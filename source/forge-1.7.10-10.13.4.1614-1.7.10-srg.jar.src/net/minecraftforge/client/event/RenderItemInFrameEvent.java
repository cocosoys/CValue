/*    */ package net.minecraftforge.client.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.client.renderer.tileentity.RenderItemFrame;
/*    */ import net.minecraft.entity.item.EntityItemFrame;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Cancelable
/*    */ public class RenderItemInFrameEvent
/*    */   extends Event
/*    */ {
/*    */   public final ItemStack item;
/*    */   public final EntityItemFrame entityItemFrame;
/*    */   public final RenderItemFrame renderer;
/*    */   
/*    */   public RenderItemInFrameEvent(EntityItemFrame itemFrame, RenderItemFrame renderItemFrame) {
/* 23 */     this.item = itemFrame.getDisplayedItem();
/* 24 */     this.entityItemFrame = itemFrame;
/* 25 */     this.renderer = renderItemFrame;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\RenderItemInFrameEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */