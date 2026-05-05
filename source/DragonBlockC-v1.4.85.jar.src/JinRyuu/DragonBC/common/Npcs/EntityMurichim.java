/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityMurichim
/*    */   extends EntityDBCBasicEvil {
/*  8 */   public final int AttPow = 7000;
/*  9 */   public final int HePo = 40000;
/*    */   
/*    */   public EntityMurichim(World world) {
/* 12 */     super(world);
/* 13 */     this.tex = "murichim";
/* 14 */     func_70105_a(0.6F, 2.5F);
/* 15 */     setHardDifficulty();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 20 */     super.func_110147_ax();
/* 21 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(40000.0D);
/* 22 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(7000.0D);
/*    */   }
/*    */   
/*    */   public long BattlePowerOld() {
/* 26 */     int BP = 165425152;
/* 27 */     int exp = this.field_70728_aV * 100;
/* 28 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/* 29 */     return BattlePower;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityMurichim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */