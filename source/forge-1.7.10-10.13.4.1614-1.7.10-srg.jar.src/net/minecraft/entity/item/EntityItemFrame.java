/*     */ package net.minecraft.entity.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityHanging;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemMap;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.storage.MapData;
/*     */ 
/*     */ public class EntityItemFrame
/*     */   extends EntityHanging {
/*  19 */   private float field_82337_e = 1.0F;
/*     */   
/*     */   public EntityItemFrame(World p_i1590_1_) {
/*  22 */     super(p_i1590_1_);
/*     */   }
/*     */   private static final String __OBFID = "CL_00001547";
/*     */   public EntityItemFrame(World p_i1591_1_, int p_i1591_2_, int p_i1591_3_, int p_i1591_4_, int p_i1591_5_) {
/*  26 */     super(p_i1591_1_, p_i1591_2_, p_i1591_3_, p_i1591_4_, p_i1591_5_);
/*  27 */     func_82328_a(p_i1591_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  32 */     func_70096_w().func_82709_a(2, 5);
/*  33 */     func_70096_w().func_75682_a(3, Byte.valueOf((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/*  38 */     if (func_85032_ar()) return false;
/*     */     
/*  40 */     if (func_82335_i() != null) {
/*  41 */       if (!this.field_70170_p.field_72995_K) {
/*  42 */         func_146065_b(p_70097_1_.func_76346_g(), false);
/*  43 */         func_82334_a((ItemStack)null);
/*     */       } 
/*  45 */       return true;
/*     */     } 
/*  47 */     return super.func_70097_a(p_70097_1_, p_70097_2_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82329_d() {
/*  53 */     return 9;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_82330_g() {
/*  58 */     return 9;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_70112_a(double p_70112_1_) {
/*  63 */     double d = 16.0D;
/*  64 */     d *= 64.0D * this.field_70155_l;
/*  65 */     return (p_70112_1_ < d * d);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_110128_b(Entity p_110128_1_) {
/*  70 */     func_146065_b(p_110128_1_, true);
/*     */   }
/*     */   
/*     */   public void func_146065_b(Entity p_146065_1_, boolean p_146065_2_) {
/*  74 */     ItemStack itemStack = func_82335_i();
/*     */     
/*  76 */     if (p_146065_1_ instanceof EntityPlayer) {
/*  77 */       EntityPlayer entityPlayer = (EntityPlayer)p_146065_1_;
/*     */       
/*  79 */       if (entityPlayer.field_71075_bZ.field_75098_d) {
/*  80 */         func_110131_b(itemStack);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*  85 */     if (p_146065_2_) func_70099_a(new ItemStack(Items.field_151160_bD), 0.0F); 
/*  86 */     if (itemStack != null && this.field_70146_Z.nextFloat() < this.field_82337_e) {
/*  87 */       itemStack = itemStack.func_77946_l();
/*  88 */       func_110131_b(itemStack);
/*  89 */       func_70099_a(itemStack, 0.0F);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_110131_b(ItemStack p_110131_1_) {
/*  94 */     if (p_110131_1_ == null)
/*  95 */       return;  if (p_110131_1_.func_77973_b() == Items.field_151098_aY) {
/*  96 */       MapData mapData = ((ItemMap)p_110131_1_.func_77973_b()).func_77873_a(p_110131_1_, this.field_70170_p);
/*  97 */       mapData.field_76203_h.remove("frame-" + func_145782_y());
/*     */     } 
/*  99 */     p_110131_1_.func_82842_a(null);
/*     */   }
/*     */   
/*     */   public ItemStack func_82335_i() {
/* 103 */     return func_70096_w().func_82710_f(2);
/*     */   }
/*     */   
/*     */   public void func_82334_a(ItemStack p_82334_1_) {
/* 107 */     if (p_82334_1_ != null) {
/* 108 */       p_82334_1_ = p_82334_1_.func_77946_l();
/* 109 */       p_82334_1_.field_77994_a = 1;
/* 110 */       p_82334_1_.func_82842_a(this);
/*     */     } 
/* 112 */     func_70096_w().func_75692_b(2, p_82334_1_);
/* 113 */     func_70096_w().func_82708_h(2);
/*     */   }
/*     */   
/*     */   public int func_82333_j() {
/* 117 */     return func_70096_w().func_75683_a(3);
/*     */   }
/*     */   
/*     */   public void func_82336_g(int p_82336_1_) {
/* 121 */     func_70096_w().func_75692_b(3, Byte.valueOf((byte)(p_82336_1_ % 4)));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 126 */     if (func_82335_i() != null) {
/* 127 */       p_70014_1_.func_74782_a("Item", (NBTBase)func_82335_i().func_77955_b(new NBTTagCompound()));
/* 128 */       p_70014_1_.func_74774_a("ItemRotation", (byte)func_82333_j());
/* 129 */       p_70014_1_.func_74776_a("ItemDropChance", this.field_82337_e);
/*     */     } 
/* 131 */     super.func_70014_b(p_70014_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 136 */     NBTTagCompound nBTTagCompound = p_70037_1_.func_74775_l("Item");
/* 137 */     if (nBTTagCompound != null && !nBTTagCompound.func_82582_d()) {
/* 138 */       func_82334_a(ItemStack.func_77949_a(nBTTagCompound));
/* 139 */       func_82336_g(p_70037_1_.func_74771_c("ItemRotation"));
/*     */       
/* 141 */       if (p_70037_1_.func_150297_b("ItemDropChance", 99)) this.field_82337_e = p_70037_1_.func_74760_g("ItemDropChance"); 
/*     */     } 
/* 143 */     super.func_70037_a(p_70037_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer p_130002_1_) {
/* 148 */     if (func_82335_i() == null) {
/* 149 */       ItemStack itemStack = p_130002_1_.func_70694_bm();
/*     */       
/* 151 */       if (itemStack != null && 
/* 152 */         !this.field_70170_p.field_72995_K) {
/* 153 */         func_82334_a(itemStack);
/*     */         
/* 155 */         if (!p_130002_1_.field_71075_bZ.field_75098_d && 
/* 156 */           --itemStack.field_77994_a <= 0) {
/* 157 */           p_130002_1_.field_71071_by.func_70299_a(p_130002_1_.field_71071_by.field_70461_c, null);
/*     */         
/*     */         }
/*     */       }
/*     */     
/*     */     }
/* 163 */     else if (!this.field_70170_p.field_72995_K) {
/* 164 */       func_82336_g(func_82333_j() + 1);
/*     */     } 
/*     */ 
/*     */     
/* 168 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityItemFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */