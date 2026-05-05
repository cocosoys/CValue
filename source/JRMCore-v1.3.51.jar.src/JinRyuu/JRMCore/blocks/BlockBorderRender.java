/*     */ package JinRyuu.JRMCore.blocks;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class BlockBorderRender
/*     */   extends TileEntitySpecialRenderer {
/*  14 */   float visibility = 0.0F;
/*  15 */   int startedTick1 = 0; int startedTick2 = 0;
/*     */   
/*  17 */   byte[] rnd = new byte[6];
/*  18 */   final int[] rndx = new int[] { 0, 0, 1, -1, 0, 0 };
/*  19 */   final int[] rndy = new int[] { 1, -1, 0, 0, 0, 0 };
/*  20 */   final int[] rndz = new int[] { 0, 0, 0, 0, 1, -1 };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAModelAt(BlockBorderTileEntity tileentity, double d, double d1, double d2, float f) {
/*  26 */     if (!inInRenderDistance(distanceFromBlock(d, d1, d2))) {
/*     */       return;
/*     */     }
/*  29 */     int ani = 0;
/*  30 */     String n = "";
/*  31 */     if (JRMCoreClient.mc.field_71439_g.func_71045_bC() != null && JRMCoreClient.mc.field_71439_g.func_71045_bC().func_77977_a().equals("tile.BlockBorder")) {
/*  32 */       ani = 0;
/*  33 */       this.visibility = 1.0F;
/*  34 */       n = "Edit";
/*     */     } else {
/*     */       
/*  37 */       ani = JRMCoreClient.mc.field_71439_g.field_70173_aa % 128;
/*  38 */       ani *= 2;
/*  39 */       this.visibility = 0.6F;
/*     */     } 
/*  41 */     boolean[] doit = new boolean[3];
/*     */     
/*  43 */     boolean one = false;
/*  44 */     for (int i = 0; i < 6; i++) {
/*  45 */       if (tileentity.field_145848_d + this.rndy[i] > 0 && tileentity.field_145848_d + this.rndy[i] < 254) {
/*  46 */         if (!tileentity.func_145831_w().func_147439_a(tileentity.field_145851_c + this.rndx[i], tileentity.field_145848_d + this.rndy[i], tileentity.field_145849_e + this.rndz[i]).func_149739_a().toLowerCase().contains("air")) {
/*  47 */           this.rnd[i] = 1;
/*  48 */           one = true;
/*     */         } else {
/*  50 */           this.rnd[i] = 0;
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/*  55 */     if (one) {
/*     */       
/*  57 */       if (this.rnd[2] == 1 || this.rnd[3] == 1 || this.rnd[4] == 1 || this.rnd[5] == 1) { doit[2] = true; }
/*  58 */       else { doit[2] = false; }
/*     */       
/*  60 */       if (this.rnd[0] == 1 || this.rnd[1] == 1)
/*     */       {
/*  62 */         if (doit[2]) {
/*     */           
/*  64 */           if (this.rnd[2] == 1 || this.rnd[3] == 1) doit[0] = true; 
/*  65 */           if (this.rnd[4] == 1 || this.rnd[5] == 1) doit[1] = true; 
/*  66 */           if ((this.rnd[2] == 1 || this.rnd[3] == 1) && (this.rnd[4] == 1 || this.rnd[5] == 1)) { doit[2] = true; }
/*  67 */           else { doit[2] = false; }
/*     */         
/*     */         } else {
/*     */           
/*  71 */           doit[0] = true;
/*  72 */           doit[1] = true;
/*     */         }
/*     */       
/*     */       }
/*     */     } else {
/*     */       
/*  78 */       doit[0] = true; doit[1] = true; doit[2] = true;
/*     */     } 
/*     */ 
/*     */     
/*  82 */     if (this.visibility > 0.0F) {
/*  83 */       GL11.glPushMatrix();
/*  84 */       GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.5F, (float)d2 + 0.5F);
/*  85 */       GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*  86 */       GL11.glPushMatrix();
/*     */       
/*  88 */       boolean view2 = (JRMCoreClient.mc.field_71474_y.field_74320_O == 2);
/*  89 */       ResourceLocation tx = new ResourceLocation(JRMCoreH.tjjrmc + ":textures/blocks/tile.BlockBorder" + n + ".png");
/*  90 */       func_147499_a(tx);
/*  91 */       float scale = 0.00391F;
/*  92 */       GL11.glScalef(scale, scale, scale);
/*  93 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, this.visibility);
/*     */ 
/*     */ 
/*     */       
/*  97 */       int side = 0;
/*  98 */       while (side < 3) {
/*  99 */         if (doit[side]) {
/* 100 */           if (side == 1) {
/* 101 */             GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
/*     */           }
/* 103 */           else if (side == 2) {
/* 104 */             GL11.glRotatef(180.0F, 0.0F, 1.0F, 1.0F);
/*     */           } 
/* 106 */           for (int mrr = 0; mrr < 2; mrr++) {
/* 107 */             if (mrr == 1) {
/* 108 */               GL11.glRotatef(180.0F, 0.0F, 0.0F, -1.0F);
/* 109 */               GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*     */             } 
/* 111 */             int sizes = 2;
/* 112 */             GL11.glPushMatrix();
/*     */             
/* 114 */             GL11.glEnable(3042);
/* 115 */             GL11.glDisable(2896);
/* 116 */             GL11.glBlendFunc(770, 771);
/* 117 */             GL11.glAlphaFunc(516, 0.003921569F);
/* 118 */             int size = 256;
/* 119 */             drawTexturedModalRect((-size + size / 2), (-size + size / 2), 0 + size + ani, 0 + size + ani, size, size, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 124 */             GL11.glEnable(2896);
/* 125 */             GL11.glDisable(3042);
/* 126 */             GL11.glPopMatrix();
/*     */           } 
/*     */         } 
/* 129 */         side++;
/*     */       } 
/*     */       
/* 132 */       GL11.glPopMatrix();
/* 133 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
/* 138 */     renderAModelAt((BlockBorderTileEntity)tileentity, d, d1, d2, f);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawTexturedModalRect(float x, float y, int u, int v, float width, float height, float z) {
/* 143 */     float f = 0.00390625F;
/* 144 */     float f1 = 0.00390625F;
/* 145 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 146 */     tessellator.func_78382_b();
/* 147 */     tessellator.func_78374_a(x, (y + 0.0F), z, ((u + 0) * f), ((v + 0) * f1));
/* 148 */     tessellator.func_78374_a(x, (y + height), z, ((u + 0) * f), ((v + height) * f1));
/* 149 */     tessellator.func_78374_a((x + width), (y + height), z, ((u + width) * f), ((v + height) * f1));
/* 150 */     tessellator.func_78374_a((x + width), (y + 0.0F), z, ((u + width) * f), ((v + 0) * f1));
/* 151 */     tessellator.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   private double distanceFromBlock(double x, double y, double z) {
/* 156 */     double longest = 0.0D;
/* 157 */     if (x < 0.0D) x *= -1.0D;  if (x > longest) longest = x; 
/* 158 */     if (y < 0.0D) y *= -1.0D;  if (y > longest) longest = y; 
/* 159 */     if (z < 0.0D) z *= -1.0D;  if (z > longest) longest = z; 
/* 160 */     return longest;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean inInRenderDistance(double distance) {
/* 165 */     if (JGConfigClientSettings.renderdistanceMultiplierBarrierBlock == 100) return true; 
/* 166 */     double d1 = 64.0D;
/* 167 */     return (distance < d1 * JGConfigClientSettings.renderdistanceMultiplierBarrierBlock / 100.0D);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\blocks\BlockBorderRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */