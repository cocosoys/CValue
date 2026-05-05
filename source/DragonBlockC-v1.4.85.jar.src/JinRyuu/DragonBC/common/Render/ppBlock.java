/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ppBlock extends BlockContainer {
/*  22 */   private final Random field_149933_a = new Random();
/*     */   private Class kfueb;
/*     */   
/*     */   public ppBlock() {
/*  26 */     super(Material.field_151573_f);
/*  27 */     this.kfueb = ppTileEntity.class;
/*     */ 
/*     */     
/*  30 */     func_149722_s();
/*  31 */     func_149752_b(6000000.0F);
/*     */     
/*  33 */     float var4 = 0.03125F;
/*  34 */     func_149676_a(0.5F - var4, 0.0F, 0.5F - var4, 0.5F + var4, 1.0F, 0.5F + var4);
/*  35 */     func_149675_a(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  42 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  47 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  52 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int x, int y, int z) {
/*  61 */     super.func_149726_b(p_149726_1_, x, y, z);
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
/*     */   public void func_149674_a(World par1World, int par2, int par3, int par4, Random par5Random) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/*  94 */     Item item = ItemsDBC.ItemPP;
/*  95 */     return new ItemStack(item, 1, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 104 */     return ItemsDBC.ItemPP;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 109 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int quantityDropped(int parMetadata, int parFortune, Random parRand) {
/* 119 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/* 127 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149738_a(World par1World) {
/* 134 */     return 20;
/*     */   }
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t) {
/* 138 */     TileEntity tile_entity = world.func_147438_o(x, y, z);
/*     */     
/* 140 */     if (tile_entity == null || player.func_70093_af()) {
/* 141 */       return false;
/*     */     }
/* 143 */     if (!world.field_72995_K) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 149 */       player.field_71071_by.func_70441_a(new ItemStack(ItemsDBC.ItemPP, 1));
/*     */       
/* 151 */       player.field_71071_by.field_70459_e = true; int i1;
/* 152 */       for (i1 = 0; i1 < 255 && 
/* 153 */         world.func_147439_a(x, y + i1, z) instanceof ppBlock; i1++) {
/* 154 */         world.func_147468_f(x, y + i1, z);
/* 155 */         world.func_147475_p(x, y + i1, z);
/*     */       } 
/*     */ 
/*     */       
/* 159 */       for (i1 = -1; i1 > -255 && 
/* 160 */         world.func_147439_a(x, y + i1, z) instanceof ppBlock; i1--) {
/* 161 */         world.func_147468_f(x, y + i1, z);
/* 162 */         world.func_147475_p(x, y + i1, z);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 168 */     return true;
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
/*     */   public TileEntity func_149915_a(World world, int i) {
/* 204 */     return new ppTileEntity();
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
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity) {
/* 235 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 246 */     TileEntity tile_entity = p_149695_1_.func_147438_o(p_149695_2_, p_149695_3_, p_149695_4_);
/* 247 */     if (tile_entity instanceof ppTileEntity && p_149695_1_.func_147437_c(p_149695_2_, p_149695_3_ - 1, p_149695_4_) && (
/* 248 */       (ppTileEntity)tile_entity).getF()) {
/* 249 */       float f = 0.7F;
/* 250 */       double d0 = (p_149695_1_.field_73012_v.nextFloat() * f) + (1.0F - f) * 0.5D;
/* 251 */       double d1 = (p_149695_1_.field_73012_v.nextFloat() * f) + (1.0F - f) * 0.5D;
/* 252 */       double d2 = (p_149695_1_.field_73012_v.nextFloat() * f) + (1.0F - f) * 0.5D;
/* 253 */       EntityItem entityitem = new EntityItem(p_149695_1_, p_149695_2_ + d0, p_149695_3_ + d1, p_149695_4_ + d2, new ItemStack(ItemsDBC.ItemPP));
/* 254 */       entityitem.field_145804_b = 10;
/* 255 */       p_149695_1_.func_72838_d((Entity)entityitem);
/*     */       
/* 257 */       for (int i1 = 0; i1 < 255 && 
/* 258 */         p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_ + i1, p_149695_4_) instanceof ppBlock; i1++) {
/* 259 */         p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_ + i1, p_149695_4_);
/* 260 */         p_149695_1_.func_147475_p(p_149695_2_, p_149695_3_ + i1, p_149695_4_);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\ppBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */