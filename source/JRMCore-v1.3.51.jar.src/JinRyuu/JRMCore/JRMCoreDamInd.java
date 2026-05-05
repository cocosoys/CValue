/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.particle.EntityAuraFX;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JRMCoreDamInd
/*    */   extends EntityAuraFX
/*    */ {
/* 17 */   private static final ResourceLocation particleTextures = new ResourceLocation("textures/particle/particles.png");
/* 18 */   private double amount = 0.0D;
/* 19 */   private double timeleft = 0.0D;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JRMCoreDamInd(double amount, float timeleft, World parWorld, double parX, double parY, double parZ, double parMotionX, double parMotionY, double parMotionZ) {
/* 25 */     super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
/* 26 */     func_70536_a(82);
/* 27 */     this.field_70544_f = 1.0F;
/* 28 */     func_70538_b(136.0F, 0.0F, 136.0F);
/* 29 */     this.amount = amount;
/* 30 */     this.timeleft = timeleft;
/* 31 */     this.field_70547_e = 50;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 37 */     this.field_70169_q = this.field_70165_t;
/* 38 */     this.field_70167_r = this.field_70163_u;
/* 39 */     this.field_70166_s = this.field_70161_v;
/* 40 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 41 */     this.field_70159_w *= 0.99D;
/* 42 */     this.field_70181_x *= 0.99D;
/* 43 */     this.field_70179_y *= 0.99D;
/*    */     
/* 45 */     this.field_70181_x += 0.00125D;
/* 46 */     if (this.field_70547_e-- <= 0)
/*    */     {
/* 48 */       func_70106_y();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 55 */     float f11 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * p_70539_2_ - field_70556_an);
/* 56 */     float f12 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * p_70539_2_ - field_70554_ao);
/* 57 */     float f13 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * p_70539_2_ - field_70555_ap);
/* 58 */     p_70539_1_.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as);
/*    */     
/* 60 */     FontRenderer fontrenderer = JRMCoreClient.mc.field_71466_p;
/* 61 */     GL11.glPushMatrix();
/* 62 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */     
/* 64 */     GL11.glTranslatef(f11 + 0.0F, f12 - 0.75F + 1.75F, f13);
/* 65 */     GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/* 66 */     boolean ro = (JRMCoreClient.mc.field_71474_y.field_74320_O == 2);
/* 67 */     GL11.glRotatef(-RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 68 */     GL11.glRotatef(RenderManager.field_78727_a.field_78732_j, 1.0F * (ro ? -1 : true), 0.0F, 0.0F);
/* 69 */     float f1 = 0.0516F;
/* 70 */     GL11.glScalef(-f1, -f1, f1);
/* 71 */     GL11.glTranslatef(0.0F, 0.25F / f1, 0.0F);
/*    */ 
/*    */     
/* 74 */     String text = "" + JRMCoreH.numSep((int)this.amount);
/* 75 */     int textWidth = fontrenderer.func_78256_a(text);
/* 76 */     JRMCoreGuiScreen.drawStringWithBorder(fontrenderer, text, -textWidth / 2, -2, JRMCoreH.techCol[4]);
/*    */     
/* 78 */     JRMCoreClient.mc.field_71446_o.func_110577_a(particleTextures);
/* 79 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 80 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreDamInd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */