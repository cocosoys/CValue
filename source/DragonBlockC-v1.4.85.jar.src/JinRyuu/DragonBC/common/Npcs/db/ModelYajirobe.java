/*     */ package JinRyuu.DragonBC.common.Npcs.db;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelYajirobe
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Hair3;
/*     */   public ModelRenderer Hair4;
/*     */   public ModelRenderer Hair5;
/*     */   public ModelRenderer Hair6;
/*     */   public ModelRenderer Hair7;
/*     */   public ModelRenderer Hair8;
/*     */   public ModelRenderer Hair9;
/*     */   public ModelRenderer Hair10;
/*     */   public ModelRenderer Hair11;
/*     */   public ModelRenderer Hair12;
/*     */   public ModelRenderer Hair13;
/*     */   public ModelRenderer Hair14;
/*     */   public ModelRenderer Hair15;
/*     */   public ModelRenderer Hair16;
/*     */   public ModelRenderer Hair17;
/*     */   public ModelRenderer Hair18;
/*     */   public ModelRenderer Hair19;
/*     */   public ModelRenderer Hair20;
/*     */   public ModelRenderer Hair21;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Sword;
/*     */   public ModelRenderer Sheet;
/*     */   public ModelRenderer Guard;
/*     */   public ModelRenderer Handle;
/*     */   public ModelRenderer Sheet2;
/*     */   
/*     */   public ModelYajirobe() {
/*  46 */     this.field_78090_t = 64;
/*  47 */     this.field_78089_u = 64;
/*  48 */     this.Hair4 = new ModelRenderer(this, 29, 1);
/*  49 */     this.Hair4.func_78793_a(-3.4F, -6.0F, -3.5F);
/*  50 */     this.Hair4.func_78790_a(-0.4F, 0.2F, -0.5F, 1, 2, 1, 0.0F);
/*  51 */     setRotateAngle(this.Hair4, -0.3642502F, 0.5009095F, 0.22759093F);
/*  52 */     this.ArmL = new ModelRenderer(this, 23, 45);
/*  53 */     this.ArmL.field_78809_i = true;
/*  54 */     this.ArmL.func_78793_a(6.0F, 4.0F, 1.0F);
/*  55 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.5F, 4, 11, 5, 0.0F);
/*  56 */     this.Sheet = new ModelRenderer(this, 46, 48);
/*  57 */     this.Sheet.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.Sheet.func_78790_a(-0.5F, -0.5F, -1.0F, 1, 8, 2, 0.0F);
/*  59 */     this.Hair19 = new ModelRenderer(this, 34, 1);
/*  60 */     this.Hair19.func_78793_a(-3.8F, -1.5F, -1.7F);
/*  61 */     this.Hair19.func_78790_a(-1.0F, 0.0F, -0.5F, 2, 3, 1, 0.0F);
/*  62 */     setRotateAngle(this.Hair19, -0.5462881F, 0.7679449F, 0.0F);
/*  63 */     this.Hair11 = new ModelRenderer(this, 47, 20);
/*  64 */     this.Hair11.field_78809_i = true;
/*  65 */     this.Hair11.func_78793_a(2.1F, -4.0F, -1.0F);
/*  66 */     this.Hair11.func_78790_a(-1.0F, -0.2F, -2.0F, 4, 4, 4, 0.0F);
/*  67 */     setRotateAngle(this.Hair11, 0.0F, 0.0F, -0.7853982F);
/*  68 */     this.Body = new ModelRenderer(this, 0, 16);
/*  69 */     this.Body.func_78793_a(0.0F, 2.0F, 1.0F);
/*  70 */     this.Body.func_78790_a(-5.0F, 0.0F, -3.0F, 10, 5, 6, 0.0F);
/*  71 */     this.Hair = new ModelRenderer(this, 0, 0);
/*  72 */     this.Hair.func_78793_a(0.0F, -0.9F, 0.0F);
/*  73 */     this.Hair.func_78790_a(-0.5F, -3.0F, 0.0F, 1, 1, 1, 0.0F);
/*  74 */     this.Hair21 = new ModelRenderer(this, 48, 6);
/*  75 */     this.Hair21.func_78793_a(0.0F, 1.3F, -0.4F);
/*  76 */     this.Hair21.func_78790_a(-3.0F, -1.0F, -0.6F, 6, 3, 2, 0.0F);
/*  77 */     setRotateAngle(this.Hair21, -0.31869712F, 0.0F, 0.0F);
/*  78 */     this.Hair18 = new ModelRenderer(this, 34, 1);
/*  79 */     this.Hair18.field_78809_i = true;
/*  80 */     this.Hair18.func_78793_a(3.8F, -1.5F, -1.7F);
/*  81 */     this.Hair18.func_78790_a(-1.0F, 0.0F, -0.5F, 2, 3, 1, 0.0F);
/*  82 */     setRotateAngle(this.Hair18, -0.5462881F, -0.7679449F, 0.0F);
/*  83 */     this.Hair9 = new ModelRenderer(this, 49, 12);
/*  84 */     this.Hair9.field_78809_i = true;
/*  85 */     this.Hair9.func_78793_a(1.7F, -6.3F, 2.1F);
/*  86 */     this.Hair9.func_78790_a(-1.1F, -3.4F, -0.9F, 3, 4, 3, 0.0F);
/*  87 */     setRotateAngle(this.Hair9, -1.2217305F, 0.9075712F, -0.090757124F);
/*  88 */     this.Sheet2 = new ModelRenderer(this, 53, 48);
/*  89 */     this.Sheet2.func_78793_a(0.0F, 7.8F, 0.0F);
/*  90 */     this.Sheet2.func_78790_a(-0.5F, -0.5F, -1.0F, 1, 7, 2, 0.0F);
/*  91 */     setRotateAngle(this.Sheet2, 0.073303826F, 0.0F, 0.0F);
/*  92 */     this.Hair14 = new ModelRenderer(this, 47, 29);
/*  93 */     this.Hair14.func_78793_a(-2.7F, -1.9F, 1.5F);
/*  94 */     this.Hair14.func_78790_a(-2.5F, 0.0F, -3.0F, 3, 3, 5, 0.0F);
/*  95 */     setRotateAngle(this.Hair14, 0.27314404F, 0.0F, 0.8196066F);
/*  96 */     this.Body2 = new ModelRenderer(this, 0, 28);
/*  97 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.Body2.func_78790_a(-5.0F, 5.0F, -3.5F, 10, 6, 7, 0.0F);
/*  99 */     this.Guard = new ModelRenderer(this, 50, 58);
/* 100 */     this.Guard.func_78793_a(0.0F, -0.6F, 0.0F);
/* 101 */     this.Guard.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 0, 3, 0.0F);
/* 102 */     this.Hair3 = new ModelRenderer(this, 29, 1);
/* 103 */     this.Hair3.func_78793_a(-1.9F, -5.9F, -3.7F);
/* 104 */     this.Hair3.func_78790_a(-0.4F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
/* 105 */     setRotateAngle(this.Hair3, -0.5462881F, 0.18203785F, 0.18203785F);
/* 106 */     this.Hair16 = new ModelRenderer(this, 49, 38);
/* 107 */     this.Hair16.func_78793_a(-2.5F, -4.0F, 2.2F);
/* 108 */     this.Hair16.func_78790_a(-2.0F, -1.0F, -1.0F, 4, 4, 3, 0.0F);
/* 109 */     setRotateAngle(this.Hair16, 0.7679449F, -0.9599311F, 0.0F);
/* 110 */     this.LegR = new ModelRenderer(this, 1, 45);
/* 111 */     this.LegR.func_78793_a(-2.6F, 13.0F, 1.0F);
/* 112 */     this.LegR.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 11, 5, 0.1F);
/* 113 */     this.Sword = new ModelRenderer(this, 0, 0);
/* 114 */     this.Sword.func_78793_a(5.8F, 7.0F, -4.4F);
/* 115 */     this.Sword.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
/* 116 */     setRotateAngle(this.Sword, 1.3185962F, -0.07853982F, 0.0F);
/* 117 */     this.Hair1 = new ModelRenderer(this, 34, 1);
/* 118 */     this.Hair1.func_78793_a(2.8F, -5.7F, -3.7F);
/* 119 */     this.Hair1.func_78790_a(-1.0F, -0.3F, -0.5F, 2, 3, 1, 0.0F);
/* 120 */     setRotateAngle(this.Hair1, -0.3642502F, -0.4553564F, -0.045553092F);
/* 121 */     this.Hair6 = new ModelRenderer(this, 33, 14);
/* 122 */     this.Hair6.func_78793_a(0.2F, -6.3F, -1.9F);
/* 123 */     this.Hair6.func_78790_a(-0.5F, -2.3F, -0.8F, 1, 2, 2, 0.0F);
/* 124 */     setRotateAngle(this.Hair6, 0.0F, 0.0F, 0.3970624F);
/* 125 */     this.Hair17 = new ModelRenderer(this, 49, 38);
/* 126 */     this.Hair17.func_78793_a(0.0F, -3.6F, 3.1F);
/* 127 */     this.Hair17.func_78790_a(-2.0F, -1.0F, -1.0F, 4, 4, 3, 0.0F);
/* 128 */     setRotateAngle(this.Hair17, 0.7285004F, 0.0F, 0.0F);
/* 129 */     this.Hair7 = new ModelRenderer(this, 40, 14);
/* 130 */     this.Hair7.func_78793_a(-0.7F, -6.6F, 0.1F);
/* 131 */     this.Hair7.func_78790_a(-1.0F, -2.6F, -0.8F, 2, 3, 2, 0.0F);
/* 132 */     setRotateAngle(this.Hair7, 0.22759093F, -0.091106184F, -0.3642502F);
/* 133 */     this.Hair13 = new ModelRenderer(this, 47, 29);
/* 134 */     this.Hair13.field_78809_i = true;
/* 135 */     this.Hair13.func_78793_a(3.2F, -1.9F, 1.5F);
/* 136 */     this.Hair13.func_78790_a(-0.5F, -0.2F, -3.0F, 3, 3, 5, 0.0F);
/* 137 */     setRotateAngle(this.Hair13, 0.17453292F, 0.0F, -0.8196066F);
/* 138 */     this.Hair5 = new ModelRenderer(this, 33, 6);
/* 139 */     this.Hair5.func_78793_a(1.8F, -6.1F, -2.6F);
/* 140 */     this.Hair5.func_78790_a(-1.1F, -3.4F, -0.9F, 2, 4, 3, 0.0F);
/* 141 */     setRotateAngle(this.Hair5, -0.091106184F, 0.0F, 1.0471976F);
/* 142 */     this.Hair10 = new ModelRenderer(this, 49, 12);
/* 143 */     this.Hair10.func_78793_a(-1.4F, -6.1F, 1.5F);
/* 144 */     this.Hair10.func_78790_a(-1.1F, -3.9F, -0.9F, 3, 4, 3, 0.0F);
/* 145 */     setRotateAngle(this.Hair10, -1.2217305F, -1.0471976F, 0.091106184F);
/* 146 */     this.Hair20 = new ModelRenderer(this, 42, 0);
/* 147 */     this.Hair20.func_78793_a(0.0F, -0.6F, 3.1F);
/* 148 */     this.Hair20.func_78790_a(-4.5F, -1.0F, -0.6F, 9, 3, 2, 0.0F);
/* 149 */     setRotateAngle(this.Hair20, 0.7285004F, 0.0F, 0.0F);
/* 150 */     this.LegL = new ModelRenderer(this, 1, 45);
/* 151 */     this.LegL.field_78809_i = true;
/* 152 */     this.LegL.func_78793_a(2.6F, 13.0F, 1.0F);
/* 153 */     this.LegL.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 11, 5, 0.1F);
/* 154 */     this.Handle = new ModelRenderer(this, 60, 49);
/* 155 */     this.Handle.func_78793_a(0.0F, -0.5F, 0.0F);
/* 156 */     this.Handle.func_78790_a(-0.5F, -5.0F, -0.5F, 1, 5, 1, 0.0F);
/* 157 */     this.Hair15 = new ModelRenderer(this, 49, 38);
/* 158 */     this.Hair15.field_78809_i = true;
/* 159 */     this.Hair15.func_78793_a(2.6F, -4.0F, 2.2F);
/* 160 */     this.Hair15.func_78790_a(-2.0F, -1.0F, -1.0F, 4, 4, 3, 0.0F);
/* 161 */     setRotateAngle(this.Hair15, 0.7679449F, 0.9599311F, 0.0F);
/* 162 */     this.ArmR = new ModelRenderer(this, 23, 45);
/* 163 */     this.ArmR.func_78793_a(-6.0F, 4.0F, 1.0F);
/* 164 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.5F, 4, 11, 5, 0.0F);
/* 165 */     this.Hair8 = new ModelRenderer(this, 49, 12);
/* 166 */     this.Hair8.func_78793_a(-2.0F, -6.3F, -2.3F);
/* 167 */     this.Hair8.func_78790_a(-2.2F, -3.4F, -0.9F, 3, 4, 3, 0.0F);
/* 168 */     setRotateAngle(this.Hair8, 0.27314404F, -0.090757124F, -1.0471976F);
/* 169 */     this.Head = new ModelRenderer(this, 0, 0);
/* 170 */     this.Head.func_78793_a(0.0F, 2.0F, 0.6F);
/* 171 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/* 172 */     this.Hair12 = new ModelRenderer(this, 47, 20);
/* 173 */     this.Hair12.func_78793_a(-2.1F, -4.0F, -1.0F);
/* 174 */     this.Hair12.func_78790_a(-3.0F, -0.4F, -2.0F, 4, 4, 4, 0.0F);
/* 175 */     setRotateAngle(this.Hair12, 0.0F, 0.0F, 0.7853982F);
/* 176 */     this.Hair2 = new ModelRenderer(this, 34, 1);
/* 177 */     this.Hair2.func_78793_a(0.2F, -5.7F, -3.8F);
/* 178 */     this.Hair2.func_78790_a(-1.0F, -0.1F, -0.5F, 2, 3, 1, 0.0F);
/* 179 */     setRotateAngle(this.Hair2, -0.5009095F, -0.091106184F, 0.13665928F);
/* 180 */     this.Hair.func_78792_a(this.Hair4);
/* 181 */     this.Sword.func_78792_a(this.Sheet);
/* 182 */     this.Hair.func_78792_a(this.Hair19);
/* 183 */     this.Hair.func_78792_a(this.Hair11);
/* 184 */     this.Head.func_78792_a(this.Hair);
/* 185 */     this.Hair20.func_78792_a(this.Hair21);
/* 186 */     this.Hair.func_78792_a(this.Hair18);
/* 187 */     this.Hair.func_78792_a(this.Hair9);
/* 188 */     this.Sheet.func_78792_a(this.Sheet2);
/* 189 */     this.Hair.func_78792_a(this.Hair14);
/* 190 */     this.Body.func_78792_a(this.Body2);
/* 191 */     this.Sword.func_78792_a(this.Guard);
/* 192 */     this.Hair.func_78792_a(this.Hair3);
/* 193 */     this.Hair.func_78792_a(this.Hair16);
/* 194 */     this.Body2.func_78792_a(this.Sword);
/* 195 */     this.Hair.func_78792_a(this.Hair1);
/* 196 */     this.Hair.func_78792_a(this.Hair6);
/* 197 */     this.Hair.func_78792_a(this.Hair17);
/* 198 */     this.Hair.func_78792_a(this.Hair7);
/* 199 */     this.Hair.func_78792_a(this.Hair13);
/* 200 */     this.Hair.func_78792_a(this.Hair5);
/* 201 */     this.Hair.func_78792_a(this.Hair10);
/* 202 */     this.Hair.func_78792_a(this.Hair20);
/* 203 */     this.Sword.func_78792_a(this.Handle);
/* 204 */     this.Hair.func_78792_a(this.Hair15);
/* 205 */     this.Hair.func_78792_a(this.Hair8);
/* 206 */     this.Hair.func_78792_a(this.Hair12);
/* 207 */     this.Hair.func_78792_a(this.Hair2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 212 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 214 */     this.Head.func_78785_a(f5);
/*     */     
/* 216 */     this.Body.func_78785_a(f5);
/* 217 */     this.ArmR.func_78785_a(f5);
/* 218 */     this.ArmL.func_78785_a(f5);
/* 219 */     this.LegL.func_78785_a(f5);
/* 220 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 230 */     modelRenderer.field_78795_f = x;
/* 231 */     modelRenderer.field_78796_g = y;
/* 232 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 236 */     int calc = par7Entity.field_70173_aa;
/* 237 */     if (calc > 100) calc -= 100; 
/* 238 */     float r = 360.0F;
/* 239 */     float r2 = 180.0F;
/* 240 */     float n4 = par4;
/* 241 */     float n5 = par5;
/*     */     
/* 243 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 244 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 245 */     float ex = par7Entity.field_70173_aa;
/* 246 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 247 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 249 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 250 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 304 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 305 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 306 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 307 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 309 */     this.LegR.field_78796_g = 0.0F;
/* 310 */     this.LegL.field_78796_g = 0.0F;
/* 311 */     this.ArmR.field_78796_g = 0.0F;
/* 312 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\db\ModelYajirobe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */