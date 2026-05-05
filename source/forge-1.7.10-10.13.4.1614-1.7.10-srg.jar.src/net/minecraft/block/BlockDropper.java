/*    */ package net.minecraft.block;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.dispenser.IBehaviorDispenseItem;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.tileentity.TileEntityDispenser;
/*    */ import net.minecraft.tileentity.TileEntityDropper;
/*    */ import net.minecraft.tileentity.TileEntityHopper;
/*    */ import net.minecraft.util.Facing;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockDropper extends BlockDispenser {
/* 16 */   private final IBehaviorDispenseItem field_149947_P = (IBehaviorDispenseItem)new BehaviorDefaultDispenseItem(); private static final String __OBFID = "CL_00000233";
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 20 */     this.field_149761_L = p_149651_1_.func_94245_a("furnace_side");
/* 21 */     this.field_149944_M = p_149651_1_.func_94245_a("furnace_top");
/* 22 */     this.field_149945_N = p_149651_1_.func_94245_a(func_149641_N() + "_front_horizontal");
/* 23 */     this.field_149946_O = p_149651_1_.func_94245_a(func_149641_N() + "_front_vertical");
/*    */   }
/*    */ 
/*    */   
/*    */   protected IBehaviorDispenseItem func_149940_a(ItemStack p_149940_1_) {
/* 28 */     return this.field_149947_P;
/*    */   }
/*    */ 
/*    */   
/*    */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 33 */     return (TileEntity)new TileEntityDropper();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_149941_e(World p_149941_1_, int p_149941_2_, int p_149941_3_, int p_149941_4_) {
/* 38 */     BlockSourceImpl blockSourceImpl = new BlockSourceImpl(p_149941_1_, p_149941_2_, p_149941_3_, p_149941_4_);
/* 39 */     TileEntityDispenser tileEntityDispenser = (TileEntityDispenser)blockSourceImpl.func_150835_j();
/* 40 */     if (tileEntityDispenser == null)
/*    */       return; 
/* 42 */     int i = tileEntityDispenser.func_146017_i();
/* 43 */     if (i < 0) {
/* 44 */       p_149941_1_.func_72926_e(1001, p_149941_2_, p_149941_3_, p_149941_4_, 0);
/*    */     } else {
/* 46 */       ItemStack itemStack2, itemStack1 = tileEntityDispenser.func_70301_a(i);
/* 47 */       int j = p_149941_1_.func_72805_g(p_149941_2_, p_149941_3_, p_149941_4_) & 0x7;
/* 48 */       IInventory iInventory = TileEntityHopper.func_145893_b(p_149941_1_, (p_149941_2_ + Facing.field_71586_b[j]), (p_149941_3_ + Facing.field_71587_c[j]), (p_149941_4_ + Facing.field_71585_d[j]));
/*    */ 
/*    */       
/* 51 */       if (iInventory != null) {
/* 52 */         itemStack2 = TileEntityHopper.func_145889_a(iInventory, itemStack1.func_77946_l().func_77979_a(1), Facing.field_71588_a[j]);
/*    */         
/* 54 */         if (itemStack2 == null) {
/* 55 */           itemStack2 = itemStack1.func_77946_l();
/* 56 */           if (--itemStack2.field_77994_a == 0) itemStack2 = null;
/*    */         
/*    */         } else {
/*    */           
/* 60 */           itemStack2 = itemStack1.func_77946_l();
/*    */         } 
/*    */       } else {
/* 63 */         itemStack2 = this.field_149947_P.func_82482_a(blockSourceImpl, itemStack1);
/* 64 */         if (itemStack2 != null && itemStack2.field_77994_a == 0) itemStack2 = null;
/*    */       
/*    */       } 
/* 67 */       tileEntityDispenser.func_70299_a(i, itemStack2);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockDropper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */