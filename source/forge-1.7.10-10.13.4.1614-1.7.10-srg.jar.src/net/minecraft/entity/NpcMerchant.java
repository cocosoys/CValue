/*    */ package net.minecraft.entity;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.InventoryMerchant;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.village.MerchantRecipe;
/*    */ import net.minecraft.village.MerchantRecipeList;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class NpcMerchant implements IMerchant {
/*    */   private InventoryMerchant field_70937_a;
/*    */   
/*    */   public NpcMerchant(EntityPlayer p_i1746_1_) {
/* 16 */     this.field_70935_b = p_i1746_1_;
/* 17 */     this.field_70937_a = new InventoryMerchant(p_i1746_1_, this);
/*    */   }
/*    */ 
/*    */   
/*    */   private EntityPlayer field_70935_b;
/*    */   private MerchantRecipeList field_70936_c;
/*    */   private static final String __OBFID = "CL_00001705";
/*    */   
/*    */   public EntityPlayer func_70931_l_() {
/* 26 */     return this.field_70935_b;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_70932_a_(EntityPlayer p_70932_1_) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public MerchantRecipeList func_70934_b(EntityPlayer p_70934_1_) {
/* 36 */     return this.field_70936_c;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70930_a(MerchantRecipeList p_70930_1_) {
/* 41 */     this.field_70936_c = p_70930_1_;
/*    */   }
/*    */   
/*    */   public void func_70933_a(MerchantRecipe p_70933_1_) {}
/*    */   
/*    */   public void func_110297_a_(ItemStack p_110297_1_) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\NpcMerchant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */