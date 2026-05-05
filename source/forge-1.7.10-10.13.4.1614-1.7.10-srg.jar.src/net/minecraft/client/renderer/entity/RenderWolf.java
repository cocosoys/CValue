/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntitySheep;
/*    */ import net.minecraft.entity.passive.EntityWolf;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderWolf extends RenderLiving {
/* 12 */   private static final ResourceLocation field_110917_a = new ResourceLocation("textures/entity/wolf/wolf.png");
/* 13 */   private static final ResourceLocation field_110915_f = new ResourceLocation("textures/entity/wolf/wolf_tame.png");
/* 14 */   private static final ResourceLocation field_110916_g = new ResourceLocation("textures/entity/wolf/wolf_angry.png");
/* 15 */   private static final ResourceLocation field_110918_h = new ResourceLocation("textures/entity/wolf/wolf_collar.png"); private static final String __OBFID = "CL_00001036";
/*    */   
/*    */   public RenderWolf(ModelBase p_i1269_1_, ModelBase p_i1269_2_, float p_i1269_3_) {
/* 18 */     super(p_i1269_1_, p_i1269_3_);
/* 19 */     func_77042_a(p_i1269_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected float func_77044_a(EntityWolf p_77044_1_, float p_77044_2_) {
/* 24 */     return p_77044_1_.func_70920_v();
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_77032_a(EntityWolf p_77032_1_, int p_77032_2_, float p_77032_3_) {
/* 29 */     if (p_77032_2_ == 0 && p_77032_1_.func_70921_u()) {
/* 30 */       float f = p_77032_1_.func_70013_c(p_77032_3_) * p_77032_1_.func_70915_j(p_77032_3_);
/* 31 */       func_110776_a(field_110917_a);
/* 32 */       GL11.glColor3f(f, f, f);
/*    */       
/* 34 */       return 1;
/*    */     } 
/* 36 */     if (p_77032_2_ == 1 && p_77032_1_.func_70909_n()) {
/* 37 */       func_110776_a(field_110918_h);
/* 38 */       int i = p_77032_1_.func_82186_bH();
/* 39 */       GL11.glColor3f(EntitySheep.field_70898_d[i][0], EntitySheep.field_70898_d[i][1], EntitySheep.field_70898_d[i][2]);
/*    */       
/* 41 */       return 1;
/*    */     } 
/* 43 */     return -1;
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityWolf p_110775_1_) {
/* 48 */     if (p_110775_1_.func_70909_n()) {
/* 49 */       return field_110915_f;
/*    */     }
/* 51 */     if (p_110775_1_.func_70919_bu()) {
/* 52 */       return field_110916_g;
/*    */     }
/* 54 */     return field_110917_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderWolf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */