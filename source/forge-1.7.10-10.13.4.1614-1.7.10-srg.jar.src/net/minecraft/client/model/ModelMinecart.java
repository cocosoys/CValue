/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelMinecart extends ModelBase {
/*  8 */   public ModelRenderer[] field_78154_a = new ModelRenderer[7]; private static final String __OBFID = "CL_00000844";
/*    */   
/*    */   public ModelMinecart() {
/* 11 */     this.field_78154_a[0] = new ModelRenderer(this, 0, 10);
/* 12 */     this.field_78154_a[1] = new ModelRenderer(this, 0, 0);
/* 13 */     this.field_78154_a[2] = new ModelRenderer(this, 0, 0);
/* 14 */     this.field_78154_a[3] = new ModelRenderer(this, 0, 0);
/* 15 */     this.field_78154_a[4] = new ModelRenderer(this, 0, 0);
/* 16 */     this.field_78154_a[5] = new ModelRenderer(this, 44, 10);
/*    */     
/* 18 */     byte b1 = 20;
/* 19 */     byte b2 = 8;
/* 20 */     byte b3 = 16;
/* 21 */     byte b4 = 4;
/*    */     
/* 23 */     this.field_78154_a[0].func_78790_a((-b1 / 2), (-b3 / 2), -1.0F, b1, b3, 2, 0.0F);
/* 24 */     this.field_78154_a[0].func_78793_a(0.0F, b4, 0.0F);
/*    */     
/* 26 */     this.field_78154_a[5].func_78790_a((-b1 / 2 + 1), (-b3 / 2 + 1), -1.0F, b1 - 2, b3 - 2, 1, 0.0F);
/* 27 */     this.field_78154_a[5].func_78793_a(0.0F, b4, 0.0F);
/*    */     
/* 29 */     this.field_78154_a[1].func_78790_a((-b1 / 2 + 2), (-b2 - 1), -1.0F, b1 - 4, b2, 2, 0.0F);
/* 30 */     this.field_78154_a[1].func_78793_a((-b1 / 2 + 1), b4, 0.0F);
/*    */     
/* 32 */     this.field_78154_a[2].func_78790_a((-b1 / 2 + 2), (-b2 - 1), -1.0F, b1 - 4, b2, 2, 0.0F);
/* 33 */     this.field_78154_a[2].func_78793_a((b1 / 2 - 1), b4, 0.0F);
/*    */     
/* 35 */     this.field_78154_a[3].func_78790_a((-b1 / 2 + 2), (-b2 - 1), -1.0F, b1 - 4, b2, 2, 0.0F);
/* 36 */     this.field_78154_a[3].func_78793_a(0.0F, b4, (-b3 / 2 + 1));
/*    */     
/* 38 */     this.field_78154_a[4].func_78790_a((-b1 / 2 + 2), (-b2 - 1), -1.0F, b1 - 4, b2, 2, 0.0F);
/* 39 */     this.field_78154_a[4].func_78793_a(0.0F, b4, (b3 / 2 - 1));
/*    */     
/* 41 */     (this.field_78154_a[0]).field_78795_f = 1.5707964F;
/* 42 */     (this.field_78154_a[1]).field_78796_g = 4.712389F;
/* 43 */     (this.field_78154_a[2]).field_78796_g = 1.5707964F;
/* 44 */     (this.field_78154_a[3]).field_78796_g = 3.1415927F;
/* 45 */     (this.field_78154_a[5]).field_78795_f = -1.5707964F;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 50 */     (this.field_78154_a[5]).field_78797_d = 4.0F - p_78088_4_;
/* 51 */     for (byte b = 0; b < 6; b++)
/* 52 */       this.field_78154_a[b].func_78785_a(p_78088_7_); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelMinecart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */