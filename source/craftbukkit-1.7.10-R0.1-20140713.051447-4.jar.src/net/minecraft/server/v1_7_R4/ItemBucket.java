/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;
/*     */ import org.bukkit.event.player.PlayerBucketEmptyEvent;
/*     */ import org.bukkit.event.player.PlayerBucketFillEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class ItemBucket
/*     */   extends Item
/*     */ {
/*     */   private Block a;
/*     */   
/*     */   public ItemBucket(Block block) {
/*  15 */     this.maxStackSize = 1;
/*  16 */     this.a = block;
/*  17 */     a(CreativeModeTab.f);
/*     */   }
/*     */   
/*     */   public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
/*  21 */     boolean flag = (this.a == Blocks.AIR);
/*  22 */     MovingObjectPosition movingobjectposition = a(world, entityhuman, flag);
/*     */     
/*  24 */     if (movingobjectposition == null) {
/*  25 */       return itemstack;
/*     */     }
/*  27 */     if (movingobjectposition.type == EnumMovingObjectType.BLOCK) {
/*  28 */       int i = movingobjectposition.b;
/*  29 */       int j = movingobjectposition.c;
/*  30 */       int k = movingobjectposition.d;
/*     */       
/*  32 */       if (!world.a(entityhuman, i, j, k)) {
/*  33 */         return itemstack;
/*     */       }
/*     */       
/*  36 */       if (flag) {
/*  37 */         if (!entityhuman.a(i, j, k, movingobjectposition.face, itemstack)) {
/*  38 */           return itemstack;
/*     */         }
/*     */         
/*  41 */         Material material = world.getType(i, j, k).getMaterial();
/*  42 */         int l = world.getData(i, j, k);
/*     */         
/*  44 */         if (material == Material.WATER && l == 0) {
/*     */           
/*  46 */           PlayerBucketFillEvent event = CraftEventFactory.callPlayerBucketFillEvent(entityhuman, i, j, k, -1, itemstack, Items.WATER_BUCKET);
/*     */           
/*  48 */           if (event.isCancelled()) {
/*  49 */             return itemstack;
/*     */           }
/*     */           
/*  52 */           world.setAir(i, j, k);
/*  53 */           return a(itemstack, entityhuman, Items.WATER_BUCKET, event.getItemStack());
/*     */         } 
/*     */         
/*  56 */         if (material == Material.LAVA && l == 0) {
/*     */           
/*  58 */           PlayerBucketFillEvent event = CraftEventFactory.callPlayerBucketFillEvent(entityhuman, i, j, k, -1, itemstack, Items.LAVA_BUCKET);
/*     */           
/*  60 */           if (event.isCancelled()) {
/*  61 */             return itemstack;
/*     */           }
/*     */           
/*  64 */           world.setAir(i, j, k);
/*  65 */           return a(itemstack, entityhuman, Items.LAVA_BUCKET, event.getItemStack());
/*     */         } 
/*     */       } else {
/*  68 */         if (this.a == Blocks.AIR) {
/*     */           
/*  70 */           PlayerBucketEmptyEvent playerBucketEmptyEvent = CraftEventFactory.callPlayerBucketEmptyEvent(entityhuman, i, j, k, movingobjectposition.face, itemstack);
/*     */           
/*  72 */           if (playerBucketEmptyEvent.isCancelled()) {
/*  73 */             return itemstack;
/*     */           }
/*     */           
/*  76 */           return CraftItemStack.asNMSCopy(playerBucketEmptyEvent.getItemStack());
/*     */         } 
/*     */         
/*  79 */         int clickedX = i, clickedY = j, clickedZ = k;
/*     */ 
/*     */         
/*  82 */         if (movingobjectposition.face == 0) {
/*  83 */           j--;
/*     */         }
/*     */         
/*  86 */         if (movingobjectposition.face == 1) {
/*  87 */           j++;
/*     */         }
/*     */         
/*  90 */         if (movingobjectposition.face == 2) {
/*  91 */           k--;
/*     */         }
/*     */         
/*  94 */         if (movingobjectposition.face == 3) {
/*  95 */           k++;
/*     */         }
/*     */         
/*  98 */         if (movingobjectposition.face == 4) {
/*  99 */           i--;
/*     */         }
/*     */         
/* 102 */         if (movingobjectposition.face == 5) {
/* 103 */           i++;
/*     */         }
/*     */         
/* 106 */         if (!entityhuman.a(i, j, k, movingobjectposition.face, itemstack)) {
/* 107 */           return itemstack;
/*     */         }
/*     */ 
/*     */         
/* 111 */         PlayerBucketEmptyEvent event = CraftEventFactory.callPlayerBucketEmptyEvent(entityhuman, clickedX, clickedY, clickedZ, movingobjectposition.face, itemstack);
/*     */         
/* 113 */         if (event.isCancelled()) {
/* 114 */           return itemstack;
/*     */         }
/*     */ 
/*     */         
/* 118 */         if (a(world, i, j, k) && !entityhuman.abilities.canInstantlyBuild) {
/* 119 */           return CraftItemStack.asNMSCopy(event.getItemStack());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 124 */     return itemstack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemStack a(ItemStack itemstack, EntityHuman entityhuman, Item item, ItemStack result) {
/* 130 */     if (entityhuman.abilities.canInstantlyBuild)
/* 131 */       return itemstack; 
/* 132 */     if (--itemstack.count <= 0) {
/* 133 */       return CraftItemStack.asNMSCopy(result);
/*     */     }
/* 135 */     if (!entityhuman.inventory.pickup(CraftItemStack.asNMSCopy(result))) {
/* 136 */       entityhuman.drop(CraftItemStack.asNMSCopy(result), false);
/*     */     }
/*     */     
/* 139 */     return itemstack;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(World world, int i, int j, int k) {
/* 144 */     if (this.a == Blocks.AIR) {
/* 145 */       return false;
/*     */     }
/* 147 */     Material material = world.getType(i, j, k).getMaterial();
/* 148 */     boolean flag = !material.isBuildable();
/*     */     
/* 150 */     if (!world.isEmpty(i, j, k) && !flag) {
/* 151 */       return false;
/*     */     }
/* 153 */     if (world.worldProvider.f && this.a == Blocks.WATER) {
/* 154 */       world.makeSound((i + 0.5F), (j + 0.5F), (k + 0.5F), "random.fizz", 0.5F, 2.6F + (world.random.nextFloat() - world.random.nextFloat()) * 0.8F);
/*     */       
/* 156 */       for (int l = 0; l < 8; l++) {
/* 157 */         world.addParticle("largesmoke", i + Math.random(), j + Math.random(), k + Math.random(), 0.0D, 0.0D, 0.0D);
/*     */       }
/*     */     } else {
/* 160 */       if (!world.isStatic && flag && !material.isLiquid()) {
/* 161 */         world.setAir(i, j, k, true);
/*     */       }
/*     */       
/* 164 */       world.setTypeAndData(i, j, k, this.a, 0, 3);
/*     */     } 
/*     */     
/* 167 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ItemBucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */