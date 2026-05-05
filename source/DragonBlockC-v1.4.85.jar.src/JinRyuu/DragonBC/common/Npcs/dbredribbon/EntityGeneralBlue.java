/*    */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*    */ 
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityGeneralBlue extends EntityRedRibbon {
/*  7 */   public final int AttPow = 110;
/*  8 */   public final int HePo = 350;
/*    */ 
/*    */   
/*    */   public EntityGeneralBlue(World world) {
/* 12 */     super(world);
/* 13 */     this.texture = "general_blue";
/* 14 */     func_70105_a(0.6F, 2.0F);
/* 15 */     setEasyDifficulty();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 20 */     super.func_110147_ax();
/* 21 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(350.0D);
/* 22 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(110.0D);
/*    */   }
/*    */   
/*    */   public long BattlePowerOld() {
/* 26 */     int BP = 7700000;
/* 27 */     int exp = this.field_70728_aV * 100;
/* 28 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/* 29 */     return BattlePower;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\EntityGeneralBlue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */