/*     */ package paulscode.sound.codecs;
/*     */ 
/*     */ import ibxm.FastTracker2;
/*     */ import ibxm.IBXM;
/*     */ import ibxm.Module;
/*     */ import ibxm.ProTracker;
/*     */ import ibxm.ScreamTracker3;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.ShortBuffer;
/*     */ import javax.sound.sampled.AudioFormat;
/*     */ import paulscode.sound.ICodec;
/*     */ import paulscode.sound.SoundBuffer;
/*     */ import paulscode.sound.SoundSystemConfig;
/*     */ import paulscode.sound.SoundSystemLogger;
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
/*     */ public class CodecIBXM
/*     */   implements ICodec
/*     */ {
/*     */   private static final boolean GET = false;
/*     */   private static final boolean SET = true;
/*     */   private static final boolean XXX = false;
/*     */   private boolean endOfStream = false;
/*     */   private boolean initialized = false;
/* 123 */   private AudioFormat myAudioFormat = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean reverseBytes = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private IBXM ibxm;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Module module;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int songDuration;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int playPosition;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SoundSystemLogger logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CodecIBXM() {
/* 161 */     this.logger = SoundSystemConfig.getLogger();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void reverseByteOrder(boolean b) {
/* 176 */     this.reverseBytes = b;
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
/*     */   public boolean initialize(URL url) {
/* 188 */     initialized(true, false);
/* 189 */     cleanup();
/*     */     
/* 191 */     if (url == null) {
/*     */       
/* 193 */       errorMessage("url null in method 'initialize'");
/* 194 */       cleanup();
/* 195 */       return false;
/*     */     } 
/*     */     
/* 198 */     InputStream is = null;
/*     */ 
/*     */     
/*     */     try {
/* 202 */       is = url.openStream();
/*     */     }
/* 204 */     catch (IOException ioe) {
/*     */       
/* 206 */       errorMessage("Unable to open stream in method 'initialize'");
/* 207 */       printStackTrace(ioe);
/* 208 */       return false;
/*     */     } 
/*     */     
/* 211 */     if (this.ibxm == null)
/* 212 */       this.ibxm = new IBXM(48000); 
/* 213 */     if (this.myAudioFormat == null) {
/* 214 */       this.myAudioFormat = new AudioFormat(48000.0F, 16, 2, true, true);
/*     */     }
/*     */     
/*     */     try {
/* 218 */       setModule(loadModule(is));
/*     */     }
/* 220 */     catch (IllegalArgumentException iae) {
/*     */       
/* 222 */       errorMessage("Illegal argument in method 'initialize'");
/* 223 */       printStackTrace(iae);
/* 224 */       if (is != null) {
/*     */         
/*     */         try {
/*     */           
/* 228 */           is.close();
/*     */         }
/* 230 */         catch (IOException iOException) {}
/*     */       }
/*     */       
/* 233 */       return false;
/*     */     }
/* 235 */     catch (IOException ioe) {
/*     */       
/* 237 */       errorMessage("Error loading module in method 'initialize'");
/* 238 */       printStackTrace(ioe);
/* 239 */       if (is != null) {
/*     */         
/*     */         try {
/*     */           
/* 243 */           is.close();
/*     */         }
/* 245 */         catch (IOException iOException) {}
/*     */       }
/*     */       
/* 248 */       return false;
/*     */     } 
/*     */     
/* 251 */     if (is != null) {
/*     */       
/*     */       try {
/*     */         
/* 255 */         is.close();
/*     */       }
/* 257 */       catch (IOException iOException) {}
/*     */     }
/*     */ 
/*     */     
/* 261 */     endOfStream(true, false);
/* 262 */     initialized(true, true);
/* 263 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean initialized() {
/* 273 */     return initialized(false, false);
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
/*     */   public SoundBuffer read() {
/* 285 */     if (endOfStream(false, false)) {
/* 286 */       return null;
/*     */     }
/* 288 */     if (this.module == null) {
/*     */       
/* 290 */       errorMessage("Module null in method 'read'");
/* 291 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 295 */     if (this.myAudioFormat == null) {
/*     */       
/* 297 */       errorMessage("Audio Format null in method 'read'");
/* 298 */       return null;
/*     */     } 
/*     */     
/* 301 */     int bufferFrameSize = SoundSystemConfig.getStreamingBufferSize() / 4;
/*     */ 
/*     */     
/* 304 */     int frames = this.songDuration - this.playPosition;
/* 305 */     if (frames > bufferFrameSize) {
/* 306 */       frames = bufferFrameSize;
/*     */     }
/* 308 */     if (frames <= 0) {
/*     */       
/* 310 */       endOfStream(true, true);
/* 311 */       return null;
/*     */     } 
/* 313 */     byte[] outputBuffer = new byte[frames * 4];
/*     */     
/* 315 */     this.ibxm.get_audio(outputBuffer, frames);
/*     */     
/* 317 */     this.playPosition += frames;
/* 318 */     if (this.playPosition >= this.songDuration)
/*     */     {
/* 320 */       endOfStream(true, true);
/*     */     }
/*     */ 
/*     */     
/* 324 */     if (this.reverseBytes) {
/* 325 */       reverseBytes(outputBuffer, 0, frames * 4);
/*     */     }
/*     */     
/* 328 */     SoundBuffer buffer = new SoundBuffer(outputBuffer, this.myAudioFormat);
/*     */     
/* 330 */     return buffer;
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
/*     */   
/*     */   public SoundBuffer readAll() {
/* 343 */     if (this.module == null) {
/*     */       
/* 345 */       errorMessage("Module null in method 'readAll'");
/* 346 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 350 */     if (this.myAudioFormat == null) {
/*     */       
/* 352 */       errorMessage("Audio Format null in method 'readAll'");
/* 353 */       return null;
/*     */     } 
/*     */     
/* 356 */     int bufferFrameSize = SoundSystemConfig.getFileChunkSize() / 4;
/*     */ 
/*     */     
/* 359 */     byte[] outputBuffer = new byte[bufferFrameSize * 4];
/*     */ 
/*     */     
/* 362 */     byte[] fullBuffer = null;
/*     */ 
/*     */ 
/*     */     
/* 366 */     int totalBytes = 0;
/*     */     
/* 368 */     while (!endOfStream(false, false) && totalBytes < 
/* 369 */       SoundSystemConfig.getMaxFileSize()) {
/*     */       
/* 371 */       int frames = this.songDuration - this.playPosition;
/* 372 */       if (frames > bufferFrameSize)
/* 373 */         frames = bufferFrameSize; 
/* 374 */       this.ibxm.get_audio(outputBuffer, frames);
/* 375 */       totalBytes += frames * 4;
/*     */       
/* 377 */       fullBuffer = appendByteArrays(fullBuffer, outputBuffer, frames * 4);
/*     */ 
/*     */       
/* 380 */       this.playPosition += frames;
/* 381 */       if (this.playPosition >= this.songDuration)
/*     */       {
/* 383 */         endOfStream(true, true);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 388 */     if (this.reverseBytes) {
/* 389 */       reverseBytes(fullBuffer, 0, totalBytes);
/*     */     }
/*     */     
/* 392 */     SoundBuffer buffer = new SoundBuffer(fullBuffer, this.myAudioFormat);
/*     */     
/* 394 */     return buffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean endOfStream() {
/* 404 */     return endOfStream(false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cleanup() {
/* 415 */     this.playPosition = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AudioFormat getAudioFormat() {
/* 426 */     return this.myAudioFormat;
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
/*     */   private static Module loadModule(InputStream input) throws IllegalArgumentException, IOException {
/* 438 */     DataInputStream data_input_stream = new DataInputStream(input);
/*     */ 
/*     */     
/* 441 */     byte[] xm_header = new byte[60];
/* 442 */     data_input_stream.readFully(xm_header);
/* 443 */     if (FastTracker2.is_xm(xm_header)) {
/* 444 */       return FastTracker2.load_xm(xm_header, data_input_stream);
/*     */     }
/*     */     
/* 447 */     byte[] s3m_header = new byte[96];
/* 448 */     System.arraycopy(xm_header, 0, s3m_header, 0, 60);
/* 449 */     data_input_stream.readFully(s3m_header, 60, 36);
/* 450 */     if (ScreamTracker3.is_s3m(s3m_header)) {
/* 451 */       return ScreamTracker3.load_s3m(s3m_header, data_input_stream);
/*     */     }
/*     */     
/* 454 */     byte[] mod_header = new byte[1084];
/* 455 */     System.arraycopy(s3m_header, 0, mod_header, 0, 96);
/* 456 */     data_input_stream.readFully(mod_header, 96, 988);
/* 457 */     return ProTracker.load_mod(mod_header, data_input_stream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setModule(Module m) {
/* 465 */     if (m != null)
/* 466 */       this.module = m; 
/* 467 */     this.ibxm.set_module(this.module);
/* 468 */     this.songDuration = this.ibxm.calculate_song_duration();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private synchronized boolean initialized(boolean action, boolean value) {
/* 479 */     if (action == true)
/* 480 */       this.initialized = value; 
/* 481 */     return this.initialized;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private synchronized boolean endOfStream(boolean action, boolean value) {
/* 492 */     if (action == true)
/* 493 */       this.endOfStream = value; 
/* 494 */     return this.endOfStream;
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
/*     */   private static byte[] trimArray(byte[] array, int maxLength) {
/* 506 */     byte[] trimmedArray = null;
/* 507 */     if (array != null && array.length > maxLength) {
/*     */       
/* 509 */       trimmedArray = new byte[maxLength];
/* 510 */       System.arraycopy(array, 0, trimmedArray, 0, maxLength);
/*     */     } 
/* 512 */     return trimmedArray;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void reverseBytes(byte[] buffer) {
/* 521 */     reverseBytes(buffer, 0, buffer.length);
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
/*     */   
/*     */   public static void reverseBytes(byte[] buffer, int offset, int size) {
/* 534 */     for (int i = offset; i < offset + size; i += 2) {
/*     */       
/* 536 */       byte b = buffer[i];
/* 537 */       buffer[i] = buffer[i + 1];
/* 538 */       buffer[i + 1] = b;
/*     */     } 
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
/*     */   private static byte[] convertAudioBytes(byte[] audio_bytes, boolean two_bytes_data) {
/* 551 */     ByteBuffer dest = ByteBuffer.allocateDirect(audio_bytes.length);
/* 552 */     dest.order(ByteOrder.nativeOrder());
/* 553 */     ByteBuffer src = ByteBuffer.wrap(audio_bytes);
/* 554 */     src.order(ByteOrder.LITTLE_ENDIAN);
/* 555 */     if (two_bytes_data) {
/*     */       
/* 557 */       ShortBuffer dest_short = dest.asShortBuffer();
/* 558 */       ShortBuffer src_short = src.asShortBuffer();
/* 559 */       while (src_short.hasRemaining())
/*     */       {
/* 561 */         dest_short.put(src_short.get());
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 566 */       while (src.hasRemaining())
/*     */       {
/* 568 */         dest.put(src.get());
/*     */       }
/*     */     } 
/* 571 */     dest.rewind();
/*     */     
/* 573 */     if (!dest.hasArray()) {
/*     */       
/* 575 */       byte[] arrayBackedBuffer = new byte[dest.capacity()];
/* 576 */       dest.get(arrayBackedBuffer);
/* 577 */       dest.clear();
/*     */       
/* 579 */       return arrayBackedBuffer;
/*     */     } 
/*     */     
/* 582 */     return dest.array();
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
/*     */ 
/*     */   
/*     */   private static byte[] appendByteArrays(byte[] arrayOne, byte[] arrayTwo, int length) {
/*     */     byte[] newArray;
/* 597 */     if (arrayOne == null && arrayTwo == null)
/*     */     {
/*     */       
/* 600 */       return null;
/*     */     }
/* 602 */     if (arrayOne == null) {
/*     */ 
/*     */       
/* 605 */       newArray = new byte[length];
/*     */       
/* 607 */       System.arraycopy(arrayTwo, 0, newArray, 0, length);
/* 608 */       arrayTwo = null;
/*     */     }
/* 610 */     else if (arrayTwo == null) {
/*     */ 
/*     */       
/* 613 */       newArray = new byte[arrayOne.length];
/*     */       
/* 615 */       System.arraycopy(arrayOne, 0, newArray, 0, arrayOne.length);
/* 616 */       arrayOne = null;
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 621 */       newArray = new byte[arrayOne.length + length];
/* 622 */       System.arraycopy(arrayOne, 0, newArray, 0, arrayOne.length);
/*     */       
/* 624 */       System.arraycopy(arrayTwo, 0, newArray, arrayOne.length, length);
/*     */       
/* 626 */       arrayOne = null;
/* 627 */       arrayTwo = null;
/*     */     } 
/*     */     
/* 630 */     return newArray;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void errorMessage(String message) {
/* 639 */     this.logger.errorMessage("CodecWav", message, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void printStackTrace(Exception e) {
/* 648 */     this.logger.printStackTrace(e, 1);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\paulscode\sound\codecs\CodecIBXM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */