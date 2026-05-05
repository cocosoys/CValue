/*     */ package net.minecraft.network;
/*     */ import io.netty.util.concurrent.GenericFutureListener;
/*     */ import java.io.DataInputStream;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.command.server.CommandBlockLogic;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.ContainerBeacon;
/*     */ import net.minecraft.inventory.ContainerRepair;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.network.play.client.C02PacketUseEntity;
/*     */ import net.minecraft.network.play.client.C03PacketPlayer;
/*     */ import net.minecraft.network.play.client.C07PacketPlayerDigging;
/*     */ import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
/*     */ import net.minecraft.network.play.client.C09PacketHeldItemChange;
/*     */ import net.minecraft.network.play.client.C0BPacketEntityAction;
/*     */ import net.minecraft.network.play.client.C0CPacketInput;
/*     */ import net.minecraft.network.play.client.C0EPacketClickWindow;
/*     */ import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
/*     */ import net.minecraft.network.play.client.C11PacketEnchantItem;
/*     */ import net.minecraft.network.play.client.C12PacketUpdateSign;
/*     */ import net.minecraft.network.play.client.C16PacketClientStatus;
/*     */ import net.minecraft.network.play.client.C17PacketCustomPayload;
/*     */ import net.minecraft.network.play.server.S02PacketChat;
/*     */ import net.minecraft.network.play.server.S23PacketBlockChange;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.management.UserListBansEntry;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityBeacon;
/*     */ import net.minecraft.tileentity.TileEntitySign;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ 
/*     */ public class NetHandlerPlayServer implements INetHandlerPlayServer {
/*  46 */   private static final Logger field_147370_c = LogManager.getLogger();
/*     */   
/*     */   public final NetworkManager field_147371_a;
/*     */   
/*     */   private final MinecraftServer field_147367_d;
/*     */   
/*     */   public EntityPlayerMP field_147369_b;
/*     */   private int field_147368_e;
/*     */   private int field_147365_f;
/*     */   private boolean field_147366_g;
/*     */   private int field_147378_h;
/*     */   private long field_147379_i;
/*  58 */   private static Random field_147376_j = new Random();
/*     */   
/*     */   private long field_147377_k;
/*     */   
/*     */   private int field_147374_l;
/*     */   private int field_147375_m;
/*  64 */   private IntHashMap field_147372_n = new IntHashMap();
/*     */   
/*     */   private double field_147373_o;
/*     */   
/*     */   private double field_147382_p;
/*     */   
/*     */   private double field_147381_q;
/*     */   
/*     */   private boolean field_147380_r;
/*     */   private static final String __OBFID = "CL_00001452";
/*     */   
/*     */   public void func_147233_a() {
/*  76 */     this.field_147366_g = false;
/*  77 */     this.field_147368_e++;
/*     */     
/*  79 */     this.field_147367_d.field_71304_b.func_76320_a("keepAlive");
/*  80 */     if (this.field_147368_e - this.field_147377_k > 40L) {
/*  81 */       this.field_147377_k = this.field_147368_e;
/*  82 */       this.field_147379_i = func_147363_d();
/*  83 */       this.field_147378_h = (int)this.field_147379_i;
/*  84 */       func_147359_a((Packet)new S00PacketKeepAlive(this.field_147378_h));
/*     */     } 
/*     */     
/*  87 */     if (this.field_147374_l > 0) {
/*  88 */       this.field_147374_l--;
/*     */     }
/*  90 */     if (this.field_147375_m > 0) {
/*  91 */       this.field_147375_m--;
/*     */     }
/*     */     
/*  94 */     if (this.field_147369_b.func_154331_x() > 0L && this.field_147367_d.func_143007_ar() > 0 && MinecraftServer.func_130071_aq() - this.field_147369_b.func_154331_x() > (this.field_147367_d.func_143007_ar() * 1000 * 60)) {
/*  95 */       func_147360_c("You have been idle for too long!");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public NetworkManager func_147362_b() {
/* 101 */     return this.field_147371_a;
/*     */   }
/*     */   
/*     */   public void func_147360_c(String p_147360_1_) {
/* 105 */     ChatComponentText chatComponentText = new ChatComponentText(p_147360_1_);
/* 106 */     this.field_147371_a.func_150725_a((Packet)new S40PacketDisconnect((IChatComponent)chatComponentText), new GenericFutureListener[] { new GenericFutureListener(this, chatComponentText) { private static final String __OBFID = "CL_00001453";
/*     */             
/*     */             public void operationComplete(Future p_operationComplete_1_) {
/* 109 */               this.field_151288_b.field_147371_a.func_150718_a((IChatComponent)this.field_151289_a);
/*     */             } }
/*     */            });
/* 112 */     this.field_147371_a.func_150721_g();
/*     */   }
/*     */   
/*     */   public NetHandlerPlayServer(MinecraftServer p_i1530_1_, NetworkManager p_i1530_2_, EntityPlayerMP p_i1530_3_) {
/* 116 */     this.field_147380_r = true; this.field_147367_d = p_i1530_1_;
/*     */     this.field_147371_a = p_i1530_2_;
/*     */     p_i1530_2_.func_150719_a((INetHandler)this);
/*     */     this.field_147369_b = p_i1530_3_;
/* 120 */     p_i1530_3_.field_71135_a = this; } public void func_147358_a(C0CPacketInput p_147358_1_) { this.field_147369_b.func_110430_a(p_147358_1_.func_149620_c(), p_147358_1_.func_149616_d(), p_147358_1_.func_149618_e(), p_147358_1_.func_149617_f()); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147347_a(C03PacketPlayer p_147347_1_) {
/* 125 */     WorldServer worldServer = this.field_147367_d.func_71218_a(this.field_147369_b.field_71093_bK);
/*     */     
/* 127 */     this.field_147366_g = true;
/*     */     
/* 129 */     if (this.field_147369_b.field_71136_j)
/* 130 */       return;  if (!this.field_147380_r) {
/* 131 */       double d = p_147347_1_.func_149467_d() - this.field_147382_p;
/* 132 */       if (p_147347_1_.func_149464_c() == this.field_147373_o && d * d < 0.01D && p_147347_1_.func_149472_e() == this.field_147381_q) {
/* 133 */         this.field_147380_r = true;
/*     */       }
/*     */     } 
/*     */     
/* 137 */     if (this.field_147380_r) {
/* 138 */       if (this.field_147369_b.field_70154_o != null) {
/* 139 */         float f4 = this.field_147369_b.field_70177_z;
/* 140 */         float f5 = this.field_147369_b.field_70125_A;
/* 141 */         this.field_147369_b.field_70154_o.func_70043_V();
/* 142 */         double d13 = this.field_147369_b.field_70165_t;
/* 143 */         double d14 = this.field_147369_b.field_70163_u;
/* 144 */         double d15 = this.field_147369_b.field_70161_v;
/*     */         
/* 146 */         if (p_147347_1_.func_149463_k()) {
/* 147 */           f4 = p_147347_1_.func_149462_g();
/* 148 */           f5 = p_147347_1_.func_149470_h();
/*     */         } 
/*     */         
/* 151 */         this.field_147369_b.field_70122_E = p_147347_1_.func_149465_i();
/* 152 */         this.field_147369_b.func_71127_g();
/* 153 */         this.field_147369_b.field_70139_V = 0.0F;
/* 154 */         this.field_147369_b.func_70080_a(d13, d14, d15, f4, f5);
/* 155 */         if (this.field_147369_b.field_70154_o != null) this.field_147369_b.field_70154_o.func_70043_V(); 
/* 156 */         this.field_147367_d.func_71203_ab().func_72358_d(this.field_147369_b);
/*     */ 
/*     */         
/* 159 */         if (this.field_147380_r) {
/* 160 */           this.field_147373_o = this.field_147369_b.field_70165_t;
/* 161 */           this.field_147382_p = this.field_147369_b.field_70163_u;
/* 162 */           this.field_147381_q = this.field_147369_b.field_70161_v;
/*     */         } 
/* 164 */         worldServer.func_72870_g((Entity)this.field_147369_b);
/*     */         
/*     */         return;
/*     */       } 
/* 168 */       if (this.field_147369_b.func_70608_bn()) {
/* 169 */         this.field_147369_b.func_71127_g();
/* 170 */         this.field_147369_b.func_70080_a(this.field_147373_o, this.field_147382_p, this.field_147381_q, this.field_147369_b.field_70177_z, this.field_147369_b.field_70125_A);
/* 171 */         worldServer.func_72870_g((Entity)this.field_147369_b);
/*     */         
/*     */         return;
/*     */       } 
/* 175 */       double d1 = this.field_147369_b.field_70163_u;
/* 176 */       this.field_147373_o = this.field_147369_b.field_70165_t;
/* 177 */       this.field_147382_p = this.field_147369_b.field_70163_u;
/* 178 */       this.field_147381_q = this.field_147369_b.field_70161_v;
/*     */       
/* 180 */       double d2 = this.field_147369_b.field_70165_t;
/* 181 */       double d3 = this.field_147369_b.field_70163_u;
/* 182 */       double d4 = this.field_147369_b.field_70161_v;
/*     */       
/* 184 */       float f1 = this.field_147369_b.field_70177_z;
/* 185 */       float f2 = this.field_147369_b.field_70125_A;
/*     */       
/* 187 */       if (p_147347_1_.func_149466_j() && p_147347_1_.func_149467_d() == -999.0D && p_147347_1_.func_149471_f() == -999.0D) {
/* 188 */         p_147347_1_.func_149469_a(false);
/*     */       }
/*     */       
/* 191 */       if (p_147347_1_.func_149466_j()) {
/* 192 */         d2 = p_147347_1_.func_149464_c();
/* 193 */         d3 = p_147347_1_.func_149467_d();
/* 194 */         d4 = p_147347_1_.func_149472_e();
/* 195 */         double d = p_147347_1_.func_149471_f() - p_147347_1_.func_149467_d();
/* 196 */         if (!this.field_147369_b.func_70608_bn() && (d > 1.65D || d < 0.1D)) {
/* 197 */           func_147360_c("Illegal stance");
/* 198 */           field_147370_c.warn(this.field_147369_b.func_70005_c_() + " had an illegal stance: " + d);
/*     */           return;
/*     */         } 
/* 201 */         if (Math.abs(p_147347_1_.func_149464_c()) > 3.2E7D || Math.abs(p_147347_1_.func_149472_e()) > 3.2E7D) {
/* 202 */           func_147360_c("Illegal position");
/*     */           return;
/*     */         } 
/*     */       } 
/* 206 */       if (p_147347_1_.func_149463_k()) {
/* 207 */         f1 = p_147347_1_.func_149462_g();
/* 208 */         f2 = p_147347_1_.func_149470_h();
/*     */       } 
/*     */       
/* 211 */       this.field_147369_b.func_71127_g();
/* 212 */       this.field_147369_b.field_70139_V = 0.0F;
/* 213 */       this.field_147369_b.func_70080_a(this.field_147373_o, this.field_147382_p, this.field_147381_q, f1, f2);
/* 214 */       if (!this.field_147380_r) {
/*     */         return;
/*     */       }
/*     */       
/* 218 */       double d5 = d2 - this.field_147369_b.field_70165_t;
/* 219 */       double d6 = d3 - this.field_147369_b.field_70163_u;
/* 220 */       double d7 = d4 - this.field_147369_b.field_70161_v;
/*     */       
/* 222 */       double d8 = Math.min(Math.abs(d5), Math.abs(this.field_147369_b.field_70159_w));
/* 223 */       double d9 = Math.min(Math.abs(d6), Math.abs(this.field_147369_b.field_70181_x));
/* 224 */       double d10 = Math.min(Math.abs(d7), Math.abs(this.field_147369_b.field_70179_y));
/*     */       
/* 226 */       double d11 = d8 * d8 + d9 * d9 + d10 * d10;
/* 227 */       if (d11 > 100.0D && (!this.field_147367_d.func_71264_H() || !this.field_147367_d.func_71214_G().equals(this.field_147369_b.func_70005_c_()))) {
/* 228 */         field_147370_c.warn(this.field_147369_b.func_70005_c_() + " moved too quickly! " + d5 + "," + d6 + "," + d7 + " (" + d8 + ", " + d9 + ", " + d10 + ")");
/* 229 */         func_147364_a(this.field_147373_o, this.field_147382_p, this.field_147381_q, this.field_147369_b.field_70177_z, this.field_147369_b.field_70125_A);
/*     */         
/*     */         return;
/*     */       } 
/* 233 */       float f3 = 0.0625F;
/* 234 */       boolean bool1 = worldServer.func_72945_a((Entity)this.field_147369_b, this.field_147369_b.field_70121_D.func_72329_c().func_72331_e(f3, f3, f3)).isEmpty();
/*     */       
/* 236 */       if (this.field_147369_b.field_70122_E && !p_147347_1_.func_149465_i() && d6 > 0.0D)
/*     */       {
/* 238 */         this.field_147369_b.func_70664_aZ();
/*     */       }
/*     */       
/* 241 */       this.field_147369_b.func_70091_d(d5, d6, d7);
/* 242 */       this.field_147369_b.field_70122_E = p_147347_1_.func_149465_i();
/*     */       
/* 244 */       this.field_147369_b.func_71000_j(d5, d6, d7);
/*     */       
/* 246 */       double d12 = d6;
/*     */       
/* 248 */       d5 = d2 - this.field_147369_b.field_70165_t;
/* 249 */       d6 = d3 - this.field_147369_b.field_70163_u;
/* 250 */       if (d6 > -0.5D || d6 < 0.5D) {
/* 251 */         d6 = 0.0D;
/*     */       }
/* 253 */       d7 = d4 - this.field_147369_b.field_70161_v;
/* 254 */       d11 = d5 * d5 + d6 * d6 + d7 * d7;
/* 255 */       boolean bool = false;
/* 256 */       if (d11 > 0.0625D && !this.field_147369_b.func_70608_bn() && !this.field_147369_b.field_71134_c.func_73083_d()) {
/* 257 */         bool = true;
/* 258 */         field_147370_c.warn(this.field_147369_b.func_70005_c_() + " moved wrongly!");
/*     */       } 
/* 260 */       this.field_147369_b.func_70080_a(d2, d3, d4, f1, f2);
/*     */       
/* 262 */       boolean bool2 = worldServer.func_72945_a((Entity)this.field_147369_b, this.field_147369_b.field_70121_D.func_72329_c().func_72331_e(f3, f3, f3)).isEmpty();
/* 263 */       if (bool1 && (bool || !bool2) && !this.field_147369_b.func_70608_bn()) {
/* 264 */         func_147364_a(this.field_147373_o, this.field_147382_p, this.field_147381_q, f1, f2);
/*     */         return;
/*     */       } 
/* 267 */       AxisAlignedBB axisAlignedBB = this.field_147369_b.field_70121_D.func_72329_c().func_72314_b(f3, f3, f3).func_72321_a(0.0D, -0.55D, 0.0D);
/* 268 */       if (!this.field_147367_d.func_71231_X() && !this.field_147369_b.field_71134_c.func_73083_d() && !worldServer.func_72829_c(axisAlignedBB)) {
/* 269 */         if (d12 >= -0.03125D) {
/* 270 */           this.field_147365_f++;
/* 271 */           if (this.field_147365_f > 80) {
/* 272 */             field_147370_c.warn(this.field_147369_b.func_70005_c_() + " was kicked for floating too long!");
/* 273 */             func_147360_c("Flying is not enabled on this server");
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } else {
/* 278 */         this.field_147365_f = 0;
/*     */       } 
/*     */       
/* 281 */       this.field_147369_b.field_70122_E = p_147347_1_.func_149465_i();
/* 282 */       this.field_147367_d.func_71203_ab().func_72358_d(this.field_147369_b);
/* 283 */       this.field_147369_b.func_71122_b(this.field_147369_b.field_70163_u - d1, p_147347_1_.func_149465_i());
/* 284 */     } else if (this.field_147368_e % 20 == 0) {
/* 285 */       func_147364_a(this.field_147373_o, this.field_147382_p, this.field_147381_q, this.field_147369_b.field_70177_z, this.field_147369_b.field_70125_A);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_147364_a(double p_147364_1_, double p_147364_3_, double p_147364_5_, float p_147364_7_, float p_147364_8_) {
/* 290 */     this.field_147380_r = false;
/* 291 */     this.field_147373_o = p_147364_1_;
/* 292 */     this.field_147382_p = p_147364_3_;
/* 293 */     this.field_147381_q = p_147364_5_;
/* 294 */     this.field_147369_b.func_70080_a(p_147364_1_, p_147364_3_, p_147364_5_, p_147364_7_, p_147364_8_);
/* 295 */     this.field_147369_b.field_71135_a.func_147359_a((Packet)new S08PacketPlayerPosLook(p_147364_1_, p_147364_3_ + 1.6200000047683716D, p_147364_5_, p_147364_7_, p_147364_8_, false));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147345_a(C07PacketPlayerDigging p_147345_1_) {
/* 300 */     WorldServer worldServer = this.field_147367_d.func_71218_a(this.field_147369_b.field_71093_bK);
/* 301 */     this.field_147369_b.func_143004_u();
/*     */     
/* 303 */     if (p_147345_1_.func_149506_g() == 4) {
/* 304 */       this.field_147369_b.func_71040_bB(false); return;
/*     */     } 
/* 306 */     if (p_147345_1_.func_149506_g() == 3) {
/* 307 */       this.field_147369_b.func_71040_bB(true); return;
/*     */     } 
/* 309 */     if (p_147345_1_.func_149506_g() == 5) {
/* 310 */       this.field_147369_b.func_71034_by();
/*     */       
/*     */       return;
/*     */     } 
/* 314 */     boolean bool = false;
/* 315 */     if (p_147345_1_.func_149506_g() == 0) bool = true; 
/* 316 */     if (p_147345_1_.func_149506_g() == 1) bool = true; 
/* 317 */     if (p_147345_1_.func_149506_g() == 2) bool = true;
/*     */     
/* 319 */     int i = p_147345_1_.func_149505_c();
/* 320 */     int j = p_147345_1_.func_149503_d();
/* 321 */     int k = p_147345_1_.func_149502_e();
/* 322 */     if (bool) {
/* 323 */       double d1 = this.field_147369_b.field_70165_t - i + 0.5D;
/*     */ 
/*     */       
/* 326 */       double d2 = this.field_147369_b.field_70163_u - j + 0.5D + 1.5D;
/* 327 */       double d3 = this.field_147369_b.field_70161_v - k + 0.5D;
/* 328 */       double d4 = d1 * d1 + d2 * d2 + d3 * d3;
/* 329 */       if (d4 > 36.0D) {
/*     */         return;
/*     */       }
/* 332 */       if (j >= this.field_147367_d.func_71207_Z()) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */     
/* 337 */     if (p_147345_1_.func_149506_g() == 0) {
/* 338 */       if (!this.field_147367_d.func_96290_a((World)worldServer, i, j, k, (EntityPlayer)this.field_147369_b)) { this.field_147369_b.field_71134_c.func_73074_a(i, j, k, p_147345_1_.func_149501_f()); }
/* 339 */       else { this.field_147369_b.field_71135_a.func_147359_a((Packet)new S23PacketBlockChange(i, j, k, (World)worldServer)); }
/*     */     
/* 341 */     } else if (p_147345_1_.func_149506_g() == 2) {
/* 342 */       this.field_147369_b.field_71134_c.func_73082_a(i, j, k);
/* 343 */       if (worldServer.func_147439_a(i, j, k).func_149688_o() != Material.field_151579_a) this.field_147369_b.field_71135_a.func_147359_a((Packet)new S23PacketBlockChange(i, j, k, (World)worldServer)); 
/* 344 */     } else if (p_147345_1_.func_149506_g() == 1) {
/* 345 */       this.field_147369_b.field_71134_c.func_73073_c(i, j, k);
/* 346 */       if (worldServer.func_147439_a(i, j, k).func_149688_o() != Material.field_151579_a) this.field_147369_b.field_71135_a.func_147359_a((Packet)new S23PacketBlockChange(i, j, k, (World)worldServer));
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_147346_a(C08PacketPlayerBlockPlacement p_147346_1_) {
/* 352 */     WorldServer worldServer = this.field_147367_d.func_71218_a(this.field_147369_b.field_71093_bK);
/* 353 */     ItemStack itemStack = this.field_147369_b.field_71071_by.func_70448_g();
/* 354 */     boolean bool = false;
/* 355 */     int i = p_147346_1_.func_149576_c();
/* 356 */     int j = p_147346_1_.func_149571_d();
/* 357 */     int k = p_147346_1_.func_149570_e();
/* 358 */     int m = p_147346_1_.func_149568_f();
/* 359 */     this.field_147369_b.func_143004_u();
/*     */     
/* 361 */     if (p_147346_1_.func_149568_f() == 255) {
/* 362 */       if (itemStack == null)
/* 363 */         return;  this.field_147369_b.field_71134_c.func_73085_a((EntityPlayer)this.field_147369_b, (World)worldServer, itemStack);
/* 364 */     } else if (p_147346_1_.func_149571_d() < this.field_147367_d.func_71207_Z() - 1 || (p_147346_1_.func_149568_f() != 1 && p_147346_1_.func_149571_d() < this.field_147367_d.func_71207_Z())) {
/* 365 */       if (this.field_147380_r && this.field_147369_b.func_70092_e(i + 0.5D, j + 0.5D, k + 0.5D) < 64.0D && 
/* 366 */         !this.field_147367_d.func_96290_a((World)worldServer, i, j, k, (EntityPlayer)this.field_147369_b)) {
/* 367 */         this.field_147369_b.field_71134_c.func_73078_a((EntityPlayer)this.field_147369_b, (World)worldServer, itemStack, i, j, k, m, p_147346_1_.func_149573_h(), p_147346_1_.func_149569_i(), p_147346_1_.func_149575_j());
/*     */       }
/*     */ 
/*     */       
/* 371 */       bool = true;
/*     */     } else {
/* 373 */       ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("build.tooHigh", new Object[] { Integer.valueOf(this.field_147367_d.func_71207_Z()) });
/* 374 */       chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.RED);
/* 375 */       this.field_147369_b.field_71135_a.func_147359_a((Packet)new S02PacketChat((IChatComponent)chatComponentTranslation));
/* 376 */       bool = true;
/*     */     } 
/*     */     
/* 379 */     if (bool) {
/* 380 */       this.field_147369_b.field_71135_a.func_147359_a((Packet)new S23PacketBlockChange(i, j, k, (World)worldServer));
/*     */       
/* 382 */       if (m == 0) j--; 
/* 383 */       if (m == 1) j++; 
/* 384 */       if (m == 2) k--; 
/* 385 */       if (m == 3) k++; 
/* 386 */       if (m == 4) i--; 
/* 387 */       if (m == 5) i++;
/*     */       
/* 389 */       this.field_147369_b.field_71135_a.func_147359_a((Packet)new S23PacketBlockChange(i, j, k, (World)worldServer));
/*     */     } 
/*     */     
/* 392 */     itemStack = this.field_147369_b.field_71071_by.func_70448_g();
/* 393 */     if (itemStack != null && itemStack.field_77994_a == 0) {
/* 394 */       this.field_147369_b.field_71071_by.field_70462_a[this.field_147369_b.field_71071_by.field_70461_c] = null;
/* 395 */       itemStack = null;
/*     */     } 
/*     */     
/* 398 */     if (itemStack == null || itemStack.func_77988_m() == 0) {
/* 399 */       this.field_147369_b.field_71137_h = true;
/* 400 */       this.field_147369_b.field_71071_by.field_70462_a[this.field_147369_b.field_71071_by.field_70461_c] = ItemStack.func_77944_b(this.field_147369_b.field_71071_by.field_70462_a[this.field_147369_b.field_71071_by.field_70461_c]);
/* 401 */       Slot slot = this.field_147369_b.field_71070_bA.func_75147_a((IInventory)this.field_147369_b.field_71071_by, this.field_147369_b.field_71071_by.field_70461_c);
/* 402 */       this.field_147369_b.field_71070_bA.func_75142_b();
/* 403 */       this.field_147369_b.field_71137_h = false;
/*     */       
/* 405 */       if (!ItemStack.func_77989_b(this.field_147369_b.field_71071_by.func_70448_g(), p_147346_1_.func_149574_g())) {
/* 406 */         func_147359_a((Packet)new S2FPacketSetSlot(this.field_147369_b.field_71070_bA.field_75152_c, slot.field_75222_d, this.field_147369_b.field_71071_by.func_70448_g()));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147231_a(IChatComponent p_147231_1_) {
/* 413 */     field_147370_c.info(this.field_147369_b.func_70005_c_() + " lost connection: " + p_147231_1_);
/* 414 */     this.field_147367_d.func_147132_au();
/* 415 */     ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("multiplayer.player.left", new Object[] { this.field_147369_b.func_145748_c_() });
/* 416 */     chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.YELLOW);
/* 417 */     this.field_147367_d.func_71203_ab().func_148539_a((IChatComponent)chatComponentTranslation);
/* 418 */     this.field_147369_b.func_71123_m();
/* 419 */     this.field_147367_d.func_71203_ab().func_72367_e(this.field_147369_b);
/*     */     
/* 421 */     if (this.field_147367_d.func_71264_H() && this.field_147369_b.func_70005_c_().equals(this.field_147367_d.func_71214_G())) {
/* 422 */       field_147370_c.info("Stopping singleplayer server as player logged out");
/* 423 */       this.field_147367_d.func_71263_m();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_147359_a(Packet p_147359_1_) {
/* 428 */     if (p_147359_1_ instanceof S02PacketChat) {
/* 429 */       S02PacketChat s02PacketChat = (S02PacketChat)p_147359_1_;
/* 430 */       EntityPlayer.EnumChatVisibility enumChatVisibility = this.field_147369_b.func_147096_v();
/*     */       
/* 432 */       if (enumChatVisibility == EntityPlayer.EnumChatVisibility.HIDDEN)
/* 433 */         return;  if (enumChatVisibility == EntityPlayer.EnumChatVisibility.SYSTEM && !s02PacketChat.func_148916_d())
/*     */         return; 
/*     */     } 
/*     */     try {
/* 437 */       this.field_147371_a.func_150725_a(p_147359_1_, new GenericFutureListener[0]);
/* 438 */     } catch (Throwable throwable) {
/* 439 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Sending packet");
/* 440 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Packet being sent");
/*     */       
/* 442 */       crashReportCategory.func_71500_a("Packet class", new Callable(this, p_147359_1_) { private static final String __OBFID = "CL_00001454";
/*     */             
/*     */             public String call() {
/* 445 */               return this.field_151287_a.getClass().getCanonicalName();
/*     */             } }
/*     */         );
/*     */       
/* 449 */       throw new ReportedException(crashReport);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147355_a(C09PacketHeldItemChange p_147355_1_) {
/* 455 */     if (p_147355_1_.func_149614_c() < 0 || p_147355_1_.func_149614_c() >= InventoryPlayer.func_70451_h()) {
/* 456 */       field_147370_c.warn(this.field_147369_b.func_70005_c_() + " tried to set an invalid carried item");
/*     */       return;
/*     */     } 
/* 459 */     this.field_147369_b.field_71071_by.field_70461_c = p_147355_1_.func_149614_c();
/* 460 */     this.field_147369_b.func_143004_u();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147354_a(C01PacketChatMessage p_147354_1_) {
/* 465 */     if (this.field_147369_b.func_147096_v() == EntityPlayer.EnumChatVisibility.HIDDEN) {
/* 466 */       ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("chat.cannotSend", new Object[0]);
/* 467 */       chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.RED);
/* 468 */       func_147359_a((Packet)new S02PacketChat((IChatComponent)chatComponentTranslation));
/*     */       return;
/*     */     } 
/* 471 */     this.field_147369_b.func_143004_u();
/*     */     
/* 473 */     String str = p_147354_1_.func_149439_c();
/* 474 */     str = StringUtils.normalizeSpace(str);
/* 475 */     for (byte b = 0; b < str.length(); b++) {
/* 476 */       if (!ChatAllowedCharacters.func_71566_a(str.charAt(b))) {
/* 477 */         func_147360_c("Illegal characters in chat");
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 482 */     if (str.startsWith("/")) {
/* 483 */       func_147361_d(str);
/*     */     } else {
/* 485 */       ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("chat.type.text", new Object[] { this.field_147369_b.func_145748_c_(), str });
/* 486 */       this.field_147367_d.func_71203_ab().func_148544_a((IChatComponent)chatComponentTranslation, false);
/*     */     } 
/*     */     
/* 489 */     this.field_147374_l += 20;
/* 490 */     if (this.field_147374_l > 200 && !this.field_147367_d.func_71203_ab().func_152596_g(this.field_147369_b.func_146103_bH())) {
/* 491 */       func_147360_c("disconnect.spam");
/*     */     }
/*     */   }
/*     */   
/*     */   private void func_147361_d(String p_147361_1_) {
/* 496 */     this.field_147367_d.func_71187_D().func_71556_a((ICommandSender)this.field_147369_b, p_147361_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147350_a(C0APacketAnimation p_147350_1_) {
/* 501 */     this.field_147369_b.func_143004_u();
/* 502 */     if (p_147350_1_.func_149421_d() == 1) {
/* 503 */       this.field_147369_b.func_71038_i();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147357_a(C0BPacketEntityAction p_147357_1_) {
/* 509 */     this.field_147369_b.func_143004_u();
/* 510 */     if (p_147357_1_.func_149513_d() == 1) {
/* 511 */       this.field_147369_b.func_70095_a(true);
/* 512 */     } else if (p_147357_1_.func_149513_d() == 2) {
/* 513 */       this.field_147369_b.func_70095_a(false);
/* 514 */     } else if (p_147357_1_.func_149513_d() == 4) {
/* 515 */       this.field_147369_b.func_70031_b(true);
/* 516 */     } else if (p_147357_1_.func_149513_d() == 5) {
/* 517 */       this.field_147369_b.func_70031_b(false);
/* 518 */     } else if (p_147357_1_.func_149513_d() == 3) {
/* 519 */       this.field_147369_b.func_70999_a(false, true, true);
/* 520 */       this.field_147380_r = false;
/* 521 */     } else if (p_147357_1_.func_149513_d() == 6) {
/*     */       
/* 523 */       if (this.field_147369_b.field_70154_o != null && this.field_147369_b.field_70154_o instanceof EntityHorse) {
/* 524 */         ((EntityHorse)this.field_147369_b.field_70154_o).func_110206_u(p_147357_1_.func_149512_e());
/*     */       }
/*     */     }
/* 527 */     else if (p_147357_1_.func_149513_d() == 7) {
/*     */       
/* 529 */       if (this.field_147369_b.field_70154_o != null && this.field_147369_b.field_70154_o instanceof EntityHorse) {
/* 530 */         ((EntityHorse)this.field_147369_b.field_70154_o).func_110199_f((EntityPlayer)this.field_147369_b);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147340_a(C02PacketUseEntity p_147340_1_) {
/* 556 */     WorldServer worldServer = this.field_147367_d.func_71218_a(this.field_147369_b.field_71093_bK);
/* 557 */     Entity entity = p_147340_1_.func_149564_a((World)worldServer);
/* 558 */     this.field_147369_b.func_143004_u();
/*     */     
/* 560 */     if (entity != null) {
/* 561 */       boolean bool = this.field_147369_b.func_70685_l(entity);
/* 562 */       double d = 36.0D;
/* 563 */       if (!bool) {
/* 564 */         d = 9.0D;
/*     */       }
/*     */       
/* 567 */       if (this.field_147369_b.func_70068_e(entity) < d) {
/* 568 */         if (p_147340_1_.func_149565_c() == C02PacketUseEntity.Action.INTERACT) {
/* 569 */           this.field_147369_b.func_70998_m(entity);
/* 570 */         } else if (p_147340_1_.func_149565_c() == C02PacketUseEntity.Action.ATTACK) {
/* 571 */           if (entity instanceof EntityItem || entity instanceof net.minecraft.entity.item.EntityXPOrb || entity instanceof net.minecraft.entity.projectile.EntityArrow || entity == this.field_147369_b) {
/* 572 */             func_147360_c("Attempting to attack an invalid entity");
/* 573 */             this.field_147367_d.func_71236_h("Player " + this.field_147369_b.func_70005_c_() + " tried to attack an invalid entity");
/*     */             
/*     */             return;
/*     */           } 
/* 577 */           this.field_147369_b.func_71059_n(entity);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147342_a(C16PacketClientStatus p_147342_1_) {
/* 585 */     this.field_147369_b.func_143004_u();
/* 586 */     C16PacketClientStatus.EnumState enumState = p_147342_1_.func_149435_c();
/* 587 */     switch (SwitchEnumState.field_151290_a[enumState.ordinal()]) {
/*     */       case 1:
/* 589 */         if (this.field_147369_b.field_71136_j) {
/* 590 */           this.field_147369_b = this.field_147367_d.func_71203_ab().func_72368_a(this.field_147369_b, 0, true); break;
/* 591 */         }  if (this.field_147369_b.func_71121_q().func_72912_H().func_76093_s()) {
/* 592 */           if (this.field_147367_d.func_71264_H() && this.field_147369_b.func_70005_c_().equals(this.field_147367_d.func_71214_G())) {
/* 593 */             this.field_147369_b.field_71135_a.func_147360_c("You have died. Game over, man, it's game over!");
/* 594 */             this.field_147367_d.func_71272_O(); break;
/*     */           } 
/* 596 */           UserListBansEntry userListBansEntry = new UserListBansEntry(this.field_147369_b.func_146103_bH(), null, "(You just lost the game)", null, "Death in Hardcore");
/*     */           
/* 598 */           this.field_147367_d.func_71203_ab().func_152608_h().func_152687_a((UserListEntry)userListBansEntry);
/* 599 */           this.field_147369_b.field_71135_a.func_147360_c("You have died. Game over, man, it's game over!");
/*     */           break;
/*     */         } 
/* 602 */         if (this.field_147369_b.func_110143_aJ() > 0.0F)
/* 603 */           return;  this.field_147369_b = this.field_147367_d.func_71203_ab().func_72368_a(this.field_147369_b, 0, false);
/*     */         break;
/*     */       
/*     */       case 2:
/* 607 */         this.field_147369_b.func_147099_x().func_150876_a(this.field_147369_b);
/*     */         break;
/*     */       case 3:
/* 610 */         this.field_147369_b.func_71029_a((StatBase)AchievementList.field_76004_f);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147356_a(C0DPacketCloseWindow p_147356_1_) {
/* 617 */     this.field_147369_b.func_71128_l();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147351_a(C0EPacketClickWindow p_147351_1_) {
/* 622 */     this.field_147369_b.func_143004_u();
/* 623 */     if (this.field_147369_b.field_71070_bA.field_75152_c == p_147351_1_.func_149548_c() && this.field_147369_b.field_71070_bA.func_75129_b((EntityPlayer)this.field_147369_b)) {
/* 624 */       ItemStack itemStack = this.field_147369_b.field_71070_bA.func_75144_a(p_147351_1_.func_149544_d(), p_147351_1_.func_149543_e(), p_147351_1_.func_149542_h(), (EntityPlayer)this.field_147369_b);
/*     */       
/* 626 */       if (ItemStack.func_77989_b(p_147351_1_.func_149546_g(), itemStack)) {
/*     */         
/* 628 */         this.field_147369_b.field_71135_a.func_147359_a((Packet)new S32PacketConfirmTransaction(p_147351_1_.func_149548_c(), p_147351_1_.func_149547_f(), true));
/* 629 */         this.field_147369_b.field_71137_h = true;
/* 630 */         this.field_147369_b.field_71070_bA.func_75142_b();
/* 631 */         this.field_147369_b.func_71113_k();
/* 632 */         this.field_147369_b.field_71137_h = false;
/*     */       } else {
/*     */         
/* 635 */         this.field_147372_n.func_76038_a(this.field_147369_b.field_71070_bA.field_75152_c, Short.valueOf(p_147351_1_.func_149547_f()));
/* 636 */         this.field_147369_b.field_71135_a.func_147359_a((Packet)new S32PacketConfirmTransaction(p_147351_1_.func_149548_c(), p_147351_1_.func_149547_f(), false));
/* 637 */         this.field_147369_b.field_71070_bA.func_75128_a((EntityPlayer)this.field_147369_b, false);
/*     */         
/* 639 */         ArrayList<ItemStack> arrayList = new ArrayList();
/* 640 */         for (byte b = 0; b < this.field_147369_b.field_71070_bA.field_75151_b.size(); b++) {
/* 641 */           arrayList.add(((Slot)this.field_147369_b.field_71070_bA.field_75151_b.get(b)).func_75211_c());
/*     */         }
/* 643 */         this.field_147369_b.func_71110_a(this.field_147369_b.field_71070_bA, arrayList);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147338_a(C11PacketEnchantItem p_147338_1_) {
/* 651 */     this.field_147369_b.func_143004_u();
/* 652 */     if (this.field_147369_b.field_71070_bA.field_75152_c == p_147338_1_.func_149539_c() && this.field_147369_b.field_71070_bA.func_75129_b((EntityPlayer)this.field_147369_b)) {
/* 653 */       this.field_147369_b.field_71070_bA.func_75140_a((EntityPlayer)this.field_147369_b, p_147338_1_.func_149537_d());
/* 654 */       this.field_147369_b.field_71070_bA.func_75142_b();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147344_a(C10PacketCreativeInventoryAction p_147344_1_) {
/* 660 */     if (this.field_147369_b.field_71134_c.func_73083_d()) {
/*     */       
/* 662 */       boolean bool1 = (p_147344_1_.func_149627_c() < 0) ? true : false;
/* 663 */       ItemStack itemStack = p_147344_1_.func_149625_d();
/*     */       
/* 665 */       boolean bool2 = (p_147344_1_.func_149627_c() >= 1 && p_147344_1_.func_149627_c() < 36 + InventoryPlayer.func_70451_h()) ? true : false;
/* 666 */       boolean bool3 = (itemStack == null || itemStack.func_77973_b() != null) ? true : false;
/* 667 */       boolean bool4 = (itemStack == null || (itemStack.func_77960_j() >= 0 && itemStack.field_77994_a <= 64 && itemStack.field_77994_a > 0)) ? true : false;
/*     */       
/* 669 */       if (bool2 && bool3 && bool4) {
/* 670 */         if (itemStack == null) {
/* 671 */           this.field_147369_b.field_71069_bz.func_75141_a(p_147344_1_.func_149627_c(), null);
/*     */         } else {
/* 673 */           this.field_147369_b.field_71069_bz.func_75141_a(p_147344_1_.func_149627_c(), itemStack);
/*     */         } 
/* 675 */         this.field_147369_b.field_71069_bz.func_75128_a((EntityPlayer)this.field_147369_b, true);
/* 676 */       } else if (bool1 && bool3 && bool4 && 
/* 677 */         this.field_147375_m < 200) {
/* 678 */         this.field_147375_m += 20;
/*     */         
/* 680 */         EntityItem entityItem = this.field_147369_b.func_71019_a(itemStack, true);
/* 681 */         if (entityItem != null) {
/* 682 */           entityItem.func_70288_d();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147339_a(C0FPacketConfirmTransaction p_147339_1_) {
/* 691 */     Short short_ = (Short)this.field_147372_n.func_76041_a(this.field_147369_b.field_71070_bA.field_75152_c);
/* 692 */     if (short_ != null && p_147339_1_.func_149533_d() == short_.shortValue() && this.field_147369_b.field_71070_bA.field_75152_c == p_147339_1_.func_149532_c() && !this.field_147369_b.field_71070_bA.func_75129_b((EntityPlayer)this.field_147369_b)) {
/* 693 */       this.field_147369_b.field_71070_bA.func_75128_a((EntityPlayer)this.field_147369_b, true);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147343_a(C12PacketUpdateSign p_147343_1_) {
/* 699 */     this.field_147369_b.func_143004_u();
/* 700 */     WorldServer worldServer = this.field_147367_d.func_71218_a(this.field_147369_b.field_71093_bK);
/* 701 */     if (worldServer.func_72899_e(p_147343_1_.func_149588_c(), p_147343_1_.func_149586_d(), p_147343_1_.func_149585_e())) {
/* 702 */       TileEntity tileEntity = worldServer.func_147438_o(p_147343_1_.func_149588_c(), p_147343_1_.func_149586_d(), p_147343_1_.func_149585_e());
/*     */       
/* 704 */       if (tileEntity instanceof TileEntitySign) {
/* 705 */         TileEntitySign tileEntitySign = (TileEntitySign)tileEntity;
/* 706 */         if (!tileEntitySign.func_145914_a() || tileEntitySign.func_145911_b() != this.field_147369_b) {
/* 707 */           this.field_147367_d.func_71236_h("Player " + this.field_147369_b.func_70005_c_() + " just tried to change non-editable sign");
/*     */           return;
/*     */         } 
/*     */       } 
/*     */       int i;
/* 712 */       for (i = 0; i < 4; i++) {
/* 713 */         boolean bool = true;
/* 714 */         if (p_147343_1_.func_149589_f()[i].length() > 15) {
/* 715 */           bool = false;
/*     */         } else {
/* 717 */           for (byte b = 0; b < p_147343_1_.func_149589_f()[i].length(); b++) {
/* 718 */             if (!ChatAllowedCharacters.func_71566_a(p_147343_1_.func_149589_f()[i].charAt(b))) {
/* 719 */               bool = false;
/*     */             }
/*     */           } 
/*     */         } 
/* 723 */         if (!bool) {
/* 724 */           p_147343_1_.func_149589_f()[i] = "!?";
/*     */         }
/*     */       } 
/* 727 */       if (tileEntity instanceof TileEntitySign) {
/* 728 */         i = p_147343_1_.func_149588_c();
/* 729 */         int j = p_147343_1_.func_149586_d();
/* 730 */         int k = p_147343_1_.func_149585_e();
/* 731 */         TileEntitySign tileEntitySign = (TileEntitySign)tileEntity;
/* 732 */         System.arraycopy(p_147343_1_.func_149589_f(), 0, tileEntitySign.field_145915_a, 0, 4);
/* 733 */         tileEntitySign.func_70296_d();
/* 734 */         worldServer.func_147471_g(i, j, k);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147353_a(C00PacketKeepAlive p_147353_1_) {
/* 741 */     if (p_147353_1_.func_149460_c() == this.field_147378_h) {
/* 742 */       int i = (int)(func_147363_d() - this.field_147379_i);
/* 743 */       this.field_147369_b.field_71138_i = (this.field_147369_b.field_71138_i * 3 + i) / 4;
/*     */     } 
/*     */   }
/*     */   
/*     */   private long func_147363_d() {
/* 748 */     return System.nanoTime() / 1000000L;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147348_a(C13PacketPlayerAbilities p_147348_1_) {
/* 753 */     this.field_147369_b.field_71075_bZ.field_75100_b = (p_147348_1_.func_149488_d() && this.field_147369_b.field_71075_bZ.field_75101_c);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147341_a(C14PacketTabComplete p_147341_1_) {
/* 758 */     ArrayList<String> arrayList = Lists.newArrayList();
/*     */     
/* 760 */     for (String str : this.field_147367_d.func_71248_a((ICommandSender)this.field_147369_b, p_147341_1_.func_149419_c())) {
/* 761 */       arrayList.add(str);
/*     */     }
/*     */     
/* 764 */     this.field_147369_b.field_71135_a.func_147359_a((Packet)new S3APacketTabComplete(arrayList.<String>toArray(new String[arrayList.size()])));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147352_a(C15PacketClientSettings p_147352_1_) {
/* 769 */     this.field_147369_b.func_147100_a(p_147352_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147349_a(C17PacketCustomPayload p_147349_1_) {
/* 774 */     if ("MC|BEdit".equals(p_147349_1_.func_149559_c())) {
/* 775 */       PacketBuffer packetBuffer = new PacketBuffer(Unpooled.wrappedBuffer(p_147349_1_.func_149558_e()));
/*     */       try {
/* 777 */         ItemStack itemStack1 = packetBuffer.func_150791_c();
/* 778 */         if (itemStack1 == null) {
/*     */           return;
/*     */         }
/*     */         
/* 782 */         if (!ItemWritableBook.func_150930_a(itemStack1.func_77978_p())) {
/* 783 */           throw new IOException("Invalid book tag!");
/*     */         }
/*     */ 
/*     */         
/* 787 */         ItemStack itemStack2 = this.field_147369_b.field_71071_by.func_70448_g();
/* 788 */         if (itemStack2 == null) {
/*     */           return;
/*     */         }
/* 791 */         if (itemStack1.func_77973_b() == Items.field_151099_bA && itemStack1.func_77973_b() == itemStack2.func_77973_b()) {
/* 792 */           itemStack2.func_77983_a("pages", (NBTBase)itemStack1.func_77978_p().func_150295_c("pages", 8));
/*     */         }
/*     */       }
/* 795 */       catch (Exception exception) {
/* 796 */         field_147370_c.error("Couldn't handle book info", exception);
/*     */       } finally {
/* 798 */         packetBuffer.release();
/*     */       } 
/* 800 */     } else if ("MC|BSign".equals(p_147349_1_.func_149559_c())) {
/* 801 */       PacketBuffer packetBuffer = new PacketBuffer(Unpooled.wrappedBuffer(p_147349_1_.func_149558_e()));
/*     */       try {
/* 803 */         ItemStack itemStack1 = packetBuffer.func_150791_c();
/* 804 */         if (itemStack1 == null) {
/*     */           return;
/*     */         }
/*     */         
/* 808 */         if (!ItemEditableBook.func_77828_a(itemStack1.func_77978_p())) {
/* 809 */           throw new IOException("Invalid book tag!");
/*     */         }
/*     */ 
/*     */         
/* 813 */         ItemStack itemStack2 = this.field_147369_b.field_71071_by.func_70448_g();
/* 814 */         if (itemStack2 == null) {
/*     */           return;
/*     */         }
/* 817 */         if (itemStack1.func_77973_b() == Items.field_151164_bB && itemStack2.func_77973_b() == Items.field_151099_bA) {
/* 818 */           itemStack2.func_77983_a("author", (NBTBase)new NBTTagString(this.field_147369_b.func_70005_c_()));
/* 819 */           itemStack2.func_77983_a("title", (NBTBase)new NBTTagString(itemStack1.func_77978_p().func_74779_i("title")));
/* 820 */           itemStack2.func_77983_a("pages", (NBTBase)itemStack1.func_77978_p().func_150295_c("pages", 8));
/* 821 */           itemStack2.func_150996_a(Items.field_151164_bB);
/*     */         }
/*     */       
/* 824 */       } catch (Exception exception) {
/* 825 */         field_147370_c.error("Couldn't sign book", exception);
/*     */       } finally {
/* 827 */         packetBuffer.release();
/*     */       } 
/* 829 */     } else if ("MC|TrSel".equals(p_147349_1_.func_149559_c())) {
/*     */       try {
/* 831 */         DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(p_147349_1_.func_149558_e()));
/* 832 */         int i = dataInputStream.readInt();
/*     */         
/* 834 */         Container container = this.field_147369_b.field_71070_bA;
/* 835 */         if (container instanceof ContainerMerchant) {
/* 836 */           ((ContainerMerchant)container).func_75175_c(i);
/*     */         }
/* 838 */       } catch (Exception exception) {
/* 839 */         field_147370_c.error("Couldn't select trade", exception);
/*     */       } 
/* 841 */     } else if ("MC|AdvCdm".equals(p_147349_1_.func_149559_c())) {
/* 842 */       if (!this.field_147367_d.func_82356_Z()) {
/* 843 */         this.field_147369_b.func_145747_a((IChatComponent)new ChatComponentTranslation("advMode.notEnabled", new Object[0]));
/* 844 */       } else if (this.field_147369_b.func_70003_b(2, "") && this.field_147369_b.field_71075_bZ.field_75098_d) {
/* 845 */         PacketBuffer packetBuffer = new PacketBuffer(Unpooled.wrappedBuffer(p_147349_1_.func_149558_e()));
/*     */         try {
/* 847 */           byte b = packetBuffer.readByte();
/* 848 */           CommandBlockLogic commandBlockLogic = null;
/*     */           
/* 850 */           if (b == 0) {
/* 851 */             TileEntity tileEntity = this.field_147369_b.field_70170_p.func_147438_o(packetBuffer.readInt(), packetBuffer.readInt(), packetBuffer.readInt());
/* 852 */             if (tileEntity instanceof TileEntityCommandBlock) {
/* 853 */               commandBlockLogic = ((TileEntityCommandBlock)tileEntity).func_145993_a();
/*     */             }
/* 855 */           } else if (b == 1) {
/* 856 */             Entity entity = this.field_147369_b.field_70170_p.func_73045_a(packetBuffer.readInt());
/*     */             
/* 858 */             if (entity instanceof EntityMinecartCommandBlock) {
/* 859 */               commandBlockLogic = ((EntityMinecartCommandBlock)entity).func_145822_e();
/*     */             }
/*     */           } 
/*     */           
/* 863 */           String str = packetBuffer.func_150789_c(packetBuffer.readableBytes());
/*     */           
/* 865 */           if (commandBlockLogic != null) {
/* 866 */             commandBlockLogic.func_145752_a(str);
/* 867 */             commandBlockLogic.func_145756_e();
/* 868 */             this.field_147369_b.func_145747_a((IChatComponent)new ChatComponentTranslation("advMode.setCommand.success", new Object[] { str }));
/*     */           } 
/* 870 */         } catch (Exception exception) {
/* 871 */           field_147370_c.error("Couldn't set command block", exception);
/*     */         } finally {
/* 873 */           packetBuffer.release();
/*     */         } 
/*     */       } else {
/* 876 */         this.field_147369_b.func_145747_a((IChatComponent)new ChatComponentTranslation("advMode.notAllowed", new Object[0]));
/*     */       } 
/* 878 */     } else if ("MC|Beacon".equals(p_147349_1_.func_149559_c())) {
/* 879 */       if (this.field_147369_b.field_71070_bA instanceof ContainerBeacon) {
/*     */         try {
/* 881 */           DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(p_147349_1_.func_149558_e()));
/* 882 */           int i = dataInputStream.readInt();
/* 883 */           int j = dataInputStream.readInt();
/*     */           
/* 885 */           ContainerBeacon containerBeacon = (ContainerBeacon)this.field_147369_b.field_71070_bA;
/* 886 */           Slot slot = containerBeacon.func_75139_a(0);
/* 887 */           if (slot.func_75216_d()) {
/* 888 */             slot.func_75209_a(1);
/* 889 */             TileEntityBeacon tileEntityBeacon = containerBeacon.func_148327_e();
/* 890 */             tileEntityBeacon.func_146001_d(i);
/* 891 */             tileEntityBeacon.func_146004_e(j);
/* 892 */             tileEntityBeacon.func_70296_d();
/*     */           } 
/* 894 */         } catch (Exception exception) {
/* 895 */           field_147370_c.error("Couldn't set beacon", exception);
/*     */         } 
/*     */       }
/* 898 */     } else if ("MC|ItemName".equals(p_147349_1_.func_149559_c()) && 
/* 899 */       this.field_147369_b.field_71070_bA instanceof ContainerRepair) {
/* 900 */       ContainerRepair containerRepair = (ContainerRepair)this.field_147369_b.field_71070_bA;
/*     */       
/* 902 */       if (p_147349_1_.func_149558_e() == null || (p_147349_1_.func_149558_e()).length < 1) {
/* 903 */         containerRepair.func_82850_a("");
/*     */       } else {
/* 905 */         String str = ChatAllowedCharacters.func_71565_a(new String(p_147349_1_.func_149558_e(), Charsets.UTF_8));
/* 906 */         if (str.length() <= 30) {
/* 907 */           containerRepair.func_82850_a(str);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147232_a(EnumConnectionState p_147232_1_, EnumConnectionState p_147232_2_) {
/* 916 */     if (p_147232_2_ != EnumConnectionState.PLAY)
/* 917 */       throw new IllegalStateException("Unexpected change in protocol!"); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\NetHandlerPlayServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */