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
/*    */ public class ExactMatchConversationCanceller
/*    */   implements ConversationCanceller
/*    */ {
/*    */   private String escapeSequence;
/*    */   
/*    */   public ExactMatchConversationCanceller(String escapeSequence) {
/* 17 */     this.escapeSequence = escapeSequence;
/*    */   }
/*    */   
/*    */   public void setConversation(Conversation conversation) {}
/*    */   
/*    */   public boolean cancelBasedOnInput(ConversationContext context, String input) {
/* 23 */     return input.equals(this.escapeSequence);
/*    */   }
/*    */   
/*    */   public ConversationCanceller clone() {
/* 27 */     return new ExactMatchConversationCanceller(this.escapeSequence);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\conversations\ExactMatchConversationCanceller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */