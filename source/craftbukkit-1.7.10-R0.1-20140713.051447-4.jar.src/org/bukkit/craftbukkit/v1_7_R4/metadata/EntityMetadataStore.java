/*    */ package org.bukkit.craftbukkit.v1_7_R4.metadata;
/*    */ 
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.metadata.MetadataStore;
/*    */ import org.bukkit.metadata.MetadataStoreBase;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityMetadataStore
/*    */   extends MetadataStoreBase<Entity>
/*    */   implements MetadataStore<Entity>
/*    */ {
/*    */   protected String disambiguate(Entity entity, String metadataKey) {
/* 21 */     return entity.getUniqueId().toString() + ":" + metadataKey;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\metadata\EntityMetadataStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */