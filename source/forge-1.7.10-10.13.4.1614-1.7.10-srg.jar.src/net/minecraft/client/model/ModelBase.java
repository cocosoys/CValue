/*    */ package net.minecraft.client.model;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public abstract class ModelBase {
/*    */   public float field_78095_p;
/* 11 */   public List field_78092_r = new ArrayList(); public boolean field_78093_q;
/*    */   public boolean field_78091_s = true;
/* 13 */   private Map field_78094_a = new HashMap<Object, Object>();
/* 14 */   public int field_78090_t = 64;
/* 15 */   public int field_78089_u = 32;
/*    */   
/*    */   private static final String __OBFID = "CL_00000845";
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {}
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {}
/*    */   
/*    */   public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {}
/*    */   
/*    */   public ModelRenderer func_85181_a(Random p_85181_1_) {
/* 27 */     return this.field_78092_r.get(p_85181_1_.nextInt(this.field_78092_r.size()));
/*    */   }
/*    */   
/*    */   protected void func_78085_a(String p_78085_1_, int p_78085_2_, int p_78085_3_) {
/* 31 */     this.field_78094_a.put(p_78085_1_, new TextureOffset(p_78085_2_, p_78085_3_));
/*    */   }
/*    */   
/*    */   public TextureOffset func_78084_a(String p_78084_1_) {
/* 35 */     return (TextureOffset)this.field_78094_a.get(p_78084_1_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\model\ModelBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */