/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
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
/*     */ public class ModelEnma
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Chair1;
/*     */   public ModelRenderer YemmaBody1;
/*     */   public ModelRenderer Desk1;
/*     */   public ModelRenderer Chair2;
/*     */   public ModelRenderer ChairBack1;
/*     */   public ModelRenderer ChairBack2;
/*     */   public ModelRenderer ChairBack3;
/*     */   public ModelRenderer ChairSideL1;
/*     */   public ModelRenderer ChairSideR1;
/*     */   public ModelRenderer ChairLeg1;
/*     */   public ModelRenderer ChairLeg2;
/*     */   public ModelRenderer ChairLeg3;
/*     */   public ModelRenderer ChairLeg4;
/*     */   public ModelRenderer ChairLegFoot1;
/*     */   public ModelRenderer ChairLegFoot2;
/*     */   public ModelRenderer ChairLegFoot3;
/*     */   public ModelRenderer ChairLegFoot4;
/*     */   public ModelRenderer ChairSideL2;
/*     */   public ModelRenderer ChairSideL3;
/*     */   public ModelRenderer ChairSideR2;
/*     */   public ModelRenderer ChairSideR3;
/*     */   public ModelRenderer YemmaBody2;
/*     */   public ModelRenderer YLeg1R;
/*     */   public ModelRenderer YLeg1L;
/*     */   public ModelRenderer YemmaBody3;
/*     */   public ModelRenderer YArm1L;
/*     */   public ModelRenderer YArm1R;
/*     */   public ModelRenderer Body4;
/*     */   public ModelRenderer YArm2L;
/*     */   public ModelRenderer YArm2R;
/*     */   public ModelRenderer Pen;
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Beard1;
/*     */   public ModelRenderer Horn1L;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Horn1R;
/*     */   public ModelRenderer Beard2R;
/*     */   public ModelRenderer Beard3L;
/*     */   public ModelRenderer Horn2L;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Horn2R;
/*     */   public ModelRenderer YLeg2R;
/*     */   public ModelRenderer YLeg3R;
/*     */   public ModelRenderer YLeg2L;
/*     */   public ModelRenderer YLeg3L;
/*     */   public ModelRenderer Desk2;
/*     */   public ModelRenderer DeskLegFR;
/*     */   public ModelRenderer DeskLegFL;
/*     */   public ModelRenderer DeskLegBR;
/*     */   public ModelRenderer DeskLegBL;
/*     */   private float animationPen1;
/*     */   private float animationPen2;
/*     */   
/*     */   public ModelEnma() {
/* 314 */     this.animationPen1 = 0.0F;
/* 315 */     this.animationPen2 = 0.0F; this.field_78090_t = 256; this.field_78089_u = 128; this.ChairBack3 = new ModelRenderer(this, 227, 40); this.ChairBack3.func_78793_a(0.0F, -5.8F, 6.0F); this.ChairBack3.func_78790_a(-6.0F, -6.6F, -0.8F, 12, 7, 2, 0.0F); setRotateAngle(this.ChairBack3, -0.034906585F, 0.0F, 0.0F); this.DeskLegBL = new ModelRenderer(this, 134, 103); this.DeskLegBL.field_78809_i = true; this.DeskLegBL.func_78793_a(16.3F, 1.5F, 2.8F); this.DeskLegBL.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 15, 3, 0.0F); this.YLeg2L = new ModelRenderer(this, 32, 98); this.YLeg2L.field_78809_i = true; this.YLeg2L.func_78793_a(0.3F, -0.2F, -3.9F); this.YLeg2L.func_78790_a(-2.6F, 0.1F, -2.2F, 5, 8, 4, 0.0F); setRotateAngle(this.YLeg2L, -0.2443461F, 0.0F, 0.0F); this.YArm2L = new ModelRenderer(this, 62, 57); this.YArm2L.field_78809_i = true; this.YArm2L.func_78793_a(0.0F, 4.6F, 0.0F); this.YArm2L.func_78790_a(-0.2F, 0.1F, -1.2F, 3, 9, 3, 0.0F); setRotateAngle(this.YArm2L, -0.9669124F, 0.04886922F, 0.2687807F); this.Beard2R = new ModelRenderer(this, 60, 30); this.Beard2R.func_78793_a(0.0F, -0.6F, 0.0F); this.Beard2R.func_78790_a(-5.0F, 1.5F, -1.0F, 4, 2, 2, 0.0F); this.ChairLegFoot2 = new ModelRenderer(this, 241, 87); this.ChairLegFoot2.func_78793_a(0.0F, 0.0F, 0.0F); this.ChairLegFoot2.func_78790_a(-1.0F, 1.0F, 5.8F, 2, 2, 2, 0.0F); setRotateAngle(this.ChairLegFoot2, 0.108210415F, 0.0F, 0.0F); this.Body4 = new ModelRenderer(this, 8, 32); this.Body4.func_78793_a(0.0F, -4.0F, -1.1F); this.Body4.func_78790_a(-6.0F, -0.4F, -2.3F, 12, 2, 6, 0.0F); this.ChairSideL1 = new ModelRenderer(this, 206, 52); this.ChairSideL1.func_78793_a(7.1F, 1.4F, 1.6F); this.ChairSideL1.func_78790_a(-0.5F, -5.7F, -0.5F, 1, 6, 1, 0.0F); setRotateAngle(this.ChairSideL1, 0.0F, 0.0F, 0.13962634F); this.Beard1 = new ModelRenderer(this, 59, 23); this.Beard1.func_78793_a(0.0F, 0.2F, -2.3F); this.Beard1.func_78790_a(-4.5F, -2.2F, -0.9F, 9, 4, 2, 0.0F); setRotateAngle(this.Beard1, -0.68294734F, 0.0F, 0.0F); this.Hair1 = new ModelRenderer(this, 22, 6); this.Hair1.func_78793_a(0.0F, -2.5F, 3.2F); this.Hair1.func_78790_a(-4.5F, 0.0F, -1.8F, 9, 4, 3, 0.0F); setRotateAngle(this.Hair1, 0.54454273F, 0.0F, 0.0F); this.Chair1 = new ModelRenderer(this, 203, 51); this.Chair1.func_78793_a(0.0F, 14.5F, 14.0F); this.Chair1.func_78790_a(-7.0F, 0.0F, -7.1F, 14, 2, 12, 0.0F); this.ChairSideL2 = new ModelRenderer(this, 206, 52); this.ChairSideL2.func_78793_a(0.0F, 0.0F, -5.2F); this.ChairSideL2.func_78790_a(-0.5F, -5.7F, -0.5F, 1, 6, 1, 0.0F); this.Chair2 = new ModelRenderer(this, 240, 66); this.Chair2.func_78793_a(0.0F, 0.0F, 0.0F); this.Chair2.func_78790_a(-1.0F, 2.0F, -1.0F, 2, 4, 2, 0.0F); this.ChairLegFoot4 = new ModelRenderer(this, 241, 87); this.ChairLegFoot4.func_78793_a(0.0F, 0.0F, 0.0F); this.ChairLegFoot4.func_78790_a(-1.0F, 1.0F, 5.8F, 2, 2, 2, 0.0F); setRotateAngle(this.ChairLegFoot4, 0.108210415F, 0.0F, 0.0F); this.Desk2 = new ModelRenderer(this, 137, 73); this.Desk2.func_78793_a(0.0F, 0.0F, 0.0F); this.Desk2.func_78790_a(-18.5F, 1.9F, -19.0F, 36, 2, 23, 0.0F); this.YArm1R = new ModelRenderer(this, 62, 44); this.YArm1R.func_78793_a(-8.7F, -1.5F, 0.0F); this.YArm1R.func_78790_a(-1.2F, -1.7F, -2.0F, 4, 7, 4, 0.0F); setRotateAngle(this.YArm1R, -0.62831855F, 0.017453292F, 0.2687807F); this.YLeg3R = new ModelRenderer(this, 52, 101); this.YLeg3R.func_78793_a(0.3F, 8.0F, -0.5F); this.YLeg3R.func_78790_a(-2.6F, 0.1F, -4.0F, 4, 3, 6, 0.0F); setRotateAngle(this.YLeg3R, 0.04712389F, 0.0F, 0.0F); this.Horn2R = new ModelRenderer(this, 48, 3); this.Horn2R.func_78793_a(-1.9F, 0.3F, 0.0F); this.Horn2R.func_78790_a(-2.7F, -0.8F, -0.5F, 3, 2, 2, 0.0F); setRotateAngle(this.Horn2R, 0.0F, 0.0F, 1.1838568F); this.Horn1R = new ModelRenderer(this, 47, 9); this.Horn1R.func_78793_a(-3.7F, -5.7F, 0.0F); this.Horn1R.func_78790_a(-2.7F, -0.8F, -0.5F, 4, 2, 2, 0.0F); setRotateAngle(this.Horn1R, 0.0F, 0.0F, 0.4712389F); this.Beard3L = new ModelRenderer(this, 60, 30); this.Beard3L.field_78809_i = true; this.Beard3L.func_78793_a(0.0F, -0.6F, 0.0F); this.Beard3L.func_78790_a(1.1F, 1.5F, -1.0F, 4, 2, 2, 0.0F); this.ChairLeg3 = new ModelRenderer(this, 234, 74); this.ChairLeg3.func_78793_a(0.0F, 6.5F, 0.0F); this.ChairLeg3.func_78790_a(-1.0F, -0.7F, -0.5F, 2, 1, 8, 0.0F); setRotateAngle(this.ChairLeg3, -0.108210415F, 2.3675392F, 0.0F); this.ChairSideR1 = new ModelRenderer(this, 206, 52); this.ChairSideR1.func_78793_a(-7.1F, 1.4F, 1.6F); this.ChairSideR1.func_78790_a(-0.5F, -5.7F, -0.5F, 1, 6, 1, 0.0F); setRotateAngle(this.ChairSideR1, 0.0F, 0.0F, -0.13962634F); this.DeskLegFL = new ModelRenderer(this, 134, 103); this.DeskLegFL.field_78809_i = true; this.DeskLegFL.func_78793_a(16.3F, 1.5F, -17.8F); this.DeskLegFL.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 15, 3, 0.0F); this.ChairSideR2 = new ModelRenderer(this, 206, 52); this.ChairSideR2.func_78793_a(0.0F, 0.0F, -5.2F); this.ChairSideR2.func_78790_a(-0.5F, -5.7F, -0.5F, 1, 6, 1, 0.0F); this.Horn2L = new ModelRenderer(this, 48, 3); this.Horn2L.field_78809_i = true; this.Horn2L.func_78793_a(2.4F, 0.5F, 0.0F); this.Horn2L.func_78790_a(-2.7F, -0.8F, -0.5F, 3, 2, 2, 0.0F); setRotateAngle(this.Horn2L, 0.0F, 0.0F, 1.9488347F); this.ChairLeg1 = new ModelRenderer(this, 234, 74); this.ChairLeg1.func_78793_a(0.0F, 6.5F, 0.0F); this.ChairLeg1.func_78790_a(-1.0F, -0.7F, -0.5F, 2, 1, 8, 0.0F); setRotateAngle(this.ChairLeg1, -0.108210415F, 1.2217305F, 0.0F); this.YArm1L = new ModelRenderer(this, 62, 44); this.YArm1L.field_78809_i = true; this.YArm1L.func_78793_a(7.2F, -1.5F, 0.0F); this.YArm1L.func_78790_a(-1.2F, -1.7F, -2.0F, 4, 7, 4, 0.0F); setRotateAngle(this.YArm1L, -0.62831855F, 0.017453292F, -0.2687807F); this.ChairLeg2 = new ModelRenderer(this, 234, 74); this.ChairLeg2.func_78793_a(0.0F, 6.5F, 0.0F); this.ChairLeg2.func_78790_a(-1.0F, -0.7F, -0.5F, 2, 1, 8, 0.0F); setRotateAngle(this.ChairLeg2, -0.108210415F, -1.2217305F, 0.0F); this.Head = new ModelRenderer(this, 53, 8); this.Head.func_78793_a(0.0F, -0.6F, -0.1F); this.Head.func_78790_a(-4.0F, -7.5F, -3.0F, 8, 8, 7, 0.0F); this.YLeg3L = new ModelRenderer(this, 52, 101); this.YLeg3L.field_78809_i = true; this.YLeg3L.func_78793_a(0.3F, 8.0F, -0.5F); this.YLeg3L.func_78790_a(-2.6F, 0.1F, -4.0F, 4, 3, 6, 0.0F); setRotateAngle(this.YLeg3L, 0.04712389F, 0.0F, 0.0F); this.ChairSideL3 = new ModelRenderer(this, 199, 38); this.ChairSideL3.func_78793_a(-0.2F, -6.0F, 0.0F); this.ChairSideL3.func_78790_a(-0.5F, -0.5F, -2.2F, 2, 1, 9, 0.0F); setRotateAngle(this.ChairSideL3, 0.0F, 0.0F, -0.10471976F); this.Horn1L = new ModelRenderer(this, 47, 9); this.Horn1L.field_78809_i = true; this.Horn1L.func_78793_a(3.6F, -5.8F, 0.0F); this.Horn1L.func_78790_a(-1.2F, -0.8F, -0.5F, 4, 2, 2, 0.0F); setRotateAngle(this.Horn1L, 0.0F, 0.0F, -0.4712389F); this.Desk1 = new ModelRenderer(this, 123, 99); this.Desk1.func_78793_a(0.0F, 7.4F, 0.0F); this.Desk1.func_78790_a(-20.5F, -0.1F, -20.4F, 40, 2, 26, 0.0F); this.ChairBack2 = new ModelRenderer(this, 246, 50); this.ChairBack2.func_78793_a(3.0F, 1.1F, 5.1F); this.ChairBack2.func_78790_a(-1.0F, -6.6F, -0.3F, 2, 7, 1, 0.0F); setRotateAngle(this.ChairBack2, -0.13962634F, 0.0F, 0.0F); this.YLeg1R = new ModelRenderer(this, 5, 100); this.YLeg1R.func_78793_a(-3.8F, 0.0F, -4.6F); this.YLeg1R.func_78790_a(-2.6F, -1.9F, -5.8F, 6, 4, 6, 0.0F); setRotateAngle(this.YLeg1R, 0.20071286F, 0.034906585F, 0.0F); this.YemmaBody1 = new ModelRenderer(this, 7, 79); this.YemmaBody1.func_78793_a(0.0F, 12.5F, 12.2F); this.YemmaBody1.func_78790_a(-6.5F, -2.0F, -5.0F, 13, 4, 12, 0.0F); this.ChairSideR3 = new ModelRenderer(this, 199, 38); this.ChairSideR3.func_78793_a(-0.2F, -6.0F, 0.0F); this.ChairSideR3.func_78790_a(-1.0F, -0.5F, -2.2F, 2, 1, 9, 0.0F); setRotateAngle(this.ChairSideR3, 0.0F, 0.0F, 0.10471976F); this.YLeg1L = new ModelRenderer(this, 5, 100); this.YLeg1L.field_78809_i = true; this.YLeg1L.func_78793_a(3.4F, 0.0F, -4.6F); this.YLeg1L.func_78790_a(-3.0F, -1.9F, -5.8F, 6, 4, 6, 0.0F); setRotateAngle(this.YLeg1L, 0.20071286F, -0.034906585F, 0.0F); this.ChairLegFoot3 = new ModelRenderer(this, 241, 87); this.ChairLegFoot3.func_78793_a(0.0F, 0.0F, 0.0F); this.ChairLegFoot3.func_78790_a(-1.0F, 1.0F, 5.8F, 2, 2, 2, 0.0F); setRotateAngle(this.ChairLegFoot3, 0.108210415F, 0.0F, 0.0F); this.YemmaBody3 = new ModelRenderer(this, 5, 41); this.YemmaBody3.func_78793_a(0.0F, -5.0F, -0.4F); this.YemmaBody3.func_78790_a(-6.5F, -3.2F, -5.6F, 13, 5, 11, 0.0F); this.YArm2R = new ModelRenderer(this, 62, 57); this.YArm2R.func_78793_a(0.0F, 4.6F, 0.0F); this.YArm2R.func_78790_a(-1.0F, 0.1F, -1.2F, 3, 9, 3, 0.0F); setRotateAngle(this.YArm2R, -0.9669124F, 0.04886922F, -0.2687807F); this.Pen = new ModelRenderer(this, 63, 69); this.Pen.func_78793_a(1.2F, 7.9F, -1.2F); this.Pen.func_78790_a(-0.5F, -0.5F, -2.3F, 1, 1, 5, 0.0F); setRotateAngle(this.Pen, 0.0F, 0.30543262F, 0.0F); this.YLeg2R = new ModelRenderer(this, 32, 98); this.YLeg2R.func_78793_a(0.3F, -0.2F, -3.9F); this.YLeg2R.func_78790_a(-2.6F, 0.1F, -2.2F, 5, 8, 4, 0.0F); setRotateAngle(this.YLeg2R, -0.2443461F, 0.0F, 0.0F); this.ChairBack1 = new ModelRenderer(this, 246, 50); this.ChairBack1.func_78793_a(-3.0F, 1.1F, 5.1F); this.ChairBack1.func_78790_a(-1.0F, -6.6F, -0.3F, 2, 7, 1, 0.0F); setRotateAngle(this.ChairBack1, -0.13962634F, 0.0F, 0.0F); this.DeskLegBR = new ModelRenderer(this, 134, 103); this.DeskLegBR.func_78793_a(-17.3F, 1.5F, 2.8F); this.DeskLegBR.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 15, 3, 0.0F); this.ChairLegFoot1 = new ModelRenderer(this, 241, 87); this.ChairLegFoot1.func_78793_a(0.0F, 0.0F, 0.0F); this.ChairLegFoot1.func_78790_a(-1.0F, 1.0F, 5.8F, 2, 2, 2, 0.0F); setRotateAngle(this.ChairLegFoot1, 0.108210415F, 0.0F, 0.0F); this.YemmaBody2 = new ModelRenderer(this, 6, 59); this.YemmaBody2.func_78793_a(0.0F, -3.7F, 0.6F); this.YemmaBody2.func_78790_a(-7.0F, -3.2F, -7.1F, 14, 5, 13, 0.0F); this.ChairLeg4 = new ModelRenderer(this, 234, 74); this.ChairLeg4.func_78793_a(0.0F, 6.5F, 0.0F); this.ChairLeg4.func_78790_a(-1.0F, -0.7F, -0.5F, 2, 1, 8, 0.0F); setRotateAngle(this.ChairLeg4, -0.108210415F, -2.3675392F, 0.0F); this.Hair2 = new ModelRenderer(this, 3, 7); this.Hair2.func_78793_a(0.0F, 3.6F, 0.4F); this.Hair2.func_78790_a(-3.5F, 0.0F, -0.9F, 7, 3, 2, 0.0F); setRotateAngle(this.Hair2, -0.24609143F, 0.0F, 0.0F); this.DeskLegFR = new ModelRenderer(this, 134, 103); this.DeskLegFR.func_78793_a(-17.3F, 1.5F, -17.8F); this.DeskLegFR.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 15, 3, 0.0F); this.Chair1.func_78792_a(this.ChairBack3); this.Desk2.func_78792_a(this.DeskLegBL); this.YLeg1L.func_78792_a(this.YLeg2L); this.YArm1L.func_78792_a(this.YArm2L); this.Beard1.func_78792_a(this.Beard2R); this.ChairLeg2.func_78792_a(this.ChairLegFoot2); this.YemmaBody3.func_78792_a(this.Body4); this.Chair1.func_78792_a(this.ChairSideL1); this.Head.func_78792_a(this.Beard1); this.Head.func_78792_a(this.Hair1); this.ChairSideL1.func_78792_a(this.ChairSideL2); this.Chair1.func_78792_a(this.Chair2); this.ChairLeg4.func_78792_a(this.ChairLegFoot4); this.Desk1.func_78792_a(this.Desk2); this.YemmaBody3.func_78792_a(this.YArm1R); this.YLeg2R.func_78792_a(this.YLeg3R); this.Horn1R.func_78792_a(this.Horn2R); this.Head.func_78792_a(this.Horn1R); this.Beard1.func_78792_a(this.Beard3L); this.Chair2.func_78792_a(this.ChairLeg3); this.Chair1.func_78792_a(this.ChairSideR1); this.Desk2.func_78792_a(this.DeskLegFL); this.ChairSideR1.func_78792_a(this.ChairSideR2); this.Horn1L.func_78792_a(this.Horn2L); this.Chair2.func_78792_a(this.ChairLeg1); this.YemmaBody3.func_78792_a(this.YArm1L); this.Chair2.func_78792_a(this.ChairLeg2); this.Body4.func_78792_a(this.Head); this.YLeg2L.func_78792_a(this.YLeg3L); this.ChairSideL2.func_78792_a(this.ChairSideL3); this.Head.func_78792_a(this.Horn1L); this.Chair1.func_78792_a(this.ChairBack2); this.YemmaBody1.func_78792_a(this.YLeg1R); this.ChairSideR2.func_78792_a(this.ChairSideR3); this.YemmaBody1.func_78792_a(this.YLeg1L); this.ChairLeg3.func_78792_a(this.ChairLegFoot3); this.YemmaBody2.func_78792_a(this.YemmaBody3); this.YArm1R.func_78792_a(this.YArm2R); this.YArm2R.func_78792_a(this.Pen); this.YLeg1R.func_78792_a(this.YLeg2R); this.Chair1.func_78792_a(this.ChairBack1); this.Desk2.func_78792_a(this.DeskLegBR);
/*     */     this.ChairLeg1.func_78792_a(this.ChairLegFoot1);
/*     */     this.YemmaBody1.func_78792_a(this.YemmaBody2);
/*     */     this.Chair2.func_78792_a(this.ChairLeg4);
/*     */     this.Hair1.func_78792_a(this.Hair2);
/* 320 */     this.Desk2.func_78792_a(this.DeskLegFR); } public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { float n4 = f3;
/* 321 */     float n5 = f4;
/* 322 */     float r2 = 180.0F;
/*     */     
/* 324 */     float headY = n4 / r2 / 3.1415927F;
/* 325 */     float headX = n5 / r2 / 3.1415927F * 0.3F;
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
/*     */ 
/*     */     
/* 346 */     int tick = entity.field_70173_aa;
/* 347 */     int animation = tick / 100;
/* 348 */     int animationTick = tick - animation * 100;
/*     */     
/* 350 */     if (!Minecraft.func_71410_x().func_147113_T()) {
/*     */       
/* 352 */       if (animationTick < 50) {
/*     */         
/* 354 */         this.animationPen1 += (-0.0F - MathHelper.func_76134_b(tick * 1.0F) * 1.2F) * 0.02F;
/* 355 */         this.animationPen2 += (-0.0F - MathHelper.func_76134_b(tick * 0.4F) * 1.2F) * 0.02F;
/*     */       }
/*     */       else {
/*     */         
/* 359 */         if (this.animationPen1 != 0.0F)
/*     */         {
/* 361 */           this.animationPen1 += -(this.animationPen1 / 10.0F);
/*     */         }
/* 363 */         if (this.animationPen2 != 0.0F)
/*     */         {
/* 365 */           this.animationPen2 += -(this.animationPen2 / 10.0F);
/*     */         }
/*     */       } 
/*     */       
/* 369 */       this.Pen.field_78795_f = this.animationPen1;
/*     */ 
/*     */       
/* 372 */       this.YArm2R.field_78796_g = 0.04886922F + -this.animationPen2 * 0.1F;
/* 373 */       this.YArm2R.field_78808_h = -0.2687807F + -this.animationPen2 * 0.1F;
/*     */     } 
/*     */     
/* 376 */     if (animationTick < 50) {
/*     */       
/* 378 */       this.Head.field_78795_f = 0.2F;
/* 379 */       this.Head.field_78796_g = 0.0F;
/*     */     }
/*     */     else {
/*     */       
/* 383 */       this.Head.field_78795_f = headX;
/* 384 */       this.Head.field_78796_g = headY;
/*     */     } 
/*     */     
/* 387 */     if (this.Head.field_78795_f > 0.0F) {
/*     */       
/* 389 */       this.Beard1.field_78795_f = -0.68294734F - this.Head.field_78795_f * 3.0F;
/*     */     }
/*     */     else {
/*     */       
/* 393 */       this.Beard1.field_78795_f = -0.68294734F;
/*     */     } 
/*     */ 
/*     */     
/* 397 */     GL11.glPushMatrix();
/* 398 */     GL11.glTranslatef(0.0F, 0.0F, -1.0F);
/*     */     
/* 400 */     float F = entity.field_70131_O / 2.0F;
/* 401 */     JGRenderHelper.modelScalePositionHelper(F);
/*     */     
/* 403 */     this.Chair1.func_78785_a(f5);
/* 404 */     this.YemmaBody1.func_78785_a(f5);
/* 405 */     if (JGConfigClientSettings.CLIENT_DA22)
/*     */     {
/*     */       
/* 408 */       this.Desk1.func_78785_a(f5);
/*     */     }
/*     */     
/* 411 */     GL11.glPopMatrix(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 419 */     modelRenderer.field_78795_f = x;
/* 420 */     modelRenderer.field_78796_g = y;
/* 421 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelEnma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */