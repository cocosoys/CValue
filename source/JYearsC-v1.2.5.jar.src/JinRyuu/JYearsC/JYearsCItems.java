/*    */ package JinRyuu.JYearsC;
/*    */ 
/*    */ import cpw.mods.fml.common.registry.GameRegistry;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ 
/*    */ public class JYearsCItems
/*    */ {
/*    */   public static Item ItemWatch;
/*    */   
/*    */   public static void init() {
/* 12 */     ItemWatch = GameRegistry.registerItem((new ItemWatch()).func_77655_b("ItemWatch"), "ItemWatch", null);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JYearsC-v1.2.5.jar!\JinRyuu\JYearsC\JYearsCItems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */