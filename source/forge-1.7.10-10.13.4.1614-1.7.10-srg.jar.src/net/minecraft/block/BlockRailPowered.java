/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockRailPowered extends BlockRailBase {
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected IIcon field_150059_b;
/*     */   
/*     */   protected BlockRailPowered() {
/*  11 */     super(true);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000288";
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  16 */     if ((p_149691_2_ & 0x8) == 0) {
/*  17 */       return this.field_149761_L;
/*     */     }
/*  19 */     return this.field_150059_b;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/*  25 */     super.func_149651_a(p_149651_1_);
/*  26 */     this.field_150059_b = p_149651_1_.func_94245_a(func_149641_N() + "_powered");
/*     */   }
/*     */   
/*     */   protected boolean func_150058_a(World p_150058_1_, int p_150058_2_, int p_150058_3_, int p_150058_4_, int p_150058_5_, boolean p_150058_6_, int p_150058_7_) {
/*  30 */     if (p_150058_7_ >= 8) {
/*  31 */       return false;
/*     */     }
/*     */     
/*  34 */     int i = p_150058_5_ & 0x7;
/*     */     
/*  36 */     boolean bool = true;
/*  37 */     switch (i) {
/*     */       case 0:
/*  39 */         if (p_150058_6_) {
/*  40 */           p_150058_4_++; break;
/*     */         } 
/*  42 */         p_150058_4_--;
/*     */         break;
/*     */       
/*     */       case 1:
/*  46 */         if (p_150058_6_) {
/*  47 */           p_150058_2_--; break;
/*     */         } 
/*  49 */         p_150058_2_++;
/*     */         break;
/*     */       
/*     */       case 2:
/*  53 */         if (p_150058_6_) {
/*  54 */           p_150058_2_--;
/*     */         } else {
/*  56 */           p_150058_2_++;
/*  57 */           p_150058_3_++;
/*  58 */           bool = false;
/*     */         } 
/*  60 */         i = 1;
/*     */         break;
/*     */       case 3:
/*  63 */         if (p_150058_6_) {
/*  64 */           p_150058_2_--;
/*  65 */           p_150058_3_++;
/*  66 */           bool = false;
/*     */         } else {
/*  68 */           p_150058_2_++;
/*     */         } 
/*  70 */         i = 1;
/*     */         break;
/*     */       case 4:
/*  73 */         if (p_150058_6_) {
/*  74 */           p_150058_4_++;
/*     */         } else {
/*  76 */           p_150058_4_--;
/*  77 */           p_150058_3_++;
/*  78 */           bool = false;
/*     */         } 
/*  80 */         i = 0;
/*     */         break;
/*     */       case 5:
/*  83 */         if (p_150058_6_) {
/*  84 */           p_150058_4_++;
/*  85 */           p_150058_3_++;
/*  86 */           bool = false;
/*     */         } else {
/*  88 */           p_150058_4_--;
/*     */         } 
/*  90 */         i = 0;
/*     */         break;
/*     */     } 
/*     */     
/*  94 */     if (func_150057_a(p_150058_1_, p_150058_2_, p_150058_3_, p_150058_4_, p_150058_6_, p_150058_7_, i)) {
/*  95 */       return true;
/*     */     }
/*  97 */     if (bool && func_150057_a(p_150058_1_, p_150058_2_, p_150058_3_ - 1, p_150058_4_, p_150058_6_, p_150058_7_, i)) {
/*  98 */       return true;
/*     */     }
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean func_150057_a(World p_150057_1_, int p_150057_2_, int p_150057_3_, int p_150057_4_, boolean p_150057_5_, int p_150057_6_, int p_150057_7_) {
/* 104 */     Block block = p_150057_1_.func_147439_a(p_150057_2_, p_150057_3_, p_150057_4_);
/*     */     
/* 106 */     if (block == this) {
/* 107 */       int i = p_150057_1_.func_72805_g(p_150057_2_, p_150057_3_, p_150057_4_);
/* 108 */       int j = i & 0x7;
/*     */       
/* 110 */       if (p_150057_7_ == 1 && (j == 0 || j == 4 || j == 5)) {
/* 111 */         return false;
/*     */       }
/* 113 */       if (p_150057_7_ == 0 && (j == 1 || j == 2 || j == 3)) {
/* 114 */         return false;
/*     */       }
/*     */       
/* 117 */       if ((i & 0x8) != 0) {
/* 118 */         if (p_150057_1_.func_72864_z(p_150057_2_, p_150057_3_, p_150057_4_)) {
/* 119 */           return true;
/*     */         }
/* 121 */         return func_150058_a(p_150057_1_, p_150057_2_, p_150057_3_, p_150057_4_, i, p_150057_5_, p_150057_6_ + 1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 126 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_150048_a(World p_150048_1_, int p_150048_2_, int p_150048_3_, int p_150048_4_, int p_150048_5_, int p_150048_6_, Block p_150048_7_) {
/* 131 */     boolean bool = p_150048_1_.func_72864_z(p_150048_2_, p_150048_3_, p_150048_4_);
/* 132 */     bool = (bool || func_150058_a(p_150048_1_, p_150048_2_, p_150048_3_, p_150048_4_, p_150048_5_, true, 0) || func_150058_a(p_150048_1_, p_150048_2_, p_150048_3_, p_150048_4_, p_150048_5_, false, 0));
/*     */     
/* 134 */     boolean bool1 = false;
/* 135 */     if (bool && (p_150048_5_ & 0x8) == 0) {
/* 136 */       p_150048_1_.func_72921_c(p_150048_2_, p_150048_3_, p_150048_4_, p_150048_6_ | 0x8, 3);
/* 137 */       bool1 = true;
/* 138 */     } else if (!bool && (p_150048_5_ & 0x8) != 0) {
/* 139 */       p_150048_1_.func_72921_c(p_150048_2_, p_150048_3_, p_150048_4_, p_150048_6_, 3);
/* 140 */       bool1 = true;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 146 */     if (bool1) {
/* 147 */       p_150048_1_.func_147459_d(p_150048_2_, p_150048_3_ - 1, p_150048_4_, this);
/* 148 */       if (p_150048_6_ == 2 || p_150048_6_ == 3 || p_150048_6_ == 4 || p_150048_6_ == 5)
/* 149 */         p_150048_1_.func_147459_d(p_150048_2_, p_150048_3_ + 1, p_150048_4_, this); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockRailPowered.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */