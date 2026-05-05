/*    */ package net.minecraftforge.client.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ 
/*    */ 
/*    */ public class TextureStitchEvent
/*    */   extends Event
/*    */ {
/*    */   public final TextureMap map;
/*    */   
/*    */   public TextureStitchEvent(TextureMap map) {
/* 13 */     this.map = map;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Pre
/*    */     extends TextureStitchEvent
/*    */   {
/*    */     public Pre(TextureMap map) {
/* 23 */       super(map);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Post
/*    */     extends TextureStitchEvent
/*    */   {
/*    */     public Post(TextureMap map) {
/* 33 */       super(map);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\TextureStitchEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */