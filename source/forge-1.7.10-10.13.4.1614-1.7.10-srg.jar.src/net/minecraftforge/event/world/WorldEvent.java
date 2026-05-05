/*     */ package net.minecraftforge.event.world;
/*     */ 
/*     */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
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
/*     */ public class WorldEvent
/*     */   extends Event
/*     */ {
/*     */   public final World world;
/*     */   
/*     */   public WorldEvent(World world) {
/*  29 */     this.world = world;
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
/*     */   public static class Load
/*     */     extends WorldEvent
/*     */   {
/*     */     public Load(World world) {
/*  48 */       super(world);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Unload
/*     */     extends WorldEvent
/*     */   {
/*     */     public Unload(World world) {
/*  68 */       super(world);
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
/*     */ 
/*     */   
/*     */   public static class Save
/*     */     extends WorldEvent
/*     */   {
/*     */     public Save(World world) {
/*  85 */       super(world);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Cancelable
/*     */   public static class PotentialSpawns
/*     */     extends WorldEvent
/*     */   {
/*     */     public final EnumCreatureType type;
/*     */     
/*     */     public final int x;
/*     */     
/*     */     public final int y;
/*     */     public final int z;
/*     */     public final List<BiomeGenBase.SpawnListEntry> list;
/*     */     
/*     */     public PotentialSpawns(World world, EnumCreatureType type, int x, int y, int z, List<BiomeGenBase.SpawnListEntry> oldList) {
/* 103 */       super(world);
/* 104 */       this.x = x;
/* 105 */       this.y = y;
/* 106 */       this.z = z;
/* 107 */       this.type = type;
/* 108 */       if (oldList != null) {
/*     */         
/* 110 */         this.list = oldList;
/*     */       }
/*     */       else {
/*     */         
/* 114 */         this.list = new ArrayList<BiomeGenBase.SpawnListEntry>();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Cancelable
/*     */   public static class CreateSpawnPosition
/*     */     extends WorldEvent
/*     */   {
/*     */     public final WorldSettings settings;
/*     */ 
/*     */     
/*     */     public CreateSpawnPosition(World world, WorldSettings ws) {
/* 129 */       super(world);
/* 130 */       this.settings = ws;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\world\WorldEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */