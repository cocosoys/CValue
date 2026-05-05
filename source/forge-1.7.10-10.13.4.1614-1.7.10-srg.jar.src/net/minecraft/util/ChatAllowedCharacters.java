/*    */ package net.minecraft.util;
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
/*    */ public class ChatAllowedCharacters
/*    */ {
/*    */   public static boolean func_71566_a(char p_71566_0_) {
/* 34 */     return (p_71566_0_ != '§' && p_71566_0_ >= ' ' && p_71566_0_ != '');
/*    */   }
/*    */   
/* 37 */   public static final char[] field_71567_b = new char[] { '/', '\n', '\r', '\t', Character.MIN_VALUE, '\f', '`', '?', '*', '\\', '<', '>', '|', '"', ':' };
/*    */ 
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00001606";
/*    */ 
/*    */ 
/*    */   
/*    */   public static String func_71565_a(String p_71565_0_) {
/* 46 */     StringBuilder stringBuilder = new StringBuilder();
/*    */     
/* 48 */     for (char c : p_71565_0_.toCharArray()) {
/* 49 */       if (func_71566_a(c)) {
/* 50 */         stringBuilder.append(c);
/*    */       }
/*    */     } 
/*    */     
/* 54 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\ChatAllowedCharacters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */