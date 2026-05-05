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
/*     */ public class EntityVegetaCopyBlue
/*     */   extends EntityDBCEvil
/*     */ {
/*  15 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  17 */   public final int AttPow = 16000;
/*  18 */   public final int HePo = 112000;
/*     */   private int target;
/*     */   
/*     */   public EntityVegetaCopyBlue(World par1World) {
/*  22 */     super(par1World);
/*  23 */     this.field_70728_aV = 200;
/*  24 */     this.tex = "vegetacopyblue";
/*  25 */     func_70105_a(0.6F, 2.0F);
/*  26 */     setHardDifficulty();
/*  27 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  33 */     super.func_110147_ax();
/*  34 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(112000.0D);
/*  35 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(16000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  39 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  42 */     int BP = 1917714432;
/*  43 */     int exp = this.field_70728_aV * 100;
/*  44 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*  45 */     return BattlePower;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  53 */     if (doBlst()) {
/*  54 */       int r = (int)(Math.random() * 3.0D);
/*  55 */       if (r == 0) {
/*  56 */         setData1(1);
/*  57 */         setData2(0);
/*     */       }
/*  59 */       else if (r == 1) {
/*  60 */         setData1(6);
/*  61 */         setData2(2);
/*     */       } else {
/*     */         
/*  64 */         setData1(5);
/*  65 */         setData2(0);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  70 */     if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
/*  71 */       float red = 48.0F, green = 208.0F, blue = 232.0F;
/*  72 */       float out = 1.6F, in = 1.0F;
/*  73 */       float life = 0.8F * this.field_70131_O;
/*  74 */       float extra_scale = 0.5F;
/*  75 */       int dea = 50;
/*     */       
/*  77 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*     */         int i;
/*  79 */         for (i = 0; i < 2; i++) {
/*  80 */           EntityVegetaCopyBlue entityVegetaCopyBlue1 = this;
/*     */           
/*  82 */           float spe2 = 1.3F;
/*  83 */           double d1 = Math.random() * spe2 - (spe2 / 2.0F);
/*  84 */           double d2 = -0.30000001192092896D;
/*  85 */           double d3 = Math.random() * spe2 - (spe2 / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  93 */           EntityCusPar entityCusPar = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityVegetaCopyBlue1).field_70165_t, ((Entity)entityVegetaCopyBlue1).field_70163_u, ((Entity)entityVegetaCopyBlue1).field_70161_v, d1, d2, d3, 0.0D, 0.05D + Math.random() * 0.10000000149011612D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 48, 48, 8, 32, false, 0.0F, false, 0.0F, 1, "", 25, 0, 0.003F + (float)(Math.random() * 0.006000000052154064D), 0.0F, 0.0F, 0, 160.0F, 220.0F, 255.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.8F, 0.0F, 0.9F, 0.95F, 0.02F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */           
/*  97 */           ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*     */         } 
/*  99 */         for (i = 0; i < 2; i++) {
/* 100 */           EntityVegetaCopyBlue entityVegetaCopyBlue1 = this;
/*     */           
/* 102 */           double d1 = Math.random() * 1.600000023841858D - 0.800000011920929D;
/* 103 */           double d2 = Math.random() * this.field_70131_O - 0.5D;
/* 104 */           double d3 = Math.random() * 1.600000023841858D - 0.800000011920929D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 112 */           EntityCusPar entityCusPar3 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityVegetaCopyBlue1).field_70165_t, ((Entity)entityVegetaCopyBlue1).field_70163_u, ((Entity)entityVegetaCopyBlue1).field_70161_v, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 48.0F, 208.0F, 232.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 117 */           d1 = Math.random() * 1.600000023841858D - 0.800000011920929D;
/* 118 */           d2 = Math.random() * this.field_70131_O - 0.5D;
/* 119 */           d3 = Math.random() * 1.600000023841858D - 0.800000011920929D;
/* 120 */           ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 129 */           EntityCusPar entityCusPar4 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityVegetaCopyBlue1).field_70165_t, ((Entity)entityVegetaCopyBlue1).field_70163_u, ((Entity)entityVegetaCopyBlue1).field_70161_v, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 48.0F, 208.0F, 232.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 134 */           ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar4);
/*     */         } 
/*     */         
/* 137 */         EntityVegetaCopyBlue entityVegetaCopyBlue = this;
/*     */         
/* 139 */         double x = Math.random() * 1.0D - 0.5D;
/* 140 */         double y = (Math.random() * this.field_70131_O - 0.5D) * 0.800000011920929D;
/* 141 */         double z = Math.random() * 1.0D - 0.5D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 149 */         EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityVegetaCopyBlue).field_70165_t, ((Entity)entityVegetaCopyBlue).field_70163_u, ((Entity)entityVegetaCopyBlue).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 160.0F, 220.0F, 255.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 154 */         x = Math.random() * 1.0D - 0.5D;
/* 155 */         y = (Math.random() * this.field_70131_O - 0.5D) * 0.800000011920929D;
/* 156 */         z = Math.random() * 1.0D - 0.5D;
/* 157 */         ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 166 */         EntityCusPar entityCusPar2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityVegetaCopyBlue).field_70165_t, ((Entity)entityVegetaCopyBlue).field_70163_u, ((Entity)entityVegetaCopyBlue).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 160.0F, 220.0F, 255.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 171 */         ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar2);
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
/*     */     
/* 193 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 198 */     Entity var3 = par1DamageSource.func_76346_g();
/* 199 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/* 215 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 218 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 226 */     this.field_70789_a = par1Entity;
/* 227 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 228 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityVegetaCopyBlue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */