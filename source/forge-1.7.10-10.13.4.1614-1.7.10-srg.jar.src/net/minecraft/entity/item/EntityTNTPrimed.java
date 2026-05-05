/*     */ package net.minecraft.entity.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityTNTPrimed
/*     */   extends Entity
/*     */ {
/*     */   public int field_70516_a;
/*     */   private EntityLivingBase field_94084_b;
/*     */   private static final String __OBFID = "CL_00001681";
/*     */   
/*     */   public EntityTNTPrimed(World p_i1729_1_) {
/*  18 */     super(p_i1729_1_);
/*  19 */     this.field_70156_m = true;
/*  20 */     func_70105_a(0.98F, 0.98F);
/*  21 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*     */   }
/*     */   
/*     */   public EntityTNTPrimed(World p_i1730_1_, double p_i1730_2_, double p_i1730_4_, double p_i1730_6_, EntityLivingBase p_i1730_8_) {
/*  25 */     this(p_i1730_1_);
/*     */     
/*  27 */     func_70107_b(p_i1730_2_, p_i1730_4_, p_i1730_6_);
/*     */     
/*  29 */     float f = (float)(Math.random() * 3.1415927410125732D * 2.0D);
/*  30 */     this.field_70159_w = (-((float)Math.sin(f)) * 0.02F);
/*  31 */     this.field_70181_x = 0.20000000298023224D;
/*  32 */     this.field_70179_y = (-((float)Math.cos(f)) * 0.02F);
/*     */     
/*  34 */     this.field_70516_a = 80;
/*     */     
/*  36 */     this.field_70169_q = p_i1730_2_;
/*  37 */     this.field_70167_r = p_i1730_4_;
/*  38 */     this.field_70166_s = p_i1730_6_;
/*  39 */     this.field_94084_b = p_i1730_8_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {}
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  48 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70067_L() {
/*  53 */     return !this.field_70128_L;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  58 */     this.field_70169_q = this.field_70165_t;
/*  59 */     this.field_70167_r = this.field_70163_u;
/*  60 */     this.field_70166_s = this.field_70161_v;
/*     */     
/*  62 */     this.field_70181_x -= 0.03999999910593033D;
/*  63 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*  64 */     this.field_70159_w *= 0.9800000190734863D;
/*  65 */     this.field_70181_x *= 0.9800000190734863D;
/*  66 */     this.field_70179_y *= 0.9800000190734863D;
/*     */     
/*  68 */     if (this.field_70122_E) {
/*  69 */       this.field_70159_w *= 0.699999988079071D;
/*  70 */       this.field_70179_y *= 0.699999988079071D;
/*  71 */       this.field_70181_x *= -0.5D;
/*     */     } 
/*     */     
/*  74 */     if (this.field_70516_a-- <= 0) {
/*  75 */       func_70106_y();
/*  76 */       if (!this.field_70170_p.field_72995_K) {
/*  77 */         func_70515_d();
/*     */       }
/*     */     } else {
/*  80 */       this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u + 0.5D, this.field_70161_v, 0.0D, 0.0D, 0.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_70515_d() {
/*  86 */     float f = 4.0F;
/*  87 */     this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, f, true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound p_70014_1_) {
/*  92 */     p_70014_1_.func_74774_a("Fuse", (byte)this.field_70516_a);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound p_70037_1_) {
/*  97 */     this.field_70516_a = p_70037_1_.func_74771_c("Fuse");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 102 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public EntityLivingBase func_94083_c() {
/* 106 */     return this.field_94084_b;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityTNTPrimed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */