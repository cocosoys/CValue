/*    */ package JinRyuu.JRMCore.manager;
/*    */ import JinRyuu.JRMCore.entity.EntitySafeZone;
/*    */ import JinRyuu.NarutoC.common.Npcs.f.EntityKonohaFugaku;
/*    */ import JinRyuu.NarutoC.common.Npcs.f.EntityKonohaHiashi;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ 
/*    */ public class JRMCoreManagerNC {
/*    */   public static String[] getMasterNames() {
/*  9 */     String[] entityNames = { "Fugaku", "Hiashi", "Sarutobi" };
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 14 */     return entityNames;
/*    */   }
/*    */   
/*    */   public static EntitySafeZone[] getMasters(EntityPlayerMP entityplayermp) {
/* 18 */     EntitySafeZone[] entities = { (EntitySafeZone)new EntityKonohaFugaku(entityplayermp.field_70170_p), (EntitySafeZone)new EntityKonohaHiashi(entityplayermp.field_70170_p), (EntitySafeZone)new EntityKonohaSarutobi(entityplayermp.field_70170_p) };
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 23 */     return entities;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\manager\JRMCoreManagerNC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */