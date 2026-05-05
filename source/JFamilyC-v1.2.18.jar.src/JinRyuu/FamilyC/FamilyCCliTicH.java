/*     */ package JinRyuu.FamilyC;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.common.gameevent.TickEvent;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ 
/*     */ public class FamilyCCliTicH
/*     */ {
/*  16 */   public Minecraft mc = FamilyCClient.mc;
/*  17 */   public int testing = 0;
/*  18 */   public int check = 0;
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
/*     */     //   #49	-> 0
/*     */     //   #50	-> 10
/*     */     //   #51	-> 28
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	29	0	this	LJinRyuu/FamilyC/FamilyCCliTicH;
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
/*     */   public static boolean onHotbar(Item item, EntityPlayer player) {
/*  64 */     for (int i = 0; i < 9; i++) {
/*  65 */       if (player.field_71071_by.func_70301_a(i) != null && player.field_71071_by.func_70301_a(i).func_77973_b() == item) {
/*  66 */         return true;
/*     */       }
/*     */     } 
/*  69 */     return false;
/*     */   }
/*     */   
/*     */   public void onRenderTick() {
/*  73 */     if (this.mc.field_71415_G) if (Minecraft.func_71382_s());
/*     */   
/*     */   }
/*     */   
/*     */   public void onTickInGUI(GuiScreen guiscreen) {
/*  78 */     EntityClientPlayerMP entityClientPlayerMP = this.mc.field_71439_g;
/*  79 */     if (entityClientPlayerMP != null && !((EntityPlayer)entityClientPlayerMP).field_70128_L && this.mc.field_71441_e != null)
/*     */     {
/*  81 */       if (this.check >= 10) { jfct(1); this.check = 2; }
/*     */     
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
/*     */   public static void jfct(int tick) {}
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
/* 118 */   private static int gen = JRMCoreH.pg;
/* 119 */   public static String[] mp = JRMCoreH.p;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onTickInGame() {
/* 129 */     EntityClientPlayerMP entityClientPlayerMP = this.mc.field_71439_g;
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
/* 143 */     if (entityClientPlayerMP != null && !((EntityPlayer)entityClientPlayerMP).field_70128_L && this.mc.field_71441_e != null) {
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
/* 155 */       if (FamilyCKeyHandler.Interact.func_151470_d()) {
/* 156 */         if (this.mc.field_71476_x != null) {
/* 157 */           if (this.mc.field_71476_x.field_72313_a == MovingObjectPosition.MovingObjectType.ENTITY) {
/* 158 */             JRMCoreH.targ = this.mc.field_71476_x.field_72308_g;
/*     */           } else {
/* 160 */             JRMCoreH.targ = null;
/*     */           } 
/*     */         } else {
/* 163 */           JRMCoreH.targ = null;
/*     */         } 
/* 165 */         entityClientPlayerMP.openGui(mod_FamilyC.instance, 1, ((EntityPlayer)entityClientPlayerMP).field_70170_p, (int)((EntityPlayer)entityClientPlayerMP).field_70165_t, (int)((EntityPlayer)entityClientPlayerMP).field_70163_u, (int)((EntityPlayer)entityClientPlayerMP).field_70161_v);
/*     */       } 
/*     */       
/* 168 */       if (this.check >= 10) { jfct(1); this.check = 2; }
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onTick(TickEvent.ClientTickEvent event) {
/* 175 */     if (event.phase.equals(TickEvent.Phase.START)) {
/*     */       
/* 177 */       EntityClientPlayerMP entityClientPlayerMP = FMLClientHandler.instance().getClientPlayerEntity();
/*     */       
/* 179 */       onTickInGame();
/*     */     } 
/*     */     
/* 182 */     if (event.phase.equals(TickEvent.Phase.END) && event.type.equals(TickEvent.Type.RENDER))
/*     */     {
/* 184 */       onRenderTick();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\FamilyCCliTicH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */