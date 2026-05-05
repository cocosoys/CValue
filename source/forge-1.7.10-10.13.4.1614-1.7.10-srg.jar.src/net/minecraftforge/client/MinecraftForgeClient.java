/*    */ package net.minecraftforge.client;
/*    */ 
/*    */ import com.google.common.collect.Maps;
/*    */ import java.util.BitSet;
/*    */ import java.util.IdentityHashMap;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MinecraftForgeClient
/*    */ {
/* 19 */   private static IdentityHashMap<Item, IItemRenderer> customItemRenderers = Maps.newIdentityHashMap();
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
/*    */   public static void registerItemRenderer(Item item, IItemRenderer renderer) {
/* 31 */     customItemRenderers.put(item, renderer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static IItemRenderer getItemRenderer(ItemStack item, IItemRenderer.ItemRenderType type) {
/* 36 */     IItemRenderer renderer = customItemRenderers.get(item.getItem());
/* 37 */     if (renderer != null && renderer.handleRenderType(item, type))
/*    */     {
/* 39 */       return renderer;
/*    */     }
/* 41 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getRenderPass() {
/* 46 */     return ForgeHooksClient.renderPass;
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getStencilBits() {
/* 51 */     return ForgeHooksClient.stencilBits;
/*    */   }
/*    */ 
/*    */   
/* 55 */   private static BitSet stencilBits = new BitSet(getStencilBits());
/*    */   
/*    */   static {
/* 58 */     stencilBits.set(0, getStencilBits());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int reserveStencilBit() {
/* 68 */     int bit = stencilBits.nextSetBit(0);
/* 69 */     if (bit >= 0)
/*    */     {
/* 71 */       stencilBits.clear(bit);
/*    */     }
/* 73 */     return bit;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void releaseStencilBit(int bit) {
/* 83 */     if (bit >= 0 && bit < getStencilBits())
/*    */     {
/* 85 */       stencilBits.set(bit);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\MinecraftForgeClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */