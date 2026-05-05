/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class Itemppm
/*    */   extends Itemm
/*    */ {
/*    */   ModelRenderer sw;
/*    */   
/*    */   public Itemppm() {
/* 15 */     this(0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Itemppm(float par1) {
/* 21 */     this(par1, 0.0F, 64, 32);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Itemppm(float par1, float par2, int par3, int par4) {
/* 27 */     this.field_78090_t = par3;
/* 28 */     this.field_78089_u = par4;
/*    */ 
/*    */     
/* 31 */     this.sw = new ModelRenderer(this, 0, 0);
/* 32 */     this.sw.func_78789_a(-0.5F, -10.0F, -0.5F, 1, 18, 1);
/* 33 */     this.sw.func_78793_a(0.0F, 0.0F, 0.0F);
/* 34 */     this.sw.func_78787_b(64, 32);
/* 35 */     setRotation(this.sw, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 42 */     model.field_78795_f = x;
/* 43 */     model.field_78796_g = y;
/* 44 */     model.field_78808_h = z;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(String s) {
/* 50 */     float par1 = 0.0625F;
/* 51 */     this.sw.field_78796_g = 0.5F;
/* 52 */     this.sw.func_78785_a(par1);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\Itemppm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */