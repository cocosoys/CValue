/*    */ package net.minecraft.world;public enum EnumDifficulty {
/*    */   private static final EnumDifficulty[] field_151530_e;
/*    */   private final int field_151527_f;
/*  4 */   PEACEFUL(0, "options.difficulty.peaceful"),
/*  5 */   EASY(1, "options.difficulty.easy"),
/*  6 */   NORMAL(2, "options.difficulty.normal"),
/*  7 */   HARD(3, "options.difficulty.hard"); private final String field_151528_g; private static final String __OBFID = "CL_00001510";
/*    */   static {
/*  9 */     field_151530_e = new EnumDifficulty[(values()).length];
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
/* 27 */     for (EnumDifficulty enumDifficulty : values())
/* 28 */       field_151530_e[enumDifficulty.field_151527_f] = enumDifficulty; 
/*    */   } EnumDifficulty(int p_i45312_3_, String p_i45312_4_) {
/*    */     this.field_151527_f = p_i45312_3_;
/*    */     this.field_151528_g = p_i45312_4_;
/*    */   } public String func_151526_b() {
/* 33 */     return this.field_151528_g;
/*    */   }
/*    */   
/*    */   public int func_151525_a() {
/*    */     return this.field_151527_f;
/*    */   }
/*    */   
/*    */   public static EnumDifficulty func_151523_a(int p_151523_0_) {
/*    */     return field_151530_e[p_151523_0_ % field_151530_e.length];
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\EnumDifficulty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */