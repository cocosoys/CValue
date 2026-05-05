/*     */ package net.minecraft.client.renderer.tileentity;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityBeacon;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class TileEntityBeaconRenderer extends TileEntitySpecialRenderer {
/*  13 */   private static final ResourceLocation field_147523_b = new ResourceLocation("textures/entity/beacon_beam.png");
/*     */   private static final String __OBFID = "CL_00000962";
/*     */   
/*     */   public void func_147500_a(TileEntityBeacon p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
/*  17 */     float f = p_147500_1_.func_146002_i();
/*     */     
/*  19 */     GL11.glAlphaFunc(516, 0.1F);
/*  20 */     if (f > 0.0F) {
/*  21 */       Tessellator tessellator = Tessellator.field_78398_a;
/*     */       
/*  23 */       func_147499_a(field_147523_b);
/*  24 */       GL11.glTexParameterf(3553, 10242, 10497.0F);
/*  25 */       GL11.glTexParameterf(3553, 10243, 10497.0F);
/*  26 */       GL11.glDisable(2896);
/*  27 */       GL11.glDisable(2884);
/*  28 */       GL11.glDisable(3042);
/*  29 */       GL11.glDepthMask(true);
/*  30 */       OpenGlHelper.func_148821_a(770, 1, 1, 0);
/*     */       
/*  32 */       float f1 = (float)p_147500_1_.func_145831_w().func_82737_E() + p_147500_8_;
/*  33 */       float f2 = -f1 * 0.2F - MathHelper.func_76141_d(-f1 * 0.1F);
/*     */ 
/*     */       
/*  36 */       boolean bool = true;
/*     */       
/*  38 */       double d2 = f1 * 0.025D * (1.0D - (bool & true) * 2.5D);
/*     */       
/*  40 */       tessellator.func_78382_b();
/*  41 */       tessellator.func_78370_a(255, 255, 255, 32);
/*     */       
/*  43 */       double d4 = bool * 0.2D;
/*     */       
/*  45 */       double d6 = 0.5D + Math.cos(d2 + 2.356194490192345D) * d4;
/*  46 */       double d8 = 0.5D + Math.sin(d2 + 2.356194490192345D) * d4;
/*  47 */       double d10 = 0.5D + Math.cos(d2 + 0.7853981633974483D) * d4;
/*  48 */       double d12 = 0.5D + Math.sin(d2 + 0.7853981633974483D) * d4;
/*     */       
/*  50 */       double d14 = 0.5D + Math.cos(d2 + 3.9269908169872414D) * d4;
/*  51 */       double d16 = 0.5D + Math.sin(d2 + 3.9269908169872414D) * d4;
/*  52 */       double d18 = 0.5D + Math.cos(d2 + 5.497787143782138D) * d4;
/*  53 */       double d20 = 0.5D + Math.sin(d2 + 5.497787143782138D) * d4;
/*     */       
/*  55 */       double d22 = (256.0F * f);
/*     */       
/*  57 */       double d24 = 0.0D;
/*  58 */       double d26 = 1.0D;
/*  59 */       double d27 = (-1.0F + f2);
/*  60 */       double d28 = (256.0F * f) * 0.5D / d4 + d27;
/*     */       
/*  62 */       tessellator.func_78374_a(p_147500_2_ + d6, p_147500_4_ + d22, p_147500_6_ + d8, d26, d28);
/*  63 */       tessellator.func_78374_a(p_147500_2_ + d6, p_147500_4_, p_147500_6_ + d8, d26, d27);
/*  64 */       tessellator.func_78374_a(p_147500_2_ + d10, p_147500_4_, p_147500_6_ + d12, d24, d27);
/*  65 */       tessellator.func_78374_a(p_147500_2_ + d10, p_147500_4_ + d22, p_147500_6_ + d12, d24, d28);
/*     */       
/*  67 */       tessellator.func_78374_a(p_147500_2_ + d18, p_147500_4_ + d22, p_147500_6_ + d20, d26, d28);
/*  68 */       tessellator.func_78374_a(p_147500_2_ + d18, p_147500_4_, p_147500_6_ + d20, d26, d27);
/*  69 */       tessellator.func_78374_a(p_147500_2_ + d14, p_147500_4_, p_147500_6_ + d16, d24, d27);
/*  70 */       tessellator.func_78374_a(p_147500_2_ + d14, p_147500_4_ + d22, p_147500_6_ + d16, d24, d28);
/*     */       
/*  72 */       tessellator.func_78374_a(p_147500_2_ + d10, p_147500_4_ + d22, p_147500_6_ + d12, d26, d28);
/*  73 */       tessellator.func_78374_a(p_147500_2_ + d10, p_147500_4_, p_147500_6_ + d12, d26, d27);
/*  74 */       tessellator.func_78374_a(p_147500_2_ + d18, p_147500_4_, p_147500_6_ + d20, d24, d27);
/*  75 */       tessellator.func_78374_a(p_147500_2_ + d18, p_147500_4_ + d22, p_147500_6_ + d20, d24, d28);
/*     */       
/*  77 */       tessellator.func_78374_a(p_147500_2_ + d14, p_147500_4_ + d22, p_147500_6_ + d16, d26, d28);
/*  78 */       tessellator.func_78374_a(p_147500_2_ + d14, p_147500_4_, p_147500_6_ + d16, d26, d27);
/*  79 */       tessellator.func_78374_a(p_147500_2_ + d6, p_147500_4_, p_147500_6_ + d8, d24, d27);
/*  80 */       tessellator.func_78374_a(p_147500_2_ + d6, p_147500_4_ + d22, p_147500_6_ + d8, d24, d28);
/*     */       
/*  82 */       tessellator.func_78381_a();
/*     */ 
/*     */       
/*  85 */       GL11.glEnable(3042);
/*  86 */       OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  87 */       GL11.glDepthMask(false);
/*     */ 
/*     */       
/*  90 */       tessellator.func_78382_b();
/*  91 */       tessellator.func_78370_a(255, 255, 255, 32);
/*     */       
/*  93 */       double d1 = 0.2D;
/*  94 */       double d3 = 0.2D;
/*  95 */       double d5 = 0.8D;
/*  96 */       double d7 = 0.2D;
/*     */       
/*  98 */       double d9 = 0.2D;
/*  99 */       double d11 = 0.8D;
/* 100 */       double d13 = 0.8D;
/* 101 */       double d15 = 0.8D;
/*     */       
/* 103 */       double d17 = (256.0F * f);
/*     */       
/* 105 */       double d19 = 0.0D;
/* 106 */       double d21 = 1.0D;
/* 107 */       double d23 = (-1.0F + f2);
/* 108 */       double d25 = (256.0F * f) + d23;
/*     */       
/* 110 */       tessellator.func_78374_a(p_147500_2_ + d1, p_147500_4_ + d17, p_147500_6_ + d3, d21, d25);
/* 111 */       tessellator.func_78374_a(p_147500_2_ + d1, p_147500_4_, p_147500_6_ + d3, d21, d23);
/* 112 */       tessellator.func_78374_a(p_147500_2_ + d5, p_147500_4_, p_147500_6_ + d7, d19, d23);
/* 113 */       tessellator.func_78374_a(p_147500_2_ + d5, p_147500_4_ + d17, p_147500_6_ + d7, d19, d25);
/*     */       
/* 115 */       tessellator.func_78374_a(p_147500_2_ + d13, p_147500_4_ + d17, p_147500_6_ + d15, d21, d25);
/* 116 */       tessellator.func_78374_a(p_147500_2_ + d13, p_147500_4_, p_147500_6_ + d15, d21, d23);
/* 117 */       tessellator.func_78374_a(p_147500_2_ + d9, p_147500_4_, p_147500_6_ + d11, d19, d23);
/* 118 */       tessellator.func_78374_a(p_147500_2_ + d9, p_147500_4_ + d17, p_147500_6_ + d11, d19, d25);
/*     */       
/* 120 */       tessellator.func_78374_a(p_147500_2_ + d5, p_147500_4_ + d17, p_147500_6_ + d7, d21, d25);
/* 121 */       tessellator.func_78374_a(p_147500_2_ + d5, p_147500_4_, p_147500_6_ + d7, d21, d23);
/* 122 */       tessellator.func_78374_a(p_147500_2_ + d13, p_147500_4_, p_147500_6_ + d15, d19, d23);
/* 123 */       tessellator.func_78374_a(p_147500_2_ + d13, p_147500_4_ + d17, p_147500_6_ + d15, d19, d25);
/*     */       
/* 125 */       tessellator.func_78374_a(p_147500_2_ + d9, p_147500_4_ + d17, p_147500_6_ + d11, d21, d25);
/* 126 */       tessellator.func_78374_a(p_147500_2_ + d9, p_147500_4_, p_147500_6_ + d11, d21, d23);
/* 127 */       tessellator.func_78374_a(p_147500_2_ + d1, p_147500_4_, p_147500_6_ + d3, d19, d23);
/* 128 */       tessellator.func_78374_a(p_147500_2_ + d1, p_147500_4_ + d17, p_147500_6_ + d3, d19, d25);
/*     */       
/* 130 */       tessellator.func_78381_a();
/*     */ 
/*     */       
/* 133 */       GL11.glEnable(2896);
/* 134 */       GL11.glEnable(3553);
/*     */       
/* 136 */       GL11.glDepthMask(true);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\tileentity\TileEntityBeaconRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */