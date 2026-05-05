/*     */ package net.minecraft.client.gui;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.inventory.GuiContainer;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.entity.IMerchant;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.ContainerMerchant;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.village.MerchantRecipe;
/*     */ import net.minecraft.village.MerchantRecipeList;
/*     */ import net.minecraft.world.World;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiMerchant extends GuiContainer {
/*  24 */   private static final Logger field_147039_u = LogManager.getLogger();
/*  25 */   private static final ResourceLocation field_147038_v = new ResourceLocation("textures/gui/container/villager.png"); private IMerchant field_147037_w;
/*     */   private MerchantButton field_147043_x;
/*     */   private MerchantButton field_147042_y;
/*     */   private int field_147041_z;
/*     */   private String field_147040_A;
/*     */   private static final String __OBFID = "CL_00000762";
/*     */   
/*     */   public GuiMerchant(InventoryPlayer p_i1096_1_, IMerchant p_i1096_2_, World p_i1096_3_, String p_i1096_4_) {
/*  33 */     super((Container)new ContainerMerchant(p_i1096_1_, p_i1096_2_, p_i1096_3_));
/*  34 */     this.field_147037_w = p_i1096_2_;
/*  35 */     this.field_147040_A = (p_i1096_4_ == null || p_i1096_4_.length() < 1) ? I18n.func_135052_a("entity.Villager.name", new Object[0]) : p_i1096_4_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  40 */     super.func_73866_w_();
/*     */     
/*  42 */     int i = (this.field_146294_l - this.field_146999_f) / 2;
/*  43 */     int j = (this.field_146295_m - this.field_147000_g) / 2;
/*     */     
/*  45 */     this.field_146292_n.add(this.field_147043_x = new MerchantButton(1, i + 120 + 27, j + 24 - 1, true));
/*  46 */     this.field_146292_n.add(this.field_147042_y = new MerchantButton(2, i + 36 - 19, j + 24 - 1, false));
/*     */     
/*  48 */     this.field_147043_x.field_146124_l = false;
/*  49 */     this.field_147042_y.field_146124_l = false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
/*  54 */     this.field_146289_q.func_78276_b(this.field_147040_A, this.field_146999_f / 2 - this.field_146289_q.func_78256_a(this.field_147040_A) / 2, 6, 4210752);
/*  55 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("container.inventory", new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  60 */     super.func_73876_c();
/*     */     
/*  62 */     MerchantRecipeList merchantRecipeList = this.field_147037_w.func_70934_b((EntityPlayer)this.field_146297_k.field_71439_g);
/*  63 */     if (merchantRecipeList != null) {
/*  64 */       this.field_147043_x.field_146124_l = (this.field_147041_z < merchantRecipeList.size() - 1);
/*  65 */       this.field_147042_y.field_146124_l = (this.field_147041_z > 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  71 */     boolean bool = false;
/*  72 */     if (p_146284_1_ == this.field_147043_x) {
/*  73 */       this.field_147041_z++;
/*  74 */       bool = true;
/*  75 */     } else if (p_146284_1_ == this.field_147042_y) {
/*  76 */       this.field_147041_z--;
/*  77 */       bool = true;
/*     */     } 
/*     */     
/*  80 */     if (bool) {
/*  81 */       ((ContainerMerchant)this.field_147002_h).func_75175_c(this.field_147041_z);
/*     */       
/*  83 */       ByteBuf byteBuf = Unpooled.buffer();
/*     */       
/*     */       try {
/*  86 */         byteBuf.writeInt(this.field_147041_z);
/*  87 */         this.field_146297_k.func_147114_u().func_147297_a((Packet)new C17PacketCustomPayload("MC|TrSel", byteBuf));
/*  88 */       } catch (Exception exception) {
/*  89 */         field_147039_u.error("Couldn't send trade info", exception);
/*     */       } finally {
/*  91 */         byteBuf.release();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
/*  98 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  99 */     this.field_146297_k.func_110434_K().func_110577_a(field_147038_v);
/* 100 */     int i = (this.field_146294_l - this.field_146999_f) / 2;
/* 101 */     int j = (this.field_146295_m - this.field_147000_g) / 2;
/* 102 */     func_73729_b(i, j, 0, 0, this.field_146999_f, this.field_147000_g);
/*     */     
/* 104 */     MerchantRecipeList merchantRecipeList = this.field_147037_w.func_70934_b((EntityPlayer)this.field_146297_k.field_71439_g);
/* 105 */     if (merchantRecipeList != null && !merchantRecipeList.isEmpty()) {
/*     */       
/* 107 */       int k = this.field_147041_z;
/* 108 */       MerchantRecipe merchantRecipe = (MerchantRecipe)merchantRecipeList.get(k);
/*     */       
/* 110 */       if (merchantRecipe.func_82784_g()) {
/* 111 */         this.field_146297_k.func_110434_K().func_110577_a(field_147038_v);
/* 112 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 113 */         GL11.glDisable(2896);
/* 114 */         func_73729_b(this.field_147003_i + 83, this.field_147009_r + 21, 212, 0, 28, 21);
/* 115 */         func_73729_b(this.field_147003_i + 83, this.field_147009_r + 51, 212, 0, 28, 21);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 122 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */ 
/*     */     
/* 125 */     MerchantRecipeList merchantRecipeList = this.field_147037_w.func_70934_b((EntityPlayer)this.field_146297_k.field_71439_g);
/* 126 */     if (merchantRecipeList != null && !merchantRecipeList.isEmpty()) {
/* 127 */       int i = (this.field_146294_l - this.field_146999_f) / 2;
/* 128 */       int j = (this.field_146295_m - this.field_147000_g) / 2;
/*     */       
/* 130 */       int k = this.field_147041_z;
/* 131 */       MerchantRecipe merchantRecipe = (MerchantRecipe)merchantRecipeList.get(k);
/*     */       
/* 133 */       GL11.glPushMatrix();
/*     */       
/* 135 */       ItemStack itemStack1 = merchantRecipe.func_77394_a();
/* 136 */       ItemStack itemStack2 = merchantRecipe.func_77396_b();
/* 137 */       ItemStack itemStack3 = merchantRecipe.func_77397_d();
/*     */       
/* 139 */       RenderHelper.func_74520_c();
/* 140 */       GL11.glDisable(2896);
/* 141 */       GL11.glEnable(32826);
/* 142 */       GL11.glEnable(2903);
/* 143 */       GL11.glEnable(2896);
/*     */       
/* 145 */       field_146296_j.field_77023_b = 100.0F;
/* 146 */       field_146296_j.func_82406_b(this.field_146289_q, this.field_146297_k.func_110434_K(), itemStack1, i + 36, j + 24);
/* 147 */       field_146296_j.func_77021_b(this.field_146289_q, this.field_146297_k.func_110434_K(), itemStack1, i + 36, j + 24);
/*     */       
/* 149 */       if (itemStack2 != null) {
/* 150 */         field_146296_j.func_82406_b(this.field_146289_q, this.field_146297_k.func_110434_K(), itemStack2, i + 62, j + 24);
/* 151 */         field_146296_j.func_77021_b(this.field_146289_q, this.field_146297_k.func_110434_K(), itemStack2, i + 62, j + 24);
/*     */       } 
/*     */       
/* 154 */       field_146296_j.func_82406_b(this.field_146289_q, this.field_146297_k.func_110434_K(), itemStack3, i + 120, j + 24);
/* 155 */       field_146296_j.func_77021_b(this.field_146289_q, this.field_146297_k.func_110434_K(), itemStack3, i + 120, j + 24);
/* 156 */       field_146296_j.field_77023_b = 0.0F;
/*     */       
/* 158 */       GL11.glDisable(2896);
/*     */       
/* 160 */       if (func_146978_c(36, 24, 16, 16, p_73863_1_, p_73863_2_)) {
/* 161 */         func_146285_a(itemStack1, p_73863_1_, p_73863_2_);
/* 162 */       } else if (itemStack2 != null && func_146978_c(62, 24, 16, 16, p_73863_1_, p_73863_2_)) {
/* 163 */         func_146285_a(itemStack2, p_73863_1_, p_73863_2_);
/* 164 */       } else if (func_146978_c(120, 24, 16, 16, p_73863_1_, p_73863_2_)) {
/* 165 */         func_146285_a(itemStack3, p_73863_1_, p_73863_2_);
/*     */       } 
/*     */       
/* 168 */       GL11.glPopMatrix();
/*     */       
/* 170 */       GL11.glEnable(2896);
/* 171 */       GL11.glEnable(2929);
/* 172 */       RenderHelper.func_74519_b();
/*     */     } 
/*     */   }
/*     */   
/*     */   public IMerchant func_147035_g() {
/* 177 */     return this.field_147037_w;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   static class MerchantButton extends GuiButton { private final boolean field_146157_o;
/*     */     private static final String __OBFID = "CL_00000763";
/*     */     
/*     */     public MerchantButton(int p_i1095_1_, int p_i1095_2_, int p_i1095_3_, boolean p_i1095_4_) {
/* 185 */       super(p_i1095_1_, p_i1095_2_, p_i1095_3_, 12, 19, "");
/* 186 */       this.field_146157_o = p_i1095_4_;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_146112_a(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_) {
/* 191 */       if (!this.field_146125_m)
/*     */         return; 
/* 193 */       p_146112_1_.func_110434_K().func_110577_a(GuiMerchant.field_147038_v);
/* 194 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       
/* 196 */       boolean bool = (p_146112_2_ >= this.field_146128_h && p_146112_3_ >= this.field_146129_i && p_146112_2_ < this.field_146128_h + this.field_146120_f && p_146112_3_ < this.field_146129_i + this.field_146121_g) ? true : false;
/* 197 */       int i = 0;
/* 198 */       int j = 176;
/* 199 */       if (!this.field_146124_l) {
/* 200 */         j += this.field_146120_f * 2;
/* 201 */       } else if (bool) {
/* 202 */         j += this.field_146120_f;
/*     */       } 
/* 204 */       if (!this.field_146157_o) {
/* 205 */         i += this.field_146121_g;
/*     */       }
/*     */       
/* 208 */       func_73729_b(this.field_146128_h, this.field_146129_i, j, i, this.field_146120_f, this.field_146121_g);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiMerchant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */