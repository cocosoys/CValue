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
/*     */ public class EntityCellJr
/*     */   extends EntityCyborgsInf
/*     */ {
/*  17 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  19 */   public final int AttPow = 1000;
/*  20 */   public final int HePo = 10000;
/*     */   private int target;
/*     */   
/*     */   public EntityCellJr(World par1World) {
/*  24 */     super(par1World);
/*  25 */     this.field_70728_aV = 200;
/*  26 */     this.tex = "celljr";
/*  27 */     setMediumDifficulty();
/*  28 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  33 */     super.func_110147_ax();
/*  34 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0D);
/*  35 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1000.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  41 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  44 */     long BP = 1000000000000L;
/*  45 */     int exp = this.field_70728_aV * 100;
/*  46 */     long BattlePower = BP + this.field_70146_Z.nextInt(100);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  51 */     return BattlePower;
/*     */   }
/*     */   public void target(int i) {
/*  54 */     this.target = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  62 */     if (doBlst()) {
/*  63 */       int r = (int)(Math.random() * 4.0D);
/*  64 */       if (r == 0) {
/*  65 */         setData1(1);
/*  66 */         setData2(0);
/*     */       }
/*  68 */       else if (r == 1) {
/*  69 */         setData1(3);
/*  70 */         setData2(0);
/*     */       }
/*  72 */       else if (r == 2) {
/*  73 */         setData1(4);
/*  74 */         setData2(7);
/*     */       } else {
/*     */         
/*  77 */         setData1(2);
/*  78 */         setData2(7);
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
/*  96 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 101 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 103 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/* 121 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 124 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 132 */     this.field_70789_a = par1Entity;
/* 133 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 134 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityCellJr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */