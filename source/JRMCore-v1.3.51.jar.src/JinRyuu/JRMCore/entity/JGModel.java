/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreGuiScreen;
/*     */ import JinRyuu.JRMCore.client.minigame.MiniGameAirBoxing;
/*     */ import JinRyuu.JRMCore.manager.AttributeArray;
/*     */ import JinRyuu.JRMCore.manager.AttributeModel;
/*     */ import java.time.Duration;
/*     */ import java.time.Instant;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JGModel
/*     */   extends ModelBase
/*     */ {
/*  20 */   private final float SPEED_MULTIPLIER = 1.0F;
/*     */   private ArrayList<AttributeModel> AttributeModels;
/*     */   public int animationID;
/*     */   private Instant lastUpdate;
/*     */   private float age;
/*     */   private boolean animationEnded;
/*     */   private float jumpAge;
/*     */   private Instant jumpUpdate;
/*     */   public AttributeArray jumpPos;
/*     */   public boolean jumping;
/*     */   
/*     */   public JGModel(int textureWidth, int textureHeight) {
/*  32 */     this.AttributeModels = new ArrayList<AttributeModel>();
/*  33 */     this.animationID = 0;
/*  34 */     this.age = 0.0F;
/*  35 */     this.animationEnded = false;
/*  36 */     this.field_78090_t = textureWidth;
/*  37 */     this.field_78089_u = textureHeight;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  42 */     updateAnimation((EntityNull)entity, f, f1, f2, f3, f4, f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateAnimation(EntityNull entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  49 */     if (this.lastUpdate == null) {
/*  50 */       this.lastUpdate = Instant.now();
/*     */     } else {
/*     */       
/*  53 */       if (getMiniGameAirBoxing() != null) {
/*     */         
/*  55 */         if (!this.animationEnded) (getMiniGameAirBoxing()).gameModelAge += (float)Duration.between(this.lastUpdate, Instant.now()).toMillis() / 1000.0F * 1.0F; 
/*  56 */         this.age = (getMiniGameAirBoxing()).gameModelAge;
/*  57 */         this.animationID = (getMiniGameAirBoxing()).gameModelAnimationID;
/*  58 */         if ((getMiniGameAirBoxing()).gameModelAnimationChanged) {
/*     */           
/*  60 */           this.jumpAge = 0.0F;
/*  61 */           this.jumpPos = null;
/*  62 */           this.jumping = false;
/*  63 */           playAnimation(this.animationID);
/*  64 */           (getMiniGameAirBoxing()).gameModelAnimationChanged = false;
/*  65 */           this.animationEnded = false;
/*     */         } 
/*     */       } 
/*  68 */       this.lastUpdate = Instant.now();
/*     */     } 
/*  70 */     updateAttributes(this.age);
/*     */   }
/*     */   
/*     */   public void addJump(AttributeArray array) {
/*  74 */     this.jumpAge = 0.0F;
/*  75 */     this.jumpPos = array;
/*  76 */     this.jumping = true;
/*  77 */     this.jumpUpdate = Instant.now();
/*     */   }
/*     */   
/*     */   public void updateJump() {
/*  81 */     if (this.jumping) {
/*     */       
/*  83 */       if (this.jumpUpdate != null) this.jumpAge += (float)Duration.between(this.jumpUpdate, Instant.now()).toMillis() / 1000.0F * 1.0F; 
/*  84 */       this.jumpUpdate = Instant.now();
/*  85 */       this.jumpPos.update(this.jumpAge);
/*  86 */       if (this.jumpPos.hasEnded) this.jumping = false; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isAnimationID(int animationID) {
/*  91 */     return (this.animationID == animationID);
/*     */   }
/*     */   
/*     */   private void playAnimation(int animationID) {
/*  95 */     this.age = 0.0F;
/*  96 */     this.animationID = animationID;
/*     */     
/*  98 */     this.AttributeModels.clear();
/*  99 */     resetAnimation();
/* 100 */     setupAnimation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetAnimation() {
/* 108 */     for (AttributeModel attributeModel : this.AttributeModels) {
/* 109 */       if (attributeModel.value == AttributeModel.X) { attributeModel.model.field_78795_f = 0.0F; continue; }
/* 110 */        if (attributeModel.value == AttributeModel.Y) { attributeModel.model.field_78796_g = 0.0F; continue; }
/* 111 */        if (attributeModel.value == AttributeModel.Z) attributeModel.model.field_78808_h = 0.0F;
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupAnimation() {}
/*     */ 
/*     */   
/*     */   public MiniGameAirBoxing getMiniGameAirBoxing() {
/* 121 */     if (JRMCoreGuiScreen.instance != null) return JRMCoreGuiScreen.instance.miniGameAirBoxing; 
/* 122 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateAttributes(float age) {
/* 129 */     this.animationEnded = true;
/* 130 */     for (AttributeModel array : this.AttributeModels) {
/* 131 */       array.update(age);
/* 132 */       if (array.value == AttributeModel.X) { array.model.field_78795_f = array.attributeArray.lastValue; }
/* 133 */       else if (array.value == AttributeModel.Y) { array.model.field_78796_g = array.attributeArray.lastValue; }
/* 134 */       else if (array.value == AttributeModel.Z) { array.model.field_78808_h = array.attributeArray.lastValue; }
/* 135 */        if (!array.hasEnded) this.animationEnded = false;
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addAttribute(ModelRenderer model, AttributeArray x, AttributeArray y, AttributeArray z) {
/* 141 */     if (x != null) addAttribute(new AttributeModel(model, AttributeModel.X, x)); 
/* 142 */     if (y != null) addAttribute(new AttributeModel(model, AttributeModel.Y, y)); 
/* 143 */     if (z != null) addAttribute(new AttributeModel(model, AttributeModel.Z, z)); 
/*     */   }
/*     */   
/*     */   public void addAttribute(AttributeModel attributes) {
/* 147 */     this.AttributeModels.add(attributes);
/*     */   }
/*     */   
/*     */   public ArrayList<AttributeModel> getAttributes() {
/* 151 */     return this.AttributeModels;
/*     */   }
/*     */   
/*     */   public AttributeModel getAttribute(int id) {
/* 155 */     return this.AttributeModels.get(id);
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer model, float x, float y, float z) {
/* 159 */     model.field_78795_f = x;
/* 160 */     model.field_78796_g = y;
/* 161 */     model.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\JGModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */