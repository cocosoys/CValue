/*    */ package net.minecraft.client.renderer;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.nio.FloatBuffer;
/*    */ import net.minecraft.util.Vec3;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderHelper {
/* 10 */   private static FloatBuffer field_74522_a = GLAllocation.func_74529_h(16);
/* 11 */   private static final Vec3 field_82884_b = Vec3.func_72443_a(0.20000000298023224D, 1.0D, -0.699999988079071D).func_72432_b();
/* 12 */   private static final Vec3 field_82885_c = Vec3.func_72443_a(-0.20000000298023224D, 1.0D, 0.699999988079071D).func_72432_b(); private static final String __OBFID = "CL_00000629";
/*    */   
/*    */   public static void func_74518_a() {
/* 15 */     GL11.glDisable(2896);
/* 16 */     GL11.glDisable(16384);
/* 17 */     GL11.glDisable(16385);
/* 18 */     GL11.glDisable(2903);
/*    */   }
/*    */   
/*    */   public static void func_74519_b() {
/* 22 */     GL11.glEnable(2896);
/* 23 */     GL11.glEnable(16384);
/* 24 */     GL11.glEnable(16385);
/* 25 */     GL11.glEnable(2903);
/* 26 */     GL11.glColorMaterial(1032, 5634);
/* 27 */     float f1 = 0.4F;
/* 28 */     float f2 = 0.6F;
/* 29 */     float f3 = 0.0F;
/*    */     
/* 31 */     GL11.glLight(16384, 4611, func_74517_a(field_82884_b.field_72450_a, field_82884_b.field_72448_b, field_82884_b.field_72449_c, 0.0D));
/* 32 */     GL11.glLight(16384, 4609, func_74521_a(f2, f2, f2, 1.0F));
/* 33 */     GL11.glLight(16384, 4608, func_74521_a(0.0F, 0.0F, 0.0F, 1.0F));
/* 34 */     GL11.glLight(16384, 4610, func_74521_a(f3, f3, f3, 1.0F));
/*    */     
/* 36 */     GL11.glLight(16385, 4611, func_74517_a(field_82885_c.field_72450_a, field_82885_c.field_72448_b, field_82885_c.field_72449_c, 0.0D));
/* 37 */     GL11.glLight(16385, 4609, func_74521_a(f2, f2, f2, 1.0F));
/* 38 */     GL11.glLight(16385, 4608, func_74521_a(0.0F, 0.0F, 0.0F, 1.0F));
/* 39 */     GL11.glLight(16385, 4610, func_74521_a(f3, f3, f3, 1.0F));
/*    */     
/* 41 */     GL11.glShadeModel(7424);
/* 42 */     GL11.glLightModel(2899, func_74521_a(f1, f1, f1, 1.0F));
/*    */   }
/*    */   
/*    */   private static FloatBuffer func_74517_a(double p_74517_0_, double p_74517_2_, double p_74517_4_, double p_74517_6_) {
/* 46 */     return func_74521_a((float)p_74517_0_, (float)p_74517_2_, (float)p_74517_4_, (float)p_74517_6_);
/*    */   }
/*    */   
/*    */   private static FloatBuffer func_74521_a(float p_74521_0_, float p_74521_1_, float p_74521_2_, float p_74521_3_) {
/* 50 */     field_74522_a.clear();
/* 51 */     field_74522_a.put(p_74521_0_).put(p_74521_1_).put(p_74521_2_).put(p_74521_3_);
/* 52 */     field_74522_a.flip();
/* 53 */     return field_74522_a;
/*    */   }
/*    */   
/*    */   public static void func_74520_c() {
/* 57 */     GL11.glPushMatrix();
/* 58 */     GL11.glRotatef(-30.0F, 0.0F, 1.0F, 0.0F);
/* 59 */     GL11.glRotatef(165.0F, 1.0F, 0.0F, 0.0F);
/* 60 */     func_74519_b();
/* 61 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\RenderHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */