/*     */ package JinRyuu.DragonBC.common.Blocks;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockLeavesBase;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.IShearable;
/*     */ 
/*     */ public class BlockNamekLeaves
/*     */   extends BlockLeavesBase implements IShearable {
/*     */   int[] adjacentTreeBlocks;
/*     */   
/*     */   public String getTextureFile() {
/*  25 */     return "jinryuudragonbc:";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockNamekLeaves(int par2) {
/*  32 */     super(Material.field_151584_j, true);
/*  33 */     func_149675_a(true);
/*  34 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addCreativeItems(ArrayList<ItemStack> itemList) {
/*  39 */     itemList.add(new ItemStack((Block)this, 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149701_w() {
/*  44 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/*  51 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149635_D() {
/*  58 */     double d0 = 0.5D;
/*  59 */     double d1 = 1.0D;
/*  60 */     return 16777215;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149741_i(int p_149741_1_) {
/*  66 */     return 16777215;
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
/*     */   public void onBlockRemoval(World par1World, int par2, int par3, int par4) {
/*  78 */     byte var5 = 1;
/*  79 */     int var6 = var5 + 1;
/*     */     
/*  81 */     if (par1World.func_72904_c(par2 - var6, par3 - var6, par4 - var6, par2 + var6, par3 + var6, par4 + var6))
/*     */     {
/*  83 */       for (int var7 = -var5; var7 <= var5; var7++) {
/*     */         
/*  85 */         for (int var8 = -var5; var8 <= var5; var8++) {
/*     */           
/*  87 */           for (int var9 = -var5; var9 <= var5; var9++) {
/*     */             
/*  89 */             Block var10 = par1World.func_147439_a(par2 + var7, par3 + var8, par4 + var9);
/*     */             
/*  91 */             if (var10 != null)
/*     */             {
/*  93 */               var10.beginLeavesDecay(par1World, par2 + var7, par3 + var8, par4 + var9);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
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
/*     */   public int func_149745_a(Random p_149745_1_) {
/* 229 */     return (p_149745_1_.nextInt(20) == 0) ? 1 : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 237 */     return Item.func_150898_a((Block)BlocksDBC.BlockNamekSapling);
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
/*     */   public void func_149636_a(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
/* 272 */     super.func_149636_a(par1World, par2EntityPlayer, par3, par4, par5, par6);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int par1) {
/* 280 */     return par1 & 0x3;
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
/*     */   public void func_149724_b(World par1World, int par2, int par3, int par4, Entity par5Entity) {
/* 299 */     super.func_149724_b(par1World, par2, par3, par4, par5Entity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
/* 305 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
/* 311 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/* 312 */     ret.add(new ItemStack((Block)this, 1, world.func_72805_g(x, y, z) & 0x3));
/* 313 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockNamekLeaves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */