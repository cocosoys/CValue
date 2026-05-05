/*    */ package net.minecraft.client.resources.data;
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.GsonBuilder;
/*    */ import com.google.gson.JsonObject;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.util.ChatStyle;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import net.minecraft.util.IRegistry;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class IMetadataSerializer {
/* 13 */   private final IRegistry field_110508_a = (IRegistry)new RegistrySimple();
/* 14 */   private final GsonBuilder field_110506_b = new GsonBuilder(); private Gson field_110507_c;
/*    */   private static final String __OBFID = "CL_00001101";
/*    */   
/*    */   public IMetadataSerializer() {
/* 18 */     this.field_110506_b.registerTypeHierarchyAdapter(IChatComponent.class, new IChatComponent.Serializer());
/* 19 */     this.field_110506_b.registerTypeHierarchyAdapter(ChatStyle.class, new ChatStyle.Serializer());
/* 20 */     this.field_110506_b.registerTypeAdapterFactory((TypeAdapterFactory)new EnumTypeAdapterFactory());
/*    */   }
/*    */   
/*    */   public void func_110504_a(IMetadataSectionSerializer p_110504_1_, Class p_110504_2_) {
/* 24 */     this.field_110508_a.func_82595_a(p_110504_1_.func_110483_a(), new Registration(p_110504_1_, p_110504_2_));
/* 25 */     this.field_110506_b.registerTypeAdapter(p_110504_2_, p_110504_1_);
/* 26 */     this.field_110507_c = null;
/*    */   }
/*    */   
/*    */   public IMetadataSection func_110503_a(String p_110503_1_, JsonObject p_110503_2_) {
/* 30 */     if (p_110503_1_ == null) {
/* 31 */       throw new IllegalArgumentException("Metadata section name cannot be null");
/*    */     }
/* 33 */     if (!p_110503_2_.has(p_110503_1_)) {
/* 34 */       return null;
/*    */     }
/* 36 */     if (!p_110503_2_.get(p_110503_1_).isJsonObject()) {
/* 37 */       throw new IllegalArgumentException("Invalid metadata for '" + p_110503_1_ + "' - expected object, found " + p_110503_2_.get(p_110503_1_));
/*    */     }
/*    */     
/* 40 */     Registration registration = (Registration)this.field_110508_a.func_82594_a(p_110503_1_);
/* 41 */     if (registration == null) {
/* 42 */       throw new IllegalArgumentException("Don't know how to handle metadata section '" + p_110503_1_ + "'");
/*    */     }
/*    */     
/* 45 */     return (IMetadataSection)func_110505_a().fromJson((JsonElement)p_110503_2_.getAsJsonObject(p_110503_1_), registration.field_110500_b);
/*    */   }
/*    */   
/*    */   private Gson func_110505_a() {
/* 49 */     if (this.field_110507_c == null) {
/* 50 */       this.field_110507_c = this.field_110506_b.create();
/*    */     }
/* 52 */     return this.field_110507_c;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   class Registration { final IMetadataSectionSerializer field_110502_a;
/*    */     final Class field_110500_b;
/*    */     private static final String __OBFID = "CL_00001103";
/*    */     
/*    */     private Registration(IMetadataSerializer p_i1305_1_, IMetadataSectionSerializer p_i1305_2_, Class p_i1305_3_) {
/* 60 */       this.field_110502_a = p_i1305_2_;
/* 61 */       this.field_110500_b = p_i1305_3_;
/*    */     } }
/*    */ 
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\data\IMetadataSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */