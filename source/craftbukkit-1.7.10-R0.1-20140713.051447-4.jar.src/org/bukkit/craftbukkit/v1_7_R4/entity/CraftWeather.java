/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ import net.minecraft.server.v1_7_R4.Entity;
/*    */ import net.minecraft.server.v1_7_R4.EntityWeather;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.Weather;
/*    */ 
/*    */ public class CraftWeather extends CraftEntity implements Weather {
/*    */   public CraftWeather(CraftServer server, EntityWeather entity) {
/* 10 */     super(server, (Entity)entity);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityWeather getHandle() {
/* 15 */     return (EntityWeather)this.entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 20 */     return "CraftWeather";
/*    */   }
/*    */   
/*    */   public EntityType getType() {
/* 24 */     return EntityType.WEATHER;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftWeather.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */