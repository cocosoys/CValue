/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.monster.EntityCreeper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderCreeper extends RenderLiving {
/* 10 */   private static final ResourceLocation field_110831_a = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
/* 11 */   private static final ResourceLocation field_110830_f = new ResourceLocation("textures/entity/creeper/creeper.png");
/*    */   
/* 13 */   private ModelBase field_77064_a = (ModelBase)new ModelCreeper(2.0F); private static final String __OBFID = "CL_00000985";
/*    */   
/*    */   public RenderCreeper() {
/* 16 */     super((ModelBase)new ModelCreeper(), 0.5F);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77041_b(EntityCreeper p_77041_1_, float p_77041_2_) {
/* 21 */     float f1 = p_77041_1_.func_70831_j(p_77041_2_);
/*    */     
/* 23 */     float f2 = 1.0F + MathHelper.func_76126_a(f1 * 100.0F) * f1 * 0.01F;
/* 24 */     if (f1 < 0.0F) f1 = 0.0F; 
/* 25 */     if (f1 > 1.0F) f1 = 1.0F; 
/* 26 */     f1 *= f1;
/* 27 */     f1 *= f1;
/* 28 */     float f3 = (1.0F + f1 * 0.4F) * f2;
/* 29 */     float f4 = (1.0F + f1 * 0.1F) / f2;
/* 30 */     GL11.glScalef(f3, f4, f3);
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_77030_a(EntityCreeper p_77030_1_, float p_77030_2_, float p_77030_3_) {
/* 35 */     float f = p_77030_1_.func_70831_j(p_77030_3_);
/*    */     
/* 37 */     if ((int)(f * 10.0F) % 2 == 0) return 0;
/*    */     
/* 39 */     int i = (int)(f * 0.2F * 255.0F);
/* 40 */     if (i < 0) i = 0; 
/* 41 */     if (i > 255) i = 255;
/*    */     
/* 43 */     char c1 = 'ÿ';
/* 44 */     char c2 = 'ÿ';
/* 45 */     char c3 = 'ÿ';
/*    */     
/* 47 */     return i << 24 | c1 << 16 | c2 << 8 | c3;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_77032_a(EntityCreeper p_77032_1_, int p_77032_2_, float p_77032_3_) {
/* 52 */     if (p_77032_1_.func_70830_n()) {
/* 53 */       if (p_77032_1_.func_82150_aj()) {
/* 54 */         GL11.glDepthMask(false);
/*    */       } else {
/* 56 */         GL11.glDepthMask(true);
/*    */       } 
/* 58 */       if (p_77032_2_ == 1) {
/* 59 */         float f1 = p_77032_1_.field_70173_aa + p_77032_3_;
/* 60 */         func_110776_a(field_110831_a);
/* 61 */         GL11.glMatrixMode(5890);
/* 62 */         GL11.glLoadIdentity();
/* 63 */         float f2 = f1 * 0.01F;
/* 64 */         float f3 = f1 * 0.01F;
/* 65 */         GL11.glTranslatef(f2, f3, 0.0F);
/* 66 */         func_77042_a(this.field_77064_a);
/* 67 */         GL11.glMatrixMode(5888);
/* 68 */         GL11.glEnable(3042);
/* 69 */         float f4 = 0.5F;
/* 70 */         GL11.glColor4f(f4, f4, f4, 1.0F);
/* 71 */         GL11.glDisable(2896);
/* 72 */         GL11.glBlendFunc(1, 1);
/* 73 */         return 1;
/*    */       } 
/* 75 */       if (p_77032_2_ == 2) {
/* 76 */         GL11.glMatrixMode(5890);
/* 77 */         GL11.glLoadIdentity();
/* 78 */         GL11.glMatrixMode(5888);
/* 79 */         GL11.glEnable(2896);
/* 80 */         GL11.glDisable(3042);
/*    */       } 
/*    */     } 
/* 83 */     return -1;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_77035_b(EntityCreeper p_77035_1_, int p_77035_2_, float p_77035_3_) {
/* 88 */     return -1;
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityCreeper p_110775_1_) {
/* 93 */     return field_110830_f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderCreeper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */