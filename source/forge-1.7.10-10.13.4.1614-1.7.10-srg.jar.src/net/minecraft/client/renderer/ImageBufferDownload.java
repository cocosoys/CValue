/*    */ package net.minecraft.client.renderer;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.awt.image.DataBufferInt;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ImageBufferDownload implements IImageBuffer {
/*    */   private int[] field_78438_a;
/*    */   
/*    */   public BufferedImage func_78432_a(BufferedImage p_78432_1_) {
/* 12 */     if (p_78432_1_ == null) return null;
/*    */     
/* 14 */     this.field_78436_b = 64;
/* 15 */     this.field_78437_c = 32;
/*    */     
/* 17 */     BufferedImage bufferedImage = new BufferedImage(this.field_78436_b, this.field_78437_c, 2);
/* 18 */     Graphics graphics = bufferedImage.getGraphics();
/* 19 */     graphics.drawImage(p_78432_1_, 0, 0, null);
/* 20 */     graphics.dispose();
/*    */     
/* 22 */     this.field_78438_a = ((DataBufferInt)bufferedImage.getRaster().getDataBuffer()).getData();
/*    */     
/* 24 */     func_78433_b(0, 0, 32, 16);
/* 25 */     func_78434_a(32, 0, 64, 32);
/* 26 */     func_78433_b(0, 16, 64, 32);
/*    */     
/* 28 */     return bufferedImage;
/*    */   }
/*    */   private int field_78436_b; private int field_78437_c;
/*    */   private static final String __OBFID = "CL_00000956";
/*    */   
/*    */   public void func_152634_a() {}
/*    */   
/*    */   private void func_78434_a(int p_78434_1_, int p_78434_2_, int p_78434_3_, int p_78434_4_) {
/* 36 */     if (func_78435_c(p_78434_1_, p_78434_2_, p_78434_3_, p_78434_4_))
/*    */       return; 
/* 38 */     for (int i = p_78434_1_; i < p_78434_3_; i++) {
/* 39 */       for (int j = p_78434_2_; j < p_78434_4_; j++) {
/* 40 */         this.field_78438_a[i + j * this.field_78436_b] = this.field_78438_a[i + j * this.field_78436_b] & 0xFFFFFF;
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   private void func_78433_b(int p_78433_1_, int p_78433_2_, int p_78433_3_, int p_78433_4_) {
/* 46 */     for (int i = p_78433_1_; i < p_78433_3_; i++) {
/* 47 */       for (int j = p_78433_2_; j < p_78433_4_; j++) {
/* 48 */         this.field_78438_a[i + j * this.field_78436_b] = this.field_78438_a[i + j * this.field_78436_b] | 0xFF000000;
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   private boolean func_78435_c(int p_78435_1_, int p_78435_2_, int p_78435_3_, int p_78435_4_) {
/* 54 */     for (int i = p_78435_1_; i < p_78435_3_; i++) {
/* 55 */       for (int j = p_78435_2_; j < p_78435_4_; j++) {
/* 56 */         int k = this.field_78438_a[i + j * this.field_78436_b];
/* 57 */         if ((k >> 24 & 0xFF) < 128) return true; 
/*    */       } 
/*    */     } 
/* 60 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\ImageBufferDownload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */