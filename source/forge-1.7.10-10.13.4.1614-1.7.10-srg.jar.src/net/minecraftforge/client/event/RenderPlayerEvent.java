/*    */ package net.minecraftforge.client.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.event.entity.player.PlayerEvent;
/*    */ 
/*    */ public abstract class RenderPlayerEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public final RenderPlayer renderer;
/*    */   public final float partialRenderTick;
/*    */   
/*    */   public RenderPlayerEvent(EntityPlayer player, RenderPlayer renderer, float partialRenderTick) {
/* 16 */     super(player);
/* 17 */     this.renderer = renderer;
/* 18 */     this.partialRenderTick = partialRenderTick;
/*    */   }
/*    */   
/*    */   @Cancelable
/*    */   public static class Pre extends RenderPlayerEvent {
/*    */     public Pre(EntityPlayer player, RenderPlayer renderer, float tick) {
/* 24 */       super(player, renderer, tick);
/*    */     } }
/*    */   
/*    */   public static class Post extends RenderPlayerEvent {
/*    */     public Post(EntityPlayer player, RenderPlayer renderer, float tick) {
/* 29 */       super(player, renderer, tick);
/*    */     }
/*    */   }
/*    */   
/*    */   public static abstract class Specials
/*    */     extends RenderPlayerEvent {
/*    */     public Specials(EntityPlayer player, RenderPlayer renderer, float partialTicks) {
/* 36 */       super(player, renderer, partialTicks);
/*    */     }
/*    */     
/*    */     @Cancelable
/*    */     public static class Pre
/*    */       extends Specials {
/*    */       public boolean renderHelmet = true;
/*    */       
/*    */       public Pre(EntityPlayer player, RenderPlayer renderer, float partialTicks) {
/* 45 */         super(player, renderer, partialTicks);
/*    */       }
/*    */       public boolean renderCape = true; public boolean renderItem = true; }
/*    */     
/*    */     public static class Post extends Specials { public Post(EntityPlayer player, RenderPlayer renderer, float partialTicks) {
/* 50 */         super(player, renderer, partialTicks);
/*    */       } }
/*    */   
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class SetArmorModel
/*    */     extends RenderPlayerEvent
/*    */   {
/* 60 */     public int result = -1;
/*    */     public final int slot;
/*    */     public final ItemStack stack;
/*    */     
/*    */     public SetArmorModel(EntityPlayer player, RenderPlayer renderer, int slot, float partialTick, ItemStack stack) {
/* 65 */       super(player, renderer, partialTick);
/* 66 */       this.slot = slot;
/* 67 */       this.stack = stack;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\RenderPlayerEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */