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
/*     */ public class EntitySaiyanVegeta
/*     */   extends EntityDBCEvil
/*     */ {
/*  21 */   public int randomSoundDelay = 0;
/*  22 */   public final int AttPow = 40;
/*  23 */   public final int HePo = 400;
/*     */ 
/*     */   
/*     */   public EntitySaiyanVegeta(World par1World) {
/*  27 */     super(par1World);
/*  28 */     this.field_70728_aV = 80;
/*  29 */     setMediumDifficulty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  35 */     super.func_110147_ax();
/*  36 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(400.0D);
/*  37 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(40.0D);
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
/*  54 */     if (this.randomSoundDelay <= 0 || --this.randomSoundDelay == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     super.func_70071_h_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  71 */     return "jinryuudragonbc:npcs/vegeta.png";
/*     */   }
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
/*     */   public void func_70636_d() {
/* 114 */     if (doBlst()) {
/* 115 */       int r = (int)(Math.random() * 3.0D);
/* 116 */       if (r == 0) {
/* 117 */         setData1(1);
/* 118 */         setData2(0);
/*     */       }
/* 120 */       else if (r == 1) {
/* 121 */         setData1(6);
/* 122 */         setData2(2);
/*     */       } else {
/*     */         
/* 125 */         setData1(5);
/* 126 */         setData2(0);
/*     */       } 
/*     */     } 
/* 129 */     if (this.field_70170_p.func_72826_c(1200.0F) == 1200.0F) {
/* 130 */       EntityNamekian01 c = new EntityNamekian01(this.field_70170_p);
/* 131 */       c.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
/*     */ 
/*     */       
/* 134 */       this.field_70170_p.func_72838_d((Entity)c);
/* 135 */       func_70106_y();
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
/* 170 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 178 */     if (func_85032_ar())
/*     */     {
/* 180 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 184 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 186 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 188 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 190 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 192 */         Entity var6 = var4.get(var5);
/*     */         
/* 194 */         if (var6 instanceof EntitySaiyanVegeta) {
/*     */           
/* 196 */           EntitySaiyanVegeta var7 = (EntitySaiyanVegeta)var6;
/* 197 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 201 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 204 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void becomeAngryAt(Entity par1Entity) {
/* 213 */     this.field_70789_a = par1Entity;
/* 214 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 215 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
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
/* 249 */     int var3 = this.field_70146_Z.nextInt(1 + par2);
/*     */     
/*     */     int var4;
/*     */     
/* 253 */     for (var4 = 0; var4 < var3; var4++)
/*     */     {
/*     */       
/* 256 */       func_145779_a(ItemsDBC.BattleArmorHelmet01, 1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 261 */     var3 = this.field_70146_Z.nextInt(2 + par2);
/*     */     
/* 263 */     for (var4 = 0; var4 < var3; var4++);
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
/* 274 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntitySaiyanVegeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */