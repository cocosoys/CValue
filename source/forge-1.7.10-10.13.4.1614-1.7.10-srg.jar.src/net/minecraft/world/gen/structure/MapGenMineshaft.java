/*    */ package net.minecraft.world.gen.structure;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ 
/*    */ public class MapGenMineshaft
/*    */   extends MapGenStructure
/*    */ {
/* 10 */   private double field_82673_e = 0.004D;
/*    */   
/*    */   private static final String __OBFID = "CL_00000443";
/*    */   
/*    */   public MapGenMineshaft() {}
/*    */   
/*    */   public String func_143025_a() {
/* 17 */     return "Mineshaft";
/*    */   }
/*    */   
/*    */   public MapGenMineshaft(Map p_i2034_1_) {
/* 21 */     for (Map.Entry entry : p_i2034_1_.entrySet()) {
/* 22 */       if (((String)entry.getKey()).equals("chance")) {
/* 23 */         this.field_82673_e = MathHelper.func_82712_a((String)entry.getValue(), this.field_82673_e);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_75047_a(int p_75047_1_, int p_75047_2_) {
/* 30 */     return (this.field_75038_b.nextDouble() < this.field_82673_e && this.field_75038_b.nextInt(80) < Math.max(Math.abs(p_75047_1_), Math.abs(p_75047_2_)));
/*    */   }
/*    */ 
/*    */   
/*    */   protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_) {
/* 35 */     return new StructureMineshaftStart(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\structure\MapGenMineshaft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */