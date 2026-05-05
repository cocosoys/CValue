/*    */ package JinRyuu.JRMCore.entity.aai;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ public class AAiSystem
/*    */ {
/*    */   public Entity entity;
/*    */   public ArrayList<AAi> aais;
/*    */   
/*    */   public AAiSystem(Entity entity, AAi... aais) {
/* 14 */     this.entity = entity;
/* 15 */     this.aais = new ArrayList<AAi>();
/* 16 */     addAAis(aais);
/*    */   }
/*    */   
/*    */   public void addAAis(AAi... aais) {
/* 20 */     this.aais.addAll(Arrays.asList(aais));
/* 21 */     for (AAi aai : aais)
/* 22 */       aai.aaiSystem = this; 
/*    */   }
/*    */   
/*    */   public void addAAi(AAi aai) {
/* 26 */     this.aais.add(aai);
/* 27 */     aai.aaiSystem = this;
/*    */   }
/*    */   
/*    */   public void update() {
/* 31 */     for (AAi aai : this.aais)
/* 32 */       aai.update(); 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\aai\AAiSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */