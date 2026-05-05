/*     */ package cpw.mods.fml.common.toposort;
/*     */ 
/*     */ import com.google.common.collect.Sets;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import java.util.SortedSet;
/*     */ import java.util.TreeSet;
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
/*     */ public class TopologicalSort
/*     */ {
/*     */   public static class DirectedGraph<T>
/*     */     implements Iterable<T>
/*     */   {
/*  44 */     private final Map<T, SortedSet<T>> graph = new HashMap<T, SortedSet<T>>();
/*  45 */     private List<T> orderedNodes = new ArrayList<T>();
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean addNode(T node) {
/*  50 */       if (this.graph.containsKey(node))
/*     */       {
/*  52 */         return false;
/*     */       }
/*     */       
/*  55 */       this.orderedNodes.add(node);
/*  56 */       this.graph.put(node, new TreeSet<T>(new Comparator<T>()
/*     */             {
/*     */               public int compare(T o1, T o2)
/*     */               {
/*  60 */                 return TopologicalSort.DirectedGraph.this.orderedNodes.indexOf(o1) - TopologicalSort.DirectedGraph.this.orderedNodes.indexOf(o2);
/*     */               }
/*     */             }));
/*  63 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void addEdge(T from, T to) {
/*  68 */       if (!this.graph.containsKey(from) || !this.graph.containsKey(to))
/*     */       {
/*  70 */         throw new NoSuchElementException("Missing nodes from graph");
/*     */       }
/*     */       
/*  73 */       ((SortedSet<T>)this.graph.get(from)).add(to);
/*     */     }
/*     */ 
/*     */     
/*     */     public void removeEdge(T from, T to) {
/*  78 */       if (!this.graph.containsKey(from) || !this.graph.containsKey(to))
/*     */       {
/*  80 */         throw new NoSuchElementException("Missing nodes from graph");
/*     */       }
/*     */       
/*  83 */       ((SortedSet)this.graph.get(from)).remove(to);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean edgeExists(T from, T to) {
/*  88 */       if (!this.graph.containsKey(from) || !this.graph.containsKey(to))
/*     */       {
/*  90 */         throw new NoSuchElementException("Missing nodes from graph");
/*     */       }
/*     */       
/*  93 */       return ((SortedSet)this.graph.get(from)).contains(to);
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<T> edgesFrom(T from) {
/*  98 */       if (!this.graph.containsKey(from))
/*     */       {
/* 100 */         throw new NoSuchElementException("Missing node from graph");
/*     */       }
/*     */       
/* 103 */       return Collections.unmodifiableSortedSet(this.graph.get(from));
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<T> iterator() {
/* 108 */       return this.orderedNodes.iterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 113 */       return this.graph.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 118 */       return this.graph.isEmpty();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 124 */       return this.graph.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> List<T> topologicalSort(DirectedGraph<T> graph) {
/* 137 */     DirectedGraph<T> rGraph = reverse(graph);
/* 138 */     List<T> sortedResult = new ArrayList<T>();
/* 139 */     Set<T> visitedNodes = new HashSet<T>();
/*     */     
/* 141 */     Set<T> expandedNodes = new HashSet<T>();
/*     */     
/* 143 */     for (T node : rGraph)
/*     */     {
/* 145 */       explore(node, rGraph, sortedResult, visitedNodes, expandedNodes);
/*     */     }
/*     */     
/* 148 */     return sortedResult;
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T> DirectedGraph<T> reverse(DirectedGraph<T> graph) {
/* 153 */     DirectedGraph<T> result = new DirectedGraph<T>();
/*     */     
/* 155 */     for (T node : graph)
/*     */     {
/* 157 */       result.addNode(node);
/*     */     }
/*     */     
/* 160 */     for (T from : graph) {
/*     */       
/* 162 */       for (T to : graph.edgesFrom(from))
/*     */       {
/* 164 */         result.addEdge(to, from);
/*     */       }
/*     */     } 
/*     */     
/* 168 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> void explore(T node, DirectedGraph<T> graph, List<T> sortedResult, Set<T> visitedNodes, Set<T> expandedNodes) {
/* 174 */     if (visitedNodes.contains(node)) {
/*     */ 
/*     */       
/* 177 */       if (expandedNodes.contains(node)) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 183 */       FMLLog.severe("Mod Sorting failed.", new Object[0]);
/* 184 */       FMLLog.severe("Visting node %s", new Object[] { node });
/* 185 */       FMLLog.severe("Current sorted list : %s", new Object[] { sortedResult });
/* 186 */       FMLLog.severe("Visited set for this node : %s", new Object[] { visitedNodes });
/* 187 */       FMLLog.severe("Explored node set : %s", new Object[] { expandedNodes });
/* 188 */       Sets.SetView<T> cycleList = Sets.difference(visitedNodes, expandedNodes);
/* 189 */       FMLLog.severe("Likely cycle is in : %s", new Object[] { cycleList });
/* 190 */       throw new ModSortingException("There was a cycle detected in the input graph, sorting is not possible", node, cycleList);
/*     */     } 
/*     */ 
/*     */     
/* 194 */     visitedNodes.add(node);
/*     */ 
/*     */     
/* 197 */     for (T inbound : graph.edgesFrom(node))
/*     */     {
/* 199 */       explore(inbound, graph, sortedResult, visitedNodes, expandedNodes);
/*     */     }
/*     */ 
/*     */     
/* 203 */     sortedResult.add(node);
/*     */     
/* 205 */     expandedNodes.add(node);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\toposort\TopologicalSort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */