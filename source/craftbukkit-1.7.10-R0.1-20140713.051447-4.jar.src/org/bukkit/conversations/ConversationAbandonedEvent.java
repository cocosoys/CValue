/*    */ package org.bukkit.conversations;
/*    */ 
/*    */ import java.util.EventObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConversationAbandonedEvent
/*    */   extends EventObject
/*    */ {
/*    */   private ConversationContext context;
/*    */   private ConversationCanceller canceller;
/*    */   
/*    */   public ConversationAbandonedEvent(Conversation conversation) {
/* 15 */     this(conversation, null);
/*    */   }
/*    */   
/*    */   public ConversationAbandonedEvent(Conversation conversation, ConversationCanceller canceller) {
/* 19 */     super(conversation);
/* 20 */     this.context = conversation.getContext();
/* 21 */     this.canceller = canceller;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ConversationCanceller getCanceller() {
/* 30 */     return this.canceller;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ConversationContext getContext() {
/* 39 */     return this.context;
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
/*    */   public boolean gracefulExit() {
/* 51 */     return (this.canceller == null);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\conversations\ConversationAbandonedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */