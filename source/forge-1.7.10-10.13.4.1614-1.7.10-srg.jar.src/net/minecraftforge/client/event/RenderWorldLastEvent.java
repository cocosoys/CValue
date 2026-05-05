/*    */ package net.minecraftforge.client.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.client.renderer.RenderGlobal;
/*    */ 
/*    */ public class RenderWorldLastEvent
/*    */   extends Event {
/*    */   public final RenderGlobal context;
/*    */   public final float partialTicks;
/*    */   
/*    */   public RenderWorldLastEvent(RenderGlobal context, float partialTicks) {
/* 12 */     this.context = context;
/* 13 */     this.partialTicks = partialTicks;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\RenderWorldLastEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */