/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.DBCMaterial;
/*     */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class DragonBlockNS01Block extends BlockContainer {
/*     */   private Class DragonBlockNS01TileEntity;
/*     */   private static int tickDragonBall = 0;
/*     */   int port1;
/*     */   
/*     */   public void func_149674_a(World par1World, int par2, int par3, int par4, Random par5Random) {
/*     */     if (!par1World.field_72995_K)
/*     */       if (par5Random.nextInt(5) == 0)
/*     */         par1World.func_147449_b(par2, par3, par4, BlocksDBC.BlockNamekDragonBall);  
/*     */   }
/*     */   
/*  30 */   public DragonBlockNS01Block() { super(DBCMaterial.dragonblock);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     this.port1 = 0; this.DragonBlockNS01TileEntity = DragonBlockNS01TileEntity.class; func_149675_a(true);
/*     */     func_149711_c(0.1F);
/*     */     float var4 = 0.4F;
/* 118 */     func_149676_a(0.5F - var4, 0.4F - var4, 0.5F - var4, 0.5F + var4, 0.4F + var4, 0.5F + var4); } public void func_149670_a(World par1World, int par2, int par3, int par4, Entity entity) { if (entity.field_70154_o == null && entity.field_70153_n == null && entity instanceof EntityPlayerMP) {
/*     */       
/* 120 */       EntityPlayerMP thePlayer = (EntityPlayerMP)entity;
/* 121 */       this.port1++;
/*     */     }  }
/*     */   
/*     */   public String getTextureFile() {
/*     */     return "jinryuudragonbc:";
/*     */   }
/*     */   public void registerIcons(IIconRegister par1IconRegister) {
/*     */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
/*     */   }
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/*     */     Item item = ItemsDBC.ItemNamekDragonBlock;
/*     */     Block block = (item instanceof net.minecraft.item.ItemBlock && !func_149648_K()) ? Block.func_149634_a(item) : (Block)this;
/*     */     return new ItemStack(item, 1, block.func_149643_k(world, x, y, z));
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/*     */     return ItemsDBC.ItemNamekDragonBlock;
/*     */   }
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*     */     return ItemsDBC.ItemNamekDragonBlock;
/*     */   }
/*     */   
/*     */   public int quanityDropped(Random random) {
/*     */     return 1;
/*     */   }
/*     */   
/*     */   public int func_149645_b() {
/*     */     return -1;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c() {
/*     */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d() {
/*     */     return false;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int i, int j, int k) {
/*     */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t) {
/* 165 */     TileEntity tile_entity = world.func_147438_o(x, y, z);
/*     */     
/* 167 */     if (tile_entity == null || player.func_70093_af()) {
/* 168 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 175 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149749_a(World world, int x, int y, int z, Block i, int j) {
/* 182 */     super.func_149749_a(world, x, y, z, i, j);
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
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 202 */     return new DragonBlockNS01TileEntity();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\DragonBlockNS01Block.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */