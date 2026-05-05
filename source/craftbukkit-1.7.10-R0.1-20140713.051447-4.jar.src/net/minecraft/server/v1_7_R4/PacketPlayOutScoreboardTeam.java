/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
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
/*     */ public class PacketPlayOutScoreboardTeam
/*     */   extends Packet
/*     */ {
/*  21 */   private String a = "";
/*  22 */   private String b = "";
/*  23 */   private String c = "";
/*  24 */   private String d = "";
/*  25 */   private Collection e = new ArrayList();
/*     */   
/*     */   private int f;
/*     */   
/*     */   private int g;
/*     */ 
/*     */   
/*     */   public PacketPlayOutScoreboardTeam(ScoreboardTeam paramScoreboardTeam, int paramInt) {
/*  33 */     this.a = paramScoreboardTeam.getName();
/*  34 */     this.f = paramInt;
/*     */     
/*  36 */     if (paramInt == 0 || paramInt == 2) {
/*  37 */       this.b = paramScoreboardTeam.getDisplayName();
/*  38 */       this.c = paramScoreboardTeam.getPrefix();
/*  39 */       this.d = paramScoreboardTeam.getSuffix();
/*  40 */       this.g = paramScoreboardTeam.packOptionData();
/*     */     } 
/*  42 */     if (paramInt == 0) {
/*  43 */       this.e.addAll(paramScoreboardTeam.getPlayerNameSet());
/*     */     }
/*     */   }
/*     */   
/*     */   public PacketPlayOutScoreboardTeam(ScoreboardTeam paramScoreboardTeam, Collection paramCollection, int paramInt) {
/*  48 */     if (paramInt != 3 && paramInt != 4) throw new IllegalArgumentException("Method must be join or leave for player constructor"); 
/*  49 */     if (paramCollection == null || paramCollection.isEmpty()) throw new IllegalArgumentException("Players cannot be null/empty");
/*     */     
/*  51 */     this.f = paramInt;
/*  52 */     this.a = paramScoreboardTeam.getName();
/*  53 */     this.e.addAll(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/*  58 */     this.a = paramPacketDataSerializer.c(16);
/*  59 */     this.f = paramPacketDataSerializer.readByte();
/*     */     
/*  61 */     if (this.f == 0 || this.f == 2) {
/*  62 */       this.b = paramPacketDataSerializer.c(32);
/*  63 */       this.c = paramPacketDataSerializer.c(16);
/*  64 */       this.d = paramPacketDataSerializer.c(16);
/*  65 */       this.g = paramPacketDataSerializer.readByte();
/*     */     } 
/*     */     
/*  68 */     if (this.f == 0 || this.f == 3 || this.f == 4) {
/*  69 */       short s = paramPacketDataSerializer.readShort();
/*     */       
/*  71 */       for (byte b = 0; b < s; b++) {
/*  72 */         this.e.add(paramPacketDataSerializer.c(40));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/*  79 */     paramPacketDataSerializer.a(this.a);
/*  80 */     paramPacketDataSerializer.writeByte(this.f);
/*     */     
/*  82 */     if (this.f == 0 || this.f == 2) {
/*  83 */       paramPacketDataSerializer.a(this.b);
/*  84 */       paramPacketDataSerializer.a(this.c);
/*  85 */       paramPacketDataSerializer.a(this.d);
/*  86 */       paramPacketDataSerializer.writeByte(this.g);
/*     */     } 
/*     */     
/*  89 */     if (this.f == 0 || this.f == 3 || this.f == 4) {
/*  90 */       paramPacketDataSerializer.writeShort(this.e.size());
/*     */       
/*  92 */       for (String str : this.e) {
/*  93 */         paramPacketDataSerializer.a(str);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 100 */     paramPacketPlayOutListener.a(this);
/*     */   }
/*     */   
/*     */   public PacketPlayOutScoreboardTeam() {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutScoreboardTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */