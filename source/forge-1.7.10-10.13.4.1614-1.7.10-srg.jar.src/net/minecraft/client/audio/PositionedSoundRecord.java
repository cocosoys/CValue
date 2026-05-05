/*    */ package net.minecraft.client.audio;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class PositionedSoundRecord extends PositionedSound {
/*    */   private static final String __OBFID = "CL_00001120";
/*    */   
/*    */   public static PositionedSoundRecord func_147674_a(ResourceLocation p_147674_0_, float p_147674_1_) {
/* 12 */     return new PositionedSoundRecord(p_147674_0_, 0.25F, p_147674_1_, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */   
/*    */   public static PositionedSoundRecord func_147673_a(ResourceLocation p_147673_0_) {
/* 16 */     return new PositionedSoundRecord(p_147673_0_, 1.0F, 1.0F, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */   
/*    */   public static PositionedSoundRecord func_147675_a(ResourceLocation p_147675_0_, float p_147675_1_, float p_147675_2_, float p_147675_3_) {
/* 20 */     return new PositionedSoundRecord(p_147675_0_, 4.0F, 1.0F, false, 0, ISound.AttenuationType.LINEAR, p_147675_1_, p_147675_2_, p_147675_3_);
/*    */   }
/*    */   
/*    */   public PositionedSoundRecord(ResourceLocation p_i45107_1_, float p_i45107_2_, float p_i45107_3_, float p_i45107_4_, float p_i45107_5_, float p_i45107_6_) {
/* 24 */     this(p_i45107_1_, p_i45107_2_, p_i45107_3_, false, 0, ISound.AttenuationType.LINEAR, p_i45107_4_, p_i45107_5_, p_i45107_6_);
/*    */   }
/*    */   
/*    */   private PositionedSoundRecord(ResourceLocation p_i45108_1_, float p_i45108_2_, float p_i45108_3_, boolean p_i45108_4_, int p_i45108_5_, ISound.AttenuationType p_i45108_6_, float p_i45108_7_, float p_i45108_8_, float p_i45108_9_) {
/* 28 */     super(p_i45108_1_);
/* 29 */     this.field_147662_b = p_i45108_2_;
/* 30 */     this.field_147663_c = p_i45108_3_;
/* 31 */     this.field_147660_d = p_i45108_7_;
/* 32 */     this.field_147661_e = p_i45108_8_;
/* 33 */     this.field_147658_f = p_i45108_9_;
/* 34 */     this.field_147659_g = p_i45108_4_;
/* 35 */     this.field_147665_h = p_i45108_5_;
/* 36 */     this.field_147666_i = p_i45108_6_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\PositionedSoundRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */