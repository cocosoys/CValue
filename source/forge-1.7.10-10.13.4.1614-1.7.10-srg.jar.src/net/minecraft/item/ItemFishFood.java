/*     */ package net.minecraft.item;
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.potion.PotionHelper;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemFishFood extends ItemFood {
/*     */   private final boolean field_150907_b;
/*     */   private static final String __OBFID = "CL_00000032";
/*     */   
/*     */   public ItemFishFood(boolean p_i45338_1_) {
/*  21 */     super(0, 0.0F, false);
/*     */     
/*  23 */     this.field_150907_b = p_i45338_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_150905_g(ItemStack p_150905_1_) {
/*  28 */     FishType fishType = FishType.func_150978_a(p_150905_1_);
/*     */     
/*  30 */     if (this.field_150907_b && fishType.func_150973_i()) {
/*  31 */       return fishType.func_150970_e();
/*     */     }
/*  33 */     return fishType.func_150975_c();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_150906_h(ItemStack p_150906_1_) {
/*  39 */     FishType fishType = FishType.func_150978_a(p_150906_1_);
/*     */     
/*  41 */     if (this.field_150907_b && fishType.func_150973_i()) {
/*  42 */       return fishType.func_150977_f();
/*     */     }
/*  44 */     return fishType.func_150967_d();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_150896_i(ItemStack p_150896_1_) {
/*  50 */     if (FishType.func_150978_a(p_150896_1_) == FishType.PUFFERFISH) {
/*  51 */       return PotionHelper.field_151423_m;
/*     */     }
/*  53 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister p_94581_1_) {
/*  59 */     for (FishType fishType : FishType.values()) {
/*  60 */       fishType.func_150968_a(p_94581_1_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_77849_c(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_) {
/*  66 */     FishType fishType = FishType.func_150978_a(p_77849_1_);
/*     */     
/*  68 */     if (fishType == FishType.PUFFERFISH) {
/*  69 */       p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, 1200, 3));
/*  70 */       p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76438_s.field_76415_H, 300, 2));
/*  71 */       p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76431_k.field_76415_H, 300, 1));
/*     */     } 
/*     */     
/*  74 */     super.func_77849_c(p_77849_1_, p_77849_2_, p_77849_3_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_77617_a(int p_77617_1_) {
/*  79 */     FishType fishType = FishType.func_150974_a(p_77617_1_);
/*     */     
/*  81 */     if (this.field_150907_b && fishType.func_150973_i()) {
/*  82 */       return fishType.func_150979_h();
/*     */     }
/*  84 */     return fishType.func_150971_g();
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List<ItemStack> p_150895_3_) {
/*  90 */     for (FishType fishType : FishType.values()) {
/*  91 */       if (!this.field_150907_b || fishType.func_150973_i()) {
/*  92 */         p_150895_3_.add(new ItemStack(this, 1, fishType.func_150976_a()));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_77667_c(ItemStack p_77667_1_) {
/*  99 */     FishType fishType = FishType.func_150978_a(p_77667_1_);
/* 100 */     return func_77658_a() + "." + fishType.func_150972_b() + "." + ((this.field_150907_b && fishType.func_150973_i()) ? "cooked" : "raw");
/*     */   }
/*     */   
/*     */   public enum FishType {
/* 104 */     COD(0, "cod", 2, 0.1F, 5, 0.6F),
/* 105 */     SALMON(1, "salmon", 2, 0.1F, 6, 0.8F),
/* 106 */     CLOWNFISH(2, "clownfish", 1, 0.1F),
/* 107 */     PUFFERFISH(3, "pufferfish", 1, 0.1F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/* 121 */       for (FishType fishType : values())
/* 122 */         field_150983_e.put(Integer.valueOf(fishType.func_150976_a()), fishType); 
/*     */     }
/*     */     private boolean field_150987_n = false; private static final Map field_150983_e = Maps.newHashMap(); private final int field_150980_f; private final String field_150981_g; @SideOnly(Side.CLIENT)
/*     */     private IIcon field_150993_h;
/*     */     FishType(int p_i45336_3_, String p_i45336_4_, int p_i45336_5_, float p_i45336_6_, int p_i45336_7_, float p_i45336_8_) {
/* 127 */       this.field_150980_f = p_i45336_3_;
/* 128 */       this.field_150981_g = p_i45336_4_;
/* 129 */       this.field_150991_j = p_i45336_5_;
/* 130 */       this.field_150992_k = p_i45336_6_;
/* 131 */       this.field_150989_l = p_i45336_7_;
/* 132 */       this.field_150990_m = p_i45336_8_;
/* 133 */       this.field_150987_n = true;
/*     */     } @SideOnly(Side.CLIENT)
/*     */     private IIcon field_150994_i; private final int field_150991_j; private final float field_150992_k; private final int field_150989_l; private final float field_150990_m; private static final String __OBFID = "CL_00000033";
/*     */     FishType(int p_i45337_3_, String p_i45337_4_, int p_i45337_5_, float p_i45337_6_) {
/* 137 */       this.field_150980_f = p_i45337_3_;
/* 138 */       this.field_150981_g = p_i45337_4_;
/* 139 */       this.field_150991_j = p_i45337_5_;
/* 140 */       this.field_150992_k = p_i45337_6_;
/* 141 */       this.field_150989_l = 0;
/* 142 */       this.field_150990_m = 0.0F;
/* 143 */       this.field_150987_n = false;
/*     */     }
/*     */     
/*     */     public int func_150976_a() {
/* 147 */       return this.field_150980_f;
/*     */     }
/*     */     
/*     */     public String func_150972_b() {
/* 151 */       return this.field_150981_g;
/*     */     }
/*     */     
/*     */     public int func_150975_c() {
/* 155 */       return this.field_150991_j;
/*     */     }
/*     */     
/*     */     public float func_150967_d() {
/* 159 */       return this.field_150992_k;
/*     */     }
/*     */     
/*     */     public int func_150970_e() {
/* 163 */       return this.field_150989_l;
/*     */     }
/*     */     
/*     */     public float func_150977_f() {
/* 167 */       return this.field_150990_m;
/*     */     }
/*     */     @SideOnly(Side.CLIENT)
/*     */     public void func_150968_a(IIconRegister p_150968_1_) {
/* 171 */       this.field_150993_h = p_150968_1_.func_94245_a("fish_" + this.field_150981_g + "_raw");
/*     */       
/* 173 */       if (this.field_150987_n)
/* 174 */         this.field_150994_i = p_150968_1_.func_94245_a("fish_" + this.field_150981_g + "_cooked"); 
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public IIcon func_150971_g() {
/* 179 */       return this.field_150993_h;
/*     */     }
/*     */     @SideOnly(Side.CLIENT)
/*     */     public IIcon func_150979_h() {
/* 183 */       return this.field_150994_i;
/*     */     }
/*     */     
/*     */     public boolean func_150973_i() {
/* 187 */       return this.field_150987_n;
/*     */     }
/*     */     
/*     */     public static FishType func_150974_a(int p_150974_0_) {
/* 191 */       FishType fishType = (FishType)field_150983_e.get(Integer.valueOf(p_150974_0_));
/*     */       
/* 193 */       if (fishType == null) {
/* 194 */         return COD;
/*     */       }
/* 196 */       return fishType;
/*     */     }
/*     */ 
/*     */     
/*     */     public static FishType func_150978_a(ItemStack p_150978_0_) {
/* 201 */       if (p_150978_0_.func_77973_b() instanceof ItemFishFood) {
/* 202 */         return func_150974_a(p_150978_0_.func_77960_j());
/*     */       }
/* 204 */       return COD;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemFishFood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */