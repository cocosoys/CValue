/*    */ package net.minecraft.client.renderer.entity;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityTNTPrimed;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderTNTPrimed
/*    */   extends Render
/*    */ {
/* 24 */   private RenderBlocks field_76993_a = new RenderBlocks();
/*    */   
/*    */   public RenderTNTPrimed() {
/* 27 */     this.field_76989_e = 0.5F;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001030";
/*    */   
/*    */   public void func_76986_a(EntityTNTPrimed p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 32 */     GL11.glPushMatrix();
/* 33 */     GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
/* 34 */     if (p_76986_1_.field_70516_a - p_76986_9_ + 1.0F < 10.0F) {
/* 35 */       float f1 = 1.0F - (p_76986_1_.field_70516_a - p_76986_9_ + 1.0F) / 10.0F;
/* 36 */       if (f1 < 0.0F) f1 = 0.0F; 
/* 37 */       if (f1 > 1.0F) f1 = 1.0F; 
/* 38 */       f1 *= f1;
/* 39 */       f1 *= f1;
/* 40 */       float f2 = 1.0F + f1 * 0.3F;
/* 41 */       GL11.glScalef(f2, f2, f2);
/*    */     } 
/*    */     
/* 44 */     float f = (1.0F - (p_76986_1_.field_70516_a - p_76986_9_ + 1.0F) / 100.0F) * 0.8F;
/* 45 */     func_110777_b((Entity)p_76986_1_);
/* 46 */     this.field_76993_a.func_147800_a(Blocks.field_150335_W, 0, p_76986_1_.func_70013_c(p_76986_9_));
/* 47 */     if (p_76986_1_.field_70516_a / 5 % 2 == 0) {
/* 48 */       GL11.glDisable(3553);
/* 49 */       GL11.glDisable(2896);
/* 50 */       GL11.glEnable(3042);
/* 51 */       GL11.glBlendFunc(770, 772);
/* 52 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
/* 53 */       this.field_76993_a.func_147800_a(Blocks.field_150335_W, 0, 1.0F);
/* 54 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 55 */       GL11.glDisable(3042);
/* 56 */       GL11.glEnable(2896);
/* 57 */       GL11.glEnable(3553);
/*    */     } 
/* 59 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityTNTPrimed p_110775_1_) {
/* 64 */     return TextureMap.field_110575_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderTNTPrimed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */