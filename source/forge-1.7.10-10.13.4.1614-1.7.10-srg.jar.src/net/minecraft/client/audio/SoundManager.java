/*     */ package net.minecraft.client.audio;
/*     */ import com.google.common.collect.BiMap;
/*     */ import com.google.common.collect.HashBiMap;
/*     */ import com.google.common.collect.HashMultimap;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Multimap;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.net.URLStreamHandler;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.apache.logging.log4j.Marker;
/*     */ import org.apache.logging.log4j.MarkerManager;
/*     */ import paulscode.sound.SoundSystemConfig;
/*     */ import paulscode.sound.SoundSystemException;
/*     */ import paulscode.sound.Source;
/*     */ import paulscode.sound.codecs.CodecJOrbis;
/*     */ import paulscode.sound.libraries.LibraryLWJGLOpenAL;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class SoundManager {
/*  35 */   private static final Marker field_148623_a = MarkerManager.getMarker("SOUNDS");
/*  36 */   private static final Logger field_148621_b = LogManager.getLogger();
/*     */ 
/*     */   
/*     */   public final SoundHandler field_148622_c;
/*     */ 
/*     */   
/*     */   private final GameSettings field_148619_d;
/*     */ 
/*     */   
/*     */   private SoundSystemStarterThread field_148620_e;
/*     */   
/*     */   private boolean field_148617_f;
/*     */   
/*  49 */   private int field_148618_g = 0;
/*     */   
/*  51 */   private final Map field_148629_h = (Map)HashBiMap.create();
/*  52 */   private final Map field_148630_i = (Map)((BiMap)this.field_148629_h).inverse();
/*  53 */   private Map field_148627_j = Maps.newHashMap();
/*  54 */   private final Multimap field_148628_k = (Multimap)HashMultimap.create();
/*     */   
/*  56 */   private final List field_148625_l = Lists.newArrayList();
/*  57 */   private final Map field_148626_m = Maps.newHashMap();
/*  58 */   private final Map field_148624_n = Maps.newHashMap(); private static final String __OBFID = "CL_00001141";
/*     */   
/*     */   public SoundManager(SoundHandler p_i45119_1_, GameSettings p_i45119_2_) {
/*  61 */     this.field_148622_c = p_i45119_1_;
/*  62 */     this.field_148619_d = p_i45119_2_;
/*     */ 
/*     */     
/*     */     try {
/*  66 */       SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
/*  67 */       SoundSystemConfig.setCodec("ogg", CodecJOrbis.class);
/*  68 */     } catch (SoundSystemException soundSystemException) {
/*  69 */       field_148621_b.error(field_148623_a, "Error linking with the LibraryJavaSound plug-in", (Throwable)soundSystemException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_148596_a() {
/*  74 */     func_148613_b();
/*  75 */     func_148608_i();
/*     */   }
/*     */   
/*     */   private synchronized void func_148608_i() {
/*  79 */     if (this.field_148617_f)
/*     */       return; 
/*     */     try {
/*  82 */       (new Thread(new Runnable(this) { private static final String __OBFID = "CL_00001142";
/*     */             
/*     */             public void run() {
/*  85 */               this.field_148631_a.field_148620_e = new SoundManager.SoundSystemStarterThread();
/*  86 */               this.field_148631_a.field_148617_f = true;
/*  87 */               this.field_148631_a.field_148620_e.setMasterVolume(this.field_148631_a.field_148619_d.func_151438_a(SoundCategory.MASTER));
/*  88 */               SoundManager.field_148621_b.info(SoundManager.field_148623_a, "Sound engine started");
/*     */             } }
/*     */           "Sound Library Loader")).start();
/*  91 */     } catch (RuntimeException runtimeException) {
/*  92 */       field_148621_b.error(field_148623_a, "Error starting SoundSystem. Turning off sounds & music", runtimeException);
/*     */       
/*  94 */       this.field_148619_d.func_151439_a(SoundCategory.MASTER, 0.0F);
/*  95 */       this.field_148619_d.func_74303_b();
/*     */     } 
/*     */   }
/*     */   
/*     */   private float func_148595_a(SoundCategory p_148595_1_) {
/* 100 */     if (p_148595_1_ == null || p_148595_1_ == SoundCategory.MASTER) {
/* 101 */       return 1.0F;
/*     */     }
/*     */     
/* 104 */     return this.field_148619_d.func_151438_a(p_148595_1_);
/*     */   }
/*     */   
/*     */   public void func_148601_a(SoundCategory p_148601_1_, float p_148601_2_) {
/* 108 */     if (!this.field_148617_f) {
/*     */       return;
/*     */     }
/*     */     
/* 112 */     if (p_148601_1_ == SoundCategory.MASTER) {
/* 113 */       this.field_148620_e.setMasterVolume(p_148601_2_);
/*     */       
/*     */       return;
/*     */     } 
/* 117 */     for (String str : this.field_148628_k.get(p_148601_1_)) {
/* 118 */       ISound iSound = (ISound)this.field_148629_h.get(str);
/* 119 */       float f = func_148594_a(iSound, (SoundPoolEntry)this.field_148627_j.get(iSound), p_148601_1_);
/* 120 */       if (f <= 0.0F) {
/* 121 */         func_148602_b(iSound); continue;
/*     */       } 
/* 123 */       this.field_148620_e.setVolume(str, f);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148613_b() {
/* 129 */     if (this.field_148617_f) {
/* 130 */       func_148614_c();
/*     */       
/* 132 */       this.field_148620_e.cleanup();
/* 133 */       this.field_148617_f = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_148614_c() {
/* 138 */     if (this.field_148617_f) {
/* 139 */       for (String str : this.field_148629_h.keySet()) {
/* 140 */         this.field_148620_e.stop(str);
/*     */       }
/* 142 */       this.field_148629_h.clear();
/* 143 */       this.field_148626_m.clear();
/* 144 */       this.field_148625_l.clear();
/* 145 */       this.field_148628_k.clear();
/* 146 */       this.field_148627_j.clear();
/* 147 */       this.field_148624_n.clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_148605_d() {
/* 152 */     this.field_148618_g++;
/*     */ 
/*     */     
/* 155 */     for (ITickableSound iTickableSound : this.field_148625_l) {
/* 156 */       iTickableSound.func_73660_a();
/*     */       
/* 158 */       if (iTickableSound.func_147667_k()) {
/* 159 */         func_148602_b(iTickableSound); continue;
/*     */       } 
/* 161 */       String str = (String)this.field_148630_i.get(iTickableSound);
/*     */       
/* 163 */       this.field_148620_e.setVolume(str, func_148594_a(iTickableSound, (SoundPoolEntry)this.field_148627_j.get(iTickableSound), this.field_148622_c.func_147680_a(iTickableSound.func_147650_b()).func_148728_d()));
/* 164 */       this.field_148620_e.setPitch(str, func_148606_a(iTickableSound, (SoundPoolEntry)this.field_148627_j.get(iTickableSound)));
/* 165 */       this.field_148620_e.setPosition(str, iTickableSound.func_147649_g(), iTickableSound.func_147654_h(), iTickableSound.func_147651_i());
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 170 */     Iterator<Map.Entry> iterator1 = this.field_148629_h.entrySet().iterator();
/* 171 */     while (iterator1.hasNext()) {
/* 172 */       Map.Entry entry = iterator1.next();
/*     */       
/* 174 */       String str = (String)entry.getKey();
/* 175 */       ISound iSound = (ISound)entry.getValue();
/*     */       
/* 177 */       if (!this.field_148620_e.playing(str)) {
/* 178 */         int i = ((Integer)this.field_148624_n.get(str)).intValue();
/* 179 */         if (i <= this.field_148618_g) {
/* 180 */           int j = iSound.func_147652_d();
/* 181 */           if (iSound.func_147657_c() && j > 0) {
/* 182 */             this.field_148626_m.put(iSound, Integer.valueOf(this.field_148618_g + j));
/*     */           }
/* 184 */           iterator1.remove();
/* 185 */           field_148621_b.debug(field_148623_a, "Removed channel {} because it's not playing anymore", new Object[] { str });
/* 186 */           this.field_148620_e.removeSource(str);
/* 187 */           this.field_148624_n.remove(str);
/*     */           
/* 189 */           this.field_148627_j.remove(iSound);
/*     */           try {
/* 191 */             this.field_148628_k.remove(this.field_148622_c.func_147680_a(iSound.func_147650_b()).func_148728_d(), str);
/* 192 */           } catch (RuntimeException runtimeException) {}
/*     */ 
/*     */ 
/*     */           
/* 196 */           if (iSound instanceof ITickableSound) {
/* 197 */             this.field_148625_l.remove(iSound);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 203 */     Iterator<Map.Entry> iterator2 = this.field_148626_m.entrySet().iterator();
/* 204 */     while (iterator2.hasNext()) {
/* 205 */       Map.Entry entry = iterator2.next();
/*     */       
/* 207 */       if (this.field_148618_g >= ((Integer)entry.getValue()).intValue()) {
/* 208 */         ISound iSound = (ISound)entry.getKey();
/*     */ 
/*     */         
/* 211 */         if (iSound instanceof ITickableSound) {
/* 212 */           ((ITickableSound)iSound).func_73660_a();
/*     */         }
/*     */         
/* 215 */         func_148611_c(iSound);
/* 216 */         iterator2.remove();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_148597_a(ISound p_148597_1_) {
/* 222 */     if (!this.field_148617_f) return false;
/*     */     
/* 224 */     String str = (String)this.field_148630_i.get(p_148597_1_);
/* 225 */     if (str == null) return false;
/*     */     
/* 227 */     return (this.field_148620_e.playing(str) || (this.field_148624_n.containsKey(str) && ((Integer)this.field_148624_n.get(str)).intValue() <= this.field_148618_g));
/*     */   }
/*     */   
/*     */   public void func_148602_b(ISound p_148602_1_) {
/* 231 */     if (!this.field_148617_f)
/*     */       return; 
/* 233 */     String str = (String)this.field_148630_i.get(p_148602_1_);
/* 234 */     if (str != null) {
/* 235 */       this.field_148620_e.stop(str);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_148611_c(ISound p_148611_1_) {
/* 240 */     if (!this.field_148617_f)
/*     */       return; 
/* 242 */     if (this.field_148620_e.getMasterVolume() <= 0.0F) {
/* 243 */       field_148621_b.debug(field_148623_a, "Skipped playing soundEvent: {}, master volume was zero", new Object[] { p_148611_1_.func_147650_b() });
/*     */       
/*     */       return;
/*     */     } 
/* 247 */     SoundEventAccessorComposite soundEventAccessorComposite = this.field_148622_c.func_147680_a(p_148611_1_.func_147650_b());
/* 248 */     if (soundEventAccessorComposite == null) {
/* 249 */       field_148621_b.warn(field_148623_a, "Unable to play unknown soundEvent: {}", new Object[] { p_148611_1_.func_147650_b() });
/*     */       
/*     */       return;
/*     */     } 
/* 253 */     SoundPoolEntry soundPoolEntry = soundEventAccessorComposite.func_148720_g();
/* 254 */     if (soundPoolEntry == SoundHandler.field_147700_a) {
/* 255 */       field_148621_b.warn(field_148623_a, "Unable to play empty soundEvent: {}", new Object[] { soundEventAccessorComposite.func_148729_c() });
/*     */       
/*     */       return;
/*     */     } 
/* 259 */     float f1 = p_148611_1_.func_147653_e();
/* 260 */     float f2 = 16.0F;
/* 261 */     if (f1 > 1.0F) f2 *= f1;
/*     */     
/* 263 */     SoundCategory soundCategory = soundEventAccessorComposite.func_148728_d();
/* 264 */     float f3 = func_148594_a(p_148611_1_, soundPoolEntry, soundCategory);
/* 265 */     double d = func_148606_a(p_148611_1_, soundPoolEntry);
/*     */     
/* 267 */     ResourceLocation resourceLocation = soundPoolEntry.func_148652_a();
/* 268 */     if (f3 == 0.0F) {
/* 269 */       field_148621_b.debug(field_148623_a, "Skipped playing sound {}, volume was zero.", new Object[] { resourceLocation });
/*     */       
/*     */       return;
/*     */     } 
/* 273 */     boolean bool = (p_148611_1_.func_147657_c() && p_148611_1_.func_147652_d() == 0) ? true : false;
/*     */     
/* 275 */     String str = UUID.randomUUID().toString();
/*     */     
/* 277 */     if (soundPoolEntry.func_148648_d()) {
/* 278 */       this.field_148620_e.newStreamingSource(false, str, func_148612_a(resourceLocation), resourceLocation.toString(), bool, p_148611_1_.func_147649_g(), p_148611_1_.func_147654_h(), p_148611_1_.func_147651_i(), p_148611_1_.func_147656_j().func_148586_a(), f2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 291 */       this.field_148620_e.newSource(false, str, func_148612_a(resourceLocation), resourceLocation.toString(), bool, p_148611_1_.func_147649_g(), p_148611_1_.func_147654_h(), p_148611_1_.func_147651_i(), p_148611_1_.func_147656_j().func_148586_a(), f2);
/*     */     } 
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
/* 305 */     field_148621_b.debug(field_148623_a, "Playing sound {} for event {} as channel {}", new Object[] { soundPoolEntry.func_148652_a(), soundEventAccessorComposite.func_148729_c(), str });
/*     */     
/* 307 */     this.field_148620_e.setPitch(str, (float)d);
/* 308 */     this.field_148620_e.setVolume(str, f3);
/* 309 */     this.field_148620_e.play(str);
/*     */     
/* 311 */     this.field_148624_n.put(str, Integer.valueOf(this.field_148618_g + 20));
/* 312 */     this.field_148629_h.put(str, p_148611_1_);
/* 313 */     this.field_148627_j.put(p_148611_1_, soundPoolEntry);
/*     */     
/* 315 */     if (soundCategory != SoundCategory.MASTER) {
/* 316 */       this.field_148628_k.put(soundCategory, str);
/*     */     }
/*     */     
/* 319 */     if (p_148611_1_ instanceof ITickableSound) {
/* 320 */       this.field_148625_l.add((ITickableSound)p_148611_1_);
/*     */     }
/*     */   }
/*     */   
/*     */   private float func_148606_a(ISound p_148606_1_, SoundPoolEntry p_148606_2_) {
/* 325 */     return (float)MathHelper.func_151237_a(p_148606_1_.func_147655_f() * p_148606_2_.func_148650_b(), 0.5D, 2.0D);
/*     */   }
/*     */   
/*     */   private float func_148594_a(ISound p_148594_1_, SoundPoolEntry p_148594_2_, SoundCategory p_148594_3_) {
/* 329 */     return (float)MathHelper.func_151237_a(p_148594_1_.func_147653_e() * p_148594_2_.func_148649_c() * func_148595_a(p_148594_3_), 0.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public void func_148610_e() {
/* 333 */     for (String str : this.field_148629_h.keySet()) {
/* 334 */       field_148621_b.debug(field_148623_a, "Pausing channel {}", new Object[] { str });
/* 335 */       this.field_148620_e.pause(str);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_148604_f() {
/* 340 */     for (String str : this.field_148629_h.keySet()) {
/* 341 */       field_148621_b.debug(field_148623_a, "Resuming channel {}", new Object[] { str });
/* 342 */       this.field_148620_e.play(str);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_148599_a(ISound p_148599_1_, int p_148599_2_) {
/* 347 */     this.field_148626_m.put(p_148599_1_, Integer.valueOf(this.field_148618_g + p_148599_2_));
/*     */   }
/*     */   
/*     */   private static URL func_148612_a(ResourceLocation p_148612_0_) {
/* 351 */     String str = String.format("%s:%s:%s", new Object[] { "mcsounddomain", p_148612_0_.func_110624_b(), p_148612_0_.func_110623_a() });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 357 */     URLStreamHandler uRLStreamHandler = new URLStreamHandler(p_148612_0_) { private static final String __OBFID = "CL_00001143";
/*     */         
/*     */         protected URLConnection openConnection(URL p_openConnection_1_) {
/* 360 */           return new URLConnection(this, p_openConnection_1_)
/*     */             {
/*     */               private static final String __OBFID = "CL_00001144";
/*     */ 
/*     */               
/*     */               public void connect() {}
/*     */               
/*     */               public InputStream getInputStream() throws IOException {
/* 368 */                 return Minecraft.func_71410_x().func_110442_L().func_110536_a(this.field_148593_a.field_148592_a).func_110527_b();
/*     */               }
/*     */             };
/*     */         } }
/*     */       ;
/*     */     
/*     */     try {
/* 375 */       return new URL(null, str, uRLStreamHandler);
/* 376 */     } catch (MalformedURLException malformedURLException) {
/* 377 */       throw new Error("TODO: Sanely handle url exception! :D");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148615_a(EntityPlayer p_148615_1_, float p_148615_2_) {
/* 383 */     if (!this.field_148617_f || p_148615_1_ == null)
/*     */       return; 
/* 385 */     float f1 = p_148615_1_.field_70127_C + (p_148615_1_.field_70125_A - p_148615_1_.field_70127_C) * p_148615_2_;
/* 386 */     float f2 = p_148615_1_.field_70126_B + (p_148615_1_.field_70177_z - p_148615_1_.field_70126_B) * p_148615_2_;
/*     */     
/* 388 */     double d1 = p_148615_1_.field_70169_q + (p_148615_1_.field_70165_t - p_148615_1_.field_70169_q) * p_148615_2_;
/* 389 */     double d2 = p_148615_1_.field_70167_r + (p_148615_1_.field_70163_u - p_148615_1_.field_70167_r) * p_148615_2_;
/* 390 */     double d3 = p_148615_1_.field_70166_s + (p_148615_1_.field_70161_v - p_148615_1_.field_70166_s) * p_148615_2_;
/*     */     
/* 392 */     float f3 = MathHelper.func_76134_b((f2 + 90.0F) * 0.017453292F);
/* 393 */     float f4 = MathHelper.func_76126_a((f2 + 90.0F) * 0.017453292F);
/*     */     
/* 395 */     float f5 = MathHelper.func_76134_b(-f1 * 0.017453292F);
/* 396 */     float f6 = MathHelper.func_76126_a(-f1 * 0.017453292F);
/*     */     
/* 398 */     float f7 = MathHelper.func_76134_b((-f1 + 90.0F) * 0.017453292F);
/* 399 */     float f8 = MathHelper.func_76126_a((-f1 + 90.0F) * 0.017453292F);
/*     */     
/* 401 */     float f9 = f3 * f5;
/* 402 */     float f10 = f6;
/* 403 */     float f11 = f4 * f5;
/*     */     
/* 405 */     float f12 = f3 * f7;
/* 406 */     float f13 = f8;
/* 407 */     float f14 = f4 * f7;
/*     */     
/* 409 */     this.field_148620_e.setListenerPosition((float)d1, (float)d2, (float)d3);
/* 410 */     this.field_148620_e.setListenerOrientation(f9, f10, f11, f12, f13, f14);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   class SoundSystemStarterThread extends SoundSystem { private static final String __OBFID = "CL_00001145";
/*     */     private SoundSystemStarterThread(SoundManager p_i45117_1_) {}
/*     */     
/*     */     public boolean playing(String p_playing_1_) {
/* 417 */       synchronized (SoundSystemConfig.THREAD_SYNC) {
/* 418 */         if (this.soundLibrary == null) return false;
/*     */         
/* 420 */         Source source = (Source)this.soundLibrary.getSources().get(p_playing_1_);
/* 421 */         if (source == null) return false;
/*     */         
/* 423 */         return (source.playing() || source.paused() || source.preLoad);
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\SoundManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */