/*    */ package net.minecraft.entity.item;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityMinecartChest extends EntityMinecartContainer {
/*    */   public EntityMinecartChest(World p_i1714_1_) {
/* 11 */     super(p_i1714_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001671";
/*    */   public EntityMinecartChest(World p_i1715_1_, double p_i1715_2_, double p_i1715_4_, double p_i1715_6_) {
/* 15 */     super(p_i1715_1_, p_i1715_2_, p_i1715_4_, p_i1715_6_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_94095_a(DamageSource p_94095_1_) {
/* 20 */     super.func_94095_a(p_94095_1_);
/*    */     
/* 22 */     func_145778_a(Item.func_150898_a((Block)Blocks.field_150486_ae), 1, 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_70302_i_() {
/* 27 */     return 27;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_94087_l() {
/* 32 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public Block func_145817_o() {
/* 37 */     return (Block)Blocks.field_150486_ae;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_94085_r() {
/* 42 */     return 8;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityMinecartChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */