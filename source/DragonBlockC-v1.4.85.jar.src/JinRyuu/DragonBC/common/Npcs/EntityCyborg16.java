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
/*     */ public class EntityCyborg16
/*     */   extends EntityCyborgsInf
/*     */ {
/*  19 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  21 */   public final int AttPow = 1400;
/*  22 */   public final int HePo = 14000;
/*     */ 
/*     */   
/*     */   public EntityCyborg16(World par1World) {
/*  26 */     super(par1World);
/*  27 */     this.field_70728_aV = 200;
/*  28 */     this.tex = "c16";
/*  29 */     setMediumDifficulty();
/*     */   }
/*     */   
/*     */   protected void func_110147_ax() {
/*  33 */     super.func_110147_ax();
/*  34 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(14000.0D);
/*  35 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1400.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  41 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/*  47 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/*  49 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/*  67 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/*  70 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/*  74 */     if (func_85032_ar())
/*     */     {
/*  76 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  80 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/*  82 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer) {
/*     */       
/*  84 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/*  86 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/*  88 */         Entity var6 = var4.get(var5);
/*     */         
/*  90 */         if (var6 instanceof EntityCyborg17) {
/*     */           
/*  92 */           EntityCyborg17 var7 = (EntityCyborg17)var6;
/*  93 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/*  97 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 100 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void becomeAngryAt(Entity par1Entity) {
/* 108 */     this.field_70789_a = par1Entity;
/* 109 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 110 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityCyborg16.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */