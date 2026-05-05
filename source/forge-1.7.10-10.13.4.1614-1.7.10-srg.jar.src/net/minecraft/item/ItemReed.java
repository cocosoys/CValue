/*    */ package net.minecraft.item;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemReed extends Item {
/*    */   private Block field_150935_a;
/*    */   private static final String __OBFID = "CL_00001773";
/*    */   
/*    */   public ItemReed(Block p_i45329_1_) {
/* 14 */     this.field_150935_a = p_i45329_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/* 19 */     Block block = p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
/* 20 */     if (block == Blocks.field_150431_aC && (p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_) & 0x7) < 1) {
/* 21 */       p_77648_7_ = 1;
/* 22 */     } else if (block != Blocks.field_150395_bd && block != Blocks.field_150329_H && block != Blocks.field_150330_I) {
/*    */       
/* 24 */       if (p_77648_7_ == 0) p_77648_5_--; 
/* 25 */       if (p_77648_7_ == 1) p_77648_5_++; 
/* 26 */       if (p_77648_7_ == 2) p_77648_6_--; 
/* 27 */       if (p_77648_7_ == 3) p_77648_6_++; 
/* 28 */       if (p_77648_7_ == 4) p_77648_4_--; 
/* 29 */       if (p_77648_7_ == 5) p_77648_4_++;
/*    */     
/*    */     } 
/* 32 */     if (!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) return false; 
/* 33 */     if (p_77648_1_.field_77994_a == 0) return false;
/*    */     
/* 35 */     if (p_77648_3_.func_147472_a(this.field_150935_a, p_77648_4_, p_77648_5_, p_77648_6_, false, p_77648_7_, null, p_77648_1_)) {
/* 36 */       int i = this.field_150935_a.func_149660_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_, 0);
/* 37 */       if (p_77648_3_.func_147465_d(p_77648_4_, p_77648_5_, p_77648_6_, this.field_150935_a, i, 3)) {
/*    */ 
/*    */ 
/*    */         
/* 41 */         if (p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_) == this.field_150935_a) {
/* 42 */           this.field_150935_a.func_149689_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, (EntityLivingBase)p_77648_2_, p_77648_1_);
/* 43 */           this.field_150935_a.func_149714_e(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, i);
/*    */         } 
/* 45 */         p_77648_3_.func_72908_a((p_77648_4_ + 0.5F), (p_77648_5_ + 0.5F), (p_77648_6_ + 0.5F), this.field_150935_a.field_149762_H.func_150496_b(), (this.field_150935_a.field_149762_H.func_150497_c() + 1.0F) / 2.0F, this.field_150935_a.field_149762_H.func_150494_d() * 0.8F);
/* 46 */         p_77648_1_.field_77994_a--;
/*    */       } 
/*    */     } 
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemReed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */