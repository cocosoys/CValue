/*     */ package net.minecraft.entity.item;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityMinecartFurnace
/*     */   extends EntityMinecart
/*     */ {
/*     */   private int field_94110_c;
/*     */   public double field_94111_a;
/*     */   public double field_94109_b;
/*     */   private static final String __OBFID = "CL_00001675";
/*     */   
/*     */   public EntityMinecartFurnace(World p_i1718_1_) {
/*  22 */     super(p_i1718_1_);
/*     */   }
/*     */   
/*     */   public EntityMinecartFurnace(World p_i1719_1_, double p_i1719_2_, double p_i1719_4_, double p_i1719_6_) {
/*  26 */     super(p_i1719_1_, p_i1719_2_, p_i1719_4_, p_i1719_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_94087_l() {
/*  31 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  36 */     super.func_70088_a();
/*  37 */     this.field_70180_af.func_75682_a(16, new Byte((byte)0));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  42 */     super.func_70071_h_();
/*     */     
/*  44 */     if (this.field_94110_c > 0) {
/*  45 */       this.field_94110_c--;
/*     */     }
/*  47 */     if (this.field_94110_c <= 0) {
/*  48 */       this.field_94111_a = this.field_94109_b = 0.0D;
/*     */     }
/*  50 */     func_94107_f((this.field_94110_c > 0));
/*     */     
/*  52 */     if (func_94108_c() && this.field_70146_Z.nextInt(4) == 0) {
/*  53 */       this.field_70170_p.func_72869_a("largesmoke", this.field_70165_t, this.field_70163_u + 0.8D, this.field_70161_v, 0.0D, 0.0D, 0.0D);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_94095_a(DamageSource p_94095_1_) {
/*  59 */     super.func_94095_a(p_94095_1_);
/*     */     
/*  61 */     if (!p_94095_1_.func_94541_c()) {
/*  62 */       func_70099_a(new ItemStack(Blocks.field_150460_al, 1), 0.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_145821_a(int p_145821_1_, int p_145821_2_, int p_145821_3_, double p_145821_4_, double p_145821_6_, Block p_145821_8_, int p_145821_9_) {
/*  68 */     super.func_145821_a(p_145821_1_, p_145821_2_, p_145821_3_, p_145821_4_, p_145821_6_, p_145821_8_, p_145821_9_);
/*     */     
/*  70 */     double d = this.field_94111_a * this.field_94111_a + this.field_94109_b * this.field_94109_b;
/*  71 */     if (d > 1.0E-4D && this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > 0.001D) {
/*  72 */       d = MathHelper.func_76133_a(d);
/*  73 */       this.field_94111_a /= d;
/*  74 */       this.field_94109_b /= d;
/*     */       
/*  76 */       if (this.field_94111_a * this.field_70159_w + this.field_94109_b * this.field_70179_y < 0.0D) {
/*  77 */         this.field_94111_a = 0.0D;
/*  78 */         this.field_94109_b = 0.0D;
/*     */       } else {
/*  80 */         this.field_94111_a = this.field_70159_w;
/*  81 */         this.field_94109_b = this.field_70179_y;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_94101_h() {
/*  88 */     double d = this.field_94111_a * this.field_94111_a + this.field_94109_b * this.field_94109_b;
/*     */     
/*  90 */     if (d > 1.0E-4D) {
/*  91 */       d = MathHelper.func_76133_a(d);
/*  92 */       this.field_94111_a /= d;
/*  93 */       this.field_94109_b /= d;
/*  94 */       double d1 = 0.05D;
/*  95 */       this.field_70159_w *= 0.800000011920929D;
/*  96 */       this.field_70181_x *= 0.0D;
/*  97 */       this.field_70179_y *= 0.800000011920929D;
/*  98 */       this.field_70159_w += this.field_94111_a * d1;
/*  99 */       this.field_70179_y += this.field_94109_b * d1;
/*     */     } else {
/* 101 */       this.field_70159_w *= 0.9800000190734863D;
/* 102 */       this.field_70181_x *= 0.0D;
/* 103 */       this.field_70179_y *= 0.9800000190734863D;
/*     */     } 
/*     */     
/* 106 */     super.func_94101_h();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer p_130002_1_) {
/* 111 */     ItemStack itemStack = p_130002_1_.field_71071_by.func_70448_g();
/* 112 */     if (itemStack != null && itemStack.func_77973_b() == Items.field_151044_h) {
/* 113 */       if (!p_130002_1_.field_71075_bZ.field_75098_d && --itemStack.field_77994_a == 0) p_130002_1_.field_71071_by.func_70299_a(p_130002_1_.field_71071_by.field_70461_c, null); 
/* 114 */       this.field_94110_c += 3600;
/*     */     } 
/*     */     
/* 117 */     this.field_94111_a = this.field_70165_t - p_130002_1_.field_70165_t;
/* 118 */     this.field_94109_b = this.field_70161_v - p_130002_1_.field_70161_v;
/*     */     
/* 120 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound p_70014_1_) {
/* 125 */     super.func_70014_b(p_70014_1_);
/* 126 */     p_70014_1_.func_74780_a("PushX", this.field_94111_a);
/* 127 */     p_70014_1_.func_74780_a("PushZ", this.field_94109_b);
/* 128 */     p_70014_1_.func_74777_a("Fuel", (short)this.field_94110_c);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound p_70037_1_) {
/* 133 */     super.func_70037_a(p_70037_1_);
/* 134 */     this.field_94111_a = p_70037_1_.func_74769_h("PushX");
/* 135 */     this.field_94109_b = p_70037_1_.func_74769_h("PushZ");
/* 136 */     this.field_94110_c = p_70037_1_.func_74765_d("Fuel");
/*     */   }
/*     */   
/*     */   protected boolean func_94108_c() {
/* 140 */     return ((this.field_70180_af.func_75683_a(16) & 0x1) != 0);
/*     */   }
/*     */   
/*     */   protected void func_94107_f(boolean p_94107_1_) {
/* 144 */     if (p_94107_1_) {
/* 145 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(this.field_70180_af.func_75683_a(16) | 0x1)));
/*     */     } else {
/* 147 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(this.field_70180_af.func_75683_a(16) & 0xFFFFFFFE)));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Block func_145817_o() {
/* 153 */     return Blocks.field_150470_am;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_94097_p() {
/* 158 */     return 2;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityMinecartFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */