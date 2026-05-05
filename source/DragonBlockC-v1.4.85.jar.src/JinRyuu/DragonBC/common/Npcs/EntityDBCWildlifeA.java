/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityDBCWildlifeA
/*    */   extends EntityDBCWildlife
/*    */ {
/*    */   public EntityDBCWildlifeA(World par1World) {
/* 14 */     super(par1World);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70645_a(DamageSource par1DamageSource) {
/* 19 */     Entity var3 = par1DamageSource.func_76346_g();
/*    */     
/* 21 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer) {
/*    */       
/* 23 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*    */       
/* 25 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*    */         
/* 27 */         Entity var6 = var4.get(var5);
/*    */         
/* 29 */         if (var6 instanceof EntityDBCWildlifeA) {
/*    */           
/* 31 */           EntityDBCWildlifeA var7 = (EntityDBCWildlifeA)var6;
/* 32 */           var7.becomeAngryAt(var3);
/*    */         } 
/*    */       } 
/*    */       
/* 36 */       becomeAngryAt(var3);
/*    */     } 
/*    */     
/* 39 */     super.func_70645_a(par1DamageSource);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Entity func_70782_k() {
/* 49 */     return super.func_70782_k();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 57 */     if (func_85032_ar())
/*    */     {
/* 59 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 63 */     Entity var3 = par1DamageSource.func_76346_g();
/*    */     
/* 65 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer) {
/*    */       
/* 67 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*    */       
/* 69 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*    */         
/* 71 */         Entity var6 = var4.get(var5);
/*    */         
/* 73 */         if (var6 instanceof EntityDBCWildlifeA) {
/*    */           
/* 75 */           EntityDBCWildlifeA var7 = (EntityDBCWildlifeA)var6;
/* 76 */           var7.becomeAngryAt(var3);
/*    */         } 
/*    */       } 
/*    */       
/* 80 */       becomeAngryAt(var3);
/*    */     } 
/*    */     
/* 83 */     return super.func_70097_a(par1DamageSource, par2);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityDBCWildlifeA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */