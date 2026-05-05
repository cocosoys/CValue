/*    */ package net.minecraftforge.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Cancelable
/*    */ public class CommandEvent
/*    */   extends Event
/*    */ {
/*    */   public final ICommand command;
/*    */   public final ICommandSender sender;
/*    */   public String[] parameters;
/*    */   public Throwable exception;
/*    */   
/*    */   public CommandEvent(ICommand command, ICommandSender sender, String[] parameters) {
/* 36 */     this.command = command;
/* 37 */     this.sender = sender;
/* 38 */     this.parameters = parameters;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\CommandEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */