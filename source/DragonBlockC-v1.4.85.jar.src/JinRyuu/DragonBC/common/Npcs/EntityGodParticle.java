/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import net.minecraft.client.particle.EntityAuraFX;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityGodParticle
/*    */   extends EntityAuraFX
/*    */ {
/*    */   public EntityGodParticle(World parWorld, double parX, double parY, double parZ, double parMotionX, double parMotionY, double parMotionZ) {
/* 13 */     super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
/* 14 */     func_70536_a(0);
/* 15 */     this.field_70544_f = (float)(Math.random() * 1.0D) + 0.4F;
/* 16 */     func_70538_b(255.0F, 255.0F, 255.0F);
/* 17 */     this.field_70547_e = (int)(10.0D / (Math.random() * 0.8D + 0.2D));
/* 18 */     this.field_70159_w *= 1.0D;
/* 19 */     this.field_70181_x *= 8.0D;
/* 20 */     this.field_70179_y *= 1.0D;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityGodParticle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */