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
/*     */ public class EntityTrunks_dbs2
/*     */   extends EntityDBCEvil
/*     */ {
/*  16 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  18 */   public final int AttPow = 16000;
/*  19 */   public final int HePo = 100000;
/*     */   private int target;
/*     */   
/*     */   public EntityTrunks_dbs2(World par1World) {
/*  23 */     super(par1World);
/*  24 */     this.field_70728_aV = 200;
/*  25 */     this.tex = "trunks2_ssj";
/*  26 */     func_70105_a(0.6F, 2.0F);
/*  27 */     setData2(2);
/*  28 */     setHardDifficulty();
/*  29 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  35 */     super.func_110147_ax();
/*  36 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100000.0D);
/*  37 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(16000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  41 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  44 */     int BP = -2122547200;
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
/*  56 */       int r = (int)(Math.random() * 3.0D);
/*  57 */       if (r == 0) {
/*  58 */         setData1(1);
/*  59 */         setData2(2);
/*     */       }
/*  61 */       else if (r == 1) {
/*  62 */         setData1(1);
/*  63 */         setData2(2);
/*     */       } else {
/*     */         
/*  66 */         setData1(6);
/*  67 */         setData2(7);
/*     */       } 
/*     */     } 
/*     */     
/*  71 */     if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
/*  72 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*  73 */         for (int i = 0; i < 5; i++) {
/*  74 */           EntityTrunks_dbs2 entityTrunks_dbs2 = this;
/*     */ 
/*     */           
/*  77 */           float a = 0.5F, h1 = 1.0F;
/*  78 */           float red = 255.0F, green = 217.0F, blue = 25.0F;
/*     */ 
/*     */           
/*  81 */           float life = 0.8F * ((Entity)entityTrunks_dbs2).field_70131_O;
/*  82 */           float extra_scale = 1.0F + ((((Entity)entityTrunks_dbs2).field_70131_O > 2.1F) ? (((Entity)entityTrunks_dbs2).field_70131_O / 2.0F) : 0.0F) / 5.0F;
/*  83 */           float width = ((Entity)entityTrunks_dbs2).field_70130_N * 3.0F;
/*     */           
/*  85 */           double x = (Math.random() * 1.0D - 0.5D) * (width * 1.2F);
/*  86 */           double y = Math.random() * (this.field_70131_O * 1.4F) - (this.field_70131_O / 2.0F) - 0.30000001192092896D;
/*  87 */           double z = (Math.random() * 1.0D - 0.5D) * (width * 1.2F);
/*     */ 
/*     */ 
/*     */           
/*  91 */           double motx = Math.random() * 0.019999999552965164D - 0.009999999776482582D;
/*  92 */           double moty = (Math.random() * 0.8999999761581421D + 0.8999999761581421D) * (life * extra_scale) * 0.07D;
/*  93 */           double motz = Math.random() * 0.019999999552965164D - 0.009999999776482582D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 103 */           EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", ((Entity)entityTrunks_dbs2).field_70170_p, 0.2F, 0.2F, ((Entity)entityTrunks_dbs2).field_70165_t, ((Entity)entityTrunks_dbs2).field_70163_u + ((entityTrunks_dbs2 instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), ((Entity)entityTrunks_dbs2).field_70161_v, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 3.0D) + 32, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 0.5F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.2F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.08F, false, -1, true, (Entity)entityTrunks_dbs2);
/*     */ 
/*     */ 
/*     */           
/* 107 */           ((Entity)entityTrunks_dbs2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 117 */           EntityCusPar entityCusPar1 = new EntityCusPar("jinryuudragonbc:bens_particles.png", ((Entity)entityTrunks_dbs2).field_70170_p, 0.2F, 0.2F, ((Entity)entityTrunks_dbs2).field_70165_t, ((Entity)entityTrunks_dbs2).field_70163_u + ((entityTrunks_dbs2 instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), ((Entity)entityTrunks_dbs2).field_70161_v, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 0.5F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.1F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.08F, false, -1, true, (Entity)entityTrunks_dbs2);
/*     */ 
/*     */ 
/*     */           
/* 121 */           ((Entity)entityTrunks_dbs2).field_70170_p.func_72838_d((Entity)entityCusPar1);
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
/* 143 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 148 */     Entity var3 = par1DamageSource.func_76346_g();
/* 149 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/* 165 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 168 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 176 */     this.field_70789_a = par1Entity;
/* 177 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 178 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityTrunks_dbs2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */