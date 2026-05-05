/*    */ package net.minecraft.client.renderer.texture;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class TextureClock extends TextureAtlasSprite {
/*    */   private double field_94239_h;
/*    */   
/*    */   public TextureClock(String p_i1285_1_) {
/* 12 */     super(p_i1285_1_);
/*    */   }
/*    */   
/*    */   private double field_94240_i;
/*    */   private static final String __OBFID = "CL_00001070";
/*    */   
/*    */   public void func_94219_l() {
/* 19 */     if (this.field_110976_a.isEmpty()) {
/*    */       return;
/*    */     }
/*    */     
/* 23 */     Minecraft minecraft = Minecraft.func_71410_x();
/*    */     
/* 25 */     double d1 = 0.0D;
/* 26 */     if (minecraft.field_71441_e != null && minecraft.field_71439_g != null) {
/* 27 */       float f = minecraft.field_71441_e.func_72826_c(1.0F);
/* 28 */       d1 = f;
/* 29 */       if (!minecraft.field_71441_e.field_73011_w.func_76569_d()) {
/* 30 */         d1 = Math.random();
/*    */       }
/*    */     } 
/*    */     
/* 34 */     double d2 = d1 - this.field_94239_h;
/* 35 */     while (d2 < -0.5D)
/* 36 */       d2++; 
/* 37 */     while (d2 >= 0.5D)
/* 38 */       d2--; 
/* 39 */     if (d2 < -1.0D) d2 = -1.0D; 
/* 40 */     if (d2 > 1.0D) d2 = 1.0D; 
/* 41 */     this.field_94240_i += d2 * 0.1D;
/* 42 */     this.field_94240_i *= 0.8D;
/*    */     
/* 44 */     this.field_94239_h += this.field_94240_i;
/*    */     
/* 46 */     int i = (int)((this.field_94239_h + 1.0D) * this.field_110976_a.size()) % this.field_110976_a.size();
/* 47 */     while (i < 0) {
/* 48 */       i = (i + this.field_110976_a.size()) % this.field_110976_a.size();
/*    */     }
/* 50 */     if (i != this.field_110973_g) {
/* 51 */       this.field_110973_g = i;
/* 52 */       TextureUtil.func_147955_a(this.field_110976_a.get(this.field_110973_g), this.field_130223_c, this.field_130224_d, this.field_110975_c, this.field_110974_d, false, false);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\texture\TextureClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */