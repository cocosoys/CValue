/*    */ package net.minecraftforge.client.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.client.renderer.WorldRenderer;
/*    */ import net.minecraft.world.ChunkCache;
/*    */ 
/*    */ public abstract class RenderWorldEvent
/*    */   extends Event
/*    */ {
/*    */   public final WorldRenderer renderer;
/*    */   public final ChunkCache chunkCache;
/*    */   public final RenderBlocks renderBlocks;
/*    */   public final int pass;
/*    */   
/*    */   public RenderWorldEvent(WorldRenderer renderer, ChunkCache chunkCache, RenderBlocks renderBlocks, int pass) {
/* 17 */     this.renderer = renderer;
/* 18 */     this.chunkCache = chunkCache;
/* 19 */     this.renderBlocks = renderBlocks;
/* 20 */     this.pass = pass;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Pre
/*    */     extends RenderWorldEvent
/*    */   {
/*    */     public Pre(WorldRenderer renderer, ChunkCache chunkCache, RenderBlocks renderBlocks, int pass) {
/* 29 */       super(renderer, chunkCache, renderBlocks, pass);
/*    */     }
/*    */   }
/*    */   
/*    */   public static class Post
/*    */     extends RenderWorldEvent
/*    */   {
/*    */     public Post(WorldRenderer renderer, ChunkCache chunkCache, RenderBlocks renderBlocks, int pass) {
/* 37 */       super(renderer, chunkCache, renderBlocks, pass);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\RenderWorldEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */