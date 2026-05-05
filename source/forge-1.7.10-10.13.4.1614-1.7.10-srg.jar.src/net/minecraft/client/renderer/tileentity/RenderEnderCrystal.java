/*    */ package net.minecraft.client.renderer.tileentity;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityEnderCrystal;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderEnderCrystal extends Render {
/* 11 */   private static final ResourceLocation field_110787_a = new ResourceLocation("textures/entity/endercrystal/endercrystal.png");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 18 */   private ModelBase field_76995_b = (ModelBase)new ModelEnderCrystal(0.0F, true);
/*    */   
/*    */   private static final String __OBFID = "CL_00000987";
/*    */   
/*    */   public void func_76986_a(EntityEnderCrystal p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 23 */     float f1 = p_76986_1_.field_70261_a + p_76986_9_;
/* 24 */     GL11.glPushMatrix();
/* 25 */     GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
/*    */     
/* 27 */     func_110776_a(field_110787_a);
/* 28 */     float f2 = MathHelper.func_76126_a(f1 * 0.2F) / 2.0F + 0.5F;
/* 29 */     f2 = f2 * f2 + f2;
/* 30 */     this.field_76995_b.func_78088_a((Entity)p_76986_1_, 0.0F, f1 * 3.0F, f2 * 0.2F, 0.0F, 0.0F, 0.0625F);
/* 31 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityEnderCrystal p_110775_1_) {
/* 36 */     return field_110787_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\tileentity\RenderEnderCrystal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */