/*    */ package net.minecraftforge.event.terraingen;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.world.WorldType;
/*    */ import net.minecraft.world.gen.layer.GenLayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldTypeEvent
/*    */   extends Event
/*    */ {
/*    */   public final WorldType worldType;
/*    */   
/*    */   public WorldTypeEvent(WorldType worldType) {
/* 22 */     this.worldType = worldType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class BiomeSize
/*    */     extends WorldTypeEvent
/*    */   {
/*    */     public final byte originalSize;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public byte newSize;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public BiomeSize(WorldType worldType, byte original) {
/* 47 */       super(worldType);
/* 48 */       this.originalSize = original;
/* 49 */       this.newSize = original;
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class InitBiomeGens
/*    */     extends WorldTypeEvent
/*    */   {
/*    */     public final long seed;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public final GenLayer[] originalBiomeGens;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public GenLayer[] newBiomeGens;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public InitBiomeGens(WorldType worldType, long seed, GenLayer[] original) {
/* 77 */       super(worldType);
/* 78 */       this.seed = seed;
/* 79 */       this.originalBiomeGens = original;
/* 80 */       this.newBiomeGens = (GenLayer[])original.clone();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\terraingen\WorldTypeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */