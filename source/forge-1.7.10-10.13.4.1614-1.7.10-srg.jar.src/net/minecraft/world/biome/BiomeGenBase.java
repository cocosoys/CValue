/*     */ package net.minecraft.world.biome;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFlower;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.NoiseGeneratorPerlin;
/*     */ import net.minecraft.world.gen.feature.WorldGenAbstractTree;
/*     */ import net.minecraft.world.gen.feature.WorldGenBigTree;
/*     */ import net.minecraft.world.gen.feature.WorldGenDoublePlant;
/*     */ import net.minecraft.world.gen.feature.WorldGenSwamp;
/*     */ import net.minecraft.world.gen.feature.WorldGenTrees;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ 
/*     */ public abstract class BiomeGenBase {
/*  24 */   private static final Logger field_150586_aC = LogManager.getLogger();
/*     */   
/*     */   public enum TempCategory {
/*  27 */     OCEAN, COLD, MEDIUM, WARM;
/*     */     private static final String __OBFID = "CL_00000160";
/*     */   }
/*     */   
/*     */   public static class Height {
/*     */     public float field_150777_a;
/*     */     public float field_150776_b;
/*     */     private static final String __OBFID = "CL_00000159";
/*     */     
/*     */     public Height(float p_i45371_1_, float p_i45371_2_) {
/*  37 */       this.field_150777_a = p_i45371_1_;
/*  38 */       this.field_150776_b = p_i45371_2_;
/*     */     }
/*     */     
/*     */     public Height func_150775_a() {
/*  42 */       return new Height(this.field_150777_a * 0.8F, this.field_150776_b * 0.6F);
/*     */     }
/*     */   }
/*     */   
/*  46 */   protected static final Height field_150596_a = new Height(0.1F, 0.2F);
/*  47 */   protected static final Height field_150594_b = new Height(-0.5F, 0.0F);
/*  48 */   protected static final Height field_150595_c = new Height(-1.0F, 0.1F);
/*  49 */   protected static final Height field_150592_d = new Height(-1.8F, 0.1F);
/*  50 */   protected static final Height field_150593_e = new Height(0.125F, 0.05F);
/*  51 */   protected static final Height field_150590_f = new Height(0.2F, 0.2F);
/*  52 */   protected static final Height field_150591_g = new Height(0.45F, 0.3F);
/*  53 */   protected static final Height field_150602_h = new Height(1.5F, 0.025F);
/*  54 */   protected static final Height field_150603_i = new Height(1.0F, 0.5F);
/*  55 */   protected static final Height field_150600_j = new Height(0.0F, 0.025F);
/*  56 */   protected static final Height field_150601_k = new Height(0.1F, 0.8F);
/*  57 */   protected static final Height field_150598_l = new Height(0.2F, 0.3F);
/*  58 */   protected static final Height field_150599_m = new Height(-0.2F, 0.1F);
/*     */   
/*  60 */   private static final BiomeGenBase[] field_76773_a = new BiomeGenBase[256];
/*  61 */   public static final Set field_150597_n = Sets.newHashSet();
/*     */   
/*  63 */   public static final BiomeGenBase field_76771_b = (new BiomeGenOcean(0)).func_76739_b(112).func_76735_a("Ocean").func_150570_a(field_150595_c);
/*  64 */   public static final BiomeGenBase field_76772_c = (new BiomeGenPlains(1)).func_76739_b(9286496).func_76735_a("Plains");
/*  65 */   public static final BiomeGenBase field_76769_d = (new BiomeGenDesert(2)).func_76739_b(16421912).func_76735_a("Desert").func_76745_m().func_76732_a(2.0F, 0.0F).func_150570_a(field_150593_e);
/*     */   
/*  67 */   public static final BiomeGenBase field_76770_e = (new BiomeGenHills(3, false)).func_76739_b(6316128).func_76735_a("Extreme Hills").func_150570_a(field_150603_i).func_76732_a(0.2F, 0.3F);
/*  68 */   public static final BiomeGenBase field_76767_f = (new BiomeGenForest(4, 0)).func_76739_b(353825).func_76735_a("Forest");
/*  69 */   public static final BiomeGenBase field_76768_g = (new BiomeGenTaiga(5, 0)).func_76739_b(747097).func_76735_a("Taiga").func_76733_a(5159473).func_76732_a(0.25F, 0.8F).func_150570_a(field_150590_f);
/*     */ 
/*     */   
/*  72 */   public static final BiomeGenBase field_76780_h = (new BiomeGenSwamp(6)).func_76739_b(522674).func_76735_a("Swampland").func_76733_a(9154376).func_150570_a(field_150599_m).func_76732_a(0.8F, 0.9F);
/*  73 */   public static final BiomeGenBase field_76781_i = (new BiomeGenRiver(7)).func_76739_b(255).func_76735_a("River").func_150570_a(field_150594_b);
/*     */   
/*  75 */   public static final BiomeGenBase field_76778_j = (new BiomeGenHell(8)).func_76739_b(16711680).func_76735_a("Hell").func_76745_m().func_76732_a(2.0F, 0.0F);
/*  76 */   public static final BiomeGenBase field_76779_k = (new BiomeGenEnd(9)).func_76739_b(8421631).func_76735_a("Sky").func_76745_m();
/*     */   
/*  78 */   public static final BiomeGenBase field_76776_l = (new BiomeGenOcean(10)).func_76739_b(9474208).func_76735_a("FrozenOcean").func_76742_b().func_150570_a(field_150595_c).func_76732_a(0.0F, 0.5F);
/*  79 */   public static final BiomeGenBase field_76777_m = (new BiomeGenRiver(11)).func_76739_b(10526975).func_76735_a("FrozenRiver").func_76742_b().func_150570_a(field_150594_b).func_76732_a(0.0F, 0.5F);
/*  80 */   public static final BiomeGenBase field_76774_n = (new BiomeGenSnow(12, false)).func_76739_b(16777215).func_76735_a("Ice Plains").func_76742_b().func_76732_a(0.0F, 0.5F).func_150570_a(field_150593_e);
/*  81 */   public static final BiomeGenBase field_76775_o = (new BiomeGenSnow(13, false)).func_76739_b(10526880).func_76735_a("Ice Mountains").func_76742_b().func_150570_a(field_150591_g).func_76732_a(0.0F, 0.5F);
/*     */ 
/*     */   
/*  84 */   public static final BiomeGenBase field_76789_p = (new BiomeGenMushroomIsland(14)).func_76739_b(16711935).func_76735_a("MushroomIsland").func_76732_a(0.9F, 1.0F).func_150570_a(field_150598_l);
/*  85 */   public static final BiomeGenBase field_76788_q = (new BiomeGenMushroomIsland(15)).func_76739_b(10486015).func_76735_a("MushroomIslandShore").func_76732_a(0.9F, 1.0F).func_150570_a(field_150600_j);
/*     */   
/*  87 */   public static final BiomeGenBase field_76787_r = (new BiomeGenBeach(16)).func_76739_b(16440917).func_76735_a("Beach").func_76732_a(0.8F, 0.4F).func_150570_a(field_150600_j);
/*  88 */   public static final BiomeGenBase field_76786_s = (new BiomeGenDesert(17)).func_76739_b(13786898).func_76735_a("DesertHills").func_76745_m().func_76732_a(2.0F, 0.0F).func_150570_a(field_150591_g);
/*  89 */   public static final BiomeGenBase field_76785_t = (new BiomeGenForest(18, 0)).func_76739_b(2250012).func_76735_a("ForestHills").func_150570_a(field_150591_g);
/*  90 */   public static final BiomeGenBase field_76784_u = (new BiomeGenTaiga(19, 0)).func_76739_b(1456435).func_76735_a("TaigaHills").func_76733_a(5159473).func_76732_a(0.25F, 0.8F).func_150570_a(field_150591_g);
/*     */   
/*  92 */   public static final BiomeGenBase field_76783_v = (new BiomeGenHills(20, true)).func_76739_b(7501978).func_76735_a("Extreme Hills Edge").func_150570_a(field_150603_i.func_150775_a()).func_76732_a(0.2F, 0.3F);
/*     */ 
/*     */   
/*  95 */   public static final BiomeGenBase field_76782_w = (new BiomeGenJungle(21, false)).func_76739_b(5470985).func_76735_a("Jungle").func_76733_a(5470985).func_76732_a(0.95F, 0.9F);
/*  96 */   public static final BiomeGenBase field_76792_x = (new BiomeGenJungle(22, false)).func_76739_b(2900485).func_76735_a("JungleHills").func_76733_a(5470985).func_76732_a(0.95F, 0.9F).func_150570_a(field_150591_g);
/*     */   
/*  98 */   public static final BiomeGenBase field_150574_L = (new BiomeGenJungle(23, true)).func_76739_b(6458135).func_76735_a("JungleEdge").func_76733_a(5470985).func_76732_a(0.95F, 0.8F);
/*     */   
/* 100 */   public static final BiomeGenBase field_150575_M = (new BiomeGenOcean(24)).func_76739_b(48).func_76735_a("Deep Ocean").func_150570_a(field_150592_d);
/* 101 */   public static final BiomeGenBase field_150576_N = (new BiomeGenStoneBeach(25)).func_76739_b(10658436).func_76735_a("Stone Beach").func_76732_a(0.2F, 0.3F).func_150570_a(field_150601_k);
/* 102 */   public static final BiomeGenBase field_150577_O = (new BiomeGenBeach(26)).func_76739_b(16445632).func_76735_a("Cold Beach").func_76732_a(0.05F, 0.3F).func_150570_a(field_150600_j).func_76742_b();
/*     */   
/* 104 */   public static final BiomeGenBase field_150583_P = (new BiomeGenForest(27, 2)).func_76735_a("Birch Forest").func_76739_b(3175492);
/* 105 */   public static final BiomeGenBase field_150582_Q = (new BiomeGenForest(28, 2)).func_76735_a("Birch Forest Hills").func_76739_b(2055986).func_150570_a(field_150591_g);
/* 106 */   public static final BiomeGenBase field_150585_R = (new BiomeGenForest(29, 3)).func_76739_b(4215066).func_76735_a("Roofed Forest");
/*     */   
/* 108 */   public static final BiomeGenBase field_150584_S = (new BiomeGenTaiga(30, 0)).func_76739_b(3233098).func_76735_a("Cold Taiga").func_76733_a(5159473).func_76742_b().func_76732_a(-0.5F, 0.4F).func_150570_a(field_150590_f).func_150563_c(16777215);
/*     */   
/* 110 */   public static final BiomeGenBase field_150579_T = (new BiomeGenTaiga(31, 0)).func_76739_b(2375478).func_76735_a("Cold Taiga Hills").func_76733_a(5159473).func_76742_b().func_76732_a(-0.5F, 0.4F).func_150570_a(field_150591_g).func_150563_c(16777215);
/*     */   
/* 112 */   public static final BiomeGenBase field_150578_U = (new BiomeGenTaiga(32, 1)).func_76739_b(5858897).func_76735_a("Mega Taiga").func_76733_a(5159473).func_76732_a(0.3F, 0.8F).func_150570_a(field_150590_f);
/*     */   
/* 114 */   public static final BiomeGenBase field_150581_V = (new BiomeGenTaiga(33, 1)).func_76739_b(4542270).func_76735_a("Mega Taiga Hills").func_76733_a(5159473).func_76732_a(0.3F, 0.8F).func_150570_a(field_150591_g);
/*     */ 
/*     */   
/* 117 */   public static final BiomeGenBase field_150580_W = (new BiomeGenHills(34, true)).func_76739_b(5271632).func_76735_a("Extreme Hills+").func_150570_a(field_150603_i).func_76732_a(0.2F, 0.3F);
/*     */ 
/*     */   
/* 120 */   public static final BiomeGenBase field_150588_X = (new BiomeGenSavanna(35)).func_76739_b(12431967).func_76735_a("Savanna").func_76732_a(1.2F, 0.0F).func_76745_m().func_150570_a(field_150593_e);
/* 121 */   public static final BiomeGenBase field_150587_Y = (new BiomeGenSavanna(36)).func_76739_b(10984804).func_76735_a("Savanna Plateau").func_76732_a(1.0F, 0.0F).func_76745_m().func_150570_a(field_150602_h);
/*     */   
/* 123 */   public static final BiomeGenBase field_150589_Z = (new BiomeGenMesa(37, false, false)).func_76739_b(14238997).func_76735_a("Mesa");
/* 124 */   public static final BiomeGenBase field_150607_aa = (new BiomeGenMesa(38, false, true)).func_76739_b(11573093).func_76735_a("Mesa Plateau F").func_150570_a(field_150602_h);
/* 125 */   public static final BiomeGenBase field_150608_ab = (new BiomeGenMesa(39, false, false)).func_76739_b(13274213).func_76735_a("Mesa Plateau").func_150570_a(field_150602_h);
/*     */ 
/*     */   
/*     */   static {
/* 129 */     field_76772_c.func_150566_k();
/* 130 */     field_76769_d.func_150566_k();
/* 131 */     field_76767_f.func_150566_k();
/* 132 */     field_76768_g.func_150566_k();
/* 133 */     field_76780_h.func_150566_k();
/* 134 */     field_76774_n.func_150566_k();
/* 135 */     field_76782_w.func_150566_k();
/* 136 */     field_150574_L.func_150566_k();
/* 137 */     field_150584_S.func_150566_k();
/* 138 */     field_150588_X.func_150566_k();
/* 139 */     field_150587_Y.func_150566_k();
/* 140 */     field_150589_Z.func_150566_k();
/* 141 */     field_150607_aa.func_150566_k();
/* 142 */     field_150608_ab.func_150566_k();
/* 143 */     field_150583_P.func_150566_k();
/* 144 */     field_150582_Q.func_150566_k();
/* 145 */     field_150585_R.func_150566_k();
/* 146 */     field_150578_U.func_150566_k();
/* 147 */     field_76770_e.func_150566_k();
/* 148 */     field_150580_W.func_150566_k();
/*     */ 
/*     */     
/* 151 */     field_76773_a[field_150581_V.field_76756_M + 128] = field_76773_a[field_150578_U.field_76756_M + 128];
/*     */     
/* 153 */     for (BiomeGenBase biomeGenBase : field_76773_a) {
/* 154 */       if (biomeGenBase != null && biomeGenBase.field_76756_M < 128) {
/* 155 */         field_150597_n.add(biomeGenBase);
/*     */       }
/*     */     } 
/*     */     
/* 159 */     field_150597_n.remove(field_76778_j);
/* 160 */     field_150597_n.remove(field_76779_k);
/* 161 */     field_150597_n.remove(field_76776_l);
/* 162 */     field_150597_n.remove(field_76783_v);
/*     */   }
/*     */   
/* 165 */   protected static final NoiseGeneratorPerlin field_150605_ac = new NoiseGeneratorPerlin(new Random(1234L), 1);
/* 166 */   protected static final NoiseGeneratorPerlin field_150606_ad = new NoiseGeneratorPerlin(new Random(2345L), 1);
/* 167 */   protected static final WorldGenDoublePlant field_150610_ae = new WorldGenDoublePlant();
/*     */   public String field_76791_y;
/*     */   public int field_76790_z;
/*     */   public int field_150609_ah;
/* 171 */   public Block field_76752_A = (Block)Blocks.field_150349_c;
/* 172 */   public int field_150604_aj = 0;
/* 173 */   public Block field_76753_B = Blocks.field_150346_d;
/* 174 */   public int field_76754_C = 5169201;
/* 175 */   public float field_76748_D = field_150596_a.field_150777_a;
/* 176 */   public float field_76749_E = field_150596_a.field_150776_b;
/* 177 */   public float field_76750_F = 0.5F;
/* 178 */   public float field_76751_G = 0.5F;
/* 179 */   public int field_76759_H = 16777215;
/*     */   
/*     */   public BiomeDecorator field_76760_I;
/*     */   
/* 183 */   protected List field_76761_J = new ArrayList();
/* 184 */   protected List field_76762_K = new ArrayList();
/* 185 */   protected List field_76755_L = new ArrayList();
/* 186 */   protected List field_82914_M = new ArrayList();
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean field_76766_R;
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean field_76765_S = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public final int field_76756_M;
/*     */ 
/*     */ 
/*     */   
/*     */   protected WorldGenTrees field_76757_N;
/*     */ 
/*     */ 
/*     */   
/*     */   protected WorldGenBigTree field_76758_O;
/*     */ 
/*     */ 
/*     */   
/*     */   protected WorldGenSwamp field_76763_Q;
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00000158";
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeDecorator func_76729_a() {
/* 218 */     return new BiomeDecorator();
/*     */   }
/*     */   
/*     */   public BiomeGenBase func_76732_a(float p_76732_1_, float p_76732_2_) {
/* 222 */     if (p_76732_1_ > 0.1F && p_76732_1_ < 0.2F) throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
/*     */     
/* 224 */     this.field_76750_F = p_76732_1_;
/* 225 */     this.field_76751_G = p_76732_2_;
/* 226 */     return this;
/*     */   }
/*     */   
/*     */   public final BiomeGenBase func_150570_a(Height p_150570_1_) {
/* 230 */     this.field_76748_D = p_150570_1_.field_150777_a;
/* 231 */     this.field_76749_E = p_150570_1_.field_150776_b;
/* 232 */     return this;
/*     */   }
/*     */   
/*     */   public BiomeGenBase func_76745_m() {
/* 236 */     this.field_76765_S = false;
/* 237 */     return this;
/*     */   }
/*     */   
/* 240 */   public BiomeGenBase(int p_i1971_1_) { this.field_76757_N = new WorldGenTrees(false);
/* 241 */     this.field_76758_O = new WorldGenBigTree(false);
/* 242 */     this.field_76763_Q = new WorldGenSwamp(); this.field_76756_M = p_i1971_1_; field_76773_a[p_i1971_1_] = this; this.field_76760_I = func_76729_a(); this.field_76762_K.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4)); this.field_76762_K.add(new SpawnListEntry(EntityPig.class, 10, 4, 4)); this.field_76762_K.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4)); this.field_76762_K.add(new SpawnListEntry(EntityCow.class, 8, 4, 4)); this.field_76761_J.add(new SpawnListEntry(EntitySpider.class, 100, 4, 4)); this.field_76761_J.add(new SpawnListEntry(EntityZombie.class, 100, 4, 4)); this.field_76761_J.add(new SpawnListEntry(EntitySkeleton.class, 100, 4, 4)); this.field_76761_J.add(new SpawnListEntry(EntityCreeper.class, 100, 4, 4)); this.field_76761_J.add(new SpawnListEntry(EntitySlime.class, 100, 4, 4)); this.field_76761_J.add(new SpawnListEntry(EntityEnderman.class, 10, 1, 4));
/*     */     this.field_76761_J.add(new SpawnListEntry(EntityWitch.class, 5, 1, 1));
/*     */     this.field_76755_L.add(new SpawnListEntry(EntitySquid.class, 10, 4, 4));
/* 245 */     this.field_82914_M.add(new SpawnListEntry(EntityBat.class, 10, 8, 8)); } public WorldGenAbstractTree func_150567_a(Random p_150567_1_) { if (p_150567_1_.nextInt(10) == 0) {
/* 246 */       return (WorldGenAbstractTree)this.field_76758_O;
/*     */     }
/* 248 */     return (WorldGenAbstractTree)this.field_76757_N; }
/*     */ 
/*     */   
/*     */   public WorldGenerator func_76730_b(Random p_76730_1_) {
/* 252 */     return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 1);
/*     */   }
/*     */   
/*     */   public String func_150572_a(Random p_150572_1_, int p_150572_2_, int p_150572_3_, int p_150572_4_) {
/* 256 */     if (p_150572_1_.nextInt(3) > 0) {
/* 257 */       return BlockFlower.field_149858_b[0];
/*     */     }
/* 259 */     return BlockFlower.field_149859_a[0];
/*     */   }
/*     */   
/*     */   public BiomeGenBase func_76742_b() {
/* 263 */     this.field_76766_R = true;
/* 264 */     return this;
/*     */   }
/*     */   
/*     */   public BiomeGenBase func_76735_a(String p_76735_1_) {
/* 268 */     this.field_76791_y = p_76735_1_;
/* 269 */     return this;
/*     */   }
/*     */   
/*     */   public BiomeGenBase func_76733_a(int p_76733_1_) {
/* 273 */     this.field_76754_C = p_76733_1_;
/* 274 */     return this;
/*     */   }
/*     */   
/*     */   public BiomeGenBase func_76739_b(int p_76739_1_) {
/* 278 */     func_150557_a(p_76739_1_, false);
/* 279 */     return this;
/*     */   }
/*     */   
/*     */   public BiomeGenBase func_150563_c(int p_150563_1_) {
/* 283 */     this.field_150609_ah = p_150563_1_;
/* 284 */     return this;
/*     */   }
/*     */   
/*     */   public BiomeGenBase func_150557_a(int p_150557_1_, boolean p_150557_2_) {
/* 288 */     this.field_76790_z = p_150557_1_;
/* 289 */     if (p_150557_2_) {
/* 290 */       this.field_150609_ah = (p_150557_1_ & 0xFEFEFE) >> 1;
/*     */     } else {
/* 292 */       this.field_150609_ah = p_150557_1_;
/*     */     } 
/* 294 */     return this;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_76731_a(float p_76731_1_) {
/* 298 */     p_76731_1_ /= 3.0F;
/* 299 */     if (p_76731_1_ < -1.0F) p_76731_1_ = -1.0F; 
/* 300 */     if (p_76731_1_ > 1.0F) p_76731_1_ = 1.0F; 
/* 301 */     return Color.getHSBColor(0.62222224F - p_76731_1_ * 0.05F, 0.5F + p_76731_1_ * 0.1F, 1.0F).getRGB();
/*     */   }
/*     */   
/*     */   public List func_76747_a(EnumCreatureType p_76747_1_) {
/* 305 */     if (p_76747_1_ == EnumCreatureType.monster) return this.field_76761_J; 
/* 306 */     if (p_76747_1_ == EnumCreatureType.creature) return this.field_76762_K; 
/* 307 */     if (p_76747_1_ == EnumCreatureType.waterCreature) return this.field_76755_L; 
/* 308 */     if (p_76747_1_ == EnumCreatureType.ambient) return this.field_82914_M; 
/* 309 */     return null;
/*     */   }
/*     */   
/*     */   public static class SpawnListEntry extends WeightedRandom.Item { public Class field_76300_b;
/*     */     public int field_76301_c;
/*     */     public int field_76299_d;
/*     */     private static final String __OBFID = "CL_00000161";
/*     */     
/*     */     public SpawnListEntry(Class p_i1970_1_, int p_i1970_2_, int p_i1970_3_, int p_i1970_4_) {
/* 318 */       super(p_i1970_2_);
/* 319 */       this.field_76300_b = p_i1970_1_;
/* 320 */       this.field_76301_c = p_i1970_3_;
/* 321 */       this.field_76299_d = p_i1970_4_;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 326 */       return this.field_76300_b.getSimpleName() + "*(" + this.field_76301_c + "-" + this.field_76299_d + "):" + this.field_76292_a;
/*     */     } }
/*     */ 
/*     */   
/*     */   public boolean func_76746_c() {
/* 331 */     return func_150559_j();
/*     */   }
/*     */   
/*     */   public boolean func_76738_d() {
/* 335 */     if (func_150559_j()) return false; 
/* 336 */     return this.field_76765_S;
/*     */   }
/*     */   
/*     */   public boolean func_76736_e() {
/* 340 */     return (this.field_76751_G > 0.85F);
/*     */   }
/*     */   
/*     */   public float func_76741_f() {
/* 344 */     return 0.1F;
/*     */   }
/*     */   
/*     */   public final int func_76744_g() {
/* 348 */     return (int)(this.field_76751_G * 65536.0F);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public final float func_76727_i() {
/* 352 */     return this.field_76751_G;
/*     */   }
/*     */   
/*     */   public final float func_150564_a(int p_150564_1_, int p_150564_2_, int p_150564_3_) {
/* 356 */     if (p_150564_2_ > 64) {
/* 357 */       float f = (float)field_150605_ac.func_151601_a(p_150564_1_ * 1.0D / 8.0D, p_150564_3_ * 1.0D / 8.0D) * 4.0F;
/* 358 */       return this.field_76750_F - (f + p_150564_2_ - 64.0F) * 0.05F / 30.0F;
/*     */     } 
/* 360 */     return this.field_76750_F;
/*     */   }
/*     */   
/*     */   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
/* 364 */     this.field_76760_I.func_150512_a(p_76728_1_, p_76728_2_, this, p_76728_3_, p_76728_4_);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_150558_b(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
/* 368 */     double d1 = MathHelper.func_76131_a(func_150564_a(p_150558_1_, p_150558_2_, p_150558_3_), 0.0F, 1.0F);
/* 369 */     double d2 = MathHelper.func_76131_a(func_76727_i(), 0.0F, 1.0F);
/*     */     
/* 371 */     return ColorizerGrass.func_77480_a(d1, d2);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_150571_c(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
/* 375 */     double d1 = MathHelper.func_76131_a(func_150564_a(p_150571_1_, p_150571_2_, p_150571_3_), 0.0F, 1.0F);
/* 376 */     double d2 = MathHelper.func_76131_a(func_76727_i(), 0.0F, 1.0F);
/*     */     
/* 378 */     return ColorizerFoliage.func_77470_a(d1, d2);
/*     */   }
/*     */   
/*     */   public boolean func_150559_j() {
/* 382 */     return this.field_76766_R;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_150573_a(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
/* 387 */     func_150560_b(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
/*     */   }
/*     */   
/*     */   public final void func_150560_b(World p_150560_1_, Random p_150560_2_, Block[] p_150560_3_, byte[] p_150560_4_, int p_150560_5_, int p_150560_6_, double p_150560_7_) {
/* 391 */     byte b = 63;
/* 392 */     Block block1 = this.field_76752_A;
/* 393 */     byte b1 = (byte)(this.field_150604_aj & 0xFF);
/* 394 */     Block block2 = this.field_76753_B;
/* 395 */     int i = -1;
/* 396 */     int j = (int)(p_150560_7_ / 3.0D + 3.0D + p_150560_2_.nextDouble() * 0.25D);
/*     */     
/* 398 */     int k = p_150560_5_ & 0xF;
/* 399 */     int m = p_150560_6_ & 0xF;
/* 400 */     int n = p_150560_3_.length / 256;
/* 401 */     for (char c = 'ÿ'; c >= '\000'; c--) {
/* 402 */       int i1 = (m * 16 + k) * n + c;
/*     */       
/* 404 */       if (c <= 0 + p_150560_2_.nextInt(5)) {
/* 405 */         p_150560_3_[i1] = Blocks.field_150357_h;
/*     */       } else {
/* 407 */         Block block = p_150560_3_[i1];
/*     */         
/* 409 */         if (block == null || block.func_149688_o() == Material.field_151579_a) {
/* 410 */           i = -1;
/* 411 */         } else if (block == Blocks.field_150348_b) {
/* 412 */           if (i == -1) {
/* 413 */             if (j <= 0) {
/* 414 */               block1 = null;
/* 415 */               b1 = 0;
/* 416 */               block2 = Blocks.field_150348_b;
/* 417 */             } else if (c >= ';' && c <= '@') {
/* 418 */               block1 = this.field_76752_A;
/* 419 */               b1 = (byte)(this.field_150604_aj & 0xFF);
/* 420 */               block2 = this.field_76753_B;
/*     */             } 
/*     */             
/* 423 */             if (c < '?' && (block1 == null || block1.func_149688_o() == Material.field_151579_a)) {
/* 424 */               if (func_150564_a(p_150560_5_, c, p_150560_6_) < 0.15F) {
/* 425 */                 block1 = Blocks.field_150432_aD;
/* 426 */                 b1 = 0;
/*     */               } else {
/* 428 */                 block1 = Blocks.field_150355_j;
/* 429 */                 b1 = 0;
/*     */               } 
/*     */             }
/*     */             
/* 433 */             i = j;
/* 434 */             if (c >= '>')
/* 435 */             { p_150560_3_[i1] = block1;
/* 436 */               p_150560_4_[i1] = b1; }
/* 437 */             else if (c < 56 - j)
/* 438 */             { block1 = null;
/* 439 */               block2 = Blocks.field_150348_b;
/* 440 */               p_150560_3_[i1] = Blocks.field_150351_n; }
/* 441 */             else { p_150560_3_[i1] = block2; } 
/* 442 */           } else if (i > 0) {
/* 443 */             i--;
/* 444 */             p_150560_3_[i1] = block2;
/*     */ 
/*     */             
/* 447 */             if (i == 0 && block2 == Blocks.field_150354_m) {
/* 448 */               i = p_150560_2_.nextInt(4) + Math.max(0, c - 63);
/* 449 */               block2 = Blocks.field_150322_A;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public BiomeGenBase func_150566_k() {
/* 458 */     return new BiomeGenMutated(this.field_76756_M + 128, this);
/*     */   }
/*     */   
/*     */   public Class func_150562_l() {
/* 462 */     return getClass();
/*     */   }
/*     */   
/*     */   public boolean func_150569_a(BiomeGenBase p_150569_1_) {
/* 466 */     if (p_150569_1_ == this) {
/* 467 */       return true;
/*     */     }
/* 469 */     if (p_150569_1_ == null) {
/* 470 */       return false;
/*     */     }
/* 472 */     return (func_150562_l() == p_150569_1_.func_150562_l());
/*     */   }
/*     */   
/*     */   public TempCategory func_150561_m() {
/* 476 */     if (this.field_76750_F < 0.2D) {
/* 477 */       return TempCategory.COLD;
/*     */     }
/* 479 */     if (this.field_76750_F < 1.0D) {
/* 480 */       return TempCategory.MEDIUM;
/*     */     }
/* 482 */     return TempCategory.WARM;
/*     */   }
/*     */   
/*     */   public static BiomeGenBase[] func_150565_n() {
/* 486 */     return field_76773_a;
/*     */   }
/*     */   
/*     */   public static BiomeGenBase func_150568_d(int p_150568_0_) {
/* 490 */     if (p_150568_0_ < 0 || p_150568_0_ > field_76773_a.length) {
/* 491 */       field_150586_aC.warn("Biome ID is out of bounds: " + p_150568_0_ + ", defaulting to 0 (Ocean)");
/* 492 */       return field_76771_b;
/*     */     } 
/* 494 */     return field_76773_a[p_150568_0_];
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeGenBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */