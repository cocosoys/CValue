/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.model.ModelSpider;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.monster.EntitySpider;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderSpider extends RenderLiving {
/* 11 */   private static final ResourceLocation field_110891_a = new ResourceLocation("textures/entity/spider_eyes.png");
/* 12 */   private static final ResourceLocation field_110890_f = new ResourceLocation("textures/entity/spider/spider.png"); private static final String __OBFID = "CL_00001027";
/*    */   
/*    */   public RenderSpider() {
/* 15 */     super((ModelBase)new ModelSpider(), 1.0F);
/* 16 */     func_77042_a((ModelBase)new ModelSpider());
/*    */   }
/*    */ 
/*    */   
/*    */   protected float func_77037_a(EntitySpider p_77037_1_) {
/* 21 */     return 180.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_77032_a(EntitySpider p_77032_1_, int p_77032_2_, float p_77032_3_) {
/* 26 */     if (p_77032_2_ != 0) return -1; 
/* 27 */     func_110776_a(field_110891_a);
/* 28 */     GL11.glEnable(3042);
/* 29 */     GL11.glDisable(3008);
/* 30 */     GL11.glBlendFunc(1, 1);
/* 31 */     if (p_77032_1_.func_82150_aj()) {
/* 32 */       GL11.glDepthMask(false);
/*    */     } else {
/* 34 */       GL11.glDepthMask(true);
/*    */     } 
/* 36 */     char c = '';
/* 37 */     int i = c % 65536;
/* 38 */     int j = c / 65536;
/*    */     
/* 40 */     OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, i / 1.0F, j / 1.0F);
/* 41 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 42 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntitySpider p_110775_1_) {
/* 47 */     return field_110890_f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderSpider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */