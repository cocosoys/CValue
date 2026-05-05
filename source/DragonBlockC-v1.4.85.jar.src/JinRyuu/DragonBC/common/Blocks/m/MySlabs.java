/*     */ package JinRyuu.DragonBC.common.Blocks.m;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockSlab;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ public class MySlabs
/*     */   extends BlockSlab
/*     */ {
/*  25 */   public static final String[] woodType = new String[] { "Sakura", "Mahagony", "Maple" };
/*     */   
/*     */   private IIcon[] icon;
/*     */ 
/*     */   
/*     */   public MySlabs(boolean isDouble) {
/*  31 */     super(isDouble, Material.field_151575_d);
/*  32 */     func_149711_c(2.0F);
/*  33 */     func_149752_b(2.0F);
/*  34 */     func_149672_a(field_149766_f);
/*  35 */     setHarvestLevel("axe", 0);
/*  36 */     this.field_149783_u = true;
/*  37 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*  38 */     func_149663_c("Slab");
/*  39 */     if (isDouble == true)
/*     */     {
/*  41 */       func_149647_a(null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/*  50 */     for (int i = 0; i < woodType.length; i++) {
/*  51 */       list.add(new ItemStack(item, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_150002_b(int p_150002_1_) {
/*  57 */     return func_149739_a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private static boolean isBlockSingleSlab(Block block) {
/*  64 */     return (block == ModdedBlocks.SakuraSlabsSingle);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World world, int idk1, int idk2, int idk3) {
/*  71 */     return isBlockSingleSlab((Block)this) ? Item.func_150898_a((Block)this) : ((this == ModdedBlocks.SakuraSlabsDouble) ? Item.func_150898_a((Block)ModdedBlocks.SakuraSlabsSingle) : Item.func_150898_a((Block)ModdedBlocks.SakuraSlabsSingle));
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int par22, Random random, int par33) {
/*  76 */     return Item.func_150898_a((Block)ModdedBlocks.SakuraSlabsSingle);
/*     */   }
/*     */   
/*     */   protected ItemStack func_149644_j(int p_149644_1_) {
/*  80 */     return new ItemStack(Item.func_150898_a((Block)ModdedBlocks.SakuraSlabsSingle), 2, p_149644_1_ & 0x7);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister iconRegister) {
/*  87 */     this.icon = new IIcon[woodType.length];
/*     */     
/*  89 */     for (int i = 0; i < this.icon.length; i++)
/*     */     {
/*  91 */       this.icon[i] = iconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":Planks" + woodType[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  98 */     meta &= 0x7;
/*  99 */     if (meta > MathHelper.func_76125_a(meta, 0, 5)) meta = MathHelper.func_76125_a(meta, 0, 5); 
/* 100 */     return this.icon[MathHelper.func_76125_a(meta, 0, 5)];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
/* 107 */     return 40;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
/* 112 */     return 5;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\m\MySlabs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */