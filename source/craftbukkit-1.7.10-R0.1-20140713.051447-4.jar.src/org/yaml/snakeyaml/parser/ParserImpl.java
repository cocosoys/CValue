/*     */ package org.yaml.snakeyaml.parser;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.yaml.snakeyaml.error.Mark;
/*     */ import org.yaml.snakeyaml.error.YAMLException;
/*     */ import org.yaml.snakeyaml.events.AliasEvent;
/*     */ import org.yaml.snakeyaml.events.DocumentEndEvent;
/*     */ import org.yaml.snakeyaml.events.DocumentStartEvent;
/*     */ import org.yaml.snakeyaml.events.Event;
/*     */ import org.yaml.snakeyaml.events.ImplicitTuple;
/*     */ import org.yaml.snakeyaml.events.MappingEndEvent;
/*     */ import org.yaml.snakeyaml.events.MappingStartEvent;
/*     */ import org.yaml.snakeyaml.events.ScalarEvent;
/*     */ import org.yaml.snakeyaml.events.SequenceEndEvent;
/*     */ import org.yaml.snakeyaml.events.SequenceStartEvent;
/*     */ import org.yaml.snakeyaml.events.StreamEndEvent;
/*     */ import org.yaml.snakeyaml.events.StreamStartEvent;
/*     */ import org.yaml.snakeyaml.reader.StreamReader;
/*     */ import org.yaml.snakeyaml.scanner.Scanner;
/*     */ import org.yaml.snakeyaml.scanner.ScannerImpl;
/*     */ import org.yaml.snakeyaml.tokens.AliasToken;
/*     */ import org.yaml.snakeyaml.tokens.AnchorToken;
/*     */ import org.yaml.snakeyaml.tokens.BlockEntryToken;
/*     */ import org.yaml.snakeyaml.tokens.DirectiveToken;
/*     */ import org.yaml.snakeyaml.tokens.ScalarToken;
/*     */ import org.yaml.snakeyaml.tokens.StreamEndToken;
/*     */ import org.yaml.snakeyaml.tokens.StreamStartToken;
/*     */ import org.yaml.snakeyaml.tokens.TagToken;
/*     */ import org.yaml.snakeyaml.tokens.TagTuple;
/*     */ import org.yaml.snakeyaml.tokens.Token;
/*     */ import org.yaml.snakeyaml.util.ArrayStack;
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
/*     */ public final class ParserImpl
/*     */   implements Parser
/*     */ {
/* 118 */   private static final Map<String, String> DEFAULT_TAGS = new HashMap<String, String>();
/*     */   static {
/* 120 */     DEFAULT_TAGS.put("!", "!");
/* 121 */     DEFAULT_TAGS.put("!!", "tag:yaml.org,2002:");
/*     */   }
/*     */   
/*     */   private final Scanner scanner;
/*     */   private Event currentEvent;
/*     */   private List<Integer> yamlVersion;
/*     */   private Map<String, String> tagHandles;
/*     */   private final ArrayStack<Production> states;
/*     */   private final ArrayStack<Mark> marks;
/*     */   private Production state;
/*     */   
/*     */   public ParserImpl(StreamReader reader) {
/* 133 */     this.scanner = (Scanner)new ScannerImpl(reader);
/* 134 */     this.currentEvent = null;
/* 135 */     this.yamlVersion = null;
/* 136 */     this.tagHandles = new HashMap<String, String>();
/* 137 */     this.states = new ArrayStack(100);
/* 138 */     this.marks = new ArrayStack(10);
/* 139 */     this.state = new ParseStreamStart();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkEvent(Event.ID choices) {
/* 146 */     peekEvent();
/* 147 */     if (this.currentEvent != null && 
/* 148 */       this.currentEvent.is(choices)) {
/* 149 */       return true;
/*     */     }
/*     */     
/* 152 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Event peekEvent() {
/* 159 */     if (this.currentEvent == null && 
/* 160 */       this.state != null) {
/* 161 */       this.currentEvent = this.state.produce();
/*     */     }
/*     */     
/* 164 */     return this.currentEvent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Event getEvent() {
/* 171 */     peekEvent();
/* 172 */     Event value = this.currentEvent;
/* 173 */     this.currentEvent = null;
/* 174 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class ParseStreamStart
/*     */     implements Production
/*     */   {
/*     */     private ParseStreamStart() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public Event produce() {
/* 187 */       StreamStartToken token = (StreamStartToken)ParserImpl.this.scanner.getToken();
/* 188 */       StreamStartEvent streamStartEvent = new StreamStartEvent(token.getStartMark(), token.getEndMark());
/*     */       
/* 190 */       ParserImpl.this.state = new ParserImpl.ParseImplicitDocumentStart();
/* 191 */       return (Event)streamStartEvent;
/*     */     } }
/*     */   
/*     */   private class ParseImplicitDocumentStart implements Production {
/*     */     private ParseImplicitDocumentStart() {}
/*     */     
/*     */     public Event produce() {
/* 198 */       if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.Directive, Token.ID.DocumentStart, Token.ID.StreamEnd })) {
/* 199 */         ParserImpl.this.tagHandles = ParserImpl.DEFAULT_TAGS;
/* 200 */         Token token = ParserImpl.this.scanner.peekToken();
/* 201 */         Mark startMark = token.getStartMark();
/* 202 */         Mark endMark = startMark;
/* 203 */         DocumentStartEvent documentStartEvent = new DocumentStartEvent(startMark, endMark, false, null, null);
/*     */         
/* 205 */         ParserImpl.this.states.push(new ParserImpl.ParseDocumentEnd());
/* 206 */         ParserImpl.this.state = new ParserImpl.ParseBlockNode();
/* 207 */         return (Event)documentStartEvent;
/*     */       } 
/* 209 */       Production p = new ParserImpl.ParseDocumentStart();
/* 210 */       return p.produce();
/*     */     }
/*     */   }
/*     */   
/*     */   private class ParseDocumentStart implements Production {
/*     */     private ParseDocumentStart() {}
/*     */     
/*     */     public Event produce() {
/*     */       StreamEndEvent streamEndEvent;
/* 219 */       while (ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.DocumentEnd })) {
/* 220 */         ParserImpl.this.scanner.getToken();
/*     */       }
/*     */ 
/*     */       
/* 224 */       if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.StreamEnd })) {
/* 225 */         Integer[] versionInteger; Token token = ParserImpl.this.scanner.peekToken();
/* 226 */         Mark startMark = token.getStartMark();
/* 227 */         List<Object> version_tags = ParserImpl.this.processDirectives();
/* 228 */         List<Object> version = (List<Object>)version_tags.get(0);
/* 229 */         Map<String, String> tags = (Map<String, String>)version_tags.get(1);
/* 230 */         if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.DocumentStart })) {
/* 231 */           throw new ParserException(null, null, "expected '<document start>', but found " + ParserImpl.this.scanner.peekToken().getTokenId(), ParserImpl.this.scanner.peekToken().getStartMark());
/*     */         }
/*     */         
/* 234 */         token = ParserImpl.this.scanner.getToken();
/* 235 */         Mark endMark = token.getEndMark();
/*     */         
/* 237 */         if (version != null) {
/* 238 */           versionInteger = new Integer[2];
/* 239 */           versionInteger = version.<Integer>toArray(versionInteger);
/*     */         } else {
/* 241 */           versionInteger = null;
/*     */         } 
/* 243 */         DocumentStartEvent documentStartEvent = new DocumentStartEvent(startMark, endMark, true, versionInteger, tags);
/* 244 */         ParserImpl.this.states.push(new ParserImpl.ParseDocumentEnd());
/* 245 */         ParserImpl.this.state = new ParserImpl.ParseDocumentContent();
/*     */       } else {
/*     */         
/* 248 */         StreamEndToken token = (StreamEndToken)ParserImpl.this.scanner.getToken();
/* 249 */         streamEndEvent = new StreamEndEvent(token.getStartMark(), token.getEndMark());
/* 250 */         if (!ParserImpl.this.states.isEmpty()) {
/* 251 */           throw new YAMLException("Unexpected end of stream. States left: " + ParserImpl.this.states);
/*     */         }
/* 253 */         if (!ParserImpl.this.marks.isEmpty()) {
/* 254 */           throw new YAMLException("Unexpected end of stream. Marks left: " + ParserImpl.this.marks);
/*     */         }
/* 256 */         ParserImpl.this.state = null;
/*     */       } 
/* 258 */       return (Event)streamEndEvent;
/*     */     }
/*     */   }
/*     */   
/*     */   private class ParseDocumentEnd implements Production { private ParseDocumentEnd() {}
/*     */     
/*     */     public Event produce() {
/* 265 */       Token token = ParserImpl.this.scanner.peekToken();
/* 266 */       Mark startMark = token.getStartMark();
/* 267 */       Mark endMark = startMark;
/* 268 */       boolean explicit = false;
/* 269 */       if (ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.DocumentEnd })) {
/* 270 */         token = ParserImpl.this.scanner.getToken();
/* 271 */         endMark = token.getEndMark();
/* 272 */         explicit = true;
/*     */       } 
/* 274 */       DocumentEndEvent documentEndEvent = new DocumentEndEvent(startMark, endMark, explicit);
/*     */       
/* 276 */       ParserImpl.this.state = new ParserImpl.ParseDocumentStart();
/* 277 */       return (Event)documentEndEvent;
/*     */     } }
/*     */   
/*     */   private class ParseDocumentContent implements Production {
/*     */     private ParseDocumentContent() {}
/*     */     
/*     */     public Event produce() {
/* 284 */       if (ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.Directive, Token.ID.DocumentStart, Token.ID.DocumentEnd, Token.ID.StreamEnd })) {
/*     */         
/* 286 */         Event event = ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
/* 287 */         ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
/* 288 */         return event;
/*     */       } 
/* 290 */       Production p = new ParserImpl.ParseBlockNode();
/* 291 */       return p.produce();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private List<Object> processDirectives() {
/* 298 */     this.yamlVersion = null;
/* 299 */     this.tagHandles = new HashMap<String, String>();
/* 300 */     while (this.scanner.checkToken(new Token.ID[] { Token.ID.Directive })) {
/*     */       
/* 302 */       DirectiveToken token = (DirectiveToken)this.scanner.getToken();
/* 303 */       if (token.getName().equals("YAML")) {
/* 304 */         if (this.yamlVersion != null) {
/* 305 */           throw new ParserException(null, null, "found duplicate YAML directive", token.getStartMark());
/*     */         }
/*     */         
/* 308 */         List<Integer> list = token.getValue();
/* 309 */         Integer major = list.get(0);
/* 310 */         if (major.intValue() != 1) {
/* 311 */           throw new ParserException(null, null, "found incompatible YAML document (version 1.* is required)", token.getStartMark());
/*     */         }
/*     */ 
/*     */         
/* 315 */         this.yamlVersion = token.getValue(); continue;
/* 316 */       }  if (token.getName().equals("TAG")) {
/* 317 */         List<String> list = token.getValue();
/* 318 */         String handle = list.get(0);
/* 319 */         String prefix = list.get(1);
/* 320 */         if (this.tagHandles.containsKey(handle)) {
/* 321 */           throw new ParserException(null, null, "duplicate tag handle " + handle, token.getStartMark());
/*     */         }
/*     */         
/* 324 */         this.tagHandles.put(handle, prefix);
/*     */       } 
/*     */     } 
/* 327 */     List<Object> value = new ArrayList(2);
/* 328 */     value.add(this.yamlVersion);
/* 329 */     if (!this.tagHandles.isEmpty()) {
/* 330 */       value.add(new HashMap<String, String>(this.tagHandles));
/*     */     } else {
/* 332 */       value.add(new HashMap<Object, Object>());
/*     */     } 
/* 334 */     for (String key : DEFAULT_TAGS.keySet()) {
/* 335 */       if (!this.tagHandles.containsKey(key)) {
/* 336 */         this.tagHandles.put(key, DEFAULT_TAGS.get(key));
/*     */       }
/*     */     } 
/* 339 */     return value;
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
/*     */   private class ParseBlockNode
/*     */     implements Production
/*     */   {
/*     */     private ParseBlockNode() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Event produce() {
/* 364 */       return ParserImpl.this.parseNode(true, false);
/*     */     }
/*     */   }
/*     */   
/*     */   private Event parseFlowNode() {
/* 369 */     return parseNode(false, false);
/*     */   }
/*     */   
/*     */   private Event parseBlockNodeOrIndentlessSequence() {
/* 373 */     return parseNode(true, true);
/*     */   }
/*     */   
/*     */   private Event parseNode(boolean block, boolean indentlessSequence) {
/*     */     ScalarEvent scalarEvent;
/* 378 */     Mark startMark = null;
/* 379 */     Mark endMark = null;
/* 380 */     Mark tagMark = null;
/* 381 */     if (this.scanner.checkToken(new Token.ID[] { Token.ID.Alias })) {
/* 382 */       AliasToken token = (AliasToken)this.scanner.getToken();
/* 383 */       AliasEvent aliasEvent = new AliasEvent(token.getValue(), token.getStartMark(), token.getEndMark());
/* 384 */       this.state = (Production)this.states.pop();
/*     */     } else {
/* 386 */       String anchor = null;
/* 387 */       TagTuple tagTokenTag = null;
/* 388 */       if (this.scanner.checkToken(new Token.ID[] { Token.ID.Anchor })) {
/* 389 */         AnchorToken token = (AnchorToken)this.scanner.getToken();
/* 390 */         startMark = token.getStartMark();
/* 391 */         endMark = token.getEndMark();
/* 392 */         anchor = token.getValue();
/* 393 */         if (this.scanner.checkToken(new Token.ID[] { Token.ID.Tag })) {
/* 394 */           TagToken tagToken = (TagToken)this.scanner.getToken();
/* 395 */           tagMark = tagToken.getStartMark();
/* 396 */           endMark = tagToken.getEndMark();
/* 397 */           tagTokenTag = tagToken.getValue();
/*     */         } 
/*     */       } else {
/* 400 */         TagToken tagToken = (TagToken)this.scanner.getToken();
/* 401 */         startMark = tagToken.getStartMark();
/* 402 */         tagMark = startMark;
/* 403 */         endMark = tagToken.getEndMark();
/* 404 */         tagTokenTag = tagToken.getValue();
/* 405 */         if (this.scanner.checkToken(new Token.ID[] { Token.ID.Tag }) && this.scanner.checkToken(new Token.ID[] { Token.ID.Anchor })) {
/* 406 */           AnchorToken token = (AnchorToken)this.scanner.getToken();
/* 407 */           endMark = token.getEndMark();
/* 408 */           anchor = token.getValue();
/*     */         } 
/*     */       } 
/* 411 */       String tag = null;
/* 412 */       if (tagTokenTag != null) {
/* 413 */         String handle = tagTokenTag.getHandle();
/* 414 */         String suffix = tagTokenTag.getSuffix();
/* 415 */         if (handle != null) {
/* 416 */           if (!this.tagHandles.containsKey(handle)) {
/* 417 */             throw new ParserException("while parsing a node", startMark, "found undefined tag handle " + handle, tagMark);
/*     */           }
/*     */           
/* 420 */           tag = (String)this.tagHandles.get(handle) + suffix;
/*     */         } else {
/* 422 */           tag = suffix;
/*     */         } 
/*     */       } 
/* 425 */       if (startMark == null) {
/* 426 */         startMark = this.scanner.peekToken().getStartMark();
/* 427 */         endMark = startMark;
/*     */       } 
/* 429 */       Event event = null;
/* 430 */       boolean implicit = (tag == null || tag.equals("!"));
/* 431 */       if (indentlessSequence && this.scanner.checkToken(new Token.ID[] { Token.ID.BlockEntry })) {
/* 432 */         endMark = this.scanner.peekToken().getEndMark();
/* 433 */         SequenceStartEvent sequenceStartEvent = new SequenceStartEvent(anchor, tag, implicit, startMark, endMark, Boolean.FALSE);
/*     */         
/* 435 */         this.state = new ParseIndentlessSequenceEntry();
/*     */       }
/* 437 */       else if (this.scanner.checkToken(new Token.ID[] { Token.ID.Scalar })) {
/* 438 */         ImplicitTuple implicitValues; ScalarToken token = (ScalarToken)this.scanner.getToken();
/* 439 */         endMark = token.getEndMark();
/*     */         
/* 441 */         if ((token.getPlain() && tag == null) || "!".equals(tag)) {
/* 442 */           implicitValues = new ImplicitTuple(true, false);
/* 443 */         } else if (tag == null) {
/* 444 */           implicitValues = new ImplicitTuple(false, true);
/*     */         } else {
/* 446 */           implicitValues = new ImplicitTuple(false, false);
/*     */         } 
/* 448 */         scalarEvent = new ScalarEvent(anchor, tag, implicitValues, token.getValue(), startMark, endMark, Character.valueOf(token.getStyle()));
/*     */         
/* 450 */         this.state = (Production)this.states.pop();
/* 451 */       } else if (this.scanner.checkToken(new Token.ID[] { Token.ID.FlowSequenceStart })) {
/* 452 */         endMark = this.scanner.peekToken().getEndMark();
/* 453 */         SequenceStartEvent sequenceStartEvent = new SequenceStartEvent(anchor, tag, implicit, startMark, endMark, Boolean.TRUE);
/*     */         
/* 455 */         this.state = new ParseFlowSequenceFirstEntry();
/* 456 */       } else if (this.scanner.checkToken(new Token.ID[] { Token.ID.FlowMappingStart })) {
/* 457 */         endMark = this.scanner.peekToken().getEndMark();
/* 458 */         MappingStartEvent mappingStartEvent = new MappingStartEvent(anchor, tag, implicit, startMark, endMark, Boolean.TRUE);
/*     */         
/* 460 */         this.state = new ParseFlowMappingFirstKey();
/* 461 */       } else if (block && this.scanner.checkToken(new Token.ID[] { Token.ID.BlockSequenceStart })) {
/* 462 */         endMark = this.scanner.peekToken().getStartMark();
/* 463 */         SequenceStartEvent sequenceStartEvent = new SequenceStartEvent(anchor, tag, implicit, startMark, endMark, Boolean.FALSE);
/*     */         
/* 465 */         this.state = new ParseBlockSequenceFirstEntry();
/* 466 */       } else if (block && this.scanner.checkToken(new Token.ID[] { Token.ID.BlockMappingStart })) {
/* 467 */         endMark = this.scanner.peekToken().getStartMark();
/* 468 */         MappingStartEvent mappingStartEvent = new MappingStartEvent(anchor, tag, implicit, startMark, endMark, Boolean.FALSE);
/*     */         
/* 470 */         this.state = new ParseBlockMappingFirstKey();
/* 471 */       } else if (anchor != null || tag != null) {
/*     */ 
/*     */         
/* 474 */         scalarEvent = new ScalarEvent(anchor, tag, new ImplicitTuple(implicit, false), "", startMark, endMark, Character.valueOf(false));
/*     */         
/* 476 */         this.state = (Production)this.states.pop();
/*     */       } else {
/*     */         String node;
/* 479 */         if (block) {
/* 480 */           node = "block";
/*     */         } else {
/* 482 */           node = "flow";
/*     */         } 
/* 484 */         Token token = this.scanner.peekToken();
/* 485 */         throw new ParserException("while parsing a " + node + " node", startMark, "expected the node content, but found " + token.getTokenId(), token.getStartMark());
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 491 */     return (Event)scalarEvent;
/*     */   }
/*     */   
/*     */   private class ParseBlockSequenceFirstEntry
/*     */     implements Production {
/*     */     private ParseBlockSequenceFirstEntry() {}
/*     */     
/*     */     public Event produce() {
/* 499 */       Token token = ParserImpl.this.scanner.getToken();
/* 500 */       ParserImpl.this.marks.push(token.getStartMark());
/* 501 */       return (new ParserImpl.ParseBlockSequenceEntry()).produce();
/*     */     } }
/*     */   
/*     */   private class ParseBlockSequenceEntry implements Production { private ParseBlockSequenceEntry() {}
/*     */     
/*     */     public Event produce() {
/* 507 */       if (ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.BlockEntry })) {
/* 508 */         BlockEntryToken blockEntryToken = (BlockEntryToken)ParserImpl.this.scanner.getToken();
/* 509 */         if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.BlockEntry, Token.ID.BlockEnd })) {
/* 510 */           ParserImpl.this.states.push(new ParseBlockSequenceEntry());
/* 511 */           return (new ParserImpl.ParseBlockNode()).produce();
/*     */         } 
/* 513 */         ParserImpl.this.state = new ParseBlockSequenceEntry();
/* 514 */         return ParserImpl.this.processEmptyScalar(blockEntryToken.getEndMark());
/*     */       } 
/*     */       
/* 517 */       if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.BlockEnd })) {
/* 518 */         Token token1 = ParserImpl.this.scanner.peekToken();
/* 519 */         throw new ParserException("while parsing a block collection", (Mark)ParserImpl.this.marks.pop(), "expected <block end>, but found " + token1.getTokenId(), token1.getStartMark());
/*     */       } 
/*     */ 
/*     */       
/* 523 */       Token token = ParserImpl.this.scanner.getToken();
/* 524 */       SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
/* 525 */       ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
/* 526 */       ParserImpl.this.marks.pop();
/* 527 */       return (Event)sequenceEndEvent;
/*     */     } }
/*     */ 
/*     */   
/*     */   private class ParseIndentlessSequenceEntry implements Production {
/*     */     private ParseIndentlessSequenceEntry() {}
/*     */     
/*     */     public Event produce() {
/* 535 */       if (ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.BlockEntry })) {
/* 536 */         Token token1 = ParserImpl.this.scanner.getToken();
/* 537 */         if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.BlockEntry, Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd })) {
/*     */           
/* 539 */           ParserImpl.this.states.push(new ParseIndentlessSequenceEntry());
/* 540 */           return (new ParserImpl.ParseBlockNode()).produce();
/*     */         } 
/* 542 */         ParserImpl.this.state = new ParseIndentlessSequenceEntry();
/* 543 */         return ParserImpl.this.processEmptyScalar(token1.getEndMark());
/*     */       } 
/*     */       
/* 546 */       Token token = ParserImpl.this.scanner.peekToken();
/* 547 */       SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
/* 548 */       ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
/* 549 */       return (Event)sequenceEndEvent;
/*     */     } }
/*     */   
/*     */   private class ParseBlockMappingFirstKey implements Production { private ParseBlockMappingFirstKey() {}
/*     */     
/*     */     public Event produce() {
/* 555 */       Token token = ParserImpl.this.scanner.getToken();
/* 556 */       ParserImpl.this.marks.push(token.getStartMark());
/* 557 */       return (new ParserImpl.ParseBlockMappingKey()).produce();
/*     */     } }
/*     */   
/*     */   private class ParseBlockMappingKey implements Production { private ParseBlockMappingKey() {}
/*     */     
/*     */     public Event produce() {
/* 563 */       if (ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.Key })) {
/* 564 */         Token token1 = ParserImpl.this.scanner.getToken();
/* 565 */         if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd })) {
/* 566 */           ParserImpl.this.states.push(new ParserImpl.ParseBlockMappingValue());
/* 567 */           return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
/*     */         } 
/* 569 */         ParserImpl.this.state = new ParserImpl.ParseBlockMappingValue();
/* 570 */         return ParserImpl.this.processEmptyScalar(token1.getEndMark());
/*     */       } 
/*     */       
/* 573 */       if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.BlockEnd })) {
/* 574 */         Token token1 = ParserImpl.this.scanner.peekToken();
/* 575 */         throw new ParserException("while parsing a block mapping", (Mark)ParserImpl.this.marks.pop(), "expected <block end>, but found " + token1.getTokenId(), token1.getStartMark());
/*     */       } 
/*     */ 
/*     */       
/* 579 */       Token token = ParserImpl.this.scanner.getToken();
/* 580 */       MappingEndEvent mappingEndEvent = new MappingEndEvent(token.getStartMark(), token.getEndMark());
/* 581 */       ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
/* 582 */       ParserImpl.this.marks.pop();
/* 583 */       return (Event)mappingEndEvent;
/*     */     } }
/*     */   
/*     */   private class ParseBlockMappingValue implements Production { private ParseBlockMappingValue() {}
/*     */     
/*     */     public Event produce() {
/* 589 */       if (ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.Value })) {
/* 590 */         Token token1 = ParserImpl.this.scanner.getToken();
/* 591 */         if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd })) {
/* 592 */           ParserImpl.this.states.push(new ParserImpl.ParseBlockMappingKey());
/* 593 */           return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
/*     */         } 
/* 595 */         ParserImpl.this.state = new ParserImpl.ParseBlockMappingKey();
/* 596 */         return ParserImpl.this.processEmptyScalar(token1.getEndMark());
/*     */       } 
/*     */       
/* 599 */       ParserImpl.this.state = new ParserImpl.ParseBlockMappingKey();
/* 600 */       Token token = ParserImpl.this.scanner.peekToken();
/* 601 */       return ParserImpl.this.processEmptyScalar(token.getStartMark());
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class ParseFlowSequenceFirstEntry
/*     */     implements Production
/*     */   {
/*     */     private ParseFlowSequenceFirstEntry() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Event produce() {
/* 620 */       Token token = ParserImpl.this.scanner.getToken();
/* 621 */       ParserImpl.this.marks.push(token.getStartMark());
/* 622 */       return (new ParserImpl.ParseFlowSequenceEntry(true)).produce();
/*     */     }
/*     */   }
/*     */   
/*     */   private class ParseFlowSequenceEntry implements Production {
/*     */     private boolean first = false;
/*     */     
/*     */     public ParseFlowSequenceEntry(boolean first) {
/* 630 */       this.first = first;
/*     */     }
/*     */     
/*     */     public Event produce() {
/* 634 */       if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.FlowSequenceEnd })) {
/* 635 */         if (!this.first) {
/* 636 */           if (ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.FlowEntry })) {
/* 637 */             ParserImpl.this.scanner.getToken();
/*     */           } else {
/* 639 */             Token token1 = ParserImpl.this.scanner.peekToken();
/* 640 */             throw new ParserException("while parsing a flow sequence", (Mark)ParserImpl.this.marks.pop(), "expected ',' or ']', but got " + token1.getTokenId(), token1.getStartMark());
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/* 645 */         if (ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.Key })) {
/* 646 */           Token token1 = ParserImpl.this.scanner.peekToken();
/* 647 */           MappingStartEvent mappingStartEvent = new MappingStartEvent(null, null, true, token1.getStartMark(), token1.getEndMark(), Boolean.TRUE);
/*     */           
/* 649 */           ParserImpl.this.state = new ParserImpl.ParseFlowSequenceEntryMappingKey();
/* 650 */           return (Event)mappingStartEvent;
/* 651 */         }  if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.FlowSequenceEnd })) {
/* 652 */           ParserImpl.this.states.push(new ParseFlowSequenceEntry(false));
/* 653 */           return ParserImpl.this.parseFlowNode();
/*     */         } 
/*     */       } 
/* 656 */       Token token = ParserImpl.this.scanner.getToken();
/* 657 */       SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
/* 658 */       ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
/* 659 */       ParserImpl.this.marks.pop();
/* 660 */       return (Event)sequenceEndEvent;
/*     */     } }
/*     */   
/*     */   private class ParseFlowSequenceEntryMappingKey implements Production { private ParseFlowSequenceEntryMappingKey() {}
/*     */     
/*     */     public Event produce() {
/* 666 */       Token token = ParserImpl.this.scanner.getToken();
/* 667 */       if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowSequenceEnd })) {
/* 668 */         ParserImpl.this.states.push(new ParserImpl.ParseFlowSequenceEntryMappingValue());
/* 669 */         return ParserImpl.this.parseFlowNode();
/*     */       } 
/* 671 */       ParserImpl.this.state = new ParserImpl.ParseFlowSequenceEntryMappingValue();
/* 672 */       return ParserImpl.this.processEmptyScalar(token.getEndMark());
/*     */     } }
/*     */ 
/*     */   
/*     */   private class ParseFlowSequenceEntryMappingValue implements Production { private ParseFlowSequenceEntryMappingValue() {}
/*     */     
/*     */     public Event produce() {
/* 679 */       if (ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.Value })) {
/* 680 */         Token token1 = ParserImpl.this.scanner.getToken();
/* 681 */         if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.FlowEntry, Token.ID.FlowSequenceEnd })) {
/* 682 */           ParserImpl.this.states.push(new ParserImpl.ParseFlowSequenceEntryMappingEnd());
/* 683 */           return ParserImpl.this.parseFlowNode();
/*     */         } 
/* 685 */         ParserImpl.this.state = new ParserImpl.ParseFlowSequenceEntryMappingEnd();
/* 686 */         return ParserImpl.this.processEmptyScalar(token1.getEndMark());
/*     */       } 
/*     */       
/* 689 */       ParserImpl.this.state = new ParserImpl.ParseFlowSequenceEntryMappingEnd();
/* 690 */       Token token = ParserImpl.this.scanner.peekToken();
/* 691 */       return ParserImpl.this.processEmptyScalar(token.getStartMark());
/*     */     } }
/*     */   
/*     */   private class ParseFlowSequenceEntryMappingEnd implements Production {
/*     */     private ParseFlowSequenceEntryMappingEnd() {}
/*     */     
/*     */     public Event produce() {
/* 698 */       ParserImpl.this.state = new ParserImpl.ParseFlowSequenceEntry(false);
/* 699 */       Token token = ParserImpl.this.scanner.peekToken();
/* 700 */       return (Event)new MappingEndEvent(token.getStartMark(), token.getEndMark());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class ParseFlowMappingFirstKey
/*     */     implements Production
/*     */   {
/*     */     private ParseFlowMappingFirstKey() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public Event produce() {
/* 715 */       Token token = ParserImpl.this.scanner.getToken();
/* 716 */       ParserImpl.this.marks.push(token.getStartMark());
/* 717 */       return (new ParserImpl.ParseFlowMappingKey(true)).produce();
/*     */     }
/*     */   }
/*     */   
/*     */   private class ParseFlowMappingKey implements Production {
/*     */     private boolean first = false;
/*     */     
/*     */     public ParseFlowMappingKey(boolean first) {
/* 725 */       this.first = first;
/*     */     }
/*     */     
/*     */     public Event produce() {
/* 729 */       if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.FlowMappingEnd })) {
/* 730 */         if (!this.first) {
/* 731 */           if (ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.FlowEntry })) {
/* 732 */             ParserImpl.this.scanner.getToken();
/*     */           } else {
/* 734 */             Token token1 = ParserImpl.this.scanner.peekToken();
/* 735 */             throw new ParserException("while parsing a flow mapping", (Mark)ParserImpl.this.marks.pop(), "expected ',' or '}', but got " + token1.getTokenId(), token1.getStartMark());
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/* 740 */         if (ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.Key })) {
/* 741 */           Token token1 = ParserImpl.this.scanner.getToken();
/* 742 */           if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowMappingEnd })) {
/*     */             
/* 744 */             ParserImpl.this.states.push(new ParserImpl.ParseFlowMappingValue());
/* 745 */             return ParserImpl.this.parseFlowNode();
/*     */           } 
/* 747 */           ParserImpl.this.state = new ParserImpl.ParseFlowMappingValue();
/* 748 */           return ParserImpl.this.processEmptyScalar(token1.getEndMark());
/*     */         } 
/* 750 */         if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.FlowMappingEnd })) {
/* 751 */           ParserImpl.this.states.push(new ParserImpl.ParseFlowMappingEmptyValue());
/* 752 */           return ParserImpl.this.parseFlowNode();
/*     */         } 
/*     */       } 
/* 755 */       Token token = ParserImpl.this.scanner.getToken();
/* 756 */       MappingEndEvent mappingEndEvent = new MappingEndEvent(token.getStartMark(), token.getEndMark());
/* 757 */       ParserImpl.this.state = (Production)ParserImpl.this.states.pop();
/* 758 */       ParserImpl.this.marks.pop();
/* 759 */       return (Event)mappingEndEvent;
/*     */     } }
/*     */   
/*     */   private class ParseFlowMappingValue implements Production { private ParseFlowMappingValue() {}
/*     */     
/*     */     public Event produce() {
/* 765 */       if (ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.Value })) {
/* 766 */         Token token1 = ParserImpl.this.scanner.getToken();
/* 767 */         if (!ParserImpl.this.scanner.checkToken(new Token.ID[] { Token.ID.FlowEntry, Token.ID.FlowMappingEnd })) {
/* 768 */           ParserImpl.this.states.push(new ParserImpl.ParseFlowMappingKey(false));
/* 769 */           return ParserImpl.this.parseFlowNode();
/*     */         } 
/* 771 */         ParserImpl.this.state = new ParserImpl.ParseFlowMappingKey(false);
/* 772 */         return ParserImpl.this.processEmptyScalar(token1.getEndMark());
/*     */       } 
/*     */       
/* 775 */       ParserImpl.this.state = new ParserImpl.ParseFlowMappingKey(false);
/* 776 */       Token token = ParserImpl.this.scanner.peekToken();
/* 777 */       return ParserImpl.this.processEmptyScalar(token.getStartMark());
/*     */     } }
/*     */   
/*     */   private class ParseFlowMappingEmptyValue implements Production {
/*     */     private ParseFlowMappingEmptyValue() {}
/*     */     
/*     */     public Event produce() {
/* 784 */       ParserImpl.this.state = new ParserImpl.ParseFlowMappingKey(false);
/* 785 */       return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
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
/*     */   private Event processEmptyScalar(Mark mark) {
/* 798 */     return (Event)new ScalarEvent(null, null, new ImplicitTuple(true, false), "", mark, mark, Character.valueOf(false));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\parser\ParserImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */