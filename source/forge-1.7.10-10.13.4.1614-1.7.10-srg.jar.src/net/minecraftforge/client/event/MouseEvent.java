/*    */ package net.minecraftforge.client.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import org.lwjgl.input.Mouse;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Cancelable
/*    */ public class MouseEvent
/*    */   extends Event
/*    */ {
/* 26 */   public final int x = Mouse.getEventX();
/* 27 */   public final int y = Mouse.getEventY();
/* 28 */   public final int dx = Mouse.getEventDX();
/* 29 */   public final int dy = Mouse.getEventDY();
/* 30 */   public final int dwheel = Mouse.getEventDWheel();
/* 31 */   public final int button = Mouse.getEventButton();
/* 32 */   public final boolean buttonstate = Mouse.getEventButtonState();
/* 33 */   public final long nanoseconds = Mouse.getEventNanoseconds();
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\MouseEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */