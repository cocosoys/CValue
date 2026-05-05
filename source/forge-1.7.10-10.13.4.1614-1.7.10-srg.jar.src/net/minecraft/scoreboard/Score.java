/*    */ package net.minecraft.scoreboard;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class Score
/*    */ {
/*  9 */   public static final Comparator field_96658_a = new Comparator()
/*    */     {
/*    */       public int compare(Score p_compare_1_, Score p_compare_2_) {
/* 12 */         if (p_compare_1_.func_96652_c() > p_compare_2_.func_96652_c())
/* 13 */           return 1; 
/* 14 */         if (p_compare_1_.func_96652_c() < p_compare_2_.func_96652_c()) {
/* 15 */           return -1;
/*    */         }
/* 17 */         return 0;
/*    */       }
/*    */       private static final String __OBFID = "CL_00000618";
/*    */     };
/*    */   private final Scoreboard field_96656_b;
/*    */   private final ScoreObjective field_96657_c;
/*    */   private final String field_96654_d;
/*    */   private int field_96655_e;
/*    */   private static final String __OBFID = "CL_00000617";
/*    */   
/*    */   public Score(Scoreboard p_i2309_1_, ScoreObjective p_i2309_2_, String p_i2309_3_) {
/* 28 */     this.field_96656_b = p_i2309_1_;
/* 29 */     this.field_96657_c = p_i2309_2_;
/* 30 */     this.field_96654_d = p_i2309_3_;
/*    */   }
/*    */   
/*    */   public void func_96649_a(int p_96649_1_) {
/* 34 */     if (this.field_96657_c.func_96680_c().func_96637_b()) throw new IllegalStateException("Cannot modify read-only score"); 
/* 35 */     func_96647_c(func_96652_c() + p_96649_1_);
/*    */   }
/*    */   
/*    */   public void func_96646_b(int p_96646_1_) {
/* 39 */     if (this.field_96657_c.func_96680_c().func_96637_b()) throw new IllegalStateException("Cannot modify read-only score"); 
/* 40 */     func_96647_c(func_96652_c() - p_96646_1_);
/*    */   }
/*    */   
/*    */   public void func_96648_a() {
/* 44 */     if (this.field_96657_c.func_96680_c().func_96637_b()) throw new IllegalStateException("Cannot modify read-only score"); 
/* 45 */     func_96649_a(1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_96652_c() {
/* 54 */     return this.field_96655_e;
/*    */   }
/*    */   
/*    */   public void func_96647_c(int p_96647_1_) {
/* 58 */     int i = this.field_96655_e;
/* 59 */     this.field_96655_e = p_96647_1_;
/* 60 */     if (i != p_96647_1_) func_96650_f().func_96536_a(this); 
/*    */   }
/*    */   
/*    */   public ScoreObjective func_96645_d() {
/* 64 */     return this.field_96657_c;
/*    */   }
/*    */   
/*    */   public String func_96653_e() {
/* 68 */     return this.field_96654_d;
/*    */   }
/*    */   
/*    */   public Scoreboard func_96650_f() {
/* 72 */     return this.field_96656_b;
/*    */   }
/*    */   
/*    */   public void func_96651_a(List p_96651_1_) {
/* 76 */     func_96647_c(this.field_96657_c.func_96680_c().func_96635_a(p_96651_1_));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\scoreboard\Score.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */