/*    */ package net.minecraft.client.renderer.entity;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderEntity extends Render {
/*    */   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 12 */     GL11.glPushMatrix();
/* 13 */     func_76978_a(p_76986_1_.field_70121_D, p_76986_2_ - p_76986_1_.field_70142_S, p_76986_4_ - p_76986_1_.field_70137_T, p_76986_6_ - p_76986_1_.field_70136_U);
/* 14 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
/* 19 */     return null;
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000986";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */