/*     */ package org.yaml.snakeyaml.representer;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.IdentityHashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.yaml.snakeyaml.DumperOptions;
/*     */ import org.yaml.snakeyaml.error.YAMLException;
/*     */ import org.yaml.snakeyaml.introspector.PropertyUtils;
/*     */ import org.yaml.snakeyaml.nodes.AnchorNode;
/*     */ import org.yaml.snakeyaml.nodes.MappingNode;
/*     */ import org.yaml.snakeyaml.nodes.Node;
/*     */ import org.yaml.snakeyaml.nodes.NodeTuple;
/*     */ import org.yaml.snakeyaml.nodes.ScalarNode;
/*     */ import org.yaml.snakeyaml.nodes.SequenceNode;
/*     */ import org.yaml.snakeyaml.nodes.Tag;
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
/*     */ public abstract class BaseRepresenter
/*     */ {
/*  42 */   protected final Map<Class<?>, Represent> representers = new HashMap<Class<?>, Represent>();
/*     */ 
/*     */ 
/*     */   
/*     */   protected Represent nullRepresenter;
/*     */ 
/*     */ 
/*     */   
/*  50 */   protected final Map<Class<?>, Represent> multiRepresenters = new LinkedHashMap<Class<?>, Represent>();
/*     */   private Character defaultStyle;
/*  52 */   protected DumperOptions.FlowStyle defaultFlowStyle = DumperOptions.FlowStyle.AUTO;
/*  53 */   protected final Map<Object, Node> representedObjects = new IdentityHashMap<Object, Node>() {
/*     */       private static final long serialVersionUID = -5576159264232131854L;
/*     */       
/*     */       public Node put(Object key, Node value) {
/*  57 */         return (Node)super.put(key, new AnchorNode(value));
/*     */       }
/*     */     };
/*     */   
/*     */   protected Object objectToRepresent;
/*     */   private PropertyUtils propertyUtils;
/*     */   private boolean explicitPropertyUtils = false;
/*     */   
/*     */   public Node represent(Object data) {
/*  66 */     Node node = representData(data);
/*  67 */     this.representedObjects.clear();
/*  68 */     this.objectToRepresent = null;
/*  69 */     return node;
/*     */   }
/*     */   protected final Node representData(Object data) {
/*     */     Node node;
/*  73 */     this.objectToRepresent = data;
/*     */     
/*  75 */     if (this.representedObjects.containsKey(this.objectToRepresent)) {
/*  76 */       node = this.representedObjects.get(this.objectToRepresent);
/*  77 */       return node;
/*     */     } 
/*     */ 
/*     */     
/*  81 */     if (data == null) {
/*  82 */       node = this.nullRepresenter.representData(data);
/*  83 */       return node;
/*     */     } 
/*     */ 
/*     */     
/*  87 */     Class<?> clazz = data.getClass();
/*  88 */     if (this.representers.containsKey(clazz)) {
/*  89 */       Represent representer = this.representers.get(clazz);
/*  90 */       node = representer.representData(data);
/*     */     } else {
/*     */       
/*  93 */       for (Class<?> repr : this.multiRepresenters.keySet()) {
/*  94 */         if (repr.isInstance(data)) {
/*  95 */           Represent representer = this.multiRepresenters.get(repr);
/*  96 */           node = representer.representData(data);
/*  97 */           return node;
/*     */         } 
/*     */       } 
/*     */       
/* 101 */       if (clazz.isArray()) {
/* 102 */         throw new YAMLException("Arrays of primitives are not fully supported.");
/*     */       }
/*     */       
/* 105 */       if (this.multiRepresenters.containsKey(null)) {
/* 106 */         Represent representer = this.multiRepresenters.get(null);
/* 107 */         node = representer.representData(data);
/*     */       } else {
/* 109 */         Represent representer = this.representers.get(null);
/* 110 */         node = representer.representData(data);
/*     */       } 
/*     */     } 
/* 113 */     return node;
/*     */   }
/*     */   
/*     */   protected Node representScalar(Tag tag, String value, Character style) {
/* 117 */     if (style == null) {
/* 118 */       style = this.defaultStyle;
/*     */     }
/* 120 */     return (Node)new ScalarNode(tag, value, null, null, style);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Node representScalar(Tag tag, String value) {
/* 126 */     return representScalar(tag, value, null);
/*     */   }
/*     */   
/*     */   protected Node representSequence(Tag tag, Iterable<? extends Object> sequence, Boolean flowStyle) {
/* 130 */     int size = 10;
/* 131 */     if (sequence instanceof List) {
/* 132 */       size = ((List)sequence).size();
/*     */     }
/* 134 */     List<Node> value = new ArrayList<Node>(size);
/* 135 */     SequenceNode node = new SequenceNode(tag, value, flowStyle);
/* 136 */     this.representedObjects.put(this.objectToRepresent, node);
/* 137 */     boolean bestStyle = true;
/* 138 */     for (Object item : sequence) {
/* 139 */       Node nodeItem = representData(item);
/* 140 */       if (!(nodeItem instanceof ScalarNode) || ((ScalarNode)nodeItem).getStyle() != null) {
/* 141 */         bestStyle = false;
/*     */       }
/* 143 */       value.add(nodeItem);
/*     */     } 
/* 145 */     if (flowStyle == null) {
/* 146 */       if (this.defaultFlowStyle != DumperOptions.FlowStyle.AUTO) {
/* 147 */         node.setFlowStyle(this.defaultFlowStyle.getStyleBoolean());
/*     */       } else {
/* 149 */         node.setFlowStyle(Boolean.valueOf(bestStyle));
/*     */       } 
/*     */     }
/* 152 */     return (Node)node;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Node representMapping(Tag tag, Map<? extends Object, Object> mapping, Boolean flowStyle) {
/* 157 */     List<NodeTuple> value = new ArrayList<NodeTuple>(mapping.size());
/* 158 */     MappingNode node = new MappingNode(tag, value, flowStyle);
/* 159 */     this.representedObjects.put(this.objectToRepresent, node);
/* 160 */     boolean bestStyle = true;
/* 161 */     for (Object itemKey : mapping.keySet()) {
/* 162 */       Object itemValue = mapping.get(itemKey);
/* 163 */       Node nodeKey = representData(itemKey);
/* 164 */       Node nodeValue = representData(itemValue);
/* 165 */       if (!(nodeKey instanceof ScalarNode) || ((ScalarNode)nodeKey).getStyle() != null) {
/* 166 */         bestStyle = false;
/*     */       }
/* 168 */       if (!(nodeValue instanceof ScalarNode) || ((ScalarNode)nodeValue).getStyle() != null) {
/* 169 */         bestStyle = false;
/*     */       }
/* 171 */       value.add(new NodeTuple(nodeKey, nodeValue));
/*     */     } 
/* 173 */     if (flowStyle == null) {
/* 174 */       if (this.defaultFlowStyle != DumperOptions.FlowStyle.AUTO) {
/* 175 */         node.setFlowStyle(this.defaultFlowStyle.getStyleBoolean());
/*     */       } else {
/* 177 */         node.setFlowStyle(Boolean.valueOf(bestStyle));
/*     */       } 
/*     */     }
/* 180 */     return (Node)node;
/*     */   }
/*     */   
/*     */   public void setDefaultScalarStyle(DumperOptions.ScalarStyle defaultStyle) {
/* 184 */     this.defaultStyle = defaultStyle.getChar();
/*     */   }
/*     */   
/*     */   public void setDefaultFlowStyle(DumperOptions.FlowStyle defaultFlowStyle) {
/* 188 */     this.defaultFlowStyle = defaultFlowStyle;
/*     */   }
/*     */   
/*     */   public DumperOptions.FlowStyle getDefaultFlowStyle() {
/* 192 */     return this.defaultFlowStyle;
/*     */   }
/*     */   
/*     */   public void setPropertyUtils(PropertyUtils propertyUtils) {
/* 196 */     this.propertyUtils = propertyUtils;
/* 197 */     this.explicitPropertyUtils = true;
/*     */   }
/*     */   
/*     */   public final PropertyUtils getPropertyUtils() {
/* 201 */     if (this.propertyUtils == null) {
/* 202 */       this.propertyUtils = new PropertyUtils();
/*     */     }
/* 204 */     return this.propertyUtils;
/*     */   }
/*     */   
/*     */   public final boolean isExplicitPropertyUtils() {
/* 208 */     return this.explicitPropertyUtils;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\representer\BaseRepresenter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */