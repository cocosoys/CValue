/*    */ package net.minecraft.block;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityFallingBlock;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockFalling extends Block {
/*    */   public static boolean field_149832_M;
/*    */   
/*    */   public BlockFalling() {
/* 14 */     super(Material.field_151595_p);
/* 15 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000240";
/*    */   public BlockFalling(Material p_i45405_1_) {
/* 19 */     super(p_i45405_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/* 24 */     p_149726_1_.func_147464_a(p_149726_2_, p_149726_3_, p_149726_4_, this, func_149738_a(p_149726_1_));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 29 */     p_149695_1_.func_147464_a(p_149695_2_, p_149695_3_, p_149695_4_, this, func_149738_a(p_149695_1_));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 34 */     if (!p_149674_1_.field_72995_K) {
/* 35 */       func_149830_m(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
/*    */     }
/*    */   }
/*    */   
/*    */   private void func_149830_m(World p_149830_1_, int p_149830_2_, int p_149830_3_, int p_149830_4_) {
/* 40 */     int i = p_149830_2_;
/* 41 */     int j = p_149830_3_;
/* 42 */     int k = p_149830_4_;
/* 43 */     if (func_149831_e(p_149830_1_, i, j - 1, k) && j >= 0) {
/* 44 */       byte b = 32;
/* 45 */       if (field_149832_M || !p_149830_1_.func_72904_c(p_149830_2_ - b, p_149830_3_ - b, p_149830_4_ - b, p_149830_2_ + b, p_149830_3_ + b, p_149830_4_ + b)) {
/* 46 */         p_149830_1_.func_147468_f(p_149830_2_, p_149830_3_, p_149830_4_);
/* 47 */         while (func_149831_e(p_149830_1_, p_149830_2_, p_149830_3_ - 1, p_149830_4_) && p_149830_3_ > 0)
/* 48 */           p_149830_3_--; 
/* 49 */         if (p_149830_3_ > 0) {
/* 50 */           p_149830_1_.func_147449_b(p_149830_2_, p_149830_3_, p_149830_4_, this);
/*    */         }
/* 52 */       } else if (!p_149830_1_.field_72995_K) {
/* 53 */         EntityFallingBlock entityFallingBlock = new EntityFallingBlock(p_149830_1_, (p_149830_2_ + 0.5F), (p_149830_3_ + 0.5F), (p_149830_4_ + 0.5F), this, p_149830_1_.func_72805_g(p_149830_2_, p_149830_3_, p_149830_4_));
/* 54 */         func_149829_a(entityFallingBlock);
/* 55 */         p_149830_1_.func_72838_d((Entity)entityFallingBlock);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_149829_a(EntityFallingBlock p_149829_1_) {}
/*    */ 
/*    */   
/*    */   public int func_149738_a(World p_149738_1_) {
/* 65 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean func_149831_e(World p_149831_0_, int p_149831_1_, int p_149831_2_, int p_149831_3_) {
/* 70 */     Block block = p_149831_0_.func_147439_a(p_149831_1_, p_149831_2_, p_149831_3_);
/* 71 */     if (block.field_149764_J == Material.field_151579_a) return true; 
/* 72 */     if (block == Blocks.field_150480_ab) return true; 
/* 73 */     Material material = block.field_149764_J;
/* 74 */     if (material == Material.field_151586_h) return true; 
/* 75 */     if (material == Material.field_151587_i) return true; 
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public void func_149828_a(World p_149828_1_, int p_149828_2_, int p_149828_3_, int p_149828_4_, int p_149828_5_) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockFalling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */