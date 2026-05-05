/*     */ package net.minecraft.entity.passive;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IEntityOwnable;
/*     */ import net.minecraft.entity.ai.EntityAISit;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.scoreboard.Team;
/*     */ import net.minecraft.server.management.PreYggdrasilConverter;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public abstract class EntityTameable
/*     */   extends EntityAnimal
/*     */   implements IEntityOwnable
/*     */ {
/*  20 */   protected EntityAISit field_70911_d = new EntityAISit(this);
/*     */   
/*     */   public EntityTameable(World p_i1604_1_) {
/*  23 */     super(p_i1604_1_);
/*     */   }
/*     */   private static final String __OBFID = "CL_00001561";
/*     */   
/*     */   protected void func_70088_a() {
/*  28 */     super.func_70088_a();
/*  29 */     this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
/*  30 */     this.field_70180_af.func_75682_a(17, "");
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/*  35 */     super.func_70014_b(p_70014_1_);
/*  36 */     if (func_152113_b() == null) {
/*  37 */       p_70014_1_.func_74778_a("OwnerUUID", "");
/*     */     } else {
/*  39 */       p_70014_1_.func_74778_a("OwnerUUID", func_152113_b());
/*     */     } 
/*  41 */     p_70014_1_.func_74757_a("Sitting", func_70906_o());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/*  46 */     super.func_70037_a(p_70037_1_);
/*  47 */     String str = "";
/*  48 */     if (p_70037_1_.func_150297_b("OwnerUUID", 8)) {
/*  49 */       str = p_70037_1_.func_74779_i("OwnerUUID");
/*     */     } else {
/*  51 */       String str1 = p_70037_1_.func_74779_i("Owner");
/*  52 */       str = PreYggdrasilConverter.func_152719_a(str1);
/*     */     } 
/*  54 */     if (str.length() > 0) {
/*  55 */       func_152115_b(str);
/*  56 */       func_70903_f(true);
/*     */     } 
/*  58 */     this.field_70911_d.func_75270_a(p_70037_1_.func_74767_n("Sitting"));
/*  59 */     func_70904_g(p_70037_1_.func_74767_n("Sitting"));
/*     */   }
/*     */   
/*     */   protected void func_70908_e(boolean p_70908_1_) {
/*  63 */     String str = "heart";
/*  64 */     if (!p_70908_1_) {
/*  65 */       str = "smoke";
/*     */     }
/*  67 */     for (byte b = 0; b < 7; b++) {
/*  68 */       double d1 = this.field_70146_Z.nextGaussian() * 0.02D;
/*  69 */       double d2 = this.field_70146_Z.nextGaussian() * 0.02D;
/*  70 */       double d3 = this.field_70146_Z.nextGaussian() * 0.02D;
/*  71 */       this.field_70170_p.func_72869_a(str, this.field_70165_t + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, this.field_70163_u + 0.5D + (this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - this.field_70130_N, d1, d2, d3);
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70103_a(byte p_70103_1_) {
/*  77 */     if (p_70103_1_ == 7) {
/*  78 */       func_70908_e(true);
/*  79 */     } else if (p_70103_1_ == 6) {
/*  80 */       func_70908_e(false);
/*     */     } else {
/*  82 */       super.func_70103_a(p_70103_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_70909_n() {
/*  87 */     return ((this.field_70180_af.func_75683_a(16) & 0x4) != 0);
/*     */   }
/*     */   
/*     */   public void func_70903_f(boolean p_70903_1_) {
/*  91 */     byte b = this.field_70180_af.func_75683_a(16);
/*  92 */     if (p_70903_1_) {
/*  93 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b | 0x4)));
/*     */     } else {
/*  95 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b & 0xFFFFFFFB)));
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_70906_o() {
/* 100 */     return ((this.field_70180_af.func_75683_a(16) & 0x1) != 0);
/*     */   }
/*     */   
/*     */   public void func_70904_g(boolean p_70904_1_) {
/* 104 */     byte b = this.field_70180_af.func_75683_a(16);
/* 105 */     if (p_70904_1_) {
/* 106 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b | 0x1)));
/*     */     } else {
/* 108 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b & 0xFFFFFFFE)));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_152113_b() {
/* 114 */     return this.field_70180_af.func_75681_e(17);
/*     */   }
/*     */   
/*     */   public void func_152115_b(String p_152115_1_) {
/* 118 */     this.field_70180_af.func_75692_b(17, p_152115_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityLivingBase func_70902_q() {
/*     */     try {
/* 124 */       UUID uUID = UUID.fromString(func_152113_b());
/* 125 */       if (uUID == null) {
/* 126 */         return null;
/*     */       }
/* 128 */       return (EntityLivingBase)this.field_70170_p.func_152378_a(uUID);
/* 129 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 130 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_152114_e(EntityLivingBase p_152114_1_) {
/* 135 */     return (p_152114_1_ == func_70902_q());
/*     */   }
/*     */   
/*     */   public EntityAISit func_70907_r() {
/* 139 */     return this.field_70911_d;
/*     */   }
/*     */   
/*     */   public boolean func_142018_a(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_) {
/* 143 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Team func_96124_cp() {
/* 148 */     if (func_70909_n()) {
/* 149 */       EntityLivingBase entityLivingBase = func_70902_q();
/* 150 */       if (entityLivingBase != null) {
/* 151 */         return entityLivingBase.func_96124_cp();
/*     */       }
/*     */     } 
/* 154 */     return super.func_96124_cp();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_142014_c(EntityLivingBase p_142014_1_) {
/* 159 */     if (func_70909_n()) {
/* 160 */       EntityLivingBase entityLivingBase = func_70902_q();
/* 161 */       if (p_142014_1_ == entityLivingBase) {
/* 162 */         return true;
/*     */       }
/* 164 */       if (entityLivingBase != null) {
/* 165 */         return entityLivingBase.func_142014_c(p_142014_1_);
/*     */       }
/*     */     } 
/* 168 */     return super.func_142014_c(p_142014_1_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\passive\EntityTameable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */