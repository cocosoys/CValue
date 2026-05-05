/*    */ package net.minecraft.world;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ import net.minecraft.world.biome.WorldChunkManagerHell;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ import net.minecraft.world.gen.ChunkProviderHell;
/*    */ 
/*    */ public class WorldProviderHell extends WorldProvider {
/*    */   public void func_76572_b() {
/* 12 */     this.field_76578_c = (WorldChunkManager)new WorldChunkManagerHell(BiomeGenBase.field_76778_j, 0.0F);
/* 13 */     this.field_76575_d = true;
/* 14 */     this.field_76576_e = true;
/* 15 */     this.field_76574_g = -1;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000387";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Vec3 func_76562_b(float p_76562_1_, float p_76562_2_) {
/* 20 */     return Vec3.func_72443_a(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_76556_a() {
/* 25 */     float f = 0.1F;
/* 26 */     for (byte b = 0; b <= 15; b++) {
/* 27 */       float f1 = 1.0F - b / 15.0F;
/* 28 */       this.field_76573_f[b] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public IChunkProvider func_76555_c() {
/* 34 */     return (IChunkProvider)new ChunkProviderHell(this.field_76579_a, this.field_76579_a.func_72905_C());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76569_d() {
/* 39 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76566_a(int p_76566_1_, int p_76566_2_) {
/* 44 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_76563_a(long p_76563_1_, float p_76563_3_) {
/* 49 */     return 0.5F;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76567_e() {
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_76568_b(int p_76568_1_, int p_76568_2_) {
/* 59 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_80007_l() {
/* 64 */     return "Nether";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\WorldProviderHell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */