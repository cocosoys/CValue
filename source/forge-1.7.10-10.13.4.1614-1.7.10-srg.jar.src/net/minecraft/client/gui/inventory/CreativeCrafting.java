/*    */ package net.minecraft.client.gui.inventory;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.inventory.ICrafting;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class CreativeCrafting implements ICrafting {
/*    */   public CreativeCrafting(Minecraft p_i1085_1_) {
/* 14 */     this.field_146109_a = p_i1085_1_;
/*    */   }
/*    */   
/*    */   private final Minecraft field_146109_a;
/*    */   private static final String __OBFID = "CL_00000751";
/*    */   
/*    */   public void func_71110_a(Container p_71110_1_, List p_71110_2_) {}
/*    */   
/*    */   public void func_71111_a(Container p_71111_1_, int p_71111_2_, ItemStack p_71111_3_) {
/* 23 */     this.field_146109_a.field_71442_b.func_78761_a(p_71111_3_, p_71111_2_);
/*    */   }
/*    */   
/*    */   public void func_71112_a(Container p_71112_1_, int p_71112_2_, int p_71112_3_) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\inventory\CreativeCrafting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */