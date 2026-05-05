/*    */ package net.minecraft.client.audio;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public abstract class PositionedSound implements ISound {
/*  7 */   protected float field_147662_b = 1.0F; protected final ResourceLocation field_147664_a;
/*  8 */   protected float field_147663_c = 1.0F;
/*    */   protected float field_147660_d;
/*    */   protected float field_147661_e;
/*    */   protected float field_147658_f;
/*    */   protected boolean field_147659_g = false;
/* 13 */   protected int field_147665_h = 0;
/* 14 */   protected ISound.AttenuationType field_147666_i = ISound.AttenuationType.LINEAR; private static final String __OBFID = "CL_00001116";
/*    */   
/*    */   protected PositionedSound(ResourceLocation p_i45103_1_) {
/* 17 */     this.field_147664_a = p_i45103_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation func_147650_b() {
/* 22 */     return this.field_147664_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_147657_c() {
/* 27 */     return this.field_147659_g;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_147652_d() {
/* 32 */     return this.field_147665_h;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_147653_e() {
/* 37 */     return this.field_147662_b;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_147655_f() {
/* 42 */     return this.field_147663_c;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_147649_g() {
/* 47 */     return this.field_147660_d;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_147654_h() {
/* 52 */     return this.field_147661_e;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_147651_i() {
/* 57 */     return this.field_147658_f;
/*    */   }
/*    */ 
/*    */   
/*    */   public ISound.AttenuationType func_147656_j() {
/* 62 */     return this.field_147666_i;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\PositionedSound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */