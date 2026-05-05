/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.ColorizerFoliage;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockOldLeaf
/*     */   extends BlockLeaves {
/*  18 */   public static final String[][] field_150130_N = new String[][] { { "leaves_oak", "leaves_spruce", "leaves_birch", "leaves_jungle" }, { "leaves_oak_opaque", "leaves_spruce_opaque", "leaves_birch_opaque", "leaves_jungle_opaque" } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  25 */   public static final String[] field_150131_O = new String[] { "oak", "spruce", "birch", "jungle" };
/*     */   
/*     */   private static final String __OBFID = "CL_00000280";
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149741_i(int p_149741_1_) {
/*  31 */     if ((p_149741_1_ & 0x3) == 1) {
/*  32 */       return ColorizerFoliage.func_77466_a();
/*     */     }
/*  34 */     if ((p_149741_1_ & 0x3) == 2) {
/*  35 */       return ColorizerFoliage.func_77469_b();
/*     */     }
/*     */     
/*  38 */     return super.func_149741_i(p_149741_1_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
/*  43 */     int i = p_149720_1_.func_72805_g(p_149720_2_, p_149720_3_, p_149720_4_);
/*     */     
/*  45 */     if ((i & 0x3) == 1) {
/*  46 */       return ColorizerFoliage.func_77466_a();
/*     */     }
/*  48 */     if ((i & 0x3) == 2) {
/*  49 */       return ColorizerFoliage.func_77469_b();
/*     */     }
/*     */     
/*  52 */     return super.func_149720_d(p_149720_1_, p_149720_2_, p_149720_3_, p_149720_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_150124_c(World p_150124_1_, int p_150124_2_, int p_150124_3_, int p_150124_4_, int p_150124_5_, int p_150124_6_) {
/*  57 */     if ((p_150124_5_ & 0x3) == 0 && p_150124_1_.field_73012_v.nextInt(p_150124_6_) == 0) {
/*  58 */       func_149642_a(p_150124_1_, p_150124_2_, p_150124_3_, p_150124_4_, new ItemStack(Items.field_151034_e, 1, 0));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_150123_b(int p_150123_1_) {
/*  64 */     int i = super.func_150123_b(p_150123_1_);
/*     */     
/*  66 */     if ((p_150123_1_ & 0x3) == 3) {
/*  67 */       i = 40;
/*     */     }
/*     */     
/*  70 */     return i;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  75 */     if ((p_149691_2_ & 0x3) == 1) {
/*  76 */       return this.field_150129_M[this.field_150127_b][1];
/*     */     }
/*  78 */     if ((p_149691_2_ & 0x3) == 3) {
/*  79 */       return this.field_150129_M[this.field_150127_b][3];
/*     */     }
/*  81 */     if ((p_149691_2_ & 0x3) == 2) {
/*  82 */       return this.field_150129_M[this.field_150127_b][2];
/*     */     }
/*  84 */     return this.field_150129_M[this.field_150127_b][0];
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/*  89 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
/*  90 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
/*  91 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 2));
/*  92 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 3));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/*  97 */     for (byte b = 0; b < field_150130_N.length; b++) {
/*  98 */       this.field_150129_M[b] = new IIcon[(field_150130_N[b]).length];
/*     */       
/* 100 */       for (byte b1 = 0; b1 < (field_150130_N[b]).length; b1++) {
/* 101 */         this.field_150129_M[b][b1] = p_149651_1_.func_94245_a(field_150130_N[b][b1]);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] func_150125_e() {
/* 108 */     return field_150131_O;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockOldLeaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */