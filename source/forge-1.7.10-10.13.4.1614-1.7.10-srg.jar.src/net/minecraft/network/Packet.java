/*    */ package net.minecraft.network;
/*    */ 
/*    */ import com.google.common.collect.BiMap;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.io.IOException;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Packet
/*    */ {
/* 13 */   private static final Logger field_148841_a = LogManager.getLogger();
/*    */   
/*    */   public static Packet func_148839_a(BiMap p_148839_0_, int p_148839_1_) {
/*    */     try {
/* 17 */       Class<Packet> clazz = (Class)p_148839_0_.get(Integer.valueOf(p_148839_1_));
/* 18 */       if (clazz == null) return null; 
/* 19 */       return clazz.newInstance();
/* 20 */     } catch (Exception exception) {
/* 21 */       field_148841_a.error("Couldn't create packet " + p_148839_1_, exception);
/* 22 */       return null;
/*    */     } 
/*    */   }
/*    */   private static final String __OBFID = "CL_00001272";
/*    */   public static void func_148838_a(ByteBuf p_148838_0_, byte[] p_148838_1_) {
/* 27 */     p_148838_0_.writeShort(p_148838_1_.length);
/* 28 */     p_148838_0_.writeBytes(p_148838_1_);
/*    */   }
/*    */   
/*    */   public static byte[] func_148834_a(ByteBuf p_148834_0_) throws IOException {
/* 32 */     short s = p_148834_0_.readShort();
/* 33 */     if (s < 0) throw new IOException("Key was smaller than nothing!  Weird key!"); 
/* 34 */     byte[] arrayOfByte = new byte[s];
/* 35 */     p_148834_0_.readBytes(arrayOfByte);
/*    */     
/* 37 */     return arrayOfByte;
/*    */   }
/*    */   
/*    */   public abstract void func_148837_a(PacketBuffer paramPacketBuffer) throws IOException;
/*    */   
/*    */   public abstract void func_148840_b(PacketBuffer paramPacketBuffer) throws IOException;
/*    */   
/*    */   public abstract void func_148833_a(INetHandler paramINetHandler);
/*    */   
/*    */   public boolean func_148836_a() {
/* 47 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 52 */     return getClass().getSimpleName();
/*    */   }
/*    */   
/*    */   public String func_148835_b() {
/* 56 */     return "";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\Packet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */