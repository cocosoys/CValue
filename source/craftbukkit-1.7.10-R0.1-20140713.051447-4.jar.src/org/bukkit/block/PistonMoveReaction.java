/*    */ package org.bukkit.block;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum PistonMoveReaction
/*    */ {
/* 11 */   MOVE(0),
/*    */ 
/*    */ 
/*    */   
/* 15 */   BREAK(1),
/*    */ 
/*    */ 
/*    */   
/* 19 */   BLOCK(2); private int id;
/*    */   
/*    */   static {
/* 22 */     byId = new HashMap<Integer, PistonMoveReaction>();
/*    */     
/* 24 */     for (PistonMoveReaction reaction : values())
/* 25 */       byId.put(Integer.valueOf(reaction.id), reaction); 
/*    */   }
/*    */   private static Map<Integer, PistonMoveReaction> byId;
/*    */   
/*    */   PistonMoveReaction(int id) {
/* 30 */     this.id = id;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public int getId() {
/* 39 */     return this.id;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public static PistonMoveReaction getById(int id) {
/* 49 */     return byId.get(Integer.valueOf(id));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\block\PistonMoveReaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */