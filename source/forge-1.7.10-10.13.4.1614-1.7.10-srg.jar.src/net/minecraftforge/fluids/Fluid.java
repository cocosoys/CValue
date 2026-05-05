/*     */ package net.minecraftforge.fluids;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import java.util.Locale;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
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
/*     */ public class Fluid
/*     */ {
/*     */   protected final String fluidName;
/*     */   protected String unlocalizedName;
/*     */   protected IIcon stillIcon;
/*     */   protected IIcon flowingIcon;
/*  52 */   protected int luminosity = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   protected int density = 1000;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  68 */   protected int temperature = 300;
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
/*  80 */   protected int viscosity = 1000;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isGaseous;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  96 */   protected EnumRarity rarity = EnumRarity.common;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 103 */   protected Block block = null;
/*     */ 
/*     */   
/*     */   public Fluid(String fluidName) {
/* 107 */     this.fluidName = fluidName.toLowerCase(Locale.ENGLISH);
/* 108 */     this.unlocalizedName = fluidName;
/*     */   }
/*     */ 
/*     */   
/*     */   public Fluid setUnlocalizedName(String unlocalizedName) {
/* 113 */     this.unlocalizedName = unlocalizedName;
/* 114 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Fluid setBlock(Block block) {
/* 119 */     if (this.block == null || this.block == block) {
/*     */       
/* 121 */       this.block = block;
/*     */     }
/*     */     else {
/*     */       
/* 125 */       FMLLog.warning("A mod has attempted to assign Block " + block + " to the Fluid '" + this.fluidName + "' but this Fluid has already been linked to the Block " + this.block + ". You may have duplicate Fluid Blocks as a result. It *may* be possible to configure your mods to avoid this.", new Object[0]);
/*     */     } 
/*     */     
/* 128 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Fluid setLuminosity(int luminosity) {
/* 133 */     this.luminosity = luminosity;
/* 134 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Fluid setDensity(int density) {
/* 139 */     this.density = density;
/* 140 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Fluid setTemperature(int temperature) {
/* 145 */     this.temperature = temperature;
/* 146 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Fluid setViscosity(int viscosity) {
/* 151 */     this.viscosity = viscosity;
/* 152 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Fluid setGaseous(boolean isGaseous) {
/* 157 */     this.isGaseous = isGaseous;
/* 158 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Fluid setRarity(EnumRarity rarity) {
/* 163 */     this.rarity = rarity;
/* 164 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getName() {
/* 169 */     return this.fluidName;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getID() {
/* 174 */     return FluidRegistry.getFluidID(this.fluidName);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Block getBlock() {
/* 179 */     return this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canBePlacedInWorld() {
/* 184 */     return (this.block != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocalizedName(FluidStack stack) {
/* 192 */     return getLocalizedName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public String getLocalizedName() {
/* 201 */     String s = getUnlocalizedName();
/* 202 */     return (s == null) ? "" : StatCollector.translateToLocal(s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUnlocalizedName(FluidStack stack) {
/* 210 */     return getUnlocalizedName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUnlocalizedName() {
/* 218 */     return "fluid." + this.unlocalizedName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getSpriteNumber() {
/* 226 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getLuminosity() {
/* 232 */     return this.luminosity;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getDensity() {
/* 237 */     return this.density;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getTemperature() {
/* 242 */     return this.temperature;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getViscosity() {
/* 247 */     return this.viscosity;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isGaseous() {
/* 252 */     return this.isGaseous;
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumRarity getRarity() {
/* 257 */     return this.rarity;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColor() {
/* 262 */     return 16777215;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Fluid setStillIcon(IIcon stillIcon) {
/* 267 */     this.stillIcon = stillIcon;
/* 268 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Fluid setFlowingIcon(IIcon flowingIcon) {
/* 273 */     this.flowingIcon = flowingIcon;
/* 274 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Fluid setIcons(IIcon stillIcon, IIcon flowingIcon) {
/* 279 */     return setStillIcon(stillIcon).setFlowingIcon(flowingIcon);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Fluid setIcons(IIcon commonIcon) {
/* 284 */     return setStillIcon(commonIcon).setFlowingIcon(commonIcon);
/*     */   }
/*     */   public IIcon getIcon() {
/* 287 */     return getStillIcon();
/*     */   }
/*     */   
/*     */   public IIcon getStillIcon() {
/* 291 */     return this.stillIcon;
/*     */   }
/*     */ 
/*     */   
/*     */   public IIcon getFlowingIcon() {
/* 296 */     return this.flowingIcon;
/*     */   }
/*     */   
/*     */   public int getLuminosity(FluidStack stack) {
/* 300 */     return getLuminosity();
/* 301 */   } public int getDensity(FluidStack stack) { return getDensity(); }
/* 302 */   public int getTemperature(FluidStack stack) { return getTemperature(); }
/* 303 */   public int getViscosity(FluidStack stack) { return getViscosity(); }
/* 304 */   public boolean isGaseous(FluidStack stack) { return isGaseous(); }
/* 305 */   public EnumRarity getRarity(FluidStack stack) { return getRarity(); }
/* 306 */   public int getColor(FluidStack stack) { return getColor(); } public IIcon getIcon(FluidStack stack) {
/* 307 */     return getIcon();
/*     */   }
/* 309 */   public int getLuminosity(World world, int x, int y, int z) { return getLuminosity(); }
/* 310 */   public int getDensity(World world, int x, int y, int z) { return getDensity(); }
/* 311 */   public int getTemperature(World world, int x, int y, int z) { return getTemperature(); }
/* 312 */   public int getViscosity(World world, int x, int y, int z) { return getViscosity(); }
/* 313 */   public boolean isGaseous(World world, int x, int y, int z) { return isGaseous(); }
/* 314 */   public EnumRarity getRarity(World world, int x, int y, int z) { return getRarity(); }
/* 315 */   public int getColor(World world, int x, int y, int z) { return getColor(); } public IIcon getIcon(World world, int x, int y, int z) {
/* 316 */     return getIcon();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\fluids\Fluid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */