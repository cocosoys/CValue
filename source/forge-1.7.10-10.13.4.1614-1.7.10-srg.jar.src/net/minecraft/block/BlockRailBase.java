/*     */ package net.minecraft.block;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.ChunkPosition;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class BlockRailBase extends Block {
/*     */   protected final boolean field_150053_a;
/*     */   private static final String __OBFID = "CL_00000195";
/*     */   
/*     */   public class Rail {
/*     */     private World field_150660_b;
/*     */     private int field_150661_c;
/*  23 */     private List field_150657_g = new ArrayList(); private int field_150658_d; private int field_150659_e; private final boolean field_150656_f; private static final String __OBFID = "CL_00000196";
/*     */     
/*     */     public Rail(BlockRailBase p_i45388_1_, World p_i45388_2_, int p_i45388_3_, int p_i45388_4_, int p_i45388_5_) {
/*  26 */       this.field_150660_b = p_i45388_2_;
/*  27 */       this.field_150661_c = p_i45388_3_;
/*  28 */       this.field_150658_d = p_i45388_4_;
/*  29 */       this.field_150659_e = p_i45388_5_;
/*     */       
/*  31 */       Block block = p_i45388_2_.func_147439_a(p_i45388_3_, p_i45388_4_, p_i45388_5_);
/*  32 */       int i = p_i45388_2_.func_72805_g(p_i45388_3_, p_i45388_4_, p_i45388_5_);
/*  33 */       if (((BlockRailBase)block).field_150053_a) {
/*  34 */         this.field_150656_f = true;
/*  35 */         i &= 0xFFFFFFF7;
/*     */       } else {
/*  37 */         this.field_150656_f = false;
/*     */       } 
/*  39 */       func_150648_a(i);
/*     */     }
/*     */ 
/*     */     
/*     */     private void func_150648_a(int p_150648_1_) {
/*  44 */       this.field_150657_g.clear();
/*  45 */       if (p_150648_1_ == 0) {
/*  46 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c, this.field_150658_d, this.field_150659_e - 1));
/*  47 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c, this.field_150658_d, this.field_150659_e + 1));
/*  48 */       } else if (p_150648_1_ == 1) {
/*  49 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c - 1, this.field_150658_d, this.field_150659_e));
/*  50 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c + 1, this.field_150658_d, this.field_150659_e));
/*  51 */       } else if (p_150648_1_ == 2) {
/*  52 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c - 1, this.field_150658_d, this.field_150659_e));
/*  53 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c + 1, this.field_150658_d + 1, this.field_150659_e));
/*  54 */       } else if (p_150648_1_ == 3) {
/*  55 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c - 1, this.field_150658_d + 1, this.field_150659_e));
/*  56 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c + 1, this.field_150658_d, this.field_150659_e));
/*  57 */       } else if (p_150648_1_ == 4) {
/*  58 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c, this.field_150658_d + 1, this.field_150659_e - 1));
/*  59 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c, this.field_150658_d, this.field_150659_e + 1));
/*  60 */       } else if (p_150648_1_ == 5) {
/*  61 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c, this.field_150658_d, this.field_150659_e - 1));
/*  62 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c, this.field_150658_d + 1, this.field_150659_e + 1));
/*  63 */       } else if (p_150648_1_ == 6) {
/*  64 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c + 1, this.field_150658_d, this.field_150659_e));
/*  65 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c, this.field_150658_d, this.field_150659_e + 1));
/*  66 */       } else if (p_150648_1_ == 7) {
/*  67 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c - 1, this.field_150658_d, this.field_150659_e));
/*  68 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c, this.field_150658_d, this.field_150659_e + 1));
/*  69 */       } else if (p_150648_1_ == 8) {
/*  70 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c - 1, this.field_150658_d, this.field_150659_e));
/*  71 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c, this.field_150658_d, this.field_150659_e - 1));
/*  72 */       } else if (p_150648_1_ == 9) {
/*  73 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c + 1, this.field_150658_d, this.field_150659_e));
/*  74 */         this.field_150657_g.add(new ChunkPosition(this.field_150661_c, this.field_150658_d, this.field_150659_e - 1));
/*     */       } 
/*     */     }
/*     */     
/*     */     private void func_150651_b() {
/*  79 */       for (byte b = 0; b < this.field_150657_g.size(); b++) {
/*  80 */         Rail rail = func_150654_a(this.field_150657_g.get(b));
/*  81 */         if (rail == null || !rail.func_150653_a(this)) {
/*  82 */           this.field_150657_g.remove(b--);
/*     */         } else {
/*  84 */           this.field_150657_g.set(b, new ChunkPosition(rail.field_150661_c, rail.field_150658_d, rail.field_150659_e));
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     private boolean func_150646_a(int p_150646_1_, int p_150646_2_, int p_150646_3_) {
/*  90 */       if (BlockRailBase.func_150049_b_(this.field_150660_b, p_150646_1_, p_150646_2_, p_150646_3_)) return true; 
/*  91 */       if (BlockRailBase.func_150049_b_(this.field_150660_b, p_150646_1_, p_150646_2_ + 1, p_150646_3_)) return true; 
/*  92 */       if (BlockRailBase.func_150049_b_(this.field_150660_b, p_150646_1_, p_150646_2_ - 1, p_150646_3_)) return true; 
/*  93 */       return false;
/*     */     }
/*     */     
/*     */     private Rail func_150654_a(ChunkPosition p_150654_1_) {
/*  97 */       if (BlockRailBase.func_150049_b_(this.field_150660_b, p_150654_1_.field_151329_a, p_150654_1_.field_151327_b, p_150654_1_.field_151328_c)) return new Rail(this.field_150662_a, this.field_150660_b, p_150654_1_.field_151329_a, p_150654_1_.field_151327_b, p_150654_1_.field_151328_c); 
/*  98 */       if (BlockRailBase.func_150049_b_(this.field_150660_b, p_150654_1_.field_151329_a, p_150654_1_.field_151327_b + 1, p_150654_1_.field_151328_c)) return new Rail(this.field_150662_a, this.field_150660_b, p_150654_1_.field_151329_a, p_150654_1_.field_151327_b + 1, p_150654_1_.field_151328_c); 
/*  99 */       if (BlockRailBase.func_150049_b_(this.field_150660_b, p_150654_1_.field_151329_a, p_150654_1_.field_151327_b - 1, p_150654_1_.field_151328_c)) return new Rail(this.field_150662_a, this.field_150660_b, p_150654_1_.field_151329_a, p_150654_1_.field_151327_b - 1, p_150654_1_.field_151328_c); 
/* 100 */       return null;
/*     */     }
/*     */     
/*     */     private boolean func_150653_a(Rail p_150653_1_) {
/* 104 */       for (byte b = 0; b < this.field_150657_g.size(); b++) {
/* 105 */         ChunkPosition chunkPosition = this.field_150657_g.get(b);
/* 106 */         if (chunkPosition.field_151329_a == p_150653_1_.field_150661_c && chunkPosition.field_151328_c == p_150653_1_.field_150659_e) {
/* 107 */           return true;
/*     */         }
/*     */       } 
/* 110 */       return false;
/*     */     }
/*     */     
/*     */     private boolean func_150652_b(int p_150652_1_, int p_150652_2_, int p_150652_3_) {
/* 114 */       for (byte b = 0; b < this.field_150657_g.size(); b++) {
/* 115 */         ChunkPosition chunkPosition = this.field_150657_g.get(b);
/* 116 */         if (chunkPosition.field_151329_a == p_150652_1_ && chunkPosition.field_151328_c == p_150652_3_) {
/* 117 */           return true;
/*     */         }
/*     */       } 
/* 120 */       return false;
/*     */     }
/*     */     
/*     */     protected int func_150650_a() {
/* 124 */       byte b = 0;
/*     */       
/* 126 */       if (func_150646_a(this.field_150661_c, this.field_150658_d, this.field_150659_e - 1)) b++; 
/* 127 */       if (func_150646_a(this.field_150661_c, this.field_150658_d, this.field_150659_e + 1)) b++; 
/* 128 */       if (func_150646_a(this.field_150661_c - 1, this.field_150658_d, this.field_150659_e)) b++; 
/* 129 */       if (func_150646_a(this.field_150661_c + 1, this.field_150658_d, this.field_150659_e)) b++;
/*     */       
/* 131 */       return b;
/*     */     }
/*     */     
/*     */     private boolean func_150649_b(Rail p_150649_1_) {
/* 135 */       if (func_150653_a(p_150649_1_)) return true; 
/* 136 */       if (this.field_150657_g.size() == 2) {
/* 137 */         return false;
/*     */       }
/* 139 */       if (this.field_150657_g.isEmpty()) {
/* 140 */         return true;
/*     */       }
/*     */       
/* 143 */       return true;
/*     */     }
/*     */     
/*     */     private void func_150645_c(Rail p_150645_1_) {
/* 147 */       this.field_150657_g.add(new ChunkPosition(p_150645_1_.field_150661_c, p_150645_1_.field_150658_d, p_150645_1_.field_150659_e));
/*     */       
/* 149 */       boolean bool1 = func_150652_b(this.field_150661_c, this.field_150658_d, this.field_150659_e - 1);
/* 150 */       boolean bool2 = func_150652_b(this.field_150661_c, this.field_150658_d, this.field_150659_e + 1);
/* 151 */       boolean bool3 = func_150652_b(this.field_150661_c - 1, this.field_150658_d, this.field_150659_e);
/* 152 */       boolean bool4 = func_150652_b(this.field_150661_c + 1, this.field_150658_d, this.field_150659_e);
/*     */       
/* 154 */       byte b = -1;
/*     */       
/* 156 */       if (bool1 || bool2) b = 0; 
/* 157 */       if (bool3 || bool4) b = 1; 
/* 158 */       if (!this.field_150656_f) {
/* 159 */         if (bool2 && bool4 && !bool1 && !bool3) b = 6; 
/* 160 */         if (bool2 && bool3 && !bool1 && !bool4) b = 7; 
/* 161 */         if (bool1 && bool3 && !bool2 && !bool4) b = 8; 
/* 162 */         if (bool1 && bool4 && !bool2 && !bool3) b = 9; 
/*     */       } 
/* 164 */       if (b == 0) {
/* 165 */         if (BlockRailBase.func_150049_b_(this.field_150660_b, this.field_150661_c, this.field_150658_d + 1, this.field_150659_e - 1)) b = 4; 
/* 166 */         if (BlockRailBase.func_150049_b_(this.field_150660_b, this.field_150661_c, this.field_150658_d + 1, this.field_150659_e + 1)) b = 5; 
/*     */       } 
/* 168 */       if (b == 1) {
/* 169 */         if (BlockRailBase.func_150049_b_(this.field_150660_b, this.field_150661_c + 1, this.field_150658_d + 1, this.field_150659_e)) b = 2; 
/* 170 */         if (BlockRailBase.func_150049_b_(this.field_150660_b, this.field_150661_c - 1, this.field_150658_d + 1, this.field_150659_e)) b = 3;
/*     */       
/*     */       } 
/* 173 */       if (b < 0) b = 0;
/*     */       
/* 175 */       int i = b;
/* 176 */       if (this.field_150656_f) {
/* 177 */         i = this.field_150660_b.func_72805_g(this.field_150661_c, this.field_150658_d, this.field_150659_e) & 0x8 | b;
/*     */       }
/*     */       
/* 180 */       this.field_150660_b.func_72921_c(this.field_150661_c, this.field_150658_d, this.field_150659_e, i, 3);
/*     */     }
/*     */     
/*     */     private boolean func_150647_c(int p_150647_1_, int p_150647_2_, int p_150647_3_) {
/* 184 */       Rail rail = func_150654_a(new ChunkPosition(p_150647_1_, p_150647_2_, p_150647_3_));
/* 185 */       if (rail == null) return false; 
/* 186 */       rail.func_150651_b();
/* 187 */       return rail.func_150649_b(this);
/*     */     }
/*     */     
/*     */     public void func_150655_a(boolean p_150655_1_, boolean p_150655_2_) {
/* 191 */       boolean bool1 = func_150647_c(this.field_150661_c, this.field_150658_d, this.field_150659_e - 1);
/* 192 */       boolean bool2 = func_150647_c(this.field_150661_c, this.field_150658_d, this.field_150659_e + 1);
/* 193 */       boolean bool3 = func_150647_c(this.field_150661_c - 1, this.field_150658_d, this.field_150659_e);
/* 194 */       boolean bool4 = func_150647_c(this.field_150661_c + 1, this.field_150658_d, this.field_150659_e);
/*     */       
/* 196 */       byte b = -1;
/*     */       
/* 198 */       if ((bool1 || bool2) && !bool3 && !bool4) b = 0; 
/* 199 */       if ((bool3 || bool4) && !bool1 && !bool2) b = 1;
/*     */       
/* 201 */       if (!this.field_150656_f) {
/* 202 */         if (bool2 && bool4 && !bool1 && !bool3) b = 6; 
/* 203 */         if (bool2 && bool3 && !bool1 && !bool4) b = 7; 
/* 204 */         if (bool1 && bool3 && !bool2 && !bool4) b = 8; 
/* 205 */         if (bool1 && bool4 && !bool2 && !bool3) b = 9; 
/*     */       } 
/* 207 */       if (b == -1) {
/* 208 */         if (bool1 || bool2) b = 0; 
/* 209 */         if (bool3 || bool4) b = 1;
/*     */         
/* 211 */         if (!this.field_150656_f) {
/* 212 */           if (p_150655_1_) {
/* 213 */             if (bool2 && bool4) b = 6; 
/* 214 */             if (bool3 && bool2) b = 7; 
/* 215 */             if (bool4 && bool1) b = 9; 
/* 216 */             if (bool1 && bool3) b = 8; 
/*     */           } else {
/* 218 */             if (bool1 && bool3) b = 8; 
/* 219 */             if (bool4 && bool1) b = 9; 
/* 220 */             if (bool3 && bool2) b = 7; 
/* 221 */             if (bool2 && bool4) b = 6;
/*     */           
/*     */           } 
/*     */         }
/*     */       } 
/* 226 */       if (b == 0) {
/* 227 */         if (BlockRailBase.func_150049_b_(this.field_150660_b, this.field_150661_c, this.field_150658_d + 1, this.field_150659_e - 1)) b = 4; 
/* 228 */         if (BlockRailBase.func_150049_b_(this.field_150660_b, this.field_150661_c, this.field_150658_d + 1, this.field_150659_e + 1)) b = 5; 
/*     */       } 
/* 230 */       if (b == 1) {
/* 231 */         if (BlockRailBase.func_150049_b_(this.field_150660_b, this.field_150661_c + 1, this.field_150658_d + 1, this.field_150659_e)) b = 2; 
/* 232 */         if (BlockRailBase.func_150049_b_(this.field_150660_b, this.field_150661_c - 1, this.field_150658_d + 1, this.field_150659_e)) b = 3;
/*     */       
/*     */       } 
/* 235 */       if (b < 0) b = 0;
/*     */       
/* 237 */       func_150648_a(b);
/*     */       
/* 239 */       int i = b;
/* 240 */       if (this.field_150656_f) {
/* 241 */         i = this.field_150660_b.func_72805_g(this.field_150661_c, this.field_150658_d, this.field_150659_e) & 0x8 | b;
/*     */       }
/*     */       
/* 244 */       if (p_150655_2_ || this.field_150660_b.func_72805_g(this.field_150661_c, this.field_150658_d, this.field_150659_e) != i) {
/* 245 */         this.field_150660_b.func_72921_c(this.field_150661_c, this.field_150658_d, this.field_150659_e, i, 3);
/* 246 */         for (byte b1 = 0; b1 < this.field_150657_g.size(); b1++) {
/* 247 */           Rail rail = func_150654_a(this.field_150657_g.get(b1));
/* 248 */           if (rail != null) {
/* 249 */             rail.func_150651_b();
/*     */             
/* 251 */             if (rail.func_150649_b(this))
/* 252 */               rail.func_150645_c(this); 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static final boolean func_150049_b_(World p_150049_0_, int p_150049_1_, int p_150049_2_, int p_150049_3_) {
/* 260 */     return func_150051_a(p_150049_0_.func_147439_a(p_150049_1_, p_150049_2_, p_150049_3_));
/*     */   }
/*     */   
/*     */   public static final boolean func_150051_a(Block p_150051_0_) {
/* 264 */     return (p_150051_0_ == Blocks.field_150448_aq || p_150051_0_ == Blocks.field_150318_D || p_150051_0_ == Blocks.field_150319_E || p_150051_0_ == Blocks.field_150408_cc);
/*     */   }
/*     */   
/*     */   protected BlockRailBase(boolean p_i45389_1_) {
/* 268 */     super(Material.field_151594_q);
/* 269 */     this.field_150053_a = p_i45389_1_;
/* 270 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
/* 271 */     func_149647_a(CreativeTabs.field_78029_e);
/*     */   }
/*     */   
/*     */   public boolean func_150050_e() {
/* 275 */     return this.field_150053_a;
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/* 280 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 289 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public MovingObjectPosition func_149731_a(World p_149731_1_, int p_149731_2_, int p_149731_3_, int p_149731_4_, Vec3 p_149731_5_, Vec3 p_149731_6_) {
/* 294 */     func_149719_a((IBlockAccess)p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_);
/* 295 */     return super.func_149731_a(p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_, p_149731_5_, p_149731_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/* 300 */     int i = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_);
/* 301 */     if (i >= 2 && i <= 5) {
/* 302 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
/*     */     } else {
/* 304 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 310 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 315 */     return 9;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/* 320 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/* 325 */     if (World.func_147466_a((IBlockAccess)p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_)) {
/* 326 */       return true;
/*     */     }
/* 328 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/* 333 */     if (!p_149726_1_.field_72995_K) {
/* 334 */       func_150052_a(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_, true);
/*     */       
/* 336 */       if (this.field_150053_a) {
/* 337 */         func_149695_a(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_, this);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 344 */     if (p_149695_1_.field_72995_K)
/*     */       return; 
/* 346 */     int i = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
/* 347 */     int j = i;
/* 348 */     if (this.field_150053_a) {
/* 349 */       j &= 0x7;
/*     */     }
/* 351 */     boolean bool = false;
/*     */     
/* 353 */     if (!World.func_147466_a((IBlockAccess)p_149695_1_, p_149695_2_, p_149695_3_ - 1, p_149695_4_)) bool = true; 
/* 354 */     if (j == 2 && !World.func_147466_a((IBlockAccess)p_149695_1_, p_149695_2_ + 1, p_149695_3_, p_149695_4_)) bool = true; 
/* 355 */     if (j == 3 && !World.func_147466_a((IBlockAccess)p_149695_1_, p_149695_2_ - 1, p_149695_3_, p_149695_4_)) bool = true; 
/* 356 */     if (j == 4 && !World.func_147466_a((IBlockAccess)p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_ - 1)) bool = true; 
/* 357 */     if (j == 5 && !World.func_147466_a((IBlockAccess)p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_ + 1)) bool = true;
/*     */     
/* 359 */     if (bool) {
/* 360 */       func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_), 0);
/* 361 */       p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
/*     */     } else {
/* 363 */       func_150048_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, i, j, p_149695_5_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_150048_a(World p_150048_1_, int p_150048_2_, int p_150048_3_, int p_150048_4_, int p_150048_5_, int p_150048_6_, Block p_150048_7_) {}
/*     */   
/*     */   protected void func_150052_a(World p_150052_1_, int p_150052_2_, int p_150052_3_, int p_150052_4_, boolean p_150052_5_) {
/* 371 */     if (p_150052_1_.field_72995_K)
/* 372 */       return;  (new Rail(this, p_150052_1_, p_150052_2_, p_150052_3_, p_150052_4_)).func_150655_a(p_150052_1_.func_72864_z(p_150052_2_, p_150052_3_, p_150052_4_), p_150052_5_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149656_h() {
/* 378 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 383 */     int i = p_149749_6_;
/* 384 */     if (this.field_150053_a) {
/* 385 */       i &= 0x7;
/*     */     }
/*     */     
/* 388 */     super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/*     */     
/* 390 */     if (i == 2 || i == 3 || i == 4 || i == 5) {
/* 391 */       p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_ + 1, p_149749_4_, p_149749_5_);
/*     */     }
/* 393 */     if (this.field_150053_a) {
/* 394 */       p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
/* 395 */       p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_ - 1, p_149749_4_, p_149749_5_);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockRailBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */