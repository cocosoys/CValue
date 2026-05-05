/*    */ package JinRyuu.JRMCore.blocks;
/*    */ 
/*    */ import cpw.mods.fml.common.registry.GameRegistry;
/*    */ import net.minecraft.block.Block;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlocksJRMC
/*    */ {
/*    */   public static BlockJRMCHalfSlab stoneSingleSlab;
/*    */   public static BlockJRMCHalfSlab stoneDoubleSlab;
/*    */   public static Block BlockColoredStone;
/*    */   public static Block BlockFence;
/*    */   public static Block BlockStairs;
/*    */   public static Block BlockColoredStone2;
/*    */   public static BlockJRMCHalfSlab stoneSingleSlab2;
/*    */   public static Block BlockFence2;
/*    */   public static Block BlockStairs2;
/*    */   private static final int BlockColorableStonePattern_number = 5;
/* 24 */   public static BlockJRMCHalfSlab[][] BlockColorableStonePattern_slab = new BlockJRMCHalfSlab[5][16];
/* 25 */   public static Block[][] BlockColorableStonePattern_fence = new Block[5][16];
/* 26 */   public static Block[][] BlockColorableStonePattern_stairs = new Block[5][16];
/*    */   
/* 28 */   public static Block[][] BlockColorableStonePattern = new Block[5][16];
/*    */   
/* 30 */   public static String mod = "jinryuumodscore:tile.";
/*    */   
/*    */   public static Block BlockBarrier;
/*    */   
/*    */   public static Block BlockBorder;
/*    */   
/*    */   public static void init() {
/* 37 */     BlockColoredStone = (new BlockColoredStone("BlockColoredStone")).func_149672_a(Block.field_149769_e).func_149663_c("BlockColoredStone").func_149658_d(mod + "BlockColoredStone");
/* 38 */     stoneSingleSlab = (BlockJRMCHalfSlab)(new BlockJRMCStep(false, "BlockColoredStone_8", "BlockColoredStoneS_8")).func_149672_a(Block.field_149769_e).func_149663_c("stoneSingleSlab").func_149658_d(mod + "stoneSingleSlab");
/* 39 */     BlockFence = (new BlockJRMCFence("BlockColoredStone_0")).func_149672_a(Block.field_149769_e).func_149663_c("BlockFence").func_149658_d(mod + "BlockFence");
/* 40 */     BlockStairs = (new BlockJRMCStairs(BlockColoredStone, 0, "BlockColoredStone_0")).func_149672_a(Block.field_149769_e).func_149663_c("BlockStairs").func_149658_d(mod + "BlockStairs");
/*    */     
/* 42 */     BlockColoredStone2 = (new BlockColoredStone("BlockColoredStone2")).func_149672_a(Block.field_149769_e).func_149663_c("BlockColoredStone2").func_149658_d(mod + "BlockColoredStone2");
/* 43 */     stoneSingleSlab2 = (BlockJRMCHalfSlab)(new BlockJRMCStep(false, "BlockColoredStone2_8", "BlockColoredStone2S_8")).func_149672_a(Block.field_149769_e).func_149663_c("stoneSingleSlab2").func_149658_d(mod + "stoneSingleSlab2");
/* 44 */     BlockFence2 = (new BlockJRMCFence("BlockColoredStone2_0")).func_149672_a(Block.field_149769_e).func_149663_c("BlockFence2").func_149658_d(mod + "BlockFence2");
/* 45 */     BlockStairs2 = (new BlockJRMCStairs(BlockColoredStone2, 0, "BlockColoredStone2_0")).func_149672_a(Block.field_149769_e).func_149663_c("BlockStairs2").func_149658_d(mod + "BlockStairs2");
/*    */     
/* 47 */     for (int i = 0; i < 5; i++) {
/* 48 */       String name = "Colorable Stone Pattern" + (i + 1);
/*    */       int j;
/* 50 */       for (j = 0; j < 16; j++) {
/* 51 */         name = "Colorable Stone Pattern" + (i + 1) + "_" + j;
/*    */         
/* 53 */         BlockColorableStonePattern[i][j] = (new BlockColorablePattern(name)).func_149672_a(Block.field_149769_e).func_149663_c(name).func_149658_d(mod + name);
/* 54 */         BlockColorableStonePattern_slab[i][j] = (BlockJRMCHalfSlab)(new BlockJRMCStep(false, name, name)).func_149672_a(Block.field_149769_e).func_149663_c(name + "Slab").func_149658_d(mod + name);
/*    */       } 
/* 56 */       for (j = 0; j < 16; j++) {
/* 57 */         name = "Colorable Stone Pattern" + (i + 1) + "_" + j;
/*    */         
/* 59 */         BlockColorableStonePattern[i][j] = (new BlockColorablePattern(name)).func_149672_a(Block.field_149769_e).func_149663_c(name).func_149658_d(mod + name);
/* 60 */         BlockColorableStonePattern_fence[i][j] = (new BlockJRMCFence(name)).func_149672_a(Block.field_149769_e).func_149663_c(name + "Fence").func_149658_d(mod + name);
/*    */       } 
/* 62 */       for (j = 0; j < 16; j++) {
/* 63 */         name = "Colorable Stone Pattern" + (i + 1) + "_" + j;
/*    */         
/* 65 */         BlockColorableStonePattern[i][j] = (new BlockColorablePattern(name)).func_149672_a(Block.field_149769_e).func_149663_c(name).func_149658_d(mod + name);
/* 66 */         BlockColorableStonePattern_stairs[i][j] = (new BlockJRMCStairs(BlockColorableStonePattern[i][j], 0, name)).func_149672_a(Block.field_149769_e).func_149663_c(name + "Stairs").func_149658_d(mod + name);
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 72 */     BlockBarrier = (new BlockBarrier()).func_149722_s().func_149672_a(Block.field_149769_e).func_149663_c("BlockBarrier").func_149658_d(mod + "BlockBarrier");
/* 73 */     BlockBorder = (new BlockBorder()).func_149722_s().func_149672_a(Block.field_149769_e).func_149663_c("BlockBorder").func_149658_d(mod + "BlockBorder");
/*    */   }
/*    */   
/*    */   public static void register() {
/* 77 */     GameRegistry.registerBlock(BlockColoredStone, ItemBlockColoredStone.class, BlockColoredStone.func_149739_a());
/* 78 */     GameRegistry.registerBlock(stoneSingleSlab, stoneSingleSlab.func_149739_a());
/* 79 */     GameRegistry.registerBlock(BlockFence, BlockFence.func_149739_a());
/* 80 */     GameRegistry.registerBlock(BlockStairs, BlockStairs.func_149739_a());
/*    */     
/* 82 */     GameRegistry.registerBlock(BlockColoredStone2, ItemBlockColoredStone.class, BlockColoredStone2.func_149739_a());
/* 83 */     GameRegistry.registerBlock(stoneSingleSlab2, stoneSingleSlab2.func_149739_a());
/* 84 */     GameRegistry.registerBlock(BlockFence2, BlockFence2.func_149739_a());
/* 85 */     GameRegistry.registerBlock(BlockStairs2, BlockStairs2.func_149739_a());
/*    */     
/* 87 */     for (int i = 0; i < 5; i++) {
/*    */       int j;
/* 89 */       for (j = 0; j < 16; ) { GameRegistry.registerBlock(BlockColorableStonePattern[i][j], BlockColorableStonePattern[i][j].func_149739_a()); j++; }
/* 90 */        for (j = 0; j < 16; ) { GameRegistry.registerBlock(BlockColorableStonePattern_slab[i][j], BlockColorableStonePattern_slab[i][j].func_149739_a()); j++; }
/* 91 */        for (j = 0; j < 16; ) { GameRegistry.registerBlock(BlockColorableStonePattern_fence[i][j], BlockColorableStonePattern_fence[i][j].func_149739_a()); j++; }
/* 92 */        for (j = 0; j < 16; ) { GameRegistry.registerBlock(BlockColorableStonePattern_stairs[i][j], BlockColorableStonePattern_stairs[i][j].func_149739_a()); j++; }
/*    */     
/*    */     } 
/* 95 */     GameRegistry.registerBlock(BlockBarrier, BlockBarrier.func_149739_a());
/* 96 */     GameRegistry.registerBlock(BlockBorder, BlockBorder.func_149739_a());
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\blocks\BlocksJRMC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */