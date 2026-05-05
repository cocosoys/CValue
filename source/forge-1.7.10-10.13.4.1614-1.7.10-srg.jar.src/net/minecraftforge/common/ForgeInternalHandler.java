/*    */ package net.minecraftforge.common;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import cpw.mods.fml.common.eventhandler.EventPriority;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.WorldServer;
/*    */ import net.minecraftforge.common.util.FakePlayerFactory;
/*    */ import net.minecraftforge.event.entity.EntityJoinWorldEvent;
/*    */ import net.minecraftforge.event.world.WorldEvent;
/*    */ 
/*    */ 
/*    */ public class ForgeInternalHandler
/*    */ {
/*    */   @SubscribeEvent(priority = EventPriority.HIGHEST)
/*    */   public void onEntityJoinWorld(EntityJoinWorldEvent event) {
/* 20 */     if (!event.world.isRemote)
/*    */     {
/* 22 */       ForgeChunkManager.loadEntity(event.entity);
/*    */     }
/*    */     
/* 25 */     Entity entity = event.entity;
/* 26 */     if (entity.getClass().equals(EntityItem.class)) {
/*    */       
/* 28 */       ItemStack stack = entity.getDataWatcher().getWatchableObjectItemStack(10);
/*    */       
/* 30 */       if (stack == null) {
/*    */         return;
/*    */       }
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 37 */       Item item = stack.getItem();
/* 38 */       if (item == null) {
/*    */         
/* 40 */         FMLLog.warning("Attempted to add a EntityItem to the world with a invalid item at (%2.2f,  %2.2f, %2.2f), this is most likely a config issue between you and the server. Please double check your configs", new Object[] {
/*    */               
/* 42 */               Double.valueOf(entity.posX), Double.valueOf(entity.posY), Double.valueOf(entity.posZ) });
/* 43 */         entity.setDead();
/* 44 */         event.setCanceled(true);
/*    */         
/*    */         return;
/*    */       } 
/* 48 */       if (item.hasCustomEntity(stack)) {
/*    */         
/* 50 */         Entity newEntity = item.createEntity(event.world, entity, stack);
/* 51 */         if (newEntity != null) {
/*    */           
/* 53 */           entity.setDead();
/* 54 */           event.setCanceled(true);
/* 55 */           event.world.spawnEntityInWorld(newEntity);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent(priority = EventPriority.HIGHEST)
/*    */   public void onDimensionLoad(WorldEvent.Load event) {
/* 64 */     ForgeChunkManager.loadWorld(event.world);
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent(priority = EventPriority.HIGHEST)
/*    */   public void onDimensionSave(WorldEvent.Save event) {
/* 70 */     ForgeChunkManager.saveWorld(event.world);
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent(priority = EventPriority.HIGHEST)
/*    */   public void onDimensionUnload(WorldEvent.Unload event) {
/* 76 */     ForgeChunkManager.unloadWorld(event.world);
/* 77 */     if (event.world instanceof WorldServer)
/* 78 */       FakePlayerFactory.unloadWorld((WorldServer)event.world); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\ForgeInternalHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */