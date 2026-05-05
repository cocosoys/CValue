/*    */ package net.minecraft.item;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockBed;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemBed extends Item {
/*    */   public ItemBed() {
/* 12 */     func_77637_a(CreativeTabs.field_78031_c);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001771";
/*    */   
/*    */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/* 17 */     if (p_77648_3_.field_72995_K) return true;
/*    */     
/* 19 */     if (p_77648_7_ != 1) {
/* 20 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 24 */     p_77648_5_++;
/*    */     
/* 26 */     BlockBed blockBed = (BlockBed)Blocks.field_150324_C;
/*    */     
/* 28 */     int i = MathHelper.func_76128_c((p_77648_2_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 29 */     byte b1 = 0;
/* 30 */     byte b2 = 0;
/*    */     
/* 32 */     if (i == 0) b2 = 1; 
/* 33 */     if (i == 1) b1 = -1; 
/* 34 */     if (i == 2) b2 = -1; 
/* 35 */     if (i == 3) b1 = 1;
/*    */     
/* 37 */     if (!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) || !p_77648_2_.func_82247_a(p_77648_4_ + b1, p_77648_5_, p_77648_6_ + b2, p_77648_7_, p_77648_1_)) return false;
/*    */     
/* 39 */     if (p_77648_3_.func_147437_c(p_77648_4_, p_77648_5_, p_77648_6_) && p_77648_3_.func_147437_c(p_77648_4_ + b1, p_77648_5_, p_77648_6_ + b2) && World.func_147466_a((IBlockAccess)p_77648_3_, p_77648_4_, p_77648_5_ - 1, p_77648_6_) && World.func_147466_a((IBlockAccess)p_77648_3_, p_77648_4_ + b1, p_77648_5_ - 1, p_77648_6_ + b2)) {
/*    */       
/* 41 */       p_77648_3_.func_147465_d(p_77648_4_, p_77648_5_, p_77648_6_, (Block)blockBed, i, 3);
/*    */       
/* 43 */       if (p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_) == blockBed) {
/* 44 */         p_77648_3_.func_147465_d(p_77648_4_ + b1, p_77648_5_, p_77648_6_ + b2, (Block)blockBed, i + 8, 3);
/*    */       }
/*    */       
/* 47 */       p_77648_1_.field_77994_a--;
/* 48 */       return true;
/*    */     } 
/*    */     
/* 51 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemBed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */