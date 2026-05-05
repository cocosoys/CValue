/*    */ package net.minecraftforge.fluids;
/*    */ 
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraftforge.common.util.ForgeDirection;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TileFluidHandler
/*    */   extends TileEntity
/*    */   implements IFluidHandler
/*    */ {
/* 16 */   protected FluidTank tank = new FluidTank(1000);
/*    */ 
/*    */ 
/*    */   
/*    */   public void readFromNBT(NBTTagCompound tag) {
/* 21 */     super.readFromNBT(tag);
/* 22 */     this.tank.readFromNBT(tag);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void writeToNBT(NBTTagCompound tag) {
/* 28 */     super.writeToNBT(tag);
/* 29 */     this.tank.writeToNBT(tag);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
/* 36 */     return this.tank.fill(resource, doFill);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
/* 42 */     if (resource == null || !resource.isFluidEqual(this.tank.getFluid()))
/*    */     {
/* 44 */       return null;
/*    */     }
/* 46 */     return this.tank.drain(resource.amount, doDrain);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
/* 52 */     return this.tank.drain(maxDrain, doDrain);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canFill(ForgeDirection from, Fluid fluid) {
/* 58 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canDrain(ForgeDirection from, Fluid fluid) {
/* 64 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public FluidTankInfo[] getTankInfo(ForgeDirection from) {
/* 70 */     return new FluidTankInfo[] { this.tank.getInfo() };
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\fluids\TileFluidHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */