/*     */ package net.minecraft.village;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ public class MerchantRecipe {
/*     */   private ItemStack field_77403_a;
/*     */   private ItemStack field_77401_b;
/*     */   private ItemStack field_77402_c;
/*     */   
/*     */   public MerchantRecipe(NBTTagCompound p_i1940_1_) {
/*  16 */     func_77390_a(p_i1940_1_);
/*     */   }
/*     */   private int field_77400_d; private int field_82786_e; private static final String __OBFID = "CL_00000126";
/*     */   public MerchantRecipe(ItemStack p_i1941_1_, ItemStack p_i1941_2_, ItemStack p_i1941_3_) {
/*  20 */     this.field_77403_a = p_i1941_1_;
/*  21 */     this.field_77401_b = p_i1941_2_;
/*  22 */     this.field_77402_c = p_i1941_3_;
/*  23 */     this.field_82786_e = 7;
/*     */   }
/*     */   
/*     */   public MerchantRecipe(ItemStack p_i1942_1_, ItemStack p_i1942_2_) {
/*  27 */     this(p_i1942_1_, null, p_i1942_2_);
/*     */   }
/*     */   
/*     */   public MerchantRecipe(ItemStack p_i1943_1_, Item p_i1943_2_) {
/*  31 */     this(p_i1943_1_, new ItemStack(p_i1943_2_));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77394_a() {
/*  39 */     return this.field_77403_a;
/*     */   }
/*     */   
/*     */   public ItemStack func_77396_b() {
/*  43 */     return this.field_77401_b;
/*     */   }
/*     */   
/*     */   public boolean func_77398_c() {
/*  47 */     return (this.field_77401_b != null);
/*     */   }
/*     */   
/*     */   public ItemStack func_77397_d() {
/*  51 */     return this.field_77402_c;
/*     */   }
/*     */   
/*     */   public boolean func_77393_a(MerchantRecipe p_77393_1_) {
/*  55 */     if (this.field_77403_a.func_77973_b() != p_77393_1_.field_77403_a.func_77973_b() || this.field_77402_c.func_77973_b() != p_77393_1_.field_77402_c.func_77973_b()) {
/*  56 */       return false;
/*     */     }
/*  58 */     return ((this.field_77401_b == null && p_77393_1_.field_77401_b == null) || (this.field_77401_b != null && p_77393_1_.field_77401_b != null && this.field_77401_b.func_77973_b() == p_77393_1_.field_77401_b.func_77973_b()));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_77391_b(MerchantRecipe p_77391_1_) {
/*  63 */     return (func_77393_a(p_77391_1_) && (this.field_77403_a.field_77994_a < p_77391_1_.field_77403_a.field_77994_a || (this.field_77401_b != null && this.field_77401_b.field_77994_a < p_77391_1_.field_77401_b.field_77994_a)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77399_f() {
/*  71 */     this.field_77400_d++;
/*     */   }
/*     */   
/*     */   public void func_82783_a(int p_82783_1_) {
/*  75 */     this.field_82786_e += p_82783_1_;
/*     */   }
/*     */   
/*     */   public boolean func_82784_g() {
/*  79 */     return (this.field_77400_d >= this.field_82786_e);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_82785_h() {
/*  83 */     this.field_77400_d = this.field_82786_e;
/*     */   }
/*     */   
/*     */   public void func_77390_a(NBTTagCompound p_77390_1_) {
/*  87 */     NBTTagCompound nBTTagCompound1 = p_77390_1_.func_74775_l("buy");
/*  88 */     this.field_77403_a = ItemStack.func_77949_a(nBTTagCompound1);
/*  89 */     NBTTagCompound nBTTagCompound2 = p_77390_1_.func_74775_l("sell");
/*  90 */     this.field_77402_c = ItemStack.func_77949_a(nBTTagCompound2);
/*  91 */     if (p_77390_1_.func_150297_b("buyB", 10)) {
/*  92 */       this.field_77401_b = ItemStack.func_77949_a(p_77390_1_.func_74775_l("buyB"));
/*     */     }
/*  94 */     if (p_77390_1_.func_150297_b("uses", 99)) {
/*  95 */       this.field_77400_d = p_77390_1_.func_74762_e("uses");
/*     */     }
/*  97 */     if (p_77390_1_.func_150297_b("maxUses", 99)) {
/*  98 */       this.field_82786_e = p_77390_1_.func_74762_e("maxUses");
/*     */     } else {
/* 100 */       this.field_82786_e = 7;
/*     */     } 
/*     */   }
/*     */   
/*     */   public NBTTagCompound func_77395_g() {
/* 105 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 106 */     nBTTagCompound.func_74782_a("buy", (NBTBase)this.field_77403_a.func_77955_b(new NBTTagCompound()));
/* 107 */     nBTTagCompound.func_74782_a("sell", (NBTBase)this.field_77402_c.func_77955_b(new NBTTagCompound()));
/* 108 */     if (this.field_77401_b != null) {
/* 109 */       nBTTagCompound.func_74782_a("buyB", (NBTBase)this.field_77401_b.func_77955_b(new NBTTagCompound()));
/*     */     }
/* 111 */     nBTTagCompound.func_74768_a("uses", this.field_77400_d);
/* 112 */     nBTTagCompound.func_74768_a("maxUses", this.field_82786_e);
/* 113 */     return nBTTagCompound;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\village\MerchantRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */