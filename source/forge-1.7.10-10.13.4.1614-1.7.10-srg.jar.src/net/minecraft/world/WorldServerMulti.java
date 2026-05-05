/*    */ package net.minecraft.world;
/*    */ import net.minecraft.profiler.Profiler;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.world.storage.DerivedWorldInfo;
/*    */ import net.minecraft.world.storage.ISaveHandler;
/*    */ import net.minecraft.world.storage.WorldInfo;
/*    */ 
/*    */ public class WorldServerMulti extends WorldServer {
/*    */   public WorldServerMulti(MinecraftServer p_i45283_1_, ISaveHandler p_i45283_2_, String p_i45283_3_, int p_i45283_4_, WorldSettings p_i45283_5_, WorldServer p_i45283_6_, Profiler p_i45283_7_) {
/* 10 */     super(p_i45283_1_, p_i45283_2_, p_i45283_3_, p_i45283_4_, p_i45283_5_, p_i45283_7_);
/* 11 */     this.field_72988_C = p_i45283_6_.field_72988_C;
/* 12 */     this.field_96442_D = p_i45283_6_.func_96441_U();
/* 13 */     this.field_72986_A = (WorldInfo)new DerivedWorldInfo(p_i45283_6_.func_72912_H());
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00001430";
/*    */   
/*    */   protected void func_73042_a() throws MinecraftException {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\WorldServerMulti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */