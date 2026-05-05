/*     */ package net.minecraft.client.resources;
/*     */ import com.google.common.base.Function;
/*     */ import com.google.common.base.Joiner;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.client.resources.data.IMetadataSerializer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class SimpleReloadableResourceManager implements IReloadableResourceManager {
/*  21 */   private static final Logger field_147967_a = LogManager.getLogger();
/*  22 */   private static final Joiner field_130074_a = Joiner.on(", ");
/*  23 */   private final Map field_110548_a = Maps.newHashMap();
/*  24 */   private final List field_110546_b = Lists.newArrayList();
/*  25 */   private final Set field_135057_d = Sets.newLinkedHashSet(); private final IMetadataSerializer field_110547_c;
/*     */   private static final String __OBFID = "CL_00001091";
/*     */   
/*     */   public SimpleReloadableResourceManager(IMetadataSerializer p_i1299_1_) {
/*  29 */     this.field_110547_c = p_i1299_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_110545_a(IResourcePack p_110545_1_) {
/*  34 */     for (String str : p_110545_1_.func_110587_b()) {
/*  35 */       this.field_135057_d.add(str);
/*  36 */       FallbackResourceManager fallbackResourceManager = (FallbackResourceManager)this.field_110548_a.get(str);
/*  37 */       if (fallbackResourceManager == null) {
/*  38 */         fallbackResourceManager = new FallbackResourceManager(this.field_110547_c);
/*  39 */         this.field_110548_a.put(str, fallbackResourceManager);
/*     */       } 
/*  41 */       fallbackResourceManager.func_110538_a(p_110545_1_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Set func_135055_a() {
/*  47 */     return this.field_135057_d;
/*     */   }
/*     */ 
/*     */   
/*     */   public IResource func_110536_a(ResourceLocation p_110536_1_) throws IOException {
/*  52 */     IResourceManager iResourceManager = (IResourceManager)this.field_110548_a.get(p_110536_1_.func_110624_b());
/*     */     
/*  54 */     if (iResourceManager != null) {
/*  55 */       return iResourceManager.func_110536_a(p_110536_1_);
/*     */     }
/*     */     
/*  58 */     throw new FileNotFoundException(p_110536_1_.toString());
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_135056_b(ResourceLocation p_135056_1_) throws IOException {
/*  63 */     IResourceManager iResourceManager = (IResourceManager)this.field_110548_a.get(p_135056_1_.func_110624_b());
/*     */     
/*  65 */     if (iResourceManager != null) {
/*  66 */       return iResourceManager.func_135056_b(p_135056_1_);
/*     */     }
/*     */     
/*  69 */     throw new FileNotFoundException(p_135056_1_.toString());
/*     */   }
/*     */   
/*     */   private void func_110543_a() {
/*  73 */     this.field_110548_a.clear();
/*  74 */     this.field_135057_d.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_110541_a(List p_110541_1_) {
/*  79 */     func_110543_a();
/*     */     
/*  81 */     field_147967_a.info("Reloading ResourceManager: " + field_130074_a.join(Iterables.transform(p_110541_1_, new Function(this) { private static final String __OBFID = "CL_00001092";
/*     */               
/*     */               public String apply(IResourcePack p_apply_1_) {
/*  84 */                 return p_apply_1_.func_130077_b();
/*     */               } }
/*     */           )));
/*     */     
/*  88 */     for (IResourcePack iResourcePack : p_110541_1_) {
/*  89 */       func_110545_a(iResourcePack);
/*     */     }
/*     */     
/*  92 */     func_110544_b();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_110542_a(IResourceManagerReloadListener p_110542_1_) {
/*  97 */     this.field_110546_b.add(p_110542_1_);
/*     */     
/*  99 */     p_110542_1_.func_110549_a(this);
/*     */   }
/*     */   
/*     */   private void func_110544_b() {
/* 103 */     for (IResourceManagerReloadListener iResourceManagerReloadListener : this.field_110546_b)
/* 104 */       iResourceManagerReloadListener.func_110549_a(this); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\SimpleReloadableResourceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */