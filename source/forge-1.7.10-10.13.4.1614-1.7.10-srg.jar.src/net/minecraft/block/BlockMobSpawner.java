/*    */ package net.minecraft.block;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockMobSpawner extends BlockContainer {
/*    */   protected BlockMobSpawner() {
/* 12 */     super(Material.field_151576_e);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000269";
/*    */   
/*    */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 17 */     return (TileEntity)new TileEntityMobSpawner();
/*    */   }
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 22 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random p_149745_1_) {
/* 27 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
/* 32 */     super.func_149690_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
/*    */ 
/*    */ 
/*    */     
/* 36 */     int i = 15 + p_149690_1_.field_73012_v.nextInt(15) + p_149690_1_.field_73012_v.nextInt(15);
/* 37 */     func_149657_c(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, i);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149662_c() {
/* 43 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 52 */     return Item.func_150899_d(0);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockMobSpawner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */