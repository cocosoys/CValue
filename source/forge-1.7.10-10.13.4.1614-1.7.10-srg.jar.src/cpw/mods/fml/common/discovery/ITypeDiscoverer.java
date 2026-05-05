/*    */ package cpw.mods.fml.common.discovery;
/*    */ 
/*    */ import cpw.mods.fml.common.ModContainer;
/*    */ import java.util.List;
/*    */ import java.util.regex.Pattern;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface ITypeDiscoverer
/*    */ {
/* 23 */   public static final Pattern classFile = Pattern.compile("[^\\s\\$]+(\\$[^\\s]+)?\\.class$");
/*    */   
/*    */   List<ModContainer> discover(ModCandidate paramModCandidate, ASMDataTable paramASMDataTable);
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\discovery\ITypeDiscoverer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */