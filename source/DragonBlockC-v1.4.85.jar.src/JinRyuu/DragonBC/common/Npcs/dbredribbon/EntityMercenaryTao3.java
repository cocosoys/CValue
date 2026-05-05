/*    */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityMercenaryTao3
/*    */   extends EntityDBCEvil {
/*    */   public String tex;
/* 14 */   public final int AttPow = 280;
/* 15 */   public final int HePo = 750;
/*    */ 
/*    */   
/*    */   public EntityMercenaryTao3(World par1World) {
/* 19 */     super(par1World);
/* 20 */     this.field_70728_aV = 10;
/* 21 */     this.tex = "mercenary_tao_cyborg_b";
/* 22 */     func_70105_a(0.6F, 2.0F);
/* 23 */     setData1(3);
/* 24 */     setData2(7);
/* 25 */     this.canFly = false;
/* 26 */     this.kiAttackTimer = 240;
/* 27 */     setEasyDifficulty();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 33 */     super.func_110147_ax();
/* 34 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(750.0D);
/* 35 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(280.0D);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 39 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*    */   }
/*    */   public long BattlePowerOld() {
/* 42 */     int BP = 42000000;
/* 43 */     int exp = this.field_70728_aV * 100;
/* 44 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/* 45 */     return BattlePower;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70636_d() {
/* 50 */     becomeAngryAtAllPlayer();
/* 51 */     super.func_70636_d();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70645_a(DamageSource par1DamageSource) {
/* 56 */     Entity var3 = par1DamageSource.func_76346_g();
/* 57 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
/*    */     {
/* 59 */       becomeAngryAt(var3);
/*    */     }
/*    */     
/* 62 */     super.func_70645_a(par1DamageSource);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void becomeAngryAt(Entity par1Entity) {
/* 70 */     this.field_70789_a = par1Entity;
/* 71 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\EntityMercenaryTao3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */