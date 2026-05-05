/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class TexturedQuad {
/*    */   public PositionTextureVertex[] field_78239_a;
/*    */   public int field_78237_b;
/*    */   
/*    */   public TexturedQuad(PositionTextureVertex[] p_i1152_1_) {
/* 12 */     this.field_78239_a = p_i1152_1_;
/* 13 */     this.field_78237_b = p_i1152_1_.length;
/*    */   }
/*    */   private boolean field_78238_c; private static final String __OBFID = "CL_00000850";
/*    */   public TexturedQuad(PositionTextureVertex[] p_i1153_1_, int p_i1153_2_, int p_i1153_3_, int p_i1153_4_, int p_i1153_5_, float p_i1153_6_, float p_i1153_7_) {
/* 17 */     this(p_i1153_1_);
/*    */     
/* 19 */     float f1 = 0.0F / p_i1153_6_;
/* 20 */     float f2 = 0.0F / p_i1153_7_;
/* 21 */     p_i1153_1_[0] = p_i1153_1_[0].func_78240_a(p_i1153_4_ / p_i1153_6_ - f1, p_i1153_3_ / p_i1153_7_ + f2);
/* 22 */     p_i1153_1_[1] = p_i1153_1_[1].func_78240_a(p_i1153_2_ / p_i1153_6_ + f1, p_i1153_3_ / p_i1153_7_ + f2);
/* 23 */     p_i1153_1_[2] = p_i1153_1_[2].func_78240_a(p_i1153_2_ / p_i1153_6_ + f1, p_i1153_5_ / p_i1153_7_ - f2);
/* 24 */     p_i1153_1_[3] = p_i1153_1_[3].func_78240_a(p_i1153_4_ / p_i1153_6_ - f1, p_i1153_5_ / p_i1153_7_ - f2);
/*    */   }
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
/*    */   public void func_78235_a() {
/* 37 */     PositionTextureVertex[] arrayOfPositionTextureVertex = new PositionTextureVertex[this.field_78239_a.length];
/* 38 */     for (byte b = 0; b < this.field_78239_a.length; b++)
/* 39 */       arrayOfPositionTextureVertex[b] = this.field_78239_a[this.field_78239_a.length - b - 1]; 
/* 40 */     this.field_78239_a = arrayOfPositionTextureVertex;
/*    */   }
/*    */   
/*    */   public void func_78236_a(Tessellator p_78236_1_, float p_78236_2_) {
/* 44 */     Vec3 vec31 = (this.field_78239_a[1]).field_78243_a.func_72444_a((this.field_78239_a[0]).field_78243_a);
/* 45 */     Vec3 vec32 = (this.field_78239_a[1]).field_78243_a.func_72444_a((this.field_78239_a[2]).field_78243_a);
/* 46 */     Vec3 vec33 = vec32.func_72431_c(vec31).func_72432_b();
/*    */     
/* 48 */     p_78236_1_.func_78382_b();
/* 49 */     if (this.field_78238_c) {
/* 50 */       p_78236_1_.func_78375_b(-((float)vec33.field_72450_a), -((float)vec33.field_72448_b), -((float)vec33.field_72449_c));
/*    */     } else {
/* 52 */       p_78236_1_.func_78375_b((float)vec33.field_72450_a, (float)vec33.field_72448_b, (float)vec33.field_72449_c);
/*    */     } 
/*    */     
/* 55 */     for (byte b = 0; b < 4; b++) {
/* 56 */       PositionTextureVertex positionTextureVertex = this.field_78239_a[b];
/* 57 */       p_78236_1_.func_78374_a(((float)positionTextureVertex.field_78243_a.field_72450_a * p_78236_2_), ((float)positionTextureVertex.field_78243_a.field_72448_b * p_78236_2_), ((float)positionTextureVertex.field_78243_a.field_72449_c * p_78236_2_), positionTextureVertex.field_78241_b, positionTextureVertex.field_78242_c);
/*    */     } 
/* 59 */     p_78236_1_.func_78381_a();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\TexturedQuad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */