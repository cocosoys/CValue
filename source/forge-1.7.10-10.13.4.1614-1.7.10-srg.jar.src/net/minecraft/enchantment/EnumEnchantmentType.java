/*    */ package net.minecraft.enchantment;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemArmor;
/*    */ 
/*    */ public enum EnumEnchantmentType {
/*  6 */   all,
/*    */   
/*  8 */   armor,
/*  9 */   armor_feet,
/* 10 */   armor_legs,
/* 11 */   armor_torso,
/* 12 */   armor_head,
/*    */   
/* 14 */   weapon,
/* 15 */   digger,
/* 16 */   fishing_rod,
/* 17 */   breakable,
/* 18 */   bow; private static final String __OBFID = "CL_00000106";
/*    */   
/*    */   public boolean func_77557_a(Item p_77557_1_) {
/* 21 */     if (this == all) return true; 
/* 22 */     if (this == breakable && p_77557_1_.func_77645_m()) return true;
/*    */     
/* 24 */     if (p_77557_1_ instanceof ItemArmor) {
/* 25 */       if (this == armor) return true; 
/* 26 */       ItemArmor itemArmor = (ItemArmor)p_77557_1_;
/* 27 */       if (itemArmor.field_77881_a == 0) return (this == armor_head); 
/* 28 */       if (itemArmor.field_77881_a == 2) return (this == armor_legs); 
/* 29 */       if (itemArmor.field_77881_a == 1) return (this == armor_torso); 
/* 30 */       if (itemArmor.field_77881_a == 3) return (this == armor_feet); 
/* 31 */       return false;
/* 32 */     }  if (p_77557_1_ instanceof net.minecraft.item.ItemSword)
/* 33 */       return (this == weapon); 
/* 34 */     if (p_77557_1_ instanceof net.minecraft.item.ItemTool)
/* 35 */       return (this == digger); 
/* 36 */     if (p_77557_1_ instanceof net.minecraft.item.ItemBow)
/* 37 */       return (this == bow); 
/* 38 */     if (p_77557_1_ instanceof net.minecraft.item.ItemFishingRod) {
/* 39 */       return (this == fishing_rod);
/*    */     }
/* 41 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\enchantment\EnumEnchantmentType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */