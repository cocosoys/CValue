/*     */ package net.minecraftforge.client;
/*     */ 
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface IItemRenderer
/*     */ {
/*     */   boolean handleRenderType(ItemStack paramItemStack, ItemRenderType paramItemRenderType);
/*     */   
/*     */   boolean shouldUseRenderHelper(ItemRenderType paramItemRenderType, ItemStack paramItemStack, ItemRendererHelper paramItemRendererHelper);
/*     */   
/*     */   void renderItem(ItemRenderType paramItemRenderType, ItemStack paramItemStack, Object... paramVarArgs);
/*     */   
/*     */   public enum ItemRenderType
/*     */   {
/*  19 */     ENTITY,
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
/*  32 */     EQUIPPED,
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
/*  45 */     EQUIPPED_FIRST_PERSON,
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
/*  57 */     INVENTORY,
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
/*  69 */     FIRST_PERSON_MAP;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum ItemRendererHelper
/*     */   {
/*  78 */     ENTITY_ROTATION,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     ENTITY_BOBBING,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     EQUIPPED_BLOCK,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     BLOCK_3D,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     INVENTORY_BLOCK;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\IItemRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */