/*    */ package net.minecraft.client.entity;
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import com.mojang.authlib.minecraft.MinecraftProfileTexture;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.ImageBufferDownload;
/*    */ import net.minecraft.client.renderer.ThreadDownloadImageData;
/*    */ import net.minecraft.client.renderer.texture.ITextureObject;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.client.resources.SkinManager;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.StringUtils;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public abstract class AbstractClientPlayer extends EntityPlayer implements SkinManager.SkinAvailableCallback {
/* 19 */   public static final ResourceLocation field_110314_b = new ResourceLocation("textures/entity/steve.png");
/*    */ 
/*    */   
/*    */   private ResourceLocation field_110312_d;
/*    */ 
/*    */   
/*    */   private ResourceLocation field_110313_e;
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00000935";
/*    */ 
/*    */ 
/*    */   
/*    */   public AbstractClientPlayer(World p_i45074_1_, GameProfile p_i45074_2_) {
/* 33 */     super(p_i45074_1_, p_i45074_2_);
/*    */     
/* 35 */     String str = func_70005_c_();
/* 36 */     if (!str.isEmpty()) {
/* 37 */       SkinManager skinManager = Minecraft.func_71410_x().func_152342_ad();
/* 38 */       skinManager.func_152790_a(p_i45074_2_, this, true);
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean func_152122_n() {
/* 43 */     return (this.field_110313_e != null);
/*    */   }
/*    */   
/*    */   public boolean func_152123_o() {
/* 47 */     return (this.field_110312_d != null);
/*    */   }
/*    */   
/*    */   public ResourceLocation func_110306_p() {
/* 51 */     return (this.field_110312_d == null) ? field_110314_b : this.field_110312_d;
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation func_110303_q() {
/* 56 */     return this.field_110313_e;
/*    */   }
/*    */   public static ThreadDownloadImageData func_110304_a(ResourceLocation p_110304_0_, String p_110304_1_) {
/*    */     ThreadDownloadImageData threadDownloadImageData;
/* 60 */     TextureManager textureManager = Minecraft.func_71410_x().func_110434_K();
/*    */     
/* 62 */     ITextureObject iTextureObject = textureManager.func_110581_b(p_110304_0_);
/* 63 */     if (iTextureObject == null) {
/* 64 */       threadDownloadImageData = new ThreadDownloadImageData(null, String.format("http://skins.minecraft.net/MinecraftSkins/%s.png", new Object[] { StringUtils.func_76338_a(p_110304_1_) }), field_110314_b, (IImageBuffer)new ImageBufferDownload());
/* 65 */       textureManager.func_110579_a(p_110304_0_, (ITextureObject)threadDownloadImageData);
/*    */     } 
/*    */     
/* 68 */     return threadDownloadImageData;
/*    */   }
/*    */   
/*    */   public static ResourceLocation func_110311_f(String p_110311_0_) {
/* 72 */     return new ResourceLocation("skins/" + StringUtils.func_76338_a(p_110311_0_));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_152121_a(MinecraftProfileTexture.Type p_152121_1_, ResourceLocation p_152121_2_) {
/* 81 */     switch (SwitchType.field_152630_a[p_152121_1_.ordinal()]) {
/*    */       case 1:
/* 83 */         this.field_110312_d = p_152121_2_;
/*    */         break;
/*    */       case 2:
/* 86 */         this.field_110313_e = p_152121_2_;
/*    */         break;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\entity\AbstractClientPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */