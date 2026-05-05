/*     */ package net.minecraftforge.client;
/*     */ 
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import cpw.mods.fml.client.registry.RenderingRegistry;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import java.util.Random;
/*     */ import javax.imageio.ImageIO;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockLiquid;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.audio.ISound;
/*     */ import net.minecraft.client.audio.SoundEventAccessorComposite;
/*     */ import net.minecraft.client.audio.SoundManager;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiMainMenu;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.RenderGlobal;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.ChunkCache;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraftforge.client.event.DrawBlockHighlightEvent;
/*     */ import net.minecraftforge.client.event.FOVUpdateEvent;
/*     */ import net.minecraftforge.client.event.MouseEvent;
/*     */ import net.minecraftforge.client.event.RenderHandEvent;
/*     */ import net.minecraftforge.client.event.RenderWorldEvent;
/*     */ import net.minecraftforge.client.event.RenderWorldLastEvent;
/*     */ import net.minecraftforge.client.event.TextureStitchEvent;
/*     */ import net.minecraftforge.client.event.sound.PlaySoundEvent17;
/*     */ import net.minecraftforge.common.ForgeModContainer;
/*     */ import net.minecraftforge.common.ForgeVersion;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.fluids.FluidRegistry;
/*     */ import net.minecraftforge.fluids.RenderBlockFluid;
/*     */ import org.lwjgl.LWJGLException;
/*     */ import org.lwjgl.opengl.Display;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.PixelFormat;
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
/*     */ public class ForgeHooksClient
/*     */ {
/*     */   static TextureManager engine() {
/*  75 */     return (FMLClientHandler.instance().getClient()).renderEngine;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getArmorTexture(Entity entity, ItemStack armor, String _default, int slot, String type) {
/*  80 */     String result = armor.getItem().getArmorTexture(armor, entity, slot, type);
/*  81 */     return (result != null) ? result : _default;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean renderEntityItem(EntityItem entity, ItemStack item, float bobing, float rotation, Random random, TextureManager engine, RenderBlocks renderBlocks, int count) {
/*  86 */     IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(item, IItemRenderer.ItemRenderType.ENTITY);
/*  87 */     if (customRenderer == null)
/*     */     {
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     if (customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.ENTITY, item, IItemRenderer.ItemRendererHelper.ENTITY_ROTATION))
/*     */     {
/*  94 */       GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
/*     */     }
/*  96 */     if (!customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.ENTITY, item, IItemRenderer.ItemRendererHelper.ENTITY_BOBBING))
/*     */     {
/*  98 */       GL11.glTranslatef(0.0F, -bobing, 0.0F);
/*     */     }
/* 100 */     boolean is3D = customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.ENTITY, item, IItemRenderer.ItemRendererHelper.BLOCK_3D);
/*     */     
/* 102 */     engine.bindTexture((item.getItemSpriteNumber() == 0) ? TextureMap.locationBlocksTexture : TextureMap.locationItemsTexture);
/* 103 */     Block block = (item.getItem() instanceof net.minecraft.item.ItemBlock) ? Block.getBlockFromItem(item.getItem()) : null;
/* 104 */     if (is3D || (block != null && RenderBlocks.renderItemIn3d(block.getRenderType()))) {
/*     */       
/* 106 */       int renderType = (block != null) ? block.getRenderType() : 1;
/* 107 */       float scale = (renderType == 1 || renderType == 19 || renderType == 12 || renderType == 2) ? 0.5F : 0.25F;
/* 108 */       boolean blend = (block != null && block.getRenderBlockPass() > 0);
/*     */       
/* 110 */       if (RenderItem.renderInFrame) {
/*     */         
/* 112 */         GL11.glScalef(1.25F, 1.25F, 1.25F);
/* 113 */         GL11.glTranslatef(0.0F, 0.05F, 0.0F);
/* 114 */         GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
/*     */       } 
/*     */       
/* 117 */       if (blend) {
/*     */         
/* 119 */         GL11.glAlphaFunc(516, 0.1F);
/* 120 */         GL11.glEnable(3042);
/* 121 */         OpenGlHelper.glBlendFunc(770, 771, 1, 0);
/*     */       } 
/*     */       
/* 124 */       GL11.glScalef(scale, scale, scale);
/*     */       
/* 126 */       for (int j = 0; j < count; j++) {
/*     */         
/* 128 */         GL11.glPushMatrix();
/* 129 */         if (j > 0)
/*     */         {
/* 131 */           GL11.glTranslatef((random
/* 132 */               .nextFloat() * 2.0F - 1.0F) * 0.2F / scale, (random
/* 133 */               .nextFloat() * 2.0F - 1.0F) * 0.2F / scale, (random
/* 134 */               .nextFloat() * 2.0F - 1.0F) * 0.2F / scale);
/*     */         }
/* 136 */         customRenderer.renderItem(IItemRenderer.ItemRenderType.ENTITY, item, new Object[] { renderBlocks, entity });
/* 137 */         GL11.glPopMatrix();
/*     */       } 
/*     */       
/* 140 */       if (blend)
/*     */       {
/* 142 */         GL11.glDisable(3042);
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 147 */       GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 148 */       customRenderer.renderItem(IItemRenderer.ItemRenderType.ENTITY, item, new Object[] { renderBlocks, entity });
/*     */     } 
/* 150 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean renderInventoryItem(RenderBlocks renderBlocks, TextureManager engine, ItemStack item, boolean inColor, float zLevel, float x, float y) {
/* 155 */     IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(item, IItemRenderer.ItemRenderType.INVENTORY);
/* 156 */     if (customRenderer == null)
/*     */     {
/* 158 */       return false;
/*     */     }
/*     */     
/* 161 */     engine.bindTexture((item.getItemSpriteNumber() == 0) ? TextureMap.locationBlocksTexture : TextureMap.locationItemsTexture);
/* 162 */     if (customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.INVENTORY, item, IItemRenderer.ItemRendererHelper.INVENTORY_BLOCK)) {
/*     */       
/* 164 */       GL11.glPushMatrix();
/* 165 */       GL11.glTranslatef(x - 2.0F, y + 3.0F, -3.0F + zLevel);
/* 166 */       GL11.glScalef(10.0F, 10.0F, 10.0F);
/* 167 */       GL11.glTranslatef(1.0F, 0.5F, 1.0F);
/* 168 */       GL11.glScalef(1.0F, 1.0F, -1.0F);
/* 169 */       GL11.glRotatef(210.0F, 1.0F, 0.0F, 0.0F);
/* 170 */       GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/*     */       
/* 172 */       if (inColor) {
/*     */         
/* 174 */         int color = item.getItem().getColorFromItemStack(item, 0);
/* 175 */         float r = (color >> 16 & 0xFF) / 255.0F;
/* 176 */         float g = (color >> 8 & 0xFF) / 255.0F;
/* 177 */         float b = (color & 0xFF) / 255.0F;
/* 178 */         GL11.glColor4f(r, g, b, 1.0F);
/*     */       } 
/*     */       
/* 181 */       GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
/* 182 */       renderBlocks.useInventoryTint = inColor;
/* 183 */       customRenderer.renderItem(IItemRenderer.ItemRenderType.INVENTORY, item, new Object[] { renderBlocks });
/* 184 */       renderBlocks.useInventoryTint = true;
/* 185 */       GL11.glPopMatrix();
/*     */     }
/*     */     else {
/*     */       
/* 189 */       GL11.glDisable(2896);
/* 190 */       GL11.glPushMatrix();
/* 191 */       GL11.glTranslatef(x, y, -3.0F + zLevel);
/*     */       
/* 193 */       if (inColor) {
/*     */         
/* 195 */         int color = item.getItem().getColorFromItemStack(item, 0);
/* 196 */         float r = (color >> 16 & 0xFF) / 255.0F;
/* 197 */         float g = (color >> 8 & 0xFF) / 255.0F;
/* 198 */         float b = (color & 0xFF) / 255.0F;
/* 199 */         GL11.glColor4f(r, g, b, 1.0F);
/*     */       } 
/*     */       
/* 202 */       customRenderer.renderItem(IItemRenderer.ItemRenderType.INVENTORY, item, new Object[] { renderBlocks });
/* 203 */       GL11.glPopMatrix();
/* 204 */       GL11.glEnable(2896);
/*     */     } 
/*     */     
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderEffectOverlay(TextureManager manager, RenderItem render) {}
/*     */ 
/*     */   
/*     */   public static void renderEquippedItem(IItemRenderer.ItemRenderType type, IItemRenderer customRenderer, RenderBlocks renderBlocks, EntityLivingBase entity, ItemStack item) {
/* 216 */     if (customRenderer.shouldUseRenderHelper(type, item, IItemRenderer.ItemRendererHelper.EQUIPPED_BLOCK)) {
/*     */       
/* 218 */       GL11.glPushMatrix();
/* 219 */       GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 220 */       customRenderer.renderItem(type, item, new Object[] { renderBlocks, entity });
/* 221 */       GL11.glPopMatrix();
/*     */     }
/*     */     else {
/*     */       
/* 225 */       GL11.glPushMatrix();
/* 226 */       GL11.glEnable(32826);
/* 227 */       GL11.glTranslatef(0.0F, -0.3F, 0.0F);
/* 228 */       GL11.glScalef(1.5F, 1.5F, 1.5F);
/* 229 */       GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
/* 230 */       GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
/* 231 */       GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
/* 232 */       customRenderer.renderItem(type, item, new Object[] { renderBlocks, entity });
/* 233 */       GL11.glDisable(32826);
/* 234 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void orientBedCamera(Minecraft mc, EntityLivingBase entity) {
/* 243 */     int x = MathHelper.floor_double(entity.posX);
/* 244 */     int y = MathHelper.floor_double(entity.posY);
/* 245 */     int z = MathHelper.floor_double(entity.posZ);
/* 246 */     Block block = mc.theWorld.getBlock(x, y, z);
/*     */     
/* 248 */     if (block != null && block.isBed((IBlockAccess)mc.theWorld, x, y, z, entity))
/*     */     {
/* 250 */       GL11.glRotatef((block.getBedDirection((IBlockAccess)mc.theWorld, x, y, z) * 90), 0.0F, 1.0F, 0.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean onDrawBlockHighlight(RenderGlobal context, EntityPlayer player, MovingObjectPosition target, int subID, ItemStack currentItem, float partialTicks) {
/* 256 */     return MinecraftForge.EVENT_BUS.post((Event)new DrawBlockHighlightEvent(context, player, target, subID, currentItem, partialTicks));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void dispatchRenderLast(RenderGlobal context, float partialTicks) {
/* 261 */     MinecraftForge.EVENT_BUS.post((Event)new RenderWorldLastEvent(context, partialTicks));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean renderFirstPersonHand(RenderGlobal context, float partialTicks, int renderPass) {
/* 266 */     return MinecraftForge.EVENT_BUS.post((Event)new RenderHandEvent(context, partialTicks, renderPass));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onTextureStitchedPre(TextureMap map) {
/* 271 */     MinecraftForge.EVENT_BUS.post((Event)new TextureStitchEvent.Pre(map));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onTextureStitchedPost(TextureMap map) {
/* 276 */     MinecraftForge.EVENT_BUS.post((Event)new TextureStitchEvent.Post(map));
/*     */     
/* 278 */     FluidRegistry.WATER.setIcons(BlockLiquid.getLiquidIcon("water_still"), BlockLiquid.getLiquidIcon("water_flow"));
/* 279 */     FluidRegistry.LAVA.setIcons(BlockLiquid.getLiquidIcon("lava_still"), BlockLiquid.getLiquidIcon("lava_flow"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void onTextureLoadPre(String texture) {
/* 288 */     if (Tessellator.renderingWorldRenderer) {
/*     */       
/* 290 */       FMLLog.warning("Warning: Texture %s not preloaded, will cause render glitches!", new Object[] { texture });
/* 291 */       if (Tessellator.class.getPackage() != null)
/*     */       {
/* 293 */         if (Tessellator.class.getPackage().getName().startsWith("net.minecraft.")) {
/*     */           
/* 295 */           Minecraft mc = FMLClientHandler.instance().getClient();
/* 296 */           if (mc.ingameGUI != null)
/*     */           {
/* 298 */             mc.ingameGUI.getChatGUI().printChatMessage((IChatComponent)new ChatComponentTranslation("forge.texture.preload.warning", new Object[] { texture }));
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/* 305 */   static int renderPass = -1;
/*     */   
/*     */   public static void setRenderPass(int pass) {
/* 308 */     renderPass = pass;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int slotID, ModelBiped _default) {
/* 313 */     ModelBiped modelbiped = itemStack.getItem().getArmorModel(entityLiving, itemStack, slotID);
/* 314 */     return (modelbiped == null) ? _default : modelbiped;
/*     */   }
/*     */   private static int skyX; private static int skyZ;
/* 317 */   static int stencilBits = 0; private static boolean skyInit;
/*     */   
/*     */   public static void createDisplay() throws LWJGLException {
/* 320 */     ImageIO.setUseCache(false);
/* 321 */     PixelFormat format = (new PixelFormat()).withDepthBits(24);
/* 322 */     if (!Boolean.parseBoolean(System.getProperty("forge.forceDisplayStencil", "false"))) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 327 */       Display.create(format);
/* 328 */       stencilBits = 0;
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     try {
/* 334 */       Display.create(format.withStencilBits(8));
/* 335 */       stencilBits = 8;
/*     */     }
/* 337 */     catch (LWJGLException e) {
/*     */       
/* 339 */       Display.create(format);
/* 340 */       stencilBits = 0;
/*     */     } 
/*     */   }
/*     */   private static int skyRGBMultiplier; static RenderBlocks worldRendererRB;
/*     */   static int worldRenderPass;
/*     */   
/*     */   public static String fixDomain(String base, String complex) {
/* 347 */     int idx = complex.indexOf(':');
/* 348 */     if (idx == -1)
/*     */     {
/* 350 */       return base + complex;
/*     */     }
/*     */     
/* 353 */     String name = complex.substring(idx + 1, complex.length());
/* 354 */     if (idx > 1) {
/*     */       
/* 356 */       String domain = complex.substring(0, idx);
/* 357 */       return domain + ':' + base + name;
/*     */     } 
/*     */ 
/*     */     
/* 361 */     return base + name;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean postMouseEvent() {
/* 367 */     return MinecraftForge.EVENT_BUS.post((Event)new MouseEvent());
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getOffsetFOV(EntityPlayerSP entity, float fov) {
/* 372 */     FOVUpdateEvent fovUpdateEvent = new FOVUpdateEvent(entity, fov);
/* 373 */     MinecraftForge.EVENT_BUS.post((Event)fovUpdateEvent);
/* 374 */     return fovUpdateEvent.newfov;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getSkyBlendColour(World world, int playerX, int playerY, int playerZ) {
/* 384 */     if (playerX == skyX && playerZ == skyZ && skyInit)
/*     */     {
/* 386 */       return skyRGBMultiplier;
/*     */     }
/* 388 */     skyInit = true;
/*     */     
/* 390 */     GameSettings settings = (Minecraft.getMinecraft()).gameSettings;
/* 391 */     int[] ranges = ForgeModContainer.blendRanges;
/* 392 */     int distance = 0;
/* 393 */     if (settings.fancyGraphics && settings.renderDistanceChunks >= 0 && settings.renderDistanceChunks < ranges.length)
/*     */     {
/* 395 */       distance = ranges[settings.renderDistanceChunks];
/*     */     }
/*     */     
/* 398 */     int r = 0;
/* 399 */     int g = 0;
/* 400 */     int b = 0;
/*     */     
/* 402 */     int divider = 0;
/* 403 */     for (int x = -distance; x <= distance; x++) {
/*     */       
/* 405 */       for (int z = -distance; z <= distance; z++) {
/*     */         
/* 407 */         BiomeGenBase biome = world.getBiomeGenForCoords(playerX + x, playerZ + z);
/* 408 */         int colour = biome.getSkyColorByTemp(biome.getFloatTemperature(playerX + x, playerY, playerZ + z));
/* 409 */         r += (colour & 0xFF0000) >> 16;
/* 410 */         g += (colour & 0xFF00) >> 8;
/* 411 */         b += colour & 0xFF;
/* 412 */         divider++;
/*     */       } 
/*     */     } 
/*     */     
/* 416 */     int multiplier = (r / divider & 0xFF) << 16 | (g / divider & 0xFF) << 8 | b / divider & 0xFF;
/*     */     
/* 418 */     skyX = playerX;
/* 419 */     skyZ = playerZ;
/* 420 */     skyRGBMultiplier = multiplier;
/* 421 */     return skyRGBMultiplier;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 428 */     FluidRegistry.renderIdFluid = RenderingRegistry.getNextAvailableRenderId();
/* 429 */     RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)RenderBlockFluid.instance);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderMainMenu(GuiMainMenu gui, FontRenderer font, int width, int height) {
/* 434 */     ForgeVersion.Status status = ForgeVersion.getStatus();
/* 435 */     if (status == ForgeVersion.Status.BETA || status == ForgeVersion.Status.BETA_OUTDATED) {
/*     */ 
/*     */       
/* 438 */       String str = I18n.format("forge.update.beta.1", new Object[] { EnumChatFormatting.RED, EnumChatFormatting.RESET });
/* 439 */       gui.drawString(font, str, (width - font.getStringWidth(str)) / 2, 4 + 0 * (font.FONT_HEIGHT + 1), -1);
/* 440 */       str = I18n.format("forge.update.beta.2", new Object[0]);
/* 441 */       gui.drawString(font, str, (width - font.getStringWidth(str)) / 2, 4 + 1 * (font.FONT_HEIGHT + 1), -1);
/*     */     } 
/*     */     
/* 444 */     String line = null;
/* 445 */     switch (status) {
/*     */ 
/*     */ 
/*     */       
/*     */       case OUTDATED:
/*     */       case BETA_OUTDATED:
/* 451 */         line = I18n.format("forge.update.newversion", new Object[] { ForgeVersion.getTarget() });
/*     */         break;
/*     */     } 
/*     */     
/* 455 */     if (line != null)
/*     */     {
/*     */       
/* 458 */       gui.drawString(font, line, width - font.getStringWidth(line) - 2, height - 2 * (font.FONT_HEIGHT + 1), -1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static ISound playSound(SoundManager manager, ISound sound) {
/* 464 */     SoundEventAccessorComposite accessor = manager.sndHandler.getSound(sound.getPositionedSoundLocation());
/* 465 */     PlaySoundEvent17 e = new PlaySoundEvent17(manager, sound, (accessor == null) ? null : accessor.getSoundCategory());
/* 466 */     MinecraftForge.EVENT_BUS.post((Event)e);
/* 467 */     return e.result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getWorldRenderPass() {
/* 475 */     return worldRenderPass;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setWorldRendererRB(RenderBlocks renderBlocks) {
/* 480 */     worldRendererRB = renderBlocks;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPreRenderWorld(WorldRenderer worldRenderer, int pass) {
/* 485 */     if (worldRendererRB != null) {
/*     */       
/* 487 */       worldRenderPass = pass;
/* 488 */       MinecraftForge.EVENT_BUS.post((Event)new RenderWorldEvent.Pre(worldRenderer, (ChunkCache)worldRendererRB.blockAccess, worldRendererRB, pass));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPostRenderWorld(WorldRenderer worldRenderer, int pass) {
/* 494 */     if (worldRendererRB != null) {
/*     */       
/* 496 */       MinecraftForge.EVENT_BUS.post((Event)new RenderWorldEvent.Post(worldRenderer, (ChunkCache)worldRendererRB.blockAccess, worldRendererRB, pass));
/* 497 */       worldRenderPass = -1;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\ForgeHooksClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */