/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.item.EnumRarity;
/*    */ import net.minecraft.item.ItemRecord;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemRec
/*    */   extends ItemRecord
/*    */ {
/*    */   public ItemRec(String recordName) {
/* 21 */     super(recordName);
/*    */ 
/*    */     
/* 24 */     this.field_77777_bU = 1;
/* 25 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister iconRegister) {
/* 33 */     this.field_77791_bV = iconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":" + func_77658_a());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public EnumRarity func_77613_e(ItemStack itemStack) {
/* 40 */     return EnumRarity.rare;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ResourceLocation getRecordResource(String name) {
/* 46 */     return new ResourceLocation(JRMCoreH.tjdbcAssts + ":" + name);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemRec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */