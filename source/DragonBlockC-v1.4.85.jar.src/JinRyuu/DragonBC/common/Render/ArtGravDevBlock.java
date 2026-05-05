/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ArtGravDevBlock
/*     */   extends BlockContainer {
/*  23 */   private final Random field_149933_a = new Random();
/*     */   private Class ArtGravDevTileEntity;
/*     */   
/*     */   public ArtGravDevBlock() {
/*  27 */     super(Material.field_151573_f);
/*  28 */     this.ArtGravDevTileEntity = ArtGravDevTileEntity.class;
/*  29 */     func_149711_c(3.0F);
/*  30 */     func_149752_b(5.0F);
/*  31 */     func_149675_a(true);
/*     */     
/*  33 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List<String> par3List, boolean par4) {
/*  39 */     par3List.add(JRMCoreH.trl("dbc", "ArtGravDevDesc"));
/*     */   }
/*     */   
/*     */   public String getTextureFile() {
/*  43 */     return "jinryuudragonbc:";
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
/*     */   public int func_149645_b() {
/*  62 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  67 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  72 */     return false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149738_a(World par1World) {
/* 115 */     return 1;
/*     */   }
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t) {
/* 119 */     TileEntity tile_entity = world.func_147438_o(x, y, z);
/*     */     
/* 121 */     if (tile_entity == null || player.func_70093_af()) {
/* 122 */       return false;
/*     */     }
/* 124 */     player.openGui(mod_DragonBC.instance, 5, world, x, y, z);
/* 125 */     return true;
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
/*     */   public TileEntity func_149915_a(World world, int i) {
/* 174 */     return new ArtGravDevTileEntity();
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
/*     */   public static void updateFurnaceBlockState(boolean p_149931_0_, World p_149931_1_, int p_149931_2_, int p_149931_3_, int p_149931_4_) {
/* 188 */     int l = p_149931_1_.func_72805_g(p_149931_2_, p_149931_3_, p_149931_4_);
/* 189 */     TileEntity tileentity = p_149931_1_.func_147438_o(p_149931_2_, p_149931_3_, p_149931_4_);
/*     */ 
/*     */     
/* 192 */     if (p_149931_0_) {
/*     */       
/* 194 */       p_149931_1_.func_147449_b(p_149931_2_, p_149931_3_, p_149931_4_, BlocksDBC.ArtGravDevBlock);
/*     */     }
/*     */     else {
/*     */       
/* 198 */       p_149931_1_.func_147449_b(p_149931_2_, p_149931_3_, p_149931_4_, BlocksDBC.ArtGravDevBlock);
/*     */     } 
/*     */ 
/*     */     
/* 202 */     p_149931_1_.func_72921_c(p_149931_2_, p_149931_3_, p_149931_4_, l, 2);
/*     */     
/* 204 */     if (tileentity != null) {
/*     */       
/* 206 */       tileentity.func_145829_t();
/* 207 */       p_149931_1_.func_147455_a(p_149931_2_, p_149931_3_, p_149931_4_, tileentity);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 215 */     ArtGravDevTileEntity tileentityfurnace = (ArtGravDevTileEntity)p_149749_1_.func_147438_o(p_149749_2_, p_149749_3_, p_149749_4_);
/*     */     
/* 217 */     if (tileentityfurnace != null) {
/*     */       
/* 219 */       for (int i1 = 0; i1 < tileentityfurnace.func_70302_i_(); i1++) {
/*     */         
/* 221 */         ItemStack itemstack = tileentityfurnace.func_70301_a(i1);
/*     */         
/* 223 */         if (itemstack != null) {
/*     */           
/* 225 */           float f = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
/* 226 */           float f1 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
/* 227 */           float f2 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
/*     */           
/* 229 */           while (itemstack.field_77994_a > 0) {
/*     */             
/* 231 */             int j1 = this.field_149933_a.nextInt(21) + 10;
/*     */             
/* 233 */             if (j1 > itemstack.field_77994_a)
/*     */             {
/* 235 */               j1 = itemstack.field_77994_a;
/*     */             }
/*     */             
/* 238 */             itemstack.field_77994_a -= j1;
/* 239 */             EntityItem entityitem = new EntityItem(p_149749_1_, (p_149749_2_ + f), (p_149749_3_ + f1), (p_149749_4_ + f2), new ItemStack(itemstack.func_77973_b(), j1, itemstack.func_77960_j()));
/*     */             
/* 241 */             if (itemstack.func_77942_o())
/*     */             {
/* 243 */               entityitem.func_92059_d().func_77982_d((NBTTagCompound)itemstack.func_77978_p().func_74737_b());
/*     */             }
/*     */             
/* 246 */             float f3 = 0.05F;
/* 247 */             entityitem.field_70159_w = ((float)this.field_149933_a.nextGaussian() * f3);
/* 248 */             entityitem.field_70181_x = ((float)this.field_149933_a.nextGaussian() * f3 + 0.2F);
/* 249 */             entityitem.field_70179_y = ((float)this.field_149933_a.nextGaussian() * f3);
/* 250 */             p_149749_1_.func_72838_d((Entity)entityitem);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 255 */       p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
/*     */     } 
/*     */ 
/*     */     
/* 259 */     super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\ArtGravDevBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */