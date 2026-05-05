/*     */ package JinRyuu.DragonBC.common.Gui;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Render.ArtGravDevContainer;
/*     */ import JinRyuu.DragonBC.common.Render.ArtGravDevTileEntity;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPwish;
/*     */ import JinRyuu.JRMCore.p.PD;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.gui.inventory.GuiContainer;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class DBCGuiArtGravDev extends GuiContainer {
/*  21 */   private static final ResourceLocation furnaceGuiTextures = new ResourceLocation(JRMCoreH.tjdbcAssts, "gui/ArtGravDev.png"); private ArtGravDevTileEntity tileFurnace; private String name; private int text;
/*     */   protected GuiTextField inputField;
/*     */   private String defaultInputFieldText;
/*     */   private boolean updateTimerStopper;
/*     */   
/*  26 */   public DBCGuiArtGravDev(InventoryPlayer p_i1091_1_, ArtGravDevTileEntity p_i1091_2_) { super((Container)new ArtGravDevContainer(p_i1091_1_, p_i1091_2_));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  45 */     this.name = "";
/*  46 */     this.text = 0;
/*     */     
/*  48 */     this.defaultInputFieldText = "";
/*  49 */     this.updateTimerStopper = false;
/*     */     this.tileFurnace = p_i1091_2_; }
/*  51 */   private void name(FontRenderer var8, int i, int j) { this.inputField = new GuiTextField(var8, i + 100, j + 15 + 0, 40, 12);
/*  52 */     this.inputField.func_146203_f(5);
/*  53 */     this.inputField.func_146185_a(true);
/*  54 */     this.inputField.func_146195_b(true);
/*  55 */     this.inputField.func_146180_a(this.defaultInputFieldText);
/*  56 */     this.inputField.func_146205_d(true); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  61 */     if (this.inputField != null)
/*  62 */       this.inputField.func_146178_a();  }
/*     */   public void func_146284_a(GuiButton button) { if ((this.name.matches("[0-9].+") || this.name.matches("[0-9]+")) && this.name.length() > 0) { boolean success = true; try { this.name = ((Float.parseFloat(this.name) > 1000.0F) ? 1000.0F : ((Float.parseFloat(this.name) < 1.0F) ? 1.0F : Float.parseFloat(this.name))) + ""; } catch (Exception e) { success = false; }
/*     */        if (!success)
/*     */         this.name = "1";  if (button.field_146127_k == 210) { PD.sendToServer((IMessage)new DBCPwish(4, this.tileFurnace.field_145851_c + ";" + this.tileFurnace.field_145848_d + ";" + this.tileFurnace.field_145849_e + ";" + this.name)); this.field_146297_k.field_71439_g.func_71053_j(); }
/*     */        }
/*  67 */      } protected void func_73869_a(char c, int i) { super.func_73869_a(c, i);
/*  68 */     if (this.inputField != null) {
/*  69 */       this.inputField.func_146201_a(c, i);
/*     */     } }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int i, int j, int k) {
/*  74 */     super.func_73864_a(i, j, k);
/*  75 */     if (this.inputField != null) {
/*  76 */       this.inputField.func_146192_a(i, j, k);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
/*  83 */     String s = this.tileFurnace.func_145818_k_() ? this.tileFurnace.func_145825_b() : I18n.func_135052_a(this.tileFurnace.func_145825_b(), new Object[0]);
/*  84 */     this.field_146289_q.func_78276_b(s, this.field_146999_f / 2 - this.field_146289_q.func_78256_a(s) / 2, 6, 4210752);
/*  85 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("container.inventory", new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
/*     */     
/*  87 */     int posX = this.field_146294_l / 2;
/*  88 */     int posY = this.field_146295_m / 2;
/*  89 */     int guiLeft = (this.field_146294_l - this.field_146999_f) / 2;
/*  90 */     int guiTop = (this.field_146295_m - this.field_147000_g) / 2;
/*     */     
/*  92 */     int line = 1; line++;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     String n = JRMCoreH.trl("dbc", "Gravity") + ": " + ((this.tileFurnace.isBurning() && this.tileFurnace.getGravity() > 1.0F) ? (String)Float.valueOf(this.tileFurnace.getGravity()) : ("1" + ((this.tileFurnace.isBurning() || this.tileFurnace.func_70301_a(0) != null) ? "" : (" (" + JRMCoreH.trl("dbc", "OutOfFuel") + ")")))); int nw = this.field_146289_q.func_78256_a(n) + 8;
/*  98 */     this.field_146289_q.func_78276_b(n, 25, 10 + line * 11, 0); line++;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
/* 103 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 104 */     this.field_146297_k.func_110434_K().func_110577_a(furnaceGuiTextures);
/* 105 */     int k = (this.field_146294_l - this.field_146999_f) / 2;
/* 106 */     int l = (this.field_146295_m - this.field_147000_g) / 2;
/* 107 */     func_73729_b(k, l, 0, 0, this.field_146999_f, this.field_147000_g);
/*     */     
/* 109 */     int guiLeft = (this.field_146294_l - this.field_146999_f) / 2;
/* 110 */     int guiTop = (this.field_146295_m - this.field_147000_g) / 2;
/*     */     
/* 112 */     if (this.tileFurnace.isBurning()) {
/*     */       
/* 114 */       int i1 = this.tileFurnace.getBurnTimeRemainingScaled(13);
/* 115 */       func_73729_b(k + 5, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 120 */     int line = 1;
/* 121 */     String n = JRMCoreH.trl("dbc", "SetGravity") + ":"; int nw = this.field_146289_q.func_78256_a(n) + 8;
/* 122 */     this.text++;
/* 123 */     if (this.text == 1) {
/* 124 */       name(this.field_146289_q, guiLeft + 25 - 100 + nw, guiTop + 10 - 18 + line * 11);
/* 125 */       this.inputField.func_146180_a("1");
/*     */     } else {
/* 127 */       this.text = 2;
/* 128 */     }  if (this.inputField != null) {
/* 129 */       this.inputField.func_146194_f();
/* 130 */       this.name = this.inputField.func_146179_b();
/* 131 */       this.field_146289_q.func_78276_b(n, guiLeft + 25, guiTop + 10 + line * 11, 0);
/* 132 */     }  line++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73863_a(int x, int y, float f) {
/* 140 */     ScaledResolution var5 = new ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/* 141 */     int var6 = var5.func_78326_a();
/* 142 */     int var7 = var5.func_78328_b();
/* 143 */     FontRenderer var8 = this.field_146297_k.field_71466_p;
/*     */     
/* 145 */     this.field_146292_n.clear();
/*     */ 
/*     */     
/* 148 */     int posX = this.field_146294_l / 2;
/* 149 */     int posY = this.field_146295_m / 2;
/* 150 */     int line = 1;
/* 151 */     String n = JRMCoreH.trl("jrmc", "Update"); int nw = this.field_146289_q.func_78256_a(n) + 8;
/* 152 */     this.field_146292_n.add(new DBCGuiButtons01(210, this.field_147003_i + 165 - nw, this.field_147009_r + 35 + line * 11, nw, 20, n)); line++;
/*     */     
/* 154 */     super.func_73863_a(x, y, f);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\DBCGuiArtGravDev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */