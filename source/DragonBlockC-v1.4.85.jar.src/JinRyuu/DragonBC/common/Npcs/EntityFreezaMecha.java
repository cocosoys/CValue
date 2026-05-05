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
/*     */ public class EntityFreezaMecha
/*     */   extends EntityDBCEvil
/*     */ {
/*  21 */   public int randomSoundDelay = 0;
/*  22 */   public final int AttPow = 500;
/*  23 */   public final int HePo = 5000;
/*     */   int trans;
/*     */   
/*     */   public EntityFreezaMecha(World par1World) {
/*  27 */     super(par1World);
/*  28 */     this.field_70728_aV = 180;
/*  29 */     setMediumDifficulty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  36 */     return "jinryuudragonbc:npcs/freezam.png";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  41 */     super.func_110147_ax();
/*  42 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5000.0D);
/*  43 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(500.0D);
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
/*  60 */     if (this.randomSoundDelay <= 0 || --this.randomSoundDelay == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     super.func_70071_h_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/*  74 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/*  82 */     super.func_70014_b(par1NBTTagCompound);
/*  83 */     par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/*  91 */     super.func_70037_a(par1NBTTagCompound);
/*  92 */     this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 101 */     return super.func_70782_k();
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
/* 113 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 115 */     if (var3 instanceof EntityPlayer) {
/*     */ 
/*     */ 
/*     */       
/* 119 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 121 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 123 */         Entity var6 = var4.get(var5);
/*     */         
/* 125 */         if (var6 instanceof EntityFreezaFather) {
/*     */           
/* 127 */           EntityFreezaFather var7 = (EntityFreezaFather)var6;
/* 128 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 132 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 135 */     super.func_70645_a(par1DamageSource);
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
/*     */   public void func_70636_d() {
/* 181 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 189 */     if (func_85032_ar())
/*     */     {
/* 191 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 195 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 197 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 199 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 201 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 203 */         Entity var6 = var4.get(var5);
/*     */         
/* 205 */         if (var6 instanceof EntityFreezaMecha) {
/*     */           
/* 207 */           EntityFreezaMecha var7 = (EntityFreezaMecha)var6;
/* 208 */           var7.becomeAngryAt(var3);
/*     */         } 
/* 210 */         if (var6 instanceof EntityFreezaSoldiers) {
/*     */           
/* 212 */           EntityFreezaSoldiers var7 = (EntityFreezaSoldiers)var6;
/* 213 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 217 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 220 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void becomeAngryAt(Entity par1Entity) {
/* 229 */     this.field_70789_a = par1Entity;
/* 230 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 231 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
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
/* 265 */     int var3 = this.field_70146_Z.nextInt(1 + par2);
/*     */ 
/*     */     
/*     */     int var4;
/*     */     
/* 270 */     for (var4 = 0; var4 < var3; var4++)
/*     */     {
/* 272 */       func_145779_a(ItemsDBC.BattleArmorHelmet04, 1);
/*     */     }
/*     */     
/* 275 */     var3 = this.field_70146_Z.nextInt(2 + par2);
/*     */     
/* 277 */     for (var4 = 0; var4 < var3; var4++);
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
/* 288 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityFreezaMecha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */