/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ 
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.network.NetworkManager;
/*    */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ppTileEntity
/*    */   extends TileEntity
/*    */ {
/*    */   private boolean f = false;
/*    */   
/*    */   public boolean getF() {
/* 16 */     return this.f;
/*    */   }
/*    */   public void setF() {
/* 19 */     this.f = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canUpdate() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   private void writeSyncableDataToNBT(NBTTagCompound syncData) {
/* 29 */     syncData.func_74757_a("f", this.f);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void readSyncableDataFromNBT(NBTTagCompound par1) {
/* 37 */     this.f = par1.func_74767_n("f");
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
/*    */ 
/*    */   
/* 59 */   private float gravity = 1.0F;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
/* 65 */     readSyncableDataFromNBT(pkt.func_148857_g());
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/* 70 */     super.func_145839_a(p_145839_1_);
/* 71 */     readSyncableDataFromNBT(p_145839_1_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/* 77 */     super.func_145841_b(p_145841_1_);
/* 78 */     writeSyncableDataToNBT(p_145841_1_);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145845_h() {
/* 84 */     boolean flag1 = false;
/*    */     
/* 86 */     if (flag1)
/*    */     {
/* 88 */       func_70296_d();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\ppTileEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */