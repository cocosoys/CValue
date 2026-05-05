/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityCell1
/*     */   extends EntityCyborgsInf
/*     */ {
/*  19 */   public int randomSoundDelay = 0;
/*     */   public String tex;
/*  21 */   public final int AttPow = 1500;
/*  22 */   public final int HePo = 15000;
/*     */ 
/*     */   
/*     */   public EntityCell1(World par1World) {
/*  26 */     super(par1World);
/*  27 */     this.field_70728_aV = 200;
/*  28 */     this.tex = "cell1";
/*  29 */     setData1(1);
/*  30 */     setData2(0);
/*  31 */     setMediumDifficulty();
/*  32 */     addAAiTeleport();
/*     */   }
/*     */   
/*     */   protected void func_110147_ax() {
/*  36 */     super.func_110147_ax();
/*  37 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(15000.0D);
/*  38 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1500.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  44 */     return "jinryuudragonbc:npcs/" + this.tex + ".png";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  52 */     if (doBlst()) {
/*  53 */       int r = (int)(Math.random() * 4.0D);
/*  54 */       if (r == 0) {
/*  55 */         setData1(1);
/*  56 */         setData2(0);
/*     */       }
/*  58 */       else if (r == 1) {
/*  59 */         setData1(3);
/*  60 */         setData2(0);
/*     */       }
/*  62 */       else if (r == 2) {
/*  63 */         setData1(4);
/*  64 */         setData2(7);
/*     */       } else {
/*     */         
/*  67 */         setData1(2);
/*  68 */         setData2(7);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 158 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 165 */     if (par1DamageSource instanceof net.minecraft.util.EntityDamageSourceIndirect || par1DamageSource instanceof net.minecraft.util.EntityDamageSource) {
/*     */       
/* 167 */       Entity var3 = par1DamageSource.func_76346_g();
/*     */       
/* 169 */       if (var3 instanceof net.minecraft.entity.player.EntityPlayer)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 187 */         becomeAngryAt(var3);
/*     */       }
/*     */     } 
/*     */     
/* 191 */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void becomeAngryAt(Entity par1Entity) {
/* 199 */     this.field_70789_a = par1Entity;
/* 200 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/* 201 */     this.randomSoundDelay = this.field_70146_Z.nextInt(40);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityCell1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */