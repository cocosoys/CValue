/*    */ package net.minecraft.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockHugeMushroom
/*    */   extends Block
/*    */ {
/* 18 */   private static final String[] field_149793_a = new String[] { "skin_brown", "skin_red" };
/*    */ 
/*    */   
/*    */   private final int field_149792_b;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon[] field_149794_M;
/*    */ 
/*    */   
/*    */   public BlockHugeMushroom(Material p_i45412_1_, int p_i45412_2_) {
/* 28 */     super(p_i45412_1_);
/* 29 */     this.field_149792_b = p_i45412_2_;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon field_149795_N; @SideOnly(Side.CLIENT)
/*    */   private IIcon field_149796_O; private static final String __OBFID = "CL_00000258";
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 37 */     if (p_149691_2_ == 10 && p_149691_1_ > 1) return this.field_149795_N; 
/* 38 */     if (p_149691_2_ >= 1 && p_149691_2_ <= 9 && p_149691_1_ == 1) return this.field_149794_M[this.field_149792_b]; 
/* 39 */     if (p_149691_2_ >= 1 && p_149691_2_ <= 3 && p_149691_1_ == 2) return this.field_149794_M[this.field_149792_b]; 
/* 40 */     if (p_149691_2_ >= 7 && p_149691_2_ <= 9 && p_149691_1_ == 3) return this.field_149794_M[this.field_149792_b];
/*    */     
/* 42 */     if ((p_149691_2_ == 1 || p_149691_2_ == 4 || p_149691_2_ == 7) && p_149691_1_ == 4) return this.field_149794_M[this.field_149792_b]; 
/* 43 */     if ((p_149691_2_ == 3 || p_149691_2_ == 6 || p_149691_2_ == 9) && p_149691_1_ == 5) return this.field_149794_M[this.field_149792_b];
/*    */ 
/*    */     
/* 46 */     if (p_149691_2_ == 14) {
/* 47 */       return this.field_149794_M[this.field_149792_b];
/*    */     }
/* 49 */     if (p_149691_2_ == 15) {
/* 50 */       return this.field_149795_N;
/*    */     }
/*    */     
/* 53 */     return this.field_149796_O;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random p_149745_1_) {
/* 58 */     int i = p_149745_1_.nextInt(10) - 7;
/* 59 */     if (i < 0) i = 0; 
/* 60 */     return i;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 66 */     return Item.func_150899_d(Block.func_149682_b(Blocks.field_150338_P) + this.field_149792_b);
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 72 */     return Item.func_150899_d(Block.func_149682_b(Blocks.field_150338_P) + this.field_149792_b);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 77 */     this.field_149794_M = new IIcon[field_149793_a.length];
/*    */     
/* 79 */     for (byte b = 0; b < this.field_149794_M.length; b++) {
/* 80 */       this.field_149794_M[b] = p_149651_1_.func_94245_a(func_149641_N() + "_" + field_149793_a[b]);
/*    */     }
/*    */     
/* 83 */     this.field_149796_O = p_149651_1_.func_94245_a(func_149641_N() + "_" + "inside");
/* 84 */     this.field_149795_N = p_149651_1_.func_94245_a(func_149641_N() + "_" + "skin_stem");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockHugeMushroom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */