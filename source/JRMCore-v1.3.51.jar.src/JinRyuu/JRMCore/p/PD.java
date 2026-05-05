/*     */ package JinRyuu.JRMCore.p;
/*     */ 
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPascend;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPascendsound;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPchargepart;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPchargesound;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPdescend;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPdescendsound;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPdri;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPduo;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPenergy;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPscouter1;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPscouter2;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPscouter3;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPscouter4;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPspacepod1;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPtick;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPwish;
/*     */ import JinRyuu.JRMCore.p.NC.NCPData;
/*     */ import JinRyuu.JRMCore.p.NC.NCPData2;
/*     */ import JinRyuu.JRMCore.p.NC.NCPDou;
/*     */ import JinRyuu.JRMCore.p.NC.NCPchargesound;
/*     */ import JinRyuu.JRMCore.p.NC.NCPjumpsound;
/*     */ import JinRyuu.JRMCore.p.YC.JYearsCP;
/*     */ import JinRyuu.JRMCore.p.YC.JYearsCPData;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
/*     */ import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
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
/*     */ public class PD
/*     */ {
/*  46 */   private static byte packetId = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   private static final SimpleNetworkWrapper dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel("jinryuujrmcore");
/*     */ 
/*     */   
/*  56 */   public static Class[] rp = new Class[] { JRMCorePData.class, JRMCorePAttck.class, JRMCorePChar.class, JRMCorePCost.class, JRMCorePExpl.class, JRMCorePFall.class, JRMCorePQuad.class, JRMCorePQuadI.class, JRMCorePRls.class, JRMCorePStats.class, JRMCorePStats2.class, JRMCorePStats3.class, JRMCorePStats3b.class, JRMCorePTech.class, JRMCorePTick.class, JRMCorePTri.class, JRMCorePTrib.class, JRMCorePUpgrade.class, SyncPlayerPropsMessage.class, OpenGuiMessage.class, JRMCorePData2.class, JRMCorePData3.class };
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
/*  83 */   public static Class[] rph = new Class[] { JRMCorePData.Handler.class, JRMCorePAttck.Handler.class, JRMCorePChar.Handler.class, JRMCorePCost.Handler.class, JRMCorePExpl.Handler.class, JRMCorePFall.Handler.class, JRMCorePQuad.Handler.class, JRMCorePQuadI.Handler.class, JRMCorePRls.Handler.class, JRMCorePStats.Handler.class, JRMCorePStats2.Handler.class, JRMCorePStats3.Handler.class, JRMCorePStats3b.Handler.class, JRMCorePTech.Handler.class, JRMCorePTick.Handler.class, JRMCorePTri.Handler.class, JRMCorePTrib.Handler.class, JRMCorePUpgrade.Handler.class, SyncPlayerPropsMessage.Handler.class, OpenGuiMessage.Handler.class, JRMCorePData2.Handler.class, JRMCorePData3.Handler.class };
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
/*     */   public static void JYCregPac() {
/* 113 */     registerBiMessage((Class)JYearsCP.Handler.class, JYearsCP.class);
/* 114 */     registerBiMessage((Class)JYearsCPData.Handler.class, JYearsCPData.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void JFCregPac() {
/* 121 */     registerBiMessage((Class)FamilyCP.Handler.class, FamilyCP.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void DBCregPac() {
/* 128 */     for (int i = 0; i < rpDBC.length; i++)
/*     */     {
/* 130 */       registerBiMessage(rphDBC[i], rpDBC[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void NCregPac() {
/* 138 */     registerBiMessage((Class)NCPchargesound.Handler.class, NCPchargesound.class);
/* 139 */     registerBiMessage((Class)NCPData.Handler.class, NCPData.class);
/* 140 */     registerBiMessage((Class)NCPData2.Handler.class, NCPData2.class);
/* 141 */     registerBiMessage((Class)NCPDou.Handler.class, NCPDou.class);
/*     */     
/* 143 */     registerBiMessage((Class)NCPjumpsound.Handler.class, NCPjumpsound.class);
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
/*     */   public static final void registerPackets() {
/* 159 */     JYCregPac();
/*     */ 
/*     */     
/* 162 */     JFCregPac();
/*     */ 
/*     */     
/* 165 */     DBCregPac();
/*     */ 
/*     */     
/* 168 */     NCregPac();
/*     */     
/* 170 */     for (int i = 0; i < rp.length; i++)
/*     */     {
/* 172 */       registerMessage(rph[i], rp[i]);
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
/*     */   private static final <REQ extends IMessage, REPLY extends IMessage> void registerMessage(Class<? extends IMessageHandler<REQ, REPLY>> handlerClass, Class<REQ> messageClass, Side side) {
/* 200 */     packetId = (byte)(packetId + 1); dispatcher.registerMessage(handlerClass, messageClass, packetId, side);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final <REQ extends IMessage, REPLY extends IMessage> void registerBiMessage(Class<? extends IMessageHandler<REQ, REPLY>> handlerClass, Class<REQ> messageClass) {
/* 209 */     dispatcher.registerMessage(handlerClass, messageClass, packetId, Side.CLIENT);
/* 210 */     packetId = (byte)(packetId + 1); dispatcher.registerMessage(handlerClass, messageClass, packetId, Side.SERVER);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final <REQ extends IMessage> void registerMessage(Class<? extends Amh<REQ>> handlerClass, Class<REQ> messageClass) {
/* 218 */     if (CAmh.class.isAssignableFrom(handlerClass)) {
/* 219 */       registerMessage((Class)handlerClass, messageClass, Side.CLIENT);
/*     */     }
/* 221 */     else if (SAmh.class.isAssignableFrom(handlerClass)) {
/* 222 */       registerMessage((Class)handlerClass, messageClass, Side.SERVER);
/*     */     }
/* 224 */     else if (BAmh.class.isAssignableFrom(handlerClass)) {
/* 225 */       registerBiMessage((Class)handlerClass, messageClass);
/*     */     } else {
/*     */       
/* 228 */       throw new IllegalArgumentException("Cannot determine on which Side(s) to register " + handlerClass.getName() + " - unrecognized handler class!");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void sendToAll(IMessage message) {
/* 239 */     dispatcher.sendToAll(message);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void sendTo(IMessage message, EntityPlayerMP player) {
/* 246 */     dispatcher.sendTo(message, player);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void sendToAllAround(IMessage message, NetworkRegistry.TargetPoint point) {
/* 254 */     dispatcher.sendToAllAround(message, point);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void sendToAllAround(IMessage message, int dimension, double x, double y, double z, double range) {
/* 261 */     sendToAllAround(message, new NetworkRegistry.TargetPoint(dimension, x, y, z, range));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void sendToAllAround(IMessage message, EntityPlayer player, double range) {
/* 268 */     sendToAllAround(message, player.field_70170_p.field_73011_w.field_76574_g, player.field_70165_t, player.field_70163_u, player.field_70161_v, range);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void sendToDimension(IMessage message, int dimensionId) {
/* 276 */     dispatcher.sendToDimension(message, dimensionId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void sendToServer(IMessage message) {
/* 284 */     dispatcher.sendToServer(message);
/*     */   }
/*     */   
/* 287 */   public static Class[] rpDBC = new Class[] { DBCPascend.class, DBCPascendsound.class, DBCPchargepart.class, DBCPchargesound.class, DBCPdescend.class, DBCPdescendsound.class, DBCPdri.class, DBCPenergy.class, DBCPduo.class, DBCPscouter1.class, DBCPscouter2.class, DBCPscouter3.class, DBCPscouter4.class, DBCPspacepod1.class, DBCPtick.class, DBCPwish.class };
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
/* 306 */   public static Class[] rphDBC = new Class[] { DBCPascend.Handler.class, DBCPascendsound.Handler.class, DBCPchargepart.Handler.class, DBCPchargesound.Handler.class, DBCPdescend.Handler.class, DBCPdescendsound.Handler.class, DBCPdri.Handler.class, DBCPenergy.Handler.class, DBCPduo.Handler.class, DBCPscouter1.Handler.class, DBCPscouter2.Handler.class, DBCPscouter3.Handler.class, DBCPscouter4.Handler.class, DBCPspacepod1.Handler.class, DBCPtick.Handler.class, DBCPwish.Handler.class };
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\PD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */