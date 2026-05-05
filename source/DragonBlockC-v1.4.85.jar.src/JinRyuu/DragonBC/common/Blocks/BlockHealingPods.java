/*     */ package JinRyuu.DragonBC.common.Blocks;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fluids.BlockFluidClassic;
/*     */ import net.minecraftforge.fluids.Fluid;
/*     */ 
/*     */ public class BlockHealingPods
/*     */   extends BlockFluidClassic {
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected IIcon stillIcon;
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected IIcon flowingIcon;
/*     */   
/*     */   public BlockHealingPods(Fluid fluid, Material material) {
/*  24 */     super(fluid, material);
/*  25 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  31 */     return (side == 0 || side == 1) ? this.stillIcon : this.flowingIcon;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister register) {
/*  37 */     this.stillIcon = register.func_94245_a(JRMCoreH.tjdbcAssts + ":" + func_149739_a() + "Still");
/*  38 */     this.flowingIcon = register.func_94245_a(JRMCoreH.tjdbcAssts + ":" + func_149739_a() + "Flowing");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
/*  43 */     if (world.func_147439_a(x, y, z).func_149688_o().func_76224_d()) return false; 
/*  44 */     return super.canDisplace(world, x, y, z);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean displaceIfPossible(World world, int x, int y, int z) {
/*  49 */     if (world.func_147439_a(x, y, z).func_149688_o().func_76224_d()) return false; 
/*  50 */     return super.displaceIfPossible(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
/*  62 */     if (this.field_149764_J == Material.field_151586_h) {
/*     */       
/*  64 */       if (p_149734_5_.nextInt(10) == 0) {
/*     */         
/*  66 */         int i = p_149734_1_.func_72805_g(p_149734_2_, p_149734_3_, p_149734_4_);
/*     */         
/*  68 */         if (i <= 0 || i >= 8)
/*     */         {
/*  70 */           p_149734_1_.func_72869_a("suspended", (p_149734_2_ + p_149734_5_.nextFloat()), (p_149734_3_ + p_149734_5_.nextFloat()), (p_149734_4_ + p_149734_5_.nextFloat()), 0.0D, 0.0D, 0.0D);
/*     */         }
/*     */       } 
/*     */       
/*  74 */       for (int l = 0; l < 0; l++) {
/*     */         
/*  76 */         int i1 = p_149734_5_.nextInt(4);
/*  77 */         int j1 = p_149734_2_;
/*  78 */         int k1 = p_149734_4_;
/*     */         
/*  80 */         if (i1 == 0)
/*     */         {
/*  82 */           j1 = p_149734_2_ - 1;
/*     */         }
/*     */         
/*  85 */         if (i1 == 1)
/*     */         {
/*  87 */           j1++;
/*     */         }
/*     */         
/*  90 */         if (i1 == 2)
/*     */         {
/*  92 */           k1 = p_149734_4_ - 1;
/*     */         }
/*     */         
/*  95 */         if (i1 == 3)
/*     */         {
/*  97 */           k1++;
/*     */         }
/*     */         
/* 100 */         if (p_149734_1_.func_147439_a(j1, p_149734_3_, k1).func_149688_o() == Material.field_151579_a && (p_149734_1_.func_147439_a(j1, p_149734_3_ - 1, k1).func_149688_o().func_76230_c() || p_149734_1_.func_147439_a(j1, p_149734_3_ - 1, k1).func_149688_o().func_76224_d())) {
/*     */           
/* 102 */           float f = 0.0625F;
/* 103 */           double d0 = (p_149734_2_ + p_149734_5_.nextFloat());
/* 104 */           double d1 = (p_149734_3_ + p_149734_5_.nextFloat());
/* 105 */           double d2 = (p_149734_4_ + p_149734_5_.nextFloat());
/*     */           
/* 107 */           if (i1 == 0)
/*     */           {
/* 109 */             d0 = (p_149734_2_ - f);
/*     */           }
/*     */           
/* 112 */           if (i1 == 1)
/*     */           {
/* 114 */             d0 = ((p_149734_2_ + 1) + f);
/*     */           }
/*     */           
/* 117 */           if (i1 == 2)
/*     */           {
/* 119 */             d2 = (p_149734_4_ - f);
/*     */           }
/*     */           
/* 122 */           if (i1 == 3)
/*     */           {
/* 124 */             d2 = ((p_149734_4_ + 1) + f);
/*     */           }
/*     */           
/* 127 */           double d3 = 0.0D;
/* 128 */           double d4 = 0.0D;
/*     */           
/* 130 */           if (i1 == 0)
/*     */           {
/* 132 */             d3 = -f;
/*     */           }
/*     */           
/* 135 */           if (i1 == 1)
/*     */           {
/* 137 */             d3 = f;
/*     */           }
/*     */           
/* 140 */           if (i1 == 2)
/*     */           {
/* 142 */             d4 = -f;
/*     */           }
/*     */           
/* 145 */           if (i1 == 3)
/*     */           {
/* 147 */             d4 = f;
/*     */           }
/*     */           
/* 150 */           p_149734_1_.func_72869_a("splash", d0, d1, d2, d3, 0.0D, d4);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 155 */     if (this.field_149764_J == Material.field_151586_h && p_149734_5_.nextInt(64) == 0) {
/*     */       
/* 157 */       int l = p_149734_1_.func_72805_g(p_149734_2_, p_149734_3_, p_149734_4_);
/*     */       
/* 159 */       if (l > 0 && l < 8)
/*     */       {
/* 161 */         p_149734_1_.func_72980_b((p_149734_2_ + 0.5F), (p_149734_3_ + 0.5F), (p_149734_4_ + 0.5F), "liquid.water", p_149734_5_.nextFloat() * 0.25F + 0.75F, p_149734_5_.nextFloat() * 1.0F + 0.5F, false);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 169 */     if (this.field_149764_J == Material.field_151587_i && p_149734_1_.func_147439_a(p_149734_2_, p_149734_3_ + 1, p_149734_4_).func_149688_o() == Material.field_151579_a && !p_149734_1_.func_147439_a(p_149734_2_, p_149734_3_ + 1, p_149734_4_).func_149662_c()) {
/*     */       
/* 171 */       if (p_149734_5_.nextInt(100) == 0) {
/*     */         
/* 173 */         double d5 = (p_149734_2_ + p_149734_5_.nextFloat());
/* 174 */         double d6 = p_149734_3_ + this.field_149756_F;
/* 175 */         double d7 = (p_149734_4_ + p_149734_5_.nextFloat());
/* 176 */         p_149734_1_.func_72869_a("lava", d5, d6, d7, 0.0D, 0.0D, 0.0D);
/* 177 */         p_149734_1_.func_72980_b(d5, d6, d7, "liquid.lavapop", 0.2F + p_149734_5_.nextFloat() * 0.2F, 0.9F + p_149734_5_.nextFloat() * 0.15F, false);
/*     */       } 
/*     */       
/* 180 */       if (p_149734_5_.nextInt(200) == 0)
/*     */       {
/* 182 */         p_149734_1_.func_72980_b(p_149734_2_, p_149734_3_, p_149734_4_, "liquid.lava", 0.2F + p_149734_5_.nextFloat() * 0.2F, 0.9F + p_149734_5_.nextFloat() * 0.15F, false);
/*     */       }
/*     */     } 
/*     */     
/* 186 */     if (p_149734_5_.nextInt(10) == 0 && World.func_147466_a((IBlockAccess)p_149734_1_, p_149734_2_, p_149734_3_ - 1, p_149734_4_) && !p_149734_1_.func_147439_a(p_149734_2_, p_149734_3_ - 2, p_149734_4_).func_149688_o().func_76230_c()) {
/*     */       
/* 188 */       double d5 = (p_149734_2_ + p_149734_5_.nextFloat());
/* 189 */       double d6 = p_149734_3_ - 1.05D;
/* 190 */       double d7 = (p_149734_4_ + p_149734_5_.nextFloat());
/*     */       
/* 192 */       if (this.field_149764_J == Material.field_151586_h) {
/*     */         
/* 194 */         p_149734_1_.func_72869_a("dripWater", d5, d6, d7, 0.0D, 0.0D, 0.0D);
/*     */       }
/*     */       else {
/*     */         
/* 198 */         p_149734_1_.func_72869_a("dripLava", d5, d6, d7, 0.0D, 0.0D, 0.0D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockHealingPods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */