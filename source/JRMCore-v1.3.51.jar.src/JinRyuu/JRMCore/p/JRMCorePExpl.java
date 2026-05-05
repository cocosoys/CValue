/*     */ package JinRyuu.JRMCore.p;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreConfig;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ 
/*     */ 
/*     */ public class JRMCorePExpl
/*     */   implements IMessage
/*     */ {
/*     */   public double explosionX;
/*     */   public double explosionY;
/*     */   public double explosionZ;
/*     */   public float explosionSize;
/*     */   public List chunkPositionRecords;
/*     */   public float playerVelocityX;
/*     */   public float playerVelocityY;
/*     */   public float playerVelocityZ;
/*     */   public boolean expGriOff;
/*     */   public double expDam;
/*     */   public Entity origin;
/*     */   public byte type;
/*     */   int plID;
/*     */   
/*     */   public JRMCorePExpl() {}
/*     */   
/*     */   public JRMCorePExpl(double explosionX, double explosionY, double explosionZ, float explosionSize, boolean expGriOff, double expDam, Entity origin, List chunkPositionRecords, float playerVelocityX, float playerVelocityY, float playerVelocityZ, byte type) {
/*  35 */     this.explosionX = explosionX;
/*  36 */     this.explosionY = explosionY;
/*  37 */     this.explosionZ = explosionZ;
/*  38 */     this.explosionSize = explosionSize;
/*  39 */     this.expGriOff = expGriOff;
/*  40 */     this.expDam = expDam;
/*  41 */     this.origin = origin;
/*  42 */     this.chunkPositionRecords = chunkPositionRecords;
/*  43 */     this.playerVelocityX = playerVelocityX;
/*  44 */     this.playerVelocityY = playerVelocityY;
/*  45 */     this.playerVelocityZ = playerVelocityZ;
/*  46 */     this.type = type;
/*     */   }
/*     */ 
/*     */   
/*     */   public void toBytes(ByteBuf buffer) {
/*  51 */     buffer.writeDouble(this.explosionX);
/*  52 */     buffer.writeDouble(this.explosionY);
/*  53 */     buffer.writeDouble(this.explosionZ);
/*  54 */     buffer.writeFloat(this.explosionSize);
/*  55 */     buffer.writeBoolean(JRMCoreConfig.expGriOff);
/*  56 */     buffer.writeDouble(this.expDam);
/*  57 */     buffer.writeInt((this.origin == null) ? 0 : this.origin.func_145782_y());
/*  58 */     buffer.writeInt(this.chunkPositionRecords.size());
/*  59 */     int var2 = (int)this.explosionX;
/*  60 */     int var3 = (int)this.explosionY;
/*  61 */     int var4 = (int)this.explosionZ;
/*  62 */     Iterator var5 = this.chunkPositionRecords.iterator();
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
/*  75 */     buffer.writeFloat(this.playerVelocityX);
/*  76 */     buffer.writeFloat(this.playerVelocityY);
/*  77 */     buffer.writeFloat(this.playerVelocityZ);
/*  78 */     buffer.writeByte(this.type);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fromBytes(ByteBuf buffer) {
/*  84 */     this.explosionX = buffer.readDouble();
/*  85 */     this.explosionY = buffer.readDouble();
/*  86 */     this.explosionZ = buffer.readDouble();
/*  87 */     this.explosionSize = buffer.readFloat();
/*  88 */     this.expGriOff = buffer.readBoolean();
/*  89 */     this.expDam = buffer.readDouble();
/*  90 */     this.plID = buffer.readInt();
/*  91 */     int var2 = buffer.readInt();
/*  92 */     this.chunkPositionRecords = new ArrayList(var2);
/*  93 */     int var3 = (int)this.explosionX;
/*  94 */     int var4 = (int)this.explosionY;
/*  95 */     int var5 = (int)this.explosionZ;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     this.playerVelocityX = buffer.readFloat();
/* 106 */     this.playerVelocityY = buffer.readFloat();
/* 107 */     this.playerVelocityZ = buffer.readFloat();
/* 108 */     this.type = buffer.readByte();
/*     */   }
/*     */   
/*     */   public static class Handler
/*     */     extends BAmh<JRMCorePExpl>
/*     */   {
/*     */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePExpl m, MessageContext ctx) {
/* 115 */       m.origin = p.field_70170_p.func_73045_a(m.plID);
/* 116 */       JRMCoreClient.phc.handleExpl(m.explosionX, m.explosionY, m.explosionZ, m.explosionSize, m.expGriOff, m.expDam, m.origin, m.chunkPositionRecords, m.playerVelocityX, m.playerVelocityY, m.playerVelocityZ, p, m.type);
/*     */ 
/*     */ 
/*     */       
/* 120 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePExpl m, MessageContext ctx) {
/* 131 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePExpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */