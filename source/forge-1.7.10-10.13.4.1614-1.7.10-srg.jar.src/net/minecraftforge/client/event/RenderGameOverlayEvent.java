/*    */ package net.minecraftforge.client.event;
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ 
/*    */ @Cancelable
/*    */ public class RenderGameOverlayEvent extends Event {
/*    */   public final float partialTicks;
/*    */   public final ScaledResolution resolution;
/*    */   public final int mouseX;
/*    */   public final int mouseY;
/*    */   public final ElementType type;
/*    */   
/*    */   public enum ElementType {
/* 15 */     ALL,
/* 16 */     HELMET,
/* 17 */     PORTAL,
/* 18 */     CROSSHAIRS,
/* 19 */     BOSSHEALTH,
/* 20 */     ARMOR,
/* 21 */     HEALTH,
/* 22 */     FOOD,
/* 23 */     AIR,
/* 24 */     HOTBAR,
/* 25 */     EXPERIENCE,
/* 26 */     TEXT,
/* 27 */     HEALTHMOUNT,
/* 28 */     JUMPBAR,
/* 29 */     CHAT,
/* 30 */     PLAYER_LIST,
/* 31 */     DEBUG;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RenderGameOverlayEvent(float partialTicks, ScaledResolution resolution, int mouseX, int mouseY) {
/* 42 */     this.partialTicks = partialTicks;
/* 43 */     this.resolution = resolution;
/* 44 */     this.mouseX = mouseX;
/* 45 */     this.mouseY = mouseY;
/* 46 */     this.type = null;
/*    */   }
/*    */ 
/*    */   
/*    */   private RenderGameOverlayEvent(RenderGameOverlayEvent parent, ElementType type) {
/* 51 */     this.partialTicks = parent.partialTicks;
/* 52 */     this.resolution = parent.resolution;
/* 53 */     this.mouseX = parent.mouseX;
/* 54 */     this.mouseY = parent.mouseY;
/* 55 */     this.type = type;
/*    */   }
/*    */   
/*    */   public static class Pre
/*    */     extends RenderGameOverlayEvent
/*    */   {
/*    */     public Pre(RenderGameOverlayEvent parent, RenderGameOverlayEvent.ElementType type) {
/* 62 */       super(parent, type);
/*    */     }
/*    */   }
/*    */   
/*    */   public static class Post
/*    */     extends RenderGameOverlayEvent
/*    */   {
/*    */     public Post(RenderGameOverlayEvent parent, RenderGameOverlayEvent.ElementType type) {
/* 70 */       super(parent, type);
/*    */     } public boolean isCancelable() {
/* 72 */       return false;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class Text extends Pre {
/*    */     public final ArrayList<String> left;
/*    */     public final ArrayList<String> right;
/*    */     
/*    */     public Text(RenderGameOverlayEvent parent, ArrayList<String> left, ArrayList<String> right) {
/* 81 */       super(parent, RenderGameOverlayEvent.ElementType.TEXT);
/* 82 */       this.left = left;
/* 83 */       this.right = right;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class Chat
/*    */     extends Pre
/*    */   {
/*    */     public int posX;
/*    */     public int posY;
/*    */     
/*    */     public Chat(RenderGameOverlayEvent parent, int posX, int posY) {
/* 94 */       super(parent, RenderGameOverlayEvent.ElementType.CHAT);
/* 95 */       this.posX = posX;
/* 96 */       this.posY = posY;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\RenderGameOverlayEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */