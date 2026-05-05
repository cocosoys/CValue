/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityCyborgsInf
/*    */   extends EntityCyborgs
/*    */ {
/* 12 */   public int randomSoundDelay = 0;
/*    */ 
/*    */   
/*    */   public EntityCyborgsInf(World par1World) {
/* 16 */     super(par1World);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void becomeAngryAt(Entity par1Entity) {
/* 57 */     this.field_70789_a = par1Entity;
/* 58 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 59 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityCyborgsInf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */