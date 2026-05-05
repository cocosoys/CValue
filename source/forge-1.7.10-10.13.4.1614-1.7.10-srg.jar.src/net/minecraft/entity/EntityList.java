/*     */ package net.minecraft.entity;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.entity.item.EntityExpBottle;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityWitch;
/*     */ import net.minecraft.entity.passive.EntityCow;
/*     */ import net.minecraft.entity.passive.EntityPig;
/*     */ import net.minecraft.entity.passive.EntityVillager;
/*     */ import net.minecraft.entity.projectile.EntityLargeFireball;
/*     */ import net.minecraft.entity.projectile.EntitySnowball;
/*     */ import net.minecraft.entity.projectile.EntityWitherSkull;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.world.World;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ 
/*     */ public class EntityList {
/*  20 */   private static final Logger field_151516_b = LogManager.getLogger();
/*  21 */   public static Map field_75625_b = new HashMap<Object, Object>();
/*  22 */   public static Map field_75626_c = new HashMap<Object, Object>();
/*  23 */   public static Map field_75623_d = new HashMap<Object, Object>();
/*  24 */   private static Map field_75624_e = new HashMap<Object, Object>();
/*  25 */   private static Map field_75622_f = new HashMap<Object, Object>();
/*     */   
/*  27 */   public static HashMap field_75627_a = new LinkedHashMap<Object, Object>(); private static final String __OBFID = "CL_00001538";
/*     */   
/*     */   public static void func_75618_a(Class<?> p_75618_0_, String p_75618_1_, int p_75618_2_) {
/*  30 */     if (field_75625_b.containsKey(p_75618_1_)) throw new IllegalArgumentException("ID is already registered: " + p_75618_1_); 
/*  31 */     if (field_75623_d.containsKey(Integer.valueOf(p_75618_2_))) throw new IllegalArgumentException("ID is already registered: " + p_75618_2_); 
/*  32 */     field_75625_b.put(p_75618_1_, p_75618_0_);
/*  33 */     field_75626_c.put(p_75618_0_, p_75618_1_);
/*  34 */     field_75623_d.put(Integer.valueOf(p_75618_2_), p_75618_0_);
/*  35 */     field_75624_e.put(p_75618_0_, Integer.valueOf(p_75618_2_));
/*  36 */     field_75622_f.put(p_75618_1_, Integer.valueOf(p_75618_2_));
/*     */   }
/*     */   
/*     */   public static void func_75614_a(Class p_75614_0_, String p_75614_1_, int p_75614_2_, int p_75614_3_, int p_75614_4_) {
/*  40 */     func_75618_a(p_75614_0_, p_75614_1_, p_75614_2_);
/*     */     
/*  42 */     field_75627_a.put(Integer.valueOf(p_75614_2_), new EntityEggInfo(p_75614_2_, p_75614_3_, p_75614_4_));
/*     */   }
/*     */   
/*     */   static {
/*  46 */     func_75618_a(EntityItem.class, "Item", 1);
/*  47 */     func_75618_a(EntityXPOrb.class, "XPOrb", 2);
/*     */     
/*  49 */     func_75618_a(EntityLeashKnot.class, "LeashKnot", 8);
/*  50 */     func_75618_a(EntityPainting.class, "Painting", 9);
/*  51 */     func_75618_a(EntityArrow.class, "Arrow", 10);
/*  52 */     func_75618_a(EntitySnowball.class, "Snowball", 11);
/*  53 */     func_75618_a(EntityLargeFireball.class, "Fireball", 12);
/*  54 */     func_75618_a(EntitySmallFireball.class, "SmallFireball", 13);
/*  55 */     func_75618_a(EntityEnderPearl.class, "ThrownEnderpearl", 14);
/*  56 */     func_75618_a(EntityEnderEye.class, "EyeOfEnderSignal", 15);
/*  57 */     func_75618_a(EntityPotion.class, "ThrownPotion", 16);
/*  58 */     func_75618_a(EntityExpBottle.class, "ThrownExpBottle", 17);
/*  59 */     func_75618_a(EntityItemFrame.class, "ItemFrame", 18);
/*  60 */     func_75618_a(EntityWitherSkull.class, "WitherSkull", 19);
/*     */     
/*  62 */     func_75618_a(EntityTNTPrimed.class, "PrimedTnt", 20);
/*  63 */     func_75618_a(EntityFallingBlock.class, "FallingSand", 21);
/*     */     
/*  65 */     func_75618_a(EntityFireworkRocket.class, "FireworksRocketEntity", 22);
/*     */     
/*  67 */     func_75618_a(EntityBoat.class, "Boat", 41);
/*  68 */     func_75618_a(EntityMinecartEmpty.class, "MinecartRideable", 42);
/*  69 */     func_75618_a(EntityMinecartChest.class, "MinecartChest", 43);
/*  70 */     func_75618_a(EntityMinecartFurnace.class, "MinecartFurnace", 44);
/*  71 */     func_75618_a(EntityMinecartTNT.class, "MinecartTNT", 45);
/*  72 */     func_75618_a(EntityMinecartHopper.class, "MinecartHopper", 46);
/*  73 */     func_75618_a(EntityMinecartMobSpawner.class, "MinecartSpawner", 47);
/*  74 */     func_75618_a(EntityMinecartCommandBlock.class, "MinecartCommandBlock", 40);
/*     */     
/*  76 */     func_75618_a(EntityLiving.class, "Mob", 48);
/*  77 */     func_75618_a(EntityMob.class, "Monster", 49);
/*     */     
/*  79 */     func_75614_a(EntityCreeper.class, "Creeper", 50, 894731, 0);
/*  80 */     func_75614_a(EntitySkeleton.class, "Skeleton", 51, 12698049, 4802889);
/*  81 */     func_75614_a(EntitySpider.class, "Spider", 52, 3419431, 11013646);
/*  82 */     func_75618_a(EntityGiantZombie.class, "Giant", 53);
/*  83 */     func_75614_a(EntityZombie.class, "Zombie", 54, 44975, 7969893);
/*  84 */     func_75614_a(EntitySlime.class, "Slime", 55, 5349438, 8306542);
/*  85 */     func_75614_a(EntityGhast.class, "Ghast", 56, 16382457, 12369084);
/*  86 */     func_75614_a(EntityPigZombie.class, "PigZombie", 57, 15373203, 5009705);
/*  87 */     func_75614_a(EntityEnderman.class, "Enderman", 58, 1447446, 0);
/*  88 */     func_75614_a(EntityCaveSpider.class, "CaveSpider", 59, 803406, 11013646);
/*  89 */     func_75614_a(EntitySilverfish.class, "Silverfish", 60, 7237230, 3158064);
/*  90 */     func_75614_a(EntityBlaze.class, "Blaze", 61, 16167425, 16775294);
/*  91 */     func_75614_a(EntityMagmaCube.class, "LavaSlime", 62, 3407872, 16579584);
/*  92 */     func_75618_a(EntityDragon.class, "EnderDragon", 63);
/*  93 */     func_75618_a(EntityWither.class, "WitherBoss", 64);
/*  94 */     func_75614_a(EntityBat.class, "Bat", 65, 4996656, 986895);
/*  95 */     func_75614_a(EntityWitch.class, "Witch", 66, 3407872, 5349438);
/*     */     
/*  97 */     func_75614_a(EntityPig.class, "Pig", 90, 15771042, 14377823);
/*  98 */     func_75614_a(EntitySheep.class, "Sheep", 91, 15198183, 16758197);
/*  99 */     func_75614_a(EntityCow.class, "Cow", 92, 4470310, 10592673);
/* 100 */     func_75614_a(EntityChicken.class, "Chicken", 93, 10592673, 16711680);
/* 101 */     func_75614_a(EntitySquid.class, "Squid", 94, 2243405, 7375001);
/* 102 */     func_75614_a(EntityWolf.class, "Wolf", 95, 14144467, 13545366);
/* 103 */     func_75614_a(EntityMooshroom.class, "MushroomCow", 96, 10489616, 12040119);
/* 104 */     func_75618_a(EntitySnowman.class, "SnowMan", 97);
/* 105 */     func_75614_a(EntityOcelot.class, "Ozelot", 98, 15720061, 5653556);
/* 106 */     func_75618_a(EntityIronGolem.class, "VillagerGolem", 99);
/* 107 */     func_75614_a(EntityHorse.class, "EntityHorse", 100, 12623485, 15656192);
/*     */     
/* 109 */     func_75614_a(EntityVillager.class, "Villager", 120, 5651507, 12422002);
/*     */     
/* 111 */     func_75618_a(EntityEnderCrystal.class, "EnderCrystal", 200);
/*     */   }
/*     */   
/*     */   public static Entity func_75620_a(String p_75620_0_, World p_75620_1_) {
/* 115 */     Entity entity = null;
/*     */     try {
/* 117 */       Class<Entity> clazz = (Class)field_75625_b.get(p_75620_0_);
/* 118 */       if (clazz != null) entity = clazz.getConstructor(new Class[] { World.class }).newInstance(new Object[] { p_75620_1_ });
/*     */     
/* 120 */     } catch (Exception exception) {
/* 121 */       exception.printStackTrace();
/*     */     } 
/* 123 */     return entity;
/*     */   }
/*     */   
/*     */   public static Entity func_75615_a(NBTTagCompound p_75615_0_, World p_75615_1_) {
/* 127 */     Entity entity = null;
/*     */     
/* 129 */     if ("Minecart".equals(p_75615_0_.func_74779_i("id"))) {
/*     */ 
/*     */       
/* 132 */       switch (p_75615_0_.func_74762_e("Type")) {
/*     */         case 1:
/* 134 */           p_75615_0_.func_74778_a("id", "MinecartChest");
/*     */           break;
/*     */         case 2:
/* 137 */           p_75615_0_.func_74778_a("id", "MinecartFurnace");
/*     */           break;
/*     */         case 0:
/* 140 */           p_75615_0_.func_74778_a("id", "MinecartRideable");
/*     */           break;
/*     */       } 
/*     */       
/* 144 */       p_75615_0_.func_82580_o("Type");
/*     */     } 
/*     */     
/*     */     try {
/* 148 */       Class<Entity> clazz = (Class)field_75625_b.get(p_75615_0_.func_74779_i("id"));
/* 149 */       if (clazz != null) entity = clazz.getConstructor(new Class[] { World.class }).newInstance(new Object[] { p_75615_1_ });
/*     */     
/* 151 */     } catch (Exception exception) {
/* 152 */       exception.printStackTrace();
/*     */     } 
/* 154 */     if (entity != null) {
/* 155 */       entity.func_70020_e(p_75615_0_);
/*     */     } else {
/* 157 */       field_151516_b.warn("Skipping Entity with id " + p_75615_0_.func_74779_i("id"));
/*     */     } 
/* 159 */     return entity;
/*     */   }
/*     */   
/*     */   public static Entity func_75616_a(int p_75616_0_, World p_75616_1_) {
/* 163 */     Entity entity = null;
/*     */     try {
/* 165 */       Class<Entity> clazz = func_90035_a(p_75616_0_);
/* 166 */       if (clazz != null) entity = clazz.getConstructor(new Class[] { World.class }).newInstance(new Object[] { p_75616_1_ });
/*     */     
/* 168 */     } catch (Exception exception) {
/* 169 */       exception.printStackTrace();
/*     */     } 
/* 171 */     if (entity == null) {
/* 172 */       field_151516_b.warn("Skipping Entity with id " + p_75616_0_);
/*     */     }
/* 174 */     return entity;
/*     */   }
/*     */   
/*     */   public static int func_75619_a(Entity p_75619_0_) {
/* 178 */     Class<?> clazz = p_75619_0_.getClass();
/*     */     
/* 180 */     return field_75624_e.containsKey(clazz) ? ((Integer)field_75624_e.get(clazz)).intValue() : 0;
/*     */   }
/*     */   
/*     */   public static Class func_90035_a(int p_90035_0_) {
/* 184 */     return (Class)field_75623_d.get(Integer.valueOf(p_90035_0_));
/*     */   }
/*     */   
/*     */   public static String func_75621_b(Entity p_75621_0_) {
/* 188 */     return (String)field_75626_c.get(p_75621_0_.getClass());
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
/*     */   public static String func_75617_a(int p_75617_0_) {
/* 201 */     Class clazz = func_90035_a(p_75617_0_);
/*     */     
/* 203 */     if (clazz != null) {
/* 204 */       return (String)field_75626_c.get(clazz);
/*     */     }
/*     */     
/* 207 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void func_151514_a() {}
/*     */   
/*     */   public static Set func_151515_b() {
/* 214 */     return Collections.unmodifiableSet(field_75622_f.keySet());
/*     */   }
/*     */   
/*     */   public static class EntityEggInfo { public final int field_75613_a;
/*     */     public final int field_75611_b;
/*     */     public final int field_75612_c;
/*     */     public final StatBase field_151512_d;
/*     */     public final StatBase field_151513_e;
/*     */     private static final String __OBFID = "CL_00001539";
/*     */     
/*     */     public EntityEggInfo(int p_i1583_1_, int p_i1583_2_, int p_i1583_3_) {
/* 225 */       this.field_75613_a = p_i1583_1_;
/* 226 */       this.field_75611_b = p_i1583_2_;
/* 227 */       this.field_75612_c = p_i1583_3_;
/* 228 */       this.field_151512_d = StatList.func_151182_a(this);
/* 229 */       this.field_151513_e = StatList.func_151176_b(this);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\EntityList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */