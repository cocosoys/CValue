/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ItemKatanaModel extends ModelBase {
/*    */   ModelRenderer sw;
/*    */   ModelRenderer grip;
/*    */   ModelRenderer pummel;
/*    */   ModelRenderer guard;
/*    */   
/*    */   public ItemKatanaModel() {
/* 14 */     this(0.0F);
/*    */   }
/*    */   ModelRenderer edge; ModelRenderer kat; ModelRenderer kgrip; ModelRenderer kguard; ModelRenderer kedge;
/*    */   
/*    */   public ItemKatanaModel(float par1) {
/* 19 */     this(par1, 0.0F, 64, 32);
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemKatanaModel(float par1, float par2, int par3, int par4) {
/* 24 */     this.field_78090_t = par3;
/* 25 */     this.field_78089_u = par4;
/*    */ 
/*    */ 
/*    */     
/* 29 */     this.sw = new ModelRenderer(this, 0, 0);
/* 30 */     this.sw.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F);
/* 31 */     this.sw.func_78793_a(0.0F, 0.0F + par2, 0.0F);
/* 32 */     this.grip = new ModelRenderer(this, 0, 0);
/* 33 */     this.grip.func_78789_a(0.0F, 13.96667F, 0.0F, 1, 7, 1);
/* 34 */     this.grip.func_78793_a(0.0F, 0.0F, 0.0F);
/* 35 */     setRotation(this.grip, 0.0F, 0.0F, 0.0F);
/* 36 */     this.guard = new ModelRenderer(this, 0, 26);
/* 37 */     this.guard.func_78789_a(-2.0F, 9.9F, -10.0F, 5, 1, 1);
/* 38 */     this.guard.func_78793_a(0.0F, 0.0F, 0.0F);
/* 39 */     setRotation(this.guard, 0.7853982F, 0.0F, 0.0F);
/* 40 */     this.edge = new ModelRenderer(this, 4, 0);
/* 41 */     this.edge.func_78789_a(-1.0F, -10.1F, 0.5F, 3, 24, 0);
/* 42 */     this.edge.func_78793_a(0.0F, 0.0F, 0.0F);
/* 43 */     setRotation(this.edge, 0.0F, 0.0F, 0.0F);
/* 44 */     this.pummel = new ModelRenderer(this, 0, 28);
/* 45 */     this.pummel.func_78789_a(-0.5F, 20.1F, -0.5F, 2, 2, 2);
/* 46 */     this.pummel.func_78793_a(0.0F, 0.0F, 0.0F);
/* 47 */     setRotation(this.pummel, 0.0F, 0.0F, 0.0F);
/* 48 */     this.sw.func_78792_a(this.grip);
/* 49 */     this.sw.func_78792_a(this.pummel);
/* 50 */     this.sw.func_78792_a(this.guard);
/* 51 */     this.sw.func_78792_a(this.edge);
/*    */ 
/*    */     
/* 54 */     this.kat = new ModelRenderer(this, 0, 0);
/* 55 */     this.kat.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F);
/* 56 */     this.kat.func_78793_a(0.0F, 0.0F + par2, 0.0F);
/* 57 */     this.kgrip = new ModelRenderer(this, 0, 0);
/* 58 */     this.kgrip.func_78789_a(0.0F, 13.96667F, 0.0F, 1, 7, 1);
/* 59 */     this.kgrip.func_78793_a(0.0F, 0.0F, 0.0F);
/* 60 */     setRotation(this.kgrip, 0.0F, 0.0F, 0.0F);
/* 61 */     this.kguard = new ModelRenderer(this, 0, 29);
/* 62 */     this.kguard.func_78789_a(-1.0F, 13.9F, -1.0F, 3, 0, 3);
/* 63 */     this.kguard.func_78793_a(0.0F, 0.0F, 0.0F);
/* 64 */     setRotation(this.kguard, 0.0F, 0.0F, 0.0F);
/* 65 */     this.kedge = new ModelRenderer(this, 4, 0);
/* 66 */     this.kedge.func_78789_a(-1.0F, -10.1F, 0.5F, 3, 24, 0);
/* 67 */     this.kedge.func_78793_a(0.0F, 0.0F, 0.0F);
/* 68 */     setRotation(this.kedge, 0.0F, 0.0F, 0.0F);
/* 69 */     this.kat.func_78792_a(this.kgrip);
/* 70 */     this.kat.func_78792_a(this.kguard);
/* 71 */     this.kat.func_78792_a(this.kedge);
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
/*    */ 
/*    */   
/*    */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 85 */     model.field_78795_f = x;
/* 86 */     model.field_78796_g = y;
/* 87 */     model.field_78808_h = z;
/*    */   }
/*    */   
/*    */   public void render(String s) {
/* 91 */     float par1 = 0.0625F;
/* 92 */     if (s.contains("S") || s.contains("Z")) {
/* 93 */       this.sw.func_78785_a(par1);
/*    */     }
/* 95 */     if (s.contains("K"))
/* 96 */       this.kat.func_78785_a(par1); 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemKatanaModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */