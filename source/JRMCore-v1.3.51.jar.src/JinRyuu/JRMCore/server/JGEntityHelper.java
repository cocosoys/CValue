/*    */ package JinRyuu.JRMCore.server;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import JinRyuu.JRMCore.JRMCoreHDBC;
/*    */ import JinRyuu.JRMCore.JRMCoreM;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityList;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JGEntityHelper
/*    */ {
/*    */   public static void spawcha(EntityPlayer p, World w, String n, String h, String a, String m, String pr, double x, double y, double z, int g) {
/* 20 */     EntityLivingBase e = (EntityLivingBase)EntityList.func_75620_a(n, w);
/* 21 */     if (e != null) {
/*    */       
/* 23 */       e.func_70012_b(x, y, z, 0.0F, 0.0F);
/* 24 */       setAttributes(e, h, a, m, pr, g);
/*    */       
/* 26 */       if (JRMCoreH.DBC())
/*    */       {
/* 28 */         JRMCoreHDBC.ifEvilDBCnpcs((Entity)e, p);
/*    */       }
/*    */       
/* 31 */       w.func_72838_d((Entity)e);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void setAttributes(EntityLivingBase e, String health, String damage, String multi, String pr, int groupMulti) {
/* 37 */     if (e != null) {
/*    */       
/* 39 */       NBTTagCompound nbt = JRMCoreH.nbt((Entity)e);
/*    */       
/* 41 */       if (!pr.equals("") && pr.length() > 0)
/*    */       {
/* 43 */         nbt.func_74778_a("jrmcSpawnInitiatedIMP", pr);
/*    */       }
/*    */       
/* 46 */       if (!damage.equals("") && damage.length() > 0) {
/*    */         
/* 48 */         double newDamage = Double.parseDouble(damage) * JRMCoreM.gm(groupMulti);
/* 49 */         nbt.func_74780_a("jrmcSpawnInitiatedCAT", newDamage);
/*    */       } 
/*    */       
/* 52 */       if (!health.equals("") && health.length() > 0) {
/*    */         
/* 54 */         double newHealth = Double.parseDouble(health) * JRMCoreM.gm(groupMulti);
/* 55 */         nbt.func_74780_a("jrmcSpawnInitiatedCHP", newHealth);
/*    */       } 
/*    */       
/* 58 */       if (!multi.equals("") && multi.length() > 0)
/*    */       {
/* 60 */         nbt.func_74778_a("jrmcSpawnInitiatedCMT", multi);
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\JGEntityHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */