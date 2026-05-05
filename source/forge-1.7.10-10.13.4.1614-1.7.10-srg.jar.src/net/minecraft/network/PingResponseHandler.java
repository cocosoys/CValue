/*     */ package net.minecraft.network;
/*     */ 
/*     */ import com.google.common.base.Charsets;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.buffer.Unpooled;
/*     */ import io.netty.channel.ChannelFutureListener;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import io.netty.channel.ChannelInboundHandlerAdapter;
/*     */ import io.netty.util.concurrent.GenericFutureListener;
/*     */ import java.net.InetSocketAddress;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class PingResponseHandler extends ChannelInboundHandlerAdapter {
/*  16 */   private static final Logger field_151258_a = LogManager.getLogger();
/*     */   
/*     */   private NetworkSystem field_151257_b;
/*     */   private static final String __OBFID = "CL_00001444";
/*     */   
/*     */   public PingResponseHandler(NetworkSystem p_i45286_1_) {
/*  22 */     this.field_151257_b = p_i45286_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void channelRead(ChannelHandlerContext p_channelRead_1_, Object p_channelRead_2_) {
/*  27 */     ByteBuf byteBuf = (ByteBuf)p_channelRead_2_;
/*     */     
/*  29 */     byteBuf.markReaderIndex();
/*     */     
/*  31 */     boolean bool = true; 
/*     */     try { String str1; int k; boolean bool1; int j, m; String str2; ByteBuf byteBuf1;
/*  33 */       if (byteBuf.readUnsignedByte() != 254) {
/*     */         return;
/*     */       }
/*     */       
/*  37 */       InetSocketAddress inetSocketAddress = (InetSocketAddress)p_channelRead_1_.channel().remoteAddress();
/*  38 */       MinecraftServer minecraftServer = this.field_151257_b.func_151267_d();
/*     */       
/*  40 */       int i = byteBuf.readableBytes();
/*  41 */       switch (i) {
/*     */         case 0:
/*  43 */           field_151258_a.debug("Ping: (<1.3.x) from {}:{}", new Object[] { inetSocketAddress.getAddress(), Integer.valueOf(inetSocketAddress.getPort()) });
/*     */           
/*  45 */           str1 = String.format("%s§%d§%d", new Object[] { minecraftServer.func_71273_Y(), Integer.valueOf(minecraftServer.func_71233_x()), Integer.valueOf(minecraftServer.func_71275_y()) });
/*  46 */           func_151256_a(p_channelRead_1_, func_151255_a(str1));
/*     */           break;
/*     */ 
/*     */         
/*     */         case 1:
/*  51 */           if (byteBuf.readUnsignedByte() != 1) {
/*     */             return;
/*     */           }
/*     */           
/*  55 */           field_151258_a.debug("Ping: (1.4-1.5.x) from {}:{}", new Object[] { inetSocketAddress.getAddress(), Integer.valueOf(inetSocketAddress.getPort()) });
/*     */           
/*  57 */           str1 = String.format("§1\000%d\000%s\000%s\000%d\000%d", new Object[] { Integer.valueOf(127), minecraftServer.func_71249_w(), minecraftServer.func_71273_Y(), Integer.valueOf(minecraftServer.func_71233_x()), Integer.valueOf(minecraftServer.func_71275_y()) });
/*  58 */           func_151256_a(p_channelRead_1_, func_151255_a(str1));
/*     */           break;
/*     */ 
/*     */         
/*     */         default:
/*  63 */           k = (byteBuf.readUnsignedByte() == 1) ? 1 : 0;
/*  64 */           k &= (byteBuf.readUnsignedByte() == 250) ? 1 : 0;
/*  65 */           bool1 = k & "MC|PingHost".equals(new String(byteBuf.readBytes(byteBuf.readShort() * 2).array(), Charsets.UTF_16BE));
/*  66 */           m = byteBuf.readUnsignedShort();
/*  67 */           j = bool1 & ((byteBuf.readUnsignedByte() >= 73) ? 1 : 0);
/*  68 */           j &= (3 + (byteBuf.readBytes(byteBuf.readShort() * 2).array()).length + 4 == m) ? 1 : 0;
/*  69 */           j &= (byteBuf.readInt() <= 65535) ? 1 : 0;
/*  70 */           j &= (byteBuf.readableBytes() == 0) ? 1 : 0;
/*     */           
/*  72 */           if (j == 0) {
/*     */             return;
/*     */           }
/*     */           
/*  76 */           field_151258_a.debug("Ping: (1.6) from {}:{}", new Object[] { inetSocketAddress.getAddress(), Integer.valueOf(inetSocketAddress.getPort()) });
/*     */           
/*  78 */           str2 = String.format("§1\000%d\000%s\000%s\000%d\000%d", new Object[] { Integer.valueOf(127), minecraftServer.func_71249_w(), minecraftServer.func_71273_Y(), Integer.valueOf(minecraftServer.func_71233_x()), Integer.valueOf(minecraftServer.func_71275_y()) });
/*  79 */           byteBuf1 = func_151255_a(str2);
/*     */           try {
/*  81 */             func_151256_a(p_channelRead_1_, byteBuf1);
/*     */           } finally {
/*  83 */             byteBuf1.release();
/*     */           } 
/*     */           break;
/*     */       } 
/*  87 */       byteBuf.release();
/*  88 */       bool = false; }
/*  89 */     catch (RuntimeException runtimeException) {  }
/*     */     finally
/*  91 */     { if (bool) {
/*  92 */         byteBuf.resetReaderIndex();
/*  93 */         p_channelRead_1_.channel().pipeline().remove("legacy_query");
/*  94 */         p_channelRead_1_.fireChannelRead(p_channelRead_2_);
/*     */       }  }
/*     */   
/*     */   }
/*     */   
/*     */   private void func_151256_a(ChannelHandlerContext p_151256_1_, ByteBuf p_151256_2_) {
/* 100 */     p_151256_1_.pipeline().firstContext().writeAndFlush(p_151256_2_).addListener((GenericFutureListener)ChannelFutureListener.CLOSE);
/*     */   }
/*     */   
/*     */   private ByteBuf func_151255_a(String p_151255_1_) {
/* 104 */     ByteBuf byteBuf = Unpooled.buffer();
/* 105 */     byteBuf.writeByte(255);
/*     */     
/* 107 */     char[] arrayOfChar = p_151255_1_.toCharArray();
/* 108 */     byteBuf.writeShort(arrayOfChar.length);
/* 109 */     for (char c : arrayOfChar) {
/* 110 */       byteBuf.writeChar(c);
/*     */     }
/*     */     
/* 113 */     return byteBuf;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\PingResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */