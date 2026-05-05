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
/*     */ public class EntityKefla
/*     */   extends EntityDBCEvil
/*     */ {
/*  14 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  16 */   public final int AttPow = 20000;
/*  17 */   public final int HePo = 120000;
/*     */   private int target;
/*     */   
/*     */   public EntityKefla(World par1World) {
/*  21 */     super(par1World);
/*  22 */     this.field_70728_aV = 200;
/*  23 */     this.tex = "kefla";
/*  24 */     func_70105_a(0.6F, 2.0F);
/*  25 */     setData1(1);
/*  26 */     setData2(6);
/*  27 */     setHardDifficulty();
/*  28 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  34 */     super.func_110147_ax();
/*  35 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(120000.0D);
/*  36 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(20000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  40 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  43 */     int BP = -1036337152;
/*  44 */     int exp = this.field_70728_aV * 100;
/*  45 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*  46 */     return BattlePower;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  54 */     if (doBlst()) {
/*  55 */       int r = (int)(Math.random() * 6.0D);
/*  56 */       if (r == 0) {
/*  57 */         setData1(1);
/*  58 */         setData2(6);
/*     */       }
/*  60 */       else if (r == 1) {
/*  61 */         setData1(6);
/*  62 */         setData2(6);
/*     */       }
/*  64 */       else if (r == 2) {
/*  65 */         setData1(5);
/*  66 */         setData2(6);
/*     */       }
/*  68 */       else if (r == 3) {
/*  69 */         setData1(1);
/*  70 */         setData2(4);
/*     */       }
/*  72 */       else if (r == 4) {
/*  73 */         setData1(6);
/*  74 */         setData2(4);
/*     */       } else {
/*     */         
/*  77 */         setData1(5);
/*  78 */         setData2(4);
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
/*  98 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 103 */     Entity var3 = par1DamageSource.func_76346_g();
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
/*     */ 
/*     */       
/* 120 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 123 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 131 */     this.field_70789_a = par1Entity;
/* 132 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 133 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityKefla.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */