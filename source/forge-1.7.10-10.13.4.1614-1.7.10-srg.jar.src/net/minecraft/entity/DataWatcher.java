/*     */ package net.minecraft.entity;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.ReportedException;
/*     */ import org.apache.commons.lang3.ObjectUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataWatcher
/*     */ {
/*     */   private final Entity field_151511_a;
/*     */   private boolean field_92086_a = true;
/*  28 */   private static final HashMap field_75697_a = new HashMap<Object, Object>();
/*     */   
/*     */   static {
/*  31 */     field_75697_a.put(Byte.class, Integer.valueOf(0));
/*  32 */     field_75697_a.put(Short.class, Integer.valueOf(1));
/*  33 */     field_75697_a.put(Integer.class, Integer.valueOf(2));
/*  34 */     field_75697_a.put(Float.class, Integer.valueOf(3));
/*  35 */     field_75697_a.put(String.class, Integer.valueOf(4));
/*  36 */     field_75697_a.put(ItemStack.class, Integer.valueOf(5));
/*  37 */     field_75697_a.put(ChunkCoordinates.class, Integer.valueOf(6));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   private final Map field_75695_b = new HashMap<Object, Object>();
/*     */   private boolean field_75696_c;
/*  49 */   private ReadWriteLock field_75694_d = new ReentrantReadWriteLock();
/*     */   
/*     */   public DataWatcher(Entity p_i45313_1_) {
/*  52 */     this.field_151511_a = p_i45313_1_;
/*     */   }
/*     */   private static final String __OBFID = "CL_00001559";
/*     */   public void func_75682_a(int p_75682_1_, Object p_75682_2_) {
/*  56 */     Integer integer = (Integer)field_75697_a.get(p_75682_2_.getClass());
/*  57 */     if (integer == null) {
/*  58 */       throw new IllegalArgumentException("Unknown data type: " + p_75682_2_.getClass());
/*     */     }
/*  60 */     if (p_75682_1_ > 31) {
/*  61 */       throw new IllegalArgumentException("Data value id is too big with " + p_75682_1_ + "! (Max is " + '\037' + ")");
/*     */     }
/*  63 */     if (this.field_75695_b.containsKey(Integer.valueOf(p_75682_1_))) {
/*  64 */       throw new IllegalArgumentException("Duplicate id value for " + p_75682_1_ + "!");
/*     */     }
/*     */     
/*  67 */     WatchableObject watchableObject = new WatchableObject(integer.intValue(), p_75682_1_, p_75682_2_);
/*  68 */     this.field_75694_d.writeLock().lock();
/*  69 */     this.field_75695_b.put(Integer.valueOf(p_75682_1_), watchableObject);
/*  70 */     this.field_75694_d.writeLock().unlock();
/*  71 */     this.field_92086_a = false;
/*     */   }
/*     */   
/*     */   public void func_82709_a(int p_82709_1_, int p_82709_2_) {
/*  75 */     WatchableObject watchableObject = new WatchableObject(p_82709_2_, p_82709_1_, null);
/*  76 */     this.field_75694_d.writeLock().lock();
/*  77 */     this.field_75695_b.put(Integer.valueOf(p_82709_1_), watchableObject);
/*  78 */     this.field_75694_d.writeLock().unlock();
/*  79 */     this.field_92086_a = false;
/*     */   }
/*     */   
/*     */   public byte func_75683_a(int p_75683_1_) {
/*  83 */     return ((Byte)func_75691_i(p_75683_1_).func_75669_b()).byteValue();
/*     */   }
/*     */   
/*     */   public short func_75693_b(int p_75693_1_) {
/*  87 */     return ((Short)func_75691_i(p_75693_1_).func_75669_b()).shortValue();
/*     */   }
/*     */   
/*     */   public int func_75679_c(int p_75679_1_) {
/*  91 */     return ((Integer)func_75691_i(p_75679_1_).func_75669_b()).intValue();
/*     */   }
/*     */   
/*     */   public float func_111145_d(int p_111145_1_) {
/*  95 */     return ((Float)func_75691_i(p_111145_1_).func_75669_b()).floatValue();
/*     */   }
/*     */   
/*     */   public String func_75681_e(int p_75681_1_) {
/*  99 */     return (String)func_75691_i(p_75681_1_).func_75669_b();
/*     */   }
/*     */   
/*     */   public ItemStack func_82710_f(int p_82710_1_) {
/* 103 */     return (ItemStack)func_75691_i(p_82710_1_).func_75669_b();
/*     */   }
/*     */   
/*     */   private WatchableObject func_75691_i(int p_75691_1_) {
/*     */     WatchableObject watchableObject;
/* 108 */     this.field_75694_d.readLock().lock();
/*     */     
/*     */     try {
/* 111 */       watchableObject = (WatchableObject)this.field_75695_b.get(Integer.valueOf(p_75691_1_));
/* 112 */     } catch (Throwable throwable) {
/* 113 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Getting synched entity data");
/* 114 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Synched entity data");
/*     */       
/* 116 */       crashReportCategory.func_71507_a("Data ID", Integer.valueOf(p_75691_1_));
/* 117 */       throw new ReportedException(crashReport);
/*     */     } 
/*     */     
/* 120 */     this.field_75694_d.readLock().unlock();
/* 121 */     return watchableObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75692_b(int p_75692_1_, Object p_75692_2_) {
/* 130 */     WatchableObject watchableObject = func_75691_i(p_75692_1_);
/*     */ 
/*     */     
/* 133 */     if (ObjectUtils.notEqual(p_75692_2_, watchableObject.func_75669_b())) {
/* 134 */       watchableObject.func_75673_a(p_75692_2_);
/* 135 */       this.field_151511_a.func_145781_i(p_75692_1_);
/* 136 */       watchableObject.func_75671_a(true);
/* 137 */       this.field_75696_c = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_82708_h(int p_82708_1_) {
/* 142 */     (func_75691_i(p_82708_1_)).field_75675_d = true;
/* 143 */     this.field_75696_c = true;
/*     */   }
/*     */   
/*     */   public boolean func_75684_a() {
/* 147 */     return this.field_75696_c;
/*     */   }
/*     */   
/*     */   public static void func_151507_a(List p_151507_0_, PacketBuffer p_151507_1_) throws IOException {
/* 151 */     if (p_151507_0_ != null) {
/* 152 */       for (WatchableObject watchableObject : p_151507_0_) {
/* 153 */         func_151510_a(p_151507_1_, watchableObject);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 158 */     p_151507_1_.writeByte(127);
/*     */   }
/*     */   
/*     */   public List func_75688_b() {
/* 162 */     ArrayList<WatchableObject> arrayList = null;
/*     */     
/* 164 */     if (this.field_75696_c) {
/* 165 */       this.field_75694_d.readLock().lock();
/* 166 */       for (WatchableObject watchableObject : this.field_75695_b.values()) {
/* 167 */         if (watchableObject.func_75670_d()) {
/* 168 */           watchableObject.func_75671_a(false);
/*     */           
/* 170 */           if (arrayList == null) {
/* 171 */             arrayList = new ArrayList();
/*     */           }
/* 173 */           arrayList.add(watchableObject);
/*     */         } 
/*     */       } 
/* 176 */       this.field_75694_d.readLock().unlock();
/*     */     } 
/* 178 */     this.field_75696_c = false;
/*     */     
/* 180 */     return arrayList;
/*     */   }
/*     */   
/*     */   public void func_151509_a(PacketBuffer p_151509_1_) throws IOException {
/* 184 */     this.field_75694_d.readLock().lock();
/* 185 */     for (WatchableObject watchableObject : this.field_75695_b.values()) {
/* 186 */       func_151510_a(p_151509_1_, watchableObject);
/*     */     }
/* 188 */     this.field_75694_d.readLock().unlock();
/*     */ 
/*     */     
/* 191 */     p_151509_1_.writeByte(127);
/*     */   }
/*     */   
/*     */   public List func_75685_c() {
/* 195 */     ArrayList<WatchableObject> arrayList = null;
/*     */     
/* 197 */     this.field_75694_d.readLock().lock();
/* 198 */     for (WatchableObject watchableObject : this.field_75695_b.values()) {
/* 199 */       if (arrayList == null) {
/* 200 */         arrayList = new ArrayList();
/*     */       }
/* 202 */       arrayList.add(watchableObject);
/*     */     } 
/* 204 */     this.field_75694_d.readLock().unlock();
/*     */     
/* 206 */     return arrayList;
/*     */   }
/*     */   private static void func_151510_a(PacketBuffer p_151510_0_, WatchableObject p_151510_1_) throws IOException {
/*     */     ItemStack itemStack;
/*     */     ChunkCoordinates chunkCoordinates;
/* 211 */     int i = (p_151510_1_.func_75674_c() << 5 | p_151510_1_.func_75672_a() & 0x1F) & 0xFF;
/* 212 */     p_151510_0_.writeByte(i);
/*     */ 
/*     */     
/* 215 */     switch (p_151510_1_.func_75674_c()) {
/*     */       case 0:
/* 217 */         p_151510_0_.writeByte(((Byte)p_151510_1_.func_75669_b()).byteValue());
/*     */         break;
/*     */       case 1:
/* 220 */         p_151510_0_.writeShort(((Short)p_151510_1_.func_75669_b()).shortValue());
/*     */         break;
/*     */       case 2:
/* 223 */         p_151510_0_.writeInt(((Integer)p_151510_1_.func_75669_b()).intValue());
/*     */         break;
/*     */       case 3:
/* 226 */         p_151510_0_.writeFloat(((Float)p_151510_1_.func_75669_b()).floatValue());
/*     */         break;
/*     */       case 4:
/* 229 */         p_151510_0_.func_150785_a((String)p_151510_1_.func_75669_b());
/*     */         break;
/*     */       case 5:
/* 232 */         itemStack = (ItemStack)p_151510_1_.func_75669_b();
/* 233 */         p_151510_0_.func_150788_a(itemStack);
/*     */         break;
/*     */       
/*     */       case 6:
/* 237 */         chunkCoordinates = (ChunkCoordinates)p_151510_1_.func_75669_b();
/* 238 */         p_151510_0_.writeInt(chunkCoordinates.field_71574_a);
/* 239 */         p_151510_0_.writeInt(chunkCoordinates.field_71572_b);
/* 240 */         p_151510_0_.writeInt(chunkCoordinates.field_71573_c);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static List func_151508_b(PacketBuffer p_151508_0_) throws IOException {
/* 246 */     ArrayList<WatchableObject> arrayList = null;
/*     */     
/* 248 */     byte b = p_151508_0_.readByte();
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
/* 263 */           watchableObject = new WatchableObject(i, j, Byte.valueOf(p_151508_0_.readByte()));
/*     */           break;
/*     */         case 1:
/* 266 */           watchableObject = new WatchableObject(i, j, Short.valueOf(p_151508_0_.readShort()));
/*     */           break;
/*     */         case 2:
/* 269 */           watchableObject = new WatchableObject(i, j, Integer.valueOf(p_151508_0_.readInt()));
/*     */           break;
/*     */         case 3:
/* 272 */           watchableObject = new WatchableObject(i, j, Float.valueOf(p_151508_0_.readFloat()));
/*     */           break;
/*     */         case 4:
/* 275 */           watchableObject = new WatchableObject(i, j, p_151508_0_.func_150789_c(32767));
/*     */           break;
/*     */         case 5:
/* 278 */           watchableObject = new WatchableObject(i, j, p_151508_0_.func_150791_c());
/*     */           break;
/*     */         case 6:
/* 281 */           k = p_151508_0_.readInt();
/* 282 */           m = p_151508_0_.readInt();
/* 283 */           n = p_151508_0_.readInt();
/* 284 */           watchableObject = new WatchableObject(i, j, new ChunkCoordinates(k, m, n));
/*     */           break;
/*     */       } 
/* 287 */       arrayList.add(watchableObject);
/*     */       
/* 289 */       b = p_151508_0_.readByte();
/*     */     } 
/*     */     
/* 292 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75687_a(List p_75687_1_) {
/* 301 */     this.field_75694_d.writeLock().lock();
/* 302 */     for (WatchableObject watchableObject1 : p_75687_1_) {
/* 303 */       WatchableObject watchableObject2 = (WatchableObject)this.field_75695_b.get(Integer.valueOf(watchableObject1.func_75672_a()));
/* 304 */       if (watchableObject2 != null) {
/* 305 */         watchableObject2.func_75673_a(watchableObject1.func_75669_b());
/* 306 */         this.field_151511_a.func_145781_i(watchableObject1.func_75672_a());
/*     */       } 
/*     */     } 
/* 309 */     this.field_75694_d.writeLock().unlock();
/*     */ 
/*     */     
/* 312 */     this.field_75696_c = true;
/*     */   }
/*     */   
/*     */   public boolean func_92085_d() {
/* 316 */     return this.field_92086_a;
/*     */   }
/*     */   
/*     */   public void func_111144_e() {
/* 320 */     this.field_75696_c = false;
/*     */   }
/*     */   
/*     */   public static class WatchableObject { private final int field_75678_a;
/*     */     private final int field_75676_b;
/*     */     private Object field_75677_c;
/*     */     private boolean field_75675_d;
/*     */     private static final String __OBFID = "CL_00001560";
/*     */     
/*     */     public WatchableObject(int p_i1603_1_, int p_i1603_2_, Object p_i1603_3_) {
/* 330 */       this.field_75676_b = p_i1603_2_;
/* 331 */       this.field_75677_c = p_i1603_3_;
/* 332 */       this.field_75678_a = p_i1603_1_;
/* 333 */       this.field_75675_d = true;
/*     */     }
/*     */     
/*     */     public int func_75672_a() {
/* 337 */       return this.field_75676_b;
/*     */     }
/*     */     
/*     */     public void func_75673_a(Object p_75673_1_) {
/* 341 */       this.field_75677_c = p_75673_1_;
/*     */     }
/*     */     
/*     */     public Object func_75669_b() {
/* 345 */       return this.field_75677_c;
/*     */     }
/*     */     
/*     */     public int func_75674_c() {
/* 349 */       return this.field_75678_a;
/*     */     }
/*     */     
/*     */     public boolean func_75670_d() {
/* 353 */       return this.field_75675_d;
/*     */     }
/*     */     
/*     */     public void func_75671_a(boolean p_75671_1_) {
/* 357 */       this.field_75675_d = p_75671_1_;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\DataWatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */