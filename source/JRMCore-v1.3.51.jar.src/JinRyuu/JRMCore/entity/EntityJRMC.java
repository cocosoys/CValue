/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.monster.IMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.EnumSkyBlock;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityJRMC extends EntityCreature implements IMob {
/*     */   protected String texture;
/*  20 */   private double moveSpeed = 0.699D;
/*  21 */   public int rang = 0;
/*     */   
/*  23 */   public int angerLevel = 0;
/*     */   
/*  25 */   private int aggroCooldown = 0;
/*  26 */   public int prevAttackCounter = 0;
/*  27 */   public int attackCounter = 0;
/*  28 */   private Entity targetedEntity = null; public String expValue; @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*     */     return this.texture;
/*     */   } public EntityJRMC(World par1World) {
/*  32 */     super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  49 */     toString(); this.expValue = String.valueOf(BattlePower());
/*     */     this.field_70728_aV = 5;
/*     */     func_94058_c("");
/*     */     func_94061_f(false);
/*     */   } public int func_70693_a(EntityPlayer Player) {
/*  54 */     return this.field_70728_aV;
/*     */   } public long BattlePower() {
/*     */     long BattlePower = this.field_70728_aV;
/*     */     return BattlePower;
/*     */   } protected void func_110147_ax() {
/*  59 */     super.func_110147_ax();
/*  60 */     func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
/*  61 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(MaxHealth());
/*  62 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0D);
/*  63 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.5D);
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
/*     */   protected void func_70088_a() {
/*  75 */     super.func_70088_a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70650_aV()
/*     */   {
/*  81 */     return false; } protected boolean func_70692_ba() {
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/*  86 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAttackStrength(Entity par1Entity) {
/*  91 */     ItemStack var2 = func_70694_bm();
/*  92 */     int var3 = 5;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  99 */     return var3;
/*     */   }
/*     */   public int MaxHealth() {
/* 102 */     return 20;
/*     */   }
/*     */   
/*     */   protected void func_70626_be() {
/* 106 */     super.func_70626_be();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 115 */     func_82168_bl();
/*     */     
/* 117 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(this.moveSpeed);
/* 118 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 123 */     super.func_70071_h_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 132 */     EntityPlayer entityplayer = this.field_70170_p.func_72856_b((Entity)this, 16.0D);
/* 133 */     return (entityplayer != null && func_70685_l((Entity)entityplayer)) ? (Entity)entityplayer : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 141 */     if (func_85032_ar())
/*     */     {
/* 143 */       return false;
/*     */     }
/* 145 */     if (super.func_70097_a(par1DamageSource, par2)) {
/*     */       
/* 147 */       Entity entity = par1DamageSource.func_76346_g();
/*     */       
/* 149 */       if (this.field_70153_n != entity && this.field_70154_o != entity) {
/*     */         
/* 151 */         if (entity != this)
/*     */         {
/* 153 */           this.field_70789_a = entity;
/*     */         }
/*     */         
/* 156 */         return true;
/*     */       } 
/*     */ 
/*     */       
/* 160 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 165 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDBCAttack(Entity par1Entity) {
/* 171 */     ItemStack var2 = func_70694_bm();
/* 172 */     int var3 = 10;
/*     */     
/* 174 */     return var3;
/*     */   }
/*     */   
/*     */   public boolean func_70652_k(Entity par1Entity) {
/* 178 */     float i = getAttackStrength(par1Entity);
/*     */     
/* 180 */     int j = 0;
/*     */     
/* 182 */     if (par1Entity instanceof net.minecraft.entity.EntityLiving) {
/*     */       
/* 184 */       i += EnchantmentHelper.func_77512_a((EntityLivingBase)this, (EntityLivingBase)par1Entity);
/* 185 */       j += EnchantmentHelper.func_77507_b((EntityLivingBase)this, (EntityLivingBase)par1Entity);
/*     */     } 
/*     */     
/* 188 */     boolean flag = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), i);
/*     */     
/* 190 */     if (flag) {
/*     */       
/* 192 */       if (j > 0) {
/*     */         
/* 194 */         par1Entity.func_70024_g((-MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F) * j * 0.5F), 0.1D, (MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F) * j * 0.5F));
/* 195 */         this.field_70159_w *= 0.6D;
/* 196 */         this.field_70179_y *= 0.6D;
/*     */       } 
/*     */       
/* 199 */       int k = EnchantmentHelper.func_90036_a((EntityLivingBase)this);
/*     */       
/* 201 */       if (k > 0)
/*     */       {
/* 203 */         par1Entity.func_70015_d(k * 4);
/*     */       }
/*     */       
/* 206 */       if (par1Entity instanceof net.minecraft.entity.EntityLiving);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 212 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70785_a(Entity par1Entity, float par2) {
/* 220 */     if (this.field_70724_aR <= 0 && par2 < 2.0F && par1Entity.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b && par1Entity.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e) {
/*     */       
/* 222 */       this.field_70724_aR = 20;
/* 223 */       func_70652_k(par1Entity);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_70783_a(int par1, int par2, int par3) {
/* 233 */     return 0.5F - this.field_70170_p.func_72801_o(par1, par2, par3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isValidLightLevel() {
/* 241 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/* 242 */     int j = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/* 243 */     int k = MathHelper.func_76128_c(this.field_70161_v);
/*     */     
/* 245 */     if (this.field_70170_p.func_72972_b(EnumSkyBlock.Sky, i, j, k) > this.field_70146_Z.nextInt(32))
/*     */     {
/* 247 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 251 */     int l = this.field_70170_p.func_72957_l(i, j, k);
/*     */     
/* 253 */     if (this.field_70170_p.func_72911_I()) {
/*     */       
/* 255 */       int i1 = this.field_70170_p.field_73008_k;
/* 256 */       this.field_70170_p.field_73008_k = 10;
/* 257 */       l = this.field_70170_p.func_72957_l(i, j, k);
/* 258 */       this.field_70170_p.field_73008_k = i1;
/*     */     } 
/*     */     
/* 261 */     return (l <= this.field_70146_Z.nextInt(8));
/*     */   }
/*     */   
/*     */   public boolean func_70601_bi() {
/* 265 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntityJRMC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */