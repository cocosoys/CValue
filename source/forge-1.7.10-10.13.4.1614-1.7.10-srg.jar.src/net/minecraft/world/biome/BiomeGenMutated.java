/*    */ package net.minecraft.world.biome;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenAbstractTree;
/*    */ 
/*    */ public class BiomeGenMutated
/*    */   extends BiomeGenBase {
/*    */   public BiomeGenMutated(int p_i45381_1_, BiomeGenBase p_i45381_2_) {
/* 14 */     super(p_i45381_1_);
/* 15 */     this.field_150611_aD = p_i45381_2_;
/* 16 */     func_150557_a(p_i45381_2_.field_76790_z, true);
/*    */     
/* 18 */     this.field_76791_y = p_i45381_2_.field_76791_y + " M";
/*    */     
/* 20 */     this.field_76752_A = p_i45381_2_.field_76752_A;
/* 21 */     this.field_76753_B = p_i45381_2_.field_76753_B;
/* 22 */     this.field_76754_C = p_i45381_2_.field_76754_C;
/* 23 */     this.field_76748_D = p_i45381_2_.field_76748_D;
/* 24 */     this.field_76749_E = p_i45381_2_.field_76749_E;
/* 25 */     this.field_76750_F = p_i45381_2_.field_76750_F;
/* 26 */     this.field_76751_G = p_i45381_2_.field_76751_G;
/* 27 */     this.field_76759_H = p_i45381_2_.field_76759_H;
/* 28 */     this.field_76766_R = p_i45381_2_.field_76766_R;
/* 29 */     this.field_76765_S = p_i45381_2_.field_76765_S;
/*    */     
/* 31 */     this.field_76762_K = new ArrayList(p_i45381_2_.field_76762_K);
/* 32 */     this.field_76761_J = new ArrayList(p_i45381_2_.field_76761_J);
/* 33 */     this.field_82914_M = new ArrayList(p_i45381_2_.field_82914_M);
/* 34 */     this.field_76755_L = new ArrayList(p_i45381_2_.field_76755_L);
/*    */     
/* 36 */     this.field_76750_F = p_i45381_2_.field_76750_F;
/* 37 */     this.field_76751_G = p_i45381_2_.field_76751_G;
/*    */     
/* 39 */     this.field_76748_D = p_i45381_2_.field_76748_D + 0.1F;
/* 40 */     this.field_76749_E = p_i45381_2_.field_76749_E + 0.2F;
/*    */   }
/*    */   protected BiomeGenBase field_150611_aD;
/*    */   private static final String __OBFID = "CL_00000178";
/*    */   
/*    */   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
/* 46 */     this.field_150611_aD.field_76760_I.func_150512_a(p_76728_1_, p_76728_2_, this, p_76728_3_, p_76728_4_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_150573_a(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
/* 51 */     this.field_150611_aD.func_150573_a(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_76741_f() {
/* 56 */     return this.field_150611_aD.func_76741_f();
/*    */   }
/*    */ 
/*    */   
/*    */   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
/* 61 */     return this.field_150611_aD.func_150567_a(p_150567_1_);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_150571_c(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
/* 66 */     return this.field_150611_aD.func_150571_c(p_150571_1_, p_150571_2_, p_150571_2_);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_150558_b(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
/* 71 */     return this.field_150611_aD.func_150558_b(p_150558_1_, p_150558_2_, p_150558_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public Class func_150562_l() {
/* 76 */     return this.field_150611_aD.func_150562_l();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_150569_a(BiomeGenBase p_150569_1_) {
/* 81 */     return this.field_150611_aD.func_150569_a(p_150569_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public BiomeGenBase.TempCategory func_150561_m() {
/* 86 */     return this.field_150611_aD.func_150561_m();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeGenMutated.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */