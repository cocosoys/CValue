/*    */ package net.minecraft.util;
/*    */ 
/*    */ public class ChatComponentText extends ChatComponentStyle {
/*    */   private final String field_150267_b;
/*    */   
/*    */   public ChatComponentText(String p_i45159_1_) {
/*  7 */     this.field_150267_b = p_i45159_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001269";
/*    */   public String func_150265_g() {
/* 11 */     return this.field_150267_b;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_150261_e() {
/* 16 */     return this.field_150267_b;
/*    */   }
/*    */ 
/*    */   
/*    */   public ChatComponentText func_150259_f() {
/* 21 */     ChatComponentText chatComponentText = new ChatComponentText(this.field_150267_b);
/* 22 */     chatComponentText.func_150255_a(func_150256_b().func_150232_l());
/* 23 */     for (IChatComponent iChatComponent : func_150253_a()) {
/* 24 */       chatComponentText.func_150257_a(iChatComponent.func_150259_f());
/*    */     }
/* 26 */     return chatComponentText;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 31 */     if (this == p_equals_1_) return true;
/*    */     
/* 33 */     if (p_equals_1_ instanceof ChatComponentText) {
/* 34 */       ChatComponentText chatComponentText = (ChatComponentText)p_equals_1_;
/* 35 */       return (this.field_150267_b.equals(chatComponentText.func_150265_g()) && super.equals(p_equals_1_));
/*    */     } 
/*    */     
/* 38 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 43 */     return "TextComponent{text='" + this.field_150267_b + '\'' + ", siblings=" + this.field_150264_a + ", style=" + func_150256_b() + '}';
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\ChatComponentText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */