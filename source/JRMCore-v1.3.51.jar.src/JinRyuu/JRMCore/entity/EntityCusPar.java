/*     */ package JinRyuu.JRMCore.entity;
/*     */ public class EntityCusPar extends Entity { private Entity ent; private byte id_min; private byte id_max; private byte id; private String rr; private boolean ended; private boolean rotation; private boolean rotation2; private float rotation_sp; private float rotation_sp2; private float max_rotation_sp;
/*     */   private float max_rotation_sp2;
/*     */   private boolean rotate;
/*     */   private boolean rotate2;
/*     */   private float data39;
/*     */   private float data40;
/*     */   private float data41;
/*     */   private byte data42;
/*     */   private float data43;
/*     */   private float data44;
/*     */   private float data45;
/*     */   private byte data1;
/*     */   private int data2;
/*     */   private String data3;
/*     */   private byte data4;
/*     */   private float data5;
/*     */   private float data6;
/*     */   private float data7;
/*     */   private byte data31;
/*     */   
/*  22 */   public boolean hasEnt() { return (this.ent != null && !this.ent.field_70128_L); } private float data8; private float data9; private float data10; private float data11; private float data12; private float data13; private float data14; private float data15; private float data16; private double data17; private double data18; private double data19; private double data36; private double data37; private double data38; private byte data20; private float data21; private float data22; private float data23; private float data24; private float data25; private boolean data26; private boolean data27; private float data28; private float data29; private float data30; private byte data32; private boolean data33; private byte data34; private boolean data35; public Entity getEnt() {
/*  23 */     return this.ent;
/*     */   }
/*     */   
/*     */   public byte getId_min() {
/*  27 */     return this.id_min;
/*     */   } public byte getId_max() {
/*  29 */     return this.id_max;
/*     */   } public byte getId() {
/*  31 */     return this.id;
/*     */   } public String getrr() {
/*  33 */     return this.rr;
/*     */   } public boolean hasEnded() {
/*  35 */     return this.ended;
/*     */   } public boolean getRotation() {
/*  37 */     return this.rotation;
/*     */   } public boolean getRotation2() {
/*  39 */     return this.rotation2;
/*     */   }
/*  41 */   public float getRotation_Sp() { return this.rotation_sp; } public void setRotation_Sp(float r) {
/*  42 */     this.rotation_sp = r;
/*     */   } public float getRotation_Sp2() {
/*  44 */     return this.rotation_sp2;
/*     */   }
/*     */   public float getMaxRotation_Sp() {
/*  47 */     return this.max_rotation_sp;
/*     */   } public float getMaxRotation_Sp2() {
/*  49 */     return this.max_rotation_sp2;
/*     */   }
/*     */   
/*  52 */   public boolean getRotate() { return this.rotate; } public void setRotate(boolean b) {
/*  53 */     this.rotate = b;
/*     */   }
/*  55 */   public boolean getRotate2() { return this.rotate2; } public void setRotate2(boolean b) {
/*  56 */     this.rotate2 = b;
/*     */   }
/*     */   
/*  59 */   public float getdata39() { return this.data39; } public void setdata39(float f) {
/*  60 */     this.data39 = f;
/*     */   }
/*  62 */   public float getdata40() { return this.data40; } public void setdata40(float f) {
/*  63 */     this.data40 = f;
/*     */   }
/*  65 */   public float getdata41() { return this.data41; } public void setdata41(float f) {
/*  66 */     this.data41 = f;
/*     */   }
/*     */   
/*  69 */   public byte getdata42() { return this.data42; } public void setdata42(int f) {
/*  70 */     this.data42 = (byte)f;
/*     */   }
/*     */   
/*  73 */   public float getdata43() { return this.data43; } public void setdata43(float f) {
/*  74 */     this.data43 = f;
/*     */   }
/*  76 */   public float getdata44() { return this.data44; } public void setdata44(float f) {
/*  77 */     this.data44 = f;
/*     */   }
/*  79 */   public float getdata45() { return this.data45; } public void setdata45(float f) {
/*  80 */     this.data45 = f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getdata1() {
/*  86 */     return this.data1;
/*     */   }
/*     */   
/*     */   public int getdata2() {
/*  90 */     return this.data2;
/*     */   }
/*     */   
/*     */   public String getdata3() {
/*  94 */     return this.data3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getdata4() {
/* 100 */     return this.data4;
/*     */   }
/*     */   
/*     */   public float getdata5() {
/* 104 */     return this.data5;
/*     */   }
/*     */   
/*     */   public float getdata6() {
/* 108 */     return this.data6;
/*     */   }
/*     */   
/*     */   public float getdata7() {
/* 112 */     return this.data7;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getdata31() {
/* 118 */     return this.data31;
/*     */   }
/*     */   
/*     */   public float getdata8() {
/* 122 */     return this.data8;
/*     */   }
/*     */   
/*     */   public float getdata9() {
/* 126 */     return this.data9;
/*     */   }
/*     */   
/*     */   public float getdata10() {
/* 130 */     return this.data10;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getdata11() {
/* 135 */     return this.data12;
/*     */   }
/*     */   
/*     */   public float getdata12() {
/* 139 */     return this.data12;
/*     */   }
/*     */   
/*     */   public float getdata13() {
/* 143 */     return this.data13;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getdata14() {
/* 148 */     return this.data14;
/*     */   }
/*     */   
/*     */   public float getdata15() {
/* 152 */     return this.data15;
/*     */   }
/*     */   
/*     */   public float getdata16() {
/* 156 */     return this.data16;
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
/*     */   public byte getdata20() {
/* 177 */     return this.data20;
/*     */   }
/*     */   
/*     */   public float getdata21() {
/* 181 */     return this.data21;
/*     */   }
/*     */   
/*     */   public float getdata22() {
/* 185 */     return this.data22;
/*     */   }
/*     */   
/*     */   public float getdata23() {
/* 189 */     return this.data23;
/*     */   }
/*     */   
/*     */   public float getdata24() {
/* 193 */     return this.data24;
/*     */   }
/*     */   
/*     */   public float getdata25() {
/* 197 */     return this.data25;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getdata28() {
/* 205 */     return this.data28;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getdata32() {
/* 213 */     return this.data32;
/*     */   }
/*     */   
/*     */   public boolean getdata33() {
/* 217 */     return this.data33;
/*     */   }
/*     */   
/*     */   public byte getdata34() {
/* 221 */     return this.data34;
/*     */   }
/*     */   
/*     */   public boolean getdata35() {
/* 225 */     return this.data35;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityCusPar(String data3, World w, float box1, float box2, double poX, double poY, double poZ, double start_poX, double start_poY, double start_poZ, double moX, double moY, double moZ, float data29, int id, int id_min, int id_max, int data32, boolean rotate, float max_rotation_sp, boolean rotate2, float max_rotation_sp2, int data1, String rr, int data2, int data4, float data5, float data6, float data7, int data31, float data8, float data9, float data10, float data11, float data12, float data13, float data14, float data15, float data16, int data20, float data21, float data22, float data23, float data24, float data25, boolean data33, int data34, boolean data35, Entity ent) {
/* 300 */     super(w);
/* 301 */     this.ent = ent;
/* 302 */     func_70105_a(box1, box2);
/* 303 */     this.data17 = start_poX;
/* 304 */     this.data18 = start_poY;
/* 305 */     this.data19 = start_poZ;
/*     */     
/* 307 */     this.field_70165_t = poX + this.data17;
/* 308 */     if (hasEnt()) { this.field_70163_u = poY + this.data18; }
/* 309 */     else { this.field_70163_u = poY + this.data18; }
/* 310 */      this.field_70161_v = poZ + this.data19;
/*     */     
/* 312 */     this.data36 = 0.0D;
/* 313 */     this.data37 = 0.0D;
/* 314 */     this.data38 = 0.0D;
/* 315 */     this.field_70159_w = moX;
/* 316 */     this.field_70181_x = moY;
/* 317 */     this.field_70179_y = moZ;
/* 318 */     this.data29 = data29;
/* 319 */     this.data30 = 1.0F;
/* 320 */     this.field_70133_I = true;
/* 321 */     func_70080_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
/*     */ 
/*     */     
/* 324 */     this.id = (byte)id;
/* 325 */     this.id_min = (byte)id_min;
/* 326 */     this.id_max = (byte)id_max;
/* 327 */     this.data32 = (byte)data32;
/*     */     
/* 329 */     this.rotate = rotate;
/* 330 */     this.rotate2 = rotate2;
/* 331 */     this.rotation = false;
/* 332 */     this.rotation2 = false;
/* 333 */     this.rotation_sp = 0.0F;
/* 334 */     this.rotation_sp2 = 0.0F;
/* 335 */     this.max_rotation_sp = 0.0F;
/* 336 */     this.max_rotation_sp2 = 0.0F;
/* 337 */     this.data39 = 0.0F;
/* 338 */     this.data40 = 0.0F;
/* 339 */     this.data41 = 0.0F;
/* 340 */     this.data42 = 0;
/* 341 */     this.data43 = 0.0F;
/* 342 */     this.data44 = 0.0F;
/* 343 */     this.data45 = 0.0F;
/*     */     
/* 345 */     if (rotate) {
/* 346 */       this.rotation = ((int)(Math.random() * 2.0D) == 0);
/* 347 */       this.max_rotation_sp = max_rotation_sp;
/* 348 */       this.rotation_sp = (float)(Math.random() * max_rotation_sp) + 0.001F;
/*     */     } 
/*     */     
/* 351 */     if (rotate) {
/* 352 */       this.rotation2 = ((int)(Math.random() * 2.0D) == 0);
/* 353 */       this.max_rotation_sp2 = max_rotation_sp2;
/* 354 */       this.rotation_sp2 = (float)(Math.random() * max_rotation_sp2) + 0.001F;
/*     */     } 
/* 356 */     this.rr = rr;
/*     */ 
/*     */     
/* 359 */     this.ended = false;
/* 360 */     this.data1 = (byte)data1;
/* 361 */     this.data2 = data2;
/* 362 */     this.data3 = data3;
/*     */ 
/*     */     
/* 365 */     this.data4 = (byte)data4;
/* 366 */     this.data5 = data5;
/* 367 */     this.data6 = data6;
/* 368 */     this.data7 = data7;
/*     */ 
/*     */     
/* 371 */     float egy = 2.55F;
/* 372 */     this.data31 = (byte)data31;
/* 373 */     this.data8 = data8;
/* 374 */     if (this.data8 > 1.0F) this.data8 = this.data8 / egy / 100.0F; 
/* 375 */     this.data9 = data9;
/* 376 */     if (this.data9 > 1.0F) this.data9 = this.data9 / egy / 100.0F; 
/* 377 */     this.data10 = data10;
/* 378 */     if (this.data10 > 1.0F) this.data10 = this.data10 / egy / 100.0F;
/*     */     
/* 380 */     this.data11 = data11;
/* 381 */     this.data12 = data12;
/* 382 */     this.data13 = data13;
/*     */     
/* 384 */     this.data14 = data14;
/* 385 */     if (this.data14 > 1.0F) this.data14 = this.data14 / egy / 100.0F; 
/* 386 */     this.data15 = data15;
/* 387 */     if (this.data15 > 1.0F) this.data15 = this.data15 / egy / 100.0F; 
/* 388 */     this.data16 = data16;
/* 389 */     if (this.data16 > 1.0F) this.data16 = this.data16 / egy / 100.0F;
/*     */ 
/*     */     
/* 392 */     this.data20 = (byte)data20;
/* 393 */     this.data21 = data21;
/* 394 */     this.data22 = data22;
/* 395 */     this.data23 = data23;
/* 396 */     this.data24 = data24;
/* 397 */     this.data25 = data25;
/* 398 */     this.data26 = false;
/* 399 */     this.data27 = false;
/* 400 */     this.data28 = data21;
/*     */     
/* 402 */     this.data33 = data33;
/* 403 */     this.data34 = (byte)data34;
/* 404 */     this.data35 = data35;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityCusPar(String data3, float box1, float box2, int id_min, int id_max, int data32, boolean rotate, float max_rotation_sp, int data1, String rr, int data2, int data4, float data5, float data6, float data7, int data31, float data8, float data9, float data10, float data11, float data12, float data13, float data14, float data15, float data16, int data20, float data21, float data22, float data23, float data24, float data25) {
/* 468 */     super(null);
/* 469 */     func_70105_a(box1, box2);
/* 470 */     this.field_70165_t = 0.0D;
/* 471 */     this.field_70163_u = 0.0D;
/* 472 */     this.field_70161_v = 0.0D;
/* 473 */     this.data17 = 0.0D;
/* 474 */     this.data18 = 0.0D;
/* 475 */     this.data19 = 0.0D;
/* 476 */     this.data36 = 0.0D;
/* 477 */     this.data37 = 0.0D;
/* 478 */     this.data38 = 0.0D;
/* 479 */     this.field_70159_w = 0.0D;
/* 480 */     this.field_70181_x = 0.0D;
/* 481 */     this.field_70179_y = 0.0D;
/* 482 */     this.data29 = 0.0F;
/* 483 */     this.data30 = 1.0F;
/* 484 */     func_70080_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
/*     */ 
/*     */     
/* 487 */     this.id = 0;
/* 488 */     this.id_min = (byte)id_min;
/* 489 */     this.id_max = (byte)id_max;
/* 490 */     this.data32 = (byte)data32;
/*     */     
/* 492 */     this.rotate = rotate;
/* 493 */     this.rotate2 = false;
/* 494 */     this.rotation = false;
/* 495 */     this.rotation2 = false;
/* 496 */     this.rotation_sp = 0.0F;
/* 497 */     this.rotation_sp2 = 0.0F;
/* 498 */     this.max_rotation_sp = 0.0F;
/* 499 */     this.max_rotation_sp2 = 0.0F;
/*     */     
/* 501 */     if (rotate) {
/* 502 */       this.rotation = ((int)(Math.random() * 2.0D) == 0);
/* 503 */       this.max_rotation_sp = max_rotation_sp;
/* 504 */       this.rotation_sp = (float)(Math.random() * max_rotation_sp) + 0.001F;
/*     */     } 
/*     */     
/* 507 */     if (rotate) {
/* 508 */       this.rotation2 = ((int)(Math.random() * 2.0D) == 0);
/* 509 */       this.max_rotation_sp2 = 0.0F;
/* 510 */       this.rotation_sp2 = (float)(Math.random() * this.max_rotation_sp2) + 0.001F;
/*     */     } 
/* 512 */     this.data39 = 0.0F;
/* 513 */     this.rr = rr;
/*     */ 
/*     */     
/* 516 */     this.ended = false;
/* 517 */     this.data1 = (byte)data1;
/* 518 */     this.data2 = data2;
/* 519 */     this.data3 = data3;
/*     */ 
/*     */     
/* 522 */     this.data4 = (byte)data4;
/* 523 */     this.data5 = data5;
/* 524 */     this.data6 = data6;
/* 525 */     this.data7 = data7;
/*     */ 
/*     */     
/* 528 */     this.data31 = (byte)data31;
/* 529 */     this.data8 = data8;
/* 530 */     this.data9 = data9;
/* 531 */     this.data10 = data10;
/*     */     
/* 533 */     this.data11 = data11;
/* 534 */     this.data12 = data12;
/* 535 */     this.data13 = data13;
/*     */     
/* 537 */     this.data14 = data14;
/* 538 */     this.data15 = data15;
/* 539 */     this.data16 = data16;
/*     */ 
/*     */     
/* 542 */     this.data20 = (byte)data20;
/* 543 */     this.data21 = data21;
/* 544 */     this.data22 = data22;
/* 545 */     this.data23 = data23;
/* 546 */     this.data24 = data24;
/* 547 */     this.data25 = data25;
/* 548 */     this.data26 = false;
/* 549 */     this.data27 = false;
/* 550 */     this.data28 = data21;
/*     */     
/* 552 */     this.data33 = false;
/* 553 */     this.data34 = -1;
/* 554 */     this.data35 = false;
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
/*     */   public void func_70071_h_() {
/* 566 */     if (this.field_70170_p.field_72995_K) {
/* 567 */       if (!JRMCoreClient.mc.func_147113_T())
/*     */       {
/* 569 */         if (!this.ended) {
/* 570 */           part_atlatszosag();
/* 571 */           if (this.field_70173_aa > 60 && this.data28 == 0.0F) {
/* 572 */             this.ended = true;
/* 573 */             func_70106_y();
/*     */           } 
/*     */           
/* 576 */           if (this.data29 != 0.0F) {
/* 577 */             this.data30 += this.data29;
/*     */             
/* 579 */             this.field_70159_w *= this.data30;
/* 580 */             this.field_70181_x *= this.data30;
/* 581 */             this.field_70179_y *= this.data30;
/*     */           } 
/*     */ 
/*     */           
/* 585 */           this.field_70165_t += this.field_70159_w * JGConfigClientSettings.get_da2();
/* 586 */           this.field_70163_u += this.field_70181_x * JGConfigClientSettings.get_da2();
/* 587 */           this.field_70161_v += this.field_70179_y * JGConfigClientSettings.get_da2();
/*     */           
/* 589 */           this.data36 += this.field_70159_w * JGConfigClientSettings.get_da2();
/* 590 */           this.data37 += this.field_70181_x * JGConfigClientSettings.get_da2();
/* 591 */           this.data38 += this.field_70179_y * JGConfigClientSettings.get_da2();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 597 */       if (hasEnt())
/* 598 */       { func_70107_b(this.ent.field_70165_t + this.data17 + this.data36, this.ent.field_70163_u + this.data18 + this.data37 + ((this.ent instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), this.ent.field_70161_v + this.data19 + this.data38); }
/* 599 */       else { func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 607 */       if (this.data1 == 0) {
/* 608 */         if (hasEnded() || this.field_70173_aa > 10000) {
/* 609 */           func_70106_y();
/*     */         }
/*     */       }
/* 612 */       else if (this.data2 <= this.field_70173_aa) {
/* 613 */         this.ended = true;
/* 614 */         func_70106_y();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void part_atlatszosag() {
/* 644 */     if (!this.data27) {
/* 645 */       if (this.data20 == 1) {
/* 646 */         if (this.data25 > 0.0F) {
/* 647 */           this.data21 += this.data25;
/* 648 */           this.data28 += this.data25;
/* 649 */           if (this.data21 > this.data22) {
/* 650 */             this.data21 = this.data22;
/* 651 */             this.data28 = this.data22;
/*     */           }
/*     */         
/* 654 */         } else if (this.data25 < 0.0F) {
/* 655 */           this.data21 += this.data25;
/* 656 */           this.data28 += this.data25;
/* 657 */           if (this.data21 < this.data22) {
/* 658 */             this.data21 = this.data22;
/* 659 */             this.data28 = this.data22;
/*     */           }
/*     */         
/*     */         } 
/* 663 */       } else if (this.data20 == 2) {
/* 664 */         if (this.data25 > 0.0F) {
/* 665 */           if (!this.data26) {
/* 666 */             this.data21 += this.data25;
/* 667 */             if (this.data21 > this.data23) this.data26 = true; 
/* 668 */             if (!this.data26) this.data28 += this.data25;
/*     */           
/*     */           } else {
/* 671 */             this.data21 -= this.data25;
/* 672 */             this.data28 -= this.data25;
/* 673 */             if (this.data21 < this.data22) this.data27 = true;
/*     */           
/*     */           } 
/* 676 */         } else if (this.data25 < 0.0F) {
/* 677 */           if (!this.data26) {
/* 678 */             this.data21 -= this.data25;
/* 679 */             if (this.data21 < this.data23) this.data26 = true; 
/* 680 */             if (!this.data26) this.data28 -= this.data25;
/*     */           
/*     */           } else {
/* 683 */             this.data21 += this.data25;
/* 684 */             this.data28 += this.data25;
/* 685 */             if (this.data21 > this.data22) this.data27 = true;
/*     */           
/*     */           } 
/*     */         } 
/* 689 */       } else if (this.data20 == 3) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 695 */         float szaz = this.data2;
/* 696 */         float egy = szaz / 100.0F;
/* 697 */         float calc = this.field_70173_aa / egy / 100.0F;
/*     */         
/* 699 */         if (this.data25 > 0.0F) {
/* 700 */           this.data21 = calc;
/* 701 */           this.data28 = calc;
/* 702 */           if (this.data21 > 1.0F) {
/* 703 */             this.data21 = 1.0F;
/* 704 */             this.data28 = 1.0F;
/*     */           }
/*     */         
/* 707 */         } else if (this.data25 < 0.0F) {
/* 708 */           this.data21 = 1.0F - calc;
/* 709 */           this.data28 = 1.0F - calc;
/* 710 */           if (0.0F < this.data22) {
/* 711 */             this.data21 = 0.0F;
/* 712 */             this.data28 = 0.0F;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 718 */     if (this.data21 < 0.0F) { this.data21 = 0.0F; }
/* 719 */     else if (this.data21 > 1.0F) { this.data21 = 1.0F; }
/* 720 */      if (this.data28 < 0.0F) { this.data28 = 0.0F; }
/* 721 */     else if (this.data28 > 1.0F) { this.data28 = 1.0F; }
/*     */   
/*     */   }
/*     */   protected void func_70088_a() {}
/*     */   protected void func_70037_a(NBTTagCompound p_70037_1_) {}
/*     */   protected void func_70014_b(NBTTagCompound p_70014_1_) {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean isInRangeToRenderVec3D(Vec3 par1Vec3) {
/* 730 */     return true;
/*     */   }
/*     */   public boolean func_70112_a(double par1) {
/* 733 */     if (JGConfigClientSettings.renderdistanceMultiplierParticles == 10000) return true; 
/* 734 */     double d1 = this.field_70121_D.func_72320_b();
/* 735 */     d1 *= 64.0D * this.field_70155_l;
/* 736 */     return (par1 < d1 * d1 * JGConfigClientSettings.renderdistanceMultiplierParticles / 100.0D);
/*     */   } }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntityCusPar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */