/*    */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*    */ 
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityCommanderRed extends EntityRedRibbon {
/*  7 */   public final int AttPow = 5;
/*  8 */   public final int HePo = 20;
/*    */ 
/*    */   
/*    */   public EntityCommanderRed(World world) {
/* 12 */     super(world);
/* 13 */     this.texture = "commander_red";
/* 14 */     func_70105_a(0.6F, 1.7F);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 19 */     super.func_110147_ax();
/* 20 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0D);
/* 21 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0D);
/*    */   }
/*    */   
/*    */   public long BattlePowerOld() {
/* 25 */     int BP = 20000;
/* 26 */     int exp = this.field_70728_aV * 100;
/* 27 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/* 28 */     return BattlePower;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\EntityCommanderRed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */