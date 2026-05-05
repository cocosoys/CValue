/*     */ package JinRyuu.JRMCore.blocks;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreConfig;
/*     */ import JinRyuu.JRMCore.mod_JRMCore;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ 
/*     */ public class BlockColoredStone
/*     */   extends Block
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] iconArray;
/*     */   private IIcon[] iconArrayS;
/*     */   private String tex;
/*     */   
/*     */   public BlockColoredStone(String tex) {
/*  27 */     super(Material.field_151573_f);
/*  28 */     func_149722_s();
/*  29 */     func_149752_b(6000000.0F);
/*  30 */     func_149647_a(mod_JRMCore.JRMCore);
/*  31 */     this.tex = tex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149701_w() {
/*  41 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  58 */     return JRMCoreConfig.BuildingBlocksRenderAsNormalBlock;
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
/*     */   public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
/*  72 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int par1, int par2) {
/*  83 */     return (par1 == 1) ? this.iconArray[par2 % this.iconArray.length] : ((par1 == 0) ? this.iconArray[par2 % this.iconArray.length] : ((par1 != 2 && par1 != 4) ? this.iconArray[par2 % this.iconArray.length] : this.iconArrayS[par2 % this.iconArrayS.length]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int par1) {
/*  93 */     return par1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getBlockFromDye(int par0) {
/*  98 */     return (par0 ^ 0xFFFFFFFF) & 0xF;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDyeFromBlock(int par0) {
/* 103 */     return (par0 ^ 0xFFFFFFFF) & 0xF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> par3List) {
/* 112 */     for (int j = 0; j < 16; j++) {
/* 113 */       par3List.add(new ItemStack(par1, 1, j));
/*     */     }
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
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/* 126 */     this.iconArray = new IIcon[16];
/* 127 */     this.iconArrayS = new IIcon[16];
/*     */     
/* 129 */     for (int i = 0; i < this.iconArray.length; i++) {
/*     */       
/* 131 */       this.iconArray[i] = par1IconRegister.func_94245_a("jinryuumodscore:" + this.tex + "_" + i);
/* 132 */       this.iconArrayS[i] = par1IconRegister.func_94245_a("jinryuumodscore:" + this.tex + "S_" + i);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\blocks\BlockColoredStone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */