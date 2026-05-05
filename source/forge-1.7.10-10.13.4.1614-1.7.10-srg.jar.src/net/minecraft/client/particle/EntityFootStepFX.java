/*    */ package net.minecraft.client.particle;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityFootStepFX
/*    */   extends EntityFX
/*    */ {
/* 19 */   private static final ResourceLocation field_110126_a = new ResourceLocation("textures/particle/footprint.png");
/*    */   
/*    */   private int field_70576_a;
/*    */   private int field_70578_aq;
/*    */   
/*    */   public EntityFootStepFX(TextureManager p_i1210_1_, World p_i1210_2_, double p_i1210_3_, double p_i1210_5_, double p_i1210_7_) {
/* 25 */     super(p_i1210_2_, p_i1210_3_, p_i1210_5_, p_i1210_7_, 0.0D, 0.0D, 0.0D);
/* 26 */     this.field_70577_ar = p_i1210_1_;
/* 27 */     this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
/* 28 */     this.field_70578_aq = 200;
/*    */   }
/*    */   private TextureManager field_70577_ar; private static final String __OBFID = "CL_00000908";
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 33 */     float f1 = (this.field_70576_a + p_70539_2_) / this.field_70578_aq;
/* 34 */     f1 *= f1;
/*    */     
/* 36 */     float f2 = 2.0F - f1 * 2.0F;
/* 37 */     if (f2 > 1.0F) f2 = 1.0F; 
/* 38 */     f2 *= 0.2F;
/*    */     
/* 40 */     GL11.glDisable(2896);
/* 41 */     float f3 = 0.125F;
/*    */     
/* 43 */     float f4 = (float)(this.field_70165_t - field_70556_an);
/* 44 */     float f5 = (float)(this.field_70163_u - field_70554_ao);
/* 45 */     float f6 = (float)(this.field_70161_v - field_70555_ap);
/*    */     
/* 47 */     float f7 = this.field_70170_p.func_72801_o(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v));
/*    */     
/* 49 */     this.field_70577_ar.func_110577_a(field_110126_a);
/* 50 */     GL11.glEnable(3042);
/* 51 */     GL11.glBlendFunc(770, 771);
/*    */     
/* 53 */     p_70539_1_.func_78382_b();
/* 54 */     p_70539_1_.func_78369_a(f7, f7, f7, f2);
/* 55 */     p_70539_1_.func_78374_a((f4 - f3), f5, (f6 + f3), 0.0D, 1.0D);
/* 56 */     p_70539_1_.func_78374_a((f4 + f3), f5, (f6 + f3), 1.0D, 1.0D);
/* 57 */     p_70539_1_.func_78374_a((f4 + f3), f5, (f6 - f3), 1.0D, 0.0D);
/* 58 */     p_70539_1_.func_78374_a((f4 - f3), f5, (f6 - f3), 0.0D, 0.0D);
/* 59 */     p_70539_1_.func_78381_a();
/*    */     
/* 61 */     GL11.glDisable(3042);
/* 62 */     GL11.glEnable(2896);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 67 */     this.field_70576_a++;
/* 68 */     if (this.field_70576_a == this.field_70578_aq) func_70106_y();
/*    */   
/*    */   }
/*    */   
/*    */   public int func_70537_b() {
/* 73 */     return 3;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityFootStepFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */