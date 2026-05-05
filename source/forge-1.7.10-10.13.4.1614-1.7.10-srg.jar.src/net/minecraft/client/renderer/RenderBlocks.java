/*      */ package net.minecraft.client.renderer;@SideOnly(Side.CLIENT)
/*      */ public class RenderBlocks { public IBlockAccess field_147845_a; public IIcon field_147840_d; public boolean field_147842_e;
/*      */   public boolean field_152631_f;
/*      */   public boolean field_147837_f;
/*      */   public static boolean field_147843_b = true;
/*      */   public boolean field_147844_c = true;
/*      */   public boolean field_147838_g = false;
/*      */   public double field_147859_h;
/*      */   public double field_147861_i;
/*      */   public double field_147855_j;
/*      */   public double field_147857_k;
/*      */   public double field_147851_l;
/*      */   public double field_147853_m;
/*      */   public boolean field_147847_n;
/*      */   public boolean field_147849_o;
/*      */   public final Minecraft field_147877_p;
/*      */   public int field_147875_q;
/*      */   public int field_147873_r;
/*      */   public int field_147871_s;
/*      */   public int field_147869_t;
/*      */   public int field_147867_u;
/*      */   public int field_147865_v;
/*      */   public boolean field_147863_w;
/*      */   public float field_147888_x;
/*      */   public float field_147886_y;
/*      */   public float field_147884_z;
/*      */   public float field_147814_A;
/*      */   public float field_147815_B;
/*      */   public float field_147816_C;
/*      */   public float field_147810_D;
/*      */   public float field_147811_E;
/*      */   public float field_147812_F;
/*      */   public float field_147813_G;
/*      */   public float field_147821_H;
/*      */   public float field_147822_I;
/*      */   public float field_147823_J;
/*      */   public float field_147824_K;
/*      */   public float field_147817_L;
/*      */   public float field_147818_M;
/*      */   
/*      */   public RenderBlocks(IBlockAccess p_i1251_1_) {
/*   42 */     this.field_147845_a = p_i1251_1_;
/*   43 */     this.field_152631_f = false;
/*   44 */     this.field_147842_e = false;
/*   45 */     this.field_147877_p = Minecraft.func_71410_x();
/*      */   }
/*      */   public float field_147819_N; public float field_147820_O; public float field_147830_P; public float field_147829_Q; public int field_147832_R; public int field_147831_S; public int field_147826_T; public int field_147825_U; public int field_147828_V; public int field_147827_W; public int field_147835_X; public int field_147834_Y; public int field_147836_Z; public int field_147880_aa; public int field_147881_ab; public int field_147878_ac; public int field_147879_ad; public int field_147885_ae; public int field_147887_af; public int field_147882_ag; public int field_147883_ah; public int field_147866_ai; public int field_147868_aj; public int field_147862_ak; public int field_147864_al; public int field_147874_am; public int field_147876_an; public int field_147870_ao; public float field_147872_ap; public float field_147852_aq; public float field_147850_ar; public float field_147848_as; public float field_147846_at; public float field_147860_au; public float field_147858_av; public float field_147856_aw; public float field_147854_ax; public float field_147841_ay; public float field_147839_az; public float field_147833_aA; private static final String __OBFID = "CL_00000940";
/*      */   public RenderBlocks() {
/*   49 */     this.field_147877_p = Minecraft.func_71410_x();
/*      */   }
/*      */   
/*      */   public void func_147757_a(IIcon p_147757_1_) {
/*   53 */     this.field_147840_d = p_147757_1_;
/*      */   }
/*      */   
/*      */   public void func_147771_a() {
/*   57 */     this.field_147840_d = null;
/*      */   }
/*      */   
/*      */   public boolean func_147744_b() {
/*   61 */     return (this.field_147840_d != null);
/*      */   }
/*      */   
/*      */   public void func_147786_a(boolean p_147786_1_) {
/*   65 */     this.field_147838_g = p_147786_1_;
/*      */   }
/*      */   
/*      */   public void func_147753_b(boolean p_147753_1_) {
/*   69 */     this.field_147837_f = p_147753_1_;
/*      */   }
/*      */   
/*      */   public void func_147782_a(double p_147782_1_, double p_147782_3_, double p_147782_5_, double p_147782_7_, double p_147782_9_, double p_147782_11_) {
/*   73 */     if (!this.field_147847_n) {
/*   74 */       this.field_147859_h = p_147782_1_;
/*   75 */       this.field_147861_i = p_147782_7_;
/*   76 */       this.field_147855_j = p_147782_3_;
/*   77 */       this.field_147857_k = p_147782_9_;
/*   78 */       this.field_147851_l = p_147782_5_;
/*   79 */       this.field_147853_m = p_147782_11_;
/*   80 */       this.field_147849_o = (this.field_147877_p.field_71474_y.field_74348_k >= 2 && (this.field_147859_h > 0.0D || this.field_147861_i < 1.0D || this.field_147855_j > 0.0D || this.field_147857_k < 1.0D || this.field_147851_l > 0.0D || this.field_147853_m < 1.0D));
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_147775_a(Block p_147775_1_) {
/*   85 */     if (!this.field_147847_n) {
/*   86 */       this.field_147859_h = p_147775_1_.func_149704_x();
/*   87 */       this.field_147861_i = p_147775_1_.func_149753_y();
/*   88 */       this.field_147855_j = p_147775_1_.func_149665_z();
/*   89 */       this.field_147857_k = p_147775_1_.func_149669_A();
/*   90 */       this.field_147851_l = p_147775_1_.func_149706_B();
/*   91 */       this.field_147853_m = p_147775_1_.func_149693_C();
/*   92 */       this.field_147849_o = (this.field_147877_p.field_71474_y.field_74348_k >= 2 && (this.field_147859_h > 0.0D || this.field_147861_i < 1.0D || this.field_147855_j > 0.0D || this.field_147857_k < 1.0D || this.field_147851_l > 0.0D || this.field_147853_m < 1.0D));
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_147770_b(double p_147770_1_, double p_147770_3_, double p_147770_5_, double p_147770_7_, double p_147770_9_, double p_147770_11_) {
/*   97 */     this.field_147859_h = p_147770_1_;
/*   98 */     this.field_147861_i = p_147770_7_;
/*   99 */     this.field_147855_j = p_147770_3_;
/*  100 */     this.field_147857_k = p_147770_9_;
/*  101 */     this.field_147851_l = p_147770_5_;
/*  102 */     this.field_147853_m = p_147770_11_;
/*  103 */     this.field_147847_n = true;
/*      */     
/*  105 */     this.field_147849_o = (this.field_147877_p.field_71474_y.field_74348_k >= 2 && (this.field_147859_h > 0.0D || this.field_147861_i < 1.0D || this.field_147855_j > 0.0D || this.field_147857_k < 1.0D || this.field_147851_l > 0.0D || this.field_147853_m < 1.0D));
/*      */   }
/*      */   
/*      */   public void func_147762_c() {
/*  109 */     this.field_147847_n = false;
/*      */   }
/*      */   
/*      */   public void func_147792_a(Block p_147792_1_, int p_147792_2_, int p_147792_3_, int p_147792_4_, IIcon p_147792_5_) {
/*  113 */     func_147757_a(p_147792_5_);
/*  114 */     func_147805_b(p_147792_1_, p_147792_2_, p_147792_3_, p_147792_4_);
/*  115 */     func_147771_a();
/*      */   }
/*      */   
/*      */   public void func_147769_a(Block p_147769_1_, int p_147769_2_, int p_147769_3_, int p_147769_4_) {
/*  119 */     this.field_147837_f = true;
/*  120 */     func_147805_b(p_147769_1_, p_147769_2_, p_147769_3_, p_147769_4_);
/*  121 */     this.field_147837_f = false;
/*      */   }
/*      */   
/*      */   public boolean func_147805_b(Block p_147805_1_, int p_147805_2_, int p_147805_3_, int p_147805_4_) {
/*  125 */     int i = p_147805_1_.func_149645_b();
/*      */     
/*  127 */     if (i == -1) {
/*  128 */       return false;
/*      */     }
/*      */     
/*  131 */     p_147805_1_.func_149719_a(this.field_147845_a, p_147805_2_, p_147805_3_, p_147805_4_);
/*  132 */     func_147775_a(p_147805_1_);
/*  133 */     if (i == 0)
/*  134 */       return func_147784_q(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  135 */     if (i == 4)
/*  136 */       return func_147721_p(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  137 */     if (i == 31)
/*  138 */       return func_147742_r(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  139 */     if (i == 1)
/*  140 */       return func_147746_l(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  141 */     if (i == 40)
/*  142 */       return func_147774_a((BlockDoublePlant)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  143 */     if (i == 2)
/*  144 */       return func_147791_c(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  145 */     if (i == 20)
/*  146 */       return func_147726_j(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  147 */     if (i == 11)
/*  148 */       return func_147735_a((BlockFence)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  149 */     if (i == 39)
/*  150 */       return func_147779_s(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  151 */     if (i == 5)
/*  152 */       return func_147788_h(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  153 */     if (i == 13)
/*  154 */       return func_147755_t(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  155 */     if (i == 9)
/*  156 */       return func_147766_a((BlockRailBase)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  157 */     if (i == 19)
/*  158 */       return func_147724_m(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  159 */     if (i == 23)
/*  160 */       return func_147783_o(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  161 */     if (i == 6)
/*  162 */       return func_147796_n(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  163 */     if (i == 3)
/*  164 */       return func_147801_a((BlockFire)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  165 */     if (i == 8)
/*  166 */       return func_147794_i(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  167 */     if (i == 7)
/*  168 */       return func_147760_u(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  169 */     if (i == 10)
/*  170 */       return func_147722_a((BlockStairs)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  171 */     if (i == 27)
/*  172 */       return func_147802_a((BlockDragonEgg)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  173 */     if (i == 32)
/*  174 */       return func_147807_a((BlockWall)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  175 */     if (i == 12)
/*  176 */       return func_147790_e(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  177 */     if (i == 29)
/*  178 */       return func_147723_f(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  179 */     if (i == 30)
/*  180 */       return func_147756_g(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  181 */     if (i == 14)
/*  182 */       return func_147773_v(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  183 */     if (i == 15)
/*  184 */       return func_147759_a((BlockRedstoneRepeater)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  185 */     if (i == 36)
/*  186 */       return func_147748_a((BlockRedstoneDiode)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  187 */     if (i == 37)
/*  188 */       return func_147781_a((BlockRedstoneComparator)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  189 */     if (i == 16)
/*  190 */       return func_147731_b(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_, false); 
/*  191 */     if (i == 17)
/*  192 */       return func_147809_c(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_, true); 
/*  193 */     if (i == 18)
/*  194 */       return func_147767_a((BlockPane)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  195 */     if (i == 41)
/*  196 */       return func_147733_k(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  197 */     if (i == 21)
/*  198 */       return func_147776_a((BlockFenceGate)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  199 */     if (i == 24)
/*  200 */       return func_147785_a((BlockCauldron)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  201 */     if (i == 33)
/*  202 */       return func_147752_a((BlockFlowerPot)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  203 */     if (i == 35)
/*  204 */       return func_147725_a((BlockAnvil)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  205 */     if (i == 25)
/*  206 */       return func_147741_a((BlockBrewingStand)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  207 */     if (i == 26)
/*  208 */       return func_147743_a((BlockEndPortalFrame)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  209 */     if (i == 28)
/*  210 */       return func_147772_a((BlockCocoa)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  211 */     if (i == 34)
/*  212 */       return func_147797_a((BlockBeacon)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_); 
/*  213 */     if (i == 38) {
/*  214 */       return func_147803_a((BlockHopper)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_);
/*      */     }
/*  216 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_147743_a(BlockEndPortalFrame p_147743_1_, int p_147743_2_, int p_147743_3_, int p_147743_4_) {
/*  221 */     int i = this.field_147845_a.func_72805_g(p_147743_2_, p_147743_3_, p_147743_4_);
/*      */     
/*  223 */     int j = i & 0x3;
/*  224 */     if (j == 0) {
/*  225 */       this.field_147867_u = 3;
/*  226 */     } else if (j == 3) {
/*  227 */       this.field_147867_u = 1;
/*  228 */     } else if (j == 1) {
/*  229 */       this.field_147867_u = 2;
/*      */     } 
/*      */     
/*  232 */     if (!BlockEndPortalFrame.func_150020_b(i)) {
/*  233 */       func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D);
/*  234 */       func_147784_q((Block)p_147743_1_, p_147743_2_, p_147743_3_, p_147743_4_);
/*      */       
/*  236 */       this.field_147867_u = 0;
/*  237 */       return true;
/*      */     } 
/*      */     
/*  240 */     this.field_147837_f = true;
/*  241 */     func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D);
/*  242 */     func_147784_q((Block)p_147743_1_, p_147743_2_, p_147743_3_, p_147743_4_);
/*  243 */     func_147757_a(p_147743_1_.func_150021_e());
/*  244 */     func_147782_a(0.25D, 0.8125D, 0.25D, 0.75D, 1.0D, 0.75D);
/*  245 */     func_147784_q((Block)p_147743_1_, p_147743_2_, p_147743_3_, p_147743_4_);
/*  246 */     this.field_147837_f = false;
/*  247 */     func_147771_a();
/*      */     
/*  249 */     this.field_147867_u = 0;
/*  250 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_147773_v(Block p_147773_1_, int p_147773_2_, int p_147773_3_, int p_147773_4_) {
/*  255 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/*  257 */     int i = this.field_147845_a.func_72805_g(p_147773_2_, p_147773_3_, p_147773_4_);
/*  258 */     int j = BlockBed.func_149895_l(i);
/*  259 */     boolean bool = BlockBed.func_149975_b(i);
/*      */     
/*  261 */     float f1 = 0.5F;
/*  262 */     float f2 = 1.0F;
/*  263 */     float f3 = 0.8F;
/*  264 */     float f4 = 0.6F;
/*      */     
/*  266 */     float f5 = f2;
/*  267 */     float f6 = f2;
/*  268 */     float f7 = f2;
/*      */     
/*  270 */     float f8 = f1;
/*  271 */     float f9 = f3;
/*  272 */     float f10 = f4;
/*      */     
/*  274 */     float f11 = f1;
/*  275 */     float f12 = f3;
/*  276 */     float f13 = f4;
/*      */     
/*  278 */     float f14 = f1;
/*  279 */     float f15 = f3;
/*  280 */     float f16 = f4;
/*      */ 
/*      */     
/*  283 */     int k = p_147773_1_.func_149677_c(this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_);
/*      */ 
/*      */ 
/*      */     
/*  287 */     tessellator.func_78380_c(k);
/*  288 */     tessellator.func_78386_a(f8, f11, f14);
/*      */     
/*  290 */     IIcon iIcon = func_147793_a(p_147773_1_, this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_, 0);
/*  291 */     double d1 = iIcon.func_94209_e();
/*  292 */     double d2 = iIcon.func_94212_f();
/*  293 */     double d3 = iIcon.func_94206_g();
/*  294 */     double d4 = iIcon.func_94210_h();
/*      */     
/*  296 */     double d5 = p_147773_2_ + this.field_147859_h;
/*  297 */     double d6 = p_147773_2_ + this.field_147861_i;
/*  298 */     double d7 = p_147773_3_ + this.field_147855_j + 0.1875D;
/*  299 */     double d8 = p_147773_4_ + this.field_147851_l;
/*  300 */     double d9 = p_147773_4_ + this.field_147853_m;
/*      */     
/*  302 */     tessellator.func_78374_a(d5, d7, d9, d1, d4);
/*  303 */     tessellator.func_78374_a(d5, d7, d8, d1, d3);
/*  304 */     tessellator.func_78374_a(d6, d7, d8, d2, d3);
/*  305 */     tessellator.func_78374_a(d6, d7, d9, d2, d4);
/*      */ 
/*      */ 
/*      */     
/*  309 */     tessellator.func_78380_c(p_147773_1_.func_149677_c(this.field_147845_a, p_147773_2_, p_147773_3_ + 1, p_147773_4_));
/*  310 */     tessellator.func_78386_a(f5, f6, f7);
/*      */     
/*  312 */     iIcon = func_147793_a(p_147773_1_, this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_, 1);
/*  313 */     d1 = iIcon.func_94209_e();
/*  314 */     d2 = iIcon.func_94212_f();
/*  315 */     d3 = iIcon.func_94206_g();
/*  316 */     d4 = iIcon.func_94210_h();
/*      */     
/*  318 */     d5 = d1;
/*  319 */     d6 = d2;
/*  320 */     d7 = d3;
/*  321 */     d8 = d3;
/*  322 */     d9 = d1;
/*  323 */     double d10 = d2;
/*  324 */     double d11 = d4;
/*  325 */     double d12 = d4;
/*      */     
/*  327 */     if (j == 0) {
/*      */       
/*  329 */       d6 = d1;
/*  330 */       d7 = d4;
/*  331 */       d9 = d2;
/*  332 */       d12 = d3;
/*  333 */     } else if (j == 2) {
/*      */       
/*  335 */       d5 = d2;
/*  336 */       d8 = d4;
/*  337 */       d10 = d1;
/*  338 */       d11 = d3;
/*  339 */     } else if (j == 3) {
/*      */       
/*  341 */       d5 = d2;
/*  342 */       d8 = d4;
/*  343 */       d10 = d1;
/*  344 */       d11 = d3;
/*  345 */       d6 = d1;
/*  346 */       d7 = d4;
/*  347 */       d9 = d2;
/*  348 */       d12 = d3;
/*      */     } 
/*      */     
/*  351 */     double d13 = p_147773_2_ + this.field_147859_h;
/*  352 */     double d14 = p_147773_2_ + this.field_147861_i;
/*  353 */     double d15 = p_147773_3_ + this.field_147857_k;
/*  354 */     double d16 = p_147773_4_ + this.field_147851_l;
/*  355 */     double d17 = p_147773_4_ + this.field_147853_m;
/*      */     
/*  357 */     tessellator.func_78374_a(d14, d15, d17, d9, d11);
/*  358 */     tessellator.func_78374_a(d14, d15, d16, d5, d7);
/*  359 */     tessellator.func_78374_a(d13, d15, d16, d6, d8);
/*  360 */     tessellator.func_78374_a(d13, d15, d17, d10, d12);
/*      */ 
/*      */     
/*  363 */     int m = Direction.field_71582_c[j];
/*  364 */     if (bool) {
/*  365 */       m = Direction.field_71582_c[Direction.field_71580_e[j]];
/*      */     }
/*      */     
/*  368 */     byte b = 4;
/*  369 */     switch (j) {
/*      */ 
/*      */       
/*      */       case 0:
/*  373 */         b = 5;
/*      */         break;
/*      */       case 3:
/*  376 */         b = 2;
/*      */         break;
/*      */       case 1:
/*  379 */         b = 3;
/*      */         break;
/*      */     } 
/*      */     
/*  383 */     if (m != 2 && (this.field_147837_f || p_147773_1_.func_149646_a(this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_ - 1, 2))) {
/*  384 */       tessellator.func_78380_c((this.field_147851_l > 0.0D) ? k : p_147773_1_.func_149677_c(this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_ - 1));
/*  385 */       tessellator.func_78386_a(f9, f12, f15);
/*  386 */       this.field_147842_e = (b == 2);
/*  387 */       func_147761_c(p_147773_1_, p_147773_2_, p_147773_3_, p_147773_4_, func_147793_a(p_147773_1_, this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_, 2));
/*      */     } 
/*      */     
/*  390 */     if (m != 3 && (this.field_147837_f || p_147773_1_.func_149646_a(this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_ + 1, 3))) {
/*  391 */       tessellator.func_78380_c((this.field_147853_m < 1.0D) ? k : p_147773_1_.func_149677_c(this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_ + 1));
/*  392 */       tessellator.func_78386_a(f9, f12, f15);
/*  393 */       this.field_147842_e = (b == 3);
/*  394 */       func_147734_d(p_147773_1_, p_147773_2_, p_147773_3_, p_147773_4_, func_147793_a(p_147773_1_, this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_, 3));
/*      */     } 
/*      */     
/*  397 */     if (m != 4 && (this.field_147837_f || p_147773_1_.func_149646_a(this.field_147845_a, p_147773_2_ - 1, p_147773_3_, p_147773_4_, 4))) {
/*  398 */       tessellator.func_78380_c((this.field_147851_l > 0.0D) ? k : p_147773_1_.func_149677_c(this.field_147845_a, p_147773_2_ - 1, p_147773_3_, p_147773_4_));
/*  399 */       tessellator.func_78386_a(f10, f13, f16);
/*  400 */       this.field_147842_e = (b == 4);
/*  401 */       func_147798_e(p_147773_1_, p_147773_2_, p_147773_3_, p_147773_4_, func_147793_a(p_147773_1_, this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_, 4));
/*      */     } 
/*      */     
/*  404 */     if (m != 5 && (this.field_147837_f || p_147773_1_.func_149646_a(this.field_147845_a, p_147773_2_ + 1, p_147773_3_, p_147773_4_, 5))) {
/*  405 */       tessellator.func_78380_c((this.field_147853_m < 1.0D) ? k : p_147773_1_.func_149677_c(this.field_147845_a, p_147773_2_ + 1, p_147773_3_, p_147773_4_));
/*  406 */       tessellator.func_78386_a(f10, f13, f16);
/*  407 */       this.field_147842_e = (b == 5);
/*  408 */       func_147764_f(p_147773_1_, p_147773_2_, p_147773_3_, p_147773_4_, func_147793_a(p_147773_1_, this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_, 5));
/*      */     } 
/*  410 */     this.field_147842_e = false;
/*  411 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_147741_a(BlockBrewingStand p_147741_1_, int p_147741_2_, int p_147741_3_, int p_147741_4_) {
/*  417 */     func_147782_a(0.4375D, 0.0D, 0.4375D, 0.5625D, 0.875D, 0.5625D);
/*  418 */     func_147784_q((Block)p_147741_1_, p_147741_2_, p_147741_3_, p_147741_4_);
/*      */     
/*  420 */     func_147757_a(p_147741_1_.func_149959_e());
/*      */ 
/*      */     
/*  423 */     this.field_147837_f = true;
/*  424 */     func_147782_a(0.5625D, 0.0D, 0.3125D, 0.9375D, 0.125D, 0.6875D);
/*  425 */     func_147784_q((Block)p_147741_1_, p_147741_2_, p_147741_3_, p_147741_4_);
/*  426 */     func_147782_a(0.125D, 0.0D, 0.0625D, 0.5D, 0.125D, 0.4375D);
/*  427 */     func_147784_q((Block)p_147741_1_, p_147741_2_, p_147741_3_, p_147741_4_);
/*  428 */     func_147782_a(0.125D, 0.0D, 0.5625D, 0.5D, 0.125D, 0.9375D);
/*  429 */     func_147784_q((Block)p_147741_1_, p_147741_2_, p_147741_3_, p_147741_4_);
/*  430 */     this.field_147837_f = false;
/*      */     
/*  432 */     func_147771_a();
/*      */     
/*  434 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/*  436 */     tessellator.func_78380_c(p_147741_1_.func_149677_c(this.field_147845_a, p_147741_2_, p_147741_3_, p_147741_4_));
/*  437 */     int i = p_147741_1_.func_149720_d(this.field_147845_a, p_147741_2_, p_147741_3_, p_147741_4_);
/*  438 */     float f1 = (i >> 16 & 0xFF) / 255.0F;
/*  439 */     float f2 = (i >> 8 & 0xFF) / 255.0F;
/*  440 */     float f3 = (i & 0xFF) / 255.0F;
/*      */     
/*  442 */     if (EntityRenderer.field_78517_a) {
/*  443 */       float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
/*  444 */       float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
/*  445 */       float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
/*      */       
/*  447 */       f1 = f4;
/*  448 */       f2 = f5;
/*  449 */       f3 = f6;
/*      */     } 
/*  451 */     tessellator.func_78386_a(f1, f2, f3);
/*      */     
/*  453 */     IIcon iIcon = func_147787_a((Block)p_147741_1_, 0, 0);
/*      */     
/*  455 */     if (func_147744_b()) iIcon = this.field_147840_d; 
/*  456 */     double d1 = iIcon.func_94206_g();
/*  457 */     double d2 = iIcon.func_94210_h();
/*      */     
/*  459 */     int j = this.field_147845_a.func_72805_g(p_147741_2_, p_147741_3_, p_147741_4_);
/*      */     
/*  461 */     for (byte b = 0; b < 3; b++) {
/*      */       
/*  463 */       double d3 = b * Math.PI * 2.0D / 3.0D + 1.5707963267948966D;
/*      */       
/*  465 */       double d4 = iIcon.func_94214_a(8.0D);
/*  466 */       double d5 = iIcon.func_94212_f();
/*  467 */       if ((j & 1 << b) != 0) {
/*  468 */         d5 = iIcon.func_94209_e();
/*      */       }
/*      */       
/*  471 */       double d6 = p_147741_2_ + 0.5D;
/*  472 */       double d7 = p_147741_2_ + 0.5D + Math.sin(d3) * 8.0D / 16.0D;
/*  473 */       double d8 = p_147741_4_ + 0.5D;
/*  474 */       double d9 = p_147741_4_ + 0.5D + Math.cos(d3) * 8.0D / 16.0D;
/*      */       
/*  476 */       tessellator.func_78374_a(d6, (p_147741_3_ + 1), d8, d4, d1);
/*  477 */       tessellator.func_78374_a(d6, (p_147741_3_ + 0), d8, d4, d2);
/*  478 */       tessellator.func_78374_a(d7, (p_147741_3_ + 0), d9, d5, d2);
/*  479 */       tessellator.func_78374_a(d7, (p_147741_3_ + 1), d9, d5, d1);
/*      */       
/*  481 */       tessellator.func_78374_a(d7, (p_147741_3_ + 1), d9, d5, d1);
/*  482 */       tessellator.func_78374_a(d7, (p_147741_3_ + 0), d9, d5, d2);
/*  483 */       tessellator.func_78374_a(d6, (p_147741_3_ + 0), d8, d4, d2);
/*  484 */       tessellator.func_78374_a(d6, (p_147741_3_ + 1), d8, d4, d1);
/*      */     } 
/*      */     
/*  487 */     p_147741_1_.func_149683_g();
/*      */     
/*  489 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_147785_a(BlockCauldron p_147785_1_, int p_147785_2_, int p_147785_3_, int p_147785_4_) {
/*  494 */     func_147784_q((Block)p_147785_1_, p_147785_2_, p_147785_3_, p_147785_4_);
/*      */     
/*  496 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/*  498 */     tessellator.func_78380_c(p_147785_1_.func_149677_c(this.field_147845_a, p_147785_2_, p_147785_3_, p_147785_4_));
/*  499 */     int i = p_147785_1_.func_149720_d(this.field_147845_a, p_147785_2_, p_147785_3_, p_147785_4_);
/*  500 */     float f1 = (i >> 16 & 0xFF) / 255.0F;
/*  501 */     float f2 = (i >> 8 & 0xFF) / 255.0F;
/*  502 */     float f3 = (i & 0xFF) / 255.0F;
/*      */     
/*  504 */     if (EntityRenderer.field_78517_a) {
/*  505 */       float f5 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
/*  506 */       float f6 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
/*  507 */       float f7 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
/*      */       
/*  509 */       f1 = f5;
/*  510 */       f2 = f6;
/*  511 */       f3 = f7;
/*      */     } 
/*  513 */     tessellator.func_78386_a(f1, f2, f3);
/*      */ 
/*      */     
/*  516 */     IIcon iIcon1 = p_147785_1_.func_149733_h(2);
/*  517 */     float f4 = 0.125F;
/*  518 */     func_147764_f((Block)p_147785_1_, (p_147785_2_ - 1.0F + f4), p_147785_3_, p_147785_4_, iIcon1);
/*  519 */     func_147798_e((Block)p_147785_1_, (p_147785_2_ + 1.0F - f4), p_147785_3_, p_147785_4_, iIcon1);
/*  520 */     func_147734_d((Block)p_147785_1_, p_147785_2_, p_147785_3_, (p_147785_4_ - 1.0F + f4), iIcon1);
/*  521 */     func_147761_c((Block)p_147785_1_, p_147785_2_, p_147785_3_, (p_147785_4_ + 1.0F - f4), iIcon1);
/*      */     
/*  523 */     IIcon iIcon2 = BlockCauldron.func_150026_e("inner");
/*  524 */     func_147806_b((Block)p_147785_1_, p_147785_2_, (p_147785_3_ - 1.0F + 0.25F), p_147785_4_, iIcon2);
/*  525 */     func_147768_a((Block)p_147785_1_, p_147785_2_, (p_147785_3_ + 1.0F - 0.75F), p_147785_4_, iIcon2);
/*      */     
/*  527 */     int j = this.field_147845_a.func_72805_g(p_147785_2_, p_147785_3_, p_147785_4_);
/*  528 */     if (j > 0) {
/*  529 */       IIcon iIcon = BlockLiquid.func_149803_e("water_still");
/*      */       
/*  531 */       func_147806_b((Block)p_147785_1_, p_147785_2_, (p_147785_3_ - 1.0F + BlockCauldron.func_150025_c(j)), p_147785_4_, iIcon);
/*      */     } 
/*      */     
/*  534 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_147752_a(BlockFlowerPot p_147752_1_, int p_147752_2_, int p_147752_3_, int p_147752_4_) {
/*  539 */     func_147784_q((Block)p_147752_1_, p_147752_2_, p_147752_3_, p_147752_4_);
/*      */     
/*  541 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/*  543 */     tessellator.func_78380_c(p_147752_1_.func_149677_c(this.field_147845_a, p_147752_2_, p_147752_3_, p_147752_4_));
/*  544 */     int i = p_147752_1_.func_149720_d(this.field_147845_a, p_147752_2_, p_147752_3_, p_147752_4_);
/*  545 */     IIcon iIcon = func_147777_a((Block)p_147752_1_, 0);
/*  546 */     float f1 = (i >> 16 & 0xFF) / 255.0F;
/*  547 */     float f2 = (i >> 8 & 0xFF) / 255.0F;
/*  548 */     float f3 = (i & 0xFF) / 255.0F;
/*      */     
/*  550 */     if (EntityRenderer.field_78517_a) {
/*  551 */       float f5 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
/*  552 */       float f6 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
/*  553 */       float f7 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
/*      */       
/*  555 */       f1 = f5;
/*  556 */       f2 = f6;
/*  557 */       f3 = f7;
/*      */     } 
/*  559 */     tessellator.func_78386_a(f1, f2, f3);
/*      */ 
/*      */ 
/*      */     
/*  563 */     float f4 = 0.1865F;
/*  564 */     func_147764_f((Block)p_147752_1_, (p_147752_2_ - 0.5F + f4), p_147752_3_, p_147752_4_, iIcon);
/*  565 */     func_147798_e((Block)p_147752_1_, (p_147752_2_ + 0.5F - f4), p_147752_3_, p_147752_4_, iIcon);
/*  566 */     func_147734_d((Block)p_147752_1_, p_147752_2_, p_147752_3_, (p_147752_4_ - 0.5F + f4), iIcon);
/*  567 */     func_147761_c((Block)p_147752_1_, p_147752_2_, p_147752_3_, (p_147752_4_ + 0.5F - f4), iIcon);
/*      */     
/*  569 */     func_147806_b((Block)p_147752_1_, p_147752_2_, (p_147752_3_ - 0.5F + f4 + 0.1875F), p_147752_4_, func_147745_b(Blocks.field_150346_d));
/*      */     
/*  571 */     TileEntity tileEntity = this.field_147845_a.func_147438_o(p_147752_2_, p_147752_3_, p_147752_4_);
/*  572 */     if (tileEntity != null && tileEntity instanceof TileEntityFlowerPot) {
/*  573 */       Item item = ((TileEntityFlowerPot)tileEntity).func_145965_a();
/*  574 */       int j = ((TileEntityFlowerPot)tileEntity).func_145966_b();
/*      */       
/*  576 */       if (item instanceof net.minecraft.item.ItemBlock) {
/*  577 */         Block block = Block.func_149634_a(item);
/*  578 */         int k = block.func_149645_b();
/*      */         
/*  580 */         float f5 = 0.0F;
/*  581 */         float f6 = 4.0F;
/*  582 */         float f7 = 0.0F;
/*      */         
/*  584 */         tessellator.func_78372_c(f5 / 16.0F, f6 / 16.0F, f7 / 16.0F);
/*      */         
/*  586 */         i = block.func_149720_d(this.field_147845_a, p_147752_2_, p_147752_3_, p_147752_4_);
/*  587 */         if (i != 16777215) {
/*  588 */           f1 = (i >> 16 & 0xFF) / 255.0F;
/*  589 */           f2 = (i >> 8 & 0xFF) / 255.0F;
/*  590 */           f3 = (i & 0xFF) / 255.0F;
/*  591 */           tessellator.func_78386_a(f1, f2, f3);
/*      */         } 
/*      */         
/*  594 */         if (k == 1) {
/*  595 */           func_147765_a(func_147787_a(block, 0, j), p_147752_2_, p_147752_3_, p_147752_4_, 0.75F);
/*  596 */         } else if (k == 13) {
/*      */           
/*  598 */           this.field_147837_f = true;
/*      */           
/*  600 */           float f = 0.125F;
/*  601 */           func_147782_a((0.5F - f), 0.0D, (0.5F - f), (0.5F + f), 0.25D, (0.5F + f));
/*  602 */           func_147784_q(block, p_147752_2_, p_147752_3_, p_147752_4_);
/*  603 */           func_147782_a((0.5F - f), 0.25D, (0.5F - f), (0.5F + f), 0.5D, (0.5F + f));
/*  604 */           func_147784_q(block, p_147752_2_, p_147752_3_, p_147752_4_);
/*  605 */           func_147782_a((0.5F - f), 0.5D, (0.5F - f), (0.5F + f), 0.75D, (0.5F + f));
/*  606 */           func_147784_q(block, p_147752_2_, p_147752_3_, p_147752_4_);
/*  607 */           this.field_147837_f = false;
/*      */           
/*  609 */           func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/*      */         } 
/*      */         
/*  612 */         tessellator.func_78372_c(-f5 / 16.0F, -f6 / 16.0F, -f7 / 16.0F);
/*      */       } 
/*      */     } 
/*      */     
/*  616 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147725_a(BlockAnvil p_147725_1_, int p_147725_2_, int p_147725_3_, int p_147725_4_) {
/*  620 */     return func_147780_a(p_147725_1_, p_147725_2_, p_147725_3_, p_147725_4_, this.field_147845_a.func_72805_g(p_147725_2_, p_147725_3_, p_147725_4_));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_147780_a(BlockAnvil p_147780_1_, int p_147780_2_, int p_147780_3_, int p_147780_4_, int p_147780_5_) {
/*  625 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/*  627 */     tessellator.func_78380_c(p_147780_1_.func_149677_c(this.field_147845_a, p_147780_2_, p_147780_3_, p_147780_4_));
/*  628 */     int i = p_147780_1_.func_149720_d(this.field_147845_a, p_147780_2_, p_147780_3_, p_147780_4_);
/*  629 */     float f1 = (i >> 16 & 0xFF) / 255.0F;
/*  630 */     float f2 = (i >> 8 & 0xFF) / 255.0F;
/*  631 */     float f3 = (i & 0xFF) / 255.0F;
/*      */     
/*  633 */     if (EntityRenderer.field_78517_a) {
/*  634 */       float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
/*  635 */       float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
/*  636 */       float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
/*      */       
/*  638 */       f1 = f4;
/*  639 */       f2 = f5;
/*  640 */       f3 = f6;
/*      */     } 
/*  642 */     tessellator.func_78386_a(f1, f2, f3);
/*      */     
/*  644 */     return func_147728_a(p_147780_1_, p_147780_2_, p_147780_3_, p_147780_4_, p_147780_5_, false);
/*      */   }
/*      */   
/*      */   public boolean func_147728_a(BlockAnvil p_147728_1_, int p_147728_2_, int p_147728_3_, int p_147728_4_, int p_147728_5_, boolean p_147728_6_) {
/*  648 */     boolean bool1 = p_147728_6_ ? false : (p_147728_5_ & 0x3);
/*  649 */     boolean bool2 = false;
/*  650 */     float f = 0.0F;
/*      */     
/*  652 */     switch (bool1) {
/*      */       case true:
/*  654 */         this.field_147871_s = 1;
/*  655 */         this.field_147869_t = 2;
/*      */         break;
/*      */       case false:
/*  658 */         this.field_147871_s = 2;
/*  659 */         this.field_147869_t = 1;
/*  660 */         this.field_147867_u = 3;
/*  661 */         this.field_147865_v = 3;
/*      */         break;
/*      */       case true:
/*  664 */         this.field_147875_q = 1;
/*  665 */         this.field_147873_r = 2;
/*  666 */         this.field_147867_u = 2;
/*  667 */         this.field_147865_v = 1;
/*  668 */         bool2 = true;
/*      */         break;
/*      */       case true:
/*  671 */         this.field_147875_q = 2;
/*  672 */         this.field_147873_r = 1;
/*  673 */         this.field_147867_u = 1;
/*  674 */         this.field_147865_v = 2;
/*  675 */         bool2 = true;
/*      */         break;
/*      */     } 
/*      */     
/*  679 */     f = func_147737_a(p_147728_1_, p_147728_2_, p_147728_3_, p_147728_4_, 0, f, 0.75F, 0.25F, 0.75F, bool2, p_147728_6_, p_147728_5_);
/*  680 */     f = func_147737_a(p_147728_1_, p_147728_2_, p_147728_3_, p_147728_4_, 1, f, 0.5F, 0.0625F, 0.625F, bool2, p_147728_6_, p_147728_5_);
/*  681 */     f = func_147737_a(p_147728_1_, p_147728_2_, p_147728_3_, p_147728_4_, 2, f, 0.25F, 0.3125F, 0.5F, bool2, p_147728_6_, p_147728_5_);
/*  682 */     f = func_147737_a(p_147728_1_, p_147728_2_, p_147728_3_, p_147728_4_, 3, f, 0.625F, 0.375F, 1.0F, bool2, p_147728_6_, p_147728_5_);
/*      */     
/*  684 */     func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/*  685 */     this.field_147875_q = 0;
/*  686 */     this.field_147873_r = 0;
/*  687 */     this.field_147871_s = 0;
/*  688 */     this.field_147869_t = 0;
/*  689 */     this.field_147867_u = 0;
/*  690 */     this.field_147865_v = 0;
/*      */     
/*  692 */     return true;
/*      */   }
/*      */   
/*      */   public float func_147737_a(BlockAnvil p_147737_1_, int p_147737_2_, int p_147737_3_, int p_147737_4_, int p_147737_5_, float p_147737_6_, float p_147737_7_, float p_147737_8_, float p_147737_9_, boolean p_147737_10_, boolean p_147737_11_, int p_147737_12_) {
/*  696 */     if (p_147737_10_) {
/*  697 */       float f = p_147737_7_;
/*  698 */       p_147737_7_ = p_147737_9_;
/*  699 */       p_147737_9_ = f;
/*      */     } 
/*      */     
/*  702 */     p_147737_7_ /= 2.0F;
/*  703 */     p_147737_9_ /= 2.0F;
/*      */     
/*  705 */     p_147737_1_.field_149833_b = p_147737_5_;
/*  706 */     func_147782_a((0.5F - p_147737_7_), p_147737_6_, (0.5F - p_147737_9_), (0.5F + p_147737_7_), (p_147737_6_ + p_147737_8_), (0.5F + p_147737_9_));
/*      */     
/*  708 */     if (p_147737_11_) {
/*  709 */       Tessellator tessellator = Tessellator.field_78398_a;
/*  710 */       tessellator.func_78382_b();
/*  711 */       tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/*  712 */       func_147768_a((Block)p_147737_1_, 0.0D, 0.0D, 0.0D, func_147787_a((Block)p_147737_1_, 0, p_147737_12_));
/*  713 */       tessellator.func_78381_a();
/*      */       
/*  715 */       tessellator.func_78382_b();
/*  716 */       tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/*  717 */       func_147806_b((Block)p_147737_1_, 0.0D, 0.0D, 0.0D, func_147787_a((Block)p_147737_1_, 1, p_147737_12_));
/*  718 */       tessellator.func_78381_a();
/*      */       
/*  720 */       tessellator.func_78382_b();
/*  721 */       tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/*  722 */       func_147761_c((Block)p_147737_1_, 0.0D, 0.0D, 0.0D, func_147787_a((Block)p_147737_1_, 2, p_147737_12_));
/*  723 */       tessellator.func_78381_a();
/*      */       
/*  725 */       tessellator.func_78382_b();
/*  726 */       tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/*  727 */       func_147734_d((Block)p_147737_1_, 0.0D, 0.0D, 0.0D, func_147787_a((Block)p_147737_1_, 3, p_147737_12_));
/*  728 */       tessellator.func_78381_a();
/*      */       
/*  730 */       tessellator.func_78382_b();
/*  731 */       tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/*  732 */       func_147798_e((Block)p_147737_1_, 0.0D, 0.0D, 0.0D, func_147787_a((Block)p_147737_1_, 4, p_147737_12_));
/*  733 */       tessellator.func_78381_a();
/*      */       
/*  735 */       tessellator.func_78382_b();
/*  736 */       tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/*  737 */       func_147764_f((Block)p_147737_1_, 0.0D, 0.0D, 0.0D, func_147787_a((Block)p_147737_1_, 5, p_147737_12_));
/*  738 */       tessellator.func_78381_a();
/*      */     } else {
/*  740 */       func_147784_q((Block)p_147737_1_, p_147737_2_, p_147737_3_, p_147737_4_);
/*      */     } 
/*      */     
/*  743 */     return p_147737_6_ + p_147737_8_;
/*      */   }
/*      */   
/*      */   public boolean func_147791_c(Block p_147791_1_, int p_147791_2_, int p_147791_3_, int p_147791_4_) {
/*  747 */     int i = this.field_147845_a.func_72805_g(p_147791_2_, p_147791_3_, p_147791_4_);
/*      */     
/*  749 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/*  751 */     tessellator.func_78380_c(p_147791_1_.func_149677_c(this.field_147845_a, p_147791_2_, p_147791_3_, p_147791_4_));
/*  752 */     tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/*      */     
/*  754 */     double d1 = 0.4000000059604645D;
/*  755 */     double d2 = 0.5D - d1;
/*  756 */     double d3 = 0.20000000298023224D;
/*  757 */     if (i == 1) {
/*  758 */       func_147747_a(p_147791_1_, p_147791_2_ - d2, p_147791_3_ + d3, p_147791_4_, -d1, 0.0D, 0);
/*  759 */     } else if (i == 2) {
/*  760 */       func_147747_a(p_147791_1_, p_147791_2_ + d2, p_147791_3_ + d3, p_147791_4_, d1, 0.0D, 0);
/*  761 */     } else if (i == 3) {
/*  762 */       func_147747_a(p_147791_1_, p_147791_2_, p_147791_3_ + d3, p_147791_4_ - d2, 0.0D, -d1, 0);
/*  763 */     } else if (i == 4) {
/*  764 */       func_147747_a(p_147791_1_, p_147791_2_, p_147791_3_ + d3, p_147791_4_ + d2, 0.0D, d1, 0);
/*      */     } else {
/*  766 */       func_147747_a(p_147791_1_, p_147791_2_, p_147791_3_, p_147791_4_, 0.0D, 0.0D, 0);
/*      */     } 
/*  768 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147759_a(BlockRedstoneRepeater p_147759_1_, int p_147759_2_, int p_147759_3_, int p_147759_4_) {
/*  772 */     int i = this.field_147845_a.func_72805_g(p_147759_2_, p_147759_3_, p_147759_4_);
/*  773 */     int j = i & 0x3;
/*  774 */     int k = (i & 0xC) >> 2;
/*      */     
/*  776 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/*  778 */     tessellator.func_78380_c(p_147759_1_.func_149677_c(this.field_147845_a, p_147759_2_, p_147759_3_, p_147759_4_));
/*  779 */     tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/*      */     
/*  781 */     double d1 = -0.1875D;
/*  782 */     boolean bool = p_147759_1_.func_149910_g(this.field_147845_a, p_147759_2_, p_147759_3_, p_147759_4_, i);
/*  783 */     double d2 = 0.0D;
/*  784 */     double d3 = 0.0D;
/*  785 */     double d4 = 0.0D;
/*  786 */     double d5 = 0.0D;
/*      */     
/*  788 */     switch (j) {
/*      */       case 0:
/*  790 */         d5 = -0.3125D;
/*  791 */         d3 = BlockRedstoneRepeater.field_149973_b[k];
/*      */         break;
/*      */       case 2:
/*  794 */         d5 = 0.3125D;
/*  795 */         d3 = -BlockRedstoneRepeater.field_149973_b[k];
/*      */         break;
/*      */       case 3:
/*  798 */         d4 = -0.3125D;
/*  799 */         d2 = BlockRedstoneRepeater.field_149973_b[k];
/*      */         break;
/*      */       case 1:
/*  802 */         d4 = 0.3125D;
/*  803 */         d2 = -BlockRedstoneRepeater.field_149973_b[k];
/*      */         break;
/*      */     } 
/*      */ 
/*      */     
/*  808 */     if (!bool) {
/*  809 */       func_147747_a((Block)p_147759_1_, p_147759_2_ + d2, p_147759_3_ + d1, p_147759_4_ + d3, 0.0D, 0.0D, 0);
/*      */     } else {
/*  811 */       IIcon iIcon = func_147745_b(Blocks.field_150357_h);
/*  812 */       func_147757_a(iIcon);
/*      */       
/*  814 */       float f1 = 2.0F;
/*  815 */       float f2 = 14.0F;
/*  816 */       float f3 = 7.0F;
/*  817 */       float f4 = 9.0F;
/*      */       
/*  819 */       switch (j) {
/*      */ 
/*      */ 
/*      */         
/*      */         case 1:
/*      */         case 3:
/*  825 */           f1 = 7.0F;
/*  826 */           f2 = 9.0F;
/*  827 */           f3 = 2.0F;
/*  828 */           f4 = 14.0F;
/*      */           break;
/*      */       } 
/*  831 */       func_147782_a((f1 / 16.0F + (float)d2), 0.125D, (f3 / 16.0F + (float)d3), (f2 / 16.0F + (float)d2), 0.25D, (f4 / 16.0F + (float)d3));
/*  832 */       double d6 = iIcon.func_94214_a(f1);
/*  833 */       double d7 = iIcon.func_94207_b(f3);
/*  834 */       double d8 = iIcon.func_94214_a(f2);
/*  835 */       double d9 = iIcon.func_94207_b(f4);
/*  836 */       tessellator.func_78374_a((p_147759_2_ + f1 / 16.0F) + d2, (p_147759_3_ + 0.25F), (p_147759_4_ + f3 / 16.0F) + d3, d6, d7);
/*  837 */       tessellator.func_78374_a((p_147759_2_ + f1 / 16.0F) + d2, (p_147759_3_ + 0.25F), (p_147759_4_ + f4 / 16.0F) + d3, d6, d9);
/*  838 */       tessellator.func_78374_a((p_147759_2_ + f2 / 16.0F) + d2, (p_147759_3_ + 0.25F), (p_147759_4_ + f4 / 16.0F) + d3, d8, d9);
/*  839 */       tessellator.func_78374_a((p_147759_2_ + f2 / 16.0F) + d2, (p_147759_3_ + 0.25F), (p_147759_4_ + f3 / 16.0F) + d3, d8, d7);
/*  840 */       func_147784_q((Block)p_147759_1_, p_147759_2_, p_147759_3_, p_147759_4_);
/*  841 */       func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D);
/*  842 */       func_147771_a();
/*      */     } 
/*      */     
/*  845 */     tessellator.func_78380_c(p_147759_1_.func_149677_c(this.field_147845_a, p_147759_2_, p_147759_3_, p_147759_4_));
/*  846 */     tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/*      */ 
/*      */     
/*  849 */     func_147747_a((Block)p_147759_1_, p_147759_2_ + d4, p_147759_3_ + d1, p_147759_4_ + d5, 0.0D, 0.0D, 0);
/*      */ 
/*      */     
/*  852 */     func_147748_a((BlockRedstoneDiode)p_147759_1_, p_147759_2_, p_147759_3_, p_147759_4_);
/*      */     
/*  854 */     return true;
/*      */   }
/*      */   public boolean func_147781_a(BlockRedstoneComparator p_147781_1_, int p_147781_2_, int p_147781_3_, int p_147781_4_) {
/*      */     IIcon iIcon;
/*  858 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/*  860 */     tessellator.func_78380_c(p_147781_1_.func_149677_c(this.field_147845_a, p_147781_2_, p_147781_3_, p_147781_4_));
/*  861 */     tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/*      */     
/*  863 */     int i = this.field_147845_a.func_72805_g(p_147781_2_, p_147781_3_, p_147781_4_);
/*  864 */     int j = i & 0x3;
/*  865 */     double d1 = 0.0D;
/*  866 */     double d2 = -0.1875D;
/*  867 */     double d3 = 0.0D;
/*  868 */     double d4 = 0.0D;
/*  869 */     double d5 = 0.0D;
/*      */ 
/*      */     
/*  872 */     if (p_147781_1_.func_149969_d(i)) {
/*  873 */       iIcon = Blocks.field_150429_aA.func_149733_h(0);
/*      */     } else {
/*  875 */       d2 -= 0.1875D;
/*  876 */       iIcon = Blocks.field_150437_az.func_149733_h(0);
/*      */     } 
/*      */     
/*  879 */     switch (j) {
/*      */       case 0:
/*  881 */         d3 = -0.3125D;
/*  882 */         d5 = 1.0D;
/*      */         break;
/*      */       case 2:
/*  885 */         d3 = 0.3125D;
/*  886 */         d5 = -1.0D;
/*      */         break;
/*      */       case 3:
/*  889 */         d1 = -0.3125D;
/*  890 */         d4 = 1.0D;
/*      */         break;
/*      */       case 1:
/*  893 */         d1 = 0.3125D;
/*  894 */         d4 = -1.0D;
/*      */         break;
/*      */     } 
/*      */ 
/*      */     
/*  899 */     func_147747_a((Block)p_147781_1_, p_147781_2_ + 0.25D * d4 + 0.1875D * d5, (p_147781_3_ - 0.1875F), p_147781_4_ + 0.25D * d5 + 0.1875D * d4, 0.0D, 0.0D, i);
/*  900 */     func_147747_a((Block)p_147781_1_, p_147781_2_ + 0.25D * d4 + -0.1875D * d5, (p_147781_3_ - 0.1875F), p_147781_4_ + 0.25D * d5 + -0.1875D * d4, 0.0D, 0.0D, i);
/*      */     
/*  902 */     func_147757_a(iIcon);
/*  903 */     func_147747_a((Block)p_147781_1_, p_147781_2_ + d1, p_147781_3_ + d2, p_147781_4_ + d3, 0.0D, 0.0D, i);
/*  904 */     func_147771_a();
/*      */     
/*  906 */     func_147732_a((BlockRedstoneDiode)p_147781_1_, p_147781_2_, p_147781_3_, p_147781_4_, j);
/*      */     
/*  908 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147748_a(BlockRedstoneDiode p_147748_1_, int p_147748_2_, int p_147748_3_, int p_147748_4_) {
/*  912 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/*  914 */     func_147732_a(p_147748_1_, p_147748_2_, p_147748_3_, p_147748_4_, this.field_147845_a.func_72805_g(p_147748_2_, p_147748_3_, p_147748_4_) & 0x3);
/*      */     
/*  916 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147732_a(BlockRedstoneDiode p_147732_1_, int p_147732_2_, int p_147732_3_, int p_147732_4_, int p_147732_5_) {
/*  921 */     func_147784_q((Block)p_147732_1_, p_147732_2_, p_147732_3_, p_147732_4_);
/*      */     
/*  923 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/*  925 */     tessellator.func_78380_c(p_147732_1_.func_149677_c(this.field_147845_a, p_147732_2_, p_147732_3_, p_147732_4_));
/*  926 */     tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/*  927 */     int i = this.field_147845_a.func_72805_g(p_147732_2_, p_147732_3_, p_147732_4_);
/*  928 */     IIcon iIcon = func_147787_a((Block)p_147732_1_, 1, i);
/*  929 */     double d1 = iIcon.func_94209_e();
/*  930 */     double d2 = iIcon.func_94212_f();
/*  931 */     double d3 = iIcon.func_94206_g();
/*  932 */     double d4 = iIcon.func_94210_h();
/*      */     
/*  934 */     double d5 = 0.125D;
/*      */     
/*  936 */     double d6 = (p_147732_2_ + 1);
/*  937 */     double d7 = (p_147732_2_ + 1);
/*  938 */     double d8 = (p_147732_2_ + 0);
/*  939 */     double d9 = (p_147732_2_ + 0);
/*      */     
/*  941 */     double d10 = (p_147732_4_ + 0);
/*  942 */     double d11 = (p_147732_4_ + 1);
/*  943 */     double d12 = (p_147732_4_ + 1);
/*  944 */     double d13 = (p_147732_4_ + 0);
/*      */     
/*  946 */     double d14 = p_147732_3_ + d5;
/*      */ 
/*      */ 
/*      */     
/*  950 */     d6 = d7 = (p_147732_2_ + 0);
/*  951 */     d8 = d9 = (p_147732_2_ + 1);
/*  952 */     d10 = d13 = (p_147732_4_ + 1);
/*  953 */     d11 = d12 = (p_147732_4_ + 0);
/*      */ 
/*      */     
/*  956 */     d6 = d9 = (p_147732_2_ + 0);
/*  957 */     d7 = d8 = (p_147732_2_ + 1);
/*  958 */     d10 = d11 = (p_147732_4_ + 0);
/*  959 */     d12 = d13 = (p_147732_4_ + 1);
/*  960 */     if (p_147732_5_ == 1) {
/*      */       
/*  962 */       d6 = d9 = (p_147732_2_ + 1);
/*  963 */       d7 = d8 = (p_147732_2_ + 0);
/*  964 */       d10 = d11 = (p_147732_4_ + 1);
/*  965 */       d12 = d13 = (p_147732_4_ + 0);
/*      */     } 
/*      */ 
/*      */     
/*  969 */     tessellator.func_78374_a(d9, d14, d13, d1, d3);
/*  970 */     tessellator.func_78374_a(d8, d14, d12, d1, d4);
/*  971 */     tessellator.func_78374_a(d7, d14, d11, d2, d4);
/*  972 */     tessellator.func_78374_a(d6, d14, d10, d2, d3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_147804_d(Block p_147804_1_, int p_147804_2_, int p_147804_3_, int p_147804_4_) {
/*  985 */     this.field_147837_f = true;
/*  986 */     func_147731_b(p_147804_1_, p_147804_2_, p_147804_3_, p_147804_4_, true);
/*  987 */     this.field_147837_f = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_147731_b(Block p_147731_1_, int p_147731_2_, int p_147731_3_, int p_147731_4_, boolean p_147731_5_) {
/*  992 */     int i = this.field_147845_a.func_72805_g(p_147731_2_, p_147731_3_, p_147731_4_);
/*  993 */     boolean bool = (p_147731_5_ || (i & 0x8) != 0) ? true : false;
/*  994 */     int j = BlockPistonBase.func_150076_b(i);
/*      */     
/*  996 */     float f = 0.25F;
/*      */     
/*  998 */     if (bool) {
/*  999 */       switch (j) {
/*      */         case 0:
/* 1001 */           this.field_147875_q = 3;
/* 1002 */           this.field_147873_r = 3;
/* 1003 */           this.field_147871_s = 3;
/* 1004 */           this.field_147869_t = 3;
/* 1005 */           func_147782_a(0.0D, 0.25D, 0.0D, 1.0D, 1.0D, 1.0D);
/*      */           break;
/*      */         case 1:
/* 1008 */           func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);
/*      */           break;
/*      */         case 2:
/* 1011 */           this.field_147871_s = 1;
/* 1012 */           this.field_147869_t = 2;
/* 1013 */           func_147782_a(0.0D, 0.0D, 0.25D, 1.0D, 1.0D, 1.0D);
/*      */           break;
/*      */         case 3:
/* 1016 */           this.field_147871_s = 2;
/* 1017 */           this.field_147869_t = 1;
/* 1018 */           this.field_147867_u = 3;
/* 1019 */           this.field_147865_v = 3;
/* 1020 */           func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.75D);
/*      */           break;
/*      */         case 4:
/* 1023 */           this.field_147875_q = 1;
/* 1024 */           this.field_147873_r = 2;
/* 1025 */           this.field_147867_u = 2;
/* 1026 */           this.field_147865_v = 1;
/* 1027 */           func_147782_a(0.25D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/*      */           break;
/*      */         case 5:
/* 1030 */           this.field_147875_q = 2;
/* 1031 */           this.field_147873_r = 1;
/* 1032 */           this.field_147867_u = 1;
/* 1033 */           this.field_147865_v = 2;
/* 1034 */           func_147782_a(0.0D, 0.0D, 0.0D, 0.75D, 1.0D, 1.0D);
/*      */           break;
/*      */       } 
/*      */       
/* 1038 */       ((BlockPistonBase)p_147731_1_).func_150070_b((float)this.field_147859_h, (float)this.field_147855_j, (float)this.field_147851_l, (float)this.field_147861_i, (float)this.field_147857_k, (float)this.field_147853_m);
/* 1039 */       func_147784_q(p_147731_1_, p_147731_2_, p_147731_3_, p_147731_4_);
/* 1040 */       this.field_147875_q = 0;
/* 1041 */       this.field_147873_r = 0;
/* 1042 */       this.field_147871_s = 0;
/* 1043 */       this.field_147869_t = 0;
/* 1044 */       this.field_147867_u = 0;
/* 1045 */       this.field_147865_v = 0;
/* 1046 */       func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 1047 */       ((BlockPistonBase)p_147731_1_).func_150070_b((float)this.field_147859_h, (float)this.field_147855_j, (float)this.field_147851_l, (float)this.field_147861_i, (float)this.field_147857_k, (float)this.field_147853_m);
/*      */     } else {
/* 1049 */       switch (j) {
/*      */         case 0:
/* 1051 */           this.field_147875_q = 3;
/* 1052 */           this.field_147873_r = 3;
/* 1053 */           this.field_147871_s = 3;
/* 1054 */           this.field_147869_t = 3;
/*      */           break;
/*      */ 
/*      */         
/*      */         case 2:
/* 1059 */           this.field_147871_s = 1;
/* 1060 */           this.field_147869_t = 2;
/*      */           break;
/*      */         case 3:
/* 1063 */           this.field_147871_s = 2;
/* 1064 */           this.field_147869_t = 1;
/* 1065 */           this.field_147867_u = 3;
/* 1066 */           this.field_147865_v = 3;
/*      */           break;
/*      */         case 4:
/* 1069 */           this.field_147875_q = 1;
/* 1070 */           this.field_147873_r = 2;
/* 1071 */           this.field_147867_u = 2;
/* 1072 */           this.field_147865_v = 1;
/*      */           break;
/*      */         case 5:
/* 1075 */           this.field_147875_q = 2;
/* 1076 */           this.field_147873_r = 1;
/* 1077 */           this.field_147867_u = 1;
/* 1078 */           this.field_147865_v = 2;
/*      */           break;
/*      */       } 
/* 1081 */       func_147784_q(p_147731_1_, p_147731_2_, p_147731_3_, p_147731_4_);
/* 1082 */       this.field_147875_q = 0;
/* 1083 */       this.field_147873_r = 0;
/* 1084 */       this.field_147871_s = 0;
/* 1085 */       this.field_147869_t = 0;
/* 1086 */       this.field_147867_u = 0;
/* 1087 */       this.field_147865_v = 0;
/*      */     } 
/*      */     
/* 1090 */     return true;
/*      */   }
/*      */   
/*      */   public void func_147763_a(double p_147763_1_, double p_147763_3_, double p_147763_5_, double p_147763_7_, double p_147763_9_, double p_147763_11_, float p_147763_13_, double p_147763_14_) {
/* 1094 */     IIcon iIcon = BlockPistonBase.func_150074_e("piston_side");
/* 1095 */     if (func_147744_b()) iIcon = this.field_147840_d;
/*      */     
/* 1097 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */ 
/*      */     
/* 1100 */     double d1 = iIcon.func_94209_e();
/* 1101 */     double d2 = iIcon.func_94206_g();
/* 1102 */     double d3 = iIcon.func_94214_a(p_147763_14_);
/* 1103 */     double d4 = iIcon.func_94207_b(4.0D);
/*      */     
/* 1105 */     tessellator.func_78386_a(p_147763_13_, p_147763_13_, p_147763_13_);
/*      */     
/* 1107 */     tessellator.func_78374_a(p_147763_1_, p_147763_7_, p_147763_9_, d3, d2);
/* 1108 */     tessellator.func_78374_a(p_147763_1_, p_147763_5_, p_147763_9_, d1, d2);
/* 1109 */     tessellator.func_78374_a(p_147763_3_, p_147763_5_, p_147763_11_, d1, d4);
/* 1110 */     tessellator.func_78374_a(p_147763_3_, p_147763_7_, p_147763_11_, d3, d4);
/*      */   }
/*      */   
/*      */   public void func_147789_b(double p_147789_1_, double p_147789_3_, double p_147789_5_, double p_147789_7_, double p_147789_9_, double p_147789_11_, float p_147789_13_, double p_147789_14_) {
/* 1114 */     IIcon iIcon = BlockPistonBase.func_150074_e("piston_side");
/* 1115 */     if (func_147744_b()) iIcon = this.field_147840_d;
/*      */     
/* 1117 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */ 
/*      */     
/* 1120 */     double d1 = iIcon.func_94209_e();
/* 1121 */     double d2 = iIcon.func_94206_g();
/* 1122 */     double d3 = iIcon.func_94214_a(p_147789_14_);
/* 1123 */     double d4 = iIcon.func_94207_b(4.0D);
/*      */     
/* 1125 */     tessellator.func_78386_a(p_147789_13_, p_147789_13_, p_147789_13_);
/*      */     
/* 1127 */     tessellator.func_78374_a(p_147789_1_, p_147789_5_, p_147789_11_, d3, d2);
/* 1128 */     tessellator.func_78374_a(p_147789_1_, p_147789_5_, p_147789_9_, d1, d2);
/* 1129 */     tessellator.func_78374_a(p_147789_3_, p_147789_7_, p_147789_9_, d1, d4);
/* 1130 */     tessellator.func_78374_a(p_147789_3_, p_147789_7_, p_147789_11_, d3, d4);
/*      */   }
/*      */   
/*      */   public void func_147738_c(double p_147738_1_, double p_147738_3_, double p_147738_5_, double p_147738_7_, double p_147738_9_, double p_147738_11_, float p_147738_13_, double p_147738_14_) {
/* 1134 */     IIcon iIcon = BlockPistonBase.func_150074_e("piston_side");
/* 1135 */     if (func_147744_b()) iIcon = this.field_147840_d;
/*      */     
/* 1137 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */ 
/*      */     
/* 1140 */     double d1 = iIcon.func_94209_e();
/* 1141 */     double d2 = iIcon.func_94206_g();
/* 1142 */     double d3 = iIcon.func_94214_a(p_147738_14_);
/* 1143 */     double d4 = iIcon.func_94207_b(4.0D);
/*      */     
/* 1145 */     tessellator.func_78386_a(p_147738_13_, p_147738_13_, p_147738_13_);
/*      */     
/* 1147 */     tessellator.func_78374_a(p_147738_3_, p_147738_5_, p_147738_9_, d3, d2);
/* 1148 */     tessellator.func_78374_a(p_147738_1_, p_147738_5_, p_147738_9_, d1, d2);
/* 1149 */     tessellator.func_78374_a(p_147738_1_, p_147738_7_, p_147738_11_, d1, d4);
/* 1150 */     tessellator.func_78374_a(p_147738_3_, p_147738_7_, p_147738_11_, d3, d4);
/*      */   }
/*      */   
/*      */   public void func_147750_a(Block p_147750_1_, int p_147750_2_, int p_147750_3_, int p_147750_4_, boolean p_147750_5_) {
/* 1154 */     this.field_147837_f = true;
/* 1155 */     func_147809_c(p_147750_1_, p_147750_2_, p_147750_3_, p_147750_4_, p_147750_5_);
/* 1156 */     this.field_147837_f = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_147809_c(Block p_147809_1_, int p_147809_2_, int p_147809_3_, int p_147809_4_, boolean p_147809_5_) {
/* 1161 */     int i = this.field_147845_a.func_72805_g(p_147809_2_, p_147809_3_, p_147809_4_);
/* 1162 */     int j = BlockPistonExtension.func_150085_b(i);
/*      */     
/* 1164 */     float f1 = 0.25F;
/* 1165 */     float f2 = 0.375F;
/* 1166 */     float f3 = 0.625F;
/* 1167 */     float f4 = p_147809_5_ ? 1.0F : 0.5F;
/* 1168 */     double d = p_147809_5_ ? 16.0D : 8.0D;
/*      */     
/* 1170 */     switch (j) {
/*      */       case 0:
/* 1172 */         this.field_147875_q = 3;
/* 1173 */         this.field_147873_r = 3;
/* 1174 */         this.field_147871_s = 3;
/* 1175 */         this.field_147869_t = 3;
/* 1176 */         func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D);
/* 1177 */         func_147784_q(p_147809_1_, p_147809_2_, p_147809_3_, p_147809_4_);
/*      */         
/* 1179 */         func_147763_a((p_147809_2_ + 0.375F), (p_147809_2_ + 0.625F), (p_147809_3_ + 0.25F), (p_147809_3_ + 0.25F + f4), (p_147809_4_ + 0.625F), (p_147809_4_ + 0.625F), 0.8F, d);
/* 1180 */         func_147763_a((p_147809_2_ + 0.625F), (p_147809_2_ + 0.375F), (p_147809_3_ + 0.25F), (p_147809_3_ + 0.25F + f4), (p_147809_4_ + 0.375F), (p_147809_4_ + 0.375F), 0.8F, d);
/* 1181 */         func_147763_a((p_147809_2_ + 0.375F), (p_147809_2_ + 0.375F), (p_147809_3_ + 0.25F), (p_147809_3_ + 0.25F + f4), (p_147809_4_ + 0.375F), (p_147809_4_ + 0.625F), 0.6F, d);
/* 1182 */         func_147763_a((p_147809_2_ + 0.625F), (p_147809_2_ + 0.625F), (p_147809_3_ + 0.25F), (p_147809_3_ + 0.25F + f4), (p_147809_4_ + 0.625F), (p_147809_4_ + 0.375F), 0.6F, d);
/*      */         break;
/*      */       
/*      */       case 1:
/* 1186 */         func_147782_a(0.0D, 0.75D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 1187 */         func_147784_q(p_147809_1_, p_147809_2_, p_147809_3_, p_147809_4_);
/*      */         
/* 1189 */         func_147763_a((p_147809_2_ + 0.375F), (p_147809_2_ + 0.625F), (p_147809_3_ - 0.25F + 1.0F - f4), (p_147809_3_ - 0.25F + 1.0F), (p_147809_4_ + 0.625F), (p_147809_4_ + 0.625F), 0.8F, d);
/* 1190 */         func_147763_a((p_147809_2_ + 0.625F), (p_147809_2_ + 0.375F), (p_147809_3_ - 0.25F + 1.0F - f4), (p_147809_3_ - 0.25F + 1.0F), (p_147809_4_ + 0.375F), (p_147809_4_ + 0.375F), 0.8F, d);
/* 1191 */         func_147763_a((p_147809_2_ + 0.375F), (p_147809_2_ + 0.375F), (p_147809_3_ - 0.25F + 1.0F - f4), (p_147809_3_ - 0.25F + 1.0F), (p_147809_4_ + 0.375F), (p_147809_4_ + 0.625F), 0.6F, d);
/* 1192 */         func_147763_a((p_147809_2_ + 0.625F), (p_147809_2_ + 0.625F), (p_147809_3_ - 0.25F + 1.0F - f4), (p_147809_3_ - 0.25F + 1.0F), (p_147809_4_ + 0.625F), (p_147809_4_ + 0.375F), 0.6F, d);
/*      */         break;
/*      */       case 2:
/* 1195 */         this.field_147871_s = 1;
/* 1196 */         this.field_147869_t = 2;
/* 1197 */         func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.25D);
/* 1198 */         func_147784_q(p_147809_1_, p_147809_2_, p_147809_3_, p_147809_4_);
/*      */         
/* 1200 */         func_147789_b((p_147809_2_ + 0.375F), (p_147809_2_ + 0.375F), (p_147809_3_ + 0.625F), (p_147809_3_ + 0.375F), (p_147809_4_ + 0.25F), (p_147809_4_ + 0.25F + f4), 0.6F, d);
/* 1201 */         func_147789_b((p_147809_2_ + 0.625F), (p_147809_2_ + 0.625F), (p_147809_3_ + 0.375F), (p_147809_3_ + 0.625F), (p_147809_4_ + 0.25F), (p_147809_4_ + 0.25F + f4), 0.6F, d);
/* 1202 */         func_147789_b((p_147809_2_ + 0.375F), (p_147809_2_ + 0.625F), (p_147809_3_ + 0.375F), (p_147809_3_ + 0.375F), (p_147809_4_ + 0.25F), (p_147809_4_ + 0.25F + f4), 0.5F, d);
/* 1203 */         func_147789_b((p_147809_2_ + 0.625F), (p_147809_2_ + 0.375F), (p_147809_3_ + 0.625F), (p_147809_3_ + 0.625F), (p_147809_4_ + 0.25F), (p_147809_4_ + 0.25F + f4), 1.0F, d);
/*      */         break;
/*      */       case 3:
/* 1206 */         this.field_147871_s = 2;
/* 1207 */         this.field_147869_t = 1;
/* 1208 */         this.field_147867_u = 3;
/* 1209 */         this.field_147865_v = 3;
/* 1210 */         func_147782_a(0.0D, 0.0D, 0.75D, 1.0D, 1.0D, 1.0D);
/* 1211 */         func_147784_q(p_147809_1_, p_147809_2_, p_147809_3_, p_147809_4_);
/*      */         
/* 1213 */         func_147789_b((p_147809_2_ + 0.375F), (p_147809_2_ + 0.375F), (p_147809_3_ + 0.625F), (p_147809_3_ + 0.375F), (p_147809_4_ - 0.25F + 1.0F - f4), (p_147809_4_ - 0.25F + 1.0F), 0.6F, d);
/* 1214 */         func_147789_b((p_147809_2_ + 0.625F), (p_147809_2_ + 0.625F), (p_147809_3_ + 0.375F), (p_147809_3_ + 0.625F), (p_147809_4_ - 0.25F + 1.0F - f4), (p_147809_4_ - 0.25F + 1.0F), 0.6F, d);
/* 1215 */         func_147789_b((p_147809_2_ + 0.375F), (p_147809_2_ + 0.625F), (p_147809_3_ + 0.375F), (p_147809_3_ + 0.375F), (p_147809_4_ - 0.25F + 1.0F - f4), (p_147809_4_ - 0.25F + 1.0F), 0.5F, d);
/* 1216 */         func_147789_b((p_147809_2_ + 0.625F), (p_147809_2_ + 0.375F), (p_147809_3_ + 0.625F), (p_147809_3_ + 0.625F), (p_147809_4_ - 0.25F + 1.0F - f4), (p_147809_4_ - 0.25F + 1.0F), 1.0F, d);
/*      */         break;
/*      */       case 4:
/* 1219 */         this.field_147875_q = 1;
/* 1220 */         this.field_147873_r = 2;
/* 1221 */         this.field_147867_u = 2;
/* 1222 */         this.field_147865_v = 1;
/* 1223 */         func_147782_a(0.0D, 0.0D, 0.0D, 0.25D, 1.0D, 1.0D);
/* 1224 */         func_147784_q(p_147809_1_, p_147809_2_, p_147809_3_, p_147809_4_);
/*      */         
/* 1226 */         func_147738_c((p_147809_2_ + 0.25F), (p_147809_2_ + 0.25F + f4), (p_147809_3_ + 0.375F), (p_147809_3_ + 0.375F), (p_147809_4_ + 0.625F), (p_147809_4_ + 0.375F), 0.5F, d);
/* 1227 */         func_147738_c((p_147809_2_ + 0.25F), (p_147809_2_ + 0.25F + f4), (p_147809_3_ + 0.625F), (p_147809_3_ + 0.625F), (p_147809_4_ + 0.375F), (p_147809_4_ + 0.625F), 1.0F, d);
/* 1228 */         func_147738_c((p_147809_2_ + 0.25F), (p_147809_2_ + 0.25F + f4), (p_147809_3_ + 0.375F), (p_147809_3_ + 0.625F), (p_147809_4_ + 0.375F), (p_147809_4_ + 0.375F), 0.6F, d);
/* 1229 */         func_147738_c((p_147809_2_ + 0.25F), (p_147809_2_ + 0.25F + f4), (p_147809_3_ + 0.625F), (p_147809_3_ + 0.375F), (p_147809_4_ + 0.625F), (p_147809_4_ + 0.625F), 0.6F, d);
/*      */         break;
/*      */       case 5:
/* 1232 */         this.field_147875_q = 2;
/* 1233 */         this.field_147873_r = 1;
/* 1234 */         this.field_147867_u = 1;
/* 1235 */         this.field_147865_v = 2;
/* 1236 */         func_147782_a(0.75D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 1237 */         func_147784_q(p_147809_1_, p_147809_2_, p_147809_3_, p_147809_4_);
/*      */         
/* 1239 */         func_147738_c((p_147809_2_ - 0.25F + 1.0F - f4), (p_147809_2_ - 0.25F + 1.0F), (p_147809_3_ + 0.375F), (p_147809_3_ + 0.375F), (p_147809_4_ + 0.625F), (p_147809_4_ + 0.375F), 0.5F, d);
/* 1240 */         func_147738_c((p_147809_2_ - 0.25F + 1.0F - f4), (p_147809_2_ - 0.25F + 1.0F), (p_147809_3_ + 0.625F), (p_147809_3_ + 0.625F), (p_147809_4_ + 0.375F), (p_147809_4_ + 0.625F), 1.0F, d);
/* 1241 */         func_147738_c((p_147809_2_ - 0.25F + 1.0F - f4), (p_147809_2_ - 0.25F + 1.0F), (p_147809_3_ + 0.375F), (p_147809_3_ + 0.625F), (p_147809_4_ + 0.375F), (p_147809_4_ + 0.375F), 0.6F, d);
/* 1242 */         func_147738_c((p_147809_2_ - 0.25F + 1.0F - f4), (p_147809_2_ - 0.25F + 1.0F), (p_147809_3_ + 0.625F), (p_147809_3_ + 0.375F), (p_147809_4_ + 0.625F), (p_147809_4_ + 0.625F), 0.6F, d);
/*      */         break;
/*      */     } 
/* 1245 */     this.field_147875_q = 0;
/* 1246 */     this.field_147873_r = 0;
/* 1247 */     this.field_147871_s = 0;
/* 1248 */     this.field_147869_t = 0;
/* 1249 */     this.field_147867_u = 0;
/* 1250 */     this.field_147865_v = 0;
/* 1251 */     func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/*      */     
/* 1253 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147790_e(Block p_147790_1_, int p_147790_2_, int p_147790_3_, int p_147790_4_) {
/* 1257 */     int i = this.field_147845_a.func_72805_g(p_147790_2_, p_147790_3_, p_147790_4_);
/*      */     
/* 1259 */     int j = i & 0x7;
/* 1260 */     boolean bool = ((i & 0x8) > 0) ? true : false;
/*      */     
/* 1262 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 1264 */     boolean bool1 = func_147744_b();
/* 1265 */     if (!bool1) func_147757_a(func_147745_b(Blocks.field_150347_e)); 
/* 1266 */     float f1 = 0.25F;
/* 1267 */     float f2 = 0.1875F;
/* 1268 */     float f3 = 0.1875F;
/* 1269 */     if (j == 5) {
/* 1270 */       func_147782_a((0.5F - f2), 0.0D, (0.5F - f1), (0.5F + f2), f3, (0.5F + f1));
/* 1271 */     } else if (j == 6) {
/* 1272 */       func_147782_a((0.5F - f1), 0.0D, (0.5F - f2), (0.5F + f1), f3, (0.5F + f2));
/* 1273 */     } else if (j == 4) {
/* 1274 */       func_147782_a((0.5F - f2), (0.5F - f1), (1.0F - f3), (0.5F + f2), (0.5F + f1), 1.0D);
/* 1275 */     } else if (j == 3) {
/* 1276 */       func_147782_a((0.5F - f2), (0.5F - f1), 0.0D, (0.5F + f2), (0.5F + f1), f3);
/* 1277 */     } else if (j == 2) {
/* 1278 */       func_147782_a((1.0F - f3), (0.5F - f1), (0.5F - f2), 1.0D, (0.5F + f1), (0.5F + f2));
/* 1279 */     } else if (j == 1) {
/* 1280 */       func_147782_a(0.0D, (0.5F - f1), (0.5F - f2), f3, (0.5F + f1), (0.5F + f2));
/* 1281 */     } else if (j == 0) {
/* 1282 */       func_147782_a((0.5F - f1), (1.0F - f3), (0.5F - f2), (0.5F + f1), 1.0D, (0.5F + f2));
/* 1283 */     } else if (j == 7) {
/* 1284 */       func_147782_a((0.5F - f2), (1.0F - f3), (0.5F - f1), (0.5F + f2), 1.0D, (0.5F + f1));
/*      */     } 
/* 1286 */     func_147784_q(p_147790_1_, p_147790_2_, p_147790_3_, p_147790_4_);
/* 1287 */     if (!bool1) func_147771_a();
/*      */     
/* 1289 */     tessellator.func_78380_c(p_147790_1_.func_149677_c(this.field_147845_a, p_147790_2_, p_147790_3_, p_147790_4_));
/* 1290 */     tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/* 1291 */     IIcon iIcon = func_147777_a(p_147790_1_, 0);
/*      */     
/* 1293 */     if (func_147744_b()) iIcon = this.field_147840_d; 
/* 1294 */     double d1 = iIcon.func_94209_e();
/* 1295 */     double d2 = iIcon.func_94206_g();
/* 1296 */     double d3 = iIcon.func_94212_f();
/* 1297 */     double d4 = iIcon.func_94210_h();
/*      */     
/* 1299 */     Vec3[] arrayOfVec3 = new Vec3[8];
/* 1300 */     float f4 = 0.0625F;
/* 1301 */     float f5 = 0.0625F;
/* 1302 */     float f6 = 0.625F;
/* 1303 */     arrayOfVec3[0] = Vec3.func_72443_a(-f4, 0.0D, -f5);
/* 1304 */     arrayOfVec3[1] = Vec3.func_72443_a(f4, 0.0D, -f5);
/* 1305 */     arrayOfVec3[2] = Vec3.func_72443_a(f4, 0.0D, f5);
/* 1306 */     arrayOfVec3[3] = Vec3.func_72443_a(-f4, 0.0D, f5);
/* 1307 */     arrayOfVec3[4] = Vec3.func_72443_a(-f4, f6, -f5);
/* 1308 */     arrayOfVec3[5] = Vec3.func_72443_a(f4, f6, -f5);
/* 1309 */     arrayOfVec3[6] = Vec3.func_72443_a(f4, f6, f5);
/* 1310 */     arrayOfVec3[7] = Vec3.func_72443_a(-f4, f6, f5);
/*      */     
/* 1312 */     for (byte b1 = 0; b1 < 8; b1++) {
/* 1313 */       if (bool) {
/* 1314 */         (arrayOfVec3[b1]).field_72449_c -= 0.0625D;
/* 1315 */         arrayOfVec3[b1].func_72440_a(0.69813174F);
/*      */       } else {
/* 1317 */         (arrayOfVec3[b1]).field_72449_c += 0.0625D;
/* 1318 */         arrayOfVec3[b1].func_72440_a(-0.69813174F);
/*      */       } 
/* 1320 */       if (j == 0 || j == 7) {
/* 1321 */         arrayOfVec3[b1].func_72446_c(3.1415927F);
/*      */       }
/* 1323 */       if (j == 6 || j == 0) {
/* 1324 */         arrayOfVec3[b1].func_72442_b(1.5707964F);
/*      */       }
/*      */       
/* 1327 */       if (j > 0 && j < 5) {
/* 1328 */         (arrayOfVec3[b1]).field_72448_b -= 0.375D;
/* 1329 */         arrayOfVec3[b1].func_72440_a(1.5707964F);
/*      */         
/* 1331 */         if (j == 4) arrayOfVec3[b1].func_72442_b(0.0F); 
/* 1332 */         if (j == 3) arrayOfVec3[b1].func_72442_b(3.1415927F); 
/* 1333 */         if (j == 2) arrayOfVec3[b1].func_72442_b(1.5707964F); 
/* 1334 */         if (j == 1) arrayOfVec3[b1].func_72442_b(-1.5707964F);
/*      */         
/* 1336 */         (arrayOfVec3[b1]).field_72450_a += p_147790_2_ + 0.5D;
/* 1337 */         (arrayOfVec3[b1]).field_72448_b += (p_147790_3_ + 0.5F);
/* 1338 */         (arrayOfVec3[b1]).field_72449_c += p_147790_4_ + 0.5D;
/* 1339 */       } else if (j == 0 || j == 7) {
/* 1340 */         (arrayOfVec3[b1]).field_72450_a += p_147790_2_ + 0.5D;
/* 1341 */         (arrayOfVec3[b1]).field_72448_b += (p_147790_3_ + 0.875F);
/* 1342 */         (arrayOfVec3[b1]).field_72449_c += p_147790_4_ + 0.5D;
/*      */       } else {
/* 1344 */         (arrayOfVec3[b1]).field_72450_a += p_147790_2_ + 0.5D;
/* 1345 */         (arrayOfVec3[b1]).field_72448_b += (p_147790_3_ + 0.125F);
/* 1346 */         (arrayOfVec3[b1]).field_72449_c += p_147790_4_ + 0.5D;
/*      */       } 
/*      */     } 
/*      */     
/* 1350 */     Vec3 vec31 = null, vec32 = null, vec33 = null, vec34 = null;
/* 1351 */     for (byte b2 = 0; b2 < 6; b2++) {
/* 1352 */       if (b2 == 0) {
/* 1353 */         d1 = iIcon.func_94214_a(7.0D);
/* 1354 */         d2 = iIcon.func_94207_b(6.0D);
/* 1355 */         d3 = iIcon.func_94214_a(9.0D);
/* 1356 */         d4 = iIcon.func_94207_b(8.0D);
/* 1357 */       } else if (b2 == 2) {
/* 1358 */         d1 = iIcon.func_94214_a(7.0D);
/* 1359 */         d2 = iIcon.func_94207_b(6.0D);
/* 1360 */         d3 = iIcon.func_94214_a(9.0D);
/* 1361 */         d4 = iIcon.func_94210_h();
/*      */       } 
/* 1363 */       if (b2 == 0) {
/* 1364 */         vec31 = arrayOfVec3[0];
/* 1365 */         vec32 = arrayOfVec3[1];
/* 1366 */         vec33 = arrayOfVec3[2];
/* 1367 */         vec34 = arrayOfVec3[3];
/* 1368 */       } else if (b2 == 1) {
/* 1369 */         vec31 = arrayOfVec3[7];
/* 1370 */         vec32 = arrayOfVec3[6];
/* 1371 */         vec33 = arrayOfVec3[5];
/* 1372 */         vec34 = arrayOfVec3[4];
/* 1373 */       } else if (b2 == 2) {
/* 1374 */         vec31 = arrayOfVec3[1];
/* 1375 */         vec32 = arrayOfVec3[0];
/* 1376 */         vec33 = arrayOfVec3[4];
/* 1377 */         vec34 = arrayOfVec3[5];
/* 1378 */       } else if (b2 == 3) {
/* 1379 */         vec31 = arrayOfVec3[2];
/* 1380 */         vec32 = arrayOfVec3[1];
/* 1381 */         vec33 = arrayOfVec3[5];
/* 1382 */         vec34 = arrayOfVec3[6];
/* 1383 */       } else if (b2 == 4) {
/* 1384 */         vec31 = arrayOfVec3[3];
/* 1385 */         vec32 = arrayOfVec3[2];
/* 1386 */         vec33 = arrayOfVec3[6];
/* 1387 */         vec34 = arrayOfVec3[7];
/* 1388 */       } else if (b2 == 5) {
/* 1389 */         vec31 = arrayOfVec3[0];
/* 1390 */         vec32 = arrayOfVec3[3];
/* 1391 */         vec33 = arrayOfVec3[7];
/* 1392 */         vec34 = arrayOfVec3[4];
/*      */       } 
/* 1394 */       tessellator.func_78374_a(vec31.field_72450_a, vec31.field_72448_b, vec31.field_72449_c, d1, d4);
/* 1395 */       tessellator.func_78374_a(vec32.field_72450_a, vec32.field_72448_b, vec32.field_72449_c, d3, d4);
/* 1396 */       tessellator.func_78374_a(vec33.field_72450_a, vec33.field_72448_b, vec33.field_72449_c, d3, d2);
/* 1397 */       tessellator.func_78374_a(vec34.field_72450_a, vec34.field_72448_b, vec34.field_72449_c, d1, d2);
/*      */     } 
/* 1399 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147723_f(Block p_147723_1_, int p_147723_2_, int p_147723_3_, int p_147723_4_) {
/* 1403 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 1404 */     int i = this.field_147845_a.func_72805_g(p_147723_2_, p_147723_3_, p_147723_4_);
/* 1405 */     int j = i & 0x3;
/* 1406 */     boolean bool1 = ((i & 0x4) == 4) ? true : false;
/* 1407 */     boolean bool2 = ((i & 0x8) == 8) ? true : false;
/* 1408 */     boolean bool3 = !World.func_147466_a(this.field_147845_a, p_147723_2_, p_147723_3_ - 1, p_147723_4_) ? true : false;
/*      */     
/* 1410 */     boolean bool = func_147744_b();
/* 1411 */     if (!bool) func_147757_a(func_147745_b(Blocks.field_150344_f));
/*      */     
/* 1413 */     float f1 = 0.25F;
/* 1414 */     float f2 = 0.125F;
/* 1415 */     float f3 = 0.125F;
/*      */     
/* 1417 */     float f4 = 0.3F - f1;
/* 1418 */     float f5 = 0.3F + f1;
/* 1419 */     if (j == 2) {
/* 1420 */       func_147782_a((0.5F - f2), f4, (1.0F - f3), (0.5F + f2), f5, 1.0D);
/* 1421 */     } else if (j == 0) {
/* 1422 */       func_147782_a((0.5F - f2), f4, 0.0D, (0.5F + f2), f5, f3);
/* 1423 */     } else if (j == 1) {
/* 1424 */       func_147782_a((1.0F - f3), f4, (0.5F - f2), 1.0D, f5, (0.5F + f2));
/* 1425 */     } else if (j == 3) {
/* 1426 */       func_147782_a(0.0D, f4, (0.5F - f2), f3, f5, (0.5F + f2));
/*      */     } 
/*      */     
/* 1429 */     func_147784_q(p_147723_1_, p_147723_2_, p_147723_3_, p_147723_4_);
/* 1430 */     if (!bool) func_147771_a();
/*      */     
/* 1432 */     tessellator.func_78380_c(p_147723_1_.func_149677_c(this.field_147845_a, p_147723_2_, p_147723_3_, p_147723_4_));
/* 1433 */     tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/* 1434 */     IIcon iIcon = func_147777_a(p_147723_1_, 0);
/*      */     
/* 1436 */     if (func_147744_b()) iIcon = this.field_147840_d; 
/* 1437 */     double d1 = iIcon.func_94209_e();
/* 1438 */     double d2 = iIcon.func_94206_g();
/* 1439 */     double d3 = iIcon.func_94212_f();
/* 1440 */     double d4 = iIcon.func_94210_h();
/*      */     
/* 1442 */     Vec3[] arrayOfVec3 = new Vec3[8];
/* 1443 */     float f6 = 0.046875F;
/* 1444 */     float f7 = 0.046875F;
/* 1445 */     float f8 = 0.3125F;
/* 1446 */     arrayOfVec3[0] = Vec3.func_72443_a(-f6, 0.0D, -f7);
/* 1447 */     arrayOfVec3[1] = Vec3.func_72443_a(f6, 0.0D, -f7);
/* 1448 */     arrayOfVec3[2] = Vec3.func_72443_a(f6, 0.0D, f7);
/* 1449 */     arrayOfVec3[3] = Vec3.func_72443_a(-f6, 0.0D, f7);
/* 1450 */     arrayOfVec3[4] = Vec3.func_72443_a(-f6, f8, -f7);
/* 1451 */     arrayOfVec3[5] = Vec3.func_72443_a(f6, f8, -f7);
/* 1452 */     arrayOfVec3[6] = Vec3.func_72443_a(f6, f8, f7);
/* 1453 */     arrayOfVec3[7] = Vec3.func_72443_a(-f6, f8, f7);
/*      */     
/* 1455 */     for (byte b1 = 0; b1 < 8; b1++) {
/* 1456 */       (arrayOfVec3[b1]).field_72449_c += 0.0625D;
/*      */       
/* 1458 */       if (bool2) {
/* 1459 */         arrayOfVec3[b1].func_72440_a(0.5235988F);
/* 1460 */         (arrayOfVec3[b1]).field_72448_b -= 0.4375D;
/* 1461 */       } else if (bool1) {
/* 1462 */         arrayOfVec3[b1].func_72440_a(0.08726647F);
/* 1463 */         (arrayOfVec3[b1]).field_72448_b -= 0.4375D;
/*      */       } else {
/* 1465 */         arrayOfVec3[b1].func_72440_a(-0.69813174F);
/* 1466 */         (arrayOfVec3[b1]).field_72448_b -= 0.375D;
/*      */       } 
/*      */       
/* 1469 */       arrayOfVec3[b1].func_72440_a(1.5707964F);
/*      */       
/* 1471 */       if (j == 2) arrayOfVec3[b1].func_72442_b(0.0F); 
/* 1472 */       if (j == 0) arrayOfVec3[b1].func_72442_b(3.1415927F); 
/* 1473 */       if (j == 1) arrayOfVec3[b1].func_72442_b(1.5707964F); 
/* 1474 */       if (j == 3) arrayOfVec3[b1].func_72442_b(-1.5707964F);
/*      */       
/* 1476 */       (arrayOfVec3[b1]).field_72450_a += p_147723_2_ + 0.5D;
/* 1477 */       (arrayOfVec3[b1]).field_72448_b += (p_147723_3_ + 0.3125F);
/* 1478 */       (arrayOfVec3[b1]).field_72449_c += p_147723_4_ + 0.5D;
/*      */     } 
/*      */     
/* 1481 */     Vec3 vec31 = null, vec32 = null, vec33 = null, vec34 = null;
/* 1482 */     byte b2 = 7;
/* 1483 */     byte b3 = 9;
/* 1484 */     byte b4 = 9;
/* 1485 */     byte b5 = 16;
/*      */     
/* 1487 */     for (byte b6 = 0; b6 < 6; b6++) {
/* 1488 */       if (b6 == 0) {
/* 1489 */         vec31 = arrayOfVec3[0];
/* 1490 */         vec32 = arrayOfVec3[1];
/* 1491 */         vec33 = arrayOfVec3[2];
/* 1492 */         vec34 = arrayOfVec3[3];
/* 1493 */         d1 = iIcon.func_94214_a(b2);
/* 1494 */         d2 = iIcon.func_94207_b(b4);
/* 1495 */         d3 = iIcon.func_94214_a(b3);
/* 1496 */         d4 = iIcon.func_94207_b((b4 + 2));
/* 1497 */       } else if (b6 == 1) {
/* 1498 */         vec31 = arrayOfVec3[7];
/* 1499 */         vec32 = arrayOfVec3[6];
/* 1500 */         vec33 = arrayOfVec3[5];
/* 1501 */         vec34 = arrayOfVec3[4];
/* 1502 */       } else if (b6 == 2) {
/* 1503 */         vec31 = arrayOfVec3[1];
/* 1504 */         vec32 = arrayOfVec3[0];
/* 1505 */         vec33 = arrayOfVec3[4];
/* 1506 */         vec34 = arrayOfVec3[5];
/* 1507 */         d1 = iIcon.func_94214_a(b2);
/* 1508 */         d2 = iIcon.func_94207_b(b4);
/* 1509 */         d3 = iIcon.func_94214_a(b3);
/* 1510 */         d4 = iIcon.func_94207_b(b5);
/* 1511 */       } else if (b6 == 3) {
/* 1512 */         vec31 = arrayOfVec3[2];
/* 1513 */         vec32 = arrayOfVec3[1];
/* 1514 */         vec33 = arrayOfVec3[5];
/* 1515 */         vec34 = arrayOfVec3[6];
/* 1516 */       } else if (b6 == 4) {
/* 1517 */         vec31 = arrayOfVec3[3];
/* 1518 */         vec32 = arrayOfVec3[2];
/* 1519 */         vec33 = arrayOfVec3[6];
/* 1520 */         vec34 = arrayOfVec3[7];
/* 1521 */       } else if (b6 == 5) {
/* 1522 */         vec31 = arrayOfVec3[0];
/* 1523 */         vec32 = arrayOfVec3[3];
/* 1524 */         vec33 = arrayOfVec3[7];
/* 1525 */         vec34 = arrayOfVec3[4];
/*      */       } 
/* 1527 */       tessellator.func_78374_a(vec31.field_72450_a, vec31.field_72448_b, vec31.field_72449_c, d1, d4);
/* 1528 */       tessellator.func_78374_a(vec32.field_72450_a, vec32.field_72448_b, vec32.field_72449_c, d3, d4);
/* 1529 */       tessellator.func_78374_a(vec33.field_72450_a, vec33.field_72448_b, vec33.field_72449_c, d3, d2);
/* 1530 */       tessellator.func_78374_a(vec34.field_72450_a, vec34.field_72448_b, vec34.field_72449_c, d1, d2);
/*      */     } 
/*      */ 
/*      */     
/* 1534 */     float f9 = 0.09375F;
/* 1535 */     float f10 = 0.09375F;
/* 1536 */     float f11 = 0.03125F;
/* 1537 */     arrayOfVec3[0] = Vec3.func_72443_a(-f9, 0.0D, -f10);
/* 1538 */     arrayOfVec3[1] = Vec3.func_72443_a(f9, 0.0D, -f10);
/* 1539 */     arrayOfVec3[2] = Vec3.func_72443_a(f9, 0.0D, f10);
/* 1540 */     arrayOfVec3[3] = Vec3.func_72443_a(-f9, 0.0D, f10);
/* 1541 */     arrayOfVec3[4] = Vec3.func_72443_a(-f9, f11, -f10);
/* 1542 */     arrayOfVec3[5] = Vec3.func_72443_a(f9, f11, -f10);
/* 1543 */     arrayOfVec3[6] = Vec3.func_72443_a(f9, f11, f10);
/* 1544 */     arrayOfVec3[7] = Vec3.func_72443_a(-f9, f11, f10);
/*      */     byte b7;
/* 1546 */     for (b7 = 0; b7 < 8; b7++) {
/* 1547 */       (arrayOfVec3[b7]).field_72449_c += 0.21875D;
/*      */       
/* 1549 */       if (bool2) {
/* 1550 */         (arrayOfVec3[b7]).field_72448_b -= 0.09375D;
/* 1551 */         (arrayOfVec3[b7]).field_72449_c -= 0.1625D;
/* 1552 */         arrayOfVec3[b7].func_72440_a(0.0F);
/* 1553 */       } else if (bool1) {
/* 1554 */         (arrayOfVec3[b7]).field_72448_b += 0.015625D;
/* 1555 */         (arrayOfVec3[b7]).field_72449_c -= 0.171875D;
/* 1556 */         arrayOfVec3[b7].func_72440_a(0.17453294F);
/*      */       } else {
/* 1558 */         arrayOfVec3[b7].func_72440_a(0.87266463F);
/*      */       } 
/*      */       
/* 1561 */       if (j == 2) arrayOfVec3[b7].func_72442_b(0.0F); 
/* 1562 */       if (j == 0) arrayOfVec3[b7].func_72442_b(3.1415927F); 
/* 1563 */       if (j == 1) arrayOfVec3[b7].func_72442_b(1.5707964F); 
/* 1564 */       if (j == 3) arrayOfVec3[b7].func_72442_b(-1.5707964F);
/*      */       
/* 1566 */       (arrayOfVec3[b7]).field_72450_a += p_147723_2_ + 0.5D;
/* 1567 */       (arrayOfVec3[b7]).field_72448_b += (p_147723_3_ + 0.3125F);
/* 1568 */       (arrayOfVec3[b7]).field_72449_c += p_147723_4_ + 0.5D;
/*      */     } 
/*      */     
/* 1571 */     b7 = 5;
/* 1572 */     byte b8 = 11;
/* 1573 */     byte b9 = 3;
/* 1574 */     byte b10 = 9;
/*      */     
/* 1576 */     for (byte b11 = 0; b11 < 6; b11++) {
/* 1577 */       if (b11 == 0) {
/* 1578 */         vec31 = arrayOfVec3[0];
/* 1579 */         vec32 = arrayOfVec3[1];
/* 1580 */         vec33 = arrayOfVec3[2];
/* 1581 */         vec34 = arrayOfVec3[3];
/* 1582 */         d1 = iIcon.func_94214_a(b7);
/* 1583 */         d2 = iIcon.func_94207_b(b9);
/* 1584 */         d3 = iIcon.func_94214_a(b8);
/* 1585 */         d4 = iIcon.func_94207_b(b10);
/* 1586 */       } else if (b11 == 1) {
/* 1587 */         vec31 = arrayOfVec3[7];
/* 1588 */         vec32 = arrayOfVec3[6];
/* 1589 */         vec33 = arrayOfVec3[5];
/* 1590 */         vec34 = arrayOfVec3[4];
/* 1591 */       } else if (b11 == 2) {
/* 1592 */         vec31 = arrayOfVec3[1];
/* 1593 */         vec32 = arrayOfVec3[0];
/* 1594 */         vec33 = arrayOfVec3[4];
/* 1595 */         vec34 = arrayOfVec3[5];
/* 1596 */         d1 = iIcon.func_94214_a(b7);
/* 1597 */         d2 = iIcon.func_94207_b(b9);
/* 1598 */         d3 = iIcon.func_94214_a(b8);
/* 1599 */         d4 = iIcon.func_94207_b((b9 + 2));
/* 1600 */       } else if (b11 == 3) {
/* 1601 */         vec31 = arrayOfVec3[2];
/* 1602 */         vec32 = arrayOfVec3[1];
/* 1603 */         vec33 = arrayOfVec3[5];
/* 1604 */         vec34 = arrayOfVec3[6];
/* 1605 */       } else if (b11 == 4) {
/* 1606 */         vec31 = arrayOfVec3[3];
/* 1607 */         vec32 = arrayOfVec3[2];
/* 1608 */         vec33 = arrayOfVec3[6];
/* 1609 */         vec34 = arrayOfVec3[7];
/* 1610 */       } else if (b11 == 5) {
/* 1611 */         vec31 = arrayOfVec3[0];
/* 1612 */         vec32 = arrayOfVec3[3];
/* 1613 */         vec33 = arrayOfVec3[7];
/* 1614 */         vec34 = arrayOfVec3[4];
/*      */       } 
/* 1616 */       tessellator.func_78374_a(vec31.field_72450_a, vec31.field_72448_b, vec31.field_72449_c, d1, d4);
/* 1617 */       tessellator.func_78374_a(vec32.field_72450_a, vec32.field_72448_b, vec32.field_72449_c, d3, d4);
/* 1618 */       tessellator.func_78374_a(vec33.field_72450_a, vec33.field_72448_b, vec33.field_72449_c, d3, d2);
/* 1619 */       tessellator.func_78374_a(vec34.field_72450_a, vec34.field_72448_b, vec34.field_72449_c, d1, d2);
/*      */     } 
/*      */     
/* 1622 */     if (bool1) {
/* 1623 */       double d5 = (arrayOfVec3[0]).field_72448_b;
/* 1624 */       float f12 = 0.03125F;
/* 1625 */       float f13 = 0.5F - f12 / 2.0F;
/* 1626 */       float f14 = f13 + f12;
/* 1627 */       double d6 = iIcon.func_94209_e();
/* 1628 */       double d7 = iIcon.func_94207_b(bool1 ? 2.0D : 0.0D);
/* 1629 */       double d8 = iIcon.func_94212_f();
/* 1630 */       double d9 = iIcon.func_94207_b(bool1 ? 4.0D : 2.0D);
/* 1631 */       double d10 = (bool3 ? 3.5F : 1.5F) / 16.0D;
/*      */       
/* 1633 */       tessellator.func_78386_a(0.75F, 0.75F, 0.75F);
/*      */       
/* 1635 */       if (j == 2) {
/* 1636 */         tessellator.func_78374_a((p_147723_2_ + f13), p_147723_3_ + d10, p_147723_4_ + 0.25D, d6, d7);
/* 1637 */         tessellator.func_78374_a((p_147723_2_ + f14), p_147723_3_ + d10, p_147723_4_ + 0.25D, d6, d9);
/* 1638 */         tessellator.func_78374_a((p_147723_2_ + f14), p_147723_3_ + d10, p_147723_4_, d8, d9);
/* 1639 */         tessellator.func_78374_a((p_147723_2_ + f13), p_147723_3_ + d10, p_147723_4_, d8, d7);
/*      */         
/* 1641 */         tessellator.func_78374_a((p_147723_2_ + f13), d5, p_147723_4_ + 0.5D, d6, d7);
/* 1642 */         tessellator.func_78374_a((p_147723_2_ + f14), d5, p_147723_4_ + 0.5D, d6, d9);
/* 1643 */         tessellator.func_78374_a((p_147723_2_ + f14), p_147723_3_ + d10, p_147723_4_ + 0.25D, d8, d9);
/* 1644 */         tessellator.func_78374_a((p_147723_2_ + f13), p_147723_3_ + d10, p_147723_4_ + 0.25D, d8, d7);
/* 1645 */       } else if (j == 0) {
/* 1646 */         tessellator.func_78374_a((p_147723_2_ + f13), p_147723_3_ + d10, p_147723_4_ + 0.75D, d6, d7);
/* 1647 */         tessellator.func_78374_a((p_147723_2_ + f14), p_147723_3_ + d10, p_147723_4_ + 0.75D, d6, d9);
/* 1648 */         tessellator.func_78374_a((p_147723_2_ + f14), d5, p_147723_4_ + 0.5D, d8, d9);
/* 1649 */         tessellator.func_78374_a((p_147723_2_ + f13), d5, p_147723_4_ + 0.5D, d8, d7);
/*      */         
/* 1651 */         tessellator.func_78374_a((p_147723_2_ + f13), p_147723_3_ + d10, (p_147723_4_ + 1), d6, d7);
/* 1652 */         tessellator.func_78374_a((p_147723_2_ + f14), p_147723_3_ + d10, (p_147723_4_ + 1), d6, d9);
/* 1653 */         tessellator.func_78374_a((p_147723_2_ + f14), p_147723_3_ + d10, p_147723_4_ + 0.75D, d8, d9);
/* 1654 */         tessellator.func_78374_a((p_147723_2_ + f13), p_147723_3_ + d10, p_147723_4_ + 0.75D, d8, d7);
/* 1655 */       } else if (j == 1) {
/* 1656 */         tessellator.func_78374_a(p_147723_2_, p_147723_3_ + d10, (p_147723_4_ + f14), d6, d9);
/* 1657 */         tessellator.func_78374_a(p_147723_2_ + 0.25D, p_147723_3_ + d10, (p_147723_4_ + f14), d8, d9);
/* 1658 */         tessellator.func_78374_a(p_147723_2_ + 0.25D, p_147723_3_ + d10, (p_147723_4_ + f13), d8, d7);
/* 1659 */         tessellator.func_78374_a(p_147723_2_, p_147723_3_ + d10, (p_147723_4_ + f13), d6, d7);
/*      */         
/* 1661 */         tessellator.func_78374_a(p_147723_2_ + 0.25D, p_147723_3_ + d10, (p_147723_4_ + f14), d6, d9);
/* 1662 */         tessellator.func_78374_a(p_147723_2_ + 0.5D, d5, (p_147723_4_ + f14), d8, d9);
/* 1663 */         tessellator.func_78374_a(p_147723_2_ + 0.5D, d5, (p_147723_4_ + f13), d8, d7);
/* 1664 */         tessellator.func_78374_a(p_147723_2_ + 0.25D, p_147723_3_ + d10, (p_147723_4_ + f13), d6, d7);
/*      */       } else {
/* 1666 */         tessellator.func_78374_a(p_147723_2_ + 0.5D, d5, (p_147723_4_ + f14), d6, d9);
/* 1667 */         tessellator.func_78374_a(p_147723_2_ + 0.75D, p_147723_3_ + d10, (p_147723_4_ + f14), d8, d9);
/* 1668 */         tessellator.func_78374_a(p_147723_2_ + 0.75D, p_147723_3_ + d10, (p_147723_4_ + f13), d8, d7);
/* 1669 */         tessellator.func_78374_a(p_147723_2_ + 0.5D, d5, (p_147723_4_ + f13), d6, d7);
/*      */         
/* 1671 */         tessellator.func_78374_a(p_147723_2_ + 0.75D, p_147723_3_ + d10, (p_147723_4_ + f14), d6, d9);
/* 1672 */         tessellator.func_78374_a((p_147723_2_ + 1), p_147723_3_ + d10, (p_147723_4_ + f14), d8, d9);
/* 1673 */         tessellator.func_78374_a((p_147723_2_ + 1), p_147723_3_ + d10, (p_147723_4_ + f13), d8, d7);
/* 1674 */         tessellator.func_78374_a(p_147723_2_ + 0.75D, p_147723_3_ + d10, (p_147723_4_ + f13), d6, d7);
/*      */       } 
/*      */     } 
/*      */     
/* 1678 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147756_g(Block p_147756_1_, int p_147756_2_, int p_147756_3_, int p_147756_4_) {
/* 1682 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 1683 */     IIcon iIcon = func_147777_a(p_147756_1_, 0);
/* 1684 */     int i = this.field_147845_a.func_72805_g(p_147756_2_, p_147756_3_, p_147756_4_);
/* 1685 */     boolean bool1 = ((i & 0x4) == 4) ? true : false;
/* 1686 */     boolean bool2 = ((i & 0x2) == 2) ? true : false;
/*      */     
/* 1688 */     if (func_147744_b()) iIcon = this.field_147840_d;
/*      */     
/* 1690 */     tessellator.func_78380_c(p_147756_1_.func_149677_c(this.field_147845_a, p_147756_2_, p_147756_3_, p_147756_4_));
/* 1691 */     tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/*      */     
/* 1693 */     double d1 = iIcon.func_94209_e();
/* 1694 */     double d2 = iIcon.func_94207_b(bool1 ? 2.0D : 0.0D);
/* 1695 */     double d3 = iIcon.func_94212_f();
/* 1696 */     double d4 = iIcon.func_94207_b(bool1 ? 4.0D : 2.0D);
/* 1697 */     double d5 = (bool2 ? 3.5F : 1.5F) / 16.0D;
/*      */     
/* 1699 */     boolean bool3 = BlockTripWire.func_150139_a(this.field_147845_a, p_147756_2_, p_147756_3_, p_147756_4_, i, 1);
/* 1700 */     boolean bool4 = BlockTripWire.func_150139_a(this.field_147845_a, p_147756_2_, p_147756_3_, p_147756_4_, i, 3);
/* 1701 */     boolean bool5 = BlockTripWire.func_150139_a(this.field_147845_a, p_147756_2_, p_147756_3_, p_147756_4_, i, 2);
/* 1702 */     boolean bool6 = BlockTripWire.func_150139_a(this.field_147845_a, p_147756_2_, p_147756_3_, p_147756_4_, i, 0);
/*      */     
/* 1704 */     float f1 = 0.03125F;
/* 1705 */     float f2 = 0.5F - f1 / 2.0F;
/* 1706 */     float f3 = f2 + f1;
/*      */     
/* 1708 */     if (!bool5 && !bool4 && !bool6 && !bool3) {
/* 1709 */       bool5 = true;
/* 1710 */       bool6 = true;
/*      */     } 
/*      */     
/* 1713 */     if (bool5) {
/* 1714 */       tessellator.func_78374_a((p_147756_2_ + f2), p_147756_3_ + d5, p_147756_4_ + 0.25D, d1, d2);
/* 1715 */       tessellator.func_78374_a((p_147756_2_ + f3), p_147756_3_ + d5, p_147756_4_ + 0.25D, d1, d4);
/* 1716 */       tessellator.func_78374_a((p_147756_2_ + f3), p_147756_3_ + d5, p_147756_4_, d3, d4);
/* 1717 */       tessellator.func_78374_a((p_147756_2_ + f2), p_147756_3_ + d5, p_147756_4_, d3, d2);
/*      */       
/* 1719 */       tessellator.func_78374_a((p_147756_2_ + f2), p_147756_3_ + d5, p_147756_4_, d3, d2);
/* 1720 */       tessellator.func_78374_a((p_147756_2_ + f3), p_147756_3_ + d5, p_147756_4_, d3, d4);
/* 1721 */       tessellator.func_78374_a((p_147756_2_ + f3), p_147756_3_ + d5, p_147756_4_ + 0.25D, d1, d4);
/* 1722 */       tessellator.func_78374_a((p_147756_2_ + f2), p_147756_3_ + d5, p_147756_4_ + 0.25D, d1, d2);
/*      */     } 
/* 1724 */     if (bool5 || (bool6 && !bool4 && !bool3)) {
/* 1725 */       tessellator.func_78374_a((p_147756_2_ + f2), p_147756_3_ + d5, p_147756_4_ + 0.5D, d1, d2);
/* 1726 */       tessellator.func_78374_a((p_147756_2_ + f3), p_147756_3_ + d5, p_147756_4_ + 0.5D, d1, d4);
/* 1727 */       tessellator.func_78374_a((p_147756_2_ + f3), p_147756_3_ + d5, p_147756_4_ + 0.25D, d3, d4);
/* 1728 */       tessellator.func_78374_a((p_147756_2_ + f2), p_147756_3_ + d5, p_147756_4_ + 0.25D, d3, d2);
/*      */       
/* 1730 */       tessellator.func_78374_a((p_147756_2_ + f2), p_147756_3_ + d5, p_147756_4_ + 0.25D, d3, d2);
/* 1731 */       tessellator.func_78374_a((p_147756_2_ + f3), p_147756_3_ + d5, p_147756_4_ + 0.25D, d3, d4);
/* 1732 */       tessellator.func_78374_a((p_147756_2_ + f3), p_147756_3_ + d5, p_147756_4_ + 0.5D, d1, d4);
/* 1733 */       tessellator.func_78374_a((p_147756_2_ + f2), p_147756_3_ + d5, p_147756_4_ + 0.5D, d1, d2);
/*      */     } 
/* 1735 */     if (bool6 || (bool5 && !bool4 && !bool3)) {
/* 1736 */       tessellator.func_78374_a((p_147756_2_ + f2), p_147756_3_ + d5, p_147756_4_ + 0.75D, d1, d2);
/* 1737 */       tessellator.func_78374_a((p_147756_2_ + f3), p_147756_3_ + d5, p_147756_4_ + 0.75D, d1, d4);
/* 1738 */       tessellator.func_78374_a((p_147756_2_ + f3), p_147756_3_ + d5, p_147756_4_ + 0.5D, d3, d4);
/* 1739 */       tessellator.func_78374_a((p_147756_2_ + f2), p_147756_3_ + d5, p_147756_4_ + 0.5D, d3, d2);
/*      */       
/* 1741 */       tessellator.func_78374_a((p_147756_2_ + f2), p_147756_3_ + d5, p_147756_4_ + 0.5D, d3, d2);
/* 1742 */       tessellator.func_78374_a((p_147756_2_ + f3), p_147756_3_ + d5, p_147756_4_ + 0.5D, d3, d4);
/* 1743 */       tessellator.func_78374_a((p_147756_2_ + f3), p_147756_3_ + d5, p_147756_4_ + 0.75D, d1, d4);
/* 1744 */       tessellator.func_78374_a((p_147756_2_ + f2), p_147756_3_ + d5, p_147756_4_ + 0.75D, d1, d2);
/*      */     } 
/* 1746 */     if (bool6) {
/* 1747 */       tessellator.func_78374_a((p_147756_2_ + f2), p_147756_3_ + d5, (p_147756_4_ + 1), d1, d2);
/* 1748 */       tessellator.func_78374_a((p_147756_2_ + f3), p_147756_3_ + d5, (p_147756_4_ + 1), d1, d4);
/* 1749 */       tessellator.func_78374_a((p_147756_2_ + f3), p_147756_3_ + d5, p_147756_4_ + 0.75D, d3, d4);
/* 1750 */       tessellator.func_78374_a((p_147756_2_ + f2), p_147756_3_ + d5, p_147756_4_ + 0.75D, d3, d2);
/*      */       
/* 1752 */       tessellator.func_78374_a((p_147756_2_ + f2), p_147756_3_ + d5, p_147756_4_ + 0.75D, d3, d2);
/* 1753 */       tessellator.func_78374_a((p_147756_2_ + f3), p_147756_3_ + d5, p_147756_4_ + 0.75D, d3, d4);
/* 1754 */       tessellator.func_78374_a((p_147756_2_ + f3), p_147756_3_ + d5, (p_147756_4_ + 1), d1, d4);
/* 1755 */       tessellator.func_78374_a((p_147756_2_ + f2), p_147756_3_ + d5, (p_147756_4_ + 1), d1, d2);
/*      */     } 
/*      */     
/* 1758 */     if (bool3) {
/* 1759 */       tessellator.func_78374_a(p_147756_2_, p_147756_3_ + d5, (p_147756_4_ + f3), d1, d4);
/* 1760 */       tessellator.func_78374_a(p_147756_2_ + 0.25D, p_147756_3_ + d5, (p_147756_4_ + f3), d3, d4);
/* 1761 */       tessellator.func_78374_a(p_147756_2_ + 0.25D, p_147756_3_ + d5, (p_147756_4_ + f2), d3, d2);
/* 1762 */       tessellator.func_78374_a(p_147756_2_, p_147756_3_ + d5, (p_147756_4_ + f2), d1, d2);
/*      */       
/* 1764 */       tessellator.func_78374_a(p_147756_2_, p_147756_3_ + d5, (p_147756_4_ + f2), d1, d2);
/* 1765 */       tessellator.func_78374_a(p_147756_2_ + 0.25D, p_147756_3_ + d5, (p_147756_4_ + f2), d3, d2);
/* 1766 */       tessellator.func_78374_a(p_147756_2_ + 0.25D, p_147756_3_ + d5, (p_147756_4_ + f3), d3, d4);
/* 1767 */       tessellator.func_78374_a(p_147756_2_, p_147756_3_ + d5, (p_147756_4_ + f3), d1, d4);
/*      */     } 
/* 1769 */     if (bool3 || (bool4 && !bool5 && !bool6)) {
/* 1770 */       tessellator.func_78374_a(p_147756_2_ + 0.25D, p_147756_3_ + d5, (p_147756_4_ + f3), d1, d4);
/* 1771 */       tessellator.func_78374_a(p_147756_2_ + 0.5D, p_147756_3_ + d5, (p_147756_4_ + f3), d3, d4);
/* 1772 */       tessellator.func_78374_a(p_147756_2_ + 0.5D, p_147756_3_ + d5, (p_147756_4_ + f2), d3, d2);
/* 1773 */       tessellator.func_78374_a(p_147756_2_ + 0.25D, p_147756_3_ + d5, (p_147756_4_ + f2), d1, d2);
/*      */       
/* 1775 */       tessellator.func_78374_a(p_147756_2_ + 0.25D, p_147756_3_ + d5, (p_147756_4_ + f2), d1, d2);
/* 1776 */       tessellator.func_78374_a(p_147756_2_ + 0.5D, p_147756_3_ + d5, (p_147756_4_ + f2), d3, d2);
/* 1777 */       tessellator.func_78374_a(p_147756_2_ + 0.5D, p_147756_3_ + d5, (p_147756_4_ + f3), d3, d4);
/* 1778 */       tessellator.func_78374_a(p_147756_2_ + 0.25D, p_147756_3_ + d5, (p_147756_4_ + f3), d1, d4);
/*      */     } 
/* 1780 */     if (bool4 || (bool3 && !bool5 && !bool6)) {
/* 1781 */       tessellator.func_78374_a(p_147756_2_ + 0.5D, p_147756_3_ + d5, (p_147756_4_ + f3), d1, d4);
/* 1782 */       tessellator.func_78374_a(p_147756_2_ + 0.75D, p_147756_3_ + d5, (p_147756_4_ + f3), d3, d4);
/* 1783 */       tessellator.func_78374_a(p_147756_2_ + 0.75D, p_147756_3_ + d5, (p_147756_4_ + f2), d3, d2);
/* 1784 */       tessellator.func_78374_a(p_147756_2_ + 0.5D, p_147756_3_ + d5, (p_147756_4_ + f2), d1, d2);
/*      */       
/* 1786 */       tessellator.func_78374_a(p_147756_2_ + 0.5D, p_147756_3_ + d5, (p_147756_4_ + f2), d1, d2);
/* 1787 */       tessellator.func_78374_a(p_147756_2_ + 0.75D, p_147756_3_ + d5, (p_147756_4_ + f2), d3, d2);
/* 1788 */       tessellator.func_78374_a(p_147756_2_ + 0.75D, p_147756_3_ + d5, (p_147756_4_ + f3), d3, d4);
/* 1789 */       tessellator.func_78374_a(p_147756_2_ + 0.5D, p_147756_3_ + d5, (p_147756_4_ + f3), d1, d4);
/*      */     } 
/* 1791 */     if (bool4) {
/* 1792 */       tessellator.func_78374_a(p_147756_2_ + 0.75D, p_147756_3_ + d5, (p_147756_4_ + f3), d1, d4);
/* 1793 */       tessellator.func_78374_a((p_147756_2_ + 1), p_147756_3_ + d5, (p_147756_4_ + f3), d3, d4);
/* 1794 */       tessellator.func_78374_a((p_147756_2_ + 1), p_147756_3_ + d5, (p_147756_4_ + f2), d3, d2);
/* 1795 */       tessellator.func_78374_a(p_147756_2_ + 0.75D, p_147756_3_ + d5, (p_147756_4_ + f2), d1, d2);
/*      */       
/* 1797 */       tessellator.func_78374_a(p_147756_2_ + 0.75D, p_147756_3_ + d5, (p_147756_4_ + f2), d1, d2);
/* 1798 */       tessellator.func_78374_a((p_147756_2_ + 1), p_147756_3_ + d5, (p_147756_4_ + f2), d3, d2);
/* 1799 */       tessellator.func_78374_a((p_147756_2_ + 1), p_147756_3_ + d5, (p_147756_4_ + f3), d3, d4);
/* 1800 */       tessellator.func_78374_a(p_147756_2_ + 0.75D, p_147756_3_ + d5, (p_147756_4_ + f3), d1, d4);
/*      */     } 
/*      */     
/* 1803 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147801_a(BlockFire p_147801_1_, int p_147801_2_, int p_147801_3_, int p_147801_4_) {
/* 1807 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 1808 */     IIcon iIcon1 = p_147801_1_.func_149840_c(0);
/* 1809 */     IIcon iIcon2 = p_147801_1_.func_149840_c(1);
/* 1810 */     IIcon iIcon3 = iIcon1;
/*      */     
/* 1812 */     if (func_147744_b()) iIcon3 = this.field_147840_d;
/*      */     
/* 1814 */     tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/* 1815 */     tessellator.func_78380_c(p_147801_1_.func_149677_c(this.field_147845_a, p_147801_2_, p_147801_3_, p_147801_4_));
/*      */     
/* 1817 */     double d1 = iIcon3.func_94209_e();
/* 1818 */     double d2 = iIcon3.func_94206_g();
/* 1819 */     double d3 = iIcon3.func_94212_f();
/* 1820 */     double d4 = iIcon3.func_94210_h();
/* 1821 */     float f = 1.4F;
/*      */ 
/*      */     
/* 1824 */     if (World.func_147466_a(this.field_147845_a, p_147801_2_, p_147801_3_ - 1, p_147801_4_) || Blocks.field_150480_ab.func_149844_e(this.field_147845_a, p_147801_2_, p_147801_3_ - 1, p_147801_4_)) {
/* 1825 */       double d5 = p_147801_2_ + 0.5D + 0.2D;
/* 1826 */       double d6 = p_147801_2_ + 0.5D - 0.2D;
/* 1827 */       double d7 = p_147801_4_ + 0.5D + 0.2D;
/* 1828 */       double d8 = p_147801_4_ + 0.5D - 0.2D;
/*      */       
/* 1830 */       double d9 = p_147801_2_ + 0.5D - 0.3D;
/* 1831 */       double d10 = p_147801_2_ + 0.5D + 0.3D;
/* 1832 */       double d11 = p_147801_4_ + 0.5D - 0.3D;
/* 1833 */       double d12 = p_147801_4_ + 0.5D + 0.3D;
/*      */       
/* 1835 */       tessellator.func_78374_a(d9, (p_147801_3_ + f), (p_147801_4_ + 1), d3, d2);
/* 1836 */       tessellator.func_78374_a(d5, (p_147801_3_ + 0), (p_147801_4_ + 1), d3, d4);
/* 1837 */       tessellator.func_78374_a(d5, (p_147801_3_ + 0), (p_147801_4_ + 0), d1, d4);
/* 1838 */       tessellator.func_78374_a(d9, (p_147801_3_ + f), (p_147801_4_ + 0), d1, d2);
/*      */       
/* 1840 */       tessellator.func_78374_a(d10, (p_147801_3_ + f), (p_147801_4_ + 0), d3, d2);
/* 1841 */       tessellator.func_78374_a(d6, (p_147801_3_ + 0), (p_147801_4_ + 0), d3, d4);
/* 1842 */       tessellator.func_78374_a(d6, (p_147801_3_ + 0), (p_147801_4_ + 1), d1, d4);
/* 1843 */       tessellator.func_78374_a(d10, (p_147801_3_ + f), (p_147801_4_ + 1), d1, d2);
/*      */       
/* 1845 */       iIcon3 = iIcon2;
/* 1846 */       d1 = iIcon3.func_94209_e();
/* 1847 */       d2 = iIcon3.func_94206_g();
/* 1848 */       d3 = iIcon3.func_94212_f();
/* 1849 */       d4 = iIcon3.func_94210_h();
/*      */       
/* 1851 */       tessellator.func_78374_a((p_147801_2_ + 1), (p_147801_3_ + f), d12, d3, d2);
/* 1852 */       tessellator.func_78374_a((p_147801_2_ + 1), (p_147801_3_ + 0), d8, d3, d4);
/* 1853 */       tessellator.func_78374_a((p_147801_2_ + 0), (p_147801_3_ + 0), d8, d1, d4);
/* 1854 */       tessellator.func_78374_a((p_147801_2_ + 0), (p_147801_3_ + f), d12, d1, d2);
/*      */       
/* 1856 */       tessellator.func_78374_a((p_147801_2_ + 0), (p_147801_3_ + f), d11, d3, d2);
/* 1857 */       tessellator.func_78374_a((p_147801_2_ + 0), (p_147801_3_ + 0), d7, d3, d4);
/* 1858 */       tessellator.func_78374_a((p_147801_2_ + 1), (p_147801_3_ + 0), d7, d1, d4);
/* 1859 */       tessellator.func_78374_a((p_147801_2_ + 1), (p_147801_3_ + f), d11, d1, d2);
/*      */       
/* 1861 */       d5 = p_147801_2_ + 0.5D - 0.5D;
/* 1862 */       d6 = p_147801_2_ + 0.5D + 0.5D;
/* 1863 */       d7 = p_147801_4_ + 0.5D - 0.5D;
/* 1864 */       d8 = p_147801_4_ + 0.5D + 0.5D;
/*      */       
/* 1866 */       d9 = p_147801_2_ + 0.5D - 0.4D;
/* 1867 */       d10 = p_147801_2_ + 0.5D + 0.4D;
/* 1868 */       d11 = p_147801_4_ + 0.5D - 0.4D;
/* 1869 */       d12 = p_147801_4_ + 0.5D + 0.4D;
/*      */       
/* 1871 */       tessellator.func_78374_a(d9, (p_147801_3_ + f), (p_147801_4_ + 0), d1, d2);
/* 1872 */       tessellator.func_78374_a(d5, (p_147801_3_ + 0), (p_147801_4_ + 0), d1, d4);
/* 1873 */       tessellator.func_78374_a(d5, (p_147801_3_ + 0), (p_147801_4_ + 1), d3, d4);
/* 1874 */       tessellator.func_78374_a(d9, (p_147801_3_ + f), (p_147801_4_ + 1), d3, d2);
/*      */       
/* 1876 */       tessellator.func_78374_a(d10, (p_147801_3_ + f), (p_147801_4_ + 1), d1, d2);
/* 1877 */       tessellator.func_78374_a(d6, (p_147801_3_ + 0), (p_147801_4_ + 1), d1, d4);
/* 1878 */       tessellator.func_78374_a(d6, (p_147801_3_ + 0), (p_147801_4_ + 0), d3, d4);
/* 1879 */       tessellator.func_78374_a(d10, (p_147801_3_ + f), (p_147801_4_ + 0), d3, d2);
/*      */       
/* 1881 */       iIcon3 = iIcon1;
/* 1882 */       d1 = iIcon3.func_94209_e();
/* 1883 */       d2 = iIcon3.func_94206_g();
/* 1884 */       d3 = iIcon3.func_94212_f();
/* 1885 */       d4 = iIcon3.func_94210_h();
/*      */       
/* 1887 */       tessellator.func_78374_a((p_147801_2_ + 0), (p_147801_3_ + f), d12, d1, d2);
/* 1888 */       tessellator.func_78374_a((p_147801_2_ + 0), (p_147801_3_ + 0), d8, d1, d4);
/* 1889 */       tessellator.func_78374_a((p_147801_2_ + 1), (p_147801_3_ + 0), d8, d3, d4);
/* 1890 */       tessellator.func_78374_a((p_147801_2_ + 1), (p_147801_3_ + f), d12, d3, d2);
/*      */       
/* 1892 */       tessellator.func_78374_a((p_147801_2_ + 1), (p_147801_3_ + f), d11, d1, d2);
/* 1893 */       tessellator.func_78374_a((p_147801_2_ + 1), (p_147801_3_ + 0), d7, d1, d4);
/* 1894 */       tessellator.func_78374_a((p_147801_2_ + 0), (p_147801_3_ + 0), d7, d3, d4);
/* 1895 */       tessellator.func_78374_a((p_147801_2_ + 0), (p_147801_3_ + f), d11, d3, d2);
/*      */     } else {
/* 1897 */       float f1 = 0.2F;
/* 1898 */       float f2 = 0.0625F;
/* 1899 */       if ((p_147801_2_ + p_147801_3_ + p_147801_4_ & 0x1) == 1) {
/* 1900 */         iIcon3 = iIcon2;
/* 1901 */         d1 = iIcon3.func_94209_e();
/* 1902 */         d2 = iIcon3.func_94206_g();
/* 1903 */         d3 = iIcon3.func_94212_f();
/* 1904 */         d4 = iIcon3.func_94210_h();
/*      */       } 
/* 1906 */       if ((p_147801_2_ / 2 + p_147801_3_ / 2 + p_147801_4_ / 2 & 0x1) == 1) {
/* 1907 */         double d = d3;
/* 1908 */         d3 = d1;
/* 1909 */         d1 = d;
/*      */       } 
/* 1911 */       if (Blocks.field_150480_ab.func_149844_e(this.field_147845_a, p_147801_2_ - 1, p_147801_3_, p_147801_4_)) {
/* 1912 */         tessellator.func_78374_a((p_147801_2_ + f1), (p_147801_3_ + f + f2), (p_147801_4_ + 1), d3, d2);
/* 1913 */         tessellator.func_78374_a((p_147801_2_ + 0), ((p_147801_3_ + 0) + f2), (p_147801_4_ + 1), d3, d4);
/* 1914 */         tessellator.func_78374_a((p_147801_2_ + 0), ((p_147801_3_ + 0) + f2), (p_147801_4_ + 0), d1, d4);
/* 1915 */         tessellator.func_78374_a((p_147801_2_ + f1), (p_147801_3_ + f + f2), (p_147801_4_ + 0), d1, d2);
/*      */         
/* 1917 */         tessellator.func_78374_a((p_147801_2_ + f1), (p_147801_3_ + f + f2), (p_147801_4_ + 0), d1, d2);
/* 1918 */         tessellator.func_78374_a((p_147801_2_ + 0), ((p_147801_3_ + 0) + f2), (p_147801_4_ + 0), d1, d4);
/* 1919 */         tessellator.func_78374_a((p_147801_2_ + 0), ((p_147801_3_ + 0) + f2), (p_147801_4_ + 1), d3, d4);
/* 1920 */         tessellator.func_78374_a((p_147801_2_ + f1), (p_147801_3_ + f + f2), (p_147801_4_ + 1), d3, d2);
/*      */       } 
/* 1922 */       if (Blocks.field_150480_ab.func_149844_e(this.field_147845_a, p_147801_2_ + 1, p_147801_3_, p_147801_4_)) {
/* 1923 */         tessellator.func_78374_a(((p_147801_2_ + 1) - f1), (p_147801_3_ + f + f2), (p_147801_4_ + 0), d1, d2);
/* 1924 */         tessellator.func_78374_a((p_147801_2_ + 1 - 0), ((p_147801_3_ + 0) + f2), (p_147801_4_ + 0), d1, d4);
/* 1925 */         tessellator.func_78374_a((p_147801_2_ + 1 - 0), ((p_147801_3_ + 0) + f2), (p_147801_4_ + 1), d3, d4);
/* 1926 */         tessellator.func_78374_a(((p_147801_2_ + 1) - f1), (p_147801_3_ + f + f2), (p_147801_4_ + 1), d3, d2);
/*      */         
/* 1928 */         tessellator.func_78374_a(((p_147801_2_ + 1) - f1), (p_147801_3_ + f + f2), (p_147801_4_ + 1), d3, d2);
/* 1929 */         tessellator.func_78374_a((p_147801_2_ + 1 - 0), ((p_147801_3_ + 0) + f2), (p_147801_4_ + 1), d3, d4);
/* 1930 */         tessellator.func_78374_a((p_147801_2_ + 1 - 0), ((p_147801_3_ + 0) + f2), (p_147801_4_ + 0), d1, d4);
/* 1931 */         tessellator.func_78374_a(((p_147801_2_ + 1) - f1), (p_147801_3_ + f + f2), (p_147801_4_ + 0), d1, d2);
/*      */       } 
/* 1933 */       if (Blocks.field_150480_ab.func_149844_e(this.field_147845_a, p_147801_2_, p_147801_3_, p_147801_4_ - 1)) {
/* 1934 */         tessellator.func_78374_a((p_147801_2_ + 0), (p_147801_3_ + f + f2), (p_147801_4_ + f1), d3, d2);
/* 1935 */         tessellator.func_78374_a((p_147801_2_ + 0), ((p_147801_3_ + 0) + f2), (p_147801_4_ + 0), d3, d4);
/* 1936 */         tessellator.func_78374_a((p_147801_2_ + 1), ((p_147801_3_ + 0) + f2), (p_147801_4_ + 0), d1, d4);
/* 1937 */         tessellator.func_78374_a((p_147801_2_ + 1), (p_147801_3_ + f + f2), (p_147801_4_ + f1), d1, d2);
/*      */         
/* 1939 */         tessellator.func_78374_a((p_147801_2_ + 1), (p_147801_3_ + f + f2), (p_147801_4_ + f1), d1, d2);
/* 1940 */         tessellator.func_78374_a((p_147801_2_ + 1), ((p_147801_3_ + 0) + f2), (p_147801_4_ + 0), d1, d4);
/* 1941 */         tessellator.func_78374_a((p_147801_2_ + 0), ((p_147801_3_ + 0) + f2), (p_147801_4_ + 0), d3, d4);
/* 1942 */         tessellator.func_78374_a((p_147801_2_ + 0), (p_147801_3_ + f + f2), (p_147801_4_ + f1), d3, d2);
/*      */       } 
/* 1944 */       if (Blocks.field_150480_ab.func_149844_e(this.field_147845_a, p_147801_2_, p_147801_3_, p_147801_4_ + 1)) {
/* 1945 */         tessellator.func_78374_a((p_147801_2_ + 1), (p_147801_3_ + f + f2), ((p_147801_4_ + 1) - f1), d1, d2);
/* 1946 */         tessellator.func_78374_a((p_147801_2_ + 1), ((p_147801_3_ + 0) + f2), (p_147801_4_ + 1 - 0), d1, d4);
/* 1947 */         tessellator.func_78374_a((p_147801_2_ + 0), ((p_147801_3_ + 0) + f2), (p_147801_4_ + 1 - 0), d3, d4);
/* 1948 */         tessellator.func_78374_a((p_147801_2_ + 0), (p_147801_3_ + f + f2), ((p_147801_4_ + 1) - f1), d3, d2);
/*      */         
/* 1950 */         tessellator.func_78374_a((p_147801_2_ + 0), (p_147801_3_ + f + f2), ((p_147801_4_ + 1) - f1), d3, d2);
/* 1951 */         tessellator.func_78374_a((p_147801_2_ + 0), ((p_147801_3_ + 0) + f2), (p_147801_4_ + 1 - 0), d3, d4);
/* 1952 */         tessellator.func_78374_a((p_147801_2_ + 1), ((p_147801_3_ + 0) + f2), (p_147801_4_ + 1 - 0), d1, d4);
/* 1953 */         tessellator.func_78374_a((p_147801_2_ + 1), (p_147801_3_ + f + f2), ((p_147801_4_ + 1) - f1), d1, d2);
/*      */       } 
/* 1955 */       if (Blocks.field_150480_ab.func_149844_e(this.field_147845_a, p_147801_2_, p_147801_3_ + 1, p_147801_4_)) {
/* 1956 */         double d5 = p_147801_2_ + 0.5D + 0.5D;
/* 1957 */         double d6 = p_147801_2_ + 0.5D - 0.5D;
/* 1958 */         double d7 = p_147801_4_ + 0.5D + 0.5D;
/* 1959 */         double d8 = p_147801_4_ + 0.5D - 0.5D;
/*      */         
/* 1961 */         double d9 = p_147801_2_ + 0.5D - 0.5D;
/* 1962 */         double d10 = p_147801_2_ + 0.5D + 0.5D;
/* 1963 */         double d11 = p_147801_4_ + 0.5D - 0.5D;
/* 1964 */         double d12 = p_147801_4_ + 0.5D + 0.5D;
/*      */         
/* 1966 */         iIcon3 = iIcon1;
/* 1967 */         d1 = iIcon3.func_94209_e();
/* 1968 */         d2 = iIcon3.func_94206_g();
/* 1969 */         d3 = iIcon3.func_94212_f();
/* 1970 */         d4 = iIcon3.func_94210_h();
/*      */         
/* 1972 */         p_147801_3_++;
/* 1973 */         f = -0.2F;
/*      */         
/* 1975 */         if ((p_147801_2_ + p_147801_3_ + p_147801_4_ & 0x1) == 0) {
/*      */           
/* 1977 */           tessellator.func_78374_a(d9, (p_147801_3_ + f), (p_147801_4_ + 0), d3, d2);
/* 1978 */           tessellator.func_78374_a(d5, (p_147801_3_ + 0), (p_147801_4_ + 0), d3, d4);
/* 1979 */           tessellator.func_78374_a(d5, (p_147801_3_ + 0), (p_147801_4_ + 1), d1, d4);
/* 1980 */           tessellator.func_78374_a(d9, (p_147801_3_ + f), (p_147801_4_ + 1), d1, d2);
/*      */           
/* 1982 */           iIcon3 = iIcon2;
/* 1983 */           d1 = iIcon3.func_94209_e();
/* 1984 */           d2 = iIcon3.func_94206_g();
/* 1985 */           d3 = iIcon3.func_94212_f();
/* 1986 */           d4 = iIcon3.func_94210_h();
/*      */           
/* 1988 */           tessellator.func_78374_a(d10, (p_147801_3_ + f), (p_147801_4_ + 1), d3, d2);
/* 1989 */           tessellator.func_78374_a(d6, (p_147801_3_ + 0), (p_147801_4_ + 1), d3, d4);
/* 1990 */           tessellator.func_78374_a(d6, (p_147801_3_ + 0), (p_147801_4_ + 0), d1, d4);
/* 1991 */           tessellator.func_78374_a(d10, (p_147801_3_ + f), (p_147801_4_ + 0), d1, d2);
/*      */         }
/*      */         else {
/*      */           
/* 1995 */           tessellator.func_78374_a((p_147801_2_ + 0), (p_147801_3_ + f), d12, d3, d2);
/* 1996 */           tessellator.func_78374_a((p_147801_2_ + 0), (p_147801_3_ + 0), d8, d3, d4);
/* 1997 */           tessellator.func_78374_a((p_147801_2_ + 1), (p_147801_3_ + 0), d8, d1, d4);
/* 1998 */           tessellator.func_78374_a((p_147801_2_ + 1), (p_147801_3_ + f), d12, d1, d2);
/*      */           
/* 2000 */           iIcon3 = iIcon2;
/* 2001 */           d1 = iIcon3.func_94209_e();
/* 2002 */           d2 = iIcon3.func_94206_g();
/* 2003 */           d3 = iIcon3.func_94212_f();
/* 2004 */           d4 = iIcon3.func_94210_h();
/*      */           
/* 2006 */           tessellator.func_78374_a((p_147801_2_ + 1), (p_147801_3_ + f), d11, d3, d2);
/* 2007 */           tessellator.func_78374_a((p_147801_2_ + 1), (p_147801_3_ + 0), d7, d3, d4);
/* 2008 */           tessellator.func_78374_a((p_147801_2_ + 0), (p_147801_3_ + 0), d7, d1, d4);
/* 2009 */           tessellator.func_78374_a((p_147801_2_ + 0), (p_147801_3_ + f), d11, d1, d2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 2014 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147788_h(Block p_147788_1_, int p_147788_2_, int p_147788_3_, int p_147788_4_) {
/* 2018 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 2020 */     int i = this.field_147845_a.func_72805_g(p_147788_2_, p_147788_3_, p_147788_4_);
/* 2021 */     IIcon iIcon1 = BlockRedstoneWire.func_150173_e("cross");
/* 2022 */     IIcon iIcon2 = BlockRedstoneWire.func_150173_e("line");
/* 2023 */     IIcon iIcon3 = BlockRedstoneWire.func_150173_e("cross_overlay");
/* 2024 */     IIcon iIcon4 = BlockRedstoneWire.func_150173_e("line_overlay");
/*      */     
/* 2026 */     tessellator.func_78380_c(p_147788_1_.func_149677_c(this.field_147845_a, p_147788_2_, p_147788_3_, p_147788_4_));
/*      */     
/* 2028 */     float f1 = i / 15.0F;
/* 2029 */     float f2 = f1 * 0.6F + 0.4F;
/* 2030 */     if (i == 0) f2 = 0.3F;
/*      */     
/* 2032 */     float f3 = f1 * f1 * 0.7F - 0.5F;
/* 2033 */     float f4 = f1 * f1 * 0.6F - 0.7F;
/* 2034 */     if (f3 < 0.0F) f3 = 0.0F; 
/* 2035 */     if (f4 < 0.0F) f4 = 0.0F;
/*      */     
/* 2037 */     tessellator.func_78386_a(f2, f3, f4);
/*      */     
/* 2039 */     double d1 = 0.015625D;
/* 2040 */     double d2 = 0.015625D;
/*      */     
/* 2042 */     boolean bool1 = (BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_ - 1, p_147788_3_, p_147788_4_, 1) || (!this.field_147845_a.func_147439_a(p_147788_2_ - 1, p_147788_3_, p_147788_4_).func_149637_q() && BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_ - 1, p_147788_3_ - 1, p_147788_4_, -1))) ? true : false;
/*      */     
/* 2044 */     boolean bool2 = (BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_ + 1, p_147788_3_, p_147788_4_, 3) || (!this.field_147845_a.func_147439_a(p_147788_2_ + 1, p_147788_3_, p_147788_4_).func_149637_q() && BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_ + 1, p_147788_3_ - 1, p_147788_4_, -1))) ? true : false;
/*      */     
/* 2046 */     boolean bool3 = (BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_, p_147788_3_, p_147788_4_ - 1, 2) || (!this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_, p_147788_4_ - 1).func_149637_q() && BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_, p_147788_3_ - 1, p_147788_4_ - 1, -1))) ? true : false;
/*      */     
/* 2048 */     boolean bool4 = (BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_, p_147788_3_, p_147788_4_ + 1, 0) || (!this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_, p_147788_4_ + 1).func_149637_q() && BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_, p_147788_3_ - 1, p_147788_4_ + 1, -1))) ? true : false;
/*      */     
/* 2050 */     if (!this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_ + 1, p_147788_4_).func_149637_q()) {
/* 2051 */       if (this.field_147845_a.func_147439_a(p_147788_2_ - 1, p_147788_3_, p_147788_4_).func_149637_q() && BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_ - 1, p_147788_3_ + 1, p_147788_4_, -1)) bool1 = true; 
/* 2052 */       if (this.field_147845_a.func_147439_a(p_147788_2_ + 1, p_147788_3_, p_147788_4_).func_149637_q() && BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_ + 1, p_147788_3_ + 1, p_147788_4_, -1)) bool2 = true; 
/* 2053 */       if (this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_, p_147788_4_ - 1).func_149637_q() && BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_, p_147788_3_ + 1, p_147788_4_ - 1, -1)) bool3 = true; 
/* 2054 */       if (this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_, p_147788_4_ + 1).func_149637_q() && BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_, p_147788_3_ + 1, p_147788_4_ + 1, -1)) bool4 = true;
/*      */     
/*      */     } 
/* 2057 */     float f5 = (p_147788_2_ + 0);
/* 2058 */     float f6 = (p_147788_2_ + 1);
/* 2059 */     float f7 = (p_147788_4_ + 0);
/* 2060 */     float f8 = (p_147788_4_ + 1);
/*      */     
/* 2062 */     byte b = 0;
/* 2063 */     if ((bool1 || bool2) && !bool3 && !bool4) b = 1; 
/* 2064 */     if ((bool3 || bool4) && !bool2 && !bool1) b = 2;
/*      */     
/* 2066 */     if (b == 0) {
/*      */       
/* 2068 */       boolean bool5 = false;
/* 2069 */       boolean bool6 = false;
/* 2070 */       byte b1 = 16;
/* 2071 */       byte b2 = 16;
/*      */       
/* 2073 */       byte b3 = 5;
/* 2074 */       if (!bool1) f5 += 0.3125F; 
/* 2075 */       if (!bool1) bool5 += true; 
/* 2076 */       if (!bool2) f6 -= 0.3125F; 
/* 2077 */       if (!bool2) b1 -= 5; 
/* 2078 */       if (!bool3) f7 += 0.3125F; 
/* 2079 */       if (!bool3) bool6 += true; 
/* 2080 */       if (!bool4) f8 -= 0.3125F; 
/* 2081 */       if (!bool4) b2 -= 5;
/*      */       
/* 2083 */       tessellator.func_78374_a(f6, p_147788_3_ + 0.015625D, f8, iIcon1.func_94214_a(b1), iIcon1.func_94207_b(b2));
/* 2084 */       tessellator.func_78374_a(f6, p_147788_3_ + 0.015625D, f7, iIcon1.func_94214_a(b1), iIcon1.func_94207_b(bool6));
/* 2085 */       tessellator.func_78374_a(f5, p_147788_3_ + 0.015625D, f7, iIcon1.func_94214_a(bool5), iIcon1.func_94207_b(bool6));
/* 2086 */       tessellator.func_78374_a(f5, p_147788_3_ + 0.015625D, f8, iIcon1.func_94214_a(bool5), iIcon1.func_94207_b(b2));
/*      */       
/* 2088 */       tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/* 2089 */       tessellator.func_78374_a(f6, p_147788_3_ + 0.015625D, f8, iIcon3.func_94214_a(b1), iIcon3.func_94207_b(b2));
/* 2090 */       tessellator.func_78374_a(f6, p_147788_3_ + 0.015625D, f7, iIcon3.func_94214_a(b1), iIcon3.func_94207_b(bool6));
/* 2091 */       tessellator.func_78374_a(f5, p_147788_3_ + 0.015625D, f7, iIcon3.func_94214_a(bool5), iIcon3.func_94207_b(bool6));
/* 2092 */       tessellator.func_78374_a(f5, p_147788_3_ + 0.015625D, f8, iIcon3.func_94214_a(bool5), iIcon3.func_94207_b(b2));
/* 2093 */     } else if (b == 1) {
/* 2094 */       tessellator.func_78374_a(f6, p_147788_3_ + 0.015625D, f8, iIcon2.func_94212_f(), iIcon2.func_94210_h());
/* 2095 */       tessellator.func_78374_a(f6, p_147788_3_ + 0.015625D, f7, iIcon2.func_94212_f(), iIcon2.func_94206_g());
/* 2096 */       tessellator.func_78374_a(f5, p_147788_3_ + 0.015625D, f7, iIcon2.func_94209_e(), iIcon2.func_94206_g());
/* 2097 */       tessellator.func_78374_a(f5, p_147788_3_ + 0.015625D, f8, iIcon2.func_94209_e(), iIcon2.func_94210_h());
/*      */       
/* 2099 */       tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/* 2100 */       tessellator.func_78374_a(f6, p_147788_3_ + 0.015625D, f8, iIcon4.func_94212_f(), iIcon4.func_94210_h());
/* 2101 */       tessellator.func_78374_a(f6, p_147788_3_ + 0.015625D, f7, iIcon4.func_94212_f(), iIcon4.func_94206_g());
/* 2102 */       tessellator.func_78374_a(f5, p_147788_3_ + 0.015625D, f7, iIcon4.func_94209_e(), iIcon4.func_94206_g());
/* 2103 */       tessellator.func_78374_a(f5, p_147788_3_ + 0.015625D, f8, iIcon4.func_94209_e(), iIcon4.func_94210_h());
/*      */     } else {
/* 2105 */       tessellator.func_78374_a(f6, p_147788_3_ + 0.015625D, f8, iIcon2.func_94212_f(), iIcon2.func_94210_h());
/* 2106 */       tessellator.func_78374_a(f6, p_147788_3_ + 0.015625D, f7, iIcon2.func_94209_e(), iIcon2.func_94210_h());
/* 2107 */       tessellator.func_78374_a(f5, p_147788_3_ + 0.015625D, f7, iIcon2.func_94209_e(), iIcon2.func_94206_g());
/* 2108 */       tessellator.func_78374_a(f5, p_147788_3_ + 0.015625D, f8, iIcon2.func_94212_f(), iIcon2.func_94206_g());
/*      */       
/* 2110 */       tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/* 2111 */       tessellator.func_78374_a(f6, p_147788_3_ + 0.015625D, f8, iIcon4.func_94212_f(), iIcon4.func_94210_h());
/* 2112 */       tessellator.func_78374_a(f6, p_147788_3_ + 0.015625D, f7, iIcon4.func_94209_e(), iIcon4.func_94210_h());
/* 2113 */       tessellator.func_78374_a(f5, p_147788_3_ + 0.015625D, f7, iIcon4.func_94209_e(), iIcon4.func_94206_g());
/* 2114 */       tessellator.func_78374_a(f5, p_147788_3_ + 0.015625D, f8, iIcon4.func_94212_f(), iIcon4.func_94206_g());
/*      */     } 
/*      */     
/* 2117 */     if (!this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_ + 1, p_147788_4_).func_149637_q()) {
/* 2118 */       float f = 0.021875F;
/*      */       
/* 2120 */       if (this.field_147845_a.func_147439_a(p_147788_2_ - 1, p_147788_3_, p_147788_4_).func_149637_q() && this.field_147845_a.func_147439_a(p_147788_2_ - 1, p_147788_3_ + 1, p_147788_4_) == Blocks.field_150488_af) {
/* 2121 */         tessellator.func_78386_a(f2, f3, f4);
/* 2122 */         tessellator.func_78374_a(p_147788_2_ + 0.015625D, ((p_147788_3_ + 1) + 0.021875F), (p_147788_4_ + 1), iIcon2.func_94212_f(), iIcon2.func_94206_g());
/* 2123 */         tessellator.func_78374_a(p_147788_2_ + 0.015625D, (p_147788_3_ + 0), (p_147788_4_ + 1), iIcon2.func_94209_e(), iIcon2.func_94206_g());
/* 2124 */         tessellator.func_78374_a(p_147788_2_ + 0.015625D, (p_147788_3_ + 0), (p_147788_4_ + 0), iIcon2.func_94209_e(), iIcon2.func_94210_h());
/* 2125 */         tessellator.func_78374_a(p_147788_2_ + 0.015625D, ((p_147788_3_ + 1) + 0.021875F), (p_147788_4_ + 0), iIcon2.func_94212_f(), iIcon2.func_94210_h());
/*      */         
/* 2127 */         tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/* 2128 */         tessellator.func_78374_a(p_147788_2_ + 0.015625D, ((p_147788_3_ + 1) + 0.021875F), (p_147788_4_ + 1), iIcon4.func_94212_f(), iIcon4.func_94206_g());
/* 2129 */         tessellator.func_78374_a(p_147788_2_ + 0.015625D, (p_147788_3_ + 0), (p_147788_4_ + 1), iIcon4.func_94209_e(), iIcon4.func_94206_g());
/* 2130 */         tessellator.func_78374_a(p_147788_2_ + 0.015625D, (p_147788_3_ + 0), (p_147788_4_ + 0), iIcon4.func_94209_e(), iIcon4.func_94210_h());
/* 2131 */         tessellator.func_78374_a(p_147788_2_ + 0.015625D, ((p_147788_3_ + 1) + 0.021875F), (p_147788_4_ + 0), iIcon4.func_94212_f(), iIcon4.func_94210_h());
/*      */       } 
/* 2133 */       if (this.field_147845_a.func_147439_a(p_147788_2_ + 1, p_147788_3_, p_147788_4_).func_149637_q() && this.field_147845_a.func_147439_a(p_147788_2_ + 1, p_147788_3_ + 1, p_147788_4_) == Blocks.field_150488_af) {
/* 2134 */         tessellator.func_78386_a(f2, f3, f4);
/* 2135 */         tessellator.func_78374_a((p_147788_2_ + 1) - 0.015625D, (p_147788_3_ + 0), (p_147788_4_ + 1), iIcon2.func_94209_e(), iIcon2.func_94210_h());
/* 2136 */         tessellator.func_78374_a((p_147788_2_ + 1) - 0.015625D, ((p_147788_3_ + 1) + 0.021875F), (p_147788_4_ + 1), iIcon2.func_94212_f(), iIcon2.func_94210_h());
/* 2137 */         tessellator.func_78374_a((p_147788_2_ + 1) - 0.015625D, ((p_147788_3_ + 1) + 0.021875F), (p_147788_4_ + 0), iIcon2.func_94212_f(), iIcon2.func_94206_g());
/* 2138 */         tessellator.func_78374_a((p_147788_2_ + 1) - 0.015625D, (p_147788_3_ + 0), (p_147788_4_ + 0), iIcon2.func_94209_e(), iIcon2.func_94206_g());
/*      */         
/* 2140 */         tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/* 2141 */         tessellator.func_78374_a((p_147788_2_ + 1) - 0.015625D, (p_147788_3_ + 0), (p_147788_4_ + 1), iIcon4.func_94209_e(), iIcon4.func_94210_h());
/* 2142 */         tessellator.func_78374_a((p_147788_2_ + 1) - 0.015625D, ((p_147788_3_ + 1) + 0.021875F), (p_147788_4_ + 1), iIcon4.func_94212_f(), iIcon4.func_94210_h());
/* 2143 */         tessellator.func_78374_a((p_147788_2_ + 1) - 0.015625D, ((p_147788_3_ + 1) + 0.021875F), (p_147788_4_ + 0), iIcon4.func_94212_f(), iIcon4.func_94206_g());
/* 2144 */         tessellator.func_78374_a((p_147788_2_ + 1) - 0.015625D, (p_147788_3_ + 0), (p_147788_4_ + 0), iIcon4.func_94209_e(), iIcon4.func_94206_g());
/*      */       } 
/* 2146 */       if (this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_, p_147788_4_ - 1).func_149637_q() && this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_ + 1, p_147788_4_ - 1) == Blocks.field_150488_af) {
/* 2147 */         tessellator.func_78386_a(f2, f3, f4);
/* 2148 */         tessellator.func_78374_a((p_147788_2_ + 1), (p_147788_3_ + 0), p_147788_4_ + 0.015625D, iIcon2.func_94209_e(), iIcon2.func_94210_h());
/* 2149 */         tessellator.func_78374_a((p_147788_2_ + 1), ((p_147788_3_ + 1) + 0.021875F), p_147788_4_ + 0.015625D, iIcon2.func_94212_f(), iIcon2.func_94210_h());
/* 2150 */         tessellator.func_78374_a((p_147788_2_ + 0), ((p_147788_3_ + 1) + 0.021875F), p_147788_4_ + 0.015625D, iIcon2.func_94212_f(), iIcon2.func_94206_g());
/* 2151 */         tessellator.func_78374_a((p_147788_2_ + 0), (p_147788_3_ + 0), p_147788_4_ + 0.015625D, iIcon2.func_94209_e(), iIcon2.func_94206_g());
/*      */         
/* 2153 */         tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/* 2154 */         tessellator.func_78374_a((p_147788_2_ + 1), (p_147788_3_ + 0), p_147788_4_ + 0.015625D, iIcon4.func_94209_e(), iIcon4.func_94210_h());
/* 2155 */         tessellator.func_78374_a((p_147788_2_ + 1), ((p_147788_3_ + 1) + 0.021875F), p_147788_4_ + 0.015625D, iIcon4.func_94212_f(), iIcon4.func_94210_h());
/* 2156 */         tessellator.func_78374_a((p_147788_2_ + 0), ((p_147788_3_ + 1) + 0.021875F), p_147788_4_ + 0.015625D, iIcon4.func_94212_f(), iIcon4.func_94206_g());
/* 2157 */         tessellator.func_78374_a((p_147788_2_ + 0), (p_147788_3_ + 0), p_147788_4_ + 0.015625D, iIcon4.func_94209_e(), iIcon4.func_94206_g());
/*      */       } 
/* 2159 */       if (this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_, p_147788_4_ + 1).func_149637_q() && this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_ + 1, p_147788_4_ + 1) == Blocks.field_150488_af) {
/* 2160 */         tessellator.func_78386_a(f2, f3, f4);
/* 2161 */         tessellator.func_78374_a((p_147788_2_ + 1), ((p_147788_3_ + 1) + 0.021875F), (p_147788_4_ + 1) - 0.015625D, iIcon2.func_94212_f(), iIcon2.func_94206_g());
/* 2162 */         tessellator.func_78374_a((p_147788_2_ + 1), (p_147788_3_ + 0), (p_147788_4_ + 1) - 0.015625D, iIcon2.func_94209_e(), iIcon2.func_94206_g());
/* 2163 */         tessellator.func_78374_a((p_147788_2_ + 0), (p_147788_3_ + 0), (p_147788_4_ + 1) - 0.015625D, iIcon2.func_94209_e(), iIcon2.func_94210_h());
/* 2164 */         tessellator.func_78374_a((p_147788_2_ + 0), ((p_147788_3_ + 1) + 0.021875F), (p_147788_4_ + 1) - 0.015625D, iIcon2.func_94212_f(), iIcon2.func_94210_h());
/*      */         
/* 2166 */         tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/* 2167 */         tessellator.func_78374_a((p_147788_2_ + 1), ((p_147788_3_ + 1) + 0.021875F), (p_147788_4_ + 1) - 0.015625D, iIcon4.func_94212_f(), iIcon4.func_94206_g());
/* 2168 */         tessellator.func_78374_a((p_147788_2_ + 1), (p_147788_3_ + 0), (p_147788_4_ + 1) - 0.015625D, iIcon4.func_94209_e(), iIcon4.func_94206_g());
/* 2169 */         tessellator.func_78374_a((p_147788_2_ + 0), (p_147788_3_ + 0), (p_147788_4_ + 1) - 0.015625D, iIcon4.func_94209_e(), iIcon4.func_94210_h());
/* 2170 */         tessellator.func_78374_a((p_147788_2_ + 0), ((p_147788_3_ + 1) + 0.021875F), (p_147788_4_ + 1) - 0.015625D, iIcon4.func_94212_f(), iIcon4.func_94210_h());
/*      */       } 
/*      */     } 
/*      */     
/* 2174 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147766_a(BlockRailBase p_147766_1_, int p_147766_2_, int p_147766_3_, int p_147766_4_) {
/* 2178 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 2179 */     int i = this.field_147845_a.func_72805_g(p_147766_2_, p_147766_3_, p_147766_4_);
/*      */     
/* 2181 */     IIcon iIcon = func_147787_a((Block)p_147766_1_, 0, i);
/* 2182 */     if (func_147744_b()) iIcon = this.field_147840_d;
/*      */     
/* 2184 */     if (p_147766_1_.func_150050_e()) {
/* 2185 */       i &= 0x7;
/*      */     }
/*      */     
/* 2188 */     tessellator.func_78380_c(p_147766_1_.func_149677_c(this.field_147845_a, p_147766_2_, p_147766_3_, p_147766_4_));
/* 2189 */     tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/*      */     
/* 2191 */     double d1 = iIcon.func_94209_e();
/* 2192 */     double d2 = iIcon.func_94206_g();
/* 2193 */     double d3 = iIcon.func_94212_f();
/* 2194 */     double d4 = iIcon.func_94210_h();
/*      */     
/* 2196 */     double d5 = 0.0625D;
/*      */     
/* 2198 */     double d6 = (p_147766_2_ + 1);
/* 2199 */     double d7 = (p_147766_2_ + 1);
/* 2200 */     double d8 = (p_147766_2_ + 0);
/* 2201 */     double d9 = (p_147766_2_ + 0);
/*      */     
/* 2203 */     double d10 = (p_147766_4_ + 0);
/* 2204 */     double d11 = (p_147766_4_ + 1);
/* 2205 */     double d12 = (p_147766_4_ + 1);
/* 2206 */     double d13 = (p_147766_4_ + 0);
/*      */     
/* 2208 */     double d14 = p_147766_3_ + d5;
/* 2209 */     double d15 = p_147766_3_ + d5;
/* 2210 */     double d16 = p_147766_3_ + d5;
/* 2211 */     double d17 = p_147766_3_ + d5;
/*      */ 
/*      */     
/* 2214 */     d6 = d9 = (p_147766_2_ + 1);
/* 2215 */     d7 = d8 = (p_147766_2_ + 0);
/* 2216 */     d10 = d11 = (p_147766_4_ + 1);
/* 2217 */     d12 = d13 = (p_147766_4_ + 0);
/*      */     
/* 2219 */     d6 = d7 = (p_147766_2_ + 0);
/* 2220 */     d8 = d9 = (p_147766_2_ + 1);
/* 2221 */     d10 = d13 = (p_147766_4_ + 1);
/* 2222 */     d11 = d12 = (p_147766_4_ + 0);
/* 2223 */     if (i == 9) {
/* 2224 */       d6 = d9 = (p_147766_2_ + 0);
/* 2225 */       d7 = d8 = (p_147766_2_ + 1);
/* 2226 */       d10 = d11 = (p_147766_4_ + 0);
/* 2227 */       d12 = d13 = (p_147766_4_ + 1);
/*      */     } 
/*      */     
/* 2230 */     if (i == 2 || i == 4) {
/* 2231 */       d14++;
/* 2232 */       d17++;
/* 2233 */     } else if (i == 3 || i == 5) {
/* 2234 */       d15++;
/* 2235 */       d16++;
/*      */     } 
/*      */     
/* 2238 */     tessellator.func_78374_a(d6, d14, d10, d3, d2);
/* 2239 */     tessellator.func_78374_a(d7, d15, d11, d3, d4);
/* 2240 */     tessellator.func_78374_a(d8, d16, d12, d1, d4);
/* 2241 */     tessellator.func_78374_a(d9, d17, d13, d1, d2);
/*      */     
/* 2243 */     tessellator.func_78374_a(d9, d17, d13, d1, d2);
/* 2244 */     tessellator.func_78374_a(d8, d16, d12, d1, d4);
/* 2245 */     tessellator.func_78374_a(d7, d15, d11, d3, d4);
/* 2246 */     tessellator.func_78374_a(d6, d14, d10, d3, d2);
/*      */     
/* 2248 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147794_i(Block p_147794_1_, int p_147794_2_, int p_147794_3_, int p_147794_4_) {
/* 2252 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 2254 */     IIcon iIcon = func_147777_a(p_147794_1_, 0);
/*      */     
/* 2256 */     if (func_147744_b()) iIcon = this.field_147840_d;
/*      */ 
/*      */     
/* 2259 */     tessellator.func_78380_c(p_147794_1_.func_149677_c(this.field_147845_a, p_147794_2_, p_147794_3_, p_147794_4_));
/* 2260 */     tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/*      */ 
/*      */     
/* 2263 */     double d1 = iIcon.func_94209_e();
/* 2264 */     double d2 = iIcon.func_94206_g();
/* 2265 */     double d3 = iIcon.func_94212_f();
/* 2266 */     double d4 = iIcon.func_94210_h();
/*      */     
/* 2268 */     int i = this.field_147845_a.func_72805_g(p_147794_2_, p_147794_3_, p_147794_4_);
/*      */     
/* 2270 */     double d5 = 0.0D;
/* 2271 */     double d6 = 0.05000000074505806D;
/* 2272 */     if (i == 5) {
/* 2273 */       tessellator.func_78374_a(p_147794_2_ + d6, (p_147794_3_ + 1) + d5, (p_147794_4_ + 1) + d5, d1, d2);
/* 2274 */       tessellator.func_78374_a(p_147794_2_ + d6, (p_147794_3_ + 0) - d5, (p_147794_4_ + 1) + d5, d1, d4);
/* 2275 */       tessellator.func_78374_a(p_147794_2_ + d6, (p_147794_3_ + 0) - d5, (p_147794_4_ + 0) - d5, d3, d4);
/* 2276 */       tessellator.func_78374_a(p_147794_2_ + d6, (p_147794_3_ + 1) + d5, (p_147794_4_ + 0) - d5, d3, d2);
/*      */     } 
/* 2278 */     if (i == 4) {
/* 2279 */       tessellator.func_78374_a((p_147794_2_ + 1) - d6, (p_147794_3_ + 0) - d5, (p_147794_4_ + 1) + d5, d3, d4);
/* 2280 */       tessellator.func_78374_a((p_147794_2_ + 1) - d6, (p_147794_3_ + 1) + d5, (p_147794_4_ + 1) + d5, d3, d2);
/* 2281 */       tessellator.func_78374_a((p_147794_2_ + 1) - d6, (p_147794_3_ + 1) + d5, (p_147794_4_ + 0) - d5, d1, d2);
/* 2282 */       tessellator.func_78374_a((p_147794_2_ + 1) - d6, (p_147794_3_ + 0) - d5, (p_147794_4_ + 0) - d5, d1, d4);
/*      */     } 
/* 2284 */     if (i == 3) {
/* 2285 */       tessellator.func_78374_a((p_147794_2_ + 1) + d5, (p_147794_3_ + 0) - d5, p_147794_4_ + d6, d3, d4);
/* 2286 */       tessellator.func_78374_a((p_147794_2_ + 1) + d5, (p_147794_3_ + 1) + d5, p_147794_4_ + d6, d3, d2);
/* 2287 */       tessellator.func_78374_a((p_147794_2_ + 0) - d5, (p_147794_3_ + 1) + d5, p_147794_4_ + d6, d1, d2);
/* 2288 */       tessellator.func_78374_a((p_147794_2_ + 0) - d5, (p_147794_3_ + 0) - d5, p_147794_4_ + d6, d1, d4);
/*      */     } 
/* 2290 */     if (i == 2) {
/* 2291 */       tessellator.func_78374_a((p_147794_2_ + 1) + d5, (p_147794_3_ + 1) + d5, (p_147794_4_ + 1) - d6, d1, d2);
/* 2292 */       tessellator.func_78374_a((p_147794_2_ + 1) + d5, (p_147794_3_ + 0) - d5, (p_147794_4_ + 1) - d6, d1, d4);
/* 2293 */       tessellator.func_78374_a((p_147794_2_ + 0) - d5, (p_147794_3_ + 0) - d5, (p_147794_4_ + 1) - d6, d3, d4);
/* 2294 */       tessellator.func_78374_a((p_147794_2_ + 0) - d5, (p_147794_3_ + 1) + d5, (p_147794_4_ + 1) - d6, d3, d2);
/*      */     } 
/*      */     
/* 2297 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147726_j(Block p_147726_1_, int p_147726_2_, int p_147726_3_, int p_147726_4_) {
/* 2301 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 2303 */     IIcon iIcon = func_147777_a(p_147726_1_, 0);
/*      */     
/* 2305 */     if (func_147744_b()) iIcon = this.field_147840_d;
/*      */     
/* 2307 */     tessellator.func_78380_c(p_147726_1_.func_149677_c(this.field_147845_a, p_147726_2_, p_147726_3_, p_147726_4_));
/*      */     
/* 2309 */     int i = p_147726_1_.func_149720_d(this.field_147845_a, p_147726_2_, p_147726_3_, p_147726_4_);
/* 2310 */     float f1 = (i >> 16 & 0xFF) / 255.0F;
/* 2311 */     float f2 = (i >> 8 & 0xFF) / 255.0F;
/* 2312 */     float f3 = (i & 0xFF) / 255.0F;
/*      */     
/* 2314 */     tessellator.func_78386_a(f1, f2, f3);
/*      */ 
/*      */     
/* 2317 */     double d1 = iIcon.func_94209_e();
/* 2318 */     double d2 = iIcon.func_94206_g();
/* 2319 */     double d3 = iIcon.func_94212_f();
/* 2320 */     double d4 = iIcon.func_94210_h();
/*      */     
/* 2322 */     double d5 = 0.05000000074505806D;
/* 2323 */     int j = this.field_147845_a.func_72805_g(p_147726_2_, p_147726_3_, p_147726_4_);
/*      */     
/* 2325 */     if ((j & 0x2) != 0) {
/* 2326 */       tessellator.func_78374_a(p_147726_2_ + d5, (p_147726_3_ + 1), (p_147726_4_ + 1), d1, d2);
/* 2327 */       tessellator.func_78374_a(p_147726_2_ + d5, (p_147726_3_ + 0), (p_147726_4_ + 1), d1, d4);
/* 2328 */       tessellator.func_78374_a(p_147726_2_ + d5, (p_147726_3_ + 0), (p_147726_4_ + 0), d3, d4);
/* 2329 */       tessellator.func_78374_a(p_147726_2_ + d5, (p_147726_3_ + 1), (p_147726_4_ + 0), d3, d2);
/*      */       
/* 2331 */       tessellator.func_78374_a(p_147726_2_ + d5, (p_147726_3_ + 1), (p_147726_4_ + 0), d3, d2);
/* 2332 */       tessellator.func_78374_a(p_147726_2_ + d5, (p_147726_3_ + 0), (p_147726_4_ + 0), d3, d4);
/* 2333 */       tessellator.func_78374_a(p_147726_2_ + d5, (p_147726_3_ + 0), (p_147726_4_ + 1), d1, d4);
/* 2334 */       tessellator.func_78374_a(p_147726_2_ + d5, (p_147726_3_ + 1), (p_147726_4_ + 1), d1, d2);
/*      */     } 
/* 2336 */     if ((j & 0x8) != 0) {
/* 2337 */       tessellator.func_78374_a((p_147726_2_ + 1) - d5, (p_147726_3_ + 0), (p_147726_4_ + 1), d3, d4);
/* 2338 */       tessellator.func_78374_a((p_147726_2_ + 1) - d5, (p_147726_3_ + 1), (p_147726_4_ + 1), d3, d2);
/* 2339 */       tessellator.func_78374_a((p_147726_2_ + 1) - d5, (p_147726_3_ + 1), (p_147726_4_ + 0), d1, d2);
/* 2340 */       tessellator.func_78374_a((p_147726_2_ + 1) - d5, (p_147726_3_ + 0), (p_147726_4_ + 0), d1, d4);
/*      */       
/* 2342 */       tessellator.func_78374_a((p_147726_2_ + 1) - d5, (p_147726_3_ + 0), (p_147726_4_ + 0), d1, d4);
/* 2343 */       tessellator.func_78374_a((p_147726_2_ + 1) - d5, (p_147726_3_ + 1), (p_147726_4_ + 0), d1, d2);
/* 2344 */       tessellator.func_78374_a((p_147726_2_ + 1) - d5, (p_147726_3_ + 1), (p_147726_4_ + 1), d3, d2);
/* 2345 */       tessellator.func_78374_a((p_147726_2_ + 1) - d5, (p_147726_3_ + 0), (p_147726_4_ + 1), d3, d4);
/*      */     } 
/* 2347 */     if ((j & 0x4) != 0) {
/* 2348 */       tessellator.func_78374_a((p_147726_2_ + 1), (p_147726_3_ + 0), p_147726_4_ + d5, d3, d4);
/* 2349 */       tessellator.func_78374_a((p_147726_2_ + 1), (p_147726_3_ + 1), p_147726_4_ + d5, d3, d2);
/* 2350 */       tessellator.func_78374_a((p_147726_2_ + 0), (p_147726_3_ + 1), p_147726_4_ + d5, d1, d2);
/* 2351 */       tessellator.func_78374_a((p_147726_2_ + 0), (p_147726_3_ + 0), p_147726_4_ + d5, d1, d4);
/*      */       
/* 2353 */       tessellator.func_78374_a((p_147726_2_ + 0), (p_147726_3_ + 0), p_147726_4_ + d5, d1, d4);
/* 2354 */       tessellator.func_78374_a((p_147726_2_ + 0), (p_147726_3_ + 1), p_147726_4_ + d5, d1, d2);
/* 2355 */       tessellator.func_78374_a((p_147726_2_ + 1), (p_147726_3_ + 1), p_147726_4_ + d5, d3, d2);
/* 2356 */       tessellator.func_78374_a((p_147726_2_ + 1), (p_147726_3_ + 0), p_147726_4_ + d5, d3, d4);
/*      */     } 
/* 2358 */     if ((j & 0x1) != 0) {
/* 2359 */       tessellator.func_78374_a((p_147726_2_ + 1), (p_147726_3_ + 1), (p_147726_4_ + 1) - d5, d1, d2);
/* 2360 */       tessellator.func_78374_a((p_147726_2_ + 1), (p_147726_3_ + 0), (p_147726_4_ + 1) - d5, d1, d4);
/* 2361 */       tessellator.func_78374_a((p_147726_2_ + 0), (p_147726_3_ + 0), (p_147726_4_ + 1) - d5, d3, d4);
/* 2362 */       tessellator.func_78374_a((p_147726_2_ + 0), (p_147726_3_ + 1), (p_147726_4_ + 1) - d5, d3, d2);
/*      */       
/* 2364 */       tessellator.func_78374_a((p_147726_2_ + 0), (p_147726_3_ + 1), (p_147726_4_ + 1) - d5, d3, d2);
/* 2365 */       tessellator.func_78374_a((p_147726_2_ + 0), (p_147726_3_ + 0), (p_147726_4_ + 1) - d5, d3, d4);
/* 2366 */       tessellator.func_78374_a((p_147726_2_ + 1), (p_147726_3_ + 0), (p_147726_4_ + 1) - d5, d1, d4);
/* 2367 */       tessellator.func_78374_a((p_147726_2_ + 1), (p_147726_3_ + 1), (p_147726_4_ + 1) - d5, d1, d2);
/*      */     } 
/* 2369 */     if (this.field_147845_a.func_147439_a(p_147726_2_, p_147726_3_ + 1, p_147726_4_).func_149637_q()) {
/* 2370 */       tessellator.func_78374_a((p_147726_2_ + 1), (p_147726_3_ + 1) - d5, (p_147726_4_ + 0), d1, d2);
/* 2371 */       tessellator.func_78374_a((p_147726_2_ + 1), (p_147726_3_ + 1) - d5, (p_147726_4_ + 1), d1, d4);
/* 2372 */       tessellator.func_78374_a((p_147726_2_ + 0), (p_147726_3_ + 1) - d5, (p_147726_4_ + 1), d3, d4);
/* 2373 */       tessellator.func_78374_a((p_147726_2_ + 0), (p_147726_3_ + 1) - d5, (p_147726_4_ + 0), d3, d2);
/*      */     } 
/*      */     
/* 2376 */     return true;
/*      */   }
/*      */   public boolean func_147733_k(Block p_147733_1_, int p_147733_2_, int p_147733_3_, int p_147733_4_) {
/*      */     IIcon iIcon1, iIcon2;
/* 2380 */     int i = this.field_147845_a.func_72800_K();
/* 2381 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 2383 */     tessellator.func_78380_c(p_147733_1_.func_149677_c(this.field_147845_a, p_147733_2_, p_147733_3_, p_147733_4_));
/* 2384 */     int j = p_147733_1_.func_149720_d(this.field_147845_a, p_147733_2_, p_147733_3_, p_147733_4_);
/* 2385 */     float f1 = (j >> 16 & 0xFF) / 255.0F;
/* 2386 */     float f2 = (j >> 8 & 0xFF) / 255.0F;
/* 2387 */     float f3 = (j & 0xFF) / 255.0F;
/*      */     
/* 2389 */     if (EntityRenderer.field_78517_a) {
/* 2390 */       float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
/* 2391 */       float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
/* 2392 */       float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
/*      */       
/* 2394 */       f1 = f4;
/* 2395 */       f2 = f5;
/* 2396 */       f3 = f6;
/*      */     } 
/* 2398 */     tessellator.func_78386_a(f1, f2, f3);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2403 */     boolean bool1 = p_147733_1_ instanceof BlockStainedGlassPane;
/* 2404 */     if (func_147744_b()) {
/* 2405 */       iIcon1 = this.field_147840_d;
/* 2406 */       iIcon2 = this.field_147840_d;
/*      */     } else {
/* 2408 */       int k = this.field_147845_a.func_72805_g(p_147733_2_, p_147733_3_, p_147733_4_);
/* 2409 */       iIcon1 = func_147787_a(p_147733_1_, 0, k);
/* 2410 */       iIcon2 = bool1 ? ((BlockStainedGlassPane)p_147733_1_).func_150104_b(k) : ((BlockPane)p_147733_1_).func_150097_e();
/*      */     } 
/*      */     
/* 2413 */     double d1 = iIcon1.func_94209_e();
/* 2414 */     double d2 = iIcon1.func_94214_a(7.0D);
/* 2415 */     double d3 = iIcon1.func_94214_a(9.0D);
/* 2416 */     double d4 = iIcon1.func_94212_f();
/* 2417 */     double d5 = iIcon1.func_94206_g();
/* 2418 */     double d6 = iIcon1.func_94210_h();
/*      */     
/* 2420 */     double d7 = iIcon2.func_94214_a(7.0D);
/* 2421 */     double d8 = iIcon2.func_94214_a(9.0D);
/* 2422 */     double d9 = iIcon2.func_94206_g();
/* 2423 */     double d10 = iIcon2.func_94210_h();
/* 2424 */     double d11 = iIcon2.func_94207_b(7.0D);
/* 2425 */     double d12 = iIcon2.func_94207_b(9.0D);
/*      */     
/* 2427 */     double d13 = p_147733_2_;
/* 2428 */     double d14 = (p_147733_2_ + 1);
/* 2429 */     double d15 = p_147733_4_;
/* 2430 */     double d16 = (p_147733_4_ + 1);
/* 2431 */     double d17 = p_147733_2_ + 0.5D - 0.0625D;
/* 2432 */     double d18 = p_147733_2_ + 0.5D + 0.0625D;
/* 2433 */     double d19 = p_147733_4_ + 0.5D - 0.0625D;
/* 2434 */     double d20 = p_147733_4_ + 0.5D + 0.0625D;
/*      */     
/* 2436 */     boolean bool2 = bool1 ? ((BlockStainedGlassPane)p_147733_1_).func_150098_a(this.field_147845_a.func_147439_a(p_147733_2_, p_147733_3_, p_147733_4_ - 1)) : ((BlockPane)p_147733_1_).func_150098_a(this.field_147845_a.func_147439_a(p_147733_2_, p_147733_3_, p_147733_4_ - 1));
/* 2437 */     boolean bool3 = bool1 ? ((BlockStainedGlassPane)p_147733_1_).func_150098_a(this.field_147845_a.func_147439_a(p_147733_2_, p_147733_3_, p_147733_4_ + 1)) : ((BlockPane)p_147733_1_).func_150098_a(this.field_147845_a.func_147439_a(p_147733_2_, p_147733_3_, p_147733_4_ + 1));
/* 2438 */     boolean bool4 = bool1 ? ((BlockStainedGlassPane)p_147733_1_).func_150098_a(this.field_147845_a.func_147439_a(p_147733_2_ - 1, p_147733_3_, p_147733_4_)) : ((BlockPane)p_147733_1_).func_150098_a(this.field_147845_a.func_147439_a(p_147733_2_ - 1, p_147733_3_, p_147733_4_));
/* 2439 */     boolean bool5 = bool1 ? ((BlockStainedGlassPane)p_147733_1_).func_150098_a(this.field_147845_a.func_147439_a(p_147733_2_ + 1, p_147733_3_, p_147733_4_)) : ((BlockPane)p_147733_1_).func_150098_a(this.field_147845_a.func_147439_a(p_147733_2_ + 1, p_147733_3_, p_147733_4_));
/*      */     
/* 2441 */     double d21 = 0.001D;
/* 2442 */     double d22 = 0.999D;
/* 2443 */     double d23 = 0.001D;
/*      */     
/* 2445 */     boolean bool = (!bool2 && !bool3 && !bool4 && !bool5) ? true : false;
/*      */     
/* 2447 */     if (bool4 || bool) {
/* 2448 */       if (bool4 && bool5) {
/* 2449 */         if (!bool2) {
/* 2450 */           tessellator.func_78374_a(d14, p_147733_3_ + 0.999D, d19, d4, d5);
/* 2451 */           tessellator.func_78374_a(d14, p_147733_3_ + 0.001D, d19, d4, d6);
/* 2452 */           tessellator.func_78374_a(d13, p_147733_3_ + 0.001D, d19, d1, d6);
/* 2453 */           tessellator.func_78374_a(d13, p_147733_3_ + 0.999D, d19, d1, d5);
/*      */         } else {
/* 2455 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d19, d2, d5);
/* 2456 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d19, d2, d6);
/* 2457 */           tessellator.func_78374_a(d13, p_147733_3_ + 0.001D, d19, d1, d6);
/* 2458 */           tessellator.func_78374_a(d13, p_147733_3_ + 0.999D, d19, d1, d5);
/*      */           
/* 2460 */           tessellator.func_78374_a(d14, p_147733_3_ + 0.999D, d19, d4, d5);
/* 2461 */           tessellator.func_78374_a(d14, p_147733_3_ + 0.001D, d19, d4, d6);
/* 2462 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d19, d3, d6);
/* 2463 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d19, d3, d5);
/*      */         } 
/* 2465 */         if (!bool3) {
/* 2466 */           tessellator.func_78374_a(d13, p_147733_3_ + 0.999D, d20, d1, d5);
/* 2467 */           tessellator.func_78374_a(d13, p_147733_3_ + 0.001D, d20, d1, d6);
/* 2468 */           tessellator.func_78374_a(d14, p_147733_3_ + 0.001D, d20, d4, d6);
/* 2469 */           tessellator.func_78374_a(d14, p_147733_3_ + 0.999D, d20, d4, d5);
/*      */         } else {
/* 2471 */           tessellator.func_78374_a(d13, p_147733_3_ + 0.999D, d20, d1, d5);
/* 2472 */           tessellator.func_78374_a(d13, p_147733_3_ + 0.001D, d20, d1, d6);
/* 2473 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d20, d2, d6);
/* 2474 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d20, d2, d5);
/*      */           
/* 2476 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d20, d3, d5);
/* 2477 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d20, d3, d6);
/* 2478 */           tessellator.func_78374_a(d14, p_147733_3_ + 0.001D, d20, d4, d6);
/* 2479 */           tessellator.func_78374_a(d14, p_147733_3_ + 0.999D, d20, d4, d5);
/*      */         } 
/*      */         
/* 2482 */         tessellator.func_78374_a(d13, p_147733_3_ + 0.999D, d20, d8, d9);
/* 2483 */         tessellator.func_78374_a(d14, p_147733_3_ + 0.999D, d20, d8, d10);
/* 2484 */         tessellator.func_78374_a(d14, p_147733_3_ + 0.999D, d19, d7, d10);
/* 2485 */         tessellator.func_78374_a(d13, p_147733_3_ + 0.999D, d19, d7, d9);
/*      */         
/* 2487 */         tessellator.func_78374_a(d14, p_147733_3_ + 0.001D, d20, d7, d10);
/* 2488 */         tessellator.func_78374_a(d13, p_147733_3_ + 0.001D, d20, d7, d9);
/* 2489 */         tessellator.func_78374_a(d13, p_147733_3_ + 0.001D, d19, d8, d9);
/* 2490 */         tessellator.func_78374_a(d14, p_147733_3_ + 0.001D, d19, d8, d10);
/*      */       } else {
/* 2492 */         if (!bool2 && !bool) {
/* 2493 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d19, d3, d5);
/* 2494 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d19, d3, d6);
/* 2495 */           tessellator.func_78374_a(d13, p_147733_3_ + 0.001D, d19, d1, d6);
/* 2496 */           tessellator.func_78374_a(d13, p_147733_3_ + 0.999D, d19, d1, d5);
/*      */         } else {
/* 2498 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d19, d2, d5);
/* 2499 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d19, d2, d6);
/* 2500 */           tessellator.func_78374_a(d13, p_147733_3_ + 0.001D, d19, d1, d6);
/* 2501 */           tessellator.func_78374_a(d13, p_147733_3_ + 0.999D, d19, d1, d5);
/*      */         } 
/* 2503 */         if (!bool3 && !bool) {
/* 2504 */           tessellator.func_78374_a(d13, p_147733_3_ + 0.999D, d20, d1, d5);
/* 2505 */           tessellator.func_78374_a(d13, p_147733_3_ + 0.001D, d20, d1, d6);
/* 2506 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d20, d3, d6);
/* 2507 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d20, d3, d5);
/*      */         } else {
/* 2509 */           tessellator.func_78374_a(d13, p_147733_3_ + 0.999D, d20, d1, d5);
/* 2510 */           tessellator.func_78374_a(d13, p_147733_3_ + 0.001D, d20, d1, d6);
/* 2511 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d20, d2, d6);
/* 2512 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d20, d2, d5);
/*      */         } 
/*      */         
/* 2515 */         tessellator.func_78374_a(d13, p_147733_3_ + 0.999D, d20, d8, d9);
/* 2516 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d20, d8, d11);
/* 2517 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d19, d7, d11);
/* 2518 */         tessellator.func_78374_a(d13, p_147733_3_ + 0.999D, d19, d7, d9);
/*      */         
/* 2520 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d20, d7, d11);
/* 2521 */         tessellator.func_78374_a(d13, p_147733_3_ + 0.001D, d20, d7, d9);
/* 2522 */         tessellator.func_78374_a(d13, p_147733_3_ + 0.001D, d19, d8, d9);
/* 2523 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d19, d8, d11);
/*      */       } 
/* 2525 */     } else if (!bool2 && !bool3) {
/* 2526 */       tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d19, d2, d5);
/* 2527 */       tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d19, d2, d6);
/* 2528 */       tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d20, d3, d6);
/* 2529 */       tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d20, d3, d5);
/*      */     } 
/*      */     
/* 2532 */     if ((bool5 || bool) && !bool4) {
/* 2533 */       if (!bool3 && !bool) {
/* 2534 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d20, d2, d5);
/* 2535 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d20, d2, d6);
/* 2536 */         tessellator.func_78374_a(d14, p_147733_3_ + 0.001D, d20, d4, d6);
/* 2537 */         tessellator.func_78374_a(d14, p_147733_3_ + 0.999D, d20, d4, d5);
/*      */       } else {
/* 2539 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d20, d3, d5);
/* 2540 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d20, d3, d6);
/* 2541 */         tessellator.func_78374_a(d14, p_147733_3_ + 0.001D, d20, d4, d6);
/* 2542 */         tessellator.func_78374_a(d14, p_147733_3_ + 0.999D, d20, d4, d5);
/*      */       } 
/* 2544 */       if (!bool2 && !bool) {
/* 2545 */         tessellator.func_78374_a(d14, p_147733_3_ + 0.999D, d19, d4, d5);
/* 2546 */         tessellator.func_78374_a(d14, p_147733_3_ + 0.001D, d19, d4, d6);
/* 2547 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d19, d2, d6);
/* 2548 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d19, d2, d5);
/*      */       } else {
/* 2550 */         tessellator.func_78374_a(d14, p_147733_3_ + 0.999D, d19, d4, d5);
/* 2551 */         tessellator.func_78374_a(d14, p_147733_3_ + 0.001D, d19, d4, d6);
/* 2552 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d19, d3, d6);
/* 2553 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d19, d3, d5);
/*      */       } 
/*      */       
/* 2556 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d20, d8, d12);
/* 2557 */       tessellator.func_78374_a(d14, p_147733_3_ + 0.999D, d20, d8, d9);
/* 2558 */       tessellator.func_78374_a(d14, p_147733_3_ + 0.999D, d19, d7, d9);
/* 2559 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d19, d7, d12);
/*      */       
/* 2561 */       tessellator.func_78374_a(d14, p_147733_3_ + 0.001D, d20, d7, d10);
/* 2562 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d20, d7, d12);
/* 2563 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d19, d8, d12);
/* 2564 */       tessellator.func_78374_a(d14, p_147733_3_ + 0.001D, d19, d8, d10);
/* 2565 */     } else if (!bool5 && !bool2 && !bool3) {
/* 2566 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d20, d2, d5);
/* 2567 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d20, d2, d6);
/* 2568 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d19, d3, d6);
/* 2569 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d19, d3, d5);
/*      */     } 
/*      */     
/* 2572 */     if (bool2 || bool) {
/* 2573 */       if (bool2 && bool3) {
/* 2574 */         if (!bool4) {
/* 2575 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d15, d1, d5);
/* 2576 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d15, d1, d6);
/* 2577 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d16, d4, d6);
/* 2578 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d16, d4, d5);
/*      */         } else {
/* 2580 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d15, d1, d5);
/* 2581 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d15, d1, d6);
/* 2582 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d19, d2, d6);
/* 2583 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d19, d2, d5);
/*      */           
/* 2585 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d20, d3, d5);
/* 2586 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d20, d3, d6);
/* 2587 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d16, d4, d6);
/* 2588 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d16, d4, d5);
/*      */         } 
/* 2590 */         if (!bool5) {
/* 2591 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d16, d4, d5);
/* 2592 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d16, d4, d6);
/* 2593 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d15, d1, d6);
/* 2594 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d15, d1, d5);
/*      */         } else {
/* 2596 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d19, d2, d5);
/* 2597 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d19, d2, d6);
/* 2598 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d15, d1, d6);
/* 2599 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d15, d1, d5);
/*      */           
/* 2601 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d16, d4, d5);
/* 2602 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d16, d4, d6);
/* 2603 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d20, d3, d6);
/* 2604 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d20, d3, d5);
/*      */         } 
/*      */         
/* 2607 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d15, d8, d9);
/* 2608 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d15, d7, d9);
/* 2609 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d16, d7, d10);
/* 2610 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d16, d8, d10);
/*      */         
/* 2612 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d15, d7, d9);
/* 2613 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d15, d8, d9);
/* 2614 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d16, d8, d10);
/* 2615 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d16, d7, d10);
/*      */       } else {
/* 2617 */         if (!bool4 && !bool) {
/* 2618 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d15, d1, d5);
/* 2619 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d15, d1, d6);
/* 2620 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d20, d3, d6);
/* 2621 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d20, d3, d5);
/*      */         } else {
/* 2623 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d15, d1, d5);
/* 2624 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d15, d1, d6);
/* 2625 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d19, d2, d6);
/* 2626 */           tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d19, d2, d5);
/*      */         } 
/* 2628 */         if (!bool5 && !bool) {
/* 2629 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d20, d3, d5);
/* 2630 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d20, d3, d6);
/* 2631 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d15, d1, d6);
/* 2632 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d15, d1, d5);
/*      */         } else {
/* 2634 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d19, d2, d5);
/* 2635 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d19, d2, d6);
/* 2636 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d15, d1, d6);
/* 2637 */           tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d15, d1, d5);
/*      */         } 
/*      */         
/* 2640 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d15, d8, d9);
/* 2641 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d15, d7, d9);
/* 2642 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d19, d7, d11);
/* 2643 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d19, d8, d11);
/*      */         
/* 2645 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d15, d7, d9);
/* 2646 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d15, d8, d9);
/* 2647 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d19, d8, d11);
/* 2648 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d19, d7, d11);
/*      */       } 
/* 2650 */     } else if (!bool5 && !bool4) {
/* 2651 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d19, d3, d5);
/* 2652 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d19, d3, d6);
/* 2653 */       tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d19, d2, d6);
/* 2654 */       tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d19, d2, d5);
/*      */     } 
/*      */     
/* 2657 */     if ((bool3 || bool) && !bool2) {
/* 2658 */       if (!bool4 && !bool) {
/* 2659 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d19, d2, d5);
/* 2660 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d19, d2, d6);
/* 2661 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d16, d4, d6);
/* 2662 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d16, d4, d5);
/*      */       } else {
/* 2664 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d20, d3, d5);
/* 2665 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d20, d3, d6);
/* 2666 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d16, d4, d6);
/* 2667 */         tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d16, d4, d5);
/*      */       } 
/* 2669 */       if (!bool5 && !bool) {
/* 2670 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d16, d4, d5);
/* 2671 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d16, d4, d6);
/* 2672 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d19, d2, d6);
/* 2673 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d19, d2, d5);
/*      */       } else {
/* 2675 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d16, d4, d5);
/* 2676 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d16, d4, d6);
/* 2677 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d20, d3, d6);
/* 2678 */         tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d20, d3, d5);
/*      */       } 
/*      */       
/* 2681 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d20, d8, d12);
/* 2682 */       tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d20, d7, d12);
/* 2683 */       tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d16, d7, d10);
/* 2684 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d16, d8, d10);
/*      */       
/* 2686 */       tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d20, d7, d12);
/* 2687 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d20, d8, d12);
/* 2688 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d16, d8, d10);
/* 2689 */       tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d16, d7, d10);
/* 2690 */     } else if (!bool3 && !bool5 && !bool4) {
/* 2691 */       tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d20, d2, d5);
/* 2692 */       tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d20, d2, d6);
/* 2693 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d20, d3, d6);
/* 2694 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d20, d3, d5);
/*      */     } 
/*      */     
/* 2697 */     tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d19, d8, d11);
/* 2698 */     tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d19, d7, d11);
/* 2699 */     tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d20, d7, d12);
/* 2700 */     tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d20, d8, d12);
/*      */     
/* 2702 */     tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d19, d7, d11);
/* 2703 */     tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d19, d8, d11);
/* 2704 */     tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d20, d8, d12);
/* 2705 */     tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d20, d7, d12);
/*      */     
/* 2707 */     if (bool) {
/* 2708 */       tessellator.func_78374_a(d13, p_147733_3_ + 0.999D, d19, d2, d5);
/* 2709 */       tessellator.func_78374_a(d13, p_147733_3_ + 0.001D, d19, d2, d6);
/* 2710 */       tessellator.func_78374_a(d13, p_147733_3_ + 0.001D, d20, d3, d6);
/* 2711 */       tessellator.func_78374_a(d13, p_147733_3_ + 0.999D, d20, d3, d5);
/*      */       
/* 2713 */       tessellator.func_78374_a(d14, p_147733_3_ + 0.999D, d20, d2, d5);
/* 2714 */       tessellator.func_78374_a(d14, p_147733_3_ + 0.001D, d20, d2, d6);
/* 2715 */       tessellator.func_78374_a(d14, p_147733_3_ + 0.001D, d19, d3, d6);
/* 2716 */       tessellator.func_78374_a(d14, p_147733_3_ + 0.999D, d19, d3, d5);
/*      */       
/* 2718 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d15, d3, d5);
/* 2719 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d15, d3, d6);
/* 2720 */       tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d15, d2, d6);
/* 2721 */       tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d15, d2, d5);
/*      */       
/* 2723 */       tessellator.func_78374_a(d17, p_147733_3_ + 0.999D, d16, d2, d5);
/* 2724 */       tessellator.func_78374_a(d17, p_147733_3_ + 0.001D, d16, d2, d6);
/* 2725 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.001D, d16, d3, d6);
/* 2726 */       tessellator.func_78374_a(d18, p_147733_3_ + 0.999D, d16, d3, d5);
/*      */     } 
/* 2728 */     return true;
/*      */   }
/*      */   public boolean func_147767_a(BlockPane p_147767_1_, int p_147767_2_, int p_147767_3_, int p_147767_4_) {
/*      */     IIcon iIcon1, iIcon2;
/* 2732 */     int i = this.field_147845_a.func_72800_K();
/* 2733 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 2735 */     tessellator.func_78380_c(p_147767_1_.func_149677_c(this.field_147845_a, p_147767_2_, p_147767_3_, p_147767_4_));
/* 2736 */     int j = p_147767_1_.func_149720_d(this.field_147845_a, p_147767_2_, p_147767_3_, p_147767_4_);
/* 2737 */     float f1 = (j >> 16 & 0xFF) / 255.0F;
/* 2738 */     float f2 = (j >> 8 & 0xFF) / 255.0F;
/* 2739 */     float f3 = (j & 0xFF) / 255.0F;
/*      */     
/* 2741 */     if (EntityRenderer.field_78517_a) {
/* 2742 */       float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
/* 2743 */       float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
/* 2744 */       float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
/*      */       
/* 2746 */       f1 = f4;
/* 2747 */       f2 = f5;
/* 2748 */       f3 = f6;
/*      */     } 
/* 2750 */     tessellator.func_78386_a(f1, f2, f3);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2755 */     if (func_147744_b()) {
/* 2756 */       iIcon1 = this.field_147840_d;
/* 2757 */       iIcon2 = this.field_147840_d;
/*      */     } else {
/* 2759 */       int k = this.field_147845_a.func_72805_g(p_147767_2_, p_147767_3_, p_147767_4_);
/* 2760 */       iIcon1 = func_147787_a((Block)p_147767_1_, 0, k);
/* 2761 */       iIcon2 = p_147767_1_.func_150097_e();
/*      */     } 
/*      */     
/* 2764 */     double d1 = iIcon1.func_94209_e();
/* 2765 */     double d2 = iIcon1.func_94214_a(8.0D);
/* 2766 */     double d3 = iIcon1.func_94212_f();
/* 2767 */     double d4 = iIcon1.func_94206_g();
/* 2768 */     double d5 = iIcon1.func_94210_h();
/*      */     
/* 2770 */     double d6 = iIcon2.func_94214_a(7.0D);
/* 2771 */     double d7 = iIcon2.func_94214_a(9.0D);
/* 2772 */     double d8 = iIcon2.func_94206_g();
/* 2773 */     double d9 = iIcon2.func_94207_b(8.0D);
/* 2774 */     double d10 = iIcon2.func_94210_h();
/*      */     
/* 2776 */     double d11 = p_147767_2_;
/* 2777 */     double d12 = p_147767_2_ + 0.5D;
/* 2778 */     double d13 = (p_147767_2_ + 1);
/* 2779 */     double d14 = p_147767_4_;
/* 2780 */     double d15 = p_147767_4_ + 0.5D;
/* 2781 */     double d16 = (p_147767_4_ + 1);
/* 2782 */     double d17 = p_147767_2_ + 0.5D - 0.0625D;
/* 2783 */     double d18 = p_147767_2_ + 0.5D + 0.0625D;
/* 2784 */     double d19 = p_147767_4_ + 0.5D - 0.0625D;
/* 2785 */     double d20 = p_147767_4_ + 0.5D + 0.0625D;
/*      */     
/* 2787 */     boolean bool1 = p_147767_1_.func_150098_a(this.field_147845_a.func_147439_a(p_147767_2_, p_147767_3_, p_147767_4_ - 1));
/* 2788 */     boolean bool2 = p_147767_1_.func_150098_a(this.field_147845_a.func_147439_a(p_147767_2_, p_147767_3_, p_147767_4_ + 1));
/* 2789 */     boolean bool3 = p_147767_1_.func_150098_a(this.field_147845_a.func_147439_a(p_147767_2_ - 1, p_147767_3_, p_147767_4_));
/* 2790 */     boolean bool4 = p_147767_1_.func_150098_a(this.field_147845_a.func_147439_a(p_147767_2_ + 1, p_147767_3_, p_147767_4_));
/*      */     
/* 2792 */     boolean bool5 = p_147767_1_.func_149646_a(this.field_147845_a, p_147767_2_, p_147767_3_ + 1, p_147767_4_, 1);
/* 2793 */     boolean bool6 = p_147767_1_.func_149646_a(this.field_147845_a, p_147767_2_, p_147767_3_ - 1, p_147767_4_, 0);
/*      */     
/* 2795 */     double d21 = 0.01D;
/* 2796 */     double d22 = 0.005D;
/*      */     
/* 2798 */     if ((bool3 && bool4) || (!bool3 && !bool4 && !bool1 && !bool2)) {
/* 2799 */       tessellator.func_78374_a(d11, (p_147767_3_ + 1), d15, d1, d4);
/* 2800 */       tessellator.func_78374_a(d11, (p_147767_3_ + 0), d15, d1, d5);
/* 2801 */       tessellator.func_78374_a(d13, (p_147767_3_ + 0), d15, d3, d5);
/* 2802 */       tessellator.func_78374_a(d13, (p_147767_3_ + 1), d15, d3, d4);
/*      */       
/* 2804 */       tessellator.func_78374_a(d13, (p_147767_3_ + 1), d15, d1, d4);
/* 2805 */       tessellator.func_78374_a(d13, (p_147767_3_ + 0), d15, d1, d5);
/* 2806 */       tessellator.func_78374_a(d11, (p_147767_3_ + 0), d15, d3, d5);
/* 2807 */       tessellator.func_78374_a(d11, (p_147767_3_ + 1), d15, d3, d4);
/*      */       
/* 2809 */       if (bool5) {
/*      */         
/* 2811 */         tessellator.func_78374_a(d11, (p_147767_3_ + 1) + 0.01D, d20, d7, d10);
/* 2812 */         tessellator.func_78374_a(d13, (p_147767_3_ + 1) + 0.01D, d20, d7, d8);
/* 2813 */         tessellator.func_78374_a(d13, (p_147767_3_ + 1) + 0.01D, d19, d6, d8);
/* 2814 */         tessellator.func_78374_a(d11, (p_147767_3_ + 1) + 0.01D, d19, d6, d10);
/*      */         
/* 2816 */         tessellator.func_78374_a(d13, (p_147767_3_ + 1) + 0.01D, d20, d7, d10);
/* 2817 */         tessellator.func_78374_a(d11, (p_147767_3_ + 1) + 0.01D, d20, d7, d8);
/* 2818 */         tessellator.func_78374_a(d11, (p_147767_3_ + 1) + 0.01D, d19, d6, d8);
/* 2819 */         tessellator.func_78374_a(d13, (p_147767_3_ + 1) + 0.01D, d19, d6, d10);
/*      */       } else {
/* 2821 */         if (p_147767_3_ < i - 1 && this.field_147845_a.func_147437_c(p_147767_2_ - 1, p_147767_3_ + 1, p_147767_4_)) {
/* 2822 */           tessellator.func_78374_a(d11, (p_147767_3_ + 1) + 0.01D, d20, d7, d9);
/* 2823 */           tessellator.func_78374_a(d12, (p_147767_3_ + 1) + 0.01D, d20, d7, d10);
/* 2824 */           tessellator.func_78374_a(d12, (p_147767_3_ + 1) + 0.01D, d19, d6, d10);
/* 2825 */           tessellator.func_78374_a(d11, (p_147767_3_ + 1) + 0.01D, d19, d6, d9);
/*      */           
/* 2827 */           tessellator.func_78374_a(d12, (p_147767_3_ + 1) + 0.01D, d20, d7, d9);
/* 2828 */           tessellator.func_78374_a(d11, (p_147767_3_ + 1) + 0.01D, d20, d7, d10);
/* 2829 */           tessellator.func_78374_a(d11, (p_147767_3_ + 1) + 0.01D, d19, d6, d10);
/* 2830 */           tessellator.func_78374_a(d12, (p_147767_3_ + 1) + 0.01D, d19, d6, d9);
/*      */         } 
/* 2832 */         if (p_147767_3_ < i - 1 && this.field_147845_a.func_147437_c(p_147767_2_ + 1, p_147767_3_ + 1, p_147767_4_)) {
/* 2833 */           tessellator.func_78374_a(d12, (p_147767_3_ + 1) + 0.01D, d20, d7, d8);
/* 2834 */           tessellator.func_78374_a(d13, (p_147767_3_ + 1) + 0.01D, d20, d7, d9);
/* 2835 */           tessellator.func_78374_a(d13, (p_147767_3_ + 1) + 0.01D, d19, d6, d9);
/* 2836 */           tessellator.func_78374_a(d12, (p_147767_3_ + 1) + 0.01D, d19, d6, d8);
/*      */           
/* 2838 */           tessellator.func_78374_a(d13, (p_147767_3_ + 1) + 0.01D, d20, d7, d8);
/* 2839 */           tessellator.func_78374_a(d12, (p_147767_3_ + 1) + 0.01D, d20, d7, d9);
/* 2840 */           tessellator.func_78374_a(d12, (p_147767_3_ + 1) + 0.01D, d19, d6, d9);
/* 2841 */           tessellator.func_78374_a(d13, (p_147767_3_ + 1) + 0.01D, d19, d6, d8);
/*      */         } 
/*      */       } 
/* 2844 */       if (bool6) {
/*      */         
/* 2846 */         tessellator.func_78374_a(d11, p_147767_3_ - 0.01D, d20, d7, d10);
/* 2847 */         tessellator.func_78374_a(d13, p_147767_3_ - 0.01D, d20, d7, d8);
/* 2848 */         tessellator.func_78374_a(d13, p_147767_3_ - 0.01D, d19, d6, d8);
/* 2849 */         tessellator.func_78374_a(d11, p_147767_3_ - 0.01D, d19, d6, d10);
/*      */         
/* 2851 */         tessellator.func_78374_a(d13, p_147767_3_ - 0.01D, d20, d7, d10);
/* 2852 */         tessellator.func_78374_a(d11, p_147767_3_ - 0.01D, d20, d7, d8);
/* 2853 */         tessellator.func_78374_a(d11, p_147767_3_ - 0.01D, d19, d6, d8);
/* 2854 */         tessellator.func_78374_a(d13, p_147767_3_ - 0.01D, d19, d6, d10);
/*      */       } else {
/* 2856 */         if (p_147767_3_ > 1 && this.field_147845_a.func_147437_c(p_147767_2_ - 1, p_147767_3_ - 1, p_147767_4_)) {
/* 2857 */           tessellator.func_78374_a(d11, p_147767_3_ - 0.01D, d20, d7, d9);
/* 2858 */           tessellator.func_78374_a(d12, p_147767_3_ - 0.01D, d20, d7, d10);
/* 2859 */           tessellator.func_78374_a(d12, p_147767_3_ - 0.01D, d19, d6, d10);
/* 2860 */           tessellator.func_78374_a(d11, p_147767_3_ - 0.01D, d19, d6, d9);
/*      */           
/* 2862 */           tessellator.func_78374_a(d12, p_147767_3_ - 0.01D, d20, d7, d9);
/* 2863 */           tessellator.func_78374_a(d11, p_147767_3_ - 0.01D, d20, d7, d10);
/* 2864 */           tessellator.func_78374_a(d11, p_147767_3_ - 0.01D, d19, d6, d10);
/* 2865 */           tessellator.func_78374_a(d12, p_147767_3_ - 0.01D, d19, d6, d9);
/*      */         } 
/* 2867 */         if (p_147767_3_ > 1 && this.field_147845_a.func_147437_c(p_147767_2_ + 1, p_147767_3_ - 1, p_147767_4_)) {
/* 2868 */           tessellator.func_78374_a(d12, p_147767_3_ - 0.01D, d20, d7, d8);
/* 2869 */           tessellator.func_78374_a(d13, p_147767_3_ - 0.01D, d20, d7, d9);
/* 2870 */           tessellator.func_78374_a(d13, p_147767_3_ - 0.01D, d19, d6, d9);
/* 2871 */           tessellator.func_78374_a(d12, p_147767_3_ - 0.01D, d19, d6, d8);
/*      */           
/* 2873 */           tessellator.func_78374_a(d13, p_147767_3_ - 0.01D, d20, d7, d8);
/* 2874 */           tessellator.func_78374_a(d12, p_147767_3_ - 0.01D, d20, d7, d9);
/* 2875 */           tessellator.func_78374_a(d12, p_147767_3_ - 0.01D, d19, d6, d9);
/* 2876 */           tessellator.func_78374_a(d13, p_147767_3_ - 0.01D, d19, d6, d8);
/*      */         }
/*      */       
/*      */       } 
/* 2880 */     } else if (bool3 && !bool4) {
/*      */       
/* 2882 */       tessellator.func_78374_a(d11, (p_147767_3_ + 1), d15, d1, d4);
/* 2883 */       tessellator.func_78374_a(d11, (p_147767_3_ + 0), d15, d1, d5);
/* 2884 */       tessellator.func_78374_a(d12, (p_147767_3_ + 0), d15, d2, d5);
/* 2885 */       tessellator.func_78374_a(d12, (p_147767_3_ + 1), d15, d2, d4);
/*      */       
/* 2887 */       tessellator.func_78374_a(d12, (p_147767_3_ + 1), d15, d1, d4);
/* 2888 */       tessellator.func_78374_a(d12, (p_147767_3_ + 0), d15, d1, d5);
/* 2889 */       tessellator.func_78374_a(d11, (p_147767_3_ + 0), d15, d2, d5);
/* 2890 */       tessellator.func_78374_a(d11, (p_147767_3_ + 1), d15, d2, d4);
/*      */ 
/*      */       
/* 2893 */       if (!bool2 && !bool1) {
/* 2894 */         tessellator.func_78374_a(d12, (p_147767_3_ + 1), d20, d6, d8);
/* 2895 */         tessellator.func_78374_a(d12, (p_147767_3_ + 0), d20, d6, d10);
/* 2896 */         tessellator.func_78374_a(d12, (p_147767_3_ + 0), d19, d7, d10);
/* 2897 */         tessellator.func_78374_a(d12, (p_147767_3_ + 1), d19, d7, d8);
/*      */         
/* 2899 */         tessellator.func_78374_a(d12, (p_147767_3_ + 1), d19, d6, d8);
/* 2900 */         tessellator.func_78374_a(d12, (p_147767_3_ + 0), d19, d6, d10);
/* 2901 */         tessellator.func_78374_a(d12, (p_147767_3_ + 0), d20, d7, d10);
/* 2902 */         tessellator.func_78374_a(d12, (p_147767_3_ + 1), d20, d7, d8);
/*      */       } 
/*      */       
/* 2905 */       if (bool5 || (p_147767_3_ < i - 1 && this.field_147845_a.func_147437_c(p_147767_2_ - 1, p_147767_3_ + 1, p_147767_4_))) {
/*      */         
/* 2907 */         tessellator.func_78374_a(d11, (p_147767_3_ + 1) + 0.01D, d20, d7, d9);
/* 2908 */         tessellator.func_78374_a(d12, (p_147767_3_ + 1) + 0.01D, d20, d7, d10);
/* 2909 */         tessellator.func_78374_a(d12, (p_147767_3_ + 1) + 0.01D, d19, d6, d10);
/* 2910 */         tessellator.func_78374_a(d11, (p_147767_3_ + 1) + 0.01D, d19, d6, d9);
/*      */         
/* 2912 */         tessellator.func_78374_a(d12, (p_147767_3_ + 1) + 0.01D, d20, d7, d9);
/* 2913 */         tessellator.func_78374_a(d11, (p_147767_3_ + 1) + 0.01D, d20, d7, d10);
/* 2914 */         tessellator.func_78374_a(d11, (p_147767_3_ + 1) + 0.01D, d19, d6, d10);
/* 2915 */         tessellator.func_78374_a(d12, (p_147767_3_ + 1) + 0.01D, d19, d6, d9);
/*      */       } 
/* 2917 */       if (bool6 || (p_147767_3_ > 1 && this.field_147845_a.func_147437_c(p_147767_2_ - 1, p_147767_3_ - 1, p_147767_4_)))
/*      */       {
/* 2919 */         tessellator.func_78374_a(d11, p_147767_3_ - 0.01D, d20, d7, d9);
/* 2920 */         tessellator.func_78374_a(d12, p_147767_3_ - 0.01D, d20, d7, d10);
/* 2921 */         tessellator.func_78374_a(d12, p_147767_3_ - 0.01D, d19, d6, d10);
/* 2922 */         tessellator.func_78374_a(d11, p_147767_3_ - 0.01D, d19, d6, d9);
/*      */         
/* 2924 */         tessellator.func_78374_a(d12, p_147767_3_ - 0.01D, d20, d7, d9);
/* 2925 */         tessellator.func_78374_a(d11, p_147767_3_ - 0.01D, d20, d7, d10);
/* 2926 */         tessellator.func_78374_a(d11, p_147767_3_ - 0.01D, d19, d6, d10);
/* 2927 */         tessellator.func_78374_a(d12, p_147767_3_ - 0.01D, d19, d6, d9);
/*      */       }
/*      */     
/* 2930 */     } else if (!bool3 && bool4) {
/*      */       
/* 2932 */       tessellator.func_78374_a(d12, (p_147767_3_ + 1), d15, d2, d4);
/* 2933 */       tessellator.func_78374_a(d12, (p_147767_3_ + 0), d15, d2, d5);
/* 2934 */       tessellator.func_78374_a(d13, (p_147767_3_ + 0), d15, d3, d5);
/* 2935 */       tessellator.func_78374_a(d13, (p_147767_3_ + 1), d15, d3, d4);
/*      */       
/* 2937 */       tessellator.func_78374_a(d13, (p_147767_3_ + 1), d15, d2, d4);
/* 2938 */       tessellator.func_78374_a(d13, (p_147767_3_ + 0), d15, d2, d5);
/* 2939 */       tessellator.func_78374_a(d12, (p_147767_3_ + 0), d15, d3, d5);
/* 2940 */       tessellator.func_78374_a(d12, (p_147767_3_ + 1), d15, d3, d4);
/*      */ 
/*      */       
/* 2943 */       if (!bool2 && !bool1) {
/* 2944 */         tessellator.func_78374_a(d12, (p_147767_3_ + 1), d19, d6, d8);
/* 2945 */         tessellator.func_78374_a(d12, (p_147767_3_ + 0), d19, d6, d10);
/* 2946 */         tessellator.func_78374_a(d12, (p_147767_3_ + 0), d20, d7, d10);
/* 2947 */         tessellator.func_78374_a(d12, (p_147767_3_ + 1), d20, d7, d8);
/*      */         
/* 2949 */         tessellator.func_78374_a(d12, (p_147767_3_ + 1), d20, d6, d8);
/* 2950 */         tessellator.func_78374_a(d12, (p_147767_3_ + 0), d20, d6, d10);
/* 2951 */         tessellator.func_78374_a(d12, (p_147767_3_ + 0), d19, d7, d10);
/* 2952 */         tessellator.func_78374_a(d12, (p_147767_3_ + 1), d19, d7, d8);
/*      */       } 
/*      */       
/* 2955 */       if (bool5 || (p_147767_3_ < i - 1 && this.field_147845_a.func_147437_c(p_147767_2_ + 1, p_147767_3_ + 1, p_147767_4_))) {
/*      */         
/* 2957 */         tessellator.func_78374_a(d12, (p_147767_3_ + 1) + 0.01D, d20, d7, d8);
/* 2958 */         tessellator.func_78374_a(d13, (p_147767_3_ + 1) + 0.01D, d20, d7, d9);
/* 2959 */         tessellator.func_78374_a(d13, (p_147767_3_ + 1) + 0.01D, d19, d6, d9);
/* 2960 */         tessellator.func_78374_a(d12, (p_147767_3_ + 1) + 0.01D, d19, d6, d8);
/*      */         
/* 2962 */         tessellator.func_78374_a(d13, (p_147767_3_ + 1) + 0.01D, d20, d7, d8);
/* 2963 */         tessellator.func_78374_a(d12, (p_147767_3_ + 1) + 0.01D, d20, d7, d9);
/* 2964 */         tessellator.func_78374_a(d12, (p_147767_3_ + 1) + 0.01D, d19, d6, d9);
/* 2965 */         tessellator.func_78374_a(d13, (p_147767_3_ + 1) + 0.01D, d19, d6, d8);
/*      */       } 
/* 2967 */       if (bool6 || (p_147767_3_ > 1 && this.field_147845_a.func_147437_c(p_147767_2_ + 1, p_147767_3_ - 1, p_147767_4_))) {
/*      */         
/* 2969 */         tessellator.func_78374_a(d12, p_147767_3_ - 0.01D, d20, d7, d8);
/* 2970 */         tessellator.func_78374_a(d13, p_147767_3_ - 0.01D, d20, d7, d9);
/* 2971 */         tessellator.func_78374_a(d13, p_147767_3_ - 0.01D, d19, d6, d9);
/* 2972 */         tessellator.func_78374_a(d12, p_147767_3_ - 0.01D, d19, d6, d8);
/*      */         
/* 2974 */         tessellator.func_78374_a(d13, p_147767_3_ - 0.01D, d20, d7, d8);
/* 2975 */         tessellator.func_78374_a(d12, p_147767_3_ - 0.01D, d20, d7, d9);
/* 2976 */         tessellator.func_78374_a(d12, p_147767_3_ - 0.01D, d19, d6, d9);
/* 2977 */         tessellator.func_78374_a(d13, p_147767_3_ - 0.01D, d19, d6, d8);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2982 */     if ((bool1 && bool2) || (!bool3 && !bool4 && !bool1 && !bool2)) {
/*      */       
/* 2984 */       tessellator.func_78374_a(d12, (p_147767_3_ + 1), d16, d1, d4);
/* 2985 */       tessellator.func_78374_a(d12, (p_147767_3_ + 0), d16, d1, d5);
/* 2986 */       tessellator.func_78374_a(d12, (p_147767_3_ + 0), d14, d3, d5);
/* 2987 */       tessellator.func_78374_a(d12, (p_147767_3_ + 1), d14, d3, d4);
/*      */       
/* 2989 */       tessellator.func_78374_a(d12, (p_147767_3_ + 1), d14, d1, d4);
/* 2990 */       tessellator.func_78374_a(d12, (p_147767_3_ + 0), d14, d1, d5);
/* 2991 */       tessellator.func_78374_a(d12, (p_147767_3_ + 0), d16, d3, d5);
/* 2992 */       tessellator.func_78374_a(d12, (p_147767_3_ + 1), d16, d3, d4);
/*      */       
/* 2994 */       if (bool5) {
/*      */         
/* 2996 */         tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d16, d7, d10);
/* 2997 */         tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d14, d7, d8);
/* 2998 */         tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d14, d6, d8);
/* 2999 */         tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d16, d6, d10);
/*      */         
/* 3001 */         tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d14, d7, d10);
/* 3002 */         tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d16, d7, d8);
/* 3003 */         tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d16, d6, d8);
/* 3004 */         tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d14, d6, d10);
/*      */       } else {
/* 3006 */         if (p_147767_3_ < i - 1 && this.field_147845_a.func_147437_c(p_147767_2_, p_147767_3_ + 1, p_147767_4_ - 1)) {
/* 3007 */           tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d14, d7, d8);
/* 3008 */           tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d15, d7, d9);
/* 3009 */           tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d15, d6, d9);
/* 3010 */           tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d14, d6, d8);
/*      */           
/* 3012 */           tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d15, d7, d8);
/* 3013 */           tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d14, d7, d9);
/* 3014 */           tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d14, d6, d9);
/* 3015 */           tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d15, d6, d8);
/*      */         } 
/* 3017 */         if (p_147767_3_ < i - 1 && this.field_147845_a.func_147437_c(p_147767_2_, p_147767_3_ + 1, p_147767_4_ + 1)) {
/* 3018 */           tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d15, d6, d9);
/* 3019 */           tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d16, d6, d10);
/* 3020 */           tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d16, d7, d10);
/* 3021 */           tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d15, d7, d9);
/*      */           
/* 3023 */           tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d16, d6, d9);
/* 3024 */           tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d15, d6, d10);
/* 3025 */           tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d15, d7, d10);
/* 3026 */           tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d16, d7, d9);
/*      */         } 
/*      */       } 
/* 3029 */       if (bool6) {
/*      */         
/* 3031 */         tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d16, d7, d10);
/* 3032 */         tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d14, d7, d8);
/* 3033 */         tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d14, d6, d8);
/* 3034 */         tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d16, d6, d10);
/*      */         
/* 3036 */         tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d14, d7, d10);
/* 3037 */         tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d16, d7, d8);
/* 3038 */         tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d16, d6, d8);
/* 3039 */         tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d14, d6, d10);
/*      */       } else {
/* 3041 */         if (p_147767_3_ > 1 && this.field_147845_a.func_147437_c(p_147767_2_, p_147767_3_ - 1, p_147767_4_ - 1)) {
/*      */           
/* 3043 */           tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d14, d7, d8);
/* 3044 */           tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d15, d7, d9);
/* 3045 */           tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d15, d6, d9);
/* 3046 */           tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d14, d6, d8);
/*      */           
/* 3048 */           tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d15, d7, d8);
/* 3049 */           tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d14, d7, d9);
/* 3050 */           tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d14, d6, d9);
/* 3051 */           tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d15, d6, d8);
/*      */         } 
/* 3053 */         if (p_147767_3_ > 1 && this.field_147845_a.func_147437_c(p_147767_2_, p_147767_3_ - 1, p_147767_4_ + 1))
/*      */         {
/* 3055 */           tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d15, d6, d9);
/* 3056 */           tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d16, d6, d10);
/* 3057 */           tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d16, d7, d10);
/* 3058 */           tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d15, d7, d9);
/*      */           
/* 3060 */           tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d16, d6, d9);
/* 3061 */           tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d15, d6, d10);
/* 3062 */           tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d15, d7, d10);
/* 3063 */           tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d16, d7, d9);
/*      */         }
/*      */       
/*      */       } 
/* 3067 */     } else if (bool1 && !bool2) {
/*      */       
/* 3069 */       tessellator.func_78374_a(d12, (p_147767_3_ + 1), d14, d1, d4);
/* 3070 */       tessellator.func_78374_a(d12, (p_147767_3_ + 0), d14, d1, d5);
/* 3071 */       tessellator.func_78374_a(d12, (p_147767_3_ + 0), d15, d2, d5);
/* 3072 */       tessellator.func_78374_a(d12, (p_147767_3_ + 1), d15, d2, d4);
/*      */       
/* 3074 */       tessellator.func_78374_a(d12, (p_147767_3_ + 1), d15, d1, d4);
/* 3075 */       tessellator.func_78374_a(d12, (p_147767_3_ + 0), d15, d1, d5);
/* 3076 */       tessellator.func_78374_a(d12, (p_147767_3_ + 0), d14, d2, d5);
/* 3077 */       tessellator.func_78374_a(d12, (p_147767_3_ + 1), d14, d2, d4);
/*      */ 
/*      */       
/* 3080 */       if (!bool4 && !bool3) {
/* 3081 */         tessellator.func_78374_a(d17, (p_147767_3_ + 1), d15, d6, d8);
/* 3082 */         tessellator.func_78374_a(d17, (p_147767_3_ + 0), d15, d6, d10);
/* 3083 */         tessellator.func_78374_a(d18, (p_147767_3_ + 0), d15, d7, d10);
/* 3084 */         tessellator.func_78374_a(d18, (p_147767_3_ + 1), d15, d7, d8);
/*      */         
/* 3086 */         tessellator.func_78374_a(d18, (p_147767_3_ + 1), d15, d6, d8);
/* 3087 */         tessellator.func_78374_a(d18, (p_147767_3_ + 0), d15, d6, d10);
/* 3088 */         tessellator.func_78374_a(d17, (p_147767_3_ + 0), d15, d7, d10);
/* 3089 */         tessellator.func_78374_a(d17, (p_147767_3_ + 1), d15, d7, d8);
/*      */       } 
/*      */       
/* 3092 */       if (bool5 || (p_147767_3_ < i - 1 && this.field_147845_a.func_147437_c(p_147767_2_, p_147767_3_ + 1, p_147767_4_ - 1))) {
/*      */         
/* 3094 */         tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d14, d7, d8);
/* 3095 */         tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d15, d7, d9);
/* 3096 */         tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d15, d6, d9);
/* 3097 */         tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d14, d6, d8);
/*      */         
/* 3099 */         tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d15, d7, d8);
/* 3100 */         tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d14, d7, d9);
/* 3101 */         tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d14, d6, d9);
/* 3102 */         tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d15, d6, d8);
/*      */       } 
/*      */       
/* 3105 */       if (bool6 || (p_147767_3_ > 1 && this.field_147845_a.func_147437_c(p_147767_2_, p_147767_3_ - 1, p_147767_4_ - 1)))
/*      */       {
/* 3107 */         tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d14, d7, d8);
/* 3108 */         tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d15, d7, d9);
/* 3109 */         tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d15, d6, d9);
/* 3110 */         tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d14, d6, d8);
/*      */         
/* 3112 */         tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d15, d7, d8);
/* 3113 */         tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d14, d7, d9);
/* 3114 */         tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d14, d6, d9);
/* 3115 */         tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d15, d6, d8);
/*      */       }
/*      */     
/* 3118 */     } else if (!bool1 && bool2) {
/*      */       
/* 3120 */       tessellator.func_78374_a(d12, (p_147767_3_ + 1), d15, d2, d4);
/* 3121 */       tessellator.func_78374_a(d12, (p_147767_3_ + 0), d15, d2, d5);
/* 3122 */       tessellator.func_78374_a(d12, (p_147767_3_ + 0), d16, d3, d5);
/* 3123 */       tessellator.func_78374_a(d12, (p_147767_3_ + 1), d16, d3, d4);
/*      */       
/* 3125 */       tessellator.func_78374_a(d12, (p_147767_3_ + 1), d16, d2, d4);
/* 3126 */       tessellator.func_78374_a(d12, (p_147767_3_ + 0), d16, d2, d5);
/* 3127 */       tessellator.func_78374_a(d12, (p_147767_3_ + 0), d15, d3, d5);
/* 3128 */       tessellator.func_78374_a(d12, (p_147767_3_ + 1), d15, d3, d4);
/*      */ 
/*      */       
/* 3131 */       if (!bool4 && !bool3) {
/* 3132 */         tessellator.func_78374_a(d18, (p_147767_3_ + 1), d15, d6, d8);
/* 3133 */         tessellator.func_78374_a(d18, (p_147767_3_ + 0), d15, d6, d10);
/* 3134 */         tessellator.func_78374_a(d17, (p_147767_3_ + 0), d15, d7, d10);
/* 3135 */         tessellator.func_78374_a(d17, (p_147767_3_ + 1), d15, d7, d8);
/*      */         
/* 3137 */         tessellator.func_78374_a(d17, (p_147767_3_ + 1), d15, d6, d8);
/* 3138 */         tessellator.func_78374_a(d17, (p_147767_3_ + 0), d15, d6, d10);
/* 3139 */         tessellator.func_78374_a(d18, (p_147767_3_ + 0), d15, d7, d10);
/* 3140 */         tessellator.func_78374_a(d18, (p_147767_3_ + 1), d15, d7, d8);
/*      */       } 
/*      */       
/* 3143 */       if (bool5 || (p_147767_3_ < i - 1 && this.field_147845_a.func_147437_c(p_147767_2_, p_147767_3_ + 1, p_147767_4_ + 1))) {
/*      */         
/* 3145 */         tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d15, d6, d9);
/* 3146 */         tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d16, d6, d10);
/* 3147 */         tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d16, d7, d10);
/* 3148 */         tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d15, d7, d9);
/*      */         
/* 3150 */         tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d16, d6, d9);
/* 3151 */         tessellator.func_78374_a(d17, (p_147767_3_ + 1) + 0.005D, d15, d6, d10);
/* 3152 */         tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d15, d7, d10);
/* 3153 */         tessellator.func_78374_a(d18, (p_147767_3_ + 1) + 0.005D, d16, d7, d9);
/*      */       } 
/* 3155 */       if (bool6 || (p_147767_3_ > 1 && this.field_147845_a.func_147437_c(p_147767_2_, p_147767_3_ - 1, p_147767_4_ + 1))) {
/*      */         
/* 3157 */         tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d15, d6, d9);
/* 3158 */         tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d16, d6, d10);
/* 3159 */         tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d16, d7, d10);
/* 3160 */         tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d15, d7, d9);
/*      */         
/* 3162 */         tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d16, d6, d9);
/* 3163 */         tessellator.func_78374_a(d17, p_147767_3_ - 0.005D, d15, d6, d10);
/* 3164 */         tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d15, d7, d10);
/* 3165 */         tessellator.func_78374_a(d18, p_147767_3_ - 0.005D, d16, d7, d9);
/*      */       } 
/*      */     } 
/*      */     
/* 3169 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147746_l(Block p_147746_1_, int p_147746_2_, int p_147746_3_, int p_147746_4_) {
/* 3173 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 3175 */     tessellator.func_78380_c(p_147746_1_.func_149677_c(this.field_147845_a, p_147746_2_, p_147746_3_, p_147746_4_));
/* 3176 */     int i = p_147746_1_.func_149720_d(this.field_147845_a, p_147746_2_, p_147746_3_, p_147746_4_);
/* 3177 */     float f1 = (i >> 16 & 0xFF) / 255.0F;
/* 3178 */     float f2 = (i >> 8 & 0xFF) / 255.0F;
/* 3179 */     float f3 = (i & 0xFF) / 255.0F;
/*      */     
/* 3181 */     if (EntityRenderer.field_78517_a) {
/* 3182 */       float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
/* 3183 */       float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
/* 3184 */       float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
/*      */       
/* 3186 */       f1 = f4;
/* 3187 */       f2 = f5;
/* 3188 */       f3 = f6;
/*      */     } 
/* 3190 */     tessellator.func_78386_a(f1, f2, f3);
/*      */     
/* 3192 */     double d1 = p_147746_2_;
/* 3193 */     double d2 = p_147746_3_;
/* 3194 */     double d3 = p_147746_4_;
/*      */     
/* 3196 */     if (p_147746_1_ == Blocks.field_150329_H) {
/* 3197 */       long l = (p_147746_2_ * 3129871) ^ p_147746_4_ * 116129781L ^ p_147746_3_;
/* 3198 */       l = l * l * 42317861L + l * 11L;
/*      */       
/* 3200 */       d1 += (((float)(l >> 16L & 0xFL) / 15.0F) - 0.5D) * 0.5D;
/* 3201 */       d2 += (((float)(l >> 20L & 0xFL) / 15.0F) - 1.0D) * 0.2D;
/* 3202 */       d3 += (((float)(l >> 24L & 0xFL) / 15.0F) - 0.5D) * 0.5D;
/* 3203 */     } else if (p_147746_1_ == Blocks.field_150328_O || p_147746_1_ == Blocks.field_150327_N) {
/* 3204 */       long l = (p_147746_2_ * 3129871) ^ p_147746_4_ * 116129781L ^ p_147746_3_;
/* 3205 */       l = l * l * 42317861L + l * 11L;
/*      */       
/* 3207 */       d1 += (((float)(l >> 16L & 0xFL) / 15.0F) - 0.5D) * 0.3D;
/* 3208 */       d3 += (((float)(l >> 24L & 0xFL) / 15.0F) - 0.5D) * 0.3D;
/*      */     } 
/*      */     
/* 3211 */     IIcon iIcon = func_147787_a(p_147746_1_, 0, this.field_147845_a.func_72805_g(p_147746_2_, p_147746_3_, p_147746_4_));
/* 3212 */     func_147765_a(iIcon, d1, d2, d3, 1.0F);
/* 3213 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147774_a(BlockDoublePlant p_147774_1_, int p_147774_2_, int p_147774_3_, int p_147774_4_) {
/* 3217 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 3219 */     tessellator.func_78380_c(p_147774_1_.func_149677_c(this.field_147845_a, p_147774_2_, p_147774_3_, p_147774_4_));
/* 3220 */     int i = p_147774_1_.func_149720_d(this.field_147845_a, p_147774_2_, p_147774_3_, p_147774_4_);
/* 3221 */     float f1 = (i >> 16 & 0xFF) / 255.0F;
/* 3222 */     float f2 = (i >> 8 & 0xFF) / 255.0F;
/* 3223 */     float f3 = (i & 0xFF) / 255.0F;
/*      */     
/* 3225 */     if (EntityRenderer.field_78517_a) {
/* 3226 */       float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
/* 3227 */       float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
/* 3228 */       float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
/*      */       
/* 3230 */       f1 = f4;
/* 3231 */       f2 = f5;
/* 3232 */       f3 = f6;
/*      */     } 
/* 3234 */     tessellator.func_78386_a(f1, f2, f3);
/*      */     
/* 3236 */     long l = (p_147774_2_ * 3129871) ^ p_147774_4_ * 116129781L;
/* 3237 */     l = l * l * 42317861L + l * 11L;
/*      */     
/* 3239 */     double d1 = p_147774_2_;
/* 3240 */     double d2 = p_147774_3_;
/* 3241 */     double d3 = p_147774_4_;
/*      */     
/* 3243 */     d1 += (((float)(l >> 16L & 0xFL) / 15.0F) - 0.5D) * 0.3D;
/* 3244 */     d3 += (((float)(l >> 24L & 0xFL) / 15.0F) - 0.5D) * 0.3D;
/*      */ 
/*      */     
/* 3247 */     int j = this.field_147845_a.func_72805_g(p_147774_2_, p_147774_3_, p_147774_4_);
/* 3248 */     int k = 0;
/* 3249 */     boolean bool = BlockDoublePlant.func_149887_c(j);
/* 3250 */     if (bool) {
/* 3251 */       if (this.field_147845_a.func_147439_a(p_147774_2_, p_147774_3_ - 1, p_147774_4_) != p_147774_1_) {
/* 3252 */         return false;
/*      */       }
/* 3254 */       k = BlockDoublePlant.func_149890_d(this.field_147845_a.func_72805_g(p_147774_2_, p_147774_3_ - 1, p_147774_4_));
/*      */     } else {
/* 3256 */       k = BlockDoublePlant.func_149890_d(j);
/*      */     } 
/* 3258 */     IIcon iIcon = p_147774_1_.func_149888_a(bool, k);
/*      */     
/* 3260 */     func_147765_a(iIcon, d1, d2, d3, 1.0F);
/*      */     
/* 3262 */     if (bool && k == 0) {
/*      */       
/* 3264 */       IIcon iIcon1 = p_147774_1_.field_149891_b[0];
/*      */       
/* 3266 */       double d4 = Math.cos(l * 0.8D) * Math.PI * 0.1D;
/* 3267 */       double d5 = Math.cos(d4);
/* 3268 */       double d6 = Math.sin(d4);
/*      */       
/* 3270 */       double d7 = iIcon1.func_94209_e();
/* 3271 */       double d8 = iIcon1.func_94206_g();
/* 3272 */       double d9 = iIcon1.func_94212_f();
/* 3273 */       double d10 = iIcon1.func_94210_h();
/*      */ 
/*      */       
/* 3276 */       double d11 = 0.3D;
/* 3277 */       double d12 = -0.05D;
/* 3278 */       double d13 = 0.5D + 0.3D * d5 - 0.5D * d6;
/* 3279 */       double d14 = 0.5D + 0.5D * d5 + 0.3D * d6;
/* 3280 */       double d15 = 0.5D + 0.3D * d5 + 0.5D * d6;
/* 3281 */       double d16 = 0.5D + -0.5D * d5 + 0.3D * d6;
/* 3282 */       double d17 = 0.5D + -0.05D * d5 + 0.5D * d6;
/* 3283 */       double d18 = 0.5D + -0.5D * d5 + -0.05D * d6;
/* 3284 */       double d19 = 0.5D + -0.05D * d5 - 0.5D * d6;
/* 3285 */       double d20 = 0.5D + 0.5D * d5 + -0.05D * d6;
/*      */ 
/*      */ 
/*      */       
/* 3289 */       tessellator.func_78374_a(d1 + d17, d2 + 1.0D, d3 + d18, d7, d10);
/* 3290 */       tessellator.func_78374_a(d1 + d19, d2 + 1.0D, d3 + d20, d9, d10);
/* 3291 */       tessellator.func_78374_a(d1 + d13, d2 + 0.0D, d3 + d14, d9, d8);
/* 3292 */       tessellator.func_78374_a(d1 + d15, d2 + 0.0D, d3 + d16, d7, d8);
/*      */       
/* 3294 */       IIcon iIcon2 = p_147774_1_.field_149891_b[1];
/*      */       
/* 3296 */       d7 = iIcon2.func_94209_e();
/* 3297 */       d8 = iIcon2.func_94206_g();
/* 3298 */       d9 = iIcon2.func_94212_f();
/* 3299 */       d10 = iIcon2.func_94210_h();
/*      */       
/* 3301 */       tessellator.func_78374_a(d1 + d19, d2 + 1.0D, d3 + d20, d7, d10);
/* 3302 */       tessellator.func_78374_a(d1 + d17, d2 + 1.0D, d3 + d18, d9, d10);
/* 3303 */       tessellator.func_78374_a(d1 + d15, d2 + 0.0D, d3 + d16, d9, d8);
/* 3304 */       tessellator.func_78374_a(d1 + d13, d2 + 0.0D, d3 + d14, d7, d8);
/*      */     } 
/*      */     
/* 3307 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147724_m(Block p_147724_1_, int p_147724_2_, int p_147724_3_, int p_147724_4_) {
/* 3311 */     BlockStem blockStem = (BlockStem)p_147724_1_;
/* 3312 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 3314 */     tessellator.func_78380_c(blockStem.func_149677_c(this.field_147845_a, p_147724_2_, p_147724_3_, p_147724_4_));
/* 3315 */     int i = blockStem.func_149720_d(this.field_147845_a, p_147724_2_, p_147724_3_, p_147724_4_);
/* 3316 */     float f1 = (i >> 16 & 0xFF) / 255.0F;
/* 3317 */     float f2 = (i >> 8 & 0xFF) / 255.0F;
/* 3318 */     float f3 = (i & 0xFF) / 255.0F;
/*      */     
/* 3320 */     if (EntityRenderer.field_78517_a) {
/* 3321 */       float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
/* 3322 */       float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
/* 3323 */       float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
/*      */       
/* 3325 */       f1 = f4;
/* 3326 */       f2 = f5;
/* 3327 */       f3 = f6;
/*      */     } 
/* 3329 */     tessellator.func_78386_a(f1, f2, f3);
/*      */     
/* 3331 */     blockStem.func_149719_a(this.field_147845_a, p_147724_2_, p_147724_3_, p_147724_4_);
/* 3332 */     int j = blockStem.func_149873_e(this.field_147845_a, p_147724_2_, p_147724_3_, p_147724_4_);
/* 3333 */     if (j < 0) {
/* 3334 */       func_147730_a((Block)blockStem, this.field_147845_a.func_72805_g(p_147724_2_, p_147724_3_, p_147724_4_), this.field_147857_k, p_147724_2_, (p_147724_3_ - 0.0625F), p_147724_4_);
/*      */     } else {
/* 3336 */       func_147730_a((Block)blockStem, this.field_147845_a.func_72805_g(p_147724_2_, p_147724_3_, p_147724_4_), 0.5D, p_147724_2_, (p_147724_3_ - 0.0625F), p_147724_4_);
/* 3337 */       func_147740_a(blockStem, this.field_147845_a.func_72805_g(p_147724_2_, p_147724_3_, p_147724_4_), j, this.field_147857_k, p_147724_2_, (p_147724_3_ - 0.0625F), p_147724_4_);
/*      */     } 
/* 3339 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147796_n(Block p_147796_1_, int p_147796_2_, int p_147796_3_, int p_147796_4_) {
/* 3343 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 3345 */     tessellator.func_78380_c(p_147796_1_.func_149677_c(this.field_147845_a, p_147796_2_, p_147796_3_, p_147796_4_));
/* 3346 */     tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/*      */     
/* 3348 */     func_147795_a(p_147796_1_, this.field_147845_a.func_72805_g(p_147796_2_, p_147796_3_, p_147796_4_), p_147796_2_, (p_147796_3_ - 0.0625F), p_147796_4_);
/* 3349 */     return true;
/*      */   }
/*      */   
/*      */   public void func_147747_a(Block p_147747_1_, double p_147747_2_, double p_147747_4_, double p_147747_6_, double p_147747_8_, double p_147747_10_, int p_147747_12_) {
/* 3353 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 3354 */     IIcon iIcon = func_147787_a(p_147747_1_, 0, p_147747_12_);
/*      */     
/* 3356 */     if (func_147744_b()) iIcon = this.field_147840_d; 
/* 3357 */     double d1 = iIcon.func_94209_e();
/* 3358 */     double d2 = iIcon.func_94206_g();
/* 3359 */     double d3 = iIcon.func_94212_f();
/* 3360 */     double d4 = iIcon.func_94210_h();
/*      */     
/* 3362 */     double d5 = iIcon.func_94214_a(7.0D);
/* 3363 */     double d6 = iIcon.func_94207_b(6.0D);
/* 3364 */     double d7 = iIcon.func_94214_a(9.0D);
/* 3365 */     double d8 = iIcon.func_94207_b(8.0D);
/*      */     
/* 3367 */     double d9 = iIcon.func_94214_a(7.0D);
/* 3368 */     double d10 = iIcon.func_94207_b(13.0D);
/* 3369 */     double d11 = iIcon.func_94214_a(9.0D);
/* 3370 */     double d12 = iIcon.func_94207_b(15.0D);
/*      */     
/* 3372 */     p_147747_2_ += 0.5D;
/* 3373 */     p_147747_6_ += 0.5D;
/*      */     
/* 3375 */     double d13 = p_147747_2_ - 0.5D;
/* 3376 */     double d14 = p_147747_2_ + 0.5D;
/* 3377 */     double d15 = p_147747_6_ - 0.5D;
/* 3378 */     double d16 = p_147747_6_ + 0.5D;
/* 3379 */     double d17 = 0.0625D;
/*      */     
/* 3381 */     double d18 = 0.625D;
/* 3382 */     tessellator.func_78374_a(p_147747_2_ + p_147747_8_ * (1.0D - d18) - d17, p_147747_4_ + d18, p_147747_6_ + p_147747_10_ * (1.0D - d18) - d17, d5, d6);
/* 3383 */     tessellator.func_78374_a(p_147747_2_ + p_147747_8_ * (1.0D - d18) - d17, p_147747_4_ + d18, p_147747_6_ + p_147747_10_ * (1.0D - d18) + d17, d5, d8);
/* 3384 */     tessellator.func_78374_a(p_147747_2_ + p_147747_8_ * (1.0D - d18) + d17, p_147747_4_ + d18, p_147747_6_ + p_147747_10_ * (1.0D - d18) + d17, d7, d8);
/* 3385 */     tessellator.func_78374_a(p_147747_2_ + p_147747_8_ * (1.0D - d18) + d17, p_147747_4_ + d18, p_147747_6_ + p_147747_10_ * (1.0D - d18) - d17, d7, d6);
/*      */     
/* 3387 */     tessellator.func_78374_a(p_147747_2_ + d17 + p_147747_8_, p_147747_4_, p_147747_6_ - d17 + p_147747_10_, d11, d10);
/* 3388 */     tessellator.func_78374_a(p_147747_2_ + d17 + p_147747_8_, p_147747_4_, p_147747_6_ + d17 + p_147747_10_, d11, d12);
/* 3389 */     tessellator.func_78374_a(p_147747_2_ - d17 + p_147747_8_, p_147747_4_, p_147747_6_ + d17 + p_147747_10_, d9, d12);
/* 3390 */     tessellator.func_78374_a(p_147747_2_ - d17 + p_147747_8_, p_147747_4_, p_147747_6_ - d17 + p_147747_10_, d9, d10);
/*      */     
/* 3392 */     tessellator.func_78374_a(p_147747_2_ - d17, p_147747_4_ + 1.0D, d15, d1, d2);
/* 3393 */     tessellator.func_78374_a(p_147747_2_ - d17 + p_147747_8_, p_147747_4_ + 0.0D, d15 + p_147747_10_, d1, d4);
/* 3394 */     tessellator.func_78374_a(p_147747_2_ - d17 + p_147747_8_, p_147747_4_ + 0.0D, d16 + p_147747_10_, d3, d4);
/* 3395 */     tessellator.func_78374_a(p_147747_2_ - d17, p_147747_4_ + 1.0D, d16, d3, d2);
/*      */     
/* 3397 */     tessellator.func_78374_a(p_147747_2_ + d17, p_147747_4_ + 1.0D, d16, d1, d2);
/* 3398 */     tessellator.func_78374_a(p_147747_2_ + p_147747_8_ + d17, p_147747_4_ + 0.0D, d16 + p_147747_10_, d1, d4);
/* 3399 */     tessellator.func_78374_a(p_147747_2_ + p_147747_8_ + d17, p_147747_4_ + 0.0D, d15 + p_147747_10_, d3, d4);
/* 3400 */     tessellator.func_78374_a(p_147747_2_ + d17, p_147747_4_ + 1.0D, d15, d3, d2);
/*      */     
/* 3402 */     tessellator.func_78374_a(d13, p_147747_4_ + 1.0D, p_147747_6_ + d17, d1, d2);
/* 3403 */     tessellator.func_78374_a(d13 + p_147747_8_, p_147747_4_ + 0.0D, p_147747_6_ + d17 + p_147747_10_, d1, d4);
/* 3404 */     tessellator.func_78374_a(d14 + p_147747_8_, p_147747_4_ + 0.0D, p_147747_6_ + d17 + p_147747_10_, d3, d4);
/* 3405 */     tessellator.func_78374_a(d14, p_147747_4_ + 1.0D, p_147747_6_ + d17, d3, d2);
/*      */     
/* 3407 */     tessellator.func_78374_a(d14, p_147747_4_ + 1.0D, p_147747_6_ - d17, d1, d2);
/* 3408 */     tessellator.func_78374_a(d14 + p_147747_8_, p_147747_4_ + 0.0D, p_147747_6_ - d17 + p_147747_10_, d1, d4);
/* 3409 */     tessellator.func_78374_a(d13 + p_147747_8_, p_147747_4_ + 0.0D, p_147747_6_ - d17 + p_147747_10_, d3, d4);
/* 3410 */     tessellator.func_78374_a(d13, p_147747_4_ + 1.0D, p_147747_6_ - d17, d3, d2);
/*      */   }
/*      */   
/*      */   public void func_147765_a(IIcon p_147765_1_, double p_147765_2_, double p_147765_4_, double p_147765_6_, float p_147765_8_) {
/* 3414 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 3416 */     if (func_147744_b()) p_147765_1_ = this.field_147840_d; 
/* 3417 */     double d1 = p_147765_1_.func_94209_e();
/* 3418 */     double d2 = p_147765_1_.func_94206_g();
/* 3419 */     double d3 = p_147765_1_.func_94212_f();
/* 3420 */     double d4 = p_147765_1_.func_94210_h();
/*      */     
/* 3422 */     double d5 = 0.45D * p_147765_8_;
/* 3423 */     double d6 = p_147765_2_ + 0.5D - d5;
/* 3424 */     double d7 = p_147765_2_ + 0.5D + d5;
/* 3425 */     double d8 = p_147765_6_ + 0.5D - d5;
/* 3426 */     double d9 = p_147765_6_ + 0.5D + d5;
/*      */     
/* 3428 */     tessellator.func_78374_a(d6, p_147765_4_ + p_147765_8_, d8, d1, d2);
/* 3429 */     tessellator.func_78374_a(d6, p_147765_4_ + 0.0D, d8, d1, d4);
/* 3430 */     tessellator.func_78374_a(d7, p_147765_4_ + 0.0D, d9, d3, d4);
/* 3431 */     tessellator.func_78374_a(d7, p_147765_4_ + p_147765_8_, d9, d3, d2);
/*      */     
/* 3433 */     tessellator.func_78374_a(d7, p_147765_4_ + p_147765_8_, d9, d1, d2);
/* 3434 */     tessellator.func_78374_a(d7, p_147765_4_ + 0.0D, d9, d1, d4);
/* 3435 */     tessellator.func_78374_a(d6, p_147765_4_ + 0.0D, d8, d3, d4);
/* 3436 */     tessellator.func_78374_a(d6, p_147765_4_ + p_147765_8_, d8, d3, d2);
/*      */     
/* 3438 */     tessellator.func_78374_a(d6, p_147765_4_ + p_147765_8_, d9, d1, d2);
/* 3439 */     tessellator.func_78374_a(d6, p_147765_4_ + 0.0D, d9, d1, d4);
/* 3440 */     tessellator.func_78374_a(d7, p_147765_4_ + 0.0D, d8, d3, d4);
/* 3441 */     tessellator.func_78374_a(d7, p_147765_4_ + p_147765_8_, d8, d3, d2);
/*      */     
/* 3443 */     tessellator.func_78374_a(d7, p_147765_4_ + p_147765_8_, d8, d1, d2);
/* 3444 */     tessellator.func_78374_a(d7, p_147765_4_ + 0.0D, d8, d1, d4);
/* 3445 */     tessellator.func_78374_a(d6, p_147765_4_ + 0.0D, d9, d3, d4);
/* 3446 */     tessellator.func_78374_a(d6, p_147765_4_ + p_147765_8_, d9, d3, d2);
/*      */   }
/*      */   
/*      */   public void func_147730_a(Block p_147730_1_, int p_147730_2_, double p_147730_3_, double p_147730_5_, double p_147730_7_, double p_147730_9_) {
/* 3450 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 3452 */     IIcon iIcon = func_147787_a(p_147730_1_, 0, p_147730_2_);
/*      */     
/* 3454 */     if (func_147744_b()) iIcon = this.field_147840_d; 
/* 3455 */     double d1 = iIcon.func_94209_e();
/* 3456 */     double d2 = iIcon.func_94206_g();
/* 3457 */     double d3 = iIcon.func_94212_f();
/* 3458 */     double d4 = iIcon.func_94207_b(p_147730_3_ * 16.0D);
/*      */     
/* 3460 */     double d5 = p_147730_5_ + 0.5D - 0.44999998807907104D;
/* 3461 */     double d6 = p_147730_5_ + 0.5D + 0.44999998807907104D;
/* 3462 */     double d7 = p_147730_9_ + 0.5D - 0.44999998807907104D;
/* 3463 */     double d8 = p_147730_9_ + 0.5D + 0.44999998807907104D;
/*      */     
/* 3465 */     tessellator.func_78374_a(d5, p_147730_7_ + p_147730_3_, d7, d1, d2);
/* 3466 */     tessellator.func_78374_a(d5, p_147730_7_ + 0.0D, d7, d1, d4);
/* 3467 */     tessellator.func_78374_a(d6, p_147730_7_ + 0.0D, d8, d3, d4);
/* 3468 */     tessellator.func_78374_a(d6, p_147730_7_ + p_147730_3_, d8, d3, d2);
/*      */     
/* 3470 */     tessellator.func_78374_a(d6, p_147730_7_ + p_147730_3_, d8, d3, d2);
/* 3471 */     tessellator.func_78374_a(d6, p_147730_7_ + 0.0D, d8, d3, d4);
/* 3472 */     tessellator.func_78374_a(d5, p_147730_7_ + 0.0D, d7, d1, d4);
/* 3473 */     tessellator.func_78374_a(d5, p_147730_7_ + p_147730_3_, d7, d1, d2);
/*      */     
/* 3475 */     tessellator.func_78374_a(d5, p_147730_7_ + p_147730_3_, d8, d1, d2);
/* 3476 */     tessellator.func_78374_a(d5, p_147730_7_ + 0.0D, d8, d1, d4);
/* 3477 */     tessellator.func_78374_a(d6, p_147730_7_ + 0.0D, d7, d3, d4);
/* 3478 */     tessellator.func_78374_a(d6, p_147730_7_ + p_147730_3_, d7, d3, d2);
/*      */     
/* 3480 */     tessellator.func_78374_a(d6, p_147730_7_ + p_147730_3_, d7, d3, d2);
/* 3481 */     tessellator.func_78374_a(d6, p_147730_7_ + 0.0D, d7, d3, d4);
/* 3482 */     tessellator.func_78374_a(d5, p_147730_7_ + 0.0D, d8, d1, d4);
/* 3483 */     tessellator.func_78374_a(d5, p_147730_7_ + p_147730_3_, d8, d1, d2);
/*      */   }
/*      */   
/*      */   public boolean func_147783_o(Block p_147783_1_, int p_147783_2_, int p_147783_3_, int p_147783_4_) {
/* 3487 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 3489 */     IIcon iIcon = func_147777_a(p_147783_1_, 1);
/*      */     
/* 3491 */     if (func_147744_b()) iIcon = this.field_147840_d; 
/* 3492 */     float f1 = 0.015625F;
/*      */     
/* 3494 */     double d1 = iIcon.func_94209_e();
/* 3495 */     double d2 = iIcon.func_94206_g();
/* 3496 */     double d3 = iIcon.func_94212_f();
/* 3497 */     double d4 = iIcon.func_94210_h();
/*      */     
/* 3499 */     long l = (p_147783_2_ * 3129871) ^ p_147783_4_ * 116129781L ^ p_147783_3_;
/* 3500 */     l = l * l * 42317861L + l * 11L;
/*      */     
/* 3502 */     int i = (int)(l >> 16L & 0x3L);
/*      */     
/* 3504 */     tessellator.func_78380_c(p_147783_1_.func_149677_c(this.field_147845_a, p_147783_2_, p_147783_3_, p_147783_4_));
/*      */     
/* 3506 */     float f2 = p_147783_2_ + 0.5F;
/* 3507 */     float f3 = p_147783_4_ + 0.5F;
/* 3508 */     float f4 = (i & 0x1) * 0.5F * (1 - i / 2 % 2 * 2);
/* 3509 */     float f5 = (i + 1 & 0x1) * 0.5F * (1 - (i + 1) / 2 % 2 * 2);
/*      */     
/* 3511 */     tessellator.func_78378_d(p_147783_1_.func_149635_D());
/* 3512 */     tessellator.func_78374_a((f2 + f4 - f5), (p_147783_3_ + f1), (f3 + f4 + f5), d1, d2);
/* 3513 */     tessellator.func_78374_a((f2 + f4 + f5), (p_147783_3_ + f1), (f3 - f4 + f5), d3, d2);
/* 3514 */     tessellator.func_78374_a((f2 - f4 + f5), (p_147783_3_ + f1), (f3 - f4 - f5), d3, d4);
/* 3515 */     tessellator.func_78374_a((f2 - f4 - f5), (p_147783_3_ + f1), (f3 + f4 - f5), d1, d4);
/*      */     
/* 3517 */     tessellator.func_78378_d((p_147783_1_.func_149635_D() & 0xFEFEFE) >> 1);
/* 3518 */     tessellator.func_78374_a((f2 - f4 - f5), (p_147783_3_ + f1), (f3 + f4 - f5), d1, d4);
/* 3519 */     tessellator.func_78374_a((f2 - f4 + f5), (p_147783_3_ + f1), (f3 - f4 - f5), d3, d4);
/* 3520 */     tessellator.func_78374_a((f2 + f4 + f5), (p_147783_3_ + f1), (f3 - f4 + f5), d3, d2);
/* 3521 */     tessellator.func_78374_a((f2 + f4 - f5), (p_147783_3_ + f1), (f3 + f4 + f5), d1, d2);
/*      */     
/* 3523 */     return true;
/*      */   }
/*      */   
/*      */   public void func_147740_a(BlockStem p_147740_1_, int p_147740_2_, int p_147740_3_, double p_147740_4_, double p_147740_6_, double p_147740_8_, double p_147740_10_) {
/* 3527 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 3529 */     IIcon iIcon = p_147740_1_.func_149872_i();
/*      */     
/* 3531 */     if (func_147744_b()) iIcon = this.field_147840_d; 
/* 3532 */     double d1 = iIcon.func_94209_e();
/* 3533 */     double d2 = iIcon.func_94206_g();
/* 3534 */     double d3 = iIcon.func_94212_f();
/* 3535 */     double d4 = iIcon.func_94210_h();
/*      */     
/* 3537 */     double d5 = p_147740_6_ + 0.5D - 0.5D;
/* 3538 */     double d6 = p_147740_6_ + 0.5D + 0.5D;
/* 3539 */     double d7 = p_147740_10_ + 0.5D - 0.5D;
/* 3540 */     double d8 = p_147740_10_ + 0.5D + 0.5D;
/*      */     
/* 3542 */     double d9 = p_147740_6_ + 0.5D;
/* 3543 */     double d10 = p_147740_10_ + 0.5D;
/*      */     
/* 3545 */     if ((p_147740_3_ + 1) / 2 % 2 == 1) {
/* 3546 */       double d = d3;
/* 3547 */       d3 = d1;
/* 3548 */       d1 = d;
/*      */     } 
/*      */     
/* 3551 */     if (p_147740_3_ < 2) {
/* 3552 */       tessellator.func_78374_a(d5, p_147740_8_ + p_147740_4_, d10, d1, d2);
/* 3553 */       tessellator.func_78374_a(d5, p_147740_8_ + 0.0D, d10, d1, d4);
/* 3554 */       tessellator.func_78374_a(d6, p_147740_8_ + 0.0D, d10, d3, d4);
/* 3555 */       tessellator.func_78374_a(d6, p_147740_8_ + p_147740_4_, d10, d3, d2);
/*      */       
/* 3557 */       tessellator.func_78374_a(d6, p_147740_8_ + p_147740_4_, d10, d3, d2);
/* 3558 */       tessellator.func_78374_a(d6, p_147740_8_ + 0.0D, d10, d3, d4);
/* 3559 */       tessellator.func_78374_a(d5, p_147740_8_ + 0.0D, d10, d1, d4);
/* 3560 */       tessellator.func_78374_a(d5, p_147740_8_ + p_147740_4_, d10, d1, d2);
/*      */     } else {
/*      */       
/* 3563 */       tessellator.func_78374_a(d9, p_147740_8_ + p_147740_4_, d8, d1, d2);
/* 3564 */       tessellator.func_78374_a(d9, p_147740_8_ + 0.0D, d8, d1, d4);
/* 3565 */       tessellator.func_78374_a(d9, p_147740_8_ + 0.0D, d7, d3, d4);
/* 3566 */       tessellator.func_78374_a(d9, p_147740_8_ + p_147740_4_, d7, d3, d2);
/*      */       
/* 3568 */       tessellator.func_78374_a(d9, p_147740_8_ + p_147740_4_, d7, d3, d2);
/* 3569 */       tessellator.func_78374_a(d9, p_147740_8_ + 0.0D, d7, d3, d4);
/* 3570 */       tessellator.func_78374_a(d9, p_147740_8_ + 0.0D, d8, d1, d4);
/* 3571 */       tessellator.func_78374_a(d9, p_147740_8_ + p_147740_4_, d8, d1, d2);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_147795_a(Block p_147795_1_, int p_147795_2_, double p_147795_3_, double p_147795_5_, double p_147795_7_) {
/* 3576 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 3578 */     IIcon iIcon = func_147787_a(p_147795_1_, 0, p_147795_2_);
/*      */     
/* 3580 */     if (func_147744_b()) iIcon = this.field_147840_d; 
/* 3581 */     double d1 = iIcon.func_94209_e();
/* 3582 */     double d2 = iIcon.func_94206_g();
/* 3583 */     double d3 = iIcon.func_94212_f();
/* 3584 */     double d4 = iIcon.func_94210_h();
/*      */     
/* 3586 */     double d5 = p_147795_3_ + 0.5D - 0.25D;
/* 3587 */     double d6 = p_147795_3_ + 0.5D + 0.25D;
/* 3588 */     double d7 = p_147795_7_ + 0.5D - 0.5D;
/* 3589 */     double d8 = p_147795_7_ + 0.5D + 0.5D;
/*      */     
/* 3591 */     tessellator.func_78374_a(d5, p_147795_5_ + 1.0D, d7, d1, d2);
/* 3592 */     tessellator.func_78374_a(d5, p_147795_5_ + 0.0D, d7, d1, d4);
/* 3593 */     tessellator.func_78374_a(d5, p_147795_5_ + 0.0D, d8, d3, d4);
/* 3594 */     tessellator.func_78374_a(d5, p_147795_5_ + 1.0D, d8, d3, d2);
/*      */     
/* 3596 */     tessellator.func_78374_a(d5, p_147795_5_ + 1.0D, d8, d1, d2);
/* 3597 */     tessellator.func_78374_a(d5, p_147795_5_ + 0.0D, d8, d1, d4);
/* 3598 */     tessellator.func_78374_a(d5, p_147795_5_ + 0.0D, d7, d3, d4);
/* 3599 */     tessellator.func_78374_a(d5, p_147795_5_ + 1.0D, d7, d3, d2);
/*      */     
/* 3601 */     tessellator.func_78374_a(d6, p_147795_5_ + 1.0D, d8, d1, d2);
/* 3602 */     tessellator.func_78374_a(d6, p_147795_5_ + 0.0D, d8, d1, d4);
/* 3603 */     tessellator.func_78374_a(d6, p_147795_5_ + 0.0D, d7, d3, d4);
/* 3604 */     tessellator.func_78374_a(d6, p_147795_5_ + 1.0D, d7, d3, d2);
/*      */     
/* 3606 */     tessellator.func_78374_a(d6, p_147795_5_ + 1.0D, d7, d1, d2);
/* 3607 */     tessellator.func_78374_a(d6, p_147795_5_ + 0.0D, d7, d1, d4);
/* 3608 */     tessellator.func_78374_a(d6, p_147795_5_ + 0.0D, d8, d3, d4);
/* 3609 */     tessellator.func_78374_a(d6, p_147795_5_ + 1.0D, d8, d3, d2);
/*      */     
/* 3611 */     d5 = p_147795_3_ + 0.5D - 0.5D;
/* 3612 */     d6 = p_147795_3_ + 0.5D + 0.5D;
/* 3613 */     d7 = p_147795_7_ + 0.5D - 0.25D;
/* 3614 */     d8 = p_147795_7_ + 0.5D + 0.25D;
/*      */     
/* 3616 */     tessellator.func_78374_a(d5, p_147795_5_ + 1.0D, d7, d1, d2);
/* 3617 */     tessellator.func_78374_a(d5, p_147795_5_ + 0.0D, d7, d1, d4);
/* 3618 */     tessellator.func_78374_a(d6, p_147795_5_ + 0.0D, d7, d3, d4);
/* 3619 */     tessellator.func_78374_a(d6, p_147795_5_ + 1.0D, d7, d3, d2);
/*      */     
/* 3621 */     tessellator.func_78374_a(d6, p_147795_5_ + 1.0D, d7, d1, d2);
/* 3622 */     tessellator.func_78374_a(d6, p_147795_5_ + 0.0D, d7, d1, d4);
/* 3623 */     tessellator.func_78374_a(d5, p_147795_5_ + 0.0D, d7, d3, d4);
/* 3624 */     tessellator.func_78374_a(d5, p_147795_5_ + 1.0D, d7, d3, d2);
/*      */     
/* 3626 */     tessellator.func_78374_a(d6, p_147795_5_ + 1.0D, d8, d1, d2);
/* 3627 */     tessellator.func_78374_a(d6, p_147795_5_ + 0.0D, d8, d1, d4);
/* 3628 */     tessellator.func_78374_a(d5, p_147795_5_ + 0.0D, d8, d3, d4);
/* 3629 */     tessellator.func_78374_a(d5, p_147795_5_ + 1.0D, d8, d3, d2);
/*      */     
/* 3631 */     tessellator.func_78374_a(d5, p_147795_5_ + 1.0D, d8, d1, d2);
/* 3632 */     tessellator.func_78374_a(d5, p_147795_5_ + 0.0D, d8, d1, d4);
/* 3633 */     tessellator.func_78374_a(d6, p_147795_5_ + 0.0D, d8, d3, d4);
/* 3634 */     tessellator.func_78374_a(d6, p_147795_5_ + 1.0D, d8, d3, d2);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_147721_p(Block p_147721_1_, int p_147721_2_, int p_147721_3_, int p_147721_4_) {
/* 3639 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 3641 */     int i = p_147721_1_.func_149720_d(this.field_147845_a, p_147721_2_, p_147721_3_, p_147721_4_);
/* 3642 */     float f1 = (i >> 16 & 0xFF) / 255.0F;
/* 3643 */     float f2 = (i >> 8 & 0xFF) / 255.0F;
/* 3644 */     float f3 = (i & 0xFF) / 255.0F;
/* 3645 */     boolean bool1 = p_147721_1_.func_149646_a(this.field_147845_a, p_147721_2_, p_147721_3_ + 1, p_147721_4_, 1);
/* 3646 */     boolean bool2 = p_147721_1_.func_149646_a(this.field_147845_a, p_147721_2_, p_147721_3_ - 1, p_147721_4_, 0);
/* 3647 */     boolean[] arrayOfBoolean = new boolean[4];
/* 3648 */     arrayOfBoolean[0] = p_147721_1_.func_149646_a(this.field_147845_a, p_147721_2_, p_147721_3_, p_147721_4_ - 1, 2);
/* 3649 */     arrayOfBoolean[1] = p_147721_1_.func_149646_a(this.field_147845_a, p_147721_2_, p_147721_3_, p_147721_4_ + 1, 3);
/* 3650 */     arrayOfBoolean[2] = p_147721_1_.func_149646_a(this.field_147845_a, p_147721_2_ - 1, p_147721_3_, p_147721_4_, 4);
/* 3651 */     arrayOfBoolean[3] = p_147721_1_.func_149646_a(this.field_147845_a, p_147721_2_ + 1, p_147721_3_, p_147721_4_, 5);
/*      */     
/* 3653 */     if (!bool1 && !bool2 && !arrayOfBoolean[0] && !arrayOfBoolean[1] && !arrayOfBoolean[2] && !arrayOfBoolean[3]) return false;
/*      */     
/* 3655 */     boolean bool = false;
/* 3656 */     float f4 = 0.5F;
/* 3657 */     float f5 = 1.0F;
/* 3658 */     float f6 = 0.8F;
/* 3659 */     float f7 = 0.6F;
/*      */     
/* 3661 */     double d1 = 0.0D;
/* 3662 */     double d2 = 1.0D;
/*      */     
/* 3664 */     Material material = p_147721_1_.func_149688_o();
/* 3665 */     int j = this.field_147845_a.func_72805_g(p_147721_2_, p_147721_3_, p_147721_4_);
/*      */     
/* 3667 */     double d3 = func_147729_a(p_147721_2_, p_147721_3_, p_147721_4_, material);
/* 3668 */     double d4 = func_147729_a(p_147721_2_, p_147721_3_, p_147721_4_ + 1, material);
/* 3669 */     double d5 = func_147729_a(p_147721_2_ + 1, p_147721_3_, p_147721_4_ + 1, material);
/* 3670 */     double d6 = func_147729_a(p_147721_2_ + 1, p_147721_3_, p_147721_4_, material);
/*      */     
/* 3672 */     double d7 = 0.0010000000474974513D;
/* 3673 */     if (this.field_147837_f || bool1) {
/* 3674 */       double d8, d9, d10, d11, d12, d13, d14, d15; bool = true;
/* 3675 */       IIcon iIcon = func_147787_a(p_147721_1_, 1, j);
/* 3676 */       float f = (float)BlockLiquid.func_149802_a(this.field_147845_a, p_147721_2_, p_147721_3_, p_147721_4_, material);
/* 3677 */       if (f > -999.0F) {
/* 3678 */         iIcon = func_147787_a(p_147721_1_, 2, j);
/*      */       }
/*      */       
/* 3681 */       d3 -= d7;
/* 3682 */       d4 -= d7;
/* 3683 */       d5 -= d7;
/* 3684 */       d6 -= d7;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3689 */       if (f < -999.0F) {
/* 3690 */         d8 = iIcon.func_94214_a(0.0D);
/* 3691 */         d12 = iIcon.func_94207_b(0.0D);
/* 3692 */         d9 = d8;
/* 3693 */         d13 = iIcon.func_94207_b(16.0D);
/* 3694 */         d10 = iIcon.func_94214_a(16.0D);
/* 3695 */         d14 = d13;
/* 3696 */         d11 = d10;
/* 3697 */         d15 = d12;
/*      */       } else {
/* 3699 */         float f8 = MathHelper.func_76126_a(f) * 0.25F;
/* 3700 */         float f9 = MathHelper.func_76134_b(f) * 0.25F;
/* 3701 */         float f10 = 8.0F;
/* 3702 */         d8 = iIcon.func_94214_a((8.0F + (-f9 - f8) * 16.0F));
/* 3703 */         d12 = iIcon.func_94207_b((8.0F + (-f9 + f8) * 16.0F));
/* 3704 */         d9 = iIcon.func_94214_a((8.0F + (-f9 + f8) * 16.0F));
/* 3705 */         d13 = iIcon.func_94207_b((8.0F + (f9 + f8) * 16.0F));
/* 3706 */         d10 = iIcon.func_94214_a((8.0F + (f9 + f8) * 16.0F));
/* 3707 */         d14 = iIcon.func_94207_b((8.0F + (f9 - f8) * 16.0F));
/* 3708 */         d11 = iIcon.func_94214_a((8.0F + (f9 - f8) * 16.0F));
/* 3709 */         d15 = iIcon.func_94207_b((8.0F + (-f9 - f8) * 16.0F));
/*      */       } 
/*      */       
/* 3712 */       tessellator.func_78380_c(p_147721_1_.func_149677_c(this.field_147845_a, p_147721_2_, p_147721_3_, p_147721_4_));
/* 3713 */       tessellator.func_78386_a(f5 * f1, f5 * f2, f5 * f3);
/* 3714 */       tessellator.func_78374_a((p_147721_2_ + 0), p_147721_3_ + d3, (p_147721_4_ + 0), d8, d12);
/* 3715 */       tessellator.func_78374_a((p_147721_2_ + 0), p_147721_3_ + d4, (p_147721_4_ + 1), d9, d13);
/* 3716 */       tessellator.func_78374_a((p_147721_2_ + 1), p_147721_3_ + d5, (p_147721_4_ + 1), d10, d14);
/* 3717 */       tessellator.func_78374_a((p_147721_2_ + 1), p_147721_3_ + d6, (p_147721_4_ + 0), d11, d15);
/*      */ 
/*      */ 
/*      */       
/* 3721 */       tessellator.func_78374_a((p_147721_2_ + 0), p_147721_3_ + d3, (p_147721_4_ + 0), d8, d12);
/* 3722 */       tessellator.func_78374_a((p_147721_2_ + 1), p_147721_3_ + d6, (p_147721_4_ + 0), d11, d15);
/* 3723 */       tessellator.func_78374_a((p_147721_2_ + 1), p_147721_3_ + d5, (p_147721_4_ + 1), d10, d14);
/* 3724 */       tessellator.func_78374_a((p_147721_2_ + 0), p_147721_3_ + d4, (p_147721_4_ + 1), d9, d13);
/*      */     } 
/*      */     
/* 3727 */     if (this.field_147837_f || bool2) {
/* 3728 */       tessellator.func_78380_c(p_147721_1_.func_149677_c(this.field_147845_a, p_147721_2_, p_147721_3_ - 1, p_147721_4_));
/* 3729 */       tessellator.func_78386_a(f4, f4, f4);
/* 3730 */       func_147768_a(p_147721_1_, p_147721_2_, p_147721_3_ + d7, p_147721_4_, func_147777_a(p_147721_1_, 0));
/* 3731 */       bool = true;
/*      */     } 
/*      */     
/* 3734 */     for (byte b = 0; b < 4; b++) {
/* 3735 */       int k = p_147721_2_;
/* 3736 */       int m = p_147721_3_;
/* 3737 */       int n = p_147721_4_;
/*      */       
/* 3739 */       if (b == 0) n--; 
/* 3740 */       if (b == 1) n++; 
/* 3741 */       if (b == 2) k--; 
/* 3742 */       if (b == 3) k++;
/*      */       
/* 3744 */       IIcon iIcon = func_147787_a(p_147721_1_, b + 2, j);
/*      */       
/* 3746 */       if (this.field_147837_f || arrayOfBoolean[b]) {
/*      */         double d8, d9, d10, d11, d12, d13;
/*      */ 
/*      */         
/* 3750 */         if (b == 0) {
/* 3751 */           d8 = d3;
/* 3752 */           d9 = d6;
/* 3753 */           d10 = p_147721_2_;
/* 3754 */           d12 = (p_147721_2_ + 1);
/* 3755 */           d11 = p_147721_4_ + d7;
/* 3756 */           d13 = p_147721_4_ + d7;
/* 3757 */         } else if (b == 1) {
/* 3758 */           d8 = d5;
/* 3759 */           d9 = d4;
/* 3760 */           d10 = (p_147721_2_ + 1);
/* 3761 */           d12 = p_147721_2_;
/* 3762 */           d11 = (p_147721_4_ + 1) - d7;
/* 3763 */           d13 = (p_147721_4_ + 1) - d7;
/* 3764 */         } else if (b == 2) {
/* 3765 */           d8 = d4;
/* 3766 */           d9 = d3;
/* 3767 */           d10 = p_147721_2_ + d7;
/* 3768 */           d12 = p_147721_2_ + d7;
/* 3769 */           d11 = (p_147721_4_ + 1);
/* 3770 */           d13 = p_147721_4_;
/*      */         } else {
/* 3772 */           d8 = d6;
/* 3773 */           d9 = d5;
/* 3774 */           d10 = (p_147721_2_ + 1) - d7;
/* 3775 */           d12 = (p_147721_2_ + 1) - d7;
/* 3776 */           d11 = p_147721_4_;
/* 3777 */           d13 = (p_147721_4_ + 1);
/*      */         } 
/*      */         
/* 3780 */         bool = true;
/* 3781 */         float f8 = iIcon.func_94214_a(0.0D);
/* 3782 */         float f9 = iIcon.func_94214_a(8.0D);
/*      */         
/* 3784 */         float f10 = iIcon.func_94207_b((1.0D - d8) * 16.0D * 0.5D);
/* 3785 */         float f11 = iIcon.func_94207_b((1.0D - d9) * 16.0D * 0.5D);
/* 3786 */         float f12 = iIcon.func_94207_b(8.0D);
/*      */         
/* 3788 */         tessellator.func_78380_c(p_147721_1_.func_149677_c(this.field_147845_a, k, m, n));
/*      */         
/* 3790 */         float f13 = 1.0F;
/* 3791 */         f13 *= (b < 2) ? f6 : f7;
/*      */         
/* 3793 */         tessellator.func_78386_a(f5 * f13 * f1, f5 * f13 * f2, f5 * f13 * f3);
/* 3794 */         tessellator.func_78374_a(d10, p_147721_3_ + d8, d11, f8, f10);
/* 3795 */         tessellator.func_78374_a(d12, p_147721_3_ + d9, d13, f9, f11);
/* 3796 */         tessellator.func_78374_a(d12, (p_147721_3_ + 0), d13, f9, f12);
/* 3797 */         tessellator.func_78374_a(d10, (p_147721_3_ + 0), d11, f8, f12);
/*      */         
/* 3799 */         tessellator.func_78374_a(d10, (p_147721_3_ + 0), d11, f8, f12);
/* 3800 */         tessellator.func_78374_a(d12, (p_147721_3_ + 0), d13, f9, f12);
/* 3801 */         tessellator.func_78374_a(d12, p_147721_3_ + d9, d13, f9, f11);
/* 3802 */         tessellator.func_78374_a(d10, p_147721_3_ + d8, d11, f8, f10);
/*      */       } 
/*      */     } 
/*      */     
/* 3806 */     this.field_147855_j = d1;
/* 3807 */     this.field_147857_k = d2;
/*      */     
/* 3809 */     return bool;
/*      */   }
/*      */   
/*      */   public float func_147729_a(int p_147729_1_, int p_147729_2_, int p_147729_3_, Material p_147729_4_) {
/* 3813 */     byte b1 = 0;
/* 3814 */     float f = 0.0F;
/* 3815 */     for (byte b2 = 0; b2 < 4; b2++) {
/* 3816 */       int i = p_147729_1_ - (b2 & 0x1);
/* 3817 */       int j = p_147729_2_;
/* 3818 */       int k = p_147729_3_ - (b2 >> 1 & 0x1);
/* 3819 */       if (this.field_147845_a.func_147439_a(i, j + 1, k).func_149688_o() == p_147729_4_) {
/* 3820 */         return 1.0F;
/*      */       }
/* 3822 */       Material material = this.field_147845_a.func_147439_a(i, j, k).func_149688_o();
/* 3823 */       if (material == p_147729_4_) {
/* 3824 */         int m = this.field_147845_a.func_72805_g(i, j, k);
/* 3825 */         if (m >= 8 || m == 0) {
/* 3826 */           f += BlockLiquid.func_149801_b(m) * 10.0F;
/* 3827 */           b1 += true;
/*      */         } 
/* 3829 */         f += BlockLiquid.func_149801_b(m);
/* 3830 */         b1++;
/* 3831 */       } else if (!material.func_76220_a()) {
/* 3832 */         f++;
/* 3833 */         b1++;
/*      */       } 
/*      */     } 
/* 3836 */     return 1.0F - f / b1;
/*      */   }
/*      */   
/*      */   public void func_147749_a(Block p_147749_1_, World p_147749_2_, int p_147749_3_, int p_147749_4_, int p_147749_5_, int p_147749_6_) {
/* 3840 */     float f1 = 0.5F;
/* 3841 */     float f2 = 1.0F;
/* 3842 */     float f3 = 0.8F;
/* 3843 */     float f4 = 0.6F;
/*      */     
/* 3845 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 3846 */     tessellator.func_78382_b();
/*      */     
/* 3848 */     tessellator.func_78380_c(p_147749_1_.func_149677_c((IBlockAccess)p_147749_2_, p_147749_3_, p_147749_4_, p_147749_5_));
/*      */     
/* 3850 */     tessellator.func_78386_a(f1, f1, f1);
/* 3851 */     func_147768_a(p_147749_1_, -0.5D, -0.5D, -0.5D, func_147787_a(p_147749_1_, 0, p_147749_6_));
/*      */     
/* 3853 */     tessellator.func_78386_a(f2, f2, f2);
/* 3854 */     func_147806_b(p_147749_1_, -0.5D, -0.5D, -0.5D, func_147787_a(p_147749_1_, 1, p_147749_6_));
/*      */     
/* 3856 */     tessellator.func_78386_a(f3, f3, f3);
/* 3857 */     func_147761_c(p_147749_1_, -0.5D, -0.5D, -0.5D, func_147787_a(p_147749_1_, 2, p_147749_6_));
/*      */     
/* 3859 */     tessellator.func_78386_a(f3, f3, f3);
/* 3860 */     func_147734_d(p_147749_1_, -0.5D, -0.5D, -0.5D, func_147787_a(p_147749_1_, 3, p_147749_6_));
/*      */     
/* 3862 */     tessellator.func_78386_a(f4, f4, f4);
/* 3863 */     func_147798_e(p_147749_1_, -0.5D, -0.5D, -0.5D, func_147787_a(p_147749_1_, 4, p_147749_6_));
/*      */     
/* 3865 */     tessellator.func_78386_a(f4, f4, f4);
/* 3866 */     func_147764_f(p_147749_1_, -0.5D, -0.5D, -0.5D, func_147787_a(p_147749_1_, 5, p_147749_6_));
/* 3867 */     tessellator.func_78381_a();
/*      */   }
/*      */   
/*      */   public boolean func_147784_q(Block p_147784_1_, int p_147784_2_, int p_147784_3_, int p_147784_4_) {
/* 3871 */     int i = p_147784_1_.func_149720_d(this.field_147845_a, p_147784_2_, p_147784_3_, p_147784_4_);
/* 3872 */     float f1 = (i >> 16 & 0xFF) / 255.0F;
/* 3873 */     float f2 = (i >> 8 & 0xFF) / 255.0F;
/* 3874 */     float f3 = (i & 0xFF) / 255.0F;
/*      */     
/* 3876 */     if (EntityRenderer.field_78517_a) {
/* 3877 */       float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
/* 3878 */       float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
/* 3879 */       float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
/*      */       
/* 3881 */       f1 = f4;
/* 3882 */       f2 = f5;
/* 3883 */       f3 = f6;
/*      */     } 
/*      */     
/* 3886 */     if (Minecraft.func_71379_u() && p_147784_1_.func_149750_m() == 0) {
/* 3887 */       if (this.field_147849_o) {
/* 3888 */         return func_147808_b(p_147784_1_, p_147784_2_, p_147784_3_, p_147784_4_, f1, f2, f3);
/*      */       }
/* 3890 */       return func_147751_a(p_147784_1_, p_147784_2_, p_147784_3_, p_147784_4_, f1, f2, f3);
/*      */     } 
/*      */     
/* 3893 */     return func_147736_d(p_147784_1_, p_147784_2_, p_147784_3_, p_147784_4_, f1, f2, f3);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_147742_r(Block p_147742_1_, int p_147742_2_, int p_147742_3_, int p_147742_4_) {
/* 3898 */     int i = this.field_147845_a.func_72805_g(p_147742_2_, p_147742_3_, p_147742_4_);
/* 3899 */     int j = i & 0xC;
/*      */     
/* 3901 */     if (j == 4) {
/* 3902 */       this.field_147875_q = 1;
/* 3903 */       this.field_147873_r = 1;
/* 3904 */       this.field_147867_u = 1;
/* 3905 */       this.field_147865_v = 1;
/* 3906 */     } else if (j == 8) {
/* 3907 */       this.field_147871_s = 1;
/* 3908 */       this.field_147869_t = 1;
/*      */     } 
/*      */     
/* 3911 */     boolean bool = func_147784_q(p_147742_1_, p_147742_2_, p_147742_3_, p_147742_4_);
/*      */     
/* 3913 */     this.field_147871_s = 0;
/* 3914 */     this.field_147875_q = 0;
/* 3915 */     this.field_147873_r = 0;
/* 3916 */     this.field_147869_t = 0;
/* 3917 */     this.field_147867_u = 0;
/* 3918 */     this.field_147865_v = 0;
/*      */     
/* 3920 */     return bool;
/*      */   }
/*      */   
/*      */   public boolean func_147779_s(Block p_147779_1_, int p_147779_2_, int p_147779_3_, int p_147779_4_) {
/* 3924 */     int i = this.field_147845_a.func_72805_g(p_147779_2_, p_147779_3_, p_147779_4_);
/*      */     
/* 3926 */     if (i == 3) {
/* 3927 */       this.field_147875_q = 1;
/* 3928 */       this.field_147873_r = 1;
/* 3929 */       this.field_147867_u = 1;
/* 3930 */       this.field_147865_v = 1;
/* 3931 */     } else if (i == 4) {
/* 3932 */       this.field_147871_s = 1;
/* 3933 */       this.field_147869_t = 1;
/*      */     } 
/*      */     
/* 3936 */     boolean bool = func_147784_q(p_147779_1_, p_147779_2_, p_147779_3_, p_147779_4_);
/*      */     
/* 3938 */     this.field_147871_s = 0;
/* 3939 */     this.field_147875_q = 0;
/* 3940 */     this.field_147873_r = 0;
/* 3941 */     this.field_147869_t = 0;
/* 3942 */     this.field_147867_u = 0;
/* 3943 */     this.field_147865_v = 0;
/*      */     
/* 3945 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_147751_a(Block p_147751_1_, int p_147751_2_, int p_147751_3_, int p_147751_4_, float p_147751_5_, float p_147751_6_, float p_147751_7_) {
/* 3963 */     this.field_147863_w = true;
/* 3964 */     boolean bool1 = false;
/* 3965 */     float f1 = 0.0F;
/* 3966 */     float f2 = 0.0F;
/* 3967 */     float f3 = 0.0F;
/* 3968 */     float f4 = 0.0F;
/*      */     
/* 3970 */     boolean bool2 = true;
/*      */     
/* 3972 */     int i = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_);
/*      */     
/* 3974 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 3975 */     tessellator.func_78380_c(983055);
/*      */     
/* 3977 */     if (func_147745_b(p_147751_1_).func_94215_i().equals("grass_top")) { bool2 = false; }
/* 3978 */     else if (func_147744_b()) { bool2 = false; }
/*      */     
/* 3980 */     if (this.field_147837_f || p_147751_1_.func_149646_a(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_, 0)) {
/* 3981 */       if (this.field_147855_j <= 0.0D) p_147751_3_--;
/*      */       
/* 3983 */       this.field_147831_S = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_);
/* 3984 */       this.field_147825_U = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ - 1);
/* 3985 */       this.field_147828_V = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ + 1);
/* 3986 */       this.field_147835_X = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_);
/*      */       
/* 3988 */       this.field_147886_y = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_).func_149685_I();
/* 3989 */       this.field_147814_A = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ - 1).func_149685_I();
/* 3990 */       this.field_147815_B = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ + 1).func_149685_I();
/* 3991 */       this.field_147810_D = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_).func_149685_I();
/*      */       
/* 3993 */       boolean bool3 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_ - 1, p_147751_4_).func_149751_l();
/* 3994 */       boolean bool4 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_ - 1, p_147751_4_).func_149751_l();
/* 3995 */       boolean bool5 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_ + 1).func_149751_l();
/* 3996 */       boolean bool6 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_ - 1).func_149751_l();
/*      */       
/* 3998 */       if (bool6 || bool4) {
/* 3999 */         this.field_147888_x = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_ - 1).func_149685_I();
/* 4000 */         this.field_147832_R = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_ - 1);
/*      */       } else {
/* 4002 */         this.field_147888_x = this.field_147886_y;
/* 4003 */         this.field_147832_R = this.field_147831_S;
/*      */       } 
/* 4005 */       if (bool5 || bool4) {
/* 4006 */         this.field_147884_z = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_ + 1).func_149685_I();
/* 4007 */         this.field_147826_T = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_ + 1);
/*      */       } else {
/* 4009 */         this.field_147884_z = this.field_147886_y;
/* 4010 */         this.field_147826_T = this.field_147831_S;
/*      */       } 
/* 4012 */       if (bool6 || bool3) {
/* 4013 */         this.field_147816_C = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_ - 1).func_149685_I();
/* 4014 */         this.field_147827_W = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_ - 1);
/*      */       } else {
/* 4016 */         this.field_147816_C = this.field_147810_D;
/* 4017 */         this.field_147827_W = this.field_147835_X;
/*      */       } 
/* 4019 */       if (bool5 || bool3) {
/* 4020 */         this.field_147811_E = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_ + 1).func_149685_I();
/* 4021 */         this.field_147834_Y = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_ + 1);
/*      */       } else {
/* 4023 */         this.field_147811_E = this.field_147810_D;
/* 4024 */         this.field_147834_Y = this.field_147835_X;
/*      */       } 
/* 4026 */       if (this.field_147855_j <= 0.0D) p_147751_3_++;
/*      */       
/* 4028 */       int j = i;
/* 4029 */       if (this.field_147855_j <= 0.0D || !this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_).func_149662_c()) j = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_); 
/* 4030 */       float f = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_).func_149685_I();
/*      */       
/* 4032 */       f1 = (this.field_147884_z + this.field_147886_y + this.field_147815_B + f) / 4.0F;
/* 4033 */       f4 = (this.field_147815_B + f + this.field_147811_E + this.field_147810_D) / 4.0F;
/* 4034 */       f3 = (f + this.field_147814_A + this.field_147810_D + this.field_147816_C) / 4.0F;
/* 4035 */       f2 = (this.field_147886_y + this.field_147888_x + f + this.field_147814_A) / 4.0F;
/*      */       
/* 4037 */       this.field_147864_al = func_147778_a(this.field_147826_T, this.field_147831_S, this.field_147828_V, j);
/* 4038 */       this.field_147870_ao = func_147778_a(this.field_147828_V, this.field_147834_Y, this.field_147835_X, j);
/* 4039 */       this.field_147876_an = func_147778_a(this.field_147825_U, this.field_147835_X, this.field_147827_W, j);
/* 4040 */       this.field_147874_am = func_147778_a(this.field_147831_S, this.field_147832_R, this.field_147825_U, j);
/*      */       
/* 4042 */       if (bool2) {
/* 4043 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147751_5_ * 0.5F;
/* 4044 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147751_6_ * 0.5F;
/* 4045 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147751_7_ * 0.5F;
/*      */       } else {
/* 4047 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.5F;
/* 4048 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.5F;
/* 4049 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.5F;
/*      */       } 
/* 4051 */       this.field_147872_ap *= f1;
/* 4052 */       this.field_147846_at *= f1;
/* 4053 */       this.field_147854_ax *= f1;
/* 4054 */       this.field_147852_aq *= f2;
/* 4055 */       this.field_147860_au *= f2;
/* 4056 */       this.field_147841_ay *= f2;
/* 4057 */       this.field_147850_ar *= f3;
/* 4058 */       this.field_147858_av *= f3;
/* 4059 */       this.field_147839_az *= f3;
/* 4060 */       this.field_147848_as *= f4;
/* 4061 */       this.field_147856_aw *= f4;
/* 4062 */       this.field_147833_aA *= f4;
/*      */       
/* 4064 */       func_147768_a(p_147751_1_, p_147751_2_, p_147751_3_, p_147751_4_, func_147793_a(p_147751_1_, this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_, 0));
/* 4065 */       bool1 = true;
/*      */     } 
/* 4067 */     if (this.field_147837_f || p_147751_1_.func_149646_a(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_, 1)) {
/* 4068 */       if (this.field_147857_k >= 1.0D) p_147751_3_++;
/*      */       
/* 4070 */       this.field_147880_aa = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_);
/* 4071 */       this.field_147885_ae = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_);
/* 4072 */       this.field_147878_ac = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ - 1);
/* 4073 */       this.field_147887_af = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ + 1);
/*      */       
/* 4075 */       this.field_147813_G = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_).func_149685_I();
/* 4076 */       this.field_147824_K = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_).func_149685_I();
/* 4077 */       this.field_147822_I = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ - 1).func_149685_I();
/* 4078 */       this.field_147817_L = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ + 1).func_149685_I();
/*      */       
/* 4080 */       boolean bool3 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_ + 1, p_147751_4_).func_149751_l();
/* 4081 */       boolean bool4 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_ + 1, p_147751_4_).func_149751_l();
/* 4082 */       boolean bool5 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_ + 1).func_149751_l();
/* 4083 */       boolean bool6 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_ - 1).func_149751_l();
/*      */ 
/*      */       
/* 4086 */       if (bool6 || bool4) {
/* 4087 */         this.field_147812_F = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_ - 1).func_149685_I();
/* 4088 */         this.field_147836_Z = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_ - 1);
/*      */       } else {
/* 4090 */         this.field_147812_F = this.field_147813_G;
/* 4091 */         this.field_147836_Z = this.field_147880_aa;
/*      */       } 
/* 4093 */       if (bool6 || bool3) {
/* 4094 */         this.field_147823_J = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_ - 1).func_149685_I();
/* 4095 */         this.field_147879_ad = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_ - 1);
/*      */       } else {
/* 4097 */         this.field_147823_J = this.field_147824_K;
/* 4098 */         this.field_147879_ad = this.field_147885_ae;
/*      */       } 
/* 4100 */       if (bool5 || bool4) {
/* 4101 */         this.field_147821_H = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_ + 1).func_149685_I();
/* 4102 */         this.field_147881_ab = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_ + 1);
/*      */       } else {
/* 4104 */         this.field_147821_H = this.field_147813_G;
/* 4105 */         this.field_147881_ab = this.field_147880_aa;
/*      */       } 
/* 4107 */       if (bool5 || bool3) {
/* 4108 */         this.field_147818_M = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_ + 1).func_149685_I();
/* 4109 */         this.field_147882_ag = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_ + 1);
/*      */       } else {
/* 4111 */         this.field_147818_M = this.field_147824_K;
/* 4112 */         this.field_147882_ag = this.field_147885_ae;
/*      */       } 
/* 4114 */       if (this.field_147857_k >= 1.0D) p_147751_3_--;
/*      */       
/* 4116 */       int j = i;
/* 4117 */       if (this.field_147857_k >= 1.0D || !this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_).func_149662_c()) j = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_); 
/* 4118 */       float f = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_).func_149685_I();
/*      */       
/* 4120 */       f4 = (this.field_147821_H + this.field_147813_G + this.field_147817_L + f) / 4.0F;
/* 4121 */       f1 = (this.field_147817_L + f + this.field_147818_M + this.field_147824_K) / 4.0F;
/* 4122 */       f2 = (f + this.field_147822_I + this.field_147824_K + this.field_147823_J) / 4.0F;
/* 4123 */       f3 = (this.field_147813_G + this.field_147812_F + f + this.field_147822_I) / 4.0F;
/*      */ 
/*      */       
/* 4126 */       this.field_147870_ao = func_147778_a(this.field_147881_ab, this.field_147880_aa, this.field_147887_af, j);
/* 4127 */       this.field_147864_al = func_147778_a(this.field_147887_af, this.field_147882_ag, this.field_147885_ae, j);
/* 4128 */       this.field_147874_am = func_147778_a(this.field_147878_ac, this.field_147885_ae, this.field_147879_ad, j);
/* 4129 */       this.field_147876_an = func_147778_a(this.field_147880_aa, this.field_147836_Z, this.field_147878_ac, j);
/*      */       
/* 4131 */       this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147751_5_;
/* 4132 */       this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147751_6_;
/* 4133 */       this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147751_7_;
/* 4134 */       this.field_147872_ap *= f1;
/* 4135 */       this.field_147846_at *= f1;
/* 4136 */       this.field_147854_ax *= f1;
/* 4137 */       this.field_147852_aq *= f2;
/* 4138 */       this.field_147860_au *= f2;
/* 4139 */       this.field_147841_ay *= f2;
/* 4140 */       this.field_147850_ar *= f3;
/* 4141 */       this.field_147858_av *= f3;
/* 4142 */       this.field_147839_az *= f3;
/* 4143 */       this.field_147848_as *= f4;
/* 4144 */       this.field_147856_aw *= f4;
/* 4145 */       this.field_147833_aA *= f4;
/* 4146 */       func_147806_b(p_147751_1_, p_147751_2_, p_147751_3_, p_147751_4_, func_147793_a(p_147751_1_, this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_, 1));
/* 4147 */       bool1 = true;
/*      */     } 
/*      */     
/* 4150 */     if (this.field_147837_f || p_147751_1_.func_149646_a(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ - 1, 2)) {
/* 4151 */       if (this.field_147851_l <= 0.0D) p_147751_4_--; 
/* 4152 */       this.field_147819_N = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_).func_149685_I();
/* 4153 */       this.field_147814_A = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_).func_149685_I();
/* 4154 */       this.field_147822_I = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_).func_149685_I();
/* 4155 */       this.field_147820_O = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_).func_149685_I();
/*      */       
/* 4157 */       this.field_147883_ah = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_);
/* 4158 */       this.field_147825_U = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_);
/* 4159 */       this.field_147878_ac = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_);
/* 4160 */       this.field_147866_ai = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_);
/*      */       
/* 4162 */       boolean bool3 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_ - 1).func_149751_l();
/* 4163 */       boolean bool4 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_ - 1).func_149751_l();
/* 4164 */       boolean bool5 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_ - 1).func_149751_l();
/* 4165 */       boolean bool6 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_ - 1).func_149751_l();
/*      */       
/* 4167 */       if (bool4 || bool6) {
/* 4168 */         this.field_147888_x = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_ - 1, p_147751_4_).func_149685_I();
/* 4169 */         this.field_147832_R = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_ - 1, p_147751_4_);
/*      */       } else {
/* 4171 */         this.field_147888_x = this.field_147819_N;
/* 4172 */         this.field_147832_R = this.field_147883_ah;
/*      */       } 
/* 4174 */       if (bool4 || bool5) {
/* 4175 */         this.field_147812_F = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_ + 1, p_147751_4_).func_149685_I();
/* 4176 */         this.field_147836_Z = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_ + 1, p_147751_4_);
/*      */       } else {
/* 4178 */         this.field_147812_F = this.field_147819_N;
/* 4179 */         this.field_147836_Z = this.field_147883_ah;
/*      */       } 
/* 4181 */       if (bool3 || bool6) {
/* 4182 */         this.field_147816_C = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_ - 1, p_147751_4_).func_149685_I();
/* 4183 */         this.field_147827_W = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_ - 1, p_147751_4_);
/*      */       } else {
/* 4185 */         this.field_147816_C = this.field_147820_O;
/* 4186 */         this.field_147827_W = this.field_147866_ai;
/*      */       } 
/* 4188 */       if (bool3 || bool5) {
/* 4189 */         this.field_147823_J = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_ + 1, p_147751_4_).func_149685_I();
/* 4190 */         this.field_147879_ad = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_ + 1, p_147751_4_);
/*      */       } else {
/* 4192 */         this.field_147823_J = this.field_147820_O;
/* 4193 */         this.field_147879_ad = this.field_147866_ai;
/*      */       } 
/* 4195 */       if (this.field_147851_l <= 0.0D) p_147751_4_++; 
/* 4196 */       int j = i;
/* 4197 */       if (this.field_147851_l <= 0.0D || !this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ - 1).func_149662_c()) j = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ - 1); 
/* 4198 */       float f = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ - 1).func_149685_I();
/*      */ 
/*      */       
/* 4201 */       f1 = (this.field_147819_N + this.field_147812_F + f + this.field_147822_I) / 4.0F;
/* 4202 */       f2 = (f + this.field_147822_I + this.field_147820_O + this.field_147823_J) / 4.0F;
/* 4203 */       f3 = (this.field_147814_A + f + this.field_147816_C + this.field_147820_O) / 4.0F;
/* 4204 */       f4 = (this.field_147888_x + this.field_147819_N + this.field_147814_A + f) / 4.0F;
/*      */       
/* 4206 */       this.field_147864_al = func_147778_a(this.field_147883_ah, this.field_147836_Z, this.field_147878_ac, j);
/* 4207 */       this.field_147874_am = func_147778_a(this.field_147878_ac, this.field_147866_ai, this.field_147879_ad, j);
/* 4208 */       this.field_147876_an = func_147778_a(this.field_147825_U, this.field_147827_W, this.field_147866_ai, j);
/* 4209 */       this.field_147870_ao = func_147778_a(this.field_147832_R, this.field_147883_ah, this.field_147825_U, j);
/*      */ 
/*      */       
/* 4212 */       if (bool2) {
/* 4213 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147751_5_ * 0.8F;
/* 4214 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147751_6_ * 0.8F;
/* 4215 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147751_7_ * 0.8F;
/*      */       } else {
/* 4217 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.8F;
/* 4218 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.8F;
/* 4219 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.8F;
/*      */       } 
/* 4221 */       this.field_147872_ap *= f1;
/* 4222 */       this.field_147846_at *= f1;
/* 4223 */       this.field_147854_ax *= f1;
/* 4224 */       this.field_147852_aq *= f2;
/* 4225 */       this.field_147860_au *= f2;
/* 4226 */       this.field_147841_ay *= f2;
/* 4227 */       this.field_147850_ar *= f3;
/* 4228 */       this.field_147858_av *= f3;
/* 4229 */       this.field_147839_az *= f3;
/* 4230 */       this.field_147848_as *= f4;
/* 4231 */       this.field_147856_aw *= f4;
/* 4232 */       this.field_147833_aA *= f4;
/*      */       
/* 4234 */       IIcon iIcon = func_147793_a(p_147751_1_, this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_, 2);
/* 4235 */       func_147761_c(p_147751_1_, p_147751_2_, p_147751_3_, p_147751_4_, iIcon);
/*      */       
/* 4237 */       if (field_147843_b && iIcon.func_94215_i().equals("grass_side") && !func_147744_b()) {
/* 4238 */         this.field_147872_ap *= p_147751_5_;
/* 4239 */         this.field_147852_aq *= p_147751_5_;
/* 4240 */         this.field_147850_ar *= p_147751_5_;
/* 4241 */         this.field_147848_as *= p_147751_5_;
/* 4242 */         this.field_147846_at *= p_147751_6_;
/* 4243 */         this.field_147860_au *= p_147751_6_;
/* 4244 */         this.field_147858_av *= p_147751_6_;
/* 4245 */         this.field_147856_aw *= p_147751_6_;
/* 4246 */         this.field_147854_ax *= p_147751_7_;
/* 4247 */         this.field_147841_ay *= p_147751_7_;
/* 4248 */         this.field_147839_az *= p_147751_7_;
/* 4249 */         this.field_147833_aA *= p_147751_7_;
/* 4250 */         func_147761_c(p_147751_1_, p_147751_2_, p_147751_3_, p_147751_4_, BlockGrass.func_149990_e());
/*      */       } 
/*      */       
/* 4253 */       bool1 = true;
/*      */     } 
/* 4255 */     if (this.field_147837_f || p_147751_1_.func_149646_a(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ + 1, 3)) {
/* 4256 */       if (this.field_147853_m >= 1.0D) p_147751_4_++;
/*      */       
/* 4258 */       this.field_147830_P = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_).func_149685_I();
/* 4259 */       this.field_147829_Q = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_).func_149685_I();
/* 4260 */       this.field_147815_B = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_).func_149685_I();
/* 4261 */       this.field_147817_L = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_).func_149685_I();
/*      */       
/* 4263 */       this.field_147868_aj = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_);
/* 4264 */       this.field_147862_ak = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_);
/* 4265 */       this.field_147828_V = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_);
/* 4266 */       this.field_147887_af = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_);
/*      */       
/* 4268 */       boolean bool3 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_ + 1).func_149751_l();
/* 4269 */       boolean bool4 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_ + 1).func_149751_l();
/* 4270 */       boolean bool5 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_ + 1).func_149751_l();
/* 4271 */       boolean bool6 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_ + 1).func_149751_l();
/*      */       
/* 4273 */       if (bool4 || bool6) {
/* 4274 */         this.field_147884_z = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_ - 1, p_147751_4_).func_149685_I();
/* 4275 */         this.field_147826_T = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_ - 1, p_147751_4_);
/*      */       } else {
/* 4277 */         this.field_147884_z = this.field_147830_P;
/* 4278 */         this.field_147826_T = this.field_147868_aj;
/*      */       } 
/* 4280 */       if (bool4 || bool5) {
/* 4281 */         this.field_147821_H = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_ + 1, p_147751_4_).func_149685_I();
/* 4282 */         this.field_147881_ab = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_ + 1, p_147751_4_);
/*      */       } else {
/* 4284 */         this.field_147821_H = this.field_147830_P;
/* 4285 */         this.field_147881_ab = this.field_147868_aj;
/*      */       } 
/* 4287 */       if (bool3 || bool6) {
/* 4288 */         this.field_147811_E = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_ - 1, p_147751_4_).func_149685_I();
/* 4289 */         this.field_147834_Y = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_ - 1, p_147751_4_);
/*      */       } else {
/* 4291 */         this.field_147811_E = this.field_147829_Q;
/* 4292 */         this.field_147834_Y = this.field_147862_ak;
/*      */       } 
/* 4294 */       if (bool3 || bool5) {
/* 4295 */         this.field_147818_M = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_ + 1, p_147751_4_).func_149685_I();
/* 4296 */         this.field_147882_ag = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_ + 1, p_147751_4_);
/*      */       } else {
/* 4298 */         this.field_147818_M = this.field_147829_Q;
/* 4299 */         this.field_147882_ag = this.field_147862_ak;
/*      */       } 
/* 4301 */       if (this.field_147853_m >= 1.0D) p_147751_4_--; 
/* 4302 */       int j = i;
/* 4303 */       if (this.field_147853_m >= 1.0D || !this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ + 1).func_149662_c()) j = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ + 1); 
/* 4304 */       float f = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ + 1).func_149685_I();
/*      */ 
/*      */       
/* 4307 */       f1 = (this.field_147830_P + this.field_147821_H + f + this.field_147817_L) / 4.0F;
/* 4308 */       f4 = (f + this.field_147817_L + this.field_147829_Q + this.field_147818_M) / 4.0F;
/* 4309 */       f3 = (this.field_147815_B + f + this.field_147811_E + this.field_147829_Q) / 4.0F;
/* 4310 */       f2 = (this.field_147884_z + this.field_147830_P + this.field_147815_B + f) / 4.0F;
/*      */       
/* 4312 */       this.field_147864_al = func_147778_a(this.field_147868_aj, this.field_147881_ab, this.field_147887_af, j);
/* 4313 */       this.field_147870_ao = func_147778_a(this.field_147887_af, this.field_147862_ak, this.field_147882_ag, j);
/* 4314 */       this.field_147876_an = func_147778_a(this.field_147828_V, this.field_147834_Y, this.field_147862_ak, j);
/* 4315 */       this.field_147874_am = func_147778_a(this.field_147826_T, this.field_147868_aj, this.field_147828_V, j);
/*      */       
/* 4317 */       if (bool2) {
/* 4318 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147751_5_ * 0.8F;
/* 4319 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147751_6_ * 0.8F;
/* 4320 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147751_7_ * 0.8F;
/*      */       } else {
/* 4322 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.8F;
/* 4323 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.8F;
/* 4324 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.8F;
/*      */       } 
/* 4326 */       this.field_147872_ap *= f1;
/* 4327 */       this.field_147846_at *= f1;
/* 4328 */       this.field_147854_ax *= f1;
/* 4329 */       this.field_147852_aq *= f2;
/* 4330 */       this.field_147860_au *= f2;
/* 4331 */       this.field_147841_ay *= f2;
/* 4332 */       this.field_147850_ar *= f3;
/* 4333 */       this.field_147858_av *= f3;
/* 4334 */       this.field_147839_az *= f3;
/* 4335 */       this.field_147848_as *= f4;
/* 4336 */       this.field_147856_aw *= f4;
/* 4337 */       this.field_147833_aA *= f4;
/* 4338 */       IIcon iIcon = func_147793_a(p_147751_1_, this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_, 3);
/* 4339 */       func_147734_d(p_147751_1_, p_147751_2_, p_147751_3_, p_147751_4_, func_147793_a(p_147751_1_, this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_, 3));
/* 4340 */       if (field_147843_b && iIcon.func_94215_i().equals("grass_side") && !func_147744_b()) {
/* 4341 */         this.field_147872_ap *= p_147751_5_;
/* 4342 */         this.field_147852_aq *= p_147751_5_;
/* 4343 */         this.field_147850_ar *= p_147751_5_;
/* 4344 */         this.field_147848_as *= p_147751_5_;
/* 4345 */         this.field_147846_at *= p_147751_6_;
/* 4346 */         this.field_147860_au *= p_147751_6_;
/* 4347 */         this.field_147858_av *= p_147751_6_;
/* 4348 */         this.field_147856_aw *= p_147751_6_;
/* 4349 */         this.field_147854_ax *= p_147751_7_;
/* 4350 */         this.field_147841_ay *= p_147751_7_;
/* 4351 */         this.field_147839_az *= p_147751_7_;
/* 4352 */         this.field_147833_aA *= p_147751_7_;
/* 4353 */         func_147734_d(p_147751_1_, p_147751_2_, p_147751_3_, p_147751_4_, BlockGrass.func_149990_e());
/*      */       } 
/* 4355 */       bool1 = true;
/*      */     } 
/* 4357 */     if (this.field_147837_f || p_147751_1_.func_149646_a(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_, 4)) {
/* 4358 */       if (this.field_147859_h <= 0.0D) p_147751_2_--; 
/* 4359 */       this.field_147886_y = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_).func_149685_I();
/* 4360 */       this.field_147819_N = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ - 1).func_149685_I();
/* 4361 */       this.field_147830_P = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ + 1).func_149685_I();
/* 4362 */       this.field_147813_G = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_).func_149685_I();
/*      */       
/* 4364 */       this.field_147831_S = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_);
/* 4365 */       this.field_147883_ah = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ - 1);
/* 4366 */       this.field_147868_aj = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ + 1);
/* 4367 */       this.field_147880_aa = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_);
/*      */       
/* 4369 */       boolean bool3 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_ + 1, p_147751_4_).func_149751_l();
/* 4370 */       boolean bool4 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_ - 1, p_147751_4_).func_149751_l();
/* 4371 */       boolean bool5 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_ - 1).func_149751_l();
/* 4372 */       boolean bool6 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_ + 1).func_149751_l();
/*      */       
/* 4374 */       if (bool5 || bool4) {
/* 4375 */         this.field_147888_x = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_ - 1).func_149685_I();
/* 4376 */         this.field_147832_R = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_ - 1);
/*      */       } else {
/* 4378 */         this.field_147888_x = this.field_147819_N;
/* 4379 */         this.field_147832_R = this.field_147883_ah;
/*      */       } 
/* 4381 */       if (bool6 || bool4) {
/* 4382 */         this.field_147884_z = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_ + 1).func_149685_I();
/* 4383 */         this.field_147826_T = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_ + 1);
/*      */       } else {
/* 4385 */         this.field_147884_z = this.field_147830_P;
/* 4386 */         this.field_147826_T = this.field_147868_aj;
/*      */       } 
/* 4388 */       if (bool5 || bool3) {
/* 4389 */         this.field_147812_F = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_ - 1).func_149685_I();
/* 4390 */         this.field_147836_Z = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_ - 1);
/*      */       } else {
/* 4392 */         this.field_147812_F = this.field_147819_N;
/* 4393 */         this.field_147836_Z = this.field_147883_ah;
/*      */       } 
/* 4395 */       if (bool6 || bool3) {
/* 4396 */         this.field_147821_H = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_ + 1).func_149685_I();
/* 4397 */         this.field_147881_ab = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_ + 1);
/*      */       } else {
/* 4399 */         this.field_147821_H = this.field_147830_P;
/* 4400 */         this.field_147881_ab = this.field_147868_aj;
/*      */       } 
/* 4402 */       if (this.field_147859_h <= 0.0D) p_147751_2_++; 
/* 4403 */       int j = i;
/* 4404 */       if (this.field_147859_h <= 0.0D || !this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_).func_149662_c()) j = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_); 
/* 4405 */       float f = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_).func_149685_I();
/*      */ 
/*      */       
/* 4408 */       f4 = (this.field_147886_y + this.field_147884_z + f + this.field_147830_P) / 4.0F;
/* 4409 */       f1 = (f + this.field_147830_P + this.field_147813_G + this.field_147821_H) / 4.0F;
/* 4410 */       f2 = (this.field_147819_N + f + this.field_147812_F + this.field_147813_G) / 4.0F;
/* 4411 */       f3 = (this.field_147888_x + this.field_147886_y + this.field_147819_N + f) / 4.0F;
/*      */       
/* 4413 */       this.field_147870_ao = func_147778_a(this.field_147831_S, this.field_147826_T, this.field_147868_aj, j);
/* 4414 */       this.field_147864_al = func_147778_a(this.field_147868_aj, this.field_147880_aa, this.field_147881_ab, j);
/* 4415 */       this.field_147874_am = func_147778_a(this.field_147883_ah, this.field_147836_Z, this.field_147880_aa, j);
/* 4416 */       this.field_147876_an = func_147778_a(this.field_147832_R, this.field_147831_S, this.field_147883_ah, j);
/*      */ 
/*      */       
/* 4419 */       if (bool2) {
/* 4420 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147751_5_ * 0.6F;
/* 4421 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147751_6_ * 0.6F;
/* 4422 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147751_7_ * 0.6F;
/*      */       } else {
/* 4424 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.6F;
/* 4425 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.6F;
/* 4426 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.6F;
/*      */       } 
/* 4428 */       this.field_147872_ap *= f1;
/* 4429 */       this.field_147846_at *= f1;
/* 4430 */       this.field_147854_ax *= f1;
/* 4431 */       this.field_147852_aq *= f2;
/* 4432 */       this.field_147860_au *= f2;
/* 4433 */       this.field_147841_ay *= f2;
/* 4434 */       this.field_147850_ar *= f3;
/* 4435 */       this.field_147858_av *= f3;
/* 4436 */       this.field_147839_az *= f3;
/* 4437 */       this.field_147848_as *= f4;
/* 4438 */       this.field_147856_aw *= f4;
/* 4439 */       this.field_147833_aA *= f4;
/* 4440 */       IIcon iIcon = func_147793_a(p_147751_1_, this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_, 4);
/* 4441 */       func_147798_e(p_147751_1_, p_147751_2_, p_147751_3_, p_147751_4_, iIcon);
/* 4442 */       if (field_147843_b && iIcon.func_94215_i().equals("grass_side") && !func_147744_b()) {
/* 4443 */         this.field_147872_ap *= p_147751_5_;
/* 4444 */         this.field_147852_aq *= p_147751_5_;
/* 4445 */         this.field_147850_ar *= p_147751_5_;
/* 4446 */         this.field_147848_as *= p_147751_5_;
/* 4447 */         this.field_147846_at *= p_147751_6_;
/* 4448 */         this.field_147860_au *= p_147751_6_;
/* 4449 */         this.field_147858_av *= p_147751_6_;
/* 4450 */         this.field_147856_aw *= p_147751_6_;
/* 4451 */         this.field_147854_ax *= p_147751_7_;
/* 4452 */         this.field_147841_ay *= p_147751_7_;
/* 4453 */         this.field_147839_az *= p_147751_7_;
/* 4454 */         this.field_147833_aA *= p_147751_7_;
/* 4455 */         func_147798_e(p_147751_1_, p_147751_2_, p_147751_3_, p_147751_4_, BlockGrass.func_149990_e());
/*      */       } 
/* 4457 */       bool1 = true;
/*      */     } 
/* 4459 */     if (this.field_147837_f || p_147751_1_.func_149646_a(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_, 5)) {
/* 4460 */       if (this.field_147861_i >= 1.0D) p_147751_2_++; 
/* 4461 */       this.field_147810_D = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_).func_149685_I();
/* 4462 */       this.field_147820_O = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ - 1).func_149685_I();
/* 4463 */       this.field_147829_Q = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ + 1).func_149685_I();
/* 4464 */       this.field_147824_K = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_).func_149685_I();
/*      */       
/* 4466 */       this.field_147835_X = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_);
/* 4467 */       this.field_147866_ai = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ - 1);
/* 4468 */       this.field_147862_ak = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ + 1);
/* 4469 */       this.field_147885_ae = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_);
/*      */       
/* 4471 */       boolean bool3 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_ + 1, p_147751_4_).func_149751_l();
/* 4472 */       boolean bool4 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_ - 1, p_147751_4_).func_149751_l();
/* 4473 */       boolean bool5 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_ + 1).func_149751_l();
/* 4474 */       boolean bool6 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_ - 1).func_149751_l();
/*      */ 
/*      */       
/* 4477 */       if (bool4 || bool6) {
/* 4478 */         this.field_147816_C = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_ - 1).func_149685_I();
/* 4479 */         this.field_147827_W = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_ - 1);
/*      */       } else {
/* 4481 */         this.field_147816_C = this.field_147820_O;
/* 4482 */         this.field_147827_W = this.field_147866_ai;
/*      */       } 
/* 4484 */       if (bool4 || bool5) {
/* 4485 */         this.field_147811_E = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_ + 1).func_149685_I();
/* 4486 */         this.field_147834_Y = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_ + 1);
/*      */       } else {
/* 4488 */         this.field_147811_E = this.field_147829_Q;
/* 4489 */         this.field_147834_Y = this.field_147862_ak;
/*      */       } 
/* 4491 */       if (bool3 || bool6) {
/* 4492 */         this.field_147823_J = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_ - 1).func_149685_I();
/* 4493 */         this.field_147879_ad = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_ - 1);
/*      */       } else {
/* 4495 */         this.field_147823_J = this.field_147820_O;
/* 4496 */         this.field_147879_ad = this.field_147866_ai;
/*      */       } 
/* 4498 */       if (bool3 || bool5) {
/* 4499 */         this.field_147818_M = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_ + 1).func_149685_I();
/* 4500 */         this.field_147882_ag = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_ + 1);
/*      */       } else {
/* 4502 */         this.field_147818_M = this.field_147829_Q;
/* 4503 */         this.field_147882_ag = this.field_147862_ak;
/*      */       } 
/* 4505 */       if (this.field_147861_i >= 1.0D) p_147751_2_--; 
/* 4506 */       int j = i;
/* 4507 */       if (this.field_147861_i >= 1.0D || !this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_).func_149662_c()) j = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_); 
/* 4508 */       float f = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_).func_149685_I();
/*      */ 
/*      */       
/* 4511 */       f1 = (this.field_147810_D + this.field_147811_E + f + this.field_147829_Q) / 4.0F;
/* 4512 */       f2 = (this.field_147816_C + this.field_147810_D + this.field_147820_O + f) / 4.0F;
/* 4513 */       f3 = (this.field_147820_O + f + this.field_147823_J + this.field_147824_K) / 4.0F;
/* 4514 */       f4 = (f + this.field_147829_Q + this.field_147824_K + this.field_147818_M) / 4.0F;
/*      */       
/* 4516 */       this.field_147864_al = func_147778_a(this.field_147835_X, this.field_147834_Y, this.field_147862_ak, j);
/* 4517 */       this.field_147870_ao = func_147778_a(this.field_147862_ak, this.field_147885_ae, this.field_147882_ag, j);
/* 4518 */       this.field_147876_an = func_147778_a(this.field_147866_ai, this.field_147879_ad, this.field_147885_ae, j);
/* 4519 */       this.field_147874_am = func_147778_a(this.field_147827_W, this.field_147835_X, this.field_147866_ai, j);
/*      */       
/* 4521 */       if (bool2) {
/* 4522 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147751_5_ * 0.6F;
/* 4523 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147751_6_ * 0.6F;
/* 4524 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147751_7_ * 0.6F;
/*      */       } else {
/* 4526 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.6F;
/* 4527 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.6F;
/* 4528 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.6F;
/*      */       } 
/* 4530 */       this.field_147872_ap *= f1;
/* 4531 */       this.field_147846_at *= f1;
/* 4532 */       this.field_147854_ax *= f1;
/* 4533 */       this.field_147852_aq *= f2;
/* 4534 */       this.field_147860_au *= f2;
/* 4535 */       this.field_147841_ay *= f2;
/* 4536 */       this.field_147850_ar *= f3;
/* 4537 */       this.field_147858_av *= f3;
/* 4538 */       this.field_147839_az *= f3;
/* 4539 */       this.field_147848_as *= f4;
/* 4540 */       this.field_147856_aw *= f4;
/* 4541 */       this.field_147833_aA *= f4;
/*      */       
/* 4543 */       IIcon iIcon = func_147793_a(p_147751_1_, this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_, 5);
/* 4544 */       func_147764_f(p_147751_1_, p_147751_2_, p_147751_3_, p_147751_4_, iIcon);
/* 4545 */       if (field_147843_b && iIcon.func_94215_i().equals("grass_side") && !func_147744_b()) {
/* 4546 */         this.field_147872_ap *= p_147751_5_;
/* 4547 */         this.field_147852_aq *= p_147751_5_;
/* 4548 */         this.field_147850_ar *= p_147751_5_;
/* 4549 */         this.field_147848_as *= p_147751_5_;
/* 4550 */         this.field_147846_at *= p_147751_6_;
/* 4551 */         this.field_147860_au *= p_147751_6_;
/* 4552 */         this.field_147858_av *= p_147751_6_;
/* 4553 */         this.field_147856_aw *= p_147751_6_;
/* 4554 */         this.field_147854_ax *= p_147751_7_;
/* 4555 */         this.field_147841_ay *= p_147751_7_;
/* 4556 */         this.field_147839_az *= p_147751_7_;
/* 4557 */         this.field_147833_aA *= p_147751_7_;
/* 4558 */         func_147764_f(p_147751_1_, p_147751_2_, p_147751_3_, p_147751_4_, BlockGrass.func_149990_e());
/*      */       } 
/* 4560 */       bool1 = true;
/*      */     } 
/* 4562 */     this.field_147863_w = false;
/* 4563 */     return bool1;
/*      */   }
/*      */   
/*      */   public boolean func_147808_b(Block p_147808_1_, int p_147808_2_, int p_147808_3_, int p_147808_4_, float p_147808_5_, float p_147808_6_, float p_147808_7_) {
/* 4567 */     this.field_147863_w = true;
/* 4568 */     boolean bool1 = false;
/* 4569 */     float f1 = 0.0F;
/* 4570 */     float f2 = 0.0F;
/* 4571 */     float f3 = 0.0F;
/* 4572 */     float f4 = 0.0F;
/*      */     
/* 4574 */     boolean bool2 = true;
/*      */     
/* 4576 */     int i = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_);
/*      */     
/* 4578 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 4579 */     tessellator.func_78380_c(983055);
/*      */     
/* 4581 */     if (func_147745_b(p_147808_1_).func_94215_i().equals("grass_top")) { bool2 = false; }
/* 4582 */     else if (func_147744_b()) { bool2 = false; }
/*      */     
/* 4584 */     if (this.field_147837_f || p_147808_1_.func_149646_a(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_, 0)) {
/* 4585 */       if (this.field_147855_j <= 0.0D) p_147808_3_--;
/*      */       
/* 4587 */       this.field_147831_S = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_);
/* 4588 */       this.field_147825_U = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ - 1);
/* 4589 */       this.field_147828_V = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ + 1);
/* 4590 */       this.field_147835_X = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_);
/*      */       
/* 4592 */       this.field_147886_y = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_).func_149685_I();
/* 4593 */       this.field_147814_A = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ - 1).func_149685_I();
/* 4594 */       this.field_147815_B = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ + 1).func_149685_I();
/* 4595 */       this.field_147810_D = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_).func_149685_I();
/*      */       
/* 4597 */       boolean bool3 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_ - 1, p_147808_4_).func_149751_l();
/* 4598 */       boolean bool4 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_ - 1, p_147808_4_).func_149751_l();
/* 4599 */       boolean bool5 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_ + 1).func_149751_l();
/* 4600 */       boolean bool6 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_ - 1).func_149751_l();
/*      */       
/* 4602 */       if (bool6 || bool4) {
/* 4603 */         this.field_147888_x = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_ - 1).func_149685_I();
/* 4604 */         this.field_147832_R = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_ - 1);
/*      */       } else {
/* 4606 */         this.field_147888_x = this.field_147886_y;
/* 4607 */         this.field_147832_R = this.field_147831_S;
/*      */       } 
/* 4609 */       if (bool5 || bool4) {
/* 4610 */         this.field_147884_z = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_ + 1).func_149685_I();
/* 4611 */         this.field_147826_T = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_ + 1);
/*      */       } else {
/* 4613 */         this.field_147884_z = this.field_147886_y;
/* 4614 */         this.field_147826_T = this.field_147831_S;
/*      */       } 
/* 4616 */       if (bool6 || bool3) {
/* 4617 */         this.field_147816_C = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_ - 1).func_149685_I();
/* 4618 */         this.field_147827_W = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_ - 1);
/*      */       } else {
/* 4620 */         this.field_147816_C = this.field_147810_D;
/* 4621 */         this.field_147827_W = this.field_147835_X;
/*      */       } 
/* 4623 */       if (bool5 || bool3) {
/* 4624 */         this.field_147811_E = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_ + 1).func_149685_I();
/* 4625 */         this.field_147834_Y = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_ + 1);
/*      */       } else {
/* 4627 */         this.field_147811_E = this.field_147810_D;
/* 4628 */         this.field_147834_Y = this.field_147835_X;
/*      */       } 
/* 4630 */       if (this.field_147855_j <= 0.0D) p_147808_3_++;
/*      */       
/* 4632 */       int j = i;
/* 4633 */       if (this.field_147855_j <= 0.0D || !this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_).func_149662_c()) j = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_); 
/* 4634 */       float f = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_).func_149685_I();
/*      */       
/* 4636 */       f1 = (this.field_147884_z + this.field_147886_y + this.field_147815_B + f) / 4.0F;
/* 4637 */       f4 = (this.field_147815_B + f + this.field_147811_E + this.field_147810_D) / 4.0F;
/* 4638 */       f3 = (f + this.field_147814_A + this.field_147810_D + this.field_147816_C) / 4.0F;
/* 4639 */       f2 = (this.field_147886_y + this.field_147888_x + f + this.field_147814_A) / 4.0F;
/*      */       
/* 4641 */       this.field_147864_al = func_147778_a(this.field_147826_T, this.field_147831_S, this.field_147828_V, j);
/* 4642 */       this.field_147870_ao = func_147778_a(this.field_147828_V, this.field_147834_Y, this.field_147835_X, j);
/* 4643 */       this.field_147876_an = func_147778_a(this.field_147825_U, this.field_147835_X, this.field_147827_W, j);
/* 4644 */       this.field_147874_am = func_147778_a(this.field_147831_S, this.field_147832_R, this.field_147825_U, j);
/*      */       
/* 4646 */       if (bool2) {
/* 4647 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147808_5_ * 0.5F;
/* 4648 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147808_6_ * 0.5F;
/* 4649 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147808_7_ * 0.5F;
/*      */       } else {
/* 4651 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.5F;
/* 4652 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.5F;
/* 4653 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.5F;
/*      */       } 
/* 4655 */       this.field_147872_ap *= f1;
/* 4656 */       this.field_147846_at *= f1;
/* 4657 */       this.field_147854_ax *= f1;
/* 4658 */       this.field_147852_aq *= f2;
/* 4659 */       this.field_147860_au *= f2;
/* 4660 */       this.field_147841_ay *= f2;
/* 4661 */       this.field_147850_ar *= f3;
/* 4662 */       this.field_147858_av *= f3;
/* 4663 */       this.field_147839_az *= f3;
/* 4664 */       this.field_147848_as *= f4;
/* 4665 */       this.field_147856_aw *= f4;
/* 4666 */       this.field_147833_aA *= f4;
/*      */       
/* 4668 */       func_147768_a(p_147808_1_, p_147808_2_, p_147808_3_, p_147808_4_, func_147793_a(p_147808_1_, this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_, 0));
/* 4669 */       bool1 = true;
/*      */     } 
/* 4671 */     if (this.field_147837_f || p_147808_1_.func_149646_a(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_, 1)) {
/* 4672 */       if (this.field_147857_k >= 1.0D) p_147808_3_++;
/*      */       
/* 4674 */       this.field_147880_aa = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_);
/* 4675 */       this.field_147885_ae = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_);
/* 4676 */       this.field_147878_ac = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ - 1);
/* 4677 */       this.field_147887_af = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ + 1);
/*      */       
/* 4679 */       this.field_147813_G = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_).func_149685_I();
/* 4680 */       this.field_147824_K = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_).func_149685_I();
/* 4681 */       this.field_147822_I = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ - 1).func_149685_I();
/* 4682 */       this.field_147817_L = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ + 1).func_149685_I();
/*      */       
/* 4684 */       boolean bool3 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_ + 1, p_147808_4_).func_149751_l();
/* 4685 */       boolean bool4 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_ + 1, p_147808_4_).func_149751_l();
/* 4686 */       boolean bool5 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_ + 1).func_149751_l();
/* 4687 */       boolean bool6 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_ - 1).func_149751_l();
/*      */ 
/*      */       
/* 4690 */       if (bool6 || bool4) {
/* 4691 */         this.field_147812_F = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_ - 1).func_149685_I();
/* 4692 */         this.field_147836_Z = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_ - 1);
/*      */       } else {
/* 4694 */         this.field_147812_F = this.field_147813_G;
/* 4695 */         this.field_147836_Z = this.field_147880_aa;
/*      */       } 
/* 4697 */       if (bool6 || bool3) {
/* 4698 */         this.field_147823_J = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_ - 1).func_149685_I();
/* 4699 */         this.field_147879_ad = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_ - 1);
/*      */       } else {
/* 4701 */         this.field_147823_J = this.field_147824_K;
/* 4702 */         this.field_147879_ad = this.field_147885_ae;
/*      */       } 
/* 4704 */       if (bool5 || bool4) {
/* 4705 */         this.field_147821_H = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_ + 1).func_149685_I();
/* 4706 */         this.field_147881_ab = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_ + 1);
/*      */       } else {
/* 4708 */         this.field_147821_H = this.field_147813_G;
/* 4709 */         this.field_147881_ab = this.field_147880_aa;
/*      */       } 
/* 4711 */       if (bool5 || bool3) {
/* 4712 */         this.field_147818_M = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_ + 1).func_149685_I();
/* 4713 */         this.field_147882_ag = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_ + 1);
/*      */       } else {
/* 4715 */         this.field_147818_M = this.field_147824_K;
/* 4716 */         this.field_147882_ag = this.field_147885_ae;
/*      */       } 
/* 4718 */       if (this.field_147857_k >= 1.0D) p_147808_3_--;
/*      */       
/* 4720 */       int j = i;
/* 4721 */       if (this.field_147857_k >= 1.0D || !this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_).func_149662_c()) j = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_); 
/* 4722 */       float f = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_).func_149685_I();
/*      */       
/* 4724 */       f4 = (this.field_147821_H + this.field_147813_G + this.field_147817_L + f) / 4.0F;
/* 4725 */       f1 = (this.field_147817_L + f + this.field_147818_M + this.field_147824_K) / 4.0F;
/* 4726 */       f2 = (f + this.field_147822_I + this.field_147824_K + this.field_147823_J) / 4.0F;
/* 4727 */       f3 = (this.field_147813_G + this.field_147812_F + f + this.field_147822_I) / 4.0F;
/*      */ 
/*      */       
/* 4730 */       this.field_147870_ao = func_147778_a(this.field_147881_ab, this.field_147880_aa, this.field_147887_af, j);
/* 4731 */       this.field_147864_al = func_147778_a(this.field_147887_af, this.field_147882_ag, this.field_147885_ae, j);
/* 4732 */       this.field_147874_am = func_147778_a(this.field_147878_ac, this.field_147885_ae, this.field_147879_ad, j);
/* 4733 */       this.field_147876_an = func_147778_a(this.field_147880_aa, this.field_147836_Z, this.field_147878_ac, j);
/*      */       
/* 4735 */       this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147808_5_;
/* 4736 */       this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147808_6_;
/* 4737 */       this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147808_7_;
/* 4738 */       this.field_147872_ap *= f1;
/* 4739 */       this.field_147846_at *= f1;
/* 4740 */       this.field_147854_ax *= f1;
/* 4741 */       this.field_147852_aq *= f2;
/* 4742 */       this.field_147860_au *= f2;
/* 4743 */       this.field_147841_ay *= f2;
/* 4744 */       this.field_147850_ar *= f3;
/* 4745 */       this.field_147858_av *= f3;
/* 4746 */       this.field_147839_az *= f3;
/* 4747 */       this.field_147848_as *= f4;
/* 4748 */       this.field_147856_aw *= f4;
/* 4749 */       this.field_147833_aA *= f4;
/* 4750 */       func_147806_b(p_147808_1_, p_147808_2_, p_147808_3_, p_147808_4_, func_147793_a(p_147808_1_, this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_, 1));
/* 4751 */       bool1 = true;
/*      */     } 
/*      */     
/* 4754 */     if (this.field_147837_f || p_147808_1_.func_149646_a(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ - 1, 2)) {
/* 4755 */       if (this.field_147851_l <= 0.0D) p_147808_4_--; 
/* 4756 */       this.field_147819_N = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_).func_149685_I();
/* 4757 */       this.field_147814_A = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_).func_149685_I();
/* 4758 */       this.field_147822_I = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_).func_149685_I();
/* 4759 */       this.field_147820_O = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_).func_149685_I();
/*      */       
/* 4761 */       this.field_147883_ah = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_);
/* 4762 */       this.field_147825_U = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_);
/* 4763 */       this.field_147878_ac = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_);
/* 4764 */       this.field_147866_ai = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_);
/*      */       
/* 4766 */       boolean bool3 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_ - 1).func_149751_l();
/* 4767 */       boolean bool4 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_ - 1).func_149751_l();
/* 4768 */       boolean bool5 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_ - 1).func_149751_l();
/* 4769 */       boolean bool6 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_ - 1).func_149751_l();
/*      */       
/* 4771 */       if (bool4 || bool6) {
/* 4772 */         this.field_147888_x = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_ - 1, p_147808_4_).func_149685_I();
/* 4773 */         this.field_147832_R = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_ - 1, p_147808_4_);
/*      */       } else {
/* 4775 */         this.field_147888_x = this.field_147819_N;
/* 4776 */         this.field_147832_R = this.field_147883_ah;
/*      */       } 
/* 4778 */       if (bool4 || bool5) {
/* 4779 */         this.field_147812_F = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_ + 1, p_147808_4_).func_149685_I();
/* 4780 */         this.field_147836_Z = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_ + 1, p_147808_4_);
/*      */       } else {
/* 4782 */         this.field_147812_F = this.field_147819_N;
/* 4783 */         this.field_147836_Z = this.field_147883_ah;
/*      */       } 
/* 4785 */       if (bool3 || bool6) {
/* 4786 */         this.field_147816_C = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_ - 1, p_147808_4_).func_149685_I();
/* 4787 */         this.field_147827_W = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_ - 1, p_147808_4_);
/*      */       } else {
/* 4789 */         this.field_147816_C = this.field_147820_O;
/* 4790 */         this.field_147827_W = this.field_147866_ai;
/*      */       } 
/* 4792 */       if (bool3 || bool5) {
/* 4793 */         this.field_147823_J = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_ + 1, p_147808_4_).func_149685_I();
/* 4794 */         this.field_147879_ad = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_ + 1, p_147808_4_);
/*      */       } else {
/* 4796 */         this.field_147823_J = this.field_147820_O;
/* 4797 */         this.field_147879_ad = this.field_147866_ai;
/*      */       } 
/* 4799 */       if (this.field_147851_l <= 0.0D) p_147808_4_++; 
/* 4800 */       int j = i;
/* 4801 */       if (this.field_147851_l <= 0.0D || !this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ - 1).func_149662_c()) j = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ - 1); 
/* 4802 */       float f5 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ - 1).func_149685_I();
/*      */ 
/*      */       
/* 4805 */       float f6 = (this.field_147819_N + this.field_147812_F + f5 + this.field_147822_I) / 4.0F;
/* 4806 */       float f7 = (f5 + this.field_147822_I + this.field_147820_O + this.field_147823_J) / 4.0F;
/* 4807 */       float f8 = (this.field_147814_A + f5 + this.field_147816_C + this.field_147820_O) / 4.0F;
/* 4808 */       float f9 = (this.field_147888_x + this.field_147819_N + this.field_147814_A + f5) / 4.0F;
/* 4809 */       f1 = (float)(f6 * this.field_147857_k * (1.0D - this.field_147859_h) + f7 * this.field_147857_k * this.field_147859_h + f8 * (1.0D - this.field_147857_k) * this.field_147859_h + f9 * (1.0D - this.field_147857_k) * (1.0D - this.field_147859_h));
/*      */       
/* 4811 */       f2 = (float)(f6 * this.field_147857_k * (1.0D - this.field_147861_i) + f7 * this.field_147857_k * this.field_147861_i + f8 * (1.0D - this.field_147857_k) * this.field_147861_i + f9 * (1.0D - this.field_147857_k) * (1.0D - this.field_147861_i));
/*      */       
/* 4813 */       f3 = (float)(f6 * this.field_147855_j * (1.0D - this.field_147861_i) + f7 * this.field_147855_j * this.field_147861_i + f8 * (1.0D - this.field_147855_j) * this.field_147861_i + f9 * (1.0D - this.field_147855_j) * (1.0D - this.field_147861_i));
/*      */       
/* 4815 */       f4 = (float)(f6 * this.field_147855_j * (1.0D - this.field_147859_h) + f7 * this.field_147855_j * this.field_147859_h + f8 * (1.0D - this.field_147855_j) * this.field_147859_h + f9 * (1.0D - this.field_147855_j) * (1.0D - this.field_147859_h));
/*      */ 
/*      */       
/* 4818 */       int k = func_147778_a(this.field_147883_ah, this.field_147836_Z, this.field_147878_ac, j);
/* 4819 */       int m = func_147778_a(this.field_147878_ac, this.field_147866_ai, this.field_147879_ad, j);
/* 4820 */       int n = func_147778_a(this.field_147825_U, this.field_147827_W, this.field_147866_ai, j);
/* 4821 */       int i1 = func_147778_a(this.field_147832_R, this.field_147883_ah, this.field_147825_U, j);
/* 4822 */       this.field_147864_al = func_147727_a(k, m, n, i1, this.field_147857_k * (1.0D - this.field_147859_h), this.field_147857_k * this.field_147859_h, (1.0D - this.field_147857_k) * this.field_147859_h, (1.0D - this.field_147857_k) * (1.0D - this.field_147859_h));
/* 4823 */       this.field_147874_am = func_147727_a(k, m, n, i1, this.field_147857_k * (1.0D - this.field_147861_i), this.field_147857_k * this.field_147861_i, (1.0D - this.field_147857_k) * this.field_147861_i, (1.0D - this.field_147857_k) * (1.0D - this.field_147861_i));
/* 4824 */       this.field_147876_an = func_147727_a(k, m, n, i1, this.field_147855_j * (1.0D - this.field_147861_i), this.field_147855_j * this.field_147861_i, (1.0D - this.field_147855_j) * this.field_147861_i, (1.0D - this.field_147855_j) * (1.0D - this.field_147861_i));
/* 4825 */       this.field_147870_ao = func_147727_a(k, m, n, i1, this.field_147855_j * (1.0D - this.field_147859_h), this.field_147855_j * this.field_147859_h, (1.0D - this.field_147855_j) * this.field_147859_h, (1.0D - this.field_147855_j) * (1.0D - this.field_147859_h));
/*      */ 
/*      */       
/* 4828 */       if (bool2) {
/* 4829 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147808_5_ * 0.8F;
/* 4830 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147808_6_ * 0.8F;
/* 4831 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147808_7_ * 0.8F;
/*      */       } else {
/* 4833 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.8F;
/* 4834 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.8F;
/* 4835 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.8F;
/*      */       } 
/* 4837 */       this.field_147872_ap *= f1;
/* 4838 */       this.field_147846_at *= f1;
/* 4839 */       this.field_147854_ax *= f1;
/* 4840 */       this.field_147852_aq *= f2;
/* 4841 */       this.field_147860_au *= f2;
/* 4842 */       this.field_147841_ay *= f2;
/* 4843 */       this.field_147850_ar *= f3;
/* 4844 */       this.field_147858_av *= f3;
/* 4845 */       this.field_147839_az *= f3;
/* 4846 */       this.field_147848_as *= f4;
/* 4847 */       this.field_147856_aw *= f4;
/* 4848 */       this.field_147833_aA *= f4;
/*      */       
/* 4850 */       IIcon iIcon = func_147793_a(p_147808_1_, this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_, 2);
/* 4851 */       func_147761_c(p_147808_1_, p_147808_2_, p_147808_3_, p_147808_4_, iIcon);
/*      */       
/* 4853 */       if (field_147843_b && iIcon.func_94215_i().equals("grass_side") && !func_147744_b()) {
/* 4854 */         this.field_147872_ap *= p_147808_5_;
/* 4855 */         this.field_147852_aq *= p_147808_5_;
/* 4856 */         this.field_147850_ar *= p_147808_5_;
/* 4857 */         this.field_147848_as *= p_147808_5_;
/* 4858 */         this.field_147846_at *= p_147808_6_;
/* 4859 */         this.field_147860_au *= p_147808_6_;
/* 4860 */         this.field_147858_av *= p_147808_6_;
/* 4861 */         this.field_147856_aw *= p_147808_6_;
/* 4862 */         this.field_147854_ax *= p_147808_7_;
/* 4863 */         this.field_147841_ay *= p_147808_7_;
/* 4864 */         this.field_147839_az *= p_147808_7_;
/* 4865 */         this.field_147833_aA *= p_147808_7_;
/* 4866 */         func_147761_c(p_147808_1_, p_147808_2_, p_147808_3_, p_147808_4_, BlockGrass.func_149990_e());
/*      */       } 
/*      */       
/* 4869 */       bool1 = true;
/*      */     } 
/* 4871 */     if (this.field_147837_f || p_147808_1_.func_149646_a(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ + 1, 3)) {
/* 4872 */       if (this.field_147853_m >= 1.0D) p_147808_4_++;
/*      */       
/* 4874 */       this.field_147830_P = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_).func_149685_I();
/* 4875 */       this.field_147829_Q = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_).func_149685_I();
/* 4876 */       this.field_147815_B = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_).func_149685_I();
/* 4877 */       this.field_147817_L = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_).func_149685_I();
/*      */       
/* 4879 */       this.field_147868_aj = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_);
/* 4880 */       this.field_147862_ak = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_);
/* 4881 */       this.field_147828_V = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_);
/* 4882 */       this.field_147887_af = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_);
/*      */       
/* 4884 */       boolean bool3 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_ + 1).func_149751_l();
/* 4885 */       boolean bool4 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_ + 1).func_149751_l();
/* 4886 */       boolean bool5 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_ + 1).func_149751_l();
/* 4887 */       boolean bool6 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_ + 1).func_149751_l();
/*      */       
/* 4889 */       if (bool4 || bool6) {
/* 4890 */         this.field_147884_z = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_ - 1, p_147808_4_).func_149685_I();
/* 4891 */         this.field_147826_T = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_ - 1, p_147808_4_);
/*      */       } else {
/* 4893 */         this.field_147884_z = this.field_147830_P;
/* 4894 */         this.field_147826_T = this.field_147868_aj;
/*      */       } 
/* 4896 */       if (bool4 || bool5) {
/* 4897 */         this.field_147821_H = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_ + 1, p_147808_4_).func_149685_I();
/* 4898 */         this.field_147881_ab = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_ + 1, p_147808_4_);
/*      */       } else {
/* 4900 */         this.field_147821_H = this.field_147830_P;
/* 4901 */         this.field_147881_ab = this.field_147868_aj;
/*      */       } 
/* 4903 */       if (bool3 || bool6) {
/* 4904 */         this.field_147811_E = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_ - 1, p_147808_4_).func_149685_I();
/* 4905 */         this.field_147834_Y = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_ - 1, p_147808_4_);
/*      */       } else {
/* 4907 */         this.field_147811_E = this.field_147829_Q;
/* 4908 */         this.field_147834_Y = this.field_147862_ak;
/*      */       } 
/* 4910 */       if (bool3 || bool5) {
/* 4911 */         this.field_147818_M = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_ + 1, p_147808_4_).func_149685_I();
/* 4912 */         this.field_147882_ag = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_ + 1, p_147808_4_);
/*      */       } else {
/* 4914 */         this.field_147818_M = this.field_147829_Q;
/* 4915 */         this.field_147882_ag = this.field_147862_ak;
/*      */       } 
/* 4917 */       if (this.field_147853_m >= 1.0D) p_147808_4_--; 
/* 4918 */       int j = i;
/* 4919 */       if (this.field_147853_m >= 1.0D || !this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ + 1).func_149662_c()) j = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ + 1); 
/* 4920 */       float f5 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ + 1).func_149685_I();
/*      */ 
/*      */       
/* 4923 */       float f6 = (this.field_147830_P + this.field_147821_H + f5 + this.field_147817_L) / 4.0F;
/* 4924 */       float f7 = (f5 + this.field_147817_L + this.field_147829_Q + this.field_147818_M) / 4.0F;
/* 4925 */       float f8 = (this.field_147815_B + f5 + this.field_147811_E + this.field_147829_Q) / 4.0F;
/* 4926 */       float f9 = (this.field_147884_z + this.field_147830_P + this.field_147815_B + f5) / 4.0F;
/* 4927 */       f1 = (float)(f6 * this.field_147857_k * (1.0D - this.field_147859_h) + f7 * this.field_147857_k * this.field_147859_h + f8 * (1.0D - this.field_147857_k) * this.field_147859_h + f9 * (1.0D - this.field_147857_k) * (1.0D - this.field_147859_h));
/*      */       
/* 4929 */       f2 = (float)(f6 * this.field_147855_j * (1.0D - this.field_147859_h) + f7 * this.field_147855_j * this.field_147859_h + f8 * (1.0D - this.field_147855_j) * this.field_147859_h + f9 * (1.0D - this.field_147855_j) * (1.0D - this.field_147859_h));
/*      */       
/* 4931 */       f3 = (float)(f6 * this.field_147855_j * (1.0D - this.field_147861_i) + f7 * this.field_147855_j * this.field_147861_i + f8 * (1.0D - this.field_147855_j) * this.field_147861_i + f9 * (1.0D - this.field_147855_j) * (1.0D - this.field_147861_i));
/*      */       
/* 4933 */       f4 = (float)(f6 * this.field_147857_k * (1.0D - this.field_147861_i) + f7 * this.field_147857_k * this.field_147861_i + f8 * (1.0D - this.field_147857_k) * this.field_147861_i + f9 * (1.0D - this.field_147857_k) * (1.0D - this.field_147861_i));
/*      */ 
/*      */       
/* 4936 */       int k = func_147778_a(this.field_147868_aj, this.field_147881_ab, this.field_147887_af, j);
/* 4937 */       int m = func_147778_a(this.field_147887_af, this.field_147862_ak, this.field_147882_ag, j);
/* 4938 */       int n = func_147778_a(this.field_147828_V, this.field_147834_Y, this.field_147862_ak, j);
/* 4939 */       int i1 = func_147778_a(this.field_147826_T, this.field_147868_aj, this.field_147828_V, j);
/* 4940 */       this.field_147864_al = func_147727_a(k, i1, n, m, this.field_147857_k * (1.0D - this.field_147859_h), (1.0D - this.field_147857_k) * (1.0D - this.field_147859_h), (1.0D - this.field_147857_k) * this.field_147859_h, this.field_147857_k * this.field_147859_h);
/* 4941 */       this.field_147874_am = func_147727_a(k, i1, n, m, this.field_147855_j * (1.0D - this.field_147859_h), (1.0D - this.field_147855_j) * (1.0D - this.field_147859_h), (1.0D - this.field_147855_j) * this.field_147859_h, this.field_147855_j * this.field_147859_h);
/* 4942 */       this.field_147876_an = func_147727_a(k, i1, n, m, this.field_147855_j * (1.0D - this.field_147861_i), (1.0D - this.field_147855_j) * (1.0D - this.field_147861_i), (1.0D - this.field_147855_j) * this.field_147861_i, this.field_147855_j * this.field_147861_i);
/* 4943 */       this.field_147870_ao = func_147727_a(k, i1, n, m, this.field_147857_k * (1.0D - this.field_147861_i), (1.0D - this.field_147857_k) * (1.0D - this.field_147861_i), (1.0D - this.field_147857_k) * this.field_147861_i, this.field_147857_k * this.field_147861_i);
/*      */       
/* 4945 */       if (bool2) {
/* 4946 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147808_5_ * 0.8F;
/* 4947 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147808_6_ * 0.8F;
/* 4948 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147808_7_ * 0.8F;
/*      */       } else {
/* 4950 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.8F;
/* 4951 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.8F;
/* 4952 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.8F;
/*      */       } 
/* 4954 */       this.field_147872_ap *= f1;
/* 4955 */       this.field_147846_at *= f1;
/* 4956 */       this.field_147854_ax *= f1;
/* 4957 */       this.field_147852_aq *= f2;
/* 4958 */       this.field_147860_au *= f2;
/* 4959 */       this.field_147841_ay *= f2;
/* 4960 */       this.field_147850_ar *= f3;
/* 4961 */       this.field_147858_av *= f3;
/* 4962 */       this.field_147839_az *= f3;
/* 4963 */       this.field_147848_as *= f4;
/* 4964 */       this.field_147856_aw *= f4;
/* 4965 */       this.field_147833_aA *= f4;
/* 4966 */       IIcon iIcon = func_147793_a(p_147808_1_, this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_, 3);
/* 4967 */       func_147734_d(p_147808_1_, p_147808_2_, p_147808_3_, p_147808_4_, iIcon);
/* 4968 */       if (field_147843_b && iIcon.func_94215_i().equals("grass_side") && !func_147744_b()) {
/* 4969 */         this.field_147872_ap *= p_147808_5_;
/* 4970 */         this.field_147852_aq *= p_147808_5_;
/* 4971 */         this.field_147850_ar *= p_147808_5_;
/* 4972 */         this.field_147848_as *= p_147808_5_;
/* 4973 */         this.field_147846_at *= p_147808_6_;
/* 4974 */         this.field_147860_au *= p_147808_6_;
/* 4975 */         this.field_147858_av *= p_147808_6_;
/* 4976 */         this.field_147856_aw *= p_147808_6_;
/* 4977 */         this.field_147854_ax *= p_147808_7_;
/* 4978 */         this.field_147841_ay *= p_147808_7_;
/* 4979 */         this.field_147839_az *= p_147808_7_;
/* 4980 */         this.field_147833_aA *= p_147808_7_;
/* 4981 */         func_147734_d(p_147808_1_, p_147808_2_, p_147808_3_, p_147808_4_, BlockGrass.func_149990_e());
/*      */       } 
/* 4983 */       bool1 = true;
/*      */     } 
/* 4985 */     if (this.field_147837_f || p_147808_1_.func_149646_a(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_, 4)) {
/* 4986 */       if (this.field_147859_h <= 0.0D) p_147808_2_--; 
/* 4987 */       this.field_147886_y = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_).func_149685_I();
/* 4988 */       this.field_147819_N = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ - 1).func_149685_I();
/* 4989 */       this.field_147830_P = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ + 1).func_149685_I();
/* 4990 */       this.field_147813_G = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_).func_149685_I();
/*      */       
/* 4992 */       this.field_147831_S = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_);
/* 4993 */       this.field_147883_ah = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ - 1);
/* 4994 */       this.field_147868_aj = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ + 1);
/* 4995 */       this.field_147880_aa = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_);
/*      */       
/* 4997 */       boolean bool3 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_ + 1, p_147808_4_).func_149751_l();
/* 4998 */       boolean bool4 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_ - 1, p_147808_4_).func_149751_l();
/* 4999 */       boolean bool5 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_ - 1).func_149751_l();
/* 5000 */       boolean bool6 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_ + 1).func_149751_l();
/*      */       
/* 5002 */       if (bool5 || bool4) {
/* 5003 */         this.field_147888_x = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_ - 1).func_149685_I();
/* 5004 */         this.field_147832_R = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_ - 1);
/*      */       } else {
/* 5006 */         this.field_147888_x = this.field_147819_N;
/* 5007 */         this.field_147832_R = this.field_147883_ah;
/*      */       } 
/* 5009 */       if (bool6 || bool4) {
/* 5010 */         this.field_147884_z = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_ + 1).func_149685_I();
/* 5011 */         this.field_147826_T = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_ + 1);
/*      */       } else {
/* 5013 */         this.field_147884_z = this.field_147830_P;
/* 5014 */         this.field_147826_T = this.field_147868_aj;
/*      */       } 
/* 5016 */       if (bool5 || bool3) {
/* 5017 */         this.field_147812_F = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_ - 1).func_149685_I();
/* 5018 */         this.field_147836_Z = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_ - 1);
/*      */       } else {
/* 5020 */         this.field_147812_F = this.field_147819_N;
/* 5021 */         this.field_147836_Z = this.field_147883_ah;
/*      */       } 
/* 5023 */       if (bool6 || bool3) {
/* 5024 */         this.field_147821_H = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_ + 1).func_149685_I();
/* 5025 */         this.field_147881_ab = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_ + 1);
/*      */       } else {
/* 5027 */         this.field_147821_H = this.field_147830_P;
/* 5028 */         this.field_147881_ab = this.field_147868_aj;
/*      */       } 
/* 5030 */       if (this.field_147859_h <= 0.0D) p_147808_2_++; 
/* 5031 */       int j = i;
/* 5032 */       if (this.field_147859_h <= 0.0D || !this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_).func_149662_c()) j = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_); 
/* 5033 */       float f5 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_).func_149685_I();
/*      */ 
/*      */       
/* 5036 */       float f6 = (this.field_147886_y + this.field_147884_z + f5 + this.field_147830_P) / 4.0F;
/* 5037 */       float f7 = (f5 + this.field_147830_P + this.field_147813_G + this.field_147821_H) / 4.0F;
/* 5038 */       float f8 = (this.field_147819_N + f5 + this.field_147812_F + this.field_147813_G) / 4.0F;
/* 5039 */       float f9 = (this.field_147888_x + this.field_147886_y + this.field_147819_N + f5) / 4.0F;
/* 5040 */       f1 = (float)(f7 * this.field_147857_k * this.field_147853_m + f8 * this.field_147857_k * (1.0D - this.field_147853_m) + f9 * (1.0D - this.field_147857_k) * (1.0D - this.field_147853_m) + f6 * (1.0D - this.field_147857_k) * this.field_147853_m);
/*      */ 
/*      */       
/* 5043 */       f2 = (float)(f7 * this.field_147857_k * this.field_147851_l + f8 * this.field_147857_k * (1.0D - this.field_147851_l) + f9 * (1.0D - this.field_147857_k) * (1.0D - this.field_147851_l) + f6 * (1.0D - this.field_147857_k) * this.field_147851_l);
/*      */ 
/*      */       
/* 5046 */       f3 = (float)(f7 * this.field_147855_j * this.field_147851_l + f8 * this.field_147855_j * (1.0D - this.field_147851_l) + f9 * (1.0D - this.field_147855_j) * (1.0D - this.field_147851_l) + f6 * (1.0D - this.field_147855_j) * this.field_147851_l);
/*      */ 
/*      */       
/* 5049 */       f4 = (float)(f7 * this.field_147855_j * this.field_147853_m + f8 * this.field_147855_j * (1.0D - this.field_147853_m) + f9 * (1.0D - this.field_147855_j) * (1.0D - this.field_147853_m) + f6 * (1.0D - this.field_147855_j) * this.field_147853_m);
/*      */ 
/*      */ 
/*      */       
/* 5053 */       int k = func_147778_a(this.field_147831_S, this.field_147826_T, this.field_147868_aj, j);
/* 5054 */       int m = func_147778_a(this.field_147868_aj, this.field_147880_aa, this.field_147881_ab, j);
/* 5055 */       int n = func_147778_a(this.field_147883_ah, this.field_147836_Z, this.field_147880_aa, j);
/* 5056 */       int i1 = func_147778_a(this.field_147832_R, this.field_147831_S, this.field_147883_ah, j);
/* 5057 */       this.field_147864_al = func_147727_a(m, n, i1, k, this.field_147857_k * this.field_147853_m, this.field_147857_k * (1.0D - this.field_147853_m), (1.0D - this.field_147857_k) * (1.0D - this.field_147853_m), (1.0D - this.field_147857_k) * this.field_147853_m);
/* 5058 */       this.field_147874_am = func_147727_a(m, n, i1, k, this.field_147857_k * this.field_147851_l, this.field_147857_k * (1.0D - this.field_147851_l), (1.0D - this.field_147857_k) * (1.0D - this.field_147851_l), (1.0D - this.field_147857_k) * this.field_147851_l);
/* 5059 */       this.field_147876_an = func_147727_a(m, n, i1, k, this.field_147855_j * this.field_147851_l, this.field_147855_j * (1.0D - this.field_147851_l), (1.0D - this.field_147855_j) * (1.0D - this.field_147851_l), (1.0D - this.field_147855_j) * this.field_147851_l);
/* 5060 */       this.field_147870_ao = func_147727_a(m, n, i1, k, this.field_147855_j * this.field_147853_m, this.field_147855_j * (1.0D - this.field_147853_m), (1.0D - this.field_147855_j) * (1.0D - this.field_147853_m), (1.0D - this.field_147855_j) * this.field_147853_m);
/*      */ 
/*      */       
/* 5063 */       if (bool2) {
/* 5064 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147808_5_ * 0.6F;
/* 5065 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147808_6_ * 0.6F;
/* 5066 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147808_7_ * 0.6F;
/*      */       } else {
/* 5068 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.6F;
/* 5069 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.6F;
/* 5070 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.6F;
/*      */       } 
/* 5072 */       this.field_147872_ap *= f1;
/* 5073 */       this.field_147846_at *= f1;
/* 5074 */       this.field_147854_ax *= f1;
/* 5075 */       this.field_147852_aq *= f2;
/* 5076 */       this.field_147860_au *= f2;
/* 5077 */       this.field_147841_ay *= f2;
/* 5078 */       this.field_147850_ar *= f3;
/* 5079 */       this.field_147858_av *= f3;
/* 5080 */       this.field_147839_az *= f3;
/* 5081 */       this.field_147848_as *= f4;
/* 5082 */       this.field_147856_aw *= f4;
/* 5083 */       this.field_147833_aA *= f4;
/* 5084 */       IIcon iIcon = func_147793_a(p_147808_1_, this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_, 4);
/* 5085 */       func_147798_e(p_147808_1_, p_147808_2_, p_147808_3_, p_147808_4_, iIcon);
/* 5086 */       if (field_147843_b && iIcon.func_94215_i().equals("grass_side") && !func_147744_b()) {
/* 5087 */         this.field_147872_ap *= p_147808_5_;
/* 5088 */         this.field_147852_aq *= p_147808_5_;
/* 5089 */         this.field_147850_ar *= p_147808_5_;
/* 5090 */         this.field_147848_as *= p_147808_5_;
/* 5091 */         this.field_147846_at *= p_147808_6_;
/* 5092 */         this.field_147860_au *= p_147808_6_;
/* 5093 */         this.field_147858_av *= p_147808_6_;
/* 5094 */         this.field_147856_aw *= p_147808_6_;
/* 5095 */         this.field_147854_ax *= p_147808_7_;
/* 5096 */         this.field_147841_ay *= p_147808_7_;
/* 5097 */         this.field_147839_az *= p_147808_7_;
/* 5098 */         this.field_147833_aA *= p_147808_7_;
/* 5099 */         func_147798_e(p_147808_1_, p_147808_2_, p_147808_3_, p_147808_4_, BlockGrass.func_149990_e());
/*      */       } 
/* 5101 */       bool1 = true;
/*      */     } 
/* 5103 */     if (this.field_147837_f || p_147808_1_.func_149646_a(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_, 5)) {
/* 5104 */       if (this.field_147861_i >= 1.0D) p_147808_2_++; 
/* 5105 */       this.field_147810_D = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_).func_149685_I();
/* 5106 */       this.field_147820_O = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ - 1).func_149685_I();
/* 5107 */       this.field_147829_Q = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ + 1).func_149685_I();
/* 5108 */       this.field_147824_K = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_).func_149685_I();
/*      */       
/* 5110 */       this.field_147835_X = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_);
/* 5111 */       this.field_147866_ai = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ - 1);
/* 5112 */       this.field_147862_ak = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ + 1);
/* 5113 */       this.field_147885_ae = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_);
/*      */       
/* 5115 */       boolean bool3 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_ + 1, p_147808_4_).func_149751_l();
/* 5116 */       boolean bool4 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_ - 1, p_147808_4_).func_149751_l();
/* 5117 */       boolean bool5 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_ + 1).func_149751_l();
/* 5118 */       boolean bool6 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_ - 1).func_149751_l();
/*      */ 
/*      */       
/* 5121 */       if (bool4 || bool6) {
/* 5122 */         this.field_147816_C = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_ - 1).func_149685_I();
/* 5123 */         this.field_147827_W = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_ - 1);
/*      */       } else {
/* 5125 */         this.field_147816_C = this.field_147820_O;
/* 5126 */         this.field_147827_W = this.field_147866_ai;
/*      */       } 
/* 5128 */       if (bool4 || bool5) {
/* 5129 */         this.field_147811_E = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_ + 1).func_149685_I();
/* 5130 */         this.field_147834_Y = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_ + 1);
/*      */       } else {
/* 5132 */         this.field_147811_E = this.field_147829_Q;
/* 5133 */         this.field_147834_Y = this.field_147862_ak;
/*      */       } 
/* 5135 */       if (bool3 || bool6) {
/* 5136 */         this.field_147823_J = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_ - 1).func_149685_I();
/* 5137 */         this.field_147879_ad = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_ - 1);
/*      */       } else {
/* 5139 */         this.field_147823_J = this.field_147820_O;
/* 5140 */         this.field_147879_ad = this.field_147866_ai;
/*      */       } 
/* 5142 */       if (bool3 || bool5) {
/* 5143 */         this.field_147818_M = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_ + 1).func_149685_I();
/* 5144 */         this.field_147882_ag = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_ + 1);
/*      */       } else {
/* 5146 */         this.field_147818_M = this.field_147829_Q;
/* 5147 */         this.field_147882_ag = this.field_147862_ak;
/*      */       } 
/* 5149 */       if (this.field_147861_i >= 1.0D) p_147808_2_--; 
/* 5150 */       int j = i;
/* 5151 */       if (this.field_147861_i >= 1.0D || !this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_).func_149662_c()) j = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_); 
/* 5152 */       float f5 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_).func_149685_I();
/*      */ 
/*      */       
/* 5155 */       float f6 = (this.field_147810_D + this.field_147811_E + f5 + this.field_147829_Q) / 4.0F;
/* 5156 */       float f7 = (this.field_147816_C + this.field_147810_D + this.field_147820_O + f5) / 4.0F;
/* 5157 */       float f8 = (this.field_147820_O + f5 + this.field_147823_J + this.field_147824_K) / 4.0F;
/* 5158 */       float f9 = (f5 + this.field_147829_Q + this.field_147824_K + this.field_147818_M) / 4.0F;
/* 5159 */       f1 = (float)(f6 * (1.0D - this.field_147855_j) * this.field_147853_m + f7 * (1.0D - this.field_147855_j) * (1.0D - this.field_147853_m) + f8 * this.field_147855_j * (1.0D - this.field_147853_m) + f9 * this.field_147855_j * this.field_147853_m);
/*      */ 
/*      */       
/* 5162 */       f2 = (float)(f6 * (1.0D - this.field_147855_j) * this.field_147851_l + f7 * (1.0D - this.field_147855_j) * (1.0D - this.field_147851_l) + f8 * this.field_147855_j * (1.0D - this.field_147851_l) + f9 * this.field_147855_j * this.field_147851_l);
/*      */ 
/*      */       
/* 5165 */       f3 = (float)(f6 * (1.0D - this.field_147857_k) * this.field_147851_l + f7 * (1.0D - this.field_147857_k) * (1.0D - this.field_147851_l) + f8 * this.field_147857_k * (1.0D - this.field_147851_l) + f9 * this.field_147857_k * this.field_147851_l);
/*      */ 
/*      */       
/* 5168 */       f4 = (float)(f6 * (1.0D - this.field_147857_k) * this.field_147853_m + f7 * (1.0D - this.field_147857_k) * (1.0D - this.field_147853_m) + f8 * this.field_147857_k * (1.0D - this.field_147853_m) + f9 * this.field_147857_k * this.field_147853_m);
/*      */ 
/*      */ 
/*      */       
/* 5172 */       int k = func_147778_a(this.field_147835_X, this.field_147834_Y, this.field_147862_ak, j);
/* 5173 */       int m = func_147778_a(this.field_147862_ak, this.field_147885_ae, this.field_147882_ag, j);
/* 5174 */       int n = func_147778_a(this.field_147866_ai, this.field_147879_ad, this.field_147885_ae, j);
/* 5175 */       int i1 = func_147778_a(this.field_147827_W, this.field_147835_X, this.field_147866_ai, j);
/* 5176 */       this.field_147864_al = func_147727_a(k, i1, n, m, (1.0D - this.field_147855_j) * this.field_147853_m, (1.0D - this.field_147855_j) * (1.0D - this.field_147853_m), this.field_147855_j * (1.0D - this.field_147853_m), this.field_147855_j * this.field_147853_m);
/* 5177 */       this.field_147874_am = func_147727_a(k, i1, n, m, (1.0D - this.field_147855_j) * this.field_147851_l, (1.0D - this.field_147855_j) * (1.0D - this.field_147851_l), this.field_147855_j * (1.0D - this.field_147851_l), this.field_147855_j * this.field_147851_l);
/* 5178 */       this.field_147876_an = func_147727_a(k, i1, n, m, (1.0D - this.field_147857_k) * this.field_147851_l, (1.0D - this.field_147857_k) * (1.0D - this.field_147851_l), this.field_147857_k * (1.0D - this.field_147851_l), this.field_147857_k * this.field_147851_l);
/* 5179 */       this.field_147870_ao = func_147727_a(k, i1, n, m, (1.0D - this.field_147857_k) * this.field_147853_m, (1.0D - this.field_147857_k) * (1.0D - this.field_147853_m), this.field_147857_k * (1.0D - this.field_147853_m), this.field_147857_k * this.field_147853_m);
/*      */       
/* 5181 */       if (bool2) {
/* 5182 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147808_5_ * 0.6F;
/* 5183 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147808_6_ * 0.6F;
/* 5184 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147808_7_ * 0.6F;
/*      */       } else {
/* 5186 */         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.6F;
/* 5187 */         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.6F;
/* 5188 */         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.6F;
/*      */       } 
/* 5190 */       this.field_147872_ap *= f1;
/* 5191 */       this.field_147846_at *= f1;
/* 5192 */       this.field_147854_ax *= f1;
/* 5193 */       this.field_147852_aq *= f2;
/* 5194 */       this.field_147860_au *= f2;
/* 5195 */       this.field_147841_ay *= f2;
/* 5196 */       this.field_147850_ar *= f3;
/* 5197 */       this.field_147858_av *= f3;
/* 5198 */       this.field_147839_az *= f3;
/* 5199 */       this.field_147848_as *= f4;
/* 5200 */       this.field_147856_aw *= f4;
/* 5201 */       this.field_147833_aA *= f4;
/*      */       
/* 5203 */       IIcon iIcon = func_147793_a(p_147808_1_, this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_, 5);
/* 5204 */       func_147764_f(p_147808_1_, p_147808_2_, p_147808_3_, p_147808_4_, iIcon);
/* 5205 */       if (field_147843_b && iIcon.func_94215_i().equals("grass_side") && !func_147744_b()) {
/* 5206 */         this.field_147872_ap *= p_147808_5_;
/* 5207 */         this.field_147852_aq *= p_147808_5_;
/* 5208 */         this.field_147850_ar *= p_147808_5_;
/* 5209 */         this.field_147848_as *= p_147808_5_;
/* 5210 */         this.field_147846_at *= p_147808_6_;
/* 5211 */         this.field_147860_au *= p_147808_6_;
/* 5212 */         this.field_147858_av *= p_147808_6_;
/* 5213 */         this.field_147856_aw *= p_147808_6_;
/* 5214 */         this.field_147854_ax *= p_147808_7_;
/* 5215 */         this.field_147841_ay *= p_147808_7_;
/* 5216 */         this.field_147839_az *= p_147808_7_;
/* 5217 */         this.field_147833_aA *= p_147808_7_;
/* 5218 */         func_147764_f(p_147808_1_, p_147808_2_, p_147808_3_, p_147808_4_, BlockGrass.func_149990_e());
/*      */       } 
/* 5220 */       bool1 = true;
/*      */     } 
/* 5222 */     this.field_147863_w = false;
/* 5223 */     return bool1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int func_147778_a(int p_147778_1_, int p_147778_2_, int p_147778_3_, int p_147778_4_) {
/* 5231 */     if (p_147778_1_ == 0) p_147778_1_ = p_147778_4_; 
/* 5232 */     if (p_147778_2_ == 0) p_147778_2_ = p_147778_4_; 
/* 5233 */     if (p_147778_3_ == 0) p_147778_3_ = p_147778_4_; 
/* 5234 */     return p_147778_1_ + p_147778_2_ + p_147778_3_ + p_147778_4_ >> 2 & 0xFF00FF;
/*      */   }
/*      */ 
/*      */   
/*      */   public int func_147727_a(int p_147727_1_, int p_147727_2_, int p_147727_3_, int p_147727_4_, double p_147727_5_, double p_147727_7_, double p_147727_9_, double p_147727_11_) {
/* 5239 */     int i = (int)((p_147727_1_ >> 16 & 0xFF) * p_147727_5_ + (p_147727_2_ >> 16 & 0xFF) * p_147727_7_ + (p_147727_3_ >> 16 & 0xFF) * p_147727_9_ + (p_147727_4_ >> 16 & 0xFF) * p_147727_11_) & 0xFF;
/* 5240 */     int j = (int)((p_147727_1_ & 0xFF) * p_147727_5_ + (p_147727_2_ & 0xFF) * p_147727_7_ + (p_147727_3_ & 0xFF) * p_147727_9_ + (p_147727_4_ & 0xFF) * p_147727_11_) & 0xFF;
/* 5241 */     return i << 16 | j;
/*      */   }
/*      */   
/*      */   public boolean func_147736_d(Block p_147736_1_, int p_147736_2_, int p_147736_3_, int p_147736_4_, float p_147736_5_, float p_147736_6_, float p_147736_7_) {
/* 5245 */     this.field_147863_w = false;
/*      */     
/* 5247 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 5249 */     boolean bool = false;
/* 5250 */     float f1 = 0.5F;
/* 5251 */     float f2 = 1.0F;
/* 5252 */     float f3 = 0.8F;
/* 5253 */     float f4 = 0.6F;
/*      */     
/* 5255 */     float f5 = f2 * p_147736_5_;
/* 5256 */     float f6 = f2 * p_147736_6_;
/* 5257 */     float f7 = f2 * p_147736_7_;
/*      */     
/* 5259 */     float f8 = f1;
/* 5260 */     float f9 = f3;
/* 5261 */     float f10 = f4;
/*      */     
/* 5263 */     float f11 = f1;
/* 5264 */     float f12 = f3;
/* 5265 */     float f13 = f4;
/*      */     
/* 5267 */     float f14 = f1;
/* 5268 */     float f15 = f3;
/* 5269 */     float f16 = f4;
/*      */     
/* 5271 */     if (p_147736_1_ != Blocks.field_150349_c) {
/* 5272 */       f8 *= p_147736_5_;
/* 5273 */       f9 *= p_147736_5_;
/* 5274 */       f10 *= p_147736_5_;
/*      */       
/* 5276 */       f11 *= p_147736_6_;
/* 5277 */       f12 *= p_147736_6_;
/* 5278 */       f13 *= p_147736_6_;
/*      */       
/* 5280 */       f14 *= p_147736_7_;
/* 5281 */       f15 *= p_147736_7_;
/* 5282 */       f16 *= p_147736_7_;
/*      */     } 
/*      */ 
/*      */     
/* 5286 */     int i = p_147736_1_.func_149677_c(this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_);
/*      */     
/* 5288 */     if (this.field_147837_f || p_147736_1_.func_149646_a(this.field_147845_a, p_147736_2_, p_147736_3_ - 1, p_147736_4_, 0)) {
/* 5289 */       tessellator.func_78380_c((this.field_147855_j > 0.0D) ? i : p_147736_1_.func_149677_c(this.field_147845_a, p_147736_2_, p_147736_3_ - 1, p_147736_4_));
/* 5290 */       tessellator.func_78386_a(f8, f11, f14);
/*      */       
/* 5292 */       func_147768_a(p_147736_1_, p_147736_2_, p_147736_3_, p_147736_4_, func_147793_a(p_147736_1_, this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_, 0));
/* 5293 */       bool = true;
/*      */     } 
/*      */     
/* 5296 */     if (this.field_147837_f || p_147736_1_.func_149646_a(this.field_147845_a, p_147736_2_, p_147736_3_ + 1, p_147736_4_, 1)) {
/* 5297 */       tessellator.func_78380_c((this.field_147857_k < 1.0D) ? i : p_147736_1_.func_149677_c(this.field_147845_a, p_147736_2_, p_147736_3_ + 1, p_147736_4_));
/* 5298 */       tessellator.func_78386_a(f5, f6, f7);
/*      */       
/* 5300 */       func_147806_b(p_147736_1_, p_147736_2_, p_147736_3_, p_147736_4_, func_147793_a(p_147736_1_, this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_, 1));
/* 5301 */       bool = true;
/*      */     } 
/*      */     
/* 5304 */     if (this.field_147837_f || p_147736_1_.func_149646_a(this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_ - 1, 2)) {
/* 5305 */       tessellator.func_78380_c((this.field_147851_l > 0.0D) ? i : p_147736_1_.func_149677_c(this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_ - 1));
/* 5306 */       tessellator.func_78386_a(f9, f12, f15);
/*      */       
/* 5308 */       IIcon iIcon = func_147793_a(p_147736_1_, this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_, 2);
/* 5309 */       func_147761_c(p_147736_1_, p_147736_2_, p_147736_3_, p_147736_4_, iIcon);
/* 5310 */       if (field_147843_b && iIcon.func_94215_i().equals("grass_side") && !func_147744_b()) {
/* 5311 */         tessellator.func_78386_a(f9 * p_147736_5_, f12 * p_147736_6_, f15 * p_147736_7_);
/* 5312 */         func_147761_c(p_147736_1_, p_147736_2_, p_147736_3_, p_147736_4_, BlockGrass.func_149990_e());
/*      */       } 
/* 5314 */       bool = true;
/*      */     } 
/*      */     
/* 5317 */     if (this.field_147837_f || p_147736_1_.func_149646_a(this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_ + 1, 3)) {
/* 5318 */       tessellator.func_78380_c((this.field_147853_m < 1.0D) ? i : p_147736_1_.func_149677_c(this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_ + 1));
/* 5319 */       tessellator.func_78386_a(f9, f12, f15);
/*      */       
/* 5321 */       IIcon iIcon = func_147793_a(p_147736_1_, this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_, 3);
/* 5322 */       func_147734_d(p_147736_1_, p_147736_2_, p_147736_3_, p_147736_4_, iIcon);
/* 5323 */       if (field_147843_b && iIcon.func_94215_i().equals("grass_side") && !func_147744_b()) {
/* 5324 */         tessellator.func_78386_a(f9 * p_147736_5_, f12 * p_147736_6_, f15 * p_147736_7_);
/* 5325 */         func_147734_d(p_147736_1_, p_147736_2_, p_147736_3_, p_147736_4_, BlockGrass.func_149990_e());
/*      */       } 
/* 5327 */       bool = true;
/*      */     } 
/*      */     
/* 5330 */     if (this.field_147837_f || p_147736_1_.func_149646_a(this.field_147845_a, p_147736_2_ - 1, p_147736_3_, p_147736_4_, 4)) {
/* 5331 */       tessellator.func_78380_c((this.field_147859_h > 0.0D) ? i : p_147736_1_.func_149677_c(this.field_147845_a, p_147736_2_ - 1, p_147736_3_, p_147736_4_));
/* 5332 */       tessellator.func_78386_a(f10, f13, f16);
/*      */       
/* 5334 */       IIcon iIcon = func_147793_a(p_147736_1_, this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_, 4);
/* 5335 */       func_147798_e(p_147736_1_, p_147736_2_, p_147736_3_, p_147736_4_, iIcon);
/* 5336 */       if (field_147843_b && iIcon.func_94215_i().equals("grass_side") && !func_147744_b()) {
/* 5337 */         tessellator.func_78386_a(f10 * p_147736_5_, f13 * p_147736_6_, f16 * p_147736_7_);
/* 5338 */         func_147798_e(p_147736_1_, p_147736_2_, p_147736_3_, p_147736_4_, BlockGrass.func_149990_e());
/*      */       } 
/* 5340 */       bool = true;
/*      */     } 
/*      */     
/* 5343 */     if (this.field_147837_f || p_147736_1_.func_149646_a(this.field_147845_a, p_147736_2_ + 1, p_147736_3_, p_147736_4_, 5)) {
/* 5344 */       tessellator.func_78380_c((this.field_147861_i < 1.0D) ? i : p_147736_1_.func_149677_c(this.field_147845_a, p_147736_2_ + 1, p_147736_3_, p_147736_4_));
/* 5345 */       tessellator.func_78386_a(f10, f13, f16);
/*      */       
/* 5347 */       IIcon iIcon = func_147793_a(p_147736_1_, this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_, 5);
/* 5348 */       func_147764_f(p_147736_1_, p_147736_2_, p_147736_3_, p_147736_4_, iIcon);
/* 5349 */       if (field_147843_b && iIcon.func_94215_i().equals("grass_side") && !func_147744_b()) {
/* 5350 */         tessellator.func_78386_a(f10 * p_147736_5_, f13 * p_147736_6_, f16 * p_147736_7_);
/* 5351 */         func_147764_f(p_147736_1_, p_147736_2_, p_147736_3_, p_147736_4_, BlockGrass.func_149990_e());
/*      */       } 
/* 5353 */       bool = true;
/*      */     } 
/*      */     
/* 5356 */     return bool;
/*      */   }
/*      */   public boolean func_147772_a(BlockCocoa p_147772_1_, int p_147772_2_, int p_147772_3_, int p_147772_4_) {
/*      */     double d17;
/* 5360 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 5362 */     tessellator.func_78380_c(p_147772_1_.func_149677_c(this.field_147845_a, p_147772_2_, p_147772_3_, p_147772_4_));
/* 5363 */     tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/*      */     
/* 5365 */     int i = this.field_147845_a.func_72805_g(p_147772_2_, p_147772_3_, p_147772_4_);
/* 5366 */     int j = BlockDirectional.func_149895_l(i);
/* 5367 */     int k = BlockCocoa.func_149987_c(i);
/* 5368 */     IIcon iIcon = p_147772_1_.func_149988_b(k);
/*      */     
/* 5370 */     int m = 4 + k * 2;
/* 5371 */     int n = 5 + k * 2;
/*      */     
/* 5373 */     double d1 = 15.0D - m;
/* 5374 */     double d2 = 15.0D;
/* 5375 */     double d3 = 4.0D;
/* 5376 */     double d4 = 4.0D + n;
/* 5377 */     double d5 = iIcon.func_94214_a(d1);
/* 5378 */     double d6 = iIcon.func_94214_a(d2);
/* 5379 */     double d7 = iIcon.func_94207_b(d3);
/* 5380 */     double d8 = iIcon.func_94207_b(d4);
/*      */ 
/*      */     
/* 5383 */     double d9 = 0.0D;
/* 5384 */     double d10 = 0.0D;
/*      */     
/* 5386 */     switch (j) {
/*      */       case 2:
/* 5388 */         d9 = 8.0D - (m / 2);
/* 5389 */         d10 = 1.0D;
/*      */         break;
/*      */       case 0:
/* 5392 */         d9 = 8.0D - (m / 2);
/* 5393 */         d10 = 15.0D - m;
/*      */         break;
/*      */       case 3:
/* 5396 */         d9 = 15.0D - m;
/* 5397 */         d10 = 8.0D - (m / 2);
/*      */         break;
/*      */       case 1:
/* 5400 */         d9 = 1.0D;
/* 5401 */         d10 = 8.0D - (m / 2);
/*      */         break;
/*      */     } 
/*      */     
/* 5405 */     double d11 = p_147772_2_ + d9 / 16.0D;
/* 5406 */     double d12 = p_147772_2_ + (d9 + m) / 16.0D;
/* 5407 */     double d13 = p_147772_3_ + (12.0D - n) / 16.0D;
/* 5408 */     double d14 = p_147772_3_ + 0.75D;
/* 5409 */     double d15 = p_147772_4_ + d10 / 16.0D;
/* 5410 */     double d16 = p_147772_4_ + (d10 + m) / 16.0D;
/*      */ 
/*      */ 
/*      */     
/* 5414 */     tessellator.func_78374_a(d11, d13, d15, d5, d8);
/* 5415 */     tessellator.func_78374_a(d11, d13, d16, d6, d8);
/* 5416 */     tessellator.func_78374_a(d11, d14, d16, d6, d7);
/* 5417 */     tessellator.func_78374_a(d11, d14, d15, d5, d7);
/*      */ 
/*      */ 
/*      */     
/* 5421 */     tessellator.func_78374_a(d12, d13, d16, d5, d8);
/* 5422 */     tessellator.func_78374_a(d12, d13, d15, d6, d8);
/* 5423 */     tessellator.func_78374_a(d12, d14, d15, d6, d7);
/* 5424 */     tessellator.func_78374_a(d12, d14, d16, d5, d7);
/*      */ 
/*      */ 
/*      */     
/* 5428 */     tessellator.func_78374_a(d12, d13, d15, d5, d8);
/* 5429 */     tessellator.func_78374_a(d11, d13, d15, d6, d8);
/* 5430 */     tessellator.func_78374_a(d11, d14, d15, d6, d7);
/* 5431 */     tessellator.func_78374_a(d12, d14, d15, d5, d7);
/*      */ 
/*      */ 
/*      */     
/* 5435 */     tessellator.func_78374_a(d11, d13, d16, d5, d8);
/* 5436 */     tessellator.func_78374_a(d12, d13, d16, d6, d8);
/* 5437 */     tessellator.func_78374_a(d12, d14, d16, d6, d7);
/* 5438 */     tessellator.func_78374_a(d11, d14, d16, d5, d7);
/*      */ 
/*      */     
/* 5441 */     int i1 = m;
/* 5442 */     if (k >= 2)
/*      */     {
/* 5444 */       i1--;
/*      */     }
/*      */     
/* 5447 */     d5 = iIcon.func_94209_e();
/* 5448 */     d6 = iIcon.func_94214_a(i1);
/* 5449 */     d7 = iIcon.func_94206_g();
/* 5450 */     d8 = iIcon.func_94207_b(i1);
/*      */ 
/*      */ 
/*      */     
/* 5454 */     tessellator.func_78374_a(d11, d14, d16, d5, d8);
/* 5455 */     tessellator.func_78374_a(d12, d14, d16, d6, d8);
/* 5456 */     tessellator.func_78374_a(d12, d14, d15, d6, d7);
/* 5457 */     tessellator.func_78374_a(d11, d14, d15, d5, d7);
/*      */ 
/*      */ 
/*      */     
/* 5461 */     tessellator.func_78374_a(d11, d13, d15, d5, d7);
/* 5462 */     tessellator.func_78374_a(d12, d13, d15, d6, d7);
/* 5463 */     tessellator.func_78374_a(d12, d13, d16, d6, d8);
/* 5464 */     tessellator.func_78374_a(d11, d13, d16, d5, d8);
/*      */ 
/*      */ 
/*      */     
/* 5468 */     d5 = iIcon.func_94214_a(12.0D);
/* 5469 */     d6 = iIcon.func_94212_f();
/* 5470 */     d7 = iIcon.func_94206_g();
/* 5471 */     d8 = iIcon.func_94207_b(4.0D);
/*      */     
/* 5473 */     d9 = 8.0D;
/* 5474 */     d10 = 0.0D;
/*      */     
/* 5476 */     switch (j) {
/*      */       case 2:
/* 5478 */         d9 = 8.0D;
/* 5479 */         d10 = 0.0D;
/*      */         break;
/*      */       case 0:
/* 5482 */         d9 = 8.0D;
/* 5483 */         d10 = 12.0D;
/*      */         
/* 5485 */         d17 = d5;
/* 5486 */         d5 = d6;
/* 5487 */         d6 = d17;
/*      */         break;
/*      */       
/*      */       case 3:
/* 5491 */         d9 = 12.0D;
/* 5492 */         d10 = 8.0D;
/*      */         
/* 5494 */         d17 = d5;
/* 5495 */         d5 = d6;
/* 5496 */         d6 = d17;
/*      */         break;
/*      */       
/*      */       case 1:
/* 5500 */         d9 = 0.0D;
/* 5501 */         d10 = 8.0D;
/*      */         break;
/*      */     } 
/*      */     
/* 5505 */     d11 = p_147772_2_ + d9 / 16.0D;
/* 5506 */     d12 = p_147772_2_ + (d9 + 4.0D) / 16.0D;
/* 5507 */     d13 = p_147772_3_ + 0.75D;
/* 5508 */     d14 = p_147772_3_ + 1.0D;
/* 5509 */     d15 = p_147772_4_ + d10 / 16.0D;
/* 5510 */     d16 = p_147772_4_ + (d10 + 4.0D) / 16.0D;
/* 5511 */     if (j == 2 || j == 0) {
/*      */ 
/*      */       
/* 5514 */       tessellator.func_78374_a(d11, d13, d15, d6, d8);
/* 5515 */       tessellator.func_78374_a(d11, d13, d16, d5, d8);
/* 5516 */       tessellator.func_78374_a(d11, d14, d16, d5, d7);
/* 5517 */       tessellator.func_78374_a(d11, d14, d15, d6, d7);
/*      */ 
/*      */ 
/*      */       
/* 5521 */       tessellator.func_78374_a(d11, d13, d16, d5, d8);
/* 5522 */       tessellator.func_78374_a(d11, d13, d15, d6, d8);
/* 5523 */       tessellator.func_78374_a(d11, d14, d15, d6, d7);
/* 5524 */       tessellator.func_78374_a(d11, d14, d16, d5, d7);
/*      */     }
/* 5526 */     else if (j == 1 || j == 3) {
/*      */ 
/*      */       
/* 5529 */       tessellator.func_78374_a(d12, d13, d15, d5, d8);
/* 5530 */       tessellator.func_78374_a(d11, d13, d15, d6, d8);
/* 5531 */       tessellator.func_78374_a(d11, d14, d15, d6, d7);
/* 5532 */       tessellator.func_78374_a(d12, d14, d15, d5, d7);
/*      */ 
/*      */ 
/*      */       
/* 5536 */       tessellator.func_78374_a(d11, d13, d15, d6, d8);
/* 5537 */       tessellator.func_78374_a(d12, d13, d15, d5, d8);
/* 5538 */       tessellator.func_78374_a(d12, d14, d15, d5, d7);
/* 5539 */       tessellator.func_78374_a(d11, d14, d15, d6, d7);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 5544 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_147797_a(BlockBeacon p_147797_1_, int p_147797_2_, int p_147797_3_, int p_147797_4_) {
/* 5549 */     float f = 0.1875F;
/*      */     
/* 5551 */     func_147757_a(func_147745_b(Blocks.field_150359_w));
/* 5552 */     func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 5553 */     func_147784_q((Block)p_147797_1_, p_147797_2_, p_147797_3_, p_147797_4_);
/*      */ 
/*      */     
/* 5556 */     this.field_147837_f = true;
/* 5557 */     func_147757_a(func_147745_b(Blocks.field_150343_Z));
/* 5558 */     func_147782_a(0.125D, 0.0062500000931322575D, 0.125D, 0.875D, f, 0.875D);
/* 5559 */     func_147784_q((Block)p_147797_1_, p_147797_2_, p_147797_3_, p_147797_4_);
/*      */     
/* 5561 */     func_147757_a(func_147745_b((Block)Blocks.field_150461_bJ));
/* 5562 */     func_147782_a(0.1875D, f, 0.1875D, 0.8125D, 0.875D, 0.8125D);
/* 5563 */     func_147784_q((Block)p_147797_1_, p_147797_2_, p_147797_3_, p_147797_4_);
/* 5564 */     this.field_147837_f = false;
/*      */     
/* 5566 */     func_147771_a();
/*      */     
/* 5568 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147755_t(Block p_147755_1_, int p_147755_2_, int p_147755_3_, int p_147755_4_) {
/* 5572 */     int i = p_147755_1_.func_149720_d(this.field_147845_a, p_147755_2_, p_147755_3_, p_147755_4_);
/* 5573 */     float f1 = (i >> 16 & 0xFF) / 255.0F;
/* 5574 */     float f2 = (i >> 8 & 0xFF) / 255.0F;
/* 5575 */     float f3 = (i & 0xFF) / 255.0F;
/*      */     
/* 5577 */     if (EntityRenderer.field_78517_a) {
/* 5578 */       float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
/* 5579 */       float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
/* 5580 */       float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
/*      */       
/* 5582 */       f1 = f4;
/* 5583 */       f2 = f5;
/* 5584 */       f3 = f6;
/*      */     } 
/*      */     
/* 5587 */     return func_147754_e(p_147755_1_, p_147755_2_, p_147755_3_, p_147755_4_, f1, f2, f3);
/*      */   }
/*      */   
/*      */   public boolean func_147754_e(Block p_147754_1_, int p_147754_2_, int p_147754_3_, int p_147754_4_, float p_147754_5_, float p_147754_6_, float p_147754_7_) {
/* 5591 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 5593 */     boolean bool = false;
/* 5594 */     float f1 = 0.5F;
/* 5595 */     float f2 = 1.0F;
/* 5596 */     float f3 = 0.8F;
/* 5597 */     float f4 = 0.6F;
/*      */     
/* 5599 */     float f5 = f1 * p_147754_5_;
/* 5600 */     float f6 = f2 * p_147754_5_;
/* 5601 */     float f7 = f3 * p_147754_5_;
/* 5602 */     float f8 = f4 * p_147754_5_;
/*      */     
/* 5604 */     float f9 = f1 * p_147754_6_;
/* 5605 */     float f10 = f2 * p_147754_6_;
/* 5606 */     float f11 = f3 * p_147754_6_;
/* 5607 */     float f12 = f4 * p_147754_6_;
/*      */     
/* 5609 */     float f13 = f1 * p_147754_7_;
/* 5610 */     float f14 = f2 * p_147754_7_;
/* 5611 */     float f15 = f3 * p_147754_7_;
/* 5612 */     float f16 = f4 * p_147754_7_;
/*      */     
/* 5614 */     float f17 = 0.0625F;
/*      */     
/* 5616 */     int i = p_147754_1_.func_149677_c(this.field_147845_a, p_147754_2_, p_147754_3_, p_147754_4_);
/*      */     
/* 5618 */     if (this.field_147837_f || p_147754_1_.func_149646_a(this.field_147845_a, p_147754_2_, p_147754_3_ - 1, p_147754_4_, 0)) {
/* 5619 */       tessellator.func_78380_c((this.field_147855_j > 0.0D) ? i : p_147754_1_.func_149677_c(this.field_147845_a, p_147754_2_, p_147754_3_ - 1, p_147754_4_));
/* 5620 */       tessellator.func_78386_a(f5, f9, f13);
/* 5621 */       func_147768_a(p_147754_1_, p_147754_2_, p_147754_3_, p_147754_4_, func_147793_a(p_147754_1_, this.field_147845_a, p_147754_2_, p_147754_3_, p_147754_4_, 0));
/*      */     } 
/*      */     
/* 5624 */     if (this.field_147837_f || p_147754_1_.func_149646_a(this.field_147845_a, p_147754_2_, p_147754_3_ + 1, p_147754_4_, 1)) {
/* 5625 */       tessellator.func_78380_c((this.field_147857_k < 1.0D) ? i : p_147754_1_.func_149677_c(this.field_147845_a, p_147754_2_, p_147754_3_ + 1, p_147754_4_));
/* 5626 */       tessellator.func_78386_a(f6, f10, f14);
/* 5627 */       func_147806_b(p_147754_1_, p_147754_2_, p_147754_3_, p_147754_4_, func_147793_a(p_147754_1_, this.field_147845_a, p_147754_2_, p_147754_3_, p_147754_4_, 1));
/*      */     } 
/*      */ 
/*      */     
/* 5631 */     tessellator.func_78380_c(i);
/* 5632 */     tessellator.func_78386_a(f7, f11, f15);
/* 5633 */     tessellator.func_78372_c(0.0F, 0.0F, f17);
/* 5634 */     func_147761_c(p_147754_1_, p_147754_2_, p_147754_3_, p_147754_4_, func_147793_a(p_147754_1_, this.field_147845_a, p_147754_2_, p_147754_3_, p_147754_4_, 2));
/* 5635 */     tessellator.func_78372_c(0.0F, 0.0F, -f17);
/*      */     
/* 5637 */     tessellator.func_78372_c(0.0F, 0.0F, -f17);
/* 5638 */     func_147734_d(p_147754_1_, p_147754_2_, p_147754_3_, p_147754_4_, func_147793_a(p_147754_1_, this.field_147845_a, p_147754_2_, p_147754_3_, p_147754_4_, 3));
/* 5639 */     tessellator.func_78372_c(0.0F, 0.0F, f17);
/*      */ 
/*      */     
/* 5642 */     tessellator.func_78386_a(f8, f12, f16);
/* 5643 */     tessellator.func_78372_c(f17, 0.0F, 0.0F);
/* 5644 */     func_147798_e(p_147754_1_, p_147754_2_, p_147754_3_, p_147754_4_, func_147793_a(p_147754_1_, this.field_147845_a, p_147754_2_, p_147754_3_, p_147754_4_, 4));
/* 5645 */     tessellator.func_78372_c(-f17, 0.0F, 0.0F);
/*      */     
/* 5647 */     tessellator.func_78372_c(-f17, 0.0F, 0.0F);
/* 5648 */     func_147764_f(p_147754_1_, p_147754_2_, p_147754_3_, p_147754_4_, func_147793_a(p_147754_1_, this.field_147845_a, p_147754_2_, p_147754_3_, p_147754_4_, 5));
/* 5649 */     tessellator.func_78372_c(f17, 0.0F, 0.0F);
/*      */     
/* 5651 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147735_a(BlockFence p_147735_1_, int p_147735_2_, int p_147735_3_, int p_147735_4_) {
/* 5655 */     boolean bool1 = false;
/*      */     
/* 5657 */     float f1 = 0.375F;
/* 5658 */     float f2 = 0.625F;
/* 5659 */     func_147782_a(f1, 0.0D, f1, f2, 1.0D, f2);
/* 5660 */     func_147784_q((Block)p_147735_1_, p_147735_2_, p_147735_3_, p_147735_4_);
/* 5661 */     bool1 = true;
/*      */     
/* 5663 */     boolean bool2 = false;
/* 5664 */     boolean bool3 = false;
/*      */     
/* 5666 */     if (p_147735_1_.func_149826_e(this.field_147845_a, p_147735_2_ - 1, p_147735_3_, p_147735_4_) || p_147735_1_.func_149826_e(this.field_147845_a, p_147735_2_ + 1, p_147735_3_, p_147735_4_)) bool2 = true; 
/* 5667 */     if (p_147735_1_.func_149826_e(this.field_147845_a, p_147735_2_, p_147735_3_, p_147735_4_ - 1) || p_147735_1_.func_149826_e(this.field_147845_a, p_147735_2_, p_147735_3_, p_147735_4_ + 1)) bool3 = true;
/*      */     
/* 5669 */     boolean bool4 = p_147735_1_.func_149826_e(this.field_147845_a, p_147735_2_ - 1, p_147735_3_, p_147735_4_);
/* 5670 */     boolean bool5 = p_147735_1_.func_149826_e(this.field_147845_a, p_147735_2_ + 1, p_147735_3_, p_147735_4_);
/* 5671 */     boolean bool6 = p_147735_1_.func_149826_e(this.field_147845_a, p_147735_2_, p_147735_3_, p_147735_4_ - 1);
/* 5672 */     boolean bool7 = p_147735_1_.func_149826_e(this.field_147845_a, p_147735_2_, p_147735_3_, p_147735_4_ + 1);
/*      */     
/* 5674 */     if (!bool2 && !bool3) bool2 = true;
/*      */     
/* 5676 */     f1 = 0.4375F;
/* 5677 */     f2 = 0.5625F;
/* 5678 */     float f3 = 0.75F;
/* 5679 */     float f4 = 0.9375F;
/*      */     
/* 5681 */     float f5 = bool4 ? 0.0F : f1;
/* 5682 */     float f6 = bool5 ? 1.0F : f2;
/* 5683 */     float f7 = bool6 ? 0.0F : f1;
/* 5684 */     float f8 = bool7 ? 1.0F : f2;
/* 5685 */     this.field_152631_f = true;
/* 5686 */     if (bool2) {
/* 5687 */       func_147782_a(f5, f3, f1, f6, f4, f2);
/* 5688 */       func_147784_q((Block)p_147735_1_, p_147735_2_, p_147735_3_, p_147735_4_);
/* 5689 */       bool1 = true;
/*      */     } 
/* 5691 */     if (bool3) {
/* 5692 */       func_147782_a(f1, f3, f7, f2, f4, f8);
/* 5693 */       func_147784_q((Block)p_147735_1_, p_147735_2_, p_147735_3_, p_147735_4_);
/* 5694 */       bool1 = true;
/*      */     } 
/*      */     
/* 5697 */     f3 = 0.375F;
/* 5698 */     f4 = 0.5625F;
/* 5699 */     if (bool2) {
/* 5700 */       func_147782_a(f5, f3, f1, f6, f4, f2);
/* 5701 */       func_147784_q((Block)p_147735_1_, p_147735_2_, p_147735_3_, p_147735_4_);
/* 5702 */       bool1 = true;
/*      */     } 
/* 5704 */     if (bool3) {
/* 5705 */       func_147782_a(f1, f3, f7, f2, f4, f8);
/* 5706 */       func_147784_q((Block)p_147735_1_, p_147735_2_, p_147735_3_, p_147735_4_);
/* 5707 */       bool1 = true;
/*      */     } 
/* 5709 */     this.field_152631_f = false;
/*      */     
/* 5711 */     p_147735_1_.func_149719_a(this.field_147845_a, p_147735_2_, p_147735_3_, p_147735_4_);
/* 5712 */     return bool1;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_147807_a(BlockWall p_147807_1_, int p_147807_2_, int p_147807_3_, int p_147807_4_) {
/* 5717 */     boolean bool1 = p_147807_1_.func_150091_e(this.field_147845_a, p_147807_2_ - 1, p_147807_3_, p_147807_4_);
/* 5718 */     boolean bool2 = p_147807_1_.func_150091_e(this.field_147845_a, p_147807_2_ + 1, p_147807_3_, p_147807_4_);
/* 5719 */     boolean bool3 = p_147807_1_.func_150091_e(this.field_147845_a, p_147807_2_, p_147807_3_, p_147807_4_ - 1);
/* 5720 */     boolean bool4 = p_147807_1_.func_150091_e(this.field_147845_a, p_147807_2_, p_147807_3_, p_147807_4_ + 1);
/*      */     
/* 5722 */     boolean bool5 = (bool3 && bool4 && !bool1 && !bool2) ? true : false;
/* 5723 */     boolean bool6 = (!bool3 && !bool4 && bool1 && bool2) ? true : false;
/* 5724 */     boolean bool7 = this.field_147845_a.func_147437_c(p_147807_2_, p_147807_3_ + 1, p_147807_4_);
/*      */     
/* 5726 */     if ((!bool5 && !bool6) || !bool7) {
/*      */       
/* 5728 */       func_147782_a(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
/* 5729 */       func_147784_q((Block)p_147807_1_, p_147807_2_, p_147807_3_, p_147807_4_);
/*      */       
/* 5731 */       if (bool1) {
/* 5732 */         func_147782_a(0.0D, 0.0D, 0.3125D, 0.25D, 0.8125D, 0.6875D);
/* 5733 */         func_147784_q((Block)p_147807_1_, p_147807_2_, p_147807_3_, p_147807_4_);
/*      */       } 
/* 5735 */       if (bool2) {
/* 5736 */         func_147782_a(0.75D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
/* 5737 */         func_147784_q((Block)p_147807_1_, p_147807_2_, p_147807_3_, p_147807_4_);
/*      */       } 
/* 5739 */       if (bool3) {
/* 5740 */         func_147782_a(0.3125D, 0.0D, 0.0D, 0.6875D, 0.8125D, 0.25D);
/* 5741 */         func_147784_q((Block)p_147807_1_, p_147807_2_, p_147807_3_, p_147807_4_);
/*      */       } 
/* 5743 */       if (bool4) {
/* 5744 */         func_147782_a(0.3125D, 0.0D, 0.75D, 0.6875D, 0.8125D, 1.0D);
/* 5745 */         func_147784_q((Block)p_147807_1_, p_147807_2_, p_147807_3_, p_147807_4_);
/*      */       } 
/* 5747 */     } else if (bool5) {
/*      */       
/* 5749 */       func_147782_a(0.3125D, 0.0D, 0.0D, 0.6875D, 0.8125D, 1.0D);
/* 5750 */       func_147784_q((Block)p_147807_1_, p_147807_2_, p_147807_3_, p_147807_4_);
/*      */     } else {
/*      */       
/* 5753 */       func_147782_a(0.0D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
/* 5754 */       func_147784_q((Block)p_147807_1_, p_147807_2_, p_147807_3_, p_147807_4_);
/*      */     } 
/*      */     
/* 5757 */     p_147807_1_.func_149719_a(this.field_147845_a, p_147807_2_, p_147807_3_, p_147807_4_);
/* 5758 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147802_a(BlockDragonEgg p_147802_1_, int p_147802_2_, int p_147802_3_, int p_147802_4_) {
/* 5762 */     boolean bool = false;
/*      */     
/* 5764 */     int i = 0;
/* 5765 */     for (byte b = 0; b < 8; b++) {
/* 5766 */       byte b1 = 0;
/* 5767 */       byte b2 = 1;
/* 5768 */       if (b == 0) b1 = 2; 
/* 5769 */       if (b == 1) b1 = 3; 
/* 5770 */       if (b == 2) b1 = 4; 
/* 5771 */       if (b == 3) {
/* 5772 */         b1 = 5;
/* 5773 */         b2 = 2;
/*      */       } 
/* 5775 */       if (b == 4) {
/* 5776 */         b1 = 6;
/* 5777 */         b2 = 3;
/*      */       } 
/* 5779 */       if (b == 5) {
/* 5780 */         b1 = 7;
/* 5781 */         b2 = 5;
/*      */       } 
/* 5783 */       if (b == 6) {
/* 5784 */         b1 = 6;
/* 5785 */         b2 = 2;
/*      */       } 
/* 5787 */       if (b == 7) b1 = 3; 
/* 5788 */       float f1 = b1 / 16.0F;
/* 5789 */       float f2 = 1.0F - i / 16.0F;
/* 5790 */       float f3 = 1.0F - (i + b2) / 16.0F;
/* 5791 */       i += b2;
/* 5792 */       func_147782_a((0.5F - f1), f3, (0.5F - f1), (0.5F + f1), f2, (0.5F + f1));
/* 5793 */       func_147784_q((Block)p_147802_1_, p_147802_2_, p_147802_3_, p_147802_4_);
/*      */     } 
/* 5795 */     bool = true;
/*      */     
/* 5797 */     func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 5798 */     return bool;
/*      */   }
/*      */   
/*      */   public boolean func_147776_a(BlockFenceGate p_147776_1_, int p_147776_2_, int p_147776_3_, int p_147776_4_) {
/* 5802 */     boolean bool = true;
/*      */     
/* 5804 */     int i = this.field_147845_a.func_72805_g(p_147776_2_, p_147776_3_, p_147776_4_);
/* 5805 */     boolean bool1 = BlockFenceGate.func_149896_b(i);
/* 5806 */     int j = BlockDirectional.func_149895_l(i);
/*      */     
/* 5808 */     float f1 = 0.375F;
/* 5809 */     float f2 = 0.5625F;
/* 5810 */     float f3 = 0.75F;
/* 5811 */     float f4 = 0.9375F;
/* 5812 */     float f5 = 0.3125F;
/* 5813 */     float f6 = 1.0F;
/*      */     
/* 5815 */     if (((j == 2 || j == 0) && this.field_147845_a.func_147439_a(p_147776_2_ - 1, p_147776_3_, p_147776_4_) == Blocks.field_150463_bK && this.field_147845_a.func_147439_a(p_147776_2_ + 1, p_147776_3_, p_147776_4_) == Blocks.field_150463_bK) || ((j == 3 || j == 1) && this.field_147845_a.func_147439_a(p_147776_2_, p_147776_3_, p_147776_4_ - 1) == Blocks.field_150463_bK && this.field_147845_a.func_147439_a(p_147776_2_, p_147776_3_, p_147776_4_ + 1) == Blocks.field_150463_bK)) {
/*      */       
/* 5817 */       f1 -= 0.1875F;
/* 5818 */       f2 -= 0.1875F;
/* 5819 */       f3 -= 0.1875F;
/* 5820 */       f4 -= 0.1875F;
/* 5821 */       f5 -= 0.1875F;
/* 5822 */       f6 -= 0.1875F;
/*      */     } 
/*      */     
/* 5825 */     this.field_147837_f = true;
/*      */     
/* 5827 */     if (j == 3 || j == 1) {
/* 5828 */       this.field_147867_u = 1;
/* 5829 */       float f7 = 0.4375F;
/* 5830 */       float f8 = 0.5625F;
/* 5831 */       float f9 = 0.0F;
/* 5832 */       float f10 = 0.125F;
/* 5833 */       func_147782_a(f7, f5, f9, f8, f6, f10);
/* 5834 */       func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/*      */       
/* 5836 */       f9 = 0.875F;
/* 5837 */       f10 = 1.0F;
/* 5838 */       func_147782_a(f7, f5, f9, f8, f6, f10);
/* 5839 */       func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5840 */       this.field_147867_u = 0;
/*      */     } else {
/* 5842 */       float f7 = 0.0F;
/* 5843 */       float f8 = 0.125F;
/* 5844 */       float f9 = 0.4375F;
/* 5845 */       float f10 = 0.5625F;
/* 5846 */       func_147782_a(f7, f5, f9, f8, f6, f10);
/* 5847 */       func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/*      */       
/* 5849 */       f7 = 0.875F;
/* 5850 */       f8 = 1.0F;
/* 5851 */       func_147782_a(f7, f5, f9, f8, f6, f10);
/* 5852 */       func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/*      */     } 
/* 5854 */     if (bool1) {
/* 5855 */       if (j == 2 || j == 0) {
/* 5856 */         this.field_147867_u = 1;
/*      */       }
/*      */       
/* 5859 */       if (j == 3) {
/* 5860 */         float f7 = 0.0F;
/* 5861 */         float f8 = 0.125F;
/* 5862 */         float f9 = 0.875F;
/* 5863 */         float f10 = 1.0F;
/*      */         
/* 5865 */         float f11 = 0.5625F;
/* 5866 */         float f12 = 0.8125F;
/* 5867 */         float f13 = 0.9375F;
/*      */         
/* 5869 */         func_147782_a(0.8125D, f1, 0.0D, 0.9375D, f4, 0.125D);
/* 5870 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5871 */         func_147782_a(0.8125D, f1, 0.875D, 0.9375D, f4, 1.0D);
/* 5872 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/*      */         
/* 5874 */         func_147782_a(0.5625D, f1, 0.0D, 0.8125D, f2, 0.125D);
/* 5875 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5876 */         func_147782_a(0.5625D, f1, 0.875D, 0.8125D, f2, 1.0D);
/* 5877 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/*      */         
/* 5879 */         func_147782_a(0.5625D, f3, 0.0D, 0.8125D, f4, 0.125D);
/* 5880 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5881 */         func_147782_a(0.5625D, f3, 0.875D, 0.8125D, f4, 1.0D);
/* 5882 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5883 */       } else if (j == 1) {
/* 5884 */         float f7 = 0.0F;
/* 5885 */         float f8 = 0.125F;
/* 5886 */         float f9 = 0.875F;
/* 5887 */         float f10 = 1.0F;
/*      */         
/* 5889 */         float f11 = 0.0625F;
/* 5890 */         float f12 = 0.1875F;
/* 5891 */         float f13 = 0.4375F;
/*      */         
/* 5893 */         func_147782_a(0.0625D, f1, 0.0D, 0.1875D, f4, 0.125D);
/* 5894 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5895 */         func_147782_a(0.0625D, f1, 0.875D, 0.1875D, f4, 1.0D);
/* 5896 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/*      */         
/* 5898 */         func_147782_a(0.1875D, f1, 0.0D, 0.4375D, f2, 0.125D);
/* 5899 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5900 */         func_147782_a(0.1875D, f1, 0.875D, 0.4375D, f2, 1.0D);
/* 5901 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/*      */         
/* 5903 */         func_147782_a(0.1875D, f3, 0.0D, 0.4375D, f4, 0.125D);
/* 5904 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5905 */         func_147782_a(0.1875D, f3, 0.875D, 0.4375D, f4, 1.0D);
/* 5906 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5907 */       } else if (j == 0) {
/*      */         
/* 5909 */         float f7 = 0.0F;
/* 5910 */         float f8 = 0.125F;
/* 5911 */         float f9 = 0.875F;
/* 5912 */         float f10 = 1.0F;
/*      */         
/* 5914 */         float f11 = 0.5625F;
/* 5915 */         float f12 = 0.8125F;
/* 5916 */         float f13 = 0.9375F;
/*      */         
/* 5918 */         func_147782_a(0.0D, f1, 0.8125D, 0.125D, f4, 0.9375D);
/* 5919 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5920 */         func_147782_a(0.875D, f1, 0.8125D, 1.0D, f4, 0.9375D);
/* 5921 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/*      */         
/* 5923 */         func_147782_a(0.0D, f1, 0.5625D, 0.125D, f2, 0.8125D);
/* 5924 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5925 */         func_147782_a(0.875D, f1, 0.5625D, 1.0D, f2, 0.8125D);
/* 5926 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/*      */         
/* 5928 */         func_147782_a(0.0D, f3, 0.5625D, 0.125D, f4, 0.8125D);
/* 5929 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5930 */         func_147782_a(0.875D, f3, 0.5625D, 1.0D, f4, 0.8125D);
/* 5931 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5932 */       } else if (j == 2) {
/* 5933 */         float f7 = 0.0F;
/* 5934 */         float f8 = 0.125F;
/* 5935 */         float f9 = 0.875F;
/* 5936 */         float f10 = 1.0F;
/*      */         
/* 5938 */         float f11 = 0.0625F;
/* 5939 */         float f12 = 0.1875F;
/* 5940 */         float f13 = 0.4375F;
/*      */         
/* 5942 */         func_147782_a(0.0D, f1, 0.0625D, 0.125D, f4, 0.1875D);
/* 5943 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5944 */         func_147782_a(0.875D, f1, 0.0625D, 1.0D, f4, 0.1875D);
/* 5945 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/*      */         
/* 5947 */         func_147782_a(0.0D, f1, 0.1875D, 0.125D, f2, 0.4375D);
/* 5948 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5949 */         func_147782_a(0.875D, f1, 0.1875D, 1.0D, f2, 0.4375D);
/* 5950 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/*      */         
/* 5952 */         func_147782_a(0.0D, f3, 0.1875D, 0.125D, f4, 0.4375D);
/* 5953 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5954 */         func_147782_a(0.875D, f3, 0.1875D, 1.0D, f4, 0.4375D);
/* 5955 */         func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/*      */       }
/*      */     
/* 5958 */     } else if (j == 3 || j == 1) {
/* 5959 */       this.field_147867_u = 1;
/* 5960 */       float f7 = 0.4375F;
/* 5961 */       float f8 = 0.5625F;
/* 5962 */       float f9 = 0.375F;
/* 5963 */       float f10 = 0.5F;
/* 5964 */       func_147782_a(f7, f1, f9, f8, f4, f10);
/* 5965 */       func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5966 */       f9 = 0.5F;
/* 5967 */       f10 = 0.625F;
/* 5968 */       func_147782_a(f7, f1, f9, f8, f4, f10);
/* 5969 */       func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5970 */       f9 = 0.625F;
/* 5971 */       f10 = 0.875F;
/* 5972 */       func_147782_a(f7, f1, f9, f8, f2, f10);
/* 5973 */       func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5974 */       func_147782_a(f7, f3, f9, f8, f4, f10);
/* 5975 */       func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5976 */       f9 = 0.125F;
/* 5977 */       f10 = 0.375F;
/* 5978 */       func_147782_a(f7, f1, f9, f8, f2, f10);
/* 5979 */       func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5980 */       func_147782_a(f7, f3, f9, f8, f4, f10);
/* 5981 */       func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/*      */     } else {
/* 5983 */       float f7 = 0.375F;
/* 5984 */       float f8 = 0.5F;
/* 5985 */       float f9 = 0.4375F;
/* 5986 */       float f10 = 0.5625F;
/* 5987 */       func_147782_a(f7, f1, f9, f8, f4, f10);
/* 5988 */       func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5989 */       f7 = 0.5F;
/* 5990 */       f8 = 0.625F;
/* 5991 */       func_147782_a(f7, f1, f9, f8, f4, f10);
/* 5992 */       func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5993 */       f7 = 0.625F;
/* 5994 */       f8 = 0.875F;
/* 5995 */       func_147782_a(f7, f1, f9, f8, f2, f10);
/* 5996 */       func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5997 */       func_147782_a(f7, f3, f9, f8, f4, f10);
/* 5998 */       func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 5999 */       f7 = 0.125F;
/* 6000 */       f8 = 0.375F;
/* 6001 */       func_147782_a(f7, f1, f9, f8, f2, f10);
/* 6002 */       func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/* 6003 */       func_147782_a(f7, f3, f9, f8, f4, f10);
/* 6004 */       func_147784_q((Block)p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
/*      */     } 
/*      */ 
/*      */     
/* 6008 */     this.field_147837_f = false;
/* 6009 */     this.field_147867_u = 0;
/*      */     
/* 6011 */     func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 6012 */     return bool;
/*      */   }
/*      */   
/*      */   public boolean func_147803_a(BlockHopper p_147803_1_, int p_147803_2_, int p_147803_3_, int p_147803_4_) {
/* 6016 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 6018 */     tessellator.func_78380_c(p_147803_1_.func_149677_c(this.field_147845_a, p_147803_2_, p_147803_3_, p_147803_4_));
/* 6019 */     int i = p_147803_1_.func_149720_d(this.field_147845_a, p_147803_2_, p_147803_3_, p_147803_4_);
/* 6020 */     float f1 = (i >> 16 & 0xFF) / 255.0F;
/* 6021 */     float f2 = (i >> 8 & 0xFF) / 255.0F;
/* 6022 */     float f3 = (i & 0xFF) / 255.0F;
/*      */     
/* 6024 */     if (EntityRenderer.field_78517_a) {
/* 6025 */       float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
/* 6026 */       float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
/* 6027 */       float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
/*      */       
/* 6029 */       f1 = f4;
/* 6030 */       f2 = f5;
/* 6031 */       f3 = f6;
/*      */     } 
/* 6033 */     tessellator.func_78386_a(f1, f2, f3);
/*      */     
/* 6035 */     return func_147799_a(p_147803_1_, p_147803_2_, p_147803_3_, p_147803_4_, this.field_147845_a.func_72805_g(p_147803_2_, p_147803_3_, p_147803_4_), false);
/*      */   }
/*      */   
/*      */   public boolean func_147799_a(BlockHopper p_147799_1_, int p_147799_2_, int p_147799_3_, int p_147799_4_, int p_147799_5_, boolean p_147799_6_) {
/* 6039 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 6040 */     int i = BlockHopper.func_149918_b(p_147799_5_);
/*      */ 
/*      */     
/* 6043 */     double d1 = 0.625D;
/* 6044 */     func_147782_a(0.0D, d1, 0.0D, 1.0D, 1.0D, 1.0D);
/*      */     
/* 6046 */     if (p_147799_6_) {
/* 6047 */       tessellator.func_78382_b();
/* 6048 */       tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 6049 */       func_147768_a((Block)p_147799_1_, 0.0D, 0.0D, 0.0D, func_147787_a((Block)p_147799_1_, 0, p_147799_5_));
/* 6050 */       tessellator.func_78381_a();
/*      */       
/* 6052 */       tessellator.func_78382_b();
/* 6053 */       tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 6054 */       func_147806_b((Block)p_147799_1_, 0.0D, 0.0D, 0.0D, func_147787_a((Block)p_147799_1_, 1, p_147799_5_));
/* 6055 */       tessellator.func_78381_a();
/*      */       
/* 6057 */       tessellator.func_78382_b();
/* 6058 */       tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/* 6059 */       func_147761_c((Block)p_147799_1_, 0.0D, 0.0D, 0.0D, func_147787_a((Block)p_147799_1_, 2, p_147799_5_));
/* 6060 */       tessellator.func_78381_a();
/*      */       
/* 6062 */       tessellator.func_78382_b();
/* 6063 */       tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/* 6064 */       func_147734_d((Block)p_147799_1_, 0.0D, 0.0D, 0.0D, func_147787_a((Block)p_147799_1_, 3, p_147799_5_));
/* 6065 */       tessellator.func_78381_a();
/*      */       
/* 6067 */       tessellator.func_78382_b();
/* 6068 */       tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 6069 */       func_147798_e((Block)p_147799_1_, 0.0D, 0.0D, 0.0D, func_147787_a((Block)p_147799_1_, 4, p_147799_5_));
/* 6070 */       tessellator.func_78381_a();
/*      */       
/* 6072 */       tessellator.func_78382_b();
/* 6073 */       tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 6074 */       func_147764_f((Block)p_147799_1_, 0.0D, 0.0D, 0.0D, func_147787_a((Block)p_147799_1_, 5, p_147799_5_));
/* 6075 */       tessellator.func_78381_a();
/*      */     } else {
/* 6077 */       func_147784_q((Block)p_147799_1_, p_147799_2_, p_147799_3_, p_147799_4_);
/*      */     } 
/*      */     
/* 6080 */     if (!p_147799_6_) {
/* 6081 */       tessellator.func_78380_c(p_147799_1_.func_149677_c(this.field_147845_a, p_147799_2_, p_147799_3_, p_147799_4_));
/* 6082 */       int j = p_147799_1_.func_149720_d(this.field_147845_a, p_147799_2_, p_147799_3_, p_147799_4_);
/* 6083 */       float f1 = (j >> 16 & 0xFF) / 255.0F;
/* 6084 */       float f2 = (j >> 8 & 0xFF) / 255.0F;
/* 6085 */       float f3 = (j & 0xFF) / 255.0F;
/*      */       
/* 6087 */       if (EntityRenderer.field_78517_a) {
/* 6088 */         float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
/* 6089 */         float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
/* 6090 */         float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
/*      */         
/* 6092 */         f1 = f4;
/* 6093 */         f2 = f5;
/* 6094 */         f3 = f6;
/*      */       } 
/* 6096 */       tessellator.func_78386_a(f1, f2, f3);
/*      */     } 
/*      */ 
/*      */     
/* 6100 */     IIcon iIcon1 = BlockHopper.func_149916_e("hopper_outside");
/* 6101 */     IIcon iIcon2 = BlockHopper.func_149916_e("hopper_inside");
/* 6102 */     float f = 0.125F;
/*      */     
/* 6104 */     if (p_147799_6_) {
/* 6105 */       tessellator.func_78382_b();
/* 6106 */       tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 6107 */       func_147764_f((Block)p_147799_1_, (-1.0F + f), 0.0D, 0.0D, iIcon1);
/* 6108 */       tessellator.func_78381_a();
/*      */       
/* 6110 */       tessellator.func_78382_b();
/* 6111 */       tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 6112 */       func_147798_e((Block)p_147799_1_, (1.0F - f), 0.0D, 0.0D, iIcon1);
/* 6113 */       tessellator.func_78381_a();
/*      */       
/* 6115 */       tessellator.func_78382_b();
/* 6116 */       tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/* 6117 */       func_147734_d((Block)p_147799_1_, 0.0D, 0.0D, (-1.0F + f), iIcon1);
/* 6118 */       tessellator.func_78381_a();
/*      */       
/* 6120 */       tessellator.func_78382_b();
/* 6121 */       tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/* 6122 */       func_147761_c((Block)p_147799_1_, 0.0D, 0.0D, (1.0F - f), iIcon1);
/* 6123 */       tessellator.func_78381_a();
/*      */       
/* 6125 */       tessellator.func_78382_b();
/* 6126 */       tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 6127 */       func_147806_b((Block)p_147799_1_, 0.0D, -1.0D + d1, 0.0D, iIcon2);
/* 6128 */       tessellator.func_78381_a();
/*      */     } else {
/* 6130 */       func_147764_f((Block)p_147799_1_, (p_147799_2_ - 1.0F + f), p_147799_3_, p_147799_4_, iIcon1);
/* 6131 */       func_147798_e((Block)p_147799_1_, (p_147799_2_ + 1.0F - f), p_147799_3_, p_147799_4_, iIcon1);
/* 6132 */       func_147734_d((Block)p_147799_1_, p_147799_2_, p_147799_3_, (p_147799_4_ - 1.0F + f), iIcon1);
/* 6133 */       func_147761_c((Block)p_147799_1_, p_147799_2_, p_147799_3_, (p_147799_4_ + 1.0F - f), iIcon1);
/* 6134 */       func_147806_b((Block)p_147799_1_, p_147799_2_, (p_147799_3_ - 1.0F) + d1, p_147799_4_, iIcon2);
/*      */     } 
/*      */ 
/*      */     
/* 6138 */     func_147757_a(iIcon1);
/* 6139 */     double d2 = 0.25D;
/* 6140 */     double d3 = 0.25D;
/* 6141 */     double d4 = d1;
/* 6142 */     func_147782_a(d2, d3, d2, 1.0D - d2, d4 - 0.002D, 1.0D - d2);
/*      */     
/* 6144 */     if (p_147799_6_) {
/* 6145 */       tessellator.func_78382_b();
/* 6146 */       tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 6147 */       func_147764_f((Block)p_147799_1_, 0.0D, 0.0D, 0.0D, iIcon1);
/* 6148 */       tessellator.func_78381_a();
/*      */       
/* 6150 */       tessellator.func_78382_b();
/* 6151 */       tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 6152 */       func_147798_e((Block)p_147799_1_, 0.0D, 0.0D, 0.0D, iIcon1);
/* 6153 */       tessellator.func_78381_a();
/*      */       
/* 6155 */       tessellator.func_78382_b();
/* 6156 */       tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/* 6157 */       func_147734_d((Block)p_147799_1_, 0.0D, 0.0D, 0.0D, iIcon1);
/* 6158 */       tessellator.func_78381_a();
/*      */       
/* 6160 */       tessellator.func_78382_b();
/* 6161 */       tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/* 6162 */       func_147761_c((Block)p_147799_1_, 0.0D, 0.0D, 0.0D, iIcon1);
/* 6163 */       tessellator.func_78381_a();
/*      */       
/* 6165 */       tessellator.func_78382_b();
/* 6166 */       tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 6167 */       func_147806_b((Block)p_147799_1_, 0.0D, 0.0D, 0.0D, iIcon1);
/* 6168 */       tessellator.func_78381_a();
/*      */       
/* 6170 */       tessellator.func_78382_b();
/* 6171 */       tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 6172 */       func_147768_a((Block)p_147799_1_, 0.0D, 0.0D, 0.0D, iIcon1);
/* 6173 */       tessellator.func_78381_a();
/*      */     } else {
/* 6175 */       func_147784_q((Block)p_147799_1_, p_147799_2_, p_147799_3_, p_147799_4_);
/*      */     } 
/*      */     
/* 6178 */     if (!p_147799_6_) {
/*      */       
/* 6180 */       double d5 = 0.375D;
/* 6181 */       double d6 = 0.25D;
/* 6182 */       func_147757_a(iIcon1);
/*      */ 
/*      */       
/* 6185 */       if (i == 0) {
/* 6186 */         func_147782_a(d5, 0.0D, d5, 1.0D - d5, 0.25D, 1.0D - d5);
/* 6187 */         func_147784_q((Block)p_147799_1_, p_147799_2_, p_147799_3_, p_147799_4_);
/*      */       } 
/*      */       
/* 6190 */       if (i == 2) {
/* 6191 */         func_147782_a(d5, d3, 0.0D, 1.0D - d5, d3 + d6, d2);
/* 6192 */         func_147784_q((Block)p_147799_1_, p_147799_2_, p_147799_3_, p_147799_4_);
/*      */       } 
/*      */       
/* 6195 */       if (i == 3) {
/* 6196 */         func_147782_a(d5, d3, 1.0D - d2, 1.0D - d5, d3 + d6, 1.0D);
/* 6197 */         func_147784_q((Block)p_147799_1_, p_147799_2_, p_147799_3_, p_147799_4_);
/*      */       } 
/*      */       
/* 6200 */       if (i == 4) {
/* 6201 */         func_147782_a(0.0D, d3, d5, d2, d3 + d6, 1.0D - d5);
/* 6202 */         func_147784_q((Block)p_147799_1_, p_147799_2_, p_147799_3_, p_147799_4_);
/*      */       } 
/*      */       
/* 6205 */       if (i == 5) {
/* 6206 */         func_147782_a(1.0D - d2, d3, d5, 1.0D, d3 + d6, 1.0D - d5);
/* 6207 */         func_147784_q((Block)p_147799_1_, p_147799_2_, p_147799_3_, p_147799_4_);
/*      */       } 
/*      */     } 
/*      */     
/* 6211 */     func_147771_a();
/*      */     
/* 6213 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_147722_a(BlockStairs p_147722_1_, int p_147722_2_, int p_147722_3_, int p_147722_4_) {
/* 6220 */     p_147722_1_.func_150147_e(this.field_147845_a, p_147722_2_, p_147722_3_, p_147722_4_);
/* 6221 */     func_147775_a((Block)p_147722_1_);
/* 6222 */     func_147784_q((Block)p_147722_1_, p_147722_2_, p_147722_3_, p_147722_4_);
/*      */     
/* 6224 */     this.field_152631_f = true;
/*      */     
/* 6226 */     boolean bool = p_147722_1_.func_150145_f(this.field_147845_a, p_147722_2_, p_147722_3_, p_147722_4_);
/* 6227 */     func_147775_a((Block)p_147722_1_);
/* 6228 */     func_147784_q((Block)p_147722_1_, p_147722_2_, p_147722_3_, p_147722_4_);
/*      */     
/* 6230 */     if (bool && 
/* 6231 */       p_147722_1_.func_150144_g(this.field_147845_a, p_147722_2_, p_147722_3_, p_147722_4_)) {
/* 6232 */       func_147775_a((Block)p_147722_1_);
/* 6233 */       func_147784_q((Block)p_147722_1_, p_147722_2_, p_147722_3_, p_147722_4_);
/*      */     } 
/*      */ 
/*      */     
/* 6237 */     this.field_152631_f = false;
/*      */     
/* 6239 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_147760_u(Block p_147760_1_, int p_147760_2_, int p_147760_3_, int p_147760_4_) {
/* 6243 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */ 
/*      */     
/* 6246 */     int i = this.field_147845_a.func_72805_g(p_147760_2_, p_147760_3_, p_147760_4_);
/* 6247 */     if ((i & 0x8) != 0) {
/* 6248 */       if (this.field_147845_a.func_147439_a(p_147760_2_, p_147760_3_ - 1, p_147760_4_) != p_147760_1_) {
/* 6249 */         return false;
/*      */       }
/*      */     }
/* 6252 */     else if (this.field_147845_a.func_147439_a(p_147760_2_, p_147760_3_ + 1, p_147760_4_) != p_147760_1_) {
/* 6253 */       return false;
/*      */     } 
/*      */ 
/*      */     
/* 6257 */     boolean bool = false;
/* 6258 */     float f1 = 0.5F;
/* 6259 */     float f2 = 1.0F;
/* 6260 */     float f3 = 0.8F;
/* 6261 */     float f4 = 0.6F;
/*      */ 
/*      */ 
/*      */     
/* 6265 */     int j = p_147760_1_.func_149677_c(this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_);
/*      */     
/* 6267 */     tessellator.func_78380_c((this.field_147855_j > 0.0D) ? j : p_147760_1_.func_149677_c(this.field_147845_a, p_147760_2_, p_147760_3_ - 1, p_147760_4_));
/* 6268 */     tessellator.func_78386_a(f1, f1, f1);
/* 6269 */     func_147768_a(p_147760_1_, p_147760_2_, p_147760_3_, p_147760_4_, func_147793_a(p_147760_1_, this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_, 0));
/* 6270 */     bool = true;
/*      */     
/* 6272 */     tessellator.func_78380_c((this.field_147857_k < 1.0D) ? j : p_147760_1_.func_149677_c(this.field_147845_a, p_147760_2_, p_147760_3_ + 1, p_147760_4_));
/* 6273 */     tessellator.func_78386_a(f2, f2, f2);
/* 6274 */     func_147806_b(p_147760_1_, p_147760_2_, p_147760_3_, p_147760_4_, func_147793_a(p_147760_1_, this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_, 1));
/* 6275 */     bool = true;
/*      */ 
/*      */     
/* 6278 */     tessellator.func_78380_c((this.field_147851_l > 0.0D) ? j : p_147760_1_.func_149677_c(this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_ - 1));
/* 6279 */     tessellator.func_78386_a(f3, f3, f3);
/* 6280 */     IIcon iIcon = func_147793_a(p_147760_1_, this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_, 2);
/* 6281 */     func_147761_c(p_147760_1_, p_147760_2_, p_147760_3_, p_147760_4_, iIcon);
/* 6282 */     bool = true;
/* 6283 */     this.field_147842_e = false;
/*      */ 
/*      */ 
/*      */     
/* 6287 */     tessellator.func_78380_c((this.field_147853_m < 1.0D) ? j : p_147760_1_.func_149677_c(this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_ + 1));
/* 6288 */     tessellator.func_78386_a(f3, f3, f3);
/* 6289 */     iIcon = func_147793_a(p_147760_1_, this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_, 3);
/* 6290 */     func_147734_d(p_147760_1_, p_147760_2_, p_147760_3_, p_147760_4_, iIcon);
/* 6291 */     bool = true;
/* 6292 */     this.field_147842_e = false;
/*      */ 
/*      */ 
/*      */     
/* 6296 */     tessellator.func_78380_c((this.field_147859_h > 0.0D) ? j : p_147760_1_.func_149677_c(this.field_147845_a, p_147760_2_ - 1, p_147760_3_, p_147760_4_));
/* 6297 */     tessellator.func_78386_a(f4, f4, f4);
/* 6298 */     iIcon = func_147793_a(p_147760_1_, this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_, 4);
/* 6299 */     func_147798_e(p_147760_1_, p_147760_2_, p_147760_3_, p_147760_4_, iIcon);
/* 6300 */     bool = true;
/* 6301 */     this.field_147842_e = false;
/*      */ 
/*      */     
/* 6304 */     tessellator.func_78380_c((this.field_147861_i < 1.0D) ? j : p_147760_1_.func_149677_c(this.field_147845_a, p_147760_2_ + 1, p_147760_3_, p_147760_4_));
/* 6305 */     tessellator.func_78386_a(f4, f4, f4);
/* 6306 */     iIcon = func_147793_a(p_147760_1_, this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_, 5);
/* 6307 */     func_147764_f(p_147760_1_, p_147760_2_, p_147760_3_, p_147760_4_, iIcon);
/* 6308 */     bool = true;
/* 6309 */     this.field_147842_e = false;
/*      */     
/* 6311 */     return bool;
/*      */   }
/*      */   
/*      */   public void func_147768_a(Block p_147768_1_, double p_147768_2_, double p_147768_4_, double p_147768_6_, IIcon p_147768_8_) {
/* 6315 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 6317 */     if (func_147744_b()) p_147768_8_ = this.field_147840_d; 
/* 6318 */     double d1 = p_147768_8_.func_94214_a(this.field_147859_h * 16.0D);
/* 6319 */     double d2 = p_147768_8_.func_94214_a(this.field_147861_i * 16.0D);
/* 6320 */     double d3 = p_147768_8_.func_94207_b(this.field_147851_l * 16.0D);
/* 6321 */     double d4 = p_147768_8_.func_94207_b(this.field_147853_m * 16.0D);
/*      */     
/* 6323 */     if (this.field_147859_h < 0.0D || this.field_147861_i > 1.0D) {
/* 6324 */       d1 = p_147768_8_.func_94209_e();
/* 6325 */       d2 = p_147768_8_.func_94212_f();
/*      */     } 
/* 6327 */     if (this.field_147851_l < 0.0D || this.field_147853_m > 1.0D) {
/* 6328 */       d3 = p_147768_8_.func_94206_g();
/* 6329 */       d4 = p_147768_8_.func_94210_h();
/*      */     } 
/*      */     
/* 6332 */     double d5 = d2, d6 = d1, d7 = d3, d8 = d4;
/*      */     
/* 6334 */     if (this.field_147865_v == 2) {
/* 6335 */       d1 = p_147768_8_.func_94214_a(this.field_147851_l * 16.0D);
/* 6336 */       d3 = p_147768_8_.func_94207_b(16.0D - this.field_147861_i * 16.0D);
/* 6337 */       d2 = p_147768_8_.func_94214_a(this.field_147853_m * 16.0D);
/* 6338 */       d4 = p_147768_8_.func_94207_b(16.0D - this.field_147859_h * 16.0D);
/*      */       
/* 6340 */       d5 = d2;
/* 6341 */       d6 = d1;
/* 6342 */       d7 = d3;
/* 6343 */       d8 = d4;
/* 6344 */       d5 = d1;
/* 6345 */       d6 = d2;
/* 6346 */       d3 = d4;
/* 6347 */       d4 = d7;
/* 6348 */     } else if (this.field_147865_v == 1) {
/*      */       
/* 6350 */       d1 = p_147768_8_.func_94214_a(16.0D - this.field_147853_m * 16.0D);
/* 6351 */       d3 = p_147768_8_.func_94207_b(this.field_147859_h * 16.0D);
/* 6352 */       d2 = p_147768_8_.func_94214_a(16.0D - this.field_147851_l * 16.0D);
/* 6353 */       d4 = p_147768_8_.func_94207_b(this.field_147861_i * 16.0D);
/*      */ 
/*      */       
/* 6356 */       d5 = d2;
/* 6357 */       d6 = d1;
/* 6358 */       d7 = d3;
/* 6359 */       d8 = d4;
/* 6360 */       d1 = d5;
/* 6361 */       d2 = d6;
/* 6362 */       d7 = d4;
/* 6363 */       d8 = d3;
/* 6364 */     } else if (this.field_147865_v == 3) {
/* 6365 */       d1 = p_147768_8_.func_94214_a(16.0D - this.field_147859_h * 16.0D);
/* 6366 */       d2 = p_147768_8_.func_94214_a(16.0D - this.field_147861_i * 16.0D);
/* 6367 */       d3 = p_147768_8_.func_94207_b(16.0D - this.field_147851_l * 16.0D);
/* 6368 */       d4 = p_147768_8_.func_94207_b(16.0D - this.field_147853_m * 16.0D);
/*      */       
/* 6370 */       d5 = d2;
/* 6371 */       d6 = d1;
/* 6372 */       d7 = d3;
/* 6373 */       d8 = d4;
/*      */     } 
/*      */     
/* 6376 */     double d9 = p_147768_2_ + this.field_147859_h;
/* 6377 */     double d10 = p_147768_2_ + this.field_147861_i;
/* 6378 */     double d11 = p_147768_4_ + this.field_147855_j;
/* 6379 */     double d12 = p_147768_6_ + this.field_147851_l;
/* 6380 */     double d13 = p_147768_6_ + this.field_147853_m;
/*      */     
/* 6382 */     if (this.field_147838_g) {
/* 6383 */       d9 = p_147768_2_ + this.field_147861_i;
/* 6384 */       d10 = p_147768_2_ + this.field_147859_h;
/*      */     } 
/*      */     
/* 6387 */     if (this.field_147863_w) {
/* 6388 */       tessellator.func_78386_a(this.field_147872_ap, this.field_147846_at, this.field_147854_ax);
/* 6389 */       tessellator.func_78380_c(this.field_147864_al);
/* 6390 */       tessellator.func_78374_a(d9, d11, d13, d6, d8);
/*      */       
/* 6392 */       tessellator.func_78386_a(this.field_147852_aq, this.field_147860_au, this.field_147841_ay);
/* 6393 */       tessellator.func_78380_c(this.field_147874_am);
/* 6394 */       tessellator.func_78374_a(d9, d11, d12, d1, d3);
/*      */       
/* 6396 */       tessellator.func_78386_a(this.field_147850_ar, this.field_147858_av, this.field_147839_az);
/* 6397 */       tessellator.func_78380_c(this.field_147876_an);
/* 6398 */       tessellator.func_78374_a(d10, d11, d12, d5, d7);
/*      */       
/* 6400 */       tessellator.func_78386_a(this.field_147848_as, this.field_147856_aw, this.field_147833_aA);
/* 6401 */       tessellator.func_78380_c(this.field_147870_ao);
/* 6402 */       tessellator.func_78374_a(d10, d11, d13, d2, d4);
/*      */     } else {
/* 6404 */       tessellator.func_78374_a(d9, d11, d13, d6, d8);
/* 6405 */       tessellator.func_78374_a(d9, d11, d12, d1, d3);
/* 6406 */       tessellator.func_78374_a(d10, d11, d12, d5, d7);
/* 6407 */       tessellator.func_78374_a(d10, d11, d13, d2, d4);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_147806_b(Block p_147806_1_, double p_147806_2_, double p_147806_4_, double p_147806_6_, IIcon p_147806_8_) {
/* 6412 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 6414 */     if (func_147744_b()) p_147806_8_ = this.field_147840_d; 
/* 6415 */     double d1 = p_147806_8_.func_94214_a(this.field_147859_h * 16.0D);
/* 6416 */     double d2 = p_147806_8_.func_94214_a(this.field_147861_i * 16.0D);
/* 6417 */     double d3 = p_147806_8_.func_94207_b(this.field_147851_l * 16.0D);
/* 6418 */     double d4 = p_147806_8_.func_94207_b(this.field_147853_m * 16.0D);
/*      */     
/* 6420 */     if (this.field_147859_h < 0.0D || this.field_147861_i > 1.0D) {
/* 6421 */       d1 = p_147806_8_.func_94209_e();
/* 6422 */       d2 = p_147806_8_.func_94212_f();
/*      */     } 
/* 6424 */     if (this.field_147851_l < 0.0D || this.field_147853_m > 1.0D) {
/* 6425 */       d3 = p_147806_8_.func_94206_g();
/* 6426 */       d4 = p_147806_8_.func_94210_h();
/*      */     } 
/*      */     
/* 6429 */     double d5 = d2, d6 = d1, d7 = d3, d8 = d4;
/*      */     
/* 6431 */     if (this.field_147867_u == 1) {
/* 6432 */       d1 = p_147806_8_.func_94214_a(this.field_147851_l * 16.0D);
/* 6433 */       d3 = p_147806_8_.func_94207_b(16.0D - this.field_147861_i * 16.0D);
/* 6434 */       d2 = p_147806_8_.func_94214_a(this.field_147853_m * 16.0D);
/* 6435 */       d4 = p_147806_8_.func_94207_b(16.0D - this.field_147859_h * 16.0D);
/*      */       
/* 6437 */       d5 = d2;
/* 6438 */       d6 = d1;
/* 6439 */       d7 = d3;
/* 6440 */       d8 = d4;
/* 6441 */       d5 = d1;
/* 6442 */       d6 = d2;
/* 6443 */       d3 = d4;
/* 6444 */       d4 = d7;
/* 6445 */     } else if (this.field_147867_u == 2) {
/*      */       
/* 6447 */       d1 = p_147806_8_.func_94214_a(16.0D - this.field_147853_m * 16.0D);
/* 6448 */       d3 = p_147806_8_.func_94207_b(this.field_147859_h * 16.0D);
/* 6449 */       d2 = p_147806_8_.func_94214_a(16.0D - this.field_147851_l * 16.0D);
/* 6450 */       d4 = p_147806_8_.func_94207_b(this.field_147861_i * 16.0D);
/*      */ 
/*      */       
/* 6453 */       d5 = d2;
/* 6454 */       d6 = d1;
/* 6455 */       d7 = d3;
/* 6456 */       d8 = d4;
/* 6457 */       d1 = d5;
/* 6458 */       d2 = d6;
/* 6459 */       d7 = d4;
/* 6460 */       d8 = d3;
/* 6461 */     } else if (this.field_147867_u == 3) {
/* 6462 */       d1 = p_147806_8_.func_94214_a(16.0D - this.field_147859_h * 16.0D);
/* 6463 */       d2 = p_147806_8_.func_94214_a(16.0D - this.field_147861_i * 16.0D);
/* 6464 */       d3 = p_147806_8_.func_94207_b(16.0D - this.field_147851_l * 16.0D);
/* 6465 */       d4 = p_147806_8_.func_94207_b(16.0D - this.field_147853_m * 16.0D);
/*      */       
/* 6467 */       d5 = d2;
/* 6468 */       d6 = d1;
/* 6469 */       d7 = d3;
/* 6470 */       d8 = d4;
/*      */     } 
/*      */     
/* 6473 */     double d9 = p_147806_2_ + this.field_147859_h;
/* 6474 */     double d10 = p_147806_2_ + this.field_147861_i;
/* 6475 */     double d11 = p_147806_4_ + this.field_147857_k;
/* 6476 */     double d12 = p_147806_6_ + this.field_147851_l;
/* 6477 */     double d13 = p_147806_6_ + this.field_147853_m;
/*      */     
/* 6479 */     if (this.field_147838_g) {
/* 6480 */       d9 = p_147806_2_ + this.field_147861_i;
/* 6481 */       d10 = p_147806_2_ + this.field_147859_h;
/*      */     } 
/*      */     
/* 6484 */     if (this.field_147863_w) {
/* 6485 */       tessellator.func_78386_a(this.field_147872_ap, this.field_147846_at, this.field_147854_ax);
/* 6486 */       tessellator.func_78380_c(this.field_147864_al);
/* 6487 */       tessellator.func_78374_a(d10, d11, d13, d2, d4);
/*      */       
/* 6489 */       tessellator.func_78386_a(this.field_147852_aq, this.field_147860_au, this.field_147841_ay);
/* 6490 */       tessellator.func_78380_c(this.field_147874_am);
/* 6491 */       tessellator.func_78374_a(d10, d11, d12, d5, d7);
/*      */       
/* 6493 */       tessellator.func_78386_a(this.field_147850_ar, this.field_147858_av, this.field_147839_az);
/* 6494 */       tessellator.func_78380_c(this.field_147876_an);
/* 6495 */       tessellator.func_78374_a(d9, d11, d12, d1, d3);
/*      */       
/* 6497 */       tessellator.func_78386_a(this.field_147848_as, this.field_147856_aw, this.field_147833_aA);
/* 6498 */       tessellator.func_78380_c(this.field_147870_ao);
/* 6499 */       tessellator.func_78374_a(d9, d11, d13, d6, d8);
/*      */     } else {
/* 6501 */       tessellator.func_78374_a(d10, d11, d13, d2, d4);
/* 6502 */       tessellator.func_78374_a(d10, d11, d12, d5, d7);
/* 6503 */       tessellator.func_78374_a(d9, d11, d12, d1, d3);
/* 6504 */       tessellator.func_78374_a(d9, d11, d13, d6, d8);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_147761_c(Block p_147761_1_, double p_147761_2_, double p_147761_4_, double p_147761_6_, IIcon p_147761_8_) {
/* 6509 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 6511 */     if (func_147744_b()) p_147761_8_ = this.field_147840_d; 
/* 6512 */     double d1 = p_147761_8_.func_94214_a(this.field_147859_h * 16.0D);
/* 6513 */     double d2 = p_147761_8_.func_94214_a(this.field_147861_i * 16.0D);
/* 6514 */     if (this.field_152631_f) {
/* 6515 */       d2 = p_147761_8_.func_94214_a((1.0D - this.field_147859_h) * 16.0D);
/* 6516 */       d1 = p_147761_8_.func_94214_a((1.0D - this.field_147861_i) * 16.0D);
/*      */     } 
/* 6518 */     double d3 = p_147761_8_.func_94207_b(16.0D - this.field_147857_k * 16.0D);
/* 6519 */     double d4 = p_147761_8_.func_94207_b(16.0D - this.field_147855_j * 16.0D);
/*      */     
/* 6521 */     if (this.field_147842_e) {
/* 6522 */       double d = d1;
/* 6523 */       d1 = d2;
/* 6524 */       d2 = d;
/*      */     } 
/*      */     
/* 6527 */     if (this.field_147859_h < 0.0D || this.field_147861_i > 1.0D) {
/* 6528 */       d1 = p_147761_8_.func_94209_e();
/* 6529 */       d2 = p_147761_8_.func_94212_f();
/*      */     } 
/* 6531 */     if (this.field_147855_j < 0.0D || this.field_147857_k > 1.0D) {
/* 6532 */       d3 = p_147761_8_.func_94206_g();
/* 6533 */       d4 = p_147761_8_.func_94210_h();
/*      */     } 
/*      */     
/* 6536 */     double d5 = d2, d6 = d1, d7 = d3, d8 = d4;
/*      */     
/* 6538 */     if (this.field_147875_q == 2) {
/* 6539 */       d1 = p_147761_8_.func_94214_a(this.field_147855_j * 16.0D);
/* 6540 */       d2 = p_147761_8_.func_94214_a(this.field_147857_k * 16.0D);
/* 6541 */       d3 = p_147761_8_.func_94207_b(16.0D - this.field_147859_h * 16.0D);
/* 6542 */       d4 = p_147761_8_.func_94207_b(16.0D - this.field_147861_i * 16.0D);
/*      */       
/* 6544 */       d5 = d2;
/* 6545 */       d6 = d1;
/* 6546 */       d7 = d3;
/* 6547 */       d8 = d4;
/* 6548 */       d5 = d1;
/* 6549 */       d6 = d2;
/* 6550 */       d3 = d4;
/* 6551 */       d4 = d7;
/* 6552 */     } else if (this.field_147875_q == 1) {
/*      */       
/* 6554 */       d1 = p_147761_8_.func_94214_a(16.0D - this.field_147857_k * 16.0D);
/* 6555 */       d2 = p_147761_8_.func_94214_a(16.0D - this.field_147855_j * 16.0D);
/* 6556 */       d3 = p_147761_8_.func_94207_b(this.field_147861_i * 16.0D);
/* 6557 */       d4 = p_147761_8_.func_94207_b(this.field_147859_h * 16.0D);
/*      */ 
/*      */       
/* 6560 */       d5 = d2;
/* 6561 */       d6 = d1;
/* 6562 */       d7 = d3;
/* 6563 */       d8 = d4;
/* 6564 */       d1 = d5;
/* 6565 */       d2 = d6;
/* 6566 */       d7 = d4;
/* 6567 */       d8 = d3;
/* 6568 */     } else if (this.field_147875_q == 3) {
/* 6569 */       d1 = p_147761_8_.func_94214_a(16.0D - this.field_147859_h * 16.0D);
/* 6570 */       d2 = p_147761_8_.func_94214_a(16.0D - this.field_147861_i * 16.0D);
/* 6571 */       d3 = p_147761_8_.func_94207_b(this.field_147857_k * 16.0D);
/* 6572 */       d4 = p_147761_8_.func_94207_b(this.field_147855_j * 16.0D);
/*      */       
/* 6574 */       d5 = d2;
/* 6575 */       d6 = d1;
/* 6576 */       d7 = d3;
/* 6577 */       d8 = d4;
/*      */     } 
/*      */     
/* 6580 */     double d9 = p_147761_2_ + this.field_147859_h;
/* 6581 */     double d10 = p_147761_2_ + this.field_147861_i;
/* 6582 */     double d11 = p_147761_4_ + this.field_147855_j;
/* 6583 */     double d12 = p_147761_4_ + this.field_147857_k;
/* 6584 */     double d13 = p_147761_6_ + this.field_147851_l;
/*      */     
/* 6586 */     if (this.field_147838_g) {
/* 6587 */       d9 = p_147761_2_ + this.field_147861_i;
/* 6588 */       d10 = p_147761_2_ + this.field_147859_h;
/*      */     } 
/*      */     
/* 6591 */     if (this.field_147863_w) {
/* 6592 */       tessellator.func_78386_a(this.field_147872_ap, this.field_147846_at, this.field_147854_ax);
/* 6593 */       tessellator.func_78380_c(this.field_147864_al);
/* 6594 */       tessellator.func_78374_a(d9, d12, d13, d5, d7);
/*      */       
/* 6596 */       tessellator.func_78386_a(this.field_147852_aq, this.field_147860_au, this.field_147841_ay);
/* 6597 */       tessellator.func_78380_c(this.field_147874_am);
/* 6598 */       tessellator.func_78374_a(d10, d12, d13, d1, d3);
/*      */       
/* 6600 */       tessellator.func_78386_a(this.field_147850_ar, this.field_147858_av, this.field_147839_az);
/* 6601 */       tessellator.func_78380_c(this.field_147876_an);
/* 6602 */       tessellator.func_78374_a(d10, d11, d13, d6, d8);
/*      */       
/* 6604 */       tessellator.func_78386_a(this.field_147848_as, this.field_147856_aw, this.field_147833_aA);
/* 6605 */       tessellator.func_78380_c(this.field_147870_ao);
/* 6606 */       tessellator.func_78374_a(d9, d11, d13, d2, d4);
/*      */     } else {
/* 6608 */       tessellator.func_78374_a(d9, d12, d13, d5, d7);
/* 6609 */       tessellator.func_78374_a(d10, d12, d13, d1, d3);
/* 6610 */       tessellator.func_78374_a(d10, d11, d13, d6, d8);
/* 6611 */       tessellator.func_78374_a(d9, d11, d13, d2, d4);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_147734_d(Block p_147734_1_, double p_147734_2_, double p_147734_4_, double p_147734_6_, IIcon p_147734_8_) {
/* 6616 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 6618 */     if (func_147744_b()) p_147734_8_ = this.field_147840_d; 
/* 6619 */     double d1 = p_147734_8_.func_94214_a(this.field_147859_h * 16.0D);
/* 6620 */     double d2 = p_147734_8_.func_94214_a(this.field_147861_i * 16.0D);
/* 6621 */     double d3 = p_147734_8_.func_94207_b(16.0D - this.field_147857_k * 16.0D);
/* 6622 */     double d4 = p_147734_8_.func_94207_b(16.0D - this.field_147855_j * 16.0D);
/*      */     
/* 6624 */     if (this.field_147842_e) {
/* 6625 */       double d = d1;
/* 6626 */       d1 = d2;
/* 6627 */       d2 = d;
/*      */     } 
/*      */     
/* 6630 */     if (this.field_147859_h < 0.0D || this.field_147861_i > 1.0D) {
/* 6631 */       d1 = p_147734_8_.func_94209_e();
/* 6632 */       d2 = p_147734_8_.func_94212_f();
/*      */     } 
/* 6634 */     if (this.field_147855_j < 0.0D || this.field_147857_k > 1.0D) {
/* 6635 */       d3 = p_147734_8_.func_94206_g();
/* 6636 */       d4 = p_147734_8_.func_94210_h();
/*      */     } 
/*      */     
/* 6639 */     double d5 = d2, d6 = d1, d7 = d3, d8 = d4;
/*      */     
/* 6641 */     if (this.field_147873_r == 1) {
/* 6642 */       d1 = p_147734_8_.func_94214_a(this.field_147855_j * 16.0D);
/* 6643 */       d4 = p_147734_8_.func_94207_b(16.0D - this.field_147859_h * 16.0D);
/* 6644 */       d2 = p_147734_8_.func_94214_a(this.field_147857_k * 16.0D);
/* 6645 */       d3 = p_147734_8_.func_94207_b(16.0D - this.field_147861_i * 16.0D);
/*      */       
/* 6647 */       d5 = d2;
/* 6648 */       d6 = d1;
/* 6649 */       d7 = d3;
/* 6650 */       d8 = d4;
/* 6651 */       d5 = d1;
/* 6652 */       d6 = d2;
/* 6653 */       d3 = d4;
/* 6654 */       d4 = d7;
/* 6655 */     } else if (this.field_147873_r == 2) {
/*      */       
/* 6657 */       d1 = p_147734_8_.func_94214_a(16.0D - this.field_147857_k * 16.0D);
/* 6658 */       d3 = p_147734_8_.func_94207_b(this.field_147859_h * 16.0D);
/* 6659 */       d2 = p_147734_8_.func_94214_a(16.0D - this.field_147855_j * 16.0D);
/* 6660 */       d4 = p_147734_8_.func_94207_b(this.field_147861_i * 16.0D);
/*      */ 
/*      */       
/* 6663 */       d5 = d2;
/* 6664 */       d6 = d1;
/* 6665 */       d7 = d3;
/* 6666 */       d8 = d4;
/* 6667 */       d1 = d5;
/* 6668 */       d2 = d6;
/* 6669 */       d7 = d4;
/* 6670 */       d8 = d3;
/* 6671 */     } else if (this.field_147873_r == 3) {
/* 6672 */       d1 = p_147734_8_.func_94214_a(16.0D - this.field_147859_h * 16.0D);
/* 6673 */       d2 = p_147734_8_.func_94214_a(16.0D - this.field_147861_i * 16.0D);
/* 6674 */       d3 = p_147734_8_.func_94207_b(this.field_147857_k * 16.0D);
/* 6675 */       d4 = p_147734_8_.func_94207_b(this.field_147855_j * 16.0D);
/*      */       
/* 6677 */       d5 = d2;
/* 6678 */       d6 = d1;
/* 6679 */       d7 = d3;
/* 6680 */       d8 = d4;
/*      */     } 
/*      */     
/* 6683 */     double d9 = p_147734_2_ + this.field_147859_h;
/* 6684 */     double d10 = p_147734_2_ + this.field_147861_i;
/* 6685 */     double d11 = p_147734_4_ + this.field_147855_j;
/* 6686 */     double d12 = p_147734_4_ + this.field_147857_k;
/* 6687 */     double d13 = p_147734_6_ + this.field_147853_m;
/*      */     
/* 6689 */     if (this.field_147838_g) {
/* 6690 */       d9 = p_147734_2_ + this.field_147861_i;
/* 6691 */       d10 = p_147734_2_ + this.field_147859_h;
/*      */     } 
/*      */     
/* 6694 */     if (this.field_147863_w) {
/* 6695 */       tessellator.func_78386_a(this.field_147872_ap, this.field_147846_at, this.field_147854_ax);
/* 6696 */       tessellator.func_78380_c(this.field_147864_al);
/* 6697 */       tessellator.func_78374_a(d9, d12, d13, d1, d3);
/*      */       
/* 6699 */       tessellator.func_78386_a(this.field_147852_aq, this.field_147860_au, this.field_147841_ay);
/* 6700 */       tessellator.func_78380_c(this.field_147874_am);
/* 6701 */       tessellator.func_78374_a(d9, d11, d13, d6, d8);
/*      */       
/* 6703 */       tessellator.func_78386_a(this.field_147850_ar, this.field_147858_av, this.field_147839_az);
/* 6704 */       tessellator.func_78380_c(this.field_147876_an);
/* 6705 */       tessellator.func_78374_a(d10, d11, d13, d2, d4);
/*      */       
/* 6707 */       tessellator.func_78386_a(this.field_147848_as, this.field_147856_aw, this.field_147833_aA);
/* 6708 */       tessellator.func_78380_c(this.field_147870_ao);
/* 6709 */       tessellator.func_78374_a(d10, d12, d13, d5, d7);
/*      */     } else {
/* 6711 */       tessellator.func_78374_a(d9, d12, d13, d1, d3);
/* 6712 */       tessellator.func_78374_a(d9, d11, d13, d6, d8);
/* 6713 */       tessellator.func_78374_a(d10, d11, d13, d2, d4);
/* 6714 */       tessellator.func_78374_a(d10, d12, d13, d5, d7);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_147798_e(Block p_147798_1_, double p_147798_2_, double p_147798_4_, double p_147798_6_, IIcon p_147798_8_) {
/* 6719 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 6721 */     if (func_147744_b()) p_147798_8_ = this.field_147840_d; 
/* 6722 */     double d1 = p_147798_8_.func_94214_a(this.field_147851_l * 16.0D);
/* 6723 */     double d2 = p_147798_8_.func_94214_a(this.field_147853_m * 16.0D);
/* 6724 */     double d3 = p_147798_8_.func_94207_b(16.0D - this.field_147857_k * 16.0D);
/* 6725 */     double d4 = p_147798_8_.func_94207_b(16.0D - this.field_147855_j * 16.0D);
/*      */     
/* 6727 */     if (this.field_147842_e) {
/* 6728 */       double d = d1;
/* 6729 */       d1 = d2;
/* 6730 */       d2 = d;
/*      */     } 
/*      */     
/* 6733 */     if (this.field_147851_l < 0.0D || this.field_147853_m > 1.0D) {
/* 6734 */       d1 = p_147798_8_.func_94209_e();
/* 6735 */       d2 = p_147798_8_.func_94212_f();
/*      */     } 
/* 6737 */     if (this.field_147855_j < 0.0D || this.field_147857_k > 1.0D) {
/* 6738 */       d3 = p_147798_8_.func_94206_g();
/* 6739 */       d4 = p_147798_8_.func_94210_h();
/*      */     } 
/*      */     
/* 6742 */     double d5 = d2, d6 = d1, d7 = d3, d8 = d4;
/*      */     
/* 6744 */     if (this.field_147869_t == 1) {
/* 6745 */       d1 = p_147798_8_.func_94214_a(this.field_147855_j * 16.0D);
/* 6746 */       d3 = p_147798_8_.func_94207_b(16.0D - this.field_147853_m * 16.0D);
/* 6747 */       d2 = p_147798_8_.func_94214_a(this.field_147857_k * 16.0D);
/* 6748 */       d4 = p_147798_8_.func_94207_b(16.0D - this.field_147851_l * 16.0D);
/*      */       
/* 6750 */       d5 = d2;
/* 6751 */       d6 = d1;
/* 6752 */       d7 = d3;
/* 6753 */       d8 = d4;
/* 6754 */       d5 = d1;
/* 6755 */       d6 = d2;
/* 6756 */       d3 = d4;
/* 6757 */       d4 = d7;
/* 6758 */     } else if (this.field_147869_t == 2) {
/*      */       
/* 6760 */       d1 = p_147798_8_.func_94214_a(16.0D - this.field_147857_k * 16.0D);
/* 6761 */       d3 = p_147798_8_.func_94207_b(this.field_147851_l * 16.0D);
/* 6762 */       d2 = p_147798_8_.func_94214_a(16.0D - this.field_147855_j * 16.0D);
/* 6763 */       d4 = p_147798_8_.func_94207_b(this.field_147853_m * 16.0D);
/*      */ 
/*      */       
/* 6766 */       d5 = d2;
/* 6767 */       d6 = d1;
/* 6768 */       d7 = d3;
/* 6769 */       d8 = d4;
/* 6770 */       d1 = d5;
/* 6771 */       d2 = d6;
/* 6772 */       d7 = d4;
/* 6773 */       d8 = d3;
/* 6774 */     } else if (this.field_147869_t == 3) {
/* 6775 */       d1 = p_147798_8_.func_94214_a(16.0D - this.field_147851_l * 16.0D);
/* 6776 */       d2 = p_147798_8_.func_94214_a(16.0D - this.field_147853_m * 16.0D);
/* 6777 */       d3 = p_147798_8_.func_94207_b(this.field_147857_k * 16.0D);
/* 6778 */       d4 = p_147798_8_.func_94207_b(this.field_147855_j * 16.0D);
/*      */       
/* 6780 */       d5 = d2;
/* 6781 */       d6 = d1;
/* 6782 */       d7 = d3;
/* 6783 */       d8 = d4;
/*      */     } 
/*      */     
/* 6786 */     double d9 = p_147798_2_ + this.field_147859_h;
/* 6787 */     double d10 = p_147798_4_ + this.field_147855_j;
/* 6788 */     double d11 = p_147798_4_ + this.field_147857_k;
/* 6789 */     double d12 = p_147798_6_ + this.field_147851_l;
/* 6790 */     double d13 = p_147798_6_ + this.field_147853_m;
/*      */     
/* 6792 */     if (this.field_147838_g) {
/* 6793 */       d12 = p_147798_6_ + this.field_147853_m;
/* 6794 */       d13 = p_147798_6_ + this.field_147851_l;
/*      */     } 
/*      */     
/* 6797 */     if (this.field_147863_w) {
/* 6798 */       tessellator.func_78386_a(this.field_147872_ap, this.field_147846_at, this.field_147854_ax);
/* 6799 */       tessellator.func_78380_c(this.field_147864_al);
/* 6800 */       tessellator.func_78374_a(d9, d11, d13, d5, d7);
/*      */       
/* 6802 */       tessellator.func_78386_a(this.field_147852_aq, this.field_147860_au, this.field_147841_ay);
/* 6803 */       tessellator.func_78380_c(this.field_147874_am);
/* 6804 */       tessellator.func_78374_a(d9, d11, d12, d1, d3);
/*      */       
/* 6806 */       tessellator.func_78386_a(this.field_147850_ar, this.field_147858_av, this.field_147839_az);
/* 6807 */       tessellator.func_78380_c(this.field_147876_an);
/* 6808 */       tessellator.func_78374_a(d9, d10, d12, d6, d8);
/*      */       
/* 6810 */       tessellator.func_78386_a(this.field_147848_as, this.field_147856_aw, this.field_147833_aA);
/* 6811 */       tessellator.func_78380_c(this.field_147870_ao);
/* 6812 */       tessellator.func_78374_a(d9, d10, d13, d2, d4);
/*      */     } else {
/* 6814 */       tessellator.func_78374_a(d9, d11, d13, d5, d7);
/* 6815 */       tessellator.func_78374_a(d9, d11, d12, d1, d3);
/* 6816 */       tessellator.func_78374_a(d9, d10, d12, d6, d8);
/* 6817 */       tessellator.func_78374_a(d9, d10, d13, d2, d4);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_147764_f(Block p_147764_1_, double p_147764_2_, double p_147764_4_, double p_147764_6_, IIcon p_147764_8_) {
/* 6822 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 6824 */     if (func_147744_b()) p_147764_8_ = this.field_147840_d; 
/* 6825 */     double d1 = p_147764_8_.func_94214_a(this.field_147851_l * 16.0D);
/* 6826 */     double d2 = p_147764_8_.func_94214_a(this.field_147853_m * 16.0D);
/* 6827 */     if (this.field_152631_f) {
/* 6828 */       d2 = p_147764_8_.func_94214_a((1.0D - this.field_147851_l) * 16.0D);
/* 6829 */       d1 = p_147764_8_.func_94214_a((1.0D - this.field_147853_m) * 16.0D);
/*      */     } 
/* 6831 */     double d3 = p_147764_8_.func_94207_b(16.0D - this.field_147857_k * 16.0D);
/* 6832 */     double d4 = p_147764_8_.func_94207_b(16.0D - this.field_147855_j * 16.0D);
/*      */     
/* 6834 */     if (this.field_147842_e) {
/* 6835 */       double d = d1;
/* 6836 */       d1 = d2;
/* 6837 */       d2 = d;
/*      */     } 
/*      */     
/* 6840 */     if (this.field_147851_l < 0.0D || this.field_147853_m > 1.0D) {
/* 6841 */       d1 = p_147764_8_.func_94209_e();
/* 6842 */       d2 = p_147764_8_.func_94212_f();
/*      */     } 
/* 6844 */     if (this.field_147855_j < 0.0D || this.field_147857_k > 1.0D) {
/* 6845 */       d3 = p_147764_8_.func_94206_g();
/* 6846 */       d4 = p_147764_8_.func_94210_h();
/*      */     } 
/*      */     
/* 6849 */     double d5 = d2, d6 = d1, d7 = d3, d8 = d4;
/*      */     
/* 6851 */     if (this.field_147871_s == 2) {
/* 6852 */       d1 = p_147764_8_.func_94214_a(this.field_147855_j * 16.0D);
/* 6853 */       d3 = p_147764_8_.func_94207_b(16.0D - this.field_147851_l * 16.0D);
/* 6854 */       d2 = p_147764_8_.func_94214_a(this.field_147857_k * 16.0D);
/* 6855 */       d4 = p_147764_8_.func_94207_b(16.0D - this.field_147853_m * 16.0D);
/*      */       
/* 6857 */       d5 = d2;
/* 6858 */       d6 = d1;
/* 6859 */       d7 = d3;
/* 6860 */       d8 = d4;
/* 6861 */       d5 = d1;
/* 6862 */       d6 = d2;
/* 6863 */       d3 = d4;
/* 6864 */       d4 = d7;
/* 6865 */     } else if (this.field_147871_s == 1) {
/*      */       
/* 6867 */       d1 = p_147764_8_.func_94214_a(16.0D - this.field_147857_k * 16.0D);
/* 6868 */       d3 = p_147764_8_.func_94207_b(this.field_147853_m * 16.0D);
/* 6869 */       d2 = p_147764_8_.func_94214_a(16.0D - this.field_147855_j * 16.0D);
/* 6870 */       d4 = p_147764_8_.func_94207_b(this.field_147851_l * 16.0D);
/*      */ 
/*      */       
/* 6873 */       d5 = d2;
/* 6874 */       d6 = d1;
/* 6875 */       d7 = d3;
/* 6876 */       d8 = d4;
/* 6877 */       d1 = d5;
/* 6878 */       d2 = d6;
/* 6879 */       d7 = d4;
/* 6880 */       d8 = d3;
/* 6881 */     } else if (this.field_147871_s == 3) {
/* 6882 */       d1 = p_147764_8_.func_94214_a(16.0D - this.field_147851_l * 16.0D);
/* 6883 */       d2 = p_147764_8_.func_94214_a(16.0D - this.field_147853_m * 16.0D);
/* 6884 */       d3 = p_147764_8_.func_94207_b(this.field_147857_k * 16.0D);
/* 6885 */       d4 = p_147764_8_.func_94207_b(this.field_147855_j * 16.0D);
/*      */       
/* 6887 */       d5 = d2;
/* 6888 */       d6 = d1;
/* 6889 */       d7 = d3;
/* 6890 */       d8 = d4;
/*      */     } 
/*      */     
/* 6893 */     double d9 = p_147764_2_ + this.field_147861_i;
/* 6894 */     double d10 = p_147764_4_ + this.field_147855_j;
/* 6895 */     double d11 = p_147764_4_ + this.field_147857_k;
/* 6896 */     double d12 = p_147764_6_ + this.field_147851_l;
/* 6897 */     double d13 = p_147764_6_ + this.field_147853_m;
/*      */     
/* 6899 */     if (this.field_147838_g) {
/* 6900 */       d12 = p_147764_6_ + this.field_147853_m;
/* 6901 */       d13 = p_147764_6_ + this.field_147851_l;
/*      */     } 
/*      */     
/* 6904 */     if (this.field_147863_w) {
/* 6905 */       tessellator.func_78386_a(this.field_147872_ap, this.field_147846_at, this.field_147854_ax);
/* 6906 */       tessellator.func_78380_c(this.field_147864_al);
/* 6907 */       tessellator.func_78374_a(d9, d10, d13, d6, d8);
/*      */       
/* 6909 */       tessellator.func_78386_a(this.field_147852_aq, this.field_147860_au, this.field_147841_ay);
/* 6910 */       tessellator.func_78380_c(this.field_147874_am);
/* 6911 */       tessellator.func_78374_a(d9, d10, d12, d2, d4);
/*      */       
/* 6913 */       tessellator.func_78386_a(this.field_147850_ar, this.field_147858_av, this.field_147839_az);
/* 6914 */       tessellator.func_78380_c(this.field_147876_an);
/* 6915 */       tessellator.func_78374_a(d9, d11, d12, d5, d7);
/*      */       
/* 6917 */       tessellator.func_78386_a(this.field_147848_as, this.field_147856_aw, this.field_147833_aA);
/* 6918 */       tessellator.func_78380_c(this.field_147870_ao);
/* 6919 */       tessellator.func_78374_a(d9, d11, d13, d1, d3);
/*      */     } else {
/* 6921 */       tessellator.func_78374_a(d9, d10, d13, d6, d8);
/* 6922 */       tessellator.func_78374_a(d9, d10, d12, d2, d4);
/* 6923 */       tessellator.func_78374_a(d9, d11, d12, d5, d7);
/* 6924 */       tessellator.func_78374_a(d9, d11, d13, d1, d3);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_147800_a(Block p_147800_1_, int p_147800_2_, float p_147800_3_) {
/* 6960 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 6962 */     boolean bool = (p_147800_1_ == Blocks.field_150349_c) ? true : false;
/*      */     
/* 6964 */     if (p_147800_1_ == Blocks.field_150367_z || p_147800_1_ == Blocks.field_150409_cd || p_147800_1_ == Blocks.field_150460_al) {
/* 6965 */       p_147800_2_ = 3;
/*      */     }
/*      */     
/* 6968 */     if (this.field_147844_c) {
/* 6969 */       int j = p_147800_1_.func_149741_i(p_147800_2_);
/* 6970 */       if (bool) {
/* 6971 */         j = 16777215;
/*      */       }
/* 6973 */       float f1 = (j >> 16 & 0xFF) / 255.0F;
/* 6974 */       float f2 = (j >> 8 & 0xFF) / 255.0F;
/* 6975 */       float f3 = (j & 0xFF) / 255.0F;
/*      */       
/* 6977 */       GL11.glColor4f(f1 * p_147800_3_, f2 * p_147800_3_, f3 * p_147800_3_, 1.0F);
/*      */     } 
/*      */     
/* 6980 */     int i = p_147800_1_.func_149645_b();
/* 6981 */     func_147775_a(p_147800_1_);
/*      */     
/* 6983 */     if (i == 0 || i == 31 || i == 39 || i == 16 || i == 26) {
/* 6984 */       if (i == 16) {
/* 6985 */         p_147800_2_ = 1;
/*      */       }
/* 6987 */       p_147800_1_.func_149683_g();
/* 6988 */       func_147775_a(p_147800_1_);
/* 6989 */       GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/* 6990 */       GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 6991 */       tessellator.func_78382_b();
/* 6992 */       tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 6993 */       func_147768_a(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 0, p_147800_2_));
/* 6994 */       tessellator.func_78381_a();
/*      */       
/* 6996 */       if (bool && this.field_147844_c) {
/* 6997 */         int j = p_147800_1_.func_149741_i(p_147800_2_);
/* 6998 */         float f1 = (j >> 16 & 0xFF) / 255.0F;
/* 6999 */         float f2 = (j >> 8 & 0xFF) / 255.0F;
/* 7000 */         float f3 = (j & 0xFF) / 255.0F;
/*      */         
/* 7002 */         GL11.glColor4f(f1 * p_147800_3_, f2 * p_147800_3_, f3 * p_147800_3_, 1.0F);
/*      */       } 
/*      */       
/* 7005 */       tessellator.func_78382_b();
/* 7006 */       tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 7007 */       func_147806_b(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 1, p_147800_2_));
/* 7008 */       tessellator.func_78381_a();
/*      */       
/* 7010 */       if (bool && this.field_147844_c) {
/* 7011 */         GL11.glColor4f(p_147800_3_, p_147800_3_, p_147800_3_, 1.0F);
/*      */       }
/*      */       
/* 7014 */       tessellator.func_78382_b();
/* 7015 */       tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/* 7016 */       func_147761_c(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 2, p_147800_2_));
/* 7017 */       tessellator.func_78381_a();
/*      */       
/* 7019 */       tessellator.func_78382_b();
/* 7020 */       tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/* 7021 */       func_147734_d(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 3, p_147800_2_));
/* 7022 */       tessellator.func_78381_a();
/*      */       
/* 7024 */       tessellator.func_78382_b();
/* 7025 */       tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 7026 */       func_147798_e(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 4, p_147800_2_));
/* 7027 */       tessellator.func_78381_a();
/*      */       
/* 7029 */       tessellator.func_78382_b();
/* 7030 */       tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 7031 */       func_147764_f(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 5, p_147800_2_));
/* 7032 */       tessellator.func_78381_a();
/*      */       
/* 7034 */       GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/* 7035 */     } else if (i == 1) {
/* 7036 */       tessellator.func_78382_b();
/* 7037 */       tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 7038 */       IIcon iIcon = func_147787_a(p_147800_1_, 0, p_147800_2_);
/* 7039 */       func_147765_a(iIcon, -0.5D, -0.5D, -0.5D, 1.0F);
/* 7040 */       tessellator.func_78381_a();
/* 7041 */     } else if (i == 19) {
/* 7042 */       tessellator.func_78382_b();
/* 7043 */       tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 7044 */       p_147800_1_.func_149683_g();
/* 7045 */       func_147730_a(p_147800_1_, p_147800_2_, this.field_147857_k, -0.5D, -0.5D, -0.5D);
/* 7046 */       tessellator.func_78381_a();
/* 7047 */     } else if (i == 23) {
/* 7048 */       tessellator.func_78382_b();
/* 7049 */       tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 7050 */       p_147800_1_.func_149683_g();
/* 7051 */       tessellator.func_78381_a();
/* 7052 */     } else if (i == 13) {
/* 7053 */       p_147800_1_.func_149683_g();
/* 7054 */       GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 7055 */       float f = 0.0625F;
/* 7056 */       tessellator.func_78382_b();
/* 7057 */       tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 7058 */       func_147768_a(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 0));
/* 7059 */       tessellator.func_78381_a();
/*      */       
/* 7061 */       tessellator.func_78382_b();
/* 7062 */       tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 7063 */       func_147806_b(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 1));
/* 7064 */       tessellator.func_78381_a();
/*      */       
/* 7066 */       tessellator.func_78382_b();
/* 7067 */       tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/* 7068 */       tessellator.func_78372_c(0.0F, 0.0F, f);
/* 7069 */       func_147761_c(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 2));
/* 7070 */       tessellator.func_78372_c(0.0F, 0.0F, -f);
/* 7071 */       tessellator.func_78381_a();
/*      */       
/* 7073 */       tessellator.func_78382_b();
/* 7074 */       tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/* 7075 */       tessellator.func_78372_c(0.0F, 0.0F, -f);
/* 7076 */       func_147734_d(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 3));
/* 7077 */       tessellator.func_78372_c(0.0F, 0.0F, f);
/* 7078 */       tessellator.func_78381_a();
/*      */       
/* 7080 */       tessellator.func_78382_b();
/* 7081 */       tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 7082 */       tessellator.func_78372_c(f, 0.0F, 0.0F);
/* 7083 */       func_147798_e(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 4));
/* 7084 */       tessellator.func_78372_c(-f, 0.0F, 0.0F);
/* 7085 */       tessellator.func_78381_a();
/*      */       
/* 7087 */       tessellator.func_78382_b();
/* 7088 */       tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 7089 */       tessellator.func_78372_c(-f, 0.0F, 0.0F);
/* 7090 */       func_147764_f(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 5));
/* 7091 */       tessellator.func_78372_c(f, 0.0F, 0.0F);
/* 7092 */       tessellator.func_78381_a();
/*      */       
/* 7094 */       GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/* 7095 */     } else if (i == 22) {
/* 7096 */       GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/* 7097 */       GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 7098 */       TileEntityRendererChestHelper.field_147719_a.func_147715_a(p_147800_1_, p_147800_2_, p_147800_3_);
/* 7099 */       GL11.glEnable(32826);
/* 7100 */     } else if (i == 6) {
/* 7101 */       tessellator.func_78382_b();
/* 7102 */       tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 7103 */       func_147795_a(p_147800_1_, p_147800_2_, -0.5D, -0.5D, -0.5D);
/* 7104 */       tessellator.func_78381_a();
/* 7105 */     } else if (i == 2) {
/* 7106 */       tessellator.func_78382_b();
/* 7107 */       tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 7108 */       func_147747_a(p_147800_1_, -0.5D, -0.5D, -0.5D, 0.0D, 0.0D, 0);
/* 7109 */       tessellator.func_78381_a();
/* 7110 */     } else if (i == 10) {
/* 7111 */       for (byte b = 0; b < 2; b++) {
/* 7112 */         if (b == 0) func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.5D); 
/* 7113 */         if (b == 1) func_147782_a(0.0D, 0.0D, 0.5D, 1.0D, 0.5D, 1.0D);
/*      */         
/* 7115 */         GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 7116 */         tessellator.func_78382_b();
/* 7117 */         tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 7118 */         func_147768_a(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 0));
/* 7119 */         tessellator.func_78381_a();
/*      */         
/* 7121 */         tessellator.func_78382_b();
/* 7122 */         tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 7123 */         func_147806_b(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 1));
/* 7124 */         tessellator.func_78381_a();
/*      */         
/* 7126 */         tessellator.func_78382_b();
/* 7127 */         tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/* 7128 */         func_147761_c(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 2));
/* 7129 */         tessellator.func_78381_a();
/*      */         
/* 7131 */         tessellator.func_78382_b();
/* 7132 */         tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/* 7133 */         func_147734_d(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 3));
/* 7134 */         tessellator.func_78381_a();
/*      */         
/* 7136 */         tessellator.func_78382_b();
/* 7137 */         tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 7138 */         func_147798_e(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 4));
/* 7139 */         tessellator.func_78381_a();
/*      */         
/* 7141 */         tessellator.func_78382_b();
/* 7142 */         tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 7143 */         func_147764_f(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 5));
/* 7144 */         tessellator.func_78381_a();
/*      */         
/* 7146 */         GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*      */       } 
/* 7148 */     } else if (i == 27) {
/* 7149 */       int j = 0;
/* 7150 */       GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 7151 */       tessellator.func_78382_b();
/* 7152 */       for (byte b = 0; b < 8; b++) {
/* 7153 */         byte b1 = 0;
/* 7154 */         byte b2 = 1;
/* 7155 */         if (b == 0) b1 = 2; 
/* 7156 */         if (b == 1) b1 = 3; 
/* 7157 */         if (b == 2) b1 = 4; 
/* 7158 */         if (b == 3) {
/* 7159 */           b1 = 5;
/* 7160 */           b2 = 2;
/*      */         } 
/* 7162 */         if (b == 4) {
/* 7163 */           b1 = 6;
/* 7164 */           b2 = 3;
/*      */         } 
/* 7166 */         if (b == 5) {
/* 7167 */           b1 = 7;
/* 7168 */           b2 = 5;
/*      */         } 
/* 7170 */         if (b == 6) {
/* 7171 */           b1 = 6;
/* 7172 */           b2 = 2;
/*      */         } 
/* 7174 */         if (b == 7) b1 = 3; 
/* 7175 */         float f1 = b1 / 16.0F;
/* 7176 */         float f2 = 1.0F - j / 16.0F;
/* 7177 */         float f3 = 1.0F - (j + b2) / 16.0F;
/* 7178 */         j += b2;
/* 7179 */         func_147782_a((0.5F - f1), f3, (0.5F - f1), (0.5F + f1), f2, (0.5F + f1));
/* 7180 */         tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 7181 */         func_147768_a(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 0));
/* 7182 */         tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 7183 */         func_147806_b(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 1));
/* 7184 */         tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/* 7185 */         func_147761_c(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 2));
/* 7186 */         tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/* 7187 */         func_147734_d(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 3));
/* 7188 */         tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 7189 */         func_147798_e(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 4));
/* 7190 */         tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 7191 */         func_147764_f(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 5));
/*      */       } 
/* 7193 */       tessellator.func_78381_a();
/* 7194 */       GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/* 7195 */       func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 7196 */     } else if (i == 11) {
/* 7197 */       for (byte b = 0; b < 4; b++) {
/* 7198 */         float f = 0.125F;
/* 7199 */         if (b == 0) func_147782_a((0.5F - f), 0.0D, 0.0D, (0.5F + f), 1.0D, (f * 2.0F)); 
/* 7200 */         if (b == 1) func_147782_a((0.5F - f), 0.0D, (1.0F - f * 2.0F), (0.5F + f), 1.0D, 1.0D); 
/* 7201 */         f = 0.0625F;
/* 7202 */         if (b == 2) func_147782_a((0.5F - f), (1.0F - f * 3.0F), (-f * 2.0F), (0.5F + f), (1.0F - f), (1.0F + f * 2.0F)); 
/* 7203 */         if (b == 3) func_147782_a((0.5F - f), (0.5F - f * 3.0F), (-f * 2.0F), (0.5F + f), (0.5F - f), (1.0F + f * 2.0F));
/*      */         
/* 7205 */         GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 7206 */         tessellator.func_78382_b();
/* 7207 */         tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 7208 */         func_147768_a(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 0));
/* 7209 */         tessellator.func_78381_a();
/*      */         
/* 7211 */         tessellator.func_78382_b();
/* 7212 */         tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 7213 */         func_147806_b(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 1));
/* 7214 */         tessellator.func_78381_a();
/*      */         
/* 7216 */         tessellator.func_78382_b();
/* 7217 */         tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/* 7218 */         func_147761_c(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 2));
/* 7219 */         tessellator.func_78381_a();
/*      */         
/* 7221 */         tessellator.func_78382_b();
/* 7222 */         tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/* 7223 */         func_147734_d(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 3));
/* 7224 */         tessellator.func_78381_a();
/*      */         
/* 7226 */         tessellator.func_78382_b();
/* 7227 */         tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 7228 */         func_147798_e(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 4));
/* 7229 */         tessellator.func_78381_a();
/*      */         
/* 7231 */         tessellator.func_78382_b();
/* 7232 */         tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 7233 */         func_147764_f(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 5));
/* 7234 */         tessellator.func_78381_a();
/*      */         
/* 7236 */         GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*      */       } 
/* 7238 */       func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 7239 */     } else if (i == 21) {
/* 7240 */       for (byte b = 0; b < 3; b++) {
/* 7241 */         float f = 0.0625F;
/* 7242 */         if (b == 0) func_147782_a((0.5F - f), 0.30000001192092896D, 0.0D, (0.5F + f), 1.0D, (f * 2.0F)); 
/* 7243 */         if (b == 1) func_147782_a((0.5F - f), 0.30000001192092896D, (1.0F - f * 2.0F), (0.5F + f), 1.0D, 1.0D); 
/* 7244 */         f = 0.0625F;
/* 7245 */         if (b == 2) func_147782_a((0.5F - f), 0.5D, 0.0D, (0.5F + f), (1.0F - f), 1.0D);
/*      */         
/* 7247 */         GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 7248 */         tessellator.func_78382_b();
/* 7249 */         tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 7250 */         func_147768_a(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 0));
/* 7251 */         tessellator.func_78381_a();
/*      */         
/* 7253 */         tessellator.func_78382_b();
/* 7254 */         tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 7255 */         func_147806_b(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 1));
/* 7256 */         tessellator.func_78381_a();
/*      */         
/* 7258 */         tessellator.func_78382_b();
/* 7259 */         tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/* 7260 */         func_147761_c(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 2));
/* 7261 */         tessellator.func_78381_a();
/*      */         
/* 7263 */         tessellator.func_78382_b();
/* 7264 */         tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/* 7265 */         func_147734_d(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 3));
/* 7266 */         tessellator.func_78381_a();
/*      */         
/* 7268 */         tessellator.func_78382_b();
/* 7269 */         tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 7270 */         func_147798_e(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 4));
/* 7271 */         tessellator.func_78381_a();
/*      */         
/* 7273 */         tessellator.func_78382_b();
/* 7274 */         tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 7275 */         func_147764_f(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147777_a(p_147800_1_, 5));
/* 7276 */         tessellator.func_78381_a();
/*      */         
/* 7278 */         GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*      */       } 
/* 7280 */     } else if (i == 32) {
/* 7281 */       for (byte b = 0; b < 2; b++) {
/* 7282 */         if (b == 0) func_147782_a(0.0D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D); 
/* 7283 */         if (b == 1) func_147782_a(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
/*      */         
/* 7285 */         GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 7286 */         tessellator.func_78382_b();
/* 7287 */         tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 7288 */         func_147768_a(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 0, p_147800_2_));
/* 7289 */         tessellator.func_78381_a();
/*      */         
/* 7291 */         tessellator.func_78382_b();
/* 7292 */         tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 7293 */         func_147806_b(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 1, p_147800_2_));
/* 7294 */         tessellator.func_78381_a();
/*      */         
/* 7296 */         tessellator.func_78382_b();
/* 7297 */         tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/* 7298 */         func_147761_c(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 2, p_147800_2_));
/* 7299 */         tessellator.func_78381_a();
/*      */         
/* 7301 */         tessellator.func_78382_b();
/* 7302 */         tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/* 7303 */         func_147734_d(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 3, p_147800_2_));
/* 7304 */         tessellator.func_78381_a();
/*      */         
/* 7306 */         tessellator.func_78382_b();
/* 7307 */         tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 7308 */         func_147798_e(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 4, p_147800_2_));
/* 7309 */         tessellator.func_78381_a();
/*      */         
/* 7311 */         tessellator.func_78382_b();
/* 7312 */         tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 7313 */         func_147764_f(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 5, p_147800_2_));
/* 7314 */         tessellator.func_78381_a();
/*      */         
/* 7316 */         GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*      */       } 
/* 7318 */       func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 7319 */     } else if (i == 35) {
/* 7320 */       GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 7321 */       func_147728_a((BlockAnvil)p_147800_1_, 0, 0, 0, p_147800_2_ << 2, true);
/* 7322 */       GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/* 7323 */     } else if (i == 34) {
/* 7324 */       for (byte b = 0; b < 3; b++) {
/* 7325 */         if (b == 0) {
/* 7326 */           func_147782_a(0.125D, 0.0D, 0.125D, 0.875D, 0.1875D, 0.875D);
/* 7327 */           func_147757_a(func_147745_b(Blocks.field_150343_Z));
/* 7328 */         } else if (b == 1) {
/* 7329 */           func_147782_a(0.1875D, 0.1875D, 0.1875D, 0.8125D, 0.875D, 0.8125D);
/* 7330 */           func_147757_a(func_147745_b((Block)Blocks.field_150461_bJ));
/* 7331 */         } else if (b == 2) {
/* 7332 */           func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 7333 */           func_147757_a(func_147745_b(Blocks.field_150359_w));
/*      */         } 
/*      */         
/* 7336 */         GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 7337 */         tessellator.func_78382_b();
/* 7338 */         tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 7339 */         func_147768_a(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 0, p_147800_2_));
/* 7340 */         tessellator.func_78381_a();
/*      */         
/* 7342 */         tessellator.func_78382_b();
/* 7343 */         tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 7344 */         func_147806_b(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 1, p_147800_2_));
/* 7345 */         tessellator.func_78381_a();
/*      */         
/* 7347 */         tessellator.func_78382_b();
/* 7348 */         tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/* 7349 */         func_147761_c(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 2, p_147800_2_));
/* 7350 */         tessellator.func_78381_a();
/*      */         
/* 7352 */         tessellator.func_78382_b();
/* 7353 */         tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/* 7354 */         func_147734_d(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 3, p_147800_2_));
/* 7355 */         tessellator.func_78381_a();
/*      */         
/* 7357 */         tessellator.func_78382_b();
/* 7358 */         tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 7359 */         func_147798_e(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 4, p_147800_2_));
/* 7360 */         tessellator.func_78381_a();
/*      */         
/* 7362 */         tessellator.func_78382_b();
/* 7363 */         tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 7364 */         func_147764_f(p_147800_1_, 0.0D, 0.0D, 0.0D, func_147787_a(p_147800_1_, 5, p_147800_2_));
/* 7365 */         tessellator.func_78381_a();
/*      */         
/* 7367 */         GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*      */       } 
/* 7369 */       func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 7370 */       func_147771_a();
/* 7371 */     } else if (i == 38) {
/* 7372 */       GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 7373 */       func_147799_a((BlockHopper)p_147800_1_, 0, 0, 0, 0, true);
/* 7374 */       GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean func_147739_a(int p_147739_0_) {
/* 7380 */     if (p_147739_0_ == 0) return true; 
/* 7381 */     if (p_147739_0_ == 31) return true; 
/* 7382 */     if (p_147739_0_ == 39) return true; 
/* 7383 */     if (p_147739_0_ == 13) return true; 
/* 7384 */     if (p_147739_0_ == 10) return true; 
/* 7385 */     if (p_147739_0_ == 11) return true; 
/* 7386 */     if (p_147739_0_ == 27) return true; 
/* 7387 */     if (p_147739_0_ == 22) return true; 
/* 7388 */     if (p_147739_0_ == 21) return true; 
/* 7389 */     if (p_147739_0_ == 16) return true; 
/* 7390 */     if (p_147739_0_ == 26) return true; 
/* 7391 */     if (p_147739_0_ == 32) return true; 
/* 7392 */     if (p_147739_0_ == 34) return true; 
/* 7393 */     if (p_147739_0_ == 35) return true; 
/* 7394 */     if (p_147739_0_ == -1) return false; 
/* 7395 */     return false;
/*      */   }
/*      */   
/*      */   public IIcon func_147793_a(Block p_147793_1_, IBlockAccess p_147793_2_, int p_147793_3_, int p_147793_4_, int p_147793_5_, int p_147793_6_) {
/* 7399 */     return func_147758_b(p_147793_1_.func_149673_e(p_147793_2_, p_147793_3_, p_147793_4_, p_147793_5_, p_147793_6_));
/*      */   }
/*      */   
/*      */   public IIcon func_147787_a(Block p_147787_1_, int p_147787_2_, int p_147787_3_) {
/* 7403 */     return func_147758_b(p_147787_1_.func_149691_a(p_147787_2_, p_147787_3_));
/*      */   }
/*      */   
/*      */   public IIcon func_147777_a(Block p_147777_1_, int p_147777_2_) {
/* 7407 */     return func_147758_b(p_147777_1_.func_149733_h(p_147777_2_));
/*      */   }
/*      */   
/*      */   public IIcon func_147745_b(Block p_147745_1_) {
/* 7411 */     return func_147758_b(p_147745_1_.func_149733_h(1));
/*      */   }
/*      */   public IIcon func_147758_b(IIcon p_147758_1_) {
/*      */     TextureAtlasSprite textureAtlasSprite;
/* 7415 */     if (p_147758_1_ == null) {
/* 7416 */       textureAtlasSprite = ((TextureMap)Minecraft.func_71410_x().func_110434_K().func_110581_b(TextureMap.field_110575_b)).func_110572_b("missingno");
/*      */     }
/* 7418 */     return (IIcon)textureAtlasSprite;
/*      */   } }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\RenderBlocks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */