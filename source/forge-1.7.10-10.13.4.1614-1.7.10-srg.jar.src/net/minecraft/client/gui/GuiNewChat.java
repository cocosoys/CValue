/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiNewChat
/*     */   extends Gui
/*     */ {
/*  24 */   private static final Logger field_146249_a = LogManager.getLogger();
/*     */   
/*     */   private final Minecraft field_146247_f;
/*     */   
/*  28 */   private final List field_146248_g = new ArrayList();
/*  29 */   private final List field_146252_h = new ArrayList();
/*  30 */   private final List field_146253_i = new ArrayList();
/*     */   
/*     */   private int field_146250_j;
/*     */   
/*     */   public GuiNewChat(Minecraft p_i1022_1_) {
/*  35 */     this.field_146247_f = p_i1022_1_;
/*     */   }
/*     */   private boolean field_146251_k; private static final String __OBFID = "CL_00000669";
/*     */   public void func_146230_a(int p_146230_1_) {
/*  39 */     if (this.field_146247_f.field_71474_y.field_74343_n == EntityPlayer.EnumChatVisibility.HIDDEN)
/*     */       return; 
/*  41 */     int i = func_146232_i();
/*  42 */     boolean bool = false;
/*  43 */     byte b = 0;
/*  44 */     int j = this.field_146253_i.size();
/*  45 */     float f1 = this.field_146247_f.field_71474_y.field_74357_r * 0.9F + 0.1F;
/*     */     
/*  47 */     if (j <= 0)
/*     */       return; 
/*  49 */     if (func_146241_e()) {
/*  50 */       bool = true;
/*     */     }
/*     */     
/*  53 */     float f2 = func_146244_h();
/*  54 */     int k = MathHelper.func_76123_f(func_146228_f() / f2);
/*     */     
/*  56 */     GL11.glPushMatrix();
/*  57 */     GL11.glTranslatef(2.0F, 20.0F, 0.0F);
/*  58 */     GL11.glScalef(f2, f2, 1.0F);
/*     */     int m;
/*  60 */     for (m = 0; m + this.field_146250_j < this.field_146253_i.size() && m < i; m++) {
/*  61 */       ChatLine chatLine = this.field_146253_i.get(m + this.field_146250_j);
/*  62 */       if (chatLine != null) {
/*  63 */         int n = p_146230_1_ - chatLine.func_74540_b();
/*     */         
/*  65 */         if (n < 200 || bool) {
/*  66 */           double d = n / 200.0D;
/*  67 */           d = 1.0D - d;
/*  68 */           d *= 10.0D;
/*  69 */           if (d < 0.0D) d = 0.0D; 
/*  70 */           if (d > 1.0D) d = 1.0D; 
/*  71 */           d *= d;
/*  72 */           int i1 = (int)(255.0D * d);
/*  73 */           if (bool) i1 = 255; 
/*  74 */           i1 = (int)(i1 * f1);
/*     */           
/*  76 */           b++;
/*     */           
/*  78 */           if (i1 > 3) {
/*  79 */             byte b1 = 0;
/*  80 */             int i2 = -m * 9;
/*  81 */             func_73734_a(b1, i2 - 9, b1 + k + 4, i2, i1 / 2 << 24);
/*     */             
/*  83 */             String str = chatLine.func_151461_a().func_150254_d();
/*     */             
/*  85 */             this.field_146247_f.field_71466_p.func_78261_a(str, b1, i2 - 8, 16777215 + (i1 << 24));
/*  86 */             GL11.glDisable(3008);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  91 */     if (bool) {
/*  92 */       m = this.field_146247_f.field_71466_p.field_78288_b;
/*  93 */       GL11.glTranslatef(-3.0F, 0.0F, 0.0F);
/*     */       
/*  95 */       int n = j * m + j;
/*  96 */       int i1 = b * m + b;
/*  97 */       int i2 = this.field_146250_j * i1 / j;
/*  98 */       int i3 = i1 * i1 / n;
/*     */       
/* 100 */       if (n != i1) {
/* 101 */         byte b1 = (i2 > 0) ? 170 : 96;
/* 102 */         int i4 = this.field_146251_k ? 13382451 : 3355562;
/*     */         
/* 104 */         func_73734_a(0, -i2, 2, -i2 - i3, i4 + (b1 << 24));
/* 105 */         func_73734_a(2, -i2, 1, -i2 - i3, 13421772 + (b1 << 24));
/*     */       } 
/*     */     } 
/*     */     
/* 109 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void func_146231_a() {
/* 113 */     this.field_146253_i.clear();
/* 114 */     this.field_146252_h.clear();
/* 115 */     this.field_146248_g.clear();
/*     */   }
/*     */   
/*     */   public void func_146227_a(IChatComponent p_146227_1_) {
/* 119 */     func_146234_a(p_146227_1_, 0);
/*     */   }
/*     */   
/*     */   public void func_146234_a(IChatComponent p_146234_1_, int p_146234_2_) {
/* 123 */     func_146237_a(p_146234_1_, p_146234_2_, this.field_146247_f.field_71456_v.func_73834_c(), false);
/* 124 */     field_146249_a.info("[CHAT] " + p_146234_1_.func_150260_c());
/*     */   }
/*     */   
/*     */   private String func_146235_b(String p_146235_1_) {
/* 128 */     if ((Minecraft.func_71410_x()).field_71474_y.field_74344_o) {
/* 129 */       return p_146235_1_;
/*     */     }
/* 131 */     return EnumChatFormatting.func_110646_a(p_146235_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_146237_a(IChatComponent p_146237_1_, int p_146237_2_, int p_146237_3_, boolean p_146237_4_) {
/* 136 */     if (p_146237_2_ != 0) {
/* 137 */       func_146242_c(p_146237_2_);
/*     */     }
/*     */     
/* 140 */     int i = MathHelper.func_76141_d(func_146228_f() / func_146244_h());
/* 141 */     int j = 0;
/* 142 */     ChatComponentText chatComponentText = new ChatComponentText("");
/* 143 */     ArrayList<ChatComponentText> arrayList = Lists.newArrayList();
/* 144 */     ArrayList<IChatComponent> arrayList1 = Lists.newArrayList((Iterable)p_146237_1_);
/*     */     
/* 146 */     for (byte b = 0; b < arrayList1.size(); b++) {
/* 147 */       IChatComponent iChatComponent = arrayList1.get(b);
/* 148 */       String str = func_146235_b(iChatComponent.func_150256_b().func_150218_j() + iChatComponent.func_150261_e());
/* 149 */       int k = this.field_146247_f.field_71466_p.func_78256_a(str);
/* 150 */       ChatComponentText chatComponentText1 = new ChatComponentText(str);
/* 151 */       chatComponentText1.func_150255_a(iChatComponent.func_150256_b().func_150232_l());
/* 152 */       boolean bool1 = false;
/*     */       
/* 154 */       if (j + k > i) {
/* 155 */         String str1 = this.field_146247_f.field_71466_p.func_78262_a(str, i - j, false);
/* 156 */         String str2 = (str1.length() < str.length()) ? str.substring(str1.length()) : null;
/*     */         
/* 158 */         if (str2 != null && str2.length() > 0) {
/* 159 */           int m = str1.lastIndexOf(" ");
/* 160 */           if (m >= 0 && this.field_146247_f.field_71466_p.func_78256_a(str.substring(0, m)) > 0) {
/* 161 */             str1 = str.substring(0, m);
/* 162 */             str2 = str.substring(m);
/*     */           } 
/*     */           
/* 165 */           ChatComponentText chatComponentText2 = new ChatComponentText(str2);
/* 166 */           chatComponentText2.func_150255_a(iChatComponent.func_150256_b().func_150232_l());
/* 167 */           arrayList1.add(b + 1, chatComponentText2);
/*     */         } 
/*     */         
/* 170 */         str = str1;
/* 171 */         k = this.field_146247_f.field_71466_p.func_78256_a(str);
/* 172 */         chatComponentText1 = new ChatComponentText(str);
/* 173 */         chatComponentText1.func_150255_a(iChatComponent.func_150256_b().func_150232_l());
/* 174 */         bool1 = true;
/*     */       } 
/*     */       
/* 177 */       if (j + k <= i) {
/* 178 */         j += k;
/*     */         
/* 180 */         chatComponentText.func_150257_a((IChatComponent)chatComponentText1);
/*     */       } else {
/* 182 */         bool1 = true;
/*     */       } 
/*     */       
/* 185 */       if (bool1) {
/* 186 */         arrayList.add(chatComponentText);
/* 187 */         j = 0;
/* 188 */         chatComponentText = new ChatComponentText("");
/*     */       } 
/*     */     } 
/*     */     
/* 192 */     arrayList.add(chatComponentText);
/*     */     
/* 194 */     boolean bool = func_146241_e();
/* 195 */     for (IChatComponent iChatComponent : arrayList) {
/* 196 */       if (bool && this.field_146250_j > 0) {
/* 197 */         this.field_146251_k = true;
/* 198 */         func_146229_b(1);
/*     */       } 
/*     */       
/* 201 */       this.field_146253_i.add(0, new ChatLine(p_146237_3_, iChatComponent, p_146237_2_));
/*     */     } 
/*     */     
/* 204 */     while (this.field_146253_i.size() > 100) {
/* 205 */       this.field_146253_i.remove(this.field_146253_i.size() - 1);
/*     */     }
/*     */     
/* 208 */     if (!p_146237_4_) {
/* 209 */       this.field_146252_h.add(0, new ChatLine(p_146237_3_, p_146237_1_, p_146237_2_));
/*     */       
/* 211 */       while (this.field_146252_h.size() > 100) {
/* 212 */         this.field_146252_h.remove(this.field_146252_h.size() - 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_146245_b() {
/* 218 */     this.field_146253_i.clear();
/* 219 */     func_146240_d();
/*     */     
/* 221 */     for (int i = this.field_146252_h.size() - 1; i >= 0; i--) {
/* 222 */       ChatLine chatLine = this.field_146252_h.get(i);
/* 223 */       func_146237_a(chatLine.func_151461_a(), chatLine.func_74539_c(), chatLine.func_74540_b(), true);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List func_146238_c() {
/* 228 */     return this.field_146248_g;
/*     */   }
/*     */   
/*     */   public void func_146239_a(String p_146239_1_) {
/* 232 */     if (this.field_146248_g.isEmpty() || !((String)this.field_146248_g.get(this.field_146248_g.size() - 1)).equals(p_146239_1_)) {
/* 233 */       this.field_146248_g.add(p_146239_1_);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_146240_d() {
/* 238 */     this.field_146250_j = 0;
/* 239 */     this.field_146251_k = false;
/*     */   }
/*     */   
/*     */   public void func_146229_b(int p_146229_1_) {
/* 243 */     this.field_146250_j += p_146229_1_;
/* 244 */     int i = this.field_146253_i.size();
/*     */     
/* 246 */     if (this.field_146250_j > i - func_146232_i()) this.field_146250_j = i - func_146232_i();
/*     */     
/* 248 */     if (this.field_146250_j <= 0) {
/* 249 */       this.field_146250_j = 0;
/* 250 */       this.field_146251_k = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public IChatComponent func_146236_a(int p_146236_1_, int p_146236_2_) {
/* 255 */     if (!func_146241_e()) return null; 
/* 256 */     ScaledResolution scaledResolution = new ScaledResolution(this.field_146247_f, this.field_146247_f.field_71443_c, this.field_146247_f.field_71440_d);
/*     */     
/* 258 */     int i = scaledResolution.func_78325_e();
/* 259 */     float f = func_146244_h();
/* 260 */     int j = p_146236_1_ / i - 3;
/* 261 */     int k = p_146236_2_ / i - 27;
/* 262 */     j = MathHelper.func_76141_d(j / f);
/* 263 */     k = MathHelper.func_76141_d(k / f);
/*     */     
/* 265 */     if (j < 0 || k < 0) return null; 
/* 266 */     int m = Math.min(func_146232_i(), this.field_146253_i.size());
/*     */     
/* 268 */     if (j <= MathHelper.func_76141_d(func_146228_f() / func_146244_h()) && k < this.field_146247_f.field_71466_p.field_78288_b * m + m) {
/* 269 */       int n = k / this.field_146247_f.field_71466_p.field_78288_b + this.field_146250_j;
/* 270 */       if (n >= 0 && n < this.field_146253_i.size()) {
/* 271 */         ChatLine chatLine = this.field_146253_i.get(n);
/* 272 */         int i1 = 0;
/*     */         
/* 274 */         for (IChatComponent iChatComponent : chatLine.func_151461_a()) {
/* 275 */           if (iChatComponent instanceof ChatComponentText) {
/* 276 */             i1 += this.field_146247_f.field_71466_p.func_78256_a(func_146235_b(((ChatComponentText)iChatComponent).func_150265_g()));
/*     */             
/* 278 */             if (i1 > j) {
/* 279 */               return iChatComponent;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 285 */       return null;
/*     */     } 
/*     */     
/* 288 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_146241_e() {
/* 292 */     return this.field_146247_f.field_71462_r instanceof GuiChat;
/*     */   }
/*     */   
/*     */   public void func_146242_c(int p_146242_1_) {
/* 296 */     Iterator<ChatLine> iterator = this.field_146253_i.iterator();
/*     */     
/* 298 */     while (iterator.hasNext()) {
/* 299 */       ChatLine chatLine = iterator.next();
/*     */       
/* 301 */       if (chatLine.func_74539_c() == p_146242_1_) {
/* 302 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */     
/* 306 */     iterator = this.field_146252_h.iterator();
/*     */     
/* 308 */     while (iterator.hasNext()) {
/* 309 */       ChatLine chatLine = iterator.next();
/*     */       
/* 311 */       if (chatLine.func_74539_c() == p_146242_1_) {
/* 312 */         iterator.remove();
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int func_146228_f() {
/* 319 */     return func_146233_a(this.field_146247_f.field_71474_y.field_96692_F);
/*     */   }
/*     */   
/*     */   public int func_146246_g() {
/* 323 */     return func_146243_b(func_146241_e() ? this.field_146247_f.field_71474_y.field_96694_H : this.field_146247_f.field_71474_y.field_96693_G);
/*     */   }
/*     */   
/*     */   public float func_146244_h() {
/* 327 */     return this.field_146247_f.field_71474_y.field_96691_E;
/*     */   }
/*     */   
/*     */   public static int func_146233_a(float p_146233_0_) {
/* 331 */     char c = 'ŀ';
/* 332 */     byte b = 40;
/* 333 */     return MathHelper.func_76141_d(p_146233_0_ * (c - b) + b);
/*     */   }
/*     */   
/*     */   public static int func_146243_b(float p_146243_0_) {
/* 337 */     char c = '´';
/* 338 */     byte b = 20;
/* 339 */     return MathHelper.func_76141_d(p_146243_0_ * (c - b) + b);
/*     */   }
/*     */   
/*     */   public int func_146232_i() {
/* 343 */     return func_146246_g() / 9;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiNewChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */