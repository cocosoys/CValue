/*     */ package net.minecraftforge.fluids;
/*     */ 
/*     */ import net.minecraft.item.Item;
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
/*     */ public class ItemFluidContainer
/*     */   extends Item
/*     */   implements IFluidContainerItem
/*     */ {
/*     */   protected int capacity;
/*     */   
/*     */   public ItemFluidContainer(int itemID) {}
/*     */   
/*     */   public ItemFluidContainer(int itemID, int capacity) {
/*  25 */     this.capacity = capacity;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemFluidContainer setCapacity(int capacity) {
/*  30 */     this.capacity = capacity;
/*  31 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FluidStack getFluid(ItemStack container) {
/*  38 */     if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Fluid"))
/*     */     {
/*  40 */       return null;
/*     */     }
/*  42 */     return FluidStack.loadFluidStackFromNBT(container.stackTagCompound.getCompoundTag("Fluid"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCapacity(ItemStack container) {
/*  48 */     return this.capacity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int fill(ItemStack container, FluidStack resource, boolean doFill) {
/*  54 */     if (resource == null)
/*     */     {
/*  56 */       return 0;
/*     */     }
/*     */     
/*  59 */     if (!doFill) {
/*     */       
/*  61 */       if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Fluid"))
/*     */       {
/*  63 */         return Math.min(this.capacity, resource.amount);
/*     */       }
/*     */       
/*  66 */       FluidStack fluidStack = FluidStack.loadFluidStackFromNBT(container.stackTagCompound.getCompoundTag("Fluid"));
/*     */       
/*  68 */       if (fluidStack == null)
/*     */       {
/*  70 */         return Math.min(this.capacity, resource.amount);
/*     */       }
/*     */       
/*  73 */       if (!fluidStack.isFluidEqual(resource))
/*     */       {
/*  75 */         return 0;
/*     */       }
/*     */       
/*  78 */       return Math.min(this.capacity - fluidStack.amount, resource.amount);
/*     */     } 
/*     */     
/*  81 */     if (container.stackTagCompound == null)
/*     */     {
/*  83 */       container.stackTagCompound = new NBTTagCompound();
/*     */     }
/*     */     
/*  86 */     if (!container.stackTagCompound.hasKey("Fluid")) {
/*     */       
/*  88 */       NBTTagCompound nBTTagCompound = resource.writeToNBT(new NBTTagCompound());
/*     */       
/*  90 */       if (this.capacity < resource.amount) {
/*     */         
/*  92 */         nBTTagCompound.setInteger("Amount", this.capacity);
/*  93 */         container.stackTagCompound.setTag("Fluid", (NBTBase)nBTTagCompound);
/*  94 */         return this.capacity;
/*     */       } 
/*     */       
/*  97 */       container.stackTagCompound.setTag("Fluid", (NBTBase)nBTTagCompound);
/*  98 */       return resource.amount;
/*     */     } 
/*     */     
/* 101 */     NBTTagCompound fluidTag = container.stackTagCompound.getCompoundTag("Fluid");
/* 102 */     FluidStack stack = FluidStack.loadFluidStackFromNBT(fluidTag);
/*     */     
/* 104 */     if (!stack.isFluidEqual(resource))
/*     */     {
/* 106 */       return 0;
/*     */     }
/*     */     
/* 109 */     int filled = this.capacity - stack.amount;
/* 110 */     if (resource.amount < filled) {
/*     */       
/* 112 */       stack.amount += resource.amount;
/* 113 */       filled = resource.amount;
/*     */     }
/*     */     else {
/*     */       
/* 117 */       stack.amount = this.capacity;
/*     */     } 
/*     */     
/* 120 */     container.stackTagCompound.setTag("Fluid", (NBTBase)stack.writeToNBT(fluidTag));
/* 121 */     return filled;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FluidStack drain(ItemStack container, int maxDrain, boolean doDrain) {
/* 127 */     if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Fluid"))
/*     */     {
/* 129 */       return null;
/*     */     }
/*     */     
/* 132 */     FluidStack stack = FluidStack.loadFluidStackFromNBT(container.stackTagCompound.getCompoundTag("Fluid"));
/* 133 */     if (stack == null)
/*     */     {
/* 135 */       return null;
/*     */     }
/*     */     
/* 138 */     int currentAmount = stack.amount;
/* 139 */     stack.amount = Math.min(stack.amount, maxDrain);
/* 140 */     if (doDrain) {
/*     */       
/* 142 */       if (currentAmount == stack.amount) {
/*     */         
/* 144 */         container.stackTagCompound.removeTag("Fluid");
/*     */         
/* 146 */         if (container.stackTagCompound.hasNoTags())
/*     */         {
/* 148 */           container.stackTagCompound = null;
/*     */         }
/* 150 */         return stack;
/*     */       } 
/*     */       
/* 153 */       NBTTagCompound fluidTag = container.stackTagCompound.getCompoundTag("Fluid");
/* 154 */       fluidTag.setInteger("Amount", currentAmount - stack.amount);
/* 155 */       container.stackTagCompound.setTag("Fluid", (NBTBase)fluidTag);
/*     */     } 
/* 157 */     return stack;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\fluids\ItemFluidContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */