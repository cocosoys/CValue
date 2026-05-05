/*     */ package net.minecraft.init;
/*     */ import net.minecraft.block.BlockDispenser;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
/*     */ import net.minecraft.dispenser.BehaviorProjectileDispense;
/*     */ import net.minecraft.dispenser.IBlockSource;
/*     */ import net.minecraft.dispenser.IPosition;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.IProjectile;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class Bootstrap {
/*     */   private static boolean field_151355_a = false;
/*     */   
/*     */   static void func_151353_a() {
/*  20 */     BlockDispenser.field_149943_a.func_82595_a(Items.field_151032_g, new BehaviorProjectileDispense() { private static final String __OBFID = "CL_00001398";
/*     */           
/*     */           protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
/*  23 */             EntityArrow entityArrow = new EntityArrow(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c());
/*  24 */             entityArrow.field_70251_a = 1;
/*     */             
/*  26 */             return (IProjectile)entityArrow;
/*     */           } }
/*     */       );
/*  29 */     BlockDispenser.field_149943_a.func_82595_a(Items.field_151110_aK, new BehaviorProjectileDispense() { private static final String __OBFID = "CL_00001404";
/*     */           
/*     */           protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
/*  32 */             return (IProjectile)new EntityEgg(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c());
/*     */           } }
/*     */       );
/*  35 */     BlockDispenser.field_149943_a.func_82595_a(Items.field_151126_ay, new BehaviorProjectileDispense() { private static final String __OBFID = "CL_00001405";
/*     */           
/*     */           protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
/*  38 */             return (IProjectile)new EntitySnowball(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c());
/*     */           } }
/*     */       );
/*  41 */     BlockDispenser.field_149943_a.func_82595_a(Items.field_151062_by, new BehaviorProjectileDispense() { private static final String __OBFID = "CL_00001406";
/*     */           
/*     */           protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
/*  44 */             return (IProjectile)new EntityExpBottle(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c());
/*     */           }
/*     */ 
/*     */           
/*     */           protected float func_82498_a() {
/*  49 */             return super.func_82498_a() * 0.5F;
/*     */           }
/*     */ 
/*     */           
/*     */           protected float func_82500_b() {
/*  54 */             return super.func_82500_b() * 1.25F;
/*     */           } }
/*     */       );
/*     */     
/*  58 */     BlockDispenser.field_149943_a.func_82595_a(Items.field_151068_bn, new IBehaviorDispenseItem() {
/*  59 */           private final BehaviorDefaultDispenseItem field_150843_b = new BehaviorDefaultDispenseItem();
/*     */           
/*     */           private static final String __OBFID = "CL_00001407";
/*     */           public ItemStack func_82482_a(IBlockSource p_82482_1_, ItemStack p_82482_2_) {
/*  63 */             if (ItemPotion.func_77831_g(p_82482_2_.func_77960_j())) {
/*  64 */               return (new BehaviorProjectileDispense(this, p_82482_2_) { private static final String __OBFID = "CL_00001408";
/*     */                   
/*     */                   protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
/*  67 */                     return (IProjectile)new EntityPotion(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c(), this.field_150836_b.func_77946_l());
/*     */                   }
/*     */ 
/*     */                   
/*     */                   protected float func_82498_a() {
/*  72 */                     return super.func_82498_a() * 0.5F;
/*     */                   }
/*     */ 
/*     */                   
/*     */                   protected float func_82500_b() {
/*  77 */                     return super.func_82500_b() * 1.25F;
/*     */                   } }
/*     */                 ).func_82482_a(p_82482_1_, p_82482_2_);
/*     */             }
/*  81 */             return this.field_150843_b.func_82482_a(p_82482_1_, p_82482_2_);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  86 */     BlockDispenser.field_149943_a.func_82595_a(Items.field_151063_bx, new BehaviorDefaultDispenseItem() { private static final String __OBFID = "CL_00001410";
/*     */           
/*     */           public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
/*  89 */             EnumFacing enumFacing = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
/*     */ 
/*     */             
/*  92 */             double d1 = p_82487_1_.func_82615_a() + enumFacing.func_82601_c();
/*  93 */             double d2 = (p_82487_1_.func_82622_e() + 0.2F);
/*  94 */             double d3 = p_82487_1_.func_82616_c() + enumFacing.func_82599_e();
/*     */             
/*  96 */             Entity entity = ItemMonsterPlacer.func_77840_a(p_82487_1_.func_82618_k(), p_82487_2_.func_77960_j(), d1, d2, d3);
/*     */             
/*  98 */             if (entity instanceof net.minecraft.entity.EntityLivingBase && p_82487_2_.func_82837_s()) {
/*  99 */               ((EntityLiving)entity).func_94058_c(p_82487_2_.func_82833_r());
/*     */             }
/*     */             
/* 102 */             p_82487_2_.func_77979_a(1);
/* 103 */             return p_82487_2_;
/*     */           } }
/*     */       );
/*     */     
/* 107 */     BlockDispenser.field_149943_a.func_82595_a(Items.field_151152_bP, new BehaviorDefaultDispenseItem() { private static final String __OBFID = "CL_00001411";
/*     */           
/*     */           public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
/* 110 */             EnumFacing enumFacing = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
/*     */             
/* 112 */             double d1 = p_82487_1_.func_82615_a() + enumFacing.func_82601_c();
/* 113 */             double d2 = (p_82487_1_.func_82622_e() + 0.2F);
/* 114 */             double d3 = p_82487_1_.func_82616_c() + enumFacing.func_82599_e();
/*     */             
/* 116 */             EntityFireworkRocket entityFireworkRocket = new EntityFireworkRocket(p_82487_1_.func_82618_k(), d1, d2, d3, p_82487_2_);
/* 117 */             p_82487_1_.func_82618_k().func_72838_d((Entity)entityFireworkRocket);
/*     */             
/* 119 */             p_82487_2_.func_77979_a(1);
/* 120 */             return p_82487_2_;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void func_82485_a(IBlockSource p_82485_1_) {
/* 125 */             p_82485_1_.func_82618_k().func_72926_e(1002, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
/*     */           } }
/*     */       );
/*     */     
/* 129 */     BlockDispenser.field_149943_a.func_82595_a(Items.field_151059_bz, new BehaviorDefaultDispenseItem() { private static final String __OBFID = "CL_00001412";
/*     */           
/*     */           public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
/* 132 */             EnumFacing enumFacing = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
/*     */             
/* 134 */             IPosition iPosition = BlockDispenser.func_149939_a(p_82487_1_);
/* 135 */             double d1 = iPosition.func_82615_a() + (enumFacing.func_82601_c() * 0.3F);
/* 136 */             double d2 = iPosition.func_82617_b() + (enumFacing.func_82601_c() * 0.3F);
/* 137 */             double d3 = iPosition.func_82616_c() + (enumFacing.func_82599_e() * 0.3F);
/*     */             
/* 139 */             World world = p_82487_1_.func_82618_k();
/* 140 */             Random random = world.field_73012_v;
/*     */             
/* 142 */             double d4 = random.nextGaussian() * 0.05D + enumFacing.func_82601_c();
/* 143 */             double d5 = random.nextGaussian() * 0.05D + enumFacing.func_96559_d();
/* 144 */             double d6 = random.nextGaussian() * 0.05D + enumFacing.func_82599_e();
/*     */             
/* 146 */             world.func_72838_d((Entity)new EntitySmallFireball(world, d1, d2, d3, d4, d5, d6));
/*     */             
/* 148 */             p_82487_2_.func_77979_a(1);
/* 149 */             return p_82487_2_;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void func_82485_a(IBlockSource p_82485_1_) {
/* 154 */             p_82485_1_.func_82618_k().func_72926_e(1009, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
/*     */           } }
/*     */       );
/*     */     
/* 158 */     BlockDispenser.field_149943_a.func_82595_a(Items.field_151124_az, new BehaviorDefaultDispenseItem() {
/* 159 */           private final BehaviorDefaultDispenseItem field_150842_b = new BehaviorDefaultDispenseItem(); private static final String __OBFID = "CL_00001413";
/*     */           
/*     */           public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
/*     */             double d4;
/* 163 */             EnumFacing enumFacing = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
/* 164 */             World world = p_82487_1_.func_82618_k();
/*     */ 
/*     */             
/* 167 */             double d1 = p_82487_1_.func_82615_a() + (enumFacing.func_82601_c() * 1.125F);
/* 168 */             double d2 = p_82487_1_.func_82617_b() + (enumFacing.func_96559_d() * 1.125F);
/* 169 */             double d3 = p_82487_1_.func_82616_c() + (enumFacing.func_82599_e() * 1.125F);
/*     */             
/* 171 */             int i = p_82487_1_.func_82623_d() + enumFacing.func_82601_c();
/* 172 */             int j = p_82487_1_.func_82622_e() + enumFacing.func_96559_d();
/* 173 */             int k = p_82487_1_.func_82621_f() + enumFacing.func_82599_e();
/* 174 */             Material material = world.func_147439_a(i, j, k).func_149688_o();
/*     */ 
/*     */             
/* 177 */             if (Material.field_151586_h.equals(material)) {
/* 178 */               d4 = 1.0D;
/* 179 */             } else if (Material.field_151579_a.equals(material) && Material.field_151586_h.equals(world.func_147439_a(i, j - 1, k).func_149688_o())) {
/* 180 */               d4 = 0.0D;
/*     */             } else {
/* 182 */               return this.field_150842_b.func_82482_a(p_82487_1_, p_82487_2_);
/*     */             } 
/*     */             
/* 185 */             EntityBoat entityBoat = new EntityBoat(world, d1, d2 + d4, d3);
/* 186 */             world.func_72838_d((Entity)entityBoat);
/*     */             
/* 188 */             p_82487_2_.func_77979_a(1);
/* 189 */             return p_82487_2_;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void func_82485_a(IBlockSource p_82485_1_) {
/* 194 */             p_82485_1_.func_82618_k().func_72926_e(1000, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
/*     */           }
/*     */         });
/*     */     
/* 198 */     BehaviorDefaultDispenseItem behaviorDefaultDispenseItem = new BehaviorDefaultDispenseItem() {
/* 199 */         private final BehaviorDefaultDispenseItem field_150841_b = new BehaviorDefaultDispenseItem();
/*     */         private static final String __OBFID = "CL_00001399";
/*     */         
/*     */         public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
/* 203 */           ItemBucket itemBucket = (ItemBucket)p_82487_2_.func_77973_b();
/* 204 */           int i = p_82487_1_.func_82623_d();
/* 205 */           int j = p_82487_1_.func_82622_e();
/* 206 */           int k = p_82487_1_.func_82621_f();
/*     */           
/* 208 */           EnumFacing enumFacing = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
/* 209 */           if (itemBucket.func_77875_a(p_82487_1_.func_82618_k(), i + enumFacing.func_82601_c(), j + enumFacing.func_96559_d(), k + enumFacing.func_82599_e())) {
/* 210 */             p_82487_2_.func_150996_a(Items.field_151133_ar);
/* 211 */             p_82487_2_.field_77994_a = 1;
/*     */             
/* 213 */             return p_82487_2_;
/*     */           } 
/*     */           
/* 216 */           return this.field_150841_b.func_82482_a(p_82487_1_, p_82487_2_);
/*     */         }
/*     */       };
/* 219 */     BlockDispenser.field_149943_a.func_82595_a(Items.field_151129_at, behaviorDefaultDispenseItem);
/* 220 */     BlockDispenser.field_149943_a.func_82595_a(Items.field_151131_as, behaviorDefaultDispenseItem);
/*     */     
/* 222 */     BlockDispenser.field_149943_a.func_82595_a(Items.field_151133_ar, new BehaviorDefaultDispenseItem() {
/* 223 */           private final BehaviorDefaultDispenseItem field_150840_b = new BehaviorDefaultDispenseItem(); private static final String __OBFID = "CL_00001400";
/*     */           
/*     */           public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
/*     */             Item item;
/* 227 */             EnumFacing enumFacing = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
/* 228 */             World world = p_82487_1_.func_82618_k();
/*     */             
/* 230 */             int i = p_82487_1_.func_82623_d() + enumFacing.func_82601_c();
/* 231 */             int j = p_82487_1_.func_82622_e() + enumFacing.func_96559_d();
/* 232 */             int k = p_82487_1_.func_82621_f() + enumFacing.func_82599_e();
/*     */             
/* 234 */             Material material = world.func_147439_a(i, j, k).func_149688_o();
/* 235 */             int m = world.func_72805_g(i, j, k);
/*     */ 
/*     */             
/* 238 */             if (Material.field_151586_h.equals(material) && m == 0) {
/* 239 */               item = Items.field_151131_as;
/* 240 */             } else if (Material.field_151587_i.equals(material) && m == 0) {
/* 241 */               item = Items.field_151129_at;
/*     */             } else {
/* 243 */               return super.func_82487_b(p_82487_1_, p_82487_2_);
/*     */             } 
/*     */             
/* 246 */             world.func_147468_f(i, j, k);
/* 247 */             if (--p_82487_2_.field_77994_a == 0) {
/* 248 */               p_82487_2_.func_150996_a(item);
/* 249 */               p_82487_2_.field_77994_a = 1;
/* 250 */             } else if (((TileEntityDispenser)p_82487_1_.func_150835_j()).func_146019_a(new ItemStack(item)) < 0) {
/* 251 */               this.field_150840_b.func_82482_a(p_82487_1_, new ItemStack(item));
/*     */             } 
/* 253 */             return p_82487_2_;
/*     */           }
/*     */         });
/*     */     
/* 257 */     BlockDispenser.field_149943_a.func_82595_a(Items.field_151033_d, new BehaviorDefaultDispenseItem() {
/*     */           private boolean field_150839_b = true;
/*     */           private static final String __OBFID = "CL_00001401";
/*     */           
/*     */           protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
/* 262 */             EnumFacing enumFacing = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
/* 263 */             World world = p_82487_1_.func_82618_k();
/*     */             
/* 265 */             int i = p_82487_1_.func_82623_d() + enumFacing.func_82601_c();
/* 266 */             int j = p_82487_1_.func_82622_e() + enumFacing.func_96559_d();
/* 267 */             int k = p_82487_1_.func_82621_f() + enumFacing.func_82599_e();
/*     */             
/* 269 */             if (world.func_147437_c(i, j, k)) {
/* 270 */               world.func_147449_b(i, j, k, (Block)Blocks.field_150480_ab);
/*     */               
/* 272 */               if (p_82487_2_.func_96631_a(1, world.field_73012_v)) {
/* 273 */                 p_82487_2_.field_77994_a = 0;
/*     */               }
/*     */             }
/* 276 */             else if (world.func_147439_a(i, j, k) == Blocks.field_150335_W) {
/* 277 */               Blocks.field_150335_W.func_149664_b(world, i, j, k, 1);
/* 278 */               world.func_147468_f(i, j, k);
/*     */             } else {
/* 280 */               this.field_150839_b = false;
/*     */             } 
/*     */ 
/*     */             
/* 284 */             return p_82487_2_;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void func_82485_a(IBlockSource p_82485_1_) {
/* 289 */             if (this.field_150839_b) {
/* 290 */               p_82485_1_.func_82618_k().func_72926_e(1000, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
/*     */             } else {
/* 292 */               p_82485_1_.func_82618_k().func_72926_e(1001, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 297 */     BlockDispenser.field_149943_a.func_82595_a(Items.field_151100_aR, new BehaviorDefaultDispenseItem() {
/*     */           private boolean field_150838_b = true;
/*     */           private static final String __OBFID = "CL_00001402";
/*     */           
/*     */           protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
/* 302 */             if (p_82487_2_.func_77960_j() == 15) {
/* 303 */               EnumFacing enumFacing = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
/* 304 */               World world = p_82487_1_.func_82618_k();
/*     */               
/* 306 */               int i = p_82487_1_.func_82623_d() + enumFacing.func_82601_c();
/* 307 */               int j = p_82487_1_.func_82622_e() + enumFacing.func_96559_d();
/* 308 */               int k = p_82487_1_.func_82621_f() + enumFacing.func_82599_e();
/*     */               
/* 310 */               if (ItemDye.func_150919_a(p_82487_2_, world, i, j, k)) {
/* 311 */                 if (!world.field_72995_K) world.func_72926_e(2005, i, j, k, 0); 
/*     */               } else {
/* 313 */                 this.field_150838_b = false;
/*     */               } 
/*     */               
/* 316 */               return p_82487_2_;
/*     */             } 
/* 318 */             return super.func_82487_b(p_82487_1_, p_82487_2_);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected void func_82485_a(IBlockSource p_82485_1_) {
/* 324 */             if (this.field_150838_b) {
/* 325 */               p_82485_1_.func_82618_k().func_72926_e(1000, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
/*     */             } else {
/* 327 */               p_82485_1_.func_82618_k().func_72926_e(1001, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 332 */     BlockDispenser.field_149943_a.func_82595_a(Item.func_150898_a(Blocks.field_150335_W), new BehaviorDefaultDispenseItem() { private static final String __OBFID = "CL_00001403";
/*     */           
/*     */           protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
/* 335 */             EnumFacing enumFacing = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
/* 336 */             World world = p_82487_1_.func_82618_k();
/*     */             
/* 338 */             int i = p_82487_1_.func_82623_d() + enumFacing.func_82601_c();
/* 339 */             int j = p_82487_1_.func_82622_e() + enumFacing.func_96559_d();
/* 340 */             int k = p_82487_1_.func_82621_f() + enumFacing.func_82599_e();
/*     */             
/* 342 */             EntityTNTPrimed entityTNTPrimed = new EntityTNTPrimed(world, (i + 0.5F), (j + 0.5F), (k + 0.5F), null);
/* 343 */             world.func_72838_d((Entity)entityTNTPrimed);
/*     */             
/* 345 */             p_82487_2_.field_77994_a--;
/* 346 */             return p_82487_2_;
/*     */           } }
/*     */       );
/*     */   } private static final String __OBFID = "CL_00001397";
/*     */   
/*     */   public static void func_151354_b() {
/* 352 */     if (field_151355_a)
/* 353 */       return;  field_151355_a = true;
/*     */     
/* 355 */     Block.func_149671_p();
/* 356 */     BlockFire.func_149843_e();
/*     */     
/* 358 */     Item.func_150900_l();
/* 359 */     StatList.func_151178_a();
/*     */     
/* 361 */     func_151353_a();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\init\Bootstrap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */