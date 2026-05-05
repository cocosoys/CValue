/*     */ package net.minecraft.client.renderer.texture;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.client.resources.IResourceManager;
/*     */ import net.minecraft.client.resources.IResourceManagerReloadListener;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.util.ReportedException;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class TextureManager implements ITickable, IResourceManagerReloadListener {
/*  21 */   private static final Logger field_147646_a = LogManager.getLogger();
/*  22 */   private final Map field_110585_a = Maps.newHashMap();
/*     */   
/*  24 */   private final Map field_130089_b = Maps.newHashMap();
/*  25 */   private final List field_110583_b = Lists.newArrayList();
/*  26 */   private final Map field_110584_c = Maps.newHashMap();
/*     */   private IResourceManager field_110582_d;
/*     */   private static final String __OBFID = "CL_00001064";
/*     */   
/*     */   public TextureManager(IResourceManager p_i1284_1_) {
/*  31 */     this.field_110582_d = p_i1284_1_;
/*     */   }
/*     */   
/*     */   public void func_110577_a(ResourceLocation p_110577_1_) {
/*  35 */     ITextureObject iTextureObject = (ITextureObject)this.field_110585_a.get(p_110577_1_);
/*     */ 
/*     */     
/*  38 */     if (iTextureObject == null) {
/*  39 */       iTextureObject = new SimpleTexture(p_110577_1_);
/*  40 */       func_110579_a(p_110577_1_, iTextureObject);
/*     */     } 
/*     */     
/*  43 */     TextureUtil.func_94277_a(iTextureObject.func_110552_b());
/*     */   }
/*     */ 
/*     */   
/*     */   public ResourceLocation func_130087_a(int p_130087_1_) {
/*  48 */     return (ResourceLocation)this.field_130089_b.get(Integer.valueOf(p_130087_1_));
/*     */   }
/*     */   
/*     */   public boolean func_130088_a(ResourceLocation p_130088_1_, TextureMap p_130088_2_) {
/*  52 */     if (func_110580_a(p_130088_1_, p_130088_2_)) {
/*  53 */       this.field_130089_b.put(Integer.valueOf(p_130088_2_.func_130086_a()), p_130088_1_);
/*  54 */       return true;
/*     */     } 
/*     */     
/*  57 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_110580_a(ResourceLocation p_110580_1_, ITickableTextureObject p_110580_2_) {
/*  61 */     if (func_110579_a(p_110580_1_, p_110580_2_)) {
/*  62 */       this.field_110583_b.add(p_110580_2_);
/*  63 */       return true;
/*     */     } 
/*     */     
/*  66 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_110579_a(ResourceLocation p_110579_1_, ITextureObject p_110579_2_) {
/*  70 */     boolean bool = true;
/*     */     try {
/*  72 */       p_110579_2_.func_110551_a(this.field_110582_d);
/*  73 */     } catch (IOException iOException) {
/*  74 */       field_147646_a.warn("Failed to load texture: " + p_110579_1_, iOException);
/*  75 */       p_110579_2_ = TextureUtil.field_111001_a;
/*  76 */       this.field_110585_a.put(p_110579_1_, p_110579_2_);
/*  77 */       bool = false;
/*  78 */     } catch (Throwable throwable) {
/*  79 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Registering texture");
/*  80 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Resource location being registered");
/*  81 */       ITextureObject iTextureObject = p_110579_2_;
/*     */       
/*  83 */       crashReportCategory.func_71507_a("Resource location", p_110579_1_);
/*  84 */       crashReportCategory.func_71500_a("Texture object class", new Callable(this, iTextureObject) { private static final String __OBFID = "CL_00001065";
/*     */             
/*     */             public String call() {
/*  87 */               return this.field_135062_a.getClass().getName();
/*     */             } }
/*     */         );
/*     */       
/*  91 */       throw new ReportedException(crashReport);
/*     */     } 
/*     */     
/*  94 */     this.field_110585_a.put(p_110579_1_, p_110579_2_);
/*     */     
/*  96 */     return bool;
/*     */   }
/*     */   
/*     */   public ITextureObject func_110581_b(ResourceLocation p_110581_1_) {
/* 100 */     return (ITextureObject)this.field_110585_a.get(p_110581_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ResourceLocation func_110578_a(String p_110578_1_, DynamicTexture p_110578_2_) {
/* 105 */     Integer integer = (Integer)this.field_110584_c.get(p_110578_1_);
/* 106 */     if (integer == null) {
/* 107 */       integer = Integer.valueOf(1);
/*     */     } else {
/* 109 */       Integer integer1 = integer, integer2 = integer = Integer.valueOf(integer.intValue() + 1);
/*     */     } 
/* 111 */     this.field_110584_c.put(p_110578_1_, integer);
/*     */     
/* 113 */     ResourceLocation resourceLocation = new ResourceLocation(String.format("dynamic/%s_%d", new Object[] { p_110578_1_, integer }));
/* 114 */     func_110579_a(resourceLocation, p_110578_2_);
/*     */     
/* 116 */     return resourceLocation;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_110550_d() {
/* 121 */     for (ITickable iTickable : this.field_110583_b) {
/* 122 */       iTickable.func_110550_d();
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_147645_c(ResourceLocation p_147645_1_) {
/* 127 */     ITextureObject iTextureObject = func_110581_b(p_147645_1_);
/* 128 */     if (iTextureObject != null) {
/* 129 */       TextureUtil.func_147942_a(iTextureObject.func_110552_b());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_110549_a(IResourceManager p_110549_1_) {
/* 135 */     for (Map.Entry entry : this.field_110585_a.entrySet())
/* 136 */       func_110579_a((ResourceLocation)entry.getKey(), (ITextureObject)entry.getValue()); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\texture\TextureManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */