/*    */ package net.minecraft.world.storage;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ 
/*    */ public class ThreadedFileIOBase implements Runnable {
/*  6 */   public static final ThreadedFileIOBase field_75741_a = new ThreadedFileIOBase();
/*    */   
/*  8 */   private List field_75739_b = Collections.synchronizedList(new ArrayList());
/*    */   private volatile long field_75740_c;
/*    */   private volatile long field_75737_d;
/*    */   private volatile boolean field_75738_e;
/*    */   private static final String __OBFID = "CL_00000605";
/*    */   
/*    */   private ThreadedFileIOBase() {
/* 15 */     Thread thread = new Thread(this, "File IO Thread");
/* 16 */     thread.setPriority(1);
/* 17 */     thread.start();
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/*    */     while (true) {
/* 23 */       func_75736_b();
/*    */     }
/*    */   }
/*    */   
/*    */   private void func_75736_b() {
/* 28 */     for (byte b = 0; b < this.field_75739_b.size(); b++) {
/* 29 */       IThreadedFileIO iThreadedFileIO = this.field_75739_b.get(b);
/* 30 */       boolean bool = iThreadedFileIO.func_75814_c();
/* 31 */       if (!bool) {
/* 32 */         this.field_75739_b.remove(b--);
/* 33 */         this.field_75737_d++;
/*    */       } 
/*    */       
/*    */       try {
/* 37 */         Thread.sleep(this.field_75738_e ? 0L : 10L);
/* 38 */       } catch (InterruptedException interruptedException) {
/* 39 */         interruptedException.printStackTrace();
/*    */       } 
/*    */     } 
/* 42 */     if (this.field_75739_b.isEmpty()) {
/*    */       try {
/* 44 */         Thread.sleep(25L);
/* 45 */       } catch (InterruptedException interruptedException) {
/* 46 */         interruptedException.printStackTrace();
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   public void func_75735_a(IThreadedFileIO p_75735_1_) {
/* 52 */     if (this.field_75739_b.contains(p_75735_1_))
/* 53 */       return;  this.field_75740_c++;
/* 54 */     this.field_75739_b.add(p_75735_1_);
/*    */   }
/*    */   
/*    */   public void func_75734_a() throws InterruptedException {
/* 58 */     this.field_75738_e = true;
/* 59 */     while (this.field_75740_c != this.field_75737_d) {
/* 60 */       Thread.sleep(10L);
/*    */     }
/* 62 */     this.field_75738_e = false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\storage\ThreadedFileIOBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */