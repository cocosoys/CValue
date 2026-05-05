/*     */ package cpw.mods.fml.client;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class GuiScrollingList
/*     */ {
/*     */   private final Minecraft client;
/*     */   protected final int listWidth;
/*     */   protected final int listHeight;
/*     */   protected final int top;
/*     */   protected final int bottom;
/*     */   private final int right;
/*     */   protected final int left;
/*     */   protected final int slotHeight;
/*     */   private int scrollUpActionId;
/*     */   private int scrollDownActionId;
/*     */   protected int mouseX;
/*     */   protected int mouseY;
/*  40 */   private float initialMouseClickY = -2.0F;
/*     */   private float scrollFactor;
/*     */   private float scrollDistance;
/*  43 */   private int selectedIndex = -1;
/*  44 */   private long lastClickTime = 0L;
/*     */   
/*     */   private boolean field_25123_p = true;
/*     */   private boolean field_27262_q;
/*     */   private int field_27261_r;
/*     */   
/*     */   public GuiScrollingList(Minecraft client, int width, int height, int top, int bottom, int left, int entryHeight) {
/*  51 */     this.client = client;
/*  52 */     this.listWidth = width;
/*  53 */     this.listHeight = height;
/*  54 */     this.top = top;
/*  55 */     this.bottom = bottom;
/*  56 */     this.slotHeight = entryHeight;
/*  57 */     this.left = left;
/*  58 */     this.right = width + this.left;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_27258_a(boolean p_27258_1_) {
/*  63 */     this.field_25123_p = p_27258_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_27259_a(boolean p_27259_1_, int p_27259_2_) {
/*  68 */     this.field_27262_q = p_27259_1_;
/*  69 */     this.field_27261_r = p_27259_2_;
/*     */     
/*  71 */     if (!p_27259_1_)
/*     */     {
/*  73 */       this.field_27261_r = 0;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract int getSize();
/*     */   
/*     */   protected abstract void elementClicked(int paramInt, boolean paramBoolean);
/*     */   
/*     */   protected abstract boolean isSelected(int paramInt);
/*     */   
/*     */   protected int getContentHeight() {
/*  85 */     return getSize() * this.slotHeight + this.field_27261_r;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract void drawBackground();
/*     */ 
/*     */   
/*     */   protected abstract void drawSlot(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Tessellator paramTessellator);
/*     */   
/*     */   protected void func_27260_a(int p_27260_1_, int p_27260_2_, Tessellator p_27260_3_) {}
/*     */   
/*     */   protected void func_27255_a(int p_27255_1_, int p_27255_2_) {}
/*     */   
/*     */   protected void func_27257_b(int p_27257_1_, int p_27257_2_) {}
/*     */   
/*     */   public int func_27256_c(int p_27256_1_, int p_27256_2_) {
/* 101 */     int var3 = this.left + 1;
/* 102 */     int var4 = this.left + this.listWidth - 7;
/* 103 */     int var5 = p_27256_2_ - this.top - this.field_27261_r + (int)this.scrollDistance - 4;
/* 104 */     int var6 = var5 / this.slotHeight;
/* 105 */     return (p_27256_1_ >= var3 && p_27256_1_ <= var4 && var6 >= 0 && var5 >= 0 && var6 < getSize()) ? var6 : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerScrollButtons(List p_22240_1_, int p_22240_2_, int p_22240_3_) {
/* 110 */     this.scrollUpActionId = p_22240_2_;
/* 111 */     this.scrollDownActionId = p_22240_3_;
/*     */   }
/*     */ 
/*     */   
/*     */   private void applyScrollLimits() {
/* 116 */     int var1 = getContentHeight() - this.bottom - this.top - 4;
/*     */     
/* 118 */     if (var1 < 0)
/*     */     {
/* 120 */       var1 /= 2;
/*     */     }
/*     */     
/* 123 */     if (this.scrollDistance < 0.0F)
/*     */     {
/* 125 */       this.scrollDistance = 0.0F;
/*     */     }
/*     */     
/* 128 */     if (this.scrollDistance > var1)
/*     */     {
/* 130 */       this.scrollDistance = var1;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void actionPerformed(GuiButton button) {
/* 136 */     if (button.enabled)
/*     */     {
/* 138 */       if (button.id == this.scrollUpActionId) {
/*     */         
/* 140 */         this.scrollDistance -= (this.slotHeight * 2 / 3);
/* 141 */         this.initialMouseClickY = -2.0F;
/* 142 */         applyScrollLimits();
/*     */       }
/* 144 */       else if (button.id == this.scrollDownActionId) {
/*     */         
/* 146 */         this.scrollDistance += (this.slotHeight * 2 / 3);
/* 147 */         this.initialMouseClickY = -2.0F;
/* 148 */         applyScrollLimits();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float p_22243_3_) {
/* 155 */     this.mouseX = mouseX;
/* 156 */     this.mouseY = mouseY;
/* 157 */     drawBackground();
/* 158 */     int listLength = getSize();
/* 159 */     int scrollBarXStart = this.left + this.listWidth - 6;
/* 160 */     int scrollBarXEnd = scrollBarXStart + 6;
/* 161 */     int boxLeft = this.left;
/* 162 */     int boxRight = scrollBarXStart - 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 168 */     if (Mouse.isButtonDown(0)) {
/*     */       
/* 170 */       if (this.initialMouseClickY == -1.0F) {
/*     */         
/* 172 */         boolean var7 = true;
/*     */         
/* 174 */         if (mouseY >= this.top && mouseY <= this.bottom) {
/*     */           
/* 176 */           int i = mouseY - this.top - this.field_27261_r + (int)this.scrollDistance - 4;
/* 177 */           int j = i / this.slotHeight;
/*     */           
/* 179 */           if (mouseX >= boxLeft && mouseX <= boxRight && j >= 0 && i >= 0 && j < listLength) {
/*     */             
/* 181 */             boolean var12 = (j == this.selectedIndex && System.currentTimeMillis() - this.lastClickTime < 250L);
/* 182 */             elementClicked(j, var12);
/* 183 */             this.selectedIndex = j;
/* 184 */             this.lastClickTime = System.currentTimeMillis();
/*     */           }
/* 186 */           else if (mouseX >= boxLeft && mouseX <= boxRight && i < 0) {
/*     */             
/* 188 */             func_27255_a(mouseX - boxLeft, mouseY - this.top + (int)this.scrollDistance - 4);
/* 189 */             var7 = false;
/*     */           } 
/*     */           
/* 192 */           if (mouseX >= scrollBarXStart && mouseX <= scrollBarXEnd) {
/*     */             
/* 194 */             this.scrollFactor = -1.0F;
/* 195 */             int k = getContentHeight() - this.bottom - this.top - 4;
/*     */             
/* 197 */             if (k < 1)
/*     */             {
/* 199 */               k = 1;
/*     */             }
/*     */             
/* 202 */             int var13 = (int)(((this.bottom - this.top) * (this.bottom - this.top)) / getContentHeight());
/*     */             
/* 204 */             if (var13 < 32)
/*     */             {
/* 206 */               var13 = 32;
/*     */             }
/*     */             
/* 209 */             if (var13 > this.bottom - this.top - 8)
/*     */             {
/* 211 */               var13 = this.bottom - this.top - 8;
/*     */             }
/*     */             
/* 214 */             this.scrollFactor /= (this.bottom - this.top - var13) / k;
/*     */           }
/*     */           else {
/*     */             
/* 218 */             this.scrollFactor = 1.0F;
/*     */           } 
/*     */           
/* 221 */           if (var7)
/*     */           {
/* 223 */             this.initialMouseClickY = mouseY;
/*     */           }
/*     */           else
/*     */           {
/* 227 */             this.initialMouseClickY = -2.0F;
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 232 */           this.initialMouseClickY = -2.0F;
/*     */         }
/*     */       
/* 235 */       } else if (this.initialMouseClickY >= 0.0F) {
/*     */         
/* 237 */         this.scrollDistance -= (mouseY - this.initialMouseClickY) * this.scrollFactor;
/* 238 */         this.initialMouseClickY = mouseY;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 243 */       while (Mouse.next()) {
/*     */         
/* 245 */         int var16 = Mouse.getEventDWheel();
/*     */         
/* 247 */         if (var16 != 0) {
/*     */           
/* 249 */           if (var16 > 0) {
/*     */             
/* 251 */             var16 = -1;
/*     */           }
/* 253 */           else if (var16 < 0) {
/*     */             
/* 255 */             var16 = 1;
/*     */           } 
/*     */           
/* 258 */           this.scrollDistance += (var16 * this.slotHeight / 2);
/*     */         } 
/*     */       } 
/*     */       
/* 262 */       this.initialMouseClickY = -1.0F;
/*     */     } 
/*     */     
/* 265 */     applyScrollLimits();
/* 266 */     Tessellator var18 = Tessellator.instance;
/* 267 */     if (this.client.theWorld != null) {
/*     */       
/* 269 */       drawGradientRect(this.left, this.top, this.right, this.bottom, -1072689136, -804253680);
/*     */     }
/*     */     else {
/*     */       
/* 273 */       GL11.glDisable(2896);
/* 274 */       GL11.glDisable(2912);
/* 275 */       this.client.renderEngine.bindTexture(Gui.optionsBackground);
/* 276 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 277 */       float var17 = 32.0F;
/* 278 */       var18.startDrawingQuads();
/* 279 */       var18.setColorOpaque_I(2105376);
/* 280 */       var18.addVertexWithUV(this.left, this.bottom, 0.0D, (this.left / var17), ((this.bottom + (int)this.scrollDistance) / var17));
/* 281 */       var18.addVertexWithUV(this.right, this.bottom, 0.0D, (this.right / var17), ((this.bottom + (int)this.scrollDistance) / var17));
/* 282 */       var18.addVertexWithUV(this.right, this.top, 0.0D, (this.right / var17), ((this.top + (int)this.scrollDistance) / var17));
/* 283 */       var18.addVertexWithUV(this.left, this.top, 0.0D, (this.left / var17), ((this.top + (int)this.scrollDistance) / var17));
/* 284 */       var18.draw();
/*     */     } 
/*     */     
/* 287 */     int var10 = this.top + 4 - (int)this.scrollDistance;
/*     */     
/* 289 */     if (this.field_27262_q)
/*     */     {
/* 291 */       func_27260_a(boxRight, var10, var18);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 296 */     for (int var11 = 0; var11 < listLength; var11++) {
/*     */       
/* 298 */       int i = var10 + var11 * this.slotHeight + this.field_27261_r;
/* 299 */       int var13 = this.slotHeight - 4;
/*     */       
/* 301 */       if (i <= this.bottom && i + var13 >= this.top) {
/*     */         
/* 303 */         if (this.field_25123_p && isSelected(var11)) {
/*     */           
/* 305 */           int var14 = boxLeft;
/* 306 */           int var15 = boxRight;
/* 307 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 308 */           GL11.glDisable(3553);
/* 309 */           var18.startDrawingQuads();
/* 310 */           var18.setColorOpaque_I(8421504);
/* 311 */           var18.addVertexWithUV(var14, (i + var13 + 2), 0.0D, 0.0D, 1.0D);
/* 312 */           var18.addVertexWithUV(var15, (i + var13 + 2), 0.0D, 1.0D, 1.0D);
/* 313 */           var18.addVertexWithUV(var15, (i - 2), 0.0D, 1.0D, 0.0D);
/* 314 */           var18.addVertexWithUV(var14, (i - 2), 0.0D, 0.0D, 0.0D);
/* 315 */           var18.setColorOpaque_I(0);
/* 316 */           var18.addVertexWithUV((var14 + 1), (i + var13 + 1), 0.0D, 0.0D, 1.0D);
/* 317 */           var18.addVertexWithUV((var15 - 1), (i + var13 + 1), 0.0D, 1.0D, 1.0D);
/* 318 */           var18.addVertexWithUV((var15 - 1), (i - 1), 0.0D, 1.0D, 0.0D);
/* 319 */           var18.addVertexWithUV((var14 + 1), (i - 1), 0.0D, 0.0D, 0.0D);
/* 320 */           var18.draw();
/* 321 */           GL11.glEnable(3553);
/*     */         } 
/*     */         
/* 324 */         drawSlot(var11, boxRight, i, var13, var18);
/*     */       } 
/*     */     } 
/*     */     
/* 328 */     GL11.glDisable(2929);
/* 329 */     byte var20 = 4;
/* 330 */     if (this.client.theWorld == null) {
/*     */       
/* 332 */       overlayBackground(0, this.top, 255, 255);
/* 333 */       overlayBackground(this.bottom, this.listHeight, 255, 255);
/*     */     } 
/* 335 */     GL11.glEnable(3042);
/* 336 */     GL11.glBlendFunc(770, 771);
/* 337 */     GL11.glDisable(3008);
/* 338 */     GL11.glShadeModel(7425);
/* 339 */     GL11.glDisable(3553);
/* 340 */     var18.startDrawingQuads();
/* 341 */     var18.setColorRGBA_I(0, 0);
/* 342 */     var18.addVertexWithUV(this.left, (this.top + var20), 0.0D, 0.0D, 1.0D);
/* 343 */     var18.addVertexWithUV(this.right, (this.top + var20), 0.0D, 1.0D, 1.0D);
/* 344 */     var18.setColorRGBA_I(0, 255);
/* 345 */     var18.addVertexWithUV(this.right, this.top, 0.0D, 1.0D, 0.0D);
/* 346 */     var18.addVertexWithUV(this.left, this.top, 0.0D, 0.0D, 0.0D);
/* 347 */     var18.draw();
/* 348 */     var18.startDrawingQuads();
/* 349 */     var18.setColorRGBA_I(0, 255);
/* 350 */     var18.addVertexWithUV(this.left, this.bottom, 0.0D, 0.0D, 1.0D);
/* 351 */     var18.addVertexWithUV(this.right, this.bottom, 0.0D, 1.0D, 1.0D);
/* 352 */     var18.setColorRGBA_I(0, 0);
/* 353 */     var18.addVertexWithUV(this.right, (this.bottom - var20), 0.0D, 1.0D, 0.0D);
/* 354 */     var18.addVertexWithUV(this.left, (this.bottom - var20), 0.0D, 0.0D, 0.0D);
/* 355 */     var18.draw();
/* 356 */     int var19 = getContentHeight() - this.bottom - this.top - 4;
/*     */     
/* 358 */     if (var19 > 0) {
/*     */       
/* 360 */       int var13 = (this.bottom - this.top) * (this.bottom - this.top) / getContentHeight();
/*     */       
/* 362 */       if (var13 < 32)
/*     */       {
/* 364 */         var13 = 32;
/*     */       }
/*     */       
/* 367 */       if (var13 > this.bottom - this.top - 8)
/*     */       {
/* 369 */         var13 = this.bottom - this.top - 8;
/*     */       }
/*     */       
/* 372 */       int var14 = (int)this.scrollDistance * (this.bottom - this.top - var13) / var19 + this.top;
/*     */       
/* 374 */       if (var14 < this.top)
/*     */       {
/* 376 */         var14 = this.top;
/*     */       }
/*     */       
/* 379 */       var18.startDrawingQuads();
/* 380 */       var18.setColorRGBA_I(0, 255);
/* 381 */       var18.addVertexWithUV(scrollBarXStart, this.bottom, 0.0D, 0.0D, 1.0D);
/* 382 */       var18.addVertexWithUV(scrollBarXEnd, this.bottom, 0.0D, 1.0D, 1.0D);
/* 383 */       var18.addVertexWithUV(scrollBarXEnd, this.top, 0.0D, 1.0D, 0.0D);
/* 384 */       var18.addVertexWithUV(scrollBarXStart, this.top, 0.0D, 0.0D, 0.0D);
/* 385 */       var18.draw();
/* 386 */       var18.startDrawingQuads();
/* 387 */       var18.setColorRGBA_I(8421504, 255);
/* 388 */       var18.addVertexWithUV(scrollBarXStart, (var14 + var13), 0.0D, 0.0D, 1.0D);
/* 389 */       var18.addVertexWithUV(scrollBarXEnd, (var14 + var13), 0.0D, 1.0D, 1.0D);
/* 390 */       var18.addVertexWithUV(scrollBarXEnd, var14, 0.0D, 1.0D, 0.0D);
/* 391 */       var18.addVertexWithUV(scrollBarXStart, var14, 0.0D, 0.0D, 0.0D);
/* 392 */       var18.draw();
/* 393 */       var18.startDrawingQuads();
/* 394 */       var18.setColorRGBA_I(12632256, 255);
/* 395 */       var18.addVertexWithUV(scrollBarXStart, (var14 + var13 - 1), 0.0D, 0.0D, 1.0D);
/* 396 */       var18.addVertexWithUV((scrollBarXEnd - 1), (var14 + var13 - 1), 0.0D, 1.0D, 1.0D);
/* 397 */       var18.addVertexWithUV((scrollBarXEnd - 1), var14, 0.0D, 1.0D, 0.0D);
/* 398 */       var18.addVertexWithUV(scrollBarXStart, var14, 0.0D, 0.0D, 0.0D);
/* 399 */       var18.draw();
/*     */     } 
/*     */     
/* 402 */     func_27257_b(mouseX, mouseY);
/* 403 */     GL11.glEnable(3553);
/* 404 */     GL11.glShadeModel(7424);
/* 405 */     GL11.glEnable(3008);
/* 406 */     GL11.glDisable(3042);
/*     */   }
/*     */ 
/*     */   
/*     */   private void overlayBackground(int p_22239_1_, int p_22239_2_, int p_22239_3_, int p_22239_4_) {
/* 411 */     Tessellator var5 = Tessellator.instance;
/* 412 */     this.client.renderEngine.bindTexture(Gui.optionsBackground);
/* 413 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 414 */     float var6 = 32.0F;
/* 415 */     var5.startDrawingQuads();
/* 416 */     var5.setColorRGBA_I(4210752, p_22239_4_);
/* 417 */     var5.addVertexWithUV(0.0D, p_22239_2_, 0.0D, 0.0D, (p_22239_2_ / var6));
/* 418 */     var5.addVertexWithUV(this.listWidth + 30.0D, p_22239_2_, 0.0D, ((this.listWidth + 30) / var6), (p_22239_2_ / var6));
/* 419 */     var5.setColorRGBA_I(4210752, p_22239_3_);
/* 420 */     var5.addVertexWithUV(this.listWidth + 30.0D, p_22239_1_, 0.0D, ((this.listWidth + 30) / var6), (p_22239_1_ / var6));
/* 421 */     var5.addVertexWithUV(0.0D, p_22239_1_, 0.0D, 0.0D, (p_22239_1_ / var6));
/* 422 */     var5.draw();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void drawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6) {
/* 427 */     float f = (par5 >> 24 & 0xFF) / 255.0F;
/* 428 */     float f1 = (par5 >> 16 & 0xFF) / 255.0F;
/* 429 */     float f2 = (par5 >> 8 & 0xFF) / 255.0F;
/* 430 */     float f3 = (par5 & 0xFF) / 255.0F;
/* 431 */     float f4 = (par6 >> 24 & 0xFF) / 255.0F;
/* 432 */     float f5 = (par6 >> 16 & 0xFF) / 255.0F;
/* 433 */     float f6 = (par6 >> 8 & 0xFF) / 255.0F;
/* 434 */     float f7 = (par6 & 0xFF) / 255.0F;
/* 435 */     GL11.glDisable(3553);
/* 436 */     GL11.glEnable(3042);
/* 437 */     GL11.glDisable(3008);
/* 438 */     OpenGlHelper.glBlendFunc(770, 771, 1, 0);
/* 439 */     GL11.glShadeModel(7425);
/* 440 */     Tessellator tessellator = Tessellator.instance;
/* 441 */     tessellator.startDrawingQuads();
/* 442 */     tessellator.setColorRGBA_F(f1, f2, f3, f);
/* 443 */     tessellator.addVertex(par3, par2, 0.0D);
/* 444 */     tessellator.addVertex(par1, par2, 0.0D);
/* 445 */     tessellator.setColorRGBA_F(f5, f6, f7, f4);
/* 446 */     tessellator.addVertex(par1, par4, 0.0D);
/* 447 */     tessellator.addVertex(par3, par4, 0.0D);
/* 448 */     tessellator.draw();
/* 449 */     GL11.glShadeModel(7424);
/* 450 */     GL11.glDisable(3042);
/* 451 */     GL11.glEnable(3008);
/* 452 */     GL11.glEnable(3553);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\GuiScrollingList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */