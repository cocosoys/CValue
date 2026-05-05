/*    */ package net.minecraft.inventory;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.stats.AchievementList;
/*    */ import net.minecraft.stats.StatBase;
/*    */ 
/*    */ public class SlotCrafting extends Slot {
/*    */   private final IInventory field_75239_a;
/*    */   private EntityPlayer field_75238_b;
/*    */   
/*    */   public SlotCrafting(EntityPlayer p_i1823_1_, IInventory p_i1823_2_, IInventory p_i1823_3_, int p_i1823_4_, int p_i1823_5_, int p_i1823_6_) {
/* 15 */     super(p_i1823_3_, p_i1823_4_, p_i1823_5_, p_i1823_6_);
/* 16 */     this.field_75238_b = p_i1823_1_;
/* 17 */     this.field_75239_a = p_i1823_2_;
/*    */   }
/*    */   private int field_75237_g; private static final String __OBFID = "CL_00001761";
/*    */   
/*    */   public boolean func_75214_a(ItemStack p_75214_1_) {
/* 22 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_75209_a(int p_75209_1_) {
/* 27 */     if (func_75216_d()) {
/* 28 */       this.field_75237_g += Math.min(p_75209_1_, (func_75211_c()).field_77994_a);
/*    */     }
/* 30 */     return super.func_75209_a(p_75209_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_75210_a(ItemStack p_75210_1_, int p_75210_2_) {
/* 35 */     this.field_75237_g += p_75210_2_;
/* 36 */     func_75208_c(p_75210_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_75208_c(ItemStack p_75208_1_) {
/* 41 */     p_75208_1_.func_77980_a(this.field_75238_b.field_70170_p, this.field_75238_b, this.field_75237_g);
/* 42 */     this.field_75237_g = 0;
/*    */     
/* 44 */     if (p_75208_1_.func_77973_b() == Item.func_150898_a(Blocks.field_150462_ai)) this.field_75238_b.func_71064_a((StatBase)AchievementList.field_76017_h, 1); 
/* 45 */     if (p_75208_1_.func_77973_b() instanceof ItemPickaxe) this.field_75238_b.func_71064_a((StatBase)AchievementList.field_76018_i, 1); 
/* 46 */     if (p_75208_1_.func_77973_b() == Item.func_150898_a(Blocks.field_150460_al)) this.field_75238_b.func_71064_a((StatBase)AchievementList.field_76015_j, 1); 
/* 47 */     if (p_75208_1_.func_77973_b() instanceof net.minecraft.item.ItemHoe) this.field_75238_b.func_71064_a((StatBase)AchievementList.field_76013_l, 1); 
/* 48 */     if (p_75208_1_.func_77973_b() == Items.field_151025_P) this.field_75238_b.func_71064_a((StatBase)AchievementList.field_76014_m, 1); 
/* 49 */     if (p_75208_1_.func_77973_b() == Items.field_151105_aU) this.field_75238_b.func_71064_a((StatBase)AchievementList.field_76011_n, 1); 
/* 50 */     if (p_75208_1_.func_77973_b() instanceof ItemPickaxe && ((ItemPickaxe)p_75208_1_.func_77973_b()).func_150913_i() != Item.ToolMaterial.WOOD) this.field_75238_b.func_71064_a((StatBase)AchievementList.field_76012_o, 1); 
/* 51 */     if (p_75208_1_.func_77973_b() instanceof net.minecraft.item.ItemSword) this.field_75238_b.func_71064_a((StatBase)AchievementList.field_76024_r, 1); 
/* 52 */     if (p_75208_1_.func_77973_b() == Item.func_150898_a(Blocks.field_150381_bn)) this.field_75238_b.func_71064_a((StatBase)AchievementList.field_75998_D, 1); 
/* 53 */     if (p_75208_1_.func_77973_b() == Item.func_150898_a(Blocks.field_150342_X)) this.field_75238_b.func_71064_a((StatBase)AchievementList.field_76000_F, 1);
/*    */   
/*    */   }
/*    */   
/*    */   public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
/* 58 */     func_75208_c(p_82870_2_);
/*    */     
/* 60 */     for (byte b = 0; b < this.field_75239_a.func_70302_i_(); b++) {
/* 61 */       ItemStack itemStack = this.field_75239_a.func_70301_a(b);
/* 62 */       if (itemStack != null) {
/* 63 */         this.field_75239_a.func_70298_a(b, 1);
/*    */         
/* 65 */         if (itemStack.func_77973_b().func_77634_r()) {
/* 66 */           ItemStack itemStack1 = new ItemStack(itemStack.func_77973_b().func_77668_q());
/*    */ 
/*    */           
/* 69 */           if (!itemStack.func_77973_b().func_77630_h(itemStack) || !this.field_75238_b.field_71071_by.func_70441_a(itemStack1))
/*    */           {
/*    */ 
/*    */ 
/*    */             
/* 74 */             if (this.field_75239_a.func_70301_a(b) == null) {
/* 75 */               this.field_75239_a.func_70299_a(b, itemStack1);
/*    */             } else {
/*    */               
/* 78 */               this.field_75238_b.func_71019_a(itemStack1, false);
/*    */             } 
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\SlotCrafting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */