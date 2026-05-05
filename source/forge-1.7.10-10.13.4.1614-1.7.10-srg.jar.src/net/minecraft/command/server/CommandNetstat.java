/*    */ package net.minecraft.command.server;
/*    */ 
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.network.NetworkManager;
/*    */ import net.minecraft.network.NetworkStatistics;
/*    */ import net.minecraft.util.ChatComponentText;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class CommandNetstat
/*    */   extends CommandBase {
/*    */   public String func_71517_b() {
/* 13 */     return "netstat";
/*    */   }
/*    */   private static final String __OBFID = "CL_00001904";
/*    */   
/*    */   public int func_82362_a() {
/* 18 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 23 */     return "commands.players.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 28 */     if (p_71515_1_ instanceof net.minecraft.entity.player.EntityPlayer) {
/* 29 */       p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText("Command is not available for players"));
/*    */       
/*    */       return;
/*    */     } 
/* 33 */     if (p_71515_2_.length > 0 && p_71515_2_[0].length() > 1) {
/* 34 */       if ("hottest-read".equals(p_71515_2_[0])) {
/* 35 */         p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText(NetworkManager.field_152462_h.func_152477_e().toString()));
/* 36 */       } else if ("hottest-write".equals(p_71515_2_[0])) {
/* 37 */         p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText(NetworkManager.field_152462_h.func_152475_g().toString()));
/* 38 */       } else if ("most-read".equals(p_71515_2_[0])) {
/* 39 */         p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText(NetworkManager.field_152462_h.func_152467_f().toString()));
/* 40 */       } else if ("most-write".equals(p_71515_2_[0])) {
/* 41 */         p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText(NetworkManager.field_152462_h.func_152470_h().toString()));
/* 42 */       } else if ("packet-read".equals(p_71515_2_[0])) {
/* 43 */         if (p_71515_2_.length > 1 && p_71515_2_[1].length() > 0) {
/*    */           try {
/* 45 */             int i = Integer.parseInt(p_71515_2_[1].trim());
/* 46 */             NetworkStatistics.PacketStat packetStat = NetworkManager.field_152462_h.func_152466_a(i);
/* 47 */             func_152375_a(p_71515_1_, i, packetStat);
/* 48 */           } catch (Exception exception) {
/* 49 */             p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText("Packet " + p_71515_2_[1] + " not found!"));
/*    */           } 
/*    */         } else {
/* 52 */           p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText("Packet id is missing"));
/*    */         } 
/* 54 */       } else if ("packet-write".equals(p_71515_2_[0])) {
/* 55 */         if (p_71515_2_.length > 1 && p_71515_2_[1].length() > 0) {
/*    */           try {
/* 57 */             int i = Integer.parseInt(p_71515_2_[1].trim());
/* 58 */             NetworkStatistics.PacketStat packetStat = NetworkManager.field_152462_h.func_152468_b(i);
/* 59 */             func_152375_a(p_71515_1_, i, packetStat);
/* 60 */           } catch (Exception exception) {
/* 61 */             p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText("Packet " + p_71515_2_[1] + " not found!"));
/*    */           } 
/*    */         } else {
/* 64 */           p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText("Packet id is missing"));
/*    */         } 
/* 66 */       } else if ("read-count".equals(p_71515_2_[0])) {
/* 67 */         p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText("total-read-count" + String.valueOf(NetworkManager.field_152462_h.func_152472_c())));
/* 68 */       } else if ("write-count".equals(p_71515_2_[0])) {
/* 69 */         p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText("total-write-count" + String.valueOf(NetworkManager.field_152462_h.func_152473_d())));
/*    */       } else {
/* 71 */         p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText("Unrecognized: " + p_71515_2_[0]));
/*    */       } 
/*    */     } else {
/* 74 */       String str = "reads: " + NetworkManager.field_152462_h.func_152465_a();
/* 75 */       str = str + ", writes: " + NetworkManager.field_152462_h.func_152471_b();
/* 76 */       p_71515_1_.func_145747_a((IChatComponent)new ChatComponentText(str));
/*    */     } 
/*    */   }
/*    */   
/*    */   private void func_152375_a(ICommandSender p_152375_1_, int p_152375_2_, NetworkStatistics.PacketStat p_152375_3_) {
/* 81 */     if (p_152375_3_ != null) {
/* 82 */       p_152375_1_.func_145747_a((IChatComponent)new ChatComponentText(p_152375_3_.toString()));
/*    */     } else {
/* 84 */       p_152375_1_.func_145747_a((IChatComponent)new ChatComponentText("Packet " + p_152375_2_ + " not found!"));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandNetstat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */