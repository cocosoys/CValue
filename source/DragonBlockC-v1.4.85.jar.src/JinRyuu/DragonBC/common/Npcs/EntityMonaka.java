/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class EntityMonaka
/*    */   extends EntityDBCEvil
/*    */ {
/* 14 */   public int randomSoundDelay = 0;
/*    */   public String tex;
/* 16 */   public final int AttPow = 2;
/* 17 */   public final int HePo = 10;
/*    */   private int wait;
/*    */   private int m; private int target; protected void func_110147_ax() { super.func_110147_ax();
/*    */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D);
/* 21 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(2.0D); } public EntityMonaka(World par1World) { super(par1World);
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
/* 46 */     this.wait = 0;
/* 47 */     this.m = 1;
/*    */     this.field_70728_aV = 200;
/*    */     this.tex = "monaka";
/*    */     func_70105_a(1.0F, 1.5F);
/* 51 */     setHardDifficulty(); } public void func_70636_d() { super.func_70636_d(); }
/*    */    @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/*    */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*    */   } public void func_70645_a(DamageSource par1DamageSource) {
/* 56 */     Entity var3 = par1DamageSource.func_76346_g();
/* 57 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/*    */       
/* 73 */       becomeAngryAt(var3);
/*    */     }
/*    */     
/* 76 */     super.func_70645_a(par1DamageSource);
/*    */   } public long BattlePowerOld() {
/*    */     int BP = 4000;
/*    */     int exp = this.field_70728_aV * 100;
/*    */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*    */     return BattlePower;
/*    */   }
/*    */   private void becomeAngryAt(Entity par1Entity) {
/* 84 */     this.field_70789_a = par1Entity;
/* 85 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 86 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityMonaka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */