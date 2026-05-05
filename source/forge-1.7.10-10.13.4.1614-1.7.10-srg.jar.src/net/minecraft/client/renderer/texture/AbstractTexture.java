/*    */ package net.minecraft.client.renderer.texture;
/*    */ @SideOnly(Side.CLIENT)
/*    */ public abstract class AbstractTexture implements ITextureObject {
/*  4 */   protected int field_110553_a = -1;
/*    */   private static final String __OBFID = "CL_00001047";
/*    */   
/*    */   public int func_110552_b() {
/*  8 */     if (this.field_110553_a == -1) {
/*  9 */       this.field_110553_a = TextureUtil.func_110996_a();
/*    */     }
/*    */     
/* 12 */     return this.field_110553_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_147631_c() {
/* 17 */     if (this.field_110553_a != -1) {
/* 18 */       TextureUtil.func_147942_a(this.field_110553_a);
/* 19 */       this.field_110553_a = -1;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\texture\AbstractTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */