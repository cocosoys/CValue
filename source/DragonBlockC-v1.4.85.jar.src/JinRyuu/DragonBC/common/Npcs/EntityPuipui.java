/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityPuipui
/*     */   extends EntityDBCEvil {
/*  12 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  14 */   public final int AttPow = 1000;
/*  15 */   public final int HePo = 10000;
/*     */   private int target;
/*     */   
/*     */   public EntityPuipui(World world) {
/*  19 */     super(world);
/*  20 */     this.field_70728_aV = 200;
/*  21 */     this.tex = "puipui";
/*  22 */     setMediumDifficulty();
/*  23 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  28 */     super.func_110147_ax();
/*  29 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0D);
/*  30 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1000.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  36 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
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
/*     */   public void target(int i) {
/*  51 */     this.target = i;
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
/*  74 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/*  80 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/*  82 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/* 100 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 103 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 111 */     this.field_70789_a = par1Entity;
/* 112 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 113 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityPuipui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */