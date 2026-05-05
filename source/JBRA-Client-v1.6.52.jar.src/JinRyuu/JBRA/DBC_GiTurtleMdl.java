/*     */ package JinRyuu.JBRA;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreHJYC;
/*     */ import JinRyuu.JRMCore.entity.ModelBipedBody;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DBC_GiTurtleMdl
/*     */   extends ModelBipedBody
/*     */ {
/*  18 */   private final int VANITY_ANDROID_21_COAT = 0; private final int VANITY_ANDROID_21_BOOT = 1; private final int VANITY_HALO = 2; private final int VANITY_ANGEL_HALO = 3; private final int VANITY_BARRIER_OF_LIGHT = 4;
/*  19 */   public int id = -1;
/*     */   
/*     */   public ModelRenderer Rarm;
/*     */   
/*     */   public ModelRenderer tail;
/*     */   
/*     */   public ModelRenderer body;
/*     */   
/*     */   public ModelRenderer Larm;
/*     */   
/*     */   public ModelRenderer RRolledSleeve;
/*     */   
/*     */   public ModelRenderer LRolledSleee;
/*     */   
/*     */   public ModelRenderer Rleg;
/*     */   
/*     */   public ModelRenderer Lleg;
/*     */   
/*     */   public ModelRenderer halo;
/*     */   
/*     */   public ModelRenderer halo1;
/*     */   public ModelRenderer halo2;
/*     */   public ModelRenderer halo3;
/*     */   public ModelRenderer halo4;
/*     */   public ModelRenderer NeckRing;
/*     */   public ModelRenderer NeckRing_1;
/*     */   public ModelRenderer NeckRing_2;
/*     */   public ModelRenderer NeckRing_3;
/*     */   public ModelRenderer NeckRing_4;
/*     */   public ModelRenderer NeckRing_5;
/*     */   public ModelRenderer NeckRing_6;
/*     */   public ModelRenderer NeckRing_7;
/*     */   public ModelRenderer BoL_Base;
/*     */   public ModelRenderer BoL_Top;
/*     */   public ModelRenderer BoL_InnerTop;
/*     */   public ModelRenderer BoL_LBase;
/*     */   public ModelRenderer BoL_RBase;
/*     */   public ModelRenderer SpikeTop;
/*     */   public ModelRenderer SpikeBottom;
/*     */   public ModelRenderer BoL_InnerL;
/*     */   public ModelRenderer BoL_InnerR;
/*     */   public ModelRenderer BoL_InnerLB;
/*     */   public ModelRenderer BoL_InnerLT;
/*     */   public ModelRenderer SpikeL;
/*     */   public ModelRenderer BoL_InnerLT2;
/*     */   public ModelRenderer BoL_InnerRB;
/*     */   public ModelRenderer BoL_InnerRT;
/*     */   public ModelRenderer SpikeR;
/*     */   public ModelRenderer BoL_InnerRT2;
/*     */   public ModelRenderer BoL_LBase2;
/*     */   public ModelRenderer BoL_LTBase2;
/*     */   public ModelRenderer BoL_LBase3;
/*     */   public ModelRenderer BoL_LTBase3;
/*     */   public ModelRenderer BoL_RBase2;
/*     */   public ModelRenderer BoL_RTBase2;
/*     */   public ModelRenderer BoL_RBase3;
/*     */   public ModelRenderer BoL_RTBase3;
/*     */   private float size;
/*     */   
/*     */   public DBC_GiTurtleMdl(int id) {
/*  79 */     super(0.1F);
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
/* 306 */     this.size = 1.0F; this.id = id; if (id == 0) { this.field_78090_t = 64; this.field_78089_u = 32; this.RRolledSleeve = new ModelRenderer((ModelBase)this, 21, 12); this.RRolledSleeve.func_78793_a(0.0F, 0.0F, 0.0F); this.RRolledSleeve.func_78790_a(-3.8F, 1.7F, -2.5F, 5, 3, 5, 0.05F); this.Larm = new ModelRenderer((ModelBase)this, 42, 1); this.Larm.func_78793_a(5.0F, 2.0F, 0.0F); this.Larm.func_78790_a(-1.0F, -2.1F, -2.0F, 4, 5, 4, 0.3F); this.tail = new ModelRenderer((ModelBase)this, 0, 17); this.tail.func_78793_a(0.0F, 11.8F, 1.9F); this.tail.func_78790_a(-4.0F, -1.0F, 0.2F, 8, 10, 1, 0.5F); setRotateAngle(this.tail, 0.18203785F, 0.0F, 0.0F); this.body = new ModelRenderer((ModelBase)this, 0, 0); this.body.func_78793_a(0.0F, 0.0F, 0.0F); this.body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.1F); this.LRolledSleee = new ModelRenderer((ModelBase)this, 43, 12); this.LRolledSleee.func_78793_a(0.0F, 0.0F, 0.0F); this.LRolledSleee.func_78790_a(-1.2F, 1.7F, -2.5F, 5, 3, 5, 0.05F); this.Rarm = new ModelRenderer((ModelBase)this, 25, 1); this.Rarm.func_78793_a(-5.0F, 2.0F, 0.0F); this.Rarm.func_78790_a(-3.0F, -2.1F, -2.0F, 4, 5, 4, 0.3F); this.Rarm.func_78792_a(this.RRolledSleeve); this.Larm.func_78792_a(this.LRolledSleee); this.body.func_78792_a(this.tail); } else if (id == 1) { this.field_78090_t = 32; this.field_78089_u = 16; this.Rleg = new ModelRenderer((ModelBase)this, 0, 0); this.Rleg.func_78793_a(-1.9F, 12.0F, 0.01F); this.Rleg.func_78790_a(-2.0F, 9.0F, -2.0F, 4, 3, 4, 0.4F); this.Lleg = new ModelRenderer((ModelBase)this, 16, 0); this.Lleg.func_78793_a(1.9F, 12.0F, 0.0F); this.Lleg.func_78790_a(-2.0F, 9.0F, -2.0F, 4, 3, 4, 0.41F); }
/*     */     else if (id == 2) { this.halo = new ModelRenderer((ModelBase)this, 0, 40); this.halo.func_78789_a(-0.0F, -0.0F, -0.0F, 0, 0, 0); this.halo.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.halo, 0.0F, 0.0F, 0.0F); this.halo1 = new ModelRenderer((ModelBase)this, 0, 40); this.halo1.func_78789_a(-4.0F, -13.0F, -5.0F, 9, 1, 1); this.halo1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.halo1, 0.0F, 0.0F, 0.0F); this.halo2 = new ModelRenderer((ModelBase)this, 0, 40); this.halo2.func_78789_a(-5.0F, -13.0F, -5.0F, 1, 1, 9); this.halo2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.halo2, 0.0F, 0.0F, 0.0F); this.halo3 = new ModelRenderer((ModelBase)this, 0, 40); this.halo3.func_78789_a(4.0F, -13.0F, -4.0F, 1, 1, 9); this.halo3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.halo3, 0.0F, 0.0F, 0.0F); this.halo4 = new ModelRenderer((ModelBase)this, 0, 40); this.halo4.func_78789_a(-5.0F, -13.0F, 4.0F, 9, 1, 1); this.halo4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.halo4, 0.0F, 0.0F, 0.0F); this.halo.func_78792_a(this.halo1); this.halo.func_78792_a(this.halo2); this.halo.func_78792_a(this.halo3); this.halo.func_78792_a(this.halo4); }
/*     */     else if (id == 3) { this.NeckRing_3 = new ModelRenderer((ModelBase)this, 0, 0); this.NeckRing_3.func_78793_a(0.0F, 0.0F, 0.0F); this.NeckRing_3.func_78790_a(-8.7F, -3.2F, -3.2F, 2, 1, 7, 0.0F); setRotateAngle(this.NeckRing_3, 0.0F, -0.8290314F, 0.0F); this.NeckRing_5 = new ModelRenderer((ModelBase)this, 0, 0); this.NeckRing_5.func_78793_a(0.0F, 0.0F, 0.0F); this.NeckRing_5.func_78790_a(-8.3F, -3.2F, -3.3F, 2, 1, 7, 0.0F); setRotateAngle(this.NeckRing_5, 0.0F, -0.7841764F, 0.0F); this.NeckRing = new ModelRenderer((ModelBase)this, 0, 10); this.NeckRing.func_78793_a(0.0F, 0.0F, 0.0F); this.NeckRing.func_78790_a(-3.5F, -3.2F, 7.9F, 7, 1, 2, 0.0F); setRotateAngle(this.NeckRing, 0.59184116F, 0.0F, 0.0F); this.NeckRing_2 = new ModelRenderer((ModelBase)this, 19, 0); this.NeckRing_2.func_78793_a(0.0F, 0.0F, 0.0F); this.NeckRing_2.func_78790_a(-8.7F, -3.2F, -3.9F, 2, 1, 9, 0.0F); setRotateAngle(this.NeckRing_2, 0.0F, -0.82833326F, 0.0F); this.NeckRing_1 = new ModelRenderer((ModelBase)this, 0, 0); this.NeckRing_1.func_78793_a(0.0F, 0.0F, 0.0F); this.NeckRing_1.func_78790_a(-9.7F, -3.2F, -2.9F, 2, 1, 7, 0.0F); setRotateAngle(this.NeckRing_1, 0.0F, 0.8342674F, 0.0F); this.NeckRing_7 = new ModelRenderer((ModelBase)this, 0, 0); this.NeckRing_7.func_78793_a(0.0F, 0.0F, 0.0F); this.NeckRing_7.func_78790_a(-9.6F, -3.2F, -4.2F, 2, 1, 7, 0.0F); setRotateAngle(this.NeckRing_7, 0.0F, -0.8609709F, 0.0F); this.NeckRing_4 = new ModelRenderer((ModelBase)this, 0, 0); this.NeckRing_4.func_78793_a(0.0F, 0.0F, 0.0F); this.NeckRing_4.func_78790_a(-8.5F, -3.2F, -3.3F, 2, 1, 7, 0.0F); setRotateAngle(this.NeckRing_4, 0.0F, -0.7382743F, 0.0F); this.NeckRing_6 = new ModelRenderer((ModelBase)this, 19, 0); this.NeckRing_6.func_78793_a(0.0F, 0.0F, 0.0F); this.NeckRing_6.func_78790_a(-8.3F, -3.2F, -5.5F, 2, 1, 9, 0.0F); setRotateAngle(this.NeckRing_6, 0.0F, -0.7696902F, 0.0F); this.NeckRing_2.func_78792_a(this.NeckRing_3); this.NeckRing_4.func_78792_a(this.NeckRing_5); this.NeckRing_1.func_78792_a(this.NeckRing_2); this.NeckRing.func_78792_a(this.NeckRing_1); this.NeckRing_6.func_78792_a(this.NeckRing_7); this.NeckRing_3.func_78792_a(this.NeckRing_4); this.NeckRing_5.func_78792_a(this.NeckRing_6); }
/*     */     else if (id == 4) { this.BoL_RBase3 = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_RBase3.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_RBase3.func_78790_a(-10.1F, -5.1F, 10.0F, 2, 6, 1, 0.0F); setRotateAngle(this.BoL_RBase3, 0.0F, 0.0F, 0.4464552F); this.BoL_Top = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_Top.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_Top.func_78790_a(-3.0F, -12.7F, 10.0F, 6, 2, 1, 0.0F); this.BoL_LBase3 = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_LBase3.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_LBase3.func_78790_a(8.0F, -5.1F, 10.0F, 2, 6, 1, 0.0F); setRotateAngle(this.BoL_LBase3, 0.0F, 0.0F, -0.4464552F); this.BoL_InnerRB = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_InnerRB.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_InnerRB.func_78790_a(-7.9F, -2.6F, 10.0F, 2, 6, 1, 0.0F); setRotateAngle(this.BoL_InnerRB, 0.0F, 0.0F, -0.6806784F); this.BoL_RBase = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_RBase.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_RBase.func_78790_a(-11.2F, -4.5F, 10.0F, 2, 6, 1, 0.0F); this.SpikeTop = new ModelRenderer((ModelBase)this, 0, 0); this.SpikeTop.func_78793_a(0.0F, 0.0F, 0.0F); this.SpikeTop.func_78790_a(-0.6F, -19.8F, 10.0F, 1, 13, 1, 0.0F); this.BoL_InnerLB = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_InnerLB.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_InnerLB.func_78790_a(5.7F, -2.4F, 10.0F, 2, 6, 1, 0.0F); setRotateAngle(this.BoL_InnerLB, 0.0F, 0.0F, 0.6806784F); this.BoL_InnerL = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_InnerL.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_InnerL.func_78790_a(5.4F, -2.0F, 10.0F, 2, 5, 1, 0.0F); this.BoL_InnerRT = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_InnerRT.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_InnerRT.func_78790_a(-7.6F, -2.1F, 10.0F, 2, 4, 1, 0.0F); setRotateAngle(this.BoL_InnerRT, 0.0F, 0.0F, 0.48694685F); this.BoL_RBase2 = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_RBase2.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_RBase2.func_78790_a(-9.4F, -3.8F, 10.0F, 2, 6, 1, 0.0F); setRotateAngle(this.BoL_RBase2, 0.0F, 0.0F, -1.0471976F); this.BoL_InnerLT2 = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_InnerLT2.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_InnerLT2.func_78790_a(5.5F, -1.8F, 10.0F, 2, 4, 1, 0.0F); setRotateAngle(this.BoL_InnerLT2, 0.0F, 0.0F, -0.54454273F); this.BoL_InnerTop = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_InnerTop.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_InnerTop.func_78790_a(-2.5F, -7.3F, 10.0F, 5, 2, 1, 0.0F); this.BoL_InnerR = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_InnerR.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_InnerR.func_78790_a(-7.7F, -2.0F, 10.0F, 2, 5, 1, 0.0F); this.SpikeR = new ModelRenderer((ModelBase)this, 0, 0); this.SpikeR.func_78793_a(0.0F, 0.0F, 0.0F); this.SpikeR.func_78790_a(-16.6F, -0.2F, 10.0F, 9, 1, 1, 0.0F); this.BoL_LBase2 = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_LBase2.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_LBase2.func_78790_a(7.4F, -3.8F, 10.0F, 2, 6, 1, 0.0F); setRotateAngle(this.BoL_LBase2, 0.0F, 0.0F, 1.0471976F); this.BoL_LBase = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_LBase.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_LBase.func_78790_a(9.2F, -4.5F, 10.0F, 2, 6, 1, 0.0F); this.SpikeL = new ModelRenderer((ModelBase)this, 0, 0); this.SpikeL.func_78793_a(0.0F, 0.0F, 0.0F); this.SpikeL.func_78790_a(7.4F, -0.2F, 10.0F, 9, 1, 1, 0.0F); this.SpikeBottom = new ModelRenderer((ModelBase)this, 0, 0); this.SpikeBottom.func_78793_a(0.0F, 0.0F, 0.0F); this.SpikeBottom.func_78790_a(-0.6F, 8.8F, 10.0F, 1, 7, 1, 0.0F); this.BoL_InnerLT = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_InnerLT.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_InnerLT.func_78790_a(5.5F, -2.3F, 10.0F, 2, 4, 1, 0.0F); setRotateAngle(this.BoL_InnerLT, 0.0F, 0.0F, -0.47298422F); this.BoL_RTBase2 = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_RTBase2.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_RTBase2.func_78790_a(-12.5F, -3.8F, 10.0F, 2, 6, 1, 0.0F); setRotateAngle(this.BoL_RTBase2, 0.0F, 0.0F, 1.0471976F); this.BoL_InnerRT2 = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_InnerRT2.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_InnerRT2.func_78790_a(-7.5F, -1.8F, 10.0F, 2, 4, 1, 0.0F); setRotateAngle(this.BoL_InnerRT2, 0.0F, 0.0F, 0.54454273F); this.BoL_LTBase2 = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_LTBase2.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_LTBase2.func_78790_a(10.5F, -4.0F, 10.0F, 2, 6, 1, 0.0F); setRotateAngle(this.BoL_LTBase2, 0.0F, 0.0F, -1.0227629F); this.BoL_LTBase3 = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_LTBase3.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_LTBase3.func_78790_a(9.9F, -4.5F, 10.0F, 2, 6, 1, 0.0F); setRotateAngle(this.BoL_LTBase3, 0.0F, 0.0F, 0.51975906F); this.BoL_Base = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_Base.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_Base.func_78790_a(-3.0F, 6.2F, 10.0F, 6, 3, 1, 0.0F); setRotateAngle(this.BoL_Base, -0.034906585F, 0.0F, 0.0F); this.BoL_RTBase3 = new ModelRenderer((ModelBase)this, 0, 0); this.BoL_RTBase3.func_78793_a(0.0F, 0.0F, 0.0F); this.BoL_RTBase3.func_78790_a(-11.9F, -4.2F, 10.0F, 2, 6, 1, 0.0F); setRotateAngle(this.BoL_RTBase3, 0.0F, 0.0F, -0.5145231F); this.BoL_RBase2.func_78792_a(this.BoL_RBase3); this.BoL_Base.func_78792_a(this.BoL_Top); this.BoL_LBase2.func_78792_a(this.BoL_LBase3); this.BoL_InnerR.func_78792_a(this.BoL_InnerRB); this.BoL_Base.func_78792_a(this.BoL_RBase); this.BoL_Base.func_78792_a(this.SpikeTop); this.BoL_InnerL.func_78792_a(this.BoL_InnerLB); this.BoL_InnerTop.func_78792_a(this.BoL_InnerL); this.BoL_InnerR.func_78792_a(this.BoL_InnerRT); this.BoL_RBase.func_78792_a(this.BoL_RBase2); this.BoL_InnerLT.func_78792_a(this.BoL_InnerLT2); this.BoL_Base.func_78792_a(this.BoL_InnerTop); this.BoL_InnerTop.func_78792_a(this.BoL_InnerR); this.BoL_InnerR.func_78792_a(this.SpikeR); this.BoL_LBase.func_78792_a(this.BoL_LBase2); this.BoL_Base.func_78792_a(this.BoL_LBase); this.BoL_InnerL.func_78792_a(this.SpikeL); this.BoL_Base.func_78792_a(this.SpikeBottom); this.BoL_InnerL.func_78792_a(this.BoL_InnerLT); this.BoL_RBase.func_78792_a(this.BoL_RTBase2); this.BoL_InnerRT.func_78792_a(this.BoL_InnerRT2); this.BoL_LBase.func_78792_a(this.BoL_LTBase2); this.BoL_LTBase2.func_78792_a(this.BoL_LTBase3); this.BoL_RTBase2.func_78792_a(this.BoL_RTBase3); }
/* 310 */      } public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 311 */     GL11.glPushMatrix();
/* 312 */     float f6 = this.size;
/* 313 */     boolean sneak = entity.func_70093_af();
/* 314 */     if (JRMCoreH.JYC()) {
/* 315 */       float age = JRMCoreHJYC.JYCAge((EntityPlayer)entity);
/* 316 */       float childScl = JRMCoreHJYC.JYCsizeBasedOnAge((EntityPlayer)entity);
/* 317 */       childScl = 3.0F - childScl * 2.0F;
/* 318 */       this.size = childScl;
/*     */     } 
/*     */ 
/*     */     
/* 322 */     if (this.id == 0) {
/* 323 */       float scale = (g <= 1) ? 1.03F : 0.8F;
/* 324 */       GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
/* 325 */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/* 326 */       GL11.glPushMatrix();
/* 327 */       GL11.glScalef(scale, scale, scale);
/* 328 */       this.Larm.func_78785_a(f5);
/* 329 */       this.body.func_78785_a(f5);
/* 330 */       this.Rarm.func_78785_a(f5);
/* 331 */       GL11.glPopMatrix();
/*     */     }
/* 333 */     else if (this.id == 1) {
/* 334 */       float scale = 1.03F;
/* 335 */       GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
/* 336 */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F + ((sneak && g > 1) ? -0.075F : 0.0F));
/* 337 */       GL11.glPushMatrix();
/* 338 */       GL11.glScalef(scale, scale, scale);
/* 339 */       this.Rleg.func_78785_a(f5);
/* 340 */       this.Lleg.func_78785_a(f5);
/* 341 */       GL11.glPopMatrix();
/*     */     }
/* 343 */     else if (this.id == 2) {
/* 344 */       float fx6 = 1.0F;
/* 345 */       GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
/* 346 */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.3F, 0.0F);
/* 347 */       GL11.glPushMatrix();
/* 348 */       GL11.glScalef((0.5F + 0.5F / fx6) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / fx6, (0.5F + 0.5F / fx6) * ((g <= 1) ? 1.0F : 0.85F));
/* 349 */       GL11.glTranslatef(0.0F, (fx6 - 1.0F) / fx6 * (2.0F - ((fx6 >= 1.5F && fx6 <= 2.0F) ? ((2.0F - fx6) / 2.5F) : ((fx6 < 1.5F && fx6 >= 1.0F) ? ((fx6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/* 350 */       this.halo.field_78796_g = this.field_78116_c.field_78796_g;
/* 351 */       this.halo.field_78795_f = this.field_78116_c.field_78795_f;
/* 352 */       this.halo.field_78800_c = this.field_78116_c.field_78800_c;
/* 353 */       this.halo.field_78797_d = this.field_78116_c.field_78797_d;
/* 354 */       this.halo.func_78785_a(0.0625F);
/* 355 */       GL11.glPopMatrix();
/*     */     }
/* 357 */     else if (this.id == 3) {
/* 358 */       float fx6 = 1.0F;
/* 359 */       GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
/* 360 */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/* 361 */       GL11.glPushMatrix();
/* 362 */       GL11.glScalef((0.5F + 0.5F / fx6) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / fx6, (0.5F + 0.5F / fx6) * ((g <= 1) ? 1.0F : 0.85F));
/* 363 */       GL11.glTranslatef(0.0F, (fx6 - 1.0F) / fx6 * (2.0F - ((fx6 >= 1.5F && fx6 <= 2.0F) ? ((2.0F - fx6) / 2.5F) : ((fx6 < 1.5F && fx6 >= 1.0F) ? ((fx6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/* 364 */       this.NeckRing.field_78796_g = this.B.field_78796_g;
/* 365 */       this.B.field_78795_f += 0.59184116F;
/* 366 */       this.NeckRing.field_78800_c = this.B.field_78800_c;
/* 367 */       this.NeckRing.field_78797_d = this.B.field_78797_d;
/* 368 */       this.NeckRing.func_78785_a(f5);
/* 369 */       GL11.glPopMatrix();
/*     */     }
/* 371 */     else if (this.id == 4) {
/* 372 */       this.BoL_Base.func_78785_a(f5);
/*     */     } 
/*     */     
/* 375 */     GL11.glPopMatrix(); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 380 */     modelRenderer.field_78795_f = x;
/* 381 */     modelRenderer.field_78796_g = y;
/* 382 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 386 */     model.field_78795_f = x;
/* 387 */     model.field_78796_g = y;
/* 388 */     model.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
/* 392 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, entity);
/* 393 */     if (this.id == 0) {
/* 394 */       this.Larm.field_78798_e = this.LA.field_78798_e;
/* 395 */       this.Larm.field_78797_d = this.LA.field_78797_d;
/* 396 */       this.Larm.field_78800_c = this.LA.field_78800_c;
/*     */       
/* 398 */       this.Larm.field_78808_h = this.LA.field_78808_h;
/* 399 */       this.Larm.field_78796_g = this.LA.field_78796_g;
/* 400 */       this.Larm.field_78795_f = this.LA.field_78795_f;
/*     */ 
/*     */ 
/*     */       
/* 404 */       this.Rarm.field_78798_e = this.RA.field_78798_e;
/* 405 */       this.Rarm.field_78797_d = this.RA.field_78797_d;
/* 406 */       this.Rarm.field_78800_c = this.RA.field_78800_c;
/*     */       
/* 408 */       this.Rarm.field_78808_h = this.RA.field_78808_h;
/* 409 */       this.Rarm.field_78796_g = this.RA.field_78796_g;
/* 410 */       this.Rarm.field_78795_f = this.RA.field_78795_f;
/*     */ 
/*     */ 
/*     */       
/* 414 */       this.body.field_78798_e = this.B.field_78798_e;
/* 415 */       this.body.field_78797_d = this.B.field_78797_d;
/* 416 */       this.body.field_78800_c = this.B.field_78800_c;
/*     */       
/* 418 */       this.body.field_78808_h = this.B.field_78808_h;
/* 419 */       this.body.field_78796_g = this.B.field_78796_g;
/* 420 */       this.body.field_78795_f = this.B.field_78795_f;
/* 421 */       if (y != 1) {
/* 422 */         float s = 0.0F;
/* 423 */         float s2 = MathHelper.func_76134_b(par1 * 0.6662F) * 1.0F * par2;
/* 424 */         float s3 = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.0F * par2;
/* 425 */         this.tail.field_78795_f = ((s3 + s > s) ? (s3 + s) : ((s2 + s > s) ? (s2 + s) : s)) + 0.1F;
/*     */       } else {
/*     */         
/* 428 */         float s = 0.0F;
/* 429 */         float s2 = MathHelper.func_76134_b(par1 * 0.6662F) * 1.0F * par2;
/* 430 */         float s3 = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.0F * par2;
/* 431 */         this.tail.field_78795_f = ((s3 + s > s) ? (s3 + s) : ((s2 + s > s) ? (s2 + s) : s)) * 2.0F + 0.1F;
/*     */       }
/*     */     
/*     */     }
/* 435 */     else if (this.id == 1) {
/* 436 */       float ff1 = 1.0F;
/* 437 */       this.RL.field_78798_e *= ff1;
/* 438 */       this.RL.field_78797_d *= ff1;
/* 439 */       this.RL.field_78800_c *= ff1;
/*     */       
/* 441 */       this.RL.field_78808_h *= ff1;
/* 442 */       this.RL.field_78796_g *= ff1;
/* 443 */       this.RL.field_78795_f *= ff1;
/*     */ 
/*     */       
/* 446 */       this.LL.field_78798_e *= ff1;
/* 447 */       this.LL.field_78797_d *= ff1;
/* 448 */       this.LL.field_78800_c *= ff1;
/*     */       
/* 450 */       this.LL.field_78808_h *= ff1;
/* 451 */       this.LL.field_78796_g *= ff1;
/* 452 */       this.LL.field_78795_f *= ff1;
/*     */     }
/* 454 */     else if (this.id != 2 && 
/* 455 */       this.id != 3 && 
/* 456 */       this.id == 4) {
/*     */     
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JBRA-Client-v1.6.52.jar!\JinRyuu\JBRA\DBC_GiTurtleMdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */