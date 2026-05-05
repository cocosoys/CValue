/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.resources.ResourcePackListEntry;
/*     */ import net.minecraft.client.resources.ResourcePackListEntryDefault;
/*     */ import net.minecraft.client.resources.ResourcePackListEntryFound;
/*     */ import net.minecraft.client.resources.ResourcePackRepository;
/*     */ import net.minecraft.util.Util;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.Sys;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiScreenResourcePacks
/*     */   extends GuiScreen
/*     */ {
/*  27 */   private static final Logger field_146968_a = LogManager.getLogger();
/*     */   
/*     */   private GuiScreen field_146965_f;
/*     */   
/*     */   private List field_146966_g;
/*     */   
/*     */   private List field_146969_h;
/*     */   
/*     */   private GuiResourcePackAvailable field_146970_i;
/*     */   private GuiResourcePackSelected field_146967_r;
/*     */   private static final String __OBFID = "CL_00000820";
/*     */   
/*     */   public GuiScreenResourcePacks(GuiScreen p_i45050_1_) {
/*  40 */     this.field_146965_f = p_i45050_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  45 */     this.field_146292_n.add(new GuiOptionButton(2, this.field_146294_l / 2 - 154, this.field_146295_m - 48, I18n.func_135052_a("resourcePack.openFolder", new Object[0])));
/*  46 */     this.field_146292_n.add(new GuiOptionButton(1, this.field_146294_l / 2 + 4, this.field_146295_m - 48, I18n.func_135052_a("gui.done", new Object[0])));
/*     */     
/*  48 */     this.field_146966_g = new ArrayList();
/*  49 */     this.field_146969_h = new ArrayList();
/*     */     
/*  51 */     ResourcePackRepository resourcePackRepository = this.field_146297_k.func_110438_M();
/*  52 */     resourcePackRepository.func_110611_a();
/*  53 */     ArrayList arrayList = Lists.newArrayList(resourcePackRepository.func_110609_b());
/*  54 */     arrayList.removeAll(resourcePackRepository.func_110613_c());
/*  55 */     for (ResourcePackRepository.Entry entry : arrayList) {
/*  56 */       this.field_146966_g.add(new ResourcePackListEntryFound(this, entry));
/*     */     }
/*  58 */     for (ResourcePackRepository.Entry entry : Lists.reverse(resourcePackRepository.func_110613_c())) {
/*  59 */       this.field_146969_h.add(new ResourcePackListEntryFound(this, entry));
/*     */     }
/*     */     
/*  62 */     this.field_146969_h.add(new ResourcePackListEntryDefault(this));
/*     */     
/*  64 */     this.field_146970_i = new GuiResourcePackAvailable(this.field_146297_k, 200, this.field_146295_m, this.field_146966_g);
/*  65 */     this.field_146970_i.func_148140_g(this.field_146294_l / 2 - 4 - 200);
/*  66 */     this.field_146970_i.func_148134_d(7, 8);
/*  67 */     this.field_146967_r = new GuiResourcePackSelected(this.field_146297_k, 200, this.field_146295_m, this.field_146969_h);
/*  68 */     this.field_146967_r.func_148140_g(this.field_146294_l / 2 + 4);
/*  69 */     this.field_146967_r.func_148134_d(7, 8);
/*     */   }
/*     */   
/*     */   public boolean func_146961_a(ResourcePackListEntry p_146961_1_) {
/*  73 */     return this.field_146969_h.contains(p_146961_1_);
/*     */   }
/*     */   
/*     */   public List func_146962_b(ResourcePackListEntry p_146962_1_) {
/*  77 */     if (func_146961_a(p_146962_1_)) {
/*  78 */       return this.field_146969_h;
/*     */     }
/*  80 */     return this.field_146966_g;
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_146964_g() {
/*  85 */     return this.field_146966_g;
/*     */   }
/*     */   
/*     */   public List func_146963_h() {
/*  89 */     return this.field_146969_h;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  94 */     if (!p_146284_1_.field_146124_l)
/*     */       return; 
/*  96 */     if (p_146284_1_.field_146127_k == 2) {
/*  97 */       File file = this.field_146297_k.func_110438_M().func_110612_e();
/*  98 */       String str = file.getAbsolutePath();
/*     */       
/* 100 */       if (Util.func_110647_a() == Util.EnumOS.OSX) {
/*     */         try {
/* 102 */           field_146968_a.info(str);
/* 103 */           Runtime.getRuntime().exec(new String[] { "/usr/bin/open", str });
/*     */ 
/*     */           
/*     */           return;
/* 107 */         } catch (IOException iOException) {
/* 108 */           field_146968_a.error("Couldn't open file", iOException);
/*     */         } 
/* 110 */       } else if (Util.func_110647_a() == Util.EnumOS.WINDOWS) {
/*     */ 
/*     */         
/* 113 */         String str1 = String.format("cmd.exe /C start \"Open file\" \"%s\"", new Object[] { str });
/*     */         try {
/* 115 */           Runtime.getRuntime().exec(str1);
/*     */           return;
/* 117 */         } catch (IOException iOException) {
/* 118 */           field_146968_a.error("Couldn't open file", iOException);
/*     */         } 
/*     */       } 
/*     */       
/* 122 */       boolean bool = false;
/*     */       try {
/* 124 */         Class<?> clazz = Class.forName("java.awt.Desktop");
/* 125 */         Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
/* 126 */         clazz.getMethod("browse", new Class[] { URI.class }).invoke(object, new Object[] { file.toURI() });
/* 127 */       } catch (Throwable throwable) {
/* 128 */         field_146968_a.error("Couldn't open link", throwable);
/* 129 */         bool = true;
/*     */       } 
/* 131 */       if (bool) {
/* 132 */         field_146968_a.info("Opening via system class!");
/* 133 */         Sys.openURL("file://" + str);
/*     */       } 
/* 135 */     } else if (p_146284_1_.field_146127_k == 1) {
/* 136 */       ArrayList<ResourcePackRepository.Entry> arrayList = Lists.newArrayList();
/* 137 */       for (ResourcePackListEntry resourcePackListEntry : this.field_146969_h) {
/* 138 */         if (resourcePackListEntry instanceof ResourcePackListEntryFound) {
/* 139 */           arrayList.add(((ResourcePackListEntryFound)resourcePackListEntry).func_148318_i());
/*     */         }
/*     */       } 
/* 142 */       Collections.reverse(arrayList);
/* 143 */       this.field_146297_k.func_110438_M().func_148527_a(arrayList);
/* 144 */       this.field_146297_k.field_71474_y.field_151453_l.clear();
/*     */       
/* 146 */       for (ResourcePackRepository.Entry entry : arrayList) {
/* 147 */         this.field_146297_k.field_71474_y.field_151453_l.add(entry.func_110515_d());
/*     */       }
/*     */       
/* 150 */       this.field_146297_k.field_71474_y.func_74303_b();
/* 151 */       this.field_146297_k.func_110436_a();
/* 152 */       this.field_146297_k.func_147108_a(this.field_146965_f);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 158 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/* 159 */     this.field_146970_i.func_148179_a(p_73864_1_, p_73864_2_, p_73864_3_);
/* 160 */     this.field_146967_r.func_148179_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146286_b(int p_146286_1_, int p_146286_2_, int p_146286_3_) {
/* 165 */     super.func_146286_b(p_146286_1_, p_146286_2_, p_146286_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 170 */     func_146278_c(0);
/*     */     
/* 172 */     this.field_146970_i.func_148128_a(p_73863_1_, p_73863_2_, p_73863_3_);
/* 173 */     this.field_146967_r.func_148128_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */     
/* 175 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("resourcePack.title", new Object[0]), this.field_146294_l / 2, 16, 16777215);
/* 176 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("resourcePack.folderInfo", new Object[0]), this.field_146294_l / 2 - 77, this.field_146295_m - 26, 8421504);
/*     */     
/* 178 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiScreenResourcePacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */