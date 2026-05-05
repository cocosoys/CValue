package net.minecraft.network.play;

import net.minecraft.network.INetHandler;
import net.minecraft.network.play.server.S00PacketKeepAlive;
import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.network.play.server.S04PacketEntityEquipment;
import net.minecraft.network.play.server.S05PacketSpawnPosition;
import net.minecraft.network.play.server.S06PacketUpdateHealth;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S09PacketHeldItemChange;
import net.minecraft.network.play.server.S0APacketUseBed;
import net.minecraft.network.play.server.S0BPacketAnimation;
import net.minecraft.network.play.server.S0CPacketSpawnPlayer;
import net.minecraft.network.play.server.S0DPacketCollectItem;
import net.minecraft.network.play.server.S0EPacketSpawnObject;
import net.minecraft.network.play.server.S0FPacketSpawnMob;
import net.minecraft.network.play.server.S10PacketSpawnPainting;
import net.minecraft.network.play.server.S11PacketSpawnExperienceOrb;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S13PacketDestroyEntities;
import net.minecraft.network.play.server.S14PacketEntity;
import net.minecraft.network.play.server.S18PacketEntityTeleport;
import net.minecraft.network.play.server.S19PacketEntityHeadLook;
import net.minecraft.network.play.server.S19PacketEntityStatus;
import net.minecraft.network.play.server.S1BPacketEntityAttach;
import net.minecraft.network.play.server.S1CPacketEntityMetadata;
import net.minecraft.network.play.server.S1DPacketEntityEffect;
import net.minecraft.network.play.server.S1EPacketRemoveEntityEffect;
import net.minecraft.network.play.server.S1FPacketSetExperience;
import net.minecraft.network.play.server.S20PacketEntityProperties;
import net.minecraft.network.play.server.S21PacketChunkData;
import net.minecraft.network.play.server.S22PacketMultiBlockChange;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.network.play.server.S24PacketBlockAction;
import net.minecraft.network.play.server.S25PacketBlockBreakAnim;
import net.minecraft.network.play.server.S26PacketMapChunkBulk;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.network.play.server.S28PacketEffect;
import net.minecraft.network.play.server.S29PacketSoundEffect;
import net.minecraft.network.play.server.S2APacketParticles;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.network.play.server.S2CPacketSpawnGlobalEntity;
import net.minecraft.network.play.server.S2DPacketOpenWindow;
import net.minecraft.network.play.server.S2EPacketCloseWindow;
import net.minecraft.network.play.server.S2FPacketSetSlot;
import net.minecraft.network.play.server.S30PacketWindowItems;
import net.minecraft.network.play.server.S31PacketWindowProperty;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;
import net.minecraft.network.play.server.S33PacketUpdateSign;
import net.minecraft.network.play.server.S34PacketMaps;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.network.play.server.S36PacketSignEditorOpen;
import net.minecraft.network.play.server.S37PacketStatistics;
import net.minecraft.network.play.server.S38PacketPlayerListItem;
import net.minecraft.network.play.server.S39PacketPlayerAbilities;
import net.minecraft.network.play.server.S3APacketTabComplete;
import net.minecraft.network.play.server.S3BPacketScoreboardObjective;
import net.minecraft.network.play.server.S3CPacketUpdateScore;
import net.minecraft.network.play.server.S3DPacketDisplayScoreboard;
import net.minecraft.network.play.server.S3EPacketTeams;
import net.minecraft.network.play.server.S3FPacketCustomPayload;
import net.minecraft.network.play.server.S40PacketDisconnect;

public interface INetHandlerPlayClient extends INetHandler {
  void func_147235_a(S0EPacketSpawnObject paramS0EPacketSpawnObject);
  
  void func_147286_a(S11PacketSpawnExperienceOrb paramS11PacketSpawnExperienceOrb);
  
  void func_147292_a(S2CPacketSpawnGlobalEntity paramS2CPacketSpawnGlobalEntity);
  
  void func_147281_a(S0FPacketSpawnMob paramS0FPacketSpawnMob);
  
  void func_147291_a(S3BPacketScoreboardObjective paramS3BPacketScoreboardObjective);
  
  void func_147288_a(S10PacketSpawnPainting paramS10PacketSpawnPainting);
  
  void func_147237_a(S0CPacketSpawnPlayer paramS0CPacketSpawnPlayer);
  
  void func_147279_a(S0BPacketAnimation paramS0BPacketAnimation);
  
  void func_147293_a(S37PacketStatistics paramS37PacketStatistics);
  
  void func_147294_a(S25PacketBlockBreakAnim paramS25PacketBlockBreakAnim);
  
  void func_147268_a(S36PacketSignEditorOpen paramS36PacketSignEditorOpen);
  
  void func_147273_a(S35PacketUpdateTileEntity paramS35PacketUpdateTileEntity);
  
  void func_147261_a(S24PacketBlockAction paramS24PacketBlockAction);
  
  void func_147234_a(S23PacketBlockChange paramS23PacketBlockChange);
  
  void func_147251_a(S02PacketChat paramS02PacketChat);
  
  void func_147274_a(S3APacketTabComplete paramS3APacketTabComplete);
  
  void func_147287_a(S22PacketMultiBlockChange paramS22PacketMultiBlockChange);
  
  void func_147264_a(S34PacketMaps paramS34PacketMaps);
  
  void func_147239_a(S32PacketConfirmTransaction paramS32PacketConfirmTransaction);
  
  void func_147276_a(S2EPacketCloseWindow paramS2EPacketCloseWindow);
  
  void func_147241_a(S30PacketWindowItems paramS30PacketWindowItems);
  
  void func_147265_a(S2DPacketOpenWindow paramS2DPacketOpenWindow);
  
  void func_147245_a(S31PacketWindowProperty paramS31PacketWindowProperty);
  
  void func_147266_a(S2FPacketSetSlot paramS2FPacketSetSlot);
  
  void func_147240_a(S3FPacketCustomPayload paramS3FPacketCustomPayload);
  
  void func_147253_a(S40PacketDisconnect paramS40PacketDisconnect);
  
  void func_147278_a(S0APacketUseBed paramS0APacketUseBed);
  
  void func_147236_a(S19PacketEntityStatus paramS19PacketEntityStatus);
  
  void func_147243_a(S1BPacketEntityAttach paramS1BPacketEntityAttach);
  
  void func_147283_a(S27PacketExplosion paramS27PacketExplosion);
  
  void func_147252_a(S2BPacketChangeGameState paramS2BPacketChangeGameState);
  
  void func_147272_a(S00PacketKeepAlive paramS00PacketKeepAlive);
  
  void func_147263_a(S21PacketChunkData paramS21PacketChunkData);
  
  void func_147269_a(S26PacketMapChunkBulk paramS26PacketMapChunkBulk);
  
  void func_147277_a(S28PacketEffect paramS28PacketEffect);
  
  void func_147282_a(S01PacketJoinGame paramS01PacketJoinGame);
  
  void func_147259_a(S14PacketEntity paramS14PacketEntity);
  
  void func_147258_a(S08PacketPlayerPosLook paramS08PacketPlayerPosLook);
  
  void func_147289_a(S2APacketParticles paramS2APacketParticles);
  
  void func_147270_a(S39PacketPlayerAbilities paramS39PacketPlayerAbilities);
  
  void func_147256_a(S38PacketPlayerListItem paramS38PacketPlayerListItem);
  
  void func_147238_a(S13PacketDestroyEntities paramS13PacketDestroyEntities);
  
  void func_147262_a(S1EPacketRemoveEntityEffect paramS1EPacketRemoveEntityEffect);
  
  void func_147280_a(S07PacketRespawn paramS07PacketRespawn);
  
  void func_147267_a(S19PacketEntityHeadLook paramS19PacketEntityHeadLook);
  
  void func_147257_a(S09PacketHeldItemChange paramS09PacketHeldItemChange);
  
  void func_147254_a(S3DPacketDisplayScoreboard paramS3DPacketDisplayScoreboard);
  
  void func_147284_a(S1CPacketEntityMetadata paramS1CPacketEntityMetadata);
  
  void func_147244_a(S12PacketEntityVelocity paramS12PacketEntityVelocity);
  
  void func_147242_a(S04PacketEntityEquipment paramS04PacketEntityEquipment);
  
  void func_147295_a(S1FPacketSetExperience paramS1FPacketSetExperience);
  
  void func_147249_a(S06PacketUpdateHealth paramS06PacketUpdateHealth);
  
  void func_147247_a(S3EPacketTeams paramS3EPacketTeams);
  
  void func_147250_a(S3CPacketUpdateScore paramS3CPacketUpdateScore);
  
  void func_147271_a(S05PacketSpawnPosition paramS05PacketSpawnPosition);
  
  void func_147285_a(S03PacketTimeUpdate paramS03PacketTimeUpdate);
  
  void func_147248_a(S33PacketUpdateSign paramS33PacketUpdateSign);
  
  void func_147255_a(S29PacketSoundEffect paramS29PacketSoundEffect);
  
  void func_147246_a(S0DPacketCollectItem paramS0DPacketCollectItem);
  
  void func_147275_a(S18PacketEntityTeleport paramS18PacketEntityTeleport);
  
  void func_147290_a(S20PacketEntityProperties paramS20PacketEntityProperties);
  
  void func_147260_a(S1DPacketEntityEffect paramS1DPacketEntityEffect);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\INetHandlerPlayClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */