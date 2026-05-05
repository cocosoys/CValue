/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelBox {
/*    */   private PositionTextureVertex[] field_78253_h;
/*    */   private TexturedQuad[] field_78254_i;
/*    */   public final float field_78252_a;
/*    */   public final float field_78250_b;
/*    */   public final float field_78251_c;
/*    */   
/*    */   public ModelBox(ModelRenderer p_i1171_1_, int p_i1171_2_, int p_i1171_3_, float p_i1171_4_, float p_i1171_5_, float p_i1171_6_, int p_i1171_7_, int p_i1171_8_, int p_i1171_9_, float p_i1171_10_) {
/* 14 */     this.field_78252_a = p_i1171_4_;
/* 15 */     this.field_78250_b = p_i1171_5_;
/* 16 */     this.field_78251_c = p_i1171_6_;
/* 17 */     this.field_78248_d = p_i1171_4_ + p_i1171_7_;
/* 18 */     this.field_78249_e = p_i1171_5_ + p_i1171_8_;
/* 19 */     this.field_78246_f = p_i1171_6_ + p_i1171_9_;
/* 20 */     this.field_78253_h = new PositionTextureVertex[8];
/* 21 */     this.field_78254_i = new TexturedQuad[6];
/*    */     
/* 23 */     float f1 = p_i1171_4_ + p_i1171_7_;
/* 24 */     float f2 = p_i1171_5_ + p_i1171_8_;
/* 25 */     float f3 = p_i1171_6_ + p_i1171_9_;
/*    */     
/* 27 */     p_i1171_4_ -= p_i1171_10_;
/* 28 */     p_i1171_5_ -= p_i1171_10_;
/* 29 */     p_i1171_6_ -= p_i1171_10_;
/* 30 */     f1 += p_i1171_10_;
/* 31 */     f2 += p_i1171_10_;
/* 32 */     f3 += p_i1171_10_;
/*    */     
/* 34 */     if (p_i1171_1_.field_78809_i) {
/* 35 */       float f = f1;
/* 36 */       f1 = p_i1171_4_;
/* 37 */       p_i1171_4_ = f;
/*    */     } 
/*    */     
/* 40 */     PositionTextureVertex positionTextureVertex1 = new PositionTextureVertex(p_i1171_4_, p_i1171_5_, p_i1171_6_, 0.0F, 0.0F);
/* 41 */     PositionTextureVertex positionTextureVertex2 = new PositionTextureVertex(f1, p_i1171_5_, p_i1171_6_, 0.0F, 8.0F);
/* 42 */     PositionTextureVertex positionTextureVertex3 = new PositionTextureVertex(f1, f2, p_i1171_6_, 8.0F, 8.0F);
/* 43 */     PositionTextureVertex positionTextureVertex4 = new PositionTextureVertex(p_i1171_4_, f2, p_i1171_6_, 8.0F, 0.0F);
/*    */     
/* 45 */     PositionTextureVertex positionTextureVertex5 = new PositionTextureVertex(p_i1171_4_, p_i1171_5_, f3, 0.0F, 0.0F);
/* 46 */     PositionTextureVertex positionTextureVertex6 = new PositionTextureVertex(f1, p_i1171_5_, f3, 0.0F, 8.0F);
/* 47 */     PositionTextureVertex positionTextureVertex7 = new PositionTextureVertex(f1, f2, f3, 8.0F, 8.0F);
/* 48 */     PositionTextureVertex positionTextureVertex8 = new PositionTextureVertex(p_i1171_4_, f2, f3, 8.0F, 0.0F);
/*    */     
/* 50 */     this.field_78253_h[0] = positionTextureVertex1;
/* 51 */     this.field_78253_h[1] = positionTextureVertex2;
/* 52 */     this.field_78253_h[2] = positionTextureVertex3;
/* 53 */     this.field_78253_h[3] = positionTextureVertex4;
/* 54 */     this.field_78253_h[4] = positionTextureVertex5;
/* 55 */     this.field_78253_h[5] = positionTextureVertex6;
/* 56 */     this.field_78253_h[6] = positionTextureVertex7;
/* 57 */     this.field_78253_h[7] = positionTextureVertex8;
/*    */     
/* 59 */     this.field_78254_i[0] = new TexturedQuad(new PositionTextureVertex[] { positionTextureVertex6, positionTextureVertex2, positionTextureVertex3, positionTextureVertex7 }, p_i1171_2_ + p_i1171_9_ + p_i1171_7_, p_i1171_3_ + p_i1171_9_, p_i1171_2_ + p_i1171_9_ + p_i1171_7_ + p_i1171_9_, p_i1171_3_ + p_i1171_9_ + p_i1171_8_, p_i1171_1_.field_78801_a, p_i1171_1_.field_78799_b);
/*    */ 
/*    */     
/* 62 */     this.field_78254_i[1] = new TexturedQuad(new PositionTextureVertex[] { positionTextureVertex1, positionTextureVertex5, positionTextureVertex8, positionTextureVertex4 }, p_i1171_2_, p_i1171_3_ + p_i1171_9_, p_i1171_2_ + p_i1171_9_, p_i1171_3_ + p_i1171_9_ + p_i1171_8_, p_i1171_1_.field_78801_a, p_i1171_1_.field_78799_b);
/*    */ 
/*    */ 
/*    */     
/* 66 */     this.field_78254_i[2] = new TexturedQuad(new PositionTextureVertex[] { positionTextureVertex6, positionTextureVertex5, positionTextureVertex1, positionTextureVertex2 }, p_i1171_2_ + p_i1171_9_, p_i1171_3_, p_i1171_2_ + p_i1171_9_ + p_i1171_7_, p_i1171_3_ + p_i1171_9_, p_i1171_1_.field_78801_a, p_i1171_1_.field_78799_b);
/*    */ 
/*    */     
/* 69 */     this.field_78254_i[3] = new TexturedQuad(new PositionTextureVertex[] { positionTextureVertex3, positionTextureVertex4, positionTextureVertex8, positionTextureVertex7 }, p_i1171_2_ + p_i1171_9_ + p_i1171_7_, p_i1171_3_ + p_i1171_9_, p_i1171_2_ + p_i1171_9_ + p_i1171_7_ + p_i1171_7_, p_i1171_3_, p_i1171_1_.field_78801_a, p_i1171_1_.field_78799_b);
/*    */ 
/*    */ 
/*    */     
/* 73 */     this.field_78254_i[4] = new TexturedQuad(new PositionTextureVertex[] { positionTextureVertex2, positionTextureVertex1, positionTextureVertex4, positionTextureVertex3 }, p_i1171_2_ + p_i1171_9_, p_i1171_3_ + p_i1171_9_, p_i1171_2_ + p_i1171_9_ + p_i1171_7_, p_i1171_3_ + p_i1171_9_ + p_i1171_8_, p_i1171_1_.field_78801_a, p_i1171_1_.field_78799_b);
/*    */ 
/*    */     
/* 76 */     this.field_78254_i[5] = new TexturedQuad(new PositionTextureVertex[] { positionTextureVertex5, positionTextureVertex6, positionTextureVertex7, positionTextureVertex8 }, p_i1171_2_ + p_i1171_9_ + p_i1171_7_ + p_i1171_9_, p_i1171_3_ + p_i1171_9_, p_i1171_2_ + p_i1171_9_ + p_i1171_7_ + p_i1171_9_ + p_i1171_7_, p_i1171_3_ + p_i1171_9_ + p_i1171_8_, p_i1171_1_.field_78801_a, p_i1171_1_.field_78799_b);
/*    */ 
/*    */ 
/*    */     
/* 80 */     if (p_i1171_1_.field_78809_i)
/* 81 */       for (byte b = 0; b < this.field_78254_i.length; b++)
/* 82 */         this.field_78254_i[b].func_78235_a();  
/*    */   }
/*    */   public final float field_78248_d; public final float field_78249_e; public final float field_78246_f; public String field_78247_g; private static final String __OBFID = "CL_00000872";
/*    */   
/*    */   public void func_78245_a(Tessellator p_78245_1_, float p_78245_2_) {
/* 87 */     for (byte b = 0; b < this.field_78254_i.length; b++) {
/* 88 */       this.field_78254_i[b].func_78236_a(p_78245_1_, p_78245_2_);
/*    */     }
/*    */   }
/*    */   
/*    */   public ModelBox func_78244_a(String p_78244_1_) {
/* 93 */     this.field_78247_g = p_78244_1_;
/* 94 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */