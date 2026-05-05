/*    */ package net.minecraft.client.resources;
/*    */ import com.google.gson.JsonParseException;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.client.gui.GuiScreenResourcePacks;
/*    */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*    */ import net.minecraft.client.renderer.texture.TextureUtil;
/*    */ import net.minecraft.client.resources.data.PackMetadataSection;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ResourcePackListEntryDefault extends ResourcePackListEntry {
/* 17 */   private static final Logger field_148322_c = LogManager.getLogger(); private final IResourcePack field_148320_d;
/*    */   private final ResourceLocation field_148321_e;
/*    */   private static final String __OBFID = "CL_00000822";
/*    */   
/*    */   public ResourcePackListEntryDefault(GuiScreenResourcePacks p_i45052_1_) {
/* 22 */     super(p_i45052_1_); DynamicTexture dynamicTexture;
/* 23 */     this.field_148320_d = (this.field_148317_a.func_110438_M()).field_110620_b;
/*    */ 
/*    */     
/*    */     try {
/* 27 */       dynamicTexture = new DynamicTexture(this.field_148320_d.func_110586_a());
/* 28 */     } catch (IOException iOException) {
/* 29 */       dynamicTexture = TextureUtil.field_111001_a;
/*    */     } 
/*    */     
/* 32 */     this.field_148321_e = this.field_148317_a.func_110434_K().func_110578_a("texturepackicon", dynamicTexture);
/*    */   }
/*    */ 
/*    */   
/*    */   protected String func_148311_a() {
/*    */     try {
/* 38 */       PackMetadataSection packMetadataSection = (PackMetadataSection)this.field_148320_d.func_135058_a((this.field_148317_a.func_110438_M()).field_110621_c, "pack");
/* 39 */       if (packMetadataSection != null) {
/* 40 */         return packMetadataSection.func_152805_a().func_150254_d();
/*    */       }
/* 42 */     } catch (JsonParseException jsonParseException) {
/* 43 */       field_148322_c.error("Couldn't load metadata info", (Throwable)jsonParseException);
/* 44 */     } catch (IOException iOException) {
/* 45 */       field_148322_c.error("Couldn't load metadata info", iOException);
/*    */     } 
/*    */     
/* 48 */     return EnumChatFormatting.RED + "Missing " + "pack.mcmeta" + " :(";
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_148309_e() {
/* 53 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_148308_f() {
/* 58 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_148314_g() {
/* 63 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_148307_h() {
/* 68 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String func_148312_b() {
/* 73 */     return "Default";
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_148313_c() {
/* 78 */     this.field_148317_a.func_110434_K().func_110577_a(this.field_148321_e);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_148310_d() {
/* 83 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\ResourcePackListEntryDefault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */