/*    */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.DBCConfig;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityMajorMetallitron2
/*    */   extends EntityMajorMetallitron1 {
/*  9 */   public final int AttPow = 50;
/* 10 */   public final int HePo = 200;
/*    */   
/*    */   public EntityMajorMetallitron2(World world) {
/* 13 */     super(world);
/* 14 */     func_70105_a(1.2F, 5.0F);
/* 15 */     this.texture = "major_metallitron2";
/* 16 */     setAttributes(DBCConfig.RRMajorDAM, DBCConfig.RRMajorHP, 50, 200);
/*    */   }
/*    */   
/*    */   protected void func_110147_ax() {
/* 20 */     super.func_110147_ax();
/* 21 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0D);
/* 22 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(50.0D);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\EntityMajorMetallitron2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */