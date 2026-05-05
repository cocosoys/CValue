/*    */ package net.minecraft.network.status.server;
/*    */ import com.google.gson.GsonBuilder;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.ServerStatusResponse;
/*    */ import net.minecraft.network.status.INetHandlerStatusClient;
/*    */ import net.minecraft.util.ChatStyle;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class S00PacketServerInfo extends Packet {
/* 13 */   private static final Gson field_149297_a = (new GsonBuilder()).registerTypeAdapter(ServerStatusResponse.MinecraftProtocolVersionIdentifier.class, new ServerStatusResponse.MinecraftProtocolVersionIdentifier.Serializer()).registerTypeAdapter(ServerStatusResponse.PlayerCountData.class, new ServerStatusResponse.PlayerCountData.Serializer()).registerTypeAdapter(ServerStatusResponse.class, new ServerStatusResponse.Serializer()).registerTypeHierarchyAdapter(IChatComponent.class, new IChatComponent.Serializer()).registerTypeHierarchyAdapter(ChatStyle.class, new ChatStyle.Serializer()).registerTypeAdapterFactory((TypeAdapterFactory)new EnumTypeAdapterFactory()).create();
/*    */ 
/*    */ 
/*    */   
/*    */   private ServerStatusResponse field_149296_b;
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00001384";
/*    */ 
/*    */ 
/*    */   
/*    */   public S00PacketServerInfo() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public S00PacketServerInfo(ServerStatusResponse p_i45273_1_) {
/* 29 */     this.field_149296_b = p_i45273_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 34 */     this.field_149296_b = (ServerStatusResponse)field_149297_a.fromJson(p_148837_1_.func_150789_c(32767), ServerStatusResponse.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 39 */     p_148840_1_.func_150785_a(field_149297_a.toJson(this.field_149296_b));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerStatusClient p_148833_1_) {
/* 44 */     p_148833_1_.func_147397_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public ServerStatusResponse func_149294_c() {
/* 48 */     return this.field_149296_b;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_148836_a() {
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\status\server\S00PacketServerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */