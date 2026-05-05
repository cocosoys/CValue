/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderAuraRing
/*     */   extends RenderDBC
/*     */ {
/*     */   private ModelKiAuraRing aModel;
/*     */   
/*     */   public RenderAuraRing() {
/*  22 */     super((ModelBase)new ModelKiAuraRing(), 0.5F);
/*  23 */     this.aModel = new ModelKiAuraRing();
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAuraRing(EntityAuraRing par1Entity, double par2, double par4, double par6, float par8, float par9) {
/*  28 */     this.field_76989_e = 0.0F;
/*  29 */     GL11.glPushMatrix();
/*     */     
/*  31 */     float a = par1Entity.getAge();
/*  32 */     float cr = par1Entity.getCRel();
/*  33 */     float s = par1Entity.getState() + cr * 0.03F;
/*  34 */     float s2 = par1Entity.getState2() * 0.5F;
/*  35 */     s += s2;
/*     */     
/*  37 */     GL11.glPushMatrix();
/*     */     
/*  39 */     float var13 = handleRotationFloat(par1Entity, par9);
/*  40 */     float size = handleSizeFloat(par1Entity, par9);
/*     */     
/*  42 */     Random rand = new Random();
/*  43 */     float randfloat = (float)(rand.nextInt(5) * 0.1D);
/*  44 */     float var20 = size;
/*     */ 
/*     */     
/*  47 */     GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + 3.2F, (float)par6 + 0.0F);
/*  48 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*     */     
/*  50 */     ResourceLocation txx = new ResourceLocation("jinryuudragonbc:auraring.png"); this.field_76990_c.field_78724_e.func_110577_a(txx);
/*     */     
/*  52 */     RenderAura.glColor4f(par1Entity.color, par1Entity.update_alpha());
/*  53 */     GL11.glDepthMask(false);
/*  54 */     GL11.glEnable(3042);
/*  55 */     GL11.glBlendFunc(770, 771);
/*  56 */     GL11.glAlphaFunc(516, 0.003921569F);
/*  57 */     GL11.glScalef(var20, 1.0F, var20);
/*     */     
/*  59 */     GL11.glTranslatef(0.0F, 0.0F - 0.15F * s, 0.0F);
/*  60 */     GL11.glScalef(1.0F + 0.1F * s, 1.0F + 0.05F * s, 1.0F + 0.1F * s);
/*     */ 
/*     */     
/*  63 */     GL11.glRotatef(a * 18.0F, 0.0F, 1.0F, 0.0F);
/*  64 */     this.aModel.renderModel(par1Entity, 0.0F, 0.0F, 0.0625F, var13);
/*  65 */     GL11.glDisable(3042);
/*  66 */     GL11.glAlphaFunc(516, 0.1F);
/*  67 */     GL11.glPopMatrix();
/*  68 */     GL11.glDepthMask(true);
/*  69 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected float handleRotationFloat(Entity par1Entity, float par2) {
/*  75 */     return par1Entity.field_70173_aa + par2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected float handleSizeFloat(Entity par1Entity, float par2) {
/*  80 */     float ticksExsisted = (par1Entity.field_70173_aa + par2) / 2.0F;
/*  81 */     return ticksExsisted;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 105 */     renderAuraRing((EntityAuraRing)par1Entity, par2, par4, par6, par8, par9);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\RenderAuraRing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */