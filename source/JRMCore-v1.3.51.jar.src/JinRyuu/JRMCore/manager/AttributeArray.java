/*    */ package JinRyuu.JRMCore.manager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AttributeArray
/*    */ {
/* 12 */   public int currentID = 0;
/*    */   
/*    */   public Attribute[] attributes;
/*    */   public float lastValue;
/*    */   
/*    */   public AttributeArray(float... attributes) {
/* 18 */     this();
/* 19 */     this.attributes = new Attribute[attributes.length / 2];
/* 20 */     for (int i = 0; i < attributes.length; i += 2)
/*    */     {
/* 22 */       this.attributes[i / 2] = new Attribute(attributes[i], attributes[i + 1]); } 
/*    */   }
/*    */   public boolean hasEnded = false;
/*    */   public AttributeArray() {}
/*    */   
/*    */   public AttributeArray(Attribute... attributes) {
/* 28 */     this();
/* 29 */     this.attributes = new Attribute[attributes.length];
/* 30 */     System.arraycopy(attributes, 0, this.attributes, 0, attributes.length);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void update(float age) {
/* 36 */     if (!this.hasEnded) {
/*    */       
/* 38 */       if (age >= (this.attributes[this.currentID + ((this.currentID + 1 == this.attributes.length) ? 0 : 1)]).time) {
/*    */         
/* 40 */         if (this.currentID + 1 == this.attributes.length) {
/*    */           
/* 42 */           this.hasEnded = true;
/* 43 */           if (age > (this.attributes[this.currentID]).time) age = (this.attributes[this.currentID]).time; 
/*    */         } 
/* 45 */         if (this.currentID + 1 != this.attributes.length) this.currentID++; 
/*    */       } 
/* 47 */       updateValue(age);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateValue(float age) {
/*    */     float currentValue;
/* 54 */     if (this.currentID + 1 == this.attributes.length) {
/*    */       
/* 56 */       currentValue = (this.attributes[this.currentID]).value;
/*    */     }
/*    */     else {
/*    */       
/* 60 */       float minValue = (this.attributes[this.currentID]).value;
/* 61 */       float maxValue = (this.attributes[this.currentID + 1]).value;
/* 62 */       float differenceValue = maxValue - minValue;
/*    */       
/* 64 */       float minTime = (this.attributes[this.currentID]).time;
/* 65 */       float maxTime = (this.attributes[this.currentID + 1]).time;
/* 66 */       float differenceTime = maxTime - minTime;
/*    */       
/* 68 */       float onePerTime = differenceValue / differenceTime;
/*    */       
/* 70 */       currentValue = (age - minTime) * onePerTime + (this.attributes[this.currentID]).value;
/*    */       
/* 72 */       if (maxValue > currentValue)
/*    */       
/* 74 */       { if (currentValue > maxValue) currentValue = maxValue;
/*    */         
/*    */          }
/*    */       
/* 78 */       else if (currentValue < maxValue) { currentValue = maxValue; }
/*    */     
/*    */     } 
/* 81 */     this.lastValue = currentValue;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\manager\AttributeArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */