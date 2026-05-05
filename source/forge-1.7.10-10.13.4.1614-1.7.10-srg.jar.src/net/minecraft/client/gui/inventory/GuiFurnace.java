/*    */ package net.minecraft.client.gui.inventory;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.tileentity.TileEntityFurnace;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiFurnace extends GuiContainer {
/* 12 */   private static final ResourceLocation field_147087_u = new ResourceLocation("textures/gui/container/furnace.png"); private TileEntityFurnace field_147086_v;
/*    */   private static final String __OBFID = "CL_00000758";
/*    */   
/*    */   public GuiFurnace(InventoryPlayer p_i1091_1_, TileEntityFurnace p_i1091_2_) {
/* 16 */     super((Container)new ContainerFurnace(p_i1091_1_, p_i1091_2_));
/* 17 */     this.field_147086_v = p_i1091_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
/* 22 */     String str = this.field_147086_v.func_145818_k_() ? this.field_147086_v.func_145825_b() : I18n.func_135052_a(this.field_147086_v.func_145825_b(), new Object[0]);
/* 23 */     this.field_146289_q.func_78276_b(str, this.field_146999_f / 2 - this.field_146289_q.func_78256_a(str) / 2, 6, 4210752);
/*    */     
/* 25 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("container.inventory", new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
/* 30 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 31 */     this.field_146297_k.func_110434_K().func_110577_a(field_147087_u);
/* 32 */     int i = (this.field_146294_l - this.field_146999_f) / 2;
/* 33 */     int j = (this.field_146295_m - this.field_147000_g) / 2;
/* 34 */     func_73729_b(i, j, 0, 0, this.field_146999_f, this.field_147000_g);
/* 35 */     if (this.field_147086_v.func_145950_i()) {
/* 36 */       int k = this.field_147086_v.func_145955_e(13);
/* 37 */       func_73729_b(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
/* 38 */       k = this.field_147086_v.func_145953_d(24);
/* 39 */       func_73729_b(i + 79, j + 34, 176, 14, k + 1, 16);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\inventory\GuiFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */