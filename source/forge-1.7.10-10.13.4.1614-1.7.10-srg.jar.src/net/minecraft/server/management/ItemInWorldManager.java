/*     */ package net.minecraft.server.management;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S23PacketBlockChange;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ 
/*     */ public class ItemInWorldManager {
/*     */   public World field_73092_a;
/*     */   public EntityPlayerMP field_73090_b;
/*  16 */   private WorldSettings.GameType field_73091_c = WorldSettings.GameType.NOT_SET;
/*     */   
/*     */   private boolean field_73088_d;
/*     */   
/*     */   private int field_73089_e;
/*     */   
/*     */   private int field_73086_f;
/*     */   
/*     */   private int field_73087_g;
/*     */   private int field_73099_h;
/*  26 */   private int field_73094_o = -1; private int field_73100_i; private boolean field_73097_j; private int field_73098_k; private int field_73095_l; private int field_73096_m; private int field_73093_n; private static final String __OBFID = "CL_00001442";
/*     */   
/*     */   public ItemInWorldManager(World p_i1524_1_) {
/*  29 */     this.field_73092_a = p_i1524_1_;
/*     */   }
/*     */   
/*     */   public void func_73076_a(WorldSettings.GameType p_73076_1_) {
/*  33 */     this.field_73091_c = p_73076_1_;
/*     */     
/*  35 */     p_73076_1_.func_77147_a(this.field_73090_b.field_71075_bZ);
/*     */     
/*  37 */     this.field_73090_b.func_71016_p();
/*     */   }
/*     */   
/*     */   public WorldSettings.GameType func_73081_b() {
/*  41 */     return this.field_73091_c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73083_d() {
/*  49 */     return this.field_73091_c.func_77145_d();
/*     */   }
/*     */   
/*     */   public void func_73077_b(WorldSettings.GameType p_73077_1_) {
/*  53 */     if (this.field_73091_c == WorldSettings.GameType.NOT_SET) {
/*  54 */       this.field_73091_c = p_73077_1_;
/*     */     }
/*  56 */     func_73076_a(this.field_73091_c);
/*     */   }
/*     */   
/*     */   public void func_73075_a() {
/*  60 */     this.field_73100_i++;
/*     */     
/*  62 */     if (this.field_73097_j) {
/*  63 */       int i = this.field_73100_i - this.field_73093_n;
/*  64 */       Block block = this.field_73092_a.func_147439_a(this.field_73098_k, this.field_73095_l, this.field_73096_m);
/*  65 */       if (block.func_149688_o() == Material.field_151579_a) {
/*  66 */         this.field_73097_j = false;
/*     */       } else {
/*  68 */         float f = block.func_149737_a((EntityPlayer)this.field_73090_b, this.field_73090_b.field_70170_p, this.field_73098_k, this.field_73095_l, this.field_73096_m) * (i + 1);
/*  69 */         int j = (int)(f * 10.0F);
/*     */         
/*  71 */         if (j != this.field_73094_o) {
/*  72 */           this.field_73092_a.func_147443_d(this.field_73090_b.func_145782_y(), this.field_73098_k, this.field_73095_l, this.field_73096_m, j);
/*  73 */           this.field_73094_o = j;
/*     */         } 
/*     */         
/*  76 */         if (f >= 1.0F) {
/*  77 */           this.field_73097_j = false;
/*  78 */           func_73084_b(this.field_73098_k, this.field_73095_l, this.field_73096_m);
/*     */         } 
/*     */       } 
/*  81 */     } else if (this.field_73088_d) {
/*  82 */       Block block = this.field_73092_a.func_147439_a(this.field_73086_f, this.field_73087_g, this.field_73099_h);
/*     */       
/*  84 */       if (block.func_149688_o() == Material.field_151579_a) {
/*  85 */         this.field_73092_a.func_147443_d(this.field_73090_b.func_145782_y(), this.field_73086_f, this.field_73087_g, this.field_73099_h, -1);
/*  86 */         this.field_73094_o = -1;
/*  87 */         this.field_73088_d = false;
/*     */       } else {
/*  89 */         int i = this.field_73100_i - this.field_73089_e;
/*  90 */         float f = block.func_149737_a((EntityPlayer)this.field_73090_b, this.field_73090_b.field_70170_p, this.field_73086_f, this.field_73087_g, this.field_73099_h) * (i + 1);
/*  91 */         int j = (int)(f * 10.0F);
/*     */         
/*  93 */         if (j != this.field_73094_o) {
/*  94 */           this.field_73092_a.func_147443_d(this.field_73090_b.func_145782_y(), this.field_73086_f, this.field_73087_g, this.field_73099_h, j);
/*  95 */           this.field_73094_o = j;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_73074_a(int p_73074_1_, int p_73074_2_, int p_73074_3_, int p_73074_4_) {
/* 102 */     if (this.field_73091_c.func_82752_c() && 
/* 103 */       !this.field_73090_b.func_82246_f(p_73074_1_, p_73074_2_, p_73074_3_)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 108 */     if (func_73083_d()) {
/* 109 */       if (!this.field_73092_a.func_72886_a(null, p_73074_1_, p_73074_2_, p_73074_3_, p_73074_4_)) {
/* 110 */         func_73084_b(p_73074_1_, p_73074_2_, p_73074_3_);
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/* 115 */     this.field_73092_a.func_72886_a(null, p_73074_1_, p_73074_2_, p_73074_3_, p_73074_4_);
/* 116 */     this.field_73089_e = this.field_73100_i;
/* 117 */     float f = 1.0F;
/* 118 */     Block block = this.field_73092_a.func_147439_a(p_73074_1_, p_73074_2_, p_73074_3_);
/* 119 */     if (block.func_149688_o() != Material.field_151579_a) {
/* 120 */       block.func_149699_a(this.field_73092_a, p_73074_1_, p_73074_2_, p_73074_3_, (EntityPlayer)this.field_73090_b);
/* 121 */       f = block.func_149737_a((EntityPlayer)this.field_73090_b, this.field_73090_b.field_70170_p, p_73074_1_, p_73074_2_, p_73074_3_);
/*     */     } 
/*     */     
/* 124 */     if (block.func_149688_o() != Material.field_151579_a && f >= 1.0F) {
/* 125 */       func_73084_b(p_73074_1_, p_73074_2_, p_73074_3_);
/*     */     } else {
/* 127 */       this.field_73088_d = true;
/* 128 */       this.field_73086_f = p_73074_1_;
/* 129 */       this.field_73087_g = p_73074_2_;
/* 130 */       this.field_73099_h = p_73074_3_;
/*     */       
/* 132 */       int i = (int)(f * 10.0F);
/* 133 */       this.field_73092_a.func_147443_d(this.field_73090_b.func_145782_y(), p_73074_1_, p_73074_2_, p_73074_3_, i);
/* 134 */       this.field_73094_o = i;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_73082_a(int p_73082_1_, int p_73082_2_, int p_73082_3_) {
/* 139 */     if (p_73082_1_ == this.field_73086_f && p_73082_2_ == this.field_73087_g && p_73082_3_ == this.field_73099_h) {
/* 140 */       int i = this.field_73100_i - this.field_73089_e;
/*     */       
/* 142 */       Block block = this.field_73092_a.func_147439_a(p_73082_1_, p_73082_2_, p_73082_3_);
/* 143 */       if (block.func_149688_o() != Material.field_151579_a) {
/* 144 */         float f = block.func_149737_a((EntityPlayer)this.field_73090_b, this.field_73090_b.field_70170_p, p_73082_1_, p_73082_2_, p_73082_3_) * (i + 1);
/* 145 */         if (f >= 0.7F) {
/* 146 */           this.field_73088_d = false;
/* 147 */           this.field_73092_a.func_147443_d(this.field_73090_b.func_145782_y(), p_73082_1_, p_73082_2_, p_73082_3_, -1);
/* 148 */           func_73084_b(p_73082_1_, p_73082_2_, p_73082_3_);
/* 149 */         } else if (!this.field_73097_j) {
/* 150 */           this.field_73088_d = false;
/* 151 */           this.field_73097_j = true;
/* 152 */           this.field_73098_k = p_73082_1_;
/* 153 */           this.field_73095_l = p_73082_2_;
/* 154 */           this.field_73096_m = p_73082_3_;
/* 155 */           this.field_73093_n = this.field_73089_e;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_73073_c(int p_73073_1_, int p_73073_2_, int p_73073_3_) {
/* 162 */     this.field_73088_d = false;
/*     */     
/* 164 */     this.field_73092_a.func_147443_d(this.field_73090_b.func_145782_y(), this.field_73086_f, this.field_73087_g, this.field_73099_h, -1);
/*     */   }
/*     */   
/*     */   private boolean func_73079_d(int p_73079_1_, int p_73079_2_, int p_73079_3_) {
/* 168 */     Block block = this.field_73092_a.func_147439_a(p_73079_1_, p_73079_2_, p_73079_3_);
/* 169 */     int i = this.field_73092_a.func_72805_g(p_73079_1_, p_73079_2_, p_73079_3_);
/*     */     
/* 171 */     block.func_149681_a(this.field_73092_a, p_73079_1_, p_73079_2_, p_73079_3_, i, (EntityPlayer)this.field_73090_b);
/*     */     
/* 173 */     boolean bool = this.field_73092_a.func_147468_f(p_73079_1_, p_73079_2_, p_73079_3_);
/* 174 */     if (bool) {
/* 175 */       block.func_149664_b(this.field_73092_a, p_73079_1_, p_73079_2_, p_73079_3_, i);
/*     */     }
/* 177 */     return bool;
/*     */   }
/*     */   
/*     */   public boolean func_73084_b(int p_73084_1_, int p_73084_2_, int p_73084_3_) {
/* 181 */     if (this.field_73091_c.func_82752_c() && 
/* 182 */       !this.field_73090_b.func_82246_f(p_73084_1_, p_73084_2_, p_73084_3_)) {
/* 183 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 187 */     if (this.field_73091_c.func_77145_d() && 
/* 188 */       this.field_73090_b.func_70694_bm() != null && this.field_73090_b.func_70694_bm().func_77973_b() instanceof net.minecraft.item.ItemSword) {
/* 189 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 193 */     Block block = this.field_73092_a.func_147439_a(p_73084_1_, p_73084_2_, p_73084_3_);
/* 194 */     int i = this.field_73092_a.func_72805_g(p_73084_1_, p_73084_2_, p_73084_3_);
/*     */     
/* 196 */     this.field_73092_a.func_72889_a((EntityPlayer)this.field_73090_b, 2001, p_73084_1_, p_73084_2_, p_73084_3_, Block.func_149682_b(block) + (this.field_73092_a.func_72805_g(p_73084_1_, p_73084_2_, p_73084_3_) << 12));
/*     */     
/* 198 */     boolean bool = func_73079_d(p_73084_1_, p_73084_2_, p_73084_3_);
/*     */     
/* 200 */     if (func_73083_d()) {
/* 201 */       this.field_73090_b.field_71135_a.func_147359_a((Packet)new S23PacketBlockChange(p_73084_1_, p_73084_2_, p_73084_3_, this.field_73092_a));
/*     */     } else {
/* 203 */       ItemStack itemStack = this.field_73090_b.func_71045_bC();
/* 204 */       boolean bool1 = this.field_73090_b.func_146099_a(block);
/* 205 */       if (itemStack != null) {
/* 206 */         itemStack.func_150999_a(this.field_73092_a, block, p_73084_1_, p_73084_2_, p_73084_3_, (EntityPlayer)this.field_73090_b);
/* 207 */         if (itemStack.field_77994_a == 0) {
/* 208 */           this.field_73090_b.func_71028_bD();
/*     */         }
/*     */       } 
/* 211 */       if (bool && bool1) {
/* 212 */         block.func_149636_a(this.field_73092_a, (EntityPlayer)this.field_73090_b, p_73084_1_, p_73084_2_, p_73084_3_, i);
/*     */       }
/*     */     } 
/* 215 */     return bool;
/*     */   }
/*     */   
/*     */   public boolean func_73085_a(EntityPlayer p_73085_1_, World p_73085_2_, ItemStack p_73085_3_) {
/* 219 */     int i = p_73085_3_.field_77994_a;
/* 220 */     int j = p_73085_3_.func_77960_j();
/* 221 */     ItemStack itemStack = p_73085_3_.func_77957_a(p_73085_2_, p_73085_1_);
/* 222 */     if (itemStack != p_73085_3_ || (itemStack != null && (itemStack.field_77994_a != i || itemStack.func_77988_m() > 0 || itemStack.func_77960_j() != j))) {
/* 223 */       p_73085_1_.field_71071_by.field_70462_a[p_73085_1_.field_71071_by.field_70461_c] = itemStack;
/* 224 */       if (func_73083_d()) {
/* 225 */         itemStack.field_77994_a = i;
/* 226 */         if (itemStack.func_77984_f()) itemStack.func_77964_b(j); 
/*     */       } 
/* 228 */       if (itemStack.field_77994_a == 0) {
/* 229 */         p_73085_1_.field_71071_by.field_70462_a[p_73085_1_.field_71071_by.field_70461_c] = null;
/*     */       }
/* 231 */       if (!p_73085_1_.func_71039_bw()) {
/* 232 */         ((EntityPlayerMP)p_73085_1_).func_71120_a(p_73085_1_.field_71069_bz);
/*     */       }
/* 234 */       return true;
/*     */     } 
/* 236 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_73078_a(EntityPlayer p_73078_1_, World p_73078_2_, ItemStack p_73078_3_, int p_73078_4_, int p_73078_5_, int p_73078_6_, int p_73078_7_, float p_73078_8_, float p_73078_9_, float p_73078_10_) {
/* 240 */     if ((!p_73078_1_.func_70093_af() || p_73078_1_.func_70694_bm() == null) && 
/* 241 */       p_73078_2_.func_147439_a(p_73078_4_, p_73078_5_, p_73078_6_).func_149727_a(p_73078_2_, p_73078_4_, p_73078_5_, p_73078_6_, p_73078_1_, p_73078_7_, p_73078_8_, p_73078_9_, p_73078_10_)) return true;
/*     */ 
/*     */     
/* 244 */     if (p_73078_3_ == null) return false; 
/* 245 */     if (func_73083_d()) {
/* 246 */       int i = p_73078_3_.func_77960_j();
/* 247 */       int j = p_73078_3_.field_77994_a;
/* 248 */       boolean bool = p_73078_3_.func_77943_a(p_73078_1_, p_73078_2_, p_73078_4_, p_73078_5_, p_73078_6_, p_73078_7_, p_73078_8_, p_73078_9_, p_73078_10_);
/* 249 */       p_73078_3_.func_77964_b(i);
/* 250 */       p_73078_3_.field_77994_a = j;
/* 251 */       return bool;
/*     */     } 
/* 253 */     return p_73078_3_.func_77943_a(p_73078_1_, p_73078_2_, p_73078_4_, p_73078_5_, p_73078_6_, p_73078_7_, p_73078_8_, p_73078_9_, p_73078_10_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73080_a(WorldServer p_73080_1_) {
/* 258 */     this.field_73092_a = (World)p_73080_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\ItemInWorldManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */