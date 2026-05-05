/*    */ package net.minecraft.inventory;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.passive.EntityHorse;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ContainerHorseInventory extends Container {
/*    */   public ContainerHorseInventory(IInventory p_i1817_1_, IInventory p_i1817_2_, EntityHorse p_i1817_3_) {
/* 13 */     this.field_111243_a = p_i1817_2_;
/* 14 */     this.field_111242_f = p_i1817_3_;
/* 15 */     byte b1 = 3;
/* 16 */     p_i1817_2_.func_70295_k_();
/*    */     
/* 18 */     int i = (b1 - 4) * 18;
/*    */ 
/*    */     
/* 21 */     func_75146_a(new Slot(this, p_i1817_2_, 0, 8, 18)
/*    */         {
/*    */           public boolean func_75214_a(ItemStack p_75214_1_) {
/* 24 */             return (super.func_75214_a(p_75214_1_) && p_75214_1_.func_77973_b() == Items.field_151141_av && !func_75216_d());
/*    */           } private static final String __OBFID = "CL_00001752";
/*    */         });
/* 27 */     func_75146_a(new Slot(this, p_i1817_2_, 1, 8, 36, p_i1817_3_) { private static final String __OBFID = "CL_00001753";
/*    */           
/*    */           public boolean func_75214_a(ItemStack p_75214_1_) {
/* 30 */             return (super.func_75214_a(p_75214_1_) && this.field_111241_a.func_110259_cr() && EntityHorse.func_146085_a(p_75214_1_.func_77973_b()));
/*    */           }
/*    */           
/*    */           @SideOnly(Side.CLIENT)
/*    */           public boolean func_111238_b() {
/* 35 */             return this.field_111241_a.func_110259_cr();
/*    */           } }
/*    */       );
/*    */     
/* 39 */     if (p_i1817_3_.func_110261_ca()) {
/* 40 */       for (byte b = 0; b < b1; b++) {
/* 41 */         for (byte b3 = 0; b3 < 5; b3++) {
/* 42 */           func_75146_a(new Slot(p_i1817_2_, 2 + b3 + b * 5, 80 + b3 * 18, 18 + b * 18));
/*    */         }
/*    */       } 
/*    */     }
/*    */     byte b2;
/* 47 */     for (b2 = 0; b2 < 3; b2++) {
/* 48 */       for (byte b = 0; b < 9; b++) {
/* 49 */         func_75146_a(new Slot(p_i1817_1_, b + b2 * 9 + 9, 8 + b * 18, 102 + b2 * 18 + i));
/*    */       }
/*    */     } 
/* 52 */     for (b2 = 0; b2 < 9; b2++)
/* 53 */       func_75146_a(new Slot(p_i1817_1_, b2, 8 + b2 * 18, 160 + i)); 
/*    */   }
/*    */   private IInventory field_111243_a; private EntityHorse field_111242_f;
/*    */   private static final String __OBFID = "CL_00001751";
/*    */   
/*    */   public boolean func_75145_c(EntityPlayer p_75145_1_) {
/* 59 */     return (this.field_111243_a.func_70300_a(p_75145_1_) && this.field_111242_f.func_70089_S() && this.field_111242_f.func_70032_d((Entity)p_75145_1_) < 8.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
/* 64 */     ItemStack itemStack = null;
/* 65 */     Slot slot = this.field_75151_b.get(p_82846_2_);
/* 66 */     if (slot != null && slot.func_75216_d()) {
/* 67 */       ItemStack itemStack1 = slot.func_75211_c();
/* 68 */       itemStack = itemStack1.func_77946_l();
/*    */       
/* 70 */       if (p_82846_2_ < this.field_111243_a.func_70302_i_()) {
/* 71 */         if (!func_75135_a(itemStack1, this.field_111243_a.func_70302_i_(), this.field_75151_b.size(), true)) {
/* 72 */           return null;
/*    */         }
/*    */       }
/* 75 */       else if (func_75139_a(1).func_75214_a(itemStack1) && !func_75139_a(1).func_75216_d()) {
/* 76 */         if (!func_75135_a(itemStack1, 1, 2, false)) {
/* 77 */           return null;
/*    */         }
/* 79 */       } else if (func_75139_a(0).func_75214_a(itemStack1)) {
/* 80 */         if (!func_75135_a(itemStack1, 0, 1, false)) {
/* 81 */           return null;
/*    */         }
/* 83 */       } else if (this.field_111243_a.func_70302_i_() <= 2 || !func_75135_a(itemStack1, 2, this.field_111243_a.func_70302_i_(), false)) {
/* 84 */         return null;
/*    */       } 
/*    */       
/* 87 */       if (itemStack1.field_77994_a == 0) {
/* 88 */         slot.func_75215_d(null);
/*    */       } else {
/* 90 */         slot.func_75218_e();
/*    */       } 
/*    */     } 
/* 93 */     return itemStack;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75134_a(EntityPlayer p_75134_1_) {
/* 98 */     super.func_75134_a(p_75134_1_);
/* 99 */     this.field_111243_a.func_70305_f();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\ContainerHorseInventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */