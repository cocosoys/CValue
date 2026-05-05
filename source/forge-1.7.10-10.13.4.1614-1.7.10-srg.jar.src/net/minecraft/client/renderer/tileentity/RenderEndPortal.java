/*     */ package net.minecraft.client.renderer.tileentity;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ActiveRenderInfo;
/*     */ import net.minecraft.client.renderer.GLAllocation;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityEndPortal;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderEndPortal extends TileEntitySpecialRenderer {
/*  17 */   private static final ResourceLocation field_147529_c = new ResourceLocation("textures/environment/end_sky.png");
/*  18 */   private static final ResourceLocation field_147526_d = new ResourceLocation("textures/entity/end_portal.png");
/*     */   
/*  20 */   private static final Random field_147527_e = new Random(31100L);
/*     */ 
/*     */   
/*     */   public void func_147500_a(TileEntityEndPortal p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
/*  24 */     float f1 = (float)this.field_147501_a.field_147560_j;
/*  25 */     float f2 = (float)this.field_147501_a.field_147561_k;
/*  26 */     float f3 = (float)this.field_147501_a.field_147558_l;
/*     */     
/*  28 */     GL11.glDisable(2896);
/*     */     
/*  30 */     field_147527_e.setSeed(31100L);
/*     */     
/*  32 */     float f4 = 0.75F;
/*  33 */     for (byte b = 0; b < 16; b++) {
/*  34 */       GL11.glPushMatrix();
/*     */       
/*  36 */       float f5 = (16 - b);
/*  37 */       float f6 = 0.0625F;
/*     */       
/*  39 */       float f7 = 1.0F / (f5 + 1.0F);
/*  40 */       if (b == 0) {
/*  41 */         func_147499_a(field_147529_c);
/*  42 */         f7 = 0.1F;
/*  43 */         f5 = 65.0F;
/*  44 */         f6 = 0.125F;
/*  45 */         GL11.glEnable(3042);
/*  46 */         GL11.glBlendFunc(770, 771);
/*     */       } 
/*  48 */       if (b == 1) {
/*  49 */         func_147499_a(field_147526_d);
/*  50 */         GL11.glEnable(3042);
/*  51 */         GL11.glBlendFunc(1, 1);
/*  52 */         f6 = 0.5F;
/*     */       } 
/*     */       
/*  55 */       float f8 = (float)-(p_147500_4_ + f4);
/*     */       
/*  57 */       float f9 = f8 + ActiveRenderInfo.field_74590_b;
/*  58 */       float f10 = f8 + f5 + ActiveRenderInfo.field_74590_b;
/*  59 */       float f11 = f9 / f10;
/*  60 */       f11 = (float)(p_147500_4_ + f4) + f11;
/*     */       
/*  62 */       GL11.glTranslatef(f1, f11, f3);
/*     */       
/*  64 */       GL11.glTexGeni(8192, 9472, 9217);
/*  65 */       GL11.glTexGeni(8193, 9472, 9217);
/*  66 */       GL11.glTexGeni(8194, 9472, 9217);
/*  67 */       GL11.glTexGeni(8195, 9472, 9216);
/*  68 */       GL11.glTexGen(8192, 9473, func_147525_a(1.0F, 0.0F, 0.0F, 0.0F));
/*  69 */       GL11.glTexGen(8193, 9473, func_147525_a(0.0F, 0.0F, 1.0F, 0.0F));
/*  70 */       GL11.glTexGen(8194, 9473, func_147525_a(0.0F, 0.0F, 0.0F, 1.0F));
/*  71 */       GL11.glTexGen(8195, 9474, func_147525_a(0.0F, 1.0F, 0.0F, 0.0F));
/*  72 */       GL11.glEnable(3168);
/*  73 */       GL11.glEnable(3169);
/*  74 */       GL11.glEnable(3170);
/*  75 */       GL11.glEnable(3171);
/*     */       
/*  77 */       GL11.glPopMatrix();
/*  78 */       GL11.glMatrixMode(5890);
/*     */       
/*  80 */       GL11.glPushMatrix();
/*  81 */       GL11.glLoadIdentity();
/*     */       
/*  83 */       GL11.glTranslatef(0.0F, (float)(Minecraft.func_71386_F() % 700000L) / 700000.0F, 0.0F);
/*  84 */       GL11.glScalef(f6, f6, f6);
/*  85 */       GL11.glTranslatef(0.5F, 0.5F, 0.0F);
/*  86 */       GL11.glRotatef((b * b * 4321 + b * 9) * 2.0F, 0.0F, 0.0F, 1.0F);
/*  87 */       GL11.glTranslatef(-0.5F, -0.5F, 0.0F);
/*  88 */       GL11.glTranslatef(-f1, -f3, -f2);
/*  89 */       f9 = f8 + ActiveRenderInfo.field_74590_b;
/*  90 */       GL11.glTranslatef(ActiveRenderInfo.field_74592_a * f5 / f9, ActiveRenderInfo.field_74591_c * f5 / f9, -f2);
/*     */       
/*  92 */       Tessellator tessellator = Tessellator.field_78398_a;
/*  93 */       tessellator.func_78382_b();
/*     */       
/*  95 */       f11 = field_147527_e.nextFloat() * 0.5F + 0.1F;
/*  96 */       float f12 = field_147527_e.nextFloat() * 0.5F + 0.4F;
/*  97 */       float f13 = field_147527_e.nextFloat() * 0.5F + 0.5F;
/*  98 */       if (b == 0) f11 = f12 = f13 = 1.0F; 
/*  99 */       tessellator.func_78369_a(f11 * f7, f12 * f7, f13 * f7, 1.0F);
/* 100 */       tessellator.func_78377_a(p_147500_2_, p_147500_4_ + f4, p_147500_6_);
/* 101 */       tessellator.func_78377_a(p_147500_2_, p_147500_4_ + f4, p_147500_6_ + 1.0D);
/* 102 */       tessellator.func_78377_a(p_147500_2_ + 1.0D, p_147500_4_ + f4, p_147500_6_ + 1.0D);
/* 103 */       tessellator.func_78377_a(p_147500_2_ + 1.0D, p_147500_4_ + f4, p_147500_6_);
/* 104 */       tessellator.func_78381_a();
/*     */       
/* 106 */       GL11.glPopMatrix();
/* 107 */       GL11.glMatrixMode(5888);
/*     */     } 
/* 109 */     GL11.glDisable(3042);
/*     */     
/* 111 */     GL11.glDisable(3168);
/* 112 */     GL11.glDisable(3169);
/* 113 */     GL11.glDisable(3170);
/* 114 */     GL11.glDisable(3171);
/* 115 */     GL11.glEnable(2896);
/*     */   }
/*     */   
/* 118 */   FloatBuffer field_147528_b = GLAllocation.func_74529_h(16); private static final String __OBFID = "CL_00000972";
/*     */   
/*     */   private FloatBuffer func_147525_a(float p_147525_1_, float p_147525_2_, float p_147525_3_, float p_147525_4_) {
/* 121 */     this.field_147528_b.clear();
/* 122 */     this.field_147528_b.put(p_147525_1_).put(p_147525_2_).put(p_147525_3_).put(p_147525_4_);
/* 123 */     this.field_147528_b.flip();
/* 124 */     return this.field_147528_b;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\tileentity\RenderEndPortal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */