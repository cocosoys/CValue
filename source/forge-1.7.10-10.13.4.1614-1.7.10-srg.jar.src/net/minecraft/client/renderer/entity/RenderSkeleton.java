/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.monster.EntitySkeleton;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderSkeleton extends RenderBiped {
/* 10 */   private static final ResourceLocation field_110862_k = new ResourceLocation("textures/entity/skeleton/skeleton.png");
/* 11 */   private static final ResourceLocation field_110861_l = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png"); private static final String __OBFID = "CL_00001023";
/*    */   
/*    */   public RenderSkeleton() {
/* 14 */     super((ModelBiped)new ModelSkeleton(), 0.5F);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77041_b(EntitySkeleton p_77041_1_, float p_77041_2_) {
/* 19 */     if (p_77041_1_.func_82202_m() == 1) {
/* 20 */       GL11.glScalef(1.2F, 1.2F, 1.2F);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_82422_c() {
/* 26 */     GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntitySkeleton p_110775_1_) {
/* 31 */     if (p_110775_1_.func_82202_m() == 1) {
/* 32 */       return field_110861_l;
/*    */     }
/* 34 */     return field_110862_k;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderSkeleton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */