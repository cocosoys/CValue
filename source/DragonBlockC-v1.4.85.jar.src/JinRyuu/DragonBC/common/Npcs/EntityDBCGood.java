/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import JinRyuu.JRMCore.JRMCoreH2;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityDBCGood
/*    */   extends EntityDBC
/*    */ {
/*    */   public EntityDBCGood(World par1World) {
/* 17 */     super(par1World);
/*    */   }
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
/*    */   public void func_70645_a(DamageSource par1DamageSource) {
/* 38 */     Entity var3 = par1DamageSource.func_76346_g();
/*    */     
/* 40 */     if (var3 instanceof EntityPlayer) {
/*    */ 
/*    */ 
/*    */       
/* 44 */       int al = JRMCoreH.getByte((EntityPlayer)var3, "jrmcAlign");
/* 45 */       al -= 20;
/* 46 */       al = (al < 0) ? 0 : al;
/* 47 */       JRMCoreH.setByte(al, (EntityPlayer)var3, "jrmcAlign");
/*    */       
/* 49 */       int kr = JRMCoreH.getInt((EntityPlayer)var3, "jrmcKarma");
/* 50 */       JRMCoreH.setInt(kr + 1, (EntityPlayer)var3, "jrmcKarma");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 56 */       ((EntityPlayer)var3).func_145747_a((new ChatComponentTranslation(JRMCoreH.trlai("dbc.moreevil.line1"), new Object[0])).func_150255_a(JRMCoreH2.styl_wht));
/*    */     } 
/*    */     
/* 59 */     super.func_70645_a(par1DamageSource);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityDBCGood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */