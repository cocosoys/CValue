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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityGodLiquiir
/*     */   extends EntityDBCEvil
/*     */ {
/*  18 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  20 */   public final int AttPow = 9200;
/*  21 */   public final int HePo = 92000;
/*     */   private int target;
/*     */   
/*     */   public EntityGodLiquiir(World par1World) {
/*  25 */     super(par1World);
/*  26 */     this.field_70728_aV = 200;
/*  27 */     this.tex = "god_liquiir";
/*  28 */     func_70105_a(0.6F, 2.0F);
/*  29 */     setData1(5);
/*  30 */     setData2(8);
/*  31 */     setHardDifficulty();
/*  32 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  38 */     super.func_110147_ax();
/*  39 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(92000.0D);
/*  40 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(9200.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  46 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   
/*     */   public long BattlePowerOld() {
/*  50 */     int BP = 1776275456;
/*  51 */     int exp = this.field_70728_aV * 100;
/*  52 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  57 */     return BattlePower;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  64 */     if (doBlst()) {
/*  65 */       if ((int)(Math.random() * 2.0D) == 0) {
/*  66 */         setData1(5);
/*  67 */         setData2(8);
/*     */       } else {
/*     */         
/*  70 */         setData1(1);
/*  71 */         setData2(0);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  76 */     if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
/*  77 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*  78 */         for (int i = 0; i < 5; i++) {
/*  79 */           EntityGodLiquiir entityGodLiquiir = this;
/*     */ 
/*     */           
/*  82 */           double x = Math.random() * 1.0D - 0.5D;
/*  83 */           double y = Math.random() * this.field_70131_O - 0.5D;
/*  84 */           double z = Math.random() * 1.0D - 0.5D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  92 */           EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGodLiquiir).field_70165_t, ((Entity)entityGodLiquiir).field_70163_u, ((Entity)entityGodLiquiir).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, (float)(Math.random() * 0.029999999329447746D), (float)(Math.random() * 0.029999999329447746D) + 0.05F, 0.1F, 2, 168.0F, 50.0F, 214.0F, 0.0F, 0.0F, 0.0F, 175.0F, 55.0F, 228.0F, 3, 0.5F, 0.0F, 0.0F, 0.0F, -0.1F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */           
/*  96 */           ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*     */ 
/*     */           
/*  99 */           x = Math.random() * 1.0D - 0.5D;
/* 100 */           y = Math.random() * this.field_70131_O - 0.5D;
/* 101 */           z = Math.random() * 1.0D - 0.5D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 110 */           EntityCusPar entityCusPar1 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGodLiquiir).field_70165_t, ((Entity)entityGodLiquiir).field_70163_u, ((Entity)entityGodLiquiir).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, (float)(Math.random() * 0.029999999329447746D), (float)(Math.random() * 0.029999999329447746D) + 0.05F, 0.1F, 2, 168.0F, 50.0F, 214.0F, 0.0F, 0.0F, 0.0F, 175.0F, 55.0F, 228.0F, 3, 0.5F, 0.0F, 0.0F, 0.0F, -0.1F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */           
/* 114 */           ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
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
/* 136 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 141 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 143 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/* 161 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 164 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 172 */     this.field_70789_a = par1Entity;
/* 173 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 174 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityGodLiquiir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */