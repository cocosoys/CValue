/*     */ package net.minecraftforge.fluids;
/*     */ 
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.common.MinecraftForge;
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
/*     */ 
/*     */ 
/*     */ public abstract class FluidContainerRegistry
/*     */ {
/*     */   private static class ContainerKey
/*     */   {
/*     */     ItemStack container;
/*     */     FluidStack stack;
/*     */     
/*     */     private ContainerKey(ItemStack container) {
/*  39 */       this.container = container;
/*     */     }
/*     */     
/*     */     private ContainerKey(ItemStack container, FluidStack stack) {
/*  43 */       this(container);
/*  44 */       this.stack = stack;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*  49 */       int code = 1;
/*  50 */       code = 31 * code + this.container.getItem().hashCode();
/*  51 */       code = 31 * code + this.container.getItemDamage();
/*  52 */       if (this.stack != null)
/*  53 */         code = 31 * code + this.stack.getFluid().hashCode(); 
/*  54 */       return code;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object o) {
/*  59 */       if (!(o instanceof ContainerKey)) return false; 
/*  60 */       ContainerKey ck = (ContainerKey)o;
/*  61 */       if (this.container.getItem() != ck.container.getItem()) return false; 
/*  62 */       if (this.container.getItemDamage() != ck.container.getItemDamage()) return false; 
/*  63 */       if (this.stack == null && ck.stack != null) return false; 
/*  64 */       if (this.stack != null && ck.stack == null) return false; 
/*  65 */       if (this.stack == null && ck.stack == null) return true; 
/*  66 */       if (this.stack.getFluid() != ck.stack.getFluid()) return false; 
/*  67 */       return true;
/*     */     }
/*     */   }
/*     */   
/*  71 */   private static Map<ContainerKey, FluidContainerData> containerFluidMap = Maps.newHashMap();
/*  72 */   private static Map<ContainerKey, FluidContainerData> filledContainerMap = Maps.newHashMap();
/*  73 */   private static Set<ContainerKey> emptyContainers = Sets.newHashSet();
/*     */   
/*     */   public static final int BUCKET_VOLUME = 1000;
/*  76 */   public static final ItemStack EMPTY_BUCKET = new ItemStack(Items.bucket);
/*  77 */   public static final ItemStack EMPTY_BOTTLE = new ItemStack(Items.glass_bottle);
/*  78 */   private static final ItemStack NULL_EMPTYCONTAINER = new ItemStack(Items.bucket);
/*     */ 
/*     */   
/*     */   static {
/*  82 */     registerFluidContainer(FluidRegistry.WATER, new ItemStack(Items.water_bucket), EMPTY_BUCKET);
/*  83 */     registerFluidContainer(FluidRegistry.LAVA, new ItemStack(Items.lava_bucket), EMPTY_BUCKET);
/*  84 */     registerFluidContainer(FluidRegistry.WATER, new ItemStack((Item)Items.potionitem), EMPTY_BOTTLE);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean registerFluidContainer(FluidStack stack, ItemStack filledContainer, ItemStack emptyContainer) {
/* 102 */     return registerFluidContainer(new FluidContainerData(stack, filledContainer, emptyContainer));
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean registerFluidContainer(Fluid fluid, ItemStack filledContainer, ItemStack emptyContainer) {
/* 119 */     if (!FluidRegistry.isFluidRegistered(fluid))
/*     */     {
/* 121 */       FluidRegistry.registerFluid(fluid);
/*     */     }
/* 123 */     return registerFluidContainer(new FluidStack(fluid, 1000), filledContainer, emptyContainer);
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
/*     */   
/*     */   public static boolean registerFluidContainer(FluidStack stack, ItemStack filledContainer) {
/* 137 */     return registerFluidContainer(new FluidContainerData(stack, filledContainer, null, true));
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
/*     */ 
/*     */   
/*     */   public static boolean registerFluidContainer(Fluid fluid, ItemStack filledContainer) {
/* 152 */     if (!FluidRegistry.isFluidRegistered(fluid))
/*     */     {
/* 154 */       FluidRegistry.registerFluid(fluid);
/*     */     }
/* 156 */     return registerFluidContainer(new FluidStack(fluid, 1000), filledContainer);
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
/*     */   public static boolean registerFluidContainer(FluidContainerData data) {
/* 168 */     if (isFilledContainer(data.filledContainer) || data.filledContainer == null)
/*     */     {
/* 170 */       return false;
/*     */     }
/* 172 */     if (data.fluid == null || data.fluid.getFluid() == null) {
/*     */       
/* 174 */       FMLLog.bigWarning("Invalid registration attempt for a fluid container item %s has occurred. The registration has been denied to prevent crashes. The mod responsible for the registration needs to correct this.", new Object[] { data.filledContainer.getItem().getUnlocalizedName(data.filledContainer) });
/* 175 */       return false;
/*     */     } 
/* 177 */     containerFluidMap.put(new ContainerKey(data.filledContainer), data);
/*     */     
/* 179 */     if (data.emptyContainer != null && data.emptyContainer != NULL_EMPTYCONTAINER) {
/*     */       
/* 181 */       filledContainerMap.put(new ContainerKey(data.emptyContainer, data.fluid), data);
/* 182 */       emptyContainers.add(new ContainerKey(data.emptyContainer));
/*     */     } 
/*     */     
/* 185 */     MinecraftForge.EVENT_BUS.post(new FluidContainerRegisterEvent(data));
/* 186 */     return true;
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
/*     */   public static FluidStack getFluidForFilledItem(ItemStack container) {
/* 198 */     if (container == null)
/*     */     {
/* 200 */       return null;
/*     */     }
/*     */     
/* 203 */     FluidContainerData data = containerFluidMap.get(new ContainerKey(container));
/* 204 */     return (data == null) ? null : data.fluid.copy();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemStack fillFluidContainer(FluidStack fluid, ItemStack container) {
/* 220 */     if (container == null || fluid == null)
/*     */     {
/* 222 */       return null;
/*     */     }
/*     */     
/* 225 */     FluidContainerData data = filledContainerMap.get(new ContainerKey(container, fluid));
/* 226 */     if (data != null && fluid.amount >= data.fluid.amount)
/*     */     {
/* 228 */       return data.filledContainer.copy();
/*     */     }
/* 230 */     return null;
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
/*     */   public static ItemStack drainFluidContainer(ItemStack container) {
/* 242 */     if (container == null)
/*     */     {
/* 244 */       return null;
/*     */     }
/*     */     
/* 247 */     FluidContainerData data = containerFluidMap.get(new ContainerKey(container));
/* 248 */     if (data != null)
/*     */     {
/* 250 */       return data.emptyContainer.copy();
/*     */     }
/*     */     
/* 253 */     return null;
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
/*     */   public static int getContainerCapacity(ItemStack container) {
/* 266 */     return getContainerCapacity(null, container);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getContainerCapacity(FluidStack fluid, ItemStack container) {
/* 283 */     if (container == null)
/*     */     {
/* 285 */       return 0;
/*     */     }
/*     */     
/* 288 */     FluidContainerData data = containerFluidMap.get(new ContainerKey(container));
/*     */     
/* 290 */     if (data != null)
/*     */     {
/* 292 */       return data.fluid.amount;
/*     */     }
/*     */     
/* 295 */     if (fluid != null) {
/*     */       
/* 297 */       data = filledContainerMap.get(new ContainerKey(container, fluid));
/*     */       
/* 299 */       if (data != null)
/*     */       {
/* 301 */         return data.fluid.amount;
/*     */       }
/*     */     } 
/*     */     
/* 305 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean containsFluid(ItemStack container, FluidStack fluid) {
/* 313 */     if (container == null || fluid == null)
/*     */     {
/* 315 */       return false;
/*     */     }
/*     */     
/* 318 */     FluidContainerData data = containerFluidMap.get(new ContainerKey(container));
/* 319 */     return (data == null) ? false : data.fluid.containsFluid(fluid);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isBucket(ItemStack container) {
/* 324 */     if (container == null)
/*     */     {
/* 326 */       return false;
/*     */     }
/*     */     
/* 329 */     if (container.isItemEqual(EMPTY_BUCKET))
/*     */     {
/* 331 */       return true;
/*     */     }
/*     */     
/* 334 */     FluidContainerData data = containerFluidMap.get(new ContainerKey(container));
/* 335 */     return (data != null && data.emptyContainer.isItemEqual(EMPTY_BUCKET));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isContainer(ItemStack container) {
/* 340 */     return (isEmptyContainer(container) || isFilledContainer(container));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isEmptyContainer(ItemStack container) {
/* 345 */     return (container != null && emptyContainers.contains(new ContainerKey(container)));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isFilledContainer(ItemStack container) {
/* 350 */     return (container != null && getFluidForFilledItem(container) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static FluidContainerData[] getRegisteredFluidContainerData() {
/* 355 */     return (FluidContainerData[])containerFluidMap.values().toArray((Object[])new FluidContainerData[containerFluidMap.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class FluidContainerData
/*     */   {
/*     */     public final FluidStack fluid;
/*     */     
/*     */     public final ItemStack filledContainer;
/*     */     
/*     */     public final ItemStack emptyContainer;
/*     */ 
/*     */     
/*     */     public FluidContainerData(FluidStack stack, ItemStack filledContainer, ItemStack emptyContainer) {
/* 370 */       this(stack, filledContainer, emptyContainer, false);
/*     */     }
/*     */ 
/*     */     
/*     */     public FluidContainerData(FluidStack stack, ItemStack filledContainer, ItemStack emptyContainer, boolean nullEmpty) {
/* 375 */       this.fluid = stack;
/* 376 */       this.filledContainer = filledContainer;
/* 377 */       this.emptyContainer = (emptyContainer == null) ? FluidContainerRegistry.NULL_EMPTYCONTAINER : emptyContainer;
/*     */       
/* 379 */       if (stack == null || filledContainer == null || (emptyContainer == null && !nullEmpty))
/*     */       {
/* 381 */         throw new RuntimeException("Invalid FluidContainerData - a parameter was null.");
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public FluidContainerData copy() {
/* 387 */       return new FluidContainerData(this.fluid, this.filledContainer, this.emptyContainer, true);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FluidContainerRegisterEvent
/*     */     extends Event
/*     */   {
/*     */     public final FluidContainerRegistry.FluidContainerData data;
/*     */     
/*     */     public FluidContainerRegisterEvent(FluidContainerRegistry.FluidContainerData data) {
/* 397 */       this.data = data.copy();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\fluids\FluidContainerRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */