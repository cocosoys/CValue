/*     */ package net.minecraft.world.gen.structure;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockLever;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.monster.EntityWitch;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.util.WeightedRandomChestContent;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ComponentScatteredFeaturePieces {
/*     */   public static void func_143045_a() {
/*  16 */     MapGenStructureIO.func_143031_a(DesertPyramid.class, "TeDP");
/*  17 */     MapGenStructureIO.func_143031_a(JunglePyramid.class, "TeJP");
/*  18 */     MapGenStructureIO.func_143031_a(SwampHut.class, "TeSH");
/*     */   }
/*     */   
/*     */   private static final String __OBFID = "CL_00000473";
/*     */   
/*     */   static abstract class Feature extends StructureComponent {
/*     */     protected int field_74939_a;
/*     */     protected int field_74937_b;
/*     */     protected int field_74938_c;
/*  27 */     protected int field_74936_d = -1;
/*     */     
/*     */     private static final String __OBFID = "CL_00000479";
/*     */     
/*     */     public Feature() {}
/*     */     
/*     */     protected Feature(Random p_i2065_1_, int p_i2065_2_, int p_i2065_3_, int p_i2065_4_, int p_i2065_5_, int p_i2065_6_, int p_i2065_7_) {
/*  34 */       super(0);
/*     */       
/*  36 */       this.field_74939_a = p_i2065_5_;
/*  37 */       this.field_74937_b = p_i2065_6_;
/*  38 */       this.field_74938_c = p_i2065_7_;
/*     */       
/*  40 */       this.field_74885_f = p_i2065_1_.nextInt(4);
/*     */       
/*  42 */       switch (this.field_74885_f) {
/*     */         case 0:
/*     */         case 2:
/*  45 */           this.field_74887_e = new StructureBoundingBox(p_i2065_2_, p_i2065_3_, p_i2065_4_, p_i2065_2_ + p_i2065_5_ - 1, p_i2065_3_ + p_i2065_6_ - 1, p_i2065_4_ + p_i2065_7_ - 1);
/*     */           return;
/*     */       } 
/*  48 */       this.field_74887_e = new StructureBoundingBox(p_i2065_2_, p_i2065_3_, p_i2065_4_, p_i2065_2_ + p_i2065_7_ - 1, p_i2065_3_ + p_i2065_6_ - 1, p_i2065_4_ + p_i2065_5_ - 1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/*  55 */       p_143012_1_.func_74768_a("Width", this.field_74939_a);
/*  56 */       p_143012_1_.func_74768_a("Height", this.field_74937_b);
/*  57 */       p_143012_1_.func_74768_a("Depth", this.field_74938_c);
/*  58 */       p_143012_1_.func_74768_a("HPos", this.field_74936_d);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/*  63 */       this.field_74939_a = p_143011_1_.func_74762_e("Width");
/*  64 */       this.field_74937_b = p_143011_1_.func_74762_e("Height");
/*  65 */       this.field_74938_c = p_143011_1_.func_74762_e("Depth");
/*  66 */       this.field_74936_d = p_143011_1_.func_74762_e("HPos");
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean func_74935_a(World p_74935_1_, StructureBoundingBox p_74935_2_, int p_74935_3_) {
/*  71 */       if (this.field_74936_d >= 0) {
/*  72 */         return true;
/*     */       }
/*     */       
/*  75 */       int i = 0;
/*  76 */       byte b = 0;
/*  77 */       for (int j = this.field_74887_e.field_78896_c; j <= this.field_74887_e.field_78892_f; j++) {
/*  78 */         for (int k = this.field_74887_e.field_78897_a; k <= this.field_74887_e.field_78893_d; k++) {
/*  79 */           if (p_74935_2_.func_78890_b(k, 64, j)) {
/*  80 */             i += Math.max(p_74935_1_.func_72825_h(k, j), p_74935_1_.field_73011_w.func_76557_i());
/*  81 */             b++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  86 */       if (b == 0) {
/*  87 */         return false;
/*     */       }
/*  89 */       this.field_74936_d = i / b;
/*  90 */       this.field_74887_e.func_78886_a(0, this.field_74936_d - this.field_74887_e.field_78895_b + p_74935_3_, 0);
/*  91 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class DesertPyramid
/*     */     extends Feature
/*     */   {
/*  99 */     private boolean[] field_74940_h = new boolean[4];
/*     */ 
/*     */     
/* 102 */     public static final WeightedRandomChestContent[] field_74941_i = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.field_151045_i, 0, 1, 3, 3), new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 5, 10), new WeightedRandomChestContent(Items.field_151043_k, 0, 2, 7, 15), new WeightedRandomChestContent(Items.field_151166_bC, 0, 1, 3, 2), new WeightedRandomChestContent(Items.field_151103_aS, 0, 4, 6, 20), new WeightedRandomChestContent(Items.field_151078_bh, 0, 3, 7, 16), new WeightedRandomChestContent(Items.field_151141_av, 0, 1, 1, 3), new WeightedRandomChestContent(Items.field_151138_bX, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151136_bY, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151125_bZ, 0, 1, 1, 1) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final String __OBFID = "CL_00000476";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DesertPyramid() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DesertPyramid(Random p_i2062_1_, int p_i2062_2_, int p_i2062_3_) {
/* 124 */       super(p_i2062_1_, p_i2062_2_, 64, p_i2062_3_, 21, 15, 21);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/* 129 */       super.func_143012_a(p_143012_1_);
/* 130 */       p_143012_1_.func_74757_a("hasPlacedChest0", this.field_74940_h[0]);
/* 131 */       p_143012_1_.func_74757_a("hasPlacedChest1", this.field_74940_h[1]);
/* 132 */       p_143012_1_.func_74757_a("hasPlacedChest2", this.field_74940_h[2]);
/* 133 */       p_143012_1_.func_74757_a("hasPlacedChest3", this.field_74940_h[3]);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/* 138 */       super.func_143011_b(p_143011_1_);
/* 139 */       this.field_74940_h[0] = p_143011_1_.func_74767_n("hasPlacedChest0");
/* 140 */       this.field_74940_h[1] = p_143011_1_.func_74767_n("hasPlacedChest1");
/* 141 */       this.field_74940_h[2] = p_143011_1_.func_74767_n("hasPlacedChest2");
/* 142 */       this.field_74940_h[3] = p_143011_1_.func_74767_n("hasPlacedChest3");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 149 */       func_151549_a(p_74875_1_, p_74875_3_, 0, -4, 0, this.field_74939_a - 1, 0, this.field_74938_c - 1, Blocks.field_150322_A, Blocks.field_150322_A, false); int i;
/* 150 */       for (i = 1; i <= 9; i++) {
/* 151 */         func_151549_a(p_74875_1_, p_74875_3_, i, i, i, this.field_74939_a - 1 - i, i, this.field_74938_c - 1 - i, Blocks.field_150322_A, Blocks.field_150322_A, false);
/* 152 */         func_151549_a(p_74875_1_, p_74875_3_, i + 1, i, i + 1, this.field_74939_a - 2 - i, i, this.field_74938_c - 2 - i, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*     */       } 
/* 154 */       for (i = 0; i < this.field_74939_a; i++) {
/* 155 */         for (byte b1 = 0; b1 < this.field_74938_c; b1++) {
/* 156 */           byte b2 = -5;
/* 157 */           func_151554_b(p_74875_1_, Blocks.field_150322_A, 0, i, b2, b1, p_74875_3_);
/*     */         } 
/*     */       } 
/*     */       
/* 161 */       i = func_151555_a(Blocks.field_150372_bz, 3);
/* 162 */       int j = func_151555_a(Blocks.field_150372_bz, 2);
/* 163 */       int k = func_151555_a(Blocks.field_150372_bz, 0);
/* 164 */       int m = func_151555_a(Blocks.field_150372_bz, 1);
/* 165 */       boolean bool = true;
/* 166 */       byte b = 11;
/*     */ 
/*     */       
/* 169 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 9, 4, Blocks.field_150322_A, Blocks.field_150350_a, false);
/* 170 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 10, 1, 3, 10, 3, Blocks.field_150322_A, Blocks.field_150322_A, false);
/* 171 */       func_151550_a(p_74875_1_, Blocks.field_150372_bz, i, 2, 10, 0, p_74875_3_);
/* 172 */       func_151550_a(p_74875_1_, Blocks.field_150372_bz, j, 2, 10, 4, p_74875_3_);
/* 173 */       func_151550_a(p_74875_1_, Blocks.field_150372_bz, k, 0, 10, 2, p_74875_3_);
/* 174 */       func_151550_a(p_74875_1_, Blocks.field_150372_bz, m, 4, 10, 2, p_74875_3_);
/* 175 */       func_151549_a(p_74875_1_, p_74875_3_, this.field_74939_a - 5, 0, 0, this.field_74939_a - 1, 9, 4, Blocks.field_150322_A, Blocks.field_150350_a, false);
/* 176 */       func_151549_a(p_74875_1_, p_74875_3_, this.field_74939_a - 4, 10, 1, this.field_74939_a - 2, 10, 3, Blocks.field_150322_A, Blocks.field_150322_A, false);
/* 177 */       func_151550_a(p_74875_1_, Blocks.field_150372_bz, i, this.field_74939_a - 3, 10, 0, p_74875_3_);
/* 178 */       func_151550_a(p_74875_1_, Blocks.field_150372_bz, j, this.field_74939_a - 3, 10, 4, p_74875_3_);
/* 179 */       func_151550_a(p_74875_1_, Blocks.field_150372_bz, k, this.field_74939_a - 5, 10, 2, p_74875_3_);
/* 180 */       func_151550_a(p_74875_1_, Blocks.field_150372_bz, m, this.field_74939_a - 1, 10, 2, p_74875_3_);
/*     */ 
/*     */       
/* 183 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 0, 0, 12, 4, 4, Blocks.field_150322_A, Blocks.field_150350_a, false);
/* 184 */       func_151549_a(p_74875_1_, p_74875_3_, 9, 1, 0, 11, 3, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 185 */       func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, 9, 1, 1, p_74875_3_);
/* 186 */       func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, 9, 2, 1, p_74875_3_);
/* 187 */       func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, 9, 3, 1, p_74875_3_);
/* 188 */       func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, 10, 3, 1, p_74875_3_);
/* 189 */       func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, 11, 3, 1, p_74875_3_);
/* 190 */       func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, 11, 2, 1, p_74875_3_);
/* 191 */       func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, 11, 1, 1, p_74875_3_);
/*     */ 
/*     */       
/* 194 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 1, 8, 3, 3, Blocks.field_150322_A, Blocks.field_150350_a, false);
/* 195 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 2, 8, 2, 2, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 196 */       func_151549_a(p_74875_1_, p_74875_3_, 12, 1, 1, 16, 3, 3, Blocks.field_150322_A, Blocks.field_150350_a, false);
/* 197 */       func_151549_a(p_74875_1_, p_74875_3_, 12, 1, 2, 16, 2, 2, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*     */ 
/*     */       
/* 200 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 4, 5, this.field_74939_a - 6, 4, this.field_74938_c - 6, Blocks.field_150322_A, Blocks.field_150322_A, false);
/* 201 */       func_151549_a(p_74875_1_, p_74875_3_, 9, 4, 9, 11, 4, 11, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 202 */       func_151556_a(p_74875_1_, p_74875_3_, 8, 1, 8, 8, 3, 8, Blocks.field_150322_A, 2, Blocks.field_150322_A, 2, false);
/* 203 */       func_151556_a(p_74875_1_, p_74875_3_, 12, 1, 8, 12, 3, 8, Blocks.field_150322_A, 2, Blocks.field_150322_A, 2, false);
/* 204 */       func_151556_a(p_74875_1_, p_74875_3_, 8, 1, 12, 8, 3, 12, Blocks.field_150322_A, 2, Blocks.field_150322_A, 2, false);
/* 205 */       func_151556_a(p_74875_1_, p_74875_3_, 12, 1, 12, 12, 3, 12, Blocks.field_150322_A, 2, Blocks.field_150322_A, 2, false);
/*     */ 
/*     */       
/* 208 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 5, 4, 4, 11, Blocks.field_150322_A, Blocks.field_150322_A, false);
/* 209 */       func_151549_a(p_74875_1_, p_74875_3_, this.field_74939_a - 5, 1, 5, this.field_74939_a - 2, 4, 11, Blocks.field_150322_A, Blocks.field_150322_A, false);
/* 210 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 7, 9, 6, 7, 11, Blocks.field_150322_A, Blocks.field_150322_A, false);
/* 211 */       func_151549_a(p_74875_1_, p_74875_3_, this.field_74939_a - 7, 7, 9, this.field_74939_a - 7, 7, 11, Blocks.field_150322_A, Blocks.field_150322_A, false);
/* 212 */       func_151556_a(p_74875_1_, p_74875_3_, 5, 5, 9, 5, 7, 11, Blocks.field_150322_A, 2, Blocks.field_150322_A, 2, false);
/* 213 */       func_151556_a(p_74875_1_, p_74875_3_, this.field_74939_a - 6, 5, 9, this.field_74939_a - 6, 7, 11, Blocks.field_150322_A, 2, Blocks.field_150322_A, 2, false);
/* 214 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 5, 5, 10, p_74875_3_);
/* 215 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 5, 6, 10, p_74875_3_);
/* 216 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 6, 6, 10, p_74875_3_);
/* 217 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, this.field_74939_a - 6, 5, 10, p_74875_3_);
/* 218 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, this.field_74939_a - 6, 6, 10, p_74875_3_);
/* 219 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, this.field_74939_a - 7, 6, 10, p_74875_3_);
/*     */ 
/*     */       
/* 222 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 4, 4, 2, 6, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 223 */       func_151549_a(p_74875_1_, p_74875_3_, this.field_74939_a - 3, 4, 4, this.field_74939_a - 3, 6, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 224 */       func_151550_a(p_74875_1_, Blocks.field_150372_bz, i, 2, 4, 5, p_74875_3_);
/* 225 */       func_151550_a(p_74875_1_, Blocks.field_150372_bz, i, 2, 3, 4, p_74875_3_);
/* 226 */       func_151550_a(p_74875_1_, Blocks.field_150372_bz, i, this.field_74939_a - 3, 4, 5, p_74875_3_);
/* 227 */       func_151550_a(p_74875_1_, Blocks.field_150372_bz, i, this.field_74939_a - 3, 3, 4, p_74875_3_);
/* 228 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 3, 2, 2, 3, Blocks.field_150322_A, Blocks.field_150322_A, false);
/* 229 */       func_151549_a(p_74875_1_, p_74875_3_, this.field_74939_a - 3, 1, 3, this.field_74939_a - 2, 2, 3, Blocks.field_150322_A, Blocks.field_150322_A, false);
/* 230 */       func_151550_a(p_74875_1_, Blocks.field_150372_bz, 0, 1, 1, 2, p_74875_3_);
/* 231 */       func_151550_a(p_74875_1_, Blocks.field_150372_bz, 0, this.field_74939_a - 2, 1, 2, p_74875_3_);
/* 232 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 1, 1, 2, 2, p_74875_3_);
/* 233 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 1, this.field_74939_a - 2, 2, 2, p_74875_3_);
/* 234 */       func_151550_a(p_74875_1_, Blocks.field_150372_bz, m, 2, 1, 2, p_74875_3_);
/* 235 */       func_151550_a(p_74875_1_, Blocks.field_150372_bz, k, this.field_74939_a - 3, 1, 2, p_74875_3_);
/*     */ 
/*     */       
/* 238 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 3, 5, 4, 3, 18, Blocks.field_150322_A, Blocks.field_150322_A, false);
/* 239 */       func_151549_a(p_74875_1_, p_74875_3_, this.field_74939_a - 5, 3, 5, this.field_74939_a - 5, 3, 17, Blocks.field_150322_A, Blocks.field_150322_A, false);
/* 240 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 1, 5, 4, 2, 16, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 241 */       func_151549_a(p_74875_1_, p_74875_3_, this.field_74939_a - 6, 1, 5, this.field_74939_a - 5, 2, 16, Blocks.field_150350_a, Blocks.field_150350_a, false); int n;
/* 242 */       for (n = 5; n <= 17; n += 2) {
/* 243 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, 4, 1, n, p_74875_3_);
/* 244 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 1, 4, 2, n, p_74875_3_);
/* 245 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, this.field_74939_a - 5, 1, n, p_74875_3_);
/* 246 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 1, this.field_74939_a - 5, 2, n, p_74875_3_);
/*     */       } 
/* 248 */       func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, 10, 0, 7, p_74875_3_);
/* 249 */       func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, 10, 0, 8, p_74875_3_);
/* 250 */       func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, 9, 0, 9, p_74875_3_);
/* 251 */       func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, 11, 0, 9, p_74875_3_);
/* 252 */       func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, 8, 0, 10, p_74875_3_);
/* 253 */       func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, 12, 0, 10, p_74875_3_);
/* 254 */       func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, 7, 0, 10, p_74875_3_);
/* 255 */       func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, 13, 0, 10, p_74875_3_);
/* 256 */       func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, 9, 0, 11, p_74875_3_);
/* 257 */       func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, 11, 0, 11, p_74875_3_);
/* 258 */       func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, 10, 0, 12, p_74875_3_);
/* 259 */       func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, 10, 0, 13, p_74875_3_);
/* 260 */       func_151550_a(p_74875_1_, Blocks.field_150325_L, b, 10, 0, 10, p_74875_3_);
/*     */ 
/*     */       
/* 263 */       for (n = 0; n <= this.field_74939_a - 1; n += this.field_74939_a - 1) {
/* 264 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n, 2, 1, p_74875_3_);
/* 265 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n, 2, 2, p_74875_3_);
/* 266 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n, 2, 3, p_74875_3_);
/* 267 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n, 3, 1, p_74875_3_);
/* 268 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n, 3, 2, p_74875_3_);
/* 269 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n, 3, 3, p_74875_3_);
/* 270 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n, 4, 1, p_74875_3_);
/* 271 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 1, n, 4, 2, p_74875_3_);
/* 272 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n, 4, 3, p_74875_3_);
/* 273 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n, 5, 1, p_74875_3_);
/* 274 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n, 5, 2, p_74875_3_);
/* 275 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n, 5, 3, p_74875_3_);
/* 276 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n, 6, 1, p_74875_3_);
/* 277 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 1, n, 6, 2, p_74875_3_);
/* 278 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n, 6, 3, p_74875_3_);
/* 279 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n, 7, 1, p_74875_3_);
/* 280 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n, 7, 2, p_74875_3_);
/* 281 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n, 7, 3, p_74875_3_);
/* 282 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n, 8, 1, p_74875_3_);
/* 283 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n, 8, 2, p_74875_3_);
/* 284 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n, 8, 3, p_74875_3_);
/*     */       } 
/* 286 */       for (n = 2; n <= this.field_74939_a - 3; n += this.field_74939_a - 3 - 2) {
/* 287 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n - 1, 2, 0, p_74875_3_);
/* 288 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n, 2, 0, p_74875_3_);
/* 289 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n + 1, 2, 0, p_74875_3_);
/* 290 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n - 1, 3, 0, p_74875_3_);
/* 291 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n, 3, 0, p_74875_3_);
/* 292 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n + 1, 3, 0, p_74875_3_);
/* 293 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n - 1, 4, 0, p_74875_3_);
/* 294 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 1, n, 4, 0, p_74875_3_);
/* 295 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n + 1, 4, 0, p_74875_3_);
/* 296 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n - 1, 5, 0, p_74875_3_);
/* 297 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n, 5, 0, p_74875_3_);
/* 298 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n + 1, 5, 0, p_74875_3_);
/* 299 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n - 1, 6, 0, p_74875_3_);
/* 300 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 1, n, 6, 0, p_74875_3_);
/* 301 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n + 1, 6, 0, p_74875_3_);
/* 302 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n - 1, 7, 0, p_74875_3_);
/* 303 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n, 7, 0, p_74875_3_);
/* 304 */         func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, n + 1, 7, 0, p_74875_3_);
/* 305 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n - 1, 8, 0, p_74875_3_);
/* 306 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n, 8, 0, p_74875_3_);
/* 307 */         func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, n + 1, 8, 0, p_74875_3_);
/*     */       } 
/* 309 */       func_151556_a(p_74875_1_, p_74875_3_, 8, 4, 0, 12, 6, 0, Blocks.field_150322_A, 2, Blocks.field_150322_A, 2, false);
/* 310 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 8, 6, 0, p_74875_3_);
/* 311 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 12, 6, 0, p_74875_3_);
/* 312 */       func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, 9, 5, 0, p_74875_3_);
/* 313 */       func_151550_a(p_74875_1_, Blocks.field_150322_A, 1, 10, 5, 0, p_74875_3_);
/* 314 */       func_151550_a(p_74875_1_, Blocks.field_150325_L, bool, 11, 5, 0, p_74875_3_);
/*     */ 
/*     */       
/* 317 */       func_151556_a(p_74875_1_, p_74875_3_, 8, -14, 8, 12, -11, 12, Blocks.field_150322_A, 2, Blocks.field_150322_A, 2, false);
/* 318 */       func_151556_a(p_74875_1_, p_74875_3_, 8, -10, 8, 12, -10, 12, Blocks.field_150322_A, 1, Blocks.field_150322_A, 1, false);
/* 319 */       func_151556_a(p_74875_1_, p_74875_3_, 8, -9, 8, 12, -9, 12, Blocks.field_150322_A, 2, Blocks.field_150322_A, 2, false);
/* 320 */       func_151549_a(p_74875_1_, p_74875_3_, 8, -8, 8, 12, -1, 12, Blocks.field_150322_A, Blocks.field_150322_A, false);
/* 321 */       func_151549_a(p_74875_1_, p_74875_3_, 9, -11, 9, 11, -1, 11, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 322 */       func_151550_a(p_74875_1_, Blocks.field_150456_au, 0, 10, -11, 10, p_74875_3_);
/* 323 */       func_151549_a(p_74875_1_, p_74875_3_, 9, -13, 9, 11, -13, 11, Blocks.field_150335_W, Blocks.field_150350_a, false);
/* 324 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 8, -11, 10, p_74875_3_);
/* 325 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 8, -10, 10, p_74875_3_);
/* 326 */       func_151550_a(p_74875_1_, Blocks.field_150322_A, 1, 7, -10, 10, p_74875_3_);
/* 327 */       func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, 7, -11, 10, p_74875_3_);
/* 328 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 12, -11, 10, p_74875_3_);
/* 329 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 12, -10, 10, p_74875_3_);
/* 330 */       func_151550_a(p_74875_1_, Blocks.field_150322_A, 1, 13, -10, 10, p_74875_3_);
/* 331 */       func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, 13, -11, 10, p_74875_3_);
/* 332 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 10, -11, 8, p_74875_3_);
/* 333 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 10, -10, 8, p_74875_3_);
/* 334 */       func_151550_a(p_74875_1_, Blocks.field_150322_A, 1, 10, -10, 7, p_74875_3_);
/* 335 */       func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, 10, -11, 7, p_74875_3_);
/* 336 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 10, -11, 12, p_74875_3_);
/* 337 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 10, -10, 12, p_74875_3_);
/* 338 */       func_151550_a(p_74875_1_, Blocks.field_150322_A, 1, 10, -10, 13, p_74875_3_);
/* 339 */       func_151550_a(p_74875_1_, Blocks.field_150322_A, 2, 10, -11, 13, p_74875_3_);
/*     */ 
/*     */       
/* 342 */       for (n = 0; n < 4; n++) {
/* 343 */         if (!this.field_74940_h[n]) {
/* 344 */           int i1 = Direction.field_71583_a[n] * 2;
/* 345 */           int i2 = Direction.field_71581_b[n] * 2;
/* 346 */           this.field_74940_h[n] = func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 10 + i1, -11, 10 + i2, WeightedRandomChestContent.func_92080_a(field_74941_i, new WeightedRandomChestContent[] { Items.field_151134_bR.func_92114_b(p_74875_2_) }), 2 + p_74875_2_.nextInt(5));
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 351 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class JunglePyramid
/*     */     extends Feature
/*     */   {
/*     */     private boolean field_74947_h;
/*     */     
/*     */     private boolean field_74948_i;
/*     */     private boolean field_74945_j;
/*     */     private boolean field_74946_k;
/* 364 */     public static final WeightedRandomChestContent[] field_74943_l = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.field_151045_i, 0, 1, 3, 3), new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 5, 10), new WeightedRandomChestContent(Items.field_151043_k, 0, 2, 7, 15), new WeightedRandomChestContent(Items.field_151166_bC, 0, 1, 3, 2), new WeightedRandomChestContent(Items.field_151103_aS, 0, 4, 6, 20), new WeightedRandomChestContent(Items.field_151078_bh, 0, 3, 7, 16), new WeightedRandomChestContent(Items.field_151141_av, 0, 1, 1, 3), new WeightedRandomChestContent(Items.field_151138_bX, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151136_bY, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151125_bZ, 0, 1, 1, 1) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 378 */     public static final WeightedRandomChestContent[] field_74944_m = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.field_151032_g, 0, 2, 7, 30) };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public JunglePyramid() {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public JunglePyramid(Random p_i2064_1_, int p_i2064_2_, int p_i2064_3_) {
/* 389 */       super(p_i2064_1_, p_i2064_2_, 64, p_i2064_3_, 12, 10, 15);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/* 394 */       super.func_143012_a(p_143012_1_);
/* 395 */       p_143012_1_.func_74757_a("placedMainChest", this.field_74947_h);
/* 396 */       p_143012_1_.func_74757_a("placedHiddenChest", this.field_74948_i);
/* 397 */       p_143012_1_.func_74757_a("placedTrap1", this.field_74945_j);
/* 398 */       p_143012_1_.func_74757_a("placedTrap2", this.field_74946_k);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/* 403 */       super.func_143011_b(p_143011_1_);
/* 404 */       this.field_74947_h = p_143011_1_.func_74767_n("placedMainChest");
/* 405 */       this.field_74948_i = p_143011_1_.func_74767_n("placedHiddenChest");
/* 406 */       this.field_74945_j = p_143011_1_.func_74767_n("placedTrap1");
/* 407 */       this.field_74946_k = p_143011_1_.func_74767_n("placedTrap2");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 413 */       if (!func_74935_a(p_74875_1_, p_74875_3_, 0)) {
/* 414 */         return false;
/*     */       }
/*     */       
/* 417 */       int i = func_151555_a(Blocks.field_150446_ar, 3);
/* 418 */       int j = func_151555_a(Blocks.field_150446_ar, 2);
/* 419 */       int k = func_151555_a(Blocks.field_150446_ar, 0);
/* 420 */       int m = func_151555_a(Blocks.field_150446_ar, 1);
/*     */ 
/*     */       
/* 423 */       func_74882_a(p_74875_1_, p_74875_3_, 0, -4, 0, this.field_74939_a - 1, 0, this.field_74938_c - 1, false, p_74875_2_, field_74942_n);
/*     */ 
/*     */       
/* 426 */       func_74882_a(p_74875_1_, p_74875_3_, 2, 1, 2, 9, 2, 2, false, p_74875_2_, field_74942_n);
/* 427 */       func_74882_a(p_74875_1_, p_74875_3_, 2, 1, 12, 9, 2, 12, false, p_74875_2_, field_74942_n);
/* 428 */       func_74882_a(p_74875_1_, p_74875_3_, 2, 1, 3, 2, 2, 11, false, p_74875_2_, field_74942_n);
/* 429 */       func_74882_a(p_74875_1_, p_74875_3_, 9, 1, 3, 9, 2, 11, false, p_74875_2_, field_74942_n);
/*     */ 
/*     */       
/* 432 */       func_74882_a(p_74875_1_, p_74875_3_, 1, 3, 1, 10, 6, 1, false, p_74875_2_, field_74942_n);
/* 433 */       func_74882_a(p_74875_1_, p_74875_3_, 1, 3, 13, 10, 6, 13, false, p_74875_2_, field_74942_n);
/* 434 */       func_74882_a(p_74875_1_, p_74875_3_, 1, 3, 2, 1, 6, 12, false, p_74875_2_, field_74942_n);
/* 435 */       func_74882_a(p_74875_1_, p_74875_3_, 10, 3, 2, 10, 6, 12, false, p_74875_2_, field_74942_n);
/*     */ 
/*     */       
/* 438 */       func_74882_a(p_74875_1_, p_74875_3_, 2, 3, 2, 9, 3, 12, false, p_74875_2_, field_74942_n);
/* 439 */       func_74882_a(p_74875_1_, p_74875_3_, 2, 6, 2, 9, 6, 12, false, p_74875_2_, field_74942_n);
/* 440 */       func_74882_a(p_74875_1_, p_74875_3_, 3, 7, 3, 8, 7, 11, false, p_74875_2_, field_74942_n);
/* 441 */       func_74882_a(p_74875_1_, p_74875_3_, 4, 8, 4, 7, 8, 10, false, p_74875_2_, field_74942_n);
/*     */ 
/*     */       
/* 444 */       func_74878_a(p_74875_1_, p_74875_3_, 3, 1, 3, 8, 2, 11);
/* 445 */       func_74878_a(p_74875_1_, p_74875_3_, 4, 3, 6, 7, 3, 9);
/* 446 */       func_74878_a(p_74875_1_, p_74875_3_, 2, 4, 2, 9, 5, 12);
/* 447 */       func_74878_a(p_74875_1_, p_74875_3_, 4, 6, 5, 7, 6, 9);
/* 448 */       func_74878_a(p_74875_1_, p_74875_3_, 5, 7, 6, 6, 7, 8);
/*     */ 
/*     */       
/* 451 */       func_74878_a(p_74875_1_, p_74875_3_, 5, 1, 2, 6, 2, 2);
/* 452 */       func_74878_a(p_74875_1_, p_74875_3_, 5, 2, 12, 6, 2, 12);
/* 453 */       func_74878_a(p_74875_1_, p_74875_3_, 5, 5, 1, 6, 5, 1);
/* 454 */       func_74878_a(p_74875_1_, p_74875_3_, 5, 5, 13, 6, 5, 13);
/* 455 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 1, 5, 5, p_74875_3_);
/* 456 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 10, 5, 5, p_74875_3_);
/* 457 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 1, 5, 9, p_74875_3_);
/* 458 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 10, 5, 9, p_74875_3_);
/*     */       
/*     */       byte b;
/* 461 */       for (b = 0; b <= 14; b += 14) {
/* 462 */         func_74882_a(p_74875_1_, p_74875_3_, 2, 4, b, 2, 5, b, false, p_74875_2_, field_74942_n);
/* 463 */         func_74882_a(p_74875_1_, p_74875_3_, 4, 4, b, 4, 5, b, false, p_74875_2_, field_74942_n);
/* 464 */         func_74882_a(p_74875_1_, p_74875_3_, 7, 4, b, 7, 5, b, false, p_74875_2_, field_74942_n);
/* 465 */         func_74882_a(p_74875_1_, p_74875_3_, 9, 4, b, 9, 5, b, false, p_74875_2_, field_74942_n);
/*     */       } 
/* 467 */       func_74882_a(p_74875_1_, p_74875_3_, 5, 6, 0, 6, 6, 0, false, p_74875_2_, field_74942_n);
/* 468 */       for (b = 0; b <= 11; b += 11) {
/* 469 */         for (byte b1 = 2; b1 <= 12; b1 += 2) {
/* 470 */           func_74882_a(p_74875_1_, p_74875_3_, b, 4, b1, b, 5, b1, false, p_74875_2_, field_74942_n);
/*     */         }
/* 472 */         func_74882_a(p_74875_1_, p_74875_3_, b, 6, 5, b, 6, 5, false, p_74875_2_, field_74942_n);
/* 473 */         func_74882_a(p_74875_1_, p_74875_3_, b, 6, 9, b, 6, 9, false, p_74875_2_, field_74942_n);
/*     */       } 
/* 475 */       func_74882_a(p_74875_1_, p_74875_3_, 2, 7, 2, 2, 9, 2, false, p_74875_2_, field_74942_n);
/* 476 */       func_74882_a(p_74875_1_, p_74875_3_, 9, 7, 2, 9, 9, 2, false, p_74875_2_, field_74942_n);
/* 477 */       func_74882_a(p_74875_1_, p_74875_3_, 2, 7, 12, 2, 9, 12, false, p_74875_2_, field_74942_n);
/* 478 */       func_74882_a(p_74875_1_, p_74875_3_, 9, 7, 12, 9, 9, 12, false, p_74875_2_, field_74942_n);
/* 479 */       func_74882_a(p_74875_1_, p_74875_3_, 4, 9, 4, 4, 9, 4, false, p_74875_2_, field_74942_n);
/* 480 */       func_74882_a(p_74875_1_, p_74875_3_, 7, 9, 4, 7, 9, 4, false, p_74875_2_, field_74942_n);
/* 481 */       func_74882_a(p_74875_1_, p_74875_3_, 4, 9, 10, 4, 9, 10, false, p_74875_2_, field_74942_n);
/* 482 */       func_74882_a(p_74875_1_, p_74875_3_, 7, 9, 10, 7, 9, 10, false, p_74875_2_, field_74942_n);
/* 483 */       func_74882_a(p_74875_1_, p_74875_3_, 5, 9, 7, 6, 9, 7, false, p_74875_2_, field_74942_n);
/* 484 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, i, 5, 9, 6, p_74875_3_);
/* 485 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, i, 6, 9, 6, p_74875_3_);
/* 486 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, j, 5, 9, 8, p_74875_3_);
/* 487 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, j, 6, 9, 8, p_74875_3_);
/*     */ 
/*     */       
/* 490 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, i, 4, 0, 0, p_74875_3_);
/* 491 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, i, 5, 0, 0, p_74875_3_);
/* 492 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, i, 6, 0, 0, p_74875_3_);
/* 493 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, i, 7, 0, 0, p_74875_3_);
/*     */ 
/*     */       
/* 496 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, i, 4, 1, 8, p_74875_3_);
/* 497 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, i, 4, 2, 9, p_74875_3_);
/* 498 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, i, 4, 3, 10, p_74875_3_);
/* 499 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, i, 7, 1, 8, p_74875_3_);
/* 500 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, i, 7, 2, 9, p_74875_3_);
/* 501 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, i, 7, 3, 10, p_74875_3_);
/* 502 */       func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 9, 4, 1, 9, false, p_74875_2_, field_74942_n);
/* 503 */       func_74882_a(p_74875_1_, p_74875_3_, 7, 1, 9, 7, 1, 9, false, p_74875_2_, field_74942_n);
/* 504 */       func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 10, 7, 2, 10, false, p_74875_2_, field_74942_n);
/*     */ 
/*     */       
/* 507 */       func_74882_a(p_74875_1_, p_74875_3_, 5, 4, 5, 6, 4, 5, false, p_74875_2_, field_74942_n);
/* 508 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, k, 4, 4, 5, p_74875_3_);
/* 509 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, m, 7, 4, 5, p_74875_3_);
/*     */ 
/*     */       
/* 512 */       for (b = 0; b < 4; b++) {
/* 513 */         func_151550_a(p_74875_1_, Blocks.field_150446_ar, j, 5, 0 - b, 6 + b, p_74875_3_);
/* 514 */         func_151550_a(p_74875_1_, Blocks.field_150446_ar, j, 6, 0 - b, 6 + b, p_74875_3_);
/* 515 */         func_74878_a(p_74875_1_, p_74875_3_, 5, 0 - b, 7 + b, 6, 0 - b, 9 + b);
/*     */       } 
/*     */ 
/*     */       
/* 519 */       func_74878_a(p_74875_1_, p_74875_3_, 1, -3, 12, 10, -1, 13);
/* 520 */       func_74878_a(p_74875_1_, p_74875_3_, 1, -3, 1, 3, -1, 13);
/* 521 */       func_74878_a(p_74875_1_, p_74875_3_, 1, -3, 1, 9, -1, 5);
/* 522 */       for (b = 1; b <= 13; b += 2) {
/* 523 */         func_74882_a(p_74875_1_, p_74875_3_, 1, -3, b, 1, -2, b, false, p_74875_2_, field_74942_n);
/*     */       }
/* 525 */       for (b = 2; b <= 12; b += 2) {
/* 526 */         func_74882_a(p_74875_1_, p_74875_3_, 1, -1, b, 3, -1, b, false, p_74875_2_, field_74942_n);
/*     */       }
/* 528 */       func_74882_a(p_74875_1_, p_74875_3_, 2, -2, 1, 5, -2, 1, false, p_74875_2_, field_74942_n);
/* 529 */       func_74882_a(p_74875_1_, p_74875_3_, 7, -2, 1, 9, -2, 1, false, p_74875_2_, field_74942_n);
/* 530 */       func_74882_a(p_74875_1_, p_74875_3_, 6, -3, 1, 6, -3, 1, false, p_74875_2_, field_74942_n);
/* 531 */       func_74882_a(p_74875_1_, p_74875_3_, 6, -1, 1, 6, -1, 1, false, p_74875_2_, field_74942_n);
/*     */ 
/*     */       
/* 534 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150479_bC, func_151555_a((Block)Blocks.field_150479_bC, 3) | 0x4, 1, -3, 8, p_74875_3_);
/* 535 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150479_bC, func_151555_a((Block)Blocks.field_150479_bC, 1) | 0x4, 4, -3, 8, p_74875_3_);
/* 536 */       func_151550_a(p_74875_1_, Blocks.field_150473_bD, 4, 2, -3, 8, p_74875_3_);
/* 537 */       func_151550_a(p_74875_1_, Blocks.field_150473_bD, 4, 3, -3, 8, p_74875_3_);
/* 538 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150488_af, 0, 5, -3, 7, p_74875_3_);
/* 539 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150488_af, 0, 5, -3, 6, p_74875_3_);
/* 540 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150488_af, 0, 5, -3, 5, p_74875_3_);
/* 541 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150488_af, 0, 5, -3, 4, p_74875_3_);
/* 542 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150488_af, 0, 5, -3, 3, p_74875_3_);
/* 543 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150488_af, 0, 5, -3, 2, p_74875_3_);
/* 544 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150488_af, 0, 5, -3, 1, p_74875_3_);
/* 545 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150488_af, 0, 4, -3, 1, p_74875_3_);
/* 546 */       func_151550_a(p_74875_1_, Blocks.field_150341_Y, 0, 3, -3, 1, p_74875_3_);
/* 547 */       if (!this.field_74945_j) {
/* 548 */         this.field_74945_j = func_74869_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, -2, 1, 2, field_74944_m, 2);
/*     */       }
/* 550 */       func_151550_a(p_74875_1_, Blocks.field_150395_bd, 15, 3, -2, 2, p_74875_3_);
/*     */ 
/*     */       
/* 553 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150479_bC, func_151555_a((Block)Blocks.field_150479_bC, 2) | 0x4, 7, -3, 1, p_74875_3_);
/* 554 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150479_bC, func_151555_a((Block)Blocks.field_150479_bC, 0) | 0x4, 7, -3, 5, p_74875_3_);
/* 555 */       func_151550_a(p_74875_1_, Blocks.field_150473_bD, 4, 7, -3, 2, p_74875_3_);
/* 556 */       func_151550_a(p_74875_1_, Blocks.field_150473_bD, 4, 7, -3, 3, p_74875_3_);
/* 557 */       func_151550_a(p_74875_1_, Blocks.field_150473_bD, 4, 7, -3, 4, p_74875_3_);
/* 558 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150488_af, 0, 8, -3, 6, p_74875_3_);
/* 559 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150488_af, 0, 9, -3, 6, p_74875_3_);
/* 560 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150488_af, 0, 9, -3, 5, p_74875_3_);
/* 561 */       func_151550_a(p_74875_1_, Blocks.field_150341_Y, 0, 9, -3, 4, p_74875_3_);
/* 562 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150488_af, 0, 9, -2, 4, p_74875_3_);
/* 563 */       if (!this.field_74946_k) {
/* 564 */         this.field_74946_k = func_74869_a(p_74875_1_, p_74875_3_, p_74875_2_, 9, -2, 3, 4, field_74944_m, 2);
/*     */       }
/* 566 */       func_151550_a(p_74875_1_, Blocks.field_150395_bd, 15, 8, -1, 3, p_74875_3_);
/* 567 */       func_151550_a(p_74875_1_, Blocks.field_150395_bd, 15, 8, -2, 3, p_74875_3_);
/* 568 */       if (!this.field_74947_h) {
/* 569 */         this.field_74947_h = func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 8, -3, 3, WeightedRandomChestContent.func_92080_a(field_74943_l, new WeightedRandomChestContent[] { Items.field_151134_bR.func_92114_b(p_74875_2_) }), 2 + p_74875_2_.nextInt(5));
/*     */       }
/* 571 */       func_151550_a(p_74875_1_, Blocks.field_150341_Y, 0, 9, -3, 2, p_74875_3_);
/* 572 */       func_151550_a(p_74875_1_, Blocks.field_150341_Y, 0, 8, -3, 1, p_74875_3_);
/* 573 */       func_151550_a(p_74875_1_, Blocks.field_150341_Y, 0, 4, -3, 5, p_74875_3_);
/* 574 */       func_151550_a(p_74875_1_, Blocks.field_150341_Y, 0, 5, -2, 5, p_74875_3_);
/* 575 */       func_151550_a(p_74875_1_, Blocks.field_150341_Y, 0, 5, -1, 5, p_74875_3_);
/* 576 */       func_151550_a(p_74875_1_, Blocks.field_150341_Y, 0, 6, -3, 5, p_74875_3_);
/* 577 */       func_151550_a(p_74875_1_, Blocks.field_150341_Y, 0, 7, -2, 5, p_74875_3_);
/* 578 */       func_151550_a(p_74875_1_, Blocks.field_150341_Y, 0, 7, -1, 5, p_74875_3_);
/* 579 */       func_151550_a(p_74875_1_, Blocks.field_150341_Y, 0, 8, -3, 5, p_74875_3_);
/* 580 */       func_74882_a(p_74875_1_, p_74875_3_, 9, -1, 1, 9, -1, 5, false, p_74875_2_, field_74942_n);
/*     */ 
/*     */       
/* 583 */       func_74878_a(p_74875_1_, p_74875_3_, 8, -3, 8, 10, -1, 10);
/* 584 */       func_151550_a(p_74875_1_, Blocks.field_150417_aV, 3, 8, -2, 11, p_74875_3_);
/* 585 */       func_151550_a(p_74875_1_, Blocks.field_150417_aV, 3, 9, -2, 11, p_74875_3_);
/* 586 */       func_151550_a(p_74875_1_, Blocks.field_150417_aV, 3, 10, -2, 11, p_74875_3_);
/* 587 */       func_151550_a(p_74875_1_, Blocks.field_150442_at, BlockLever.func_149819_b(func_151555_a(Blocks.field_150442_at, 2)), 8, -2, 12, p_74875_3_);
/* 588 */       func_151550_a(p_74875_1_, Blocks.field_150442_at, BlockLever.func_149819_b(func_151555_a(Blocks.field_150442_at, 2)), 9, -2, 12, p_74875_3_);
/* 589 */       func_151550_a(p_74875_1_, Blocks.field_150442_at, BlockLever.func_149819_b(func_151555_a(Blocks.field_150442_at, 2)), 10, -2, 12, p_74875_3_);
/* 590 */       func_74882_a(p_74875_1_, p_74875_3_, 8, -3, 8, 8, -3, 10, false, p_74875_2_, field_74942_n);
/* 591 */       func_74882_a(p_74875_1_, p_74875_3_, 10, -3, 8, 10, -3, 10, false, p_74875_2_, field_74942_n);
/* 592 */       func_151550_a(p_74875_1_, Blocks.field_150341_Y, 0, 10, -2, 9, p_74875_3_);
/* 593 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150488_af, 0, 8, -2, 9, p_74875_3_);
/* 594 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150488_af, 0, 8, -2, 10, p_74875_3_);
/* 595 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150488_af, 0, 10, -1, 9, p_74875_3_);
/* 596 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150320_F, 1, 9, -2, 8, p_74875_3_);
/* 597 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150320_F, func_151555_a((Block)Blocks.field_150320_F, 4), 10, -2, 8, p_74875_3_);
/* 598 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150320_F, func_151555_a((Block)Blocks.field_150320_F, 4), 10, -1, 8, p_74875_3_);
/* 599 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150413_aR, func_151555_a((Block)Blocks.field_150413_aR, 2), 10, -2, 10, p_74875_3_);
/* 600 */       if (!this.field_74948_i) {
/* 601 */         this.field_74948_i = func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 9, -3, 10, WeightedRandomChestContent.func_92080_a(field_74943_l, new WeightedRandomChestContent[] { Items.field_151134_bR.func_92114_b(p_74875_2_) }), 2 + p_74875_2_.nextInt(5));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 606 */       return true;
/*     */     }
/*     */     
/*     */     static class Stones extends StructureComponent.BlockSelector { private static final String __OBFID = "CL_00000478";
/*     */       
/*     */       public void func_75062_a(Random p_75062_1_, int p_75062_2_, int p_75062_3_, int p_75062_4_, boolean p_75062_5_) {
/* 612 */         if (p_75062_1_.nextFloat() < 0.4F) {
/* 613 */           this.field_151562_a = Blocks.field_150347_e;
/*     */         } else {
/* 615 */           this.field_151562_a = Blocks.field_150341_Y;
/*     */         } 
/*     */       }
/*     */       
/*     */       private Stones() {} }
/* 620 */     private static Stones field_74942_n = new Stones();
/*     */     private static final String __OBFID = "CL_00000477";
/*     */   }
/*     */   
/*     */   public static class SwampHut
/*     */     extends Feature
/*     */   {
/*     */     private boolean field_82682_h;
/*     */     private static final String __OBFID = "CL_00000480";
/*     */     
/*     */     public SwampHut() {}
/*     */     
/*     */     public SwampHut(Random p_i2066_1_, int p_i2066_2_, int p_i2066_3_) {
/* 633 */       super(p_i2066_1_, p_i2066_2_, 64, p_i2066_3_, 7, 5, 9);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/* 638 */       super.func_143012_a(p_143012_1_);
/* 639 */       p_143012_1_.func_74757_a("Witch", this.field_82682_h);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/* 644 */       super.func_143011_b(p_143011_1_);
/* 645 */       this.field_82682_h = p_143011_1_.func_74767_n("Witch");
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 650 */       if (!func_74935_a(p_74875_1_, p_74875_3_, 0)) {
/* 651 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 655 */       func_151556_a(p_74875_1_, p_74875_3_, 1, 1, 1, 5, 1, 7, Blocks.field_150344_f, 1, Blocks.field_150344_f, 1, false);
/* 656 */       func_151556_a(p_74875_1_, p_74875_3_, 1, 4, 2, 5, 4, 7, Blocks.field_150344_f, 1, Blocks.field_150344_f, 1, false);
/* 657 */       func_151556_a(p_74875_1_, p_74875_3_, 2, 1, 0, 4, 1, 0, Blocks.field_150344_f, 1, Blocks.field_150344_f, 1, false);
/*     */ 
/*     */       
/* 660 */       func_151556_a(p_74875_1_, p_74875_3_, 2, 2, 2, 3, 3, 2, Blocks.field_150344_f, 1, Blocks.field_150344_f, 1, false);
/* 661 */       func_151556_a(p_74875_1_, p_74875_3_, 1, 2, 3, 1, 3, 6, Blocks.field_150344_f, 1, Blocks.field_150344_f, 1, false);
/* 662 */       func_151556_a(p_74875_1_, p_74875_3_, 5, 2, 3, 5, 3, 6, Blocks.field_150344_f, 1, Blocks.field_150344_f, 1, false);
/* 663 */       func_151556_a(p_74875_1_, p_74875_3_, 2, 2, 7, 4, 3, 7, Blocks.field_150344_f, 1, Blocks.field_150344_f, 1, false);
/*     */ 
/*     */       
/* 666 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 2, 1, 3, 2, Blocks.field_150364_r, Blocks.field_150364_r, false);
/* 667 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 0, 2, 5, 3, 2, Blocks.field_150364_r, Blocks.field_150364_r, false);
/* 668 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 7, 1, 3, 7, Blocks.field_150364_r, Blocks.field_150364_r, false);
/* 669 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 0, 7, 5, 3, 7, Blocks.field_150364_r, Blocks.field_150364_r, false);
/*     */ 
/*     */       
/* 672 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 2, 3, 2, p_74875_3_);
/* 673 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 3, 3, 7, p_74875_3_);
/* 674 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 1, 3, 4, p_74875_3_);
/* 675 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 5, 3, 4, p_74875_3_);
/* 676 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 5, 3, 5, p_74875_3_);
/* 677 */       func_151550_a(p_74875_1_, Blocks.field_150457_bL, 7, 1, 3, 5, p_74875_3_);
/*     */ 
/*     */       
/* 680 */       func_151550_a(p_74875_1_, Blocks.field_150462_ai, 0, 3, 2, 6, p_74875_3_);
/* 681 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150383_bp, 0, 4, 2, 6, p_74875_3_);
/*     */ 
/*     */       
/* 684 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 2, 1, p_74875_3_);
/* 685 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 5, 2, 1, p_74875_3_);
/*     */ 
/*     */       
/* 688 */       int i = func_151555_a(Blocks.field_150476_ad, 3);
/* 689 */       int j = func_151555_a(Blocks.field_150476_ad, 1);
/* 690 */       int k = func_151555_a(Blocks.field_150476_ad, 0);
/* 691 */       int m = func_151555_a(Blocks.field_150476_ad, 2);
/*     */       
/* 693 */       func_151556_a(p_74875_1_, p_74875_3_, 0, 4, 1, 6, 4, 1, Blocks.field_150485_bF, i, Blocks.field_150485_bF, i, false);
/* 694 */       func_151556_a(p_74875_1_, p_74875_3_, 0, 4, 2, 0, 4, 7, Blocks.field_150485_bF, k, Blocks.field_150485_bF, k, false);
/* 695 */       func_151556_a(p_74875_1_, p_74875_3_, 6, 4, 2, 6, 4, 7, Blocks.field_150485_bF, j, Blocks.field_150485_bF, j, false);
/* 696 */       func_151556_a(p_74875_1_, p_74875_3_, 0, 4, 8, 6, 4, 8, Blocks.field_150485_bF, m, Blocks.field_150485_bF, m, false);
/*     */       
/*     */       int n;
/* 699 */       for (n = 2; n <= 7; n += 5) {
/* 700 */         for (byte b = 1; b <= 5; b += 4) {
/* 701 */           func_151554_b(p_74875_1_, Blocks.field_150364_r, 0, b, -1, n, p_74875_3_);
/*     */         }
/*     */       } 
/*     */       
/* 705 */       if (!this.field_82682_h) {
/* 706 */         n = func_74865_a(2, 5);
/* 707 */         int i1 = func_74862_a(2);
/* 708 */         int i2 = func_74873_b(2, 5);
/*     */         
/* 710 */         if (p_74875_3_.func_78890_b(n, i1, i2)) {
/* 711 */           this.field_82682_h = true;
/*     */           
/* 713 */           EntityWitch entityWitch = new EntityWitch(p_74875_1_);
/* 714 */           entityWitch.func_70012_b(n + 0.5D, i1, i2 + 0.5D, 0.0F, 0.0F);
/* 715 */           entityWitch.func_110161_a(null);
/* 716 */           p_74875_1_.func_72838_d((Entity)entityWitch);
/*     */         } 
/*     */       } 
/*     */       
/* 720 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\structure\ComponentScatteredFeaturePieces.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */