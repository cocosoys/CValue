/*     */ package net.minecraft.entity.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class EntityFireworkRocket
/*     */   extends Entity
/*     */ {
/*     */   private int field_92056_a;
/*     */   private int field_92055_b;
/*     */   private static final String __OBFID = "CL_00001718";
/*     */   
/*     */   public EntityFireworkRocket(World p_i1762_1_) {
/*  21 */     super(p_i1762_1_);
/*  22 */     func_70105_a(0.25F, 0.25F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  27 */     this.field_70180_af.func_82709_a(8, 5);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_70112_a(double p_70112_1_) {
/*  32 */     return (p_70112_1_ < 4096.0D);
/*     */   }
/*     */   
/*     */   public EntityFireworkRocket(World p_i1763_1_, double p_i1763_2_, double p_i1763_4_, double p_i1763_6_, ItemStack p_i1763_8_) {
/*  36 */     super(p_i1763_1_);
/*  37 */     this.field_92056_a = 0;
/*     */     
/*  39 */     func_70105_a(0.25F, 0.25F);
/*     */     
/*  41 */     func_70107_b(p_i1763_2_, p_i1763_4_, p_i1763_6_);
/*  42 */     this.field_70129_M = 0.0F;
/*     */     
/*  44 */     int i = 1;
/*  45 */     if (p_i1763_8_ != null && p_i1763_8_.func_77942_o()) {
/*  46 */       this.field_70180_af.func_75692_b(8, p_i1763_8_);
/*     */       
/*  48 */       NBTTagCompound nBTTagCompound1 = p_i1763_8_.func_77978_p();
/*  49 */       NBTTagCompound nBTTagCompound2 = nBTTagCompound1.func_74775_l("Fireworks");
/*  50 */       if (nBTTagCompound2 != null) {
/*  51 */         i += nBTTagCompound2.func_74771_c("Flight");
/*     */       }
/*     */     } 
/*  54 */     this.field_70159_w = this.field_70146_Z.nextGaussian() * 0.001D;
/*  55 */     this.field_70179_y = this.field_70146_Z.nextGaussian() * 0.001D;
/*  56 */     this.field_70181_x = 0.05D;
/*     */     
/*  58 */     this.field_92055_b = 10 * i + this.field_70146_Z.nextInt(6) + this.field_70146_Z.nextInt(7);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
/*  63 */     this.field_70159_w = p_70016_1_;
/*  64 */     this.field_70181_x = p_70016_3_;
/*  65 */     this.field_70179_y = p_70016_5_;
/*  66 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/*  67 */       float f = MathHelper.func_76133_a(p_70016_1_ * p_70016_1_ + p_70016_5_ * p_70016_5_);
/*  68 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(p_70016_1_, p_70016_5_) * 180.0D / 3.1415927410125732D);
/*  69 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(p_70016_3_, f) * 180.0D / 3.1415927410125732D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  75 */     this.field_70142_S = this.field_70165_t;
/*  76 */     this.field_70137_T = this.field_70163_u;
/*  77 */     this.field_70136_U = this.field_70161_v;
/*  78 */     super.func_70071_h_();
/*     */     
/*  80 */     this.field_70159_w *= 1.15D;
/*  81 */     this.field_70179_y *= 1.15D;
/*  82 */     this.field_70181_x += 0.04D;
/*  83 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */     
/*  85 */     float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*  86 */     this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.1415927410125732D);
/*  87 */     this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f) * 180.0D / 3.1415927410125732D);
/*     */     
/*  89 */     while (this.field_70125_A - this.field_70127_C < -180.0F)
/*  90 */       this.field_70127_C -= 360.0F; 
/*  91 */     while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/*  92 */       this.field_70127_C += 360.0F;
/*     */     }
/*  94 */     while (this.field_70177_z - this.field_70126_B < -180.0F)
/*  95 */       this.field_70126_B -= 360.0F; 
/*  96 */     while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/*  97 */       this.field_70126_B += 360.0F;
/*     */     }
/*  99 */     this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F;
/* 100 */     this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
/*     */     
/* 102 */     if (this.field_92056_a == 0) {
/* 103 */       this.field_70170_p.func_72956_a(this, "fireworks.launch", 3.0F, 1.0F);
/*     */     }
/*     */     
/* 106 */     this.field_92056_a++;
/* 107 */     if (this.field_70170_p.field_72995_K && this.field_92056_a % 2 < 2) {
/* 108 */       this.field_70170_p.func_72869_a("fireworksSpark", this.field_70165_t, this.field_70163_u - 0.3D, this.field_70161_v, this.field_70146_Z.nextGaussian() * 0.05D, -this.field_70181_x * 0.5D, this.field_70146_Z.nextGaussian() * 0.05D);
/*     */     }
/* 110 */     if (!this.field_70170_p.field_72995_K && this.field_92056_a > this.field_92055_b) {
/* 111 */       this.field_70170_p.func_72960_a(this, (byte)17);
/* 112 */       func_70106_y();
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70103_a(byte p_70103_1_) {
/* 118 */     if (p_70103_1_ == 17 && this.field_70170_p.field_72995_K) {
/* 119 */       ItemStack itemStack = this.field_70180_af.func_82710_f(8);
/* 120 */       NBTTagCompound nBTTagCompound = null;
/* 121 */       if (itemStack != null && itemStack.func_77942_o()) {
/* 122 */         nBTTagCompound = itemStack.func_77978_p().func_74775_l("Fireworks");
/*     */       }
/* 124 */       this.field_70170_p.func_92088_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70159_w, this.field_70181_x, this.field_70179_y, nBTTagCompound);
/*     */     } 
/* 126 */     super.func_70103_a(p_70103_1_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 132 */     p_70014_1_.func_74768_a("Life", this.field_92056_a);
/* 133 */     p_70014_1_.func_74768_a("LifeTime", this.field_92055_b);
/* 134 */     ItemStack itemStack = this.field_70180_af.func_82710_f(8);
/* 135 */     if (itemStack != null) {
/* 136 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 137 */       itemStack.func_77955_b(nBTTagCompound);
/* 138 */       p_70014_1_.func_74782_a("FireworksItem", (NBTBase)nBTTagCompound);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 145 */     this.field_92056_a = p_70037_1_.func_74762_e("Life");
/* 146 */     this.field_92055_b = p_70037_1_.func_74762_e("LifeTime");
/*     */     
/* 148 */     NBTTagCompound nBTTagCompound = p_70037_1_.func_74775_l("FireworksItem");
/* 149 */     if (nBTTagCompound != null) {
/* 150 */       ItemStack itemStack = ItemStack.func_77949_a(nBTTagCompound);
/* 151 */       if (itemStack != null) {
/* 152 */         this.field_70180_af.func_75692_b(8, itemStack);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 159 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_70013_c(float p_70013_1_) {
/* 164 */     return super.func_70013_c(p_70013_1_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_70070_b(float p_70070_1_) {
/* 169 */     return super.func_70070_b(p_70070_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70075_an() {
/* 174 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityFireworkRocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */