/*    */ package net.minecraft.world.biome;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockFlower;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.entity.monster.EntitySlime;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenAbstractTree;
/*    */ 
/*    */ public class BiomeGenSwamp extends BiomeGenBase {
/*    */   private static final String __OBFID = "CL_00000185";
/*    */   
/*    */   protected BiomeGenSwamp(int p_i1988_1_) {
/* 18 */     super(p_i1988_1_);
/* 19 */     this.field_76760_I.field_76832_z = 2;
/* 20 */     this.field_76760_I.field_76802_A = 1;
/* 21 */     this.field_76760_I.field_76804_C = 1;
/* 22 */     this.field_76760_I.field_76798_D = 8;
/* 23 */     this.field_76760_I.field_76799_E = 10;
/* 24 */     this.field_76760_I.field_76806_I = 1;
/* 25 */     this.field_76760_I.field_76833_y = 4;
/* 26 */     this.field_76760_I.field_76805_H = 0;
/* 27 */     this.field_76760_I.field_76801_G = 0;
/* 28 */     this.field_76760_I.field_76803_B = 5;
/*    */     
/* 30 */     this.field_76759_H = 14745518;
/*    */     
/* 32 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySlime.class, 1, 1, 1));
/*    */   }
/*    */ 
/*    */   
/*    */   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
/* 37 */     return (WorldGenAbstractTree)this.field_76763_Q;
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_150558_b(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
/* 43 */     double d = field_150606_ad.func_151601_a(p_150558_1_ * 0.0225D, p_150558_3_ * 0.0225D);
/* 44 */     if (d < -0.1D) {
/* 45 */       return 5011004;
/*    */     }
/* 47 */     return 6975545;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_150571_c(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
/* 52 */     return 6975545;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_150572_a(Random p_150572_1_, int p_150572_2_, int p_150572_3_, int p_150572_4_) {
/* 57 */     return BlockFlower.field_149859_a[1];
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_150573_a(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
/* 62 */     double d = field_150606_ad.func_151601_a(p_150573_5_ * 0.25D, p_150573_6_ * 0.25D);
/* 63 */     if (d > 0.0D) {
/* 64 */       int i = p_150573_5_ & 0xF;
/* 65 */       int j = p_150573_6_ & 0xF;
/* 66 */       int k = p_150573_3_.length / 256;
/* 67 */       for (char c = 'ÿ'; c >= '\000'; c--) {
/* 68 */         int m = (j * 16 + i) * k + c;
/* 69 */         if (p_150573_3_[m] == null || p_150573_3_[m].func_149688_o() != Material.field_151579_a) {
/* 70 */           if (c == '>' && p_150573_3_[m] != Blocks.field_150355_j) {
/* 71 */             p_150573_3_[m] = Blocks.field_150355_j;
/* 72 */             if (d < 0.12D) {
/* 73 */               p_150573_3_[m + 1] = Blocks.field_150392_bi;
/*    */             }
/*    */           } 
/*    */           
/*    */           break;
/*    */         } 
/*    */       } 
/*    */     } 
/* 81 */     func_150560_b(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeGenSwamp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */