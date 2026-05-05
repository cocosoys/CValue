/*    */ package net.minecraft.util.com.mojang.authlib.yggdrasil.response;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.minecraft.util.com.mojang.authlib.properties.PropertyMap;
/*    */ 
/*    */ public class MinecraftProfilePropertiesResponse
/*    */   extends Response {
/*    */   private UUID id;
/*    */   private String name;
/*    */   private PropertyMap properties;
/*    */   
/*    */   public UUID getId() {
/* 13 */     return this.id;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 17 */     return this.name;
/*    */   }
/*    */   
/*    */   public PropertyMap getProperties() {
/* 21 */     return this.properties;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\mojang\authlib\yggdrasil\response\MinecraftProfilePropertiesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */