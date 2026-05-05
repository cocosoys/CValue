/*    */ package JinRyuu.DragonBC.common;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*    */ import JinRyuu.DragonBC.common.Blocks.m.ModdedBlocks;
/*    */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*    */ import JinRyuu.DragonBC.common.Items.m.ModdedItems;
/*    */ import cpw.mods.fml.common.IFuelHandler;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DBCHandlerFuel
/*    */   implements IFuelHandler
/*    */ {
/*    */   public int getBurnTime(ItemStack fuel) {
/* 43 */     if (fuel.func_77973_b() == ModdedItems.SakuraStick) return 150; 
/* 44 */     if (fuel.func_77973_b() == ModdedItems.MahagonyStick) return 150; 
/* 45 */     if (fuel.func_77973_b() == ModdedItems.MapleStick) return 150;
/*    */     
/* 47 */     if (fuel.func_77973_b() == ModdedItems.SakuraBranch) return 200; 
/* 48 */     if (fuel.func_77973_b() == ModdedItems.MahagonyBranch) return 200;
/*    */     
/* 50 */     if (fuel.func_77973_b() == ModdedItems.SakuraHammer) return 250; 
/* 51 */     if (fuel.func_77973_b() == ModdedItems.SakuraSword) return 250; 
/* 52 */     if (fuel.func_77973_b() == ModdedItems.SakuraAxe) return 250; 
/* 53 */     if (fuel.func_77973_b() == ModdedItems.SakuraPickaxe) return 250; 
/* 54 */     if (fuel.func_77973_b() == ModdedItems.SakuraHoe) return 250; 
/* 55 */     if (fuel.func_77973_b() == ModdedItems.SakuraShovel) return 250;
/*    */     
/* 57 */     if (fuel.func_77973_b() == ModdedItems.MahagonySword) return 250; 
/* 58 */     if (fuel.func_77973_b() == ModdedItems.MahagonyAxe) return 250; 
/* 59 */     if (fuel.func_77973_b() == ModdedItems.MahagonyPickaxe) return 250; 
/* 60 */     if (fuel.func_77973_b() == ModdedItems.MahagonyHoe) return 250; 
/* 61 */     if (fuel.func_77973_b() == ModdedItems.MahagonyShovel) return 250;
/*    */     
/* 63 */     if (fuel.func_77973_b() == ModdedItems.MapleSword) return 250; 
/* 64 */     if (fuel.func_77973_b() == ModdedItems.MapleAxe) return 250; 
/* 65 */     if (fuel.func_77973_b() == ModdedItems.MaplePickaxe) return 250; 
/* 66 */     if (fuel.func_77973_b() == ModdedItems.MapleHoe) return 250; 
/* 67 */     if (fuel.func_77973_b() == ModdedItems.MapleShovel) return 250;
/*    */     
/* 69 */     if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.PaperWallSakura)) return 150; 
/* 70 */     if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.PaperWallMahagony)) return 150; 
/* 71 */     if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.SakuraLogs)) return 400; 
/* 72 */     if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.SakuraPlank)) return 400; 
/* 73 */     if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.SakuraSaplings)) return 150; 
/* 74 */     if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.SakuraStairs)) return 200; 
/* 75 */     if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.MahagonyStairs)) return 200; 
/* 76 */     if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.MapleStairs)) return 200; 
/* 77 */     if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.SakuraFence)) return 200; 
/* 78 */     if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.MahagonyFence)) return 200; 
/* 79 */     if (fuel.func_77973_b() == Item.func_150898_a(ModdedBlocks.MapleFence)) return 200; 
/* 80 */     if (fuel.func_77973_b() == Item.func_150898_a((Block)ModdedBlocks.SakuraSlabsSingle)) return 200;
/*    */ 
/*    */     
/* 83 */     Item item = fuel.func_77973_b();
/* 84 */     if (item == ItemsDBC.ItemsOW[3]) {
/* 85 */       return 1500;
/*    */     }
/* 87 */     if (item == Item.func_150898_a(BlocksDBC.BlockOW[0])) {
/* 88 */       return 15000;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 93 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\DBCHandlerFuel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */