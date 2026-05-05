/*    */ package net.minecraft.inventory;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityXPOrb;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.crafting.FurnaceRecipes;
/*    */ import net.minecraft.stats.AchievementList;
/*    */ import net.minecraft.stats.StatBase;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public class SlotFurnace extends Slot {
/*    */   private EntityPlayer field_75229_a;
/*    */   
/*    */   public SlotFurnace(EntityPlayer p_i1813_1_, IInventory p_i1813_2_, int p_i1813_3_, int p_i1813_4_, int p_i1813_5_) {
/* 17 */     super(p_i1813_2_, p_i1813_3_, p_i1813_4_, p_i1813_5_);
/*    */     
/* 19 */     this.field_75229_a = p_i1813_1_;
/*    */   }
/*    */   private int field_75228_b; private static final String __OBFID = "CL_00001749";
/*    */   
/*    */   public boolean func_75214_a(ItemStack p_75214_1_) {
/* 24 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_75209_a(int p_75209_1_) {
/* 29 */     if (func_75216_d()) {
/* 30 */       this.field_75228_b += Math.min(p_75209_1_, (func_75211_c()).field_77994_a);
/*    */     }
/* 32 */     return super.func_75209_a(p_75209_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
/* 37 */     func_75208_c(p_82870_2_);
/* 38 */     super.func_82870_a(p_82870_1_, p_82870_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_75210_a(ItemStack p_75210_1_, int p_75210_2_) {
/* 43 */     this.field_75228_b += p_75210_2_;
/* 44 */     func_75208_c(p_75210_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_75208_c(ItemStack p_75208_1_) {
/* 49 */     p_75208_1_.func_77980_a(this.field_75229_a.field_70170_p, this.field_75229_a, this.field_75228_b);
/*    */     
/* 51 */     if (!this.field_75229_a.field_70170_p.field_72995_K) {
/* 52 */       int i = this.field_75228_b;
/* 53 */       float f = FurnaceRecipes.func_77602_a().func_151398_b(p_75208_1_);
/*    */       
/* 55 */       if (f == 0.0F) {
/* 56 */         i = 0;
/* 57 */       } else if (f < 1.0F) {
/* 58 */         int j = MathHelper.func_76141_d(i * f);
/* 59 */         if (j < MathHelper.func_76123_f(i * f) && (float)Math.random() < i * f - j) {
/* 60 */           j++;
/*    */         }
/* 62 */         i = j;
/*    */       } 
/*    */       
/* 65 */       while (i > 0) {
/* 66 */         int j = EntityXPOrb.func_70527_a(i);
/* 67 */         i -= j;
/* 68 */         this.field_75229_a.field_70170_p.func_72838_d((Entity)new EntityXPOrb(this.field_75229_a.field_70170_p, this.field_75229_a.field_70165_t, this.field_75229_a.field_70163_u + 0.5D, this.field_75229_a.field_70161_v + 0.5D, j));
/*    */       } 
/*    */     } 
/* 71 */     this.field_75228_b = 0;
/*    */     
/* 73 */     if (p_75208_1_.func_77973_b() == Items.field_151042_j) this.field_75229_a.func_71064_a((StatBase)AchievementList.field_76016_k, 1); 
/* 74 */     if (p_75208_1_.func_77973_b() == Items.field_151101_aQ) this.field_75229_a.func_71064_a((StatBase)AchievementList.field_76026_p, 1); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\SlotFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */