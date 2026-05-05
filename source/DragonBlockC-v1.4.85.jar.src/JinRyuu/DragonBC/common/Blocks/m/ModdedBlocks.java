/*    */ package JinRyuu.DragonBC.common.Blocks.m;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Items.m.MapleLeafItem;
/*    */ import JinRyuu.DragonBC.common.Items.m.WoodLeafItem;
/*    */ import JinRyuu.DragonBC.common.Items.m.WoodLogItem;
/*    */ import JinRyuu.DragonBC.common.Items.m.WoodPaperItem;
/*    */ import JinRyuu.DragonBC.common.Items.m.WoodPlanksItem;
/*    */ import JinRyuu.DragonBC.common.Items.m.WoodSaplingItem;
/*    */ import JinRyuu.DragonBC.common.Items.m.WoodSlabItem;
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import cpw.mods.fml.common.registry.GameRegistry;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockSlab;
/*    */ import net.minecraft.block.material.Material;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ModdedBlocks
/*    */ {
/*    */   public static Block SakuraStone;
/*    */   public static Block SakuraPlank;
/*    */   public static Block SakuraLogs;
/*    */   public static Block SakuraLeaves;
/*    */   public static Block SakuraSaplings;
/*    */   public static Block SakuraFence;
/*    */   public static Block MahagonyFence;
/*    */   public static Block MapleFence;
/*    */   public static Block SakuraStairs;
/*    */   public static Block MahagonyStairs;
/*    */   public static Block MapleStairs;
/*    */   public static Block MapleLeafs;
/*    */   public static BlockSlab SakuraSlabsSingle;
/*    */   public static BlockSlab SakuraSlabsDouble;
/*    */   public static Block PaperWallMahagony;
/*    */   public static Block PaperWallSakura;
/*    */   public static Block SakFenc;
/*    */   public static Block MahFenc;
/*    */   public static Block MapFenc;
/*    */   
/*    */   public static final void init() {
/* 46 */     GameRegistry.registerBlock(SakuraStone = new MyNormalBlocks("Sakura_Block", Material.field_151576_e), "Sakura_Block");
/* 47 */     PaperWallMahagony = (new MyPaperWallMahagony("Mahagony", Material.field_151575_d)).func_149663_c("MahagonyPaperWall");
/* 48 */     PaperWallSakura = (new MyPaperWallSakura("Sakura", Material.field_151575_d)).func_149663_c("SakuraPaperWall");
/*    */ 
/*    */     
/* 51 */     GameRegistry.registerBlock(PaperWallSakura, WoodPaperItem.class, PaperWallSakura.func_149739_a().substring(5));
/* 52 */     GameRegistry.registerBlock(PaperWallMahagony, WoodPaperItem.class, PaperWallMahagony.func_149739_a().substring(5));
/* 53 */     SakuraPlank = (new MyWoodPlanks()).func_149663_c("Planks");
/*    */     
/* 55 */     SakFenc = (new MyFenceGates(0)).func_149663_c("SakFencGate");
/* 56 */     MahFenc = (new MyFenceGates(1)).func_149663_c("MahFencGate");
/* 57 */     MapFenc = (new MyFenceGates(2)).func_149663_c("MapFencGate");
/*    */     
/* 59 */     SakuraSlabsSingle = new MySlabs(false);
/* 60 */     SakuraSlabsDouble = new MySlabs(true);
/*    */ 
/*    */     
/* 63 */     SakuraStairs = (new MyWoodStairs(SakuraStairs, 0)).func_149663_c("SakuraStairs").func_149647_a(mod_DragonBC.DragonBlockC);
/* 64 */     MahagonyStairs = (new MyWoodStairs(MahagonyStairs, 1)).func_149663_c("MahagonyStairs").func_149647_a(mod_DragonBC.DragonBlockC);
/* 65 */     MapleStairs = (new MyWoodStairs(MapleStairs, 2)).func_149663_c("MapleStairs").func_149647_a(mod_DragonBC.DragonBlockC);
/*    */     
/* 67 */     SakuraFence = (new MySakuraFence("SakuraFence", Material.field_151575_d)).func_149752_b(4.0F).func_149711_c(3.0F).func_149647_a(mod_DragonBC.DragonBlockC);
/* 68 */     MahagonyFence = (new MyMahagonyFence("MahagonyFence", Material.field_151575_d)).func_149752_b(5.0F).func_149711_c(4.0F).func_149647_a(mod_DragonBC.DragonBlockC);
/* 69 */     MapleFence = (new MyMapleFence("MapleFence", Material.field_151575_d)).func_149752_b(5.0F).func_149711_c(4.0F).func_149647_a(mod_DragonBC.DragonBlockC);
/*    */     
/* 71 */     SakuraLogs = (new LogBlock()).func_149663_c("Log").func_149647_a(mod_DragonBC.DragonBlockC);
/* 72 */     SakuraLeaves = (new LeafyBlock()).func_149663_c("Leaf").func_149713_g(1).func_149647_a(mod_DragonBC.DragonBlockC);
/* 73 */     SakuraSaplings = (new MySapling()).func_149663_c("Sapling").func_149647_a(mod_DragonBC.DragonBlockC);
/* 74 */     MapleLeafs = (new MapleLeaf()).func_149663_c("Maples").func_149713_g(1).func_149647_a(mod_DragonBC.DragonBlockC);
/*    */     
/* 76 */     GameRegistry.registerBlock(MapleLeafs, MapleLeafItem.class, MapleLeafs.func_149739_a().substring(5));
/*    */     
/* 78 */     GameRegistry.registerBlock(SakuraPlank, WoodPlanksItem.class, SakuraPlank.func_149739_a().substring(5));
/* 79 */     GameRegistry.registerBlock(SakuraStairs, "SakuraStairs");
/* 80 */     GameRegistry.registerBlock(MahagonyStairs, "MahagonyStairs");
/* 81 */     GameRegistry.registerBlock(MapleStairs, "MapleStairs");
/* 82 */     GameRegistry.registerBlock((Block)SakuraSlabsSingle, WoodSlabItem.class, SakuraSlabsSingle.func_149739_a().substring(5));
/* 83 */     GameRegistry.registerBlock((Block)SakuraSlabsDouble, WoodSlabItem.class, "DoubleSlab");
/* 84 */     GameRegistry.registerBlock(SakuraFence, "SakuraFence");
/* 85 */     GameRegistry.registerBlock(MahagonyFence, "MahagonyFence");
/* 86 */     GameRegistry.registerBlock(MapleFence, "MapleFence");
/* 87 */     GameRegistry.registerBlock(SakuraLogs, WoodLogItem.class, SakuraLogs.func_149739_a().substring(5));
/* 88 */     GameRegistry.registerBlock(SakuraLeaves, WoodLeafItem.class, SakuraLeaves.func_149739_a().substring(5));
/* 89 */     GameRegistry.registerBlock(SakuraSaplings, WoodSaplingItem.class, SakuraSaplings.func_149739_a().substring(5));
/*    */     
/* 91 */     GameRegistry.registerBlock(SakFenc, "SakuraFenceGate");
/* 92 */     GameRegistry.registerBlock(MahFenc, "MahagonyFenceGate");
/* 93 */     GameRegistry.registerBlock(MapFenc, "MapleFenceGate");
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\m\ModdedBlocks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */