/*    */ package net.minecraftforge.fluids;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class FluidTankInfo
/*    */ {
/*    */   public final FluidStack fluid;
/*    */   public final int capacity;
/*    */   
/*    */   public FluidTankInfo(FluidStack fluid, int capacity) {
/* 16 */     this.fluid = fluid;
/* 17 */     this.capacity = capacity;
/*    */   }
/*    */ 
/*    */   
/*    */   public FluidTankInfo(IFluidTank tank) {
/* 22 */     this.fluid = tank.getFluid();
/* 23 */     this.capacity = tank.getCapacity();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\fluids\FluidTankInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */