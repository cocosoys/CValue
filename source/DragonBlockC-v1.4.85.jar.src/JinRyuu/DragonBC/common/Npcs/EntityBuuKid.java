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
/*     */ public class EntityBuuKid
/*     */   extends EntityDBCEvil
/*     */ {
/*  14 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  16 */   public final int AttPow = 12000;
/*  17 */   public final int HePo = 30000;
/*     */   private int target;
/*     */   
/*     */   public EntityBuuKid(World par1World) {
/*  21 */     super(par1World);
/*  22 */     this.field_70728_aV = 200;
/*  23 */     this.tex = "kidMajinBuu";
/*  24 */     setData1(5);
/*  25 */     setData2(3);
/*  26 */     setHardDifficulty();
/*  27 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  32 */     super.func_110147_ax();
/*  33 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30000.0D);
/*  34 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(12000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  38 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  41 */     int BP = -1014444032;
/*  42 */     int exp = this.field_70728_aV * 100;
/*  43 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  48 */     return BattlePower;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  58 */     if (doBlst()) {
/*  59 */       if ((int)(Math.random() * 2.0D) == 0) {
/*  60 */         setData1(5);
/*  61 */         setData2(3);
/*     */       } else {
/*     */         
/*  64 */         setData1(1);
/*  65 */         setData2(3);
/*     */       } 
/*     */     }
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
/*  85 */     super.func_70636_d();
/*     */   }
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/*  89 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/*  91 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/* 109 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 112 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 120 */     this.field_70789_a = par1Entity;
/* 121 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 122 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityBuuKid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */