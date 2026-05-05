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
/*     */ public class EntityRecoome
/*     */   extends EntityDBCEvil
/*     */ {
/*  21 */   public int randomSoundDelay = 0;
/*  22 */   public final int AttPow = 160;
/*  23 */   public final int HePo = 1700;
/*     */ 
/*     */   
/*     */   public EntityRecoome(World par1World) {
/*  27 */     super(par1World);
/*  28 */     this.field_70728_aV = 45;
/*  29 */     setMediumDifficulty();
/*  30 */     this.aggressive = false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  35 */     super.func_110147_ax();
/*  36 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1700.0D);
/*  37 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(160.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  43 */     return "jinryuudragonbc:npcs/recoome.png";
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
/*     */   public void func_70636_d() {
/* 143 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 151 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 153 */     if (var3 instanceof EntityPlayer) {
/*     */ 
/*     */       
/* 156 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 158 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 160 */         Entity var6 = var4.get(var5);
/*     */         
/* 162 */         if (var6 instanceof EntityBarta) {
/*     */           
/* 164 */           EntityBarta var7 = (EntityBarta)var6;
/* 165 */           var7.becomeAngryAt(var3);
/*     */         } 
/* 167 */         if (var6 instanceof EntityJeice) {
/*     */           
/* 169 */           EntityJeice var71 = (EntityJeice)var6;
/* 170 */           var71.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 174 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 177 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 184 */     if (func_85032_ar())
/*     */     {
/* 186 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 190 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 192 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 194 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 196 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 198 */         Entity var6 = var4.get(var5);
/*     */         
/* 200 */         if (var6 instanceof EntityRecoome) {
/*     */           
/* 202 */           EntityRecoome var7 = (EntityRecoome)var6;
/* 203 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 207 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 210 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void becomeAngryAt(Entity par1Entity) {
/* 219 */     this.field_70789_a = par1Entity;
/* 220 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 221 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
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
/* 255 */     int var3 = this.field_70146_Z.nextInt(1 + par2);
/*     */ 
/*     */     
/*     */     int var4;
/*     */     
/* 260 */     for (var4 = 0; var4 < var3; var4++)
/*     */     {
/* 262 */       func_145779_a(ItemsDBC.BattleArmorHelmet04, 1);
/*     */     }
/*     */     
/* 265 */     var3 = this.field_70146_Z.nextInt(2 + par2);
/*     */     
/* 267 */     for (var4 = 0; var4 < var3; var4++);
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
/* 278 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityRecoome.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */