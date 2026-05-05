/*     */ package net.minecraftforge.common;
/*     */ 
/*     */ import com.google.common.collect.ObjectArrays;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.eventhandler.EventBus;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.fluids.FluidRegistry;
/*     */ import net.minecraftforge.oredict.OreDictionary;
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
/*     */ public class MinecraftForge
/*     */ {
/*  28 */   public static final EventBus EVENT_BUS = new EventBus();
/*  29 */   public static final EventBus TERRAIN_GEN_BUS = new EventBus();
/*  30 */   public static final EventBus ORE_GEN_BUS = new EventBus();
/*     */   
/*     */   public static final String MC_VERSION = "1.7.10";
/*  33 */   static final ForgeInternalHandler INTERNAL_HANDLER = new ForgeInternalHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addGrassSeed(ItemStack seed, int weight) {
/*  44 */     ForgeHooks.seedList.add(new ForgeHooks.SeedEntry(seed, weight));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void initialize() {
/*  52 */     FMLLog.info("MinecraftForge v%s Initialized", new Object[] { ForgeVersion.getVersion() });
/*     */     
/*  54 */     OreDictionary.getOreName(0);
/*     */ 
/*     */     
/*  57 */     CrashReport fake = new CrashReport("ThisIsFake", new Exception("Not real"));
/*     */     
/*  59 */     String[] handlers = { "net.minecraft.world.World$1", "net.minecraft.world.World$2", "net.minecraft.world.World$3", "net.minecraft.world.World$4", "net.minecraft.world.chunk.Chunk$1", "net.minecraft.crash.CrashReportCategory$1", "net.minecraft.crash.CrashReportCategory$2", "net.minecraft.crash.CrashReportCategory$3", "net.minecraft.entity.Entity$1", "net.minecraft.entity.Entity$2", "net.minecraft.entity.EntityTracker$1", "net.minecraft.world.gen.layer.GenLayer$1", "net.minecraft.world.gen.layer.GenLayer$2", "net.minecraft.entity.player.InventoryPlayer$1", "net.minecraft.world.gen.structure.MapGenStructure$1", "net.minecraft.world.gen.structure.MapGenStructure$2", "net.minecraft.world.gen.structure.MapGenStructure$3", "net.minecraft.server.MinecraftServer$3", "net.minecraft.server.MinecraftServer$4", "net.minecraft.server.MinecraftServer$5", "net.minecraft.nbt.NBTTagCompound$1", "net.minecraft.nbt.NBTTagCompound$2", "net.minecraft.network.NetHandlerPlayServer$2", "net.minecraft.network.NetworkSystem$3", "net.minecraft.tileentity.TileEntity$1", "net.minecraft.tileentity.TileEntity$2", "net.minecraft.tileentity.TileEntity$3", "net.minecraft.world.storage.WorldInfo$1", "net.minecraft.world.storage.WorldInfo$2", "net.minecraft.world.storage.WorldInfo$3", "net.minecraft.world.storage.WorldInfo$4", "net.minecraft.world.storage.WorldInfo$5", "net.minecraft.world.storage.WorldInfo$6", "net.minecraft.world.storage.WorldInfo$7", "net.minecraft.world.storage.WorldInfo$8", "net.minecraft.world.storage.WorldInfo$9" };
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
/*     */     
/*  97 */     String[] client = { "net.minecraft.client.Minecraft$3", "net.minecraft.client.Minecraft$4", "net.minecraft.client.Minecraft$5", "net.minecraft.client.Minecraft$6", "net.minecraft.client.Minecraft$7", "net.minecraft.client.Minecraft$8", "net.minecraft.client.Minecraft$9", "net.minecraft.client.Minecraft$10", "net.minecraft.client.Minecraft$11", "net.minecraft.client.Minecraft$12", "net.minecraft.client.Minecraft$13", "net.minecraft.client.Minecraft$14", "net.minecraft.client.Minecraft$15", "net.minecraft.client.multiplayer.WorldClient$1", "net.minecraft.client.multiplayer.WorldClient$2", "net.minecraft.client.multiplayer.WorldClient$3", "net.minecraft.client.multiplayer.WorldClient$4", "net.minecraft.client.particle,EffectRenderer$1", "net.minecraft.client.particle,EffectRenderer$2", "net.minecraft.client.particle,EffectRenderer$3", "net.minecraft.client.particle,EffectRenderer$4", "net.minecraft.client.renderer.EntityRenderer$1", "net.minecraft.client.renderer.EntityRenderer$2", "net.minecraft.client.renderer.EntityRenderer$3", "net.minecraft.server.integrated.IntegratedServer$1", "net.minecraft.server.integrated.IntegratedServer$2", "net.minecraft.client.renderer.RenderGlobal$1", "net.minecraft.client.renderer.entity.RenderItem$1", "net.minecraft.client.renderer.entity.RenderItem$2", "net.minecraft.client.renderer.entity.RenderItem$3", "net.minecraft.client.renderer.entity.RenderItem$4", "net.minecraft.client.renderer.texture.TextureAtlasSprite$1", "net.minecraft.client.renderer.texture.TextureManager$1", "net.minecraft.client.renderer.texture.TextureMap$1", "net.minecraft.client.renderer.texture.TextureMap$2", "net.minecraft.client.renderer.texture.TextureMap$3" };
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
/*     */     
/* 135 */     String[] server = { "net.minecraft.server.dedicated.DedicatedServer$3", "net.minecraft.server.dedicated.DedicatedServer$4" };
/*     */ 
/*     */ 
/*     */     
/* 139 */     if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
/* 140 */       handlers = (String[])ObjectArrays.concat((Object[])handlers, (Object[])client, String.class);
/*     */     } else {
/* 142 */       handlers = (String[])ObjectArrays.concat((Object[])handlers, (Object[])server, String.class);
/*     */     } 
/*     */     
/* 145 */     for (String s : handlers) {
/*     */ 
/*     */       
/*     */       try {
/*     */         
/* 150 */         Class<?> cls = Class.forName(s, false, MinecraftForge.class.getClassLoader());
/* 151 */         if (cls == null || !Callable.class.isAssignableFrom(cls));
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 156 */       catch (Exception exception) {}
/*     */     } 
/*     */     
/* 159 */     UsernameCache.load();
/*     */     
/* 161 */     FluidRegistry.validateFluidRegistry();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getBrandingVersion() {
/* 168 */     return "Minecraft Forge " + ForgeVersion.getVersion();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\MinecraftForge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */