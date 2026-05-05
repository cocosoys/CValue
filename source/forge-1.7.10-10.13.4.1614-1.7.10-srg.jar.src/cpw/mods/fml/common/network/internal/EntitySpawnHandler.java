/*     */ package cpw.mods.fml.common.network.internal;
/*     */ 
/*     */ import com.google.common.base.Throwables;
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.common.registry.EntityRegistry;
/*     */ import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
/*     */ import cpw.mods.fml.common.registry.IThrowableEntity;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import io.netty.channel.SimpleChannelInboundHandler;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.world.World;
/*     */ import org.apache.logging.log4j.Level;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntitySpawnHandler
/*     */   extends SimpleChannelInboundHandler<FMLMessage.EntityMessage>
/*     */ {
/*     */   protected void channelRead0(ChannelHandlerContext ctx, FMLMessage.EntityMessage msg) throws Exception {
/*  32 */     if (msg.getClass().equals(FMLMessage.EntitySpawnMessage.class)) {
/*     */       
/*  34 */       spawnEntity((FMLMessage.EntitySpawnMessage)msg);
/*     */     }
/*  36 */     else if (msg.getClass().equals(FMLMessage.EntityAdjustMessage.class)) {
/*     */       
/*  38 */       adjustEntity((FMLMessage.EntityAdjustMessage)msg);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void adjustEntity(FMLMessage.EntityAdjustMessage msg) {
/*  44 */     Entity ent = FMLClientHandler.instance().getWorldClient().getEntityByID(msg.entityId);
/*  45 */     if (ent != null) {
/*     */       
/*  47 */       ent.serverPosX = msg.serverX;
/*  48 */       ent.serverPosY = msg.serverY;
/*  49 */       ent.serverPosZ = msg.serverZ;
/*     */     }
/*     */     else {
/*     */       
/*  53 */       FMLLog.fine("Attempted to adjust the position of entity %d which is not present on the client", new Object[] { Integer.valueOf(msg.entityId) });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void spawnEntity(FMLMessage.EntitySpawnMessage spawnMsg) {
/*  60 */     ModContainer mc = (ModContainer)Loader.instance().getIndexedModList().get(spawnMsg.modId);
/*  61 */     EntityRegistry.EntityRegistration er = EntityRegistry.instance().lookupModSpawn(mc, spawnMsg.modEntityTypeId);
/*  62 */     if (er == null)
/*     */     {
/*  64 */       throw new RuntimeException("Could not spawn mod entity ModID: " + spawnMsg.modId + " EntityID: " + spawnMsg.modEntityTypeId + " at ( " + spawnMsg.scaledX + "," + spawnMsg.scaledY + ", " + spawnMsg.scaledZ + ") Please contact mod author or server admin.");
/*     */     }
/*     */     
/*  67 */     WorldClient wc = FMLClientHandler.instance().getWorldClient();
/*  68 */     Class<? extends Entity> cls = er.getEntityClass();
/*     */     
/*     */     try {
/*     */       Entity entity;
/*  72 */       if (er.hasCustomSpawning()) {
/*     */         
/*  74 */         entity = er.doCustomSpawning(spawnMsg);
/*     */       } else {
/*     */         
/*  77 */         entity = cls.getConstructor(new Class[] { World.class }).newInstance(new Object[] { wc });
/*     */         
/*  79 */         int offset = spawnMsg.entityId - entity.getEntityId();
/*  80 */         entity.setEntityId(spawnMsg.entityId);
/*  81 */         entity.setLocationAndAngles(spawnMsg.scaledX, spawnMsg.scaledY, spawnMsg.scaledZ, spawnMsg.scaledYaw, spawnMsg.scaledPitch);
/*  82 */         if (entity instanceof EntityLiving)
/*     */         {
/*  84 */           ((EntityLiving)entity).rotationYawHead = spawnMsg.scaledHeadYaw;
/*     */         }
/*     */         
/*  87 */         Entity[] parts = entity.getParts();
/*  88 */         if (parts != null)
/*     */         {
/*  90 */           for (int j = 0; j < parts.length; j++)
/*     */           {
/*  92 */             parts[j].setEntityId(parts[j].getEntityId() + offset);
/*     */           }
/*     */         }
/*     */       } 
/*     */       
/*  97 */       entity.serverPosX = spawnMsg.rawX;
/*  98 */       entity.serverPosY = spawnMsg.rawY;
/*  99 */       entity.serverPosZ = spawnMsg.rawZ;
/*     */       
/* 101 */       EntityClientPlayerMP clientPlayer = FMLClientHandler.instance().getClientPlayerEntity();
/* 102 */       if (entity instanceof IThrowableEntity) {
/*     */         
/* 104 */         Entity thrower = (clientPlayer.getEntityId() == spawnMsg.throwerId) ? (Entity)clientPlayer : wc.getEntityByID(spawnMsg.throwerId);
/* 105 */         ((IThrowableEntity)entity).setThrower(thrower);
/*     */       } 
/*     */       
/* 108 */       if (spawnMsg.dataWatcherList != null)
/*     */       {
/* 110 */         entity.getDataWatcher().updateWatchedObjectsFromList(spawnMsg.dataWatcherList);
/*     */       }
/*     */       
/* 113 */       if (spawnMsg.throwerId > 0)
/*     */       {
/* 115 */         entity.setVelocity(spawnMsg.speedScaledX, spawnMsg.speedScaledY, spawnMsg.speedScaledZ);
/*     */       }
/*     */       
/* 118 */       if (entity instanceof IEntityAdditionalSpawnData)
/*     */       {
/* 120 */         ((IEntityAdditionalSpawnData)entity).readSpawnData(spawnMsg.dataStream);
/*     */       }
/* 122 */       wc.addEntityToWorld(spawnMsg.entityId, entity);
/* 123 */     } catch (Exception e) {
/*     */       
/* 125 */       FMLLog.log(Level.ERROR, e, "A severe problem occurred during the spawning of an entity at ( " + spawnMsg.scaledX + "," + spawnMsg.scaledY + ", " + spawnMsg.scaledZ + ")", new Object[0]);
/* 126 */       throw Throwables.propagate(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 133 */     FMLLog.log(Level.ERROR, cause, "EntitySpawnHandler exception", new Object[0]);
/* 134 */     super.exceptionCaught(ctx, cause);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\internal\EntitySpawnHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */