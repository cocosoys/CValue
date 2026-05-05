/*     */ package net.minecraft.network.play.server;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ 
/*     */ public class S20PacketEntityProperties extends Packet {
/*     */   private int field_149445_a;
/*  17 */   private final List field_149444_b = new ArrayList();
/*     */   
/*     */   private static final String __OBFID = "CL_00001341";
/*     */ 
/*     */   
/*     */   public S20PacketEntityProperties(int p_i45236_1_, Collection p_i45236_2_) {
/*  23 */     this.field_149445_a = p_i45236_1_;
/*     */     
/*  25 */     for (IAttributeInstance iAttributeInstance : p_i45236_2_) {
/*  26 */       this.field_149444_b.add(new Snapshot(this, iAttributeInstance.func_111123_a().func_111108_a(), iAttributeInstance.func_111125_b(), iAttributeInstance.func_111122_c()));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  32 */     this.field_149445_a = p_148837_1_.readInt();
/*     */     
/*  34 */     int i = p_148837_1_.readInt();
/*  35 */     for (byte b = 0; b < i; b++) {
/*  36 */       String str = p_148837_1_.func_150789_c(64);
/*  37 */       double d = p_148837_1_.readDouble();
/*  38 */       ArrayList<AttributeModifier> arrayList = new ArrayList();
/*  39 */       short s = p_148837_1_.readShort();
/*     */       
/*  41 */       for (byte b1 = 0; b1 < s; b1++) {
/*  42 */         UUID uUID = new UUID(p_148837_1_.readLong(), p_148837_1_.readLong());
/*  43 */         arrayList.add(new AttributeModifier(uUID, "Unknown synced attribute modifier", p_148837_1_.readDouble(), p_148837_1_.readByte()));
/*     */       } 
/*     */       
/*  46 */       this.field_149444_b.add(new Snapshot(this, str, d, arrayList));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/*  52 */     p_148840_1_.writeInt(this.field_149445_a);
/*  53 */     p_148840_1_.writeInt(this.field_149444_b.size());
/*     */     
/*  55 */     for (Snapshot snapshot : this.field_149444_b) {
/*  56 */       p_148840_1_.func_150785_a(snapshot.func_151409_a());
/*  57 */       p_148840_1_.writeDouble(snapshot.func_151410_b());
/*  58 */       p_148840_1_.writeShort(snapshot.func_151408_c().size());
/*     */       
/*  60 */       for (AttributeModifier attributeModifier : snapshot.func_151408_c()) {
/*  61 */         p_148840_1_.writeLong(attributeModifier.func_111167_a().getMostSignificantBits());
/*  62 */         p_148840_1_.writeLong(attributeModifier.func_111167_a().getLeastSignificantBits());
/*  63 */         p_148840_1_.writeDouble(attributeModifier.func_111164_d());
/*  64 */         p_148840_1_.writeByte(attributeModifier.func_111169_c());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/*  71 */     p_148833_1_.func_147290_a(this);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149442_c() {
/*  75 */     return this.field_149445_a;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public List func_149441_d() {
/*  79 */     return this.field_149444_b;
/*     */   }
/*     */   
/*     */   public S20PacketEntityProperties() {}
/*     */   
/*     */   public class Snapshot { private final String field_151412_b;
/*     */     private final double field_151413_c;
/*     */     
/*     */     public Snapshot(S20PacketEntityProperties p_i45235_1_, String p_i45235_2_, double p_i45235_3_, Collection p_i45235_5_) {
/*  88 */       this.field_151412_b = p_i45235_2_;
/*  89 */       this.field_151413_c = p_i45235_3_;
/*  90 */       this.field_151411_d = p_i45235_5_;
/*     */     }
/*     */     private final Collection field_151411_d; private static final String __OBFID = "CL_00001342";
/*     */     public String func_151409_a() {
/*  94 */       return this.field_151412_b;
/*     */     }
/*     */     
/*     */     public double func_151410_b() {
/*  98 */       return this.field_151413_c;
/*     */     }
/*     */     
/*     */     public Collection func_151408_c() {
/* 102 */       return this.field_151411_d;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S20PacketEntityProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */