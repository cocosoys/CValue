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
/*     */ public class EntityBuuBuffed
/*     */   extends EntityDBCEvil
/*     */ {
/*  14 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  16 */   public final int AttPow = 7200;
/*  17 */   public final int HePo = 72000;
/*     */   private int target;
/*     */   
/*     */   public EntityBuuBuffed(World par1World) {
/*  21 */     super(par1World);
/*  22 */     this.field_70728_aV = 200;
/*  23 */     this.tex = "superMajinBuu_Buffed";
/*  24 */     setData2(3);
/*  25 */     setMediumDifficulty();
/*  26 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  31 */     super.func_110147_ax();
/*  32 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(72000.0D);
/*  33 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(7200.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  37 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  40 */     int BP = 600784896;
/*  41 */     int exp = this.field_70728_aV * 100;
/*  42 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  47 */     return BattlePower;
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
/*  71 */     super.func_70636_d();
/*     */   }
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/*  75 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/*  77 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/*     */ 
/*     */       
/*  95 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/*  98 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 106 */     this.field_70789_a = par1Entity;
/* 107 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 108 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityBuuBuffed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */