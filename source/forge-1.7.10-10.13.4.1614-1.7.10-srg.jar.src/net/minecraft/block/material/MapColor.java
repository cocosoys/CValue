/*     */ package net.minecraft.block.material;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.BlockColored;
/*     */ 
/*     */ public class MapColor {
/*   7 */   public static final MapColor[] field_76281_a = new MapColor[64];
/*     */   
/*   9 */   public static final MapColor field_151660_b = new MapColor(0, 0);
/*  10 */   public static final MapColor field_151661_c = new MapColor(1, 8368696);
/*  11 */   public static final MapColor field_151658_d = new MapColor(2, 16247203);
/*  12 */   public static final MapColor field_151659_e = new MapColor(3, 10987431);
/*  13 */   public static final MapColor field_151656_f = new MapColor(4, 16711680);
/*  14 */   public static final MapColor field_151657_g = new MapColor(5, 10526975);
/*  15 */   public static final MapColor field_151668_h = new MapColor(6, 10987431);
/*  16 */   public static final MapColor field_151669_i = new MapColor(7, 31744);
/*  17 */   public static final MapColor field_151666_j = new MapColor(8, 16777215);
/*  18 */   public static final MapColor field_151667_k = new MapColor(9, 10791096);
/*  19 */   public static final MapColor field_151664_l = new MapColor(10, 12020271);
/*  20 */   public static final MapColor field_151665_m = new MapColor(11, 7368816);
/*  21 */   public static final MapColor field_151662_n = new MapColor(12, 4210943);
/*  22 */   public static final MapColor field_151663_o = new MapColor(13, 6837042);
/*  23 */   public static final MapColor field_151677_p = new MapColor(14, 16776437);
/*  24 */   public static final MapColor field_151676_q = new MapColor(15, 14188339);
/*  25 */   public static final MapColor field_151675_r = new MapColor(16, 11685080);
/*  26 */   public static final MapColor field_151674_s = new MapColor(17, 6724056);
/*  27 */   public static final MapColor field_151673_t = new MapColor(18, 15066419);
/*  28 */   public static final MapColor field_151672_u = new MapColor(19, 8375321);
/*  29 */   public static final MapColor field_151671_v = new MapColor(20, 15892389);
/*  30 */   public static final MapColor field_151670_w = new MapColor(21, 5000268);
/*  31 */   public static final MapColor field_151680_x = new MapColor(22, 10066329);
/*  32 */   public static final MapColor field_151679_y = new MapColor(23, 5013401);
/*  33 */   public static final MapColor field_151678_z = new MapColor(24, 8339378);
/*  34 */   public static final MapColor field_151649_A = new MapColor(25, 3361970);
/*  35 */   public static final MapColor field_151650_B = new MapColor(26, 6704179);
/*  36 */   public static final MapColor field_151651_C = new MapColor(27, 6717235);
/*  37 */   public static final MapColor field_151645_D = new MapColor(28, 10040115);
/*  38 */   public static final MapColor field_151646_E = new MapColor(29, 1644825);
/*  39 */   public static final MapColor field_151647_F = new MapColor(30, 16445005);
/*  40 */   public static final MapColor field_151648_G = new MapColor(31, 6085589);
/*  41 */   public static final MapColor field_151652_H = new MapColor(32, 4882687);
/*  42 */   public static final MapColor field_151653_I = new MapColor(33, 55610);
/*  43 */   public static final MapColor field_151654_J = new MapColor(34, 1381407);
/*  44 */   public static final MapColor field_151655_K = new MapColor(35, 7340544);
/*     */   public final int field_76291_p;
/*     */   public final int field_76290_q;
/*     */   private static final String __OBFID = "CL_00000544";
/*     */   
/*     */   private MapColor(int p_i2117_1_, int p_i2117_2_) {
/*  50 */     if (p_i2117_1_ < 0 || p_i2117_1_ > 63) throw new IndexOutOfBoundsException("Map colour ID must be between 0 and 63 (inclusive)"); 
/*  51 */     this.field_76290_q = p_i2117_1_;
/*  52 */     this.field_76291_p = p_i2117_2_;
/*  53 */     field_76281_a[p_i2117_1_] = this;
/*     */   }
/*     */   
/*     */   public static MapColor func_151644_a(int p_151644_0_) {
/*  57 */     switch (BlockColored.func_150031_c(p_151644_0_)) {
/*     */       case 0:
/*  59 */         return field_151646_E;
/*     */       case 1:
/*  61 */         return field_151645_D;
/*     */       case 2:
/*  63 */         return field_151651_C;
/*     */       case 3:
/*  65 */         return field_151650_B;
/*     */       case 4:
/*  67 */         return field_151649_A;
/*     */       case 5:
/*  69 */         return field_151678_z;
/*     */       case 6:
/*  71 */         return field_151679_y;
/*     */       case 7:
/*  73 */         return field_151680_x;
/*     */       case 8:
/*  75 */         return field_151670_w;
/*     */       case 9:
/*  77 */         return field_151671_v;
/*     */       case 10:
/*  79 */         return field_151672_u;
/*     */       case 11:
/*  81 */         return field_151673_t;
/*     */       case 12:
/*  83 */         return field_151674_s;
/*     */       case 13:
/*  85 */         return field_151675_r;
/*     */       case 14:
/*  87 */         return field_151676_q;
/*     */       case 15:
/*  89 */         return field_151666_j;
/*     */     } 
/*     */     
/*  92 */     return field_151660_b;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_151643_b(int p_151643_1_) {
/*  96 */     char c = 'Ü';
/*  97 */     if (p_151643_1_ == 3) c = ''; 
/*  98 */     if (p_151643_1_ == 2) c = 'ÿ'; 
/*  99 */     if (p_151643_1_ == 1) c = 'Ü'; 
/* 100 */     if (p_151643_1_ == 0) c = '´';
/*     */     
/* 102 */     int i = (this.field_76291_p >> 16 & 0xFF) * c / 255;
/* 103 */     int j = (this.field_76291_p >> 8 & 0xFF) * c / 255;
/* 104 */     int k = (this.field_76291_p & 0xFF) * c / 255;
/*     */     
/* 106 */     return 0xFF000000 | i << 16 | j << 8 | k;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\material\MapColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */