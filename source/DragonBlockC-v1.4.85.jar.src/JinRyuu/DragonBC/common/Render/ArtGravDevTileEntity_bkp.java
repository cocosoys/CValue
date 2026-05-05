/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ 
/*     */ public class ArtGravDevTileEntity_bkp
/*     */   extends TileEntity
/*     */ {
/*     */   public boolean canUpdate() {
/*  17 */     return true;
/*     */   }
/*     */   
/*     */   private void writeSyncableDataToNBT(NBTTagCompound syncData) {
/*  21 */     syncData.func_74776_a("gravity", this.gravity);
/*     */   }
/*     */   private void readSyncableDataFromNBT(NBTTagCompound par1) {
/*  24 */     this.gravity = par1.func_74760_g("gravity");
/*     */   }
/*     */   
/*     */   public float getGravity() {
/*  28 */     return this.gravity;
/*     */   }
/*     */   
/*     */   public void setGravity(float gravity) {
/*  32 */     this.gravity = gravity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  37 */   private float gravity = 1.0F;
/*     */   
/*     */   public int gravityDevCB;
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/*  43 */     super.func_145845_h();
/*     */     
/*  45 */     if (this.gravity > 1.0F) {
/*  46 */       this.gravityDevCB--;
/*  47 */       if (this.gravityDevCB <= 0) {
/*  48 */         this.gravityDevCB = 20;
/*     */         
/*  50 */         if (!this.field_145850_b.field_72995_K) {
/*     */           
/*  52 */           int n = 10;
/*  53 */           AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(this.field_145851_c - n, this.field_145848_d - n, this.field_145849_e - n, this.field_145851_c + n, this.field_145848_d + n, this.field_145849_e + n);
/*  54 */           List<EntityPlayer> list = this.field_145850_b.func_72872_a(EntityPlayer.class, aabb);
/*  55 */           if (!list.isEmpty())
/*     */           {
/*  57 */             for (int i = 0; i < list.size(); i++) {
/*     */               
/*  59 */               EntityPlayer player = list.get(i);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*  65 */               int epoch = (int)(System.currentTimeMillis() / 1000L) + 1;
/*  66 */               JRMCoreH.setInt(epoch, player, "jrmcGravZoneLast");
/*  67 */               float G = JRMCoreH.getFloat(player, "jrmcGravForce");
/*  68 */               if (this.gravity > G) JRMCoreH.setFloat(this.gravity, player, "jrmcGravForce");
/*     */             
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
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
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound par1) {
/*  91 */     super.func_145841_b(par1);
/*  92 */     writeSyncableDataToNBT(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound par1) {
/*  98 */     super.func_145839_a(par1);
/*  99 */     readSyncableDataFromNBT(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Packet func_145844_m() {
/* 105 */     NBTTagCompound syncData = new NBTTagCompound();
/* 106 */     writeSyncableDataToNBT(syncData);
/* 107 */     return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, syncData);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
/* 112 */     readSyncableDataFromNBT(pkt.func_148857_g());
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\ArtGravDevTileEntity_bkp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */