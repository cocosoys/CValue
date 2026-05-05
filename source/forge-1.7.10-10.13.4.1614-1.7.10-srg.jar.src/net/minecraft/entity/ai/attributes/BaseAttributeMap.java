/*    */ package net.minecraft.entity.ai.attributes;
/*    */ 
/*    */ import com.google.common.collect.Multimap;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.minecraft.server.management.LowerStringMap;
/*    */ 
/*    */ public abstract class BaseAttributeMap
/*    */ {
/* 11 */   protected final Map field_111154_a = new HashMap<Object, Object>();
/* 12 */   protected final Map field_111153_b = (Map)new LowerStringMap();
/*    */   
/*    */   public IAttributeInstance func_111151_a(IAttribute p_111151_1_) {
/* 15 */     return (IAttributeInstance)this.field_111154_a.get(p_111151_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001566";
/*    */   public IAttributeInstance func_111152_a(String p_111152_1_) {
/* 19 */     return (IAttributeInstance)this.field_111153_b.get(p_111152_1_);
/*    */   }
/*    */   
/*    */   public abstract IAttributeInstance func_111150_b(IAttribute paramIAttribute);
/*    */   
/*    */   public Collection func_111146_a() {
/* 25 */     return this.field_111153_b.values();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_111149_a(ModifiableAttributeInstance p_111149_1_) {}
/*    */ 
/*    */   
/*    */   public void func_111148_a(Multimap p_111148_1_) {
/* 33 */     for (Map.Entry entry : p_111148_1_.entries()) {
/* 34 */       IAttributeInstance iAttributeInstance = func_111152_a((String)entry.getKey());
/*    */       
/* 36 */       if (iAttributeInstance != null) {
/* 37 */         iAttributeInstance.func_111124_b((AttributeModifier)entry.getValue());
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public void func_111147_b(Multimap p_111147_1_) {
/* 43 */     for (Map.Entry entry : p_111147_1_.entries()) {
/* 44 */       IAttributeInstance iAttributeInstance = func_111152_a((String)entry.getKey());
/*    */       
/* 46 */       if (iAttributeInstance != null) {
/* 47 */         iAttributeInstance.func_111124_b((AttributeModifier)entry.getValue());
/* 48 */         iAttributeInstance.func_111121_a((AttributeModifier)entry.getValue());
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\attributes\BaseAttributeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */