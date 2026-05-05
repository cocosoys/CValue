/*     */ package net.minecraft.item.crafting;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.ItemDye;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class RecipeFireworks implements IRecipe {
/*     */   private ItemStack field_92102_a;
/*     */   
/*     */   public boolean func_77569_a(InventoryCrafting p_77569_1_, World p_77569_2_) {
/*  17 */     this.field_92102_a = null;
/*     */     
/*  19 */     byte b1 = 0;
/*  20 */     byte b2 = 0;
/*  21 */     byte b3 = 0;
/*  22 */     byte b4 = 0;
/*  23 */     int i = 0;
/*  24 */     byte b5 = 0;
/*     */     
/*  26 */     for (byte b6 = 0; b6 < p_77569_1_.func_70302_i_(); b6++) {
/*  27 */       ItemStack itemStack = p_77569_1_.func_70301_a(b6);
/*  28 */       if (itemStack != null)
/*     */       {
/*  30 */         if (itemStack.func_77973_b() == Items.field_151016_H) {
/*  31 */           b2++;
/*  32 */         } else if (itemStack.func_77973_b() == Items.field_151154_bQ) {
/*  33 */           b4++;
/*  34 */         } else if (itemStack.func_77973_b() == Items.field_151100_aR) {
/*  35 */           b3++;
/*  36 */         } else if (itemStack.func_77973_b() == Items.field_151121_aF) {
/*  37 */           b1++;
/*  38 */         } else if (itemStack.func_77973_b() == Items.field_151114_aO) {
/*     */           
/*  40 */           i++;
/*  41 */         } else if (itemStack.func_77973_b() == Items.field_151045_i) {
/*     */           
/*  43 */           i++;
/*  44 */         } else if (itemStack.func_77973_b() == Items.field_151059_bz) {
/*     */           
/*  46 */           b5++;
/*  47 */         } else if (itemStack.func_77973_b() == Items.field_151008_G) {
/*     */           
/*  49 */           b5++;
/*  50 */         } else if (itemStack.func_77973_b() == Items.field_151074_bl) {
/*     */           
/*  52 */           b5++;
/*  53 */         } else if (itemStack.func_77973_b() == Items.field_151144_bL) {
/*     */           
/*  55 */           b5++;
/*     */         } else {
/*  57 */           return false;
/*     */         }  } 
/*     */     } 
/*  60 */     i += b3 + b5;
/*     */     
/*  62 */     if (b2 > 3 || b1 > 1) {
/*  63 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  67 */     if (b2 >= 1 && b1 == 1 && i == 0) {
/*     */       
/*  69 */       this.field_92102_a = new ItemStack(Items.field_151152_bP);
/*  70 */       if (b4 > 0) {
/*  71 */         NBTTagCompound nBTTagCompound1 = new NBTTagCompound();
/*  72 */         NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
/*  73 */         NBTTagList nBTTagList = new NBTTagList();
/*     */         
/*  75 */         for (byte b = 0; b < p_77569_1_.func_70302_i_(); b++) {
/*  76 */           ItemStack itemStack = p_77569_1_.func_70301_a(b);
/*  77 */           if (itemStack != null && itemStack.func_77973_b() == Items.field_151154_bQ)
/*     */           {
/*  79 */             if (itemStack.func_77942_o() && itemStack.func_77978_p().func_150297_b("Explosion", 10)) {
/*  80 */               nBTTagList.func_74742_a((NBTBase)itemStack.func_77978_p().func_74775_l("Explosion"));
/*     */             }
/*     */           }
/*     */         } 
/*  84 */         nBTTagCompound2.func_74782_a("Explosions", (NBTBase)nBTTagList);
/*  85 */         nBTTagCompound2.func_74774_a("Flight", (byte)b2);
/*  86 */         nBTTagCompound1.func_74782_a("Fireworks", (NBTBase)nBTTagCompound2);
/*  87 */         this.field_92102_a.func_77982_d(nBTTagCompound1);
/*     */       } 
/*  89 */       return true;
/*     */     } 
/*     */     
/*  92 */     if (b2 == 1 && b1 == 0 && b4 == 0 && b3 > 0 && b5 <= 1) {
/*     */       
/*  94 */       this.field_92102_a = new ItemStack(Items.field_151154_bQ);
/*  95 */       NBTTagCompound nBTTagCompound1 = new NBTTagCompound();
/*  96 */       NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
/*     */       
/*  98 */       byte b7 = 0;
/*     */       
/* 100 */       ArrayList<Integer> arrayList = new ArrayList();
/* 101 */       for (byte b8 = 0; b8 < p_77569_1_.func_70302_i_(); b8++) {
/* 102 */         ItemStack itemStack = p_77569_1_.func_70301_a(b8);
/* 103 */         if (itemStack != null)
/*     */         {
/* 105 */           if (itemStack.func_77973_b() == Items.field_151100_aR) {
/* 106 */             arrayList.add(Integer.valueOf(ItemDye.field_150922_c[itemStack.func_77960_j()]));
/* 107 */           } else if (itemStack.func_77973_b() == Items.field_151114_aO) {
/*     */             
/* 109 */             nBTTagCompound2.func_74757_a("Flicker", true);
/* 110 */           } else if (itemStack.func_77973_b() == Items.field_151045_i) {
/*     */             
/* 112 */             nBTTagCompound2.func_74757_a("Trail", true);
/* 113 */           } else if (itemStack.func_77973_b() == Items.field_151059_bz) {
/* 114 */             b7 = 1;
/* 115 */           } else if (itemStack.func_77973_b() == Items.field_151008_G) {
/* 116 */             b7 = 4;
/* 117 */           } else if (itemStack.func_77973_b() == Items.field_151074_bl) {
/* 118 */             b7 = 2;
/* 119 */           } else if (itemStack.func_77973_b() == Items.field_151144_bL) {
/* 120 */             b7 = 3;
/*     */           }  } 
/*     */       } 
/* 123 */       int[] arrayOfInt = new int[arrayList.size()];
/* 124 */       for (byte b9 = 0; b9 < arrayOfInt.length; b9++) {
/* 125 */         arrayOfInt[b9] = ((Integer)arrayList.get(b9)).intValue();
/*     */       }
/* 127 */       nBTTagCompound2.func_74783_a("Colors", arrayOfInt);
/* 128 */       nBTTagCompound2.func_74774_a("Type", b7);
/* 129 */       nBTTagCompound1.func_74782_a("Explosion", (NBTBase)nBTTagCompound2);
/* 130 */       this.field_92102_a.func_77982_d(nBTTagCompound1);
/* 131 */       return true;
/*     */     } 
/*     */     
/* 134 */     if (b2 == 0 && b1 == 0 && b4 == 1 && b3 > 0 && b3 == i) {
/*     */       
/* 136 */       ArrayList<Integer> arrayList = new ArrayList();
/* 137 */       for (byte b7 = 0; b7 < p_77569_1_.func_70302_i_(); b7++) {
/* 138 */         ItemStack itemStack = p_77569_1_.func_70301_a(b7);
/* 139 */         if (itemStack != null)
/*     */         {
/* 141 */           if (itemStack.func_77973_b() == Items.field_151100_aR) {
/* 142 */             arrayList.add(Integer.valueOf(ItemDye.field_150922_c[itemStack.func_77960_j()]));
/* 143 */           } else if (itemStack.func_77973_b() == Items.field_151154_bQ) {
/* 144 */             this.field_92102_a = itemStack.func_77946_l();
/* 145 */             this.field_92102_a.field_77994_a = 1;
/*     */           }  } 
/*     */       } 
/* 148 */       int[] arrayOfInt = new int[arrayList.size()];
/* 149 */       for (byte b8 = 0; b8 < arrayOfInt.length; b8++) {
/* 150 */         arrayOfInt[b8] = ((Integer)arrayList.get(b8)).intValue();
/*     */       }
/* 152 */       if (this.field_92102_a != null && this.field_92102_a.func_77942_o()) {
/* 153 */         NBTTagCompound nBTTagCompound = this.field_92102_a.func_77978_p().func_74775_l("Explosion");
/* 154 */         if (nBTTagCompound == null) {
/* 155 */           return false;
/*     */         }
/* 157 */         nBTTagCompound.func_74783_a("FadeColors", arrayOfInt);
/*     */       } else {
/* 159 */         return false;
/*     */       } 
/* 161 */       return true;
/*     */     } 
/*     */     
/* 164 */     return false;
/*     */   }
/*     */   
/*     */   private static final String __OBFID = "CL_00000083";
/*     */   
/*     */   public ItemStack func_77572_b(InventoryCrafting p_77572_1_) {
/* 170 */     return this.field_92102_a.func_77946_l();
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_77570_a() {
/* 175 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_77571_b() {
/* 180 */     return this.field_92102_a;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\crafting\RecipeFireworks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */