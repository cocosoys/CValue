/*     */ package net.minecraft.client.gui.stream;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiSlot;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.stream.IngestServerTester;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import tv.twitch.broadcast.IngestServer;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiIngestServers extends GuiScreen {
/*     */   private final GuiScreen field_152309_a;
/*     */   private String field_152310_f;
/*     */   
/*     */   public GuiIngestServers(GuiScreen p_i1077_1_) {
/*  21 */     this.field_152309_a = p_i1077_1_;
/*     */   }
/*     */   private ServerList field_152311_g; private static final String __OBFID = "CL_00001843";
/*     */   
/*     */   public void func_73866_w_() {
/*  26 */     this.field_152310_f = I18n.func_135052_a("options.stream.ingest.title", new Object[0]);
/*  27 */     this.field_152311_g = new ServerList(this);
/*  28 */     if (!this.field_146297_k.func_152346_Z().func_152908_z()) this.field_146297_k.func_152346_Z().func_152909_x();
/*     */     
/*  30 */     this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 155, this.field_146295_m - 24 - 6, 150, 20, I18n.func_135052_a("gui.done", new Object[0])));
/*  31 */     this.field_146292_n.add(new GuiButton(2, this.field_146294_l / 2 + 5, this.field_146295_m - 24 - 6, 150, 20, I18n.func_135052_a("options.stream.ingest.reset", new Object[0])));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/*  36 */     if (this.field_146297_k.func_152346_Z().func_152908_z()) {
/*  37 */       this.field_146297_k.func_152346_Z().func_152932_y().func_153039_l();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  43 */     if (!p_146284_1_.field_146124_l)
/*     */       return; 
/*  45 */     if (p_146284_1_.field_146127_k == 1) {
/*  46 */       this.field_146297_k.func_147108_a(this.field_152309_a);
/*     */     } else {
/*  48 */       this.field_146297_k.field_71474_y.field_152407_Q = "";
/*  49 */       this.field_146297_k.field_71474_y.func_74303_b();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/*  55 */     func_146276_q_();
/*  56 */     this.field_152311_g.func_148128_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*  57 */     func_73732_a(this.field_146289_q, this.field_152310_f, this.field_146294_l / 2, 20, 16777215);
/*     */     
/*  59 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   class ServerList extends GuiSlot { private static final String __OBFID = "CL_00001842";
/*     */     public ServerList(GuiIngestServers p_i1075_1_) {
/*  64 */       super(p_i1075_1_.field_146297_k, p_i1075_1_.field_146294_l, p_i1075_1_.field_146295_m, 32, p_i1075_1_.field_146295_m - 35, (int)(p_i1075_1_.field_146297_k.field_71466_p.field_78288_b * 3.5D));
/*  65 */       func_148130_a(false);
/*     */     }
/*     */ 
/*     */     
/*     */     protected int func_148127_b() {
/*  70 */       return (this.field_152435_k.field_146297_k.func_152346_Z().func_152925_v()).length;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148144_a(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {
/*  75 */       this.field_152435_k.field_146297_k.field_71474_y.field_152407_Q = (this.field_152435_k.field_146297_k.func_152346_Z().func_152925_v()[p_148144_1_]).serverUrl;
/*  76 */       this.field_152435_k.field_146297_k.field_71474_y.func_74303_b();
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean func_148131_a(int p_148131_1_) {
/*  81 */       return (this.field_152435_k.field_146297_k.func_152346_Z().func_152925_v()[p_148131_1_]).serverUrl.equals(this.field_152435_k.field_146297_k.field_71474_y.field_152407_Q);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_148123_a() {}
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_148126_a(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Tessellator p_148126_5_, int p_148126_6_, int p_148126_7_) {
/*  91 */       IngestServer ingestServer = this.field_152435_k.field_146297_k.func_152346_Z().func_152925_v()[p_148126_1_];
/*  92 */       String str1 = ingestServer.serverUrl.replaceAll("\\{stream_key\\}", "");
/*  93 */       String str2 = (int)ingestServer.bitrateKbps + " kbps";
/*  94 */       String str3 = null;
/*  95 */       IngestServerTester ingestServerTester = this.field_152435_k.field_146297_k.func_152346_Z().func_152932_y();
/*     */       
/*  97 */       if (ingestServerTester != null) {
/*  98 */         if (ingestServer == ingestServerTester.func_153040_c()) {
/*  99 */           str1 = EnumChatFormatting.GREEN + str1;
/* 100 */           str2 = (int)(ingestServerTester.func_153030_h() * 100.0F) + "%";
/* 101 */         } else if (p_148126_1_ < ingestServerTester.func_153028_p()) {
/* 102 */           if (ingestServer.bitrateKbps == 0.0F) {
/* 103 */             str2 = EnumChatFormatting.RED + "Down!";
/*     */           }
/*     */         } else {
/* 106 */           str2 = EnumChatFormatting.OBFUSCATED + "1234" + EnumChatFormatting.RESET + " kbps";
/*     */         } 
/* 108 */       } else if (ingestServer.bitrateKbps == 0.0F) {
/* 109 */         str2 = EnumChatFormatting.RED + "Down!";
/*     */       } 
/*     */       
/* 112 */       p_148126_2_ -= 15;
/*     */       
/* 114 */       if (func_148131_a(p_148126_1_)) {
/* 115 */         str3 = EnumChatFormatting.BLUE + "(Preferred)";
/* 116 */       } else if (ingestServer.defaultServer) {
/* 117 */         str3 = EnumChatFormatting.GREEN + "(Default)";
/*     */       } 
/*     */       
/* 120 */       this.field_152435_k.func_73731_b(this.field_152435_k.field_146289_q, ingestServer.serverName, p_148126_2_ + 2, p_148126_3_ + 5, 16777215);
/* 121 */       this.field_152435_k.func_73731_b(this.field_152435_k.field_146289_q, str1, p_148126_2_ + 2, p_148126_3_ + this.field_152435_k.field_146289_q.field_78288_b + 5 + 3, 3158064);
/* 122 */       this.field_152435_k.func_73731_b(this.field_152435_k.field_146289_q, str2, func_148137_d() - 5 - this.field_152435_k.field_146289_q.func_78256_a(str2), p_148126_3_ + 5, 8421504);
/* 123 */       if (str3 != null) this.field_152435_k.func_73731_b(this.field_152435_k.field_146289_q, str3, func_148137_d() - 5 - this.field_152435_k.field_146289_q.func_78256_a(str3), p_148126_3_ + 5 + 3 + this.field_152435_k.field_146289_q.field_78288_b, 8421504);
/*     */     
/*     */     }
/*     */     
/*     */     protected int func_148137_d() {
/* 128 */       return super.func_148137_d() + 15;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\stream\GuiIngestServers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */