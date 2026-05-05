/*    */ package net.minecraft.client.audio;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class SoundEventAccessor implements ISoundEventAccessor {
/*    */   private final SoundPoolEntry field_148739_a;
/*    */   
/*    */   SoundEventAccessor(SoundPoolEntry p_i45123_1_, int p_i45123_2_) {
/*  8 */     this.field_148739_a = p_i45123_1_;
/*  9 */     this.field_148738_b = p_i45123_2_;
/*    */   }
/*    */   private final int field_148738_b; private static final String __OBFID = "CL_00001153";
/*    */   
/*    */   public int func_148721_a() {
/* 14 */     return this.field_148738_b;
/*    */   }
/*    */ 
/*    */   
/*    */   public SoundPoolEntry func_148720_g() {
/* 19 */     return new SoundPoolEntry(this.field_148739_a);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\SoundEventAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */