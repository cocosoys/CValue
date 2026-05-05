/*     */ package net.minecraft.item;
/*     */ import com.google.common.collect.Multimap;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemSword extends Item {
/*     */   private float field_150934_a;
/*     */   
/*     */   public ItemSword(Item.ToolMaterial p_i45356_1_) {
/*  18 */     this.field_150933_b = p_i45356_1_;
/*  19 */     this.field_77777_bU = 1;
/*  20 */     func_77656_e(p_i45356_1_.func_77997_a());
/*  21 */     func_77637_a(CreativeTabs.field_78037_j);
/*     */     
/*  23 */     this.field_150934_a = 4.0F + p_i45356_1_.func_78000_c();
/*     */   }
/*     */   private final Item.ToolMaterial field_150933_b; private static final String __OBFID = "CL_00000072";
/*     */   public float func_150931_i() {
/*  27 */     return this.field_150933_b.func_78000_c();
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_) {
/*  32 */     if (p_150893_2_ == Blocks.field_150321_G)
/*     */     {
/*  34 */       return 15.0F;
/*     */     }
/*     */ 
/*     */     
/*  38 */     Material material = p_150893_2_.func_149688_o();
/*  39 */     if (material == Material.field_151585_k || material == Material.field_151582_l || material == Material.field_151589_v || material == Material.field_151584_j || material == Material.field_151572_C) {
/*  40 */       return 1.5F;
/*     */     }
/*  42 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_77644_a(ItemStack p_77644_1_, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_) {
/*  47 */     p_77644_1_.func_77972_a(1, p_77644_3_);
/*  48 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_150894_a(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_) {
/*  54 */     if (p_150894_3_.func_149712_f(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_) != 0.0D) p_150894_1_.func_77972_a(2, p_150894_7_); 
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77662_d() {
/*  60 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack p_77661_1_) {
/*  65 */     return EnumAction.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_77626_a(ItemStack p_77626_1_) {
/*  70 */     return 72000;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/*  75 */     p_77659_3_.func_71008_a(p_77659_1_, func_77626_a(p_77659_1_));
/*  76 */     return p_77659_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_150897_b(Block p_150897_1_) {
/*  81 */     return (p_150897_1_ == Blocks.field_150321_G);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_77619_b() {
/*  86 */     return this.field_150933_b.func_77995_e();
/*     */   }
/*     */   
/*     */   public String func_150932_j() {
/*  90 */     return this.field_150933_b.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_82789_a(ItemStack p_82789_1_, ItemStack p_82789_2_) {
/*  95 */     if (this.field_150933_b.func_150995_f() == p_82789_2_.func_77973_b()) {
/*  96 */       return true;
/*     */     }
/*  98 */     return super.func_82789_a(p_82789_1_, p_82789_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public Multimap func_111205_h() {
/* 103 */     Multimap multimap = super.func_111205_h();
/*     */     
/* 105 */     multimap.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Weapon modifier", this.field_150934_a, 0));
/*     */     
/* 107 */     return multimap;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemSword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */