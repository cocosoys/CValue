/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.m.mBlob;
/*     */ import JinRyuu.JRMCore.m.mEnergy5;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderJRMCexpl
/*     */   extends RenderJRMC {
/*     */   private mBlob aModel;
/*     */   private mEnergy5 bModel;
/*     */   
/*     */   public RenderJRMCexpl() {
/*  23 */     super((ModelBase)new mBlob(), 0.0F);
/*  24 */     this.aModel = new mBlob();
/*  25 */     this.bModel = new mEnergy5();
/*     */   }
/*     */   
/*     */   public void renderJRMCexpl(EntityJRMCexpl par1Entity, double par2, double par4, double par6, float par8, float par9) {
/*  29 */     this.field_76989_e = 0.0F;
/*  30 */     if (par1Entity.type != 10 && par1Entity.type < 3 && JGConfigClientSettings.CLIENT_DA7 && par1Entity.type != 0) {
/*     */       
/*  32 */       boolean ext = JGConfigClientSettings.CLIENT_DA5;
/*  33 */       GL11.glPushMatrix();
/*  34 */       float var13 = handleRotationFloat(par1Entity, par9);
/*  35 */       float size = handleSizeFloat(par1Entity, par9);
/*  36 */       Random rand = new Random();
/*  37 */       float randfloat = (float)(rand.nextInt(5) * 0.1D);
/*  38 */       float var20 = size;
/*     */       
/*  40 */       GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + 0.0F, (float)par6 + 0.0F);
/*  41 */       GL11.glRotatef(par1Entity.field_70126_B + (par1Entity.field_70177_z - par1Entity.field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
/*  42 */       GL11.glRotatef(par1Entity.field_70127_C + (par1Entity.field_70125_A - par1Entity.field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
/*  43 */       GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*     */ 
/*     */       
/*  46 */       if (!ext) {
/*  47 */         ResourceLocation txx = new ResourceLocation(JRMCoreH.tjjrmc + ":en.png"); this.field_76990_c.field_78724_e.func_110577_a(txx);
/*     */       }
/*  49 */       else if (ext) {
/*  50 */         ResourceLocation txx = new ResourceLocation(JRMCoreH.tjjrmc + ":en2.png"); this.field_76990_c.field_78724_e.func_110577_a(txx);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  56 */       JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
/*  57 */       GL11.glDisable(2896);
/*  58 */       if (ext) {
/*  59 */         GL11.glEnable(3042);
/*  60 */         GL11.glBlendFunc(770, 771);
/*  61 */         GL11.glAlphaFunc(516, 0.003921569F);
/*  62 */         GL11.glDepthMask(false);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*  67 */       float t = par1Entity.field_70173_aa;
/*  68 */       float sp = t * par1Entity.explsiz / 5.0F;
/*     */       
/*  70 */       GL11.glPushMatrix();
/*  71 */       if (!ext) {
/*  72 */         GL11.glScalef(var20, var20, var20);
/*  73 */         this.aModel.renderModel(par1Entity, 0.0F, 0.0F, 0.0625F, var13);
/*     */       }
/*  75 */       else if (ext) {
/*  76 */         GL11.glRotatef(t * 10.0F, 0.5F, 1.0F, 0.0F);
/*  77 */         GL11.glScalef(sp, sp, sp);
/*     */         
/*  79 */         float szaz = par1Entity.MaxAge;
/*  80 */         float egy = szaz / 100.0F;
/*  81 */         float calc = par1Entity.Age / egy / 100.0F;
/*     */         
/*  83 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F - calc);
/*  84 */         this.bModel.renderModel(par1Entity, 0.0F, 0.0F, 0.0625F, var13);
/*     */       } 
/*     */       
/*  87 */       GL11.glPopMatrix();
/*     */       
/*  89 */       GL11.glEnable(2896);
/*  90 */       GL11.glDisable(3042);
/*  91 */       JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
/*  92 */       GL11.glDepthMask(false);
/*  93 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected float handleRotationFloat(Entity par1Entity, float par2) {
/*  98 */     return par1Entity.field_70173_aa + par2;
/*     */   }
/*     */   protected float handleSizeFloat(EntityJRMCexpl par1Entity, float par2) {
/* 101 */     float size = par1Entity.explsiz;
/* 102 */     float f = par1Entity.MaxAge * 0.2F;
/* 103 */     float f2 = par1Entity.MaxAge - f;
/* 104 */     float ticksExsisted = par1Entity.field_70173_aa;
/* 105 */     if (ticksExsisted < f) { ticksExsisted = ticksExsisted / f * size; }
/* 106 */     else if (ticksExsisted > f2) { ticksExsisted = (par1Entity.MaxAge - ticksExsisted) / f * size; }
/* 107 */     else { ticksExsisted = size; }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     return ticksExsisted;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 121 */     renderJRMCexpl((EntityJRMCexpl)par1Entity, par2, par4, par6, par8, par9);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\RenderJRMCexpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */