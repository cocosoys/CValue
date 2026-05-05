/*    */ package net.minecraft.util;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class WeightedRandomFishable
/*    */   extends WeightedRandom.Item {
/*    */   private final ItemStack field_150711_b;
/*    */   private float field_150712_c;
/*    */   private boolean field_150710_d;
/*    */   private static final String __OBFID = "CL_00001664";
/*    */   
/*    */   public WeightedRandomFishable(ItemStack p_i45317_1_, int p_i45317_2_) {
/* 15 */     super(p_i45317_2_);
/* 16 */     this.field_150711_b = p_i45317_1_;
/*    */   }
/*    */   
/*    */   public ItemStack func_150708_a(Random p_150708_1_) {
/* 20 */     ItemStack itemStack = this.field_150711_b.func_77946_l();
/*    */     
/* 22 */     if (this.field_150712_c > 0.0F) {
/* 23 */       int i = (int)(this.field_150712_c * this.field_150711_b.func_77958_k());
/* 24 */       int j = itemStack.func_77958_k() - p_150708_1_.nextInt(p_150708_1_.nextInt(i) + 1);
/* 25 */       if (j > i) j = i; 
/* 26 */       if (j < 1) j = 1; 
/* 27 */       itemStack.func_77964_b(j);
/*    */     } 
/*    */     
/* 30 */     if (this.field_150710_d) {
/* 31 */       EnchantmentHelper.func_77504_a(p_150708_1_, itemStack, 30);
/*    */     }
/*    */     
/* 34 */     return itemStack;
/*    */   }
/*    */   
/*    */   public WeightedRandomFishable func_150709_a(float p_150709_1_) {
/* 38 */     this.field_150712_c = p_150709_1_;
/* 39 */     return this;
/*    */   }
/*    */   
/*    */   public WeightedRandomFishable func_150707_a() {
/* 43 */     this.field_150710_d = true;
/* 44 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\WeightedRandomFishable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */