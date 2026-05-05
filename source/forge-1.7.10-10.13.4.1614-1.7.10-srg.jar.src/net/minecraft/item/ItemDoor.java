/*    */ package net.minecraft.item;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemDoor extends Item {
/*    */   private Material field_77870_a;
/*    */   
/*    */   public ItemDoor(Material p_i45334_1_) {
/* 15 */     this.field_77870_a = p_i45334_1_;
/* 16 */     this.field_77777_bU = 1;
/* 17 */     func_77637_a(CreativeTabs.field_78028_d);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000020";
/*    */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/*    */     Block block;
/* 22 */     if (p_77648_7_ != 1) return false; 
/* 23 */     p_77648_5_++;
/*    */ 
/*    */ 
/*    */     
/* 27 */     if (this.field_77870_a == Material.field_151575_d) { block = Blocks.field_150466_ao; }
/* 28 */     else { block = Blocks.field_150454_av; }
/*    */     
/* 30 */     if (!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) || !p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_ + 1, p_77648_6_, p_77648_7_, p_77648_1_)) return false; 
/* 31 */     if (!block.func_149742_c(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) return false;
/*    */     
/* 33 */     int i = MathHelper.func_76128_c(((p_77648_2_.field_70177_z + 180.0F) * 4.0F / 360.0F) - 0.5D) & 0x3;
/*    */     
/* 35 */     func_150924_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, i, block);
/*    */     
/* 37 */     p_77648_1_.field_77994_a--;
/* 38 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void func_150924_a(World p_150924_0_, int p_150924_1_, int p_150924_2_, int p_150924_3_, int p_150924_4_, Block p_150924_5_) {
/* 43 */     byte b1 = 0;
/* 44 */     byte b2 = 0;
/* 45 */     if (p_150924_4_ == 0) b2 = 1; 
/* 46 */     if (p_150924_4_ == 1) b1 = -1; 
/* 47 */     if (p_150924_4_ == 2) b2 = -1; 
/* 48 */     if (p_150924_4_ == 3) b1 = 1;
/*    */     
/* 50 */     int i = (p_150924_0_.func_147439_a(p_150924_1_ - b1, p_150924_2_, p_150924_3_ - b2).func_149721_r() ? 1 : 0) + (p_150924_0_.func_147439_a(p_150924_1_ - b1, p_150924_2_ + 1, p_150924_3_ - b2).func_149721_r() ? 1 : 0);
/* 51 */     int j = (p_150924_0_.func_147439_a(p_150924_1_ + b1, p_150924_2_, p_150924_3_ + b2).func_149721_r() ? 1 : 0) + (p_150924_0_.func_147439_a(p_150924_1_ + b1, p_150924_2_ + 1, p_150924_3_ + b2).func_149721_r() ? 1 : 0);
/*    */     
/* 53 */     boolean bool1 = (p_150924_0_.func_147439_a(p_150924_1_ - b1, p_150924_2_, p_150924_3_ - b2) == p_150924_5_ || p_150924_0_.func_147439_a(p_150924_1_ - b1, p_150924_2_ + 1, p_150924_3_ - b2) == p_150924_5_) ? true : false;
/* 54 */     boolean bool2 = (p_150924_0_.func_147439_a(p_150924_1_ + b1, p_150924_2_, p_150924_3_ + b2) == p_150924_5_ || p_150924_0_.func_147439_a(p_150924_1_ + b1, p_150924_2_ + 1, p_150924_3_ + b2) == p_150924_5_) ? true : false;
/*    */     
/* 56 */     boolean bool3 = false;
/* 57 */     if (bool1 && !bool2) { bool3 = true; }
/* 58 */     else if (j > i) { bool3 = true; }
/*    */     
/* 60 */     p_150924_0_.func_147465_d(p_150924_1_, p_150924_2_, p_150924_3_, p_150924_5_, p_150924_4_, 2);
/* 61 */     p_150924_0_.func_147465_d(p_150924_1_, p_150924_2_ + 1, p_150924_3_, p_150924_5_, 0x8 | (bool3 ? 1 : 0), 2);
/* 62 */     p_150924_0_.func_147459_d(p_150924_1_, p_150924_2_, p_150924_3_, p_150924_5_);
/* 63 */     p_150924_0_.func_147459_d(p_150924_1_, p_150924_2_ + 1, p_150924_3_, p_150924_5_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemDoor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */