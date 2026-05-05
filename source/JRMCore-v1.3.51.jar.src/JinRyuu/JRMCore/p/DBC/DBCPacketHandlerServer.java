/*      */ package JinRyuu.JRMCore.p.DBC;
/*      */ 
/*      */ import JinRyuu.DragonBC.common.DBCConfig;
/*      */ import JinRyuu.DragonBC.common.DBCH;
/*      */ import JinRyuu.DragonBC.common.Entitys.EntityEnergyFM;
/*      */ import JinRyuu.DragonBC.common.Entitys.EntityInstantTransmission;
/*      */ import JinRyuu.DragonBC.common.Entitys.EntityMajinAbsorption;
/*      */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*      */ import JinRyuu.DragonBC.common.Npcs.EntityDBCKami;
/*      */ import JinRyuu.DragonBC.common.Render.ArtGravDevTileEntity;
/*      */ import JinRyuu.DragonBC.common.Worlds.WorldTeleporterDBCSpacePod01;
/*      */ import JinRyuu.DragonBC.common.Worlds.WorldTeleporterDBCTelep;
/*      */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*      */ import JinRyuu.JRMCore.JRMCoreConfig;
/*      */ import JinRyuu.JRMCore.JRMCoreH;
/*      */ import JinRyuu.JRMCore.JRMCoreHDBC;
/*      */ import JinRyuu.JRMCore.entity.EntityEnergyAtt;
/*      */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*      */ import JinRyuu.JRMCore.p.PD;
/*      */ import JinRyuu.JRMCore.server.JGPlayerMP;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCFormMastery;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCGoD;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCInstantTransmission;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigRaces;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
/*      */ import cpw.mods.fml.common.FMLCommonHandler;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.player.EntityPlayerMP;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTBase;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.nbt.NBTTagList;
/*      */ import net.minecraft.server.MinecraftServer;
/*      */ import net.minecraft.tileentity.TileEntity;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.ChatComponentText;
/*      */ import net.minecraft.util.ChatComponentTranslation;
/*      */ import net.minecraft.util.ChatStyle;
/*      */ import net.minecraft.util.EnumChatFormatting;
/*      */ import net.minecraft.util.IChatComponent;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.world.Teleporter;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class DBCPacketHandlerServer
/*      */ {
/*      */   public static final int SHENL = 0;
/*      */   public static final int PORUN = 1;
/*      */   public static final int DRAGON_WISH = 0;
/*      */   public static final int MASTER_ENMA_REVIVE = 1;
/*      */   public static final int GIVE_WEIGHT_ITEM = 2;
/*      */   public static final int PLAYER_DEAD_LIST = 3;
/*      */   public static final int CHANGE_GRAVITY_FOR_GRAV_DEVICE = 4;
/*      */   public static final int ASKING_FOR_MAJIN_STATUS_EFFECT = 5;
/*   64 */   public static final ChatStyle styleYellow = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW); public static final int WHIS_TELEPORT = 6; public static final int TOP_ARENA_RINGOUT = 7; public static final int KAIOKEN = 26; public static final int SCOUTER_EXPLOSION = -2; public static final int GRAVITY_TP_GAIN = -3; public static final int TIME_CHAMBER_KICK_TOO_LONG = -6; public static final int PLANET_NAMEK = 1; public static final int PLANET_VEGETA = 2; public static final int PLANET_EARTH = 3;
/*   65 */   public static final ChatStyle styleGold = (new ChatStyle()).func_150238_a(EnumChatFormatting.GOLD);
/*   66 */   public static final ChatStyle styleRed = (new ChatStyle()).func_150238_a(EnumChatFormatting.RED);
/*      */   
/*   68 */   public static byte WAVE_FIRING = 10; public static byte WAVE_STOP = 11; public static byte INSTANT_TRANSMISSION = 12; public static byte INSTANT_TRANSMISSION_GROUP = 13; public static byte MAJIN_ABSORPTION = 14; public double explosionX; public double explosionY; public double explosionZ; public float explosionSize;
/*      */   public List chunkPositionRecords;
/*      */   
/*      */   public void handleDBCenergy(byte b, byte p, EntityPlayer pl) {
/*   72 */     if (b == WAVE_FIRING) {
/*      */       
/*   74 */       JRMCoreH.setByte(1, pl, "jrmcFrng");
/*      */     }
/*   76 */     else if (b == WAVE_STOP) {
/*      */       
/*   78 */       JRMCoreH.setByte(0, pl, "jrmcFrng");
/*      */     }
/*   80 */     else if (b == INSTANT_TRANSMISSION || b == INSTANT_TRANSMISSION_GROUP) {
/*      */       
/*   82 */       boolean isShortRange = (b == INSTANT_TRANSMISSION);
/*   83 */       int modeID = isShortRange ? 0 : 1;
/*   84 */       boolean isEnabled = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_ENABLED[modeID];
/*      */       
/*   86 */       if (isEnabled && pl != null && pl.field_70154_o == null && pl.field_70153_n == null) {
/*   87 */         JGPlayerMP jgPlayer = new JGPlayerMP(pl);
/*   88 */         NBTTagCompound nbt = nbt(pl, "pres");
/*   89 */         jgPlayer.setNBT(nbt);
/*   90 */         byte currentRelease = jgPlayer.getRelease();
/*   91 */         byte mode = p;
/*      */         
/*   93 */         if (currentRelease > 0) {
/*   94 */           byte skillLevel = (byte)JRMCoreH.SklLvl(17, pl);
/*   95 */           byte requiredLevel = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_UNLOCK_SKILL_LEVEL[modeID];
/*      */           
/*   97 */           if (skillLevel > 0) {
/*   98 */             if (skillLevel >= requiredLevel) {
/*   99 */               byte kiSenseLevelRequirement = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_KI_SENSE_REQUIREMENT[modeID];
/*  100 */               byte kiSenseSkillLevel = (byte)JRMCoreH.SklLvl(6, pl);
/*  101 */               if (kiSenseLevelRequirement > kiSenseSkillLevel) {
/*  102 */                 String message = "Instant Transmission Failed! " + JGConfigDBCInstantTransmission.TP_MODES[modeID] + " Requires Ki Sense Level " + kiSenseLevelRequirement + " to be used!";
/*      */                 
/*  104 */                 pl.func_145747_a((new ChatComponentText(message)).func_150255_a(styleRed));
/*      */                 
/*      */                 return;
/*      */               } 
/*  108 */               int surroundMode = JRMCoreH.PlyrSettings(pl, 15);
/*  109 */               if (!JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_ENABLED_SURROUND[surroundMode + 1]) {
/*  110 */                 String message = "Instant Transmission Failed! Surround Teleportation Mode " + JGConfigDBCInstantTransmission.SURROUND_MODES[surroundMode + 1] + " is Disabled!";
/*      */                 
/*  112 */                 pl.func_145747_a((new ChatComponentText(message)).func_150255_a(styleRed));
/*      */                 
/*      */                 return;
/*      */               } 
/*  116 */               if (nbt.func_74764_b("jrmcInstantTransmissionTimers")) {
/*  117 */                 String instantTransmissionTimers = nbt.func_74779_i("jrmcInstantTransmissionTimers");
/*  118 */                 String[] values = instantTransmissionTimers.split(";");
/*  119 */                 int cd = Integer.parseInt(values[modeID]);
/*  120 */                 if (cd > 0) {
/*  121 */                   String message = "Instant Transmission Failed! " + JGConfigDBCInstantTransmission.TP_MODES[modeID] + " teleportation is in Cooldown! " + (cd * 5) + "s Remaining!";
/*      */                   
/*  123 */                   pl.func_145747_a((new ChatComponentText(message)).func_150255_a(styleRed));
/*      */                   
/*      */                   return;
/*      */                 } 
/*      */               } 
/*      */               
/*  129 */               if (isShortRange) {
/*      */                 
/*  131 */                 int shortTPMode = JRMCoreH.PlyrSettings(pl, 14);
/*  132 */                 if (!JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_ENABLED_SHORT[shortTPMode + 1]) {
/*  133 */                   String message = "Instant Transmission Failed! Short Teleportation Mode " + JGConfigDBCInstantTransmission.SHORT_MODES[shortTPMode + 1] + " is Disabled!";
/*      */                   
/*  135 */                   pl.func_145747_a((new ChatComponentText(message)).func_150255_a(styleRed));
/*      */                   
/*      */                   return;
/*      */                 } 
/*  139 */                 EntityInstantTransmission entityInstantTransmission = new EntityInstantTransmission((EntityLivingBase)pl);
/*  140 */                 entityInstantTransmission.setData(mode, skillLevel, shortTPMode, surroundMode);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*  146 */                 pl.field_70170_p.func_72838_d((Entity)entityInstantTransmission);
/*      */               }
/*      */               else {
/*      */                 
/*  150 */                 MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/*  151 */                 int groupID = JRMCoreH.getInt(pl, "JRMCGID");
/*      */                 
/*  153 */                 for (int playerID = 0; playerID < (server.func_71213_z()).length; playerID++) {
/*      */                   
/*  155 */                   int selectedMember = p;
/*  156 */                   if (playerID == selectedMember) {
/*      */                     
/*  158 */                     EntityPlayerMP targetEntity = JRMCoreH.getPlayerForUsername(server, server.func_71213_z()[playerID]);
/*  159 */                     int egid = JRMCoreH.getInt((EntityPlayer)targetEntity, "JRMCGID");
/*      */                     
/*  161 */                     if (JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_RELEASE_SENSE_REQUIRED_ENABLED[modeID]) {
/*      */                       
/*  163 */                       JGPlayerMP targetMP = new JGPlayerMP(targetEntity);
/*  164 */                       NBTTagCompound nbt2 = nbt((EntityPlayer)targetEntity, "pres");
/*  165 */                       targetMP.setNBT(nbt2);
/*  166 */                       byte targetRelease = targetMP.getRelease();
/*  167 */                       boolean targetCanBeSensed = (targetRelease > 0);
/*      */                       
/*  169 */                       if (!targetCanBeSensed) {
/*  170 */                         String message = "Instant Transmission Failed! Target can not be sensed at 0% Release Level.";
/*  171 */                         pl.func_145747_a((new ChatComponentText(message)).func_150255_a(styleRed));
/*      */                         
/*      */                         return;
/*      */                       } 
/*      */                     } 
/*  176 */                     if (egid == groupID && targetEntity != null && !targetEntity.equals(pl)) {
/*      */                       
/*  178 */                       boolean isOneInOtherworld = ((pl.field_71093_bK == DBCConfig.otherWorld && targetEntity.field_71093_bK != DBCConfig.otherWorld) || (pl.field_71093_bK != DBCConfig.otherWorld && targetEntity.field_71093_bK == DBCConfig.otherWorld));
/*      */                       
/*  180 */                       if (isOneInOtherworld) {
/*      */                         
/*  182 */                         String message = "Instant Transmission Failed! You can't " + ((pl.field_71093_bK == DBCConfig.otherWorld && targetEntity.field_71093_bK != DBCConfig.otherWorld) ? "Leave" : "Enter") + " the Otherworld!";
/*      */                         
/*  184 */                         pl.func_145747_a((new ChatComponentText(message)).func_150255_a(styleRed));
/*      */                         
/*      */                         return;
/*      */                       } 
/*  188 */                       boolean isFused = JRMCoreH.isFused((Entity)pl);
/*      */                       
/*  190 */                       if (pl.field_71093_bK != targetEntity.field_71093_bK) {
/*      */                         
/*  192 */                         if (!JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_TP_ENABLED || JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_DIMENSION_BLACKLIST
/*  193 */                           .containsKey(Integer.valueOf(targetEntity.field_71093_bK))) {
/*      */                           String message;
/*  195 */                           if (JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_TP_ENABLED) {
/*  196 */                             message = "Instant Transmission Failed! Dimensional Teleportation is Disabled!";
/*      */                           } else {
/*      */                             
/*  199 */                             message = "Instant Transmission Failed! Target Dimension for Teleportation is Blacklisted!";
/*      */                           } 
/*      */                           
/*  202 */                           pl.func_145747_a((new ChatComponentText(message)).func_150255_a(styleRed));
/*      */                           
/*      */                           return;
/*      */                         } 
/*  206 */                         if (isFused) {
/*  207 */                           String message = "Unable to dimensional teleport while fused.";
/*  208 */                           pl.func_145747_a((new ChatComponentText(message)).func_150255_a(styleRed));
/*      */                           
/*      */                           return;
/*      */                         } 
/*      */                       } 
/*  213 */                       ArrayList<EntityPlayer> teleportedEntities = new ArrayList<EntityPlayer>();
/*  214 */                       teleportedEntities.add(pl);
/*      */                       
/*  216 */                       if (surroundMode != -1) {
/*  217 */                         int surroundPlayerLimit = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SURROUND_PLAYER_LIMIT_SKILL_LEVEL[modeID][skillLevel - 1];
/*      */                         
/*  219 */                         double r2 = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SURROUND_TARGET_FINDER_RANGE;
/*  220 */                         double r2Y = 1.0D;
/*  221 */                         AxisAlignedBB aabb2 = AxisAlignedBB.func_72330_a(pl.field_70165_t - r2, pl.field_70163_u - 1.0D, pl.field_70161_v - r2, pl.field_70165_t + r2, pl.field_70163_u + 1.0D, pl.field_70161_v + r2);
/*  222 */                         List<Entity> entityList2 = pl.field_70170_p.func_72839_b((Entity)pl, aabb2);
/*      */                         
/*  224 */                         for (int k = 0; k < entityList2.size(); k++) {
/*  225 */                           Entity nearbyEntity = entityList2.get(k);
/*  226 */                           if (nearbyEntity != null && nearbyEntity instanceof EntityPlayer && !((EntityPlayer)nearbyEntity).equals(targetEntity) && !((EntityPlayer)nearbyEntity).equals(pl) && nearbyEntity.func_70089_S()) {
/*      */                             
/*  228 */                             if (surroundPlayerLimit != -1 && teleportedEntities.size() - 1 > surroundPlayerLimit)
/*      */                               break; 
/*  230 */                             boolean groupOnly = (surroundMode == 0);
/*  231 */                             if (groupOnly) {
/*  232 */                               int egid2 = JRMCoreH.getInt((EntityPlayer)nearbyEntity, "JRMCGID");
/*  233 */                               if (egid2 == groupID && groupID != 0)
/*      */                               {
/*  235 */                                 teleportedEntities.add((EntityPlayer)nearbyEntity);
/*      */                               }
/*      */                             } else {
/*      */                               
/*  239 */                               teleportedEntities.add((EntityPlayer)nearbyEntity);
/*      */                             } 
/*      */                           } 
/*      */                         } 
/*      */                       } 
/*      */                       
/*  245 */                       String ste = jgPlayer.getStatusEffects();
/*  246 */                       boolean divine = JRMCoreH.StusEfcts(17, ste);
/*      */ 
/*      */                       
/*  249 */                       boolean creativeMode = JRMCoreH.isInCreativeMode((Entity)pl);
/*      */ 
/*      */                       
/*  252 */                       if (!creativeMode) {
/*  253 */                         int[] playerAttributes = jgPlayer.getAttributes();
/*  254 */                         byte race = jgPlayer.getRace();
/*  255 */                         byte classID = jgPlayer.getClassID();
/*  256 */                         byte powerType = jgPlayer.getPowerType();
/*      */                         
/*  258 */                         int curEnergy = jgPlayer.getEnergy();
/*  259 */                         int maxEnergy = jgPlayer.getEnergyMax(race, classID, powerType, playerAttributes, JRMCoreH.SklLvl_KiBs(pl, powerType));
/*      */                         
/*  261 */                         double FLAT_COST = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_COST[modeID][0][skillLevel - 1];
/*  262 */                         double PERCENTAGE_COST = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_COST[modeID][1][skillLevel - 1];
/*      */                         
/*  264 */                         double costMulti = PERCENTAGE_COST / 100.0D;
/*  265 */                         double energyCost = maxEnergy * costMulti + FLAT_COST;
/*      */ 
/*      */                         
/*  268 */                         if (pl.field_71093_bK != targetEntity.field_71093_bK) {
/*  269 */                           double DIMENSIONAL_FLAT_COST = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_COST[0][skillLevel - 1];
/*  270 */                           double DIMENSIONAL_PERCENTAGE_COST = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_DIMENSIONAL_COST[1][skillLevel - 1];
/*      */                           
/*  272 */                           double costMultiDim = DIMENSIONAL_PERCENTAGE_COST / 100.0D;
/*  273 */                           double energyCostDim = maxEnergy * costMultiDim + DIMENSIONAL_FLAT_COST;
/*      */                           
/*  275 */                           energyCost += energyCostDim;
/*      */                         } 
/*      */ 
/*      */                         
/*  279 */                         if (teleportedEntities.size() > 1) {
/*      */                           
/*  281 */                           double costPerPlayerFlat = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER[0][skillLevel - 1];
/*  282 */                           double costPerPlayerPerc = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_SURROUND_COST_PER_PLAYER[1][skillLevel - 1];
/*  283 */                           double costMultiPerPlayer = costPerPlayerPerc / 100.0D;
/*  284 */                           double energyCostDim = maxEnergy * costMultiPerPlayer + costPerPlayerFlat;
/*      */                           
/*  286 */                           energyCost += energyCostDim * (teleportedEntities.size() - 1);
/*      */                         } 
/*      */                         
/*  289 */                         if (curEnergy < energyCost) {
/*  290 */                           String message = "Instant Transmission Failed! Not Enough Ki: " + (int)energyCost;
/*  291 */                           pl.func_145747_a((new ChatComponentText(message)).func_150255_a(styleRed));
/*      */                           
/*      */                           return;
/*      */                         } 
/*      */                         
/*  296 */                         int remainingEnergy = curEnergy - (int)energyCost;
/*  297 */                         JRMCoreH.setInt(remainingEnergy, pl, "jrmcEnrgy");
/*      */                       } 
/*      */                       
/*  300 */                       pl.field_70170_p.func_72956_a((Entity)pl, divine ? "jinryuudragonbc:DBC4.blacktp" : "jinryuudragonbc:DBC5.instant_transmission", 0.25F, pl.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*      */ 
/*      */ 
/*      */                       
/*  304 */                       double x = targetEntity.field_70165_t;
/*  305 */                       double y = targetEntity.field_70163_u;
/*  306 */                       double z = targetEntity.field_70161_v;
/*      */                       
/*  308 */                       JRMCoreH.playerUsedInstantTransmission(pl);
/*      */                       
/*  310 */                       for (int i = teleportedEntities.size() - 1; i >= 0; i--) {
/*  311 */                         EntityPlayer entity = teleportedEntities.get(i);
/*  312 */                         double x2 = entity.field_70165_t - pl.field_70165_t;
/*      */                         
/*  314 */                         double z2 = entity.field_70161_v - pl.field_70161_v;
/*      */                         
/*  316 */                         boolean dimensional = (((EntityPlayerMP)entity).field_71093_bK != targetEntity.field_71093_bK);
/*  317 */                         boolean nether = (((EntityPlayerMP)entity).field_71093_bK == -1 && dimensional);
/*  318 */                         boolean theEnd = (((EntityPlayerMP)entity).field_71093_bK == 1 && dimensional);
/*  319 */                         boolean netherTarget = (targetEntity.field_71093_bK == -1 && dimensional);
/*  320 */                         boolean theEndTarget = (targetEntity.field_71093_bK == 1 && dimensional);
/*  321 */                         boolean overworldTarget = (targetEntity.field_71093_bK == 0 && dimensional);
/*      */ 
/*      */ 
/*      */                         
/*  325 */                         double x3 = x + x2;
/*  326 */                         double y3 = y + 1.0D;
/*  327 */                         double z3 = z + z2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                         
/*  336 */                         if (((EntityPlayerMP)entity).field_71093_bK != targetEntity.field_71093_bK) {
/*  337 */                           if (netherTarget || theEndTarget || theEnd) {
/*  338 */                             ((EntityPlayerMP)pl).field_71133_b.func_71203_ab().func_72356_a((EntityPlayerMP)pl, targetEntity.field_71093_bK);
/*      */                           }
/*      */                           
/*  341 */                           if (!theEndTarget) {
/*  342 */                             FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().transferPlayerToDimension((EntityPlayerMP)entity, targetEntity.field_71093_bK, (Teleporter)new WorldTeleporterDBCTelep(
/*      */                                   
/*  344 */                                   FMLCommonHandler.instance().getMinecraftServerInstance().func_71218_a(targetEntity.field_71093_bK)));
/*      */                           }
/*      */                         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                         
/*  409 */                         ((EntityPlayerMP)entity).field_71135_a.func_147364_a(x3, y3, z3, entity.field_70177_z, entity.field_70125_A);
/*  410 */                         ((EntityPlayerMP)entity).func_70634_a(x3, y3, z3);
/*      */                         
/*  412 */                         entity.func_71023_q(1);
/*      */                       } 
/*      */                       
/*  415 */                       if (isFused) {
/*  416 */                         String fusionMembers = jgPlayer.getNBT().func_74779_i("jrmcFuzion");
/*  417 */                         if (fusionMembers.length() > 0 && !fusionMembers.equals(" ")) {
/*      */                           
/*  419 */                           String[] fusionParticipants = fusionMembers.split(",");
/*  420 */                           if (fusionParticipants.length == 3) {
/*      */                             
/*  422 */                             boolean isController = fusionParticipants[0].equalsIgnoreCase(pl.func_70005_c_());
/*  423 */                             if (isController) {
/*  424 */                               EntityPlayer fusedPlayerPartner = pl.field_70170_p.func_72924_a(fusionParticipants[1]);
/*  425 */                               if (fusedPlayerPartner != null) {
/*  426 */                                 NBTTagCompound nbt2 = nbt(fusedPlayerPartner, "pres");
/*  427 */                                 String fusionMembers2 = nbt2.func_74779_i("jrmcFuzion");
/*  428 */                                 String[] fusionParticipants2 = fusionMembers2.split(",");
/*      */                                 
/*  430 */                                 if (fusionParticipants2.length == 3) {
/*      */                                   
/*  432 */                                   ((EntityPlayerMP)fusedPlayerPartner).field_71135_a.func_147364_a(x, y + 1.5D, z, fusedPlayerPartner.field_70177_z, fusedPlayerPartner.field_70125_A);
/*  433 */                                   ((EntityPlayerMP)fusedPlayerPartner).func_70634_a(x, y + 1.5D, z);
/*  434 */                                   fusedPlayerPartner.func_71023_q(1);
/*      */                                 } 
/*      */                               } 
/*      */                             } 
/*      */                           } 
/*      */                         } 
/*      */                       } 
/*      */                       
/*  442 */                       JRMCoreH.playerUsedInstantTransmission(pl);
/*      */ 
/*      */                       
/*  445 */                       if (JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_NOTIFY_SERVER_ENABLED) {
/*  446 */                         mod_DragonBC.logger.info(pl.func_70005_c_() + " used Long Distance Teleportation to " + targetEntity
/*  447 */                             .func_70005_c_() + " with " + (teleportedEntities.size() - 1) + " Surrounding Players to the DimensionID: " + targetEntity.field_71093_bK);
/*      */                       }
/*      */ 
/*      */ 
/*      */ 
/*      */                       
/*  453 */                       if (nbt.func_74764_b("jrmcInstantTransmissionTimers")) {
/*  454 */                         String instantTransmissionTimers = nbt.func_74779_i("jrmcInstantTransmissionTimers");
/*  455 */                         String[] values = instantTransmissionTimers.split(";");
/*  456 */                         int tpShort = Integer.parseInt(values[0]);
/*  457 */                         int tpLong = JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_COOLDOWN[1][skillLevel - 1];
/*  458 */                         JRMCoreH.setString(tpShort + ";" + tpLong, pl, "jrmcInstantTransmissionTimers");
/*      */                       } else {
/*      */                         
/*  461 */                         String instantTransmissionTimers = "0;" + JGConfigDBCInstantTransmission.CONFIG_INSTANT_TRANSMISSION_COOLDOWN[1][skillLevel - 1];
/*  462 */                         JRMCoreH.setString(instantTransmissionTimers, pl, "jrmcInstantTransmissionTimers");
/*      */                       } 
/*      */                       
/*  465 */                       pl.field_70170_p.func_72956_a((Entity)pl, divine ? "jinryuudragonbc:DBC4.blacktp" : "jinryuudragonbc:DBC5.instant_transmission", 0.25F, pl.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*      */                       
/*      */                       return;
/*      */                     } 
/*      */                     
/*  470 */                     selectedMember++;
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */             } else {
/*      */               
/*  476 */               String message = "Instant Transmission Failed! " + JGConfigDBCInstantTransmission.TP_MODES[modeID] + " Requires Instant Transmission Skill Level " + requiredLevel + " to be used!";
/*      */               
/*  478 */               pl.func_145747_a((new ChatComponentText(message)).func_150255_a(styleRed));
/*      */               
/*      */               return;
/*      */             } 
/*      */           }
/*      */         } 
/*  484 */       } else if (!isEnabled) {
/*      */         
/*  486 */         String message = (isShortRange ? "Short" : "Long") + " Distance Instant Transmission Failed! It is Disabled on this Server!";
/*  487 */         pl.func_145747_a((new ChatComponentText(message)).func_150255_a(styleRed));
/*      */         
/*      */         return;
/*      */       } 
/*  491 */     } else if (b == MAJIN_ABSORPTION) {
/*  492 */       if (JGConfigRaces.CONFIG_MAJIN_ENABLED && JGConfigRaces.CONFIG_MAJIN_ABSORPTION_ENABLED) {
/*  493 */         JGPlayerMP jgPlayer = new JGPlayerMP(pl);
/*  494 */         NBTTagCompound nbt = nbt(pl, "pres");
/*  495 */         jgPlayer.setNBT(nbt);
/*  496 */         byte race = jgPlayer.getRace();
/*  497 */         float release = jgPlayer.getRelease() / 100.0F;
/*      */         
/*  499 */         if (JRMCoreH.isRaceMajin(race) && jgPlayer.getTransformationMeter() >= 100 && release > 0.0F) {
/*  500 */           boolean isCreative = JRMCoreH.isInCreativeMode((Entity)pl);
/*      */           
/*  502 */           int remainingLife = 0;
/*  503 */           int lifeCost = 0;
/*  504 */           int cooldown = 0;
/*      */           
/*  506 */           int state = jgPlayer.getState();
/*  507 */           String statusEffects = jgPlayer.getStatusEffects();
/*  508 */           boolean isMysticOn = JRMCoreH.StusEfcts(13, statusEffects);
/*  509 */           boolean isUltraInstinctOn = JRMCoreH.StusEfcts(19, statusEffects);
/*  510 */           boolean isGoDOn = JRMCoreH.StusEfcts(20, statusEffects);
/*  511 */           int stateID = JRMCoreH.getMajinFormID(state, isMysticOn, isUltraInstinctOn, isGoDOn);
/*      */           
/*  513 */           boolean canUse = true;
/*  514 */           boolean isOnCooldown = false;
/*      */           
/*  516 */           if (!isCreative) {
/*  517 */             cooldown = jgPlayer.getNBT().func_74762_e("jrmcMajinAbsorptionTimer");
/*  518 */             isOnCooldown = (cooldown > 0);
/*      */             
/*  520 */             if (isOnCooldown) {
/*  521 */               canUse = false;
/*      */             } else {
/*      */               
/*  524 */               byte classID = jgPlayer.getClassID();
/*  525 */               byte powerType = jgPlayer.getPowerType();
/*  526 */               int[] playerAttributes = jgPlayer.getAttributes();
/*      */               
/*  528 */               int curBody = jgPlayer.getHealth();
/*  529 */               int maxBody = jgPlayer.getHealthMax(race, classID, powerType, playerAttributes);
/*      */               
/*  531 */               lifeCost = (int)(maxBody * JGConfigRaces.CONFIG_MAJIN_ABSORPTON_HEALTH_COST[stateID][1] + JGConfigRaces.CONFIG_MAJIN_ABSORPTON_HEALTH_COST[stateID][0]);
/*      */ 
/*      */               
/*  534 */               boolean hasEnoughHealth = isCreative ? true : ((curBody > lifeCost));
/*      */               
/*  536 */               remainingLife = curBody - lifeCost;
/*  537 */               canUse = hasEnoughHealth;
/*      */             } 
/*      */           } 
/*      */           
/*  541 */           if (canUse) {
/*  542 */             if (!isCreative) {
/*  543 */               JRMCoreH.setInt(remainingLife, pl, "jrmcBdy");
/*  544 */               cooldown = JGConfigRaces.CONFIG_MAJIN_ABSORPTON_CD_TIMER[stateID];
/*  545 */               jgPlayer.getNBT().func_74768_a("jrmcMajinAbsorptionTimer", cooldown);
/*      */             } 
/*  547 */             String dns = nbt.func_74779_i("jrmcDNS");
/*      */             
/*  549 */             float userPower = 0.0F;
/*      */             
/*  551 */             float attackUser = 0.0F;
/*  552 */             float healthUser = 0.0F;
/*  553 */             float kiPowerUser = 0.0F;
/*      */             
/*  555 */             int strength = jgPlayer.getAttribute(0);
/*  556 */             attackUser = JRMCoreH.stat(0, pl, 0, strength, 0.0F);
/*  557 */             attackUser = (int)(attackUser * release);
/*  558 */             healthUser = jgPlayer.getHealth();
/*  559 */             kiPowerUser = jgPlayer.getEnergyPower();
/*  560 */             kiPowerUser = (int)(kiPowerUser * release);
/*      */             
/*  562 */             attackUser = (int)(attackUser * JGConfigRaces.CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[stateID][0]);
/*  563 */             healthUser = (int)(healthUser * JGConfigRaces.CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[stateID][1]);
/*  564 */             kiPowerUser = (int)(kiPowerUser * JGConfigRaces.CONFIG_MAJIN_ABSORPTON_USER_POWER_MULTI[stateID][2]);
/*      */             
/*  566 */             if (attackUser < 1.0F) attackUser = 1.0F;  if (healthUser < 1.0F) healthUser = 1.0F;  if (kiPowerUser < 1.0F) kiPowerUser = 1.0F; 
/*  567 */             userPower = attackUser + kiPowerUser + healthUser;
/*      */ 
/*      */             
/*  570 */             EntityMajinAbsorption entityMajinAbsorption = new EntityMajinAbsorption((EntityLivingBase)pl, 0, (state == 1) ? 12561588 : ((state == 3) ? 16757199 : JRMCoreH.dnsBodyCM(dns)), userPower, attackUser + kiPowerUser, stateID);
/*      */ 
/*      */             
/*  573 */             pl.field_70170_p.func_72838_d((Entity)entityMajinAbsorption);
/*      */           } else {
/*      */             
/*  576 */             String text = "";
/*  577 */             if (isOnCooldown) { text = "Unable to use Absorption! Cooldown: " + (cooldown * 5) + "s"; }
/*  578 */             else { text = "Unable to use Absorption! Health Cost: " + lifeCost; }
/*  579 */              pl.func_145747_a((new ChatComponentText(text)).func_150255_a(styleRed));
/*      */           } 
/*      */           
/*  582 */           jgPlayer.setTransformationMeter(0);
/*      */         }
/*      */       
/*      */       } 
/*      */     } else {
/*      */       
/*  588 */       String s2 = JRMCoreH.getString(pl, JRMCoreH.techNbt[b]);
/*  589 */       boolean isAKiAttack = (b >= 0 && b <= 7);
/*      */       
/*  591 */       if (isAKiAttack) {
/*      */         
/*  593 */         byte curRel = JRMCoreH.getByte(pl, "jrmcRelease");
/*      */         
/*  595 */         if (curRel > 0) {
/*      */           
/*  597 */           int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(pl);
/*      */           
/*  599 */           String[] PlyrSkills = JRMCoreH.getString(pl, "jrmcSSlts").split(",");
/*      */           
/*  601 */           byte pwr = JRMCoreH.getByte(pl, "jrmcPwrtyp");
/*  602 */           byte rc = JRMCoreH.getByte(pl, "jrmcRace");
/*  603 */           byte cls = JRMCoreH.getByte(pl, "jrmcClass");
/*  604 */           int curEn = JRMCoreH.getInt(pl, "jrmcEnrgy");
/*  605 */           int curBo = JRMCoreH.getInt(pl, "jrmcBdy");
/*  606 */           byte align = JRMCoreH.getByte(pl, "jrmcAlign");
/*  607 */           byte state = JRMCoreH.getByte(pl, "jrmcState");
/*  608 */           byte state2 = JRMCoreH.getByte(pl, "jrmcState2");
/*  609 */           String sklx = JRMCoreH.getString(pl, "jrmcSSltX");
/*  610 */           int resrv = JRMCoreH.getInt(pl, "jrmcArcRsrv");
/*  611 */           String absorption = JRMCoreH.getString(pl, "jrmcMajinAbsorptionData");
/*  612 */           byte trans = (byte)(state + 1);
/*  613 */           String ste = JRMCoreH.getString(pl, "jrmcStatusEff");
/*  614 */           boolean mj = JRMCoreH.StusEfcts(12, ste);
/*  615 */           boolean lg = JRMCoreH.StusEfcts(14, ste);
/*  616 */           boolean kk = JRMCoreH.StusEfcts(5, ste);
/*  617 */           boolean mc = JRMCoreH.StusEfcts(13, ste);
/*  618 */           boolean mn = JRMCoreH.StusEfcts(19, ste);
/*  619 */           boolean gd = JRMCoreH.StusEfcts(20, ste);
/*  620 */           boolean v = (JRMCoreH.StusEfcts(10, ste) || JRMCoreH.StusEfcts(11, ste));
/*      */           
/*  622 */           byte release = JRMCoreH.getByte(pl, "jrmcRelease");
/*      */ 
/*      */           
/*  625 */           int WIL = JRMCoreH.getPlayerAttribute(pl, PlyrAttrbts, 3, state, state2, rc, sklx, curRel, resrv, lg, mj, kk, mc, mn, gd, pwr, PlyrSkills, v, absorption);
/*  626 */           int WIL2 = JRMCoreH.getPlayerAttribute(pl, PlyrAttrbts, 3, 0, 0, rc, sklx, curRel, resrv, lg, mj, false, false, false, false, pwr, PlyrSkills, v, absorption);
/*  627 */           int stat = JRMCoreH.stat((Entity)pl, 3, pwr, 4, WIL, rc, cls, 0.0F);
/*  628 */           int stat2 = JRMCoreH.stat((Entity)pl, 3, pwr, 4, WIL2, rc, cls, 0.0F);
/*      */           
/*  630 */           Entity var8 = null;
/*      */           
/*  632 */           boolean isCustomAttack = (b >= 0 && b < 4 && s2 != null && s2.length() > 0);
/*  633 */           boolean isFixedAttack = (b >= 4 && b < 8 && s2 != null && s2.length() > 0);
/*      */           
/*  635 */           float RELEASE_MULTI = 0.01F;
/*      */ 
/*      */           
/*  638 */           if (isCustomAttack) {
/*      */             
/*  640 */             String[] tech = s2.toString().split(";");
/*      */             
/*  642 */             if (tech != null && tech.length > 9)
/*      */             {
/*  644 */               byte type = Byte.parseByte(tech[3]);
/*  645 */               byte speed = Byte.parseByte(tech[4]);
/*  646 */               short dam = Short.parseShort(tech[5]);
/*  647 */               byte effect = Byte.parseByte(tech[6]);
/*  648 */               byte color = Byte.parseByte(tech[10]);
/*  649 */               byte density = Byte.parseByte(tech[11]);
/*  650 */               byte sincantation = 0;
/*  651 */               byte sfire = 0;
/*  652 */               byte smove = 0;
/*  653 */               if (tech.length > 12) {
/*      */                 
/*  655 */                 sincantation = Byte.parseByte(tech[12]);
/*  656 */                 sfire = Byte.parseByte(tech[13]);
/*  657 */                 smove = Byte.parseByte(tech[14]);
/*      */               } 
/*  659 */               int exp = 0;
/*  660 */               int lvl = 0;
/*  661 */               int upg = 0;
/*  662 */               byte[] sts = { 0, 0, 0, 0, 0, 0, 0 };
/*  663 */               if (tech.length > 16) {
/*      */                 
/*  665 */                 exp = Integer.parseInt(tech[16]);
/*  666 */                 lvl = Integer.parseInt(tech[17]);
/*  667 */                 upg = Integer.parseInt(tech[18]);
/*  668 */                 sts = JRMCoreH.tech_statmods(tech[19]);
/*      */               } 
/*  670 */               int dam1 = JRMCoreH.techDBCdmg(tech, stat, sts);
/*  671 */               int cost1 = JRMCoreH.techDBCkic(tech, stat2, sts);
/*  672 */               int cost2 = (int)(cost1 * curRel * 0.009999999776482582D * (p * 0.02F) * JRMCoreConfig.dat5696[type][2]);
/*  673 */               dam1 = (dam1 < 1) ? 1 : dam1;
/*  674 */               cost2 = (cost2 < 2) ? 2 : cost2;
/*  675 */               int costBo = (cost2 > curEn) ? (curBo - cost2 - curEn) : 0;
/*      */               
/*  677 */               boolean canAffordKiCost = (cost2 <= curEn);
/*  678 */               boolean lifeAboveZero = (costBo > 0);
/*      */               
/*  680 */               if (JRMCoreConfig.dat5695[type] && (canAffordKiCost || lifeAboveZero))
/*      */               {
/*  682 */                 if (!JRMCoreH.isInCreativeMode((Entity)pl)) {
/*      */                   
/*  684 */                   int energy = (curEn - cost2 < 0) ? 0 : (curEn - cost2);
/*  685 */                   JRMCoreH.setInt(energy, pl, "jrmcEnrgy");
/*  686 */                   if (energy == 0) JRMCoreH.setByte(0, pl, "jrmcRelease");
/*      */                   
/*  688 */                   if (costBo > 0) JRMCoreH.setInt(costBo, pl, "jrmcBdy"); 
/*      */                 } 
/*  690 */                 pl.field_70170_p.func_72956_a((Entity)pl, "jinryuudragonbc:" + JRMCoreH.techSnds(type, 1, sfire), (type == 6) ? 0.2F : 1.0F, 1.0F);
/*  691 */                 NBTTagCompound nbt = JRMCoreH.nbt((Entity)pl, "pres");
/*  692 */                 String StE = nbt.func_74779_i("jrmcStatusEff");
/*  693 */                 boolean setGoDOn = JRMCoreH.StusEfcts(20, StE);
/*      */                 
/*  695 */                 EntityEnergyAtt entityEnergyAtt = new EntityEnergyAtt((EntityLivingBase)pl, type, speed, dam, effect, color, density, sincantation, sfire, smove, p, dam1, cost1, sts, b, release, align);
/*      */                 
/*  697 */                 if (setGoDOn && JGConfigDBCGoD.CONFIG_GOD_ENERGY_ENABLED && JGConfigDBCGoD.CONFIG_GOD_ENABLED) {
/*  698 */                   entityEnergyAtt.destroyer = setGoDOn;
/*      */                 }
/*      */                 
/*  701 */                 if (JGConfigDBCFormMastery.FM_Enabled && release > 0) {
/*  702 */                   JRMCoreH.addToFormMasteriesValue(pl, JGConfigDBCFormMastery.FM_GainKiFire, JGConfigDBCFormMastery.FM_GainKiFire, rc, state, state2, kk, mc, mn, gd, 3);
/*      */                 }
/*      */ 
/*      */                 
/*  706 */                 pl.field_70170_p.func_72838_d((Entity)entityEnergyAtt);
/*  707 */                 JRMCoreH.a1t3(pl);
/*      */               }
/*      */             
/*      */             }
/*      */           
/*  712 */           } else if (isFixedAttack) {
/*      */ 
/*      */             
/*  715 */             int tn = Integer.parseInt(s2);
/*  716 */             String[] tech = JRMCoreH.pmdbc[tn];
/*      */             
/*  718 */             if (tech[0].equals("KAFakeMoon")) {
/*      */               
/*  720 */               int kicost = Integer.parseInt(tech[7]);
/*  721 */               if (curEn >= kicost) {
/*  722 */                 if (!JRMCoreH.isInCreativeMode((Entity)pl)) {
/*      */                   
/*  724 */                   int energy = (curEn - kicost < 0) ? 0 : (curEn - kicost);
/*  725 */                   JRMCoreH.setInt(energy, pl, "jrmcEnrgy");
/*  726 */                   if (energy == 0) JRMCoreH.setByte(0, pl, "jrmcRelease"); 
/*      */                 } 
/*  728 */                 EntityEnergyFM entityEnergyFM = new EntityEnergyFM((EntityLivingBase)pl);
/*  729 */                 pl.field_70170_p.func_72838_d((Entity)entityEnergyFM);
/*      */               }
/*      */             
/*  732 */             } else if (tech != null && tech.length > 9) {
/*      */               
/*  734 */               byte type = Byte.parseByte(tech[3]);
/*  735 */               byte speed = Byte.parseByte(tech[4]);
/*  736 */               short dam = Short.parseShort(tech[5]);
/*  737 */               byte cast = Byte.parseByte(tech[8]);
/*  738 */               byte effect = Byte.parseByte(tech[6]);
/*  739 */               byte color = Byte.parseByte(tech[10]);
/*  740 */               byte density = Byte.parseByte(tech[11]);
/*  741 */               byte sincantation = Byte.parseByte(tech[12]);
/*  742 */               byte sfire = Byte.parseByte(tech[13]);
/*  743 */               byte smove = Byte.parseByte(tech[14]);
/*  744 */               if (tech.length > 12) {
/*  745 */                 sincantation = Byte.parseByte(tech[12]);
/*  746 */                 sfire = Byte.parseByte(tech[13]);
/*  747 */                 smove = Byte.parseByte(tech[14]);
/*      */               } 
/*  749 */               int exp = 0;
/*  750 */               int lvl = 0;
/*  751 */               int upg = 0;
/*  752 */               byte[] sts = { 0, 0, 0, 0, 0, 0, 0 };
/*  753 */               if (tech.length > 16) {
/*  754 */                 exp = Integer.parseInt(tech[16]);
/*  755 */                 lvl = Integer.parseInt(tech[17]);
/*  756 */                 upg = Integer.parseInt(tech[18]);
/*  757 */                 sts = JRMCoreH.tech_statmods(tech[19]);
/*      */               } 
/*      */               
/*  760 */               int dam1 = JRMCoreH.techDBCdmg(tech, stat, sts);
/*  761 */               int cost1 = JRMCoreH.techDBCkic(tech, stat2, sts);
/*      */               
/*  763 */               int dam2 = (int)(dam1 * curRel * 0.009999999776482582D);
/*  764 */               int cost2 = (int)(cost1 * curRel * 0.009999999776482582D * (p * 0.02F) * JRMCoreConfig.dat5696[type][2]);
/*  765 */               dam1 = (dam1 < 1) ? 1 : dam1;
/*  766 */               dam2 = (dam2 < 1) ? 1 : dam2;
/*  767 */               cost2 = (cost2 < 2) ? 2 : cost2;
/*      */               
/*  769 */               int costBo = (cost2 > curEn) ? (curBo - cost2 - curEn) : 0;
/*      */               
/*  771 */               boolean canAffordKiCost = (cost2 <= curEn);
/*  772 */               boolean lifeAboveZero = (costBo > 0);
/*      */               
/*  774 */               if (JRMCoreConfig.dat5695[type] && (canAffordKiCost || lifeAboveZero)) {
/*      */                 
/*  776 */                 if (sfire > 0) {
/*      */                   
/*  778 */                   pl.field_70170_p.func_72956_a((Entity)pl, "jinryuudragonbc:" + JRMCoreH.techSnds(10, 1, (short)(sfire - 1)), 1.0F, 1.0F);
/*  779 */                   if (cast > 0)
/*      */                   {
/*  781 */                     pl.field_70170_p.func_72956_a((Entity)pl, "jinryuudragonbc:" + JRMCoreH.techSnds(10, 3, (short)(cast - 1)), 1.0F, 1.0F);
/*      */                   }
/*      */                 } 
/*  784 */                 if (sincantation > 0)
/*      */                 {
/*  786 */                   pl.field_70170_p.func_72956_a((Entity)pl, "jinryuudragonbc:" + JRMCoreH.techSnds(10, 3, (short)(sincantation - 1)), 1.0F, 1.0F);
/*      */                 }
/*  788 */                 if (!JRMCoreH.isInCreativeMode((Entity)pl)) {
/*      */                   
/*  790 */                   int energy = (curEn - cost2 < 0) ? 0 : (curEn - cost2);
/*  791 */                   JRMCoreH.setInt(energy, pl, "jrmcEnrgy");
/*  792 */                   if (energy == 0) JRMCoreH.setByte(0, pl, "jrmcRelease");
/*      */                   
/*  794 */                   if (costBo > 0) JRMCoreH.setInt(costBo, pl, "jrmcBdy");
/*      */                 
/*      */                 } 
/*  797 */                 EntityEnergyAtt entityEnergyAtt = new EntityEnergyAtt((EntityLivingBase)pl, type, speed, dam2, effect, color, density, sincantation, sfire, smove, p, dam1, cost1, sts, b, release, align);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*  804 */                 if (JGConfigDBCFormMastery.FM_Enabled && release > 0) {
/*  805 */                   JRMCoreH.addToFormMasteriesValue(pl, JGConfigDBCFormMastery.FM_GainKiFire, JGConfigDBCFormMastery.FM_GainKiFire, rc, state, state2, kk, mc, mn, gd, 3);
/*      */                 }
/*      */ 
/*      */                 
/*  809 */                 pl.field_70170_p.func_72838_d((Entity)entityEnergyAtt);
/*  810 */                 JRMCoreH.a1t3(pl);
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   public float playerVelocityX; public float playerVelocityY; public float playerVelocityZ; public boolean expGriOff; public double expDam;
/*      */   public Entity origin;
/*      */   
/*      */   public void handleDBCdri(int dri, EntityPlayer p) {
/*  822 */     NBTTagCompound tag = nbt(p, "");
/*      */     
/*  824 */     if (dri == 5 || dri == 6)
/*      */     {
/*  826 */       tag.func_74768_a("DBCdriS", dri);
/*      */     }
/*      */     
/*  829 */     if (dri == 1 || dri == 2)
/*      */     {
/*  831 */       tag.func_74768_a("DBCdriF", dri);
/*      */     }
/*      */     
/*  834 */     if (dri == 3 || dri == 4)
/*      */     {
/*  836 */       tag.func_74768_a("DBCdriY", dri);
/*      */     }
/*      */     
/*  839 */     if (dri >= 100) {
/*      */       
/*  841 */       ChatStyle styl = (new ChatStyle()).func_150238_a(EnumChatFormatting.WHITE);
/*  842 */       if (JRMCoreConfig.DebugInfo) {
/*      */         
/*  844 */         String info = "DBC has found Potential hacking at ID:06 by player: %";
/*  845 */         mod_DragonBC.logger.info(String.format(info, new Object[] { p.func_70005_c_() }));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void send(EntityPlayerMP Player) {
/*  853 */     Player.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.trl("jrmc", "notenoughtp")));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleDBCwish(int id, String s, EntityPlayer p) {
/*  878 */     MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/*  879 */     if (id == 0) {
/*      */       
/*  881 */       String[] sa = s.split(";");
/*  882 */       int wish = Integer.parseInt(sa[0]);
/*  883 */       EntityPlayer target = null;
/*  884 */       if (sa.length > 1) {
/*  885 */         for (int i = 0; i < server.field_71305_c.length; i++) {
/*  886 */           int d = (server.field_71305_c[i]).field_73011_w.field_76574_g;
/*  887 */           if (d == DBCConfig.otherWorld) {
/*  888 */             target = server.field_71305_c[i].func_72924_a(sa[1]);
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*  894 */       if (wish < 100)
/*      */       {
/*  896 */         int wsh = JRMCoreH.getInt(p, "jrmcWishes");
/*  897 */         int dragon = JRMCoreH.getInt(p, "jrmcDrgn");
/*      */         
/*  899 */         ArrayList<String> wl = (dragon == 0) ? DBCH.wishS : DBCH.wishP;
/*  900 */         if (wsh > 0) {
/*      */           
/*  902 */           p.field_70170_p.func_72908_a(p.field_70165_t, p.field_70163_u, p.field_70161_v, "jinryuudragonbc:dragon.grant", 1.0F, 1.0F);
/*  903 */           if (((String)wl.get(wish)).contains(";+;")) {
/*  904 */             String[] ia = ((String)wl.get(wish)).replace(";+;", ";+").split(";+");
/*  905 */             String in = ia[0];
/*  906 */             int iz = Integer.parseInt(ia[1]);
/*  907 */             int im = Integer.parseInt(ia[2]);
/*  908 */             Item item = JRMCoreH.getItemByText(in);
/*  909 */             if (item != null) {
/*  910 */               ItemStack is = new ItemStack(item, iz, im);
/*  911 */               p.field_71071_by.func_70441_a(is);
/*  912 */               p.field_71071_by.field_70459_e = true;
/*  913 */               closeInventoryChange(p);
/*      */             
/*      */             }
/*      */           
/*      */           }
/*  918 */           else if (((String)wl.get(wish)).equals("revive") && target != null) {
/*  919 */             int alive = JRMCoreH.getByte(target, "jrmcAlv");
/*  920 */             if (alive == 1 && target != null && p.field_71093_bK != DBCConfig.otherWorld && target.field_71093_bK == DBCConfig.otherWorld) {
/*  921 */               JRMCoreH.setInt(0, target, "jrmcReviveTmer");
/*  922 */               String t = JRMCoreH.trlai("dbc", "canrevivenow");
/*  923 */               ChatStyle styl = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/*  924 */               target.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(styl));
/*      */             }
/*      */           
/*  927 */           } else if (((String)wl.get(wish)).equals("reviventp") && target != null) {
/*  928 */             int alive = JRMCoreH.getByte(target, "jrmcAlv");
/*  929 */             if (alive == 1 && target != null && p.field_71093_bK != DBCConfig.otherWorld && target.field_71093_bK == DBCConfig.otherWorld) {
/*  930 */               JRMCoreH.setString(p.func_70005_c_() + ";" + p.field_71093_bK + ";" + (int)p.field_70165_t + ";" + (int)p.field_70163_u + ";" + (int)p.field_70161_v, target, "jrmcRevtpInit");
/*  931 */               String t = JRMCoreH.trlai("dbc", "reviveoffered");
/*  932 */               ChatStyle styl = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/*  933 */               target.func_145747_a((new ChatComponentTranslation(t, new Object[] { p.func_70005_c_(), new ChatComponentTranslation(JRMCoreH.trlai("dbc", (String)DBCH.plntNms.get(Integer.valueOf(p.field_71093_bK))), new Object[0]), (int)p.field_70165_t + ", " + (int)p.field_70163_u + ", " + (int)p.field_70161_v })).func_150255_a(styl));
/*      */             }
/*      */           
/*  936 */           } else if (((String)wl.get(wish)).equals("reviveall")) {
/*  937 */             if (p.field_71093_bK != DBCConfig.otherWorld) {
/*  938 */               int al = JRMCoreH.Algnmnt(JRMCoreH.getByte(p, "jrmcAlign"));
/*  939 */               for (int i = 0; i < server.field_71305_c.length; i++) {
/*  940 */                 int d = (server.field_71305_c[i]).field_73011_w.field_76574_g;
/*  941 */                 if (d == DBCConfig.otherWorld) {
/*  942 */                   for (Iterator<EntityPlayer> iterator = (server.field_71305_c[i]).field_73010_i.iterator(); iterator.hasNext(); ) {
/*  943 */                     target = iterator.next();
/*  944 */                     int alive = JRMCoreH.getByte(target, "jrmcAlv");
/*  945 */                     if (alive == 1 && target != null && target.field_71093_bK == DBCConfig.otherWorld) {
/*  946 */                       int tal = JRMCoreH.Algnmnt(JRMCoreH.getByte(target, "jrmcAlign"));
/*  947 */                       if (al == tal) {
/*  948 */                         JRMCoreH.setInt(0, target, "jrmcReviveTmer");
/*  949 */                         String t = JRMCoreH.trlai("dbc", "canrevivenow");
/*  950 */                         ChatStyle styl = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/*  951 */                         target.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(styl));
/*      */                       }
/*      */                     
/*      */                     } 
/*      */                   } 
/*      */                 }
/*      */               } 
/*      */             } 
/*  959 */           } else if (((String)wl.get(wish)).equals("young")) {
/*  960 */             JRMCoreH.setFloat(90, p, "JRYCAge");
/*      */           }
/*  962 */           else if (((String)wl.get(wish)).equals("child")) {
/*  963 */             JRMCoreH.setFloat(25, p, "JRYCAge");
/*      */           }
/*  965 */           else if (((String)wl.get(wish)).equals("old")) {
/*  966 */             JRMCoreH.setFloat(300, p, "JRYCAge");
/*      */           }
/*  968 */           else if (((String)wl.get(wish)).equals("kicolor")) {
/*  969 */             JRMCoreH.setInt(Integer.parseInt(sa[1]), p, "jrmcAuraColor");
/*      */           }
/*  971 */           else if (((String)wl.get(wish)).equals("arcultformcolor")) {
/*  972 */             String d = JRMCoreH.getString(p, "jrmcDNSAU");
/*  973 */             if (d.contains(";")) {
/*  974 */               JRMCoreH.setString(d.substring(1), p, "jrmcDNSAU");
/*      */             }
/*      */           } 
/*      */         } 
/*  978 */         JRMCoreH.setInt(--wsh, p, "jrmcWishes");
/*      */       }
/*      */     
/*      */     }
/*  982 */     else if (id == 1) {
/*      */       
/*  984 */       int wish = Integer.parseInt(s);
/*  985 */       if (wish == 100 && 
/*  986 */         p.field_71093_bK == DBCConfig.otherWorld && 
/*  987 */         p != null && p.field_70154_o == null && p.field_70153_n == null) {
/*  988 */         int RevTmr = JRMCoreH.getInt(p, "jrmcReviveTmer");
/*  989 */         if (RevTmr <= 0) {
/*      */           
/*  991 */           if (JRMCoreHDBC.DBCgetConfigDeadInv() && p.field_70170_p.func_82736_K().func_82766_b("keepInventory") && !p.field_71075_bZ.field_75098_d && 
/*  992 */             JRMCoreHDBC.hasHalo(p)) {
/*  993 */             JRMCoreH.nbt(p).func_74782_a("InventoryDead", (NBTBase)p.field_71071_by.func_70442_a(new NBTTagList()));
/*      */             
/*  995 */             p.field_71071_by.func_70443_b(JRMCoreH.nbt(p).func_150295_c("InventoryLiving", 10));
/*  996 */             p.getEntityData().func_74782_a("Inventory", (NBTBase)p.field_71071_by.func_70442_a(new NBTTagList()));
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1010 */           byte by = (byte)JRMCoreH.Algnmnt(JRMCoreH.getByte(p, "jrmcAlign"));
/*      */           
/* 1012 */           JRMCoreH.setByte(0, p, "jrmcAlv");
/* 1013 */           FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().transferPlayerToDimension((EntityPlayerMP)p, DBCConfig.RevDim[by], (Teleporter)new WorldTeleporterDBCTelep(FMLCommonHandler.instance().getMinecraftServerInstance().func_71218_a(DBCConfig.planetEarth)));
/*      */ 
/*      */           
/* 1016 */           p.func_71023_q(1);
/*      */           
/* 1018 */           double[] d = { 50.0D, 220.0D, 50.0D };
/* 1019 */           switch (by) { case 0:
/* 1020 */               d = DBCConfig.RevLocG; break;
/* 1021 */             case 1: d = DBCConfig.RevLocN; break;
/* 1022 */             case 2: d = DBCConfig.RevLocE; break; }
/*      */           
/* 1024 */           ((EntityPlayerMP)p).field_71135_a.func_147364_a(d[0], d[1], d[2], (float)DBCConfig.RevAng[by][0], (float)DBCConfig.RevAng[by][1]);
/* 1025 */           ((EntityPlayerMP)p).field_71135_a.func_147364_a(d[0], d[1] + 1.0D, d[2], (float)DBCConfig.RevAng[by][0], (float)DBCConfig.RevAng[by][1]);
/*      */ 
/*      */           
/* 1028 */           mod_DragonBC.logger.info(p.func_70005_c_() + " revived!");
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1033 */       if (wish == 102);
/*      */ 
/*      */       
/* 1036 */       if (wish == 101) {
/* 1037 */         JRMCoreHDBC.reincarnate(p);
/*      */         
/* 1039 */         mod_DragonBC.logger.info(p.func_70005_c_() + " choose to Reincarnate!");
/*      */       } 
/* 1041 */       if (wish == 199 && 
/* 1042 */         nbt(p, "pres").func_74762_e("DBCSenzu") == 0) {
/* 1043 */         nbt(p, "pres").func_74768_a("DBCSenzu", 1);
/* 1044 */         p.field_71071_by.func_70441_a(new ItemStack(ItemsDBC.ItemSenzu, DBCConfig.senzuFromKarin));
/* 1045 */         p.field_71071_by.field_70459_e = true;
/* 1046 */         closeInventoryChange(p);
/*      */       } 
/* 1048 */       if (wish == 202) {
/* 1049 */         p.field_71071_by.func_70441_a(new ItemStack(ItemsDBC.KintounItem, 1));
/* 1050 */         p.field_71071_by.field_70459_e = true;
/* 1051 */         closeInventoryChange(p);
/*      */       } 
/* 1053 */       if (wish == 203) {
/* 1054 */         p.field_71071_by.func_70441_a(new ItemStack(ItemsDBC.KintounBlackItem, 1));
/* 1055 */         p.field_71071_by.field_70459_e = true;
/* 1056 */         closeInventoryChange(p);
/*      */       }
/*      */     
/* 1059 */     } else if (id == 2) {
/*      */       
/* 1061 */       String[] s2 = s.split(";");
/* 1062 */       int i = Integer.parseInt(s2[0]);
/* 1063 */       float a = Float.parseFloat(s2[1]);
/* 1064 */       ItemStack stack = new ItemStack((i == 0) ? ItemsDBC.ItemWeightHandLeg : ((i == 1) ? ItemsDBC.ItemWeightShell : ((i == 2) ? ItemsDBC.ItemWeightShirt : ((i == 3) ? ItemsDBC.ItemWeightCape : ItemsDBC.ItemWeightHeavySuit))), 1, 1);
/* 1065 */       if (stack != null) {
/* 1066 */         JRMCoreH.addItemWeightStats(stack, new Object[] { Float.valueOf(a) });
/* 1067 */         stack.func_77964_b(0);
/* 1068 */         p.field_71071_by.func_70441_a(stack);
/* 1069 */         p.field_71071_by.field_70459_e = true;
/* 1070 */         closeInventoryChange(p);
/*      */       }
/*      */     
/* 1073 */     } else if (id == 3) {
/*      */       
/* 1075 */       String list = ";";
/* 1076 */       for (int i = 0; i < server.field_71305_c.length; i++) {
/* 1077 */         int d = (server.field_71305_c[i]).field_73011_w.field_76574_g;
/* 1078 */         if (d == DBCConfig.otherWorld) {
/* 1079 */           for (Iterator<EntityPlayer> iterator = (server.field_71305_c[i]).field_73010_i.iterator(); iterator.hasNext(); ) {
/* 1080 */             EntityPlayer target = iterator.next();
/* 1081 */             if (target != null && target.field_71093_bK == DBCConfig.otherWorld) {
/* 1082 */               int alive = JRMCoreH.getByte(target, "jrmcAlv");
/* 1083 */               if (alive == 1) {
/* 1084 */                 list = list + ";" + target.func_70005_c_();
/*      */               }
/*      */             } 
/*      */           } 
/*      */         }
/* 1089 */         PD.sendTo(new DBCPwish(id, list), (EntityPlayerMP)p);
/*      */       }
/*      */     
/* 1092 */     } else if (id == 4) {
/*      */       
/* 1094 */       String[] s2 = s.split(";");
/* 1095 */       int x = Integer.parseInt(s2[0]);
/* 1096 */       int y = Integer.parseInt(s2[1]);
/* 1097 */       int z = Integer.parseInt(s2[2]);
/* 1098 */       TileEntity te = p.field_70170_p.func_147438_o(x, y, z);
/* 1099 */       float g = Float.parseFloat(s2[3]);
/* 1100 */       if (te instanceof ArtGravDevTileEntity) {
/* 1101 */         ((ArtGravDevTileEntity)te).setGravity(g);
/* 1102 */         p.field_70170_p.func_147471_g(x, y, z);
/* 1103 */         te.func_70296_d();
/*      */       }
/*      */     
/* 1106 */     } else if (id == 5) {
/*      */ 
/*      */       
/* 1109 */       JRMCoreH.StusEfcts(12, p, s.equals("1"));
/*      */     }
/* 1111 */     else if (id == 6) {
/*      */       
/* 1113 */       if (DBCConfig.CanWhisTeleport)
/*      */       {
/* 1115 */         if (p != null && p.field_70154_o == null && p.field_70153_n == null)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1144 */           if (!JRMCoreH.isFused((Entity)p))
/*      */           {
/* 1146 */             boolean earth = (p.field_71093_bK == DBCConfig.dimNullRealm);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1153 */             p.func_71023_q(1);
/*      */             
/* 1155 */             double[] d = earth ? DBCConfig.WhisTeleportLocationBack : DBCConfig.WhisTeleportLocationNull;
/*      */             
/* 1157 */             FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().transferPlayerToDimension((EntityPlayerMP)p, earth ? DBCConfig.planetEarth : DBCConfig.dimNullRealm, (Teleporter)new WorldTeleporterDBCTelep(
/*      */                   
/* 1159 */                   FMLCommonHandler.instance().getMinecraftServerInstance().func_71218_a(DBCConfig.planetEarth)));
/*      */             
/* 1161 */             ((EntityPlayerMP)p).field_71135_a.func_147364_a(d[0], d[1], d[2], 0.0F, 0.0F);
/* 1162 */             ((EntityPlayerMP)p).field_71135_a.func_147364_a(d[0], d[1] + 1.0D, d[2], 0.0F, 0.0F);
/*      */             
/* 1164 */             mod_DragonBC.logger.info(p.func_70005_c_() + " was Teleported by Master Whis!");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/*      */           else
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1182 */             p.func_145747_a((new ChatComponentText("Unable to teleport while fused")).func_150255_a(styleRed));
/*      */           }
/*      */         
/*      */         }
/*      */       }
/* 1187 */     } else if (id == 7) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1216 */       double[] d = DBCConfig.WhisTeleportLocationNull;
/* 1217 */       ((EntityPlayerMP)p).field_71135_a.func_147364_a(d[0], d[1], d[2], 0.0F, 0.0F);
/* 1218 */       ((EntityPlayerMP)p).field_71135_a.func_147364_a(d[0], d[1] + 1.0D, d[2], 0.0F, 0.0F);
/* 1219 */       mod_DragonBC.logger.info(p.func_70005_c_() + " has fallen down in the Null Realm!");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleDBCtick(int dbctick, EntityPlayer Player) {
/* 1237 */     if (dbctick != 0 && 
/* 1238 */       dbctick != 26 && (
/* 1239 */       dbctick < 10 || dbctick > 25)) {
/* 1240 */       if (dbctick == -2) {
/*      */         
/* 1242 */         if ((ExtendedPlayer.get(Player)).inventory.func_70301_a(2) != null)
/*      */         {
/*      */           
/* 1245 */           (ExtendedPlayer.get(Player)).inventory.func_70299_a(2, null);
/* 1246 */           soundPowerUp(Player, "jinryuudragonbc:scouter.expl");
/*      */         }
/*      */       
/* 1249 */       } else if (dbctick == -3) {
/*      */         
/* 1251 */         short GTrnng = JRMCoreH.getShort(Player, "jrmcGTrnng");
/*      */         
/* 1253 */         int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(Player);
/* 1254 */         byte pwr = JRMCoreH.getByte(Player, "jrmcPwrtyp");
/* 1255 */         byte rc = JRMCoreH.getByte(Player, "jrmcRace");
/* 1256 */         byte cls = JRMCoreH.getByte(Player, "jrmcClass");
/* 1257 */         int maxBody = JRMCoreH.stat((Entity)Player, 2, pwr, 2, PlyrAttrbts[2], rc, cls, 0.0F);
/* 1258 */         int curBody = JRMCoreH.getInt(Player, "jrmcBdy");
/* 1259 */         int maxEnergy = JRMCoreH.stat((Entity)Player, 5, pwr, 5, PlyrAttrbts[5], rc, cls, JRMCoreH.SklLvl_KiBs(Player, pwr));
/* 1260 */         int curEnergy = JRMCoreH.getInt(Player, "jrmcEnrgy");
/*      */ 
/*      */ 
/*      */         
/* 1264 */         if (GTrnng < DBCConfig.maxTrnExp && curBody > maxBody / 2 && curEnergy > maxEnergy / 2)
/*      */         {
/* 1266 */           int all = curBody - 50;
/* 1267 */           int alle = curEnergy - 50;
/* 1268 */           if (all < 0)
/* 1269 */           { Player.func_70606_j(Player.func_110143_aJ() / 2.0F);
/* 1270 */             JRMCoreH.setInt(0, Player, "jrmcBdy"); }
/* 1271 */           else { JRMCoreH.setInt(all, Player, "jrmcBdy"); }
/* 1272 */            if (alle < 0) { alle = 0; JRMCoreH.setByte(0, Player, "jrmcRelease"); }
/* 1273 */            if (!JRMCoreH.isInCreativeMode((Entity)Player)) JRMCoreH.setInt(alle, Player, "jrmcEnrgy"); 
/* 1274 */           JRMCoreH.setShort(GTrnng + 1, Player, "jrmcGTrnng");
/* 1275 */           JRMCoreH.expPls(Player, 1);
/*      */         }
/*      */       
/*      */       }
/* 1279 */       else if (dbctick == -6) {
/*      */         
/* 1281 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().transferPlayerToDimension((EntityPlayerMP)Player, DBCConfig.planetEarth, (Teleporter)new WorldTeleporterDBCTelep(FMLCommonHandler.instance().getMinecraftServerInstance().func_71218_a(DBCConfig.planetEarth)));
/*      */         
/* 1283 */         ((EntityPlayerMP)Player).field_71135_a.func_147364_a(77.5D, 217.0D, 10.5D, 0.0F, 0.0F);
/* 1284 */         Player.func_71023_q(1);
/* 1285 */         JRMCoreH.setShort(2400, Player, "jrmcHTCTmO");
/* 1286 */         String t = "dbc.timechamber.mustwaitaday";
/* 1287 */         ChatStyle styl = (new ChatStyle()).func_150238_a(EnumChatFormatting.YELLOW);
/* 1288 */         Player.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(styl));
/*      */       }
/* 1290 */       else if (dbctick == -100) {
/*      */         
/* 1292 */         int dbcnum = nbt(Player, "pres").func_74762_e("DBCSenzu");
/* 1293 */         PD.sendTo(new DBCPspacepod1(dbcnum), (EntityPlayerMP)Player);
/*      */       }
/* 1295 */       else if (dbctick == -101) {
/*      */         
/* 1297 */         int dbcnum = nbt(Player, "pres").func_74762_e("jrmcMaster");
/* 1298 */         if (dbcnum == 0) nbt(Player, "pres").func_74768_a("jrmcMaster", 1);
/*      */         
/* 1300 */         PD.sendTo(new DBCPtick(dbcnum + 2), (EntityPlayerMP)Player);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public void handleDBCspacepod1(int planetID, EntityPlayer p) {
/* 1306 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/* 1307 */     if (side == Side.SERVER) {
/*      */       
/* 1309 */       Entity entity = null;
/*      */       
/* 1311 */       if (planetID == 1) {
/*      */         
/* 1313 */         if (p.field_70154_o != null) {
/*      */           
/* 1315 */           entity = p.field_70154_o;
/* 1316 */           entity.func_70106_y();
/*      */         } 
/* 1318 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().transferPlayerToDimension((EntityPlayerMP)p, DBCConfig.planetNamek, (Teleporter)new WorldTeleporterDBCSpacePod01(
/* 1319 */               FMLCommonHandler.instance().getMinecraftServerInstance().func_71218_a(DBCConfig.planetNamek), entity));
/* 1320 */         p.func_71023_q(1);
/*      */       } 
/* 1322 */       if (planetID == 2) {
/*      */         
/* 1324 */         if (p.field_70154_o != null) {
/*      */           
/* 1326 */           entity = p.field_70154_o;
/* 1327 */           entity.func_70106_y();
/*      */         } 
/* 1329 */         int plnt = DBCConfig.planetVegeta;
/* 1330 */         if (!DBCConfig.plntVegeta) plnt = DBCConfig.planetEarth; 
/* 1331 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().transferPlayerToDimension((EntityPlayerMP)p, plnt, (Teleporter)new WorldTeleporterDBCSpacePod01(
/* 1332 */               FMLCommonHandler.instance().getMinecraftServerInstance().func_71218_a(plnt), entity));
/* 1333 */         p.func_71023_q(1);
/*      */       } 
/* 1335 */       if (planetID == 3) {
/*      */         
/* 1337 */         if (p.field_70154_o != null) {
/*      */           
/* 1339 */           entity = p.field_70154_o;
/* 1340 */           entity.func_70106_y();
/*      */         } 
/* 1342 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().transferPlayerToDimension((EntityPlayerMP)p, DBCConfig.planetEarth, (Teleporter)new WorldTeleporterDBCSpacePod01(
/* 1343 */               FMLCommonHandler.instance().getMinecraftServerInstance().func_71218_a(DBCConfig.planetEarth), entity));
/* 1344 */         p.func_71023_q(1);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleDBCchargepart(byte dbcchargepart, String dbcCharger, EntityPlayer p) {
/* 1351 */     PD.sendToDimension(new DBCPchargepart(dbcchargepart, dbcCharger), p.field_71093_bK);
/*      */   }
/*      */ 
/*      */   
/*      */   public void ki(NBTTagCompound tag, int e) {
/* 1356 */     if (e == 2) tag.func_74768_a("DBCKiCharge", tag.func_74762_e("DBCKiCharge") * e); 
/* 1357 */     if (e == 3) tag.func_74768_a("DBCKiCharge", tag.func_74762_e("DBCKiCharge") + tag.func_74762_e("DBCKiCharge") / (e - 1)); 
/* 1358 */     if (e == 4) tag.func_74768_a("DBCKiCharge", tag.func_74762_e("DBCKiCharge") + tag.func_74762_e("DBCKiCharge") / (e - 1)); 
/* 1359 */     if (e == -4) tag.func_74768_a("DBCKiCharge", tag.func_74762_e("DBCKiCharge") / 4); 
/* 1360 */     if (e == -3) tag.func_74768_a("DBCKiCharge", tag.func_74762_e("DBCKiCharge") / 3); 
/* 1361 */     if (e == -2) tag.func_74768_a("DBCKiCharge", tag.func_74762_e("DBCKiCharge") / 2); 
/*      */   }
/*      */   
/*      */   private boolean hasInstantTransformUnlocked(EntityPlayer p, boolean isRacial, int formID, int race) {
/* 1365 */     double hasUnlocked = 0.0D;
/* 1366 */     if (JGConfigDBCFormMastery.FM_Enabled) {
/* 1367 */       double unlockLevel = JGConfigDBCFormMastery.getDouble(race, formID + (isRacial ? 0 : (JRMCoreH.trans[race]).length), JGConfigDBCFormMastery.DATA_ID_INSTANT_TRANSFORM_UNLOCK);
/*      */       
/* 1369 */       String message = "";
/*      */       
/* 1371 */       if (unlockLevel <= -1.0D) {
/* 1372 */         hasUnlocked = -1.0D;
/* 1373 */         message = "Instant Transformation is not available for this Form!";
/*      */       }
/* 1375 */       else if (unlockLevel > 0.0D) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1382 */         double masteryLevel = JRMCoreH.getFormMasteryValue(p, formID + (isRacial ? 0 : (JRMCoreH.trans[race]).length));
/* 1383 */         if (masteryLevel < unlockLevel) {
/* 1384 */           hasUnlocked = unlockLevel;
/* 1385 */           String formName = isRacial ? JRMCoreH.trans[race][formID] : JRMCoreH.transNonRacial[formID];
/* 1386 */           message = "Failed to Instant Transform! Required " + formName + " Mastery Level: " + hasUnlocked + " to be unlocked!";
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1391 */       if (hasUnlocked != 0.0D) {
/* 1392 */         p.func_145747_a((new ChatComponentText(message)).func_150255_a(styleRed));
/* 1393 */         return false;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1398 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleDBCascend(byte dbcascend, EntityPlayer p) {
/* 1404 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/*      */     
/* 1406 */     if (side == Side.SERVER) {
/*      */       
/* 1408 */       JGPlayerMP jgPlayer = new JGPlayerMP(p);
/* 1409 */       NBTTagCompound nbt = nbt(p, "pres");
/* 1410 */       jgPlayer.setNBT(nbt);
/*      */       
/* 1412 */       boolean quickTransform = (dbcascend == -1);
/* 1413 */       int transformationMeter = quickTransform ? 100 : jgPlayer.getTransformationMeter();
/*      */       
/* 1415 */       String StE = jgPlayer.getStatusEffects();
/* 1416 */       boolean statusKaiokenOn = JRMCoreH.StusEfcts(13, StE);
/* 1417 */       boolean statusMysticOn = JRMCoreH.StusEfcts(13, StE);
/* 1418 */       boolean statusUltraInstinctOn = JRMCoreH.StusEfcts(19, StE);
/* 1419 */       boolean statusGodOfDestructionOn = JRMCoreH.StusEfcts(20, StE);
/*      */       
/* 1421 */       int kaiokenSkillLevel = JRMCoreH.SklLvl(8, p);
/* 1422 */       boolean isKaiokenAvailable = (JRMCoreH.PlyrSettingsB(nbt, 0) && kaiokenSkillLevel > 0 && (DBCConfig.MysticKaiokenOn || !statusMysticOn) && !statusUltraInstinctOn && !statusGodOfDestructionOn);
/*      */ 
/*      */       
/* 1425 */       if (transformationMeter < 100 && !isKaiokenAvailable)
/* 1426 */         return;  jgPlayer.setTransformationMeter(0);
/*      */       
/* 1428 */       int[] playerAttributes = jgPlayer.getAttributes();
/* 1429 */       byte race = jgPlayer.getRace();
/* 1430 */       byte classID = jgPlayer.getClassID();
/* 1431 */       byte powerType = jgPlayer.getPowerType();
/*      */       
/* 1433 */       int quickTransformKiLoss = -1;
/*      */       
/* 1435 */       byte st = jgPlayer.getState();
/* 1436 */       byte st2 = jgPlayer.getState2();
/*      */       
/* 1438 */       if (quickTransform) {
/*      */         
/* 1440 */         int curEnergy = jgPlayer.getEnergy();
/* 1441 */         int maxEnergy = jgPlayer.getEnergyMax(race, classID, powerType, playerAttributes, JRMCoreH.SklLvl_KiBs(p, powerType));
/*      */         
/* 1443 */         boolean costPercentage = true;
/* 1444 */         double costMulti = DBCConfig.InstantTransformKiPercentageCost / 100.0D;
/*      */         
/* 1446 */         double energyCost = maxEnergy * costMulti + DBCConfig.InstantTransformKiCost;
/*      */         
/* 1448 */         if (curEnergy >= energyCost && DBCConfig.InstantTransformOn) {
/*      */           
/* 1450 */           int remainingEnergy = curEnergy - (int)energyCost;
/* 1451 */           quickTransformKiLoss = remainingEnergy;
/*      */         }
/*      */         else {
/*      */           
/* 1455 */           p.func_145747_a((new ChatComponentText("Not Enough Ki to Transform Instantly! Cost: " + energyCost)).func_150255_a(styleRed));
/*      */           
/*      */           return;
/*      */         } 
/*      */       } 
/* 1460 */       int align = jgPlayer.getAlignment();
/*      */       
/* 1462 */       int level = jgPlayer.getLevel(playerAttributes);
/* 1463 */       String s1 = nbt.func_74779_i("jrmcSSltX");
/* 1464 */       String s2 = nbt.func_74779_i("jrmcSSltY");
/* 1465 */       int stUp = st;
/* 1466 */       boolean isPainZero = (nbt.func_74762_e("jrmcGyJ7dp") <= 0);
/* 1467 */       int godSkillLevel = JRMCoreH.SklLvl(9, p);
/* 1468 */       int mysticSkillLevel = JRMCoreH.SklLvl(10, p);
/* 1469 */       int ultraInstinctSkillLevel = JRMCoreH.SklLvl(16, p);
/* 1470 */       int godOfDestructionSkillLevel = JRMCoreH.SklLvl(18, p);
/* 1471 */       boolean isMysticAvailable = (JRMCoreH.PlyrSettingsB(nbt, 6) && mysticSkillLevel > 0);
/* 1472 */       boolean isUIAvailable = (JRMCoreH.PlyrSettingsB(nbt, 11) && ultraInstinctSkillLevel > 0 && JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0);
/* 1473 */       boolean isGoDAvailable = (JRMCoreH.PlyrSettingsB(nbt, 16) && godOfDestructionSkillLevel > 0);
/*      */       
/* 1475 */       boolean playerAscendNormal = JRMCoreH.PlyrSettingsI(p, 1, 0);
/* 1476 */       boolean playerAscendGod = JRMCoreH.PlyrSettingsI(p, 1, 1);
/* 1477 */       boolean playerAscendBlue = JRMCoreH.PlyrSettingsI(p, 1, 2);
/* 1478 */       boolean playerAscendSS4 = JRMCoreH.PlyrSettingsI(p, 1, 3);
/*      */       
/* 1480 */       boolean transformToOozaru = false;
/* 1481 */       boolean tailMode = false;
/*      */       
/* 1483 */       if (JRMCoreH.isRaceSaiyan(race)) {
/*      */         
/* 1485 */         int n = 200;
/* 1486 */         AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(p.field_70165_t - 200.0D, 200.0D, p.field_70161_v - 200.0D, p.field_70165_t + 200.0D, 255.0D, p.field_70161_v + 200.0D);
/* 1487 */         List l = p.field_70170_p.func_72872_a(EntityEnergyFM.class, aabb);
/* 1488 */         boolean pwbl = !l.isEmpty();
/* 1489 */         tailMode = JRMCoreH.tailHas(JRMCoreH.getByte(p, "jrmcTlmd"));
/* 1490 */         boolean night = (JRMCoreH.StusEfcts(8, StE) || pwbl);
/* 1491 */         boolean lookup = (p.field_70125_A <= -90.0F);
/* 1492 */         transformToOozaru = (night && lookup && tailMode && st == 0);
/*      */       } 
/*      */       
/* 1495 */       boolean isNotFused = !JRMCoreH.isFused((Entity)p);
/* 1496 */       boolean isFusionSelectedAvailable = (JRMCoreH.PlyrSettingsB(nbt, 4) && isNotFused);
/* 1497 */       String fusionMembers = nbt.func_74779_i("jrmcFuzion");
/*      */       
/* 1499 */       boolean tryToUseUltraInstinct = false;
/*      */       
/* 1501 */       int baseStateID = (race == 4) ? 4 : 0;
/* 1502 */       boolean isInBaseForm = (st == baseStateID);
/* 1503 */       boolean hasGodForm = (godSkillLevel > (JRMCoreH.isRaceSaiyan(race) ? 1 : 0));
/*      */       
/* 1505 */       if (!statusUltraInstinctOn) {
/*      */ 
/*      */         
/* 1508 */         if (!statusMysticOn && isMysticAvailable && mysticSkillLevel > 0 && !transformToOozaru) {
/*      */           
/* 1510 */           boolean canUseMystic = (isInBaseForm && DBCConfig.MysticKaiokenOn) ? (!statusUltraInstinctOn) : ((st2 == 0));
/*      */           
/* 1512 */           if (canUseMystic)
/*      */           {
/* 1514 */             if (quickTransformKiLoss != -1 && !DBCConfig.IsInstantTransformEnabled[2])
/* 1515 */               return;  if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, false, 1, race))
/* 1516 */               return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, "Mystic"))
/*      */               return; 
/* 1518 */             StE = JRMCoreH.StusEfcts(13, StE, nbt, true);
/* 1519 */             jgPlayer.setStateAndTransformationMeter(stUp = (race == 4) ? 4 : 0, 0);
/* 1520 */             JRMCoreH.PlyrSettingsRem(nbt, 6);
/*      */           }
/*      */           else
/*      */           {
/* 1524 */             p.func_145747_a((new ChatComponentText("Unable to use Mystic form in your current state!")).func_150255_a(styleRed));
/*      */           }
/*      */         
/*      */         }
/* 1528 */         else if (!statusGodOfDestructionOn && isGoDAvailable && !transformToOozaru) {
/*      */           
/* 1530 */           boolean canUseGoD = (isInBaseForm && st2 == 0 && hasGodForm && align <= JGConfigDBCGoD.CONFIG_GOD_MAX_ALIGNMENT && JGConfigDBCGoD.CONFIG_GOD_ENABLED);
/*      */           
/* 1532 */           if (canUseGoD) {
/*      */             
/* 1534 */             if (quickTransformKiLoss != -1 && !DBCConfig.IsInstantTransformEnabled[3])
/* 1535 */               return;  if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, false, 3, race))
/* 1536 */               return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, "GodOfDestruction"))
/*      */               return; 
/* 1538 */             int levelRequirement = JGConfigDBCGoD.CONFIG_GOD_LEVEL_REQUIREMENT;
/* 1539 */             if (level > levelRequirement || (byte)(new Random()).nextInt(100) <= JGConfigDBCGoD.CONFIG_GOD_REGARDLESS_LEVEL_REQUIREMENT) {
/*      */ 
/*      */               
/* 1542 */               StE = JRMCoreH.StusEfcts(20, StE, nbt, true);
/* 1543 */               jgPlayer.setStateAndTransformationMeter(stUp = baseStateID, 0);
/* 1544 */               JRMCoreH.PlyrSettingsRem(nbt, 16);
/*      */             }
/*      */             else {
/*      */               
/* 1548 */               p.func_145747_a((new ChatComponentText("Your level was not enough to use God of Destruction (" + level + "/" + levelRequirement + ") (Failed secondary " + JGConfigDBCGoD.CONFIG_GOD_REGARDLESS_LEVEL_REQUIREMENT + "% success chance)"))
/* 1549 */                   .func_150255_a(styleRed));
/*      */             } 
/*      */           } else {
/*      */             String message;
/*      */ 
/*      */             
/* 1555 */             if (!JGConfigDBCGoD.CONFIG_GOD_ENABLED) {
/* 1556 */               message = "God of Destruction form is Disabled!";
/*      */             }
/* 1558 */             else if (align > JGConfigDBCGoD.CONFIG_GOD_MAX_ALIGNMENT) {
/* 1559 */               message = "Your Alignment is too high to use God of Destruction! Max Alignment: " + JGConfigDBCGoD.CONFIG_GOD_MAX_ALIGNMENT;
/*      */             } else {
/*      */               
/* 1562 */               message = "Unable to use God of Destruction form in your current state!";
/*      */             } 
/* 1564 */             p.func_145747_a((new ChatComponentText(message)).func_150255_a(styleYellow));
/*      */           }
/*      */         
/*      */         }
/* 1568 */         else if (!statusMysticOn && isUIAvailable && isInBaseForm && !transformToOozaru && st2 < JGConfigUltraInstinct.CONFIG_UI_LEVELS && hasGodForm) {
/*      */           
/* 1570 */           if (quickTransformKiLoss != -1 && !DBCConfig.IsInstantTransformEnabled[1])
/* 1571 */             return;  if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, false, 2, race))
/* 1572 */             return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, "UltraInstict"))
/*      */             return; 
/* 1574 */           tryToUseUltraInstinct = true;
/*      */         }
/* 1576 */         else if (!statusMysticOn && isFusionSelectedAvailable && !JRMCoreConfig.fuzn) {
/*      */           
/* 1578 */           if (quickTransformKiLoss != -1)
/*      */             return; 
/* 1580 */           String t = JRMCoreH.trlai("jrmc", "specskilldisabled");
/* 1581 */           p.func_145747_a((new ChatComponentTranslation(t, new Object[] { JRMCoreH.DBCSkillNames[0] })).func_150255_a(styleYellow));
/*      */         
/*      */         }
/* 1584 */         else if (!statusMysticOn && isFusionSelectedAvailable && JRMCoreConfig.fuzn) {
/*      */           
/* 1586 */           if (quickTransformKiLoss != -1)
/*      */             return; 
/* 1588 */           if (statusMysticOn) StE = JRMCoreH.StusEfcts(13, StE, nbt, false);
/*      */           
/* 1590 */           if (fusionMembers.equals(" ")) {
/*      */             
/* 1592 */             jgPlayer.setTransformationMeter(0);
/* 1593 */             int n = 3;
/* 1594 */             AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(p.field_70165_t - 3.0D, p.field_70163_u - 3.0D, p.field_70161_v - 3.0D, p.field_70165_t + 3.0D, p.field_70163_u + 3.0D, p.field_70161_v + 3.0D);
/* 1595 */             List<EntityPlayer> entityList = p.field_70170_p.func_72872_a(EntityPlayer.class, aabb);
/*      */             
/* 1597 */             if (!entityList.isEmpty())
/*      */             {
/* 1599 */               for (int i = 0; i < entityList.size(); i++) {
/*      */                 
/* 1601 */                 EntityPlayer pl2 = entityList.get(i);
/* 1602 */                 if (!pl2.func_70005_c_().equals(p.func_70005_c_())) {
/*      */ 
/*      */                   
/* 1605 */                   NBTTagCompound nbt2 = nbt(pl2, "pres");
/* 1606 */                   int rc2 = nbt2.func_74771_c("jrmcRace");
/* 1607 */                   if (JRMCoreH.race_match(race, rc2)) {
/*      */ 
/*      */                     
/* 1610 */                     boolean isNotFused2 = !JRMCoreH.isFused((Entity)pl2);
/* 1611 */                     boolean f2 = (JRMCoreH.PlyrSettingsB(nbt2, 4) && isNotFused2);
/* 1612 */                     String StE2 = nbt2.func_74779_i("jrmcStatusEff");
/* 1613 */                     boolean pl2HasAura = JRMCoreH.StusEfcts(4, StE2);
/* 1614 */                     Random rand = new Random();
/* 1615 */                     int random = rand.nextInt(100);
/* 1616 */                     int fusionLevel1 = JRMCoreH.SklLvl(0, p);
/* 1617 */                     int fusionLevel2 = JRMCoreH.SklLvl(0, pl2);
/*      */                     
/* 1619 */                     if (pl2HasAura) {
/*      */ 
/*      */                       
/* 1622 */                       if (30 + fusionLevel1 * 3 + fusionLevel2 * 3 < random) {
/*      */                         
/* 1624 */                         JRMCoreH.PlyrSettingsRem(nbt2, 4);
/* 1625 */                         JRMCoreH.PlyrSettingsRem(nbt, 4);
/*      */                         
/* 1627 */                         String t = JRMCoreH.trlai("dbc", "playersFuseFaild");
/* 1628 */                         p.func_145747_a((new ChatComponentTranslation(t, new Object[] { p.func_70005_c_(), pl2.func_70005_c_() })).func_150255_a(styleYellow));
/* 1629 */                         pl2.func_145747_a((new ChatComponentTranslation(t, new Object[] { p.func_70005_c_(), pl2.func_70005_c_() })).func_150255_a(styleYellow));
/* 1630 */                         mod_DragonBC.logger.info(p.func_70005_c_() + " and " + pl2.func_70005_c_() + " fusion failed!");
/*      */                         
/* 1632 */                         nbt.func_74778_a("jrmcFuzion", "" + JRMCoreConfig.FznOverTime);
/* 1633 */                         nbt2.func_74778_a("jrmcFuzion", "" + JRMCoreConfig.FznOverTime);
/* 1634 */                         JRMCoreH.StusEfcts(10, nbt, false);
/* 1635 */                         JRMCoreH.StusEfcts(11, nbt, false);
/* 1636 */                         JRMCoreH.StusEfcts(10, nbt2, false);
/* 1637 */                         JRMCoreH.StusEfcts(11, nbt2, false);
/*      */                         
/*      */                         break;
/*      */                       } 
/* 1641 */                       if (f2) {
/*      */                         
/* 1643 */                         JRMCoreH.PlyrSettingsRem(nbt2, 4);
/* 1644 */                         JRMCoreH.PlyrSettingsRem(nbt, 4);
/* 1645 */                         StE = JRMCoreH.StusEfcts(10, StE, nbt, true);
/* 1646 */                         StE2 = JRMCoreH.StusEfcts(11, StE2, nbt2, true);
/*      */                         
/* 1648 */                         String fznn = JRMCoreHDBC.f_namgen(p.func_70005_c_(), pl2.func_70005_c_());
/* 1649 */                         int FznTime = JRMCoreConfig.FznTime - ((JRMCoreH.isRaceArcosian(race) && stUp > 4) ? ((stUp - 4) * 5) : (JRMCoreH.isRaceHumanOrNamekian(race) ? (stUp * 5) : (stUp * 2)));
/* 1650 */                         nbt2.func_74778_a("jrmcFuzion", p.func_70005_c_() + "," + pl2.func_70005_c_() + "," + FznTime);
/* 1651 */                         nbt.func_74778_a("jrmcFuzion", p.func_70005_c_() + "," + pl2.func_70005_c_() + "," + FznTime);
/* 1652 */                         mod_DragonBC.logger.info(p.func_70005_c_() + " and " + pl2.func_70005_c_() + " fused to " + fznn + "!");
/*      */                         
/* 1654 */                         String t = JRMCoreH.trlai("dbc", "playersFused");
/* 1655 */                         p.func_145747_a((new ChatComponentTranslation(t, new Object[] { p.func_70005_c_(), pl2.func_70005_c_(), fznn })).func_150255_a(styleYellow));
/* 1656 */                         pl2.func_145747_a((new ChatComponentTranslation(t, new Object[] { p.func_70005_c_(), pl2.func_70005_c_(), fznn })).func_150255_a(styleYellow));
/* 1657 */                         soundPowerUp(p, "jinryuudragonbc:DBC.fusefin");
/*      */                         
/* 1659 */                         StE = JRMCoreH.StusEfcts(3, StE, nbt, false);
/* 1660 */                         StE = JRMCoreH.StusEfcts(5, StE, nbt, false);
/* 1661 */                         StE = JRMCoreH.StusEfcts(4, StE, nbt, false);
/* 1662 */                         StE2 = JRMCoreH.StusEfcts(3, StE2, nbt2, false);
/* 1663 */                         StE2 = JRMCoreH.StusEfcts(5, StE2, nbt2, false);
/* 1664 */                         StE2 = JRMCoreH.StusEfcts(4, StE2, nbt2, false);
/* 1665 */                         nbt.func_74774_a("jrmcState2", (byte)0);
/* 1666 */                         nbt2.func_74774_a("jrmcState2", (byte)0);
/*      */                         
/* 1668 */                         String[] PlyrSkills = JRMCoreH.PlyrSkills(p);
/*      */                         
/* 1670 */                         byte pwr = nbt.func_74771_c("jrmcPwrtyp");
/* 1671 */                         byte rce = nbt.func_74771_c("jrmcRace");
/* 1672 */                         byte cls = nbt.func_74771_c("jrmcClass");
/* 1673 */                         int maxBody = JRMCoreH.stat((Entity)p, 2, pwr, 2, playerAttributes[2], rce, cls, 0.0F);
/* 1674 */                         int ki = JRMCoreH.stat((Entity)p, 5, pwr, 5, playerAttributes[5], rce, cls, JRMCoreH.SklLvl_KiBs(PlyrSkills, pwr));
/* 1675 */                         playerAttributes = JRMCoreH.PlyrAttrbts(pl2);
/* 1676 */                         PlyrSkills = JRMCoreH.PlyrSkills(pl2);
/* 1677 */                         int maxBodyF = JRMCoreH.stat((Entity)pl2, 2, pwr, 2, playerAttributes[2], rce, cls, 0.0F);
/* 1678 */                         int kiF = JRMCoreH.stat((Entity)pl2, 5, pwr, 5, playerAttributes[5], rce, cls, JRMCoreH.SklLvl_KiBs(PlyrSkills, pwr));
/*      */                         
/* 1680 */                         double curBody = nbt.func_74762_e("jrmcBdy");
/* 1681 */                         double curEn = nbt.func_74762_e("jrmcEnrgy");
/* 1682 */                         nbt.func_74768_a("jrmcBdy", (int)(curBody / maxBody * maxBodyF));
/* 1683 */                         nbt.func_74768_a("jrmcEnrgy", (int)(curEn / ki * kiF));
/*      */                         break;
/*      */                       } 
/*      */                     } 
/*      */                   } 
/*      */                 } 
/*      */               }  } 
/*      */           } 
/* 1691 */         } else if (!statusMysticOn && s1 != null && (!isKaiokenAvailable || transformToOozaru)) {
/*      */           
/* 1693 */           if (statusMysticOn)
/*      */           {
/* 1695 */             StE = JRMCoreH.StusEfcts(13, StE, nbt, false);
/*      */           }
/*      */           
/* 1698 */           if (statusGodOfDestructionOn)
/*      */           {
/* 1700 */             StE = JRMCoreH.StusEfcts(20, StE, nbt, false);
/*      */           }
/*      */           
/* 1703 */           if (statusUltraInstinctOn)
/*      */           {
/* 1705 */             StE = JRMCoreH.StusEfcts(19, StE, nbt, false);
/*      */           }
/*      */           
/* 1708 */           int racialSkillLevel = JRMCoreH.SklLvlX(1, s1);
/*      */           
/* 1710 */           if (JRMCoreH.isRaceSaiyan(race)) {
/*      */             
/* 1712 */             int s4ft = JRMCoreH.getInt(p, "jrmcAfGFtStFT");
/*      */             
/* 1714 */             int ssgHelp = 0;
/* 1715 */             int n = 3;
/* 1716 */             AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(p.field_70165_t - 3.0D, p.field_70163_u - 3.0D, p.field_70161_v - 3.0D, p.field_70165_t + 3.0D, p.field_70163_u + 3.0D, p.field_70161_v + 3.0D);
/* 1717 */             List<EntityPlayer> list = p.field_70170_p.func_72872_a(EntityPlayer.class, aabb);
/*      */             
/* 1719 */             if (!list.isEmpty())
/*      */             {
/* 1721 */               for (int i = 0; i < list.size(); i++) {
/*      */                 
/* 1723 */                 EntityPlayer pl = list.get(i);
/*      */                 
/* 1725 */                 if (!pl.func_70005_c_().equals(p.func_70005_c_())) {
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1730 */                   String StE2 = JRMCoreH.getString(pl, "jrmcStatusEff");
/* 1731 */                   int align2 = JRMCoreH.getByte(pl, "jrmcAlign");
/* 1732 */                   boolean a = JRMCoreH.StusEfcts(4, StE2);
/*      */                   
/* 1734 */                   int sg = JRMCoreH.getInt(pl, "jrmcGodStrain");
/* 1735 */                   int s = JRMCoreH.getByte(pl, "jrmcState");
/* 1736 */                   int rcpl = JRMCoreH.getByte(pl, "jrmcRace");
/* 1737 */                   boolean state = (s == 1 || s == 4 || s == 0);
/* 1738 */                   if (state && a && sg <= 0 && JRMCoreH.Algnmnt(align2) == 0 && JRMCoreH.isRaceSaiyan(rcpl))
/*      */                   {
/* 1740 */                     ssgHelp++;
/*      */                   }
/*      */                 } 
/*      */               } 
/*      */             }
/* 1745 */             if (ssgHelp == 0) {
/*      */               
/* 1747 */               aabb = AxisAlignedBB.func_72330_a(p.field_70165_t - 3.0D, p.field_70163_u - 3.0D, p.field_70161_v - 3.0D, p.field_70165_t + 3.0D, p.field_70163_u + 3.0D, p.field_70161_v + 3.0D);
/* 1748 */               List<EntityDBCKami> listMasters = p.field_70170_p.func_72872_a(EntityDBCKami.class, aabb);
/* 1749 */               if (!listMasters.isEmpty())
/*      */               {
/* 1751 */                 for (int i = 0; i < listMasters.size(); i++) {
/*      */                   
/* 1753 */                   EntityDBCKami entity = listMasters.get(i);
/* 1754 */                   if (entity instanceof JinRyuu.DragonBC.common.Npcs.EntityMasterGoku || entity instanceof JinRyuu.DragonBC.common.Npcs.EntityMasterGohan || entity instanceof JinRyuu.DragonBC.common.Npcs.EntityMasterTrunksFuture || entity instanceof JinRyuu.DragonBC.common.Npcs.EntityMasterVegeta)
/*      */                   {
/* 1756 */                     ssgHelp++;
/*      */                   }
/*      */                 } 
/*      */               }
/*      */             } 
/*      */             
/* 1762 */             if (transformToOozaru) {
/*      */               
/* 1764 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 7, race))
/* 1765 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][7]))
/* 1766 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 7, 0);
/*      */             }
/* 1768 */             else if (racialSkillLevel >= 2 && st == 7) {
/*      */               
/* 1770 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 8, race))
/* 1771 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][8]))
/* 1772 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 8, 0);
/*      */             }
/* 1774 */             else if (racialSkillLevel >= 8 && st == 8 && tailMode && DBCConfig.DBGT) {
/*      */               
/* 1776 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 14, race))
/* 1777 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][14]))
/* 1778 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 14, 0);
/* 1779 */               JRMCoreH.setInt(1, p, "jrmcAfGFtStFT");
/*      */             }
/* 1781 */             else if (JRMCoreHDBC.DBCgetConfigGodform() && st == 0 && ssgHelp >= DBCConfig.SSGHelp && JRMCoreH.Algnmnt(align) == 0) {
/*      */               
/* 1783 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 11, race))
/* 1784 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][11]))
/* 1785 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 11, 0);
/*      */               
/* 1787 */               int gplvl = JRMCoreH.getPlayerLevel(playerAttributes);
/* 1788 */               int gp = 0;
/* 1789 */               if (!list.isEmpty()) {
/*      */                 
/* 1791 */                 int hlprs = 0;
/* 1792 */                 for (int i = 0; i < list.size(); i++) {
/* 1793 */                   EntityPlayer pl = list.get(i);
/* 1794 */                   if (!pl.func_70005_c_().equals(p.func_70005_c_())) {
/*      */                     
/* 1796 */                     int align2 = JRMCoreH.getByte(pl, "jrmcAlign");
/* 1797 */                     int sg = JRMCoreH.getInt(pl, "jrmcGodStrain");
/* 1798 */                     int s = JRMCoreH.getByte(pl, "jrmcState");
/* 1799 */                     boolean state = (s == 1 || s == 4 || s == 0);
/* 1800 */                     int rcpl = JRMCoreH.getByte(pl, "jrmcRace");
/* 1801 */                     if (state && sg <= 0 && JRMCoreH.Algnmnt(align2) == 0 && JRMCoreH.isRaceSaiyan(rcpl)) {
/*      */                       
/* 1803 */                       gp += JRMCoreH.getPlayerLevel(JRMCoreH.PlyrAttrbts(pl));
/*      */ 
/*      */                       
/* 1806 */                       double d = 1.0D;
/* 1807 */                       if (JGConfigDBCFormMastery.FM_Enabled) {
/* 1808 */                         int formID = JRMCoreH.getFormID(JRMCoreH.trans[race][11], race);
/* 1809 */                         double masteryLevel = JRMCoreH.getFormMasteryValue(pl, formID);
/* 1810 */                         d = (float)JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, formID, JGConfigDBCFormMastery.DATA_ID_GOD_RITUAL_STRAIN_COST_MULTI);
/*      */                       } 
/* 1812 */                       JRMCoreH.setInt((int)(DBCConfig.StrainGod * d), pl, "jrmcGodStrain");
/* 1813 */                       JRMCoreH.setInt(0, pl, "jrmcEnrgy");
/* 1814 */                       hlprs++;
/*      */                     } 
/*      */                   } 
/* 1817 */                 }  gp = ((hlprs == 0) ? gplvl : gp) / DBCConfig.SSGHelp;
/* 1818 */                 float gpf = gp / gplvl;
/* 1819 */                 gpf = (gpf > 2.0F) ? 2.0F : ((gpf < 0.2F) ? 0.2F : gpf);
/*      */ 
/*      */                 
/* 1822 */                 double reqMulti = 1.0D;
/* 1823 */                 if (JGConfigDBCFormMastery.FM_Enabled) {
/* 1824 */                   int formID = JRMCoreH.getFormID(JRMCoreH.trans[race][11], race);
/* 1825 */                   double masteryLevel = JRMCoreH.getFormMasteryValue(p, formID);
/* 1826 */                   reqMulti = (float)JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, formID, JGConfigDBCFormMastery.DATA_ID_GOD_RITUAL_TIMER_MULTI);
/*      */                 } 
/*      */                 
/* 1829 */                 gp = (int)((120.0F * gpf) * reqMulti);
/*      */               } 
/* 1831 */               JRMCoreH.setInt(gp, p, "jrmcGodPwr");
/*      */             }
/* 1833 */             else if (JRMCoreHDBC.DBCgetConfigGodform() && JRMCoreHDBC.godformslr(racialSkillLevel) && (st == 0 || st == 9) && godSkillLevel > 1 && playerAscendBlue) {
/*      */               
/* 1835 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 10, race))
/* 1836 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][10]))
/* 1837 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 10, 0);
/*      */             }
/* 1839 */             else if (racialSkillLevel >= 6 && JRMCoreHDBC.DBCgetConfigGodform() && JRMCoreHDBC.godformslr(racialSkillLevel) && godSkillLevel > 2 && (playerAscendBlue || playerAscendGod) && st == 10) {
/*      */               
/* 1841 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 15, race))
/* 1842 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][15]))
/* 1843 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 15, 0);
/*      */             }
/* 1845 */             else if (JRMCoreHDBC.DBCgetConfigGodform() && JRMCoreHDBC.godformslr(racialSkillLevel) && godSkillLevel > 0 && playerAscendGod && st == 0) {
/*      */               
/* 1847 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 9, race))
/* 1848 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][9]))
/* 1849 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 9, 0);
/*      */             }
/* 1851 */             else if (JRMCoreHDBC.DBCgetConfigGodform() && JRMCoreHDBC.godformslr(racialSkillLevel) && godSkillLevel > 1 && playerAscendGod && st == 9) {
/*      */               
/* 1853 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 10, race))
/* 1854 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][10]))
/* 1855 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 10, 0);
/*      */             }
/* 1857 */             else if (racialSkillLevel >= 8 && st == 0 && playerAscendSS4 && s4ft > 0 && tailMode && DBCConfig.DBGT) {
/*      */               
/* 1859 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 14, race))
/* 1860 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][14]))
/* 1861 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 14, 0);
/*      */             }
/* 1863 */             else if (racialSkillLevel >= 5 && st == 0) {
/*      */               
/* 1865 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 4, race))
/* 1866 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][4]))
/* 1867 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 4, 0);
/*      */             }
/* 1869 */             else if (racialSkillLevel >= 2 && st == 0) {
/*      */               
/* 1871 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 1, race))
/* 1872 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][1]))
/* 1873 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 1, 0);
/*      */             }
/* 1875 */             else if (racialSkillLevel >= 6 && st == 4 && playerAscendNormal) {
/*      */               
/* 1877 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 5, race))
/* 1878 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][5]))
/* 1879 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 5, 0);
/*      */             }
/* 1881 */             else if (racialSkillLevel >= 3 && (st == 1 || st == 4)) {
/*      */               
/* 1883 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 2, race))
/* 1884 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][2]))
/* 1885 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 2, 0);
/*      */             }
/* 1887 */             else if (racialSkillLevel >= 4 && st == 2) {
/*      */               
/* 1889 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 3, race))
/* 1890 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][3]))
/* 1891 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 3, 0);
/*      */             }
/* 1893 */             else if (racialSkillLevel >= 7 && st == 5) {
/*      */               
/* 1895 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 6, race))
/* 1896 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][6]))
/* 1897 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 6, 0);
/*      */             } else {
/* 1899 */               quickTransformKiLoss = -1;
/*      */             } 
/* 1901 */           } else if (JRMCoreH.isRaceArcosian(race)) {
/*      */             
/* 1903 */             String bns = JRMCoreH.StusEfcts[6];
/* 1904 */             if (StE.contains(bns))
/*      */             {
/* 1906 */               nbt.func_74778_a("jrmcStatusEff", StE.replace(bns, ""));
/*      */             }
/*      */             
/* 1909 */             nbt.func_74774_a("jrmcTlmd", (byte)0);
/*      */             
/* 1911 */             if (racialSkillLevel >= 1 && st == 0) {
/*      */               
/* 1913 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 1, race))
/* 1914 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][1]))
/* 1915 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 1, 0);
/*      */             }
/* 1917 */             else if (racialSkillLevel >= 1 && st == 1) {
/*      */               
/* 1919 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 2, race))
/* 1920 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][2]))
/* 1921 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 2, 0);
/*      */             }
/* 1923 */             else if (racialSkillLevel >= 1 && st == 2) {
/*      */               
/* 1925 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 3, race))
/* 1926 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][3]))
/* 1927 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 3, 0);
/*      */             }
/* 1929 */             else if (racialSkillLevel >= 1 && st == 3) {
/*      */               
/* 1931 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 4, race))
/* 1932 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][4]))
/* 1933 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 4, 0);
/*      */             }
/* 1935 */             else if (racialSkillLevel >= 7 && st == 4 && godSkillLevel > 0 && playerAscendGod) {
/*      */               
/* 1937 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 7, race))
/* 1938 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][7]))
/* 1939 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 7, 0);
/*      */             }
/* 1941 */             else if (racialSkillLevel >= 7 && st == 4 && playerAscendNormal) {
/*      */               
/* 1943 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 6, race))
/* 1944 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][6]))
/* 1945 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 6, 0);
/*      */             }
/* 1947 */             else if (racialSkillLevel >= 4 && st == 4) {
/*      */               
/* 1949 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 5, race))
/* 1950 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][5]))
/* 1951 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 5, 0);
/*      */             } else {
/* 1953 */               quickTransformKiLoss = -1;
/*      */             } 
/* 1955 */           } else if (JRMCoreH.isRaceMajin(race)) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1965 */             if (JRMCoreHDBC.DBCgetConfigGodform() && JRMCoreHDBC.hasMajinGodRacialRequirement(racialSkillLevel) && st == 0 && godSkillLevel > 0 && playerAscendGod) {
/*      */               
/* 1967 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 4, race))
/* 1968 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][4]))
/* 1969 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 4, 0);
/*      */             
/*      */             }
/* 1972 */             else if (racialSkillLevel >= 6 && st == 0 && playerAscendNormal) {
/*      */               
/* 1974 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 3, race))
/* 1975 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][3]))
/* 1976 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 3, 0);
/*      */             
/*      */             }
/* 1979 */             else if (racialSkillLevel >= 3 && st == 0) {
/*      */               
/* 1981 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 1, race))
/* 1982 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][1]))
/* 1983 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 1, 0);
/*      */             
/*      */             }
/* 1986 */             else if (racialSkillLevel >= 4 && st == 1) {
/*      */               
/* 1988 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 2, race))
/* 1989 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][2]))
/* 1990 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 2, 0);
/*      */             } else {
/* 1992 */               quickTransformKiLoss = -1;
/*      */             } 
/* 1994 */           } else if (JRMCoreH.isRaceHumanOrNamekian(race)) {
/*      */             
/* 1996 */             if (JRMCoreHDBC.DBCgetConfigGodform() && JRMCoreHDBC.godformslrHN(racialSkillLevel) && st == 0 && godSkillLevel > 0 && playerAscendGod) {
/*      */               
/* 1998 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 3, race))
/* 1999 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][3]))
/* 2000 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 3, 0);
/*      */             }
/* 2002 */             else if (racialSkillLevel >= 3 && st == 0 && playerAscendNormal) {
/*      */               
/* 2004 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 1, race))
/* 2005 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][1]))
/* 2006 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 1, 0);
/*      */             }
/* 2008 */             else if (racialSkillLevel >= 2 && st == 0) {
/*      */               
/* 2010 */               if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, true, 2, race))
/* 2011 */                 return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, JRMCoreH.trans[race][2]))
/* 2012 */                 return;  jgPlayer.setStateAndTransformationMeter(stUp = 2, 0);
/*      */             } else {
/* 2014 */               quickTransformKiLoss = -1;
/*      */             }
/*      */           
/*      */           } 
/* 2018 */         } else if (isKaiokenAvailable && kaiokenSkillLevel > st2) {
/*      */           
/* 2020 */           if (quickTransformKiLoss != -1 && !DBCConfig.IsInstantTransformEnabled[0])
/* 2021 */             return;  if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, false, 0, race))
/* 2022 */             return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, "Kaioken"))
/*      */             return; 
/* 2024 */           if (JRMCoreH.TransKaiDmg.length - 1 > st2)
/*      */           {
/* 2026 */             nbt.func_74774_a("jrmcState2", (byte)(st2 + 1));
/* 2027 */             p.func_145747_a((new ChatComponentText("Kaioken " + JRMCoreH.TransKaiNms[st2 + 1])).func_150255_a(styleGold));
/*      */           }
/*      */         
/*      */         } 
/* 2031 */       } else if (isUIAvailable && st == ((race == 4) ? 4 : 0) && !transformToOozaru && st2 < JGConfigUltraInstinct.CONFIG_UI_LEVELS && godSkillLevel > (
/* 2032 */         JRMCoreH.isRaceSaiyan(race) ? 1 : 0)) {
/*      */         
/* 2034 */         if (quickTransformKiLoss != -1 && !DBCConfig.IsInstantTransformEnabled[1])
/* 2035 */           return;  if (DBCConfig.InstantTransformOn && quickTransform && !hasInstantTransformUnlocked(p, false, 2, race))
/* 2036 */           return;  if (JGConfigDBCFormMastery.FM_Enabled && !JRMCoreH.hasRequiredFormMasteries(p, JRMCoreH.getFormMasteryData(p), race, "UltraInstict"))
/*      */           return; 
/* 2038 */         tryToUseUltraInstinct = true;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2045 */       if (tryToUseUltraInstinct) {
/*      */         
/* 2047 */         if (quickTransformKiLoss != -1 && !DBCConfig.IsInstantTransformEnabled[1])
/*      */           return; 
/* 2049 */         if (isPainZero) {
/*      */           
/* 2051 */           boolean uiCheckEachLevel = (JGConfigUltraInstinct.CONFIG_UI_CHECK_SKIP_REQUIREMENT_EACH_LEVEL == 0);
/* 2052 */           byte experiencePainMode = JGConfigUltraInstinct.CONFIG_UI_EXPERIENCE_PAIN_MODE;
/* 2053 */           boolean canIgnorePain = (experiencePainMode <= 0) ? true : ((nbt.func_74771_c("jrmcUIWasInPain") > 0));
/*      */           
/* 2055 */           jgPlayer.setStateAndTransformationMeter(stUp = JRMCoreH.getBaseForm(race), 0);
/*      */           
/* 2057 */           boolean succeded = false;
/* 2058 */           boolean skippable = true;
/* 2059 */           Random rand = new Random();
/* 2060 */           byte random = (byte)rand.nextInt(100);
/* 2061 */           byte randomLast = random;
/*      */ 
/*      */ 
/*      */           
/* 2065 */           int curBody = jgPlayer.getHealth();
/* 2066 */           int maxBody = jgPlayer.getHealthMax(race, classID, powerType, playerAttributes);
/* 2067 */           int[] levelRequirement = JGConfigUltraInstinct.CONFIG_UI_LEVEL_REQUIREMENT;
/* 2068 */           byte[] healthPercentage = JGConfigUltraInstinct.CONFIG_UI_HEALTH_PERCENTAGE;
/*      */           
/* 2070 */           double reqMulti = 1.0D;
/* 2071 */           if (JGConfigDBCFormMastery.FM_Enabled) {
/* 2072 */             int formID = JRMCoreH.getFormID("UltraInstict", race);
/* 2073 */             double masteryLevel = JRMCoreH.getFormMasteryValue(p, formID);
/*      */             
/* 2075 */             reqMulti = JGConfigDBCFormMastery.getCostMulti(masteryLevel, race, formID, JGConfigDBCFormMastery.DATA_ID_UI_HEALTH_REQ_MULTI);
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2083 */           if (uiCheckEachLevel) {
/*      */             
/* 2085 */             while (st2 < JGConfigUltraInstinct.CONFIG_UI_LEVELS && ultraInstinctSkillLevel > st2 && skippable && (level > levelRequirement[st2] || random <= JGConfigUltraInstinct.CONFIG_UI_REGARDLESS_LEVEL_REQUIREMENT[st2]) && ((int)(healthPercentage[st2] * reqMulti) >= 100 || curBody / maxBody / 100 <= (int)(healthPercentage[st2] * reqMulti)) && (!JGConfigUltraInstinct.CONFIG_UI_HAIR_WHITE[st2] || canIgnorePain))
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2093 */               if (JGConfigUltraInstinct.CONFIG_UI_HAIR_WHITE[st2] && experiencePainMode == 2) nbt.func_74774_a("jrmcUIWasInPain", (byte)0); 
/* 2094 */               succeded = true;
/* 2095 */               randomLast = random;
/* 2096 */               random = (byte)rand.nextInt(100);
/* 2097 */               skippable = JGConfigUltraInstinct.CONFIG_UI_SKIP[st2];
/* 2098 */               st2 = (byte)(st2 + 1);
/* 2099 */               int UI_HighestStateReached = nbt.func_74771_c("jrmcUIStateReach");
/* 2100 */               if (st2 > UI_HighestStateReached) nbt.func_74774_a("jrmcUIStateReach", st2);
/*      */               
/*      */ 
/*      */             
/*      */             }
/*      */           
/*      */           }
/*      */           else {
/*      */             
/* 2109 */             boolean[] conditionsMet = new boolean[JGConfigUltraInstinct.CONFIG_UI_LEVELS];
/* 2110 */             for (int i = 0; i < conditionsMet.length; ) { conditionsMet[i] = false; i++; }
/*      */             
/* 2112 */             while (st2 < JGConfigUltraInstinct.CONFIG_UI_LEVELS && ultraInstinctSkillLevel > st2 && skippable) {
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2117 */               skippable = JGConfigUltraInstinct.CONFIG_UI_SKIP[st2];
/* 2118 */               conditionsMet[st2] = (st2 < JGConfigUltraInstinct.CONFIG_UI_LEVELS && ultraInstinctSkillLevel > st2 && (level > levelRequirement[st2] || random <= JGConfigUltraInstinct.CONFIG_UI_REGARDLESS_LEVEL_REQUIREMENT[st2]) && ((int)(healthPercentage[st2] * reqMulti) >= 100 || curBody / maxBody / 100 <= (int)(healthPercentage[st2] * reqMulti)) && (!JGConfigUltraInstinct.CONFIG_UI_HAIR_WHITE[st2] || canIgnorePain));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2124 */               randomLast = random;
/* 2125 */               random = (byte)rand.nextInt(100);
/* 2126 */               st2 = (byte)(st2 + 1);
/*      */             } 
/*      */             
/* 2129 */             int conditionCount = conditionsMet.length;
/* 2130 */             for (int j = conditionCount - 1; j >= 0; j--) {
/*      */               
/* 2132 */               if (conditionsMet[j]) {
/*      */                 
/* 2134 */                 st2 = (byte)j;
/* 2135 */                 if (JGConfigUltraInstinct.CONFIG_UI_HAIR_WHITE[st2] && experiencePainMode == 2) nbt.func_74774_a("jrmcUIWasInPain", (byte)0); 
/* 2136 */                 succeded = true;
/* 2137 */                 skippable = JGConfigUltraInstinct.CONFIG_UI_SKIP[st2];
/* 2138 */                 st2 = (byte)(st2 + 1);
/* 2139 */                 int UI_HighestStateReached = nbt.func_74771_c("jrmcUIStateReach");
/* 2140 */                 if (st2 > UI_HighestStateReached) nbt.func_74774_a("jrmcUIStateReach", st2);
/*      */ 
/*      */ 
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */           
/* 2149 */           if (succeded) {
/*      */             
/* 2151 */             StE = JRMCoreH.StusEfcts(19, StE, nbt, true);
/* 2152 */             jgPlayer.setState2(st2);
/* 2153 */             p.func_145747_a((new ChatComponentText(JGConfigUltraInstinct.CONFIG_UI_CHAT_SUCCEED[st2 - 1].replace("@p", p.getDisplayName()))).func_150255_a(styleYellow));
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2159 */           if (st2 <= JGConfigUltraInstinct.CONFIG_UI_LEVELS) {
/*      */             
/* 2161 */             if (st2 == JGConfigUltraInstinct.CONFIG_UI_LEVELS) st2 = (byte)(st2 - 1);
/*      */             
/* 2163 */             if (ultraInstinctSkillLevel > st2)
/*      */             {
/* 2165 */               if (level > levelRequirement[st2] || randomLast <= JGConfigUltraInstinct.CONFIG_UI_REGARDLESS_LEVEL_REQUIREMENT[st2])
/*      */               
/*      */               { 
/*      */ 
/*      */ 
/*      */                 
/* 2171 */                 if ((int)(healthPercentage[st2] * reqMulti) < 100 && curBody / maxBody / 100 > (int)(healthPercentage[st2] * reqMulti)) {
/*      */                   
/* 2173 */                   p.func_145747_a((new ChatComponentText("Your health was not low enough to use an Ultra Instinct Level (" + (int)(healthPercentage[st2] * reqMulti) + "% or below)")).func_150255_a(styleRed));
/*      */                 }
/* 2175 */                 else if (JGConfigUltraInstinct.CONFIG_UI_HAIR_WHITE[st2] && !canIgnorePain) {
/*      */                   
/* 2177 */                   p.func_145747_a((new ChatComponentText("You must experience 'Pain' Status Effect before using Complete Ultra Instinct")).func_150255_a(styleRed));
/*      */                 }  }
/*      */               else { p.func_145747_a((new ChatComponentText("Your level was not enough to use an Ultra Instinct Lvl (" + level + "/" + levelRequirement[st2] + ") (Failed secondary " + JGConfigUltraInstinct.CONFIG_UI_REGARDLESS_LEVEL_REQUIREMENT[st2] + "% success chance)")).func_150255_a(styleRed)); }
/* 2180 */                }  if (st2 == JGConfigUltraInstinct.CONFIG_UI_LEVELS) st2 = (byte)(st2 + 1);
/*      */           
/*      */           } 
/*      */         } else {
/*      */           
/* 2185 */           p.func_145747_a((new ChatComponentText("You can't use Ultra Instinct while in Pain")).func_150255_a(styleRed));
/*      */         } 
/*      */       } 
/*      */       
/* 2189 */       if (!fusionMembers.equals(" ") && !isKaiokenAvailable) {
/*      */ 
/*      */ 
/*      */         
/* 2193 */         String[] fusionParticipants = fusionMembers.split(",");
/* 2194 */         if (fusionParticipants.length == 3) {
/*      */           
/* 2196 */           boolean isParticipentCommandSender = fusionParticipants[0].equalsIgnoreCase(p.func_70005_c_());
/* 2197 */           if (isParticipentCommandSender) {
/*      */ 
/*      */             
/* 2200 */             EntityPlayer pl2 = p.field_70170_p.func_72924_a(fusionParticipants[1]);
/* 2201 */             boolean isPlayer2Null = (pl2 == null);
/* 2202 */             int fusionTime = Integer.parseInt(fusionParticipants[2]) - ((JRMCoreH.isRaceArcosian(race) && stUp > 4) ? ((stUp - 4) * 5) : (JRMCoreH.isRaceHumanOrNamekian(race) ? (stUp * 5) : (stUp * 2)));
/* 2203 */             if (!isPlayer2Null) {
/*      */               
/* 2205 */               NBTTagCompound nbt2 = JRMCoreH.nbt(pl2);
/* 2206 */               nbt.func_74778_a("jrmcFuzion", fusionMembers = fusionParticipants[0] + "," + fusionParticipants[1] + "," + fusionTime);
/* 2207 */               nbt2.func_74778_a("jrmcFuzion", fusionMembers = fusionParticipants[0] + "," + fusionParticipants[1] + "," + fusionTime);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 2213 */       st2 = nbt.func_74771_c("jrmcState2");
/*      */       
/* 2215 */       if (st2 > 0)
/*      */       {
/*      */         
/* 2218 */         if (isKaiokenAvailable) {
/*      */           
/* 2220 */           if (quickTransformKiLoss != -1 && !DBCConfig.IsInstantTransformEnabled[0]) {
/*      */             return;
/*      */           }
/*      */           
/* 2224 */           int skl = JRMCoreH.SklLvlX(1, JRMCoreH.getString(p, "jrmcSSltX"));
/* 2225 */           int strn = JRMCoreH.getInt(p, "jrmcStrain");
/* 2226 */           int strnTmp = nbt.func_74762_e("jrmcStrainTemp");
/* 2227 */           int strnAct = nbt.func_74762_e("jrmcStrainActv");
/*      */           
/* 2229 */           int curBody = jgPlayer.getHealth();
/* 2230 */           int maxBody = jgPlayer.getHealthMax(race, classID, powerType, playerAttributes);
/* 2231 */           double kaiokenCost = JRMCoreH.KaiKCost(p) * maxBody;
/* 2232 */           int ske = JRMCoreH.SklLvl(4, p);
/*      */           
/* 2234 */           int r = (new Random()).nextInt(100);
/* 2235 */           float rd = 0.5F + 0.05F * (10 - ske);
/* 2236 */           if (kaiokenSkillLevel * 3 > r) { kaiokenCost = 0.0D; }
/* 2237 */           else if (kaiokenSkillLevel * 5 > r) { kaiokenCost *= rd; }
/*      */           
/* 2239 */           int curen = (int)((curBody - kaiokenCost < 1.0D) ? 1.0D : (curBody - kaiokenCost));
/* 2240 */           if (!JRMCoreH.isInCreativeMode((Entity)p)) JRMCoreH.setInt(curen, p, "jrmcBdy");
/*      */           
/* 2242 */           float strainMulti = 1.0F;
/* 2243 */           float strainMulti2 = 1.0F;
/* 2244 */           if (JGConfigDBCFormMastery.FM_Enabled) {
/* 2245 */             int kkID = JRMCoreH.getFormID("Kaioken", race);
/* 2246 */             double kkMasteryLevel = JRMCoreH.getFormMasteryValue(p, kkID);
/*      */             
/* 2248 */             strainMulti = (float)JGConfigDBCFormMastery.getCostMulti(kkMasteryLevel, race, kkID, JGConfigDBCFormMastery.DATA_ID_KAIOKEN_STRAIN_TEMP_MULTI);
/*      */ 
/*      */ 
/*      */             
/* 2252 */             strainMulti2 = (float)JGConfigDBCFormMastery.getCostMulti(kkMasteryLevel, race, kkID, JGConfigDBCFormMastery.DATA_ID_KAIOKEN_STRAIN_ACTIVE_MULTI);
/*      */           } 
/*      */ 
/*      */           
/* 2256 */           if (!JRMCoreConfig.sskai) {
/*      */ 
/*      */             
/* 2259 */             int strainTemp = ((JRMCoreH.isRaceSaiyan(race) && stUp == 0) ? 1 : ((race == 4 && stUp <= 4) ? 1 : ((JRMCoreH.isRaceHumanOrNamekian(race) && stUp <= 1) ? 1 : 12))) + 20 - kaiokenSkillLevel;
/* 2260 */             strainTemp = (int)(strainTemp * strainMulti);
/* 2261 */             strainTemp += strnTmp;
/*      */             
/* 2263 */             JRMCoreH.setInt(strainTemp, p, "jrmcStrainTemp");
/*      */           } 
/*      */           
/* 2266 */           if (curen <= maxBody * 0.1F && !JRMCoreH.isInCreativeMode((Entity)p)) {
/*      */             
/* 2268 */             jgPlayer.setState(JRMCoreH.getBaseForm(race));
/* 2269 */             jgPlayer.setState2(0);
/* 2270 */             JRMCoreH.setInt(curen, p, "jrmcBdy");
/*      */           } 
/*      */           
/* 2273 */           if (!JRMCoreConfig.sskai)
/*      */           {
/* 2275 */             if (strnAct <= 0) {
/*      */               
/* 2277 */               int sa = 100 + kaiokenSkillLevel * 6 - MathHelper.func_76123_f(JRMCoreH.KaiKFBal(race, st, st2, skl, strn)) * 2 - st2 * 2;
/* 2278 */               sa = (int)(sa * strainMulti);
/* 2279 */               JRMCoreH.setInt(sa, p, "jrmcStrainActv");
/*      */             }
/*      */             else {
/*      */               
/* 2283 */               strnAct = (int)(strnAct - strainMulti2 * (MathHelper.func_76123_f(JRMCoreH.KaiKFBal(race, st, st2, skl, strn)) * 2 - st2 * 2));
/*      */               
/* 2285 */               JRMCoreH.setInt(strnAct, p, "jrmcStrainActv");
/*      */             } 
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 2292 */       if (quickTransformKiLoss != -1 && !JRMCoreH.isInCreativeMode((Entity)p))
/*      */       {
/* 2294 */         JRMCoreH.setInt(quickTransformKiLoss, p, "jrmcEnrgy");
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleDBCdescend(byte dbcdescend, EntityPlayer p) {
/* 2301 */     NBTTagCompound nbt = nbt(p, "pres");
/* 2302 */     byte race = nbt.func_74771_c("jrmcRace");
/* 2303 */     int state = nbt.func_74771_c("jrmcState");
/* 2304 */     int state2 = nbt.func_74771_c("jrmcState2");
/* 2305 */     String StE = nbt.func_74779_i("jrmcStatusEff");
/* 2306 */     boolean statusMysticOn = JRMCoreH.StusEfcts(13, StE);
/* 2307 */     boolean statusGoDOn = JRMCoreH.StusEfcts(20, StE);
/* 2308 */     boolean isKaiokenSelected = JRMCoreH.PlyrSettingsB(nbt, 0);
/* 2309 */     int baseState = (JRMCoreH.isRaceArcosian(race) && state >= 4) ? 4 : 0;
/* 2310 */     boolean lowerState2 = (state > baseState) ? (isKaiokenSelected ? ((state2 > 0)) : false) : (isKaiokenSelected ? ((state2 > 0)) : ((!statusGoDOn && !statusMysticOn && state2 > 0)));
/*      */     
/* 2312 */     if (lowerState2) {
/*      */ 
/*      */       
/* 2315 */       boolean isKaiokenOn = JRMCoreH.StusEfcts(5, StE);
/* 2316 */       boolean kaiokenTurnedOff = true;
/*      */       
/* 2318 */       if (DBCConfig.KaiokenSingleFormDescendOn && dbcdescend == -1 && isKaiokenOn) {
/*      */         
/* 2320 */         if (state2 > 0) state2--; 
/* 2321 */         if (state2 > 0) {
/*      */           
/* 2323 */           kaiokenTurnedOff = false;
/* 2324 */           p.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.clgd + "Kaioken " + JRMCoreH.TransKaiNms[state2]));
/*      */         } 
/* 2326 */         nbt.func_74774_a("jrmcState2", (byte)((state2 > 0) ? state2 : 0));
/*      */       } else {
/* 2328 */         nbt.func_74774_a("jrmcState2", (byte)0);
/*      */       } 
/* 2330 */       if (isKaiokenOn) {
/*      */         
/* 2332 */         if (kaiokenTurnedOff)
/*      */         {
/* 2334 */           int strnTmp = nbt.func_74762_e("jrmcStrainTemp");
/* 2335 */           int strnAct = nbt.func_74762_e("jrmcStrainActv");
/* 2336 */           int strn = nbt.func_74762_e("jrmcStrain");
/*      */           
/* 2338 */           JRMCoreH.KaiKStrainAct(p, nbt, state2, strn, strnTmp, strnAct);
/*      */         }
/*      */       
/*      */       } else {
/*      */         
/* 2343 */         StE = JRMCoreH.StusEfcts(19, nbt, false);
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 2349 */       if (statusMysticOn) StE = JRMCoreH.StusEfcts(13, StE, nbt, false); 
/* 2350 */       if (statusGoDOn) StE = JRMCoreH.StusEfcts(20, StE, nbt, false); 
/* 2351 */       int newState = baseState;
/*      */       
/* 2353 */       if (dbcdescend == -1 && DBCConfig.SingleFormDescendOn)
/*      */       {
/* 2355 */         if (JRMCoreH.isRaceSaiyan(race))
/*      */         {
/* 2357 */           if (JRMCoreH.isInState(state, 15)) { newState = 10; }
/* 2358 */           else if (JRMCoreH.isInState(state, 10)) { newState = 9; }
/* 2359 */           else if (JRMCoreH.isInState(state, 2))
/*      */           
/* 2361 */           { String s1 = nbt.func_74779_i("jrmcSSltX");
/* 2362 */             int racialSkillLevel = JRMCoreH.SklLvlX(1, s1);
/* 2363 */             newState = (racialSkillLevel - 1 >= 4) ? 4 : 1;
/*      */              }
/*      */           
/* 2366 */           else if (JRMCoreH.isInState(state, 3)) { newState = 2; }
/* 2367 */           else if (JRMCoreH.isInState(state, 5))
/*      */           
/* 2369 */           { String s1 = nbt.func_74779_i("jrmcSSltX");
/* 2370 */             int racialSkillLevel = JRMCoreH.SklLvlX(1, s1);
/* 2371 */             newState = (racialSkillLevel - 1 >= 4) ? 4 : 1;
/*      */              }
/*      */           
/* 2374 */           else if (JRMCoreH.isInState(state, 6)) { newState = 5; }
/*      */         
/*      */         }
/*      */       }
/* 2378 */       nbt.func_74774_a("jrmcState", (byte)newState);
/*      */     } 
/*      */     
/* 2381 */     if (dbcdescend == 3) {
/*      */       
/* 2383 */       if (statusMysticOn) StE = JRMCoreH.StusEfcts(13, StE, nbt, false); 
/* 2384 */       if (statusGoDOn) StE = JRMCoreH.StusEfcts(20, StE, nbt, false); 
/* 2385 */       nbt.func_74774_a("jrmcState", (byte)((JRMCoreH.isRaceArcosian(race) && state >= 4) ? 4 : 0));
/*      */     } 
/*      */ 
/*      */     
/* 2389 */     if (dbcdescend == 4) {
/*      */       
/* 2391 */       if (statusMysticOn) StE = JRMCoreH.StusEfcts(13, StE, nbt, false); 
/* 2392 */       if (statusGoDOn) StE = JRMCoreH.StusEfcts(20, StE, nbt, false); 
/* 2393 */       nbt.func_74774_a("jrmcState", (byte)0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleDBCchargesound(int c, String s, EntityPlayer p) {
/* 2400 */     soundPowerUp(p, s);
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleDBCjumpsound(int dbcjumpsound, int dbcp, EntityPlayer p) {
/* 2405 */     if (dbcjumpsound == -2)
/*      */     {
/* 2407 */       PD.sendTo(new DBCPduo(dbcjumpsound, JRMCoreH.getInt(p, "jrmcWishes")), (EntityPlayerMP)p);
/*      */     }
/* 2409 */     if (dbcjumpsound == -1)
/*      */     {
/* 2411 */       PD.sendTo(new DBCPduo(dbcjumpsound, JRMCoreH.getInt(p, "jrmcReviveTmer")), (EntityPlayerMP)p);
/*      */     }
/* 2413 */     if (dbcjumpsound < 999 && dbcjumpsound >= 0) {
/*      */       
/* 2415 */       int n = 16;
/* 2416 */       AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(p.field_70165_t - 16.0D, p.field_70163_u - 16.0D, p.field_70161_v - 16.0D, p.field_70165_t + 16.0D, p.field_70163_u + 16.0D, p.field_70161_v + 16.0D);
/* 2417 */       List<EntityPlayer> l = p.field_70170_p.func_72872_a(EntityPlayer.class, aabb);
/*      */ 
/*      */       
/* 2420 */       for (int i = 0; i < l.size(); i++) {
/* 2421 */         EntityPlayer entity2 = l.get(i);
/* 2422 */         PD.sendTo(new DBCPduo(dbcjumpsound, dbcp), (EntityPlayerMP)entity2);
/*      */       
/*      */       }
/*      */ 
/*      */     
/*      */     }
/* 2428 */     else if (dbcjumpsound == 1000 && p.field_70170_p.func_73045_a(dbcp) != null) {
/* 2429 */       p.field_70170_p.func_73045_a(dbcp).func_70106_y();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleDBCascendsound(int c, EntityPlayer p) {
/* 2437 */     int n = 16;
/* 2438 */     AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(p.field_70165_t - 16.0D, p.field_70163_u - 16.0D, p.field_70161_v - 16.0D, p.field_70165_t + 16.0D, p.field_70163_u + 16.0D, p.field_70161_v + 16.0D);
/* 2439 */     List<EntityPlayer> l = p.field_70170_p.func_72872_a(EntityPlayer.class, aabb);
/* 2440 */     for (int i = 0; i < l.size(); i++) {
/*      */       
/* 2442 */       EntityPlayer entity2 = l.get(i);
/* 2443 */       PD.sendTo(new DBCPascendsound(c), (EntityPlayerMP)entity2);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleDBCdescendsound(int c, EntityPlayer p) {
/* 2449 */     int n = 16;
/* 2450 */     AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(p.field_70165_t - 16.0D, p.field_70163_u - 16.0D, p.field_70161_v - 16.0D, p.field_70165_t + 16.0D, p.field_70163_u + 16.0D, p.field_70161_v + 16.0D);
/* 2451 */     List<EntityPlayer> l = p.field_70170_p.func_72872_a(EntityPlayer.class, aabb);
/* 2452 */     for (int i = 0; i < l.size(); i++) {
/*      */       
/* 2454 */       EntityPlayer entity2 = l.get(i);
/* 2455 */       PD.sendTo(new DBCPdescendsound(c), (EntityPlayerMP)entity2);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleDBCscouter1(int c, EntityPlayer p) {
/* 2461 */     int n = 16;
/* 2462 */     AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(p.field_70165_t - 16.0D, p.field_70163_u - 16.0D, p.field_70161_v - 16.0D, p.field_70165_t + 16.0D, p.field_70163_u + 16.0D, p.field_70161_v + 16.0D);
/* 2463 */     List<EntityPlayer> l = p.field_70170_p.func_72872_a(EntityPlayer.class, aabb);
/* 2464 */     for (int i = 0; i < l.size(); i++) {
/*      */       
/* 2466 */       EntityPlayer entity2 = l.get(i);
/* 2467 */       PD.sendTo(new DBCPscouter1(c), (EntityPlayerMP)entity2);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleDBCscouter2(int c, EntityPlayer p) {
/* 2473 */     int n = 16;
/* 2474 */     AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(p.field_70165_t - 16.0D, p.field_70163_u - 16.0D, p.field_70161_v - 16.0D, p.field_70165_t + 16.0D, p.field_70163_u + 16.0D, p.field_70161_v + 16.0D);
/* 2475 */     List<EntityPlayer> l = p.field_70170_p.func_72872_a(EntityPlayer.class, aabb);
/* 2476 */     for (int i = 0; i < l.size(); i++) {
/*      */       
/* 2478 */       EntityPlayer entity2 = l.get(i);
/* 2479 */       PD.sendTo(new DBCPscouter2(c), (EntityPlayerMP)entity2);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleDBCscouter3(int c, EntityPlayer p) {
/* 2485 */     int n = 16;
/* 2486 */     AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(p.field_70165_t - 16.0D, p.field_70163_u - 16.0D, p.field_70161_v - 16.0D, p.field_70165_t + 16.0D, p.field_70163_u + 16.0D, p.field_70161_v + 16.0D);
/* 2487 */     List<EntityPlayer> l = p.field_70170_p.func_72872_a(EntityPlayer.class, aabb);
/* 2488 */     for (int i = 0; i < l.size(); i++) {
/*      */       
/* 2490 */       EntityPlayer entity2 = l.get(i);
/* 2491 */       PD.sendTo(new DBCPscouter3(c), (EntityPlayerMP)entity2);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleDBCscouter4(int c, EntityPlayer p) {
/* 2497 */     int n = 16;
/* 2498 */     AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(p.field_70165_t - 16.0D, p.field_70163_u - 16.0D, p.field_70161_v - 16.0D, p.field_70165_t + 16.0D, p.field_70163_u + 16.0D, p.field_70161_v + 16.0D);
/* 2499 */     List<EntityPlayer> l = p.field_70170_p.func_72872_a(EntityPlayer.class, aabb);
/* 2500 */     for (int i = 0; i < l.size(); i++) {
/*      */       
/* 2502 */       EntityPlayer entity2 = l.get(i);
/* 2503 */       PD.sendTo(new DBCPscouter4(c), (EntityPlayerMP)entity2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void soundPowerUp(EntityPlayer var4, String var2) {
/* 2512 */     var4.field_70170_p.func_72956_a((Entity)var4, var2, 0.15F, 1.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public NBTTagCompound nbt(EntityPlayer p, String s) {
/*      */     NBTTagCompound nbt;
/* 2518 */     if (s.contains("pres")) {
/*      */       
/* 2520 */       if (!p.getEntityData().func_74764_b("PlayerPersisted")) {
/* 2521 */         nbt = new NBTTagCompound();
/* 2522 */         p.getEntityData().func_74782_a("PlayerPersisted", (NBTBase)nbt);
/*      */       } else {
/* 2524 */         nbt = p.getEntityData().func_74775_l("PlayerPersisted");
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 2529 */       nbt = p.getEntityData();
/*      */     } 
/*      */     
/* 2532 */     return nbt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void closeInventoryChange(EntityPlayer p) {
/* 2537 */     p.field_71071_by.field_70459_e = false;
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\DBC\DBCPacketHandlerServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */