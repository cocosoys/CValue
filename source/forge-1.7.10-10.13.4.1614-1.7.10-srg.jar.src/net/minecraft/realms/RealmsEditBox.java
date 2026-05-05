/*     */ package net.minecraft.realms;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.ChatAllowedCharacters;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RealmsEditBox
/*     */ {
/*     */   public static final int BACKWARDS = -1;
/*     */   public static final int FORWARDS = 1;
/*     */   private static final int CURSOR_INSERT_WIDTH = 1;
/*     */   private static final int CURSOR_INSERT_COLOR = -3092272;
/*     */   private static final String CURSOR_APPEND_CHARACTER = "_";
/*     */   private final FontRenderer font;
/*     */   private final int x;
/*     */   private final int y;
/*     */   private final int width;
/*     */   private final int height;
/*  26 */   private String value = "";
/*  27 */   private int maxLength = 32;
/*     */   private int frame;
/*     */   private boolean bordered = true;
/*     */   private boolean canLoseFocus = true;
/*     */   private boolean inFocus;
/*     */   private boolean isEditable = true;
/*     */   private int displayPos;
/*     */   private int cursorPos;
/*     */   private int highlightPos;
/*  36 */   private int textColor = 14737632;
/*  37 */   private int textColorUneditable = 7368816;
/*     */   private boolean visible = true;
/*     */   
/*     */   public RealmsEditBox(int p_i1111_1_, int p_i1111_2_, int p_i1111_3_, int p_i1111_4_) {
/*  41 */     this((Minecraft.func_71410_x()).field_71466_p, p_i1111_1_, p_i1111_2_, p_i1111_3_, p_i1111_4_);
/*     */   }
/*     */   private static final String __OBFID = "CL_00001858";
/*     */   public RealmsEditBox(FontRenderer p_i1112_1_, int p_i1112_2_, int p_i1112_3_, int p_i1112_4_, int p_i1112_5_) {
/*  45 */     this.font = p_i1112_1_;
/*  46 */     this.x = p_i1112_2_;
/*  47 */     this.y = p_i1112_3_;
/*  48 */     this.width = p_i1112_4_;
/*  49 */     this.height = p_i1112_5_;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  53 */     this.frame++;
/*     */   }
/*     */   
/*     */   public void setValue(String p_setValue_1_) {
/*  57 */     if (p_setValue_1_.length() > this.maxLength) {
/*  58 */       this.value = p_setValue_1_.substring(0, this.maxLength);
/*     */     } else {
/*  60 */       this.value = p_setValue_1_;
/*     */     } 
/*     */     
/*  63 */     moveCursorToEnd();
/*     */   }
/*     */   
/*     */   public String getValue() {
/*  67 */     return this.value;
/*     */   }
/*     */   
/*     */   public String getHighlighted() {
/*  71 */     int i = (this.cursorPos < this.highlightPos) ? this.cursorPos : this.highlightPos;
/*  72 */     int j = (this.cursorPos < this.highlightPos) ? this.highlightPos : this.cursorPos;
/*     */     
/*  74 */     return this.value.substring(i, j);
/*     */   }
/*     */   
/*     */   public void insertText(String p_insertText_1_) {
/*  78 */     String str1 = "";
/*  79 */     String str2 = ChatAllowedCharacters.func_71565_a(p_insertText_1_);
/*  80 */     int i = (this.cursorPos < this.highlightPos) ? this.cursorPos : this.highlightPos;
/*  81 */     int j = (this.cursorPos < this.highlightPos) ? this.highlightPos : this.cursorPos;
/*  82 */     int k = this.maxLength - this.value.length() - i - this.highlightPos;
/*  83 */     int m = 0;
/*     */     
/*  85 */     if (this.value.length() > 0) str1 = str1 + this.value.substring(0, i);
/*     */     
/*  87 */     if (k < str2.length()) {
/*  88 */       str1 = str1 + str2.substring(0, k);
/*  89 */       m = k;
/*     */     } else {
/*  91 */       str1 = str1 + str2;
/*  92 */       m = str2.length();
/*     */     } 
/*     */     
/*  95 */     if (this.value.length() > 0 && j < this.value.length()) str1 = str1 + this.value.substring(j);
/*     */     
/*  97 */     this.value = str1;
/*  98 */     moveCursor(i - this.highlightPos + m);
/*     */   }
/*     */   
/*     */   public void deleteWords(int p_deleteWords_1_) {
/* 102 */     if (this.value.length() == 0)
/*     */       return; 
/* 104 */     if (this.highlightPos != this.cursorPos) {
/* 105 */       insertText("");
/*     */       
/*     */       return;
/*     */     } 
/* 109 */     deleteChars(getWordPosition(p_deleteWords_1_) - this.cursorPos);
/*     */   }
/*     */   
/*     */   public void deleteChars(int p_deleteChars_1_) {
/* 113 */     if (this.value.length() == 0)
/*     */       return; 
/* 115 */     if (this.highlightPos != this.cursorPos) {
/* 116 */       insertText("");
/*     */       
/*     */       return;
/*     */     } 
/* 120 */     boolean bool = (p_deleteChars_1_ < 0) ? true : false;
/* 121 */     int i = bool ? (this.cursorPos + p_deleteChars_1_) : this.cursorPos;
/* 122 */     int j = bool ? this.cursorPos : (this.cursorPos + p_deleteChars_1_);
/* 123 */     String str = "";
/*     */     
/* 125 */     if (i >= 0) str = this.value.substring(0, i);
/*     */     
/* 127 */     if (j < this.value.length()) str = str + this.value.substring(j);
/*     */     
/* 129 */     this.value = str;
/* 130 */     if (bool) moveCursor(p_deleteChars_1_); 
/*     */   }
/*     */   
/*     */   public int getWordPosition(int p_getWordPosition_1_) {
/* 134 */     return getWordPosition(p_getWordPosition_1_, getCursorPosition());
/*     */   }
/*     */   
/*     */   public int getWordPosition(int p_getWordPosition_1_, int p_getWordPosition_2_) {
/* 138 */     return getWordPosition(p_getWordPosition_1_, getCursorPosition(), true);
/*     */   }
/*     */   
/*     */   public int getWordPosition(int p_getWordPosition_1_, int p_getWordPosition_2_, boolean p_getWordPosition_3_) {
/* 142 */     int i = p_getWordPosition_2_;
/* 143 */     boolean bool = (p_getWordPosition_1_ < 0) ? true : false;
/* 144 */     int j = Math.abs(p_getWordPosition_1_);
/*     */     
/* 146 */     for (byte b = 0; b < j; b++) {
/* 147 */       if (bool) {
/* 148 */         while (p_getWordPosition_3_ && i > 0 && this.value.charAt(i - 1) == ' ')
/* 149 */           i--; 
/* 150 */         while (i > 0 && this.value.charAt(i - 1) != ' ')
/* 151 */           i--; 
/*     */       } else {
/* 153 */         int k = this.value.length();
/*     */         
/* 155 */         i = this.value.indexOf(' ', i);
/* 156 */         if (i == -1) {
/* 157 */           i = k;
/*     */         } else {
/* 159 */           while (p_getWordPosition_3_ && i < k && this.value.charAt(i) == ' ') {
/* 160 */             i++;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 165 */     return i;
/*     */   }
/*     */   
/*     */   public void moveCursor(int p_moveCursor_1_) {
/* 169 */     moveCursorTo(this.highlightPos + p_moveCursor_1_);
/*     */   }
/*     */   
/*     */   public void moveCursorTo(int p_moveCursorTo_1_) {
/* 173 */     this.cursorPos = p_moveCursorTo_1_;
/*     */     
/* 175 */     int i = this.value.length();
/* 176 */     if (this.cursorPos < 0) this.cursorPos = 0; 
/* 177 */     if (this.cursorPos > i) this.cursorPos = i;
/*     */     
/* 179 */     setHighlightPos(this.cursorPos);
/*     */   }
/*     */   
/*     */   public void moveCursorToStart() {
/* 183 */     moveCursorTo(0);
/*     */   }
/*     */   
/*     */   public void moveCursorToEnd() {
/* 187 */     moveCursorTo(this.value.length());
/*     */   }
/*     */   
/*     */   public boolean keyPressed(char p_keyPressed_1_, int p_keyPressed_2_) {
/* 191 */     if (!this.inFocus) {
/* 192 */       return false;
/*     */     }
/*     */     
/* 195 */     switch (p_keyPressed_1_) {
/*     */       case '\001':
/* 197 */         moveCursorToEnd();
/* 198 */         setHighlightPos(0);
/* 199 */         return true;
/*     */       case '\003':
/* 201 */         GuiScreen.func_146275_d(getHighlighted());
/* 202 */         return true;
/*     */       case '\026':
/* 204 */         if (this.isEditable) insertText(GuiScreen.func_146277_j()); 
/* 205 */         return true;
/*     */       case '\030':
/* 207 */         GuiScreen.func_146275_d(getHighlighted());
/* 208 */         if (this.isEditable) insertText(""); 
/* 209 */         return true;
/*     */     } 
/*     */     
/* 212 */     switch (p_keyPressed_2_) {
/*     */       case 203:
/* 214 */         if (GuiScreen.func_146272_n()) {
/* 215 */           if (GuiScreen.func_146271_m()) {
/* 216 */             setHighlightPos(getWordPosition(-1, getHighlightPos()));
/*     */           } else {
/* 218 */             setHighlightPos(getHighlightPos() - 1);
/*     */           }
/*     */         
/* 221 */         } else if (GuiScreen.func_146271_m()) {
/* 222 */           moveCursorTo(getWordPosition(-1));
/*     */         } else {
/* 224 */           moveCursor(-1);
/*     */         } 
/*     */ 
/*     */         
/* 228 */         return true;
/*     */       case 205:
/* 230 */         if (GuiScreen.func_146272_n()) {
/* 231 */           if (GuiScreen.func_146271_m()) {
/* 232 */             setHighlightPos(getWordPosition(1, getHighlightPos()));
/*     */           } else {
/* 234 */             setHighlightPos(getHighlightPos() + 1);
/*     */           }
/*     */         
/* 237 */         } else if (GuiScreen.func_146271_m()) {
/* 238 */           moveCursorTo(getWordPosition(1));
/*     */         } else {
/* 240 */           moveCursor(1);
/*     */         } 
/*     */ 
/*     */         
/* 244 */         return true;
/*     */       case 14:
/* 246 */         if (GuiScreen.func_146271_m())
/* 247 */         { if (this.isEditable) deleteWords(-1);
/*     */            }
/* 249 */         else if (this.isEditable) { deleteChars(-1); }
/*     */ 
/*     */         
/* 252 */         return true;
/*     */       
/*     */       case 211:
/* 255 */         if (GuiScreen.func_146271_m())
/* 256 */         { if (this.isEditable) deleteWords(1);
/*     */            }
/* 258 */         else if (this.isEditable) { deleteChars(1); }
/*     */ 
/*     */         
/* 261 */         return true;
/*     */       
/*     */       case 199:
/* 264 */         if (GuiScreen.func_146272_n()) {
/* 265 */           setHighlightPos(0);
/*     */         } else {
/* 267 */           moveCursorToStart();
/*     */         } 
/*     */         
/* 270 */         return true;
/*     */       
/*     */       case 207:
/* 273 */         if (GuiScreen.func_146272_n()) {
/* 274 */           setHighlightPos(this.value.length());
/*     */         } else {
/* 276 */           moveCursorToEnd();
/*     */         } 
/*     */         
/* 279 */         return true;
/*     */     } 
/*     */     
/* 282 */     if (ChatAllowedCharacters.func_71566_a(p_keyPressed_1_)) {
/* 283 */       if (this.isEditable) insertText(Character.toString(p_keyPressed_1_));
/*     */       
/* 285 */       return true;
/*     */     } 
/*     */     
/* 288 */     return false;
/*     */   }
/*     */   
/*     */   public void mouseClicked(int p_mouseClicked_1_, int p_mouseClicked_2_, int p_mouseClicked_3_) {
/* 292 */     boolean bool = (p_mouseClicked_1_ >= this.x && p_mouseClicked_1_ < this.x + this.width && p_mouseClicked_2_ >= this.y && p_mouseClicked_2_ < this.y + this.height) ? true : false;
/*     */     
/* 294 */     if (this.canLoseFocus) {
/* 295 */       setFocus(bool);
/*     */     }
/*     */     
/* 298 */     if (this.inFocus && p_mouseClicked_3_ == 0) {
/* 299 */       int i = p_mouseClicked_1_ - this.x;
/*     */       
/* 301 */       if (this.bordered) {
/* 302 */         i -= 4;
/*     */       }
/*     */       
/* 305 */       String str = this.font.func_78269_a(this.value.substring(this.displayPos), getInnerWidth());
/* 306 */       moveCursorTo(this.font.func_78269_a(str, i).length() + this.displayPos);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render() {
/* 311 */     if (!isVisible())
/*     */       return; 
/* 313 */     if (isBordered()) {
/* 314 */       Gui.func_73734_a(this.x - 1, this.y - 1, this.x + this.width + 1, this.y + this.height + 1, -6250336);
/* 315 */       Gui.func_73734_a(this.x, this.y, this.x + this.width, this.y + this.height, -16777216);
/*     */     } 
/*     */     
/* 318 */     int i = this.isEditable ? this.textColor : this.textColorUneditable;
/* 319 */     int j = this.cursorPos - this.displayPos;
/* 320 */     int k = this.highlightPos - this.displayPos;
/* 321 */     String str = this.font.func_78269_a(this.value.substring(this.displayPos), getInnerWidth());
/* 322 */     boolean bool1 = (j >= 0 && j <= str.length()) ? true : false;
/* 323 */     boolean bool2 = (this.inFocus && this.frame / 6 % 2 == 0 && bool1) ? true : false;
/* 324 */     int m = this.bordered ? (this.x + 4) : this.x;
/* 325 */     int n = this.bordered ? (this.y + (this.height - 8) / 2) : this.y;
/* 326 */     int i1 = m;
/*     */     
/* 328 */     if (k > str.length()) k = str.length();
/*     */     
/* 330 */     if (str.length() > 0) {
/* 331 */       String str1 = bool1 ? str.substring(0, j) : str;
/* 332 */       i1 = this.font.func_78261_a(str1, i1, n, i);
/*     */     } 
/*     */     
/* 335 */     boolean bool3 = (this.cursorPos < this.value.length() || this.value.length() >= getMaxLength()) ? true : false;
/* 336 */     int i2 = i1;
/*     */     
/* 338 */     if (!bool1) {
/* 339 */       i2 = (j > 0) ? (m + this.width) : m;
/* 340 */     } else if (bool3) {
/* 341 */       i2--;
/* 342 */       i1--;
/*     */     } 
/*     */     
/* 345 */     if (str.length() > 0 && bool1 && j < str.length()) {
/* 346 */       i1 = this.font.func_78261_a(str.substring(j), i1, n, i);
/*     */     }
/*     */     
/* 349 */     if (bool2) {
/* 350 */       if (bool3) {
/* 351 */         Gui.func_73734_a(i2, n - 1, i2 + 1, n + 1 + this.font.field_78288_b, -3092272);
/*     */       } else {
/* 353 */         this.font.func_78261_a("_", i2, n, i);
/*     */       } 
/*     */     }
/*     */     
/* 357 */     if (k != j) {
/* 358 */       int i3 = m + this.font.func_78256_a(str.substring(0, k));
/* 359 */       renderHighlight(i2, n - 1, i3 - 1, n + 1 + this.font.field_78288_b);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderHighlight(int p_renderHighlight_1_, int p_renderHighlight_2_, int p_renderHighlight_3_, int p_renderHighlight_4_) {
/* 364 */     if (p_renderHighlight_1_ < p_renderHighlight_3_) {
/* 365 */       int i = p_renderHighlight_1_;
/* 366 */       p_renderHighlight_1_ = p_renderHighlight_3_;
/* 367 */       p_renderHighlight_3_ = i;
/*     */     } 
/* 369 */     if (p_renderHighlight_2_ < p_renderHighlight_4_) {
/* 370 */       int i = p_renderHighlight_2_;
/* 371 */       p_renderHighlight_2_ = p_renderHighlight_4_;
/* 372 */       p_renderHighlight_4_ = i;
/*     */     } 
/*     */     
/* 375 */     if (p_renderHighlight_3_ > this.x + this.width) p_renderHighlight_3_ = this.x + this.width; 
/* 376 */     if (p_renderHighlight_1_ > this.x + this.width) p_renderHighlight_1_ = this.x + this.width;
/*     */     
/* 378 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 380 */     GL11.glColor4f(0.0F, 0.0F, 255.0F, 255.0F);
/* 381 */     GL11.glDisable(3553);
/* 382 */     GL11.glEnable(3058);
/* 383 */     GL11.glLogicOp(5387);
/*     */     
/* 385 */     tessellator.func_78382_b();
/* 386 */     tessellator.func_78377_a(p_renderHighlight_1_, p_renderHighlight_4_, 0.0D);
/* 387 */     tessellator.func_78377_a(p_renderHighlight_3_, p_renderHighlight_4_, 0.0D);
/* 388 */     tessellator.func_78377_a(p_renderHighlight_3_, p_renderHighlight_2_, 0.0D);
/* 389 */     tessellator.func_78377_a(p_renderHighlight_1_, p_renderHighlight_2_, 0.0D);
/* 390 */     tessellator.func_78381_a();
/*     */     
/* 392 */     GL11.glDisable(3058);
/* 393 */     GL11.glEnable(3553);
/*     */   }
/*     */   
/*     */   public void setMaxLength(int p_setMaxLength_1_) {
/* 397 */     this.maxLength = p_setMaxLength_1_;
/*     */     
/* 399 */     if (this.value.length() > p_setMaxLength_1_) {
/* 400 */       this.value = this.value.substring(0, p_setMaxLength_1_);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getMaxLength() {
/* 405 */     return this.maxLength;
/*     */   }
/*     */   
/*     */   public int getCursorPosition() {
/* 409 */     return this.cursorPos;
/*     */   }
/*     */   
/*     */   public boolean isBordered() {
/* 413 */     return this.bordered;
/*     */   }
/*     */   
/*     */   public void setBordered(boolean p_setBordered_1_) {
/* 417 */     this.bordered = p_setBordered_1_;
/*     */   }
/*     */   
/*     */   public int getTextColor() {
/* 421 */     return this.textColor;
/*     */   }
/*     */   
/*     */   public void setTextColor(int p_setTextColor_1_) {
/* 425 */     this.textColor = p_setTextColor_1_;
/*     */   }
/*     */   
/*     */   public int getTextColorUneditable() {
/* 429 */     return this.textColorUneditable;
/*     */   }
/*     */   
/*     */   public void setTextColorUneditable(int p_setTextColorUneditable_1_) {
/* 433 */     this.textColorUneditable = p_setTextColorUneditable_1_;
/*     */   }
/*     */   
/*     */   public void setFocus(boolean p_setFocus_1_) {
/* 437 */     if (p_setFocus_1_ && !this.inFocus)
/*     */     {
/* 439 */       this.frame = 0;
/*     */     }
/* 441 */     this.inFocus = p_setFocus_1_;
/*     */   }
/*     */   
/*     */   public boolean isFocused() {
/* 445 */     return this.inFocus;
/*     */   }
/*     */   
/*     */   public boolean isIsEditable() {
/* 449 */     return this.isEditable;
/*     */   }
/*     */   
/*     */   public void setIsEditable(boolean p_setIsEditable_1_) {
/* 453 */     this.isEditable = p_setIsEditable_1_;
/*     */   }
/*     */   
/*     */   public int getHighlightPos() {
/* 457 */     return this.highlightPos;
/*     */   }
/*     */   
/*     */   public int getInnerWidth() {
/* 461 */     return isBordered() ? (this.width - 8) : this.width;
/*     */   }
/*     */   
/*     */   public void setHighlightPos(int p_setHighlightPos_1_) {
/* 465 */     int i = this.value.length();
/*     */     
/* 467 */     if (p_setHighlightPos_1_ > i) p_setHighlightPos_1_ = i; 
/* 468 */     if (p_setHighlightPos_1_ < 0) p_setHighlightPos_1_ = 0;
/*     */     
/* 470 */     this.highlightPos = p_setHighlightPos_1_;
/*     */     
/* 472 */     if (this.font != null) {
/* 473 */       if (this.displayPos > i) this.displayPos = i; 
/* 474 */       int j = getInnerWidth();
/* 475 */       String str = this.font.func_78269_a(this.value.substring(this.displayPos), j);
/* 476 */       int k = str.length() + this.displayPos;
/*     */       
/* 478 */       if (p_setHighlightPos_1_ == this.displayPos) {
/* 479 */         this.displayPos -= this.font.func_78262_a(this.value, j, true).length();
/*     */       }
/* 481 */       if (p_setHighlightPos_1_ > k) {
/* 482 */         this.displayPos += p_setHighlightPos_1_ - k;
/* 483 */       } else if (p_setHighlightPos_1_ <= this.displayPos) {
/* 484 */         this.displayPos -= this.displayPos - p_setHighlightPos_1_;
/*     */       } 
/*     */       
/* 487 */       if (this.displayPos < 0) this.displayPos = 0; 
/* 488 */       if (this.displayPos > i) this.displayPos = i; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isCanLoseFocus() {
/* 493 */     return this.canLoseFocus;
/*     */   }
/*     */   
/*     */   public void setCanLoseFocus(boolean p_setCanLoseFocus_1_) {
/* 497 */     this.canLoseFocus = p_setCanLoseFocus_1_;
/*     */   }
/*     */   
/*     */   public boolean isVisible() {
/* 501 */     return this.visible;
/*     */   }
/*     */   
/*     */   public void setVisible(boolean p_setVisible_1_) {
/* 505 */     this.visible = p_setVisible_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\realms\RealmsEditBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */