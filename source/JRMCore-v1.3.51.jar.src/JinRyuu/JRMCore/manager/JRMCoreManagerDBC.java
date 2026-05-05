/*    */ package JinRyuu.JRMCore.manager;
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityMasterGoku;
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityMasterWhis;
/*    */ import JinRyuu.JRMCore.entity.EntitySafeZone;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ 
/*    */ public class JRMCoreManagerDBC {
/*    */   public static String[] getMasterNames() {
/*  9 */     String[] entityNames = { "Jin", "Babidi", "Cell", "Enma", "Freeza", "Gohan", "Goku", "Guru", "Kaio", "Kami", "Karin", "Piccolo", "Roshi", "Vegeta", "Trunks", "Whis" };
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 28 */     return entityNames;
/*    */   }
/*    */   
/*    */   public static EntitySafeZone[] getMasters(EntityPlayerMP entityplayermp) {
/* 32 */     EntitySafeZone[] entities = { (EntitySafeZone)new EntityMasterJin(entityplayermp.field_70170_p), (EntitySafeZone)new EntityMasterBabidi(entityplayermp.field_70170_p), (EntitySafeZone)new EntityMasterCell(entityplayermp.field_70170_p), (EntitySafeZone)new EntityMasterEnma(entityplayermp.field_70170_p), (EntitySafeZone)new EntityMasterFreeza(entityplayermp.field_70170_p), (EntitySafeZone)new EntityMasterGohan(entityplayermp.field_70170_p), (EntitySafeZone)new EntityMasterGoku(entityplayermp.field_70170_p), (EntitySafeZone)new EntityMasterGuru(entityplayermp.field_70170_p), (EntitySafeZone)new EntityMasterKaio(entityplayermp.field_70170_p), (EntitySafeZone)new EntityMasterKami(entityplayermp.field_70170_p), (EntitySafeZone)new EntityMasterKarin(entityplayermp.field_70170_p), (EntitySafeZone)new EntityMasterPiccolo(entityplayermp.field_70170_p), (EntitySafeZone)new EntityMasterRoshi(entityplayermp.field_70170_p), (EntitySafeZone)new EntityMasterVegeta(entityplayermp.field_70170_p), (EntitySafeZone)new EntityMasterTrunksFuture(entityplayermp.field_70170_p), (EntitySafeZone)new EntityMasterWhis(entityplayermp.field_70170_p) };
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 51 */     return entities;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\manager\JRMCoreManagerDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */