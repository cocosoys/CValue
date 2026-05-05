/*    */ package net.minecraft.world.biome;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.entity.monster.EntityEnderman;
/*    */ import net.minecraft.init.Blocks;
/*    */ 
/*    */ public class BiomeGenEnd extends BiomeGenBase {
/*    */   public BiomeGenEnd(int p_i1990_1_) {
/*  8 */     super(p_i1990_1_);
/*    */     
/* 10 */     this.field_76761_J.clear();
/* 11 */     this.field_76762_K.clear();
/* 12 */     this.field_76755_L.clear();
/* 13 */     this.field_82914_M.clear();
/*    */     
/* 15 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityEnderman.class, 10, 4, 4));
/* 16 */     this.field_76752_A = Blocks.field_150346_d;
/* 17 */     this.field_76753_B = Blocks.field_150346_d;
/*    */     
/* 19 */     this.field_76760_I = new BiomeEndDecorator();
/*    */   }
/*    */   private static final String __OBFID = "CL_00000187";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_76731_a(float p_76731_1_) {
/* 24 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeGenEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */