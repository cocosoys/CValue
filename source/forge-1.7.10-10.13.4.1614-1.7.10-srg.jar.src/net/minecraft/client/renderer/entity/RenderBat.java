/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.model.ModelBat;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityBat;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderBat extends RenderLiving {
/* 10 */   private static final ResourceLocation field_110835_a = new ResourceLocation("textures/entity/bat.png"); private int field_82446_a;
/*    */   private static final String __OBFID = "CL_00000979";
/*    */   
/*    */   public RenderBat() {
/* 14 */     super((ModelBase)new ModelBat(), 0.25F);
/* 15 */     this.field_82446_a = ((ModelBat)this.field_77045_g).func_82889_a();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76986_a(EntityBat p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 20 */     int i = ((ModelBat)this.field_77045_g).func_82889_a();
/* 21 */     if (i != this.field_82446_a) {
/* 22 */       this.field_82446_a = i;
/* 23 */       this.field_77045_g = (ModelBase)new ModelBat();
/*    */     } 
/* 25 */     super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityBat p_110775_1_) {
/* 30 */     return field_110835_a;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77041_b(EntityBat p_77041_1_, float p_77041_2_) {
/* 35 */     GL11.glScalef(0.35F, 0.35F, 0.35F);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77039_a(EntityBat p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
/* 40 */     super.func_77039_a((EntityLivingBase)p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77043_a(EntityBat p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
/* 45 */     if (!p_77043_1_.func_82235_h()) {
/* 46 */       GL11.glTranslatef(0.0F, MathHelper.func_76134_b(p_77043_2_ * 0.3F) * 0.1F, 0.0F);
/*    */     } else {
/* 48 */       GL11.glTranslatef(0.0F, -0.1F, 0.0F);
/*    */     } 
/* 50 */     super.func_77043_a((EntityLivingBase)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderBat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */