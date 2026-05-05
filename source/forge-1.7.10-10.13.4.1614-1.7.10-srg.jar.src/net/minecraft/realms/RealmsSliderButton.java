/*    */ package net.minecraft.realms;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RealmsSliderButton extends RealmsButton {
/*  9 */   public float value = 1.0F; public boolean sliding;
/*    */   private final float minValue;
/*    */   private final float maxValue;
/*    */   private int steps;
/*    */   private static final String __OBFID = "CL_00001834";
/*    */   
/*    */   public RealmsSliderButton(int p_i1056_1_, int p_i1056_2_, int p_i1056_3_, int p_i1056_4_, int p_i1056_5_, int p_i1056_6_) {
/* 16 */     this(p_i1056_1_, p_i1056_2_, p_i1056_3_, p_i1056_4_, p_i1056_6_, 0, 1.0F, p_i1056_5_);
/*    */   }
/*    */   
/*    */   public RealmsSliderButton(int p_i1057_1_, int p_i1057_2_, int p_i1057_3_, int p_i1057_4_, int p_i1057_5_, int p_i1057_6_, float p_i1057_7_, float p_i1057_8_) {
/* 20 */     super(p_i1057_1_, p_i1057_2_, p_i1057_3_, p_i1057_4_, 20, "");
/* 21 */     this.minValue = p_i1057_7_;
/* 22 */     this.maxValue = p_i1057_8_;
/*    */     
/* 24 */     this.value = toPct(p_i1057_6_);
/* 25 */     (getProxy()).field_146126_j = getMessage();
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 29 */     return "";
/*    */   }
/*    */   
/*    */   public float toPct(float p_toPct_1_) {
/* 33 */     return MathHelper.func_76131_a((clamp(p_toPct_1_) - this.minValue) / (this.maxValue - this.minValue), 0.0F, 1.0F);
/*    */   }
/*    */   
/*    */   public float toValue(float p_toValue_1_) {
/* 37 */     return clamp(this.minValue + (this.maxValue - this.minValue) * MathHelper.func_76131_a(p_toValue_1_, 0.0F, 1.0F));
/*    */   }
/*    */   
/*    */   public float clamp(float p_clamp_1_) {
/* 41 */     p_clamp_1_ = clampSteps(p_clamp_1_);
/* 42 */     return MathHelper.func_76131_a(p_clamp_1_, this.minValue, this.maxValue);
/*    */   }
/*    */   
/*    */   protected float clampSteps(float p_clampSteps_1_) {
/* 46 */     if (this.steps > 0) {
/* 47 */       p_clampSteps_1_ = (this.steps * Math.round(p_clampSteps_1_ / this.steps));
/*    */     }
/* 49 */     return p_clampSteps_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getYImage(boolean p_getYImage_1_) {
/* 54 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderBg(int p_renderBg_1_, int p_renderBg_2_) {
/* 59 */     if (!(getProxy()).field_146125_m)
/*    */       return; 
/* 61 */     if (this.sliding) {
/* 62 */       this.value = (p_renderBg_1_ - (getProxy()).field_146128_h + 4) / (getProxy().func_146117_b() - 8);
/* 63 */       if (this.value < 0.0F) this.value = 0.0F; 
/* 64 */       if (this.value > 1.0F) this.value = 1.0F; 
/* 65 */       float f = toValue(this.value);
/* 66 */       clicked(f);
/* 67 */       this.value = toPct(f);
/* 68 */       (getProxy()).field_146126_j = getMessage();
/*    */     } 
/*    */     
/* 71 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 72 */     blit((getProxy()).field_146128_h + (int)(this.value * (getProxy().func_146117_b() - 8)), (getProxy()).field_146129_i, 0, 66, 4, 20);
/* 73 */     blit((getProxy()).field_146128_h + (int)(this.value * (getProxy().func_146117_b() - 8)) + 4, (getProxy()).field_146129_i, 196, 66, 4, 20);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clicked(int p_clicked_1_, int p_clicked_2_) {
/* 78 */     this.value = (p_clicked_1_ - (getProxy()).field_146128_h + 4) / (getProxy().func_146117_b() - 8);
/* 79 */     if (this.value < 0.0F) this.value = 0.0F; 
/* 80 */     if (this.value > 1.0F) this.value = 1.0F; 
/* 81 */     clicked(toValue(this.value));
/* 82 */     (getProxy()).field_146126_j = getMessage();
/* 83 */     this.sliding = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void clicked(float p_clicked_1_) {}
/*    */ 
/*    */   
/*    */   public void released(int p_released_1_, int p_released_2_) {
/* 92 */     this.sliding = false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\realms\RealmsSliderButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */