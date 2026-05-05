/*     */ package ibxm;
/*     */ 
/*     */ public class IBXM {
/*     */   public static final String VERSION = "ibxm alpha 51 (c)2008 mumart@gmail.com";
/*     */   public static final int FP_SHIFT = 15;
/*     */   public static final int FP_ONE = 32768;
/*     */   public static final int FP_MASK = 32767;
/*     */   private int sampling_rate;
/*     */   private int resampling_quality;
/*     */   private int volume_ramp_length;
/*     */   private int tick_length_samples;
/*     */   private int current_tick_samples;
/*     */   private int[] mixing_buffer;
/*     */   private int[] volume_ramp_buffer;
/*     */   private Module module;
/*     */   private Channel[] channels;
/*     */   private int[] global_volume;
/*     */   private int[] note;
/*     */   private int current_sequence_index;
/*     */   private int next_sequence_index;
/*     */   private int current_row;
/*     */   private int next_row;
/*     */   private int tick_counter;
/*     */   private int ticks_per_row;
/*     */   private int pattern_loop_count;
/*     */   private int pattern_loop_channel;
/*     */   
/*     */   public IBXM(int sample_rate) {
/*  29 */     if (sample_rate < 8000) {
/*  30 */       sample_rate = 8000;
/*     */     }
/*  32 */     this.sampling_rate = sample_rate;
/*  33 */     this.volume_ramp_length = this.sampling_rate >> 10;
/*  34 */     this.volume_ramp_buffer = new int[this.volume_ramp_length * 2];
/*  35 */     this.mixing_buffer = new int[this.sampling_rate / 6];
/*  36 */     this.global_volume = new int[1];
/*  37 */     this.note = new int[5];
/*  38 */     set_module(new Module());
/*  39 */     set_resampling_quality(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void set_module(Module m) {
/*  44 */     this.module = m;
/*  45 */     this.channels = new Channel[this.module.get_num_channels()];
/*  46 */     for (int channel_idx = 0; channel_idx < this.channels.length; channel_idx++) {
/*  47 */       this.channels[channel_idx] = new Channel(this.module, this.sampling_rate, this.global_volume);
/*     */     }
/*  49 */     set_sequence_index(0, 0);
/*     */   }
/*     */   
/*     */   public void set_resampling_quality(int quality) {
/*  53 */     this.resampling_quality = quality;
/*     */   }
/*     */ 
/*     */   
/*     */   public int calculate_song_duration() {
/*  58 */     set_sequence_index(0, 0);
/*  59 */     next_tick();
/*  60 */     int song_duration = this.tick_length_samples;
/*  61 */     while (!next_tick()) {
/*  62 */       song_duration += this.tick_length_samples;
/*     */     }
/*  64 */     set_sequence_index(0, 0);
/*  65 */     return song_duration;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set_sequence_index(int sequence_index, int row) {
/*  70 */     this.global_volume[0] = 64;
/*  71 */     for (int channel_idx = 0; channel_idx < this.channels.length; channel_idx++) {
/*  72 */       this.channels[channel_idx].reset();
/*  73 */       this.channels[channel_idx].set_panning(this.module.get_initial_panning(channel_idx));
/*     */     } 
/*  75 */     set_global_volume(this.module.global_volume);
/*  76 */     set_speed(6);
/*  77 */     set_speed(this.module.default_speed);
/*  78 */     set_tempo(125);
/*  79 */     set_tempo(this.module.default_tempo);
/*  80 */     this.pattern_loop_count = -1;
/*  81 */     this.next_sequence_index = sequence_index;
/*  82 */     this.next_row = row;
/*  83 */     this.tick_counter = 0;
/*  84 */     this.current_tick_samples = this.tick_length_samples;
/*  85 */     clear_vol_ramp_buffer();
/*     */   }
/*     */ 
/*     */   
/*     */   public void seek(int sample_position) {
/*  90 */     set_sequence_index(0, 0);
/*  91 */     next_tick();
/*  92 */     while (sample_position > this.tick_length_samples) {
/*  93 */       sample_position -= this.tick_length_samples;
/*  94 */       next_tick();
/*     */     } 
/*  96 */     mix_tick();
/*  97 */     this.current_tick_samples = sample_position;
/*     */   }
/*     */ 
/*     */   
/*     */   public void get_audio(byte[] output_buffer, int frames) {
/* 102 */     int output_idx = 0;
/* 103 */     while (frames > 0) {
/* 104 */       int count = this.tick_length_samples - this.current_tick_samples;
/* 105 */       if (count > frames) {
/* 106 */         count = frames;
/*     */       }
/* 108 */       int mix_idx = this.current_tick_samples << 1;
/* 109 */       int mix_end = mix_idx + (count << 1) - 1;
/* 110 */       while (mix_idx <= mix_end) {
/* 111 */         int amplitude = this.mixing_buffer[mix_idx];
/* 112 */         if (amplitude > 32767) {
/* 113 */           amplitude = 32767;
/*     */         }
/* 115 */         if (amplitude < -32768) {
/* 116 */           amplitude = -32768;
/*     */         }
/* 118 */         output_buffer[output_idx] = (byte)(amplitude >> 8);
/* 119 */         output_buffer[output_idx + 1] = (byte)(amplitude & 0xFF);
/* 120 */         output_idx += 2;
/* 121 */         mix_idx++;
/*     */       } 
/* 123 */       this.current_tick_samples = mix_idx >> 1;
/* 124 */       frames -= count;
/* 125 */       if (frames > 0) {
/* 126 */         next_tick();
/* 127 */         mix_tick();
/* 128 */         this.current_tick_samples = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void mix_tick() {
/* 135 */     int mix_idx = 0;
/* 136 */     int mix_len = this.tick_length_samples + this.volume_ramp_length << 1;
/* 137 */     while (mix_idx < mix_len) {
/* 138 */       this.mixing_buffer[mix_idx] = 0;
/* 139 */       mix_idx++;
/*     */     } 
/* 141 */     for (int channel_idx = 0; channel_idx < this.channels.length; channel_idx++) {
/* 142 */       mix_len = this.tick_length_samples + this.volume_ramp_length;
/* 143 */       this.channels[channel_idx].resample(this.mixing_buffer, 0, mix_len, this.resampling_quality);
/*     */     } 
/* 145 */     volume_ramp();
/*     */   }
/*     */   
/*     */   private boolean next_tick() {
/*     */     boolean song_end;
/*     */     int channel_idx;
/* 151 */     for (channel_idx = 0; channel_idx < this.channels.length; channel_idx++) {
/* 152 */       this.channels[channel_idx].update_sample_idx(this.tick_length_samples);
/*     */     }
/* 154 */     this.tick_counter--;
/* 155 */     if (this.tick_counter <= 0) {
/* 156 */       this.tick_counter = this.ticks_per_row;
/* 157 */       song_end = next_row();
/*     */     } else {
/* 159 */       for (channel_idx = 0; channel_idx < this.channels.length; channel_idx++) {
/* 160 */         this.channels[channel_idx].tick();
/*     */       }
/* 162 */       song_end = false;
/*     */     } 
/* 164 */     return song_end;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean next_row() {
/* 171 */     boolean song_end = false;
/* 172 */     if (this.next_sequence_index < 0) {
/*     */       
/* 174 */       this.next_sequence_index = 0;
/* 175 */       this.next_row = 0;
/*     */     } 
/* 177 */     if (this.next_sequence_index >= this.module.get_sequence_length()) {
/*     */       
/* 179 */       song_end = true;
/* 180 */       this.next_sequence_index = this.module.restart_sequence_index;
/* 181 */       if (this.next_sequence_index < 0) {
/* 182 */         this.next_sequence_index = 0;
/*     */       }
/* 184 */       if (this.next_sequence_index >= this.module.get_sequence_length()) {
/* 185 */         this.next_sequence_index = 0;
/*     */       }
/* 187 */       this.next_row = 0;
/*     */     } 
/* 189 */     if (this.next_sequence_index < this.current_sequence_index)
/*     */     {
/* 191 */       song_end = true;
/*     */     }
/* 193 */     if (this.next_sequence_index == this.current_sequence_index && 
/* 194 */       this.next_row <= this.current_row && 
/* 195 */       this.pattern_loop_count < 0)
/*     */     {
/* 197 */       song_end = true;
/*     */     }
/*     */ 
/*     */     
/* 201 */     this.current_sequence_index = this.next_sequence_index;
/* 202 */     Pattern pattern = this.module.get_pattern_from_sequence(this.current_sequence_index);
/* 203 */     if (this.next_row < 0 || this.next_row >= pattern.num_rows)
/*     */     {
/* 205 */       this.next_row = 0;
/*     */     }
/* 207 */     this.current_row = this.next_row;
/* 208 */     this.next_row = this.current_row + 1;
/* 209 */     if (this.next_row >= pattern.num_rows) {
/* 210 */       this.next_sequence_index = this.current_sequence_index + 1;
/* 211 */       this.next_row = 0;
/*     */     } 
/* 213 */     for (int channel_idx = 0; channel_idx < this.channels.length; channel_idx++) {
/* 214 */       pattern.get_note(this.note, this.current_row * this.channels.length + channel_idx);
/* 215 */       int effect = this.note[3];
/* 216 */       int effect_param = this.note[4];
/* 217 */       this.channels[channel_idx].row(this.note[0], this.note[1], this.note[2], effect, effect_param);
/* 218 */       switch (effect) {
/*     */         
/*     */         case 11:
/* 221 */           if (this.pattern_loop_count < 0) {
/* 222 */             this.next_sequence_index = effect_param;
/* 223 */             this.next_row = 0;
/*     */           } 
/*     */           break;
/*     */         
/*     */         case 13:
/* 228 */           if (this.pattern_loop_count < 0) {
/* 229 */             this.next_sequence_index = this.current_sequence_index + 1;
/* 230 */             this.next_row = (effect_param >> 4) * 10 + (effect_param & 0xF);
/*     */           } 
/*     */           break;
/*     */         
/*     */         case 14:
/* 235 */           switch (effect_param & 0xF0) {
/*     */             
/*     */             case 96:
/* 238 */               if ((effect_param & 0xF) == 0)
/*     */               {
/* 240 */                 (this.channels[channel_idx]).pattern_loop_row = this.current_row;
/*     */               }
/* 242 */               if ((this.channels[channel_idx]).pattern_loop_row < this.current_row) {
/*     */                 
/* 244 */                 if (this.pattern_loop_count < 0) {
/*     */                   
/* 246 */                   this.pattern_loop_count = effect_param & 0xF;
/* 247 */                   this.pattern_loop_channel = channel_idx;
/*     */                 } 
/* 249 */                 if (this.pattern_loop_channel == channel_idx) {
/*     */                   
/* 251 */                   if (this.pattern_loop_count == 0) {
/*     */ 
/*     */                     
/* 254 */                     (this.channels[channel_idx]).pattern_loop_row = this.current_row + 1;
/*     */                   }
/*     */                   else {
/*     */                     
/* 258 */                     this.next_row = (this.channels[channel_idx]).pattern_loop_row;
/* 259 */                     this.next_sequence_index = this.current_sequence_index;
/*     */                   } 
/* 261 */                   this.pattern_loop_count--;
/*     */                 } 
/*     */               } 
/*     */               break;
/*     */             
/*     */             case 224:
/* 267 */               this.tick_counter += this.ticks_per_row * (effect_param & 0xF);
/*     */               break;
/*     */           } 
/*     */           
/*     */           break;
/*     */         case 15:
/* 273 */           if (effect_param < 32) {
/* 274 */             set_speed(effect_param);
/* 275 */             this.tick_counter = this.ticks_per_row; break;
/*     */           } 
/* 277 */           set_tempo(effect_param);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 37:
/* 282 */           set_speed(effect_param);
/* 283 */           this.tick_counter = this.ticks_per_row;
/*     */           break;
/*     */       } 
/*     */     } 
/* 287 */     return song_end;
/*     */   }
/*     */   
/*     */   private void set_global_volume(int volume) {
/* 291 */     if (volume < 0) {
/* 292 */       volume = 0;
/*     */     }
/* 294 */     if (volume > 64) {
/* 295 */       volume = 64;
/*     */     }
/* 297 */     this.global_volume[0] = volume;
/*     */   }
/*     */   
/*     */   private void set_speed(int speed) {
/* 301 */     if (speed > 0 && speed < 256) {
/* 302 */       this.ticks_per_row = speed;
/*     */     }
/*     */   }
/*     */   
/*     */   private void set_tempo(int bpm) {
/* 307 */     if (bpm > 31 && bpm < 256) {
/* 308 */       this.tick_length_samples = this.sampling_rate * 5 / bpm * 2;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void volume_ramp() {
/* 315 */     int sample = 0;
/* 316 */     int volume_ramp_delta = 32768 / this.volume_ramp_length;
/* 317 */     int volume = 0;
/* 318 */     int ramp_idx = 0;
/* 319 */     int next_idx = 2 * this.tick_length_samples;
/* 320 */     int ramp_end = this.volume_ramp_length * 2 - 1;
/* 321 */     while (ramp_idx <= ramp_end) {
/* 322 */       sample = this.volume_ramp_buffer[ramp_idx] * (32768 - volume) >> 15;
/* 323 */       this.mixing_buffer[ramp_idx] = sample + (this.mixing_buffer[ramp_idx] * volume >> 15);
/* 324 */       this.volume_ramp_buffer[ramp_idx] = this.mixing_buffer[next_idx + ramp_idx];
/* 325 */       sample = this.volume_ramp_buffer[ramp_idx + 1] * (32768 - volume) >> 15;
/* 326 */       this.mixing_buffer[ramp_idx + 1] = sample + (this.mixing_buffer[ramp_idx + 1] * volume >> 15);
/* 327 */       this.volume_ramp_buffer[ramp_idx + 1] = this.mixing_buffer[next_idx + ramp_idx + 1];
/* 328 */       volume += volume_ramp_delta;
/* 329 */       ramp_idx += 2;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void clear_vol_ramp_buffer() {
/* 335 */     int ramp_idx = 0;
/* 336 */     int ramp_end = this.volume_ramp_length * 2 - 1;
/* 337 */     while (ramp_idx <= ramp_end) {
/* 338 */       this.volume_ramp_buffer[ramp_idx] = 0;
/* 339 */       ramp_idx++;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\ibxm\IBXM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */