/*     */ package JinRyuu.DragonBC.common.m;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.m.ModdedBlocks;
/*     */ import JinRyuu.DragonBC.common.Items.m.ModdedItems;
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class MyRecipes
/*     */ {
/*     */   public static void init() {
/*  15 */     GameRegistry.addRecipe(new ItemStack(ModdedItems.SakuraStick, 4), new Object[] { "#", "#", Character.valueOf('#'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 0) });
/*  16 */     GameRegistry.addRecipe(new ItemStack(ModdedItems.MahagonyStick, 4), new Object[] { "#", "#", Character.valueOf('#'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 1) });
/*  17 */     GameRegistry.addRecipe(new ItemStack(ModdedItems.MapleStick, 4), new Object[] { "&", "&", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 2) });
/*     */     
/*  19 */     GameRegistry.addRecipe(new ItemStack(ModdedItems.SakuraBranch, 4), new Object[] { "#", "#", Character.valueOf('#'), new ItemStack(ModdedBlocks.SakuraLogs, 1, 0) });
/*  20 */     GameRegistry.addRecipe(new ItemStack(ModdedItems.MahagonyBranch, 4), new Object[] { "#", "#", Character.valueOf('#'), new ItemStack(ModdedBlocks.SakuraLogs, 1, 1) });
/*     */ 
/*     */     
/*  23 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.SakuraPlank, 4, 0), new Object[] { "#", Character.valueOf('#'), new ItemStack(ModdedBlocks.SakuraLogs, 1, 0) });
/*  24 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.SakuraPlank, 4, 1), new Object[] { "#", Character.valueOf('#'), new ItemStack(ModdedBlocks.SakuraLogs, 1, 1) });
/*  25 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.SakuraPlank, 4, 2), new Object[] { "#", Character.valueOf('#'), new ItemStack(ModdedBlocks.SakuraLogs, 1, 2) });
/*     */     
/*  27 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.MahagonyFence, 2), new Object[] { "&&&", "&&&", Character.valueOf('&'), ModdedItems.MahagonyStick });
/*  28 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.SakuraFence, 2), new Object[] { "&&&", "&&&", Character.valueOf('&'), ModdedItems.SakuraStick });
/*  29 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.MapleFence, 2), new Object[] { "&&&", "&&&", Character.valueOf('&'), ModdedItems.MapleStick });
/*     */     
/*  31 */     GameRegistry.addRecipe(new ItemStack((Block)ModdedBlocks.SakuraSlabsSingle, 6, 0), new Object[] { "&&&", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 0) });
/*  32 */     GameRegistry.addRecipe(new ItemStack((Block)ModdedBlocks.SakuraSlabsSingle, 6, 1), new Object[] { "&&&", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 1) });
/*  33 */     GameRegistry.addRecipe(new ItemStack((Block)ModdedBlocks.SakuraSlabsSingle, 6, 2), new Object[] { "&&&", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 2) });
/*     */ 
/*     */     
/*  36 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 3, 0), new Object[] { "&I&", "IOI", "&I&", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 0), Character.valueOf('I'), Items.field_151121_aF, Character.valueOf('O'), ModdedItems.SakuraStick });
/*  37 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 1, 0), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallSakura, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 15) });
/*  38 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 1, 1), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallSakura, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 14) });
/*  39 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 1, 2), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallSakura, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 13) });
/*  40 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 1, 3), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallSakura, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 12) });
/*  41 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 1, 4), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallSakura, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 11) });
/*  42 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 1, 5), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallSakura, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 10) });
/*  43 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 1, 6), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallSakura, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 9) });
/*  44 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 1, 7), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallSakura, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 8) });
/*  45 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 1, 8), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallSakura, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 7) });
/*  46 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 1, 9), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallSakura, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 6) });
/*  47 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 1, 10), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallSakura, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 5) });
/*  48 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 1, 11), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallSakura, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 4) });
/*  49 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 1, 12), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallSakura, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 3) });
/*  50 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 1, 13), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallSakura, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 2) });
/*  51 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 1, 14), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallSakura, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 1) });
/*  52 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallSakura, 1, 15), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallSakura, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 0) });
/*     */     
/*  54 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 3, 0), new Object[] { "&I&", "IOI", "&I&", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 1), Character.valueOf('I'), Items.field_151121_aF, Character.valueOf('O'), ModdedItems.MahagonyStick });
/*  55 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 1, 0), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallMahagony, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 15) });
/*  56 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 1, 1), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallMahagony, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 14) });
/*  57 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 1, 2), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallMahagony, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 13) });
/*  58 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 1, 3), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallMahagony, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 12) });
/*  59 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 1, 4), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallMahagony, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 11) });
/*  60 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 1, 5), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallMahagony, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 10) });
/*  61 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 1, 6), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallMahagony, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 9) });
/*  62 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 1, 7), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallMahagony, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 8) });
/*  63 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 1, 8), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallMahagony, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 7) });
/*  64 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 1, 9), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallMahagony, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 6) });
/*  65 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 1, 10), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallMahagony, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 5) });
/*  66 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 1, 11), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallMahagony, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 4) });
/*  67 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 1, 12), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallMahagony, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 3) });
/*  68 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 1, 13), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallMahagony, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 2) });
/*  69 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 1, 14), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallMahagony, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 1) });
/*  70 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.PaperWallMahagony, 1, 15), new Object[] { " I ", "I&I", " I ", Character.valueOf('&'), ModdedBlocks.PaperWallMahagony, Character.valueOf('I'), new ItemStack(Items.field_151100_aR, 1, 0) });
/*     */ 
/*     */     
/*  73 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.SakFenc, 2), new Object[] { "I&I", "I&I", Character.valueOf('I'), ModdedItems.SakuraStick, Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 0) });
/*  74 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.MahFenc, 2), new Object[] { "I&I", "I&I", Character.valueOf('I'), ModdedItems.MahagonyStick, Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 1) });
/*  75 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.MapFenc, 2), new Object[] { "I&I", "I&I", Character.valueOf('I'), ModdedItems.MapleStick, Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 2) });
/*     */ 
/*     */ 
/*     */     
/*  79 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.SakuraStairs, 4), new Object[] { "&  ", "&& ", "&&&", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 0) });
/*  80 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.MahagonyStairs, 4), new Object[] { "&  ", "&& ", "&&&", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 1) });
/*  81 */     GameRegistry.addRecipe(new ItemStack(ModdedBlocks.MapleStairs, 4), new Object[] { "&  ", "&& ", "&&&", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 2) });
/*     */ 
/*     */     
/*  84 */     GameRegistry.addRecipe(new ItemStack(Blocks.field_150468_ap, 3), new Object[] { "& &", "&&&", "& &", Character.valueOf('&'), ModdedItems.SakuraStick });
/*  85 */     GameRegistry.addRecipe(new ItemStack(Blocks.field_150468_ap, 3), new Object[] { "& &", "&&&", "& &", Character.valueOf('&'), ModdedItems.MahagonyStick });
/*  86 */     GameRegistry.addRecipe(new ItemStack(Blocks.field_150468_ap, 3), new Object[] { "& &", "&&&", "& &", Character.valueOf('&'), ModdedItems.MapleStick });
/*     */     
/*  88 */     GameRegistry.addRecipe(new ItemStack(Blocks.field_150478_aa, 4), new Object[] { "I", "&", Character.valueOf('&'), ModdedItems.SakuraStick, Character.valueOf('I'), Items.field_151044_h });
/*  89 */     GameRegistry.addRecipe(new ItemStack(Blocks.field_150478_aa, 4), new Object[] { "I", "&", Character.valueOf('&'), ModdedItems.MahagonyStick, Character.valueOf('I'), Items.field_151044_h });
/*  90 */     GameRegistry.addRecipe(new ItemStack(Blocks.field_150478_aa, 4), new Object[] { "I", "&", Character.valueOf('&'), ModdedItems.MapleStick, Character.valueOf('I'), Items.field_151044_h });
/*  91 */     GameRegistry.addRecipe(new ItemStack(Blocks.field_150478_aa, 4), new Object[] { "I", "&", Character.valueOf('&'), new ItemStack(ModdedItems.MahagonyStick), Character.valueOf('I'), new ItemStack(Items.field_151044_h, 1, 1) });
/*  92 */     GameRegistry.addRecipe(new ItemStack(Blocks.field_150478_aa, 4), new Object[] { "I", "&", Character.valueOf('&'), new ItemStack(ModdedItems.SakuraStick), Character.valueOf('I'), new ItemStack(Items.field_151044_h, 1, 1) });
/*  93 */     GameRegistry.addRecipe(new ItemStack(Blocks.field_150478_aa, 4), new Object[] { "I", "&", Character.valueOf('&'), new ItemStack(ModdedItems.MapleStick), Character.valueOf('I'), new ItemStack(Items.field_151044_h, 1, 1) });
/*     */     
/*  95 */     GameRegistry.addRecipe(new ItemStack(Blocks.field_150462_ai), new Object[] { "&&", "&&", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 0) });
/*  96 */     GameRegistry.addRecipe(new ItemStack((Block)Blocks.field_150486_ae), new Object[] { "&&&", "& &", "&&&", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 0) });
/*  97 */     GameRegistry.addRecipe(new ItemStack(Blocks.field_150462_ai), new Object[] { "&&", "&&", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 1) });
/*  98 */     GameRegistry.addRecipe(new ItemStack((Block)Blocks.field_150486_ae), new Object[] { "&&&", "& &", "&&&", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 1) });
/*  99 */     GameRegistry.addRecipe(new ItemStack(Blocks.field_150462_ai), new Object[] { "&&", "&&", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 2) });
/* 100 */     GameRegistry.addRecipe(new ItemStack((Block)Blocks.field_150486_ae), new Object[] { "&&&", "& &", "&&&", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 2) });
/*     */ 
/*     */ 
/*     */     
/* 104 */     GameRegistry.addRecipe(new ItemStack((Item)ModdedItems.SakuraSword), new Object[] { " & ", " & ", " I ", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 0), Character.valueOf('I'), ModdedItems.SakuraStick });
/* 105 */     GameRegistry.addRecipe(new ItemStack((Item)ModdedItems.SakuraAxe), new Object[] { " &&", " I&", " I ", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 0), Character.valueOf('I'), ModdedItems.SakuraStick });
/* 106 */     GameRegistry.addRecipe(new ItemStack((Item)ModdedItems.SakuraPickaxe), new Object[] { "&&&", " I ", " I ", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 0), Character.valueOf('I'), ModdedItems.SakuraStick });
/* 107 */     GameRegistry.addRecipe(new ItemStack((Item)ModdedItems.SakuraShovel), new Object[] { " & ", " I ", " I ", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 0), Character.valueOf('I'), ModdedItems.SakuraStick });
/* 108 */     GameRegistry.addRecipe(new ItemStack((Item)ModdedItems.SakuraHoe), new Object[] { " &&", " I ", " I ", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 0), Character.valueOf('I'), ModdedItems.SakuraStick });
/* 109 */     GameRegistry.addRecipe(new ItemStack((Item)ModdedItems.SakuraHammer), new Object[] { "&I&", " I ", " I ", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 0), Character.valueOf('I'), ModdedItems.SakuraBranch });
/*     */ 
/*     */ 
/*     */     
/* 113 */     GameRegistry.addRecipe(new ItemStack((Item)ModdedItems.MahagonySword), new Object[] { " & ", " & ", " I ", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 1), Character.valueOf('I'), ModdedItems.MahagonyStick });
/* 114 */     GameRegistry.addRecipe(new ItemStack((Item)ModdedItems.MahagonyAxe), new Object[] { " &&", " I&", " I ", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 1), Character.valueOf('I'), ModdedItems.MahagonyStick });
/* 115 */     GameRegistry.addRecipe(new ItemStack((Item)ModdedItems.MahagonyPickaxe), new Object[] { "&&&", " I ", " I ", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 1), Character.valueOf('I'), ModdedItems.MahagonyStick });
/* 116 */     GameRegistry.addRecipe(new ItemStack((Item)ModdedItems.MahagonyShovel), new Object[] { " & ", " I ", " I ", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 1), Character.valueOf('I'), ModdedItems.MahagonyStick });
/* 117 */     GameRegistry.addRecipe(new ItemStack((Item)ModdedItems.MahagonyHoe), new Object[] { " &&", " I ", " I ", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 1), Character.valueOf('I'), ModdedItems.MahagonyStick });
/*     */     
/* 119 */     GameRegistry.addRecipe(new ItemStack((Item)ModdedItems.MapleSword), new Object[] { " & ", " & ", " I ", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 2), Character.valueOf('I'), ModdedItems.MapleStick });
/* 120 */     GameRegistry.addRecipe(new ItemStack((Item)ModdedItems.MapleAxe), new Object[] { " &&", " I&", " I ", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 2), Character.valueOf('I'), ModdedItems.MapleStick });
/* 121 */     GameRegistry.addRecipe(new ItemStack((Item)ModdedItems.MaplePickaxe), new Object[] { "&&&", " I ", " I ", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 2), Character.valueOf('I'), ModdedItems.MapleStick });
/* 122 */     GameRegistry.addRecipe(new ItemStack((Item)ModdedItems.MapleShovel), new Object[] { " & ", " I ", " I ", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 2), Character.valueOf('I'), ModdedItems.MapleStick });
/* 123 */     GameRegistry.addRecipe(new ItemStack((Item)ModdedItems.MapleHoe), new Object[] { " &&", " I ", " I ", Character.valueOf('&'), new ItemStack(ModdedBlocks.SakuraPlank, 1, 2), Character.valueOf('I'), ModdedItems.MapleStick });
/*     */ 
/*     */     
/* 126 */     GameRegistry.addSmelting(ModdedBlocks.SakuraLogs, new ItemStack(Items.field_151044_h, 1, 1), 0.15F);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\m\MyRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */