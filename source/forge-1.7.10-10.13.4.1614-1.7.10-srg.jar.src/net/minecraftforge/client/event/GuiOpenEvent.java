/*    */ package net.minecraftforge.client.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Cancelable
/*    */ public class GuiOpenEvent
/*    */   extends Event
/*    */ {
/*    */   public GuiScreen gui;
/*    */   
/*    */   public GuiOpenEvent(GuiScreen gui) {
/* 20 */     this.gui = gui;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\GuiOpenEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */