/*    */ package org.bukkit.conversations;
/*    */ 
/*    */ import org.apache.commons.lang.ArrayUtils;
/*    */ import org.apache.commons.lang.BooleanUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class BooleanPrompt
/*    */   extends ValidatingPrompt
/*    */ {
/*    */   protected boolean isInputValid(ConversationContext context, String input) {
/* 18 */     String[] accepted = { "true", "false", "on", "off", "yes", "no" };
/* 19 */     return ArrayUtils.contains((Object[])accepted, input.toLowerCase());
/*    */   }
/*    */ 
/*    */   
/*    */   protected Prompt acceptValidatedInput(ConversationContext context, String input) {
/* 24 */     return acceptValidatedInput(context, BooleanUtils.toBoolean(input));
/*    */   }
/*    */   
/*    */   protected abstract Prompt acceptValidatedInput(ConversationContext paramConversationContext, boolean paramBoolean);
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\conversations\BooleanPrompt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */