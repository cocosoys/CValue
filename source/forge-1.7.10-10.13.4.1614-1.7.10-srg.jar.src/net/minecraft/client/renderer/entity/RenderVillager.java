/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityVillager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderVillager extends RenderLiving {
/* 10 */   private static final ResourceLocation field_110903_f = new ResourceLocation("textures/entity/villager/villager.png");
/* 11 */   private static final ResourceLocation field_110904_g = new ResourceLocation("textures/entity/villager/farmer.png");
/* 12 */   private static final ResourceLocation field_110908_h = new ResourceLocation("textures/entity/villager/librarian.png");
/* 13 */   private static final ResourceLocation field_110907_k = new ResourceLocation("textures/entity/villager/priest.png");
/* 14 */   private static final ResourceLocation field_110905_l = new ResourceLocation("textures/entity/villager/smith.png");
/* 15 */   private static final ResourceLocation field_110906_m = new ResourceLocation("textures/entity/villager/butcher.png"); protected ModelVillager field_77056_a;
/*    */   private static final String __OBFID = "CL_00001032";
/*    */   
/*    */   public RenderVillager() {
/* 19 */     super((ModelBase)new ModelVillager(0.0F), 0.5F);
/*    */     
/* 21 */     this.field_77056_a = (ModelVillager)this.field_77045_g;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected int func_77032_a(EntityVillager p_77032_1_, int p_77032_2_, float p_77032_3_) {
/* 27 */     return -1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76986_a(EntityVillager p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 32 */     super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityVillager p_110775_1_) {
/* 37 */     switch (p_110775_1_.func_70946_n()) {
/*    */       case 0:
/* 39 */         return field_110904_g;
/*    */       case 1:
/* 41 */         return field_110908_h;
/*    */       case 2:
/* 43 */         return field_110907_k;
/*    */       case 3:
/* 45 */         return field_110905_l;
/*    */       case 4:
/* 47 */         return field_110906_m;
/*    */     } 
/* 49 */     return field_110903_f;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_77029_c(EntityVillager p_77029_1_, float p_77029_2_) {
/* 55 */     super.func_77029_c((EntityLivingBase)p_77029_1_, p_77029_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77041_b(EntityVillager p_77041_1_, float p_77041_2_) {
/* 60 */     float f = 0.9375F;
/* 61 */     if (p_77041_1_.func_70874_b() < 0)
/* 62 */     { f = (float)(f * 0.5D);
/* 63 */       this.field_76989_e = 0.25F; }
/* 64 */     else { this.field_76989_e = 0.5F; }
/* 65 */      GL11.glScalef(f, f, f);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderVillager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */