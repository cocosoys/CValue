/*    */ package ibxm;
/*    */ 
/*    */ public class Pattern
/*    */ {
/*    */   public int num_rows;
/*    */   private int data_offset;
/*    */   private int note_index;
/*    */   private byte[] pattern_data;
/*    */   
/*    */   public Pattern() {
/* 11 */     this.num_rows = 1;
/* 12 */     set_pattern_data(new byte[0]);
/*    */   }
/*    */   
/*    */   public void set_pattern_data(byte[] data) {
/* 16 */     if (data != null) {
/* 17 */       this.pattern_data = data;
/*    */     }
/* 19 */     this.data_offset = 0;
/* 20 */     this.note_index = 0;
/*    */   }
/*    */   
/*    */   public void get_note(int[] note, int index) {
/* 24 */     if (index < this.note_index) {
/* 25 */       this.note_index = 0;
/* 26 */       this.data_offset = 0;
/*    */     } 
/* 28 */     while (this.note_index <= index) {
/* 29 */       this.data_offset = next_note(this.data_offset, note);
/* 30 */       this.note_index++;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int next_note(int data_offset, int[] note) {
/* 36 */     if (data_offset < 0) {
/* 37 */       data_offset = this.pattern_data.length;
/*    */     }
/* 39 */     int bitmask = 128;
/* 40 */     if (data_offset < this.pattern_data.length) {
/* 41 */       bitmask = this.pattern_data[data_offset] & 0xFF;
/*    */     }
/* 43 */     if ((bitmask & 0x80) == 128) {
/* 44 */       data_offset++;
/*    */     } else {
/* 46 */       bitmask = 31;
/*    */     } 
/* 48 */     for (int field = 0; field < 5; field++) {
/* 49 */       note[field] = 0;
/* 50 */       if ((bitmask & 0x1) == 1 && 
/* 51 */         data_offset < this.pattern_data.length) {
/* 52 */         note[field] = this.pattern_data[data_offset] & 0xFF;
/* 53 */         data_offset++;
/*    */       } 
/*    */       
/* 56 */       bitmask >>= 1;
/*    */     } 
/* 58 */     return data_offset;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\ibxm\Pattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */