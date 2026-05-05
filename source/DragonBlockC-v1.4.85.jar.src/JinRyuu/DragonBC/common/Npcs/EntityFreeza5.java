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
/*     */ public class EntityFreeza5
/*     */   extends EntityDBCEvil
/*     */ {
/*  24 */   public int randomSoundDelay = 0;
/*  25 */   public final int AttPow = 360;
/*  26 */   public final int HePo = 3600;
/*     */   int trans;
/*     */   
/*     */   public EntityFreeza5(World par1World) {
/*  30 */     super(par1World);
/*  31 */     this.field_70728_aV = 180;
/*  32 */     setData1(3);
/*  33 */     setData2(3);
/*  34 */     setMediumDifficulty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  41 */     return "jinryuudragonbc:npcs/freeza5.png";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  46 */     super.func_110147_ax();
/*  47 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(3600.0D);
/*  48 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(360.0D);
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
/*  67 */     if (this.randomSoundDelay <= 0 || --this.randomSoundDelay == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     super.func_70071_h_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/*  81 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/*  89 */     super.func_70014_b(par1NBTTagCompound);
/*  90 */     par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/*  98 */     super.func_70037_a(par1NBTTagCompound);
/*  99 */     this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/* 108 */     return (this.target != null) ? this.target : ((this.angerLevel == 0) ? null : super.func_70782_k());
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
/* 120 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 122 */     if (var3 instanceof EntityPlayer) {
/*     */ 
/*     */       
/* 125 */       ((EntityPlayer)var3).func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("dbc.itemFreeSagaFre.d.5.line1"), new Object[0])).func_150255_a(JRMCoreH2.styl_wht));
/*     */       
/* 127 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 129 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 131 */         Entity var6 = var4.get(var5);
/*     */         
/* 133 */         if (var6 instanceof EntityBarta) {
/*     */           
/* 135 */           EntityBarta var7 = (EntityBarta)var6;
/* 136 */           var7.becomeAngryAt(var3);
/*     */         } 
/* 138 */         if (var6 instanceof EntityJeice) {
/*     */           
/* 140 */           EntityJeice var71 = (EntityJeice)var6;
/* 141 */           var71.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 145 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 148 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 153 */     if (doBlst()) {
/* 154 */       int r = (int)(Math.random() * 3.0D);
/* 155 */       if (r == 0) {
/* 156 */         setData1(3);
/* 157 */         setData2(3);
/*     */       }
/* 159 */       else if (r == 1) {
/* 160 */         setData1(1);
/* 161 */         setData2(3);
/*     */       }
/* 163 */       else if (r == 2) {
/* 164 */         setData1(5);
/* 165 */         setData2(3);
/*     */       } 
/*     */     } 
/*     */     
/* 169 */     this.trans++;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 220 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 228 */     if (func_85032_ar())
/*     */     {
/* 230 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 234 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 236 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 238 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 240 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 242 */         Entity var6 = var4.get(var5);
/*     */         
/* 244 */         if (var6 instanceof EntityFreeza5) {
/*     */           
/* 246 */           EntityFreeza5 var7 = (EntityFreeza5)var6;
/* 247 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 251 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 254 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 263 */     this.field_70789_a = par1Entity;
/* 264 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 265 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
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
/* 299 */     int var3 = this.field_70146_Z.nextInt(1 + par2);
/*     */ 
/*     */     
/*     */     int var4;
/*     */     
/* 304 */     for (var4 = 0; var4 < var3; var4++)
/*     */     {
/* 306 */       func_145779_a(ItemsDBC.BattleArmorHelmet04, 1);
/*     */     }
/*     */     
/* 309 */     var3 = this.field_70146_Z.nextInt(2 + par2);
/*     */     
/* 311 */     for (var4 = 0; var4 < var3; var4++);
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
/* 322 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityFreeza5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */