/*     */ package org.apache.commons.lang.text;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class StrSubstitutor
/*     */ {
/*     */   public static final char DEFAULT_ESCAPE = '$';
/* 101 */   public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
/*     */ 
/*     */ 
/*     */   
/* 105 */   public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private char escapeChar;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private StrMatcher prefixMatcher;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private StrMatcher suffixMatcher;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private StrLookup variableResolver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String replace(Object source, Map valueMap) {
/* 134 */     return (new StrSubstitutor(valueMap)).replace(source);
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
/*     */   public static String replace(Object source, Map valueMap, String prefix, String suffix) {
/* 150 */     return (new StrSubstitutor(valueMap, prefix, suffix)).replace(source);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String replaceSystemProperties(Object source) {
/* 161 */     return (new StrSubstitutor(StrLookup.systemPropertiesLookup())).replace(source);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StrSubstitutor() {
/* 170 */     this((StrLookup)null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StrSubstitutor(Map valueMap) {
/* 180 */     this(StrLookup.mapLookup(valueMap), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
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
/*     */   public StrSubstitutor(Map valueMap, String prefix, String suffix) {
/* 192 */     this(StrLookup.mapLookup(valueMap), prefix, suffix, '$');
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
/*     */   public StrSubstitutor(Map valueMap, String prefix, String suffix, char escape) {
/* 205 */     this(StrLookup.mapLookup(valueMap), prefix, suffix, escape);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StrSubstitutor(StrLookup variableResolver) {
/* 214 */     this(variableResolver, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
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
/*     */   public StrSubstitutor(StrLookup variableResolver, String prefix, String suffix, char escape) {
/* 227 */     setVariableResolver(variableResolver);
/* 228 */     setVariablePrefix(prefix);
/* 229 */     setVariableSuffix(suffix);
/* 230 */     setEscapeChar(escape);
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
/*     */   public StrSubstitutor(StrLookup variableResolver, StrMatcher prefixMatcher, StrMatcher suffixMatcher, char escape) {
/* 244 */     setVariableResolver(variableResolver);
/* 245 */     setVariablePrefixMatcher(prefixMatcher);
/* 246 */     setVariableSuffixMatcher(suffixMatcher);
/* 247 */     setEscapeChar(escape);
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
/*     */   public String replace(String source) {
/* 259 */     if (source == null) {
/* 260 */       return null;
/*     */     }
/* 262 */     StrBuilder buf = new StrBuilder(source);
/* 263 */     if (!substitute(buf, 0, source.length())) {
/* 264 */       return source;
/*     */     }
/* 266 */     return buf.toString();
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
/*     */   public String replace(String source, int offset, int length) {
/* 282 */     if (source == null) {
/* 283 */       return null;
/*     */     }
/* 285 */     StrBuilder buf = (new StrBuilder(length)).append(source, offset, length);
/* 286 */     if (!substitute(buf, 0, length)) {
/* 287 */       return source.substring(offset, offset + length);
/*     */     }
/* 289 */     return buf.toString();
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
/*     */   public String replace(char[] source) {
/* 302 */     if (source == null) {
/* 303 */       return null;
/*     */     }
/* 305 */     StrBuilder buf = (new StrBuilder(source.length)).append(source);
/* 306 */     substitute(buf, 0, source.length);
/* 307 */     return buf.toString();
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
/*     */   public String replace(char[] source, int offset, int length) {
/* 324 */     if (source == null) {
/* 325 */       return null;
/*     */     }
/* 327 */     StrBuilder buf = (new StrBuilder(length)).append(source, offset, length);
/* 328 */     substitute(buf, 0, length);
/* 329 */     return buf.toString();
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
/*     */   public String replace(StringBuffer source) {
/* 342 */     if (source == null) {
/* 343 */       return null;
/*     */     }
/* 345 */     StrBuilder buf = (new StrBuilder(source.length())).append(source);
/* 346 */     substitute(buf, 0, buf.length());
/* 347 */     return buf.toString();
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
/*     */   public String replace(StringBuffer source, int offset, int length) {
/* 364 */     if (source == null) {
/* 365 */       return null;
/*     */     }
/* 367 */     StrBuilder buf = (new StrBuilder(length)).append(source, offset, length);
/* 368 */     substitute(buf, 0, length);
/* 369 */     return buf.toString();
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
/*     */   public String replace(StrBuilder source) {
/* 382 */     if (source == null) {
/* 383 */       return null;
/*     */     }
/* 385 */     StrBuilder buf = (new StrBuilder(source.length())).append(source);
/* 386 */     substitute(buf, 0, buf.length());
/* 387 */     return buf.toString();
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
/*     */   public String replace(StrBuilder source, int offset, int length) {
/* 404 */     if (source == null) {
/* 405 */       return null;
/*     */     }
/* 407 */     StrBuilder buf = (new StrBuilder(length)).append(source, offset, length);
/* 408 */     substitute(buf, 0, length);
/* 409 */     return buf.toString();
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
/*     */   public String replace(Object source) {
/* 422 */     if (source == null) {
/* 423 */       return null;
/*     */     }
/* 425 */     StrBuilder buf = (new StrBuilder()).append(source);
/* 426 */     substitute(buf, 0, buf.length());
/* 427 */     return buf.toString();
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
/*     */   public boolean replaceIn(StringBuffer source) {
/* 440 */     if (source == null) {
/* 441 */       return false;
/*     */     }
/* 443 */     return replaceIn(source, 0, source.length());
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
/*     */   public boolean replaceIn(StringBuffer source, int offset, int length) {
/* 460 */     if (source == null) {
/* 461 */       return false;
/*     */     }
/* 463 */     StrBuilder buf = (new StrBuilder(length)).append(source, offset, length);
/* 464 */     if (!substitute(buf, 0, length)) {
/* 465 */       return false;
/*     */     }
/* 467 */     source.replace(offset, offset + length, buf.toString());
/* 468 */     return true;
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
/*     */   public boolean replaceIn(StrBuilder source) {
/* 480 */     if (source == null) {
/* 481 */       return false;
/*     */     }
/* 483 */     return substitute(source, 0, source.length());
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
/*     */   public boolean replaceIn(StrBuilder source, int offset, int length) {
/* 499 */     if (source == null) {
/* 500 */       return false;
/*     */     }
/* 502 */     return substitute(source, offset, length);
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
/*     */   protected boolean substitute(StrBuilder buf, int offset, int length) {
/* 521 */     return (substitute(buf, offset, length, null) > 0);
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
/*     */   private int substitute(StrBuilder buf, int offset, int length, List priorVariables) {
/* 537 */     StrMatcher prefixMatcher = getVariablePrefixMatcher();
/* 538 */     StrMatcher suffixMatcher = getVariableSuffixMatcher();
/* 539 */     char escape = getEscapeChar();
/*     */     
/* 541 */     boolean top = (priorVariables == null);
/* 542 */     boolean altered = false;
/* 543 */     int lengthChange = 0;
/* 544 */     char[] chars = buf.buffer;
/* 545 */     int bufEnd = offset + length;
/* 546 */     int pos = offset;
/* 547 */     while (pos < bufEnd) {
/* 548 */       int startMatchLen = prefixMatcher.isMatch(chars, pos, offset, bufEnd);
/* 549 */       if (startMatchLen == 0) {
/* 550 */         pos++;
/*     */         continue;
/*     */       } 
/* 553 */       if (pos > offset && chars[pos - 1] == escape) {
/*     */         
/* 555 */         buf.deleteCharAt(pos - 1);
/* 556 */         chars = buf.buffer;
/* 557 */         lengthChange--;
/* 558 */         altered = true;
/* 559 */         bufEnd--;
/*     */         continue;
/*     */       } 
/* 562 */       int startPos = pos;
/* 563 */       pos += startMatchLen;
/* 564 */       int endMatchLen = 0;
/* 565 */       while (pos < bufEnd) {
/* 566 */         endMatchLen = suffixMatcher.isMatch(chars, pos, offset, bufEnd);
/* 567 */         if (endMatchLen == 0) {
/* 568 */           pos++;
/*     */           continue;
/*     */         } 
/* 571 */         String varName = new String(chars, startPos + startMatchLen, pos - startPos - startMatchLen);
/*     */         
/* 573 */         pos += endMatchLen;
/* 574 */         int endPos = pos;
/*     */ 
/*     */         
/* 577 */         if (priorVariables == null) {
/* 578 */           priorVariables = new ArrayList();
/* 579 */           priorVariables.add(new String(chars, offset, length));
/*     */         } 
/*     */ 
/*     */         
/* 583 */         checkCyclicSubstitution(varName, priorVariables);
/* 584 */         priorVariables.add(varName);
/*     */ 
/*     */         
/* 587 */         String varValue = resolveVariable(varName, buf, startPos, endPos);
/* 588 */         if (varValue != null) {
/*     */           
/* 590 */           int varLen = varValue.length();
/* 591 */           buf.replace(startPos, endPos, varValue);
/* 592 */           altered = true;
/* 593 */           int change = substitute(buf, startPos, varLen, priorVariables);
/* 594 */           change += varLen - endPos - startPos;
/* 595 */           pos += change;
/* 596 */           bufEnd += change;
/* 597 */           lengthChange += change;
/* 598 */           chars = buf.buffer;
/*     */         } 
/*     */ 
/*     */         
/* 602 */         priorVariables.remove(priorVariables.size() - 1);
/*     */ 
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 609 */     if (top) {
/* 610 */       return altered ? 1 : 0;
/*     */     }
/* 612 */     return lengthChange;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkCyclicSubstitution(String varName, List priorVariables) {
/* 622 */     if (!priorVariables.contains(varName)) {
/*     */       return;
/*     */     }
/* 625 */     StrBuilder buf = new StrBuilder(256);
/* 626 */     buf.append("Infinite loop in property interpolation of ");
/* 627 */     buf.append(priorVariables.remove(0));
/* 628 */     buf.append(": ");
/* 629 */     buf.appendWithSeparators(priorVariables, "->");
/* 630 */     throw new IllegalStateException(buf.toString());
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
/*     */ 
/*     */   
/*     */   protected String resolveVariable(String variableName, StrBuilder buf, int startPos, int endPos) {
/* 651 */     StrLookup resolver = getVariableResolver();
/* 652 */     if (resolver == null) {
/* 653 */       return null;
/*     */     }
/* 655 */     return resolver.lookup(variableName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char getEscapeChar() {
/* 666 */     return this.escapeChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEscapeChar(char escapeCharacter) {
/* 677 */     this.escapeChar = escapeCharacter;
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
/*     */   public StrMatcher getVariablePrefixMatcher() {
/* 692 */     return this.prefixMatcher;
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
/*     */   public StrSubstitutor setVariablePrefixMatcher(StrMatcher prefixMatcher) {
/* 707 */     if (prefixMatcher == null) {
/* 708 */       throw new IllegalArgumentException("Variable prefix matcher must not be null!");
/*     */     }
/* 710 */     this.prefixMatcher = prefixMatcher;
/* 711 */     return this;
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
/*     */   public StrSubstitutor setVariablePrefix(char prefix) {
/* 725 */     return setVariablePrefixMatcher(StrMatcher.charMatcher(prefix));
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
/*     */   public StrSubstitutor setVariablePrefix(String prefix) {
/* 739 */     if (prefix == null) {
/* 740 */       throw new IllegalArgumentException("Variable prefix must not be null!");
/*     */     }
/* 742 */     return setVariablePrefixMatcher(StrMatcher.stringMatcher(prefix));
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
/*     */   public StrMatcher getVariableSuffixMatcher() {
/* 757 */     return this.suffixMatcher;
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
/*     */   public StrSubstitutor setVariableSuffixMatcher(StrMatcher suffixMatcher) {
/* 772 */     if (suffixMatcher == null) {
/* 773 */       throw new IllegalArgumentException("Variable suffix matcher must not be null!");
/*     */     }
/* 775 */     this.suffixMatcher = suffixMatcher;
/* 776 */     return this;
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
/*     */   public StrSubstitutor setVariableSuffix(char suffix) {
/* 790 */     return setVariableSuffixMatcher(StrMatcher.charMatcher(suffix));
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
/*     */   public StrSubstitutor setVariableSuffix(String suffix) {
/* 804 */     if (suffix == null) {
/* 805 */       throw new IllegalArgumentException("Variable suffix must not be null!");
/*     */     }
/* 807 */     return setVariableSuffixMatcher(StrMatcher.stringMatcher(suffix));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StrLookup getVariableResolver() {
/* 818 */     return this.variableResolver;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVariableResolver(StrLookup variableResolver) {
/* 827 */     this.variableResolver = variableResolver;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\text\StrSubstitutor.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */