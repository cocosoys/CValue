/*     */ package ibxm;
/*     */ import java.io.DataInput;
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class ScreamTracker3 {
/*   7 */   private static final int[] effect_map = new int[] { 255, 37, 11, 13, 10, 2, 1, 3, 4, 29, 0, 6, 5, 255, 255, 9, 255, 27, 7, 14, 15, 36, 16, 255, 255, 255, 255, 255, 255, 255, 255, 255 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   private static final int[] effect_s_map = new int[] { 0, 3, 5, 4, 7, 255, 255, 255, 8, 255, 9, 6, 12, 13, 14, 15 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean is_s3m(byte[] header_96_bytes) {
/*  56 */     String s3m_identifier = ascii_text(header_96_bytes, 44, 4);
/*  57 */     return s3m_identifier.equals("SCRM");
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
/*     */   public static Module load_s3m(byte[] header_96_bytes, DataInput data_input) throws IOException {
/*  69 */     byte[] s3m_file = read_s3m_file(header_96_bytes, data_input);
/*  70 */     Module module = new Module();
/*  71 */     module.song_title = ascii_text(s3m_file, 0, 28);
/*  72 */     int num_pattern_orders = get_num_pattern_orders(s3m_file);
/*  73 */     int num_instruments = get_num_instruments(s3m_file);
/*  74 */     int num_patterns = get_num_patterns(s3m_file);
/*  75 */     int flags = unsigned_short_le(s3m_file, 38);
/*  76 */     int tracker_version = unsigned_short_le(s3m_file, 40);
/*  77 */     if ((flags & 0x40) == 64 || tracker_version == 4864) {
/*  78 */       module.fast_volume_slides = true;
/*     */     }
/*  80 */     boolean signed_samples = false;
/*  81 */     if (unsigned_short_le(s3m_file, 42) == 1) {
/*  82 */       signed_samples = true;
/*     */     }
/*  84 */     module.global_volume = s3m_file[48] & 0xFF;
/*  85 */     module.default_speed = s3m_file[49] & 0xFF;
/*  86 */     module.default_tempo = s3m_file[50] & 0xFF;
/*  87 */     int master_volume = s3m_file[51] & Byte.MAX_VALUE;
/*  88 */     module.channel_gain = master_volume << 15 >> 7;
/*  89 */     boolean stereo_mode = ((s3m_file[51] & 0x80) == 128);
/*  90 */     boolean default_panning = ((s3m_file[53] & 0xFF) == 252);
/*  91 */     int[] channel_map = new int[32];
/*  92 */     int num_channels = 0; int channel_idx;
/*  93 */     for (channel_idx = 0; channel_idx < 32; channel_idx++) {
/*  94 */       int channel_config = s3m_file[64 + channel_idx] & 0xFF;
/*  95 */       channel_map[channel_idx] = -1;
/*  96 */       if (channel_config < 16) {
/*  97 */         channel_map[channel_idx] = num_channels;
/*  98 */         num_channels++;
/*     */       } 
/*     */     } 
/* 101 */     module.set_num_channels(num_channels);
/* 102 */     int panning_offset = 96 + num_pattern_orders + num_instruments * 2 + num_patterns * 2;
/* 103 */     for (channel_idx = 0; channel_idx < 32; channel_idx++) {
/* 104 */       if (channel_map[channel_idx] >= 0) {
/* 105 */         int panning = 7;
/* 106 */         if (stereo_mode) {
/* 107 */           panning = 12;
/* 108 */           if ((s3m_file[64 + channel_idx] & 0xFF) < 8) {
/* 109 */             panning = 3;
/*     */           }
/*     */         } 
/* 112 */         if (default_panning) {
/* 113 */           flags = s3m_file[panning_offset + channel_idx] & 0xFF;
/* 114 */           if ((flags & 0x20) == 32) {
/* 115 */             panning = flags & 0xF;
/*     */           }
/*     */         } 
/* 118 */         module.set_initial_panning(channel_map[channel_idx], panning * 17);
/*     */       } 
/* 120 */     }  int[] sequence = read_s3m_sequence(s3m_file);
/* 121 */     module.set_sequence_length(sequence.length);
/* 122 */     for (int order_idx = 0; order_idx < sequence.length; order_idx++) {
/* 123 */       module.set_sequence(order_idx, sequence[order_idx]);
/*     */     }
/* 125 */     module.set_num_instruments(num_instruments);
/* 126 */     for (int instrument_idx = 0; instrument_idx < num_instruments; instrument_idx++) {
/* 127 */       Instrument instrument = read_s3m_instrument(s3m_file, instrument_idx, signed_samples);
/* 128 */       module.set_instrument(instrument_idx + 1, instrument);
/*     */     } 
/* 130 */     module.set_num_patterns(num_patterns);
/* 131 */     for (int pattern_idx = 0; pattern_idx < num_patterns; pattern_idx++) {
/* 132 */       module.set_pattern(pattern_idx, read_s3m_pattern(s3m_file, pattern_idx, channel_map));
/*     */     }
/* 134 */     return module;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int[] read_s3m_sequence(byte[] s3m_file) {
/* 141 */     int num_pattern_orders = get_num_pattern_orders(s3m_file);
/* 142 */     int sequence_length = 0; int order_idx;
/* 143 */     for (order_idx = 0; order_idx < num_pattern_orders; order_idx++) {
/* 144 */       int pattern_order = s3m_file[96 + order_idx] & 0xFF;
/* 145 */       if (pattern_order == 255)
/*     */         break; 
/* 147 */       if (pattern_order < 254) {
/* 148 */         sequence_length++;
/*     */       }
/*     */     } 
/* 151 */     int[] sequence = new int[sequence_length];
/* 152 */     int sequence_idx = 0;
/* 153 */     for (order_idx = 0; order_idx < num_pattern_orders; order_idx++) {
/* 154 */       int pattern_order = s3m_file[96 + order_idx] & 0xFF;
/* 155 */       if (pattern_order == 255)
/*     */         break; 
/* 157 */       if (pattern_order < 254) {
/* 158 */         sequence[sequence_idx] = pattern_order;
/* 159 */         sequence_idx++;
/*     */       } 
/*     */     } 
/* 162 */     return sequence;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Instrument read_s3m_instrument(byte[] s3m_file, int instrument_idx, boolean signed_samples) {
/* 173 */     int instrument_offset = get_instrument_offset(s3m_file, instrument_idx);
/* 174 */     Instrument instrument = new Instrument();
/* 175 */     instrument.name = ascii_text(s3m_file, instrument_offset + 48, 28);
/* 176 */     Sample sample = new Sample();
/* 177 */     if (s3m_file[instrument_offset] == 1) {
/* 178 */       short[] sample_data; int sample_data_length = get_sample_data_length(s3m_file, instrument_offset);
/* 179 */       int loop_start = unsigned_short_le(s3m_file, instrument_offset + 20);
/* 180 */       int loop_length = unsigned_short_le(s3m_file, instrument_offset + 24) - loop_start;
/* 181 */       sample.volume = s3m_file[instrument_offset + 28] & 0xFF;
/* 182 */       if (s3m_file[instrument_offset + 30] != 0) {
/* 183 */         throw new IllegalArgumentException("ScreamTracker3: Packed samples not supported!");
/*     */       }
/* 185 */       if ((s3m_file[instrument_offset + 31] & 0x1) == 0) {
/* 186 */         loop_length = 0;
/*     */       }
/* 188 */       if ((s3m_file[instrument_offset + 31] & 0x2) != 0) {
/* 189 */         throw new IllegalArgumentException("ScreamTracker3: Stereo samples not supported!");
/*     */       }
/* 191 */       boolean sixteen_bit = ((s3m_file[instrument_offset + 31] & 0x4) != 0);
/* 192 */       int c2_rate = unsigned_short_le(s3m_file, instrument_offset + 32);
/* 193 */       sample.transpose = LogTable.log_2(c2_rate) - LogTable.log_2(8363);
/* 194 */       int sample_data_offset = get_sample_data_offset(s3m_file, instrument_offset);
/* 195 */       if (sixteen_bit) {
/* 196 */         if (signed_samples) {
/* 197 */           throw new IllegalArgumentException("ScreamTracker3: Signed 16-bit samples not supported!");
/*     */         }
/* 199 */         sample_data_length >>= 1;
/* 200 */         sample_data = new short[sample_data_length];
/* 201 */         for (int sample_idx = 0; sample_idx < sample_data_length; sample_idx++) {
/* 202 */           int amplitude = s3m_file[sample_data_offset + sample_idx * 2] & 0xFF;
/* 203 */           amplitude |= (s3m_file[sample_data_offset + sample_idx * 2 + 1] & 0xFF) << 8;
/* 204 */           sample_data[sample_idx] = (short)(amplitude - 32768);
/*     */         } 
/*     */       } else {
/* 207 */         sample_data = new short[sample_data_length];
/* 208 */         if (signed_samples) {
/* 209 */           for (int sample_idx = 0; sample_idx < sample_data_length; sample_idx++) {
/* 210 */             int amplitude = s3m_file[sample_data_offset + sample_idx] << 8;
/* 211 */             sample_data[sample_idx] = (short)amplitude;
/*     */           } 
/*     */         } else {
/* 214 */           for (int sample_idx = 0; sample_idx < sample_data_length; sample_idx++) {
/* 215 */             int amplitude = (s3m_file[sample_data_offset + sample_idx] & 0xFF) << 8;
/* 216 */             sample_data[sample_idx] = (short)(amplitude - 32768);
/*     */           } 
/*     */         } 
/*     */       } 
/* 220 */       sample.set_sample_data(sample_data, loop_start, loop_length, false);
/*     */     } 
/* 222 */     instrument.set_num_samples(1);
/* 223 */     instrument.set_sample(0, sample);
/* 224 */     return instrument;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Pattern read_s3m_pattern(byte[] s3m_file, int pattern_idx, int[] channel_map) {
/* 234 */     int num_channels = 0; int channel_idx;
/* 235 */     for (channel_idx = 0; channel_idx < 32; channel_idx++) {
/* 236 */       if (channel_map[channel_idx] >= num_channels) {
/* 237 */         num_channels = channel_idx + 1;
/*     */       }
/*     */     } 
/* 240 */     int num_notes = num_channels * 64;
/* 241 */     byte[] pattern_data = new byte[num_notes * 5];
/* 242 */     int row_idx = 0;
/* 243 */     int pattern_offset = get_pattern_offset(s3m_file, pattern_idx) + 2;
/* 244 */     while (row_idx < 64) {
/* 245 */       int token = s3m_file[pattern_offset] & 0xFF;
/* 246 */       pattern_offset++;
/* 247 */       if (token > 0) {
/* 248 */         channel_idx = channel_map[token & 0x1F];
/* 249 */         int note_idx = (num_channels * row_idx + channel_idx) * 5;
/* 250 */         if ((token & 0x20) == 32) {
/*     */           
/* 252 */           if (channel_idx >= 0) {
/* 253 */             int key = s3m_file[pattern_offset] & 0xFF;
/* 254 */             if (key == 255) {
/* 255 */               key = 0;
/* 256 */             } else if (key == 254) {
/* 257 */               key = 97;
/*     */             } else {
/* 259 */               key = ((key & 0xF0) >> 4) * 12 + (key & 0xF) + 1;
/* 260 */               while (key > 96) {
/* 261 */                 key -= 12;
/*     */               }
/*     */             } 
/* 264 */             pattern_data[note_idx] = (byte)key;
/* 265 */             pattern_data[note_idx + 1] = s3m_file[pattern_offset + 1];
/*     */           } 
/* 267 */           pattern_offset += 2;
/*     */         } 
/* 269 */         if ((token & 0x40) == 64) {
/*     */           
/* 271 */           if (channel_idx >= 0) {
/* 272 */             int volume_column = (s3m_file[pattern_offset] & 0xFF) + 16;
/* 273 */             pattern_data[note_idx + 2] = (byte)volume_column;
/*     */           } 
/* 275 */           pattern_offset++;
/*     */         } 
/* 277 */         if ((token & 0x80) == 128) {
/*     */           
/* 279 */           if (channel_idx >= 0) {
/* 280 */             int effect = s3m_file[pattern_offset] & 0xFF;
/* 281 */             int effect_param = s3m_file[pattern_offset + 1] & 0xFF;
/* 282 */             effect = effect_map[effect & 0x1F];
/* 283 */             if (effect == 255) {
/* 284 */               effect = 0;
/* 285 */               effect_param = 0;
/*     */             } 
/* 287 */             if (effect == 14) {
/* 288 */               effect = effect_s_map[(effect_param & 0xF0) >> 4];
/* 289 */               effect_param &= 0xF;
/* 290 */               switch (effect) {
/*     */                 case 8:
/* 292 */                   effect = 8;
/* 293 */                   effect_param *= 17;
/*     */                   break;
/*     */                 case 9:
/* 296 */                   effect = 8;
/* 297 */                   if (effect_param > 7) {
/* 298 */                     effect_param -= 8;
/*     */                   } else {
/* 300 */                     effect_param += 8;
/*     */                   } 
/* 302 */                   effect_param *= 17;
/*     */                   break;
/*     */                 case 255:
/* 305 */                   effect = 0;
/* 306 */                   effect_param = 0;
/*     */                   break;
/*     */                 default:
/* 309 */                   effect_param = (effect & 0xF) << 4 | effect_param & 0xF;
/* 310 */                   effect = 14;
/*     */                   break;
/*     */               } 
/*     */             } 
/* 314 */             pattern_data[note_idx + 3] = (byte)effect;
/* 315 */             pattern_data[note_idx + 4] = (byte)effect_param;
/*     */           } 
/* 317 */           pattern_offset += 2;
/*     */         }  continue;
/*     */       } 
/* 320 */       row_idx++;
/*     */     } 
/*     */     
/* 323 */     Pattern pattern = new Pattern();
/* 324 */     pattern.num_rows = 64;
/* 325 */     pattern.set_pattern_data(pattern_data);
/* 326 */     return pattern;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte[] read_s3m_file(byte[] header_96_bytes, DataInput data_input) throws IOException {
/* 335 */     if (!is_s3m(header_96_bytes)) {
/* 336 */       throw new IllegalArgumentException("ScreamTracker3: Not an S3M file!");
/*     */     }
/* 338 */     byte[] s3m_file = header_96_bytes;
/* 339 */     int s3m_file_length = header_96_bytes.length;
/* 340 */     int num_pattern_orders = get_num_pattern_orders(s3m_file);
/* 341 */     int num_instruments = get_num_instruments(s3m_file);
/* 342 */     int num_patterns = get_num_patterns(s3m_file);
/* 343 */     s3m_file_length += num_pattern_orders;
/* 344 */     s3m_file_length += num_instruments * 2;
/* 345 */     s3m_file_length += num_patterns * 2;
/*     */     
/* 347 */     s3m_file = read_more(s3m_file, s3m_file_length, data_input); int instrument_idx;
/* 348 */     for (instrument_idx = 0; instrument_idx < num_instruments; instrument_idx++) {
/* 349 */       int instrument_offset = get_instrument_offset(s3m_file, instrument_idx);
/* 350 */       instrument_offset += 80;
/* 351 */       if (instrument_offset > s3m_file_length)
/* 352 */         s3m_file_length = instrument_offset; 
/*     */     } 
/*     */     int pattern_idx;
/* 355 */     for (pattern_idx = 0; pattern_idx < num_patterns; pattern_idx++) {
/* 356 */       int pattern_offset = get_pattern_offset(s3m_file, pattern_idx);
/* 357 */       pattern_offset += 2;
/* 358 */       if (pattern_offset > s3m_file_length) {
/* 359 */         s3m_file_length = pattern_offset;
/*     */       }
/*     */     } 
/* 362 */     s3m_file = read_more(s3m_file, s3m_file_length, data_input);
/*     */     
/* 364 */     for (instrument_idx = 0; instrument_idx < num_instruments; instrument_idx++) {
/* 365 */       int instrument_offset = get_instrument_offset(s3m_file, instrument_idx);
/* 366 */       int sample_data_offset = get_sample_data_offset(s3m_file, instrument_offset);
/* 367 */       sample_data_offset += get_sample_data_length(s3m_file, instrument_offset);
/* 368 */       if (sample_data_offset > s3m_file_length) {
/* 369 */         s3m_file_length = sample_data_offset;
/*     */       }
/*     */     } 
/* 372 */     for (pattern_idx = 0; pattern_idx < num_patterns; pattern_idx++) {
/* 373 */       int pattern_offset = get_pattern_offset(s3m_file, pattern_idx);
/* 374 */       pattern_offset += get_pattern_length(s3m_file, pattern_offset);
/* 375 */       pattern_offset += 2;
/* 376 */       if (pattern_offset > s3m_file_length) {
/* 377 */         s3m_file_length = pattern_offset;
/*     */       }
/*     */     } 
/* 380 */     s3m_file = read_more(s3m_file, s3m_file_length, data_input);
/* 381 */     return s3m_file;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int get_num_pattern_orders(byte[] s3m_file) {
/* 386 */     int num_pattern_orders = unsigned_short_le(s3m_file, 32);
/* 387 */     return num_pattern_orders;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int get_num_instruments(byte[] s3m_file) {
/* 392 */     int num_instruments = unsigned_short_le(s3m_file, 34);
/* 393 */     return num_instruments;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int get_num_patterns(byte[] s3m_file) {
/* 398 */     int num_patterns = unsigned_short_le(s3m_file, 36);
/* 399 */     return num_patterns;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int get_instrument_offset(byte[] s3m_file, int instrument_idx) {
/* 404 */     int pointer_offset = 96 + get_num_pattern_orders(s3m_file);
/* 405 */     int instrument_offset = unsigned_short_le(s3m_file, pointer_offset + instrument_idx * 2) << 4;
/* 406 */     return instrument_offset;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int get_sample_data_offset(byte[] s3m_file, int instrument_offset) {
/* 411 */     int sample_data_offset = 0;
/* 412 */     if (s3m_file[instrument_offset] == 1) {
/* 413 */       sample_data_offset = (s3m_file[instrument_offset + 13] & 0xFF) << 20;
/* 414 */       sample_data_offset |= unsigned_short_le(s3m_file, instrument_offset + 14) << 4;
/*     */     } 
/* 416 */     return sample_data_offset;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int get_sample_data_length(byte[] s3m_file, int instrument_offset) {
/* 422 */     int sample_data_length = 0;
/* 423 */     if (s3m_file[instrument_offset] == 1) {
/* 424 */       sample_data_length = unsigned_short_le(s3m_file, instrument_offset + 16);
/* 425 */       boolean sixteen_bit = ((s3m_file[instrument_offset + 31] & 0x4) != 0);
/* 426 */       if (sixteen_bit) {
/* 427 */         sample_data_length <<= 1;
/*     */       }
/*     */     } 
/* 430 */     return sample_data_length;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int get_pattern_offset(byte[] s3m_file, int pattern_idx) {
/* 435 */     int pointer_offset = 96 + get_num_pattern_orders(s3m_file);
/* 436 */     pointer_offset += get_num_instruments(s3m_file) * 2;
/* 437 */     int pattern_offset = unsigned_short_le(s3m_file, pointer_offset + pattern_idx * 2) << 4;
/* 438 */     return pattern_offset;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int get_pattern_length(byte[] s3m_file, int pattern_offset) {
/* 443 */     int pattern_length = unsigned_short_le(s3m_file, pattern_offset);
/* 444 */     return pattern_length;
/*     */   }
/*     */ 
/*     */   
/*     */   private static byte[] read_more(byte[] old_data, int new_length, DataInput data_input) throws IOException {
/* 449 */     byte[] new_data = old_data;
/* 450 */     if (new_length > old_data.length) {
/* 451 */       new_data = new byte[new_length];
/* 452 */       System.arraycopy(old_data, 0, new_data, 0, old_data.length);
/*     */       try {
/* 454 */         data_input.readFully(new_data, old_data.length, new_data.length - old_data.length);
/* 455 */       } catch (EOFException e) {
/* 456 */         System.out.println("ScreamTracker3: Module has been truncated!");
/*     */       } 
/*     */     } 
/* 459 */     return new_data;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int unsigned_short_le(byte[] buffer, int offset) {
/* 464 */     int value = buffer[offset] & 0xFF;
/* 465 */     value |= (buffer[offset + 1] & 0xFF) << 8;
/* 466 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String ascii_text(byte[] buffer, int offset, int length) {
/*     */     String string;
/* 473 */     byte[] string_buffer = new byte[length];
/* 474 */     for (int idx = 0; idx < length; idx++) {
/* 475 */       int chr = buffer[offset + idx];
/* 476 */       if (chr < 32) {
/* 477 */         chr = 32;
/*     */       }
/* 479 */       string_buffer[idx] = (byte)chr;
/*     */     } 
/*     */     try {
/* 482 */       string = new String(string_buffer, 0, length, "ISO-8859-1");
/* 483 */     } catch (UnsupportedEncodingException e) {
/* 484 */       string = "";
/*     */     } 
/* 486 */     return string;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\ibxm\ScreamTracker3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */