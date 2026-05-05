/*    */ package net.minecraft.client.gui;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.inventory.ContainerHopper;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiHopper extends GuiContainer {
/* 12 */   private static final ResourceLocation field_147085_u = new ResourceLocation("textures/gui/container/hopper.png"); private IInventory field_147084_v;
/*    */   private IInventory field_147083_w;
/*    */   private static final String __OBFID = "CL_00000759";
/*    */   
/*    */   public GuiHopper(InventoryPlayer p_i1092_1_, IInventory p_i1092_2_) {
/* 17 */     super((Container)new ContainerHopper(p_i1092_1_, p_i1092_2_));
/* 18 */     this.field_147084_v = (IInventory)p_i1092_1_;
/* 19 */     this.field_147083_w = p_i1092_2_;
/* 20 */     this.field_146291_p = false;
/*    */     
/* 22 */     this.field_147000_g = 133;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
/* 27 */     this.field_146289_q.func_78276_b(this.field_147083_w.func_145818_k_() ? this.field_147083_w.func_145825_b() : I18n.func_135052_a(this.field_147083_w.func_145825_b(), new Object[0]), 8, 6, 4210752);
/* 28 */     this.field_146289_q.func_78276_b(this.field_147084_v.func_145818_k_() ? this.field_147084_v.func_145825_b() : I18n.func_135052_a(this.field_147084_v.func_145825_b(), new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
/* 33 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 34 */     this.field_146297_k.func_110434_K().func_110577_a(field_147085_u);
/* 35 */     int i = (this.field_146294_l - this.field_146999_f) / 2;
/* 36 */     int j = (this.field_146295_m - this.field_147000_g) / 2;
/* 37 */     func_73729_b(i, j, 0, 0, this.field_146999_f, this.field_147000_g);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiHopper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */