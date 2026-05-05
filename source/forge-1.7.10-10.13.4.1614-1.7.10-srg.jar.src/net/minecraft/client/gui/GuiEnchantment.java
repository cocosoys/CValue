/*     */ package net.minecraft.client.gui;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.gui.inventory.GuiContainer;
/*     */ import net.minecraft.client.model.ModelBook;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.ContainerEnchantment;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnchantmentNameParts;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.util.glu.Project;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiEnchantment extends GuiContainer {
/*  22 */   private static final ResourceLocation field_147078_C = new ResourceLocation("textures/gui/container/enchanting_table.png");
/*  23 */   private static final ResourceLocation field_147070_D = new ResourceLocation("textures/entity/enchanting_table_book.png");
/*  24 */   private static final ModelBook field_147072_E = new ModelBook();
/*  25 */   private Random field_147074_F = new Random();
/*     */   
/*     */   private ContainerEnchantment field_147075_G;
/*     */   
/*     */   public int field_147073_u;
/*     */   
/*     */   public float field_147071_v;
/*     */   public float field_147069_w;
/*     */   public float field_147082_x;
/*     */   
/*     */   public GuiEnchantment(InventoryPlayer p_i1090_1_, World p_i1090_2_, int p_i1090_3_, int p_i1090_4_, int p_i1090_5_, String p_i1090_6_) {
/*  36 */     super((Container)new ContainerEnchantment(p_i1090_1_, p_i1090_2_, p_i1090_3_, p_i1090_4_, p_i1090_5_));
/*  37 */     this.field_147075_G = (ContainerEnchantment)this.field_147002_h;
/*  38 */     this.field_147079_H = p_i1090_6_;
/*     */   }
/*     */   public float field_147081_y; public float field_147080_z; public float field_147076_A; ItemStack field_147077_B; private String field_147079_H; private static final String __OBFID = "CL_00000757";
/*     */   
/*     */   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
/*  43 */     this.field_146289_q.func_78276_b((this.field_147079_H == null) ? I18n.func_135052_a("container.enchant", new Object[0]) : this.field_147079_H, 12, 5, 4210752);
/*  44 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("container.inventory", new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  49 */     super.func_73876_c();
/*  50 */     func_147068_g();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/*  55 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */     
/*  57 */     int i = (this.field_146294_l - this.field_146999_f) / 2;
/*  58 */     int j = (this.field_146295_m - this.field_147000_g) / 2;
/*  59 */     for (byte b = 0; b < 3; b++) {
/*  60 */       int k = p_73864_1_ - i + 60;
/*  61 */       int m = p_73864_2_ - j + 14 + 19 * b;
/*  62 */       if (k >= 0 && m >= 0 && k < 108 && m < 19 && 
/*  63 */         this.field_147075_G.func_75140_a((EntityPlayer)this.field_146297_k.field_71439_g, b)) {
/*  64 */         this.field_146297_k.field_71442_b.func_78756_a(this.field_147075_G.field_75152_c, b);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
/*  72 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  73 */     this.field_146297_k.func_110434_K().func_110577_a(field_147078_C);
/*  74 */     int i = (this.field_146294_l - this.field_146999_f) / 2;
/*  75 */     int j = (this.field_146295_m - this.field_147000_g) / 2;
/*  76 */     func_73729_b(i, j, 0, 0, this.field_146999_f, this.field_147000_g);
/*     */     
/*  78 */     GL11.glPushMatrix();
/*  79 */     GL11.glMatrixMode(5889);
/*  80 */     GL11.glPushMatrix();
/*  81 */     GL11.glLoadIdentity();
/*  82 */     ScaledResolution scaledResolution = new ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/*     */     
/*  84 */     GL11.glViewport((scaledResolution.func_78326_a() - 320) / 2 * scaledResolution.func_78325_e(), (scaledResolution.func_78328_b() - 240) / 2 * scaledResolution.func_78325_e(), 320 * scaledResolution.func_78325_e(), 240 * scaledResolution.func_78325_e());
/*  85 */     GL11.glTranslatef(-0.34F, 0.23F, 0.0F);
/*     */     
/*  87 */     Project.gluPerspective(90.0F, 1.3333334F, 9.0F, 80.0F);
/*     */     
/*  89 */     float f1 = 1.0F;
/*  90 */     GL11.glMatrixMode(5888);
/*  91 */     GL11.glLoadIdentity();
/*  92 */     RenderHelper.func_74519_b();
/*  93 */     GL11.glTranslatef(0.0F, 3.3F, -16.0F);
/*  94 */     GL11.glScalef(f1, f1, f1);
/*  95 */     float f2 = 5.0F;
/*  96 */     GL11.glScalef(f2, f2, f2);
/*  97 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*     */     
/*  99 */     this.field_146297_k.func_110434_K().func_110577_a(field_147070_D);
/* 100 */     GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
/* 101 */     float f3 = this.field_147076_A + (this.field_147080_z - this.field_147076_A) * p_146976_1_;
/* 102 */     GL11.glTranslatef((1.0F - f3) * 0.2F, (1.0F - f3) * 0.1F, (1.0F - f3) * 0.25F);
/* 103 */     GL11.glRotatef(-(1.0F - f3) * 90.0F - 90.0F, 0.0F, 1.0F, 0.0F);
/* 104 */     GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*     */     
/* 106 */     float f4 = this.field_147069_w + (this.field_147071_v - this.field_147069_w) * p_146976_1_ + 0.25F;
/* 107 */     float f5 = this.field_147069_w + (this.field_147071_v - this.field_147069_w) * p_146976_1_ + 0.75F;
/* 108 */     f4 = (f4 - MathHelper.func_76140_b(f4)) * 1.6F - 0.3F;
/* 109 */     f5 = (f5 - MathHelper.func_76140_b(f5)) * 1.6F - 0.3F;
/*     */     
/* 111 */     if (f4 < 0.0F) f4 = 0.0F; 
/* 112 */     if (f5 < 0.0F) f5 = 0.0F; 
/* 113 */     if (f4 > 1.0F) f4 = 1.0F; 
/* 114 */     if (f5 > 1.0F) f5 = 1.0F;
/*     */     
/* 116 */     GL11.glEnable(32826);
/*     */     
/* 118 */     field_147072_E.func_78088_a(null, 0.0F, f4, f5, f3, 0.0F, 0.0625F);
/*     */     
/* 120 */     GL11.glDisable(32826);
/* 121 */     RenderHelper.func_74518_a();
/* 122 */     GL11.glMatrixMode(5889);
/* 123 */     GL11.glViewport(0, 0, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/* 124 */     GL11.glPopMatrix();
/* 125 */     GL11.glMatrixMode(5888);
/* 126 */     GL11.glPopMatrix();
/*     */     
/* 128 */     RenderHelper.func_74518_a();
/* 129 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/* 131 */     EnchantmentNameParts.field_148338_a.func_148335_a(this.field_147075_G.field_75166_f);
/*     */     
/* 133 */     for (byte b = 0; b < 3; b++) {
/* 134 */       String str = EnchantmentNameParts.field_148338_a.func_148334_a();
/* 135 */       this.field_73735_i = 0.0F;
/* 136 */       this.field_146297_k.func_110434_K().func_110577_a(field_147078_C);
/* 137 */       int k = this.field_147075_G.field_75167_g[b];
/* 138 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 139 */       if (k == 0) {
/* 140 */         func_73729_b(i + 60, j + 14 + 19 * b, 0, 185, 108, 19);
/*     */       } else {
/*     */         
/* 143 */         String str1 = "" + k;
/* 144 */         FontRenderer fontRenderer = this.field_146297_k.field_71464_q;
/* 145 */         int m = 6839882;
/* 146 */         if (this.field_146297_k.field_71439_g.field_71068_ca < k && !this.field_146297_k.field_71439_g.field_71075_bZ.field_75098_d) {
/* 147 */           func_73729_b(i + 60, j + 14 + 19 * b, 0, 185, 108, 19);
/* 148 */           fontRenderer.func_78279_b(str, i + 62, j + 16 + 19 * b, 104, (m & 0xFEFEFE) >> 1);
/* 149 */           fontRenderer = this.field_146297_k.field_71466_p;
/* 150 */           m = 4226832;
/* 151 */           fontRenderer.func_78261_a(str1, i + 62 + 104 - fontRenderer.func_78256_a(str1), j + 16 + 19 * b + 7, m);
/*     */         } else {
/* 153 */           int n = p_146976_2_ - i + 60;
/* 154 */           int i1 = p_146976_3_ - j + 14 + 19 * b;
/* 155 */           if (n >= 0 && i1 >= 0 && n < 108 && i1 < 19) {
/* 156 */             func_73729_b(i + 60, j + 14 + 19 * b, 0, 204, 108, 19);
/* 157 */             m = 16777088;
/*     */           } else {
/* 159 */             func_73729_b(i + 60, j + 14 + 19 * b, 0, 166, 108, 19);
/*     */           } 
/* 161 */           fontRenderer.func_78279_b(str, i + 62, j + 16 + 19 * b, 104, m);
/* 162 */           fontRenderer = this.field_146297_k.field_71466_p;
/* 163 */           m = 8453920;
/* 164 */           fontRenderer.func_78261_a(str1, i + 62 + 104 - fontRenderer.func_78256_a(str1), j + 16 + 19 * b + 7, m);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public void func_147068_g() {
/* 170 */     ItemStack itemStack = this.field_147002_h.func_75139_a(0).func_75211_c();
/*     */     
/* 172 */     if (!ItemStack.func_77989_b(itemStack, this.field_147077_B)) {
/* 173 */       this.field_147077_B = itemStack;
/*     */       do {
/* 175 */         this.field_147082_x += (this.field_147074_F.nextInt(4) - this.field_147074_F.nextInt(4));
/* 176 */       } while (this.field_147071_v <= this.field_147082_x + 1.0F && this.field_147071_v >= this.field_147082_x - 1.0F);
/*     */     } 
/*     */     
/* 179 */     this.field_147073_u++;
/* 180 */     this.field_147069_w = this.field_147071_v;
/* 181 */     this.field_147076_A = this.field_147080_z;
/*     */     
/* 183 */     boolean bool = false;
/* 184 */     for (byte b = 0; b < 3; b++) {
/* 185 */       if (this.field_147075_G.field_75167_g[b] != 0) {
/* 186 */         bool = true;
/*     */       }
/*     */     } 
/*     */     
/* 190 */     if (bool) { this.field_147080_z += 0.2F; }
/* 191 */     else { this.field_147080_z -= 0.2F; }
/* 192 */      if (this.field_147080_z < 0.0F) this.field_147080_z = 0.0F; 
/* 193 */     if (this.field_147080_z > 1.0F) this.field_147080_z = 1.0F;
/*     */     
/* 195 */     float f1 = (this.field_147082_x - this.field_147071_v) * 0.4F;
/* 196 */     float f2 = 0.2F;
/* 197 */     if (f1 < -f2) f1 = -f2; 
/* 198 */     if (f1 > f2) f1 = f2; 
/* 199 */     this.field_147081_y += (f1 - this.field_147081_y) * 0.9F;
/*     */     
/* 201 */     this.field_147071_v += this.field_147081_y;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiEnchantment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */