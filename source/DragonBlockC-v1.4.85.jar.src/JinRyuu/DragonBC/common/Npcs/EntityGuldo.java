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
/*     */ public class EntityGuldo
/*     */   extends EntityDBCEvil
/*     */ {
/*  21 */   public int randomSoundDelay = 0;
/*  22 */   public final int AttPow = 80;
/*  23 */   public final int HePo = 400;
/*     */ 
/*     */   
/*     */   public EntityGuldo(World par1World) {
/*  27 */     super(par1World);
/*  28 */     this.field_70728_aV = 10;
/*  29 */     this.angerLevel = 400;
/*  30 */     setMediumDifficulty();
/*  31 */     this.aggressive = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  38 */     return "jinryuudragonbc:npcs/guldo.png";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  43 */     super.func_110147_ax();
/*  44 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(400.0D);
/*  45 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(80.0D);
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
/*     */   public boolean func_70601_bi() {
/*  77 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/*  85 */     super.func_70014_b(par1NBTTagCompound);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/*  94 */     super.func_70037_a(par1NBTTagCompound);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 104 */     return (this.angerLevel == 0) ? null : super.func_70782_k();
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
/* 144 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 152 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 154 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 156 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 158 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 160 */         Entity var6 = var4.get(var5);
/*     */         
/* 162 */         if (var6 instanceof EntityRecoome) {
/*     */           
/* 164 */           EntityRecoome var7 = (EntityRecoome)var6;
/* 165 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 169 */       becomeAngryAt(var3);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 174 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 181 */     if (func_85032_ar())
/*     */     {
/* 183 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 187 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 189 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 191 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 193 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 195 */         Entity var6 = var4.get(var5);
/*     */         
/* 197 */         if (var6 instanceof EntityGuldo) {
/*     */           
/* 199 */           EntityGuldo var7 = (EntityGuldo)var6;
/* 200 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 204 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 207 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 216 */     this.field_70789_a = par1Entity;
/*     */     
/* 218 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
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
/* 252 */     int var3 = this.field_70146_Z.nextInt(1 + par2);
/*     */ 
/*     */     
/*     */     int var4;
/*     */     
/* 257 */     for (var4 = 0; var4 < var3; var4++)
/*     */     {
/* 259 */       func_145779_a(ItemsDBC.BattleArmorHelmet04, 1);
/*     */     }
/*     */     
/* 262 */     var3 = this.field_70146_Z.nextInt(2 + par2);
/*     */     
/* 264 */     for (var4 = 0; var4 < var3; var4++);
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
/* 275 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityGuldo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */