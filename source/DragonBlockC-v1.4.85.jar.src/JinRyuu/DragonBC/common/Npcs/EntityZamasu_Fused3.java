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
/*     */ public class EntityZamasu_Fused3
/*     */   extends EntityDBCEvil
/*     */ {
/*  15 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  17 */   public final int AttPow = 32000;
/*  18 */   public final int HePo = 132000;
/*     */   private int target;
/*     */   
/*     */   public EntityZamasu_Fused3(World par1World) {
/*  22 */     super(par1World);
/*  23 */     this.field_70728_aV = 200;
/*  24 */     this.tex = "zamasu_fused2";
/*  25 */     func_70105_a(0.6F, 2.0F);
/*  26 */     setHardDifficulty();
/*  27 */     addAAiTeleport("jinryuudragonbc:DBC4.blacktp");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  33 */     super.func_110147_ax();
/*  34 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(132000.0D);
/*  35 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(32000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  39 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  42 */     int BP = -1308557312;
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
/*     */   public void func_70636_d() {
/*  54 */     if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
/*  55 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*     */         
/*  57 */         float red = 186.0F, green = 37.0F, blue = 197.0F;
/*  58 */         float red2 = 140.0F, green2 = 8.0F, blue2 = 62.0F;
/*  59 */         float out = 1.6F, in = 1.0F;
/*  60 */         float life = 0.8F * this.field_70131_O;
/*  61 */         float extra_scale = 0.5F;
/*  62 */         int dea = 50;
/*  63 */         EntityZamasu_Fused3 entityZamasu_Fused3 = this;
/*     */ 
/*     */         
/*  66 */         for (int gh = 0; gh < 2; gh++) {
/*  67 */           double d1 = Math.random() * out - (out / 2.0F);
/*  68 */           double d2 = Math.random() * this.field_70131_O - 0.5D;
/*  69 */           double d3 = Math.random() * out - (out / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  77 */           EntityCusPar entityCusPar7 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityZamasu_Fused3).field_70165_t, ((Entity)entityZamasu_Fused3).field_70163_u, ((Entity)entityZamasu_Fused3).field_70161_v, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 186.0F, 37.0F, 197.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)entityZamasu_Fused3);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  82 */           d1 = Math.random() * out - (out / 2.0F);
/*  83 */           d2 = Math.random() * this.field_70131_O - 0.5D;
/*  84 */           d3 = Math.random() * out - (out / 2.0F);
/*  85 */           ((Entity)entityCusPar7).field_70170_p.func_72838_d((Entity)entityCusPar7);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  94 */           EntityCusPar entityCusPar8 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityZamasu_Fused3).field_70165_t, ((Entity)entityZamasu_Fused3).field_70163_u, ((Entity)entityZamasu_Fused3).field_70161_v, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 186.0F, 37.0F, 197.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)entityZamasu_Fused3);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  99 */           ((Entity)entityCusPar7).field_70170_p.func_72838_d((Entity)entityCusPar8);
/*     */         } 
/*     */         
/* 102 */         out *= 1.4F;
/* 103 */         double x = Math.random() * out - (out / 2.0F);
/* 104 */         double y = Math.random() * this.field_70131_O - 0.5D;
/* 105 */         double z = Math.random() * out - (out / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 113 */         EntityCusPar entityCusPar3 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityZamasu_Fused3).field_70165_t, ((Entity)entityZamasu_Fused3).field_70163_u, ((Entity)entityZamasu_Fused3).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 140.0F, 8.0F, 62.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)entityZamasu_Fused3);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 118 */         x = Math.random() * out - (out / 2.0F);
/* 119 */         y = Math.random() * this.field_70131_O - 0.5D;
/* 120 */         z = Math.random() * out - (out / 2.0F);
/* 121 */         ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 130 */         EntityCusPar entityCusPar6 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityZamasu_Fused3).field_70165_t, ((Entity)entityZamasu_Fused3).field_70163_u, ((Entity)entityZamasu_Fused3).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 140.0F, 8.0F, 62.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)entityZamasu_Fused3);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 135 */         ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar6);
/*     */ 
/*     */         
/* 138 */         x = Math.random() * in - (in / 2.0F);
/* 139 */         y = (Math.random() * this.field_70131_O - 0.5D) * 0.800000011920929D;
/* 140 */         z = Math.random() * in - (in / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 148 */         EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityZamasu_Fused3).field_70165_t, ((Entity)entityZamasu_Fused3).field_70163_u, ((Entity)entityZamasu_Fused3).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 184.0F, 147.0F, 241.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)entityZamasu_Fused3);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 153 */         x = Math.random() * in - (in / 2.0F);
/* 154 */         y = (Math.random() * this.field_70131_O - 0.5D) * 0.800000011920929D;
/* 155 */         z = Math.random() * in - (in / 2.0F);
/* 156 */         ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 165 */         EntityCusPar entityCusPar5 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityZamasu_Fused3).field_70165_t, ((Entity)entityZamasu_Fused3).field_70163_u, ((Entity)entityZamasu_Fused3).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 184.0F, 147.0F, 241.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)entityZamasu_Fused3);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 170 */         ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar5);
/*     */ 
/*     */         
/* 173 */         in *= 1.2F;
/* 174 */         x = Math.random() * in - (in / 2.0F);
/* 175 */         y = (Math.random() * this.field_70131_O - 0.5D) * 0.800000011920929D;
/* 176 */         z = Math.random() * in - (in / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 184 */         EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityZamasu_Fused3).field_70165_t, ((Entity)entityZamasu_Fused3).field_70163_u, ((Entity)entityZamasu_Fused3).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 93.0F, 3.0F, 177.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)entityZamasu_Fused3);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 189 */         x = Math.random() * in - (in / 2.0F);
/* 190 */         y = (Math.random() * this.field_70131_O - 0.5D) * 0.800000011920929D;
/* 191 */         z = Math.random() * in - (in / 2.0F);
/* 192 */         ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 201 */         EntityCusPar entityCusPar4 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityZamasu_Fused3).field_70165_t, ((Entity)entityZamasu_Fused3).field_70163_u, ((Entity)entityZamasu_Fused3).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 93.0F, 3.0F, 177.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)entityZamasu_Fused3);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 206 */         ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar4);
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
/* 287 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 292 */     Entity var3 = par1DamageSource.func_76346_g();
/* 293 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/* 309 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 312 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 320 */     this.field_70789_a = par1Entity;
/* 321 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 322 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityZamasu_Fused3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */