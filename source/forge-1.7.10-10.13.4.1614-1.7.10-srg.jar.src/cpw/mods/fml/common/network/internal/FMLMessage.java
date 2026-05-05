/*     */ package cpw.mods.fml.common.network.internal;
/*     */ 
/*     */ import com.google.common.base.Throwables;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.common.network.ByteBufUtils;
/*     */ import cpw.mods.fml.common.registry.EntityRegistry;
/*     */ import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
/*     */ import cpw.mods.fml.common.registry.IThrowableEntity;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.buffer.Unpooled;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.apache.logging.log4j.Level;
/*     */ 
/*     */ public abstract class FMLMessage {
/*     */   abstract void toBytes(ByteBuf paramByteBuf);
/*     */   
/*     */   abstract void fromBytes(ByteBuf paramByteBuf);
/*     */   
/*     */   public static class CompleteHandshake extends FMLMessage {
/*     */     Side target;
/*     */     
/*     */     public CompleteHandshake() {}
/*     */     
/*     */     public CompleteHandshake(Side target) {
/*  33 */       this.target = target;
/*     */     }
/*     */ 
/*     */     
/*     */     void fromBytes(ByteBuf buf) {
/*  38 */       this.target = Side.values()[buf.readByte()];
/*     */     }
/*     */ 
/*     */     
/*     */     void toBytes(ByteBuf buf) {
/*  43 */       buf.writeByte(this.target.ordinal());
/*     */     } }
/*     */   
/*     */   public static class OpenGui extends FMLMessage {
/*     */     int windowId;
/*     */     String modId;
/*     */     int modGuiId;
/*     */     int x;
/*     */     int y;
/*     */     int z;
/*     */     
/*     */     public OpenGui() {}
/*     */     
/*     */     OpenGui(int windowId, String modId, int modGuiId, int x, int y, int z) {
/*  57 */       this.windowId = windowId;
/*  58 */       this.modId = modId;
/*  59 */       this.modGuiId = modGuiId;
/*  60 */       this.x = x;
/*  61 */       this.y = y;
/*  62 */       this.z = z;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void toBytes(ByteBuf buf) {
/*  68 */       buf.writeInt(this.windowId);
/*  69 */       ByteBufUtils.writeUTF8String(buf, this.modId);
/*  70 */       buf.writeInt(this.modGuiId);
/*  71 */       buf.writeInt(this.x);
/*  72 */       buf.writeInt(this.y);
/*  73 */       buf.writeInt(this.z);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void fromBytes(ByteBuf buf) {
/*  79 */       this.windowId = buf.readInt();
/*  80 */       this.modId = ByteBufUtils.readUTF8String(buf);
/*  81 */       this.modGuiId = buf.readInt();
/*  82 */       this.x = buf.readInt();
/*  83 */       this.y = buf.readInt();
/*  84 */       this.z = buf.readInt();
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class EntityMessage
/*     */     extends FMLMessage
/*     */   {
/*     */     Entity entity;
/*     */     int entityId;
/*     */     
/*     */     public EntityMessage() {}
/*     */     
/*     */     EntityMessage(Entity entity) {
/*  97 */       this.entity = entity;
/*     */     }
/*     */ 
/*     */     
/*     */     void toBytes(ByteBuf buf) {
/* 102 */       buf.writeInt(this.entity.getEntityId());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void fromBytes(ByteBuf buf) {
/* 108 */       this.entityId = buf.readInt();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class EntityAdjustMessage extends EntityMessage {
/*     */     int serverX;
/*     */     int serverY;
/*     */     int serverZ;
/*     */     
/*     */     public EntityAdjustMessage() {}
/*     */     
/*     */     public EntityAdjustMessage(Entity entity, int serverX, int serverY, int serverZ) {
/* 120 */       super(entity);
/* 121 */       this.serverX = serverX;
/* 122 */       this.serverY = serverY;
/* 123 */       this.serverZ = serverZ;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void toBytes(ByteBuf buf) {
/* 129 */       super.toBytes(buf);
/* 130 */       buf.writeInt(this.serverX);
/* 131 */       buf.writeInt(this.serverY);
/* 132 */       buf.writeInt(this.serverZ);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void fromBytes(ByteBuf buf) {
/* 138 */       super.fromBytes(buf);
/* 139 */       this.serverX = buf.readInt();
/* 140 */       this.serverY = buf.readInt();
/* 141 */       this.serverZ = buf.readInt();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class EntitySpawnMessage extends EntityMessage {
/*     */     String modId;
/*     */     int modEntityTypeId;
/*     */     int rawX;
/*     */     int rawY;
/*     */     int rawZ;
/*     */     double scaledX;
/*     */     double scaledY;
/*     */     double scaledZ;
/*     */     float scaledYaw;
/*     */     float scaledPitch;
/*     */     float scaledHeadYaw;
/*     */     int throwerId;
/*     */     double speedScaledX;
/*     */     double speedScaledY;
/*     */     double speedScaledZ;
/*     */     List dataWatcherList;
/*     */     ByteBuf dataStream;
/*     */     
/*     */     public EntitySpawnMessage() {}
/*     */     
/*     */     public EntitySpawnMessage(EntityRegistry.EntityRegistration er, Entity entity, ModContainer modContainer) {
/* 167 */       super(entity);
/* 168 */       this.modId = modContainer.getModId();
/* 169 */       this.modEntityTypeId = er.getModEntityId();
/*     */     }
/*     */ 
/*     */     
/*     */     void toBytes(ByteBuf buf) {
/* 174 */       super.toBytes(buf);
/* 175 */       ByteBufUtils.writeUTF8String(buf, this.modId);
/* 176 */       buf.writeInt(this.modEntityTypeId);
/*     */       
/* 178 */       buf.writeInt(MathHelper.floor_double(this.entity.posX * 32.0D));
/* 179 */       buf.writeInt(MathHelper.floor_double(this.entity.posY * 32.0D));
/* 180 */       buf.writeInt(MathHelper.floor_double(this.entity.posZ * 32.0D));
/*     */       
/* 182 */       buf.writeByte((byte)(int)(this.entity.rotationYaw * 256.0F / 360.0F));
/* 183 */       buf.writeByte((byte)(int)(this.entity.rotationPitch * 256.0F / 360.0F));
/*     */       
/* 185 */       if (this.entity instanceof EntityLivingBase) {
/*     */         
/* 187 */         buf.writeByte((byte)(int)(((EntityLivingBase)this.entity).rotationYawHead * 256.0F / 360.0F));
/*     */       }
/*     */       else {
/*     */         
/* 191 */         buf.writeByte(0);
/*     */       } 
/* 193 */       ByteBuf tmpBuf = Unpooled.buffer();
/* 194 */       PacketBuffer pb = new PacketBuffer(tmpBuf);
/*     */       
/*     */       try {
/* 197 */         this.entity.getDataWatcher().func_151509_a(pb);
/* 198 */       } catch (IOException e) {
/*     */         
/* 200 */         FMLLog.log(Level.FATAL, e, "Encountered fatal exception trying to send entity spawn data watchers", new Object[0]);
/* 201 */         throw Throwables.propagate(e);
/*     */       } 
/* 203 */       buf.writeBytes(tmpBuf);
/*     */       
/* 205 */       if (this.entity instanceof IThrowableEntity) {
/*     */         
/* 207 */         Entity owner = ((IThrowableEntity)this.entity).getThrower();
/* 208 */         buf.writeInt((owner == null) ? this.entity.getEntityId() : owner.getEntityId());
/* 209 */         double maxVel = 3.9D;
/* 210 */         double mX = this.entity.motionX;
/* 211 */         double mY = this.entity.motionY;
/* 212 */         double mZ = this.entity.motionZ;
/* 213 */         if (mX < -maxVel) mX = -maxVel; 
/* 214 */         if (mY < -maxVel) mY = -maxVel; 
/* 215 */         if (mZ < -maxVel) mZ = -maxVel; 
/* 216 */         if (mX > maxVel) mX = maxVel; 
/* 217 */         if (mY > maxVel) mY = maxVel; 
/* 218 */         if (mZ > maxVel) mZ = maxVel; 
/* 219 */         buf.writeInt((int)(mX * 8000.0D));
/* 220 */         buf.writeInt((int)(mY * 8000.0D));
/* 221 */         buf.writeInt((int)(mZ * 8000.0D));
/*     */       }
/*     */       else {
/*     */         
/* 225 */         buf.writeInt(0);
/*     */       } 
/* 227 */       if (this.entity instanceof IEntityAdditionalSpawnData) {
/*     */         
/* 229 */         tmpBuf = Unpooled.buffer();
/* 230 */         ((IEntityAdditionalSpawnData)this.entity).writeSpawnData(tmpBuf);
/* 231 */         buf.writeBytes(tmpBuf);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     void fromBytes(ByteBuf dat) {
/* 237 */       super.fromBytes(dat);
/* 238 */       this.modId = ByteBufUtils.readUTF8String(dat);
/* 239 */       this.modEntityTypeId = dat.readInt();
/* 240 */       this.rawX = dat.readInt();
/* 241 */       this.rawY = dat.readInt();
/* 242 */       this.rawZ = dat.readInt();
/* 243 */       this.scaledX = this.rawX / 32.0D;
/* 244 */       this.scaledY = this.rawY / 32.0D;
/* 245 */       this.scaledZ = this.rawZ / 32.0D;
/* 246 */       this.scaledYaw = dat.readByte() * 360.0F / 256.0F;
/* 247 */       this.scaledPitch = dat.readByte() * 360.0F / 256.0F;
/* 248 */       this.scaledHeadYaw = dat.readByte() * 360.0F / 256.0F;
/*     */       
/*     */       try {
/* 251 */         this.dataWatcherList = DataWatcher.readWatchedListFromPacketBuffer(new PacketBuffer(dat));
/* 252 */       } catch (IOException e) {
/*     */         
/* 254 */         FMLLog.log(Level.FATAL, e, "There was a critical error decoding the datawatcher stream for a mod entity.", new Object[0]);
/* 255 */         throw Throwables.propagate(e);
/*     */       } 
/*     */       
/* 258 */       this.throwerId = dat.readInt();
/* 259 */       if (this.throwerId != 0) {
/*     */         
/* 261 */         this.speedScaledX = dat.readInt() / 8000.0D;
/* 262 */         this.speedScaledY = dat.readInt() / 8000.0D;
/* 263 */         this.speedScaledZ = dat.readInt() / 8000.0D;
/*     */       } 
/* 265 */       this.dataStream = dat;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\internal\FMLMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */