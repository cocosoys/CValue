/*     */ package cpw.mods.fml.common.eventhandler;
/*     */ 
/*     */ import com.google.common.base.Preconditions;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import javax.annotation.Nonnull;
/*     */ import javax.annotation.Nullable;
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
/*     */ public class Event
/*     */ {
/*     */   public enum Result
/*     */   {
/*  26 */     DENY,
/*  27 */     DEFAULT,
/*  28 */     ALLOW;
/*     */   }
/*     */   
/*     */   private boolean isCanceled = false;
/*  32 */   private Result result = Result.DEFAULT;
/*  33 */   private static ListenerList listeners = new ListenerList();
/*  34 */   private EventPriority phase = null;
/*     */ 
/*     */   
/*     */   public Event() {
/*  38 */     setup();
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
/*     */   public boolean isCancelable() {
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCanceled() {
/*  59 */     return this.isCanceled;
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
/*     */   public void setCanceled(boolean cancel) {
/*  72 */     if (!isCancelable())
/*     */     {
/*  74 */       throw new IllegalArgumentException("Attempted to cancel a uncancelable event");
/*     */     }
/*  76 */     this.isCanceled = cancel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasResult() {
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Result getResult() {
/*  95 */     return this.result;
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
/*     */   public void setResult(Result value) {
/* 108 */     this.result = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setup() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ListenerList getListenerList() {
/* 126 */     return listeners;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public EventPriority getPhase() {
/* 132 */     return this.phase;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPhase(@Nonnull EventPriority value) {
/* 137 */     Preconditions.checkArgument((value != null), "setPhase argument must not be null");
/* 138 */     int prev = (this.phase == null) ? -1 : this.phase.ordinal();
/* 139 */     Preconditions.checkArgument((prev < value.ordinal()), "Attempted to set event phase to %s when already %s", new Object[] { value, this.phase });
/* 140 */     this.phase = value;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   @Target({ElementType.TYPE})
/*     */   public static @interface HasResult {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\eventhandler\Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */