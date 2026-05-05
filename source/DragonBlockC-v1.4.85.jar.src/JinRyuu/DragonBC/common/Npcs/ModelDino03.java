/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
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
/*     */ public class ModelDino03
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer Body_1;
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer FrontLeftLeg;
/*     */   public ModelRenderer FronRightLeg;
/*     */   public ModelRenderer BackLeftLeg;
/*     */   public ModelRenderer BackRightLeg;
/*     */   public ModelRenderer Tail1;
/*     */   public ModelRenderer Mouth;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Head3;
/*     */   public ModelRenderer Head4;
/*     */   public ModelRenderer LHorn;
/*     */   public ModelRenderer RHorn;
/*     */   public ModelRenderer Horn;
/*     */   public ModelRenderer LHorn2;
/*     */   public ModelRenderer LHorn4;
/*     */   public ModelRenderer RHorn2;
/*     */   public ModelRenderer RHorn4;
/*     */   public ModelRenderer FrontLeftLeg2;
/*     */   public ModelRenderer FrontRightLeg2;
/*     */   public ModelRenderer FrontLeftLeg2_1;
/*     */   public ModelRenderer FrontRightLeg2_1;
/*     */   public ModelRenderer Tail2;
/*     */   public ModelRenderer Tail3;
/*     */   public ModelRenderer Tail4;
/*     */   public ModelRenderer Tail5;
/*     */   public ModelRenderer Tail6;
/*     */   public ModelRenderer Tail7;
/*     */   
/*     */   public ModelDino03() {
/*  54 */     this.field_78090_t = 128;
/*  55 */     this.field_78089_u = 128;
/*  56 */     this.FrontLeftLeg2_1 = new ModelRenderer(this, 90, 65);
/*  57 */     this.FrontLeftLeg2_1.field_78809_i = true;
/*  58 */     this.FrontLeftLeg2_1.func_78793_a(2.5F, 6.9F, -0.1F);
/*  59 */     this.FrontLeftLeg2_1.func_78790_a(-2.5F, 0.1F, -2.5F, 5, 7, 5, 0.0F);
/*  60 */     setRotation(this.FrontLeftLeg2_1, 0.4098033F, 0.0F, 0.0F);
/*  61 */     this.Tail1 = new ModelRenderer(this, 0, 61);
/*  62 */     this.Tail1.func_78793_a(0.0F, 4.1F, 16.4F);
/*  63 */     this.Tail1.func_78790_a(-4.0F, -4.0F, 0.0F, 8, 8, 7, 0.0F);
/*  64 */     setRotation(this.Tail1, -0.3642502F, 0.0F, 0.0F);
/*  65 */     this.Body = new ModelRenderer(this, 0, 29);
/*  66 */     this.Body.func_78793_a(0.0F, 5.4F, -7.0F);
/*  67 */     this.Body.func_78790_a(-6.0F, 0.0F, 0.0F, 12, 10, 18, 0.0F);
/*  68 */     this.Body_1 = new ModelRenderer(this, 43, 25);
/*  69 */     this.Body_1.func_78793_a(0.0F, 10.4F, 8.4F);
/*  70 */     this.Body_1.func_78790_a(-5.0F, -0.8F, -7.0F, 10, 2, 16, 0.0F);
/*  71 */     this.RHorn4 = new ModelRenderer(this, 48, 18);
/*  72 */     this.RHorn4.func_78793_a(-0.3F, -3.4F, 0.0F);
/*  73 */     this.RHorn4.func_78790_a(-0.5F, -4.0F, -0.5F, 1, 4, 1, 0.0F);
/*  74 */     setRotation(this.RHorn4, 0.0F, 0.0F, 0.31869712F);
/*  75 */     this.Tail3 = new ModelRenderer(this, 0, 100);
/*  76 */     this.Tail3.func_78793_a(0.0F, 0.0F, 5.8F);
/*  77 */     this.Tail3.func_78790_a(-3.5F, -3.5F, 0.0F, 7, 7, 7, 0.0F);
/*  78 */     setRotation(this.Tail3, -0.22759093F, 0.0F, 0.0F);
/*  79 */     this.FrontLeftLeg2 = new ModelRenderer(this, 65, 65);
/*  80 */     this.FrontLeftLeg2.field_78809_i = true;
/*  81 */     this.FrontLeftLeg2.func_78793_a(2.5F, 4.9F, -0.3F);
/*  82 */     this.FrontLeftLeg2.func_78790_a(-2.5F, 0.1F, -2.5F, 5, 7, 5, 0.0F);
/*  83 */     setRotation(this.FrontLeftLeg2, 0.4098033F, 0.0F, 0.0F);
/*  84 */     this.Head3 = new ModelRenderer(this, 70, 0);
/*  85 */     this.Head3.field_78809_i = true;
/*  86 */     this.Head3.func_78793_a(4.5F, -2.5F, 0.0F);
/*  87 */     this.Head3.func_78790_a(0.0F, -10.0F, -0.5F, 10, 14, 1, 0.0F);
/*  88 */     setRotation(this.Head3, -0.22759093F, -0.13665928F, 0.22759093F);
/*  89 */     this.RHorn = new ModelRenderer(this, 26, 18);
/*  90 */     this.RHorn.func_78793_a(-4.2F, -3.9F, -3.2F);
/*  91 */     this.RHorn.func_78790_a(-1.0F, -4.0F, -1.0F, 2, 4, 2, 0.0F);
/*  92 */     setRotation(this.RHorn, 0.0F, 0.0F, -0.68294734F);
/*  93 */     this.Head = new ModelRenderer(this, 0, 0);
/*  94 */     this.Head.func_78793_a(0.0F, 1.0F, -1.0F);
/*  95 */     this.Head.func_78790_a(-5.0F, -4.5F, -6.0F, 10, 9, 7, 0.0F);
/*  96 */     this.Tail2 = new ModelRenderer(this, 0, 80);
/*  97 */     this.Tail2.func_78793_a(0.0F, 0.0F, 5.8F);
/*  98 */     this.Tail2.func_78790_a(-4.0F, -4.0F, 0.0F, 8, 8, 7, 0.0F);
/*  99 */     setRotation(this.Tail2, -0.22759093F, 0.0F, 0.0F);
/* 100 */     this.Head2 = new ModelRenderer(this, 37, 0);
/* 101 */     this.Head2.func_78793_a(0.0F, -2.2F, -0.4F);
/* 102 */     this.Head2.func_78790_a(-7.0F, -13.0F, 0.0F, 14, 13, 1, 0.0F);
/* 103 */     setRotation(this.Head2, -0.18203785F, 0.0F, 0.0F);
/* 104 */     this.FrontRightLeg2_1 = new ModelRenderer(this, 90, 65);
/* 105 */     this.FrontRightLeg2_1.func_78793_a(-2.5F, 6.9F, -0.1F);
/* 106 */     this.FrontRightLeg2_1.func_78790_a(-2.5F, 0.1F, -2.5F, 5, 7, 5, 0.0F);
/* 107 */     setRotation(this.FrontRightLeg2_1, 0.4098033F, 0.0F, 0.0F);
/* 108 */     this.Tail7 = new ModelRenderer(this, 86, 96);
/* 109 */     this.Tail7.func_78793_a(0.0F, 0.0F, 5.3F);
/* 110 */     this.Tail7.func_78790_a(-2.0F, -2.0F, 0.0F, 4, 4, 7, 0.0F);
/* 111 */     setRotation(this.Tail7, 0.13665928F, 0.0F, 0.0F);
/* 112 */     this.RHorn2 = new ModelRenderer(this, 37, 18);
/* 113 */     this.RHorn2.func_78793_a(-0.3F, -3.4F, 0.0F);
/* 114 */     this.RHorn2.func_78790_a(-1.0F, -4.0F, -1.0F, 2, 4, 2, 0.0F);
/* 115 */     setRotation(this.RHorn2, 0.0F, 0.0F, 0.59184116F);
/* 116 */     this.LHorn2 = new ModelRenderer(this, 37, 18);
/* 117 */     this.LHorn2.func_78793_a(0.3F, -3.4F, 0.0F);
/* 118 */     this.LHorn2.func_78790_a(-1.0F, -4.0F, -1.0F, 2, 4, 2, 0.0F);
/* 119 */     setRotation(this.LHorn2, 0.0F, 0.0F, -0.59184116F);
/* 120 */     this.Head4 = new ModelRenderer(this, 70, 0);
/* 121 */     this.Head4.func_78793_a(-4.5F, -2.5F, 0.0F);
/* 122 */     this.Head4.func_78790_a(-10.0F, -10.0F, -0.5F, 10, 14, 1, 0.0F);
/* 123 */     setRotation(this.Head4, -0.22759093F, 0.13665928F, -0.22759093F);
/* 124 */     this.LHorn = new ModelRenderer(this, 26, 18);
/* 125 */     this.LHorn.func_78793_a(4.2F, -3.9F, -3.2F);
/* 126 */     this.LHorn.func_78790_a(-1.0F, -4.0F, -1.0F, 2, 4, 2, 0.0F);
/* 127 */     setRotation(this.LHorn, 0.0F, 0.0F, 0.68294734F);
/* 128 */     this.LHorn4 = new ModelRenderer(this, 48, 18);
/* 129 */     this.LHorn4.func_78793_a(0.3F, -3.4F, 0.0F);
/* 130 */     this.LHorn4.func_78790_a(-0.5F, -4.0F, -0.5F, 1, 4, 1, 0.0F);
/* 131 */     setRotation(this.LHorn4, 0.0F, 0.0F, -0.31869712F);
/* 132 */     this.Tail4 = new ModelRenderer(this, 31, 112);
/* 133 */     this.Tail4.func_78793_a(0.0F, 0.0F, 5.3F);
/* 134 */     this.Tail4.func_78790_a(-3.5F, -3.5F, 0.0F, 7, 7, 7, 0.0F);
/* 135 */     setRotation(this.Tail4, 0.5009095F, 0.0F, 0.0F);
/* 136 */     this.Tail6 = new ModelRenderer(this, 86, 112);
/* 137 */     this.Tail6.func_78793_a(0.0F, 0.0F, 5.3F);
/* 138 */     this.Tail6.func_78790_a(-3.0F, -3.0F, 0.0F, 6, 6, 7, 0.0F);
/* 139 */     setRotation(this.Tail6, 0.13665928F, 0.0F, 0.0F);
/* 140 */     this.Mouth = new ModelRenderer(this, 0, 17);
/* 141 */     this.Mouth.func_78793_a(0.0F, 1.7F, -5.8F);
/* 142 */     this.Mouth.func_78790_a(-2.5F, -2.5F, -5.0F, 5, 5, 5, 0.0F);
/* 143 */     this.FrontRightLeg2 = new ModelRenderer(this, 65, 65);
/* 144 */     this.FrontRightLeg2.func_78793_a(-2.5F, 4.9F, -0.3F);
/* 145 */     this.FrontRightLeg2.func_78790_a(-2.5F, 0.1F, -2.5F, 5, 7, 5, 0.0F);
/* 146 */     setRotation(this.FrontRightLeg2, 0.4098033F, 0.0F, 0.0F);
/* 147 */     this.FronRightLeg = new ModelRenderer(this, 65, 50);
/* 148 */     this.FronRightLeg.func_78793_a(-6.0F, 7.4F, 3.3F);
/* 149 */     this.FronRightLeg.func_78790_a(-5.0F, -0.9F, -2.5F, 5, 7, 5, 0.0F);
/* 150 */     setRotation(this.FronRightLeg, -0.4098033F, 0.0F, 0.0F);
/* 151 */     this.Horn = new ModelRenderer(this, 60, 18);
/* 152 */     this.Horn.func_78793_a(0.0F, -2.2F, -3.2F);
/* 153 */     this.Horn.func_78790_a(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
/* 154 */     setRotation(this.Horn, -0.091106184F, 0.0F, 0.0F);
/* 155 */     this.FrontLeftLeg = new ModelRenderer(this, 65, 50);
/* 156 */     this.FrontLeftLeg.field_78809_i = true;
/* 157 */     this.FrontLeftLeg.func_78793_a(6.0F, 7.4F, 3.3F);
/* 158 */     this.FrontLeftLeg.func_78790_a(0.0F, -0.9F, -2.5F, 5, 7, 5, 0.0F);
/* 159 */     setRotation(this.FrontLeftLeg, -0.4098033F, 0.0F, 0.0F);
/* 160 */     this.BackLeftLeg = new ModelRenderer(this, 90, 50);
/* 161 */     this.BackLeftLeg.field_78809_i = true;
/* 162 */     this.BackLeftLeg.func_78793_a(6.0F, 5.6F, 14.6F);
/* 163 */     this.BackLeftLeg.func_78790_a(0.0F, -0.9F, -2.5F, 5, 9, 6, 0.0F);
/* 164 */     setRotation(this.BackLeftLeg, -0.4098033F, 0.0F, 0.0F);
/* 165 */     this.BackRightLeg = new ModelRenderer(this, 90, 50);
/* 166 */     this.BackRightLeg.func_78793_a(-6.0F, 5.6F, 14.6F);
/* 167 */     this.BackRightLeg.func_78790_a(-5.0F, -0.9F, -2.5F, 5, 9, 6, 0.0F);
/* 168 */     setRotation(this.BackRightLeg, -0.4098033F, 0.0F, 0.0F);
/* 169 */     this.Tail5 = new ModelRenderer(this, 59, 112);
/* 170 */     this.Tail5.func_78793_a(0.0F, 0.0F, 5.3F);
/* 171 */     this.Tail5.func_78790_a(-3.0F, -3.0F, 0.0F, 6, 6, 7, 0.0F);
/* 172 */     setRotation(this.Tail5, 0.13665928F, 0.0F, 0.0F);
/* 173 */     this.BackLeftLeg.func_78792_a(this.FrontLeftLeg2_1);
/* 174 */     this.Body.func_78792_a(this.Tail1);
/* 175 */     this.Body.func_78792_a(this.Body_1);
/* 176 */     this.RHorn2.func_78792_a(this.RHorn4);
/* 177 */     this.Tail2.func_78792_a(this.Tail3);
/* 178 */     this.FrontLeftLeg.func_78792_a(this.FrontLeftLeg2);
/* 179 */     this.Head.func_78792_a(this.Head3);
/* 180 */     this.Head.func_78792_a(this.RHorn);
/* 181 */     this.Body.func_78792_a(this.Head);
/* 182 */     this.Tail1.func_78792_a(this.Tail2);
/* 183 */     this.Head.func_78792_a(this.Head2);
/* 184 */     this.BackRightLeg.func_78792_a(this.FrontRightLeg2_1);
/* 185 */     this.Tail6.func_78792_a(this.Tail7);
/* 186 */     this.RHorn.func_78792_a(this.RHorn2);
/* 187 */     this.LHorn.func_78792_a(this.LHorn2);
/* 188 */     this.Head.func_78792_a(this.Head4);
/* 189 */     this.Head.func_78792_a(this.LHorn);
/* 190 */     this.LHorn2.func_78792_a(this.LHorn4);
/* 191 */     this.Tail3.func_78792_a(this.Tail4);
/* 192 */     this.Tail5.func_78792_a(this.Tail6);
/* 193 */     this.Head.func_78792_a(this.Mouth);
/* 194 */     this.FronRightLeg.func_78792_a(this.FrontRightLeg2);
/* 195 */     this.Body.func_78792_a(this.FronRightLeg);
/* 196 */     this.Mouth.func_78792_a(this.Horn);
/* 197 */     this.Body.func_78792_a(this.FrontLeftLeg);
/* 198 */     this.Body.func_78792_a(this.BackLeftLeg);
/* 199 */     this.Body.func_78792_a(this.BackRightLeg);
/* 200 */     this.Tail4.func_78792_a(this.Tail5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 207 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 208 */     GL11.glPushMatrix();
/* 209 */     GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 210 */     GL11.glTranslatef(0.0F, -0.74F, 0.0F);
/* 211 */     this.Body.func_78785_a(f5);
/* 212 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 216 */     model.field_78795_f = x;
/* 217 */     model.field_78796_g = y;
/* 218 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 223 */     float r = 360.0F;
/* 224 */     float r2 = 180.0F;
/* 225 */     float n4 = par4;
/* 226 */     float n5 = par5;
/* 227 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 228 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 229 */     this.FronRightLeg.field_78795_f = -0.4F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 230 */     this.FrontLeftLeg.field_78795_f = -0.4F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 231 */     this.BackRightLeg.field_78795_f = -0.4F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 232 */     this.BackLeftLeg.field_78795_f = -0.4F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 233 */     this.FronRightLeg.field_78796_g = 0.0F;
/* 234 */     this.FrontLeftLeg.field_78796_g = 0.0F;
/* 235 */     this.BackRightLeg.field_78796_g = 0.0F;
/* 236 */     this.BackLeftLeg.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 239 */     float ex = par7Entity.field_70173_aa;
/* 240 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 241 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 4.0F - 0.2F;
/* 242 */     this.Tail1.field_78796_g = 0.2F;
/* 243 */     this.Tail1.field_78796_g += r4;
/*     */     
/* 245 */     this.Tail2.field_78796_g = 0.2F;
/* 246 */     this.Tail2.field_78796_g += r4;
/*     */     
/* 248 */     this.Tail3.field_78796_g = 0.2F;
/* 249 */     this.Tail3.field_78796_g += r4;
/*     */     
/* 251 */     this.Tail4.field_78796_g = 0.2F;
/* 252 */     this.Tail4.field_78796_g += r4;
/*     */     
/* 254 */     this.Tail5.field_78796_g = 0.2F;
/* 255 */     this.Tail5.field_78796_g += r4;
/*     */     
/* 257 */     this.Tail6.field_78796_g = 0.2F;
/* 258 */     this.Tail6.field_78796_g += r4;
/*     */     
/* 260 */     this.Tail7.field_78796_g = 0.2F;
/* 261 */     this.Tail7.field_78796_g += r4;
/*     */ 
/*     */     
/* 264 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelDino03.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */