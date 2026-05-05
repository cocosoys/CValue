/*     */ package JinRyuu.DragonBC.common.Blocks;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.m.ModdedBlocks;
/*     */ import JinRyuu.DragonBC.common.Render.ArtGravDevBlock;
/*     */ import JinRyuu.DragonBC.common.Render.DragonBlock01Block;
/*     */ import JinRyuu.DragonBC.common.Render.DragonBlockNS01Block;
/*     */ import JinRyuu.DragonBC.common.Render.DragonBlockNamek01Block;
/*     */ import JinRyuu.DragonBC.common.Render.DragonBlockS01Block;
/*     */ import JinRyuu.DragonBC.common.Render.MedPodDoor1Block;
/*     */ import JinRyuu.DragonBC.common.Render.SaibaiHatchedBlock;
/*     */ import JinRyuu.DragonBC.common.Render.SpacePod01Block;
/*     */ import JinRyuu.DragonBC.common.Render.namekian_throneBlock;
/*     */ import JinRyuu.DragonBC.common.Render.ppBlock;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraftforge.fluids.Fluid;
/*     */ import net.minecraftforge.fluids.FluidRegistry;
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
/*     */ public class BlocksDBC
/*     */ {
/*     */   public static Block BlockAlienStone;
/*     */   public static Block BlockAlienCobbleStone;
/*     */   public static Block BlockNamekDragonBallStone;
/*     */   public static Block BlockNamekDragonBall;
/*     */   public static Block BlockDragonBallStone;
/*     */   public static Block BlockDragonBall;
/*     */   public static Block BlockOreWrenai;
/*     */   public static Block BlockNamekGrass;
/*     */   public static Block BlockNamekDirt;
/*     */   public static Block BlockNamekStone;
/*     */   public static Block BlockNamekLog;
/*     */   public static Block BlockNamekLeaves;
/*     */   public static Block BlockKiFire;
/*     */   public static Block AuraDyn;
/*     */   public static Block BlockHellStone;
/*     */   public static Block BlockYellowCloud;
/*     */   public static Block BlockInvisWall;
/*     */   public static Block BlockTCPort;
/*     */   public static Block BlockTCFloor;
/*  55 */   public static Fluid medicalLiquid = new Fluid("medicalliquid");
/*     */   
/*     */   public static Block BlockHealingPods;
/*     */   public static Block BlockHealingPodDoor;
/*     */   public static Block BlockCropMedMoss;
/*     */   public static Block BlockWildMedMoss;
/*     */   public static Block SpacePod01Block;
/*     */   public static Block SaibaiHatched;
/*     */   public static Block ArtGravDevBlock;
/*     */   public static BlockDBCSaplings BlockNamekSapling;
/*     */   public static Block DBCmobSpawner;
/*  66 */   public static String mod = "jinryuudragonbc:tile.";
/*     */   
/*     */   public static Block ppBlock;
/*     */   
/*     */   public static Block BlockOreJJay;
/*     */   
/*     */   public static Block BlockOreDlog;
/*     */   public static Block BlockOreLehnori;
/*     */   public static Block BlockOreDnomaid;
/*  75 */   public static String[] BlockOWnams = new String[] { "JJayblock", "Dlogblock", "Lehnoriblock", "Dnomaidblock" };
/*  76 */   public static Block[] BlockOWtyps = new Block[] { new BlockAnyBase(Item.ToolMaterial.WOOD.func_77996_d()), new BlockAnyBase(Item.ToolMaterial.STONE.func_77996_d()), new BlockAnyBase(Item.ToolMaterial.STONE.func_77996_d()), new BlockAnyBase(Item.ToolMaterial.IRON.func_77996_d()) };
/*  77 */   public static Block[] BlockOW = new Block[BlockOWnams.length];
/*     */   
/*     */   public static final int BlockJJay = 0;
/*     */   
/*     */   public static final int BlockDlog = 1;
/*     */   public static final int BlockLehnori = 2;
/*     */   public static final int BlockDnomaid = 3;
/*     */   public static Block namekian_throneBlock;
/*  85 */   private static int BlockKachiKachin_n = 16;
/*  86 */   public static Block[] BlockKachiKachin = new Block[BlockKachiKachin_n];
/*  87 */   private static int BlockKachin_n = 3;
/*  88 */   public static Block[] BlockKachin = new Block[BlockKachin_n];
/*     */   
/*     */   public static void init() {
/*  91 */     FluidRegistry.registerFluid(medicalLiquid);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  99 */     BlockAlienStone = (new BlockAlienStone()).func_149663_c("BlockAlienStone").func_149658_d(mod + "BlockAlienStone");
/* 100 */     BlockAlienCobbleStone = (new BlockAlienCobbleStone()).func_149663_c("BlockAlienCobbleStone").func_149658_d(mod + "BlockAlienCobbleStone");
/* 101 */     BlockNamekDragonBallStone = (new DragonBlockNS01Block()).func_149663_c("BlockNamekDragonBallStone").func_149658_d(mod + "BlockNamekDragonBallStone");
/* 102 */     BlockNamekDragonBall = (new DragonBlockNamek01Block()).func_149663_c("BlockNamekDragonBall").func_149658_d(mod + "BlockNamekDragonBall");
/* 103 */     BlockDragonBallStone = (new DragonBlockS01Block()).func_149663_c("BlockDragonBallStone").func_149658_d(mod + "BlockDragonBallStone");
/* 104 */     BlockDragonBall = (new DragonBlock01Block()).func_149663_c("BlockDragonBall").func_149658_d(mod + "BlockDragonBall");
/* 105 */     BlockOreWrenai = (new BlockOreWrenai()).func_149663_c("BlockOreWrenai").func_149658_d(mod + "BlockOreWrenai");
/* 106 */     BlockNamekGrass = (new BlockNamekGrass()).func_149711_c(0.6F).func_149672_a(Block.field_149779_h).func_149663_c("BlockNamekGrass").func_149658_d(mod + "BlockNamekGrass");
/* 107 */     BlockNamekDirt = (new BlockNamekDirt()).func_149711_c(0.5F).func_149672_a(Block.field_149767_g).func_149663_c("BlockNamekDirt").func_149658_d(mod + "BlockNamekDirt");
/* 108 */     BlockNamekStone = (new BlockNamekStone()).func_149711_c(1.5F).func_149672_a(Block.field_149769_e).func_149663_c("BlockNamekStone").func_149658_d(mod + "BlockNamekStone");
/* 109 */     BlockNamekLog = (new BlockNamekLog()).func_149711_c(2.0F).func_149672_a(Block.field_149766_f).func_149663_c("BlockNamekLog").func_149658_d(mod + "BlockNamekLog");
/*     */     
/* 111 */     BlockNamekLeaves = (new BlockNamekLeaves(52)).func_149711_c(0.2F).func_149713_g(1).func_149672_a(Block.field_149779_h).func_149663_c("BlockNamekLeaves").func_149658_d(mod + "BlockNamekLeaves");
/* 112 */     BlockNamekSapling = (BlockDBCSaplings)(new BlockDBCSaplings()).func_149711_c(0.0F).func_149672_a(Block.field_149779_h).func_149663_c("Sapling");
/*     */     
/* 114 */     BlockOreJJay = (new BlockOreDBC(Item.ToolMaterial.WOOD.func_77996_d())).func_149663_c("JJayore").func_149658_d(mod + "JJayore");
/* 115 */     BlockOreDlog = (new BlockOreDBC(Item.ToolMaterial.STONE.func_77996_d())).func_149663_c("Dlogore").func_149658_d(mod + "Dlogore");
/* 116 */     BlockOreLehnori = (new BlockOreDBC(Item.ToolMaterial.STONE.func_77996_d())).func_149663_c("Lehnoriore").func_149658_d(mod + "Lehnoriore");
/* 117 */     BlockOreDnomaid = (new BlockOreDBC(Item.ToolMaterial.IRON.func_77996_d())).func_149663_c("Dnomaidore").func_149658_d(mod + "Dnomaidore");
/*     */     int i;
/* 119 */     for (i = 0; i < BlockOW.length; i++) {
/* 120 */       BlockOW[i] = BlockOWtyps[i].func_149663_c(BlockOWnams[i]).func_149658_d(mod + BlockOWnams[i]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 129 */     BlockYellowCloud = (new BlockYellowCloud()).func_149711_c(5.0F).func_149672_a(Block.field_149779_h).func_149663_c("BlockYellowCloud").func_149658_d(mod + "BlockYellowCloud");
/* 130 */     BlockTCPort = (new BlockTCPort()).func_149663_c("BlockTCPort").func_149658_d(mod + "BlockTCPort");
/* 131 */     BlockTCFloor = (new BlockTCFloor()).func_149711_c(50.0F).func_149752_b(2000.0F).func_149672_a(Block.field_149769_e).func_149663_c("BlockTCFloor").func_149658_d(mod + "BlockTCFloor");
/*     */ 
/*     */     
/* 134 */     BlockHealingPods = (new BlockHealingPods(medicalLiquid, Material.field_151586_h)).func_149663_c("BlockHealingPods");
/* 135 */     BlockHealingPodDoor = (new MedPodDoor1Block()).func_149711_c(50.0F).func_149752_b(2000.0F).func_149663_c("BlockHealingPodDoor");
/* 136 */     BlockCropMedMoss = (new BlockCropMedMoss()).func_149663_c("BlockCropMedMoss");
/* 137 */     BlockWildMedMoss = (new BlockWildMedMoss()).func_149663_c("BlockWildMedMoss");
/*     */     
/* 139 */     SpacePod01Block = (new SpacePod01Block()).func_149711_c(0.2F).func_149713_g(1).func_149672_a(Block.field_149779_h).func_149663_c("SpacePod01Block").func_149658_d(mod + "SpacePod01Block");
/*     */     
/* 141 */     SaibaiHatched = (new SaibaiHatchedBlock()).func_149711_c(0.2F).func_149713_g(5).func_149672_a(Block.field_149779_h).func_149663_c("SaibaiHatched").func_149658_d(mod + "SaibaiHatched");
/* 142 */     ArtGravDevBlock = (new ArtGravDevBlock()).func_149711_c(0.2F).func_149713_g(5).func_149672_a(Block.field_149777_j).func_149663_c("ArtGravDevBlock").func_149658_d(mod + "ArtGravDevBlock");
/* 143 */     ppBlock = (new ppBlock()).func_149672_a(Block.field_149777_j).func_149663_c("ppBlock").func_149658_d(mod + "ppBlock");
/*     */     
/* 145 */     namekian_throneBlock = (new namekian_throneBlock()).func_149663_c("namekian_throneBlock").func_149658_d(mod + "namekian_throneBlock").func_149647_a(mod_DragonBC.DragonBlockC);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 150 */     for (i = 0; i < BlockKachin_n; i++) {
/* 151 */       BlockKachin[i] = (new BlockAnyBase2(-1)).func_149711_c(50.0F).func_149752_b(2000.0F).func_149663_c("katchin_block" + i).func_149658_d(mod + "katchin_block" + i);
/*     */     }
/*     */ 
/*     */     
/* 155 */     for (i = 0; i < BlockKachiKachin_n; i++) {
/* 156 */       BlockKachiKachin[i] = (new BlockAnyBase2(-1)).func_149711_c(-1.0F).func_149752_b(6000000.0F).func_149663_c("kachi_katchin_block" + i).func_149658_d(mod + "kachi_katchin_block" + i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void register() {
/* 165 */     GameRegistry.registerBlock(BlockTCPort, BlockTCPort.func_149739_a());
/* 166 */     GameRegistry.registerBlock(BlockTCFloor, BlockTCFloor.func_149739_a());
/* 167 */     GameRegistry.registerBlock(BlockYellowCloud, BlockYellowCloud.func_149739_a());
/* 168 */     GameRegistry.registerBlock(BlockAlienStone, BlockAlienStone.func_149739_a());
/* 169 */     GameRegistry.registerBlock(BlockAlienCobbleStone, BlockAlienCobbleStone.func_149739_a());
/* 170 */     GameRegistry.registerBlock(BlockNamekDragonBallStone, BlockNamekDragonBallStone.func_149739_a());
/* 171 */     GameRegistry.registerBlock(BlockNamekDragonBall, BlockNamekDragonBall.func_149739_a());
/* 172 */     GameRegistry.registerBlock(BlockDragonBallStone, BlockDragonBallStone.func_149739_a());
/* 173 */     GameRegistry.registerBlock(BlockDragonBall, BlockDragonBall.func_149739_a());
/* 174 */     GameRegistry.registerBlock(BlockOreWrenai, BlockOreWrenai.func_149739_a());
/* 175 */     GameRegistry.registerBlock(BlockNamekGrass, BlockNamekGrass.func_149739_a());
/* 176 */     GameRegistry.registerBlock(BlockNamekLog, BlockNamekLog.func_149739_a());
/* 177 */     GameRegistry.registerBlock(BlockNamekDirt, BlockNamekDirt.func_149739_a());
/* 178 */     GameRegistry.registerBlock(BlockNamekStone, BlockNamekStone.func_149739_a());
/* 179 */     GameRegistry.registerBlock(BlockNamekLeaves, BlockNamekLeaves.func_149739_a());
/* 180 */     GameRegistry.registerBlock((Block)BlockNamekSapling, ItemDBCSaplingsTex.class, BlockNamekSapling.func_149739_a());
/* 181 */     GameRegistry.registerBlock(BlockOreJJay, BlockOreJJay.func_149739_a());
/* 182 */     GameRegistry.registerBlock(BlockOreDlog, BlockOreDlog.func_149739_a());
/* 183 */     GameRegistry.registerBlock(BlockOreLehnori, BlockOreLehnori.func_149739_a());
/* 184 */     GameRegistry.registerBlock(BlockOreDnomaid, BlockOreDnomaid.func_149739_a()); int i;
/* 185 */     for (i = 0; i < BlockOW.length; i++) {
/* 186 */       GameRegistry.registerBlock(BlockOW[i], BlockOW[i].func_149739_a());
/*     */     }
/*     */     
/* 189 */     GameRegistry.registerBlock(BlockHealingPods, BlockHealingPods.func_149739_a());
/* 190 */     GameRegistry.registerBlock(BlockHealingPodDoor, BlockHealingPodDoor.func_149739_a());
/* 191 */     GameRegistry.registerBlock(SpacePod01Block, SpacePod01Block.func_149739_a());
/* 192 */     GameRegistry.registerBlock(SaibaiHatched, SaibaiHatched.func_149739_a());
/* 193 */     GameRegistry.registerBlock(ArtGravDevBlock, ArtGravDevBlock.func_149739_a());
/* 194 */     GameRegistry.registerBlock(BlockCropMedMoss, BlockCropMedMoss.func_149739_a());
/* 195 */     GameRegistry.registerBlock(BlockWildMedMoss, BlockWildMedMoss.func_149739_a());
/* 196 */     GameRegistry.registerBlock(ppBlock, ppBlock.func_149739_a());
/*     */     
/* 198 */     GameRegistry.registerBlock(namekian_throneBlock, namekian_throneBlock.func_149739_a());
/*     */     
/* 200 */     for (i = 0; i < BlockKachin_n; i++) {
/* 201 */       GameRegistry.registerBlock(BlockKachin[i], BlockKachin[i].func_149739_a());
/*     */     }
/* 203 */     for (i = 0; i < BlockKachiKachin_n; i++) {
/* 204 */       GameRegistry.registerBlock(BlockKachiKachin[i], BlockKachiKachin[i].func_149739_a());
/*     */     }
/*     */ 
/*     */     
/* 208 */     ModdedBlocks.init();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlocksDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */