/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
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
/*     */ public class EntityFrost6
/*     */   extends EntityDBCEvil
/*     */ {
/*  20 */   public int randomSoundDelay = 0;
/*  21 */   public final int AttPow = 8000;
/*  22 */   public final int HePo = 56000;
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityFrost6(World par1World) {
/*  27 */     super(par1World);
/*     */     
/*  29 */     this.field_70728_aV = 200;
/*  30 */     setData1(3);
/*  31 */     setData2(3);
/*  32 */     this.angerLevel = 400;
/*  33 */     setHardDifficulty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  41 */     return "jinryuudragonbc:npcs/frost6.png";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  46 */     super.func_110147_ax();
/*  47 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(56000.0D);
/*  48 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(8000.0D);
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
/* 107 */     return super.func_70782_k();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 115 */     if (doBlst()) {
/* 116 */       int r = (int)(Math.random() * 3.0D);
/* 117 */       if (r == 0) {
/* 118 */         setData1(3);
/* 119 */         setData2(3);
/*     */       }
/* 121 */       else if (r == 1) {
/* 122 */         setData1(1);
/* 123 */         setData2(3);
/*     */       }
/* 125 */       else if (r == 2) {
/* 126 */         setData1(5);
/* 127 */         setData2(3);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 171 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 173 */     if (var3 instanceof EntityPlayer) {
/*     */ 
/*     */       
/* 176 */       int e = 50;
/* 177 */       if (var3 instanceof EntityPlayer) {
/* 178 */         EntityPlayer player = (EntityPlayer)var3;
/* 179 */         JRMCoreH.expPls(player, e);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 186 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 194 */     if (func_85032_ar())
/*     */     {
/* 196 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 200 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 202 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 204 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 206 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 208 */         Entity var6 = var4.get(var5);
/*     */         
/* 210 */         if (var6 instanceof EntityFrost6) {
/*     */           
/* 212 */           EntityFrost6 var7 = (EntityFrost6)var6;
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
/*     */   void becomeAngryAt(Entity par1Entity) {
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
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 288 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityFrost6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */