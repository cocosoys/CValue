/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
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
/*     */ public class EntityFreeza1
/*     */   extends EntityDBCEvil
/*     */ {
/*  24 */   public int randomSoundDelay = 0;
/*  25 */   public final int AttPow = 200;
/*  26 */   public final int HePo = 2000;
/*     */   int trans;
/*     */   
/*     */   public EntityFreeza1(World par1World) {
/*  30 */     super(par1World);
/*  31 */     this.field_70728_aV = 100;
/*  32 */     setData1(3);
/*  33 */     setData2(3);
/*  34 */     setMediumDifficulty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  41 */     return "jinryuudragonbc:npcs/freeza1.png";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  46 */     super.func_110147_ax();
/*  47 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2000.0D);
/*  48 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(200.0D);
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
/* 107 */     return (this.target != null) ? this.target : ((this.angerLevel == 0) ? null : super.func_70782_k());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 116 */     if (doBlst()) {
/* 117 */       int r = (int)(Math.random() * 2.0D);
/* 118 */       if (r == 0) {
/* 119 */         setData1(3);
/* 120 */         setData2(3);
/*     */       }
/* 122 */       else if (r == 1) {
/* 123 */         setData1(1);
/* 124 */         setData2(3);
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
/* 136 */     this.trans++;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 187 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 195 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 197 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 199 */       ((EntityPlayer)var3).func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("dbc.itemFreeSagaFre.d.1.line1"), new Object[0])).func_150255_a(JRMCoreH2.styl_wht));
/*     */       
/* 201 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 203 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 205 */         Entity var6 = var4.get(var5);
/*     */         
/* 207 */         if (var6 instanceof EntityBarta) {
/*     */           
/* 209 */           EntityBarta var7 = (EntityBarta)var6;
/* 210 */           var7.becomeAngryAt(var3);
/*     */         } 
/* 212 */         if (var6 instanceof EntityJeice) {
/*     */           
/* 214 */           EntityJeice var71 = (EntityJeice)var6;
/* 215 */           var71.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 219 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 222 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 229 */     if (func_85032_ar())
/*     */     {
/* 231 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 235 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 237 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 239 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 241 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 243 */         Entity var6 = var4.get(var5);
/*     */         
/* 245 */         if (var6 instanceof EntityFreeza1) {
/*     */           
/* 247 */           EntityFreeza1 var7 = (EntityFreeza1)var6;
/* 248 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 252 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 255 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 264 */     this.field_70789_a = par1Entity;
/* 265 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 266 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
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
/* 300 */     int var3 = this.field_70146_Z.nextInt(1 + par2);
/*     */ 
/*     */     
/*     */     int var4;
/*     */     
/* 305 */     for (var4 = 0; var4 < var3; var4++)
/*     */     {
/* 307 */       func_145779_a(ItemsDBC.BattleArmorHelmet04, 1);
/*     */     }
/*     */     
/* 310 */     var3 = this.field_70146_Z.nextInt(2 + par2);
/*     */     
/* 312 */     for (var4 = 0; var4 < var3; var4++);
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
/* 323 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityFreeza1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */