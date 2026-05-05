/*     */ package ibxm;
/*     */ 
/*     */ 
/*     */ public class Sample
/*     */ {
/*     */   public String name;
/*     */   public boolean set_panning;
/*     */   public int volume;
/*     */   public int panning;
/*     */   public int transpose;
/*     */   private int loop_start;
/*     */   private int loop_length;
/*     */   private short[] sample_data;
/*     */   private static final int POINT_SHIFT = 4;
/*     */   private static final int POINTS = 16;
/*     */   private static final int OVERLAP = 8;
/*     */   private static final int INTERP_SHIFT = 11;
/*     */   private static final int INTERP_BITMASK = 2047;
/*  19 */   private static final short[] sinc_table = new short[] { 0, -7, 27, -71, 142, -227, 299, 32439, 299, -227, 142, -71, 27, -7, 0, 0, 0, 0, -5, 36, -142, 450, -1439, 32224, 2302, -974, 455, -190, 64, -15, 2, 0, 0, 6, -33, 128, -391, 1042, -2894, 31584, 4540, -1765, 786, -318, 105, -25, 3, 0, 0, 10, -55, 204, -597, 1533, -4056, 30535, 6977, -2573, 1121, -449, 148, -36, 5, 0, -1, 13, -71, 261, -757, 1916, -4922, 29105, 9568, -3366, 1448, -578, 191, -47, 7, 0, -1, 15, -81, 300, -870, 2185, -5498, 27328, 12263, -4109, 1749, -698, 232, -58, 9, 0, -1, 15, -86, 322, -936, 2343, -5800, 25249, 15006, -4765, 2011, -802, 269, -68, 10, 0, -1, 15, -87, 328, -957, 2394, -5849, 22920, 17738, -5298, 2215, -885, 299, -77, 12, 0, 0, 14, -83, 319, -938, 2347, -5671, 20396, 20396, -5671, 2347, -938, 319, -83, 14, 0, 0, 12, -77, 299, -885, 2215, -5298, 17738, 22920, -5849, 2394, -957, 328, -87, 15, -1, 0, 10, -68, 269, -802, 2011, -4765, 15006, 25249, -5800, 2343, -936, 322, -86, 15, -1, 0, 9, -58, 232, -698, 1749, -4109, 12263, 27328, -5498, 2185, -870, 300, -81, 15, -1, 0, 7, -47, 191, -578, 1448, -3366, 9568, 29105, -4922, 1916, -757, 261, -71, 13, -1, 0, 5, -36, 148, -449, 1121, -2573, 6977, 30535, -4056, 1533, -597, 204, -55, 10, 0, 0, 3, -25, 105, -318, 786, -1765, 4540, 31584, -2894, 1042, -391, 128, -33, 6, 0, 0, 2, -15, 64, -190, 455, -974, 2302, 32224, -1439, 450, -142, 36, -5, 0, 0, 0, 0, -7, 27, -71, 142, -227, 299, 32439, 299, -227, 142, -71, 27, -7, 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sample() {
/*  40 */     this.name = "";
/*  41 */     set_sample_data(new short[0], 0, 0, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set_sample_data(short[] data, int loop_start, int loop_length, boolean ping_pong) {
/*  47 */     if (loop_start < 0) {
/*  48 */       loop_start = 0;
/*     */     }
/*  50 */     if (loop_start >= data.length) {
/*  51 */       loop_start = data.length - 1;
/*     */     }
/*  53 */     if (loop_start + loop_length > data.length) {
/*  54 */       loop_length = data.length - loop_start;
/*     */     }
/*  56 */     if (loop_length <= 1) {
/*  57 */       this.sample_data = new short[8 + data.length + 24];
/*  58 */       System.arraycopy(data, 0, this.sample_data, 8, data.length);
/*  59 */       int offset = 0;
/*  60 */       while (offset < 8) {
/*  61 */         short sample = this.sample_data[8 + data.length - 1];
/*  62 */         sample = (short)(sample * (8 - offset) / 8);
/*  63 */         this.sample_data[8 + data.length + offset] = sample;
/*  64 */         offset++;
/*     */       } 
/*  66 */       loop_start = 8 + data.length + 8;
/*  67 */       loop_length = 1;
/*     */     } else {
/*  69 */       if (ping_pong) {
/*  70 */         this.sample_data = new short[8 + loop_start + loop_length * 2 + 16];
/*  71 */         System.arraycopy(data, 0, this.sample_data, 8, loop_start + loop_length);
/*  72 */         int i = 0;
/*  73 */         while (i < loop_length) {
/*  74 */           short sample = data[loop_start + loop_length - i - 1];
/*  75 */           this.sample_data[8 + loop_start + loop_length + i] = sample;
/*  76 */           i++;
/*     */         } 
/*  78 */         loop_start += 8;
/*  79 */         loop_length *= 2;
/*     */       } else {
/*  81 */         this.sample_data = new short[8 + loop_start + loop_length + 16];
/*  82 */         System.arraycopy(data, 0, this.sample_data, 8, loop_start + loop_length);
/*  83 */         loop_start += 8;
/*     */       } 
/*  85 */       int offset = 0;
/*  86 */       while (offset < 16) {
/*  87 */         short sample = this.sample_data[loop_start + offset];
/*  88 */         this.sample_data[loop_start + loop_length + offset] = sample;
/*  89 */         offset++;
/*     */       } 
/*     */     } 
/*  92 */     this.loop_start = loop_start;
/*  93 */     this.loop_length = loop_length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resample_nearest(int sample_idx, int sample_frac, int step, int left_gain, int right_gain, int[] mix_buffer, int frame_offset, int frames) {
/* 100 */     sample_idx += 8;
/* 101 */     int loop_end = this.loop_start + this.loop_length - 1;
/* 102 */     int offset = frame_offset << 1;
/* 103 */     int end = frame_offset + frames - 1 << 1;
/* 104 */     while (frames > 0) {
/* 105 */       if (sample_idx > loop_end) {
/* 106 */         if (this.loop_length <= 1) {
/*     */           break;
/*     */         }
/* 109 */         sample_idx = this.loop_start + (sample_idx - this.loop_start) % this.loop_length;
/*     */       } 
/* 111 */       int max_sample_idx = sample_idx + (sample_frac + (frames - 1) * step >> 15);
/* 112 */       if (max_sample_idx > loop_end) {
/* 113 */         while (sample_idx <= loop_end) {
/* 114 */           mix_buffer[offset++] = mix_buffer[offset++] + (this.sample_data[sample_idx] * left_gain >> 15);
/* 115 */           mix_buffer[offset++] = mix_buffer[offset++] + (this.sample_data[sample_idx] * right_gain >> 15);
/* 116 */           sample_frac += step;
/* 117 */           sample_idx += sample_frac >> 15;
/* 118 */           sample_frac &= 0x7FFF;
/*     */         } 
/*     */       } else {
/* 121 */         while (offset <= end) {
/* 122 */           mix_buffer[offset++] = mix_buffer[offset++] + (this.sample_data[sample_idx] * left_gain >> 15);
/* 123 */           mix_buffer[offset++] = mix_buffer[offset++] + (this.sample_data[sample_idx] * right_gain >> 15);
/* 124 */           sample_frac += step;
/* 125 */           sample_idx += sample_frac >> 15;
/* 126 */           sample_frac &= 0x7FFF;
/*     */         } 
/*     */       } 
/* 129 */       frames = end - offset + 2 >> 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resample_linear(int sample_idx, int sample_frac, int step, int left_gain, int right_gain, int[] mix_buffer, int frame_offset, int frames) {
/* 137 */     sample_idx += 8;
/* 138 */     int loop_end = this.loop_start + this.loop_length - 1;
/* 139 */     int offset = frame_offset << 1;
/* 140 */     int end = frame_offset + frames - 1 << 1;
/* 141 */     while (frames > 0) {
/* 142 */       if (sample_idx > loop_end) {
/* 143 */         if (this.loop_length <= 1) {
/*     */           break;
/*     */         }
/* 146 */         sample_idx = this.loop_start + (sample_idx - this.loop_start) % this.loop_length;
/*     */       } 
/* 148 */       int max_sample_idx = sample_idx + (sample_frac + (frames - 1) * step >> 15);
/* 149 */       if (max_sample_idx > loop_end) {
/* 150 */         while (sample_idx <= loop_end) {
/* 151 */           int amplitude = this.sample_data[sample_idx];
/* 152 */           amplitude += (this.sample_data[sample_idx + 1] - amplitude) * sample_frac >> 15;
/* 153 */           mix_buffer[offset++] = mix_buffer[offset++] + (amplitude * left_gain >> 15);
/* 154 */           mix_buffer[offset++] = mix_buffer[offset++] + (amplitude * right_gain >> 15);
/* 155 */           sample_frac += step;
/* 156 */           sample_idx += sample_frac >> 15;
/* 157 */           sample_frac &= 0x7FFF;
/*     */         } 
/*     */       } else {
/* 160 */         while (offset <= end) {
/* 161 */           int amplitude = this.sample_data[sample_idx];
/* 162 */           amplitude += (this.sample_data[sample_idx + 1] - amplitude) * sample_frac >> 15;
/* 163 */           mix_buffer[offset++] = mix_buffer[offset++] + (amplitude * left_gain >> 15);
/* 164 */           mix_buffer[offset++] = mix_buffer[offset++] + (amplitude * right_gain >> 15);
/* 165 */           sample_frac += step;
/* 166 */           sample_idx += sample_frac >> 15;
/* 167 */           sample_frac &= 0x7FFF;
/*     */         } 
/*     */       } 
/* 170 */       frames = end - offset + 2 >> 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resample_sinc(int sample_idx, int sample_frac, int step, int left_gain, int right_gain, int[] mix_buffer, int frame_offset, int frames) {
/* 178 */     int loop_end = this.loop_start + this.loop_length - 1;
/* 179 */     int offset = frame_offset << 1;
/* 180 */     int end = frame_offset + frames - 1 << 1;
/* 181 */     while (offset <= end) {
/* 182 */       if (sample_idx > loop_end) {
/* 183 */         if (this.loop_length <= 1) {
/*     */           break;
/*     */         }
/* 186 */         sample_idx = this.loop_start + (sample_idx - this.loop_start) % this.loop_length;
/*     */       } 
/* 188 */       int table_idx = sample_frac >> 11 << 4;
/* 189 */       int a1 = sinc_table[table_idx + 0] * this.sample_data[sample_idx + 0] >> 15;
/* 190 */       a1 += sinc_table[table_idx + 1] * this.sample_data[sample_idx + 1] >> 15;
/* 191 */       a1 += sinc_table[table_idx + 2] * this.sample_data[sample_idx + 2] >> 15;
/* 192 */       a1 += sinc_table[table_idx + 3] * this.sample_data[sample_idx + 3] >> 15;
/* 193 */       a1 += sinc_table[table_idx + 4] * this.sample_data[sample_idx + 4] >> 15;
/* 194 */       a1 += sinc_table[table_idx + 5] * this.sample_data[sample_idx + 5] >> 15;
/* 195 */       a1 += sinc_table[table_idx + 6] * this.sample_data[sample_idx + 6] >> 15;
/* 196 */       a1 += sinc_table[table_idx + 7] * this.sample_data[sample_idx + 7] >> 15;
/* 197 */       a1 += sinc_table[table_idx + 8] * this.sample_data[sample_idx + 8] >> 15;
/* 198 */       a1 += sinc_table[table_idx + 9] * this.sample_data[sample_idx + 9] >> 15;
/* 199 */       a1 += sinc_table[table_idx + 10] * this.sample_data[sample_idx + 10] >> 15;
/* 200 */       a1 += sinc_table[table_idx + 11] * this.sample_data[sample_idx + 11] >> 15;
/* 201 */       a1 += sinc_table[table_idx + 12] * this.sample_data[sample_idx + 12] >> 15;
/* 202 */       a1 += sinc_table[table_idx + 13] * this.sample_data[sample_idx + 13] >> 15;
/* 203 */       a1 += sinc_table[table_idx + 14] * this.sample_data[sample_idx + 14] >> 15;
/* 204 */       a1 += sinc_table[table_idx + 15] * this.sample_data[sample_idx + 15] >> 15;
/* 205 */       int a2 = sinc_table[table_idx + 16] * this.sample_data[sample_idx + 0] >> 15;
/* 206 */       a2 += sinc_table[table_idx + 17] * this.sample_data[sample_idx + 1] >> 15;
/* 207 */       a2 += sinc_table[table_idx + 18] * this.sample_data[sample_idx + 2] >> 15;
/* 208 */       a2 += sinc_table[table_idx + 19] * this.sample_data[sample_idx + 3] >> 15;
/* 209 */       a2 += sinc_table[table_idx + 20] * this.sample_data[sample_idx + 4] >> 15;
/* 210 */       a2 += sinc_table[table_idx + 21] * this.sample_data[sample_idx + 5] >> 15;
/* 211 */       a2 += sinc_table[table_idx + 22] * this.sample_data[sample_idx + 6] >> 15;
/* 212 */       a2 += sinc_table[table_idx + 23] * this.sample_data[sample_idx + 7] >> 15;
/* 213 */       a2 += sinc_table[table_idx + 24] * this.sample_data[sample_idx + 8] >> 15;
/* 214 */       a2 += sinc_table[table_idx + 25] * this.sample_data[sample_idx + 9] >> 15;
/* 215 */       a2 += sinc_table[table_idx + 26] * this.sample_data[sample_idx + 10] >> 15;
/* 216 */       a2 += sinc_table[table_idx + 27] * this.sample_data[sample_idx + 11] >> 15;
/* 217 */       a2 += sinc_table[table_idx + 28] * this.sample_data[sample_idx + 12] >> 15;
/* 218 */       a2 += sinc_table[table_idx + 29] * this.sample_data[sample_idx + 13] >> 15;
/* 219 */       a2 += sinc_table[table_idx + 30] * this.sample_data[sample_idx + 14] >> 15;
/* 220 */       a2 += sinc_table[table_idx + 31] * this.sample_data[sample_idx + 15] >> 15;
/* 221 */       int amplitude = a1 + ((a2 - a1) * (sample_frac & 0x7FF) >> 11);
/* 222 */       mix_buffer[offset] = mix_buffer[offset] + (amplitude * left_gain >> 15);
/* 223 */       mix_buffer[offset + 1] = mix_buffer[offset + 1] + (amplitude * right_gain >> 15);
/* 224 */       offset += 2;
/* 225 */       sample_frac += step;
/* 226 */       sample_idx += sample_frac >> 15;
/* 227 */       sample_frac &= 0x7FFF;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean has_finished(int sample_idx) {
/* 233 */     boolean finished = false;
/* 234 */     if (this.loop_length <= 1 && sample_idx > this.loop_start) {
/* 235 */       finished = true;
/*     */     }
/* 237 */     return finished;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\ibxm\Sample.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */