/*    */ package net.minecraft.client.audio;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public abstract class MovingSound extends PositionedSound implements ITickableSound {
/*    */   protected boolean field_147668_j = false;
/*    */   
/*    */   protected MovingSound(ResourceLocation p_i45104_1_) {
/*  9 */     super(p_i45104_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001117";
/*    */   
/*    */   public boolean func_147667_k() {
/* 14 */     return this.field_147668_j;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\MovingSound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */