/*     */ package net.minecraft.server.v1_7_R4;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftEntity;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.entity.EntityExplodeEvent;
/*     */ 
/*     */ public class Explosion {
/*     */   public boolean a;
/*  21 */   private int i = 16; public boolean b = true;
/*  22 */   private Random j = new Random();
/*     */   private World world;
/*     */   public double posX;
/*     */   public double posY;
/*     */   public double posZ;
/*     */   public Entity source;
/*     */   public float size;
/*  29 */   public List blocks = new ArrayList();
/*  30 */   private Map l = new HashMap<Object, Object>();
/*     */   public boolean wasCanceled = false;
/*     */   
/*     */   public Explosion(World world, Entity entity, double d0, double d1, double d2, float f) {
/*  34 */     this.world = world;
/*  35 */     this.source = entity;
/*  36 */     this.size = (float)Math.max(f, 0.0D);
/*  37 */     this.posX = d0;
/*  38 */     this.posY = d1;
/*  39 */     this.posZ = d2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a() {
/*  44 */     if (this.size < 0.1F) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  49 */     float f = this.size;
/*  50 */     HashSet<ChunkPosition> hashset = new HashSet();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */ 
/*     */     
/*  59 */     for (i = 0; i < this.i; i++) {
/*  60 */       for (int m = 0; m < this.i; m++) {
/*  61 */         for (int n = 0; n < this.i; n++) {
/*  62 */           if (i == 0 || i == this.i - 1 || m == 0 || m == this.i - 1 || n == 0 || n == this.i - 1) {
/*  63 */             double d3 = (i / (this.i - 1.0F) * 2.0F - 1.0F);
/*  64 */             double d4 = (m / (this.i - 1.0F) * 2.0F - 1.0F);
/*  65 */             double d5 = (n / (this.i - 1.0F) * 2.0F - 1.0F);
/*  66 */             double d6 = Math.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
/*     */             
/*  68 */             d3 /= d6;
/*  69 */             d4 /= d6;
/*  70 */             d5 /= d6;
/*  71 */             float f1 = this.size * (0.7F + this.world.random.nextFloat() * 0.6F);
/*     */             
/*  73 */             double d0 = this.posX;
/*  74 */             double d1 = this.posY;
/*  75 */             double d2 = this.posZ;
/*     */             
/*  77 */             for (float f2 = 0.3F; f1 > 0.0F; f1 -= f2 * 0.75F) {
/*  78 */               int l = MathHelper.floor(d0);
/*  79 */               int i1 = MathHelper.floor(d1);
/*  80 */               int j1 = MathHelper.floor(d2);
/*  81 */               Block block = this.world.getType(l, i1, j1);
/*     */               
/*  83 */               if (block.getMaterial() != Material.AIR) {
/*  84 */                 float f3 = (this.source != null) ? this.source.a(this, this.world, l, i1, j1, block) : block.a(this.source);
/*     */                 
/*  86 */                 f1 -= (f3 + 0.3F) * f2;
/*     */               } 
/*     */               
/*  89 */               if (f1 > 0.0F && (this.source == null || this.source.a(this, this.world, l, i1, j1, block, f1)) && i1 < 256 && i1 >= 0) {
/*  90 */                 hashset.add(new ChunkPosition(l, i1, j1));
/*     */               }
/*     */               
/*  93 */               d0 += d3 * f2;
/*  94 */               d1 += d4 * f2;
/*  95 */               d2 += d5 * f2;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 102 */     this.blocks.addAll(hashset);
/* 103 */     this.size *= 2.0F;
/* 104 */     i = MathHelper.floor(this.posX - this.size - 1.0D);
/* 105 */     int j = MathHelper.floor(this.posX + this.size + 1.0D);
/* 106 */     int k = MathHelper.floor(this.posY - this.size - 1.0D);
/* 107 */     int k1 = MathHelper.floor(this.posY + this.size + 1.0D);
/* 108 */     int l1 = MathHelper.floor(this.posZ - this.size - 1.0D);
/* 109 */     int i2 = MathHelper.floor(this.posZ + this.size + 1.0D);
/* 110 */     List<Entity> list = this.world.getEntities(this.source, AxisAlignedBB.a(i, k, l1, j, k1, i2));
/* 111 */     Vec3D vec3d = Vec3D.a(this.posX, this.posY, this.posZ);
/*     */     
/* 113 */     for (int j2 = 0; j2 < list.size(); j2++) {
/* 114 */       Entity entity = list.get(j2);
/* 115 */       double d7 = entity.f(this.posX, this.posY, this.posZ) / this.size;
/*     */       
/* 117 */       if (d7 <= 1.0D) {
/* 118 */         double d0 = entity.locX - this.posX;
/* 119 */         double d1 = entity.locY + entity.getHeadHeight() - this.posY;
/* 120 */         double d2 = entity.locZ - this.posZ;
/* 121 */         double d8 = MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
/*     */         
/* 123 */         if (d8 != 0.0D) {
/* 124 */           d0 /= d8;
/* 125 */           d1 /= d8;
/* 126 */           d2 /= d8;
/* 127 */           double d9 = this.world.a(vec3d, entity.boundingBox);
/* 128 */           double d10 = (1.0D - d7) * d9;
/*     */ 
/*     */           
/* 131 */           CraftEventFactory.entityDamage = this.source;
/* 132 */           if (!entity.damageEntity(DamageSource.explosion(this), (int)((d10 * d10 + d10) / 2.0D * 8.0D * this.size + 1.0D))) {
/* 133 */             CraftEventFactory.entityDamage = null;
/*     */           }
/*     */           else {
/*     */             
/* 137 */             double d11 = EnchantmentProtection.a(entity, d10);
/*     */             
/* 139 */             entity.motX += d0 * d11;
/* 140 */             entity.motY += d1 * d11;
/* 141 */             entity.motZ += d2 * d11;
/* 142 */             if (entity instanceof EntityHuman) {
/* 143 */               this.l.put((EntityHuman)entity, Vec3D.a(d0 * d10, d1 * d10, d2 * d10));
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 149 */     this.size = f;
/*     */   }
/*     */   
/*     */   public void a(boolean flag) {
/* 153 */     this.world.makeSound(this.posX, this.posY, this.posZ, "random.explode", 4.0F, (1.0F + (this.world.random.nextFloat() - this.world.random.nextFloat()) * 0.2F) * 0.7F);
/* 154 */     if (this.size >= 2.0F && this.b) {
/* 155 */       this.world.addParticle("hugeexplosion", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
/*     */     } else {
/* 157 */       this.world.addParticle("largeexplode", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 167 */     if (this.b) {
/*     */       
/* 169 */       CraftWorld craftWorld = this.world.getWorld();
/* 170 */       CraftEntity craftEntity = (this.source == null) ? null : this.source.getBukkitEntity();
/* 171 */       Location location = new Location((World)craftWorld, this.posX, this.posY, this.posZ);
/*     */       
/* 173 */       List<Block> blockList = new ArrayList<Block>();
/* 174 */       for (int i1 = this.blocks.size() - 1; i1 >= 0; i1--) {
/* 175 */         ChunkPosition cpos = this.blocks.get(i1);
/* 176 */         Block bblock = craftWorld.getBlockAt(cpos.x, cpos.y, cpos.z);
/* 177 */         if (bblock.getType() != Material.AIR) {
/* 178 */           blockList.add(bblock);
/*     */         }
/*     */       } 
/*     */       
/* 182 */       EntityExplodeEvent event = new EntityExplodeEvent((Entity)craftEntity, location, blockList, 0.3F);
/* 183 */       this.world.getServer().getPluginManager().callEvent((Event)event);
/*     */       
/* 185 */       this.blocks.clear();
/*     */       
/* 187 */       for (Block bblock : event.blockList()) {
/* 188 */         ChunkPosition coords = new ChunkPosition(bblock.getX(), bblock.getY(), bblock.getZ());
/* 189 */         this.blocks.add(coords);
/*     */       } 
/*     */       
/* 192 */       if (event.isCancelled()) {
/* 193 */         this.wasCanceled = true;
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 198 */       Iterator<ChunkPosition> iterator = this.blocks.iterator();
/*     */       
/* 200 */       while (iterator.hasNext()) {
/* 201 */         ChunkPosition chunkposition = iterator.next();
/* 202 */         int i = chunkposition.x;
/* 203 */         int j = chunkposition.y;
/* 204 */         int k = chunkposition.z;
/* 205 */         Block block = this.world.getType(i, j, k);
/* 206 */         if (flag) {
/* 207 */           double d0 = (i + this.world.random.nextFloat());
/* 208 */           double d1 = (j + this.world.random.nextFloat());
/* 209 */           double d2 = (k + this.world.random.nextFloat());
/* 210 */           double d3 = d0 - this.posX;
/* 211 */           double d4 = d1 - this.posY;
/* 212 */           double d5 = d2 - this.posZ;
/* 213 */           double d6 = MathHelper.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
/*     */           
/* 215 */           d3 /= d6;
/* 216 */           d4 /= d6;
/* 217 */           d5 /= d6;
/* 218 */           double d7 = 0.5D / (d6 / this.size + 0.1D);
/*     */           
/* 220 */           d7 *= (this.world.random.nextFloat() * this.world.random.nextFloat() + 0.3F);
/* 221 */           d3 *= d7;
/* 222 */           d4 *= d7;
/* 223 */           d5 *= d7;
/* 224 */           this.world.addParticle("explode", (d0 + this.posX * 1.0D) / 2.0D, (d1 + this.posY * 1.0D) / 2.0D, (d2 + this.posZ * 1.0D) / 2.0D, d3, d4, d5);
/* 225 */           this.world.addParticle("smoke", d0, d1, d2, d3, d4, d5);
/*     */         } 
/*     */         
/* 228 */         if (block.getMaterial() != Material.AIR) {
/* 229 */           if (block.a(this))
/*     */           {
/* 231 */             block.dropNaturally(this.world, i, j, k, this.world.getData(i, j, k), event.getYield(), 0);
/*     */           }
/*     */           
/* 234 */           this.world.setTypeAndData(i, j, k, Blocks.AIR, 0, 3);
/* 235 */           block.wasExploded(this.world, i, j, k, this);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 240 */     if (this.a) {
/* 241 */       Iterator<ChunkPosition> iterator = this.blocks.iterator();
/*     */       
/* 243 */       while (iterator.hasNext()) {
/* 244 */         ChunkPosition chunkposition = iterator.next();
/* 245 */         int i = chunkposition.x;
/* 246 */         int j = chunkposition.y;
/* 247 */         int k = chunkposition.z;
/* 248 */         Block block = this.world.getType(i, j, k);
/* 249 */         Block block1 = this.world.getType(i, j - 1, k);
/*     */         
/* 251 */         if (block.getMaterial() == Material.AIR && block1.j() && this.j.nextInt(3) == 0)
/*     */         {
/* 253 */           if (!CraftEventFactory.callBlockIgniteEvent(this.world, i, j, k, this).isCancelled()) {
/* 254 */             this.world.setTypeUpdate(i, j, k, Blocks.FIRE);
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Map b() {
/* 263 */     return this.l;
/*     */   }
/*     */   
/*     */   public EntityLiving c() {
/* 267 */     return (this.source == null) ? null : ((this.source instanceof EntityTNTPrimed) ? ((EntityTNTPrimed)this.source).getSource() : ((this.source instanceof EntityLiving) ? (EntityLiving)this.source : null));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\Explosion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */