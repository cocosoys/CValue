/*    */ package net.minecraft.client.gui.inventory;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.entity.passive.EntityHorse;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiScreenHorseInventory extends GuiContainer {
/* 12 */   private static final ResourceLocation field_147031_u = new ResourceLocation("textures/gui/container/horse.png"); private IInventory field_147030_v; private IInventory field_147029_w;
/*    */   private EntityHorse field_147034_x;
/*    */   private float field_147033_y;
/*    */   private float field_147032_z;
/*    */   private static final String __OBFID = "CL_00000760";
/*    */   
/*    */   public GuiScreenHorseInventory(IInventory p_i1093_1_, IInventory p_i1093_2_, EntityHorse p_i1093_3_) {
/* 19 */     super((Container)new ContainerHorseInventory(p_i1093_1_, p_i1093_2_, p_i1093_3_));
/* 20 */     this.field_147030_v = p_i1093_1_;
/* 21 */     this.field_147029_w = p_i1093_2_;
/* 22 */     this.field_147034_x = p_i1093_3_;
/* 23 */     this.field_146291_p = false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
/* 28 */     this.field_146289_q.func_78276_b(this.field_147029_w.func_145818_k_() ? this.field_147029_w.func_145825_b() : I18n.func_135052_a(this.field_147029_w.func_145825_b(), new Object[0]), 8, 6, 4210752);
/* 29 */     this.field_146289_q.func_78276_b(this.field_147030_v.func_145818_k_() ? this.field_147030_v.func_145825_b() : I18n.func_135052_a(this.field_147030_v.func_145825_b(), new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
/* 34 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 35 */     this.field_146297_k.func_110434_K().func_110577_a(field_147031_u);
/* 36 */     int i = (this.field_146294_l - this.field_146999_f) / 2;
/* 37 */     int j = (this.field_146295_m - this.field_147000_g) / 2;
/* 38 */     func_73729_b(i, j, 0, 0, this.field_146999_f, this.field_147000_g);
/*    */     
/* 40 */     if (this.field_147034_x.func_110261_ca()) {
/* 41 */       func_73729_b(i + 79, j + 17, 0, this.field_147000_g, 90, 54);
/*    */     }
/* 43 */     if (this.field_147034_x.func_110259_cr()) {
/* 44 */       func_73729_b(i + 7, j + 35, 0, this.field_147000_g + 54, 18, 18);
/*    */     }
/*    */     
/* 47 */     GuiInventory.func_147046_a(i + 51, j + 60, 17, (i + 51) - this.field_147033_y, (j + 75 - 50) - this.field_147032_z, (EntityLivingBase)this.field_147034_x);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 52 */     this.field_147033_y = p_73863_1_;
/* 53 */     this.field_147032_z = p_73863_2_;
/*    */     
/* 55 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\inventory\GuiScreenHorseInventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */