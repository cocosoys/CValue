/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.entity.EntityCusPar;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityBeerusMonaka
/*     */   extends EntityDBCEvil
/*     */ {
/*  15 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  17 */   public final int AttPow = 8000;
/*  18 */   public final int HePo = 104000;
/*     */   private int target;
/*     */   
/*     */   public EntityBeerusMonaka(World par1World) {
/*  22 */     super(par1World);
/*  23 */     this.field_70728_aV = 200;
/*  24 */     this.tex = "beerus_monaka";
/*  25 */     func_70105_a(0.6F, 2.0F);
/*  26 */     setData1(5);
/*  27 */     setData2(8);
/*  28 */     setHardDifficulty();
/*  29 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  35 */     super.func_110147_ax();
/*  36 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(104000.0D);
/*  37 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(8000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  41 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  44 */     int BP = -1103724544;
/*  45 */     int exp = this.field_70728_aV * 100;
/*  46 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*  47 */     return BattlePower;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  55 */     if (doBlst()) {
/*  56 */       if ((int)(Math.random() * 2.0D) == 0) {
/*  57 */         setData1(5);
/*  58 */         setData2(8);
/*     */       } else {
/*     */         
/*  61 */         setData1(1);
/*  62 */         setData2(0);
/*     */       } 
/*     */     }
/*     */     
/*  66 */     if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
/*  67 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*  68 */         for (int i = 0; i < 5; i++) {
/*  69 */           EntityBeerusMonaka entityBeerusMonaka = this;
/*     */ 
/*     */           
/*  72 */           double x = Math.random() * 1.0D - 0.5D;
/*  73 */           double y = Math.random() * this.field_70131_O - 0.5D;
/*  74 */           double z = Math.random() * 1.0D - 0.5D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  82 */           EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityBeerusMonaka).field_70165_t, ((Entity)entityBeerusMonaka).field_70163_u, ((Entity)entityBeerusMonaka).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, (float)(Math.random() * 0.029999999329447746D), (float)(Math.random() * 0.029999999329447746D) + 0.05F, 0.1F, 2, 168.0F, 50.0F, 214.0F, 0.0F, 0.0F, 0.0F, 175.0F, 55.0F, 228.0F, 3, 0.5F, 0.0F, 0.0F, 0.0F, -0.1F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */           
/*  86 */           ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*     */ 
/*     */           
/*  89 */           x = Math.random() * 1.0D - 0.5D;
/*  90 */           y = Math.random() * this.field_70131_O - 0.5D;
/*  91 */           z = Math.random() * 1.0D - 0.5D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 100 */           EntityCusPar entityCusPar1 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityBeerusMonaka).field_70165_t, ((Entity)entityBeerusMonaka).field_70163_u, ((Entity)entityBeerusMonaka).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, (float)(Math.random() * 0.029999999329447746D), (float)(Math.random() * 0.029999999329447746D) + 0.05F, 0.1F, 2, 168.0F, 50.0F, 214.0F, 0.0F, 0.0F, 0.0F, 175.0F, 55.0F, 228.0F, 3, 0.5F, 0.0F, 0.0F, 0.0F, -0.1F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */           
/* 104 */           ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*     */         } 
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
/* 126 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 131 */     Entity var3 = par1DamageSource.func_76346_g();
/* 132 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/* 148 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 151 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 159 */     this.field_70789_a = par1Entity;
/* 160 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 161 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityBeerusMonaka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */