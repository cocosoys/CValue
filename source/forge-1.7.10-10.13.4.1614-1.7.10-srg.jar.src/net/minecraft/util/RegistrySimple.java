/*    */ package net.minecraft.util;
/*    */ 
/*    */ import com.google.common.collect.Maps;
/*    */ import java.util.Collections;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ public class RegistrySimple
/*    */   implements IRegistry
/*    */ {
/* 13 */   private static final Logger field_148743_a = LogManager.getLogger();
/* 14 */   protected final Map field_82596_a = func_148740_a();
/*    */   
/*    */   protected Map func_148740_a() {
/* 17 */     return Maps.newHashMap();
/*    */   }
/*    */   private static final String __OBFID = "CL_00001210";
/*    */   
/*    */   public Object func_82594_a(Object p_82594_1_) {
/* 22 */     return this.field_82596_a.get(p_82594_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_82595_a(Object p_82595_1_, Object p_82595_2_) {
/* 27 */     if (this.field_82596_a.containsKey(p_82595_1_)) {
/* 28 */       field_148743_a.debug("Adding duplicate key '" + p_82595_1_ + "' to registry");
/*    */     }
/* 30 */     this.field_82596_a.put(p_82595_1_, p_82595_2_);
/*    */   }
/*    */   
/*    */   public Set func_148742_b() {
/* 34 */     return Collections.unmodifiableSet(this.field_82596_a.keySet());
/*    */   }
/*    */   
/*    */   public boolean func_148741_d(Object p_148741_1_) {
/* 38 */     return this.field_82596_a.containsKey(p_148741_1_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\RegistrySimple.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */