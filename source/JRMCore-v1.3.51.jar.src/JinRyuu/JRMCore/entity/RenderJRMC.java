/*    */ package JinRyuu.JRMCore.entity;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.entity.RendererLivingEntity;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.client.event.RenderLivingEvent;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderJRMC extends RendererLivingEntity {
/*    */   boolean b = false;
/*    */   
/*    */   public RenderJRMC(ModelBase par1ModelBase, float par2) {
/* 22 */     super(par1ModelBase, par2);
/* 23 */     this.field_77045_g = par1ModelBase;
/* 24 */     this.field_76989_e = par2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76986_a(Entity entity, double d0, double d1, double d2, float f, float f1) {
/* 29 */     func_76986_a((EntityLivingBase)entity, d0, d1, d2, f, f1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 37 */     return new ResourceLocation("jinryuudragonbc:npcs/" + entity.func_70005_c_().replaceAll("entity.jinryuudragonblockc.", "").replaceAll(".name", "") + ".png");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_77033_b(EntityLivingBase entity, double par2, double par4, double par6) {
/* 45 */     if (MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Specials.Pre(entity, this, par2, par4, par6)))
/* 46 */       return;  if (this.b) {
/*    */       
/* 48 */       float f = 1.6F;
/* 49 */       float f1 = 0.016666668F * f;
/* 50 */       double d3 = entity.func_70068_e((Entity)this.field_76990_c.field_78734_h);
/* 51 */       float f2 = entity.func_70093_af() ? NAME_TAG_RANGE_SNEAK : NAME_TAG_RANGE;
/*    */       
/* 53 */       if (d3 < (f2 * f2)) {
/*    */         
/* 55 */         String s = entity.func_70005_c_();
/*    */         
/* 57 */         if (entity.func_70093_af()) {
/*    */           
/* 59 */           FontRenderer fontrenderer = func_76983_a();
/* 60 */           GL11.glPushMatrix();
/* 61 */           GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + entity.field_70131_O + 0.5F, (float)par6);
/* 62 */           GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/* 63 */           GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 64 */           GL11.glRotatef(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
/* 65 */           GL11.glScalef(-f1, -f1, f1);
/* 66 */           GL11.glDisable(2896);
/* 67 */           GL11.glTranslatef(0.0F, 0.25F / f1, 0.0F);
/* 68 */           GL11.glDepthMask(false);
/* 69 */           GL11.glEnable(3042);
/* 70 */           GL11.glBlendFunc(770, 771);
/* 71 */           Tessellator tessellator = Tessellator.field_78398_a;
/* 72 */           GL11.glDisable(3553);
/* 73 */           tessellator.func_78382_b();
/* 74 */           int i = fontrenderer.func_78256_a(s) / 2;
/* 75 */           tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
/* 76 */           tessellator.func_78377_a((-i - 1), -1.0D, 0.0D);
/* 77 */           tessellator.func_78377_a((-i - 1), 8.0D, 0.0D);
/* 78 */           tessellator.func_78377_a((i + 1), 8.0D, 0.0D);
/* 79 */           tessellator.func_78377_a((i + 1), -1.0D, 0.0D);
/* 80 */           tessellator.func_78381_a();
/* 81 */           GL11.glEnable(3553);
/* 82 */           GL11.glDepthMask(true);
/* 83 */           fontrenderer.func_78276_b(s, -fontrenderer.func_78256_a(s) / 2, 0, 553648127);
/* 84 */           GL11.glEnable(2896);
/* 85 */           GL11.glDisable(3042);
/* 86 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 87 */           GL11.glPopMatrix();
/*    */         }
/*    */         else {
/*    */           
/* 91 */           func_96449_a(entity, par2, par4, par6, s, f1, d3);
/*    */         } 
/*    */       } 
/*    */     } 
/* 95 */     MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Specials.Post(entity, this, par2, par4, par6));
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\RenderJRMC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */