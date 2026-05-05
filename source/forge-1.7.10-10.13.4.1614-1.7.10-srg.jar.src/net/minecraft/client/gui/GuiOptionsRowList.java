/*     */ package net.minecraft.client.gui;
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiOptionsRowList extends GuiListExtended {
/*  11 */   private final List field_148184_k = Lists.newArrayList(); private static final String __OBFID = "CL_00000677";
/*     */   
/*     */   public GuiOptionsRowList(Minecraft p_i45015_1_, int p_i45015_2_, int p_i45015_3_, int p_i45015_4_, int p_i45015_5_, int p_i45015_6_, GameSettings.Options... p_i45015_7_) {
/*  14 */     super(p_i45015_1_, p_i45015_2_, p_i45015_3_, p_i45015_4_, p_i45015_5_, p_i45015_6_);
/*  15 */     this.field_148163_i = false;
/*     */     
/*  17 */     for (byte b = 0; b < p_i45015_7_.length; b += 2) {
/*  18 */       GameSettings.Options options1 = p_i45015_7_[b];
/*  19 */       GameSettings.Options options2 = (b < p_i45015_7_.length - 1) ? p_i45015_7_[b + 1] : null;
/*  20 */       GuiButton guiButton1 = func_148182_a(p_i45015_1_, p_i45015_2_ / 2 - 155, 0, options1);
/*  21 */       GuiButton guiButton2 = func_148182_a(p_i45015_1_, p_i45015_2_ / 2 - 155 + 160, 0, options2);
/*     */       
/*  23 */       this.field_148184_k.add(new Row(guiButton1, guiButton2));
/*     */     } 
/*     */   }
/*     */   
/*     */   private GuiButton func_148182_a(Minecraft p_148182_1_, int p_148182_2_, int p_148182_3_, GameSettings.Options p_148182_4_) {
/*  28 */     if (p_148182_4_ == null) return null; 
/*  29 */     int i = p_148182_4_.func_74381_c();
/*  30 */     return p_148182_4_.func_74380_a() ? new GuiOptionSlider(i, p_148182_2_, p_148182_3_, p_148182_4_) : new GuiOptionButton(i, p_148182_2_, p_148182_3_, p_148182_4_, p_148182_1_.field_71474_y.func_74297_c(p_148182_4_));
/*     */   }
/*     */ 
/*     */   
/*     */   public Row func_148180_b(int p_148180_1_) {
/*  35 */     return this.field_148184_k.get(p_148180_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_148127_b() {
/*  40 */     return this.field_148184_k.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_148139_c() {
/*  45 */     return 400;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_148137_d() {
/*  50 */     return super.func_148137_d() + 32;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static class Row implements GuiListExtended.IGuiListEntry { private final Minecraft field_148325_a;
/*     */     private final GuiButton field_148323_b;
/*     */     private final GuiButton field_148324_c;
/*     */     private static final String __OBFID = "CL_00000678";
/*     */     
/*     */     public Row(GuiButton p_i45014_1_, GuiButton p_i45014_2_) {
/*  60 */       this.field_148325_a = Minecraft.func_71410_x();
/*  61 */       this.field_148323_b = p_i45014_1_;
/*  62 */       this.field_148324_c = p_i45014_2_;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148279_a(int p_148279_1_, int p_148279_2_, int p_148279_3_, int p_148279_4_, int p_148279_5_, Tessellator p_148279_6_, int p_148279_7_, int p_148279_8_, boolean p_148279_9_) {
/*  67 */       if (this.field_148323_b != null) {
/*  68 */         this.field_148323_b.field_146129_i = p_148279_3_;
/*  69 */         this.field_148323_b.func_146112_a(this.field_148325_a, p_148279_7_, p_148279_8_);
/*     */       } 
/*     */       
/*  72 */       if (this.field_148324_c != null) {
/*  73 */         this.field_148324_c.field_146129_i = p_148279_3_;
/*  74 */         this.field_148324_c.func_146112_a(this.field_148325_a, p_148279_7_, p_148279_8_);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_148278_a(int p_148278_1_, int p_148278_2_, int p_148278_3_, int p_148278_4_, int p_148278_5_, int p_148278_6_) {
/*  80 */       if (this.field_148323_b.func_146116_c(this.field_148325_a, p_148278_2_, p_148278_3_)) {
/*  81 */         if (this.field_148323_b instanceof GuiOptionButton) {
/*  82 */           this.field_148325_a.field_71474_y.func_74306_a(((GuiOptionButton)this.field_148323_b).func_146136_c(), 1);
/*  83 */           this.field_148323_b.field_146126_j = this.field_148325_a.field_71474_y.func_74297_c(GameSettings.Options.func_74379_a(this.field_148323_b.field_146127_k));
/*     */         } 
/*  85 */         return true;
/*  86 */       }  if (this.field_148324_c != null && this.field_148324_c.func_146116_c(this.field_148325_a, p_148278_2_, p_148278_3_)) {
/*  87 */         if (this.field_148324_c instanceof GuiOptionButton) {
/*  88 */           this.field_148325_a.field_71474_y.func_74306_a(((GuiOptionButton)this.field_148324_c).func_146136_c(), 1);
/*  89 */           this.field_148324_c.field_146126_j = this.field_148325_a.field_71474_y.func_74297_c(GameSettings.Options.func_74379_a(this.field_148324_c.field_146127_k));
/*     */         } 
/*  91 */         return true;
/*     */       } 
/*     */       
/*  94 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148277_b(int p_148277_1_, int p_148277_2_, int p_148277_3_, int p_148277_4_, int p_148277_5_, int p_148277_6_) {
/*  99 */       if (this.field_148323_b != null) this.field_148323_b.func_146118_a(p_148277_2_, p_148277_3_); 
/* 100 */       if (this.field_148324_c != null) this.field_148324_c.func_146118_a(p_148277_2_, p_148277_3_); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiOptionsRowList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */