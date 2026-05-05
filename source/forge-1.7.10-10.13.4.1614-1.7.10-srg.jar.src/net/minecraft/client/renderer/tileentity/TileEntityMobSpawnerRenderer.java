/*    */ package net.minecraft.client.renderer.tileentity;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.tileentity.MobSpawnerBaseLogic;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class TileEntityMobSpawnerRenderer extends TileEntitySpecialRenderer {
/*    */   public void func_147500_a(TileEntityMobSpawner p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
/* 13 */     GL11.glPushMatrix();
/* 14 */     GL11.glTranslatef((float)p_147500_2_ + 0.5F, (float)p_147500_4_, (float)p_147500_6_ + 0.5F);
/* 15 */     func_147517_a(p_147500_1_.func_145881_a(), p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
/* 16 */     GL11.glPopMatrix();
/*    */   }
/*    */   private static final String __OBFID = "CL_00000968";
/*    */   public static void func_147517_a(MobSpawnerBaseLogic p_147517_0_, double p_147517_1_, double p_147517_3_, double p_147517_5_, float p_147517_7_) {
/* 20 */     Entity entity = p_147517_0_.func_98281_h();
/* 21 */     if (entity != null) {
/* 22 */       entity.func_70029_a(p_147517_0_.func_98271_a());
/* 23 */       float f = 0.4375F;
/* 24 */       GL11.glTranslatef(0.0F, 0.4F, 0.0F);
/* 25 */       GL11.glRotatef((float)(p_147517_0_.field_98284_d + (p_147517_0_.field_98287_c - p_147517_0_.field_98284_d) * p_147517_7_) * 10.0F, 0.0F, 1.0F, 0.0F);
/* 26 */       GL11.glRotatef(-30.0F, 1.0F, 0.0F, 0.0F);
/* 27 */       GL11.glTranslatef(0.0F, -0.4F, 0.0F);
/* 28 */       GL11.glScalef(f, f, f);
/* 29 */       entity.func_70012_b(p_147517_1_, p_147517_3_, p_147517_5_, 0.0F, 0.0F);
/* 30 */       RenderManager.field_78727_a.func_147940_a(entity, 0.0D, 0.0D, 0.0D, 0.0F, p_147517_7_);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\tileentity\TileEntityMobSpawnerRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */