/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.DBCMaterial;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MedPodDoor1Block
/*     */   extends BlockContainer
/*     */ {
/*     */   private Class MedPodDoor1TileEntity;
/*     */   
/*     */   public MedPodDoor1Block() {
/*  26 */     super(DBCMaterial.dragonblock);
/*  27 */     func_149647_a(mod_DragonBC.DragonBlockC);
/*  28 */     this.MedPodDoor1TileEntity = MedPodDoor1TileEntity.class;
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
/*     */   public String getTextureFile() {
/*  40 */     return "jinryuudragonbc:";
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerIcons(IIconRegister par1IconRegister) {
/*  45 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/*  55 */     int l = p_149668_1_.func_72805_g(p_149668_2_, p_149668_3_, p_149668_4_);
/*     */ 
/*     */ 
/*     */     
/*  59 */     return isFenceGateOpen(l) ? null : ((l != 2 && l != 0) ? AxisAlignedBB.func_72330_a((p_149668_2_ + 0.375F), p_149668_3_, p_149668_4_, (p_149668_2_ + 0.625F), (p_149668_3_ + 1.5F), (p_149668_4_ + 1)) : AxisAlignedBB.func_72330_a(p_149668_2_, p_149668_3_, (p_149668_4_ + 0.375F), (p_149668_2_ + 1), (p_149668_3_ + 1.5F), (p_149668_4_ + 0.625F)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
/*  67 */     int l = getDirection(p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_));
/*     */     
/*  69 */     if (l != 2 && l != 0) {
/*     */       
/*  71 */       func_149676_a(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
/*     */     }
/*     */     else {
/*     */       
/*  75 */       func_149676_a(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
/*  85 */     return isFenceGateOpen(p_149655_1_.func_72805_g(p_149655_2_, p_149655_3_, p_149655_4_));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/*  93 */     int l = (MathHelper.func_76128_c((p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3) % 4;
/*  94 */     p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, l, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World w, int x, int y, int z, EntityPlayer plyer, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/* 102 */     TileEntity tile_entity = w.func_147438_o(x, y, z);
/*     */     
/* 104 */     if (tile_entity == null || plyer.func_70093_af()) return false;
/*     */     
/* 106 */     int i1 = w.func_72805_g(x, y, z);
/*     */     
/* 108 */     boolean open = isFenceGateOpen(i1);
/* 109 */     w.func_72908_a(x + 0.5D, y + 0.5D, z + 0.5D, "jinryuudragonbc:150724.MedPodDoor1", 1.0F, w.field_73012_v.nextFloat() * 0.1F + (open ? 0.8F : 0.9F));
/*     */     
/* 111 */     int r = i1 + 4 * (open ? -1 : 1);
/* 112 */     w.func_72921_c(x, y, z, r, 2);
/*     */     int i;
/* 114 */     for (i = 0; i < 5; ) {
/*     */       
/* 116 */       Block block = w.func_147439_a(x, y + i + 1, z);
/* 117 */       if (block == this) { w.func_72921_c(x, y + i + 1, z, r, 2); i++; }
/*     */     
/*     */     } 
/* 120 */     for (i = 0; i < 5; ) {
/*     */       
/* 122 */       Block block = w.func_147439_a(x, y - i + 1, z);
/* 123 */       if (block == this) { w.func_72921_c(x, y - i + 1, z, r, 2);
/*     */         i++; }
/*     */     
/*     */     } 
/* 127 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDirection(int p_149895_0_) {
/* 132 */     return p_149895_0_ & 0x3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World w, int x, int y, int z, Block neighbor) {
/* 140 */     if (!w.field_72995_K) {
/*     */       
/* 142 */       int l = w.func_72805_g(x, y, z);
/* 143 */       boolean flag = (w.func_72864_z(x, y, z) || w.func_72864_z(x, y + 1, z) || w.func_72864_z(x, y - 1, z));
/*     */       
/* 145 */       if (flag || neighbor.func_149744_f()) {
/*     */         
/* 147 */         Block block2 = w.func_147439_a(x, y + 1, z);
/* 148 */         Block block3 = w.func_147439_a(x, y - 1, z);
/*     */ 
/*     */ 
/*     */         
/* 152 */         int i1 = w.func_72805_g(x, y, z);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 158 */         if (flag && !isFenceGateOpen(l)) {
/*     */           
/* 160 */           w.func_72908_a(x + 0.5D, y + 0.5D, z + 0.5D, "jinryuudragonbc:150724.MedPodDoor1", 1.0F, w.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */           
/* 162 */           int r = i1 + 4;
/* 163 */           w.func_72921_c(x, y, z, r, 2);
/* 164 */           if (block2 == this)
/*     */           {
/* 166 */             w.func_72921_c(x, y + 1, z, r, 2);
/*     */           }
/* 168 */           if (block3 == this)
/*     */           {
/* 170 */             w.func_72921_c(x, y - 1, z, r, 2);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/* 181 */         else if (!flag && isFenceGateOpen(l)) {
/*     */           
/* 183 */           w.func_72908_a(x + 0.5D, y + 0.5D, z + 0.5D, "jinryuudragonbc:150724.MedPodDoor1", 1.0F, w.field_73012_v.nextFloat() * 0.1F + 0.8F);
/*     */           
/* 185 */           int r = i1 - 4;
/* 186 */           w.func_72921_c(x, y, z, r, 2);
/* 187 */           TileEntity te = w.func_147438_o(x, y, z);
/* 188 */           if (te instanceof MedPodDoor1TileEntity)
/*     */           {
/* 190 */             ((MedPodDoor1TileEntity)te).setCb(21);
/*     */           }
/* 192 */           if (block2 == this) {
/*     */             
/* 194 */             w.func_72921_c(x, y + 1, z, r, 2);
/* 195 */             te = w.func_147438_o(x, y + 1, z);
/* 196 */             if (te instanceof MedPodDoor1TileEntity)
/*     */             {
/* 198 */               ((MedPodDoor1TileEntity)te).setCb(21);
/*     */             }
/*     */           } 
/* 201 */           if (block3 == this) {
/*     */             
/* 203 */             w.func_72921_c(x, y - 1, z, r, 2);
/* 204 */             te = w.func_147438_o(x, y - 1, z);
/* 205 */             if (te instanceof MedPodDoor1TileEntity)
/*     */             {
/* 207 */               ((MedPodDoor1TileEntity)te).setCb(21);
/*     */             }
/*     */           } 
/*     */         } 
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
/*     */   public static boolean isFenceGateOpen(int p_149896_0_) {
/* 238 */     return ((p_149896_0_ & 0x4) != 0);
/*     */   }
/*     */   
/*     */   public int quanityDropped(Random random) {
/* 242 */     return 1;
/*     */   }
/*     */   
/*     */   public int func_149645_b() {
/* 246 */     return -1;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c() {
/* 250 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d() {
/* 254 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World world, int x, int y, int z, Block i, int j) {
/* 259 */     super.func_149749_a(world, x, y, z, i, j);
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 264 */     return new MedPodDoor1TileEntity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/* 275 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/* 281 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\MedPodDoor1Block.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */