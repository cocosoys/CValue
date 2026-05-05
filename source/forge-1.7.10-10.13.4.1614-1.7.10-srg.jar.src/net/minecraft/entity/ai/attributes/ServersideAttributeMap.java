/*    */ package net.minecraft.entity.ai.attributes;
/*    */ 
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.Collection;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import net.minecraft.server.management.LowerStringMap;
/*    */ 
/*    */ public class ServersideAttributeMap extends BaseAttributeMap {
/* 11 */   private final Set field_111162_d = Sets.newHashSet();
/* 12 */   protected final Map field_111163_c = (Map)new LowerStringMap();
/*    */   private static final String __OBFID = "CL_00001569";
/*    */   
/*    */   public ModifiableAttributeInstance func_111151_a(IAttribute p_111151_1_) {
/* 16 */     return (ModifiableAttributeInstance)super.func_111151_a(p_111151_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public ModifiableAttributeInstance func_111152_a(String p_111152_1_) {
/* 21 */     IAttributeInstance iAttributeInstance = super.func_111152_a(p_111152_1_);
/* 22 */     if (iAttributeInstance == null) iAttributeInstance = (IAttributeInstance)this.field_111163_c.get(p_111152_1_); 
/* 23 */     return (ModifiableAttributeInstance)iAttributeInstance;
/*    */   }
/*    */ 
/*    */   
/*    */   public IAttributeInstance func_111150_b(IAttribute p_111150_1_) {
/* 28 */     if (this.field_111153_b.containsKey(p_111150_1_.func_111108_a())) throw new IllegalArgumentException("Attribute is already registered!");
/*    */     
/* 30 */     ModifiableAttributeInstance modifiableAttributeInstance = new ModifiableAttributeInstance(this, p_111150_1_);
/* 31 */     this.field_111153_b.put(p_111150_1_.func_111108_a(), modifiableAttributeInstance);
/* 32 */     if (p_111150_1_ instanceof RangedAttribute && ((RangedAttribute)p_111150_1_).func_111116_f() != null) {
/* 33 */       this.field_111163_c.put(((RangedAttribute)p_111150_1_).func_111116_f(), modifiableAttributeInstance);
/*    */     }
/* 35 */     this.field_111154_a.put(p_111150_1_, modifiableAttributeInstance);
/*    */     
/* 37 */     return modifiableAttributeInstance;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_111149_a(ModifiableAttributeInstance p_111149_1_) {
/* 42 */     if (p_111149_1_.func_111123_a().func_111111_c()) {
/* 43 */       this.field_111162_d.add(p_111149_1_);
/*    */     }
/*    */   }
/*    */   
/*    */   public Set func_111161_b() {
/* 48 */     return this.field_111162_d;
/*    */   }
/*    */   
/*    */   public Collection func_111160_c() {
/* 52 */     HashSet<IAttributeInstance> hashSet = Sets.newHashSet();
/*    */     
/* 54 */     for (IAttributeInstance iAttributeInstance : func_111146_a()) {
/* 55 */       if (iAttributeInstance.func_111123_a().func_111111_c()) {
/* 56 */         hashSet.add(iAttributeInstance);
/*    */       }
/*    */     } 
/*    */     
/* 60 */     return hashSet;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\attributes\ServersideAttributeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */