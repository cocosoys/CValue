/*     */ package net.minecraft.client.gui;
/*     */ import com.google.common.base.Splitter;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Sets;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.File;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Set;
/*     */ import net.minecraft.client.gui.stream.GuiTwitchUserMode;
/*     */ import net.minecraft.event.ClickEvent;
/*     */ import net.minecraft.event.HoverEvent;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.JsonToNBT;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTException;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.play.client.C14PacketTabComplete;
/*     */ import net.minecraft.stats.Achievement;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import tv.twitch.chat.ChatUserInfo;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiChat extends GuiScreen implements GuiYesNoCallback {
/*  38 */   private static final Set field_152175_f = Sets.newHashSet((Object[])new String[] { "http", "https" });
/*     */   
/*  40 */   private static final Logger field_146408_f = LogManager.getLogger();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   private String field_146410_g = "";
/*  46 */   private int field_146416_h = -1;
/*     */   private boolean field_146417_i;
/*     */   private boolean field_146414_r;
/*     */   private int field_146413_s;
/*  50 */   private List field_146412_t = new ArrayList();
/*     */   private URI field_146411_u;
/*     */   protected GuiTextField field_146415_a;
/*  53 */   private String field_146409_v = "";
/*     */   private static final String __OBFID = "CL_00000682";
/*     */   
/*     */   public GuiChat() {}
/*     */   
/*     */   public GuiChat(String p_i1024_1_) {
/*  59 */     this.field_146409_v = p_i1024_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  64 */     Keyboard.enableRepeatEvents(true);
/*     */     
/*  66 */     this.field_146416_h = this.field_146297_k.field_71456_v.func_146158_b().func_146238_c().size();
/*  67 */     this.field_146415_a = new GuiTextField(this.field_146289_q, 4, this.field_146295_m - 12, this.field_146294_l - 4, 12);
/*  68 */     this.field_146415_a.func_146203_f(100);
/*  69 */     this.field_146415_a.func_146185_a(false);
/*  70 */     this.field_146415_a.func_146195_b(true);
/*  71 */     this.field_146415_a.func_146180_a(this.field_146409_v);
/*  72 */     this.field_146415_a.func_146205_d(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/*  77 */     Keyboard.enableRepeatEvents(false);
/*     */     
/*  79 */     this.field_146297_k.field_71456_v.func_146158_b().func_146240_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  84 */     this.field_146415_a.func_146178_a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/*  89 */     this.field_146414_r = false;
/*     */     
/*  91 */     if (p_73869_2_ == 15) {
/*  92 */       func_146404_p_();
/*     */     } else {
/*  94 */       this.field_146417_i = false;
/*     */     } 
/*     */     
/*  97 */     if (p_73869_2_ == 1) {
/*  98 */       this.field_146297_k.func_147108_a(null);
/*  99 */     } else if (p_73869_2_ == 28 || p_73869_2_ == 156) {
/* 100 */       String str = this.field_146415_a.func_146179_b().trim();
/*     */       
/* 102 */       if (str.length() > 0) {
/* 103 */         func_146403_a(str);
/*     */       }
/*     */       
/* 106 */       this.field_146297_k.func_147108_a(null);
/* 107 */     } else if (p_73869_2_ == 200) {
/* 108 */       func_146402_a(-1);
/* 109 */     } else if (p_73869_2_ == 208) {
/* 110 */       func_146402_a(1);
/* 111 */     } else if (p_73869_2_ == 201) {
/* 112 */       this.field_146297_k.field_71456_v.func_146158_b().func_146229_b(this.field_146297_k.field_71456_v.func_146158_b().func_146232_i() - 1);
/* 113 */     } else if (p_73869_2_ == 209) {
/* 114 */       this.field_146297_k.field_71456_v.func_146158_b().func_146229_b(-this.field_146297_k.field_71456_v.func_146158_b().func_146232_i() + 1);
/*     */     } else {
/* 116 */       this.field_146415_a.func_146201_a(p_73869_1_, p_73869_2_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_146403_a(String p_146403_1_) {
/* 121 */     this.field_146297_k.field_71456_v.func_146158_b().func_146239_a(p_146403_1_);
/* 122 */     this.field_146297_k.field_71439_g.func_71165_d(p_146403_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146274_d() {
/* 127 */     super.func_146274_d();
/*     */     
/* 129 */     int i = Mouse.getEventDWheel();
/*     */     
/* 131 */     if (i != 0) {
/* 132 */       if (i > 1) i = 1; 
/* 133 */       if (i < -1) i = -1; 
/* 134 */       if (!func_146272_n()) i *= 7; 
/* 135 */       this.field_146297_k.field_71456_v.func_146158_b().func_146229_b(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 141 */     if (p_73864_3_ == 0 && 
/* 142 */       this.field_146297_k.field_71474_y.field_74359_p) {
/* 143 */       IChatComponent iChatComponent = this.field_146297_k.field_71456_v.func_146158_b().func_146236_a(Mouse.getX(), Mouse.getY());
/*     */       
/* 145 */       if (iChatComponent != null) {
/* 146 */         ClickEvent clickEvent = iChatComponent.func_150256_b().func_150235_h();
/* 147 */         if (clickEvent != null) {
/* 148 */           if (func_146272_n()) {
/* 149 */             this.field_146415_a.func_146191_b(iChatComponent.func_150261_e());
/*     */           }
/* 151 */           else if (clickEvent.func_150669_a() == ClickEvent.Action.OPEN_URL) {
/*     */             try {
/* 153 */               URI uRI = new URI(clickEvent.func_150668_b());
/*     */               
/* 155 */               if (!field_152175_f.contains(uRI.getScheme().toLowerCase())) {
/* 156 */                 throw new URISyntaxException(clickEvent.func_150668_b(), "Unsupported protocol: " + uRI.getScheme().toLowerCase());
/*     */               }
/*     */               
/* 159 */               if (this.field_146297_k.field_71474_y.field_74358_q) {
/* 160 */                 this.field_146411_u = uRI;
/* 161 */                 this.field_146297_k.func_147108_a(new GuiConfirmOpenLink(this, clickEvent.func_150668_b(), 0, false));
/*     */               } else {
/* 163 */                 func_146407_a(uRI);
/*     */               } 
/* 165 */             } catch (URISyntaxException uRISyntaxException) {
/* 166 */               field_146408_f.error("Can't open url for " + clickEvent, uRISyntaxException);
/*     */             } 
/* 168 */           } else if (clickEvent.func_150669_a() == ClickEvent.Action.OPEN_FILE) {
/* 169 */             URI uRI = (new File(clickEvent.func_150668_b())).toURI();
/* 170 */             func_146407_a(uRI);
/* 171 */           } else if (clickEvent.func_150669_a() == ClickEvent.Action.SUGGEST_COMMAND) {
/* 172 */             this.field_146415_a.func_146180_a(clickEvent.func_150668_b());
/* 173 */           } else if (clickEvent.func_150669_a() == ClickEvent.Action.RUN_COMMAND) {
/* 174 */             func_146403_a(clickEvent.func_150668_b());
/* 175 */           } else if (clickEvent.func_150669_a() == ClickEvent.Action.TWITCH_USER_INFO) {
/* 176 */             ChatUserInfo chatUserInfo = this.field_146297_k.func_152346_Z().func_152926_a(clickEvent.func_150668_b());
/* 177 */             if (chatUserInfo != null) {
/* 178 */               this.field_146297_k.func_147108_a((GuiScreen)new GuiTwitchUserMode(this.field_146297_k.func_152346_Z(), chatUserInfo));
/*     */             } else {
/* 180 */               field_146408_f.error("Tried to handle twitch user but couldn't find them!");
/*     */             } 
/*     */           } else {
/* 183 */             field_146408_f.error("Don't know how to handle " + clickEvent);
/*     */           } 
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 193 */     this.field_146415_a.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
/* 194 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
/* 199 */     if (p_73878_2_ == 0) {
/* 200 */       if (p_73878_1_) {
/* 201 */         func_146407_a(this.field_146411_u);
/*     */       }
/*     */       
/* 204 */       this.field_146411_u = null;
/* 205 */       this.field_146297_k.func_147108_a(this);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_146407_a(URI p_146407_1_) {
/*     */     try {
/* 211 */       Class<?> clazz = Class.forName("java.awt.Desktop");
/* 212 */       Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
/* 213 */       clazz.getMethod("browse", new Class[] { URI.class }).invoke(object, new Object[] { p_146407_1_ });
/* 214 */     } catch (Throwable throwable) {
/* 215 */       field_146408_f.error("Couldn't open link", throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_146404_p_() {
/* 220 */     if (this.field_146417_i) {
/* 221 */       this.field_146415_a.func_146175_b(this.field_146415_a.func_146197_a(-1, this.field_146415_a.func_146198_h(), false) - this.field_146415_a.func_146198_h());
/* 222 */       if (this.field_146413_s >= this.field_146412_t.size()) this.field_146413_s = 0; 
/*     */     } else {
/* 224 */       int i = this.field_146415_a.func_146197_a(-1, this.field_146415_a.func_146198_h(), false);
/*     */       
/* 226 */       this.field_146412_t.clear();
/* 227 */       this.field_146413_s = 0;
/* 228 */       String str1 = this.field_146415_a.func_146179_b().substring(i).toLowerCase();
/* 229 */       String str2 = this.field_146415_a.func_146179_b().substring(0, this.field_146415_a.func_146198_h());
/*     */       
/* 231 */       func_146405_a(str2, str1);
/*     */       
/* 233 */       if (this.field_146412_t.isEmpty())
/*     */         return; 
/* 235 */       this.field_146417_i = true;
/*     */       
/* 237 */       this.field_146415_a.func_146175_b(i - this.field_146415_a.func_146198_h());
/*     */     } 
/*     */     
/* 240 */     if (this.field_146412_t.size() > 1) {
/* 241 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       
/* 243 */       for (String str : this.field_146412_t) {
/* 244 */         if (stringBuilder.length() > 0) stringBuilder.append(", "); 
/* 245 */         stringBuilder.append(str);
/*     */       } 
/*     */       
/* 248 */       this.field_146297_k.field_71456_v.func_146158_b().func_146234_a((IChatComponent)new ChatComponentText(stringBuilder.toString()), 1);
/*     */     } 
/*     */     
/* 251 */     this.field_146415_a.func_146191_b(this.field_146412_t.get(this.field_146413_s++));
/*     */   }
/*     */   
/*     */   private void func_146405_a(String p_146405_1_, String p_146405_2_) {
/* 255 */     if (p_146405_1_.length() < 1)
/*     */       return; 
/* 257 */     this.field_146297_k.field_71439_g.field_71174_a.func_147297_a((Packet)new C14PacketTabComplete(p_146405_1_));
/* 258 */     this.field_146414_r = true;
/*     */   }
/*     */   
/*     */   public void func_146402_a(int p_146402_1_) {
/* 262 */     int i = this.field_146416_h + p_146402_1_;
/* 263 */     int j = this.field_146297_k.field_71456_v.func_146158_b().func_146238_c().size();
/*     */     
/* 265 */     if (i < 0) i = 0; 
/* 266 */     if (i > j) i = j; 
/* 267 */     if (i == this.field_146416_h)
/*     */       return; 
/* 269 */     if (i == j) {
/* 270 */       this.field_146416_h = j;
/* 271 */       this.field_146415_a.func_146180_a(this.field_146410_g); return;
/*     */     } 
/* 273 */     if (this.field_146416_h == j) {
/* 274 */       this.field_146410_g = this.field_146415_a.func_146179_b();
/*     */     }
/*     */     
/* 277 */     this.field_146415_a.func_146180_a(this.field_146297_k.field_71456_v.func_146158_b().func_146238_c().get(i));
/* 278 */     this.field_146416_h = i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 283 */     func_73734_a(2, this.field_146295_m - 14, this.field_146294_l - 2, this.field_146295_m - 2, -2147483648);
/* 284 */     this.field_146415_a.func_146194_f();
/*     */     
/* 286 */     IChatComponent iChatComponent = this.field_146297_k.field_71456_v.func_146158_b().func_146236_a(Mouse.getX(), Mouse.getY());
/* 287 */     if (iChatComponent != null && iChatComponent.func_150256_b().func_150210_i() != null) {
/* 288 */       HoverEvent hoverEvent = iChatComponent.func_150256_b().func_150210_i();
/*     */       
/* 290 */       if (hoverEvent.func_150701_a() == HoverEvent.Action.SHOW_ITEM) {
/* 291 */         ItemStack itemStack = null;
/*     */         
/*     */         try {
/* 294 */           NBTBase nBTBase = JsonToNBT.func_150315_a(hoverEvent.func_150702_b().func_150260_c());
/* 295 */           if (nBTBase != null && nBTBase instanceof NBTTagCompound) {
/* 296 */             itemStack = ItemStack.func_77949_a((NBTTagCompound)nBTBase);
/*     */           }
/* 298 */         } catch (NBTException nBTException) {}
/*     */         
/* 300 */         if (itemStack != null) {
/* 301 */           func_146285_a(itemStack, p_73863_1_, p_73863_2_);
/*     */         } else {
/* 303 */           func_146279_a(EnumChatFormatting.RED + "Invalid Item!", p_73863_1_, p_73863_2_);
/*     */         } 
/* 305 */       } else if (hoverEvent.func_150701_a() == HoverEvent.Action.SHOW_TEXT) {
/* 306 */         func_146283_a(Splitter.on("\n").splitToList(hoverEvent.func_150702_b().func_150254_d()), p_73863_1_, p_73863_2_);
/* 307 */       } else if (hoverEvent.func_150701_a() == HoverEvent.Action.SHOW_ACHIEVEMENT) {
/* 308 */         StatBase statBase = StatList.func_151177_a(hoverEvent.func_150702_b().func_150260_c());
/*     */         
/* 310 */         if (statBase != null) {
/* 311 */           IChatComponent iChatComponent1 = statBase.func_150951_e();
/* 312 */           ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("stats.tooltip.type." + (statBase.func_75967_d() ? "achievement" : "statistic"), new Object[0]);
/* 313 */           chatComponentTranslation.func_150256_b().func_150217_b(Boolean.valueOf(true));
/* 314 */           String str = (statBase instanceof Achievement) ? ((Achievement)statBase).func_75989_e() : null;
/* 315 */           ArrayList arrayList = Lists.newArrayList((Object[])new String[] { iChatComponent1.func_150254_d(), chatComponentTranslation.func_150254_d() });
/* 316 */           if (str != null) arrayList.addAll(this.field_146289_q.func_78271_c(str, 150)); 
/* 317 */           func_146283_a(arrayList, p_73863_1_, p_73863_2_);
/*     */         } else {
/* 319 */           func_146279_a(EnumChatFormatting.RED + "Invalid statistic/achievement!", p_73863_1_, p_73863_2_);
/*     */         } 
/*     */       } 
/*     */       
/* 323 */       GL11.glDisable(2896);
/*     */     } 
/*     */     
/* 326 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */   
/*     */   public void func_146406_a(String[] p_146406_1_) {
/* 330 */     if (this.field_146414_r) {
/* 331 */       this.field_146417_i = false;
/* 332 */       this.field_146412_t.clear();
/*     */       
/* 334 */       for (String str : p_146406_1_) {
/* 335 */         if (str.length() > 0) {
/* 336 */           this.field_146412_t.add(str);
/*     */         }
/*     */       } 
/*     */       
/* 340 */       String str1 = this.field_146415_a.func_146179_b().substring(this.field_146415_a.func_146197_a(-1, this.field_146415_a.func_146198_h(), false));
/* 341 */       String str2 = StringUtils.getCommonPrefix(p_146406_1_);
/*     */       
/* 343 */       if (str2.length() > 0 && !str1.equalsIgnoreCase(str2)) {
/* 344 */         this.field_146415_a.func_146175_b(this.field_146415_a.func_146197_a(-1, this.field_146415_a.func_146198_h(), false) - this.field_146415_a.func_146198_h());
/* 345 */         this.field_146415_a.func_146191_b(str2);
/* 346 */       } else if (this.field_146412_t.size() > 0) {
/* 347 */         this.field_146417_i = true;
/* 348 */         func_146404_p_();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/* 355 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */