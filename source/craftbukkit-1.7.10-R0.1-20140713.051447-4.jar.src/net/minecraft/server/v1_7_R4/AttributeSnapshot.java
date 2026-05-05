/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AttributeSnapshot
/*     */ {
/*     */   private final String b;
/*     */   private final double c;
/*     */   private final Collection d;
/*     */   
/*     */   public AttributeSnapshot(PacketPlayOutUpdateAttributes paramPacketPlayOutUpdateAttributes, String paramString, double paramDouble, Collection paramCollection) {
/*  88 */     this.b = paramString;
/*  89 */     this.c = paramDouble;
/*  90 */     this.d = paramCollection;
/*     */   }
/*     */   
/*     */   public String a() {
/*  94 */     return this.b;
/*     */   }
/*     */   
/*     */   public double b() {
/*  98 */     return this.c;
/*     */   }
/*     */   
/*     */   public Collection c() {
/* 102 */     return this.d;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\AttributeSnapshot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */