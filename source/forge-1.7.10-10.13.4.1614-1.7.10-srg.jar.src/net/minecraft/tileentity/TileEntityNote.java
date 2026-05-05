/*    */ package net.minecraft.tileentity;
/*    */ 
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class TileEntityNote extends TileEntity {
/*    */   public byte field_145879_a;
/*    */   public boolean field_145880_i;
/*    */   private static final String __OBFID = "CL_00000362";
/*    */   
/*    */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/* 14 */     super.func_145841_b(p_145841_1_);
/* 15 */     p_145841_1_.func_74774_a("note", this.field_145879_a);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/* 20 */     super.func_145839_a(p_145839_1_);
/* 21 */     this.field_145879_a = p_145839_1_.func_74771_c("note");
/* 22 */     if (this.field_145879_a < 0) this.field_145879_a = 0; 
/* 23 */     if (this.field_145879_a > 24) this.field_145879_a = 24; 
/*    */   }
/*    */   
/*    */   public void func_145877_a() {
/* 27 */     this.field_145879_a = (byte)((this.field_145879_a + 1) % 25);
/* 28 */     func_70296_d();
/*    */   }
/*    */   
/*    */   public void func_145878_a(World p_145878_1_, int p_145878_2_, int p_145878_3_, int p_145878_4_) {
/* 32 */     if (p_145878_1_.func_147439_a(p_145878_2_, p_145878_3_ + 1, p_145878_4_).func_149688_o() != Material.field_151579_a)
/*    */       return; 
/* 34 */     Material material = p_145878_1_.func_147439_a(p_145878_2_, p_145878_3_ - 1, p_145878_4_).func_149688_o();
/*    */     
/* 36 */     byte b = 0;
/* 37 */     if (material == Material.field_151576_e) b = 1; 
/* 38 */     if (material == Material.field_151595_p) b = 2; 
/* 39 */     if (material == Material.field_151592_s) b = 3; 
/* 40 */     if (material == Material.field_151575_d) b = 4;
/*    */     
/* 42 */     p_145878_1_.func_147452_c(p_145878_2_, p_145878_3_, p_145878_4_, Blocks.field_150323_B, b, this.field_145879_a);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntityNote.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */