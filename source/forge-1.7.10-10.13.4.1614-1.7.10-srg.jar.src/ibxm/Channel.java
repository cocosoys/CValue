/*     */ package ibxm;public class Channel { public int pattern_loop_row;
/*     */   private Module module;
/*     */   private Instrument instrument;
/*     */   private Sample sample;
/*     */   private int[] global_volume;
/*     */   private int[] current_note;
/*     */   private boolean linear_periods;
/*     */   private boolean fast_volume_slides;
/*     */   private boolean key_on;
/*     */   private boolean silent;
/*     */   private int sample_idx;
/*     */   private int sample_frac;
/*     */   private int step;
/*     */   private int left_gain;
/*     */   private int right_gain;
/*     */   private int volume;
/*     */   private int panning;
/*     */   private int fine_tune;
/*     */   private int period;
/*     */   private int porta_period;
/*  21 */   private static final int LOG_2_29024 = LogTable.log_2(29024); private int key_add; private int tremolo_speed; private int tremolo_depth; private int tremolo_tick; private int tremolo_wave; private int tremolo_add; private int vibrato_speed; private int vibrato_depth; private int vibrato_tick; private int vibrato_wave; private int vibrato_add; private int volume_slide_param; private int portamento_param; private int retrig_param; private int volume_envelope_tick; private int panning_envelope_tick; private int effect_tick; private int trigger_tick; private int fade_out_volume; private int random_seed; private int log_2_sampling_rate;
/*  22 */   private static final int LOG_2_8287 = LogTable.log_2(8287);
/*  23 */   private static final int LOG_2_8363 = LogTable.log_2(8363);
/*  24 */   private static final int LOG_2_1712 = LogTable.log_2(1712);
/*     */   
/*  26 */   private static final int[] sine_table = new int[] { 0, 24, 49, 74, 97, 120, 141, 161, 180, 197, 212, 224, 235, 244, 250, 253, 255, 253, 250, 244, 235, 224, 212, 197, 180, 161, 141, 120, 97, 74, 49, 24 };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Channel(Module mod, int sampling_rate, int[] global_vol) {
/*  32 */     this.module = mod;
/*  33 */     this.global_volume = global_vol;
/*  34 */     this.linear_periods = this.module.linear_periods;
/*  35 */     this.fast_volume_slides = this.module.fast_volume_slides;
/*  36 */     this.current_note = new int[5];
/*  37 */     this.log_2_sampling_rate = LogTable.log_2(sampling_rate);
/*     */   }
/*     */   
/*     */   public void reset() {
/*  41 */     this.tremolo_speed = 0;
/*  42 */     this.tremolo_depth = 0;
/*  43 */     this.tremolo_wave = 0;
/*  44 */     this.vibrato_speed = 0;
/*  45 */     this.vibrato_depth = 0;
/*  46 */     this.vibrato_wave = 0;
/*  47 */     this.volume_slide_param = 0;
/*  48 */     this.portamento_param = 0;
/*  49 */     this.retrig_param = 0;
/*  50 */     this.random_seed = 11256099;
/*  51 */     this.instrument = this.module.get_instrument(0);
/*  52 */     row(48, 256, 0, 0, 0);
/*     */   }
/*     */   
/*     */   public void resample(int[] mixing_buffer, int frame_offset, int frames, int quality) {
/*  56 */     if (!this.silent) {
/*  57 */       switch (quality) {
/*     */         default:
/*  59 */           this.sample.resample_nearest(this.sample_idx, this.sample_frac, this.step, this.left_gain, this.right_gain, mixing_buffer, frame_offset, frames);
/*     */           return;
/*     */         case 1:
/*  62 */           this.sample.resample_linear(this.sample_idx, this.sample_frac, this.step, this.left_gain, this.right_gain, mixing_buffer, frame_offset, frames); return;
/*     */         case 2:
/*     */           break;
/*  65 */       }  this.sample.resample_sinc(this.sample_idx, this.sample_frac, this.step, this.left_gain, this.right_gain, mixing_buffer, frame_offset, frames);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update_sample_idx(int samples) {
/*  72 */     this.sample_frac += this.step * samples;
/*  73 */     this.sample_idx += this.sample_frac >> 15;
/*  74 */     this.sample_frac &= 0x7FFF;
/*     */   }
/*     */   
/*     */   public void set_volume(int vol) {
/*  78 */     if (vol < 0) {
/*  79 */       vol = 0;
/*     */     }
/*  81 */     if (vol > 64) {
/*  82 */       vol = 64;
/*     */     }
/*  84 */     this.volume = vol;
/*     */   }
/*     */   
/*     */   public void set_panning(int pan) {
/*  88 */     if (pan < 0) {
/*  89 */       pan = 0;
/*     */     }
/*  91 */     if (pan > 255) {
/*  92 */       pan = 255;
/*     */     }
/*  94 */     this.panning = pan;
/*     */   }
/*     */   
/*     */   public void row(int key, int inst_idx, int volume_column, int effect, int effect_param) {
/*  98 */     effect &= 0xFF;
/*  99 */     if (effect >= 48)
/*     */     {
/* 101 */       effect = 0;
/*     */     }
/* 103 */     if (effect == 0 && effect_param != 0)
/*     */     {
/* 105 */       effect = 64;
/*     */     }
/* 107 */     if (effect == 14) {
/*     */       
/* 109 */       effect = 48 + ((effect_param & 0xF0) >> 4);
/* 110 */       effect_param &= 0xF;
/*     */     } 
/* 112 */     if (effect == 33) {
/*     */       
/* 114 */       effect = 64 + ((effect_param & 0xF0) >> 4);
/* 115 */       effect_param &= 0xF;
/*     */     } 
/* 117 */     this.current_note[0] = key;
/* 118 */     this.current_note[1] = inst_idx;
/* 119 */     this.current_note[2] = volume_column;
/* 120 */     this.current_note[3] = effect;
/* 121 */     this.current_note[4] = effect_param;
/* 122 */     this.effect_tick = 0;
/* 123 */     this.trigger_tick++;
/* 124 */     update_envelopes();
/* 125 */     this.key_add = 0;
/* 126 */     this.vibrato_add = 0;
/* 127 */     this.tremolo_add = 0;
/* 128 */     if (effect != 61 || effect_param <= 0) {
/*     */       
/* 130 */       trigger(key, inst_idx, volume_column, effect);
/*     */       
/* 132 */       switch (volume_column & 0xF0) {
/*     */         case 0:
/*     */         case 96:
/*     */         case 112:
/*     */           break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 128:
/* 144 */           set_volume(this.volume - (volume_column & 0xF));
/*     */           break;
/*     */         
/*     */         case 144:
/* 148 */           set_volume(this.volume + (volume_column & 0xF));
/*     */           break;
/*     */         
/*     */         case 160:
/* 152 */           set_vibrato_speed(volume_column & 0xF);
/*     */           break;
/*     */         
/*     */         case 176:
/* 156 */           set_vibrato_depth(volume_column & 0xF);
/* 157 */           vibrato();
/*     */           break;
/*     */         
/*     */         case 192:
/* 161 */           set_panning((volume_column & 0xF) << 4);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 208:
/*     */         case 224:
/*     */           break;
/*     */ 
/*     */         
/*     */         case 240:
/* 171 */           set_portamento_param(volume_column & 0xF);
/*     */           break;
/*     */         
/*     */         default:
/* 175 */           set_volume(volume_column - 16);
/*     */           break;
/*     */       } 
/*     */     } 
/* 179 */     if (this.instrument.vibrato_depth > 0) {
/* 180 */       auto_vibrato();
/*     */     }
/* 182 */     switch (effect) {
/*     */       
/*     */       case 1:
/* 185 */         set_portamento_param(effect_param);
/* 186 */         portamento_up();
/*     */         break;
/*     */       
/*     */       case 2:
/* 190 */         set_portamento_param(effect_param);
/* 191 */         portamento_down();
/*     */         break;
/*     */       
/*     */       case 3:
/* 195 */         set_portamento_param(effect_param);
/*     */         break;
/*     */       
/*     */       case 4:
/* 199 */         set_vibrato_speed((effect_param & 0xF0) >> 4);
/* 200 */         set_vibrato_depth(effect_param & 0xF);
/* 201 */         vibrato();
/*     */         break;
/*     */       
/*     */       case 5:
/* 205 */         set_volume_slide_param(effect_param);
/* 206 */         volume_slide();
/*     */         break;
/*     */       
/*     */       case 6:
/* 210 */         set_volume_slide_param(effect_param);
/* 211 */         vibrato();
/* 212 */         volume_slide();
/*     */         break;
/*     */       
/*     */       case 7:
/* 216 */         set_tremolo_speed((effect_param & 0xF0) >> 4);
/* 217 */         set_tremolo_depth(effect_param & 0xF);
/* 218 */         tremolo();
/*     */         break;
/*     */       
/*     */       case 8:
/* 222 */         set_panning(effect_param);
/*     */         break;
/*     */       
/*     */       case 9:
/* 226 */         set_sample_index(effect_param << 8);
/*     */         break;
/*     */       
/*     */       case 10:
/* 230 */         set_volume_slide_param(effect_param);
/* 231 */         volume_slide();
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 12:
/* 238 */         set_volume(effect_param);
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 16:
/* 251 */         set_global_volume(effect_param);
/*     */         break;
/*     */       
/*     */       case 17:
/* 255 */         set_volume_slide_param(effect_param);
/*     */         break;
/*     */       
/*     */       case 20:
/* 259 */         if (effect_param == 0) {
/* 260 */           this.key_on = false;
/*     */         }
/*     */         break;
/*     */       
/*     */       case 21:
/* 265 */         set_envelope_tick(effect_param);
/*     */         break;
/*     */       
/*     */       case 25:
/* 269 */         set_volume_slide_param(effect_param);
/*     */         break;
/*     */       
/*     */       case 27:
/* 273 */         set_retrig_param(effect_param);
/* 274 */         retrig_volume_slide();
/*     */         break;
/*     */       
/*     */       case 29:
/* 278 */         set_retrig_param(effect_param);
/* 279 */         tremor();
/*     */         break;
/*     */       
/*     */       case 36:
/* 283 */         set_vibrato_speed((effect_param & 0xF0) >> 4);
/* 284 */         set_vibrato_depth(effect_param & 0xF);
/* 285 */         fine_vibrato();
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 49:
/* 295 */         set_portamento_param(0xF0 | effect_param);
/* 296 */         portamento_up();
/*     */         break;
/*     */       
/*     */       case 50:
/* 300 */         set_portamento_param(0xF0 | effect_param);
/* 301 */         portamento_down();
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 52:
/* 308 */         set_vibrato_wave(effect_param);
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 55:
/* 318 */         set_tremolo_wave(effect_param);
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 57:
/* 325 */         set_retrig_param(effect_param);
/*     */         break;
/*     */       
/*     */       case 58:
/* 329 */         set_volume_slide_param(effect_param << 4 | 0xF);
/* 330 */         volume_slide();
/*     */         break;
/*     */       
/*     */       case 59:
/* 334 */         set_volume_slide_param(0xF0 | effect_param);
/* 335 */         volume_slide();
/*     */         break;
/*     */       
/*     */       case 60:
/* 339 */         if (effect_param == 0) {
/* 340 */           set_volume(0);
/*     */         }
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 65:
/* 357 */         set_portamento_param(0xE0 | effect_param);
/* 358 */         portamento_up();
/*     */         break;
/*     */       
/*     */       case 66:
/* 362 */         set_portamento_param(0xE0 | effect_param);
/* 363 */         portamento_down();
/*     */         break;
/*     */     } 
/* 366 */     calculate_amplitude();
/* 367 */     calculate_frequency();
/*     */   }
/*     */ 
/*     */   
/*     */   public void tick() {
/* 372 */     int volume_column = this.current_note[2];
/* 373 */     int effect = this.current_note[3];
/* 374 */     int effect_param = this.current_note[4];
/* 375 */     this.effect_tick++;
/* 376 */     if (effect == 61 && effect_param == this.effect_tick) {
/*     */       
/* 378 */       row(this.current_note[0], this.current_note[1], volume_column, 0, 0);
/*     */     } else {
/* 380 */       this.trigger_tick++;
/* 381 */       this.vibrato_tick++;
/* 382 */       this.tremolo_tick++;
/* 383 */       update_envelopes();
/* 384 */       this.key_add = 0;
/* 385 */       this.vibrato_add = 0;
/* 386 */       this.tremolo_add = 0;
/* 387 */       if (this.instrument.vibrato_depth > 0) {
/* 388 */         auto_vibrato();
/*     */       }
/* 390 */       switch (volume_column & 0xF0) {
/*     */         
/*     */         case 96:
/* 393 */           set_volume(this.volume - (volume_column & 0xF));
/*     */           break;
/*     */         
/*     */         case 112:
/* 397 */           set_volume(this.volume + (volume_column & 0xF));
/*     */           break;
/*     */         
/*     */         case 176:
/* 401 */           vibrato();
/*     */           break;
/*     */         
/*     */         case 208:
/* 405 */           set_panning(this.panning - (volume_column & 0xF));
/*     */           break;
/*     */         
/*     */         case 224:
/* 409 */           set_panning(this.panning + (volume_column & 0xF));
/*     */           break;
/*     */         
/*     */         case 240:
/* 413 */           tone_portamento();
/*     */           break;
/*     */       } 
/* 416 */       switch (effect) {
/*     */         
/*     */         case 1:
/* 419 */           portamento_up();
/*     */           break;
/*     */         
/*     */         case 2:
/* 423 */           portamento_down();
/*     */           break;
/*     */         
/*     */         case 3:
/* 427 */           tone_portamento();
/*     */           break;
/*     */         
/*     */         case 4:
/* 431 */           vibrato();
/*     */           break;
/*     */         
/*     */         case 5:
/* 435 */           tone_portamento();
/* 436 */           volume_slide();
/*     */           break;
/*     */         
/*     */         case 6:
/* 440 */           vibrato();
/* 441 */           volume_slide();
/*     */           break;
/*     */         
/*     */         case 7:
/* 445 */           tremolo();
/*     */           break;
/*     */         
/*     */         case 10:
/* 449 */           volume_slide();
/*     */           break;
/*     */         
/*     */         case 17:
/* 453 */           global_volume_slide();
/*     */           break;
/*     */         
/*     */         case 20:
/* 457 */           if (this.effect_tick == effect_param) {
/* 458 */             this.key_on = false;
/*     */           }
/*     */           break;
/*     */         
/*     */         case 25:
/* 463 */           panning_slide();
/*     */           break;
/*     */         
/*     */         case 27:
/* 467 */           retrig_volume_slide();
/*     */           break;
/*     */         
/*     */         case 29:
/* 471 */           tremor();
/*     */           break;
/*     */         
/*     */         case 36:
/* 475 */           fine_vibrato();
/*     */           break;
/*     */         
/*     */         case 57:
/* 479 */           retrig_volume_slide();
/*     */           break;
/*     */         
/*     */         case 60:
/* 483 */           if (this.effect_tick == effect_param) {
/* 484 */             set_volume(0);
/*     */           }
/*     */           break;
/*     */         
/*     */         case 64:
/* 489 */           switch (this.effect_tick % 3) {
/*     */             case 1:
/* 491 */               this.key_add = (effect_param & 0xF0) >> 4;
/*     */               break;
/*     */             case 2:
/* 494 */               this.key_add = effect_param & 0xF;
/*     */               break;
/*     */           } 
/*     */           break;
/*     */       } 
/*     */     } 
/* 500 */     calculate_amplitude();
/* 501 */     calculate_frequency();
/*     */   }
/*     */   
/*     */   private void set_vibrato_speed(int speed) {
/* 505 */     if (speed > 0) {
/* 506 */       this.vibrato_speed = speed;
/*     */     }
/*     */   }
/*     */   
/*     */   private void set_vibrato_depth(int depth) {
/* 511 */     if (depth > 0) {
/* 512 */       this.vibrato_depth = depth;
/*     */     }
/*     */   }
/*     */   
/*     */   private void set_vibrato_wave(int wave) {
/* 517 */     if (wave < 0 || wave > 7) {
/* 518 */       wave = 0;
/*     */     }
/* 520 */     this.vibrato_wave = wave;
/*     */   }
/*     */   
/*     */   private void set_tremolo_speed(int speed) {
/* 524 */     if (speed > 0) {
/* 525 */       this.tremolo_speed = speed;
/*     */     }
/*     */   }
/*     */   
/*     */   private void set_tremolo_depth(int depth) {
/* 530 */     if (depth > 0) {
/* 531 */       this.tremolo_depth = depth;
/*     */     }
/*     */   }
/*     */   
/*     */   private void set_tremolo_wave(int wave) {
/* 536 */     if (wave < 0 || wave > 7) {
/* 537 */       wave = 0;
/*     */     }
/* 539 */     this.tremolo_wave = wave;
/*     */   }
/*     */ 
/*     */   
/*     */   private void vibrato() {
/* 544 */     int vibrato_phase = this.vibrato_tick * this.vibrato_speed;
/* 545 */     this.vibrato_add += waveform(vibrato_phase, this.vibrato_wave) * this.vibrato_depth >> 5;
/*     */   }
/*     */ 
/*     */   
/*     */   private void fine_vibrato() {
/* 550 */     int vibrato_phase = this.vibrato_tick * this.vibrato_speed;
/* 551 */     this.vibrato_add += waveform(vibrato_phase, this.vibrato_wave) * this.vibrato_depth >> 7;
/*     */   }
/*     */ 
/*     */   
/*     */   private void tremolo() {
/* 556 */     int tremolo_phase = this.tremolo_tick * this.tremolo_speed;
/* 557 */     this.tremolo_add += waveform(tremolo_phase, this.tremolo_wave) * this.tremolo_depth >> 6;
/*     */   }
/*     */   
/*     */   private void set_portamento_param(int param) {
/* 561 */     if (param != 0) {
/* 562 */       this.portamento_param = param;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void tone_portamento() {
/* 568 */     if (this.porta_period < this.period) {
/* 569 */       int new_period = this.period - (this.portamento_param << 2);
/* 570 */       if (new_period < this.porta_period) {
/* 571 */         new_period = this.porta_period;
/*     */       }
/* 573 */       set_period(new_period);
/*     */     } 
/* 575 */     if (this.porta_period > this.period) {
/* 576 */       int new_period = this.period + (this.portamento_param << 2);
/* 577 */       if (new_period > this.porta_period) {
/* 578 */         new_period = this.porta_period;
/*     */       }
/* 580 */       set_period(new_period);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void portamento_up() {
/* 585 */     if ((this.portamento_param & 0xF0) == 224) {
/*     */       
/* 587 */       if (this.effect_tick == 0) {
/* 588 */         set_period(this.period - (this.portamento_param & 0xF));
/*     */       }
/* 590 */     } else if ((this.portamento_param & 0xF0) == 240) {
/*     */       
/* 592 */       if (this.effect_tick == 0) {
/* 593 */         set_period(this.period - ((this.portamento_param & 0xF) << 2));
/*     */       
/*     */       }
/*     */     }
/* 597 */     else if (this.effect_tick > 0) {
/* 598 */       set_period(this.period - (this.portamento_param << 2));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void portamento_down() {
/* 604 */     if ((this.portamento_param & 0xF0) == 224) {
/*     */       
/* 606 */       if (this.effect_tick == 0) {
/* 607 */         set_period(this.period + (this.portamento_param & 0xF));
/*     */       }
/* 609 */     } else if ((this.portamento_param & 0xF0) == 240) {
/*     */       
/* 611 */       if (this.effect_tick == 0) {
/* 612 */         set_period(this.period + ((this.portamento_param & 0xF) << 2));
/*     */       
/*     */       }
/*     */     }
/* 616 */     else if (this.effect_tick > 0) {
/* 617 */       set_period(this.period + (this.portamento_param << 2));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void set_period(int p) {
/* 623 */     if (p < 32) {
/* 624 */       p = 32;
/*     */     }
/* 626 */     if (p > 32768) {
/* 627 */       p = 32768;
/*     */     }
/* 629 */     this.period = p;
/*     */   }
/*     */   
/*     */   private void set_global_volume(int vol) {
/* 633 */     if (vol < 0) {
/* 634 */       vol = 0;
/*     */     }
/* 636 */     if (vol > 64) {
/* 637 */       vol = 64;
/*     */     }
/* 639 */     this.global_volume[0] = vol;
/*     */   }
/*     */   
/*     */   private void set_volume_slide_param(int param) {
/* 643 */     if (param != 0) {
/* 644 */       this.volume_slide_param = param;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void global_volume_slide() {
/* 650 */     int up = (this.volume_slide_param & 0xF0) >> 4;
/* 651 */     int down = this.volume_slide_param & 0xF;
/* 652 */     set_global_volume(this.global_volume[0] + up - down);
/*     */   }
/*     */ 
/*     */   
/*     */   private void volume_slide() {
/* 657 */     int up = (this.volume_slide_param & 0xF0) >> 4;
/* 658 */     int down = this.volume_slide_param & 0xF;
/* 659 */     if (down == 15 && up > 0) {
/*     */       
/* 661 */       if (this.effect_tick == 0) {
/* 662 */         set_volume(this.volume + up);
/*     */       }
/* 664 */     } else if (up == 15 && down > 0) {
/*     */       
/* 666 */       if (this.effect_tick == 0) {
/* 667 */         set_volume(this.volume - down);
/*     */       
/*     */       }
/*     */     }
/* 671 */     else if (this.effect_tick > 0 || this.fast_volume_slides) {
/* 672 */       set_volume(this.volume + up - down);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void panning_slide() {
/* 679 */     int left = (this.volume_slide_param & 0xF0) >> 4;
/* 680 */     int right = this.volume_slide_param & 0xF;
/* 681 */     set_panning(this.panning - left + right);
/*     */   }
/*     */   
/*     */   private void set_retrig_param(int param) {
/* 685 */     if (param != 0) {
/* 686 */       this.retrig_param = param;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void tremor() {
/* 692 */     int on_ticks = ((this.retrig_param & 0xF0) >> 4) + 1;
/* 693 */     int cycle_length = on_ticks + (this.retrig_param & 0xF) + 1;
/* 694 */     int cycle_index = this.trigger_tick % cycle_length;
/* 695 */     if (cycle_index >= on_ticks) {
/* 696 */       this.tremolo_add = -64;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void retrig_volume_slide() {
/* 702 */     int retrig_volume = (this.retrig_param & 0xF0) >> 4;
/* 703 */     int retrig_tick = this.retrig_param & 0xF;
/* 704 */     if (retrig_tick > 0 && this.trigger_tick % retrig_tick == 0) {
/* 705 */       set_sample_index(0);
/* 706 */       switch (retrig_volume) {
/*     */         case 1:
/* 708 */           set_volume(this.volume - 1);
/*     */           break;
/*     */         case 2:
/* 711 */           set_volume(this.volume - 2);
/*     */           break;
/*     */         case 3:
/* 714 */           set_volume(this.volume - 4);
/*     */           break;
/*     */         case 4:
/* 717 */           set_volume(this.volume - 8);
/*     */           break;
/*     */         case 5:
/* 720 */           set_volume(this.volume - 16);
/*     */           break;
/*     */         case 6:
/* 723 */           set_volume(this.volume - this.volume / 3);
/*     */           break;
/*     */         case 7:
/* 726 */           set_volume(this.volume / 2);
/*     */           break;
/*     */         case 9:
/* 729 */           set_volume(this.volume + 1);
/*     */           break;
/*     */         case 10:
/* 732 */           set_volume(this.volume + 2);
/*     */           break;
/*     */         case 11:
/* 735 */           set_volume(this.volume + 4);
/*     */           break;
/*     */         case 12:
/* 738 */           set_volume(this.volume + 8);
/*     */           break;
/*     */         case 13:
/* 741 */           set_volume(this.volume + 16);
/*     */           break;
/*     */         case 14:
/* 744 */           set_volume(this.volume + this.volume / 2);
/*     */           break;
/*     */         case 15:
/* 747 */           set_volume(this.volume * 2);
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void set_sample_index(int index) {
/* 754 */     if (index < 0) {
/* 755 */       index = 0;
/*     */     }
/* 757 */     this.sample_idx = index;
/* 758 */     this.sample_frac = 0;
/*     */   }
/*     */   
/*     */   private void set_envelope_tick(int tick) {
/* 762 */     this.volume_envelope_tick = tick;
/* 763 */     this.panning_envelope_tick = tick;
/*     */   }
/*     */   
/*     */   private void trigger(int key, int instrument_idx, int volume_column, int effect) {
/* 767 */     if (instrument_idx > 0) {
/* 768 */       this.instrument = this.module.get_instrument(instrument_idx);
/* 769 */       this.sample = this.instrument.get_sample_from_key(key);
/* 770 */       set_volume(this.sample.volume);
/* 771 */       if (this.sample.set_panning) {
/* 772 */         set_panning(this.sample.panning);
/*     */       }
/* 774 */       set_envelope_tick(0);
/* 775 */       this.fade_out_volume = 32768;
/* 776 */       this.key_on = true;
/*     */     } 
/* 778 */     if (key > 0) {
/* 779 */       if (key < 97) {
/* 780 */         this.porta_period = key_to_period(key);
/* 781 */         if (effect != 3 && effect != 5 && (
/* 782 */           volume_column & 0xF0) != 240)
/*     */         {
/* 784 */           this.trigger_tick = 0;
/* 785 */           if (this.vibrato_wave < 4) {
/* 786 */             this.vibrato_tick = 0;
/*     */           }
/* 788 */           if (this.tremolo_wave < 4) {
/* 789 */             this.tremolo_tick = 0;
/*     */           }
/* 791 */           set_period(this.porta_period);
/* 792 */           set_sample_index(0);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 797 */         this.key_on = false;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void update_envelopes() {
/* 804 */     if (this.instrument.volume_envelope_active) {
/* 805 */       if (!this.key_on) {
/* 806 */         this.fade_out_volume -= this.instrument.volume_fade_out & 0xFFFF;
/* 807 */         if (this.fade_out_volume < 0) {
/* 808 */           this.fade_out_volume = 0;
/*     */         }
/*     */       } 
/* 811 */       Envelope envelope = this.instrument.get_volume_envelope();
/* 812 */       this.volume_envelope_tick = envelope.next_tick(this.volume_envelope_tick, this.key_on);
/*     */     } 
/* 814 */     if (this.instrument.panning_envelope_active) {
/* 815 */       Envelope envelope = this.instrument.get_panning_envelope();
/* 816 */       this.panning_envelope_tick = envelope.next_tick(this.panning_envelope_tick, this.key_on);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void auto_vibrato() {
/* 822 */     int sweep = this.instrument.vibrato_sweep & 0xFF;
/* 823 */     int depth = this.instrument.vibrato_depth & 0xF;
/* 824 */     int rate = this.instrument.vibrato_rate & 0x3F;
/* 825 */     if (this.trigger_tick < sweep) {
/* 826 */       depth = depth * this.trigger_tick / sweep;
/*     */     }
/* 828 */     this.vibrato_add += waveform(this.trigger_tick * rate, 0) * depth >> 9;
/*     */   }
/*     */ 
/*     */   
/*     */   private int waveform(int phase, int wform) {
/* 833 */     int amplitude = 0;
/* 834 */     switch (wform & 0x3) {
/*     */       
/*     */       case 0:
/* 837 */         if ((phase & 0x20) == 0) {
/* 838 */           amplitude = sine_table[phase & 0x1F]; break;
/*     */         } 
/* 840 */         amplitude = -sine_table[phase & 0x1F];
/*     */         break;
/*     */ 
/*     */       
/*     */       case 1:
/* 845 */         if ((phase & 0x20) == 0) {
/* 846 */           amplitude = (phase & 0x1F) << 3; break;
/*     */         } 
/* 848 */         amplitude = ((phase & 0x1F) << 3) - 255;
/*     */         break;
/*     */ 
/*     */       
/*     */       case 2:
/* 853 */         if ((phase & 0x20) == 0) {
/* 854 */           amplitude = 255; break;
/*     */         } 
/* 856 */         amplitude = -255;
/*     */         break;
/*     */ 
/*     */       
/*     */       case 3:
/* 861 */         amplitude = (this.random_seed >> 15) - 255;
/* 862 */         this.random_seed = this.random_seed * 65 + 17 & 0xFFFFFF;
/*     */         break;
/*     */     } 
/* 865 */     return amplitude;
/*     */   }
/*     */ 
/*     */   
/*     */   private int key_to_period(int key) {
/* 870 */     int period_out, octave = (key << 15) / 12 + this.sample.transpose;
/* 871 */     if (this.linear_periods) {
/* 872 */       period_out = 7744 - (octave * 768 >> 15);
/*     */     } else {
/* 874 */       int log_2_period = LOG_2_29024 - octave;
/* 875 */       period_out = LogTable.raise_2(log_2_period);
/* 876 */       period_out >>= 14;
/* 877 */       period_out = (period_out >> 1) + (period_out & 0x1);
/*     */     } 
/* 879 */     return period_out;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void calculate_amplitude() {
/* 886 */     int envelope_volume = 0;
/* 887 */     if (this.instrument.volume_envelope_active) {
/* 888 */       Envelope envelope = this.instrument.get_volume_envelope();
/* 889 */       envelope_volume = envelope.calculate_ampl(this.volume_envelope_tick);
/*     */     }
/* 891 */     else if (this.key_on) {
/* 892 */       envelope_volume = 64;
/*     */     } 
/*     */     
/* 895 */     int tremolo_volume = this.volume + this.tremolo_add;
/* 896 */     if (tremolo_volume < 0) {
/* 897 */       tremolo_volume = 0;
/*     */     }
/* 899 */     if (tremolo_volume > 64) {
/* 900 */       tremolo_volume = 64;
/*     */     }
/* 902 */     int amplitude = tremolo_volume << 9;
/* 903 */     amplitude = amplitude * envelope_volume >> 6;
/* 904 */     amplitude = amplitude * this.fade_out_volume >> 15;
/* 905 */     amplitude = amplitude * this.global_volume[0] >> 6;
/* 906 */     amplitude = amplitude * this.module.channel_gain >> 15;
/* 907 */     this.silent = this.sample.has_finished(this.sample_idx);
/* 908 */     if (amplitude <= 0) {
/* 909 */       this.silent = true;
/*     */     } else {
/* 911 */       int envelope_panning = 32;
/* 912 */       if (this.instrument.panning_envelope_active) {
/* 913 */         Envelope envelope = this.instrument.get_panning_envelope();
/* 914 */         envelope_panning = envelope.calculate_ampl(this.panning_envelope_tick);
/*     */       } 
/* 916 */       int mixer_panning = (this.panning & 0xFF) << 7;
/* 917 */       int panning_range = 32768 - mixer_panning;
/* 918 */       if (panning_range > mixer_panning) {
/* 919 */         panning_range = mixer_panning;
/*     */       }
/* 921 */       mixer_panning += panning_range * (envelope_panning - 32) >> 5;
/* 922 */       this.left_gain = amplitude * (32768 - mixer_panning) >> 15;
/* 923 */       this.right_gain = amplitude * mixer_panning >> 15;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void calculate_frequency() {
/* 929 */     int log_2_freq, vibrato_period = this.period + this.vibrato_add;
/* 930 */     if (vibrato_period < 32) {
/* 931 */       vibrato_period = 32;
/*     */     }
/* 933 */     if (vibrato_period > 32768) {
/* 934 */       vibrato_period = 32768;
/*     */     }
/* 936 */     if (this.linear_periods) {
/* 937 */       log_2_freq = LOG_2_8363 + (4608 - vibrato_period << 15) / 768;
/*     */     } else {
/* 939 */       log_2_freq = this.module.pal ? LOG_2_8287 : LOG_2_8363;
/* 940 */       log_2_freq = log_2_freq + LOG_2_1712 - LogTable.log_2(vibrato_period);
/*     */     } 
/* 942 */     log_2_freq += (this.key_add << 15) / 12;
/* 943 */     this.step = LogTable.raise_2(log_2_freq - this.log_2_sampling_rate);
/*     */   } }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\ibxm\Channel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */