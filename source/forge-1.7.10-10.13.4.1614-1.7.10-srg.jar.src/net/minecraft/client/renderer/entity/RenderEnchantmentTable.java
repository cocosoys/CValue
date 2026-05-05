/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.model.ModelBook;
/*    */ import net.minecraft.tileentity.TileEntityEnchantmentTable;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderEnchantmentTable extends TileEntitySpecialRenderer {
/* 10 */   private static final ResourceLocation field_147540_b = new ResourceLocation("textures/entity/enchanting_table_book.png");
/* 11 */   private ModelBook field_147541_c = new ModelBook();
/*    */   private static final String __OBFID = "CL_00000966";
/*    */   
/*    */   public void func_147500_a(TileEntityEnchantmentTable p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
/* 15 */     GL11.glPushMatrix();
/* 16 */     GL11.glTranslatef((float)p_147500_2_ + 0.5F, (float)p_147500_4_ + 0.75F, (float)p_147500_6_ + 0.5F);
/*    */     
/* 18 */     float f1 = p_147500_1_.field_145926_a + p_147500_8_;
/*    */     
/* 20 */     GL11.glTranslatef(0.0F, 0.1F + MathHelper.func_76126_a(f1 * 0.1F) * 0.01F, 0.0F);
/* 21 */     float f2 = p_147500_1_.field_145928_o - p_147500_1_.field_145925_p;
/* 22 */     while (f2 >= 3.1415927F)
/* 23 */       f2 -= 6.2831855F; 
/* 24 */     while (f2 < -3.1415927F) {
/* 25 */       f2 += 6.2831855F;
/*    */     }
/* 27 */     float f3 = p_147500_1_.field_145925_p + f2 * p_147500_8_;
/*    */     
/* 29 */     GL11.glRotatef(-f3 * 180.0F / 3.1415927F, 0.0F, 1.0F, 0.0F);
/* 30 */     GL11.glRotatef(80.0F, 0.0F, 0.0F, 1.0F);
/* 31 */     func_147499_a(field_147540_b);
/*    */     
/* 33 */     float f4 = p_147500_1_.field_145931_j + (p_147500_1_.field_145933_i - p_147500_1_.field_145931_j) * p_147500_8_ + 0.25F;
/* 34 */     float f5 = p_147500_1_.field_145931_j + (p_147500_1_.field_145933_i - p_147500_1_.field_145931_j) * p_147500_8_ + 0.75F;
/* 35 */     f4 = (f4 - MathHelper.func_76140_b(f4)) * 1.6F - 0.3F;
/* 36 */     f5 = (f5 - MathHelper.func_76140_b(f5)) * 1.6F - 0.3F;
/*    */     
/* 38 */     if (f4 < 0.0F) f4 = 0.0F; 
/* 39 */     if (f5 < 0.0F) f5 = 0.0F; 
/* 40 */     if (f4 > 1.0F) f4 = 1.0F; 
/* 41 */     if (f5 > 1.0F) f5 = 1.0F;
/*    */     
/* 43 */     float f6 = p_147500_1_.field_145927_n + (p_147500_1_.field_145930_m - p_147500_1_.field_145927_n) * p_147500_8_;
/* 44 */     GL11.glEnable(2884);
/* 45 */     this.field_147541_c.func_78088_a(null, f1, f4, f5, f6, 0.0F, 0.0625F);
/* 46 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderEnchantmentTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */