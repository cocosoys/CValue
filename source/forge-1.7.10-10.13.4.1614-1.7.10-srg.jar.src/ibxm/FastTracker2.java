/*     */ package ibxm;
/*     */ import java.io.DataInput;
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ 
/*     */ public class FastTracker2 {
/*     */   public static boolean is_xm(byte[] header_60_bytes) {
/*   9 */     String xm_identifier = ascii_text(header_60_bytes, 0, 17);
/*  10 */     return xm_identifier.equals("Extended Module: ");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Module load_xm(byte[] header_60_bytes, DataInput data_input) throws IOException {
/*  21 */     if (!is_xm(header_60_bytes)) {
/*  22 */       throw new IllegalArgumentException("Not an XM file!");
/*     */     }
/*  24 */     int xm_version = unsigned_short_le(header_60_bytes, 58);
/*  25 */     if (xm_version != 260) {
/*  26 */       throw new IllegalArgumentException("Sorry, XM version " + xm_version + " is not supported!");
/*     */     }
/*  28 */     Module module = new Module();
/*  29 */     module.song_title = ascii_text(header_60_bytes, 17, 20);
/*  30 */     String tracker_name = ascii_text(header_60_bytes, 38, 20);
/*  31 */     boolean delta_env = tracker_name.startsWith("DigiBooster Pro");
/*  32 */     byte[] structure_header = new byte[4];
/*  33 */     data_input.readFully(structure_header);
/*  34 */     int song_header_length = int_le(structure_header, 0);
/*  35 */     byte[] song_header = new byte[song_header_length];
/*  36 */     data_input.readFully(song_header, 4, song_header_length - 4);
/*  37 */     int sequence_length = unsigned_short_le(song_header, 4);
/*  38 */     module.restart_sequence_index = unsigned_short_le(song_header, 6);
/*  39 */     int num_channels = unsigned_short_le(song_header, 8);
/*  40 */     int num_patterns = unsigned_short_le(song_header, 10);
/*  41 */     int num_instruments = unsigned_short_le(song_header, 12);
/*  42 */     int xm_flags = unsigned_short_le(song_header, 14);
/*  43 */     module.linear_periods = ((xm_flags & 0x1) == 1);
/*  44 */     module.global_volume = 64;
/*  45 */     module.channel_gain = 12288;
/*  46 */     module.default_speed = unsigned_short_le(song_header, 16);
/*  47 */     module.default_tempo = unsigned_short_le(song_header, 18);
/*  48 */     module.set_num_channels(num_channels); int idx;
/*  49 */     for (idx = 0; idx < num_channels; idx++) {
/*  50 */       module.set_initial_panning(idx, 128);
/*     */     }
/*  52 */     module.set_sequence_length(sequence_length);
/*  53 */     for (idx = 0; idx < sequence_length; idx++) {
/*  54 */       module.set_sequence(idx, song_header[20 + idx] & 0xFF);
/*     */     }
/*  56 */     module.set_num_patterns(num_patterns);
/*  57 */     for (idx = 0; idx < num_patterns; idx++) {
/*  58 */       module.set_pattern(idx, read_xm_pattern(data_input, num_channels));
/*     */     }
/*  60 */     module.set_num_instruments(num_instruments);
/*  61 */     for (idx = 1; idx <= num_instruments; idx++) {
/*     */       try {
/*  63 */         Instrument instrument = read_xm_instrument(data_input, delta_env);
/*  64 */         module.set_instrument(idx, instrument);
/*  65 */       } catch (EOFException e) {
/*  66 */         System.out.println("Instrument " + idx + " is missing!");
/*     */       } 
/*     */     } 
/*  69 */     return module;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Pattern read_xm_pattern(DataInput data_input, int num_channels) throws IOException {
/*  76 */     byte[] structure_header = new byte[4];
/*  77 */     data_input.readFully(structure_header);
/*  78 */     int pattern_header_length = int_le(structure_header, 0);
/*  79 */     byte[] pattern_header = new byte[pattern_header_length];
/*  80 */     data_input.readFully(pattern_header, 4, pattern_header_length - 4);
/*  81 */     int packing_type = pattern_header[4];
/*  82 */     if (packing_type != 0) {
/*  83 */       throw new IllegalArgumentException("Pattern packing type " + packing_type + " is not supported!");
/*     */     }
/*  85 */     Pattern pattern = new Pattern();
/*  86 */     pattern.num_rows = unsigned_short_le(pattern_header, 5);
/*  87 */     int pattern_data_length = unsigned_short_le(pattern_header, 7);
/*  88 */     byte[] pattern_data = new byte[pattern_data_length];
/*  89 */     data_input.readFully(pattern_data);
/*  90 */     pattern.set_pattern_data(pattern_data);
/*  91 */     return pattern;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Instrument read_xm_instrument(DataInput data_input, boolean delta_env) throws IOException {
/* 100 */     byte[] structure_header = new byte[4];
/* 101 */     data_input.readFully(structure_header);
/* 102 */     int instrument_header_length = int_le(structure_header, 0);
/* 103 */     byte[] instrument_header = new byte[instrument_header_length];
/* 104 */     data_input.readFully(instrument_header, 4, instrument_header_length - 4);
/* 105 */     Instrument instrument = new Instrument();
/* 106 */     instrument.name = ascii_text(instrument_header, 4, 22);
/* 107 */     int num_samples = unsigned_short_le(instrument_header, 27);
/* 108 */     if (num_samples > 0) {
/* 109 */       instrument.set_num_samples(num_samples); int idx;
/* 110 */       for (idx = 0; idx < 96; idx++) {
/* 111 */         instrument.set_key_to_sample(idx + 1, instrument_header[33 + idx] & 0xFF);
/*     */       }
/* 113 */       Envelope envelope = new Envelope();
/* 114 */       int env_num_points = instrument_header[225] & 0xFF;
/* 115 */       envelope.set_num_points(env_num_points);
/* 116 */       for (idx = 0; idx < env_num_points; idx++) {
/* 117 */         int env_tick = unsigned_short_le(instrument_header, 129 + idx * 4);
/* 118 */         int env_ampl = unsigned_short_le(instrument_header, 131 + idx * 4);
/* 119 */         envelope.set_point(idx, env_tick, env_ampl, delta_env);
/*     */       } 
/* 121 */       envelope.set_sustain_point(instrument_header[227] & 0xFF);
/* 122 */       envelope.set_loop_points(instrument_header[228] & 0xFF, instrument_header[229] & 0xFF);
/* 123 */       int flags = instrument_header[233] & 0xFF;
/* 124 */       instrument.volume_envelope_active = ((flags & 0x1) == 1);
/* 125 */       envelope.sustain = ((flags & 0x2) == 2);
/* 126 */       envelope.looped = ((flags & 0x4) == 4);
/* 127 */       instrument.set_volume_envelope(envelope);
/* 128 */       envelope = new Envelope();
/* 129 */       env_num_points = instrument_header[226] & 0xFF;
/* 130 */       envelope.set_num_points(env_num_points);
/* 131 */       for (idx = 0; idx < env_num_points; idx++) {
/* 132 */         int env_tick = unsigned_short_le(instrument_header, 177 + idx * 4);
/* 133 */         int env_ampl = unsigned_short_le(instrument_header, 179 + idx * 4);
/* 134 */         envelope.set_point(idx, env_tick, env_ampl, delta_env);
/*     */       } 
/* 136 */       envelope.set_sustain_point(instrument_header[230] & 0xFF);
/* 137 */       envelope.set_loop_points(instrument_header[231] & 0xFF, instrument_header[232] & 0xFF);
/* 138 */       flags = instrument_header[234] & 0xFF;
/* 139 */       instrument.panning_envelope_active = ((flags & 0x1) == 1);
/* 140 */       envelope.sustain = ((flags & 0x2) == 2);
/* 141 */       envelope.looped = ((flags & 0x4) == 4);
/* 142 */       instrument.set_panning_envelope(envelope);
/* 143 */       instrument.vibrato_type = instrument_header[235] & 0xFF;
/* 144 */       instrument.vibrato_sweep = instrument_header[236] & 0xFF;
/* 145 */       instrument.vibrato_depth = instrument_header[237] & 0xFF;
/* 146 */       instrument.vibrato_rate = instrument_header[238] & 0xFF;
/* 147 */       instrument.volume_fade_out = unsigned_short_le(instrument_header, 239);
/* 148 */       byte[] sample_headers = new byte[num_samples * 40];
/* 149 */       data_input.readFully(sample_headers);
/* 150 */       for (idx = 0; idx < num_samples; idx++) {
/* 151 */         instrument.set_sample(idx, read_xm_sample(sample_headers, idx, data_input));
/*     */       }
/*     */     } 
/* 154 */     return instrument;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Sample read_xm_sample(byte[] sample_headers, int sample_idx, DataInput data_input) throws IOException {
/* 165 */     int header_offset = sample_idx * 40;
/* 166 */     Sample sample = new Sample();
/* 167 */     int sample_length = int_le(sample_headers, header_offset);
/* 168 */     int loop_start = int_le(sample_headers, header_offset + 4);
/* 169 */     int loop_length = int_le(sample_headers, header_offset + 8);
/* 170 */     sample.volume = sample_headers[header_offset + 12] & 0xFF;
/* 171 */     int fine_tune = sample_headers[header_offset + 13];
/* 172 */     fine_tune = (fine_tune << 15) / 1536;
/* 173 */     sample.set_panning = true;
/* 174 */     int flags = sample_headers[header_offset + 14] & 0xFF;
/* 175 */     if ((flags & 0x3) == 0) {
/* 176 */       loop_length = 0;
/*     */     }
/* 178 */     boolean ping_pong = ((flags & 0x2) == 2);
/* 179 */     boolean sixteen_bit = ((flags & 0x10) == 16);
/* 180 */     sample.panning = sample_headers[header_offset + 15] & 0xFF;
/* 181 */     int relative_note = sample_headers[header_offset + 16];
/* 182 */     relative_note = (relative_note << 15) / 12;
/* 183 */     sample.transpose = relative_note + fine_tune;
/* 184 */     sample.name = ascii_text(sample_headers, header_offset + 18, 22);
/* 185 */     byte[] raw_sample_data = new byte[sample_length];
/*     */     try {
/* 187 */       data_input.readFully(raw_sample_data);
/* 188 */     } catch (EOFException e) {
/* 189 */       System.out.println("Sample has been truncated!");
/*     */     } 
/* 191 */     int in_idx = 0;
/* 192 */     int out_idx = 0;
/* 193 */     int sam = 0;
/* 194 */     int last_sam = 0;
/* 195 */     if (sixteen_bit) {
/* 196 */       short[] decoded_sample_data = new short[sample_length >> 1];
/* 197 */       while (in_idx < raw_sample_data.length) {
/* 198 */         sam = raw_sample_data[in_idx] & 0xFF;
/* 199 */         sam |= (raw_sample_data[in_idx + 1] & 0xFF) << 8;
/* 200 */         last_sam += sam;
/* 201 */         decoded_sample_data[out_idx] = (short)last_sam;
/* 202 */         in_idx += 2;
/* 203 */         out_idx++;
/*     */       } 
/* 205 */       sample.set_sample_data(decoded_sample_data, loop_start >> 1, loop_length >> 1, ping_pong);
/*     */     } else {
/* 207 */       short[] decoded_sample_data = new short[sample_length];
/* 208 */       while (in_idx < raw_sample_data.length) {
/* 209 */         sam = raw_sample_data[in_idx] & 0xFF;
/* 210 */         last_sam += sam;
/* 211 */         decoded_sample_data[out_idx] = (short)(last_sam << 8);
/* 212 */         in_idx++;
/* 213 */         out_idx++;
/*     */       } 
/* 215 */       sample.set_sample_data(decoded_sample_data, loop_start, loop_length, ping_pong);
/*     */     } 
/* 217 */     return sample;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int unsigned_short_le(byte[] buffer, int offset) {
/* 222 */     int value = buffer[offset] & 0xFF;
/* 223 */     value |= (buffer[offset + 1] & 0xFF) << 8;
/* 224 */     return value;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int int_le(byte[] buffer, int offset) {
/* 229 */     int value = buffer[offset] & 0xFF;
/* 230 */     value |= (buffer[offset + 1] & 0xFF) << 8;
/* 231 */     value |= (buffer[offset + 2] & 0xFF) << 16;
/* 232 */     value |= (buffer[offset + 3] & Byte.MAX_VALUE) << 24;
/* 233 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String ascii_text(byte[] buffer, int offset, int length) {
/*     */     String string;
/* 240 */     byte[] string_buffer = new byte[length];
/* 241 */     for (int idx = 0; idx < length; idx++) {
/* 242 */       int chr = buffer[offset + idx];
/* 243 */       if (chr < 32) {
/* 244 */         chr = 32;
/*     */       }
/* 246 */       string_buffer[idx] = (byte)chr;
/*     */     } 
/*     */     try {
/* 249 */       string = new String(string_buffer, 0, length, "ISO-8859-1");
/* 250 */     } catch (UnsupportedEncodingException e) {
/* 251 */       string = "";
/*     */     } 
/* 253 */     return string;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\ibxm\FastTracker2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */