/*     */ package net.minecraft.village;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.TreeMap;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.monster.EntityIronGolem;
/*     */ import net.minecraft.entity.passive.EntityVillager;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class Village {
/*  22 */   private final List field_75584_b = new ArrayList();
/*     */   private World field_75586_a;
/*  24 */   private final ChunkCoordinates field_75585_c = new ChunkCoordinates(0, 0, 0);
/*  25 */   private final ChunkCoordinates field_75582_d = new ChunkCoordinates(0, 0, 0);
/*     */   
/*     */   private int field_75583_e;
/*     */   private int field_75580_f;
/*     */   private int field_75581_g;
/*     */   private int field_75588_h;
/*     */   private int field_82694_i;
/*  32 */   private TreeMap field_82693_j = new TreeMap<Object, Object>();
/*     */   class VillageAgressor { public EntityLivingBase field_75592_a;
/*     */     
/*     */     VillageAgressor(Village p_i1674_1_, EntityLivingBase p_i1674_2_, int p_i1674_3_) {
/*  36 */       this.field_75592_a = p_i1674_2_;
/*  37 */       this.field_75590_b = p_i1674_3_;
/*     */     }
/*     */ 
/*     */     
/*     */     public int field_75590_b;
/*     */     private static final String __OBFID = "CL_00001632"; }
/*     */   
/*  44 */   private List field_75589_i = new ArrayList();
/*     */   
/*     */   private int field_75587_j;
/*     */   private static final String __OBFID = "CL_00001631";
/*     */   
/*     */   public Village() {}
/*     */   
/*     */   public Village(World p_i1675_1_) {
/*  52 */     this.field_75586_a = p_i1675_1_;
/*     */   }
/*     */   
/*     */   public void func_82691_a(World p_82691_1_) {
/*  56 */     this.field_75586_a = p_82691_1_;
/*     */   }
/*     */   
/*     */   public void func_75560_a(int p_75560_1_) {
/*  60 */     this.field_75581_g = p_75560_1_;
/*  61 */     func_75557_k();
/*  62 */     func_75565_j();
/*  63 */     if (p_75560_1_ % 20 == 0) func_75572_i(); 
/*  64 */     if (p_75560_1_ % 30 == 0) func_75579_h();
/*     */     
/*  66 */     int i = this.field_75588_h / 10;
/*  67 */     if (this.field_75587_j < i && this.field_75584_b.size() > 20 && this.field_75586_a.field_73012_v.nextInt(7000) == 0) {
/*  68 */       Vec3 vec3 = func_75559_a(MathHelper.func_76141_d(this.field_75582_d.field_71574_a), MathHelper.func_76141_d(this.field_75582_d.field_71572_b), MathHelper.func_76141_d(this.field_75582_d.field_71573_c), 2, 4, 2);
/*  69 */       if (vec3 != null) {
/*  70 */         EntityIronGolem entityIronGolem = new EntityIronGolem(this.field_75586_a);
/*  71 */         entityIronGolem.func_70107_b(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c);
/*  72 */         this.field_75586_a.func_72838_d((Entity)entityIronGolem);
/*  73 */         this.field_75587_j++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Vec3 func_75559_a(int p_75559_1_, int p_75559_2_, int p_75559_3_, int p_75559_4_, int p_75559_5_, int p_75559_6_) {
/*  81 */     for (byte b = 0; b < 10; b++) {
/*  82 */       int i = p_75559_1_ + this.field_75586_a.field_73012_v.nextInt(16) - 8;
/*  83 */       int j = p_75559_2_ + this.field_75586_a.field_73012_v.nextInt(6) - 3;
/*  84 */       int k = p_75559_3_ + this.field_75586_a.field_73012_v.nextInt(16) - 8;
/*  85 */       if (func_75570_a(i, j, k) && 
/*  86 */         func_75563_b(i, j, k, p_75559_4_, p_75559_5_, p_75559_6_)) return Vec3.func_72443_a(i, j, k); 
/*     */     } 
/*  88 */     return null;
/*     */   }
/*     */   
/*     */   private boolean func_75563_b(int p_75563_1_, int p_75563_2_, int p_75563_3_, int p_75563_4_, int p_75563_5_, int p_75563_6_) {
/*  92 */     if (!World.func_147466_a((IBlockAccess)this.field_75586_a, p_75563_1_, p_75563_2_ - 1, p_75563_3_)) return false;
/*     */     
/*  94 */     int i = p_75563_1_ - p_75563_4_ / 2;
/*  95 */     int j = p_75563_3_ - p_75563_6_ / 2;
/*  96 */     for (int k = i; k < i + p_75563_4_; k++) {
/*  97 */       for (int m = p_75563_2_; m < p_75563_2_ + p_75563_5_; m++) {
/*  98 */         for (int n = j; n < j + p_75563_6_; n++) {
/*  99 */           if (this.field_75586_a.func_147439_a(k, m, n).func_149721_r()) return false; 
/*     */         } 
/*     */       } 
/* 102 */     }  return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_75579_h() {
/* 107 */     List list = this.field_75586_a.func_72872_a(EntityIronGolem.class, AxisAlignedBB.func_72330_a((this.field_75582_d.field_71574_a - this.field_75583_e), (this.field_75582_d.field_71572_b - 4), (this.field_75582_d.field_71573_c - this.field_75583_e), (this.field_75582_d.field_71574_a + this.field_75583_e), (this.field_75582_d.field_71572_b + 4), (this.field_75582_d.field_71573_c + this.field_75583_e)));
/*     */     
/* 109 */     this.field_75587_j = list.size();
/*     */   }
/*     */   
/*     */   private void func_75572_i() {
/* 113 */     List list = this.field_75586_a.func_72872_a(EntityVillager.class, AxisAlignedBB.func_72330_a((this.field_75582_d.field_71574_a - this.field_75583_e), (this.field_75582_d.field_71572_b - 4), (this.field_75582_d.field_71573_c - this.field_75583_e), (this.field_75582_d.field_71574_a + this.field_75583_e), (this.field_75582_d.field_71572_b + 4), (this.field_75582_d.field_71573_c + this.field_75583_e)));
/*     */     
/* 115 */     this.field_75588_h = list.size();
/*     */     
/* 117 */     if (this.field_75588_h == 0)
/*     */     {
/* 119 */       this.field_82693_j.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   public ChunkCoordinates func_75577_a() {
/* 124 */     return this.field_75582_d;
/*     */   }
/*     */   
/*     */   public int func_75568_b() {
/* 128 */     return this.field_75583_e;
/*     */   }
/*     */   
/*     */   public int func_75567_c() {
/* 132 */     return this.field_75584_b.size();
/*     */   }
/*     */   
/*     */   public int func_75561_d() {
/* 136 */     return this.field_75581_g - this.field_75580_f;
/*     */   }
/*     */   
/*     */   public int func_75562_e() {
/* 140 */     return this.field_75588_h;
/*     */   }
/*     */   
/*     */   public boolean func_75570_a(int p_75570_1_, int p_75570_2_, int p_75570_3_) {
/* 144 */     return (this.field_75582_d.func_71569_e(p_75570_1_, p_75570_2_, p_75570_3_) < (this.field_75583_e * this.field_75583_e));
/*     */   }
/*     */   
/*     */   public List func_75558_f() {
/* 148 */     return this.field_75584_b;
/*     */   }
/*     */   
/*     */   public VillageDoorInfo func_75564_b(int p_75564_1_, int p_75564_2_, int p_75564_3_) {
/* 152 */     VillageDoorInfo villageDoorInfo = null;
/* 153 */     int i = Integer.MAX_VALUE;
/* 154 */     for (VillageDoorInfo villageDoorInfo1 : this.field_75584_b) {
/* 155 */       int j = villageDoorInfo1.func_75474_b(p_75564_1_, p_75564_2_, p_75564_3_);
/* 156 */       if (j < i) {
/* 157 */         villageDoorInfo = villageDoorInfo1;
/* 158 */         i = j;
/*     */       } 
/*     */     } 
/* 161 */     return villageDoorInfo;
/*     */   }
/*     */   
/*     */   public VillageDoorInfo func_75569_c(int p_75569_1_, int p_75569_2_, int p_75569_3_) {
/* 165 */     VillageDoorInfo villageDoorInfo = null;
/* 166 */     int i = Integer.MAX_VALUE;
/* 167 */     for (VillageDoorInfo villageDoorInfo1 : this.field_75584_b) {
/*     */       
/* 169 */       int j = villageDoorInfo1.func_75474_b(p_75569_1_, p_75569_2_, p_75569_3_);
/* 170 */       if (j > 256) { j *= 1000; }
/* 171 */       else { j = villageDoorInfo1.func_75468_f(); }
/*     */       
/* 173 */       if (j < i) {
/* 174 */         villageDoorInfo = villageDoorInfo1;
/* 175 */         i = j;
/*     */       } 
/*     */     } 
/* 178 */     return villageDoorInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VillageDoorInfo func_75578_e(int p_75578_1_, int p_75578_2_, int p_75578_3_) {
/* 186 */     if (this.field_75582_d.func_71569_e(p_75578_1_, p_75578_2_, p_75578_3_) > (this.field_75583_e * this.field_75583_e)) return null; 
/* 187 */     for (VillageDoorInfo villageDoorInfo : this.field_75584_b) {
/* 188 */       if (villageDoorInfo.field_75481_a == p_75578_1_ && villageDoorInfo.field_75480_c == p_75578_3_ && Math.abs(villageDoorInfo.field_75479_b - p_75578_2_) <= 1) return villageDoorInfo; 
/* 189 */     }  return null;
/*     */   }
/*     */   
/*     */   public void func_75576_a(VillageDoorInfo p_75576_1_) {
/* 193 */     this.field_75584_b.add(p_75576_1_);
/* 194 */     this.field_75585_c.field_71574_a += p_75576_1_.field_75481_a;
/* 195 */     this.field_75585_c.field_71572_b += p_75576_1_.field_75479_b;
/* 196 */     this.field_75585_c.field_71573_c += p_75576_1_.field_75480_c;
/* 197 */     func_75573_l();
/* 198 */     this.field_75580_f = p_75576_1_.field_75475_f;
/*     */   }
/*     */   
/*     */   public boolean func_75566_g() {
/* 202 */     return this.field_75584_b.isEmpty();
/*     */   }
/*     */   
/*     */   public void func_75575_a(EntityLivingBase p_75575_1_) {
/* 206 */     for (VillageAgressor villageAgressor : this.field_75589_i) {
/* 207 */       if (villageAgressor.field_75592_a == p_75575_1_) {
/* 208 */         villageAgressor.field_75590_b = this.field_75581_g;
/*     */         return;
/*     */       } 
/*     */     } 
/* 212 */     this.field_75589_i.add(new VillageAgressor(this, p_75575_1_, this.field_75581_g));
/*     */   }
/*     */   
/*     */   public EntityLivingBase func_75571_b(EntityLivingBase p_75571_1_) {
/* 216 */     double d = Double.MAX_VALUE;
/* 217 */     VillageAgressor villageAgressor = null;
/* 218 */     for (byte b = 0; b < this.field_75589_i.size(); b++) {
/* 219 */       VillageAgressor villageAgressor1 = this.field_75589_i.get(b);
/* 220 */       double d1 = villageAgressor1.field_75592_a.func_70068_e((Entity)p_75571_1_);
/* 221 */       if (d1 <= d) {
/* 222 */         villageAgressor = villageAgressor1;
/* 223 */         d = d1;
/*     */       } 
/* 225 */     }  return (villageAgressor != null) ? villageAgressor.field_75592_a : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPlayer func_82685_c(EntityLivingBase p_82685_1_) {
/* 230 */     double d = Double.MAX_VALUE;
/* 231 */     EntityPlayer entityPlayer = null;
/*     */     
/* 233 */     for (String str : this.field_82693_j.keySet()) {
/* 234 */       if (func_82687_d(str)) {
/* 235 */         EntityPlayer entityPlayer1 = this.field_75586_a.func_72924_a(str);
/* 236 */         if (entityPlayer1 != null) {
/* 237 */           double d1 = entityPlayer1.func_70068_e((Entity)p_82685_1_);
/* 238 */           if (d1 > d)
/* 239 */             continue;  entityPlayer = entityPlayer1;
/* 240 */           d = d1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 245 */     return entityPlayer;
/*     */   }
/*     */   
/*     */   private void func_75565_j() {
/* 249 */     for (Iterator<VillageAgressor> iterator = this.field_75589_i.iterator(); iterator.hasNext(); ) {
/* 250 */       VillageAgressor villageAgressor = iterator.next();
/* 251 */       if (!villageAgressor.field_75592_a.func_70089_S() || Math.abs(this.field_75581_g - villageAgressor.field_75590_b) > 300) iterator.remove(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_75557_k() {
/* 256 */     boolean bool1 = false;
/* 257 */     boolean bool2 = (this.field_75586_a.field_73012_v.nextInt(50) == 0) ? true : false;
/* 258 */     for (Iterator<VillageDoorInfo> iterator = this.field_75584_b.iterator(); iterator.hasNext(); ) {
/* 259 */       VillageDoorInfo villageDoorInfo = iterator.next();
/* 260 */       if (bool2) villageDoorInfo.func_75466_d(); 
/* 261 */       if (!func_75574_f(villageDoorInfo.field_75481_a, villageDoorInfo.field_75479_b, villageDoorInfo.field_75480_c) || Math.abs(this.field_75581_g - villageDoorInfo.field_75475_f) > 1200) {
/* 262 */         this.field_75585_c.field_71574_a -= villageDoorInfo.field_75481_a;
/* 263 */         this.field_75585_c.field_71572_b -= villageDoorInfo.field_75479_b;
/* 264 */         this.field_75585_c.field_71573_c -= villageDoorInfo.field_75480_c;
/* 265 */         bool1 = true;
/* 266 */         villageDoorInfo.field_75476_g = true;
/* 267 */         iterator.remove();
/*     */       } 
/*     */     } 
/*     */     
/* 271 */     if (bool1) func_75573_l(); 
/*     */   }
/*     */   
/*     */   private boolean func_75574_f(int p_75574_1_, int p_75574_2_, int p_75574_3_) {
/* 275 */     return (this.field_75586_a.func_147439_a(p_75574_1_, p_75574_2_, p_75574_3_) == Blocks.field_150466_ao);
/*     */   }
/*     */   
/*     */   private void func_75573_l() {
/* 279 */     int i = this.field_75584_b.size();
/* 280 */     if (i == 0) {
/* 281 */       this.field_75582_d.func_71571_b(0, 0, 0);
/* 282 */       this.field_75583_e = 0;
/*     */       return;
/*     */     } 
/* 285 */     this.field_75582_d.func_71571_b(this.field_75585_c.field_71574_a / i, this.field_75585_c.field_71572_b / i, this.field_75585_c.field_71573_c / i);
/* 286 */     int j = 0;
/* 287 */     for (VillageDoorInfo villageDoorInfo : this.field_75584_b)
/* 288 */       j = Math.max(villageDoorInfo.func_75474_b(this.field_75582_d.field_71574_a, this.field_75582_d.field_71572_b, this.field_75582_d.field_71573_c), j); 
/* 289 */     this.field_75583_e = Math.max(32, (int)Math.sqrt(j) + 1);
/*     */   }
/*     */   
/*     */   public int func_82684_a(String p_82684_1_) {
/* 293 */     Integer integer = (Integer)this.field_82693_j.get(p_82684_1_);
/* 294 */     if (integer != null) {
/* 295 */       return integer.intValue();
/*     */     }
/* 297 */     return 0;
/*     */   }
/*     */   
/*     */   public int func_82688_a(String p_82688_1_, int p_82688_2_) {
/* 301 */     int i = func_82684_a(p_82688_1_);
/* 302 */     int j = MathHelper.func_76125_a(i + p_82688_2_, -30, 10);
/* 303 */     this.field_82693_j.put(p_82688_1_, Integer.valueOf(j));
/* 304 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_82687_d(String p_82687_1_) {
/* 316 */     return (func_82684_a(p_82687_1_) <= -15);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82690_a(NBTTagCompound p_82690_1_) {
/* 321 */     this.field_75588_h = p_82690_1_.func_74762_e("PopSize");
/* 322 */     this.field_75583_e = p_82690_1_.func_74762_e("Radius");
/* 323 */     this.field_75587_j = p_82690_1_.func_74762_e("Golems");
/* 324 */     this.field_75580_f = p_82690_1_.func_74762_e("Stable");
/* 325 */     this.field_75581_g = p_82690_1_.func_74762_e("Tick");
/* 326 */     this.field_82694_i = p_82690_1_.func_74762_e("MTick");
/* 327 */     this.field_75582_d.field_71574_a = p_82690_1_.func_74762_e("CX");
/* 328 */     this.field_75582_d.field_71572_b = p_82690_1_.func_74762_e("CY");
/* 329 */     this.field_75582_d.field_71573_c = p_82690_1_.func_74762_e("CZ");
/* 330 */     this.field_75585_c.field_71574_a = p_82690_1_.func_74762_e("ACX");
/* 331 */     this.field_75585_c.field_71572_b = p_82690_1_.func_74762_e("ACY");
/* 332 */     this.field_75585_c.field_71573_c = p_82690_1_.func_74762_e("ACZ");
/*     */     
/* 334 */     NBTTagList nBTTagList1 = p_82690_1_.func_150295_c("Doors", 10);
/* 335 */     for (byte b1 = 0; b1 < nBTTagList1.func_74745_c(); b1++) {
/* 336 */       NBTTagCompound nBTTagCompound = nBTTagList1.func_150305_b(b1);
/*     */       
/* 338 */       VillageDoorInfo villageDoorInfo = new VillageDoorInfo(nBTTagCompound.func_74762_e("X"), nBTTagCompound.func_74762_e("Y"), nBTTagCompound.func_74762_e("Z"), nBTTagCompound.func_74762_e("IDX"), nBTTagCompound.func_74762_e("IDZ"), nBTTagCompound.func_74762_e("TS"));
/* 339 */       this.field_75584_b.add(villageDoorInfo);
/*     */     } 
/*     */     
/* 342 */     NBTTagList nBTTagList2 = p_82690_1_.func_150295_c("Players", 10);
/* 343 */     for (byte b2 = 0; b2 < nBTTagList2.func_74745_c(); b2++) {
/* 344 */       NBTTagCompound nBTTagCompound = nBTTagList2.func_150305_b(b2);
/* 345 */       this.field_82693_j.put(nBTTagCompound.func_74779_i("Name"), Integer.valueOf(nBTTagCompound.func_74762_e("S")));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82689_b(NBTTagCompound p_82689_1_) {
/* 351 */     p_82689_1_.func_74768_a("PopSize", this.field_75588_h);
/* 352 */     p_82689_1_.func_74768_a("Radius", this.field_75583_e);
/* 353 */     p_82689_1_.func_74768_a("Golems", this.field_75587_j);
/* 354 */     p_82689_1_.func_74768_a("Stable", this.field_75580_f);
/* 355 */     p_82689_1_.func_74768_a("Tick", this.field_75581_g);
/* 356 */     p_82689_1_.func_74768_a("MTick", this.field_82694_i);
/* 357 */     p_82689_1_.func_74768_a("CX", this.field_75582_d.field_71574_a);
/* 358 */     p_82689_1_.func_74768_a("CY", this.field_75582_d.field_71572_b);
/* 359 */     p_82689_1_.func_74768_a("CZ", this.field_75582_d.field_71573_c);
/* 360 */     p_82689_1_.func_74768_a("ACX", this.field_75585_c.field_71574_a);
/* 361 */     p_82689_1_.func_74768_a("ACY", this.field_75585_c.field_71572_b);
/* 362 */     p_82689_1_.func_74768_a("ACZ", this.field_75585_c.field_71573_c);
/*     */     
/* 364 */     NBTTagList nBTTagList1 = new NBTTagList();
/* 365 */     for (VillageDoorInfo villageDoorInfo : this.field_75584_b) {
/* 366 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 367 */       nBTTagCompound.func_74768_a("X", villageDoorInfo.field_75481_a);
/* 368 */       nBTTagCompound.func_74768_a("Y", villageDoorInfo.field_75479_b);
/* 369 */       nBTTagCompound.func_74768_a("Z", villageDoorInfo.field_75480_c);
/* 370 */       nBTTagCompound.func_74768_a("IDX", villageDoorInfo.field_75477_d);
/* 371 */       nBTTagCompound.func_74768_a("IDZ", villageDoorInfo.field_75478_e);
/* 372 */       nBTTagCompound.func_74768_a("TS", villageDoorInfo.field_75475_f);
/* 373 */       nBTTagList1.func_74742_a((NBTBase)nBTTagCompound);
/*     */     } 
/* 375 */     p_82689_1_.func_74782_a("Doors", (NBTBase)nBTTagList1);
/*     */     
/* 377 */     NBTTagList nBTTagList2 = new NBTTagList();
/* 378 */     for (String str : this.field_82693_j.keySet()) {
/* 379 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 380 */       nBTTagCompound.func_74778_a("Name", str);
/* 381 */       nBTTagCompound.func_74768_a("S", ((Integer)this.field_82693_j.get(str)).intValue());
/* 382 */       nBTTagList2.func_74742_a((NBTBase)nBTTagCompound);
/*     */     } 
/* 384 */     p_82689_1_.func_74782_a("Players", (NBTBase)nBTTagList2);
/*     */   }
/*     */   
/*     */   public void func_82692_h() {
/* 388 */     this.field_82694_i = this.field_75581_g;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_82686_i() {
/* 394 */     return (this.field_82694_i == 0 || this.field_75581_g - this.field_82694_i >= 3600);
/*     */   }
/*     */   
/*     */   public void func_82683_b(int p_82683_1_) {
/* 398 */     for (String str : this.field_82693_j.keySet())
/* 399 */       func_82688_a(str, p_82683_1_); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\village\Village.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */