/*     */ package JinRyuu.JRMCore.blocks;
/*     */ 
/*     */ import JinRyuu.JRMCore.mod_JRMCore;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.BlockFence;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockJRMCFence
/*     */   extends BlockFence
/*     */ {
/*     */   private String tex;
/*     */   
/*     */   public BlockJRMCFence(String tex) {
/*  24 */     super("", Material.field_151573_f);
/*  25 */     func_149722_s();
/*  26 */     func_149752_b(6000000.0F);
/*  27 */     func_149647_a(mod_JRMCore.JRMCore);
/*  28 */     this.tex = tex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149743_a(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
/*  37 */     boolean flag = func_149826_e((IBlockAccess)par1World, par2, par3, par4 - 1);
/*  38 */     boolean flag1 = func_149826_e((IBlockAccess)par1World, par2, par3, par4 + 1);
/*  39 */     boolean flag2 = func_149826_e((IBlockAccess)par1World, par2 - 1, par3, par4);
/*  40 */     boolean flag3 = func_149826_e((IBlockAccess)par1World, par2 + 1, par3, par4);
/*  41 */     float f = 0.375F;
/*  42 */     float f1 = 0.625F;
/*  43 */     float f2 = 0.375F;
/*  44 */     float f3 = 0.625F;
/*     */     
/*  46 */     if (flag)
/*     */     {
/*  48 */       f2 = 0.0F;
/*     */     }
/*     */     
/*  51 */     if (flag1)
/*     */     {
/*  53 */       f3 = 1.0F;
/*     */     }
/*     */     
/*  56 */     if (flag || flag1) {
/*     */       
/*  58 */       func_149676_a(f, 0.0F, f2, f1, 1.5F, f3);
/*  59 */       super.func_149743_a(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
/*     */     } 
/*     */     
/*  62 */     f2 = 0.375F;
/*  63 */     f3 = 0.625F;
/*     */     
/*  65 */     if (flag2)
/*     */     {
/*  67 */       f = 0.0F;
/*     */     }
/*     */     
/*  70 */     if (flag3)
/*     */     {
/*  72 */       f1 = 1.0F;
/*     */     }
/*     */     
/*  75 */     if (flag2 || flag3 || (!flag && !flag1)) {
/*     */       
/*  77 */       func_149676_a(f, 0.0F, f2, f1, 1.5F, f3);
/*  78 */       super.func_149743_a(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
/*     */     } 
/*     */     
/*  81 */     if (flag)
/*     */     {
/*  83 */       f2 = 0.0F;
/*     */     }
/*     */     
/*  86 */     if (flag1)
/*     */     {
/*  88 */       f3 = 1.0F;
/*     */     }
/*     */     
/*  91 */     func_149676_a(f, 0.0F, f2, f1, 1.0F, f3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/*  99 */     boolean flag = func_149826_e(par1IBlockAccess, par2, par3, par4 - 1);
/* 100 */     boolean flag1 = func_149826_e(par1IBlockAccess, par2, par3, par4 + 1);
/* 101 */     boolean flag2 = func_149826_e(par1IBlockAccess, par2 - 1, par3, par4);
/* 102 */     boolean flag3 = func_149826_e(par1IBlockAccess, par2 + 1, par3, par4);
/* 103 */     float f = 0.375F;
/* 104 */     float f1 = 0.625F;
/* 105 */     float f2 = 0.375F;
/* 106 */     float f3 = 0.625F;
/*     */     
/* 108 */     if (flag)
/*     */     {
/* 110 */       f2 = 0.0F;
/*     */     }
/*     */     
/* 113 */     if (flag1)
/*     */     {
/* 115 */       f3 = 1.0F;
/*     */     }
/*     */     
/* 118 */     if (flag2)
/*     */     {
/* 120 */       f = 0.0F;
/*     */     }
/*     */     
/* 123 */     if (flag3)
/*     */     {
/* 125 */       f1 = 1.0F;
/*     */     }
/*     */     
/* 128 */     func_149676_a(f, 0.0F, f2, f1, 1.0F, f3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 137 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 145 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 150 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 158 */     return 11;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
/* 192 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/* 199 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuumodscore:" + this.tex);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random par1Random) {
/* 205 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149701_w() {
/* 231 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\blocks\BlockJRMCFence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */