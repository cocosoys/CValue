/*     */ package net.minecraft.client.gui.inventory;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.play.client.C17PacketCustomPayload;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.tileentity.TileEntityBeacon;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiBeacon extends GuiContainer {
/*  23 */   private static final Logger field_147026_u = LogManager.getLogger();
/*     */ 
/*     */   
/*  26 */   private static final ResourceLocation field_147025_v = new ResourceLocation("textures/gui/container/beacon.png");
/*     */   
/*     */   private TileEntityBeacon field_147024_w;
/*     */   private ConfirmButton field_147028_x;
/*     */   private boolean field_147027_y;
/*     */   private static final String __OBFID = "CL_00000739";
/*     */   
/*     */   public GuiBeacon(InventoryPlayer p_i1078_1_, TileEntityBeacon p_i1078_2_) {
/*  34 */     super((Container)new ContainerBeacon(p_i1078_1_, p_i1078_2_));
/*  35 */     this.field_147024_w = p_i1078_2_;
/*     */     
/*  37 */     this.field_146999_f = 230;
/*  38 */     this.field_147000_g = 219;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  43 */     super.func_73866_w_();
/*     */     
/*  45 */     this.field_146292_n.add(this.field_147028_x = new ConfirmButton(this, -1, this.field_147003_i + 164, this.field_147009_r + 107));
/*  46 */     this.field_146292_n.add(new CancelButton(this, -2, this.field_147003_i + 190, this.field_147009_r + 107));
/*     */     
/*  48 */     this.field_147027_y = true;
/*     */     
/*  50 */     this.field_147028_x.field_146124_l = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  55 */     super.func_73876_c();
/*     */     
/*  57 */     if (this.field_147027_y && this.field_147024_w.func_145998_l() >= 0) {
/*  58 */       this.field_147027_y = false;
/*     */       byte b1;
/*  60 */       for (b1 = 0; b1 <= 2; b1++) {
/*  61 */         int k = (TileEntityBeacon.field_146009_a[b1]).length;
/*  62 */         int m = k * 22 + (k - 1) * 2;
/*     */         
/*  64 */         for (byte b = 0; b < k; b++) {
/*  65 */           int n = (TileEntityBeacon.field_146009_a[b1][b]).field_76415_H;
/*  66 */           PowerButton powerButton = new PowerButton(this, b1 << 8 | n, this.field_147003_i + 76 + b * 24 - m / 2, this.field_147009_r + 22 + b1 * 25, n, b1);
/*  67 */           this.field_146292_n.add(powerButton);
/*     */           
/*  69 */           if (b1 >= this.field_147024_w.func_145998_l()) {
/*  70 */             powerButton.field_146124_l = false;
/*  71 */           } else if (n == this.field_147024_w.func_146007_j()) {
/*  72 */             powerButton.func_146140_b(true);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  77 */       b1 = 3;
/*     */       
/*  79 */       int i = (TileEntityBeacon.field_146009_a[b1]).length + 1;
/*  80 */       int j = i * 22 + (i - 1) * 2;
/*     */       
/*  82 */       for (byte b2 = 0; b2 < i - 1; b2++) {
/*  83 */         int k = (TileEntityBeacon.field_146009_a[b1][b2]).field_76415_H;
/*  84 */         PowerButton powerButton = new PowerButton(this, b1 << 8 | k, this.field_147003_i + 167 + b2 * 24 - j / 2, this.field_147009_r + 47, k, b1);
/*  85 */         this.field_146292_n.add(powerButton);
/*     */         
/*  87 */         if (b1 >= this.field_147024_w.func_145998_l()) {
/*  88 */           powerButton.field_146124_l = false;
/*  89 */         } else if (k == this.field_147024_w.func_146006_k()) {
/*  90 */           powerButton.func_146140_b(true);
/*     */         } 
/*     */       } 
/*  93 */       if (this.field_147024_w.func_146007_j() > 0) {
/*  94 */         PowerButton powerButton = new PowerButton(this, b1 << 8 | this.field_147024_w.func_146007_j(), this.field_147003_i + 167 + (i - 1) * 24 - j / 2, this.field_147009_r + 47, this.field_147024_w.func_146007_j(), b1);
/*     */         
/*  96 */         this.field_146292_n.add(powerButton);
/*     */         
/*  98 */         if (b1 >= this.field_147024_w.func_145998_l()) {
/*  99 */           powerButton.field_146124_l = false;
/* 100 */         } else if (this.field_147024_w.func_146007_j() == this.field_147024_w.func_146006_k()) {
/* 101 */           powerButton.func_146140_b(true);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 106 */     this.field_147028_x.field_146124_l = (this.field_147024_w.func_70301_a(0) != null && this.field_147024_w.func_146007_j() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 111 */     if (p_146284_1_.field_146127_k == -2) {
/* 112 */       this.field_146297_k.func_147108_a(null);
/* 113 */     } else if (p_146284_1_.field_146127_k == -1) {
/* 114 */       String str = "MC|Beacon";
/*     */       
/* 116 */       ByteBuf byteBuf = Unpooled.buffer();
/*     */       
/*     */       try {
/* 119 */         byteBuf.writeInt(this.field_147024_w.func_146007_j());
/* 120 */         byteBuf.writeInt(this.field_147024_w.func_146006_k());
/* 121 */         this.field_146297_k.func_147114_u().func_147297_a((Packet)new C17PacketCustomPayload(str, byteBuf));
/* 122 */       } catch (Exception exception) {
/* 123 */         field_147026_u.error("Couldn't send beacon info", exception);
/*     */       } finally {
/* 125 */         byteBuf.release();
/*     */       } 
/* 127 */       this.field_146297_k.func_147108_a(null);
/*     */     }
/* 129 */     else if (p_146284_1_ instanceof PowerButton) {
/* 130 */       if (((PowerButton)p_146284_1_).func_146141_c())
/* 131 */         return;  int i = p_146284_1_.field_146127_k;
/* 132 */       int j = i & 0xFF;
/* 133 */       int k = i >> 8;
/*     */       
/* 135 */       if (k < 3) {
/* 136 */         this.field_147024_w.func_146001_d(j);
/*     */       } else {
/* 138 */         this.field_147024_w.func_146004_e(j);
/*     */       } 
/*     */       
/* 141 */       this.field_146292_n.clear();
/* 142 */       func_73866_w_();
/* 143 */       func_73876_c();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
/* 149 */     RenderHelper.func_74518_a();
/* 150 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("tile.beacon.primary", new Object[0]), 62, 10, 14737632);
/* 151 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("tile.beacon.secondary", new Object[0]), 169, 10, 14737632);
/*     */     
/* 153 */     for (GuiButton guiButton : this.field_146292_n) {
/* 154 */       if (guiButton.func_146115_a()) {
/* 155 */         guiButton.func_146111_b(p_146979_1_ - this.field_147003_i, p_146979_2_ - this.field_147009_r);
/*     */         break;
/*     */       } 
/*     */     } 
/* 159 */     RenderHelper.func_74520_c();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
/* 164 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 165 */     this.field_146297_k.func_110434_K().func_110577_a(field_147025_v);
/* 166 */     int i = (this.field_146294_l - this.field_146999_f) / 2;
/* 167 */     int j = (this.field_146295_m - this.field_147000_g) / 2;
/* 168 */     func_73729_b(i, j, 0, 0, this.field_146999_f, this.field_147000_g);
/*     */     
/* 170 */     field_146296_j.field_77023_b = 100.0F;
/* 171 */     field_146296_j.func_82406_b(this.field_146289_q, this.field_146297_k.func_110434_K(), new ItemStack(Items.field_151166_bC), i + 42, j + 109);
/* 172 */     field_146296_j.func_82406_b(this.field_146289_q, this.field_146297_k.func_110434_K(), new ItemStack(Items.field_151045_i), i + 42 + 22, j + 109);
/* 173 */     field_146296_j.func_82406_b(this.field_146289_q, this.field_146297_k.func_110434_K(), new ItemStack(Items.field_151043_k), i + 42 + 44, j + 109);
/* 174 */     field_146296_j.func_82406_b(this.field_146289_q, this.field_146297_k.func_110434_K(), new ItemStack(Items.field_151042_j), i + 42 + 66, j + 109);
/* 175 */     field_146296_j.field_77023_b = 0.0F;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   static class Button extends GuiButton { private final ResourceLocation field_146145_o;
/*     */     private final int field_146144_p;
/*     */     private final int field_146143_q;
/*     */     private boolean field_146142_r;
/*     */     private static final String __OBFID = "CL_00000743";
/*     */     
/*     */     protected Button(int p_i1077_1_, int p_i1077_2_, int p_i1077_3_, ResourceLocation p_i1077_4_, int p_i1077_5_, int p_i1077_6_) {
/* 185 */       super(p_i1077_1_, p_i1077_2_, p_i1077_3_, 22, 22, "");
/* 186 */       this.field_146145_o = p_i1077_4_;
/* 187 */       this.field_146144_p = p_i1077_5_;
/* 188 */       this.field_146143_q = p_i1077_6_;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_146112_a(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_) {
/* 193 */       if (!this.field_146125_m)
/*     */         return; 
/* 195 */       p_146112_1_.func_110434_K().func_110577_a(GuiBeacon.field_147025_v);
/* 196 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       
/* 198 */       this.field_146123_n = (p_146112_2_ >= this.field_146128_h && p_146112_3_ >= this.field_146129_i && p_146112_2_ < this.field_146128_h + this.field_146120_f && p_146112_3_ < this.field_146129_i + this.field_146121_g);
/* 199 */       char c = 'Û';
/* 200 */       int i = 0;
/* 201 */       if (!this.field_146124_l) {
/* 202 */         i += this.field_146120_f * 2;
/* 203 */       } else if (this.field_146142_r) {
/* 204 */         i += this.field_146120_f * 1;
/* 205 */       } else if (this.field_146123_n) {
/* 206 */         i += this.field_146120_f * 3;
/*     */       } 
/*     */       
/* 209 */       func_73729_b(this.field_146128_h, this.field_146129_i, i, c, this.field_146120_f, this.field_146121_g);
/*     */       
/* 211 */       if (!GuiBeacon.field_147025_v.equals(this.field_146145_o)) {
/* 212 */         p_146112_1_.func_110434_K().func_110577_a(this.field_146145_o);
/*     */       }
/*     */       
/* 215 */       func_73729_b(this.field_146128_h + 2, this.field_146129_i + 2, this.field_146144_p, this.field_146143_q, 18, 18);
/*     */     }
/*     */     
/*     */     public boolean func_146141_c() {
/* 219 */       return this.field_146142_r;
/*     */     }
/*     */     
/*     */     public void func_146140_b(boolean p_146140_1_) {
/* 223 */       this.field_146142_r = p_146140_1_;
/*     */     } }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   class PowerButton extends Button { private final int field_146149_p;
/*     */     private final int field_146148_q;
/*     */     private static final String __OBFID = "CL_00000742";
/*     */     
/*     */     public PowerButton(GuiBeacon p_i1076_1_, int p_i1076_2_, int p_i1076_3_, int p_i1076_4_, int p_i1076_5_, int p_i1076_6_) {
/* 233 */       super(p_i1076_2_, p_i1076_3_, p_i1076_4_, GuiContainer.field_147001_a, 0 + Potion.field_76425_a[p_i1076_5_].func_76392_e() % 8 * 18, 198 + Potion.field_76425_a[p_i1076_5_].func_76392_e() / 8 * 18);
/* 234 */       this.field_146149_p = p_i1076_5_;
/* 235 */       this.field_146148_q = p_i1076_6_;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_146111_b(int p_146111_1_, int p_146111_2_) {
/* 241 */       String str = I18n.func_135052_a(Potion.field_76425_a[this.field_146149_p].func_76393_a(), new Object[0]);
/*     */ 
/*     */       
/* 244 */       if (this.field_146148_q >= 3 && this.field_146149_p != Potion.field_76428_l.field_76415_H) {
/* 245 */         str = str + " II";
/*     */       }
/*     */       
/* 248 */       this.field_146150_o.func_146279_a(str, p_146111_1_, p_146111_2_);
/*     */     } }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   class ConfirmButton extends Button { private static final String __OBFID = "CL_00000741";
/*     */     
/*     */     public ConfirmButton(GuiBeacon p_i1075_1_, int p_i1075_2_, int p_i1075_3_, int p_i1075_4_) {
/* 255 */       super(p_i1075_2_, p_i1075_3_, p_i1075_4_, GuiBeacon.field_147025_v, 90, 220);
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_146111_b(int p_146111_1_, int p_146111_2_) {
/* 260 */       this.field_146147_o.func_146279_a(I18n.func_135052_a("gui.done", new Object[0]), p_146111_1_, p_146111_2_);
/*     */     } }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   class CancelButton extends Button { private static final String __OBFID = "CL_00000740";
/*     */     
/*     */     public CancelButton(GuiBeacon p_i1074_1_, int p_i1074_2_, int p_i1074_3_, int p_i1074_4_) {
/* 267 */       super(p_i1074_2_, p_i1074_3_, p_i1074_4_, GuiBeacon.field_147025_v, 112, 220);
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_146111_b(int p_146111_1_, int p_146111_2_) {
/* 272 */       this.field_146146_o.func_146279_a(I18n.func_135052_a("gui.cancel", new Object[0]), p_146111_1_, p_146111_2_);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\inventory\GuiBeacon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */