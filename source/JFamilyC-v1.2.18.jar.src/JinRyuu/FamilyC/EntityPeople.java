/*     */ package JinRyuu.FamilyC;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.passive.IAnimals;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class EntityPeople
/*     */   extends EntityTameable
/*     */   implements IAnimals
/*     */ {
/*     */   public int field_70881_d;
/*     */   private int breeding;
/*     */   
/*     */   public EntityPeople(World par1World) {
/*  32 */     super(par1World);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70629_bd() {
/*  40 */     if (func_70874_b() != 0)
/*     */     {
/*  42 */       this.field_70881_d = 0;
/*     */     }
/*     */     
/*  45 */     super.func_70629_bd();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  54 */     super.func_70636_d();
/*     */     
/*  56 */     if (func_70874_b() != 0)
/*     */     {
/*  58 */       this.field_70881_d = 0;
/*     */     }
/*     */     
/*  61 */     if (this.field_70881_d > 0) {
/*     */       
/*  63 */       this.field_70881_d--;
/*  64 */       String s = "heart";
/*     */       
/*  66 */       if (this.field_70881_d % 10 == 0)
/*     */       {
/*  68 */         double d0 = this.field_70146_Z.nextGaussian() * 0.02D;
/*  69 */         double d1 = this.field_70146_Z.nextGaussian() * 0.02D;
/*  70 */         double d2 = this.field_70146_Z.nextGaussian() * 0.02D;
/*  71 */         this.field_70170_p.func_72869_a(s, this.field_70165_t + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, this.field_70163_u + 0.5D + (this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, d0, d1, d2);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  76 */       this.breeding = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70785_a(Entity par1Entity, float par2) {
/*  85 */     if (par1Entity instanceof EntityPlayer) {
/*     */       
/*  87 */       if (par2 < 3.0F) {
/*     */         
/*  89 */         double d0 = par1Entity.field_70165_t - this.field_70165_t;
/*  90 */         double d1 = par1Entity.field_70161_v - this.field_70161_v;
/*  91 */         this.field_70177_z = (float)(Math.atan2(d1, d0) * 180.0D / Math.PI) - 90.0F;
/*  92 */         this.field_70787_b = true;
/*     */       } 
/*     */       
/*  95 */       EntityPlayer entityplayer = (EntityPlayer)par1Entity;
/*     */       
/*  97 */       if (entityplayer.func_71045_bC() == null || !func_70877_b(entityplayer.func_71045_bC()))
/*     */       {
/*  99 */         this.field_70789_a = null;
/*     */       }
/*     */     }
/* 102 */     else if (par1Entity instanceof EntityPeople) {
/*     */       
/* 104 */       EntityPeople entityPeople = (EntityPeople)par1Entity;
/*     */       
/* 106 */       if (func_70874_b() > 0 && entityPeople.func_70874_b() < 0) {
/*     */         
/* 108 */         if (par2 < 2.5D)
/*     */         {
/* 110 */           this.field_70787_b = true;
/*     */         }
/*     */       }
/* 113 */       else if (this.field_70881_d > 0 && entityPeople.field_70881_d > 0) {
/*     */         
/* 115 */         if (entityPeople.field_70789_a == null)
/*     */         {
/* 117 */           entityPeople.field_70789_a = (Entity)this;
/*     */         }
/*     */         
/* 120 */         if (entityPeople.field_70789_a == this && par2 < 3.5D)
/*     */         {
/* 122 */           entityPeople.field_70881_d++;
/* 123 */           this.field_70881_d++;
/* 124 */           this.breeding++;
/*     */           
/* 126 */           if (this.breeding % 4 == 0)
/*     */           {
/* 128 */             this.field_70170_p.func_72869_a("heart", this.field_70165_t + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, this.field_70163_u + 0.5D + (this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, 0.0D, 0.0D, 0.0D);
/*     */           }
/*     */           
/* 131 */           if (this.breeding == 60)
/*     */           {
/* 133 */             procreate((EntityPeople)par1Entity);
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 138 */           this.breeding = 0;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 143 */         this.breeding = 0;
/* 144 */         this.field_70789_a = null;
/*     */       } 
/*     */     } 
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
/*     */   private void procreate(EntityPeople par1EntityPeople) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 187 */     if (func_85032_ar())
/*     */     {
/* 189 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 193 */     this.field_70788_c = 60;
/*     */     
/* 195 */     if (!func_70650_aV()) {
/*     */       
/* 197 */       IAttributeInstance attributeinstance = func_110148_a(SharedMonsterAttributes.field_111263_d);
/*     */       
/* 199 */       if (attributeinstance.func_111127_a(field_110179_h) == null)
/*     */       {
/* 201 */         attributeinstance.func_111121_a(field_110181_i);
/*     */       }
/*     */     } 
/*     */     
/* 205 */     this.field_70789_a = null;
/* 206 */     this.field_70881_d = 0;
/* 207 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_70783_a(int par1, int par2, int par3) {
/* 217 */     return (this.field_70170_p.func_147439_a(par1, par2 - 1, par3) == Blocks.field_150349_c) ? 10.0F : (this.field_70170_p.func_72801_o(par1, par2, par3) - 0.5F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 225 */     super.func_70014_b(par1NBTTagCompound);
/* 226 */     par1NBTTagCompound.func_74768_a("InLove", this.field_70881_d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 234 */     super.func_70037_a(par1NBTTagCompound);
/* 235 */     this.field_70881_d = par1NBTTagCompound.func_74762_e("InLove");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 244 */     if (this.field_70788_c > 0)
/*     */     {
/* 246 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 250 */     float f = 8.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 255 */     if (this.field_70881_d > 0) {
/*     */       
/* 257 */       List<EntityPeople> list = this.field_70170_p.func_72872_a(getClass(), this.field_70121_D.func_72314_b(f, f, f));
/*     */       
/* 259 */       for (int i = 0; i < list.size(); i++)
/*     */       {
/* 261 */         EntityPeople entityPeople = list.get(i);
/*     */         
/* 263 */         if (entityPeople != this && entityPeople.field_70881_d > 0)
/*     */         {
/* 265 */           return (Entity)entityPeople;
/*     */         }
/*     */       }
/*     */     
/* 269 */     } else if (func_70874_b() == 0) {
/*     */       
/* 271 */       List<EntityPlayer> list = this.field_70170_p.func_72872_a(EntityPlayer.class, this.field_70121_D.func_72314_b(f, f, f));
/*     */       
/* 273 */       for (int i = 0; i < list.size(); i++)
/*     */       {
/* 275 */         EntityPlayer entityplayer = list.get(i);
/*     */         
/* 277 */         if (entityplayer.func_71045_bC() != null && func_70877_b(entityplayer.func_71045_bC()))
/*     */         {
/* 279 */           return (Entity)entityplayer;
/*     */         }
/*     */       }
/*     */     
/* 283 */     } else if (func_70874_b() > 0) {
/*     */       
/* 285 */       List<EntityPeople> list = this.field_70170_p.func_72872_a(getClass(), this.field_70121_D.func_72314_b(f, f, f));
/*     */       
/* 287 */       for (int i = 0; i < list.size(); i++) {
/*     */         
/* 289 */         EntityPeople entityPeople = list.get(i);
/*     */         
/* 291 */         if (entityPeople != this && entityPeople.func_70874_b() < 0)
/*     */         {
/* 293 */           return (Entity)entityPeople;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 298 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/* 307 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/* 308 */     int j = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/* 309 */     int k = MathHelper.func_76128_c(this.field_70161_v);
/* 310 */     return (this.field_70170_p.func_147439_a(i, j - 1, k) == Blocks.field_150349_c && this.field_70170_p.func_72883_k(i, j, k) > 8 && super.func_70601_bi());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70627_aG() {
/* 318 */     return 120;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/* 326 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int func_70693_a(EntityPlayer par1EntityPlayer) {
/* 334 */     return 1 + this.field_70170_p.field_73012_v.nextInt(3);
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
/*     */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 351 */     ItemStack itemstack = par1EntityPlayer.field_71071_by.func_70448_g();
/*     */     
/* 353 */     if (itemstack != null && func_70877_b(itemstack) && func_70874_b() == 0 && this.field_70881_d <= 0) {
/*     */       
/* 355 */       if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
/*     */         
/* 357 */         itemstack.field_77994_a--;
/*     */         
/* 359 */         if (itemstack.field_77994_a <= 0)
/*     */         {
/* 361 */           par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
/*     */         }
/*     */       } 
/*     */       
/* 365 */       func_110196_bT();
/* 366 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 370 */     return super.func_70085_c(par1EntityPlayer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_110196_bT() {
/* 376 */     this.field_70881_d = 600;
/* 377 */     this.field_70789_a = null;
/* 378 */     this.field_70170_p.func_72960_a((Entity)this, (byte)18);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70880_s() {
/* 386 */     return (this.field_70881_d > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70875_t() {
/* 391 */     this.field_70881_d = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMateWith(EntityPeople par1EntityPeople) {
/* 399 */     return (par1EntityPeople == this) ? false : ((par1EntityPeople.getClass() != getClass()) ? false : ((func_70880_s() && par1EntityPeople.func_70880_s())));
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70103_a(byte par1) {
/* 405 */     if (par1 == 18) {
/*     */       
/* 407 */       for (int i = 0; i < 7; i++)
/*     */       {
/* 409 */         double d0 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 410 */         double d1 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 411 */         double d2 = this.field_70146_Z.nextGaussian() * 0.02D;
/* 412 */         this.field_70170_p.func_72869_a("heart", this.field_70165_t + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, this.field_70163_u + 0.5D + (this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, d0, d1, d2);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 417 */       super.func_70103_a(par1);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\EntityPeople.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */