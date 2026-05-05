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
/*     */ public class EntityFreeza6
/*     */   extends EntityDBCEvil
/*     */ {
/*  23 */   public int randomSoundDelay = 0;
/*  24 */   public final int AttPow = 400;
/*  25 */   public final int HePo = 4000;
/*     */ 
/*     */   
/*     */   public EntityFreeza6(World par1World) {
/*  29 */     super(par1World);
/*  30 */     this.field_70728_aV = 200;
/*  31 */     setData1(3);
/*  32 */     setData2(3);
/*  33 */     this.angerLevel = 400;
/*  34 */     setMediumDifficulty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  42 */     return "jinryuudragonbc:npcs/freeza6.png";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  47 */     super.func_110147_ax();
/*  48 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4000.0D);
/*  49 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(400.0D);
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
/* 108 */     return super.func_70782_k();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 116 */     if (doBlst()) {
/* 117 */       int r = (int)(Math.random() * 3.0D);
/* 118 */       if (r == 0) {
/* 119 */         setData1(3);
/* 120 */         setData2(3);
/*     */       }
/* 122 */       else if (r == 1) {
/* 123 */         setData1(1);
/* 124 */         setData2(3);
/*     */       }
/* 126 */       else if (r == 2) {
/* 127 */         setData1(5);
/* 128 */         setData2(3);
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
/* 164 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 172 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 174 */     if (var3 instanceof EntityPlayer) {
/*     */ 
/*     */       
/* 177 */       int e = 50;
/* 178 */       if (var3 instanceof EntityPlayer) {
/* 179 */         EntityPlayer player = (EntityPlayer)var3;
/* 180 */         JRMCoreH.expPls(player, e);
/*     */       } 
/*     */       
/* 183 */       ((EntityPlayer)var3).func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("dbc.itemFreeSagaFre.d.6.line1"), new Object[0])).func_150255_a(JRMCoreH2.styl_wht));
/*     */     } 
/*     */ 
/*     */     
/* 187 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 195 */     if (func_85032_ar())
/*     */     {
/* 197 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 201 */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     
/* 203 */     if (var3 instanceof EntityPlayer) {
/*     */       
/* 205 */       List<Entity> var4 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 207 */       for (int var5 = 0; var5 < var4.size(); var5++) {
/*     */         
/* 209 */         Entity var6 = var4.get(var5);
/*     */         
/* 211 */         if (var6 instanceof EntityFreeza6) {
/*     */           
/* 213 */           EntityFreeza6 var7 = (EntityFreeza6)var6;
/* 214 */           var7.becomeAngryAt(var3);
/*     */         } 
/*     */       } 
/*     */       
/* 218 */       becomeAngryAt(var3);
/*     */     } 
/*     */     
/* 221 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void becomeAngryAt(Entity par1Entity) {
/* 230 */     this.field_70789_a = par1Entity;
/* 231 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 232 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
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
/* 266 */     int var3 = this.field_70146_Z.nextInt(1 + par2);
/*     */ 
/*     */     
/*     */     int var4;
/*     */     
/* 271 */     for (var4 = 0; var4 < var3; var4++)
/*     */     {
/* 273 */       func_145779_a(ItemsDBC.BattleArmorHelmet04, 1);
/*     */     }
/*     */     
/* 276 */     var3 = this.field_70146_Z.nextInt(2 + par2);
/*     */     
/* 278 */     for (var4 = 0; var4 < var3; var4++);
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
/* 289 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityFreeza6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */