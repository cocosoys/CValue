/*    */ package net.minecraft.item;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.EntityHanging;
/*    */ import net.minecraft.entity.item.EntityItemFrame;
/*    */ import net.minecraft.entity.item.EntityPainting;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemHangingEntity extends Item {
/*    */   private final Class field_82811_a;
/*    */   
/*    */   public ItemHangingEntity(Class p_i45342_1_) {
/* 13 */     this.field_82811_a = p_i45342_1_;
/* 14 */     func_77637_a(CreativeTabs.field_78031_c);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000038";
/*    */   
/*    */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/* 19 */     if (p_77648_7_ == 0) return false; 
/* 20 */     if (p_77648_7_ == 1) return false;
/*    */     
/* 22 */     int i = Direction.field_71579_d[p_77648_7_];
/*    */     
/* 24 */     EntityHanging entityHanging = func_82810_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, i);
/*    */     
/* 26 */     if (!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) return false; 
/* 27 */     if (entityHanging != null && entityHanging.func_70518_d()) {
/* 28 */       if (!p_77648_3_.field_72995_K) {
/* 29 */         p_77648_3_.func_72838_d((Entity)entityHanging);
/*    */       }
/* 31 */       p_77648_1_.field_77994_a--;
/*    */     } 
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   private EntityHanging func_82810_a(World p_82810_1_, int p_82810_2_, int p_82810_3_, int p_82810_4_, int p_82810_5_) {
/* 37 */     if (this.field_82811_a == EntityPainting.class)
/* 38 */       return (EntityHanging)new EntityPainting(p_82810_1_, p_82810_2_, p_82810_3_, p_82810_4_, p_82810_5_); 
/* 39 */     if (this.field_82811_a == EntityItemFrame.class) {
/* 40 */       return (EntityHanging)new EntityItemFrame(p_82810_1_, p_82810_2_, p_82810_3_, p_82810_4_, p_82810_5_);
/*    */     }
/* 42 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemHangingEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */