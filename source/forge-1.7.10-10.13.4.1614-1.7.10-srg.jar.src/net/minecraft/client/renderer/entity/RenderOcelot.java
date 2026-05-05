/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityOcelot;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderOcelot extends RenderLiving {
/* 10 */   private static final ResourceLocation field_110877_a = new ResourceLocation("textures/entity/cat/black.png");
/* 11 */   private static final ResourceLocation field_110875_f = new ResourceLocation("textures/entity/cat/ocelot.png");
/* 12 */   private static final ResourceLocation field_110876_g = new ResourceLocation("textures/entity/cat/red.png");
/* 13 */   private static final ResourceLocation field_110878_h = new ResourceLocation("textures/entity/cat/siamese.png"); private static final String __OBFID = "CL_00001017";
/*    */   
/*    */   public RenderOcelot(ModelBase p_i1264_1_, float p_i1264_2_) {
/* 16 */     super(p_i1264_1_, p_i1264_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76986_a(EntityOcelot p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 21 */     super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityOcelot p_110775_1_) {
/* 26 */     switch (p_110775_1_.func_70913_u())
/*    */     
/*    */     { default:
/* 29 */         return field_110875_f;
/*    */       case 1:
/* 31 */         return field_110877_a;
/*    */       case 2:
/* 33 */         return field_110876_g;
/*    */       case 3:
/* 35 */         break; }  return field_110878_h;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_77041_b(EntityOcelot p_77041_1_, float p_77041_2_) {
/* 41 */     super.func_77041_b((EntityLivingBase)p_77041_1_, p_77041_2_);
/* 42 */     if (p_77041_1_.func_70909_n())
/* 43 */       GL11.glScalef(0.8F, 0.8F, 0.8F); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderOcelot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */