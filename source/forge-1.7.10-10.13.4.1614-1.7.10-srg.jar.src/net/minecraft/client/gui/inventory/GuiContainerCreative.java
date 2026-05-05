/*     */ package net.minecraft.client.gui.inventory;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.client.gui.achievement.GuiAchievements;
/*     */ import net.minecraft.client.gui.achievement.GuiStats;
/*     */ import net.minecraft.client.renderer.InventoryEffectRenderer;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryBasic;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiContainerCreative extends InventoryEffectRenderer {
/*  38 */   private static final ResourceLocation field_147061_u = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   private static InventoryBasic field_147060_v = new InventoryBasic("tmp", true, 45);
/*  48 */   private static int field_147058_w = CreativeTabs.field_78030_b.func_78021_a();
/*     */   private float field_147067_x;
/*     */   private boolean field_147066_y;
/*     */   private boolean field_147065_z;
/*     */   private GuiTextField field_147062_A;
/*     */   private List field_147063_B;
/*     */   private Slot field_147064_C;
/*     */   private boolean field_147057_D;
/*     */   private CreativeCrafting field_147059_E;
/*     */   private static final String __OBFID = "CL_00000752";
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*  60 */   static class ContainerCreative extends Container { public List field_148330_a = new ArrayList(); private static final String __OBFID = "CL_00000753";
/*     */     
/*     */     public ContainerCreative(EntityPlayer p_i1086_1_) {
/*  63 */       InventoryPlayer inventoryPlayer = p_i1086_1_.field_71071_by; byte b;
/*  64 */       for (b = 0; b < 5; b++) {
/*  65 */         for (byte b1 = 0; b1 < 9; b1++) {
/*  66 */           func_75146_a(new Slot((IInventory)GuiContainerCreative.field_147060_v, b * 9 + b1, 9 + b1 * 18, 18 + b * 18));
/*     */         }
/*     */       } 
/*     */       
/*  70 */       for (b = 0; b < 9; b++) {
/*  71 */         func_75146_a(new Slot((IInventory)inventoryPlayer, b, 9 + b * 18, 112));
/*     */       }
/*     */       
/*  74 */       func_148329_a(0.0F);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_75145_c(EntityPlayer p_75145_1_) {
/*  79 */       return true;
/*     */     }
/*     */     
/*     */     public void func_148329_a(float p_148329_1_) {
/*  83 */       int i = this.field_148330_a.size() / 9 - 5 + 1;
/*     */       
/*  85 */       int j = (int)((p_148329_1_ * i) + 0.5D);
/*  86 */       if (j < 0) j = 0; 
/*  87 */       for (byte b = 0; b < 5; b++) {
/*  88 */         for (byte b1 = 0; b1 < 9; b1++) {
/*  89 */           int k = b1 + (b + j) * 9;
/*  90 */           if (k >= 0 && k < this.field_148330_a.size()) {
/*  91 */             GuiContainerCreative.field_147060_v.func_70299_a(b1 + b * 9, this.field_148330_a.get(k));
/*     */           } else {
/*  93 */             GuiContainerCreative.field_147060_v.func_70299_a(b1 + b * 9, null);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean func_148328_e() {
/* 100 */       return (this.field_148330_a.size() > 45);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_75133_b(int p_75133_1_, int p_75133_2_, boolean p_75133_3_, EntityPlayer p_75133_4_) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
/* 115 */       if (p_82846_2_ >= this.field_75151_b.size() - 9 && p_82846_2_ < this.field_75151_b.size()) {
/* 116 */         Slot slot = this.field_75151_b.get(p_82846_2_);
/*     */         
/* 118 */         if (slot != null && slot.func_75216_d()) {
/* 119 */           slot.func_75215_d(null);
/*     */         }
/*     */       } 
/*     */       
/* 123 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_94530_a(ItemStack p_94530_1_, Slot p_94530_2_) {
/* 128 */       return (p_94530_2_.field_75221_f > 90);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_94531_b(Slot p_94531_1_) {
/* 133 */       return (p_94531_1_.field_75224_c instanceof InventoryPlayer || (p_94531_1_.field_75221_f > 90 && p_94531_1_.field_75223_e <= 162));
/*     */     } }
/*     */ 
/*     */   
/*     */   public GuiContainerCreative(EntityPlayer p_i1088_1_) {
/* 138 */     super(new ContainerCreative(p_i1088_1_));
/* 139 */     p_i1088_1_.field_71070_bA = this.field_147002_h;
/* 140 */     this.field_146291_p = true;
/* 141 */     this.field_147000_g = 136;
/* 142 */     this.field_146999_f = 195;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/* 147 */     if (!this.field_146297_k.field_71442_b.func_78758_h()) {
/* 148 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiInventory((EntityPlayer)this.field_146297_k.field_71439_g));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146984_a(Slot p_146984_1_, int p_146984_2_, int p_146984_3_, int p_146984_4_) {
/* 154 */     this.field_147057_D = true;
/* 155 */     boolean bool = (p_146984_4_ == 1) ? true : false;
/* 156 */     p_146984_4_ = (p_146984_2_ == -999 && p_146984_4_ == 0) ? 4 : p_146984_4_;
/*     */     
/* 158 */     if (p_146984_1_ != null || field_147058_w == CreativeTabs.field_78036_m.func_78021_a() || p_146984_4_ == 5) {
/* 159 */       if (p_146984_1_ == this.field_147064_C && bool) {
/* 160 */         for (byte b = 0; b < this.field_146297_k.field_71439_g.field_71069_bz.func_75138_a().size(); b++) {
/* 161 */           this.field_146297_k.field_71442_b.func_78761_a(null, b);
/*     */         }
/* 163 */       } else if (field_147058_w == CreativeTabs.field_78036_m.func_78021_a()) {
/*     */         
/* 165 */         if (p_146984_1_ == this.field_147064_C) {
/* 166 */           this.field_146297_k.field_71439_g.field_71071_by.func_70437_b(null);
/* 167 */         } else if (p_146984_4_ == 4 && p_146984_1_ != null && p_146984_1_.func_75216_d()) {
/* 168 */           ItemStack itemStack = p_146984_1_.func_75209_a((p_146984_3_ == 0) ? 1 : p_146984_1_.func_75211_c().func_77976_d());
/* 169 */           this.field_146297_k.field_71439_g.func_71019_a(itemStack, true);
/* 170 */           this.field_146297_k.field_71442_b.func_78752_a(itemStack);
/* 171 */         } else if (p_146984_4_ == 4 && this.field_146297_k.field_71439_g.field_71071_by.func_70445_o() != null) {
/* 172 */           this.field_146297_k.field_71439_g.func_71019_a(this.field_146297_k.field_71439_g.field_71071_by.func_70445_o(), true);
/* 173 */           this.field_146297_k.field_71442_b.func_78752_a(this.field_146297_k.field_71439_g.field_71071_by.func_70445_o());
/* 174 */           this.field_146297_k.field_71439_g.field_71071_by.func_70437_b(null);
/*     */         } else {
/* 176 */           this.field_146297_k.field_71439_g.field_71069_bz.func_75144_a((p_146984_1_ == null) ? p_146984_2_ : ((CreativeSlot)p_146984_1_).field_148332_b.field_75222_d, p_146984_3_, p_146984_4_, (EntityPlayer)this.field_146297_k.field_71439_g);
/* 177 */           this.field_146297_k.field_71439_g.field_71069_bz.func_75142_b();
/*     */         }
/*     */       
/* 180 */       } else if (p_146984_4_ != 5 && p_146984_1_.field_75224_c == field_147060_v) {
/*     */         
/* 182 */         InventoryPlayer inventoryPlayer = this.field_146297_k.field_71439_g.field_71071_by;
/* 183 */         ItemStack itemStack1 = inventoryPlayer.func_70445_o();
/* 184 */         ItemStack itemStack2 = p_146984_1_.func_75211_c();
/*     */         
/* 186 */         if (p_146984_4_ == 2) {
/* 187 */           if (itemStack2 != null && p_146984_3_ >= 0 && p_146984_3_ < 9) {
/* 188 */             ItemStack itemStack = itemStack2.func_77946_l();
/* 189 */             itemStack.field_77994_a = itemStack.func_77976_d();
/* 190 */             this.field_146297_k.field_71439_g.field_71071_by.func_70299_a(p_146984_3_, itemStack);
/* 191 */             this.field_146297_k.field_71439_g.field_71069_bz.func_75142_b();
/*     */           } 
/*     */           return;
/*     */         } 
/* 195 */         if (p_146984_4_ == 3) {
/* 196 */           if (inventoryPlayer.func_70445_o() == null && p_146984_1_.func_75216_d()) {
/* 197 */             ItemStack itemStack = p_146984_1_.func_75211_c().func_77946_l();
/* 198 */             itemStack.field_77994_a = itemStack.func_77976_d();
/* 199 */             inventoryPlayer.func_70437_b(itemStack);
/*     */           } 
/*     */           return;
/*     */         } 
/* 203 */         if (p_146984_4_ == 4) {
/* 204 */           if (itemStack2 != null) {
/* 205 */             ItemStack itemStack = itemStack2.func_77946_l();
/* 206 */             itemStack.field_77994_a = (p_146984_3_ == 0) ? 1 : itemStack.func_77976_d();
/* 207 */             this.field_146297_k.field_71439_g.func_71019_a(itemStack, true);
/* 208 */             this.field_146297_k.field_71442_b.func_78752_a(itemStack);
/*     */           } 
/*     */           
/*     */           return;
/*     */         } 
/*     */         
/* 214 */         if (itemStack1 != null && itemStack2 != null && itemStack1.func_77969_a(itemStack2)) {
/*     */           
/* 216 */           if (p_146984_3_ == 0) {
/* 217 */             if (bool)
/* 218 */             { itemStack1.field_77994_a = itemStack1.func_77976_d(); }
/*     */             
/* 220 */             else if (itemStack1.field_77994_a < itemStack1.func_77976_d()) { itemStack1.field_77994_a++; }
/*     */ 
/*     */           
/* 223 */           } else if (itemStack1.field_77994_a <= 1) {
/* 224 */             inventoryPlayer.func_70437_b(null);
/*     */           } else {
/* 226 */             itemStack1.field_77994_a--;
/*     */           }
/*     */         
/* 229 */         } else if (itemStack2 == null || itemStack1 != null) {
/*     */           
/* 231 */           inventoryPlayer.func_70437_b(null);
/*     */         } else {
/*     */           
/* 234 */           inventoryPlayer.func_70437_b(ItemStack.func_77944_b(itemStack2));
/* 235 */           itemStack1 = inventoryPlayer.func_70445_o();
/* 236 */           if (bool) {
/* 237 */             itemStack1.field_77994_a = itemStack1.func_77976_d();
/*     */           }
/*     */         } 
/*     */       } else {
/* 241 */         this.field_147002_h.func_75144_a((p_146984_1_ == null) ? p_146984_2_ : p_146984_1_.field_75222_d, p_146984_3_, p_146984_4_, (EntityPlayer)this.field_146297_k.field_71439_g);
/*     */         
/* 243 */         if (Container.func_94532_c(p_146984_3_) == 2) {
/* 244 */           for (byte b = 0; b < 9; b++) {
/* 245 */             this.field_146297_k.field_71442_b.func_78761_a(this.field_147002_h.func_75139_a(45 + b).func_75211_c(), 36 + b);
/*     */           }
/* 247 */         } else if (p_146984_1_ != null) {
/* 248 */           ItemStack itemStack = this.field_147002_h.func_75139_a(p_146984_1_.field_75222_d).func_75211_c();
/* 249 */           this.field_146297_k.field_71442_b.func_78761_a(itemStack, p_146984_1_.field_75222_d - this.field_147002_h.field_75151_b.size() + 9 + 36);
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       
/* 254 */       InventoryPlayer inventoryPlayer = this.field_146297_k.field_71439_g.field_71071_by;
/* 255 */       if (inventoryPlayer.func_70445_o() != null) {
/* 256 */         if (p_146984_3_ == 0) {
/* 257 */           this.field_146297_k.field_71439_g.func_71019_a(inventoryPlayer.func_70445_o(), true);
/* 258 */           this.field_146297_k.field_71442_b.func_78752_a(inventoryPlayer.func_70445_o());
/* 259 */           inventoryPlayer.func_70437_b(null);
/*     */         } 
/* 261 */         if (p_146984_3_ == 1) {
/* 262 */           ItemStack itemStack = inventoryPlayer.func_70445_o().func_77979_a(1);
/* 263 */           this.field_146297_k.field_71439_g.func_71019_a(itemStack, true);
/* 264 */           this.field_146297_k.field_71442_b.func_78752_a(itemStack);
/* 265 */           if ((inventoryPlayer.func_70445_o()).field_77994_a == 0) inventoryPlayer.func_70437_b(null);
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_73866_w_() {
/* 273 */     if (this.field_146297_k.field_71442_b.func_78758_h()) {
/* 274 */       super.func_73866_w_();
/* 275 */       this.field_146292_n.clear();
/*     */       
/* 277 */       Keyboard.enableRepeatEvents(true);
/*     */       
/* 279 */       this.field_147062_A = new GuiTextField(this.field_146289_q, this.field_147003_i + 82, this.field_147009_r + 6, 89, this.field_146289_q.field_78288_b);
/* 280 */       this.field_147062_A.func_146203_f(15);
/* 281 */       this.field_147062_A.func_146185_a(false);
/* 282 */       this.field_147062_A.func_146189_e(false);
/* 283 */       this.field_147062_A.func_146193_g(16777215);
/*     */       
/* 285 */       int i = field_147058_w;
/* 286 */       field_147058_w = -1;
/* 287 */       func_147050_b(CreativeTabs.field_78032_a[i]);
/*     */       
/* 289 */       this.field_147059_E = new CreativeCrafting(this.field_146297_k);
/* 290 */       this.field_146297_k.field_71439_g.field_71069_bz.func_75132_a(this.field_147059_E);
/*     */     } else {
/* 292 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiInventory((EntityPlayer)this.field_146297_k.field_71439_g));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/* 298 */     super.func_146281_b();
/*     */     
/* 300 */     if (this.field_146297_k.field_71439_g != null && this.field_146297_k.field_71439_g.field_71071_by != null) {
/* 301 */       this.field_146297_k.field_71439_g.field_71069_bz.func_82847_b(this.field_147059_E);
/*     */     }
/*     */     
/* 304 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/* 309 */     if (field_147058_w != CreativeTabs.field_78027_g.func_78021_a()) {
/* 310 */       if (GameSettings.func_100015_a(this.field_146297_k.field_71474_y.field_74310_D)) {
/* 311 */         func_147050_b(CreativeTabs.field_78027_g);
/*     */       } else {
/* 313 */         super.func_73869_a(p_73869_1_, p_73869_2_);
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/* 318 */     if (this.field_147057_D) {
/* 319 */       this.field_147057_D = false;
/* 320 */       this.field_147062_A.func_146180_a("");
/*     */     } 
/*     */     
/* 323 */     if (func_146983_a(p_73869_2_)) {
/*     */       return;
/*     */     }
/*     */     
/* 327 */     if (this.field_147062_A.func_146201_a(p_73869_1_, p_73869_2_)) {
/* 328 */       func_147053_i();
/*     */     } else {
/* 330 */       super.func_73869_a(p_73869_1_, p_73869_2_);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_147053_i() {
/* 335 */     ContainerCreative containerCreative = (ContainerCreative)this.field_147002_h;
/* 336 */     containerCreative.field_148330_a.clear();
/*     */     
/* 338 */     for (Item item : Item.field_150901_e) {
/* 339 */       if (item == null)
/*     */         continue; 
/* 341 */       if (item.func_77640_w() != null) {
/* 342 */         item.func_150895_a(item, null, containerCreative.field_148330_a);
/*     */       }
/*     */     } 
/*     */     
/* 346 */     for (Enchantment enchantment : Enchantment.field_77331_b) {
/* 347 */       if (enchantment != null && enchantment.field_77351_y != null)
/*     */       {
/* 349 */         Items.field_151134_bR.func_92113_a(enchantment, containerCreative.field_148330_a);
/*     */       }
/*     */     } 
/* 352 */     Iterator<ItemStack> iterator = containerCreative.field_148330_a.iterator();
/* 353 */     String str = this.field_147062_A.func_146179_b().toLowerCase();
/*     */     
/* 355 */     while (iterator.hasNext()) {
/* 356 */       ItemStack itemStack = iterator.next();
/* 357 */       boolean bool = false;
/*     */       
/* 359 */       for (String str1 : itemStack.func_82840_a((EntityPlayer)this.field_146297_k.field_71439_g, this.field_146297_k.field_71474_y.field_82882_x)) {
/* 360 */         if (str1.toLowerCase().contains(str)) {
/* 361 */           bool = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 366 */       if (!bool) iterator.remove();
/*     */     
/*     */     } 
/* 369 */     this.field_147067_x = 0.0F;
/* 370 */     containerCreative.func_148329_a(0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
/* 375 */     CreativeTabs creativeTabs = CreativeTabs.field_78032_a[field_147058_w];
/*     */     
/* 377 */     if (creativeTabs.func_78019_g()) {
/* 378 */       GL11.glDisable(3042);
/* 379 */       this.field_146289_q.func_78276_b(I18n.func_135052_a(creativeTabs.func_78024_c(), new Object[0]), 8, 6, 4210752);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 385 */     if (p_73864_3_ == 0) {
/* 386 */       int i = p_73864_1_ - this.field_147003_i;
/* 387 */       int j = p_73864_2_ - this.field_147009_r;
/*     */       
/* 389 */       for (CreativeTabs creativeTabs : CreativeTabs.field_78032_a) {
/* 390 */         if (func_147049_a(creativeTabs, i, j)) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 396 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146286_b(int p_146286_1_, int p_146286_2_, int p_146286_3_) {
/* 401 */     if (p_146286_3_ == 0) {
/* 402 */       int i = p_146286_1_ - this.field_147003_i;
/* 403 */       int j = p_146286_2_ - this.field_147009_r;
/*     */       
/* 405 */       for (CreativeTabs creativeTabs : CreativeTabs.field_78032_a) {
/* 406 */         if (func_147049_a(creativeTabs, i, j)) {
/* 407 */           func_147050_b(creativeTabs);
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/* 413 */     super.func_146286_b(p_146286_1_, p_146286_2_, p_146286_3_);
/*     */   }
/*     */   
/*     */   private boolean func_147055_p() {
/* 417 */     return (field_147058_w != CreativeTabs.field_78036_m.func_78021_a() && CreativeTabs.field_78032_a[field_147058_w].func_78017_i() && ((ContainerCreative)this.field_147002_h).func_148328_e());
/*     */   }
/*     */   
/*     */   private void func_147050_b(CreativeTabs p_147050_1_) {
/* 421 */     int i = field_147058_w;
/* 422 */     field_147058_w = p_147050_1_.func_78021_a();
/* 423 */     ContainerCreative containerCreative = (ContainerCreative)this.field_147002_h;
/*     */     
/* 425 */     this.field_147008_s.clear();
/* 426 */     containerCreative.field_148330_a.clear();
/* 427 */     p_147050_1_.func_78018_a(containerCreative.field_148330_a);
/*     */     
/* 429 */     if (p_147050_1_ == CreativeTabs.field_78036_m) {
/* 430 */       Container container = this.field_146297_k.field_71439_g.field_71069_bz;
/*     */       
/* 432 */       if (this.field_147063_B == null) this.field_147063_B = containerCreative.field_75151_b; 
/* 433 */       containerCreative.field_75151_b = new ArrayList();
/* 434 */       for (byte b = 0; b < container.field_75151_b.size(); b++) {
/* 435 */         CreativeSlot creativeSlot = new CreativeSlot(this, container.field_75151_b.get(b), b);
/* 436 */         containerCreative.field_75151_b.add(creativeSlot);
/*     */         
/* 438 */         if (b >= 5 && b < 9) {
/* 439 */           int j = b - 5;
/* 440 */           int k = j / 2;
/* 441 */           int m = j % 2;
/*     */           
/* 443 */           creativeSlot.field_75223_e = 9 + k * 54;
/* 444 */           creativeSlot.field_75221_f = 6 + m * 27;
/* 445 */         } else if (b >= 0 && b < 5) {
/* 446 */           creativeSlot.field_75221_f = -2000;
/* 447 */           creativeSlot.field_75223_e = -2000;
/* 448 */         } else if (b < container.field_75151_b.size()) {
/* 449 */           int j = b - 9;
/* 450 */           int k = j % 9;
/* 451 */           int m = j / 9;
/*     */           
/* 453 */           creativeSlot.field_75223_e = 9 + k * 18;
/*     */           
/* 455 */           if (b >= 36) {
/* 456 */             creativeSlot.field_75221_f = 112;
/*     */           } else {
/* 458 */             creativeSlot.field_75221_f = 54 + m * 18;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 463 */       this.field_147064_C = new Slot((IInventory)field_147060_v, 0, 173, 112);
/* 464 */       containerCreative.field_75151_b.add(this.field_147064_C);
/* 465 */     } else if (i == CreativeTabs.field_78036_m.func_78021_a()) {
/* 466 */       containerCreative.field_75151_b = this.field_147063_B;
/* 467 */       this.field_147063_B = null;
/*     */     } 
/*     */     
/* 470 */     if (this.field_147062_A != null) {
/* 471 */       if (p_147050_1_ == CreativeTabs.field_78027_g) {
/* 472 */         this.field_147062_A.func_146189_e(true);
/* 473 */         this.field_147062_A.func_146205_d(false);
/* 474 */         this.field_147062_A.func_146195_b(true);
/* 475 */         this.field_147062_A.func_146180_a("");
/* 476 */         func_147053_i();
/*     */       } else {
/* 478 */         this.field_147062_A.func_146189_e(false);
/* 479 */         this.field_147062_A.func_146205_d(true);
/* 480 */         this.field_147062_A.func_146195_b(false);
/*     */       } 
/*     */     }
/*     */     
/* 484 */     this.field_147067_x = 0.0F;
/* 485 */     containerCreative.func_148329_a(0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146274_d() {
/* 490 */     super.func_146274_d();
/*     */     
/* 492 */     int i = Mouse.getEventDWheel();
/* 493 */     if (i != 0 && func_147055_p()) {
/* 494 */       int j = ((ContainerCreative)this.field_147002_h).field_148330_a.size() / 9 - 5 + 1;
/* 495 */       if (i > 0) i = 1; 
/* 496 */       if (i < 0) i = -1; 
/* 497 */       this.field_147067_x = (float)(this.field_147067_x - i / j);
/* 498 */       if (this.field_147067_x < 0.0F) this.field_147067_x = 0.0F; 
/* 499 */       if (this.field_147067_x > 1.0F) this.field_147067_x = 1.0F; 
/* 500 */       ((ContainerCreative)this.field_147002_h).func_148329_a(this.field_147067_x);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 508 */     boolean bool = Mouse.isButtonDown(0);
/* 509 */     int i = this.field_147003_i;
/* 510 */     int j = this.field_147009_r;
/*     */     
/* 512 */     int k = i + 175;
/* 513 */     int m = j + 18;
/* 514 */     int n = k + 14;
/* 515 */     int i1 = m + 112;
/* 516 */     if (!this.field_147065_z && bool && 
/* 517 */       p_73863_1_ >= k && p_73863_2_ >= m && p_73863_1_ < n && p_73863_2_ < i1) {
/* 518 */       this.field_147066_y = func_147055_p();
/*     */     }
/*     */     
/* 521 */     if (!bool) this.field_147066_y = false; 
/* 522 */     this.field_147065_z = bool;
/*     */     
/* 524 */     if (this.field_147066_y) {
/* 525 */       this.field_147067_x = ((p_73863_2_ - m) - 7.5F) / ((i1 - m) - 15.0F);
/* 526 */       if (this.field_147067_x < 0.0F) this.field_147067_x = 0.0F; 
/* 527 */       if (this.field_147067_x > 1.0F) this.field_147067_x = 1.0F; 
/* 528 */       ((ContainerCreative)this.field_147002_h).func_148329_a(this.field_147067_x);
/*     */     } 
/*     */     
/* 531 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */     
/* 533 */     for (CreativeTabs creativeTabs : CreativeTabs.field_78032_a) {
/* 534 */       if (func_147052_b(creativeTabs, p_73863_1_, p_73863_2_))
/*     */         break; 
/*     */     } 
/* 537 */     if (this.field_147064_C != null && field_147058_w == CreativeTabs.field_78036_m.func_78021_a() && func_146978_c(this.field_147064_C.field_75223_e, this.field_147064_C.field_75221_f, 16, 16, p_73863_1_, p_73863_2_)) {
/* 538 */       func_146279_a(I18n.func_135052_a("inventory.binSlot", new Object[0]), p_73863_1_, p_73863_2_);
/*     */     }
/*     */     
/* 541 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 542 */     GL11.glDisable(2896);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146285_a(ItemStack p_146285_1_, int p_146285_2_, int p_146285_3_) {
/* 548 */     if (field_147058_w == CreativeTabs.field_78027_g.func_78021_a()) {
/* 549 */       List<String> list = p_146285_1_.func_82840_a((EntityPlayer)this.field_146297_k.field_71439_g, this.field_146297_k.field_71474_y.field_82882_x);
/*     */       
/* 551 */       CreativeTabs creativeTabs = p_146285_1_.func_77973_b().func_77640_w();
/*     */       
/* 553 */       if (creativeTabs == null && p_146285_1_.func_77973_b() == Items.field_151134_bR) {
/* 554 */         Map map = EnchantmentHelper.func_82781_a(p_146285_1_);
/*     */         
/* 556 */         if (map.size() == 1) {
/* 557 */           Enchantment enchantment = Enchantment.field_77331_b[((Integer)map.keySet().iterator().next()).intValue()];
/*     */           
/* 559 */           for (CreativeTabs creativeTabs1 : CreativeTabs.field_78032_a) {
/* 560 */             if (creativeTabs1.func_111226_a(enchantment.field_77351_y)) {
/* 561 */               creativeTabs = creativeTabs1;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 568 */       if (creativeTabs != null) {
/* 569 */         list.add(1, "" + EnumChatFormatting.BOLD + EnumChatFormatting.BLUE + I18n.func_135052_a(creativeTabs.func_78024_c(), new Object[0]));
/*     */       }
/*     */       
/* 572 */       for (byte b = 0; b < list.size(); b++) {
/* 573 */         if (b == 0) {
/* 574 */           list.set(b, (p_146285_1_.func_77953_t()).field_77937_e + (String)list.get(b));
/*     */         } else {
/* 576 */           list.set(b, EnumChatFormatting.GRAY + (String)list.get(b));
/*     */         } 
/*     */       } 
/*     */       
/* 580 */       func_146283_a(list, p_146285_2_, p_146285_3_);
/*     */     } else {
/* 582 */       super.func_146285_a(p_146285_1_, p_146285_2_, p_146285_3_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
/* 588 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 589 */     RenderHelper.func_74520_c();
/* 590 */     CreativeTabs creativeTabs = CreativeTabs.field_78032_a[field_147058_w];
/*     */     
/* 592 */     for (CreativeTabs creativeTabs1 : CreativeTabs.field_78032_a) {
/* 593 */       this.field_146297_k.func_110434_K().func_110577_a(field_147061_u);
/* 594 */       if (creativeTabs1.func_78021_a() != field_147058_w) func_147051_a(creativeTabs1);
/*     */     
/*     */     } 
/* 597 */     this.field_146297_k.func_110434_K().func_110577_a(new ResourceLocation("textures/gui/container/creative_inventory/tab_" + creativeTabs.func_78015_f()));
/* 598 */     func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
/*     */     
/* 600 */     this.field_147062_A.func_146194_f();
/* 601 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/* 603 */     int i = this.field_147003_i + 175;
/* 604 */     int j = this.field_147009_r + 18;
/* 605 */     int k = j + 112;
/* 606 */     this.field_146297_k.func_110434_K().func_110577_a(field_147061_u);
/*     */     
/* 608 */     if (creativeTabs.func_78017_i()) {
/* 609 */       func_73729_b(i, j + (int)((k - j - 17) * this.field_147067_x), 232 + (func_147055_p() ? 0 : 12), 0, 12, 15);
/*     */     }
/*     */     
/* 612 */     func_147051_a(creativeTabs);
/*     */     
/* 614 */     if (creativeTabs == CreativeTabs.field_78036_m) {
/* 615 */       GuiInventory.func_147046_a(this.field_147003_i + 43, this.field_147009_r + 45, 20, (this.field_147003_i + 43 - p_146976_2_), (this.field_147009_r + 45 - 30 - p_146976_3_), (EntityLivingBase)this.field_146297_k.field_71439_g);
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean func_147049_a(CreativeTabs p_147049_1_, int p_147049_2_, int p_147049_3_) {
/* 620 */     int i = p_147049_1_.func_78020_k();
/* 621 */     int j = 28 * i;
/* 622 */     int k = 0;
/*     */     
/* 624 */     if (i == 5) {
/* 625 */       j = this.field_146999_f - 28 + 2;
/* 626 */     } else if (i > 0) {
/* 627 */       j += i;
/*     */     } 
/*     */     
/* 630 */     if (p_147049_1_.func_78023_l()) {
/* 631 */       k -= true;
/*     */     } else {
/* 633 */       k += this.field_147000_g;
/*     */     } 
/*     */     
/* 636 */     return (p_147049_2_ >= j && p_147049_2_ <= j + 28 && p_147049_3_ >= k && p_147049_3_ <= k + 32);
/*     */   }
/*     */   
/*     */   protected boolean func_147052_b(CreativeTabs p_147052_1_, int p_147052_2_, int p_147052_3_) {
/* 640 */     int i = p_147052_1_.func_78020_k();
/* 641 */     int j = 28 * i;
/* 642 */     int k = 0;
/*     */     
/* 644 */     if (i == 5) {
/* 645 */       j = this.field_146999_f - 28 + 2;
/* 646 */     } else if (i > 0) {
/* 647 */       j += i;
/*     */     } 
/*     */     
/* 650 */     if (p_147052_1_.func_78023_l()) {
/* 651 */       k -= true;
/*     */     } else {
/* 653 */       k += this.field_147000_g;
/*     */     } 
/*     */     
/* 656 */     if (func_146978_c(j + 3, k + 3, 23, 27, p_147052_2_, p_147052_3_)) {
/* 657 */       func_146279_a(I18n.func_135052_a(p_147052_1_.func_78024_c(), new Object[0]), p_147052_2_, p_147052_3_);
/* 658 */       return true;
/*     */     } 
/*     */     
/* 661 */     return false;
/*     */   }
/*     */   
/*     */   protected void func_147051_a(CreativeTabs p_147051_1_) {
/* 665 */     boolean bool1 = (p_147051_1_.func_78021_a() == field_147058_w) ? true : false;
/* 666 */     boolean bool = p_147051_1_.func_78023_l();
/* 667 */     int i = p_147051_1_.func_78020_k();
/* 668 */     int j = i * 28;
/* 669 */     boolean bool2 = false;
/* 670 */     int k = this.field_147003_i + 28 * i;
/* 671 */     int m = this.field_147009_r;
/* 672 */     byte b = 32;
/*     */     
/* 674 */     if (bool1) {
/* 675 */       bool2 += true;
/*     */     }
/*     */     
/* 678 */     if (i == 5) {
/* 679 */       k = this.field_147003_i + this.field_146999_f - 28;
/* 680 */     } else if (i > 0) {
/* 681 */       k += i;
/*     */     } 
/*     */     
/* 684 */     if (bool) {
/* 685 */       m -= 28;
/*     */     } else {
/* 687 */       bool2 += true;
/* 688 */       m += this.field_147000_g - 4;
/*     */     } 
/*     */     
/* 691 */     GL11.glDisable(2896);
/* 692 */     func_73729_b(k, m, j, bool2, 28, b);
/*     */     
/* 694 */     this.field_73735_i = 100.0F;
/* 695 */     field_146296_j.field_77023_b = 100.0F;
/* 696 */     k += 6;
/* 697 */     m += 8 + (bool ? 1 : -1);
/*     */     
/* 699 */     GL11.glEnable(2896);
/* 700 */     GL11.glEnable(32826);
/* 701 */     ItemStack itemStack = p_147051_1_.func_151244_d();
/* 702 */     field_146296_j.func_82406_b(this.field_146289_q, this.field_146297_k.func_110434_K(), itemStack, k, m);
/* 703 */     field_146296_j.func_77021_b(this.field_146289_q, this.field_146297_k.func_110434_K(), itemStack, k, m);
/* 704 */     GL11.glDisable(2896);
/*     */     
/* 706 */     field_146296_j.field_77023_b = 0.0F;
/* 707 */     this.field_73735_i = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 712 */     if (p_146284_1_.field_146127_k == 0) {
/* 713 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiAchievements((GuiScreen)this, this.field_146297_k.field_71439_g.func_146107_m()));
/*     */     }
/* 715 */     if (p_146284_1_.field_146127_k == 1) {
/* 716 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiStats((GuiScreen)this, this.field_146297_k.field_71439_g.func_146107_m()));
/*     */     }
/*     */   }
/*     */   
/*     */   public int func_147056_g() {
/* 721 */     return field_147058_w;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   class CreativeSlot extends Slot { private final Slot field_148332_b;
/*     */     private static final String __OBFID = "CL_00000754";
/*     */     
/*     */     public CreativeSlot(GuiContainerCreative p_i1087_1_, Slot p_i1087_2_, int p_i1087_3_) {
/* 728 */       super(p_i1087_2_.field_75224_c, p_i1087_3_, 0, 0);
/* 729 */       this.field_148332_b = p_i1087_2_;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
/* 739 */       this.field_148332_b.func_82870_a(p_82870_1_, p_82870_2_);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_75214_a(ItemStack p_75214_1_) {
/* 744 */       return this.field_148332_b.func_75214_a(p_75214_1_);
/*     */     }
/*     */ 
/*     */     
/*     */     public ItemStack func_75211_c() {
/* 749 */       return this.field_148332_b.func_75211_c();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_75216_d() {
/* 754 */       return this.field_148332_b.func_75216_d();
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_75215_d(ItemStack p_75215_1_) {
/* 759 */       this.field_148332_b.func_75215_d(p_75215_1_);
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_75218_e() {
/* 764 */       this.field_148332_b.func_75218_e();
/*     */     }
/*     */ 
/*     */     
/*     */     public int func_75219_a() {
/* 769 */       return this.field_148332_b.func_75219_a();
/*     */     }
/*     */ 
/*     */     
/*     */     public IIcon func_75212_b() {
/* 774 */       return this.field_148332_b.func_75212_b();
/*     */     }
/*     */ 
/*     */     
/*     */     public ItemStack func_75209_a(int p_75209_1_) {
/* 779 */       return this.field_148332_b.func_75209_a(p_75209_1_);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_75217_a(IInventory p_75217_1_, int p_75217_2_) {
/* 784 */       return this.field_148332_b.func_75217_a(p_75217_1_, p_75217_2_);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\inventory\GuiContainerCreative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */