/*    */ package net.minecraft.client.model;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelEnderCrystal extends ModelBase {
/*    */   private ModelRenderer field_78230_a;
/*    */   private ModelRenderer field_78228_b;
/*    */   private ModelRenderer field_78229_c;
/*    */   private static final String __OBFID = "CL_00000871";
/*    */   
/*    */   public ModelEnderCrystal(float p_i1170_1_, boolean p_i1170_2_) {
/* 16 */     this.field_78228_b = new ModelRenderer(this, "glass");
/* 17 */     this.field_78228_b.func_78784_a(0, 0).func_78789_a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
/*    */     
/* 19 */     this.field_78230_a = new ModelRenderer(this, "cube");
/* 20 */     this.field_78230_a.func_78784_a(32, 0).func_78789_a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
/*    */     
/* 22 */     if (p_i1170_2_) {
/* 23 */       this.field_78229_c = new ModelRenderer(this, "base");
/* 24 */       this.field_78229_c.func_78784_a(0, 16).func_78789_a(-6.0F, 0.0F, -6.0F, 12, 4, 12);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 30 */     GL11.glPushMatrix();
/* 31 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 32 */     GL11.glTranslatef(0.0F, -0.5F, 0.0F);
/* 33 */     if (this.field_78229_c != null) {
/* 34 */       this.field_78229_c.func_78785_a(p_78088_7_);
/*    */     }
/* 36 */     GL11.glRotatef(p_78088_3_, 0.0F, 1.0F, 0.0F);
/* 37 */     GL11.glTranslatef(0.0F, 0.8F + p_78088_4_, 0.0F);
/* 38 */     GL11.glRotatef(60.0F, 0.7071F, 0.0F, 0.7071F);
/* 39 */     this.field_78228_b.func_78785_a(p_78088_7_);
/* 40 */     float f = 0.875F;
/* 41 */     GL11.glScalef(f, f, f);
/* 42 */     GL11.glRotatef(60.0F, 0.7071F, 0.0F, 0.7071F);
/* 43 */     GL11.glRotatef(p_78088_3_, 0.0F, 1.0F, 0.0F);
/* 44 */     this.field_78228_b.func_78785_a(p_78088_7_);
/* 45 */     GL11.glScalef(f, f, f);
/* 46 */     GL11.glRotatef(60.0F, 0.7071F, 0.0F, 0.7071F);
/* 47 */     GL11.glRotatef(p_78088_3_, 0.0F, 1.0F, 0.0F);
/* 48 */     this.field_78230_a.func_78785_a(p_78088_7_);
/* 49 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelEnderCrystal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */