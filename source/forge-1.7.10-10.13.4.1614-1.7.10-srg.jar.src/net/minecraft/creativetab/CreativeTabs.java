/*     */ package net.minecraft.creativetab;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnumEnchantmentType;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ 
/*     */ public abstract class CreativeTabs {
/*  12 */   public static CreativeTabs[] field_78032_a = new CreativeTabs[12];
/*  13 */   public static final CreativeTabs field_78030_b = new CreativeTabs(0, "buildingBlocks") { private static final String __OBFID = "CL_00000006";
/*     */       @SideOnly(Side.CLIENT)
/*     */       public Item func_78016_d() {
/*  16 */         return Item.func_150898_a(Blocks.field_150336_V);
/*     */       } }
/*     */   ;
/*  19 */   public static final CreativeTabs field_78031_c = new CreativeTabs(1, "decorations") { private static final String __OBFID = "CL_00000010";
/*     */       @SideOnly(Side.CLIENT)
/*     */       public Item func_78016_d() {
/*  22 */         return Item.func_150898_a((Block)Blocks.field_150398_cm);
/*     */       }
/*     */       
/*     */       @SideOnly(Side.CLIENT)
/*     */       public int func_151243_f() {
/*  27 */         return 5;
/*     */       } }
/*     */   ;
/*  30 */   public static final CreativeTabs field_78028_d = new CreativeTabs(2, "redstone") { private static final String __OBFID = "CL_00000011";
/*     */       @SideOnly(Side.CLIENT)
/*     */       public Item func_78016_d() {
/*  33 */         return Items.field_151137_ax;
/*     */       } }
/*     */   ;
/*  36 */   public static final CreativeTabs field_78029_e = new CreativeTabs(3, "transportation") { private static final String __OBFID = "CL_00000012";
/*     */       @SideOnly(Side.CLIENT)
/*     */       public Item func_78016_d() {
/*  39 */         return Item.func_150898_a(Blocks.field_150318_D);
/*     */       } }
/*     */   ;
/*  42 */   public static final CreativeTabs field_78026_f = (new CreativeTabs(4, "misc") { private static final String __OBFID = "CL_00000014";
/*     */       @SideOnly(Side.CLIENT)
/*     */       public Item func_78016_d() {
/*  45 */         return Items.field_151129_at;
/*     */       } }
/*     */     ).func_111229_a(new EnumEnchantmentType[] { EnumEnchantmentType.all });
/*  48 */   public static final CreativeTabs field_78027_g = (new CreativeTabs(5, "search") { private static final String __OBFID = "CL_00000015";
/*     */       @SideOnly(Side.CLIENT)
/*     */       public Item func_78016_d() {
/*  51 */         return Items.field_151111_aL;
/*     */       } }
/*     */     ).func_78025_a("item_search.png");
/*     */   
/*  55 */   public static final CreativeTabs field_78039_h = new CreativeTabs(6, "food") { private static final String __OBFID = "CL_00000016";
/*     */       @SideOnly(Side.CLIENT)
/*     */       public Item func_78016_d() {
/*  58 */         return Items.field_151034_e;
/*     */       } }
/*     */   ;
/*  61 */   public static final CreativeTabs field_78040_i = (new CreativeTabs(7, "tools") { private static final String __OBFID = "CL_00000017";
/*     */       @SideOnly(Side.CLIENT)
/*     */       public Item func_78016_d() {
/*  64 */         return Items.field_151036_c;
/*     */       } }
/*     */     ).func_111229_a(new EnumEnchantmentType[] { EnumEnchantmentType.digger, EnumEnchantmentType.fishing_rod, EnumEnchantmentType.breakable });
/*     */   
/*  68 */   public static final CreativeTabs field_78037_j = (new CreativeTabs(8, "combat") { private static final String __OBFID = "CL_00000018";
/*     */       @SideOnly(Side.CLIENT)
/*     */       public Item func_78016_d() {
/*  71 */         return Items.field_151010_B;
/*     */       } }
/*     */     ).func_111229_a(new EnumEnchantmentType[] { EnumEnchantmentType.armor, EnumEnchantmentType.armor_feet, EnumEnchantmentType.armor_head, EnumEnchantmentType.armor_legs, EnumEnchantmentType.armor_torso, EnumEnchantmentType.bow, EnumEnchantmentType.weapon });
/*     */ 
/*     */ 
/*     */   
/*  77 */   public static final CreativeTabs field_78038_k = new CreativeTabs(9, "brewing") { private static final String __OBFID = "CL_00000007";
/*     */       @SideOnly(Side.CLIENT)
/*     */       public Item func_78016_d() {
/*  80 */         return (Item)Items.field_151068_bn;
/*     */       } }
/*     */   ;
/*  83 */   public static final CreativeTabs field_78035_l = new CreativeTabs(10, "materials") { private static final String __OBFID = "CL_00000008";
/*     */       @SideOnly(Side.CLIENT)
/*     */       public Item func_78016_d() {
/*  86 */         return Items.field_151055_y;
/*     */       } }
/*     */   ;
/*  89 */   public static final CreativeTabs field_78036_m = (new CreativeTabs(11, "inventory") { private static final String __OBFID = "CL_00000009";
/*     */       @SideOnly(Side.CLIENT)
/*     */       public Item func_78016_d() {
/*  92 */         return Item.func_150898_a((Block)Blocks.field_150486_ae);
/*     */       } }
/*     */     ).func_78025_a("inventory.png").func_78022_j().func_78014_h();
/*     */   
/*     */   private final int field_78033_n;
/*     */   private final String field_78034_o;
/*  98 */   private String field_78043_p = "items.png"; private boolean field_78042_q = true; private boolean field_78041_r = true;
/*     */   private EnumEnchantmentType[] field_111230_s;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private ItemStack field_151245_t;
/*     */   private static final String __OBFID = "CL_00000005";
/*     */   
/*     */   public CreativeTabs(int p_i1853_1_, String p_i1853_2_) {
/* 105 */     this.field_78033_n = p_i1853_1_;
/* 106 */     this.field_78034_o = p_i1853_2_;
/*     */     
/* 108 */     field_78032_a[p_i1853_1_] = this;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_78021_a() {
/* 112 */     return this.field_78033_n;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_78013_b() {
/* 116 */     return this.field_78034_o;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_78024_c() {
/* 120 */     return "itemGroup." + func_78013_b();
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ItemStack func_151244_d() {
/* 124 */     if (this.field_151245_t == null) {
/* 125 */       this.field_151245_t = new ItemStack(func_78016_d(), 1, func_151243_f());
/*     */     }
/* 127 */     return this.field_151245_t;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_151243_f() {
/* 133 */     return 0;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_78015_f() {
/* 137 */     return this.field_78043_p;
/*     */   }
/*     */   
/*     */   public CreativeTabs func_78025_a(String p_78025_1_) {
/* 141 */     this.field_78043_p = p_78025_1_;
/* 142 */     return this;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_78019_g() {
/* 146 */     return this.field_78041_r;
/*     */   }
/*     */   
/*     */   public CreativeTabs func_78014_h() {
/* 150 */     this.field_78041_r = false;
/* 151 */     return this;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_78017_i() {
/* 155 */     return this.field_78042_q;
/*     */   }
/*     */   
/*     */   public CreativeTabs func_78022_j() {
/* 159 */     this.field_78042_q = false;
/* 160 */     return this;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_78020_k() {
/* 164 */     return this.field_78033_n % 6;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_78023_l() {
/* 168 */     return (this.field_78033_n < 6);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EnumEnchantmentType[] func_111225_m() {
/* 172 */     return this.field_111230_s;
/*     */   }
/*     */   
/*     */   public CreativeTabs func_111229_a(EnumEnchantmentType... p_111229_1_) {
/* 176 */     this.field_111230_s = p_111229_1_;
/* 177 */     return this;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_111226_a(EnumEnchantmentType p_111226_1_) {
/* 181 */     if (this.field_111230_s == null) return false;
/*     */     
/* 183 */     for (EnumEnchantmentType enumEnchantmentType : this.field_111230_s) {
/* 184 */       if (enumEnchantmentType == p_111226_1_) return true;
/*     */     
/*     */     } 
/* 187 */     return false;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_78018_a(List p_78018_1_) {
/* 191 */     for (Item item : Item.field_150901_e) {
/* 192 */       if (item != null && 
/* 193 */         item.func_77640_w() == this) {
/* 194 */         item.func_150895_a(item, this, p_78018_1_);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 199 */     if (func_111225_m() != null)
/* 200 */       func_92116_a(p_78018_1_, func_111225_m()); 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_92116_a(List<ItemStack> p_92116_1_, EnumEnchantmentType... p_92116_2_) {
/* 205 */     for (Enchantment enchantment : Enchantment.field_77331_b) {
/* 206 */       if (enchantment != null && enchantment.field_77351_y != null) {
/* 207 */         boolean bool = false;
/*     */         
/* 209 */         for (byte b = 0; b < p_92116_2_.length && !bool; b++) {
/* 210 */           if (enchantment.field_77351_y == p_92116_2_[b]) bool = true;
/*     */         
/*     */         } 
/* 213 */         if (bool)
/* 214 */           p_92116_1_.add(Items.field_151134_bR.func_92111_a(new EnchantmentData(enchantment, enchantment.func_77325_b()))); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public abstract Item func_78016_d();
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\creativetab\CreativeTabs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */