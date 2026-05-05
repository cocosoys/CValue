/*    */ package net.minecraft.client.resources;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import com.google.common.collect.Maps;
/*    */ import com.google.common.collect.Sets;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.SortedSet;
/*    */ import net.minecraft.client.resources.data.IMetadataSerializer;
/*    */ import net.minecraft.client.resources.data.LanguageMetadataSection;
/*    */ import net.minecraft.util.StringTranslate;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class LanguageManager implements IResourceManagerReloadListener {
/* 21 */   private static final Logger field_147648_b = LogManager.getLogger();
/*    */ 
/*    */   
/*    */   private final IMetadataSerializer field_135047_b;
/*    */   
/*    */   private String field_135048_c;
/*    */   
/* 28 */   protected static final Locale field_135049_a = new Locale();
/* 29 */   private Map field_135046_d = Maps.newHashMap();
/*    */   
/*    */   public LanguageManager(IMetadataSerializer p_i1304_1_, String p_i1304_2_) {
/* 32 */     this.field_135047_b = p_i1304_1_;
/*    */     
/* 34 */     this.field_135048_c = p_i1304_2_;
/*    */     
/* 36 */     I18n.func_135051_a(field_135049_a);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001096";
/*    */   public void func_135043_a(List p_135043_1_) {
/* 40 */     this.field_135046_d.clear();
/*    */     
/* 42 */     for (IResourcePack iResourcePack : p_135043_1_) {
/*    */       try {
/* 44 */         LanguageMetadataSection languageMetadataSection = (LanguageMetadataSection)iResourcePack.func_135058_a(this.field_135047_b, "language");
/* 45 */         if (languageMetadataSection != null) {
/* 46 */           for (Language language : languageMetadataSection.func_135018_a()) {
/*    */             
/* 48 */             if (!this.field_135046_d.containsKey(language.func_135034_a())) {
/* 49 */               this.field_135046_d.put(language.func_135034_a(), language);
/*    */             }
/*    */           } 
/*    */         }
/* 53 */       } catch (RuntimeException runtimeException) {
/* 54 */         field_147648_b.warn("Unable to parse metadata section of resourcepack: " + iResourcePack.func_130077_b(), runtimeException);
/* 55 */       } catch (IOException iOException) {
/* 56 */         field_147648_b.warn("Unable to parse metadata section of resourcepack: " + iResourcePack.func_130077_b(), iOException);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_110549_a(IResourceManager p_110549_1_) {
/* 63 */     ArrayList<String> arrayList = Lists.newArrayList((Object[])new String[] { "en_US" });
/* 64 */     if (!"en_US".equals(this.field_135048_c)) {
/* 65 */       arrayList.add(this.field_135048_c);
/*    */     }
/*    */     
/* 68 */     field_135049_a.func_135022_a(p_110549_1_, arrayList);
/*    */ 
/*    */     
/* 71 */     StringTranslate.func_135063_a(field_135049_a.field_135032_a);
/*    */   }
/*    */   
/*    */   public boolean func_135042_a() {
/* 75 */     return field_135049_a.func_135025_a();
/*    */   }
/*    */   
/*    */   public boolean func_135044_b() {
/* 79 */     return (func_135041_c() != null && func_135041_c().func_135035_b());
/*    */   }
/*    */   
/*    */   public void func_135045_a(Language p_135045_1_) {
/* 83 */     this.field_135048_c = p_135045_1_.func_135034_a();
/*    */   }
/*    */   
/*    */   public Language func_135041_c() {
/* 87 */     return this.field_135046_d.containsKey(this.field_135048_c) ? (Language)this.field_135046_d.get(this.field_135048_c) : (Language)this.field_135046_d.get("en_US");
/*    */   }
/*    */   
/*    */   public SortedSet func_135040_d() {
/* 91 */     return Sets.newTreeSet(this.field_135046_d.values());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\LanguageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */