/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.manager.AttributeArray;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelNPCTraining
/*     */   extends JGModel
/*     */ {
/*  14 */   private final int ANIMATION_STAND = 0; private final int ANIMATION_LEFT_PUNCH = 1; private final int ANIMATION_RIGHT_PUNCH = 2; private final int ANIMATION_LEFT_KICK = 3; private final int ANIMATION_RIGHT_KICK = 4; private final int ANIMATION_HURT = 5; private final int ANIMATION_VICTORY = 6; private final int ANIMATION_DEFEAT = 7;
/*     */   
/*     */   public ModelRenderer head;
/*     */   
/*     */   public ModelRenderer body;
/*     */   public ModelRenderer rightarm;
/*     */   public ModelRenderer leftarm;
/*     */   public ModelRenderer rightleg;
/*     */   public ModelRenderer leftleg;
/*     */   public ModelRenderer rightarm2;
/*     */   public ModelRenderer leftarm2;
/*     */   public ModelRenderer rightleg2;
/*     */   public ModelRenderer leftleg2;
/*     */   
/*     */   public ModelNPCTraining() {
/*  29 */     super(64, 64);
/*  30 */     this.rightarm2 = new ModelRenderer(this, 40, 26);
/*  31 */     this.rightarm2.func_78793_a(0.0F, 4.0F, 0.0F);
/*  32 */     this.rightarm2.func_78790_a(-3.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  33 */     this.leftarm = new ModelRenderer(this, 32, 36);
/*  34 */     this.leftarm.func_78793_a(5.0F, 2.0F, 0.0F);
/*  35 */     this.leftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
/*  36 */     this.leftleg2 = new ModelRenderer(this, 16, 46);
/*  37 */     this.leftleg2.func_78793_a(0.0F, 6.0F, 0.0F);
/*  38 */     this.leftleg2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  39 */     this.rightarm = new ModelRenderer(this, 40, 16);
/*  40 */     this.rightarm.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  41 */     this.rightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
/*  42 */     this.body = new ModelRenderer(this, 16, 16);
/*  43 */     this.body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  45 */     this.rightleg = new ModelRenderer(this, 0, 16);
/*  46 */     this.rightleg.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  47 */     this.rightleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  48 */     this.rightleg2 = new ModelRenderer(this, 0, 26);
/*  49 */     this.rightleg2.func_78793_a(0.0F, 6.0F, 0.0F);
/*  50 */     this.rightleg2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  51 */     this.leftleg = new ModelRenderer(this, 16, 36);
/*  52 */     this.leftleg.func_78793_a(1.9F, 12.0F, 0.0F);
/*  53 */     this.leftleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  54 */     this.leftarm2 = new ModelRenderer(this, 32, 46);
/*  55 */     this.leftarm2.func_78793_a(0.0F, 4.0F, 0.0F);
/*  56 */     this.leftarm2.func_78790_a(-1.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  57 */     this.head = new ModelRenderer(this, 0, 0);
/*  58 */     this.head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  59 */     this.head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  60 */     this.leftarm.func_78792_a(this.leftarm2);
/*  61 */     this.rightarm.func_78792_a(this.rightarm2);
/*  62 */     this.rightleg.func_78792_a(this.rightleg2);
/*  63 */     this.leftleg.func_78792_a(this.leftleg2);
/*  64 */     this.body.func_78792_a(this.head);
/*  65 */     this.body.func_78792_a(this.leftarm);
/*  66 */     this.body.func_78792_a(this.rightarm);
/*  67 */     this.body.func_78792_a(this.leftleg);
/*  68 */     this.body.func_78792_a(this.rightleg);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  73 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*  74 */     updateJump();
/*  75 */     GL11.glPushMatrix();
/*     */ 
/*     */     
/*  78 */     float legL = this.leftleg.field_78795_f; if (legL > 0.75F) legL = 0.75F; 
/*  79 */     float legL2 = this.leftleg2.field_78795_f;
/*  80 */     float legR = this.rightleg.field_78795_f; if (legR > 0.75F) legR = 0.75F; 
/*  81 */     float legR2 = this.rightleg.field_78795_f;
/*  82 */     float leg = (legL < legR) ? legL : legR;
/*  83 */     float leg2 = (legL < legR) ? legL2 : legR2;
/*  84 */     float F1 = leg * -0.25F + leg2 * ((leg2 > 1.0F) ? 0.01F : -0.08F);
/*  85 */     GL11.glTranslatef(0.0F, F1 - ((this.jumping && this.jumpPos != null) ? this.jumpPos.lastValue : 0.0F), 0.0F);
/*  86 */     this.body.func_78785_a(f5);
/*  87 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetAnimation() {
/*  93 */     setRotateAngle(this.head, 0.0F, 0.0F, 0.0F);
/*  94 */     setRotateAngle(this.body, 0.0F, 0.0F, 0.0F);
/*  95 */     setRotateAngle(this.leftarm, 0.0F, 0.0F, 0.0F);
/*  96 */     setRotateAngle(this.leftarm2, 0.0F, 0.0F, 0.0F);
/*  97 */     setRotateAngle(this.rightarm, 0.0F, 0.0F, 0.0F);
/*  98 */     setRotateAngle(this.rightarm2, 0.0F, 0.0F, 0.0F);
/*  99 */     setRotateAngle(this.leftleg, 0.0F, 0.0F, 0.0F);
/* 100 */     setRotateAngle(this.leftleg2, 0.0F, 0.0F, 0.0F);
/* 101 */     setRotateAngle(this.rightleg, 0.0F, 0.0F, 0.0F);
/* 102 */     setRotateAngle(this.rightleg2, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setupAnimation() {
/*     */     float FRAME0;
/*     */     float FRAME1;
/*     */     float FRAME2;
/*     */     float FRAME3;
/* 115 */     switch (this.animationID) {
/*     */       
/*     */       case 0:
/* 118 */         FRAME0 = 0.0F; FRAME1 = 0.8F;
/* 119 */         addAttribute(this.leftarm, new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -0.8F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -0.1F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 123 */         addAttribute(this.leftarm2, new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 128 */         addAttribute(this.rightarm, new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -0.8F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 0.1F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 132 */         addAttribute(this.rightarm2, new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 137 */         addAttribute(this.leftleg, new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -0.5F }, ), null);
/*     */ 
/*     */ 
/*     */         
/* 141 */         addAttribute(this.leftleg2, new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 146 */         addAttribute(this.rightleg, new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 0.8F }, ), null);
/*     */ 
/*     */ 
/*     */         
/* 150 */         addAttribute(this.rightleg2, new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 0.001F }, ), null);
/*     */         return;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 1:
/* 157 */         FRAME0 = 0.0F; FRAME1 = 0.05F; FRAME2 = 0.3F;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 162 */         addAttribute(this.body, null, new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 0.2F, FRAME2, 0.0F }, ), null);
/*     */ 
/*     */ 
/*     */         
/* 166 */         addAttribute(this.leftarm, new AttributeArray(new float[] { FRAME0, -0.8F, FRAME1, -1.6F, FRAME2, -0.8F }, ), new AttributeArray(new float[] { FRAME0, -0.1F, FRAME1, -0.2F, FRAME2, -0.1F }, ), new AttributeArray(new float[] { FRAME0, -0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 170 */         addAttribute(this.leftarm2, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, 0.0F, FRAME2, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 175 */         addAttribute(this.rightarm, new AttributeArray(new float[] { FRAME0, -0.8F, FRAME1, -0.3F, FRAME2, -0.8F }, ), new AttributeArray(new float[] { FRAME0, 0.1F, FRAME1, 0.2F, FRAME2, 0.1F }, ), new AttributeArray(new float[] { FRAME0, 0.1F, FRAME1, 0.2F, FRAME2, 0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 179 */         addAttribute(this.rightarm2, new AttributeArray(new float[] { FRAME0, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 184 */         addAttribute(this.leftleg, new AttributeArray(new float[] { FRAME0, -1.0F }, ), new AttributeArray(new float[] { FRAME0, -0.5F, FRAME1, -0.7F, FRAME2, -0.5F }, ), null);
/*     */ 
/*     */ 
/*     */         
/* 188 */         addAttribute(this.leftleg2, new AttributeArray(new float[] { FRAME0, 1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 193 */         addAttribute(this.rightleg, new AttributeArray(new float[] { FRAME0, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.8F, FRAME1, 0.6F, FRAME2, 0.8F }, ), null);
/*     */ 
/*     */ 
/*     */         
/* 197 */         addAttribute(this.rightleg2, new AttributeArray(new float[] { FRAME0, 1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */         return;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/* 204 */         FRAME0 = 0.0F; FRAME1 = 0.05F; FRAME2 = 0.3F;
/* 205 */         addAttribute(this.body, null, new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -0.2F, FRAME2, 0.0F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 210 */         addAttribute(this.leftarm, new AttributeArray(new float[] { FRAME0, -0.8F, FRAME1, -0.3F, FRAME2, -0.8F }, ), new AttributeArray(new float[] { FRAME0, -0.1F, FRAME1, -0.2F, FRAME2, -0.1F }, ), new AttributeArray(new float[] { FRAME0, -0.1F, FRAME1, -0.1F, FRAME2, -0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 214 */         addAttribute(this.leftarm2, new AttributeArray(new float[] { FRAME0, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */         
/* 218 */         addAttribute(this.rightarm, new AttributeArray(new float[] { FRAME0, -0.8F, FRAME1, -1.6F, FRAME2, -0.8F }, ), new AttributeArray(new float[] { FRAME0, 0.1F, FRAME1, 0.2F, FRAME2, 0.1F }, ), new AttributeArray(new float[] { FRAME0, 0.1F, FRAME1, 0.2F, FRAME2, 0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 222 */         addAttribute(this.rightarm2, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, 0.0F, FRAME2, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 227 */         addAttribute(this.leftleg, new AttributeArray(new float[] { FRAME0, -1.0F }, ), new AttributeArray(new float[] { FRAME0, -0.5F, FRAME1, -0.3F, FRAME2, -0.5F }, ), null);
/*     */ 
/*     */ 
/*     */         
/* 231 */         addAttribute(this.leftleg2, new AttributeArray(new float[] { FRAME0, 1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 236 */         addAttribute(this.rightleg, new AttributeArray(new float[] { FRAME0, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.8F, FRAME1, 1.0F, FRAME2, 0.8F }, ), null);
/*     */ 
/*     */ 
/*     */         
/* 240 */         addAttribute(this.rightleg2, new AttributeArray(new float[] { FRAME0, 1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */         return;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 3:
/* 247 */         FRAME0 = 0.0F; FRAME1 = 0.05F; FRAME2 = 0.25F; FRAME3 = 0.3F;
/* 248 */         addAttribute(this.body, null, new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 0.05F, FRAME2, 0.02F, FRAME3, 0.0F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -0.4F, FRAME2, -0.3F, FRAME3, 0.0F }));
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 253 */         addAttribute(this.leftarm, new AttributeArray(new float[] { FRAME0, -0.8F, FRAME1, -0.2F, FRAME2, -0.3F, FRAME3, -0.8F }, ), new AttributeArray(new float[] { FRAME0, -0.1F }, ), new AttributeArray(new float[] { FRAME0, -0.1F, FRAME1, -1.3F, FRAME2, -1.0F, FRAME3, -0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 257 */         addAttribute(this.leftarm2, new AttributeArray(new float[] { FRAME0, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 262 */         addAttribute(this.rightarm, new AttributeArray(new float[] { FRAME0, -0.8F, FRAME1, -0.2F, FRAME2, -0.3F, FRAME3, -0.8F }, ), new AttributeArray(new float[] { FRAME0, 0.1F }, ), new AttributeArray(new float[] { FRAME0, 0.1F, FRAME1, 0.5F, FRAME2, 0.4F, FRAME3, 0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 266 */         addAttribute(this.rightarm2, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, -1.5F, FRAME2, -1.4F, FRAME3, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 271 */         addAttribute(this.leftleg, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, -1.3F, FRAME2, -1.2F, FRAME3, -1.0F }, ), new AttributeArray(new float[] { FRAME0, -0.5F, FRAME1, -0.3F, FRAME2, -0.4F, FRAME3, -0.5F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -1.3F, FRAME2, -1.0F, FRAME3, 0.0F }));
/*     */ 
/*     */ 
/*     */         
/* 275 */         addAttribute(this.leftleg2, new AttributeArray(new float[] { FRAME0, 1.0F, FRAME1, 0.0F, FRAME2, 0.1F, FRAME3, 1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 280 */         addAttribute(this.rightleg, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, 0.2F, FRAME2, 0.3F, FRAME3, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.8F, FRAME1, 0.6F, FRAME2, 0.7F, FRAME3, 0.8F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 0.3F, FRAME2, 0.2F, FRAME3, 0.0F }));
/*     */ 
/*     */ 
/*     */         
/* 284 */         addAttribute(this.rightleg2, new AttributeArray(new float[] { FRAME0, 1.0F, FRAME1, 0.0F, FRAME2, 0.1F, FRAME3, 1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */         return;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 4:
/* 291 */         FRAME0 = 0.0F; FRAME1 = 0.05F; FRAME2 = 0.25F; FRAME3 = 0.3F;
/* 292 */         addAttribute(this.body, null, new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -0.5F, FRAME2, -0.48F, FRAME3, 0.0F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 0.4F, FRAME2, 0.3F, FRAME3, 0.0F }));
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 297 */         addAttribute(this.leftarm, new AttributeArray(new float[] { FRAME0, -0.8F, FRAME1, -0.2F, FRAME2, -0.3F, FRAME3, -0.8F }, ), new AttributeArray(new float[] { FRAME0, -0.1F }, ), new AttributeArray(new float[] { FRAME0, -0.1F, FRAME1, -0.5F, FRAME2, -0.4F, FRAME3, -0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 301 */         addAttribute(this.leftarm2, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, -1.5F, FRAME2, -1.4F, FRAME3, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 306 */         addAttribute(this.rightarm, new AttributeArray(new float[] { FRAME0, -0.8F, FRAME1, -0.2F, FRAME2, -0.3F, FRAME3, -0.8F }, ), new AttributeArray(new float[] { FRAME0, 0.1F }, ), new AttributeArray(new float[] { FRAME0, 0.1F, FRAME1, 1.3F, FRAME2, 1.0F, FRAME3, 0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 310 */         addAttribute(this.rightarm2, new AttributeArray(new float[] { FRAME0, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 315 */         addAttribute(this.leftleg, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, -0.2F, FRAME2, -0.3F, FRAME3, -1.0F }, ), new AttributeArray(new float[] { FRAME0, -0.5F, FRAME1, 0.6F, FRAME2, 0.7F, FRAME3, -0.5F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -0.8F, FRAME2, -0.7F, FRAME3, 0.0F }));
/*     */ 
/*     */ 
/*     */         
/* 319 */         addAttribute(this.leftleg2, new AttributeArray(new float[] { FRAME0, 1.0F, FRAME1, 0.0F, FRAME2, 0.1F, FRAME3, 1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 324 */         addAttribute(this.rightleg, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, -1.3F, FRAME2, -1.2F, FRAME3, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.8F, FRAME1, 0.3F, FRAME2, 0.4F, FRAME3, 0.8F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 1.3F, FRAME2, 1.0F, FRAME3, 0.0F }));
/*     */ 
/*     */ 
/*     */         
/* 328 */         addAttribute(this.rightleg2, new AttributeArray(new float[] { FRAME0, 1.0F, FRAME1, 0.0F, FRAME2, 0.1F, FRAME3, 1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */         return;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 5:
/* 335 */         FRAME0 = 0.0F; FRAME1 = 0.05F; FRAME2 = 0.3F;
/* 336 */         addAttribute(this.head, new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -0.1F, FRAME2, 0.0F }, ), null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 341 */         addAttribute(this.leftarm, new AttributeArray(new float[] { FRAME0, -0.8F, FRAME1, -0.6F, FRAME2, -0.8F }, ), new AttributeArray(new float[] { FRAME0, -0.1F }, ), new AttributeArray(new float[] { FRAME0, -0.1F, FRAME1, -0.3F, FRAME2, -0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 345 */         addAttribute(this.leftarm2, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, -0.5F, FRAME2, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 350 */         addAttribute(this.rightarm, new AttributeArray(new float[] { FRAME0, -0.8F, FRAME1, -0.6F, FRAME2, -0.8F }, ), new AttributeArray(new float[] { FRAME0, 0.1F }, ), new AttributeArray(new float[] { FRAME0, 0.1F, FRAME1, 0.3F, FRAME2, 0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 354 */         addAttribute(this.rightarm2, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, -0.5F, FRAME2, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 359 */         addAttribute(this.leftleg, new AttributeArray(new float[] { FRAME0, -1.0F }, ), new AttributeArray(new float[] { FRAME0, -0.5F }, ), null);
/*     */ 
/*     */ 
/*     */         
/* 363 */         addAttribute(this.leftleg2, new AttributeArray(new float[] { FRAME0, 1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 368 */         addAttribute(this.rightleg, new AttributeArray(new float[] { FRAME0, -1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.8F }, ), null);
/*     */ 
/*     */ 
/*     */         
/* 372 */         addAttribute(this.rightleg2, new AttributeArray(new float[] { FRAME0, 1.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */         return;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 6:
/* 379 */         FRAME0 = 0.0F; FRAME1 = 0.3F; FRAME2 = 0.5F; FRAME3 = 0.7F;
/* 380 */         addAttribute(this.body, null, new AttributeArray(new float[] { FRAME0, 0.0F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -0.06F, FRAME2, -0.06F, FRAME3, 0.0F }));
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 385 */         addAttribute(this.leftarm, new AttributeArray(new float[] { FRAME0, -0.8F, FRAME1, -2.7F, FRAME2, -2.7F, FRAME3, -0.1F }, ), new AttributeArray(new float[] { FRAME0, -0.1F }, ), new AttributeArray(new float[] { FRAME0, -0.1F, FRAME1, 0.2F, FRAME2, 0.2F, FRAME3, -0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 389 */         addAttribute(this.leftarm2, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, -0.1F, FRAME2, -0.1F, FRAME3, -0.9F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 394 */         addAttribute(this.rightarm, new AttributeArray(new float[] { FRAME0, -0.8F, FRAME1, -0.6F, FRAME2, -0.6F, FRAME3, -0.1F }, ), new AttributeArray(new float[] { FRAME0, 0.1F, FRAME1, 0.2F, FRAME2, 0.2F, FRAME3, 0.1F }, ), new AttributeArray(new float[] { FRAME0, 0.1F, FRAME1, 0.2F, FRAME2, 0.2F, FRAME3, 0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 398 */         addAttribute(this.rightarm2, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME2, -1.0F, FRAME3, -0.9F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 403 */         addAttribute(this.leftleg, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, 0.0F, FRAME2, 0.0F, FRAME3, 0.1F }, ), new AttributeArray(new float[] { FRAME0, 0.5F, FRAME1, 0.0F, FRAME2, 0.0F, FRAME3, 0.1F }, ), new AttributeArray(new float[] { FRAME0, 0.001F, FRAME1, 0.06F, FRAME2, 0.06F, FRAME3, -0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 407 */         addAttribute(this.leftleg2, new AttributeArray(new float[] { FRAME0, 1.0F, FRAME1, 0.0F, FRAME2, 0.0F, FRAME3, 0.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F, FRAME1, 0.0F, FRAME2, 0.0F, FRAME3, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 412 */         addAttribute(this.rightleg, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, -1.05F, FRAME2, -1.05F, FRAME3, 0.1F }, ), new AttributeArray(new float[] { FRAME0, 0.8F, FRAME1, 0.4F, FRAME2, 0.4F, FRAME3, 0.1F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME2, 0.0F, FRAME3, 0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 416 */         addAttribute(this.rightleg2, new AttributeArray(new float[] { FRAME0, 1.0F, FRAME1, 1.05F, FRAME2, 1.05F, FRAME3, 0.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 439 */         addJump(new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 1.0F, FRAME2, 0.9F, FRAME3, 0.0F }));
/*     */         return;
/*     */       
/*     */       case 7:
/* 443 */         FRAME0 = 0.0F; FRAME1 = 0.3F; FRAME2 = 0.5F; FRAME3 = 0.7F;
/* 444 */         addAttribute(this.head, new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 0.06F }, ), new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, -0.5F, FRAME1 * 2.0F, 0.0F, FRAME1 * 3.0F, 0.5F, FRAME1 * 4.0F, 0.0F }, ), null);
/*     */ 
/*     */ 
/*     */         
/* 448 */         addAttribute(this.body, new AttributeArray(new float[] { FRAME0, 0.0F, FRAME1, 0.06F }, ), null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 453 */         addAttribute(this.leftarm, new AttributeArray(new float[] { FRAME0, -0.8F, FRAME1, -0.15F }, ), new AttributeArray(new float[] { FRAME0, -0.1F }, ), new AttributeArray(new float[] { FRAME0, -0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 457 */         addAttribute(this.leftarm2, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, -0.05F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 462 */         addAttribute(this.rightarm, new AttributeArray(new float[] { FRAME0, -0.8F, FRAME1, -0.15F }, ), new AttributeArray(new float[] { FRAME0, 0.1F }, ), new AttributeArray(new float[] { FRAME0, 0.1F }));
/*     */ 
/*     */ 
/*     */         
/* 466 */         addAttribute(this.rightarm2, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, -0.05F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 471 */         addAttribute(this.leftleg, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, -0.3F }, ), new AttributeArray(new float[] { FRAME0, 0.5F, FRAME1, 0.0F }, ), new AttributeArray(new float[] { FRAME0, 0.001F, FRAME1, -0.06F }));
/*     */ 
/*     */ 
/*     */         
/* 475 */         addAttribute(this.leftleg2, new AttributeArray(new float[] { FRAME0, 1.0F, FRAME1, 0.3F }, ), new AttributeArray(new float[] { FRAME0, 0.001F, FRAME1, 0.0F }, ), null);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 480 */         addAttribute(this.rightleg, new AttributeArray(new float[] { FRAME0, -1.0F, FRAME1, -0.3F }, ), new AttributeArray(new float[] { FRAME0, 0.8F, FRAME1, 0.4F }, ), null);
/*     */ 
/*     */ 
/*     */         
/* 484 */         addAttribute(this.rightleg2, new AttributeArray(new float[] { FRAME0, 1.0F, FRAME1, 0.25F }, ), new AttributeArray(new float[] { FRAME0, 0.001F }, ), null);
/*     */         return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\ModelNPCTraining.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */