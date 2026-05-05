/*     */ package cpw.mods.fml.client;
/*     */ 
/*     */ import com.google.common.base.Strings;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import javax.imageio.ImageIO;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.resources.IResourcePack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.logging.log4j.Level;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiModList
/*     */   extends GuiScreen
/*     */ {
/*     */   private GuiScreen mainMenu;
/*     */   private GuiSlotModList modList;
/*  54 */   private int selected = -1;
/*     */   
/*     */   private ModContainer selectedMod;
/*     */   
/*     */   private int listWidth;
/*     */   
/*     */   private ArrayList<ModContainer> mods;
/*     */   
/*     */   private GuiButton configModButton;
/*     */   private GuiButton disableModButton;
/*     */   private ResourceLocation cachedLogo;
/*     */   private Dimension cachedLogoDimensions;
/*     */   
/*     */   public GuiModList(GuiScreen mainMenu) {
/*  68 */     this.mainMenu = mainMenu;
/*  69 */     this.mods = new ArrayList<ModContainer>();
/*  70 */     FMLClientHandler.instance().addSpecialModEntries(this.mods);
/*  71 */     for (ModContainer mod : Loader.instance().getModList()) {
/*  72 */       if (mod.getMetadata() != null && (mod.getMetadata()).parentMod == null && !Strings.isNullOrEmpty((mod.getMetadata()).parent)) {
/*  73 */         String parentMod = (mod.getMetadata()).parent;
/*  74 */         ModContainer parentContainer = (ModContainer)Loader.instance().getIndexedModList().get(parentMod);
/*  75 */         if (parentContainer != null) {
/*     */           
/*  77 */           (mod.getMetadata()).parentMod = parentContainer;
/*  78 */           (parentContainer.getMetadata()).childMods.add(mod);
/*     */           
/*     */           continue;
/*     */         } 
/*  82 */       } else if (mod.getMetadata() != null && (mod.getMetadata()).parentMod != null) {
/*     */         continue;
/*     */       } 
/*     */       
/*  86 */       this.mods.add(mod);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  97 */     for (ModContainer mod : this.mods) {
/*  98 */       this.listWidth = Math.max(this.listWidth, getFontRenderer().getStringWidth(mod.getName()) + 10);
/*  99 */       this.listWidth = Math.max(this.listWidth, getFontRenderer().getStringWidth(mod.getVersion()) + 10);
/*     */     } 
/* 101 */     this.listWidth = Math.min(this.listWidth, 150);
/* 102 */     this.buttonList.add(new GuiButton(6, this.width / 2 - 75, this.height - 38, I18n.format("gui.done", new Object[0])));
/* 103 */     this.configModButton = new GuiButton(20, 10, this.height - 60, this.listWidth, 20, "Config");
/* 104 */     this.disableModButton = new GuiButton(21, 10, this.height - 38, this.listWidth, 20, "Disable");
/* 105 */     this.buttonList.add(this.configModButton);
/* 106 */     this.buttonList.add(this.disableModButton);
/* 107 */     this.modList = new GuiSlotModList(this, this.mods, this.listWidth);
/* 108 */     this.modList.registerScrollButtons(this.buttonList, 7, 8);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void actionPerformed(GuiButton button) {
/* 113 */     if (button.enabled)
/*     */     {
/* 115 */       switch (button.id) {
/*     */         
/*     */         case 6:
/* 118 */           this.mc.displayGuiScreen(this.mainMenu);
/*     */           return;
/*     */         
/*     */         case 20:
/*     */           try {
/* 123 */             IModGuiFactory guiFactory = FMLClientHandler.instance().getGuiFactoryFor(this.selectedMod);
/* 124 */             GuiScreen newScreen = guiFactory.mainConfigGuiClass().getConstructor(new Class[] { GuiScreen.class }).newInstance(new Object[] { this });
/* 125 */             this.mc.displayGuiScreen(newScreen);
/*     */           }
/* 127 */           catch (Exception e) {
/*     */             
/* 129 */             FMLLog.log(Level.ERROR, e, "There was a critical issue trying to build the config GUI for %s", new Object[] { this.selectedMod.getModId() });
/*     */           } 
/*     */           return;
/*     */       } 
/*     */     }
/* 134 */     super.actionPerformed(button);
/*     */   }
/*     */ 
/*     */   
/*     */   public int drawLine(String line, int offset, int shifty) {
/* 139 */     this.fontRendererObj.drawString(line, offset, shifty, 14151146);
/* 140 */     return shifty + 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int p_571_1_, int p_571_2_, float p_571_3_) {
/* 149 */     this.modList.drawScreen(p_571_1_, p_571_2_, p_571_3_);
/* 150 */     drawCenteredString(this.fontRendererObj, "Mod List", this.width / 2, 16, 16777215);
/* 151 */     int offset = this.listWidth + 20;
/* 152 */     if (this.selectedMod != null) {
/* 153 */       GL11.glEnable(3042);
/* 154 */       if (!(this.selectedMod.getMetadata()).autogenerated) {
/* 155 */         this.configModButton.visible = true;
/* 156 */         this.disableModButton.visible = true;
/* 157 */         this.disableModButton.packedFGColour = 16724855;
/* 158 */         this.configModButton.enabled = false;
/* 159 */         int shifty = 35;
/* 160 */         String logoFile = (this.selectedMod.getMetadata()).logoFile;
/* 161 */         if (!logoFile.isEmpty()) {
/*     */           
/* 163 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 164 */           TextureManager tm = this.mc.getTextureManager();
/* 165 */           IResourcePack pack = FMLClientHandler.instance().getResourcePackFor(this.selectedMod.getModId());
/*     */           
/*     */           try {
/* 168 */             if (this.cachedLogo == null) {
/*     */               
/* 170 */               BufferedImage logo = null;
/* 171 */               if (pack != null) {
/*     */                 
/* 173 */                 logo = pack.getPackImage();
/*     */               }
/*     */               else {
/*     */                 
/* 177 */                 InputStream logoResource = getClass().getResourceAsStream(logoFile);
/* 178 */                 if (logoResource != null)
/*     */                 {
/* 180 */                   logo = ImageIO.read(logoResource);
/*     */                 }
/*     */               } 
/* 183 */               if (logo != null) {
/*     */                 
/* 185 */                 this.cachedLogo = tm.getDynamicTextureLocation("modlogo", new DynamicTexture(logo));
/* 186 */                 this.cachedLogoDimensions = new Dimension(logo.getWidth(), logo.getHeight());
/*     */               } 
/*     */             } 
/* 189 */             if (this.cachedLogo != null)
/*     */             {
/* 191 */               this.mc.renderEngine.bindTexture(this.cachedLogo);
/* 192 */               double scaleX = this.cachedLogoDimensions.width / 200.0D;
/* 193 */               double scaleY = this.cachedLogoDimensions.height / 65.0D;
/* 194 */               double scale = 1.0D;
/* 195 */               if (scaleX > 1.0D || scaleY > 1.0D)
/*     */               {
/* 197 */                 scale = 1.0D / Math.max(scaleX, scaleY);
/*     */               }
/* 199 */               this.cachedLogoDimensions.width = (int)(this.cachedLogoDimensions.width * scale);
/* 200 */               this.cachedLogoDimensions.height = (int)(this.cachedLogoDimensions.height * scale);
/* 201 */               int top = 32;
/* 202 */               Tessellator tess = Tessellator.instance;
/* 203 */               tess.startDrawingQuads();
/* 204 */               tess.addVertexWithUV(offset, (top + this.cachedLogoDimensions.height), this.zLevel, 0.0D, 1.0D);
/* 205 */               tess.addVertexWithUV((offset + this.cachedLogoDimensions.width), (top + this.cachedLogoDimensions.height), this.zLevel, 1.0D, 1.0D);
/* 206 */               tess.addVertexWithUV((offset + this.cachedLogoDimensions.width), top, this.zLevel, 1.0D, 0.0D);
/* 207 */               tess.addVertexWithUV(offset, top, this.zLevel, 0.0D, 0.0D);
/* 208 */               tess.draw();
/*     */               
/* 210 */               shifty += 65;
/*     */             }
/*     */           
/* 213 */           } catch (IOException iOException) {}
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 218 */         this.fontRendererObj.drawStringWithShadow((this.selectedMod.getMetadata()).name, offset, shifty, 16777215);
/* 219 */         shifty += 12;
/*     */         
/* 221 */         shifty = drawLine(String.format("Version: %s (%s)", new Object[] { this.selectedMod.getDisplayVersion(), this.selectedMod.getVersion() }), offset, shifty);
/* 222 */         shifty = drawLine(String.format("Mod ID: '%s' Mod State: %s", new Object[] { this.selectedMod.getModId(), Loader.instance().getModState(this.selectedMod) }), offset, shifty);
/* 223 */         if (!(this.selectedMod.getMetadata()).credits.isEmpty()) {
/* 224 */           shifty = drawLine(String.format("Credits: %s", new Object[] { (this.selectedMod.getMetadata()).credits }), offset, shifty);
/*     */         }
/* 226 */         shifty = drawLine(String.format("Authors: %s", new Object[] { this.selectedMod.getMetadata().getAuthorList() }), offset, shifty);
/* 227 */         shifty = drawLine(String.format("URL: %s", new Object[] { (this.selectedMod.getMetadata()).url }), offset, shifty);
/* 228 */         shifty = drawLine((this.selectedMod.getMetadata()).childMods.isEmpty() ? "No child mods for this mod" : String.format("Child mods: %s", new Object[] { this.selectedMod.getMetadata().getChildModList() }), offset, shifty);
/* 229 */         int rightSide = this.width - offset - 20;
/* 230 */         if (rightSide > 20)
/*     */         {
/* 232 */           getFontRenderer().drawSplitString((this.selectedMod.getMetadata()).description, offset, shifty + 10, rightSide, 14540253);
/*     */         }
/* 234 */         ModContainer.Disableable disableable = this.selectedMod.canBeDisabled();
/* 235 */         if (disableable == ModContainer.Disableable.RESTART) {
/*     */           
/* 237 */           this.disableModButton.enabled = true;
/* 238 */           this.disableModButton.visible = true;
/* 239 */           this.disableModButton.packedFGColour = 16724855;
/*     */         }
/* 241 */         else if (disableable == ModContainer.Disableable.YES) {
/*     */           
/* 243 */           this.disableModButton.enabled = true;
/* 244 */           this.disableModButton.visible = true;
/* 245 */           this.disableModButton.packedFGColour = 0;
/*     */         }
/*     */         else {
/*     */           
/* 249 */           this.disableModButton.packedFGColour = 0;
/* 250 */           this.disableModButton.visible = true;
/* 251 */           this.disableModButton.enabled = false;
/*     */         } 
/* 253 */         IModGuiFactory guiFactory = FMLClientHandler.instance().getGuiFactoryFor(this.selectedMod);
/* 254 */         if (guiFactory == null || guiFactory.mainConfigGuiClass() == null) {
/*     */           
/* 256 */           this.configModButton.visible = true;
/* 257 */           this.configModButton.enabled = false;
/*     */         }
/*     */         else {
/*     */           
/* 261 */           this.configModButton.visible = true;
/* 262 */           this.configModButton.enabled = true;
/*     */         } 
/*     */       } else {
/* 265 */         offset = (this.listWidth + this.width) / 2;
/* 266 */         drawCenteredString(this.fontRendererObj, this.selectedMod.getName(), offset, 35, 16777215);
/* 267 */         drawCenteredString(this.fontRendererObj, String.format("Version: %s", new Object[] { this.selectedMod.getVersion() }), offset, 45, 16777215);
/* 268 */         drawCenteredString(this.fontRendererObj, String.format("Mod State: %s", new Object[] { Loader.instance().getModState(this.selectedMod) }), offset, 55, 16777215);
/* 269 */         drawCenteredString(this.fontRendererObj, "No mod information found", offset, 65, 14540253);
/* 270 */         drawCenteredString(this.fontRendererObj, "Ask your mod author to provide a mod mcmod.info file", offset, 75, 14540253);
/* 271 */         this.configModButton.visible = false;
/* 272 */         this.disableModButton.visible = false;
/*     */       } 
/* 274 */       GL11.glDisable(3042);
/*     */     }
/*     */     else {
/*     */       
/* 278 */       this.configModButton.visible = false;
/* 279 */       this.disableModButton.visible = false;
/*     */     } 
/* 281 */     super.drawScreen(p_571_1_, p_571_2_, p_571_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   Minecraft getMinecraftInstance() {
/* 286 */     return this.mc;
/*     */   }
/*     */ 
/*     */   
/*     */   FontRenderer getFontRenderer() {
/* 291 */     return this.fontRendererObj;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void selectModIndex(int var1) {
/* 299 */     this.selected = var1;
/* 300 */     if (var1 >= 0 && var1 <= this.mods.size()) {
/* 301 */       this.selectedMod = this.mods.get(this.selected);
/*     */     } else {
/* 303 */       this.selectedMod = null;
/*     */     } 
/* 305 */     this.cachedLogo = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean modIndexSelected(int var1) {
/* 310 */     return (var1 == this.selected);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\GuiModList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */