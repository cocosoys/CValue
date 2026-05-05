/*    */ package net.minecraft.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockRedstoneLight extends Block {
/*    */   public BlockRedstoneLight(boolean p_i45421_1_) {
/* 14 */     super(Material.field_151591_t);
/* 15 */     this.field_150171_a = p_i45421_1_;
/*    */     
/* 17 */     if (p_i45421_1_)
/* 18 */       func_149715_a(1.0F); 
/*    */   }
/*    */   
/*    */   private final boolean field_150171_a;
/*    */   
/*    */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/* 24 */     if (!p_149726_1_.field_72995_K)
/* 25 */       if (this.field_150171_a && !p_149726_1_.func_72864_z(p_149726_2_, p_149726_3_, p_149726_4_)) {
/* 26 */         p_149726_1_.func_147464_a(p_149726_2_, p_149726_3_, p_149726_4_, this, 4);
/* 27 */       } else if (!this.field_150171_a && p_149726_1_.func_72864_z(p_149726_2_, p_149726_3_, p_149726_4_)) {
/* 28 */         p_149726_1_.func_147465_d(p_149726_2_, p_149726_3_, p_149726_4_, Blocks.field_150374_bv, 0, 2);
/*    */       }  
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000297";
/*    */   
/*    */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 35 */     if (!p_149695_1_.field_72995_K) {
/* 36 */       if (this.field_150171_a && !p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_, p_149695_4_)) {
/* 37 */         p_149695_1_.func_147464_a(p_149695_2_, p_149695_3_, p_149695_4_, this, 4);
/* 38 */       } else if (!this.field_150171_a && p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_, p_149695_4_)) {
/* 39 */         p_149695_1_.func_147465_d(p_149695_2_, p_149695_3_, p_149695_4_, Blocks.field_150374_bv, 0, 2);
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 46 */     if (!p_149674_1_.field_72995_K && 
/* 47 */       this.field_150171_a && !p_149674_1_.func_72864_z(p_149674_2_, p_149674_3_, p_149674_4_)) {
/* 48 */       p_149674_1_.func_147465_d(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.field_150379_bu, 0, 2);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 55 */     return Item.func_150898_a(Blocks.field_150379_bu);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 60 */     return Item.func_150898_a(Blocks.field_150379_bu);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ItemStack func_149644_j(int p_149644_1_) {
/* 65 */     return new ItemStack(Blocks.field_150379_bu);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockRedstoneLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */