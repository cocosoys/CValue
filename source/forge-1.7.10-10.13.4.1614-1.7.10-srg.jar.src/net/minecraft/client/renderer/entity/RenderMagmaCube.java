/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.model.ModelMagmaCube;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.monster.EntityMagmaCube;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderMagmaCube extends RenderLiving {
/* 11 */   private static final ResourceLocation field_110873_a = new ResourceLocation("textures/entity/slime/magmacube.png"); private static final String __OBFID = "CL_00001009";
/*    */   
/*    */   public RenderMagmaCube() {
/* 14 */     super((ModelBase)new ModelMagmaCube(), 0.25F);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityMagmaCube p_110775_1_) {
/* 19 */     return field_110873_a;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77041_b(EntityMagmaCube p_77041_1_, float p_77041_2_) {
/* 24 */     int i = p_77041_1_.func_70809_q();
/* 25 */     float f1 = (p_77041_1_.field_70812_c + (p_77041_1_.field_70811_b - p_77041_1_.field_70812_c) * p_77041_2_) / (i * 0.5F + 1.0F);
/* 26 */     float f2 = 1.0F / (f1 + 1.0F);
/* 27 */     float f3 = i;
/* 28 */     GL11.glScalef(f2 * f3, 1.0F / f2 * f3, f2 * f3);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderMagmaCube.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */