/*    */ package net.minecraft.client.renderer;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.FloatBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GLAllocation {
/* 12 */   private static final Map field_74531_a = new HashMap<Object, Object>();
/* 13 */   private static final List field_74530_b = new ArrayList(); private static final String __OBFID = "CL_00000630";
/*    */   
/*    */   public static synchronized int func_74526_a(int p_74526_0_) {
/* 16 */     int i = GL11.glGenLists(p_74526_0_);
/* 17 */     field_74531_a.put(Integer.valueOf(i), Integer.valueOf(p_74526_0_));
/*    */     
/* 19 */     return i;
/*    */   }
/*    */   
/*    */   public static synchronized void func_74523_b(int p_74523_0_) {
/* 23 */     GL11.glDeleteLists(p_74523_0_, ((Integer)field_74531_a.remove(Integer.valueOf(p_74523_0_))).intValue());
/*    */   }
/*    */   
/*    */   public static synchronized void func_74525_a() {
/* 27 */     for (Map.Entry entry : field_74531_a.entrySet()) {
/* 28 */       GL11.glDeleteLists(((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/*    */     }
/* 30 */     field_74531_a.clear();
/*    */   }
/*    */   
/*    */   public static synchronized ByteBuffer func_74524_c(int p_74524_0_) {
/* 34 */     return ByteBuffer.allocateDirect(p_74524_0_).order(ByteOrder.nativeOrder());
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
/*    */   public static IntBuffer func_74527_f(int p_74527_0_) {
/* 46 */     return func_74524_c(p_74527_0_ << 2).asIntBuffer();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static FloatBuffer func_74529_h(int p_74529_0_) {
/* 54 */     return func_74524_c(p_74529_0_ << 2).asFloatBuffer();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\GLAllocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */