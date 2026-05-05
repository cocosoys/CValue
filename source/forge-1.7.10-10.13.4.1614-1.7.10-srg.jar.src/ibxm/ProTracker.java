/*     */ package ibxm;
/*     */ import java.io.DataInput;
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class ProTracker {
/*     */   public static boolean is_mod(byte[] header_1084_bytes) {
/*   8 */     boolean is_mod = false;
/*   9 */     if (calculate_num_channels(header_1084_bytes) > 0) {
/*  10 */       is_mod = true;
/*     */     }
/*  12 */     return is_mod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Module load_mod(byte[] header_1084_bytes, DataInput data_input) throws IOException {
/*  20 */     int num_channels = calculate_num_channels(header_1084_bytes);
/*  21 */     if (num_channels < 1) {
/*  22 */       throw new IllegalArgumentException("ProTracker: Unrecognised module format!");
/*     */     }
/*  24 */     Module module = new Module();
/*  25 */     module.song_title = ascii_text(header_1084_bytes, 0, 20);
/*  26 */     module.pal = (num_channels == 4);
/*  27 */     module.global_volume = 64;
/*  28 */     module.channel_gain = 12288;
/*  29 */     module.default_speed = 6;
/*  30 */     module.default_tempo = 125;
/*  31 */     module.set_num_channels(num_channels);
/*  32 */     for (int channel_idx = 0; channel_idx < num_channels; channel_idx++) {
/*  33 */       int panning = 64;
/*  34 */       if ((channel_idx & 0x3) == 1 || (channel_idx & 0x3) == 2) {
/*  35 */         panning = 192;
/*     */       }
/*  37 */       module.set_initial_panning(channel_idx, panning);
/*     */     } 
/*  39 */     int sequence_length = header_1084_bytes[950] & Byte.MAX_VALUE;
/*  40 */     int restart_idx = header_1084_bytes[951] & Byte.MAX_VALUE;
/*  41 */     if (restart_idx >= sequence_length) {
/*  42 */       restart_idx = 0;
/*     */     }
/*  44 */     module.restart_sequence_index = restart_idx;
/*  45 */     module.set_sequence_length(sequence_length);
/*  46 */     for (int sequence_idx = 0; sequence_idx < sequence_length; sequence_idx++) {
/*  47 */       module.set_sequence(sequence_idx, header_1084_bytes[952 + sequence_idx] & Byte.MAX_VALUE);
/*     */     }
/*  49 */     int num_patterns = calculate_num_patterns(header_1084_bytes);
/*  50 */     module.set_num_patterns(num_patterns);
/*  51 */     for (int pattern_idx = 0; pattern_idx < num_patterns; pattern_idx++) {
/*  52 */       module.set_pattern(pattern_idx, read_mod_pattern(data_input, num_channels));
/*     */     }
/*  54 */     module.set_num_instruments(31);
/*  55 */     for (int instrument_idx = 1; instrument_idx <= 31; instrument_idx++) {
/*  56 */       module.set_instrument(instrument_idx, read_mod_instrument(header_1084_bytes, instrument_idx, data_input));
/*     */     }
/*  58 */     return module;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int calculate_num_patterns(byte[] module_header) {
/*  63 */     int num_patterns = 0;
/*  64 */     for (int pattern_idx = 0; pattern_idx < 128; pattern_idx++) {
/*  65 */       int order_entry = module_header[952 + pattern_idx] & Byte.MAX_VALUE;
/*  66 */       if (order_entry >= num_patterns) {
/*  67 */         num_patterns = order_entry + 1;
/*     */       }
/*     */     } 
/*  70 */     return num_patterns;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int calculate_num_channels(byte[] module_header) {
/*  75 */     switch (module_header[1082] << 8 | module_header[1083])
/*     */     { case 19233:
/*     */       case 19246:
/*     */       case 21550:
/*     */       case 21556:
/*  80 */         num_channels = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  93 */         return num_channels;case 18510: num_channels = module_header[1080] - 48; return num_channels;case 17224: num_channels = (module_header[1080] - 48) * 10 + module_header[1081] - 48; return num_channels; }  int num_channels = 0; return num_channels;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Pattern read_mod_pattern(DataInput data_input, int num_channels) throws IOException {
/* 101 */     Pattern pattern = new Pattern();
/* 102 */     pattern.num_rows = 64;
/* 103 */     byte[] input_pattern_data = new byte[64 * num_channels * 4];
/* 104 */     byte[] output_pattern_data = new byte[64 * num_channels * 5];
/* 105 */     data_input.readFully(input_pattern_data);
/* 106 */     int input_idx = 0;
/* 107 */     int output_idx = 0;
/* 108 */     while (input_idx < input_pattern_data.length) {
/* 109 */       int period = (input_pattern_data[input_idx] & 0xF) << 8;
/* 110 */       period |= input_pattern_data[input_idx + 1] & 0xFF;
/* 111 */       output_pattern_data[output_idx] = to_key(period);
/* 112 */       int instrument = input_pattern_data[input_idx] & 0x10;
/* 113 */       instrument |= (input_pattern_data[input_idx + 2] & 0xF0) >> 4;
/* 114 */       output_pattern_data[output_idx + 1] = (byte)instrument;
/* 115 */       int effect = input_pattern_data[input_idx + 2] & 0xF;
/* 116 */       int effect_param = input_pattern_data[input_idx + 3] & 0xFF;
/* 117 */       if (effect == 1 && effect_param == 0)
/*     */       {
/* 119 */         effect = 0;
/*     */       }
/* 121 */       if (effect == 2 && effect_param == 0)
/*     */       {
/* 123 */         effect = 0;
/*     */       }
/* 125 */       if (effect == 8 && num_channels == 4) {
/*     */         
/* 127 */         effect = 0;
/* 128 */         effect_param = 0;
/*     */       } 
/* 130 */       if (effect == 10 && effect_param == 0)
/*     */       {
/* 132 */         effect = 0;
/*     */       }
/* 134 */       if (effect == 5 && effect_param == 0)
/*     */       {
/* 136 */         effect = 3;
/*     */       }
/* 138 */       if (effect == 6 && effect_param == 0)
/*     */       {
/* 140 */         effect = 4;
/*     */       }
/* 142 */       output_pattern_data[output_idx + 3] = (byte)effect;
/* 143 */       output_pattern_data[output_idx + 4] = (byte)effect_param;
/* 144 */       input_idx += 4;
/* 145 */       output_idx += 5;
/*     */     } 
/* 147 */     pattern.set_pattern_data(output_pattern_data);
/* 148 */     return pattern;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Instrument read_mod_instrument(byte[] mod_header, int idx, DataInput data_input) throws IOException {
/* 158 */     int header_offset = (idx - 1) * 30 + 20;
/* 159 */     Instrument instrument = new Instrument();
/* 160 */     instrument.name = ascii_text(mod_header, header_offset, 22);
/* 161 */     Sample sample = new Sample();
/* 162 */     int sample_data_length = unsigned_short_be(mod_header, header_offset + 22) << 1;
/* 163 */     int fine_tune = mod_header[header_offset + 24] & 0xF;
/* 164 */     if (fine_tune > 7) {
/* 165 */       fine_tune -= 16;
/*     */     }
/* 167 */     sample.transpose = (fine_tune << 15) / 96;
/* 168 */     sample.volume = mod_header[header_offset + 25] & Byte.MAX_VALUE;
/* 169 */     int loop_start = unsigned_short_be(mod_header, header_offset + 26) << 1;
/* 170 */     int loop_length = unsigned_short_be(mod_header, header_offset + 28) << 1;
/* 171 */     if (loop_length < 4) {
/* 172 */       loop_length = 0;
/*     */     }
/* 174 */     byte[] raw_sample_data = new byte[sample_data_length];
/* 175 */     short[] sample_data = new short[sample_data_length];
/*     */     try {
/* 177 */       data_input.readFully(raw_sample_data);
/* 178 */     } catch (EOFException e) {
/* 179 */       System.out.println("ProTracker: Instrument " + idx + " has samples missing.");
/*     */     } 
/* 181 */     for (int sample_idx = 0; sample_idx < raw_sample_data.length; sample_idx++) {
/* 182 */       sample_data[sample_idx] = (short)(raw_sample_data[sample_idx] << 8);
/*     */     }
/* 184 */     sample.set_sample_data(sample_data, loop_start, loop_length, false);
/* 185 */     instrument.set_num_samples(1);
/* 186 */     instrument.set_sample(0, sample);
/* 187 */     return instrument;
/*     */   }
/*     */   
/*     */   private static byte to_key(int period) {
/*     */     int key;
/* 192 */     if (period < 32) {
/* 193 */       key = 0;
/*     */     } else {
/* 195 */       int oct = LogTable.log_2(7256) - LogTable.log_2(period);
/* 196 */       if (oct < 0) {
/* 197 */         key = 0;
/*     */       } else {
/* 199 */         key = oct * 12;
/* 200 */         key >>= 14;
/* 201 */         key = (key >> 1) + (key & 0x1);
/*     */       } 
/*     */     } 
/* 204 */     return (byte)key;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int unsigned_short_be(byte[] buf, int offset) {
/* 209 */     int value = (buf[offset] & 0xFF) << 8;
/* 210 */     value |= buf[offset + 1] & 0xFF;
/* 211 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String ascii_text(byte[] buffer, int offset, int length) {
/*     */     String string;
/* 218 */     byte[] string_buffer = new byte[length];
/* 219 */     for (int idx = 0; idx < length; idx++) {
/* 220 */       int chr = buffer[offset + idx];
/* 221 */       if (chr < 32) {
/* 222 */         chr = 32;
/*     */       }
/* 224 */       string_buffer[idx] = (byte)chr;
/*     */     } 
/*     */     try {
/* 227 */       string = new String(string_buffer, 0, length, "ISO-8859-1");
/* 228 */     } catch (UnsupportedEncodingException e) {
/* 229 */       string = "";
/*     */     } 
/* 231 */     return string;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\ibxm\ProTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */