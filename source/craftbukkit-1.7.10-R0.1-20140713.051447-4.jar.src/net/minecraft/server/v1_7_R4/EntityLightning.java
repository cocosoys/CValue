/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityLightning
/*     */   extends EntityWeather
/*     */ {
/*     */   private int lifeTicks;
/*     */   public long a;
/*     */   private int c;
/*     */   public boolean isEffect = false;
/*     */   
/*     */   public EntityLightning(World world, double d0, double d1, double d2) {
/*  17 */     this(world, d0, d1, d2, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityLightning(World world, double d0, double d1, double d2, boolean isEffect) {
/*  23 */     super(world);
/*     */ 
/*     */     
/*  26 */     this.isEffect = isEffect;
/*     */     
/*  28 */     setPositionRotation(d0, d1, d2, 0.0F, 0.0F);
/*  29 */     this.lifeTicks = 2;
/*  30 */     this.a = this.random.nextLong();
/*  31 */     this.c = this.random.nextInt(3) + 1;
/*     */ 
/*     */     
/*  34 */     if (!isEffect && !world.isStatic && world.getGameRules().getBoolean("doFireTick") && (world.difficulty == EnumDifficulty.NORMAL || world.difficulty == EnumDifficulty.HARD) && world.areChunksLoaded(MathHelper.floor(d0), MathHelper.floor(d1), MathHelper.floor(d2), 10)) {
/*  35 */       int i = MathHelper.floor(d0);
/*  36 */       int j = MathHelper.floor(d1);
/*  37 */       int k = MathHelper.floor(d2);
/*     */       
/*  39 */       if (world.getType(i, j, k).getMaterial() == Material.AIR && Blocks.FIRE.canPlace(world, i, j, k))
/*     */       {
/*  41 */         if (!CraftEventFactory.callBlockIgniteEvent(world, i, j, k, this).isCancelled()) {
/*  42 */           world.setTypeUpdate(i, j, k, Blocks.FIRE);
/*     */         }
/*     */       }
/*     */ 
/*     */       
/*  47 */       for (i = 0; i < 4; i++) {
/*  48 */         j = MathHelper.floor(d0) + this.random.nextInt(3) - 1;
/*  49 */         k = MathHelper.floor(d1) + this.random.nextInt(3) - 1;
/*  50 */         int l = MathHelper.floor(d2) + this.random.nextInt(3) - 1;
/*     */         
/*  52 */         if (world.getType(j, k, l).getMaterial() == Material.AIR && Blocks.FIRE.canPlace(world, j, k, l))
/*     */         {
/*  54 */           if (!CraftEventFactory.callBlockIgniteEvent(world, j, k, l, this).isCancelled()) {
/*  55 */             world.setTypeUpdate(j, k, l, Blocks.FIRE);
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void h() {
/*  64 */     super.h();
/*  65 */     if (this.lifeTicks == 2) {
/*  66 */       this.world.makeSound(this.locX, this.locY, this.locZ, "ambient.weather.thunder", 10000.0F, 0.8F + this.random.nextFloat() * 0.2F);
/*  67 */       this.world.makeSound(this.locX, this.locY, this.locZ, "random.explode", 2.0F, 0.5F + this.random.nextFloat() * 0.2F);
/*     */     } 
/*     */     
/*  70 */     this.lifeTicks--;
/*  71 */     if (this.lifeTicks < 0) {
/*  72 */       if (this.c == 0) {
/*  73 */         die();
/*  74 */       } else if (this.lifeTicks < -this.random.nextInt(10)) {
/*  75 */         this.c--;
/*  76 */         this.lifeTicks = 1;
/*  77 */         this.a = this.random.nextLong();
/*     */         
/*  79 */         if (!this.isEffect && !this.world.isStatic && this.world.getGameRules().getBoolean("doFireTick") && this.world.areChunksLoaded(MathHelper.floor(this.locX), MathHelper.floor(this.locY), MathHelper.floor(this.locZ), 10)) {
/*  80 */           int i = MathHelper.floor(this.locX);
/*  81 */           int j = MathHelper.floor(this.locY);
/*  82 */           int k = MathHelper.floor(this.locZ);
/*     */           
/*  84 */           if (this.world.getType(i, j, k).getMaterial() == Material.AIR && Blocks.FIRE.canPlace(this.world, i, j, k))
/*     */           {
/*  86 */             if (!CraftEventFactory.callBlockIgniteEvent(this.world, i, j, k, this).isCancelled()) {
/*  87 */               this.world.setTypeUpdate(i, j, k, Blocks.FIRE);
/*     */             }
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  95 */     if (this.lifeTicks >= 0 && !this.isEffect)
/*  96 */       if (this.world.isStatic) {
/*  97 */         this.world.q = 2;
/*     */       } else {
/*  99 */         double d0 = 3.0D;
/* 100 */         List<Entity> list = this.world.getEntities(this, AxisAlignedBB.a(this.locX - d0, this.locY - d0, this.locZ - d0, this.locX + d0, this.locY + 6.0D + d0, this.locZ + d0));
/*     */         
/* 102 */         for (int l = 0; l < list.size(); l++) {
/* 103 */           Entity entity = list.get(l);
/*     */           
/* 105 */           entity.a(this);
/*     */         } 
/*     */       }  
/*     */   }
/*     */   
/*     */   protected void c() {}
/*     */   
/*     */   protected void a(NBTTagCompound nbttagcompound) {}
/*     */   
/*     */   protected void b(NBTTagCompound nbttagcompound) {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityLightning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */