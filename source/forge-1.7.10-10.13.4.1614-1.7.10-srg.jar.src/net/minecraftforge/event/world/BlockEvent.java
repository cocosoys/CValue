/*     */ package net.minecraftforge.event.world;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ import net.minecraftforge.common.util.BlockSnapshot;
/*     */ 
/*     */ public class BlockEvent
/*     */   extends Event {
/*  20 */   private static final boolean DEBUG = Boolean.parseBoolean(System.getProperty("forge.debugBlockEvent", "false"));
/*     */   
/*     */   public final int x;
/*     */   public final int y;
/*     */   public final int z;
/*     */   public final World world;
/*     */   public final Block block;
/*     */   public final int blockMetadata;
/*     */   
/*     */   public BlockEvent(int x, int y, int z, World world, Block block, int blockMetadata) {
/*  30 */     this.x = x;
/*  31 */     this.y = y;
/*  32 */     this.z = z;
/*  33 */     this.world = world;
/*  34 */     this.block = block;
/*  35 */     this.blockMetadata = blockMetadata;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class HarvestDropsEvent
/*     */     extends BlockEvent
/*     */   {
/*     */     public final int fortuneLevel;
/*     */ 
/*     */     
/*     */     public final ArrayList<ItemStack> drops;
/*     */ 
/*     */     
/*     */     public final boolean isSilkTouching;
/*     */ 
/*     */     
/*     */     public float dropChance;
/*     */     
/*     */     public final EntityPlayer harvester;
/*     */ 
/*     */     
/*     */     public HarvestDropsEvent(int x, int y, int z, World world, Block block, int blockMetadata, int fortuneLevel, float dropChance, ArrayList<ItemStack> drops, EntityPlayer harvester, boolean isSilkTouching) {
/*  58 */       super(x, y, z, world, block, blockMetadata);
/*  59 */       this.fortuneLevel = fortuneLevel;
/*  60 */       this.dropChance = dropChance;
/*  61 */       this.drops = drops;
/*  62 */       this.isSilkTouching = isSilkTouching;
/*  63 */       this.harvester = harvester;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Cancelable
/*     */   public static class BreakEvent
/*     */     extends BlockEvent
/*     */   {
/*     */     private final EntityPlayer player;
/*     */ 
/*     */     
/*     */     private int exp;
/*     */ 
/*     */     
/*     */     public BreakEvent(int x, int y, int z, World world, Block block, int blockMetadata, EntityPlayer player) {
/*  80 */       super(x, y, z, world, block, blockMetadata);
/*  81 */       this.player = player;
/*     */       
/*  83 */       if (block == null || !ForgeHooks.canHarvestBlock(block, player, blockMetadata) || (block
/*  84 */         .canSilkHarvest(world, player, x, y, z, blockMetadata) && EnchantmentHelper.getSilkTouchModifier((EntityLivingBase)player))) {
/*     */         
/*  86 */         this.exp = 0;
/*     */       }
/*     */       else {
/*     */         
/*  90 */         int meta = block.getDamageValue(world, x, y, z);
/*  91 */         int bonusLevel = EnchantmentHelper.getFortuneModifier((EntityLivingBase)player);
/*  92 */         this.exp = block.getExpDrop((IBlockAccess)world, meta, bonusLevel);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public EntityPlayer getPlayer() {
/*  98 */       return this.player;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getExpToDrop() {
/* 108 */       return isCanceled() ? 0 : this.exp;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setExpToDrop(int exp) {
/* 118 */       this.exp = exp;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Cancelable
/*     */   public static class PlaceEvent
/*     */     extends BlockEvent
/*     */   {
/*     */     public final EntityPlayer player;
/*     */     
/*     */     public final ItemStack itemInHand;
/*     */     
/*     */     public final BlockSnapshot blockSnapshot;
/*     */     
/*     */     public final Block placedBlock;
/*     */     public final Block placedAgainst;
/*     */     
/*     */     public PlaceEvent(BlockSnapshot blockSnapshot, Block placedAgainst, EntityPlayer player) {
/* 137 */       super(blockSnapshot.x, blockSnapshot.y, blockSnapshot.z, blockSnapshot.world, blockSnapshot.getCurrentBlock(), blockSnapshot.meta);
/* 138 */       this.player = player;
/* 139 */       this.itemInHand = player.getCurrentEquippedItem();
/* 140 */       this.blockSnapshot = blockSnapshot;
/* 141 */       this.placedBlock = blockSnapshot.getCurrentBlock();
/* 142 */       this.placedAgainst = placedAgainst;
/* 143 */       if (BlockEvent.DEBUG)
/*     */       {
/* 145 */         System.out.printf("Created PlaceEvent - [PlacedBlock: %s ][PlacedAgainst: %s ][ItemStack: %s ][Player: %s ]\n", new Object[] { this.placedBlock, placedAgainst, player.getCurrentEquippedItem(), player });
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Cancelable
/*     */   public static class MultiPlaceEvent
/*     */     extends PlaceEvent
/*     */   {
/*     */     private final List<BlockSnapshot> blockSnapshots;
/*     */ 
/*     */ 
/*     */     
/*     */     public MultiPlaceEvent(List<BlockSnapshot> blockSnapshots, Block placedAgainst, EntityPlayer player) {
/* 162 */       super(blockSnapshots.get(0), placedAgainst, player);
/* 163 */       this.blockSnapshots = (List<BlockSnapshot>)ImmutableList.copyOf(blockSnapshots);
/* 164 */       if (BlockEvent.DEBUG)
/*     */       {
/* 166 */         System.out.printf("Created MultiPlaceEvent - [PlacedAgainst: %s ][ItemInHand: %s ][Player: %s ]\n", new Object[] { placedAgainst, this.itemInHand, player });
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<BlockSnapshot> getReplacedBlockSnapshots() {
/* 177 */       return this.blockSnapshots;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\world\BlockEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */