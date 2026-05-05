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
/*    */ public class EntityZeno
/*    */   extends EntityDBCEvil
/*    */ {
/* 16 */   public int randomSoundDelay = 0;
/*    */   public String tex;
/* 18 */   public final int AttPow = 600000;
/* 19 */   public final int HePo = 2000000;
/*    */   private int wait;
/*    */   private int m; private int target; protected void func_110147_ax() { super.func_110147_ax();
/*    */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2000000.0D);
/* 23 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(600000.0D); } public EntityZeno(World par1World) { super(par1World);
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
/*    */ 
/*    */     
/* 50 */     this.wait = 0;
/* 51 */     this.m = 1; this.field_70728_aV = 200;
/*    */     this.tex = "zeno";
/*    */     func_70105_a(0.6F, 2.0F);
/*    */     setData1(5);
/*    */     setData2(2);
/* 56 */     setHardDifficulty(); } public void func_70636_d() { List<Entity> var4 = this.field_70170_p.func_72872_a(EntityPlayer.class, this.field_70121_D.func_72314_b(16.0D, 16.0D, 16.0D));
/* 57 */     if (!var4.isEmpty()) {
/* 58 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/* 59 */         Entity var6 = var4.get(var5);
/* 60 */         becomeAngryAt(var6);
/*    */       } 
/*    */     }
/* 63 */     super.func_70636_d(); } @SideOnly(Side.CLIENT) public String getTexture() { return "jinryuudragonbc:npcs/" + this.tex + ".png"; }
/*    */   public long BattlePowerOld() { int BP = 1522466816;
/*    */     int exp = this.field_70728_aV * 100;
/*    */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*    */     return BattlePower; }
/* 68 */   public void func_70645_a(DamageSource par1DamageSource) { Entity var3 = par1DamageSource.func_76346_g();
/* 69 */     if (var3 instanceof EntityPlayer)
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
/* 85 */       becomeAngryAt(var3);
/*    */     }
/*    */     
/* 88 */     super.func_70645_a(par1DamageSource); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void becomeAngryAt(Entity par1Entity) {
/* 96 */     this.field_70789_a = par1Entity;
/* 97 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 98 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityZeno.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */