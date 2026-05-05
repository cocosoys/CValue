/*     */ package net.minecraftforge.event.entity.player;
/*     */ 
/*     */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*     */ import java.io.File;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraftforge.event.entity.living.LivingEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerEvent
/*     */   extends LivingEvent
/*     */ {
/*     */   public final EntityPlayer entityPlayer;
/*     */   
/*     */   public PlayerEvent(EntityPlayer player) {
/*  23 */     super((EntityLivingBase)player);
/*  24 */     this.entityPlayer = player;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class HarvestCheck
/*     */     extends PlayerEvent
/*     */   {
/*     */     public final Block block;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean success;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public HarvestCheck(EntityPlayer player, Block block, boolean success) {
/*  50 */       super(player);
/*  51 */       this.block = block;
/*  52 */       this.success = success;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Cancelable
/*     */   public static class BreakSpeed
/*     */     extends PlayerEvent
/*     */   {
/*     */     public final Block block;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int metadata;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final float originalSpeed;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     public float newSpeed = 0.0F;
/*     */     
/*     */     public final int x;
/*     */     public final int y;
/*     */     public final int z;
/*     */     
/*     */     @Deprecated
/*     */     public BreakSpeed(EntityPlayer player, Block block, int metadata, float original) {
/*  92 */       this(player, block, metadata, original, 0, -1, 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public BreakSpeed(EntityPlayer player, Block block, int metadata, float original, int x, int y, int z) {
/*  97 */       super(player);
/*  98 */       this.block = block;
/*  99 */       this.metadata = metadata;
/* 100 */       this.originalSpeed = original;
/* 101 */       this.newSpeed = original;
/* 102 */       this.x = x;
/* 103 */       this.y = y;
/* 104 */       this.z = z;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class NameFormat
/*     */     extends PlayerEvent
/*     */   {
/*     */     public final String username;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String displayname;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public NameFormat(EntityPlayer player, String username) {
/* 130 */       super(player);
/* 131 */       this.username = username;
/* 132 */       this.displayname = username;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Clone
/*     */     extends PlayerEvent
/*     */   {
/*     */     public final EntityPlayer original;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean wasDeath;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Clone(EntityPlayer _new, EntityPlayer oldPlayer, boolean wasDeath) {
/* 154 */       super(_new);
/* 155 */       this.original = oldPlayer;
/* 156 */       this.wasDeath = wasDeath;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class StartTracking
/*     */     extends PlayerEvent
/*     */   {
/*     */     public final Entity target;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StartTracking(EntityPlayer player, Entity target) {
/* 173 */       super(player);
/* 174 */       this.target = target;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class StopTracking
/*     */     extends PlayerEvent
/*     */   {
/*     */     public final Entity target;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StopTracking(EntityPlayer player, Entity target) {
/* 192 */       super(player);
/* 193 */       this.target = target;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class LoadFromFile
/*     */     extends PlayerEvent
/*     */   {
/*     */     public final File playerDirectory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String playerUUID;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public LoadFromFile(EntityPlayer player, File originDirectory, String playerUUID) {
/* 218 */       super(player);
/* 219 */       this.playerDirectory = originDirectory;
/* 220 */       this.playerUUID = playerUUID;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public File getPlayerFile(String suffix) {
/* 230 */       if ("dat".equals(suffix)) throw new IllegalArgumentException("The suffix 'dat' is reserved"); 
/* 231 */       return new File(this.playerDirectory, this.playerUUID + "." + suffix);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class SaveToFile
/*     */     extends PlayerEvent
/*     */   {
/*     */     public final File playerDirectory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String playerUUID;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SaveToFile(EntityPlayer player, File originDirectory, String playerUUID) {
/* 261 */       super(player);
/* 262 */       this.playerDirectory = originDirectory;
/* 263 */       this.playerUUID = playerUUID;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public File getPlayerFile(String suffix) {
/* 273 */       if ("dat".equals(suffix)) throw new IllegalArgumentException("The suffix 'dat' is reserved"); 
/* 274 */       return new File(this.playerDirectory, this.playerUUID + "." + suffix);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\PlayerEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */