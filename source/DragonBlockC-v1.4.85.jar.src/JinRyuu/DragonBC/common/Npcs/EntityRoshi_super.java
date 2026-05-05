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
/*     */ public class EntityRoshi_super
/*     */   extends EntityDBCEvil
/*     */ {
/*  14 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  16 */   public final int AttPow = 5000;
/*  17 */   public final int HePo = 10000;
/*     */   private int target;
/*     */   
/*     */   public EntityRoshi_super(World par1World) {
/*  21 */     super(par1World);
/*  22 */     this.field_70728_aV = 200;
/*  23 */     this.tex = "roshi_super";
/*     */     
/*  25 */     setData2(2);
/*  26 */     setHardDifficulty();
/*  27 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  33 */     super.func_110147_ax();
/*  34 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0D);
/*  35 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  39 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  42 */     int BP = 1410065408;
/*  43 */     int exp = this.field_70728_aV * 100;
/*  44 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*  45 */     return BattlePower;
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
/*  69 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/*  74 */     Entity var3 = par1DamageSource.func_76346_g();
/*  75 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/*  91 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/*  94 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 102 */     this.field_70789_a = par1Entity;
/* 103 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 104 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityRoshi_super.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */