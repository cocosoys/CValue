/*     */ package net.minecraft.client.renderer.tileentity;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.entity.RenderEnchantmentTable;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityEnderChest;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class TileEntityRendererDispatcher {
/*  19 */   public Map field_147559_m = new HashMap<Object, Object>();
/*     */   
/*  21 */   public static TileEntityRendererDispatcher field_147556_a = new TileEntityRendererDispatcher(); private FontRenderer field_147557_n; public static double field_147554_b;
/*     */   public static double field_147555_c;
/*     */   public static double field_147552_d;
/*     */   public TextureManager field_147553_e;
/*     */   public World field_147550_f;
/*     */   public EntityLivingBase field_147551_g;
/*     */   public float field_147562_h;
/*     */   public float field_147563_i;
/*     */   public double field_147560_j;
/*     */   public double field_147561_k;
/*     */   public double field_147558_l;
/*     */   private static final String __OBFID = "CL_00000963";
/*     */   
/*     */   private TileEntityRendererDispatcher() {
/*  35 */     this.field_147559_m.put(TileEntitySign.class, new TileEntitySignRenderer());
/*  36 */     this.field_147559_m.put(TileEntityMobSpawner.class, new TileEntityMobSpawnerRenderer());
/*  37 */     this.field_147559_m.put(TileEntityPiston.class, new TileEntityRendererPiston());
/*  38 */     this.field_147559_m.put(TileEntityChest.class, new TileEntityChestRenderer());
/*  39 */     this.field_147559_m.put(TileEntityEnderChest.class, new TileEntityEnderChestRenderer());
/*  40 */     this.field_147559_m.put(TileEntityEnchantmentTable.class, new RenderEnchantmentTable());
/*  41 */     this.field_147559_m.put(TileEntityEndPortal.class, new RenderEndPortal());
/*  42 */     this.field_147559_m.put(TileEntityBeacon.class, new TileEntityBeaconRenderer());
/*  43 */     this.field_147559_m.put(TileEntitySkull.class, new TileEntitySkullRenderer());
/*     */     
/*  45 */     for (TileEntitySpecialRenderer tileEntitySpecialRenderer : this.field_147559_m.values()) {
/*  46 */       tileEntitySpecialRenderer.func_147497_a(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntitySpecialRenderer func_147546_a(Class<TileEntity> p_147546_1_) {
/*  52 */     TileEntitySpecialRenderer tileEntitySpecialRenderer = (TileEntitySpecialRenderer)this.field_147559_m.get(p_147546_1_);
/*  53 */     if (tileEntitySpecialRenderer == null && p_147546_1_ != TileEntity.class) {
/*  54 */       tileEntitySpecialRenderer = func_147546_a(p_147546_1_.getSuperclass());
/*  55 */       this.field_147559_m.put(p_147546_1_, tileEntitySpecialRenderer);
/*     */     } 
/*  57 */     return tileEntitySpecialRenderer;
/*     */   }
/*     */   
/*     */   public boolean func_147545_a(TileEntity p_147545_1_) {
/*  61 */     return (func_147547_b(p_147545_1_) != null);
/*     */   }
/*     */   
/*     */   public TileEntitySpecialRenderer func_147547_b(TileEntity p_147547_1_) {
/*  65 */     if (p_147547_1_ == null) return null; 
/*  66 */     return func_147546_a(p_147547_1_.getClass());
/*     */   }
/*     */   
/*     */   public void func_147542_a(World p_147542_1_, TextureManager p_147542_2_, FontRenderer p_147542_3_, EntityLivingBase p_147542_4_, float p_147542_5_) {
/*  70 */     if (this.field_147550_f != p_147542_1_) {
/*  71 */       func_147543_a(p_147542_1_);
/*     */     }
/*  73 */     this.field_147553_e = p_147542_2_;
/*  74 */     this.field_147551_g = p_147542_4_;
/*  75 */     this.field_147557_n = p_147542_3_;
/*     */     
/*  77 */     this.field_147562_h = p_147542_4_.field_70126_B + (p_147542_4_.field_70177_z - p_147542_4_.field_70126_B) * p_147542_5_;
/*  78 */     this.field_147563_i = p_147542_4_.field_70127_C + (p_147542_4_.field_70125_A - p_147542_4_.field_70127_C) * p_147542_5_;
/*     */     
/*  80 */     this.field_147560_j = p_147542_4_.field_70142_S + (p_147542_4_.field_70165_t - p_147542_4_.field_70142_S) * p_147542_5_;
/*  81 */     this.field_147561_k = p_147542_4_.field_70137_T + (p_147542_4_.field_70163_u - p_147542_4_.field_70137_T) * p_147542_5_;
/*  82 */     this.field_147558_l = p_147542_4_.field_70136_U + (p_147542_4_.field_70161_v - p_147542_4_.field_70136_U) * p_147542_5_;
/*     */   }
/*     */   
/*     */   public void func_147544_a(TileEntity p_147544_1_, float p_147544_2_) {
/*  86 */     if (p_147544_1_.func_145835_a(this.field_147560_j, this.field_147561_k, this.field_147558_l) < p_147544_1_.func_145833_n()) {
/*  87 */       int i = this.field_147550_f.func_72802_i(p_147544_1_.field_145851_c, p_147544_1_.field_145848_d, p_147544_1_.field_145849_e, 0);
/*  88 */       int j = i % 65536;
/*  89 */       int k = i / 65536;
/*  90 */       OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, j / 1.0F, k / 1.0F);
/*  91 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  92 */       func_147549_a(p_147544_1_, p_147544_1_.field_145851_c - field_147554_b, p_147544_1_.field_145848_d - field_147555_c, p_147544_1_.field_145849_e - field_147552_d, p_147544_2_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_147549_a(TileEntity p_147549_1_, double p_147549_2_, double p_147549_4_, double p_147549_6_, float p_147549_8_) {
/*  97 */     TileEntitySpecialRenderer tileEntitySpecialRenderer = func_147547_b(p_147549_1_);
/*  98 */     if (tileEntitySpecialRenderer != null) {
/*     */       try {
/* 100 */         tileEntitySpecialRenderer.func_147500_a(p_147549_1_, p_147549_2_, p_147549_4_, p_147549_6_, p_147549_8_);
/* 101 */       } catch (Throwable throwable) {
/* 102 */         CrashReport crashReport = CrashReport.func_85055_a(throwable, "Rendering Block Entity");
/* 103 */         CrashReportCategory crashReportCategory = crashReport.func_85058_a("Block Entity Details");
/*     */         
/* 105 */         p_147549_1_.func_145828_a(crashReportCategory);
/*     */         
/* 107 */         throw new ReportedException(crashReport);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_147543_a(World p_147543_1_) {
/* 113 */     this.field_147550_f = p_147543_1_;
/*     */     
/* 115 */     for (TileEntitySpecialRenderer tileEntitySpecialRenderer : this.field_147559_m.values()) {
/* 116 */       if (tileEntitySpecialRenderer != null) {
/* 117 */         tileEntitySpecialRenderer.func_147496_a(p_147543_1_);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FontRenderer func_147548_a() {
/* 130 */     return this.field_147557_n;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\tileentity\TileEntityRendererDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */