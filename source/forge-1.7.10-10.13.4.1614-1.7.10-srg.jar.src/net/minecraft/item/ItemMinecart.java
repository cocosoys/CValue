/*    */ package net.minecraft.item;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockRailBase;
/*    */ import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
/*    */ import net.minecraft.dispenser.IBlockSource;
/*    */ import net.minecraft.entity.item.EntityMinecart;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemMinecart extends Item {
/* 11 */   private static final IBehaviorDispenseItem field_96602_b = (IBehaviorDispenseItem)new BehaviorDefaultDispenseItem() {
/* 12 */       private final BehaviorDefaultDispenseItem field_96465_b = new BehaviorDefaultDispenseItem(); private static final String __OBFID = "CL_00000050";
/*    */       
/*    */       public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
/*    */         double d4;
/* 16 */         EnumFacing enumFacing = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
/* 17 */         World world = p_82487_1_.func_82618_k();
/*    */ 
/*    */ 
/*    */         
/* 21 */         double d1 = p_82487_1_.func_82615_a() + (enumFacing.func_82601_c() * 1.125F);
/* 22 */         double d2 = p_82487_1_.func_82617_b() + (enumFacing.func_96559_d() * 1.125F);
/* 23 */         double d3 = p_82487_1_.func_82616_c() + (enumFacing.func_82599_e() * 1.125F);
/*    */         
/* 25 */         int i = p_82487_1_.func_82623_d() + enumFacing.func_82601_c();
/* 26 */         int j = p_82487_1_.func_82622_e() + enumFacing.func_96559_d();
/* 27 */         int k = p_82487_1_.func_82621_f() + enumFacing.func_82599_e();
/* 28 */         Block block = world.func_147439_a(i, j, k);
/*    */ 
/*    */         
/* 31 */         if (BlockRailBase.func_150051_a(block)) {
/* 32 */           d4 = 0.0D;
/* 33 */         } else if (block.func_149688_o() == Material.field_151579_a && BlockRailBase.func_150051_a(world.func_147439_a(i, j - 1, k))) {
/* 34 */           d4 = -1.0D;
/*    */         } else {
/* 36 */           return this.field_96465_b.func_82482_a(p_82487_1_, p_82487_2_);
/*    */         } 
/*    */         
/* 39 */         EntityMinecart entityMinecart = EntityMinecart.func_94090_a(world, d1, d2 + d4, d3, ((ItemMinecart)p_82487_2_.func_77973_b()).field_77841_a);
/* 40 */         if (p_82487_2_.func_82837_s()) {
/* 41 */           entityMinecart.func_96094_a(p_82487_2_.func_82833_r());
/*    */         }
/* 43 */         world.func_72838_d((Entity)entityMinecart);
/*    */         
/* 45 */         p_82487_2_.func_77979_a(1);
/* 46 */         return p_82487_2_;
/*    */       }
/*    */ 
/*    */       
/*    */       protected void func_82485_a(IBlockSource p_82485_1_) {
/* 51 */         p_82485_1_.func_82618_k().func_72926_e(1000, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
/*    */       }
/*    */     };
/*    */   public int field_77841_a;
/*    */   private static final String __OBFID = "CL_00000049";
/*    */   
/*    */   public ItemMinecart(int p_i45345_1_) {
/* 58 */     this.field_77777_bU = 1;
/* 59 */     this.field_77841_a = p_i45345_1_;
/* 60 */     func_77637_a(CreativeTabs.field_78029_e);
/* 61 */     BlockDispenser.field_149943_a.func_82595_a(this, field_96602_b);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/* 67 */     if (BlockRailBase.func_150051_a(p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_))) {
/* 68 */       if (!p_77648_3_.field_72995_K) {
/* 69 */         EntityMinecart entityMinecart = EntityMinecart.func_94090_a(p_77648_3_, (p_77648_4_ + 0.5F), (p_77648_5_ + 0.5F), (p_77648_6_ + 0.5F), this.field_77841_a);
/* 70 */         if (p_77648_1_.func_82837_s()) {
/* 71 */           entityMinecart.func_96094_a(p_77648_1_.func_82833_r());
/*    */         }
/* 73 */         p_77648_3_.func_72838_d((Entity)entityMinecart);
/*    */       } 
/* 75 */       p_77648_1_.field_77994_a--;
/* 76 */       return true;
/*    */     } 
/* 78 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemMinecart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */