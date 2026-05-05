/*    */ package net.minecraft.client.renderer;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.nio.FloatBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockLiquid;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.ChunkPosition;
/*    */ import net.minecraft.world.World;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ import org.lwjgl.util.glu.GLU;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ActiveRenderInfo {
/*    */   public static float field_74592_a;
/*    */   public static float field_74590_b;
/*    */   public static float field_74591_c;
/* 23 */   private static IntBuffer field_74597_i = GLAllocation.func_74527_f(16);
/* 24 */   private static FloatBuffer field_74594_j = GLAllocation.func_74529_h(16);
/* 25 */   private static FloatBuffer field_74595_k = GLAllocation.func_74529_h(16);
/*    */   
/* 27 */   private static FloatBuffer field_74593_l = GLAllocation.func_74529_h(3);
/*    */   
/*    */   public static float field_74588_d;
/*    */   
/*    */   public static void func_74583_a(EntityPlayer p_74583_0_, boolean p_74583_1_) {
/* 32 */     GL11.glGetFloat(2982, field_74594_j);
/* 33 */     GL11.glGetFloat(2983, field_74595_k);
/* 34 */     GL11.glGetInteger(2978, field_74597_i);
/*    */     
/* 36 */     float f1 = ((field_74597_i.get(0) + field_74597_i.get(2)) / 2);
/* 37 */     float f2 = ((field_74597_i.get(1) + field_74597_i.get(3)) / 2);
/* 38 */     GLU.gluUnProject(f1, f2, 0.0F, field_74594_j, field_74595_k, field_74597_i, field_74593_l);
/*    */     
/* 40 */     field_74592_a = field_74593_l.get(0);
/* 41 */     field_74590_b = field_74593_l.get(1);
/* 42 */     field_74591_c = field_74593_l.get(2);
/*    */     
/* 44 */     byte b = p_74583_1_ ? 1 : 0;
/*    */     
/* 46 */     float f3 = p_74583_0_.field_70125_A;
/* 47 */     float f4 = p_74583_0_.field_70177_z;
/*    */     
/* 49 */     field_74588_d = MathHelper.func_76134_b(f4 * 3.1415927F / 180.0F) * (1 - b * 2);
/* 50 */     field_74586_f = MathHelper.func_76126_a(f4 * 3.1415927F / 180.0F) * (1 - b * 2);
/*    */     
/* 52 */     field_74587_g = -field_74586_f * MathHelper.func_76126_a(f3 * 3.1415927F / 180.0F) * (1 - b * 2);
/* 53 */     field_74596_h = field_74588_d * MathHelper.func_76126_a(f3 * 3.1415927F / 180.0F) * (1 - b * 2);
/* 54 */     field_74589_e = MathHelper.func_76134_b(f3 * 3.1415927F / 180.0F);
/*    */   }
/*    */   public static float field_74589_e; public static float field_74586_f;
/*    */   public static float field_74587_g;
/*    */   public static float field_74596_h;
/*    */   private static final String __OBFID = "CL_00000626";
/*    */   
/*    */   public static Vec3 func_74585_b(EntityLivingBase p_74585_0_, double p_74585_1_) {
/* 62 */     double d1 = p_74585_0_.field_70169_q + (p_74585_0_.field_70165_t - p_74585_0_.field_70169_q) * p_74585_1_;
/* 63 */     double d2 = p_74585_0_.field_70167_r + (p_74585_0_.field_70163_u - p_74585_0_.field_70167_r) * p_74585_1_ + p_74585_0_.func_70047_e();
/* 64 */     double d3 = p_74585_0_.field_70166_s + (p_74585_0_.field_70161_v - p_74585_0_.field_70166_s) * p_74585_1_;
/*    */     
/* 66 */     double d4 = d1 + (field_74592_a * 1.0F);
/* 67 */     double d5 = d2 + (field_74590_b * 1.0F);
/* 68 */     double d6 = d3 + (field_74591_c * 1.0F);
/*    */     
/* 70 */     return Vec3.func_72443_a(d4, d5, d6);
/*    */   }
/*    */   
/*    */   public static Block func_151460_a(World p_151460_0_, EntityLivingBase p_151460_1_, float p_151460_2_) {
/* 74 */     Vec3 vec3 = func_74585_b(p_151460_1_, p_151460_2_);
/* 75 */     ChunkPosition chunkPosition = new ChunkPosition(vec3);
/* 76 */     Block block = p_151460_0_.func_147439_a(chunkPosition.field_151329_a, chunkPosition.field_151327_b, chunkPosition.field_151328_c);
/* 77 */     if (block.func_149688_o().func_76224_d()) {
/* 78 */       float f1 = BlockLiquid.func_149801_b(p_151460_0_.func_72805_g(chunkPosition.field_151329_a, chunkPosition.field_151327_b, chunkPosition.field_151328_c)) - 0.11111111F;
/* 79 */       float f2 = (chunkPosition.field_151327_b + 1) - f1;
/* 80 */       if (vec3.field_72448_b >= f2) {
/* 81 */         block = p_151460_0_.func_147439_a(chunkPosition.field_151329_a, chunkPosition.field_151327_b + 1, chunkPosition.field_151328_c);
/*    */       }
/*    */     } 
/* 84 */     return block;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\ActiveRenderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */