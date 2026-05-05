/*     */ package net.minecraftforge.fluids;
/*     */ 
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FluidTank
/*     */   implements IFluidTank
/*     */ {
/*     */   protected FluidStack fluid;
/*     */   protected int capacity;
/*     */   protected TileEntity tile;
/*     */   
/*     */   public FluidTank(int capacity) {
/*  21 */     this(null, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public FluidTank(FluidStack stack, int capacity) {
/*  26 */     this.fluid = stack;
/*  27 */     this.capacity = capacity;
/*     */   }
/*     */ 
/*     */   
/*     */   public FluidTank(Fluid fluid, int amount, int capacity) {
/*  32 */     this(new FluidStack(fluid, amount), capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public FluidTank readFromNBT(NBTTagCompound nbt) {
/*  37 */     if (!nbt.hasKey("Empty")) {
/*     */       
/*  39 */       FluidStack fluid = FluidStack.loadFluidStackFromNBT(nbt);
/*  40 */       setFluid(fluid);
/*     */     }
/*     */     else {
/*     */       
/*  44 */       setFluid(null);
/*     */     } 
/*  46 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
/*  51 */     if (this.fluid != null) {
/*     */       
/*  53 */       this.fluid.writeToNBT(nbt);
/*     */     }
/*     */     else {
/*     */       
/*  57 */       nbt.setString("Empty", "");
/*     */     } 
/*  59 */     return nbt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFluid(FluidStack fluid) {
/*  64 */     this.fluid = fluid;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCapacity(int capacity) {
/*  69 */     this.capacity = capacity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FluidStack getFluid() {
/*  76 */     return this.fluid;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFluidAmount() {
/*  82 */     if (this.fluid == null)
/*     */     {
/*  84 */       return 0;
/*     */     }
/*  86 */     return this.fluid.amount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCapacity() {
/*  92 */     return this.capacity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FluidTankInfo getInfo() {
/*  98 */     return new FluidTankInfo(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int fill(FluidStack resource, boolean doFill) {
/* 104 */     if (resource == null)
/*     */     {
/* 106 */       return 0;
/*     */     }
/*     */     
/* 109 */     if (!doFill) {
/*     */       
/* 111 */       if (this.fluid == null)
/*     */       {
/* 113 */         return Math.min(this.capacity, resource.amount);
/*     */       }
/*     */       
/* 116 */       if (!this.fluid.isFluidEqual(resource))
/*     */       {
/* 118 */         return 0;
/*     */       }
/*     */       
/* 121 */       return Math.min(this.capacity - this.fluid.amount, resource.amount);
/*     */     } 
/*     */     
/* 124 */     if (this.fluid == null) {
/*     */       
/* 126 */       this.fluid = new FluidStack(resource, Math.min(this.capacity, resource.amount));
/*     */       
/* 128 */       if (this.tile != null)
/*     */       {
/* 130 */         FluidEvent.fireEvent(new FluidEvent.FluidFillingEvent(this.fluid, this.tile.getWorldObj(), this.tile.xCoord, this.tile.yCoord, this.tile.zCoord, this, this.fluid.amount));
/*     */       }
/* 132 */       return this.fluid.amount;
/*     */     } 
/*     */     
/* 135 */     if (!this.fluid.isFluidEqual(resource))
/*     */     {
/* 137 */       return 0;
/*     */     }
/* 139 */     int filled = this.capacity - this.fluid.amount;
/*     */     
/* 141 */     if (resource.amount < filled) {
/*     */       
/* 143 */       this.fluid.amount += resource.amount;
/* 144 */       filled = resource.amount;
/*     */     }
/*     */     else {
/*     */       
/* 148 */       this.fluid.amount = this.capacity;
/*     */     } 
/*     */     
/* 151 */     if (this.tile != null)
/*     */     {
/* 153 */       FluidEvent.fireEvent(new FluidEvent.FluidFillingEvent(this.fluid, this.tile.getWorldObj(), this.tile.xCoord, this.tile.yCoord, this.tile.zCoord, this, filled));
/*     */     }
/* 155 */     return filled;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FluidStack drain(int maxDrain, boolean doDrain) {
/* 161 */     if (this.fluid == null)
/*     */     {
/* 163 */       return null;
/*     */     }
/*     */     
/* 166 */     int drained = maxDrain;
/* 167 */     if (this.fluid.amount < drained)
/*     */     {
/* 169 */       drained = this.fluid.amount;
/*     */     }
/*     */     
/* 172 */     FluidStack stack = new FluidStack(this.fluid, drained);
/* 173 */     if (doDrain) {
/*     */       
/* 175 */       this.fluid.amount -= drained;
/* 176 */       if (this.fluid.amount <= 0)
/*     */       {
/* 178 */         this.fluid = null;
/*     */       }
/*     */       
/* 181 */       if (this.tile != null)
/*     */       {
/* 183 */         FluidEvent.fireEvent(new FluidEvent.FluidDrainingEvent(this.fluid, this.tile.getWorldObj(), this.tile.xCoord, this.tile.yCoord, this.tile.zCoord, this, drained));
/*     */       }
/*     */     } 
/* 186 */     return stack;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\fluids\FluidTank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */