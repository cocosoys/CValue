/*     */ package net.minecraft.client.resources;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiListExtended;
/*     */ import net.minecraft.client.gui.GuiScreenResourcePacks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public abstract class ResourcePackListEntry implements GuiListExtended.IGuiListEntry {
/*  15 */   private static final ResourceLocation field_148316_c = new ResourceLocation("textures/gui/resource_packs.png");
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Minecraft field_148317_a;
/*     */ 
/*     */   
/*     */   protected final GuiScreenResourcePacks field_148315_b;
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00000821";
/*     */ 
/*     */ 
/*     */   
/*     */   public ResourcePackListEntry(GuiScreenResourcePacks p_i45051_1_) {
/*  30 */     this.field_148315_b = p_i45051_1_;
/*  31 */     this.field_148317_a = Minecraft.func_71410_x();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148279_a(int p_148279_1_, int p_148279_2_, int p_148279_3_, int p_148279_4_, int p_148279_5_, Tessellator p_148279_6_, int p_148279_7_, int p_148279_8_, boolean p_148279_9_) {
/*  36 */     func_148313_c();
/*     */     
/*  38 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  39 */     Gui.func_146110_a(p_148279_2_, p_148279_3_, 0.0F, 0.0F, 32, 32, 32.0F, 32.0F);
/*     */     
/*  41 */     if ((this.field_148317_a.field_71474_y.field_85185_A || p_148279_9_) && func_148310_d()) {
/*  42 */       this.field_148317_a.func_110434_K().func_110577_a(field_148316_c);
/*  43 */       Gui.func_73734_a(p_148279_2_, p_148279_3_, p_148279_2_ + 32, p_148279_3_ + 32, -1601138544);
/*  44 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  45 */       int j = p_148279_7_ - p_148279_2_;
/*  46 */       int k = p_148279_8_ - p_148279_3_;
/*     */       
/*  48 */       if (func_148309_e()) {
/*  49 */         if (j < 32) {
/*  50 */           Gui.func_146110_a(p_148279_2_, p_148279_3_, 0.0F, 32.0F, 32, 32, 256.0F, 256.0F);
/*     */         } else {
/*  52 */           Gui.func_146110_a(p_148279_2_, p_148279_3_, 0.0F, 0.0F, 32, 32, 256.0F, 256.0F);
/*     */         } 
/*     */       } else {
/*  55 */         if (func_148308_f()) {
/*  56 */           if (j < 16) {
/*  57 */             Gui.func_146110_a(p_148279_2_, p_148279_3_, 32.0F, 32.0F, 32, 32, 256.0F, 256.0F);
/*     */           } else {
/*  59 */             Gui.func_146110_a(p_148279_2_, p_148279_3_, 32.0F, 0.0F, 32, 32, 256.0F, 256.0F);
/*     */           } 
/*     */         }
/*  62 */         if (func_148314_g()) {
/*  63 */           if (j < 32 && j > 16 && k < 16) {
/*  64 */             Gui.func_146110_a(p_148279_2_, p_148279_3_, 96.0F, 32.0F, 32, 32, 256.0F, 256.0F);
/*     */           } else {
/*  66 */             Gui.func_146110_a(p_148279_2_, p_148279_3_, 96.0F, 0.0F, 32, 32, 256.0F, 256.0F);
/*     */           } 
/*     */         }
/*  69 */         if (func_148307_h()) {
/*  70 */           if (j < 32 && j > 16 && k > 16) {
/*  71 */             Gui.func_146110_a(p_148279_2_, p_148279_3_, 64.0F, 32.0F, 32, 32, 256.0F, 256.0F);
/*     */           } else {
/*  73 */             Gui.func_146110_a(p_148279_2_, p_148279_3_, 64.0F, 0.0F, 32, 32, 256.0F, 256.0F);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  80 */     String str = func_148312_b();
/*  81 */     int i = this.field_148317_a.field_71466_p.func_78256_a(str);
/*  82 */     if (i > 157) {
/*  83 */       str = this.field_148317_a.field_71466_p.func_78269_a(str, 157 - this.field_148317_a.field_71466_p.func_78256_a("...")) + "...";
/*     */     }
/*  85 */     this.field_148317_a.field_71466_p.func_78261_a(str, p_148279_2_ + 32 + 2, p_148279_3_ + 1, 16777215);
/*  86 */     List<String> list = this.field_148317_a.field_71466_p.func_78271_c(func_148311_a(), 157);
/*     */     
/*  88 */     for (byte b = 0; b < 2 && b < list.size(); b++) {
/*  89 */       this.field_148317_a.field_71466_p.func_78261_a(list.get(b), p_148279_2_ + 32 + 2, p_148279_3_ + 12 + 10 * b, 8421504);
/*     */     }
/*     */   }
/*     */   
/*     */   protected abstract String func_148311_a();
/*     */   
/*     */   protected abstract String func_148312_b();
/*     */   
/*     */   protected abstract void func_148313_c();
/*     */   
/*     */   protected boolean func_148310_d() {
/* 100 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean func_148309_e() {
/* 104 */     return !this.field_148315_b.func_146961_a(this);
/*     */   }
/*     */   
/*     */   protected boolean func_148308_f() {
/* 108 */     return this.field_148315_b.func_146961_a(this);
/*     */   }
/*     */   
/*     */   protected boolean func_148314_g() {
/* 112 */     List<ResourcePackListEntry> list = this.field_148315_b.func_146962_b(this);
/* 113 */     int i = list.indexOf(this);
/* 114 */     return (i > 0 && ((ResourcePackListEntry)list.get(i - 1)).func_148310_d());
/*     */   }
/*     */   
/*     */   protected boolean func_148307_h() {
/* 118 */     List<ResourcePackListEntry> list = this.field_148315_b.func_146962_b(this);
/* 119 */     int i = list.indexOf(this);
/* 120 */     return (i >= 0 && i < list.size() - 1 && ((ResourcePackListEntry)list.get(i + 1)).func_148310_d());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_148278_a(int p_148278_1_, int p_148278_2_, int p_148278_3_, int p_148278_4_, int p_148278_5_, int p_148278_6_) {
/* 125 */     if (func_148310_d() && p_148278_5_ <= 32) {
/* 126 */       if (func_148309_e()) {
/*     */         
/* 128 */         this.field_148315_b.func_146962_b(this).remove(this);
/* 129 */         this.field_148315_b.func_146963_h().add(0, this);
/* 130 */         return true;
/*     */       } 
/* 132 */       if (p_148278_5_ < 16 && func_148308_f()) {
/*     */         
/* 134 */         this.field_148315_b.func_146962_b(this).remove(this);
/* 135 */         this.field_148315_b.func_146964_g().add(0, this);
/* 136 */         return true;
/*     */       } 
/* 138 */       if (p_148278_5_ > 16 && p_148278_6_ < 16 && func_148314_g()) {
/*     */         
/* 140 */         List<ResourcePackListEntry> list = this.field_148315_b.func_146962_b(this);
/* 141 */         int i = list.indexOf(this);
/* 142 */         list.remove(this);
/* 143 */         list.add(i - 1, this);
/* 144 */         return true;
/*     */       } 
/* 146 */       if (p_148278_5_ > 16 && p_148278_6_ > 16 && func_148307_h()) {
/*     */         
/* 148 */         List<ResourcePackListEntry> list = this.field_148315_b.func_146962_b(this);
/* 149 */         int i = list.indexOf(this);
/* 150 */         list.remove(this);
/* 151 */         list.add(i + 1, this);
/* 152 */         return true;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 157 */     return false;
/*     */   }
/*     */   
/*     */   public void func_148277_b(int p_148277_1_, int p_148277_2_, int p_148277_3_, int p_148277_4_, int p_148277_5_, int p_148277_6_) {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\ResourcePackListEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */