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
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockDragonBallStone
/*     */   extends Block
/*     */ {
/*     */   public BlockDragonBallStone() {
/*  20 */     super(DBCMaterial.dragonblock);
/*     */     
/*  22 */     func_149675_a(true);
/*  23 */     func_149711_c(1.0F);
/*  24 */     float var4 = 0.2F;
/*     */     
/*  26 */     func_149676_a(0.5F - var4, 0.2F - var4, 0.5F - var4, 0.5F + var4, var4 + 0.2F, 0.5F + var4);
/*  27 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int metadata, Random random, int fortune) {
/*  32 */     return Item.func_150898_a(BlocksDBC.BlockDragonBall);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/*  38 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
/*     */   }
/*     */   
/*  41 */   private static int tickDragonBall = 0;
/*     */   public void func_149674_a(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  43 */     if (!par1World.field_72995_K && 
/*  44 */       par5Random.nextInt(5) == 0) {
/*  45 */       par1World.func_147449_b(par2, par3, par4, BlocksDBC.BlockDragonBall);
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
/*     */   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
/* 105 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d() {
/* 109 */     return false;
/*     */   }
/*     */   
/*     */   public int func_149645_b() {
/* 113 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c() {
/* 117 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockDragonBallStone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */