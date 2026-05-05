/*      */ package org.apache.commons.lang.text;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import java.util.ListIterator;
/*      */ import java.util.NoSuchElementException;
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
/*      */ public class StrTokenizer
/*      */   implements ListIterator, Cloneable
/*      */ {
/*   93 */   private static final StrTokenizer CSV_TOKENIZER_PROTOTYPE = new StrTokenizer(); static {
/*   94 */     CSV_TOKENIZER_PROTOTYPE.setDelimiterMatcher(StrMatcher.commaMatcher());
/*   95 */     CSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
/*   96 */     CSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StrMatcher.noneMatcher());
/*   97 */     CSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StrMatcher.trimMatcher());
/*   98 */     CSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
/*   99 */     CSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
/*      */   }
/*  101 */   private static final StrTokenizer TSV_TOKENIZER_PROTOTYPE = new StrTokenizer(); static {
/*  102 */     TSV_TOKENIZER_PROTOTYPE.setDelimiterMatcher(StrMatcher.tabMatcher());
/*  103 */     TSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
/*  104 */     TSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StrMatcher.noneMatcher());
/*  105 */     TSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StrMatcher.trimMatcher());
/*  106 */     TSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
/*  107 */     TSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private char[] chars;
/*      */   
/*      */   private String[] tokens;
/*      */   
/*      */   private int tokenPos;
/*      */   
/*  118 */   private StrMatcher delimMatcher = StrMatcher.splitMatcher();
/*      */   
/*  120 */   private StrMatcher quoteMatcher = StrMatcher.noneMatcher();
/*      */   
/*  122 */   private StrMatcher ignoredMatcher = StrMatcher.noneMatcher();
/*      */   
/*  124 */   private StrMatcher trimmerMatcher = StrMatcher.noneMatcher();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean emptyAsNull = false;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean ignoreEmptyTokens = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static StrTokenizer getCSVClone() {
/*  139 */     return (StrTokenizer)CSV_TOKENIZER_PROTOTYPE.clone();
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
/*      */   public static StrTokenizer getCSVInstance() {
/*  152 */     return getCSVClone();
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
/*      */   public static StrTokenizer getCSVInstance(String input) {
/*  165 */     StrTokenizer tok = getCSVClone();
/*  166 */     tok.reset(input);
/*  167 */     return tok;
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
/*      */   public static StrTokenizer getCSVInstance(char[] input) {
/*  180 */     StrTokenizer tok = getCSVClone();
/*  181 */     tok.reset(input);
/*  182 */     return tok;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static StrTokenizer getTSVClone() {
/*  191 */     return (StrTokenizer)TSV_TOKENIZER_PROTOTYPE.clone();
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
/*      */   public static StrTokenizer getTSVInstance() {
/*  204 */     return getTSVClone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StrTokenizer getTSVInstance(String input) {
/*  215 */     StrTokenizer tok = getTSVClone();
/*  216 */     tok.reset(input);
/*  217 */     return tok;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StrTokenizer getTSVInstance(char[] input) {
/*  228 */     StrTokenizer tok = getTSVClone();
/*  229 */     tok.reset(input);
/*  230 */     return tok;
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
/*      */   public StrTokenizer() {
/*  242 */     this.chars = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String input) {
/*  253 */     if (input != null) {
/*  254 */       this.chars = input.toCharArray();
/*      */     } else {
/*  256 */       this.chars = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String input, char delim) {
/*  267 */     this(input);
/*  268 */     setDelimiterChar(delim);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String input, String delim) {
/*  278 */     this(input);
/*  279 */     setDelimiterString(delim);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String input, StrMatcher delim) {
/*  289 */     this(input);
/*  290 */     setDelimiterMatcher(delim);
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
/*      */   public StrTokenizer(String input, char delim, char quote) {
/*  302 */     this(input, delim);
/*  303 */     setQuoteChar(quote);
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
/*      */   public StrTokenizer(String input, StrMatcher delim, StrMatcher quote) {
/*  315 */     this(input, delim);
/*  316 */     setQuoteMatcher(quote);
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
/*      */   public StrTokenizer(char[] input) {
/*  330 */     this.chars = input;
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
/*      */   public StrTokenizer(char[] input, char delim) {
/*  343 */     this(input);
/*  344 */     setDelimiterChar(delim);
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
/*      */   public StrTokenizer(char[] input, String delim) {
/*  357 */     this(input);
/*  358 */     setDelimiterString(delim);
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
/*      */   public StrTokenizer(char[] input, StrMatcher delim) {
/*  371 */     this(input);
/*  372 */     setDelimiterMatcher(delim);
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
/*      */   public StrTokenizer(char[] input, char delim, char quote) {
/*  387 */     this(input, delim);
/*  388 */     setQuoteChar(quote);
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
/*      */   public StrTokenizer(char[] input, StrMatcher delim, StrMatcher quote) {
/*  403 */     this(input, delim);
/*  404 */     setQuoteMatcher(quote);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  415 */     checkTokenized();
/*  416 */     return this.tokens.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String nextToken() {
/*  425 */     if (hasNext()) {
/*  426 */       return this.tokens[this.tokenPos++];
/*      */     }
/*  428 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String previousToken() {
/*  437 */     if (hasPrevious()) {
/*  438 */       return this.tokens[--this.tokenPos];
/*      */     }
/*  440 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getTokenArray() {
/*  449 */     checkTokenized();
/*  450 */     return (String[])this.tokens.clone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List getTokenList() {
/*  459 */     checkTokenized();
/*  460 */     List list = new ArrayList(this.tokens.length);
/*  461 */     for (int i = 0; i < this.tokens.length; i++) {
/*  462 */       list.add(this.tokens[i]);
/*      */     }
/*  464 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer reset() {
/*  475 */     this.tokenPos = 0;
/*  476 */     this.tokens = null;
/*  477 */     return this;
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
/*      */   public StrTokenizer reset(String input) {
/*  489 */     reset();
/*  490 */     if (input != null) {
/*  491 */       this.chars = input.toCharArray();
/*      */     } else {
/*  493 */       this.chars = null;
/*      */     } 
/*  495 */     return this;
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
/*      */   public StrTokenizer reset(char[] input) {
/*  510 */     reset();
/*  511 */     this.chars = input;
/*  512 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasNext() {
/*  523 */     checkTokenized();
/*  524 */     return (this.tokenPos < this.tokens.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object next() {
/*  533 */     if (hasNext()) {
/*  534 */       return this.tokens[this.tokenPos++];
/*      */     }
/*  536 */     throw new NoSuchElementException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int nextIndex() {
/*  545 */     return this.tokenPos;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasPrevious() {
/*  554 */     checkTokenized();
/*  555 */     return (this.tokenPos > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object previous() {
/*  564 */     if (hasPrevious()) {
/*  565 */       return this.tokens[--this.tokenPos];
/*      */     }
/*  567 */     throw new NoSuchElementException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int previousIndex() {
/*  576 */     return this.tokenPos - 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void remove() {
/*  585 */     throw new UnsupportedOperationException("remove() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void set(Object obj) {
/*  594 */     throw new UnsupportedOperationException("set() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(Object obj) {
/*  603 */     throw new UnsupportedOperationException("add() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkTokenized() {
/*  612 */     if (this.tokens == null) {
/*  613 */       if (this.chars == null) {
/*      */         
/*  615 */         List split = tokenize(null, 0, 0);
/*  616 */         this.tokens = (String[])split.toArray((Object[])new String[split.size()]);
/*      */       } else {
/*  618 */         List split = tokenize(this.chars, 0, this.chars.length);
/*  619 */         this.tokens = (String[])split.toArray((Object[])new String[split.size()]);
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
/*      */   protected List tokenize(char[] chars, int offset, int count) {
/*  645 */     if (chars == null || count == 0) {
/*  646 */       return Collections.EMPTY_LIST;
/*      */     }
/*  648 */     StrBuilder buf = new StrBuilder();
/*  649 */     List tokens = new ArrayList();
/*  650 */     int pos = offset;
/*      */ 
/*      */     
/*  653 */     while (pos >= 0 && pos < count) {
/*      */       
/*  655 */       pos = readNextToken(chars, pos, count, buf, tokens);
/*      */ 
/*      */       
/*  658 */       if (pos >= count) {
/*  659 */         addToken(tokens, "");
/*      */       }
/*      */     } 
/*  662 */     return tokens;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void addToken(List list, String tok) {
/*  672 */     if (tok == null || tok.length() == 0) {
/*  673 */       if (isIgnoreEmptyTokens()) {
/*      */         return;
/*      */       }
/*  676 */       if (isEmptyTokenAsNull()) {
/*  677 */         tok = null;
/*      */       }
/*      */     } 
/*  680 */     list.add(tok);
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
/*      */   private int readNextToken(char[] chars, int start, int len, StrBuilder workArea, List tokens) {
/*  697 */     while (start < len) {
/*  698 */       int removeLen = Math.max(getIgnoredMatcher().isMatch(chars, start, start, len), getTrimmerMatcher().isMatch(chars, start, start, len));
/*      */ 
/*      */       
/*  701 */       if (removeLen == 0 || getDelimiterMatcher().isMatch(chars, start, start, len) > 0 || getQuoteMatcher().isMatch(chars, start, start, len) > 0) {
/*      */         break;
/*      */       }
/*      */ 
/*      */       
/*  706 */       start += removeLen;
/*      */     } 
/*      */ 
/*      */     
/*  710 */     if (start >= len) {
/*  711 */       addToken(tokens, "");
/*  712 */       return -1;
/*      */     } 
/*      */ 
/*      */     
/*  716 */     int delimLen = getDelimiterMatcher().isMatch(chars, start, start, len);
/*  717 */     if (delimLen > 0) {
/*  718 */       addToken(tokens, "");
/*  719 */       return start + delimLen;
/*      */     } 
/*      */ 
/*      */     
/*  723 */     int quoteLen = getQuoteMatcher().isMatch(chars, start, start, len);
/*  724 */     if (quoteLen > 0) {
/*  725 */       return readWithQuotes(chars, start + quoteLen, len, workArea, tokens, start, quoteLen);
/*      */     }
/*  727 */     return readWithQuotes(chars, start, len, workArea, tokens, 0, 0);
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
/*      */   private int readWithQuotes(char[] chars, int start, int len, StrBuilder workArea, List tokens, int quoteStart, int quoteLen) {
/*  749 */     workArea.clear();
/*  750 */     int pos = start;
/*  751 */     boolean quoting = (quoteLen > 0);
/*  752 */     int trimStart = 0;
/*      */     
/*  754 */     while (pos < len) {
/*      */ 
/*      */ 
/*      */       
/*  758 */       if (quoting) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  765 */         if (isQuote(chars, pos, len, quoteStart, quoteLen)) {
/*  766 */           if (isQuote(chars, pos + quoteLen, len, quoteStart, quoteLen)) {
/*      */             
/*  768 */             workArea.append(chars, pos, quoteLen);
/*  769 */             pos += quoteLen * 2;
/*  770 */             trimStart = workArea.size();
/*      */             
/*      */             continue;
/*      */           } 
/*      */           
/*  775 */           quoting = false;
/*  776 */           pos += quoteLen;
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/*  781 */         workArea.append(chars[pos++]);
/*  782 */         trimStart = workArea.size();
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  788 */       int delimLen = getDelimiterMatcher().isMatch(chars, pos, start, len);
/*  789 */       if (delimLen > 0) {
/*      */         
/*  791 */         addToken(tokens, workArea.substring(0, trimStart));
/*  792 */         return pos + delimLen;
/*      */       } 
/*      */ 
/*      */       
/*  796 */       if (quoteLen > 0 && 
/*  797 */         isQuote(chars, pos, len, quoteStart, quoteLen)) {
/*  798 */         quoting = true;
/*  799 */         pos += quoteLen;
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  805 */       int ignoredLen = getIgnoredMatcher().isMatch(chars, pos, start, len);
/*  806 */       if (ignoredLen > 0) {
/*  807 */         pos += ignoredLen;
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */ 
/*      */       
/*  814 */       int trimmedLen = getTrimmerMatcher().isMatch(chars, pos, start, len);
/*  815 */       if (trimmedLen > 0) {
/*  816 */         workArea.append(chars, pos, trimmedLen);
/*  817 */         pos += trimmedLen;
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  822 */       workArea.append(chars[pos++]);
/*  823 */       trimStart = workArea.size();
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  828 */     addToken(tokens, workArea.substring(0, trimStart));
/*  829 */     return -1;
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
/*      */   private boolean isQuote(char[] chars, int pos, int len, int quoteStart, int quoteLen) {
/*  844 */     for (int i = 0; i < quoteLen; i++) {
/*  845 */       if (pos + i >= len || chars[pos + i] != chars[quoteStart + i]) {
/*  846 */         return false;
/*      */       }
/*      */     } 
/*  849 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrMatcher getDelimiterMatcher() {
/*  860 */     return this.delimMatcher;
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
/*      */   public StrTokenizer setDelimiterMatcher(StrMatcher delim) {
/*  872 */     if (delim == null) {
/*  873 */       this.delimMatcher = StrMatcher.noneMatcher();
/*      */     } else {
/*  875 */       this.delimMatcher = delim;
/*      */     } 
/*  877 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setDelimiterChar(char delim) {
/*  887 */     return setDelimiterMatcher(StrMatcher.charMatcher(delim));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setDelimiterString(String delim) {
/*  897 */     return setDelimiterMatcher(StrMatcher.stringMatcher(delim));
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
/*      */   public StrMatcher getQuoteMatcher() {
/*  912 */     return this.quoteMatcher;
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
/*      */   public StrTokenizer setQuoteMatcher(StrMatcher quote) {
/*  925 */     if (quote != null) {
/*  926 */       this.quoteMatcher = quote;
/*      */     }
/*  928 */     return this;
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
/*      */   public StrTokenizer setQuoteChar(char quote) {
/*  941 */     return setQuoteMatcher(StrMatcher.charMatcher(quote));
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
/*      */   public StrMatcher getIgnoredMatcher() {
/*  956 */     return this.ignoredMatcher;
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
/*      */   public StrTokenizer setIgnoredMatcher(StrMatcher ignored) {
/*  969 */     if (ignored != null) {
/*  970 */       this.ignoredMatcher = ignored;
/*      */     }
/*  972 */     return this;
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
/*      */   public StrTokenizer setIgnoredChar(char ignored) {
/*  985 */     return setIgnoredMatcher(StrMatcher.charMatcher(ignored));
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
/*      */   public StrMatcher getTrimmerMatcher() {
/* 1000 */     return this.trimmerMatcher;
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
/*      */   public StrTokenizer setTrimmerMatcher(StrMatcher trimmer) {
/* 1013 */     if (trimmer != null) {
/* 1014 */       this.trimmerMatcher = trimmer;
/*      */     }
/* 1016 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmptyTokenAsNull() {
/* 1027 */     return this.emptyAsNull;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setEmptyTokenAsNull(boolean emptyAsNull) {
/* 1038 */     this.emptyAsNull = emptyAsNull;
/* 1039 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isIgnoreEmptyTokens() {
/* 1050 */     return this.ignoreEmptyTokens;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setIgnoreEmptyTokens(boolean ignoreEmptyTokens) {
/* 1061 */     this.ignoreEmptyTokens = ignoreEmptyTokens;
/* 1062 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getContent() {
/* 1072 */     if (this.chars == null) {
/* 1073 */       return null;
/*      */     }
/* 1075 */     return new String(this.chars);
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
/*      */   public Object clone() {
/*      */     try {
/* 1088 */       return cloneReset();
/*      */     } catch (CloneNotSupportedException ex) {
/* 1090 */       return null;
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
/*      */   Object cloneReset() throws CloneNotSupportedException {
/* 1103 */     StrTokenizer cloned = (StrTokenizer)super.clone();
/* 1104 */     if (cloned.chars != null) {
/* 1105 */       cloned.chars = (char[])cloned.chars.clone();
/*      */     }
/* 1107 */     cloned.reset();
/* 1108 */     return cloned;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1118 */     if (this.tokens == null) {
/* 1119 */       return "StrTokenizer[not tokenized yet]";
/*      */     }
/* 1121 */     return "StrTokenizer" + getTokenList();
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\text\StrTokenizer.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */