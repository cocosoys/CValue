/*    */ package net.minecraft.util;
/*    */ import org.lwjgl.input.Mouse;
/*    */ import org.lwjgl.opengl.Display;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MouseHelper {
/*    */   public int field_74377_a;
/*    */   
/*    */   public void func_74372_a() {
/* 10 */     Mouse.setGrabbed(true);
/* 11 */     this.field_74377_a = 0;
/* 12 */     this.field_74375_b = 0;
/*    */   }
/*    */   public int field_74375_b; private static final String __OBFID = "CL_00000648";
/*    */   public void func_74373_b() {
/* 16 */     Mouse.setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2);
/* 17 */     Mouse.setGrabbed(false);
/*    */   }
/*    */   
/*    */   public void func_74374_c() {
/* 21 */     this.field_74377_a = Mouse.getDX();
/* 22 */     this.field_74375_b = Mouse.getDY();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\MouseHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */