/*     */ package net.minecraft.entity.item;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class EntityMinecartContainer
/*     */   extends EntityMinecart implements IInventory {
/*  15 */   private ItemStack[] field_94113_a = new ItemStack[36];
/*     */   private boolean field_94112_b = true;
/*     */   
/*     */   public EntityMinecartContainer(World p_i1716_1_) {
/*  19 */     super(p_i1716_1_);
/*     */   }
/*     */   private static final String __OBFID = "CL_00001674";
/*     */   public EntityMinecartContainer(World p_i1717_1_, double p_i1717_2_, double p_i1717_4_, double p_i1717_6_) {
/*  23 */     super(p_i1717_1_, p_i1717_2_, p_i1717_4_, p_i1717_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_94095_a(DamageSource p_94095_1_) {
/*  28 */     super.func_94095_a(p_94095_1_);
/*     */     
/*  30 */     for (byte b = 0; b < func_70302_i_(); b++) {
/*  31 */       ItemStack itemStack = func_70301_a(b);
/*  32 */       if (itemStack != null) {
/*  33 */         float f1 = this.field_70146_Z.nextFloat() * 0.8F + 0.1F;
/*  34 */         float f2 = this.field_70146_Z.nextFloat() * 0.8F + 0.1F;
/*  35 */         float f3 = this.field_70146_Z.nextFloat() * 0.8F + 0.1F;
/*     */         
/*  37 */         while (itemStack.field_77994_a > 0) {
/*  38 */           int i = this.field_70146_Z.nextInt(21) + 10;
/*  39 */           if (i > itemStack.field_77994_a) i = itemStack.field_77994_a; 
/*  40 */           itemStack.field_77994_a -= i;
/*     */           
/*  42 */           EntityItem entityItem = new EntityItem(this.field_70170_p, this.field_70165_t + f1, this.field_70163_u + f2, this.field_70161_v + f3, new ItemStack(itemStack.func_77973_b(), i, itemStack.func_77960_j()));
/*  43 */           float f = 0.05F;
/*  44 */           entityItem.field_70159_w = ((float)this.field_70146_Z.nextGaussian() * f);
/*  45 */           entityItem.field_70181_x = ((float)this.field_70146_Z.nextGaussian() * f + 0.2F);
/*  46 */           entityItem.field_70179_y = ((float)this.field_70146_Z.nextGaussian() * f);
/*  47 */           this.field_70170_p.func_72838_d(entityItem);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int p_70301_1_) {
/*  55 */     return this.field_94113_a[p_70301_1_];
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
/*  60 */     if (this.field_94113_a[p_70298_1_] != null) {
/*  61 */       if ((this.field_94113_a[p_70298_1_]).field_77994_a <= p_70298_2_) {
/*  62 */         ItemStack itemStack1 = this.field_94113_a[p_70298_1_];
/*  63 */         this.field_94113_a[p_70298_1_] = null;
/*  64 */         return itemStack1;
/*     */       } 
/*  66 */       ItemStack itemStack = this.field_94113_a[p_70298_1_].func_77979_a(p_70298_2_);
/*  67 */       if ((this.field_94113_a[p_70298_1_]).field_77994_a == 0) this.field_94113_a[p_70298_1_] = null; 
/*  68 */       return itemStack;
/*     */     } 
/*     */     
/*  71 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int p_70304_1_) {
/*  76 */     if (this.field_94113_a[p_70304_1_] != null) {
/*  77 */       ItemStack itemStack = this.field_94113_a[p_70304_1_];
/*  78 */       this.field_94113_a[p_70304_1_] = null;
/*  79 */       return itemStack;
/*     */     } 
/*  81 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
/*  86 */     this.field_94113_a[p_70299_1_] = p_70299_2_;
/*  87 */     if (p_70299_2_ != null && p_70299_2_.field_77994_a > func_70297_j_()) p_70299_2_.field_77994_a = func_70297_j_();
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70296_d() {}
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer p_70300_1_) {
/*  96 */     if (this.field_70128_L) return false; 
/*  97 */     if (p_70300_1_.func_70068_e(this) > 64.0D) return false; 
/*  98 */     return true;
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
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 116 */     return func_145818_k_() ? func_95999_t() : "container.minecart";
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 121 */     return 64;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71027_c(int p_71027_1_) {
/* 126 */     this.field_94112_b = false;
/* 127 */     super.func_71027_c(p_71027_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70106_y() {
/* 132 */     if (this.field_94112_b) {
/* 133 */       for (byte b = 0; b < func_70302_i_(); b++) {
/* 134 */         ItemStack itemStack = func_70301_a(b);
/* 135 */         if (itemStack != null) {
/* 136 */           float f1 = this.field_70146_Z.nextFloat() * 0.8F + 0.1F;
/* 137 */           float f2 = this.field_70146_Z.nextFloat() * 0.8F + 0.1F;
/* 138 */           float f3 = this.field_70146_Z.nextFloat() * 0.8F + 0.1F;
/*     */           
/* 140 */           while (itemStack.field_77994_a > 0) {
/* 141 */             int i = this.field_70146_Z.nextInt(21) + 10;
/* 142 */             if (i > itemStack.field_77994_a) i = itemStack.field_77994_a; 
/* 143 */             itemStack.field_77994_a -= i;
/*     */             
/* 145 */             EntityItem entityItem = new EntityItem(this.field_70170_p, this.field_70165_t + f1, this.field_70163_u + f2, this.field_70161_v + f3, new ItemStack(itemStack.func_77973_b(), i, itemStack.func_77960_j()));
/*     */             
/* 147 */             if (itemStack.func_77942_o()) {
/* 148 */               entityItem.func_92059_d().func_77982_d((NBTTagCompound)itemStack.func_77978_p().func_74737_b());
/*     */             }
/*     */             
/* 151 */             float f = 0.05F;
/* 152 */             entityItem.field_70159_w = ((float)this.field_70146_Z.nextGaussian() * f);
/* 153 */             entityItem.field_70181_x = ((float)this.field_70146_Z.nextGaussian() * f + 0.2F);
/* 154 */             entityItem.field_70179_y = ((float)this.field_70146_Z.nextGaussian() * f);
/* 155 */             this.field_70170_p.func_72838_d(entityItem);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 161 */     super.func_70106_y();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound p_70014_1_) {
/* 166 */     super.func_70014_b(p_70014_1_);
/*     */     
/* 168 */     NBTTagList nBTTagList = new NBTTagList();
/*     */     
/* 170 */     for (byte b = 0; b < this.field_94113_a.length; b++) {
/* 171 */       if (this.field_94113_a[b] != null) {
/* 172 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 173 */         nBTTagCompound.func_74774_a("Slot", (byte)b);
/* 174 */         this.field_94113_a[b].func_77955_b(nBTTagCompound);
/* 175 */         nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*     */       } 
/*     */     } 
/* 178 */     p_70014_1_.func_74782_a("Items", (NBTBase)nBTTagList);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound p_70037_1_) {
/* 184 */     super.func_70037_a(p_70037_1_);
/*     */     
/* 186 */     NBTTagList nBTTagList = p_70037_1_.func_150295_c("Items", 10);
/* 187 */     this.field_94113_a = new ItemStack[func_70302_i_()];
/* 188 */     for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 189 */       NBTTagCompound nBTTagCompound = nBTTagList.func_150305_b(b);
/* 190 */       int i = nBTTagCompound.func_74771_c("Slot") & 0xFF;
/* 191 */       if (i >= 0 && i < this.field_94113_a.length) this.field_94113_a[i] = ItemStack.func_77949_a(nBTTagCompound);
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer p_130002_1_) {
/* 197 */     if (!this.field_70170_p.field_72995_K) {
/* 198 */       p_130002_1_.func_71007_a(this);
/*     */     }
/*     */     
/* 201 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_94101_h() {
/* 206 */     int i = 15 - Container.func_94526_b(this);
/* 207 */     float f = 0.98F + i * 0.001F;
/*     */     
/* 209 */     this.field_70159_w *= f;
/* 210 */     this.field_70181_x *= 0.0D;
/* 211 */     this.field_70179_y *= f;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityMinecartContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */