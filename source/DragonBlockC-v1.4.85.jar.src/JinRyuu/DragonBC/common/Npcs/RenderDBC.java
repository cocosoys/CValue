/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.entity.EntityJRMC;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RendererLivingEntity;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.event.RenderLivingEvent;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderDBC extends RendererLivingEntity {
/*     */   boolean b = false;
/*     */   
/*     */   public RenderDBC(ModelBase par1ModelBase, float par2) {
/*  23 */     super(par1ModelBase, par2);
/*  24 */     this.field_77045_g = par1ModelBase;
/*  25 */     this.field_76989_e = par2;
/*     */   }
/*     */   
/*     */   public void func_76986_a(Entity entity, double d0, double d1, double d2, float f, float f1) {
/*  29 */     func_76986_a((EntityLivingBase)entity, d0, d1, d2, f, f1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ResourceLocation func_110775_a(Entity entity) {
/*  36 */     if (entity instanceof EntityNamekian03)
/*  37 */       return new ResourceLocation(((EntityNamekian03)entity).getTexture()); 
/*  38 */     if (entity instanceof EntityDBC)
/*  39 */       return new ResourceLocation(((EntityDBC)entity).getTexture()); 
/*  40 */     if (entity instanceof EntityJRMC)
/*  41 */       return new ResourceLocation(((EntityJRMC)entity).getTexture()); 
/*  42 */     if (entity instanceof EntityDragon)
/*  43 */       return new ResourceLocation(((EntityDragon)entity).getTexture()); 
/*  44 */     if (entity instanceof EntityDragon2)
/*  45 */       return new ResourceLocation(((EntityDragon2)entity).getTexture()); 
/*  46 */     if (entity instanceof EntityNamekFrog)
/*  47 */       return new ResourceLocation(((EntityNamekFrog)entity).getTexture()); 
/*  48 */     return new ResourceLocation("jinryuudragonbc:npcs/" + entity.func_70005_c_().replaceAll("entity.jinryuudragonblockc.", "").replaceAll(".name", "") + ".png");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_77033_b(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6) {
/*  55 */     if (MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Specials.Pre(par1EntityLivingBase, this, par2, par4, par6)))
/*  56 */       return;  if (this.b) {
/*     */       
/*  58 */       float f = 1.6F;
/*  59 */       float f1 = 0.016666668F * f;
/*  60 */       double d3 = par1EntityLivingBase.func_70068_e((Entity)this.field_76990_c.field_78734_h);
/*  61 */       float f2 = par1EntityLivingBase.func_70093_af() ? NAME_TAG_RANGE_SNEAK : NAME_TAG_RANGE;
/*     */       
/*  63 */       if (d3 < (f2 * f2)) {
/*     */         
/*  65 */         String s = par1EntityLivingBase.func_70005_c_();
/*     */         
/*  67 */         if (par1EntityLivingBase.func_70093_af()) {
/*  68 */           FontRenderer fontrenderer = func_76983_a();
/*  69 */           GL11.glPushMatrix();
/*  70 */           GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + par1EntityLivingBase.field_70131_O + 0.5F, (float)par6);
/*  71 */           GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/*  72 */           GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/*  73 */           GL11.glRotatef(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
/*  74 */           GL11.glScalef(-f1, -f1, f1);
/*  75 */           GL11.glDisable(2896);
/*  76 */           GL11.glTranslatef(0.0F, 0.25F / f1, 0.0F);
/*  77 */           GL11.glDepthMask(false);
/*  78 */           GL11.glEnable(3042);
/*  79 */           GL11.glBlendFunc(770, 771);
/*  80 */           Tessellator tessellator = Tessellator.field_78398_a;
/*  81 */           GL11.glDisable(3553);
/*  82 */           tessellator.func_78382_b();
/*  83 */           int i = fontrenderer.func_78256_a(s) / 2;
/*  84 */           tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
/*  85 */           tessellator.func_78377_a((-i - 1), -1.0D, 0.0D);
/*  86 */           tessellator.func_78377_a((-i - 1), 8.0D, 0.0D);
/*  87 */           tessellator.func_78377_a((i + 1), 8.0D, 0.0D);
/*  88 */           tessellator.func_78377_a((i + 1), -1.0D, 0.0D);
/*  89 */           tessellator.func_78381_a();
/*  90 */           GL11.glEnable(3553);
/*  91 */           GL11.glDepthMask(true);
/*  92 */           fontrenderer.func_78276_b(s, -fontrenderer.func_78256_a(s) / 2, 0, 553648127);
/*  93 */           GL11.glEnable(2896);
/*  94 */           GL11.glDisable(3042);
/*  95 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  96 */           GL11.glPopMatrix();
/*     */         } else {
/*  98 */           func_96449_a(par1EntityLivingBase, par2, par4, par6, s, f1, d3);
/*     */         } 
/*     */       } 
/*     */     } 
/* 102 */     MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Specials.Post(par1EntityLivingBase, this, par2, par4, par6));
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\RenderDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */