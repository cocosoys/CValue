/*    */ package net.minecraft.realms;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.shader.TesselatorVertexState;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class Tezzelator {
/*  8 */   public static Tessellator t = Tessellator.field_78398_a;
/*    */   
/* 10 */   public static final Tezzelator instance = new Tezzelator(); private static final String __OBFID = "CL_00001855";
/*    */   
/*    */   public int end() {
/* 13 */     return t.func_78381_a();
/*    */   }
/*    */   
/*    */   public void vertex(double p_vertex_1_, double p_vertex_3_, double p_vertex_5_) {
/* 17 */     t.func_78377_a(p_vertex_1_, p_vertex_3_, p_vertex_5_);
/*    */   }
/*    */   
/*    */   public void color(float p_color_1_, float p_color_2_, float p_color_3_, float p_color_4_) {
/* 21 */     t.func_78369_a(p_color_1_, p_color_2_, p_color_3_, p_color_4_);
/*    */   }
/*    */   
/*    */   public void color(int p_color_1_, int p_color_2_, int p_color_3_) {
/* 25 */     t.func_78376_a(p_color_1_, p_color_2_, p_color_3_);
/*    */   }
/*    */   
/*    */   public void tex2(int p_tex2_1_) {
/* 29 */     t.func_78380_c(p_tex2_1_);
/*    */   }
/*    */   
/*    */   public void normal(float p_normal_1_, float p_normal_2_, float p_normal_3_) {
/* 33 */     t.func_78375_b(p_normal_1_, p_normal_2_, p_normal_3_);
/*    */   }
/*    */   
/*    */   public void noColor() {
/* 37 */     t.func_78383_c();
/*    */   }
/*    */   
/*    */   public void color(int p_color_1_) {
/* 41 */     t.func_78378_d(p_color_1_);
/*    */   }
/*    */   
/*    */   public void color(float p_color_1_, float p_color_2_, float p_color_3_) {
/* 45 */     t.func_78386_a(p_color_1_, p_color_2_, p_color_3_);
/*    */   }
/*    */   
/*    */   public TesselatorVertexState sortQuads(float p_sortQuads_1_, float p_sortQuads_2_, float p_sortQuads_3_) {
/* 49 */     return t.func_147564_a(p_sortQuads_1_, p_sortQuads_2_, p_sortQuads_3_);
/*    */   }
/*    */   
/*    */   public void restoreState(TesselatorVertexState p_restoreState_1_) {
/* 53 */     t.func_147565_a(p_restoreState_1_);
/*    */   }
/*    */   
/*    */   public void begin(int p_begin_1_) {
/* 57 */     t.func_78371_b(p_begin_1_);
/*    */   }
/*    */   
/*    */   public void begin() {
/* 61 */     t.func_78382_b();
/*    */   }
/*    */   
/*    */   public void vertexUV(double p_vertexUV_1_, double p_vertexUV_3_, double p_vertexUV_5_, double p_vertexUV_7_, double p_vertexUV_9_) {
/* 65 */     t.func_78374_a(p_vertexUV_1_, p_vertexUV_3_, p_vertexUV_5_, p_vertexUV_7_, p_vertexUV_9_);
/*    */   }
/*    */   
/*    */   public void color(int p_color_1_, int p_color_2_) {
/* 69 */     t.func_78384_a(p_color_1_, p_color_2_);
/*    */   }
/*    */   
/*    */   public void offset(double p_offset_1_, double p_offset_3_, double p_offset_5_) {
/* 73 */     t.func_78373_b(p_offset_1_, p_offset_3_, p_offset_5_);
/*    */   }
/*    */   
/*    */   public void color(int p_color_1_, int p_color_2_, int p_color_3_, int p_color_4_) {
/* 77 */     t.func_78370_a(p_color_1_, p_color_2_, p_color_3_, p_color_4_);
/*    */   }
/*    */   
/*    */   public void addOffset(float p_addOffset_1_, float p_addOffset_2_, float p_addOffset_3_) {
/* 81 */     t.func_78372_c(p_addOffset_1_, p_addOffset_2_, p_addOffset_3_);
/*    */   }
/*    */   
/*    */   public void tex(double p_tex_1_, double p_tex_3_) {
/* 85 */     t.func_78385_a(p_tex_1_, p_tex_3_);
/*    */   }
/*    */   
/*    */   public void color(byte p_color_1_, byte p_color_2_, byte p_color_3_) {
/* 89 */     t.func_154352_a(p_color_1_, p_color_2_, p_color_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\realms\Tezzelator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */