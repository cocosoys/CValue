/*     */ package JinRyuu.DragonBC.common.Blocks.m;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.BlockLeaves;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ public class LeafyBlock
/*     */   extends BlockLeaves
/*     */ {
/*  22 */   public static final String[][] leaftypes = new String[][] { { "LeafSakura", "LeafMahagony" }, { "LeafSakuraOpaque", "LeafMahagonyOpaque" } };
/*  23 */   public static final String[] leaves = new String[] { "Sakura", "Mahagony" };
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
/*     */   public int func_149635_D() {
/*  38 */     double d0 = 0.5D;
/*  39 */     double d1 = 1.0D;
/*  40 */     return 16777215;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149741_i(int p_149741_1_) {
/*  46 */     return 16777215;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int i) {
/*  54 */     return super.func_149692_a(i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149643_k(World world, int x, int y, int z) {
/*  62 */     return world.func_72805_g(x, y, z) & 0x3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/*  71 */     for (int i = 0; i < leaves.length; i++) {
/*  72 */       list.add(new ItemStack(item, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister iconRegister) {
/*  79 */     for (int i = 0; i < leaftypes.length; i++) {
/*     */       
/*  81 */       this.field_150129_M[i] = new IIcon[(leaftypes[i]).length];
/*     */       
/*  83 */       for (int j = 0; j < (leaftypes[i]).length; j++)
/*     */       {
/*  85 */         this.field_150129_M[i][j] = iconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":" + leaftypes[i][j]);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  93 */     func_150122_b((Minecraft.func_71410_x()).field_71474_y.field_74347_j);
/*     */     
/*  95 */     return ((meta & 0x3) == 1) ? this.field_150129_M[this.field_150127_b][1] : this.field_150129_M[this.field_150127_b][0];
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] func_150125_e() {
/* 100 */     return leaves;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149646_a(IBlockAccess blockacces, int x, int y, int z, int side) {
/* 105 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 110 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 115 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 120 */     return Item.func_150898_a(ModdedBlocks.SakuraSaplings);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
/* 125 */     return 30;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
/* 130 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
/* 135 */     return 16777215;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\m\LeafyBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */