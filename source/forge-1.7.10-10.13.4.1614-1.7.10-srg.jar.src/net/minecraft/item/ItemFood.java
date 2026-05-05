/*    */ package net.minecraft.item;
/*    */ 
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemFood extends Item {
/* 10 */   public final int field_77855_a = 32;
/*    */   
/*    */   private final int field_77853_b;
/*    */   private final float field_77854_c;
/*    */   private final boolean field_77856_bY;
/*    */   private boolean field_77852_bZ;
/*    */   private int field_77851_ca;
/*    */   private int field_77850_cb;
/*    */   private int field_77857_cc;
/*    */   private float field_77858_cd;
/*    */   private static final String __OBFID = "CL_00000036";
/*    */   
/*    */   public ItemFood(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
/* 23 */     this.field_77853_b = p_i45339_1_;
/* 24 */     this.field_77856_bY = p_i45339_3_;
/* 25 */     this.field_77854_c = p_i45339_2_;
/* 26 */     func_77637_a(CreativeTabs.field_78039_h);
/*    */   }
/*    */   
/*    */   public ItemFood(int p_i45340_1_, boolean p_i45340_2_) {
/* 30 */     this(p_i45340_1_, 0.6F, p_i45340_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
/* 35 */     p_77654_1_.field_77994_a--;
/* 36 */     p_77654_3_.func_71024_bL().func_151686_a(this, p_77654_1_);
/* 37 */     p_77654_2_.func_72956_a((Entity)p_77654_3_, "random.burp", 0.5F, p_77654_2_.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*    */     
/* 39 */     func_77849_c(p_77654_1_, p_77654_2_, p_77654_3_);
/*    */     
/* 41 */     return p_77654_1_;
/*    */   }
/*    */   
/*    */   protected void func_77849_c(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_) {
/* 45 */     if (!p_77849_2_.field_72995_K && this.field_77851_ca > 0 && p_77849_2_.field_73012_v.nextFloat() < this.field_77858_cd) {
/* 46 */       p_77849_3_.func_70690_d(new PotionEffect(this.field_77851_ca, this.field_77850_cb * 20, this.field_77857_cc));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_77626_a(ItemStack p_77626_1_) {
/* 53 */     return 32;
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumAction func_77661_b(ItemStack p_77661_1_) {
/* 58 */     return EnumAction.eat;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 63 */     if (p_77659_3_.func_71043_e(this.field_77852_bZ)) {
/* 64 */       p_77659_3_.func_71008_a(p_77659_1_, func_77626_a(p_77659_1_));
/*    */     }
/* 66 */     return p_77659_1_;
/*    */   }
/*    */   
/*    */   public int func_150905_g(ItemStack p_150905_1_) {
/* 70 */     return this.field_77853_b;
/*    */   }
/*    */   
/*    */   public float func_150906_h(ItemStack p_150906_1_) {
/* 74 */     return this.field_77854_c;
/*    */   }
/*    */   
/*    */   public boolean func_77845_h() {
/* 78 */     return this.field_77856_bY;
/*    */   }
/*    */   
/*    */   public ItemFood func_77844_a(int p_77844_1_, int p_77844_2_, int p_77844_3_, float p_77844_4_) {
/* 82 */     this.field_77851_ca = p_77844_1_;
/* 83 */     this.field_77850_cb = p_77844_2_;
/* 84 */     this.field_77857_cc = p_77844_3_;
/* 85 */     this.field_77858_cd = p_77844_4_;
/* 86 */     return this;
/*    */   }
/*    */   
/*    */   public ItemFood func_77848_i() {
/* 90 */     this.field_77852_bZ = true;
/* 91 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemFood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */