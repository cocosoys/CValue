/*     */ package net.minecraft.tileentity;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Facing;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TileEntityPiston
/*     */   extends TileEntity
/*     */ {
/*     */   private Block field_145869_a;
/*     */   private int field_145876_i;
/*     */   private int field_145874_j;
/*     */   private boolean field_145875_k;
/*     */   private boolean field_145872_l;
/*     */   private float field_145873_m;
/*     */   private float field_145870_n;
/*     */   
/*     */   public TileEntityPiston(Block p_i45444_1_, int p_i45444_2_, int p_i45444_3_, boolean p_i45444_4_, boolean p_i45444_5_) {
/*  28 */     this.field_145869_a = p_i45444_1_;
/*  29 */     this.field_145876_i = p_i45444_2_;
/*  30 */     this.field_145874_j = p_i45444_3_;
/*  31 */     this.field_145875_k = p_i45444_4_;
/*  32 */     this.field_145872_l = p_i45444_5_;
/*     */   }
/*     */ 
/*     */   
/*     */   public Block func_145861_a() {
/*  37 */     return this.field_145869_a;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_145832_p() {
/*  42 */     return this.field_145876_i;
/*     */   }
/*     */   
/*     */   public boolean func_145868_b() {
/*  46 */     return this.field_145875_k;
/*     */   }
/*     */   
/*     */   public int func_145864_c() {
/*  50 */     return this.field_145874_j;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_145867_d() {
/*  54 */     return this.field_145872_l;
/*     */   }
/*     */   
/*     */   public float func_145860_a(float p_145860_1_) {
/*  58 */     if (p_145860_1_ > 1.0F) {
/*  59 */       p_145860_1_ = 1.0F;
/*     */     }
/*  61 */     return this.field_145870_n + (this.field_145873_m - this.field_145870_n) * p_145860_1_;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_145865_b(float p_145865_1_) {
/*  65 */     if (this.field_145875_k) {
/*  66 */       return (func_145860_a(p_145865_1_) - 1.0F) * Facing.field_71586_b[this.field_145874_j];
/*     */     }
/*  68 */     return (1.0F - func_145860_a(p_145865_1_)) * Facing.field_71586_b[this.field_145874_j];
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_145862_c(float p_145862_1_) {
/*  73 */     if (this.field_145875_k) {
/*  74 */       return (func_145860_a(p_145862_1_) - 1.0F) * Facing.field_71587_c[this.field_145874_j];
/*     */     }
/*  76 */     return (1.0F - func_145860_a(p_145862_1_)) * Facing.field_71587_c[this.field_145874_j];
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_145859_d(float p_145859_1_) {
/*  81 */     if (this.field_145875_k) {
/*  82 */       return (func_145860_a(p_145859_1_) - 1.0F) * Facing.field_71585_d[this.field_145874_j];
/*     */     }
/*  84 */     return (1.0F - func_145860_a(p_145859_1_)) * Facing.field_71585_d[this.field_145874_j];
/*     */   }
/*     */ 
/*     */   
/*  88 */   private List field_145871_o = new ArrayList(); private static final String __OBFID = "CL_00000369";
/*     */   
/*     */   private void func_145863_a(float p_145863_1_, float p_145863_2_) {
/*  91 */     if (this.field_145875_k) {
/*  92 */       p_145863_1_ = 1.0F - p_145863_1_;
/*     */     } else {
/*  94 */       p_145863_1_--;
/*     */     } 
/*     */ 
/*     */     
/*  98 */     AxisAlignedBB axisAlignedBB = Blocks.field_150326_M.func_149964_a(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e, this.field_145869_a, p_145863_1_, this.field_145874_j);
/*  99 */     if (axisAlignedBB != null) {
/*     */       
/* 101 */       List list = this.field_145850_b.func_72839_b(null, axisAlignedBB);
/* 102 */       if (!list.isEmpty()) {
/* 103 */         this.field_145871_o.addAll(list);
/*     */         
/* 105 */         for (Entity entity : this.field_145871_o) {
/* 106 */           entity.func_70091_d((p_145863_2_ * Facing.field_71586_b[this.field_145874_j]), (p_145863_2_ * Facing.field_71587_c[this.field_145874_j]), (p_145863_2_ * Facing.field_71585_d[this.field_145874_j]));
/*     */         }
/* 108 */         this.field_145871_o.clear();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_145866_f() {
/* 114 */     if (this.field_145870_n < 1.0F && this.field_145850_b != null) {
/* 115 */       this.field_145870_n = this.field_145873_m = 1.0F;
/* 116 */       this.field_145850_b.func_147475_p(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 117 */       func_145843_s();
/* 118 */       if (this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d, this.field_145849_e) == Blocks.field_150326_M) {
/* 119 */         this.field_145850_b.func_147465_d(this.field_145851_c, this.field_145848_d, this.field_145849_e, this.field_145869_a, this.field_145876_i, 3);
/* 120 */         this.field_145850_b.func_147460_e(this.field_145851_c, this.field_145848_d, this.field_145849_e, this.field_145869_a);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 127 */     this.field_145870_n = this.field_145873_m;
/*     */     
/* 129 */     if (this.field_145870_n >= 1.0F) {
/* 130 */       func_145863_a(1.0F, 0.25F);
/* 131 */       this.field_145850_b.func_147475_p(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 132 */       func_145843_s();
/* 133 */       if (this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d, this.field_145849_e) == Blocks.field_150326_M) {
/* 134 */         this.field_145850_b.func_147465_d(this.field_145851_c, this.field_145848_d, this.field_145849_e, this.field_145869_a, this.field_145876_i, 3);
/* 135 */         this.field_145850_b.func_147460_e(this.field_145851_c, this.field_145848_d, this.field_145849_e, this.field_145869_a);
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/* 140 */     this.field_145873_m += 0.5F;
/* 141 */     if (this.field_145873_m >= 1.0F) {
/* 142 */       this.field_145873_m = 1.0F;
/*     */     }
/*     */     
/* 145 */     if (this.field_145875_k) {
/* 146 */       func_145863_a(this.field_145873_m, this.field_145873_m - this.field_145870_n + 0.0625F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/* 153 */     super.func_145839_a(p_145839_1_);
/*     */     
/* 155 */     this.field_145869_a = Block.func_149729_e(p_145839_1_.func_74762_e("blockId"));
/* 156 */     this.field_145876_i = p_145839_1_.func_74762_e("blockData");
/* 157 */     this.field_145874_j = p_145839_1_.func_74762_e("facing");
/* 158 */     this.field_145870_n = this.field_145873_m = p_145839_1_.func_74760_g("progress");
/* 159 */     this.field_145875_k = p_145839_1_.func_74767_n("extending");
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/* 164 */     super.func_145841_b(p_145841_1_);
/*     */     
/* 166 */     p_145841_1_.func_74768_a("blockId", Block.func_149682_b(this.field_145869_a));
/* 167 */     p_145841_1_.func_74768_a("blockData", this.field_145876_i);
/* 168 */     p_145841_1_.func_74768_a("facing", this.field_145874_j);
/* 169 */     p_145841_1_.func_74776_a("progress", this.field_145870_n);
/* 170 */     p_145841_1_.func_74757_a("extending", this.field_145875_k);
/*     */   }
/*     */   
/*     */   public TileEntityPiston() {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntityPiston.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */