/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntitySquid;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderSquid extends RenderLiving {
/* 11 */   private static final ResourceLocation field_110901_a = new ResourceLocation("textures/entity/squid.png"); private static final String __OBFID = "CL_00001028";
/*    */   
/*    */   public RenderSquid(ModelBase p_i1268_1_, float p_i1268_2_) {
/* 14 */     super(p_i1268_1_, p_i1268_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76986_a(EntitySquid p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 19 */     super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntitySquid p_110775_1_) {
/* 24 */     return field_110901_a;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77043_a(EntitySquid p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
/* 29 */     float f1 = p_77043_1_.field_70862_e + (p_77043_1_.field_70861_d - p_77043_1_.field_70862_e) * p_77043_4_;
/* 30 */     float f2 = p_77043_1_.field_70860_g + (p_77043_1_.field_70859_f - p_77043_1_.field_70860_g) * p_77043_4_;
/*    */     
/* 32 */     GL11.glTranslatef(0.0F, 0.5F, 0.0F);
/* 33 */     GL11.glRotatef(180.0F - p_77043_3_, 0.0F, 1.0F, 0.0F);
/* 34 */     GL11.glRotatef(f1, 1.0F, 0.0F, 0.0F);
/* 35 */     GL11.glRotatef(f2, 0.0F, 1.0F, 0.0F);
/* 36 */     GL11.glTranslatef(0.0F, -1.2F, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   protected float func_77044_a(EntitySquid p_77044_1_, float p_77044_2_) {
/* 41 */     return p_77044_1_.field_70865_by + (p_77044_1_.field_70866_j - p_77044_1_.field_70865_by) * p_77044_2_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderSquid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */