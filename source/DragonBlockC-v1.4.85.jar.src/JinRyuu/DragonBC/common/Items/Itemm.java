/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class Itemm
/*    */   extends ModelBase
/*    */ {
/*    */   public Itemm() {
/* 16 */     this(0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Itemm(float par1) {
/* 22 */     this(par1, 0.0F, 64, 32);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Itemm(float par1, float par2, int par3, int par4) {
/* 28 */     this.field_78090_t = par3;
/* 29 */     this.field_78089_u = par4;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 36 */     model.field_78795_f = x;
/* 37 */     model.field_78796_g = y;
/* 38 */     model.field_78808_h = z;
/*    */   }
/*    */   
/*    */   public void render(String s) {}
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\Itemm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */