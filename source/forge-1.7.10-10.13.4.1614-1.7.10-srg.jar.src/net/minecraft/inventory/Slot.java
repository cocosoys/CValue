/*     */ package net.minecraft.inventory;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ 
/*     */ public class Slot {
/*     */   private final int field_75225_a;
/*     */   public final IInventory field_75224_c;
/*     */   public int field_75222_d;
/*     */   
/*     */   public Slot(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_) {
/*  15 */     this.field_75224_c = p_i1824_1_;
/*  16 */     this.field_75225_a = p_i1824_2_;
/*  17 */     this.field_75223_e = p_i1824_3_;
/*  18 */     this.field_75221_f = p_i1824_4_;
/*     */   }
/*     */   public int field_75223_e; public int field_75221_f; private static final String __OBFID = "CL_00001762";
/*     */   public void func_75220_a(ItemStack p_75220_1_, ItemStack p_75220_2_) {
/*  22 */     if (p_75220_1_ == null || p_75220_2_ == null) {
/*     */       return;
/*     */     }
/*  25 */     if (p_75220_1_.func_77973_b() != p_75220_2_.func_77973_b()) {
/*     */       return;
/*     */     }
/*  28 */     int i = p_75220_2_.field_77994_a - p_75220_1_.field_77994_a;
/*  29 */     if (i > 0) {
/*  30 */       func_75210_a(p_75220_1_, i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_75210_a(ItemStack p_75210_1_, int p_75210_2_) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_75208_c(ItemStack p_75208_1_) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
/*  61 */     func_75218_e();
/*     */   }
/*     */   
/*     */   public boolean func_75214_a(ItemStack p_75214_1_) {
/*  65 */     return true;
/*     */   }
/*     */   
/*     */   public ItemStack func_75211_c() {
/*  69 */     return this.field_75224_c.func_70301_a(this.field_75225_a);
/*     */   }
/*     */   
/*     */   public boolean func_75216_d() {
/*  73 */     return (func_75211_c() != null);
/*     */   }
/*     */   
/*     */   public void func_75215_d(ItemStack p_75215_1_) {
/*  77 */     this.field_75224_c.func_70299_a(this.field_75225_a, p_75215_1_);
/*  78 */     func_75218_e();
/*     */   }
/*     */   
/*     */   public void func_75218_e() {
/*  82 */     this.field_75224_c.func_70296_d();
/*     */   }
/*     */   
/*     */   public int func_75219_a() {
/*  86 */     return this.field_75224_c.func_70297_j_();
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_75212_b() {
/*  90 */     return null;
/*     */   }
/*     */   
/*     */   public ItemStack func_75209_a(int p_75209_1_) {
/*  94 */     return this.field_75224_c.func_70298_a(this.field_75225_a, p_75209_1_);
/*     */   }
/*     */   
/*     */   public boolean func_75217_a(IInventory p_75217_1_, int p_75217_2_) {
/*  98 */     return (p_75217_1_ == this.field_75224_c && p_75217_2_ == this.field_75225_a);
/*     */   }
/*     */   
/*     */   public boolean func_82869_a(EntityPlayer p_82869_1_) {
/* 102 */     return true;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_111238_b() {
/* 106 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\Slot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */