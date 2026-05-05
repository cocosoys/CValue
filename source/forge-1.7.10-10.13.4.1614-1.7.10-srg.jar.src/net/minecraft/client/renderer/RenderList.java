/*    */ package net.minecraft.client.renderer;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderList {
/*    */   public int field_78429_a;
/*    */   public int field_78427_b;
/*    */   public int field_78428_c;
/*    */   private double field_78425_d;
/*    */   private double field_78426_e;
/*    */   private double field_78423_f;
/* 16 */   private IntBuffer field_78424_g = GLAllocation.func_74527_f(65536);
/*    */   private boolean field_78430_h;
/*    */   private boolean field_78431_i;
/*    */   private static final String __OBFID = "CL_00000957";
/*    */   
/*    */   public void func_78422_a(int p_78422_1_, int p_78422_2_, int p_78422_3_, double p_78422_4_, double p_78422_6_, double p_78422_8_) {
/* 22 */     this.field_78430_h = true;
/* 23 */     this.field_78424_g.clear();
/* 24 */     this.field_78429_a = p_78422_1_;
/* 25 */     this.field_78427_b = p_78422_2_;
/* 26 */     this.field_78428_c = p_78422_3_;
/*    */     
/* 28 */     this.field_78425_d = p_78422_4_;
/* 29 */     this.field_78426_e = p_78422_6_;
/* 30 */     this.field_78423_f = p_78422_8_;
/*    */   }
/*    */   
/*    */   public boolean func_78418_a(int p_78418_1_, int p_78418_2_, int p_78418_3_) {
/* 34 */     if (!this.field_78430_h) return false; 
/* 35 */     return (p_78418_1_ == this.field_78429_a && p_78418_2_ == this.field_78427_b && p_78418_3_ == this.field_78428_c);
/*    */   }
/*    */   
/*    */   public void func_78420_a(int p_78420_1_) {
/* 39 */     this.field_78424_g.put(p_78420_1_);
/* 40 */     if (this.field_78424_g.remaining() == 0) func_78419_a(); 
/*    */   }
/*    */   
/*    */   public void func_78419_a() {
/* 44 */     if (!this.field_78430_h)
/* 45 */       return;  if (!this.field_78431_i) {
/* 46 */       this.field_78424_g.flip();
/* 47 */       this.field_78431_i = true;
/*    */     } 
/* 49 */     if (this.field_78424_g.remaining() > 0) {
/* 50 */       GL11.glPushMatrix();
/* 51 */       GL11.glTranslatef((float)(this.field_78429_a - this.field_78425_d), (float)(this.field_78427_b - this.field_78426_e), (float)(this.field_78428_c - this.field_78423_f));
/* 52 */       GL11.glCallLists(this.field_78424_g);
/* 53 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void func_78421_b() {
/* 58 */     this.field_78430_h = false;
/* 59 */     this.field_78431_i = false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\RenderList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */