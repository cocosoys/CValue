/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.EnumSkyBlock;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityNPC
/*     */   extends EntityCreature
/*     */ {
/*     */   protected String texture;
/*  25 */   protected String type = "6";
/*  26 */   protected int dam = 0; public String expValue; public int angerLevel; private int aggroCooldown; public int prevAttackCounter;
/*     */   public int attackCounter;
/*     */   private Entity targetedEntity;
/*     */   
/*  30 */   public EntityNPC(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     toString(); this.expValue = String.valueOf(BattlePower());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     this.angerLevel = 0;
/*     */     
/*  98 */     this.aggroCooldown = 0;
/*  99 */     this.prevAttackCounter = 0;
/* 100 */     this.attackCounter = 0;
/* 101 */     this.targetedEntity = null;
/*     */     this.field_70728_aV = 5; }
/*     */   @SideOnly(Side.CLIENT) public String getTexture() { return this.texture; }
/* 104 */   public ResourceLocation getResource() { return null; } protected void func_70626_be() { if (this.angerLevel > 0) {
/* 105 */       this.field_70143_R = 0.0F;
/*     */       
/* 107 */       this.prevAttackCounter = this.attackCounter;
/*     */ 
/*     */       
/* 110 */       if (this.targetedEntity != null && this.targetedEntity.field_70128_L) {
/*     */         
/* 112 */         this.targetedEntity = null;
/* 113 */         super.func_70626_be();
/*     */       } 
/*     */       
/* 116 */       if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
/*     */         
/* 118 */         this.targetedEntity = (Entity)this.field_70170_p.func_72856_b((Entity)this, 100.0D);
/* 119 */         super.func_70626_be();
/* 120 */         if (this.targetedEntity != null)
/*     */         {
/* 122 */           this.aggroCooldown = 20;
/*     */         }
/*     */       } 
/*     */       
/* 126 */       double d4 = 64.0D;
/*     */       
/* 128 */       if (this.targetedEntity != null && this.targetedEntity.func_70068_e((Entity)this) < d4 * d4)
/*     */       {
/* 130 */         double d5 = this.targetedEntity.field_70165_t - this.field_70165_t;
/* 131 */         double d6 = this.targetedEntity.field_70121_D.field_72338_b + (this.targetedEntity.field_70131_O / 2.0F) - this.field_70163_u + (this.field_70131_O / 2.0F);
/* 132 */         double d7 = this.targetedEntity.field_70161_v - this.field_70161_v;
/* 133 */         this.field_70761_aq = this.field_70177_z = -((float)Math.atan2(d5, d7)) * 180.0F / 3.1415927F;
/*     */         
/* 135 */         if (func_70685_l(this.targetedEntity)) {
/*     */           
/* 137 */           this.attackCounter++;
/*     */           
/* 139 */           if (this.attackCounter == 80) {
/*     */             
/* 141 */             int t = Integer.parseInt(this.type);
/* 142 */             if (t == 6)
/*     */             {
/*     */ 
/*     */               
/* 146 */               byte type = 1;
/* 147 */               byte speed = 1;
/* 148 */               byte effect = 0;
/* 149 */               byte color = 0;
/* 150 */               byte density = 1;
/* 151 */               byte sincantation = 4;
/* 152 */               byte sfire = 0;
/* 153 */               byte smove = 3;
/* 154 */               int dmg1 = this.dam;
/* 155 */               int cst = this.dam / 2;
/*     */ 
/*     */ 
/*     */               
/* 159 */               Entity entityball = new EntityEnergyAttJ((EntityLivingBase)this, type, speed, this.dam, effect, color, density, sincantation, sfire, smove, (byte)-1, dmg1, cst, 5);
/* 160 */               double d8 = 0.5D;
/* 161 */               Vec3 vec3 = func_70676_i(1.0F);
/* 162 */               entityball.field_70165_t = this.field_70165_t + vec3.field_72450_a * d8;
/* 163 */               entityball.field_70163_u = this.field_70163_u + (this.field_70131_O / 2.0F) + 0.5D;
/* 164 */               entityball.field_70161_v = this.field_70161_v + vec3.field_72449_c * d8;
/* 165 */               this.field_70170_p.func_72838_d(entityball);
/* 166 */               this.attackCounter = -40;
/*     */             }
/*     */           
/*     */           } 
/* 170 */         } else if (this.attackCounter > 0) {
/*     */           
/* 172 */           this.attackCounter--;
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 177 */       else if (this.attackCounter > 0)
/*     */       {
/* 179 */         this.attackCounter--;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 184 */       super.func_70626_be();
/*     */     }  }
/*     */   protected void func_110147_ax() { super.func_110147_ax();
/*     */     func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
/*     */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(MaxHealth());
/*     */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0D);
/*     */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5D); }
/*     */   public int BattlePower() { int BattlePower = this.field_70728_aV;
/*     */     return BattlePower; }
/*     */   public int func_70693_a(EntityPlayer par1EntityPlayer) { return this.field_70728_aV; }
/* 194 */   protected boolean func_70692_ba() { return true; } public void func_70636_d() { func_82168_bl();
/* 195 */     super.func_70636_d(); } public void func_70645_a(DamageSource par1DamageSource) { Entity var3 = par1DamageSource.func_76346_g(); if (var3 instanceof EntityPlayer) {
/*     */       int e = 1; if (var3 instanceof EntityPlayer) {
/*     */         EntityPlayer player = (EntityPlayer)var3; JRMCoreH.expPls(player, e);
/*     */       } 
/*     */     }  super.func_70645_a(par1DamageSource); }
/*     */   public int getAttackStrength(Entity par1Entity) { ItemStack var2 = func_70694_bm(); int var3 = 5;
/*     */     return var3; }
/*     */   public int MaxHealth() { return 20; }
/* 203 */   public void func_70071_h_() { if (this.targetedEntity == null || func_70685_l(this.targetedEntity));
/* 204 */     super.func_70071_h_(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 214 */     EntityPlayer entityplayer = this.field_70170_p.func_72856_b((Entity)this, 16.0D);
/* 215 */     return (entityplayer != null && func_70685_l((Entity)entityplayer)) ? (Entity)entityplayer : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 223 */     if (func_85032_ar())
/*     */     {
/* 225 */       return false;
/*     */     }
/* 227 */     if (super.func_70097_a(par1DamageSource, par2)) {
/*     */       
/* 229 */       Entity entity = par1DamageSource.func_76346_g();
/*     */       
/* 231 */       if (this.field_70153_n != entity && this.field_70154_o != entity) {
/*     */         
/* 233 */         if (entity != this)
/*     */         {
/* 235 */           this.field_70789_a = entity;
/*     */         }
/*     */         
/* 238 */         return true;
/*     */       } 
/*     */ 
/*     */       
/* 242 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 247 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDBCAttack(Entity par1Entity) {
/* 253 */     ItemStack var2 = func_70694_bm();
/* 254 */     int var3 = 10;
/*     */     
/* 256 */     return var3;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70652_k(Entity par1Entity) {
/* 261 */     int i = getAttackStrength(par1Entity);
/*     */ 
/*     */     
/* 264 */     if (func_70644_a(Potion.field_76420_g))
/*     */     {
/* 266 */       i += 3 << func_70660_b(Potion.field_76420_g).func_76458_c();
/*     */     }
/*     */     
/* 269 */     if (func_70644_a(Potion.field_76437_t))
/*     */     {
/* 271 */       i -= 2 << func_70660_b(Potion.field_76437_t).func_76458_c();
/*     */     }
/*     */     
/* 274 */     int j = 0;
/*     */     
/* 276 */     if (par1Entity instanceof net.minecraft.entity.EntityLiving) {
/*     */       
/* 278 */       i = (int)(i + EnchantmentHelper.func_77512_a((EntityLivingBase)this, (EntityLivingBase)par1Entity));
/* 279 */       j += EnchantmentHelper.func_77507_b((EntityLivingBase)this, (EntityLivingBase)par1Entity);
/*     */     } 
/*     */     
/* 282 */     boolean flag = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), i);
/*     */     
/* 284 */     if (flag) {
/*     */       
/* 286 */       if (j > 0) {
/*     */         
/* 288 */         par1Entity.func_70024_g((-MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F) * j * 0.5F), 0.1D, (MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F) * j * 0.5F));
/* 289 */         this.field_70159_w *= 0.6D;
/* 290 */         this.field_70179_y *= 0.6D;
/*     */       } 
/*     */       
/* 293 */       int k = EnchantmentHelper.func_90036_a((EntityLivingBase)this);
/*     */       
/* 295 */       if (k > 0)
/*     */       {
/* 297 */         par1Entity.func_70015_d(k * 4);
/*     */       }
/*     */     } 
/*     */     
/* 301 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70785_a(Entity par1Entity, float par2) {
/* 309 */     if (this.field_70724_aR <= 0 && par2 < 2.0F && par1Entity.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b && par1Entity.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e) {
/*     */       
/* 311 */       this.field_70724_aR = 20;
/* 312 */       func_70652_k(par1Entity);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_70783_a(int par1, int par2, int par3) {
/* 322 */     return 0.5F - this.field_70170_p.func_72801_o(par1, par2, par3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isValidLightLevel() {
/* 330 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/* 331 */     int j = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/* 332 */     int k = MathHelper.func_76128_c(this.field_70161_v);
/*     */     
/* 334 */     if (this.field_70170_p.func_72972_b(EnumSkyBlock.Sky, i, j, k) > this.field_70146_Z.nextInt(32))
/*     */     {
/* 336 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 340 */     int l = this.field_70170_p.func_72957_l(i, j, k);
/*     */     
/* 342 */     if (this.field_70170_p.func_72911_I()) {
/*     */       
/* 344 */       int i1 = this.field_70170_p.field_73008_k;
/* 345 */       this.field_70170_p.field_73008_k = 10;
/* 346 */       l = this.field_70170_p.func_72957_l(i, j, k);
/* 347 */       this.field_70170_p.field_73008_k = i1;
/*     */     } 
/*     */     
/* 350 */     return (l <= this.field_70146_Z.nextInt(8));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/* 359 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntityNPC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */