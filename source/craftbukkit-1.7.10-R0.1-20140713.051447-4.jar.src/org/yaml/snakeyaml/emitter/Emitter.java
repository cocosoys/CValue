/*      */ package org.yaml.snakeyaml.emitter;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.Writer;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Queue;
/*      */ import java.util.Set;
/*      */ import java.util.TreeSet;
/*      */ import java.util.concurrent.ArrayBlockingQueue;
/*      */ import java.util.regex.Pattern;
/*      */ import org.yaml.snakeyaml.DumperOptions;
/*      */ import org.yaml.snakeyaml.events.CollectionStartEvent;
/*      */ import org.yaml.snakeyaml.events.DocumentEndEvent;
/*      */ import org.yaml.snakeyaml.events.DocumentStartEvent;
/*      */ import org.yaml.snakeyaml.events.Event;
/*      */ import org.yaml.snakeyaml.events.MappingStartEvent;
/*      */ import org.yaml.snakeyaml.events.NodeEvent;
/*      */ import org.yaml.snakeyaml.events.ScalarEvent;
/*      */ import org.yaml.snakeyaml.events.SequenceStartEvent;
/*      */ import org.yaml.snakeyaml.scanner.Constant;
/*      */ import org.yaml.snakeyaml.util.ArrayStack;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class Emitter
/*      */   implements Emitable
/*      */ {
/*   62 */   private static final Map<Character, String> ESCAPE_REPLACEMENTS = new HashMap<Character, String>();
/*      */   
/*      */   public static final int MIN_INDENT = 1;
/*      */   public static final int MAX_INDENT = 10;
/*   66 */   public static final char[] SPACE = new char[] { ' ' };
/*      */   
/*      */   static {
/*   69 */     ESCAPE_REPLACEMENTS.put(new Character(false), "0");
/*   70 */     ESCAPE_REPLACEMENTS.put(new Character('\007'), "a");
/*   71 */     ESCAPE_REPLACEMENTS.put(new Character('\b'), "b");
/*   72 */     ESCAPE_REPLACEMENTS.put(new Character('\t'), "t");
/*   73 */     ESCAPE_REPLACEMENTS.put(new Character('\n'), "n");
/*   74 */     ESCAPE_REPLACEMENTS.put(new Character('\013'), "v");
/*   75 */     ESCAPE_REPLACEMENTS.put(new Character('\f'), "f");
/*   76 */     ESCAPE_REPLACEMENTS.put(new Character('\r'), "r");
/*   77 */     ESCAPE_REPLACEMENTS.put(new Character('\033'), "e");
/*   78 */     ESCAPE_REPLACEMENTS.put(new Character('"'), "\"");
/*   79 */     ESCAPE_REPLACEMENTS.put(new Character('\\'), "\\");
/*   80 */     ESCAPE_REPLACEMENTS.put(new Character(''), "N");
/*   81 */     ESCAPE_REPLACEMENTS.put(new Character(' '), "_");
/*   82 */     ESCAPE_REPLACEMENTS.put(new Character(' '), "L");
/*   83 */     ESCAPE_REPLACEMENTS.put(new Character(' '), "P");
/*      */   }
/*      */   
/*   86 */   private static final Map<String, String> DEFAULT_TAG_PREFIXES = new LinkedHashMap<String, String>();
/*      */   static {
/*   88 */     DEFAULT_TAG_PREFIXES.put("!", "!");
/*   89 */     DEFAULT_TAG_PREFIXES.put("tag:yaml.org,2002:", "!!");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private final Writer stream;
/*      */ 
/*      */   
/*      */   private final ArrayStack<EmitterState> states;
/*      */ 
/*      */   
/*      */   private EmitterState state;
/*      */ 
/*      */   
/*      */   private final Queue<Event> events;
/*      */ 
/*      */   
/*      */   private Event event;
/*      */   
/*      */   private final ArrayStack<Integer> indents;
/*      */   
/*      */   private Integer indent;
/*      */   
/*      */   private int flowLevel;
/*      */   
/*      */   private boolean rootContext;
/*      */   
/*      */   private boolean mappingContext;
/*      */   
/*      */   private boolean simpleKeyContext;
/*      */   
/*      */   private int column;
/*      */   
/*      */   private boolean whitespace;
/*      */   
/*      */   private boolean indention;
/*      */   
/*      */   private boolean openEnded;
/*      */   
/*      */   private Boolean canonical;
/*      */   
/*      */   private Boolean prettyFlow;
/*      */   
/*      */   private boolean allowUnicode;
/*      */   
/*      */   private int bestIndent;
/*      */   
/*      */   private int bestWidth;
/*      */   
/*      */   private char[] bestLineBreak;
/*      */   
/*      */   private Map<String, String> tagPrefixes;
/*      */   
/*      */   private String preparedAnchor;
/*      */   
/*      */   private String preparedTag;
/*      */   
/*      */   private ScalarAnalysis analysis;
/*      */   
/*      */   private Character style;
/*      */   
/*      */   private DumperOptions options;
/*      */ 
/*      */   
/*      */   public Emitter(Writer stream, DumperOptions opts) {
/*  154 */     this.stream = stream;
/*      */ 
/*      */     
/*  157 */     this.states = new ArrayStack(100);
/*  158 */     this.state = new ExpectStreamStart();
/*      */     
/*  160 */     this.events = new ArrayBlockingQueue<Event>(100);
/*  161 */     this.event = null;
/*      */     
/*  163 */     this.indents = new ArrayStack(10);
/*  164 */     this.indent = null;
/*      */     
/*  166 */     this.flowLevel = 0;
/*      */     
/*  168 */     this.mappingContext = false;
/*  169 */     this.simpleKeyContext = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  177 */     this.column = 0;
/*  178 */     this.whitespace = true;
/*  179 */     this.indention = true;
/*      */ 
/*      */     
/*  182 */     this.openEnded = false;
/*      */ 
/*      */     
/*  185 */     this.canonical = Boolean.valueOf(opts.isCanonical());
/*  186 */     this.prettyFlow = Boolean.valueOf(opts.isPrettyFlow());
/*  187 */     this.allowUnicode = opts.isAllowUnicode();
/*  188 */     this.bestIndent = 2;
/*  189 */     if (opts.getIndent() > 1 && opts.getIndent() < 10) {
/*  190 */       this.bestIndent = opts.getIndent();
/*      */     }
/*  192 */     this.bestWidth = 80;
/*  193 */     if (opts.getWidth() > this.bestIndent * 2) {
/*  194 */       this.bestWidth = opts.getWidth();
/*      */     }
/*  196 */     this.bestLineBreak = opts.getLineBreak().getString().toCharArray();
/*      */ 
/*      */     
/*  199 */     this.tagPrefixes = new LinkedHashMap<String, String>();
/*      */ 
/*      */     
/*  202 */     this.preparedAnchor = null;
/*  203 */     this.preparedTag = null;
/*      */ 
/*      */     
/*  206 */     this.analysis = null;
/*  207 */     this.style = null;
/*  208 */     this.options = opts;
/*      */   }
/*      */   
/*      */   public void emit(Event event) throws IOException {
/*  212 */     this.events.add(event);
/*  213 */     while (!needMoreEvents()) {
/*  214 */       this.event = this.events.poll();
/*  215 */       this.state.expect();
/*  216 */       this.event = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean needMoreEvents() {
/*  223 */     if (this.events.isEmpty()) {
/*  224 */       return true;
/*      */     }
/*  226 */     Event event = this.events.peek();
/*  227 */     if (event instanceof DocumentStartEvent)
/*  228 */       return needEvents(1); 
/*  229 */     if (event instanceof SequenceStartEvent)
/*  230 */       return needEvents(2); 
/*  231 */     if (event instanceof MappingStartEvent) {
/*  232 */       return needEvents(3);
/*      */     }
/*  234 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean needEvents(int count) {
/*  239 */     int level = 0;
/*  240 */     Iterator<Event> iter = this.events.iterator();
/*  241 */     iter.next();
/*  242 */     while (iter.hasNext()) {
/*  243 */       Event event = iter.next();
/*  244 */       if (event instanceof DocumentStartEvent || event instanceof CollectionStartEvent) {
/*  245 */         level++;
/*  246 */       } else if (event instanceof DocumentEndEvent || event instanceof org.yaml.snakeyaml.events.CollectionEndEvent) {
/*  247 */         level--;
/*  248 */       } else if (event instanceof org.yaml.snakeyaml.events.StreamEndEvent) {
/*  249 */         level = -1;
/*      */       } 
/*  251 */       if (level < 0) {
/*  252 */         return false;
/*      */       }
/*      */     } 
/*  255 */     return (this.events.size() < count + 1);
/*      */   }
/*      */   
/*      */   private void increaseIndent(boolean flow, boolean indentless) {
/*  259 */     this.indents.push(this.indent);
/*  260 */     if (this.indent == null) {
/*  261 */       if (flow) {
/*  262 */         this.indent = Integer.valueOf(this.bestIndent);
/*      */       } else {
/*  264 */         this.indent = Integer.valueOf(0);
/*      */       } 
/*  266 */     } else if (!indentless) {
/*  267 */       Emitter emitter = this; emitter.indent = Integer.valueOf(emitter.indent.intValue() + this.bestIndent);
/*      */     } 
/*      */   }
/*      */   
/*      */   private class ExpectStreamStart
/*      */     implements EmitterState
/*      */   {
/*      */     private ExpectStreamStart() {}
/*      */     
/*      */     public void expect() throws IOException {
/*  277 */       if (Emitter.this.event instanceof org.yaml.snakeyaml.events.StreamStartEvent) {
/*  278 */         Emitter.this.writeStreamStart();
/*  279 */         Emitter.this.state = new Emitter.ExpectFirstDocumentStart();
/*      */       } else {
/*  281 */         throw new EmitterException("expected StreamStartEvent, but got " + Emitter.this.event);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private class ExpectNothing implements EmitterState {
/*      */     public void expect() throws IOException {
/*  288 */       throw new EmitterException("expecting nothing, but got " + Emitter.this.event);
/*      */     }
/*      */     
/*      */     private ExpectNothing() {} }
/*      */   
/*      */   private class ExpectFirstDocumentStart implements EmitterState { private ExpectFirstDocumentStart() {}
/*      */     
/*      */     public void expect() throws IOException {
/*  296 */       (new Emitter.ExpectDocumentStart(true)).expect();
/*      */     } }
/*      */ 
/*      */   
/*      */   private class ExpectDocumentStart implements EmitterState {
/*      */     private boolean first;
/*      */     
/*      */     public ExpectDocumentStart(boolean first) {
/*  304 */       this.first = first;
/*      */     }
/*      */     
/*      */     public void expect() throws IOException {
/*  308 */       if (Emitter.this.event instanceof DocumentStartEvent) {
/*  309 */         DocumentStartEvent ev = (DocumentStartEvent)Emitter.this.event;
/*  310 */         if ((ev.getVersion() != null || ev.getTags() != null) && Emitter.this.openEnded) {
/*  311 */           Emitter.this.writeIndicator("...", true, false, false);
/*  312 */           Emitter.this.writeIndent();
/*      */         } 
/*  314 */         if (ev.getVersion() != null) {
/*  315 */           String versionText = Emitter.this.prepareVersion(ev.getVersion());
/*  316 */           Emitter.this.writeVersionDirective(versionText);
/*      */         } 
/*  318 */         Emitter.this.tagPrefixes = (Map)new LinkedHashMap<Object, Object>(Emitter.DEFAULT_TAG_PREFIXES);
/*  319 */         if (ev.getTags() != null) {
/*  320 */           Set<String> handles = new TreeSet<String>(ev.getTags().keySet());
/*  321 */           for (String handle : handles) {
/*  322 */             String prefix = (String)ev.getTags().get(handle);
/*  323 */             Emitter.this.tagPrefixes.put(prefix, handle);
/*  324 */             String handleText = Emitter.this.prepareTagHandle(handle);
/*  325 */             String prefixText = Emitter.this.prepareTagPrefix(prefix);
/*  326 */             Emitter.this.writeTagDirective(handleText, prefixText);
/*      */           } 
/*      */         } 
/*  329 */         boolean implicit = (this.first && !ev.getExplicit() && !Emitter.this.canonical.booleanValue() && ev.getVersion() == null && ev.getTags() == null && !Emitter.this.checkEmptyDocument());
/*      */         
/*  331 */         if (!implicit) {
/*  332 */           Emitter.this.writeIndent();
/*  333 */           Emitter.this.writeIndicator("---", true, false, false);
/*  334 */           if (Emitter.this.canonical.booleanValue()) {
/*  335 */             Emitter.this.writeIndent();
/*      */           }
/*      */         } 
/*  338 */         Emitter.this.state = new Emitter.ExpectDocumentRoot();
/*  339 */       } else if (Emitter.this.event instanceof org.yaml.snakeyaml.events.StreamEndEvent) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  345 */         Emitter.this.writeStreamEnd();
/*  346 */         Emitter.this.state = new Emitter.ExpectNothing();
/*      */       } else {
/*  348 */         throw new EmitterException("expected DocumentStartEvent, but got " + Emitter.this.event);
/*      */       } 
/*      */     } }
/*      */   
/*      */   private class ExpectDocumentEnd implements EmitterState { private ExpectDocumentEnd() {}
/*      */     
/*      */     public void expect() throws IOException {
/*  355 */       if (Emitter.this.event instanceof DocumentEndEvent) {
/*  356 */         Emitter.this.writeIndent();
/*  357 */         if (((DocumentEndEvent)Emitter.this.event).getExplicit()) {
/*  358 */           Emitter.this.writeIndicator("...", true, false, false);
/*  359 */           Emitter.this.writeIndent();
/*      */         } 
/*  361 */         Emitter.this.flushStream();
/*  362 */         Emitter.this.state = new Emitter.ExpectDocumentStart(false);
/*      */       } else {
/*  364 */         throw new EmitterException("expected DocumentEndEvent, but got " + Emitter.this.event);
/*      */       } 
/*      */     } }
/*      */   
/*      */   private class ExpectDocumentRoot implements EmitterState { private ExpectDocumentRoot() {}
/*      */     
/*      */     public void expect() throws IOException {
/*  371 */       Emitter.this.states.push(new Emitter.ExpectDocumentEnd());
/*  372 */       Emitter.this.expectNode(true, false, false, false);
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void expectNode(boolean root, boolean sequence, boolean mapping, boolean simpleKey) throws IOException {
/*  380 */     this.rootContext = root;
/*  381 */     this.mappingContext = mapping;
/*  382 */     this.simpleKeyContext = simpleKey;
/*  383 */     if (this.event instanceof org.yaml.snakeyaml.events.AliasEvent) {
/*  384 */       expectAlias();
/*  385 */     } else if (this.event instanceof ScalarEvent || this.event instanceof CollectionStartEvent) {
/*  386 */       processAnchor("&");
/*  387 */       processTag();
/*  388 */       if (this.event instanceof ScalarEvent) {
/*  389 */         expectScalar();
/*  390 */       } else if (this.event instanceof SequenceStartEvent) {
/*  391 */         if (this.flowLevel != 0 || this.canonical.booleanValue() || ((SequenceStartEvent)this.event).getFlowStyle().booleanValue() || checkEmptySequence()) {
/*      */           
/*  393 */           expectFlowSequence();
/*      */         } else {
/*  395 */           expectBlockSequence();
/*      */         }
/*      */       
/*  398 */       } else if (this.flowLevel != 0 || this.canonical.booleanValue() || ((MappingStartEvent)this.event).getFlowStyle().booleanValue() || checkEmptyMapping()) {
/*      */         
/*  400 */         expectFlowMapping();
/*      */       } else {
/*  402 */         expectBlockMapping();
/*      */       } 
/*      */     } else {
/*      */       
/*  406 */       throw new EmitterException("expected NodeEvent, but got " + this.event);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void expectAlias() throws IOException {
/*  411 */     if (((NodeEvent)this.event).getAnchor() == null) {
/*  412 */       throw new EmitterException("anchor is not specified for alias");
/*      */     }
/*  414 */     processAnchor("*");
/*  415 */     this.state = (EmitterState)this.states.pop();
/*      */   }
/*      */   
/*      */   private void expectScalar() throws IOException {
/*  419 */     increaseIndent(true, false);
/*  420 */     processScalar();
/*  421 */     this.indent = (Integer)this.indents.pop();
/*  422 */     this.state = (EmitterState)this.states.pop();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void expectFlowSequence() throws IOException {
/*  428 */     writeIndicator("[", true, true, false);
/*  429 */     this.flowLevel++;
/*  430 */     increaseIndent(true, false);
/*  431 */     if (this.prettyFlow.booleanValue()) {
/*  432 */       writeIndent();
/*      */     }
/*  434 */     this.state = new ExpectFirstFlowSequenceItem();
/*      */   }
/*      */   private class ExpectFirstFlowSequenceItem implements EmitterState { private ExpectFirstFlowSequenceItem() {}
/*      */     
/*      */     public void expect() throws IOException {
/*  439 */       if (Emitter.this.event instanceof org.yaml.snakeyaml.events.SequenceEndEvent) {
/*  440 */         Emitter.this.indent = (Integer)Emitter.this.indents.pop();
/*  441 */         Emitter.this.flowLevel--;
/*  442 */         Emitter.this.writeIndicator("]", false, false, false);
/*  443 */         Emitter.this.state = (EmitterState)Emitter.this.states.pop();
/*      */       } else {
/*  445 */         if (Emitter.this.canonical.booleanValue() || Emitter.this.column > Emitter.this.bestWidth || Emitter.this.prettyFlow.booleanValue()) {
/*  446 */           Emitter.this.writeIndent();
/*      */         }
/*  448 */         Emitter.this.states.push(new Emitter.ExpectFlowSequenceItem());
/*  449 */         Emitter.this.expectNode(false, true, false, false);
/*      */       } 
/*      */     } }
/*      */   
/*      */   private class ExpectFlowSequenceItem implements EmitterState { private ExpectFlowSequenceItem() {}
/*      */     
/*      */     public void expect() throws IOException {
/*  456 */       if (Emitter.this.event instanceof org.yaml.snakeyaml.events.SequenceEndEvent) {
/*  457 */         Emitter.this.indent = (Integer)Emitter.this.indents.pop();
/*  458 */         Emitter.this.flowLevel--;
/*  459 */         if (Emitter.this.canonical.booleanValue()) {
/*  460 */           Emitter.this.writeIndicator(",", false, false, false);
/*  461 */           Emitter.this.writeIndent();
/*      */         } 
/*  463 */         Emitter.this.writeIndicator("]", false, false, false);
/*  464 */         if (Emitter.this.prettyFlow.booleanValue()) {
/*  465 */           Emitter.this.writeIndent();
/*      */         }
/*  467 */         Emitter.this.state = (EmitterState)Emitter.this.states.pop();
/*      */       } else {
/*  469 */         Emitter.this.writeIndicator(",", false, false, false);
/*  470 */         if (Emitter.this.canonical.booleanValue() || Emitter.this.column > Emitter.this.bestWidth || Emitter.this.prettyFlow.booleanValue()) {
/*  471 */           Emitter.this.writeIndent();
/*      */         }
/*  473 */         Emitter.this.states.push(new ExpectFlowSequenceItem());
/*  474 */         Emitter.this.expectNode(false, true, false, false);
/*      */       } 
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void expectFlowMapping() throws IOException {
/*  482 */     writeIndicator("{", true, true, false);
/*  483 */     this.flowLevel++;
/*  484 */     increaseIndent(true, false);
/*  485 */     if (this.prettyFlow.booleanValue()) {
/*  486 */       writeIndent();
/*      */     }
/*  488 */     this.state = new ExpectFirstFlowMappingKey();
/*      */   }
/*      */   private class ExpectFirstFlowMappingKey implements EmitterState { private ExpectFirstFlowMappingKey() {}
/*      */     
/*      */     public void expect() throws IOException {
/*  493 */       if (Emitter.this.event instanceof org.yaml.snakeyaml.events.MappingEndEvent) {
/*  494 */         Emitter.this.indent = (Integer)Emitter.this.indents.pop();
/*  495 */         Emitter.this.flowLevel--;
/*  496 */         Emitter.this.writeIndicator("}", false, false, false);
/*  497 */         Emitter.this.state = (EmitterState)Emitter.this.states.pop();
/*      */       } else {
/*  499 */         if (Emitter.this.canonical.booleanValue() || Emitter.this.column > Emitter.this.bestWidth || Emitter.this.prettyFlow.booleanValue()) {
/*  500 */           Emitter.this.writeIndent();
/*      */         }
/*  502 */         if (!Emitter.this.canonical.booleanValue() && Emitter.this.checkSimpleKey()) {
/*  503 */           Emitter.this.states.push(new Emitter.ExpectFlowMappingSimpleValue());
/*  504 */           Emitter.this.expectNode(false, false, true, true);
/*      */         } else {
/*  506 */           Emitter.this.writeIndicator("?", true, false, false);
/*  507 */           Emitter.this.states.push(new Emitter.ExpectFlowMappingValue());
/*  508 */           Emitter.this.expectNode(false, false, true, false);
/*      */         } 
/*      */       } 
/*      */     } }
/*      */   
/*      */   private class ExpectFlowMappingKey implements EmitterState { private ExpectFlowMappingKey() {}
/*      */     
/*      */     public void expect() throws IOException {
/*  516 */       if (Emitter.this.event instanceof org.yaml.snakeyaml.events.MappingEndEvent) {
/*  517 */         Emitter.this.indent = (Integer)Emitter.this.indents.pop();
/*  518 */         Emitter.this.flowLevel--;
/*  519 */         if (Emitter.this.canonical.booleanValue()) {
/*  520 */           Emitter.this.writeIndicator(",", false, false, false);
/*  521 */           Emitter.this.writeIndent();
/*      */         } 
/*  523 */         if (Emitter.this.prettyFlow.booleanValue()) {
/*  524 */           Emitter.this.writeIndent();
/*      */         }
/*  526 */         Emitter.this.writeIndicator("}", false, false, false);
/*  527 */         Emitter.this.state = (EmitterState)Emitter.this.states.pop();
/*      */       } else {
/*  529 */         Emitter.this.writeIndicator(",", false, false, false);
/*  530 */         if (Emitter.this.canonical.booleanValue() || Emitter.this.column > Emitter.this.bestWidth || Emitter.this.prettyFlow.booleanValue()) {
/*  531 */           Emitter.this.writeIndent();
/*      */         }
/*  533 */         if (!Emitter.this.canonical.booleanValue() && Emitter.this.checkSimpleKey()) {
/*  534 */           Emitter.this.states.push(new Emitter.ExpectFlowMappingSimpleValue());
/*  535 */           Emitter.this.expectNode(false, false, true, true);
/*      */         } else {
/*  537 */           Emitter.this.writeIndicator("?", true, false, false);
/*  538 */           Emitter.this.states.push(new Emitter.ExpectFlowMappingValue());
/*  539 */           Emitter.this.expectNode(false, false, true, false);
/*      */         } 
/*      */       } 
/*      */     } }
/*      */   
/*      */   private class ExpectFlowMappingSimpleValue implements EmitterState { private ExpectFlowMappingSimpleValue() {}
/*      */     
/*      */     public void expect() throws IOException {
/*  547 */       Emitter.this.writeIndicator(":", false, false, false);
/*  548 */       Emitter.this.states.push(new Emitter.ExpectFlowMappingKey());
/*  549 */       Emitter.this.expectNode(false, false, true, false);
/*      */     } }
/*      */   
/*      */   private class ExpectFlowMappingValue implements EmitterState { private ExpectFlowMappingValue() {}
/*      */     
/*      */     public void expect() throws IOException {
/*  555 */       if (Emitter.this.canonical.booleanValue() || Emitter.this.column > Emitter.this.bestWidth || Emitter.this.prettyFlow.booleanValue()) {
/*  556 */         Emitter.this.writeIndent();
/*      */       }
/*  558 */       Emitter.this.writeIndicator(":", true, false, false);
/*  559 */       Emitter.this.states.push(new Emitter.ExpectFlowMappingKey());
/*  560 */       Emitter.this.expectNode(false, false, true, false);
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void expectBlockSequence() throws IOException {
/*  567 */     boolean indentless = (this.mappingContext && !this.indention);
/*  568 */     increaseIndent(false, indentless);
/*  569 */     this.state = new ExpectFirstBlockSequenceItem();
/*      */   }
/*      */   private class ExpectFirstBlockSequenceItem implements EmitterState { private ExpectFirstBlockSequenceItem() {}
/*      */     
/*      */     public void expect() throws IOException {
/*  574 */       (new Emitter.ExpectBlockSequenceItem(true)).expect();
/*      */     } }
/*      */ 
/*      */   
/*      */   private class ExpectBlockSequenceItem implements EmitterState {
/*      */     private boolean first;
/*      */     
/*      */     public ExpectBlockSequenceItem(boolean first) {
/*  582 */       this.first = first;
/*      */     }
/*      */     
/*      */     public void expect() throws IOException {
/*  586 */       if (!this.first && Emitter.this.event instanceof org.yaml.snakeyaml.events.SequenceEndEvent) {
/*  587 */         Emitter.this.indent = (Integer)Emitter.this.indents.pop();
/*  588 */         Emitter.this.state = (EmitterState)Emitter.this.states.pop();
/*      */       } else {
/*  590 */         Emitter.this.writeIndent();
/*  591 */         Emitter.this.writeIndicator("-", true, false, true);
/*  592 */         Emitter.this.states.push(new ExpectBlockSequenceItem(false));
/*  593 */         Emitter.this.expectNode(false, true, false, false);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void expectBlockMapping() throws IOException {
/*  600 */     increaseIndent(false, false);
/*  601 */     this.state = new ExpectFirstBlockMappingKey();
/*      */   }
/*      */   private class ExpectFirstBlockMappingKey implements EmitterState { private ExpectFirstBlockMappingKey() {}
/*      */     
/*      */     public void expect() throws IOException {
/*  606 */       (new Emitter.ExpectBlockMappingKey(true)).expect();
/*      */     } }
/*      */ 
/*      */   
/*      */   private class ExpectBlockMappingKey implements EmitterState {
/*      */     private boolean first;
/*      */     
/*      */     public ExpectBlockMappingKey(boolean first) {
/*  614 */       this.first = first;
/*      */     }
/*      */     
/*      */     public void expect() throws IOException {
/*  618 */       if (!this.first && Emitter.this.event instanceof org.yaml.snakeyaml.events.MappingEndEvent) {
/*  619 */         Emitter.this.indent = (Integer)Emitter.this.indents.pop();
/*  620 */         Emitter.this.state = (EmitterState)Emitter.this.states.pop();
/*      */       } else {
/*  622 */         Emitter.this.writeIndent();
/*  623 */         if (Emitter.this.checkSimpleKey()) {
/*  624 */           Emitter.this.states.push(new Emitter.ExpectBlockMappingSimpleValue());
/*  625 */           Emitter.this.expectNode(false, false, true, true);
/*      */         } else {
/*  627 */           Emitter.this.writeIndicator("?", true, false, true);
/*  628 */           Emitter.this.states.push(new Emitter.ExpectBlockMappingValue());
/*  629 */           Emitter.this.expectNode(false, false, true, false);
/*      */         } 
/*      */       } 
/*      */     } }
/*      */   
/*      */   private class ExpectBlockMappingSimpleValue implements EmitterState { private ExpectBlockMappingSimpleValue() {}
/*      */     
/*      */     public void expect() throws IOException {
/*  637 */       Emitter.this.writeIndicator(":", false, false, false);
/*  638 */       Emitter.this.states.push(new Emitter.ExpectBlockMappingKey(false));
/*  639 */       Emitter.this.expectNode(false, false, true, false);
/*      */     } }
/*      */   
/*      */   private class ExpectBlockMappingValue implements EmitterState { private ExpectBlockMappingValue() {}
/*      */     
/*      */     public void expect() throws IOException {
/*  645 */       Emitter.this.writeIndent();
/*  646 */       Emitter.this.writeIndicator(":", true, false, true);
/*  647 */       Emitter.this.states.push(new Emitter.ExpectBlockMappingKey(false));
/*  648 */       Emitter.this.expectNode(false, false, true, false);
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean checkEmptySequence() {
/*  655 */     return (this.event instanceof SequenceStartEvent && !this.events.isEmpty() && this.events.peek() instanceof org.yaml.snakeyaml.events.SequenceEndEvent);
/*      */   }
/*      */   
/*      */   private boolean checkEmptyMapping() {
/*  659 */     return (this.event instanceof MappingStartEvent && !this.events.isEmpty() && this.events.peek() instanceof org.yaml.snakeyaml.events.MappingEndEvent);
/*      */   }
/*      */   
/*      */   private boolean checkEmptyDocument() {
/*  663 */     if (!(this.event instanceof DocumentStartEvent) || this.events.isEmpty()) {
/*  664 */       return false;
/*      */     }
/*  666 */     Event event = this.events.peek();
/*  667 */     if (event instanceof ScalarEvent) {
/*  668 */       ScalarEvent e = (ScalarEvent)event;
/*  669 */       return (e.getAnchor() == null && e.getTag() == null && e.getImplicit() != null && e.getValue() == "");
/*      */     } 
/*      */     
/*  672 */     return false;
/*      */   }
/*      */   
/*      */   private boolean checkSimpleKey() {
/*  676 */     int length = 0;
/*  677 */     if (this.event instanceof NodeEvent && ((NodeEvent)this.event).getAnchor() != null) {
/*  678 */       if (this.preparedAnchor == null) {
/*  679 */         this.preparedAnchor = prepareAnchor(((NodeEvent)this.event).getAnchor());
/*      */       }
/*  681 */       length += this.preparedAnchor.length();
/*      */     } 
/*  683 */     String tag = null;
/*  684 */     if (this.event instanceof ScalarEvent) {
/*  685 */       tag = ((ScalarEvent)this.event).getTag();
/*  686 */     } else if (this.event instanceof CollectionStartEvent) {
/*  687 */       tag = ((CollectionStartEvent)this.event).getTag();
/*      */     } 
/*  689 */     if (tag != null) {
/*  690 */       if (this.preparedTag == null) {
/*  691 */         this.preparedTag = prepareTag(tag);
/*      */       }
/*  693 */       length += this.preparedTag.length();
/*      */     } 
/*  695 */     if (this.event instanceof ScalarEvent) {
/*  696 */       if (this.analysis == null) {
/*  697 */         this.analysis = analyzeScalar(((ScalarEvent)this.event).getValue());
/*      */       }
/*  699 */       length += this.analysis.scalar.length();
/*      */     } 
/*  701 */     return (length < 128 && (this.event instanceof org.yaml.snakeyaml.events.AliasEvent || (this.event instanceof ScalarEvent && !this.analysis.empty && !this.analysis.multiline) || checkEmptySequence() || checkEmptyMapping()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void processAnchor(String indicator) throws IOException {
/*  709 */     NodeEvent ev = (NodeEvent)this.event;
/*  710 */     if (ev.getAnchor() == null) {
/*  711 */       this.preparedAnchor = null;
/*      */       return;
/*      */     } 
/*  714 */     if (this.preparedAnchor == null) {
/*  715 */       this.preparedAnchor = prepareAnchor(ev.getAnchor());
/*      */     }
/*  717 */     writeIndicator(indicator + this.preparedAnchor, true, false, false);
/*  718 */     this.preparedAnchor = null;
/*      */   }
/*      */   
/*      */   private void processTag() throws IOException {
/*  722 */     String tag = null;
/*  723 */     if (this.event instanceof ScalarEvent) {
/*  724 */       ScalarEvent ev = (ScalarEvent)this.event;
/*  725 */       tag = ev.getTag();
/*  726 */       if (this.style == null) {
/*  727 */         this.style = chooseScalarStyle();
/*      */       }
/*  729 */       if ((!this.canonical.booleanValue() || tag == null) && ((this.style == null && ev.getImplicit().canOmitTagInPlainScalar()) || (this.style != null && ev.getImplicit().canOmitTagInNonPlainScalar()))) {
/*      */ 
/*      */         
/*  732 */         this.preparedTag = null;
/*      */         return;
/*      */       } 
/*  735 */       if (ev.getImplicit().canOmitTagInPlainScalar() && tag == null) {
/*  736 */         tag = "!";
/*  737 */         this.preparedTag = null;
/*      */       } 
/*      */     } else {
/*  740 */       CollectionStartEvent ev = (CollectionStartEvent)this.event;
/*  741 */       tag = ev.getTag();
/*  742 */       if ((!this.canonical.booleanValue() || tag == null) && ev.getImplicit()) {
/*  743 */         this.preparedTag = null;
/*      */         return;
/*      */       } 
/*      */     } 
/*  747 */     if (tag == null) {
/*  748 */       throw new EmitterException("tag is not specified");
/*      */     }
/*  750 */     if (this.preparedTag == null) {
/*  751 */       this.preparedTag = prepareTag(tag);
/*      */     }
/*  753 */     writeIndicator(this.preparedTag, true, false, false);
/*  754 */     this.preparedTag = null;
/*      */   }
/*      */   
/*      */   private Character chooseScalarStyle() {
/*  758 */     ScalarEvent ev = (ScalarEvent)this.event;
/*  759 */     if (this.analysis == null) {
/*  760 */       this.analysis = analyzeScalar(ev.getValue());
/*      */     }
/*  762 */     if ((ev.getStyle() != null && ev.getStyle().charValue() == '"') || this.canonical.booleanValue()) {
/*  763 */       return Character.valueOf('"');
/*      */     }
/*  765 */     if (ev.getStyle() == null && ev.getImplicit().canOmitTagInPlainScalar() && (
/*  766 */       !this.simpleKeyContext || (!this.analysis.empty && !this.analysis.multiline)) && ((this.flowLevel != 0 && this.analysis.allowFlowPlain) || (this.flowLevel == 0 && this.analysis.allowBlockPlain)))
/*      */     {
/*  768 */       return null;
/*      */     }
/*      */     
/*  771 */     if (ev.getStyle() != null && (ev.getStyle().charValue() == '|' || ev.getStyle().charValue() == '>') && 
/*  772 */       this.flowLevel == 0 && !this.simpleKeyContext && this.analysis.allowBlock) {
/*  773 */       return ev.getStyle();
/*      */     }
/*      */     
/*  776 */     if ((ev.getStyle() == null || ev.getStyle().charValue() == '\'') && 
/*  777 */       this.analysis.allowSingleQuoted && (!this.simpleKeyContext || !this.analysis.multiline)) {
/*  778 */       return Character.valueOf('\'');
/*      */     }
/*      */     
/*  781 */     return Character.valueOf('"');
/*      */   }
/*      */   
/*      */   private void processScalar() throws IOException {
/*  785 */     ScalarEvent ev = (ScalarEvent)this.event;
/*  786 */     if (this.analysis == null) {
/*  787 */       this.analysis = analyzeScalar(ev.getValue());
/*      */     }
/*  789 */     if (this.style == null) {
/*  790 */       this.style = chooseScalarStyle();
/*      */     }
/*  792 */     this.style = this.options.calculateScalarStyle(this.analysis, DumperOptions.ScalarStyle.createStyle(this.style)).getChar();
/*  793 */     boolean split = !this.simpleKeyContext;
/*  794 */     if (this.style == null) {
/*  795 */       writePlain(this.analysis.scalar, split);
/*      */     } else {
/*  797 */       switch (this.style.charValue()) {
/*      */         case '"':
/*  799 */           writeDoubleQuoted(this.analysis.scalar, split);
/*      */           break;
/*      */         case '\'':
/*  802 */           writeSingleQuoted(this.analysis.scalar, split);
/*      */           break;
/*      */         case '>':
/*  805 */           writeFolded(this.analysis.scalar);
/*      */           break;
/*      */         case '|':
/*  808 */           writeLiteral(this.analysis.scalar);
/*      */           break;
/*      */       } 
/*      */     } 
/*  812 */     this.analysis = null;
/*  813 */     this.style = null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private String prepareVersion(Integer[] version) {
/*  819 */     Integer major = version[0];
/*  820 */     Integer minor = version[1];
/*  821 */     if (major.intValue() != 1) {
/*  822 */       throw new EmitterException("unsupported YAML version: " + version[0] + "." + version[1]);
/*      */     }
/*  824 */     return major.toString() + "." + minor.toString();
/*      */   }
/*      */   
/*  827 */   private static final Pattern HANDLE_FORMAT = Pattern.compile("^![-_\\w]*!$");
/*      */   
/*      */   private String prepareTagHandle(String handle) {
/*  830 */     if (handle.length() == 0)
/*  831 */       throw new EmitterException("tag handle must not be empty"); 
/*  832 */     if (handle.charAt(0) != '!' || handle.charAt(handle.length() - 1) != '!')
/*  833 */       throw new EmitterException("tag handle must start and end with '!': " + handle); 
/*  834 */     if (!"!".equals(handle) && !HANDLE_FORMAT.matcher(handle).matches()) {
/*  835 */       throw new EmitterException("invalid character in the tag handle: " + handle);
/*      */     }
/*  837 */     return handle;
/*      */   }
/*      */   
/*      */   private String prepareTagPrefix(String prefix) {
/*  841 */     if (prefix.length() == 0) {
/*  842 */       throw new EmitterException("tag prefix must not be empty");
/*      */     }
/*  844 */     StringBuilder chunks = new StringBuilder();
/*  845 */     int start = 0;
/*  846 */     int end = 0;
/*  847 */     if (prefix.charAt(0) == '!') {
/*  848 */       end = 1;
/*      */     }
/*  850 */     while (end < prefix.length()) {
/*  851 */       end++;
/*      */     }
/*  853 */     if (start < end) {
/*  854 */       chunks.append(prefix.substring(start, end));
/*      */     }
/*  856 */     return chunks.toString();
/*      */   }
/*      */   
/*      */   private String prepareTag(String tag) {
/*  860 */     if (tag.length() == 0) {
/*  861 */       throw new EmitterException("tag must not be empty");
/*      */     }
/*  863 */     if ("!".equals(tag)) {
/*  864 */       return tag;
/*      */     }
/*  866 */     String handle = null;
/*  867 */     String suffix = tag;
/*  868 */     for (String prefix : this.tagPrefixes.keySet()) {
/*  869 */       if (tag.startsWith(prefix) && ("!".equals(prefix) || prefix.length() < tag.length())) {
/*  870 */         handle = prefix;
/*      */       }
/*      */     } 
/*  873 */     if (handle != null) {
/*  874 */       suffix = tag.substring(handle.length());
/*  875 */       handle = this.tagPrefixes.get(handle);
/*      */     } 
/*      */     
/*  878 */     int end = suffix.length();
/*  879 */     String suffixText = (end > 0) ? suffix.substring(0, end) : "";
/*      */     
/*  881 */     if (handle != null) {
/*  882 */       return handle + suffixText;
/*      */     }
/*  884 */     return "!<" + suffixText + ">";
/*      */   }
/*      */   
/*  887 */   private static final Pattern ANCHOR_FORMAT = Pattern.compile("^[-_\\w]*$");
/*      */   
/*      */   static String prepareAnchor(String anchor) {
/*  890 */     if (anchor.length() == 0) {
/*  891 */       throw new EmitterException("anchor must not be empty");
/*      */     }
/*  893 */     if (!ANCHOR_FORMAT.matcher(anchor).matches()) {
/*  894 */       throw new EmitterException("invalid character in the anchor: " + anchor);
/*      */     }
/*  896 */     return anchor;
/*      */   }
/*      */ 
/*      */   
/*      */   private ScalarAnalysis analyzeScalar(String scalar) {
/*  901 */     if (scalar.length() == 0) {
/*  902 */       return new ScalarAnalysis(scalar, true, false, false, true, true, true, false);
/*      */     }
/*      */     
/*  905 */     boolean blockIndicators = false;
/*  906 */     boolean flowIndicators = false;
/*  907 */     boolean lineBreaks = false;
/*  908 */     boolean specialCharacters = false;
/*      */ 
/*      */     
/*  911 */     boolean leadingSpace = false;
/*  912 */     boolean leadingBreak = false;
/*  913 */     boolean trailingSpace = false;
/*  914 */     boolean trailingBreak = false;
/*  915 */     boolean breakSpace = false;
/*  916 */     boolean spaceBreak = false;
/*      */ 
/*      */     
/*  919 */     if (scalar.startsWith("---") || scalar.startsWith("...")) {
/*  920 */       blockIndicators = true;
/*  921 */       flowIndicators = true;
/*      */     } 
/*      */     
/*  924 */     boolean preceededByWhitespace = true;
/*  925 */     boolean followedByWhitespace = (scalar.length() == 1 || Constant.NULL_BL_T_LINEBR.has(scalar.charAt(1)));
/*      */ 
/*      */     
/*  928 */     boolean previousSpace = false;
/*      */ 
/*      */     
/*  931 */     boolean previousBreak = false;
/*      */     
/*  933 */     int index = 0;
/*      */     
/*  935 */     while (index < scalar.length()) {
/*  936 */       char ch = scalar.charAt(index);
/*      */       
/*  938 */       if (index == 0) {
/*      */         
/*  940 */         if ("#,[]{}&*!|>'\"%@`".indexOf(ch) != -1) {
/*  941 */           flowIndicators = true;
/*  942 */           blockIndicators = true;
/*      */         } 
/*  944 */         if (ch == '?' || ch == ':') {
/*  945 */           flowIndicators = true;
/*  946 */           if (followedByWhitespace) {
/*  947 */             blockIndicators = true;
/*      */           }
/*      */         } 
/*  950 */         if (ch == '-' && followedByWhitespace) {
/*  951 */           flowIndicators = true;
/*  952 */           blockIndicators = true;
/*      */         } 
/*      */       } else {
/*      */         
/*  956 */         if (",?[]{}".indexOf(ch) != -1) {
/*  957 */           flowIndicators = true;
/*      */         }
/*  959 */         if (ch == ':') {
/*  960 */           flowIndicators = true;
/*  961 */           if (followedByWhitespace) {
/*  962 */             blockIndicators = true;
/*      */           }
/*      */         } 
/*  965 */         if (ch == '#' && preceededByWhitespace) {
/*  966 */           flowIndicators = true;
/*  967 */           blockIndicators = true;
/*      */         } 
/*      */       } 
/*      */       
/*  971 */       boolean isLineBreak = Constant.LINEBR.has(ch);
/*  972 */       if (isLineBreak) {
/*  973 */         lineBreaks = true;
/*      */       }
/*  975 */       if (ch != '\n' && (' ' > ch || ch > '~')) {
/*  976 */         if ((ch == '' || (' ' <= ch && ch <= '퟿') || ('' <= ch && ch <= '�')) && ch != '﻿') {
/*      */ 
/*      */           
/*  979 */           if (!this.allowUnicode) {
/*  980 */             specialCharacters = true;
/*      */           }
/*      */         } else {
/*  983 */           specialCharacters = true;
/*      */         } 
/*      */       }
/*      */       
/*  987 */       if (ch == ' ') {
/*  988 */         if (index == 0) {
/*  989 */           leadingSpace = true;
/*      */         }
/*  991 */         if (index == scalar.length() - 1) {
/*  992 */           trailingSpace = true;
/*      */         }
/*  994 */         if (previousBreak) {
/*  995 */           breakSpace = true;
/*      */         }
/*  997 */         previousSpace = true;
/*  998 */         previousBreak = false;
/*  999 */       } else if (isLineBreak) {
/* 1000 */         if (index == 0) {
/* 1001 */           leadingBreak = true;
/*      */         }
/* 1003 */         if (index == scalar.length() - 1) {
/* 1004 */           trailingBreak = true;
/*      */         }
/* 1006 */         if (previousSpace) {
/* 1007 */           spaceBreak = true;
/*      */         }
/* 1009 */         previousSpace = false;
/* 1010 */         previousBreak = true;
/*      */       } else {
/* 1012 */         previousSpace = false;
/* 1013 */         previousBreak = false;
/*      */       } 
/*      */ 
/*      */       
/* 1017 */       index++;
/* 1018 */       preceededByWhitespace = (Constant.NULL_BL_T.has(ch) || isLineBreak);
/* 1019 */       followedByWhitespace = (index + 1 >= scalar.length() || Constant.NULL_BL_T.has(scalar.charAt(index + 1)) || isLineBreak);
/*      */     } 
/*      */ 
/*      */     
/* 1023 */     boolean allowFlowPlain = true;
/* 1024 */     boolean allowBlockPlain = true;
/* 1025 */     boolean allowSingleQuoted = true;
/* 1026 */     boolean allowDoubleQuoted = true;
/* 1027 */     boolean allowBlock = true;
/*      */     
/* 1029 */     if (leadingSpace || leadingBreak || trailingSpace || trailingBreak) {
/* 1030 */       allowFlowPlain = allowBlockPlain = false;
/*      */     }
/*      */     
/* 1033 */     if (trailingSpace) {
/* 1034 */       allowBlock = false;
/*      */     }
/*      */ 
/*      */     
/* 1038 */     if (breakSpace) {
/* 1039 */       allowFlowPlain = allowBlockPlain = allowSingleQuoted = false;
/*      */     }
/*      */ 
/*      */     
/* 1043 */     if (spaceBreak || specialCharacters) {
/* 1044 */       allowFlowPlain = allowBlockPlain = allowSingleQuoted = allowBlock = false;
/*      */     }
/*      */ 
/*      */     
/* 1048 */     if (lineBreaks) {
/* 1049 */       allowFlowPlain = allowBlockPlain = false;
/*      */     }
/*      */     
/* 1052 */     if (flowIndicators) {
/* 1053 */       allowFlowPlain = false;
/*      */     }
/*      */     
/* 1056 */     if (blockIndicators) {
/* 1057 */       allowBlockPlain = false;
/*      */     }
/*      */     
/* 1060 */     return new ScalarAnalysis(scalar, false, lineBreaks, allowFlowPlain, allowBlockPlain, allowSingleQuoted, allowDoubleQuoted, allowBlock);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void flushStream() throws IOException {
/* 1067 */     this.stream.flush();
/*      */   }
/*      */ 
/*      */   
/*      */   void writeStreamStart() {}
/*      */ 
/*      */   
/*      */   void writeStreamEnd() throws IOException {
/* 1075 */     flushStream();
/*      */   }
/*      */ 
/*      */   
/*      */   void writeIndicator(String indicator, boolean needWhitespace, boolean whitespace, boolean indentation) throws IOException {
/* 1080 */     if (!this.whitespace && needWhitespace) {
/* 1081 */       this.column++;
/* 1082 */       this.stream.write(SPACE);
/*      */     } 
/* 1084 */     this.whitespace = whitespace;
/* 1085 */     this.indention = (this.indention && indentation);
/* 1086 */     this.column += indicator.length();
/* 1087 */     this.openEnded = false;
/* 1088 */     this.stream.write(indicator);
/*      */   }
/*      */   
/*      */   void writeIndent() throws IOException {
/*      */     int indent;
/* 1093 */     if (this.indent != null) {
/* 1094 */       indent = this.indent.intValue();
/*      */     } else {
/* 1096 */       indent = 0;
/*      */     } 
/*      */     
/* 1099 */     if (!this.indention || this.column > indent || (this.column == indent && !this.whitespace)) {
/* 1100 */       writeLineBreak(null);
/*      */     }
/*      */     
/* 1103 */     if (this.column < indent) {
/* 1104 */       this.whitespace = true;
/* 1105 */       char[] data = new char[indent - this.column];
/* 1106 */       for (int i = 0; i < data.length; i++) {
/* 1107 */         data[i] = ' ';
/*      */       }
/* 1109 */       this.column = indent;
/* 1110 */       this.stream.write(data);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void writeLineBreak(String data) throws IOException {
/* 1115 */     this.whitespace = true;
/* 1116 */     this.indention = true;
/* 1117 */     this.column = 0;
/* 1118 */     if (data == null) {
/* 1119 */       this.stream.write(this.bestLineBreak);
/*      */     } else {
/* 1121 */       this.stream.write(data);
/*      */     } 
/*      */   }
/*      */   
/*      */   void writeVersionDirective(String versionText) throws IOException {
/* 1126 */     this.stream.write("%YAML ");
/* 1127 */     this.stream.write(versionText);
/* 1128 */     writeLineBreak(null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void writeTagDirective(String handleText, String prefixText) throws IOException {
/* 1134 */     this.stream.write("%TAG ");
/* 1135 */     this.stream.write(handleText);
/* 1136 */     this.stream.write(SPACE);
/* 1137 */     this.stream.write(prefixText);
/* 1138 */     writeLineBreak(null);
/*      */   }
/*      */ 
/*      */   
/*      */   private void writeSingleQuoted(String text, boolean split) throws IOException {
/* 1143 */     writeIndicator("'", true, false, false);
/* 1144 */     boolean spaces = false;
/* 1145 */     boolean breaks = false;
/* 1146 */     int start = 0, end = 0;
/*      */     
/* 1148 */     while (end <= text.length()) {
/* 1149 */       char ch = Character.MIN_VALUE;
/* 1150 */       if (end < text.length()) {
/* 1151 */         ch = text.charAt(end);
/*      */       }
/* 1153 */       if (spaces) {
/* 1154 */         if (ch == '\000' || ch != ' ') {
/* 1155 */           if (start + 1 == end && this.column > this.bestWidth && split && start != 0 && end != text.length()) {
/*      */             
/* 1157 */             writeIndent();
/*      */           } else {
/* 1159 */             int len = end - start;
/* 1160 */             this.column += len;
/* 1161 */             this.stream.write(text, start, len);
/*      */           } 
/* 1163 */           start = end;
/*      */         } 
/* 1165 */       } else if (breaks) {
/* 1166 */         if (ch == '\000' || Constant.LINEBR.hasNo(ch)) {
/* 1167 */           if (text.charAt(start) == '\n') {
/* 1168 */             writeLineBreak(null);
/*      */           }
/* 1170 */           String data = text.substring(start, end);
/* 1171 */           for (char br : data.toCharArray()) {
/* 1172 */             if (br == '\n') {
/* 1173 */               writeLineBreak(null);
/*      */             } else {
/* 1175 */               writeLineBreak(String.valueOf(br));
/*      */             } 
/*      */           } 
/* 1178 */           writeIndent();
/* 1179 */           start = end;
/*      */         }
/*      */       
/* 1182 */       } else if (Constant.LINEBR.has(ch, "\000 '") && 
/* 1183 */         start < end) {
/* 1184 */         int len = end - start;
/* 1185 */         this.column += len;
/* 1186 */         this.stream.write(text, start, len);
/* 1187 */         start = end;
/*      */       } 
/*      */ 
/*      */       
/* 1191 */       if (ch == '\'') {
/* 1192 */         this.column += 2;
/* 1193 */         this.stream.write("''");
/* 1194 */         start = end + 1;
/*      */       } 
/* 1196 */       if (ch != '\000') {
/* 1197 */         spaces = (ch == ' ');
/* 1198 */         breaks = Constant.LINEBR.has(ch);
/*      */       } 
/* 1200 */       end++;
/*      */     } 
/* 1202 */     writeIndicator("'", false, false, false);
/*      */   }
/*      */   
/*      */   private void writeDoubleQuoted(String text, boolean split) throws IOException {
/* 1206 */     writeIndicator("\"", true, false, false);
/* 1207 */     int start = 0;
/* 1208 */     int end = 0;
/* 1209 */     while (end <= text.length()) {
/* 1210 */       Character ch = null;
/* 1211 */       if (end < text.length()) {
/* 1212 */         ch = Character.valueOf(text.charAt(end));
/*      */       }
/* 1214 */       if (ch == null || "\"\\  ﻿".indexOf(ch.charValue()) != -1 || ' ' > ch.charValue() || ch.charValue() > '~') {
/*      */         
/* 1216 */         if (start < end) {
/* 1217 */           int len = end - start;
/* 1218 */           this.column += len;
/* 1219 */           this.stream.write(text, start, len);
/* 1220 */           start = end;
/*      */         } 
/* 1222 */         if (ch != null) {
/*      */           String data;
/* 1224 */           if (ESCAPE_REPLACEMENTS.containsKey(new Character(ch.charValue()))) {
/* 1225 */             data = "\\" + (String)ESCAPE_REPLACEMENTS.get(new Character(ch.charValue()));
/* 1226 */           } else if (!this.allowUnicode) {
/*      */ 
/*      */             
/* 1229 */             if (ch.charValue() <= 'ÿ') {
/* 1230 */               String s = "0" + Integer.toString(ch.charValue(), 16);
/* 1231 */               data = "\\x" + s.substring(s.length() - 2);
/*      */             } else {
/* 1233 */               String s = "000" + Integer.toString(ch.charValue(), 16);
/* 1234 */               data = "\\u" + s.substring(s.length() - 4);
/*      */             } 
/*      */           } else {
/* 1237 */             data = String.valueOf(ch);
/*      */           } 
/* 1239 */           this.column += data.length();
/* 1240 */           this.stream.write(data);
/* 1241 */           start = end + 1;
/*      */         } 
/*      */       } 
/* 1244 */       if (0 < end && end < text.length() - 1 && (ch.charValue() == ' ' || start >= end) && this.column + end - start > this.bestWidth && split) {
/*      */         String data;
/*      */         
/* 1247 */         if (start >= end) {
/* 1248 */           data = "\\";
/*      */         } else {
/* 1250 */           data = text.substring(start, end) + "\\";
/*      */         } 
/* 1252 */         if (start < end) {
/* 1253 */           start = end;
/*      */         }
/* 1255 */         this.column += data.length();
/* 1256 */         this.stream.write(data);
/* 1257 */         writeIndent();
/* 1258 */         this.whitespace = false;
/* 1259 */         this.indention = false;
/* 1260 */         if (text.charAt(start) == ' ') {
/* 1261 */           data = "\\";
/* 1262 */           this.column += data.length();
/* 1263 */           this.stream.write(data);
/*      */         } 
/*      */       } 
/* 1266 */       end++;
/*      */     } 
/* 1268 */     writeIndicator("\"", false, false, false);
/*      */   }
/*      */   
/*      */   private String determineBlockHints(String text) {
/* 1272 */     StringBuilder hints = new StringBuilder();
/* 1273 */     if (Constant.LINEBR.has(text.charAt(0), " ")) {
/* 1274 */       hints.append(this.bestIndent);
/*      */     }
/* 1276 */     char ch1 = text.charAt(text.length() - 1);
/* 1277 */     if (Constant.LINEBR.hasNo(ch1)) {
/* 1278 */       hints.append("-");
/* 1279 */     } else if (text.length() == 1 || Constant.LINEBR.has(text.charAt(text.length() - 2))) {
/* 1280 */       hints.append("+");
/*      */     } 
/* 1282 */     return hints.toString();
/*      */   }
/*      */   
/*      */   void writeFolded(String text) throws IOException {
/* 1286 */     String hints = determineBlockHints(text);
/* 1287 */     writeIndicator(">" + hints, true, false, false);
/* 1288 */     if (hints.length() > 0 && hints.charAt(hints.length() - 1) == '+') {
/* 1289 */       this.openEnded = true;
/*      */     }
/* 1291 */     writeLineBreak(null);
/* 1292 */     boolean leadingSpace = true;
/* 1293 */     boolean spaces = false;
/* 1294 */     boolean breaks = true;
/* 1295 */     int start = 0, end = 0;
/* 1296 */     while (end <= text.length()) {
/* 1297 */       char ch = Character.MIN_VALUE;
/* 1298 */       if (end < text.length()) {
/* 1299 */         ch = text.charAt(end);
/*      */       }
/* 1301 */       if (breaks) {
/* 1302 */         if (ch == '\000' || Constant.LINEBR.hasNo(ch)) {
/* 1303 */           if (!leadingSpace && ch != '\000' && ch != ' ' && text.charAt(start) == '\n') {
/* 1304 */             writeLineBreak(null);
/*      */           }
/* 1306 */           leadingSpace = (ch == ' ');
/* 1307 */           String data = text.substring(start, end);
/* 1308 */           for (char br : data.toCharArray()) {
/* 1309 */             if (br == '\n') {
/* 1310 */               writeLineBreak(null);
/*      */             } else {
/* 1312 */               writeLineBreak(String.valueOf(br));
/*      */             } 
/*      */           } 
/* 1315 */           if (ch != '\000') {
/* 1316 */             writeIndent();
/*      */           }
/* 1318 */           start = end;
/*      */         } 
/* 1320 */       } else if (spaces) {
/* 1321 */         if (ch != ' ') {
/* 1322 */           if (start + 1 == end && this.column > this.bestWidth) {
/* 1323 */             writeIndent();
/*      */           } else {
/* 1325 */             int len = end - start;
/* 1326 */             this.column += len;
/* 1327 */             this.stream.write(text, start, len);
/*      */           } 
/* 1329 */           start = end;
/*      */         }
/*      */       
/* 1332 */       } else if (Constant.LINEBR.has(ch, "\000 ")) {
/* 1333 */         int len = end - start;
/* 1334 */         this.column += len;
/* 1335 */         this.stream.write(text, start, len);
/* 1336 */         if (ch == '\000') {
/* 1337 */           writeLineBreak(null);
/*      */         }
/* 1339 */         start = end;
/*      */       } 
/*      */       
/* 1342 */       if (ch != '\000') {
/* 1343 */         breaks = Constant.LINEBR.has(ch);
/* 1344 */         spaces = (ch == ' ');
/*      */       } 
/* 1346 */       end++;
/*      */     } 
/*      */   }
/*      */   
/*      */   void writeLiteral(String text) throws IOException {
/* 1351 */     String hints = determineBlockHints(text);
/* 1352 */     writeIndicator("|" + hints, true, false, false);
/* 1353 */     if (hints.length() > 0 && hints.charAt(hints.length() - 1) == '+') {
/* 1354 */       this.openEnded = true;
/*      */     }
/* 1356 */     writeLineBreak(null);
/* 1357 */     boolean breaks = true;
/* 1358 */     int start = 0, end = 0;
/* 1359 */     while (end <= text.length()) {
/* 1360 */       char ch = Character.MIN_VALUE;
/* 1361 */       if (end < text.length()) {
/* 1362 */         ch = text.charAt(end);
/*      */       }
/* 1364 */       if (breaks) {
/* 1365 */         if (ch == '\000' || Constant.LINEBR.hasNo(ch)) {
/* 1366 */           String data = text.substring(start, end);
/* 1367 */           for (char br : data.toCharArray()) {
/* 1368 */             if (br == '\n') {
/* 1369 */               writeLineBreak(null);
/*      */             } else {
/* 1371 */               writeLineBreak(String.valueOf(br));
/*      */             } 
/*      */           } 
/* 1374 */           if (ch != '\000') {
/* 1375 */             writeIndent();
/*      */           }
/* 1377 */           start = end;
/*      */         }
/*      */       
/* 1380 */       } else if (ch == '\000' || Constant.LINEBR.has(ch)) {
/* 1381 */         this.stream.write(text, start, end - start);
/* 1382 */         if (ch == '\000') {
/* 1383 */           writeLineBreak(null);
/*      */         }
/* 1385 */         start = end;
/*      */       } 
/*      */       
/* 1388 */       if (ch != '\000') {
/* 1389 */         breaks = Constant.LINEBR.has(ch);
/*      */       }
/* 1391 */       end++;
/*      */     } 
/*      */   }
/*      */   
/*      */   void writePlain(String text, boolean split) throws IOException {
/* 1396 */     if (this.rootContext) {
/* 1397 */       this.openEnded = true;
/*      */     }
/* 1399 */     if (text.length() == 0) {
/*      */       return;
/*      */     }
/* 1402 */     if (!this.whitespace) {
/* 1403 */       this.column++;
/* 1404 */       this.stream.write(SPACE);
/*      */     } 
/* 1406 */     this.whitespace = false;
/* 1407 */     this.indention = false;
/* 1408 */     boolean spaces = false;
/* 1409 */     boolean breaks = false;
/* 1410 */     int start = 0, end = 0;
/* 1411 */     while (end <= text.length()) {
/* 1412 */       char ch = Character.MIN_VALUE;
/* 1413 */       if (end < text.length()) {
/* 1414 */         ch = text.charAt(end);
/*      */       }
/* 1416 */       if (spaces) {
/* 1417 */         if (ch != ' ') {
/* 1418 */           if (start + 1 == end && this.column > this.bestWidth && split) {
/* 1419 */             writeIndent();
/* 1420 */             this.whitespace = false;
/* 1421 */             this.indention = false;
/*      */           } else {
/* 1423 */             int len = end - start;
/* 1424 */             this.column += len;
/* 1425 */             this.stream.write(text, start, len);
/*      */           } 
/* 1427 */           start = end;
/*      */         } 
/* 1429 */       } else if (breaks) {
/* 1430 */         if (Constant.LINEBR.hasNo(ch)) {
/* 1431 */           if (text.charAt(start) == '\n') {
/* 1432 */             writeLineBreak(null);
/*      */           }
/* 1434 */           String data = text.substring(start, end);
/* 1435 */           for (char br : data.toCharArray()) {
/* 1436 */             if (br == '\n') {
/* 1437 */               writeLineBreak(null);
/*      */             } else {
/* 1439 */               writeLineBreak(String.valueOf(br));
/*      */             } 
/*      */           } 
/* 1442 */           writeIndent();
/* 1443 */           this.whitespace = false;
/* 1444 */           this.indention = false;
/* 1445 */           start = end;
/*      */         }
/*      */       
/* 1448 */       } else if (ch == '\000' || Constant.LINEBR.has(ch)) {
/* 1449 */         int len = end - start;
/* 1450 */         this.column += len;
/* 1451 */         this.stream.write(text, start, len);
/* 1452 */         start = end;
/*      */       } 
/*      */       
/* 1455 */       if (ch != '\000') {
/* 1456 */         spaces = (ch == ' ');
/* 1457 */         breaks = Constant.LINEBR.has(ch);
/*      */       } 
/* 1459 */       end++;
/*      */     } 
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\emitter\Emitter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */