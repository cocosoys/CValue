/*     */ package net.minecraft.entity.passive;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class EntityAnimal extends EntityAgeable implements IAnimals {
/*     */   private int field_70881_d;
/*     */   private int field_70882_e;
/*     */   
/*     */   public EntityAnimal(World p_i1681_1_) {
/*  26 */     super(p_i1681_1_);
/*     */   }
/*     */   private EntityPlayer field_146084_br; private static final String __OBFID = "CL_00001638";
/*     */   
/*     */   protected void func_70629_bd() {
/*  31 */     if (func_70874_b() != 0) this.field_70881_d = 0; 
/*  32 */     super.func_70629_bd();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  37 */     super.func_70636_d();
/*     */     
/*  39 */     if (func_70874_b() != 0) this.field_70881_d = 0;
/*     */     
/*  41 */     if (this.field_70881_d > 0) {
/*  42 */       this.field_70881_d--;
/*  43 */       String str = "heart";
/*  44 */       if (this.field_70881_d % 10 == 0) {
/*  45 */         double d1 = this.field_70146_Z.nextGaussian() * 0.02D;
/*  46 */         double d2 = this.field_70146_Z.nextGaussian() * 0.02D;
/*  47 */         double d3 = this.field_70146_Z.nextGaussian() * 0.02D;
/*  48 */         this.field_70170_p.func_72869_a(str, this.field_70165_t + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, this.field_70163_u + 0.5D + (this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, d1, d2, d3);
/*     */       } 
/*     */     } else {
/*  51 */       this.field_70882_e = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70785_a(Entity p_70785_1_, float p_70785_2_) {
/*  57 */     if (p_70785_1_ instanceof EntityPlayer) {
/*  58 */       if (p_70785_2_ < 3.0F) {
/*  59 */         double d1 = p_70785_1_.field_70165_t - this.field_70165_t;
/*  60 */         double d2 = p_70785_1_.field_70161_v - this.field_70161_v;
/*  61 */         this.field_70177_z = (float)(Math.atan2(d2, d1) * 180.0D / 3.1415927410125732D) - 90.0F;
/*     */         
/*  63 */         this.field_70787_b = true;
/*     */       } 
/*     */       
/*  66 */       EntityPlayer entityPlayer = (EntityPlayer)p_70785_1_;
/*  67 */       if (entityPlayer.func_71045_bC() == null || !func_70877_b(entityPlayer.func_71045_bC())) {
/*  68 */         this.field_70789_a = null;
/*     */       }
/*  70 */     } else if (p_70785_1_ instanceof EntityAnimal) {
/*  71 */       EntityAnimal entityAnimal = (EntityAnimal)p_70785_1_;
/*  72 */       if (func_70874_b() > 0 && entityAnimal.func_70874_b() < 0)
/*  73 */       { if (p_70785_2_ < 2.5D) {
/*  74 */           this.field_70787_b = true;
/*     */         } }
/*  76 */       else if (this.field_70881_d > 0 && entityAnimal.field_70881_d > 0)
/*  77 */       { if (entityAnimal.field_70789_a == null) entityAnimal.field_70789_a = (Entity)this;
/*     */         
/*  79 */         if (entityAnimal.field_70789_a == this && p_70785_2_ < 3.5D)
/*  80 */         { entityAnimal.field_70881_d++;
/*  81 */           this.field_70881_d++;
/*  82 */           this.field_70882_e++;
/*  83 */           if (this.field_70882_e % 4 == 0) {
/*  84 */             this.field_70170_p.func_72869_a("heart", this.field_70165_t + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, this.field_70163_u + 0.5D + (this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, 0.0D, 0.0D, 0.0D);
/*     */           }
/*     */           
/*  87 */           if (this.field_70882_e == 60) func_70876_c((EntityAnimal)p_70785_1_);  }
/*  88 */         else { this.field_70882_e = 0; }
/*     */          }
/*  90 */       else { this.field_70882_e = 0;
/*  91 */         this.field_70789_a = null; }
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_70876_c(EntityAnimal p_70876_1_) {
/*  97 */     EntityAgeable entityAgeable = func_90011_a(p_70876_1_);
/*  98 */     if (entityAgeable != null) {
/*  99 */       if (this.field_146084_br == null && p_70876_1_.func_146083_cb() != null) {
/* 100 */         this.field_146084_br = p_70876_1_.func_146083_cb();
/*     */       }
/*     */       
/* 103 */       if (this.field_146084_br != null) {
/* 104 */         this.field_146084_br.func_71029_a(StatList.field_151186_x);
/*     */         
/* 106 */         if (this instanceof EntityCow) {
/* 107 */           this.field_146084_br.func_71029_a((StatBase)AchievementList.field_150962_H);
/*     */         }
/*     */       } 
/*     */       
/* 111 */       func_70873_a(6000);
/* 112 */       p_70876_1_.func_70873_a(6000);
/* 113 */       this.field_70881_d = 0;
/* 114 */       this.field_70882_e = 0;
/* 115 */       this.field_70789_a = null;
/* 116 */       p_70876_1_.field_70789_a = null;
/* 117 */       p_70876_1_.field_70882_e = 0;
/* 118 */       p_70876_1_.field_70881_d = 0;
/* 119 */       entityAgeable.func_70873_a(-24000);
/* 120 */       entityAgeable.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 121 */       for (byte b = 0; b < 7; b++) {
/* 122 */         double d1 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 123 */         double d2 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 124 */         double d3 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 125 */         this.field_70170_p.func_72869_a("heart", this.field_70165_t + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, this.field_70163_u + 0.5D + (this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, d1, d2, d3);
/*     */       } 
/* 127 */       this.field_70170_p.func_72838_d((Entity)entityAgeable);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/* 133 */     if (func_85032_ar()) return false; 
/* 134 */     this.field_70788_c = 60;
/*     */     
/* 136 */     if (!func_70650_aV()) {
/* 137 */       IAttributeInstance iAttributeInstance = func_110148_a(SharedMonsterAttributes.field_111263_d);
/* 138 */       if (iAttributeInstance.func_111127_a(field_110179_h) == null) {
/* 139 */         iAttributeInstance.func_111121_a(field_110181_i);
/*     */       }
/*     */     } 
/*     */     
/* 143 */     this.field_70789_a = null;
/* 144 */     this.field_70881_d = 0;
/* 145 */     return super.func_70097_a(p_70097_1_, p_70097_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_) {
/* 150 */     if (this.field_70170_p.func_147439_a(p_70783_1_, p_70783_2_ - 1, p_70783_3_) == Blocks.field_150349_c) return 10.0F; 
/* 151 */     return this.field_70170_p.func_72801_o(p_70783_1_, p_70783_2_, p_70783_3_) - 0.5F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 156 */     super.func_70014_b(p_70014_1_);
/* 157 */     p_70014_1_.func_74768_a("InLove", this.field_70881_d);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 162 */     super.func_70037_a(p_70037_1_);
/* 163 */     this.field_70881_d = p_70037_1_.func_74762_e("InLove");
/*     */   }
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 168 */     if (this.field_70788_c > 0) return null;
/*     */     
/* 170 */     float f = 8.0F;
/* 171 */     if (this.field_70881_d > 0) {
/* 172 */       List<EntityAnimal> list = this.field_70170_p.func_72872_a(getClass(), this.field_70121_D.func_72314_b(f, f, f));
/* 173 */       for (byte b = 0; b < list.size(); b++) {
/* 174 */         EntityAnimal entityAnimal = list.get(b);
/* 175 */         if (entityAnimal != this && entityAnimal.field_70881_d > 0) {
/* 176 */           return (Entity)entityAnimal;
/*     */         }
/*     */       }
/*     */     
/* 180 */     } else if (func_70874_b() == 0) {
/* 181 */       List<EntityPlayer> list = this.field_70170_p.func_72872_a(EntityPlayer.class, this.field_70121_D.func_72314_b(f, f, f));
/* 182 */       for (byte b = 0; b < list.size(); b++) {
/* 183 */         EntityPlayer entityPlayer = list.get(b);
/* 184 */         if (entityPlayer.func_71045_bC() != null && func_70877_b(entityPlayer.func_71045_bC())) {
/* 185 */           return (Entity)entityPlayer;
/*     */         }
/*     */       } 
/* 188 */     } else if (func_70874_b() > 0) {
/* 189 */       List<EntityAnimal> list = this.field_70170_p.func_72872_a(getClass(), this.field_70121_D.func_72314_b(f, f, f));
/* 190 */       for (byte b = 0; b < list.size(); b++) {
/* 191 */         EntityAnimal entityAnimal = list.get(b);
/* 192 */         if (entityAnimal != this && entityAnimal.func_70874_b() < 0) {
/* 193 */           return (Entity)entityAnimal;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 198 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/* 203 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/* 204 */     int j = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/* 205 */     int k = MathHelper.func_76128_c(this.field_70161_v);
/* 206 */     return (this.field_70170_p.func_147439_a(i, j - 1, k) == Blocks.field_150349_c && this.field_70170_p.func_72883_k(i, j, k) > 8 && super.func_70601_bi());
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70627_aG() {
/* 211 */     return 120;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/* 216 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_70693_a(EntityPlayer p_70693_1_) {
/* 221 */     return 1 + this.field_70170_p.field_73012_v.nextInt(3);
/*     */   }
/*     */   
/*     */   public boolean func_70877_b(ItemStack p_70877_1_) {
/* 225 */     return (p_70877_1_.func_77973_b() == Items.field_151015_O);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer p_70085_1_) {
/* 230 */     ItemStack itemStack = p_70085_1_.field_71071_by.func_70448_g();
/* 231 */     if (itemStack != null && func_70877_b(itemStack) && func_70874_b() == 0 && this.field_70881_d <= 0) {
/* 232 */       if (!p_70085_1_.field_71075_bZ.field_75098_d) {
/* 233 */         itemStack.field_77994_a--;
/* 234 */         if (itemStack.field_77994_a <= 0) {
/* 235 */           p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, null);
/*     */         }
/*     */       } 
/* 238 */       func_146082_f(p_70085_1_);
/* 239 */       return true;
/*     */     } 
/* 241 */     return super.func_70085_c(p_70085_1_);
/*     */   }
/*     */   
/*     */   public void func_146082_f(EntityPlayer p_146082_1_) {
/* 245 */     this.field_70881_d = 600;
/* 246 */     this.field_146084_br = p_146082_1_;
/*     */     
/* 248 */     this.field_70789_a = null;
/* 249 */     this.field_70170_p.func_72960_a((Entity)this, (byte)18);
/*     */   }
/*     */   
/*     */   public EntityPlayer func_146083_cb() {
/* 253 */     return this.field_146084_br;
/*     */   }
/*     */   
/*     */   public boolean func_70880_s() {
/* 257 */     return (this.field_70881_d > 0);
/*     */   }
/*     */   
/*     */   public void func_70875_t() {
/* 261 */     this.field_70881_d = 0;
/*     */   }
/*     */   
/*     */   public boolean func_70878_b(EntityAnimal p_70878_1_) {
/* 265 */     if (p_70878_1_ == this) return false; 
/* 266 */     if (p_70878_1_.getClass() != getClass()) return false; 
/* 267 */     return (func_70880_s() && p_70878_1_.func_70880_s());
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70103_a(byte p_70103_1_) {
/* 272 */     if (p_70103_1_ == 18) {
/* 273 */       for (byte b = 0; b < 7; b++) {
/* 274 */         double d1 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 275 */         double d2 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 276 */         double d3 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 277 */         this.field_70170_p.func_72869_a("heart", this.field_70165_t + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, this.field_70163_u + 0.5D + (this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, d1, d2, d3);
/*     */       } 
/*     */     } else {
/* 280 */       super.func_70103_a(p_70103_1_);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\passive\EntityAnimal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */