/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityDBCWildlifeP
/*    */   extends EntityDBCWildlife
/*    */ {
/*    */   public EntityDBCWildlifeP(World par1World) {
/* 16 */     super(par1World);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70645_a(DamageSource par1DamageSource) {
/* 21 */     Entity var3 = par1DamageSource.func_76346_g();
/*    */     
/* 23 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer) {
/*    */       
/* 25 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*    */       
/* 27 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*    */         
/* 29 */         Entity var6 = var4.get(var5);
/*    */         
/* 31 */         if (var6 instanceof EntityDBCWildlifeP) {
/*    */           
/* 33 */           EntityDBCWildlifeP var7 = (EntityDBCWildlifeP)var6;
/* 34 */           var7.becomeAngryAt(var3);
/*    */         } 
/*    */       } 
/*    */       
/* 38 */       becomeAngryAt(var3);
/*    */     } 
/*    */     
/* 41 */     super.func_70645_a(par1DamageSource);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Entity func_70782_k() {
/* 51 */     return (this.angerLevel == 0) ? null : super.func_70782_k();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 59 */     if (func_85032_ar())
/*    */     {
/* 61 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 65 */     Entity var3 = par1DamageSource.func_76346_g();
/*    */     
/* 67 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer) {
/*    */       
/* 69 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*    */       
/* 71 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*    */         
/* 73 */         Entity var6 = var4.get(var5);
/*    */         
/* 75 */         if (var6 instanceof EntityDBCWildlifeP) {
/*    */           
/* 77 */           EntityDBCWildlifeP var7 = (EntityDBCWildlifeP)var6;
/* 78 */           var7.becomeAngryAt(var3);
/*    */         } 
/*    */       } 
/*    */       
/* 82 */       becomeAngryAt(var3);
/*    */     } 
/*    */     
/* 85 */     return super.func_70097_a(par1DamageSource, par2);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityDBCWildlifeP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */