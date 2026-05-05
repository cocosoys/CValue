/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Npcs.EntitySaibaiman;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class SaibaiHatchedBlock extends BlockContainer {
/*     */   private Class SaibaiHatchedTileEntity;
/*     */   
/*     */   public SaibaiHatchedBlock() {
/*  18 */     super(Material.field_151576_e);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     this.port1 = 0;
/*     */     this.SaibaiHatchedTileEntity = SaibaiHatchedTileEntity.class;
/*     */     func_149675_a(true);
/*     */     func_149647_a(mod_DragonBC.DragonBlockC);
/*     */   }
/*     */ 
/*     */   
/*     */   int port1;
/*     */ 
/*     */   
/*     */   public String getTextureFile() {
/*     */     return "jinryuudragonbc:";
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerIcons(IIconRegister par1IconRegister) {
/*     */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
/*     */   }
/*     */ 
/*     */   
/*     */   public int idDropped(int i, Random random, int j) {
/*     */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int quanityDropped(Random random) {
/*     */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149738_a(World par1World) {
/*  91 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*     */     return -1;
/*     */   }
/*     */ 
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
/*     */   public void func_149674_a(World par1World, int par2, int par3, int par4, Random par5Random) {}
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t) {
/* 116 */     if (player.field_71075_bZ.field_75098_d) {
/* 117 */       EntitySaibaiman Saibaiman = new EntitySaibaiman(world);
/* 118 */       Saibaiman.func_70012_b(x + 0.5D, (y + 1), z + 0.5D, 0.0F, 0.0F);
/* 119 */       if (!world.field_72995_K)
/* 120 */         world.func_72838_d((Entity)Saibaiman); 
/*     */     } 
/* 122 */     return true;
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
/*     */   public TileEntity func_149915_a(World world, int i) {
/* 140 */     return new SaibaiHatchedTileEntity();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\SaibaiHatchedBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */