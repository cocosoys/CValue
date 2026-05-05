/*     */ package net.minecraft.client.gui;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.nbt.NBTTagString;
/*     */ import net.minecraft.network.play.client.C17PacketCustomPayload;
/*     */ import net.minecraft.util.ChatAllowedCharacters;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiScreenBook extends GuiScreen {
/*  24 */   private static final Logger field_146473_a = LogManager.getLogger();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   private static final ResourceLocation field_146466_f = new ResourceLocation("textures/gui/book.png");
/*     */   
/*     */   private final EntityPlayer field_146468_g;
/*     */   
/*     */   private final ItemStack field_146474_h;
/*     */   
/*     */   private final boolean field_146475_i;
/*     */   private boolean field_146481_r;
/*     */   private boolean field_146480_s;
/*     */   private int field_146479_t;
/*  45 */   private int field_146478_u = 192;
/*  46 */   private int field_146477_v = 192;
/*     */   
/*  48 */   private int field_146476_w = 1;
/*     */   private int field_146484_x;
/*     */   private NBTTagList field_146483_y;
/*  51 */   private String field_146482_z = "";
/*     */   
/*     */   private NextPageButton field_146470_A;
/*     */   private NextPageButton field_146471_B;
/*     */   private GuiButton field_146472_C;
/*     */   private GuiButton field_146465_D;
/*     */   private GuiButton field_146467_E;
/*     */   private GuiButton field_146469_F;
/*     */   private static final String __OBFID = "CL_00000744";
/*     */   
/*     */   public GuiScreenBook(EntityPlayer p_i1080_1_, ItemStack p_i1080_2_, boolean p_i1080_3_) {
/*  62 */     this.field_146468_g = p_i1080_1_;
/*  63 */     this.field_146474_h = p_i1080_2_;
/*  64 */     this.field_146475_i = p_i1080_3_;
/*     */     
/*  66 */     if (p_i1080_2_.func_77942_o()) {
/*  67 */       NBTTagCompound nBTTagCompound = p_i1080_2_.func_77978_p();
/*  68 */       this.field_146483_y = nBTTagCompound.func_150295_c("pages", 8);
/*  69 */       if (this.field_146483_y != null) {
/*  70 */         this.field_146483_y = (NBTTagList)this.field_146483_y.func_74737_b();
/*  71 */         this.field_146476_w = this.field_146483_y.func_74745_c();
/*  72 */         if (this.field_146476_w < 1) {
/*  73 */           this.field_146476_w = 1;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  78 */     if (this.field_146483_y == null && p_i1080_3_) {
/*  79 */       this.field_146483_y = new NBTTagList();
/*  80 */       this.field_146483_y.func_74742_a((NBTBase)new NBTTagString(""));
/*     */       
/*  82 */       this.field_146476_w = 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  88 */     super.func_73876_c();
/*  89 */     this.field_146479_t++;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  94 */     this.field_146292_n.clear();
/*  95 */     Keyboard.enableRepeatEvents(true);
/*     */     
/*  97 */     if (this.field_146475_i) {
/*  98 */       this.field_146292_n.add(this.field_146465_D = new GuiButton(3, this.field_146294_l / 2 - 100, 4 + this.field_146477_v, 98, 20, I18n.func_135052_a("book.signButton", new Object[0])));
/*  99 */       this.field_146292_n.add(this.field_146472_C = new GuiButton(0, this.field_146294_l / 2 + 2, 4 + this.field_146477_v, 98, 20, I18n.func_135052_a("gui.done", new Object[0])));
/*     */       
/* 101 */       this.field_146292_n.add(this.field_146467_E = new GuiButton(5, this.field_146294_l / 2 - 100, 4 + this.field_146477_v, 98, 20, I18n.func_135052_a("book.finalizeButton", new Object[0])));
/* 102 */       this.field_146292_n.add(this.field_146469_F = new GuiButton(4, this.field_146294_l / 2 + 2, 4 + this.field_146477_v, 98, 20, I18n.func_135052_a("gui.cancel", new Object[0])));
/*     */     } else {
/* 104 */       this.field_146292_n.add(this.field_146472_C = new GuiButton(0, this.field_146294_l / 2 - 100, 4 + this.field_146477_v, 200, 20, I18n.func_135052_a("gui.done", new Object[0])));
/*     */     } 
/*     */     
/* 107 */     int i = (this.field_146294_l - this.field_146478_u) / 2;
/* 108 */     byte b = 2;
/*     */     
/* 110 */     this.field_146292_n.add(this.field_146470_A = new NextPageButton(1, i + 120, b + 154, true));
/* 111 */     this.field_146292_n.add(this.field_146471_B = new NextPageButton(2, i + 38, b + 154, false));
/*     */     
/* 113 */     func_146464_h();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/* 118 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */   
/*     */   private void func_146464_h() {
/* 122 */     this.field_146470_A.field_146125_m = (!this.field_146480_s && (this.field_146484_x < this.field_146476_w - 1 || this.field_146475_i));
/* 123 */     this.field_146471_B.field_146125_m = (!this.field_146480_s && this.field_146484_x > 0);
/*     */     
/* 125 */     this.field_146472_C.field_146125_m = (!this.field_146475_i || !this.field_146480_s);
/* 126 */     if (this.field_146475_i) {
/* 127 */       this.field_146465_D.field_146125_m = !this.field_146480_s;
/* 128 */       this.field_146469_F.field_146125_m = this.field_146480_s;
/* 129 */       this.field_146467_E.field_146125_m = this.field_146480_s;
/* 130 */       this.field_146467_E.field_146124_l = (this.field_146482_z.trim().length() > 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_146462_a(boolean p_146462_1_) {
/* 136 */     if (!this.field_146475_i || !this.field_146481_r) {
/*     */       return;
/*     */     }
/*     */     
/* 140 */     if (this.field_146483_y != null) {
/*     */ 
/*     */       
/* 143 */       while (this.field_146483_y.func_74745_c() > 1) {
/* 144 */         String str1 = this.field_146483_y.func_150307_f(this.field_146483_y.func_74745_c() - 1);
/* 145 */         if (str1.length() == 0) {
/* 146 */           this.field_146483_y.func_74744_a(this.field_146483_y.func_74745_c() - 1);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 153 */       if (this.field_146474_h.func_77942_o()) {
/* 154 */         NBTTagCompound nBTTagCompound = this.field_146474_h.func_77978_p();
/* 155 */         nBTTagCompound.func_74782_a("pages", (NBTBase)this.field_146483_y);
/*     */       } else {
/* 157 */         this.field_146474_h.func_77983_a("pages", (NBTBase)this.field_146483_y);
/*     */       } 
/*     */       
/* 160 */       String str = "MC|BEdit";
/* 161 */       if (p_146462_1_) {
/* 162 */         str = "MC|BSign";
/* 163 */         this.field_146474_h.func_77983_a("author", (NBTBase)new NBTTagString(this.field_146468_g.func_70005_c_()));
/* 164 */         this.field_146474_h.func_77983_a("title", (NBTBase)new NBTTagString(this.field_146482_z.trim()));
/*     */ 
/*     */         
/* 167 */         this.field_146474_h.func_150996_a(Items.field_151164_bB);
/*     */       } 
/*     */       
/* 170 */       ByteBuf byteBuf = Unpooled.buffer();
/*     */       
/*     */       try {
/* 173 */         (new PacketBuffer(byteBuf)).func_150788_a(this.field_146474_h);
/* 174 */         this.field_146297_k.func_147114_u().func_147297_a((Packet)new C17PacketCustomPayload(str, byteBuf));
/* 175 */       } catch (Exception exception) {
/* 176 */         field_146473_a.error("Couldn't send book info", exception);
/*     */       } finally {
/* 178 */         byteBuf.release();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 185 */     if (!p_146284_1_.field_146124_l)
/*     */       return; 
/* 187 */     if (p_146284_1_.field_146127_k == 0) {
/* 188 */       this.field_146297_k.func_147108_a(null);
/* 189 */       func_146462_a(false);
/*     */     }
/* 191 */     else if (p_146284_1_.field_146127_k == 3 && this.field_146475_i) {
/* 192 */       this.field_146480_s = true;
/* 193 */     } else if (p_146284_1_.field_146127_k == 1) {
/* 194 */       if (this.field_146484_x < this.field_146476_w - 1) {
/* 195 */         this.field_146484_x++;
/* 196 */       } else if (this.field_146475_i) {
/* 197 */         func_146461_i();
/*     */         
/* 199 */         if (this.field_146484_x < this.field_146476_w - 1) {
/* 200 */           this.field_146484_x++;
/*     */         }
/*     */       } 
/* 203 */     } else if (p_146284_1_.field_146127_k == 2) {
/* 204 */       if (this.field_146484_x > 0) {
/* 205 */         this.field_146484_x--;
/*     */       }
/* 207 */     } else if (p_146284_1_.field_146127_k == 5 && this.field_146480_s) {
/* 208 */       func_146462_a(true);
/* 209 */       this.field_146297_k.func_147108_a(null);
/* 210 */     } else if (p_146284_1_.field_146127_k == 4 && this.field_146480_s) {
/* 211 */       this.field_146480_s = false;
/*     */     } 
/* 213 */     func_146464_h();
/*     */   }
/*     */   
/*     */   private void func_146461_i() {
/* 217 */     if (this.field_146483_y == null || this.field_146483_y.func_74745_c() >= 50) {
/*     */       return;
/*     */     }
/* 220 */     this.field_146483_y.func_74742_a((NBTBase)new NBTTagString(""));
/* 221 */     this.field_146476_w++;
/*     */     
/* 223 */     this.field_146481_r = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/* 228 */     super.func_73869_a(p_73869_1_, p_73869_2_);
/*     */     
/* 230 */     if (!this.field_146475_i) {
/*     */       return;
/*     */     }
/*     */     
/* 234 */     if (this.field_146480_s) {
/* 235 */       func_146460_c(p_73869_1_, p_73869_2_);
/*     */     } else {
/* 237 */       func_146463_b(p_73869_1_, p_73869_2_);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_146463_b(char p_146463_1_, int p_146463_2_) {
/*     */     String str;
/* 243 */     switch (p_146463_1_) {
/*     */       case '\026':
/* 245 */         func_146459_b(GuiScreen.func_146277_j());
/*     */         return;
/*     */     } 
/*     */     
/* 249 */     switch (p_146463_2_) {
/*     */       case 14:
/* 251 */         str = func_146456_p();
/* 252 */         if (str.length() > 0) {
/* 253 */           func_146457_a(str.substring(0, str.length() - 1));
/*     */         }
/*     */         return;
/*     */       case 28:
/*     */       case 156:
/* 258 */         func_146459_b("\n");
/*     */         return;
/*     */     } 
/*     */     
/* 262 */     if (ChatAllowedCharacters.func_71566_a(p_146463_1_)) {
/* 263 */       func_146459_b(Character.toString(p_146463_1_));
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_146460_c(char p_146460_1_, int p_146460_2_) {
/* 270 */     switch (p_146460_2_) {
/*     */       case 14:
/* 272 */         if (!this.field_146482_z.isEmpty()) {
/* 273 */           this.field_146482_z = this.field_146482_z.substring(0, this.field_146482_z.length() - 1);
/* 274 */           func_146464_h();
/*     */         } 
/*     */         return;
/*     */       case 28:
/*     */       case 156:
/* 279 */         if (!this.field_146482_z.isEmpty()) {
/* 280 */           func_146462_a(true);
/* 281 */           this.field_146297_k.func_147108_a(null);
/*     */         } 
/*     */         return;
/*     */     } 
/*     */     
/* 286 */     if (this.field_146482_z.length() < 16 && ChatAllowedCharacters.func_71566_a(p_146460_1_)) {
/* 287 */       this.field_146482_z += Character.toString(p_146460_1_);
/* 288 */       func_146464_h();
/* 289 */       this.field_146481_r = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   private String func_146456_p() {
/* 294 */     if (this.field_146483_y != null && this.field_146484_x >= 0 && this.field_146484_x < this.field_146483_y.func_74745_c()) {
/* 295 */       return this.field_146483_y.func_150307_f(this.field_146484_x);
/*     */     }
/* 297 */     return "";
/*     */   }
/*     */   
/*     */   private void func_146457_a(String p_146457_1_) {
/* 301 */     if (this.field_146483_y != null && this.field_146484_x >= 0 && this.field_146484_x < this.field_146483_y.func_74745_c()) {
/* 302 */       this.field_146483_y.func_150304_a(this.field_146484_x, (NBTBase)new NBTTagString(p_146457_1_));
/*     */       
/* 304 */       this.field_146481_r = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void func_146459_b(String p_146459_1_) {
/* 311 */     String str1 = func_146456_p();
/* 312 */     String str2 = str1 + p_146459_1_;
/*     */     
/* 314 */     int i = this.field_146289_q.func_78267_b(str2 + "" + EnumChatFormatting.BLACK + "_", 118);
/* 315 */     if (i <= 118 && str2.length() < 256) {
/* 316 */       func_146457_a(str2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 322 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 323 */     this.field_146297_k.func_110434_K().func_110577_a(field_146466_f);
/* 324 */     int i = (this.field_146294_l - this.field_146478_u) / 2;
/* 325 */     byte b = 2;
/* 326 */     func_73729_b(i, b, 0, 0, this.field_146478_u, this.field_146477_v);
/*     */     
/* 328 */     if (this.field_146480_s) {
/* 329 */       String str1 = this.field_146482_z;
/*     */       
/* 331 */       if (this.field_146475_i) {
/* 332 */         if (this.field_146479_t / 6 % 2 == 0) {
/* 333 */           str1 = str1 + "" + EnumChatFormatting.BLACK + "_";
/*     */         } else {
/* 335 */           str1 = str1 + "" + EnumChatFormatting.GRAY + "_";
/*     */         } 
/*     */       }
/*     */       
/* 339 */       String str2 = I18n.func_135052_a("book.editTitle", new Object[0]);
/* 340 */       int j = this.field_146289_q.func_78256_a(str2);
/* 341 */       this.field_146289_q.func_78276_b(str2, i + 36 + (116 - j) / 2, b + 16 + 16, 0);
/*     */       
/* 343 */       int k = this.field_146289_q.func_78256_a(str1);
/* 344 */       this.field_146289_q.func_78276_b(str1, i + 36 + (116 - k) / 2, b + 48, 0);
/* 345 */       String str3 = I18n.func_135052_a("book.byAuthor", new Object[] { this.field_146468_g.func_70005_c_() });
/* 346 */       int m = this.field_146289_q.func_78256_a(str3);
/* 347 */       this.field_146289_q.func_78276_b(EnumChatFormatting.DARK_GRAY + str3, i + 36 + (116 - m) / 2, b + 48 + 10, 0);
/*     */       
/* 349 */       String str4 = I18n.func_135052_a("book.finalizeWarning", new Object[0]);
/* 350 */       this.field_146289_q.func_78279_b(str4, i + 36, b + 80, 116, 0);
/*     */     } else {
/* 352 */       String str1 = I18n.func_135052_a("book.pageIndicator", new Object[] { Integer.valueOf(this.field_146484_x + 1), Integer.valueOf(this.field_146476_w) });
/* 353 */       String str2 = "";
/*     */       
/* 355 */       if (this.field_146483_y != null && this.field_146484_x >= 0 && this.field_146484_x < this.field_146483_y.func_74745_c()) {
/* 356 */         str2 = this.field_146483_y.func_150307_f(this.field_146484_x);
/*     */       }
/*     */       
/* 359 */       if (this.field_146475_i) {
/* 360 */         if (this.field_146289_q.func_78260_a()) {
/* 361 */           str2 = str2 + "_";
/*     */         }
/* 363 */         else if (this.field_146479_t / 6 % 2 == 0) {
/* 364 */           str2 = str2 + "" + EnumChatFormatting.BLACK + "_";
/*     */         } else {
/* 366 */           str2 = str2 + "" + EnumChatFormatting.GRAY + "_";
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 371 */       int j = this.field_146289_q.func_78256_a(str1);
/* 372 */       this.field_146289_q.func_78276_b(str1, i - j + this.field_146478_u - 44, b + 16, 0);
/* 373 */       this.field_146289_q.func_78279_b(str2, i + 36, b + 16 + 16, 116, 0);
/*     */     } 
/*     */     
/* 376 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   static class NextPageButton extends GuiButton { private final boolean field_146151_o;
/*     */     private static final String __OBFID = "CL_00000745";
/*     */     
/*     */     public NextPageButton(int p_i1079_1_, int p_i1079_2_, int p_i1079_3_, boolean p_i1079_4_) {
/* 384 */       super(p_i1079_1_, p_i1079_2_, p_i1079_3_, 23, 13, "");
/* 385 */       this.field_146151_o = p_i1079_4_;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_146112_a(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_) {
/* 390 */       if (!this.field_146125_m)
/* 391 */         return;  boolean bool1 = (p_146112_2_ >= this.field_146128_h && p_146112_3_ >= this.field_146129_i && p_146112_2_ < this.field_146128_h + this.field_146120_f && p_146112_3_ < this.field_146129_i + this.field_146121_g) ? true : false;
/*     */       
/* 393 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 394 */       p_146112_1_.func_110434_K().func_110577_a(GuiScreenBook.field_146466_f);
/*     */       
/* 396 */       boolean bool2 = false;
/* 397 */       char c = 'À';
/* 398 */       if (bool1) {
/* 399 */         bool2 += true;
/*     */       }
/* 401 */       if (!this.field_146151_o) {
/* 402 */         c += '\r';
/*     */       }
/*     */       
/* 405 */       func_73729_b(this.field_146128_h, this.field_146129_i, bool2, c, 23, 13);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiScreenBook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */