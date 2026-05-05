/*    */ package net.minecraft.server.v1_7_R4;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Event;
/*    */ import org.bukkit.event.player.PlayerTeleportEvent;
/*    */ 
/*    */ public class EntityEnderPearl extends EntityProjectile {
/*    */   public EntityEnderPearl(World world) {
/* 12 */     super(world);
/*    */   }
/*    */   
/*    */   public EntityEnderPearl(World world, EntityLiving entityliving) {
/* 16 */     super(world, entityliving);
/*    */   }
/*    */   
/*    */   protected void a(MovingObjectPosition movingobjectposition) {
/* 20 */     if (movingobjectposition.entity != null) {
/* 21 */       movingobjectposition.entity.damageEntity(DamageSource.projectile(this, getShooter()), 0.0F);
/*    */     }
/*    */     
/* 24 */     for (int i = 0; i < 32; i++) {
/* 25 */       this.world.addParticle("portal", this.locX, this.locY + this.random.nextDouble() * 2.0D, this.locZ, this.random.nextGaussian(), 0.0D, this.random.nextGaussian());
/*    */     }
/*    */     
/* 28 */     if (!this.world.isStatic) {
/* 29 */       if (getShooter() != null && getShooter() instanceof EntityPlayer) {
/* 30 */         EntityPlayer entityplayer = (EntityPlayer)getShooter();
/*    */         
/* 32 */         if (entityplayer.playerConnection.b().isConnected() && entityplayer.world == this.world) {
/*    */           
/* 34 */           CraftPlayer player = entityplayer.getBukkitEntity();
/* 35 */           Location location = getBukkitEntity().getLocation();
/* 36 */           location.setPitch(player.getLocation().getPitch());
/* 37 */           location.setYaw(player.getLocation().getYaw());
/*    */           
/* 39 */           PlayerTeleportEvent teleEvent = new PlayerTeleportEvent((Player)player, player.getLocation(), location, PlayerTeleportEvent.TeleportCause.ENDER_PEARL);
/* 40 */           Bukkit.getPluginManager().callEvent((Event)teleEvent);
/*    */           
/* 42 */           if (!teleEvent.isCancelled() && !entityplayer.playerConnection.isDisconnected()) {
/* 43 */             if (getShooter().am()) {
/* 44 */               getShooter().mount((Entity)null);
/*    */             }
/*    */             
/* 47 */             entityplayer.playerConnection.teleport(teleEvent.getTo());
/* 48 */             (getShooter()).fallDistance = 0.0F;
/* 49 */             CraftEventFactory.entityDamage = this;
/* 50 */             getShooter().damageEntity(DamageSource.FALL, 5.0F);
/* 51 */             CraftEventFactory.entityDamage = null;
/*    */           } 
/*    */         } 
/*    */       } 
/*    */ 
/*    */       
/* 57 */       die();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityEnderPearl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */