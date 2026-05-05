/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class EntityFreezaSoldiers
/*    */   extends EntityDBCEvil
/*    */ {
/* 12 */   public int randomSoundDelay = 0;
/*    */ 
/*    */   
/*    */   public EntityFreezaSoldiers(World par1World) {
/* 16 */     super(par1World);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 21 */     if (func_85032_ar())
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 27 */     Entity var3 = par1DamageSource.func_76346_g();
/*    */     
/* 29 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer) {
/*    */       
/* 31 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*    */       
/* 33 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*    */         
/* 35 */         Entity var6 = var4.get(var5);
/*    */         
/* 37 */         if (var6 instanceof EntityFreezaSoldiers) {
/*    */           
/* 39 */           EntityFreezaSoldiers var7 = (EntityFreezaSoldiers)var6;
/* 40 */           var7.becomeAngryAt(var3);
/*    */         } 
/*    */       } 
/*    */       
/* 44 */       becomeAngryAt(var3);
/*    */     } 
/*    */     
/* 47 */     return super.func_70097_a(par1DamageSource, par2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void becomeAngryAt(Entity par1Entity) {
/* 56 */     this.field_70789_a = par1Entity;
/* 57 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 58 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityFreezaSoldiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */