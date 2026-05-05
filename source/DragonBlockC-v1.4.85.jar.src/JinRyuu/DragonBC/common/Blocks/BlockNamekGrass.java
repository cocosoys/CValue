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
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockNamekGrass
/*     */   extends Block
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon iconGrassTop;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon iconSnowSide;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon iconGrassSideOverlay;
/*     */   
/*     */   public BlockNamekGrass() {
/*  37 */     super(Material.field_151577_b);
/*  38 */     func_149675_a(true);
/*  39 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*  40 */     setHarvestLevel("shovel", 0);
/*     */   }
/*     */   
/*     */   public String getTextureFile() {
/*  44 */     return "jinryuudragonbc:";
/*     */   }
/*     */ 
/*     */   
/*     */   public void addCreativeItems(ArrayList<ItemStack> itemList) {
/*  49 */     itemList.add(new ItemStack(this, 1));
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int par1, int par2) {
/*  62 */     return (par1 == 1) ? this.iconGrassTop : ((par1 == 0) ? BlocksDBC.BlockNamekDirt.func_149733_h(par1) : this.field_149761_L);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149673_e(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
/*  68 */     if (par5 == 1)
/*     */     {
/*  70 */       return this.iconGrassTop;
/*     */     }
/*  72 */     if (par5 == 0)
/*     */     {
/*  74 */       return BlocksDBC.BlockNamekDirt.func_149733_h(par5);
/*     */     }
/*     */ 
/*     */     
/*  78 */     return this.field_149761_L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/*  85 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a() + "Side");
/*  86 */     this.iconGrassTop = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a() + "Top");
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
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 131 */     if (!p_149674_1_.field_72995_K)
/*     */     {
/* 133 */       if (p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) < 4 && p_149674_1_.getBlockLightOpacity(p_149674_2_, p_149674_3_ + 1, p_149674_4_) > 2) {
/*     */         
/* 135 */         p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_, p_149674_4_, BlocksDBC.BlockNamekDirt);
/*     */       }
/* 137 */       else if (p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9) {
/*     */         
/* 139 */         for (int l = 0; l < 4; l++) {
/*     */           
/* 141 */           int i1 = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
/* 142 */           int j1 = p_149674_3_ + p_149674_5_.nextInt(5) - 3;
/* 143 */           int k1 = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
/* 144 */           Block block = p_149674_1_.func_147439_a(i1, j1 + 1, k1);
/*     */           
/* 146 */           if ((p_149674_1_.func_147439_a(i1, j1, k1) == BlocksDBC.BlockNamekDirt || p_149674_1_.func_147439_a(i1, j1, k1) == Blocks.field_150346_d) && p_149674_1_.func_72805_g(i1, j1, k1) == 0 && p_149674_1_.func_72957_l(i1, j1 + 1, k1) >= 4 && p_149674_1_.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
/*     */           {
/* 148 */             p_149674_1_.func_147449_b(i1, j1, k1, BlocksDBC.BlockNamekGrass);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 156 */     return BlocksDBC.BlockNamekDirt.func_149650_a(0, p_149650_2_, p_149650_3_);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockNamekGrass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */