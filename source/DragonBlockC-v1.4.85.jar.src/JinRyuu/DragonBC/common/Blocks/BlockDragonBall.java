/*     */ package JinRyuu.DragonBC.common.Blocks;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class BlockDragonBall
/*     */   extends Block
/*     */ {
/*  16 */   protected int maxStackSize = 7;
/*     */ 
/*     */   
/*     */   public BlockDragonBall setMaxStackSize(int par1) {
/*  20 */     this.maxStackSize = par1;
/*  21 */     return this;
/*     */   }
/*     */   
/*     */   public int getItemStackLimit() {
/*  25 */     return this.maxStackSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockDragonBall() {
/*  30 */     super(DBCMaterial.dragonblock);
/*     */     
/*  32 */     func_149675_a(true);
/*  33 */     func_149711_c(0.1F);
/*  34 */     float var4 = 0.2F;
/*  35 */     func_149676_a(0.5F - var4, 0.2F - var4, 0.5F - var4, 0.5F + var4, 0.2F + var4, 0.5F + var4);
/*     */     
/*  37 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/*  43 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
/*     */   }
/*     */   
/*     */   public void func_149674_a(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  47 */     if (!par1World.field_72995_K) {
/*  48 */       if (par1World.func_147439_a(par2 + 1, par3, par4) == this) {
/*  49 */         if (par1World.func_147439_a(par2 + 1, par3, par4 + 1) == this && 
/*  50 */           par1World.func_147439_a(par2 + 1, par3, par4 - 1) == this && 
/*  51 */           par1World.func_147439_a(par2 - 1, par3, par4) == this && 
/*  52 */           par1World.func_147439_a(par2 - 1, par3, par4 - 1) == this && 
/*  53 */           par1World.func_147439_a(par2 - 1, par3, par4 + 1) == this)
/*     */         {
/*  55 */           par1World.func_147449_b(par2, par3, par4, BlocksDBC.BlockDragonBallStone);
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */       
/*     */       }
/*  63 */       else if (par1World.func_147439_a(par2, par3, par4 + 1) == this && 
/*  64 */         par1World.func_147439_a(par2 + 1, par3, par4 + 1) == this && 
/*  65 */         par1World.func_147439_a(par2 + 1, par3, par4 - 1) == this && 
/*  66 */         par1World.func_147439_a(par2, par3, par4 - 1) == this && 
/*  67 */         par1World.func_147439_a(par2 - 1, par3, par4 - 1) == this && 
/*  68 */         par1World.func_147439_a(par2 - 1, par3, par4 + 1) == this) {
/*     */         
/*  70 */         par1World.func_147449_b(par2, par3, par4, BlocksDBC.BlockDragonBallStone);
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
/*     */   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
/* 128 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d() {
/* 132 */     return false;
/*     */   }
/*     */   
/*     */   public int func_149645_b() {
/* 136 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c() {
/* 140 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockDragonBall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */