/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityDBCNeut
/*     */   extends EntityDBC
/*     */ {
/*     */   public EntityDBCNeut(World par1World) {
/*  18 */     super(par1World);
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
/*     */   protected NBTTagCompound nbt(EntityPlayer p, String s) {
/*     */     NBTTagCompound nbt;
/*  40 */     if (s.contains("pres"))
/*  41 */     { if (!p.getEntityData().func_74764_b("PlayerPersisted")) {
/*  42 */         nbt = new NBTTagCompound();
/*  43 */         p.getEntityData().func_74782_a("PlayerPersisted", (NBTBase)nbt);
/*     */       } else {
/*  45 */         nbt = p.getEntityData().func_74775_l("PlayerPersisted");
/*     */       }  }
/*  47 */     else { nbt = p.getEntityData(); }
/*     */     
/*  49 */     return nbt;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  54 */     super.func_110147_ax();
/*     */     
/*  56 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.699999988079071D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/*  62 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/*  64 */     if (var3 instanceof EntityPlayer) {
/*     */       
/*  66 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/*  68 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/*  70 */         Entity var6 = var4.get(var5);
/*     */         
/*  72 */         if (var6 instanceof EntityDBCNeut) {
/*     */           
/*  74 */           EntityDBCNeut var7 = (EntityDBCNeut)var6;
/*  75 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/*  79 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/*  82 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/*  91 */     super.func_70014_b(par1NBTTagCompound);
/*  92 */     par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 100 */     super.func_70037_a(par1NBTTagCompound);
/* 101 */     this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 110 */     return (this.angerLevel == 0) ? null : super.func_70782_k();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 118 */     if (func_85032_ar())
/*     */     {
/* 120 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 124 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 126 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 128 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 130 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 132 */         Entity var6 = var4.get(var5);
/*     */         
/* 134 */         if (var6 instanceof EntityDBCNeut) {
/*     */           
/* 136 */           EntityDBCNeut var7 = (EntityDBCNeut)var6;
/* 137 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 141 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 144 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 153 */     this.field_70789_a = par1Entity;
/* 154 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityDBCNeut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */