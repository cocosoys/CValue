/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCConfig;
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
/*     */ public class EntityHell01
/*     */   extends EntityDBCNeut
/*     */ {
/*  22 */   public int randomSoundDelay = 0;
/*     */   
/*  24 */   public final int AttPow = 500;
/*  25 */   public final int HePo = 2000;
/*     */   
/*     */   public EntityHell01(World par1World) {
/*  28 */     super(par1World);
/*  29 */     if (DBCConfig.NPCOgreDam != 500 || DBCConfig.NPCOgreHP != 2000) {
/*  30 */       getEntityData().func_74780_a("jrmcSpawnInitiatedCAT", DBCConfig.NPCOgreDam);
/*  31 */       getEntityData().func_74780_a("jrmcSpawnInitiatedCHP", DBCConfig.NPCOgreHP);
/*     */     } 
/*  33 */     this.field_70728_aV = 30;
/*  34 */     setEasyDifficulty();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  39 */     super.func_110147_ax();
/*  40 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2000.0D);
/*  41 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(500.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/*  46 */     return true;
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
/*  63 */     if (this.randomSoundDelay <= 0 || --this.randomSoundDelay == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  68 */     super.func_70071_h_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  78 */     return "jinryuudragonbc:npcs/hell01.png";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/*  86 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/*  94 */     super.func_70014_b(par1NBTTagCompound);
/*  95 */     par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 103 */     super.func_70037_a(par1NBTTagCompound);
/* 104 */     this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 113 */     return (this.angerLevel == 0) ? null : super.func_70782_k();
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
/* 153 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 161 */     if (func_85032_ar())
/*     */     {
/* 163 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 167 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 169 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 171 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 173 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 175 */         Entity var6 = var4.get(var5);
/*     */         
/* 177 */         if (var6 instanceof EntityHell01) {
/*     */           
/* 179 */           EntityHell01 var7 = (EntityHell01)var6;
/* 180 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 184 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 187 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 196 */     this.field_70789_a = par1Entity;
/* 197 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 198 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
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
/*     */   protected void func_70628_a(boolean par1, int par2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 253 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityHell01.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */