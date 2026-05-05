/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.monster.EntityIronGolem;
/*     */ import net.minecraft.entity.monster.EntitySnowman;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockPumpkin extends BlockDirectional {
/*     */   private boolean field_149985_a;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149984_b;
/*     */   
/*     */   protected BlockPumpkin(boolean p_i45419_1_) {
/*  25 */     super(Material.field_151572_C);
/*  26 */     func_149675_a(true);
/*  27 */     this.field_149985_a = p_i45419_1_;
/*  28 */     func_149647_a(CreativeTabs.field_78030_b);
/*     */   } @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149986_M; private static final String __OBFID = "CL_00000291";
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  33 */     if (p_149691_1_ == 1) return this.field_149984_b; 
/*  34 */     if (p_149691_1_ == 0) return this.field_149984_b;
/*     */     
/*  36 */     if (p_149691_2_ == 2 && p_149691_1_ == 2) return this.field_149986_M; 
/*  37 */     if (p_149691_2_ == 3 && p_149691_1_ == 5) return this.field_149986_M; 
/*  38 */     if (p_149691_2_ == 0 && p_149691_1_ == 3) return this.field_149986_M; 
/*  39 */     if (p_149691_2_ == 1 && p_149691_1_ == 4) return this.field_149986_M;
/*     */     
/*  41 */     return this.field_149761_L;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/*  46 */     super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/*  47 */     if (p_149726_1_.func_147439_a(p_149726_2_, p_149726_3_ - 1, p_149726_4_) == Blocks.field_150433_aE && p_149726_1_.func_147439_a(p_149726_2_, p_149726_3_ - 2, p_149726_4_) == Blocks.field_150433_aE) {
/*  48 */       if (!p_149726_1_.field_72995_K) {
/*  49 */         p_149726_1_.func_147465_d(p_149726_2_, p_149726_3_, p_149726_4_, func_149729_e(0), 0, 2);
/*  50 */         p_149726_1_.func_147465_d(p_149726_2_, p_149726_3_ - 1, p_149726_4_, func_149729_e(0), 0, 2);
/*  51 */         p_149726_1_.func_147465_d(p_149726_2_, p_149726_3_ - 2, p_149726_4_, func_149729_e(0), 0, 2);
/*  52 */         EntitySnowman entitySnowman = new EntitySnowman(p_149726_1_);
/*  53 */         entitySnowman.func_70012_b(p_149726_2_ + 0.5D, p_149726_3_ - 1.95D, p_149726_4_ + 0.5D, 0.0F, 0.0F);
/*  54 */         p_149726_1_.func_72838_d((Entity)entitySnowman);
/*     */         
/*  56 */         p_149726_1_.func_147444_c(p_149726_2_, p_149726_3_, p_149726_4_, func_149729_e(0));
/*  57 */         p_149726_1_.func_147444_c(p_149726_2_, p_149726_3_ - 1, p_149726_4_, func_149729_e(0));
/*  58 */         p_149726_1_.func_147444_c(p_149726_2_, p_149726_3_ - 2, p_149726_4_, func_149729_e(0));
/*     */       } 
/*  60 */       for (byte b = 0; b < 120; b++) {
/*  61 */         p_149726_1_.func_72869_a("snowshovel", p_149726_2_ + p_149726_1_.field_73012_v.nextDouble(), (p_149726_3_ - 2) + p_149726_1_.field_73012_v.nextDouble() * 2.5D, p_149726_4_ + p_149726_1_.field_73012_v.nextDouble(), 0.0D, 0.0D, 0.0D);
/*     */       }
/*  63 */     } else if (p_149726_1_.func_147439_a(p_149726_2_, p_149726_3_ - 1, p_149726_4_) == Blocks.field_150339_S && p_149726_1_.func_147439_a(p_149726_2_, p_149726_3_ - 2, p_149726_4_) == Blocks.field_150339_S) {
/*     */       
/*  65 */       boolean bool1 = (p_149726_1_.func_147439_a(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_) == Blocks.field_150339_S && p_149726_1_.func_147439_a(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_) == Blocks.field_150339_S) ? true : false;
/*  66 */       boolean bool2 = (p_149726_1_.func_147439_a(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1) == Blocks.field_150339_S && p_149726_1_.func_147439_a(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1) == Blocks.field_150339_S) ? true : false;
/*  67 */       if (bool1 || bool2) {
/*  68 */         p_149726_1_.func_147465_d(p_149726_2_, p_149726_3_, p_149726_4_, func_149729_e(0), 0, 2);
/*  69 */         p_149726_1_.func_147465_d(p_149726_2_, p_149726_3_ - 1, p_149726_4_, func_149729_e(0), 0, 2);
/*  70 */         p_149726_1_.func_147465_d(p_149726_2_, p_149726_3_ - 2, p_149726_4_, func_149729_e(0), 0, 2);
/*  71 */         if (bool1) {
/*  72 */           p_149726_1_.func_147465_d(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, func_149729_e(0), 0, 2);
/*  73 */           p_149726_1_.func_147465_d(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, func_149729_e(0), 0, 2);
/*     */         } else {
/*  75 */           p_149726_1_.func_147465_d(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, func_149729_e(0), 0, 2);
/*  76 */           p_149726_1_.func_147465_d(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, func_149729_e(0), 0, 2);
/*     */         } 
/*     */         
/*  79 */         EntityIronGolem entityIronGolem = new EntityIronGolem(p_149726_1_);
/*  80 */         entityIronGolem.func_70849_f(true);
/*  81 */         entityIronGolem.func_70012_b(p_149726_2_ + 0.5D, p_149726_3_ - 1.95D, p_149726_4_ + 0.5D, 0.0F, 0.0F);
/*  82 */         p_149726_1_.func_72838_d((Entity)entityIronGolem);
/*     */         
/*  84 */         for (byte b = 0; b < 120; b++) {
/*  85 */           p_149726_1_.func_72869_a("snowballpoof", p_149726_2_ + p_149726_1_.field_73012_v.nextDouble(), (p_149726_3_ - 2) + p_149726_1_.field_73012_v.nextDouble() * 3.9D, p_149726_4_ + p_149726_1_.field_73012_v.nextDouble(), 0.0D, 0.0D, 0.0D);
/*     */         }
/*     */         
/*  88 */         p_149726_1_.func_147444_c(p_149726_2_, p_149726_3_, p_149726_4_, func_149729_e(0));
/*  89 */         p_149726_1_.func_147444_c(p_149726_2_, p_149726_3_ - 1, p_149726_4_, func_149729_e(0));
/*  90 */         p_149726_1_.func_147444_c(p_149726_2_, p_149726_3_ - 2, p_149726_4_, func_149729_e(0));
/*  91 */         if (bool1) {
/*  92 */           p_149726_1_.func_147444_c(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, func_149729_e(0));
/*  93 */           p_149726_1_.func_147444_c(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, func_149729_e(0));
/*     */         } else {
/*  95 */           p_149726_1_.func_147444_c(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, func_149729_e(0));
/*  96 */           p_149726_1_.func_147444_c(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, func_149729_e(0));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/* 104 */     return ((p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_, p_149742_4_)).field_149764_J.func_76222_j() && World.func_147466_a((IBlockAccess)p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/* 109 */     int i = MathHelper.func_76128_c((p_149689_5_.field_70177_z * 4.0F / 360.0F) + 2.5D) & 0x3;
/* 110 */     p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, i, 2);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 115 */     this.field_149986_M = p_149651_1_.func_94245_a(func_149641_N() + "_face_" + (this.field_149985_a ? "on" : "off"));
/* 116 */     this.field_149984_b = p_149651_1_.func_94245_a(func_149641_N() + "_top");
/* 117 */     this.field_149761_L = p_149651_1_.func_94245_a(func_149641_N() + "_side");
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockPumpkin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */