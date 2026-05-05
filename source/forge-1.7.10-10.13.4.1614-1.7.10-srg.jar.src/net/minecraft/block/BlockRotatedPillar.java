/*    */ package net.minecraft.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class BlockRotatedPillar
/*    */   extends Block
/*    */ {
/*    */   @SideOnly(Side.CLIENT)
/*    */   protected IIcon field_150164_N;
/*    */   private static final String __OBFID = "CL_00000302";
/*    */   
/*    */   protected BlockRotatedPillar(Material p_i45425_1_) {
/* 21 */     super(p_i45425_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149645_b() {
/* 26 */     return 31;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
/* 31 */     int i = p_149660_9_ & 0x3;
/* 32 */     byte b = 0;
/*    */     
/* 34 */     switch (p_149660_5_) {
/*    */       case 2:
/*    */       case 3:
/* 37 */         b = 8;
/*    */         break;
/*    */       case 4:
/*    */       case 5:
/* 41 */         b = 4;
/*    */         break;
/*    */       case 0:
/*    */       case 1:
/* 45 */         b = 0;
/*    */         break;
/*    */     } 
/*    */     
/* 49 */     return i | b;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 54 */     int i = p_149691_2_ & 0xC;
/* 55 */     int j = p_149691_2_ & 0x3;
/*    */     
/* 57 */     if (i == 0 && (p_149691_1_ == 1 || p_149691_1_ == 0))
/* 58 */       return func_150161_d(j); 
/* 59 */     if (i == 4 && (p_149691_1_ == 5 || p_149691_1_ == 4))
/* 60 */       return func_150161_d(j); 
/* 61 */     if (i == 8 && (p_149691_1_ == 2 || p_149691_1_ == 3)) {
/* 62 */       return func_150161_d(j);
/*    */     }
/*    */     
/* 65 */     return func_150163_b(j);
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   protected IIcon func_150161_d(int p_150161_1_) {
/* 71 */     return this.field_150164_N;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149692_a(int p_149692_1_) {
/* 76 */     return p_149692_1_ & 0x3;
/*    */   }
/*    */   
/*    */   public int func_150162_k(int p_150162_1_) {
/* 80 */     return p_150162_1_ & 0x3;
/*    */   }
/*    */ 
/*    */   
/*    */   protected ItemStack func_149644_j(int p_149644_1_) {
/* 85 */     return new ItemStack(Item.func_150898_a(this), 1, func_150162_k(p_149644_1_));
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   protected abstract IIcon func_150163_b(int paramInt);
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockRotatedPillar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */