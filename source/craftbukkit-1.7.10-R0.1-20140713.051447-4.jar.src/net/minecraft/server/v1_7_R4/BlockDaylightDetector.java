/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.util.Random;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*    */ 
/*    */ public class BlockDaylightDetector extends BlockContainer {
/*  7 */   private IIcon[] a = new IIcon[2];
/*    */   
/*    */   public BlockDaylightDetector() {
/* 10 */     super(Material.WOOD);
/* 11 */     a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
/* 12 */     a(CreativeModeTab.d);
/*    */   }
/*    */   
/*    */   public void updateShape(IBlockAccess iblockaccess, int i, int j, int k) {
/* 16 */     a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
/*    */   }
/*    */   
/*    */   public int b(IBlockAccess iblockaccess, int i, int j, int k, int l) {
/* 20 */     return iblockaccess.getData(i, j, k);
/*    */   }
/*    */   
/*    */   public void a(World world, int i, int j, int k, Random random) {}
/*    */   
/*    */   public void doPhysics(World world, int i, int j, int k, Block block) {}
/*    */   
/*    */   public void onPlace(World world, int i, int j, int k) {}
/*    */   
/*    */   public void e(World world, int i, int j, int k) {
/* 30 */     if (!world.worldProvider.g) {
/* 31 */       int l = world.getData(i, j, k);
/* 32 */       int i1 = world.b(EnumSkyBlock.SKY, i, j, k) - world.j;
/* 33 */       float f = world.d(1.0F);
/*    */       
/* 35 */       if (f < 3.1415927F) {
/* 36 */         f += (0.0F - f) * 0.2F;
/*    */       } else {
/* 38 */         f += (6.2831855F - f) * 0.2F;
/*    */       } 
/*    */       
/* 41 */       i1 = Math.round(i1 * MathHelper.cos(f));
/* 42 */       if (i1 < 0) {
/* 43 */         i1 = 0;
/*    */       }
/*    */       
/* 46 */       if (i1 > 15) {
/* 47 */         i1 = 15;
/*    */       }
/*    */       
/* 50 */       if (l != i1) {
/* 51 */         i1 = CraftEventFactory.callRedstoneChange(world, i, j, k, l, i1).getNewCurrent();
/* 52 */         world.setData(i, j, k, i1, 3);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean d() {
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public boolean c() {
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isPowerSource() {
/* 66 */     return true;
/*    */   }
/*    */   
/*    */   public TileEntity a(World world, int i) {
/* 70 */     return new TileEntityLightDetector();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockDaylightDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */