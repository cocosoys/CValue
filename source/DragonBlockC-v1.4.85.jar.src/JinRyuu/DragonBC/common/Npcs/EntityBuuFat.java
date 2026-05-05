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
/*     */ public class EntityBuuFat
/*     */   extends EntityDBCEvil
/*     */ {
/*  19 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  21 */   public final int AttPow = 4800;
/*  22 */   public final int HePo = 48000;
/*     */   private int target;
/*     */   
/*     */   public EntityBuuFat(World par1World) {
/*  26 */     super(par1World);
/*  27 */     this.field_70728_aV = 200;
/*  28 */     this.tex = "fatMajinBuu";
/*  29 */     setMediumDifficulty();
/*  30 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  35 */     super.func_110147_ax();
/*  36 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(48000.0D);
/*  37 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(4800.0D);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  42 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   
/*     */   public void target(int i) {
/*  46 */     this.target = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  55 */     if (doBlst()) {
/*  56 */       int r = (int)(Math.random() * 3.0D);
/*  57 */       if (r == 0) {
/*  58 */         setData1(1);
/*  59 */         setData2(0);
/*     */       }
/*  61 */       else if (r == 1) {
/*  62 */         setData1(6);
/*  63 */         setData2(0);
/*     */       } else {
/*     */         
/*  66 */         setData1(5);
/*  67 */         setData2(0);
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
/*  86 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/*  91 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/*  93 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  98 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 100 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 102 */         Entity var6 = var4.get(var5);
/*     */         
/* 104 */         if (var6 instanceof EntityBuuFat) {
/*     */           
/* 106 */           EntityBuuFat var7 = (EntityBuuFat)var6;
/* 107 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 111 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 114 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 122 */     this.field_70789_a = par1Entity;
/* 123 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 124 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityBuuFat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */