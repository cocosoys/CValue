/*     */ package net.minecraft.entity.ai;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.pathfinding.PathFinder;
/*     */ import net.minecraft.pathfinding.PathPoint;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class EntityAIControlledByPlayer
/*     */   extends EntityAIBase
/*     */ {
/*     */   private final EntityLiving field_82640_a;
/*     */   private final float field_82638_b;
/*     */   private float field_82639_c;
/*     */   
/*     */   public EntityAIControlledByPlayer(EntityLiving p_i1620_1_, float p_i1620_2_) {
/*  25 */     this.field_82640_a = p_i1620_1_;
/*  26 */     this.field_82638_b = p_i1620_2_;
/*  27 */     func_75248_a(7);
/*     */   }
/*     */   private boolean field_82636_d; private int field_82637_e; private int field_82635_f; private static final String __OBFID = "CL_00001580";
/*     */   
/*     */   public void func_75249_e() {
/*  32 */     this.field_82639_c = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75251_c() {
/*  37 */     this.field_82636_d = false;
/*  38 */     this.field_82639_c = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75250_a() {
/*  43 */     return (this.field_82640_a.func_70089_S() && this.field_82640_a.field_70153_n != null && this.field_82640_a.field_70153_n instanceof EntityPlayer && (this.field_82636_d || this.field_82640_a.func_82171_bF()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75246_d() {
/*  48 */     EntityPlayer entityPlayer = (EntityPlayer)this.field_82640_a.field_70153_n;
/*  49 */     EntityCreature entityCreature = (EntityCreature)this.field_82640_a;
/*     */     
/*  51 */     float f1 = MathHelper.func_76142_g(entityPlayer.field_70177_z - this.field_82640_a.field_70177_z) * 0.5F;
/*  52 */     if (f1 > 5.0F) f1 = 5.0F; 
/*  53 */     if (f1 < -5.0F) f1 = -5.0F;
/*     */     
/*  55 */     this.field_82640_a.field_70177_z = MathHelper.func_76142_g(this.field_82640_a.field_70177_z + f1);
/*  56 */     if (this.field_82639_c < this.field_82638_b) this.field_82639_c += (this.field_82638_b - this.field_82639_c) * 0.01F; 
/*  57 */     if (this.field_82639_c > this.field_82638_b) this.field_82639_c = this.field_82638_b;
/*     */     
/*  59 */     int i = MathHelper.func_76128_c(this.field_82640_a.field_70165_t);
/*  60 */     int j = MathHelper.func_76128_c(this.field_82640_a.field_70163_u);
/*  61 */     int k = MathHelper.func_76128_c(this.field_82640_a.field_70161_v);
/*  62 */     float f2 = this.field_82639_c;
/*  63 */     if (this.field_82636_d) {
/*  64 */       if (this.field_82637_e++ > this.field_82635_f) {
/*  65 */         this.field_82636_d = false;
/*     */       }
/*  67 */       f2 += f2 * 1.15F * MathHelper.func_76126_a(this.field_82637_e / this.field_82635_f * 3.1415927F);
/*     */     } 
/*     */     
/*  70 */     float f3 = 0.91F;
/*  71 */     if (this.field_82640_a.field_70122_E) {
/*  72 */       f3 = (this.field_82640_a.field_70170_p.func_147439_a(MathHelper.func_76141_d(i), MathHelper.func_76141_d(j) - 1, MathHelper.func_76141_d(k))).field_149765_K * 0.91F;
/*     */     }
/*  74 */     float f4 = 0.16277136F / f3 * f3 * f3;
/*  75 */     float f5 = MathHelper.func_76126_a(entityCreature.field_70177_z * 3.1415927F / 180.0F);
/*  76 */     float f6 = MathHelper.func_76134_b(entityCreature.field_70177_z * 3.1415927F / 180.0F);
/*  77 */     float f7 = entityCreature.func_70689_ay() * f4;
/*  78 */     float f8 = Math.max(f2, 1.0F);
/*  79 */     f8 = f7 / f8;
/*  80 */     float f9 = f2 * f8;
/*  81 */     float f10 = -(f9 * f5);
/*  82 */     float f11 = f9 * f6;
/*     */     
/*  84 */     if (MathHelper.func_76135_e(f10) > MathHelper.func_76135_e(f11)) {
/*  85 */       if (f10 < 0.0F) f10 -= this.field_82640_a.field_70130_N / 2.0F; 
/*  86 */       if (f10 > 0.0F) f10 += this.field_82640_a.field_70130_N / 2.0F; 
/*  87 */       f11 = 0.0F;
/*     */     } else {
/*  89 */       f10 = 0.0F;
/*  90 */       if (f11 < 0.0F) f11 -= this.field_82640_a.field_70130_N / 2.0F; 
/*  91 */       if (f11 > 0.0F) f11 += this.field_82640_a.field_70130_N / 2.0F;
/*     */     
/*     */     } 
/*  94 */     int m = MathHelper.func_76128_c(this.field_82640_a.field_70165_t + f10);
/*  95 */     int n = MathHelper.func_76128_c(this.field_82640_a.field_70161_v + f11);
/*     */     
/*  97 */     PathPoint pathPoint = new PathPoint(MathHelper.func_76141_d(this.field_82640_a.field_70130_N + 1.0F), MathHelper.func_76141_d(this.field_82640_a.field_70131_O + entityPlayer.field_70131_O + 1.0F), MathHelper.func_76141_d(this.field_82640_a.field_70130_N + 1.0F));
/*     */     
/*  99 */     if (i != m || k != n) {
/*     */ 
/*     */       
/* 102 */       Block block = this.field_82640_a.field_70170_p.func_147439_a(i, j, k);
/* 103 */       boolean bool = (!func_151498_a(block) && (block.func_149688_o() != Material.field_151579_a || !func_151498_a(this.field_82640_a.field_70170_p.func_147439_a(i, j - 1, k)))) ? true : false;
/*     */       
/* 105 */       if (bool && PathFinder.func_82565_a((Entity)this.field_82640_a, m, j, n, pathPoint, false, false, true) == 0 && PathFinder.func_82565_a((Entity)this.field_82640_a, i, j + 1, k, pathPoint, false, false, true) == 1 && PathFinder.func_82565_a((Entity)this.field_82640_a, m, j + 1, n, pathPoint, false, false, true) == 1)
/*     */       {
/* 107 */         entityCreature.func_70683_ar().func_75660_a();
/*     */       }
/*     */     } 
/*     */     
/* 111 */     if (!entityPlayer.field_71075_bZ.field_75098_d && this.field_82639_c >= this.field_82638_b * 0.5F && this.field_82640_a.func_70681_au().nextFloat() < 0.006F && !this.field_82636_d) {
/* 112 */       ItemStack itemStack = entityPlayer.func_70694_bm();
/*     */       
/* 114 */       if (itemStack != null && itemStack.func_77973_b() == Items.field_151146_bM) {
/* 115 */         itemStack.func_77972_a(1, (EntityLivingBase)entityPlayer);
/*     */         
/* 117 */         if (itemStack.field_77994_a == 0) {
/* 118 */           ItemStack itemStack1 = new ItemStack((Item)Items.field_151112_aM);
/* 119 */           itemStack1.func_77982_d(itemStack.field_77990_d);
/* 120 */           entityPlayer.field_71071_by.field_70462_a[entityPlayer.field_71071_by.field_70461_c] = itemStack1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 125 */     this.field_82640_a.func_70612_e(0.0F, f2);
/*     */   }
/*     */   
/*     */   private boolean func_151498_a(Block p_151498_1_) {
/* 129 */     return (p_151498_1_.func_149645_b() == 10 || p_151498_1_ instanceof net.minecraft.block.BlockSlab);
/*     */   }
/*     */   
/*     */   public boolean func_82634_f() {
/* 133 */     return this.field_82636_d;
/*     */   }
/*     */   
/*     */   public void func_82632_g() {
/* 137 */     this.field_82636_d = true;
/* 138 */     this.field_82637_e = 0;
/* 139 */     this.field_82635_f = this.field_82640_a.func_70681_au().nextInt(841) + 140;
/*     */   }
/*     */   
/*     */   public boolean func_82633_h() {
/* 143 */     return (!func_82634_f() && this.field_82639_c > this.field_82638_b * 0.3F);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIControlledByPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */