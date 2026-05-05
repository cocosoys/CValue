/*    */ package net.minecraft.client.renderer.entity;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.projectile.EntityFireball;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderFireball extends Render {
/*    */   private float field_77002_a;
/*    */   
/*    */   public RenderFireball(float p_i1254_1_) {
/* 18 */     this.field_77002_a = p_i1254_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000995";
/*    */   
/*    */   public void func_76986_a(EntityFireball p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 23 */     GL11.glPushMatrix();
/*    */     
/* 25 */     func_110777_b((Entity)p_76986_1_);
/*    */     
/* 27 */     GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
/* 28 */     GL11.glEnable(32826);
/* 29 */     float f1 = this.field_77002_a;
/* 30 */     GL11.glScalef(f1 / 1.0F, f1 / 1.0F, f1 / 1.0F);
/* 31 */     IIcon iIcon = Items.field_151059_bz.func_77617_a(0);
/* 32 */     Tessellator tessellator = Tessellator.field_78398_a;
/*    */     
/* 34 */     float f2 = iIcon.func_94209_e();
/* 35 */     float f3 = iIcon.func_94212_f();
/* 36 */     float f4 = iIcon.func_94206_g();
/* 37 */     float f5 = iIcon.func_94210_h();
/*    */     
/* 39 */     float f6 = 1.0F;
/* 40 */     float f7 = 0.5F;
/* 41 */     float f8 = 0.25F;
/*    */     
/* 43 */     GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 44 */     GL11.glRotatef(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
/* 45 */     tessellator.func_78382_b();
/* 46 */     tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 47 */     tessellator.func_78374_a((0.0F - f7), (0.0F - f8), 0.0D, f2, f5);
/* 48 */     tessellator.func_78374_a((f6 - f7), (0.0F - f8), 0.0D, f3, f5);
/* 49 */     tessellator.func_78374_a((f6 - f7), (1.0F - f8), 0.0D, f3, f4);
/* 50 */     tessellator.func_78374_a((0.0F - f7), (1.0F - f8), 0.0D, f2, f4);
/* 51 */     tessellator.func_78381_a();
/*    */     
/* 53 */     GL11.glDisable(32826);
/* 54 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityFireball p_110775_1_) {
/* 59 */     return TextureMap.field_110576_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderFireball.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */