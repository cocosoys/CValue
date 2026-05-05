/*     */ package net.minecraft.util;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.nio.IntBuffer;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.imageio.ImageIO;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.texture.TextureUtil;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import net.minecraft.event.ClickEvent;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ScreenShotHelper
/*     */ {
/*  31 */   private static final Logger field_148261_a = LogManager.getLogger();
/*  32 */   private static final DateFormat field_74295_a = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
/*     */   
/*     */   private static IntBuffer field_74293_b;
/*     */   
/*     */   public static IChatComponent func_148260_a(File p_148260_0_, int p_148260_1_, int p_148260_2_, Framebuffer p_148260_3_) {
/*  37 */     return func_148259_a(p_148260_0_, null, p_148260_1_, p_148260_2_, p_148260_3_);
/*     */   }
/*     */   private static int[] field_74294_c; private static final String __OBFID = "CL_00000656";
/*     */   public static IChatComponent func_148259_a(File p_148259_0_, String p_148259_1_, int p_148259_2_, int p_148259_3_, Framebuffer p_148259_4_) {
/*     */     try {
/*  42 */       File file2, file1 = new File(p_148259_0_, "screenshots");
/*  43 */       file1.mkdir();
/*     */       
/*  45 */       if (OpenGlHelper.func_148822_b()) {
/*  46 */         p_148259_2_ = p_148259_4_.field_147622_a;
/*  47 */         p_148259_3_ = p_148259_4_.field_147620_b;
/*     */       } 
/*  49 */       int i = p_148259_2_ * p_148259_3_;
/*  50 */       if (field_74293_b == null || field_74293_b.capacity() < i) {
/*  51 */         field_74293_b = BufferUtils.createIntBuffer(i);
/*  52 */         field_74294_c = new int[i];
/*     */       } 
/*     */       
/*  55 */       GL11.glPixelStorei(3333, 1);
/*  56 */       GL11.glPixelStorei(3317, 1);
/*     */       
/*  58 */       field_74293_b.clear();
/*  59 */       if (OpenGlHelper.func_148822_b()) {
/*  60 */         GL11.glBindTexture(3553, p_148259_4_.field_147617_g);
/*  61 */         GL11.glGetTexImage(3553, 0, 32993, 33639, field_74293_b);
/*     */       } else {
/*  63 */         GL11.glReadPixels(0, 0, p_148259_2_, p_148259_3_, 32993, 33639, field_74293_b);
/*     */       } 
/*     */       
/*  66 */       field_74293_b.get(field_74294_c);
/*     */       
/*  68 */       TextureUtil.func_147953_a(field_74294_c, p_148259_2_, p_148259_3_);
/*     */ 
/*     */       
/*  71 */       BufferedImage bufferedImage = null;
/*  72 */       if (OpenGlHelper.func_148822_b()) {
/*  73 */         bufferedImage = new BufferedImage(p_148259_4_.field_147621_c, p_148259_4_.field_147618_d, 1);
/*  74 */         int j = p_148259_4_.field_147620_b - p_148259_4_.field_147618_d;
/*  75 */         for (int k = j; k < p_148259_4_.field_147620_b; k++) {
/*  76 */           for (byte b = 0; b < p_148259_4_.field_147621_c; b++) {
/*  77 */             bufferedImage.setRGB(b, k - j, field_74294_c[k * p_148259_4_.field_147622_a + b]);
/*     */           }
/*     */         } 
/*     */       } else {
/*  81 */         bufferedImage = new BufferedImage(p_148259_2_, p_148259_3_, 1);
/*  82 */         bufferedImage.setRGB(0, 0, p_148259_2_, p_148259_3_, field_74294_c, 0, p_148259_2_);
/*     */       } 
/*     */ 
/*     */       
/*  86 */       if (p_148259_1_ == null) {
/*  87 */         file2 = func_74290_a(file1);
/*     */       } else {
/*  89 */         file2 = new File(file1, p_148259_1_);
/*     */       } 
/*     */       
/*  92 */       ImageIO.write(bufferedImage, "png", file2);
/*     */       
/*  94 */       ChatComponentText chatComponentText = new ChatComponentText(file2.getName());
/*  95 */       chatComponentText.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.OPEN_FILE, file2.getAbsolutePath()));
/*  96 */       chatComponentText.func_150256_b().func_150228_d(Boolean.valueOf(true));
/*  97 */       return new ChatComponentTranslation("screenshot.success", new Object[] { chatComponentText });
/*  98 */     } catch (Exception exception) {
/*  99 */       field_148261_a.warn("Couldn't save screenshot", exception);
/* 100 */       return new ChatComponentTranslation("screenshot.failure", new Object[] { exception.getMessage() });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static File func_74290_a(File p_74290_0_) {
/* 106 */     String str = field_74295_a.format(new Date()).toString();
/*     */     
/* 108 */     for (byte b = 1;; b++) {
/* 109 */       File file = new File(p_74290_0_, str + ((b == 1) ? "" : ("_" + b)) + ".png");
/* 110 */       if (!file.exists())
/* 111 */         return file; 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\ScreenShotHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */