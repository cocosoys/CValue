/*     */ package net.minecraft.client.gui;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.inventory.GuiContainer;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.ContainerRepair;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.play.client.C17PacketCustomPayload;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import org.apache.commons.io.Charsets;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiRepair extends GuiContainer implements ICrafting {
/*  21 */   private static final ResourceLocation field_147093_u = new ResourceLocation("textures/gui/container/anvil.png");
/*     */   private ContainerRepair field_147092_v;
/*     */   private GuiTextField field_147091_w;
/*     */   private InventoryPlayer field_147094_x;
/*     */   private static final String __OBFID = "CL_00000738";
/*     */   
/*     */   public GuiRepair(InventoryPlayer p_i1073_1_, World p_i1073_2_, int p_i1073_3_, int p_i1073_4_, int p_i1073_5_) {
/*  28 */     super((Container)new ContainerRepair(p_i1073_1_, p_i1073_2_, p_i1073_3_, p_i1073_4_, p_i1073_5_, (EntityPlayer)(Minecraft.func_71410_x()).field_71439_g));
/*  29 */     this.field_147094_x = p_i1073_1_;
/*  30 */     this.field_147092_v = (ContainerRepair)this.field_147002_h;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  35 */     super.func_73866_w_();
/*  36 */     Keyboard.enableRepeatEvents(true);
/*     */     
/*  38 */     int i = (this.field_146294_l - this.field_146999_f) / 2;
/*  39 */     int j = (this.field_146295_m - this.field_147000_g) / 2;
/*     */     
/*  41 */     this.field_147091_w = new GuiTextField(this.field_146289_q, i + 62, j + 24, 103, 12);
/*  42 */     this.field_147091_w.func_146193_g(-1);
/*  43 */     this.field_147091_w.func_146204_h(-1);
/*  44 */     this.field_147091_w.func_146185_a(false);
/*  45 */     this.field_147091_w.func_146203_f(40);
/*     */     
/*  47 */     this.field_147002_h.func_82847_b(this);
/*  48 */     this.field_147002_h.func_75132_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/*  53 */     super.func_146281_b();
/*     */     
/*  55 */     Keyboard.enableRepeatEvents(false);
/*  56 */     this.field_147002_h.func_82847_b(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
/*  61 */     GL11.glDisable(2896);
/*  62 */     GL11.glDisable(3042);
/*  63 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("container.repair", new Object[0]), 60, 6, 4210752);
/*     */     
/*  65 */     if (this.field_147092_v.field_82854_e > 0) {
/*  66 */       int i = 8453920;
/*  67 */       boolean bool = true;
/*  68 */       String str = I18n.func_135052_a("container.repair.cost", new Object[] { Integer.valueOf(this.field_147092_v.field_82854_e) });
/*  69 */       if (this.field_147092_v.field_82854_e >= 40 && !this.field_146297_k.field_71439_g.field_71075_bZ.field_75098_d) {
/*  70 */         str = I18n.func_135052_a("container.repair.expensive", new Object[0]);
/*  71 */         i = 16736352;
/*  72 */       } else if (!this.field_147092_v.func_75139_a(2).func_75216_d()) {
/*  73 */         bool = false;
/*  74 */       } else if (!this.field_147092_v.func_75139_a(2).func_82869_a(this.field_147094_x.field_70458_d)) {
/*  75 */         i = 16736352;
/*     */       } 
/*     */       
/*  78 */       if (bool) {
/*  79 */         int j = 0xFF000000 | (i & 0xFCFCFC) >> 2 | i & 0xFF000000;
/*  80 */         int k = this.field_146999_f - 8 - this.field_146289_q.func_78256_a(str);
/*  81 */         byte b = 67;
/*  82 */         if (this.field_146289_q.func_82883_a()) {
/*  83 */           func_73734_a(k - 3, b - 2, this.field_146999_f - 7, b + 10, -16777216);
/*  84 */           func_73734_a(k - 2, b - 1, this.field_146999_f - 8, b + 9, -12895429);
/*     */         } else {
/*  86 */           this.field_146289_q.func_78276_b(str, k, b + 1, j);
/*  87 */           this.field_146289_q.func_78276_b(str, k + 1, b, j);
/*  88 */           this.field_146289_q.func_78276_b(str, k + 1, b + 1, j);
/*     */         } 
/*  90 */         this.field_146289_q.func_78276_b(str, k, b, i);
/*     */       } 
/*     */     } 
/*  93 */     GL11.glEnable(2896);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/*  98 */     if (this.field_147091_w.func_146201_a(p_73869_1_, p_73869_2_)) {
/*  99 */       func_147090_g();
/*     */     } else {
/* 101 */       super.func_73869_a(p_73869_1_, p_73869_2_);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_147090_g() {
/* 106 */     String str = this.field_147091_w.func_146179_b();
/*     */     
/* 108 */     Slot slot = this.field_147092_v.func_75139_a(0);
/* 109 */     if (slot != null && slot.func_75216_d() && 
/* 110 */       !slot.func_75211_c().func_82837_s() && str.equals(slot.func_75211_c().func_82833_r())) {
/* 111 */       str = "";
/*     */     }
/*     */ 
/*     */     
/* 115 */     this.field_147092_v.func_82850_a(str);
/* 116 */     this.field_146297_k.field_71439_g.field_71174_a.func_147297_a((Packet)new C17PacketCustomPayload("MC|ItemName", str.getBytes(Charsets.UTF_8)));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 121 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/* 122 */     this.field_147091_w.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 127 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */     
/* 129 */     GL11.glDisable(2896);
/* 130 */     GL11.glDisable(3042);
/* 131 */     this.field_147091_w.func_146194_f();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
/* 136 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 137 */     this.field_146297_k.func_110434_K().func_110577_a(field_147093_u);
/* 138 */     int i = (this.field_146294_l - this.field_146999_f) / 2;
/* 139 */     int j = (this.field_146295_m - this.field_147000_g) / 2;
/* 140 */     func_73729_b(i, j, 0, 0, this.field_146999_f, this.field_147000_g);
/*     */     
/* 142 */     func_73729_b(i + 59, j + 20, 0, this.field_147000_g + (this.field_147092_v.func_75139_a(0).func_75216_d() ? 0 : 16), 110, 16);
/*     */     
/* 144 */     if ((this.field_147092_v.func_75139_a(0).func_75216_d() || this.field_147092_v.func_75139_a(1).func_75216_d()) && !this.field_147092_v.func_75139_a(2).func_75216_d()) {
/* 145 */       func_73729_b(i + 99, j + 45, this.field_146999_f, 0, 28, 21);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71110_a(Container p_71110_1_, List p_71110_2_) {
/* 151 */     func_71111_a(p_71110_1_, 0, p_71110_1_.func_75139_a(0).func_75211_c());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71111_a(Container p_71111_1_, int p_71111_2_, ItemStack p_71111_3_) {
/* 156 */     if (p_71111_2_ == 0) {
/* 157 */       this.field_147091_w.func_146180_a((p_71111_3_ == null) ? "" : p_71111_3_.func_82833_r());
/* 158 */       this.field_147091_w.func_146184_c((p_71111_3_ != null));
/* 159 */       if (p_71111_3_ != null)
/* 160 */         func_147090_g(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_71112_a(Container p_71112_1_, int p_71112_2_, int p_71112_3_) {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiRepair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */