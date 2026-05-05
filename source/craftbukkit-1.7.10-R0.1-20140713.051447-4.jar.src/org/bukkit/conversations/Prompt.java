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
/*    */ public interface Prompt
/*    */   extends Cloneable
/*    */ {
/* 15 */   public static final Prompt END_OF_CONVERSATION = null;
/*    */   
/*    */   String getPromptText(ConversationContext paramConversationContext);
/*    */   
/*    */   boolean blocksForInput(ConversationContext paramConversationContext);
/*    */   
/*    */   Prompt acceptInput(ConversationContext paramConversationContext, String paramString);
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\conversations\Prompt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */