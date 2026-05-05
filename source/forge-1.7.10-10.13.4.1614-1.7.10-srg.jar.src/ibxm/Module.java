/*     */ package ibxm;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Module
/*     */ {
/*     */   public String song_title;
/*     */   public boolean linear_periods;
/*     */   public boolean fast_volume_slides;
/*     */   public boolean pal;
/*     */   public int global_volume;
/*     */   public int channel_gain;
/*     */   public int default_speed;
/*     */   
/*     */   public Module() {
/*  19 */     this.song_title = "ibxm alpha 51 (c)2008 mumart@gmail.com";
/*  20 */     set_num_channels(1);
/*  21 */     set_sequence_length(1);
/*  22 */     set_num_patterns(0);
/*  23 */     set_num_instruments(0);
/*  24 */     this.default_pattern = new Pattern();
/*  25 */     this.default_instrument = new Instrument();
/*     */   }
/*     */   public int default_tempo; public int restart_sequence_index; private int[] initial_panning; private int[] sequence; private Pattern[] patterns; private Instrument[] instruments; private Pattern default_pattern; private Instrument default_instrument;
/*     */   public int get_num_channels() {
/*  29 */     return this.initial_panning.length;
/*     */   }
/*     */   
/*     */   public void set_num_channels(int num_channels) {
/*  33 */     if (num_channels < 1) {
/*  34 */       num_channels = 1;
/*     */     }
/*  36 */     this.initial_panning = new int[num_channels];
/*     */   }
/*     */ 
/*     */   
/*     */   public int get_initial_panning(int channel) {
/*  41 */     int panning = 128;
/*  42 */     if (channel >= 0 && channel < this.initial_panning.length) {
/*  43 */       panning = this.initial_panning[channel];
/*     */     }
/*  45 */     return panning;
/*     */   }
/*     */   
/*     */   public void set_initial_panning(int channel, int panning) {
/*  49 */     if (channel >= 0 && channel < this.initial_panning.length) {
/*  50 */       this.initial_panning[channel] = panning;
/*     */     }
/*     */   }
/*     */   
/*     */   public int get_sequence_length() {
/*  55 */     return this.sequence.length;
/*     */   }
/*     */   
/*     */   public void set_sequence_length(int sequence_length) {
/*  59 */     if (sequence_length < 0) {
/*  60 */       sequence_length = 0;
/*     */     }
/*  62 */     this.sequence = new int[sequence_length];
/*     */   }
/*     */   
/*     */   public void set_sequence(int sequence_index, int pattern_index) {
/*  66 */     if (sequence_index >= 0 && sequence_index < this.sequence.length) {
/*  67 */       this.sequence[sequence_index] = pattern_index;
/*     */     }
/*     */   }
/*     */   
/*     */   public int get_num_patterns() {
/*  72 */     return this.patterns.length;
/*     */   }
/*     */   
/*     */   public void set_num_patterns(int num_patterns) {
/*  76 */     if (num_patterns < 0) {
/*  77 */       num_patterns = 0;
/*     */     }
/*  79 */     this.patterns = new Pattern[num_patterns];
/*     */   }
/*     */ 
/*     */   
/*     */   public Pattern get_pattern_from_sequence(int sequence_index) {
/*  84 */     Pattern pattern = this.default_pattern;
/*  85 */     if (sequence_index >= 0 && sequence_index < this.sequence.length) {
/*  86 */       pattern = get_pattern(this.sequence[sequence_index]);
/*     */     }
/*  88 */     return pattern;
/*     */   }
/*     */ 
/*     */   
/*     */   public Pattern get_pattern(int pattern_index) {
/*  93 */     Pattern pattern = null;
/*  94 */     if (pattern_index >= 0 && pattern_index < this.patterns.length) {
/*  95 */       pattern = this.patterns[pattern_index];
/*     */     }
/*  97 */     if (pattern == null) {
/*  98 */       pattern = this.default_pattern;
/*     */     }
/* 100 */     return pattern;
/*     */   }
/*     */   
/*     */   public void set_pattern(int pattern_index, Pattern pattern) {
/* 104 */     if (pattern_index >= 0 && pattern_index < this.patterns.length) {
/* 105 */       this.patterns[pattern_index] = pattern;
/*     */     }
/*     */   }
/*     */   
/*     */   public int get_num_instruments() {
/* 110 */     return this.instruments.length;
/*     */   }
/*     */   
/*     */   public void set_num_instruments(int num_instruments) {
/* 114 */     if (num_instruments < 0) {
/* 115 */       num_instruments = 0;
/*     */     }
/* 117 */     this.instruments = new Instrument[num_instruments];
/*     */   }
/*     */ 
/*     */   
/*     */   public Instrument get_instrument(int instrument_index) {
/* 122 */     Instrument instrument = null;
/* 123 */     if (instrument_index > 0 && instrument_index <= this.instruments.length) {
/* 124 */       instrument = this.instruments[instrument_index - 1];
/*     */     }
/* 126 */     if (instrument == null) {
/* 127 */       instrument = this.default_instrument;
/*     */     }
/* 129 */     return instrument;
/*     */   }
/*     */   
/*     */   public void set_instrument(int instrument_index, Instrument instrument) {
/* 133 */     if (instrument_index > 0 && instrument_index <= this.instruments.length)
/* 134 */       this.instruments[instrument_index - 1] = instrument; 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\ibxm\Module.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */