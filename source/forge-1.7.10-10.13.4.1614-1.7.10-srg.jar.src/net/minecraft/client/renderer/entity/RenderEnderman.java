/*     */ package net.minecraft.client.renderer.entity;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelEnderman;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.monster.EntityEnderman;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderEnderman extends RenderLiving {
/*  16 */   private static final ResourceLocation field_110840_a = new ResourceLocation("textures/entity/enderman/enderman_eyes.png");
/*  17 */   private static final ResourceLocation field_110839_f = new ResourceLocation("textures/entity/enderman/enderman.png");
/*     */   private ModelEnderman field_77078_a;
/*  19 */   private Random field_77077_b = new Random(); private static final String __OBFID = "CL_00000989";
/*     */   
/*     */   public RenderEnderman() {
/*  22 */     super((ModelBase)new ModelEnderman(), 0.5F);
/*  23 */     this.field_77078_a = (ModelEnderman)this.field_77045_g;
/*  24 */     func_77042_a((ModelBase)this.field_77078_a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76986_a(EntityEnderman p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/*  30 */     this.field_77078_a.field_78126_a = (p_76986_1_.func_146080_bZ().func_149688_o() != Material.field_151579_a);
/*  31 */     this.field_77078_a.field_78125_b = p_76986_1_.func_70823_r();
/*     */     
/*  33 */     if (p_76986_1_.func_70823_r()) {
/*  34 */       double d = 0.02D;
/*  35 */       p_76986_2_ += this.field_77077_b.nextGaussian() * d;
/*  36 */       p_76986_6_ += this.field_77077_b.nextGaussian() * d;
/*     */     } 
/*     */     
/*  39 */     super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected ResourceLocation func_110775_a(EntityEnderman p_110775_1_) {
/*  44 */     return field_110839_f;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_77029_c(EntityEnderman p_77029_1_, float p_77029_2_) {
/*  49 */     super.func_77029_c((EntityLivingBase)p_77029_1_, p_77029_2_);
/*     */     
/*  51 */     if (p_77029_1_.func_146080_bZ().func_149688_o() != Material.field_151579_a) {
/*  52 */       GL11.glEnable(32826);
/*  53 */       GL11.glPushMatrix();
/*     */       
/*  55 */       float f = 0.5F;
/*  56 */       GL11.glTranslatef(0.0F, 0.6875F, -0.75F);
/*  57 */       f *= 1.0F;
/*  58 */       GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
/*  59 */       GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/*  60 */       GL11.glScalef(-f, -f, f);
/*     */       
/*  62 */       int i = p_77029_1_.func_70070_b(p_77029_2_);
/*  63 */       int j = i % 65536;
/*  64 */       int k = i / 65536;
/*     */       
/*  66 */       OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, j / 1.0F, k / 1.0F);
/*     */       
/*  68 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  69 */       func_110776_a(TextureMap.field_110575_b);
/*  70 */       this.field_147909_c.func_147800_a(p_77029_1_.func_146080_bZ(), p_77029_1_.func_70824_q(), 1.0F);
/*  71 */       GL11.glPopMatrix();
/*  72 */       GL11.glDisable(32826);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_77032_a(EntityEnderman p_77032_1_, int p_77032_2_, float p_77032_3_) {
/*  78 */     if (p_77032_2_ != 0) return -1;
/*     */     
/*  80 */     func_110776_a(field_110840_a);
/*  81 */     float f = 1.0F;
/*  82 */     GL11.glEnable(3042);
/*  83 */     GL11.glDisable(3008);
/*  84 */     GL11.glBlendFunc(1, 1);
/*  85 */     GL11.glDisable(2896);
/*  86 */     if (p_77032_1_.func_82150_aj()) {
/*  87 */       GL11.glDepthMask(false);
/*     */     } else {
/*  89 */       GL11.glDepthMask(true);
/*     */     } 
/*     */     
/*  92 */     char c = '';
/*  93 */     int i = c % 65536;
/*  94 */     int j = c / 65536;
/*     */     
/*  96 */     OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, i / 1.0F, j / 1.0F);
/*     */     
/*  98 */     GL11.glEnable(2896);
/*  99 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
/* 100 */     return 1;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderEnderman.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */