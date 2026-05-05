/*      */ package org.yaml.snakeyaml.scanner;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.charset.CharacterCodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.regex.Pattern;
/*      */ import org.yaml.snakeyaml.error.Mark;
/*      */ import org.yaml.snakeyaml.error.YAMLException;
/*      */ import org.yaml.snakeyaml.reader.StreamReader;
/*      */ import org.yaml.snakeyaml.tokens.AliasToken;
/*      */ import org.yaml.snakeyaml.tokens.AnchorToken;
/*      */ import org.yaml.snakeyaml.tokens.BlockEndToken;
/*      */ import org.yaml.snakeyaml.tokens.BlockEntryToken;
/*      */ import org.yaml.snakeyaml.tokens.BlockMappingStartToken;
/*      */ import org.yaml.snakeyaml.tokens.BlockSequenceStartToken;
/*      */ import org.yaml.snakeyaml.tokens.DirectiveToken;
/*      */ import org.yaml.snakeyaml.tokens.DocumentEndToken;
/*      */ import org.yaml.snakeyaml.tokens.DocumentStartToken;
/*      */ import org.yaml.snakeyaml.tokens.FlowEntryToken;
/*      */ import org.yaml.snakeyaml.tokens.FlowMappingEndToken;
/*      */ import org.yaml.snakeyaml.tokens.FlowMappingStartToken;
/*      */ import org.yaml.snakeyaml.tokens.FlowSequenceEndToken;
/*      */ import org.yaml.snakeyaml.tokens.FlowSequenceStartToken;
/*      */ import org.yaml.snakeyaml.tokens.KeyToken;
/*      */ import org.yaml.snakeyaml.tokens.ScalarToken;
/*      */ import org.yaml.snakeyaml.tokens.StreamEndToken;
/*      */ import org.yaml.snakeyaml.tokens.StreamStartToken;
/*      */ import org.yaml.snakeyaml.tokens.TagToken;
/*      */ import org.yaml.snakeyaml.tokens.TagTuple;
/*      */ import org.yaml.snakeyaml.tokens.Token;
/*      */ import org.yaml.snakeyaml.tokens.ValueToken;
/*      */ import org.yaml.snakeyaml.util.ArrayStack;
/*      */ import org.yaml.snakeyaml.util.UriEncoder;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class ScannerImpl
/*      */   implements Scanner
/*      */ {
/*   84 */   private static final Pattern NOT_HEXA = Pattern.compile("[^0-9A-Fa-f]");
/*   85 */   public static final Map<Character, String> ESCAPE_REPLACEMENTS = new HashMap<Character, String>();
/*   86 */   public static final Map<Character, Integer> ESCAPE_CODES = new HashMap<Character, Integer>(); private final StreamReader reader;
/*      */   
/*      */   static {
/*   89 */     ESCAPE_REPLACEMENTS.put(new Character('0'), "\000");
/*   90 */     ESCAPE_REPLACEMENTS.put(new Character('a'), "\007");
/*   91 */     ESCAPE_REPLACEMENTS.put(new Character('b'), "\b");
/*   92 */     ESCAPE_REPLACEMENTS.put(new Character('t'), "\t");
/*   93 */     ESCAPE_REPLACEMENTS.put(new Character('n'), "\n");
/*   94 */     ESCAPE_REPLACEMENTS.put(new Character('v'), "\013");
/*   95 */     ESCAPE_REPLACEMENTS.put(new Character('f'), "\f");
/*   96 */     ESCAPE_REPLACEMENTS.put(new Character('r'), "\r");
/*   97 */     ESCAPE_REPLACEMENTS.put(new Character('e'), "\033");
/*   98 */     ESCAPE_REPLACEMENTS.put(new Character(' '), " ");
/*   99 */     ESCAPE_REPLACEMENTS.put(new Character('"'), "\"");
/*  100 */     ESCAPE_REPLACEMENTS.put(new Character('\\'), "\\");
/*  101 */     ESCAPE_REPLACEMENTS.put(new Character('N'), "");
/*  102 */     ESCAPE_REPLACEMENTS.put(new Character('_'), " ");
/*  103 */     ESCAPE_REPLACEMENTS.put(new Character('L'), " ");
/*  104 */     ESCAPE_REPLACEMENTS.put(new Character('P'), " ");
/*      */     
/*  106 */     ESCAPE_CODES.put(new Character('x'), Integer.valueOf(2));
/*  107 */     ESCAPE_CODES.put(new Character('u'), Integer.valueOf(4));
/*  108 */     ESCAPE_CODES.put(new Character('U'), Integer.valueOf(8));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean done = false;
/*      */ 
/*      */   
/*  116 */   private int flowLevel = 0;
/*      */ 
/*      */   
/*      */   private List<Token> tokens;
/*      */ 
/*      */   
/*  122 */   private int tokensTaken = 0;
/*      */ 
/*      */   
/*  125 */   private int indent = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ArrayStack<Integer> indents;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean allowSimpleKey = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<Integer, SimpleKey> possibleSimpleKeys;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ScannerImpl(StreamReader reader) {
/*  166 */     this.reader = reader;
/*  167 */     this.tokens = new ArrayList<Token>(100);
/*  168 */     this.indents = new ArrayStack(10);
/*      */     
/*  170 */     this.possibleSimpleKeys = new LinkedHashMap<Integer, SimpleKey>();
/*  171 */     fetchStreamStart();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean checkToken(Token.ID... choices) {
/*  178 */     while (needMoreTokens()) {
/*  179 */       fetchMoreTokens();
/*      */     }
/*  181 */     if (!this.tokens.isEmpty()) {
/*  182 */       if (choices.length == 0) {
/*  183 */         return true;
/*      */       }
/*      */ 
/*      */       
/*  187 */       Token.ID first = ((Token)this.tokens.get(0)).getTokenId();
/*  188 */       for (int i = 0; i < choices.length; i++) {
/*  189 */         if (first == choices[i]) {
/*  190 */           return true;
/*      */         }
/*      */       } 
/*      */     } 
/*  194 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Token peekToken() {
/*  201 */     while (needMoreTokens()) {
/*  202 */       fetchMoreTokens();
/*      */     }
/*  204 */     return this.tokens.get(0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Token getToken() {
/*  211 */     if (!this.tokens.isEmpty()) {
/*  212 */       this.tokensTaken++;
/*  213 */       return this.tokens.remove(0);
/*      */     } 
/*  215 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean needMoreTokens() {
/*  221 */     if (this.done) {
/*  222 */       return false;
/*      */     }
/*  224 */     if (this.tokens.isEmpty()) {
/*  225 */       return true;
/*      */     }
/*      */ 
/*      */     
/*  229 */     stalePossibleSimpleKeys();
/*  230 */     return (nextPossibleSimpleKey() == this.tokensTaken);
/*      */   }
/*      */ 
/*      */   
/*      */   private void fetchMoreTokens() {
/*  235 */     scanToNextToken();
/*      */     
/*  237 */     stalePossibleSimpleKeys();
/*      */ 
/*      */     
/*  240 */     unwindIndent(this.reader.getColumn());
/*      */     
/*  242 */     char ch = this.reader.peek();
/*  243 */     switch (ch) {
/*      */       
/*      */       case '\000':
/*  246 */         fetchStreamEnd();
/*      */         return;
/*      */       
/*      */       case '%':
/*  250 */         if (checkDirective()) {
/*  251 */           fetchDirective();
/*      */           return;
/*      */         } 
/*      */         break;
/*      */       
/*      */       case '-':
/*  257 */         if (checkDocumentStart()) {
/*  258 */           fetchDocumentStart();
/*      */           return;
/*      */         } 
/*  261 */         if (checkBlockEntry()) {
/*  262 */           fetchBlockEntry();
/*      */           return;
/*      */         } 
/*      */         break;
/*      */       
/*      */       case '.':
/*  268 */         if (checkDocumentEnd()) {
/*  269 */           fetchDocumentEnd();
/*      */           return;
/*      */         } 
/*      */         break;
/*      */ 
/*      */       
/*      */       case '[':
/*  276 */         fetchFlowSequenceStart();
/*      */         return;
/*      */       
/*      */       case '{':
/*  280 */         fetchFlowMappingStart();
/*      */         return;
/*      */       
/*      */       case ']':
/*  284 */         fetchFlowSequenceEnd();
/*      */         return;
/*      */       
/*      */       case '}':
/*  288 */         fetchFlowMappingEnd();
/*      */         return;
/*      */       
/*      */       case ',':
/*  292 */         fetchFlowEntry();
/*      */         return;
/*      */ 
/*      */       
/*      */       case '?':
/*  297 */         if (checkKey()) {
/*  298 */           fetchKey();
/*      */           return;
/*      */         } 
/*      */         break;
/*      */       
/*      */       case ':':
/*  304 */         if (checkValue()) {
/*  305 */           fetchValue();
/*      */           return;
/*      */         } 
/*      */         break;
/*      */       
/*      */       case '*':
/*  311 */         fetchAlias();
/*      */         return;
/*      */       
/*      */       case '&':
/*  315 */         fetchAnchor();
/*      */         return;
/*      */       
/*      */       case '!':
/*  319 */         fetchTag();
/*      */         return;
/*      */       
/*      */       case '|':
/*  323 */         if (this.flowLevel == 0) {
/*  324 */           fetchLiteral();
/*      */           return;
/*      */         } 
/*      */         break;
/*      */       
/*      */       case '>':
/*  330 */         if (this.flowLevel == 0) {
/*  331 */           fetchFolded();
/*      */           return;
/*      */         } 
/*      */         break;
/*      */       
/*      */       case '\'':
/*  337 */         fetchSingle();
/*      */         return;
/*      */       
/*      */       case '"':
/*  341 */         fetchDouble();
/*      */         return;
/*      */     } 
/*      */     
/*  345 */     if (checkPlain()) {
/*  346 */       fetchPlain();
/*      */       
/*      */       return;
/*      */     } 
/*  350 */     String chRepresentation = String.valueOf(ch);
/*  351 */     for (Character s : ESCAPE_REPLACEMENTS.keySet()) {
/*  352 */       String v = ESCAPE_REPLACEMENTS.get(s);
/*  353 */       if (v.equals(chRepresentation)) {
/*  354 */         chRepresentation = "\\" + s;
/*      */         break;
/*      */       } 
/*      */     } 
/*  358 */     throw new ScannerException("while scanning for the next token", null, "found character " + ch + "'" + chRepresentation + "' that cannot start any token", this.reader.getMark());
/*      */   }
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
/*      */   private int nextPossibleSimpleKey() {
/*  373 */     if (!this.possibleSimpleKeys.isEmpty()) {
/*  374 */       return ((SimpleKey)this.possibleSimpleKeys.values().iterator().next()).getTokenNumber();
/*      */     }
/*  376 */     return -1;
/*      */   }
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
/*      */   private void stalePossibleSimpleKeys() {
/*  391 */     if (!this.possibleSimpleKeys.isEmpty()) {
/*  392 */       Iterator<SimpleKey> iterator = this.possibleSimpleKeys.values().iterator();
/*  393 */       while (iterator.hasNext()) {
/*  394 */         SimpleKey key = iterator.next();
/*  395 */         if (key.getLine() != this.reader.getLine() || this.reader.getIndex() - key.getIndex() > 1024) {
/*      */           
/*  397 */           if (key.isRequired()) {
/*  398 */             throw new ScannerException("while scanning a simple key", key.getMark(), "could not found expected ':'", this.reader.getMark());
/*      */           }
/*      */           
/*  401 */           iterator.remove();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
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
/*      */   private void savePossibleSimpleKey() {
/*  418 */     boolean required = (this.flowLevel == 0 && this.indent == this.reader.getColumn());
/*      */     
/*  420 */     if (this.allowSimpleKey || !required) {
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
/*  431 */       if (this.allowSimpleKey) {
/*  432 */         removePossibleSimpleKey();
/*  433 */         int tokenNumber = this.tokensTaken + this.tokens.size();
/*  434 */         SimpleKey key = new SimpleKey(tokenNumber, required, this.reader.getIndex(), this.reader.getLine(), this.reader.getColumn(), this.reader.getMark());
/*      */         
/*  436 */         this.possibleSimpleKeys.put(Integer.valueOf(this.flowLevel), key);
/*      */       } 
/*      */       return;
/*      */     } 
/*      */     throw new YAMLException("A simple key is required only if it is the first token in the current line");
/*      */   }
/*      */   
/*      */   private void removePossibleSimpleKey() {
/*  444 */     SimpleKey key = this.possibleSimpleKeys.remove(Integer.valueOf(this.flowLevel));
/*  445 */     if (key != null && key.isRequired()) {
/*  446 */       throw new ScannerException("while scanning a simple key", key.getMark(), "could not found expected ':'", this.reader.getMark());
/*      */     }
/*      */   }
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
/*      */   private void unwindIndent(int col) {
/*  466 */     if (this.flowLevel != 0) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  471 */     while (this.indent > col) {
/*  472 */       Mark mark = this.reader.getMark();
/*  473 */       this.indent = ((Integer)this.indents.pop()).intValue();
/*  474 */       this.tokens.add(new BlockEndToken(mark, mark));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean addIndent(int column) {
/*  482 */     if (this.indent < column) {
/*  483 */       this.indents.push(Integer.valueOf(this.indent));
/*  484 */       this.indent = column;
/*  485 */       return true;
/*      */     } 
/*  487 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void fetchStreamStart() {
/*  498 */     Mark mark = this.reader.getMark();
/*      */ 
/*      */     
/*  501 */     StreamStartToken streamStartToken = new StreamStartToken(mark, mark);
/*  502 */     this.tokens.add(streamStartToken);
/*      */   }
/*      */ 
/*      */   
/*      */   private void fetchStreamEnd() {
/*  507 */     unwindIndent(-1);
/*      */ 
/*      */     
/*  510 */     removePossibleSimpleKey();
/*  511 */     this.allowSimpleKey = false;
/*  512 */     this.possibleSimpleKeys.clear();
/*      */ 
/*      */     
/*  515 */     Mark mark = this.reader.getMark();
/*      */ 
/*      */     
/*  518 */     StreamEndToken streamEndToken = new StreamEndToken(mark, mark);
/*  519 */     this.tokens.add(streamEndToken);
/*      */ 
/*      */     
/*  522 */     this.done = true;
/*      */   }
/*      */ 
/*      */   
/*      */   private void fetchDirective() {
/*  527 */     unwindIndent(-1);
/*      */ 
/*      */     
/*  530 */     removePossibleSimpleKey();
/*  531 */     this.allowSimpleKey = false;
/*      */ 
/*      */     
/*  534 */     Token tok = scanDirective();
/*  535 */     this.tokens.add(tok);
/*      */   }
/*      */   
/*      */   private void fetchDocumentStart() {
/*  539 */     fetchDocumentIndicator(true);
/*      */   }
/*      */   
/*      */   private void fetchDocumentEnd() {
/*  543 */     fetchDocumentIndicator(false);
/*      */   }
/*      */   
/*      */   private void fetchDocumentIndicator(boolean isDocumentStart) {
/*      */     DocumentEndToken documentEndToken;
/*  548 */     unwindIndent(-1);
/*      */ 
/*      */ 
/*      */     
/*  552 */     removePossibleSimpleKey();
/*  553 */     this.allowSimpleKey = false;
/*      */ 
/*      */     
/*  556 */     Mark startMark = this.reader.getMark();
/*  557 */     this.reader.forward(3);
/*  558 */     Mark endMark = this.reader.getMark();
/*      */     
/*  560 */     if (isDocumentStart) {
/*  561 */       DocumentStartToken documentStartToken = new DocumentStartToken(startMark, endMark);
/*      */     } else {
/*  563 */       documentEndToken = new DocumentEndToken(startMark, endMark);
/*      */     } 
/*  565 */     this.tokens.add(documentEndToken);
/*      */   }
/*      */   
/*      */   private void fetchFlowSequenceStart() {
/*  569 */     fetchFlowCollectionStart(false);
/*      */   }
/*      */   
/*      */   private void fetchFlowMappingStart() {
/*  573 */     fetchFlowCollectionStart(true);
/*      */   }
/*      */   
/*      */   private void fetchFlowCollectionStart(boolean isMappingStart) {
/*      */     FlowSequenceStartToken flowSequenceStartToken;
/*  578 */     savePossibleSimpleKey();
/*      */ 
/*      */     
/*  581 */     this.flowLevel++;
/*      */ 
/*      */     
/*  584 */     this.allowSimpleKey = true;
/*      */ 
/*      */     
/*  587 */     Mark startMark = this.reader.getMark();
/*  588 */     this.reader.forward(1);
/*  589 */     Mark endMark = this.reader.getMark();
/*      */     
/*  591 */     if (isMappingStart) {
/*  592 */       FlowMappingStartToken flowMappingStartToken = new FlowMappingStartToken(startMark, endMark);
/*      */     } else {
/*  594 */       flowSequenceStartToken = new FlowSequenceStartToken(startMark, endMark);
/*      */     } 
/*  596 */     this.tokens.add(flowSequenceStartToken);
/*      */   }
/*      */   
/*      */   private void fetchFlowSequenceEnd() {
/*  600 */     fetchFlowCollectionEnd(false);
/*      */   }
/*      */   
/*      */   private void fetchFlowMappingEnd() {
/*  604 */     fetchFlowCollectionEnd(true);
/*      */   }
/*      */   
/*      */   private void fetchFlowCollectionEnd(boolean isMappingEnd) {
/*      */     FlowSequenceEndToken flowSequenceEndToken;
/*  609 */     removePossibleSimpleKey();
/*      */ 
/*      */     
/*  612 */     this.flowLevel--;
/*      */ 
/*      */     
/*  615 */     this.allowSimpleKey = false;
/*      */ 
/*      */     
/*  618 */     Mark startMark = this.reader.getMark();
/*  619 */     this.reader.forward();
/*  620 */     Mark endMark = this.reader.getMark();
/*      */     
/*  622 */     if (isMappingEnd) {
/*  623 */       FlowMappingEndToken flowMappingEndToken = new FlowMappingEndToken(startMark, endMark);
/*      */     } else {
/*  625 */       flowSequenceEndToken = new FlowSequenceEndToken(startMark, endMark);
/*      */     } 
/*  627 */     this.tokens.add(flowSequenceEndToken);
/*      */   }
/*      */ 
/*      */   
/*      */   private void fetchFlowEntry() {
/*  632 */     this.allowSimpleKey = true;
/*      */ 
/*      */     
/*  635 */     removePossibleSimpleKey();
/*      */ 
/*      */     
/*  638 */     Mark startMark = this.reader.getMark();
/*  639 */     this.reader.forward();
/*  640 */     Mark endMark = this.reader.getMark();
/*  641 */     FlowEntryToken flowEntryToken = new FlowEntryToken(startMark, endMark);
/*  642 */     this.tokens.add(flowEntryToken);
/*      */   }
/*      */ 
/*      */   
/*      */   private void fetchBlockEntry() {
/*  647 */     if (this.flowLevel == 0) {
/*      */       
/*  649 */       if (!this.allowSimpleKey) {
/*  650 */         throw new ScannerException(null, null, "sequence entries are not allowed here", this.reader.getMark());
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  655 */       if (addIndent(this.reader.getColumn())) {
/*  656 */         Mark mark = this.reader.getMark();
/*  657 */         this.tokens.add(new BlockSequenceStartToken(mark, mark));
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  664 */     this.allowSimpleKey = true;
/*      */ 
/*      */     
/*  667 */     removePossibleSimpleKey();
/*      */ 
/*      */     
/*  670 */     Mark startMark = this.reader.getMark();
/*  671 */     this.reader.forward();
/*  672 */     Mark endMark = this.reader.getMark();
/*  673 */     BlockEntryToken blockEntryToken = new BlockEntryToken(startMark, endMark);
/*  674 */     this.tokens.add(blockEntryToken);
/*      */   }
/*      */ 
/*      */   
/*      */   private void fetchKey() {
/*  679 */     if (this.flowLevel == 0) {
/*      */       
/*  681 */       if (!this.allowSimpleKey) {
/*  682 */         throw new ScannerException(null, null, "mapping keys are not allowed here", this.reader.getMark());
/*      */       }
/*      */ 
/*      */       
/*  686 */       if (addIndent(this.reader.getColumn())) {
/*  687 */         Mark mark = this.reader.getMark();
/*  688 */         this.tokens.add(new BlockMappingStartToken(mark, mark));
/*      */       } 
/*      */     } 
/*      */     
/*  692 */     this.allowSimpleKey = (this.flowLevel == 0);
/*      */ 
/*      */     
/*  695 */     removePossibleSimpleKey();
/*      */ 
/*      */     
/*  698 */     Mark startMark = this.reader.getMark();
/*  699 */     this.reader.forward();
/*  700 */     Mark endMark = this.reader.getMark();
/*  701 */     KeyToken keyToken = new KeyToken(startMark, endMark);
/*  702 */     this.tokens.add(keyToken);
/*      */   }
/*      */ 
/*      */   
/*      */   private void fetchValue() {
/*  707 */     SimpleKey key = this.possibleSimpleKeys.remove(Integer.valueOf(this.flowLevel));
/*  708 */     if (key != null) {
/*      */       
/*  710 */       this.tokens.add(key.getTokenNumber() - this.tokensTaken, new KeyToken(key.getMark(), key.getMark()));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  715 */       if (this.flowLevel == 0 && 
/*  716 */         addIndent(key.getColumn())) {
/*  717 */         this.tokens.add(key.getTokenNumber() - this.tokensTaken, new BlockMappingStartToken(key.getMark(), key.getMark()));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  722 */       this.allowSimpleKey = false;
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/*  728 */       if (this.flowLevel == 0)
/*      */       {
/*      */ 
/*      */         
/*  732 */         if (!this.allowSimpleKey) {
/*  733 */           throw new ScannerException(null, null, "mapping values are not allowed here", this.reader.getMark());
/*      */         }
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  741 */       if (this.flowLevel == 0 && 
/*  742 */         addIndent(this.reader.getColumn())) {
/*  743 */         Mark mark = this.reader.getMark();
/*  744 */         this.tokens.add(new BlockMappingStartToken(mark, mark));
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  749 */       this.allowSimpleKey = (this.flowLevel == 0);
/*      */ 
/*      */       
/*  752 */       removePossibleSimpleKey();
/*      */     } 
/*      */     
/*  755 */     Mark startMark = this.reader.getMark();
/*  756 */     this.reader.forward();
/*  757 */     Mark endMark = this.reader.getMark();
/*  758 */     ValueToken valueToken = new ValueToken(startMark, endMark);
/*  759 */     this.tokens.add(valueToken);
/*      */   }
/*      */ 
/*      */   
/*      */   private void fetchAlias() {
/*  764 */     savePossibleSimpleKey();
/*      */ 
/*      */     
/*  767 */     this.allowSimpleKey = false;
/*      */ 
/*      */     
/*  770 */     Token tok = scanAnchor(false);
/*  771 */     this.tokens.add(tok);
/*      */   }
/*      */ 
/*      */   
/*      */   private void fetchAnchor() {
/*  776 */     savePossibleSimpleKey();
/*      */ 
/*      */     
/*  779 */     this.allowSimpleKey = false;
/*      */ 
/*      */     
/*  782 */     Token tok = scanAnchor(true);
/*  783 */     this.tokens.add(tok);
/*      */   }
/*      */ 
/*      */   
/*      */   private void fetchTag() {
/*  788 */     savePossibleSimpleKey();
/*      */ 
/*      */     
/*  791 */     this.allowSimpleKey = false;
/*      */ 
/*      */     
/*  794 */     Token tok = scanTag();
/*  795 */     this.tokens.add(tok);
/*      */   }
/*      */   
/*      */   private void fetchLiteral() {
/*  799 */     fetchBlockScalar('|');
/*      */   }
/*      */   
/*      */   private void fetchFolded() {
/*  803 */     fetchBlockScalar('>');
/*      */   }
/*      */ 
/*      */   
/*      */   private void fetchBlockScalar(char style) {
/*  808 */     this.allowSimpleKey = true;
/*      */ 
/*      */     
/*  811 */     removePossibleSimpleKey();
/*      */ 
/*      */     
/*  814 */     Token tok = scanBlockScalar(style);
/*  815 */     this.tokens.add(tok);
/*      */   }
/*      */   
/*      */   private void fetchSingle() {
/*  819 */     fetchFlowScalar('\'');
/*      */   }
/*      */   
/*      */   private void fetchDouble() {
/*  823 */     fetchFlowScalar('"');
/*      */   }
/*      */ 
/*      */   
/*      */   private void fetchFlowScalar(char style) {
/*  828 */     savePossibleSimpleKey();
/*      */ 
/*      */     
/*  831 */     this.allowSimpleKey = false;
/*      */ 
/*      */     
/*  834 */     Token tok = scanFlowScalar(style);
/*  835 */     this.tokens.add(tok);
/*      */   }
/*      */ 
/*      */   
/*      */   private void fetchPlain() {
/*  840 */     savePossibleSimpleKey();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  845 */     this.allowSimpleKey = false;
/*      */ 
/*      */     
/*  848 */     Token tok = scanPlain();
/*  849 */     this.tokens.add(tok);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean checkDirective() {
/*  857 */     return (this.reader.getColumn() == 0);
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean checkDocumentStart() {
/*  862 */     if (this.reader.getColumn() == 0 && 
/*  863 */       "---".equals(this.reader.prefix(3)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3))) {
/*  864 */       return true;
/*      */     }
/*      */     
/*  867 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean checkDocumentEnd() {
/*  872 */     if (this.reader.getColumn() == 0 && 
/*  873 */       "...".equals(this.reader.prefix(3)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3))) {
/*  874 */       return true;
/*      */     }
/*      */     
/*  877 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean checkBlockEntry() {
/*  882 */     return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean checkKey() {
/*  887 */     if (this.flowLevel != 0) {
/*  888 */       return true;
/*      */     }
/*      */     
/*  891 */     return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean checkValue() {
/*  897 */     if (this.flowLevel != 0) {
/*  898 */       return true;
/*      */     }
/*      */     
/*  901 */     return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
/*      */   }
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
/*      */   private boolean checkPlain() {
/*  922 */     char ch = this.reader.peek();
/*  923 */     return (Constant.NULL_BL_T_LINEBR.hasNo(ch, "-?:,[]{}#&*!|>'\"%@`") || (Constant.NULL_BL_T_LINEBR.hasNo(this.reader.peek(1)) && (ch == '-' || (this.flowLevel == 0 && "?:".indexOf(ch) != -1))));
/*      */   }
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
/*      */   private void scanToNextToken() {
/*  952 */     if (this.reader.getIndex() == 0 && this.reader.peek() == '﻿') {
/*  953 */       this.reader.forward();
/*      */     }
/*  955 */     boolean found = false;
/*  956 */     while (!found) {
/*  957 */       int ff = 0;
/*  958 */       while (this.reader.peek(ff) == ' ') {
/*  959 */         ff++;
/*      */       }
/*  961 */       if (ff > 0) {
/*  962 */         this.reader.forward(ff);
/*      */       }
/*      */       
/*  965 */       if (this.reader.peek() == '#') {
/*  966 */         ff = 0;
/*  967 */         while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(ff))) {
/*  968 */           ff++;
/*      */         }
/*  970 */         if (ff > 0) {
/*  971 */           this.reader.forward(ff);
/*      */         }
/*      */       } 
/*  974 */       if (scanLineBreak().length() != 0) {
/*  975 */         if (this.flowLevel == 0)
/*  976 */           this.allowSimpleKey = true; 
/*      */         continue;
/*      */       } 
/*  979 */       found = true;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Token scanDirective() {
/*  987 */     Mark endMark, startMark = this.reader.getMark();
/*      */     
/*  989 */     this.reader.forward();
/*  990 */     String name = scanDirectiveName(startMark);
/*  991 */     List<?> value = null;
/*  992 */     if ("YAML".equals(name)) {
/*  993 */       value = scanYamlDirectiveValue(startMark);
/*  994 */       endMark = this.reader.getMark();
/*  995 */     } else if ("TAG".equals(name)) {
/*  996 */       value = scanTagDirectiveValue(startMark);
/*  997 */       endMark = this.reader.getMark();
/*      */     } else {
/*  999 */       endMark = this.reader.getMark();
/* 1000 */       int ff = 0;
/* 1001 */       while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(ff))) {
/* 1002 */         ff++;
/*      */       }
/* 1004 */       if (ff > 0) {
/* 1005 */         this.reader.forward(ff);
/*      */       }
/*      */     } 
/* 1008 */     scanDirectiveIgnoredLine(startMark);
/* 1009 */     return (Token)new DirectiveToken(name, value, startMark, endMark);
/*      */   }
/*      */ 
/*      */   
/*      */   private String scanDirectiveName(Mark startMark) {
/* 1014 */     int length = 0;
/* 1015 */     char ch = this.reader.peek(length);
/* 1016 */     while (Constant.ALPHA.has(ch)) {
/* 1017 */       length++;
/* 1018 */       ch = this.reader.peek(length);
/*      */     } 
/* 1020 */     if (length == 0) {
/* 1021 */       throw new ScannerException("while scanning a directive", startMark, "expected alphabetic or numeric character, but found " + ch + "(" + ch + ")", this.reader.getMark());
/*      */     }
/*      */ 
/*      */     
/* 1025 */     String value = this.reader.prefixForward(length);
/* 1026 */     ch = this.reader.peek();
/* 1027 */     if (Constant.NULL_BL_LINEBR.hasNo(ch)) {
/* 1028 */       throw new ScannerException("while scanning a directive", startMark, "expected alphabetic or numeric character, but found " + ch + "(" + ch + ")", this.reader.getMark());
/*      */     }
/*      */ 
/*      */     
/* 1032 */     return value;
/*      */   }
/*      */ 
/*      */   
/*      */   private List<Integer> scanYamlDirectiveValue(Mark startMark) {
/* 1037 */     while (this.reader.peek() == ' ') {
/* 1038 */       this.reader.forward();
/*      */     }
/* 1040 */     Integer major = scanYamlDirectiveNumber(startMark);
/* 1041 */     if (this.reader.peek() != '.') {
/* 1042 */       throw new ScannerException("while scanning a directive", startMark, "expected a digit or '.', but found " + this.reader.peek() + "(" + this.reader.peek() + ")", this.reader.getMark());
/*      */     }
/*      */ 
/*      */     
/* 1046 */     this.reader.forward();
/* 1047 */     Integer minor = scanYamlDirectiveNumber(startMark);
/* 1048 */     if (Constant.NULL_BL_LINEBR.hasNo(this.reader.peek())) {
/* 1049 */       throw new ScannerException("while scanning a directive", startMark, "expected a digit or ' ', but found " + this.reader.peek() + "(" + this.reader.peek() + ")", this.reader.getMark());
/*      */     }
/*      */ 
/*      */     
/* 1053 */     List<Integer> result = new ArrayList<Integer>(2);
/* 1054 */     result.add(major);
/* 1055 */     result.add(minor);
/* 1056 */     return result;
/*      */   }
/*      */ 
/*      */   
/*      */   private Integer scanYamlDirectiveNumber(Mark startMark) {
/* 1061 */     char ch = this.reader.peek();
/* 1062 */     if (!Character.isDigit(ch)) {
/* 1063 */       throw new ScannerException("while scanning a directive", startMark, "expected a digit, but found " + ch + "(" + ch + ")", this.reader.getMark());
/*      */     }
/*      */     
/* 1066 */     int length = 0;
/* 1067 */     while (Character.isDigit(this.reader.peek(length))) {
/* 1068 */       length++;
/*      */     }
/* 1070 */     Integer value = new Integer(this.reader.prefixForward(length));
/* 1071 */     return value;
/*      */   }
/*      */ 
/*      */   
/*      */   private List<String> scanTagDirectiveValue(Mark startMark) {
/* 1076 */     while (this.reader.peek() == ' ') {
/* 1077 */       this.reader.forward();
/*      */     }
/* 1079 */     String handle = scanTagDirectiveHandle(startMark);
/* 1080 */     while (this.reader.peek() == ' ') {
/* 1081 */       this.reader.forward();
/*      */     }
/* 1083 */     String prefix = scanTagDirectivePrefix(startMark);
/* 1084 */     List<String> result = new ArrayList<String>(2);
/* 1085 */     result.add(handle);
/* 1086 */     result.add(prefix);
/* 1087 */     return result;
/*      */   }
/*      */ 
/*      */   
/*      */   private String scanTagDirectiveHandle(Mark startMark) {
/* 1092 */     String value = scanTagHandle("directive", startMark);
/* 1093 */     char ch = this.reader.peek();
/* 1094 */     if (ch != ' ') {
/* 1095 */       throw new ScannerException("while scanning a directive", startMark, "expected ' ', but found " + this.reader.peek() + "(" + ch + ")", this.reader.getMark());
/*      */     }
/*      */     
/* 1098 */     return value;
/*      */   }
/*      */ 
/*      */   
/*      */   private String scanTagDirectivePrefix(Mark startMark) {
/* 1103 */     String value = scanTagUri("directive", startMark);
/* 1104 */     if (Constant.NULL_BL_LINEBR.hasNo(this.reader.peek())) {
/* 1105 */       throw new ScannerException("while scanning a directive", startMark, "expected ' ', but found " + this.reader.peek() + "(" + this.reader.peek() + ")", this.reader.getMark());
/*      */     }
/*      */ 
/*      */     
/* 1109 */     return value;
/*      */   }
/*      */ 
/*      */   
/*      */   private String scanDirectiveIgnoredLine(Mark startMark) {
/* 1114 */     int ff = 0;
/* 1115 */     while (this.reader.peek(ff) == ' ') {
/* 1116 */       ff++;
/*      */     }
/* 1118 */     if (ff > 0) {
/* 1119 */       this.reader.forward(ff);
/*      */     }
/* 1121 */     if (this.reader.peek() == '#') {
/* 1122 */       ff = 0;
/* 1123 */       while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(ff))) {
/* 1124 */         ff++;
/*      */       }
/* 1126 */       this.reader.forward(ff);
/*      */     } 
/* 1128 */     char ch = this.reader.peek();
/* 1129 */     String lineBreak = scanLineBreak();
/* 1130 */     if (lineBreak.length() == 0 && ch != '\000') {
/* 1131 */       throw new ScannerException("while scanning a directive", startMark, "expected a comment or a line break, but found " + ch + "(" + ch + ")", this.reader.getMark());
/*      */     }
/*      */ 
/*      */     
/* 1135 */     return lineBreak;
/*      */   }
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
/*      */   private Token scanAnchor(boolean isAnchor) {
/*      */     AliasToken aliasToken;
/* 1151 */     Mark startMark = this.reader.getMark();
/* 1152 */     char indicator = this.reader.peek();
/* 1153 */     String name = (indicator == '*') ? "alias" : "anchor";
/* 1154 */     this.reader.forward();
/* 1155 */     int length = 0;
/* 1156 */     char ch = this.reader.peek(length);
/* 1157 */     while (Constant.ALPHA.has(ch)) {
/* 1158 */       length++;
/* 1159 */       ch = this.reader.peek(length);
/*      */     } 
/* 1161 */     if (length == 0) {
/* 1162 */       throw new ScannerException("while scanning an " + name, startMark, "expected alphabetic or numeric character, but found but found " + ch, this.reader.getMark());
/*      */     }
/*      */ 
/*      */     
/* 1166 */     String value = this.reader.prefixForward(length);
/* 1167 */     ch = this.reader.peek();
/* 1168 */     if (Constant.NULL_BL_T_LINEBR.hasNo(ch, "?:,]}%@`")) {
/* 1169 */       throw new ScannerException("while scanning an " + name, startMark, "expected alphabetic or numeric character, but found " + ch + "(" + this.reader.peek() + ")", this.reader.getMark());
/*      */     }
/*      */ 
/*      */     
/* 1173 */     Mark endMark = this.reader.getMark();
/*      */     
/* 1175 */     if (isAnchor) {
/* 1176 */       AnchorToken anchorToken = new AnchorToken(value, startMark, endMark);
/*      */     } else {
/* 1178 */       aliasToken = new AliasToken(value, startMark, endMark);
/*      */     } 
/* 1180 */     return (Token)aliasToken;
/*      */   }
/*      */ 
/*      */   
/*      */   private Token scanTag() {
/* 1185 */     Mark startMark = this.reader.getMark();
/* 1186 */     char ch = this.reader.peek(1);
/* 1187 */     String handle = null;
/* 1188 */     String suffix = null;
/* 1189 */     if (ch == '<') {
/* 1190 */       this.reader.forward(2);
/* 1191 */       suffix = scanTagUri("tag", startMark);
/* 1192 */       if (this.reader.peek() != '>') {
/* 1193 */         throw new ScannerException("while scanning a tag", startMark, "expected '>', but found '" + this.reader.peek() + "' (" + this.reader.peek() + ")", this.reader.getMark());
/*      */       }
/*      */ 
/*      */       
/* 1197 */       this.reader.forward();
/* 1198 */     } else if (Constant.NULL_BL_T_LINEBR.has(ch)) {
/* 1199 */       suffix = "!";
/* 1200 */       this.reader.forward();
/*      */     } else {
/* 1202 */       int length = 1;
/* 1203 */       boolean useHandle = false;
/* 1204 */       while (Constant.NULL_BL_LINEBR.hasNo(ch)) {
/* 1205 */         if (ch == '!') {
/* 1206 */           useHandle = true;
/*      */           break;
/*      */         } 
/* 1209 */         length++;
/* 1210 */         ch = this.reader.peek(length);
/*      */       } 
/* 1212 */       handle = "!";
/* 1213 */       if (useHandle) {
/* 1214 */         handle = scanTagHandle("tag", startMark);
/*      */       } else {
/* 1216 */         handle = "!";
/* 1217 */         this.reader.forward();
/*      */       } 
/* 1219 */       suffix = scanTagUri("tag", startMark);
/*      */     } 
/* 1221 */     ch = this.reader.peek();
/* 1222 */     if (Constant.NULL_BL_LINEBR.hasNo(ch)) {
/* 1223 */       throw new ScannerException("while scanning a tag", startMark, "expected ' ', but found '" + ch + "' (" + ch + ")", this.reader.getMark());
/*      */     }
/*      */     
/* 1226 */     TagTuple value = new TagTuple(handle, suffix);
/* 1227 */     Mark endMark = this.reader.getMark();
/* 1228 */     return (Token)new TagToken(value, startMark, endMark);
/*      */   }
/*      */   
/*      */   private Token scanBlockScalar(char style) {
/*      */     boolean folded;
/*      */     Mark mark1;
/* 1234 */     if (style == '>') {
/* 1235 */       folded = true;
/*      */     } else {
/* 1237 */       folded = false;
/*      */     } 
/* 1239 */     StringBuilder chunks = new StringBuilder();
/* 1240 */     Mark startMark = this.reader.getMark();
/*      */     
/* 1242 */     this.reader.forward();
/* 1243 */     Chomping chompi = scanBlockScalarIndicators(startMark);
/* 1244 */     int increment = chompi.getIncrement();
/* 1245 */     scanBlockScalarIgnoredLine(startMark);
/*      */ 
/*      */     
/* 1248 */     int minIndent = this.indent + 1;
/* 1249 */     if (minIndent < 1) {
/* 1250 */       minIndent = 1;
/*      */     }
/* 1252 */     String breaks = null;
/* 1253 */     int maxIndent = 0;
/* 1254 */     int indent = 0;
/*      */     
/* 1256 */     if (increment == -1) {
/* 1257 */       Object[] brme = scanBlockScalarIndentation();
/* 1258 */       breaks = (String)brme[0];
/* 1259 */       maxIndent = ((Integer)brme[1]).intValue();
/* 1260 */       mark1 = (Mark)brme[2];
/* 1261 */       indent = Math.max(minIndent, maxIndent);
/*      */     } else {
/* 1263 */       indent = minIndent + increment - 1;
/* 1264 */       Object[] brme = scanBlockScalarBreaks(indent);
/* 1265 */       breaks = (String)brme[0];
/* 1266 */       mark1 = (Mark)brme[1];
/*      */     } 
/*      */     
/* 1269 */     String lineBreak = "";
/*      */ 
/*      */     
/* 1272 */     while (this.reader.getColumn() == indent && this.reader.peek() != '\000') {
/* 1273 */       chunks.append(breaks);
/* 1274 */       boolean leadingNonSpace = (" \t".indexOf(this.reader.peek()) == -1);
/* 1275 */       int length = 0;
/* 1276 */       while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(length))) {
/* 1277 */         length++;
/*      */       }
/* 1279 */       chunks.append(this.reader.prefixForward(length));
/* 1280 */       lineBreak = scanLineBreak();
/* 1281 */       Object[] brme = scanBlockScalarBreaks(indent);
/* 1282 */       breaks = (String)brme[0];
/* 1283 */       mark1 = (Mark)brme[1];
/* 1284 */       if (this.reader.getColumn() == indent && this.reader.peek() != '\000') {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1289 */         if (folded && "\n".equals(lineBreak) && leadingNonSpace && " \t".indexOf(this.reader.peek()) == -1) {
/*      */           
/* 1291 */           if (breaks.length() == 0)
/* 1292 */             chunks.append(" "); 
/*      */           continue;
/*      */         } 
/* 1295 */         chunks.append(lineBreak);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1304 */     if (chompi.chompTailIsNotFalse()) {
/* 1305 */       chunks.append(lineBreak);
/*      */     }
/* 1307 */     if (chompi.chompTailIsTrue()) {
/* 1308 */       chunks.append(breaks);
/*      */     }
/*      */     
/* 1311 */     return (Token)new ScalarToken(chunks.toString(), false, startMark, mark1, style);
/*      */   }
/*      */ 
/*      */   
/*      */   private Chomping scanBlockScalarIndicators(Mark startMark) {
/* 1316 */     Boolean chomping = null;
/* 1317 */     int increment = -1;
/* 1318 */     char ch = this.reader.peek();
/* 1319 */     if (ch == '-' || ch == '+') {
/* 1320 */       if (ch == '+') {
/* 1321 */         chomping = Boolean.TRUE;
/*      */       } else {
/* 1323 */         chomping = Boolean.FALSE;
/*      */       } 
/* 1325 */       this.reader.forward();
/* 1326 */       ch = this.reader.peek();
/* 1327 */       if (Character.isDigit(ch)) {
/* 1328 */         increment = Integer.parseInt(String.valueOf(ch));
/* 1329 */         if (increment == 0) {
/* 1330 */           throw new ScannerException("while scanning a block scalar", startMark, "expected indentation indicator in the range 1-9, but found 0", this.reader.getMark());
/*      */         }
/*      */ 
/*      */         
/* 1334 */         this.reader.forward();
/*      */       } 
/* 1336 */     } else if (Character.isDigit(ch)) {
/* 1337 */       increment = Integer.parseInt(String.valueOf(ch));
/* 1338 */       if (increment == 0) {
/* 1339 */         throw new ScannerException("while scanning a block scalar", startMark, "expected indentation indicator in the range 1-9, but found 0", this.reader.getMark());
/*      */       }
/*      */ 
/*      */       
/* 1343 */       this.reader.forward();
/* 1344 */       ch = this.reader.peek();
/* 1345 */       if (ch == '-' || ch == '+') {
/* 1346 */         if (ch == '+') {
/* 1347 */           chomping = Boolean.TRUE;
/*      */         } else {
/* 1349 */           chomping = Boolean.FALSE;
/*      */         } 
/* 1351 */         this.reader.forward();
/*      */       } 
/*      */     } 
/* 1354 */     ch = this.reader.peek();
/* 1355 */     if (Constant.NULL_BL_LINEBR.hasNo(ch)) {
/* 1356 */       throw new ScannerException("while scanning a block scalar", startMark, "expected chomping or indentation indicators, but found " + ch, this.reader.getMark());
/*      */     }
/*      */ 
/*      */     
/* 1360 */     return new Chomping(chomping, increment);
/*      */   }
/*      */ 
/*      */   
/*      */   private String scanBlockScalarIgnoredLine(Mark startMark) {
/* 1365 */     int ff = 0;
/* 1366 */     while (this.reader.peek(ff) == ' ') {
/* 1367 */       ff++;
/*      */     }
/* 1369 */     if (ff > 0) {
/* 1370 */       this.reader.forward(ff);
/*      */     }
/*      */     
/* 1373 */     if (this.reader.peek() == '#') {
/* 1374 */       ff = 0;
/* 1375 */       while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(ff))) {
/* 1376 */         ff++;
/*      */       }
/* 1378 */       if (ff > 0) {
/* 1379 */         this.reader.forward(ff);
/*      */       }
/*      */     } 
/* 1382 */     char ch = this.reader.peek();
/* 1383 */     String lineBreak = scanLineBreak();
/* 1384 */     if (lineBreak.length() == 0 && ch != '\000') {
/* 1385 */       throw new ScannerException("while scanning a block scalar", startMark, "expected a comment or a line break, but found " + ch, this.reader.getMark());
/*      */     }
/*      */     
/* 1388 */     return lineBreak;
/*      */   }
/*      */ 
/*      */   
/*      */   private Object[] scanBlockScalarIndentation() {
/* 1393 */     StringBuilder chunks = new StringBuilder();
/* 1394 */     int maxIndent = 0;
/* 1395 */     Mark endMark = this.reader.getMark();
/* 1396 */     while (Constant.LINEBR.has(this.reader.peek(), " \r")) {
/* 1397 */       if (this.reader.peek() != ' ') {
/* 1398 */         chunks.append(scanLineBreak());
/* 1399 */         endMark = this.reader.getMark(); continue;
/*      */       } 
/* 1401 */       this.reader.forward();
/* 1402 */       if (this.reader.getColumn() > maxIndent) {
/* 1403 */         maxIndent = this.reader.getColumn();
/*      */       }
/*      */     } 
/*      */     
/* 1407 */     return new Object[] { chunks.toString(), Integer.valueOf(maxIndent), endMark };
/*      */   }
/*      */ 
/*      */   
/*      */   private Object[] scanBlockScalarBreaks(int indent) {
/* 1412 */     StringBuilder chunks = new StringBuilder();
/* 1413 */     Mark endMark = this.reader.getMark();
/* 1414 */     int ff = 0;
/* 1415 */     int col = this.reader.getColumn();
/* 1416 */     while (col < indent && this.reader.peek(ff) == ' ') {
/* 1417 */       ff++;
/* 1418 */       col++;
/*      */     } 
/* 1420 */     if (ff > 0) {
/* 1421 */       this.reader.forward(ff);
/*      */     }
/*      */     
/* 1424 */     String lineBreak = null;
/* 1425 */     while ((lineBreak = scanLineBreak()).length() != 0) {
/* 1426 */       chunks.append(lineBreak);
/* 1427 */       endMark = this.reader.getMark();
/* 1428 */       ff = 0;
/* 1429 */       col = this.reader.getColumn();
/* 1430 */       while (col < indent && this.reader.peek(ff) == ' ') {
/* 1431 */         ff++;
/* 1432 */         col++;
/*      */       } 
/* 1434 */       if (ff > 0) {
/* 1435 */         this.reader.forward(ff);
/*      */       }
/*      */     } 
/* 1438 */     return new Object[] { chunks.toString(), endMark };
/*      */   }
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
/*      */   private Token scanFlowScalar(char style) {
/*      */     boolean _double;
/* 1453 */     if (style == '"') {
/* 1454 */       _double = true;
/*      */     } else {
/* 1456 */       _double = false;
/*      */     } 
/* 1458 */     StringBuilder chunks = new StringBuilder();
/* 1459 */     Mark startMark = this.reader.getMark();
/* 1460 */     char quote = this.reader.peek();
/* 1461 */     this.reader.forward();
/* 1462 */     chunks.append(scanFlowScalarNonSpaces(_double, startMark));
/* 1463 */     while (this.reader.peek() != quote) {
/* 1464 */       chunks.append(scanFlowScalarSpaces(startMark));
/* 1465 */       chunks.append(scanFlowScalarNonSpaces(_double, startMark));
/*      */     } 
/* 1467 */     this.reader.forward();
/* 1468 */     Mark endMark = this.reader.getMark();
/* 1469 */     return (Token)new ScalarToken(chunks.toString(), false, startMark, endMark, style);
/*      */   }
/*      */ 
/*      */   
/*      */   private String scanFlowScalarNonSpaces(boolean _double, Mark startMark) {
/* 1474 */     StringBuilder chunks = new StringBuilder();
/*      */     while (true) {
/* 1476 */       int length = 0;
/* 1477 */       while (Constant.NULL_BL_T_LINEBR.hasNo(this.reader.peek(length), "'\"\\")) {
/* 1478 */         length++;
/*      */       }
/* 1480 */       if (length != 0) {
/* 1481 */         chunks.append(this.reader.prefixForward(length));
/*      */       }
/* 1483 */       char ch = this.reader.peek();
/* 1484 */       if (!_double && ch == '\'' && this.reader.peek(1) == '\'') {
/* 1485 */         chunks.append("'");
/* 1486 */         this.reader.forward(2); continue;
/* 1487 */       }  if ((_double && ch == '\'') || (!_double && "\"\\".indexOf(ch) != -1)) {
/* 1488 */         chunks.append(ch);
/* 1489 */         this.reader.forward(); continue;
/* 1490 */       }  if (_double && ch == '\\') {
/* 1491 */         this.reader.forward();
/* 1492 */         ch = this.reader.peek();
/* 1493 */         if (ESCAPE_REPLACEMENTS.containsKey(new Character(ch))) {
/* 1494 */           chunks.append(ESCAPE_REPLACEMENTS.get(new Character(ch)));
/* 1495 */           this.reader.forward(); continue;
/* 1496 */         }  if (ESCAPE_CODES.containsKey(new Character(ch))) {
/* 1497 */           length = ((Integer)ESCAPE_CODES.get(new Character(ch))).intValue();
/* 1498 */           this.reader.forward();
/* 1499 */           String hex = this.reader.prefix(length);
/* 1500 */           if (NOT_HEXA.matcher(hex).find()) {
/* 1501 */             throw new ScannerException("while scanning a double-quoted scalar", startMark, "expected escape sequence of " + length + " hexadecimal numbers, but found: " + hex, this.reader.getMark());
/*      */           }
/*      */ 
/*      */ 
/*      */           
/* 1506 */           char unicode = (char)Integer.parseInt(hex, 16);
/* 1507 */           chunks.append(unicode);
/* 1508 */           this.reader.forward(length); continue;
/* 1509 */         }  if (scanLineBreak().length() != 0) {
/* 1510 */           chunks.append(scanFlowScalarBreaks(startMark)); continue;
/*      */         } 
/* 1512 */         throw new ScannerException("while scanning a double-quoted scalar", startMark, "found unknown escape character " + ch + "(" + ch + ")", this.reader.getMark());
/*      */       } 
/*      */       
/*      */       break;
/*      */     } 
/* 1517 */     return chunks.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String scanFlowScalarSpaces(Mark startMark) {
/* 1524 */     StringBuilder chunks = new StringBuilder();
/* 1525 */     int length = 0;
/* 1526 */     while (" \t".indexOf(this.reader.peek(length)) != -1) {
/* 1527 */       length++;
/*      */     }
/* 1529 */     String whitespaces = this.reader.prefixForward(length);
/* 1530 */     char ch = this.reader.peek();
/* 1531 */     if (ch == '\000') {
/* 1532 */       throw new ScannerException("while scanning a quoted scalar", startMark, "found unexpected end of stream", this.reader.getMark());
/*      */     }
/*      */     
/* 1535 */     String lineBreak = scanLineBreak();
/* 1536 */     if (lineBreak.length() != 0) {
/* 1537 */       String breaks = scanFlowScalarBreaks(startMark);
/* 1538 */       if (!"\n".equals(lineBreak)) {
/* 1539 */         chunks.append(lineBreak);
/* 1540 */       } else if (breaks.length() == 0) {
/* 1541 */         chunks.append(" ");
/*      */       } 
/* 1543 */       chunks.append(breaks);
/*      */     } else {
/* 1545 */       chunks.append(whitespaces);
/*      */     } 
/* 1547 */     return chunks.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   private String scanFlowScalarBreaks(Mark startMark) {
/* 1552 */     StringBuilder chunks = new StringBuilder();
/*      */ 
/*      */     
/*      */     while (true) {
/* 1556 */       String prefix = this.reader.prefix(3);
/* 1557 */       if (("---".equals(prefix) || "...".equals(prefix)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3)))
/*      */       {
/* 1559 */         throw new ScannerException("while scanning a quoted scalar", startMark, "found unexpected document separator", this.reader.getMark());
/*      */       }
/*      */       
/* 1562 */       while (" \t".indexOf(this.reader.peek()) != -1) {
/* 1563 */         this.reader.forward();
/*      */       }
/* 1565 */       String lineBreak = scanLineBreak();
/* 1566 */       if (lineBreak.length() != 0) {
/* 1567 */         chunks.append(lineBreak); continue;
/*      */       }  break;
/* 1569 */     }  return chunks.toString();
/*      */   }
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
/*      */   private Token scanPlain() {
/* 1584 */     StringBuilder chunks = new StringBuilder();
/* 1585 */     Mark startMark = this.reader.getMark();
/* 1586 */     Mark endMark = startMark;
/* 1587 */     int indent = this.indent + 1;
/* 1588 */     String spaces = "";
/*      */     do {
/*      */       char ch;
/* 1591 */       int length = 0;
/* 1592 */       if (this.reader.peek() == '#') {
/*      */         break;
/*      */       }
/*      */       while (true) {
/* 1596 */         ch = this.reader.peek(length);
/* 1597 */         if (Constant.NULL_BL_T_LINEBR.has(ch) || (this.flowLevel == 0 && ch == ':' && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(length + 1))) || (this.flowLevel != 0 && ",:?[]{}".indexOf(ch) != -1)) {
/*      */           break;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/* 1603 */         length++;
/*      */       } 
/*      */       
/* 1606 */       if (this.flowLevel != 0 && ch == ':' && Constant.NULL_BL_T_LINEBR.hasNo(this.reader.peek(length + 1), ",[]{}")) {
/*      */         
/* 1608 */         this.reader.forward(length);
/* 1609 */         throw new ScannerException("while scanning a plain scalar", startMark, "found unexpected ':'", this.reader.getMark(), "Please check http://pyyaml.org/wiki/YAMLColonInFlowContext for details.");
/*      */       } 
/*      */ 
/*      */       
/* 1613 */       if (length == 0) {
/*      */         break;
/*      */       }
/* 1616 */       this.allowSimpleKey = false;
/* 1617 */       chunks.append(spaces);
/* 1618 */       chunks.append(this.reader.prefixForward(length));
/* 1619 */       endMark = this.reader.getMark();
/* 1620 */       spaces = scanPlainSpaces();
/*      */     }
/* 1622 */     while (spaces.length() != 0 && this.reader.peek() != '#' && (this.flowLevel != 0 || this.reader.getColumn() >= indent));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1627 */     return (Token)new ScalarToken(chunks.toString(), startMark, endMark, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String scanPlainSpaces() {
/* 1638 */     int length = 0;
/* 1639 */     while (this.reader.peek(length) == ' ') {
/* 1640 */       length++;
/*      */     }
/* 1642 */     String whitespaces = this.reader.prefixForward(length);
/* 1643 */     String lineBreak = scanLineBreak();
/* 1644 */     if (lineBreak.length() != 0) {
/* 1645 */       this.allowSimpleKey = true;
/* 1646 */       String prefix = this.reader.prefix(3);
/* 1647 */       if ("---".equals(prefix) || ("...".equals(prefix) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3))))
/*      */       {
/* 1649 */         return "";
/*      */       }
/* 1651 */       StringBuilder breaks = new StringBuilder();
/*      */       while (true) {
/* 1653 */         while (this.reader.peek() == ' ') {
/* 1654 */           this.reader.forward();
/*      */         }
/* 1656 */         String lb = scanLineBreak();
/* 1657 */         if (lb.length() != 0) {
/* 1658 */           breaks.append(lb);
/* 1659 */           prefix = this.reader.prefix(3);
/* 1660 */           if ("---".equals(prefix) || ("...".equals(prefix) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3))))
/*      */           {
/* 1662 */             return "";
/*      */           }
/*      */           
/*      */           continue;
/*      */         } 
/*      */         break;
/*      */       } 
/* 1669 */       if (!"\n".equals(lineBreak))
/* 1670 */         return lineBreak + breaks; 
/* 1671 */       if (breaks.length() == 0) {
/* 1672 */         return " ";
/*      */       }
/* 1674 */       return breaks.toString();
/*      */     } 
/* 1676 */     return whitespaces;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String scanTagHandle(String name, Mark startMark) {
/* 1687 */     char ch = this.reader.peek();
/* 1688 */     if (ch != '!') {
/* 1689 */       throw new ScannerException("while scanning a " + name, startMark, "expected '!', but found " + ch + "(" + ch + ")", this.reader.getMark());
/*      */     }
/*      */     
/* 1692 */     int length = 1;
/* 1693 */     ch = this.reader.peek(length);
/* 1694 */     if (ch != ' ') {
/* 1695 */       while (Constant.ALPHA.has(ch)) {
/* 1696 */         length++;
/* 1697 */         ch = this.reader.peek(length);
/*      */       } 
/* 1699 */       if (ch != '!') {
/* 1700 */         this.reader.forward(length);
/* 1701 */         throw new ScannerException("while scanning a " + name, startMark, "expected '!', but found " + ch + "(" + ch + ")", this.reader.getMark());
/*      */       } 
/*      */       
/* 1704 */       length++;
/*      */     } 
/* 1706 */     String value = this.reader.prefixForward(length);
/* 1707 */     return value;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private String scanTagUri(String name, Mark startMark) {
/* 1713 */     StringBuilder chunks = new StringBuilder();
/* 1714 */     int length = 0;
/* 1715 */     char ch = this.reader.peek(length);
/* 1716 */     while (Constant.URI_CHARS.has(ch)) {
/* 1717 */       if (ch == '%') {
/* 1718 */         chunks.append(this.reader.prefixForward(length));
/* 1719 */         length = 0;
/* 1720 */         chunks.append(scanUriEscapes(name, startMark));
/*      */       } else {
/* 1722 */         length++;
/*      */       } 
/* 1724 */       ch = this.reader.peek(length);
/*      */     } 
/* 1726 */     if (length != 0) {
/* 1727 */       chunks.append(this.reader.prefixForward(length));
/* 1728 */       length = 0;
/*      */     } 
/* 1730 */     if (chunks.length() == 0) {
/* 1731 */       throw new ScannerException("while scanning a " + name, startMark, "expected URI, but found " + ch + "(" + ch + ")", this.reader.getMark());
/*      */     }
/*      */     
/* 1734 */     return chunks.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private String scanUriEscapes(String name, Mark startMark) {
/* 1740 */     int length = 1;
/* 1741 */     while (this.reader.peek(length * 3) == '%') {
/* 1742 */       length++;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1748 */     Mark beginningMark = this.reader.getMark();
/* 1749 */     ByteBuffer buff = ByteBuffer.allocate(length);
/* 1750 */     while (this.reader.peek() == '%') {
/* 1751 */       this.reader.forward();
/*      */       try {
/* 1753 */         byte code = (byte)Integer.parseInt(this.reader.prefix(2), 16);
/* 1754 */         buff.put(code);
/* 1755 */       } catch (NumberFormatException nfe) {
/* 1756 */         throw new ScannerException("while scanning a " + name, startMark, "expected URI escape sequence of 2 hexadecimal numbers, but found " + this.reader.peek() + "(" + this.reader.peek() + ") and " + this.reader.peek(1) + "(" + this.reader.peek(1) + ")", this.reader.getMark());
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1762 */       this.reader.forward(2);
/*      */     } 
/* 1764 */     buff.flip();
/*      */     try {
/* 1766 */       return UriEncoder.decode(buff);
/* 1767 */     } catch (CharacterCodingException e) {
/* 1768 */       throw new ScannerException("while scanning a " + name, startMark, "expected URI in UTF-8: " + e.getMessage(), beginningMark);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String scanLineBreak() {
/* 1780 */     char ch = this.reader.peek();
/* 1781 */     if (ch == '\r' || ch == '\n' || ch == '') {
/* 1782 */       if (ch == '\r' && '\n' == this.reader.peek(1)) {
/* 1783 */         this.reader.forward(2);
/*      */       } else {
/* 1785 */         this.reader.forward();
/*      */       } 
/* 1787 */       return "\n";
/* 1788 */     }  if (ch == ' ' || ch == ' ') {
/* 1789 */       this.reader.forward();
/* 1790 */       return String.valueOf(ch);
/*      */     } 
/* 1792 */     return "";
/*      */   }
/*      */ 
/*      */   
/*      */   private class Chomping
/*      */   {
/*      */     private final Boolean value;
/*      */     
/*      */     private final int increment;
/*      */     
/*      */     public Chomping(Boolean value, int increment) {
/* 1803 */       this.value = value;
/* 1804 */       this.increment = increment;
/*      */     }
/*      */     
/*      */     public boolean chompTailIsNotFalse() {
/* 1808 */       return (this.value == null || this.value.booleanValue());
/*      */     }
/*      */     
/*      */     public boolean chompTailIsTrue() {
/* 1812 */       return (this.value != null && this.value.booleanValue());
/*      */     }
/*      */     
/*      */     public int getIncrement() {
/* 1816 */       return this.increment;
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\scanner\ScannerImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */