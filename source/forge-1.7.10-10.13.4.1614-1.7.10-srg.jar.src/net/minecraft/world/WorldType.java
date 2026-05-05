/*    */ package net.minecraft.world;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ 
/*    */ public class WorldType {
/*  5 */   public static WorldType[] field_77139_a = new WorldType[16];
/*    */   
/*  7 */   public static final WorldType field_77137_b = (new WorldType(0, "default", 1)).func_77129_f();
/*  8 */   public static final WorldType field_77138_c = new WorldType(1, "flat");
/*  9 */   public static final WorldType field_77135_d = new WorldType(2, "largeBiomes");
/* 10 */   public static final WorldType field_151360_e = (new WorldType(3, "amplified")).func_151358_j();
/*    */   
/* 12 */   public static final WorldType field_77136_e = (new WorldType(8, "default_1_1", 0)).func_77124_a(false);
/*    */   private final int field_82748_f;
/*    */   private final String field_77133_f;
/*    */   private final int field_77134_g;
/*    */   private boolean field_77140_h;
/*    */   private boolean field_77141_i;
/*    */   private boolean field_151361_l;
/*    */   private static final String __OBFID = "CL_00000150";
/*    */   
/*    */   private WorldType(int p_i1959_1_, String p_i1959_2_) {
/* 22 */     this(p_i1959_1_, p_i1959_2_, 0);
/*    */   }
/*    */   
/*    */   private WorldType(int p_i1960_1_, String p_i1960_2_, int p_i1960_3_) {
/* 26 */     this.field_77133_f = p_i1960_2_;
/* 27 */     this.field_77134_g = p_i1960_3_;
/* 28 */     this.field_77140_h = true;
/* 29 */     this.field_82748_f = p_i1960_1_;
/* 30 */     field_77139_a[p_i1960_1_] = this;
/*    */   }
/*    */   
/*    */   public String func_77127_a() {
/* 34 */     return this.field_77133_f;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String func_77128_b() {
/* 38 */     return "generator." + this.field_77133_f;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String func_151359_c() {
/* 42 */     return func_77128_b() + ".info";
/*    */   }
/*    */   
/*    */   public int func_77131_c() {
/* 46 */     return this.field_77134_g;
/*    */   }
/*    */   
/*    */   public WorldType func_77132_a(int p_77132_1_) {
/* 50 */     if (this == field_77137_b && p_77132_1_ == 0) {
/* 51 */       return field_77136_e;
/*    */     }
/* 53 */     return this;
/*    */   }
/*    */   
/*    */   private WorldType func_77124_a(boolean p_77124_1_) {
/* 57 */     this.field_77140_h = p_77124_1_;
/* 58 */     return this;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_77126_d() {
/* 62 */     return this.field_77140_h;
/*    */   }
/*    */   
/*    */   private WorldType func_77129_f() {
/* 66 */     this.field_77141_i = true;
/* 67 */     return this;
/*    */   }
/*    */   
/*    */   public boolean func_77125_e() {
/* 71 */     return this.field_77141_i;
/*    */   }
/*    */   
/*    */   public static WorldType func_77130_a(String p_77130_0_) {
/* 75 */     for (byte b = 0; b < field_77139_a.length; b++) {
/* 76 */       if (field_77139_a[b] != null && (field_77139_a[b]).field_77133_f.equalsIgnoreCase(p_77130_0_)) {
/* 77 */         return field_77139_a[b];
/*    */       }
/*    */     } 
/* 80 */     return null;
/*    */   }
/*    */   
/*    */   public int func_82747_f() {
/* 84 */     return this.field_82748_f;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_151357_h() {
/* 88 */     return this.field_151361_l;
/*    */   }
/*    */   
/*    */   private WorldType func_151358_j() {
/* 92 */     this.field_151361_l = true;
/* 93 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\WorldType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */