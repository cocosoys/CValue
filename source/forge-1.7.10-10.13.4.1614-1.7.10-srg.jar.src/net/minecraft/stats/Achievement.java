/*    */ package net.minecraft.stats;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import net.minecraft.util.StatCollector;
/*    */ 
/*    */ public class Achievement extends StatBase {
/*    */   public final int field_75993_a;
/*    */   public final int field_75991_b;
/*    */   public final Achievement field_75992_c;
/*    */   private final String field_75996_k;
/*    */   
/*    */   public Achievement(String p_i45300_1_, String p_i45300_2_, int p_i45300_3_, int p_i45300_4_, Item p_i45300_5_, Achievement p_i45300_6_) {
/* 19 */     this(p_i45300_1_, p_i45300_2_, p_i45300_3_, p_i45300_4_, new ItemStack(p_i45300_5_), p_i45300_6_);
/*    */   } @SideOnly(Side.CLIENT)
/*    */   private IStatStringFormat field_75994_l; public final ItemStack field_75990_d; private boolean field_75995_m; private static final String __OBFID = "CL_00001466";
/*    */   public Achievement(String p_i45301_1_, String p_i45301_2_, int p_i45301_3_, int p_i45301_4_, Block p_i45301_5_, Achievement p_i45301_6_) {
/* 23 */     this(p_i45301_1_, p_i45301_2_, p_i45301_3_, p_i45301_4_, new ItemStack(p_i45301_5_), p_i45301_6_);
/*    */   }
/*    */   
/*    */   public Achievement(String p_i45302_1_, String p_i45302_2_, int p_i45302_3_, int p_i45302_4_, ItemStack p_i45302_5_, Achievement p_i45302_6_) {
/* 27 */     super(p_i45302_1_, (IChatComponent)new ChatComponentTranslation("achievement." + p_i45302_2_, new Object[0]));
/* 28 */     this.field_75990_d = p_i45302_5_;
/*    */     
/* 30 */     this.field_75996_k = "achievement." + p_i45302_2_ + ".desc";
/* 31 */     this.field_75993_a = p_i45302_3_;
/* 32 */     this.field_75991_b = p_i45302_4_;
/*    */     
/* 34 */     if (p_i45302_3_ < AchievementList.field_76010_a) AchievementList.field_76010_a = p_i45302_3_; 
/* 35 */     if (p_i45302_4_ < AchievementList.field_76008_b) AchievementList.field_76008_b = p_i45302_4_; 
/* 36 */     if (p_i45302_3_ > AchievementList.field_76009_c) AchievementList.field_76009_c = p_i45302_3_; 
/* 37 */     if (p_i45302_4_ > AchievementList.field_76006_d) AchievementList.field_76006_d = p_i45302_4_; 
/* 38 */     this.field_75992_c = p_i45302_6_;
/*    */   }
/*    */ 
/*    */   
/*    */   public Achievement func_75966_h() {
/* 43 */     this.field_75972_f = true;
/* 44 */     return this;
/*    */   }
/*    */   
/*    */   public Achievement func_75987_b() {
/* 48 */     this.field_75995_m = true;
/* 49 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public Achievement func_75971_g() {
/* 54 */     super.func_75971_g();
/*    */     
/* 56 */     AchievementList.field_76007_e.add(this);
/*    */     
/* 58 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75967_d() {
/* 63 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public IChatComponent func_150951_e() {
/* 68 */     IChatComponent iChatComponent = super.func_150951_e();
/* 69 */     iChatComponent.func_150256_b().func_150238_a(func_75984_f() ? EnumChatFormatting.DARK_PURPLE : EnumChatFormatting.GREEN);
/* 70 */     return iChatComponent;
/*    */   }
/*    */ 
/*    */   
/*    */   public Achievement func_150953_b(Class p_150953_1_) {
/* 75 */     return (Achievement)super.func_150953_b(p_150953_1_);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String func_75989_e() {
/* 79 */     if (this.field_75994_l != null) {
/* 80 */       return this.field_75994_l.func_74535_a(StatCollector.func_74838_a(this.field_75996_k));
/*    */     }
/* 82 */     return StatCollector.func_74838_a(this.field_75996_k);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Achievement func_75988_a(IStatStringFormat p_75988_1_) {
/* 86 */     this.field_75994_l = p_75988_1_;
/* 87 */     return this;
/*    */   }
/*    */   
/*    */   public boolean func_75984_f() {
/* 91 */     return this.field_75995_m;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\stats\Achievement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */