/*     */ package JinRyuu.DragonBC.common.Blocks;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockNamekDragonBallStone
/*     */   extends Block
/*     */ {
/*     */   public BlockNamekDragonBallStone() {
/*  21 */     super(DBCMaterial.dragonblock);
/*     */     
/*  23 */     func_149675_a(true);
/*  24 */     func_149711_c(1.0F);
/*  25 */     float var4 = 0.4F;
/*     */     
/*  27 */     func_149676_a(0.5F - var4, 0.0F, 0.5F - var4, 0.5F + var4, 0.4F + var4, 0.5F + var4);
/*     */     
/*  29 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*     */   }
/*     */   
/*     */   public Item func_149650_a(int metadata, Random random, int fortune) {
/*  33 */     return Item.func_150898_a(BlocksDBC.BlockNamekDragonBall);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/*  39 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  44 */   private static int tickDragonBall = 0;
/*     */   public void func_149674_a(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  46 */     if (!par1World.field_72995_K)
/*     */     {
/*  48 */       if (par5Random.nextInt(5) == 0) {
/*  49 */         par1World.func_147465_d(par2, par3, par4, BlocksDBC.BlockNamekDragonBall, 0, 0);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149679_a(int par1, Random par2Random) {
/*  57 */     return MathHelper.func_76125_a(func_149745_a(par2Random) + par2Random.nextInt(par1 + 1), 1, 1);
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
/*     */   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
/* 110 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d() {
/* 114 */     return false;
/*     */   }
/*     */   
/*     */   public int func_149645_b() {
/* 118 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c() {
/* 122 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockNamekDragonBallStone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */