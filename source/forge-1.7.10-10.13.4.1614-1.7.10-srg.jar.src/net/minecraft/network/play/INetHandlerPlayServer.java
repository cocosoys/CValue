package net.minecraft.network.play;

import net.minecraft.network.INetHandler;
import net.minecraft.network.play.client.C00PacketKeepAlive;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0CPacketInput;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
import net.minecraft.network.play.client.C11PacketEnchantItem;
import net.minecraft.network.play.client.C12PacketUpdateSign;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;
import net.minecraft.network.play.client.C14PacketTabComplete;
import net.minecraft.network.play.client.C15PacketClientSettings;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.network.play.client.C17PacketCustomPayload;

public interface INetHandlerPlayServer extends INetHandler {
  void func_147350_a(C0APacketAnimation paramC0APacketAnimation);
  
  void func_147354_a(C01PacketChatMessage paramC01PacketChatMessage);
  
  void func_147341_a(C14PacketTabComplete paramC14PacketTabComplete);
  
  void func_147342_a(C16PacketClientStatus paramC16PacketClientStatus);
  
  void func_147352_a(C15PacketClientSettings paramC15PacketClientSettings);
  
  void func_147339_a(C0FPacketConfirmTransaction paramC0FPacketConfirmTransaction);
  
  void func_147338_a(C11PacketEnchantItem paramC11PacketEnchantItem);
  
  void func_147351_a(C0EPacketClickWindow paramC0EPacketClickWindow);
  
  void func_147356_a(C0DPacketCloseWindow paramC0DPacketCloseWindow);
  
  void func_147349_a(C17PacketCustomPayload paramC17PacketCustomPayload);
  
  void func_147340_a(C02PacketUseEntity paramC02PacketUseEntity);
  
  void func_147353_a(C00PacketKeepAlive paramC00PacketKeepAlive);
  
  void func_147347_a(C03PacketPlayer paramC03PacketPlayer);
  
  void func_147348_a(C13PacketPlayerAbilities paramC13PacketPlayerAbilities);
  
  void func_147345_a(C07PacketPlayerDigging paramC07PacketPlayerDigging);
  
  void func_147357_a(C0BPacketEntityAction paramC0BPacketEntityAction);
  
  void func_147358_a(C0CPacketInput paramC0CPacketInput);
  
  void func_147355_a(C09PacketHeldItemChange paramC09PacketHeldItemChange);
  
  void func_147344_a(C10PacketCreativeInventoryAction paramC10PacketCreativeInventoryAction);
  
  void func_147343_a(C12PacketUpdateSign paramC12PacketUpdateSign);
  
  void func_147346_a(C08PacketPlayerBlockPlacement paramC08PacketPlayerBlockPlacement);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\INetHandlerPlayServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */