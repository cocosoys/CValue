/*     */ package net.minecraft.entity.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityEnderEye
/*     */   extends Entity {
/*     */   private double field_70224_b;
/*     */   private double field_70225_c;
/*     */   private double field_70222_d;
/*     */   private int field_70223_e;
/*     */   private boolean field_70221_f;
/*     */   private static final String __OBFID = "CL_00001716";
/*     */   
/*     */   public EntityEnderEye(World p_i1757_1_) {
/*  22 */     super(p_i1757_1_);
/*  23 */     func_70105_a(0.25F, 0.25F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {}
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_70112_a(double p_70112_1_) {
/*  32 */     double d = this.field_70121_D.func_72320_b() * 4.0D;
/*  33 */     d *= 64.0D;
/*  34 */     return (p_70112_1_ < d * d);
/*     */   }
/*     */   
/*     */   public EntityEnderEye(World p_i1758_1_, double p_i1758_2_, double p_i1758_4_, double p_i1758_6_) {
/*  38 */     super(p_i1758_1_);
/*  39 */     this.field_70223_e = 0;
/*     */     
/*  41 */     func_70105_a(0.25F, 0.25F);
/*     */     
/*  43 */     func_70107_b(p_i1758_2_, p_i1758_4_, p_i1758_6_);
/*  44 */     this.field_70129_M = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70220_a(double p_70220_1_, int p_70220_3_, double p_70220_4_) {
/*  49 */     double d1 = p_70220_1_ - this.field_70165_t, d2 = p_70220_4_ - this.field_70161_v;
/*  50 */     float f = MathHelper.func_76133_a(d1 * d1 + d2 * d2);
/*     */     
/*  52 */     if (f > 12.0F) {
/*  53 */       this.field_70224_b = this.field_70165_t + d1 / f * 12.0D;
/*  54 */       this.field_70222_d = this.field_70161_v + d2 / f * 12.0D;
/*  55 */       this.field_70225_c = this.field_70163_u + 8.0D;
/*     */     } else {
/*  57 */       this.field_70224_b = p_70220_1_;
/*  58 */       this.field_70225_c = p_70220_3_;
/*  59 */       this.field_70222_d = p_70220_4_;
/*     */     } 
/*     */     
/*  62 */     this.field_70223_e = 0;
/*  63 */     this.field_70221_f = (this.field_70146_Z.nextInt(5) > 0);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
/*  68 */     this.field_70159_w = p_70016_1_;
/*  69 */     this.field_70181_x = p_70016_3_;
/*  70 */     this.field_70179_y = p_70016_5_;
/*  71 */     if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
/*  72 */       float f = MathHelper.func_76133_a(p_70016_1_ * p_70016_1_ + p_70016_5_ * p_70016_5_);
/*  73 */       this.field_70126_B = this.field_70177_z = (float)(Math.atan2(p_70016_1_, p_70016_5_) * 180.0D / 3.1415927410125732D);
/*  74 */       this.field_70127_C = this.field_70125_A = (float)(Math.atan2(p_70016_3_, f) * 180.0D / 3.1415927410125732D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  80 */     this.field_70142_S = this.field_70165_t;
/*  81 */     this.field_70137_T = this.field_70163_u;
/*  82 */     this.field_70136_U = this.field_70161_v;
/*  83 */     super.func_70071_h_();
/*     */     
/*  85 */     this.field_70165_t += this.field_70159_w;
/*  86 */     this.field_70163_u += this.field_70181_x;
/*  87 */     this.field_70161_v += this.field_70179_y;
/*     */     
/*  89 */     float f1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*  90 */     this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.1415927410125732D);
/*  91 */     this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f1) * 180.0D / 3.1415927410125732D);
/*     */     
/*  93 */     while (this.field_70125_A - this.field_70127_C < -180.0F)
/*  94 */       this.field_70127_C -= 360.0F; 
/*  95 */     while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/*  96 */       this.field_70127_C += 360.0F;
/*     */     }
/*  98 */     while (this.field_70177_z - this.field_70126_B < -180.0F)
/*  99 */       this.field_70126_B -= 360.0F; 
/* 100 */     while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/* 101 */       this.field_70126_B += 360.0F;
/*     */     }
/* 103 */     this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F;
/* 104 */     this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
/*     */     
/* 106 */     if (!this.field_70170_p.field_72995_K) {
/* 107 */       double d1 = this.field_70224_b - this.field_70165_t, d2 = this.field_70222_d - this.field_70161_v;
/* 108 */       float f3 = (float)Math.sqrt(d1 * d1 + d2 * d2);
/* 109 */       float f4 = (float)Math.atan2(d2, d1);
/* 110 */       double d3 = f1 + (f3 - f1) * 0.0025D;
/* 111 */       if (f3 < 1.0F) {
/* 112 */         d3 *= 0.8D;
/* 113 */         this.field_70181_x *= 0.8D;
/*     */       } 
/* 115 */       this.field_70159_w = Math.cos(f4) * d3;
/* 116 */       this.field_70179_y = Math.sin(f4) * d3;
/*     */       
/* 118 */       if (this.field_70163_u < this.field_70225_c) {
/* 119 */         this.field_70181_x += (1.0D - this.field_70181_x) * 0.014999999664723873D;
/*     */       } else {
/* 121 */         this.field_70181_x += (-1.0D - this.field_70181_x) * 0.014999999664723873D;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 126 */     float f2 = 0.25F;
/* 127 */     if (func_70090_H()) {
/* 128 */       for (byte b = 0; b < 4; b++) {
/* 129 */         this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * f2, this.field_70163_u - this.field_70181_x * f2, this.field_70161_v - this.field_70179_y * f2, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */       }
/*     */     } else {
/*     */       
/* 133 */       this.field_70170_p.func_72869_a("portal", this.field_70165_t - this.field_70159_w * f2 + this.field_70146_Z.nextDouble() * 0.6D - 0.3D, this.field_70163_u - this.field_70181_x * f2 - 0.5D, this.field_70161_v - this.field_70179_y * f2 + this.field_70146_Z.nextDouble() * 0.6D - 0.3D, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */     } 
/*     */     
/* 136 */     if (!this.field_70170_p.field_72995_K) {
/* 137 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */       
/* 139 */       this.field_70223_e++;
/* 140 */       if (this.field_70223_e > 80 && !this.field_70170_p.field_72995_K) {
/* 141 */         func_70106_y();
/* 142 */         if (this.field_70221_f) {
/* 143 */           this.field_70170_p.func_72838_d(new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(Items.field_151061_bv)));
/*     */         } else {
/* 145 */           this.field_70170_p.func_72926_e(2003, (int)Math.round(this.field_70165_t), (int)Math.round(this.field_70163_u), (int)Math.round(this.field_70161_v), 0);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {}
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {}
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 161 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_70013_c(float p_70013_1_) {
/* 166 */     return 1.0F;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_70070_b(float p_70070_1_) {
/* 171 */     return 15728880;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70075_an() {
/* 176 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityEnderEye.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */