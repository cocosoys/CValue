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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityYakon
/*     */   extends EntityDBCEvil
/*     */ {
/*  17 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  19 */   public final int AttPow = 1400;
/*  20 */   public final int HePo = 14000;
/*     */   private int target;
/*     */   
/*     */   public EntityYakon(World par1World) {
/*  24 */     super(par1World);
/*  25 */     this.field_70728_aV = 200;
/*  26 */     this.field_70130_N = 2.0F;
/*  27 */     this.field_70131_O = 4.0F;
/*  28 */     this.tex = "yakon";
/*  29 */     setMediumDifficulty();
/*  30 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  35 */     super.func_110147_ax();
/*  36 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(14000.0D);
/*  37 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1400.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  43 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   
/*     */   public void target(int i) {
/*  47 */     this.target = i;
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
/*     */   public void func_70636_d() {
/*  70 */     super.func_70636_d();
/*     */   }
/*     */ 
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


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityYakon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */