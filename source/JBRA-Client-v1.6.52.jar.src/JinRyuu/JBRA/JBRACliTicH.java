/*    */ package JinRyuu.JBRA;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import JinRyuu.JRMCore.JRMCoreConfig;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import cpw.mods.fml.common.gameevent.TickEvent;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*    */ import net.minecraft.client.renderer.EntityRenderer;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ public class JBRACliTicH
/*    */ {
/* 16 */   public Minecraft mc = JRMCoreClient.mc;
/*    */   
/*    */   private EntityRenderer renderer;
/*    */   private EntityRenderer prevRenderer;
/* 20 */   private RenderPlayerJBRA RenderPlayerJBRA = new RenderPlayerJBRA();
/*    */ 
/*    */   
/*    */   public void onPreRenderTick() {
/* 24 */     EntityClientPlayerMP entityClientPlayerMP = this.mc.field_71439_g;
/* 25 */     if (entityClientPlayerMP != null && !((EntityPlayer)entityClientPlayerMP).field_70128_L && this.mc.field_71441_e != null) {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 30 */       boolean jbraview = true;
/* 31 */       if (jbraview) {
/*    */         
/* 33 */         if (JRMCoreConfig.forceJBRA && !(RenderManager.field_78727_a.field_78729_o.get(EntityPlayer.class) instanceof RenderPlayerJBRA)) {
/* 34 */           RenderManager.field_78727_a.field_78729_o.put(EntityPlayer.class, this.RenderPlayerJBRA);
/* 35 */           this.RenderPlayerJBRA.func_76976_a(RenderManager.field_78727_a);
/*    */         } 
/*    */         
/* 38 */         if (this.renderer == null) {
/* 39 */           this.renderer = new JBRAEnRen(this.mc);
/*    */         }
/* 41 */         if (this.mc.field_71460_t != this.renderer) {
/*    */           
/* 43 */           this.prevRenderer = this.mc.field_71460_t;
/* 44 */           this.mc.field_71460_t = this.renderer;
/*    */         } 
/* 46 */       } else if (this.prevRenderer != null && this.mc.field_71460_t != this.prevRenderer) {
/*    */         
/* 48 */         this.mc.field_71460_t = this.prevRenderer;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onTick(TickEvent.ClientTickEvent event) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onRenderTick(TickEvent.RenderTickEvent event) {
/* 76 */     if (event.phase == TickEvent.Phase.START)
/* 77 */       onPreRenderTick(); 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JBRA-Client-v1.6.52.jar!\JinRyuu\JBRA\JBRACliTicH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */