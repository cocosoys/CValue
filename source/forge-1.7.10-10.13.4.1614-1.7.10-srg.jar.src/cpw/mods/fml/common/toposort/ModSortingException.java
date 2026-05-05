/*    */ package cpw.mods.fml.common.toposort;
/*    */ 
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModSortingException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private SortingExceptionData<?> sortingExceptionData;
/*    */   
/*    */   public class SortingExceptionData<T>
/*    */   {
/*    */     private T firstBadNode;
/*    */     private Set<T> visitedNodes;
/*    */     
/*    */     public SortingExceptionData(T node, Set<T> visitedNodes) {
/* 25 */       this.firstBadNode = node;
/* 26 */       this.visitedNodes = visitedNodes;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public T getFirstBadNode() {
/* 34 */       return this.firstBadNode;
/*    */     }
/*    */     
/*    */     public Set<T> getVisitedNodes() {
/* 38 */       return this.visitedNodes;
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public <T> ModSortingException(String string, T node, Set<T> visitedNodes) {
/* 46 */     super(string);
/* 47 */     this.sortingExceptionData = new SortingExceptionData(node, visitedNodes);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public <T> SortingExceptionData<T> getExceptionData() {
/* 53 */     return (SortingExceptionData)this.sortingExceptionData;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\toposort\ModSortingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */