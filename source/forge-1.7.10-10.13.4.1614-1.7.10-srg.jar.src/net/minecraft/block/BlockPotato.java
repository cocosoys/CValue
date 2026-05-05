/*    */ package net.minecraft.block;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockPotato extends BlockCrops {
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 13 */     if (p_149691_2_ < 7) {
/* 14 */       if (p_149691_2_ == 6) {
/* 15 */         p_149691_2_ = 5;
/*    */       }
/* 17 */       return this.field_149869_a[p_149691_2_ >> 1];
/*    */     } 
/* 19 */     return this.field_149869_a[3];
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon[] field_149869_a; private static final String __OBFID = "CL_00000286";
/*    */   
/*    */   protected Item func_149866_i() {
/* 25 */     return Items.field_151174_bG;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Item func_149865_P() {
/* 30 */     return Items.field_151174_bG;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
/* 35 */     super.func_149690_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
/*    */     
/* 37 */     if (p_149690_1_.field_72995_K) {
/*    */       return;
/*    */     }
/* 40 */     if (p_149690_5_ >= 7 && 
/* 41 */       p_149690_1_.field_73012_v.nextInt(50) == 0) {
/* 42 */       func_149642_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(Items.field_151170_bI));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 49 */     this.field_149869_a = new IIcon[4];
/*    */     
/* 51 */     for (byte b = 0; b < this.field_149869_a.length; b++)
/* 52 */       this.field_149869_a[b] = p_149651_1_.func_94245_a(func_149641_N() + "_stage_" + b); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockPotato.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */