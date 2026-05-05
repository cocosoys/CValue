/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ 
/*     */ public class BlockFlower extends BlockBush {
/*  14 */   private static final String[][] field_149860_M = new String[][] { { "flower_dandelion" }, { "flower_rose", "flower_blue_orchid", "flower_allium", "flower_houstonia", "flower_tulip_red", "flower_tulip_orange", "flower_tulip_white", "flower_tulip_pink", "flower_oxeye_daisy" } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   public static final String[] field_149859_a = new String[] { "poppy", "blueOrchid", "allium", "houstonia", "tulipRed", "tulipOrange", "tulipWhite", "tulipPink", "oxeyeDaisy" };
/*     */ 
/*     */ 
/*     */   
/*  39 */   public static final String[] field_149858_b = new String[] { "dandelion" };
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_149861_N;
/*     */   private int field_149862_O;
/*     */   private static final String __OBFID = "CL_00000246";
/*     */   
/*     */   protected BlockFlower(int p_i2173_1_) {
/*  47 */     super(Material.field_151585_k);
/*  48 */     this.field_149862_O = p_i2173_1_;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  53 */     if (p_149691_2_ >= this.field_149861_N.length) p_149691_2_ = 0; 
/*  54 */     return this.field_149861_N[p_149691_2_];
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/*  59 */     this.field_149861_N = new IIcon[(field_149860_M[this.field_149862_O]).length];
/*     */     
/*  61 */     for (byte b = 0; b < this.field_149861_N.length; b++) {
/*  62 */       this.field_149861_N[b] = p_149651_1_.func_94245_a(field_149860_M[this.field_149862_O][b]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int p_149692_1_) {
/*  68 */     return p_149692_1_;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/*  73 */     for (byte b = 0; b < this.field_149861_N.length; b++) {
/*  74 */       p_149666_3_.add(new ItemStack(p_149666_1_, 1, b));
/*     */     }
/*     */   }
/*     */   
/*     */   public static BlockFlower func_149857_e(String p_149857_0_) {
/*  79 */     for (String str : field_149858_b) {
/*  80 */       if (str.equals(p_149857_0_)) {
/*  81 */         return Blocks.field_150327_N;
/*     */       }
/*     */     } 
/*  84 */     for (String str : field_149859_a) {
/*  85 */       if (str.equals(p_149857_0_)) {
/*  86 */         return Blocks.field_150328_O;
/*     */       }
/*     */     } 
/*  89 */     return null;
/*     */   }
/*     */   public static int func_149856_f(String p_149856_0_) {
/*     */     byte b;
/*  93 */     for (b = 0; b < field_149858_b.length; b++) {
/*  94 */       if (field_149858_b[b].equals(p_149856_0_)) {
/*  95 */         return b;
/*     */       }
/*     */     } 
/*  98 */     for (b = 0; b < field_149859_a.length; b++) {
/*  99 */       if (field_149859_a[b].equals(p_149856_0_)) {
/* 100 */         return b;
/*     */       }
/*     */     } 
/* 103 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockFlower.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */