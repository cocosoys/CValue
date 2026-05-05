/*    */ package org.bukkit.conversations;
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
/*    */ public abstract class MessagePrompt
/*    */   implements Prompt
/*    */ {
/*    */   public boolean blocksForInput(ConversationContext context) {
/* 20 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Prompt acceptInput(ConversationContext context, String input) {
/* 32 */     return getNextPrompt(context);
/*    */   }
/*    */   
/*    */   protected abstract Prompt getNextPrompt(ConversationContext paramConversationContext);
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\conversations\MessagePrompt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */