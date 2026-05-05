/*     */ package org.yaml.snakeyaml.representer;
/*     */ 
/*     */ import java.beans.IntrospectionException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.yaml.snakeyaml.DumperOptions;
/*     */ import org.yaml.snakeyaml.error.YAMLException;
/*     */ import org.yaml.snakeyaml.introspector.Property;
/*     */ import org.yaml.snakeyaml.nodes.MappingNode;
/*     */ import org.yaml.snakeyaml.nodes.Node;
/*     */ import org.yaml.snakeyaml.nodes.NodeId;
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
/*     */ public class Representer
/*     */   extends SafeRepresenter
/*     */ {
/*     */   public Representer() {
/*  44 */     this.representers.put(null, new RepresentJavaBean());
/*     */   }
/*     */   
/*     */   protected class RepresentJavaBean implements Represent {
/*     */     public Node representData(Object data) {
/*     */       try {
/*  50 */         return (Node)Representer.this.representJavaBean(Representer.this.getProperties((Class)data.getClass()), data);
/*  51 */       } catch (IntrospectionException e) {
/*  52 */         throw new YAMLException(e);
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected MappingNode representJavaBean(Set<Property> properties, Object javaBean) {
/*  72 */     List<NodeTuple> value = new ArrayList<NodeTuple>(properties.size());
/*     */     
/*  74 */     Tag customTag = this.classTags.get(javaBean.getClass());
/*  75 */     Tag tag = (customTag != null) ? customTag : new Tag(javaBean.getClass());
/*     */     
/*  77 */     MappingNode node = new MappingNode(tag, value, null);
/*  78 */     this.representedObjects.put(javaBean, node);
/*  79 */     boolean bestStyle = true;
/*  80 */     for (Property property : properties) {
/*  81 */       Object memberValue = property.get(javaBean);
/*  82 */       Tag customPropertyTag = (memberValue == null) ? null : this.classTags.get(memberValue.getClass());
/*     */       
/*  84 */       NodeTuple tuple = representJavaBeanProperty(javaBean, property, memberValue, customPropertyTag);
/*     */       
/*  86 */       if (tuple == null) {
/*     */         continue;
/*     */       }
/*  89 */       if (((ScalarNode)tuple.getKeyNode()).getStyle() != null) {
/*  90 */         bestStyle = false;
/*     */       }
/*  92 */       Node nodeValue = tuple.getValueNode();
/*  93 */       if (!(nodeValue instanceof ScalarNode) || ((ScalarNode)nodeValue).getStyle() != null) {
/*  94 */         bestStyle = false;
/*     */       }
/*  96 */       value.add(tuple);
/*     */     } 
/*  98 */     if (this.defaultFlowStyle != DumperOptions.FlowStyle.AUTO) {
/*  99 */       node.setFlowStyle(this.defaultFlowStyle.getStyleBoolean());
/*     */     } else {
/* 101 */       node.setFlowStyle(Boolean.valueOf(bestStyle));
/*     */     } 
/* 103 */     return node;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected NodeTuple representJavaBeanProperty(Object javaBean, Property property, Object propertyValue, Tag customTag) {
/* 122 */     ScalarNode nodeKey = (ScalarNode)representData(property.getName());
/*     */     
/* 124 */     boolean hasAlias = this.representedObjects.containsKey(propertyValue);
/*     */     
/* 126 */     Node nodeValue = representData(propertyValue);
/*     */     
/* 128 */     if (propertyValue != null && !hasAlias) {
/* 129 */       NodeId nodeId = nodeValue.getNodeId();
/* 130 */       if (customTag == null) {
/* 131 */         if (nodeId == NodeId.scalar) {
/* 132 */           if (propertyValue instanceof Enum) {
/* 133 */             nodeValue.setTag(Tag.STR);
/*     */           }
/*     */         } else {
/* 136 */           if (nodeId == NodeId.mapping && 
/* 137 */             property.getType() == propertyValue.getClass() && 
/* 138 */             !(propertyValue instanceof java.util.Map) && 
/* 139 */             !nodeValue.getTag().equals(Tag.SET)) {
/* 140 */             nodeValue.setTag(Tag.MAP);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 145 */           checkGlobalTag(property, nodeValue, propertyValue);
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 150 */     return new NodeTuple((Node)nodeKey, nodeValue);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkGlobalTag(Property property, Node node, Object object) {
/* 166 */     Class<?>[] arguments = property.getActualTypeArguments();
/* 167 */     if (arguments != null) {
/* 168 */       if (node.getNodeId() == NodeId.sequence) {
/*     */         Iterable<Object> memberList;
/* 170 */         Class<? extends Object> t = (Class)arguments[0];
/* 171 */         SequenceNode snode = (SequenceNode)node;
/*     */         
/* 173 */         if (object.getClass().isArray()) {
/* 174 */           memberList = Arrays.asList((Object[])object);
/*     */         } else {
/*     */           
/* 177 */           memberList = (Iterable<Object>)object;
/*     */         } 
/* 179 */         Iterator<Object> iter = memberList.iterator();
/* 180 */         for (Node childNode : snode.getValue()) {
/* 181 */           Object member = iter.next();
/* 182 */           if (member != null && 
/* 183 */             t.equals(member.getClass()) && 
/* 184 */             childNode.getNodeId() == NodeId.mapping) {
/* 185 */             childNode.setTag(Tag.MAP);
/*     */           }
/*     */         }
/*     */       
/* 189 */       } else if (object instanceof Set) {
/* 190 */         Class<?> t = arguments[0];
/* 191 */         MappingNode mnode = (MappingNode)node;
/* 192 */         Iterator<NodeTuple> iter = mnode.getValue().iterator();
/* 193 */         Set<?> set = (Set)object;
/* 194 */         for (Object member : set) {
/* 195 */           NodeTuple tuple = iter.next();
/* 196 */           Node keyNode = tuple.getKeyNode();
/* 197 */           if (t.equals(member.getClass()) && 
/* 198 */             keyNode.getNodeId() == NodeId.mapping) {
/* 199 */             keyNode.setTag(Tag.MAP);
/*     */           }
/*     */         }
/*     */       
/* 203 */       } else if (object instanceof java.util.Map) {
/* 204 */         Class<?> keyType = arguments[0];
/* 205 */         Class<?> valueType = arguments[1];
/* 206 */         MappingNode mnode = (MappingNode)node;
/* 207 */         for (NodeTuple tuple : mnode.getValue()) {
/* 208 */           resetTag((Class)keyType, tuple.getKeyNode());
/* 209 */           resetTag((Class)valueType, tuple.getValueNode());
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void resetTag(Class<? extends Object> type, Node node) {
/* 219 */     Tag tag = node.getTag();
/* 220 */     if (tag.matches(type)) {
/* 221 */       if (Enum.class.isAssignableFrom(type)) {
/* 222 */         node.setTag(Tag.STR);
/*     */       } else {
/* 224 */         node.setTag(Tag.MAP);
/*     */       } 
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
/*     */   
/*     */   protected Set<Property> getProperties(Class<? extends Object> type) throws IntrospectionException {
/* 239 */     return getPropertyUtils().getProperties(type);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\representer\Representer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */