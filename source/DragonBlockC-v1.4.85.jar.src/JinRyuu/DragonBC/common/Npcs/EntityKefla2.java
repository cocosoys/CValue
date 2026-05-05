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
/*     */ public class EntityKefla2
/*     */   extends EntityDBCEvil
/*     */ {
/*  16 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  18 */   public final int AttPow = 26000;
/*  19 */   public final int HePo = 140000;
/*     */   private int target;
/*     */   
/*     */   public EntityKefla2(World par1World) {
/*  23 */     super(par1World);
/*  24 */     this.field_70728_aV = 200;
/*  25 */     this.tex = "kefla_ssj";
/*  26 */     func_70105_a(0.6F, 2.0F);
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
/*  37 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(140000.0D);
/*  38 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(26000.0D);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  42 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */   public long BattlePowerOld() {
/*  45 */     int BP = -2144440320;
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
/*  57 */       int r = (int)(Math.random() * 6.0D);
/*  58 */       if (r == 0) {
/*  59 */         setData1(1);
/*  60 */         setData2(6);
/*     */       }
/*  62 */       else if (r == 1) {
/*  63 */         setData1(6);
/*  64 */         setData2(6);
/*     */       }
/*  66 */       else if (r == 2) {
/*  67 */         setData1(5);
/*  68 */         setData2(6);
/*     */       }
/*  70 */       else if (r == 3) {
/*  71 */         setData1(1);
/*  72 */         setData2(4);
/*     */       }
/*  74 */       else if (r == 4) {
/*  75 */         setData1(6);
/*  76 */         setData2(4);
/*     */       } else {
/*     */         
/*  79 */         setData1(5);
/*  80 */         setData2(4);
/*     */       } 
/*     */     } 
/*     */     
/*  84 */     if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
/*  85 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*  86 */         for (int i = 0; i < 5; i++) {
/*  87 */           EntityKefla2 entityKefla2 = this;
/*     */ 
/*     */           
/*  90 */           float a = 0.5F, h1 = 1.0F;
/*  91 */           float red = 183.0F, green = 205.0F, blue = 97.0F;
/*     */ 
/*     */ 
/*     */           
/*  95 */           float life = 0.8F * ((Entity)entityKefla2).field_70131_O;
/*  96 */           float extra_scale = 1.0F + ((((Entity)entityKefla2).field_70131_O > 2.1F) ? (((Entity)entityKefla2).field_70131_O / 2.0F) : 0.0F) / 5.0F;
/*  97 */           float width = ((Entity)entityKefla2).field_70130_N * 3.0F;
/*     */           
/*  99 */           double x = (Math.random() * 1.0D - 0.5D) * (width * 1.2F);
/* 100 */           double y = Math.random() * (this.field_70131_O * 1.4F) - (this.field_70131_O / 2.0F) - 0.30000001192092896D;
/* 101 */           double z = (Math.random() * 1.0D - 0.5D) * (width * 1.2F);
/*     */ 
/*     */ 
/*     */           
/* 105 */           double motx = Math.random() * 0.019999999552965164D - 0.009999999776482582D;
/* 106 */           double moty = (Math.random() * 0.8999999761581421D + 0.8999999761581421D) * (life * extra_scale) * 0.07D;
/* 107 */           double motz = Math.random() * 0.019999999552965164D - 0.009999999776482582D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 117 */           EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", ((Entity)entityKefla2).field_70170_p, 0.2F, 0.2F, ((Entity)entityKefla2).field_70165_t, ((Entity)entityKefla2).field_70163_u + ((entityKefla2 instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), ((Entity)entityKefla2).field_70161_v, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 3.0D) + 32, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 0.5F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.2F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.08F, false, -1, true, (Entity)entityKefla2);
/*     */ 
/*     */ 
/*     */           
/* 121 */           ((Entity)entityKefla2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 131 */           EntityCusPar entityCusPar1 = new EntityCusPar("jinryuudragonbc:bens_particles.png", ((Entity)entityKefla2).field_70170_p, 0.2F, 0.2F, ((Entity)entityKefla2).field_70165_t, ((Entity)entityKefla2).field_70163_u + ((entityKefla2 instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), ((Entity)entityKefla2).field_70161_v, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 0.5F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.1F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.08F, false, -1, true, (Entity)entityKefla2);
/*     */ 
/*     */ 
/*     */           
/* 135 */           ((Entity)entityKefla2).field_70170_p.func_72838_d((Entity)entityCusPar1);
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
/* 157 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 162 */     Entity var3 = par1DamageSource.func_76346_g();
/* 163 */     if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
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
/* 179 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 182 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 190 */     this.field_70789_a = par1Entity;
/* 191 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 192 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityKefla2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */