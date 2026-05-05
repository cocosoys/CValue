/*    */ package net.minecraft.inventory;
/*    */ 
/*    */ import net.minecraft.entity.IMerchant;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.village.MerchantRecipe;
/*    */ 
/*    */ public class SlotMerchantResult
/*    */   extends Slot
/*    */ {
/*    */   private final InventoryMerchant field_75233_a;
/*    */   private EntityPlayer field_75232_b;
/*    */   
/*    */   public SlotMerchantResult(EntityPlayer p_i1822_1_, IMerchant p_i1822_2_, InventoryMerchant p_i1822_3_, int p_i1822_4_, int p_i1822_5_, int p_i1822_6_) {
/* 15 */     super(p_i1822_3_, p_i1822_4_, p_i1822_5_, p_i1822_6_);
/* 16 */     this.field_75232_b = p_i1822_1_;
/* 17 */     this.field_75234_h = p_i1822_2_;
/* 18 */     this.field_75233_a = p_i1822_3_;
/*    */   }
/*    */   private int field_75231_g; private final IMerchant field_75234_h; private static final String __OBFID = "CL_00001758";
/*    */   
/*    */   public boolean func_75214_a(ItemStack p_75214_1_) {
/* 23 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_75209_a(int p_75209_1_) {
/* 28 */     if (func_75216_d()) {
/* 29 */       this.field_75231_g += Math.min(p_75209_1_, (func_75211_c()).field_77994_a);
/*    */     }
/* 31 */     return super.func_75209_a(p_75209_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_75210_a(ItemStack p_75210_1_, int p_75210_2_) {
/* 36 */     this.field_75231_g += p_75210_2_;
/* 37 */     func_75208_c(p_75210_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_75208_c(ItemStack p_75208_1_) {
/* 42 */     p_75208_1_.func_77980_a(this.field_75232_b.field_70170_p, this.field_75232_b, this.field_75231_g);
/* 43 */     this.field_75231_g = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
/* 48 */     func_75208_c(p_82870_2_);
/*    */     
/* 50 */     MerchantRecipe merchantRecipe = this.field_75233_a.func_70468_h();
/* 51 */     if (merchantRecipe != null) {
/*    */       
/* 53 */       ItemStack itemStack1 = this.field_75233_a.func_70301_a(0);
/* 54 */       ItemStack itemStack2 = this.field_75233_a.func_70301_a(1);
/*    */ 
/*    */       
/* 57 */       if (func_75230_a(merchantRecipe, itemStack1, itemStack2) || func_75230_a(merchantRecipe, itemStack2, itemStack1)) {
/* 58 */         this.field_75234_h.func_70933_a(merchantRecipe);
/*    */         
/* 60 */         if (itemStack1 != null && itemStack1.field_77994_a <= 0) {
/* 61 */           itemStack1 = null;
/*    */         }
/* 63 */         if (itemStack2 != null && itemStack2.field_77994_a <= 0) {
/* 64 */           itemStack2 = null;
/*    */         }
/* 66 */         this.field_75233_a.func_70299_a(0, itemStack1);
/* 67 */         this.field_75233_a.func_70299_a(1, itemStack2);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private boolean func_75230_a(MerchantRecipe p_75230_1_, ItemStack p_75230_2_, ItemStack p_75230_3_) {
/* 73 */     ItemStack itemStack1 = p_75230_1_.func_77394_a();
/* 74 */     ItemStack itemStack2 = p_75230_1_.func_77396_b();
/*    */     
/* 76 */     if (p_75230_2_ != null && p_75230_2_.func_77973_b() == itemStack1.func_77973_b()) {
/* 77 */       if (itemStack2 != null && p_75230_3_ != null && itemStack2.func_77973_b() == p_75230_3_.func_77973_b()) {
/* 78 */         p_75230_2_.field_77994_a -= itemStack1.field_77994_a;
/* 79 */         p_75230_3_.field_77994_a -= itemStack2.field_77994_a;
/* 80 */         return true;
/* 81 */       }  if (itemStack2 == null && p_75230_3_ == null) {
/* 82 */         p_75230_2_.field_77994_a -= itemStack1.field_77994_a;
/* 83 */         return true;
/*    */       } 
/*    */     } 
/* 86 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\SlotMerchantResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */