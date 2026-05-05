/*     */ package net.minecraft.client.renderer.entity;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelWitch;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.monster.EntityWitch;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderWitch extends RenderLiving {
/*  15 */   private static final ResourceLocation field_110910_a = new ResourceLocation("textures/entity/witch.png"); private final ModelWitch field_82414_a;
/*     */   private static final String __OBFID = "CL_00001033";
/*     */   
/*     */   public RenderWitch() {
/*  19 */     super((ModelBase)new ModelWitch(0.0F), 0.5F);
/*     */     
/*  21 */     this.field_82414_a = (ModelWitch)this.field_77045_g;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76986_a(EntityWitch p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/*  26 */     ItemStack itemStack = p_76986_1_.func_70694_bm();
/*     */     
/*  28 */     this.field_82414_a.field_82900_g = (itemStack != null);
/*  29 */     super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected ResourceLocation func_110775_a(EntityWitch p_110775_1_) {
/*  34 */     return field_110910_a;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_77029_c(EntityWitch p_77029_1_, float p_77029_2_) {
/*  39 */     GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*     */     
/*  41 */     super.func_77029_c((EntityLivingBase)p_77029_1_, p_77029_2_);
/*     */     
/*  43 */     ItemStack itemStack = p_77029_1_.func_70694_bm();
/*     */     
/*  45 */     if (itemStack != null) {
/*  46 */       GL11.glPushMatrix();
/*     */       
/*  48 */       if (this.field_77045_g.field_78091_s) {
/*  49 */         float f = 0.5F;
/*  50 */         GL11.glTranslatef(0.0F, 0.625F, 0.0F);
/*  51 */         GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
/*  52 */         GL11.glScalef(f, f, f);
/*     */       } 
/*     */       
/*  55 */       this.field_82414_a.field_82898_f.func_78794_c(0.0625F);
/*  56 */       GL11.glTranslatef(-0.0625F, 0.53125F, 0.21875F);
/*     */       
/*  58 */       if (itemStack.func_77973_b() instanceof net.minecraft.item.ItemBlock && RenderBlocks.func_147739_a(Block.func_149634_a(itemStack.func_77973_b()).func_149645_b())) {
/*  59 */         float f = 0.5F;
/*  60 */         GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
/*  61 */         f *= 0.75F;
/*  62 */         GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
/*  63 */         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/*  64 */         GL11.glScalef(f, -f, f);
/*  65 */       } else if (itemStack.func_77973_b() == Items.field_151031_f) {
/*  66 */         float f = 0.625F;
/*  67 */         GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
/*  68 */         GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
/*  69 */         GL11.glScalef(f, -f, f);
/*  70 */         GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
/*  71 */         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/*  72 */       } else if (itemStack.func_77973_b().func_77662_d()) {
/*  73 */         float f = 0.625F;
/*  74 */         if (itemStack.func_77973_b().func_77629_n_()) {
/*  75 */           GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*  76 */           GL11.glTranslatef(0.0F, -0.125F, 0.0F);
/*     */         } 
/*  78 */         func_82410_b();
/*  79 */         GL11.glScalef(f, -f, f);
/*  80 */         GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
/*  81 */         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/*     */       } else {
/*  83 */         float f = 0.375F;
/*  84 */         GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
/*  85 */         GL11.glScalef(f, f, f);
/*  86 */         GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
/*  87 */         GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/*  88 */         GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
/*     */       } 
/*     */       
/*  91 */       GL11.glRotatef(-15.0F, 1.0F, 0.0F, 0.0F);
/*  92 */       GL11.glRotatef(40.0F, 0.0F, 0.0F, 1.0F);
/*     */       
/*  94 */       this.field_76990_c.field_78721_f.func_78443_a((EntityLivingBase)p_77029_1_, itemStack, 0);
/*  95 */       if (itemStack.func_77973_b().func_77623_v()) {
/*  96 */         this.field_76990_c.field_78721_f.func_78443_a((EntityLivingBase)p_77029_1_, itemStack, 1);
/*     */       }
/*  98 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_82410_b() {
/* 103 */     GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_77041_b(EntityWitch p_77041_1_, float p_77041_2_) {
/* 108 */     float f = 0.9375F;
/* 109 */     GL11.glScalef(f, f, f);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderWitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */