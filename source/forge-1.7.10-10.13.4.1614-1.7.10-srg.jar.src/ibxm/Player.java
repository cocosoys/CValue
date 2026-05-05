/*     */ package ibxm;
/*     */ 
/*     */ import java.io.DataInputStream;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import javax.sound.sampled.AudioFormat;
/*     */ import javax.sound.sampled.AudioSystem;
/*     */ import javax.sound.sampled.LineUnavailableException;
/*     */ import javax.sound.sampled.SourceDataLine;
/*     */ 
/*     */ public class Player
/*     */ {
/*     */   private Thread play_thread;
/*     */   private IBXM ibxm;
/*     */   private Module module;
/*     */   private int song_duration;
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/*  20 */     if (args.length < 1) {
/*  21 */       System.err.println("Usage: java ibxm.Player <module file>");
/*  22 */       System.exit(0);
/*     */     } 
/*  24 */     FileInputStream file_input_stream = new FileInputStream(args[0]);
/*  25 */     Player player = new Player();
/*  26 */     player.set_module(load_module(file_input_stream));
/*  27 */     file_input_stream.close();
/*  28 */     player.play();
/*     */   }
/*     */ 
/*     */   
/*     */   private int play_position;
/*     */   
/*     */   private boolean running;
/*     */   
/*     */   public static Module load_module(InputStream input) throws IllegalArgumentException, IOException {
/*  37 */     DataInputStream data_input_stream = new DataInputStream(input);
/*     */     
/*  39 */     byte[] xm_header = new byte[60];
/*  40 */     data_input_stream.readFully(xm_header);
/*  41 */     if (FastTracker2.is_xm(xm_header)) {
/*  42 */       return FastTracker2.load_xm(xm_header, data_input_stream);
/*     */     }
/*  44 */     byte[] s3m_header = new byte[96];
/*  45 */     System.arraycopy(xm_header, 0, s3m_header, 0, 60);
/*  46 */     data_input_stream.readFully(s3m_header, 60, 36);
/*  47 */     if (ScreamTracker3.is_s3m(s3m_header)) {
/*  48 */       return ScreamTracker3.load_s3m(s3m_header, data_input_stream);
/*     */     }
/*  50 */     byte[] mod_header = new byte[1084];
/*  51 */     System.arraycopy(s3m_header, 0, mod_header, 0, 96);
/*  52 */     data_input_stream.readFully(mod_header, 96, 988);
/*  53 */     return ProTracker.load_mod(mod_header, data_input_stream);
/*     */   }
/*     */   private boolean loop;
/*     */   private byte[] output_buffer;
/*     */   private SourceDataLine output_line;
/*     */   
/*     */   public Player() throws LineUnavailableException {
/*  60 */     this.ibxm = new IBXM(48000);
/*  61 */     set_loop(true);
/*  62 */     this.output_line = AudioSystem.getSourceDataLine(new AudioFormat(48000.0F, 16, 2, true, true));
/*  63 */     this.output_buffer = new byte[4096];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set_module(Module m) {
/*  70 */     if (m != null) this.module = m; 
/*  71 */     stop();
/*  72 */     this.ibxm.set_module(this.module);
/*  73 */     this.song_duration = this.ibxm.calculate_song_duration();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set_loop(boolean loop) {
/*  81 */     this.loop = loop;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void play() {
/*  89 */     stop();
/*  90 */     this.play_thread = new Thread(new Driver());
/*  91 */     this.play_thread.start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stop() {
/*  98 */     this.running = false;
/*  99 */     if (this.play_thread != null)
/*     */       try {
/* 101 */         this.play_thread.join();
/* 102 */       } catch (InterruptedException interruptedException) {} 
/*     */   }
/*     */   
/*     */   private class Driver implements Runnable {
/*     */     private Driver() {}
/*     */     
/*     */     public void run() {
/* 109 */       if (Player.this.running)
/*     */         return;  try {
/* 111 */         Player.this.output_line.open();
/* 112 */         Player.this.output_line.start();
/* 113 */         Player.this.play_position = 0;
/* 114 */         Player.this.running = true;
/* 115 */         while (Player.this.running) {
/* 116 */           int frames = Player.this.song_duration - Player.this.play_position;
/* 117 */           if (frames > 1024) frames = 1024; 
/* 118 */           Player.this.ibxm.get_audio(Player.this.output_buffer, frames);
/* 119 */           Player.this.output_line.write(Player.this.output_buffer, 0, frames * 4);
/* 120 */           Player.this.play_position = Player.this.play_position + frames;
/* 121 */           if (Player.this.play_position >= Player.this.song_duration) {
/* 122 */             Player.this.play_position = 0;
/* 123 */             if (!Player.this.loop) Player.this.running = false; 
/*     */           } 
/*     */         } 
/* 126 */         Player.this.output_line.drain();
/* 127 */         Player.this.output_line.close();
/* 128 */       } catch (LineUnavailableException lue) {
/* 129 */         lue.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\ibxm\Player.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */