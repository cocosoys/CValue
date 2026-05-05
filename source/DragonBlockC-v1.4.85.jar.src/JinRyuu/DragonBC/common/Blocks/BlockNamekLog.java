/*     */ package JinRyuu.DragonBC.common.Blocks;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockNamekLog
/*     */   extends Block
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon iconGrassTop;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon iconSnowSide;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon iconGrassSideOverlay;
/*     */   
/*     */   public String getTextureFile() {
/*  28 */     return "jinryuudragonbc:";
/*     */   }
/*     */ 
/*     */   
/*     */   public void addCreativeItems(ArrayList<ItemStack> itemList) {
/*  33 */     itemList.add(new ItemStack(this, 1));
/*     */   }
/*     */   
/*     */   public BlockNamekLog() {
/*  37 */     super(Material.field_151575_d);
/*  38 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int par1, int par2) {
/*  45 */     return (par1 == 1) ? this.iconGrassTop : ((par1 == 0) ? this.iconGrassTop : this.field_149761_L);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149673_e(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
/*  50 */     if (par5 == 1)
/*     */     {
/*  52 */       return this.iconGrassTop;
/*     */     }
/*  54 */     if (par5 == 0)
/*     */     {
/*  56 */       return this.iconGrassTop;
/*     */     }
/*     */ 
/*     */     
/*  60 */     return this.field_149761_L;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/*  66 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a() + "Side");
/*  67 */     this.iconGrassTop = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a() + "Top");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  72 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  80 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/*  88 */     float var9 = 0.375F;
/*  89 */     float var10 = 0.625F;
/*  90 */     float var11 = 0.375F;
/*  91 */     float var12 = 0.625F;
/*     */     
/*  93 */     func_149676_a(var9, 0.0F, var11, var10, 1.0F, var12);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random par1Random) {
/* 101 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
/* 111 */     super.func_149636_a(par1World, par2EntityPlayer, par3, par4, par5, par6);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockRemoval(World par1World, int par2, int par3, int par4) {
/* 119 */     byte var5 = 4;
/* 120 */     int var6 = var5 + 1;
/*     */     
/* 122 */     if (par1World.func_72904_c(par2 - var6, par3 - var6, par4 - var6, par2 + var6, par3 + var6, par4 + var6))
/*     */     {
/* 124 */       for (int var7 = -var5; var7 <= var5; var7++) {
/*     */         
/* 126 */         for (int var8 = -var5; var8 <= var5; var8++) {
/*     */           
/* 128 */           for (int var9 = -var5; var9 <= var5; var9++) {
/*     */             
/* 130 */             Block var10 = par1World.func_147439_a(par2 + var7, par3 + var8, par4 + var9);
/*     */             
/* 132 */             if (var10 != null)
/*     */             {
/* 134 */               var10.beginLeavesDecay(par1World, par2 + var7, par3 + var8, par4 + var9);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 145 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int par1) {
/* 153 */     return par1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canSustainLeaves(World world, int x, int y, int z) {
/* 158 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isWood(World world, int x, int y, int z) {
/* 163 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockNamekLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */