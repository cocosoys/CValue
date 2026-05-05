/*    */ package net.minecraft.util;
/*    */ import java.util.Random;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EnchantmentNameParts {
/*  6 */   public static final EnchantmentNameParts field_148338_a = new EnchantmentNameParts();
/*  7 */   private Random field_148336_b = new Random();
/*    */   
/*  9 */   private String[] field_148337_c = "the elder scrolls klaatu berata niktu xyzzy bless curse light darkness fire air earth water hot dry cold wet ignite snuff embiggen twist shorten stretch fiddle destroy imbue galvanize enchant free limited range of towards inside sphere cube self other ball mental physical grow shrink demon elemental spirit animal creature beast humanoid undead fresh stale ".split(" ");
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
/*    */   private static final String __OBFID = "CL_00000756";
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
/*    */   public String func_148334_a() {
/* 34 */     int i = this.field_148336_b.nextInt(2) + 3;
/* 35 */     String str = "";
/* 36 */     for (byte b = 0; b < i; b++) {
/* 37 */       if (b > 0) str = str + " "; 
/* 38 */       str = str + this.field_148337_c[this.field_148336_b.nextInt(this.field_148337_c.length)];
/*    */     } 
/* 40 */     return str;
/*    */   }
/*    */   
/*    */   public void func_148335_a(long p_148335_1_) {
/* 44 */     this.field_148336_b.setSeed(p_148335_1_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\EnchantmentNameParts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */