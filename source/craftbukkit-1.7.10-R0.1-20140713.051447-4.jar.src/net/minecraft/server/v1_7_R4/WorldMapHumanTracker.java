/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.map.RenderData;
/*     */ import org.bukkit.map.MapCursor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldMapHumanTracker
/*     */ {
/*     */   public final EntityHuman trackee;
/*     */   public int[] b;
/*     */   public int[] c;
/*     */   private int f;
/*     */   
/*     */   public WorldMapHumanTracker(WorldMap worldmap, EntityHuman entityhuman) {
/*  18 */     this.worldMap = worldmap;
/*  19 */     this.b = new int[128];
/*  20 */     this.c = new int[128];
/*  21 */     this.trackee = entityhuman;
/*     */     
/*  23 */     for (int i = 0; i < this.b.length; i++) {
/*  24 */       this.b[i] = 0;
/*  25 */       this.c[i] = 127;
/*     */     } 
/*     */   }
/*     */   private int g; private byte[] h; public int d; private boolean i;
/*     */   final WorldMap worldMap;
/*     */   
/*     */   public byte[] a(ItemStack itemstack) {
/*  32 */     if (!this.i) {
/*  33 */       byte[] abyte = { 2, this.worldMap.scale };
/*  34 */       this.i = true;
/*  35 */       return abyte;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  40 */     RenderData render = this.worldMap.mapView.render((CraftPlayer)this.trackee.getBukkitEntity());
/*     */     
/*  42 */     if (--this.g < 0) {
/*  43 */       this.g = 4;
/*  44 */       byte[] abyte = new byte[render.cursors.size() * 3 + 1];
/*  45 */       abyte[0] = 1;
/*  46 */       int i = 0;
/*     */ 
/*     */       
/*  49 */       for (i = 0; i < render.cursors.size(); i++) {
/*  50 */         MapCursor cursor = render.cursors.get(i);
/*  51 */         if (cursor.isVisible()) {
/*     */           
/*  53 */           abyte[i * 3 + 1] = (byte)(cursor.getRawType() << 4 | cursor.getDirection() & 0xF);
/*  54 */           abyte[i * 3 + 2] = cursor.getX();
/*  55 */           abyte[i * 3 + 3] = cursor.getY();
/*     */         } 
/*     */       } 
/*     */       
/*  59 */       boolean flag = !itemstack.A();
/*     */       
/*  61 */       if (this.h != null && this.h.length == abyte.length) {
/*  62 */         for (int j = 0; j < abyte.length; j++) {
/*  63 */           if (abyte[j] != this.h[j]) {
/*  64 */             flag = false;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } else {
/*  69 */         flag = false;
/*     */       } 
/*     */       
/*  72 */       if (!flag) {
/*  73 */         this.h = abyte;
/*  74 */         return abyte;
/*     */       } 
/*     */     } 
/*     */     
/*  78 */     for (int k = 0; k < 1; k++) {
/*  79 */       int i = this.f++ * 11 % 128;
/*  80 */       if (this.b[i] >= 0) {
/*  81 */         int l = this.c[i] - this.b[i] + 1;
/*     */         
/*  83 */         int j = this.b[i];
/*  84 */         byte[] abyte1 = new byte[l + 3];
/*     */         
/*  86 */         abyte1[0] = 0;
/*  87 */         abyte1[1] = (byte)i;
/*  88 */         abyte1[2] = (byte)j;
/*     */         
/*  90 */         for (int i1 = 0; i1 < abyte1.length - 3; i1++) {
/*  91 */           abyte1[i1 + 3] = render.buffer[(i1 + j) * 128 + i];
/*     */         }
/*     */         
/*  94 */         this.c[i] = -1;
/*  95 */         this.b[i] = -1;
/*  96 */         return abyte1;
/*     */       } 
/*     */     } 
/*     */     
/* 100 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\WorldMapHumanTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */