/*     */ package JinRyuu.DragonBC.common;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import JinRyuu.DragonBC.common.Items.ItemBodyDBC;
/*     */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*     */ import JinRyuu.DragonBC.common.Items.VanityColor;
/*     */ import JinRyuu.DragonBC.common.m.MyRecipes;
/*     */ import JinRyuu.JRMCore.JRMCoreH2;
/*     */ import JinRyuu.JRMCore.items.ItemsJRMC;
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RecipesDBC
/*     */ {
/*  21 */   public static final Item[] lesz = new Item[] { ItemsDBC.BattleArmorHelmet00a, ItemsDBC.BattleArmorHelmet01a, ItemsDBC.BattleArmorHelmet02a, ItemsDBC.BattleArmorHelmet03a, ItemsDBC.BattleArmorHelmet04a, ItemsDBC.BattleArmorHelmet05a, ItemsDBC.BattleArmorHelmet00b, ItemsDBC.BattleArmorHelmet01b, ItemsDBC.BattleArmorHelmet02b, ItemsDBC.BattleArmorHelmet03b, ItemsDBC.BattleArmorHelmet04b, ItemsDBC.BattleArmorHelmet05b };
/*     */   
/*  23 */   public static final Item[] comp = new Item[] { ItemsDBC.BattleArmorHelmet00, ItemsDBC.BattleArmorHelmet01, ItemsDBC.BattleArmorHelmet02, ItemsDBC.BattleArmorHelmet03, ItemsDBC.BattleArmorHelmet04, ItemsDBC.BattleArmorHelmet05, ItemsDBC.BattleArmorHelmet00a, ItemsDBC.BattleArmorHelmet01a, ItemsDBC.BattleArmorHelmet02a, ItemsDBC.BattleArmorHelmet03a, ItemsDBC.BattleArmorHelmet04a, ItemsDBC.BattleArmorHelmet05a };
/*     */   
/*  25 */   public static final Item[] tier = new Item[] { ItemsDBC.ItemChipTier2, ItemsDBC.ItemChipTier3 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void init() {
/*  75 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemKatana, 1), new Object[] { "L", "X", 
/*  76 */           Character.valueOf('X'), ItemsDBC.ItemKatanaHandle, Character.valueOf('L'), ItemsDBC.ItemKatanaSwordBlade });
/*  77 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemBraveSword, 1), new Object[] { "L", "X", 
/*  78 */           Character.valueOf('X'), ItemsDBC.ItemBraveSwordHandle, Character.valueOf('L'), ItemsDBC.ItemBraveSwordBlade });
/*  79 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemZSword, 1), new Object[] { "L", "X", 
/*  80 */           Character.valueOf('X'), ItemsDBC.ItemZSwordHandle, Character.valueOf('L'), ItemsDBC.ItemZSwordBlade });
/*     */     
/*  82 */     int WILDCARD = 32767;
/*     */     
/*  84 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemKatana, 1), new Object[] { new ItemStack(ItemsDBC.ItemKatana, 1, WILDCARD), new ItemStack(Items.field_151042_j, 1, 0) });
/*     */     
/*  86 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemBraveSword, 1), new Object[] { new ItemStack(ItemsDBC.ItemBraveSword, 1, WILDCARD), new ItemStack(ItemsDBC.ItemKatchin, 1, 0), new ItemStack(Items.field_151042_j, 1, 0) });
/*     */     
/*  88 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemZSword, 1), new Object[] { new ItemStack(ItemsDBC.ItemZSword, 1, WILDCARD), new ItemStack(ItemsDBC.ItemKatchin, 1, 0), new ItemStack(ItemsDBC.ItemKatchin, 1, 0) });
/*     */ 
/*     */     
/*  91 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemKatanaHandle, 1), new Object[] { "LXL", 
/*  92 */           Character.valueOf('X'), Items.field_151042_j, Character.valueOf('L'), Items.field_151116_aA });
/*  93 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemBraveSwordHandle, 1), new Object[] { "X X", "LKL", 
/*  94 */           Character.valueOf('X'), Items.field_151042_j, Character.valueOf('L'), Items.field_151116_aA, Character.valueOf('K'), ItemsDBC.ItemKatchin });
/*  95 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemZSwordHandle, 1), new Object[] { "G G", "LKL", 
/*  96 */           Character.valueOf('K'), ItemsDBC.ItemKatchin, Character.valueOf('L'), Items.field_151116_aA, Character.valueOf('G'), Items.field_151043_k });
/*     */     
/*  98 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemKatanaSwordBlade, 1), new Object[] { "XXX", "XXX", " X ", 
/*  99 */           Character.valueOf('X'), Items.field_151042_j });
/* 100 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemBraveSwordBlade, 1), new Object[] { "XKX", 
/* 101 */           Character.valueOf('X'), ItemsDBC.ItemKatanaSwordBlade, Character.valueOf('K'), ItemsDBC.ItemKatchin });
/* 102 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemZSwordBlade, 1), new Object[] { " K ", "XKX", " K ", 
/* 103 */           Character.valueOf('X'), ItemsDBC.ItemBraveSwordBlade, Character.valueOf('K'), ItemsDBC.ItemKatchin });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     Item[] scouters = { ItemsDBC.BattleArmorHelmet00, ItemsDBC.BattleArmorHelmet01, ItemsDBC.BattleArmorHelmet02, ItemsDBC.BattleArmorHelmet03, ItemsDBC.BattleArmorHelmet04, ItemsDBC.BattleArmorHelmet05, ItemsDBC.BattleArmorHelmet00a, ItemsDBC.BattleArmorHelmet01a, ItemsDBC.BattleArmorHelmet02a, ItemsDBC.BattleArmorHelmet03a, ItemsDBC.BattleArmorHelmet04a, ItemsDBC.BattleArmorHelmet05a, ItemsDBC.BattleArmorHelmet00b, ItemsDBC.BattleArmorHelmet01b, ItemsDBC.BattleArmorHelmet02b, ItemsDBC.BattleArmorHelmet03b, ItemsDBC.BattleArmorHelmet04b, ItemsDBC.BattleArmorHelmet05b };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 116 */     Item[] armor = { ItemsDBC.BattleArmorChest00, ItemsDBC.BattleArmorChest01, ItemsDBC.BattleArmorChest02, ItemsDBC.BattleArmorChest03, ItemsDBC.BattleArmorChest04, ItemsDBC.BattleArmorChest05, ItemsDBC.BattleArmorLegs00, ItemsDBC.BattleArmorLegs01, ItemsDBC.BattleArmorLegs02, ItemsDBC.BattleArmorLegs03, ItemsDBC.BattleArmorLegs04, ItemsDBC.BattleArmorLegs05, ItemsDBC.BattleArmorBoots00, ItemsDBC.BattleArmorBoots01, ItemsDBC.BattleArmorBoots02, ItemsDBC.BattleArmorBoots03, ItemsDBC.BattleArmorBoots04, ItemsDBC.BattleArmorBoots05 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 123 */     for (Item item : scouters) {
/* 124 */       GameRegistry.addShapelessRecipe(new ItemStack(item, 1), new Object[] { new ItemStack(item, 1, WILDCARD), new ItemStack(ItemsDBC.ItemWarenai, 1, 0) });
/*     */     } 
/*     */     
/* 127 */     for (Item item : armor) {
/* 128 */       GameRegistry.addShapelessRecipe(new ItemStack(item, 1), new Object[] { new ItemStack(item, 1, WILDCARD), new ItemStack(ItemsDBC.ItemWarenai, 1, 0), new ItemStack(ItemsDBC.ItemWarenai, 1, 0) });
/*     */     } 
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */     
/* 135 */     for (i = 0; i < ItemsDBC.OutfitGis.size(); i++) {
/* 136 */       GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.OutfitGis.get(i), 1), new Object[] { new ItemStack(ItemsDBC.OutfitGis
/* 137 */               .get(i), 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 13), new ItemStack(Blocks.field_150325_L, 1, 14), new ItemStack(Blocks.field_150325_L, 1, 11) });
/* 138 */       GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.OutfitGis.get(i), 1), new Object[] { new ItemStack(ItemsDBC.OutfitGis
/* 139 */               .get(i), 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 2), new ItemStack(Blocks.field_150325_L, 1, 9), new ItemStack(Blocks.field_150325_L, 1, 4) });
/*     */     } 
/*     */     
/* 142 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest00, 1), new Object[] { "X X", "XXX", "XXX", 
/* 143 */           Character.valueOf('X'), ItemsDBC.ItemWarenai });
/*     */     
/* 145 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet00, 1), new Object[] { "YC", "GX", 
/* 146 */           Character.valueOf('X'), ItemsDBC.ItemWarenai, Character.valueOf('G'), Blocks.field_150359_w, Character.valueOf('Y'), new ItemStack(Items.field_151100_aR, 1, 11), Character.valueOf('C'), ItemsDBC.ItemAlienTechChipTier1 });
/* 147 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet01, 1), new Object[] { "RC", "GX", 
/* 148 */           Character.valueOf('X'), ItemsDBC.ItemWarenai, Character.valueOf('G'), Blocks.field_150359_w, Character.valueOf('R'), new ItemStack(Items.field_151100_aR, 1, 1), Character.valueOf('C'), ItemsDBC.ItemAlienTechChipTier1 });
/* 149 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet02, 1), new Object[] { "PC", "GX", 
/* 150 */           Character.valueOf('X'), ItemsDBC.ItemWarenai, Character.valueOf('G'), Blocks.field_150359_w, Character.valueOf('P'), new ItemStack(Items.field_151100_aR, 1, 5), Character.valueOf('C'), ItemsDBC.ItemAlienTechChipTier1 });
/* 151 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet03, 1), new Object[] { "BC", "GX", 
/* 152 */           Character.valueOf('X'), ItemsDBC.ItemWarenai, Character.valueOf('G'), Blocks.field_150359_w, Character.valueOf('B'), new ItemStack(Items.field_151100_aR, 1, 4), Character.valueOf('C'), ItemsDBC.ItemAlienTechChipTier1 });
/* 153 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet04, 1), new Object[] { "gC", "GX", 
/* 154 */           Character.valueOf('X'), ItemsDBC.ItemWarenai, Character.valueOf('G'), Blocks.field_150359_w, Character.valueOf('g'), new ItemStack(Items.field_151100_aR, 1, 2), Character.valueOf('C'), ItemsDBC.ItemAlienTechChipTier1 });
/* 155 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet05, 1), new Object[] { "PC", "GX", 
/* 156 */           Character.valueOf('X'), ItemsDBC.ItemWarenai, Character.valueOf('G'), Blocks.field_150359_w, Character.valueOf('P'), new ItemStack(Items.field_151100_aR, 1, 9), Character.valueOf('C'), ItemsDBC.ItemAlienTechChipTier1 });
/* 157 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest00, 1), new Object[] { "X X", "XXX", "XXX", 
/* 158 */           Character.valueOf('X'), ItemsDBC.ItemWarenai });
/* 159 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest01, 1), new Object[] { "D D", "BXB", "BDB", 
/* 160 */           Character.valueOf('X'), ItemsDBC.BattleArmorChest00, Character.valueOf('B'), new ItemStack(Items.field_151100_aR, 1, 0), Character.valueOf('D'), new ItemStack(Items.field_151100_aR, 1, 12) });
/* 161 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest02, 1), new Object[] { "D D", "BXB", "BDB", 
/* 162 */           Character.valueOf('X'), ItemsDBC.BattleArmorChest00, Character.valueOf('B'), new ItemStack(Items.field_151100_aR, 1, 0), Character.valueOf('D'), new ItemStack(Items.field_151100_aR, 1, 3) });
/* 163 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest03, 1), new Object[] { "D D", " X ", " D ", 
/* 164 */           Character.valueOf('X'), ItemsDBC.BattleArmorChest00, Character.valueOf('D'), new ItemStack(Items.field_151100_aR, 1, 3) });
/* 165 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest04, 1), new Object[] { " D ", "BXB", "BDB", 
/* 166 */           Character.valueOf('X'), ItemsDBC.BattleArmorChest00, Character.valueOf('B'), new ItemStack(Items.field_151100_aR, 1, 0), Character.valueOf('D'), new ItemStack(Items.field_151100_aR, 1, 2) });
/* 167 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest05, 1), new Object[] { " D ", " X ", " D ", 
/* 168 */           Character.valueOf('X'), ItemsDBC.BattleArmorChest00, Character.valueOf('D'), new ItemStack(Items.field_151100_aR, 1, 3) });
/* 169 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs00, 1), new Object[] { "XXX", "X X", "X X", 
/* 170 */           Character.valueOf('X'), ItemsDBC.ItemWarenai });
/* 171 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs01, 1), new Object[] { "D D", "BXB", "B B", 
/* 172 */           Character.valueOf('X'), ItemsDBC.BattleArmorLegs00, Character.valueOf('B'), new ItemStack(Items.field_151100_aR, 1, 0), Character.valueOf('D'), new ItemStack(Items.field_151100_aR, 1, 12) });
/* 173 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs02, 1), new Object[] { "D D", "BXB", "   ", 
/* 174 */           Character.valueOf('X'), ItemsDBC.BattleArmorLegs00, Character.valueOf('B'), new ItemStack(Items.field_151100_aR, 1, 0), Character.valueOf('D'), new ItemStack(Items.field_151100_aR, 1, 3) });
/* 175 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs03, 1), new Object[] { " D ", "BXB", "   ", 
/* 176 */           Character.valueOf('X'), ItemsDBC.BattleArmorLegs00, Character.valueOf('B'), new ItemStack(Items.field_151100_aR, 1, 0), Character.valueOf('D'), new ItemStack(Items.field_151100_aR, 1, 3) });
/* 177 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs04, 1), new Object[] { "D D", "BXB", "B B", 
/* 178 */           Character.valueOf('X'), ItemsDBC.BattleArmorLegs00, Character.valueOf('B'), new ItemStack(Items.field_151100_aR, 1, 0), Character.valueOf('D'), new ItemStack(Items.field_151100_aR, 1, 2) });
/* 179 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs05, 1), new Object[] { "D D", "BXB", "B B", 
/* 180 */           Character.valueOf('X'), ItemsDBC.BattleArmorLegs00, Character.valueOf('B'), new ItemStack(Items.field_151100_aR, 1, 4), Character.valueOf('D'), new ItemStack(Items.field_151100_aR, 1, 3) });
/* 181 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots00, 1), new Object[] { "X X", "X X", 
/* 182 */           Character.valueOf('X'), ItemsDBC.ItemWarenai });
/* 183 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots01, 1), new Object[] { "DXD", "B B", "   ", 
/* 184 */           Character.valueOf('X'), ItemsDBC.BattleArmorBoots00, Character.valueOf('B'), new ItemStack(Items.field_151100_aR, 1, 12), Character.valueOf('D'), new ItemStack(Items.field_151100_aR, 1, 0) });
/* 185 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots02, 1), new Object[] { "DXD", "B B", "   ", 
/* 186 */           Character.valueOf('X'), ItemsDBC.BattleArmorBoots00, Character.valueOf('B'), new ItemStack(Items.field_151100_aR, 1, 3), Character.valueOf('D'), new ItemStack(Items.field_151100_aR, 1, 0) });
/* 187 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots03, 1), new Object[] { " X ", "B B", "   ", 
/* 188 */           Character.valueOf('X'), ItemsDBC.BattleArmorBoots00, Character.valueOf('B'), new ItemStack(Items.field_151100_aR, 1, 3) });
/* 189 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots04, 1), new Object[] { "DXD", "B B", "   ", 
/* 190 */           Character.valueOf('X'), ItemsDBC.BattleArmorBoots00, Character.valueOf('B'), new ItemStack(Items.field_151100_aR, 1, 2), Character.valueOf('D'), new ItemStack(Items.field_151100_aR, 1, 1) });
/* 191 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots05, 1), new Object[] { "DXD", "D D", "   ", 
/* 192 */           Character.valueOf('X'), ItemsDBC.BattleArmorBoots00, Character.valueOf('D'), new ItemStack(Items.field_151100_aR, 1, 15) });
/*     */     
/* 194 */     for (i = 0; i < lesz.length; i++) {
/* 195 */       GameRegistry.addRecipe(new ItemStack(lesz[i], 1), new Object[] { " C ", "CXC", " C ", 
/* 196 */             Character.valueOf('X'), comp[i], Character.valueOf('C'), tier[i / 6] });
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 204 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter3Torso, 1), new Object[] { "R R", "RBR", "BRB", 
/* 205 */           Character.valueOf('R'), new ItemStack(Blocks.field_150325_L, 1, 14), Character.valueOf('B'), new ItemStack(Blocks.field_150325_L, 1, 11) });
/* 206 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.KameTorso1, 1), new Object[] { "R R", "R R", "RRR", 
/* 207 */           Character.valueOf('R'), new ItemStack(Blocks.field_150325_L, 1, 14) });
/* 208 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.KameBoots1, 1), new Object[] { "B B", "Y Y", 
/* 209 */           Character.valueOf('Y'), new ItemStack(Blocks.field_150325_L, 1, 15), Character.valueOf('B'), new ItemStack(Blocks.field_150325_L, 1, 0) });
/*     */ 
/*     */     
/* 212 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter3Torso, 1), new Object[] { new ItemStack(ItemsDBC.GiFighter3Torso, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 14), new ItemStack(Blocks.field_150325_L, 1, 11) });
/*     */     
/* 214 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.KameTorso1, 1), new Object[] { new ItemStack(ItemsDBC.KameTorso1, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 14), new ItemStack(Blocks.field_150325_L, 1, 14) });
/*     */     
/* 216 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.KameBoots1, 1), new Object[] { new ItemStack(ItemsDBC.KameBoots1, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 0) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 232 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter1Torso, 1), new Object[] { "R R", "RBR", "RRR", 
/* 233 */           Character.valueOf('R'), new ItemStack(Blocks.field_150325_L, 1, 14), Character.valueOf('B'), new ItemStack(Blocks.field_150325_L, 1, 11) });
/* 234 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter1Leg, 1), new Object[] { "XXX", "X X", "X X", 
/* 235 */           Character.valueOf('X'), new ItemStack(Blocks.field_150325_L, 1, 14) });
/* 236 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter1Boots, 1), new Object[] { "B B", "Y Y", 
/* 237 */           Character.valueOf('Y'), new ItemStack(Blocks.field_150325_L, 1, 4), Character.valueOf('B'), new ItemStack(Blocks.field_150325_L, 1, 11) });
/*     */     
/* 239 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter1Torso, 1), new Object[] { new ItemStack(ItemsDBC.GiFighter1Torso, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 14), new ItemStack(Blocks.field_150325_L, 1, 11) });
/*     */     
/* 241 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter1Leg, 1), new Object[] { new ItemStack(ItemsDBC.GiFighter1Leg, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 14), new ItemStack(Blocks.field_150325_L, 1, 14) });
/*     */     
/* 243 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter1Boots, 1), new Object[] { new ItemStack(ItemsDBC.GiFighter1Boots, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 4) });
/*     */ 
/*     */     
/* 246 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiNamekTorso, 1), new Object[] { "B B", "BBB", "BBB", 
/* 247 */           Character.valueOf('B'), new ItemStack(Blocks.field_150325_L, 1, 11) });
/* 248 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiNamekLeg, 1), new Object[] { "XXX", "X X", "X X", 
/* 249 */           Character.valueOf('X'), new ItemStack(Blocks.field_150325_L, 1, 11) });
/* 250 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiNamekBoots, 1), new Object[] { "B B", "B B", 
/* 251 */           Character.valueOf('B'), new ItemStack(Blocks.field_150325_L, 1, 12) });
/* 252 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiNamekTorso, 1), new Object[] { new ItemStack(ItemsDBC.GiNamekTorso, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 11), new ItemStack(Blocks.field_150325_L, 1, 11) });
/*     */     
/* 254 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiNamekLeg, 1), new Object[] { new ItemStack(ItemsDBC.GiNamekLeg, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 11), new ItemStack(Blocks.field_150325_L, 1, 11) });
/*     */     
/* 256 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiNamekBoots, 1), new Object[] { new ItemStack(ItemsDBC.GiNamekBoots, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 12) });
/*     */ 
/*     */     
/* 259 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFutureTorso, 1), new Object[] { "B B", "BBB", 
/* 260 */           Character.valueOf('B'), new ItemStack(Blocks.field_150325_L, 1, 11) });
/* 261 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFutureLeg, 1), new Object[] { "XXX", "X X", "X X", 
/* 262 */           Character.valueOf('X'), new ItemStack(Blocks.field_150325_L, 1, 7) });
/* 263 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFutureBoots, 1), new Object[] { "B B", "B B", 
/* 264 */           Character.valueOf('B'), new ItemStack(Blocks.field_150325_L, 1, 4) });
/* 265 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFutureTorso, 1), new Object[] { new ItemStack(ItemsDBC.GiFutureTorso, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 11), new ItemStack(Blocks.field_150325_L, 1, 11) });
/*     */     
/* 267 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFutureLeg, 1), new Object[] { new ItemStack(ItemsDBC.GiFutureLeg, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 7), new ItemStack(Blocks.field_150325_L, 1, 7) });
/*     */     
/* 269 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFutureBoots, 1), new Object[] { new ItemStack(ItemsDBC.GiFutureBoots, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 4) });
/*     */ 
/*     */     
/* 272 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter2Torso, 1), new Object[] { "B B", "BRB", "BBB", 
/* 273 */           Character.valueOf('R'), new ItemStack(Blocks.field_150325_L, 1, 14), Character.valueOf('B'), new ItemStack(Blocks.field_150325_L, 1, 11) });
/* 274 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter2Leg, 1), new Object[] { "BBB", "X X", "X X", 
/* 275 */           Character.valueOf('X'), new ItemStack(Blocks.field_150325_L, 1, 11), Character.valueOf('B'), new ItemStack(Blocks.field_150325_L, 1, 3) });
/* 276 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter2Boots, 1), new Object[] { "Y Y", "Y Y", 
/* 277 */           Character.valueOf('Y'), new ItemStack(Blocks.field_150325_L, 1, 0) });
/* 278 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter2Torso, 1), new Object[] { new ItemStack(ItemsDBC.GiFighter2Torso, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 11), new ItemStack(Blocks.field_150325_L, 1, 11) });
/*     */     
/* 280 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter2Leg, 1), new Object[] { new ItemStack(ItemsDBC.GiFighter2Leg, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 14), new ItemStack(Blocks.field_150325_L, 1, 3) });
/*     */     
/* 282 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter2Boots, 1), new Object[] { new ItemStack(ItemsDBC.GiFighter2Boots, 1, WILDCARD), new ItemStack(Blocks.field_150325_L, 1, 0) });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 287 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.SpacePod01Item, 1), new Object[] { "WWW", "WCW", "WWW", 
/* 288 */           Character.valueOf('C'), ItemsDBC.ItemChipTier2, Character.valueOf('W'), ItemsDBC.ItemWarenai });
/*     */ 
/*     */ 
/*     */     
/* 292 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemAlienTechChipTier1, 3), new Object[] { "GIR", "CCC", "WWW", 
/* 293 */           Character.valueOf('C'), new ItemStack(Items.field_151100_aR, 1, 2), Character.valueOf('G'), Items.field_151043_k, Character.valueOf('I'), Items.field_151042_j, Character.valueOf('R'), Items.field_151137_ax, Character.valueOf('W'), ItemsDBC.ItemWarenai });
/*     */     
/* 295 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemChipTier2, 1), new Object[] { "BGB", "CCC", "GBG", 
/* 296 */           Character.valueOf('C'), ItemsDBC.ItemAlienTechChipTier1, Character.valueOf('B'), new ItemStack(Items.field_151100_aR, 1, 4), Character.valueOf('G'), Items.field_151114_aO });
/* 297 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemChipTier3, 1), new Object[] { "BDB", "CcC", "DBD", 
/* 298 */           Character.valueOf('C'), ItemsDBC.ItemChipTier2, Character.valueOf('c'), ItemsDBC.ItemAlienTechChipTier1, Character.valueOf('B'), new ItemStack(Items.field_151100_aR, 1, 4), Character.valueOf('D'), Items.field_151045_i });
/*     */     
/* 300 */     GameRegistry.addRecipe(new ItemStack(BlocksDBC.ArtGravDevBlock, 1), new Object[] { "IKI", "CCC", "KIK", 
/* 301 */           Character.valueOf('C'), ItemsDBC.ItemChipTier3, Character.valueOf('I'), Items.field_151042_j, Character.valueOf('K'), ItemsDBC.ItemKatchin });
/*     */     
/* 303 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemBucketMedLiq, 1), new Object[] { "CCC", "CBC", "CCC", 
/* 304 */           Character.valueOf('C'), ItemsDBC.ItemMedMoss, Character.valueOf('B'), Items.field_151133_ar });
/*     */ 
/*     */ 
/*     */     
/* 308 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemDragonRadar, 1), new Object[] { "ICI", "CWC", "ICI", 
/* 309 */           Character.valueOf('I'), Items.field_151042_j, Character.valueOf('W'), ItemsDBC.ItemWarenai, Character.valueOf('C'), ItemsDBC.ItemAlienTechChipTier1 });
/* 310 */     GameRegistry.addRecipe(new ItemStack(Blocks.field_150344_f, 2), new Object[] { "X", 
/* 311 */           Character.valueOf('X'), BlocksDBC.BlockNamekLog });
/* 312 */     GameRegistry.addRecipe(new ItemStack(Blocks.field_150347_e, 1), new Object[] { "X", 
/* 313 */           Character.valueOf('X'), BlocksDBC.BlockAlienCobbleStone });
/* 314 */     GameRegistry.addRecipe(new ItemStack(Blocks.field_150348_b, 1), new Object[] { "X", 
/* 315 */           Character.valueOf('X'), BlocksDBC.BlockAlienStone });
/* 316 */     GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockNamekStone, 4), new Object[] { "XX", "XX", 
/* 317 */           Character.valueOf('X'), BlocksDBC.BlockAlienStone });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 369 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[11], 1), new Object[] { "II ", "IS ", " S ", 
/* 370 */           Character.valueOf('I'), ItemsDBC.ItemsOW[2], Character.valueOf('S'), Items.field_151055_y });
/* 371 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[8], 1), new Object[] { "III", " S ", " S ", 
/* 372 */           Character.valueOf('I'), ItemsDBC.ItemsOW[2], Character.valueOf('S'), Items.field_151055_y });
/* 373 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[5], 1), new Object[] { " I ", " I ", " S ", 
/* 374 */           Character.valueOf('I'), ItemsDBC.ItemsOW[2], Character.valueOf('S'), Items.field_151055_y });
/* 375 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[10], 1), new Object[] { "II ", "IS ", " S ", 
/* 376 */           Character.valueOf('I'), ItemsDBC.ItemsOW[1], Character.valueOf('S'), Items.field_151055_y });
/* 377 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[7], 1), new Object[] { "III", " S ", " S ", 
/* 378 */           Character.valueOf('I'), ItemsDBC.ItemsOW[1], Character.valueOf('S'), Items.field_151055_y });
/* 379 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[4], 1), new Object[] { " I ", " I ", " S ", 
/* 380 */           Character.valueOf('I'), ItemsDBC.ItemsOW[1], Character.valueOf('S'), Items.field_151055_y });
/* 381 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[12], 1), new Object[] { "II ", "IS ", " S ", 
/* 382 */           Character.valueOf('I'), ItemsDBC.ItemsOW[0], Character.valueOf('S'), Items.field_151055_y });
/* 383 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[9], 1), new Object[] { "III", " S ", " S ", 
/* 384 */           Character.valueOf('I'), ItemsDBC.ItemsOW[0], Character.valueOf('S'), Items.field_151055_y });
/* 385 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[6], 1), new Object[] { " I ", " I ", " S ", 
/* 386 */           Character.valueOf('I'), ItemsDBC.ItemsOW[0], Character.valueOf('S'), Items.field_151055_y });
/*     */ 
/*     */     
/* 389 */     GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockOW[0], 1), new Object[] { "III", "III", "III", 
/* 390 */           Character.valueOf('I'), ItemsDBC.ItemsOW[3] });
/* 391 */     GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockOW[1], 1), new Object[] { "III", "III", "III", 
/* 392 */           Character.valueOf('I'), ItemsDBC.ItemsOW[1] });
/* 393 */     GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockOW[2], 1), new Object[] { "III", "III", "III", 
/* 394 */           Character.valueOf('I'), ItemsDBC.ItemsOW[0] });
/* 395 */     GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockOW[3], 1), new Object[] { "III", "III", "III", 
/* 396 */           Character.valueOf('I'), ItemsDBC.ItemsOW[2] });
/*     */     
/* 398 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemsOW[3], 9), new Object[] { BlocksDBC.BlockOW[0] });
/*     */     
/* 400 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemsOW[1], 9), new Object[] { BlocksDBC.BlockOW[1] });
/*     */     
/* 402 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemsOW[0], 9), new Object[] { BlocksDBC.BlockOW[2] });
/*     */     
/* 404 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemsOW[2], 9), new Object[] { BlocksDBC.BlockOW[3] });
/*     */ 
/*     */ 
/*     */     
/* 408 */     for (i = 0; i < 3; i++) {
/* 409 */       GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[i * 4 + 13], 1), new Object[] { "XXX", "X X", 
/* 410 */             Character.valueOf('X'), ItemsDBC.ItemsOW[i] });
/* 411 */       GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[i * 4 + 14], 1), new Object[] { "X X", "XXX", "XXX", 
/* 412 */             Character.valueOf('X'), ItemsDBC.ItemsOW[i] });
/* 413 */       GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[i * 4 + 15], 1), new Object[] { "XXX", "X X", "X X", 
/* 414 */             Character.valueOf('X'), ItemsDBC.ItemsOW[i] });
/* 415 */       GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[i * 4 + 16], 1), new Object[] { "X X", "X X", 
/* 416 */             Character.valueOf('X'), ItemsDBC.ItemsOW[i] });
/*     */     } 
/*     */ 
/*     */     
/* 420 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemWarenaiFabric, 4), new Object[] { "WOW", "OWO", "WOW", 
/* 421 */           Character.valueOf('W'), new ItemStack(Blocks.field_150325_L, 1, 0), Character.valueOf('O'), ItemsDBC.ItemWarenai });
/*     */     
/* 423 */     String[] row1 = { "FFF", "WWW", "FFF", "FWF", "FWF", "   ", "   ", "   " };
/* 424 */     String[] row2 = { "FFF", "FFF", "WFW", "FFF", "WFW", "FFF", "WFW", "WFW" };
/* 425 */     String[] row3 = { "W W", "W W", "W W", "W W", "W W", "W W", "W W", "   " };
/* 426 */     for (int j = 0; j < ItemsDBC.ItemBodysuits.length; j++) {
/* 427 */       ItemStack body = new ItemStack((Item)ItemsDBC.ItemBodysuits[j]);
/* 428 */       GameRegistry.addRecipe(body, new Object[] { row1[j], row2[j], row3[j], 
/* 429 */             Character.valueOf('W'), new ItemStack(Blocks.field_150325_L, 1, 0), Character.valueOf('F'), ItemsDBC.ItemWarenaiFabric });
/*     */       
/* 431 */       for (int i1 = 0; i1 < JRMCoreH2.colNams.length; i1++) {
/* 432 */         body = new ItemStack((Item)ItemsDBC.ItemBodysuits[j]);
/* 433 */         ((ItemBodyDBC)body.func_77973_b()).setColor(body, JRMCoreH2.cols[i1]);
/*     */         
/* 435 */         ItemStack dye = new ItemStack(Items.field_151100_aR, 1, i1);
/* 436 */         GameRegistry.addRecipe(((ItemBodyDBC)body.func_77973_b()).setColor(body, JRMCoreH2.cols[i1]), new Object[] { "DDD", "DXD", "DDD", 
/* 437 */               Character.valueOf('X'), ItemsDBC.ItemBodysuits[j], Character.valueOf('D'), dye });
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 445 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemStrongFabric, 4), new Object[] { "WOW", "WOW", "WOW", 
/* 446 */           Character.valueOf('W'), new ItemStack(Blocks.field_150325_L, 1, 0), Character.valueOf('O'), ItemsDBC.ItemWarenai });
/*     */     
/* 448 */     String[] gi_row1 = { "F F", "F F", "F F" };
/* 449 */     String[] gi_row2 = { "FWF", "FWF", " W " };
/* 450 */     String[] gi_row3 = { " F ", "FFF", " F " };
/* 451 */     for (int k = 0; k < ItemsDBC.ItemGiBody.length; k++) {
/* 452 */       ItemStack body = new ItemStack((Item)ItemsDBC.ItemGiBody[k]);
/* 453 */       GameRegistry.addRecipe(body, new Object[] { gi_row1[k], gi_row2[k], gi_row3[k], 
/* 454 */             Character.valueOf('W'), new ItemStack(Blocks.field_150325_L, 1, 0), Character.valueOf('F'), ItemsDBC.ItemStrongFabric });
/*     */       
/* 456 */       for (int i1 = 0; i1 < JRMCoreH2.colNams.length; i1++) {
/* 457 */         body = new ItemStack((Item)ItemsDBC.ItemGiBody[k]);
/* 458 */         ((VanityColor)body.func_77973_b()).setColor(body, JRMCoreH2.cols[i1]);
/* 459 */         ItemStack dye = new ItemStack(Items.field_151100_aR, 1, i1);
/* 460 */         GameRegistry.addRecipe(((VanityColor)body.func_77973_b()).setColor(body, JRMCoreH2.cols[i1]), new Object[] { "DDD", "DXD", "DDD", 
/* 461 */               Character.valueOf('X'), ItemsDBC.ItemGiBody[k], Character.valueOf('D'), dye });
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 475 */     String[] gi_color_Head1 = { "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   " };
/* 476 */     String[] gi_color_Head2 = { "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ", "WFF", "FWF" };
/* 477 */     String[] gi_color_Head3 = { "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   " };
/*     */     
/* 479 */     String[] gi_color_Chest1 = { "W F", "   ", "   ", "   ", "   ", "F F", "FFF", "  F", "   ", "   ", "   ", "  F" };
/* 480 */     String[] gi_color_Chest2 = { "FFF", "   ", "   ", "FFF", " F ", " W ", "FWF", "FWF", "   ", "   ", "F W", "W F" };
/* 481 */     String[] gi_color_Chest3 = { "FFF", "   ", "   ", " F ", " F ", "   ", "FFF", "FFF", "   ", "   ", "F  ", "   " };
/*     */     
/* 483 */     String[] gi_color_Legs1 = { "WFF", "FWF", "   ", "   ", "   ", "   ", "   ", "   " };
/* 484 */     String[] gi_color_Legs2 = { "F F", "F F", "   ", "   ", "   ", "   ", "   ", "   " };
/* 485 */     String[] gi_color_Legs3 = { "F F", "F F", "   ", "   ", "   ", "   ", "   ", "   " };
/*     */     
/* 487 */     String[] gi_color_Boots1 = { "   ", "   ", "   ", "   ", "   ", "   ", "   ", "   " };
/* 488 */     String[] gi_color_Boots2 = { "W F", "   ", "F F", "   ", "   ", "   ", "   ", "   " };
/* 489 */     String[] gi_color_Boots3 = { "F F", "   ", "F F", "   ", "   ", "   ", "   ", "   " };
/* 490 */     int added = 0;
/* 491 */     for (int m = 0; m < 12; m++) {
/* 492 */       for (int i1 = 0; i1 < 4; i1++) {
/* 493 */         if (ItemsDBC.ItemsGiType[m].contains("" + i1)) {
/*     */           ItemStack body;
/*     */           
/* 496 */           if (i1 == 0) { body = new ItemStack(ItemsDBC.ItemsGi0[m]); }
/* 497 */           else if (i1 == 1) { body = new ItemStack(ItemsDBC.ItemsGi1[m]); }
/* 498 */           else if (i1 == 2) { body = new ItemStack(ItemsDBC.ItemsGi2[m]); }
/* 499 */           else { body = new ItemStack(ItemsDBC.ItemsGi3[m]); }
/*     */ 
/*     */           
/* 502 */           if (i1 == 0) { GameRegistry.addRecipe(body, new Object[] { gi_color_Head1[m], gi_color_Head2[m], gi_color_Head3[m], 
/* 503 */                   Character.valueOf('W'), new ItemStack(Blocks.field_150325_L, 1, 0), Character.valueOf('F'), ItemsDBC.ItemStrongFabric }); }
/* 504 */           else if (i1 == 1) { GameRegistry.addRecipe(body, new Object[] { gi_color_Chest1[m], gi_color_Chest2[m], gi_color_Chest3[m], 
/* 505 */                   Character.valueOf('W'), new ItemStack(Blocks.field_150325_L, 1, 0), Character.valueOf('F'), ItemsDBC.ItemStrongFabric }); }
/* 506 */           else if (i1 == 2) { GameRegistry.addRecipe(body, new Object[] { gi_color_Legs1[m], gi_color_Legs2[m], gi_color_Legs3[m], 
/* 507 */                   Character.valueOf('W'), new ItemStack(Blocks.field_150325_L, 1, 0), Character.valueOf('F'), ItemsDBC.ItemStrongFabric }); }
/* 508 */           else { GameRegistry.addRecipe(body, new Object[] { gi_color_Boots1[m], gi_color_Boots2[m], gi_color_Boots3[m], 
/* 509 */                   Character.valueOf('W'), new ItemStack(Blocks.field_150325_L, 1, 0), Character.valueOf('F'), ItemsDBC.ItemStrongFabric }); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 519 */           for (int i2 = 0; i2 < JRMCoreH2.colNams.length; i2++) {
/* 520 */             body = new ItemStack(ItemsDBC.ItemGi.get(added));
/* 521 */             ((VanityColor)body.func_77973_b()).setColor(body, JRMCoreH2.cols[i2]);
/* 522 */             ItemStack dye = new ItemStack(Items.field_151100_aR, 1, i2);
/* 523 */             GameRegistry.addRecipe(((VanityColor)body.func_77973_b()).setColor(body, JRMCoreH2.cols[i2]), new Object[] { "DDD", "DXD", "DDD", 
/* 524 */                   Character.valueOf('X'), ItemsDBC.ItemGi.get(added), Character.valueOf('D'), dye });
/*     */           } 
/* 526 */           added++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 535 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.Coat, 1), new Object[] { "F W", "WWW", "WWW", 
/* 536 */           Character.valueOf('F'), ItemsJRMC.Custom_fabric, Character.valueOf('W'), new ItemStack(Blocks.field_150325_L, 1, 11) });
/* 537 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.Coat_2, 1), new Object[] { "F W", "WWW", "WWW", 
/* 538 */           Character.valueOf('F'), ItemsJRMC.Custom_fabric, Character.valueOf('W'), new ItemStack(Blocks.field_150325_L, 1, 13) });
/*     */     
/* 540 */     added += 2;
/*     */ 
/*     */     
/* 543 */     String[] gi_color_Chest1_1 = { "   ", "   " };
/* 544 */     String[] gi_color_Chest2_1 = { "FFF", "FFF" };
/* 545 */     String[] gi_color_Chest3_1 = { "   ", "FFF" };
/* 546 */     for (int n = 0; n < 2; n++) {
/* 547 */       int i1 = 1;
/* 548 */       if (ItemsDBC.ItemsGiType2[n].contains("" + i1)) {
/*     */ 
/*     */         
/* 551 */         ItemStack body = new ItemStack(ItemsDBC.ItemsGi1_2[n]);
/*     */ 
/*     */         
/* 554 */         GameRegistry.addRecipe(body, new Object[] { gi_color_Chest1_1[n], gi_color_Chest2_1[n], gi_color_Chest3_1[n], 
/*     */               
/* 556 */               Character.valueOf('W'), new ItemStack(Blocks.field_150325_L, 1, 0), 
/* 557 */               Character.valueOf('F'), ItemsDBC.ItemStrongFabric });
/*     */         
/* 559 */         for (int i2 = 0; i2 < JRMCoreH2.colNams.length; i2++) {
/* 560 */           body = new ItemStack(ItemsDBC.ItemGi.get(added));
/* 561 */           ((VanityColor)body.func_77973_b()).setColor(body, JRMCoreH2.cols[i2]);
/* 562 */           ItemStack dye = new ItemStack(Items.field_151100_aR, 1, i2);
/* 563 */           GameRegistry.addRecipe(((VanityColor)body.func_77973_b()).setColor(body, JRMCoreH2.cols[i2]), new Object[] { "DDD", "DXD", "DDD", 
/* 564 */                 Character.valueOf('X'), ItemsDBC.ItemGi.get(added), Character.valueOf('D'), dye });
/*     */         } 
/* 566 */         added++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 598 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemDimensionSword, 1), new Object[] { "AAA", "ABA", "AAA", 
/* 599 */           Character.valueOf('A'), ItemsDBC.ItemJanembaEssence, Character.valueOf('B'), ItemsDBC.ItemSmallClub });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 604 */     GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockKachin[0], 1), new Object[] { "AAA", "AAA", "AAA", 
/* 605 */           Character.valueOf('A'), ItemsDBC.ItemKatchin });
/* 606 */     GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemKatchin, 9), new Object[] { "AAA", "AAA", "AAA", 
/* 607 */           Character.valueOf('A'), BlocksDBC.BlockKachin[0] });
/*     */     
/* 609 */     GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemKatchin, 9), new Object[] { new ItemStack(BlocksDBC.BlockKachin[0], 1, WILDCARD) });
/*     */ 
/*     */     
/* 612 */     GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockKachin[1], 4), new Object[] { "AA", "AA", 
/* 613 */           Character.valueOf('A'), BlocksDBC.BlockKachin[0] });
/* 614 */     GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockKachin[2], 4), new Object[] { "AA", "AA", 
/* 615 */           Character.valueOf('A'), BlocksDBC.BlockKachin[1] });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 623 */     GameRegistry.addSmelting(BlocksDBC.BlockDragonBallStone, new ItemStack(BlocksDBC.BlockDragonBall, 1), 0.1F);
/* 624 */     GameRegistry.addSmelting(BlocksDBC.BlockOreWrenai, new ItemStack(ItemsDBC.ItemWarenai, 1), 0.7F);
/* 625 */     GameRegistry.addSmelting(BlocksDBC.BlockAlienCobbleStone, new ItemStack(BlocksDBC.BlockAlienStone, 1), 0.1F);
/*     */     
/* 627 */     GameRegistry.addSmelting(Items.field_151102_aT, new ItemStack(Items.field_151100_aR, 1, 3), 0.2F);
/* 628 */     GameRegistry.addSmelting(ItemsDBC.ItemDinoMeat, new ItemStack(ItemsDBC.ItemDinoMeatCooked), 0.5F);
/* 629 */     GameRegistry.addSmelting(ItemsDBC.ItemDinoMeatBig, new ItemStack(ItemsDBC.ItemDinoMeatCookedBig), 0.5F);
/*     */     
/* 631 */     GameRegistry.addSmelting(BlocksDBC.BlockOreLehnori, new ItemStack(ItemsDBC.ItemsOW[0]), 0.7F);
/* 632 */     GameRegistry.addSmelting(BlocksDBC.BlockOreDlog, new ItemStack(ItemsDBC.ItemsOW[1]), 1.0F);
/* 633 */     GameRegistry.addSmelting(BlocksDBC.BlockOreDnomaid, new ItemStack(ItemsDBC.ItemsOW[2]), 1.0F);
/*     */ 
/*     */ 
/*     */     
/* 637 */     MyRecipes.init();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\RecipesDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */