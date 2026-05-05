/*    */ package ibxm;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Instrument
/*    */ {
/*    */   public String name;
/*    */   public int vibrato_type;
/*    */   public int vibrato_sweep;
/*    */   public int vibrato_depth;
/*    */   public int vibrato_rate;
/*    */   public boolean volume_envelope_active;
/*    */   
/*    */   public Instrument() {
/* 16 */     this.name = "";
/* 17 */     set_volume_envelope(new Envelope());
/* 18 */     set_panning_envelope(new Envelope());
/* 19 */     this.key_to_sample = new int[96];
/* 20 */     set_num_samples(1);
/*    */   }
/*    */   public boolean panning_envelope_active; public int volume_fade_out; private Envelope volume_envelope; private Envelope panning_envelope; private int[] key_to_sample; private Sample[] samples;
/*    */   public Envelope get_volume_envelope() {
/* 24 */     return this.volume_envelope;
/*    */   }
/*    */   
/*    */   public void set_volume_envelope(Envelope envelope) {
/* 28 */     if (envelope != null) {
/* 29 */       this.volume_envelope = envelope;
/*    */     }
/*    */   }
/*    */   
/*    */   public Envelope get_panning_envelope() {
/* 34 */     return this.panning_envelope;
/*    */   }
/*    */   
/*    */   public void set_panning_envelope(Envelope envelope) {
/* 38 */     if (envelope != null) {
/* 39 */       this.panning_envelope = envelope;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public Sample get_sample_from_key(int key) {
/* 45 */     int sample_idx = 0;
/* 46 */     if (key > 0 && key <= this.key_to_sample.length) {
/* 47 */       sample_idx = this.key_to_sample[key - 1];
/*    */     }
/* 49 */     return get_sample(sample_idx);
/*    */   }
/*    */   
/*    */   public void set_key_to_sample(int key, int sample) {
/* 53 */     if (key > 0 && key <= this.key_to_sample.length) {
/* 54 */       this.key_to_sample[key - 1] = sample;
/*    */     }
/*    */   }
/*    */   
/*    */   public int get_num_samples() {
/* 59 */     return this.samples.length;
/*    */   }
/*    */   
/*    */   public void set_num_samples(int num_samples) {
/* 63 */     if (num_samples < 1) {
/* 64 */       num_samples = 1;
/*    */     }
/* 66 */     this.samples = new Sample[num_samples];
/* 67 */     set_sample(0, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public Sample get_sample(int sample_index) {
/* 72 */     Sample sample = null;
/* 73 */     if (sample_index >= 0 && sample_index < this.samples.length) {
/* 74 */       sample = this.samples[sample_index];
/*    */     }
/* 76 */     if (sample == null) {
/* 77 */       sample = this.samples[0];
/*    */     }
/* 79 */     return sample;
/*    */   }
/*    */   
/*    */   public void set_sample(int sample_index, Sample sample) {
/* 83 */     if (sample_index >= 0 && sample_index < this.samples.length) {
/* 84 */       this.samples[sample_index] = sample;
/*    */     }
/* 86 */     if (this.samples[0] == null)
/* 87 */       this.samples[0] = new Sample(); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\ibxm\Instrument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */