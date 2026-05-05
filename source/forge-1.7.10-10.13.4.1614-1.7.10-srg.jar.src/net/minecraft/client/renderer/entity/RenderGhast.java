/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.model.ModelGhast;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.monster.EntityGhast;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderGhast extends RenderLiving {
/* 11 */   private static final ResourceLocation field_110869_a = new ResourceLocation("textures/entity/ghast/ghast.png");
/* 12 */   private static final ResourceLocation field_110868_f = new ResourceLocation("textures/entity/ghast/ghast_shooting.png"); private static final String __OBFID = "CL_00000997";
/*    */   
/*    */   public RenderGhast() {
/* 15 */     super((ModelBase)new ModelGhast(), 0.5F);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityGhast p_110775_1_) {
/* 20 */     if (p_110775_1_.func_110182_bF()) {
/* 21 */       return field_110868_f;
/*    */     }
/*    */     
/* 24 */     return field_110869_a;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77041_b(EntityGhast p_77041_1_, float p_77041_2_) {
/* 29 */     EntityGhast entityGhast = p_77041_1_;
/*    */     
/* 31 */     float f1 = (entityGhast.field_70794_e + (entityGhast.field_70791_f - entityGhast.field_70794_e) * p_77041_2_) / 20.0F;
/* 32 */     if (f1 < 0.0F) f1 = 0.0F; 
/* 33 */     f1 = 1.0F / (f1 * f1 * f1 * f1 * f1 * 2.0F + 1.0F);
/* 34 */     float f2 = (8.0F + f1) / 2.0F;
/* 35 */     float f3 = (8.0F + 1.0F / f1) / 2.0F;
/* 36 */     GL11.glScalef(f3, f2, f3);
/* 37 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderGhast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */