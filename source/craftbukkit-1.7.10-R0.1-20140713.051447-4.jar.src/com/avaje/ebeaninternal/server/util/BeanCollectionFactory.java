/*    */ package com.avaje.ebeaninternal.server.util;
/*    */ 
/*    */ import com.avaje.ebean.Query;
/*    */ import com.avaje.ebean.bean.BeanCollection;
/*    */ import com.avaje.ebean.common.BeanList;
/*    */ import com.avaje.ebean.common.BeanMap;
/*    */ import com.avaje.ebean.common.BeanSet;
/*    */ import java.util.ArrayList;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.LinkedHashSet;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BeanCollectionFactory
/*    */ {
/*    */   private static final int defaultListInitialCapacity = 20;
/*    */   private static final int defaultSetInitialCapacity = 32;
/*    */   private static final int defaultMapInitialCapacity = 32;
/*    */   
/*    */   private static class BeanCollectionFactoryHolder
/*    */   {
/* 41 */     private static BeanCollectionFactory me = new BeanCollectionFactory();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private BeanCollectionFactory() {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static BeanCollection<?> create(BeanCollectionParams params) {
/* 56 */     return BeanCollectionFactoryHolder.me.createMany(params);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private BeanCollection<?> createMany(BeanCollectionParams params) {
/* 62 */     Query.Type manyType = params.getManyType();
/* 63 */     switch (manyType) {
/*    */       case MAP:
/* 65 */         return (BeanCollection<?>)createMap(params);
/*    */       case LIST:
/* 67 */         return (BeanCollection<?>)createList(params);
/*    */       case SET:
/* 69 */         return (BeanCollection<?>)createSet(params);
/*    */     } 
/*    */     
/* 72 */     throw new RuntimeException("Invalid Arg " + manyType);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private BeanMap createMap(BeanCollectionParams params) {
/* 80 */     return new BeanMap(new LinkedHashMap<Object, Object>(32));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private BeanSet createSet(BeanCollectionParams params) {
/* 86 */     return new BeanSet(new LinkedHashSet(32));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private BeanList createList(BeanCollectionParams params) {
/* 92 */     return new BeanList(new ArrayList(20));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\serve\\util\BeanCollectionFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */