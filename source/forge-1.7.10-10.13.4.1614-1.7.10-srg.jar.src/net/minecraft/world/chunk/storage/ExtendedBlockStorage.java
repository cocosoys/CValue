/*     */ package net.minecraft.world.chunk.storage;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.chunk.NibbleArray;
/*     */ 
/*     */ 
/*     */ public class ExtendedBlockStorage
/*     */ {
/*     */   private int field_76684_a;
/*     */   private int field_76682_b;
/*     */   private int field_76683_c;
/*     */   private byte[] field_76680_d;
/*     */   private NibbleArray field_76681_e;
/*     */   private NibbleArray field_76678_f;
/*     */   private NibbleArray field_76679_g;
/*     */   private NibbleArray field_76685_h;
/*     */   private static final String __OBFID = "CL_00000375";
/*     */   
/*     */   public ExtendedBlockStorage(int p_i1997_1_, boolean p_i1997_2_) {
/*  23 */     this.field_76684_a = p_i1997_1_;
/*  24 */     this.field_76680_d = new byte[4096];
/*  25 */     this.field_76678_f = new NibbleArray(this.field_76680_d.length, 4);
/*  26 */     this.field_76679_g = new NibbleArray(this.field_76680_d.length, 4);
/*  27 */     if (p_i1997_2_) {
/*  28 */       this.field_76685_h = new NibbleArray(this.field_76680_d.length, 4);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Block func_150819_a(int p_150819_1_, int p_150819_2_, int p_150819_3_) {
/*  34 */     int i = this.field_76680_d[p_150819_2_ << 8 | p_150819_3_ << 4 | p_150819_1_] & 0xFF;
/*  35 */     if (this.field_76681_e != null) {
/*  36 */       i = this.field_76681_e.func_76582_a(p_150819_1_, p_150819_2_, p_150819_3_) << 8 | i;
/*     */     }
/*  38 */     return Block.func_149729_e(i);
/*     */   }
/*     */   
/*     */   public void func_150818_a(int p_150818_1_, int p_150818_2_, int p_150818_3_, Block p_150818_4_) {
/*  42 */     int i = this.field_76680_d[p_150818_2_ << 8 | p_150818_3_ << 4 | p_150818_1_] & 0xFF;
/*  43 */     if (this.field_76681_e != null) {
/*  44 */       i = this.field_76681_e.func_76582_a(p_150818_1_, p_150818_2_, p_150818_3_) << 8 | i;
/*     */     }
/*     */     
/*  47 */     Block block = Block.func_149729_e(i);
/*  48 */     if (block != Blocks.field_150350_a) {
/*  49 */       this.field_76682_b--;
/*  50 */       if (block.func_149653_t()) {
/*  51 */         this.field_76683_c--;
/*     */       }
/*     */     } 
/*     */     
/*  55 */     if (p_150818_4_ != Blocks.field_150350_a) {
/*  56 */       this.field_76682_b++;
/*  57 */       if (p_150818_4_.func_149653_t()) {
/*  58 */         this.field_76683_c++;
/*     */       }
/*     */     } 
/*     */     
/*  62 */     int j = Block.func_149682_b(p_150818_4_);
/*  63 */     this.field_76680_d[p_150818_2_ << 8 | p_150818_3_ << 4 | p_150818_1_] = (byte)(j & 0xFF);
/*  64 */     if (j > 255) {
/*  65 */       if (this.field_76681_e == null) {
/*  66 */         this.field_76681_e = new NibbleArray(this.field_76680_d.length, 4);
/*     */       }
/*  68 */       this.field_76681_e.func_76581_a(p_150818_1_, p_150818_2_, p_150818_3_, (j & 0xF00) >> 8);
/*  69 */     } else if (this.field_76681_e != null) {
/*  70 */       this.field_76681_e.func_76581_a(p_150818_1_, p_150818_2_, p_150818_3_, 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int func_76665_b(int p_76665_1_, int p_76665_2_, int p_76665_3_) {
/*  75 */     return this.field_76678_f.func_76582_a(p_76665_1_, p_76665_2_, p_76665_3_);
/*     */   }
/*     */   
/*     */   public void func_76654_b(int p_76654_1_, int p_76654_2_, int p_76654_3_, int p_76654_4_) {
/*  79 */     this.field_76678_f.func_76581_a(p_76654_1_, p_76654_2_, p_76654_3_, p_76654_4_);
/*     */   }
/*     */   
/*     */   public boolean func_76663_a() {
/*  83 */     return (this.field_76682_b == 0);
/*     */   }
/*     */   
/*     */   public boolean func_76675_b() {
/*  87 */     return (this.field_76683_c > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_76662_d() {
/*  95 */     return this.field_76684_a;
/*     */   }
/*     */   
/*     */   public void func_76657_c(int p_76657_1_, int p_76657_2_, int p_76657_3_, int p_76657_4_) {
/*  99 */     this.field_76685_h.func_76581_a(p_76657_1_, p_76657_2_, p_76657_3_, p_76657_4_);
/*     */   }
/*     */   
/*     */   public int func_76670_c(int p_76670_1_, int p_76670_2_, int p_76670_3_) {
/* 103 */     return this.field_76685_h.func_76582_a(p_76670_1_, p_76670_2_, p_76670_3_);
/*     */   }
/*     */   
/*     */   public void func_76677_d(int p_76677_1_, int p_76677_2_, int p_76677_3_, int p_76677_4_) {
/* 107 */     this.field_76679_g.func_76581_a(p_76677_1_, p_76677_2_, p_76677_3_, p_76677_4_);
/*     */   }
/*     */   
/*     */   public int func_76674_d(int p_76674_1_, int p_76674_2_, int p_76674_3_) {
/* 111 */     return this.field_76679_g.func_76582_a(p_76674_1_, p_76674_2_, p_76674_3_);
/*     */   }
/*     */   
/*     */   public void func_76672_e() {
/* 115 */     this.field_76682_b = 0;
/* 116 */     this.field_76683_c = 0;
/*     */     
/* 118 */     for (byte b = 0; b < 16; b++) {
/* 119 */       for (byte b1 = 0; b1 < 16; b1++) {
/* 120 */         for (byte b2 = 0; b2 < 16; b2++) {
/* 121 */           Block block = func_150819_a(b, b1, b2);
/*     */           
/* 123 */           if (block != Blocks.field_150350_a) {
/* 124 */             this.field_76682_b++;
/* 125 */             if (block.func_149653_t()) {
/* 126 */               this.field_76683_c++;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] func_76658_g() {
/* 139 */     return this.field_76680_d;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_76676_h() {
/* 143 */     this.field_76681_e = null;
/*     */   }
/*     */   
/*     */   public NibbleArray func_76660_i() {
/* 147 */     return this.field_76681_e;
/*     */   }
/*     */   
/*     */   public NibbleArray func_76669_j() {
/* 151 */     return this.field_76678_f;
/*     */   }
/*     */   
/*     */   public NibbleArray func_76661_k() {
/* 155 */     return this.field_76679_g;
/*     */   }
/*     */   
/*     */   public NibbleArray func_76671_l() {
/* 159 */     return this.field_76685_h;
/*     */   }
/*     */   
/*     */   public void func_76664_a(byte[] p_76664_1_) {
/* 163 */     this.field_76680_d = p_76664_1_;
/*     */   }
/*     */   
/*     */   public void func_76673_a(NibbleArray p_76673_1_) {
/* 167 */     this.field_76681_e = p_76673_1_;
/*     */   }
/*     */   
/*     */   public void func_76668_b(NibbleArray p_76668_1_) {
/* 171 */     this.field_76678_f = p_76668_1_;
/*     */   }
/*     */   
/*     */   public void func_76659_c(NibbleArray p_76659_1_) {
/* 175 */     this.field_76679_g = p_76659_1_;
/*     */   }
/*     */   
/*     */   public void func_76666_d(NibbleArray p_76666_1_) {
/* 179 */     this.field_76685_h = p_76666_1_;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public NibbleArray func_76667_m() {
/* 183 */     this.field_76681_e = new NibbleArray(this.field_76680_d.length, 4);
/* 184 */     return this.field_76681_e;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\chunk\storage\ExtendedBlockStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */