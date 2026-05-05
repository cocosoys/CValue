/*    */ package net.minecraft.block;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.command.server.CommandBlockLogic;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.tileentity.TileEntityCommandBlock;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockCommandBlock
/*    */   extends BlockContainer {
/*    */   private static final String __OBFID = "CL_00000219";
/*    */   
/*    */   public BlockCommandBlock() {
/* 18 */     super(Material.field_151573_f);
/*    */   }
/*    */ 
/*    */   
/*    */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 23 */     return (TileEntity)new TileEntityCommandBlock();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 28 */     if (!p_149695_1_.field_72995_K) {
/*    */       
/* 30 */       boolean bool = p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_, p_149695_4_);
/* 31 */       int i = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
/* 32 */       boolean bool1 = ((i & 0x1) != 0) ? true : false;
/*    */       
/* 34 */       if (bool && !bool1) {
/* 35 */         p_149695_1_.func_72921_c(p_149695_2_, p_149695_3_, p_149695_4_, i | 0x1, 4);
/* 36 */         p_149695_1_.func_147464_a(p_149695_2_, p_149695_3_, p_149695_4_, this, func_149738_a(p_149695_1_));
/* 37 */       } else if (!bool && bool1) {
/* 38 */         p_149695_1_.func_72921_c(p_149695_2_, p_149695_3_, p_149695_4_, i & 0xFFFFFFFE, 4);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 45 */     TileEntity tileEntity = p_149674_1_.func_147438_o(p_149674_2_, p_149674_3_, p_149674_4_);
/*    */     
/* 47 */     if (tileEntity != null && tileEntity instanceof TileEntityCommandBlock) {
/* 48 */       CommandBlockLogic commandBlockLogic = ((TileEntityCommandBlock)tileEntity).func_145993_a();
/* 49 */       commandBlockLogic.func_145755_a(p_149674_1_);
/* 50 */       p_149674_1_.func_147453_f(p_149674_2_, p_149674_3_, p_149674_4_, this);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149738_a(World p_149738_1_) {
/* 56 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/* 61 */     TileEntityCommandBlock tileEntityCommandBlock = (TileEntityCommandBlock)p_149727_1_.func_147438_o(p_149727_2_, p_149727_3_, p_149727_4_);
/*    */     
/* 63 */     if (tileEntityCommandBlock != null) {
/* 64 */       p_149727_5_.func_146100_a((TileEntity)tileEntityCommandBlock);
/*    */     }
/*    */     
/* 67 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149740_M() {
/* 72 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
/* 77 */     TileEntity tileEntity = p_149736_1_.func_147438_o(p_149736_2_, p_149736_3_, p_149736_4_);
/*    */     
/* 79 */     if (tileEntity != null && tileEntity instanceof TileEntityCommandBlock) {
/* 80 */       return ((TileEntityCommandBlock)tileEntity).func_145993_a().func_145760_g();
/*    */     }
/*    */     
/* 83 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/* 88 */     TileEntityCommandBlock tileEntityCommandBlock = (TileEntityCommandBlock)p_149689_1_.func_147438_o(p_149689_2_, p_149689_3_, p_149689_4_);
/*    */     
/* 90 */     if (p_149689_6_.func_82837_s()) {
/* 91 */       tileEntityCommandBlock.func_145993_a().func_145754_b(p_149689_6_.func_82833_r());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random p_149745_1_) {
/* 97 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockCommandBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */