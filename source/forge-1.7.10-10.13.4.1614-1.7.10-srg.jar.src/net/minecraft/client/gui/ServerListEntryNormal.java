/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.util.concurrent.ThreadFactoryBuilder;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.buffer.ByteBufInputStream;
/*     */ import io.netty.buffer.Unpooled;
/*     */ import io.netty.handler.codec.base64.Base64;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.InputStream;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.ScheduledThreadPoolExecutor;
/*     */ import java.util.concurrent.ThreadPoolExecutor;
/*     */ import javax.imageio.ImageIO;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.multiplayer.ServerData;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import net.minecraft.client.renderer.texture.ITextureObject;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.commons.lang3.Validate;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ServerListEntryNormal
/*     */   implements GuiListExtended.IGuiListEntry {
/*  33 */   private static final Logger field_148304_a = LogManager.getLogger();
/*  34 */   private static final ThreadPoolExecutor field_148302_b = new ScheduledThreadPoolExecutor(5, (new ThreadFactoryBuilder()).setNameFormat("Server Pinger #%d").setDaemon(true).build());
/*     */   
/*     */   private final GuiMultiplayer field_148303_c;
/*     */   
/*     */   private final Minecraft field_148300_d;
/*     */   private final ServerData field_148301_e;
/*     */   private long field_148298_f;
/*     */   private String field_148299_g;
/*     */   private DynamicTexture field_148305_h;
/*     */   private ResourceLocation field_148306_i;
/*     */   private static final String __OBFID = "CL_00000817";
/*     */   
/*     */   protected ServerListEntryNormal(GuiMultiplayer p_i45048_1_, ServerData p_i45048_2_) {
/*  47 */     this.field_148303_c = p_i45048_1_;
/*  48 */     this.field_148301_e = p_i45048_2_;
/*  49 */     this.field_148300_d = Minecraft.func_71410_x();
/*  50 */     this.field_148306_i = new ResourceLocation("servers/" + p_i45048_2_.field_78845_b + "/icon");
/*  51 */     this.field_148305_h = (DynamicTexture)this.field_148300_d.func_110434_K().func_110581_b(this.field_148306_i);
/*     */   }
/*     */   public void func_148279_a(int p_148279_1_, int p_148279_2_, int p_148279_3_, int p_148279_4_, int p_148279_5_, Tessellator p_148279_6_, int p_148279_7_, int p_148279_8_, boolean p_148279_9_) {
/*     */     int j;
/*     */     String str3;
/*  56 */     if (!this.field_148301_e.field_78841_f) {
/*  57 */       this.field_148301_e.field_78841_f = true;
/*  58 */       this.field_148301_e.field_78844_e = -2L;
/*  59 */       this.field_148301_e.field_78843_d = "";
/*  60 */       this.field_148301_e.field_78846_c = "";
/*     */       
/*  62 */       field_148302_b.submit(new Runnable(this) { private static final String __OBFID = "CL_00000818";
/*     */             
/*     */             public void run() {
/*     */               try {
/*  66 */                 this.field_148521_a.field_148303_c.func_146789_i().func_147224_a(this.field_148521_a.field_148301_e);
/*  67 */               } catch (UnknownHostException unknownHostException) {
/*  68 */                 this.field_148521_a.field_148301_e.field_78844_e = -1L;
/*  69 */                 this.field_148521_a.field_148301_e.field_78843_d = EnumChatFormatting.DARK_RED + "Can't resolve hostname";
/*  70 */               } catch (Exception exception) {
/*  71 */                 this.field_148521_a.field_148301_e.field_78844_e = -1L;
/*  72 */                 this.field_148521_a.field_148301_e.field_78843_d = EnumChatFormatting.DARK_RED + "Can't connect to server.";
/*     */               } 
/*     */             } }
/*     */         );
/*     */     } 
/*     */     
/*  78 */     boolean bool1 = (this.field_148301_e.field_82821_f > 5) ? true : false;
/*  79 */     boolean bool2 = (this.field_148301_e.field_82821_f < 5) ? true : false;
/*  80 */     boolean bool3 = (bool1 || bool2) ? true : false;
/*     */     
/*  82 */     this.field_148300_d.field_71466_p.func_78276_b(this.field_148301_e.field_78847_a, p_148279_2_ + 32 + 3, p_148279_3_ + 1, 16777215);
/*     */     
/*  84 */     List<String> list = this.field_148300_d.field_71466_p.func_78271_c(this.field_148301_e.field_78843_d, p_148279_4_ - 32 - 2);
/*  85 */     for (byte b1 = 0; b1 < Math.min(list.size(), 2); b1++) {
/*  86 */       this.field_148300_d.field_71466_p.func_78276_b(list.get(b1), p_148279_2_ + 32 + 3, p_148279_3_ + 12 + this.field_148300_d.field_71466_p.field_78288_b * b1, 8421504);
/*     */     }
/*     */     
/*  89 */     String str1 = bool3 ? (EnumChatFormatting.DARK_RED + this.field_148301_e.field_82822_g) : this.field_148301_e.field_78846_c;
/*  90 */     int i = this.field_148300_d.field_71466_p.func_78256_a(str1);
/*  91 */     this.field_148300_d.field_71466_p.func_78276_b(str1, p_148279_2_ + p_148279_4_ - i - 15 - 2, p_148279_3_ + 1, 8421504);
/*     */ 
/*     */     
/*  94 */     byte b2 = 0;
/*     */     
/*  96 */     String str2 = null;
/*     */ 
/*     */     
/*  99 */     if (bool3) {
/* 100 */       j = 5;
/* 101 */       str3 = bool1 ? "Client out of date!" : "Server out of date!";
/* 102 */       str2 = this.field_148301_e.field_147412_i;
/* 103 */     } else if (this.field_148301_e.field_78841_f && this.field_148301_e.field_78844_e != -2L) {
/* 104 */       if (this.field_148301_e.field_78844_e < 0L) { j = 5; }
/* 105 */       else if (this.field_148301_e.field_78844_e < 150L) { j = 0; }
/* 106 */       else if (this.field_148301_e.field_78844_e < 300L) { j = 1; }
/* 107 */       else if (this.field_148301_e.field_78844_e < 600L) { j = 2; }
/* 108 */       else if (this.field_148301_e.field_78844_e < 1000L) { j = 3; }
/* 109 */       else { j = 4; }
/*     */       
/* 111 */       if (this.field_148301_e.field_78844_e < 0L) {
/* 112 */         str3 = "(no connection)";
/*     */       } else {
/* 114 */         str3 = this.field_148301_e.field_78844_e + "ms";
/* 115 */         str2 = this.field_148301_e.field_147412_i;
/*     */       } 
/*     */     } else {
/* 118 */       b2 = 1;
/* 119 */       j = (int)(Minecraft.func_71386_F() / 100L + (p_148279_1_ * 2) & 0x7L);
/* 120 */       if (j > 4) j = 8 - j; 
/* 121 */       str3 = "Pinging...";
/*     */     } 
/*     */     
/* 124 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 125 */     this.field_148300_d.func_110434_K().func_110577_a(Gui.field_110324_m);
/* 126 */     Gui.func_146110_a(p_148279_2_ + p_148279_4_ - 15, p_148279_3_, (b2 * 10), (176 + j * 8), 10, 8, 256.0F, 256.0F);
/*     */     
/* 128 */     if (this.field_148301_e.func_147409_e() != null && !this.field_148301_e.func_147409_e().equals(this.field_148299_g)) {
/* 129 */       this.field_148299_g = this.field_148301_e.func_147409_e();
/* 130 */       func_148297_b();
/* 131 */       this.field_148303_c.func_146795_p().func_78855_b();
/*     */     } 
/*     */     
/* 134 */     if (this.field_148305_h != null) {
/* 135 */       this.field_148300_d.func_110434_K().func_110577_a(this.field_148306_i);
/* 136 */       Gui.func_146110_a(p_148279_2_, p_148279_3_, 0.0F, 0.0F, 32, 32, 32.0F, 32.0F);
/*     */     } 
/*     */     
/* 139 */     int k = p_148279_7_ - p_148279_2_;
/* 140 */     int m = p_148279_8_ - p_148279_3_;
/* 141 */     if (k >= p_148279_4_ - 15 && k <= p_148279_4_ - 5 && m >= 0 && m <= 8) {
/* 142 */       this.field_148303_c.func_146793_a(str3);
/* 143 */     } else if (k >= p_148279_4_ - i - 15 - 2 && k <= p_148279_4_ - 15 - 2 && m >= 0 && m <= 8) {
/* 144 */       this.field_148303_c.func_146793_a(str2);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_148297_b() {
/* 149 */     if (this.field_148301_e.func_147409_e() == null) {
/* 150 */       this.field_148300_d.func_110434_K().func_147645_c(this.field_148306_i);
/* 151 */       this.field_148305_h = null;
/*     */     } else {
/*     */       BufferedImage bufferedImage;
/* 154 */       ByteBuf byteBuf1 = Unpooled.copiedBuffer(this.field_148301_e.func_147409_e(), Charsets.UTF_8);
/* 155 */       ByteBuf byteBuf2 = Base64.decode(byteBuf1);
/*     */       
/*     */       try {
/* 158 */         bufferedImage = ImageIO.read((InputStream)new ByteBufInputStream(byteBuf2));
/* 159 */         Validate.validState((bufferedImage.getWidth() == 64), "Must be 64 pixels wide", new Object[0]);
/* 160 */         Validate.validState((bufferedImage.getHeight() == 64), "Must be 64 pixels high", new Object[0]);
/* 161 */       } catch (Exception exception) {
/* 162 */         field_148304_a.error("Invalid icon for server " + this.field_148301_e.field_78847_a + " (" + this.field_148301_e.field_78845_b + ")", exception);
/* 163 */         this.field_148301_e.func_147407_a(null);
/*     */         return;
/*     */       } finally {
/* 166 */         byteBuf1.release();
/* 167 */         byteBuf2.release();
/*     */       } 
/*     */       
/* 170 */       if (this.field_148305_h == null) {
/* 171 */         this.field_148305_h = new DynamicTexture(bufferedImage.getWidth(), bufferedImage.getHeight());
/* 172 */         this.field_148300_d.func_110434_K().func_110579_a(this.field_148306_i, (ITextureObject)this.field_148305_h);
/*     */       } 
/*     */       
/* 175 */       bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), this.field_148305_h.func_110565_c(), 0, bufferedImage.getWidth());
/* 176 */       this.field_148305_h.func_110564_a();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_148278_a(int p_148278_1_, int p_148278_2_, int p_148278_3_, int p_148278_4_, int p_148278_5_, int p_148278_6_) {
/* 182 */     this.field_148303_c.func_146790_a(p_148278_1_);
/* 183 */     if (Minecraft.func_71386_F() - this.field_148298_f < 250L) {
/* 184 */       this.field_148303_c.func_146796_h();
/*     */     }
/* 186 */     this.field_148298_f = Minecraft.func_71386_F();
/* 187 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148277_b(int p_148277_1_, int p_148277_2_, int p_148277_3_, int p_148277_4_, int p_148277_5_, int p_148277_6_) {}
/*     */ 
/*     */   
/*     */   public ServerData func_148296_a() {
/* 195 */     return this.field_148301_e;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\ServerListEntryNormal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */