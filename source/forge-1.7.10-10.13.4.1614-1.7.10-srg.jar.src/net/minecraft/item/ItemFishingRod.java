/*    */ package net.minecraft.item;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemFishingRod extends Item {
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon field_94598_a;
/*    */   
/*    */   public ItemFishingRod() {
/* 13 */     func_77656_e(64);
/* 14 */     func_77625_d(1);
/* 15 */     func_77637_a(CreativeTabs.field_78040_i);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000034";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_77662_d() {
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_77629_n_() {
/* 25 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 30 */     if (p_77659_3_.field_71104_cf != null) {
/* 31 */       int i = p_77659_3_.field_71104_cf.func_146034_e();
/* 32 */       p_77659_1_.func_77972_a(i, (EntityLivingBase)p_77659_3_);
/* 33 */       p_77659_3_.func_71038_i();
/*    */     } else {
/* 35 */       p_77659_2_.func_72956_a((Entity)p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
/* 36 */       if (!p_77659_2_.field_72995_K) {
/* 37 */         p_77659_2_.func_72838_d((Entity)new EntityFishHook(p_77659_2_, p_77659_3_));
/*    */       }
/* 39 */       p_77659_3_.func_71038_i();
/*    */     } 
/* 41 */     return p_77659_1_;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_94581_a(IIconRegister p_94581_1_) {
/* 46 */     this.field_77791_bV = p_94581_1_.func_94245_a(func_111208_A() + "_uncast");
/* 47 */     this.field_94598_a = p_94581_1_.func_94245_a(func_111208_A() + "_cast");
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_94597_g() {
/* 51 */     return this.field_94598_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_77616_k(ItemStack p_77616_1_) {
/* 56 */     return super.func_77616_k(p_77616_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77619_b() {
/* 61 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemFishingRod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */