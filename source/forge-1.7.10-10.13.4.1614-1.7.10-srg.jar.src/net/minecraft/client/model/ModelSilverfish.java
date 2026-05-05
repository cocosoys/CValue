/*     */ package net.minecraft.client.model;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelSilverfish
/*     */   extends ModelBase {
/*     */   private ModelRenderer[] field_78171_a;
/*     */   private ModelRenderer[] field_78169_b;
/*  13 */   private float[] field_78170_c = new float[7];
/*     */   
/*  15 */   private static final int[][] field_78167_d = new int[][] { { 3, 2, 2 }, { 4, 3, 2 }, { 6, 4, 3 }, { 3, 3, 3 }, { 2, 2, 3 }, { 2, 1, 2 }, { 1, 1, 2 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  32 */   private static final int[][] field_78168_e = new int[][] { { 0, 0 }, { 0, 4 }, { 0, 9 }, { 0, 16 }, { 0, 22 }, { 11, 0 }, { 13, 4 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00000855";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelSilverfish() {
/*  51 */     this.field_78171_a = new ModelRenderer[7];
/*  52 */     float f = -3.5F;
/*  53 */     for (byte b = 0; b < this.field_78171_a.length; b++) {
/*  54 */       this.field_78171_a[b] = new ModelRenderer(this, field_78168_e[b][0], field_78168_e[b][1]);
/*  55 */       this.field_78171_a[b].func_78789_a(field_78167_d[b][0] * -0.5F, 0.0F, field_78167_d[b][2] * -0.5F, field_78167_d[b][0], field_78167_d[b][1], field_78167_d[b][2]);
/*  56 */       this.field_78171_a[b].func_78793_a(0.0F, (24 - field_78167_d[b][1]), f);
/*  57 */       this.field_78170_c[b] = f;
/*  58 */       if (b < this.field_78171_a.length - 1) {
/*  59 */         f += (field_78167_d[b][2] + field_78167_d[b + 1][2]) * 0.5F;
/*     */       }
/*     */     } 
/*     */     
/*  63 */     this.field_78169_b = new ModelRenderer[3];
/*  64 */     this.field_78169_b[0] = new ModelRenderer(this, 20, 0);
/*  65 */     this.field_78169_b[0].func_78789_a(-5.0F, 0.0F, field_78167_d[2][2] * -0.5F, 10, 8, field_78167_d[2][2]);
/*  66 */     this.field_78169_b[0].func_78793_a(0.0F, 16.0F, this.field_78170_c[2]);
/*  67 */     this.field_78169_b[1] = new ModelRenderer(this, 20, 11);
/*  68 */     this.field_78169_b[1].func_78789_a(-3.0F, 0.0F, field_78167_d[4][2] * -0.5F, 6, 4, field_78167_d[4][2]);
/*  69 */     this.field_78169_b[1].func_78793_a(0.0F, 20.0F, this.field_78170_c[4]);
/*  70 */     this.field_78169_b[2] = new ModelRenderer(this, 20, 18);
/*  71 */     this.field_78169_b[2].func_78789_a(-3.0F, 0.0F, field_78167_d[4][2] * -0.5F, 6, 5, field_78167_d[1][2]);
/*  72 */     this.field_78169_b[2].func_78793_a(0.0F, 19.0F, this.field_78170_c[1]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/*  81 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*     */     byte b;
/*  83 */     for (b = 0; b < this.field_78171_a.length; b++) {
/*  84 */       this.field_78171_a[b].func_78785_a(p_78088_7_);
/*     */     }
/*  86 */     for (b = 0; b < this.field_78169_b.length; b++) {
/*  87 */       this.field_78169_b[b].func_78785_a(p_78088_7_);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/*  94 */     for (byte b = 0; b < this.field_78171_a.length; b++) {
/*  95 */       (this.field_78171_a[b]).field_78796_g = MathHelper.func_76134_b(p_78087_3_ * 0.9F + b * 0.15F * 3.1415927F) * 3.1415927F * 0.05F * (1 + Math.abs(b - 2));
/*  96 */       (this.field_78171_a[b]).field_78800_c = MathHelper.func_76126_a(p_78087_3_ * 0.9F + b * 0.15F * 3.1415927F) * 3.1415927F * 0.2F * Math.abs(b - 2);
/*     */     } 
/*     */     
/*  99 */     (this.field_78169_b[0]).field_78796_g = (this.field_78171_a[2]).field_78796_g;
/* 100 */     (this.field_78169_b[1]).field_78796_g = (this.field_78171_a[4]).field_78796_g;
/* 101 */     (this.field_78169_b[1]).field_78800_c = (this.field_78171_a[4]).field_78800_c;
/* 102 */     (this.field_78169_b[2]).field_78796_g = (this.field_78171_a[1]).field_78796_g;
/* 103 */     (this.field_78169_b[2]).field_78800_c = (this.field_78171_a[1]).field_78800_c;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelSilverfish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */