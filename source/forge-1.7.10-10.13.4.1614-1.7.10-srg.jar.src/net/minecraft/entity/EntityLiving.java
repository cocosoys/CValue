/*     */ package net.minecraft.entity;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.ai.EntityJumpHelper;
/*     */ import net.minecraft.entity.ai.EntityLookHelper;
/*     */ import net.minecraft.entity.ai.EntityMoveHelper;
/*     */ import net.minecraft.entity.ai.EntitySenses;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityCreeper;
/*     */ import net.minecraft.entity.monster.EntityGhast;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemSword;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagFloat;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S1BPacketEntityAttach;
/*     */ import net.minecraft.pathfinding.PathNavigate;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ 
/*     */ public abstract class EntityLiving extends EntityLivingBase {
/*     */   public int field_70757_a;
/*     */   protected int field_70728_aV;
/*     */   private EntityLookHelper field_70749_g;
/*     */   private EntityMoveHelper field_70765_h;
/*     */   private EntityJumpHelper field_70767_i;
/*  45 */   private ItemStack[] field_82182_bS = new ItemStack[5]; private EntityBodyHelper field_70762_j; private PathNavigate field_70699_by; public final EntityAITasks field_70714_bg; public final EntityAITasks field_70715_bh; private EntityLivingBase field_70696_bz; private EntitySenses field_70723_bA;
/*  46 */   protected float[] field_82174_bp = new float[5]; private boolean field_82172_bs; private boolean field_82179_bU;
/*     */   protected float field_70698_bv;
/*     */   private Entity field_70776_bF;
/*     */   
/*     */   public EntityLiving(World p_i1595_1_) {
/*  51 */     super(p_i1595_1_);
/*     */     
/*  53 */     this.field_70714_bg = new EntityAITasks((p_i1595_1_ == null || p_i1595_1_.field_72984_F == null) ? null : p_i1595_1_.field_72984_F);
/*  54 */     this.field_70715_bh = new EntityAITasks((p_i1595_1_ == null || p_i1595_1_.field_72984_F == null) ? null : p_i1595_1_.field_72984_F);
/*  55 */     this.field_70749_g = new EntityLookHelper(this);
/*  56 */     this.field_70765_h = new EntityMoveHelper(this);
/*  57 */     this.field_70767_i = new EntityJumpHelper(this);
/*  58 */     this.field_70762_j = new EntityBodyHelper(this);
/*  59 */     this.field_70699_by = new PathNavigate(this, p_i1595_1_);
/*  60 */     this.field_70723_bA = new EntitySenses(this);
/*     */     
/*  62 */     for (byte b = 0; b < this.field_82174_bp.length; b++)
/*  63 */       this.field_82174_bp[b] = 0.085F; 
/*     */   }
/*     */   protected int field_70700_bx; private boolean field_110169_bv; private Entity field_110168_bw; private NBTTagCompound field_110170_bx;
/*     */   private static final String __OBFID = "CL_00001550";
/*     */   
/*     */   protected void func_110147_ax() {
/*  69 */     super.func_110147_ax();
/*     */     
/*  71 */     func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111265_b).func_111128_a(16.0D);
/*     */   }
/*     */   
/*     */   public EntityLookHelper func_70671_ap() {
/*  75 */     return this.field_70749_g;
/*     */   }
/*     */   
/*     */   public EntityMoveHelper func_70605_aq() {
/*  79 */     return this.field_70765_h;
/*     */   }
/*     */   
/*     */   public EntityJumpHelper func_70683_ar() {
/*  83 */     return this.field_70767_i;
/*     */   }
/*     */   
/*     */   public PathNavigate func_70661_as() {
/*  87 */     return this.field_70699_by;
/*     */   }
/*     */   
/*     */   public EntitySenses func_70635_at() {
/*  91 */     return this.field_70723_bA;
/*     */   }
/*     */   
/*     */   public EntityLivingBase func_70638_az() {
/*  95 */     return this.field_70696_bz;
/*     */   }
/*     */   
/*     */   public void func_70624_b(EntityLivingBase p_70624_1_) {
/*  99 */     this.field_70696_bz = p_70624_1_;
/*     */   }
/*     */   
/*     */   public boolean func_70686_a(Class<EntityCreeper> p_70686_1_) {
/* 103 */     return (EntityCreeper.class != p_70686_1_ && EntityGhast.class != p_70686_1_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70615_aA() {}
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 112 */     super.func_70088_a();
/* 113 */     this.field_70180_af.func_75682_a(11, Byte.valueOf((byte)0));
/* 114 */     this.field_70180_af.func_75682_a(10, "");
/*     */   }
/*     */   
/*     */   public int func_70627_aG() {
/* 118 */     return 80;
/*     */   }
/*     */   
/*     */   public void func_70642_aH() {
/* 122 */     String str = func_70639_aQ();
/* 123 */     if (str != null) {
/* 124 */       func_85030_a(str, func_70599_aP(), func_70647_i());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70030_z() {
/* 130 */     super.func_70030_z();
/*     */     
/* 132 */     this.field_70170_p.field_72984_F.func_76320_a("mobBaseTick");
/* 133 */     if (func_70089_S() && this.field_70146_Z.nextInt(1000) < this.field_70757_a++) {
/* 134 */       this.field_70757_a = -func_70627_aG();
/* 135 */       func_70642_aH();
/*     */     } 
/* 137 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_70693_a(EntityPlayer p_70693_1_) {
/* 142 */     if (this.field_70728_aV > 0) {
/* 143 */       int i = this.field_70728_aV;
/*     */       
/* 145 */       ItemStack[] arrayOfItemStack = func_70035_c();
/* 146 */       for (byte b = 0; b < arrayOfItemStack.length; b++) {
/* 147 */         if (arrayOfItemStack[b] != null && this.field_82174_bp[b] <= 1.0F) {
/* 148 */           i += 1 + this.field_70146_Z.nextInt(3);
/*     */         }
/*     */       } 
/*     */       
/* 152 */       return i;
/*     */     } 
/* 154 */     return this.field_70728_aV;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70656_aK() {
/* 159 */     for (byte b = 0; b < 20; b++) {
/* 160 */       double d1 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 161 */       double d2 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 162 */       double d3 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 163 */       double d4 = 10.0D;
/* 164 */       this.field_70170_p.func_72869_a("explode", this.field_70165_t + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N - d1 * d4, this.field_70163_u + (this.field_70146_Z.nextFloat() * this.field_70131_O) - d2 * d4, this.field_70161_v + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N - d3 * d4, d1, d2, d3);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 171 */     super.func_70071_h_();
/*     */     
/* 173 */     if (!this.field_70170_p.field_72995_K) {
/* 174 */       func_110159_bB();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_110146_f(float p_110146_1_, float p_110146_2_) {
/* 180 */     if (func_70650_aV()) {
/* 181 */       this.field_70762_j.func_75664_a();
/* 182 */       return p_110146_2_;
/*     */     } 
/* 184 */     return super.func_110146_f(p_110146_1_, p_110146_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/* 189 */     return null;
/*     */   }
/*     */   
/*     */   protected Item func_146068_u() {
/* 193 */     return Item.func_150899_d(0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/* 198 */     Item item = func_146068_u();
/* 199 */     if (item != null) {
/* 200 */       int i = this.field_70146_Z.nextInt(3);
/* 201 */       if (p_70628_2_ > 0) {
/* 202 */         i += this.field_70146_Z.nextInt(p_70628_2_ + 1);
/*     */       }
/* 204 */       for (byte b = 0; b < i; b++) {
/* 205 */         func_145779_a(item, 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 211 */     super.func_70014_b(p_70014_1_);
/* 212 */     p_70014_1_.func_74757_a("CanPickUpLoot", func_98052_bS());
/* 213 */     p_70014_1_.func_74757_a("PersistenceRequired", this.field_82179_bU);
/*     */     
/* 215 */     NBTTagList nBTTagList1 = new NBTTagList();
/* 216 */     for (byte b1 = 0; b1 < this.field_82182_bS.length; b1++) {
/* 217 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 218 */       if (this.field_82182_bS[b1] != null) this.field_82182_bS[b1].func_77955_b(nBTTagCompound); 
/* 219 */       nBTTagList1.func_74742_a((NBTBase)nBTTagCompound);
/*     */     } 
/* 221 */     p_70014_1_.func_74782_a("Equipment", (NBTBase)nBTTagList1);
/*     */     
/* 223 */     NBTTagList nBTTagList2 = new NBTTagList();
/* 224 */     for (byte b2 = 0; b2 < this.field_82174_bp.length; b2++) {
/* 225 */       nBTTagList2.func_74742_a((NBTBase)new NBTTagFloat(this.field_82174_bp[b2]));
/*     */     }
/* 227 */     p_70014_1_.func_74782_a("DropChances", (NBTBase)nBTTagList2);
/* 228 */     p_70014_1_.func_74778_a("CustomName", func_94057_bL());
/* 229 */     p_70014_1_.func_74757_a("CustomNameVisible", func_94062_bN());
/*     */ 
/*     */     
/* 232 */     p_70014_1_.func_74757_a("Leashed", this.field_110169_bv);
/* 233 */     if (this.field_110168_bw != null) {
/* 234 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 235 */       if (this.field_110168_bw instanceof EntityLivingBase) {
/*     */         
/* 237 */         nBTTagCompound.func_74772_a("UUIDMost", this.field_110168_bw.func_110124_au().getMostSignificantBits());
/* 238 */         nBTTagCompound.func_74772_a("UUIDLeast", this.field_110168_bw.func_110124_au().getLeastSignificantBits());
/* 239 */       } else if (this.field_110168_bw instanceof EntityHanging) {
/*     */         
/* 241 */         EntityHanging entityHanging = (EntityHanging)this.field_110168_bw;
/* 242 */         nBTTagCompound.func_74768_a("X", entityHanging.field_146063_b);
/* 243 */         nBTTagCompound.func_74768_a("Y", entityHanging.field_146064_c);
/* 244 */         nBTTagCompound.func_74768_a("Z", entityHanging.field_146062_d);
/*     */       } 
/* 246 */       p_70014_1_.func_74782_a("Leash", (NBTBase)nBTTagCompound);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 253 */     super.func_70037_a(p_70037_1_);
/*     */     
/* 255 */     func_98053_h(p_70037_1_.func_74767_n("CanPickUpLoot"));
/* 256 */     this.field_82179_bU = p_70037_1_.func_74767_n("PersistenceRequired");
/* 257 */     if (p_70037_1_.func_150297_b("CustomName", 8) && p_70037_1_.func_74779_i("CustomName").length() > 0) func_94058_c(p_70037_1_.func_74779_i("CustomName")); 
/* 258 */     func_94061_f(p_70037_1_.func_74767_n("CustomNameVisible"));
/*     */     
/* 260 */     if (p_70037_1_.func_150297_b("Equipment", 9)) {
/* 261 */       NBTTagList nBTTagList = p_70037_1_.func_150295_c("Equipment", 10);
/*     */       
/* 263 */       for (byte b = 0; b < this.field_82182_bS.length; b++) {
/* 264 */         this.field_82182_bS[b] = ItemStack.func_77949_a(nBTTagList.func_150305_b(b));
/*     */       }
/*     */     } 
/*     */     
/* 268 */     if (p_70037_1_.func_150297_b("DropChances", 9)) {
/* 269 */       NBTTagList nBTTagList = p_70037_1_.func_150295_c("DropChances", 5);
/* 270 */       for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 271 */         this.field_82174_bp[b] = nBTTagList.func_150308_e(b);
/*     */       }
/*     */     } 
/*     */     
/* 275 */     this.field_110169_bv = p_70037_1_.func_74767_n("Leashed");
/* 276 */     if (this.field_110169_bv && p_70037_1_.func_150297_b("Leash", 10)) {
/* 277 */       this.field_110170_bx = p_70037_1_.func_74775_l("Leash");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70657_f(float p_70657_1_) {
/* 284 */     this.field_70701_bs = p_70657_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70659_e(float p_70659_1_) {
/* 289 */     super.func_70659_e(p_70659_1_);
/* 290 */     func_70657_f(p_70659_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 295 */     super.func_70636_d();
/*     */     
/* 297 */     this.field_70170_p.field_72984_F.func_76320_a("looting");
/* 298 */     if (!this.field_70170_p.field_72995_K && func_98052_bS() && !this.field_70729_aU && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
/* 299 */       List list = this.field_70170_p.func_72872_a(EntityItem.class, this.field_70121_D.func_72314_b(1.0D, 0.0D, 1.0D));
/* 300 */       for (EntityItem entityItem : list) {
/* 301 */         if (entityItem.field_70128_L || entityItem.func_92059_d() == null)
/* 302 */           continue;  ItemStack itemStack = entityItem.func_92059_d();
/* 303 */         int i = func_82159_b(itemStack);
/*     */         
/* 305 */         if (i > -1) {
/* 306 */           boolean bool = true;
/* 307 */           ItemStack itemStack1 = func_71124_b(i);
/*     */           
/* 309 */           if (itemStack1 != null) {
/* 310 */             if (i == 0) {
/* 311 */               if (itemStack.func_77973_b() instanceof ItemSword && !(itemStack1.func_77973_b() instanceof ItemSword)) {
/* 312 */                 bool = true;
/* 313 */               } else if (itemStack.func_77973_b() instanceof ItemSword && itemStack1.func_77973_b() instanceof ItemSword) {
/* 314 */                 ItemSword itemSword1 = (ItemSword)itemStack.func_77973_b();
/* 315 */                 ItemSword itemSword2 = (ItemSword)itemStack1.func_77973_b();
/*     */                 
/* 317 */                 if (itemSword1.func_150931_i() == itemSword2.func_150931_i()) {
/* 318 */                   bool = (itemStack.func_77960_j() > itemStack1.func_77960_j() || (itemStack.func_77942_o() && !itemStack1.func_77942_o())) ? true : false;
/*     */                 } else {
/* 320 */                   bool = (itemSword1.func_150931_i() > itemSword2.func_150931_i()) ? true : false;
/*     */                 } 
/*     */               } else {
/* 323 */                 bool = false;
/*     */               }
/*     */             
/* 326 */             } else if (itemStack.func_77973_b() instanceof ItemArmor && !(itemStack1.func_77973_b() instanceof ItemArmor)) {
/* 327 */               bool = true;
/* 328 */             } else if (itemStack.func_77973_b() instanceof ItemArmor && itemStack1.func_77973_b() instanceof ItemArmor) {
/* 329 */               ItemArmor itemArmor1 = (ItemArmor)itemStack.func_77973_b();
/* 330 */               ItemArmor itemArmor2 = (ItemArmor)itemStack1.func_77973_b();
/*     */               
/* 332 */               if (itemArmor1.field_77879_b == itemArmor2.field_77879_b) {
/* 333 */                 bool = (itemStack.func_77960_j() > itemStack1.func_77960_j() || (itemStack.func_77942_o() && !itemStack1.func_77942_o())) ? true : false;
/*     */               } else {
/* 335 */                 bool = (itemArmor1.field_77879_b > itemArmor2.field_77879_b) ? true : false;
/*     */               } 
/*     */             } else {
/* 338 */               bool = false;
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/* 343 */           if (bool) {
/* 344 */             if (itemStack1 != null && this.field_70146_Z.nextFloat() - 0.1F < this.field_82174_bp[i]) {
/* 345 */               func_70099_a(itemStack1, 0.0F);
/*     */             }
/*     */             
/* 348 */             if (itemStack.func_77973_b() == Items.field_151045_i && entityItem.func_145800_j() != null) {
/* 349 */               EntityPlayer entityPlayer = this.field_70170_p.func_72924_a(entityItem.func_145800_j());
/* 350 */               if (entityPlayer != null) {
/* 351 */                 entityPlayer.func_71029_a((StatBase)AchievementList.field_150966_x);
/*     */               }
/*     */             } 
/*     */             
/* 355 */             func_70062_b(i, itemStack);
/* 356 */             this.field_82174_bp[i] = 2.0F;
/* 357 */             this.field_82179_bU = true;
/* 358 */             func_71001_a((Entity)entityItem, 1);
/* 359 */             entityItem.func_70106_y();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 364 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70650_aV() {
/* 369 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean func_70692_ba() {
/* 373 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70623_bb() {
/* 380 */     if (this.field_82179_bU) {
/* 381 */       this.field_70708_bq = 0;
/*     */       
/*     */       return;
/*     */     } 
/* 385 */     EntityPlayer entityPlayer = this.field_70170_p.func_72890_a(this, -1.0D);
/* 386 */     if (entityPlayer != null) {
/* 387 */       double d1 = ((Entity)entityPlayer).field_70165_t - this.field_70165_t;
/* 388 */       double d2 = ((Entity)entityPlayer).field_70163_u - this.field_70163_u;
/* 389 */       double d3 = ((Entity)entityPlayer).field_70161_v - this.field_70161_v;
/* 390 */       double d4 = d1 * d1 + d2 * d2 + d3 * d3;
/*     */       
/* 392 */       if (func_70692_ba() && d4 > 16384.0D) {
/* 393 */         func_70106_y();
/*     */       }
/*     */       
/* 396 */       if (this.field_70708_bq > 600 && this.field_70146_Z.nextInt(800) == 0 && d4 > 1024.0D && func_70692_ba()) {
/* 397 */         func_70106_y();
/* 398 */       } else if (d4 < 1024.0D) {
/* 399 */         this.field_70708_bq = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70619_bc() {
/* 406 */     this.field_70708_bq++;
/* 407 */     this.field_70170_p.field_72984_F.func_76320_a("checkDespawn");
/* 408 */     func_70623_bb();
/* 409 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */     
/* 411 */     this.field_70170_p.field_72984_F.func_76320_a("sensing");
/* 412 */     this.field_70723_bA.func_75523_a();
/* 413 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */     
/* 415 */     this.field_70170_p.field_72984_F.func_76320_a("targetSelector");
/* 416 */     this.field_70715_bh.func_75774_a();
/* 417 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */     
/* 419 */     this.field_70170_p.field_72984_F.func_76320_a("goalSelector");
/* 420 */     this.field_70714_bg.func_75774_a();
/* 421 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */     
/* 423 */     this.field_70170_p.field_72984_F.func_76320_a("navigation");
/* 424 */     this.field_70699_by.func_75501_e();
/* 425 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */     
/* 427 */     this.field_70170_p.field_72984_F.func_76320_a("mob tick");
/* 428 */     func_70629_bd();
/* 429 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */     
/* 431 */     this.field_70170_p.field_72984_F.func_76320_a("controls");
/* 432 */     this.field_70170_p.field_72984_F.func_76320_a("move");
/* 433 */     this.field_70765_h.func_75641_c();
/* 434 */     this.field_70170_p.field_72984_F.func_76318_c("look");
/* 435 */     this.field_70749_g.func_75649_a();
/* 436 */     this.field_70170_p.field_72984_F.func_76318_c("jump");
/* 437 */     this.field_70767_i.func_75661_b();
/* 438 */     this.field_70170_p.field_72984_F.func_76319_b();
/* 439 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70626_be() {
/* 444 */     super.func_70626_be();
/* 445 */     this.field_70702_br = 0.0F;
/* 446 */     this.field_70701_bs = 0.0F;
/* 447 */     func_70623_bb();
/*     */     
/* 449 */     float f = 8.0F;
/* 450 */     if (this.field_70146_Z.nextFloat() < 0.02F) {
/* 451 */       EntityPlayer entityPlayer = this.field_70170_p.func_72890_a(this, f);
/* 452 */       if (entityPlayer != null) {
/* 453 */         this.field_70776_bF = (Entity)entityPlayer;
/* 454 */         this.field_70700_bx = 10 + this.field_70146_Z.nextInt(20);
/*     */       } else {
/* 456 */         this.field_70704_bt = (this.field_70146_Z.nextFloat() - 0.5F) * 20.0F;
/*     */       } 
/*     */     } 
/*     */     
/* 460 */     if (this.field_70776_bF != null) {
/* 461 */       func_70625_a(this.field_70776_bF, 10.0F, func_70646_bf());
/* 462 */       if (this.field_70700_bx-- <= 0 || this.field_70776_bF.field_70128_L || this.field_70776_bF.func_70068_e(this) > (f * f)) {
/* 463 */         this.field_70776_bF = null;
/*     */       }
/*     */     } else {
/* 466 */       if (this.field_70146_Z.nextFloat() < 0.05F) {
/* 467 */         this.field_70704_bt = (this.field_70146_Z.nextFloat() - 0.5F) * 20.0F;
/*     */       }
/* 469 */       this.field_70177_z += this.field_70704_bt;
/* 470 */       this.field_70125_A = this.field_70698_bv;
/*     */     } 
/*     */     
/* 473 */     boolean bool1 = func_70090_H();
/* 474 */     boolean bool2 = func_70058_J();
/* 475 */     if (bool1 || bool2) this.field_70703_bu = (this.field_70146_Z.nextFloat() < 0.8F); 
/*     */   }
/*     */   
/*     */   public int func_70646_bf() {
/* 479 */     return 40;
/*     */   }
/*     */   
/*     */   public void func_70625_a(Entity p_70625_1_, float p_70625_2_, float p_70625_3_) {
/* 483 */     double d2, d1 = p_70625_1_.field_70165_t - this.field_70165_t;
/*     */     
/* 485 */     double d3 = p_70625_1_.field_70161_v - this.field_70161_v;
/*     */     
/* 487 */     if (p_70625_1_ instanceof EntityLivingBase) {
/* 488 */       EntityLivingBase entityLivingBase = (EntityLivingBase)p_70625_1_;
/* 489 */       d2 = entityLivingBase.field_70163_u + entityLivingBase.func_70047_e() - this.field_70163_u + func_70047_e();
/*     */     } else {
/* 491 */       d2 = (p_70625_1_.field_70121_D.field_72338_b + p_70625_1_.field_70121_D.field_72337_e) / 2.0D - this.field_70163_u + func_70047_e();
/*     */     } 
/*     */     
/* 494 */     double d4 = MathHelper.func_76133_a(d1 * d1 + d3 * d3);
/*     */     
/* 496 */     float f1 = (float)(Math.atan2(d3, d1) * 180.0D / 3.1415927410125732D) - 90.0F;
/* 497 */     float f2 = (float)-(Math.atan2(d2, d4) * 180.0D / 3.1415927410125732D);
/* 498 */     this.field_70125_A = func_70663_b(this.field_70125_A, f2, p_70625_3_);
/* 499 */     this.field_70177_z = func_70663_b(this.field_70177_z, f1, p_70625_2_);
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
/*     */   private float func_70663_b(float p_70663_1_, float p_70663_2_, float p_70663_3_) {
/* 511 */     float f = MathHelper.func_76142_g(p_70663_2_ - p_70663_1_);
/* 512 */     if (f > p_70663_3_) {
/* 513 */       f = p_70663_3_;
/*     */     }
/* 515 */     if (f < -p_70663_3_) {
/* 516 */       f = -p_70663_3_;
/*     */     }
/* 518 */     return p_70663_1_ + f;
/*     */   }
/*     */   
/*     */   public boolean func_70601_bi() {
/* 522 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70603_bj() {
/* 526 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70641_bl() {
/* 534 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_82143_as() {
/* 539 */     if (func_70638_az() == null) return 3; 
/* 540 */     int i = (int)(func_110143_aJ() - func_110138_aP() * 0.33F);
/* 541 */     i -= (3 - this.field_70170_p.field_73013_u.func_151525_a()) * 4;
/* 542 */     if (i < 0) i = 0; 
/* 543 */     return i + 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70694_bm() {
/* 548 */     return this.field_82182_bS[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_71124_b(int p_71124_1_) {
/* 553 */     return this.field_82182_bS[p_71124_1_];
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_130225_q(int p_130225_1_) {
/* 558 */     return this.field_82182_bS[p_130225_1_ + 1];
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_) {
/* 563 */     this.field_82182_bS[p_70062_1_] = p_70062_2_;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack[] func_70035_c() {
/* 568 */     return this.field_82182_bS;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_82160_b(boolean p_82160_1_, int p_82160_2_) {
/* 573 */     for (byte b = 0; b < (func_70035_c()).length; b++) {
/* 574 */       ItemStack itemStack = func_71124_b(b);
/* 575 */       boolean bool = (this.field_82174_bp[b] > 1.0F) ? true : false;
/*     */       
/* 577 */       if (itemStack != null && (p_82160_1_ || bool) && this.field_70146_Z.nextFloat() - p_82160_2_ * 0.01F < this.field_82174_bp[b]) {
/* 578 */         if (!bool && itemStack.func_77984_f()) {
/* 579 */           int i = Math.max(itemStack.func_77958_k() - 25, 1);
/* 580 */           int j = itemStack.func_77958_k() - this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(i) + 1);
/* 581 */           if (j > i) j = i; 
/* 582 */           if (j < 1) j = 1; 
/* 583 */           itemStack.func_77964_b(j);
/*     */         } 
/* 585 */         func_70099_a(itemStack, 0.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_82164_bB() {
/* 591 */     if (this.field_70146_Z.nextFloat() < 0.15F * this.field_70170_p.func_147462_b(this.field_70165_t, this.field_70163_u, this.field_70161_v)) {
/* 592 */       int i = this.field_70146_Z.nextInt(2);
/* 593 */       float f = (this.field_70170_p.field_73013_u == EnumDifficulty.HARD) ? 0.1F : 0.25F;
/* 594 */       if (this.field_70146_Z.nextFloat() < 0.095F) i++; 
/* 595 */       if (this.field_70146_Z.nextFloat() < 0.095F) i++; 
/* 596 */       if (this.field_70146_Z.nextFloat() < 0.095F) i++;
/*     */       
/* 598 */       for (byte b = 3; b >= 0; b--) {
/* 599 */         ItemStack itemStack = func_130225_q(b);
/* 600 */         if (b < 3 && this.field_70146_Z.nextFloat() < f)
/* 601 */           break;  if (itemStack == null) {
/* 602 */           Item item = func_82161_a(b + 1, i);
/* 603 */           if (item != null) func_70062_b(b + 1, new ItemStack(item)); 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int func_82159_b(ItemStack p_82159_0_) {
/* 610 */     if (p_82159_0_.func_77973_b() == Item.func_150898_a(Blocks.field_150423_aK) || p_82159_0_.func_77973_b() == Items.field_151144_bL) {
/* 611 */       return 4;
/*     */     }
/*     */     
/* 614 */     if (p_82159_0_.func_77973_b() instanceof ItemArmor) {
/* 615 */       switch (((ItemArmor)p_82159_0_.func_77973_b()).field_77881_a) {
/*     */         case 3:
/* 617 */           return 1;
/*     */         case 2:
/* 619 */           return 2;
/*     */         case 1:
/* 621 */           return 3;
/*     */         case 0:
/* 623 */           return 4;
/*     */       } 
/*     */     
/*     */     }
/* 627 */     return 0;
/*     */   }
/*     */   
/*     */   public static Item func_82161_a(int p_82161_0_, int p_82161_1_) {
/* 631 */     switch (p_82161_0_) {
/*     */       case 4:
/* 633 */         if (p_82161_1_ == 0) return (Item)Items.field_151024_Q; 
/* 634 */         if (p_82161_1_ == 1) return (Item)Items.field_151169_ag; 
/* 635 */         if (p_82161_1_ == 2) return (Item)Items.field_151020_U; 
/* 636 */         if (p_82161_1_ == 3) return (Item)Items.field_151028_Y; 
/* 637 */         if (p_82161_1_ == 4) return (Item)Items.field_151161_ac; 
/*     */       case 3:
/* 639 */         if (p_82161_1_ == 0) return (Item)Items.field_151027_R; 
/* 640 */         if (p_82161_1_ == 1) return (Item)Items.field_151171_ah; 
/* 641 */         if (p_82161_1_ == 2) return (Item)Items.field_151023_V; 
/* 642 */         if (p_82161_1_ == 3) return (Item)Items.field_151030_Z; 
/* 643 */         if (p_82161_1_ == 4) return (Item)Items.field_151163_ad; 
/*     */       case 2:
/* 645 */         if (p_82161_1_ == 0) return (Item)Items.field_151026_S; 
/* 646 */         if (p_82161_1_ == 1) return (Item)Items.field_151149_ai; 
/* 647 */         if (p_82161_1_ == 2) return (Item)Items.field_151022_W; 
/* 648 */         if (p_82161_1_ == 3) return (Item)Items.field_151165_aa; 
/* 649 */         if (p_82161_1_ == 4) return (Item)Items.field_151173_ae; 
/*     */       case 1:
/* 651 */         if (p_82161_1_ == 0) return (Item)Items.field_151021_T; 
/* 652 */         if (p_82161_1_ == 1) return (Item)Items.field_151151_aj; 
/* 653 */         if (p_82161_1_ == 2) return (Item)Items.field_151029_X; 
/* 654 */         if (p_82161_1_ == 3) return (Item)Items.field_151167_ab; 
/* 655 */         if (p_82161_1_ == 4) return (Item)Items.field_151175_af; 
/*     */         break;
/*     */     } 
/* 658 */     return null;
/*     */   }
/*     */   
/*     */   protected void func_82162_bC() {
/* 662 */     float f = this.field_70170_p.func_147462_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */     
/* 664 */     if (func_70694_bm() != null && this.field_70146_Z.nextFloat() < 0.25F * f) {
/* 665 */       EnchantmentHelper.func_77504_a(this.field_70146_Z, func_70694_bm(), (int)(5.0F + f * this.field_70146_Z.nextInt(18)));
/*     */     }
/*     */     
/* 668 */     for (byte b = 0; b < 4; b++) {
/* 669 */       ItemStack itemStack = func_130225_q(b);
/* 670 */       if (itemStack != null && this.field_70146_Z.nextFloat() < 0.5F * f) {
/* 671 */         EnchantmentHelper.func_77504_a(this.field_70146_Z, itemStack, (int)(5.0F + f * this.field_70146_Z.nextInt(18)));
/*     */       }
/*     */     } 
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
/*     */   public IEntityLivingData func_110161_a(IEntityLivingData p_110161_1_) {
/* 685 */     func_110148_a(SharedMonsterAttributes.field_111265_b).func_111121_a(new AttributeModifier("Random spawn bonus", this.field_70146_Z.nextGaussian() * 0.05D, 1));
/*     */     
/* 687 */     return p_110161_1_;
/*     */   }
/*     */   
/*     */   public boolean func_82171_bF() {
/* 691 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_70005_c_() {
/* 698 */     if (func_94056_bM()) return func_94057_bL(); 
/* 699 */     return super.func_70005_c_();
/*     */   }
/*     */   
/*     */   public void func_110163_bv() {
/* 703 */     this.field_82179_bU = true;
/*     */   }
/*     */   
/*     */   public void func_94058_c(String p_94058_1_) {
/* 707 */     this.field_70180_af.func_75692_b(10, p_94058_1_);
/*     */   }
/*     */   
/*     */   public String func_94057_bL() {
/* 711 */     return this.field_70180_af.func_75681_e(10);
/*     */   }
/*     */   
/*     */   public boolean func_94056_bM() {
/* 715 */     return (this.field_70180_af.func_75681_e(10).length() > 0);
/*     */   }
/*     */   
/*     */   public void func_94061_f(boolean p_94061_1_) {
/* 719 */     this.field_70180_af.func_75692_b(11, Byte.valueOf(p_94061_1_ ? 1 : 0));
/*     */   }
/*     */   
/*     */   public boolean func_94062_bN() {
/* 723 */     return (this.field_70180_af.func_75683_a(11) == 1);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_94059_bO() {
/* 728 */     return func_94062_bN();
/*     */   }
/*     */   
/*     */   public void func_96120_a(int p_96120_1_, float p_96120_2_) {
/* 732 */     this.field_82174_bp[p_96120_1_] = p_96120_2_;
/*     */   }
/*     */   
/*     */   public boolean func_98052_bS() {
/* 736 */     return this.field_82172_bs;
/*     */   }
/*     */   
/*     */   public void func_98053_h(boolean p_98053_1_) {
/* 740 */     this.field_82172_bs = p_98053_1_;
/*     */   }
/*     */   
/*     */   public boolean func_104002_bU() {
/* 744 */     return this.field_82179_bU;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean func_130002_c(EntityPlayer p_130002_1_) {
/* 750 */     if (func_110167_bD() && func_110166_bE() == p_130002_1_) {
/* 751 */       func_110160_i(true, !p_130002_1_.field_71075_bZ.field_75098_d);
/* 752 */       return true;
/*     */     } 
/*     */     
/* 755 */     ItemStack itemStack = p_130002_1_.field_71071_by.func_70448_g();
/* 756 */     if (itemStack != null)
/*     */     {
/*     */ 
/*     */       
/* 760 */       if (itemStack.func_77973_b() == Items.field_151058_ca && 
/* 761 */         func_110164_bC()) {
/* 762 */         if (this instanceof EntityTameable && ((EntityTameable)this).func_70909_n()) {
/* 763 */           if (((EntityTameable)this).func_152114_e((EntityLivingBase)p_130002_1_)) {
/* 764 */             func_110162_b((Entity)p_130002_1_, true);
/* 765 */             itemStack.field_77994_a--;
/* 766 */             return true;
/*     */           } 
/*     */         } else {
/* 769 */           func_110162_b((Entity)p_130002_1_, true);
/* 770 */           itemStack.field_77994_a--;
/* 771 */           return true;
/*     */         } 
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 777 */     if (func_70085_c(p_130002_1_)) {
/* 778 */       return true;
/*     */     }
/*     */     
/* 781 */     return super.func_130002_c(p_130002_1_);
/*     */   }
/*     */   
/*     */   protected boolean func_70085_c(EntityPlayer p_70085_1_) {
/* 785 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110159_bB() {
/* 795 */     if (this.field_110170_bx != null) {
/* 796 */       func_110165_bF();
/*     */     }
/* 798 */     if (!this.field_110169_bv) {
/*     */       return;
/*     */     }
/*     */     
/* 802 */     if (this.field_110168_bw == null || this.field_110168_bw.field_70128_L) {
/* 803 */       func_110160_i(true, true);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_110160_i(boolean p_110160_1_, boolean p_110160_2_) {
/* 809 */     if (this.field_110169_bv) {
/* 810 */       this.field_110169_bv = false;
/* 811 */       this.field_110168_bw = null;
/* 812 */       if (!this.field_70170_p.field_72995_K && p_110160_2_) {
/* 813 */         func_145779_a(Items.field_151058_ca, 1);
/*     */       }
/*     */       
/* 816 */       if (!this.field_70170_p.field_72995_K && p_110160_1_ && this.field_70170_p instanceof WorldServer) {
/* 817 */         ((WorldServer)this.field_70170_p).func_73039_n().func_151247_a(this, (Packet)new S1BPacketEntityAttach(1, this, null));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_110164_bC() {
/* 823 */     return (!func_110167_bD() && !(this instanceof net.minecraft.entity.monster.IMob));
/*     */   }
/*     */   
/*     */   public boolean func_110167_bD() {
/* 827 */     return this.field_110169_bv;
/*     */   }
/*     */   
/*     */   public Entity func_110166_bE() {
/* 831 */     return this.field_110168_bw;
/*     */   }
/*     */   
/*     */   public void func_110162_b(Entity p_110162_1_, boolean p_110162_2_) {
/* 835 */     this.field_110169_bv = true;
/* 836 */     this.field_110168_bw = p_110162_1_;
/*     */     
/* 838 */     if (!this.field_70170_p.field_72995_K && p_110162_2_ && this.field_70170_p instanceof WorldServer) {
/* 839 */       ((WorldServer)this.field_70170_p).func_73039_n().func_151247_a(this, (Packet)new S1BPacketEntityAttach(1, this, this.field_110168_bw));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_110165_bF() {
/* 845 */     if (this.field_110169_bv && this.field_110170_bx != null) {
/* 846 */       if (this.field_110170_bx.func_150297_b("UUIDMost", 4) && this.field_110170_bx.func_150297_b("UUIDLeast", 4)) {
/* 847 */         UUID uUID = new UUID(this.field_110170_bx.func_74763_f("UUIDMost"), this.field_110170_bx.func_74763_f("UUIDLeast"));
/* 848 */         List list = this.field_70170_p.func_72872_a(EntityLivingBase.class, this.field_70121_D.func_72314_b(10.0D, 10.0D, 10.0D));
/* 849 */         for (EntityLivingBase entityLivingBase : list) {
/* 850 */           if (entityLivingBase.func_110124_au().equals(uUID)) {
/* 851 */             this.field_110168_bw = entityLivingBase;
/*     */             break;
/*     */           } 
/*     */         } 
/* 855 */       } else if (this.field_110170_bx.func_150297_b("X", 99) && this.field_110170_bx.func_150297_b("Y", 99) && this.field_110170_bx.func_150297_b("Z", 99)) {
/* 856 */         int i = this.field_110170_bx.func_74762_e("X");
/* 857 */         int j = this.field_110170_bx.func_74762_e("Y");
/* 858 */         int k = this.field_110170_bx.func_74762_e("Z");
/*     */         
/* 860 */         EntityLeashKnot entityLeashKnot = EntityLeashKnot.func_110130_b(this.field_70170_p, i, j, k);
/* 861 */         if (entityLeashKnot == null) {
/* 862 */           entityLeashKnot = EntityLeashKnot.func_110129_a(this.field_70170_p, i, j, k);
/*     */         }
/* 864 */         this.field_110168_bw = entityLeashKnot;
/*     */       } else {
/*     */         
/* 867 */         func_110160_i(false, true);
/*     */       } 
/*     */     }
/* 870 */     this.field_110170_bx = null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\EntityLiving.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */