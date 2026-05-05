/*    */ package net.minecraft.item;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ public class ItemColored extends ItemBlock {
/*    */   private final Block field_150944_b;
/*    */   
/*    */   public ItemColored(Block p_i45332_1_, boolean p_i45332_2_) {
/* 12 */     super(p_i45332_1_);
/* 13 */     this.field_150944_b = p_i45332_1_;
/*    */     
/* 15 */     if (p_i45332_2_) {
/* 16 */       func_77656_e(0);
/* 17 */       func_77627_a(true);
/*    */     } 
/*    */   }
/*    */   private String[] field_150945_c; private static final String __OBFID = "CL_00000003";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
/* 23 */     return this.field_150944_b.func_149741_i(p_82790_1_.func_77960_j());
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_77617_a(int p_77617_1_) {
/* 28 */     return this.field_150944_b.func_149691_a(0, p_77617_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77647_b(int p_77647_1_) {
/* 33 */     return p_77647_1_;
/*    */   }
/*    */   
/*    */   public ItemColored func_150943_a(String[] p_150943_1_) {
/* 37 */     this.field_150945_c = p_150943_1_;
/* 38 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_77667_c(ItemStack p_77667_1_) {
/* 43 */     if (this.field_150945_c == null) {
/* 44 */       return super.func_77667_c(p_77667_1_);
/*    */     }
/* 46 */     int i = p_77667_1_.func_77960_j();
/* 47 */     if (i >= 0 && i < this.field_150945_c.length) {
/* 48 */       return super.func_77667_c(p_77667_1_) + "." + this.field_150945_c[i];
/*    */     }
/* 50 */     return super.func_77667_c(p_77667_1_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemColored.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */