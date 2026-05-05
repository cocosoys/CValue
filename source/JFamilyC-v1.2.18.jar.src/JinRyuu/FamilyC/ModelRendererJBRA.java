/*     */ package JinRyuu.FamilyC;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.TextureOffset;
/*     */ import net.minecraft.client.renderer.GLAllocation;
/*     */ import net.minecraft.client.renderer.Tessellator;
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
/*     */ public class ModelRendererJBRA
/*     */ {
/*     */   public float textureWidth;
/*     */   public float textureHeight;
/*     */   private int textureOffsetX;
/*     */   private int textureOffsetY;
/*     */   public float rotationPointX;
/*     */   public float rotationPointY;
/*     */   public float rotationPointZ;
/*     */   public float rotateAngleX;
/*     */   public float rotateAngleY;
/*     */   public float rotateAngleZ;
/*     */   private boolean compiled;
/*     */   private int displayList;
/*     */   public boolean mirror;
/*     */   public boolean showModel;
/*     */   public boolean isHidden;
/*     */   public List cubeList;
/*     */   public List childModels;
/*     */   public final String boxName;
/*     */   private ModelBase baseModel;
/*     */   public float offsetX;
/*     */   public float offsetY;
/*     */   public float offsetZ;
/*     */   private static final String __OBFID = "CL_00000874";
/*  47 */   public float lengthY = 1.0F;
/*  48 */   public float sizeXZ = 1.0F;
/*     */ 
/*     */   
/*     */   public ModelRendererJBRA(ModelBase p_i1172_1_, String p_i1172_2_) {
/*  52 */     this.textureWidth = 64.0F;
/*  53 */     this.textureHeight = 32.0F;
/*  54 */     this.showModel = true;
/*  55 */     this.cubeList = new ArrayList();
/*  56 */     this.baseModel = p_i1172_1_;
/*  57 */     p_i1172_1_.field_78092_r.add(this);
/*  58 */     this.boxName = p_i1172_2_;
/*  59 */     setTextureSize(p_i1172_1_.field_78090_t, p_i1172_1_.field_78089_u);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelRendererJBRA(ModelBase p_i1173_1_) {
/*  64 */     this(p_i1173_1_, (String)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelRendererJBRA(ModelBase p_i1174_1_, int p_i1174_2_, int p_i1174_3_) {
/*  69 */     this(p_i1174_1_);
/*  70 */     setTextureOffset(p_i1174_2_, p_i1174_3_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addChild(ModelRendererJBRA p_78792_1_) {
/*  78 */     if (this.childModels == null)
/*     */     {
/*  80 */       this.childModels = new ArrayList();
/*     */     }
/*     */     
/*  83 */     this.childModels.add(p_78792_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelRendererJBRA setTextureOffset(int p_78784_1_, int p_78784_2_) {
/*  88 */     this.textureOffsetX = p_78784_1_;
/*  89 */     this.textureOffsetY = p_78784_2_;
/*  90 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelRendererJBRA addBox(String p_78786_1_, float p_78786_2_, float p_78786_3_, float p_78786_4_, int p_78786_5_, int p_78786_6_, int p_78786_7_) {
/*  95 */     p_78786_1_ = this.boxName + "." + p_78786_1_;
/*  96 */     TextureOffset textureoffset = this.baseModel.func_78084_a(p_78786_1_);
/*  97 */     setTextureOffset(textureoffset.field_78783_a, textureoffset.field_78782_b);
/*  98 */     this.cubeList.add((new ModelBoxJBRA(this, this.textureOffsetX, this.textureOffsetY, p_78786_2_, p_78786_3_, p_78786_4_, p_78786_5_, p_78786_6_, p_78786_7_, 0.0F)).func_78244_a(p_78786_1_));
/*  99 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelRendererJBRA addBox(float p_78789_1_, float p_78789_2_, float p_78789_3_, int p_78789_4_, int p_78789_5_, int p_78789_6_) {
/* 104 */     this.cubeList.add(new ModelBoxJBRA(this, this.textureOffsetX, this.textureOffsetY, p_78789_1_, p_78789_2_, p_78789_3_, p_78789_4_, p_78789_5_, p_78789_6_, 0.0F));
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addBox(float p_78790_1_, float p_78790_2_, float p_78790_3_, int p_78790_4_, int p_78790_5_, int p_78790_6_, float p_78790_7_) {
/* 113 */     this.cubeList.add(new ModelBoxJBRA(this, this.textureOffsetX, this.textureOffsetY, p_78790_1_, p_78790_2_, p_78790_3_, p_78790_4_, p_78790_5_, p_78790_6_, p_78790_7_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationPoint(float p_78793_1_, float p_78793_2_, float p_78793_3_) {
/* 118 */     this.rotationPointX = p_78793_1_;
/* 119 */     this.rotationPointY = p_78793_2_;
/* 120 */     this.rotationPointZ = p_78793_3_;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void render(float p_78785_1_) {
/* 126 */     if (!this.isHidden)
/*     */     {
/* 128 */       if (this.showModel) {
/*     */         
/* 130 */         if (!this.compiled)
/*     */         {
/* 132 */           compileDisplayList(p_78785_1_);
/*     */         }
/*     */         
/* 135 */         GL11.glTranslatef(this.offsetX, this.offsetY, this.offsetZ);
/*     */ 
/*     */         
/* 138 */         if (this.rotateAngleX == 0.0F && this.rotateAngleY == 0.0F && this.rotateAngleZ == 0.0F) {
/*     */           
/* 140 */           if (this.rotationPointX == 0.0F && this.rotationPointY == 0.0F && this.rotationPointZ == 0.0F)
/*     */           {
/* 142 */             GL11.glCallList(this.displayList);
/*     */             
/* 144 */             if (this.childModels != null)
/*     */             {
/* 146 */               for (int i = 0; i < this.childModels.size(); i++)
/*     */               {
/* 148 */                 ((ModelRendererJBRA)this.childModels.get(i)).render(p_78785_1_);
/*     */               }
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 154 */             GL11.glTranslatef(this.rotationPointX * p_78785_1_, this.rotationPointY * p_78785_1_, this.rotationPointZ * p_78785_1_);
/* 155 */             GL11.glScalef(this.sizeXZ, this.lengthY, this.sizeXZ);
/* 156 */             GL11.glCallList(this.displayList);
/* 157 */             GL11.glScalef(1.0F / this.sizeXZ, 1.0F / this.lengthY, 1.0F / this.sizeXZ);
/*     */             
/* 159 */             if (this.childModels != null)
/*     */             {
/* 161 */               for (int i = 0; i < this.childModels.size(); i++)
/*     */               {
/* 163 */                 ((ModelRendererJBRA)this.childModels.get(i)).render(p_78785_1_);
/*     */               }
/*     */             }
/* 166 */             GL11.glTranslatef(-this.rotationPointX * p_78785_1_, -this.rotationPointY * p_78785_1_, -this.rotationPointZ * p_78785_1_);
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 171 */           GL11.glPushMatrix();
/* 172 */           GL11.glTranslatef(this.rotationPointX * p_78785_1_, this.rotationPointY * p_78785_1_, this.rotationPointZ * p_78785_1_);
/*     */           
/* 174 */           if (this.rotateAngleZ != 0.0F)
/*     */           {
/* 176 */             GL11.glRotatef(this.rotateAngleZ * 57.295776F, 0.0F, 0.0F, 1.0F);
/*     */           }
/*     */           
/* 179 */           if (this.rotateAngleY != 0.0F)
/*     */           {
/* 181 */             GL11.glRotatef(this.rotateAngleY * 57.295776F, 0.0F, 1.0F, 0.0F);
/*     */           }
/*     */           
/* 184 */           if (this.rotateAngleX != 0.0F)
/*     */           {
/* 186 */             GL11.glRotatef(this.rotateAngleX * 57.295776F, 1.0F, 0.0F, 0.0F);
/*     */           }
/* 188 */           GL11.glScalef(this.sizeXZ, this.lengthY, this.sizeXZ);
/*     */           
/* 190 */           GL11.glCallList(this.displayList);
/*     */           
/* 192 */           GL11.glScalef(1.0F / this.sizeXZ, 1.0F / this.lengthY, 1.0F / this.sizeXZ);
/* 193 */           GL11.glTranslatef(0.0F, this.lengthY * 0.15F - 0.15F, 0.0F);
/*     */           
/* 195 */           if (this.childModels != null)
/*     */           {
/* 197 */             for (int i = 0; i < this.childModels.size(); i++)
/*     */             {
/* 199 */               ((ModelRendererJBRA)this.childModels.get(i)).render(p_78785_1_);
/*     */             }
/*     */           }
/*     */           
/* 203 */           GL11.glPopMatrix();
/*     */         } 
/*     */         
/* 206 */         GL11.glTranslatef(-this.offsetX, -this.offsetY, -this.offsetZ);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void renderWithRotation(float p_78791_1_) {
/* 214 */     if (!this.isHidden)
/*     */     {
/* 216 */       if (this.showModel) {
/*     */         
/* 218 */         if (!this.compiled)
/*     */         {
/* 220 */           compileDisplayList(p_78791_1_);
/*     */         }
/*     */         
/* 223 */         GL11.glPushMatrix();
/* 224 */         GL11.glTranslatef(this.rotationPointX * p_78791_1_, this.rotationPointY * p_78791_1_, this.rotationPointZ * p_78791_1_);
/*     */         
/* 226 */         if (this.rotateAngleY != 0.0F)
/*     */         {
/* 228 */           GL11.glRotatef(this.rotateAngleY * 57.295776F, 0.0F, 1.0F, 0.0F);
/*     */         }
/*     */         
/* 231 */         if (this.rotateAngleX != 0.0F)
/*     */         {
/* 233 */           GL11.glRotatef(this.rotateAngleX * 57.295776F, 1.0F, 0.0F, 0.0F);
/*     */         }
/*     */         
/* 236 */         if (this.rotateAngleZ != 0.0F)
/*     */         {
/* 238 */           GL11.glRotatef(this.rotateAngleZ * 57.295776F, 0.0F, 0.0F, 1.0F);
/*     */         }
/*     */         
/* 241 */         GL11.glCallList(this.displayList);
/* 242 */         GL11.glPopMatrix();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void postRender(float p_78794_1_) {
/* 253 */     if (!this.isHidden)
/*     */     {
/* 255 */       if (this.showModel) {
/*     */         
/* 257 */         if (!this.compiled)
/*     */         {
/* 259 */           compileDisplayList(p_78794_1_);
/*     */         }
/*     */         
/* 262 */         if (this.rotateAngleX == 0.0F && this.rotateAngleY == 0.0F && this.rotateAngleZ == 0.0F) {
/*     */           
/* 264 */           if (this.rotationPointX != 0.0F || this.rotationPointY != 0.0F || this.rotationPointZ != 0.0F)
/*     */           {
/* 266 */             GL11.glTranslatef(this.rotationPointX * p_78794_1_, this.rotationPointY * p_78794_1_, this.rotationPointZ * p_78794_1_);
/*     */           }
/*     */         }
/*     */         else {
/*     */           
/* 271 */           GL11.glTranslatef(this.rotationPointX * p_78794_1_, this.rotationPointY * p_78794_1_, this.rotationPointZ * p_78794_1_);
/*     */           
/* 273 */           if (this.rotateAngleZ != 0.0F)
/*     */           {
/* 275 */             GL11.glRotatef(this.rotateAngleZ * 57.295776F, 0.0F, 0.0F, 1.0F);
/*     */           }
/*     */           
/* 278 */           if (this.rotateAngleY != 0.0F)
/*     */           {
/* 280 */             GL11.glRotatef(this.rotateAngleY * 57.295776F, 0.0F, 1.0F, 0.0F);
/*     */           }
/*     */           
/* 283 */           if (this.rotateAngleX != 0.0F)
/*     */           {
/* 285 */             GL11.glRotatef(this.rotateAngleX * 57.295776F, 1.0F, 0.0F, 0.0F);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private void compileDisplayList(float p_78788_1_) {
/* 298 */     this.displayList = GLAllocation.func_74526_a(1);
/* 299 */     GL11.glNewList(this.displayList, 4864);
/* 300 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 302 */     for (int i = 0; i < this.cubeList.size(); i++)
/*     */     {
/* 304 */       ((ModelBoxJBRA)this.cubeList.get(i)).render(tessellator, p_78788_1_);
/*     */     }
/*     */     
/* 307 */     GL11.glEndList();
/* 308 */     this.compiled = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelRendererJBRA setTextureSize(int p_78787_1_, int p_78787_2_) {
/* 316 */     this.textureWidth = p_78787_1_;
/* 317 */     this.textureHeight = p_78787_2_;
/* 318 */     return this;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\ModelRendererJBRA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */