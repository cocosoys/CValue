/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.monster.EntityCaveSpider;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderCaveSpider extends RenderSpider {
/*  8 */   private static final ResourceLocation field_110893_a = new ResourceLocation("textures/entity/spider/cave_spider.png");
/*    */   private static final String __OBFID = "CL_00000982";
/*    */   
/*    */   public RenderCaveSpider() {
/* 12 */     this.field_76989_e *= 0.7F;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77041_b(EntityCaveSpider p_77041_1_, float p_77041_2_) {
/* 17 */     GL11.glScalef(0.7F, 0.7F, 0.7F);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityCaveSpider p_110775_1_) {
/* 22 */     return field_110893_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderCaveSpider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */