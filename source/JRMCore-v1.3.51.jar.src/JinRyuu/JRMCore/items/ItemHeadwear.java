/*    */ package JinRyuu.JRMCore.items;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public class ItemHeadwear
/*    */   extends Item
/*    */ {
/*    */   public String modid;
/*    */   private String armorNamePrefix;
/*    */   private String tier;
/*    */   
/*    */   public String getTier() {
/* 15 */     return this.tier;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemHeadwear(String armornamePrefix, String tier, int maxDam) {
/* 21 */     this.armorNamePrefix = armornamePrefix;
/* 22 */     this.tier = tier;
/* 23 */     func_77656_e(maxDam);
/* 24 */     func_77625_d(1);
/* 25 */     this.modid = JRMCoreH.tjjrmc;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTextureFile() {
/* 31 */     return this.modid + ":";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister iconRegister) {
/* 36 */     this.field_77791_bV = iconRegister.func_94245_a(this.modid + ":" + func_77658_a().replaceAll("item.", "").replaceAll("Scoutera", "Scouter").replaceAll("Scouterb", "Scouter"));
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\items\ItemHeadwear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */