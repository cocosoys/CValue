/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ItemDBCModel1
/*    */   extends ModelBase {
/*    */   public ModelRenderer Handle;
/*    */   public ModelRenderer Handle2;
/*    */   public ModelRenderer Handle3;
/*    */   public ModelRenderer Handle4;
/*    */   public ModelRenderer Handle5;
/*    */   public ModelRenderer Handle7;
/*    */   public ModelRenderer Blade1;
/*    */   public ModelRenderer Handle6;
/*    */   public ModelRenderer Handle8;
/*    */   public ModelRenderer Blade2;
/*    */   public ModelRenderer Blade3;
/*    */   
/*    */   public ItemDBCModel1() {
/* 24 */     this.field_78090_t = 128;
/* 25 */     this.field_78089_u = 128;
/* 26 */     this.Handle = new ModelRenderer(this, 0, 0);
/* 27 */     this.Handle.func_78793_a(0.0F, 0.0F, 0.0F);
/* 28 */     this.Handle.func_78790_a(0.0F, 0.0F, 0.0F, 3, 20, 3, 0.0F);
/* 29 */     this.Handle8 = new ModelRenderer(this, 112, 6);
/* 30 */     this.Handle8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 31 */     this.Handle8.func_78790_a(-2.0F, -2.5F, 0.0F, 3, 6, 4, 0.0F);
/* 32 */     setRotateAngle(this.Handle8, 0.0F, 0.0F, -0.40578905F);
/* 33 */     this.Handle4 = new ModelRenderer(this, 32, 0);
/* 34 */     this.Handle4.func_78793_a(1.5F, -8.0F, -0.5F);
/* 35 */     this.Handle4.func_78790_a(0.0F, 0.0F, 0.0F, 3, 3, 4, 0.0F);
/* 36 */     setRotateAngle(this.Handle4, 0.0F, 0.0F, 0.7853982F);
/* 37 */     this.Handle7 = new ModelRenderer(this, 66, 0);
/* 38 */     this.Handle7.func_78793_a(9.5F, -4.0F, 3.5F);
/* 39 */     this.Handle7.func_78790_a(0.0F, 0.0F, 0.0F, 6, 3, 4, 0.0F);
/* 40 */     setRotateAngle(this.Handle7, 0.0F, -3.1415927F, 0.0F);
/* 41 */     this.Blade3 = new ModelRenderer(this, 54, 7);
/* 42 */     this.Blade3.func_78793_a(-11.1F, 0.8F, 0.0F);
/* 43 */     this.Blade3.func_78790_a(-50.0F, -70.0F, 0.0F, 6, 6, 2, 0.0F);
/* 44 */     setRotateAngle(this.Blade3, 0.0F, 0.0F, 0.7853982F);
/* 45 */     this.Handle3 = new ModelRenderer(this, 16, 0);
/* 46 */     this.Handle3.func_78793_a(-0.5F, -6.0F, -0.5F);
/* 47 */     this.Handle3.func_78790_a(0.0F, 0.0F, 0.0F, 4, 6, 4, 0.0F);
/* 48 */     this.Handle2 = new ModelRenderer(this, 12, 0);
/* 49 */     this.Handle2.func_78793_a(0.5F, 20.0F, 0.5F);
/* 50 */     this.Handle2.func_78790_a(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
/* 51 */     this.Blade2 = new ModelRenderer(this, 32, 7);
/* 52 */     this.Blade2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 53 */     this.Blade2.func_78790_a(-1.5F, -80.0F, 0.0F, 9, 80, 2, 0.0F);
/* 54 */     this.Blade1 = new ModelRenderer(this, 86, 0);
/* 55 */     this.Blade1.func_78793_a(-1.5F, -11.0F, 0.5F);
/* 56 */     this.Blade1.func_78790_a(0.0F, 0.0F, 0.0F, 6, 7, 2, 0.0F);
/* 57 */     this.Handle5 = new ModelRenderer(this, 46, 0);
/* 58 */     this.Handle5.func_78793_a(-6.5F, -4.0F, -0.5F);
/* 59 */     this.Handle5.func_78790_a(0.0F, 0.0F, 0.0F, 6, 3, 4, 0.0F);
/* 60 */     this.Handle6 = new ModelRenderer(this, 102, 0);
/* 61 */     this.Handle6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 62 */     this.Handle6.func_78790_a(-2.0F, -2.5F, 0.0F, 3, 6, 4, 0.0F);
/* 63 */     setRotateAngle(this.Handle6, 0.0F, 0.0F, -0.40578905F);
/* 64 */     this.Handle7.func_78792_a(this.Handle8);
/* 65 */     this.Handle.func_78792_a(this.Handle4);
/* 66 */     this.Handle.func_78792_a(this.Handle7);
/* 67 */     this.Blade1.func_78792_a(this.Blade3);
/* 68 */     this.Handle.func_78792_a(this.Handle3);
/* 69 */     this.Handle.func_78792_a(this.Handle2);
/* 70 */     this.Blade1.func_78792_a(this.Blade2);
/* 71 */     this.Handle.func_78792_a(this.Blade1);
/* 72 */     this.Handle.func_78792_a(this.Handle5);
/* 73 */     this.Handle5.func_78792_a(this.Handle6);
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
/* 85 */     modelRenderer.field_78795_f = x;
/* 86 */     modelRenderer.field_78796_g = y;
/* 87 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */   public void render() {
/* 90 */     float par1 = 0.0625F;
/* 91 */     this.Handle.func_78785_a(par1);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemDBCModel1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */