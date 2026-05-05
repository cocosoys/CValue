/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
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
/*     */ public class EntityFrost5
/*     */   extends EntityDBCEvil
/*     */ {
/*  20 */   public int randomSoundDelay = 0;
/*  21 */   public final int AttPow = 7600;
/*  22 */   public final int HePo = 52000;
/*     */   
/*     */   int trans;
/*     */   
/*     */   public EntityFrost5(World par1World) {
/*  27 */     super(par1World);
/*     */     
/*  29 */     this.field_70728_aV = 180;
/*  30 */     setData1(3);
/*  31 */     setData2(3);
/*  32 */     setHardDifficulty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  39 */     return "jinryuudragonbc:npcs/frost5.png";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  44 */     super.func_110147_ax();
/*  45 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(52000.0D);
/*  46 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(7600.0D);
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
/*  65 */     if (this.randomSoundDelay <= 0 || --this.randomSoundDelay == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     super.func_70071_h_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/*  79 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/*  87 */     super.func_70014_b(par1NBTTagCompound);
/*  88 */     par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/*  96 */     super.func_70037_a(par1NBTTagCompound);
/*  97 */     this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 106 */     return (this.target != null) ? this.target : ((this.angerLevel == 0) ? null : super.func_70782_k());
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
/* 118 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 120 */     if (var3 instanceof EntityPlayer)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 143 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 146 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 151 */     if (doBlst()) {
/* 152 */       int r = (int)(Math.random() * 3.0D);
/* 153 */       if (r == 0) {
/* 154 */         setData1(3);
/* 155 */         setData2(3);
/*     */       }
/* 157 */       else if (r == 1) {
/* 158 */         setData1(1);
/* 159 */         setData2(3);
/*     */       }
/* 161 */       else if (r == 2) {
/* 162 */         setData1(5);
/* 163 */         setData2(3);
/*     */       } 
/*     */     } 
/*     */     
/* 167 */     this.trans++;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 218 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 226 */     if (func_85032_ar())
/*     */     {
/* 228 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 232 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 234 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 236 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 238 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 240 */         Entity var6 = var4.get(var5);
/*     */         
/* 242 */         if (var6 instanceof EntityFrost5) {
/*     */           
/* 244 */           EntityFrost5 var7 = (EntityFrost5)var6;
/* 245 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 249 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 252 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 261 */     this.field_70789_a = par1Entity;
/* 262 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 263 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
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
/* 320 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityFrost5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */