/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class EntityAngelCukatail
/*     */   extends EntityDBCEvil
/*     */ {
/*  14 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  16 */   public final int AttPow = 10000;
/*  17 */   public final int HePo = 100000;
/*     */   private int target;
/*     */   
/*     */   public EntityAngelCukatail(World par1World) {
/*  21 */     super(par1World);
/*  22 */     this.field_70728_aV = 200;
/*  23 */     this.tex = "angel_cukatail";
/*  24 */     func_70105_a(0.7F, 2.2F);
/*  25 */     setHardDifficulty();
/*  26 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  32 */     super.func_110147_ax();
/*  33 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100000.0D);
/*  34 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(10000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  38 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  41 */     int BP = -1863462912;
/*  42 */     int exp = this.field_70728_aV * 100;
/*  43 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*  44 */     return BattlePower;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  68 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/*  73 */     Entity var3 = par1DamageSource.func_76346_g();
/*  74 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  90 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/*  93 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 101 */     this.field_70789_a = par1Entity;
/* 102 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 103 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityAngelCukatail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */