/*     */ package net.minecraft.client.renderer.entity;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityMinecart;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderMinecart extends Render {
/*  16 */   private static final ResourceLocation field_110804_g = new ResourceLocation("textures/entity/minecart.png");
/*  17 */   protected ModelBase field_77013_a = (ModelBase)new ModelMinecart(); protected final RenderBlocks field_94145_f;
/*     */   private static final String __OBFID = "CL_00001013";
/*     */   
/*     */   public RenderMinecart() {
/*  21 */     this.field_76989_e = 0.5F;
/*  22 */     this.field_94145_f = new RenderBlocks();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76986_a(EntityMinecart p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/*  27 */     GL11.glPushMatrix();
/*     */     
/*  29 */     func_110777_b((Entity)p_76986_1_);
/*     */     
/*  31 */     long l = p_76986_1_.func_145782_y() * 493286711L;
/*  32 */     l = l * l * 4392167121L + l * 98761L;
/*     */     
/*  34 */     float f1 = (((float)(l >> 16L & 0x7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
/*  35 */     float f2 = (((float)(l >> 20L & 0x7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
/*  36 */     float f3 = (((float)(l >> 24L & 0x7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
/*     */     
/*  38 */     GL11.glTranslatef(f1, f2, f3);
/*     */     
/*  40 */     double d1 = p_76986_1_.field_70142_S + (p_76986_1_.field_70165_t - p_76986_1_.field_70142_S) * p_76986_9_;
/*  41 */     double d2 = p_76986_1_.field_70137_T + (p_76986_1_.field_70163_u - p_76986_1_.field_70137_T) * p_76986_9_;
/*  42 */     double d3 = p_76986_1_.field_70136_U + (p_76986_1_.field_70161_v - p_76986_1_.field_70136_U) * p_76986_9_;
/*     */     
/*  44 */     double d4 = 0.30000001192092896D;
/*     */     
/*  46 */     Vec3 vec3 = p_76986_1_.func_70489_a(d1, d2, d3);
/*     */     
/*  48 */     float f4 = p_76986_1_.field_70127_C + (p_76986_1_.field_70125_A - p_76986_1_.field_70127_C) * p_76986_9_;
/*     */     
/*  50 */     if (vec3 != null) {
/*  51 */       Vec3 vec31 = p_76986_1_.func_70495_a(d1, d2, d3, d4);
/*  52 */       Vec3 vec32 = p_76986_1_.func_70495_a(d1, d2, d3, -d4);
/*  53 */       if (vec31 == null) vec31 = vec3; 
/*  54 */       if (vec32 == null) vec32 = vec3;
/*     */       
/*  56 */       p_76986_2_ += vec3.field_72450_a - d1;
/*  57 */       p_76986_4_ += (vec31.field_72448_b + vec32.field_72448_b) / 2.0D - d2;
/*  58 */       p_76986_6_ += vec3.field_72449_c - d3;
/*     */       
/*  60 */       Vec3 vec33 = vec32.func_72441_c(-vec31.field_72450_a, -vec31.field_72448_b, -vec31.field_72449_c);
/*  61 */       if (vec33.func_72433_c() != 0.0D) {
/*  62 */         vec33 = vec33.func_72432_b();
/*  63 */         p_76986_8_ = (float)(Math.atan2(vec33.field_72449_c, vec33.field_72450_a) * 180.0D / Math.PI);
/*  64 */         f4 = (float)(Math.atan(vec33.field_72448_b) * 73.0D);
/*     */       } 
/*     */     } 
/*  67 */     GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
/*     */     
/*  69 */     GL11.glRotatef(180.0F - p_76986_8_, 0.0F, 1.0F, 0.0F);
/*  70 */     GL11.glRotatef(-f4, 0.0F, 0.0F, 1.0F);
/*  71 */     float f5 = p_76986_1_.func_70496_j() - p_76986_9_;
/*  72 */     float f6 = p_76986_1_.func_70491_i() - p_76986_9_;
/*  73 */     if (f6 < 0.0F) f6 = 0.0F; 
/*  74 */     if (f5 > 0.0F) {
/*  75 */       GL11.glRotatef(MathHelper.func_76126_a(f5) * f5 * f6 / 10.0F * p_76986_1_.func_70493_k(), 1.0F, 0.0F, 0.0F);
/*     */     }
/*  77 */     int i = p_76986_1_.func_94099_q();
/*  78 */     Block block = p_76986_1_.func_145820_n();
/*  79 */     int j = p_76986_1_.func_94098_o();
/*     */     
/*  81 */     if (block.func_149645_b() != -1) {
/*  82 */       GL11.glPushMatrix();
/*     */       
/*  84 */       func_110776_a(TextureMap.field_110575_b);
/*  85 */       float f = 0.75F;
/*     */       
/*  87 */       GL11.glScalef(f, f, f);
/*  88 */       GL11.glTranslatef(0.0F, i / 16.0F, 0.0F);
/*  89 */       func_147910_a(p_76986_1_, p_76986_9_, block, j);
/*     */       
/*  91 */       GL11.glPopMatrix();
/*  92 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  93 */       func_110777_b((Entity)p_76986_1_);
/*     */     } 
/*     */     
/*  96 */     GL11.glScalef(-1.0F, -1.0F, 1.0F);
/*  97 */     this.field_77013_a.func_78088_a((Entity)p_76986_1_, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
/*  98 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   protected ResourceLocation func_110775_a(EntityMinecart p_110775_1_) {
/* 103 */     return field_110804_g;
/*     */   }
/*     */   
/*     */   protected void func_147910_a(EntityMinecart p_147910_1_, float p_147910_2_, Block p_147910_3_, int p_147910_4_) {
/* 107 */     float f = p_147910_1_.func_70013_c(p_147910_2_);
/*     */     
/* 109 */     GL11.glPushMatrix();
/* 110 */     this.field_94145_f.func_147800_a(p_147910_3_, p_147910_4_, f);
/* 111 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderMinecart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */