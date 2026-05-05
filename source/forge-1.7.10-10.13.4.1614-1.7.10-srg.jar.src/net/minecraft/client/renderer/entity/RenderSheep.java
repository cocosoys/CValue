/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.passive.EntitySheep;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderSheep extends RenderLiving {
/*  9 */   private static final ResourceLocation field_110885_a = new ResourceLocation("textures/entity/sheep/sheep_fur.png");
/* 10 */   private static final ResourceLocation field_110884_f = new ResourceLocation("textures/entity/sheep/sheep.png"); private static final String __OBFID = "CL_00001021";
/*    */   
/*    */   public RenderSheep(ModelBase p_i1266_1_, ModelBase p_i1266_2_, float p_i1266_3_) {
/* 13 */     super(p_i1266_1_, p_i1266_3_);
/* 14 */     func_77042_a(p_i1266_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_77032_a(EntitySheep p_77032_1_, int p_77032_2_, float p_77032_3_) {
/* 19 */     if (p_77032_2_ == 0 && !p_77032_1_.func_70892_o()) {
/* 20 */       func_110776_a(field_110885_a);
/*    */       
/* 22 */       if (p_77032_1_.func_94056_bM() && "jeb_".equals(p_77032_1_.func_94057_bL())) {
/*    */         
/* 24 */         byte b = 25;
/* 25 */         int i = p_77032_1_.field_70173_aa / 25 + p_77032_1_.func_145782_y();
/* 26 */         int j = i % EntitySheep.field_70898_d.length;
/* 27 */         int k = (i + 1) % EntitySheep.field_70898_d.length;
/* 28 */         float f = ((p_77032_1_.field_70173_aa % 25) + p_77032_3_) / 25.0F;
/*    */         
/* 30 */         GL11.glColor3f(EntitySheep.field_70898_d[j][0] * (1.0F - f) + EntitySheep.field_70898_d[k][0] * f, EntitySheep.field_70898_d[j][1] * (1.0F - f) + EntitySheep.field_70898_d[k][1] * f, EntitySheep.field_70898_d[j][2] * (1.0F - f) + EntitySheep.field_70898_d[k][2] * f);
/*    */       } else {
/*    */         
/* 33 */         int i = p_77032_1_.func_70896_n();
/* 34 */         GL11.glColor3f(EntitySheep.field_70898_d[i][0], EntitySheep.field_70898_d[i][1], EntitySheep.field_70898_d[i][2]);
/*    */       } 
/*    */       
/* 37 */       return 1;
/*    */     } 
/* 39 */     return -1;
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntitySheep p_110775_1_) {
/* 44 */     return field_110884_f;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderSheep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */