/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*     */ import net.minecraft.util.com.mojang.authlib.properties.Property;
/*     */ 
/*     */ 
/*     */ public class PacketPlayOutNamedEntitySpawn
/*     */   extends Packet
/*     */ {
/*     */   private int a;
/*     */   private GameProfile b;
/*     */   private int c;
/*     */   private int d;
/*     */   private int e;
/*     */   private byte f;
/*     */   private byte g;
/*     */   private int h;
/*     */   private DataWatcher i;
/*     */   private List j;
/*     */   
/*     */   public PacketPlayOutNamedEntitySpawn() {}
/*     */   
/*     */   public PacketPlayOutNamedEntitySpawn(EntityHuman entityhuman) {
/*  28 */     this.a = entityhuman.getId();
/*  29 */     this.b = entityhuman.getProfile();
/*  30 */     this.c = MathHelper.floor(entityhuman.locX * 32.0D);
/*  31 */     this.d = MathHelper.floor(entityhuman.locY * 32.0D);
/*  32 */     this.e = MathHelper.floor(entityhuman.locZ * 32.0D);
/*  33 */     this.f = (byte)(int)(entityhuman.yaw * 256.0F / 360.0F);
/*  34 */     this.g = (byte)(int)(entityhuman.pitch * 256.0F / 360.0F);
/*  35 */     ItemStack itemstack = entityhuman.inventory.getItemInHand();
/*     */     
/*  37 */     this.h = (itemstack == null) ? 0 : Item.getId(itemstack.getItem());
/*  38 */     this.i = entityhuman.getDataWatcher();
/*     */   }
/*     */   
/*     */   public void a(PacketDataSerializer packetdataserializer) throws IOException {
/*  42 */     this.a = packetdataserializer.a();
/*  43 */     UUID uuid = UUID.fromString(packetdataserializer.c(36));
/*     */     
/*  45 */     this.b = new GameProfile(uuid, packetdataserializer.c(16));
/*  46 */     int i = packetdataserializer.a();
/*     */     
/*  48 */     for (int j = 0; j < i; j++) {
/*  49 */       String s = packetdataserializer.c(32767);
/*  50 */       String s1 = packetdataserializer.c(32767);
/*  51 */       String s2 = packetdataserializer.c(32767);
/*     */       
/*  53 */       this.b.getProperties().put(s, new Property(s, s1, s2));
/*     */     } 
/*     */     
/*  56 */     this.c = packetdataserializer.readInt();
/*  57 */     this.d = packetdataserializer.readInt();
/*  58 */     this.e = packetdataserializer.readInt();
/*  59 */     this.f = packetdataserializer.readByte();
/*  60 */     this.g = packetdataserializer.readByte();
/*  61 */     this.h = packetdataserializer.readShort();
/*  62 */     this.j = DataWatcher.b(packetdataserializer);
/*     */   }
/*     */   
/*     */   public void b(PacketDataSerializer packetdataserializer) throws IOException {
/*  66 */     packetdataserializer.b(this.a);
/*  67 */     UUID uuid = this.b.getId();
/*     */     
/*  69 */     packetdataserializer.a((uuid == null) ? "" : uuid.toString());
/*  70 */     packetdataserializer.a((this.b.getName().length() > 16) ? this.b.getName().substring(0, 16) : this.b.getName());
/*  71 */     packetdataserializer.b(this.b.getProperties().size());
/*  72 */     Iterator<Property> iterator = this.b.getProperties().values().iterator();
/*     */     
/*  74 */     while (iterator.hasNext()) {
/*  75 */       Property property = iterator.next();
/*     */       
/*  77 */       packetdataserializer.a(property.getName());
/*  78 */       packetdataserializer.a(property.getValue());
/*  79 */       packetdataserializer.a(property.getSignature());
/*     */     } 
/*     */     
/*  82 */     packetdataserializer.writeInt(this.c);
/*  83 */     packetdataserializer.writeInt(this.d);
/*  84 */     packetdataserializer.writeInt(this.e);
/*  85 */     packetdataserializer.writeByte(this.f);
/*  86 */     packetdataserializer.writeByte(this.g);
/*  87 */     packetdataserializer.writeShort(this.h);
/*  88 */     this.i.a(packetdataserializer);
/*     */   }
/*     */   
/*     */   public void a(PacketPlayOutListener packetplayoutlistener) {
/*  92 */     packetplayoutlistener.a(this);
/*     */   }
/*     */   
/*     */   public String b() {
/*  96 */     return String.format("id=%d, gameProfile='%s', x=%.2f, y=%.2f, z=%.2f, carried=%d", new Object[] { Integer.valueOf(this.a), this.b, Float.valueOf(this.c / 32.0F), Float.valueOf(this.d / 32.0F), Float.valueOf(this.e / 32.0F), Integer.valueOf(this.h) });
/*     */   }
/*     */   
/*     */   public void handle(PacketListener packetlistener) {
/* 100 */     a((PacketPlayOutListener)packetlistener);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutNamedEntitySpawn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */