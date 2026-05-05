/*    */ package JinRyuu.DragonBC.common.Blocks;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.DBCConfig;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ 
/*    */ public class TileEntityHealingPods
/*    */   extends TileEntity
/*    */ {
/* 15 */   private int timer = 100;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145845_h() {
/* 23 */     if (!this.field_145850_b.field_72995_K) {
/* 24 */       this.timer--;
/* 25 */       if (this.timer <= 0) {
/* 26 */         float n = 1.0F;
/* 27 */         AxisAlignedBB aabb = getRenderBoundingBox();
/* 28 */         List<EntityPlayer> list = this.field_145850_b.func_72872_a(EntityPlayer.class, aabb);
/*    */         
/* 30 */         for (int i = 0; i < list.size(); i++) {
/*    */           
/* 32 */           EntityPlayer player = list.get(i);
/*    */           
/* 34 */           int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(player);
/*    */           
/* 36 */           byte pwr = JRMCoreH.getByte(player, "jrmcPwrtyp");
/* 37 */           byte rce = JRMCoreH.getByte(player, "jrmcRace");
/* 38 */           byte cls = JRMCoreH.getByte(player, "jrmcClass");
/* 39 */           int maxBody = JRMCoreH.stat((Entity)player, 2, pwr, 2, PlyrAttrbts[2], rce, cls, 0.0F);
/* 40 */           int curBody = JRMCoreH.getInt(player, "jrmcBdy");
/* 41 */           int maxEnergy = JRMCoreH.stat((Entity)player, 5, pwr, 5, PlyrAttrbts[5], rce, cls, JRMCoreH.SklLvl_KiBs(player, pwr));
/* 42 */           int curEnergy = JRMCoreH.getInt(player, "jrmcEnrgy");
/* 43 */           int maxStam = JRMCoreH.stat((Entity)player, 2, pwr, 3, PlyrAttrbts[2], rce, cls, 0.0F);
/* 44 */           int curStam = JRMCoreH.getInt(player, "jrmcStamina");
/*    */           
/* 46 */           float damage = 20.0F - player.func_110143_aJ();
/* 47 */           if (curBody - damage > 0.0F) {
/* 48 */             player.func_70606_j(player.func_110143_aJ() + damage);
/*    */           }
/* 50 */           if (curBody < maxBody) {
/* 51 */             float body = (curBody + DBCConfig.healingpodhealingrate);
/* 52 */             JRMCoreH.setInt((body > maxBody) ? maxBody : body, player, "jrmcBdy");
/*    */           } 
/* 54 */           if (curEnergy < maxEnergy) {
/* 55 */             float energy = (curEnergy + DBCConfig.healingpodhealingrate);
/* 56 */             JRMCoreH.setInt((energy > maxEnergy) ? maxEnergy : energy, player, "jrmcEnrgy");
/*    */           } 
/* 58 */           if (curStam < maxStam) {
/* 59 */             float stam = (curStam + DBCConfig.healingpodhealingrate);
/* 60 */             JRMCoreH.setInt((stam > maxStam) ? maxStam : stam, player, "jrmcStamina");
/*    */           } 
/* 62 */           if (player.func_71024_bL().func_75121_c()) {
/* 63 */             player.func_71024_bL().func_75122_a(1, 0.5F);
/*    */           }
/*    */         } 
/* 66 */         this.timer = 100;
/*    */       } 
/*    */     } 
/* 69 */     super.func_145845_h();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound par1NBTTagCompound) {
/* 78 */     super.func_145839_a(par1NBTTagCompound);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145841_b(NBTTagCompound par1NBTTagCompound) {
/* 87 */     super.func_145841_b(par1NBTTagCompound);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\TileEntityHealingPods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */