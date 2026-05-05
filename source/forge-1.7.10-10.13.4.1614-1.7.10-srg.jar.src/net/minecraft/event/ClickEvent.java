/*    */ package net.minecraft.event;
/*    */ 
/*    */ import com.google.common.collect.Maps;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class ClickEvent {
/*    */   private final Action field_150671_a;
/*    */   private final String field_150670_b;
/*    */   private static final String __OBFID = "CL_00001260";
/*    */   
/*    */   public ClickEvent(Action p_i45156_1_, String p_i45156_2_) {
/* 12 */     this.field_150671_a = p_i45156_1_;
/* 13 */     this.field_150670_b = p_i45156_2_;
/*    */   }
/*    */   
/*    */   public Action func_150669_a() {
/* 17 */     return this.field_150671_a;
/*    */   }
/*    */   
/*    */   public String func_150668_b() {
/* 21 */     return this.field_150670_b;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 26 */     if (this == p_equals_1_) return true; 
/* 27 */     if (p_equals_1_ == null || getClass() != p_equals_1_.getClass()) return false;
/*    */     
/* 29 */     ClickEvent clickEvent = (ClickEvent)p_equals_1_;
/*    */     
/* 31 */     if (this.field_150671_a != clickEvent.field_150671_a) return false; 
/* 32 */     if ((this.field_150670_b != null) ? !this.field_150670_b.equals(clickEvent.field_150670_b) : (clickEvent.field_150670_b != null)) return false;
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 39 */     return "ClickEvent{action=" + this.field_150671_a + ", value='" + this.field_150670_b + '\'' + '}';
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 47 */     int i = this.field_150671_a.hashCode();
/* 48 */     i = 31 * i + ((this.field_150670_b != null) ? this.field_150670_b.hashCode() : 0);
/* 49 */     return i;
/*    */   }
/*    */   
/*    */   public enum Action {
/* 53 */     OPEN_URL("open_url", true),
/* 54 */     OPEN_FILE("open_file", false),
/* 55 */     RUN_COMMAND("run_command", true),
/* 56 */     TWITCH_USER_INFO("twitch_user_info", false),
/* 57 */     SUGGEST_COMMAND("suggest_command", true);
/*    */     
/* 59 */     private static final Map field_150679_e = Maps.newHashMap();
/*    */ 
/*    */ 
/*    */     
/*    */     private final boolean field_150676_f;
/*    */ 
/*    */ 
/*    */     
/*    */     private final String field_150677_g;
/*    */ 
/*    */ 
/*    */     
/*    */     private static final String __OBFID = "CL_00001261";
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     static {
/* 77 */       for (Action action : values()) {
/* 78 */         field_150679_e.put(action.func_150673_b(), action);
/*    */       }
/*    */     }
/*    */     
/*    */     public static Action func_150672_a(String p_150672_0_) {
/* 83 */       return (Action)field_150679_e.get(p_150672_0_);
/*    */     }
/*    */     
/*    */     Action(String p_i45155_3_, boolean p_i45155_4_) {
/*    */       this.field_150677_g = p_i45155_3_;
/*    */       this.field_150676_f = p_i45155_4_;
/*    */     }
/*    */     
/*    */     public boolean func_150674_a() {
/*    */       return this.field_150676_f;
/*    */     }
/*    */     
/*    */     public String func_150673_b() {
/*    */       return this.field_150677_g;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\event\ClickEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */