/*      */ package org.apache.commons.lang.text;
/*      */ 
/*      */ import java.io.Reader;
/*      */ import java.io.Writer;
/*      */ import java.util.Collection;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import org.apache.commons.lang.ArrayUtils;
/*      */ import org.apache.commons.lang.SystemUtils;
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
/*      */ public class StrBuilder
/*      */   implements Cloneable
/*      */ {
/*      */   static final int CAPACITY = 32;
/*      */   private static final long serialVersionUID = 7628716375283629643L;
/*      */   protected char[] buffer;
/*      */   protected int size;
/*      */   private String newLine;
/*      */   private String nullText;
/*      */   
/*      */   public StrBuilder() {
/*   98 */     this(32);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder(int initialCapacity) {
/*  108 */     if (initialCapacity <= 0) {
/*  109 */       initialCapacity = 32;
/*      */     }
/*  111 */     this.buffer = new char[initialCapacity];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder(String str) {
/*  122 */     if (str == null) {
/*  123 */       this.buffer = new char[32];
/*      */     } else {
/*  125 */       this.buffer = new char[str.length() + 32];
/*  126 */       append(str);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNewLineText() {
/*  137 */     return this.newLine;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder setNewLineText(String newLine) {
/*  147 */     this.newLine = newLine;
/*  148 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNullText() {
/*  158 */     return this.nullText;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder setNullText(String nullText) {
/*  168 */     if (nullText != null && nullText.length() == 0) {
/*  169 */       nullText = null;
/*      */     }
/*  171 */     this.nullText = nullText;
/*  172 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int length() {
/*  182 */     return this.size;
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
/*      */   public StrBuilder setLength(int length) {
/*  194 */     if (length < 0) {
/*  195 */       throw new StringIndexOutOfBoundsException(length);
/*      */     }
/*  197 */     if (length < this.size) {
/*  198 */       this.size = length;
/*  199 */     } else if (length > this.size) {
/*  200 */       ensureCapacity(length);
/*  201 */       int oldEnd = this.size;
/*  202 */       int newEnd = length;
/*  203 */       this.size = length;
/*  204 */       for (int i = oldEnd; i < newEnd; i++) {
/*  205 */         this.buffer[i] = Character.MIN_VALUE;
/*      */       }
/*      */     } 
/*  208 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int capacity() {
/*  218 */     return this.buffer.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder ensureCapacity(int capacity) {
/*  228 */     if (capacity > this.buffer.length) {
/*  229 */       char[] old = this.buffer;
/*  230 */       this.buffer = new char[capacity];
/*  231 */       System.arraycopy(old, 0, this.buffer, 0, this.size);
/*      */     } 
/*  233 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder minimizeCapacity() {
/*  242 */     if (this.buffer.length > length()) {
/*  243 */       char[] old = this.buffer;
/*  244 */       this.buffer = new char[length()];
/*  245 */       System.arraycopy(old, 0, this.buffer, 0, this.size);
/*      */     } 
/*  247 */     return this;
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
/*      */   public int size() {
/*  260 */     return this.size;
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
/*      */   public boolean isEmpty() {
/*  272 */     return (this.size == 0);
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
/*      */   public StrBuilder clear() {
/*  287 */     this.size = 0;
/*  288 */     return this;
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
/*      */   public char charAt(int index) {
/*  302 */     if (index < 0 || index >= length()) {
/*  303 */       throw new StringIndexOutOfBoundsException(index);
/*      */     }
/*  305 */     return this.buffer[index];
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
/*      */   public StrBuilder setCharAt(int index, char ch) {
/*  319 */     if (index < 0 || index >= length()) {
/*  320 */       throw new StringIndexOutOfBoundsException(index);
/*      */     }
/*  322 */     this.buffer[index] = ch;
/*  323 */     return this;
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
/*      */   public StrBuilder deleteCharAt(int index) {
/*  336 */     if (index < 0 || index >= this.size) {
/*  337 */       throw new StringIndexOutOfBoundsException(index);
/*      */     }
/*  339 */     deleteImpl(index, index + 1, 1);
/*  340 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char[] toCharArray() {
/*  350 */     if (this.size == 0) {
/*  351 */       return ArrayUtils.EMPTY_CHAR_ARRAY;
/*      */     }
/*  353 */     char[] chars = new char[this.size];
/*  354 */     System.arraycopy(this.buffer, 0, chars, 0, this.size);
/*  355 */     return chars;
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
/*      */   public char[] toCharArray(int startIndex, int endIndex) {
/*  369 */     endIndex = validateRange(startIndex, endIndex);
/*  370 */     int len = endIndex - startIndex;
/*  371 */     if (len == 0) {
/*  372 */       return ArrayUtils.EMPTY_CHAR_ARRAY;
/*      */     }
/*  374 */     char[] chars = new char[len];
/*  375 */     System.arraycopy(this.buffer, startIndex, chars, 0, len);
/*  376 */     return chars;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char[] getChars(char[] destination) {
/*  386 */     int len = length();
/*  387 */     if (destination == null || destination.length < len) {
/*  388 */       destination = new char[len];
/*      */     }
/*  390 */     System.arraycopy(this.buffer, 0, destination, 0, len);
/*  391 */     return destination;
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
/*      */   public void getChars(int startIndex, int endIndex, char[] destination, int destinationIndex) {
/*  405 */     if (startIndex < 0) {
/*  406 */       throw new StringIndexOutOfBoundsException(startIndex);
/*      */     }
/*  408 */     if (endIndex < 0 || endIndex > length()) {
/*  409 */       throw new StringIndexOutOfBoundsException(endIndex);
/*      */     }
/*  411 */     if (startIndex > endIndex) {
/*  412 */       throw new StringIndexOutOfBoundsException("end < start");
/*      */     }
/*  414 */     System.arraycopy(this.buffer, startIndex, destination, destinationIndex, endIndex - startIndex);
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
/*      */   public StrBuilder appendNewLine() {
/*  428 */     if (this.newLine == null) {
/*  429 */       append(SystemUtils.LINE_SEPARATOR);
/*  430 */       return this;
/*      */     } 
/*  432 */     return append(this.newLine);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendNull() {
/*  441 */     if (this.nullText == null) {
/*  442 */       return this;
/*      */     }
/*  444 */     return append(this.nullText);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(Object obj) {
/*  455 */     if (obj == null) {
/*  456 */       return appendNull();
/*      */     }
/*  458 */     return append(obj.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(String str) {
/*  469 */     if (str == null) {
/*  470 */       return appendNull();
/*      */     }
/*  472 */     int strLen = str.length();
/*  473 */     if (strLen > 0) {
/*  474 */       int len = length();
/*  475 */       ensureCapacity(len + strLen);
/*  476 */       str.getChars(0, strLen, this.buffer, len);
/*  477 */       this.size += strLen;
/*      */     } 
/*  479 */     return this;
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
/*      */   public StrBuilder append(String str, int startIndex, int length) {
/*  492 */     if (str == null) {
/*  493 */       return appendNull();
/*      */     }
/*  495 */     if (startIndex < 0 || startIndex > str.length()) {
/*  496 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  498 */     if (length < 0 || startIndex + length > str.length()) {
/*  499 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  501 */     if (length > 0) {
/*  502 */       int len = length();
/*  503 */       ensureCapacity(len + length);
/*  504 */       str.getChars(startIndex, startIndex + length, this.buffer, len);
/*  505 */       this.size += length;
/*      */     } 
/*  507 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(StringBuffer str) {
/*  518 */     if (str == null) {
/*  519 */       return appendNull();
/*      */     }
/*  521 */     int strLen = str.length();
/*  522 */     if (strLen > 0) {
/*  523 */       int len = length();
/*  524 */       ensureCapacity(len + strLen);
/*  525 */       str.getChars(0, strLen, this.buffer, len);
/*  526 */       this.size += strLen;
/*      */     } 
/*  528 */     return this;
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
/*      */   public StrBuilder append(StringBuffer str, int startIndex, int length) {
/*  541 */     if (str == null) {
/*  542 */       return appendNull();
/*      */     }
/*  544 */     if (startIndex < 0 || startIndex > str.length()) {
/*  545 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  547 */     if (length < 0 || startIndex + length > str.length()) {
/*  548 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  550 */     if (length > 0) {
/*  551 */       int len = length();
/*  552 */       ensureCapacity(len + length);
/*  553 */       str.getChars(startIndex, startIndex + length, this.buffer, len);
/*  554 */       this.size += length;
/*      */     } 
/*  556 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(StrBuilder str) {
/*  567 */     if (str == null) {
/*  568 */       return appendNull();
/*      */     }
/*  570 */     int strLen = str.length();
/*  571 */     if (strLen > 0) {
/*  572 */       int len = length();
/*  573 */       ensureCapacity(len + strLen);
/*  574 */       System.arraycopy(str.buffer, 0, this.buffer, len, strLen);
/*  575 */       this.size += strLen;
/*      */     } 
/*  577 */     return this;
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
/*      */   public StrBuilder append(StrBuilder str, int startIndex, int length) {
/*  590 */     if (str == null) {
/*  591 */       return appendNull();
/*      */     }
/*  593 */     if (startIndex < 0 || startIndex > str.length()) {
/*  594 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  596 */     if (length < 0 || startIndex + length > str.length()) {
/*  597 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  599 */     if (length > 0) {
/*  600 */       int len = length();
/*  601 */       ensureCapacity(len + length);
/*  602 */       str.getChars(startIndex, startIndex + length, this.buffer, len);
/*  603 */       this.size += length;
/*      */     } 
/*  605 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(char[] chars) {
/*  616 */     if (chars == null) {
/*  617 */       return appendNull();
/*      */     }
/*  619 */     int strLen = chars.length;
/*  620 */     if (strLen > 0) {
/*  621 */       int len = length();
/*  622 */       ensureCapacity(len + strLen);
/*  623 */       System.arraycopy(chars, 0, this.buffer, len, strLen);
/*  624 */       this.size += strLen;
/*      */     } 
/*  626 */     return this;
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
/*      */   public StrBuilder append(char[] chars, int startIndex, int length) {
/*  639 */     if (chars == null) {
/*  640 */       return appendNull();
/*      */     }
/*  642 */     if (startIndex < 0 || startIndex > chars.length) {
/*  643 */       throw new StringIndexOutOfBoundsException("Invalid startIndex: " + length);
/*      */     }
/*  645 */     if (length < 0 || startIndex + length > chars.length) {
/*  646 */       throw new StringIndexOutOfBoundsException("Invalid length: " + length);
/*      */     }
/*  648 */     if (length > 0) {
/*  649 */       int len = length();
/*  650 */       ensureCapacity(len + length);
/*  651 */       System.arraycopy(chars, startIndex, this.buffer, len, length);
/*  652 */       this.size += length;
/*      */     } 
/*  654 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(boolean value) {
/*  664 */     if (value) {
/*  665 */       ensureCapacity(this.size + 4);
/*  666 */       this.buffer[this.size++] = 't';
/*  667 */       this.buffer[this.size++] = 'r';
/*  668 */       this.buffer[this.size++] = 'u';
/*  669 */       this.buffer[this.size++] = 'e';
/*      */     } else {
/*  671 */       ensureCapacity(this.size + 5);
/*  672 */       this.buffer[this.size++] = 'f';
/*  673 */       this.buffer[this.size++] = 'a';
/*  674 */       this.buffer[this.size++] = 'l';
/*  675 */       this.buffer[this.size++] = 's';
/*  676 */       this.buffer[this.size++] = 'e';
/*      */     } 
/*  678 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(char ch) {
/*  688 */     int len = length();
/*  689 */     ensureCapacity(len + 1);
/*  690 */     this.buffer[this.size++] = ch;
/*  691 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(int value) {
/*  701 */     return append(String.valueOf(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(long value) {
/*  711 */     return append(String.valueOf(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(float value) {
/*  721 */     return append(String.valueOf(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(double value) {
/*  731 */     return append(String.valueOf(value));
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
/*      */   public StrBuilder appendln(Object obj) {
/*  744 */     return append(obj).appendNewLine();
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
/*      */   public StrBuilder appendln(String str) {
/*  756 */     return append(str).appendNewLine();
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
/*      */   public StrBuilder appendln(String str, int startIndex, int length) {
/*  770 */     return append(str, startIndex, length).appendNewLine();
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
/*      */   public StrBuilder appendln(StringBuffer str) {
/*  782 */     return append(str).appendNewLine();
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
/*      */   public StrBuilder appendln(StringBuffer str, int startIndex, int length) {
/*  796 */     return append(str, startIndex, length).appendNewLine();
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
/*      */   public StrBuilder appendln(StrBuilder str) {
/*  808 */     return append(str).appendNewLine();
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
/*      */   public StrBuilder appendln(StrBuilder str, int startIndex, int length) {
/*  822 */     return append(str, startIndex, length).appendNewLine();
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
/*      */   public StrBuilder appendln(char[] chars) {
/*  834 */     return append(chars).appendNewLine();
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
/*      */   public StrBuilder appendln(char[] chars, int startIndex, int length) {
/*  848 */     return append(chars, startIndex, length).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(boolean value) {
/*  859 */     return append(value).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(char ch) {
/*  870 */     return append(ch).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(int value) {
/*  881 */     return append(value).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(long value) {
/*  892 */     return append(value).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(float value) {
/*  903 */     return append(value).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(double value) {
/*  914 */     return append(value).appendNewLine();
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
/*      */   public StrBuilder appendAll(Object[] array) {
/*  928 */     if (array != null && array.length > 0) {
/*  929 */       for (int i = 0; i < array.length; i++) {
/*  930 */         append(array[i]);
/*      */       }
/*      */     }
/*  933 */     return this;
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
/*      */   public StrBuilder appendAll(Collection coll) {
/*  946 */     if (coll != null && coll.size() > 0) {
/*  947 */       Iterator it = coll.iterator();
/*  948 */       while (it.hasNext()) {
/*  949 */         append(it.next());
/*      */       }
/*      */     } 
/*  952 */     return this;
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
/*      */   public StrBuilder appendAll(Iterator it) {
/*  965 */     if (it != null) {
/*  966 */       while (it.hasNext()) {
/*  967 */         append(it.next());
/*      */       }
/*      */     }
/*  970 */     return this;
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
/*      */   public StrBuilder appendWithSeparators(Object[] array, String separator) {
/*  985 */     if (array != null && array.length > 0) {
/*  986 */       separator = (separator == null) ? "" : separator;
/*  987 */       append(array[0]);
/*  988 */       for (int i = 1; i < array.length; i++) {
/*  989 */         append(separator);
/*  990 */         append(array[i]);
/*      */       } 
/*      */     } 
/*  993 */     return this;
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
/*      */   public StrBuilder appendWithSeparators(Collection coll, String separator) {
/* 1007 */     if (coll != null && coll.size() > 0) {
/* 1008 */       separator = (separator == null) ? "" : separator;
/* 1009 */       Iterator it = coll.iterator();
/* 1010 */       while (it.hasNext()) {
/* 1011 */         append(it.next());
/* 1012 */         if (it.hasNext()) {
/* 1013 */           append(separator);
/*      */         }
/*      */       } 
/*      */     } 
/* 1017 */     return this;
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
/*      */   public StrBuilder appendWithSeparators(Iterator it, String separator) {
/* 1031 */     if (it != null) {
/* 1032 */       separator = (separator == null) ? "" : separator;
/* 1033 */       while (it.hasNext()) {
/* 1034 */         append(it.next());
/* 1035 */         if (it.hasNext()) {
/* 1036 */           append(separator);
/*      */         }
/*      */       } 
/*      */     } 
/* 1040 */     return this;
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
/*      */   public StrBuilder appendSeparator(String separator) {
/* 1065 */     if (separator != null && size() > 0) {
/* 1066 */       append(separator);
/*      */     }
/* 1068 */     return this;
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
/*      */   public StrBuilder appendSeparator(char separator) {
/* 1091 */     if (size() > 0) {
/* 1092 */       append(separator);
/*      */     }
/* 1094 */     return this;
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
/*      */   public StrBuilder appendSeparator(String separator, int loopIndex) {
/* 1119 */     if (separator != null && loopIndex > 0) {
/* 1120 */       append(separator);
/*      */     }
/* 1122 */     return this;
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
/*      */   public StrBuilder appendSeparator(char separator, int loopIndex) {
/* 1146 */     if (loopIndex > 0) {
/* 1147 */       append(separator);
/*      */     }
/* 1149 */     return this;
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
/*      */   public StrBuilder appendPadding(int length, char padChar) {
/* 1161 */     if (length >= 0) {
/* 1162 */       ensureCapacity(this.size + length);
/* 1163 */       for (int i = 0; i < length; i++) {
/* 1164 */         this.buffer[this.size++] = padChar;
/*      */       }
/*      */     } 
/* 1167 */     return this;
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
/*      */   public StrBuilder appendFixedWidthPadLeft(Object obj, int width, char padChar) {
/* 1183 */     if (width > 0) {
/* 1184 */       ensureCapacity(this.size + width);
/* 1185 */       String str = (obj == null) ? getNullText() : obj.toString();
/* 1186 */       int strLen = str.length();
/* 1187 */       if (strLen >= width) {
/* 1188 */         str.getChars(strLen - width, strLen, this.buffer, this.size);
/*      */       } else {
/* 1190 */         int padLen = width - strLen;
/* 1191 */         for (int i = 0; i < padLen; i++) {
/* 1192 */           this.buffer[this.size + i] = padChar;
/*      */         }
/* 1194 */         str.getChars(0, strLen, this.buffer, this.size + padLen);
/*      */       } 
/* 1196 */       this.size += width;
/*      */     } 
/* 1198 */     return this;
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
/*      */   public StrBuilder appendFixedWidthPadLeft(int value, int width, char padChar) {
/* 1212 */     return appendFixedWidthPadLeft(String.valueOf(value), width, padChar);
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
/*      */   public StrBuilder appendFixedWidthPadRight(Object obj, int width, char padChar) {
/* 1227 */     if (width > 0) {
/* 1228 */       ensureCapacity(this.size + width);
/* 1229 */       String str = (obj == null) ? getNullText() : obj.toString();
/* 1230 */       int strLen = str.length();
/* 1231 */       if (strLen >= width) {
/* 1232 */         str.getChars(0, width, this.buffer, this.size);
/*      */       } else {
/* 1234 */         int padLen = width - strLen;
/* 1235 */         str.getChars(0, strLen, this.buffer, this.size);
/* 1236 */         for (int i = 0; i < padLen; i++) {
/* 1237 */           this.buffer[this.size + strLen + i] = padChar;
/*      */         }
/*      */       } 
/* 1240 */       this.size += width;
/*      */     } 
/* 1242 */     return this;
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
/*      */   public StrBuilder appendFixedWidthPadRight(int value, int width, char padChar) {
/* 1256 */     return appendFixedWidthPadRight(String.valueOf(value), width, padChar);
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
/*      */   public StrBuilder insert(int index, Object obj) {
/* 1270 */     if (obj == null) {
/* 1271 */       return insert(index, this.nullText);
/*      */     }
/* 1273 */     return insert(index, obj.toString());
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
/*      */   public StrBuilder insert(int index, String str) {
/* 1286 */     validateIndex(index);
/* 1287 */     if (str == null) {
/* 1288 */       str = this.nullText;
/*      */     }
/* 1290 */     int strLen = (str == null) ? 0 : str.length();
/* 1291 */     if (strLen > 0) {
/* 1292 */       int newSize = this.size + strLen;
/* 1293 */       ensureCapacity(newSize);
/* 1294 */       System.arraycopy(this.buffer, index, this.buffer, index + strLen, this.size - index);
/* 1295 */       this.size = newSize;
/* 1296 */       str.getChars(0, strLen, this.buffer, index);
/*      */     } 
/* 1298 */     return this;
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
/*      */   public StrBuilder insert(int index, char[] chars) {
/* 1311 */     validateIndex(index);
/* 1312 */     if (chars == null) {
/* 1313 */       return insert(index, this.nullText);
/*      */     }
/* 1315 */     int len = chars.length;
/* 1316 */     if (len > 0) {
/* 1317 */       ensureCapacity(this.size + len);
/* 1318 */       System.arraycopy(this.buffer, index, this.buffer, index + len, this.size - index);
/* 1319 */       System.arraycopy(chars, 0, this.buffer, index, len);
/* 1320 */       this.size += len;
/*      */     } 
/* 1322 */     return this;
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
/*      */   public StrBuilder insert(int index, char[] chars, int offset, int length) {
/* 1337 */     validateIndex(index);
/* 1338 */     if (chars == null) {
/* 1339 */       return insert(index, this.nullText);
/*      */     }
/* 1341 */     if (offset < 0 || offset > chars.length) {
/* 1342 */       throw new StringIndexOutOfBoundsException("Invalid offset: " + offset);
/*      */     }
/* 1344 */     if (length < 0 || offset + length > chars.length) {
/* 1345 */       throw new StringIndexOutOfBoundsException("Invalid length: " + length);
/*      */     }
/* 1347 */     if (length > 0) {
/* 1348 */       ensureCapacity(this.size + length);
/* 1349 */       System.arraycopy(this.buffer, index, this.buffer, index + length, this.size - index);
/* 1350 */       System.arraycopy(chars, offset, this.buffer, index, length);
/* 1351 */       this.size += length;
/*      */     } 
/* 1353 */     return this;
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
/*      */   public StrBuilder insert(int index, boolean value) {
/* 1365 */     validateIndex(index);
/* 1366 */     if (value) {
/* 1367 */       ensureCapacity(this.size + 4);
/* 1368 */       System.arraycopy(this.buffer, index, this.buffer, index + 4, this.size - index);
/* 1369 */       this.buffer[index++] = 't';
/* 1370 */       this.buffer[index++] = 'r';
/* 1371 */       this.buffer[index++] = 'u';
/* 1372 */       this.buffer[index] = 'e';
/* 1373 */       this.size += 4;
/*      */     } else {
/* 1375 */       ensureCapacity(this.size + 5);
/* 1376 */       System.arraycopy(this.buffer, index, this.buffer, index + 5, this.size - index);
/* 1377 */       this.buffer[index++] = 'f';
/* 1378 */       this.buffer[index++] = 'a';
/* 1379 */       this.buffer[index++] = 'l';
/* 1380 */       this.buffer[index++] = 's';
/* 1381 */       this.buffer[index] = 'e';
/* 1382 */       this.size += 5;
/*      */     } 
/* 1384 */     return this;
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
/*      */   public StrBuilder insert(int index, char value) {
/* 1396 */     validateIndex(index);
/* 1397 */     ensureCapacity(this.size + 1);
/* 1398 */     System.arraycopy(this.buffer, index, this.buffer, index + 1, this.size - index);
/* 1399 */     this.buffer[index] = value;
/* 1400 */     this.size++;
/* 1401 */     return this;
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
/*      */   public StrBuilder insert(int index, int value) {
/* 1413 */     return insert(index, String.valueOf(value));
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
/*      */   public StrBuilder insert(int index, long value) {
/* 1425 */     return insert(index, String.valueOf(value));
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
/*      */   public StrBuilder insert(int index, float value) {
/* 1437 */     return insert(index, String.valueOf(value));
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
/*      */   public StrBuilder insert(int index, double value) {
/* 1449 */     return insert(index, String.valueOf(value));
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
/*      */   private void deleteImpl(int startIndex, int endIndex, int len) {
/* 1462 */     System.arraycopy(this.buffer, endIndex, this.buffer, startIndex, this.size - endIndex);
/* 1463 */     this.size -= len;
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
/*      */   public StrBuilder delete(int startIndex, int endIndex) {
/* 1476 */     endIndex = validateRange(startIndex, endIndex);
/* 1477 */     int len = endIndex - startIndex;
/* 1478 */     if (len > 0) {
/* 1479 */       deleteImpl(startIndex, endIndex, len);
/*      */     }
/* 1481 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteAll(char ch) {
/* 1492 */     for (int i = 0; i < this.size; i++) {
/* 1493 */       if (this.buffer[i] == ch) {
/* 1494 */         int start = i; do {  }
/* 1495 */         while (++i < this.size && 
/* 1496 */           this.buffer[i] == ch);
/*      */ 
/*      */ 
/*      */         
/* 1500 */         int len = i - start;
/* 1501 */         deleteImpl(start, i, len);
/* 1502 */         i -= len;
/*      */       } 
/*      */     } 
/* 1505 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteFirst(char ch) {
/* 1515 */     for (int i = 0; i < this.size; i++) {
/* 1516 */       if (this.buffer[i] == ch) {
/* 1517 */         deleteImpl(i, i + 1, 1);
/*      */         break;
/*      */       } 
/*      */     } 
/* 1521 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteAll(String str) {
/* 1532 */     int len = (str == null) ? 0 : str.length();
/* 1533 */     if (len > 0) {
/* 1534 */       int index = indexOf(str, 0);
/* 1535 */       while (index >= 0) {
/* 1536 */         deleteImpl(index, index + len, len);
/* 1537 */         index = indexOf(str, index);
/*      */       } 
/*      */     } 
/* 1540 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteFirst(String str) {
/* 1550 */     int len = (str == null) ? 0 : str.length();
/* 1551 */     if (len > 0) {
/* 1552 */       int index = indexOf(str, 0);
/* 1553 */       if (index >= 0) {
/* 1554 */         deleteImpl(index, index + len, len);
/*      */       }
/*      */     } 
/* 1557 */     return this;
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
/*      */   public StrBuilder deleteAll(StrMatcher matcher) {
/* 1572 */     return replace(matcher, null, 0, this.size, -1);
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
/*      */   public StrBuilder deleteFirst(StrMatcher matcher) {
/* 1586 */     return replace(matcher, null, 0, this.size, 1);
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
/*      */   private void replaceImpl(int startIndex, int endIndex, int removeLen, String insertStr, int insertLen) {
/* 1601 */     int newSize = this.size - removeLen + insertLen;
/* 1602 */     if (insertLen != removeLen) {
/* 1603 */       ensureCapacity(newSize);
/* 1604 */       System.arraycopy(this.buffer, endIndex, this.buffer, startIndex + insertLen, this.size - endIndex);
/* 1605 */       this.size = newSize;
/*      */     } 
/* 1607 */     if (insertLen > 0) {
/* 1608 */       insertStr.getChars(0, insertLen, this.buffer, startIndex);
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
/*      */   public StrBuilder replace(int startIndex, int endIndex, String replaceStr) {
/* 1624 */     endIndex = validateRange(startIndex, endIndex);
/* 1625 */     int insertLen = (replaceStr == null) ? 0 : replaceStr.length();
/* 1626 */     replaceImpl(startIndex, endIndex, endIndex - startIndex, replaceStr, insertLen);
/* 1627 */     return this;
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
/*      */   public StrBuilder replaceAll(char search, char replace) {
/* 1640 */     if (search != replace) {
/* 1641 */       for (int i = 0; i < this.size; i++) {
/* 1642 */         if (this.buffer[i] == search) {
/* 1643 */           this.buffer[i] = replace;
/*      */         }
/*      */       } 
/*      */     }
/* 1647 */     return this;
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
/*      */   public StrBuilder replaceFirst(char search, char replace) {
/* 1659 */     if (search != replace) {
/* 1660 */       for (int i = 0; i < this.size; i++) {
/* 1661 */         if (this.buffer[i] == search) {
/* 1662 */           this.buffer[i] = replace;
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/* 1667 */     return this;
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
/*      */   public StrBuilder replaceAll(String searchStr, String replaceStr) {
/* 1679 */     int searchLen = (searchStr == null) ? 0 : searchStr.length();
/* 1680 */     if (searchLen > 0) {
/* 1681 */       int replaceLen = (replaceStr == null) ? 0 : replaceStr.length();
/* 1682 */       int index = indexOf(searchStr, 0);
/* 1683 */       while (index >= 0) {
/* 1684 */         replaceImpl(index, index + searchLen, searchLen, replaceStr, replaceLen);
/* 1685 */         index = indexOf(searchStr, index + replaceLen);
/*      */       } 
/*      */     } 
/* 1688 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replaceFirst(String searchStr, String replaceStr) {
/* 1699 */     int searchLen = (searchStr == null) ? 0 : searchStr.length();
/* 1700 */     if (searchLen > 0) {
/* 1701 */       int index = indexOf(searchStr, 0);
/* 1702 */       if (index >= 0) {
/* 1703 */         int replaceLen = (replaceStr == null) ? 0 : replaceStr.length();
/* 1704 */         replaceImpl(index, index + searchLen, searchLen, replaceStr, replaceLen);
/*      */       } 
/*      */     } 
/* 1707 */     return this;
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
/*      */   public StrBuilder replaceAll(StrMatcher matcher, String replaceStr) {
/* 1723 */     return replace(matcher, replaceStr, 0, this.size, -1);
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
/*      */   public StrBuilder replaceFirst(StrMatcher matcher, String replaceStr) {
/* 1738 */     return replace(matcher, replaceStr, 0, this.size, 1);
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
/*      */   public StrBuilder replace(StrMatcher matcher, String replaceStr, int startIndex, int endIndex, int replaceCount) {
/* 1761 */     endIndex = validateRange(startIndex, endIndex);
/* 1762 */     return replaceImpl(matcher, replaceStr, startIndex, endIndex, replaceCount);
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
/*      */   private StrBuilder replaceImpl(StrMatcher matcher, String replaceStr, int from, int to, int replaceCount) {
/* 1783 */     if (matcher == null || this.size == 0) {
/* 1784 */       return this;
/*      */     }
/* 1786 */     int replaceLen = (replaceStr == null) ? 0 : replaceStr.length();
/* 1787 */     char[] buf = this.buffer;
/* 1788 */     for (int i = from; i < to && replaceCount != 0; i++) {
/* 1789 */       int removeLen = matcher.isMatch(buf, i, from, to);
/* 1790 */       if (removeLen > 0) {
/* 1791 */         replaceImpl(i, i + removeLen, removeLen, replaceStr, replaceLen);
/* 1792 */         to = to - removeLen + replaceLen;
/* 1793 */         i = i + replaceLen - 1;
/* 1794 */         if (replaceCount > 0) {
/* 1795 */           replaceCount--;
/*      */         }
/*      */       } 
/*      */     } 
/* 1799 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder reverse() {
/* 1809 */     if (this.size == 0) {
/* 1810 */       return this;
/*      */     }
/*      */     
/* 1813 */     int half = this.size / 2;
/* 1814 */     char[] buf = this.buffer;
/* 1815 */     for (int leftIdx = 0, rightIdx = this.size - 1; leftIdx < half; leftIdx++, rightIdx--) {
/* 1816 */       char swap = buf[leftIdx];
/* 1817 */       buf[leftIdx] = buf[rightIdx];
/* 1818 */       buf[rightIdx] = swap;
/*      */     } 
/* 1820 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder trim() {
/* 1831 */     if (this.size == 0) {
/* 1832 */       return this;
/*      */     }
/* 1834 */     int len = this.size;
/* 1835 */     char[] buf = this.buffer;
/* 1836 */     int pos = 0;
/* 1837 */     while (pos < len && buf[pos] <= ' ') {
/* 1838 */       pos++;
/*      */     }
/* 1840 */     while (pos < len && buf[len - 1] <= ' ') {
/* 1841 */       len--;
/*      */     }
/* 1843 */     if (len < this.size) {
/* 1844 */       delete(len, this.size);
/*      */     }
/* 1846 */     if (pos > 0) {
/* 1847 */       delete(0, pos);
/*      */     }
/* 1849 */     return this;
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
/*      */   public boolean startsWith(String str) {
/* 1862 */     if (str == null) {
/* 1863 */       return false;
/*      */     }
/* 1865 */     int len = str.length();
/* 1866 */     if (len == 0) {
/* 1867 */       return true;
/*      */     }
/* 1869 */     if (len > this.size) {
/* 1870 */       return false;
/*      */     }
/* 1872 */     for (int i = 0; i < len; i++) {
/* 1873 */       if (this.buffer[i] != str.charAt(i)) {
/* 1874 */         return false;
/*      */       }
/*      */     } 
/* 1877 */     return true;
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
/*      */   public boolean endsWith(String str) {
/* 1889 */     if (str == null) {
/* 1890 */       return false;
/*      */     }
/* 1892 */     int len = str.length();
/* 1893 */     if (len == 0) {
/* 1894 */       return true;
/*      */     }
/* 1896 */     if (len > this.size) {
/* 1897 */       return false;
/*      */     }
/* 1899 */     int pos = this.size - len;
/* 1900 */     for (int i = 0; i < len; i++, pos++) {
/* 1901 */       if (this.buffer[pos] != str.charAt(i)) {
/* 1902 */         return false;
/*      */       }
/*      */     } 
/* 1905 */     return true;
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
/*      */   public String substring(int start) {
/* 1917 */     return substring(start, this.size);
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
/*      */   public String substring(int startIndex, int endIndex) {
/* 1934 */     endIndex = validateRange(startIndex, endIndex);
/* 1935 */     return new String(this.buffer, startIndex, endIndex - startIndex);
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
/*      */   public String leftString(int length) {
/* 1951 */     if (length <= 0)
/* 1952 */       return ""; 
/* 1953 */     if (length >= this.size) {
/* 1954 */       return new String(this.buffer, 0, this.size);
/*      */     }
/* 1956 */     return new String(this.buffer, 0, length);
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
/*      */   public String rightString(int length) {
/* 1973 */     if (length <= 0)
/* 1974 */       return ""; 
/* 1975 */     if (length >= this.size) {
/* 1976 */       return new String(this.buffer, 0, this.size);
/*      */     }
/* 1978 */     return new String(this.buffer, this.size - length, length);
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
/*      */   public String midString(int index, int length) {
/* 1999 */     if (index < 0) {
/* 2000 */       index = 0;
/*      */     }
/* 2002 */     if (length <= 0 || index >= this.size) {
/* 2003 */       return "";
/*      */     }
/* 2005 */     if (this.size <= index + length) {
/* 2006 */       return new String(this.buffer, index, this.size - index);
/*      */     }
/* 2008 */     return new String(this.buffer, index, length);
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
/*      */   public boolean contains(char ch) {
/* 2020 */     char[] thisBuf = this.buffer;
/* 2021 */     for (int i = 0; i < this.size; i++) {
/* 2022 */       if (thisBuf[i] == ch) {
/* 2023 */         return true;
/*      */       }
/*      */     } 
/* 2026 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(String str) {
/* 2036 */     return (indexOf(str, 0) >= 0);
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
/*      */   public boolean contains(StrMatcher matcher) {
/* 2051 */     return (indexOf(matcher, 0) >= 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(char ch) {
/* 2062 */     return indexOf(ch, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(char ch, int startIndex) {
/* 2073 */     startIndex = (startIndex < 0) ? 0 : startIndex;
/* 2074 */     if (startIndex >= this.size) {
/* 2075 */       return -1;
/*      */     }
/* 2077 */     char[] thisBuf = this.buffer;
/* 2078 */     for (int i = startIndex; i < this.size; i++) {
/* 2079 */       if (thisBuf[i] == ch) {
/* 2080 */         return i;
/*      */       }
/*      */     } 
/* 2083 */     return -1;
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
/*      */   public int indexOf(String str) {
/* 2095 */     return indexOf(str, 0);
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
/*      */   public int indexOf(String str, int startIndex) {
/* 2109 */     startIndex = (startIndex < 0) ? 0 : startIndex;
/* 2110 */     if (str == null || startIndex >= this.size) {
/* 2111 */       return -1;
/*      */     }
/* 2113 */     int strLen = str.length();
/* 2114 */     if (strLen == 1) {
/* 2115 */       return indexOf(str.charAt(0), startIndex);
/*      */     }
/* 2117 */     if (strLen == 0) {
/* 2118 */       return startIndex;
/*      */     }
/* 2120 */     if (strLen > this.size) {
/* 2121 */       return -1;
/*      */     }
/* 2123 */     char[] thisBuf = this.buffer;
/* 2124 */     int len = this.size - strLen + 1;
/*      */     
/* 2126 */     for (int i = startIndex; i < len; i++) {
/* 2127 */       int j = 0; while (true) { if (j >= strLen)
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 2132 */           return i; }  if (str.charAt(j) != thisBuf[i + j])
/*      */           break;  j++; } 
/* 2134 */     }  return -1;
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
/*      */   public int indexOf(StrMatcher matcher) {
/* 2148 */     return indexOf(matcher, 0);
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
/*      */   public int indexOf(StrMatcher matcher, int startIndex) {
/* 2164 */     startIndex = (startIndex < 0) ? 0 : startIndex;
/* 2165 */     if (matcher == null || startIndex >= this.size) {
/* 2166 */       return -1;
/*      */     }
/* 2168 */     int len = this.size;
/* 2169 */     char[] buf = this.buffer;
/* 2170 */     for (int i = startIndex; i < len; i++) {
/* 2171 */       if (matcher.isMatch(buf, i, startIndex, len) > 0) {
/* 2172 */         return i;
/*      */       }
/*      */     } 
/* 2175 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(char ch) {
/* 2186 */     return lastIndexOf(ch, this.size - 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(char ch, int startIndex) {
/* 2197 */     startIndex = (startIndex >= this.size) ? (this.size - 1) : startIndex;
/* 2198 */     if (startIndex < 0) {
/* 2199 */       return -1;
/*      */     }
/* 2201 */     for (int i = startIndex; i >= 0; i--) {
/* 2202 */       if (this.buffer[i] == ch) {
/* 2203 */         return i;
/*      */       }
/*      */     } 
/* 2206 */     return -1;
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
/*      */   public int lastIndexOf(String str) {
/* 2218 */     return lastIndexOf(str, this.size - 1);
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
/*      */   public int lastIndexOf(String str, int startIndex) {
/* 2232 */     startIndex = (startIndex >= this.size) ? (this.size - 1) : startIndex;
/* 2233 */     if (str == null || startIndex < 0) {
/* 2234 */       return -1;
/*      */     }
/* 2236 */     int strLen = str.length();
/* 2237 */     if (strLen > 0 && strLen <= this.size) {
/* 2238 */       if (strLen == 1) {
/* 2239 */         return lastIndexOf(str.charAt(0), startIndex);
/*      */       }
/*      */ 
/*      */       
/* 2243 */       for (int i = startIndex - strLen + 1; i >= 0; i--) {
/* 2244 */         int j = 0; while (true) { if (j >= strLen)
/*      */           {
/*      */ 
/*      */ 
/*      */             
/* 2249 */             return i; }  if (str.charAt(j) != this.buffer[i + j])
/*      */             break;  j++; } 
/*      */       } 
/* 2252 */     } else if (strLen == 0) {
/* 2253 */       return startIndex;
/*      */     } 
/* 2255 */     return -1;
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
/*      */   public int lastIndexOf(StrMatcher matcher) {
/* 2269 */     return lastIndexOf(matcher, this.size);
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
/*      */   public int lastIndexOf(StrMatcher matcher, int startIndex) {
/* 2285 */     startIndex = (startIndex >= this.size) ? (this.size - 1) : startIndex;
/* 2286 */     if (matcher == null || startIndex < 0) {
/* 2287 */       return -1;
/*      */     }
/* 2289 */     char[] buf = this.buffer;
/* 2290 */     int endIndex = startIndex + 1;
/* 2291 */     for (int i = startIndex; i >= 0; i--) {
/* 2292 */       if (matcher.isMatch(buf, i, 0, endIndex) > 0) {
/* 2293 */         return i;
/*      */       }
/*      */     } 
/* 2296 */     return -1;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer asTokenizer() {
/* 2333 */     return new StrBuilderTokenizer(this);
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
/*      */   public Reader asReader() {
/* 2357 */     return new StrBuilderReader(this);
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
/*      */   public Writer asWriter() {
/* 2382 */     return new StrBuilderWriter(this);
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
/*      */   public boolean equalsIgnoreCase(StrBuilder other) {
/* 2424 */     if (this == other) {
/* 2425 */       return true;
/*      */     }
/* 2427 */     if (this.size != other.size) {
/* 2428 */       return false;
/*      */     }
/* 2430 */     char[] thisBuf = this.buffer;
/* 2431 */     char[] otherBuf = other.buffer;
/* 2432 */     for (int i = this.size - 1; i >= 0; i--) {
/* 2433 */       char c1 = thisBuf[i];
/* 2434 */       char c2 = otherBuf[i];
/* 2435 */       if (c1 != c2 && Character.toUpperCase(c1) != Character.toUpperCase(c2)) {
/* 2436 */         return false;
/*      */       }
/*      */     } 
/* 2439 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(StrBuilder other) {
/* 2450 */     if (this == other) {
/* 2451 */       return true;
/*      */     }
/* 2453 */     if (this.size != other.size) {
/* 2454 */       return false;
/*      */     }
/* 2456 */     char[] thisBuf = this.buffer;
/* 2457 */     char[] otherBuf = other.buffer;
/* 2458 */     for (int i = this.size - 1; i >= 0; i--) {
/* 2459 */       if (thisBuf[i] != otherBuf[i]) {
/* 2460 */         return false;
/*      */       }
/*      */     } 
/* 2463 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object obj) {
/* 2474 */     if (obj instanceof StrBuilder) {
/* 2475 */       return equals((StrBuilder)obj);
/*      */     }
/* 2477 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 2486 */     char[] buf = this.buffer;
/* 2487 */     int hash = 0;
/* 2488 */     for (int i = this.size - 1; i >= 0; i--) {
/* 2489 */       hash = 31 * hash + buf[i];
/*      */     }
/* 2491 */     return hash;
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
/*      */   public String toString() {
/* 2505 */     return new String(this.buffer, 0, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer toStringBuffer() {
/* 2515 */     return (new StringBuffer(this.size)).append(this.buffer, 0, this.size);
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
/*      */   protected int validateRange(int startIndex, int endIndex) {
/* 2529 */     if (startIndex < 0) {
/* 2530 */       throw new StringIndexOutOfBoundsException(startIndex);
/*      */     }
/* 2532 */     if (endIndex > this.size) {
/* 2533 */       endIndex = this.size;
/*      */     }
/* 2535 */     if (startIndex > endIndex) {
/* 2536 */       throw new StringIndexOutOfBoundsException("end < start");
/*      */     }
/* 2538 */     return endIndex;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void validateIndex(int index) {
/* 2548 */     if (index < 0 || index > this.size) {
/* 2549 */       throw new StringIndexOutOfBoundsException(index);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   class StrBuilderTokenizer
/*      */     extends StrTokenizer
/*      */   {
/*      */     private final StrBuilder this$0;
/*      */     
/*      */     StrBuilderTokenizer(StrBuilder this$0) {
/* 2560 */       this.this$0 = this$0;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected List tokenize(char[] chars, int offset, int count) {
/* 2566 */       if (chars == null) {
/* 2567 */         return super.tokenize(this.this$0.buffer, 0, this.this$0.size());
/*      */       }
/* 2569 */       return super.tokenize(chars, offset, count);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String getContent() {
/* 2575 */       String str = super.getContent();
/* 2576 */       if (str == null) {
/* 2577 */         return this.this$0.toString();
/*      */       }
/* 2579 */       return str;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   class StrBuilderReader
/*      */     extends Reader
/*      */   {
/*      */     private int pos;
/*      */     
/*      */     private int mark;
/*      */     
/*      */     private final StrBuilder this$0;
/*      */ 
/*      */     
/*      */     StrBuilderReader(StrBuilder this$0) {
/* 2595 */       this.this$0 = this$0;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {}
/*      */ 
/*      */ 
/*      */     
/*      */     public int read() {
/* 2606 */       if (!ready()) {
/* 2607 */         return -1;
/*      */       }
/* 2609 */       return this.this$0.charAt(this.pos++);
/*      */     }
/*      */ 
/*      */     
/*      */     public int read(char[] b, int off, int len) {
/* 2614 */       if (off < 0 || len < 0 || off > b.length || off + len > b.length || off + len < 0)
/*      */       {
/* 2616 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 2618 */       if (len == 0) {
/* 2619 */         return 0;
/*      */       }
/* 2621 */       if (this.pos >= this.this$0.size()) {
/* 2622 */         return -1;
/*      */       }
/* 2624 */       if (this.pos + len > this.this$0.size()) {
/* 2625 */         len = this.this$0.size() - this.pos;
/*      */       }
/* 2627 */       this.this$0.getChars(this.pos, this.pos + len, b, off);
/* 2628 */       this.pos += len;
/* 2629 */       return len;
/*      */     }
/*      */ 
/*      */     
/*      */     public long skip(long n) {
/* 2634 */       if (this.pos + n > this.this$0.size()) {
/* 2635 */         n = (this.this$0.size() - this.pos);
/*      */       }
/* 2637 */       if (n < 0L) {
/* 2638 */         return 0L;
/*      */       }
/* 2640 */       this.pos = (int)(this.pos + n);
/* 2641 */       return n;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean ready() {
/* 2646 */       return (this.pos < this.this$0.size());
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean markSupported() {
/* 2651 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public void mark(int readAheadLimit) {
/* 2656 */       this.mark = this.pos;
/*      */     }
/*      */ 
/*      */     
/*      */     public void reset() {
/* 2661 */       this.pos = this.mark;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   class StrBuilderWriter
/*      */     extends Writer
/*      */   {
/*      */     private final StrBuilder this$0;
/*      */     
/*      */     StrBuilderWriter(StrBuilder this$0) {
/* 2672 */       this.this$0 = this$0;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void flush() {}
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(int c) {
/* 2688 */       this.this$0.append((char)c);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(char[] cbuf) {
/* 2693 */       this.this$0.append(cbuf);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(char[] cbuf, int off, int len) {
/* 2698 */       this.this$0.append(cbuf, off, len);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(String str) {
/* 2703 */       this.this$0.append(str);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(String str, int off, int len) {
/* 2708 */       this.this$0.append(str, off, len);
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\text\StrBuilder.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */