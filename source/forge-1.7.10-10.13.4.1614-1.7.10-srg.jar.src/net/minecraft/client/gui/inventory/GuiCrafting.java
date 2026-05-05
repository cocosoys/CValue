/*    */ package net.minecraft.client.gui.inventory;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.inventory.ContainerWorkbench;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiCrafting extends GuiContainer {
/* 12 */   private static final ResourceLocation field_147019_u = new ResourceLocation("textures/gui/container/crafting_table.png"); private static final String __OBFID = "CL_00000750";
/*    */   
/*    */   public GuiCrafting(InventoryPlayer p_i1084_1_, World p_i1084_2_, int p_i1084_3_, int p_i1084_4_, int p_i1084_5_) {
/* 15 */     super((Container)new ContainerWorkbench(p_i1084_1_, p_i1084_2_, p_i1084_3_, p_i1084_4_, p_i1084_5_));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
/* 20 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("container.crafting", new Object[0]), 28, 6, 4210752);
/* 21 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("container.inventory", new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
/* 26 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 27 */     this.field_146297_k.func_110434_K().func_110577_a(field_147019_u);
/* 28 */     int i = (this.field_146294_l - this.field_146999_f) / 2;
/* 29 */     int j = (this.field_146295_m - this.field_147000_g) / 2;
/* 30 */     func_73729_b(i, j, 0, 0, this.field_146999_f, this.field_147000_g);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\inventory\GuiCrafting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */