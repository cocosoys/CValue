/*    */ package net.minecraft.client.gui.inventory;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.inventory.ContainerBrewingStand;
/*    */ import net.minecraft.tileentity.TileEntityBrewingStand;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiBrewingStand extends GuiContainer {
/* 14 */   private static final ResourceLocation field_147014_u = new ResourceLocation("textures/gui/container/brewing_stand.png"); private TileEntityBrewingStand field_147013_v;
/*    */   private static final String __OBFID = "CL_00000746";
/*    */   
/*    */   public GuiBrewingStand(InventoryPlayer p_i1081_1_, TileEntityBrewingStand p_i1081_2_) {
/* 18 */     super((Container)new ContainerBrewingStand(p_i1081_1_, p_i1081_2_));
/* 19 */     this.field_147013_v = p_i1081_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
/* 24 */     String str = this.field_147013_v.func_145818_k_() ? this.field_147013_v.func_145825_b() : I18n.func_135052_a(this.field_147013_v.func_145825_b(), new Object[0]);
/* 25 */     this.field_146289_q.func_78276_b(str, this.field_146999_f / 2 - this.field_146289_q.func_78256_a(str) / 2, 6, 4210752);
/* 26 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("container.inventory", new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
/* 31 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 32 */     this.field_146297_k.func_110434_K().func_110577_a(field_147014_u);
/* 33 */     int i = (this.field_146294_l - this.field_146999_f) / 2;
/* 34 */     int j = (this.field_146295_m - this.field_147000_g) / 2;
/* 35 */     func_73729_b(i, j, 0, 0, this.field_146999_f, this.field_147000_g);
/*    */     
/* 37 */     int k = this.field_147013_v.func_145935_i();
/* 38 */     if (k > 0) {
/* 39 */       int m = (int)(28.0F * (1.0F - k / 400.0F));
/* 40 */       if (m > 0) {
/* 41 */         func_73729_b(i + 97, j + 16, 176, 0, 9, m);
/*    */       }
/*    */       
/* 44 */       int n = k / 2 % 7;
/* 45 */       switch (n) {
/*    */         case 6:
/* 47 */           m = 0;
/*    */           break;
/*    */         case 5:
/* 50 */           m = 6;
/*    */           break;
/*    */         case 4:
/* 53 */           m = 11;
/*    */           break;
/*    */         case 3:
/* 56 */           m = 16;
/*    */           break;
/*    */         case 2:
/* 59 */           m = 20;
/*    */           break;
/*    */         case 1:
/* 62 */           m = 24;
/*    */           break;
/*    */         case 0:
/* 65 */           m = 29;
/*    */           break;
/*    */       } 
/*    */       
/* 69 */       if (m > 0)
/* 70 */         func_73729_b(i + 65, j + 14 + 29 - m, 185, 29 - m, 12, m); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\inventory\GuiBrewingStand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */