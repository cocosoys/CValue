/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import net.minecraft.util.org.apache.commons.lang3.ObjectUtils;
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
/*     */ public class DataWatcher
/*     */ {
/*     */   private final Entity a;
/*     */   private boolean b = true;
/*  28 */   private static final HashMap c = new HashMap<Object, Object>();
/*     */   
/*     */   static {
/*  31 */     c.put(Byte.class, Integer.valueOf(0));
/*  32 */     c.put(Short.class, Integer.valueOf(1));
/*  33 */     c.put(Integer.class, Integer.valueOf(2));
/*  34 */     c.put(Float.class, Integer.valueOf(3));
/*  35 */     c.put(String.class, Integer.valueOf(4));
/*  36 */     c.put(ItemStack.class, Integer.valueOf(5));
/*  37 */     c.put(ChunkCoordinates.class, Integer.valueOf(6));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   private final Map d = new HashMap<Object, Object>();
/*     */   private boolean e;
/*  49 */   private ReadWriteLock f = new ReentrantReadWriteLock();
/*     */   
/*     */   public DataWatcher(Entity paramEntity) {
/*  52 */     this.a = paramEntity;
/*     */   }
/*     */   
/*     */   public void a(int paramInt, Object paramObject) {
/*  56 */     Integer integer = (Integer)c.get(paramObject.getClass());
/*  57 */     if (integer == null) {
/*  58 */       throw new IllegalArgumentException("Unknown data type: " + paramObject.getClass());
/*     */     }
/*  60 */     if (paramInt > 31) {
/*  61 */       throw new IllegalArgumentException("Data value id is too big with " + paramInt + "! (Max is " + '\037' + ")");
/*     */     }
/*  63 */     if (this.d.containsKey(Integer.valueOf(paramInt))) {
/*  64 */       throw new IllegalArgumentException("Duplicate id value for " + paramInt + "!");
/*     */     }
/*     */     
/*  67 */     WatchableObject watchableObject = new WatchableObject(integer.intValue(), paramInt, paramObject);
/*  68 */     this.f.writeLock().lock();
/*  69 */     this.d.put(Integer.valueOf(paramInt), watchableObject);
/*  70 */     this.f.writeLock().unlock();
/*  71 */     this.b = false;
/*     */   }
/*     */   
/*     */   public void add(int paramInt1, int paramInt2) {
/*  75 */     WatchableObject watchableObject = new WatchableObject(paramInt2, paramInt1, null);
/*  76 */     this.f.writeLock().lock();
/*  77 */     this.d.put(Integer.valueOf(paramInt1), watchableObject);
/*  78 */     this.f.writeLock().unlock();
/*  79 */     this.b = false;
/*     */   }
/*     */   
/*     */   public byte getByte(int paramInt) {
/*  83 */     return ((Byte)i(paramInt).b()).byteValue();
/*     */   }
/*     */   
/*     */   public short getShort(int paramInt) {
/*  87 */     return ((Short)i(paramInt).b()).shortValue();
/*     */   }
/*     */   
/*     */   public int getInt(int paramInt) {
/*  91 */     return ((Integer)i(paramInt).b()).intValue();
/*     */   }
/*     */   
/*     */   public float getFloat(int paramInt) {
/*  95 */     return ((Float)i(paramInt).b()).floatValue();
/*     */   }
/*     */   
/*     */   public String getString(int paramInt) {
/*  99 */     return (String)i(paramInt).b();
/*     */   }
/*     */   
/*     */   public ItemStack getItemStack(int paramInt) {
/* 103 */     return (ItemStack)i(paramInt).b();
/*     */   }
/*     */   
/*     */   private WatchableObject i(int paramInt) {
/*     */     WatchableObject watchableObject;
/* 108 */     this.f.readLock().lock();
/*     */     
/*     */     try {
/* 111 */       watchableObject = (WatchableObject)this.d.get(Integer.valueOf(paramInt));
/* 112 */     } catch (Throwable throwable) {
/* 113 */       CrashReport crashReport = CrashReport.a(throwable, "Getting synched entity data");
/* 114 */       CrashReportSystemDetails crashReportSystemDetails = crashReport.a("Synched entity data");
/*     */       
/* 116 */       crashReportSystemDetails.a("Data ID", Integer.valueOf(paramInt));
/* 117 */       throw new ReportedException(crashReport);
/*     */     } 
/*     */     
/* 120 */     this.f.readLock().unlock();
/* 121 */     return watchableObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void watch(int paramInt, Object paramObject) {
/* 130 */     WatchableObject watchableObject = i(paramInt);
/*     */ 
/*     */     
/* 133 */     if (ObjectUtils.notEqual(paramObject, watchableObject.b())) {
/* 134 */       watchableObject.a(paramObject);
/* 135 */       this.a.i(paramInt);
/* 136 */       watchableObject.a(true);
/* 137 */       this.e = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void update(int paramInt) {
/* 142 */     WatchableObject.a(i(paramInt), true);
/* 143 */     this.e = true;
/*     */   }
/*     */   
/*     */   public boolean a() {
/* 147 */     return this.e;
/*     */   }
/*     */   
/*     */   public static void a(List paramList, PacketDataSerializer paramPacketDataSerializer) {
/* 151 */     if (paramList != null) {
/* 152 */       for (WatchableObject watchableObject : paramList) {
/* 153 */         a(paramPacketDataSerializer, watchableObject);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 158 */     paramPacketDataSerializer.writeByte(127);
/*     */   }
/*     */   
/*     */   public List b() {
/* 162 */     ArrayList<WatchableObject> arrayList = null;
/*     */     
/* 164 */     if (this.e) {
/* 165 */       this.f.readLock().lock();
/* 166 */       for (WatchableObject watchableObject : this.d.values()) {
/* 167 */         if (watchableObject.d()) {
/* 168 */           watchableObject.a(false);
/*     */           
/* 170 */           if (arrayList == null) {
/* 171 */             arrayList = new ArrayList();
/*     */           }
/* 173 */           arrayList.add(watchableObject);
/*     */         } 
/*     */       } 
/* 176 */       this.f.readLock().unlock();
/*     */     } 
/* 178 */     this.e = false;
/*     */     
/* 180 */     return arrayList;
/*     */   }
/*     */   
/*     */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 184 */     this.f.readLock().lock();
/* 185 */     for (WatchableObject watchableObject : this.d.values()) {
/* 186 */       a(paramPacketDataSerializer, watchableObject);
/*     */     }
/* 188 */     this.f.readLock().unlock();
/*     */ 
/*     */     
/* 191 */     paramPacketDataSerializer.writeByte(127);
/*     */   }
/*     */   
/*     */   public List c() {
/* 195 */     ArrayList<WatchableObject> arrayList = null;
/*     */     
/* 197 */     this.f.readLock().lock();
/* 198 */     for (WatchableObject watchableObject : this.d.values()) {
/* 199 */       if (arrayList == null) {
/* 200 */         arrayList = new ArrayList();
/*     */       }
/* 202 */       arrayList.add(watchableObject);
/*     */     } 
/* 204 */     this.f.readLock().unlock();
/*     */     
/* 206 */     return arrayList;
/*     */   }
/*     */   private static void a(PacketDataSerializer paramPacketDataSerializer, WatchableObject paramWatchableObject) {
/*     */     ItemStack itemStack;
/*     */     ChunkCoordinates chunkCoordinates;
/* 211 */     int i = (paramWatchableObject.c() << 5 | paramWatchableObject.a() & 0x1F) & 0xFF;
/* 212 */     paramPacketDataSerializer.writeByte(i);
/*     */ 
/*     */     
/* 215 */     switch (paramWatchableObject.c()) {
/*     */       case 0:
/* 217 */         paramPacketDataSerializer.writeByte(((Byte)paramWatchableObject.b()).byteValue());
/*     */         break;
/*     */       case 1:
/* 220 */         paramPacketDataSerializer.writeShort(((Short)paramWatchableObject.b()).shortValue());
/*     */         break;
/*     */       case 2:
/* 223 */         paramPacketDataSerializer.writeInt(((Integer)paramWatchableObject.b()).intValue());
/*     */         break;
/*     */       case 3:
/* 226 */         paramPacketDataSerializer.writeFloat(((Float)paramWatchableObject.b()).floatValue());
/*     */         break;
/*     */       case 4:
/* 229 */         paramPacketDataSerializer.a((String)paramWatchableObject.b());
/*     */         break;
/*     */       case 5:
/* 232 */         itemStack = (ItemStack)paramWatchableObject.b();
/* 233 */         paramPacketDataSerializer.a(itemStack);
/*     */         break;
/*     */       
/*     */       case 6:
/* 237 */         chunkCoordinates = (ChunkCoordinates)paramWatchableObject.b();
/* 238 */         paramPacketDataSerializer.writeInt(chunkCoordinates.x);
/* 239 */         paramPacketDataSerializer.writeInt(chunkCoordinates.y);
/* 240 */         paramPacketDataSerializer.writeInt(chunkCoordinates.z);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static List b(PacketDataSerializer paramPacketDataSerializer) {
/* 246 */     ArrayList<WatchableObject> arrayList = null;
/*     */     
/* 248 */     byte b = paramPacketDataSerializer.readByte();
/*     */     
/* 250 */     while (b != Byte.MAX_VALUE) {
/*     */       int k, m, n;
/* 252 */       if (arrayList == null) {
/* 253 */         arrayList = new ArrayList();
/*     */       }
/*     */ 
/*     */       
/* 257 */       int i = (b & 0xE0) >> 5;
/* 258 */       int j = b & 0x1F;
/*     */       
/* 260 */       WatchableObject watchableObject = null;
/* 261 */       switch (i) {
/*     */         case 0:
/* 263 */           watchableObject = new WatchableObject(i, j, Byte.valueOf(paramPacketDataSerializer.readByte()));
/*     */           break;
/*     */         case 1:
/* 266 */           watchableObject = new WatchableObject(i, j, Short.valueOf(paramPacketDataSerializer.readShort()));
/*     */           break;
/*     */         case 2:
/* 269 */           watchableObject = new WatchableObject(i, j, Integer.valueOf(paramPacketDataSerializer.readInt()));
/*     */           break;
/*     */         case 3:
/* 272 */           watchableObject = new WatchableObject(i, j, Float.valueOf(paramPacketDataSerializer.readFloat()));
/*     */           break;
/*     */         case 4:
/* 275 */           watchableObject = new WatchableObject(i, j, paramPacketDataSerializer.c(32767));
/*     */           break;
/*     */         case 5:
/* 278 */           watchableObject = new WatchableObject(i, j, paramPacketDataSerializer.c());
/*     */           break;
/*     */         case 6:
/* 281 */           k = paramPacketDataSerializer.readInt();
/* 282 */           m = paramPacketDataSerializer.readInt();
/* 283 */           n = paramPacketDataSerializer.readInt();
/* 284 */           watchableObject = new WatchableObject(i, j, new ChunkCoordinates(k, m, n));
/*     */           break;
/*     */       } 
/* 287 */       arrayList.add(watchableObject);
/*     */       
/* 289 */       b = paramPacketDataSerializer.readByte();
/*     */     } 
/*     */     
/* 292 */     return arrayList;
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
/*     */   public boolean d() {
/* 316 */     return this.b;
/*     */   }
/*     */   
/*     */   public void e() {
/* 320 */     this.e = false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\DataWatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */