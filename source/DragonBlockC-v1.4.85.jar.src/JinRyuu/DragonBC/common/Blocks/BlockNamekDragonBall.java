/*     */ package JinRyuu.DragonBC.common.Blocks;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockNamekDragonBall
/*     */   extends Block
/*     */ {
/*  20 */   protected int maxStackSize = 7;
/*     */   
/*     */   public BlockNamekDragonBall setMaxStackSize(int par1) {
/*  23 */     this.maxStackSize = par1;
/*  24 */     return this;
/*     */   }
/*     */   
/*     */   public int getItemStackLimit() {
/*  28 */     return this.maxStackSize;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/*  33 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
/*     */   }
/*     */   public BlockNamekDragonBall(int par1) {
/*  36 */     super(DBCMaterial.dragonblock);
/*     */     
/*  38 */     func_149675_a(true);
/*  39 */     func_149711_c(0.1F);
/*  40 */     float var4 = 0.4F;
/*  41 */     func_149676_a(0.5F - var4, 0.4F - var4, 0.5F - var4, 0.5F + var4, 0.4F + var4, 0.5F + var4);
/*     */ 
/*     */     
/*  44 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*     */   }
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t) {
/*  47 */     TileEntity tile_entity = world.func_147438_o(x, y, z);
/*     */     
/*  49 */     if (tile_entity == null || player.func_70093_af()) {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     if (!world.field_72995_K) {
/*  54 */       World par1World = world;
/*     */       
/*  56 */       if (par1World.func_147439_a(x + 1, y, z) == this) {
/*  57 */         if (par1World.func_147439_a(x + 1, y, z + 1) == this && 
/*  58 */           par1World.func_147439_a(x + 1, y, z - 1) == this && 
/*  59 */           par1World.func_147439_a(x - 1, y, z) == this && 
/*  60 */           par1World.func_147439_a(x - 1, y, z - 1) == this && 
/*  61 */           par1World.func_147439_a(x - 1, y, z + 1) == this) {
/*  62 */           par1World.func_147449_b(x, y, z, BlocksDBC.BlockDragonBallStone);
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */       
/*     */       }
/*  69 */       else if (par1World.func_147439_a(x, y, z + 1) == this && 
/*  70 */         par1World.func_147439_a(x + 1, y, z + 1) == this && 
/*  71 */         par1World.func_147439_a(x + 1, y, z - 1) == this && 
/*  72 */         par1World.func_147439_a(x, y, z - 1) == this && 
/*  73 */         par1World.func_147439_a(x - 1, y, z - 1) == this && 
/*  74 */         par1World.func_147439_a(x - 1, y, z + 1) == this) {
/*  75 */         par1World.func_147449_b(x, y, z, BlocksDBC.BlockDragonBallStone);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     return true;
/*     */   }
/*     */   public void func_149674_a(World par1World, int par2, int par3, int par4, Random par5Random) {
/*  88 */     if (!par1World.field_72995_K) {
/*  89 */       if (par1World.func_147439_a(par2 + 1, par3, par4) == this) {
/*  90 */         if (par1World.func_147439_a(par2 + 1, par3, par4 + 1) == this && 
/*  91 */           par1World.func_147439_a(par2 + 1, par3, par4 - 1) == this && 
/*  92 */           par1World.func_147439_a(par2 - 1, par3, par4) == this && 
/*  93 */           par1World.func_147439_a(par2 - 1, par3, par4 - 1) == this && 
/*  94 */           par1World.func_147439_a(par2 - 1, par3, par4 + 1) == this) {
/*  95 */           par1World.func_147449_b(par2, par3, par4, BlocksDBC.BlockDragonBallStone);
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */       
/*     */       }
/* 102 */       else if (par1World.func_147439_a(par2, par3, par4 + 1) == this && 
/* 103 */         par1World.func_147439_a(par2 + 1, par3, par4 + 1) == this && 
/* 104 */         par1World.func_147439_a(par2 + 1, par3, par4 - 1) == this && 
/* 105 */         par1World.func_147439_a(par2, par3, par4 - 1) == this && 
/* 106 */         par1World.func_147439_a(par2 - 1, par3, par4 - 1) == this && 
/* 107 */         par1World.func_147439_a(par2 - 1, par3, par4 + 1) == this) {
/* 108 */         par1World.func_147449_b(par2, par3, par4, BlocksDBC.BlockDragonBallStone);
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
/*     */   public void addCreativeItems(ArrayList<ItemStack> itemList) {
/* 120 */     itemList.add(new ItemStack(this, 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149679_a(int par1, Random par2Random) {
/* 128 */     return MathHelper.func_76125_a(func_149745_a(par2Random) + par2Random.nextInt(par1 + 1), 1, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random par1Random) {
/* 135 */     return 2 + par1Random.nextInt(3);
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
/*     */   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
/* 162 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d() {
/* 166 */     return false;
/*     */   }
/*     */   
/*     */   public int func_149645_b() {
/* 170 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c() {
/* 174 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockNamekDragonBall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */