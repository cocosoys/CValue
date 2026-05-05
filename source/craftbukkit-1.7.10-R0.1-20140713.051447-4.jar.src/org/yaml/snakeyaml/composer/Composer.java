/*     */ package org.yaml.snakeyaml.composer;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.yaml.snakeyaml.events.AliasEvent;
/*     */ import org.yaml.snakeyaml.events.Event;
/*     */ import org.yaml.snakeyaml.events.MappingStartEvent;
/*     */ import org.yaml.snakeyaml.events.NodeEvent;
/*     */ import org.yaml.snakeyaml.events.ScalarEvent;
/*     */ import org.yaml.snakeyaml.events.SequenceStartEvent;
/*     */ import org.yaml.snakeyaml.nodes.MappingNode;
/*     */ import org.yaml.snakeyaml.nodes.Node;
/*     */ import org.yaml.snakeyaml.nodes.NodeId;
/*     */ import org.yaml.snakeyaml.nodes.NodeTuple;
/*     */ import org.yaml.snakeyaml.nodes.ScalarNode;
/*     */ import org.yaml.snakeyaml.nodes.SequenceNode;
/*     */ import org.yaml.snakeyaml.nodes.Tag;
/*     */ import org.yaml.snakeyaml.parser.Parser;
/*     */ import org.yaml.snakeyaml.resolver.Resolver;
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
/*     */ public class Composer
/*     */ {
/*     */   private final Parser parser;
/*     */   private final Resolver resolver;
/*     */   private final Map<String, Node> anchors;
/*     */   private final Set<Node> recursiveNodes;
/*     */   
/*     */   public Composer(Parser parser, Resolver resolver) {
/*  56 */     this.parser = parser;
/*  57 */     this.resolver = resolver;
/*  58 */     this.anchors = new HashMap<String, Node>();
/*  59 */     this.recursiveNodes = new HashSet<Node>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkNode() {
/*  69 */     if (this.parser.checkEvent(Event.ID.StreamStart)) {
/*  70 */       this.parser.getEvent();
/*     */     }
/*     */     
/*  73 */     return !this.parser.checkEvent(Event.ID.StreamEnd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node getNode() {
/*  84 */     if (!this.parser.checkEvent(Event.ID.StreamEnd)) {
/*  85 */       return composeDocument();
/*     */     }
/*  87 */     return null;
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
/*     */   public Node getSingleNode() {
/* 102 */     this.parser.getEvent();
/*     */     
/* 104 */     Node document = null;
/* 105 */     if (!this.parser.checkEvent(Event.ID.StreamEnd)) {
/* 106 */       document = composeDocument();
/*     */     }
/*     */     
/* 109 */     if (!this.parser.checkEvent(Event.ID.StreamEnd)) {
/* 110 */       Event event = this.parser.getEvent();
/* 111 */       throw new ComposerException("expected a single document in the stream", document.getStartMark(), "but found another document", event.getStartMark());
/*     */     } 
/*     */ 
/*     */     
/* 115 */     this.parser.getEvent();
/* 116 */     return document;
/*     */   }
/*     */ 
/*     */   
/*     */   private Node composeDocument() {
/* 121 */     this.parser.getEvent();
/*     */     
/* 123 */     Node node = composeNode(null, null);
/*     */     
/* 125 */     this.parser.getEvent();
/* 126 */     this.anchors.clear();
/* 127 */     this.recursiveNodes.clear();
/* 128 */     return node;
/*     */   }
/*     */   
/*     */   private Node composeNode(Node parent, Object index) {
/* 132 */     this.recursiveNodes.add(parent);
/* 133 */     if (this.parser.checkEvent(Event.ID.Alias)) {
/* 134 */       AliasEvent aliasEvent = (AliasEvent)this.parser.getEvent();
/* 135 */       String str = aliasEvent.getAnchor();
/* 136 */       if (!this.anchors.containsKey(str)) {
/* 137 */         throw new ComposerException(null, null, "found undefined alias " + str, aliasEvent.getStartMark());
/*     */       }
/*     */       
/* 140 */       Node result = this.anchors.get(str);
/* 141 */       if (this.recursiveNodes.remove(result)) {
/* 142 */         result.setTwoStepsConstruction(true);
/*     */       }
/* 144 */       return result;
/*     */     } 
/* 146 */     NodeEvent event = (NodeEvent)this.parser.peekEvent();
/* 147 */     String anchor = null;
/* 148 */     anchor = event.getAnchor();
/* 149 */     if (anchor != null && this.anchors.containsKey(anchor)) {
/* 150 */       throw new ComposerException("found duplicate anchor " + anchor + "; first occurence", ((Node)this.anchors.get(anchor)).getStartMark(), "second occurence", event.getStartMark());
/*     */     }
/*     */ 
/*     */     
/* 154 */     Node node = null;
/* 155 */     if (this.parser.checkEvent(Event.ID.Scalar)) {
/* 156 */       node = composeScalarNode(anchor);
/* 157 */     } else if (this.parser.checkEvent(Event.ID.SequenceStart)) {
/* 158 */       node = composeSequenceNode(anchor);
/*     */     } else {
/* 160 */       node = composeMappingNode(anchor);
/*     */     } 
/* 162 */     this.recursiveNodes.remove(parent);
/* 163 */     return node;
/*     */   }
/*     */   private Node composeScalarNode(String anchor) {
/*     */     Tag nodeTag;
/* 167 */     ScalarEvent ev = (ScalarEvent)this.parser.getEvent();
/* 168 */     String tag = ev.getTag();
/* 169 */     boolean resolved = false;
/*     */     
/* 171 */     if (tag == null || tag.equals("!")) {
/* 172 */       nodeTag = this.resolver.resolve(NodeId.scalar, ev.getValue(), ev.getImplicit().canOmitTagInPlainScalar());
/* 173 */       resolved = true;
/*     */     } else {
/* 175 */       nodeTag = new Tag(tag);
/*     */     } 
/* 177 */     ScalarNode scalarNode = new ScalarNode(nodeTag, resolved, ev.getValue(), ev.getStartMark(), ev.getEndMark(), ev.getStyle());
/*     */     
/* 179 */     if (anchor != null) {
/* 180 */       this.anchors.put(anchor, scalarNode);
/*     */     }
/* 182 */     return (Node)scalarNode;
/*     */   }
/*     */   private Node composeSequenceNode(String anchor) {
/*     */     Tag nodeTag;
/* 186 */     SequenceStartEvent startEvent = (SequenceStartEvent)this.parser.getEvent();
/* 187 */     String tag = startEvent.getTag();
/*     */     
/* 189 */     boolean resolved = false;
/* 190 */     if (tag == null || tag.equals("!")) {
/* 191 */       nodeTag = this.resolver.resolve(NodeId.sequence, null, startEvent.getImplicit());
/* 192 */       resolved = true;
/*     */     } else {
/* 194 */       nodeTag = new Tag(tag);
/*     */     } 
/* 196 */     ArrayList<Node> children = new ArrayList<Node>();
/* 197 */     SequenceNode node = new SequenceNode(nodeTag, resolved, children, startEvent.getStartMark(), null, startEvent.getFlowStyle());
/*     */     
/* 199 */     if (anchor != null) {
/* 200 */       this.anchors.put(anchor, node);
/*     */     }
/* 202 */     int index = 0;
/* 203 */     while (!this.parser.checkEvent(Event.ID.SequenceEnd)) {
/* 204 */       children.add(composeNode((Node)node, Integer.valueOf(index)));
/* 205 */       index++;
/*     */     } 
/* 207 */     Event endEvent = this.parser.getEvent();
/* 208 */     node.setEndMark(endEvent.getEndMark());
/* 209 */     return (Node)node;
/*     */   }
/*     */   private Node composeMappingNode(String anchor) {
/*     */     Tag nodeTag;
/* 213 */     MappingStartEvent startEvent = (MappingStartEvent)this.parser.getEvent();
/* 214 */     String tag = startEvent.getTag();
/*     */     
/* 216 */     boolean resolved = false;
/* 217 */     if (tag == null || tag.equals("!")) {
/* 218 */       nodeTag = this.resolver.resolve(NodeId.mapping, null, startEvent.getImplicit());
/* 219 */       resolved = true;
/*     */     } else {
/* 221 */       nodeTag = new Tag(tag);
/*     */     } 
/*     */     
/* 224 */     List<NodeTuple> children = new ArrayList<NodeTuple>();
/* 225 */     MappingNode node = new MappingNode(nodeTag, resolved, children, startEvent.getStartMark(), null, startEvent.getFlowStyle());
/*     */     
/* 227 */     if (anchor != null) {
/* 228 */       this.anchors.put(anchor, node);
/*     */     }
/* 230 */     while (!this.parser.checkEvent(Event.ID.MappingEnd)) {
/* 231 */       Node itemKey = composeNode((Node)node, null);
/* 232 */       if (itemKey.getTag().equals(Tag.MERGE)) {
/* 233 */         node.setMerged(true);
/* 234 */       } else if (itemKey.getTag().equals(Tag.VALUE)) {
/* 235 */         itemKey.setTag(Tag.STR);
/*     */       } 
/* 237 */       Node itemValue = composeNode((Node)node, itemKey);
/* 238 */       children.add(new NodeTuple(itemKey, itemValue));
/*     */     } 
/* 240 */     Event endEvent = this.parser.getEvent();
/* 241 */     node.setEndMark(endEvent.getEndMark());
/* 242 */     return (Node)node;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\composer\Composer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */