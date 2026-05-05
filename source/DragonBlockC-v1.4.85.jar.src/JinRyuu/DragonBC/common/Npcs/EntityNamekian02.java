/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Gui.DBCSAAGui;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreH2;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityNamekian02
/*     */   extends EntityDBCGood
/*     */ {
/*  24 */   public int randomSoundDelay = 0;
/*  25 */   public final int AttPow = 40;
/*  26 */   public final int HePo = 400;
/*     */ 
/*     */   
/*     */   public EntityNamekian02(World par1World) {
/*  30 */     super(par1World);
/*  31 */     this.field_70728_aV = 10;
/*  32 */     setData2(2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  42 */     super.func_110147_ax();
/*  43 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(400.0D);
/*  44 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(40.0D);
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
/*  61 */     if (this.randomSoundDelay <= 0 || --this.randomSoundDelay == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  66 */     super.func_70071_h_();
/*     */   }
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/*  70 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/*  72 */     if (var3 instanceof EntityPlayer) {
/*     */ 
/*     */       
/*  75 */       DBCSAAGui.dbcSAA(var3.func_145782_y(), 10);
/*     */       
/*  77 */       ((EntityPlayer)var3).func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("dbc.moreevil.line1"), new Object[0])).func_150255_a(JRMCoreH2.styl_wht));
/*     */     } 
/*     */ 
/*     */     
/*  81 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  90 */     return "jinryuudragonbc:npcs/namek01.png";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/*  98 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 106 */     super.func_70014_b(par1NBTTagCompound);
/* 107 */     par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 115 */     super.func_70037_a(par1NBTTagCompound);
/* 116 */     this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 125 */     return (this.angerLevel == 0) ? null : super.func_70782_k();
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
/* 165 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 173 */     if (func_85032_ar())
/*     */     {
/* 175 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 179 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 181 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 183 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 185 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 187 */         Entity var6 = var4.get(var5);
/*     */         
/* 189 */         if (var6 instanceof EntityNamekian02) {
/*     */           
/* 191 */           EntityNamekian02 var7 = (EntityNamekian02)var6;
/* 192 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 196 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 199 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 208 */     this.field_70789_a = par1Entity;
/* 209 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 210 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
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
/* 244 */     int var3 = this.field_70146_Z.nextInt(2 + par2);
/*     */ 
/*     */     
/*     */     int var4;
/*     */     
/* 249 */     for (var4 = 0; var4 < var3; var4++);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 254 */     var3 = this.field_70146_Z.nextInt(2 + par2);
/*     */     
/* 256 */     for (var4 = 0; var4 < var3; var4++);
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
/* 267 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityNamekian02.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */