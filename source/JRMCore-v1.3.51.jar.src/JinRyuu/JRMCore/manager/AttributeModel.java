/*    */ package JinRyuu.JRMCore.manager;
/*    */ 
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ 
/*    */ public class AttributeModel {
/*  6 */   public static byte X = 0; public static byte Y = 1; public static byte Z = 2;
/*    */   public ModelRenderer model;
/*    */   public AttributeArray attributeArray;
/*    */   public boolean hasEnded;
/*    */   public byte value;
/*    */   
/*    */   public AttributeModel(ModelRenderer model, byte value, AttributeArray attributeArray) {
/* 13 */     this.model = model;
/* 14 */     this.value = value;
/* 15 */     this.attributeArray = attributeArray;
/* 16 */     this.hasEnded = false;
/*    */   }
/*    */   
/*    */   public void update(float age) {
/* 20 */     if (!this.hasEnded) {
/* 21 */       this.attributeArray.update(age);
/* 22 */       if (this.attributeArray.hasEnded) this.hasEnded = true; 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\manager\AttributeModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */