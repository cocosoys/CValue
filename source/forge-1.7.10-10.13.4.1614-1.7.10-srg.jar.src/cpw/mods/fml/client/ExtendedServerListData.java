/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import java.util.Map;
/*    */ 
/*    */ public class ExtendedServerListData
/*    */ {
/*    */   public final String type;
/*    */   public final boolean isCompatible;
/*    */   public final Map<String, String> modData;
/*    */   public final boolean isBlocked;
/*    */   
/*    */   public ExtendedServerListData(String type, boolean isCompatible, Map<String, String> modData, boolean isBlocked) {
/* 13 */     this.type = type;
/* 14 */     this.isCompatible = isCompatible;
/* 15 */     this.modData = modData;
/* 16 */     this.isBlocked = isBlocked;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\ExtendedServerListData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */