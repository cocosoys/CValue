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
/*     */ public class EntityCabbaSSJ
/*     */   extends EntityDBCEvil
/*     */ {
/*  16 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  18 */   public final int AttPow = 20000;
/*  19 */   public final int HePo = 200000;
/*     */   private int target;
/*     */   
/*     */   public EntityCabbaSSJ(World par1World) {
/*  23 */     super(par1World);
/*  24 */     this.field_70728_aV = 200;
/*  25 */     this.tex = "cabbaSSJ";
/*  26 */     func_70105_a(0.6F, 2.0F);
/*  27 */     setHardDifficulty();
/*  28 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  34 */     super.func_110147_ax();
/*  35 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200000.0D);
/*  36 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(20000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  40 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  43 */     int BP = 1136082944;
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
/*  54 */     if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
/*  55 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*  56 */         for (int i = 0; i < 5; i++) {
/*  57 */           EntityCabbaSSJ entityCabbaSSJ = this;
/*     */ 
/*     */           
/*  60 */           float a = 0.5F, h1 = 1.0F;
/*  61 */           float red = 255.0F, green = 217.0F, blue = 25.0F;
/*     */ 
/*     */           
/*  64 */           float life = 0.8F * ((Entity)entityCabbaSSJ).field_70131_O;
/*  65 */           float extra_scale = 1.0F + ((((Entity)entityCabbaSSJ).field_70131_O > 2.1F) ? (((Entity)entityCabbaSSJ).field_70131_O / 2.0F) : 0.0F) / 5.0F;
/*  66 */           float width = ((Entity)entityCabbaSSJ).field_70130_N * 3.0F;
/*     */           
/*  68 */           double x = (Math.random() * 1.0D - 0.5D) * (width * 1.2F);
/*  69 */           double y = Math.random() * (this.field_70131_O * 1.4F) - (this.field_70131_O / 2.0F) - 0.30000001192092896D;
/*  70 */           double z = (Math.random() * 1.0D - 0.5D) * (width * 1.2F);
/*     */ 
/*     */ 
/*     */           
/*  74 */           double motx = Math.random() * 0.019999999552965164D - 0.009999999776482582D;
/*  75 */           double moty = (Math.random() * 0.8999999761581421D + 0.8999999761581421D) * (life * extra_scale) * 0.07D;
/*  76 */           double motz = Math.random() * 0.019999999552965164D - 0.009999999776482582D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  86 */           EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", ((Entity)entityCabbaSSJ).field_70170_p, 0.2F, 0.2F, ((Entity)entityCabbaSSJ).field_70165_t, ((Entity)entityCabbaSSJ).field_70163_u + ((entityCabbaSSJ instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), ((Entity)entityCabbaSSJ).field_70161_v, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 3.0D) + 32, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 0.5F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.2F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.08F, false, -1, true, (Entity)entityCabbaSSJ);
/*     */ 
/*     */ 
/*     */           
/*  90 */           ((Entity)entityCabbaSSJ).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 100 */           EntityCusPar entityCusPar1 = new EntityCusPar("jinryuudragonbc:bens_particles.png", ((Entity)entityCabbaSSJ).field_70170_p, 0.2F, 0.2F, ((Entity)entityCabbaSSJ).field_70165_t, ((Entity)entityCabbaSSJ).field_70163_u + ((entityCabbaSSJ instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), ((Entity)entityCabbaSSJ).field_70161_v, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 0.5F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.1F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.08F, false, -1, true, (Entity)entityCabbaSSJ);
/*     */ 
/*     */ 
/*     */           
/* 104 */           ((Entity)entityCabbaSSJ).field_70170_p.func_72838_d((Entity)entityCusPar1);
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


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityCabbaSSJ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */