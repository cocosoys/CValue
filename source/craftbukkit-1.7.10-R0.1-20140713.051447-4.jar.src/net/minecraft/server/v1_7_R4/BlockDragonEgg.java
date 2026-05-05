/*     */ package net.minecraft.server.v1_7_R4;
/*     */ import java.util.Random;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.block.BlockFromToEvent;
/*     */ 
/*     */ public class BlockDragonEgg extends Block {
/*     */   public BlockDragonEgg() {
/*  10 */     super(Material.DRAGON_EGG);
/*  11 */     a(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
/*     */   }
/*     */   
/*     */   public void onPlace(World world, int i, int j, int k) {
/*  15 */     world.a(i, j, k, this, a(world));
/*     */   }
/*     */   
/*     */   public void doPhysics(World world, int i, int j, int k, Block block) {
/*  19 */     world.a(i, j, k, this, a(world));
/*     */   }
/*     */   
/*     */   public void a(World world, int i, int j, int k, Random random) {
/*  23 */     e(world, i, j, k);
/*     */   }
/*     */   
/*     */   private void e(World world, int i, int j, int k) {
/*  27 */     if (BlockFalling.canFall(world, i, j - 1, k) && j >= 0) {
/*  28 */       byte b0 = 32;
/*     */       
/*  30 */       if (!BlockFalling.instaFall && world.b(i - b0, j - b0, k - b0, i + b0, j + b0, k + b0)) {
/*     */         
/*  32 */         EntityFallingBlock entityfallingblock = new EntityFallingBlock(world, (i + 0.5F), (j + 0.5F), (k + 0.5F), this, world.getData(i, j, k));
/*     */         
/*  34 */         world.addEntity(entityfallingblock);
/*     */       } else {
/*  36 */         world.setAir(i, j, k);
/*     */         
/*  38 */         while (BlockFalling.canFall(world, i, j - 1, k) && j > 0) {
/*  39 */           j--;
/*     */         }
/*     */         
/*  42 */         if (j > 0) {
/*  43 */           world.setTypeAndData(i, j, k, this, 0, 2);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean interact(World world, int i, int j, int k, EntityHuman entityhuman, int l, float f, float f1, float f2) {
/*  50 */     m(world, i, j, k);
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public void attack(World world, int i, int j, int k, EntityHuman entityhuman) {
/*  55 */     m(world, i, j, k);
/*     */   }
/*     */   
/*     */   private void m(World world, int i, int j, int k) {
/*  59 */     if (world.getType(i, j, k) == this) {
/*  60 */       for (int l = 0; l < 1000; l++) {
/*  61 */         int i1 = i + world.random.nextInt(16) - world.random.nextInt(16);
/*  62 */         int j1 = j + world.random.nextInt(8) - world.random.nextInt(8);
/*  63 */         int k1 = k + world.random.nextInt(16) - world.random.nextInt(16);
/*     */         
/*  65 */         if ((world.getType(i1, j1, k1)).material == Material.AIR) {
/*     */           
/*  67 */           Block from = world.getWorld().getBlockAt(i, j, k);
/*  68 */           Block to = world.getWorld().getBlockAt(i1, j1, k1);
/*  69 */           BlockFromToEvent event = new BlockFromToEvent(from, to);
/*  70 */           Bukkit.getPluginManager().callEvent((Event)event);
/*     */           
/*  72 */           if (event.isCancelled()) {
/*     */             return;
/*     */           }
/*     */           
/*  76 */           i1 = event.getToBlock().getX();
/*  77 */           j1 = event.getToBlock().getY();
/*  78 */           k1 = event.getToBlock().getZ();
/*     */ 
/*     */           
/*  81 */           if (!world.isStatic) {
/*  82 */             world.setTypeAndData(i1, j1, k1, this, world.getData(i, j, k), 2);
/*  83 */             world.setAir(i, j, k);
/*     */           } else {
/*  85 */             short short1 = 128;
/*     */             
/*  87 */             for (int l1 = 0; l1 < short1; l1++) {
/*  88 */               double d0 = world.random.nextDouble();
/*  89 */               float f = (world.random.nextFloat() - 0.5F) * 0.2F;
/*  90 */               float f1 = (world.random.nextFloat() - 0.5F) * 0.2F;
/*  91 */               float f2 = (world.random.nextFloat() - 0.5F) * 0.2F;
/*  92 */               double d1 = i1 + (i - i1) * d0 + (world.random.nextDouble() - 0.5D) * 1.0D + 0.5D;
/*  93 */               double d2 = j1 + (j - j1) * d0 + world.random.nextDouble() * 1.0D - 0.5D;
/*  94 */               double d3 = k1 + (k - k1) * d0 + (world.random.nextDouble() - 0.5D) * 1.0D + 0.5D;
/*     */               
/*  96 */               world.addParticle("portal", d1, d2, d3, f, f1, f2);
/*     */             } 
/*     */           } 
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int a(World world) {
/* 107 */     return 5;
/*     */   }
/*     */   
/*     */   public boolean c() {
/* 111 */     return false;
/*     */   }
/*     */   
/*     */   public boolean d() {
/* 115 */     return false;
/*     */   }
/*     */   
/*     */   public int b() {
/* 119 */     return 27;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockDragonEgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */