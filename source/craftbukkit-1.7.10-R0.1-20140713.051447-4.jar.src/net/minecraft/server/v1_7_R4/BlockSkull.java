/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Random;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.util.BlockStateListPopulator;
/*     */ import org.bukkit.event.entity.CreatureSpawnEvent;
/*     */ 
/*     */ 
/*     */ public class BlockSkull
/*     */   extends BlockContainer
/*     */ {
/*     */   protected BlockSkull() {
/*  14 */     super(Material.ORIENTABLE);
/*  15 */     a(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
/*     */   }
/*     */   
/*     */   public int b() {
/*  19 */     return -1;
/*     */   }
/*     */   
/*     */   public boolean c() {
/*  23 */     return false;
/*     */   }
/*     */   
/*     */   public boolean d() {
/*  27 */     return false;
/*     */   }
/*     */   
/*     */   public void updateShape(IBlockAccess iblockaccess, int i, int j, int k) {
/*  31 */     int l = iblockaccess.getData(i, j, k) & 0x7;
/*     */     
/*  33 */     switch (l) {
/*     */       
/*     */       default:
/*  36 */         a(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
/*     */         return;
/*     */       
/*     */       case 2:
/*  40 */         a(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
/*     */         return;
/*     */       
/*     */       case 3:
/*  44 */         a(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
/*     */         return;
/*     */       
/*     */       case 4:
/*  48 */         a(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F); return;
/*     */       case 5:
/*     */         break;
/*     */     } 
/*  52 */     a(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB a(World world, int i, int j, int k) {
/*  57 */     updateShape(world, i, j, k);
/*  58 */     return super.a(world, i, j, k);
/*     */   }
/*     */   
/*     */   public void postPlace(World world, int i, int j, int k, EntityLiving entityliving, ItemStack itemstack) {
/*  62 */     int l = MathHelper.floor((entityliving.yaw * 4.0F / 360.0F) + 2.5D) & 0x3;
/*     */     
/*  64 */     world.setData(i, j, k, l, 2);
/*     */   }
/*     */   
/*     */   public TileEntity a(World world, int i) {
/*  68 */     return new TileEntitySkull();
/*     */   }
/*     */   
/*     */   public int getDropData(World world, int i, int j, int k) {
/*  72 */     TileEntity tileentity = world.getTileEntity(i, j, k);
/*     */     
/*  74 */     return (tileentity != null && tileentity instanceof TileEntitySkull) ? ((TileEntitySkull)tileentity).getSkullType() : super.getDropData(world, i, j, k);
/*     */   }
/*     */   
/*     */   public int getDropData(int i) {
/*  78 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dropNaturally(World world, int i, int j, int k, int l, float f, int i1) {
/*  83 */     if (world.random.nextFloat() < f) {
/*  84 */       ItemStack itemstack = new ItemStack(Items.SKULL, 1, getDropData(world, i, j, k));
/*  85 */       TileEntitySkull tileentityskull = (TileEntitySkull)world.getTileEntity(i, j, k);
/*     */       
/*  87 */       if (tileentityskull.getSkullType() == 3 && tileentityskull.getGameProfile() != null) {
/*  88 */         itemstack.setTag(new NBTTagCompound());
/*  89 */         NBTTagCompound nbttagcompound = new NBTTagCompound();
/*     */         
/*  91 */         GameProfileSerializer.serialize(nbttagcompound, tileentityskull.getGameProfile());
/*  92 */         itemstack.getTag().set("SkullOwner", nbttagcompound);
/*     */       } 
/*     */       
/*  95 */       a(world, i, j, k, itemstack);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(World world, int i, int j, int k, int l, EntityHuman entityhuman) {
/* 101 */     if (entityhuman.abilities.canInstantlyBuild) {
/* 102 */       l |= 0x8;
/* 103 */       world.setData(i, j, k, l, 4);
/*     */     } 
/*     */     
/* 106 */     super.a(world, i, j, k, l, entityhuman);
/*     */   }
/*     */   
/*     */   public void remove(World world, int i, int j, int k, Block block, int l) {
/* 110 */     if (!world.isStatic)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 129 */       super.remove(world, i, j, k, block, l);
/*     */     }
/*     */   }
/*     */   
/*     */   public Item getDropType(int i, Random random, int j) {
/* 134 */     return Items.SKULL;
/*     */   }
/*     */   
/*     */   public void a(World world, int i, int j, int k, TileEntitySkull tileentityskull) {
/* 138 */     if (tileentityskull.getSkullType() == 1 && j >= 2 && world.difficulty != EnumDifficulty.PEACEFUL && !world.isStatic) {
/*     */       int l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 145 */       for (l = -2; l <= 0; l++) {
/* 146 */         if (world.getType(i, j - 1, k + l) == Blocks.SOUL_SAND && world.getType(i, j - 1, k + l + 1) == Blocks.SOUL_SAND && world.getType(i, j - 2, k + l + 1) == Blocks.SOUL_SAND && world.getType(i, j - 1, k + l + 2) == Blocks.SOUL_SAND && a(world, i, j, k + l, 1) && a(world, i, j, k + l + 1, 1) && a(world, i, j, k + l + 2, 1)) {
/*     */           
/* 148 */           BlockStateListPopulator blockList = new BlockStateListPopulator((World)world.getWorld());
/*     */           
/* 150 */           world.setData(i, j, k + l, 8, 2);
/* 151 */           world.setData(i, j, k + l + 1, 8, 2);
/* 152 */           world.setData(i, j, k + l + 2, 8, 2);
/*     */           
/* 154 */           blockList.setTypeAndData(i, j, k + l, getById(0), 0, 2);
/* 155 */           blockList.setTypeAndData(i, j, k + l + 1, getById(0), 0, 2);
/* 156 */           blockList.setTypeAndData(i, j, k + l + 2, getById(0), 0, 2);
/* 157 */           blockList.setTypeAndData(i, j - 1, k + l, getById(0), 0, 2);
/* 158 */           blockList.setTypeAndData(i, j - 1, k + l + 1, getById(0), 0, 2);
/* 159 */           blockList.setTypeAndData(i, j - 1, k + l + 2, getById(0), 0, 2);
/* 160 */           blockList.setTypeAndData(i, j - 2, k + l + 1, getById(0), 0, 2);
/*     */           
/* 162 */           if (!world.isStatic) {
/* 163 */             EntityWither entitywither = new EntityWither(world);
/* 164 */             entitywither.setPositionRotation(i + 0.5D, j - 1.45D, (k + l) + 1.5D, 90.0F, 0.0F);
/* 165 */             entitywither.aM = 90.0F;
/* 166 */             entitywither.bZ();
/*     */             
/* 168 */             if (world.addEntity(entitywither, CreatureSpawnEvent.SpawnReason.BUILD_WITHER)) {
/* 169 */               if (!world.isStatic) {
/* 170 */                 Iterator<EntityHuman> iterator = world.a(EntityHuman.class, entitywither.boundingBox.grow(50.0D, 50.0D, 50.0D)).iterator();
/*     */                 
/* 172 */                 while (iterator.hasNext()) {
/* 173 */                   EntityHuman entityhuman = iterator.next();
/* 174 */                   entityhuman.a(AchievementList.I);
/*     */                 } 
/*     */               } 
/*     */               
/* 178 */               blockList.updateList();
/*     */             } 
/*     */           } 
/*     */           
/* 182 */           for (int i1 = 0; i1 < 120; i1++) {
/* 183 */             world.addParticle("snowballpoof", i + world.random.nextDouble(), (j - 2) + world.random.nextDouble() * 3.9D, (k + l + 1) + world.random.nextDouble(), 0.0D, 0.0D, 0.0D);
/*     */           }
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */       
/* 190 */       for (l = -2; l <= 0; l++) {
/* 191 */         if (world.getType(i + l, j - 1, k) == Blocks.SOUL_SAND && world.getType(i + l + 1, j - 1, k) == Blocks.SOUL_SAND && world.getType(i + l + 1, j - 2, k) == Blocks.SOUL_SAND && world.getType(i + l + 2, j - 1, k) == Blocks.SOUL_SAND && a(world, i + l, j, k, 1) && a(world, i + l + 1, j, k, 1) && a(world, i + l + 2, j, k, 1)) {
/*     */           
/* 193 */           BlockStateListPopulator blockList = new BlockStateListPopulator((World)world.getWorld());
/*     */           
/* 195 */           world.setData(i + l, j, k, 8, 2);
/* 196 */           world.setData(i + l + 1, j, k, 8, 2);
/* 197 */           world.setData(i + l + 2, j, k, 8, 2);
/*     */           
/* 199 */           blockList.setTypeAndData(i + l, j, k, getById(0), 0, 2);
/* 200 */           blockList.setTypeAndData(i + l + 1, j, k, getById(0), 0, 2);
/* 201 */           blockList.setTypeAndData(i + l + 2, j, k, getById(0), 0, 2);
/* 202 */           blockList.setTypeAndData(i + l, j - 1, k, getById(0), 0, 2);
/* 203 */           blockList.setTypeAndData(i + l + 1, j - 1, k, getById(0), 0, 2);
/* 204 */           blockList.setTypeAndData(i + l + 2, j - 1, k, getById(0), 0, 2);
/* 205 */           blockList.setTypeAndData(i + l + 1, j - 2, k, getById(0), 0, 2);
/* 206 */           if (!world.isStatic) {
/* 207 */             EntityWither entitywither = new EntityWither(world);
/* 208 */             entitywither.setPositionRotation((i + l) + 1.5D, j - 1.45D, k + 0.5D, 0.0F, 0.0F);
/* 209 */             entitywither.bZ();
/*     */             
/* 211 */             if (world.addEntity(entitywither, CreatureSpawnEvent.SpawnReason.BUILD_WITHER)) {
/* 212 */               if (!world.isStatic) {
/* 213 */                 Iterator<EntityHuman> iterator = world.a(EntityHuman.class, entitywither.boundingBox.grow(50.0D, 50.0D, 50.0D)).iterator();
/*     */                 
/* 215 */                 while (iterator.hasNext()) {
/* 216 */                   EntityHuman entityhuman = iterator.next();
/* 217 */                   entityhuman.a(AchievementList.I);
/*     */                 } 
/*     */               } 
/* 220 */               blockList.updateList();
/*     */             } 
/*     */           } 
/*     */           
/* 224 */           for (int i1 = 0; i1 < 120; i1++) {
/* 225 */             world.addParticle("snowballpoof", (i + l + 1) + world.random.nextDouble(), (j - 2) + world.random.nextDouble() * 3.9D, k + world.random.nextDouble(), 0.0D, 0.0D, 0.0D);
/*     */           }
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(World world, int i, int j, int k, int l) {
/* 236 */     if (world.getType(i, j, k) != this) {
/* 237 */       return false;
/*     */     }
/* 239 */     TileEntity tileentity = world.getTileEntity(i, j, k);
/*     */     
/* 241 */     return (tileentity != null && tileentity instanceof TileEntitySkull) ? ((((TileEntitySkull)tileentity).getSkullType() == l)) : false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockSkull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */