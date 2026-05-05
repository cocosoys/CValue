/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.multiplayer.ServerData;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiScreenAddServer
/*     */   extends GuiScreen {
/*     */   private final GuiScreen field_146310_a;
/*     */   private final ServerData field_146311_h;
/*     */   private GuiTextField field_146308_f;
/*     */   
/*     */   public GuiScreenAddServer(GuiScreen p_i1033_1_, ServerData p_i1033_2_) {
/*  17 */     this.field_146310_a = p_i1033_1_;
/*  18 */     this.field_146311_h = p_i1033_2_;
/*     */   }
/*     */   private GuiTextField field_146309_g; private GuiButton field_152176_i; private static final String __OBFID = "CL_00000695";
/*     */   
/*     */   public void func_73876_c() {
/*  23 */     this.field_146309_g.func_146178_a();
/*  24 */     this.field_146308_f.func_146178_a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  30 */     Keyboard.enableRepeatEvents(true);
/*  31 */     this.field_146292_n.clear();
/*  32 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 96 + 18, I18n.func_135052_a("addServer.add", new Object[0])));
/*  33 */     this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 120 + 18, I18n.func_135052_a("gui.cancel", new Object[0])));
/*  34 */     this.field_146292_n.add(this.field_152176_i = new GuiButton(2, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 72, I18n.func_135052_a("addServer.resourcePack", new Object[0]) + ": " + this.field_146311_h.func_152586_b().func_152589_a().func_150254_d()));
/*     */     
/*  36 */     this.field_146309_g = new GuiTextField(this.field_146289_q, this.field_146294_l / 2 - 100, 66, 200, 20);
/*  37 */     this.field_146309_g.func_146195_b(true);
/*  38 */     this.field_146309_g.func_146180_a(this.field_146311_h.field_78847_a);
/*     */     
/*  40 */     this.field_146308_f = new GuiTextField(this.field_146289_q, this.field_146294_l / 2 - 100, 106, 200, 20);
/*  41 */     this.field_146308_f.func_146203_f(128);
/*  42 */     this.field_146308_f.func_146180_a(this.field_146311_h.field_78845_b);
/*     */     
/*  44 */     ((GuiButton)this.field_146292_n.get(0)).field_146124_l = (this.field_146308_f.func_146179_b().length() > 0 && (this.field_146308_f.func_146179_b().split(":")).length > 0 && this.field_146309_g.func_146179_b().length() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/*  49 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  54 */     if (!p_146284_1_.field_146124_l)
/*  55 */       return;  if (p_146284_1_.field_146127_k == 2) {
/*  56 */       this.field_146311_h.func_152584_a(ServerData.ServerResourceMode.values()[(this.field_146311_h.func_152586_b().ordinal() + 1) % (ServerData.ServerResourceMode.values()).length]);
/*  57 */       this.field_152176_i.field_146126_j = I18n.func_135052_a("addServer.resourcePack", new Object[0]) + ": " + this.field_146311_h.func_152586_b().func_152589_a().func_150254_d();
/*  58 */     } else if (p_146284_1_.field_146127_k == 1) {
/*  59 */       this.field_146310_a.func_73878_a(false, 0);
/*  60 */     } else if (p_146284_1_.field_146127_k == 0) {
/*  61 */       this.field_146311_h.field_78847_a = this.field_146309_g.func_146179_b();
/*  62 */       this.field_146311_h.field_78845_b = this.field_146308_f.func_146179_b();
/*  63 */       this.field_146310_a.func_73878_a(true, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/*  69 */     this.field_146309_g.func_146201_a(p_73869_1_, p_73869_2_);
/*  70 */     this.field_146308_f.func_146201_a(p_73869_1_, p_73869_2_);
/*     */     
/*  72 */     if (p_73869_2_ == 15) {
/*  73 */       this.field_146309_g.func_146195_b(!this.field_146309_g.func_146206_l());
/*  74 */       this.field_146308_f.func_146195_b(!this.field_146308_f.func_146206_l());
/*     */     } 
/*  76 */     if (p_73869_2_ == 28 || p_73869_2_ == 156) {
/*  77 */       func_146284_a(this.field_146292_n.get(0));
/*     */     }
/*  79 */     ((GuiButton)this.field_146292_n.get(0)).field_146124_l = (this.field_146308_f.func_146179_b().length() > 0 && (this.field_146308_f.func_146179_b().split(":")).length > 0 && this.field_146309_g.func_146179_b().length() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/*  84 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */     
/*  86 */     this.field_146308_f.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*  87 */     this.field_146309_g.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/*  93 */     func_146276_q_();
/*     */     
/*  95 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("addServer.title", new Object[0]), this.field_146294_l / 2, 17, 16777215);
/*  96 */     func_73731_b(this.field_146289_q, I18n.func_135052_a("addServer.enterName", new Object[0]), this.field_146294_l / 2 - 100, 53, 10526880);
/*  97 */     func_73731_b(this.field_146289_q, I18n.func_135052_a("addServer.enterIp", new Object[0]), this.field_146294_l / 2 - 100, 94, 10526880);
/*     */     
/*  99 */     this.field_146309_g.func_146194_f();
/* 100 */     this.field_146308_f.func_146194_f();
/*     */     
/* 102 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiScreenAddServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */