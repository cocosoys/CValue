/*     */ package net.minecraftforge.fluids;
/*     */ 
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ 
/*     */ 
/*     */ public class FluidEvent
/*     */   extends Event
/*     */ {
/*     */   public final FluidStack fluid;
/*     */   public final int x;
/*     */   public final int y;
/*     */   public final int z;
/*     */   public final World world;
/*     */   
/*     */   public FluidEvent(FluidStack fluid, World world, int x, int y, int z) {
/*  18 */     this.fluid = fluid;
/*  19 */     this.world = world;
/*  20 */     this.x = x;
/*  21 */     this.y = y;
/*  22 */     this.z = z;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class FluidMotionEvent
/*     */     extends FluidEvent
/*     */   {
/*     */     public FluidMotionEvent(FluidStack fluid, World world, int x, int y, int z) {
/*  35 */       super(fluid, world, x, y, z);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class FluidFillingEvent
/*     */     extends FluidEvent
/*     */   {
/*     */     public final IFluidTank tank;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int amount;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     public FluidFillingEvent(FluidStack fluid, World world, int x, int y, int z, IFluidTank tank) {
/*  58 */       this(fluid, world, x, y, z, tank, -1);
/*     */     }
/*     */ 
/*     */     
/*     */     public FluidFillingEvent(FluidStack fluid, World world, int x, int y, int z, IFluidTank tank, int amount) {
/*  63 */       super(fluid, world, x, y, z);
/*  64 */       this.tank = tank;
/*  65 */       this.amount = amount;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class FluidDrainingEvent
/*     */     extends FluidEvent
/*     */   {
/*     */     public final IFluidTank tank;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int amount;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     public FluidDrainingEvent(FluidStack fluid, World world, int x, int y, int z, IFluidTank tank) {
/*  88 */       this(fluid, world, x, y, z, tank, -1);
/*     */     }
/*     */ 
/*     */     
/*     */     public FluidDrainingEvent(FluidStack fluid, World world, int x, int y, int z, IFluidTank tank, int amount) {
/*  93 */       super(fluid, world, x, y, z);
/*  94 */       this.amount = amount;
/*  95 */       this.tank = tank;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class FluidSpilledEvent
/*     */     extends FluidEvent
/*     */   {
/*     */     public FluidSpilledEvent(FluidStack fluid, World world, int x, int y, int z) {
/* 110 */       super(fluid, world, x, y, z);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void fireEvent(FluidEvent event) {
/* 121 */     MinecraftForge.EVENT_BUS.post(event);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\fluids\FluidEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */