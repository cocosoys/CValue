/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelSquid extends ModelBase {
/*  8 */   ModelRenderer[] field_78201_b = new ModelRenderer[8]; ModelRenderer field_78202_a; private static final String __OBFID = "CL_00000861";
/*    */   
/*    */   public ModelSquid() {
/* 11 */     byte b = -16;
/* 12 */     this.field_78202_a = new ModelRenderer(this, 0, 0);
/* 13 */     this.field_78202_a.func_78789_a(-6.0F, -8.0F, -6.0F, 12, 16, 12);
/* 14 */     this.field_78202_a.field_78797_d += (24 + b);
/*    */     
/* 16 */     for (byte b1 = 0; b1 < this.field_78201_b.length; b1++) {
/* 17 */       this.field_78201_b[b1] = new ModelRenderer(this, 48, 0);
/*    */       
/* 19 */       double d = b1 * Math.PI * 2.0D / this.field_78201_b.length;
/* 20 */       float f1 = (float)Math.cos(d) * 5.0F;
/* 21 */       float f2 = (float)Math.sin(d) * 5.0F;
/* 22 */       this.field_78201_b[b1].func_78789_a(-1.0F, 0.0F, -1.0F, 2, 18, 2);
/*    */       
/* 24 */       (this.field_78201_b[b1]).field_78800_c = f1;
/* 25 */       (this.field_78201_b[b1]).field_78798_e = f2;
/* 26 */       (this.field_78201_b[b1]).field_78797_d = (31 + b);
/*    */       
/* 28 */       d = b1 * Math.PI * -2.0D / this.field_78201_b.length + 1.5707963267948966D;
/* 29 */       (this.field_78201_b[b1]).field_78796_g = (float)d;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 35 */     for (ModelRenderer modelRenderer : this.field_78201_b)
/*    */     {
/* 37 */       modelRenderer.field_78795_f = p_78087_3_;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 43 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*    */     
/* 45 */     this.field_78202_a.func_78785_a(p_78088_7_);
/* 46 */     for (byte b = 0; b < this.field_78201_b.length; b++)
/* 47 */       this.field_78201_b[b].func_78785_a(p_78088_7_); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelSquid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */