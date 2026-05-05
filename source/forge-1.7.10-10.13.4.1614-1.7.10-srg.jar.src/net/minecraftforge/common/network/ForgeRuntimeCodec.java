/*    */ package net.minecraftforge.common.network;
/*    */ 
/*    */ import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ 
/*    */ public class ForgeRuntimeCodec
/*    */   extends FMLIndexedMessageToMessageCodec<ForgeMessage> {
/*    */   public ForgeRuntimeCodec() {
/* 10 */     addDiscriminator(1, ForgeMessage.DimensionRegisterMessage.class);
/* 11 */     addDiscriminator(2, ForgeMessage.FluidIdMapMessage.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public void encodeInto(ChannelHandlerContext ctx, ForgeMessage msg, ByteBuf target) throws Exception {
/* 16 */     msg.toBytes(target);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void decodeInto(ChannelHandlerContext ctx, ByteBuf source, ForgeMessage msg) {
/* 22 */     msg.fromBytes(source);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\network\ForgeRuntimeCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */