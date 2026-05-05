/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ItemDBCModel2
/*    */   extends ModelBase {
/*    */   public ModelRenderer Handle;
/*    */   public ModelRenderer Handle2;
/*    */   public ModelRenderer Handle3;
/*    */   public ModelRenderer Handle4;
/*    */   public ModelRenderer Blade;
/*    */   public ModelRenderer Blade2;
/*    */   public ModelRenderer Blade3;
/*    */   public ModelRenderer Blade4;
/*    */   public ModelRenderer Blade5;
/*    */   
/*    */   public ItemDBCModel2() {
/* 22 */     this.field_78090_t = 64;
/* 23 */     this.field_78089_u = 256;
/* 24 */     this.Handle = new ModelRenderer(this, 0, 0);
/* 25 */     this.Handle.func_78793_a(0.0F, 0.0F, 0.0F);
/* 26 */     this.Handle.func_78790_a(-0.5F, 68.0F, -0.5F, 7, 2, 5, 0.0F);
/* 27 */     this.Handle2 = new ModelRenderer(this, 19, 0);
/* 28 */     this.Handle2.func_78793_a(1.0F, 20.0F, 0.5F);
/* 29 */     this.Handle2.func_78790_a(0.0F, 50.0F, 0.0F, 4, 2, 3, 0.0F);
/* 30 */     this.Blade = new ModelRenderer(this, 0, 17);
/* 31 */     this.Blade.func_78793_a(-11.0F, 1.0F, 1.0F);
/* 32 */     this.Blade.func_78790_a(-50.0F, -70.0F, 0.0F, 11, 11, 2, 0.0F);
/* 33 */     setRotateAngle(this.Blade, 0.0F, 0.0F, 0.7853982F);
/* 34 */     this.Blade4 = new ModelRenderer(this, 22, 5);
/* 35 */     this.Blade4.func_78793_a(2.0F, -77.0F, 1.0F);
/* 36 */     this.Blade4.func_78790_a(0.1F, 6.0F, 0.0F, 2, 8, 2, 0.0F);
/* 37 */     setRotateAngle(this.Blade4, 0.0F, 0.0F, 0.6265732F);
/* 38 */     this.Handle3 = new ModelRenderer(this, 33, 0);
/* 39 */     this.Handle3.func_78793_a(1.0F, -72.0F, 0.5F);
/* 40 */     this.Handle3.func_78790_a(0.0F, 10.0F, 0.0F, 4, 130, 3, 0.0F);
/* 41 */     this.Handle4 = new ModelRenderer(this, 0, 7);
/* 42 */     this.Handle4.func_78793_a(0.3F, -77.0F, -0.5F);
/* 43 */     this.Handle4.func_78790_a(0.0F, 10.0F, 0.0F, 5, 5, 5, 0.0F);
/* 44 */     this.Blade2 = new ModelRenderer(this, 47, 0);
/* 45 */     this.Blade2.func_78793_a(24.0F, 1.5F, 6.0F);
/* 46 */     this.Blade2.func_78790_a(-1.3F, -80.0F, -5.0F, 5, 9, 2, 0.0F);
/* 47 */     setRotateAngle(this.Blade2, 0.0F, 0.0F, -0.31869712F);
/* 48 */     this.Blade3 = new ModelRenderer(this, 47, 11);
/* 49 */     this.Blade3.func_78793_a(-20.0F, 1.5F, 6.0F);
/* 50 */     this.Blade3.func_78790_a(-1.7F, -80.0F, -5.0F, 5, 9, 2, 0.0F);
/* 51 */     setRotateAngle(this.Blade3, 0.0F, 0.0F, 0.31869712F);
/* 52 */     this.Blade5 = new ModelRenderer(this, 47, 22);
/* 53 */     this.Blade5.func_78793_a(2.0F, -76.0F, 1.0F);
/* 54 */     this.Blade5.func_78790_a(0.1F, 6.0F, 0.0F, 2, 8, 2, 0.0F);
/* 55 */     setRotateAngle(this.Blade5, 0.0F, 0.0F, -0.6265732F);
/* 56 */     this.Handle.func_78792_a(this.Handle2);
/* 57 */     this.Handle.func_78792_a(this.Blade);
/* 58 */     this.Handle.func_78792_a(this.Blade4);
/* 59 */     this.Handle.func_78792_a(this.Handle3);
/* 60 */     this.Handle.func_78792_a(this.Handle4);
/* 61 */     this.Handle.func_78792_a(this.Blade2);
/* 62 */     this.Handle.func_78792_a(this.Blade3);
/* 63 */     this.Handle.func_78792_a(this.Blade5);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 75 */     modelRenderer.field_78795_f = x;
/* 76 */     modelRenderer.field_78796_g = y;
/* 77 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */   public void render() {
/* 80 */     float par1 = 0.0625F;
/* 81 */     this.Handle.func_78785_a(par1);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemDBCModel2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */