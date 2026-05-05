/*     */ package net.minecraft.client.resources;
/*     */ import com.google.common.cache.CacheLoader;
/*     */ import com.google.common.cache.LoadingCache;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import com.mojang.authlib.minecraft.InsecureTextureException;
/*     */ import com.mojang.authlib.minecraft.MinecraftProfileTexture;
/*     */ import com.mojang.authlib.minecraft.MinecraftSessionService;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import java.util.concurrent.ThreadPoolExecutor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.IImageBuffer;
/*     */ import net.minecraft.client.renderer.ImageBufferDownload;
/*     */ import net.minecraft.client.renderer.ThreadDownloadImageData;
/*     */ import net.minecraft.client.renderer.texture.ITextureObject;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class SkinManager {
/*  29 */   public static final ResourceLocation field_152793_a = new ResourceLocation("textures/entity/steve.png");
/*  30 */   private static final ExecutorService field_152794_b = new ThreadPoolExecutor(0, 2, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
/*     */   private final TextureManager field_152795_c;
/*     */   private final File field_152796_d;
/*     */   private final MinecraftSessionService field_152797_e;
/*     */   private final LoadingCache field_152798_f;
/*     */   private static final String __OBFID = "CL_00001830";
/*     */   
/*     */   public SkinManager(TextureManager p_i1044_1_, File p_i1044_2_, MinecraftSessionService p_i1044_3_) {
/*  38 */     this.field_152795_c = p_i1044_1_;
/*  39 */     this.field_152796_d = p_i1044_2_;
/*  40 */     this.field_152797_e = p_i1044_3_;
/*     */     
/*  42 */     this.field_152798_f = CacheBuilder.newBuilder().expireAfterAccess(15L, TimeUnit.SECONDS).build(new CacheLoader(this)
/*     */         {
/*     */           private static final String __OBFID = "CL_00001829";
/*     */ 
/*     */           
/*     */           public Map func_152786_a(GameProfile p_152786_1_) {
/*  48 */             return Minecraft.func_71410_x().func_152347_ac().getTextures(p_152786_1_, false);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public ResourceLocation func_152792_a(MinecraftProfileTexture p_152792_1_, MinecraftProfileTexture.Type p_152792_2_) {
/*  54 */     return func_152789_a(p_152792_1_, p_152792_2_, null);
/*     */   }
/*     */   
/*     */   public ResourceLocation func_152789_a(MinecraftProfileTexture p_152789_1_, MinecraftProfileTexture.Type p_152789_2_, SkinAvailableCallback p_152789_3_) {
/*  58 */     ResourceLocation resourceLocation = new ResourceLocation("skins/" + p_152789_1_.getHash());
/*  59 */     ITextureObject iTextureObject = this.field_152795_c.func_110581_b(resourceLocation);
/*     */     
/*  61 */     if (iTextureObject != null) {
/*  62 */       if (p_152789_3_ != null) {
/*  63 */         p_152789_3_.func_152121_a(p_152789_2_, resourceLocation);
/*     */       }
/*     */     } else {
/*  66 */       File file1 = new File(this.field_152796_d, p_152789_1_.getHash().substring(0, 2));
/*  67 */       File file2 = new File(file1, p_152789_1_.getHash());
/*  68 */       ImageBufferDownload imageBufferDownload = (p_152789_2_ == MinecraftProfileTexture.Type.SKIN) ? new ImageBufferDownload() : null;
/*  69 */       ThreadDownloadImageData threadDownloadImageData = new ThreadDownloadImageData(file2, p_152789_1_.getUrl(), field_152793_a, new IImageBuffer(this, (IImageBuffer)imageBufferDownload, p_152789_3_, p_152789_2_, resourceLocation) { private static final String __OBFID = "CL_00001828";
/*     */             
/*     */             public BufferedImage func_78432_a(BufferedImage p_78432_1_) {
/*  72 */               if (this.field_152635_a != null) {
/*  73 */                 p_78432_1_ = this.field_152635_a.func_78432_a(p_78432_1_);
/*     */               }
/*  75 */               return p_78432_1_;
/*     */             }
/*     */ 
/*     */             
/*     */             public void func_152634_a() {
/*  80 */               if (this.field_152635_a != null) {
/*  81 */                 this.field_152635_a.func_152634_a();
/*     */               }
/*  83 */               if (this.field_152636_b != null) {
/*  84 */                 this.field_152636_b.func_152121_a(this.field_152637_c, this.field_152638_d);
/*     */               }
/*     */             } }
/*     */         );
/*  88 */       this.field_152795_c.func_110579_a(resourceLocation, (ITextureObject)threadDownloadImageData);
/*     */     } 
/*     */     
/*  91 */     return resourceLocation;
/*     */   }
/*     */   
/*     */   public void func_152790_a(GameProfile p_152790_1_, SkinAvailableCallback p_152790_2_, boolean p_152790_3_) {
/*  95 */     field_152794_b.submit(new Runnable(this, p_152790_1_, p_152790_3_, p_152790_2_) { private static final String __OBFID = "CL_00001827";
/*     */           
/*     */           public void run() {
/*  98 */             HashMap hashMap = Maps.newHashMap();
/*     */             
/*     */             try {
/* 101 */               hashMap.putAll(this.field_152802_d.field_152797_e.getTextures(this.field_152799_a, this.field_152800_b));
/* 102 */             } catch (InsecureTextureException insecureTextureException) {}
/*     */ 
/*     */             
/* 105 */             if (hashMap.isEmpty() && this.field_152799_a.getId().equals(Minecraft.func_71410_x().func_110432_I().func_148256_e().getId())) {
/* 106 */               hashMap.putAll(this.field_152802_d.field_152797_e.getTextures(this.field_152802_d.field_152797_e.fillProfileProperties(this.field_152799_a, false), false));
/*     */             }
/*     */             
/* 109 */             Minecraft.func_71410_x().func_152344_a(new Runnable(this, hashMap) { private static final String __OBFID = "CL_00001826";
/*     */                   
/*     */                   public void run() {
/* 112 */                     if (this.field_152803_a.containsKey(MinecraftProfileTexture.Type.SKIN)) {
/* 113 */                       this.field_152804_b.field_152802_d.func_152789_a((MinecraftProfileTexture)this.field_152803_a.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN, this.field_152804_b.field_152801_c);
/*     */                     }
/* 115 */                     if (this.field_152803_a.containsKey(MinecraftProfileTexture.Type.CAPE)) {
/* 116 */                       this.field_152804_b.field_152802_d.func_152789_a((MinecraftProfileTexture)this.field_152803_a.get(MinecraftProfileTexture.Type.CAPE), MinecraftProfileTexture.Type.CAPE, this.field_152804_b.field_152801_c);
/*     */                     }
/*     */                   } }
/*     */               );
/*     */           } }
/*     */       );
/*     */   }
/*     */   
/*     */   public Map func_152788_a(GameProfile p_152788_1_) {
/* 125 */     return (Map)this.field_152798_f.getUnchecked(p_152788_1_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static interface SkinAvailableCallback {
/*     */     void func_152121_a(MinecraftProfileTexture.Type param1Type, ResourceLocation param1ResourceLocation);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\SkinManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */