/*     */ package net.minecraft.item.crafting;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class CraftingManager {
/*  14 */   private static final CraftingManager field_77598_a = new CraftingManager();
/*  15 */   private List field_77597_b = new ArrayList(); private static final String __OBFID = "CL_00000090";
/*     */   
/*     */   public static final CraftingManager func_77594_a() {
/*  18 */     return field_77598_a;
/*     */   }
/*     */   
/*     */   private CraftingManager() {
/*  22 */     (new RecipesTools()).func_77586_a(this);
/*  23 */     (new RecipesWeapons()).func_77583_a(this);
/*  24 */     (new RecipesIngots()).func_77590_a(this);
/*  25 */     (new RecipesFood()).func_77608_a(this);
/*  26 */     (new RecipesCrafting()).func_77589_a(this);
/*  27 */     (new RecipesArmor()).func_77609_a(this);
/*  28 */     (new RecipesDyes()).func_77607_a(this);
/*  29 */     this.field_77597_b.add(new RecipesArmorDyes());
/*  30 */     this.field_77597_b.add(new RecipeBookCloning());
/*  31 */     this.field_77597_b.add(new RecipesMapCloning());
/*  32 */     this.field_77597_b.add(new RecipesMapExtending());
/*  33 */     this.field_77597_b.add(new RecipeFireworks());
/*     */     
/*  35 */     func_92103_a(new ItemStack(Items.field_151121_aF, 3), new Object[] { "###", Character.valueOf('#'), Items.field_151120_aE });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  40 */     func_77596_b(new ItemStack(Items.field_151122_aG, 1), new Object[] { Items.field_151121_aF, Items.field_151121_aF, Items.field_151121_aF, Items.field_151116_aA });
/*     */ 
/*     */     
/*  43 */     func_77596_b(new ItemStack(Items.field_151099_bA, 1), new Object[] { Items.field_151122_aG, new ItemStack(Items.field_151100_aR, 1, 0), Items.field_151008_G });
/*     */ 
/*     */     
/*  46 */     func_92103_a(new ItemStack(Blocks.field_150422_aJ, 2), new Object[] { "###", "###", Character.valueOf('#'), Items.field_151055_y });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  52 */     func_92103_a(new ItemStack(Blocks.field_150463_bK, 6, 0), new Object[] { "###", "###", Character.valueOf('#'), Blocks.field_150347_e });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  58 */     func_92103_a(new ItemStack(Blocks.field_150463_bK, 6, 1), new Object[] { "###", "###", Character.valueOf('#'), Blocks.field_150341_Y });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  64 */     func_92103_a(new ItemStack(Blocks.field_150386_bk, 6), new Object[] { "###", "###", Character.valueOf('#'), Blocks.field_150385_bj });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     func_92103_a(new ItemStack(Blocks.field_150396_be, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), Items.field_151055_y, Character.valueOf('W'), Blocks.field_150344_f });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     func_92103_a(new ItemStack(Blocks.field_150421_aI, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Blocks.field_150344_f, Character.valueOf('X'), Items.field_151045_i });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  83 */     func_92103_a(new ItemStack(Items.field_151058_ca, 2), new Object[] { "~~ ", "~O ", "  ~", Character.valueOf('~'), Items.field_151007_F, Character.valueOf('O'), Items.field_151123_aH });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     func_92103_a(new ItemStack(Blocks.field_150323_B, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Blocks.field_150344_f, Character.valueOf('X'), Items.field_151137_ax });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     func_92103_a(new ItemStack(Blocks.field_150342_X, 1), new Object[] { "###", "XXX", "###", Character.valueOf('#'), Blocks.field_150344_f, Character.valueOf('X'), Items.field_151122_aG });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     func_92103_a(new ItemStack(Blocks.field_150433_aE, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.field_151126_ay });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     func_92103_a(new ItemStack(Blocks.field_150431_aC, 6), new Object[] { "###", Character.valueOf('#'), Blocks.field_150433_aE });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     func_92103_a(new ItemStack(Blocks.field_150435_aG, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.field_151119_aD });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     func_92103_a(new ItemStack(Blocks.field_150336_V, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.field_151118_aC });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     func_92103_a(new ItemStack(Blocks.field_150426_aN, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.field_151114_aO });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     func_92103_a(new ItemStack(Blocks.field_150371_ca, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.field_151128_bU });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 139 */     func_92103_a(new ItemStack(Blocks.field_150325_L, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.field_151007_F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     func_92103_a(new ItemStack(Blocks.field_150335_W, 1), new Object[] { "X#X", "#X#", "X#X", Character.valueOf('X'), Items.field_151016_H, Character.valueOf('#'), Blocks.field_150354_m });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 153 */     func_92103_a(new ItemStack((Block)Blocks.field_150333_U, 6, 3), new Object[] { "###", Character.valueOf('#'), Blocks.field_150347_e });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 158 */     func_92103_a(new ItemStack((Block)Blocks.field_150333_U, 6, 0), new Object[] { "###", Character.valueOf('#'), Blocks.field_150348_b });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     func_92103_a(new ItemStack((Block)Blocks.field_150333_U, 6, 1), new Object[] { "###", Character.valueOf('#'), Blocks.field_150322_A });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 169 */     func_92103_a(new ItemStack((Block)Blocks.field_150333_U, 6, 4), new Object[] { "###", Character.valueOf('#'), Blocks.field_150336_V });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     func_92103_a(new ItemStack((Block)Blocks.field_150333_U, 6, 5), new Object[] { "###", Character.valueOf('#'), Blocks.field_150417_aV });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 179 */     func_92103_a(new ItemStack((Block)Blocks.field_150333_U, 6, 6), new Object[] { "###", Character.valueOf('#'), Blocks.field_150385_bj });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 184 */     func_92103_a(new ItemStack((Block)Blocks.field_150333_U, 6, 7), new Object[] { "###", Character.valueOf('#'), Blocks.field_150371_ca });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     func_92103_a(new ItemStack((Block)Blocks.field_150376_bx, 6, 0), new Object[] { "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 0) });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     func_92103_a(new ItemStack((Block)Blocks.field_150376_bx, 6, 2), new Object[] { "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 2) });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 199 */     func_92103_a(new ItemStack((Block)Blocks.field_150376_bx, 6, 1), new Object[] { "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 1) });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 204 */     func_92103_a(new ItemStack((Block)Blocks.field_150376_bx, 6, 3), new Object[] { "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 3) });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 209 */     func_92103_a(new ItemStack((Block)Blocks.field_150376_bx, 6, 4), new Object[] { "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 4) });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 214 */     func_92103_a(new ItemStack((Block)Blocks.field_150376_bx, 6, 5), new Object[] { "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 5) });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 219 */     func_92103_a(new ItemStack(Blocks.field_150468_ap, 3), new Object[] { "# #", "###", "# #", Character.valueOf('#'), Items.field_151055_y });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 226 */     func_92103_a(new ItemStack(Items.field_151135_aq, 1), new Object[] { "##", "##", "##", Character.valueOf('#'), Blocks.field_150344_f });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 233 */     func_92103_a(new ItemStack(Blocks.field_150415_aT, 2), new Object[] { "###", "###", Character.valueOf('#'), Blocks.field_150344_f });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 239 */     func_92103_a(new ItemStack(Items.field_151139_aw, 1), new Object[] { "##", "##", "##", Character.valueOf('#'), Items.field_151042_j });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 246 */     func_92103_a(new ItemStack(Items.field_151155_ap, 3), new Object[] { "###", "###", " X ", Character.valueOf('#'), Blocks.field_150344_f, Character.valueOf('X'), Items.field_151055_y });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 253 */     func_92103_a(new ItemStack(Items.field_151105_aU, 1), new Object[] { "AAA", "BEB", "CCC", Character.valueOf('A'), Items.field_151117_aB, Character.valueOf('B'), Items.field_151102_aT, Character.valueOf('C'), Items.field_151015_O, Character.valueOf('E'), Items.field_151110_aK });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 262 */     func_92103_a(new ItemStack(Items.field_151102_aT, 1), new Object[] { "#", Character.valueOf('#'), Items.field_151120_aE });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 267 */     func_92103_a(new ItemStack(Blocks.field_150344_f, 4, 0), new Object[] { "#", Character.valueOf('#'), new ItemStack(Blocks.field_150364_r, 1, 0) });
/*     */ 
/*     */ 
/*     */     
/* 271 */     func_92103_a(new ItemStack(Blocks.field_150344_f, 4, 1), new Object[] { "#", Character.valueOf('#'), new ItemStack(Blocks.field_150364_r, 1, 1) });
/*     */ 
/*     */ 
/*     */     
/* 275 */     func_92103_a(new ItemStack(Blocks.field_150344_f, 4, 2), new Object[] { "#", Character.valueOf('#'), new ItemStack(Blocks.field_150364_r, 1, 2) });
/*     */ 
/*     */ 
/*     */     
/* 279 */     func_92103_a(new ItemStack(Blocks.field_150344_f, 4, 3), new Object[] { "#", Character.valueOf('#'), new ItemStack(Blocks.field_150364_r, 1, 3) });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 284 */     func_92103_a(new ItemStack(Blocks.field_150344_f, 4, 4), new Object[] { "#", Character.valueOf('#'), new ItemStack(Blocks.field_150363_s, 1, 0) });
/*     */ 
/*     */ 
/*     */     
/* 288 */     func_92103_a(new ItemStack(Blocks.field_150344_f, 4, 5), new Object[] { "#", Character.valueOf('#'), new ItemStack(Blocks.field_150363_s, 1, 1) });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 293 */     func_92103_a(new ItemStack(Items.field_151055_y, 4), new Object[] { "#", "#", Character.valueOf('#'), Blocks.field_150344_f });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 299 */     func_92103_a(new ItemStack(Blocks.field_150478_aa, 4), new Object[] { "X", "#", Character.valueOf('X'), Items.field_151044_h, Character.valueOf('#'), Items.field_151055_y });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 306 */     func_92103_a(new ItemStack(Blocks.field_150478_aa, 4), new Object[] { "X", "#", Character.valueOf('X'), new ItemStack(Items.field_151044_h, 1, 1), Character.valueOf('#'), Items.field_151055_y });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 313 */     func_92103_a(new ItemStack(Items.field_151054_z, 4), new Object[] { "# #", " # ", Character.valueOf('#'), Blocks.field_150344_f });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 319 */     func_92103_a(new ItemStack(Items.field_151069_bo, 3), new Object[] { "# #", " # ", Character.valueOf('#'), Blocks.field_150359_w });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 325 */     func_92103_a(new ItemStack(Blocks.field_150448_aq, 16), new Object[] { "X X", "X#X", "X X", Character.valueOf('X'), Items.field_151042_j, Character.valueOf('#'), Items.field_151055_y });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 333 */     func_92103_a(new ItemStack(Blocks.field_150318_D, 6), new Object[] { "X X", "X#X", "XRX", Character.valueOf('X'), Items.field_151043_k, Character.valueOf('R'), Items.field_151137_ax, Character.valueOf('#'), Items.field_151055_y });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 342 */     func_92103_a(new ItemStack(Blocks.field_150408_cc, 6), new Object[] { "XSX", "X#X", "XSX", Character.valueOf('X'), Items.field_151042_j, Character.valueOf('#'), Blocks.field_150429_aA, Character.valueOf('S'), Items.field_151055_y });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 351 */     func_92103_a(new ItemStack(Blocks.field_150319_E, 6), new Object[] { "X X", "X#X", "XRX", Character.valueOf('X'), Items.field_151042_j, Character.valueOf('R'), Items.field_151137_ax, Character.valueOf('#'), Blocks.field_150456_au });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 360 */     func_92103_a(new ItemStack(Items.field_151143_au, 1), new Object[] { "# #", "###", Character.valueOf('#'), Items.field_151042_j });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 366 */     func_92103_a(new ItemStack(Items.field_151066_bu, 1), new Object[] { "# #", "# #", "###", Character.valueOf('#'), Items.field_151042_j });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 373 */     func_92103_a(new ItemStack(Items.field_151067_bt, 1), new Object[] { " B ", "###", Character.valueOf('#'), Blocks.field_150347_e, Character.valueOf('B'), Items.field_151072_bj });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 379 */     func_92103_a(new ItemStack(Blocks.field_150428_aP, 1), new Object[] { "A", "B", Character.valueOf('A'), Blocks.field_150423_aK, Character.valueOf('B'), Blocks.field_150478_aa });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 385 */     func_92103_a(new ItemStack(Items.field_151108_aI, 1), new Object[] { "A", "B", Character.valueOf('A'), Blocks.field_150486_ae, Character.valueOf('B'), Items.field_151143_au });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 391 */     func_92103_a(new ItemStack(Items.field_151109_aJ, 1), new Object[] { "A", "B", Character.valueOf('A'), Blocks.field_150460_al, Character.valueOf('B'), Items.field_151143_au });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 397 */     func_92103_a(new ItemStack(Items.field_151142_bV, 1), new Object[] { "A", "B", Character.valueOf('A'), Blocks.field_150335_W, Character.valueOf('B'), Items.field_151143_au });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 403 */     func_92103_a(new ItemStack(Items.field_151140_bW, 1), new Object[] { "A", "B", Character.valueOf('A'), Blocks.field_150438_bZ, Character.valueOf('B'), Items.field_151143_au });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 409 */     func_92103_a(new ItemStack(Items.field_151124_az, 1), new Object[] { "# #", "###", Character.valueOf('#'), Blocks.field_150344_f });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 415 */     func_92103_a(new ItemStack(Items.field_151133_ar, 1), new Object[] { "# #", " # ", Character.valueOf('#'), Items.field_151042_j });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 421 */     func_92103_a(new ItemStack(Items.field_151162_bE, 1), new Object[] { "# #", " # ", Character.valueOf('#'), Items.field_151118_aC });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 428 */     func_77596_b(new ItemStack(Items.field_151033_d, 1), new Object[] { new ItemStack(Items.field_151042_j, 1), new ItemStack(Items.field_151145_ak, 1) });
/*     */ 
/*     */     
/* 431 */     func_92103_a(new ItemStack(Items.field_151025_P, 1), new Object[] { "###", Character.valueOf('#'), Items.field_151015_O });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 436 */     func_92103_a(new ItemStack(Blocks.field_150476_ad, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 0) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 443 */     func_92103_a(new ItemStack(Blocks.field_150487_bG, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 2) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 450 */     func_92103_a(new ItemStack(Blocks.field_150485_bF, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 1) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 457 */     func_92103_a(new ItemStack(Blocks.field_150481_bH, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 3) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 464 */     func_92103_a(new ItemStack(Blocks.field_150400_ck, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 4) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 471 */     func_92103_a(new ItemStack(Blocks.field_150401_cl, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 5) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 478 */     func_92103_a(new ItemStack((Item)Items.field_151112_aM, 1), new Object[] { "  #", " #X", "# X", Character.valueOf('#'), Items.field_151055_y, Character.valueOf('X'), Items.field_151007_F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 485 */     func_92103_a(new ItemStack(Items.field_151146_bM, 1), new Object[] { "# ", " X", Character.valueOf('#'), Items.field_151112_aM, Character.valueOf('X'), Items.field_151172_bF }).func_92100_c();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 491 */     func_92103_a(new ItemStack(Blocks.field_150446_ar, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.field_150347_e });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 498 */     func_92103_a(new ItemStack(Blocks.field_150389_bf, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.field_150336_V });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 505 */     func_92103_a(new ItemStack(Blocks.field_150390_bg, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.field_150417_aV });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 512 */     func_92103_a(new ItemStack(Blocks.field_150387_bl, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.field_150385_bj });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 519 */     func_92103_a(new ItemStack(Blocks.field_150372_bz, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.field_150322_A });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 526 */     func_92103_a(new ItemStack(Blocks.field_150370_cb, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.field_150371_ca });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 533 */     func_92103_a(new ItemStack(Items.field_151159_an, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.field_151055_y, Character.valueOf('X'), Blocks.field_150325_L });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 540 */     func_92103_a(new ItemStack(Items.field_151160_bD, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.field_151055_y, Character.valueOf('X'), Items.field_151116_aA });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 547 */     func_92103_a(new ItemStack(Items.field_151153_ao, 1, 0), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.field_151043_k, Character.valueOf('X'), Items.field_151034_e });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 554 */     func_92103_a(new ItemStack(Items.field_151153_ao, 1, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Blocks.field_150340_R, Character.valueOf('X'), Items.field_151034_e });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 561 */     func_92103_a(new ItemStack(Items.field_151150_bK, 1, 0), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.field_151074_bl, Character.valueOf('X'), Items.field_151172_bF });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 569 */     func_92103_a(new ItemStack(Items.field_151060_bw, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.field_151074_bl, Character.valueOf('X'), Items.field_151127_ba });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 577 */     func_92103_a(new ItemStack(Blocks.field_150442_at, 1), new Object[] { "X", "#", Character.valueOf('#'), Blocks.field_150347_e, Character.valueOf('X'), Items.field_151055_y });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 583 */     func_92103_a(new ItemStack((Block)Blocks.field_150479_bC, 2), new Object[] { "I", "S", "#", Character.valueOf('#'), Blocks.field_150344_f, Character.valueOf('S'), Items.field_151055_y, Character.valueOf('I'), Items.field_151042_j });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 590 */     func_92103_a(new ItemStack(Blocks.field_150429_aA, 1), new Object[] { "X", "#", Character.valueOf('#'), Items.field_151055_y, Character.valueOf('X'), Items.field_151137_ax });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 596 */     func_92103_a(new ItemStack(Items.field_151107_aW, 1), new Object[] { "#X#", "III", Character.valueOf('#'), Blocks.field_150429_aA, Character.valueOf('X'), Items.field_151137_ax, Character.valueOf('I'), Blocks.field_150348_b });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 602 */     func_92103_a(new ItemStack(Items.field_151132_bS, 1), new Object[] { " # ", "#X#", "III", Character.valueOf('#'), Blocks.field_150429_aA, Character.valueOf('X'), Items.field_151128_bU, Character.valueOf('I'), Blocks.field_150348_b });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 609 */     func_92103_a(new ItemStack(Items.field_151113_aN, 1), new Object[] { " # ", "#X#", " # ", Character.valueOf('#'), Items.field_151043_k, Character.valueOf('X'), Items.field_151137_ax });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 616 */     func_92103_a(new ItemStack(Items.field_151111_aL, 1), new Object[] { " # ", "#X#", " # ", Character.valueOf('#'), Items.field_151042_j, Character.valueOf('X'), Items.field_151137_ax });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 623 */     func_92103_a(new ItemStack((Item)Items.field_151148_bJ, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.field_151121_aF, Character.valueOf('X'), Items.field_151111_aL });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 630 */     func_92103_a(new ItemStack(Blocks.field_150430_aB, 1), new Object[] { "#", Character.valueOf('#'), Blocks.field_150348_b });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 635 */     func_92103_a(new ItemStack(Blocks.field_150471_bO, 1), new Object[] { "#", Character.valueOf('#'), Blocks.field_150344_f });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 640 */     func_92103_a(new ItemStack(Blocks.field_150456_au, 1), new Object[] { "##", Character.valueOf('#'), Blocks.field_150348_b });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 645 */     func_92103_a(new ItemStack(Blocks.field_150452_aw, 1), new Object[] { "##", Character.valueOf('#'), Blocks.field_150344_f });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 650 */     func_92103_a(new ItemStack(Blocks.field_150443_bT, 1), new Object[] { "##", Character.valueOf('#'), Items.field_151042_j });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 655 */     func_92103_a(new ItemStack(Blocks.field_150445_bS, 1), new Object[] { "##", Character.valueOf('#'), Items.field_151043_k });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 660 */     func_92103_a(new ItemStack(Blocks.field_150367_z, 1), new Object[] { "###", "#X#", "#R#", Character.valueOf('#'), Blocks.field_150347_e, Character.valueOf('X'), Items.field_151031_f, Character.valueOf('R'), Items.field_151137_ax });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 667 */     func_92103_a(new ItemStack(Blocks.field_150409_cd, 1), new Object[] { "###", "# #", "#R#", Character.valueOf('#'), Blocks.field_150347_e, Character.valueOf('R'), Items.field_151137_ax });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 674 */     func_92103_a(new ItemStack((Block)Blocks.field_150331_J, 1), new Object[] { "TTT", "#X#", "#R#", Character.valueOf('#'), Blocks.field_150347_e, Character.valueOf('X'), Items.field_151042_j, Character.valueOf('R'), Items.field_151137_ax, Character.valueOf('T'), Blocks.field_150344_f });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 681 */     func_92103_a(new ItemStack((Block)Blocks.field_150320_F, 1), new Object[] { "S", "P", Character.valueOf('S'), Items.field_151123_aH, Character.valueOf('P'), Blocks.field_150331_J });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 688 */     func_92103_a(new ItemStack(Items.field_151104_aV, 1), new Object[] { "###", "XXX", Character.valueOf('#'), Blocks.field_150325_L, Character.valueOf('X'), Blocks.field_150344_f });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 694 */     func_92103_a(new ItemStack(Blocks.field_150381_bn, 1), new Object[] { " B ", "D#D", "###", Character.valueOf('#'), Blocks.field_150343_Z, Character.valueOf('B'), Items.field_151122_aG, Character.valueOf('D'), Items.field_151045_i });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 701 */     func_92103_a(new ItemStack(Blocks.field_150467_bQ, 1), new Object[] { "III", " i ", "iii", Character.valueOf('I'), Blocks.field_150339_S, Character.valueOf('i'), Items.field_151042_j });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 708 */     func_77596_b(new ItemStack(Items.field_151061_bv, 1), new Object[] { Items.field_151079_bi, Items.field_151065_br });
/*     */ 
/*     */     
/* 711 */     func_77596_b(new ItemStack(Items.field_151059_bz, 3), new Object[] { Items.field_151016_H, Items.field_151065_br, Items.field_151044_h });
/*     */ 
/*     */     
/* 714 */     func_77596_b(new ItemStack(Items.field_151059_bz, 3), new Object[] { Items.field_151016_H, Items.field_151065_br, new ItemStack(Items.field_151044_h, 1, 1) });
/*     */ 
/*     */     
/* 717 */     func_92103_a(new ItemStack((Block)Blocks.field_150453_bW), new Object[] { "GGG", "QQQ", "WWW", Character.valueOf('G'), Blocks.field_150359_w, Character.valueOf('Q'), Items.field_151128_bU, Character.valueOf('W'), Blocks.field_150376_bx });
/*     */ 
/*     */ 
/*     */     
/* 721 */     func_92103_a(new ItemStack((Block)Blocks.field_150438_bZ), new Object[] { "I I", "ICI", " I ", Character.valueOf('I'), Items.field_151042_j, Character.valueOf('C'), Blocks.field_150486_ae });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 727 */     Collections.sort(this.field_77597_b, new Comparator(this)
/*     */         {
/*     */           private static final String __OBFID = "CL_00000091";
/*     */           
/*     */           public int compare(IRecipe p_compare_1_, IRecipe p_compare_2_) {
/* 732 */             if (p_compare_1_ instanceof ShapelessRecipes && p_compare_2_ instanceof ShapedRecipes) {
/* 733 */               return 1;
/*     */             }
/* 735 */             if (p_compare_2_ instanceof ShapelessRecipes && p_compare_1_ instanceof ShapedRecipes) {
/* 736 */               return -1;
/*     */             }
/*     */             
/* 739 */             if (p_compare_2_.func_77570_a() < p_compare_1_.func_77570_a()) return -1; 
/* 740 */             if (p_compare_2_.func_77570_a() > p_compare_1_.func_77570_a()) return 1; 
/* 741 */             return 0;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public ShapedRecipes func_92103_a(ItemStack p_92103_1_, Object... p_92103_2_) {
/* 747 */     String str = "";
/* 748 */     byte b1 = 0;
/* 749 */     int i = 0;
/* 750 */     byte b2 = 0;
/*     */     
/* 752 */     if (p_92103_2_[b1] instanceof String[]) {
/* 753 */       String[] arrayOfString = (String[])p_92103_2_[b1++];
/* 754 */       for (byte b = 0; b < arrayOfString.length; b++) {
/* 755 */         String str1 = arrayOfString[b];
/* 756 */         b2++;
/* 757 */         i = str1.length();
/* 758 */         str = str + str1;
/*     */       } 
/*     */     } else {
/* 761 */       while (p_92103_2_[b1] instanceof String) {
/* 762 */         String str1 = (String)p_92103_2_[b1++];
/* 763 */         b2++;
/* 764 */         i = str1.length();
/* 765 */         str = str + str1;
/*     */       } 
/*     */     } 
/*     */     
/* 769 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 770 */     for (; b1 < p_92103_2_.length; b1 += 2) {
/* 771 */       Character character = (Character)p_92103_2_[b1];
/* 772 */       ItemStack itemStack = null;
/* 773 */       if (p_92103_2_[b1 + 1] instanceof Item) {
/* 774 */         itemStack = new ItemStack((Item)p_92103_2_[b1 + 1]);
/* 775 */       } else if (p_92103_2_[b1 + 1] instanceof Block) {
/* 776 */         itemStack = new ItemStack((Block)p_92103_2_[b1 + 1], 1, 32767);
/* 777 */       } else if (p_92103_2_[b1 + 1] instanceof ItemStack) {
/* 778 */         itemStack = (ItemStack)p_92103_2_[b1 + 1];
/*     */       } 
/* 780 */       hashMap.put(character, itemStack);
/*     */     } 
/*     */     
/* 783 */     ItemStack[] arrayOfItemStack = new ItemStack[i * b2];
/*     */     
/* 785 */     for (byte b3 = 0; b3 < i * b2; b3++) {
/* 786 */       char c = str.charAt(b3);
/* 787 */       if (hashMap.containsKey(Character.valueOf(c))) {
/* 788 */         arrayOfItemStack[b3] = ((ItemStack)hashMap.get(Character.valueOf(c))).func_77946_l();
/*     */       } else {
/* 790 */         arrayOfItemStack[b3] = null;
/*     */       } 
/*     */     } 
/* 793 */     ShapedRecipes shapedRecipes = new ShapedRecipes(i, b2, arrayOfItemStack, p_92103_1_);
/* 794 */     this.field_77597_b.add(shapedRecipes);
/* 795 */     return shapedRecipes;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_77596_b(ItemStack p_77596_1_, Object... p_77596_2_) {
/* 800 */     ArrayList<ItemStack> arrayList = new ArrayList();
/*     */     
/* 802 */     for (Object object : p_77596_2_) {
/* 803 */       if (object instanceof ItemStack) {
/* 804 */         arrayList.add(((ItemStack)object).func_77946_l());
/* 805 */       } else if (object instanceof Item) {
/* 806 */         arrayList.add(new ItemStack((Item)object));
/* 807 */       } else if (object instanceof Block) {
/* 808 */         arrayList.add(new ItemStack((Block)object));
/*     */       } else {
/* 810 */         throw new RuntimeException("Invalid shapeless recipy!");
/*     */       } 
/*     */     } 
/*     */     
/* 814 */     this.field_77597_b.add(new ShapelessRecipes(p_77596_1_, arrayList));
/*     */   }
/*     */   
/*     */   public ItemStack func_82787_a(InventoryCrafting p_82787_1_, World p_82787_2_) {
/* 818 */     byte b1 = 0;
/* 819 */     ItemStack itemStack1 = null;
/* 820 */     ItemStack itemStack2 = null; byte b2;
/* 821 */     for (b2 = 0; b2 < p_82787_1_.func_70302_i_(); b2++) {
/* 822 */       ItemStack itemStack = p_82787_1_.func_70301_a(b2);
/* 823 */       if (itemStack != null) {
/* 824 */         if (!b1) itemStack1 = itemStack; 
/* 825 */         if (b1 == 1) itemStack2 = itemStack; 
/* 826 */         b1++;
/*     */       } 
/*     */     } 
/*     */     
/* 830 */     if (b1 == 2 && itemStack1.func_77973_b() == itemStack2.func_77973_b() && itemStack1.field_77994_a == 1 && itemStack2.field_77994_a == 1 && itemStack1.func_77973_b().func_77645_m()) {
/* 831 */       Item item = itemStack1.func_77973_b();
/* 832 */       int i = item.func_77612_l() - itemStack1.func_77952_i();
/* 833 */       int j = item.func_77612_l() - itemStack2.func_77952_i();
/* 834 */       int k = i + j + item.func_77612_l() * 5 / 100;
/* 835 */       int m = item.func_77612_l() - k;
/* 836 */       if (m < 0) m = 0; 
/* 837 */       return new ItemStack(itemStack1.func_77973_b(), 1, m);
/*     */     } 
/*     */     
/* 840 */     for (b2 = 0; b2 < this.field_77597_b.size(); b2++) {
/* 841 */       IRecipe iRecipe = this.field_77597_b.get(b2);
/* 842 */       if (iRecipe.func_77569_a(p_82787_1_, p_82787_2_)) return iRecipe.func_77572_b(p_82787_1_); 
/*     */     } 
/* 844 */     return null;
/*     */   }
/*     */   
/*     */   public List func_77592_b() {
/* 848 */     return this.field_77597_b;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\crafting\CraftingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */