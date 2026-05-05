/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import JinRyuu.JRMCore.JRMCoreHJBRA;
/*    */ import JinRyuu.JRMCore.items.ItemVanity;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.ItemArmor;
/*    */ 
/*    */ public class VanityColor
/*    */   extends ItemVanity {
/* 14 */   private final int VANITY_ANDROID_21_COAT = 0; private final int VANITY_ANDROID_21_BOOT = 1;
/* 15 */   private int type = -1;
/*    */   
/*    */   public VanityColor(int defcol, ItemArmor.ArmorMaterial par2ArmorMaterial, int par3, String armornamePrefix) {
/* 18 */     super(defcol, par3, armornamePrefix);
/* 19 */     this.rl = par2ArmorMaterial;
/* 20 */     func_77637_a(mod_DragonBC.DragonBlockC);
/* 21 */     this.modid = "jinryuudragonbc";
/*    */   }
/*    */   
/*    */   public VanityColor(int defcol, ItemArmor.ArmorMaterial par2ArmorMaterial, int par3, String armornamePrefix, int type) {
/* 25 */     super(defcol, par3, armornamePrefix);
/* 26 */     this.rl = par2ArmorMaterial;
/* 27 */     func_77637_a(mod_DragonBC.DragonBlockC);
/* 28 */     this.modid = "jinryuudragonbc";
/* 29 */     this.type = type;
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public ModelBiped giMdl(int slt, EntityLivingBase e) {
/* 35 */     if (wear(e)) {
/*    */ 
/*    */       
/* 38 */       boolean has = false;
/* 39 */       for (int i = 0; i < ItemsDBC.ItemsVanityNum.length; i++) {
/* 40 */         if (ItemsDBC.ItemVanity3[i] > -1 && 
/* 41 */           this.type == ItemsDBC.ItemVanity3[i]) {
/* 42 */           has = true;
/* 43 */           return JRMCoreHJBRA.DBC_GiTurtleMdl2[this.type];
/*    */         } 
/*    */       } 
/*    */ 
/*    */ 
/*    */       
/* 49 */       if (!has) {
/* 50 */         if (slt != 5) {
/* 51 */           if (func_77658_a().contains("Head")) return JRMCoreHJBRA.GiTurtleMdl2; 
/* 52 */           return JRMCoreHJBRA.GiTurtleMdl3;
/*    */         } 
/* 54 */         return JRMCoreHJBRA.GiTurtleMdl2;
/*    */       } 
/*    */     } 
/* 57 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\VanityColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */