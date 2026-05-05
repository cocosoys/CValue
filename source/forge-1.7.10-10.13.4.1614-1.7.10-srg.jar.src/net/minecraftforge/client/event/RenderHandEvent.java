/*    */ package net.minecraftforge.client.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.client.renderer.RenderGlobal;
/*    */ 
/*    */ @Cancelable
/*    */ public class RenderHandEvent
/*    */   extends Event {
/*    */   public final RenderGlobal context;
/*    */   public final float partialTicks;
/*    */   public final int renderPass;
/*    */   
/*    */   public RenderHandEvent(RenderGlobal context, float partialTicks, int renderPass) {
/* 15 */     this.context = context;
/* 16 */     this.partialTicks = partialTicks;
/* 17 */     this.renderPass = renderPass;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\RenderHandEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */