/*    */ package net.minecraft.client.renderer.tileentity;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.model.ModelChest;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.tileentity.TileEntityEnderChest;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class TileEntityEnderChestRenderer extends TileEntitySpecialRenderer {
/* 11 */   private static final ResourceLocation field_147520_b = new ResourceLocation("textures/entity/chest/ender.png");
/* 12 */   private ModelChest field_147521_c = new ModelChest();
/*    */   private static final String __OBFID = "CL_00000967";
/*    */   
/*    */   public void func_147500_a(TileEntityEnderChest p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
/* 16 */     int i = 0;
/*    */     
/* 18 */     if (p_147500_1_.func_145830_o()) {
/* 19 */       i = p_147500_1_.func_145832_p();
/*    */     }
/*    */     
/* 22 */     func_147499_a(field_147520_b);
/*    */     
/* 24 */     GL11.glPushMatrix();
/* 25 */     GL11.glEnable(32826);
/* 26 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 27 */     GL11.glTranslatef((float)p_147500_2_, (float)p_147500_4_ + 1.0F, (float)p_147500_6_ + 1.0F);
/* 28 */     GL11.glScalef(1.0F, -1.0F, -1.0F);
/*    */     
/* 30 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/* 31 */     short s = 0;
/* 32 */     if (i == 2) s = 180; 
/* 33 */     if (i == 3) s = 0; 
/* 34 */     if (i == 4) s = 90; 
/* 35 */     if (i == 5) s = -90;
/*    */     
/* 37 */     GL11.glRotatef(s, 0.0F, 1.0F, 0.0F);
/* 38 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/*    */     
/* 40 */     float f = p_147500_1_.field_145975_i + (p_147500_1_.field_145972_a - p_147500_1_.field_145975_i) * p_147500_8_;
/* 41 */     f = 1.0F - f;
/* 42 */     f = 1.0F - f * f * f;
/*    */     
/* 44 */     this.field_147521_c.field_78234_a.field_78795_f = -(f * 3.1415927F / 2.0F);
/* 45 */     this.field_147521_c.func_78231_a();
/* 46 */     GL11.glDisable(32826);
/* 47 */     GL11.glPopMatrix();
/* 48 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\tileentity\TileEntityEnderChestRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */