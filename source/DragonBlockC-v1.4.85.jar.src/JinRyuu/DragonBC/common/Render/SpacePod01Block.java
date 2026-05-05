/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class SpacePod01Block
/*     */   extends BlockContainer
/*     */ {
/*     */   private Class SpacePod01TileEntity;
/*     */   int port1;
/*     */   
/*     */   public SpacePod01Block() {
/*  27 */     super(Material.field_151590_u);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  73 */     this.port1 = 0;
/*     */     float var4 = 0.4F;
/*     */     func_149676_a(-0.5F, 0.0F, -0.5F, 1.5F, 2.0F, 1.5F);
/*  76 */     this.SpacePod01TileEntity = SpacePod01TileEntity.class; } public void func_149670_a(World par1World, int par2, int par3, int par4, Entity entity) { if (entity.field_70154_o == null && entity.field_70153_n == null && entity instanceof EntityPlayerMP) {
/*     */       
/*  78 */       EntityPlayerMP thePlayer = (EntityPlayerMP)entity;
/*  79 */       this.port1++;
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextureFile() {
/*     */     return "jinryuudragonbc:";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerIcons(IIconRegister par1IconRegister) {
/*     */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int quanityDropped(Random random) {
/*     */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*     */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*     */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*     */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int i, int j, int k) {
/*     */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t) {
/* 123 */     TileEntity tile_entity = world.func_147438_o(x, y, z);
/*     */     
/* 125 */     if (tile_entity == null || player.func_70093_af()) {
/* 126 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 130 */     player.field_71071_by.func_70441_a(new ItemStack(ItemsDBC.SpacePod01Item, 1));
/*     */     
/* 132 */     player.openGui(mod_DragonBC.instance, 0, world, x, y, z);
/* 133 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void dropItems(World world, int x, int y, int z) {
/* 144 */     Random rand = new Random();
/*     */     
/* 146 */     TileEntity tile_entity = world.func_147438_o(x, y, z);
/*     */     
/* 148 */     if (!(tile_entity instanceof IInventory)) {
/*     */       return;
/*     */     }
/*     */     
/* 152 */     IInventory inventory = (IInventory)tile_entity;
/*     */     
/* 154 */     for (int i = 0; i < inventory.func_70302_i_(); i++) {
/* 155 */       ItemStack item = inventory.func_70301_a(i);
/*     */       
/* 157 */       if (item != null && item.field_77994_a > 0) {
/* 158 */         float rx = rand.nextFloat() * 0.6F + 0.1F;
/* 159 */         float ry = rand.nextFloat() * 0.6F + 0.1F;
/* 160 */         float rz = rand.nextFloat() * 0.6F + 0.1F;
/*     */         
/* 162 */         EntityItem entity_item = new EntityItem(world, (x + rx), (y + ry), (z + rz), item);
/*     */ 
/*     */         
/* 165 */         if (item.func_77942_o()) {
/* 166 */           item.func_77982_d((NBTTagCompound)item.func_77978_p().func_74737_b());
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 171 */         float factor = 0.5F;
/*     */         
/* 173 */         entity_item.field_70159_w = rand.nextGaussian() * factor;
/* 174 */         entity_item.field_70181_x = rand.nextGaussian() * factor + 0.20000000298023224D;
/* 175 */         entity_item.field_70179_y = rand.nextGaussian() * factor;
/* 176 */         world.func_72838_d((Entity)entity_item);
/* 177 */         item.field_77994_a = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World world, int i) {
/* 184 */     return new SpacePod01TileEntity();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\SpacePod01Block.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */