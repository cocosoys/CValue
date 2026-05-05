/*    */ package net.minecraft.block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.tileentity.TileEntityNote;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockNote extends BlockContainer {
/*    */   public BlockNote() {
/* 11 */     super(Material.field_151575_d);
/* 12 */     func_149647_a(CreativeTabs.field_78028_d);
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000278";
/*    */   
/*    */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 18 */     boolean bool = p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_, p_149695_4_);
/* 19 */     TileEntityNote tileEntityNote = (TileEntityNote)p_149695_1_.func_147438_o(p_149695_2_, p_149695_3_, p_149695_4_);
/* 20 */     if (tileEntityNote != null && tileEntityNote.field_145880_i != bool) {
/* 21 */       if (bool) {
/* 22 */         tileEntityNote.func_145878_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
/*    */       }
/* 24 */       tileEntityNote.field_145880_i = bool;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/* 31 */     if (p_149727_1_.field_72995_K) return true; 
/* 32 */     TileEntityNote tileEntityNote = (TileEntityNote)p_149727_1_.func_147438_o(p_149727_2_, p_149727_3_, p_149727_4_);
/* 33 */     if (tileEntityNote != null) {
/* 34 */       tileEntityNote.func_145877_a();
/* 35 */       tileEntityNote.func_145878_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
/*    */     } 
/* 37 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149699_a(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {
/* 42 */     if (p_149699_1_.field_72995_K)
/* 43 */       return;  TileEntityNote tileEntityNote = (TileEntityNote)p_149699_1_.func_147438_o(p_149699_2_, p_149699_3_, p_149699_4_);
/* 44 */     if (tileEntityNote != null) tileEntityNote.func_145878_a(p_149699_1_, p_149699_2_, p_149699_3_, p_149699_4_);
/*    */   
/*    */   }
/*    */   
/*    */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 49 */     return (TileEntity)new TileEntityNote();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149696_a(World p_149696_1_, int p_149696_2_, int p_149696_3_, int p_149696_4_, int p_149696_5_, int p_149696_6_) {
/* 54 */     float f = (float)Math.pow(2.0D, (p_149696_6_ - 12) / 12.0D);
/*    */     
/* 56 */     String str = "harp";
/* 57 */     if (p_149696_5_ == 1) str = "bd"; 
/* 58 */     if (p_149696_5_ == 2) str = "snare"; 
/* 59 */     if (p_149696_5_ == 3) str = "hat"; 
/* 60 */     if (p_149696_5_ == 4) str = "bassattack";
/*    */     
/* 62 */     p_149696_1_.func_72908_a(p_149696_2_ + 0.5D, p_149696_3_ + 0.5D, p_149696_4_ + 0.5D, "note." + str, 3.0F, f);
/* 63 */     p_149696_1_.func_72869_a("note", p_149696_2_ + 0.5D, p_149696_3_ + 1.2D, p_149696_4_ + 0.5D, p_149696_6_ / 24.0D, 0.0D, 0.0D);
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockNote.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */