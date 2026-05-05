/*    */ package net.minecraft.world.biome;
/*    */ import net.minecraft.entity.monster.EntityGhast;
/*    */ import net.minecraft.entity.monster.EntityPigZombie;
/*    */ 
/*    */ public class BiomeGenHell extends BiomeGenBase {
/*    */   public BiomeGenHell(int p_i1981_1_) {
/*  7 */     super(p_i1981_1_);
/*    */     
/*  9 */     this.field_76761_J.clear();
/* 10 */     this.field_76762_K.clear();
/* 11 */     this.field_76755_L.clear();
/* 12 */     this.field_82914_M.clear();
/*    */     
/* 14 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityGhast.class, 50, 4, 4));
/* 15 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityPigZombie.class, 100, 4, 4));
/* 16 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityMagmaCube.class, 1, 4, 4));
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000173";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeGenHell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */