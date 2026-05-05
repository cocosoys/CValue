/*    */ package net.minecraft.item;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.BlockLeaves;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ public class ItemLeaves extends ItemBlock {
/*    */   private final BlockLeaves field_150940_b;
/*    */   
/*    */   public ItemLeaves(BlockLeaves p_i45344_1_) {
/* 11 */     super((Block)p_i45344_1_);
/* 12 */     this.field_150940_b = p_i45344_1_;
/*    */     
/* 14 */     func_77656_e(0);
/* 15 */     func_77627_a(true);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000046";
/*    */   
/*    */   public int func_77647_b(int p_77647_1_) {
/* 20 */     return p_77647_1_ | 0x4;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_77617_a(int p_77617_1_) {
/* 25 */     return this.field_150940_b.func_149691_a(0, p_77617_1_);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
/* 30 */     return this.field_150940_b.func_149741_i(p_82790_1_.func_77960_j());
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_77667_c(ItemStack p_77667_1_) {
/* 35 */     int i = p_77667_1_.func_77960_j();
/* 36 */     if (i < 0 || i >= (this.field_150940_b.func_150125_e()).length) {
/* 37 */       i = 0;
/*    */     }
/* 39 */     return func_77658_a() + "." + this.field_150940_b.func_150125_e()[i];
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemLeaves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */