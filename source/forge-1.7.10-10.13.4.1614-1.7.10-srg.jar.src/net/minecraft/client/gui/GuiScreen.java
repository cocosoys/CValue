/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.datatransfer.DataFlavor;
/*     */ import java.awt.datatransfer.StringSelection;
/*     */ import java.awt.datatransfer.Transferable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiScreen
/*     */   extends Gui
/*     */ {
/*  27 */   protected static RenderItem field_146296_j = new RenderItem();
/*     */   public Minecraft field_146297_k;
/*     */   public int field_146294_l;
/*     */   public int field_146295_m;
/*  31 */   protected List field_146292_n = new ArrayList();
/*  32 */   protected List field_146293_o = new ArrayList();
/*     */   
/*     */   public boolean field_146291_p;
/*     */   
/*     */   protected FontRenderer field_146289_q;
/*     */   private GuiButton field_146290_a;
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/*     */     byte b;
/*  41 */     for (b = 0; b < this.field_146292_n.size(); b++) {
/*  42 */       ((GuiButton)this.field_146292_n.get(b)).func_146112_a(this.field_146297_k, p_73863_1_, p_73863_2_);
/*     */     }
/*  44 */     for (b = 0; b < this.field_146293_o.size(); b++)
/*  45 */       ((GuiLabel)this.field_146293_o.get(b)).func_146159_a(this.field_146297_k, p_73863_1_, p_73863_2_); 
/*     */   }
/*     */   private int field_146287_f; private long field_146288_g; private int field_146298_h; private static final String __OBFID = "CL_00000710";
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/*  50 */     if (p_73869_2_ == 1) {
/*  51 */       this.field_146297_k.func_147108_a(null);
/*  52 */       this.field_146297_k.func_71381_h();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String func_146277_j() {
/*     */     try {
/*  58 */       Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
/*  59 */       if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
/*  60 */         return (String)transferable.getTransferData(DataFlavor.stringFlavor);
/*     */       }
/*  62 */     } catch (Exception exception) {}
/*     */     
/*  64 */     return "";
/*     */   }
/*     */   
/*     */   public static void func_146275_d(String p_146275_0_) {
/*     */     try {
/*  69 */       StringSelection stringSelection = new StringSelection(p_146275_0_);
/*  70 */       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
/*  71 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146285_a(ItemStack p_146285_1_, int p_146285_2_, int p_146285_3_) {
/*  76 */     List<String> list = p_146285_1_.func_82840_a((EntityPlayer)this.field_146297_k.field_71439_g, this.field_146297_k.field_71474_y.field_82882_x);
/*     */     
/*  78 */     for (byte b = 0; b < list.size(); b++) {
/*  79 */       if (b == 0) {
/*  80 */         list.set(b, (p_146285_1_.func_77953_t()).field_77937_e + (String)list.get(b));
/*     */       } else {
/*  82 */         list.set(b, EnumChatFormatting.GRAY + (String)list.get(b));
/*     */       } 
/*     */     } 
/*     */     
/*  86 */     func_146283_a(list, p_146285_2_, p_146285_3_);
/*     */   }
/*     */   
/*     */   protected void func_146279_a(String p_146279_1_, int p_146279_2_, int p_146279_3_) {
/*  90 */     func_146283_a(Arrays.asList(new String[] { p_146279_1_ }, ), p_146279_2_, p_146279_3_);
/*     */   }
/*     */   
/*     */   protected void func_146283_a(List<String> p_146283_1_, int p_146283_2_, int p_146283_3_) {
/*  94 */     if (p_146283_1_.isEmpty())
/*     */       return; 
/*  96 */     GL11.glDisable(32826);
/*  97 */     RenderHelper.func_74518_a();
/*  98 */     GL11.glDisable(2896);
/*  99 */     GL11.glDisable(2929);
/*     */     
/* 101 */     int i = 0;
/* 102 */     for (String str : p_146283_1_) {
/* 103 */       int i4 = this.field_146289_q.func_78256_a(str);
/* 104 */       if (i4 > i) i = i4;
/*     */     
/*     */     } 
/* 107 */     int j = p_146283_2_ + 12;
/* 108 */     int k = p_146283_3_ - 12;
/*     */     
/* 110 */     int m = i;
/* 111 */     int n = 8;
/*     */     
/* 113 */     if (p_146283_1_.size() > 1) {
/* 114 */       n += 2 + (p_146283_1_.size() - 1) * 10;
/*     */     }
/*     */ 
/*     */     
/* 118 */     if (j + i > this.field_146294_l) {
/* 119 */       j -= 28 + i;
/*     */     }
/*     */ 
/*     */     
/* 123 */     if (k + n + 6 > this.field_146295_m) {
/* 124 */       k = this.field_146295_m - n - 6;
/*     */     }
/*     */     
/* 127 */     this.field_73735_i = 300.0F;
/* 128 */     field_146296_j.field_77023_b = 300.0F;
/*     */     
/* 130 */     int i1 = -267386864;
/* 131 */     func_73733_a(j - 3, k - 4, j + m + 3, k - 3, i1, i1);
/* 132 */     func_73733_a(j - 3, k + n + 3, j + m + 3, k + n + 4, i1, i1);
/*     */     
/* 134 */     func_73733_a(j - 3, k - 3, j + m + 3, k + n + 3, i1, i1);
/* 135 */     func_73733_a(j - 4, k - 3, j - 3, k + n + 3, i1, i1);
/* 136 */     func_73733_a(j + m + 3, k - 3, j + m + 4, k + n + 3, i1, i1);
/*     */     
/* 138 */     int i2 = 1347420415;
/* 139 */     int i3 = (i2 & 0xFEFEFE) >> 1 | i2 & 0xFF000000;
/*     */     
/* 141 */     func_73733_a(j - 3, k - 3 + 1, j - 3 + 1, k + n + 3 - 1, i2, i3);
/* 142 */     func_73733_a(j + m + 2, k - 3 + 1, j + m + 3, k + n + 3 - 1, i2, i3);
/*     */     
/* 144 */     func_73733_a(j - 3, k - 3, j + m + 3, k - 3 + 1, i2, i2);
/* 145 */     func_73733_a(j - 3, k + n + 2, j + m + 3, k + n + 3, i3, i3);
/*     */     
/* 147 */     for (byte b = 0; b < p_146283_1_.size(); b++) {
/* 148 */       String str = p_146283_1_.get(b);
/*     */       
/* 150 */       this.field_146289_q.func_78261_a(str, j, k, -1);
/*     */       
/* 152 */       if (b == 0) k += 2; 
/* 153 */       k += 10;
/*     */     } 
/*     */     
/* 156 */     this.field_73735_i = 0.0F;
/* 157 */     field_146296_j.field_77023_b = 0.0F;
/*     */     
/* 159 */     GL11.glEnable(2896);
/* 160 */     GL11.glEnable(2929);
/* 161 */     RenderHelper.func_74519_b();
/* 162 */     GL11.glEnable(32826);
/*     */   }
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 166 */     if (p_73864_3_ == 0) {
/* 167 */       for (byte b = 0; b < this.field_146292_n.size(); b++) {
/* 168 */         GuiButton guiButton = this.field_146292_n.get(b);
/* 169 */         if (guiButton.func_146116_c(this.field_146297_k, p_73864_1_, p_73864_2_)) {
/* 170 */           this.field_146290_a = guiButton;
/* 171 */           guiButton.func_146113_a(this.field_146297_k.func_147118_V());
/* 172 */           func_146284_a(guiButton);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   protected void func_146286_b(int p_146286_1_, int p_146286_2_, int p_146286_3_) {
/* 179 */     if (this.field_146290_a != null && p_146286_3_ == 0) {
/* 180 */       this.field_146290_a.func_146118_a(p_146286_1_, p_146286_2_);
/* 181 */       this.field_146290_a = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146273_a(int p_146273_1_, int p_146273_2_, int p_146273_3_, long p_146273_4_) {}
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {}
/*     */   
/*     */   public void func_146280_a(Minecraft p_146280_1_, int p_146280_2_, int p_146280_3_) {
/* 192 */     this.field_146297_k = p_146280_1_;
/* 193 */     this.field_146289_q = p_146280_1_.field_71466_p;
/* 194 */     this.field_146294_l = p_146280_2_;
/* 195 */     this.field_146295_m = p_146280_3_;
/* 196 */     this.field_146292_n.clear();
/* 197 */     func_73866_w_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146269_k() {
/* 209 */     if (Mouse.isCreated()) {
/* 210 */       while (Mouse.next()) {
/* 211 */         func_146274_d();
/*     */       }
/*     */     }
/*     */     
/* 215 */     if (Keyboard.isCreated()) {
/* 216 */       while (Keyboard.next()) {
/* 217 */         func_146282_l();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_146274_d() {
/* 223 */     int i = Mouse.getEventX() * this.field_146294_l / this.field_146297_k.field_71443_c;
/* 224 */     int j = this.field_146295_m - Mouse.getEventY() * this.field_146295_m / this.field_146297_k.field_71440_d - 1;
/*     */     
/* 226 */     int k = Mouse.getEventButton();
/*     */     
/* 228 */     if (Mouse.getEventButtonState()) {
/* 229 */       if (this.field_146297_k.field_71474_y.field_85185_A && this.field_146298_h++ > 0)
/* 230 */         return;  this.field_146287_f = k;
/* 231 */       this.field_146288_g = Minecraft.func_71386_F();
/* 232 */       func_73864_a(i, j, this.field_146287_f);
/* 233 */     } else if (k != -1) {
/* 234 */       if (this.field_146297_k.field_71474_y.field_85185_A && --this.field_146298_h > 0)
/* 235 */         return;  this.field_146287_f = -1;
/* 236 */       func_146286_b(i, j, k);
/* 237 */     } else if (this.field_146287_f != -1 && this.field_146288_g > 0L) {
/* 238 */       long l = Minecraft.func_71386_F() - this.field_146288_g;
/* 239 */       func_146273_a(i, j, this.field_146287_f, l);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_146282_l() {
/* 244 */     if (Keyboard.getEventKeyState()) {
/* 245 */       func_73869_a(Keyboard.getEventCharacter(), Keyboard.getEventKey());
/*     */     }
/*     */     
/* 248 */     this.field_146297_k.func_152348_aa();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {}
/*     */ 
/*     */   
/*     */   public void func_146281_b() {}
/*     */   
/*     */   public void func_146276_q_() {
/* 258 */     func_146270_b(0);
/*     */   }
/*     */   
/*     */   public void func_146270_b(int p_146270_1_) {
/* 262 */     if (this.field_146297_k.field_71441_e != null) {
/* 263 */       func_73733_a(0, 0, this.field_146294_l, this.field_146295_m, -1072689136, -804253680);
/*     */     } else {
/* 265 */       func_146278_c(p_146270_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_146278_c(int p_146278_1_) {
/* 270 */     GL11.glDisable(2896);
/* 271 */     GL11.glDisable(2912);
/* 272 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 273 */     this.field_146297_k.func_110434_K().func_110577_a(field_110325_k);
/* 274 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 275 */     float f = 32.0F;
/* 276 */     tessellator.func_78382_b();
/* 277 */     tessellator.func_78378_d(4210752);
/* 278 */     tessellator.func_78374_a(0.0D, this.field_146295_m, 0.0D, 0.0D, (this.field_146295_m / f + p_146278_1_));
/* 279 */     tessellator.func_78374_a(this.field_146294_l, this.field_146295_m, 0.0D, (this.field_146294_l / f), (this.field_146295_m / f + p_146278_1_));
/* 280 */     tessellator.func_78374_a(this.field_146294_l, 0.0D, 0.0D, (this.field_146294_l / f), p_146278_1_);
/* 281 */     tessellator.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, p_146278_1_);
/* 282 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   public boolean func_73868_f() {
/* 286 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {}
/*     */   
/*     */   public static boolean func_146271_m() {
/* 293 */     if (Minecraft.field_142025_a) {
/* 294 */       return (Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220));
/*     */     }
/*     */     
/* 297 */     return (Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157));
/*     */   }
/*     */   
/*     */   public static boolean func_146272_n() {
/* 301 */     return (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */