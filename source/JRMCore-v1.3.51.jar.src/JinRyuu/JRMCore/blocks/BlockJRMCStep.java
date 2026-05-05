/*     */ package JinRyuu.JRMCore.blocks;
/*     */ 
/*     */ import JinRyuu.JRMCore.mod_JRMCore;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.util.IIcon;
/*     */ 
/*     */ public class BlockJRMCStep
/*     */   extends BlockJRMCHalfSlab
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon theIcon;
/*     */   private String tex;
/*     */   private String tex2;
/*     */   
/*     */   public BlockJRMCStep(boolean par2, String tex, String tex2) {
/*  19 */     super(par2, Material.field_151576_e);
/*  20 */     func_149711_c(50.0F);
/*  21 */     func_149752_b(2000.0F);
/*  22 */     func_149647_a(mod_JRMCore.JRMCore);
/*  23 */     this.tex = tex;
/*  24 */     this.tex2 = tex2;
/*     */   }
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int par1, int par2) {
/*  41 */     return (par1 == 1) ? this.field_149761_L : ((par1 == 0) ? this.field_149761_L : ((par1 != 2 && par1 != 4) ? this.field_149761_L : this.theIcon));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149701_w() {
/*  48 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c() {
/*  52 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  60 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/*  72 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuumodscore:" + this.tex);
/*  73 */     this.theIcon = par1IconRegister.func_94245_a("jinryuumodscore:" + this.tex2);
/*     */   }
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
/*     */   public String getFullSlabName(int par1) {
/* 103 */     return func_149739_a();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\blocks\BlockJRMCStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */