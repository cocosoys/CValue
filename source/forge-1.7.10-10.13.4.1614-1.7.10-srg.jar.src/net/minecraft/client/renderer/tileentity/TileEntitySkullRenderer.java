/*     */ package net.minecraft.client.renderer.tileentity;
/*     */ 
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import com.mojang.authlib.minecraft.MinecraftProfileTexture;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.model.ModelSkeletonHead;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntitySkull;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class TileEntitySkullRenderer
/*     */   extends TileEntitySpecialRenderer
/*     */ {
/*  22 */   private static final ResourceLocation field_147537_c = new ResourceLocation("textures/entity/skeleton/skeleton.png");
/*  23 */   private static final ResourceLocation field_147534_d = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
/*  24 */   private static final ResourceLocation field_147535_e = new ResourceLocation("textures/entity/zombie/zombie.png");
/*  25 */   private static final ResourceLocation field_147532_f = new ResourceLocation("textures/entity/creeper/creeper.png");
/*     */ 
/*     */   
/*     */   public static TileEntitySkullRenderer field_147536_b;
/*     */   
/*  30 */   private ModelSkeletonHead field_147533_g = new ModelSkeletonHead(0, 0, 64, 32);
/*  31 */   private ModelSkeletonHead field_147538_h = new ModelSkeletonHead(0, 0, 64, 64);
/*     */   private static final String __OBFID = "CL_00000971";
/*     */   
/*     */   public void func_147500_a(TileEntitySkull p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
/*  35 */     func_152674_a((float)p_147500_2_, (float)p_147500_4_, (float)p_147500_6_, p_147500_1_.func_145832_p() & 0x7, (p_147500_1_.func_145906_b() * 360) / 16.0F, p_147500_1_.func_145904_a(), p_147500_1_.func_152108_a());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147497_a(TileEntityRendererDispatcher p_147497_1_) {
/*  40 */     super.func_147497_a(p_147497_1_);
/*  41 */     field_147536_b = this;
/*     */   }
/*     */   public void func_152674_a(float p_152674_1_, float p_152674_2_, float p_152674_3_, int p_152674_4_, float p_152674_5_, int p_152674_6_, GameProfile p_152674_7_) {
/*     */     ResourceLocation resourceLocation;
/*  45 */     ModelSkeletonHead modelSkeletonHead = this.field_147533_g;
/*     */     
/*  47 */     switch (p_152674_6_) {
/*     */       
/*     */       default:
/*  50 */         func_147499_a(field_147537_c);
/*     */         break;
/*     */       case 1:
/*  53 */         func_147499_a(field_147534_d);
/*     */         break;
/*     */       case 2:
/*  56 */         func_147499_a(field_147535_e);
/*  57 */         modelSkeletonHead = this.field_147538_h;
/*     */         break;
/*     */       case 3:
/*  60 */         resourceLocation = AbstractClientPlayer.field_110314_b;
/*     */         
/*  62 */         if (p_152674_7_ != null) {
/*  63 */           Minecraft minecraft = Minecraft.func_71410_x();
/*  64 */           Map map = minecraft.func_152342_ad().func_152788_a(p_152674_7_);
/*  65 */           if (map.containsKey(MinecraftProfileTexture.Type.SKIN)) {
/*  66 */             resourceLocation = minecraft.func_152342_ad().func_152792_a((MinecraftProfileTexture)map.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN);
/*     */           }
/*     */         } 
/*     */         
/*  70 */         func_147499_a(resourceLocation);
/*     */         break;
/*     */       case 4:
/*  73 */         func_147499_a(field_147532_f);
/*     */         break;
/*     */     } 
/*     */     
/*  77 */     GL11.glPushMatrix();
/*  78 */     GL11.glDisable(2884);
/*     */     
/*  80 */     if (p_152674_4_ != 1) {
/*  81 */       switch (p_152674_4_) {
/*     */         case 2:
/*  83 */           GL11.glTranslatef(p_152674_1_ + 0.5F, p_152674_2_ + 0.25F, p_152674_3_ + 0.74F);
/*     */           break;
/*     */         case 3:
/*  86 */           GL11.glTranslatef(p_152674_1_ + 0.5F, p_152674_2_ + 0.25F, p_152674_3_ + 0.26F);
/*  87 */           p_152674_5_ = 180.0F;
/*     */           break;
/*     */         case 4:
/*  90 */           GL11.glTranslatef(p_152674_1_ + 0.74F, p_152674_2_ + 0.25F, p_152674_3_ + 0.5F);
/*  91 */           p_152674_5_ = 270.0F;
/*     */           break;
/*     */         
/*     */         default:
/*  95 */           GL11.glTranslatef(p_152674_1_ + 0.26F, p_152674_2_ + 0.25F, p_152674_3_ + 0.5F);
/*  96 */           p_152674_5_ = 90.0F;
/*     */           break;
/*     */       } 
/*     */     } else {
/* 100 */       GL11.glTranslatef(p_152674_1_ + 0.5F, p_152674_2_, p_152674_3_ + 0.5F);
/*     */     } 
/*     */     
/* 103 */     float f = 0.0625F;
/* 104 */     GL11.glEnable(32826);
/* 105 */     GL11.glScalef(-1.0F, -1.0F, 1.0F);
/*     */     
/* 107 */     GL11.glEnable(3008);
/*     */     
/* 109 */     modelSkeletonHead.func_78088_a(null, 0.0F, 0.0F, 0.0F, p_152674_5_, 0.0F, f);
/*     */     
/* 111 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\tileentity\TileEntitySkullRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */