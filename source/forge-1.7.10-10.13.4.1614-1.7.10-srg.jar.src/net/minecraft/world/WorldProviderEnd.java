/*    */ package net.minecraft.world;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.util.ChunkCoordinates;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ import net.minecraft.world.biome.WorldChunkManager;
/*    */ import net.minecraft.world.biome.WorldChunkManagerHell;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ 
/*    */ public class WorldProviderEnd extends WorldProvider {
/*    */   public void func_76572_b() {
/* 13 */     this.field_76578_c = (WorldChunkManager)new WorldChunkManagerHell(BiomeGenBase.field_76779_k, 0.0F);
/* 14 */     this.field_76574_g = 1;
/* 15 */     this.field_76576_e = true;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000389";
/*    */   
/*    */   public IChunkProvider func_76555_c() {
/* 20 */     return (IChunkProvider)new ChunkProviderEnd(this.field_76579_a, this.field_76579_a.func_72905_C());
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_76563_a(long p_76563_1_, float p_76563_3_) {
/* 25 */     return 0.0F;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public float[] func_76560_a(float p_76560_1_, float p_76560_2_) {
/* 30 */     return null;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Vec3 func_76562_b(float p_76562_1_, float p_76562_2_) {
/* 35 */     int i = 10518688;
/* 36 */     float f1 = MathHelper.func_76134_b(p_76562_1_ * 3.1415927F * 2.0F) * 2.0F + 0.5F;
/* 37 */     if (f1 < 0.0F) f1 = 0.0F; 
/* 38 */     if (f1 > 1.0F) f1 = 1.0F;
/*    */     
/* 40 */     float f2 = (i >> 16 & 0xFF) / 255.0F;
/* 41 */     float f3 = (i >> 8 & 0xFF) / 255.0F;
/* 42 */     float f4 = (i & 0xFF) / 255.0F;
/* 43 */     f2 *= f1 * 0.0F + 0.15F;
/* 44 */     f3 *= f1 * 0.0F + 0.15F;
/* 45 */     f4 *= f1 * 0.0F + 0.15F;
/*    */     
/* 47 */     return Vec3.func_72443_a(f2, f3, f4);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_76561_g() {
/* 52 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76567_e() {
/* 57 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76569_d() {
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public float func_76571_f() {
/* 67 */     return 8.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76566_a(int p_76566_1_, int p_76566_2_) {
/* 72 */     return this.field_76579_a.func_147474_b(p_76566_1_, p_76566_2_).func_149688_o().func_76230_c();
/*    */   }
/*    */ 
/*    */   
/*    */   public ChunkCoordinates func_76554_h() {
/* 77 */     return new ChunkCoordinates(100, 50, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_76557_i() {
/* 82 */     return 50;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_76568_b(int p_76568_1_, int p_76568_2_) {
/* 87 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_80007_l() {
/* 92 */     return "The End";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\WorldProviderEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */