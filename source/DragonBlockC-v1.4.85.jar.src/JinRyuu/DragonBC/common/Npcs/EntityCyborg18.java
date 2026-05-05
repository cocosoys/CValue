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
/*     */ 
/*     */ 
/*     */ public class EntityCyborg18
/*     */   extends EntityCyborgsInf
/*     */ {
/*  19 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  21 */   public final int AttPow = 1000;
/*  22 */   public final int HePo = 10000;
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityCyborg18(World par1World) {
/*  27 */     super(par1World);
/*     */     
/*  29 */     this.field_70728_aV = 200;
/*     */     
/*  31 */     this.tex = "c18";
/*  32 */     setMediumDifficulty();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  37 */     super.func_110147_ax();
/*  38 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0D);
/*  39 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1000.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  45 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/*  52 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/*  54 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/*  72 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/*  75 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/*  79 */     if (func_85032_ar())
/*     */     {
/*  81 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  85 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/*  87 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/* 102 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 105 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void becomeAngryAt(Entity par1Entity) {
/* 113 */     this.field_70789_a = par1Entity;
/* 114 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 115 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityCyborg18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */