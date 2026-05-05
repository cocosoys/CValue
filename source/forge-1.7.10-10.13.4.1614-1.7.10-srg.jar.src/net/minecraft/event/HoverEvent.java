/*    */ package net.minecraft.event;
/*    */ 
/*    */ import com.google.common.collect.Maps;
/*    */ import java.util.Map;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class HoverEvent
/*    */ {
/*    */   private final Action field_150704_a;
/*    */   
/*    */   public HoverEvent(Action p_i45158_1_, IChatComponent p_i45158_2_) {
/* 12 */     this.field_150704_a = p_i45158_1_;
/* 13 */     this.field_150703_b = p_i45158_2_;
/*    */   }
/*    */   private final IChatComponent field_150703_b; private static final String __OBFID = "CL_00001264";
/*    */   public Action func_150701_a() {
/* 17 */     return this.field_150704_a;
/*    */   }
/*    */   
/*    */   public IChatComponent func_150702_b() {
/* 21 */     return this.field_150703_b;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 26 */     if (this == p_equals_1_) return true; 
/* 27 */     if (p_equals_1_ == null || getClass() != p_equals_1_.getClass()) return false;
/*    */     
/* 29 */     HoverEvent hoverEvent = (HoverEvent)p_equals_1_;
/*    */     
/* 31 */     if (this.field_150704_a != hoverEvent.field_150704_a) return false; 
/* 32 */     if ((this.field_150703_b != null) ? !this.field_150703_b.equals(hoverEvent.field_150703_b) : (hoverEvent.field_150703_b != null)) return false;
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 39 */     return "HoverEvent{action=" + this.field_150704_a + ", value='" + this.field_150703_b + '\'' + '}';
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 47 */     int i = this.field_150704_a.hashCode();
/* 48 */     i = 31 * i + ((this.field_150703_b != null) ? this.field_150703_b.hashCode() : 0);
/* 49 */     return i;
/*    */   }
/*    */   
/*    */   public enum Action {
/* 53 */     SHOW_TEXT("show_text", true),
/* 54 */     SHOW_ACHIEVEMENT("show_achievement", true),
/* 55 */     SHOW_ITEM("show_item", true);
/*    */     
/* 57 */     private static final Map field_150690_d = Maps.newHashMap();
/*    */ 
/*    */ 
/*    */     
/*    */     private final boolean field_150691_e;
/*    */ 
/*    */ 
/*    */     
/*    */     private final String field_150688_f;
/*    */ 
/*    */ 
/*    */     
/*    */     private static final String __OBFID = "CL_00001265";
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     static {
/* 75 */       for (Action action : values()) {
/* 76 */         field_150690_d.put(action.func_150685_b(), action);
/*    */       }
/*    */     }
/*    */     
/*    */     public static Action func_150684_a(String p_150684_0_) {
/* 81 */       return (Action)field_150690_d.get(p_150684_0_);
/*    */     }
/*    */     
/*    */     Action(String p_i45157_3_, boolean p_i45157_4_) {
/*    */       this.field_150688_f = p_i45157_3_;
/*    */       this.field_150691_e = p_i45157_4_;
/*    */     }
/*    */     
/*    */     public boolean func_150686_a() {
/*    */       return this.field_150691_e;
/*    */     }
/*    */     
/*    */     public String func_150685_b() {
/*    */       return this.field_150688_f;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\event\HoverEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */