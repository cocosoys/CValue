/*     */ package net.minecraft.stats;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.CraftingManager;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ 
/*     */ public class StatList {
/*  18 */   protected static Map field_75942_a = new HashMap<Object, Object>();
/*     */   
/*  20 */   public static List field_75940_b = new ArrayList();
/*  21 */   public static List field_75941_c = new ArrayList();
/*  22 */   public static List field_75938_d = new ArrayList();
/*  23 */   public static List field_75939_e = new ArrayList();
/*     */   
/*  25 */   public static StatBase field_75947_j = (new StatBasic("stat.leaveGame", (IChatComponent)new ChatComponentTranslation("stat.leaveGame", new Object[0]))).func_75966_h().func_75971_g();
/*     */   
/*  27 */   public static StatBase field_75948_k = (new StatBasic("stat.playOneMinute", (IChatComponent)new ChatComponentTranslation("stat.playOneMinute", new Object[0]), StatBase.field_75981_i)).func_75966_h().func_75971_g();
/*     */   
/*  29 */   public static StatBase field_75945_l = (new StatBasic("stat.walkOneCm", (IChatComponent)new ChatComponentTranslation("stat.walkOneCm", new Object[0]), StatBase.field_75979_j)).func_75966_h().func_75971_g();
/*  30 */   public static StatBase field_75946_m = (new StatBasic("stat.swimOneCm", (IChatComponent)new ChatComponentTranslation("stat.swimOneCm", new Object[0]), StatBase.field_75979_j)).func_75966_h().func_75971_g();
/*  31 */   public static StatBase field_75943_n = (new StatBasic("stat.fallOneCm", (IChatComponent)new ChatComponentTranslation("stat.fallOneCm", new Object[0]), StatBase.field_75979_j)).func_75966_h().func_75971_g();
/*  32 */   public static StatBase field_75944_o = (new StatBasic("stat.climbOneCm", (IChatComponent)new ChatComponentTranslation("stat.climbOneCm", new Object[0]), StatBase.field_75979_j)).func_75966_h().func_75971_g();
/*  33 */   public static StatBase field_75958_p = (new StatBasic("stat.flyOneCm", (IChatComponent)new ChatComponentTranslation("stat.flyOneCm", new Object[0]), StatBase.field_75979_j)).func_75966_h().func_75971_g();
/*  34 */   public static StatBase field_75957_q = (new StatBasic("stat.diveOneCm", (IChatComponent)new ChatComponentTranslation("stat.diveOneCm", new Object[0]), StatBase.field_75979_j)).func_75966_h().func_75971_g();
/*  35 */   public static StatBase field_75956_r = (new StatBasic("stat.minecartOneCm", (IChatComponent)new ChatComponentTranslation("stat.minecartOneCm", new Object[0]), StatBase.field_75979_j)).func_75966_h().func_75971_g();
/*  36 */   public static StatBase field_75955_s = (new StatBasic("stat.boatOneCm", (IChatComponent)new ChatComponentTranslation("stat.boatOneCm", new Object[0]), StatBase.field_75979_j)).func_75966_h().func_75971_g();
/*  37 */   public static StatBase field_75954_t = (new StatBasic("stat.pigOneCm", (IChatComponent)new ChatComponentTranslation("stat.pigOneCm", new Object[0]), StatBase.field_75979_j)).func_75966_h().func_75971_g();
/*  38 */   public static StatBase field_151185_q = (new StatBasic("stat.horseOneCm", (IChatComponent)new ChatComponentTranslation("stat.horseOneCm", new Object[0]), StatBase.field_75979_j)).func_75966_h().func_75971_g();
/*     */   
/*  40 */   public static StatBase field_75953_u = (new StatBasic("stat.jump", (IChatComponent)new ChatComponentTranslation("stat.jump", new Object[0]))).func_75966_h().func_75971_g();
/*  41 */   public static StatBase field_75952_v = (new StatBasic("stat.drop", (IChatComponent)new ChatComponentTranslation("stat.drop", new Object[0]))).func_75966_h().func_75971_g();
/*     */   
/*  43 */   public static StatBase field_75951_w = (new StatBasic("stat.damageDealt", (IChatComponent)new ChatComponentTranslation("stat.damageDealt", new Object[0]), StatBase.field_111202_k)).func_75971_g();
/*  44 */   public static StatBase field_75961_x = (new StatBasic("stat.damageTaken", (IChatComponent)new ChatComponentTranslation("stat.damageTaken", new Object[0]), StatBase.field_111202_k)).func_75971_g();
/*  45 */   public static StatBase field_75960_y = (new StatBasic("stat.deaths", (IChatComponent)new ChatComponentTranslation("stat.deaths", new Object[0]))).func_75971_g();
/*  46 */   public static StatBase field_75959_z = (new StatBasic("stat.mobKills", (IChatComponent)new ChatComponentTranslation("stat.mobKills", new Object[0]))).func_75971_g();
/*  47 */   public static StatBase field_151186_x = (new StatBasic("stat.animalsBred", (IChatComponent)new ChatComponentTranslation("stat.animalsBred", new Object[0]))).func_75971_g();
/*  48 */   public static StatBase field_75932_A = (new StatBasic("stat.playerKills", (IChatComponent)new ChatComponentTranslation("stat.playerKills", new Object[0]))).func_75971_g();
/*  49 */   public static StatBase field_75933_B = (new StatBasic("stat.fishCaught", (IChatComponent)new ChatComponentTranslation("stat.fishCaught", new Object[0]))).func_75971_g();
/*  50 */   public static StatBase field_151183_A = (new StatBasic("stat.junkFished", (IChatComponent)new ChatComponentTranslation("stat.junkFished", new Object[0]))).func_75971_g();
/*  51 */   public static StatBase field_151184_B = (new StatBasic("stat.treasureFished", (IChatComponent)new ChatComponentTranslation("stat.treasureFished", new Object[0]))).func_75971_g();
/*     */   
/*  53 */   public static final StatBase[] field_75934_C = new StatBase[4096];
/*  54 */   public static final StatBase[] field_75928_D = new StatBase[32000];
/*  55 */   public static final StatBase[] field_75929_E = new StatBase[32000];
/*  56 */   public static final StatBase[] field_75930_F = new StatBase[32000]; private static final String __OBFID = "CL_00001480";
/*     */   
/*     */   public static void func_151178_a() {
/*  59 */     func_151181_c();
/*  60 */     func_75925_c();
/*  61 */     func_151179_e();
/*  62 */     func_75918_d();
/*     */     
/*  64 */     AchievementList.func_75997_a();
/*  65 */     EntityList.func_151514_a();
/*     */   }
/*     */   
/*     */   private static void func_75918_d() {
/*  69 */     HashSet<Item> hashSet = new HashSet();
/*     */     
/*  71 */     for (IRecipe iRecipe : CraftingManager.func_77594_a().func_77592_b()) {
/*  72 */       if (iRecipe.func_77571_b() == null)
/*  73 */         continue;  hashSet.add(iRecipe.func_77571_b().func_77973_b());
/*     */     } 
/*  75 */     for (ItemStack itemStack : FurnaceRecipes.func_77602_a().func_77599_b().values()) {
/*  76 */       hashSet.add(itemStack.func_77973_b());
/*     */     }
/*     */     
/*  79 */     for (Item item : hashSet) {
/*  80 */       if (item == null)
/*     */         continue; 
/*  82 */       int i = Item.func_150891_b(item);
/*  83 */       field_75928_D[i] = (new StatCrafting("stat.craftItem." + i, (IChatComponent)new ChatComponentTranslation("stat.craftItem", new Object[] { (new ItemStack(item)).func_151000_E() }), item)).func_75971_g();
/*     */     } 
/*     */     
/*  86 */     func_75924_a(field_75928_D);
/*     */   }
/*     */   
/*     */   private static void func_151181_c() {
/*  90 */     for (Block block : Block.field_149771_c) {
/*  91 */       if (Item.func_150898_a(block) == null)
/*     */         continue; 
/*  93 */       int i = Block.func_149682_b(block);
/*  94 */       if (block.func_149652_G()) {
/*  95 */         field_75934_C[i] = (new StatCrafting("stat.mineBlock." + i, (IChatComponent)new ChatComponentTranslation("stat.mineBlock", new Object[] { (new ItemStack(block)).func_151000_E() }), Item.func_150898_a(block))).func_75971_g();
/*  96 */         field_75939_e.add((StatCrafting)field_75934_C[i]);
/*     */       } 
/*     */     } 
/*     */     
/* 100 */     func_75924_a(field_75934_C);
/*     */   }
/*     */   
/*     */   private static void func_75925_c() {
/* 104 */     for (Item item : Item.field_150901_e) {
/* 105 */       if (item == null)
/*     */         continue; 
/* 107 */       int i = Item.func_150891_b(item);
/*     */       
/* 109 */       field_75929_E[i] = (new StatCrafting("stat.useItem." + i, (IChatComponent)new ChatComponentTranslation("stat.useItem", new Object[] { (new ItemStack(item)).func_151000_E() }), item)).func_75971_g();
/*     */       
/* 111 */       if (!(item instanceof net.minecraft.item.ItemBlock)) {
/* 112 */         field_75938_d.add((StatCrafting)field_75929_E[i]);
/*     */       }
/*     */     } 
/*     */     
/* 116 */     func_75924_a(field_75929_E);
/*     */   }
/*     */   
/*     */   private static void func_151179_e() {
/* 120 */     for (Item item : Item.field_150901_e) {
/* 121 */       if (item == null)
/*     */         continue; 
/* 123 */       int i = Item.func_150891_b(item);
/*     */       
/* 125 */       if (item.func_77645_m()) {
/* 126 */         field_75930_F[i] = (new StatCrafting("stat.breakItem." + i, (IChatComponent)new ChatComponentTranslation("stat.breakItem", new Object[] { (new ItemStack(item)).func_151000_E() }), item)).func_75971_g();
/*     */       }
/*     */     } 
/*     */     
/* 130 */     func_75924_a(field_75930_F);
/*     */   }
/*     */   
/*     */   private static void func_75924_a(StatBase[] p_75924_0_) {
/* 134 */     func_151180_a(p_75924_0_, Blocks.field_150355_j, (Block)Blocks.field_150358_i);
/* 135 */     func_151180_a(p_75924_0_, Blocks.field_150353_l, (Block)Blocks.field_150356_k);
/*     */     
/* 137 */     func_151180_a(p_75924_0_, Blocks.field_150428_aP, Blocks.field_150423_aK);
/* 138 */     func_151180_a(p_75924_0_, Blocks.field_150470_am, Blocks.field_150460_al);
/* 139 */     func_151180_a(p_75924_0_, Blocks.field_150439_ay, Blocks.field_150450_ax);
/*     */     
/* 141 */     func_151180_a(p_75924_0_, (Block)Blocks.field_150416_aS, (Block)Blocks.field_150413_aR);
/* 142 */     func_151180_a(p_75924_0_, (Block)Blocks.field_150455_bV, (Block)Blocks.field_150441_bU);
/* 143 */     func_151180_a(p_75924_0_, Blocks.field_150429_aA, Blocks.field_150437_az);
/* 144 */     func_151180_a(p_75924_0_, Blocks.field_150374_bv, Blocks.field_150379_bu);
/*     */     
/* 146 */     func_151180_a(p_75924_0_, (Block)Blocks.field_150337_Q, (Block)Blocks.field_150338_P);
/* 147 */     func_151180_a(p_75924_0_, (Block)Blocks.field_150334_T, (Block)Blocks.field_150333_U);
/* 148 */     func_151180_a(p_75924_0_, (Block)Blocks.field_150373_bw, (Block)Blocks.field_150376_bx);
/*     */     
/* 150 */     func_151180_a(p_75924_0_, (Block)Blocks.field_150349_c, Blocks.field_150346_d);
/* 151 */     func_151180_a(p_75924_0_, Blocks.field_150458_ak, Blocks.field_150346_d);
/*     */   }
/*     */   
/*     */   private static void func_151180_a(StatBase[] p_151180_0_, Block p_151180_1_, Block p_151180_2_) {
/* 155 */     int i = Block.func_149682_b(p_151180_1_);
/* 156 */     int j = Block.func_149682_b(p_151180_2_);
/*     */     
/* 158 */     if (p_151180_0_[i] != null && p_151180_0_[j] == null) {
/*     */       
/* 160 */       p_151180_0_[j] = p_151180_0_[i];
/*     */       
/*     */       return;
/*     */     } 
/* 164 */     field_75940_b.remove(p_151180_0_[i]);
/* 165 */     field_75939_e.remove(p_151180_0_[i]);
/* 166 */     field_75941_c.remove(p_151180_0_[i]);
/* 167 */     p_151180_0_[i] = p_151180_0_[j];
/*     */   }
/*     */   
/*     */   public static StatBase func_151182_a(EntityList.EntityEggInfo p_151182_0_) {
/* 171 */     String str = EntityList.func_75617_a(p_151182_0_.field_75613_a);
/* 172 */     if (str == null) return null; 
/* 173 */     return (new StatBase("stat.killEntity." + str, (IChatComponent)new ChatComponentTranslation("stat.entityKill", new Object[] { new ChatComponentTranslation("entity." + str + ".name", new Object[0]) }))).func_75971_g();
/*     */   }
/*     */   
/*     */   public static StatBase func_151176_b(EntityList.EntityEggInfo p_151176_0_) {
/* 177 */     String str = EntityList.func_75617_a(p_151176_0_.field_75613_a);
/* 178 */     if (str == null) return null; 
/* 179 */     return (new StatBase("stat.entityKilledBy." + str, (IChatComponent)new ChatComponentTranslation("stat.entityKilledBy", new Object[] { new ChatComponentTranslation("entity." + str + ".name", new Object[0]) }))).func_75971_g();
/*     */   }
/*     */   
/*     */   public static StatBase func_151177_a(String p_151177_0_) {
/* 183 */     return (StatBase)field_75942_a.get(p_151177_0_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\stats\StatList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */