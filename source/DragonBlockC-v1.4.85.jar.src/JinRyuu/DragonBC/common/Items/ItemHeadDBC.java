/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import JinRyuu.JRMCore.items.ItemHeadwear;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class ItemHeadDBC
/*    */   extends ItemHeadwear
/*    */ {
/*    */   private String armorNamePrefix;
/*    */   private String tier;
/*    */   
/*    */   public ItemHeadDBC(String armornamePrefix, String tier) {
/* 17 */     super(armornamePrefix, tier, Integer.parseInt(tier) * 50 + 200);
/* 18 */     this.armorNamePrefix = armornamePrefix;
/* 19 */     this.tier = tier;
/* 20 */     this.modid = JRMCoreH.tjdbcAssts;
/*    */     
/* 22 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
/* 27 */     String armor = "";
/* 28 */     String s = "";
/* 29 */     String j = "";
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 34 */     j = "jbra";
/*    */     
/* 36 */     if (stack.toString().contains("leg") || stack.toString().contains("Leg"))
/* 37 */     { armor = this.modid + ":armor/" + this.armorNamePrefix + "_2" + j + s + ".png"; }
/* 38 */     else { armor = this.modid + ":armor/" + this.armorNamePrefix + "_1" + j + s + ".png"; }
/*    */     
/* 40 */     return armor;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemHeadDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */