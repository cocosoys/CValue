/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityChicken;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderChicken extends RenderLiving {
/* 10 */   private static final ResourceLocation field_110920_a = new ResourceLocation("textures/entity/chicken.png"); private static final String __OBFID = "CL_00000983";
/*    */   
/*    */   public RenderChicken(ModelBase p_i1252_1_, float p_i1252_2_) {
/* 13 */     super(p_i1252_1_, p_i1252_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76986_a(EntityChicken p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 18 */     super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityChicken p_110775_1_) {
/* 23 */     return field_110920_a;
/*    */   }
/*    */ 
/*    */   
/*    */   protected float func_77044_a(EntityChicken p_77044_1_, float p_77044_2_) {
/* 28 */     float f1 = p_77044_1_.field_70888_h + (p_77044_1_.field_70886_e - p_77044_1_.field_70888_h) * p_77044_2_;
/* 29 */     float f2 = p_77044_1_.field_70884_g + (p_77044_1_.field_70883_f - p_77044_1_.field_70884_g) * p_77044_2_;
/*    */     
/* 31 */     return (MathHelper.func_76126_a(f1) + 1.0F) * f2;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderChicken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */