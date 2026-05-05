/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
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
/*     */ public class EntityCyborg20
/*     */   extends EntityCyborgsAbs
/*     */ {
/*  20 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*     */   private boolean abs;
/*  23 */   public final int AttPow = 800;
/*  24 */   public final int HePo = 8000;
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityCyborg20(World par1World) {
/*  29 */     super(par1World);
/*     */     
/*  31 */     this.field_70728_aV = 200;
/*     */     
/*  33 */     this.tex = "c20";
/*  34 */     this.abs = false;
/*  35 */     setMediumDifficulty();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  40 */     super.func_110147_ax();
/*  41 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(8000.0D);
/*  42 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(800.0D);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  47 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   
/*     */   public long BattlePowerOld() {
/*  51 */     long BP = 270000000L;
/*  52 */     int exp = this.field_70728_aV * 100;
/*  53 */     if (this.abs) BP = 320000000L; 
/*  54 */     long BattlePower = BP + this.field_70146_Z.nextInt(100);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     return BattlePower;
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/*  63 */     if (func_85032_ar() || par1DamageSource == null)
/*     */     {
/*  65 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  69 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/*  71 */     if (var3 instanceof JinRyuu.JRMCore.entity.EntityKiAttacks)
/*     */     {
/*  73 */       func_70606_j(func_110143_aJ() + 300.0F);
/*     */     }
/*  75 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer) {
/*     */       
/*  77 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/*  79 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/*  81 */         Entity var6 = var4.get(var5);
/*     */         
/*  83 */         if (var6 instanceof EntityCyborg19) {
/*     */           
/*  85 */           EntityCyborg19 var7 = (EntityCyborg19)var6;
/*  86 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/*  90 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/*  93 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/*  98 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 100 */     if (var3 instanceof JinRyuu.JRMCore.entity.EntityKiAttacks)
/*     */     {
/* 102 */       func_70606_j(func_110143_aJ() + 300.0F);
/*     */     }
/* 104 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/* 118 */       becomeAngryAt(var3);
/*     */     }
/* 120 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void becomeAngryAt(Entity par1Entity) {
/* 128 */     this.field_70789_a = par1Entity;
/* 129 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 130 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityCyborg20.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */