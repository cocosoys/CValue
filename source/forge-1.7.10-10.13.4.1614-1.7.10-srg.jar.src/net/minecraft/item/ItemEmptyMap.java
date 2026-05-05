/*    */ package net.minecraft.item;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.storage.MapData;
/*    */ 
/*    */ public class ItemEmptyMap extends ItemMapBase {
/*    */   protected ItemEmptyMap() {
/*  9 */     func_77637_a(CreativeTabs.field_78026_f);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000024";
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 14 */     ItemStack itemStack = new ItemStack(Items.field_151098_aY, 1, p_77659_2_.func_72841_b("map"));
/*    */     
/* 16 */     String str = "map_" + itemStack.func_77960_j();
/* 17 */     MapData mapData = new MapData(str);
/* 18 */     p_77659_2_.func_72823_a(str, (WorldSavedData)mapData);
/*    */     
/* 20 */     mapData.field_76197_d = 0;
/* 21 */     int i = 128 * (1 << mapData.field_76197_d);
/* 22 */     mapData.field_76201_a = (int)(Math.round(p_77659_3_.field_70165_t / i) * i);
/* 23 */     mapData.field_76199_b = (int)(Math.round(p_77659_3_.field_70161_v / i) * i);
/* 24 */     mapData.field_76200_c = (byte)p_77659_2_.field_73011_w.field_76574_g;
/*    */     
/* 26 */     mapData.func_76185_a();
/*    */     
/* 28 */     p_77659_1_.field_77994_a--;
/* 29 */     if (p_77659_1_.field_77994_a <= 0) {
/* 30 */       return itemStack;
/*    */     }
/* 32 */     if (!p_77659_3_.field_71071_by.func_70441_a(itemStack.func_77946_l())) {
/* 33 */       p_77659_3_.func_71019_a(itemStack, false);
/*    */     }
/*    */ 
/*    */     
/* 37 */     return p_77659_1_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemEmptyMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */