/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.entity.EntityCusPar;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityFreeza7
/*     */   extends EntityDBCEvil
/*     */ {
/*  22 */   public int randomSoundDelay = 0;
/*  23 */   public final int AttPow = 12000;
/*  24 */   public final int HePo = 90000;
/*     */   int trans;
/*     */   
/*     */   public EntityFreeza7(World par1World) {
/*  28 */     super(par1World);
/*  29 */     this.field_70728_aV = 300;
/*  30 */     setData1(3);
/*  31 */     setData2(3);
/*  32 */     setHardDifficulty();
/*  33 */     addAAiTeleport();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  40 */     return "jinryuudragonbc:npcs/freeza7.png";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  45 */     super.func_110147_ax();
/*  46 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(90000.0D);
/*  47 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(12000.0D);
/*     */   }
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
/*     */   public void func_70071_h_() {
/*  66 */     if (this.randomSoundDelay <= 0 || --this.randomSoundDelay == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  71 */     super.func_70071_h_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/*  80 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/*  88 */     super.func_70014_b(par1NBTTagCompound);
/*  89 */     par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/*  97 */     super.func_70037_a(par1NBTTagCompound);
/*  98 */     this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 107 */     return (this.target != null) ? this.target : ((this.angerLevel == 0) ? null : super.func_70782_k());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 119 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 121 */     if (var3 instanceof EntityPlayer)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 144 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 147 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 156 */     if (doBlst()) {
/* 157 */       int r = (int)(Math.random() * 4.0D);
/* 158 */       if (r == 0) {
/* 159 */         setData1(3);
/* 160 */         setData2(3);
/*     */       }
/* 162 */       else if (r == 1) {
/* 163 */         setData1(1);
/* 164 */         setData2(3);
/*     */       }
/* 166 */       else if (r == 2) {
/* 167 */         setData1(5);
/* 168 */         setData2(3);
/*     */       }
/* 170 */       else if (r == 3) {
/* 171 */         setData1(6);
/* 172 */         setData2(0);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 178 */     if (this.field_70170_p.field_72995_K && JGConfigClientSettings.CLIENT_DA8) {
/* 179 */       float red = 249.0F, green = 212.0F, blue = 33.0F;
/* 180 */       float red2 = 234.0F, green2 = 134.0F, blue2 = 34.0F;
/* 181 */       float out = 1.6F;
/* 182 */       float in = 1.0F;
/* 183 */       float life = 0.8F * this.field_70131_O;
/* 184 */       float extra_scale = 0.5F;
/* 185 */       int dea = 50;
/*     */       
/* 187 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/* 188 */         int i; for (i = 0; i < 2; i++) {
/* 189 */           EntityFreeza7 entityFreeza71 = this;
/*     */           
/* 191 */           double d1 = Math.random() * out - (out / 2.0F);
/* 192 */           double d2 = Math.random() * this.field_70131_O - 0.5D;
/* 193 */           double d3 = Math.random() * out - (out / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 201 */           EntityCusPar entityCusPar3 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityFreeza71).field_70165_t, ((Entity)entityFreeza71).field_70163_u, ((Entity)entityFreeza71).field_70161_v, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 249.0F, 212.0F, 33.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 206 */           d1 = Math.random() * out - (out / 2.0F);
/* 207 */           d2 = Math.random() * this.field_70131_O - 0.5D;
/* 208 */           d3 = Math.random() * out - (out / 2.0F);
/* 209 */           ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 218 */           EntityCusPar entityCusPar4 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityFreeza71).field_70165_t, ((Entity)entityFreeza71).field_70163_u, ((Entity)entityFreeza71).field_70161_v, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 249.0F, 212.0F, 33.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 223 */           ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar4);
/*     */         } 
/* 225 */         for (i = 0; i < 2; i++) {
/* 226 */           EntityFreeza7 entityFreeza71 = this;
/*     */           
/* 228 */           out *= 1.3F;
/* 229 */           double d1 = Math.random() * out - (out / 2.0F);
/* 230 */           double d2 = Math.random() * this.field_70131_O - 0.5D;
/* 231 */           double d3 = Math.random() * out - (out / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 239 */           EntityCusPar entityCusPar3 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityFreeza71).field_70165_t, ((Entity)entityFreeza71).field_70163_u, ((Entity)entityFreeza71).field_70161_v, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 234.0F, 134.0F, 34.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 244 */           d1 = Math.random() * out - (out / 2.0F);
/* 245 */           d2 = Math.random() * this.field_70131_O - 0.5D;
/* 246 */           d3 = Math.random() * out - (out / 2.0F);
/* 247 */           ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 256 */           EntityCusPar entityCusPar4 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityFreeza71).field_70165_t, ((Entity)entityFreeza71).field_70163_u, ((Entity)entityFreeza71).field_70161_v, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 234.0F, 134.0F, 34.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 261 */           ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar4);
/*     */         } 
/*     */         
/* 264 */         EntityFreeza7 entityFreeza7 = this;
/*     */         
/* 266 */         double x = Math.random() * 1.0D - 0.5D;
/* 267 */         double y = (Math.random() * this.field_70131_O - 0.5D) * 0.800000011920929D;
/* 268 */         double z = Math.random() * 1.0D - 0.5D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 276 */         EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityFreeza7).field_70165_t, ((Entity)entityFreeza7).field_70163_u, ((Entity)entityFreeza7).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 255.0F, 255.0F, 208.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 281 */         x = Math.random() * 1.0D - 0.5D;
/* 282 */         y = (Math.random() * this.field_70131_O - 0.5D) * 0.800000011920929D;
/* 283 */         z = Math.random() * 1.0D - 0.5D;
/* 284 */         ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 293 */         EntityCusPar entityCusPar2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityFreeza7).field_70165_t, ((Entity)entityFreeza7).field_70163_u, ((Entity)entityFreeza7).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 255.0F, 255.0F, 208.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, false, (Entity)this);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 298 */         ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 303 */     this.trans++;
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
/* 371 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 379 */     if (func_85032_ar())
/*     */     {
/* 381 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 385 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 387 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 389 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 391 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 393 */         Entity var6 = var4.get(var5);
/*     */         
/* 395 */         if (var6 instanceof EntityFreeza7) {
/*     */           
/* 397 */           EntityFreeza7 var7 = (EntityFreeza7)var6;
/* 398 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 402 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 405 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 414 */     this.field_70789_a = par1Entity;
/* 415 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 416 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
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
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 450 */     int var3 = this.field_70146_Z.nextInt(1 + par2);
/*     */ 
/*     */     
/*     */     int var4;
/*     */     
/* 455 */     for (var4 = 0; var4 < var3; var4++)
/*     */     {
/* 457 */       func_145779_a(ItemsDBC.BattleArmorHelmet04, 1);
/*     */     }
/*     */     
/* 460 */     var3 = this.field_70146_Z.nextInt(2 + par2);
/*     */     
/* 462 */     for (var4 = 0; var4 < var3; var4++);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 473 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityFreeza7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */