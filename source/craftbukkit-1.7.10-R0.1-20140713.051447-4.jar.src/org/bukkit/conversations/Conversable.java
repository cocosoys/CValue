package org.bukkit.conversations;

public interface Conversable {
  boolean isConversing();
  
  void acceptConversationInput(String paramString);
  
  boolean beginConversation(Conversation paramConversation);
  
  void abandonConversation(Conversation paramConversation);
  
  void abandonConversation(Conversation paramConversation, ConversationAbandonedEvent paramConversationAbandonedEvent);
  
  void sendRawMessage(String paramString);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\conversations\Conversable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */