/*     */ package JinRyuu.JRMCore.blocks;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class BlockBarrierRender
/*     */   extends TileEntitySpecialRenderer {
/*  15 */   float visibility = 0.0F;
/*  16 */   int startedTick1 = 0, startedTick2 = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAModelAt(BlockBarrierTileEntity tileentity, double d, double d1, double d2, float f) {
/*  21 */     if (!inInRenderDistance(distanceFromBlock(d, d1, d2)))
/*     */       return; 
/*  23 */     if (this.visibility > 0.0F) {
/*     */       
/*  25 */       GL11.glPushMatrix();
/*  26 */       GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.5F, (float)d2 + 0.5F);
/*  27 */       GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*  28 */       GL11.glPushMatrix();
/*     */       
/*  30 */       boolean view2 = (JRMCoreClient.mc.field_71474_y.field_74320_O == 2);
/*  31 */       GL11.glRotatef(RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
/*  32 */       GL11.glRotatef(RenderManager.field_78727_a.field_78732_j * (view2 ? true : -1), 1.0F, 0.0F, 0.0F);
/*     */       
/*  34 */       ResourceLocation tx = new ResourceLocation(JRMCoreH.tjjrmc + ":textures/blocks/tile.BlockBarrier.png");
/*  35 */       func_147499_a(tx);
/*  36 */       float scale = 0.0038F;
/*  37 */       GL11.glScalef(scale, scale, scale);
/*  38 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, this.visibility);
/*     */ 
/*     */       
/*  41 */       GL11.glPushMatrix();
/*     */       
/*  43 */       GL11.glEnable(3042);
/*  44 */       GL11.glDisable(2896);
/*  45 */       GL11.glBlendFunc(770, 771);
/*  46 */       GL11.glAlphaFunc(516, 0.003921569F);
/*     */       
/*  48 */       int size = 256;
/*  49 */       drawTexturedModalRect(-size / 2.0F, -size / 2.0F, 0, 0, size, size, 0.0F);
/*     */       
/*  51 */       GL11.glEnable(2896);
/*  52 */       GL11.glDisable(3042);
/*  53 */       GL11.glPopMatrix();
/*     */       
/*  55 */       GL11.glPopMatrix();
/*  56 */       GL11.glPopMatrix();
/*     */     } 
/*     */     
/*  59 */     if (JRMCoreClient.mc.field_71439_g.func_71045_bC() != null && JRMCoreClient.mc.field_71439_g.func_71045_bC().func_77977_a().equals("tile.BlockBarrier")) {
/*     */       
/*  61 */       this.startedTick1 = JRMCoreClient.mc.field_71439_g.field_70173_aa;
/*  62 */       if (this.visibility < 1.0F) {
/*  63 */         this.visibility += (JRMCoreClient.mc.field_71439_g.field_70173_aa - this.startedTick2) / 15.0F;
/*  64 */         this.startedTick2 = JRMCoreClient.mc.field_71439_g.field_70173_aa;
/*     */       } 
/*     */       
/*  67 */       if (this.visibility > 1.0F) this.visibility = 1.0F;
/*     */     
/*     */     } else {
/*  70 */       this.startedTick2 = JRMCoreClient.mc.field_71439_g.field_70173_aa;
/*  71 */       if (this.visibility > 0.0F) {
/*  72 */         this.visibility -= (JRMCoreClient.mc.field_71439_g.field_70173_aa - this.startedTick1) / 15.0F;
/*  73 */         this.startedTick1 = JRMCoreClient.mc.field_71439_g.field_70173_aa;
/*     */       } 
/*     */       
/*  76 */       if (this.visibility < 0.0F) this.visibility = 0.0F; 
/*     */     } 
/*     */   }
/*     */   public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f) {
/*  80 */     renderAModelAt((BlockBarrierTileEntity)tileentity, d, d1, d2, f);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawTexturedModalRect(float x, float y, int u, int v, float width, float height, float z) {
/*  85 */     float f = 0.00390625F;
/*  86 */     float f1 = 0.00390625F;
/*  87 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  88 */     tessellator.func_78382_b();
/*  89 */     tessellator.func_78374_a(x, (y + 0.0F), z, ((u + 0) * f), ((v + 0) * f1));
/*  90 */     tessellator.func_78374_a(x, (y + height), z, ((u + 0) * f), ((v + height) * f1));
/*  91 */     tessellator.func_78374_a((x + width), (y + height), z, ((u + width) * f), ((v + height) * f1));
/*  92 */     tessellator.func_78374_a((x + width), (y + 0.0F), z, ((u + width) * f), ((v + 0) * f1));
/*  93 */     tessellator.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   private double distanceFromBlock(double x, double y, double z) {
/*  98 */     double longest = 0.0D;
/*  99 */     if (x < 0.0D) x *= -1.0D;  if (x > longest) longest = x; 
/* 100 */     if (y < 0.0D) y *= -1.0D;  if (y > longest) longest = y; 
/* 101 */     if (z < 0.0D) z *= -1.0D;  if (z > longest) longest = z; 
/* 102 */     return longest;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean inInRenderDistance(double distance) {
/* 107 */     if (JGConfigClientSettings.renderdistanceMultiplierBarrierBlock == 100) return true; 
/* 108 */     double d1 = 64.0D;
/* 109 */     return (distance < d1 * JGConfigClientSettings.renderdistanceMultiplierBarrierBlock / 100.0D);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\blocks\BlockBarrierRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */