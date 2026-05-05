/*    */ package org.yaml.snakeyaml.util;
/*    */ 
/*    */ import java.util.ArrayList;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArrayStack<T>
/*    */ {
/*    */   private ArrayList<T> stack;
/*    */   
/*    */   public ArrayStack(int initSize) {
/* 25 */     this.stack = new ArrayList<T>(initSize);
/*    */   }
/*    */   
/*    */   public void push(T obj) {
/* 29 */     this.stack.add(obj);
/*    */   }
/*    */   
/*    */   public T pop() {
/* 33 */     return this.stack.remove(this.stack.size() - 1);
/*    */   }
/*    */   
/*    */   public boolean isEmpty() {
/* 37 */     return this.stack.isEmpty();
/*    */   }
/*    */   
/*    */   public void clear() {
/* 41 */     this.stack.clear();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyam\\util\ArrayStack.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */