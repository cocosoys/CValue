/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelBoat extends ModelBase {
/*  8 */   public ModelRenderer[] field_78103_a = new ModelRenderer[5]; private static final String __OBFID = "CL_00000832";
/*    */   
/*    */   public ModelBoat() {
/* 11 */     this.field_78103_a[0] = new ModelRenderer(this, 0, 8);
/* 12 */     this.field_78103_a[1] = new ModelRenderer(this, 0, 0);
/* 13 */     this.field_78103_a[2] = new ModelRenderer(this, 0, 0);
/* 14 */     this.field_78103_a[3] = new ModelRenderer(this, 0, 0);
/* 15 */     this.field_78103_a[4] = new ModelRenderer(this, 0, 0);
/*    */     
/* 17 */     byte b1 = 24;
/* 18 */     byte b2 = 6;
/* 19 */     byte b3 = 20;
/* 20 */     byte b4 = 4;
/*    */     
/* 22 */     this.field_78103_a[0].func_78790_a((-b1 / 2), (-b3 / 2 + 2), -3.0F, b1, b3 - 4, 4, 0.0F);
/* 23 */     this.field_78103_a[0].func_78793_a(0.0F, b4, 0.0F);
/*    */     
/* 25 */     this.field_78103_a[1].func_78790_a((-b1 / 2 + 2), (-b2 - 1), -1.0F, b1 - 4, b2, 2, 0.0F);
/* 26 */     this.field_78103_a[1].func_78793_a((-b1 / 2 + 1), b4, 0.0F);
/*    */     
/* 28 */     this.field_78103_a[2].func_78790_a((-b1 / 2 + 2), (-b2 - 1), -1.0F, b1 - 4, b2, 2, 0.0F);
/* 29 */     this.field_78103_a[2].func_78793_a((b1 / 2 - 1), b4, 0.0F);
/*    */     
/* 31 */     this.field_78103_a[3].func_78790_a((-b1 / 2 + 2), (-b2 - 1), -1.0F, b1 - 4, b2, 2, 0.0F);
/* 32 */     this.field_78103_a[3].func_78793_a(0.0F, b4, (-b3 / 2 + 1));
/*    */     
/* 34 */     this.field_78103_a[4].func_78790_a((-b1 / 2 + 2), (-b2 - 1), -1.0F, b1 - 4, b2, 2, 0.0F);
/* 35 */     this.field_78103_a[4].func_78793_a(0.0F, b4, (b3 / 2 - 1));
/*    */     
/* 37 */     (this.field_78103_a[0]).field_78795_f = 1.5707964F;
/* 38 */     (this.field_78103_a[1]).field_78796_g = 4.712389F;
/* 39 */     (this.field_78103_a[2]).field_78796_g = 1.5707964F;
/* 40 */     (this.field_78103_a[3]).field_78796_g = 3.1415927F;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 45 */     for (byte b = 0; b < 5; b++)
/* 46 */       this.field_78103_a[b].func_78785_a(p_78088_7_); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelBoat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */