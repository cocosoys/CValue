/*    */ package JinRyuu.JRMCore;
/*    */ import JinRyuu.FamilyC.EntityNPC;
/*    */ import JinRyuu.FamilyC.FamilyCConfig;
/*    */ import JinRyuu.FamilyC.mod_FamilyC;
/*    */ import JinRyuu.JRMCore.entity.ModelBipedBody;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class JRMCoreHJFC {
/*    */   public static int getConfigcpt() {
/* 12 */     return FamilyCConfig.cpt;
/*    */   }
/*    */   public static void setConfigpt(int value) {
/* 15 */     FamilyCConfig.pt = value;
/*    */   }
/*    */   public static void openGui(int id, EntityPlayer pl) {
/* 18 */     pl.openGui(mod_FamilyC.instance, id, pl.field_70170_p, (int)pl.field_70165_t, (int)pl.field_70163_u, (int)pl.field_70161_v);
/*    */   }
/*    */   
/*    */   public static boolean isChildNPC(Entity entity) {
/* 22 */     return entity instanceof EntityNPC;
/*    */   }
/*    */   public static String childDNS(Entity entity) {
/* 25 */     if (entity instanceof EntityNPC) {
/* 26 */       EntityNPC e = (EntityNPC)entity;
/* 27 */       return e.getDNS();
/*    */     } 
/* 29 */     return "";
/*    */   }
/*    */   public static String childDNSH(Entity entity) {
/* 32 */     if (entity instanceof EntityNPC) {
/* 33 */       EntityNPC e = (EntityNPC)entity;
/* 34 */       return e.getDNSH();
/*    */     } 
/* 36 */     return "";
/*    */   }
/*    */   public static void childDNSset(Entity entity, String w) {
/* 39 */     if (entity instanceof EntityNPC) {
/* 40 */       EntityNPC e = (EntityNPC)entity;
/* 41 */       e.setDNS(w);
/* 42 */       FamilyCH.jfcd(23, entity.func_145782_y() + ":dns:" + w);
/*    */     } 
/*    */   }
/*    */   public static void childDNSHset(Entity entity, String w) {
/* 46 */     if (entity instanceof EntityNPC) {
/* 47 */       EntityNPC e = (EntityNPC)entity;
/* 48 */       e.setDNSH(w);
/* 49 */       FamilyCH.jfcd(23, entity.func_145782_y() + ":dnsH:" + w);
/*    */     } 
/*    */   }
/*    */   public static void modelHelper(EntityLivingBase entityLiving, ModelBipedBody mdl) {
/* 53 */     if (entityLiving instanceof EntityNPC) {
/* 54 */       EntityNPC e = (EntityNPC)entityLiving;
/* 55 */       String dns = e.getDNS();
/* 56 */       mdl.b = JRMCoreH.dnsBreast(dns);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 63 */       if (dns.length() > 5) {
/* 64 */         ModelBipedBody.g = JRMCoreH.dnsGender(dns) + 1;
/*    */       }
/* 66 */       ModelBipedBody.f = e.getNPCgrw();
/* 67 */       mdl.b = JRMCoreH.dnsBreast(dns);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreHJFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */