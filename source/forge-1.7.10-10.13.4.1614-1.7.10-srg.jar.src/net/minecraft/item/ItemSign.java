/*    */ package net.minecraft.item;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.tileentity.TileEntitySign;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemSign extends Item {
/*    */   public ItemSign() {
/* 12 */     this.field_77777_bU = 16;
/* 13 */     func_77637_a(CreativeTabs.field_78031_c);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000064";
/*    */   
/*    */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/* 18 */     if (p_77648_7_ == 0) return false; 
/* 19 */     if (!p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_).func_149688_o().func_76220_a()) return false;
/*    */     
/* 21 */     if (p_77648_7_ == 1) p_77648_5_++;
/*    */     
/* 23 */     if (p_77648_7_ == 2) p_77648_6_--; 
/* 24 */     if (p_77648_7_ == 3) p_77648_6_++; 
/* 25 */     if (p_77648_7_ == 4) p_77648_4_--; 
/* 26 */     if (p_77648_7_ == 5) p_77648_4_++;
/*    */     
/* 28 */     if (!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) return false; 
/* 29 */     if (!Blocks.field_150472_an.func_149742_c(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) return false;
/*    */     
/* 31 */     if (p_77648_3_.field_72995_K) {
/* 32 */       return true;
/*    */     }
/*    */     
/* 35 */     if (p_77648_7_ == 1) {
/* 36 */       int i = MathHelper.func_76128_c(((p_77648_2_.field_70177_z + 180.0F) * 16.0F / 360.0F) + 0.5D) & 0xF;
/* 37 */       p_77648_3_.func_147465_d(p_77648_4_, p_77648_5_, p_77648_6_, Blocks.field_150472_an, i, 3);
/*    */     } else {
/* 39 */       p_77648_3_.func_147465_d(p_77648_4_, p_77648_5_, p_77648_6_, Blocks.field_150444_as, p_77648_7_, 3);
/*    */     } 
/*    */     
/* 42 */     p_77648_1_.field_77994_a--;
/* 43 */     TileEntitySign tileEntitySign = (TileEntitySign)p_77648_3_.func_147438_o(p_77648_4_, p_77648_5_, p_77648_6_);
/* 44 */     if (tileEntitySign != null) p_77648_2_.func_146100_a((TileEntity)tileEntitySign); 
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemSign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */