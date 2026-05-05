/*   */ package net.minecraft.client.resources;
/*   */ import java.io.File;
/*   */ import java.io.FileNotFoundException;
/*   */ 
/*   */ @SideOnly(Side.CLIENT)
/*   */ public class ResourcePackFileNotFoundException extends FileNotFoundException {
/*   */   public ResourcePackFileNotFoundException(File p_i1294_1_, String p_i1294_2_) {
/* 8 */     super(String.format("'%s' in ResourcePack '%s'", new Object[] { p_i1294_2_, p_i1294_1_ }));
/*   */   }
/*   */   
/*   */   private static final String __OBFID = "CL_00001086";
/*   */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\ResourcePackFileNotFoundException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */