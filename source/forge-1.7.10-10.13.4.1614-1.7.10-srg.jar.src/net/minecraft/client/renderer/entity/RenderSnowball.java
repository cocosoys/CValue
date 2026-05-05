/*    */ package net.minecraft.client.renderer.entity;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemPotion;
/*    */ import net.minecraft.potion.PotionHelper;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderSnowball extends Render {
/*    */   private Item field_94151_a;
/*    */   
/*    */   public RenderSnowball(Item p_i1259_1_, int p_i1259_2_) {
/* 19 */     this.field_94151_a = p_i1259_1_;
/* 20 */     this.field_94150_f = p_i1259_2_;
/*    */   }
/*    */   private int field_94150_f; private static final String __OBFID = "CL_00001008";
/*    */   public RenderSnowball(Item p_i1260_1_) {
/* 24 */     this(p_i1260_1_, 0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 30 */     IIcon iIcon = this.field_94151_a.func_77617_a(this.field_94150_f);
/* 31 */     if (iIcon == null) {
/*    */       return;
/*    */     }
/*    */     
/* 35 */     GL11.glPushMatrix();
/*    */     
/* 37 */     GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
/* 38 */     GL11.glEnable(32826);
/* 39 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 40 */     func_110777_b(p_76986_1_);
/*    */     
/* 42 */     Tessellator tessellator = Tessellator.field_78398_a;
/*    */     
/* 44 */     if (iIcon == ItemPotion.func_94589_d("bottle_splash")) {
/*    */       
/* 46 */       int i = PotionHelper.func_77915_a(((EntityPotion)p_76986_1_).func_70196_i(), false);
/* 47 */       float f1 = (i >> 16 & 0xFF) / 255.0F;
/* 48 */       float f2 = (i >> 8 & 0xFF) / 255.0F;
/* 49 */       float f3 = (i & 0xFF) / 255.0F;
/*    */       
/* 51 */       GL11.glColor3f(f1, f2, f3);
/* 52 */       GL11.glPushMatrix();
/* 53 */       func_77026_a(tessellator, ItemPotion.func_94589_d("overlay"));
/* 54 */       GL11.glPopMatrix();
/* 55 */       GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*    */     } 
/*    */     
/* 58 */     func_77026_a(tessellator, iIcon);
/*    */     
/* 60 */     GL11.glDisable(32826);
/* 61 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
/* 66 */     return TextureMap.field_110576_c;
/*    */   }
/*    */   
/*    */   private void func_77026_a(Tessellator p_77026_1_, IIcon p_77026_2_) {
/* 70 */     float f1 = p_77026_2_.func_94209_e();
/* 71 */     float f2 = p_77026_2_.func_94212_f();
/* 72 */     float f3 = p_77026_2_.func_94206_g();
/* 73 */     float f4 = p_77026_2_.func_94210_h();
/* 74 */     float f5 = 1.0F;
/* 75 */     float f6 = 0.5F;
/* 76 */     float f7 = 0.25F;
/* 77 */     GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 78 */     GL11.glRotatef(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
/* 79 */     p_77026_1_.func_78382_b();
/* 80 */     p_77026_1_.func_78375_b(0.0F, 1.0F, 0.0F);
/* 81 */     p_77026_1_.func_78374_a((0.0F - f6), (0.0F - f7), 0.0D, f1, f4);
/* 82 */     p_77026_1_.func_78374_a((f5 - f6), (0.0F - f7), 0.0D, f2, f4);
/* 83 */     p_77026_1_.func_78374_a((f5 - f6), (f5 - f7), 0.0D, f2, f3);
/* 84 */     p_77026_1_.func_78374_a((0.0F - f6), (f5 - f7), 0.0D, f1, f3);
/* 85 */     p_77026_1_.func_78381_a();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderSnowball.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */