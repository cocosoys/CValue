/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.monster.EntitySilverfish;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderSilverfish extends RenderLiving {
/*  9 */   private static final ResourceLocation field_110882_a = new ResourceLocation("textures/entity/silverfish.png"); private static final String __OBFID = "CL_00001022";
/*    */   
/*    */   public RenderSilverfish() {
/* 12 */     super((ModelBase)new ModelSilverfish(), 0.3F);
/*    */   }
/*    */ 
/*    */   
/*    */   protected float func_77037_a(EntitySilverfish p_77037_1_) {
/* 17 */     return 180.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76986_a(EntitySilverfish p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 22 */     super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntitySilverfish p_110775_1_) {
/* 27 */     return field_110882_a;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_77032_a(EntitySilverfish p_77032_1_, int p_77032_2_, float p_77032_3_) {
/* 32 */     return -1;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderSilverfish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */