/*     */ package cpw.mods.fml.repackage.com.nothome.delta;
/*     */ 
/*     */ import com.google.common.collect.Maps;
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Checksum
/*     */ {
/*     */   static final boolean debug = false;
/*  41 */   private Map<Long, Integer> checksums = Maps.newHashMap();
/*     */   
/*  43 */   private static final char[] single_hash = new char[] { '병', '뭥', '䋂', '?', '陦', '䌛', '蔄', '', '捹', '푠', '켔', '叏', '?', '?', 'ወ', '', '', '⎔', '┍', '?', 'ꙸ', 'ʯ', 'ꗆ', '约', '뙅', '쭍', '쑋', '', '鿦', '孜', '㗵', '瀚', '∏', '永', 'ᩖ', '䲣', 'ￆ', '녒', '赡', '穘', '逥', '謽', '뼏', '閣', '', '섧', '㯭', '㈋', '럳', '恔', '㌼', '펃', '腔', '剂', '不', 'ઔ', '瀨', '蚉', '㨢', 'ঀ', 'ᡇ', '냱', '魜', '䅶', '롘', '핂', 'Ὤ', '⒗', '橚', '龩', '豚', '睃', 'ꢩ', '騂', '䤘', '䎌', '쎈', '鸫', '䲭', 'ƶ', '꬙', '', '㙟', 'Ẳ', 'ञ', '篸', '窎', '刧', '', '⁴', '䔣', '', 'ƣ', 'ᘽ', '㬮', '⡽', '广', 'ꁣ', '넴', '辮', '庎', '랷', '䕈', '὚', '節', '稤', '透', '䋜', '챩', 'ʠ', 'ଢ', '?', '燾', '౽', 'ᜲ', 'ᅙ', '쬉', '', 'ፑ', '勩', '', '婏', '쌖', '毹', '覔', '띴', '弾', '', '㩡', '', '찢', '鴆', '⦜', '৥', 'Ử', '兏', '赓', 'Ꙑ', '屮', '앷', '祘', '熬', '褖', '魏', 'Ⰹ', '刑', '', '쪪', '', '⡿', '窔', 'ꭉ', '館', '爢', '', '휚', 'Ã', '᩶', '', '쀷', '興', '尭', '?', '', '୅', 'ᗎ', '詾', 'ﲭ', 'ꨭ', '䭜', '퐮', '뉑', '遾', '驇', '즦', '?', '࡞', '㗎', 'ꅓ', '繻', '鼋', '▪', '嶟', '쁍', '討', '⡵', '䨜', '⥟', '᎓', '', '酸', 'ཛ', '墳', '莴', '₂', '爝', '摢', 'ͨ', '柢', '蘤', '᥍', '⋶', '磻', '枑', '눸', '댲', '牶', '', '䟬', '䔄', 'ꥡ', '鿈', '㿜', '됓', 'z', 'ࠆ', '瑘', '闆', '첪', 'ᣖ', '', 'ᬆ', '', '偐', '죨', '', '쁌', '', '餯', '깄', '弛', 'ᄓ', '᜸', '?', '᧪', 'ⴳ', '隘', '⿩', '㈿', '췢', '浱', '', '뚗', 'ⱏ', '䍳', '鄂', 'ݝ', '踥', 'ᙲ', '', '櫋', '蛌', 'ᡮ', '鐔', '홴', '톥' };
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
/*     */   public Checksum(SeekableSource source, int chunkSize) throws IOException {
/*  84 */     ByteBuffer bb = ByteBuffer.allocate(chunkSize * 2);
/*  85 */     int count = 0;
/*     */     while (true) {
/*  87 */       source.read(bb);
/*  88 */       bb.flip();
/*  89 */       if (bb.remaining() < chunkSize)
/*     */         break; 
/*  91 */       while (bb.remaining() >= chunkSize) {
/*  92 */         long queryChecksum = queryChecksum0(bb, chunkSize);
/*  93 */         this.checksums.put(Long.valueOf(queryChecksum), Integer.valueOf(count++));
/*     */       } 
/*  95 */       bb.compact();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long queryChecksum(ByteBuffer bb, int len) {
/* 104 */     bb.mark();
/* 105 */     long sum = queryChecksum0(bb, len);
/* 106 */     bb.reset();
/* 107 */     return sum;
/*     */   }
/*     */   
/*     */   private static long queryChecksum0(ByteBuffer bb, int len) {
/* 111 */     int high = 0, low = 0;
/* 112 */     for (int i = 0; i < len; i++) {
/* 113 */       low += single_hash[bb.get() + 128];
/* 114 */       high += low;
/*     */     } 
/* 116 */     return ((high & 0xFFFF) << 16 | low & 0xFFFF);
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
/*     */   public static long incrementChecksum(long checksum, byte out, byte in, int chunkSize) {
/* 128 */     char old_c = single_hash[out + 128];
/* 129 */     char new_c = single_hash[in + 128];
/* 130 */     int low = (int)(checksum & 0xFFFFL) - old_c + new_c & 0xFFFF;
/* 131 */     int high = (int)(checksum >> 16L) - old_c * chunkSize + low & 0xFFFF;
/* 132 */     return (high << 16 | low & 0xFFFF);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static char[] getSingleHash() {
/* 139 */     return single_hash;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int findChecksumIndex(long hashf) {
/* 146 */     if (!this.checksums.containsKey(Long.valueOf(hashf)))
/* 147 */       return -1; 
/* 148 */     return ((Integer)this.checksums.get(Long.valueOf(hashf))).intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 157 */     return super.toString() + " checksums=" + this.checksums;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\repackage\com\nothome\delta\Checksum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */