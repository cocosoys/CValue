/*    */ package net.minecraft.server.v1_7_R4;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftEntity;
/*    */ import org.bukkit.entity.Explosive;
/*    */ import org.bukkit.event.entity.ExplosionPrimeEvent;
/*    */ 
/*    */ public class EntityTNTPrimed extends Entity {
/*    */   public int fuseTicks;
/*  9 */   public float yield = 4.0F; private EntityLiving source;
/*    */   public boolean isIncendiary = false;
/*    */   
/*    */   public EntityTNTPrimed(World world) {
/* 13 */     super(world);
/* 14 */     this.k = true;
/* 15 */     a(0.98F, 0.98F);
/* 16 */     this.height = this.length / 2.0F;
/*    */   }
/*    */   
/*    */   public EntityTNTPrimed(World world, double d0, double d1, double d2, EntityLiving entityliving) {
/* 20 */     this(world);
/* 21 */     setPosition(d0, d1, d2);
/* 22 */     float f = (float)(Math.random() * 3.1415927410125732D * 2.0D);
/*    */     
/* 24 */     this.motX = (-((float)Math.sin(f)) * 0.02F);
/* 25 */     this.motY = 0.20000000298023224D;
/* 26 */     this.motZ = (-((float)Math.cos(f)) * 0.02F);
/* 27 */     this.fuseTicks = 80;
/* 28 */     this.lastX = d0;
/* 29 */     this.lastY = d1;
/* 30 */     this.lastZ = d2;
/* 31 */     this.source = entityliving;
/*    */   }
/*    */   
/*    */   protected void c() {}
/*    */   
/*    */   protected boolean g_() {
/* 37 */     return false;
/*    */   }
/*    */   
/*    */   public boolean R() {
/* 41 */     return !this.dead;
/*    */   }
/*    */   
/*    */   public void h() {
/* 45 */     this.lastX = this.locX;
/* 46 */     this.lastY = this.locY;
/* 47 */     this.lastZ = this.locZ;
/* 48 */     this.motY -= 0.03999999910593033D;
/* 49 */     move(this.motX, this.motY, this.motZ);
/* 50 */     this.motX *= 0.9800000190734863D;
/* 51 */     this.motY *= 0.9800000190734863D;
/* 52 */     this.motZ *= 0.9800000190734863D;
/* 53 */     if (this.onGround) {
/* 54 */       this.motX *= 0.699999988079071D;
/* 55 */       this.motZ *= 0.699999988079071D;
/* 56 */       this.motY *= -0.5D;
/*    */     } 
/*    */     
/* 59 */     if (this.fuseTicks-- <= 0) {
/*    */       
/* 61 */       if (!this.world.isStatic) {
/* 62 */         explode();
/*    */       }
/* 64 */       die();
/*    */     } else {
/*    */       
/* 67 */       this.world.addParticle("smoke", this.locX, this.locY + 0.5D, this.locZ, 0.0D, 0.0D, 0.0D);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void explode() {
/* 75 */     CraftServer server = this.world.getServer();
/*    */     
/* 77 */     ExplosionPrimeEvent event = new ExplosionPrimeEvent((Explosive)CraftEntity.getEntity(server, this));
/* 78 */     server.getPluginManager().callEvent((Event)event);
/*    */     
/* 80 */     if (!event.isCancelled())
/*    */     {
/* 82 */       this.world.createExplosion(this, this.locX, this.locY, this.locZ, event.getRadius(), event.getFire(), true);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected void b(NBTTagCompound nbttagcompound) {
/* 88 */     nbttagcompound.setByte("Fuse", (byte)this.fuseTicks);
/*    */   }
/*    */   
/*    */   protected void a(NBTTagCompound nbttagcompound) {
/* 92 */     this.fuseTicks = nbttagcompound.getByte("Fuse");
/*    */   }
/*    */   
/*    */   public EntityLiving getSource() {
/* 96 */     return this.source;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityTNTPrimed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */