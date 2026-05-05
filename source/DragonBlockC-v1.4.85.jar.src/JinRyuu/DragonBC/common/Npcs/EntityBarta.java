/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityBarta
/*     */   extends EntityDBCEvil
/*     */ {
/*  23 */   public int randomSoundDelay = 0;
/*     */   
/*  25 */   public final int AttPow = 400;
/*  26 */   public final int HePo = 4000;
/*     */   
/*     */   public EntityBarta(World par1World) {
/*  29 */     super(par1World);
/*  30 */     this.field_70728_aV = 45;
/*  31 */     setMediumDifficulty();
/*  32 */     this.aggressive = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  38 */     super.func_110147_ax();
/*  39 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4000.0D);
/*  40 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(400.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  47 */     return "jinryuudragonbc:npcs/burter.png";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  58 */     if (this.randomSoundDelay <= 0 || --this.randomSoundDelay == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  63 */     super.func_70071_h_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/*  72 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/*  80 */     super.func_70014_b(par1NBTTagCompound);
/*  81 */     par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/*  89 */     super.func_70037_a(par1NBTTagCompound);
/*  90 */     this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/*  99 */     return (this.target != null) ? this.target : ((this.angerLevel == 0) ? null : super.func_70782_k());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 139 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 148 */     if (par1DamageSource instanceof net.minecraft.util.EntityDamageSourceIndirect || par1DamageSource instanceof net.minecraft.util.EntityDamageSource) {
/*     */       
/* 150 */       Entity var3 = par1DamageSource.func_76346_g();
/*     */       
/* 152 */       if (var3 instanceof EntityPlayer) {
/*     */         
/* 154 */         List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */         
/* 156 */         for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */           
/* 158 */           Entity var6 = var4.get(var5);
/*     */           
/* 160 */           if (var6 instanceof EntityGinyu) {
/*     */             
/* 162 */             EntityGinyu var71 = (EntityGinyu)var6;
/* 163 */             var71.becomeAngryAt(var3);
/*     */           } 
/*     */         } 
/*     */         
/* 167 */         becomeAngryAt(var3);
/*     */       } 
/*     */     } 
/* 170 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 177 */     if (func_85032_ar())
/*     */     {
/* 179 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 183 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 185 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 187 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 189 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 191 */         Entity var6 = var4.get(var5);
/*     */         
/* 193 */         if (var6 instanceof EntityBarta) {
/*     */           
/* 195 */           EntityBarta var7 = (EntityBarta)var6;
/* 196 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 200 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 203 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void becomeAngryAt(Entity par1Entity) {
/* 212 */     this.field_70789_a = par1Entity;
/* 213 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 214 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
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
/* 248 */     int var3 = this.field_70146_Z.nextInt(1 + par2);
/*     */ 
/*     */     
/*     */     int var4;
/*     */     
/* 253 */     for (var4 = 0; var4 < var3; var4++)
/*     */     {
/* 255 */       func_145779_a(ItemsDBC.BattleArmorHelmet04, 1);
/*     */     }
/*     */     
/* 258 */     var3 = this.field_70146_Z.nextInt(2 + par2);
/*     */     
/* 260 */     for (var4 = 0; var4 < var3; var4++);
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
/* 271 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityBarta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */