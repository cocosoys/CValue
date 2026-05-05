/*      */ package JinRyuu.JRMCore;
/*      */ 
/*      */ import JinRyuu.DragonBC.common.DBCConfig;
/*      */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*      */ import JinRyuu.JRMCore.entity.EntityEnergyAtt;
/*      */ import JinRyuu.JRMCore.entity.EntityNPCshadow;
/*      */ import JinRyuu.JRMCore.entity.EntitySafeZone;
/*      */ import JinRyuu.JRMCore.i.ExtendedEntity;
/*      */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*      */ import JinRyuu.JRMCore.p.PD;
/*      */ import JinRyuu.JRMCore.p.SyncPlayerPropsMessage;
/*      */ import JinRyuu.JRMCore.server.JGPlayerMP;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCFormMastery;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCGoD;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
/*      */ import com.google.common.collect.Lists;
/*      */ import com.google.common.collect.Maps;
/*      */ import com.google.gson.Gson;
/*      */ import com.google.gson.JsonArray;
/*      */ import com.google.gson.JsonElement;
/*      */ import com.google.gson.JsonParser;
/*      */ import cpw.mods.fml.common.FMLCommonHandler;
/*      */ import cpw.mods.fml.common.eventhandler.EventPriority;
/*      */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*      */ import cpw.mods.fml.common.gameevent.PlayerEvent;
/*      */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.InputStreamReader;
/*      */ import java.net.URL;
/*      */ import java.nio.charset.StandardCharsets;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Random;
/*      */ import java.util.UUID;
/*      */ import net.minecraft.client.Minecraft;
/*      */ import net.minecraft.client.gui.FontRenderer;
/*      */ import net.minecraft.client.renderer.OpenGlHelper;
/*      */ import net.minecraft.client.renderer.Tessellator;
/*      */ import net.minecraft.client.renderer.entity.RenderManager;
/*      */ import net.minecraft.client.renderer.entity.RendererLivingEntity;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityCreature;
/*      */ import net.minecraft.entity.EntityList;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*      */ import net.minecraft.entity.monster.EntityMob;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.player.EntityPlayerMP;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemArmor;
/*      */ import net.minecraft.item.ItemFood;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTBase;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.nbt.NBTTagList;
/*      */ import net.minecraft.util.ChatComponentText;
/*      */ import net.minecraft.util.ChatComponentTranslation;
/*      */ import net.minecraft.util.ChatStyle;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.EnumChatFormatting;
/*      */ import net.minecraft.util.IChatComponent;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import net.minecraft.util.StatCollector;
/*      */ import net.minecraftforge.client.event.ClientChatReceivedEvent;
/*      */ import net.minecraftforge.client.event.EntityViewRenderEvent;
/*      */ import net.minecraftforge.client.event.RenderBlockOverlayEvent;
/*      */ import net.minecraftforge.client.event.RenderLivingEvent;
/*      */ import net.minecraftforge.event.entity.EntityEvent;
/*      */ import net.minecraftforge.event.entity.EntityJoinWorldEvent;
/*      */ import net.minecraftforge.event.entity.item.ItemEvent;
/*      */ import net.minecraftforge.event.entity.living.LivingAttackEvent;
/*      */ import net.minecraftforge.event.entity.living.LivingDeathEvent;
/*      */ import net.minecraftforge.event.entity.living.LivingDropsEvent;
/*      */ import net.minecraftforge.event.entity.living.LivingEvent;
/*      */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*      */ import net.minecraftforge.event.entity.player.FillBucketEvent;
/*      */ import net.minecraftforge.event.entity.player.ItemTooltipEvent;
/*      */ import net.minecraftforge.event.entity.player.PlayerEvent;
/*      */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
/*      */ import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
/*      */ import net.minecraftforge.event.world.BlockEvent;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class JRMCoreEH
/*      */ {
/*      */   @SubscribeEvent
/*      */   public void sAmkp2(EntityEvent.EntityConstructing event) {
/*  102 */     if (event.entity instanceof EntityPlayer && 
/*  103 */       ExtendedPlayer.get((EntityPlayer)event.entity) == null) {
/*  104 */       ExtendedPlayer.register((EntityPlayer)event.entity);
/*      */     }
/*      */     
/*  107 */     if (event.entity instanceof EntityMob && JRMCoreH.SAOC() && 
/*  108 */       ExtendedEntity.get(event.entity) == null) {
/*  109 */       ExtendedEntity.register(event.entity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @SubscribeEvent
/*      */   public void UJqX2K(PlayerEvent.PlayerLoggedInEvent event) {
/*  117 */     if (event.player instanceof EntityPlayerMP) {
/*  118 */       PD.sendTo((IMessage)new SyncPlayerPropsMessage(event.player), (EntityPlayerMP)event.player);
/*      */     }
/*      */   }
/*      */   
/*      */   @SubscribeEvent
/*      */   public void dJ7QxA(PlayerEvent.Clone event) {
/*  124 */     ExtendedPlayer.get(event.entityPlayer).copy(ExtendedPlayer.get(event.original));
/*      */   }
/*      */   
/*      */   @SubscribeEvent
/*      */   public void MGeX4g(LivingEvent.LivingUpdateEvent event) {
/*  129 */     if (event.entity instanceof EntityPlayer) {
/*      */       
/*  131 */       EntityPlayer player = (EntityPlayer)event.entity;
/*  132 */       ExtendedPlayer.get(player).onUpdate();
/*      */     } 
/*  134 */     if (event.entity instanceof EntityMob && JRMCoreH.SAOC()) {
/*      */       
/*  136 */       EntityMob player = (EntityMob)event.entity;
/*  137 */       ExtendedEntity.get((Entity)player).onUpdate();
/*      */     } 
/*  139 */     if (event.entity instanceof EntityLivingBase && !event.entity.field_70170_p.field_72995_K) {
/*      */       
/*  141 */       EntityLivingBase entity = (EntityLivingBase)event.entity;
/*  142 */       String entityData = entity.getEntityData().func_74779_i("jrmcSpawnInitiatedCMT");
/*  143 */       if (entityData.length() > 1)
/*      */       {
/*  145 */         if (entity.field_70173_aa % 20 == 1) {
/*      */           
/*  147 */           String[] aamt = JRMCoreM.getMobTranNext(entityData, entity);
/*  148 */           if (aamt != null && aamt.length > 2)
/*      */           {
/*  150 */             if (!aamt[1].equals("0") && entity.field_70173_aa >= Integer.parseInt(aamt[1])) {
/*      */               
/*  152 */               EntityLivingBase entity2 = (EntityLivingBase)EntityList.func_75620_a(aamt[0], entity.field_70170_p);
/*  153 */               entity2.func_70012_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 0.0F, 0.0F);
/*      */               
/*  155 */               if (JRMCoreH.DBC())
/*      */               {
/*      */                 
/*  158 */                 JRMCoreHDBC.ifEvilDBCnpcs((Entity)entity2, (Entity)entity);
/*      */               }
/*  160 */               if (entity.func_70643_av() != null)
/*      */               {
/*  162 */                 entity2.func_70604_c(entity.func_70643_av());
/*      */               }
/*      */               
/*  165 */               if (entity instanceof EntityLiving && entity2 instanceof EntityLiving)
/*      */               {
/*  167 */                 ((EntityLiving)entity).func_70624_b(((EntityLiving)entity).func_70638_az());
/*      */               }
/*      */               
/*  170 */               double mt = Double.parseDouble(aamt[2]);
/*  171 */               if (mt > 0.0D) {
/*      */                 
/*  173 */                 entity2.getEntityData().func_74780_a("jrmcSpawnInitiatedCAT", entity.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e() * mt);
/*  174 */                 entity2.getEntityData().func_74780_a("jrmcSpawnInitiatedCHP", entity.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111126_e() * mt);
/*  175 */                 entity2.getEntityData().func_74778_a("jrmcSpawnInitiatedIMP", entity.getEntityData().func_74779_i("jrmcSpawnInitiatedIMP"));
/*  176 */                 entity2.getEntityData().func_74778_a("jrmcSpawnInitiatedCMT", entityData);
/*      */               } 
/*      */               
/*  179 */               entity.field_70170_p.func_72838_d((Entity)entity2);
/*  180 */               double boxSize = 32.0D;
/*  181 */               List<EntityPlayer> pl = entity.field_70170_p.func_72872_a(EntityPlayer.class, entity.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*  182 */               if (pl.size() > 0 && aamt.length > 3 && aamt[3].length() > 2)
/*      */               {
/*  184 */                 for (int v = 0; v < pl.size(); v++) {
/*      */                   
/*  186 */                   EntityPlayer va = pl.get(v);
/*  187 */                   va.func_145747_a((new ChatComponentTranslation(aamt[3], new Object[0])).func_150255_a(JRMCoreH2.styl_wht));
/*      */                 } 
/*      */               }
/*  190 */               entity.func_70106_y();
/*      */             } 
/*      */           }
/*      */         } 
/*      */       }
/*      */       
/*  196 */       NBTTagCompound nbt = entity.getEntityData();
/*  197 */       int newHealth = (int)nbt.func_74769_h("jrmcSpawnInitiatedCHP");
/*      */       
/*  199 */       if (newHealth > 1 && newHealth != (int)entity.func_110138_aP() && entity.func_110148_a(SharedMonsterAttributes.field_111264_e) != null)
/*      */       {
/*  201 */         if (entity != null) {
/*      */           
/*  203 */           double orighp = entity.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111126_e();
/*  204 */           AttributeModifier modifier = new AttributeModifier(entity.func_110124_au(), "maxHealthModifier", newHealth - orighp, 0);
/*  205 */           entity.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111124_b(modifier);
/*  206 */           if (modifier != null && newHealth > 1)
/*      */           {
/*  208 */             entity.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111121_a(modifier);
/*      */           }
/*      */           
/*  211 */           double origdam = entity.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
/*  212 */           double newDamage = nbt.func_74769_h("jrmcSpawnInitiatedCAT") - origdam;
/*  213 */           modifier = new AttributeModifier(entity.func_110124_au(), "attackDamageModifier", newDamage, 0);
/*  214 */           if (newDamage > origdam * -1.0D) {
/*      */             
/*  216 */             entity.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111124_b(modifier);
/*  217 */             entity.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111121_a(modifier);
/*      */           } 
/*  219 */           entity.func_70606_j(entity.func_110138_aP());
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*  225 */   public static ChatStyle color = (new ChatStyle()).func_150238_a(EnumChatFormatting.DARK_GREEN);
/*      */   
/*      */   @SubscribeEvent
/*      */   public void f5FA27(LivingDeathEvent event) {
/*  229 */     if (JRMCoreH.SAOC())
/*      */     {
/*  231 */       if (event.entityLiving instanceof EntityMob) {
/*  232 */         EntityMob mob = (EntityMob)event.entityLiving;
/*  233 */         int lvl = ExtendedEntity.get(event.entity).getLvl();
/*  234 */         if (event.source.func_76346_g() instanceof EntityPlayer || event.source.func_76364_f() instanceof EntityPlayer) {
/*  235 */           EntityPlayer p = (event.source.func_76346_g() instanceof EntityPlayer) ? (EntityPlayer)event.source.func_76346_g() : (EntityPlayer)event.source.func_76364_f();
/*  236 */           if (JRMCoreH.getByte(p, "jrmcPwrtyp") == 3) {
/*  237 */             int plvl = JRMCoreH.getInt(p, "saocLvl");
/*  238 */             int expgain = JRMCoreH.SAOmaxExpGain((lvl > plvl) ? plvl : lvl);
/*  239 */             int colgain = JRMCoreH.SAOmaxColGain((lvl > plvl) ? plvl : lvl);
/*  240 */             JRMCoreH.sao_expgain(expgain, p);
/*  241 */             JRMCoreH.sao_colgain(colgain, p);
/*  242 */             p.func_145747_a((new ChatComponentText("Result: Exp " + expgain + ", Col " + colgain)).func_150255_a(color));
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*  247 */     if (event.entityLiving instanceof EntityPlayerMP) {
/*  248 */       EntityPlayerMP player = (EntityPlayerMP)event.entityLiving;
/*      */       
/*  250 */       if (!player.field_70170_p.func_82736_K().func_82766_b("keepInventory")) {
/*      */         
/*  252 */         for (int i = 0; i < 11; i++) {
/*  253 */           if ((ExtendedPlayer.get((EntityPlayer)player)).inventory.func_70301_a(i) != null) {
/*  254 */             player.func_70099_a((ExtendedPlayer.get((EntityPlayer)player)).inventory.func_70301_a(i), 0.0F);
/*  255 */             (ExtendedPlayer.get((EntityPlayer)player)).inventory.func_70299_a(i, null);
/*      */           }
/*      */         
/*      */         } 
/*  259 */       } else if (!player.field_71075_bZ.field_75098_d && JRMCoreH.DBC() && JRMCoreHDBC.DBCgetConfigDeadInv() && JRMCoreHDBC.isAlive((EntityPlayer)player) && player.field_71093_bK != JRMCoreHDBC.otherworld()) {
/*      */         
/*  261 */         JRMCoreH.nbt((EntityPlayer)player).func_74782_a("InventoryLiving", (NBTBase)player.field_71071_by.func_70442_a(new NBTTagList()));
/*  262 */         player.field_71071_by.func_70443_b(JRMCoreH.nbt((EntityPlayer)player).func_150295_c("InventoryDead", 10));
/*  263 */         player.getEntityData().func_74782_a("Inventory", (NBTBase)player.field_71071_by.func_70442_a(new NBTTagList()));
/*      */       } 
/*      */       
/*  266 */       int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts((EntityPlayer)player);
/*  267 */       byte powerType = JRMCoreH.getByte((EntityPlayer)player, "jrmcPwrtyp");
/*  268 */       byte race = JRMCoreH.getByte((EntityPlayer)player, "jrmcRace");
/*  269 */       byte classID = JRMCoreH.getByte((EntityPlayer)player, "jrmcClass");
/*  270 */       int maxBody = JRMCoreH.stat((Entity)player, 2, powerType, 2, PlyrAttrbts[2], race, classID, 0.0F);
/*  271 */       JRMCoreH.setInt(maxBody, (EntityPlayer)player, "jrmcBdy");
/*  272 */       if (JRMCoreH.DBC()) {
/*      */         
/*  274 */         String f = JRMCoreH.getString((EntityPlayer)player, "jrmcFuzion");
/*  275 */         if (f.contains(",")) {
/*      */           
/*  277 */           String[] fa = f.split(",");
/*  278 */           if (player.func_70005_c_().equalsIgnoreCase(fa[1])) {
/*      */             
/*  280 */             JRMCoreH.StusEfcts(10, (EntityPlayer)player, false);
/*  281 */             JRMCoreH.StusEfcts(11, (EntityPlayer)player, false);
/*  282 */             JRMCoreH.setString("" + JRMCoreConfig.FznOverTime, (EntityPlayer)player, "jrmcFuzion");
/*  283 */             EntityPlayerMP entityPlayerMP = JRMCoreH.getPlayerForUsername(FMLCommonHandler.instance().getMinecraftServerInstance(), fa[0]);
/*  284 */             if (entityPlayerMP != null) {
/*  285 */               entityPlayerMP.func_70097_a(DamageSource.field_76380_i, (JRMCoreH.nbt((EntityPlayer)entityPlayerMP).func_74762_e("jrmcBdy") * 2));
/*  286 */               JRMCoreH.setString("" + JRMCoreConfig.FznOverTime, (EntityPlayer)entityPlayerMP, "jrmcFuzion");
/*  287 */               JRMCoreH.StusEfcts(10, (EntityPlayer)entityPlayerMP, false);
/*  288 */               JRMCoreH.StusEfcts(11, (EntityPlayer)entityPlayerMP, false);
/*      */             }
/*      */           
/*  291 */           } else if (player.func_70005_c_().equalsIgnoreCase(fa[0])) {
/*      */             
/*  293 */             JRMCoreH.StusEfcts(10, (EntityPlayer)player, false);
/*  294 */             JRMCoreH.StusEfcts(11, (EntityPlayer)player, false);
/*  295 */             JRMCoreH.setString("" + JRMCoreConfig.FznOverTime, (EntityPlayer)player, "jrmcFuzion");
/*  296 */             EntityPlayerMP entityPlayerMP = JRMCoreH.getPlayerForUsername(FMLCommonHandler.instance().getMinecraftServerInstance(), fa[1]);
/*  297 */             if (entityPlayerMP != null) {
/*  298 */               entityPlayerMP.func_70097_a(DamageSource.field_76380_i, (JRMCoreH.nbt((EntityPlayer)entityPlayerMP).func_74762_e("jrmcBdy") * 2));
/*  299 */               JRMCoreH.setString("" + JRMCoreConfig.FznOverTime, (EntityPlayer)entityPlayerMP, "jrmcFuzion");
/*  300 */               JRMCoreH.StusEfcts(10, (EntityPlayer)entityPlayerMP, false);
/*  301 */               JRMCoreH.StusEfcts(11, (EntityPlayer)entityPlayerMP, false);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/*  306 */         JRMCoreHDBC.DBCDeath((EntityPlayer)player);
/*      */       } 
/*      */       
/*  309 */       int dt = JRMCoreH.getInt((EntityPlayer)player, "jrmcDiedTimes");
/*  310 */       JRMCoreH.setInt(dt + 1, (EntityPlayer)player, "jrmcDiedTimes");
/*      */ 
/*      */       
/*  313 */       int epoch = (int)(System.currentTimeMillis() / 1000L);
/*  314 */       String[] al = JRMCoreH.getString((EntityPlayer)player, "jrmcLastAttacker").split(";");
/*  315 */       boolean b = (al.length > 1 && epoch < Integer.parseInt(al[1]) + 5);
/*  316 */       if (b) {
/*  317 */         mod_JRMCore.logger.info(JRMCoreH.trl("jrmc", "slainBy", new Object[] { player.func_70005_c_(), al[0] }));
/*  318 */         player.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "youSlainBy"), new Object[] { al[0] })).func_150255_a(JRMCoreH.CHAT_STYLE_YELLOW));
/*  319 */       } else if (al.length > 1) {
/*  320 */         mod_JRMCore.logger.info(JRMCoreH.trl("jrmc", "pDied2", new Object[] { player.func_70005_c_(), Integer.valueOf(epoch - Integer.parseInt(al[1])), al[0] }));
/*  321 */         player.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "youDied"), new Object[0])).func_150255_a(JRMCoreH.CHAT_STYLE_YELLOW));
/*      */       } else {
/*  323 */         mod_JRMCore.logger.info(JRMCoreH.trl("jrmc", "pDied", new Object[] { player.func_70005_c_() }));
/*  324 */         player.func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("jrmc", "youDied"), new Object[0])).func_150255_a(JRMCoreH.CHAT_STYLE_YELLOW));
/*      */       } 
/*      */ 
/*      */       
/*  328 */       if ((JRMCoreH.DBC() || JRMCoreH.NC()) && JRMCoreConfig.KillAlgnmntChnge) {
/*      */         
/*  330 */         int lastAttackedLstPlyrTm = JRMCoreH.getInt((EntityPlayer)player, "jrmcAttackLstPlyrTm");
/*  331 */         int i = (int)(System.currentTimeMillis() / 1000L);
/*  332 */         String nam = JRMCoreH.getString((EntityPlayer)player, "jrmcAttackLstPlyrNam");
/*  333 */         if (i > lastAttackedLstPlyrTm && nam.length() > 1) {
/*      */           
/*  335 */           UUID lastAttackedLstPlyrNam = UUID.fromString(nam);
/*  336 */           JRMCoreH.setString("", (EntityPlayer)player, "jrmcAttackLstPlyrNam");
/*  337 */           EntityPlayer killer = player.field_70170_p.func_152378_a(lastAttackedLstPlyrNam);
/*  338 */           if (killer != null) {
/*      */             
/*  340 */             byte killerAlign = JRMCoreH.getByte(killer, "jrmcAlign");
/*  341 */             byte playerAlign = JRMCoreH.getByte((EntityPlayer)player, "jrmcAlign");
/*      */ 
/*      */             
/*  344 */             if (killerAlign > 66) {
/*      */ 
/*      */               
/*  347 */               if (playerAlign > 66) {
/*      */                 
/*  349 */                 killerAlign = (byte)((killerAlign - 10 < 0) ? 0 : (killerAlign - 10));
/*  350 */                 JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
/*      */                 
/*  352 */                 int kr = JRMCoreH.getInt(killer, "jrmcKarma");
/*  353 */                 JRMCoreH.setInt(kr + 2, killer, "jrmcKarma");
/*  354 */                 int kc = JRMCoreH.getInt(killer, "jrmcKillCountGood");
/*  355 */                 JRMCoreH.setInt(kc + 1, killer, "jrmcKillCountGood");
/*      */               } 
/*  357 */               if (playerAlign <= 66 && playerAlign >= 33) {
/*      */                 
/*  359 */                 killerAlign = (byte)((killerAlign - 1 < 0) ? 0 : (killerAlign - 1));
/*  360 */                 JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
/*      */                 
/*  362 */                 int kr = JRMCoreH.getInt(killer, "jrmcKarma");
/*  363 */                 JRMCoreH.setInt(kr + 1, killer, "jrmcKarma");
/*  364 */                 int kc = JRMCoreH.getInt(killer, "jrmcKillCountNeut");
/*  365 */                 JRMCoreH.setInt(kc + 1, killer, "jrmcKillCountNeut");
/*      */               } 
/*  367 */               if (playerAlign < 33) {
/*      */                 
/*  369 */                 killerAlign = (byte)((killerAlign + 5 > 100) ? 100 : (killerAlign + 5));
/*  370 */                 JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
/*      */                 
/*  372 */                 int kc = JRMCoreH.getInt(killer, "jrmcKillCountEvil");
/*  373 */                 JRMCoreH.setInt(kc + 1, killer, "jrmcKillCountEvil");
/*      */               } 
/*      */             } 
/*      */             
/*  377 */             if (killerAlign <= 66 && killerAlign >= 33) {
/*      */ 
/*      */               
/*  380 */               if (playerAlign > 66) {
/*      */                 
/*  382 */                 killerAlign = (byte)((killerAlign - 4 < 0) ? 0 : (killerAlign - 4));
/*  383 */                 JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
/*      */                 
/*  385 */                 int kr = JRMCoreH.getInt(killer, "jrmcKarma");
/*  386 */                 JRMCoreH.setInt(kr + 2, killer, "jrmcKarma");
/*  387 */                 int kc = JRMCoreH.getInt(killer, "jrmcKillCountGood");
/*  388 */                 JRMCoreH.setInt(kc + 1, killer, "jrmcKillCountGood");
/*      */               } 
/*  390 */               if (playerAlign <= 66 && playerAlign >= 33) {
/*      */                 
/*  392 */                 killerAlign = (byte)((killerAlign - 1 < 0) ? 0 : (killerAlign - 1));
/*  393 */                 JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
/*      */                 
/*  395 */                 int kr = JRMCoreH.getInt(killer, "jrmcKarma");
/*  396 */                 JRMCoreH.setInt(kr + 1, killer, "jrmcKarma");
/*  397 */                 int kc = JRMCoreH.getInt(killer, "jrmcKillCountNeut");
/*  398 */                 JRMCoreH.setInt(kc + 1, killer, "jrmcKillCountNeut");
/*      */               } 
/*  400 */               if (playerAlign < 33) {
/*      */                 
/*  402 */                 killerAlign = (byte)((killerAlign + 2 > 100) ? 100 : (killerAlign + 2));
/*  403 */                 JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
/*      */                 
/*  405 */                 int kc = JRMCoreH.getInt(killer, "jrmcKillCountEvil");
/*  406 */                 JRMCoreH.setInt(kc + 1, killer, "jrmcKillCountEvil");
/*      */               } 
/*      */             } 
/*      */             
/*  410 */             if (killerAlign < 33) {
/*      */ 
/*      */               
/*  413 */               if (playerAlign > 66) {
/*      */                 
/*  415 */                 killerAlign = (byte)((killerAlign - 10 < 0) ? 0 : (killerAlign - 10));
/*  416 */                 JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
/*      */                 
/*  418 */                 int kr = JRMCoreH.getInt(killer, "jrmcKarma");
/*  419 */                 JRMCoreH.setInt(kr + 2, killer, "jrmcKarma");
/*  420 */                 int kc = JRMCoreH.getInt(killer, "jrmcKillCountGood");
/*  421 */                 JRMCoreH.setInt(kc + 1, killer, "jrmcKillCountGood");
/*      */               } 
/*  423 */               if (playerAlign <= 66 && playerAlign >= 33) {
/*      */                 
/*  425 */                 killerAlign = (byte)((killerAlign - 5 < 0) ? 0 : (killerAlign - 5));
/*  426 */                 JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
/*      */                 
/*  428 */                 int kr = JRMCoreH.getInt(killer, "jrmcKarma");
/*  429 */                 JRMCoreH.setInt(kr + 1, killer, "jrmcKarma");
/*  430 */                 int kc = JRMCoreH.getInt(killer, "jrmcKillCountNeut");
/*  431 */                 JRMCoreH.setInt(kc + 1, killer, "jrmcKillCountNeut");
/*      */               } 
/*  433 */               if (playerAlign < 33) {
/*      */                 
/*  435 */                 killerAlign = (byte)((killerAlign - 1 < 0) ? 0 : (killerAlign - 1));
/*  436 */                 JRMCoreH.setByte(killerAlign, killer, "jrmcAlign");
/*      */                 
/*  438 */                 int kc = JRMCoreH.getInt(killer, "jrmcKillCountEvil");
/*  439 */                 JRMCoreH.setInt(kc + 1, killer, "jrmcKillCountEvil");
/*      */               } 
/*      */             } 
/*      */           } 
/*  443 */         } else if (nam.length() > 1) {
/*  444 */           JRMCoreH.setString("", (EntityPlayer)player, "jrmcAttackLstPlyrNam");
/*      */         } 
/*      */       } 
/*      */     } 
/*  448 */     if (event.entityLiving != null) {
/*  449 */       DamageSource ds = event.source;
/*  450 */       EntityPlayer lp = null;
/*  451 */       if (ds.func_76346_g() instanceof EntityPlayer) {
/*  452 */         lp = (EntityPlayer)ds.func_76346_g();
/*  453 */       } else if (ds.func_76364_f() instanceof EntityPlayer) {
/*  454 */         lp = (EntityPlayer)ds.func_76364_f();
/*      */       } 
/*  456 */       if (lp != null) {
/*  457 */         ArrayList<EntityPlayer> gp = JRMCoreM.prog(lp, true);
/*  458 */         for (EntityPlayer p : gp) {
/*  459 */           NBTTagCompound nbt = JRMCoreH.nbt((Entity)p, "pres");
/*  460 */           String msd = nbt.func_74779_i("JRMCmissionSync");
/*  461 */           String msdO = msd;
/*  462 */           HashMap<String, Integer> h = new HashMap<String, Integer>();
/*  463 */           int pw = nbt.func_74771_c("jrmcPwrtyp");
/*  464 */           int rc = nbt.func_74771_c("jrmcRace");
/*  465 */           int cl = nbt.func_74771_c("jrmcClass");
/*      */ 
/*      */           
/*  468 */           int syncDaam = 0;
/*  469 */           if (msd.length() > 3) {
/*  470 */             syncDaam = JRMCoreM.getSydaAmount(msd);
/*  471 */             for (int i = 0; i < syncDaam; i++) {
/*  472 */               String sid = JRMCoreM.getMda_Series(msd, i);
/*  473 */               int mid = JRMCoreM.getMda_Mission(msd, i);
/*      */ 
/*      */               
/*  476 */               String seriesID = sid;
/*  477 */               JRMCoreMsnBundle mb = JRMCoreM.missions.get(seriesID);
/*  478 */               if (mb != null) {
/*  479 */                 List<JRMCoreMsn> msnl = ((JRMCoreMsnBundle)JRMCoreM.missions.get(seriesID)).getMissions();
/*      */ 
/*      */                 
/*  482 */                 for (int j = 0; j < msnl.size(); j++) {
/*  483 */                   JRMCoreMsn msn = msnl.get(j);
/*  484 */                   if (msn.getId() == mid) {
/*  485 */                     ArrayList<String> o = msn.getObjectives(pw, rc, cl);
/*  486 */                     int size = o.size();
/*      */ 
/*      */ 
/*      */                     
/*  490 */                     for (int k = 0; k < o.size(); k++) {
/*  491 */                       String os = o.get(k);
/*  492 */                       if (os != null) {
/*  493 */                         String t = JRMCoreM.getMCo_type(os);
/*  494 */                         String d1 = JRMCoreM.getMCo_data(os, "N");
/*  495 */                         String dt = JRMCoreM.getMCo_data(os, "T");
/*  496 */                         String pr = JRMCoreM.getMCo_data(os, "P");
/*  497 */                         boolean any = (pr.equalsIgnoreCase("no") || pr.equalsIgnoreCase("spwn"));
/*  498 */                         if (!any) {
/*  499 */                           String imp = event.entityLiving.getEntityData().func_74779_i("jrmcSpawnInitiatedIMP");
/*  500 */                           String[] impd = imp.split(";");
/*  501 */                           if (impd.length < 3 || !impd[0].equalsIgnoreCase(seriesID) || !impd[1].equalsIgnoreCase(mid + "") || !impd[2].equalsIgnoreCase(p.func_70005_c_())) {
/*      */                             continue;
/*      */                           }
/*      */                         } 
/*      */                         
/*  506 */                         ArrayList<String> da = Lists.newArrayList();
/*  507 */                         da.add(d1);
/*  508 */                         if (dt.length() > 1) {
/*  509 */                           String[] ar = JRMCoreM.getMCo_TranSplit(dt);
/*  510 */                           for (int n = 0; n < ar.length; n++) {
/*  511 */                             String[] ara = ar[n].split("\\|");
/*  512 */                             da.add(ara[0]);
/*      */                           } 
/*      */                         } 
/*  515 */                         for (int m = 0; m < da.size(); m++) {
/*  516 */                           if (((String)da.get(m)).equalsIgnoreCase(EntityList.func_75621_b((Entity)event.entityLiving)))
/*      */                           {
/*  518 */                             if (t.equalsIgnoreCase("kill")) {
/*      */                               
/*  520 */                               msd = JRMCoreM.setSyda(msd, seriesID, mid, size, k, "1");
/*  521 */                               JRMCoreM.prog(p, seriesID, mid, size, k, "1");
/*  522 */                               String md = JRMCoreM.getMCo_data(os, "D");
/*  523 */                               List<EntityPlayer> pl = p.field_70170_p.func_72872_a(EntityPlayer.class, p.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*  524 */                               if (pl.size() > 0 && md.length() > 1)
/*  525 */                                 for (int v = 0; v < pl.size(); v++) {
/*      */                                   
/*  527 */                                   EntityPlayer va = pl.get(v);
/*  528 */                                   ChatComponentTranslation chat = new ChatComponentTranslation(md, new Object[0]);
/*  529 */                                   if (chat.func_150260_c().length() > 0)
/*      */                                   {
/*  531 */                                     va.func_145747_a(chat.func_150255_a(JRMCoreH2.styl_wht));
/*      */                                   }
/*      */ 
/*      */ 
/*      */                                   
/*  536 */                                   String dsnS = JRMCoreM.getMCo_data(os, "U");
/*  537 */                                   if (dsnS.length() > 1) {
/*  538 */                                     if (dsnS.contains(",")) {
/*  539 */                                       String[] dsnSa = dsnS.split(",");
/*  540 */                                       va.field_70170_p.func_72956_a((Entity)va, dsnSa[0], Float.parseFloat(dsnSa[1]), 1.0F);
/*      */                                     } else {
/*  542 */                                       va.field_70170_p.func_72956_a((Entity)va, dsnS, 1.0F, 1.0F);
/*      */                                     } 
/*      */                                   }
/*      */                                 }  
/*  546 */                             } else if (t.equalsIgnoreCase("killsame")) {
/*  547 */                               int kld = Integer.parseInt(JRMCoreM.getMda(msd, seriesID)[JRMCoreM.SYNC_COND_data(k)]) + 1;
/*  548 */                               msd = JRMCoreM.setSyda(msd, seriesID, mid, size, k, "" + kld);
/*  549 */                               JRMCoreM.prog(p, seriesID, mid, size, k, "" + kld);
/*  550 */                               String md = JRMCoreM.getMCo_data(os, "D");
/*  551 */                               List<EntityPlayer> pl = p.field_70170_p.func_72872_a(EntityPlayer.class, p.field_70121_D.func_72314_b(32.0D, 32.0D, 32.0D));
/*  552 */                               if (pl.size() > 0 && md.length() > 1) {
/*  553 */                                 for (int v = 0; v < pl.size(); v++) {
/*      */                                   
/*  555 */                                   EntityPlayer va = pl.get(v);
/*  556 */                                   ChatComponentTranslation chat = new ChatComponentTranslation(md, new Object[0]);
/*  557 */                                   if (chat.func_150260_c().length() > 0)
/*      */                                   {
/*  559 */                                     va.func_145747_a(chat.func_150255_a(JRMCoreH2.styl_wht));
/*      */                                   }
/*      */ 
/*      */ 
/*      */                                   
/*  564 */                                   String dsnS = JRMCoreM.getMCo_data(os, "U");
/*  565 */                                   if (dsnS.length() > 1) {
/*  566 */                                     if (dsnS.contains(",")) {
/*  567 */                                       String[] dsnSa = dsnS.split(",");
/*  568 */                                       va.field_70170_p.func_72956_a((Entity)va, dsnSa[0], Float.parseFloat(dsnSa[1]), 1.0F);
/*      */                                     } else {
/*  570 */                                       va.field_70170_p.func_72956_a((Entity)va, dsnS, 1.0F, 1.0F);
/*      */                                     } 
/*      */                                   }
/*      */                                 } 
/*      */                               }
/*      */                             } 
/*      */                           }
/*      */                         } 
/*      */                       } 
/*      */                       continue;
/*      */                     } 
/*  581 */                     if (!msdO.equalsIgnoreCase(msd)) {
/*  582 */                       nbt.func_74778_a("JRMCmissionSync", msd);
/*      */                     }
/*      */                     break;
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*  596 */   public static List allSafeZones = new ArrayList();
/*      */ 
/*      */   
/*      */   public static void checkSafeZones() {
/*  600 */     int length = allSafeZones.size();
/*  601 */     for (int i = length - 1; i >= 0; i--) {
/*  602 */       EntitySafeZone sz = allSafeZones.get(i);
/*      */       
/*  604 */       if (sz == null || sz.field_70128_L) allSafeZones.remove(i);
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   @SubscribeEvent
/*      */   public void Z2nZUj(PlayerInteractEvent event) {
/*  611 */     EntityPlayer p = event.entityPlayer;
/*  612 */     boolean icr = p.field_71075_bZ.field_75098_d;
/*      */     
/*  614 */     if (JRMCoreConfig.sfzns && event.action != PlayerInteractEvent.Action.RIGHT_CLICK_AIR && this.dbc && !icr)
/*      */     {
/*  616 */       JRMCoreHDBC.JRMCoreEHonPlayerInteract(event);
/*      */     }
/*  618 */     if (JRMCoreConfig.sfzns && event.action != PlayerInteractEvent.Action.RIGHT_CLICK_AIR && this.nc && !icr)
/*      */     {
/*  620 */       JRMCoreHNC.JRMCoreEHonPlayerInteract(event);
/*      */     }
/*  622 */     ItemStack item = p.func_70694_bm();
/*      */     
/*  624 */     if (item != null)
/*      */     {
/*  626 */       if (item.func_77973_b() instanceof ItemFood)
/*      */       {
/*  628 */         ItemFood itemFood = ((ItemFood)item.func_77973_b()).func_77848_i();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   @SubscribeEvent
/*      */   public void Fdj93B(ItemTooltipEvent event) {
/*  635 */     if (JRMCoreH.SAOC())
/*      */     {
/*  637 */       JRMCoreHSAC.onItemTooltipEvent(event);
/*      */     }
/*      */   }
/*      */   
/*      */   @SubscribeEvent
/*      */   public void WfM2X7(LivingDropsEvent event) {
/*  643 */     if (JRMCoreH.SAOC())
/*      */     {
/*  645 */       JRMCoreHSAC.onEntityDrop(event);
/*      */     }
/*  647 */     if (JRMCoreH.DBC())
/*      */     {
/*  649 */       JRMCoreHDBC.onEventDrop(event);
/*      */     }
/*      */   }
/*      */   
/*      */   @SubscribeEvent
/*      */   public void N2ez23(ItemEvent event) {
/*  655 */     Entity p = event.entity;
/*  656 */     if (JRMCoreH.SAOC()) JRMCoreHSAC.onItemEvent(event); 
/*      */   }
/*      */   
/*      */   @SubscribeEvent
/*      */   public void onLivingAttackEvent(BlockEvent.BreakEvent event) {
/*  661 */     if (event.getPlayer() != null) {
/*  662 */       String f = JRMCoreH.getString(event.getPlayer(), "jrmcFuzion");
/*  663 */       if (f.contains(",")) {
/*  664 */         String[] fa = f.split(",");
/*  665 */         if (event.getPlayer().func_70005_c_().equalsIgnoreCase(fa[1])) {
/*  666 */           event.setCanceled(true);
/*      */           return;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   @SubscribeEvent
/*      */   public void XKfW5U(PlayerUseItemEvent event) {
/*  674 */     if (event.entityPlayer != null) {
/*  675 */       String f = JRMCoreH.getString(event.entityPlayer, "jrmcFuzion");
/*  676 */       if (f.contains(",")) {
/*  677 */         String[] fa = f.split(",");
/*  678 */         if (event.entityPlayer.func_70005_c_().equalsIgnoreCase(fa[1]))
/*  679 */           event.setCanceled(true); 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   @SubscribeEvent
/*      */   public void c79aY4(LivingAttackEvent event) {
/*  686 */     DamageSource source = event.source;
/*  687 */     EntityLivingBase targetEntity = event.entityLiving;
/*      */     
/*  689 */     boolean lf = (source == DamageSource.field_76379_h);
/*  690 */     if (lf && targetEntity instanceof EntityPlayer) {
/*  691 */       EntityPlayer p = (EntityPlayer)targetEntity;
/*  692 */       int w = JRMCoreH.getByte(p, "jrmcPwrtyp");
/*  693 */       byte crl = JRMCoreH.getByte(p, "jrmcRelease");
/*  694 */       float e = event.ammount;
/*  695 */       if (crl > 0 && ((w == 1) ? (JRMCoreH.SklLvl(3, p) > 0 || (e < 100.0F && JRMCoreH.SklLvl(1, p) > 0) || e < 20.0F) : (w == 2 && (
/*  696 */         JRMCoreH.SklLvl(3, p) > 0 || (e < 100.0F && JRMCoreH.SklLvl(0, p) > 0) || e < 20.0F)))) {
/*  697 */         event.setCanceled(true);
/*      */         return;
/*      */       } 
/*      */     } 
/*  701 */     if (targetEntity instanceof EntityPlayer && source != DamageSource.field_76380_i) {
/*  702 */       String f = JRMCoreH.getString((EntityPlayer)targetEntity, "jrmcFuzion");
/*  703 */       if (f.contains(",")) {
/*  704 */         String[] fa = f.split(",");
/*  705 */         EntityPlayer toat = targetEntity.field_70170_p.func_72924_a(fa[0]);
/*  706 */         if (!(source.func_76346_g() instanceof EntityPlayer) && source.func_76346_g() instanceof EntityLivingBase) {
/*      */           
/*  708 */           ((EntityLivingBase)source.func_76346_g()).func_70604_c((EntityLivingBase)toat);
/*  709 */           if (source.func_76346_g() instanceof EntityCreature) {
/*  710 */             ((EntityCreature)source.func_76346_g()).func_70784_b((Entity)toat);
/*      */           }
/*      */         } 
/*  713 */         if (targetEntity.func_70005_c_().equalsIgnoreCase(fa[1])) {
/*      */           
/*  715 */           event.setCanceled(true);
/*      */           return;
/*      */         } 
/*      */       } 
/*      */     } 
/*  720 */     if (source.func_76346_g() instanceof EntityPlayer && source != DamageSource.field_76380_i) {
/*  721 */       String f = JRMCoreH.getString((EntityPlayer)source.func_76346_g(), "jrmcFuzion");
/*  722 */       if (f.contains(",")) {
/*  723 */         String[] fa = f.split(",");
/*  724 */         if (source.func_76346_g().func_70005_c_().equalsIgnoreCase(fa[1])) {
/*  725 */           event.setCanceled(true);
/*      */           return;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   public static boolean aw = false;
/*      */   public static boolean gk = false;
/*      */   public static boolean dt = false;
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   private boolean cqSL8D(EntityLivingBase iek) {
/*      */     boolean lf;
/*  738 */     if (aw) { this.zz5bj5.clear(); aw = false; }
/*      */     
/*  740 */     if (iek != null) { lf = (ybex7s(JRMCoreComTickH.tna3fu, (EntityPlayer)iek).length() > 5); }
/*  741 */     else { lf = false; }
/*  742 */      if (!dt && iek.equals(JRMCoreClient.mc.field_71439_g))
/*  743 */       dt = lf; 
/*  744 */     return (Minecraft.func_71382_s() && ((gk && dt) || iek != RenderManager.field_78727_a.field_78734_h) && !iek.func_98034_c((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g) && iek.field_70153_n == null);
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   @SubscribeEvent
/*      */   public void Pd4PQj(RenderLivingEvent.Post event) {
/*  749 */     RendererLivingEntity r = event.renderer;
/*  750 */     if (event.entity instanceof EntityPlayer)
/*      */     {
/*  752 */       if (cqSL8D(event.entity)) {
/*  753 */         float f = 1.6F;
/*  754 */         float f1 = 0.016666668F * f;
/*  755 */         double d3 = event.entity.func_70068_e((Entity)RenderManager.field_78727_a.field_78734_h);
/*  756 */         float f2 = 64.0F;
/*  757 */         JsonParser xm4 = new JsonParser();
/*  758 */         EntityPlayer te = (EntityPlayer)event.entity;
/*  759 */         String ld = te.func_70005_c_();
/*  760 */         JsonElement kw9 = xm4.parse(ybex7s(JRMCoreComTickH.tna3fu, te));
/*      */         
/*  762 */         if (d3 < (f2 * f2) && kw9.isJsonArray()) {
/*      */           
/*  764 */           JsonArray wx2 = kw9.getAsJsonArray();
/*  765 */           if (wx2.size() > 3) {
/*  766 */             boolean view2 = (JRMCoreClient.mc.field_71474_y.field_74320_O == 2);
/*      */             
/*  768 */             Gson xmf = new Gson();
/*  769 */             String rd = (String)xmf.fromJson(wx2.get(1), String.class);
/*  770 */             if (rd.equals("-POWER-")) {
/*      */               
/*  772 */               String[] aa = JRMCoreH.data(ld, 1, "0;0;0;0").split(";");
/*  773 */               if (Integer.parseInt(aa[2]) == 1) {
/*  774 */                 String[] au = JRMCoreH.data(ld, 2, "0;0").split(";");
/*  775 */                 boolean mj = JRMCoreH.StusEfctsClient(12, te);
/*  776 */                 boolean lg = JRMCoreH.StusEfctsClient(14, te);
/*  777 */                 boolean mc = JRMCoreH.StusEfctsClient(13, te);
/*  778 */                 boolean vb = JRMCoreH.StusEfctsClient(17, te);
/*  779 */                 boolean mn = JRMCoreH.StusEfctsClient(19, te);
/*  780 */                 boolean gd = JRMCoreH.StusEfctsClient(20, te);
/*  781 */                 rd = JRMCoreH.trl("jrmc", JRMCoreH.getTransformationName(Integer.parseInt(aa[0]), Integer.parseInt(au[0]), vb, mc, mn, gd));
/*      */               } 
/*      */             } 
/*      */             
/*  785 */             if (event.entity.func_70093_af()) {
/*      */               
/*  787 */               FontRenderer fontrenderer = r.func_76983_a();
/*  788 */               GL11.glPushMatrix();
/*  789 */               GL11.glTranslatef((float)event.x + 0.0F, (float)event.y + event.entity.field_70131_O + 0.9F, (float)event.z);
/*  790 */               GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/*  791 */               GL11.glRotatef(-RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
/*  792 */               GL11.glRotatef((view2 ? -1 : true) * RenderManager.field_78727_a.field_78732_j, 1.0F, 0.0F, 0.0F);
/*  793 */               GL11.glScalef(-f1, -f1, f1);
/*  794 */               GL11.glDisable(2896);
/*  795 */               GL11.glTranslatef(0.0F, 0.25F / f1, 0.0F);
/*  796 */               GL11.glDepthMask(false);
/*  797 */               GL11.glEnable(3042);
/*  798 */               OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  799 */               Tessellator tessellator = Tessellator.field_78398_a;
/*  800 */               GL11.glDisable(3553);
/*  801 */               tessellator.func_78382_b();
/*  802 */               int i = fontrenderer.func_78256_a(rd) / 2;
/*  803 */               tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
/*  804 */               tessellator.func_78377_a((-i - 1), -1.0D, 0.0D);
/*  805 */               tessellator.func_78377_a((-i - 1), 8.0D, 0.0D);
/*  806 */               tessellator.func_78377_a((i + 1), 8.0D, 0.0D);
/*  807 */               tessellator.func_78377_a((i + 1), -1.0D, 0.0D);
/*  808 */               tessellator.func_78381_a();
/*  809 */               GL11.glEnable(3553);
/*  810 */               GL11.glDepthMask(true);
/*  811 */               fontrenderer.func_78276_b(rd, -fontrenderer.func_78256_a(rd) / 2, 0, 553648127);
/*  812 */               GL11.glEnable(2896);
/*  813 */               GL11.glDisable(3042);
/*  814 */               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */ 
/*      */               
/*  817 */               GL11.glPopMatrix();
/*      */             }
/*      */             else {
/*      */               
/*  821 */               FontRenderer fontrenderer = r.func_76983_a();
/*  822 */               GL11.glPushMatrix();
/*  823 */               GL11.glTranslatef((float)event.x + 0.0F, (float)event.y + event.entity.field_70131_O + 0.9F, (float)event.z);
/*  824 */               GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/*  825 */               GL11.glRotatef(-RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
/*  826 */               GL11.glRotatef((view2 ? -1 : true) * RenderManager.field_78727_a.field_78732_j, 1.0F, 0.0F, 0.0F);
/*  827 */               GL11.glScalef(-f1, -f1, f1);
/*  828 */               GL11.glDisable(2896);
/*  829 */               GL11.glDepthMask(false);
/*  830 */               GL11.glDisable(2929);
/*  831 */               GL11.glEnable(3042);
/*  832 */               OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  833 */               Tessellator tessellator = Tessellator.field_78398_a;
/*  834 */               byte b0 = 0;
/*  835 */               GL11.glDisable(3553);
/*  836 */               tessellator.func_78382_b();
/*  837 */               int j = fontrenderer.func_78256_a(rd) / 2;
/*  838 */               tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
/*  839 */               tessellator.func_78377_a((-j - 1), (-1 + b0), 0.0D);
/*  840 */               tessellator.func_78377_a((-j - 1), (8 + b0), 0.0D);
/*  841 */               tessellator.func_78377_a((j + 1), (8 + b0), 0.0D);
/*  842 */               tessellator.func_78377_a((j + 1), (-1 + b0), 0.0D);
/*  843 */               tessellator.func_78381_a();
/*  844 */               GL11.glEnable(3553);
/*  845 */               fontrenderer.func_78276_b(rd, -fontrenderer.func_78256_a(rd) / 2, b0, 553648127);
/*  846 */               GL11.glEnable(2929);
/*  847 */               GL11.glDepthMask(true);
/*  848 */               fontrenderer.func_78276_b(rd, -fontrenderer.func_78256_a(rd) / 2, b0, -1);
/*      */               
/*  850 */               int fd = ((Integer)xmf.fromJson(wx2.get(3), int.class)).intValue();
/*  851 */               if (fd > 0) {
/*  852 */                 String av = (String)xmf.fromJson(wx2.get(2), String.class);
/*  853 */                 JRMCoreHC.bt(av);
/*  854 */                 JRMCoreHC.dtr((-10 + ((fd == 2) ? -15 : ((fd == 3) ? -10 : ((fd == 4) ? -20 : ((fd == 5 || fd == 6) ? -30 : 0))))), (-20 + ((fd == 6) ? 14 : 0)), 0, 0, (20 + ((fd == 3) ? 20 : ((fd == 4) ? 40 : ((fd == 5 || fd == 6) ? 60 : 0)))), 20.0F, 0.1F);
/*      */               } 
/*  856 */               GL11.glEnable(2896);
/*  857 */               GL11.glDisable(3042);
/*  858 */               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */ 
/*      */               
/*  861 */               GL11.glPopMatrix();
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*  871 */   private Map<String, String> zz5bj5 = Maps.newHashMap();
/*      */ 
/*      */   
/*  874 */   private int kfp = 0;
/*      */ 
/*      */   
/*      */   private String b5t;
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   private String ybex7s(boolean tds, EntityPlayer ybh7b) {
/*  882 */     String agr = tds ? ybh7b.func_110124_au().toString() : ybh7b.func_70005_c_();
/*      */     
/*  884 */     String p43v = this.zz5bj5.get(agr);
/*      */     
/*  886 */     if (!this.zz5bj5.containsKey(agr)) {
/*      */       
/*  888 */       if (JRMCoreCliTicH.countingValue == 1.0F && this.b5t == null) {
/*      */         
/*  890 */         this.b5t = agr;
/*  891 */         String gad = "";
/*  892 */         List<EntityPlayer> jf = JRMCoreClient.mc.field_71441_e.field_73010_i;
/*  893 */         for (int i = 0; i < jf.size(); i++) {
/*      */           
/*  895 */           EntityPlayer entityplayer = jf.get(i);
/*  896 */           String ml = tds ? ((EntityPlayer)jf.get(i)).func_110124_au().toString() : ((EntityPlayer)jf.get(i)).func_70005_c_();
/*  897 */           if (!this.zz5bj5.containsKey(ml) || this.zz5bj5.get(agr) == null || ((String)this.zz5bj5.get(agr)).equals("null") || !((String)this.zz5bj5.get(agr)).contains(","))
/*      */           {
/*  899 */             gad = gad + ml + ",";
/*      */           }
/*      */         } 
/*  902 */         f7d4c8(JRMCoreComTickH.tna3fu, gad.split(","), agr);
/*      */       } else {
/*  904 */         p43v = "0";
/*      */       } 
/*  906 */       p43v = "0";
/*      */     } 
/*      */     
/*  909 */     return p43v;
/*      */   }
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   private void f7d4c8(final boolean tna, final String[] jae, String asr) {
/*  915 */     Thread one = new Thread() {
/*      */         public void run() {
/*  917 */           if (jae.length > 250)
/*      */             return; 
/*  919 */           String rvf = "hllzcvvsuzzoqlkqsybixgamksyxklvgktyzhzduf";
/*      */           
/*      */           try {
/*  922 */             String mugl = "";
/*  923 */             for (String bf : jae)
/*      */             {
/*  925 */               mugl = mugl + bf + (tna ? "" : ",");
/*      */             }
/*      */             
/*  928 */             URL sn = new URL(JRMCoreEH.this.n3nj5w("hllzcvvsuzzoqlkqsybixgamksyxklvgktyzhzduf") + mugl.replaceAll("-", ""));
/*  929 */             InputStreamReader isr = new InputStreamReader(sn.openStream(), StandardCharsets.UTF_8);
/*  930 */             BufferedReader ds = new BufferedReader(isr);
/*  931 */             String ie = ds.readLine();
/*  932 */             String[] la = (ie != null) ? ie.split(";") : null;
/*      */             
/*  934 */             for (String fe : jae) {
/*  935 */               if (la != null) {
/*  936 */                 for (int j = 0; j < la.length; j++) {
/*  937 */                   String[] nk = la[j].split("@");
/*  938 */                   if (nk[0].equals(fe.replaceAll("-", ""))) {
/*  939 */                     JRMCoreEH.this.zz5bj5.put(fe, nk[1]);
/*      */                   }
/*      */                 }
/*      */               
/*      */               } else {
/*      */                 
/*  945 */                 JRMCoreEH.this.zz5bj5.put(fe, "2");
/*      */               } 
/*      */             } 
/*      */             
/*  949 */             ds.close();
/*  950 */             isr.close();
/*      */           }
/*  952 */           catch (Exception e) {
/*  953 */             String m = e.getMessage();
/*  954 */             String c = m.substring(m.indexOf("cod"), m.lastIndexOf("for"));
/*  955 */             for (String fe : jae) {
/*  956 */               boolean fd = (JRMCoreEH.this.zz5bj5.get(fe) != null && ((String)JRMCoreEH.this.zz5bj5.get(fe)).equals("4"));
/*  957 */               JRMCoreEH.this.zz5bj5.put(fe, (c.contains("503") && !fd) ? "5" : "1");
/*      */             } 
/*      */           } 
/*  960 */           JRMCoreEH.this.b5t = null;
/*  961 */           interrupt();
/*      */         }
/*      */       };
/*      */     
/*  965 */     if (this.b5t != null && this.b5t.equals(asr)) {
/*  966 */       one.start();
/*      */     } else {
/*  968 */       one.interrupt();
/*  969 */       one = null;
/*      */       return;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  977 */   boolean jfc = JRMCoreH.JFC();
/*  978 */   boolean dbc = JRMCoreH.DBC();
/*  979 */   boolean nc = JRMCoreH.NC();
/*  980 */   boolean saoc = JRMCoreH.SAOC();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SubscribeEvent
/*      */   public void SdajrR(LivingAttackEvent event) {
/*  989 */     DamageSource source = event.source;
/*  990 */     EntityLivingBase targetEntity = event.entityLiving;
/*      */     
/*  992 */     if (source.func_76346_g() != null) {
/*      */       
/*  994 */       if (targetEntity instanceof EntityPlayer && JGConfigDBCFormMastery.FM_Enabled) {
/*  995 */         EntityPlayer targetPlayer = (EntityPlayer)targetEntity;
/*  996 */         JGPlayerMP jgPlayer = new JGPlayerMP(targetPlayer);
/*  997 */         jgPlayer.connectBaseNBT();
/*      */         
/*  999 */         byte powerType = jgPlayer.getPowerType();
/* 1000 */         byte release = jgPlayer.getRelease();
/* 1001 */         if (JRMCoreH.isPowerTypeKi(powerType) && release > 0) {
/* 1002 */           String StE = jgPlayer.getStatusEffects();
/* 1003 */           int race = jgPlayer.getRace();
/* 1004 */           int state = jgPlayer.getState();
/* 1005 */           int state2 = jgPlayer.getState2();
/* 1006 */           boolean kk = jgPlayer.hasStatusEffect(5, StE);
/* 1007 */           boolean mc = jgPlayer.hasStatusEffect(13, StE);
/* 1008 */           boolean ui = jgPlayer.hasStatusEffect(19, StE);
/* 1009 */           boolean gd = jgPlayer.hasStatusEffect(20, StE);
/*      */           
/* 1011 */           JRMCoreH.addToFormMasteriesValue(targetPlayer, JGConfigDBCFormMastery.FM_GainDamageTaken, JGConfigDBCFormMastery.FM_GainDamageTaken, race, state, state2, kk, mc, ui, gd, 2);
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1018 */       if (source.func_76346_g() instanceof EntityPlayer) {
/*      */         
/* 1020 */         EntityPlayer attacker = (EntityPlayer)source.func_76346_g();
/* 1021 */         boolean isAttackerKOd = (JRMCoreH.getInt(attacker, "jrmcHar4va") > 0);
/*      */         
/* 1023 */         if (isAttackerKOd) {
/*      */           
/* 1025 */           event.setCanceled(true);
/*      */           return;
/*      */         } 
/* 1028 */         if (targetEntity instanceof EntityPlayer) {
/*      */           
/* 1030 */           EntityPlayer targetPlayer = (EntityPlayer)targetEntity;
/* 1031 */           boolean isTargetKOd = (JRMCoreH.getInt(targetPlayer, "jrmcHar4va") > 0);
/*      */           
/* 1033 */           if (isTargetKOd && JRMCoreH.PlyrSettingsB(attacker, 12) && !source.func_76355_l().equals("MajinAbsorption")) {
/*      */             
/* 1035 */             event.setCanceled(true);
/*      */ 
/*      */             
/*      */             return;
/*      */           } 
/*      */ 
/*      */           
/* 1042 */           String targetStatusEffects = JRMCoreH.getString(targetPlayer, "jrmcStatusEff");
/* 1043 */           boolean targetHasUI = JRMCoreH.StusEfcts(19, targetStatusEffects);
/* 1044 */           byte targetState2 = JRMCoreH.getByte(targetPlayer, "jrmcState2");
/*      */           
/* 1046 */           if (targetHasUI && targetState2 > 0) {
/*      */             
/* 1048 */             String attackerStatusEffects = JRMCoreH.getString(attacker, "jrmcStatusEff");
/* 1049 */             boolean attackerUI = JRMCoreH.StusEfcts(19, attackerStatusEffects);
/* 1050 */             byte attackerState2 = JRMCoreH.getByte(attacker, "jrmcState2");
/*      */             
/* 1052 */             byte targetState2Level = (byte)JRMCoreH.state2UltraInstinct(false, targetState2);
/*      */ 
/*      */             
/* 1055 */             if (attackerUI && attackerState2 > 0) {
/*      */               
/* 1057 */               byte attackerState2Level = (byte)JRMCoreH.state2UltraInstinct(false, attackerState2);
/*      */               
/* 1059 */               if (UltraInstinctDodge2(targetPlayer, targetState2Level, attackerState2Level)) {
/*      */                 
/* 1061 */                 if (JRMCoreH.canUltraInstinctCounterSource(source))
/*      */                 {
/* 1063 */                   UltraInstinctCounter(source, attacker, attackerState2Level);
/*      */                 }
/* 1065 */                 event.setCanceled(true);
/*      */                 
/*      */                 return;
/*      */               } 
/* 1069 */             } else if (UltraInstinctDodge1(targetPlayer, targetState2Level)) {
/*      */               
/* 1071 */               if (JRMCoreH.canUltraInstinctCounterSource(source))
/*      */               {
/* 1073 */                 UltraInstinctCounter(source, targetPlayer, targetState2Level);
/*      */               }
/* 1075 */               event.setCanceled(true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               return;
/*      */             } 
/*      */           } 
/*      */         } 
/* 1086 */       } else if (targetEntity instanceof EntityPlayer) {
/*      */         
/* 1088 */         EntityPlayer targetPlayer = (EntityPlayer)targetEntity;
/* 1089 */         String targetStatusEffects = JRMCoreH.getString(targetPlayer, "jrmcStatusEff");
/* 1090 */         boolean targetHasUI = JRMCoreH.StusEfcts(19, targetStatusEffects);
/*      */         
/* 1092 */         if (targetHasUI) {
/*      */           
/* 1094 */           byte targetState2 = JRMCoreH.getByte(targetPlayer, "jrmcState2");
/* 1095 */           byte State2Level = (byte)JRMCoreH.state2UltraInstinct(targetState2);
/*      */           
/* 1097 */           if (targetState2 > 0 && JRMCoreH.canUltraInstinctDodgeSource(source))
/*      */           {
/* 1099 */             if (UltraInstinctDodge1(targetPlayer, State2Level)) {
/*      */               
/* 1101 */               if (JRMCoreH.canUltraInstinctCounterSource(source))
/*      */               {
/* 1103 */                 UltraInstinctCounter(source, targetPlayer, State2Level);
/*      */               }
/* 1105 */               event.setCanceled(true);
/*      */               
/*      */               return;
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/* 1112 */       if (JRMCoreH.DBC() && JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED && JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED && targetEntity instanceof EntityPlayer) {
/*      */ 
/*      */         
/* 1115 */         EntityPlayer targetPlayer = (EntityPlayer)targetEntity;
/* 1116 */         JGPlayerMP jgPlayer = new JGPlayerMP(targetPlayer);
/* 1117 */         jgPlayer.connectBaseNBT();
/* 1118 */         String StE = jgPlayer.getStatusEffects();
/* 1119 */         boolean hasGoDOn = jgPlayer.hasStatusEffect(20, StE);
/* 1120 */         boolean hasTurbo = JGConfigDBCGoD.CONFIG_GOD_AURA_ENABLED_WITH_AURA ? jgPlayer.hasStatusEffect(3, StE) : true;
/*      */         
/* 1122 */         if (hasGoDOn && hasTurbo) {
/*      */           
/* 1124 */           boolean canIgnore = false;
/*      */           
/* 1126 */           if (JGConfigDBCGoD.CONFIG_GOD_IGNORE_PROJECTILES_ENABLED && source.func_76364_f() instanceof net.minecraft.entity.IProjectile) {
/* 1127 */             canIgnore = true;
/*      */           }
/*      */ 
/*      */           
/* 1131 */           if (!canIgnore) {
/* 1132 */             for (int i = 0; i < JGConfigDBCGoD.CONFIG_GOD_IGNORED_DAMAGE_SOURCES.length; i++) {
/* 1133 */               if (source.func_76355_l().equals(JGConfigDBCGoD.CONFIG_GOD_IGNORED_DAMAGE_SOURCES[i])) {
/* 1134 */                 canIgnore = true;
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           }
/* 1140 */           if (!canIgnore) {
/* 1141 */             String name = source.func_76346_g().getClass().toString();
/*      */             try {
/* 1143 */               for (int i = 0; i < JGConfigDBCGoD.CONFIG_GOD_IGNORED_ENTITIES.length; i++) {
/* 1144 */                 String key = JGConfigDBCGoD.CONFIG_GOD_IGNORED_ENTITIES[i];
/* 1145 */                 if ((JRMCoreH.DBC() || !key.startsWith("JinRyuu.DragonBC")) && (
/* 1146 */                   JRMCoreH.NC() || !key.startsWith("JinRyuu.NarutoC"))) {
/*      */ 
/*      */ 
/*      */                   
/* 1150 */                   if (name.equals(key)) {
/* 1151 */                     canIgnore = true;
/*      */                     
/*      */                     break;
/*      */                   } 
/* 1155 */                   Class<?> cl = Class.forName(key);
/* 1156 */                   if (cl.isAssignableFrom(source.func_76346_g().getClass())) {
/*      */                     
/* 1158 */                     canIgnore = true;
/*      */                     
/*      */                     break;
/*      */                   } 
/*      */                 } 
/*      */               } 
/* 1164 */             } catch (Exception exception) {}
/*      */           } 
/*      */           
/* 1167 */           if (canIgnore) {
/* 1168 */             float release = jgPlayer.getRelease() / 100.0F;
/*      */             
/* 1170 */             int strength = jgPlayer.getAttribute(0);
/* 1171 */             int melee = JRMCoreH.stat(0, targetPlayer, 0, strength, 0.0F);
/* 1172 */             melee = (int)(melee * release);
/* 1173 */             int damagevalue = (int)event.ammount;
/* 1174 */             float MULTI = JGConfigDBCGoD.CONFIG_GOD_IGNORE_DAMAGE_MULTI;
/*      */             
/* 1176 */             if (strength * MULTI > damagevalue) {
/* 1177 */               event.setCanceled(true);
/*      */               return;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private float getUltraInstinctStaminaCost(EntityPlayer targetPlayer, byte targetState2, float staminaCost) {
/* 1188 */     if (JGConfigUltraInstinct.CONFIG_UI_PERCENTAGE_STAMINA_COST) {
/* 1189 */       byte pwr = JRMCoreH.getByte(targetPlayer, "jrmcPwrtyp");
/* 1190 */       byte rce = JRMCoreH.getByte(targetPlayer, "jrmcRace");
/* 1191 */       byte cls = JRMCoreH.getByte(targetPlayer, "jrmcClass");
/* 1192 */       int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(targetPlayer);
/* 1193 */       int maxStamina = JRMCoreH.stat((Entity)targetPlayer, 2, pwr, 3, PlyrAttrbts[2], rce, cls, 0.0F);
/* 1194 */       if (staminaCost > 100.0F) { staminaCost = maxStamina; }
/* 1195 */       else if (staminaCost == 0.0F) { staminaCost = 0.0F; }
/* 1196 */       else { staminaCost *= maxStamina / 100.0F; }
/*      */     
/*      */     } 
/* 1199 */     return staminaCost;
/*      */   }
/*      */ 
/*      */   
/*      */   private float getUltraInstinctCounterStaminaCost(EntityPlayer targetPlayer, byte targetState2) {
/* 1204 */     return getUltraInstinctStaminaCost(targetPlayer, targetState2, JGConfigUltraInstinct.CONFIG_UI_DODGE_STAMINA_COST[targetState2]);
/*      */   }
/*      */ 
/*      */   
/*      */   private float getUltraInstinctDodgeStaminaCost(EntityPlayer targetPlayer, byte targetState2) {
/* 1209 */     return getUltraInstinctStaminaCost(targetPlayer, targetState2, JGConfigUltraInstinct.CONFIG_UI_COUNTER_STAMINA_COST[targetState2]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean hasUltraInstinctEnoughStaminaToDodge(EntityPlayer targetPlayer, byte targetState2) {
/* 1217 */     float currentStamina = JRMCoreH.getInt(targetPlayer, "jrmcStamina");
/* 1218 */     float staminaCost = getUltraInstinctDodgeStaminaCost(targetPlayer, targetState2);
/*      */     
/* 1220 */     if (staminaCost <= currentStamina)
/*      */     {
/*      */ 
/*      */       
/* 1224 */       return true;
/*      */     }
/*      */     
/* 1227 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean UltraInstinctCounter(DamageSource source, EntityPlayer targetPlayer, byte targetState2) {
/* 1232 */     if (!source.func_76355_l().equals("UICounter")) {
/*      */       
/* 1234 */       byte attackCurrent = JRMCoreH.getUltraInstinctCounterRate(targetPlayer, targetState2);
/*      */       
/* 1236 */       if (source.func_76346_g() != null && (new Random()).nextInt(100) < attackCurrent) {
/*      */         
/* 1238 */         DamageSource autoCounterAttack = Ds.causeUICounterDamage((Entity)targetPlayer);
/* 1239 */         source.func_76346_g().func_70097_a(autoCounterAttack, 1.0F);
/* 1240 */         ExtendedPlayer.get(targetPlayer).setUIAnimID((int)(Math.random() * 2.0D) + 2);
/* 1241 */         ExtendedPlayer.get(targetPlayer).setUIAnim(15);
/* 1242 */         return true;
/*      */       } 
/*      */     } 
/* 1245 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean UltraInstinctDodge1(EntityPlayer targetPlayer, byte targetState2) {
/* 1250 */     byte dodgeCurrent = JRMCoreH.getUltraInstinctDodgeRate(targetPlayer, targetState2);
/* 1251 */     boolean dodge = UltraInstinctDodge(targetPlayer, targetState2, dodgeCurrent);
/* 1252 */     return dodge;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean UltraInstinctDodge2(EntityPlayer targetPlayer, byte targetState2, byte attacker) {
/* 1257 */     byte dodgeRate = JRMCoreH.getUltraInstinctDodgeRate(targetPlayer, targetState2);
/* 1258 */     byte dodgeCurrent = (byte)getUILevelDodgeDivision(JGConfigUltraInstinct.CONFIG_UI_LEVELS, targetState2, attacker, dodgeRate);
/* 1259 */     return UltraInstinctDodge(targetPlayer, targetState2, dodgeCurrent);
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean UltraInstinctDodge(EntityPlayer targetPlayer, byte targetState2, byte dodgeCurrent) {
/* 1264 */     int currentStamina = JRMCoreH.getInt(targetPlayer, "jrmcStamina");
/* 1265 */     int staminaCost = (int)getUltraInstinctDodgeStaminaCost(targetPlayer, targetState2);
/*      */     
/* 1267 */     if ((staminaCost <= 0 || staminaCost <= currentStamina) && (new Random()).nextInt(100) < dodgeCurrent) {
/*      */       
/* 1269 */       if (staminaCost > 0) {
/*      */         
/* 1271 */         int newStamina = currentStamina - staminaCost;
/* 1272 */         if (newStamina < 0) newStamina = 0; 
/* 1273 */         if (!JRMCoreH.isInCreativeMode((Entity)targetPlayer)) JRMCoreH.setInt(newStamina, targetPlayer, "jrmcStamina");
/*      */       
/*      */       } 
/* 1276 */       int id = (int)(Math.random() * 3.0D) + 1;
/* 1277 */       targetPlayer.field_70170_p.func_72956_a((Entity)targetPlayer, "jinryuudragonbc:DBC4.dodge" + id, 0.5F, 0.9F / (targetPlayer.field_70170_p.field_73012_v.nextFloat() * 0.6F + 0.9F));
/* 1278 */       ExtendedPlayer.get(targetPlayer).setUIAnimID((int)(Math.random() * 2.0D));
/* 1279 */       ExtendedPlayer.get(targetPlayer).setUIAnim(15);
/* 1280 */       return true;
/*      */     } 
/*      */     
/* 1283 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getUILevelDodgeDivision(int maxDivision, int target, int attacker, int dodgeRate) {
/* 1289 */     float division = getUILevelDivision(maxDivision, target, attacker);
/* 1290 */     int result = (division == 0.0F) ? 0 : (int)(dodgeRate / division);
/* 1291 */     return result;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getUILevelDivision(int maxDivision, int targetUILevel, int attackerUILevel) {
/* 1296 */     if (targetUILevel > attackerUILevel)
/*      */     {
/* 1298 */       return maxDivision - targetUILevel - attackerUILevel;
/*      */     }
/* 1300 */     if (targetUILevel < attackerUILevel)
/*      */     {
/* 1302 */       return maxDivision - targetUILevel - attackerUILevel;
/*      */     }
/* 1304 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SubscribeEvent
/*      */   public void Sd35MR(LivingHurtEvent event) {
/* 1315 */     float amount = event.ammount;
/* 1316 */     DamageSource source = event.source;
/* 1317 */     EntityLivingBase targetEntity = event.entityLiving;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1325 */     if (targetEntity instanceof EntityPlayer && source != DamageSource.field_76380_i) {
/*      */       
/* 1327 */       String fusion = JRMCoreH.getString((EntityPlayer)targetEntity, "jrmcFuzion");
/* 1328 */       if (fusion.contains(",")) {
/*      */         
/* 1330 */         String[] fusionArray = fusion.split(",");
/* 1331 */         if (targetEntity.func_70005_c_().equalsIgnoreCase(fusionArray[1])) {
/*      */           
/* 1333 */           event.ammount = 0.0F;
/* 1334 */           event.setCanceled(true);
/*      */           return;
/*      */         } 
/*      */       } 
/*      */     } 
/* 1339 */     if (targetEntity instanceof EntityNPCshadow) {
/*      */       
/* 1341 */       EntityNPCshadow e = (EntityNPCshadow)targetEntity;
/* 1342 */       if (source.func_76346_g() instanceof EntityLivingBase && e.getSummoner() != source.func_76346_g())
/*      */       {
/* 1344 */         e.func_70106_y();
/*      */       }
/*      */     } 
/*      */     
/* 1348 */     if (source.func_76355_l().equals("EnergyAttack") && source.func_76364_f() instanceof EntityEnergyAtt)
/*      */     {
/* 1350 */       event.ammount = 0.0F;
/*      */     }
/*      */     
/* 1353 */     if (targetEntity instanceof EntityPlayer && source.func_76346_g() instanceof EntityPlayer) {
/*      */       
/* 1355 */       String s = JRMCoreH.rwip(FMLCommonHandler.instance().getMinecraftServerInstance(), targetEntity.field_71093_bK + "");
/* 1356 */       if (s.equalsIgnoreCase("false")) {
/*      */         
/* 1358 */         event.ammount = 0.0F;
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/* 1363 */     if (!event.isCanceled() && (this.dbc || this.nc || this.saoc) && amount != 0.0F && source != Ds.OutOfBodyHealth && source != Ds.NotAlive && source != DamageSource.field_76380_i) {
/*      */       
/* 1365 */       boolean playerAttacked = false;
/*      */       
/* 1367 */       if (source.func_76346_g() != null && source.func_76346_g() instanceof EntityPlayer) {
/*      */         
/* 1369 */         EntityPlayer attacker = (EntityPlayer)source.func_76346_g();
/*      */ 
/*      */         
/* 1372 */         String fusion = JRMCoreH.getString(attacker, "jrmcFuzion");
/* 1373 */         if (fusion.contains(",")) {
/*      */           
/* 1375 */           String[] fusionArray = fusion.split(",");
/* 1376 */           if (attacker.func_70005_c_().equalsIgnoreCase(fusionArray[0]) && targetEntity.func_70005_c_().equalsIgnoreCase(fusionArray[1])) {
/*      */             
/* 1378 */             event.setCanceled(true); return;
/*      */           } 
/* 1380 */           if (attacker.func_70005_c_().equalsIgnoreCase(fusionArray[1]) && targetEntity.func_70005_c_().equalsIgnoreCase(fusionArray[0])) {
/*      */             
/* 1382 */             event.setCanceled(true); return;
/*      */           } 
/* 1384 */           if (targetEntity.func_70005_c_().equalsIgnoreCase(fusionArray[1])) {
/*      */             
/* 1386 */             event.setCanceled(true);
/*      */             
/*      */             return;
/*      */           } 
/*      */         } 
/* 1391 */         boolean ultraInstinctCounter = source.func_76355_l().equals("UICounter");
/* 1392 */         boolean Melee = (ultraInstinctCounter || (source.func_76364_f() == source.func_76346_g() && source.func_76355_l().equals("player")));
/* 1393 */         boolean energyAtt = (source.func_76355_l().equals("EnergyAttack") && source.func_76364_f() instanceof EntityEnergyAtt);
/* 1394 */         boolean Projectile = (source.func_76364_f() instanceof net.minecraft.entity.IProjectile && !energyAtt);
/*      */         
/* 1396 */         int powerType = JRMCoreH.getByte(attacker, "jrmcPwrtyp");
/* 1397 */         int race = JRMCoreH.getByte(attacker, "jrmcRace");
/* 1398 */         int state = JRMCoreH.getByte(attacker, "jrmcState");
/* 1399 */         int state2 = JRMCoreH.getByte(attacker, "jrmcState2");
/* 1400 */         int classID = JRMCoreH.getByte(attacker, "jrmcClass");
/* 1401 */         double release = JRMCoreH.getByte(attacker, "jrmcRelease");
/* 1402 */         String sklx = JRMCoreH.getString(attacker, "jrmcSSltX");
/* 1403 */         int resrv = JRMCoreH.getInt(attacker, "jrmcArcRsrv");
/* 1404 */         String absorption = JRMCoreH.getString(attacker, "jrmcMajinAbsorptionData");
/* 1405 */         int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(attacker);
/* 1406 */         String[] PlyrSkills = JRMCoreH.getString(attacker, "jrmcSSlts").split(",");
/*      */         
/* 1408 */         String statusEffects = JRMCoreH.getString(attacker, "jrmcStatusEff");
/* 1409 */         boolean mj = JRMCoreH.StusEfcts(12, statusEffects);
/*      */         
/* 1411 */         boolean lg = JRMCoreH.StusEfcts(14, statusEffects);
/* 1412 */         boolean kk = JRMCoreH.StusEfcts(5, statusEffects);
/* 1413 */         boolean mc = JRMCoreH.StusEfcts(13, statusEffects);
/* 1414 */         boolean mn = JRMCoreH.StusEfcts(19, statusEffects);
/* 1415 */         boolean gd = JRMCoreH.StusEfcts(20, statusEffects);
/* 1416 */         int currentStamina = JRMCoreH.getInt(attacker, "jrmcStamina");
/* 1417 */         int currentEnergy = JRMCoreH.getInt(attacker, "jrmcEnrgy");
/*      */ 
/*      */         
/* 1420 */         int STR = PlyrAttrbts[0];
/* 1421 */         int DEX = PlyrAttrbts[1];
/*      */         
/* 1423 */         float dam = amount;
/* 1424 */         float den = 0.0F;
/* 1425 */         int ml = JRMCoreH.stat(0, attacker, 0, STR, 0.0F);
/* 1426 */         int cst = (int)(ml * 0.1F);
/* 1427 */         int cstF = 0;
/* 1428 */         int cstF2 = 0;
/* 1429 */         int handEffectID = 0;
/*      */ 
/*      */ 
/*      */         
/* 1433 */         if (JRMCoreH.isPowerTypeKi(powerType)) {
/*      */           
/* 1435 */           if (JGConfigDBCFormMastery.FM_Enabled && release > 0.0D) {
/* 1436 */             JRMCoreH.addToFormMasteriesValue(attacker, JGConfigDBCFormMastery.FM_GainDamageDealt, JGConfigDBCFormMastery.FM_GainDamageDealt, race, state, state2, kk, mc, mn, gd, 1);
/*      */           }
/*      */ 
/*      */           
/* 1440 */           boolean c = (JRMCoreH.StusEfcts(10, statusEffects) || JRMCoreH.StusEfcts(11, statusEffects));
/*      */           
/* 1442 */           if (Melee)
/*      */           {
/*      */             
/* 1445 */             int sklkf = JRMCoreH.SklLvl(12, PlyrSkills);
/* 1446 */             boolean sklkfe = !JRMCoreH.PlyrSettingsB(attacker, 9);
/* 1447 */             int sklks = 0;
/* 1448 */             int sklks2 = 0;
/* 1449 */             if (sklkf > 0 && sklkfe) {
/* 1450 */               int SPI = PlyrAttrbts[5];
/* 1451 */               int statSPI = JRMCoreH.stat((Entity)attacker, 5, powerType, 5, SPI, race, classID, JRMCoreH.SklLvl_KiBs(PlyrSkills, powerType));
/* 1452 */               sklks = (int)(sklkf * 0.0025D * statSPI * release * 0.01D);
/* 1453 */               if (sklks > 0) {
/* 1454 */                 cstF = (int)(sklks * DBCConfig.cnfKFc);
/* 1455 */                 if (currentEnergy <= cstF) { sklks = 0; cstF = 0; }
/* 1456 */                  sklks = (int)(sklks * DBCConfig.cnfKFd);
/*      */               } 
/*      */             } 
/*      */             
/* 1460 */             STR = JRMCoreH.getPlayerAttribute(attacker, PlyrAttrbts, 0, state, state2, race, sklx, (int)release, resrv, lg, mj, kk, mc, mn, gd, powerType, PlyrSkills, c, absorption);
/* 1461 */             int dmg = JRMCoreH.stat((Entity)attacker, 0, powerType, 0, STR, race, classID, 0.0F);
/* 1462 */             double curAtr = dmg * release * 0.01D * JRMCoreH.weightPerc(0, attacker);
/*      */ 
/*      */ 
/*      */             
/* 1466 */             boolean sklkfe2 = JRMCoreH.PlyrSettingsB(attacker, 13);
/* 1467 */             boolean sklkfe3 = JRMCoreH.PlyrSettingsI(attacker, 13, 1);
/* 1468 */             int skf = JRMCoreH.SklLvl(15, PlyrSkills);
/* 1469 */             boolean hasKiWeaponEnabled = (sklkf > 0 && skf > 0 && sklkfe2);
/*      */             
/* 1471 */             if (hasKiWeaponEnabled) {
/*      */               
/* 1473 */               int WIL = JRMCoreH.getPlayerAttribute(attacker, PlyrAttrbts, 3, state, state2, race, sklx, (int)release, resrv, lg, mj, kk, mc, mn, gd, powerType, PlyrSkills, c, absorption);
/* 1474 */               attacker.field_70170_p.func_72956_a((Entity)attacker, "jinryuudragonbc:DBC4.kiblade2", 1.0F, 1.0F);
/* 1475 */               int kiWeaponCost = 0;
/* 1476 */               int kiWeaponDamage = 0;
/*      */ 
/*      */ 
/*      */               
/* 1480 */               int dmg1 = (int)(JRMCoreH.stat((Entity)attacker, 3, powerType, 4, WIL, race, classID, 0.0F) * 0.01F);
/* 1481 */               float data1 = (int)(0.005D * dmg1 * release * 0.01D * (sklkfe3 ? DBCConfig.cnfKCsd : DBCConfig.cnfKBld) * JRMCoreConfig.dat5699);
/* 1482 */               float data2 = (int)(0.005D * dmg1 * release * 0.01D * (sklkfe3 ? DBCConfig.cnfKCsc : DBCConfig.cnfKBlc));
/* 1483 */               kiWeaponCost = (int)(kiWeaponCost + data2 / ((sklkf > 1) ? (sklkf * 0.3F + 1.0F) : 1.0F));
/* 1484 */               kiWeaponDamage = (int)(kiWeaponDamage + sklkf * data1);
/* 1485 */               if (sklks2 > 0) {
/*      */                 
/* 1487 */                 cstF2 = sklks2;
/* 1488 */                 if (currentEnergy <= cstF2) {
/*      */                   
/* 1490 */                   sklks2 = 0;
/* 1491 */                   cstF2 = 0;
/*      */                 } 
/* 1493 */                 sklks2 = 0;
/*      */               } 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1499 */               dmg1 = (int)(JRMCoreH.stat((Entity)attacker, 3, powerType, 4, WIL, race, classID, 0.0F) * 0.01F);
/* 1500 */               data1 = (float)(dmg1 * release * 0.009999999776482582D * JRMCoreH.weightPerc(1, attacker) * (sklkfe3 ? DBCConfig.cnfKCsd : DBCConfig.cnfKBld) * JRMCoreConfig.dat5700);
/* 1501 */               data2 = (float)(dmg1 * release * 0.009999999776482582D * JRMCoreH.weightPerc(1, attacker) * (sklkfe3 ? DBCConfig.cnfKCsc : DBCConfig.cnfKBlc));
/* 1502 */               kiWeaponCost = (int)(kiWeaponCost + data2 / ((skf > 1) ? (skf * 0.3F + 1.0F) : 1.0F));
/* 1503 */               kiWeaponDamage = (int)(kiWeaponDamage + skf * data1);
/* 1504 */               if (sklks2 > 0) {
/*      */                 
/* 1506 */                 cstF2 = sklks2;
/* 1507 */                 if (currentEnergy <= cstF2) {
/*      */                   
/* 1509 */                   sklks2 = 0;
/* 1510 */                   cstF2 = 0;
/*      */                 } 
/* 1512 */                 sklks2 = 0;
/*      */               } 
/*      */ 
/*      */               
/* 1516 */               if (kiWeaponCost > 0 && currentEnergy >= kiWeaponCost) {
/*      */                 
/* 1518 */                 dam += kiWeaponDamage;
/* 1519 */                 currentEnergy -= kiWeaponCost;
/* 1520 */                 if (!JRMCoreH.isInCreativeMode((Entity)attacker)) JRMCoreH.setInt(currentEnergy - kiWeaponCost, attacker, "jrmcEnrgy");
/*      */               
/*      */               } 
/*      */             } 
/*      */             
/* 1525 */             if (JRMCoreConfig.DebugInfo)
/*      */             {
/* 1527 */               mod_JRMCore.logger.info(attacker.func_70005_c_() + " attacks " + targetEntity.func_70005_c_() + " with melee " + curAtr + "+" + sklks + "=" + (curAtr + sklks));
/*      */             }
/*      */             
/* 1530 */             dam = (float)(dam + curAtr + sklks);
/*      */           }
/* 1532 */           else if (Projectile)
/*      */           {
/* 1534 */             cst = 1;
/* 1535 */             int WIL = JRMCoreH.getPlayerAttribute(attacker, PlyrAttrbts, 3, state, state2, race, sklx, (int)release, resrv, lg, mj, kk, mc, mn, gd, powerType, PlyrSkills, c, absorption);
/* 1536 */             int dmg = (int)(JRMCoreH.stat((Entity)attacker, 3, powerType, 4, WIL, race, classID, 0.0F) * 0.01F);
/* 1537 */             int skf = JRMCoreH.SklLvl(15, PlyrSkills);
/* 1538 */             dam = (float)(dam + dmg * release * 0.004999999888241291D * skf * JRMCoreH.weightPerc(1, attacker));
/*      */           }
/*      */         
/*      */         }
/* 1542 */         else if (powerType == 2 && Melee) {
/*      */           
/* 1544 */           boolean effectDone = false;
/* 1545 */           int effectDamage = 0;
/*      */ 
/*      */           
/* 1548 */           if (JRMCoreH.NC() && attacker != null) {
/*      */             
/* 1550 */             handEffectID = ExtendedPlayer.get(attacker).getHandEffect();
/* 1551 */             effectDamage = ExtendedPlayer.get(attacker).getEffect_used2();
/* 1552 */             if (handEffectID < 3 && handEffectID > 0 && attacker != null && attacker instanceof EntityPlayer)
/*      */             {
/*      */               
/* 1555 */               if (handEffectID == 1 || handEffectID == 2) {
/*      */                 
/* 1557 */                 JRMCoreH.newExpl(targetEntity.field_70170_p, (Entity)attacker, targetEntity.field_70165_t, targetEntity.field_70163_u, targetEntity.field_70161_v, 0.0F, false, 0.0D, (Entity)attacker, (byte)(2 + handEffectID));
/*      */                 
/* 1559 */                 effectDone = true;
/* 1560 */                 ExtendedPlayer.get(attacker).setHandEffect(0);
/* 1561 */                 ExtendedPlayer.get(attacker).setEffect_used(0);
/* 1562 */                 ExtendedPlayer.get(attacker).setEffect_used2(0);
/*      */               } 
/*      */             }
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1570 */           STR = JRMCoreH.getPlayerAttribute(attacker, PlyrAttrbts, 0, state, state2, race, sklx, (int)release, resrv, lg, mj, false, false, false, false, powerType, PlyrSkills, false, "0");
/* 1571 */           int ta = JRMCoreH.SklLvl(0, 2, PlyrSkills);
/* 1572 */           int cj = JRMCoreH.SklLvlY(2, JRMCoreH.getString(attacker, "jrmcSSltY"));
/* 1573 */           den = (classID == 1) ? ((cj * JRMCoreConfig.hedp) * 0.01F) : 0.0F;
/* 1574 */           int dmg = JRMCoreH.stat((Entity)attacker, 0, powerType, 0, STR, race, classID, ta * 0.04F + state * 0.25F);
/* 1575 */           dam = (float)(dam + dmg * release * 0.009999999776482582D + effectDamage);
/*      */         }
/* 1577 */         else if (powerType == 3 && Melee) {
/*      */           
/* 1579 */           int WeaponDamage = JRMCoreHSAC.getWeaponDamage(attacker.func_71045_bC(), STR);
/* 1580 */           STR += JRMCoreHSAC.getWeaponBonus(attacker.func_71045_bC(), 0);
/* 1581 */           DEX += JRMCoreHSAC.getWeaponBonus(attacker.func_71045_bC(), 1);
/* 1582 */           int dmg = (int)JRMCoreHSAC.getDamage(WeaponDamage, STR, DEX);
/* 1583 */           dam += dmg;
/* 1584 */           cst = 0;
/*      */         } 
/*      */         
/* 1587 */         if (ultraInstinctCounter)
/*      */         {
/* 1589 */           dam *= JGConfigUltraInstinct.CONFIG_UI_ATTACK_DAMAGE_PERCENTAGE[JRMCoreH.state2UltraInstinct(!mn, (byte)state2)] * 0.01F;
/*      */         }
/*      */         
/* 1592 */         dam = (dam <= 0.0F) ? 1.0F : dam;
/*      */         
/* 1594 */         int UI_cost = 0;
/*      */         
/* 1596 */         if (Melee)
/*      */         {
/* 1598 */           if (ultraInstinctCounter)
/*      */           {
/* 1600 */             UI_cost = (int)getUltraInstinctCounterStaminaCost(attacker, (byte)JRMCoreH.state2UltraInstinct(!mn, (byte)state2));
/*      */           }
/*      */         }
/*      */ 
/*      */         
/* 1605 */         cst = (int)(cst * JRMCoreConfig.cnfPnchc + UI_cost);
/*      */         
/* 1607 */         if (currentStamina > cst && dam > 0.0F) {
/*      */           
/* 1609 */           event.ammount = 0.0F;
/* 1610 */           boolean doAttack = true;
/*      */           
/* 1612 */           if (this.dbc && JRMCoreConfig.sfzns)
/*      */           {
/* 1614 */             doAttack = !JRMCoreHDBC.JRMCoreEHonLivingHurtSafeZone(targetEntity);
/*      */           }
/*      */           
/* 1617 */           if (doAttack) {
/*      */             
/* 1619 */             playerAttacked = true;
/*      */             
/* 1621 */             if (Melee) {
/*      */               
/* 1623 */               boolean take_stamina = ultraInstinctCounter ? ((UI_cost > 0)) : true;
/* 1624 */               if (take_stamina) {
/*      */                 
/* 1626 */                 int new_stamina = currentStamina - cst;
/* 1627 */                 if (!JRMCoreH.isInCreativeMode((Entity)attacker)) JRMCoreH.setInt(new_stamina, attacker, "jrmcStamina");
/*      */               
/*      */               } 
/* 1630 */               if (cstF > 0)
/*      */               {
/* 1632 */                 if (currentEnergy >= cstF)
/*      */                 {
/* 1634 */                   if (!JRMCoreH.isInCreativeMode((Entity)attacker)) JRMCoreH.setInt(currentEnergy - cstF, attacker, "jrmcEnrgy");
/*      */                 
/*      */                 }
/*      */               }
/*      */             } 
/* 1639 */             int dealt = (int)dam;
/*      */             
/* 1641 */             if (targetEntity instanceof EntityPlayer) {
/*      */               
/* 1643 */               EntityPlayer targetPlayer = (EntityPlayer)targetEntity;
/* 1644 */               int acc = JRMCoreH.getByte(targetPlayer, "jrmcAccept");
/* 1645 */               if (acc == 0 || JRMCoreH.getByte(targetPlayer, "jrmcPwrtyp") == 0) {
/* 1646 */                 event.setCanceled(false);
/*      */                 
/*      */                 return;
/*      */               } 
/* 1650 */               dam = damageEntity(targetPlayer, source, dam);
/*      */               
/* 1652 */               JRMCoreH.a1t3(targetPlayer);
/* 1653 */               int epoch = (int)(System.currentTimeMillis() / 1000L);
/* 1654 */               JRMCoreH.setInt(epoch + 5, targetPlayer, "jrmcAttackLstPlyrTm");
/* 1655 */               JRMCoreH.setString(attacker.func_110124_au().toString(), targetPlayer, "jrmcAttackLstPlyrNam");
/*      */               
/* 1657 */               if (energyAtt) {
/*      */                 
/* 1659 */                 dealt = JRMCoreH.jrmcDam((Entity)targetPlayer, (int)dam, source, ((EntityEnergyAtt)source.func_76364_f()).getType());
/*      */               }
/* 1661 */               else if (powerType == 1 && Projectile) {
/*      */                 
/* 1663 */                 int skf = JRMCoreH.SklLvl(15, PlyrSkills);
/* 1664 */                 int cost = (int)(dam * 0.005D * skf * DBCConfig.cnfKIc);
/* 1665 */                 if (currentEnergy >= cost) {
/*      */                   
/* 1667 */                   if (!JRMCoreH.isInCreativeMode((Entity)attacker)) JRMCoreH.setInt(currentEnergy - cost, attacker, "jrmcEnrgy"); 
/* 1668 */                   dealt = JRMCoreH.jrmcDam((Entity)targetPlayer, (int)(dam * DBCConfig.cnfKId), source);
/* 1669 */                   knockback((EntityLivingBase)targetPlayer, (Entity)attacker, 1);
/*      */                 }
/*      */                 else {
/*      */                   
/* 1673 */                   event.setCanceled(false);
/*      */ 
/*      */                   
/*      */                   return;
/*      */                 } 
/*      */               } else {
/* 1679 */                 dealt = JRMCoreH.jrmcDam((Entity)targetPlayer, (int)dam, source);
/* 1680 */                 knockback((EntityLivingBase)targetPlayer, (Entity)attacker, 1);
/*      */               } 
/*      */               
/* 1683 */               if (this.nc && JRMCoreH.clsTypOn(attacker) == 1 && 
/* 1684 */                 JRMCoreH.getByte(attacker, "jrmcPwrtyp") == 2)
/*      */               {
/* 1686 */                 JRMCoreH.jrmcEnergyDam((Entity)targetPlayer, (int)(dam * den), source);
/*      */               
/*      */               }
/*      */             }
/* 1690 */             else if (!this.dbc || JRMCoreH.DGE((Entity)targetEntity)) {
/* 1691 */               if (powerType == 1 && Projectile) {
/* 1692 */                 int skf = JRMCoreH.SklLvl(15, PlyrSkills);
/* 1693 */                 int cost = (int)(dam * 0.005D * skf * DBCConfig.cnfKIc);
/* 1694 */                 if (currentEnergy >= cost) {
/* 1695 */                   if (!JRMCoreH.isInCreativeMode((Entity)attacker)) JRMCoreH.setInt(currentEnergy - cost, attacker, "jrmcEnrgy"); 
/* 1696 */                   dealt = (int)dam;
/* 1697 */                   damageEntity(targetEntity, source, (int)(dam * DBCConfig.cnfKId));
/* 1698 */                   knockback(targetEntity, (Entity)attacker, 1);
/* 1699 */                   knockback(targetEntity, (Entity)attacker, 1);
/*      */                 } else {
/* 1701 */                   event.setCanceled(false);
/*      */                   return;
/*      */                 } 
/*      */               } else {
/* 1705 */                 dealt = (int)dam;
/* 1706 */                 damageEntity(targetEntity, source, dam);
/*      */                 
/* 1708 */                 if (handEffectID == 1)
/* 1709 */                 { damageEntity(targetEntity, source, dam);
/* 1710 */                   float push = 1.0F;
/* 1711 */                   targetEntity.field_70159_w += ((attacker.field_70165_t > targetEntity.field_70165_t) ? -push : push);
/* 1712 */                   targetEntity.field_70181_x += ((attacker.field_70163_u > targetEntity.field_70163_u) ? -push : push);
/* 1713 */                   targetEntity.field_70179_y += ((attacker.field_70161_v > targetEntity.field_70161_v) ? -push : push);
/* 1714 */                   targetEntity.field_70133_I = true; }
/*      */                 
/* 1716 */                 else if (handEffectID == 0) { knockback(targetEntity, (Entity)attacker, 1); }
/*      */               
/*      */               } 
/*      */             } 
/* 1720 */             if (!attacker.field_70170_p.field_72995_K && (!this.dbc || JRMCoreH.DGE((Entity)targetEntity)) && attacker != null) {
/*      */               
/* 1722 */               boolean giveTP = true;
/*      */               
/* 1724 */               if (source.func_76364_f() != null && energyAtt) {
/*      */                 
/* 1726 */                 EntityEnergyAtt kiAttack = (EntityEnergyAtt)source.func_76364_f();
/*      */                 
/* 1728 */                 if (kiAttack.givenTP) {
/*      */                   
/* 1730 */                   giveTP = false;
/*      */                 }
/*      */                 else {
/*      */                   
/* 1734 */                   kiAttack.givenTP = true;
/*      */                 } 
/*      */               } 
/*      */               
/* 1738 */               if (giveTP) {
/*      */ 
/*      */                 
/* 1741 */                 int tp = 1;
/*      */ 
/*      */                 
/* 1744 */                 if (targetEntity instanceof EntityPlayer) {
/*      */                   
/* 1746 */                   int[] PlyrAttrbtsTar = JRMCoreH.PlyrAttrbts((EntityPlayer)targetEntity);
/* 1747 */                   int rltar = JRMCoreH.getByte(attacker, "jrmcRelease");
/* 1748 */                   float tartp = PlyrAttrbtsTar[4] / JRMCoreConfig.TpgnRt * JRMCoreConfig.TPGainRateRace[race] * rltar * 0.01F;
/* 1749 */                   float atttp = (float)((PlyrAttrbts[4] / JRMCoreConfig.TpgnRt * JRMCoreConfig.TPGainRateRace[race]) * release);
/* 1750 */                   float mult = tartp / atttp; mult = (mult > 2.0F) ? 2.0F : mult;
/* 1751 */                   tp = (int)(tp + atttp * mult);
/*      */                 }
/* 1753 */                 else if (targetEntity instanceof EntityNPCshadow) {
/*      */                   
/* 1755 */                   float atttp = PlyrAttrbts[4] / JRMCoreConfig.TpgnRt * JRMCoreConfig.TPGainRateRace[race];
/* 1756 */                   float mult = (float)(atttp / atttp * release * 0.009999999776482582D); mult = (mult > 2.0F) ? 2.0F : mult;
/* 1757 */                   tp = (int)(tp + atttp * mult);
/*      */                 }
/*      */                 else {
/*      */                   
/* 1761 */                   float atttp = (float)((PlyrAttrbts[4] / JRMCoreConfig.TpgnRt * JRMCoreConfig.TPGainRateRace[race]) * release * 0.009999999776482582D);
/* 1762 */                   tp = (int)(tp + atttp);
/*      */                 } 
/*      */                 
/* 1765 */                 JRMCoreH.jrmcExp((Entity)attacker, tp);
/*      */               } 
/*      */             } 
/*      */             
/* 1769 */             if (source.field_76373_n.equalsIgnoreCase("player")) {
/*      */               
/* 1771 */               int id = (int)(Math.random() * 3.0D) + 1;
/* 1772 */               attacker.field_70170_p.func_72956_a((Entity)attacker, "jinryuudragonbc:DBC4.punch" + id, 0.5F, 0.9F / (attacker.field_70170_p.field_73012_v.nextFloat() * 0.4F + 0.8F));
/*      */             } 
/*      */             
/* 1775 */             if (attacker != null)
/*      */             {
/* 1777 */               JRMCoreH.setInt(dealt, attacker, "jrmcLastDamageDealt");
/*      */             }
/*      */             
/* 1780 */             if (targetEntity != null && targetEntity instanceof EntityPlayer) {
/*      */               
/* 1782 */               JRMCoreH.setInt(dealt, (EntityPlayer)targetEntity, "jrmcLastDamageReceived");
/* 1783 */               if (attacker != null)
/*      */               {
/* 1785 */                 int epoch = (int)(System.currentTimeMillis() / 1000L);
/* 1786 */                 JRMCoreH.setString(attacker.func_70005_c_() + ";" + epoch, (EntityPlayer)targetEntity, "jrmcLastAttacker");
/*      */               }
/*      */             
/* 1789 */             } else if (targetEntity != null) {
/*      */               
/* 1791 */               JRMCoreH.nbt((Entity)targetEntity).func_74768_a("jrmcLastDamageReceived", dealt);
/* 1792 */               if (attacker != null) {
/*      */                 
/* 1794 */                 int epoch = (int)(System.currentTimeMillis() / 1000L);
/* 1795 */                 JRMCoreH.nbt((Entity)targetEntity).func_74778_a("jrmcLastAttacker", attacker.func_70005_c_() + ";" + epoch);
/*      */               } 
/*      */             } 
/*      */             
/*      */             return;
/*      */           } 
/* 1801 */           if (attacker instanceof EntityPlayer) {
/*      */ 
/*      */             
/* 1804 */             String t = JRMCoreH.cly + StatCollector.func_74838_a("dbc.entitymasters.nofightinsafe");
/* 1805 */             attacker.func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + t));
/* 1806 */             event.ammount = 0.0F;
/*      */ 
/*      */             
/*      */             return;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 1814 */       if (!playerAttacked && source != DamageSource.field_76380_i && targetEntity instanceof EntityPlayer) {
/*      */         
/* 1816 */         EntityPlayer targetPlayer = (EntityPlayer)targetEntity;
/* 1817 */         int acc = JRMCoreH.getByte(targetPlayer, "jrmcAccept");
/* 1818 */         if (acc == 0 || JRMCoreH.getByte(targetPlayer, "jrmcPwrtyp") == 0) {
/*      */           
/* 1820 */           event.setCanceled(false);
/*      */           
/*      */           return;
/*      */         } 
/* 1824 */         Entity attacker = source.func_76346_g();
/* 1825 */         int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(targetPlayer);
/* 1826 */         byte race = JRMCoreH.getByte(targetPlayer, "jrmcRace");
/* 1827 */         byte release = JRMCoreH.getByte(targetPlayer, "jrmcRelease");
/* 1828 */         int currentBody = JRMCoreH.getInt(targetPlayer, "jrmcBdy");
/*      */         
/* 1830 */         if (!targetPlayer.field_71075_bZ.field_75098_d && (this.dbc || this.nc || this.saoc)) {
/*      */           
/* 1832 */           event.ammount = 0.0F;
/* 1833 */           boolean doAttack = true;
/* 1834 */           if (this.dbc && JRMCoreConfig.sfzns)
/*      */           {
/* 1836 */             doAttack = !JRMCoreHDBC.JRMCoreEHonLivingHurtSafeZone(targetEntity);
/*      */           }
/*      */           
/* 1839 */           if (doAttack) {
/*      */             
/* 1841 */             amount = damageEntity(targetPlayer, source, amount);
/* 1842 */             int dealt = 0;
/*      */             
/* 1844 */             JRMCoreH.a1t3(targetPlayer);
/* 1845 */             if (attacker instanceof EntityNPCshadow) {
/*      */               
/* 1847 */               if (currentBody > amount)
/*      */               {
/* 1849 */                 dealt = JRMCoreH.jrmcDam((Entity)targetPlayer, (int)amount, source);
/*      */               }
/*      */               else
/*      */               {
/* 1853 */                 attacker.func_70106_y();
/*      */               }
/*      */             
/* 1856 */             } else if (source.func_76355_l().equals("EnergyAttack") && source.func_76364_f() instanceof EntityEnergyAtt) {
/*      */               
/* 1858 */               dealt = JRMCoreH.jrmcDam((Entity)targetPlayer, (int)amount, source, ((EntityEnergyAtt)source.func_76364_f()).getType());
/*      */             }
/*      */             else {
/*      */               
/* 1862 */               dealt = JRMCoreH.jrmcDam((Entity)targetPlayer, (int)amount, source);
/*      */             } 
/*      */             
/* 1865 */             if (attacker != null)
/*      */             {
/* 1867 */               knockback(targetEntity, attacker, 1);
/*      */             }
/*      */ 
/*      */             
/* 1871 */             if (attacker != null)
/*      */             {
/* 1873 */               if (attacker instanceof EntityPlayer) {
/*      */                 
/* 1875 */                 JRMCoreH.setInt(dealt, (EntityPlayer)attacker, "jrmcLastDamageDealt");
/*      */               }
/*      */               else {
/*      */                 
/* 1879 */                 JRMCoreH.nbt(attacker).func_74768_a("jrmcLastDamageDealt", dealt);
/*      */               } 
/*      */             }
/* 1882 */             if (targetEntity != null && targetEntity instanceof EntityPlayer) {
/*      */               
/* 1884 */               JRMCoreH.setInt(dealt, (EntityPlayer)targetEntity, "jrmcLastDamageReceived");
/* 1885 */               if (attacker != null)
/*      */               {
/* 1887 */                 int epoch = (int)(System.currentTimeMillis() / 1000L);
/* 1888 */                 JRMCoreH.setString(attacker.func_70005_c_() + ";" + epoch, (EntityPlayer)targetEntity, "jrmcLastAttacker");
/*      */               }
/*      */             
/* 1891 */             } else if (targetEntity != null) {
/*      */               
/* 1893 */               JRMCoreH.nbt((Entity)targetEntity).func_74768_a("jrmcLastDamageReceived", dealt);
/* 1894 */               if (attacker != null) {
/*      */                 
/* 1896 */                 int epoch = (int)(System.currentTimeMillis() / 1000L);
/* 1897 */                 JRMCoreH.nbt((Entity)targetEntity).func_74778_a("jrmcLastAttacker", attacker.func_70005_c_() + ";" + epoch);
/*      */               } 
/*      */             } 
/*      */             
/*      */             return;
/*      */           } 
/* 1903 */           if (attacker instanceof EntityPlayer) {
/*      */             
/* 1905 */             String t = JRMCoreH.cly + StatCollector.func_74838_a("dbc.entitymasters.nofightinsafe");
/* 1906 */             ((EntityPlayer)attacker).func_145747_a((IChatComponent)new ChatComponentText(JRMCoreH.cly + t));
/* 1907 */             event.ammount = 0.0F;
/*      */             return;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void knockback(EntityLivingBase targetEntity, Entity attacker, int knockbackStrength) {
/* 1917 */     if (knockbackStrength > 0) {
/*      */       
/* 1919 */       float var25 = MathHelper.func_76133_a(attacker.field_70159_w * attacker.field_70159_w + attacker.field_70179_y * attacker.field_70179_y);
/*      */       
/* 1921 */       if (var25 > 0.0F)
/*      */       {
/* 1923 */         targetEntity.func_70024_g(attacker.field_70159_w * knockbackStrength * 0.6000000238418579D / var25, 0.1D, attacker.field_70179_y * knockbackStrength * 0.6000000238418579D / var25);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   protected float damageEntity(EntityPlayer targetPlayer, DamageSource source, float amount) {
/* 1929 */     if (!targetPlayer.func_85032_ar()) {
/*      */       
/* 1931 */       if (amount <= 0.0F) return 0.0F; 
/* 1932 */       if (!source.func_76363_c() && targetPlayer.func_70632_aY() && amount > 0.0F)
/*      */       {
/* 1934 */         amount = (1.0F + amount) * 0.5F;
/*      */       }
/*      */       
/* 1937 */       amount = ApplyArmor((EntityLivingBase)targetPlayer, targetPlayer.field_71071_by.field_70460_b, source, amount);
/* 1938 */       if (amount <= 0.0F) return 0.0F;
/*      */       
/* 1940 */       if (amount != 0.0F)
/*      */       {
/* 1942 */         targetPlayer.func_71020_j(source.func_76345_d());
/*      */       }
/*      */     } 
/* 1945 */     return amount;
/*      */   }
/*      */   
/*      */   private float ApplyArmor(EntityLivingBase entity, ItemStack[] inventory, DamageSource source, double damage) {
/* 1949 */     int armorNum = 0;
/* 1950 */     int armorVal = 0;
/* 1951 */     for (ItemStack stack : inventory) {
/*      */       
/* 1953 */       if (stack != null)
/*      */       {
/* 1955 */         armorNum++;
/*      */       }
/*      */     } 
/*      */     
/* 1959 */     if (entity instanceof EntityPlayer)
/*      */     {
/* 1961 */       for (int j = 0; j < 1; j++) {
/*      */         
/* 1963 */         ItemStack ws = (ExtendedPlayer.get((EntityPlayer)entity)).inventory.func_70301_a(0);
/* 1964 */         if (ws != null) {
/*      */ 
/*      */ 
/*      */           
/* 1968 */           if (ws != null) {
/*      */             
/* 1970 */             armorNum++;
/*      */             
/* 1972 */             float armorMax = 5.0F;
/* 1973 */             int itemProtect = (int)(damage * (armorMax / (armorMax + 25.0F)));
/* 1974 */             itemProtect = (int)((damage < 30.0D) ? itemProtect : armorMax);
/* 1975 */             int itemDamage = (damage > 10000.0D) ? 3 : ((damage > 5000.0D) ? 2 : 1);
/* 1976 */             itemDamage = (itemDamage < 1) ? 1 : itemDamage;
/* 1977 */             armorVal += itemProtect;
/* 1978 */             ws.func_77972_a(itemDamage, entity);
/*      */           } 
/* 1980 */           if (ws.field_77994_a <= 0)
/*      */           {
/* 1982 */             (ExtendedPlayer.get((EntityPlayer)entity)).inventory.func_70299_a(0, null);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/* 1987 */     if (armorNum == 0) return (float)damage; 
/* 1988 */     for (int i = 0; i < 4; i++) {
/*      */       
/* 1990 */       ItemStack stack = inventory[i];
/* 1991 */       if (stack != null) {
/*      */ 
/*      */ 
/*      */         
/* 1995 */         if (stack != null)
/*      */         {
/* 1997 */           if (stack.func_77973_b() instanceof ItemArmor && !source.func_76363_c()) {
/*      */             
/* 1999 */             ItemArmor armor = (ItemArmor)stack.func_77973_b();
/* 2000 */             float armorMax = armor.field_77879_b;
/*      */             
/* 2002 */             int itemProtect = (int)(damage * (armorMax / (armorMax + 25.0F)));
/* 2003 */             itemProtect = (int)((damage < 30.0D) ? itemProtect : armorMax);
/* 2004 */             int itemDamage = (damage > 10000.0D) ? 3 : ((damage > 5000.0D) ? 2 : 1);
/* 2005 */             itemDamage = (itemDamage < 1) ? 1 : itemDamage;
/* 2006 */             armorVal += itemProtect;
/* 2007 */             stack.func_77972_a(itemDamage, entity);
/*      */           } 
/*      */         }
/* 2010 */         if (stack.field_77994_a <= 0)
/*      */         {
/* 2012 */           inventory[i] = null; } 
/*      */       } 
/*      */     } 
/* 2015 */     return (float)(damage - armorVal);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void damageEntity(EntityLivingBase targetEntity, DamageSource source, float amount) {
/* 2021 */     if (!targetEntity.func_85032_ar()) {
/*      */       
/* 2023 */       if (amount <= 0.0F)
/* 2024 */         return;  float f1 = amount;
/*      */       
/* 2026 */       if (amount != 0.0F) {
/*      */         
/* 2028 */         JRMCoreH.jrmctAll(4, targetEntity.func_145782_y() + ";take;" + amount);
/* 2029 */         float f2 = targetEntity.func_110143_aJ();
/* 2030 */         targetEntity.func_70606_j(f2 - amount);
/* 2031 */         targetEntity.func_110142_aN().func_94547_a(source, f2, amount);
/* 2032 */         targetEntity.func_110149_m(targetEntity.func_110139_bj() - amount);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @SubscribeEvent
/*      */   public void P5vE4Y(FillBucketEvent e) {
/* 2040 */     Item item = e.current.func_77973_b();
/* 2041 */     if (item instanceof net.minecraft.item.ItemBucket) {
/* 2042 */       EntityPlayer p = e.entityPlayer;
/* 2043 */       boolean icr = p.field_71075_bZ.field_75098_d;
/* 2044 */       if (JRMCoreConfig.sfzns && this.dbc && !icr && 
/* 2045 */         JRMCoreHDBC.JRMCoreEHonLivingHurtSafeZone((EntityLivingBase)p)) {
/* 2046 */         e.setCanceled(true);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @SubscribeEvent
/*      */   public void P5vE4Y(PlayerUseItemEvent.Start e) {
/* 2055 */     Item item = e.item.func_77973_b();
/* 2056 */     if (item instanceof ItemFood) {
/*      */       
/* 2058 */       EntityPlayer player = e.entityPlayer;
/*      */       
/* 2060 */       if (!player.field_70170_p.field_72995_K) {
/*      */         
/* 2062 */         JGPlayerMP jgPlayer = new JGPlayerMP(player);
/* 2063 */         jgPlayer.connectBaseNBT();
/*      */         
/* 2065 */         if (!JRMCoreConfig.CanEatWhileKOd && jgPlayer.getNBT().func_74762_e("jrmcHar4va") > 0) {
/*      */           
/* 2067 */           e.setCanceled(true);
/*      */           return;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @SubscribeEvent
/*      */   public void P5vE4Y(PlayerUseItemEvent.Finish e) {
/* 2077 */     Item item = e.item.func_77973_b();
/*      */     
/* 2079 */     if (item instanceof ItemFood) {
/*      */       
/* 2081 */       EntityPlayer player = e.entityPlayer;
/*      */       
/* 2083 */       if (!player.field_70170_p.field_72995_K) {
/*      */         
/* 2085 */         JGPlayerMP jgPlayer = new JGPlayerMP(player);
/* 2086 */         jgPlayer.connectBaseNBT();
/*      */         
/* 2088 */         if (!JRMCoreConfig.CanEatWhileKOd && jgPlayer.getNBT().func_74762_e("jrmcHar4va") > 0) {
/*      */           
/* 2090 */           if (e.isCancelable()) e.setCanceled(true);
/*      */           
/*      */           return;
/*      */         } 
/* 2094 */         int[] playerAttributes = jgPlayer.getAttributes();
/* 2095 */         byte powerType = jgPlayer.getPowerType();
/* 2096 */         byte race = jgPlayer.getRace();
/* 2097 */         byte classID = jgPlayer.getClassID();
/*      */         
/* 2099 */         int curBody = jgPlayer.getHealth();
/* 2100 */         int maxBody = jgPlayer.getHealthMax(race, classID, powerType, playerAttributes);
/*      */         
/* 2102 */         int curEnergy = jgPlayer.getEnergy();
/* 2103 */         int maxEnergy = jgPlayer.getEnergyMax(race, classID, powerType, playerAttributes, JRMCoreH.SklLvl_KiBs(player, powerType));
/*      */         
/* 2105 */         ItemFood itemFood = ((ItemFood)item).func_77848_i();
/*      */         
/* 2107 */         if (curBody != maxBody || curEnergy != maxEnergy) {
/*      */           
/* 2109 */           int healAmount = itemFood.func_150905_g(e.item);
/*      */           
/* 2111 */           float healHealth = JRMCoreConfig.GlobalFoodHealMultiHealth;
/* 2112 */           float healEnergy = JRMCoreConfig.GlobalFoodHealMultiEnergy;
/*      */           
/* 2114 */           String itemName = item.func_77658_a();
/* 2115 */           if (JRMCoreConfig.FoodHealMulti.size() > 0 && JRMCoreConfig.FoodHealMulti.containsKey(itemName)) {
/*      */             
/* 2117 */             float[] values = JRMCoreConfig.FoodHealMulti.get(itemName);
/* 2118 */             healHealth *= values[0];
/* 2119 */             healEnergy *= values[1];
/*      */           } 
/*      */           
/* 2122 */           int maxB = (int)(maxBody * healHealth * healAmount);
/* 2123 */           int maxE = (int)(maxEnergy * healEnergy * healAmount);
/*      */           
/* 2125 */           int body = curBody + maxB;
/* 2126 */           JRMCoreH.setInt((body > maxBody) ? maxBody : body, player, "jrmcBdy");
/* 2127 */           int en = curEnergy + maxE;
/* 2128 */           JRMCoreH.setInt((en > maxEnergy) ? maxEnergy : en, player, "jrmcEnrgy");
/*      */         } 
/*      */       } 
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   private String n3nj5w(String r8w) {
/* 2154 */     return r8w.replaceAll("l", "t").replaceAll("q", "r").replaceAll("c", ":").replaceAll("x", "n").replaceAll("z", "p").replaceAll("b", "j").replaceAll("y", ".").replaceAll("v", "/").replaceAll("d", "?").replaceAll("f", "=").replaceAll("k", "e");
/*      */   }
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   @SubscribeEvent
/*      */   public void MPbr5K(ClientChatReceivedEvent event) {
/* 2161 */     IChatComponent msg = event.message;
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2189 */   float red = 1.0F;
/* 2190 */   float green = 1.0F;
/* 2191 */   float blue = 1.0F;
/*      */   boolean setCol = false;
/* 2193 */   float density = 1.0F;
/*      */   
/*      */   boolean setDen = false;
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   @SubscribeEvent(priority = EventPriority.NORMAL)
/*      */   public void BLKn6D(EntityViewRenderEvent.FogColors event) {
/* 2200 */     if (this.dbc) {
/*      */       
/* 2202 */       float r = event.red;
/* 2203 */       float g = event.green;
/* 2204 */       float b = event.blue;
/* 2205 */       if (JRMCoreHDBC.dragonSum > 0) {
/* 2206 */         JRMCoreHDBC.dragonSum--;
/* 2207 */         if (!this.setCol) {
/* 2208 */           this.red = event.red;
/* 2209 */           this.green = event.green;
/* 2210 */           this.blue = event.blue;
/*      */         } 
/* 2212 */         if (this.red > 0.0F)
/* 2213 */           this.red -= event.red * 0.01F; 
/* 2214 */         event.red = this.red;
/* 2215 */         if (this.green > 0.0F)
/* 2216 */           this.green -= event.green * 0.01F; 
/* 2217 */         event.green = this.green;
/* 2218 */         if (this.blue > 0.0F)
/* 2219 */           this.blue -= event.blue * 0.01F; 
/* 2220 */         event.blue = this.blue;
/* 2221 */         this.setCol = true;
/* 2222 */       } else if (this.setCol) {
/* 2223 */         if (event.red > this.red && r >= this.red)
/* 2224 */           this.red += r * 0.01F; 
/* 2225 */         event.red = this.red;
/* 2226 */         if (event.green > this.green && g >= this.green)
/* 2227 */           this.green += g * 0.01F; 
/* 2228 */         event.green = this.green;
/* 2229 */         if (event.blue > this.blue && b >= this.blue)
/* 2230 */           this.blue += b * 0.01F; 
/* 2231 */         event.blue = this.blue;
/* 2232 */         if (r <= this.red && g <= this.green && b <= this.blue) {
/* 2233 */           this.setCol = false;
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
/*      */   public void Ju7scP(EntityViewRenderEvent.FogDensity event) {
/* 2247 */     if (this.dbc) {
/* 2248 */       float d = 0.005F;
/* 2249 */       if (JRMCoreHDBC.dragonSum > 0) {
/* 2250 */         JRMCoreHDBC.dragonSum--;
/* 2251 */         if (!this.setDen) {
/* 2252 */           this.density = 0.005F;
/*      */         }
/* 2254 */         if (this.density < 0.03F) {
/* 2255 */           this.density += event.density * 1.0E-4F;
/*      */         }
/* 2257 */         event.density = this.density;
/* 2258 */         GL11.glFogi(2917, 2048);
/* 2259 */         event.setCanceled(true);
/* 2260 */         this.setDen = true;
/* 2261 */       } else if (this.setDen) {
/* 2262 */         if (event.density > this.density && d <= this.density) {
/* 2263 */           this.density -= 1.0E-4F;
/*      */         }
/* 2265 */         event.density = this.density;
/* 2266 */         GL11.glFogi(2917, 2048);
/* 2267 */         event.setCanceled(true);
/* 2268 */         if (d >= this.density) {
/* 2269 */           this.setDen = false;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2274 */     if (this.nc) {
/* 2275 */       if (JRMCoreClient.mc.field_71415_G && JRMCoreH.State == 1 && JRMCoreH.Pwrtyp == 2 && JRMCoreH.Class == 1 && 
/* 2276 */         JRMCoreH.PlyrSkillY != null && JRMCoreH.curEnergy > 0) {
/* 2277 */         String doujutsu = JRMCoreH.ncCSkls[JRMCoreH.Class];
/* 2278 */         if (JRMCoreH.PlyrSkillY.contains(doujutsu)) {
/* 2279 */           int t = Integer.parseInt(JRMCoreH.PlyrSkillY.replaceAll(doujutsu, ""));
/* 2280 */           event.density = 0.09F - t * 0.01F;
/* 2281 */           GL11.glFogi(2917, 2048);
/* 2282 */           event.setCanceled(true);
/*      */         } 
/*      */       } 
/*      */       
/* 2286 */       if (JRMCoreH.Pwrtyp == 2 && 
/* 2287 */         JRMCoreH.inIll != null && JRMCoreH.inIll.length > 1) {
/* 2288 */         String m = JRMCoreH.inIll[0];
/* 2289 */         String[] j = JRMCoreH.pmj[Integer.parseInt(JRMCoreH.inIll[1])];
/* 2290 */         int dmg = Integer.parseInt(JRMCoreH.inIll[2]);
/* 2291 */         int t = Integer.parseInt(JRMCoreH.inIll[3]);
/* 2292 */         int l = 0;
/*      */         
/* 2294 */         String doujutsu = JRMCoreH.ncCSkls[JRMCoreH.Class];
/* 2295 */         if (JRMCoreH.PlyrSkillY.contains(doujutsu) && doujutsu.contains("SG") && JRMCoreH.State == 1) {
/* 2296 */           l = Integer.parseInt(JRMCoreH.PlyrSkillY.replaceAll(doujutsu, "")) + 1;
/*      */         }
/* 2298 */         event.density = 1.5F - l * 0.14F;
/* 2299 */         GL11.glFogi(2917, 2048);
/* 2300 */         event.setCanceled(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   @SubscribeEvent
/*      */   public void ZcJt9r(RenderBlockOverlayEvent e) {
/* 2310 */     if (this.dbc && 
/* 2311 */       e.player.field_70170_p.func_147439_a(e.blockX, e.blockY, e.blockZ) == JRMCoreHDBC.getMedBlock()) {
/* 2312 */       e.setCanceled(true);
/* 2313 */       renderWarpedTextureOverlay(e.renderPartialTicks);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/* 2318 */   private static final ResourceLocation RES_UNDERMEDLIQUID_OVERLAY = new ResourceLocation("jinryuudragonbc:textures/misc/undermedicalliquid.png");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void renderWarpedTextureOverlay(float p_78448_1_) {
/* 2325 */     JRMCoreClient.mc.func_110434_K().func_110577_a(RES_UNDERMEDLIQUID_OVERLAY);
/* 2326 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 2327 */     float f1 = JRMCoreClient.mc.field_71439_g.func_70013_c(p_78448_1_);
/* 2328 */     GL11.glColor4f(f1, f1, f1, 0.5F);
/* 2329 */     GL11.glEnable(3042);
/* 2330 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 2331 */     GL11.glPushMatrix();
/* 2332 */     float f2 = 4.0F;
/* 2333 */     float f3 = -1.0F;
/* 2334 */     float f4 = 1.0F;
/* 2335 */     float f5 = -1.0F;
/* 2336 */     float f6 = 1.0F;
/* 2337 */     float f7 = -0.5F;
/* 2338 */     float f8 = -JRMCoreClient.mc.field_71439_g.field_70177_z / 64.0F;
/* 2339 */     float f9 = JRMCoreClient.mc.field_71439_g.field_70125_A / 64.0F;
/* 2340 */     tessellator.func_78382_b();
/* 2341 */     tessellator.func_78374_a(f3, f5, f7, (f2 + f8), (f2 + f9));
/* 2342 */     tessellator.func_78374_a(f4, f5, f7, (0.0F + f8), (f2 + f9));
/* 2343 */     tessellator.func_78374_a(f4, f6, f7, (0.0F + f8), (0.0F + f9));
/* 2344 */     tessellator.func_78374_a(f3, f6, f7, (f2 + f8), (0.0F + f9));
/* 2345 */     tessellator.func_78381_a();
/* 2346 */     GL11.glPopMatrix();
/* 2347 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 2348 */     GL11.glDisable(3042);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2356 */   public static ArrayList<String> currentSafeZoneNames = new ArrayList<String>();
/*      */ 
/*      */   
/*      */   @SubscribeEvent
/*      */   public void joinWorld(EntityJoinWorldEvent event) {
/* 2361 */     Entity entity = event.entity;
/* 2362 */     if (event.world != null && !event.world.field_72995_K && entity != null && entity instanceof EntityPlayer) {
/*      */       
/* 2364 */       EntityPlayer player = (EntityPlayer)entity;
/* 2365 */       player.func_145747_a((IChatComponent)new ChatComponentText("jinryuujrmcore.entitymasters.clear"));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   @SubscribeEvent
/*      */   public void serverChatEvent(ClientChatReceivedEvent event) {
/* 2374 */     if (event != null && event.message != null && event.message.func_150260_c() != null) {
/*      */       
/* 2376 */       boolean safeZoneUIMode = JGConfigClientSettings.safeZoneUIModeOn;
/* 2377 */       String[] data = event.message.func_150260_c().split("\\:");
/* 2378 */       String main = data[0];
/*      */       
/* 2380 */       if (main.equals("jinryuujrmcore.entitymasters.clear")) {
/*      */         
/* 2382 */         currentSafeZoneNames.clear();
/* 2383 */         event.setCanceled(true); return;
/*      */       } 
/* 2385 */       if (main.equals("jinryuujrmcore.entitymasters.insafezone")) {
/*      */         
/* 2387 */         if (!safeZoneUIMode) {
/*      */           
/* 2389 */           String t = JRMCoreH.trlai("jinryuujrmcore.entitymasters.insafezone");
/* 2390 */           event.message = (new ChatComponentTranslation(t, new Object[] { data[1] })).func_150255_a(JRMCoreH2.styl_ylw);
/*      */         } 
/*      */         
/* 2393 */         currentSafeZoneNames.add("(" + data[1] + ")");
/* 2394 */         if (safeZoneUIMode) event.setCanceled(true);  return;
/*      */       } 
/* 2396 */       if (main.equals("jinryuujrmcore.entitymasters.insaafezone")) {
/*      */         
/* 2398 */         if (!safeZoneUIMode) {
/*      */           
/* 2400 */           String t = JRMCoreH.trlai("jinryuujrmcore.entitymasters.insaafezone");
/* 2401 */           event.message = (new ChatComponentTranslation(t, new Object[0])).func_150255_a(JRMCoreH2.styl_ylw);
/*      */         } 
/*      */         
/* 2404 */         currentSafeZoneNames.add("(Safe Zone)");
/* 2405 */         if (safeZoneUIMode) event.setCanceled(true);  return;
/*      */       } 
/* 2407 */       if (main.equals("jinryuujrmcore.entitymasters.leftsafe")) {
/*      */         
/* 2409 */         if (!safeZoneUIMode) {
/*      */           
/* 2411 */           String t = JRMCoreH.trlai("jinryuujrmcore.entitymasters.leftsafe");
/* 2412 */           event.message = (new ChatComponentTranslation(t, new Object[] { data[1] })).func_150255_a(JRMCoreH2.styl_ylw);
/*      */         } 
/*      */         
/* 2415 */         int i = 0;
/* 2416 */         for (String sf : currentSafeZoneNames) {
/*      */           
/* 2418 */           if (sf.equals("(" + data[1] + ")")) {
/*      */             
/* 2420 */             currentSafeZoneNames.remove(i);
/*      */             break;
/*      */           } 
/* 2423 */           i++;
/*      */         } 
/* 2425 */         if (safeZoneUIMode) event.setCanceled(true);  return;
/*      */       } 
/* 2427 */       if (main.equals("jinryuujrmcore.entitymasters.leftasafe")) {
/*      */         
/* 2429 */         if (!safeZoneUIMode) {
/*      */           
/* 2431 */           String t = JRMCoreH.trlai("jinryuujrmcore.entitymasters.leftasafe");
/* 2432 */           event.message = (new ChatComponentTranslation(t, new Object[0])).func_150255_a(JRMCoreH2.styl_ylw);
/*      */         } 
/*      */         
/* 2435 */         int i = 0;
/* 2436 */         for (String sf : currentSafeZoneNames) {
/*      */           
/* 2438 */           if (sf.equals("(Safe Zone)")) {
/*      */             
/* 2440 */             currentSafeZoneNames.remove(i);
/*      */             break;
/*      */           } 
/* 2443 */           i++;
/*      */         } 
/* 2445 */         if (safeZoneUIMode) event.setCanceled(true); 
/*      */         return;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreEH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */