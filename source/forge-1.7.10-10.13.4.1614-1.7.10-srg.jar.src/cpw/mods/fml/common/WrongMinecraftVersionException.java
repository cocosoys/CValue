/*    */ package cpw.mods.fml.common;
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
/*    */ public class WrongMinecraftVersionException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public ModContainer mod;
/*    */   
/*    */   public WrongMinecraftVersionException(ModContainer mod) {
/* 22 */     this.mod = mod;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\WrongMinecraftVersionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */