/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Arrays;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.client.settings.KeyBinding;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import org.apache.commons.lang3.ArrayUtils;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiKeyBindingList
/*     */   extends GuiListExtended {
/*     */   private final GuiControls field_148191_k;
/*     */   private final Minecraft field_148189_l;
/*     */   private final GuiListExtended.IGuiListEntry[] field_148190_m;
/*  20 */   private int field_148188_n = 0; private static final String __OBFID = "CL_00000732";
/*     */   
/*     */   public GuiKeyBindingList(GuiControls p_i45031_1_, Minecraft p_i45031_2_) {
/*  23 */     super(p_i45031_2_, p_i45031_1_.field_146294_l, p_i45031_1_.field_146295_m, 63, p_i45031_1_.field_146295_m - 32, 20);
/*  24 */     this.field_148191_k = p_i45031_1_;
/*  25 */     this.field_148189_l = p_i45031_2_;
/*     */     
/*  27 */     KeyBinding[] arrayOfKeyBinding = (KeyBinding[])ArrayUtils.clone((Object[])p_i45031_2_.field_71474_y.field_74324_K);
/*  28 */     this.field_148190_m = new GuiListExtended.IGuiListEntry[arrayOfKeyBinding.length + KeyBinding.func_151467_c().size()];
/*     */     
/*  30 */     Arrays.sort((Object[])arrayOfKeyBinding);
/*     */     
/*  32 */     byte b = 0;
/*  33 */     String str = null;
/*     */     
/*  35 */     for (KeyBinding keyBinding : arrayOfKeyBinding) {
/*  36 */       String str1 = keyBinding.func_151466_e();
/*     */       
/*  38 */       if (!str1.equals(str)) {
/*  39 */         str = str1;
/*  40 */         this.field_148190_m[b++] = new CategoryEntry(this, str1);
/*     */       } 
/*     */       
/*  43 */       int i = p_i45031_2_.field_71466_p.func_78256_a(I18n.func_135052_a(keyBinding.func_151464_g(), new Object[0]));
/*  44 */       if (i > this.field_148188_n) this.field_148188_n = i; 
/*  45 */       this.field_148190_m[b++] = new KeyEntry(keyBinding);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_148127_b() {
/*  51 */     return this.field_148190_m.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiListExtended.IGuiListEntry func_148180_b(int p_148180_1_) {
/*  56 */     return this.field_148190_m[p_148180_1_];
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public class CategoryEntry implements GuiListExtended.IGuiListEntry {
/*     */     private final String field_148285_b;
/*     */     
/*     */     public CategoryEntry(GuiKeyBindingList p_i45028_1_, String p_i45028_2_) {
/*  64 */       this.field_148285_b = I18n.func_135052_a(p_i45028_2_, new Object[0]);
/*  65 */       this.field_148286_c = p_i45028_1_.field_148189_l.field_71466_p.func_78256_a(this.field_148285_b);
/*     */     }
/*     */     private final int field_148286_c; private static final String __OBFID = "CL_00000734";
/*     */     
/*     */     public void func_148279_a(int p_148279_1_, int p_148279_2_, int p_148279_3_, int p_148279_4_, int p_148279_5_, Tessellator p_148279_6_, int p_148279_7_, int p_148279_8_, boolean p_148279_9_) {
/*  70 */       this.field_148287_a.field_148189_l.field_71466_p.func_78276_b(this.field_148285_b, this.field_148287_a.field_148189_l.field_71462_r.field_146294_l / 2 - this.field_148286_c / 2, p_148279_3_ + p_148279_5_ - this.field_148287_a.field_148189_l.field_71466_p.field_78288_b - 1, 16777215);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_148278_a(int p_148278_1_, int p_148278_2_, int p_148278_3_, int p_148278_4_, int p_148278_5_, int p_148278_6_) {
/*  75 */       return false;
/*     */     }
/*     */     
/*     */     public void func_148277_b(int p_148277_1_, int p_148277_2_, int p_148277_3_, int p_148277_4_, int p_148277_5_, int p_148277_6_) {}
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public class KeyEntry
/*     */     implements GuiListExtended.IGuiListEntry {
/*     */     private final KeyBinding field_148282_b;
/*     */     private final String field_148283_c;
/*     */     private final GuiButton field_148280_d;
/*     */     private final GuiButton field_148281_e;
/*     */     private static final String __OBFID = "CL_00000735";
/*     */     
/*     */     private KeyEntry(GuiKeyBindingList p_i45029_1_, KeyBinding p_i45029_2_) {
/*  91 */       this.field_148282_b = p_i45029_2_;
/*  92 */       this.field_148283_c = I18n.func_135052_a(p_i45029_2_.func_151464_g(), new Object[0]);
/*  93 */       this.field_148280_d = new GuiButton(0, 0, 0, 75, 18, I18n.func_135052_a(p_i45029_2_.func_151464_g(), new Object[0]));
/*  94 */       this.field_148281_e = new GuiButton(0, 0, 0, 50, 18, I18n.func_135052_a("controls.reset", new Object[0]));
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148279_a(int p_148279_1_, int p_148279_2_, int p_148279_3_, int p_148279_4_, int p_148279_5_, Tessellator p_148279_6_, int p_148279_7_, int p_148279_8_, boolean p_148279_9_) {
/*  99 */       boolean bool1 = (this.field_148284_a.field_148191_k.field_146491_f == this.field_148282_b) ? true : false;
/* 100 */       this.field_148284_a.field_148189_l.field_71466_p.func_78276_b(this.field_148283_c, p_148279_2_ + 90 - this.field_148284_a.field_148188_n, p_148279_3_ + p_148279_5_ / 2 - this.field_148284_a.field_148189_l.field_71466_p.field_78288_b / 2, 16777215);
/*     */       
/* 102 */       this.field_148281_e.field_146128_h = p_148279_2_ + 190;
/* 103 */       this.field_148281_e.field_146129_i = p_148279_3_;
/* 104 */       this.field_148281_e.field_146124_l = (this.field_148282_b.func_151463_i() != this.field_148282_b.func_151469_h());
/* 105 */       this.field_148281_e.func_146112_a(this.field_148284_a.field_148189_l, p_148279_7_, p_148279_8_);
/*     */       
/* 107 */       this.field_148280_d.field_146128_h = p_148279_2_ + 105;
/* 108 */       this.field_148280_d.field_146129_i = p_148279_3_;
/* 109 */       this.field_148280_d.field_146126_j = GameSettings.func_74298_c(this.field_148282_b.func_151463_i());
/*     */       
/* 111 */       boolean bool2 = false;
/*     */       
/* 113 */       if (this.field_148282_b.func_151463_i() != 0) {
/* 114 */         for (KeyBinding keyBinding : this.field_148284_a.field_148189_l.field_71474_y.field_74324_K) {
/* 115 */           if (keyBinding != this.field_148282_b && keyBinding.func_151463_i() == this.field_148282_b.func_151463_i()) {
/* 116 */             bool2 = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 122 */       if (bool1) {
/* 123 */         this.field_148280_d.field_146126_j = EnumChatFormatting.WHITE + "> " + EnumChatFormatting.YELLOW + this.field_148280_d.field_146126_j + EnumChatFormatting.WHITE + " <";
/* 124 */       } else if (bool2) {
/* 125 */         this.field_148280_d.field_146126_j = EnumChatFormatting.RED + this.field_148280_d.field_146126_j;
/*     */       } 
/*     */       
/* 128 */       this.field_148280_d.func_146112_a(this.field_148284_a.field_148189_l, p_148279_7_, p_148279_8_);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_148278_a(int p_148278_1_, int p_148278_2_, int p_148278_3_, int p_148278_4_, int p_148278_5_, int p_148278_6_) {
/* 133 */       if (this.field_148280_d.func_146116_c(this.field_148284_a.field_148189_l, p_148278_2_, p_148278_3_)) {
/* 134 */         this.field_148284_a.field_148191_k.field_146491_f = this.field_148282_b;
/* 135 */         return true;
/* 136 */       }  if (this.field_148281_e.func_146116_c(this.field_148284_a.field_148189_l, p_148278_2_, p_148278_3_)) {
/* 137 */         this.field_148284_a.field_148189_l.field_71474_y.func_151440_a(this.field_148282_b, this.field_148282_b.func_151469_h());
/* 138 */         KeyBinding.func_74508_b();
/* 139 */         return true;
/*     */       } 
/* 141 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148277_b(int p_148277_1_, int p_148277_2_, int p_148277_3_, int p_148277_4_, int p_148277_5_, int p_148277_6_) {
/* 146 */       this.field_148280_d.func_146118_a(p_148277_2_, p_148277_3_);
/* 147 */       this.field_148281_e.func_146118_a(p_148277_2_, p_148277_3_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_148137_d() {
/* 153 */     return super.func_148137_d() + 15;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_148139_c() {
/* 158 */     return super.func_148139_c() + 32;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiKeyBindingList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */