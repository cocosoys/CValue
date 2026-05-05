/*     */ package cpw.mods.fml.client.registry;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.ObjectArrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.client.renderer.entity.RenderBiped;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.world.IBlockAccess;
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
/*     */ public class RenderingRegistry
/*     */ {
/*  36 */   private static final RenderingRegistry INSTANCE = new RenderingRegistry();
/*     */   
/*  38 */   private int nextRenderId = 42;
/*     */   
/*  40 */   private Map<Integer, ISimpleBlockRenderingHandler> blockRenderers = Maps.newHashMap();
/*     */   
/*  42 */   private List<EntityRendererInfo> entityRenderers = Lists.newArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int addNewArmourRendererPrefix(String armor) {
/*  51 */     RenderBiped.bipedArmorFilenamePrefix = (String[])ObjectArrays.concat((Object[])RenderBiped.bipedArmorFilenamePrefix, armor);
/*  52 */     return RenderBiped.bipedArmorFilenamePrefix.length - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerEntityRenderingHandler(Class<? extends Entity> entityClass, Render renderer) {
/*  64 */     (instance()).entityRenderers.add(new EntityRendererInfo(entityClass, renderer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerBlockHandler(ISimpleBlockRenderingHandler handler) {
/*  74 */     (instance()).blockRenderers.put(Integer.valueOf(handler.getRenderId()), handler);
/*     */   }
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
/*     */   public static void registerBlockHandler(int renderId, ISimpleBlockRenderingHandler handler) {
/*  87 */     (instance()).blockRenderers.put(Integer.valueOf(renderId), handler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getNextAvailableRenderId() {
/*  94 */     return (instance()).nextRenderId++;
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static RenderingRegistry instance() {
/* 100 */     return INSTANCE;
/*     */   }
/*     */   
/*     */   private static class EntityRendererInfo {
/*     */     private Class<? extends Entity> target;
/*     */     
/*     */     public EntityRendererInfo(Class<? extends Entity> target, Render renderer) {
/* 107 */       this.target = target;
/* 108 */       this.renderer = renderer;
/*     */     }
/*     */ 
/*     */     
/*     */     private Render renderer;
/*     */   }
/*     */   
/*     */   public boolean renderWorldBlock(RenderBlocks renderer, IBlockAccess world, int x, int y, int z, Block block, int modelId) {
/* 116 */     if (!this.blockRenderers.containsKey(Integer.valueOf(modelId))) return false; 
/* 117 */     ISimpleBlockRenderingHandler bri = this.blockRenderers.get(Integer.valueOf(modelId));
/* 118 */     return bri.renderWorldBlock(world, x, y, z, block, modelId, renderer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(RenderBlocks renderer, Block block, int metadata, int modelID) {
/* 123 */     if (!this.blockRenderers.containsKey(Integer.valueOf(modelID)))
/* 124 */       return;  ISimpleBlockRenderingHandler bri = this.blockRenderers.get(Integer.valueOf(modelID));
/* 125 */     bri.renderInventoryBlock(block, metadata, modelID, renderer);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderItemAsFull3DBlock(int modelId) {
/* 130 */     ISimpleBlockRenderingHandler bri = this.blockRenderers.get(Integer.valueOf(modelId));
/* 131 */     return (bri != null && bri.shouldRender3DInInventory(modelId));
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadEntityRenderers(Map<Class<? extends Entity>, Render> rendererMap) {
/* 136 */     for (EntityRendererInfo info : this.entityRenderers) {
/*     */       
/* 138 */       rendererMap.put(info.target, info.renderer);
/* 139 */       info.renderer.setRenderManager(RenderManager.instance);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\registry\RenderingRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */