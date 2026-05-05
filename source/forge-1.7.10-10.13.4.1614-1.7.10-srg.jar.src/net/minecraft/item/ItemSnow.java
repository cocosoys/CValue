/*    */ package net.minecraft.item;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemSnow
/*    */   extends ItemBlockWithMetadata {
/*    */   public ItemSnow(Block p_i45354_1_, Block p_i45354_2_) {
/* 11 */     super(p_i45354_1_, p_i45354_2_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000068";
/*    */   
/*    */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/* 16 */     if (p_77648_1_.field_77994_a == 0) return false; 
/* 17 */     if (!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) return false;
/*    */     
/* 19 */     Block block = p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
/* 20 */     if (block == Blocks.field_150431_aC) {
/* 21 */       int i = p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_);
/* 22 */       int j = i & 0x7;
/*    */       
/* 24 */       if (j <= 6 && 
/* 25 */         p_77648_3_.func_72855_b(this.field_150939_a.func_149668_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) && p_77648_3_.func_72921_c(p_77648_4_, p_77648_5_, p_77648_6_, j + 1 | i & 0xFFFFFFF8, 2)) {
/* 26 */         p_77648_3_.func_72908_a((p_77648_4_ + 0.5F), (p_77648_5_ + 0.5F), (p_77648_6_ + 0.5F), this.field_150939_a.field_149762_H.func_150496_b(), (this.field_150939_a.field_149762_H.func_150497_c() + 1.0F) / 2.0F, this.field_150939_a.field_149762_H.func_150494_d() * 0.8F);
/* 27 */         p_77648_1_.field_77994_a--;
/* 28 */         return true;
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 33 */     return super.func_77648_a(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemSnow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */