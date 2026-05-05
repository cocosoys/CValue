/*     */ package cpw.mods.fml.common.network.internal;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.FMLContainer;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.common.network.FMLEmbeddedChannel;
/*     */ import cpw.mods.fml.common.network.FMLOutboundHandler;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import cpw.mods.fml.common.network.handshake.FMLHandshakeMessage;
/*     */ import cpw.mods.fml.common.network.handshake.NetworkDispatcher;
/*     */ import cpw.mods.fml.common.registry.EntityRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.channel.ChannelHandler;
/*     */ import io.netty.channel.ChannelPipeline;
/*     */ import io.netty.channel.embedded.EmbeddedChannel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.EnumMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import net.minecraft.world.World;
/*     */ import org.apache.logging.log4j.core.helpers.Integers;
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
/*     */ public class FMLNetworkHandler
/*     */ {
/*  53 */   public static final int READ_TIMEOUT = Integers.parseInt(System.getProperty("fml.readTimeout", "30"), 30);
/*  54 */   public static final int LOGIN_TIMEOUT = Integers.parseInt(System.getProperty("fml.loginTimeout", "600"), 600);
/*     */   
/*     */   private static EnumMap<Side, FMLEmbeddedChannel> channelPair;
/*     */   
/*     */   public static void fmlServerHandshake(ServerConfigurationManager scm, NetworkManager manager, EntityPlayerMP player) {
/*  59 */     NetworkDispatcher dispatcher = NetworkDispatcher.allocAndSet(manager, scm);
/*  60 */     dispatcher.serverToClientHandshake(player);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void fmlClientHandshake(NetworkManager field_147393_d) {
/*  65 */     NetworkDispatcher dispatcher = NetworkDispatcher.allocAndSet(field_147393_d);
/*  66 */     dispatcher.clientToServerHandshake();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void openGui(EntityPlayer entityPlayer, Object mod, int modGuiId, World world, int x, int y, int z) {
/*  71 */     ModContainer mc = FMLCommonHandler.instance().findContainerFor(mod);
/*  72 */     if (entityPlayer instanceof EntityPlayerMP) {
/*     */       
/*  74 */       EntityPlayerMP entityPlayerMP = (EntityPlayerMP)entityPlayer;
/*  75 */       Container remoteGuiContainer = NetworkRegistry.INSTANCE.getRemoteGuiContainer(mc, entityPlayerMP, modGuiId, world, x, y, z);
/*  76 */       if (remoteGuiContainer != null)
/*     */       {
/*  78 */         entityPlayerMP.getNextWindowId();
/*  79 */         entityPlayerMP.closeContainer();
/*  80 */         int windowId = entityPlayerMP.currentWindowId;
/*  81 */         FMLMessage.OpenGui openGui = new FMLMessage.OpenGui(windowId, mc.getModId(), modGuiId, x, y, z);
/*  82 */         EmbeddedChannel embeddedChannel = (EmbeddedChannel)channelPair.get(Side.SERVER);
/*  83 */         embeddedChannel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
/*  84 */         embeddedChannel.attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(entityPlayerMP);
/*  85 */         embeddedChannel.writeOutbound(new Object[] { openGui });
/*  86 */         entityPlayerMP.openContainer = remoteGuiContainer;
/*  87 */         entityPlayerMP.openContainer.windowId = windowId;
/*  88 */         entityPlayerMP.openContainer.addCraftingToCrafters((ICrafting)entityPlayerMP);
/*     */       }
/*     */     
/*  91 */     } else if (FMLCommonHandler.instance().getSide().equals(Side.CLIENT)) {
/*     */       
/*  93 */       Object guiContainer = NetworkRegistry.INSTANCE.getLocalGuiContainer(mc, entityPlayer, modGuiId, world, x, y, z);
/*  94 */       FMLCommonHandler.instance().showGuiScreen(guiContainer);
/*     */     }
/*     */     else {
/*     */       
/*  98 */       FMLLog.fine("Invalid attempt to open a local GUI on a dedicated server. This is likely a bug. GUIID: %s,%d", new Object[] { mc.getModId(), Integer.valueOf(modGuiId) });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void makeEntitySpawnAdjustment(Entity entity, EntityPlayerMP player, int serverX, int serverY, int serverZ) {
/* 105 */     EmbeddedChannel embeddedChannel = (EmbeddedChannel)channelPair.get(Side.SERVER);
/* 106 */     embeddedChannel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
/* 107 */     embeddedChannel.attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
/* 108 */     embeddedChannel.writeOutbound(new Object[] { new FMLMessage.EntityAdjustMessage(entity, serverX, serverY, serverZ) });
/*     */   }
/*     */ 
/*     */   
/*     */   public static Packet getEntitySpawningPacket(Entity entity) {
/* 113 */     EntityRegistry.EntityRegistration er = EntityRegistry.instance().lookupModSpawn(entity.getClass(), false);
/* 114 */     if (er == null)
/*     */     {
/* 116 */       return null;
/*     */     }
/* 118 */     if (er.usesVanillaSpawning())
/*     */     {
/* 120 */       return null;
/*     */     }
/*     */     
/* 123 */     return ((FMLEmbeddedChannel)channelPair.get(Side.SERVER)).generatePacketFrom(new FMLMessage.EntitySpawnMessage(er, entity, er.getContainer()));
/*     */   }
/*     */ 
/*     */   
/*     */   public static String checkModList(FMLHandshakeMessage.ModList modListPacket, Side side) {
/* 128 */     Map<String, String> modList = modListPacket.modList();
/* 129 */     return checkModList(modList, side);
/*     */   }
/*     */   
/*     */   public static String checkModList(Map<String, String> listData, Side side) {
/* 133 */     List<ModContainer> rejects = Lists.newArrayList();
/* 134 */     for (Map.Entry<ModContainer, NetworkModHolder> networkMod : (Iterable<Map.Entry<ModContainer, NetworkModHolder>>)NetworkRegistry.INSTANCE.registry().entrySet()) {
/*     */       
/* 136 */       boolean result = ((NetworkModHolder)networkMod.getValue()).check(listData, side);
/* 137 */       if (!result)
/*     */       {
/* 139 */         rejects.add(networkMod.getKey());
/*     */       }
/*     */     } 
/* 142 */     if (rejects.isEmpty())
/*     */     {
/* 144 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 148 */     FMLLog.info("Rejecting connection %s: %s", new Object[] { side, rejects });
/* 149 */     return String.format("Mod rejections %s", new Object[] { rejects });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private static void addClientHandlers() {
/* 156 */     ChannelPipeline pipeline = ((FMLEmbeddedChannel)channelPair.get(Side.CLIENT)).pipeline();
/* 157 */     String targetName = ((FMLEmbeddedChannel)channelPair.get(Side.CLIENT)).findChannelHandlerNameForType(FMLRuntimeCodec.class);
/* 158 */     pipeline.addAfter(targetName, "GuiHandler", (ChannelHandler)new OpenGuiHandler());
/* 159 */     pipeline.addAfter(targetName, "EntitySpawnHandler", (ChannelHandler)new EntitySpawnHandler());
/*     */   }
/*     */   
/*     */   public static void registerChannel(FMLContainer container, Side side) {
/* 163 */     channelPair = NetworkRegistry.INSTANCE.newChannel((ModContainer)container, "FML", new ChannelHandler[] { (ChannelHandler)new FMLRuntimeCodec(), (ChannelHandler)new HandshakeCompletionHandler() });
/* 164 */     EmbeddedChannel embeddedChannel = (EmbeddedChannel)channelPair.get(Side.SERVER);
/* 165 */     embeddedChannel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.NOWHERE);
/*     */     
/* 167 */     if (side == Side.CLIENT)
/*     */     {
/* 169 */       addClientHandlers();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<FMLProxyPacket> forwardHandshake(FMLMessage.CompleteHandshake push, NetworkDispatcher target, Side side) {
/* 175 */     ((FMLEmbeddedChannel)channelPair.get(side)).attr(NetworkDispatcher.FML_DISPATCHER).set(target);
/* 176 */     ((FMLEmbeddedChannel)channelPair.get(side)).writeOutbound(new Object[] { push });
/*     */     
/* 178 */     ArrayList<FMLProxyPacket> list = new ArrayList<FMLProxyPacket>();
/* 179 */     for (Object o : ((FMLEmbeddedChannel)channelPair.get(side)).outboundMessages())
/*     */     {
/* 181 */       list.add((FMLProxyPacket)o);
/*     */     }
/* 183 */     ((FMLEmbeddedChannel)channelPair.get(side)).outboundMessages().clear();
/* 184 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void enhanceStatusQuery(JsonObject jsonobject) {
/* 190 */     JsonObject fmlData = new JsonObject();
/* 191 */     fmlData.addProperty("type", "FML");
/* 192 */     JsonArray modList = new JsonArray();
/* 193 */     for (ModContainer mc : Loader.instance().getActiveModList()) {
/*     */       
/* 195 */       JsonObject modData = new JsonObject();
/* 196 */       modData.addProperty("modid", mc.getModId());
/* 197 */       modData.addProperty("version", mc.getVersion());
/* 198 */       modList.add((JsonElement)modData);
/*     */     } 
/* 200 */     fmlData.add("modList", (JsonElement)modList);
/* 201 */     jsonobject.add("modinfo", (JsonElement)fmlData);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\internal\FMLNetworkHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */