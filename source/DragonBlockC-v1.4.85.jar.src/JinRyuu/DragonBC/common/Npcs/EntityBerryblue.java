/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class EntityBerryblue
/*    */   extends EntityDBCEvil
/*    */ {
/* 16 */   public int randomSoundDelay = 0;
/*    */   public String tex;
/* 18 */   public final int AttPow = 10;
/* 19 */   public final int HePo = 100;
/*    */   private int target;
/*    */   
/*    */   public EntityBerryblue(World par1World) {
/* 23 */     super(par1World);
/* 24 */     this.field_70728_aV = 200;
/* 25 */     this.tex = "berryblue";
/* 26 */     func_70105_a(1.0F, 1.5F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 32 */     super.func_110147_ax();
/* 33 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100.0D);
/* 34 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(10.0D);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 38 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*    */   }
/*    */   public long BattlePowerOld() {
/* 41 */     int BP = 200000;
/* 42 */     int exp = this.field_70728_aV * 100;
/* 43 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/* 44 */     return BattlePower;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_70636_d() {
/* 53 */     List<Entity> var4 = this.field_70170_p.func_72872_a(EntityPlayer.class, this.field_70121_D.func_72314_b(16.0D, 16.0D, 16.0D));
/* 54 */     if (!var4.isEmpty()) {
/* 55 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/* 56 */         Entity var6 = var4.get(var5);
/* 57 */         becomeAngryAt(var6);
/*    */       } 
/*    */     }
/* 60 */     super.func_70636_d();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70645_a(DamageSource par1DamageSource) {
/* 65 */     Entity var3 = par1DamageSource.func_76346_g();
/* 66 */     if (var3 instanceof EntityPlayer)
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
/* 82 */       becomeAngryAt(var3);
/*    */     }
/*    */     
/* 85 */     super.func_70645_a(par1DamageSource);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void becomeAngryAt(Entity par1Entity) {
/* 93 */     this.field_70789_a = par1Entity;
/* 94 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 95 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityBerryblue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */