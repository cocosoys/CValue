/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.monster.IMob;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntitySaibaiman extends EntityDBCEvil implements IMob {
/* 12 */   public int randomSoundDelay = 0;
/* 13 */   public final int AttPow = 20;
/* 14 */   public final int HePo = 200;
/*    */ 
/*    */   
/*    */   public EntitySaibaiman(World par1World) {
/* 18 */     super(par1World);
/* 19 */     this.field_70728_aV = 10;
/*    */ 
/*    */ 
/*    */     
/* 23 */     setKiUsage(false, false);
/* 24 */     setEasyDifficulty();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 29 */     super.func_110147_ax();
/* 30 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0D);
/* 31 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(20.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 37 */     return "jinryuudragonbc:npcs/Saibaiman.png";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_70601_bi() {
/* 45 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_70636_d() {
/* 51 */     becomeAngryAtAllPlayer();
/* 52 */     super.func_70636_d();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_70628_a(boolean par1, int par2) {
/* 60 */     int ran = this.field_70146_Z.nextInt(5);
/* 61 */     if (ran == 0)
/*    */     {
/* 63 */       func_145779_a(ItemsDBC.ItemSaibaiSeed, 1);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 72 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntitySaibaiman.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */