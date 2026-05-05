/*    */ package net.minecraft.client.renderer.entity;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.item.EntityMinecart;
/*    */ import net.minecraft.entity.item.EntityMinecartTNT;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderTntMinecart extends RenderMinecart {
/*    */   protected void func_147910_a(EntityMinecartTNT p_147910_1_, float p_147910_2_, Block p_147910_3_, int p_147910_4_) {
/* 12 */     int i = p_147910_1_.func_94104_d();
/*    */     
/* 14 */     if (i > -1 && 
/* 15 */       i - p_147910_2_ + 1.0F < 10.0F) {
/* 16 */       float f1 = 1.0F - (i - p_147910_2_ + 1.0F) / 10.0F;
/* 17 */       if (f1 < 0.0F) f1 = 0.0F; 
/* 18 */       if (f1 > 1.0F) f1 = 1.0F; 
/* 19 */       f1 *= f1;
/* 20 */       f1 *= f1;
/* 21 */       float f2 = 1.0F + f1 * 0.3F;
/* 22 */       GL11.glScalef(f2, f2, f2);
/*    */     } 
/*    */ 
/*    */     
/* 26 */     super.func_147910_a((EntityMinecart)p_147910_1_, p_147910_2_, p_147910_3_, p_147910_4_);
/*    */     
/* 28 */     if (i > -1 && i / 5 % 2 == 0) {
/* 29 */       GL11.glDisable(3553);
/* 30 */       GL11.glDisable(2896);
/* 31 */       GL11.glEnable(3042);
/* 32 */       GL11.glBlendFunc(770, 772);
/* 33 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, (1.0F - (i - p_147910_2_ + 1.0F) / 100.0F) * 0.8F);
/*    */       
/* 35 */       GL11.glPushMatrix();
/* 36 */       this.field_94145_f.func_147800_a(Blocks.field_150335_W, 0, 1.0F);
/* 37 */       GL11.glPopMatrix();
/*    */       
/* 39 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 40 */       GL11.glDisable(3042);
/* 41 */       GL11.glEnable(2896);
/* 42 */       GL11.glEnable(3553);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00001029";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderTntMinecart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */