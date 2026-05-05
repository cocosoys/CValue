/*     */ package com.avaje.ebean.common;
/*     */ 
/*     */ import com.avaje.ebean.bean.BeanCollectionAdd;
/*     */ import com.avaje.ebean.bean.BeanCollectionLoader;
/*     */ import com.avaje.ebean.bean.SerializeControl;
/*     */ import java.io.ObjectStreamException;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Set;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class BeanSet<E>
/*     */   extends AbstractBeanCollection<E>
/*     */   implements Set<E>, BeanCollectionAdd
/*     */ {
/*     */   private Set<E> set;
/*     */   
/*     */   public BeanSet(Set<E> set) {
/*  47 */     this.set = set;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BeanSet() {
/*  54 */     this(new LinkedHashSet<E>());
/*     */   }
/*     */   
/*     */   public BeanSet(BeanCollectionLoader loader, Object ownerBean, String propertyName) {
/*  58 */     super(loader, ownerBean, propertyName);
/*     */   }
/*     */ 
/*     */   
/*     */   Object readResolve() throws ObjectStreamException {
/*  63 */     if (SerializeControl.isVanillaCollections()) {
/*  64 */       return this.set;
/*     */     }
/*  66 */     return this;
/*     */   }
/*     */   
/*     */   Object writeReplace() throws ObjectStreamException {
/*  70 */     if (SerializeControl.isVanillaCollections()) {
/*  71 */       return this.set;
/*     */     }
/*  73 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addBean(Object bean) {
/*  78 */     this.set.add((E)bean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void internalAdd(Object bean) {
/*  83 */     this.set.add((E)bean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPopulated() {
/*  90 */     return (this.set != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReference() {
/*  98 */     return (this.set == null);
/*     */   }
/*     */   
/*     */   public boolean checkEmptyLazyLoad() {
/* 102 */     if (this.set == null) {
/* 103 */       this.set = new LinkedHashSet<E>();
/* 104 */       return true;
/*     */     } 
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void initClear() {
/* 111 */     synchronized (this) {
/* 112 */       if (this.set == null) {
/* 113 */         if (this.modifyListening) {
/* 114 */           lazyLoadCollection(true);
/*     */         } else {
/* 116 */           this.set = new LinkedHashSet<E>();
/*     */         } 
/*     */       }
/* 119 */       touched();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void init() {
/* 124 */     synchronized (this) {
/* 125 */       if (this.set == null) {
/* 126 */         lazyLoadCollection(true);
/*     */       }
/* 128 */       touched();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActualSet(Set<?> set) {
/* 137 */     this.set = (Set)set;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<E> getActualSet() {
/* 144 */     return this.set;
/*     */   }
/*     */   
/*     */   public Collection<E> getActualDetails() {
/* 148 */     return this.set;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getActualCollection() {
/* 155 */     return this.set;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 160 */     StringBuffer sb = new StringBuffer();
/* 161 */     sb.append("BeanSet ");
/* 162 */     if (isSharedInstance()) {
/* 163 */       sb.append("sharedInstance ");
/* 164 */     } else if (isReadOnly()) {
/* 165 */       sb.append("readOnly ");
/*     */     } 
/* 167 */     if (this.set == null) {
/* 168 */       sb.append("deferred ");
/*     */     } else {
/*     */       
/* 171 */       sb.append("size[").append(this.set.size()).append("]");
/* 172 */       sb.append(" hasMoreRows[").append(this.hasMoreRows).append("]");
/* 173 */       sb.append(" set").append(this.set);
/*     */     } 
/* 175 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 182 */     init();
/* 183 */     return this.set.equals(obj);
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 187 */     init();
/* 188 */     return this.set.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(E o) {
/* 197 */     checkReadOnly();
/* 198 */     init();
/* 199 */     if (this.modifyAddListening) {
/* 200 */       if (this.set.add(o)) {
/* 201 */         modifyAddition(o);
/* 202 */         return true;
/*     */       } 
/* 204 */       return false;
/*     */     } 
/*     */     
/* 207 */     return this.set.add(o);
/*     */   }
/*     */   
/*     */   public boolean addAll(Collection<? extends E> c) {
/* 211 */     checkReadOnly();
/* 212 */     init();
/* 213 */     if (this.modifyAddListening) {
/* 214 */       boolean changed = false;
/* 215 */       Iterator<? extends E> it = c.iterator();
/* 216 */       while (it.hasNext()) {
/* 217 */         E o = it.next();
/* 218 */         if (this.set.add(o)) {
/* 219 */           modifyAddition(o);
/* 220 */           changed = true;
/*     */         } 
/*     */       } 
/* 223 */       return changed;
/*     */     } 
/* 225 */     return this.set.addAll(c);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 229 */     checkReadOnly();
/* 230 */     initClear();
/* 231 */     if (this.modifyRemoveListening) {
/* 232 */       Iterator<E> it = this.set.iterator();
/* 233 */       while (it.hasNext()) {
/* 234 */         E e = it.next();
/* 235 */         modifyRemoval(e);
/*     */       } 
/*     */     } 
/* 238 */     this.set.clear();
/*     */   }
/*     */   
/*     */   public boolean contains(Object o) {
/* 242 */     init();
/* 243 */     return this.set.contains(o);
/*     */   }
/*     */   
/*     */   public boolean containsAll(Collection<?> c) {
/* 247 */     init();
/* 248 */     return this.set.containsAll(c);
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 252 */     init();
/* 253 */     return this.set.isEmpty();
/*     */   }
/*     */   
/*     */   public Iterator<E> iterator() {
/* 257 */     init();
/* 258 */     if (isReadOnly()) {
/* 259 */       return new ReadOnlyIterator<E>(this.set.iterator());
/*     */     }
/* 261 */     if (this.modifyListening) {
/* 262 */       return new ModifyIterator<E>(this, this.set.iterator());
/*     */     }
/* 264 */     return this.set.iterator();
/*     */   }
/*     */   
/*     */   public boolean remove(Object o) {
/* 268 */     checkReadOnly();
/* 269 */     init();
/* 270 */     if (this.modifyRemoveListening) {
/* 271 */       if (this.set.remove(o)) {
/* 272 */         modifyRemoval(o);
/* 273 */         return true;
/*     */       } 
/* 275 */       return false;
/*     */     } 
/* 277 */     return this.set.remove(o);
/*     */   }
/*     */   
/*     */   public boolean removeAll(Collection<?> c) {
/* 281 */     checkReadOnly();
/* 282 */     init();
/* 283 */     if (this.modifyRemoveListening) {
/* 284 */       boolean changed = false;
/* 285 */       Iterator<?> it = c.iterator();
/* 286 */       while (it.hasNext()) {
/* 287 */         Object o = it.next();
/* 288 */         if (this.set.remove(o)) {
/* 289 */           modifyRemoval(o);
/* 290 */           changed = true;
/*     */         } 
/*     */       } 
/* 293 */       return changed;
/*     */     } 
/* 295 */     return this.set.removeAll(c);
/*     */   }
/*     */   
/*     */   public boolean retainAll(Collection<?> c) {
/* 299 */     checkReadOnly();
/* 300 */     init();
/* 301 */     if (this.modifyRemoveListening) {
/* 302 */       boolean changed = false;
/* 303 */       Iterator<?> it = this.set.iterator();
/* 304 */       while (it.hasNext()) {
/* 305 */         Object o = it.next();
/* 306 */         if (!c.contains(o)) {
/* 307 */           it.remove();
/* 308 */           modifyRemoval(o);
/* 309 */           changed = true;
/*     */         } 
/*     */       } 
/* 312 */       return changed;
/*     */     } 
/* 314 */     return this.set.retainAll(c);
/*     */   }
/*     */   
/*     */   public int size() {
/* 318 */     init();
/* 319 */     return this.set.size();
/*     */   }
/*     */   
/*     */   public Object[] toArray() {
/* 323 */     init();
/* 324 */     return this.set.toArray();
/*     */   }
/*     */   
/*     */   public <T> T[] toArray(T[] a) {
/* 328 */     init();
/* 329 */     return this.set.toArray(a);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class ReadOnlyIterator<E>
/*     */     implements Iterator<E>, Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 2577697326745352605L;
/*     */     private final Iterator<E> it;
/*     */     
/*     */     ReadOnlyIterator(Iterator<E> it) {
/* 340 */       this.it = it;
/*     */     }
/*     */     public boolean hasNext() {
/* 343 */       return this.it.hasNext();
/*     */     }
/*     */     
/*     */     public E next() {
/* 347 */       return this.it.next();
/*     */     }
/*     */     
/*     */     public void remove() {
/* 351 */       throw new IllegalStateException("This collection is in ReadOnly mode");
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\common\BeanSet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */