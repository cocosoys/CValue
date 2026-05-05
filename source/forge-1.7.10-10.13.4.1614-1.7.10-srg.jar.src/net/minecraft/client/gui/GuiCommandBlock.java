/*     */ package net.minecraft.client.gui;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.buffer.Unpooled;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.command.server.CommandBlockLogic;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.client.C17PacketCustomPayload;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiCommandBlock extends GuiScreen {
/*  17 */   private static final Logger field_146488_a = LogManager.getLogger(); private GuiTextField field_146485_f;
/*     */   private GuiTextField field_146486_g;
/*     */   private final CommandBlockLogic field_146489_h;
/*     */   private GuiButton field_146490_i;
/*     */   private GuiButton field_146487_r;
/*     */   private static final String __OBFID = "CL_00000748";
/*     */   
/*     */   public GuiCommandBlock(CommandBlockLogic p_i45032_1_) {
/*  25 */     this.field_146489_h = p_i45032_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  30 */     this.field_146485_f.func_146178_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  35 */     Keyboard.enableRepeatEvents(true);
/*  36 */     this.field_146292_n.clear();
/*  37 */     this.field_146292_n.add(this.field_146490_i = new GuiButton(0, this.field_146294_l / 2 - 4 - 150, this.field_146295_m / 4 + 120 + 12, 150, 20, I18n.func_135052_a("gui.done", new Object[0])));
/*  38 */     this.field_146292_n.add(this.field_146487_r = new GuiButton(1, this.field_146294_l / 2 + 4, this.field_146295_m / 4 + 120 + 12, 150, 20, I18n.func_135052_a("gui.cancel", new Object[0])));
/*     */     
/*  40 */     this.field_146485_f = new GuiTextField(this.field_146289_q, this.field_146294_l / 2 - 150, 50, 300, 20);
/*  41 */     this.field_146485_f.func_146203_f(32767);
/*  42 */     this.field_146485_f.func_146195_b(true);
/*  43 */     this.field_146485_f.func_146180_a(this.field_146489_h.func_145753_i());
/*     */     
/*  45 */     this.field_146486_g = new GuiTextField(this.field_146289_q, this.field_146294_l / 2 - 150, 135, 300, 20);
/*  46 */     this.field_146486_g.func_146203_f(32767);
/*  47 */     this.field_146486_g.func_146184_c(false);
/*  48 */     this.field_146486_g.func_146180_a(this.field_146489_h.func_145753_i());
/*     */     
/*  50 */     if (this.field_146489_h.func_145749_h() != null) {
/*  51 */       this.field_146486_g.func_146180_a(this.field_146489_h.func_145749_h().func_150260_c());
/*     */     }
/*     */     
/*  54 */     this.field_146490_i.field_146124_l = (this.field_146485_f.func_146179_b().trim().length() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/*  59 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/*  64 */     if (!p_146284_1_.field_146124_l)
/*  65 */       return;  if (p_146284_1_.field_146127_k == 1) {
/*  66 */       this.field_146297_k.func_147108_a(null);
/*  67 */     } else if (p_146284_1_.field_146127_k == 0) {
/*  68 */       PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
/*     */       
/*     */       try {
/*  71 */         packetBuffer.writeByte(this.field_146489_h.func_145751_f());
/*  72 */         this.field_146489_h.func_145757_a((ByteBuf)packetBuffer);
/*  73 */         packetBuffer.func_150785_a(this.field_146485_f.func_146179_b());
/*  74 */         this.field_146297_k.func_147114_u().func_147297_a((Packet)new C17PacketCustomPayload("MC|AdvCdm", (ByteBuf)packetBuffer));
/*  75 */       } catch (Exception exception) {
/*  76 */         field_146488_a.error("Couldn't send command block info", exception);
/*     */       } finally {
/*  78 */         packetBuffer.release();
/*     */       } 
/*     */       
/*  81 */       this.field_146297_k.func_147108_a(null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
/*  87 */     this.field_146485_f.func_146201_a(p_73869_1_, p_73869_2_);
/*  88 */     this.field_146486_g.func_146201_a(p_73869_1_, p_73869_2_);
/*  89 */     this.field_146490_i.field_146124_l = (this.field_146485_f.func_146179_b().trim().length() > 0);
/*     */     
/*  91 */     if (p_73869_2_ == 28 || p_73869_2_ == 156) {
/*  92 */       func_146284_a(this.field_146490_i);
/*  93 */     } else if (p_73869_2_ == 1) {
/*  94 */       func_146284_a(this.field_146487_r);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 100 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */     
/* 102 */     this.field_146485_f.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
/* 103 */     this.field_146486_g.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 108 */     func_146276_q_();
/*     */     
/* 110 */     func_73732_a(this.field_146289_q, I18n.func_135052_a("advMode.setCommand", new Object[0]), this.field_146294_l / 2, 20, 16777215);
/* 111 */     func_73731_b(this.field_146289_q, I18n.func_135052_a("advMode.command", new Object[0]), this.field_146294_l / 2 - 150, 37, 10526880);
/* 112 */     this.field_146485_f.func_146194_f();
/*     */     
/* 114 */     int i = 75;
/* 115 */     byte b = 0;
/*     */     
/* 117 */     func_73731_b(this.field_146289_q, I18n.func_135052_a("advMode.nearestPlayer", new Object[0]), this.field_146294_l / 2 - 150, i + b++ * this.field_146289_q.field_78288_b, 10526880);
/* 118 */     func_73731_b(this.field_146289_q, I18n.func_135052_a("advMode.randomPlayer", new Object[0]), this.field_146294_l / 2 - 150, i + b++ * this.field_146289_q.field_78288_b, 10526880);
/* 119 */     func_73731_b(this.field_146289_q, I18n.func_135052_a("advMode.allPlayers", new Object[0]), this.field_146294_l / 2 - 150, i + b++ * this.field_146289_q.field_78288_b, 10526880);
/*     */     
/* 121 */     if (this.field_146486_g.func_146179_b().length() > 0) {
/* 122 */       i += b * this.field_146289_q.field_78288_b + 20;
/* 123 */       func_73731_b(this.field_146289_q, I18n.func_135052_a("advMode.previousOutput", new Object[0]), this.field_146294_l / 2 - 150, i, 10526880);
/* 124 */       this.field_146486_g.func_146194_f();
/*     */     } 
/*     */     
/* 127 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiCommandBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */