/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.model.ModelWither;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.boss.EntityWither;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderWither extends RenderLiving {
/* 12 */   private static final ResourceLocation field_110913_a = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
/* 13 */   private static final ResourceLocation field_110912_f = new ResourceLocation("textures/entity/wither/wither.png"); private int field_82419_a;
/*    */   private static final String __OBFID = "CL_00001034";
/*    */   
/*    */   public RenderWither() {
/* 17 */     super((ModelBase)new ModelWither(), 1.0F);
/* 18 */     this.field_82419_a = ((ModelWither)this.field_77045_g).func_82903_a();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76986_a(EntityWither p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 23 */     BossStatus.func_82824_a((IBossDisplayData)p_76986_1_, true);
/*    */     
/* 25 */     int i = ((ModelWither)this.field_77045_g).func_82903_a();
/* 26 */     if (i != this.field_82419_a) {
/* 27 */       this.field_82419_a = i;
/* 28 */       this.field_77045_g = (ModelBase)new ModelWither();
/*    */     } 
/* 30 */     super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityWither p_110775_1_) {
/* 35 */     int i = p_110775_1_.func_82212_n();
/* 36 */     if (i <= 0 || (i <= 80 && i / 5 % 2 == 1)) {
/* 37 */       return field_110912_f;
/*    */     }
/* 39 */     return field_110913_a;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77041_b(EntityWither p_77041_1_, float p_77041_2_) {
/* 44 */     int i = p_77041_1_.func_82212_n();
/* 45 */     if (i > 0) {
/* 46 */       float f = 2.0F - (i - p_77041_2_) / 220.0F * 0.5F;
/* 47 */       GL11.glScalef(f, f, f);
/*    */     } else {
/* 49 */       GL11.glScalef(2.0F, 2.0F, 2.0F);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_77032_a(EntityWither p_77032_1_, int p_77032_2_, float p_77032_3_) {
/* 55 */     if (p_77032_1_.func_82205_o()) {
/* 56 */       if (p_77032_1_.func_82150_aj()) {
/* 57 */         GL11.glDepthMask(false);
/*    */       } else {
/* 59 */         GL11.glDepthMask(true);
/*    */       } 
/* 61 */       if (p_77032_2_ == 1) {
/* 62 */         float f1 = p_77032_1_.field_70173_aa + p_77032_3_;
/* 63 */         func_110776_a(field_110913_a);
/* 64 */         GL11.glMatrixMode(5890);
/* 65 */         GL11.glLoadIdentity();
/* 66 */         float f2 = MathHelper.func_76134_b(f1 * 0.02F) * 3.0F;
/* 67 */         float f3 = f1 * 0.01F;
/* 68 */         GL11.glTranslatef(f2, f3, 0.0F);
/* 69 */         func_77042_a(this.field_77045_g);
/* 70 */         GL11.glMatrixMode(5888);
/* 71 */         GL11.glEnable(3042);
/* 72 */         float f4 = 0.5F;
/* 73 */         GL11.glColor4f(f4, f4, f4, 1.0F);
/* 74 */         GL11.glDisable(2896);
/* 75 */         GL11.glBlendFunc(1, 1);
/* 76 */         GL11.glTranslatef(0.0F, -0.01F, 0.0F);
/* 77 */         GL11.glScalef(1.1F, 1.1F, 1.1F);
/* 78 */         return 1;
/*    */       } 
/* 80 */       if (p_77032_2_ == 2) {
/* 81 */         GL11.glMatrixMode(5890);
/* 82 */         GL11.glLoadIdentity();
/* 83 */         GL11.glMatrixMode(5888);
/* 84 */         GL11.glEnable(2896);
/* 85 */         GL11.glDisable(3042);
/*    */       } 
/*    */     } 
/* 88 */     return -1;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_77035_b(EntityWither p_77035_1_, int p_77035_2_, float p_77035_3_) {
/* 93 */     return -1;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderWither.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */