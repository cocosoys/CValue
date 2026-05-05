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
/*    */ public class EntityTien5
/*    */   extends EntityDBCEvil {
/*    */   public String tex;
/* 14 */   public final int AttPow = 350;
/* 15 */   public final int HePo = 1200;
/*    */ 
/*    */   
/*    */   public EntityTien5(World par1World) {
/* 19 */     super(par1World);
/* 20 */     this.field_70728_aV = 10;
/* 21 */     this.tex = "tien_shinhan_buusaga_a";
/* 22 */     func_70105_a(0.6F, 2.0F);
/* 23 */     setData1(3);
/* 24 */     setData2(7);
/* 25 */     this.kiAttackTimer = 240;
/* 26 */     setEasyDifficulty();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 32 */     super.func_110147_ax();
/* 33 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1200.0D);
/* 34 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(350.0D);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 38 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*    */   }
/*    */   public long BattlePowerOld() {
/* 41 */     int BP = 84000000;
/* 42 */     int exp = this.field_70728_aV * 100;
/* 43 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/* 44 */     return BattlePower;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70636_d() {
/* 49 */     if (doBlst()) {
/* 50 */       int r = (int)(Math.random() * 2.0D);
/* 51 */       if (r == 0) {
/* 52 */         setData1(5);
/* 53 */         setData2(7);
/*    */       } else {
/*    */         
/* 56 */         setData1(3);
/* 57 */         setData2(7);
/*    */       } 
/*    */     } 
/*    */     
/* 61 */     becomeAngryAtAllPlayer();
/* 62 */     super.func_70636_d();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70645_a(DamageSource par1DamageSource) {
/* 67 */     Entity var3 = par1DamageSource.func_76346_g();
/* 68 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
/*    */     {
/* 70 */       becomeAngryAt(var3);
/*    */     }
/*    */     
/* 73 */     super.func_70645_a(par1DamageSource);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void becomeAngryAt(Entity par1Entity) {
/* 81 */     this.field_70789_a = par1Entity;
/* 82 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbtournament\EntityTien5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */