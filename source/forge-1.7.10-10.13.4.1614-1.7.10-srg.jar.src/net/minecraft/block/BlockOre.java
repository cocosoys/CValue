/*    */ package net.minecraft.block;
/*    */ import java.util.Random;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockOre extends Block {
/*    */   public BlockOre() {
/* 12 */     super(Material.field_151576_e);
/* 13 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000282";
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 18 */     if (this == Blocks.field_150365_q) return Items.field_151044_h; 
/* 19 */     if (this == Blocks.field_150482_ag) return Items.field_151045_i; 
/* 20 */     if (this == Blocks.field_150369_x) return Items.field_151100_aR; 
/* 21 */     if (this == Blocks.field_150412_bA) return Items.field_151166_bC; 
/* 22 */     if (this == Blocks.field_150449_bY) return Items.field_151128_bU; 
/* 23 */     return Item.func_150898_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random p_149745_1_) {
/* 28 */     if (this == Blocks.field_150369_x) return 4 + p_149745_1_.nextInt(5); 
/* 29 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149679_a(int p_149679_1_, Random p_149679_2_) {
/* 34 */     if (p_149679_1_ > 0 && Item.func_150898_a(this) != func_149650_a(0, p_149679_2_, p_149679_1_)) {
/* 35 */       int i = p_149679_2_.nextInt(p_149679_1_ + 2) - 1;
/* 36 */       if (i < 0) {
/* 37 */         i = 0;
/*    */       }
/* 39 */       return func_149745_a(p_149679_2_) * (i + 1);
/*    */     } 
/* 41 */     return func_149745_a(p_149679_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
/* 46 */     super.func_149690_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
/*    */ 
/*    */     
/* 49 */     if (func_149650_a(p_149690_5_, p_149690_1_.field_73012_v, p_149690_7_) != Item.func_150898_a(this)) {
/* 50 */       int i = 0;
/* 51 */       if (this == Blocks.field_150365_q) {
/* 52 */         i = MathHelper.func_76136_a(p_149690_1_.field_73012_v, 0, 2);
/* 53 */       } else if (this == Blocks.field_150482_ag) {
/* 54 */         i = MathHelper.func_76136_a(p_149690_1_.field_73012_v, 3, 7);
/* 55 */       } else if (this == Blocks.field_150412_bA) {
/* 56 */         i = MathHelper.func_76136_a(p_149690_1_.field_73012_v, 3, 7);
/* 57 */       } else if (this == Blocks.field_150369_x) {
/* 58 */         i = MathHelper.func_76136_a(p_149690_1_.field_73012_v, 2, 5);
/* 59 */       } else if (this == Blocks.field_150449_bY) {
/* 60 */         i = MathHelper.func_76136_a(p_149690_1_.field_73012_v, 2, 5);
/*    */       } 
/* 62 */       func_149657_c(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, i);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149692_a(int p_149692_1_) {
/* 69 */     if (this == Blocks.field_150369_x) return 4; 
/* 70 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockOre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */