/*    */ package net.minecraft.client.audio;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class SoundPoolEntry {
/*    */   private final ResourceLocation field_148656_a;
/*    */   private final boolean field_148654_b;
/*    */   
/*    */   public SoundPoolEntry(ResourceLocation p_i45113_1_, double p_i45113_2_, double p_i45113_4_, boolean p_i45113_6_) {
/* 12 */     this.field_148656_a = p_i45113_1_;
/* 13 */     this.field_148655_c = p_i45113_2_;
/* 14 */     this.field_148653_d = p_i45113_4_;
/* 15 */     this.field_148654_b = p_i45113_6_;
/*    */   }
/*    */   private double field_148655_c; private double field_148653_d; private static final String __OBFID = "CL_00001140";
/*    */   public SoundPoolEntry(SoundPoolEntry p_i45114_1_) {
/* 19 */     this.field_148656_a = p_i45114_1_.field_148656_a;
/* 20 */     this.field_148655_c = p_i45114_1_.field_148655_c;
/* 21 */     this.field_148653_d = p_i45114_1_.field_148653_d;
/* 22 */     this.field_148654_b = p_i45114_1_.field_148654_b;
/*    */   }
/*    */   
/*    */   public ResourceLocation func_148652_a() {
/* 26 */     return this.field_148656_a;
/*    */   }
/*    */   
/*    */   public double func_148650_b() {
/* 30 */     return this.field_148655_c;
/*    */   }
/*    */   
/*    */   public void func_148651_a(double p_148651_1_) {
/* 34 */     this.field_148655_c = p_148651_1_;
/*    */   }
/*    */   
/*    */   public double func_148649_c() {
/* 38 */     return this.field_148653_d;
/*    */   }
/*    */   
/*    */   public void func_148647_b(double p_148647_1_) {
/* 42 */     this.field_148653_d = p_148647_1_;
/*    */   }
/*    */   
/*    */   public boolean func_148648_d() {
/* 46 */     return this.field_148654_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\SoundPoolEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */