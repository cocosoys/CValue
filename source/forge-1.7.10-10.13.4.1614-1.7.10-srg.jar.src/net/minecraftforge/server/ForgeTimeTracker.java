/*     */ package net.minecraftforge.server;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.MapMaker;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ForgeTimeTracker
/*     */ {
/*     */   public static boolean tileEntityTracking;
/*     */   public static int tileEntityTrackingDuration;
/*     */   public static long tileEntityTrackingTime;
/*     */   private Map<TileEntity, int[]> tileEntityTimings;
/*     */   private Map<Entity, int[]> entityTimings;
/*  23 */   private static final ForgeTimeTracker INSTANCE = new ForgeTimeTracker();
/*     */   
/*     */   private WeakReference<TileEntity> tile;
/*     */   
/*     */   private WeakReference<Entity> entity;
/*     */   
/*     */   private long timing;
/*     */   
/*     */   private ForgeTimeTracker() {
/*  32 */     MapMaker mm = new MapMaker();
/*  33 */     mm.weakKeys();
/*  34 */     this.tileEntityTimings = mm.makeMap();
/*  35 */     this.entityTimings = mm.makeMap();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void trackTileStart(TileEntity tileEntity, long nanoTime) {
/*  41 */     if (tileEntityTrackingTime == 0L) {
/*     */       
/*  43 */       tileEntityTrackingTime = nanoTime;
/*     */     }
/*  45 */     else if (tileEntityTrackingTime + tileEntityTrackingDuration < nanoTime) {
/*     */       
/*  47 */       tileEntityTracking = false;
/*  48 */       tileEntityTrackingTime = 0L;
/*     */       
/*     */       return;
/*     */     } 
/*  52 */     this.tile = new WeakReference<TileEntity>(tileEntity);
/*  53 */     this.timing = nanoTime;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void trackTileEnd(TileEntity tileEntity, long nanoTime) {
/*  59 */     if (this.tile == null || this.tile.get() != tileEntity) {
/*     */       
/*  61 */       this.tile = null;
/*     */       
/*     */       return;
/*     */     } 
/*  65 */     int[] timings = this.tileEntityTimings.get(tileEntity);
/*  66 */     if (timings == null) {
/*     */       
/*  68 */       timings = new int[101];
/*  69 */       this.tileEntityTimings.put(tileEntity, timings);
/*     */     } 
/*  71 */     int idx = timings[100] = (timings[100] + 1) % 100;
/*  72 */     timings[idx] = (int)(nanoTime - this.timing);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ImmutableMap<TileEntity, int[]> getTileTimings() {
/*  77 */     return INSTANCE.buildImmutableTileEntityTimingMap();
/*     */   }
/*     */ 
/*     */   
/*     */   private ImmutableMap<TileEntity, int[]> buildImmutableTileEntityTimingMap() {
/*  82 */     ImmutableMap.Builder<TileEntity, int[]> builder = ImmutableMap.builder();
/*  83 */     for (Map.Entry<TileEntity, int[]> entry : this.tileEntityTimings.entrySet())
/*     */     {
/*  85 */       builder.put(entry.getKey(), Arrays.copyOfRange(entry.getValue(), 0, 100));
/*     */     }
/*  87 */     return builder.build();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void trackStart(TileEntity tileEntity) {
/*  93 */     if (!tileEntityTracking)
/*  94 */       return;  INSTANCE.trackTileStart(tileEntity, System.nanoTime());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void trackEnd(TileEntity tileEntity) {
/*  99 */     if (!tileEntityTracking)
/* 100 */       return;  INSTANCE.trackTileEnd(tileEntity, System.nanoTime());
/*     */   }
/*     */   
/*     */   public static void trackStart(Entity par1Entity) {}
/*     */   
/*     */   public static void trackEnd(Entity par1Entity) {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\server\ForgeTimeTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */