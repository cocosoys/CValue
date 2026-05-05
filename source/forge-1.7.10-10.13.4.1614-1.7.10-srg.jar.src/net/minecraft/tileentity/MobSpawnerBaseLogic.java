/*     */ package net.minecraft.tileentity;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.WeightedRandom;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class MobSpawnerBaseLogic {
/*  16 */   public int field_98286_b = 20;
/*  17 */   private String field_98288_a = "Pig"; private List field_98285_e;
/*     */   private WeightedRandomMinecart field_98282_f;
/*     */   public double field_98287_c;
/*     */   public double field_98284_d;
/*  21 */   private int field_98283_g = 200;
/*  22 */   private int field_98293_h = 800;
/*  23 */   private int field_98294_i = 4;
/*     */   private Entity field_98291_j;
/*  25 */   private int field_98292_k = 6;
/*  26 */   private int field_98289_l = 16;
/*  27 */   private int field_98290_m = 4; private static final String __OBFID = "CL_00000129";
/*     */   
/*     */   public String func_98276_e() {
/*  30 */     if (func_98269_i() == null) {
/*  31 */       if (this.field_98288_a.equals("Minecart")) {
/*  32 */         this.field_98288_a = "MinecartRideable";
/*     */       }
/*  34 */       return this.field_98288_a;
/*     */     } 
/*  36 */     return (func_98269_i()).field_98223_c;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_98272_a(String p_98272_1_) {
/*  41 */     this.field_98288_a = p_98272_1_;
/*     */   }
/*     */   
/*     */   public boolean func_98279_f() {
/*  45 */     return (func_98271_a().func_72977_a(func_98275_b() + 0.5D, func_98274_c() + 0.5D, func_98266_d() + 0.5D, this.field_98289_l) != null);
/*     */   }
/*     */   
/*     */   public void func_98278_g() {
/*  49 */     if (!func_98279_f()) {
/*     */       return;
/*     */     }
/*     */     
/*  53 */     if ((func_98271_a()).field_72995_K) {
/*  54 */       double d1 = (func_98275_b() + (func_98271_a()).field_73012_v.nextFloat());
/*  55 */       double d2 = (func_98274_c() + (func_98271_a()).field_73012_v.nextFloat());
/*  56 */       double d3 = (func_98266_d() + (func_98271_a()).field_73012_v.nextFloat());
/*  57 */       func_98271_a().func_72869_a("smoke", d1, d2, d3, 0.0D, 0.0D, 0.0D);
/*  58 */       func_98271_a().func_72869_a("flame", d1, d2, d3, 0.0D, 0.0D, 0.0D);
/*     */       
/*  60 */       if (this.field_98286_b > 0) this.field_98286_b--; 
/*  61 */       this.field_98284_d = this.field_98287_c;
/*  62 */       this.field_98287_c = (this.field_98287_c + (1000.0F / (this.field_98286_b + 200.0F))) % 360.0D;
/*     */     } else {
/*  64 */       if (this.field_98286_b == -1) func_98273_j();
/*     */       
/*  66 */       if (this.field_98286_b > 0) {
/*  67 */         this.field_98286_b--;
/*     */         
/*     */         return;
/*     */       } 
/*  71 */       boolean bool = false;
/*     */       
/*  73 */       for (byte b = 0; b < this.field_98294_i; b++) {
/*  74 */         Entity entity = EntityList.func_75620_a(func_98276_e(), func_98271_a());
/*  75 */         if (entity == null)
/*     */           return; 
/*  77 */         int i = func_98271_a().func_72872_a(entity.getClass(), AxisAlignedBB.func_72330_a(func_98275_b(), func_98274_c(), func_98266_d(), (func_98275_b() + 1), (func_98274_c() + 1), (func_98266_d() + 1)).func_72314_b((this.field_98290_m * 2), 4.0D, (this.field_98290_m * 2))).size();
/*     */         
/*  79 */         if (i >= this.field_98292_k) {
/*  80 */           func_98273_j();
/*     */           
/*     */           return;
/*     */         } 
/*  84 */         double d1 = func_98275_b() + ((func_98271_a()).field_73012_v.nextDouble() - (func_98271_a()).field_73012_v.nextDouble()) * this.field_98290_m;
/*  85 */         double d2 = (func_98274_c() + (func_98271_a()).field_73012_v.nextInt(3) - 1);
/*  86 */         double d3 = func_98266_d() + ((func_98271_a()).field_73012_v.nextDouble() - (func_98271_a()).field_73012_v.nextDouble()) * this.field_98290_m;
/*  87 */         EntityLiving entityLiving = (entity instanceof EntityLiving) ? (EntityLiving)entity : null;
/*     */         
/*  89 */         entity.func_70012_b(d1, d2, d3, (func_98271_a()).field_73012_v.nextFloat() * 360.0F, 0.0F);
/*     */         
/*  91 */         if (entityLiving == null || entityLiving.func_70601_bi()) {
/*  92 */           func_98265_a(entity);
/*  93 */           func_98271_a().func_72926_e(2004, func_98275_b(), func_98274_c(), func_98266_d(), 0);
/*     */           
/*  95 */           if (entityLiving != null) {
/*  96 */             entityLiving.func_70656_aK();
/*     */           }
/*     */           
/*  99 */           bool = true;
/*     */         } 
/*     */       } 
/*     */       
/* 103 */       if (bool) func_98273_j(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public Entity func_98265_a(Entity p_98265_1_) {
/* 108 */     if (func_98269_i() != null) {
/* 109 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 110 */       p_98265_1_.func_70039_c(nBTTagCompound);
/*     */       
/* 112 */       for (String str : (func_98269_i()).field_98222_b.func_150296_c()) {
/* 113 */         NBTBase nBTBase = (func_98269_i()).field_98222_b.func_74781_a(str);
/* 114 */         nBTTagCompound.func_74782_a(str, nBTBase.func_74737_b());
/*     */       } 
/*     */       
/* 117 */       p_98265_1_.func_70020_e(nBTTagCompound);
/* 118 */       if (p_98265_1_.field_70170_p != null) p_98265_1_.field_70170_p.func_72838_d(p_98265_1_);
/*     */ 
/*     */       
/* 121 */       Entity entity = p_98265_1_;
/* 122 */       while (nBTTagCompound.func_150297_b("Riding", 10)) {
/* 123 */         NBTTagCompound nBTTagCompound1 = nBTTagCompound.func_74775_l("Riding");
/* 124 */         Entity entity1 = EntityList.func_75620_a(nBTTagCompound1.func_74779_i("id"), p_98265_1_.field_70170_p);
/* 125 */         if (entity1 != null) {
/* 126 */           NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
/* 127 */           entity1.func_70039_c(nBTTagCompound2);
/*     */           
/* 129 */           for (String str : nBTTagCompound1.func_150296_c()) {
/* 130 */             NBTBase nBTBase = nBTTagCompound1.func_74781_a(str);
/* 131 */             nBTTagCompound2.func_74782_a(str, nBTBase.func_74737_b());
/*     */           } 
/* 133 */           entity1.func_70020_e(nBTTagCompound2);
/* 134 */           entity1.func_70012_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, entity.field_70177_z, entity.field_70125_A);
/*     */           
/* 136 */           if (p_98265_1_.field_70170_p != null) p_98265_1_.field_70170_p.func_72838_d(entity1); 
/* 137 */           entity.func_70078_a(entity1);
/*     */         } 
/* 139 */         entity = entity1;
/* 140 */         nBTTagCompound = nBTTagCompound1;
/*     */       }
/*     */     
/* 143 */     } else if (p_98265_1_ instanceof net.minecraft.entity.EntityLivingBase && p_98265_1_.field_70170_p != null) {
/* 144 */       ((EntityLiving)p_98265_1_).func_110161_a(null);
/* 145 */       func_98271_a().func_72838_d(p_98265_1_);
/*     */     } 
/*     */     
/* 148 */     return p_98265_1_;
/*     */   }
/*     */   
/*     */   private void func_98273_j() {
/* 152 */     if (this.field_98293_h <= this.field_98283_g) {
/* 153 */       this.field_98286_b = this.field_98283_g;
/*     */     } else {
/* 155 */       this.field_98286_b = this.field_98283_g + (func_98271_a()).field_73012_v.nextInt(this.field_98293_h - this.field_98283_g);
/*     */     } 
/*     */     
/* 158 */     if (this.field_98285_e != null && this.field_98285_e.size() > 0) {
/* 159 */       func_98277_a((WeightedRandomMinecart)WeightedRandom.func_76271_a((func_98271_a()).field_73012_v, this.field_98285_e));
/*     */     }
/*     */     
/* 162 */     func_98267_a(1);
/*     */   }
/*     */   
/*     */   public void func_98270_a(NBTTagCompound p_98270_1_) {
/* 166 */     this.field_98288_a = p_98270_1_.func_74779_i("EntityId");
/* 167 */     this.field_98286_b = p_98270_1_.func_74765_d("Delay");
/*     */     
/* 169 */     if (p_98270_1_.func_150297_b("SpawnPotentials", 9)) {
/* 170 */       this.field_98285_e = new ArrayList();
/* 171 */       NBTTagList nBTTagList = p_98270_1_.func_150295_c("SpawnPotentials", 10);
/*     */       
/* 173 */       for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 174 */         this.field_98285_e.add(new WeightedRandomMinecart(this, nBTTagList.func_150305_b(b)));
/*     */       }
/*     */     } else {
/* 177 */       this.field_98285_e = null;
/*     */     } 
/*     */     
/* 180 */     if (p_98270_1_.func_150297_b("SpawnData", 10)) {
/* 181 */       func_98277_a(new WeightedRandomMinecart(this, p_98270_1_.func_74775_l("SpawnData"), this.field_98288_a));
/*     */     } else {
/* 183 */       func_98277_a(null);
/*     */     } 
/*     */     
/* 186 */     if (p_98270_1_.func_150297_b("MinSpawnDelay", 99)) {
/* 187 */       this.field_98283_g = p_98270_1_.func_74765_d("MinSpawnDelay");
/* 188 */       this.field_98293_h = p_98270_1_.func_74765_d("MaxSpawnDelay");
/* 189 */       this.field_98294_i = p_98270_1_.func_74765_d("SpawnCount");
/*     */     } 
/*     */     
/* 192 */     if (p_98270_1_.func_150297_b("MaxNearbyEntities", 99)) {
/* 193 */       this.field_98292_k = p_98270_1_.func_74765_d("MaxNearbyEntities");
/* 194 */       this.field_98289_l = p_98270_1_.func_74765_d("RequiredPlayerRange");
/*     */     } 
/*     */     
/* 197 */     if (p_98270_1_.func_150297_b("SpawnRange", 99)) this.field_98290_m = p_98270_1_.func_74765_d("SpawnRange");
/*     */     
/* 199 */     if (func_98271_a() != null && (func_98271_a()).field_72995_K) {
/* 200 */       this.field_98291_j = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_98280_b(NBTTagCompound p_98280_1_) {
/* 205 */     p_98280_1_.func_74778_a("EntityId", func_98276_e());
/* 206 */     p_98280_1_.func_74777_a("Delay", (short)this.field_98286_b);
/* 207 */     p_98280_1_.func_74777_a("MinSpawnDelay", (short)this.field_98283_g);
/* 208 */     p_98280_1_.func_74777_a("MaxSpawnDelay", (short)this.field_98293_h);
/* 209 */     p_98280_1_.func_74777_a("SpawnCount", (short)this.field_98294_i);
/* 210 */     p_98280_1_.func_74777_a("MaxNearbyEntities", (short)this.field_98292_k);
/* 211 */     p_98280_1_.func_74777_a("RequiredPlayerRange", (short)this.field_98289_l);
/* 212 */     p_98280_1_.func_74777_a("SpawnRange", (short)this.field_98290_m);
/*     */     
/* 214 */     if (func_98269_i() != null) {
/* 215 */       p_98280_1_.func_74782_a("SpawnData", (func_98269_i()).field_98222_b.func_74737_b());
/*     */     }
/*     */     
/* 218 */     if (func_98269_i() != null || (this.field_98285_e != null && this.field_98285_e.size() > 0)) {
/* 219 */       NBTTagList nBTTagList = new NBTTagList();
/*     */       
/* 221 */       if (this.field_98285_e != null && this.field_98285_e.size() > 0) {
/* 222 */         for (WeightedRandomMinecart weightedRandomMinecart : this.field_98285_e) {
/* 223 */           nBTTagList.func_74742_a((NBTBase)weightedRandomMinecart.func_98220_a());
/*     */         }
/*     */       } else {
/* 226 */         nBTTagList.func_74742_a((NBTBase)func_98269_i().func_98220_a());
/*     */       } 
/*     */       
/* 229 */       p_98280_1_.func_74782_a("SpawnPotentials", (NBTBase)nBTTagList);
/*     */     } 
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Entity func_98281_h() {
/* 234 */     if (this.field_98291_j == null) {
/* 235 */       Entity entity = EntityList.func_75620_a(func_98276_e(), null);
/* 236 */       entity = func_98265_a(entity);
/* 237 */       this.field_98291_j = entity;
/*     */     } 
/*     */     
/* 240 */     return this.field_98291_j;
/*     */   }
/*     */   
/*     */   public boolean func_98268_b(int p_98268_1_) {
/* 244 */     if (p_98268_1_ == 1 && (func_98271_a()).field_72995_K) {
/* 245 */       this.field_98286_b = this.field_98283_g;
/* 246 */       return true;
/*     */     } 
/* 248 */     return false;
/*     */   }
/*     */   
/*     */   public WeightedRandomMinecart func_98269_i() {
/* 252 */     return this.field_98282_f;
/*     */   }
/*     */   
/*     */   public void func_98277_a(WeightedRandomMinecart p_98277_1_) {
/* 256 */     this.field_98282_f = p_98277_1_;
/*     */   }
/*     */   
/*     */   public abstract void func_98267_a(int paramInt);
/*     */   
/*     */   public abstract World func_98271_a();
/*     */   
/*     */   public abstract int func_98275_b();
/*     */   
/*     */   public abstract int func_98274_c();
/*     */   
/*     */   public abstract int func_98266_d();
/*     */   
/*     */   public class WeightedRandomMinecart extends WeightedRandom.Item { public final NBTTagCompound field_98222_b;
/*     */     public final String field_98223_c;
/*     */     private static final String __OBFID = "CL_00000130";
/*     */     
/*     */     public WeightedRandomMinecart(MobSpawnerBaseLogic p_i1945_1_, NBTTagCompound p_i1945_2_) {
/* 274 */       super(p_i1945_2_.func_74762_e("Weight"));
/*     */       
/* 276 */       NBTTagCompound nBTTagCompound = p_i1945_2_.func_74775_l("Properties");
/* 277 */       String str = p_i1945_2_.func_74779_i("Type");
/*     */       
/* 279 */       if (str.equals("Minecart")) {
/* 280 */         if (nBTTagCompound != null) {
/* 281 */           switch (nBTTagCompound.func_74762_e("Type")) {
/*     */             case 1:
/* 283 */               str = "MinecartChest";
/*     */               break;
/*     */             case 2:
/* 286 */               str = "MinecartFurnace";
/*     */               break;
/*     */             case 0:
/* 289 */               str = "MinecartRideable";
/*     */               break;
/*     */           } 
/*     */         } else {
/* 293 */           str = "MinecartRideable";
/*     */         } 
/*     */       }
/*     */       
/* 297 */       this.field_98222_b = nBTTagCompound;
/* 298 */       this.field_98223_c = str;
/*     */     }
/*     */     
/*     */     public WeightedRandomMinecart(MobSpawnerBaseLogic p_i1946_1_, NBTTagCompound p_i1946_2_, String p_i1946_3_) {
/* 302 */       super(1);
/*     */       
/* 304 */       if (p_i1946_3_.equals("Minecart")) {
/* 305 */         if (p_i1946_2_ != null) {
/* 306 */           switch (p_i1946_2_.func_74762_e("Type")) {
/*     */             case 1:
/* 308 */               p_i1946_3_ = "MinecartChest";
/*     */               break;
/*     */             case 2:
/* 311 */               p_i1946_3_ = "MinecartFurnace";
/*     */               break;
/*     */             case 0:
/* 314 */               p_i1946_3_ = "MinecartRideable";
/*     */               break;
/*     */           } 
/*     */         } else {
/* 318 */           p_i1946_3_ = "MinecartRideable";
/*     */         } 
/*     */       }
/*     */       
/* 322 */       this.field_98222_b = p_i1946_2_;
/* 323 */       this.field_98223_c = p_i1946_3_;
/*     */     }
/*     */     
/*     */     public NBTTagCompound func_98220_a() {
/* 327 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */       
/* 329 */       nBTTagCompound.func_74782_a("Properties", (NBTBase)this.field_98222_b);
/* 330 */       nBTTagCompound.func_74778_a("Type", this.field_98223_c);
/* 331 */       nBTTagCompound.func_74768_a("Weight", this.field_76292_a);
/*     */       
/* 333 */       return nBTTagCompound;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\MobSpawnerBaseLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */