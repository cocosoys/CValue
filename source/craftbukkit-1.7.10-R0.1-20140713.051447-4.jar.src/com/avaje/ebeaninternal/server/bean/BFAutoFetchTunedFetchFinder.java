/*    */ package com.avaje.ebeaninternal.server.bean;
/*    */ 
/*    */ import com.avaje.ebean.Query;
/*    */ import com.avaje.ebean.bean.BeanCollection;
/*    */ import com.avaje.ebean.common.BeanList;
/*    */ import com.avaje.ebean.event.BeanFinder;
/*    */ import com.avaje.ebean.event.BeanQueryRequest;
/*    */ import com.avaje.ebean.meta.MetaAutoFetchTunedQueryInfo;
/*    */ import com.avaje.ebeaninternal.api.SpiEbeanServer;
/*    */ import com.avaje.ebeaninternal.api.SpiQuery;
/*    */ import com.avaje.ebeaninternal.server.autofetch.AutoFetchManager;
/*    */ import com.avaje.ebeaninternal.server.autofetch.TunedQueryInfo;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import javax.persistence.PersistenceException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BFAutoFetchTunedFetchFinder
/*    */   implements BeanFinder<MetaAutoFetchTunedQueryInfo>
/*    */ {
/*    */   public MetaAutoFetchTunedQueryInfo find(BeanQueryRequest<MetaAutoFetchTunedQueryInfo> request) {
/* 26 */     SpiQuery<?> query = (SpiQuery)request.getQuery();
/*    */     try {
/* 28 */       String queryPointKey = (String)query.getId();
/*    */       
/* 30 */       SpiEbeanServer server = (SpiEbeanServer)request.getEbeanServer();
/* 31 */       AutoFetchManager manager = server.getAutoFetchManager();
/*    */       
/* 33 */       TunedQueryInfo tunedFetch = manager.getTunedQueryInfo(queryPointKey);
/* 34 */       if (tunedFetch != null) {
/* 35 */         return tunedFetch.createPublicMeta();
/*    */       }
/* 37 */       return null;
/*    */     
/*    */     }
/* 40 */     catch (Exception e) {
/* 41 */       throw new PersistenceException(e);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BeanCollection<MetaAutoFetchTunedQueryInfo> findMany(BeanQueryRequest<MetaAutoFetchTunedQueryInfo> request) {
/* 50 */     Query.Type queryType = request.getQuery().getType();
/* 51 */     if (!queryType.equals(Query.Type.LIST)) {
/* 52 */       throw new PersistenceException("Only findList() supported at this stage.");
/*    */     }
/*    */     
/* 55 */     SpiEbeanServer server = (SpiEbeanServer)request.getEbeanServer();
/* 56 */     AutoFetchManager manager = server.getAutoFetchManager();
/*    */     
/* 58 */     BeanList<MetaAutoFetchTunedQueryInfo> list = new BeanList();
/*    */     
/* 60 */     Iterator<TunedQueryInfo> it = manager.iterateTunedQueryInfo();
/* 61 */     while (it.hasNext()) {
/* 62 */       TunedQueryInfo tunedFetch = it.next();
/*    */       
/* 64 */       list.add(tunedFetch.createPublicMeta());
/*    */     } 
/*    */     
/* 67 */     String orderBy = request.getQuery().order().toStringFormat();
/* 68 */     if (orderBy == null) {
/* 69 */       orderBy = "beanType, origQueryPlanHash";
/*    */     }
/* 71 */     server.sort((List)list, orderBy);
/*    */ 
/*    */     
/* 74 */     return (BeanCollection<MetaAutoFetchTunedQueryInfo>)list;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\bean\BFAutoFetchTunedFetchFinder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */