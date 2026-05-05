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
/*     */ public class EntityFreezaFather
/*     */   extends EntityDBCEvil
/*     */ {
/*  21 */   public int randomSoundDelay = 0;
/*  22 */   public final int AttPow = 440;
/*  23 */   public final int HePo = 4400;
/*     */   int trans;
/*     */   
/*     */   public EntityFreezaFather(World par1World) {
/*  27 */     super(par1World);
/*  28 */     this.field_70728_aV = 120;
/*  29 */     this.field_70130_N = 2.0F;
/*  30 */     this.field_70131_O = 4.0F;
/*  31 */     setMediumDifficulty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  38 */     return "jinryuudragonbc:npcs/kcold.png";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  43 */     super.func_110147_ax();
/*  44 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4400.0D);
/*  45 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(440.0D);
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
/*     */   public void func_70071_h_() {
/*  62 */     if (this.randomSoundDelay <= 0 || --this.randomSoundDelay == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  67 */     super.func_70071_h_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/*  76 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/*  84 */     super.func_70014_b(par1NBTTagCompound);
/*  85 */     par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/*  93 */     super.func_70037_a(par1NBTTagCompound);
/*  94 */     this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 103 */     return (this.target != null) ? this.target : ((this.angerLevel == 0) ? null : super.func_70782_k());
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
/*     */ 
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
/* 153 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 161 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 163 */     if (var3 instanceof EntityPlayer) {
/*     */ 
/*     */ 
/*     */       
/* 167 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 169 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 171 */         Entity var6 = var4.get(var5);
/*     */         
/* 173 */         if (var6 instanceof EntityFreezaFather) {
/*     */           
/* 175 */           EntityFreezaFather var7 = (EntityFreezaFather)var6;
/* 176 */           var7.becomeAngryAt(var3);
/*     */         } 
/* 178 */         if (var6 instanceof EntityFreezaSoldier1) ((EntityFreezaSoldier1)var6).becomeAngryAt(var3); 
/* 179 */         if (var6 instanceof EntityFreezaSoldier2) ((EntityFreezaSoldier2)var6).becomeAngryAt(var3); 
/* 180 */         if (var6 instanceof EntityFreezaSoldier3) ((EntityFreezaSoldier3)var6).becomeAngryAt(var3);
/*     */       
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 189 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 192 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 199 */     if (func_85032_ar())
/*     */     {
/* 201 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 205 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 207 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 209 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 211 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 213 */         Entity var6 = var4.get(var5);
/*     */         
/* 215 */         if (var6 instanceof EntityFreezaFather) {
/*     */           
/* 217 */           EntityFreezaFather var7 = (EntityFreezaFather)var6;
/* 218 */           var7.becomeAngryAt(var3);
/*     */         } 
/* 220 */         if (var6 instanceof EntityFreezaSoldiers) {
/*     */           
/* 222 */           EntityFreezaSoldiers var7 = (EntityFreezaSoldiers)var6;
/* 223 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/* 226 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 229 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void becomeAngryAt(Entity par1Entity) {
/* 238 */     this.field_70789_a = par1Entity;
/* 239 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 240 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
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
/* 274 */     int var3 = this.field_70146_Z.nextInt(1 + par2);
/*     */ 
/*     */     
/*     */     int var4;
/*     */     
/* 279 */     for (var4 = 0; var4 < var3; var4++)
/*     */     {
/* 281 */       func_145779_a(ItemsDBC.BattleArmorHelmet04, 1);
/*     */     }
/*     */     
/* 284 */     var3 = this.field_70146_Z.nextInt(2 + par2);
/*     */     
/* 286 */     for (var4 = 0; var4 < var3; var4++);
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
/* 297 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityFreezaFather.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */