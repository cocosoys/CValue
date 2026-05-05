/*     */ package com.avaje.ebeaninternal.server.type;
/*     */ 
/*     */ import com.avaje.ebeaninternal.server.core.Message;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.Array;
/*     */ import java.sql.Blob;
/*     */ import java.sql.Clob;
/*     */ import java.sql.Date;
/*     */ import java.sql.Ref;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Time;
/*     */ import java.sql.Timestamp;
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
/*     */ public class RsetDataReader
/*     */   implements DataReader
/*     */ {
/*     */   private static final int bufferSize = 512;
/*     */   static final int clobBufferSize = 512;
/*     */   static final int stringInitialSize = 512;
/*     */   private final ResultSet rset;
/*     */   protected int pos;
/*     */   
/*     */   public RsetDataReader(ResultSet rset) {
/*  52 */     this.rset = rset;
/*     */   }
/*     */   
/*     */   public void close() throws SQLException {
/*  56 */     this.rset.close();
/*     */   }
/*     */   
/*     */   public boolean next() throws SQLException {
/*  60 */     return this.rset.next();
/*     */   }
/*     */   
/*     */   public void resetColumnPosition() {
/*  64 */     this.pos = 0;
/*     */   }
/*     */   
/*     */   public void incrementPos(int increment) {
/*  68 */     this.pos += increment;
/*     */   }
/*     */   
/*     */   protected int pos() {
/*  72 */     return ++this.pos;
/*     */   }
/*     */   
/*     */   public Array getArray() throws SQLException {
/*  76 */     return this.rset.getArray(pos());
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getAsciiStream() throws SQLException {
/*  81 */     return this.rset.getAsciiStream(pos());
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getBigDecimal() throws SQLException {
/*  86 */     return this.rset.getBigDecimal(pos());
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getBinaryStream() throws SQLException {
/*  91 */     return this.rset.getBinaryStream(pos());
/*     */   }
/*     */   
/*     */   public Boolean getBoolean() throws SQLException {
/*  95 */     boolean v = this.rset.getBoolean(pos());
/*  96 */     if (this.rset.wasNull()) {
/*  97 */       return null;
/*     */     }
/*  99 */     return Boolean.valueOf(v);
/*     */   }
/*     */   
/*     */   public Byte getByte() throws SQLException {
/* 103 */     byte v = this.rset.getByte(pos());
/* 104 */     if (this.rset.wasNull()) {
/* 105 */       return null;
/*     */     }
/* 107 */     return Byte.valueOf(v);
/*     */   }
/*     */   
/*     */   public byte[] getBytes() throws SQLException {
/* 111 */     return this.rset.getBytes(pos());
/*     */   }
/*     */   
/*     */   public Date getDate() throws SQLException {
/* 115 */     return this.rset.getDate(pos());
/*     */   }
/*     */   
/*     */   public Double getDouble() throws SQLException {
/* 119 */     double v = this.rset.getDouble(pos());
/* 120 */     if (this.rset.wasNull()) {
/* 121 */       return null;
/*     */     }
/* 123 */     return Double.valueOf(v);
/*     */   }
/*     */   
/*     */   public Float getFloat() throws SQLException {
/* 127 */     float v = this.rset.getFloat(pos());
/* 128 */     if (this.rset.wasNull()) {
/* 129 */       return null;
/*     */     }
/* 131 */     return Float.valueOf(v);
/*     */   }
/*     */   
/*     */   public Integer getInt() throws SQLException {
/* 135 */     int v = this.rset.getInt(pos());
/* 136 */     if (this.rset.wasNull()) {
/* 137 */       return null;
/*     */     }
/* 139 */     return Integer.valueOf(v);
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getLong() throws SQLException {
/* 144 */     long v = this.rset.getLong(pos());
/* 145 */     if (this.rset.wasNull()) {
/* 146 */       return null;
/*     */     }
/* 148 */     return Long.valueOf(v);
/*     */   }
/*     */ 
/*     */   
/*     */   public Ref getRef() throws SQLException {
/* 153 */     return this.rset.getRef(pos());
/*     */   }
/*     */ 
/*     */   
/*     */   public Short getShort() throws SQLException {
/* 158 */     short s = this.rset.getShort(pos());
/* 159 */     if (this.rset.wasNull()) {
/* 160 */       return null;
/*     */     }
/* 162 */     return Short.valueOf(s);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() throws SQLException {
/* 167 */     return this.rset.getString(pos());
/*     */   }
/*     */ 
/*     */   
/*     */   public Time getTime() throws SQLException {
/* 172 */     return this.rset.getTime(pos());
/*     */   }
/*     */ 
/*     */   
/*     */   public Timestamp getTimestamp() throws SQLException {
/* 177 */     return this.rset.getTimestamp(pos());
/*     */   }
/*     */   
/*     */   public String getStringFromStream() throws SQLException {
/* 181 */     Reader reader = this.rset.getCharacterStream(pos());
/* 182 */     if (reader == null) {
/* 183 */       return null;
/*     */     }
/* 185 */     return readStringLob(reader);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStringClob() throws SQLException {
/* 190 */     Clob clob = this.rset.getClob(pos());
/* 191 */     if (clob == null) {
/* 192 */       return null;
/*     */     }
/* 194 */     Reader reader = clob.getCharacterStream();
/* 195 */     if (reader == null) {
/* 196 */       return null;
/*     */     }
/* 198 */     return readStringLob(reader);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String readStringLob(Reader reader) throws SQLException {
/* 203 */     char[] buffer = new char[512];
/* 204 */     int readLength = 0;
/* 205 */     StringBuilder out = new StringBuilder(512);
/*     */     try {
/* 207 */       while ((readLength = reader.read(buffer)) != -1) {
/* 208 */         out.append(buffer, 0, readLength);
/*     */       }
/* 210 */       reader.close();
/* 211 */     } catch (IOException e) {
/* 212 */       throw new SQLException(Message.msg("persist.clob.io", e.getMessage()));
/*     */     } 
/*     */     
/* 215 */     return out.toString();
/*     */   }
/*     */   
/*     */   public byte[] getBinaryBytes() throws SQLException {
/* 219 */     InputStream in = this.rset.getBinaryStream(pos());
/* 220 */     return getBinaryLob(in);
/*     */   }
/*     */   
/*     */   public byte[] getBlobBytes() throws SQLException {
/* 224 */     Blob blob = this.rset.getBlob(pos());
/* 225 */     if (blob == null) {
/* 226 */       return null;
/*     */     }
/* 228 */     InputStream in = blob.getBinaryStream();
/* 229 */     return getBinaryLob(in);
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte[] getBinaryLob(InputStream in) throws SQLException {
/*     */     try {
/* 235 */       if (in == null) {
/* 236 */         return null;
/*     */       }
/* 238 */       ByteArrayOutputStream out = new ByteArrayOutputStream();
/*     */       
/* 240 */       byte[] buf = new byte[512];
/*     */       int len;
/* 242 */       while ((len = in.read(buf, 0, buf.length)) != -1) {
/* 243 */         out.write(buf, 0, len);
/*     */       }
/* 245 */       byte[] data = out.toByteArray();
/*     */       
/* 247 */       if (data.length == 0) {
/* 248 */         data = null;
/*     */       }
/* 250 */       in.close();
/* 251 */       out.close();
/* 252 */       return data;
/*     */     }
/* 254 */     catch (IOException e) {
/* 255 */       throw new SQLException(e.getClass().getName() + ":" + e.getMessage());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\RsetDataReader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */