/*     */ package JinRyuu.DragonBC.common.Blocks;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockOreDBC extends Block {
/*     */   private Random rand;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/*     */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a().replaceAll("tile.", ""));
/*     */   }
/*     */   
/*  22 */   public BlockOreDBC(int harvestlevel) { super(Material.field_151576_e);
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
/*  79 */     this.rand = new Random(); func_149711_c(3.0F);
/*     */     func_149752_b(5.0F);
/*     */     func_149672_a(field_149780_i);
/*     */     func_149647_a(mod_DragonBC.DragonBlockC);
/*  83 */     setHarvestLevel("pickaxe", harvestlevel); } public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_) { if (func_149650_a(p_149690_5_, this.rand, p_149690_7_) != Item.func_150898_a(this)) {
/*     */       
/*  85 */       int j1 = 0;
/*     */       
/*  87 */       if (this == BlocksDBC.BlockOreJJay) {
/*     */         
/*  89 */         j1 = MathHelper.func_76136_a(this.rand, 0, 2);
/*     */       }
/*  91 */       else if (this == BlocksDBC.BlockOreDnomaid) {
/*     */         
/*  93 */         j1 = MathHelper.func_76136_a(this.rand, 3, 7);
/*     */       } 
/*     */       
/*  96 */       return j1;
/*     */     } 
/*  98 */     return 0; }
/*     */    public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*     */     return (this == BlocksDBC.BlockOreJJay) ? ItemsDBC.ItemsOW[3] : ((this == BlocksDBC.BlockOreDnomaid) ? ItemsDBC.ItemsOW[2] : Item.func_150898_a(this));
/*     */   }
/*     */   public int func_149745_a(Random p_149745_1_) {
/*     */     return (this == Blocks.field_150369_x) ? (4 + p_149745_1_.nextInt(5)) : 1;
/*     */   }
/*     */   public int func_149692_a(int p_149692_1_) {
/* 106 */     return (this == Blocks.field_150369_x) ? 4 : 0;
/*     */   }
/*     */   
/*     */   public int func_149679_a(int p_149679_1_, Random p_149679_2_) {
/*     */     if (p_149679_1_ > 0 && Item.func_150898_a(this) != func_149650_a(0, p_149679_2_, p_149679_1_)) {
/*     */       int j = p_149679_2_.nextInt(p_149679_1_ + 2) - 1;
/*     */       if (j < 0)
/*     */         j = 0; 
/*     */       return func_149745_a(p_149679_2_) * (j + 1);
/*     */     } 
/*     */     return func_149745_a(p_149679_2_);
/*     */   }
/*     */   
/*     */   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
/*     */     super.func_149690_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockOreDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */