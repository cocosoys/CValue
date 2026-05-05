/*     */ package net.minecraftforge.client.event;
/*     */ 
/*     */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
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
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiScreenEvent
/*     */   extends Event
/*     */ {
/*     */   public final GuiScreen gui;
/*     */   
/*     */   public GuiScreenEvent(GuiScreen gui) {
/*  28 */     this.gui = gui;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class InitGuiEvent
/*     */     extends GuiScreenEvent
/*     */   {
/*     */     public List buttonList;
/*     */ 
/*     */     
/*     */     public InitGuiEvent(GuiScreen gui, List buttonList) {
/*  40 */       super(gui);
/*  41 */       this.buttonList = buttonList;
/*     */     }
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
/*     */     @Cancelable
/*     */     public static class Pre
/*     */       extends InitGuiEvent
/*     */     {
/*     */       public Pre(GuiScreen gui, List buttonList) {
/*  60 */         super(gui, buttonList);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class Post
/*     */       extends InitGuiEvent
/*     */     {
/*     */       public Post(GuiScreen gui, List buttonList) {
/*  74 */         super(gui, buttonList);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class DrawScreenEvent
/*     */     extends GuiScreenEvent
/*     */   {
/*     */     public final int mouseX;
/*     */ 
/*     */     
/*     */     public final int mouseY;
/*     */ 
/*     */     
/*     */     public final float renderPartialTicks;
/*     */ 
/*     */ 
/*     */     
/*     */     public DrawScreenEvent(GuiScreen gui, int mouseX, int mouseY, float renderPartialTicks) {
/*  96 */       super(gui);
/*  97 */       this.mouseX = mouseX;
/*  98 */       this.mouseY = mouseY;
/*  99 */       this.renderPartialTicks = renderPartialTicks;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Cancelable
/*     */     public static class Pre
/*     */       extends DrawScreenEvent
/*     */     {
/*     */       public Pre(GuiScreen gui, int mouseX, int mouseY, float renderPartialTicks) {
/* 113 */         super(gui, mouseX, mouseY, renderPartialTicks);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class Post
/*     */       extends DrawScreenEvent
/*     */     {
/*     */       public Post(GuiScreen gui, int mouseX, int mouseY, float renderPartialTicks) {
/* 126 */         super(gui, mouseX, mouseY, renderPartialTicks);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ActionPerformedEvent
/*     */     extends GuiScreenEvent
/*     */   {
/*     */     public GuiButton button;
/*     */ 
/*     */     
/*     */     public List buttonList;
/*     */ 
/*     */ 
/*     */     
/*     */     public ActionPerformedEvent(GuiScreen gui, GuiButton button, List<?> buttonList) {
/* 144 */       super(gui);
/* 145 */       this.button = button;
/* 146 */       this.buttonList = new ArrayList(buttonList);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Cancelable
/*     */     public static class Pre
/*     */       extends ActionPerformedEvent
/*     */     {
/*     */       public Pre(GuiScreen gui, GuiButton button, List buttonList) {
/* 161 */         super(gui, button, buttonList);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class Post
/*     */       extends ActionPerformedEvent
/*     */     {
/*     */       public Post(GuiScreen gui, GuiButton button, List buttonList) {
/* 175 */         super(gui, button, buttonList);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\event\GuiScreenEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */