/*    */ package net.minecraft.item;
/*    */ 
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.Set;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ 
/*    */ public class ItemPickaxe
/*    */   extends ItemTool {
/* 11 */   private static final Set field_150915_c = Sets.newHashSet((Object[])new Block[] { Blocks.field_150347_e, (Block)Blocks.field_150334_T, (Block)Blocks.field_150333_U, Blocks.field_150348_b, Blocks.field_150322_A, Blocks.field_150341_Y, Blocks.field_150366_p, Blocks.field_150339_S, Blocks.field_150365_q, Blocks.field_150340_R, Blocks.field_150352_o, Blocks.field_150482_ag, Blocks.field_150484_ah, Blocks.field_150432_aD, Blocks.field_150424_aL, Blocks.field_150369_x, Blocks.field_150368_y, Blocks.field_150450_ax, Blocks.field_150439_ay, Blocks.field_150448_aq, Blocks.field_150319_E, Blocks.field_150318_D, Blocks.field_150408_cc });
/*    */   
/*    */   private static final String __OBFID = "CL_00000053";
/*    */ 
/*    */   
/*    */   protected ItemPickaxe(Item.ToolMaterial p_i45347_1_) {
/* 17 */     super(2.0F, p_i45347_1_, field_150915_c);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_150897_b(Block p_150897_1_) {
/* 22 */     if (p_150897_1_ == Blocks.field_150343_Z) return (this.field_77862_b.func_77996_d() == 3); 
/* 23 */     if (p_150897_1_ == Blocks.field_150484_ah || p_150897_1_ == Blocks.field_150482_ag) return (this.field_77862_b.func_77996_d() >= 2); 
/* 24 */     if (p_150897_1_ == Blocks.field_150412_bA || p_150897_1_ == Blocks.field_150475_bE) return (this.field_77862_b.func_77996_d() >= 2); 
/* 25 */     if (p_150897_1_ == Blocks.field_150340_R || p_150897_1_ == Blocks.field_150352_o) return (this.field_77862_b.func_77996_d() >= 2); 
/* 26 */     if (p_150897_1_ == Blocks.field_150339_S || p_150897_1_ == Blocks.field_150366_p) return (this.field_77862_b.func_77996_d() >= 1); 
/* 27 */     if (p_150897_1_ == Blocks.field_150368_y || p_150897_1_ == Blocks.field_150369_x) return (this.field_77862_b.func_77996_d() >= 1); 
/* 28 */     if (p_150897_1_ == Blocks.field_150450_ax || p_150897_1_ == Blocks.field_150439_ay) return (this.field_77862_b.func_77996_d() >= 2); 
/* 29 */     if (p_150897_1_.func_149688_o() == Material.field_151576_e) return true; 
/* 30 */     if (p_150897_1_.func_149688_o() == Material.field_151573_f) return true; 
/* 31 */     if (p_150897_1_.func_149688_o() == Material.field_151574_g) return true; 
/* 32 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_) {
/* 37 */     if (p_150893_2_.func_149688_o() == Material.field_151573_f || p_150893_2_.func_149688_o() == Material.field_151574_g || p_150893_2_.func_149688_o() == Material.field_151576_e) {
/* 38 */       return this.field_77864_a;
/*    */     }
/* 40 */     return super.func_150893_a(p_150893_1_, p_150893_2_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemPickaxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */