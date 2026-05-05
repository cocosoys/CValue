/*    */ package net.minecraft.client.resources;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import net.minecraft.client.resources.data.IMetadataSerializer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class FallbackResourceManager implements IResourceManager {
/* 14 */   protected final List field_110540_a = new ArrayList(); private final IMetadataSerializer field_110539_b;
/*    */   private static final String __OBFID = "CL_00001074";
/*    */   
/*    */   public FallbackResourceManager(IMetadataSerializer p_i1289_1_) {
/* 18 */     this.field_110539_b = p_i1289_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_110538_a(IResourcePack p_110538_1_) {
/* 23 */     this.field_110540_a.add(p_110538_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set func_135055_a() {
/* 28 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public IResource func_110536_a(ResourceLocation p_110536_1_) throws IOException {
/* 33 */     IResourcePack iResourcePack = null;
/* 34 */     ResourceLocation resourceLocation = func_110537_b(p_110536_1_);
/*    */     
/* 36 */     for (int i = this.field_110540_a.size() - 1; i >= 0; i--) {
/* 37 */       IResourcePack iResourcePack1 = this.field_110540_a.get(i);
/* 38 */       if (iResourcePack == null && iResourcePack1.func_110589_b(resourceLocation)) {
/* 39 */         iResourcePack = iResourcePack1;
/*    */       }
/*    */       
/* 42 */       if (iResourcePack1.func_110589_b(p_110536_1_)) {
/* 43 */         InputStream inputStream = null;
/* 44 */         if (iResourcePack != null) {
/* 45 */           inputStream = iResourcePack.func_110590_a(resourceLocation);
/*    */         }
/* 47 */         return new SimpleResource(p_110536_1_, iResourcePack1.func_110590_a(p_110536_1_), inputStream, this.field_110539_b);
/*    */       } 
/*    */     } 
/*    */     
/* 51 */     throw new FileNotFoundException(p_110536_1_.toString());
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_135056_b(ResourceLocation p_135056_1_) throws IOException {
/* 56 */     ArrayList<SimpleResource> arrayList = Lists.newArrayList();
/* 57 */     ResourceLocation resourceLocation = func_110537_b(p_135056_1_);
/*    */     
/* 59 */     for (IResourcePack iResourcePack : this.field_110540_a) {
/* 60 */       if (iResourcePack.func_110589_b(p_135056_1_)) {
/* 61 */         InputStream inputStream = iResourcePack.func_110589_b(resourceLocation) ? iResourcePack.func_110590_a(resourceLocation) : null;
/* 62 */         arrayList.add(new SimpleResource(p_135056_1_, iResourcePack.func_110590_a(p_135056_1_), inputStream, this.field_110539_b));
/*    */       } 
/*    */     } 
/*    */     
/* 66 */     if (arrayList.isEmpty()) {
/* 67 */       throw new FileNotFoundException(p_135056_1_.toString());
/*    */     }
/*    */     
/* 70 */     return arrayList;
/*    */   }
/*    */   
/*    */   static ResourceLocation func_110537_b(ResourceLocation p_110537_0_) {
/* 74 */     return new ResourceLocation(p_110537_0_.func_110624_b(), p_110537_0_.func_110623_a() + ".mcmeta");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\FallbackResourceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */