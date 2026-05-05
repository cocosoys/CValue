/*    */ package net.minecraft.util;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import java.lang.reflect.Array;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ThreadSafeBoundList {
/*    */   private final Object[] field_152759_a;
/* 10 */   private final ReadWriteLock field_152761_c = new ReentrantReadWriteLock(); private final Class field_152760_b;
/*    */   private int field_152762_d;
/*    */   private int field_152763_e;
/*    */   private static final String __OBFID = "CL_00001868";
/*    */   
/*    */   public ThreadSafeBoundList(Class<?> p_i1126_1_, int p_i1126_2_) {
/* 16 */     this.field_152760_b = p_i1126_1_;
/* 17 */     this.field_152759_a = (Object[])Array.newInstance(p_i1126_1_, p_i1126_2_);
/*    */   }
/*    */   
/*    */   public Object func_152757_a(Object p_152757_1_) {
/* 21 */     this.field_152761_c.writeLock().lock();
/*    */     
/* 23 */     this.field_152759_a[this.field_152763_e] = p_152757_1_;
/* 24 */     this.field_152763_e = (this.field_152763_e + 1) % func_152758_b();
/* 25 */     if (this.field_152762_d < func_152758_b()) this.field_152762_d++;
/*    */     
/* 27 */     this.field_152761_c.writeLock().unlock();
/* 28 */     return p_152757_1_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_152758_b() {
/* 39 */     this.field_152761_c.readLock().lock();
/* 40 */     int i = this.field_152759_a.length;
/* 41 */     this.field_152761_c.readLock().unlock();
/* 42 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object[] func_152756_c() {
/* 47 */     Object[] arrayOfObject = (Object[])Array.newInstance(this.field_152760_b, this.field_152762_d);
/*    */     
/* 49 */     this.field_152761_c.readLock().lock();
/* 50 */     for (byte b = 0; b < this.field_152762_d; b++) {
/* 51 */       int i = (this.field_152763_e - this.field_152762_d + b) % func_152758_b();
/* 52 */       if (i < 0) i += func_152758_b(); 
/* 53 */       arrayOfObject[b] = this.field_152759_a[i];
/*    */     } 
/* 55 */     this.field_152761_c.readLock().unlock();
/*    */     
/* 57 */     return arrayOfObject;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\ThreadSafeBoundList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */