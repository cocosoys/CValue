/*    */ package net.minecraft.item;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ public class ItemMultiTexture extends ItemBlock {
/*    */   protected final Block field_150941_b;
/*    */   
/*    */   public ItemMultiTexture(Block p_i45346_1_, Block p_i45346_2_, String[] p_i45346_3_) {
/* 11 */     super(p_i45346_1_);
/*    */     
/* 13 */     this.field_150941_b = p_i45346_2_;
/* 14 */     this.field_150942_c = p_i45346_3_;
/*    */     
/* 16 */     func_77656_e(0);
/* 17 */     func_77627_a(true);
/*    */   }
/*    */   protected final String[] field_150942_c; private static final String __OBFID = "CL_00000051";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_77617_a(int p_77617_1_) {
/* 22 */     return this.field_150941_b.func_149691_a(2, p_77617_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77647_b(int p_77647_1_) {
/* 27 */     return p_77647_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_77667_c(ItemStack p_77667_1_) {
/* 32 */     int i = p_77667_1_.func_77960_j();
/* 33 */     if (i < 0 || i >= this.field_150942_c.length) {
/* 34 */       i = 0;
/*    */     }
/* 36 */     return func_77658_a() + "." + this.field_150942_c[i];
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemMultiTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */