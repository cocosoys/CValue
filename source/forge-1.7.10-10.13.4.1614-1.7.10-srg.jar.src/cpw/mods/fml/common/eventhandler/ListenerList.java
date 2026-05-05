/*     */ package cpw.mods.fml.common.eventhandler;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.UnmodifiableIterator;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ListenerList {
/*   9 */   private static ImmutableList<ListenerList> allLists = ImmutableList.of();
/*  10 */   private static int maxSize = 0;
/*     */   
/*     */   private ListenerList parent;
/*  13 */   private ListenerListInst[] lists = new ListenerListInst[0];
/*     */ 
/*     */   
/*     */   public ListenerList() {
/*  17 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ListenerList(ListenerList parent) {
/*  23 */     this.parent = parent;
/*  24 */     extendMasterList(this);
/*  25 */     resizeLists(maxSize);
/*     */   }
/*     */ 
/*     */   
/*     */   private static synchronized void extendMasterList(ListenerList inst) {
/*  30 */     ImmutableList.Builder<ListenerList> builder = ImmutableList.builder();
/*  31 */     builder.addAll((Iterable)allLists);
/*  32 */     builder.add(inst);
/*  33 */     allLists = builder.build();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void resize(int max) {
/*  38 */     if (max <= maxSize) {
/*     */       return;
/*     */     }
/*     */     
/*  42 */     for (UnmodifiableIterator<ListenerList> unmodifiableIterator = allLists.iterator(); unmodifiableIterator.hasNext(); ) { ListenerList list = unmodifiableIterator.next();
/*     */       
/*  44 */       list.resizeLists(max); }
/*     */     
/*  46 */     maxSize = max;
/*     */   }
/*     */ 
/*     */   
/*     */   public void resizeLists(int max) {
/*  51 */     if (this.parent != null)
/*     */     {
/*  53 */       this.parent.resizeLists(max);
/*     */     }
/*     */     
/*  56 */     if (this.lists.length >= max) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  61 */     ListenerListInst[] newList = new ListenerListInst[max];
/*  62 */     int x = 0;
/*  63 */     for (; x < this.lists.length; x++)
/*     */     {
/*  65 */       newList[x] = this.lists[x];
/*     */     }
/*  67 */     for (; x < max; x++) {
/*     */       
/*  69 */       if (this.parent != null) {
/*     */         
/*  71 */         newList[x] = new ListenerListInst(this.parent.getInstance(x));
/*     */       }
/*     */       else {
/*     */         
/*  75 */         newList[x] = new ListenerListInst();
/*     */       } 
/*     */     } 
/*  78 */     this.lists = newList;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void clearBusID(int id) {
/*  83 */     for (UnmodifiableIterator<ListenerList> unmodifiableIterator = allLists.iterator(); unmodifiableIterator.hasNext(); ) { ListenerList list = unmodifiableIterator.next();
/*     */       
/*  85 */       list.lists[id].dispose(); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   protected ListenerListInst getInstance(int id) {
/*  91 */     return this.lists[id];
/*     */   }
/*     */ 
/*     */   
/*     */   public IEventListener[] getListeners(int id) {
/*  96 */     return this.lists[id].getListeners();
/*     */   }
/*     */ 
/*     */   
/*     */   public void register(int id, EventPriority priority, IEventListener listener) {
/* 101 */     this.lists[id].register(priority, listener);
/*     */   }
/*     */ 
/*     */   
/*     */   public void unregister(int id, IEventListener listener) {
/* 106 */     this.lists[id].unregister(listener);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void unregisterAll(int id, IEventListener listener) {
/* 111 */     for (UnmodifiableIterator<ListenerList> unmodifiableIterator = allLists.iterator(); unmodifiableIterator.hasNext(); ) { ListenerList list = unmodifiableIterator.next();
/*     */       
/* 113 */       list.unregister(id, listener); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   private class ListenerListInst
/*     */   {
/*     */     private boolean rebuild = true;
/*     */     private IEventListener[] listeners;
/*     */     private ArrayList<ArrayList<IEventListener>> priorities;
/*     */     private ListenerListInst parent;
/*     */     
/*     */     private ListenerListInst() {
/* 126 */       int count = (EventPriority.values()).length;
/* 127 */       this.priorities = new ArrayList<ArrayList<IEventListener>>(count);
/*     */       
/* 129 */       for (int x = 0; x < count; x++)
/*     */       {
/* 131 */         this.priorities.add(new ArrayList<IEventListener>());
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void dispose() {
/* 137 */       for (ArrayList<IEventListener> listeners : this.priorities)
/*     */       {
/* 139 */         listeners.clear();
/*     */       }
/* 141 */       this.priorities.clear();
/* 142 */       this.parent = null;
/* 143 */       this.listeners = null;
/*     */     }
/*     */ 
/*     */     
/*     */     private ListenerListInst(ListenerListInst parent) {
/* 148 */       this();
/* 149 */       this.parent = parent;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ArrayList<IEventListener> getListeners(EventPriority priority) {
/* 163 */       ArrayList<IEventListener> ret = new ArrayList<IEventListener>(this.priorities.get(priority.ordinal()));
/* 164 */       if (this.parent != null)
/*     */       {
/* 166 */         ret.addAll(this.parent.getListeners(priority));
/*     */       }
/* 168 */       return ret;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IEventListener[] getListeners() {
/* 183 */       if (shouldRebuild()) buildCache(); 
/* 184 */       return this.listeners;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean shouldRebuild() {
/* 189 */       return (this.rebuild || (this.parent != null && this.parent.shouldRebuild()));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void buildCache() {
/* 197 */       if (this.parent != null && this.parent.shouldRebuild())
/*     */       {
/* 199 */         this.parent.buildCache();
/*     */       }
/*     */       
/* 202 */       ArrayList<IEventListener> ret = new ArrayList<IEventListener>();
/* 203 */       for (EventPriority value : EventPriority.values()) {
/*     */         
/* 205 */         List<IEventListener> listeners = getListeners(value);
/* 206 */         if (listeners.size() > 0) {
/*     */           
/* 208 */           ret.add(value);
/* 209 */           ret.addAll(listeners);
/*     */         } 
/*     */       } 
/* 212 */       this.listeners = ret.<IEventListener>toArray(new IEventListener[ret.size()]);
/* 213 */       this.rebuild = false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void register(EventPriority priority, IEventListener listener) {
/* 218 */       ((ArrayList<IEventListener>)this.priorities.get(priority.ordinal())).add(listener);
/* 219 */       this.rebuild = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void unregister(IEventListener listener) {
/* 224 */       for (ArrayList<IEventListener> list : this.priorities) {
/*     */         
/* 226 */         if (list.remove(listener))
/*     */         {
/* 228 */           this.rebuild = true;
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\eventhandler\ListenerList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */