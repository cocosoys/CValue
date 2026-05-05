/*    */ package net.minecraft.item;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemHoe extends Item {
/*    */   protected Item.ToolMaterial field_77843_a;
/*    */   
/*    */   public ItemHoe(Item.ToolMaterial p_i45343_1_) {
/* 13 */     this.field_77843_a = p_i45343_1_;
/* 14 */     this.field_77777_bU = 1;
/* 15 */     func_77656_e(p_i45343_1_.func_77997_a());
/* 16 */     func_77637_a(CreativeTabs.field_78040_i);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000039";
/*    */   
/*    */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/* 21 */     if (!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) return false;
/*    */     
/* 23 */     Block block = p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
/* 24 */     if (p_77648_7_ != 0 && p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_ + 1, p_77648_6_).func_149688_o() == Material.field_151579_a && (block == Blocks.field_150349_c || block == Blocks.field_150346_d)) {
/* 25 */       Block block1 = Blocks.field_150458_ak;
/* 26 */       p_77648_3_.func_72908_a((p_77648_4_ + 0.5F), (p_77648_5_ + 0.5F), (p_77648_6_ + 0.5F), block1.field_149762_H.func_150498_e(), (block1.field_149762_H.func_150497_c() + 1.0F) / 2.0F, block1.field_149762_H.func_150494_d() * 0.8F);
/*    */       
/* 28 */       if (p_77648_3_.field_72995_K) return true; 
/* 29 */       p_77648_3_.func_147449_b(p_77648_4_, p_77648_5_, p_77648_6_, block1);
/* 30 */       p_77648_1_.func_77972_a(1, (EntityLivingBase)p_77648_2_);
/*    */       
/* 32 */       return true;
/*    */     } 
/*    */     
/* 35 */     return false;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_77662_d() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public String func_77842_f() {
/* 44 */     return this.field_77843_a.toString();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemHoe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */