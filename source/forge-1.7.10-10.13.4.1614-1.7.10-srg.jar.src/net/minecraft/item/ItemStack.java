/*     */ package net.minecraft.item;
/*     */ import com.google.common.collect.HashMultimap;
/*     */ import com.google.common.collect.Multimap;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.item.EntityItemFrame;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public final class ItemStack {
/*  25 */   public static final DecimalFormat field_111284_a = new DecimalFormat("#.###");
/*     */ 
/*     */   
/*     */   public int field_77994_a;
/*     */ 
/*     */   
/*     */   public int field_77992_b;
/*     */ 
/*     */   
/*     */   private Item field_151002_e;
/*     */ 
/*     */   
/*     */   public NBTTagCompound field_77990_d;
/*     */ 
/*     */   
/*     */   int field_77991_e;
/*     */ 
/*     */   
/*     */   private EntityItemFrame field_82843_f;
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00000043";
/*     */ 
/*     */   
/*     */   public ItemStack(Block p_i1876_1_) {
/*  50 */     this(p_i1876_1_, 1);
/*     */   }
/*     */   
/*     */   public ItemStack(Block p_i1877_1_, int p_i1877_2_) {
/*  54 */     this(p_i1877_1_, p_i1877_2_, 0);
/*     */   }
/*     */   
/*     */   public ItemStack(Block p_i1878_1_, int p_i1878_2_, int p_i1878_3_) {
/*  58 */     this(Item.func_150898_a(p_i1878_1_), p_i1878_2_, p_i1878_3_);
/*     */   }
/*     */   
/*     */   public ItemStack(Item p_i1879_1_) {
/*  62 */     this(p_i1879_1_, 1);
/*     */   }
/*     */   
/*     */   public ItemStack(Item p_i1880_1_, int p_i1880_2_) {
/*  66 */     this(p_i1880_1_, p_i1880_2_, 0);
/*     */   }
/*     */   
/*     */   public ItemStack(Item p_i1881_1_, int p_i1881_2_, int p_i1881_3_) {
/*  70 */     this.field_151002_e = p_i1881_1_;
/*  71 */     this.field_77994_a = p_i1881_2_;
/*  72 */     this.field_77991_e = p_i1881_3_;
/*  73 */     if (this.field_77991_e < 0) {
/*  74 */       this.field_77991_e = 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public static ItemStack func_77949_a(NBTTagCompound p_77949_0_) {
/*  79 */     ItemStack itemStack = new ItemStack();
/*  80 */     itemStack.func_77963_c(p_77949_0_);
/*  81 */     return (itemStack.func_77973_b() != null) ? itemStack : null;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack() {}
/*     */   
/*     */   public ItemStack func_77979_a(int p_77979_1_) {
/*  88 */     ItemStack itemStack = new ItemStack(this.field_151002_e, p_77979_1_, this.field_77991_e);
/*  89 */     if (this.field_77990_d != null) itemStack.field_77990_d = (NBTTagCompound)this.field_77990_d.func_74737_b(); 
/*  90 */     this.field_77994_a -= p_77979_1_;
/*  91 */     return itemStack;
/*     */   }
/*     */   
/*     */   public Item func_77973_b() {
/*  95 */     return this.field_151002_e;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_77954_c() {
/*  99 */     return func_77973_b().func_77650_f(this);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_94608_d() {
/* 103 */     return func_77973_b().func_94901_k();
/*     */   }
/*     */   
/*     */   public boolean func_77943_a(EntityPlayer p_77943_1_, World p_77943_2_, int p_77943_3_, int p_77943_4_, int p_77943_5_, int p_77943_6_, float p_77943_7_, float p_77943_8_, float p_77943_9_) {
/* 107 */     boolean bool = func_77973_b().func_77648_a(this, p_77943_1_, p_77943_2_, p_77943_3_, p_77943_4_, p_77943_5_, p_77943_6_, p_77943_7_, p_77943_8_, p_77943_9_);
/* 108 */     if (bool) p_77943_1_.func_71064_a(StatList.field_75929_E[Item.func_150891_b(this.field_151002_e)], 1); 
/* 109 */     return bool;
/*     */   }
/*     */   
/*     */   public float func_150997_a(Block p_150997_1_) {
/* 113 */     return func_77973_b().func_150893_a(this, p_150997_1_);
/*     */   }
/*     */   
/*     */   public ItemStack func_77957_a(World p_77957_1_, EntityPlayer p_77957_2_) {
/* 117 */     return func_77973_b().func_77659_a(this, p_77957_1_, p_77957_2_);
/*     */   }
/*     */   
/*     */   public ItemStack func_77950_b(World p_77950_1_, EntityPlayer p_77950_2_) {
/* 121 */     return func_77973_b().func_77654_b(this, p_77950_1_, p_77950_2_);
/*     */   }
/*     */   
/*     */   public NBTTagCompound func_77955_b(NBTTagCompound p_77955_1_) {
/* 125 */     p_77955_1_.func_74777_a("id", (short)Item.func_150891_b(this.field_151002_e));
/* 126 */     p_77955_1_.func_74774_a("Count", (byte)this.field_77994_a);
/* 127 */     p_77955_1_.func_74777_a("Damage", (short)this.field_77991_e);
/* 128 */     if (this.field_77990_d != null) p_77955_1_.func_74782_a("tag", (NBTBase)this.field_77990_d); 
/* 129 */     return p_77955_1_;
/*     */   }
/*     */   
/*     */   public void func_77963_c(NBTTagCompound p_77963_1_) {
/* 133 */     this.field_151002_e = Item.func_150899_d(p_77963_1_.func_74765_d("id"));
/* 134 */     this.field_77994_a = p_77963_1_.func_74771_c("Count");
/* 135 */     this.field_77991_e = p_77963_1_.func_74765_d("Damage");
/* 136 */     if (this.field_77991_e < 0) {
/* 137 */       this.field_77991_e = 0;
/*     */     }
/* 139 */     if (p_77963_1_.func_150297_b("tag", 10)) this.field_77990_d = p_77963_1_.func_74775_l("tag"); 
/*     */   }
/*     */   
/*     */   public int func_77976_d() {
/* 143 */     return func_77973_b().func_77639_j();
/*     */   }
/*     */   
/*     */   public boolean func_77985_e() {
/* 147 */     return (func_77976_d() > 1 && (!func_77984_f() || !func_77951_h()));
/*     */   }
/*     */   
/*     */   public boolean func_77984_f() {
/* 151 */     if (this.field_151002_e.func_77612_l() <= 0) {
/* 152 */       return false;
/*     */     }
/* 154 */     if (func_77942_o() && func_77978_p().func_74767_n("Unbreakable")) {
/* 155 */       return false;
/*     */     }
/* 157 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77981_g() {
/* 167 */     return this.field_151002_e.func_77614_k();
/*     */   }
/*     */   
/*     */   public boolean func_77951_h() {
/* 171 */     return (func_77984_f() && this.field_77991_e > 0);
/*     */   }
/*     */   
/*     */   public int func_77952_i() {
/* 175 */     return this.field_77991_e;
/*     */   }
/*     */   
/*     */   public int func_77960_j() {
/* 179 */     return this.field_77991_e;
/*     */   }
/*     */   
/*     */   public void func_77964_b(int p_77964_1_) {
/* 183 */     this.field_77991_e = p_77964_1_;
/* 184 */     if (this.field_77991_e < 0) {
/* 185 */       this.field_77991_e = 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public int func_77958_k() {
/* 190 */     return this.field_151002_e.func_77612_l();
/*     */   }
/*     */   
/*     */   public boolean func_96631_a(int p_96631_1_, Random p_96631_2_) {
/* 194 */     if (!func_77984_f()) {
/* 195 */       return false;
/*     */     }
/*     */     
/* 198 */     if (p_96631_1_ > 0) {
/* 199 */       int i = EnchantmentHelper.func_77506_a(Enchantment.field_77347_r.field_77352_x, this);
/*     */       
/* 201 */       byte b1 = 0;
/* 202 */       for (byte b2 = 0; i > 0 && b2 < p_96631_1_; b2++) {
/* 203 */         if (EnchantmentDurability.func_92097_a(this, i, p_96631_2_)) {
/* 204 */           b1++;
/*     */         }
/*     */       } 
/* 207 */       p_96631_1_ -= b1;
/*     */       
/* 209 */       if (p_96631_1_ <= 0) return false;
/*     */     
/*     */     } 
/* 212 */     this.field_77991_e += p_96631_1_;
/*     */     
/* 214 */     return (this.field_77991_e > func_77958_k());
/*     */   }
/*     */   
/*     */   public void func_77972_a(int p_77972_1_, EntityLivingBase p_77972_2_) {
/* 218 */     if (p_77972_2_ instanceof EntityPlayer && ((EntityPlayer)p_77972_2_).field_71075_bZ.field_75098_d)
/* 219 */       return;  if (!func_77984_f())
/*     */       return; 
/* 221 */     if (func_96631_a(p_77972_1_, p_77972_2_.func_70681_au())) {
/* 222 */       p_77972_2_.func_70669_a(this);
/*     */       
/* 224 */       this.field_77994_a--;
/* 225 */       if (p_77972_2_ instanceof EntityPlayer) {
/* 226 */         EntityPlayer entityPlayer = (EntityPlayer)p_77972_2_;
/* 227 */         entityPlayer.func_71064_a(StatList.field_75930_F[Item.func_150891_b(this.field_151002_e)], 1);
/* 228 */         if (this.field_77994_a == 0 && func_77973_b() instanceof ItemBow) {
/* 229 */           entityPlayer.func_71028_bD();
/*     */         }
/*     */       } 
/* 232 */       if (this.field_77994_a < 0) this.field_77994_a = 0; 
/* 233 */       this.field_77991_e = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_77961_a(EntityLivingBase p_77961_1_, EntityPlayer p_77961_2_) {
/* 238 */     boolean bool = this.field_151002_e.func_77644_a(this, p_77961_1_, (EntityLivingBase)p_77961_2_);
/* 239 */     if (bool) {
/* 240 */       p_77961_2_.func_71064_a(StatList.field_75929_E[Item.func_150891_b(this.field_151002_e)], 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_150999_a(World p_150999_1_, Block p_150999_2_, int p_150999_3_, int p_150999_4_, int p_150999_5_, EntityPlayer p_150999_6_) {
/* 245 */     boolean bool = this.field_151002_e.func_150894_a(this, p_150999_1_, p_150999_2_, p_150999_3_, p_150999_4_, p_150999_5_, (EntityLivingBase)p_150999_6_);
/* 246 */     if (bool) {
/* 247 */       p_150999_6_.func_71064_a(StatList.field_75929_E[Item.func_150891_b(this.field_151002_e)], 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_150998_b(Block p_150998_1_) {
/* 252 */     return this.field_151002_e.func_150897_b(p_150998_1_);
/*     */   }
/*     */   
/*     */   public boolean func_111282_a(EntityPlayer p_111282_1_, EntityLivingBase p_111282_2_) {
/* 256 */     return this.field_151002_e.func_111207_a(this, p_111282_1_, p_111282_2_);
/*     */   }
/*     */   
/*     */   public ItemStack func_77946_l() {
/* 260 */     ItemStack itemStack = new ItemStack(this.field_151002_e, this.field_77994_a, this.field_77991_e);
/* 261 */     if (this.field_77990_d != null) {
/* 262 */       itemStack.field_77990_d = (NBTTagCompound)this.field_77990_d.func_74737_b();
/*     */     }
/* 264 */     return itemStack;
/*     */   }
/*     */   
/*     */   public static boolean func_77970_a(ItemStack p_77970_0_, ItemStack p_77970_1_) {
/* 268 */     if (p_77970_0_ == null && p_77970_1_ == null) return true; 
/* 269 */     if (p_77970_0_ == null || p_77970_1_ == null) return false;
/*     */     
/* 271 */     if (p_77970_0_.field_77990_d == null && p_77970_1_.field_77990_d != null) {
/* 272 */       return false;
/*     */     }
/* 274 */     if (p_77970_0_.field_77990_d != null && !p_77970_0_.field_77990_d.equals(p_77970_1_.field_77990_d)) {
/* 275 */       return false;
/*     */     }
/* 277 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean func_77989_b(ItemStack p_77989_0_, ItemStack p_77989_1_) {
/* 281 */     if (p_77989_0_ == null && p_77989_1_ == null) return true; 
/* 282 */     if (p_77989_0_ == null || p_77989_1_ == null) return false; 
/* 283 */     return p_77989_0_.func_77959_d(p_77989_1_);
/*     */   }
/*     */   
/*     */   private boolean func_77959_d(ItemStack p_77959_1_) {
/* 287 */     if (this.field_77994_a != p_77959_1_.field_77994_a) return false; 
/* 288 */     if (this.field_151002_e != p_77959_1_.field_151002_e) return false; 
/* 289 */     if (this.field_77991_e != p_77959_1_.field_77991_e) return false; 
/* 290 */     if (this.field_77990_d == null && p_77959_1_.field_77990_d != null) {
/* 291 */       return false;
/*     */     }
/* 293 */     if (this.field_77990_d != null && !this.field_77990_d.equals(p_77959_1_.field_77990_d)) {
/* 294 */       return false;
/*     */     }
/* 296 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77969_a(ItemStack p_77969_1_) {
/* 307 */     return (this.field_151002_e == p_77969_1_.field_151002_e && this.field_77991_e == p_77969_1_.field_77991_e);
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_77977_a() {
/* 312 */     return this.field_151002_e.func_77667_c(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemStack func_77944_b(ItemStack p_77944_0_) {
/* 321 */     return (p_77944_0_ == null) ? null : p_77944_0_.func_77946_l();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 326 */     return this.field_77994_a + "x" + this.field_151002_e.func_77658_a() + "@" + this.field_77991_e;
/*     */   }
/*     */   
/*     */   public void func_77945_a(World p_77945_1_, Entity p_77945_2_, int p_77945_3_, boolean p_77945_4_) {
/* 330 */     if (this.field_77992_b > 0) this.field_77992_b--; 
/* 331 */     this.field_151002_e.func_77663_a(this, p_77945_1_, p_77945_2_, p_77945_3_, p_77945_4_);
/*     */   }
/*     */   
/*     */   public void func_77980_a(World p_77980_1_, EntityPlayer p_77980_2_, int p_77980_3_) {
/* 335 */     p_77980_2_.func_71064_a(StatList.field_75928_D[Item.func_150891_b(this.field_151002_e)], p_77980_3_);
/* 336 */     this.field_151002_e.func_77622_d(this, p_77980_1_, p_77980_2_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77988_m() {
/* 344 */     return func_77973_b().func_77626_a(this);
/*     */   }
/*     */   
/*     */   public EnumAction func_77975_n() {
/* 348 */     return func_77973_b().func_77661_b(this);
/*     */   }
/*     */   
/*     */   public void func_77974_b(World p_77974_1_, EntityPlayer p_77974_2_, int p_77974_3_) {
/* 352 */     func_77973_b().func_77615_a(this, p_77974_1_, p_77974_2_, p_77974_3_);
/*     */   }
/*     */   
/*     */   public boolean func_77942_o() {
/* 356 */     return (this.field_77990_d != null);
/*     */   }
/*     */   
/*     */   public NBTTagCompound func_77978_p() {
/* 360 */     return this.field_77990_d;
/*     */   }
/*     */   
/*     */   public NBTTagList func_77986_q() {
/* 364 */     if (this.field_77990_d == null) {
/* 365 */       return null;
/*     */     }
/* 367 */     return this.field_77990_d.func_150295_c("ench", 10);
/*     */   }
/*     */   
/*     */   public void func_77982_d(NBTTagCompound p_77982_1_) {
/* 371 */     this.field_77990_d = p_77982_1_;
/*     */   }
/*     */   
/*     */   public String func_82833_r() {
/* 375 */     String str = func_77973_b().func_77653_i(this);
/*     */     
/* 377 */     if (this.field_77990_d != null && this.field_77990_d.func_150297_b("display", 10)) {
/* 378 */       NBTTagCompound nBTTagCompound = this.field_77990_d.func_74775_l("display");
/*     */       
/* 380 */       if (nBTTagCompound.func_150297_b("Name", 8)) {
/* 381 */         str = nBTTagCompound.func_74779_i("Name");
/*     */       }
/*     */     } 
/*     */     
/* 385 */     return str;
/*     */   }
/*     */   
/*     */   public ItemStack func_151001_c(String p_151001_1_) {
/* 389 */     if (this.field_77990_d == null) this.field_77990_d = new NBTTagCompound(); 
/* 390 */     if (!this.field_77990_d.func_150297_b("display", 10)) this.field_77990_d.func_74782_a("display", (NBTBase)new NBTTagCompound()); 
/* 391 */     this.field_77990_d.func_74775_l("display").func_74778_a("Name", p_151001_1_);
/* 392 */     return this;
/*     */   }
/*     */   
/*     */   public void func_135074_t() {
/* 396 */     if (this.field_77990_d == null)
/* 397 */       return;  if (!this.field_77990_d.func_150297_b("display", 10))
/* 398 */       return;  NBTTagCompound nBTTagCompound = this.field_77990_d.func_74775_l("display");
/* 399 */     nBTTagCompound.func_82580_o("Name");
/*     */     
/* 401 */     if (nBTTagCompound.func_82582_d()) {
/* 402 */       this.field_77990_d.func_82580_o("display");
/*     */       
/* 404 */       if (this.field_77990_d.func_82582_d()) {
/* 405 */         func_77982_d(null);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_82837_s() {
/* 411 */     if (this.field_77990_d == null) return false; 
/* 412 */     if (!this.field_77990_d.func_150297_b("display", 10)) return false; 
/* 413 */     return this.field_77990_d.func_74775_l("display").func_150297_b("Name", 8);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public List func_82840_a(EntityPlayer p_82840_1_, boolean p_82840_2_) {
/* 417 */     ArrayList<String> arrayList = new ArrayList();
/* 418 */     String str = func_82833_r();
/*     */     
/* 420 */     if (func_82837_s()) {
/* 421 */       str = EnumChatFormatting.ITALIC + str + EnumChatFormatting.RESET;
/*     */     }
/*     */     
/* 424 */     if (p_82840_2_) {
/* 425 */       String str1 = "";
/*     */       
/* 427 */       if (str.length() > 0) {
/* 428 */         str = str + " (";
/* 429 */         str1 = ")";
/*     */       } 
/*     */       
/* 432 */       int i = Item.func_150891_b(this.field_151002_e);
/* 433 */       if (func_77981_g()) {
/* 434 */         str = str + String.format("#%04d/%d%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.field_77991_e), str1 });
/*     */       } else {
/* 436 */         str = str + String.format("#%04d%s", new Object[] { Integer.valueOf(i), str1 });
/*     */       } 
/* 438 */     } else if (!func_82837_s() && 
/* 439 */       this.field_151002_e == Items.field_151098_aY) {
/* 440 */       str = str + " #" + this.field_77991_e;
/*     */     } 
/*     */ 
/*     */     
/* 444 */     arrayList.add(str);
/* 445 */     this.field_151002_e.func_77624_a(this, p_82840_1_, arrayList, p_82840_2_);
/*     */     
/* 447 */     if (func_77942_o()) {
/* 448 */       NBTTagList nBTTagList = func_77986_q();
/* 449 */       if (nBTTagList != null) {
/* 450 */         for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 451 */           short s1 = nBTTagList.func_150305_b(b).func_74765_d("id");
/* 452 */           short s2 = nBTTagList.func_150305_b(b).func_74765_d("lvl");
/*     */           
/* 454 */           if (Enchantment.field_77331_b[s1] != null) {
/* 455 */             arrayList.add(Enchantment.field_77331_b[s1].func_77316_c(s2));
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 460 */       if (this.field_77990_d.func_150297_b("display", 10)) {
/* 461 */         NBTTagCompound nBTTagCompound = this.field_77990_d.func_74775_l("display");
/*     */         
/* 463 */         if (nBTTagCompound.func_150297_b("color", 3)) {
/* 464 */           if (p_82840_2_) {
/* 465 */             arrayList.add("Color: #" + Integer.toHexString(nBTTagCompound.func_74762_e("color")).toUpperCase());
/*     */           } else {
/* 467 */             arrayList.add(EnumChatFormatting.ITALIC + StatCollector.func_74838_a("item.dyed"));
/*     */           } 
/*     */         }
/*     */         
/* 471 */         if (nBTTagCompound.func_150299_b("Lore") == 9) {
/* 472 */           NBTTagList nBTTagList1 = nBTTagCompound.func_150295_c("Lore", 8);
/* 473 */           if (nBTTagList1.func_74745_c() > 0) {
/* 474 */             for (byte b = 0; b < nBTTagList1.func_74745_c(); b++) {
/* 475 */               arrayList.add(EnumChatFormatting.DARK_PURPLE + "" + EnumChatFormatting.ITALIC + nBTTagList1.func_150307_f(b));
/*     */             }
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 482 */     Multimap multimap = func_111283_C();
/*     */     
/* 484 */     if (!multimap.isEmpty()) {
/* 485 */       arrayList.add("");
/* 486 */       for (Map.Entry entry : multimap.entries()) {
/* 487 */         double d2; AttributeModifier attributeModifier = (AttributeModifier)entry.getValue();
/* 488 */         double d1 = attributeModifier.func_111164_d();
/*     */ 
/*     */         
/* 491 */         if (attributeModifier.func_111167_a() == Item.field_111210_e) {
/* 492 */           d1 += EnchantmentHelper.func_152377_a(this, EnumCreatureAttribute.UNDEFINED);
/*     */         }
/*     */         
/* 495 */         if (attributeModifier.func_111169_c() == 1 || attributeModifier.func_111169_c() == 2) {
/* 496 */           d2 = d1 * 100.0D;
/*     */         } else {
/* 498 */           d2 = d1;
/*     */         } 
/*     */         
/* 501 */         if (d1 > 0.0D) {
/* 502 */           arrayList.add(EnumChatFormatting.BLUE + StatCollector.func_74837_a("attribute.modifier.plus." + attributeModifier.func_111169_c(), new Object[] { field_111284_a.format(d2), StatCollector.func_74838_a("attribute.name." + (String)entry.getKey()) })); continue;
/*     */         } 
/* 504 */         if (d1 < 0.0D) {
/* 505 */           d2 *= -1.0D;
/* 506 */           arrayList.add(EnumChatFormatting.RED + StatCollector.func_74837_a("attribute.modifier.take." + attributeModifier.func_111169_c(), new Object[] { field_111284_a.format(d2), StatCollector.func_74838_a("attribute.name." + (String)entry.getKey()) }));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 511 */     if (func_77942_o() && func_77978_p().func_74767_n("Unbreakable")) {
/* 512 */       arrayList.add(EnumChatFormatting.BLUE + StatCollector.func_74838_a("item.unbreakable"));
/*     */     }
/*     */     
/* 515 */     if (p_82840_2_ && 
/* 516 */       func_77951_h()) {
/* 517 */       arrayList.add("Durability: " + (func_77958_k() - func_77952_i()) + " / " + func_77958_k());
/*     */     }
/*     */ 
/*     */     
/* 521 */     return arrayList;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77962_s() {
/* 525 */     return func_77973_b().func_77636_d(this);
/*     */   }
/*     */   
/*     */   public EnumRarity func_77953_t() {
/* 529 */     return func_77973_b().func_77613_e(this);
/*     */   }
/*     */   
/*     */   public boolean func_77956_u() {
/* 533 */     if (!func_77973_b().func_77616_k(this)) return false; 
/* 534 */     if (func_77948_v()) return false; 
/* 535 */     return true;
/*     */   }
/*     */   
/*     */   public void func_77966_a(Enchantment p_77966_1_, int p_77966_2_) {
/* 539 */     if (this.field_77990_d == null) func_77982_d(new NBTTagCompound()); 
/* 540 */     if (!this.field_77990_d.func_150297_b("ench", 9)) this.field_77990_d.func_74782_a("ench", (NBTBase)new NBTTagList()); 
/* 541 */     NBTTagList nBTTagList = this.field_77990_d.func_150295_c("ench", 10);
/* 542 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 543 */     nBTTagCompound.func_74777_a("id", (short)p_77966_1_.field_77352_x);
/* 544 */     nBTTagCompound.func_74777_a("lvl", (short)(byte)p_77966_2_);
/* 545 */     nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*     */   }
/*     */   
/*     */   public boolean func_77948_v() {
/* 549 */     if (this.field_77990_d != null && this.field_77990_d.func_150297_b("ench", 9)) return true; 
/* 550 */     return false;
/*     */   }
/*     */   
/*     */   public void func_77983_a(String p_77983_1_, NBTBase p_77983_2_) {
/* 554 */     if (this.field_77990_d == null) {
/* 555 */       func_77982_d(new NBTTagCompound());
/*     */     }
/* 557 */     this.field_77990_d.func_74782_a(p_77983_1_, p_77983_2_);
/*     */   }
/*     */   
/*     */   public boolean func_82835_x() {
/* 561 */     return func_77973_b().func_82788_x();
/*     */   }
/*     */   
/*     */   public boolean func_82839_y() {
/* 565 */     return (this.field_82843_f != null);
/*     */   }
/*     */   
/*     */   public void func_82842_a(EntityItemFrame p_82842_1_) {
/* 569 */     this.field_82843_f = p_82842_1_;
/*     */   }
/*     */   
/*     */   public EntityItemFrame func_82836_z() {
/* 573 */     return this.field_82843_f;
/*     */   }
/*     */   
/*     */   public int func_82838_A() {
/* 577 */     if (func_77942_o() && this.field_77990_d.func_150297_b("RepairCost", 3)) {
/* 578 */       return this.field_77990_d.func_74762_e("RepairCost");
/*     */     }
/* 580 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82841_c(int p_82841_1_) {
/* 585 */     if (!func_77942_o()) this.field_77990_d = new NBTTagCompound(); 
/* 586 */     this.field_77990_d.func_74768_a("RepairCost", p_82841_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public Multimap func_111283_C() {
/*     */     Multimap multimap;
/* 592 */     if (func_77942_o() && this.field_77990_d.func_150297_b("AttributeModifiers", 9)) {
/* 593 */       HashMultimap hashMultimap = HashMultimap.create();
/* 594 */       NBTTagList nBTTagList = this.field_77990_d.func_150295_c("AttributeModifiers", 10);
/*     */       
/* 596 */       for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 597 */         NBTTagCompound nBTTagCompound = nBTTagList.func_150305_b(b);
/* 598 */         AttributeModifier attributeModifier = SharedMonsterAttributes.func_111259_a(nBTTagCompound);
/*     */         
/* 600 */         if (attributeModifier.func_111167_a().getLeastSignificantBits() != 0L && attributeModifier.func_111167_a().getMostSignificantBits() != 0L) {
/* 601 */           hashMultimap.put(nBTTagCompound.func_74779_i("AttributeName"), attributeModifier);
/*     */         }
/*     */       } 
/*     */     } else {
/* 605 */       multimap = func_77973_b().func_111205_h();
/*     */     } 
/*     */     
/* 608 */     return multimap;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_150996_a(Item p_150996_1_) {
/* 614 */     this.field_151002_e = p_150996_1_;
/*     */   }
/*     */   
/*     */   public IChatComponent func_151000_E() {
/* 618 */     IChatComponent iChatComponent = (new ChatComponentText("[")).func_150258_a(func_82833_r()).func_150258_a("]");
/*     */     
/* 620 */     if (this.field_151002_e != null) {
/* 621 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 622 */       func_77955_b(nBTTagCompound);
/*     */       
/* 624 */       iChatComponent.func_150256_b().func_150209_a(new HoverEvent(HoverEvent.Action.SHOW_ITEM, (IChatComponent)new ChatComponentText(nBTTagCompound.toString())));
/* 625 */       iChatComponent.func_150256_b().func_150238_a((func_77953_t()).field_77937_e);
/*     */     } 
/*     */     
/* 628 */     return iChatComponent;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */