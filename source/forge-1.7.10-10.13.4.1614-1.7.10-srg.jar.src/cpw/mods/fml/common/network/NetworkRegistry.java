/*     */ package cpw.mods.fml.common.network;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.common.discovery.ASMDataTable;
/*     */ import cpw.mods.fml.common.network.handshake.NetworkDispatcher;
/*     */ import cpw.mods.fml.common.network.internal.NetworkModHolder;
/*     */ import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import io.netty.channel.ChannelHandler;
/*     */ import io.netty.util.AttributeKey;
/*     */ import java.util.EnumMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.world.World;
/*     */ import org.apache.logging.log4j.Level;
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
/*     */ public enum NetworkRegistry
/*     */ {
/*  52 */   INSTANCE;
/*  53 */   private EnumMap<Side, Map<String, FMLEmbeddedChannel>> channels = Maps.newEnumMap(Side.class);
/*  54 */   private Map<ModContainer, NetworkModHolder> registry = Maps.newHashMap();
/*  55 */   private Map<ModContainer, IGuiHandler> serverGuiHandlers = Maps.newHashMap();
/*  56 */   private Map<ModContainer, IGuiHandler> clientGuiHandlers = Maps.newHashMap();
/*     */   public static final AttributeKey<String> FML_CHANNEL;
/*     */   public static final AttributeKey<Side> CHANNEL_SOURCE;
/*     */   
/*     */   static {
/*  61 */     FML_CHANNEL = new AttributeKey("fml:channelName");
/*  62 */     CHANNEL_SOURCE = new AttributeKey("fml:channelSource");
/*  63 */     MOD_CONTAINER = new AttributeKey("fml:modContainer");
/*  64 */     NET_HANDLER = new AttributeKey("fml:netHandler");
/*     */   }
/*     */   
/*     */   public static final AttributeKey<ModContainer> MOD_CONTAINER;
/*     */   public static final AttributeKey<INetHandler> NET_HANDLER;
/*     */   public static final byte FML_PROTOCOL = 2;
/*     */   
/*     */   NetworkRegistry() {
/*  72 */     this.channels.put(Side.CLIENT, Maps.newConcurrentMap());
/*  73 */     this.channels.put(Side.SERVER, Maps.newConcurrentMap());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class TargetPoint
/*     */   {
/*     */     public final double x;
/*     */ 
/*     */     
/*     */     public final double y;
/*     */     
/*     */     public final double z;
/*     */     
/*     */     public final double range;
/*     */     
/*     */     public final int dimension;
/*     */ 
/*     */     
/*     */     public TargetPoint(int dimension, double x, double y, double z, double range) {
/*  93 */       this.x = x;
/*  94 */       this.y = y;
/*  95 */       this.z = z;
/*  96 */       this.range = range;
/*  97 */       this.dimension = dimension;
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
/*     */   public EnumMap<Side, FMLEmbeddedChannel> newChannel(String name, ChannelHandler... handlers) {
/* 143 */     if (this.channels.containsKey(name) || name.startsWith("MC|") || name.startsWith("\001") || name.startsWith("FML"))
/*     */     {
/* 145 */       throw new RuntimeException("That channel is already registered");
/*     */     }
/* 147 */     EnumMap<Side, FMLEmbeddedChannel> result = Maps.newEnumMap(Side.class);
/*     */     
/* 149 */     for (Side side : Side.values()) {
/*     */       
/* 151 */       FMLEmbeddedChannel channel = new FMLEmbeddedChannel(name, side, handlers);
/* 152 */       ((Map<String, FMLEmbeddedChannel>)this.channels.get(side)).put(name, channel);
/* 153 */       result.put(side, channel);
/*     */     } 
/* 155 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleNetworkWrapper newSimpleChannel(String name) {
/* 166 */     return new SimpleNetworkWrapper(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FMLEventChannel newEventDrivenChannel(String name) {
/* 176 */     return new FMLEventChannel(name);
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
/*     */   public EnumMap<Side, FMLEmbeddedChannel> newChannel(ModContainer container, String name, ChannelHandler... handlers) {
/* 189 */     if (this.channels.containsKey(name) || name.startsWith("MC|") || name.startsWith("\001") || (name.startsWith("FML") && !"FML".equals(container.getModId())))
/*     */     {
/* 191 */       throw new RuntimeException("That channel is already registered");
/*     */     }
/* 193 */     EnumMap<Side, FMLEmbeddedChannel> result = Maps.newEnumMap(Side.class);
/*     */     
/* 195 */     for (Side side : Side.values()) {
/*     */       
/* 197 */       FMLEmbeddedChannel channel = new FMLEmbeddedChannel(container, name, side, handlers);
/* 198 */       ((Map<String, FMLEmbeddedChannel>)this.channels.get(side)).put(name, channel);
/* 199 */       result.put(side, channel);
/*     */     } 
/* 201 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public FMLEmbeddedChannel getChannel(String name, Side source) {
/* 206 */     return (FMLEmbeddedChannel)((Map)this.channels.get(source)).get(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerGuiHandler(Object mod, IGuiHandler handler) {
/* 216 */     ModContainer mc = FMLCommonHandler.instance().findContainerFor(mod);
/* 217 */     if (mc == null) {
/*     */       
/* 219 */       FMLLog.log(Level.ERROR, "Mod of type %s attempted to register a gui network handler during a construction phase", new Object[] { mod.getClass().getName() });
/* 220 */       throw new RuntimeException("Invalid attempt to create a GUI during mod construction. Use an EventHandler instead");
/*     */     } 
/* 222 */     this.serverGuiHandlers.put(mc, handler);
/* 223 */     this.clientGuiHandlers.put(mc, handler);
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
/*     */   public Container getRemoteGuiContainer(ModContainer mc, EntityPlayerMP player, int modGuiId, World world, int x, int y, int z) {
/* 239 */     IGuiHandler handler = this.serverGuiHandlers.get(mc);
/*     */     
/* 241 */     if (handler != null)
/*     */     {
/* 243 */       return (Container)handler.getServerGuiElement(modGuiId, (EntityPlayer)player, world, x, y, z);
/*     */     }
/*     */ 
/*     */     
/* 247 */     return null;
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
/*     */   public Object getLocalGuiContainer(ModContainer mc, EntityPlayer player, int modGuiId, World world, int x, int y, int z) {
/* 264 */     IGuiHandler handler = this.clientGuiHandlers.get(mc);
/* 265 */     return handler.getClientGuiElement(modGuiId, player, world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasChannel(String channelName, Side source) {
/* 276 */     return ((Map)this.channels.get(source)).containsKey(channelName);
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
/*     */   public void register(ModContainer fmlModContainer, Class<?> clazz, String remoteVersionRange, ASMDataTable asmHarvestedData) {
/* 288 */     NetworkModHolder networkModHolder = new NetworkModHolder(fmlModContainer, clazz, remoteVersionRange, asmHarvestedData);
/* 289 */     this.registry.put(fmlModContainer, networkModHolder);
/* 290 */     networkModHolder.testVanillaAcceptance();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isVanillaAccepted(Side from) {
/* 295 */     boolean result = true;
/* 296 */     for (Map.Entry<ModContainer, NetworkModHolder> e : this.registry.entrySet())
/*     */     {
/* 298 */       result &= ((NetworkModHolder)e.getValue()).acceptsVanilla(from);
/*     */     }
/* 300 */     return result;
/*     */   }
/*     */   
/*     */   public Map<ModContainer, NetworkModHolder> registry() {
/* 304 */     return (Map<ModContainer, NetworkModHolder>)ImmutableMap.copyOf(this.registry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> channelNamesFor(Side side) {
/* 314 */     return ((Map)this.channels.get(side)).keySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fireNetworkHandshake(NetworkDispatcher networkDispatcher, Side origin) {
/* 324 */     NetworkHandshakeEstablished handshake = new NetworkHandshakeEstablished(networkDispatcher, networkDispatcher.getNetHandler(), origin);
/* 325 */     for (Map.Entry<String, FMLEmbeddedChannel> channel : (Iterable<Map.Entry<String, FMLEmbeddedChannel>>)((Map)this.channels.get(origin)).entrySet()) {
/*     */       
/* 327 */       ((FMLEmbeddedChannel)channel.getValue()).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.DISPATCHER);
/* 328 */       ((FMLEmbeddedChannel)channel.getValue()).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(networkDispatcher);
/* 329 */       ((FMLEmbeddedChannel)channel.getValue()).pipeline().fireUserEventTriggered(handshake);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\NetworkRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */