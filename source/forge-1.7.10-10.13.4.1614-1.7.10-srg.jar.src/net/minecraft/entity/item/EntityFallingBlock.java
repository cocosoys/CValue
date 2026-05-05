/*     */ package net.minecraft.entity.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFalling;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityFallingBlock extends Entity {
/*     */   private Block field_145811_e;
/*     */   public int field_145814_a;
/*     */   public int field_145812_b;
/*     */   public boolean field_145813_c = true;
/*     */   private boolean field_145808_f;
/*     */   private boolean field_145809_g;
/*  27 */   private int field_145815_h = 40;
/*  28 */   private float field_145816_i = 2.0F;
/*     */   public NBTTagCompound field_145810_d;
/*     */   
/*     */   public EntityFallingBlock(World p_i1706_1_) {
/*  32 */     super(p_i1706_1_);
/*     */   }
/*     */   private static final String __OBFID = "CL_00001668";
/*     */   public EntityFallingBlock(World p_i45318_1_, double p_i45318_2_, double p_i45318_4_, double p_i45318_6_, Block p_i45318_8_) {
/*  36 */     this(p_i45318_1_, p_i45318_2_, p_i45318_4_, p_i45318_6_, p_i45318_8_, 0);
/*     */   }
/*     */   
/*     */   public EntityFallingBlock(World p_i45319_1_, double p_i45319_2_, double p_i45319_4_, double p_i45319_6_, Block p_i45319_8_, int p_i45319_9_) {
/*  40 */     super(p_i45319_1_);
/*  41 */     this.field_145811_e = p_i45319_8_;
/*  42 */     this.field_145814_a = p_i45319_9_;
/*  43 */     this.field_70156_m = true;
/*  44 */     func_70105_a(0.98F, 0.98F);
/*  45 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*  46 */     func_70107_b(p_i45319_2_, p_i45319_4_, p_i45319_6_);
/*     */     
/*  48 */     this.field_70159_w = 0.0D;
/*  49 */     this.field_70181_x = 0.0D;
/*  50 */     this.field_70179_y = 0.0D;
/*     */     
/*  52 */     this.field_70169_q = p_i45319_2_;
/*  53 */     this.field_70167_r = p_i45319_4_;
/*  54 */     this.field_70166_s = p_i45319_6_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  60 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {}
/*     */ 
/*     */   
/*     */   public boolean func_70067_L() {
/*  69 */     return !this.field_70128_L;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  74 */     if (this.field_145811_e.func_149688_o() == Material.field_151579_a) {
/*  75 */       func_70106_y();
/*     */       
/*     */       return;
/*     */     } 
/*  79 */     this.field_70169_q = this.field_70165_t;
/*  80 */     this.field_70167_r = this.field_70163_u;
/*  81 */     this.field_70166_s = this.field_70161_v;
/*  82 */     this.field_145812_b++;
/*     */     
/*  84 */     this.field_70181_x -= 0.03999999910593033D;
/*  85 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*  86 */     this.field_70159_w *= 0.9800000190734863D;
/*  87 */     this.field_70181_x *= 0.9800000190734863D;
/*  88 */     this.field_70179_y *= 0.9800000190734863D;
/*     */     
/*  90 */     if (!this.field_70170_p.field_72995_K) {
/*  91 */       int i = MathHelper.func_76128_c(this.field_70165_t);
/*  92 */       int j = MathHelper.func_76128_c(this.field_70163_u);
/*  93 */       int k = MathHelper.func_76128_c(this.field_70161_v);
/*     */       
/*  95 */       if (this.field_145812_b == 1) {
/*  96 */         if (this.field_70170_p.func_147439_a(i, j, k) == this.field_145811_e) {
/*  97 */           this.field_70170_p.func_147468_f(i, j, k);
/*     */         } else {
/*  99 */           func_70106_y();
/*     */           
/*     */           return;
/*     */         } 
/*     */       }
/* 104 */       if (this.field_70122_E) {
/* 105 */         this.field_70159_w *= 0.699999988079071D;
/* 106 */         this.field_70179_y *= 0.699999988079071D;
/* 107 */         this.field_70181_x *= -0.5D;
/*     */         
/* 109 */         if (this.field_70170_p.func_147439_a(i, j, k) != Blocks.field_150326_M) {
/* 110 */           func_70106_y();
/*     */           
/* 112 */           if (!this.field_145808_f && this.field_70170_p.func_147472_a(this.field_145811_e, i, j, k, true, 1, null, null) && !BlockFalling.func_149831_e(this.field_70170_p, i, j - 1, k) && this.field_70170_p.func_147465_d(i, j, k, this.field_145811_e, this.field_145814_a, 3))
/*     */           
/*     */           { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 120 */             if (this.field_145811_e instanceof BlockFalling) {
/* 121 */               ((BlockFalling)this.field_145811_e).func_149828_a(this.field_70170_p, i, j, k, this.field_145814_a);
/*     */             }
/* 123 */             if (this.field_145810_d != null && this.field_145811_e instanceof net.minecraft.block.ITileEntityProvider) {
/* 124 */               TileEntity tileEntity = this.field_70170_p.func_147438_o(i, j, k);
/*     */               
/* 126 */               if (tileEntity != null) {
/* 127 */                 NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 128 */                 tileEntity.func_145841_b(nBTTagCompound);
/* 129 */                 for (String str : this.field_145810_d.func_150296_c()) {
/* 130 */                   NBTBase nBTBase = this.field_145810_d.func_74781_a(str);
/* 131 */                   if (str.equals("x") || str.equals("y") || str.equals("z"))
/* 132 */                     continue;  nBTTagCompound.func_74782_a(str, nBTBase.func_74737_b());
/*     */                 } 
/* 134 */                 tileEntity.func_145839_a(nBTTagCompound);
/* 135 */                 tileEntity.func_70296_d();
/*     */               }
/*     */             
/*     */             }  }
/* 139 */           else if (this.field_145813_c && !this.field_145808_f) { func_70099_a(new ItemStack(this.field_145811_e, 1, this.field_145811_e.func_149692_a(this.field_145814_a)), 0.0F); }
/*     */         
/*     */         } 
/* 142 */       } else if ((this.field_145812_b > 100 && !this.field_70170_p.field_72995_K && (j < 1 || j > 256)) || this.field_145812_b > 600) {
/* 143 */         if (this.field_145813_c) func_70099_a(new ItemStack(this.field_145811_e, 1, this.field_145811_e.func_149692_a(this.field_145814_a)), 0.0F); 
/* 144 */         func_70106_y();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70069_a(float p_70069_1_) {
/* 151 */     if (this.field_145809_g) {
/* 152 */       int i = MathHelper.func_76123_f(p_70069_1_ - 1.0F);
/* 153 */       if (i > 0) {
/* 154 */         ArrayList arrayList = new ArrayList(this.field_70170_p.func_72839_b(this, this.field_70121_D));
/* 155 */         boolean bool = (this.field_145811_e == Blocks.field_150467_bQ) ? true : false;
/* 156 */         DamageSource damageSource = bool ? DamageSource.field_82728_o : DamageSource.field_82729_p;
/*     */         
/* 158 */         for (Entity entity : arrayList) {
/* 159 */           entity.func_70097_a(damageSource, Math.min(MathHelper.func_76141_d(i * this.field_145816_i), this.field_145815_h));
/*     */         }
/*     */         
/* 162 */         if (bool && this.field_70146_Z.nextFloat() < 0.05000000074505806D + i * 0.05D) {
/* 163 */           int j = this.field_145814_a >> 2;
/* 164 */           int k = this.field_145814_a & 0x3;
/*     */           
/* 166 */           if (++j > 2) {
/* 167 */             this.field_145808_f = true;
/*     */           } else {
/* 169 */             this.field_145814_a = k | j << 2;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound p_70014_1_) {
/* 178 */     p_70014_1_.func_74774_a("Tile", (byte)Block.func_149682_b(this.field_145811_e));
/* 179 */     p_70014_1_.func_74768_a("TileID", Block.func_149682_b(this.field_145811_e));
/* 180 */     p_70014_1_.func_74774_a("Data", (byte)this.field_145814_a);
/* 181 */     p_70014_1_.func_74774_a("Time", (byte)this.field_145812_b);
/* 182 */     p_70014_1_.func_74757_a("DropItem", this.field_145813_c);
/* 183 */     p_70014_1_.func_74757_a("HurtEntities", this.field_145809_g);
/* 184 */     p_70014_1_.func_74776_a("FallHurtAmount", this.field_145816_i);
/* 185 */     p_70014_1_.func_74768_a("FallHurtMax", this.field_145815_h);
/* 186 */     if (this.field_145810_d != null) p_70014_1_.func_74782_a("TileEntityData", (NBTBase)this.field_145810_d);
/*     */   
/*     */   }
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound p_70037_1_) {
/* 191 */     if (p_70037_1_.func_150297_b("TileID", 99)) {
/* 192 */       this.field_145811_e = Block.func_149729_e(p_70037_1_.func_74762_e("TileID"));
/*     */     } else {
/* 194 */       this.field_145811_e = Block.func_149729_e(p_70037_1_.func_74771_c("Tile") & 0xFF);
/*     */     } 
/*     */     
/* 197 */     this.field_145814_a = p_70037_1_.func_74771_c("Data") & 0xFF;
/* 198 */     this.field_145812_b = p_70037_1_.func_74771_c("Time") & 0xFF;
/*     */     
/* 200 */     if (p_70037_1_.func_150297_b("HurtEntities", 99)) {
/* 201 */       this.field_145809_g = p_70037_1_.func_74767_n("HurtEntities");
/* 202 */       this.field_145816_i = p_70037_1_.func_74760_g("FallHurtAmount");
/* 203 */       this.field_145815_h = p_70037_1_.func_74762_e("FallHurtMax");
/* 204 */     } else if (this.field_145811_e == Blocks.field_150467_bQ) {
/* 205 */       this.field_145809_g = true;
/*     */     } 
/*     */     
/* 208 */     if (p_70037_1_.func_150297_b("DropItem", 99)) {
/* 209 */       this.field_145813_c = p_70037_1_.func_74767_n("DropItem");
/*     */     }
/*     */     
/* 212 */     if (p_70037_1_.func_150297_b("TileEntityData", 10)) {
/* 213 */       this.field_145810_d = p_70037_1_.func_74775_l("TileEntityData");
/*     */     }
/*     */     
/* 216 */     if (this.field_145811_e.func_149688_o() == Material.field_151579_a) {
/* 217 */       this.field_145811_e = (Block)Blocks.field_150354_m;
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 223 */     return 0.0F;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public World func_145807_e() {
/* 227 */     return this.field_70170_p;
/*     */   }
/*     */   
/*     */   public void func_145806_a(boolean p_145806_1_) {
/* 231 */     this.field_145809_g = p_145806_1_;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_90999_ad() {
/* 236 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_85029_a(CrashReportCategory p_85029_1_) {
/* 241 */     super.func_85029_a(p_85029_1_);
/* 242 */     p_85029_1_.func_71507_a("Immitating block ID", Integer.valueOf(Block.func_149682_b(this.field_145811_e)));
/* 243 */     p_85029_1_.func_71507_a("Immitating block data", Integer.valueOf(this.field_145814_a));
/*     */   }
/*     */ 
/*     */   
/*     */   public Block func_145805_f() {
/* 248 */     return this.field_145811_e;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityFallingBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */