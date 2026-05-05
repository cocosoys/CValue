/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class PositionTextureVertex {
/*    */   public Vec3 field_78243_a;
/*    */   public float field_78241_b;
/*    */   
/*    */   public PositionTextureVertex(float p_i1158_1_, float p_i1158_2_, float p_i1158_3_, float p_i1158_4_, float p_i1158_5_) {
/* 11 */     this(Vec3.func_72443_a(p_i1158_1_, p_i1158_2_, p_i1158_3_), p_i1158_4_, p_i1158_5_);
/*    */   }
/*    */   public float field_78242_c; private static final String __OBFID = "CL_00000862";
/*    */   public PositionTextureVertex func_78240_a(float p_78240_1_, float p_78240_2_) {
/* 15 */     return new PositionTextureVertex(this, p_78240_1_, p_78240_2_);
/*    */   }
/*    */   
/*    */   public PositionTextureVertex(PositionTextureVertex p_i1159_1_, float p_i1159_2_, float p_i1159_3_) {
/* 19 */     this.field_78243_a = p_i1159_1_.field_78243_a;
/* 20 */     this.field_78241_b = p_i1159_2_;
/* 21 */     this.field_78242_c = p_i1159_3_;
/*    */   }
/*    */   
/*    */   public PositionTextureVertex(Vec3 p_i1160_1_, float p_i1160_2_, float p_i1160_3_) {
/* 25 */     this.field_78243_a = p_i1160_1_;
/* 26 */     this.field_78241_b = p_i1160_2_;
/* 27 */     this.field_78242_c = p_i1160_3_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\PositionTextureVertex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */