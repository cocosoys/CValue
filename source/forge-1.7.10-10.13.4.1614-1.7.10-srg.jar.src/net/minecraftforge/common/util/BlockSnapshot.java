/*     */ package net.minecraftforge.common.util;
/*     */ 
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import java.io.Serializable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.DimensionManager;
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
/*     */ public class BlockSnapshot
/*     */   implements Serializable
/*     */ {
/*  24 */   private static final boolean DEBUG = Boolean.parseBoolean(System.getProperty("forge.debugBlockSnapshot", "false"));
/*     */   
/*     */   public final int x;
/*     */   
/*     */   public final int y;
/*     */   public final int z;
/*     */   public final int dimId;
/*     */   public transient Block replacedBlock;
/*     */   public final int meta;
/*     */   public int flag;
/*     */   private final NBTTagCompound nbt;
/*     */   public transient World world;
/*     */   public final GameRegistry.UniqueIdentifier blockIdentifier;
/*     */   
/*     */   public BlockSnapshot(World world, int x, int y, int z, Block block, int meta) {
/*  39 */     this.world = world;
/*  40 */     this.dimId = world.provider.dimensionId;
/*  41 */     this.x = x;
/*  42 */     this.y = y;
/*  43 */     this.z = z;
/*  44 */     this.replacedBlock = block;
/*  45 */     this.blockIdentifier = GameRegistry.findUniqueIdentifierFor(block);
/*  46 */     this.meta = meta;
/*  47 */     this.flag = 3;
/*  48 */     TileEntity te = world.getTileEntity(x, y, z);
/*  49 */     if (te != null) {
/*     */       
/*  51 */       this.nbt = new NBTTagCompound();
/*  52 */       te.writeToNBT(this.nbt);
/*     */     } else {
/*  54 */       this.nbt = null;
/*  55 */     }  if (DEBUG)
/*     */     {
/*  57 */       System.out.printf("Created BlockSnapshot - [World: %s ][Location: %d,%d,%d ][Block: %s ][Meta: %d ]", new Object[] { world.getWorldInfo().getWorldName(), Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(z), block, Integer.valueOf(meta) });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockSnapshot(World world, int x, int y, int z, Block block, int meta, NBTTagCompound nbt) {
/*  63 */     this.world = world;
/*  64 */     this.dimId = world.provider.dimensionId;
/*  65 */     this.x = x;
/*  66 */     this.y = y;
/*  67 */     this.z = z;
/*  68 */     this.replacedBlock = block;
/*  69 */     this.blockIdentifier = GameRegistry.findUniqueIdentifierFor(block);
/*  70 */     this.meta = meta;
/*  71 */     this.flag = 3;
/*  72 */     this.nbt = nbt;
/*  73 */     if (DEBUG)
/*     */     {
/*  75 */       System.out.printf("Created BlockSnapshot - [World: %s ][Location: %d,%d,%d ][Block: %s ][Meta: %d ]", new Object[] { world.getWorldInfo().getWorldName(), Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(z), block, Integer.valueOf(meta) });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockSnapshot(World world, int x, int y, int z, Block block, int meta, int flag) {
/*  81 */     this(world, x, y, z, block, meta);
/*  82 */     this.flag = flag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockSnapshot(int dimension, int x, int y, int z, String modid, String blockName, int meta, int flag, NBTTagCompound nbt) {
/*  90 */     this.dimId = dimension;
/*  91 */     this.x = x;
/*  92 */     this.y = y;
/*  93 */     this.z = z;
/*  94 */     this.meta = meta;
/*  95 */     this.flag = flag;
/*  96 */     this.blockIdentifier = new GameRegistry.UniqueIdentifier(modid + ":" + blockName);
/*  97 */     this.nbt = nbt;
/*     */   }
/*     */ 
/*     */   
/*     */   public static BlockSnapshot getBlockSnapshot(World world, int x, int y, int z) {
/* 102 */     return new BlockSnapshot(world, x, y, z, world.getBlock(x, y, z), world.getBlockMetadata(x, y, z));
/*     */   }
/*     */ 
/*     */   
/*     */   public static BlockSnapshot getBlockSnapshot(World world, int x, int y, int z, int flag) {
/* 107 */     return new BlockSnapshot(world, x, y, z, world.getBlock(x, y, z), world.getBlockMetadata(x, y, z), flag);
/*     */   }
/*     */ 
/*     */   
/*     */   public static BlockSnapshot readFromNBT(NBTTagCompound tag) {
/* 112 */     NBTTagCompound nbt = tag.getBoolean("hasTE") ? null : tag.getCompoundTag("tileEntity");
/*     */     
/* 114 */     return new BlockSnapshot(tag
/* 115 */         .getInteger("dimension"), tag
/* 116 */         .getInteger("posX"), tag
/* 117 */         .getInteger("posY"), tag
/* 118 */         .getInteger("posZ"), tag
/* 119 */         .getString("blockMod"), tag
/* 120 */         .getString("blockName"), tag
/* 121 */         .getInteger("metadata"), tag
/* 122 */         .getInteger("flag"), nbt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Block getCurrentBlock() {
/* 128 */     return this.world.getBlock(this.x, this.y, this.z);
/*     */   }
/*     */ 
/*     */   
/*     */   public World getWorld() {
/* 133 */     if (this.world == null)
/*     */     {
/* 135 */       this.world = (World)DimensionManager.getWorld(this.dimId);
/*     */     }
/* 137 */     return this.world;
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getReplacedBlock() {
/* 142 */     if (this.replacedBlock == null)
/*     */     {
/* 144 */       this.replacedBlock = GameRegistry.findBlock(this.blockIdentifier.modId, this.blockIdentifier.name);
/*     */     }
/* 146 */     return this.replacedBlock;
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity getTileEntity() {
/* 151 */     if (this.nbt != null)
/* 152 */       return TileEntity.createAndLoadEntity(this.nbt); 
/* 153 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean restore() {
/* 158 */     return restore(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean restore(boolean force) {
/* 163 */     return restore(force, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean restore(boolean force, boolean applyPhysics) {
/* 168 */     if (getCurrentBlock() != getReplacedBlock() || this.world.getBlockMetadata(this.x & 0xF, this.y, this.z & 0xF) != this.meta)
/*     */     {
/* 170 */       if (force) {
/*     */         
/* 172 */         this.world.setBlock(this.x, this.y, this.z, getReplacedBlock(), this.meta, applyPhysics ? 3 : 2);
/*     */       }
/*     */       else {
/*     */         
/* 176 */         return false;
/*     */       } 
/*     */     }
/*     */     
/* 180 */     this.world.setBlockMetadataWithNotify(this.x, this.y, this.z, this.meta, applyPhysics ? 3 : 2);
/* 181 */     this.world.markBlockForUpdate(this.x, this.y, this.z);
/* 182 */     TileEntity te = null;
/* 183 */     if (this.nbt != null) {
/*     */       
/* 185 */       te = this.world.getTileEntity(this.x, this.y, this.z);
/* 186 */       if (te != null)
/*     */       {
/* 188 */         te.readFromNBT(this.nbt);
/*     */       }
/*     */     } 
/*     */     
/* 192 */     if (DEBUG)
/*     */     {
/* 194 */       System.out.printf("Restored BlockSnapshot with data [World: %s ][Location: %d,%d,%d ][Meta: %d ][Block: %s ][TileEntity: %s ][force: %s ][applyPhysics: %s]", new Object[] { this.world.getWorldInfo().getWorldName(), Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.z), Integer.valueOf(this.meta), getReplacedBlock(), te, Boolean.valueOf(force), Boolean.valueOf(applyPhysics) });
/*     */     }
/* 196 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean restoreToLocation(World world, int x, int y, int z, boolean force, boolean applyPhysics) {
/* 201 */     if (getCurrentBlock() != getReplacedBlock() || world.getBlockMetadata(x & 0xF, y, z & 0xF) != this.meta)
/*     */     {
/* 203 */       if (force) {
/*     */         
/* 205 */         world.setBlock(x, y, z, getReplacedBlock(), this.meta, applyPhysics ? 3 : 2);
/*     */       }
/*     */       else {
/*     */         
/* 209 */         return false;
/*     */       } 
/*     */     }
/*     */     
/* 213 */     world.setBlockMetadataWithNotify(x, y, z, this.meta, applyPhysics ? 3 : 2);
/* 214 */     world.markBlockForUpdate(x, y, z);
/* 215 */     TileEntity te = null;
/* 216 */     if (this.nbt != null) {
/*     */       
/* 218 */       te = world.getTileEntity(x, y, z);
/* 219 */       if (te != null)
/*     */       {
/* 221 */         te.readFromNBT(this.nbt);
/*     */       }
/*     */     } 
/*     */     
/* 225 */     if (DEBUG)
/*     */     {
/* 227 */       System.out.printf("Restored BlockSnapshot with data [World: %s ][Location: %d,%d,%d ][Meta: %d ][Block: %s ][TileEntity: %s ][force: %s ][applyPhysics: %s]", new Object[] { world.getWorldInfo().getWorldName(), Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(z), Integer.valueOf(this.meta), getReplacedBlock(), te, Boolean.valueOf(force), Boolean.valueOf(applyPhysics) });
/*     */     }
/* 229 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToNBT(NBTTagCompound compound) {
/* 234 */     compound.setString("blockMod", this.blockIdentifier.modId);
/* 235 */     compound.setString("blockName", this.blockIdentifier.name);
/* 236 */     compound.setInteger("posX", this.x);
/* 237 */     compound.setInteger("posY", this.y);
/* 238 */     compound.setInteger("posZ", this.z);
/* 239 */     compound.setInteger("flag", this.flag);
/* 240 */     compound.setInteger("dimension", this.dimId);
/* 241 */     compound.setInteger("metadata", this.meta);
/*     */     
/* 243 */     compound.setBoolean("hasTE", (this.nbt != null));
/*     */     
/* 245 */     if (this.nbt != null)
/*     */     {
/* 247 */       compound.setTag("tileEntity", (NBTBase)this.nbt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 254 */     if (obj == null)
/*     */     {
/* 256 */       return false;
/*     */     }
/* 258 */     if (getClass() != obj.getClass())
/*     */     {
/* 260 */       return false;
/*     */     }
/* 262 */     BlockSnapshot other = (BlockSnapshot)obj;
/* 263 */     if (this.x != other.x)
/*     */     {
/* 265 */       return false;
/*     */     }
/* 267 */     if (this.y != other.y)
/*     */     {
/* 269 */       return false;
/*     */     }
/* 271 */     if (this.z != other.z)
/*     */     {
/* 273 */       return false;
/*     */     }
/* 275 */     if (this.meta != other.meta)
/*     */     {
/* 277 */       return false;
/*     */     }
/* 279 */     if (this.dimId != other.dimId)
/*     */     {
/* 281 */       return false;
/*     */     }
/* 283 */     if (this.nbt != other.nbt && (this.nbt == null || !this.nbt.equals(other.nbt)))
/*     */     {
/* 285 */       return false;
/*     */     }
/* 287 */     if (this.world != other.world && (this.world == null || !this.world.equals(other.world)))
/*     */     {
/* 289 */       return false;
/*     */     }
/* 291 */     if (this.blockIdentifier != other.blockIdentifier && (this.blockIdentifier == null || !this.blockIdentifier.equals(other.blockIdentifier)))
/*     */     {
/* 293 */       return false;
/*     */     }
/* 295 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 301 */     int hash = 7;
/* 302 */     hash = 73 * hash + this.x;
/* 303 */     hash = 73 * hash + this.y;
/* 304 */     hash = 73 * hash + this.z;
/* 305 */     hash = 73 * hash + this.meta;
/* 306 */     hash = 73 * hash + this.dimId;
/* 307 */     hash = 73 * hash + ((this.nbt != null) ? this.nbt.hashCode() : 0);
/* 308 */     hash = 73 * hash + ((this.world != null) ? this.world.hashCode() : 0);
/* 309 */     hash = 73 * hash + ((this.blockIdentifier != null) ? this.blockIdentifier.hashCode() : 0);
/* 310 */     return hash;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\commo\\util\BlockSnapshot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */