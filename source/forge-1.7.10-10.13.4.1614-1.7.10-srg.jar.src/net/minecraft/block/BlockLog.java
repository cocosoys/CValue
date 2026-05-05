/*    */ package net.minecraft.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public abstract class BlockLog
/*    */   extends BlockRotatedPillar
/*    */ {
/*    */   @SideOnly(Side.CLIENT)
/*    */   protected IIcon[] field_150167_a;
/*    */   
/*    */   public BlockLog() {
/* 19 */     super(Material.field_151575_d);
/* 20 */     func_149647_a(CreativeTabs.field_78030_b);
/* 21 */     func_149711_c(2.0F);
/* 22 */     func_149672_a(field_149766_f);
/*    */   } @SideOnly(Side.CLIENT)
/*    */   protected IIcon[] field_150166_b; private static final String __OBFID = "CL_00000266";
/*    */   public static int func_150165_c(int p_150165_0_) {
/* 26 */     return p_150165_0_ & 0x3;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random p_149745_1_) {
/* 31 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 36 */     return Item.func_150898_a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 41 */     byte b = 4;
/* 42 */     int i = b + 1;
/*    */     
/* 44 */     if (p_149749_1_.func_72904_c(p_149749_2_ - i, p_149749_3_ - i, p_149749_4_ - i, p_149749_2_ + i, p_149749_3_ + i, p_149749_4_ + i)) {
/* 45 */       for (byte b1 = -b; b1 <= b; b1++) {
/* 46 */         for (byte b2 = -b; b2 <= b; b2++) {
/* 47 */           for (byte b3 = -b; b3 <= b; b3++) {
/* 48 */             if (p_149749_1_.func_147439_a(p_149749_2_ + b1, p_149749_3_ + b2, p_149749_4_ + b3).func_149688_o() == Material.field_151584_j) {
/* 49 */               int j = p_149749_1_.func_72805_g(p_149749_2_ + b1, p_149749_3_ + b2, p_149749_4_ + b3);
/* 50 */               if ((j & 0x8) == 0) {
/* 51 */                 p_149749_1_.func_72921_c(p_149749_2_ + b1, p_149749_3_ + b2, p_149749_4_ + b3, j | 0x8, 4);
/*    */               }
/*    */             } 
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   protected IIcon func_150163_b(int p_150163_1_) {
/* 62 */     return this.field_150167_a[p_150163_1_ % this.field_150167_a.length];
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   protected IIcon func_150161_d(int p_150161_1_) {
/* 67 */     return this.field_150166_b[p_150161_1_ % this.field_150166_b.length];
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */