/*    */ package net.minecraft.world.demo;
/*    */ 
/*    */ import net.minecraft.profiler.Profiler;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.world.WorldServer;
/*    */ import net.minecraft.world.WorldSettings;
/*    */ import net.minecraft.world.WorldType;
/*    */ import net.minecraft.world.storage.ISaveHandler;
/*    */ 
/*    */ public class DemoWorldServer
/*    */   extends WorldServer {
/* 12 */   private static final long field_73072_L = "North Carolina".hashCode();
/*    */   
/* 14 */   public static final WorldSettings field_73071_a = (new WorldSettings(field_73072_L, WorldSettings.GameType.SURVIVAL, true, false, WorldType.field_77137_b)).func_77159_a();
/*    */   
/*    */   public DemoWorldServer(MinecraftServer p_i45282_1_, ISaveHandler p_i45282_2_, String p_i45282_3_, int p_i45282_4_, Profiler p_i45282_5_) {
/* 17 */     super(p_i45282_1_, p_i45282_2_, p_i45282_3_, p_i45282_4_, field_73071_a, p_i45282_5_);
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00001428";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\demo\DemoWorldServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */