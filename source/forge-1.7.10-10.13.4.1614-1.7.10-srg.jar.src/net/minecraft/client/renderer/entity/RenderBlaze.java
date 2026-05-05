/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.model.ModelBlaze;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.monster.EntityBlaze;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderBlaze extends RenderLiving {
/*  8 */   private static final ResourceLocation field_110837_a = new ResourceLocation("textures/entity/blaze.png"); private int field_77068_a;
/*    */   private static final String __OBFID = "CL_00000980";
/*    */   
/*    */   public RenderBlaze() {
/* 12 */     super((ModelBase)new ModelBlaze(), 0.5F);
/* 13 */     this.field_77068_a = ((ModelBlaze)this.field_77045_g).func_78104_a();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76986_a(EntityBlaze p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 18 */     int i = ((ModelBlaze)this.field_77045_g).func_78104_a();
/* 19 */     if (i != this.field_77068_a) {
/* 20 */       this.field_77068_a = i;
/* 21 */       this.field_77045_g = (ModelBase)new ModelBlaze();
/*    */     } 
/* 23 */     super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityBlaze p_110775_1_) {
/* 28 */     return field_110837_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderBlaze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */