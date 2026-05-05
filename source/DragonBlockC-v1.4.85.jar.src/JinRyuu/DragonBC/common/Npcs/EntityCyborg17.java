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
/*     */ public class EntityCyborg17
/*     */   extends EntityCyborgsInf
/*     */ {
/*  19 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  21 */   public final int AttPow = 1200;
/*  22 */   public final int HePo = 12000;
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityCyborg17(World par1World) {
/*  27 */     super(par1World);
/*     */     
/*  29 */     this.field_70728_aV = 200;
/*     */     
/*  31 */     this.tex = "c17";
/*  32 */     setMediumDifficulty();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  37 */     super.func_110147_ax();
/*  38 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(12000.0D);
/*  39 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1200.0D);
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
/*  87 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer) {
/*     */       
/*  89 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/*  91 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/*  93 */         Entity var6 = var4.get(var5);
/*     */         
/*  95 */         if (var6 instanceof EntityCyborg16) {
/*     */           
/*  97 */           EntityCyborg16 var7 = (EntityCyborg16)var6;
/*  98 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
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


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityCyborg17.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */