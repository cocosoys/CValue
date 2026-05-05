/*    */ package net.minecraft.command;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public interface IEntitySelector {
/*  8 */   public static final IEntitySelector field_94557_a = new IEntitySelector() { private static final String __OBFID = "CL_00001541";
/*    */       
/*    */       public boolean func_82704_a(Entity p_82704_1_) {
/* 11 */         return p_82704_1_.func_70089_S();
/*    */       } }
/*    */   ;
/* 14 */   public static final IEntitySelector field_152785_b = new IEntitySelector() { private static final String __OBFID = "CL_00001542";
/*    */       
/*    */       public boolean func_82704_a(Entity p_82704_1_) {
/* 17 */         return (p_82704_1_.func_70089_S() && p_82704_1_.field_70153_n == null && p_82704_1_.field_70154_o == null);
/*    */       } }
/*    */   ;
/* 20 */   public static final IEntitySelector field_96566_b = new IEntitySelector() { private static final String __OBFID = "CL_00001867";
/*    */       
/*    */       public boolean func_82704_a(Entity p_82704_1_) {
/* 23 */         return (p_82704_1_ instanceof net.minecraft.inventory.IInventory && p_82704_1_.func_70089_S());
/*    */       } }
/*    */   ;
/*    */   boolean func_82704_a(Entity paramEntity);
/*    */   
/*    */   public static class ArmoredMob implements IEntitySelector { private final ItemStack field_96567_c;
/*    */     
/*    */     public ArmoredMob(ItemStack p_i1584_1_) {
/* 31 */       this.field_96567_c = p_i1584_1_;
/*    */     }
/*    */     private static final String __OBFID = "CL_00001543";
/*    */     
/*    */     public boolean func_82704_a(Entity p_82704_1_) {
/* 36 */       if (!p_82704_1_.func_70089_S()) return false; 
/* 37 */       if (!(p_82704_1_ instanceof EntityLivingBase)) return false; 
/* 38 */       EntityLivingBase entityLivingBase = (EntityLivingBase)p_82704_1_;
/* 39 */       if (entityLivingBase.func_71124_b(EntityLiving.func_82159_b(this.field_96567_c)) != null) return false;
/*    */       
/* 41 */       if (entityLivingBase instanceof EntityLiving)
/* 42 */         return ((EntityLiving)entityLivingBase).func_98052_bS(); 
/* 43 */       if (entityLivingBase instanceof net.minecraft.entity.player.EntityPlayer) {
/* 44 */         return true;
/*    */       }
/*    */       
/* 47 */       return false;
/*    */     } }
/*    */ 
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\IEntitySelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */