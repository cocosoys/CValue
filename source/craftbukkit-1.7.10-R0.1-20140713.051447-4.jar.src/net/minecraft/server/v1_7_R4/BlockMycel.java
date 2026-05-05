/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.util.Random;
/*    */ import org.bukkit.block.BlockState;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.util.CraftMagicNumbers;
/*    */ import org.bukkit.event.Event;
/*    */ import org.bukkit.event.block.BlockFadeEvent;
/*    */ import org.bukkit.event.block.BlockSpreadEvent;
/*    */ 
/*    */ public class BlockMycel
/*    */   extends Block
/*    */ {
/*    */   protected BlockMycel() {
/* 15 */     super(Material.GRASS);
/* 16 */     a(true);
/* 17 */     a(CreativeModeTab.b);
/*    */   }
/*    */   
/*    */   public void a(World world, int i, int j, int k, Random random) {
/* 21 */     if (!world.isStatic) {
/* 22 */       if (world.getLightLevel(i, j + 1, k) < 4 && world.getType(i, j + 1, k).k() > 2) {
/*    */         
/* 24 */         CraftWorld craftWorld = world.getWorld();
/* 25 */         BlockState blockState = craftWorld.getBlockAt(i, j, k).getState();
/* 26 */         blockState.setType(CraftMagicNumbers.getMaterial(Blocks.DIRT));
/*    */         
/* 28 */         BlockFadeEvent event = new BlockFadeEvent(blockState.getBlock(), blockState);
/* 29 */         world.getServer().getPluginManager().callEvent((Event)event);
/*    */         
/* 31 */         if (!event.isCancelled()) {
/* 32 */           blockState.update(true);
/*    */         }
/*    */       }
/* 35 */       else if (world.getLightLevel(i, j + 1, k) >= 9) {
/* 36 */         for (int l = 0; l < 4; l++) {
/* 37 */           int i1 = i + random.nextInt(3) - 1;
/* 38 */           int j1 = j + random.nextInt(5) - 3;
/* 39 */           int k1 = k + random.nextInt(3) - 1;
/* 40 */           Block block = world.getType(i1, j1 + 1, k1);
/*    */           
/* 42 */           if (world.getType(i1, j1, k1) == Blocks.DIRT && world.getData(i1, j1, k1) == 0 && world.getLightLevel(i1, j1 + 1, k1) >= 4 && block.k() <= 2) {
/*    */             
/* 44 */             CraftWorld craftWorld = world.getWorld();
/* 45 */             BlockState blockState = craftWorld.getBlockAt(i1, j1, k1).getState();
/* 46 */             blockState.setType(CraftMagicNumbers.getMaterial(this));
/*    */             
/* 48 */             BlockSpreadEvent event = new BlockSpreadEvent(blockState.getBlock(), craftWorld.getBlockAt(i, j, k), blockState);
/* 49 */             world.getServer().getPluginManager().callEvent((Event)event);
/*    */             
/* 51 */             if (!event.isCancelled()) {
/* 52 */               blockState.update(true);
/*    */             }
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public Item getDropType(int i, Random random, int j) {
/* 62 */     return Blocks.DIRT.getDropType(0, random, j);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockMycel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */