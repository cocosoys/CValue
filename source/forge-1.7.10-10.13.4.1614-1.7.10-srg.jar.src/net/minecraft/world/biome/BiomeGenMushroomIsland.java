/*    */ package net.minecraft.world.biome;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.passive.EntityMooshroom;
/*    */ import net.minecraft.init.Blocks;
/*    */ 
/*    */ public class BiomeGenMushroomIsland extends BiomeGenBase {
/*    */   public BiomeGenMushroomIsland(int p_i1984_1_) {
/*  9 */     super(p_i1984_1_);
/*    */     
/* 11 */     this.field_76760_I.field_76832_z = -100;
/* 12 */     this.field_76760_I.field_76802_A = -100;
/* 13 */     this.field_76760_I.field_76803_B = -100;
/*    */     
/* 15 */     this.field_76760_I.field_76798_D = 1;
/* 16 */     this.field_76760_I.field_76807_J = 1;
/*    */     
/* 18 */     this.field_76752_A = (Block)Blocks.field_150391_bh;
/*    */     
/* 20 */     this.field_76761_J.clear();
/* 21 */     this.field_76762_K.clear();
/* 22 */     this.field_76755_L.clear();
/*    */     
/* 24 */     this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityMooshroom.class, 8, 4, 8));
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000177";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeGenMushroomIsland.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */