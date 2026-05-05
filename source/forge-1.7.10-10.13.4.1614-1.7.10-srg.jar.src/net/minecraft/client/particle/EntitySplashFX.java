/*    */ package net.minecraft.client.particle;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntitySplashFX extends EntityRainFX {
/*    */   public EntitySplashFX(World p_i1230_1_, double p_i1230_2_, double p_i1230_4_, double p_i1230_6_, double p_i1230_8_, double p_i1230_10_, double p_i1230_12_) {
/*  7 */     super(p_i1230_1_, p_i1230_2_, p_i1230_4_, p_i1230_6_);
/*  8 */     this.field_70545_g = 0.04F;
/*  9 */     func_94053_h();
/* 10 */     if (p_i1230_10_ == 0.0D && (p_i1230_8_ != 0.0D || p_i1230_12_ != 0.0D)) {
/* 11 */       this.field_70159_w = p_i1230_8_;
/* 12 */       this.field_70181_x = p_i1230_10_ + 0.1D;
/* 13 */       this.field_70179_y = p_i1230_12_;
/*    */     } 
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000927";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntitySplashFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */