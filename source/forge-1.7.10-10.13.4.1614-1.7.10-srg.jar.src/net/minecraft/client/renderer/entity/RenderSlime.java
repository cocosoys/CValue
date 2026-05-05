/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.monster.EntitySlime;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderSlime extends RenderLiving {
/*  9 */   private static final ResourceLocation field_110897_a = new ResourceLocation("textures/entity/slime/slime.png"); private ModelBase field_77092_a;
/*    */   private static final String __OBFID = "CL_00001024";
/*    */   
/*    */   public RenderSlime(ModelBase p_i1267_1_, ModelBase p_i1267_2_, float p_i1267_3_) {
/* 13 */     super(p_i1267_1_, p_i1267_3_);
/* 14 */     this.field_77092_a = p_i1267_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int func_77032_a(EntitySlime p_77032_1_, int p_77032_2_, float p_77032_3_) {
/* 19 */     if (p_77032_1_.func_82150_aj()) {
/* 20 */       return 0;
/*    */     }
/* 22 */     if (p_77032_2_ == 0) {
/* 23 */       func_77042_a(this.field_77092_a);
/*    */       
/* 25 */       GL11.glEnable(2977);
/* 26 */       GL11.glEnable(3042);
/* 27 */       GL11.glBlendFunc(770, 771);
/*    */       
/* 29 */       return 1;
/*    */     } 
/* 31 */     if (p_77032_2_ == 1) {
/* 32 */       GL11.glDisable(3042);
/* 33 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */     } 
/* 35 */     return -1;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77041_b(EntitySlime p_77041_1_, float p_77041_2_) {
/* 40 */     float f1 = p_77041_1_.func_70809_q();
/* 41 */     float f2 = (p_77041_1_.field_70812_c + (p_77041_1_.field_70811_b - p_77041_1_.field_70812_c) * p_77041_2_) / (f1 * 0.5F + 1.0F);
/* 42 */     float f3 = 1.0F / (f2 + 1.0F);
/* 43 */     GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntitySlime p_110775_1_) {
/* 48 */     return field_110897_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderSlime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */