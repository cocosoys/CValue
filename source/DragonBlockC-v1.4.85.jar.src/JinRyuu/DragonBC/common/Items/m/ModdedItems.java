/*     */ package JinRyuu.DragonBC.common.Items.m;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraftforge.common.util.EnumHelper;
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
/*     */ public final class ModdedItems
/*     */ {
/*     */   public static Item SakuraStick;
/*     */   public static Item MahagonyStick;
/*     */   public static Item MapleStick;
/*     */   public static Item SakuraBranch;
/*     */   public static Item MahagonyBranch;
/*     */   public static MySwords SakuraHammer;
/*     */   public static MyPickaxes SakuraPickaxe;
/*     */   public static MyAxes SakuraAxe;
/*     */   public static MySwords SakuraSword;
/*     */   public static MyHoes SakuraHoe;
/*     */   public static MyShovels SakuraShovel;
/*     */   public static MyPickaxes MahagonyPickaxe;
/*     */   public static MyAxes MahagonyAxe;
/*     */   public static MySwords MahagonySword;
/*     */   public static MyHoes MahagonyHoe;
/*     */   public static MyShovels MahagonyShovel;
/*     */   public static MyPickaxes MaplePickaxe;
/*     */   public static MyAxes MapleAxe;
/*     */   public static MySwords MapleSword;
/*     */   public static MyHoes MapleHoe;
/*     */   public static MyShovels MapleShovel;
/*  41 */   public static Item.ToolMaterial Sakura = EnumHelper.addToolMaterial("Sakura", 1, 175, 5.0F, 1.5F, 7);
/*  42 */   public static Item.ToolMaterial Mahagony = EnumHelper.addToolMaterial("Mahagony", 2, 230, 7.0F, 2.5F, 10);
/*  43 */   public static Item.ToolMaterial Maple = EnumHelper.addToolMaterial("Maple", 2, 450, 8.0F, 3.5F, 14);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void init() {
/*  50 */     SakuraStick = (new Item()).func_77655_b("Sakura_Stick").func_77637_a(mod_DragonBC.DragonBlockC).func_111206_d(JRMCoreH.tjdbcAssts + ":Sakura_Stick");
/*  51 */     MahagonyStick = (new Item()).func_77655_b("Mahagony_Stick").func_77637_a(mod_DragonBC.DragonBlockC).func_111206_d(JRMCoreH.tjdbcAssts + ":Mahagony_Stick");
/*  52 */     MapleStick = (new Item()).func_77655_b("Maple_Stick").func_77637_a(mod_DragonBC.DragonBlockC).func_111206_d(JRMCoreH.tjdbcAssts + ":Maple_Stick");
/*     */     
/*  54 */     SakuraBranch = (new Item()).func_77655_b("Sakura_Branch").func_77637_a(mod_DragonBC.DragonBlockC).func_111206_d(JRMCoreH.tjdbcAssts + ":Sakura_Branch");
/*  55 */     MahagonyBranch = (new Item()).func_77655_b("Mahagony_Branch").func_77637_a(mod_DragonBC.DragonBlockC).func_111206_d(JRMCoreH.tjdbcAssts + ":Mahagony_Branch");
/*     */     
/*  57 */     SakuraPickaxe = new MyPickaxes("Sakura_Pickaxe", Sakura);
/*  58 */     SakuraAxe = new MyAxes("Sakura_Axe", Sakura);
/*  59 */     SakuraSword = new MySwords("Sakura_Sword", Sakura);
/*  60 */     SakuraAxe = new MyAxes("Sakura_Axe", Sakura);
/*  61 */     SakuraShovel = new MyShovels("Sakura_Shovel", Sakura);
/*  62 */     SakuraHoe = new MyHoes("Sakura_Hoe", Sakura);
/*  63 */     SakuraHammer = new MySwords("Sakura_Hammer", Sakura);
/*     */     
/*  65 */     MahagonyPickaxe = new MyPickaxes("Mahagony_Pickaxe", Mahagony);
/*  66 */     MahagonyAxe = new MyAxes("Mahagony_Axe", Mahagony);
/*  67 */     MahagonySword = new MySwords("Mahagony_Sword", Mahagony);
/*  68 */     MahagonyAxe = new MyAxes("Mahagony_Axe", Mahagony);
/*  69 */     MahagonyShovel = new MyShovels("Mahagony_Shovel", Mahagony);
/*  70 */     MahagonyHoe = new MyHoes("Mahagony_Hoe", Mahagony);
/*     */     
/*  72 */     MaplePickaxe = new MyPickaxes("Maple_Pickaxe", Maple);
/*  73 */     MapleAxe = new MyAxes("Maple_Axe", Maple);
/*  74 */     MapleSword = new MySwords("Maple_Sword", Maple);
/*  75 */     MapleAxe = new MyAxes("Maple_Axe", Maple);
/*  76 */     MapleShovel = new MyShovels("Maple_Shovel", Maple);
/*  77 */     MapleHoe = new MyHoes("Maple_Hoe", Maple);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     GameRegistry.registerItem(SakuraStick, "Sakura_Stick");
/*  85 */     GameRegistry.registerItem(MahagonyStick, "Mahagony_Stick");
/*  86 */     GameRegistry.registerItem(MapleStick, "Maple_Stick");
/*     */     
/*  88 */     GameRegistry.registerItem(SakuraBranch, "Sakura_Branch");
/*  89 */     GameRegistry.registerItem(MahagonyBranch, "Mahagony_Branch");
/*     */ 
/*     */     
/*  92 */     GameRegistry.registerItem((Item)SakuraPickaxe, "Sakura_Pickaxe");
/*  93 */     GameRegistry.registerItem((Item)SakuraAxe, "Sakura_Axe");
/*  94 */     GameRegistry.registerItem((Item)SakuraShovel, "Sakura_Shovel");
/*  95 */     GameRegistry.registerItem((Item)SakuraHoe, "Sakura_Hoe");
/*  96 */     GameRegistry.registerItem((Item)SakuraSword, "Sakura_Sword");
/*  97 */     GameRegistry.registerItem((Item)SakuraHammer, "Sakura_Hammer");
/*     */     
/*  99 */     GameRegistry.registerItem((Item)MahagonyPickaxe, "Mahagony_Pickaxe");
/* 100 */     GameRegistry.registerItem((Item)MahagonyAxe, "Mahagony_Axe");
/* 101 */     GameRegistry.registerItem((Item)MahagonyShovel, "Mahagony_Shovel");
/* 102 */     GameRegistry.registerItem((Item)MahagonyHoe, "Mahagony_Hoe");
/* 103 */     GameRegistry.registerItem((Item)MahagonySword, "Mahagony_Sword");
/*     */     
/* 105 */     GameRegistry.registerItem((Item)MaplePickaxe, "Maple_Pickaxe");
/* 106 */     GameRegistry.registerItem((Item)MapleAxe, "Maple_Axe");
/* 107 */     GameRegistry.registerItem((Item)MapleShovel, "Maple_Shovel");
/* 108 */     GameRegistry.registerItem((Item)MapleHoe, "Maple_Hoe");
/* 109 */     GameRegistry.registerItem((Item)MapleSword, "Maple_Sword");
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\m\ModdedItems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */