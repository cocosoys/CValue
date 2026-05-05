/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderCow extends RenderLiving {
/*  8 */   private static final ResourceLocation field_110833_a = new ResourceLocation("textures/entity/cow/cow.png"); private static final String __OBFID = "CL_00000984";
/*    */   
/*    */   public RenderCow(ModelBase p_i1253_1_, float p_i1253_2_) {
/* 11 */     super(p_i1253_1_, p_i1253_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityCow p_110775_1_) {
/* 16 */     return field_110833_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderCow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */