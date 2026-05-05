/*    */ package net.minecraft.client.renderer.texture;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.ChunkCoordinates;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class TextureCompass
/*    */   extends TextureAtlasSprite {
/*    */   public double field_94244_i;
/*    */   
/*    */   public TextureCompass(String p_i1286_1_) {
/* 15 */     super(p_i1286_1_);
/*    */   }
/*    */   public double field_94242_j; private static final String __OBFID = "CL_00001071";
/*    */   
/*    */   public void func_94219_l() {
/* 20 */     Minecraft minecraft = Minecraft.func_71410_x();
/*    */     
/* 22 */     if (minecraft.field_71441_e != null && minecraft.field_71439_g != null) {
/* 23 */       func_94241_a((World)minecraft.field_71441_e, minecraft.field_71439_g.field_70165_t, minecraft.field_71439_g.field_70161_v, minecraft.field_71439_g.field_70177_z, false, false);
/*    */     } else {
/* 25 */       func_94241_a((World)null, 0.0D, 0.0D, 0.0D, true, false);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94241_a(World p_94241_1_, double p_94241_2_, double p_94241_4_, double p_94241_6_, boolean p_94241_8_, boolean p_94241_9_) {
/* 32 */     if (this.field_110976_a.isEmpty()) {
/*    */       return;
/*    */     }
/*    */     
/* 36 */     double d = 0.0D;
/* 37 */     if (p_94241_1_ != null && !p_94241_8_) {
/* 38 */       ChunkCoordinates chunkCoordinates = p_94241_1_.func_72861_E();
/* 39 */       double d1 = chunkCoordinates.field_71574_a - p_94241_2_;
/* 40 */       double d2 = chunkCoordinates.field_71573_c - p_94241_4_;
/* 41 */       p_94241_6_ %= 360.0D;
/* 42 */       d = -((p_94241_6_ - 90.0D) * Math.PI / 180.0D - Math.atan2(d2, d1));
/* 43 */       if (!p_94241_1_.field_73011_w.func_76569_d()) {
/* 44 */         d = Math.random() * 3.1415927410125732D * 2.0D;
/*    */       }
/*    */     } 
/*    */     
/* 48 */     if (p_94241_9_) {
/* 49 */       this.field_94244_i = d;
/*    */     } else {
/* 51 */       double d1 = d - this.field_94244_i;
/* 52 */       while (d1 < -3.141592653589793D)
/* 53 */         d1 += 6.283185307179586D; 
/* 54 */       while (d1 >= Math.PI)
/* 55 */         d1 -= 6.283185307179586D; 
/* 56 */       if (d1 < -1.0D) d1 = -1.0D; 
/* 57 */       if (d1 > 1.0D) d1 = 1.0D; 
/* 58 */       this.field_94242_j += d1 * 0.1D;
/* 59 */       this.field_94242_j *= 0.8D;
/* 60 */       this.field_94244_i += this.field_94242_j;
/*    */     } 
/*    */     
/* 63 */     int i = (int)((this.field_94244_i / 6.283185307179586D + 1.0D) * this.field_110976_a.size()) % this.field_110976_a.size();
/* 64 */     while (i < 0) {
/* 65 */       i = (i + this.field_110976_a.size()) % this.field_110976_a.size();
/*    */     }
/* 67 */     if (i != this.field_110973_g) {
/* 68 */       this.field_110973_g = i;
/* 69 */       TextureUtil.func_147955_a(this.field_110976_a.get(this.field_110973_g), this.field_130223_c, this.field_130224_d, this.field_110975_c, this.field_110974_d, false, false);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\texture\TextureCompass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */