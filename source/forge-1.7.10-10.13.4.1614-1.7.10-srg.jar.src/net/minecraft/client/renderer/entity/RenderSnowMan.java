/*    */ package net.minecraft.client.renderer.entity;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelSnowMan;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.monster.EntitySnowman;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderSnowMan extends RenderLiving {
/* 14 */   private static final ResourceLocation field_110895_a = new ResourceLocation("textures/entity/snowman.png"); private ModelSnowMan field_77094_a;
/*    */   private static final String __OBFID = "CL_00001025";
/*    */   
/*    */   public RenderSnowMan() {
/* 18 */     super((ModelBase)new ModelSnowMan(), 0.5F);
/* 19 */     this.field_77094_a = (ModelSnowMan)this.field_77045_g;
/* 20 */     func_77042_a((ModelBase)this.field_77094_a);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77029_c(EntitySnowman p_77029_1_, float p_77029_2_) {
/* 25 */     super.func_77029_c((EntityLivingBase)p_77029_1_, p_77029_2_);
/* 26 */     ItemStack itemStack = new ItemStack(Blocks.field_150423_aK, 1);
/* 27 */     if (itemStack.func_77973_b() instanceof net.minecraft.item.ItemBlock) {
/* 28 */       GL11.glPushMatrix();
/* 29 */       this.field_77094_a.field_78195_c.func_78794_c(0.0625F);
/*    */       
/* 31 */       if (RenderBlocks.func_147739_a(Block.func_149634_a(itemStack.func_77973_b()).func_149645_b())) {
/* 32 */         float f = 0.625F;
/* 33 */         GL11.glTranslatef(0.0F, -0.34375F, 0.0F);
/* 34 */         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/* 35 */         GL11.glScalef(f, -f, f);
/*    */       } 
/*    */       
/* 38 */       this.field_76990_c.field_78721_f.func_78443_a((EntityLivingBase)p_77029_1_, itemStack, 0);
/*    */       
/* 40 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntitySnowman p_110775_1_) {
/* 46 */     return field_110895_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderSnowMan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */