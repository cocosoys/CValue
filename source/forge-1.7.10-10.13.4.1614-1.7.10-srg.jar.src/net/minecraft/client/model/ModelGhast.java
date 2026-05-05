/*    */ package net.minecraft.client.model;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelGhast
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer field_78128_a;
/* 16 */   ModelRenderer[] field_78127_b = new ModelRenderer[9];
/*    */   
/*    */   public ModelGhast() {
/* 19 */     byte b = -16;
/* 20 */     this.field_78128_a = new ModelRenderer(this, 0, 0);
/* 21 */     this.field_78128_a.func_78789_a(-8.0F, -8.0F, -8.0F, 16, 16, 16);
/* 22 */     this.field_78128_a.field_78797_d += (24 + b);
/*    */     
/* 24 */     Random random = new Random(1660L);
/* 25 */     for (byte b1 = 0; b1 < this.field_78127_b.length; b1++) {
/* 26 */       this.field_78127_b[b1] = new ModelRenderer(this, 0, 0);
/*    */       
/* 28 */       float f1 = (((b1 % 3) - (b1 / 3 % 2) * 0.5F + 0.25F) / 2.0F * 2.0F - 1.0F) * 5.0F;
/* 29 */       float f2 = ((b1 / 3) / 2.0F * 2.0F - 1.0F) * 5.0F;
/* 30 */       int i = random.nextInt(7) + 8;
/* 31 */       this.field_78127_b[b1].func_78789_a(-1.0F, 0.0F, -1.0F, 2, i, 2);
/*    */       
/* 33 */       (this.field_78127_b[b1]).field_78800_c = f1;
/* 34 */       (this.field_78127_b[b1]).field_78798_e = f2;
/* 35 */       (this.field_78127_b[b1]).field_78797_d = (31 + b);
/*    */     } 
/*    */   }
/*    */   private static final String __OBFID = "CL_00000839";
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 41 */     for (byte b = 0; b < this.field_78127_b.length; b++)
/*    */     {
/* 43 */       (this.field_78127_b[b]).field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.3F + b) + 0.4F;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 49 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*    */     
/* 51 */     GL11.glPushMatrix();
/* 52 */     GL11.glTranslatef(0.0F, 0.6F, 0.0F);
/*    */     
/* 54 */     this.field_78128_a.func_78785_a(p_78088_7_);
/* 55 */     for (ModelRenderer modelRenderer : this.field_78127_b) {
/* 56 */       modelRenderer.func_78785_a(p_78088_7_);
/*    */     }
/*    */     
/* 59 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelGhast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */