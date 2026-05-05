/*    */ package net.minecraft.client.stream;
/*    */ import net.minecraft.stats.Achievement;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MetadataAchievement extends Metadata {
/*    */   public MetadataAchievement(Achievement p_i1032_1_) {
/*  7 */     super("achievement");
/*    */     
/*  9 */     func_152808_a("achievement_id", p_i1032_1_.field_75975_e);
/* 10 */     func_152808_a("achievement_name", p_i1032_1_.func_150951_e().func_150260_c());
/* 11 */     func_152808_a("achievement_description", p_i1032_1_.func_75989_e());
/*    */     
/* 13 */     func_152807_a("Achievement '" + p_i1032_1_.func_150951_e().func_150260_c() + "' obtained!");
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00001824";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\stream\MetadataAchievement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */