/*    */ package net.minecraft.world.storage;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.world.WorldSettings;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class SaveFormatComparator
/*    */   implements Comparable
/*    */ {
/*    */   private final String field_75797_a;
/*    */   private final String field_75795_b;
/*    */   private final long field_75796_c;
/*    */   private final long field_75793_d;
/*    */   
/*    */   public SaveFormatComparator(String p_i2161_1_, String p_i2161_2_, long p_i2161_3_, long p_i2161_5_, WorldSettings.GameType p_i2161_7_, boolean p_i2161_8_, boolean p_i2161_9_, boolean p_i2161_10_) {
/* 17 */     this.field_75797_a = p_i2161_1_;
/* 18 */     this.field_75795_b = p_i2161_2_;
/* 19 */     this.field_75796_c = p_i2161_3_;
/* 20 */     this.field_75793_d = p_i2161_5_;
/* 21 */     this.field_75791_f = p_i2161_7_;
/* 22 */     this.field_75794_e = p_i2161_8_;
/* 23 */     this.field_75792_g = p_i2161_9_;
/* 24 */     this.field_75798_h = p_i2161_10_;
/*    */   }
/*    */   private final boolean field_75794_e; private final WorldSettings.GameType field_75791_f; private final boolean field_75792_g; private final boolean field_75798_h; private static final String __OBFID = "CL_00000601";
/*    */   public String func_75786_a() {
/* 28 */     return this.field_75797_a;
/*    */   }
/*    */   
/*    */   public String func_75788_b() {
/* 32 */     return this.field_75795_b;
/*    */   }
/*    */   
/*    */   public long func_154336_c() {
/* 36 */     return this.field_75793_d;
/*    */   }
/*    */   
/*    */   public boolean func_75785_d() {
/* 40 */     return this.field_75794_e;
/*    */   }
/*    */   
/*    */   public long func_75784_e() {
/* 44 */     return this.field_75796_c;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(SaveFormatComparator p_compareTo_1_) {
/* 49 */     if (this.field_75796_c < p_compareTo_1_.field_75796_c) {
/* 50 */       return 1;
/*    */     }
/* 52 */     if (this.field_75796_c > p_compareTo_1_.field_75796_c) {
/* 53 */       return -1;
/*    */     }
/* 55 */     return this.field_75797_a.compareTo(p_compareTo_1_.field_75797_a);
/*    */   }
/*    */   
/*    */   public WorldSettings.GameType func_75790_f() {
/* 59 */     return this.field_75791_f;
/*    */   }
/*    */   
/*    */   public boolean func_75789_g() {
/* 63 */     return this.field_75792_g;
/*    */   }
/*    */   
/*    */   public boolean func_75783_h() {
/* 67 */     return this.field_75798_h;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\storage\SaveFormatComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */