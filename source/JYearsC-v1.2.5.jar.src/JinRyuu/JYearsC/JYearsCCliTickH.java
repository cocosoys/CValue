/*     */ package JinRyuu.JYearsC;
/*     */ 
/*     */ import JinRyuu.JRMCore.JYearsCH;
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.common.gameevent.TickEvent;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ 
/*     */ 
/*     */ public class JYearsCCliTickH
/*     */ {
/*  15 */   public Minecraft mc = JYearsCClient.mc;
/*  16 */   public int testing = 0;
/*  17 */   public int check = 0;
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
/*     */   public void onRenderTickInGUI(GuiScreen guiscreen) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   4: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   7: ifnull -> 10
/*     */     //   10: aload_0
/*     */     //   11: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   14: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   17: ifnull -> 28
/*     */     //   20: aload_0
/*     */     //   21: getfield testing : I
/*     */     //   24: iconst_1
/*     */     //   25: if_icmpne -> 28
/*     */     //   28: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #20	-> 0
/*     */     //   #21	-> 10
/*     */     //   #22	-> 28
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	29	0	this	LJinRyuu/JYearsC/JYearsCCliTickH;
/*     */     //   0	29	1	guiscreen	Lnet/minecraft/client/gui/GuiScreen;
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
/*  42 */   private static int[] mid = JYearsCH.mID;
/*  43 */   public static String[] dm = JYearsCH.dayNames;
/*  44 */   public static String[] mn = JYearsCH.monthNames;
/*     */   
/*  46 */   public int agin = 0;
/*     */   public void onTickInGame() {
/*  48 */     EntityClientPlayerMP entityClientPlayerMP = this.mc.field_71439_g;
/*  49 */     if (entityClientPlayerMP != null && !((EntityPlayer)entityClientPlayerMP).field_70128_L && this.mc.field_71441_e != null && 
/*  50 */       JYearsCKeyHandler.Calendar.func_151470_d()) {
/*  51 */       entityClientPlayerMP.openGui(mod_JYearsC.instance, 0, ((EntityPlayer)entityClientPlayerMP).field_70170_p, (int)((EntityPlayer)entityClientPlayerMP).field_70165_t, (int)((EntityPlayer)entityClientPlayerMP).field_70163_u, (int)((EntityPlayer)entityClientPlayerMP).field_70161_v);
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
/*     */   public void onRenderTick() {}
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
/*     */   @SubscribeEvent
/*     */   public void onRenderTick(TickEvent.RenderTickEvent event) {
/*  88 */     if (event.phase.equals(TickEvent.Phase.END))
/*     */     {
/*  90 */       onRenderTick();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onTick(TickEvent.ClientTickEvent event) {
/* 102 */     if (event.phase.equals(TickEvent.Phase.START)) {
/*     */       
/* 104 */       EntityClientPlayerMP entityClientPlayerMP = FMLClientHandler.instance().getClientPlayerEntity();
/*     */       
/* 106 */       onTickInGame();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JYearsC-v1.2.5.jar!\JinRyuu\JYearsC\JYearsCCliTickH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */