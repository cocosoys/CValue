/*    */ package JinRyuu.DragonBC.common;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.event.entity.player.FillBucketEvent;
/*    */ 
/*    */ 
/*    */ public class DBCHandlerBucket
/*    */ {
/* 17 */   public static DBCHandlerBucket INSTANCE = new DBCHandlerBucket();
/* 18 */   public Map<Block, Item> buckets = new HashMap<Block, Item>();
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onBucketFill(FillBucketEvent event) {
/* 22 */     ItemStack result = fillBucket(event.world, event.target);
/* 23 */     if (result == null) {
/*    */       return;
/*    */     }
/* 26 */     event.result = result;
/* 27 */     event.setResult(Event.Result.ALLOW);
/*    */   }
/*    */ 
/*    */   
/*    */   private ItemStack fillBucket(World world, MovingObjectPosition pos) {
/* 32 */     Block block = world.func_147439_a(pos.field_72311_b, pos.field_72312_c, pos.field_72309_d);
/*    */     
/* 34 */     Item bucket = this.buckets.get(block);
/* 35 */     if (bucket != null && world.func_72805_g(pos.field_72311_b, pos.field_72312_c, pos.field_72309_d) == 0) {
/* 36 */       world.func_147468_f(pos.field_72311_b, pos.field_72312_c, pos.field_72309_d);
/* 37 */       return new ItemStack(bucket);
/*    */     } 
/*    */     
/* 40 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\DBCHandlerBucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */