/*    */ package net.minecraft.client.renderer.entity;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelIronGolem;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.monster.EntityIronGolem;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderIronGolem extends RenderLiving {
/* 16 */   private static final ResourceLocation field_110899_a = new ResourceLocation("textures/entity/iron_golem.png"); private final ModelIronGolem field_77050_a;
/*    */   private static final String __OBFID = "CL_00001031";
/*    */   
/*    */   public RenderIronGolem() {
/* 20 */     super((ModelBase)new ModelIronGolem(), 0.5F);
/* 21 */     this.field_77050_a = (ModelIronGolem)this.field_77045_g;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76986_a(EntityIronGolem p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 26 */     super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityIronGolem p_110775_1_) {
/* 31 */     return field_110899_a;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77043_a(EntityIronGolem p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
/* 36 */     super.func_77043_a((EntityLivingBase)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
/* 37 */     if (p_77043_1_.field_70721_aZ < 0.01D)
/*    */       return; 
/* 39 */     float f1 = 13.0F;
/* 40 */     float f2 = p_77043_1_.field_70754_ba - p_77043_1_.field_70721_aZ * (1.0F - p_77043_4_) + 6.0F;
/* 41 */     float f3 = (Math.abs(f2 % f1 - f1 * 0.5F) - f1 * 0.25F) / f1 * 0.25F;
/* 42 */     GL11.glRotatef(6.5F * f3, 0.0F, 0.0F, 1.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77029_c(EntityIronGolem p_77029_1_, float p_77029_2_) {
/* 47 */     super.func_77029_c((EntityLivingBase)p_77029_1_, p_77029_2_);
/* 48 */     if (p_77029_1_.func_70853_p() == 0)
/*    */       return; 
/* 50 */     GL11.glEnable(32826);
/* 51 */     GL11.glPushMatrix();
/*    */ 
/*    */     
/* 54 */     GL11.glRotatef(5.0F + 180.0F * this.field_77050_a.field_78177_c.field_78795_f / 3.1415927F, 1.0F, 0.0F, 0.0F);
/* 55 */     GL11.glTranslatef(-0.6875F, 1.25F, -0.9375F);
/* 56 */     GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/* 57 */     float f = 0.8F;
/* 58 */     GL11.glScalef(f, -f, f);
/*    */     
/* 60 */     int i = p_77029_1_.func_70070_b(p_77029_2_);
/* 61 */     int j = i % 65536;
/* 62 */     int k = i / 65536;
/* 63 */     OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, j / 1.0F, k / 1.0F);
/*    */     
/* 65 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 66 */     func_110776_a(TextureMap.field_110575_b);
/* 67 */     this.field_147909_c.func_147800_a((Block)Blocks.field_150328_O, 0, 1.0F);
/* 68 */     GL11.glPopMatrix();
/* 69 */     GL11.glDisable(32826);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderIronGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */