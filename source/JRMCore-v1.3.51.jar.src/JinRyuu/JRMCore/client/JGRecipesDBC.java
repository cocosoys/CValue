/*     */ package JinRyuu.JRMCore.client;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*     */ import JinRyuu.DragonBC.common.RecipesDBC;
/*     */ import net.minecraft.item.Item;
/*     */ 
/*     */ 
/*     */ public class JGRecipesDBC
/*     */ {
/*     */   public static void registerRecipes(String mod, String category) {
/*  12 */     mod = "Dragon Block C";
/*  13 */     category = "Blocks";
/*  14 */     JGRecipeHandler.addRecipe(mod, category, BlocksDBC.ArtGravDevBlock);
/*  15 */     JGRecipeHandler.addRecipe(mod, category, BlocksDBC.BlockNamekStone); int i;
/*  16 */     for (i = 0; i < BlocksDBC.BlockOWnams.length; ) { JGRecipeHandler.addRecipe(mod, category, BlocksDBC.BlockOW[i]); i++; }
/*  17 */      JGRecipeHandler.addRecipe(mod, category, BlocksDBC.BlockKachin[0]);
/*  18 */     JGRecipeHandler.addRecipe(mod, category, BlocksDBC.BlockKachin[1]);
/*  19 */     JGRecipeHandler.addRecipe(mod, category, BlocksDBC.BlockKachin[2]);
/*     */ 
/*     */     
/*  22 */     category = "Items";
/*  23 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemAlienTechChipTier1);
/*  24 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemChipTier2);
/*  25 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemChipTier3);
/*  26 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemWarenaiFabric);
/*  27 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemStrongFabric);
/*  28 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemKatchin);
/*     */ 
/*     */     
/*  31 */     category = "Armors";
/*     */     
/*  33 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorHelmet00);
/*  34 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorHelmet01);
/*  35 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorHelmet02);
/*  36 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorHelmet03);
/*  37 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorHelmet04);
/*  38 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorHelmet05);
/*  39 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorChest00);
/*  40 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorChest01);
/*  41 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorChest02);
/*  42 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorChest03);
/*  43 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorChest04);
/*  44 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorChest05);
/*  45 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorLegs00);
/*  46 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorLegs01);
/*  47 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorLegs02);
/*  48 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorLegs03);
/*  49 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorLegs04);
/*  50 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorLegs05);
/*  51 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorBoots00);
/*  52 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorBoots01);
/*  53 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorBoots02);
/*  54 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorBoots03);
/*  55 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorBoots04);
/*  56 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.BattleArmorBoots05);
/*     */     
/*  58 */     for (i = 0; i < RecipesDBC.lesz.length; i++) {
/*  59 */       JGRecipeHandler.addRecipe(mod, category, RecipesDBC.lesz[i]);
/*     */     }
/*     */     
/*  62 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.GiFighter3Torso);
/*  63 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.KameTorso1);
/*  64 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.KameBoots1);
/*     */     
/*  66 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.GiFighter1Torso);
/*  67 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.GiFighter1Leg);
/*  68 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.GiFighter1Boots);
/*     */     
/*  70 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.GiNamekTorso);
/*  71 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.GiNamekLeg);
/*  72 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.GiNamekBoots);
/*     */     
/*  74 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.GiFutureTorso);
/*  75 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.GiFutureLeg);
/*  76 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.GiFutureBoots);
/*     */     
/*  78 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.GiFighter2Torso);
/*  79 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.GiFighter2Leg);
/*  80 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.GiFighter2Boots);
/*     */     
/*  82 */     for (i = 0; i < ItemsDBC.ItemBodysuits.length; ) { JGRecipeHandler.addRecipe(mod, category, (Item)ItemsDBC.ItemBodysuits[i]); i++; }
/*     */     
/*  84 */     for (i = 0; i < 3; i++) {
/*  85 */       JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemsOW[i * 4 + 13]);
/*  86 */       JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemsOW[i * 4 + 14]);
/*  87 */       JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemsOW[i * 4 + 15]);
/*  88 */       JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemsOW[i * 4 + 16]);
/*     */     } 
/*     */ 
/*     */     
/*  92 */     category = "Weapons";
/*  93 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemKatana);
/*  94 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemBraveSword);
/*  95 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemZSword);
/*  96 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemKatanaHandle);
/*  97 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemKatanaSwordBlade);
/*  98 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemBraveSwordBlade);
/*  99 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemBraveSwordHandle);
/* 100 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemZSwordBlade);
/* 101 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemZSwordHandle);
/*     */     
/* 103 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemDimensionSword);
/*     */     
/* 105 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemsOW[5]);
/* 106 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemsOW[4]);
/* 107 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemsOW[6]);
/*     */ 
/*     */     
/* 110 */     category = "Tools";
/* 111 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.SpacePod01Item);
/* 112 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemBucketMedLiq);
/* 113 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemDragonRadar);
/* 114 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemsOW[11]);
/* 115 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemsOW[8]);
/* 116 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemsOW[10]);
/* 117 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemsOW[7]);
/* 118 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemsOW[12]);
/* 119 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.ItemsOW[9]);
/*     */ 
/*     */     
/* 122 */     category = "Vanities";
/* 123 */     for (i = 0; i < ItemsDBC.ItemGiBody.length; ) { JGRecipeHandler.addRecipe(mod, category, (Item)ItemsDBC.ItemGiBody[i]); i++; }
/* 124 */      for (i = 0; i < 12; i++) {
/*     */       
/* 126 */       for (int j = 0; j < 4; j++) {
/* 127 */         if (ItemsDBC.ItemsGiType[i].contains("" + j)) {
/*     */           Item item;
/*     */           
/* 130 */           if (j == 0) { item = ItemsDBC.ItemsGi0[i]; }
/* 131 */           else if (j == 1) { item = ItemsDBC.ItemsGi1[i]; }
/* 132 */           else if (j == 2) { item = ItemsDBC.ItemsGi2[i]; }
/* 133 */           else { item = ItemsDBC.ItemsGi3[i]; }
/* 134 */            JGRecipeHandler.addRecipe(mod, category, item);
/*     */         } 
/*     */       } 
/*     */     } 
/* 138 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.Coat);
/* 139 */     JGRecipeHandler.addRecipe(mod, category, ItemsDBC.Coat_2);
/* 140 */     for (i = 0; i < 2; i++) {
/*     */       
/* 142 */       int j = 1;
/* 143 */       if (ItemsDBC.ItemsGiType2[i].contains("" + j)) {
/* 144 */         Item item = ItemsDBC.ItemsGi1_2[i];
/* 145 */         JGRecipeHandler.addRecipe(mod, category, item);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\client\JGRecipesDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */