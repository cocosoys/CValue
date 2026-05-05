/*     */ package net.minecraft.entity.monster;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockSilverfish;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.Facing;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import org.apache.commons.lang3.tuple.ImmutablePair;
/*     */ 
/*     */ public class EntitySilverfish extends EntityMob {
/*     */   private int field_70843_d;
/*     */   
/*     */   public EntitySilverfish(World p_i1740_1_) {
/*  21 */     super(p_i1740_1_);
/*  22 */     func_70105_a(0.3F, 0.7F);
/*     */   }
/*     */   private static final String __OBFID = "CL_00001696";
/*     */   
/*     */   protected void func_110147_ax() {
/*  27 */     super.func_110147_ax();
/*     */     
/*  29 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(8.0D);
/*  30 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.6000000238418579D);
/*  31 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  36 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Entity func_70782_k() {
/*  41 */     double d = 8.0D;
/*  42 */     return (Entity)this.field_70170_p.func_72856_b((Entity)this, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/*  47 */     return "mob.silverfish.say";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/*  52 */     return "mob.silverfish.hit";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/*  57 */     return "mob.silverfish.kill";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/*  62 */     if (func_85032_ar()) return false; 
/*  63 */     if (this.field_70843_d <= 0 && (p_70097_1_ instanceof net.minecraft.util.EntityDamageSource || p_70097_1_ == DamageSource.field_76376_m))
/*     */     {
/*  65 */       this.field_70843_d = 20;
/*     */     }
/*  67 */     return super.func_70097_a(p_70097_1_, p_70097_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70785_a(Entity p_70785_1_, float p_70785_2_) {
/*  72 */     if (this.field_70724_aR <= 0 && p_70785_2_ < 1.2F && p_70785_1_.field_70121_D.field_72337_e > this.field_70121_D.field_72338_b && p_70785_1_.field_70121_D.field_72338_b < this.field_70121_D.field_72337_e) {
/*  73 */       this.field_70724_aR = 20;
/*  74 */       func_70652_k(p_70785_1_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
/*  80 */     func_85030_a("mob.silverfish.step", 0.15F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/*  85 */     return Item.func_150899_d(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  91 */     this.field_70761_aq = this.field_70177_z;
/*     */     
/*  93 */     super.func_70071_h_();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70626_be() {
/*  98 */     super.func_70626_be();
/*     */     
/* 100 */     if (this.field_70170_p.field_72995_K) {
/*     */       return;
/*     */     }
/*     */     
/* 104 */     if (this.field_70843_d > 0) {
/* 105 */       this.field_70843_d--;
/* 106 */       if (this.field_70843_d == 0) {
/*     */ 
/*     */         
/* 109 */         int i = MathHelper.func_76128_c(this.field_70165_t);
/* 110 */         int j = MathHelper.func_76128_c(this.field_70163_u);
/* 111 */         int k = MathHelper.func_76128_c(this.field_70161_v);
/* 112 */         boolean bool = false;
/*     */         int m;
/* 114 */         for (m = 0; !bool && m <= 5 && m >= -5; m = (m <= 0) ? (1 - m) : (0 - m)) {
/* 115 */           int n; for (n = 0; !bool && n <= 10 && n >= -10; n = (n <= 0) ? (1 - n) : (0 - n)) {
/* 116 */             int i1; for (i1 = 0; !bool && i1 <= 10 && i1 >= -10; i1 = (i1 <= 0) ? (1 - i1) : (0 - i1)) {
/* 117 */               if (this.field_70170_p.func_147439_a(i + n, j + m, k + i1) == Blocks.field_150418_aU) {
/* 118 */                 if (!this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
/* 119 */                   int i2 = this.field_70170_p.func_72805_g(i + n, j + m, k + i1);
/* 120 */                   ImmutablePair immutablePair = BlockSilverfish.func_150197_b(i2);
/*     */                   
/* 122 */                   this.field_70170_p.func_147465_d(i + n, j + m, k + i1, (Block)immutablePair.getLeft(), ((Integer)immutablePair.getRight()).intValue(), 3);
/*     */                 } else {
/* 124 */                   this.field_70170_p.func_147480_a(i + n, j + m, k + i1, false);
/*     */                 } 
/* 126 */                 Blocks.field_150418_aU.func_149664_b(this.field_70170_p, i + n, j + m, k + i1, 0);
/* 127 */                 if (this.field_70146_Z.nextBoolean()) {
/* 128 */                   bool = true;
/*     */                   
/*     */                   break;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 138 */     if (this.field_70789_a == null && !func_70781_l()) {
/*     */ 
/*     */       
/* 141 */       int i = MathHelper.func_76128_c(this.field_70165_t);
/* 142 */       int j = MathHelper.func_76128_c(this.field_70163_u + 0.5D);
/* 143 */       int k = MathHelper.func_76128_c(this.field_70161_v);
/* 144 */       int m = this.field_70146_Z.nextInt(6);
/*     */       
/* 146 */       Block block = this.field_70170_p.func_147439_a(i + Facing.field_71586_b[m], j + Facing.field_71587_c[m], k + Facing.field_71585_d[m]);
/* 147 */       int n = this.field_70170_p.func_72805_g(i + Facing.field_71586_b[m], j + Facing.field_71587_c[m], k + Facing.field_71585_d[m]);
/* 148 */       if (BlockSilverfish.func_150196_a(block)) {
/* 149 */         this.field_70170_p.func_147465_d(i + Facing.field_71586_b[m], j + Facing.field_71587_c[m], k + Facing.field_71585_d[m], Blocks.field_150418_aU, BlockSilverfish.func_150195_a(block, n), 3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 157 */         func_70656_aK();
/* 158 */         func_70106_y();
/*     */       } else {
/* 160 */         func_70779_j();
/*     */       }
/*     */     
/* 163 */     } else if (this.field_70789_a != null && !func_70781_l()) {
/* 164 */       this.field_70789_a = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_) {
/* 171 */     if (this.field_70170_p.func_147439_a(p_70783_1_, p_70783_2_ - 1, p_70783_3_) == Blocks.field_150348_b) return 10.0F; 
/* 172 */     return super.func_70783_a(p_70783_1_, p_70783_2_, p_70783_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70814_o() {
/* 177 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/* 182 */     if (super.func_70601_bi()) {
/* 183 */       EntityPlayer entityPlayer = this.field_70170_p.func_72890_a((Entity)this, 5.0D);
/* 184 */       return (entityPlayer == null);
/*     */     } 
/* 186 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumCreatureAttribute func_70668_bt() {
/* 191 */     return EnumCreatureAttribute.ARTHROPOD;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntitySilverfish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */