/*    */ package net.minecraft.client.audio;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public enum SoundCategory {
/*    */   private static final Map field_147168_j;
/*    */   private static final Map field_147169_k;
/*    */   private final String field_147166_l;
/*  8 */   MASTER("master", 0),
/*  9 */   MUSIC("music", 1),
/* 10 */   RECORDS("record", 2),
/* 11 */   WEATHER("weather", 3),
/* 12 */   BLOCKS("block", 4),
/* 13 */   MOBS("hostile", 5),
/* 14 */   ANIMALS("neutral", 6),
/* 15 */   PLAYERS("player", 7),
/* 16 */   AMBIENT("ambient", 8); private final int field_147167_m; private static final String __OBFID = "CL_00001686";
/*    */   static {
/* 18 */     field_147168_j = Maps.newHashMap();
/* 19 */     field_147169_k = Maps.newHashMap();
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
/* 37 */     for (SoundCategory soundCategory : values()) {
/* 38 */       if (field_147168_j.containsKey(soundCategory.func_147155_a()) || field_147169_k.containsKey(Integer.valueOf(soundCategory.func_147156_b()))) {
/* 39 */         throw new Error("Clash in Sound Category ID & Name pools! Cannot insert " + soundCategory);
/*    */       }
/* 41 */       field_147168_j.put(soundCategory.func_147155_a(), soundCategory);
/* 42 */       field_147169_k.put(Integer.valueOf(soundCategory.func_147156_b()), soundCategory);
/*    */     }  } SoundCategory(String p_i45126_3_, int p_i45126_4_) {
/*    */     this.field_147166_l = p_i45126_3_;
/*    */     this.field_147167_m = p_i45126_4_;
/*    */   } public static SoundCategory func_147154_a(String p_147154_0_) {
/* 47 */     return (SoundCategory)field_147168_j.get(p_147154_0_);
/*    */   }
/*    */   
/*    */   public String func_147155_a() {
/*    */     return this.field_147166_l;
/*    */   }
/*    */   
/*    */   public int func_147156_b() {
/*    */     return this.field_147167_m;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\SoundCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */