/*    */ package JinRyuu.DragonBC.common;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import cpw.mods.fml.common.gameevent.TickEvent;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.nbt.NBTBase;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ public class DBCCommonTickHandler
/*    */ {
/*    */   boolean charge = false;
/*    */   EntityPlayer player;
/*    */   protected WorldGenerator ChkInSt;
/*    */   protected WorldGenerator KiLt;
/*    */   protected WorldGenerator SnkWy;
/*    */   protected WorldGenerator TiCha;
/*    */   private int tick;
/*    */   
/*    */   public void onPlayerTick(EntityPlayer Player) {}
/*    */   
/*    */   public String getLabel() {
/* 24 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   private NBTTagCompound nbt(EntityPlayer p, String s) {
/*    */     NBTTagCompound nbt;
/* 30 */     if (s.contains("pres")) {
/*    */       
/* 32 */       if (!p.getEntityData().func_74764_b("PlayerPersisted")) {
/* 33 */         nbt = new NBTTagCompound();
/* 34 */         p.getEntityData().func_74782_a("PlayerPersisted", (NBTBase)nbt);
/*    */       } else {
/* 36 */         nbt = p.getEntityData().func_74775_l("PlayerPersisted");
/*    */       } 
/*    */     } else {
/* 39 */       nbt = p.getEntityData();
/*    */     } 
/*    */     
/* 42 */     return nbt;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onTickInGame() {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onTick(TickEvent.ServerTickEvent event) {
/* 50 */     if (event.phase.equals(TickEvent.Phase.START) && !JRMCoreH.paused)
/*    */     {
/* 52 */       onTickInGame();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\DBCCommonTickHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */