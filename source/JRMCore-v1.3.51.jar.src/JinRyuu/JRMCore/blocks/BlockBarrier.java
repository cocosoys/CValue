/*     */ package JinRyuu.JRMCore.blocks;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.mod_JRMCore;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.ITileEntityProvider;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockBarrier
/*     */   extends Block
/*     */   implements ITileEntityProvider
/*     */ {
/*     */   Class TileEntity;
/*     */   
/*     */   public BlockBarrier() {
/*  23 */     super(Material.field_151576_e);
/*  24 */     func_149647_a(mod_JRMCore.JRMCore);
/*  25 */     func_149711_c(-1.0F);
/*     */ 
/*     */     
/*  28 */     func_149752_b(6000000.0F);
/*  29 */     this.TileEntity = BlockBarrierTileEntity.class;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTextureFile() {
/*  34 */     return JRMCoreH.tjjrmc + ":";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149701_w() {
/*  43 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  52 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  60 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149678_a(int par1, boolean par2) {
/*  67 */     return true;
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
/*     */   public boolean func_149747_d(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/*  85 */     this.field_149761_L = par1IconRegister.func_94245_a(JRMCoreH.tjjrmc + ":" + func_149739_a());
/*     */   }
/*     */ 
/*     */   
/*     */   public int idDropped(int par1, Random par2Random, int par3) {
/*  90 */     return 0;
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/*  94 */     return new BlockBarrierTileEntity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int quanityDropped(Random random) {
/* 102 */     return 1;
/*     */   }
/*     */   
/*     */   public int func_149645_b() {
/* 106 */     return -1;
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
/*     */   public int tickRate() {
/* 125 */     return 1;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\blocks\BlockBarrier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */