/*    */ package JinRyuu.DragonBC.common.Npcs.dbz;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityOfficeOgre5
/*    */   extends EntityDBCEvil {
/*    */   public String tex;
/* 14 */   public final int AttPow = 5;
/* 15 */   public final int HePo = 20;
/*    */ 
/*    */   
/*    */   public EntityOfficeOgre5(World par1World) {
/* 19 */     super(par1World);
/* 20 */     this.field_70728_aV = 10;
/* 21 */     this.tex = "office_ogre_e";
/* 22 */     func_70105_a(0.6F, 2.0F);
/* 23 */     this.canFireKiAttacks = false;
/* 24 */     this.canFly = false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 30 */     super.func_110147_ax();
/* 31 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0D);
/* 32 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0D);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 36 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*    */   }
/*    */   public long BattlePowerOld() {
/* 39 */     int BP = 20000;
/* 40 */     int exp = this.field_70728_aV * 100;
/* 41 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/* 42 */     return BattlePower;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70636_d() {
/* 47 */     becomeAngryAtAllPlayer();
/* 48 */     super.func_70636_d();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70645_a(DamageSource par1DamageSource) {
/* 53 */     Entity var3 = par1DamageSource.func_76346_g();
/* 54 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
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


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbz\EntityOfficeOgre5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */