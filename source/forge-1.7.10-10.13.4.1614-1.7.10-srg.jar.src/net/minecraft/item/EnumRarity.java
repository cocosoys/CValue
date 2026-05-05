/*    */ package net.minecraft.item;
/*    */ 
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ 
/*    */ public enum EnumRarity {
/*  6 */   common(EnumChatFormatting.WHITE, "Common"),
/*  7 */   uncommon(EnumChatFormatting.YELLOW, "Uncommon"),
/*  8 */   rare(EnumChatFormatting.AQUA, "Rare"),
/*  9 */   epic(EnumChatFormatting.LIGHT_PURPLE, "Epic");
/*    */   public final EnumChatFormatting field_77937_e;
/*    */   public final String field_77934_f;
/*    */   private static final String __OBFID = "CL_00000056";
/*    */   
/*    */   EnumRarity(EnumChatFormatting p_i45349_3_, String p_i45349_4_) {
/* 15 */     this.field_77937_e = p_i45349_3_;
/* 16 */     this.field_77934_f = p_i45349_4_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\EnumRarity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */