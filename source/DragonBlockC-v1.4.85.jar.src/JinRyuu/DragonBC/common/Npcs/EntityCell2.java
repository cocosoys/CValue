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
/*     */ public class EntityCell2
/*     */   extends EntityCyborgsInf
/*     */ {
/*  17 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  19 */   private int target = 0;
/*  20 */   public final int AttPow = 1600;
/*  21 */   public final int HePo = 16000;
/*     */ 
/*     */   
/*     */   public EntityCell2(World par1World) {
/*  25 */     super(par1World);
/*  26 */     this.field_70728_aV = 200;
/*  27 */     this.tex = "cell2";
/*  28 */     setData1(1);
/*  29 */     setData2(4);
/*  30 */     setMediumDifficulty();
/*  31 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  36 */     super.func_110147_ax();
/*  37 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(16000.0D);
/*  38 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1600.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  44 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */ 
/*     */   
/*     */   public void target(int i) {
/*  49 */     this.target = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  56 */     if (doBlst()) {
/*  57 */       int r = (int)(Math.random() * 4.0D);
/*  58 */       if (r == 0) {
/*  59 */         setData1(1);
/*  60 */         setData2(4);
/*     */       }
/*  62 */       else if (r == 1) {
/*  63 */         setData1(3);
/*  64 */         setData2(0);
/*     */       }
/*  66 */       else if (r == 2) {
/*  67 */         setData1(4);
/*  68 */         setData2(7);
/*     */       } else {
/*     */         
/*  71 */         setData1(2);
/*  72 */         setData2(7);
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
/*     */     
/*  93 */     if (!this.field_70170_p.field_72995_K);
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
/* 127 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 132 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 134 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/* 152 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 155 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 163 */     this.field_70789_a = par1Entity;
/* 164 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 165 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityCell2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */