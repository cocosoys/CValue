/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.Random;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.block.BlockFace;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.block.BlockFromToEvent;
/*     */ 
/*     */ public class BlockFlowing extends BlockFluids {
/*     */   int a;
/*  13 */   boolean[] b = new boolean[4];
/*  14 */   int[] M = new int[4];
/*     */   
/*     */   protected BlockFlowing(Material material) {
/*  17 */     super(material);
/*     */   }
/*     */   
/*     */   private void n(World world, int i, int j, int k) {
/*  21 */     int l = world.getData(i, j, k);
/*     */     
/*  23 */     world.setTypeAndData(i, j, k, Block.getById(Block.getId(this) + 1), l, 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(World world, int i, int j, int k, Random random) {
/*  28 */     CraftWorld craftWorld = world.getWorld();
/*  29 */     CraftServer craftServer = world.getServer();
/*  30 */     Block source = (craftWorld == null) ? null : craftWorld.getBlockAt(i, j, k);
/*     */ 
/*     */     
/*  33 */     int l = e(world, i, j, k);
/*  34 */     byte b0 = 1;
/*     */     
/*  36 */     if (this.material == Material.LAVA && !world.worldProvider.f) {
/*  37 */       b0 = 2;
/*     */     }
/*     */     
/*  40 */     boolean flag = true;
/*  41 */     int i1 = a(world);
/*     */ 
/*     */     
/*  44 */     if (l > 0) {
/*  45 */       byte b1 = -100;
/*     */       
/*  47 */       this.a = 0;
/*  48 */       int k1 = a(world, i - 1, j, k, b1);
/*     */       
/*  50 */       k1 = a(world, i + 1, j, k, k1);
/*  51 */       k1 = a(world, i, j, k - 1, k1);
/*  52 */       k1 = a(world, i, j, k + 1, k1);
/*  53 */       int j1 = k1 + b0;
/*  54 */       if (j1 >= 8 || k1 < 0) {
/*  55 */         j1 = -1;
/*     */       }
/*     */       
/*  58 */       if (e(world, i, j + 1, k) >= 0) {
/*  59 */         int l1 = e(world, i, j + 1, k);
/*     */         
/*  61 */         if (l1 >= 8) {
/*  62 */           j1 = l1;
/*     */         } else {
/*  64 */           j1 = l1 + 8;
/*     */         } 
/*     */       } 
/*     */       
/*  68 */       if (this.a >= 2 && this.material == Material.WATER) {
/*  69 */         if (world.getType(i, j - 1, k).getMaterial().isBuildable()) {
/*  70 */           j1 = 0;
/*  71 */         } else if (world.getType(i, j - 1, k).getMaterial() == this.material && world.getData(i, j - 1, k) == 0) {
/*  72 */           j1 = 0;
/*     */         } 
/*     */       }
/*     */       
/*  76 */       if (this.material == Material.LAVA && l < 8 && j1 < 8 && j1 > l && random.nextInt(4) != 0) {
/*  77 */         i1 *= 4;
/*     */       }
/*     */       
/*  80 */       if (j1 == l) {
/*  81 */         if (flag) {
/*  82 */           n(world, i, j, k);
/*     */         }
/*     */       } else {
/*  85 */         l = j1;
/*  86 */         if (j1 < 0) {
/*  87 */           world.setAir(i, j, k);
/*     */         } else {
/*  89 */           world.setData(i, j, k, j1, 2);
/*  90 */           world.a(i, j, k, this, i1);
/*  91 */           world.applyPhysics(i, j, k, this);
/*     */         } 
/*     */       } 
/*     */     } else {
/*  95 */       n(world, i, j, k);
/*     */     } 
/*     */     
/*  98 */     if (q(world, i, j - 1, k)) {
/*     */       
/* 100 */       BlockFromToEvent event = new BlockFromToEvent(source, BlockFace.DOWN);
/* 101 */       if (craftServer != null) {
/* 102 */         craftServer.getPluginManager().callEvent((Event)event);
/*     */       }
/*     */       
/* 105 */       if (!event.isCancelled()) {
/* 106 */         if (this.material == Material.LAVA && world.getType(i, j - 1, k).getMaterial() == Material.WATER) {
/* 107 */           world.setTypeUpdate(i, j - 1, k, Blocks.STONE);
/* 108 */           fizz(world, i, j - 1, k);
/*     */           
/*     */           return;
/*     */         } 
/* 112 */         if (l >= 8) {
/* 113 */           flow(world, i, j - 1, k, l);
/*     */         } else {
/* 115 */           flow(world, i, j - 1, k, l + 8);
/*     */         }
/*     */       
/*     */       } 
/* 119 */     } else if (l >= 0 && (l == 0 || p(world, i, j - 1, k))) {
/* 120 */       boolean[] aboolean = o(world, i, j, k);
/*     */       
/* 122 */       int j1 = l + b0;
/* 123 */       if (l >= 8) {
/* 124 */         j1 = 1;
/*     */       }
/*     */       
/* 127 */       if (j1 >= 8) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 132 */       BlockFace[] faces = { BlockFace.WEST, BlockFace.EAST, BlockFace.NORTH, BlockFace.SOUTH };
/* 133 */       int index = 0;
/*     */       
/* 135 */       for (BlockFace currentFace : faces) {
/* 136 */         if (aboolean[index]) {
/* 137 */           BlockFromToEvent event = new BlockFromToEvent(source, currentFace);
/*     */           
/* 139 */           if (craftServer != null) {
/* 140 */             craftServer.getPluginManager().callEvent((Event)event);
/*     */           }
/*     */           
/* 143 */           if (!event.isCancelled()) {
/* 144 */             flow(world, i + currentFace.getModX(), j, k + currentFace.getModZ(), j1);
/*     */           }
/*     */         } 
/* 147 */         index++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void flow(World world, int i, int j, int k, int l) {
/* 154 */     if (q(world, i, j, k)) {
/* 155 */       Block block = world.getType(i, j, k);
/*     */       
/* 157 */       if (this.material == Material.LAVA) {
/* 158 */         fizz(world, i, j, k);
/*     */       } else {
/* 160 */         block.b(world, i, j, k, world.getData(i, j, k), 0);
/*     */       } 
/*     */       
/* 163 */       world.setTypeAndData(i, j, k, this, l, 3);
/*     */     } 
/*     */   }
/*     */   
/*     */   private int c(World world, int i, int j, int k, int l, int i1) {
/* 168 */     int j1 = 1000;
/*     */     
/* 170 */     for (int k1 = 0; k1 < 4; k1++) {
/* 171 */       if ((k1 != 0 || i1 != 1) && (k1 != 1 || i1 != 0) && (k1 != 2 || i1 != 3) && (k1 != 3 || i1 != 2)) {
/* 172 */         int l1 = i;
/* 173 */         int i2 = k;
/*     */         
/* 175 */         if (k1 == 0) {
/* 176 */           l1 = i - 1;
/*     */         }
/*     */         
/* 179 */         if (k1 == 1) {
/* 180 */           l1++;
/*     */         }
/*     */         
/* 183 */         if (k1 == 2) {
/* 184 */           i2 = k - 1;
/*     */         }
/*     */         
/* 187 */         if (k1 == 3) {
/* 188 */           i2++;
/*     */         }
/*     */         
/* 191 */         if (!p(world, l1, j, i2) && (world.getType(l1, j, i2).getMaterial() != this.material || world.getData(l1, j, i2) != 0)) {
/* 192 */           if (!p(world, l1, j - 1, i2)) {
/* 193 */             return l;
/*     */           }
/*     */           
/* 196 */           if (l < 4) {
/* 197 */             int j2 = c(world, l1, j, i2, l + 1, k1);
/*     */             
/* 199 */             if (j2 < j1) {
/* 200 */               j1 = j2;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 207 */     return j1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean[] o(World world, int i, int j, int k) {
/*     */     int l;
/* 214 */     for (l = 0; l < 4; l++) {
/* 215 */       this.M[l] = 1000;
/* 216 */       int m = i;
/* 217 */       int j1 = k;
/*     */       
/* 219 */       if (l == 0) {
/* 220 */         m = i - 1;
/*     */       }
/*     */       
/* 223 */       if (l == 1) {
/* 224 */         m++;
/*     */       }
/*     */       
/* 227 */       if (l == 2) {
/* 228 */         j1 = k - 1;
/*     */       }
/*     */       
/* 231 */       if (l == 3) {
/* 232 */         j1++;
/*     */       }
/*     */       
/* 235 */       if (!p(world, m, j, j1) && (world.getType(m, j, j1).getMaterial() != this.material || world.getData(m, j, j1) != 0)) {
/* 236 */         if (p(world, m, j - 1, j1)) {
/* 237 */           this.M[l] = c(world, m, j, j1, 1, l);
/*     */         } else {
/* 239 */           this.M[l] = 0;
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 244 */     l = this.M[0];
/*     */     int i1;
/* 246 */     for (i1 = 1; i1 < 4; i1++) {
/* 247 */       if (this.M[i1] < l) {
/* 248 */         l = this.M[i1];
/*     */       }
/*     */     } 
/*     */     
/* 252 */     for (i1 = 0; i1 < 4; i1++) {
/* 253 */       this.b[i1] = (this.M[i1] == l);
/*     */     }
/*     */     
/* 256 */     return this.b;
/*     */   }
/*     */   
/*     */   private boolean p(World world, int i, int j, int k) {
/* 260 */     Block block = world.getType(i, j, k);
/*     */     
/* 262 */     return (block != Blocks.WOODEN_DOOR && block != Blocks.IRON_DOOR_BLOCK && block != Blocks.SIGN_POST && block != Blocks.LADDER && block != Blocks.SUGAR_CANE_BLOCK) ? ((block.material == Material.PORTAL) ? true : block.material.isSolid()) : true;
/*     */   }
/*     */   
/*     */   protected int a(World world, int i, int j, int k, int l) {
/* 266 */     int i1 = e(world, i, j, k);
/*     */     
/* 268 */     if (i1 < 0) {
/* 269 */       return l;
/*     */     }
/* 271 */     if (i1 == 0) {
/* 272 */       this.a++;
/*     */     }
/*     */     
/* 275 */     if (i1 >= 8) {
/* 276 */       i1 = 0;
/*     */     }
/*     */     
/* 279 */     return (l >= 0 && i1 >= l) ? l : i1;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean q(World world, int i, int j, int k) {
/* 284 */     Material material = world.getType(i, j, k).getMaterial();
/*     */     
/* 286 */     return (material == this.material) ? false : ((material == Material.LAVA) ? false : (!p(world, i, j, k)));
/*     */   }
/*     */   
/*     */   public void onPlace(World world, int i, int j, int k) {
/* 290 */     super.onPlace(world, i, j, k);
/* 291 */     if (world.getType(i, j, k) == this) {
/* 292 */       world.a(i, j, k, this, a(world));
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean L() {
/* 297 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockFlowing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */