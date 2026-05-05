/*     */ package net.minecraft.network.play.server;
/*     */ 
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import com.mojang.authlib.properties.Property;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class S0CPacketSpawnPlayer extends Packet {
/*     */   private int field_148957_a;
/*     */   private GameProfile field_148955_b;
/*     */   private int field_148956_c;
/*     */   private int field_148953_d;
/*     */   private int field_148954_e;
/*     */   private byte field_148951_f;
/*     */   private byte field_148952_g;
/*     */   private int field_148959_h;
/*     */   private DataWatcher field_148960_i;
/*     */   private List field_148958_j;
/*     */   private static final String __OBFID = "CL_00001281";
/*     */   
/*     */   public S0CPacketSpawnPlayer() {}
/*     */   
/*     */   public S0CPacketSpawnPlayer(EntityPlayer p_i45171_1_) {
/*  36 */     this.field_148957_a = p_i45171_1_.func_145782_y();
/*  37 */     this.field_148955_b = p_i45171_1_.func_146103_bH();
/*  38 */     this.field_148956_c = MathHelper.func_76128_c(p_i45171_1_.field_70165_t * 32.0D);
/*  39 */     this.field_148953_d = MathHelper.func_76128_c(p_i45171_1_.field_70163_u * 32.0D);
/*  40 */     this.field_148954_e = MathHelper.func_76128_c(p_i45171_1_.field_70161_v * 32.0D);
/*  41 */     this.field_148951_f = (byte)(int)(p_i45171_1_.field_70177_z * 256.0F / 360.0F);
/*  42 */     this.field_148952_g = (byte)(int)(p_i45171_1_.field_70125_A * 256.0F / 360.0F);
/*     */     
/*  44 */     ItemStack itemStack = p_i45171_1_.field_71071_by.func_70448_g();
/*  45 */     this.field_148959_h = (itemStack == null) ? 0 : Item.func_150891_b(itemStack.func_77973_b());
/*     */     
/*  47 */     this.field_148960_i = p_i45171_1_.func_70096_w();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  52 */     this.field_148957_a = p_148837_1_.func_150792_a();
/*  53 */     UUID uUID = UUID.fromString(p_148837_1_.func_150789_c(36));
/*  54 */     this.field_148955_b = new GameProfile(uUID, p_148837_1_.func_150789_c(16));
/*  55 */     int i = p_148837_1_.func_150792_a();
/*  56 */     for (byte b = 0; b < i; b++) {
/*  57 */       String str1 = p_148837_1_.func_150789_c(32767);
/*  58 */       String str2 = p_148837_1_.func_150789_c(32767);
/*  59 */       String str3 = p_148837_1_.func_150789_c(32767);
/*  60 */       this.field_148955_b.getProperties().put(str1, new Property(str1, str2, str3));
/*     */     } 
/*  62 */     this.field_148956_c = p_148837_1_.readInt();
/*  63 */     this.field_148953_d = p_148837_1_.readInt();
/*  64 */     this.field_148954_e = p_148837_1_.readInt();
/*  65 */     this.field_148951_f = p_148837_1_.readByte();
/*  66 */     this.field_148952_g = p_148837_1_.readByte();
/*  67 */     this.field_148959_h = p_148837_1_.readShort();
/*  68 */     this.field_148958_j = DataWatcher.func_151508_b(p_148837_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/*  73 */     p_148840_1_.func_150787_b(this.field_148957_a);
/*  74 */     UUID uUID = this.field_148955_b.getId();
/*  75 */     p_148840_1_.func_150785_a((uUID == null) ? "" : uUID.toString());
/*  76 */     p_148840_1_.func_150785_a(this.field_148955_b.getName());
/*  77 */     p_148840_1_.func_150787_b(this.field_148955_b.getProperties().size());
/*  78 */     for (Property property : this.field_148955_b.getProperties().values()) {
/*  79 */       p_148840_1_.func_150785_a(property.getName());
/*  80 */       p_148840_1_.func_150785_a(property.getValue());
/*  81 */       p_148840_1_.func_150785_a(property.getSignature());
/*     */     } 
/*  83 */     p_148840_1_.writeInt(this.field_148956_c);
/*  84 */     p_148840_1_.writeInt(this.field_148953_d);
/*  85 */     p_148840_1_.writeInt(this.field_148954_e);
/*  86 */     p_148840_1_.writeByte(this.field_148951_f);
/*  87 */     p_148840_1_.writeByte(this.field_148952_g);
/*  88 */     p_148840_1_.writeShort(this.field_148959_h);
/*  89 */     this.field_148960_i.func_151509_a(p_148840_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/*  94 */     p_148833_1_.func_147237_a(this);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public List func_148944_c() {
/*  98 */     if (this.field_148958_j == null) {
/*  99 */       this.field_148958_j = this.field_148960_i.func_75685_c();
/*     */     }
/* 101 */     return this.field_148958_j;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_148835_b() {
/* 106 */     return String.format("id=%d, gameProfile='%s', x=%.2f, y=%.2f, z=%.2f, carried=%d", new Object[] { Integer.valueOf(this.field_148957_a), this.field_148955_b, Float.valueOf(this.field_148956_c / 32.0F), Float.valueOf(this.field_148953_d / 32.0F), Float.valueOf(this.field_148954_e / 32.0F), Integer.valueOf(this.field_148959_h) });
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_148943_d() {
/* 110 */     return this.field_148957_a;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public GameProfile func_148948_e() {
/* 114 */     return this.field_148955_b;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_148942_f() {
/* 118 */     return this.field_148956_c;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_148949_g() {
/* 122 */     return this.field_148953_d;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_148946_h() {
/* 126 */     return this.field_148954_e;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public byte func_148941_i() {
/* 130 */     return this.field_148951_f;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public byte func_148945_j() {
/* 134 */     return this.field_148952_g;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_148947_k() {
/* 138 */     return this.field_148959_h;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S0CPacketSpawnPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */