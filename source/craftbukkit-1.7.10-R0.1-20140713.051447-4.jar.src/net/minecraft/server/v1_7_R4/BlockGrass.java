/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.Random;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.bukkit.block.BlockState;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.util.CraftMagicNumbers;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.block.BlockFadeEvent;
/*     */ import org.bukkit.event.block.BlockSpreadEvent;
/*     */ 
/*     */ public class BlockGrass
/*     */   extends Block
/*     */   implements IBlockFragilePlantElement
/*     */ {
/*  18 */   private static final Logger a = LogManager.getLogger();
/*     */   
/*     */   protected BlockGrass() {
/*  21 */     super(Material.GRASS);
/*  22 */     a(true);
/*  23 */     a(CreativeModeTab.b);
/*     */   }
/*     */   
/*     */   public void a(World world, int i, int j, int k, Random random) {
/*  27 */     if (!world.isStatic) {
/*  28 */       if (world.getLightLevel(i, j + 1, k) < 4 && world.getType(i, j + 1, k).k() > 2) {
/*     */         
/*  30 */         CraftWorld craftWorld = world.getWorld();
/*  31 */         BlockState blockState = craftWorld.getBlockAt(i, j, k).getState();
/*  32 */         blockState.setType(CraftMagicNumbers.getMaterial(Blocks.DIRT));
/*     */         
/*  34 */         BlockFadeEvent event = new BlockFadeEvent(blockState.getBlock(), blockState);
/*  35 */         world.getServer().getPluginManager().callEvent((Event)event);
/*     */         
/*  37 */         if (!event.isCancelled()) {
/*  38 */           blockState.update(true);
/*     */         }
/*     */       }
/*  41 */       else if (world.getLightLevel(i, j + 1, k) >= 9) {
/*  42 */         for (int l = 0; l < 4; l++) {
/*  43 */           int i1 = i + random.nextInt(3) - 1;
/*  44 */           int j1 = j + random.nextInt(5) - 3;
/*  45 */           int k1 = k + random.nextInt(3) - 1;
/*  46 */           Block block = world.getType(i1, j1 + 1, k1);
/*     */           
/*  48 */           if (world.getType(i1, j1, k1) == Blocks.DIRT && world.getData(i1, j1, k1) == 0 && world.getLightLevel(i1, j1 + 1, k1) >= 4 && block.k() <= 2) {
/*     */             
/*  50 */             CraftWorld craftWorld = world.getWorld();
/*  51 */             BlockState blockState = craftWorld.getBlockAt(i1, j1, k1).getState();
/*  52 */             blockState.setType(CraftMagicNumbers.getMaterial(Blocks.GRASS));
/*     */             
/*  54 */             BlockSpreadEvent event = new BlockSpreadEvent(blockState.getBlock(), craftWorld.getBlockAt(i, j, k), blockState);
/*  55 */             world.getServer().getPluginManager().callEvent((Event)event);
/*     */             
/*  57 */             if (!event.isCancelled()) {
/*  58 */               blockState.update(true);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Item getDropType(int i, Random random, int j) {
/*  68 */     return Blocks.DIRT.getDropType(0, random, j);
/*     */   }
/*     */   
/*     */   public boolean a(World world, int i, int j, int k, boolean flag) {
/*  72 */     return true;
/*     */   }
/*     */   
/*     */   public boolean a(World world, Random random, int i, int j, int k) {
/*  76 */     return true;
/*     */   }
/*     */   
/*     */   public void b(World world, Random random, int i, int j, int k) {
/*  80 */     int l = 0;
/*     */     
/*  82 */     label26: while (l < 128) {
/*  83 */       int i1 = i;
/*  84 */       int j1 = j + 1;
/*  85 */       int k1 = k;
/*  86 */       int l1 = 0;
/*     */ 
/*     */       
/*  89 */       while (l1 < l / 16) {
/*  90 */         i1 += random.nextInt(3) - 1;
/*  91 */         j1 += (random.nextInt(3) - 1) * random.nextInt(3) / 2;
/*  92 */         k1 += random.nextInt(3) - 1;
/*  93 */         if (world.getType(i1, j1 - 1, k1) == Blocks.GRASS) { if (!world.getType(i1, j1, k1).r()) {
/*  94 */             l1++; continue;
/*     */           }  continue label26; }
/*     */          continue label26;
/*  97 */       }  if ((world.getType(i1, j1, k1)).material == Material.AIR) {
/*  98 */         if (random.nextInt(8) != 0) {
/*  99 */           if (Blocks.LONG_GRASS.j(world, i1, j1, k1)) {
/* 100 */             CraftEventFactory.handleBlockGrowEvent(world, i1, j1, k1, Blocks.LONG_GRASS, 1);
/*     */           }
/*     */         } else {
/* 103 */           String s = world.getBiome(i1, k1).a(random, i1, j1, k1);
/*     */           
/* 105 */           a.debug("Flower in " + (world.getBiome(i1, k1)).af + ": " + s);
/* 106 */           BlockFlowers blockflowers = BlockFlowers.e(s);
/*     */           
/* 108 */           if (blockflowers != null && blockflowers.j(world, i1, j1, k1)) {
/* 109 */             int i2 = BlockFlowers.f(s);
/*     */             
/* 111 */             CraftEventFactory.handleBlockGrowEvent(world, i1, j1, k1, blockflowers, i2);
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 116 */       l++;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockGrass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */