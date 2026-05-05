/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.passive.EntityPig;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderPig extends RenderLiving {
/*  9 */   private static final ResourceLocation field_110888_a = new ResourceLocation("textures/entity/pig/pig_saddle.png");
/* 10 */   private static final ResourceLocation field_110887_f = new ResourceLocation("textures/entity/pig/pig.png"); private static final String __OBFID = "CL_00001019";
/*    */   
/*    */   public RenderPig(ModelBase p_i1265_1_, ModelBase p_i1265_2_, float p_i1265_3_) {
/* 13 */     super(p_i1265_1_, p_i1265_3_);
/* 14 */     func_77042_a(p_i1265_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_77032_a(EntityPig p_77032_1_, int p_77032_2_, float p_77032_3_) {
/* 19 */     if (p_77032_2_ == 0 && p_77032_1_.func_70901_n()) {
/* 20 */       func_110776_a(field_110888_a);
/* 21 */       return 1;
/*    */     } 
/*    */     
/* 24 */     return -1;
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityPig p_110775_1_) {
/* 29 */     return field_110887_f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderPig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */