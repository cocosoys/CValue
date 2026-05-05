/*    */ package JinRyuu.DragonBC.common.Npcs.dbtournament;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityChiaotzu4
/*    */   extends EntityDBCEvil
/*    */ {
/*    */   public String tex;
/* 17 */   public final int AttPow = 50;
/* 18 */   public final int HePo = 150;
/*    */ 
/*    */   
/*    */   public EntityChiaotzu4(World par1World) {
/* 22 */     super(par1World);
/* 23 */     this.field_70728_aV = 10;
/* 24 */     this.tex = "chiaotzu_super";
/* 25 */     func_70105_a(0.6F, 1.6F);
/* 26 */     setData1(3);
/* 27 */     setData2(7);
/* 28 */     this.canFly = true;
/* 29 */     this.kiAttackTimer = 240;
/* 30 */     setEasyDifficulty();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 36 */     super.func_110147_ax();
/* 37 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(150.0D);
/* 38 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(50.0D);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 42 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*    */   }
/*    */   public long BattlePowerOld() {
/* 45 */     int BP = 1500000;
/* 46 */     int exp = this.field_70728_aV * 100;
/* 47 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/* 48 */     return BattlePower;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70636_d() {
/* 53 */     becomeAngryAtAllPlayer();
/* 54 */     super.func_70636_d();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70645_a(DamageSource par1DamageSource) {
/* 59 */     Entity var3 = par1DamageSource.func_76346_g();
/* 60 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
/*    */     {
/* 62 */       becomeAngryAt(var3);
/*    */     }
/*    */     
/* 65 */     super.func_70645_a(par1DamageSource);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void becomeAngryAt(Entity par1Entity) {
/* 73 */     this.field_70789_a = par1Entity;
/* 74 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbtournament\EntityChiaotzu4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */