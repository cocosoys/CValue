/*    */ package net.minecraft.util;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.tileentity.TileEntityDispenser;
/*    */ 
/*    */ public class WeightedRandomChestContent
/*    */   extends WeightedRandom.Item {
/*    */   public ItemStack field_76297_b;
/*    */   public int field_76295_d;
/*    */   
/*    */   public WeightedRandomChestContent(Item p_i45311_1_, int p_i45311_2_, int p_i45311_3_, int p_i45311_4_, int p_i45311_5_) {
/* 15 */     super(p_i45311_5_);
/* 16 */     this.field_76297_b = new ItemStack(p_i45311_1_, 1, p_i45311_2_);
/* 17 */     this.field_76295_d = p_i45311_3_;
/* 18 */     this.field_76296_e = p_i45311_4_;
/*    */   }
/*    */   public int field_76296_e; private static final String __OBFID = "CL_00001505";
/*    */   public WeightedRandomChestContent(ItemStack p_i1558_1_, int p_i1558_2_, int p_i1558_3_, int p_i1558_4_) {
/* 22 */     super(p_i1558_4_);
/* 23 */     this.field_76297_b = p_i1558_1_;
/* 24 */     this.field_76295_d = p_i1558_2_;
/* 25 */     this.field_76296_e = p_i1558_3_;
/*    */   }
/*    */   
/*    */   public static void func_76293_a(Random p_76293_0_, WeightedRandomChestContent[] p_76293_1_, IInventory p_76293_2_, int p_76293_3_) {
/* 29 */     for (byte b = 0; b < p_76293_3_; b++) {
/* 30 */       WeightedRandomChestContent weightedRandomChestContent = (WeightedRandomChestContent)WeightedRandom.func_76274_a(p_76293_0_, (WeightedRandom.Item[])p_76293_1_);
/* 31 */       int i = weightedRandomChestContent.field_76295_d + p_76293_0_.nextInt(weightedRandomChestContent.field_76296_e - weightedRandomChestContent.field_76295_d + 1);
/*    */       
/* 33 */       if (weightedRandomChestContent.field_76297_b.func_77976_d() >= i) {
/* 34 */         ItemStack itemStack = weightedRandomChestContent.field_76297_b.func_77946_l();
/* 35 */         itemStack.field_77994_a = i;
/* 36 */         p_76293_2_.func_70299_a(p_76293_0_.nextInt(p_76293_2_.func_70302_i_()), itemStack);
/*    */       } else {
/*    */         
/* 39 */         for (byte b1 = 0; b1 < i; b1++) {
/* 40 */           ItemStack itemStack = weightedRandomChestContent.field_76297_b.func_77946_l();
/* 41 */           itemStack.field_77994_a = 1;
/* 42 */           p_76293_2_.func_70299_a(p_76293_0_.nextInt(p_76293_2_.func_70302_i_()), itemStack);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void func_150706_a(Random p_150706_0_, WeightedRandomChestContent[] p_150706_1_, TileEntityDispenser p_150706_2_, int p_150706_3_) {
/* 49 */     for (byte b = 0; b < p_150706_3_; b++) {
/* 50 */       WeightedRandomChestContent weightedRandomChestContent = (WeightedRandomChestContent)WeightedRandom.func_76274_a(p_150706_0_, (WeightedRandom.Item[])p_150706_1_);
/* 51 */       int i = weightedRandomChestContent.field_76295_d + p_150706_0_.nextInt(weightedRandomChestContent.field_76296_e - weightedRandomChestContent.field_76295_d + 1);
/*    */       
/* 53 */       if (weightedRandomChestContent.field_76297_b.func_77976_d() >= i) {
/* 54 */         ItemStack itemStack = weightedRandomChestContent.field_76297_b.func_77946_l();
/* 55 */         itemStack.field_77994_a = i;
/* 56 */         p_150706_2_.func_70299_a(p_150706_0_.nextInt(p_150706_2_.func_70302_i_()), itemStack);
/*    */       } else {
/*    */         
/* 59 */         for (byte b1 = 0; b1 < i; b1++) {
/* 60 */           ItemStack itemStack = weightedRandomChestContent.field_76297_b.func_77946_l();
/* 61 */           itemStack.field_77994_a = 1;
/* 62 */           p_150706_2_.func_70299_a(p_150706_0_.nextInt(p_150706_2_.func_70302_i_()), itemStack);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static WeightedRandomChestContent[] func_92080_a(WeightedRandomChestContent[] p_92080_0_, WeightedRandomChestContent... p_92080_1_) {
/* 69 */     WeightedRandomChestContent[] arrayOfWeightedRandomChestContent = new WeightedRandomChestContent[p_92080_0_.length + p_92080_1_.length];
/* 70 */     byte b1 = 0;
/*    */     
/* 72 */     for (byte b2 = 0; b2 < p_92080_0_.length; b2++) {
/* 73 */       arrayOfWeightedRandomChestContent[b1++] = p_92080_0_[b2];
/*    */     }
/*    */     
/* 76 */     for (WeightedRandomChestContent weightedRandomChestContent : p_92080_1_) {
/* 77 */       arrayOfWeightedRandomChestContent[b1++] = weightedRandomChestContent;
/*    */     }
/*    */     
/* 80 */     return arrayOfWeightedRandomChestContent;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\WeightedRandomChestContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */