/*     */ package net.minecraft.entity.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockRailBase;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityMinecartTNT
/*     */   extends EntityMinecart {
/*  16 */   private int field_94106_a = -1;
/*     */   
/*     */   public EntityMinecartTNT(World p_i1727_1_) {
/*  19 */     super(p_i1727_1_);
/*     */   }
/*     */   private static final String __OBFID = "CL_00001680";
/*     */   public EntityMinecartTNT(World p_i1728_1_, double p_i1728_2_, double p_i1728_4_, double p_i1728_6_) {
/*  23 */     super(p_i1728_1_, p_i1728_2_, p_i1728_4_, p_i1728_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_94087_l() {
/*  28 */     return 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public Block func_145817_o() {
/*  33 */     return Blocks.field_150335_W;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  38 */     super.func_70071_h_();
/*     */     
/*  40 */     if (this.field_94106_a > 0) {
/*  41 */       this.field_94106_a--;
/*  42 */       this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u + 0.5D, this.field_70161_v, 0.0D, 0.0D, 0.0D);
/*  43 */     } else if (this.field_94106_a == 0) {
/*  44 */       func_94103_c(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */     } 
/*     */     
/*  47 */     if (this.field_70123_F) {
/*  48 */       double d = this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y;
/*     */       
/*  50 */       if (d >= 0.009999999776482582D) {
/*  51 */         func_94103_c(d);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_94095_a(DamageSource p_94095_1_) {
/*  58 */     super.func_94095_a(p_94095_1_);
/*     */     
/*  60 */     double d = this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y;
/*     */     
/*  62 */     if (!p_94095_1_.func_94541_c()) {
/*  63 */       func_70099_a(new ItemStack(Blocks.field_150335_W, 1), 0.0F);
/*     */     }
/*     */     
/*  66 */     if (p_94095_1_.func_76347_k() || p_94095_1_.func_94541_c() || d >= 0.009999999776482582D) {
/*  67 */       func_94103_c(d);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void func_94103_c(double p_94103_1_) {
/*  72 */     if (!this.field_70170_p.field_72995_K) {
/*  73 */       double d = Math.sqrt(p_94103_1_);
/*  74 */       if (d > 5.0D) d = 5.0D; 
/*  75 */       this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, (float)(4.0D + this.field_70146_Z.nextDouble() * 1.5D * d), true);
/*  76 */       func_70106_y();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70069_a(float p_70069_1_) {
/*  82 */     if (p_70069_1_ >= 3.0F) {
/*  83 */       float f = p_70069_1_ / 10.0F;
/*  84 */       func_94103_c((f * f));
/*     */     } 
/*     */     
/*  87 */     super.func_70069_a(p_70069_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96095_a(int p_96095_1_, int p_96095_2_, int p_96095_3_, boolean p_96095_4_) {
/*  92 */     if (p_96095_4_ && this.field_94106_a < 0) {
/*  93 */       func_94105_c();
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70103_a(byte p_70103_1_) {
/*  99 */     if (p_70103_1_ == 10) {
/* 100 */       func_94105_c();
/*     */     } else {
/* 102 */       super.func_70103_a(p_70103_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_94105_c() {
/* 107 */     this.field_94106_a = 80;
/*     */     
/* 109 */     if (!this.field_70170_p.field_72995_K) {
/* 110 */       this.field_70170_p.func_72960_a(this, (byte)10);
/* 111 */       this.field_70170_p.func_72956_a(this, "game.tnt.primed", 1.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_94104_d() {
/* 116 */     return this.field_94106_a;
/*     */   }
/*     */   
/*     */   public boolean func_96096_ay() {
/* 120 */     return (this.field_94106_a > -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_145772_a(Explosion p_145772_1_, World p_145772_2_, int p_145772_3_, int p_145772_4_, int p_145772_5_, Block p_145772_6_) {
/* 125 */     if (func_96096_ay() && (BlockRailBase.func_150051_a(p_145772_6_) || BlockRailBase.func_150049_b_(p_145772_2_, p_145772_3_, p_145772_4_ + 1, p_145772_5_))) {
/* 126 */       return 0.0F;
/*     */     }
/*     */     
/* 129 */     return super.func_145772_a(p_145772_1_, p_145772_2_, p_145772_3_, p_145772_4_, p_145772_5_, p_145772_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_145774_a(Explosion p_145774_1_, World p_145774_2_, int p_145774_3_, int p_145774_4_, int p_145774_5_, Block p_145774_6_, float p_145774_7_) {
/* 134 */     if (func_96096_ay() && (BlockRailBase.func_150051_a(p_145774_6_) || BlockRailBase.func_150049_b_(p_145774_2_, p_145774_3_, p_145774_4_ + 1, p_145774_5_))) return false;
/*     */     
/* 136 */     return super.func_145774_a(p_145774_1_, p_145774_2_, p_145774_3_, p_145774_4_, p_145774_5_, p_145774_6_, p_145774_7_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound p_70037_1_) {
/* 141 */     super.func_70037_a(p_70037_1_);
/* 142 */     if (p_70037_1_.func_150297_b("TNTFuse", 99)) this.field_94106_a = p_70037_1_.func_74762_e("TNTFuse");
/*     */   
/*     */   }
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound p_70014_1_) {
/* 147 */     super.func_70014_b(p_70014_1_);
/* 148 */     p_70014_1_.func_74768_a("TNTFuse", this.field_94106_a);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityMinecartTNT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */