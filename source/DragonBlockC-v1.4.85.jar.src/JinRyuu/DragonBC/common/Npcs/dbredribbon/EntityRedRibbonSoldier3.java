/*    */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*    */ import JinRyuu.DragonBC.common.DBCConfig;
/*    */ import JinRyuu.JRMCore.entity.EntityPrjtls_1;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityRedRibbonSoldier3 extends EntityRedRibbon2 {
/*  9 */   public final int AttPow = 40;
/* 10 */   public final int HePo = 80;
/*    */   
/*    */   public EntityRedRibbonSoldier3(World world) {
/* 13 */     super(world);
/* 14 */     func_70105_a(0.6F, 2.0F);
/* 15 */     this.texture = "redribbon_soldier3";
/* 16 */     setAttributes(DBCConfig.RRSoldier3DAM, DBCConfig.RRSoldier3HP, 40, 80);
/*    */   }
/*    */   
/*    */   protected void func_110147_ax() {
/* 20 */     super.func_110147_ax();
/* 21 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(80.0D);
/* 22 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(40.0D);
/*    */   }
/*    */   
/*    */   public void func_70071_h_() {
/* 26 */     super.func_70071_h_();
/*    */     
/* 28 */     if (!this.field_70170_p.field_72995_K && !this.field_70128_L && this.field_70789_a != null && this.field_70789_a.func_70089_S() && this.field_70789_a.func_70032_d((Entity)this) < 25.0F)
/*    */     {
/* 30 */       if (this.field_70173_aa % 150 == 0) {
/*    */         
/* 32 */         EntityPrjtls_1 var8 = new EntityPrjtls_1(this.field_70170_p, (Entity)this, this.field_70789_a, 1.8F, 1.0F, 5);
/* 33 */         this.field_70170_p.func_72956_a((Entity)this, "jinryuudragonbc:DBC4.rocket_shot", 0.6F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/* 34 */         this.field_70170_p.func_72838_d((Entity)var8);
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\EntityRedRibbonSoldier3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */