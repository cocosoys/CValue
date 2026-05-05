/*    */ package net.minecraftforge.event.terraingen;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.NoiseGenerator;
/*    */ import net.minecraftforge.event.world.WorldEvent;
/*    */ 
/*    */ 
/*    */ public class InitNoiseGensEvent
/*    */   extends WorldEvent
/*    */ {
/*    */   public final Random rand;
/*    */   public final NoiseGenerator[] originalNoiseGens;
/*    */   public NoiseGenerator[] newNoiseGens;
/*    */   
/*    */   public InitNoiseGensEvent(World world, Random rand, NoiseGenerator[] original) {
/* 17 */     super(world);
/* 18 */     this.rand = rand;
/* 19 */     this.originalNoiseGens = original;
/* 20 */     this.newNoiseGens = (NoiseGenerator[])original.clone();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\terraingen\InitNoiseGensEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */