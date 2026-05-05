/*    */ package net.minecraft.client.renderer.entity;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockDragonEgg;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityFallingBlock;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderFallingBlock extends Render {
/* 17 */   private final RenderBlocks field_147920_a = new RenderBlocks(); private static final String __OBFID = "CL_00000994";
/*    */   
/*    */   public RenderFallingBlock() {
/* 20 */     this.field_76989_e = 0.5F;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_76986_a(EntityFallingBlock p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 25 */     World world = p_76986_1_.func_145807_e();
/* 26 */     Block block = p_76986_1_.func_145805_f();
/*    */     
/* 28 */     int i = MathHelper.func_76128_c(p_76986_1_.field_70165_t);
/* 29 */     int j = MathHelper.func_76128_c(p_76986_1_.field_70163_u);
/* 30 */     int k = MathHelper.func_76128_c(p_76986_1_.field_70161_v);
/* 31 */     if (block != null && block != world.func_147439_a(i, j, k)) {
/*    */       
/* 33 */       GL11.glPushMatrix();
/* 34 */       GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
/*    */       
/* 36 */       func_110777_b((Entity)p_76986_1_);
/*    */       
/* 38 */       GL11.glDisable(2896);
/* 39 */       if (block instanceof BlockAnvil) {
/* 40 */         this.field_147920_a.field_147845_a = (IBlockAccess)world;
/* 41 */         Tessellator tessellator = Tessellator.field_78398_a;
/* 42 */         tessellator.func_78382_b();
/* 43 */         tessellator.func_78373_b((-i - 0.5F), (-j - 0.5F), (-k - 0.5F));
/* 44 */         this.field_147920_a.func_147780_a((BlockAnvil)block, i, j, k, p_76986_1_.field_145814_a);
/* 45 */         tessellator.func_78373_b(0.0D, 0.0D, 0.0D);
/* 46 */         tessellator.func_78381_a();
/* 47 */       } else if (block instanceof BlockDragonEgg) {
/* 48 */         this.field_147920_a.field_147845_a = (IBlockAccess)world;
/* 49 */         Tessellator tessellator = Tessellator.field_78398_a;
/* 50 */         tessellator.func_78382_b();
/* 51 */         tessellator.func_78373_b((-i - 0.5F), (-j - 0.5F), (-k - 0.5F));
/* 52 */         this.field_147920_a.func_147802_a((BlockDragonEgg)block, i, j, k);
/* 53 */         tessellator.func_78373_b(0.0D, 0.0D, 0.0D);
/* 54 */         tessellator.func_78381_a();
/*    */       } else {
/* 56 */         this.field_147920_a.func_147775_a(block);
/* 57 */         this.field_147920_a.func_147749_a(block, world, i, j, k, p_76986_1_.field_145814_a);
/*    */       } 
/* 59 */       GL11.glEnable(2896);
/* 60 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityFallingBlock p_110775_1_) {
/* 66 */     return TextureMap.field_110575_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderFallingBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */