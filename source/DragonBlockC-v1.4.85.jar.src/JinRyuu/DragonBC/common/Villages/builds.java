/*     */ package JinRyuu.DragonBC.common.Villages;
/*     */ 
/*     */ import JinRyuu.JRMCore.blocks.BlocksJRMC;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ 
/*     */ public class builds
/*     */   extends WorldGenerator
/*     */ {
/*     */   public void b(int par2, int par3, int par4, Block par5) {
/*  14 */     b(par2, par3, par4, par5, 0);
/*     */   }
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
/*     */   protected void b(int par2, int par3, int par4, Block par5, int par6) {
/*  57 */     func_150516_a(this.w, par2, par3, par4, par5, par6);
/*     */   }
/*     */   protected boolean notComplete = false;
/*     */   public boolean getNotComplete() {
/*  61 */     return this.notComplete;
/*  62 */   } protected int x = 0;
/*  63 */   protected int y = 0;
/*  64 */   protected int z = 0;
/*  65 */   protected int r = 0;
/*  66 */   protected int flp = 0;
/*     */   protected boolean check = false;
/*  68 */   public static int SizeX = 0;
/*  69 */   public static int SizeZ = 0;
/*  70 */   public static int SizeY = 0;
/*  71 */   public static int MidPointX = 0;
/*  72 */   public static int MidPointZ = 0;
/*  73 */   public void setR(int i) { this.r = i; }
/*  74 */   public void setFlp(int i) { this.flp = i; } public void setCheck(boolean b) {
/*  75 */     this.check = b;
/*     */   }
/*  77 */   protected Block air = Blocks.field_150350_a;
/*  78 */   protected Block b56 = (Block)BlocksJRMC.stoneSingleSlab2;
/*  79 */   protected Block b97 = Blocks.field_150344_f;
/*  80 */   protected Block c = BlocksJRMC.BlockColoredStone2;
/*  81 */   protected Block c2 = BlocksJRMC.BlockColoredStone2;
/*  82 */   protected Block s = (Block)BlocksJRMC.stoneSingleSlab2;
/*  83 */   protected Block f = BlocksJRMC.BlockFence2;
/*  84 */   protected Block stairCompactCobblestone = Blocks.field_150446_ar;
/*  85 */   protected Block stairCompactPlanks = Blocks.field_150476_ad;
/*  86 */   protected Block stoneSingleSlab = (Block)Blocks.field_150333_U;
/*  87 */   protected Block woodSingleSlab = (Block)Blocks.field_150376_bx;
/*  88 */   protected Block fence = Blocks.field_150422_aJ;
/*  89 */   protected Block planks = Blocks.field_150344_f;
/*  90 */   protected Block leaves = (Block)Blocks.field_150362_t;
/*  91 */   protected Block glass = Blocks.field_150359_w;
/*  92 */   protected Block wood = Blocks.field_150364_r;
/*  93 */   protected Block stone = Blocks.field_150348_b;
/*  94 */   protected Block sand = (Block)Blocks.field_150354_m;
/*  95 */   protected Block sandstone = Blocks.field_150322_A;
/*  96 */   protected Block grass = (Block)Blocks.field_150349_c;
/*  97 */   protected Block dirt = Blocks.field_150346_d;
/*  98 */   protected Block oak_stairs = Blocks.field_150476_ad;
/*  99 */   protected Block doorWood = Blocks.field_150466_ao;
/* 100 */   protected Block iron_door = Blocks.field_150454_av;
/* 101 */   protected Block iron_block = Blocks.field_150339_S;
/* 102 */   protected Block torchWood = Blocks.field_150350_a;
/* 103 */   protected Block glowStone = Blocks.field_150426_aN;
/* 104 */   protected Block bookShelf = Blocks.field_150342_X;
/* 105 */   protected Block stoneDoubleSlab = Blocks.field_150417_aV;
/* 106 */   protected Block signWall = Blocks.field_150444_as;
/* 107 */   protected Block blockSteel = Blocks.field_150339_S;
/* 108 */   protected Block ladder = Blocks.field_150468_ap;
/* 109 */   protected Block stoneBrick = Blocks.field_150417_aV;
/* 110 */   protected Block woodDoubleSlab = Blocks.field_150344_f;
/* 111 */   protected Block sandStone = Blocks.field_150322_A;
/* 112 */   protected Block b116 = Blocks.field_150457_bL;
/* 113 */   protected Block b121 = BlocksJRMC.BlockStairs2;
/* 114 */   protected Block b113 = Blocks.field_150467_bQ;
/*     */   
/*     */   protected World w;
/*     */   protected boolean respawn = false;
/*     */   
/*     */   protected Block[] GetValidSpawnBlocks() {
/* 120 */     return new Block[] { (Block)Blocks.field_150349_c };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean LocationIsValidSpawn(World world, int i, int j, int k) {
/* 126 */     this.w = world;
/*     */ 
/*     */ 
/*     */     
/* 130 */     int distanceToAir = 0;
/* 131 */     Block checkID = world.func_147439_a(i, j, k);
/*     */     
/* 133 */     while (checkID != Blocks.field_150350_a) {
/* 134 */       distanceToAir++;
/* 135 */       checkID = world.func_147439_a(i, j + distanceToAir, k);
/*     */     } 
/*     */     
/* 138 */     if (distanceToAir > 6) {
/* 139 */       return false;
/*     */     }
/* 141 */     j += distanceToAir - 1;
/*     */     
/* 143 */     Block blockID = world.func_147439_a(i, j, k);
/* 144 */     Block blockIDAbove = world.func_147439_a(i, j + 1, k);
/* 145 */     Block blockIDBelow = world.func_147439_a(i, j - 1, k);
/* 146 */     for (Block x : GetValidSpawnBlocks()) {
/* 147 */       if (blockIDAbove != Blocks.field_150350_a) {
/* 148 */         return false;
/*     */       }
/* 150 */       if (blockID == x)
/* 151 */         return true; 
/* 152 */       if (blockID == Blocks.field_150433_aE && blockIDBelow == x) {
/* 153 */         return true;
/*     */       }
/*     */     } 
/* 156 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 164 */     return false;
/*     */   }
/*     */   
/*     */   public void setWorld(World world) {
/* 168 */     this.w = world;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean generateBuilding(World world, Random random, int i, int j, int k) {
/* 174 */     return false;
/*     */   }
/*     */   
/*     */   public void setRespawn(boolean b) {
/* 178 */     this.respawn = b;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Villages\builds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */