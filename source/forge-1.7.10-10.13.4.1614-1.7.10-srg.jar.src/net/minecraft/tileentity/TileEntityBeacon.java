/*     */ package net.minecraft.tileentity;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ 
/*     */ public class TileEntityBeacon
/*     */   extends TileEntity
/*     */   implements IInventory {
/*  24 */   public static final Potion[][] field_146009_a = new Potion[][] { { Potion.field_76424_c, Potion.field_76422_e }, { Potion.field_76429_m, Potion.field_76430_j }, { Potion.field_76420_g }, { Potion.field_76428_l } };
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private long field_146016_i;
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private float field_146014_j;
/*     */ 
/*     */   
/*     */   private boolean field_146015_k;
/*     */ 
/*     */   
/*  40 */   private int field_146012_l = -1;
/*     */   
/*     */   private int field_146013_m;
/*     */   
/*     */   private int field_146010_n;
/*     */   private ItemStack field_146011_o;
/*     */   private String field_146008_p;
/*     */   private static final String __OBFID = "CL_00000339";
/*     */   
/*     */   public void func_145845_h() {
/*  50 */     if (this.field_145850_b.func_82737_E() % 80L == 0L) {
/*  51 */       func_146003_y();
/*  52 */       func_146000_x();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_146000_x() {
/*  57 */     if (this.field_146015_k && this.field_146012_l > 0 && !this.field_145850_b.field_72995_K && this.field_146013_m > 0) {
/*     */       
/*  59 */       double d = (this.field_146012_l * 10 + 10);
/*  60 */       boolean bool = false;
/*  61 */       if (this.field_146012_l >= 4 && this.field_146013_m == this.field_146010_n) {
/*  62 */         bool = true;
/*     */       }
/*     */       
/*  65 */       AxisAlignedBB axisAlignedBB = AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + 1), (this.field_145849_e + 1)).func_72314_b(d, d, d);
/*  66 */       axisAlignedBB.field_72337_e = this.field_145850_b.func_72800_K();
/*  67 */       List list = this.field_145850_b.func_72872_a(EntityPlayer.class, axisAlignedBB);
/*  68 */       for (EntityPlayer entityPlayer : list) {
/*  69 */         entityPlayer.func_70690_d(new PotionEffect(this.field_146013_m, 180, bool, true));
/*     */       }
/*     */       
/*  72 */       if (this.field_146012_l >= 4 && this.field_146013_m != this.field_146010_n && this.field_146010_n > 0) {
/*  73 */         for (EntityPlayer entityPlayer : list) {
/*  74 */           entityPlayer.func_70690_d(new PotionEffect(this.field_146010_n, 180, 0, true));
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_146003_y() {
/*  81 */     int i = this.field_146012_l;
/*     */     
/*  83 */     if (!this.field_145850_b.func_72937_j(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e)) {
/*  84 */       this.field_146015_k = false;
/*  85 */       this.field_146012_l = 0;
/*     */     } else {
/*  87 */       this.field_146015_k = true;
/*  88 */       this.field_146012_l = 0;
/*     */       
/*  90 */       for (byte b = 1; b <= 4; ) {
/*  91 */         int j = this.field_145848_d - b;
/*  92 */         if (j < 0) {
/*     */           break;
/*     */         }
/*     */         
/*  96 */         boolean bool = true;
/*  97 */         for (int k = this.field_145851_c - b; k <= this.field_145851_c + b && bool; k++) {
/*  98 */           for (int m = this.field_145849_e - b; m <= this.field_145849_e + b; m++) {
/*  99 */             Block block = this.field_145850_b.func_147439_a(k, j, m);
/* 100 */             if (block != Blocks.field_150475_bE && block != Blocks.field_150340_R && block != Blocks.field_150484_ah && block != Blocks.field_150339_S) {
/* 101 */               bool = false;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/* 107 */         if (bool) {
/* 108 */           this.field_146012_l = b;
/*     */           
/*     */           b++;
/*     */         } 
/*     */       } 
/*     */       
/* 114 */       if (this.field_146012_l == 0) {
/* 115 */         this.field_146015_k = false;
/*     */       }
/*     */     } 
/*     */     
/* 119 */     if (!this.field_145850_b.field_72995_K && this.field_146012_l == 4 && i < this.field_146012_l) {
/* 120 */       for (EntityPlayer entityPlayer : this.field_145850_b.func_72872_a(EntityPlayer.class, AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, this.field_145851_c, (this.field_145848_d - 4), this.field_145849_e).func_72314_b(10.0D, 5.0D, 10.0D))) {
/* 121 */         entityPlayer.func_71029_a((StatBase)AchievementList.field_150965_K);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_146002_i() {
/* 129 */     if (!this.field_146015_k) {
/* 130 */       return 0.0F;
/*     */     }
/*     */     
/* 133 */     int i = (int)(this.field_145850_b.func_82737_E() - this.field_146016_i);
/* 134 */     this.field_146016_i = this.field_145850_b.func_82737_E();
/* 135 */     if (i > 1) {
/* 136 */       this.field_146014_j -= i / 40.0F;
/*     */       
/* 138 */       if (this.field_146014_j < 0.0F) {
/* 139 */         this.field_146014_j = 0.0F;
/*     */       }
/*     */     } 
/* 142 */     this.field_146014_j += 0.025F;
/* 143 */     if (this.field_146014_j > 1.0F) {
/* 144 */       this.field_146014_j = 1.0F;
/*     */     }
/* 146 */     return this.field_146014_j;
/*     */   }
/*     */   
/*     */   public int func_146007_j() {
/* 150 */     return this.field_146013_m;
/*     */   }
/*     */   
/*     */   public int func_146006_k() {
/* 154 */     return this.field_146010_n;
/*     */   }
/*     */   
/*     */   public int func_145998_l() {
/* 158 */     return this.field_146012_l;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_146005_c(int p_146005_1_) {
/* 163 */     this.field_146012_l = p_146005_1_;
/*     */   }
/*     */   
/*     */   public void func_146001_d(int p_146001_1_) {
/* 167 */     this.field_146013_m = 0;
/*     */ 
/*     */     
/* 170 */     for (byte b = 0; b < this.field_146012_l && b < 3; b++) {
/* 171 */       for (Potion potion : field_146009_a[b]) {
/* 172 */         if (potion.field_76415_H == p_146001_1_) {
/* 173 */           this.field_146013_m = p_146001_1_;
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_146004_e(int p_146004_1_) {
/* 181 */     this.field_146010_n = 0;
/*     */ 
/*     */     
/* 184 */     if (this.field_146012_l >= 4) {
/* 185 */       for (byte b = 0; b < 4; b++) {
/* 186 */         for (Potion potion : field_146009_a[b]) {
/* 187 */           if (potion.field_76415_H == p_146004_1_) {
/* 188 */             this.field_146010_n = p_146004_1_;
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Packet func_145844_m() {
/* 198 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 199 */     func_145841_b(nBTTagCompound);
/* 200 */     return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 3, nBTTagCompound);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public double func_145833_n() {
/* 205 */     return 65536.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/* 210 */     super.func_145839_a(p_145839_1_);
/*     */     
/* 212 */     this.field_146013_m = p_145839_1_.func_74762_e("Primary");
/* 213 */     this.field_146010_n = p_145839_1_.func_74762_e("Secondary");
/* 214 */     this.field_146012_l = p_145839_1_.func_74762_e("Levels");
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/* 219 */     super.func_145841_b(p_145841_1_);
/*     */     
/* 221 */     p_145841_1_.func_74768_a("Primary", this.field_146013_m);
/* 222 */     p_145841_1_.func_74768_a("Secondary", this.field_146010_n);
/*     */     
/* 224 */     p_145841_1_.func_74768_a("Levels", this.field_146012_l);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 229 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int p_70301_1_) {
/* 234 */     if (p_70301_1_ == 0) {
/* 235 */       return this.field_146011_o;
/*     */     }
/* 237 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
/* 242 */     if (p_70298_1_ == 0 && this.field_146011_o != null) {
/* 243 */       if (p_70298_2_ >= this.field_146011_o.field_77994_a) {
/* 244 */         ItemStack itemStack = this.field_146011_o;
/* 245 */         this.field_146011_o = null;
/* 246 */         return itemStack;
/*     */       } 
/* 248 */       this.field_146011_o.field_77994_a -= p_70298_2_;
/* 249 */       return new ItemStack(this.field_146011_o.func_77973_b(), p_70298_2_, this.field_146011_o.func_77960_j());
/*     */     } 
/*     */     
/* 252 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int p_70304_1_) {
/* 257 */     if (p_70304_1_ == 0 && this.field_146011_o != null) {
/* 258 */       ItemStack itemStack = this.field_146011_o;
/* 259 */       this.field_146011_o = null;
/* 260 */       return itemStack;
/*     */     } 
/* 262 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
/* 267 */     if (p_70299_1_ == 0) {
/* 268 */       this.field_146011_o = p_70299_2_;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 274 */     return func_145818_k_() ? this.field_146008_p : "container.beacon";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 279 */     return (this.field_146008_p != null && this.field_146008_p.length() > 0);
/*     */   }
/*     */   
/*     */   public void func_145999_a(String p_145999_1_) {
/* 283 */     this.field_146008_p = p_145999_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 288 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer p_70300_1_) {
/* 293 */     if (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this) return false; 
/* 294 */     if (p_70300_1_.func_70092_e(this.field_145851_c + 0.5D, this.field_145848_d + 0.5D, this.field_145849_e + 0.5D) > 64.0D) return false; 
/* 295 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
/* 308 */     return (p_94041_2_.func_77973_b() == Items.field_151166_bC || p_94041_2_.func_77973_b() == Items.field_151045_i || p_94041_2_.func_77973_b() == Items.field_151043_k || p_94041_2_.func_77973_b() == Items.field_151042_j);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntityBeacon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */