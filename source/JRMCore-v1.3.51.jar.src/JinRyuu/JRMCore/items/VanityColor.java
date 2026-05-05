/*    */ package JinRyuu.JRMCore.items;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import JinRyuu.JRMCore.mod_JRMCore;
/*    */ import net.minecraft.item.ItemArmor;
/*    */ 
/*    */ public class VanityColor
/*    */   extends ItemVanity {
/*    */   public VanityColor(int defcol, ItemArmor.ArmorMaterial par2ArmorMaterial, int par3, String armornamePrefix) {
/* 10 */     super(defcol, par3, armornamePrefix);
/* 11 */     this.rl = par2ArmorMaterial;
/* 12 */     func_77637_a(mod_JRMCore.JRMCore);
/* 13 */     this.modid = JRMCoreH.tjjrmc;
/*    */   }
/*    */   
/*    */   public VanityColor(int defcol, ItemArmor.ArmorMaterial par2ArmorMaterial, int par3, String armornamePrefix, int type) {
/* 17 */     super(defcol, par3, armornamePrefix, type);
/* 18 */     this.rl = par2ArmorMaterial;
/* 19 */     func_77637_a(mod_JRMCore.JRMCore);
/* 20 */     this.modid = JRMCoreH.tjjrmc;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\items\VanityColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */