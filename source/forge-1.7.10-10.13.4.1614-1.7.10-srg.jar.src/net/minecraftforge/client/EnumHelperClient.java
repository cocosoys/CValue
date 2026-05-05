/*    */ package net.minecraftforge.client;
/*    */ 
/*    */ import net.minecraft.client.settings.GameSettings;
/*    */ import net.minecraft.util.Util;
/*    */ import net.minecraft.world.WorldSettings;
/*    */ import net.minecraftforge.common.util.EnumHelper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EnumHelperClient
/*    */   extends EnumHelper
/*    */ {
/* 15 */   private static Class[][] clentTypes = new Class[][] { { WorldSettings.GameType.class, int.class, String.class }, { GameSettings.Options.class, String.class, boolean.class, boolean.class }, { Util.EnumOS.class } };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static WorldSettings.GameType addGameType(String name, int id, String displayName) {
/* 24 */     return addEnum(WorldSettings.GameType.class, name, new Object[] { Integer.valueOf(id), displayName });
/*    */   }
/*    */ 
/*    */   
/*    */   public static GameSettings.Options addOptions(String name, String langName, boolean isSlider, boolean isToggle) {
/* 29 */     return addEnum(GameSettings.Options.class, name, new Object[] { langName, Boolean.valueOf(isSlider), Boolean.valueOf(isToggle) });
/*    */   }
/*    */ 
/*    */   
/*    */   public static Util.EnumOS addOS2(String name) {
/* 34 */     return addEnum(Util.EnumOS.class, name, new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public static <T extends Enum<?>> T addEnum(Class<T> enumType, String enumName, Object... paramValues) {
/* 39 */     return (T)addEnum(clentTypes, enumType, enumName, paramValues);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\EnumHelperClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */