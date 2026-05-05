/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.minecraft.util.com.google.common.collect.Iterables;
/*    */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*    */ import net.minecraft.util.com.mojang.authlib.properties.Property;
/*    */ 
/*    */ public class TileEntitySkull
/*    */   extends TileEntity
/*    */ {
/*    */   private int a;
/*    */   private int i;
/* 13 */   private GameProfile j = null;
/*    */ 
/*    */ 
/*    */   
/*    */   public void b(NBTTagCompound nbttagcompound) {
/* 18 */     super.b(nbttagcompound);
/* 19 */     nbttagcompound.setByte("SkullType", (byte)(this.a & 0xFF));
/* 20 */     nbttagcompound.setByte("Rot", (byte)(this.i & 0xFF));
/* 21 */     if (this.j != null) {
/* 22 */       NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*    */       
/* 24 */       GameProfileSerializer.serialize(nbttagcompound1, this.j);
/* 25 */       nbttagcompound.set("Owner", nbttagcompound1);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void a(NBTTagCompound nbttagcompound) {
/* 30 */     super.a(nbttagcompound);
/* 31 */     this.a = nbttagcompound.getByte("SkullType");
/* 32 */     this.i = nbttagcompound.getByte("Rot");
/* 33 */     if (this.a == 3) {
/* 34 */       if (nbttagcompound.hasKeyOfType("Owner", 10)) {
/* 35 */         this.j = GameProfileSerializer.deserialize(nbttagcompound.getCompound("Owner"));
/* 36 */       } else if (nbttagcompound.hasKeyOfType("ExtraType", 8) && !UtilColor.b(nbttagcompound.getString("ExtraType"))) {
/* 37 */         this.j = new GameProfile((UUID)null, nbttagcompound.getString("ExtraType"));
/* 38 */         d();
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   public GameProfile getGameProfile() {
/* 44 */     return this.j;
/*    */   }
/*    */   
/*    */   public Packet getUpdatePacket() {
/* 48 */     NBTTagCompound nbttagcompound = new NBTTagCompound();
/*    */     
/* 50 */     b(nbttagcompound);
/* 51 */     return new PacketPlayOutTileEntityData(this.x, this.y, this.z, 4, nbttagcompound);
/*    */   }
/*    */   
/*    */   public void setSkullType(int i) {
/* 55 */     this.a = i;
/* 56 */     this.j = null;
/*    */   }
/*    */   
/*    */   public void setGameProfile(GameProfile gameprofile) {
/* 60 */     this.a = 3;
/* 61 */     this.j = gameprofile;
/* 62 */     d();
/*    */   }
/*    */   
/*    */   private void d() {
/* 66 */     if (this.j != null && !UtilColor.b(this.j.getName()) && (
/* 67 */       !this.j.isComplete() || !this.j.getProperties().containsKey("textures"))) {
/* 68 */       GameProfile gameprofile = MinecraftServer.getServer().getUserCache().getProfile(this.j.getName());
/*    */       
/* 70 */       if (gameprofile != null) {
/* 71 */         Property property = (Property)Iterables.getFirst(gameprofile.getProperties().get("textures"), null);
/*    */         
/* 73 */         if (property == null) {
/* 74 */           gameprofile = MinecraftServer.getServer().av().fillProfileProperties(gameprofile, true);
/*    */         }
/*    */         
/* 77 */         this.j = gameprofile;
/* 78 */         update();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSkullType() {
/* 85 */     return this.a;
/*    */   }
/*    */   
/*    */   public void setRotation(int i) {
/* 89 */     this.i = i;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getRotation() {
/* 94 */     return this.i;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\TileEntitySkull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */