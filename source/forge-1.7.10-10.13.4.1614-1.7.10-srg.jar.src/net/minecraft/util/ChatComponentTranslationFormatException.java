/*    */ package net.minecraft.util;
/*    */ 
/*    */ public class ChatComponentTranslationFormatException extends IllegalArgumentException {
/*    */   public ChatComponentTranslationFormatException(ChatComponentTranslation p_i45161_1_, String p_i45161_2_) {
/*  5 */     super(String.format("Error parsing: %s: %s", new Object[] { p_i45161_1_, p_i45161_2_ }));
/*    */   }
/*    */   private static final String __OBFID = "CL_00001271";
/*    */   public ChatComponentTranslationFormatException(ChatComponentTranslation p_i45162_1_, int p_i45162_2_) {
/*  9 */     super(String.format("Invalid index %d requested for %s", new Object[] { Integer.valueOf(p_i45162_2_), p_i45162_1_ }));
/*    */   }
/*    */   
/*    */   public ChatComponentTranslationFormatException(ChatComponentTranslation p_i45163_1_, Throwable p_i45163_2_) {
/* 13 */     super(String.format("Error while parsing: %s", new Object[] { p_i45163_1_ }), p_i45163_2_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\ChatComponentTranslationFormatException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */