/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.monster.EntityMagmaCube;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelMagmaCube extends ModelBase {
/*  9 */   ModelRenderer[] field_78109_a = new ModelRenderer[8];
/*    */   ModelRenderer field_78108_b;
/*    */   private static final String __OBFID = "CL_00000842";
/*    */   
/*    */   public ModelMagmaCube() {
/* 14 */     for (byte b = 0; b < this.field_78109_a.length; b++) {
/* 15 */       byte b1 = 0;
/* 16 */       byte b2 = b;
/* 17 */       if (b == 2) {
/* 18 */         b1 = 24;
/* 19 */         b2 = 10;
/* 20 */       } else if (b == 3) {
/* 21 */         b1 = 24;
/* 22 */         b2 = 19;
/*    */       } 
/* 24 */       this.field_78109_a[b] = new ModelRenderer(this, b1, b2);
/* 25 */       this.field_78109_a[b].func_78789_a(-4.0F, (16 + b), -4.0F, 8, 1, 8);
/*    */     } 
/*    */     
/* 28 */     this.field_78108_b = new ModelRenderer(this, 0, 16);
/* 29 */     this.field_78108_b.func_78789_a(-2.0F, 18.0F, -2.0F, 4, 4, 4);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
/* 38 */     EntityMagmaCube entityMagmaCube = (EntityMagmaCube)p_78086_1_;
/*    */     
/* 40 */     float f = entityMagmaCube.field_70812_c + (entityMagmaCube.field_70811_b - entityMagmaCube.field_70812_c) * p_78086_4_;
/* 41 */     if (f < 0.0F) {
/* 42 */       f = 0.0F;
/*    */     }
/*    */     
/* 45 */     for (byte b = 0; b < this.field_78109_a.length; b++) {
/* 46 */       (this.field_78109_a[b]).field_78797_d = -(4 - b) * f * 1.7F;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/* 52 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*    */     
/* 54 */     this.field_78108_b.func_78785_a(p_78088_7_);
/* 55 */     for (byte b = 0; b < this.field_78109_a.length; b++)
/* 56 */       this.field_78109_a[b].func_78785_a(p_78088_7_); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelMagmaCube.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */