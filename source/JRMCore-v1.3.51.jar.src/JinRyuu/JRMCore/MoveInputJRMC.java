/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.settings.GameSettings;
/*    */ import net.minecraft.util.MovementInput;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MoveInputJRMC
/*    */   extends MovementInput {
/*    */   private GameSettings gameSettings;
/*    */   private static final String __OBFID = "CL_00000937";
/* 13 */   public float moveModifier = 1.0F;
/*    */ 
/*    */   
/*    */   public MoveInputJRMC(GameSettings p_i1237_1_, float mm) {
/* 17 */     this.gameSettings = p_i1237_1_;
/* 18 */     this.moveModifier = mm;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78898_a() {
/* 23 */     this.field_78902_a = 0.0F;
/* 24 */     this.field_78900_b = 0.0F;
/*    */     
/* 26 */     if (this.gameSettings.field_74351_w.func_151470_d())
/*    */     {
/* 28 */       this.field_78900_b++;
/*    */     }
/*    */     
/* 31 */     if (this.gameSettings.field_74368_y.func_151470_d())
/*    */     {
/* 33 */       this.field_78900_b--;
/*    */     }
/*    */     
/* 36 */     if (this.gameSettings.field_74370_x.func_151470_d())
/*    */     {
/* 38 */       this.field_78902_a++;
/*    */     }
/*    */     
/* 41 */     if (this.gameSettings.field_74366_z.func_151470_d())
/*    */     {
/* 43 */       this.field_78902_a--;
/*    */     }
/*    */     
/* 46 */     this.field_78901_c = this.gameSettings.field_74314_A.func_151470_d();
/* 47 */     this.field_78899_d = this.gameSettings.field_74311_E.func_151470_d();
/*    */     
/* 49 */     if (this.field_78899_d) {
/*    */       
/* 51 */       this.field_78902_a = (float)(this.field_78902_a * 0.3D);
/* 52 */       this.field_78900_b = (float)(this.field_78900_b * 0.3D);
/*    */     } 
/* 54 */     this.field_78902_a *= this.moveModifier;
/* 55 */     this.field_78900_b *= this.moveModifier;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\MoveInputJRMC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */