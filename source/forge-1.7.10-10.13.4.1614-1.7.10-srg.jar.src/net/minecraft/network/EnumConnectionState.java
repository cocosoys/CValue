/*     */ package net.minecraft.network;
/*     */ import com.google.common.collect.BiMap;
/*     */ import com.google.common.collect.HashBiMap;
/*     */ import gnu.trove.map.TIntObjectMap;
/*     */ import net.minecraft.network.login.server.S01PacketEncryptionRequest;
/*     */ import net.minecraft.network.play.client.C00PacketKeepAlive;
/*     */ import net.minecraft.network.play.client.C03PacketPlayer;
/*     */ import net.minecraft.network.play.client.C09PacketHeldItemChange;
/*     */ import net.minecraft.network.play.client.C17PacketCustomPayload;
/*     */ import net.minecraft.network.play.server.S04PacketEntityEquipment;
/*     */ import net.minecraft.network.play.server.S0APacketUseBed;
/*     */ import net.minecraft.network.play.server.S14PacketEntity;
/*     */ import net.minecraft.network.play.server.S21PacketChunkData;
/*     */ import net.minecraft.network.play.server.S30PacketWindowItems;
/*     */ import net.minecraft.network.play.server.S32PacketConfirmTransaction;
/*     */ import net.minecraft.network.play.server.S36PacketSignEditorOpen;
/*     */ import net.minecraft.network.play.server.S40PacketDisconnect;
/*     */ import net.minecraft.network.status.client.C01PacketPing;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ 
/*     */ public enum EnumConnectionState {
/*  22 */   HANDSHAKING(-1) { private static final String __OBFID = "CL_00001247"; EnumConnectionState(int p_i1195_3_) {
/*  23 */       func_150751_a(0, C00Handshake.class);
/*     */     } },
/*  25 */   PLAY(0) { private static final String __OBFID = "CL_00001250"; EnumConnectionState(int p_i1194_3_) {
/*  26 */       func_150756_b(0, S00PacketKeepAlive.class);
/*  27 */       func_150756_b(1, S01PacketJoinGame.class);
/*  28 */       func_150756_b(2, S02PacketChat.class);
/*  29 */       func_150756_b(3, S03PacketTimeUpdate.class);
/*  30 */       func_150756_b(4, S04PacketEntityEquipment.class);
/*  31 */       func_150756_b(5, S05PacketSpawnPosition.class);
/*  32 */       func_150756_b(6, S06PacketUpdateHealth.class);
/*  33 */       func_150756_b(7, S07PacketRespawn.class);
/*  34 */       func_150756_b(8, S08PacketPlayerPosLook.class);
/*  35 */       func_150756_b(9, S09PacketHeldItemChange.class);
/*  36 */       func_150756_b(10, S0APacketUseBed.class);
/*  37 */       func_150756_b(11, S0BPacketAnimation.class);
/*  38 */       func_150756_b(12, S0CPacketSpawnPlayer.class);
/*  39 */       func_150756_b(13, S0DPacketCollectItem.class);
/*  40 */       func_150756_b(14, S0EPacketSpawnObject.class);
/*  41 */       func_150756_b(15, S0FPacketSpawnMob.class);
/*  42 */       func_150756_b(16, S10PacketSpawnPainting.class);
/*  43 */       func_150756_b(17, S11PacketSpawnExperienceOrb.class);
/*  44 */       func_150756_b(18, S12PacketEntityVelocity.class);
/*  45 */       func_150756_b(19, S13PacketDestroyEntities.class);
/*  46 */       func_150756_b(20, S14PacketEntity.class);
/*  47 */       func_150756_b(21, S14PacketEntity.S15PacketEntityRelMove.class);
/*  48 */       func_150756_b(22, S14PacketEntity.S16PacketEntityLook.class);
/*  49 */       func_150756_b(23, S14PacketEntity.S17PacketEntityLookMove.class);
/*  50 */       func_150756_b(24, S18PacketEntityTeleport.class);
/*  51 */       func_150756_b(25, S19PacketEntityHeadLook.class);
/*  52 */       func_150756_b(26, S19PacketEntityStatus.class);
/*  53 */       func_150756_b(27, S1BPacketEntityAttach.class);
/*  54 */       func_150756_b(28, S1CPacketEntityMetadata.class);
/*  55 */       func_150756_b(29, S1DPacketEntityEffect.class);
/*  56 */       func_150756_b(30, S1EPacketRemoveEntityEffect.class);
/*  57 */       func_150756_b(31, S1FPacketSetExperience.class);
/*  58 */       func_150756_b(32, S20PacketEntityProperties.class);
/*  59 */       func_150756_b(33, S21PacketChunkData.class);
/*  60 */       func_150756_b(34, S22PacketMultiBlockChange.class);
/*  61 */       func_150756_b(35, S23PacketBlockChange.class);
/*  62 */       func_150756_b(36, S24PacketBlockAction.class);
/*  63 */       func_150756_b(37, S25PacketBlockBreakAnim.class);
/*  64 */       func_150756_b(38, S26PacketMapChunkBulk.class);
/*  65 */       func_150756_b(39, S27PacketExplosion.class);
/*  66 */       func_150756_b(40, S28PacketEffect.class);
/*  67 */       func_150756_b(41, S29PacketSoundEffect.class);
/*  68 */       func_150756_b(42, S2APacketParticles.class);
/*  69 */       func_150756_b(43, S2BPacketChangeGameState.class);
/*  70 */       func_150756_b(44, S2CPacketSpawnGlobalEntity.class);
/*  71 */       func_150756_b(45, S2DPacketOpenWindow.class);
/*  72 */       func_150756_b(46, S2EPacketCloseWindow.class);
/*  73 */       func_150756_b(47, S2FPacketSetSlot.class);
/*  74 */       func_150756_b(48, S30PacketWindowItems.class);
/*  75 */       func_150756_b(49, S31PacketWindowProperty.class);
/*  76 */       func_150756_b(50, S32PacketConfirmTransaction.class);
/*  77 */       func_150756_b(51, S33PacketUpdateSign.class);
/*  78 */       func_150756_b(52, S34PacketMaps.class);
/*  79 */       func_150756_b(53, S35PacketUpdateTileEntity.class);
/*  80 */       func_150756_b(54, S36PacketSignEditorOpen.class);
/*  81 */       func_150756_b(55, S37PacketStatistics.class);
/*  82 */       func_150756_b(56, S38PacketPlayerListItem.class);
/*  83 */       func_150756_b(57, S39PacketPlayerAbilities.class);
/*  84 */       func_150756_b(58, S3APacketTabComplete.class);
/*  85 */       func_150756_b(59, S3BPacketScoreboardObjective.class);
/*  86 */       func_150756_b(60, S3CPacketUpdateScore.class);
/*  87 */       func_150756_b(61, S3DPacketDisplayScoreboard.class);
/*  88 */       func_150756_b(62, S3EPacketTeams.class);
/*  89 */       func_150756_b(63, S3FPacketCustomPayload.class);
/*  90 */       func_150756_b(64, S40PacketDisconnect.class);
/*     */       
/*  92 */       func_150751_a(0, C00PacketKeepAlive.class);
/*  93 */       func_150751_a(1, C01PacketChatMessage.class);
/*  94 */       func_150751_a(2, C02PacketUseEntity.class);
/*  95 */       func_150751_a(3, C03PacketPlayer.class);
/*  96 */       func_150751_a(4, C03PacketPlayer.C04PacketPlayerPosition.class);
/*  97 */       func_150751_a(5, C03PacketPlayer.C05PacketPlayerLook.class);
/*  98 */       func_150751_a(6, C03PacketPlayer.C06PacketPlayerPosLook.class);
/*  99 */       func_150751_a(7, C07PacketPlayerDigging.class);
/* 100 */       func_150751_a(8, C08PacketPlayerBlockPlacement.class);
/* 101 */       func_150751_a(9, C09PacketHeldItemChange.class);
/* 102 */       func_150751_a(10, C0APacketAnimation.class);
/* 103 */       func_150751_a(11, C0BPacketEntityAction.class);
/* 104 */       func_150751_a(12, C0CPacketInput.class);
/* 105 */       func_150751_a(13, C0DPacketCloseWindow.class);
/* 106 */       func_150751_a(14, C0EPacketClickWindow.class);
/* 107 */       func_150751_a(15, C0FPacketConfirmTransaction.class);
/* 108 */       func_150751_a(16, C10PacketCreativeInventoryAction.class);
/* 109 */       func_150751_a(17, C11PacketEnchantItem.class);
/* 110 */       func_150751_a(18, C12PacketUpdateSign.class);
/* 111 */       func_150751_a(19, C13PacketPlayerAbilities.class);
/* 112 */       func_150751_a(20, C14PacketTabComplete.class);
/* 113 */       func_150751_a(21, C15PacketClientSettings.class);
/* 114 */       func_150751_a(22, C16PacketClientStatus.class);
/* 115 */       func_150751_a(23, C17PacketCustomPayload.class);
/*     */     } },
/* 117 */   STATUS(1) { private static final String __OBFID = "CL_00001246"; EnumConnectionState(int p_i1193_3_) {
/* 118 */       func_150751_a(0, C00PacketServerQuery.class);
/* 119 */       func_150756_b(0, S00PacketServerInfo.class);
/* 120 */       func_150751_a(1, C01PacketPing.class);
/* 121 */       func_150756_b(1, S01PacketPong.class);
/*     */     } },
/* 123 */   LOGIN(2) { private static final String __OBFID = "CL_00001249"; EnumConnectionState(int p_i1192_3_) {
/* 124 */       func_150756_b(0, S00PacketDisconnect.class);
/* 125 */       func_150756_b(1, S01PacketEncryptionRequest.class);
/* 126 */       func_150756_b(2, S02PacketLoginSuccess.class);
/*     */       
/* 128 */       func_150751_a(0, C00PacketLoginStart.class);
/* 129 */       func_150751_a(1, C01PacketEncryptionResponse.class);
/*     */     } }
/*     */   ;
/* 132 */   static { field_150764_e = (TIntObjectMap)new TIntObjectHashMap();
/* 133 */     field_150761_f = Maps.newHashMap();
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
/* 193 */     for (EnumConnectionState enumConnectionState : values())
/* 194 */     { field_150764_e.put(enumConnectionState.func_150759_c(), enumConnectionState);
/*     */       
/* 196 */       for (Class<?> clazz : (Iterable<Class<?>>)Iterables.concat(enumConnectionState.func_150755_b().values(), enumConnectionState.func_150753_a().values()))
/* 197 */       { if (field_150761_f.containsKey(clazz) && field_150761_f.get(clazz) != enumConnectionState) {
/* 198 */           throw new Error("Packet " + clazz + " is already assigned to protocol " + field_150761_f.get(clazz) + " - can't reassign to " + enumConnectionState);
/*     */         }
/*     */         
/* 201 */         field_150761_f.put(clazz, enumConnectionState); }  }  }
/*     */   private final BiMap field_150769_h = (BiMap)HashBiMap.create();
/*     */   private final BiMap field_150770_i = (BiMap)HashBiMap.create();
/*     */   private static final TIntObjectMap field_150764_e;
/*     */   private static final Map field_150761_f;
/*     */   private final int field_150762_g;
/* 207 */   private static final String __OBFID = "CL_00001245"; EnumConnectionState(int p_i45152_3_) { this.field_150762_g = p_i45152_3_; } protected EnumConnectionState func_150751_a(int p_150751_1_, Class p_150751_2_) { if (this.field_150769_h.containsKey(Integer.valueOf(p_150751_1_))) { String str = "Serverbound packet ID " + p_150751_1_ + " is already assigned to " + this.field_150769_h.get(Integer.valueOf(p_150751_1_)) + "; cannot re-assign to " + p_150751_2_; LogManager.getLogger().fatal(str); throw new IllegalArgumentException(str); }  if (this.field_150769_h.containsValue(p_150751_2_)) { String str = "Serverbound packet " + p_150751_2_ + " is already assigned to ID " + this.field_150769_h.inverse().get(p_150751_2_) + "; cannot re-assign to " + p_150751_1_; LogManager.getLogger().fatal(str); throw new IllegalArgumentException(str); }  this.field_150769_h.put(Integer.valueOf(p_150751_1_), p_150751_2_); return this; } protected EnumConnectionState func_150756_b(int p_150756_1_, Class p_150756_2_) { if (this.field_150770_i.containsKey(Integer.valueOf(p_150756_1_))) { String str = "Clientbound packet ID " + p_150756_1_ + " is already assigned to " + this.field_150770_i.get(Integer.valueOf(p_150756_1_)) + "; cannot re-assign to " + p_150756_2_; LogManager.getLogger().fatal(str); throw new IllegalArgumentException(str); }  if (this.field_150770_i.containsValue(p_150756_2_)) { String str = "Clientbound packet " + p_150756_2_ + " is already assigned to ID " + this.field_150770_i.inverse().get(p_150756_2_) + "; cannot re-assign to " + p_150756_1_; LogManager.getLogger().fatal(str); throw new IllegalArgumentException(str); }  this.field_150770_i.put(Integer.valueOf(p_150756_1_), p_150756_2_); return this; } public BiMap func_150753_a() { return this.field_150769_h; } public BiMap func_150755_b() { return this.field_150770_i; } public BiMap func_150757_a(boolean p_150757_1_) { return p_150757_1_ ? func_150755_b() : func_150753_a(); } public BiMap func_150754_b(boolean p_150754_1_) { return p_150754_1_ ? func_150753_a() : func_150755_b(); } public int func_150759_c() { return this.field_150762_g; } public static EnumConnectionState func_150760_a(int p_150760_0_) { return (EnumConnectionState)field_150764_e.get(p_150760_0_); }
/*     */ 
/*     */   
/*     */   public static EnumConnectionState func_150752_a(Packet p_150752_0_) {
/* 211 */     return (EnumConnectionState)field_150761_f.get(p_150752_0_.getClass());
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\EnumConnectionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */