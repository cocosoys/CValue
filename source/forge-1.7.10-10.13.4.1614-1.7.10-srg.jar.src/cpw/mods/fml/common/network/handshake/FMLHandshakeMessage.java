/*     */ package cpw.mods.fml.common.network.handshake;
/*     */ 
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.base.Joiner;
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.common.network.ByteBufUtils;
/*     */ import cpw.mods.fml.common.network.internal.FMLProxyPacket;
/*     */ import cpw.mods.fml.common.registry.GameData;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.buffer.Unpooled;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class FMLHandshakeMessage
/*     */ {
/*     */   public static FMLProxyPacket makeCustomChannelRegistration(Set<String> channels) {
/*  28 */     String salutation = Joiner.on(false).join(Iterables.concat(Arrays.asList(new String[] { "FML|HS", "FML" }, ), channels));
/*  29 */     FMLProxyPacket proxy = new FMLProxyPacket(Unpooled.wrappedBuffer(salutation.getBytes(Charsets.UTF_8)), "REGISTER");
/*  30 */     return proxy;
/*     */   }
/*     */   
/*     */   public static class ServerHello
/*     */     extends FMLHandshakeMessage {
/*     */     private byte serverProtocolVersion;
/*     */     private int overrideDimension;
/*     */     
/*     */     public ServerHello() {}
/*     */     
/*     */     public ServerHello(int overrideDim) {
/*  41 */       this.overrideDimension = overrideDim;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void toBytes(ByteBuf buffer) {
/*  47 */       buffer.writeByte(2);
/*  48 */       buffer.writeInt(this.overrideDimension);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void fromBytes(ByteBuf buffer) {
/*  54 */       this.serverProtocolVersion = buffer.readByte();
/*     */       
/*  56 */       if (this.serverProtocolVersion > 1) {
/*     */         
/*  58 */         this.overrideDimension = buffer.readInt();
/*  59 */         FMLLog.fine("Server FML protocol version %d, 4 byte dimension received %d", new Object[] { Byte.valueOf(this.serverProtocolVersion), Integer.valueOf(this.overrideDimension) });
/*     */       }
/*     */       else {
/*     */         
/*  63 */         FMLLog.info("Server FML protocol version %d, no additional data received", new Object[] { Byte.valueOf(this.serverProtocolVersion) });
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public byte protocolVersion() {
/*  69 */       return this.serverProtocolVersion;
/*     */     }
/*     */     
/*     */     public int overrideDim() {
/*  73 */       return this.overrideDimension;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ClientHello extends FMLHandshakeMessage {
/*     */     private byte serverProtocolVersion;
/*     */     
/*     */     public void toBytes(ByteBuf buffer) {
/*  81 */       buffer.writeByte(2);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void fromBytes(ByteBuf buffer) {
/*  87 */       this.serverProtocolVersion = buffer.readByte();
/*     */     }
/*     */ 
/*     */     
/*     */     public byte protocolVersion() {
/*  92 */       return this.serverProtocolVersion;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ModList
/*     */     extends FMLHandshakeMessage
/*     */   {
/*     */     public ModList() {}
/*     */     
/*     */     public ModList(List<ModContainer> modList) {
/* 102 */       for (ModContainer mod : modList)
/*     */       {
/* 104 */         this.modTags.put(mod.getModId(), mod.getVersion()); } 
/*     */     }
/*     */     
/* 107 */     private Map<String, String> modTags = Maps.newHashMap();
/*     */ 
/*     */ 
/*     */     
/*     */     public void toBytes(ByteBuf buffer) {
/* 112 */       super.toBytes(buffer);
/* 113 */       ByteBufUtils.writeVarInt(buffer, this.modTags.size(), 2);
/* 114 */       for (Map.Entry<String, String> modTag : this.modTags.entrySet()) {
/*     */         
/* 116 */         ByteBufUtils.writeUTF8String(buffer, modTag.getKey());
/* 117 */         ByteBufUtils.writeUTF8String(buffer, modTag.getValue());
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void fromBytes(ByteBuf buffer) {
/* 124 */       super.fromBytes(buffer);
/* 125 */       int modCount = ByteBufUtils.readVarInt(buffer, 2);
/* 126 */       for (int i = 0; i < modCount; i++)
/*     */       {
/* 128 */         this.modTags.put(ByteBufUtils.readUTF8String(buffer), ByteBufUtils.readUTF8String(buffer));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public String modListAsString() {
/* 134 */       return Joiner.on(',').withKeyValueSeparator("@").join(this.modTags);
/*     */     }
/*     */ 
/*     */     
/*     */     public int modListSize() {
/* 139 */       return this.modTags.size();
/*     */     }
/*     */     
/*     */     public Map<String, String> modList() {
/* 143 */       return this.modTags;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString(Class<? extends Enum<?>> side) {
/* 149 */       return super.toString(side) + ":" + this.modTags.size() + " mods";
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ModIdData
/*     */     extends FMLHandshakeMessage
/*     */   {
/*     */     private Map<String, Integer> modIds;
/*     */     private Set<String> blockSubstitutions;
/*     */     
/*     */     public ModIdData(GameData.GameDataSnapshot snapshot) {
/* 161 */       this.modIds = snapshot.idMap;
/* 162 */       this.blockSubstitutions = snapshot.blockSubstitutions;
/* 163 */       this.itemSubstitutions = snapshot.itemSubstitutions;
/*     */     }
/*     */ 
/*     */     
/*     */     private Set<String> itemSubstitutions;
/*     */     
/*     */     public ModIdData() {}
/*     */     
/*     */     public void fromBytes(ByteBuf buffer) {
/* 172 */       int length = ByteBufUtils.readVarInt(buffer, 3);
/* 173 */       this.modIds = Maps.newHashMap();
/* 174 */       this.blockSubstitutions = Sets.newHashSet();
/* 175 */       this.itemSubstitutions = Sets.newHashSet();
/*     */       int i;
/* 177 */       for (i = 0; i < length; i++)
/*     */       {
/* 179 */         this.modIds.put(ByteBufUtils.readUTF8String(buffer), Integer.valueOf(ByteBufUtils.readVarInt(buffer, 3)));
/*     */       }
/*     */       
/* 182 */       if (!buffer.isReadable()) {
/*     */         return;
/*     */       }
/*     */       
/* 186 */       length = ByteBufUtils.readVarInt(buffer, 3);
/* 187 */       for (i = 0; i < length; i++)
/*     */       {
/* 189 */         this.blockSubstitutions.add(ByteBufUtils.readUTF8String(buffer));
/*     */       }
/* 191 */       length = ByteBufUtils.readVarInt(buffer, 3);
/* 192 */       for (i = 0; i < length; i++)
/*     */       {
/* 194 */         this.itemSubstitutions.add(ByteBufUtils.readUTF8String(buffer));
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void toBytes(ByteBuf buffer) {
/* 201 */       ByteBufUtils.writeVarInt(buffer, this.modIds.size(), 3);
/* 202 */       for (Map.Entry<String, Integer> entry : this.modIds.entrySet()) {
/*     */         
/* 204 */         ByteBufUtils.writeUTF8String(buffer, entry.getKey());
/* 205 */         ByteBufUtils.writeVarInt(buffer, ((Integer)entry.getValue()).intValue(), 3);
/*     */       } 
/*     */       
/* 208 */       ByteBufUtils.writeVarInt(buffer, this.blockSubstitutions.size(), 3);
/* 209 */       for (String entry : this.blockSubstitutions)
/*     */       {
/* 211 */         ByteBufUtils.writeUTF8String(buffer, entry);
/*     */       }
/* 213 */       ByteBufUtils.writeVarInt(buffer, this.blockSubstitutions.size(), 3);
/*     */       
/* 215 */       for (String entry : this.itemSubstitutions)
/*     */       {
/* 217 */         ByteBufUtils.writeUTF8String(buffer, entry);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public Map<String, Integer> dataList() {
/* 223 */       return this.modIds;
/*     */     }
/*     */     
/*     */     public Set<String> blockSubstitutions() {
/* 227 */       return this.blockSubstitutions;
/*     */     }
/*     */     
/*     */     public Set<String> itemSubstitutions() {
/* 231 */       return this.itemSubstitutions;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString(Class<? extends Enum<?>> side) {
/* 237 */       return super.toString(side) + ":" + this.modIds.size() + " mappings";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class HandshakeAck extends FMLHandshakeMessage {
/*     */     int phase;
/*     */     
/*     */     HandshakeAck(int phase) {
/* 245 */       this.phase = phase;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fromBytes(ByteBuf buffer) {
/* 250 */       this.phase = buffer.readByte();
/*     */     }
/*     */     
/*     */     public HandshakeAck() {}
/*     */     
/*     */     public void toBytes(ByteBuf buffer) {
/* 256 */       buffer.writeByte(this.phase);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString(Class<? extends Enum<?>> side) {
/* 261 */       return super.toString(side) + ":{" + this.phase + "}";
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class HandshakeReset
/*     */     extends FMLHandshakeMessage {}
/*     */ 
/*     */   
/*     */   public void fromBytes(ByteBuf buffer) {}
/*     */ 
/*     */   
/*     */   public void toBytes(ByteBuf buffer) {}
/*     */ 
/*     */   
/*     */   public String toString(Class<? extends Enum<?>> side) {
/* 277 */     return getClass().getName().substring(getClass().getName().lastIndexOf('$'));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\handshake\FMLHandshakeMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */