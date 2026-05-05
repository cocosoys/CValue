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
/*     */ public class EntityKale2
/*     */   extends EntityDBCEvil
/*     */ {
/*  16 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  18 */   public final int AttPow = 16000;
/*  19 */   public final int HePo = 100000;
/*     */   private int target;
/*     */   
/*     */   public EntityKale2(World par1World) {
/*  23 */     super(par1World);
/*  24 */     this.field_70728_aV = 200;
/*  25 */     this.tex = "kale_ssj";
/*  26 */     func_70105_a(0.65F, 2.5F);
/*  27 */     setData1(1);
/*  28 */     setData2(6);
/*  29 */     setHardDifficulty();
/*  30 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  36 */     super.func_110147_ax();
/*  37 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100000.0D);
/*  38 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(16000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  42 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  45 */     int BP = -2122547200;
/*  46 */     int exp = this.field_70728_aV * 100;
/*  47 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/*  48 */     return BattlePower;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  56 */     if (doBlst()) {
/*  57 */       int r = (int)(Math.random() * 3.0D);
/*  58 */       if (r == 0) {
/*  59 */         setData1(1);
/*  60 */         setData2(6);
/*     */       }
/*  62 */       else if (r == 1) {
/*  63 */         setData1(6);
/*  64 */         setData2(6);
/*     */       } else {
/*     */         
/*  67 */         setData1(5);
/*  68 */         setData2(6);
/*     */       } 
/*     */     } 
/*     */     
/*  72 */     if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
/*  73 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*  74 */         for (int i = 0; i < 5; i++) {
/*  75 */           EntityKale2 entityKale2 = this;
/*     */ 
/*     */           
/*  78 */           float a = 0.5F, h1 = 1.0F;
/*  79 */           float red = 183.0F, green = 205.0F, blue = 97.0F;
/*     */ 
/*     */ 
/*     */           
/*  83 */           float life = 0.8F * ((Entity)entityKale2).field_70131_O;
/*  84 */           float extra_scale = 1.0F + ((((Entity)entityKale2).field_70131_O > 2.1F) ? (((Entity)entityKale2).field_70131_O / 2.0F) : 0.0F) / 5.0F;
/*  85 */           float width = ((Entity)entityKale2).field_70130_N * 3.0F;
/*     */           
/*  87 */           double x = (Math.random() * 1.0D - 0.5D) * (width * 1.2F);
/*  88 */           double y = Math.random() * (this.field_70131_O * 1.4F) - (this.field_70131_O / 2.0F) - 0.30000001192092896D;
/*  89 */           double z = (Math.random() * 1.0D - 0.5D) * (width * 1.2F);
/*     */ 
/*     */ 
/*     */           
/*  93 */           double motx = Math.random() * 0.019999999552965164D - 0.009999999776482582D;
/*  94 */           double moty = (Math.random() * 0.8999999761581421D + 0.8999999761581421D) * (life * extra_scale) * 0.07D;
/*  95 */           double motz = Math.random() * 0.019999999552965164D - 0.009999999776482582D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 105 */           EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", ((Entity)entityKale2).field_70170_p, 0.2F, 0.2F, ((Entity)entityKale2).field_70165_t, ((Entity)entityKale2).field_70163_u + ((entityKale2 instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), ((Entity)entityKale2).field_70161_v, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 3.0D) + 32, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 0.5F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.2F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.08F, false, -1, true, (Entity)entityKale2);
/*     */ 
/*     */ 
/*     */           
/* 109 */           ((Entity)entityKale2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 119 */           EntityCusPar entityCusPar1 = new EntityCusPar("jinryuudragonbc:bens_particles.png", ((Entity)entityKale2).field_70170_p, 0.2F, 0.2F, ((Entity)entityKale2).field_70165_t, ((Entity)entityKale2).field_70163_u + ((entityKale2 instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), ((Entity)entityKale2).field_70161_v, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 0.5F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.1F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.08F, false, -1, true, (Entity)entityKale2);
/*     */ 
/*     */ 
/*     */           
/* 123 */           ((Entity)entityKale2).field_70170_p.func_72838_d((Entity)entityCusPar1);
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
/* 145 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 150 */     Entity var3 = par1DamageSource.func_76346_g();
/* 151 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/* 167 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 170 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 178 */     this.field_70789_a = par1Entity;
/* 179 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 180 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityKale2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */