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
/*     */ public class EntityCyborg19
/*     */   extends EntityCyborgsAbs
/*     */ {
/*  20 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*     */   private boolean abs;
/*  23 */   public int BP2 = 350000000;
/*  24 */   public final int AttPow = 600;
/*  25 */   public final int HePo = 6000;
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityCyborg19(World par1World) {
/*  30 */     super(par1World);
/*     */     
/*  32 */     this.field_70728_aV = 200;
/*     */     
/*  34 */     this.tex = "c19";
/*  35 */     this.abs = false;
/*  36 */     setMediumDifficulty();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  41 */     super.func_110147_ax();
/*  42 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(6000.0D);
/*  43 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(600.0D);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  48 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/*  53 */     if (func_85032_ar())
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  59 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/*  61 */     if (var3 instanceof JinRyuu.JRMCore.entity.EntityKiAttacks)
/*     */     {
/*  63 */       func_70606_j(func_110143_aJ() + 300.0F);
/*     */     }
/*  65 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer) {
/*     */       
/*  67 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/*  69 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/*  71 */         Entity var6 = var4.get(var5);
/*     */         
/*  73 */         if (var6 instanceof EntityCyborg20) {
/*     */           
/*  75 */           EntityCyborg20 var7 = (EntityCyborg20)var6;
/*  76 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/*  80 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/*  83 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/*  88 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/*  90 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/* 106 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 109 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void becomeAngryAt(Entity par1Entity) {
/* 117 */     this.field_70789_a = par1Entity;
/* 118 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 119 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityCyborg19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */