/*     */ package net.minecraftforge.fluids;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.registry.RegistryDelegate;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FluidStack
/*     */ {
/*     */   @Deprecated
/*     */   public final Fluid fluid;
/*     */   public int amount;
/*     */   public NBTTagCompound tag;
/*     */   private RegistryDelegate<Fluid> fluidDelegate;
/*     */   
/*     */   public FluidStack(Fluid fluid, int amount) {
/*  33 */     if (fluid == null) {
/*     */       
/*  35 */       FMLLog.bigWarning("Null fluid supplied to fluidstack. Did you try and create a stack for an unregistered fluid?", new Object[0]);
/*  36 */       throw new IllegalArgumentException("Cannot create a fluidstack from a null fluid");
/*     */     } 
/*  38 */     if (!FluidRegistry.isFluidRegistered(fluid)) {
/*     */       
/*  40 */       FMLLog.bigWarning("Failed attempt to create a FluidStack for an unregistered Fluid %s (type %s)", new Object[] { fluid.getName(), fluid.getClass().getName() });
/*  41 */       throw new IllegalArgumentException("Cannot create a fluidstack from an unregistered fluid");
/*     */     } 
/*  43 */     this.fluidDelegate = FluidRegistry.makeDelegate(fluid);
/*  44 */     this.amount = amount;
/*  45 */     this.fluid = fluid;
/*     */   }
/*     */ 
/*     */   
/*     */   public FluidStack(Fluid fluid, int amount, NBTTagCompound nbt) {
/*  50 */     this(fluid, amount);
/*     */     
/*  52 */     if (nbt != null)
/*     */     {
/*  54 */       this.tag = (NBTTagCompound)nbt.copy();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public FluidStack(FluidStack stack, int amount) {
/*  60 */     this(stack.getFluid(), amount, stack.tag);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public FluidStack(int fluidID, int amount) {
/*  67 */     this(FluidRegistry.getFluid(fluidID), amount);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public FluidStack(int fluidID, int amount, NBTTagCompound nbt) {
/*  74 */     this(FluidRegistry.getFluid(fluidID), amount, nbt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FluidStack loadFluidStackFromNBT(NBTTagCompound nbt) {
/*  83 */     if (nbt == null)
/*     */     {
/*  85 */       return null;
/*     */     }
/*  87 */     String fluidName = nbt.getString("FluidName");
/*     */     
/*  89 */     if (fluidName == null || FluidRegistry.getFluid(fluidName) == null)
/*     */     {
/*  91 */       return null;
/*     */     }
/*  93 */     FluidStack stack = new FluidStack(FluidRegistry.getFluid(fluidName), nbt.getInteger("Amount"));
/*     */     
/*  95 */     if (nbt.hasKey("Tag"))
/*     */     {
/*  97 */       stack.tag = nbt.getCompoundTag("Tag");
/*     */     }
/*  99 */     return stack;
/*     */   }
/*     */ 
/*     */   
/*     */   public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
/* 104 */     nbt.setString("FluidName", FluidRegistry.getFluidName(getFluid()));
/* 105 */     nbt.setInteger("Amount", this.amount);
/*     */     
/* 107 */     if (this.tag != null)
/*     */     {
/* 109 */       nbt.setTag("Tag", (NBTBase)this.tag);
/*     */     }
/* 111 */     return nbt;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Fluid getFluid() {
/* 116 */     return (Fluid)this.fluidDelegate.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getFluidID() {
/* 121 */     return FluidRegistry.getFluidID(getFluid());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getLocalizedName() {
/* 126 */     return getFluid().getLocalizedName(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUnlocalizedName() {
/* 131 */     return getFluid().getUnlocalizedName(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FluidStack copy() {
/* 139 */     return new FluidStack(getFluid(), this.amount, this.tag);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFluidEqual(FluidStack other) {
/* 151 */     return (other != null && getFluid() == other.getFluid() && isFluidStackTagEqual(other));
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isFluidStackTagEqual(FluidStack other) {
/* 156 */     return (this.tag == null) ? ((other.tag == null)) : ((other.tag == null) ? false : this.tag.equals(other.tag));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean areFluidStackTagsEqual(FluidStack stack1, FluidStack stack2) {
/* 164 */     return (stack1 == null && stack2 == null) ? true : ((stack1 == null || stack2 == null) ? false : stack1.isFluidStackTagEqual(stack2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsFluid(FluidStack other) {
/* 175 */     return (isFluidEqual(other) && this.amount >= other.amount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFluidStackIdentical(FluidStack other) {
/* 187 */     return (isFluidEqual(other) && this.amount == other.amount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFluidEqual(ItemStack other) {
/* 200 */     if (other == null)
/*     */     {
/* 202 */       return false;
/*     */     }
/*     */     
/* 205 */     if (other.getItem() instanceof IFluidContainerItem)
/*     */     {
/* 207 */       return isFluidEqual(((IFluidContainerItem)other.getItem()).getFluid(other));
/*     */     }
/*     */     
/* 210 */     return isFluidEqual(FluidContainerRegistry.getFluidForFilledItem(other));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 216 */     int code = 1;
/* 217 */     code = 31 * code + getFluid().hashCode();
/* 218 */     code = 31 * code + this.amount;
/* 219 */     if (this.tag != null)
/* 220 */       code = 31 * code + this.tag.hashCode(); 
/* 221 */     return code;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object o) {
/* 232 */     if (!(o instanceof FluidStack))
/*     */     {
/* 234 */       return false;
/*     */     }
/*     */     
/* 237 */     return isFluidEqual((FluidStack)o);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\fluids\FluidStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */