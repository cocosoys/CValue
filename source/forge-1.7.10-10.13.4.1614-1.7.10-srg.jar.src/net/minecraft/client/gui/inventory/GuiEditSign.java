/*     */ package net.minecraft.client.gui.inventory;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.client.C12PacketUpdateSign;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntitySign;
/*     */ import net.minecraft.util.ChatAllowedCharacters;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiEditSign extends GuiScreen {
/*     */   private TileEntitySign field_146848_f;
/*     */   private int field_146849_g;
/*     */   
/*     */   public GuiEditSign(TileEntitySign p_i1097_1_) {
/*  26 */     this.field_146848_f = p_i1097_1_;
/*     */   }
/*     */   private int field_146851_h; private GuiButton field_146852_i; private static final String __OBFID = "CL_00000764";
/*     */   
/*     */   public void func_73866_w_() {
/*  31 */     this.field_146292_n.clear();
/*  32 */     Keyboard.enableRepeatEvents(true);
/*  33 */     this.field_146292_n.add(this.field_146852_i = new GuiButton(0, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 120, I18n.func_135052_a("gui.done", new Object[0])));
/*  34 */     this.field_146848_f.func_145913_a(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/*  39 */     Keyboard.enableRepeatEvents(false);
/*  40 */     NetHandlerPlayClient netHandlerPlayClient = this.field_146297_k.func_147114_u();
/*  41 */     if (netHandlerPlayClient != null) netHandlerPlayClient.func_147297_a((Packet)new C12PacketUpdateSign(this.field_146848_f.field_145851_c, this.field_146848_f.field_145848_d, this.field_146848_f.field_145849_e, this.field_146848_f.field_145915_a)); 
/*  42 */     this.field_146848_f.func_145913_a(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  47 */     this.field_146849_g++;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  52 */     if (!p_146284_1_.field_146124_l)
/*     */       return; 
/*  54 */     if (p_146284_1_.field_146127_k == 0) {
/*  55 */       this.field_146848_f.func_70296_d();
/*  56 */       this.field_146297_k.func_147108_a(null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/*  62 */     if (p_73869_2_ == 200) this.field_146851_h = this.field_146851_h - 1 & 0x3; 
/*  63 */     if (p_73869_2_ == 208 || p_73869_2_ == 28 || p_73869_2_ == 156) this.field_146851_h = this.field_146851_h + 1 & 0x3; 
/*  64 */     if (p_73869_2_ == 14 && this.field_146848_f.field_145915_a[this.field_146851_h].length() > 0) {
/*  65 */       this.field_146848_f.field_145915_a[this.field_146851_h] = this.field_146848_f.field_145915_a[this.field_146851_h].substring(0, this.field_146848_f.field_145915_a[this.field_146851_h].length() - 1);
/*     */     }
/*  67 */     if (ChatAllowedCharacters.func_71566_a(p_73869_1_) && this.field_146848_f.field_145915_a[this.field_146851_h].length() < 15) {
/*  68 */       this.field_146848_f.field_145915_a[this.field_146851_h] = this.field_146848_f.field_145915_a[this.field_146851_h] + p_73869_1_;
/*     */     }
/*  70 */     if (p_73869_2_ == 1) {
/*  71 */       func_146284_a(this.field_146852_i);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/*  77 */     func_146276_q_();
/*     */     
/*  79 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("sign.edit", new Object[0]), this.field_146294_l / 2, 40, 16777215);
/*     */     
/*  81 */     GL11.glPushMatrix();
/*  82 */     GL11.glTranslatef((this.field_146294_l / 2), 0.0F, 50.0F);
/*  83 */     float f = 93.75F;
/*  84 */     GL11.glScalef(-f, -f, -f);
/*  85 */     GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
/*     */     
/*  87 */     Block block = this.field_146848_f.func_145838_q();
/*     */     
/*  89 */     if (block == Blocks.field_150472_an) {
/*  90 */       float f1 = (this.field_146848_f.func_145832_p() * 360) / 16.0F;
/*  91 */       GL11.glRotatef(f1, 0.0F, 1.0F, 0.0F);
/*     */       
/*  93 */       GL11.glTranslatef(0.0F, -1.0625F, 0.0F);
/*     */     } else {
/*  95 */       int i = this.field_146848_f.func_145832_p();
/*  96 */       float f1 = 0.0F;
/*     */       
/*  98 */       if (i == 2) f1 = 180.0F; 
/*  99 */       if (i == 4) f1 = 90.0F; 
/* 100 */       if (i == 5) f1 = -90.0F; 
/* 101 */       GL11.glRotatef(f1, 0.0F, 1.0F, 0.0F);
/* 102 */       GL11.glTranslatef(0.0F, -1.0625F, 0.0F);
/*     */     } 
/*     */     
/* 105 */     if (this.field_146849_g / 6 % 2 == 0) this.field_146848_f.field_145918_i = this.field_146851_h;
/*     */     
/* 107 */     TileEntityRendererDispatcher.field_147556_a.func_147549_a((TileEntity)this.field_146848_f, -0.5D, -0.75D, -0.5D, 0.0F);
/* 108 */     this.field_146848_f.field_145918_i = -1;
/*     */     
/* 110 */     GL11.glPopMatrix();
/*     */     
/* 112 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\inventory\GuiEditSign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */