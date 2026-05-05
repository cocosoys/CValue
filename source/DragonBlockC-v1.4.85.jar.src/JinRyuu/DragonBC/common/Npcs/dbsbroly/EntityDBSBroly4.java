/*    */ package JinRyuu.DragonBC.common.Npcs.dbsbroly;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityDBSBroly4
/*    */   extends EntityDBCEvil {
/*    */   public String tex;
/* 14 */   public final int AttPow = 20000;
/* 15 */   public final int HePo = 140000;
/*    */ 
/*    */   
/*    */   public EntityDBSBroly4(World par1World) {
/* 19 */     super(par1World);
/* 20 */     this.field_70728_aV = 200;
/* 21 */     this.tex = "dbsbroly4";
/* 22 */     func_70105_a(0.6F, 2.0F);
/* 23 */     setData1(1);
/* 24 */     setData2(6);
/* 25 */     setHardDifficulty();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 31 */     super.func_110147_ax();
/* 32 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(140000.0D);
/* 33 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(20000.0D);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 37 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*    */   }
/*    */   public long BattlePowerOld() {
/* 40 */     int BP = 1654251520;
/* 41 */     int exp = this.field_70728_aV * 100;
/* 42 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/* 43 */     return BattlePower;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70636_d() {
/* 48 */     if (doBlst()) {
/* 49 */       int r = (int)(Math.random() * 2.0D);
/* 50 */       if (r == 0) {
/* 51 */         setData1(1);
/* 52 */         setData2(6);
/*    */       } else {
/*    */         
/* 55 */         setData1(6);
/* 56 */         setData2(6);
/*    */       } 
/*    */     } 
/*    */     
/* 60 */     becomeAngryAtAllPlayer();
/* 61 */     super.func_70636_d();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70645_a(DamageSource par1DamageSource) {
/* 66 */     Entity var3 = par1DamageSource.func_76346_g();
/* 67 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
/*    */     {
/* 69 */       becomeAngryAt(var3);
/*    */     }
/*    */     
/* 72 */     super.func_70645_a(par1DamageSource);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void becomeAngryAt(Entity par1Entity) {
/* 80 */     this.field_70789_a = par1Entity;
/* 81 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbsbroly\EntityDBSBroly4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */