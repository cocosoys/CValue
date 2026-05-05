/*    */ package net.minecraftforge.common.util;
/*    */ 
/*    */ 
/*    */ public enum ForgeDirection
/*    */ {
/*  6 */   DOWN(0, -1, 0),
/*    */ 
/*    */   
/*  9 */   UP(0, 1, 0),
/*    */ 
/*    */   
/* 12 */   NORTH(0, 0, -1),
/*    */ 
/*    */   
/* 15 */   SOUTH(0, 0, 1),
/*    */ 
/*    */   
/* 18 */   WEST(-1, 0, 0),
/*    */ 
/*    */   
/* 21 */   EAST(1, 0, 0),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 26 */   UNKNOWN(0, 0, 0);
/*    */   public final int offsetX;
/*    */   public final int offsetY;
/*    */   public final int offsetZ;
/*    */   
/*    */   static {
/* 32 */     VALID_DIRECTIONS = new ForgeDirection[] { DOWN, UP, NORTH, SOUTH, WEST, EAST };
/* 33 */     OPPOSITES = new int[] { 1, 0, 3, 2, 5, 4, 6 };
/*    */     
/* 35 */     ROTATION_MATRIX = new int[][] { { 0, 1, 4, 5, 3, 2, 6 }, { 0, 1, 5, 4, 2, 3, 6 }, { 5, 4, 2, 3, 0, 1, 6 }, { 4, 5, 2, 3, 1, 0, 6 }, { 2, 3, 1, 0, 4, 5, 6 }, { 3, 2, 0, 1, 4, 5, 6 }, { 0, 1, 2, 3, 4, 5, 6 } };
/*    */   }
/*    */ 
/*    */   
/*    */   public final int flag;
/*    */   
/*    */   public static final ForgeDirection[] VALID_DIRECTIONS;
/*    */   
/*    */   public static final int[] OPPOSITES;
/*    */   public static final int[][] ROTATION_MATRIX;
/*    */   
/*    */   ForgeDirection(int x, int y, int z) {
/* 47 */     this.offsetX = x;
/* 48 */     this.offsetY = y;
/* 49 */     this.offsetZ = z;
/* 50 */     this.flag = 1 << ordinal();
/*    */   }
/*    */ 
/*    */   
/*    */   public static ForgeDirection getOrientation(int id) {
/* 55 */     if (id >= 0 && id < VALID_DIRECTIONS.length)
/*    */     {
/* 57 */       return VALID_DIRECTIONS[id];
/*    */     }
/* 59 */     return UNKNOWN;
/*    */   }
/*    */ 
/*    */   
/*    */   public ForgeDirection getOpposite() {
/* 64 */     return getOrientation(OPPOSITES[ordinal()]);
/*    */   }
/*    */ 
/*    */   
/*    */   public ForgeDirection getRotation(ForgeDirection axis) {
/* 69 */     return getOrientation(ROTATION_MATRIX[axis.ordinal()][ordinal()]);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\commo\\util\ForgeDirection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */