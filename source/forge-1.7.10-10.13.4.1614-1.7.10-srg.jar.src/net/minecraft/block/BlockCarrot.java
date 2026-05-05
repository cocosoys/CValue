/*    */ package net.minecraft.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ public class BlockCarrot extends BlockCrops {
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 13 */     if (p_149691_2_ < 7) {
/* 14 */       if (p_149691_2_ == 6) {
/* 15 */         p_149691_2_ = 5;
/*    */       }
/* 17 */       return this.field_149868_a[p_149691_2_ >> 1];
/*    */     } 
/* 19 */     return this.field_149868_a[3];
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon[] field_149868_a;
/*    */   
/*    */   protected Item func_149866_i() {
/* 25 */     return Items.field_151172_bF;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000212";
/*    */   
/*    */   protected Item func_149865_P() {
/* 30 */     return Items.field_151172_bF;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 35 */     this.field_149868_a = new IIcon[4];
/*    */     
/* 37 */     for (byte b = 0; b < this.field_149868_a.length; b++)
/* 38 */       this.field_149868_a[b] = p_149651_1_.func_94245_a(func_149641_N() + "_stage_" + b); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockCarrot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */