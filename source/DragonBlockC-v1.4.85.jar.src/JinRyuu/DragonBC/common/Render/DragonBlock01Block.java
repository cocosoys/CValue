/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.DBCMaterial;
/*     */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityDragon;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class DragonBlock01Block extends BlockContainer {
/*     */   private Class DragonBlock01TileEntity;
/*     */   int port1;
/*     */   
/*     */   public String getTextureFile() {
/*     */     return "jinryuudragonbc:";
/*     */   }
/*     */   
/*  31 */   public DragonBlock01Block() { super(DBCMaterial.dragonblock);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 158 */     this.port1 = 0; this.DragonBlock01TileEntity = DragonBlock01TileEntity.class; func_149675_a(true);
/*     */     func_149711_c(0.1F);
/*     */     float var4 = 0.2F;
/* 161 */     func_149676_a(0.5F - var4, 0.2F - var4, 0.5F - var4, 0.5F + var4, 0.2F + var4, 0.5F + var4); } public void func_149670_a(World par1World, int par2, int par3, int par4, Entity entity) { if (entity.field_70154_o == null && entity.field_70153_n == null && entity instanceof EntityPlayerMP) {
/*     */       
/* 163 */       EntityPlayerMP thePlayer = (EntityPlayerMP)entity;
/* 164 */       this.port1++;
/*     */     }  }
/*     */   
/*     */   public void registerIcons(IIconRegister par1IconRegister) {
/*     */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
/*     */   }
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/*     */     Item item = ItemsDBC.ItemDragonBlock;
/*     */     Block block = (item instanceof net.minecraft.item.ItemBlock && !func_149648_K()) ? Block.func_149634_a(item) : (Block)this;
/*     */     return new ItemStack(item, 1, block.func_149643_k(world, x, y, z));
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/*     */     return ItemsDBC.ItemDragonBlock;
/*     */   }
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*     */     return ItemsDBC.ItemDragonBlock;
/*     */   }
/*     */   public int quanityDropped(Random random) {
/*     */     return 1;
/*     */   }
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
/*     */   public int tickRate() {
/*     */     return 1;
/*     */   }
/*     */   
/*     */   public void func_149674_a(World par1World, int par2, int par3, int par4, Random par5Random) {}
/*     */   
/*     */   public boolean func_149727_a(World par1World, int par2, int par3, int par4, EntityPlayer player, int i, float f, float g, float t) {
/* 208 */     TileEntity tile_entity = par1World.func_147438_o(par2, par3, par4);
/*     */     
/* 210 */     if (tile_entity == null || player.func_70093_af()) {
/* 211 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 218 */     if (!par1World.field_72995_K) {
/* 219 */       if (par1World.func_147439_a(par2 + 1, par3, par4) == this) {
/* 220 */         if (par1World.func_147439_a(par2 + 1, par3, par4 + 1) == this && 
/* 221 */           par1World.func_147439_a(par2 + 1, par3, par4 - 1) == this && 
/* 222 */           par1World.func_147439_a(par2 - 1, par3, par4) == this && 
/* 223 */           par1World.func_147439_a(par2 - 1, par3, par4 - 1) == this && 
/* 224 */           par1World.func_147439_a(par2 - 1, par3, par4 + 1) == this)
/*     */         {
/*     */           
/* 227 */           if (!par1World.field_72995_K) {
/* 228 */             EntityDragon Dragon = new EntityDragon(par1World);
/* 229 */             Dragon.func_70012_b(par2, par3, par4, f, 0.0F);
/*     */             
/* 231 */             par1World.func_72838_d((Entity)Dragon);
/*     */             
/* 233 */             par1World.func_72908_a(par2, par3, par4, "jinryuudragonbc:dragon.makeone", 1.0F, 1.0F);
/*     */           } 
/*     */           
/* 236 */           par1World.func_147449_b(par2 + 1, par3, par4, Blocks.field_150350_a);
/* 237 */           par1World.func_147449_b(par2 + 1, par3, par4 + 1, Blocks.field_150350_a);
/* 238 */           par1World.func_147449_b(par2 + 1, par3, par4 - 1, Blocks.field_150350_a);
/* 239 */           par1World.func_147449_b(par2 - 1, par3, par4, Blocks.field_150350_a);
/* 240 */           par1World.func_147449_b(par2 - 1, par3, par4 - 1, Blocks.field_150350_a);
/* 241 */           par1World.func_147449_b(par2 - 1, par3, par4 + 1, Blocks.field_150350_a);
/* 242 */           par1World.func_147449_b(par2, par3, par4, Blocks.field_150350_a);
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 250 */       else if (par1World.func_147439_a(par2, par3, par4 + 1) == this && 
/* 251 */         par1World.func_147439_a(par2 + 1, par3, par4 + 1) == this && 
/* 252 */         par1World.func_147439_a(par2 + 1, par3, par4 - 1) == this && 
/* 253 */         par1World.func_147439_a(par2, par3, par4 - 1) == this && 
/* 254 */         par1World.func_147439_a(par2 - 1, par3, par4 - 1) == this && 
/* 255 */         par1World.func_147439_a(par2 - 1, par3, par4 + 1) == this) {
/*     */ 
/*     */         
/* 258 */         if (!par1World.field_72995_K) {
/* 259 */           EntityDragon Dragon = new EntityDragon(par1World);
/* 260 */           Dragon.func_70012_b(par2, par3, par4, f, 0.0F);
/*     */           
/* 262 */           par1World.func_72838_d((Entity)Dragon);
/*     */           
/* 264 */           par1World.func_72908_a(par2, par3, par4, "jinryuudragonbc:dragon.makeone", 1.0F, 1.0F);
/*     */         } 
/*     */         
/* 267 */         par1World.func_147449_b(par2, par3, par4 + 1, Blocks.field_150350_a);
/* 268 */         par1World.func_147449_b(par2 + 1, par3, par4 + 1, Blocks.field_150350_a);
/* 269 */         par1World.func_147449_b(par2 + 1, par3, par4 - 1, Blocks.field_150350_a);
/* 270 */         par1World.func_147449_b(par2, par3, par4 - 1, Blocks.field_150350_a);
/* 271 */         par1World.func_147449_b(par2 - 1, par3, par4 - 1, Blocks.field_150350_a);
/* 272 */         par1World.func_147449_b(par2 - 1, par3, par4 + 1, Blocks.field_150350_a);
/* 273 */         par1World.func_147449_b(par2, par3, par4, Blocks.field_150350_a);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 284 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149749_a(World world, int x, int y, int z, Block i, int j) {
/* 291 */     super.func_149749_a(world, x, y, z, i, j);
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 296 */     return (TileEntity)new DragonBlock01TileEntity();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\DragonBlock01Block.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */