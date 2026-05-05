/*     */ package net.minecraft.client.model;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.GLAllocation;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelRenderer
/*     */ {
/*  16 */   public float field_78801_a = 64.0F;
/*  17 */   public float field_78799_b = 32.0F;
/*     */   private int field_78803_o;
/*     */   private int field_78813_p;
/*     */   public float field_78800_c;
/*     */   public float field_78797_d;
/*     */   public float field_78798_e;
/*     */   public float field_78795_f;
/*     */   public float field_78796_g;
/*     */   public float field_78808_h;
/*     */   private boolean field_78812_q;
/*     */   private int field_78811_r;
/*     */   public boolean field_78809_i;
/*     */   public boolean field_78806_j = true;
/*     */   public boolean field_78807_k;
/*  31 */   public List field_78804_l = new ArrayList();
/*     */   
/*     */   public List field_78805_m;
/*     */   
/*     */   public final String field_78802_n;
/*     */   private ModelBase field_78810_s;
/*     */   
/*     */   public ModelRenderer(ModelBase p_i1172_1_, String p_i1172_2_) {
/*  39 */     this.field_78810_s = p_i1172_1_;
/*  40 */     p_i1172_1_.field_78092_r.add(this);
/*  41 */     this.field_78802_n = p_i1172_2_;
/*  42 */     func_78787_b(p_i1172_1_.field_78090_t, p_i1172_1_.field_78089_u);
/*     */   }
/*     */   public float field_82906_o; public float field_82908_p; public float field_82907_q; private static final String __OBFID = "CL_00000874";
/*     */   public ModelRenderer(ModelBase p_i1173_1_) {
/*  46 */     this(p_i1173_1_, null);
/*     */   }
/*     */   
/*     */   public ModelRenderer(ModelBase p_i1174_1_, int p_i1174_2_, int p_i1174_3_) {
/*  50 */     this(p_i1174_1_);
/*  51 */     func_78784_a(p_i1174_2_, p_i1174_3_);
/*     */   }
/*     */   
/*     */   public void func_78792_a(ModelRenderer p_78792_1_) {
/*  55 */     if (this.field_78805_m == null) this.field_78805_m = new ArrayList(); 
/*  56 */     this.field_78805_m.add(p_78792_1_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelRenderer func_78784_a(int p_78784_1_, int p_78784_2_) {
/*  65 */     this.field_78803_o = p_78784_1_;
/*  66 */     this.field_78813_p = p_78784_2_;
/*  67 */     return this;
/*     */   }
/*     */   
/*     */   public ModelRenderer func_78786_a(String p_78786_1_, float p_78786_2_, float p_78786_3_, float p_78786_4_, int p_78786_5_, int p_78786_6_, int p_78786_7_) {
/*  71 */     p_78786_1_ = this.field_78802_n + "." + p_78786_1_;
/*  72 */     TextureOffset textureOffset = this.field_78810_s.func_78084_a(p_78786_1_);
/*  73 */     func_78784_a(textureOffset.field_78783_a, textureOffset.field_78782_b);
/*  74 */     this.field_78804_l.add((new ModelBox(this, this.field_78803_o, this.field_78813_p, p_78786_2_, p_78786_3_, p_78786_4_, p_78786_5_, p_78786_6_, p_78786_7_, 0.0F)).func_78244_a(p_78786_1_));
/*  75 */     return this;
/*     */   }
/*     */   
/*     */   public ModelRenderer func_78789_a(float p_78789_1_, float p_78789_2_, float p_78789_3_, int p_78789_4_, int p_78789_5_, int p_78789_6_) {
/*  79 */     this.field_78804_l.add(new ModelBox(this, this.field_78803_o, this.field_78813_p, p_78789_1_, p_78789_2_, p_78789_3_, p_78789_4_, p_78789_5_, p_78789_6_, 0.0F));
/*  80 */     return this;
/*     */   }
/*     */   
/*     */   public void func_78790_a(float p_78790_1_, float p_78790_2_, float p_78790_3_, int p_78790_4_, int p_78790_5_, int p_78790_6_, float p_78790_7_) {
/*  84 */     this.field_78804_l.add(new ModelBox(this, this.field_78803_o, this.field_78813_p, p_78790_1_, p_78790_2_, p_78790_3_, p_78790_4_, p_78790_5_, p_78790_6_, p_78790_7_));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78793_a(float p_78793_1_, float p_78793_2_, float p_78793_3_) {
/*  92 */     this.field_78800_c = p_78793_1_;
/*  93 */     this.field_78797_d = p_78793_2_;
/*  94 */     this.field_78798_e = p_78793_3_;
/*     */   }
/*     */   
/*     */   public void func_78785_a(float p_78785_1_) {
/*  98 */     if (this.field_78807_k)
/*  99 */       return;  if (!this.field_78806_j)
/* 100 */       return;  if (!this.field_78812_q) func_78788_d(p_78785_1_);
/*     */     
/* 102 */     GL11.glTranslatef(this.field_82906_o, this.field_82908_p, this.field_82907_q);
/*     */     
/* 104 */     if (this.field_78795_f != 0.0F || this.field_78796_g != 0.0F || this.field_78808_h != 0.0F) {
/* 105 */       GL11.glPushMatrix();
/* 106 */       GL11.glTranslatef(this.field_78800_c * p_78785_1_, this.field_78797_d * p_78785_1_, this.field_78798_e * p_78785_1_);
/* 107 */       if (this.field_78808_h != 0.0F) GL11.glRotatef(this.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F); 
/* 108 */       if (this.field_78796_g != 0.0F) GL11.glRotatef(this.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F); 
/* 109 */       if (this.field_78795_f != 0.0F) GL11.glRotatef(this.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F); 
/* 110 */       GL11.glCallList(this.field_78811_r);
/* 111 */       if (this.field_78805_m != null) {
/* 112 */         for (byte b = 0; b < this.field_78805_m.size(); b++) {
/* 113 */           ((ModelRenderer)this.field_78805_m.get(b)).func_78785_a(p_78785_1_);
/*     */         }
/*     */       }
/* 116 */       GL11.glPopMatrix();
/* 117 */     } else if (this.field_78800_c != 0.0F || this.field_78797_d != 0.0F || this.field_78798_e != 0.0F) {
/* 118 */       GL11.glTranslatef(this.field_78800_c * p_78785_1_, this.field_78797_d * p_78785_1_, this.field_78798_e * p_78785_1_);
/* 119 */       GL11.glCallList(this.field_78811_r);
/* 120 */       if (this.field_78805_m != null) {
/* 121 */         for (byte b = 0; b < this.field_78805_m.size(); b++) {
/* 122 */           ((ModelRenderer)this.field_78805_m.get(b)).func_78785_a(p_78785_1_);
/*     */         }
/*     */       }
/* 125 */       GL11.glTranslatef(-this.field_78800_c * p_78785_1_, -this.field_78797_d * p_78785_1_, -this.field_78798_e * p_78785_1_);
/*     */     } else {
/* 127 */       GL11.glCallList(this.field_78811_r);
/* 128 */       if (this.field_78805_m != null) {
/* 129 */         for (byte b = 0; b < this.field_78805_m.size(); b++) {
/* 130 */           ((ModelRenderer)this.field_78805_m.get(b)).func_78785_a(p_78785_1_);
/*     */         }
/*     */       }
/*     */     } 
/*     */     
/* 135 */     GL11.glTranslatef(-this.field_82906_o, -this.field_82908_p, -this.field_82907_q);
/*     */   }
/*     */   
/*     */   public void func_78791_b(float p_78791_1_) {
/* 139 */     if (this.field_78807_k)
/* 140 */       return;  if (!this.field_78806_j)
/* 141 */       return;  if (!this.field_78812_q) func_78788_d(p_78791_1_);
/*     */     
/* 143 */     GL11.glPushMatrix();
/* 144 */     GL11.glTranslatef(this.field_78800_c * p_78791_1_, this.field_78797_d * p_78791_1_, this.field_78798_e * p_78791_1_);
/* 145 */     if (this.field_78796_g != 0.0F) GL11.glRotatef(this.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F); 
/* 146 */     if (this.field_78795_f != 0.0F) GL11.glRotatef(this.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F); 
/* 147 */     if (this.field_78808_h != 0.0F) GL11.glRotatef(this.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F); 
/* 148 */     GL11.glCallList(this.field_78811_r);
/* 149 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78794_c(float p_78794_1_) {
/* 154 */     if (this.field_78807_k)
/* 155 */       return;  if (!this.field_78806_j)
/* 156 */       return;  if (!this.field_78812_q) func_78788_d(p_78794_1_);
/*     */     
/* 158 */     if (this.field_78795_f != 0.0F || this.field_78796_g != 0.0F || this.field_78808_h != 0.0F) {
/* 159 */       GL11.glTranslatef(this.field_78800_c * p_78794_1_, this.field_78797_d * p_78794_1_, this.field_78798_e * p_78794_1_);
/* 160 */       if (this.field_78808_h != 0.0F) GL11.glRotatef(this.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F); 
/* 161 */       if (this.field_78796_g != 0.0F) GL11.glRotatef(this.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F); 
/* 162 */       if (this.field_78795_f != 0.0F) GL11.glRotatef(this.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F); 
/* 163 */     } else if (this.field_78800_c != 0.0F || this.field_78797_d != 0.0F || this.field_78798_e != 0.0F) {
/* 164 */       GL11.glTranslatef(this.field_78800_c * p_78794_1_, this.field_78797_d * p_78794_1_, this.field_78798_e * p_78794_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_78788_d(float p_78788_1_) {
/* 169 */     this.field_78811_r = GLAllocation.func_74526_a(1);
/*     */     
/* 171 */     GL11.glNewList(this.field_78811_r, 4864);
/* 172 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 173 */     for (byte b = 0; b < this.field_78804_l.size(); b++) {
/* 174 */       ((ModelBox)this.field_78804_l.get(b)).func_78245_a(tessellator, p_78788_1_);
/*     */     }
/* 176 */     GL11.glEndList();
/*     */     
/* 178 */     this.field_78812_q = true;
/*     */   }
/*     */   
/*     */   public ModelRenderer func_78787_b(int p_78787_1_, int p_78787_2_) {
/* 182 */     this.field_78801_a = p_78787_1_;
/* 183 */     this.field_78799_b = p_78787_2_;
/* 184 */     return this;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */