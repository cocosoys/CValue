/*     */ package net.minecraftforge.common.util;
/*     */ 
/*     */ import com.google.common.collect.BiMap;
/*     */ import com.google.common.collect.HashBiMap;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RotationHelper
/*     */ {
/*     */   private enum BlockType
/*     */   {
/*  57 */     LOG,
/*  58 */     DISPENSER,
/*  59 */     BED,
/*  60 */     RAIL,
/*  61 */     RAIL_POWERED,
/*  62 */     RAIL_ASCENDING,
/*  63 */     RAIL_CORNER,
/*  64 */     TORCH,
/*  65 */     STAIR,
/*  66 */     CHEST,
/*  67 */     SIGNPOST,
/*  68 */     DOOR,
/*  69 */     LEVER,
/*  70 */     BUTTON,
/*  71 */     REDSTONE_REPEATER,
/*  72 */     TRAPDOOR,
/*  73 */     MUSHROOM_CAP,
/*  74 */     MUSHROOM_CAP_CORNER,
/*  75 */     MUSHROOM_CAP_SIDE,
/*  76 */     VINE,
/*  77 */     SKULL,
/*  78 */     ANVIL;
/*     */   }
/*     */   
/*  81 */   private static final ForgeDirection[] UP_DOWN_AXES = new ForgeDirection[] { ForgeDirection.UP, ForgeDirection.DOWN };
/*  82 */   private static final Map<BlockType, BiMap<Integer, ForgeDirection>> MAPPINGS = new HashMap<BlockType, BiMap<Integer, ForgeDirection>>();
/*     */ 
/*     */   
/*     */   public static ForgeDirection[] getValidVanillaBlockRotations(Block block) {
/*  86 */     return (block instanceof net.minecraft.block.BlockBed || block instanceof net.minecraft.block.BlockPumpkin || block instanceof net.minecraft.block.BlockFenceGate || block instanceof net.minecraft.block.BlockEndPortalFrame || block instanceof net.minecraft.block.BlockTripWireHook || block instanceof net.minecraft.block.BlockCocoa || block instanceof net.minecraft.block.BlockRailPowered || block instanceof net.minecraft.block.BlockRailDetector || block instanceof net.minecraft.block.BlockStairs || block instanceof net.minecraft.block.BlockChest || block instanceof net.minecraft.block.BlockEnderChest || block instanceof net.minecraft.block.BlockFurnace || block instanceof net.minecraft.block.BlockLadder || block == Blocks.wall_sign || block == Blocks.standing_sign || block instanceof net.minecraft.block.BlockDoor || block instanceof net.minecraft.block.BlockRail || block instanceof net.minecraft.block.BlockButton || block instanceof net.minecraft.block.BlockRedstoneRepeater || block instanceof net.minecraft.block.BlockRedstoneComparator || block instanceof net.minecraft.block.BlockTrapDoor || block instanceof net.minecraft.block.BlockHugeMushroom || block instanceof net.minecraft.block.BlockVine || block instanceof net.minecraft.block.BlockSkull || block instanceof net.minecraft.block.BlockAnvil) ? UP_DOWN_AXES : ForgeDirection.VALID_DIRECTIONS;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean rotateVanillaBlock(Block block, World worldObj, int x, int y, int z, ForgeDirection axis) {
/* 115 */     if (worldObj.isRemote)
/*     */     {
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     if (axis == ForgeDirection.UP || axis == ForgeDirection.DOWN) {
/*     */       
/* 122 */       if (block instanceof net.minecraft.block.BlockBed || block instanceof net.minecraft.block.BlockPumpkin || block instanceof net.minecraft.block.BlockFenceGate || block instanceof net.minecraft.block.BlockEndPortalFrame || block instanceof net.minecraft.block.BlockTripWireHook || block instanceof net.minecraft.block.BlockCocoa)
/*     */       {
/* 124 */         return rotateBlock(worldObj, x, y, z, axis, 3, BlockType.BED);
/*     */       }
/* 126 */       if (block instanceof net.minecraft.block.BlockRail)
/*     */       {
/* 128 */         return rotateBlock(worldObj, x, y, z, axis, 15, BlockType.RAIL);
/*     */       }
/* 130 */       if (block instanceof net.minecraft.block.BlockRailPowered || block instanceof net.minecraft.block.BlockRailDetector)
/*     */       {
/* 132 */         return rotateBlock(worldObj, x, y, z, axis, 7, BlockType.RAIL_POWERED);
/*     */       }
/* 134 */       if (block instanceof net.minecraft.block.BlockStairs)
/*     */       {
/* 136 */         return rotateBlock(worldObj, x, y, z, axis, 3, BlockType.STAIR);
/*     */       }
/* 138 */       if (block instanceof net.minecraft.block.BlockChest || block instanceof net.minecraft.block.BlockEnderChest || block instanceof net.minecraft.block.BlockFurnace || block instanceof net.minecraft.block.BlockLadder || block == Blocks.wall_sign)
/*     */       {
/* 140 */         return rotateBlock(worldObj, x, y, z, axis, 7, BlockType.CHEST);
/*     */       }
/* 142 */       if (block == Blocks.standing_sign)
/*     */       {
/* 144 */         return rotateBlock(worldObj, x, y, z, axis, 15, BlockType.SIGNPOST);
/*     */       }
/* 146 */       if (block instanceof net.minecraft.block.BlockDoor)
/*     */       {
/* 148 */         return rotateBlock(worldObj, x, y, z, axis, 3, BlockType.DOOR);
/*     */       }
/* 150 */       if (block instanceof net.minecraft.block.BlockButton)
/*     */       {
/* 152 */         return rotateBlock(worldObj, x, y, z, axis, 7, BlockType.BUTTON);
/*     */       }
/* 154 */       if (block instanceof net.minecraft.block.BlockRedstoneRepeater || block instanceof net.minecraft.block.BlockRedstoneComparator)
/*     */       {
/* 156 */         return rotateBlock(worldObj, x, y, z, axis, 3, BlockType.REDSTONE_REPEATER);
/*     */       }
/* 158 */       if (block instanceof net.minecraft.block.BlockTrapDoor)
/*     */       {
/* 160 */         return rotateBlock(worldObj, x, y, z, axis, 3, BlockType.TRAPDOOR);
/*     */       }
/* 162 */       if (block instanceof net.minecraft.block.BlockHugeMushroom)
/*     */       {
/* 164 */         return rotateBlock(worldObj, x, y, z, axis, 15, BlockType.MUSHROOM_CAP);
/*     */       }
/* 166 */       if (block instanceof net.minecraft.block.BlockVine)
/*     */       {
/* 168 */         return rotateBlock(worldObj, x, y, z, axis, 15, BlockType.VINE);
/*     */       }
/* 170 */       if (block instanceof net.minecraft.block.BlockSkull)
/*     */       {
/* 172 */         return rotateBlock(worldObj, x, y, z, axis, 7, BlockType.SKULL);
/*     */       }
/* 174 */       if (block instanceof net.minecraft.block.BlockAnvil)
/*     */       {
/* 176 */         return rotateBlock(worldObj, x, y, z, axis, 1, BlockType.ANVIL);
/*     */       }
/*     */     } 
/*     */     
/* 180 */     if (block instanceof net.minecraft.block.BlockLog)
/*     */     {
/* 182 */       return rotateBlock(worldObj, x, y, z, axis, 12, BlockType.LOG);
/*     */     }
/* 184 */     if (block instanceof net.minecraft.block.BlockDispenser || block instanceof net.minecraft.block.BlockPistonBase || block instanceof net.minecraft.block.BlockPistonExtension || block instanceof net.minecraft.block.BlockHopper)
/*     */     {
/* 186 */       return rotateBlock(worldObj, x, y, z, axis, 7, BlockType.DISPENSER);
/*     */     }
/* 188 */     if (block instanceof net.minecraft.block.BlockTorch)
/*     */     {
/* 190 */       return rotateBlock(worldObj, x, y, z, axis, 15, BlockType.TORCH);
/*     */     }
/* 192 */     if (block instanceof net.minecraft.block.BlockLever)
/*     */     {
/* 194 */       return rotateBlock(worldObj, x, y, z, axis, 7, BlockType.LEVER);
/*     */     }
/*     */     
/* 197 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean rotateBlock(World worldObj, int x, int y, int z, ForgeDirection axis, int mask, BlockType blockType) {
/* 202 */     int rotMeta = worldObj.getBlockMetadata(x, y, z);
/* 203 */     if (blockType == BlockType.DOOR && (rotMeta & 0x8) == 8)
/*     */     {
/* 205 */       return false;
/*     */     }
/* 207 */     int masked = rotMeta & (mask ^ 0xFFFFFFFF);
/* 208 */     int meta = rotateMetadata(axis, blockType, rotMeta & mask);
/* 209 */     if (meta == -1)
/*     */     {
/* 211 */       return false;
/*     */     }
/* 213 */     worldObj.setBlockMetadataWithNotify(x, y, z, meta & mask | masked, 3);
/* 214 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int rotateMetadata(ForgeDirection axis, BlockType blockType, int meta) {
/* 219 */     if (blockType == BlockType.RAIL || blockType == BlockType.RAIL_POWERED) {
/*     */       
/* 221 */       if (meta == 0 || meta == 1)
/*     */       {
/* 223 */         return (meta ^ 0xFFFFFFFF) & 0x1;
/*     */       }
/* 225 */       if (meta >= 2 && meta <= 5)
/*     */       {
/* 227 */         blockType = BlockType.RAIL_ASCENDING;
/*     */       }
/* 229 */       if (meta >= 6 && meta <= 9 && blockType == BlockType.RAIL)
/*     */       {
/* 231 */         blockType = BlockType.RAIL_CORNER;
/*     */       }
/*     */     } 
/* 234 */     if (blockType == BlockType.SIGNPOST)
/*     */     {
/* 236 */       return (axis == ForgeDirection.UP) ? ((meta + 4) % 16) : ((meta + 12) % 16);
/*     */     }
/* 238 */     if (blockType == BlockType.LEVER && (axis == ForgeDirection.UP || axis == ForgeDirection.DOWN))
/*     */     {
/* 240 */       switch (meta) {
/*     */         
/*     */         case 5:
/* 243 */           return 6;
/*     */         case 6:
/* 245 */           return 5;
/*     */         case 7:
/* 247 */           return 0;
/*     */         case 0:
/* 249 */           return 7;
/*     */       } 
/*     */     }
/* 252 */     if (blockType == BlockType.MUSHROOM_CAP)
/*     */     {
/* 254 */       if (meta % 2 == 0) {
/*     */         
/* 256 */         blockType = BlockType.MUSHROOM_CAP_SIDE;
/*     */       }
/*     */       else {
/*     */         
/* 260 */         blockType = BlockType.MUSHROOM_CAP_CORNER;
/*     */       } 
/*     */     }
/* 263 */     if (blockType == BlockType.VINE)
/*     */     {
/* 265 */       return meta << 1 | (meta & 0x8) >> 3;
/*     */     }
/*     */     
/* 268 */     ForgeDirection orientation = metadataToDirection(blockType, meta);
/* 269 */     ForgeDirection rotated = orientation.getRotation(axis);
/* 270 */     return directionToMetadata(blockType, rotated);
/*     */   }
/*     */ 
/*     */   
/*     */   private static ForgeDirection metadataToDirection(BlockType blockType, int meta) {
/* 275 */     if (blockType == BlockType.LEVER)
/*     */     {
/* 277 */       if (meta == 6) {
/*     */         
/* 279 */         meta = 5;
/*     */       }
/* 281 */       else if (meta == 0) {
/*     */         
/* 283 */         meta = 7;
/*     */       } 
/*     */     }
/*     */     
/* 287 */     if (MAPPINGS.containsKey(blockType)) {
/*     */       
/* 289 */       BiMap<Integer, ForgeDirection> biMap = MAPPINGS.get(blockType);
/* 290 */       if (biMap.containsKey(Integer.valueOf(meta)))
/*     */       {
/* 292 */         return (ForgeDirection)biMap.get(Integer.valueOf(meta));
/*     */       }
/*     */     } 
/*     */     
/* 296 */     if (blockType == BlockType.TORCH)
/*     */     {
/* 298 */       return ForgeDirection.getOrientation(6 - meta);
/*     */     }
/* 300 */     if (blockType == BlockType.STAIR)
/*     */     {
/* 302 */       return ForgeDirection.getOrientation(5 - meta);
/*     */     }
/* 304 */     if (blockType == BlockType.CHEST || blockType == BlockType.DISPENSER || blockType == BlockType.SKULL)
/*     */     {
/* 306 */       return ForgeDirection.getOrientation(meta);
/*     */     }
/* 308 */     if (blockType == BlockType.BUTTON)
/*     */     {
/* 310 */       return ForgeDirection.getOrientation(6 - meta);
/*     */     }
/* 312 */     if (blockType == BlockType.TRAPDOOR)
/*     */     {
/* 314 */       return ForgeDirection.getOrientation(meta + 2).getOpposite();
/*     */     }
/*     */     
/* 317 */     return ForgeDirection.UNKNOWN;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int directionToMetadata(BlockType blockType, ForgeDirection direction) {
/* 322 */     if ((blockType == BlockType.LOG || blockType == BlockType.ANVIL) && direction.offsetX + direction.offsetY + direction.offsetZ < 0)
/*     */     {
/* 324 */       direction = direction.getOpposite();
/*     */     }
/*     */     
/* 327 */     if (MAPPINGS.containsKey(blockType)) {
/*     */       
/* 329 */       BiMap<ForgeDirection, Integer> biMap = ((BiMap)MAPPINGS.get(blockType)).inverse();
/* 330 */       if (biMap.containsKey(direction))
/*     */       {
/* 332 */         return ((Integer)biMap.get(direction)).intValue();
/*     */       }
/*     */     } 
/*     */     
/* 336 */     if (blockType == BlockType.TORCH)
/*     */     {
/* 338 */       if (direction.ordinal() >= 1)
/*     */       {
/* 340 */         return 6 - direction.ordinal();
/*     */       }
/*     */     }
/* 343 */     if (blockType == BlockType.STAIR)
/*     */     {
/* 345 */       return 5 - direction.ordinal();
/*     */     }
/* 347 */     if (blockType == BlockType.CHEST || blockType == BlockType.DISPENSER || blockType == BlockType.SKULL)
/*     */     {
/* 349 */       return direction.ordinal();
/*     */     }
/* 351 */     if (blockType == BlockType.BUTTON)
/*     */     {
/* 353 */       if (direction.ordinal() >= 2)
/*     */       {
/* 355 */         return 6 - direction.ordinal();
/*     */       }
/*     */     }
/* 358 */     if (blockType == BlockType.TRAPDOOR)
/*     */     {
/* 360 */       return direction.getOpposite().ordinal() - 2;
/*     */     }
/*     */     
/* 363 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 370 */     HashBiMap hashBiMap = HashBiMap.create(3);
/* 371 */     hashBiMap.put(Integer.valueOf(0), ForgeDirection.UP);
/* 372 */     hashBiMap.put(Integer.valueOf(4), ForgeDirection.EAST);
/* 373 */     hashBiMap.put(Integer.valueOf(8), ForgeDirection.SOUTH);
/* 374 */     MAPPINGS.put(BlockType.LOG, hashBiMap);
/*     */     
/* 376 */     hashBiMap = HashBiMap.create(4);
/* 377 */     hashBiMap.put(Integer.valueOf(0), ForgeDirection.SOUTH);
/* 378 */     hashBiMap.put(Integer.valueOf(1), ForgeDirection.WEST);
/* 379 */     hashBiMap.put(Integer.valueOf(2), ForgeDirection.NORTH);
/* 380 */     hashBiMap.put(Integer.valueOf(3), ForgeDirection.EAST);
/* 381 */     MAPPINGS.put(BlockType.BED, hashBiMap);
/*     */     
/* 383 */     hashBiMap = HashBiMap.create(4);
/* 384 */     hashBiMap.put(Integer.valueOf(2), ForgeDirection.EAST);
/* 385 */     hashBiMap.put(Integer.valueOf(3), ForgeDirection.WEST);
/* 386 */     hashBiMap.put(Integer.valueOf(4), ForgeDirection.NORTH);
/* 387 */     hashBiMap.put(Integer.valueOf(5), ForgeDirection.SOUTH);
/* 388 */     MAPPINGS.put(BlockType.RAIL_ASCENDING, hashBiMap);
/*     */     
/* 390 */     hashBiMap = HashBiMap.create(4);
/* 391 */     hashBiMap.put(Integer.valueOf(6), ForgeDirection.WEST);
/* 392 */     hashBiMap.put(Integer.valueOf(7), ForgeDirection.NORTH);
/* 393 */     hashBiMap.put(Integer.valueOf(8), ForgeDirection.EAST);
/* 394 */     hashBiMap.put(Integer.valueOf(9), ForgeDirection.SOUTH);
/* 395 */     MAPPINGS.put(BlockType.RAIL_CORNER, hashBiMap);
/*     */     
/* 397 */     hashBiMap = HashBiMap.create(6);
/* 398 */     hashBiMap.put(Integer.valueOf(1), ForgeDirection.EAST);
/* 399 */     hashBiMap.put(Integer.valueOf(2), ForgeDirection.WEST);
/* 400 */     hashBiMap.put(Integer.valueOf(3), ForgeDirection.SOUTH);
/* 401 */     hashBiMap.put(Integer.valueOf(4), ForgeDirection.NORTH);
/* 402 */     hashBiMap.put(Integer.valueOf(5), ForgeDirection.UP);
/* 403 */     hashBiMap.put(Integer.valueOf(7), ForgeDirection.DOWN);
/* 404 */     MAPPINGS.put(BlockType.LEVER, hashBiMap);
/*     */     
/* 406 */     hashBiMap = HashBiMap.create(4);
/* 407 */     hashBiMap.put(Integer.valueOf(0), ForgeDirection.WEST);
/* 408 */     hashBiMap.put(Integer.valueOf(1), ForgeDirection.NORTH);
/* 409 */     hashBiMap.put(Integer.valueOf(2), ForgeDirection.EAST);
/* 410 */     hashBiMap.put(Integer.valueOf(3), ForgeDirection.SOUTH);
/* 411 */     MAPPINGS.put(BlockType.DOOR, hashBiMap);
/*     */     
/* 413 */     hashBiMap = HashBiMap.create(4);
/* 414 */     hashBiMap.put(Integer.valueOf(0), ForgeDirection.NORTH);
/* 415 */     hashBiMap.put(Integer.valueOf(1), ForgeDirection.EAST);
/* 416 */     hashBiMap.put(Integer.valueOf(2), ForgeDirection.SOUTH);
/* 417 */     hashBiMap.put(Integer.valueOf(3), ForgeDirection.WEST);
/* 418 */     MAPPINGS.put(BlockType.REDSTONE_REPEATER, hashBiMap);
/*     */     
/* 420 */     hashBiMap = HashBiMap.create(4);
/* 421 */     hashBiMap.put(Integer.valueOf(1), ForgeDirection.EAST);
/* 422 */     hashBiMap.put(Integer.valueOf(3), ForgeDirection.SOUTH);
/* 423 */     hashBiMap.put(Integer.valueOf(7), ForgeDirection.NORTH);
/* 424 */     hashBiMap.put(Integer.valueOf(9), ForgeDirection.WEST);
/* 425 */     MAPPINGS.put(BlockType.MUSHROOM_CAP_CORNER, hashBiMap);
/*     */     
/* 427 */     hashBiMap = HashBiMap.create(4);
/* 428 */     hashBiMap.put(Integer.valueOf(2), ForgeDirection.NORTH);
/* 429 */     hashBiMap.put(Integer.valueOf(4), ForgeDirection.WEST);
/* 430 */     hashBiMap.put(Integer.valueOf(6), ForgeDirection.EAST);
/* 431 */     hashBiMap.put(Integer.valueOf(8), ForgeDirection.SOUTH);
/* 432 */     MAPPINGS.put(BlockType.MUSHROOM_CAP_SIDE, hashBiMap);
/*     */     
/* 434 */     hashBiMap = HashBiMap.create(2);
/* 435 */     hashBiMap.put(Integer.valueOf(0), ForgeDirection.SOUTH);
/* 436 */     hashBiMap.put(Integer.valueOf(1), ForgeDirection.EAST);
/* 437 */     MAPPINGS.put(BlockType.ANVIL, hashBiMap);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\commo\\util\RotationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */