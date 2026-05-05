/*    */ package net.minecraft.client.renderer.tileentity;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.model.ModelSign;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.tileentity.TileEntitySign;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class TileEntitySignRenderer extends TileEntitySpecialRenderer {
/* 13 */   private static final ResourceLocation field_147513_b = new ResourceLocation("textures/entity/sign.png");
/*    */   
/* 15 */   private final ModelSign field_147514_c = new ModelSign();
/*    */   private static final String __OBFID = "CL_00000970";
/*    */   
/*    */   public void func_147500_a(TileEntitySign p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
/* 19 */     Block block = p_147500_1_.func_145838_q();
/*    */     
/* 21 */     GL11.glPushMatrix();
/* 22 */     float f1 = 0.6666667F;
/* 23 */     if (block == Blocks.field_150472_an) {
/* 24 */       GL11.glTranslatef((float)p_147500_2_ + 0.5F, (float)p_147500_4_ + 0.75F * f1, (float)p_147500_6_ + 0.5F);
/* 25 */       float f = (p_147500_1_.func_145832_p() * 360) / 16.0F;
/* 26 */       GL11.glRotatef(-f, 0.0F, 1.0F, 0.0F);
/* 27 */       this.field_147514_c.field_78165_b.field_78806_j = true;
/*    */     } else {
/* 29 */       int i = p_147500_1_.func_145832_p();
/* 30 */       float f = 0.0F;
/*    */       
/* 32 */       if (i == 2) f = 180.0F; 
/* 33 */       if (i == 4) f = 90.0F; 
/* 34 */       if (i == 5) f = -90.0F;
/*    */       
/* 36 */       GL11.glTranslatef((float)p_147500_2_ + 0.5F, (float)p_147500_4_ + 0.75F * f1, (float)p_147500_6_ + 0.5F);
/* 37 */       GL11.glRotatef(-f, 0.0F, 1.0F, 0.0F);
/* 38 */       GL11.glTranslatef(0.0F, -0.3125F, -0.4375F);
/*    */       
/* 40 */       this.field_147514_c.field_78165_b.field_78806_j = false;
/*    */     } 
/*    */     
/* 43 */     func_147499_a(field_147513_b);
/*    */     
/* 45 */     GL11.glPushMatrix();
/* 46 */     GL11.glScalef(f1, -f1, -f1);
/* 47 */     this.field_147514_c.func_78164_a();
/* 48 */     GL11.glPopMatrix();
/* 49 */     FontRenderer fontRenderer = func_147498_b();
/*    */     
/* 51 */     float f2 = 0.016666668F * f1;
/* 52 */     GL11.glTranslatef(0.0F, 0.5F * f1, 0.07F * f1);
/* 53 */     GL11.glScalef(f2, -f2, f2);
/* 54 */     GL11.glNormal3f(0.0F, 0.0F, -1.0F * f2);
/* 55 */     GL11.glDepthMask(false);
/*    */     
/* 57 */     boolean bool = false;
/* 58 */     for (byte b = 0; b < p_147500_1_.field_145915_a.length; b++) {
/* 59 */       String str = p_147500_1_.field_145915_a[b];
/* 60 */       if (b == p_147500_1_.field_145918_i) {
/* 61 */         str = "> " + str + " <";
/* 62 */         fontRenderer.func_78276_b(str, -fontRenderer.func_78256_a(str) / 2, b * 10 - p_147500_1_.field_145915_a.length * 5, bool);
/*    */       } else {
/* 64 */         fontRenderer.func_78276_b(str, -fontRenderer.func_78256_a(str) / 2, b * 10 - p_147500_1_.field_145915_a.length * 5, bool);
/*    */       } 
/*    */     } 
/* 67 */     GL11.glDepthMask(true);
/* 68 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 69 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\tileentity\TileEntitySignRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */