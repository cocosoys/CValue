/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import JinRyuu.FamilyC.FamilyCConfig;
/*     */ import JinRyuu.JBRA.DBC_GiTurtleMdl;
/*     */ import JinRyuu.JBRA.GiTurtleMdl;
/*     */ import JinRyuu.JBRA.JRMC_GiTurtleMdl;
/*     */ import JinRyuu.JBRA.NC_GiTurtleMdl;
/*     */ import JinRyuu.JRMCore.entity.ModelBipedBody;
/*     */ import JinRyuu.JRMCore.entity.ModelKB;
/*     */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*     */ import JinRyuu.JRMCore.m.mEnergy5;
/*     */ import JinRyuu.JYearsC.JYearsCConfig;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class JRMCoreHJBRA
/*     */ {
/*     */   public static final ModelBiped ModelBipedBody(float s) {
/*  22 */     return (ModelBiped)new ModelBipedBody(s);
/*     */   }
/*     */   
/*  25 */   public static final ModelBiped GiTurtleMdl1 = (ModelBiped)new GiTurtleMdl(0.201F);
/*     */   
/*  27 */   public static final ModelBiped GiTurtleMdl2 = (ModelBiped)new GiTurtleMdl(0.11F);
/*     */   
/*  29 */   public static final ModelBiped GiTurtleMdl3 = (ModelBiped)new GiTurtleMdl(0.056F);
/*     */   
/*  31 */   public static final ModelBiped GiTurtleMdl4 = (ModelBiped)new ModelBipedBody(0.198F);
/*     */   
/*  33 */   public static final ModelBiped GiTurtleMdl5 = (ModelBiped)new ModelBipedBody(0.5F);
/*     */   
/*  35 */   public static final ModelBiped GiTurtleMdl3_1 = (ModelBiped)new GiTurtleMdl(0.056F);
/*     */ 
/*     */   
/*  38 */   public static final ModelBiped[] JRMC_GiTurtleMdl2 = new ModelBiped[] { (ModelBiped)new JRMC_GiTurtleMdl(0), (ModelBiped)new JRMC_GiTurtleMdl(1), (ModelBiped)new JRMC_GiTurtleMdl(2), (ModelBiped)new JRMC_GiTurtleMdl(3), (ModelBiped)new JRMC_GiTurtleMdl(4) };
/*     */   
/*  40 */   public static final ModelBiped[] DBC_GiTurtleMdl2 = new ModelBiped[] { (ModelBiped)new DBC_GiTurtleMdl(0), (ModelBiped)new DBC_GiTurtleMdl(1), (ModelBiped)new DBC_GiTurtleMdl(2), (ModelBiped)new DBC_GiTurtleMdl(3), (ModelBiped)new DBC_GiTurtleMdl(4) };
/*     */ 
/*     */   
/*  43 */   public static final ModelBiped[] NC_GiTurtleMdl2 = new ModelBiped[] { (ModelBiped)new NC_GiTurtleMdl(0), (ModelBiped)new NC_GiTurtleMdl(1) };
/*     */ 
/*     */ 
/*     */   
/*  47 */   public static final mEnergy5 model1 = new mEnergy5();
/*  48 */   public static final ModelKB model2 = new ModelKB();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int JFCgetConfigpt() {
/*  57 */     return FamilyCConfig.pt; } private static float JYCgetConfigpgut() {
/*  58 */     return JYearsCConfig.pgut;
/*     */   }
/*     */   public static ModelBiped showModel(ModelBiped m, EntityLivingBase entityLiving, ItemStack is, int par2) {
/*  61 */     ModelBipedBody mdl = (ModelBipedBody)m;
/*     */     
/*  63 */     modelHelper(entityLiving, mdl);
/*  64 */     if (JRMCoreH.JFC()) JRMCoreHJFC.modelHelper(entityLiving, mdl);
/*     */     
/*  66 */     mdl.field_78116_c.field_78806_j = (par2 == 0 || par2 == 5);
/*  67 */     if (par2 == 5) par2 = 1; 
/*  68 */     if (ModelBipedBody.g >= 2) {
/*  69 */       mdl.body.field_78806_j = (par2 == 1 || par2 == 2 || par2 == 4);
/*  70 */       mdl.hip.field_78806_j = (par2 == 1 || par2 == 2 || par2 == 4);
/*  71 */       mdl.hip2.field_78806_j = (par2 == 1 || par2 == 2 || par2 == 4);
/*  72 */       mdl.waist.field_78806_j = (par2 == 1 || par2 == 2 || par2 == 4);
/*  73 */       mdl.bottom.field_78806_j = (par2 == 1 || par2 == 2 || par2 == 4);
/*  74 */       mdl.bottom2.field_78806_j = (par2 == 1 || par2 == 2 || par2 == 4);
/*  75 */       mdl.Bbreast.field_78806_j = (par2 == 1 || par2 == 2 || par2 == 4);
/*  76 */       mdl.Bbreast2.field_78806_j = (par2 == 1 || par2 == 2 || par2 == 4);
/*  77 */       mdl.Brightarm.field_78806_j = (par2 == 1 || par2 == 4);
/*  78 */       mdl.Bleftarm.field_78806_j = (par2 == 1 || par2 == 4);
/*  79 */       mdl.rightleg.field_78806_j = (par2 == 2 || par2 == 3 || par2 == 4);
/*  80 */       mdl.leftleg.field_78806_j = (par2 == 2 || par2 == 3 || par2 == 4);
/*     */     } else {
/*  82 */       mdl.field_78115_e.field_78806_j = (par2 == 1 || par2 == 2 || par2 == 4);
/*  83 */       mdl.field_78112_f.field_78806_j = (par2 == 1 || par2 == 4);
/*  84 */       mdl.field_78113_g.field_78806_j = (par2 == 1 || par2 == 4);
/*  85 */       mdl.field_78123_h.field_78806_j = (par2 == 2 || par2 == 3 || par2 == 4);
/*  86 */       mdl.field_78124_i.field_78806_j = (par2 == 2 || par2 == 3 || par2 == 4);
/*     */     } 
/*     */ 
/*     */     
/*  90 */     mdl.field_78117_n = entityLiving.func_70093_af();
/*  91 */     mdl.field_78095_p = 0.0F;
/*  92 */     mdl.field_78093_q = entityLiving.func_70115_ae();
/*  93 */     mdl.field_78091_s = entityLiving.func_70631_g_();
/*  94 */     mdl.field_78117_n = entityLiving.func_70093_af();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     return (ModelBiped)mdl;
/*     */   }
/*     */   
/*     */   private static void modelHelper(EntityLivingBase entityLiving, ModelBipedBody mdl) {
/* 104 */     if (entityLiving instanceof EntityPlayer) {
/* 105 */       EntityPlayer ply = (EntityPlayer)entityLiving;
/* 106 */       float childScl = 1.0F;
/* 107 */       float age = 0.0F;
/* 108 */       int gen = 1;
/* 109 */       int preg = 0;
/* 110 */       int breast = 0;
/* 111 */       if (JRMCoreH.JYC()) {
/* 112 */         age = JRMCoreHJYC.JYCAge(ply);
/* 113 */         childScl = JRMCoreHJYC.JYCsizeBasedOnAge(ply);
/* 114 */         childScl = 3.0F - childScl * 2.0F;
/*     */       } 
/* 116 */       if (JRMCoreH.JFC()) {
/* 117 */         if (JRMCoreH.dnn(1) && JRMCoreH.dnn(2)) {
/* 118 */           String[] s = JRMCoreH.data(ply.func_70005_c_(), 1, "0;0;0;0;0;0").split(";");
/* 119 */           String dns = s[1];
/* 120 */           int A = JRMCoreH.dnsGender(dns) + 1;
/*     */           
/* 122 */           if (A >= 1) gen = 1; 
/* 123 */           if (A == 2) gen = 2; 
/* 124 */           if (A == 3) gen = 3; 
/* 125 */           int pwr = Integer.parseInt(s[2]);
/* 126 */           if (pwr == 1 && A > 1) {
/* 127 */             int race = Integer.parseInt(s[0]);
/* 128 */             String[] dummy = { "0", "0", "0" };
/* 129 */             String[] state = JRMCoreH.data(ply.func_70005_c_(), 2, "0;0;0").split(";");
/* 130 */             int State = (pwr == 2 || race == 0) ? 0 : Integer.parseInt(state[0]);
/* 131 */             boolean saiOozar = JRMCoreH.rSai(race) ? ((State == 7 || State == 8)) : false;
/* 132 */             if (saiOozar) {
/* 133 */               gen = 1;
/*     */             }
/*     */           } 
/*     */         } 
/* 137 */         if (JRMCoreH.dnn(30) && !ply.func_82150_aj() && JRMCoreH.dnn(30)) {
/* 138 */           String s = JRMCoreH.data(ply.func_70005_c_(), 30, "0");
/* 139 */           int i = s.matches("[0-9]+") ? Integer.parseInt(s) : 0;
/* 140 */           int def = JFCgetConfigpt() * 120;
/* 141 */           if (i > 1)
/* 142 */           { preg = (int)((i - def / 2.0F) / def / 2.0F * 0.01F);
/* 143 */             preg = 100 - preg;
/* 144 */             preg = (preg > 100) ? 100 : ((preg < 0) ? 0 : preg); }
/* 145 */           else { preg = 0; }
/*     */         
/*     */         } 
/* 148 */         if (JRMCoreH.dnn(1) && JRMCoreH.dnn(2)) {
/* 149 */           String[] s = JRMCoreH.data(ply.func_70005_c_(), 1, "0;0;0;0;0;0").split(";");
/* 150 */           String dns = s[1];
/* 151 */           breast = JRMCoreH.dnsBreast(dns);
/*     */         } 
/*     */       } 
/*     */       
/* 155 */       ModelBipedBody.g = gen;
/*     */       
/* 157 */       ModelBipedBody.f = childScl;
/*     */       
/* 159 */       ModelBipedBody.p = preg;
/*     */       
/* 161 */       mdl.b = breast;
/*     */       
/* 163 */       ExtendedPlayer props = ExtendedPlayer.get(ply);
/* 164 */       boolean block = (props.getBlocking() == 1);
/* 165 */       boolean instantTransmissionOn = (props.getBlocking() == 2);
/* 166 */       int kishoot = props.getAnimKiShoot();
/*     */       
/* 168 */       mdl.blk = block;
/* 169 */       mdl.instantTransmission = instantTransmissionOn;
/* 170 */       mdl.KiAttack = kishoot;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 175 */       ItemStack var11 = ply.field_71071_by.func_70448_g();
/* 176 */       mdl.field_78120_m = (var11 != null) ? JRMCoreHSAC.ah(var11.func_77973_b(), 1) : 0;
/*     */       
/* 178 */       if (var11 != null && ply.func_71052_bv() > 0) {
/* 179 */         EnumAction var12 = var11.func_77975_n();
/*     */         
/* 181 */         if (var12 == EnumAction.block) {
/* 182 */           mdl.field_78120_m = 3;
/* 183 */         } else if (var12 == EnumAction.bow) {
/* 184 */           mdl.field_78118_o = true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreHJBRA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */