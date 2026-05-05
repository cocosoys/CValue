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
/*     */ 
/*     */ public class EntitySaiyan02
/*     */   extends EntityDBCEvil
/*     */ {
/*     */   private int randomSoundDelay;
/*     */   private Entity field_110191_bu;
/*  23 */   public final int AttPow = 60;
/*  24 */   public final int HePo = 600;
/*     */ 
/*     */   
/*     */   public EntitySaiyan02(World par1World) {
/*  28 */     super(par1World);
/*     */     
/*  30 */     setEasyDifficulty();
/*     */   }
/*     */   
/*     */   protected void func_110147_ax() {
/*  34 */     super.func_110147_ax();
/*  35 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(600.0D);
/*  36 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(60.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  46 */     return "jinryuudragonbc:npcs/saiyan02.png";
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
/*     */   protected boolean func_70650_aV() {
/*  63 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/*  69 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  77 */     this.field_110191_bu = this.field_70789_a;
/*     */     
/*  79 */     if (this.randomSoundDelay <= 0 || --this.randomSoundDelay == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     super.func_70071_h_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/*  92 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 100 */     super.func_70014_b(par1NBTTagCompound);
/* 101 */     par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 109 */     super.func_70037_a(par1NBTTagCompound);
/* 110 */     this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 119 */     return (this.target != null) ? this.target : ((this.angerLevel == 0) ? null : super.func_70782_k());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 127 */     if (func_85032_ar())
/*     */     {
/* 129 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 133 */     Entity entity = par1DamageSource.func_76346_g();
/*     */     
/* 135 */     if (entity instanceof EntityPlayer) {
/*     */       
/* 137 */       List<Entity> list = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 139 */       for (int i = 0; i < list.size(); i++) {
/*     */         
/* 141 */         Entity entity1 = list.get(i);
/*     */         
/* 143 */         if (entity1 instanceof EntitySaiyan02) {
/*     */           
/* 145 */           EntitySaiyan02 entitypigzombie = (EntitySaiyan02)entity1;
/* 146 */           entitypigzombie.becomeAngryAt(entity);
/*     */         } 
/*     */       } 
/*     */       
/* 150 */       becomeAngryAt(entity);
/*     */     } 
/*     */     
/* 153 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 162 */     this.field_70789_a = par1Entity;
/* 163 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 164 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 174 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntitySaiyan02.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */