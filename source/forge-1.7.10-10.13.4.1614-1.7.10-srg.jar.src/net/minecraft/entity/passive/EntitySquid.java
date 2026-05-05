/*     */ package net.minecraft.entity.passive;
/*     */ 
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class EntitySquid
/*     */   extends EntityWaterMob
/*     */ {
/*     */   public float field_70861_d;
/*     */   public float field_70862_e;
/*     */   public float field_70859_f;
/*     */   public float field_70860_g;
/*     */   public float field_70867_h;
/*     */   public float field_70868_i;
/*     */   public float field_70866_j;
/*     */   
/*     */   public EntitySquid(World p_i1693_1_) {
/*  25 */     super(p_i1693_1_);
/*  26 */     func_70105_a(0.95F, 0.95F);
/*  27 */     this.field_70864_bA = 1.0F / (this.field_70146_Z.nextFloat() + 1.0F) * 0.2F;
/*     */   }
/*     */   public float field_70865_by; private float field_70863_bz; private float field_70864_bA; private float field_70871_bB; private float field_70872_bC; private float field_70869_bD; private float field_70870_bE; private static final String __OBFID = "CL_00001651";
/*     */   
/*     */   protected void func_110147_ax() {
/*  32 */     super.func_110147_ax();
/*     */     
/*  34 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/*  39 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/*  44 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/*  49 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_70599_aP() {
/*  54 */     return 0.4F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/*  59 */     return Item.func_150899_d(0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  64 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/*  69 */     int i = this.field_70146_Z.nextInt(3 + p_70628_2_) + 1;
/*  70 */     for (byte b = 0; b < i; b++) {
/*  71 */       func_70099_a(new ItemStack(Items.field_151100_aR, 1, 0), 0.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70090_H() {
/*  77 */     return this.field_70170_p.func_72918_a(this.field_70121_D.func_72314_b(0.0D, -0.6000000238418579D, 0.0D), Material.field_151586_h, (Entity)this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  83 */     super.func_70636_d();
/*     */     
/*  85 */     this.field_70862_e = this.field_70861_d;
/*  86 */     this.field_70860_g = this.field_70859_f;
/*     */     
/*  88 */     this.field_70868_i = this.field_70867_h;
/*  89 */     this.field_70865_by = this.field_70866_j;
/*     */     
/*  91 */     this.field_70867_h += this.field_70864_bA;
/*  92 */     if (this.field_70867_h > 6.2831855F) {
/*  93 */       this.field_70867_h -= 6.2831855F;
/*  94 */       if (this.field_70146_Z.nextInt(10) == 0) this.field_70864_bA = 1.0F / (this.field_70146_Z.nextFloat() + 1.0F) * 0.2F;
/*     */     
/*     */     } 
/*  97 */     if (func_70090_H()) {
/*  98 */       if (this.field_70867_h < 3.1415927F) {
/*  99 */         float f1 = this.field_70867_h / 3.1415927F;
/* 100 */         this.field_70866_j = MathHelper.func_76126_a(f1 * f1 * 3.1415927F) * 3.1415927F * 0.25F;
/*     */         
/* 102 */         if (f1 > 0.75D) {
/* 103 */           this.field_70863_bz = 1.0F;
/* 104 */           this.field_70871_bB = 1.0F;
/*     */         } else {
/* 106 */           this.field_70871_bB *= 0.8F;
/*     */         } 
/*     */       } else {
/* 109 */         this.field_70866_j = 0.0F;
/* 110 */         this.field_70863_bz *= 0.9F;
/* 111 */         this.field_70871_bB *= 0.99F;
/*     */       } 
/*     */       
/* 114 */       if (!this.field_70170_p.field_72995_K) {
/* 115 */         this.field_70159_w = (this.field_70872_bC * this.field_70863_bz);
/* 116 */         this.field_70181_x = (this.field_70869_bD * this.field_70863_bz);
/* 117 */         this.field_70179_y = (this.field_70870_bE * this.field_70863_bz);
/*     */       } 
/*     */       
/* 120 */       float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */       
/* 122 */       this.field_70761_aq += (-((float)Math.atan2(this.field_70159_w, this.field_70179_y)) * 180.0F / 3.1415927F - this.field_70761_aq) * 0.1F;
/* 123 */       this.field_70177_z = this.field_70761_aq;
/* 124 */       this.field_70859_f += 3.1415927F * this.field_70871_bB * 1.5F;
/* 125 */       this.field_70861_d += (-((float)Math.atan2(f, this.field_70181_x)) * 180.0F / 3.1415927F - this.field_70861_d) * 0.1F;
/*     */     } else {
/* 127 */       this.field_70866_j = MathHelper.func_76135_e(MathHelper.func_76126_a(this.field_70867_h)) * 3.1415927F * 0.25F;
/*     */       
/* 129 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 131 */         this.field_70159_w = 0.0D;
/* 132 */         this.field_70181_x -= 0.08D;
/* 133 */         this.field_70181_x *= 0.9800000190734863D;
/* 134 */         this.field_70179_y = 0.0D;
/*     */       } 
/*     */ 
/*     */       
/* 138 */       this.field_70861_d = (float)(this.field_70861_d + (-90.0F - this.field_70861_d) * 0.02D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70612_e(float p_70612_1_, float p_70612_2_) {
/* 144 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70626_be() {
/* 150 */     this.field_70708_bq++;
/*     */ 
/*     */     
/* 153 */     if (this.field_70708_bq > 100) {
/* 154 */       this.field_70872_bC = this.field_70869_bD = this.field_70870_bE = 0.0F;
/* 155 */     } else if (this.field_70146_Z.nextInt(50) == 0 || !this.field_70171_ac || (this.field_70872_bC == 0.0F && this.field_70869_bD == 0.0F && this.field_70870_bE == 0.0F)) {
/* 156 */       float f = this.field_70146_Z.nextFloat() * 3.1415927F * 2.0F;
/* 157 */       this.field_70872_bC = MathHelper.func_76134_b(f) * 0.2F;
/* 158 */       this.field_70869_bD = -0.1F + this.field_70146_Z.nextFloat() * 0.2F;
/* 159 */       this.field_70870_bE = MathHelper.func_76126_a(f) * 0.2F;
/*     */     } 
/*     */     
/* 162 */     func_70623_bb();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/* 168 */     return (this.field_70163_u > 45.0D && this.field_70163_u < 63.0D && super.func_70601_bi());
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\passive\EntitySquid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */