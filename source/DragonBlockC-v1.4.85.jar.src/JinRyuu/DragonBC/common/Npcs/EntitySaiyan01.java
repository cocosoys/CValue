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
/*     */ public class EntitySaiyan01
/*     */   extends EntityDBCEvil
/*     */ {
/*     */   private int randomSoundDelay;
/*  21 */   public final int AttPow = 50;
/*  22 */   public final int HePo = 500;
/*     */ 
/*     */   
/*     */   public EntitySaiyan01(World par1World) {
/*  26 */     super(par1World);
/*     */     
/*  28 */     setEasyDifficulty();
/*     */   }
/*     */   
/*     */   protected void func_110147_ax() {
/*  32 */     super.func_110147_ax();
/*  33 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(500.0D);
/*  34 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(50.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  44 */     return "jinryuudragonbc:npcs/saiyan01.png";
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
/*     */   protected boolean func_70650_aV() {
/*  59 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/*  65 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  75 */     if (this.randomSoundDelay <= 0 || --this.randomSoundDelay == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     super.func_70071_h_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/*  88 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/*  96 */     super.func_70014_b(par1NBTTagCompound);
/*  97 */     par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 105 */     super.func_70037_a(par1NBTTagCompound);
/* 106 */     this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 115 */     return (this.target != null) ? this.target : ((this.angerLevel == 0) ? null : super.func_70782_k());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 123 */     if (func_85032_ar())
/*     */     {
/* 125 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 129 */     Entity entity = par1DamageSource.func_76346_g();
/*     */     
/* 131 */     if (entity instanceof EntityPlayer) {
/*     */       
/* 133 */       List<Entity> list = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 135 */       for (int i = 0; i < list.size(); i++) {
/*     */         
/* 137 */         Entity entity1 = list.get(i);
/*     */         
/* 139 */         if (entity1 instanceof EntitySaiyan01) {
/*     */           
/* 141 */           EntitySaiyan01 entitypigzombie = (EntitySaiyan01)entity1;
/* 142 */           entitypigzombie.becomeAngryAt(entity);
/*     */         } 
/*     */       } 
/*     */       
/* 146 */       becomeAngryAt(entity);
/*     */     } 
/*     */     
/* 149 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 158 */     this.field_70789_a = par1Entity;
/* 159 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 160 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 170 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntitySaiyan01.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */