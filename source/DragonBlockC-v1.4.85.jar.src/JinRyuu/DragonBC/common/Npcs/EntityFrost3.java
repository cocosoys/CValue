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
/*     */ public class EntityFrost3
/*     */   extends EntityDBCEvil
/*     */ {
/*  20 */   public int randomSoundDelay = 0;
/*  21 */   public final int AttPow = 6800;
/*  22 */   public final int HePo = 44000;
/*     */   
/*     */   int trans;
/*     */   
/*     */   public EntityFrost3(World par1World) {
/*  27 */     super(par1World);
/*     */     
/*  29 */     this.field_70728_aV = 140;
/*  30 */     setData1(3);
/*  31 */     setData2(3);
/*  32 */     setHardDifficulty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  39 */     return "jinryuudragonbc:npcs/frost3.png";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  44 */     super.func_110147_ax();
/*  45 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(44000.0D);
/*  46 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(6800.0D);
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
/*  86 */     par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/*  94 */     super.func_70037_a(par1NBTTagCompound);
/*  95 */     this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 104 */     return (this.target != null) ? this.target : ((this.angerLevel == 0) ? null : super.func_70782_k());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 113 */     if (doBlst()) {
/* 114 */       int r = (int)(Math.random() * 2.0D);
/* 115 */       if (r == 0) {
/* 116 */         setData1(3);
/* 117 */         setData2(3);
/*     */       }
/* 119 */       else if (r == 1) {
/* 120 */         setData1(1);
/* 121 */         setData2(3);
/*     */       } 
/*     */     } 
/*     */     
/* 125 */     this.trans++;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 176 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 184 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 186 */     if (var3 instanceof EntityPlayer)
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
/* 209 */       becomeAngryAt(var3);
/*     */     }
/*     */     
/* 212 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 219 */     if (func_85032_ar())
/*     */     {
/* 221 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 225 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 227 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 229 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 231 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 233 */         Entity var6 = var4.get(var5);
/*     */         
/* 235 */         if (var6 instanceof EntityFrost3) {
/*     */           
/* 237 */           EntityFrost3 var7 = (EntityFrost3)var6;
/* 238 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 242 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 245 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 254 */     this.field_70789_a = par1Entity;
/* 255 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 256 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
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
/* 313 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityFrost3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */