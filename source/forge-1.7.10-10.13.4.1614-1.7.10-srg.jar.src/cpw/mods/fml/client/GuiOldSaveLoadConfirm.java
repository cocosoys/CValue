/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import cpw.mods.fml.common.ObfuscationReflectionHelper;
/*    */ import cpw.mods.fml.common.StartupQuery;
/*    */ import cpw.mods.fml.common.ZipperUtil;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiLabel;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.gui.GuiSelectWorld;
/*    */ import net.minecraft.client.gui.GuiYesNo;
/*    */ import net.minecraft.client.gui.GuiYesNoCallback;
/*    */ import net.minecraft.world.WorldSettings;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ 
/*    */ public class GuiOldSaveLoadConfirm
/*    */   extends GuiYesNo
/*    */   implements GuiYesNoCallback
/*    */ {
/*    */   private String dirName;
/*    */   private String saveName;
/*    */   private File zip;
/*    */   private GuiScreen parent;
/*    */   
/*    */   public GuiOldSaveLoadConfirm(String dirName, String saveName, GuiScreen parent) {
/* 29 */     super(null, "", "", 0);
/* 30 */     this.parent = parent;
/* 31 */     this.dirName = dirName;
/* 32 */     this.saveName = saveName;
/* 33 */     this.zip = new File((FMLClientHandler.instance().getClient()).mcDataDir, String.format("%s-%2$td%2$tm%2$ty%2$tH%2$tM%2$tS.zip", new Object[] { dirName, Long.valueOf(System.currentTimeMillis()) }));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 42 */     drawDefaultBackground();
/* 43 */     drawCenteredString(this.fontRendererObj, String.format("The world %s contains pre-update modding data", new Object[] { this.saveName }), this.width / 2, 50, 16777215);
/* 44 */     drawCenteredString(this.fontRendererObj, String.format("There may be problems updating it to this version", new Object[0]), this.width / 2, 70, 16777215);
/* 45 */     drawCenteredString(this.fontRendererObj, String.format("FML will save a zip to %s", new Object[] { this.zip.getName() }), this.width / 2, 90, 16777215);
/* 46 */     drawCenteredString(this.fontRendererObj, String.format("Do you wish to continue loading?", new Object[0]), this.width / 2, 110, 16777215);
/*    */     
/*    */     int k;
/* 49 */     for (k = 0; k < this.buttonList.size(); k++)
/*    */     {
/* 51 */       ((GuiButton)this.buttonList.get(k)).drawButton(this.mc, p_73863_1_, p_73863_2_);
/*    */     }
/*    */     
/* 54 */     for (k = 0; k < this.labelList.size(); k++)
/*    */     {
/* 56 */       ((GuiLabel)this.labelList.get(k)).func_146159_a(this.mc, p_73863_1_, p_73863_2_);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected void actionPerformed(GuiButton p_146284_1_) {
/* 62 */     if (p_146284_1_.id == 1) {
/*    */       
/* 64 */       ObfuscationReflectionHelper.setPrivateValue(GuiSelectWorld.class, this.parentScreen, Boolean.valueOf(false), new String[] { "field_146634_i" });
/* 65 */       FMLClientHandler.instance().showGuiScreen(this.parent);
/*    */     }
/*    */     else {
/*    */       
/* 69 */       FMLLog.info("Capturing current state of world %s into file %s", new Object[] { this.saveName, this.zip.getAbsolutePath() });
/*    */       
/*    */       try {
/* 72 */         String skip = System.getProperty("fml.doNotBackup");
/* 73 */         if (skip == null || !"true".equals(skip)) {
/*    */           
/* 75 */           ZipperUtil.zip(new File(FMLClientHandler.instance().getSavesDir(), this.dirName), this.zip);
/*    */         }
/*    */         else {
/*    */           
/* 79 */           for (int x = 0; x < 10; x++)
/* 80 */             FMLLog.severe("!!!!!!!!!! UPDATING WORLD WITHOUT DOING BACKUP !!!!!!!!!!!!!!!!", new Object[0]); 
/*    */         } 
/* 82 */       } catch (IOException e) {
/*    */         
/* 84 */         FMLLog.log(Level.WARN, e, "There was a problem saving the backup %s. Please fix and try again", new Object[] { this.zip.getName() });
/* 85 */         FMLClientHandler.instance().showGuiScreen(new GuiBackupFailed(this.parent, this.zip));
/*    */         return;
/*    */       } 
/* 88 */       FMLClientHandler.instance().showGuiScreen(null);
/*    */ 
/*    */       
/*    */       try {
/* 92 */         this.mc.launchIntegratedServer(this.dirName, this.saveName, (WorldSettings)null);
/*    */       }
/* 94 */       catch (cpw.mods.fml.common.StartupQuery.AbortedException abortedException) {}
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\GuiOldSaveLoadConfirm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */