/*    */ package net.minecraft.item;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLeashKnot;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemLead extends Item {
/*    */   public ItemLead() {
/* 14 */     func_77637_a(CreativeTabs.field_78040_i);
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000045";
/*    */   
/*    */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/* 20 */     Block block = p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
/* 21 */     if (block.func_149645_b() == 11) {
/* 22 */       if (p_77648_3_.field_72995_K) {
/* 23 */         return true;
/*    */       }
/*    */       
/* 26 */       func_150909_a(p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_);
/* 27 */       return true;
/*    */     } 
/* 29 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean func_150909_a(EntityPlayer p_150909_0_, World p_150909_1_, int p_150909_2_, int p_150909_3_, int p_150909_4_) {
/* 35 */     EntityLeashKnot entityLeashKnot = EntityLeashKnot.func_110130_b(p_150909_1_, p_150909_2_, p_150909_3_, p_150909_4_);
/*    */ 
/*    */     
/* 38 */     boolean bool = false;
/* 39 */     double d = 7.0D;
/* 40 */     List list = p_150909_1_.func_72872_a(EntityLiving.class, AxisAlignedBB.func_72330_a(p_150909_2_ - d, p_150909_3_ - d, p_150909_4_ - d, p_150909_2_ + d, p_150909_3_ + d, p_150909_4_ + d));
/* 41 */     if (list != null) {
/* 42 */       for (EntityLiving entityLiving : list) {
/* 43 */         if (entityLiving.func_110167_bD() && entityLiving.func_110166_bE() == p_150909_0_) {
/* 44 */           if (entityLeashKnot == null) {
/* 45 */             entityLeashKnot = EntityLeashKnot.func_110129_a(p_150909_1_, p_150909_2_, p_150909_3_, p_150909_4_);
/*    */           }
/* 47 */           entityLiving.func_110162_b((Entity)entityLeashKnot, true);
/* 48 */           bool = true;
/*    */         } 
/*    */       } 
/*    */     }
/* 52 */     return bool;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemLead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */