/*    */ package net.minecraft.client.particle;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.RenderHelper;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityLargeExplodeFX
/*    */   extends EntityFX
/*    */ {
/* 16 */   private static final ResourceLocation field_110127_a = new ResourceLocation("textures/entity/explosion.png");
/*    */   
/*    */   private int field_70581_a;
/*    */   
/*    */   private int field_70584_aq;
/*    */   
/*    */   public EntityLargeExplodeFX(TextureManager p_i1213_1_, World p_i1213_2_, double p_i1213_3_, double p_i1213_5_, double p_i1213_7_, double p_i1213_9_, double p_i1213_11_, double p_i1213_13_) {
/* 23 */     super(p_i1213_2_, p_i1213_3_, p_i1213_5_, p_i1213_7_, 0.0D, 0.0D, 0.0D);
/* 24 */     this.field_70583_ar = p_i1213_1_;
/* 25 */     this.field_70584_aq = 6 + this.field_70146_Z.nextInt(4);
/* 26 */     this.field_70552_h = this.field_70553_i = this.field_70551_j = this.field_70146_Z.nextFloat() * 0.6F + 0.4F;
/* 27 */     this.field_70582_as = 1.0F - (float)p_i1213_9_ * 0.5F;
/*    */   }
/*    */   private TextureManager field_70583_ar; private float field_70582_as; private static final String __OBFID = "CL_00000910";
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 32 */     int i = (int)((this.field_70581_a + p_70539_2_) * 15.0F / this.field_70584_aq);
/* 33 */     if (i > 15)
/* 34 */       return;  this.field_70583_ar.func_110577_a(field_110127_a);
/*    */     
/* 36 */     float f1 = (i % 4) / 4.0F;
/* 37 */     float f2 = f1 + 0.24975F;
/* 38 */     float f3 = (i / 4) / 4.0F;
/* 39 */     float f4 = f3 + 0.24975F;
/*    */     
/* 41 */     float f5 = 2.0F * this.field_70582_as;
/*    */     
/* 43 */     float f6 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * p_70539_2_ - field_70556_an);
/* 44 */     float f7 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * p_70539_2_ - field_70554_ao);
/* 45 */     float f8 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * p_70539_2_ - field_70555_ap);
/* 46 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 47 */     GL11.glDisable(2896);
/* 48 */     RenderHelper.func_74518_a();
/* 49 */     p_70539_1_.func_78382_b();
/* 50 */     p_70539_1_.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, 1.0F);
/* 51 */     p_70539_1_.func_78375_b(0.0F, 1.0F, 0.0F);
/* 52 */     p_70539_1_.func_78380_c(240);
/* 53 */     p_70539_1_.func_78374_a((f6 - p_70539_3_ * f5 - p_70539_6_ * f5), (f7 - p_70539_4_ * f5), (f8 - p_70539_5_ * f5 - p_70539_7_ * f5), f2, f4);
/* 54 */     p_70539_1_.func_78374_a((f6 - p_70539_3_ * f5 + p_70539_6_ * f5), (f7 + p_70539_4_ * f5), (f8 - p_70539_5_ * f5 + p_70539_7_ * f5), f2, f3);
/* 55 */     p_70539_1_.func_78374_a((f6 + p_70539_3_ * f5 + p_70539_6_ * f5), (f7 + p_70539_4_ * f5), (f8 + p_70539_5_ * f5 + p_70539_7_ * f5), f1, f3);
/* 56 */     p_70539_1_.func_78374_a((f6 + p_70539_3_ * f5 - p_70539_6_ * f5), (f7 - p_70539_4_ * f5), (f8 + p_70539_5_ * f5 - p_70539_7_ * f5), f1, f4);
/* 57 */     p_70539_1_.func_78381_a();
/* 58 */     GL11.glPolygonOffset(0.0F, 0.0F);
/* 59 */     GL11.glEnable(2896);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_70070_b(float p_70070_1_) {
/* 64 */     return 61680;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 69 */     this.field_70169_q = this.field_70165_t;
/* 70 */     this.field_70167_r = this.field_70163_u;
/* 71 */     this.field_70166_s = this.field_70161_v;
/* 72 */     this.field_70581_a++;
/* 73 */     if (this.field_70581_a == this.field_70584_aq) func_70106_y();
/*    */   
/*    */   }
/*    */   
/*    */   public int func_70537_b() {
/* 78 */     return 3;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityLargeExplodeFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */