/*     */ package net.minecraft.client.renderer.texture;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Callable;
/*     */ import javax.imageio.ImageIO;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.StitcherException;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.resources.IResource;
/*     */ import net.minecraft.client.resources.IResourceManager;
/*     */ import net.minecraft.client.resources.data.AnimationMetadataSection;
/*     */ import net.minecraft.client.resources.data.TextureMetadataSection;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ReportedException;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class TextureMap extends AbstractTexture implements ITickableTextureObject, IIconRegister {
/*  35 */   private static final Logger field_147635_d = LogManager.getLogger();
/*     */   
/*  37 */   public static final ResourceLocation field_110575_b = new ResourceLocation("textures/atlas/blocks.png");
/*  38 */   public static final ResourceLocation field_110576_c = new ResourceLocation("textures/atlas/items.png");
/*     */ 
/*     */   
/*  41 */   private final List field_94258_i = Lists.newArrayList();
/*  42 */   private final Map field_110574_e = Maps.newHashMap();
/*  43 */   private final Map field_94252_e = Maps.newHashMap();
/*     */   
/*     */   private final int field_94255_a;
/*     */   private final String field_94254_c;
/*     */   private int field_147636_j;
/*  48 */   private int field_147637_k = 1;
/*     */   
/*  50 */   private final TextureAtlasSprite field_94249_f = new TextureAtlasSprite("missingno"); private static final String __OBFID = "CL_00001058";
/*     */   
/*     */   public TextureMap(int p_i1281_1_, String p_i1281_2_) {
/*  53 */     this.field_94255_a = p_i1281_1_;
/*  54 */     this.field_94254_c = p_i1281_2_;
/*  55 */     func_110573_f();
/*     */   }
/*     */   
/*     */   private void func_110569_e() {
/*     */     int[] arrayOfInt;
/*  60 */     if (this.field_147637_k > 1.0F) {
/*  61 */       byte b1 = 16;
/*  62 */       byte b2 = 32;
/*  63 */       byte b3 = 32;
/*     */       
/*  65 */       this.field_94249_f.func_110966_b(32);
/*  66 */       this.field_94249_f.func_110969_c(32);
/*     */       
/*  68 */       arrayOfInt = new int[1024];
/*  69 */       System.arraycopy(TextureUtil.field_110999_b, 0, arrayOfInt, 0, TextureUtil.field_110999_b.length);
/*     */       
/*  71 */       TextureUtil.func_147948_a(arrayOfInt, 16, 16, 8);
/*     */     } else {
/*     */       
/*  74 */       arrayOfInt = TextureUtil.field_110999_b;
/*  75 */       this.field_94249_f.func_110966_b(16);
/*  76 */       this.field_94249_f.func_110969_c(16);
/*     */     } 
/*     */     
/*  79 */     int[][] arrayOfInt1 = new int[this.field_147636_j + 1][];
/*  80 */     arrayOfInt1[0] = arrayOfInt;
/*  81 */     this.field_94249_f.func_110968_a(Lists.newArrayList((Object[])new int[][][] { arrayOfInt1 }));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_110551_a(IResourceManager p_110551_1_) throws IOException {
/*  86 */     func_110569_e();
/*     */     
/*  88 */     func_147631_c();
/*     */     
/*  90 */     func_110571_b(p_110551_1_);
/*     */   }
/*     */   
/*     */   public void func_110571_b(IResourceManager p_110571_1_) {
/*  94 */     int i = Minecraft.func_71369_N();
/*  95 */     Stitcher stitcher = new Stitcher(i, i, true, 0, this.field_147636_j);
/*     */     
/*  97 */     this.field_94252_e.clear();
/*  98 */     this.field_94258_i.clear();
/*     */     
/* 100 */     int j = Integer.MAX_VALUE;
/*     */ 
/*     */     
/* 103 */     for (Map.Entry entry : this.field_110574_e.entrySet()) {
/* 104 */       ResourceLocation resourceLocation1 = new ResourceLocation((String)entry.getKey());
/* 105 */       TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite)entry.getValue();
/*     */       
/* 107 */       ResourceLocation resourceLocation2 = func_147634_a(resourceLocation1, 0);
/*     */       try {
/* 109 */         IResource iResource = p_110571_1_.func_110536_a(resourceLocation2);
/*     */         
/* 111 */         BufferedImage[] arrayOfBufferedImage = new BufferedImage[1 + this.field_147636_j];
/* 112 */         arrayOfBufferedImage[0] = ImageIO.read(iResource.func_110527_b());
/*     */ 
/*     */         
/* 115 */         TextureMetadataSection textureMetadataSection = (TextureMetadataSection)iResource.func_110526_a("texture");
/* 116 */         if (textureMetadataSection != null) {
/* 117 */           List list = textureMetadataSection.func_148535_c();
/*     */ 
/*     */           
/* 120 */           if (!list.isEmpty()) {
/* 121 */             int m = arrayOfBufferedImage[0].getWidth();
/* 122 */             int n = arrayOfBufferedImage[0].getHeight();
/* 123 */             if (MathHelper.func_151236_b(m) != m || MathHelper.func_151236_b(n) != n) {
/* 124 */               throw new RuntimeException("Unable to load extra miplevels, source-texture is not power of two");
/*     */             }
/*     */           } 
/*     */           
/* 128 */           for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) { int m = ((Integer)iterator.next()).intValue();
/*     */             
/* 130 */             if (m > 0 && m < arrayOfBufferedImage.length - 1 && arrayOfBufferedImage[m] == null) {
/* 131 */               ResourceLocation resourceLocation = func_147634_a(resourceLocation1, m);
/*     */               try {
/* 133 */                 arrayOfBufferedImage[m] = ImageIO.read(p_110571_1_.func_110536_a(resourceLocation).func_110527_b());
/* 134 */               } catch (IOException iOException) {
/* 135 */                 field_147635_d.error("Unable to load miplevel {} from: {}", new Object[] { Integer.valueOf(m), resourceLocation, iOException });
/*     */               } 
/*     */             }  }
/*     */         
/*     */         } 
/*     */         
/* 141 */         AnimationMetadataSection animationMetadataSection = (AnimationMetadataSection)iResource.func_110526_a("animation");
/* 142 */         textureAtlasSprite.func_147964_a(arrayOfBufferedImage, animationMetadataSection, (this.field_147637_k > 1.0F));
/* 143 */       } catch (RuntimeException runtimeException) {
/* 144 */         field_147635_d.error("Unable to parse metadata from " + resourceLocation2, runtimeException);
/*     */         continue;
/* 146 */       } catch (IOException iOException) {
/* 147 */         field_147635_d.error("Using missing texture, unable to load " + resourceLocation2, iOException);
/*     */         
/*     */         continue;
/*     */       } 
/* 151 */       j = Math.min(j, Math.min(textureAtlasSprite.func_94211_a(), textureAtlasSprite.func_94216_b()));
/*     */       
/* 153 */       stitcher.func_110934_a(textureAtlasSprite);
/*     */     } 
/*     */ 
/*     */     
/* 157 */     int k = MathHelper.func_151239_c(j);
/* 158 */     if (k < this.field_147636_j) {
/* 159 */       field_147635_d.debug("{}: dropping miplevel from {} to {}, because of minTexel: {}", new Object[] { this.field_94254_c, Integer.valueOf(this.field_147636_j), Integer.valueOf(k), Integer.valueOf(j) });
/* 160 */       this.field_147636_j = k;
/*     */     } 
/*     */     
/* 163 */     for (TextureAtlasSprite textureAtlasSprite : this.field_110574_e.values()) {
/*     */       try {
/* 165 */         textureAtlasSprite.func_147963_d(this.field_147636_j);
/* 166 */       } catch (Throwable throwable) {
/* 167 */         CrashReport crashReport = CrashReport.func_85055_a(throwable, "Applying mipmap");
/* 168 */         CrashReportCategory crashReportCategory = crashReport.func_85058_a("Sprite being mipmapped");
/*     */         
/* 170 */         crashReportCategory.func_71500_a("Sprite name", new Callable(this, textureAtlasSprite) { private static final String __OBFID = "CL_00001059";
/*     */               
/*     */               public String call() {
/* 173 */                 return this.field_147980_a.func_94215_i();
/*     */               } }
/*     */           );
/*     */         
/* 177 */         crashReportCategory.func_71500_a("Sprite size", new Callable(this, textureAtlasSprite) { private static final String __OBFID = "CL_00001060";
/*     */               
/*     */               public String call() {
/* 180 */                 return this.field_147977_a.func_94211_a() + " x " + this.field_147977_a.func_94216_b();
/*     */               } }
/*     */           );
/*     */         
/* 184 */         crashReportCategory.func_71500_a("Sprite frames", new Callable(this, textureAtlasSprite) { private static final String __OBFID = "CL_00001061";
/*     */               
/*     */               public String call() {
/* 187 */                 return this.field_147974_a.func_110970_k() + " frames";
/*     */               } }
/*     */           );
/*     */         
/* 191 */         crashReportCategory.func_71507_a("Mipmap levels", Integer.valueOf(this.field_147636_j));
/*     */         
/* 193 */         throw new ReportedException(crashReport);
/*     */       } 
/*     */     } 
/* 196 */     this.field_94249_f.func_147963_d(this.field_147636_j);
/*     */ 
/*     */     
/* 199 */     stitcher.func_110934_a(this.field_94249_f);
/*     */ 
/*     */     
/*     */     try {
/* 203 */       stitcher.func_94305_f();
/* 204 */     } catch (StitcherException stitcherException) {
/* 205 */       throw stitcherException;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 210 */     field_147635_d.info("Created: {}x{} {}-atlas", new Object[] { Integer.valueOf(stitcher.func_110935_a()), Integer.valueOf(stitcher.func_110936_b()), this.field_94254_c });
/* 211 */     TextureUtil.func_147946_a(func_110552_b(), this.field_147636_j, stitcher.func_110935_a(), stitcher.func_110936_b(), this.field_147637_k);
/*     */     
/* 213 */     HashMap hashMap = Maps.newHashMap(this.field_110574_e);
/* 214 */     for (TextureAtlasSprite textureAtlasSprite : stitcher.func_94309_g()) {
/*     */ 
/*     */       
/* 217 */       String str = textureAtlasSprite.func_94215_i();
/* 218 */       hashMap.remove(str);
/* 219 */       this.field_94252_e.put(str, textureAtlasSprite);
/*     */ 
/*     */       
/*     */       try {
/* 223 */         TextureUtil.func_147955_a(textureAtlasSprite.func_147965_a(0), textureAtlasSprite.func_94211_a(), textureAtlasSprite.func_94216_b(), textureAtlasSprite.func_130010_a(), textureAtlasSprite.func_110967_i(), false, false);
/* 224 */       } catch (Throwable throwable) {
/* 225 */         CrashReport crashReport = CrashReport.func_85055_a(throwable, "Stitching texture atlas");
/* 226 */         CrashReportCategory crashReportCategory = crashReport.func_85058_a("Texture being stitched together");
/*     */         
/* 228 */         crashReportCategory.func_71507_a("Atlas path", this.field_94254_c);
/* 229 */         crashReportCategory.func_71507_a("Sprite", textureAtlasSprite);
/*     */         
/* 231 */         throw new ReportedException(crashReport);
/*     */       } 
/*     */ 
/*     */       
/* 235 */       if (textureAtlasSprite.func_130098_m()) {
/* 236 */         this.field_94258_i.add(textureAtlasSprite); continue;
/*     */       } 
/* 238 */       textureAtlasSprite.func_130103_l();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 243 */     for (TextureAtlasSprite textureAtlasSprite : hashMap.values()) {
/* 244 */       textureAtlasSprite.func_94217_a(this.field_94249_f);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ResourceLocation func_147634_a(ResourceLocation p_147634_1_, int p_147634_2_) {
/* 251 */     if (p_147634_2_ == 0) {
/* 252 */       return new ResourceLocation(p_147634_1_.func_110624_b(), String.format("%s/%s%s", new Object[] { this.field_94254_c, p_147634_1_.func_110623_a(), ".png" }));
/*     */     }
/* 254 */     return new ResourceLocation(p_147634_1_.func_110624_b(), String.format("%s/mipmaps/%s.%d%s", new Object[] { this.field_94254_c, p_147634_1_.func_110623_a(), Integer.valueOf(p_147634_2_), ".png" }));
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_110573_f() {
/* 259 */     this.field_110574_e.clear();
/*     */ 
/*     */     
/* 262 */     if (this.field_94255_a == 0) {
/* 263 */       for (Block block : Block.field_149771_c) {
/* 264 */         if (block.func_149688_o() != Material.field_151579_a) {
/* 265 */           block.func_149651_a(this);
/*     */         }
/*     */       } 
/*     */       
/* 269 */       (Minecraft.func_71410_x()).field_71438_f.func_94140_a(this);
/* 270 */       RenderManager.field_78727_a.func_94178_a(this);
/*     */     } 
/*     */     
/* 273 */     for (Item item : Item.field_150901_e) {
/* 274 */       if (item == null)
/*     */         continue; 
/* 276 */       if (item.func_94901_k() == this.field_94255_a) {
/* 277 */         item.func_94581_a(this);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureAtlasSprite func_110572_b(String p_110572_1_) {
/* 284 */     TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite)this.field_94252_e.get(p_110572_1_);
/* 285 */     if (textureAtlasSprite == null) textureAtlasSprite = this.field_94249_f; 
/* 286 */     return textureAtlasSprite;
/*     */   }
/*     */   
/*     */   public void func_94248_c() {
/* 290 */     TextureUtil.func_94277_a(func_110552_b());
/* 291 */     for (TextureAtlasSprite textureAtlasSprite : this.field_94258_i) {
/* 292 */       textureAtlasSprite.func_94219_l();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IIcon func_94245_a(String p_94245_1_) {
/* 298 */     if (p_94245_1_ == null) {
/* 299 */       throw new IllegalArgumentException("Name cannot be null!");
/*     */     }
/*     */     
/* 302 */     if (p_94245_1_.indexOf('/') != -1 || p_94245_1_.indexOf('\\') != -1) {
/* 303 */       throw new IllegalArgumentException("Name cannot contain slashes!");
/*     */     }
/*     */     
/* 306 */     TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite)this.field_110574_e.get(p_94245_1_);
/* 307 */     if (textureAtlasSprite == null) {
/* 308 */       if (this.field_94255_a == 1) {
/*     */         
/* 310 */         if ("clock".equals(p_94245_1_)) {
/* 311 */           textureAtlasSprite = new TextureClock(p_94245_1_);
/* 312 */         } else if ("compass".equals(p_94245_1_)) {
/* 313 */           textureAtlasSprite = new TextureCompass(p_94245_1_);
/*     */         } else {
/* 315 */           textureAtlasSprite = new TextureAtlasSprite(p_94245_1_);
/*     */         } 
/*     */       } else {
/* 318 */         textureAtlasSprite = new TextureAtlasSprite(p_94245_1_);
/*     */       } 
/* 320 */       this.field_110574_e.put(p_94245_1_, textureAtlasSprite);
/*     */     } 
/*     */     
/* 323 */     return textureAtlasSprite;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_130086_a() {
/* 328 */     return this.field_94255_a;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_110550_d() {
/* 333 */     func_94248_c();
/*     */   }
/*     */   
/*     */   public void func_147633_a(int p_147633_1_) {
/* 337 */     this.field_147636_j = p_147633_1_;
/*     */   }
/*     */   
/*     */   public void func_147632_b(int p_147632_1_) {
/* 341 */     this.field_147637_k = p_147632_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\texture\TextureMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */