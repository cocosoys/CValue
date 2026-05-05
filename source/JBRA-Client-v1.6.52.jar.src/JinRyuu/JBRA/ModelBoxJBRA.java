/*     */ package JinRyuu.JBRA;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.PositionTextureVertex;
/*     */ import net.minecraft.client.model.TexturedQuad;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelBoxJBRA
/*     */ {
/*     */   private PositionTextureVertex[] vertexPositions;
/*     */   private TexturedQuad[] quadList;
/*     */   public final float posX1;
/*     */   public final float posY1;
/*     */   public final float posZ1;
/*     */   public final float posX2;
/*     */   public final float posY2;
/*     */   public final float posZ2;
/*     */   public String field_78247_g;
/*     */   private static final String __OBFID = "CL_00000872";
/*     */   
/*     */   public ModelBoxJBRA(ModelRendererJBRA modelRendererJBRA, int p_i1171_2_, int p_i1171_3_, float p_i1171_4_, float p_i1171_5_, float p_i1171_6_, int p_i1171_7_, int p_i1171_8_, int p_i1171_9_, float p_i1171_10_) {
/*  32 */     this.posX1 = p_i1171_4_;
/*  33 */     this.posY1 = p_i1171_5_;
/*  34 */     this.posZ1 = p_i1171_6_;
/*  35 */     this.posX2 = p_i1171_4_ + p_i1171_7_;
/*  36 */     this.posY2 = p_i1171_5_ + p_i1171_8_;
/*  37 */     this.posZ2 = p_i1171_6_ + p_i1171_9_;
/*  38 */     this.vertexPositions = new PositionTextureVertex[8];
/*  39 */     this.quadList = new TexturedQuad[6];
/*  40 */     float f4 = p_i1171_4_ + p_i1171_7_;
/*  41 */     float f5 = p_i1171_5_ + p_i1171_8_;
/*  42 */     float f6 = p_i1171_6_ + p_i1171_9_;
/*  43 */     p_i1171_4_ -= p_i1171_10_;
/*  44 */     p_i1171_5_ -= p_i1171_10_;
/*  45 */     p_i1171_6_ -= p_i1171_10_;
/*  46 */     f4 += p_i1171_10_;
/*  47 */     f5 += p_i1171_10_;
/*  48 */     f6 += p_i1171_10_;
/*     */     
/*  50 */     if (modelRendererJBRA.mirror) {
/*     */       
/*  52 */       float f7 = f4;
/*  53 */       f4 = p_i1171_4_;
/*  54 */       p_i1171_4_ = f7;
/*     */     } 
/*     */     
/*  57 */     PositionTextureVertex positiontexturevertex7 = new PositionTextureVertex(p_i1171_4_, p_i1171_5_, p_i1171_6_, 0.0F, 0.0F);
/*  58 */     PositionTextureVertex positiontexturevertex = new PositionTextureVertex(f4, p_i1171_5_, p_i1171_6_, 0.0F, 8.0F);
/*  59 */     PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(f4, f5, p_i1171_6_, 8.0F, 8.0F);
/*  60 */     PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(p_i1171_4_, f5, p_i1171_6_, 8.0F, 0.0F);
/*  61 */     PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(p_i1171_4_, p_i1171_5_, f6, 0.0F, 0.0F);
/*  62 */     PositionTextureVertex positiontexturevertex4 = new PositionTextureVertex(f4, p_i1171_5_, f6, 0.0F, 8.0F);
/*  63 */     PositionTextureVertex positiontexturevertex5 = new PositionTextureVertex(f4, f5, f6, 8.0F, 8.0F);
/*  64 */     PositionTextureVertex positiontexturevertex6 = new PositionTextureVertex(p_i1171_4_, f5, f6, 8.0F, 0.0F);
/*  65 */     this.vertexPositions[0] = positiontexturevertex7;
/*  66 */     this.vertexPositions[1] = positiontexturevertex;
/*  67 */     this.vertexPositions[2] = positiontexturevertex1;
/*  68 */     this.vertexPositions[3] = positiontexturevertex2;
/*  69 */     this.vertexPositions[4] = positiontexturevertex3;
/*  70 */     this.vertexPositions[5] = positiontexturevertex4;
/*  71 */     this.vertexPositions[6] = positiontexturevertex5;
/*  72 */     this.vertexPositions[7] = positiontexturevertex6;
/*  73 */     this.quadList[0] = new TexturedQuad(new PositionTextureVertex[] { positiontexturevertex4, positiontexturevertex, positiontexturevertex1, positiontexturevertex5 }, p_i1171_2_ + p_i1171_9_ + p_i1171_7_, p_i1171_3_ + p_i1171_9_, p_i1171_2_ + p_i1171_9_ + p_i1171_7_ + p_i1171_9_, p_i1171_3_ + p_i1171_9_ + p_i1171_8_, modelRendererJBRA.textureWidth, modelRendererJBRA.textureHeight);
/*  74 */     this.quadList[1] = new TexturedQuad(new PositionTextureVertex[] { positiontexturevertex7, positiontexturevertex3, positiontexturevertex6, positiontexturevertex2 }, p_i1171_2_, p_i1171_3_ + p_i1171_9_, p_i1171_2_ + p_i1171_9_, p_i1171_3_ + p_i1171_9_ + p_i1171_8_, modelRendererJBRA.textureWidth, modelRendererJBRA.textureHeight);
/*  75 */     this.quadList[2] = new TexturedQuad(new PositionTextureVertex[] { positiontexturevertex4, positiontexturevertex3, positiontexturevertex7, positiontexturevertex }, p_i1171_2_ + p_i1171_9_, p_i1171_3_, p_i1171_2_ + p_i1171_9_ + p_i1171_7_, p_i1171_3_ + p_i1171_9_, modelRendererJBRA.textureWidth, modelRendererJBRA.textureHeight);
/*  76 */     this.quadList[3] = new TexturedQuad(new PositionTextureVertex[] { positiontexturevertex1, positiontexturevertex2, positiontexturevertex6, positiontexturevertex5 }, p_i1171_2_ + p_i1171_9_ + p_i1171_7_, p_i1171_3_ + p_i1171_9_, p_i1171_2_ + p_i1171_9_ + p_i1171_7_ + p_i1171_7_, p_i1171_3_, modelRendererJBRA.textureWidth, modelRendererJBRA.textureHeight);
/*  77 */     this.quadList[4] = new TexturedQuad(new PositionTextureVertex[] { positiontexturevertex, positiontexturevertex7, positiontexturevertex2, positiontexturevertex1 }, p_i1171_2_ + p_i1171_9_, p_i1171_3_ + p_i1171_9_, p_i1171_2_ + p_i1171_9_ + p_i1171_7_, p_i1171_3_ + p_i1171_9_ + p_i1171_8_, modelRendererJBRA.textureWidth, modelRendererJBRA.textureHeight);
/*  78 */     this.quadList[5] = new TexturedQuad(new PositionTextureVertex[] { positiontexturevertex3, positiontexturevertex4, positiontexturevertex5, positiontexturevertex6 }, p_i1171_2_ + p_i1171_9_ + p_i1171_7_ + p_i1171_9_, p_i1171_3_ + p_i1171_9_, p_i1171_2_ + p_i1171_9_ + p_i1171_7_ + p_i1171_9_ + p_i1171_7_, p_i1171_3_ + p_i1171_9_ + p_i1171_8_, modelRendererJBRA.textureWidth, modelRendererJBRA.textureHeight);
/*     */     
/*  80 */     if (modelRendererJBRA.mirror)
/*     */     {
/*  82 */       for (int j1 = 0; j1 < this.quadList.length; j1++)
/*     */       {
/*  84 */         this.quadList[j1].func_78235_a();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void render(Tessellator p_78245_1_, float p_78245_2_) {
/*  95 */     for (int i = 0; i < this.quadList.length; i++)
/*     */     {
/*  97 */       this.quadList[i].func_78236_a(p_78245_1_, p_78245_2_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelBoxJBRA func_78244_a(String p_78244_1_) {
/* 103 */     this.field_78247_g = p_78244_1_;
/* 104 */     return this;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JBRA-Client-v1.6.52.jar!\JinRyuu\JBRA\ModelBoxJBRA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */