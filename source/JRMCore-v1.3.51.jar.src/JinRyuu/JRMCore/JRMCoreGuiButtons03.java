/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.notification.JGNotificationHandler;
/*     */ import java.awt.Color;
/*     */ import java.time.Duration;
/*     */ import java.time.Instant;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class JRMCoreGuiButtons03
/*     */   extends GuiButton
/*     */ {
/*  17 */   public static String icons = JRMCoreH.tjjrmc + ":icons3.png";
/*  18 */   public static int newsAnimation = 0; public static int noticiationAnimation = 0; public static int noticiationAnimationLast = 0;
/*  19 */   public static Instant animation = null;
/*  20 */   public static float rotation = 0.0F;
/*     */ 
/*     */   
/*     */   private int col;
/*     */   
/*     */   private int type;
/*     */   
/*     */   private int resourceID;
/*     */ 
/*     */   
/*     */   public JRMCoreGuiButtons03(int par1, int par2, int par3, String par6Str, int type, int col, int resourceID) {
/*  31 */     super(par1, par2, par3, 20, 20, par6Str);
/*  32 */     this.field_146120_f = 20;
/*  33 */     this.field_146121_g = 20;
/*  34 */     this.col = col;
/*  35 */     this.type = type;
/*  36 */     this.resourceID = resourceID;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146112_a(Minecraft par1Minecraft, int par2, int par3) {
/*  42 */     if (this.field_146125_m) {
/*     */       
/*  44 */       int t = (int)(System.currentTimeMillis() / 100L % 20L);
/*  45 */       newsAnimation = t - 10; newsAnimation = (newsAnimation < 0) ? (newsAnimation * -1) : newsAnimation;
/*     */       
/*  47 */       boolean hasNewContent = JGNotificationHandler.hasNewContent;
/*     */       
/*  49 */       if (!hasNewContent)
/*     */       {
/*  51 */         animation = null;
/*     */       }
/*     */ 
/*     */       
/*  55 */       FontRenderer var4 = par1Minecraft.field_71466_p;
/*  56 */       ResourceLocation txx = new ResourceLocation(icons);
/*  57 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/*  58 */       GL11.glColor4f(0.7F, 0.7F, 0.7F, 1.0F);
/*  59 */       this.field_146123_n = (par2 >= this.field_146128_h && par3 >= this.field_146129_i && par2 < this.field_146128_h + this.field_146120_f && par3 < this.field_146129_i + this.field_146121_g);
/*  60 */       int var5 = func_146114_a(this.field_146123_n);
/*     */       
/*  62 */       boolean redBack = (this.resourceID == 10 || this.resourceID == 9 || this.resourceID == 8);
/*     */       
/*  64 */       int j = (this.col == 0) ? 16449280 : this.col;
/*  65 */       float h2 = (j >> 16 & 0xFF) / 255.0F;
/*  66 */       float h3 = (j >> 8 & 0xFF) / 255.0F;
/*  67 */       float h4 = (j & 0xFF) / 255.0F;
/*     */       
/*  69 */       float h1 = redBack ? 2.0F : 1.0F;
/*     */       
/*  71 */       if (var5 == 2) {
/*  72 */         int r = (int)(h2 * 254.0F);
/*  73 */         int g = (int)(h3 * 254.0F);
/*  74 */         int b = (int)(h4 * 254.0F);
/*  75 */         float[] hsb = Color.RGBtoHSB(r, g, b, null);
/*  76 */         float hue = hsb[0];
/*  77 */         float saturation = 0.33F;
/*  78 */         float brightness = hsb[2];
/*  79 */         int rgb = Color.HSBtoRGB(hue, saturation, brightness);
/*  80 */         h2 = (rgb >> 16 & 0xFF) / 255.0F;
/*  81 */         h3 = (rgb >> 8 & 0xFF) / 255.0F;
/*  82 */         h4 = (rgb & 0xFF) / 255.0F;
/*     */       } 
/*  84 */       GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
/*     */       
/*  86 */       func_73729_b(this.field_146128_h, this.field_146129_i, 0 + var5 * 20 + (redBack ? (80 - var5 * 20) : 0), 156 + this.type * 20 + (redBack ? (var5 * 20) : 0), this.field_146120_f, this.field_146121_g);
/*     */       
/*  88 */       func_146119_b(par1Minecraft, par2, par3);
/*  89 */       int var6 = 14737632;
/*     */       
/*  91 */       if (!this.field_146124_l) {
/*     */         
/*  93 */         var6 = -6250336;
/*     */       }
/*  95 */       else if (this.field_146123_n) {
/*     */         
/*  97 */         var6 = 16777120;
/*     */       } 
/*     */       
/* 100 */       if (this.resourceID == 0 || this.resourceID == 10) {
/*     */         
/* 102 */         int r = (int)(h2 * 254.0F);
/* 103 */         int g = (int)(h3 * 254.0F);
/* 104 */         int b = (int)(h4 * 254.0F);
/* 105 */         float[] hsb = Color.RGBtoHSB(r, g, b, null);
/* 106 */         float hue = 0.0F;
/* 107 */         float saturation = 0.0F;
/* 108 */         float brightness = 1.0F;
/*     */         
/* 110 */         brightness = 0.75F + newsAnimation / 40.0F;
/*     */         
/* 112 */         brightness = (brightness < 0.75F) ? 0.75F : ((brightness > 1.0F) ? 1.0F : brightness);
/* 113 */         int rgb = Color.HSBtoRGB(hue, saturation, brightness);
/* 114 */         h2 = (rgb >> 16 & 0xFF) / 255.0F;
/* 115 */         h3 = (rgb >> 8 & 0xFF) / 255.0F;
/* 116 */         h4 = (rgb & 0xFF) / 255.0F;
/* 117 */         GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 123 */         float color = (var5 == 2 || this.type == 1) ? 1.0F : 0.6F;
/* 124 */         GL11.glColor4f(color, color, color, 1.0F);
/*     */       } 
/*     */ 
/*     */       
/* 128 */       txx = new ResourceLocation(icons);
/* 129 */       par1Minecraft.func_110434_K().func_110577_a(txx);
/*     */       
/* 131 */       GL11.glPushMatrix();
/* 132 */       GL11.glTranslatef((this.field_146128_h + 2), (this.field_146129_i + 2), 0.0F);
/*     */       
/* 134 */       boolean isNotification = (this.resourceID == 10);
/*     */       
/* 136 */       if (isNotification && animation != null) {
/*     */         
/* 138 */         float rotation = (float)Duration.between(animation, Instant.now()).toMillis() / 10.0F;
/* 139 */         JRMCoreGuiButtons03.rotation += rotation;
/* 140 */         rotation = (float)Math.sin((JRMCoreGuiButtons03.rotation / 25.0F)) * 20.0F;
/* 141 */         GL11.glTranslatef(8.0F, 8.0F, 0.0F);
/* 142 */         GL11.glRotatef(rotation, 0.0F, 0.0F, 1.0F);
/*     */       } 
/*     */       
/* 145 */       func_73729_b((isNotification && hasNewContent && animation != null) ? -8 : 0, (isNotification && hasNewContent && animation != null) ? -8 : 0, this.resourceID * 16, (JRMCoreH.Pwrtyp == 2) ? 16 : ((JRMCoreH.Pwrtyp == 3) ? 32 : 0), 16, 16);
/*     */       
/* 147 */       GL11.glPopMatrix();
/*     */ 
/*     */       
/* 150 */       if (isNotification) {
/*     */         
/* 152 */         float rotation = (float)Math.sin((JRMCoreGuiButtons03.rotation / 30.0F)) * 3.0F;
/*     */ 
/*     */         
/* 155 */         int MUTED = 0, NEW = 1, NORMAL = 2;
/* 156 */         int state = hasNewContent ? 1 : 2;
/*     */         
/* 158 */         int bonusY = (int)rotation;
/*     */         
/* 160 */         if (state == 1) {
/*     */           
/* 162 */           if (JRMCoreClient.mc.field_71439_g.field_70173_aa != noticiationAnimationLast)
/*     */           {
/* 164 */             noticiationAnimation++;
/* 165 */             if (noticiationAnimation > 3) noticiationAnimation = 0; 
/* 166 */             noticiationAnimationLast = JRMCoreClient.mc.field_71439_g.field_70173_aa;
/*     */           }
/*     */         
/* 169 */         } else if (bonusY != 0) {
/*     */           
/* 171 */           bonusY = 0;
/*     */         } 
/*     */         
/* 174 */         rotation = (float)Math.sin((JRMCoreGuiButtons03.rotation / 25.0F)) * 20.0F;
/*     */         
/* 176 */         GL11.glPushMatrix();
/* 177 */         GL11.glTranslatef((this.field_146128_h + 2), (this.field_146129_i + 2 + bonusY), 0.0F);
/* 178 */         GL11.glTranslatef(8.0F, 8.0F, 0.0F);
/* 179 */         GL11.glRotatef(rotation, 0.0F, 0.0F, 1.0F);
/*     */         
/* 181 */         func_73729_b(isNotification ? -8 : 0, isNotification ? -8 : 0, 16, 48 + state * 16, 16, 16);
/*     */         
/* 183 */         GL11.glPopMatrix();
/*     */         
/* 185 */         if (state == 1)
/*     */         {
/* 187 */           animation = Instant.now();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiButtons03.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */