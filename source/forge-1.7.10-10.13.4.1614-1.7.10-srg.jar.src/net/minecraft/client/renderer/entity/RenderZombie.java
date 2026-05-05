/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.monster.EntityZombie;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderZombie extends RenderBiped {
/*  9 */   private static final ResourceLocation field_110866_o = new ResourceLocation("textures/entity/zombie_pigman.png");
/* 10 */   private static final ResourceLocation field_110865_p = new ResourceLocation("textures/entity/zombie/zombie.png");
/* 11 */   private static final ResourceLocation field_110864_q = new ResourceLocation("textures/entity/zombie/zombie_villager.png");
/*    */   
/*    */   private ModelBiped field_82434_o;
/*    */   
/*    */   private ModelZombieVillager field_82432_p;
/*    */   protected ModelBiped field_82437_k;
/*    */   protected ModelBiped field_82435_l;
/*    */   protected ModelBiped field_82436_m;
/*    */   protected ModelBiped field_82433_n;
/* 20 */   private int field_82431_q = 1; private static final String __OBFID = "CL_00001037";
/*    */   
/*    */   public RenderZombie() {
/* 23 */     super((ModelBiped)new ModelZombie(), 0.5F, 1.0F);
/* 24 */     this.field_82434_o = this.field_77071_a;
/* 25 */     this.field_82432_p = new ModelZombieVillager();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_82421_b() {
/* 30 */     this.field_82423_g = (ModelBiped)new ModelZombie(1.0F, true);
/* 31 */     this.field_82425_h = (ModelBiped)new ModelZombie(0.5F, true);
/*    */     
/* 33 */     this.field_82437_k = this.field_82423_g;
/* 34 */     this.field_82435_l = this.field_82425_h;
/*    */     
/* 36 */     this.field_82436_m = (ModelBiped)new ModelZombieVillager(1.0F, 0.0F, true);
/* 37 */     this.field_82433_n = (ModelBiped)new ModelZombieVillager(0.5F, 0.0F, true);
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_77032_a(EntityZombie p_77032_1_, int p_77032_2_, float p_77032_3_) {
/* 42 */     func_82427_a(p_77032_1_);
/* 43 */     return super.func_77032_a((EntityLiving)p_77032_1_, p_77032_2_, p_77032_3_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76986_a(EntityZombie p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 48 */     func_82427_a(p_76986_1_);
/* 49 */     super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityZombie p_110775_1_) {
/* 55 */     if (p_110775_1_ instanceof net.minecraft.entity.monster.EntityPigZombie) {
/* 56 */       return field_110866_o;
/*    */     }
/*    */     
/* 59 */     if (p_110775_1_.func_82231_m()) {
/* 60 */       return field_110864_q;
/*    */     }
/* 62 */     return field_110865_p;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77029_c(EntityZombie p_77029_1_, float p_77029_2_) {
/* 67 */     func_82427_a(p_77029_1_);
/* 68 */     super.func_77029_c((EntityLiving)p_77029_1_, p_77029_2_);
/*    */   }
/*    */   
/*    */   private void func_82427_a(EntityZombie p_82427_1_) {
/* 72 */     if (p_82427_1_.func_82231_m()) {
/* 73 */       if (this.field_82431_q != this.field_82432_p.func_82897_a()) {
/* 74 */         this.field_82432_p = new ModelZombieVillager();
/* 75 */         this.field_82431_q = this.field_82432_p.func_82897_a();
/* 76 */         this.field_82436_m = (ModelBiped)new ModelZombieVillager(1.0F, 0.0F, true);
/* 77 */         this.field_82433_n = (ModelBiped)new ModelZombieVillager(0.5F, 0.0F, true);
/*    */       } 
/* 79 */       this.field_77045_g = (ModelBase)this.field_82432_p;
/* 80 */       this.field_82423_g = this.field_82436_m;
/* 81 */       this.field_82425_h = this.field_82433_n;
/*    */     } else {
/* 83 */       this.field_77045_g = (ModelBase)this.field_82434_o;
/* 84 */       this.field_82423_g = this.field_82437_k;
/* 85 */       this.field_82425_h = this.field_82435_l;
/*    */     } 
/*    */     
/* 88 */     this.field_77071_a = (ModelBiped)this.field_77045_g;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77043_a(EntityZombie p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
/* 93 */     if (p_77043_1_.func_82230_o()) {
/* 94 */       p_77043_3_ += (float)(Math.cos(p_77043_1_.field_70173_aa * 3.25D) * Math.PI * 0.25D);
/*    */     }
/* 96 */     super.func_77043_a((EntityLivingBase)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderZombie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */