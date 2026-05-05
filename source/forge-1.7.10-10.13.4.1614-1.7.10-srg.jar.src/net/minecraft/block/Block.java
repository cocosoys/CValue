/*      */ package net.minecraft.block;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import net.minecraft.block.material.MapColor;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.client.renderer.texture.IIconRegister;
/*      */ import net.minecraft.creativetab.CreativeTabs;
/*      */ import net.minecraft.enchantment.EnchantmentHelper;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.item.EntityXPOrb;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.tileentity.TileEntitySign;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.IIcon;
/*      */ import net.minecraft.util.RegistryNamespaced;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.Explosion;
/*      */ import net.minecraft.world.IBlockAccess;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ public class Block {
/*   28 */   public static final RegistryNamespaced field_149771_c = (RegistryNamespaced)new RegistryNamespacedDefaultedByKey("air");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CreativeTabs field_149772_a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String field_149768_d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int func_149682_b(Block p_149682_0_) {
/*   51 */     return field_149771_c.func_148757_b(p_149682_0_);
/*      */   }
/*      */   
/*      */   public static Block func_149729_e(int p_149729_0_) {
/*   55 */     return (Block)field_149771_c.func_148754_a(p_149729_0_);
/*      */   }
/*      */   
/*      */   public static Block func_149634_a(Item p_149634_0_) {
/*   59 */     return func_149729_e(Item.func_150891_b(p_149634_0_));
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block func_149684_b(String p_149684_0_) {
/*   64 */     if (field_149771_c.func_148741_d(p_149684_0_)) {
/*   65 */       return (Block)field_149771_c.func_82594_a(p_149684_0_);
/*      */     }
/*      */     
/*      */     try {
/*   69 */       return (Block)field_149771_c.func_148754_a(Integer.parseInt(p_149684_0_));
/*   70 */     } catch (NumberFormatException numberFormatException) {
/*      */ 
/*      */       
/*   73 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_149730_j() {
/*   87 */     return this.field_149787_q;
/*      */   }
/*      */   
/*      */   public int func_149717_k() {
/*   91 */     return this.field_149786_r;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean func_149751_l() {
/*   95 */     return this.field_149785_s;
/*      */   }
/*      */   
/*      */   public int func_149750_m() {
/*   99 */     return this.field_149784_t;
/*      */   }
/*      */   
/*      */   public boolean func_149710_n() {
/*  103 */     return this.field_149783_u;
/*      */   }
/*      */   
/*      */   public Material func_149688_o() {
/*  107 */     return this.field_149764_J;
/*      */   }
/*      */   
/*      */   public MapColor func_149728_f(int p_149728_1_) {
/*  111 */     return func_149688_o().func_151565_r();
/*      */   }
/*      */   
/*      */   public static class SoundType { public final String field_150501_a;
/*      */     public final float field_150499_b;
/*      */     public final float field_150500_c;
/*      */     private static final String __OBFID = "CL_00000203";
/*      */     
/*      */     public SoundType(String p_i45393_1_, float p_i45393_2_, float p_i45393_3_) {
/*  120 */       this.field_150501_a = p_i45393_1_;
/*  121 */       this.field_150499_b = p_i45393_2_;
/*  122 */       this.field_150500_c = p_i45393_3_;
/*      */     }
/*      */     
/*      */     public float func_150497_c() {
/*  126 */       return this.field_150499_b;
/*      */     }
/*      */     
/*      */     public float func_150494_d() {
/*  130 */       return this.field_150500_c;
/*      */     }
/*      */     
/*      */     public String func_150495_a() {
/*  134 */       return "dig." + this.field_150501_a;
/*      */     }
/*      */     
/*      */     public String func_150498_e() {
/*  138 */       return "step." + this.field_150501_a;
/*      */     }
/*      */     
/*      */     public String func_150496_b() {
/*  142 */       return func_150495_a();
/*      */     } }
/*      */ 
/*      */   
/*  146 */   public static final SoundType field_149769_e = new SoundType("stone", 1.0F, 1.0F);
/*  147 */   public static final SoundType field_149766_f = new SoundType("wood", 1.0F, 1.0F);
/*  148 */   public static final SoundType field_149767_g = new SoundType("gravel", 1.0F, 1.0F);
/*  149 */   public static final SoundType field_149779_h = new SoundType("grass", 1.0F, 1.0F);
/*  150 */   public static final SoundType field_149780_i = new SoundType("stone", 1.0F, 1.0F);
/*  151 */   public static final SoundType field_149777_j = new SoundType("stone", 1.0F, 1.5F);
/*  152 */   public static final SoundType field_149778_k = new SoundType("stone", 1.0F, 1.0F) { private static final String __OBFID = "CL_00000200";
/*      */       
/*      */       public String func_150495_a() {
/*  155 */         return "dig.glass";
/*      */       }
/*      */ 
/*      */       
/*      */       public String func_150496_b() {
/*  160 */         return "step.stone";
/*      */       } }
/*      */   ;
/*  163 */   public static final SoundType field_149775_l = new SoundType("cloth", 1.0F, 1.0F);
/*  164 */   public static final SoundType field_149776_m = new SoundType("sand", 1.0F, 1.0F);
/*  165 */   public static final SoundType field_149773_n = new SoundType("snow", 1.0F, 1.0F);
/*  166 */   public static final SoundType field_149774_o = new SoundType("ladder", 1.0F, 1.0F) { private static final String __OBFID = "CL_00000201";
/*      */       
/*      */       public String func_150495_a() {
/*  169 */         return "dig.wood";
/*      */       } }
/*      */   ;
/*  172 */   public static final SoundType field_149788_p = new SoundType("anvil", 0.3F, 1.0F) { private static final String __OBFID = "CL_00000202";
/*      */       
/*      */       public String func_150495_a() {
/*  175 */         return "dig.stone";
/*      */       }
/*      */ 
/*      */       
/*      */       public String func_150496_b() {
/*  180 */         return "random.anvil_land";
/*      */       } }
/*      */   ;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean field_149787_q;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int field_149786_r;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean field_149785_s;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int field_149784_t;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean field_149783_u;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float field_149782_v;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float field_149781_w;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void func_149671_p() {
/*  237 */     field_149771_c.func_148756_a(0, "air", (new BlockAir()).func_149663_c("air"));
/*  238 */     field_149771_c.func_148756_a(1, "stone", (new BlockStone()).func_149711_c(1.5F).func_149752_b(10.0F).func_149672_a(field_149780_i).func_149663_c("stone").func_149658_d("stone"));
/*  239 */     field_149771_c.func_148756_a(2, "grass", (new BlockGrass()).func_149711_c(0.6F).func_149672_a(field_149779_h).func_149663_c("grass").func_149658_d("grass"));
/*  240 */     field_149771_c.func_148756_a(3, "dirt", (new BlockDirt()).func_149711_c(0.5F).func_149672_a(field_149767_g).func_149663_c("dirt").func_149658_d("dirt"));
/*  241 */     Block block1 = (new Block(Material.field_151576_e)).func_149711_c(2.0F).func_149752_b(10.0F).func_149672_a(field_149780_i).func_149663_c("stonebrick").func_149647_a(CreativeTabs.field_78030_b).func_149658_d("cobblestone");
/*  242 */     field_149771_c.func_148756_a(4, "cobblestone", block1);
/*  243 */     Block block2 = (new BlockWood()).func_149711_c(2.0F).func_149752_b(5.0F).func_149672_a(field_149766_f).func_149663_c("wood").func_149658_d("planks");
/*  244 */     field_149771_c.func_148756_a(5, "planks", block2);
/*  245 */     field_149771_c.func_148756_a(6, "sapling", (new BlockSapling()).func_149711_c(0.0F).func_149672_a(field_149779_h).func_149663_c("sapling").func_149658_d("sapling"));
/*  246 */     field_149771_c.func_148756_a(7, "bedrock", (new Block(Material.field_151576_e)).func_149722_s().func_149752_b(6000000.0F).func_149672_a(field_149780_i).func_149663_c("bedrock").func_149649_H().func_149647_a(CreativeTabs.field_78030_b).func_149658_d("bedrock"));
/*  247 */     field_149771_c.func_148756_a(8, "flowing_water", (new BlockDynamicLiquid(Material.field_151586_h)).func_149711_c(100.0F).func_149713_g(3).func_149663_c("water").func_149649_H().func_149658_d("water_flow"));
/*  248 */     field_149771_c.func_148756_a(9, "water", (new BlockStaticLiquid(Material.field_151586_h)).func_149711_c(100.0F).func_149713_g(3).func_149663_c("water").func_149649_H().func_149658_d("water_still"));
/*  249 */     field_149771_c.func_148756_a(10, "flowing_lava", (new BlockDynamicLiquid(Material.field_151587_i)).func_149711_c(100.0F).func_149715_a(1.0F).func_149663_c("lava").func_149649_H().func_149658_d("lava_flow"));
/*  250 */     field_149771_c.func_148756_a(11, "lava", (new BlockStaticLiquid(Material.field_151587_i)).func_149711_c(100.0F).func_149715_a(1.0F).func_149663_c("lava").func_149649_H().func_149658_d("lava_still"));
/*  251 */     field_149771_c.func_148756_a(12, "sand", (new BlockSand()).func_149711_c(0.5F).func_149672_a(field_149776_m).func_149663_c("sand").func_149658_d("sand"));
/*  252 */     field_149771_c.func_148756_a(13, "gravel", (new BlockGravel()).func_149711_c(0.6F).func_149672_a(field_149767_g).func_149663_c("gravel").func_149658_d("gravel"));
/*  253 */     field_149771_c.func_148756_a(14, "gold_ore", (new BlockOre()).func_149711_c(3.0F).func_149752_b(5.0F).func_149672_a(field_149780_i).func_149663_c("oreGold").func_149658_d("gold_ore"));
/*  254 */     field_149771_c.func_148756_a(15, "iron_ore", (new BlockOre()).func_149711_c(3.0F).func_149752_b(5.0F).func_149672_a(field_149780_i).func_149663_c("oreIron").func_149658_d("iron_ore"));
/*  255 */     field_149771_c.func_148756_a(16, "coal_ore", (new BlockOre()).func_149711_c(3.0F).func_149752_b(5.0F).func_149672_a(field_149780_i).func_149663_c("oreCoal").func_149658_d("coal_ore"));
/*  256 */     field_149771_c.func_148756_a(17, "log", (new BlockOldLog()).func_149663_c("log").func_149658_d("log"));
/*  257 */     field_149771_c.func_148756_a(18, "leaves", (new BlockOldLeaf()).func_149663_c("leaves").func_149658_d("leaves"));
/*  258 */     field_149771_c.func_148756_a(19, "sponge", (new BlockSponge()).func_149711_c(0.6F).func_149672_a(field_149779_h).func_149663_c("sponge").func_149658_d("sponge"));
/*  259 */     field_149771_c.func_148756_a(20, "glass", (new BlockGlass(Material.field_151592_s, false)).func_149711_c(0.3F).func_149672_a(field_149778_k).func_149663_c("glass").func_149658_d("glass"));
/*  260 */     field_149771_c.func_148756_a(21, "lapis_ore", (new BlockOre()).func_149711_c(3.0F).func_149752_b(5.0F).func_149672_a(field_149780_i).func_149663_c("oreLapis").func_149658_d("lapis_ore"));
/*  261 */     field_149771_c.func_148756_a(22, "lapis_block", (new BlockCompressed(MapColor.field_151652_H)).func_149711_c(3.0F).func_149752_b(5.0F).func_149672_a(field_149780_i).func_149663_c("blockLapis").func_149647_a(CreativeTabs.field_78030_b).func_149658_d("lapis_block"));
/*  262 */     field_149771_c.func_148756_a(23, "dispenser", (new BlockDispenser()).func_149711_c(3.5F).func_149672_a(field_149780_i).func_149663_c("dispenser").func_149658_d("dispenser"));
/*  263 */     Block block3 = (new BlockSandStone()).func_149672_a(field_149780_i).func_149711_c(0.8F).func_149663_c("sandStone").func_149658_d("sandstone");
/*  264 */     field_149771_c.func_148756_a(24, "sandstone", block3);
/*  265 */     field_149771_c.func_148756_a(25, "noteblock", (new BlockNote()).func_149711_c(0.8F).func_149663_c("musicBlock").func_149658_d("noteblock"));
/*  266 */     field_149771_c.func_148756_a(26, "bed", (new BlockBed()).func_149711_c(0.2F).func_149663_c("bed").func_149649_H().func_149658_d("bed"));
/*  267 */     field_149771_c.func_148756_a(27, "golden_rail", (new BlockRailPowered()).func_149711_c(0.7F).func_149672_a(field_149777_j).func_149663_c("goldenRail").func_149658_d("rail_golden"));
/*  268 */     field_149771_c.func_148756_a(28, "detector_rail", (new BlockRailDetector()).func_149711_c(0.7F).func_149672_a(field_149777_j).func_149663_c("detectorRail").func_149658_d("rail_detector"));
/*  269 */     field_149771_c.func_148756_a(29, "sticky_piston", (new BlockPistonBase(true)).func_149663_c("pistonStickyBase"));
/*  270 */     field_149771_c.func_148756_a(30, "web", (new BlockWeb()).func_149713_g(1).func_149711_c(4.0F).func_149663_c("web").func_149658_d("web"));
/*  271 */     field_149771_c.func_148756_a(31, "tallgrass", (new BlockTallGrass()).func_149711_c(0.0F).func_149672_a(field_149779_h).func_149663_c("tallgrass"));
/*  272 */     field_149771_c.func_148756_a(32, "deadbush", (new BlockDeadBush()).func_149711_c(0.0F).func_149672_a(field_149779_h).func_149663_c("deadbush").func_149658_d("deadbush"));
/*  273 */     field_149771_c.func_148756_a(33, "piston", (new BlockPistonBase(false)).func_149663_c("pistonBase"));
/*  274 */     field_149771_c.func_148756_a(34, "piston_head", new BlockPistonExtension());
/*  275 */     field_149771_c.func_148756_a(35, "wool", (new BlockColored(Material.field_151580_n)).func_149711_c(0.8F).func_149672_a(field_149775_l).func_149663_c("cloth").func_149658_d("wool_colored"));
/*  276 */     field_149771_c.func_148756_a(36, "piston_extension", new BlockPistonMoving());
/*  277 */     field_149771_c.func_148756_a(37, "yellow_flower", (new BlockFlower(0)).func_149711_c(0.0F).func_149672_a(field_149779_h).func_149663_c("flower1").func_149658_d("flower_dandelion"));
/*  278 */     field_149771_c.func_148756_a(38, "red_flower", (new BlockFlower(1)).func_149711_c(0.0F).func_149672_a(field_149779_h).func_149663_c("flower2").func_149658_d("flower_rose"));
/*  279 */     field_149771_c.func_148756_a(39, "brown_mushroom", (new BlockMushroom()).func_149711_c(0.0F).func_149672_a(field_149779_h).func_149715_a(0.125F).func_149663_c("mushroom").func_149658_d("mushroom_brown"));
/*  280 */     field_149771_c.func_148756_a(40, "red_mushroom", (new BlockMushroom()).func_149711_c(0.0F).func_149672_a(field_149779_h).func_149663_c("mushroom").func_149658_d("mushroom_red"));
/*  281 */     field_149771_c.func_148756_a(41, "gold_block", (new BlockCompressed(MapColor.field_151647_F)).func_149711_c(3.0F).func_149752_b(10.0F).func_149672_a(field_149777_j).func_149663_c("blockGold").func_149658_d("gold_block"));
/*  282 */     field_149771_c.func_148756_a(42, "iron_block", (new BlockCompressed(MapColor.field_151668_h)).func_149711_c(5.0F).func_149752_b(10.0F).func_149672_a(field_149777_j).func_149663_c("blockIron").func_149658_d("iron_block"));
/*  283 */     field_149771_c.func_148756_a(43, "double_stone_slab", (new BlockStoneSlab(true)).func_149711_c(2.0F).func_149752_b(10.0F).func_149672_a(field_149780_i).func_149663_c("stoneSlab"));
/*  284 */     field_149771_c.func_148756_a(44, "stone_slab", (new BlockStoneSlab(false)).func_149711_c(2.0F).func_149752_b(10.0F).func_149672_a(field_149780_i).func_149663_c("stoneSlab"));
/*  285 */     Block block4 = (new Block(Material.field_151576_e)).func_149711_c(2.0F).func_149752_b(10.0F).func_149672_a(field_149780_i).func_149663_c("brick").func_149647_a(CreativeTabs.field_78030_b).func_149658_d("brick");
/*  286 */     field_149771_c.func_148756_a(45, "brick_block", block4);
/*  287 */     field_149771_c.func_148756_a(46, "tnt", (new BlockTNT()).func_149711_c(0.0F).func_149672_a(field_149779_h).func_149663_c("tnt").func_149658_d("tnt"));
/*  288 */     field_149771_c.func_148756_a(47, "bookshelf", (new BlockBookshelf()).func_149711_c(1.5F).func_149672_a(field_149766_f).func_149663_c("bookshelf").func_149658_d("bookshelf"));
/*  289 */     field_149771_c.func_148756_a(48, "mossy_cobblestone", (new Block(Material.field_151576_e)).func_149711_c(2.0F).func_149752_b(10.0F).func_149672_a(field_149780_i).func_149663_c("stoneMoss").func_149647_a(CreativeTabs.field_78030_b).func_149658_d("cobblestone_mossy"));
/*  290 */     field_149771_c.func_148756_a(49, "obsidian", (new BlockObsidian()).func_149711_c(50.0F).func_149752_b(2000.0F).func_149672_a(field_149780_i).func_149663_c("obsidian").func_149658_d("obsidian"));
/*  291 */     field_149771_c.func_148756_a(50, "torch", (new BlockTorch()).func_149711_c(0.0F).func_149715_a(0.9375F).func_149672_a(field_149766_f).func_149663_c("torch").func_149658_d("torch_on"));
/*  292 */     field_149771_c.func_148756_a(51, "fire", (new BlockFire()).func_149711_c(0.0F).func_149715_a(1.0F).func_149672_a(field_149766_f).func_149663_c("fire").func_149649_H().func_149658_d("fire"));
/*  293 */     field_149771_c.func_148756_a(52, "mob_spawner", (new BlockMobSpawner()).func_149711_c(5.0F).func_149672_a(field_149777_j).func_149663_c("mobSpawner").func_149649_H().func_149658_d("mob_spawner"));
/*  294 */     field_149771_c.func_148756_a(53, "oak_stairs", (new BlockStairs(block2, 0)).func_149663_c("stairsWood"));
/*  295 */     field_149771_c.func_148756_a(54, "chest", (new BlockChest(0)).func_149711_c(2.5F).func_149672_a(field_149766_f).func_149663_c("chest"));
/*  296 */     field_149771_c.func_148756_a(55, "redstone_wire", (new BlockRedstoneWire()).func_149711_c(0.0F).func_149672_a(field_149769_e).func_149663_c("redstoneDust").func_149649_H().func_149658_d("redstone_dust"));
/*  297 */     field_149771_c.func_148756_a(56, "diamond_ore", (new BlockOre()).func_149711_c(3.0F).func_149752_b(5.0F).func_149672_a(field_149780_i).func_149663_c("oreDiamond").func_149658_d("diamond_ore"));
/*  298 */     field_149771_c.func_148756_a(57, "diamond_block", (new BlockCompressed(MapColor.field_151648_G)).func_149711_c(5.0F).func_149752_b(10.0F).func_149672_a(field_149777_j).func_149663_c("blockDiamond").func_149658_d("diamond_block"));
/*  299 */     field_149771_c.func_148756_a(58, "crafting_table", (new BlockWorkbench()).func_149711_c(2.5F).func_149672_a(field_149766_f).func_149663_c("workbench").func_149658_d("crafting_table"));
/*  300 */     field_149771_c.func_148756_a(59, "wheat", (new BlockCrops()).func_149663_c("crops").func_149658_d("wheat"));
/*  301 */     Block block5 = (new BlockFarmland()).func_149711_c(0.6F).func_149672_a(field_149767_g).func_149663_c("farmland").func_149658_d("farmland");
/*  302 */     field_149771_c.func_148756_a(60, "farmland", block5);
/*  303 */     field_149771_c.func_148756_a(61, "furnace", (new BlockFurnace(false)).func_149711_c(3.5F).func_149672_a(field_149780_i).func_149663_c("furnace").func_149647_a(CreativeTabs.field_78031_c));
/*  304 */     field_149771_c.func_148756_a(62, "lit_furnace", (new BlockFurnace(true)).func_149711_c(3.5F).func_149672_a(field_149780_i).func_149715_a(0.875F).func_149663_c("furnace"));
/*  305 */     field_149771_c.func_148756_a(63, "standing_sign", (new BlockSign(TileEntitySign.class, true)).func_149711_c(1.0F).func_149672_a(field_149766_f).func_149663_c("sign").func_149649_H());
/*  306 */     field_149771_c.func_148756_a(64, "wooden_door", (new BlockDoor(Material.field_151575_d)).func_149711_c(3.0F).func_149672_a(field_149766_f).func_149663_c("doorWood").func_149649_H().func_149658_d("door_wood"));
/*  307 */     field_149771_c.func_148756_a(65, "ladder", (new BlockLadder()).func_149711_c(0.4F).func_149672_a(field_149774_o).func_149663_c("ladder").func_149658_d("ladder"));
/*  308 */     field_149771_c.func_148756_a(66, "rail", (new BlockRail()).func_149711_c(0.7F).func_149672_a(field_149777_j).func_149663_c("rail").func_149658_d("rail_normal"));
/*  309 */     field_149771_c.func_148756_a(67, "stone_stairs", (new BlockStairs(block1, 0)).func_149663_c("stairsStone"));
/*  310 */     field_149771_c.func_148756_a(68, "wall_sign", (new BlockSign(TileEntitySign.class, false)).func_149711_c(1.0F).func_149672_a(field_149766_f).func_149663_c("sign").func_149649_H());
/*  311 */     field_149771_c.func_148756_a(69, "lever", (new BlockLever()).func_149711_c(0.5F).func_149672_a(field_149766_f).func_149663_c("lever").func_149658_d("lever"));
/*  312 */     field_149771_c.func_148756_a(70, "stone_pressure_plate", (new BlockPressurePlate("stone", Material.field_151576_e, BlockPressurePlate.Sensitivity.mobs)).func_149711_c(0.5F).func_149672_a(field_149780_i).func_149663_c("pressurePlate"));
/*  313 */     field_149771_c.func_148756_a(71, "iron_door", (new BlockDoor(Material.field_151573_f)).func_149711_c(5.0F).func_149672_a(field_149777_j).func_149663_c("doorIron").func_149649_H().func_149658_d("door_iron"));
/*  314 */     field_149771_c.func_148756_a(72, "wooden_pressure_plate", (new BlockPressurePlate("planks_oak", Material.field_151575_d, BlockPressurePlate.Sensitivity.everything)).func_149711_c(0.5F).func_149672_a(field_149766_f).func_149663_c("pressurePlate"));
/*  315 */     field_149771_c.func_148756_a(73, "redstone_ore", (new BlockRedstoneOre(false)).func_149711_c(3.0F).func_149752_b(5.0F).func_149672_a(field_149780_i).func_149663_c("oreRedstone").func_149647_a(CreativeTabs.field_78030_b).func_149658_d("redstone_ore"));
/*  316 */     field_149771_c.func_148756_a(74, "lit_redstone_ore", (new BlockRedstoneOre(true)).func_149715_a(0.625F).func_149711_c(3.0F).func_149752_b(5.0F).func_149672_a(field_149780_i).func_149663_c("oreRedstone").func_149658_d("redstone_ore"));
/*  317 */     field_149771_c.func_148756_a(75, "unlit_redstone_torch", (new BlockRedstoneTorch(false)).func_149711_c(0.0F).func_149672_a(field_149766_f).func_149663_c("notGate").func_149658_d("redstone_torch_off"));
/*  318 */     field_149771_c.func_148756_a(76, "redstone_torch", (new BlockRedstoneTorch(true)).func_149711_c(0.0F).func_149715_a(0.5F).func_149672_a(field_149766_f).func_149663_c("notGate").func_149647_a(CreativeTabs.field_78028_d).func_149658_d("redstone_torch_on"));
/*  319 */     field_149771_c.func_148756_a(77, "stone_button", (new BlockButtonStone()).func_149711_c(0.5F).func_149672_a(field_149780_i).func_149663_c("button"));
/*  320 */     field_149771_c.func_148756_a(78, "snow_layer", (new BlockSnow()).func_149711_c(0.1F).func_149672_a(field_149773_n).func_149663_c("snow").func_149713_g(0).func_149658_d("snow"));
/*  321 */     field_149771_c.func_148756_a(79, "ice", (new BlockIce()).func_149711_c(0.5F).func_149713_g(3).func_149672_a(field_149778_k).func_149663_c("ice").func_149658_d("ice"));
/*  322 */     field_149771_c.func_148756_a(80, "snow", (new BlockSnowBlock()).func_149711_c(0.2F).func_149672_a(field_149773_n).func_149663_c("snow").func_149658_d("snow"));
/*  323 */     field_149771_c.func_148756_a(81, "cactus", (new BlockCactus()).func_149711_c(0.4F).func_149672_a(field_149775_l).func_149663_c("cactus").func_149658_d("cactus"));
/*  324 */     field_149771_c.func_148756_a(82, "clay", (new BlockClay()).func_149711_c(0.6F).func_149672_a(field_149767_g).func_149663_c("clay").func_149658_d("clay"));
/*  325 */     field_149771_c.func_148756_a(83, "reeds", (new BlockReed()).func_149711_c(0.0F).func_149672_a(field_149779_h).func_149663_c("reeds").func_149649_H().func_149658_d("reeds"));
/*  326 */     field_149771_c.func_148756_a(84, "jukebox", (new BlockJukebox()).func_149711_c(2.0F).func_149752_b(10.0F).func_149672_a(field_149780_i).func_149663_c("jukebox").func_149658_d("jukebox"));
/*  327 */     field_149771_c.func_148756_a(85, "fence", (new BlockFence("planks_oak", Material.field_151575_d)).func_149711_c(2.0F).func_149752_b(5.0F).func_149672_a(field_149766_f).func_149663_c("fence"));
/*  328 */     Block block6 = (new BlockPumpkin(false)).func_149711_c(1.0F).func_149672_a(field_149766_f).func_149663_c("pumpkin").func_149658_d("pumpkin");
/*  329 */     field_149771_c.func_148756_a(86, "pumpkin", block6);
/*  330 */     field_149771_c.func_148756_a(87, "netherrack", (new BlockNetherrack()).func_149711_c(0.4F).func_149672_a(field_149780_i).func_149663_c("hellrock").func_149658_d("netherrack"));
/*  331 */     field_149771_c.func_148756_a(88, "soul_sand", (new BlockSoulSand()).func_149711_c(0.5F).func_149672_a(field_149776_m).func_149663_c("hellsand").func_149658_d("soul_sand"));
/*  332 */     field_149771_c.func_148756_a(89, "glowstone", (new BlockGlowstone(Material.field_151592_s)).func_149711_c(0.3F).func_149672_a(field_149778_k).func_149715_a(1.0F).func_149663_c("lightgem").func_149658_d("glowstone"));
/*  333 */     field_149771_c.func_148756_a(90, "portal", (new BlockPortal()).func_149711_c(-1.0F).func_149672_a(field_149778_k).func_149715_a(0.75F).func_149663_c("portal").func_149658_d("portal"));
/*  334 */     field_149771_c.func_148756_a(91, "lit_pumpkin", (new BlockPumpkin(true)).func_149711_c(1.0F).func_149672_a(field_149766_f).func_149715_a(1.0F).func_149663_c("litpumpkin").func_149658_d("pumpkin"));
/*  335 */     field_149771_c.func_148756_a(92, "cake", (new BlockCake()).func_149711_c(0.5F).func_149672_a(field_149775_l).func_149663_c("cake").func_149649_H().func_149658_d("cake"));
/*  336 */     field_149771_c.func_148756_a(93, "unpowered_repeater", (new BlockRedstoneRepeater(false)).func_149711_c(0.0F).func_149672_a(field_149766_f).func_149663_c("diode").func_149649_H().func_149658_d("repeater_off"));
/*  337 */     field_149771_c.func_148756_a(94, "powered_repeater", (new BlockRedstoneRepeater(true)).func_149711_c(0.0F).func_149715_a(0.625F).func_149672_a(field_149766_f).func_149663_c("diode").func_149649_H().func_149658_d("repeater_on"));
/*  338 */     field_149771_c.func_148756_a(95, "stained_glass", (new BlockStainedGlass(Material.field_151592_s)).func_149711_c(0.3F).func_149672_a(field_149778_k).func_149663_c("stainedGlass").func_149658_d("glass"));
/*  339 */     field_149771_c.func_148756_a(96, "trapdoor", (new BlockTrapDoor(Material.field_151575_d)).func_149711_c(3.0F).func_149672_a(field_149766_f).func_149663_c("trapdoor").func_149649_H().func_149658_d("trapdoor"));
/*  340 */     field_149771_c.func_148756_a(97, "monster_egg", (new BlockSilverfish()).func_149711_c(0.75F).func_149663_c("monsterStoneEgg"));
/*  341 */     Block block7 = (new BlockStoneBrick()).func_149711_c(1.5F).func_149752_b(10.0F).func_149672_a(field_149780_i).func_149663_c("stonebricksmooth").func_149658_d("stonebrick");
/*  342 */     field_149771_c.func_148756_a(98, "stonebrick", block7);
/*  343 */     field_149771_c.func_148756_a(99, "brown_mushroom_block", (new BlockHugeMushroom(Material.field_151575_d, 0)).func_149711_c(0.2F).func_149672_a(field_149766_f).func_149663_c("mushroom").func_149658_d("mushroom_block"));
/*  344 */     field_149771_c.func_148756_a(100, "red_mushroom_block", (new BlockHugeMushroom(Material.field_151575_d, 1)).func_149711_c(0.2F).func_149672_a(field_149766_f).func_149663_c("mushroom").func_149658_d("mushroom_block"));
/*  345 */     field_149771_c.func_148756_a(101, "iron_bars", (new BlockPane("iron_bars", "iron_bars", Material.field_151573_f, true)).func_149711_c(5.0F).func_149752_b(10.0F).func_149672_a(field_149777_j).func_149663_c("fenceIron"));
/*  346 */     field_149771_c.func_148756_a(102, "glass_pane", (new BlockPane("glass", "glass_pane_top", Material.field_151592_s, false)).func_149711_c(0.3F).func_149672_a(field_149778_k).func_149663_c("thinGlass"));
/*  347 */     Block block8 = (new BlockMelon()).func_149711_c(1.0F).func_149672_a(field_149766_f).func_149663_c("melon").func_149658_d("melon");
/*  348 */     field_149771_c.func_148756_a(103, "melon_block", block8);
/*  349 */     field_149771_c.func_148756_a(104, "pumpkin_stem", (new BlockStem(block6)).func_149711_c(0.0F).func_149672_a(field_149766_f).func_149663_c("pumpkinStem").func_149658_d("pumpkin_stem"));
/*  350 */     field_149771_c.func_148756_a(105, "melon_stem", (new BlockStem(block8)).func_149711_c(0.0F).func_149672_a(field_149766_f).func_149663_c("pumpkinStem").func_149658_d("melon_stem"));
/*  351 */     field_149771_c.func_148756_a(106, "vine", (new BlockVine()).func_149711_c(0.2F).func_149672_a(field_149779_h).func_149663_c("vine").func_149658_d("vine"));
/*  352 */     field_149771_c.func_148756_a(107, "fence_gate", (new BlockFenceGate()).func_149711_c(2.0F).func_149752_b(5.0F).func_149672_a(field_149766_f).func_149663_c("fenceGate"));
/*  353 */     field_149771_c.func_148756_a(108, "brick_stairs", (new BlockStairs(block4, 0)).func_149663_c("stairsBrick"));
/*  354 */     field_149771_c.func_148756_a(109, "stone_brick_stairs", (new BlockStairs(block7, 0)).func_149663_c("stairsStoneBrickSmooth"));
/*  355 */     field_149771_c.func_148756_a(110, "mycelium", (new BlockMycelium()).func_149711_c(0.6F).func_149672_a(field_149779_h).func_149663_c("mycel").func_149658_d("mycelium"));
/*  356 */     field_149771_c.func_148756_a(111, "waterlily", (new BlockLilyPad()).func_149711_c(0.0F).func_149672_a(field_149779_h).func_149663_c("waterlily").func_149658_d("waterlily"));
/*  357 */     Block block9 = (new Block(Material.field_151576_e)).func_149711_c(2.0F).func_149752_b(10.0F).func_149672_a(field_149780_i).func_149663_c("netherBrick").func_149647_a(CreativeTabs.field_78030_b).func_149658_d("nether_brick");
/*  358 */     field_149771_c.func_148756_a(112, "nether_brick", block9);
/*  359 */     field_149771_c.func_148756_a(113, "nether_brick_fence", (new BlockFence("nether_brick", Material.field_151576_e)).func_149711_c(2.0F).func_149752_b(10.0F).func_149672_a(field_149780_i).func_149663_c("netherFence"));
/*  360 */     field_149771_c.func_148756_a(114, "nether_brick_stairs", (new BlockStairs(block9, 0)).func_149663_c("stairsNetherBrick"));
/*  361 */     field_149771_c.func_148756_a(115, "nether_wart", (new BlockNetherWart()).func_149663_c("netherStalk").func_149658_d("nether_wart"));
/*  362 */     field_149771_c.func_148756_a(116, "enchanting_table", (new BlockEnchantmentTable()).func_149711_c(5.0F).func_149752_b(2000.0F).func_149663_c("enchantmentTable").func_149658_d("enchanting_table"));
/*  363 */     field_149771_c.func_148756_a(117, "brewing_stand", (new BlockBrewingStand()).func_149711_c(0.5F).func_149715_a(0.125F).func_149663_c("brewingStand").func_149658_d("brewing_stand"));
/*  364 */     field_149771_c.func_148756_a(118, "cauldron", (new BlockCauldron()).func_149711_c(2.0F).func_149663_c("cauldron").func_149658_d("cauldron"));
/*  365 */     field_149771_c.func_148756_a(119, "end_portal", (new BlockEndPortal(Material.field_151567_E)).func_149711_c(-1.0F).func_149752_b(6000000.0F));
/*  366 */     field_149771_c.func_148756_a(120, "end_portal_frame", (new BlockEndPortalFrame()).func_149672_a(field_149778_k).func_149715_a(0.125F).func_149711_c(-1.0F).func_149663_c("endPortalFrame").func_149752_b(6000000.0F).func_149647_a(CreativeTabs.field_78031_c).func_149658_d("endframe"));
/*  367 */     field_149771_c.func_148756_a(121, "end_stone", (new Block(Material.field_151576_e)).func_149711_c(3.0F).func_149752_b(15.0F).func_149672_a(field_149780_i).func_149663_c("whiteStone").func_149647_a(CreativeTabs.field_78030_b).func_149658_d("end_stone"));
/*  368 */     field_149771_c.func_148756_a(122, "dragon_egg", (new BlockDragonEgg()).func_149711_c(3.0F).func_149752_b(15.0F).func_149672_a(field_149780_i).func_149715_a(0.125F).func_149663_c("dragonEgg").func_149658_d("dragon_egg"));
/*  369 */     field_149771_c.func_148756_a(123, "redstone_lamp", (new BlockRedstoneLight(false)).func_149711_c(0.3F).func_149672_a(field_149778_k).func_149663_c("redstoneLight").func_149647_a(CreativeTabs.field_78028_d).func_149658_d("redstone_lamp_off"));
/*  370 */     field_149771_c.func_148756_a(124, "lit_redstone_lamp", (new BlockRedstoneLight(true)).func_149711_c(0.3F).func_149672_a(field_149778_k).func_149663_c("redstoneLight").func_149658_d("redstone_lamp_on"));
/*  371 */     field_149771_c.func_148756_a(125, "double_wooden_slab", (new BlockWoodSlab(true)).func_149711_c(2.0F).func_149752_b(5.0F).func_149672_a(field_149766_f).func_149663_c("woodSlab"));
/*  372 */     field_149771_c.func_148756_a(126, "wooden_slab", (new BlockWoodSlab(false)).func_149711_c(2.0F).func_149752_b(5.0F).func_149672_a(field_149766_f).func_149663_c("woodSlab"));
/*  373 */     field_149771_c.func_148756_a(127, "cocoa", (new BlockCocoa()).func_149711_c(0.2F).func_149752_b(5.0F).func_149672_a(field_149766_f).func_149663_c("cocoa").func_149658_d("cocoa"));
/*  374 */     field_149771_c.func_148756_a(128, "sandstone_stairs", (new BlockStairs(block3, 0)).func_149663_c("stairsSandStone"));
/*  375 */     field_149771_c.func_148756_a(129, "emerald_ore", (new BlockOre()).func_149711_c(3.0F).func_149752_b(5.0F).func_149672_a(field_149780_i).func_149663_c("oreEmerald").func_149658_d("emerald_ore"));
/*  376 */     field_149771_c.func_148756_a(130, "ender_chest", (new BlockEnderChest()).func_149711_c(22.5F).func_149752_b(1000.0F).func_149672_a(field_149780_i).func_149663_c("enderChest").func_149715_a(0.5F));
/*  377 */     field_149771_c.func_148756_a(131, "tripwire_hook", (new BlockTripWireHook()).func_149663_c("tripWireSource").func_149658_d("trip_wire_source"));
/*  378 */     field_149771_c.func_148756_a(132, "tripwire", (new BlockTripWire()).func_149663_c("tripWire").func_149658_d("trip_wire"));
/*  379 */     field_149771_c.func_148756_a(133, "emerald_block", (new BlockCompressed(MapColor.field_151653_I)).func_149711_c(5.0F).func_149752_b(10.0F).func_149672_a(field_149777_j).func_149663_c("blockEmerald").func_149658_d("emerald_block"));
/*  380 */     field_149771_c.func_148756_a(134, "spruce_stairs", (new BlockStairs(block2, 1)).func_149663_c("stairsWoodSpruce"));
/*  381 */     field_149771_c.func_148756_a(135, "birch_stairs", (new BlockStairs(block2, 2)).func_149663_c("stairsWoodBirch"));
/*  382 */     field_149771_c.func_148756_a(136, "jungle_stairs", (new BlockStairs(block2, 3)).func_149663_c("stairsWoodJungle"));
/*  383 */     field_149771_c.func_148756_a(137, "command_block", (new BlockCommandBlock()).func_149722_s().func_149752_b(6000000.0F).func_149663_c("commandBlock").func_149658_d("command_block"));
/*  384 */     field_149771_c.func_148756_a(138, "beacon", (new BlockBeacon()).func_149663_c("beacon").func_149715_a(1.0F).func_149658_d("beacon"));
/*  385 */     field_149771_c.func_148756_a(139, "cobblestone_wall", (new BlockWall(block1)).func_149663_c("cobbleWall"));
/*  386 */     field_149771_c.func_148756_a(140, "flower_pot", (new BlockFlowerPot()).func_149711_c(0.0F).func_149672_a(field_149769_e).func_149663_c("flowerPot").func_149658_d("flower_pot"));
/*  387 */     field_149771_c.func_148756_a(141, "carrots", (new BlockCarrot()).func_149663_c("carrots").func_149658_d("carrots"));
/*  388 */     field_149771_c.func_148756_a(142, "potatoes", (new BlockPotato()).func_149663_c("potatoes").func_149658_d("potatoes"));
/*  389 */     field_149771_c.func_148756_a(143, "wooden_button", (new BlockButtonWood()).func_149711_c(0.5F).func_149672_a(field_149766_f).func_149663_c("button"));
/*  390 */     field_149771_c.func_148756_a(144, "skull", (new BlockSkull()).func_149711_c(1.0F).func_149672_a(field_149780_i).func_149663_c("skull").func_149658_d("skull"));
/*  391 */     field_149771_c.func_148756_a(145, "anvil", (new BlockAnvil()).func_149711_c(5.0F).func_149672_a(field_149788_p).func_149752_b(2000.0F).func_149663_c("anvil"));
/*  392 */     field_149771_c.func_148756_a(146, "trapped_chest", (new BlockChest(1)).func_149711_c(2.5F).func_149672_a(field_149766_f).func_149663_c("chestTrap"));
/*  393 */     field_149771_c.func_148756_a(147, "light_weighted_pressure_plate", (new BlockPressurePlateWeighted("gold_block", Material.field_151573_f, 15)).func_149711_c(0.5F).func_149672_a(field_149766_f).func_149663_c("weightedPlate_light"));
/*  394 */     field_149771_c.func_148756_a(148, "heavy_weighted_pressure_plate", (new BlockPressurePlateWeighted("iron_block", Material.field_151573_f, 150)).func_149711_c(0.5F).func_149672_a(field_149766_f).func_149663_c("weightedPlate_heavy"));
/*  395 */     field_149771_c.func_148756_a(149, "unpowered_comparator", (new BlockRedstoneComparator(false)).func_149711_c(0.0F).func_149672_a(field_149766_f).func_149663_c("comparator").func_149649_H().func_149658_d("comparator_off"));
/*  396 */     field_149771_c.func_148756_a(150, "powered_comparator", (new BlockRedstoneComparator(true)).func_149711_c(0.0F).func_149715_a(0.625F).func_149672_a(field_149766_f).func_149663_c("comparator").func_149649_H().func_149658_d("comparator_on"));
/*  397 */     field_149771_c.func_148756_a(151, "daylight_detector", (new BlockDaylightDetector()).func_149711_c(0.2F).func_149672_a(field_149766_f).func_149663_c("daylightDetector").func_149658_d("daylight_detector"));
/*  398 */     field_149771_c.func_148756_a(152, "redstone_block", (new BlockCompressedPowered(MapColor.field_151656_f)).func_149711_c(5.0F).func_149752_b(10.0F).func_149672_a(field_149777_j).func_149663_c("blockRedstone").func_149658_d("redstone_block"));
/*  399 */     field_149771_c.func_148756_a(153, "quartz_ore", (new BlockOre()).func_149711_c(3.0F).func_149752_b(5.0F).func_149672_a(field_149780_i).func_149663_c("netherquartz").func_149658_d("quartz_ore"));
/*  400 */     field_149771_c.func_148756_a(154, "hopper", (new BlockHopper()).func_149711_c(3.0F).func_149752_b(8.0F).func_149672_a(field_149766_f).func_149663_c("hopper").func_149658_d("hopper"));
/*  401 */     Block block10 = (new BlockQuartz()).func_149672_a(field_149780_i).func_149711_c(0.8F).func_149663_c("quartzBlock").func_149658_d("quartz_block");
/*  402 */     field_149771_c.func_148756_a(155, "quartz_block", block10);
/*  403 */     field_149771_c.func_148756_a(156, "quartz_stairs", (new BlockStairs(block10, 0)).func_149663_c("stairsQuartz"));
/*  404 */     field_149771_c.func_148756_a(157, "activator_rail", (new BlockRailPowered()).func_149711_c(0.7F).func_149672_a(field_149777_j).func_149663_c("activatorRail").func_149658_d("rail_activator"));
/*  405 */     field_149771_c.func_148756_a(158, "dropper", (new BlockDropper()).func_149711_c(3.5F).func_149672_a(field_149780_i).func_149663_c("dropper").func_149658_d("dropper"));
/*  406 */     field_149771_c.func_148756_a(159, "stained_hardened_clay", (new BlockColored(Material.field_151576_e)).func_149711_c(1.25F).func_149752_b(7.0F).func_149672_a(field_149780_i).func_149663_c("clayHardenedStained").func_149658_d("hardened_clay_stained"));
/*  407 */     field_149771_c.func_148756_a(160, "stained_glass_pane", (new BlockStainedGlassPane()).func_149711_c(0.3F).func_149672_a(field_149778_k).func_149663_c("thinStainedGlass").func_149658_d("glass"));
/*  408 */     field_149771_c.func_148756_a(161, "leaves2", (new BlockNewLeaf()).func_149663_c("leaves").func_149658_d("leaves"));
/*  409 */     field_149771_c.func_148756_a(162, "log2", (new BlockNewLog()).func_149663_c("log").func_149658_d("log"));
/*  410 */     field_149771_c.func_148756_a(163, "acacia_stairs", (new BlockStairs(block2, 4)).func_149663_c("stairsWoodAcacia"));
/*  411 */     field_149771_c.func_148756_a(164, "dark_oak_stairs", (new BlockStairs(block2, 5)).func_149663_c("stairsWoodDarkOak"));
/*      */ 
/*      */ 
/*      */     
/*  415 */     field_149771_c.func_148756_a(170, "hay_block", (new BlockHay()).func_149711_c(0.5F).func_149672_a(field_149779_h).func_149663_c("hayBlock").func_149647_a(CreativeTabs.field_78030_b).func_149658_d("hay_block"));
/*  416 */     field_149771_c.func_148756_a(171, "carpet", (new BlockCarpet()).func_149711_c(0.1F).func_149672_a(field_149775_l).func_149663_c("woolCarpet").func_149713_g(0));
/*  417 */     field_149771_c.func_148756_a(172, "hardened_clay", (new BlockHardenedClay()).func_149711_c(1.25F).func_149752_b(7.0F).func_149672_a(field_149780_i).func_149663_c("clayHardened").func_149658_d("hardened_clay"));
/*  418 */     field_149771_c.func_148756_a(173, "coal_block", (new Block(Material.field_151576_e)).func_149711_c(5.0F).func_149752_b(10.0F).func_149672_a(field_149780_i).func_149663_c("blockCoal").func_149647_a(CreativeTabs.field_78030_b).func_149658_d("coal_block"));
/*  419 */     field_149771_c.func_148756_a(174, "packed_ice", (new BlockPackedIce()).func_149711_c(0.5F).func_149672_a(field_149778_k).func_149663_c("icePacked").func_149658_d("ice_packed"));
/*  420 */     field_149771_c.func_148756_a(175, "double_plant", new BlockDoublePlant());
/*      */ 
/*      */ 
/*      */     
/*  424 */     for (Block block : field_149771_c) {
/*  425 */       if (block.field_149764_J == Material.field_151579_a) {
/*  426 */         block.field_149783_u = false;
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  431 */       boolean bool1 = false;
/*  432 */       boolean bool2 = (block.func_149645_b() == 10) ? true : false;
/*  433 */       boolean bool3 = block instanceof BlockSlab;
/*  434 */       boolean bool4 = (block == block5) ? true : false;
/*  435 */       boolean bool5 = block.field_149785_s;
/*  436 */       boolean bool6 = (block.field_149786_r == 0) ? true : false;
/*  437 */       if (bool2 || bool3 || bool4 || bool5 || bool6) {
/*  438 */         bool1 = true;
/*      */       }
/*      */       
/*  441 */       block.field_149783_u = bool1;
/*      */     } 
/*      */   }
/*      */   protected boolean field_149791_x = true;
/*      */   protected boolean field_149790_y = true;
/*      */   protected boolean field_149789_z;
/*      */   protected boolean field_149758_A;
/*      */   protected double field_149759_B;
/*      */   protected double field_149760_C;
/*      */   protected double field_149754_D;
/*      */   protected double field_149755_E;
/*      */   protected double field_149756_F;
/*      */   protected double field_149757_G;
/*  454 */   public SoundType field_149762_H = field_149769_e;
/*      */   
/*  456 */   public float field_149763_I = 1.0F;
/*      */   protected final Material field_149764_J;
/*  458 */   public float field_149765_K = 0.6F; private String field_149770_b;
/*      */   @SideOnly(Side.CLIENT)
/*      */   protected IIcon field_149761_L;
/*      */   private static final String __OBFID = "CL_00000199";
/*      */   
/*      */   protected Block(Material p_i45394_1_) {
/*  464 */     this.field_149764_J = p_i45394_1_;
/*  465 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*  466 */     this.field_149787_q = func_149662_c();
/*  467 */     this.field_149786_r = func_149662_c() ? 255 : 0;
/*  468 */     this.field_149785_s = !p_i45394_1_.func_76228_b();
/*      */   }
/*      */   
/*      */   public Block func_149672_a(SoundType p_149672_1_) {
/*  472 */     this.field_149762_H = p_149672_1_;
/*  473 */     return this;
/*      */   }
/*      */   
/*      */   public Block func_149713_g(int p_149713_1_) {
/*  477 */     this.field_149786_r = p_149713_1_;
/*  478 */     return this;
/*      */   }
/*      */   
/*      */   public Block func_149715_a(float p_149715_1_) {
/*  482 */     this.field_149784_t = (int)(15.0F * p_149715_1_);
/*  483 */     return this;
/*      */   }
/*      */   
/*      */   public Block func_149752_b(float p_149752_1_) {
/*  487 */     this.field_149781_w = p_149752_1_ * 3.0F;
/*  488 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean func_149637_q() {
/*  496 */     return (this.field_149764_J.func_76230_c() && func_149686_d());
/*      */   }
/*      */   
/*      */   public boolean func_149721_r() {
/*  500 */     return (this.field_149764_J.func_76218_k() && func_149686_d() && !func_149744_f());
/*      */   }
/*      */   
/*      */   public boolean func_149686_d() {
/*  504 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
/*  508 */     return !this.field_149764_J.func_76230_c();
/*      */   }
/*      */   
/*      */   public int func_149645_b() {
/*  512 */     return 0;
/*      */   }
/*      */   
/*      */   public Block func_149711_c(float p_149711_1_) {
/*  516 */     this.field_149782_v = p_149711_1_;
/*  517 */     if (this.field_149781_w < p_149711_1_ * 5.0F) this.field_149781_w = p_149711_1_ * 5.0F; 
/*  518 */     return this;
/*      */   }
/*      */   
/*      */   public Block func_149722_s() {
/*  522 */     func_149711_c(-1.0F);
/*  523 */     return this;
/*      */   }
/*      */   
/*      */   public float func_149712_f(World p_149712_1_, int p_149712_2_, int p_149712_3_, int p_149712_4_) {
/*  527 */     return this.field_149782_v;
/*      */   }
/*      */   
/*      */   public Block func_149675_a(boolean p_149675_1_) {
/*  531 */     this.field_149789_z = p_149675_1_;
/*  532 */     return this;
/*      */   }
/*      */   
/*      */   public boolean func_149653_t() {
/*  536 */     return this.field_149789_z;
/*      */   }
/*      */   
/*      */   public boolean func_149716_u() {
/*  540 */     return this.field_149758_A;
/*      */   }
/*      */   
/*      */   public final void func_149676_a(float p_149676_1_, float p_149676_2_, float p_149676_3_, float p_149676_4_, float p_149676_5_, float p_149676_6_) {
/*  544 */     this.field_149759_B = p_149676_1_;
/*  545 */     this.field_149760_C = p_149676_2_;
/*  546 */     this.field_149754_D = p_149676_3_;
/*  547 */     this.field_149755_E = p_149676_4_;
/*  548 */     this.field_149756_F = p_149676_5_;
/*  549 */     this.field_149757_G = p_149676_6_;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int func_149677_c(IBlockAccess p_149677_1_, int p_149677_2_, int p_149677_3_, int p_149677_4_) {
/*  553 */     Block block = p_149677_1_.func_147439_a(p_149677_2_, p_149677_3_, p_149677_4_);
/*  554 */     int i = p_149677_1_.func_72802_i(p_149677_2_, p_149677_3_, p_149677_4_, block.func_149750_m());
/*      */ 
/*      */     
/*  557 */     if (i == 0 && block instanceof BlockSlab) {
/*  558 */       p_149677_3_--;
/*  559 */       block = p_149677_1_.func_147439_a(p_149677_2_, p_149677_3_, p_149677_4_);
/*  560 */       return p_149677_1_.func_72802_i(p_149677_2_, p_149677_3_, p_149677_4_, block.func_149750_m());
/*      */     } 
/*  562 */     return i;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/*  566 */     if (p_149646_5_ == 0 && this.field_149760_C > 0.0D) return true; 
/*  567 */     if (p_149646_5_ == 1 && this.field_149756_F < 1.0D) return true; 
/*  568 */     if (p_149646_5_ == 2 && this.field_149754_D > 0.0D) return true; 
/*  569 */     if (p_149646_5_ == 3 && this.field_149757_G < 1.0D) return true; 
/*  570 */     if (p_149646_5_ == 4 && this.field_149759_B > 0.0D) return true; 
/*  571 */     if (p_149646_5_ == 5 && this.field_149755_E < 1.0D) return true; 
/*  572 */     return !p_149646_1_.func_147439_a(p_149646_2_, p_149646_3_, p_149646_4_).func_149662_c();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_149747_d(IBlockAccess p_149747_1_, int p_149747_2_, int p_149747_3_, int p_149747_4_, int p_149747_5_) {
/*  577 */     return p_149747_1_.func_147439_a(p_149747_2_, p_149747_3_, p_149747_4_).func_149688_o().func_76220_a();
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public IIcon func_149673_e(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_) {
/*  581 */     return func_149691_a(p_149673_5_, p_149673_1_.func_72805_g(p_149673_2_, p_149673_3_, p_149673_4_));
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  585 */     return this.field_149761_L;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public final IIcon func_149733_h(int p_149733_1_) {
/*  589 */     return func_149691_a(p_149733_1_, 0);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public AxisAlignedBB func_149633_g(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
/*  593 */     return AxisAlignedBB.func_72330_a(p_149633_2_ + this.field_149759_B, p_149633_3_ + this.field_149760_C, p_149633_4_ + this.field_149754_D, p_149633_2_ + this.field_149755_E, p_149633_3_ + this.field_149756_F, p_149633_4_ + this.field_149757_G);
/*      */   }
/*      */   
/*      */   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List<AxisAlignedBB> p_149743_6_, Entity p_149743_7_) {
/*  597 */     AxisAlignedBB axisAlignedBB = func_149668_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_);
/*  598 */     if (axisAlignedBB != null && p_149743_5_.func_72326_a(axisAlignedBB)) p_149743_6_.add(axisAlignedBB); 
/*      */   }
/*      */   
/*      */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  602 */     return AxisAlignedBB.func_72330_a(p_149668_2_ + this.field_149759_B, p_149668_3_ + this.field_149760_C, p_149668_4_ + this.field_149754_D, p_149668_2_ + this.field_149755_E, p_149668_3_ + this.field_149756_F, p_149668_4_ + this.field_149757_G);
/*      */   }
/*      */   
/*      */   public boolean func_149662_c() {
/*  606 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_149678_a(int p_149678_1_, boolean p_149678_2_) {
/*  610 */     return func_149703_v();
/*      */   }
/*      */   
/*      */   public boolean func_149703_v() {
/*  614 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {}
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {}
/*      */ 
/*      */   
/*      */   public void func_149664_b(World p_149664_1_, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_) {}
/*      */ 
/*      */   
/*      */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {}
/*      */ 
/*      */   
/*      */   public int func_149738_a(World p_149738_1_) {
/*  633 */     return 10;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {}
/*      */ 
/*      */   
/*      */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {}
/*      */   
/*      */   public int func_149745_a(Random p_149745_1_) {
/*  643 */     return 1;
/*      */   }
/*      */   
/*      */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*  647 */     return Item.func_150898_a(this);
/*      */   }
/*      */   
/*      */   public float func_149737_a(EntityPlayer p_149737_1_, World p_149737_2_, int p_149737_3_, int p_149737_4_, int p_149737_5_) {
/*  651 */     float f = func_149712_f(p_149737_2_, p_149737_3_, p_149737_4_, p_149737_5_);
/*  652 */     if (f < 0.0F) return 0.0F; 
/*  653 */     if (!p_149737_1_.func_146099_a(this)) {
/*  654 */       return p_149737_1_.func_146096_a(this, false) / f / 100.0F;
/*      */     }
/*  656 */     return p_149737_1_.func_146096_a(this, true) / f / 30.0F;
/*      */   }
/*      */   
/*      */   public final void func_149697_b(World p_149697_1_, int p_149697_2_, int p_149697_3_, int p_149697_4_, int p_149697_5_, int p_149697_6_) {
/*  660 */     func_149690_a(p_149697_1_, p_149697_2_, p_149697_3_, p_149697_4_, p_149697_5_, 1.0F, p_149697_6_);
/*      */   }
/*      */   
/*      */   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
/*  664 */     if (p_149690_1_.field_72995_K)
/*  665 */       return;  int i = func_149679_a(p_149690_7_, p_149690_1_.field_73012_v);
/*  666 */     for (byte b = 0; b < i; b++) {
/*  667 */       if (p_149690_1_.field_73012_v.nextFloat() <= p_149690_6_) {
/*  668 */         Item item = func_149650_a(p_149690_5_, p_149690_1_.field_73012_v, p_149690_7_);
/*  669 */         if (item != null)
/*      */         {
/*  671 */           func_149642_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(item, 1, func_149692_a(p_149690_5_))); } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   protected void func_149642_a(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {
/*  676 */     if (p_149642_1_.field_72995_K || !p_149642_1_.func_82736_K().func_82766_b("doTileDrops"))
/*      */       return; 
/*  678 */     float f = 0.7F;
/*  679 */     double d1 = (p_149642_1_.field_73012_v.nextFloat() * f) + (1.0F - f) * 0.5D;
/*  680 */     double d2 = (p_149642_1_.field_73012_v.nextFloat() * f) + (1.0F - f) * 0.5D;
/*  681 */     double d3 = (p_149642_1_.field_73012_v.nextFloat() * f) + (1.0F - f) * 0.5D;
/*  682 */     EntityItem entityItem = new EntityItem(p_149642_1_, p_149642_2_ + d1, p_149642_3_ + d2, p_149642_4_ + d3, p_149642_5_);
/*  683 */     entityItem.field_145804_b = 10;
/*  684 */     p_149642_1_.func_72838_d((Entity)entityItem);
/*      */   }
/*      */   
/*      */   public void func_149657_c(World p_149657_1_, int p_149657_2_, int p_149657_3_, int p_149657_4_, int p_149657_5_) {
/*  688 */     if (!p_149657_1_.field_72995_K) {
/*  689 */       while (p_149657_5_ > 0) {
/*  690 */         int i = EntityXPOrb.func_70527_a(p_149657_5_);
/*  691 */         p_149657_5_ -= i;
/*  692 */         p_149657_1_.func_72838_d((Entity)new EntityXPOrb(p_149657_1_, p_149657_2_ + 0.5D, p_149657_3_ + 0.5D, p_149657_4_ + 0.5D, i));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int func_149692_a(int p_149692_1_) {
/*  704 */     return 0;
/*      */   }
/*      */   
/*      */   public float func_149638_a(Entity p_149638_1_) {
/*  708 */     return this.field_149781_w / 5.0F;
/*      */   }
/*      */   
/*      */   public MovingObjectPosition func_149731_a(World p_149731_1_, int p_149731_2_, int p_149731_3_, int p_149731_4_, Vec3 p_149731_5_, Vec3 p_149731_6_) {
/*  712 */     func_149719_a((IBlockAccess)p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_);
/*      */     
/*  714 */     p_149731_5_ = p_149731_5_.func_72441_c(-p_149731_2_, -p_149731_3_, -p_149731_4_);
/*  715 */     p_149731_6_ = p_149731_6_.func_72441_c(-p_149731_2_, -p_149731_3_, -p_149731_4_);
/*      */     
/*  717 */     Vec3 vec31 = p_149731_5_.func_72429_b(p_149731_6_, this.field_149759_B);
/*  718 */     Vec3 vec32 = p_149731_5_.func_72429_b(p_149731_6_, this.field_149755_E);
/*      */     
/*  720 */     Vec3 vec33 = p_149731_5_.func_72435_c(p_149731_6_, this.field_149760_C);
/*  721 */     Vec3 vec34 = p_149731_5_.func_72435_c(p_149731_6_, this.field_149756_F);
/*      */     
/*  723 */     Vec3 vec35 = p_149731_5_.func_72434_d(p_149731_6_, this.field_149754_D);
/*  724 */     Vec3 vec36 = p_149731_5_.func_72434_d(p_149731_6_, this.field_149757_G);
/*      */     
/*  726 */     if (!func_149654_a(vec31)) vec31 = null; 
/*  727 */     if (!func_149654_a(vec32)) vec32 = null; 
/*  728 */     if (!func_149687_b(vec33)) vec33 = null; 
/*  729 */     if (!func_149687_b(vec34)) vec34 = null; 
/*  730 */     if (!func_149661_c(vec35)) vec35 = null; 
/*  731 */     if (!func_149661_c(vec36)) vec36 = null;
/*      */     
/*  733 */     Vec3 vec37 = null;
/*      */     
/*  735 */     if (vec31 != null && (vec37 == null || p_149731_5_.func_72436_e(vec31) < p_149731_5_.func_72436_e(vec37))) vec37 = vec31; 
/*  736 */     if (vec32 != null && (vec37 == null || p_149731_5_.func_72436_e(vec32) < p_149731_5_.func_72436_e(vec37))) vec37 = vec32; 
/*  737 */     if (vec33 != null && (vec37 == null || p_149731_5_.func_72436_e(vec33) < p_149731_5_.func_72436_e(vec37))) vec37 = vec33; 
/*  738 */     if (vec34 != null && (vec37 == null || p_149731_5_.func_72436_e(vec34) < p_149731_5_.func_72436_e(vec37))) vec37 = vec34; 
/*  739 */     if (vec35 != null && (vec37 == null || p_149731_5_.func_72436_e(vec35) < p_149731_5_.func_72436_e(vec37))) vec37 = vec35; 
/*  740 */     if (vec36 != null && (vec37 == null || p_149731_5_.func_72436_e(vec36) < p_149731_5_.func_72436_e(vec37))) vec37 = vec36;
/*      */     
/*  742 */     if (vec37 == null) return null;
/*      */     
/*  744 */     byte b = -1;
/*      */     
/*  746 */     if (vec37 == vec31) b = 4; 
/*  747 */     if (vec37 == vec32) b = 5; 
/*  748 */     if (vec37 == vec33) b = 0; 
/*  749 */     if (vec37 == vec34) b = 1; 
/*  750 */     if (vec37 == vec35) b = 2; 
/*  751 */     if (vec37 == vec36) b = 3;
/*      */     
/*  753 */     return new MovingObjectPosition(p_149731_2_, p_149731_3_, p_149731_4_, b, vec37.func_72441_c(p_149731_2_, p_149731_3_, p_149731_4_));
/*      */   }
/*      */   
/*      */   private boolean func_149654_a(Vec3 p_149654_1_) {
/*  757 */     if (p_149654_1_ == null) return false; 
/*  758 */     return (p_149654_1_.field_72448_b >= this.field_149760_C && p_149654_1_.field_72448_b <= this.field_149756_F && p_149654_1_.field_72449_c >= this.field_149754_D && p_149654_1_.field_72449_c <= this.field_149757_G);
/*      */   }
/*      */   
/*      */   private boolean func_149687_b(Vec3 p_149687_1_) {
/*  762 */     if (p_149687_1_ == null) return false; 
/*  763 */     return (p_149687_1_.field_72450_a >= this.field_149759_B && p_149687_1_.field_72450_a <= this.field_149755_E && p_149687_1_.field_72449_c >= this.field_149754_D && p_149687_1_.field_72449_c <= this.field_149757_G);
/*      */   }
/*      */   
/*      */   private boolean func_149661_c(Vec3 p_149661_1_) {
/*  767 */     if (p_149661_1_ == null) return false; 
/*  768 */     return (p_149661_1_.field_72450_a >= this.field_149759_B && p_149661_1_.field_72450_a <= this.field_149755_E && p_149661_1_.field_72448_b >= this.field_149760_C && p_149661_1_.field_72448_b <= this.field_149756_F);
/*      */   }
/*      */   
/*      */   public void func_149723_a(World p_149723_1_, int p_149723_2_, int p_149723_3_, int p_149723_4_, Explosion p_149723_5_) {}
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int func_149701_w() {
/*  775 */     return 0;
/*      */   }
/*      */   
/*      */   public boolean func_149705_a(World p_149705_1_, int p_149705_2_, int p_149705_3_, int p_149705_4_, int p_149705_5_, ItemStack p_149705_6_) {
/*  779 */     return func_149707_d(p_149705_1_, p_149705_2_, p_149705_3_, p_149705_4_, p_149705_5_);
/*      */   }
/*      */   
/*      */   public boolean func_149707_d(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_) {
/*  783 */     return func_149742_c(p_149707_1_, p_149707_2_, p_149707_3_, p_149707_4_);
/*      */   }
/*      */   
/*      */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/*  787 */     return (p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_, p_149742_4_)).field_149764_J.func_76222_j();
/*      */   }
/*      */   
/*      */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/*  791 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_149724_b(World p_149724_1_, int p_149724_2_, int p_149724_3_, int p_149724_4_, Entity p_149724_5_) {}
/*      */   
/*      */   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
/*  798 */     return p_149660_9_;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_149699_a(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_149640_a(World p_149640_1_, int p_149640_2_, int p_149640_3_, int p_149640_4_, Entity p_149640_5_, Vec3 p_149640_6_) {}
/*      */ 
/*      */   
/*      */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {}
/*      */ 
/*      */   
/*      */   public final double func_149704_x() {
/*  814 */     return this.field_149759_B;
/*      */   }
/*      */   
/*      */   public final double func_149753_y() {
/*  818 */     return this.field_149755_E;
/*      */   }
/*      */   
/*      */   public final double func_149665_z() {
/*  822 */     return this.field_149760_C;
/*      */   }
/*      */   
/*      */   public final double func_149669_A() {
/*  826 */     return this.field_149756_F;
/*      */   }
/*      */   
/*      */   public final double func_149706_B() {
/*  830 */     return this.field_149754_D;
/*      */   }
/*      */   
/*      */   public final double func_149693_C() {
/*  834 */     return this.field_149757_G;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int func_149635_D() {
/*  838 */     return 16777215;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int func_149741_i(int p_149741_1_) {
/*  842 */     return 16777215;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
/*  846 */     return 16777215;
/*      */   }
/*      */   
/*      */   public int func_149709_b(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_) {
/*  850 */     return 0;
/*      */   }
/*      */   
/*      */   public boolean func_149744_f() {
/*  854 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {}
/*      */   
/*      */   public int func_149748_c(IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_, int p_149748_5_) {
/*  861 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_149683_g() {}
/*      */   
/*      */   public void func_149636_a(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
/*  868 */     p_149636_2_.func_71064_a(StatList.field_75934_C[func_149682_b(this)], 1);
/*  869 */     p_149636_2_.func_71020_j(0.025F);
/*      */     
/*  871 */     if (func_149700_E() && EnchantmentHelper.func_77502_d((EntityLivingBase)p_149636_2_)) {
/*  872 */       ItemStack itemStack = func_149644_j(p_149636_6_);
/*  873 */       if (itemStack != null) {
/*  874 */         func_149642_a(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, itemStack);
/*      */       }
/*      */     } else {
/*  877 */       int i = EnchantmentHelper.func_77517_e((EntityLivingBase)p_149636_2_);
/*  878 */       func_149697_b(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_, i);
/*      */     } 
/*      */   }
/*      */   
/*      */   protected boolean func_149700_E() {
/*  883 */     return (func_149686_d() && !this.field_149758_A);
/*      */   }
/*      */   
/*      */   protected ItemStack func_149644_j(int p_149644_1_) {
/*  887 */     int i = 0;
/*  888 */     Item item = Item.func_150898_a(this);
/*  889 */     if (item != null && item.func_77614_k()) {
/*  890 */       i = p_149644_1_;
/*      */     }
/*  892 */     return new ItemStack(item, 1, i);
/*      */   }
/*      */   
/*      */   public int func_149679_a(int p_149679_1_, Random p_149679_2_) {
/*  896 */     return func_149745_a(p_149679_2_);
/*      */   }
/*      */   
/*      */   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
/*  900 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {}
/*      */ 
/*      */   
/*      */   public void func_149714_e(World p_149714_1_, int p_149714_2_, int p_149714_3_, int p_149714_4_, int p_149714_5_) {}
/*      */ 
/*      */   
/*      */   public Block func_149663_c(String p_149663_1_) {
/*  911 */     this.field_149770_b = p_149663_1_;
/*  912 */     return this;
/*      */   }
/*      */   
/*      */   public String func_149732_F() {
/*  916 */     return StatCollector.func_74838_a(func_149739_a() + ".name");
/*      */   }
/*      */ 
/*      */   
/*      */   public String func_149739_a() {
/*  921 */     return "tile." + this.field_149770_b;
/*      */   }
/*      */   
/*      */   public boolean func_149696_a(World p_149696_1_, int p_149696_2_, int p_149696_3_, int p_149696_4_, int p_149696_5_, int p_149696_6_) {
/*  925 */     return false;
/*      */   }
/*      */   
/*      */   public boolean func_149652_G() {
/*  929 */     return this.field_149790_y;
/*      */   }
/*      */   
/*      */   protected Block func_149649_H() {
/*  933 */     this.field_149790_y = false;
/*  934 */     return this;
/*      */   }
/*      */   
/*      */   public int func_149656_h() {
/*  938 */     return this.field_149764_J.func_76227_m();
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public float func_149685_I() {
/*  942 */     return func_149637_q() ? 0.2F : 1.0F;
/*      */   }
/*      */   
/*      */   public void func_149746_a(World p_149746_1_, int p_149746_2_, int p_149746_3_, int p_149746_4_, Entity p_149746_5_, float p_149746_6_) {}
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/*  949 */     return Item.func_150898_a(this);
/*      */   }
/*      */   
/*      */   public int func_149643_k(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
/*  953 */     return func_149692_a(p_149643_1_.func_72805_g(p_149643_2_, p_149643_3_, p_149643_4_));
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/*  957 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public CreativeTabs func_149708_J() {
/*  961 */     return this.field_149772_a;
/*      */   }
/*      */   
/*      */   public Block func_149647_a(CreativeTabs p_149647_1_) {
/*  965 */     this.field_149772_a = p_149647_1_;
/*  966 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_149681_a(World p_149681_1_, int p_149681_2_, int p_149681_3_, int p_149681_4_, int p_149681_5_, EntityPlayer p_149681_6_) {}
/*      */ 
/*      */   
/*      */   public void func_149725_f(World p_149725_1_, int p_149725_2_, int p_149725_3_, int p_149725_4_, int p_149725_5_) {}
/*      */ 
/*      */   
/*      */   public void func_149639_l(World p_149639_1_, int p_149639_2_, int p_149639_3_, int p_149639_4_) {}
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean func_149648_K() {
/*  982 */     return false;
/*      */   }
/*      */   
/*      */   public boolean func_149698_L() {
/*  986 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_149659_a(Explosion p_149659_1_) {
/*  990 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_149667_c(Block p_149667_1_) {
/*  994 */     return (this == p_149667_1_);
/*      */   }
/*      */   
/*      */   public static boolean func_149680_a(Block p_149680_0_, Block p_149680_1_) {
/*  998 */     if (p_149680_0_ == null || p_149680_1_ == null) {
/*  999 */       return false;
/*      */     }
/* 1001 */     if (p_149680_0_ == p_149680_1_) {
/* 1002 */       return true;
/*      */     }
/* 1004 */     return p_149680_0_.func_149667_c(p_149680_1_);
/*      */   }
/*      */   
/*      */   public boolean func_149740_M() {
/* 1008 */     return false;
/*      */   }
/*      */   
/*      */   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
/* 1012 */     return 0;
/*      */   }
/*      */   
/*      */   public Block func_149658_d(String p_149658_1_) {
/* 1016 */     this.field_149768_d = p_149658_1_;
/* 1017 */     return this;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   protected String func_149641_N() {
/* 1021 */     return (this.field_149768_d == null) ? ("MISSING_ICON_BLOCK_" + func_149682_b(this) + "_" + this.field_149770_b) : this.field_149768_d;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public IIcon func_149735_b(int p_149735_1_, int p_149735_2_) {
/* 1025 */     return func_149691_a(p_149735_1_, p_149735_2_);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 1029 */     this.field_149761_L = p_149651_1_.func_94245_a(func_149641_N());
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public String func_149702_O() {
/* 1033 */     return null;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\Block.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */