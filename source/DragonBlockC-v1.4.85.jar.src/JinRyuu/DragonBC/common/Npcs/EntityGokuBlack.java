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
/*     */ public class EntityGokuBlack
/*     */   extends EntityDBCEvil
/*     */ {
/*  15 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  17 */   public final int AttPow = 12000;
/*  18 */   public final int HePo = 90000;
/*     */   private int target;
/*     */   
/*     */   public EntityGokuBlack(World par1World) {
/*  22 */     super(par1World);
/*  23 */     this.field_70728_aV = 200;
/*  24 */     this.tex = "gokublack";
/*  25 */     func_70105_a(0.6F, 2.0F);
/*  26 */     setHardDifficulty();
/*  27 */     addAAiTeleport("jinryuudragonbc:DBC4.blacktp");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  33 */     super.func_110147_ax();
/*  34 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(90000.0D);
/*  35 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(12000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  39 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  42 */     int BP = 1251635200;
/*  43 */     int exp = this.field_70728_aV * 100;
/*  44 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*  45 */     return BattlePower;
/*     */   }
/*     */ 
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
/*  59 */         setData2(7);
/*     */       }
/*  61 */       else if (r == 1) {
/*  62 */         setData1(1);
/*  63 */         setData2(0);
/*     */       } else {
/*     */         
/*  66 */         setData1(5);
/*  67 */         setData2(0);
/*     */       } 
/*     */     } 
/*     */     
/*  71 */     if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8)
/*     */     {
/*  73 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*  74 */         for (int i = 0; i < 5; i++) {
/*  75 */           EntityGokuBlack entityGokuBlack = this;
/*     */           
/*  77 */           double x = Math.random() * 1.0D - 0.5D;
/*  78 */           double y = Math.random() * this.field_70131_O - 0.5D;
/*  79 */           double z = Math.random() * 1.0D - 0.5D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  87 */           EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGokuBlack).field_70165_t, ((Entity)entityGokuBlack).field_70163_u, ((Entity)entityGokuBlack).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, (float)(Math.random() * 0.029999999329447746D), (float)(Math.random() * 0.029999999329447746D) + 0.05F, 0.1F, 0, 213.0F, 118.0F, 241.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 3, 0.5F, 0.0F, 0.0F, 0.0F, -0.1F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  92 */           x = Math.random() * 1.0D - 0.5D;
/*  93 */           y = Math.random() * this.field_70131_O - 0.5D;
/*  94 */           z = Math.random() * 1.0D - 0.5D;
/*  95 */           ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 104 */           EntityCusPar entityCusPar2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityGokuBlack).field_70165_t, ((Entity)entityGokuBlack).field_70163_u, ((Entity)entityGokuBlack).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, (float)(Math.random() * 0.029999999329447746D), (float)(Math.random() * 0.029999999329447746D) + 0.05F, 0.1F, 0, 213.0F, 118.0F, 241.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 3, 0.5F, 0.0F, 0.0F, 0.0F, -0.1F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 109 */           ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar2);
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
/* 130 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 135 */     Entity var3 = par1DamageSource.func_76346_g();
/* 136 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityGokuBlack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */