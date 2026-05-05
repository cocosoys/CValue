/*     */ package net.minecraft.client.gui;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.client.C16PacketClientStatus;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.commons.io.Charsets;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiWinGame extends GuiScreen {
/*  20 */   private static final Logger field_146580_a = LogManager.getLogger();
/*  21 */   private static final ResourceLocation field_146576_f = new ResourceLocation("textures/gui/title/minecraft.png");
/*  22 */   private static final ResourceLocation field_146577_g = new ResourceLocation("textures/misc/vignette.png");
/*     */   
/*     */   private int field_146581_h;
/*     */   private List field_146582_i;
/*     */   private int field_146579_r;
/*  27 */   private float field_146578_s = 0.5F;
/*     */   private static final String __OBFID = "CL_00000719";
/*     */   
/*     */   public void func_73876_c() {
/*  31 */     this.field_146581_h++;
/*  32 */     float f = (this.field_146579_r + this.field_146295_m + this.field_146295_m + 24) / this.field_146578_s;
/*  33 */     if (this.field_146581_h > f) {
/*  34 */       func_146574_g();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/*  40 */     if (p_73869_2_ == 1) {
/*  41 */       func_146574_g();
/*     */     }
/*     */   }
/*     */   
/*     */   private void func_146574_g() {
/*  46 */     this.field_146297_k.field_71439_g.field_71174_a.func_147297_a((Packet)new C16PacketClientStatus(C16PacketClientStatus.EnumState.PERFORM_RESPAWN));
/*  47 */     this.field_146297_k.func_147108_a(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/*  52 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  57 */     if (this.field_146582_i != null)
/*     */       return; 
/*  59 */     this.field_146582_i = new ArrayList();
/*     */     try {
/*  61 */       String str1 = "";
/*  62 */       String str2 = "" + EnumChatFormatting.WHITE + EnumChatFormatting.OBFUSCATED + EnumChatFormatting.GREEN + EnumChatFormatting.AQUA;
/*  63 */       char c = 'Ē';
/*  64 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.field_146297_k.func_110442_L().func_110536_a(new ResourceLocation("texts/end.txt")).func_110527_b(), Charsets.UTF_8));
/*  65 */       Random random = new Random(8124371L);
/*  66 */       while ((str1 = bufferedReader.readLine()) != null) {
/*  67 */         str1 = str1.replaceAll("PLAYERNAME", this.field_146297_k.func_110432_I().func_111285_a());
/*     */         
/*  69 */         while (str1.contains(str2)) {
/*  70 */           int i = str1.indexOf(str2);
/*  71 */           String str3 = str1.substring(0, i);
/*  72 */           String str4 = str1.substring(i + str2.length());
/*  73 */           str1 = str3 + EnumChatFormatting.WHITE + EnumChatFormatting.OBFUSCATED + "XXXXXXXX".substring(0, random.nextInt(4) + 3) + str4;
/*     */         } 
/*  75 */         this.field_146582_i.addAll(this.field_146297_k.field_71466_p.func_78271_c(str1, c));
/*  76 */         this.field_146582_i.add("");
/*     */       } 
/*     */       
/*  79 */       for (byte b = 0; b < 8; b++) {
/*  80 */         this.field_146582_i.add("");
/*     */       }
/*     */       
/*  83 */       bufferedReader = new BufferedReader(new InputStreamReader(this.field_146297_k.func_110442_L().func_110536_a(new ResourceLocation("texts/credits.txt")).func_110527_b(), Charsets.UTF_8));
/*  84 */       while ((str1 = bufferedReader.readLine()) != null) {
/*  85 */         str1 = str1.replaceAll("PLAYERNAME", this.field_146297_k.func_110432_I().func_111285_a());
/*  86 */         str1 = str1.replaceAll("\t", "    ");
/*     */         
/*  88 */         this.field_146582_i.addAll(this.field_146297_k.field_71466_p.func_78271_c(str1, c));
/*  89 */         this.field_146582_i.add("");
/*     */       } 
/*     */       
/*  92 */       this.field_146579_r = this.field_146582_i.size() * 12;
/*  93 */     } catch (Exception exception) {
/*  94 */       field_146580_a.error("Couldn't load credits", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_146575_b(int p_146575_1_, int p_146575_2_, float p_146575_3_) {
/*  99 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 101 */     this.field_146297_k.func_110434_K().func_110577_a(Gui.field_110325_k);
/* 102 */     tessellator.func_78382_b();
/* 103 */     tessellator.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F);
/* 104 */     int i = this.field_146294_l;
/* 105 */     float f1 = 0.0F - (this.field_146581_h + p_146575_3_) * 0.5F * this.field_146578_s;
/* 106 */     float f2 = this.field_146295_m - (this.field_146581_h + p_146575_3_) * 0.5F * this.field_146578_s;
/* 107 */     float f3 = 0.015625F;
/*     */     
/* 109 */     float f4 = (this.field_146581_h + p_146575_3_ - 0.0F) * 0.02F;
/*     */     
/* 111 */     float f5 = (this.field_146579_r + this.field_146295_m + this.field_146295_m + 24) / this.field_146578_s;
/* 112 */     float f6 = (f5 - 20.0F - this.field_146581_h + p_146575_3_) * 0.005F;
/* 113 */     if (f6 < f4) f4 = f6; 
/* 114 */     if (f4 > 1.0F) f4 = 1.0F; 
/* 115 */     f4 *= f4;
/* 116 */     f4 = f4 * 96.0F / 255.0F;
/* 117 */     tessellator.func_78386_a(f4, f4, f4);
/* 118 */     tessellator.func_78374_a(0.0D, this.field_146295_m, this.field_73735_i, 0.0D, (f1 * f3));
/* 119 */     tessellator.func_78374_a(i, this.field_146295_m, this.field_73735_i, (i * f3), (f1 * f3));
/* 120 */     tessellator.func_78374_a(i, 0.0D, this.field_73735_i, (i * f3), (f2 * f3));
/* 121 */     tessellator.func_78374_a(0.0D, 0.0D, this.field_73735_i, 0.0D, (f2 * f3));
/* 122 */     tessellator.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 127 */     func_146575_b(p_73863_1_, p_73863_2_, p_73863_3_);
/* 128 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 130 */     char c = 'Ē';
/* 131 */     int i = this.field_146294_l / 2 - c / 2;
/* 132 */     int j = this.field_146295_m + 50;
/*     */     
/* 134 */     float f = -(this.field_146581_h + p_73863_3_) * this.field_146578_s;
/* 135 */     GL11.glPushMatrix();
/* 136 */     GL11.glTranslatef(0.0F, f, 0.0F);
/* 137 */     this.field_146297_k.func_110434_K().func_110577_a(field_146576_f);
/* 138 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 139 */     func_73729_b(i, j, 0, 0, 155, 44);
/* 140 */     func_73729_b(i + 155, j, 0, 45, 155, 44);
/* 141 */     tessellator.func_78378_d(16777215);
/* 142 */     int k = j + 200;
/*     */     int m;
/* 144 */     for (m = 0; m < this.field_146582_i.size(); m++) {
/* 145 */       if (m == this.field_146582_i.size() - 1) {
/* 146 */         float f1 = k + f - (this.field_146295_m / 2 - 6);
/* 147 */         if (f1 < 0.0F) {
/* 148 */           GL11.glTranslatef(0.0F, -f1, 0.0F);
/*     */         }
/*     */       } 
/* 151 */       if (k + f + 12.0F + 8.0F > 0.0F && k + f < this.field_146295_m) {
/* 152 */         String str = this.field_146582_i.get(m);
/* 153 */         if (str.startsWith("[C]")) {
/* 154 */           this.field_146289_q.func_78261_a(str.substring(3), i + (c - this.field_146289_q.func_78256_a(str.substring(3))) / 2, k, 16777215);
/*     */         } else {
/* 156 */           this.field_146289_q.field_78289_c.setSeed(m * 4238972211L + (this.field_146581_h / 4));
/* 157 */           this.field_146289_q.func_78261_a(str, i, k, 16777215);
/*     */         } 
/*     */       } 
/* 160 */       k += 12;
/*     */     } 
/*     */     
/* 163 */     GL11.glPopMatrix();
/*     */     
/* 165 */     this.field_146297_k.func_110434_K().func_110577_a(field_146577_g);
/* 166 */     GL11.glEnable(3042);
/* 167 */     GL11.glBlendFunc(0, 769);
/* 168 */     tessellator.func_78382_b();
/* 169 */     tessellator.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F);
/* 170 */     m = this.field_146294_l;
/* 171 */     int n = this.field_146295_m;
/* 172 */     tessellator.func_78374_a(0.0D, n, this.field_73735_i, 0.0D, 1.0D);
/* 173 */     tessellator.func_78374_a(m, n, this.field_73735_i, 1.0D, 1.0D);
/* 174 */     tessellator.func_78374_a(m, 0.0D, this.field_73735_i, 1.0D, 0.0D);
/* 175 */     tessellator.func_78374_a(0.0D, 0.0D, this.field_73735_i, 0.0D, 0.0D);
/* 176 */     tessellator.func_78381_a();
/* 177 */     GL11.glDisable(3042);
/*     */     
/* 179 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiWinGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */