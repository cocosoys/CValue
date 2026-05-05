/*    */ package net.minecraft.world.gen.structure;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.World;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MapGenStructureIO
/*    */ {
/* 17 */   private static final Logger field_151687_a = LogManager.getLogger();
/* 18 */   private static Map field_143040_a = new HashMap<Object, Object>();
/* 19 */   private static Map field_143038_b = new HashMap<Object, Object>();
/*    */   
/* 21 */   private static Map field_143039_c = new HashMap<Object, Object>();
/* 22 */   private static Map field_143037_d = new HashMap<Object, Object>();
/*    */   
/*    */   public static void func_143034_b(Class<?> p_143034_0_, String p_143034_1_) {
/* 25 */     field_143040_a.put(p_143034_1_, p_143034_0_);
/* 26 */     field_143038_b.put(p_143034_0_, p_143034_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000509";
/*    */   public static void func_143031_a(Class<?> p_143031_0_, String p_143031_1_) {
/* 30 */     field_143039_c.put(p_143031_1_, p_143031_0_);
/* 31 */     field_143037_d.put(p_143031_0_, p_143031_1_);
/*    */   }
/*    */   
/*    */   static {
/* 35 */     func_143034_b(StructureMineshaftStart.class, "Mineshaft");
/* 36 */     func_143034_b(MapGenVillage.Start.class, "Village");
/* 37 */     func_143034_b(MapGenNetherBridge.Start.class, "Fortress");
/* 38 */     func_143034_b(MapGenStronghold.Start.class, "Stronghold");
/* 39 */     func_143034_b(MapGenScatteredFeature.Start.class, "Temple");
/*    */     
/* 41 */     StructureMineshaftPieces.func_143048_a();
/* 42 */     StructureVillagePieces.func_143016_a();
/* 43 */     StructureNetherBridgePieces.func_143049_a();
/* 44 */     StructureStrongholdPieces.func_143046_a();
/* 45 */     ComponentScatteredFeaturePieces.func_143045_a();
/*    */   }
/*    */   
/*    */   public static String func_143033_a(StructureStart p_143033_0_) {
/* 49 */     return (String)field_143038_b.get(p_143033_0_.getClass());
/*    */   }
/*    */   
/*    */   public static String func_143036_a(StructureComponent p_143036_0_) {
/* 53 */     return (String)field_143037_d.get(p_143036_0_.getClass());
/*    */   }
/*    */ 
/*    */   
/*    */   public static StructureStart func_143035_a(NBTTagCompound p_143035_0_, World p_143035_1_) {
/* 58 */     StructureStart structureStart = null;
/*    */     
/*    */     try {
/* 61 */       Class<StructureStart> clazz = (Class)field_143040_a.get(p_143035_0_.func_74779_i("id"));
/* 62 */       if (clazz != null) structureStart = clazz.newInstance();
/*    */     
/* 64 */     } catch (Exception exception) {
/* 65 */       field_151687_a.warn("Failed Start with id " + p_143035_0_.func_74779_i("id"));
/* 66 */       exception.printStackTrace();
/*    */     } 
/* 68 */     if (structureStart != null) {
/* 69 */       structureStart.func_143020_a(p_143035_1_, p_143035_0_);
/*    */     } else {
/* 71 */       field_151687_a.warn("Skipping Structure with id " + p_143035_0_.func_74779_i("id"));
/*    */     } 
/* 73 */     return structureStart;
/*    */   }
/*    */   
/*    */   public static StructureComponent func_143032_b(NBTTagCompound p_143032_0_, World p_143032_1_) {
/* 77 */     StructureComponent structureComponent = null;
/*    */     
/*    */     try {
/* 80 */       Class<StructureComponent> clazz = (Class)field_143039_c.get(p_143032_0_.func_74779_i("id"));
/* 81 */       if (clazz != null) structureComponent = clazz.newInstance();
/*    */     
/* 83 */     } catch (Exception exception) {
/* 84 */       field_151687_a.warn("Failed Piece with id " + p_143032_0_.func_74779_i("id"));
/* 85 */       exception.printStackTrace();
/*    */     } 
/* 87 */     if (structureComponent != null) {
/* 88 */       structureComponent.func_143009_a(p_143032_1_, p_143032_0_);
/*    */     } else {
/* 90 */       field_151687_a.warn("Skipping Piece with id " + p_143032_0_.func_74779_i("id"));
/*    */     } 
/* 92 */     return structureComponent;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\structure\MapGenStructureIO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */