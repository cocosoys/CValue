/*     */ package ibxm;
/*     */ 
/*     */ public class Envelope
/*     */ {
/*     */   public boolean sustain;
/*     */   public boolean looped;
/*     */   private int sustain_tick;
/*     */   
/*     */   public Envelope() {
/*  10 */     set_num_points(1);
/*     */   }
/*     */   private int loop_start_tick; private int loop_end_tick; private int[] ticks; private int[] ampls;
/*     */   
/*     */   public void set_num_points(int num_points) {
/*  15 */     if (num_points <= 0) {
/*  16 */       num_points = 1;
/*     */     }
/*  18 */     this.ticks = new int[num_points];
/*  19 */     this.ampls = new int[num_points];
/*  20 */     set_point(0, 0, 0, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void set_point(int point, int tick, int ampl, boolean delta) {
/*  25 */     if (point >= 0 && point < this.ticks.length) {
/*  26 */       if (point == 0) {
/*  27 */         tick = 0;
/*     */       }
/*  29 */       if (point > 0) {
/*  30 */         if (delta) tick += this.ticks[point - 1]; 
/*  31 */         if (tick <= this.ticks[point - 1]) {
/*  32 */           System.out.println("Envelope: Point not valid (" + tick + " <= " + this.ticks[point - 1] + ")");
/*  33 */           tick = this.ticks[point - 1] + 1;
/*     */         } 
/*     */       } 
/*  36 */       this.ticks[point] = tick;
/*  37 */       this.ampls[point] = ampl;
/*  38 */       point++;
/*  39 */       while (point < this.ticks.length) {
/*  40 */         this.ticks[point] = this.ticks[point - 1] + 1;
/*  41 */         this.ampls[point] = 0;
/*  42 */         point++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void set_sustain_point(int point) {
/*  48 */     if (point < 0) {
/*  49 */       point = 0;
/*     */     }
/*  51 */     if (point >= this.ticks.length) {
/*  52 */       point = this.ticks.length - 1;
/*     */     }
/*  54 */     this.sustain_tick = this.ticks[point];
/*     */   }
/*     */   
/*     */   public void set_loop_points(int start, int end) {
/*  58 */     if (start < 0) {
/*  59 */       start = 0;
/*     */     }
/*  61 */     if (start >= this.ticks.length) {
/*  62 */       start = this.ticks.length - 1;
/*     */     }
/*  64 */     if (end < start || end >= this.ticks.length) {
/*  65 */       end = start;
/*     */     }
/*  67 */     this.loop_start_tick = this.ticks[start];
/*  68 */     this.loop_end_tick = this.ticks[end];
/*     */   }
/*     */   
/*     */   public int next_tick(int tick, boolean key_on) {
/*  72 */     tick++;
/*  73 */     if (this.looped && tick >= this.loop_end_tick) {
/*  74 */       tick = this.loop_start_tick;
/*     */     }
/*  76 */     if (this.sustain && key_on && tick >= this.sustain_tick) {
/*  77 */       tick = this.sustain_tick;
/*     */     }
/*  79 */     return tick;
/*     */   }
/*     */ 
/*     */   
/*     */   public int calculate_ampl(int tick) {
/*  84 */     int ampl = this.ampls[this.ticks.length - 1];
/*  85 */     if (tick < this.ticks[this.ticks.length - 1]) {
/*  86 */       int point = 0;
/*  87 */       for (int idx = 1; idx < this.ticks.length; idx++) {
/*  88 */         if (this.ticks[idx] <= tick) {
/*  89 */           point = idx;
/*     */         }
/*     */       } 
/*  92 */       int delta_t = this.ticks[point + 1] - this.ticks[point];
/*  93 */       int delta_a = this.ampls[point + 1] - this.ampls[point];
/*  94 */       ampl = (delta_a << 15) / delta_t;
/*  95 */       ampl = ampl * (tick - this.ticks[point]) >> 15;
/*  96 */       ampl += this.ampls[point];
/*     */     } 
/*  98 */     return ampl;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dump() {
/* 103 */     for (int idx = 0; idx < this.ticks.length; idx++) {
/* 104 */       System.out.println(this.ticks[idx] + ", " + this.ampls[idx]);
/*     */     }
/* 106 */     for (int tick = 0; tick < 222; tick++)
/* 107 */       System.out.print(calculate_ampl(tick) + ", "); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\ibxm\Envelope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */