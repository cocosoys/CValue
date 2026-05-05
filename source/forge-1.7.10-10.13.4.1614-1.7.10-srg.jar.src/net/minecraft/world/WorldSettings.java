/*     */ package net.minecraft.world;public final class WorldSettings { private final long field_77174_a;
/*     */   private final GameType field_77172_b;
/*     */   private final boolean field_77173_c;
/*     */   private final boolean field_77170_d;
/*     */   private final WorldType field_77171_e;
/*     */   private boolean field_77168_f;
/*     */   private boolean field_77169_g;
/*     */   
/*   9 */   public enum GameType { NOT_SET(-1, ""), SURVIVAL(0, "survival"), CREATIVE(1, "creative"), ADVENTURE(2, "adventure");
/*     */     private static final String __OBFID = "CL_00000148";
/*     */     String field_77151_f;
/*     */     int field_77154_e;
/*     */     
/*     */     GameType(int p_i1956_3_, String p_i1956_4_) {
/*  15 */       this.field_77154_e = p_i1956_3_;
/*  16 */       this.field_77151_f = p_i1956_4_;
/*     */     }
/*     */     
/*     */     public int func_77148_a() {
/*  20 */       return this.field_77154_e;
/*     */     }
/*     */     
/*     */     public String func_77149_b() {
/*  24 */       return this.field_77151_f;
/*     */     }
/*     */     
/*     */     public void func_77147_a(PlayerCapabilities p_77147_1_) {
/*  28 */       if (this == CREATIVE) {
/*  29 */         p_77147_1_.field_75101_c = true;
/*  30 */         p_77147_1_.field_75098_d = true;
/*  31 */         p_77147_1_.field_75102_a = true;
/*     */       } else {
/*  33 */         p_77147_1_.field_75101_c = false;
/*  34 */         p_77147_1_.field_75098_d = false;
/*  35 */         p_77147_1_.field_75102_a = false;
/*  36 */         p_77147_1_.field_75100_b = false;
/*     */       } 
/*  38 */       p_77147_1_.field_75099_e = !func_82752_c();
/*     */     }
/*     */     
/*     */     public boolean func_82752_c() {
/*  42 */       return (this == ADVENTURE);
/*     */     }
/*     */     
/*     */     public boolean func_77145_d() {
/*  46 */       return (this == CREATIVE);
/*     */     }
/*     */     @SideOnly(Side.CLIENT)
/*     */     public boolean func_77144_e() {
/*  50 */       return (this == SURVIVAL || this == ADVENTURE);
/*     */     }
/*     */     
/*     */     public static GameType func_77146_a(int p_77146_0_) {
/*  54 */       for (GameType gameType : values()) {
/*  55 */         if (gameType.field_77154_e == p_77146_0_) {
/*  56 */           return gameType;
/*     */         }
/*     */       } 
/*  59 */       return SURVIVAL;
/*     */     }
/*     */     @SideOnly(Side.CLIENT)
/*     */     public static GameType func_77142_a(String p_77142_0_) {
/*  63 */       for (GameType gameType : values()) {
/*  64 */         if (gameType.field_77151_f.equals(p_77142_0_)) {
/*  65 */           return gameType;
/*     */         }
/*     */       } 
/*  68 */       return SURVIVAL;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  79 */   private String field_82751_h = ""; private static final String __OBFID = "CL_00000147";
/*     */   
/*     */   public WorldSettings(long p_i1957_1_, GameType p_i1957_3_, boolean p_i1957_4_, boolean p_i1957_5_, WorldType p_i1957_6_) {
/*  82 */     this.field_77174_a = p_i1957_1_;
/*  83 */     this.field_77172_b = p_i1957_3_;
/*  84 */     this.field_77173_c = p_i1957_4_;
/*  85 */     this.field_77170_d = p_i1957_5_;
/*  86 */     this.field_77171_e = p_i1957_6_;
/*     */   }
/*     */   
/*     */   public WorldSettings(WorldInfo p_i1958_1_) {
/*  90 */     this(p_i1958_1_.func_76063_b(), p_i1958_1_.func_76077_q(), p_i1958_1_.func_76089_r(), p_i1958_1_.func_76093_s(), p_i1958_1_.func_76067_t());
/*     */   }
/*     */   
/*     */   public WorldSettings func_77159_a() {
/*  94 */     this.field_77169_g = true;
/*  95 */     return this;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public WorldSettings func_77166_b() {
/*  99 */     this.field_77168_f = true;
/* 100 */     return this;
/*     */   }
/*     */   
/*     */   public WorldSettings func_82750_a(String p_82750_1_) {
/* 104 */     this.field_82751_h = p_82750_1_;
/* 105 */     return this;
/*     */   }
/*     */   
/*     */   public boolean func_77167_c() {
/* 109 */     return this.field_77169_g;
/*     */   }
/*     */   
/*     */   public long func_77160_d() {
/* 113 */     return this.field_77174_a;
/*     */   }
/*     */   
/*     */   public GameType func_77162_e() {
/* 117 */     return this.field_77172_b;
/*     */   }
/*     */   
/*     */   public boolean func_77158_f() {
/* 121 */     return this.field_77170_d;
/*     */   }
/*     */   
/*     */   public boolean func_77164_g() {
/* 125 */     return this.field_77173_c;
/*     */   }
/*     */   
/*     */   public WorldType func_77165_h() {
/* 129 */     return this.field_77171_e;
/*     */   }
/*     */   
/*     */   public boolean func_77163_i() {
/* 133 */     return this.field_77168_f;
/*     */   }
/*     */   
/*     */   public static GameType func_77161_a(int p_77161_0_) {
/* 137 */     return GameType.func_77146_a(p_77161_0_);
/*     */   }
/*     */   
/*     */   public String func_82749_j() {
/* 141 */     return this.field_82751_h;
/*     */   } }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\WorldSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */