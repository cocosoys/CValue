/*    */ package net.minecraft.client.particle;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.world.World;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityPickupFX extends EntityFX {
/*    */   private Entity field_70591_a;
/*    */   private Entity field_70595_aq;
/*    */   private int field_70594_ar;
/*    */   
/*    */   public EntityPickupFX(World p_i1233_1_, Entity p_i1233_2_, Entity p_i1233_3_, float p_i1233_4_) {
/* 18 */     super(p_i1233_1_, p_i1233_2_.field_70165_t, p_i1233_2_.field_70163_u, p_i1233_2_.field_70161_v, p_i1233_2_.field_70159_w, p_i1233_2_.field_70181_x, p_i1233_2_.field_70179_y);
/* 19 */     this.field_70591_a = p_i1233_2_;
/* 20 */     this.field_70595_aq = p_i1233_3_;
/* 21 */     this.field_70593_as = 3;
/* 22 */     this.field_70592_at = p_i1233_4_;
/*    */   }
/*    */   private int field_70593_as; private float field_70592_at; private static final String __OBFID = "CL_00000930";
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 27 */     float f = (this.field_70594_ar + p_70539_2_) / this.field_70593_as;
/* 28 */     f *= f;
/*    */     
/* 30 */     double d1 = this.field_70591_a.field_70165_t;
/* 31 */     double d2 = this.field_70591_a.field_70163_u;
/* 32 */     double d3 = this.field_70591_a.field_70161_v;
/*    */     
/* 34 */     double d4 = this.field_70595_aq.field_70142_S + (this.field_70595_aq.field_70165_t - this.field_70595_aq.field_70142_S) * p_70539_2_;
/* 35 */     double d5 = this.field_70595_aq.field_70137_T + (this.field_70595_aq.field_70163_u - this.field_70595_aq.field_70137_T) * p_70539_2_ + this.field_70592_at;
/* 36 */     double d6 = this.field_70595_aq.field_70136_U + (this.field_70595_aq.field_70161_v - this.field_70595_aq.field_70136_U) * p_70539_2_;
/*    */     
/* 38 */     double d7 = d1 + (d4 - d1) * f;
/* 39 */     double d8 = d2 + (d5 - d2) * f;
/* 40 */     double d9 = d3 + (d6 - d3) * f;
/*    */     
/* 42 */     int i = func_70070_b(p_70539_2_);
/* 43 */     int j = i % 65536;
/* 44 */     int k = i / 65536;
/* 45 */     OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, j / 1.0F, k / 1.0F);
/* 46 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */     
/* 48 */     d7 -= field_70556_an;
/* 49 */     d8 -= field_70554_ao;
/* 50 */     d9 -= field_70555_ap;
/*    */     
/* 52 */     RenderManager.field_78727_a.func_147940_a(this.field_70591_a, (float)d7, (float)d8, (float)d9, this.field_70591_a.field_70177_z, p_70539_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 57 */     this.field_70594_ar++;
/* 58 */     if (this.field_70594_ar == this.field_70593_as) func_70106_y();
/*    */   
/*    */   }
/*    */   
/*    */   public int func_70537_b() {
/* 63 */     return 3;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityPickupFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */