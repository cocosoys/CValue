/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.monster.EntityGiantZombie;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderGiantZombie extends RenderLiving {
/* 10 */   private static final ResourceLocation field_110871_a = new ResourceLocation("textures/entity/zombie/zombie.png"); private float field_77073_a;
/*    */   private static final String __OBFID = "CL_00000998";
/*    */   
/*    */   public RenderGiantZombie(ModelBase p_i1255_1_, float p_i1255_2_, float p_i1255_3_) {
/* 14 */     super(p_i1255_1_, p_i1255_2_ * p_i1255_3_);
/* 15 */     this.field_77073_a = p_i1255_3_;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77041_b(EntityGiantZombie p_77041_1_, float p_77041_2_) {
/* 20 */     GL11.glScalef(this.field_77073_a, this.field_77073_a, this.field_77073_a);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityGiantZombie p_110775_1_) {
/* 25 */     return field_110871_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderGiantZombie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */