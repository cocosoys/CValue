/*    */ package net.minecraft.client.renderer.culling;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ClippingHelper
/*    */ {
/* 21 */   public float[][] field_78557_a = new float[16][16];
/* 22 */   public float[] field_78555_b = new float[16];
/* 23 */   public float[] field_78556_c = new float[16];
/* 24 */   public float[] field_78554_d = new float[16];
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00000977";
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_78553_b(double p_78553_1_, double p_78553_3_, double p_78553_5_, double p_78553_7_, double p_78553_9_, double p_78553_11_) {
/* 70 */     for (byte b = 0; b < 6; b++) {
/* 71 */       if (this.field_78557_a[b][0] * p_78553_1_ + this.field_78557_a[b][1] * p_78553_3_ + this.field_78557_a[b][2] * p_78553_5_ + this.field_78557_a[b][3] <= 0.0D)
/*    */       {
/* 73 */         if (this.field_78557_a[b][0] * p_78553_7_ + this.field_78557_a[b][1] * p_78553_3_ + this.field_78557_a[b][2] * p_78553_5_ + this.field_78557_a[b][3] <= 0.0D)
/*    */         {
/* 75 */           if (this.field_78557_a[b][0] * p_78553_1_ + this.field_78557_a[b][1] * p_78553_9_ + this.field_78557_a[b][2] * p_78553_5_ + this.field_78557_a[b][3] <= 0.0D)
/*    */           {
/* 77 */             if (this.field_78557_a[b][0] * p_78553_7_ + this.field_78557_a[b][1] * p_78553_9_ + this.field_78557_a[b][2] * p_78553_5_ + this.field_78557_a[b][3] <= 0.0D)
/*    */             {
/* 79 */               if (this.field_78557_a[b][0] * p_78553_1_ + this.field_78557_a[b][1] * p_78553_3_ + this.field_78557_a[b][2] * p_78553_11_ + this.field_78557_a[b][3] <= 0.0D)
/*    */               {
/* 81 */                 if (this.field_78557_a[b][0] * p_78553_7_ + this.field_78557_a[b][1] * p_78553_3_ + this.field_78557_a[b][2] * p_78553_11_ + this.field_78557_a[b][3] <= 0.0D)
/*    */                 {
/* 83 */                   if (this.field_78557_a[b][0] * p_78553_1_ + this.field_78557_a[b][1] * p_78553_9_ + this.field_78557_a[b][2] * p_78553_11_ + this.field_78557_a[b][3] <= 0.0D)
/*    */                   {
/* 85 */                     if (this.field_78557_a[b][0] * p_78553_7_ + this.field_78557_a[b][1] * p_78553_9_ + this.field_78557_a[b][2] * p_78553_11_ + this.field_78557_a[b][3] <= 0.0D)
/*    */                     {
/*    */                       
/* 88 */                       return false; }  }  }  }  }  }  } 
/*    */       }
/*    */     } 
/* 91 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\culling\ClippingHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */