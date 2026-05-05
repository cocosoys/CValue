/*     */ package net.minecraft.client.audio;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.resources.IResource;
/*     */ import net.minecraft.client.resources.IResourceManager;
/*     */ import net.minecraft.client.resources.IResourceManagerReloadListener;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.server.gui.IUpdatePlayerListBox;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.commons.lang3.ArrayUtils;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class SoundHandler
/*     */   implements IResourceManagerReloadListener, IUpdatePlayerListBox {
/*  31 */   private static final Logger field_147698_b = LogManager.getLogger();
/*     */   
/*  33 */   private static final Gson field_147699_c = (new GsonBuilder()).registerTypeAdapter(SoundList.class, new SoundListSerializer()).create();
/*     */   
/*  35 */   private static final ParameterizedType field_147696_d = new ParameterizedType() { private static final String __OBFID = "CL_00001148";
/*     */       
/*     */       public Type[] getActualTypeArguments() {
/*  38 */         return new Type[] { String.class, SoundList.class };
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Type getRawType() {
/*  46 */         return Map.class;
/*     */       }
/*     */ 
/*     */       
/*     */       public Type getOwnerType() {
/*  51 */         return null;
/*     */       } }
/*     */   ;
/*     */   
/*  55 */   public static final SoundPoolEntry field_147700_a = new SoundPoolEntry(new ResourceLocation("meta:missing_sound"), 0.0D, 0.0D, false);
/*     */   
/*  57 */   private final SoundRegistry field_147697_e = new SoundRegistry(); private final SoundManager field_147694_f;
/*     */   private final IResourceManager field_147695_g;
/*     */   private static final String __OBFID = "CL_00001147";
/*     */   
/*     */   public SoundHandler(IResourceManager p_i45122_1_, GameSettings p_i45122_2_) {
/*  62 */     this.field_147695_g = p_i45122_1_;
/*  63 */     this.field_147694_f = new SoundManager(this, p_i45122_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_110549_a(IResourceManager p_110549_1_) {
/*  68 */     this.field_147694_f.func_148596_a();
/*     */     
/*  70 */     this.field_147697_e.func_148763_c();
/*     */     
/*  72 */     for (String str : p_110549_1_.func_135055_a()) {
/*     */       try {
/*  74 */         List list = p_110549_1_.func_135056_b(new ResourceLocation(str, "sounds.json"));
/*     */         
/*  76 */         for (IResource iResource : list) {
/*     */           try {
/*  78 */             Map map = (Map)field_147699_c.fromJson(new InputStreamReader(iResource.func_110527_b()), field_147696_d);
/*  79 */             for (Map.Entry entry : map.entrySet()) {
/*  80 */               func_147693_a(new ResourceLocation(str, (String)entry.getKey()), (SoundList)entry.getValue());
/*     */             }
/*  82 */           } catch (RuntimeException runtimeException) {
/*  83 */             field_147698_b.warn("Invalid sounds.json", runtimeException);
/*     */           } 
/*     */         } 
/*  86 */       } catch (IOException iOException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_147693_a(ResourceLocation p_147693_1_, SoundList p_147693_2_) {
/*     */     SoundEventAccessorComposite soundEventAccessorComposite;
/*  93 */     if (!this.field_147697_e.func_148741_d(p_147693_1_) || p_147693_2_.func_148574_b()) {
/*  94 */       field_147698_b.debug("Registered/replaced new sound event location {}", new Object[] { p_147693_1_ });
/*  95 */       soundEventAccessorComposite = new SoundEventAccessorComposite(p_147693_1_, 1.0D, 1.0D, p_147693_2_.func_148573_c());
/*  96 */       this.field_147697_e.func_148762_a(soundEventAccessorComposite);
/*     */     } else {
/*  98 */       soundEventAccessorComposite = (SoundEventAccessorComposite)this.field_147697_e.func_82594_a(p_147693_1_);
/*     */     } 
/*     */     
/* 101 */     for (SoundList.SoundEntry soundEntry : p_147693_2_.func_148570_a()) {
/* 102 */       SoundEventAccessor soundEventAccessor; ISoundEventAccessor iSoundEventAccessor; ResourceLocation resourceLocation2; String str1 = soundEntry.func_148556_a();
/*     */       
/* 104 */       ResourceLocation resourceLocation1 = new ResourceLocation(str1);
/* 105 */       String str2 = str1.contains(":") ? resourceLocation1.func_110624_b() : p_147693_1_.func_110624_b();
/*     */ 
/*     */       
/* 108 */       switch (SwitchType.field_148765_a[soundEntry.func_148563_e().ordinal()]) {
/*     */         case 1:
/* 110 */           resourceLocation2 = new ResourceLocation(str2, "sounds/" + resourceLocation1.func_110623_a() + ".ogg");
/*     */           
/*     */           try {
/* 113 */             this.field_147695_g.func_110536_a(resourceLocation2);
/* 114 */           } catch (FileNotFoundException fileNotFoundException) {
/* 115 */             field_147698_b.warn("File {} does not exist, cannot add it to event {}", new Object[] { resourceLocation2, p_147693_1_ });
/*     */             continue;
/* 117 */           } catch (IOException iOException) {
/* 118 */             field_147698_b.warn("Could not load sound file " + resourceLocation2 + ", cannot add it to event " + p_147693_1_, iOException);
/*     */             
/*     */             continue;
/*     */           } 
/* 122 */           soundEventAccessor = new SoundEventAccessor(new SoundPoolEntry(resourceLocation2, soundEntry.func_148560_c(), soundEntry.func_148558_b(), soundEntry.func_148552_f()), soundEntry.func_148555_d());
/*     */           break;
/*     */         case 2:
/* 125 */           iSoundEventAccessor = new ISoundEventAccessor(this, str2, soundEntry) {
/* 126 */               final ResourceLocation field_148726_a = new ResourceLocation(this.field_148724_b, this.field_148725_c.func_148556_a());
/*     */               private static final String __OBFID = "CL_00001149";
/*     */               
/*     */               public int func_148721_a() {
/* 130 */                 SoundEventAccessorComposite soundEventAccessorComposite = (SoundEventAccessorComposite)this.field_148723_d.field_147697_e.func_82594_a(this.field_148726_a);
/* 131 */                 return (soundEventAccessorComposite == null) ? 0 : soundEventAccessorComposite.func_148721_a();
/*     */               }
/*     */ 
/*     */               
/*     */               public SoundPoolEntry func_148720_g() {
/* 136 */                 SoundEventAccessorComposite soundEventAccessorComposite = (SoundEventAccessorComposite)this.field_148723_d.field_147697_e.func_82594_a(this.field_148726_a);
/* 137 */                 return (soundEventAccessorComposite == null) ? SoundHandler.field_147700_a : soundEventAccessorComposite.func_148720_g();
/*     */               }
/*     */             };
/*     */           break;
/*     */         default:
/* 142 */           throw new IllegalStateException("IN YOU FACE");
/*     */       } 
/*     */       
/* 145 */       soundEventAccessorComposite.func_148727_a(iSoundEventAccessor);
/*     */     } 
/*     */   }
/*     */   
/*     */   public SoundEventAccessorComposite func_147680_a(ResourceLocation p_147680_1_) {
/* 150 */     return (SoundEventAccessorComposite)this.field_147697_e.func_82594_a(p_147680_1_);
/*     */   }
/*     */   
/*     */   public void func_147682_a(ISound p_147682_1_) {
/* 154 */     this.field_147694_f.func_148611_c(p_147682_1_);
/*     */   }
/*     */   
/*     */   public void func_147681_a(ISound p_147681_1_, int p_147681_2_) {
/* 158 */     this.field_147694_f.func_148599_a(p_147681_1_, p_147681_2_);
/*     */   }
/*     */   
/*     */   public void func_147691_a(EntityPlayer p_147691_1_, float p_147691_2_) {
/* 162 */     this.field_147694_f.func_148615_a(p_147691_1_, p_147691_2_);
/*     */   }
/*     */   
/*     */   public void func_147689_b() {
/* 166 */     this.field_147694_f.func_148610_e();
/*     */   }
/*     */   
/*     */   public void func_147690_c() {
/* 170 */     this.field_147694_f.func_148614_c();
/*     */   }
/*     */   
/*     */   public void func_147685_d() {
/* 174 */     this.field_147694_f.func_148613_b();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73660_a() {
/* 179 */     this.field_147694_f.func_148605_d();
/*     */   }
/*     */   
/*     */   public void func_147687_e() {
/* 183 */     this.field_147694_f.func_148604_f();
/*     */   }
/*     */   
/*     */   public void func_147684_a(SoundCategory p_147684_1_, float p_147684_2_) {
/* 187 */     if (p_147684_1_ == SoundCategory.MASTER && p_147684_2_ <= 0.0F) {
/* 188 */       func_147690_c();
/*     */     }
/*     */     
/* 191 */     this.field_147694_f.func_148601_a(p_147684_1_, p_147684_2_);
/*     */   }
/*     */   
/*     */   public void func_147683_b(ISound p_147683_1_) {
/* 195 */     this.field_147694_f.func_148602_b(p_147683_1_);
/*     */   }
/*     */   
/*     */   public SoundEventAccessorComposite func_147686_a(SoundCategory... p_147686_1_) {
/* 199 */     ArrayList<SoundEventAccessorComposite> arrayList = Lists.newArrayList();
/*     */     
/* 201 */     for (ResourceLocation resourceLocation : this.field_147697_e.func_148742_b()) {
/* 202 */       SoundEventAccessorComposite soundEventAccessorComposite = (SoundEventAccessorComposite)this.field_147697_e.func_82594_a(resourceLocation);
/* 203 */       if (ArrayUtils.contains((Object[])p_147686_1_, soundEventAccessorComposite.func_148728_d())) {
/* 204 */         arrayList.add(soundEventAccessorComposite);
/*     */       }
/*     */     } 
/*     */     
/* 208 */     if (arrayList.isEmpty()) {
/* 209 */       return null;
/*     */     }
/* 211 */     return arrayList.get((new Random()).nextInt(arrayList.size()));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_147692_c(ISound p_147692_1_) {
/* 216 */     return this.field_147694_f.func_148597_a(p_147692_1_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\SoundHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */