/*     */ package net.minecraft.item.crafting;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.block.BlockColored;
/*     */ import net.minecraft.entity.passive.EntitySheep;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class RecipesArmorDyes implements IRecipe {
/*     */   public boolean func_77569_a(InventoryCrafting p_77569_1_, World p_77569_2_) {
/*  14 */     ItemStack itemStack = null;
/*  15 */     ArrayList<ItemStack> arrayList = new ArrayList();
/*     */     
/*  17 */     for (byte b = 0; b < p_77569_1_.func_70302_i_(); b++) {
/*  18 */       ItemStack itemStack1 = p_77569_1_.func_70301_a(b);
/*  19 */       if (itemStack1 != null)
/*     */       {
/*  21 */         if (itemStack1.func_77973_b() instanceof ItemArmor) {
/*  22 */           ItemArmor itemArmor = (ItemArmor)itemStack1.func_77973_b();
/*     */           
/*  24 */           if (itemArmor.func_82812_d() == ItemArmor.ArmorMaterial.CLOTH && itemStack == null) {
/*  25 */             itemStack = itemStack1;
/*     */           } else {
/*  27 */             return false;
/*     */           } 
/*  29 */         } else if (itemStack1.func_77973_b() == Items.field_151100_aR) {
/*  30 */           arrayList.add(itemStack1);
/*     */         } else {
/*  32 */           return false;
/*     */         } 
/*     */       }
/*     */     } 
/*  36 */     return (itemStack != null && !arrayList.isEmpty());
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_77572_b(InventoryCrafting p_77572_1_) {
/*  41 */     ItemStack itemStack = null;
/*  42 */     int[] arrayOfInt = new int[3];
/*  43 */     int i = 0;
/*  44 */     byte b = 0;
/*  45 */     ItemArmor itemArmor = null;
/*     */     int j;
/*  47 */     for (j = 0; j < p_77572_1_.func_70302_i_(); j++) {
/*  48 */       ItemStack itemStack1 = p_77572_1_.func_70301_a(j);
/*  49 */       if (itemStack1 != null)
/*     */       {
/*  51 */         if (itemStack1.func_77973_b() instanceof ItemArmor) {
/*  52 */           itemArmor = (ItemArmor)itemStack1.func_77973_b();
/*     */           
/*  54 */           if (itemArmor.func_82812_d() == ItemArmor.ArmorMaterial.CLOTH && itemStack == null) {
/*  55 */             itemStack = itemStack1.func_77946_l();
/*  56 */             itemStack.field_77994_a = 1;
/*     */             
/*  58 */             if (itemArmor.func_82816_b_(itemStack1)) {
/*  59 */               int i1 = itemArmor.func_82814_b(itemStack);
/*  60 */               float f3 = (i1 >> 16 & 0xFF) / 255.0F;
/*  61 */               float f4 = (i1 >> 8 & 0xFF) / 255.0F;
/*  62 */               float f5 = (i1 & 0xFF) / 255.0F;
/*     */               
/*  64 */               i = (int)(i + Math.max(f3, Math.max(f4, f5)) * 255.0F);
/*     */               
/*  66 */               arrayOfInt[0] = (int)(arrayOfInt[0] + f3 * 255.0F);
/*  67 */               arrayOfInt[1] = (int)(arrayOfInt[1] + f4 * 255.0F);
/*  68 */               arrayOfInt[2] = (int)(arrayOfInt[2] + f5 * 255.0F);
/*  69 */               b++;
/*     */             } 
/*     */           } else {
/*  72 */             return null;
/*     */           } 
/*  74 */         } else if (itemStack1.func_77973_b() == Items.field_151100_aR) {
/*  75 */           float[] arrayOfFloat = EntitySheep.field_70898_d[BlockColored.func_150032_b(itemStack1.func_77960_j())];
/*  76 */           int i1 = (int)(arrayOfFloat[0] * 255.0F);
/*  77 */           int i2 = (int)(arrayOfFloat[1] * 255.0F);
/*  78 */           int i3 = (int)(arrayOfFloat[2] * 255.0F);
/*     */           
/*  80 */           i += Math.max(i1, Math.max(i2, i3));
/*     */           
/*  82 */           arrayOfInt[0] = arrayOfInt[0] + i1;
/*  83 */           arrayOfInt[1] = arrayOfInt[1] + i2;
/*  84 */           arrayOfInt[2] = arrayOfInt[2] + i3;
/*  85 */           b++;
/*     */         } else {
/*  87 */           return null;
/*     */         } 
/*     */       }
/*     */     } 
/*  91 */     if (itemArmor == null) return null;
/*     */     
/*  93 */     j = arrayOfInt[0] / b;
/*  94 */     int k = arrayOfInt[1] / b;
/*  95 */     int m = arrayOfInt[2] / b;
/*     */     
/*  97 */     float f1 = i / b;
/*  98 */     float f2 = Math.max(j, Math.max(k, m));
/*     */     
/* 100 */     j = (int)(j * f1 / f2);
/* 101 */     k = (int)(k * f1 / f2);
/* 102 */     m = (int)(m * f1 / f2);
/*     */     
/* 104 */     int n = j;
/* 105 */     n = (n << 8) + k;
/* 106 */     n = (n << 8) + m;
/*     */     
/* 108 */     itemArmor.func_82813_b(itemStack, n);
/* 109 */     return itemStack;
/*     */   }
/*     */   private static final String __OBFID = "CL_00000079";
/*     */   
/*     */   public int func_77570_a() {
/* 114 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_77571_b() {
/* 119 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\crafting\RecipesArmorDyes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */