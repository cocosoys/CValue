/*    */ package net.minecraft.client.renderer.entity;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityMooshroom;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderMooshroom extends RenderLiving {
/* 14 */   private static final ResourceLocation field_110880_a = new ResourceLocation("textures/entity/cow/mooshroom.png"); private static final String __OBFID = "CL_00001016";
/*    */   
/*    */   public RenderMooshroom(ModelBase p_i1263_1_, float p_i1263_2_) {
/* 17 */     super(p_i1263_1_, p_i1263_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76986_a(EntityMooshroom p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 22 */     super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityMooshroom p_110775_1_) {
/* 27 */     return field_110880_a;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77029_c(EntityMooshroom p_77029_1_, float p_77029_2_) {
/* 32 */     super.func_77029_c((EntityLivingBase)p_77029_1_, p_77029_2_);
/* 33 */     if (p_77029_1_.func_70631_g_())
/*    */       return; 
/* 35 */     func_110776_a(TextureMap.field_110575_b);
/* 36 */     GL11.glEnable(2884);
/* 37 */     GL11.glPushMatrix();
/* 38 */     GL11.glScalef(1.0F, -1.0F, 1.0F);
/* 39 */     GL11.glTranslatef(0.2F, 0.4F, 0.5F);
/* 40 */     GL11.glRotatef(42.0F, 0.0F, 1.0F, 0.0F);
/* 41 */     this.field_147909_c.func_147800_a((Block)Blocks.field_150337_Q, 0, 1.0F);
/* 42 */     GL11.glTranslatef(0.1F, 0.0F, -0.6F);
/* 43 */     GL11.glRotatef(42.0F, 0.0F, 1.0F, 0.0F);
/* 44 */     this.field_147909_c.func_147800_a((Block)Blocks.field_150337_Q, 0, 1.0F);
/* 45 */     GL11.glPopMatrix();
/*    */     
/* 47 */     GL11.glPushMatrix();
/* 48 */     ((ModelQuadruped)this.field_77045_g).field_78150_a.func_78794_c(0.0625F);
/* 49 */     GL11.glScalef(1.0F, -1.0F, 1.0F);
/* 50 */     GL11.glTranslatef(0.0F, 0.75F, -0.2F);
/* 51 */     GL11.glRotatef(12.0F, 0.0F, 1.0F, 0.0F);
/* 52 */     this.field_147909_c.func_147800_a((Block)Blocks.field_150337_Q, 0, 1.0F);
/* 53 */     GL11.glPopMatrix();
/*    */     
/* 55 */     GL11.glDisable(2884);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderMooshroom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */