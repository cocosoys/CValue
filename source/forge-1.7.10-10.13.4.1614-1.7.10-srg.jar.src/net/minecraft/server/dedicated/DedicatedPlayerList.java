/*     */ package net.minecraft.server.dedicated;
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ @SideOnly(Side.SERVER)
/*     */ public class DedicatedPlayerList extends ServerConfigurationManager {
/*  11 */   private static final Logger field_164439_d = LogManager.getLogger(); private static final String __OBFID = "CL_00001783";
/*     */   
/*     */   public DedicatedPlayerList(DedicatedServer p_i1503_1_) {
/*  14 */     super(p_i1503_1_);
/*     */     
/*  16 */     func_152611_a(p_i1503_1_.func_71327_a("view-distance", 10));
/*  17 */     this.field_72405_c = p_i1503_1_.func_71327_a("max-players", 20);
/*  18 */     func_72371_a(p_i1503_1_.func_71332_a("white-list", false));
/*     */     
/*  20 */     if (!p_i1503_1_.func_71264_H()) {
/*  21 */       func_152608_h().func_152686_a(true);
/*  22 */       func_72363_f().func_152686_a(true);
/*     */     } 
/*     */     
/*  25 */     func_152620_y();
/*  26 */     func_152617_w();
/*  27 */     func_152619_x();
/*  28 */     func_152618_v();
/*  29 */     func_72417_t();
/*  30 */     func_72418_v();
/*  31 */     func_72419_u();
/*  32 */     if (!func_152599_k().func_152691_c().exists()) {
/*  33 */       func_72421_w();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72371_a(boolean p_72371_1_) {
/*  39 */     super.func_72371_a(p_72371_1_);
/*  40 */     func_72365_p().func_71328_a("white-list", Boolean.valueOf(p_72371_1_));
/*  41 */     func_72365_p().func_71326_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152605_a(GameProfile p_152605_1_) {
/*  46 */     super.func_152605_a(p_152605_1_);
/*  47 */     func_72419_u();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152610_b(GameProfile p_152610_1_) {
/*  52 */     super.func_152610_b(p_152610_1_);
/*  53 */     func_72419_u();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152597_c(GameProfile p_152597_1_) {
/*  58 */     super.func_152597_c(p_152597_1_);
/*  59 */     func_72421_w();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_152601_d(GameProfile p_152601_1_) {
/*  64 */     super.func_152601_d(p_152601_1_);
/*  65 */     func_72421_w();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_72362_j() {
/*  70 */     func_72418_v();
/*     */   }
/*     */   
/*     */   private void func_152618_v() {
/*     */     try {
/*  75 */       func_72363_f().func_152678_f();
/*  76 */     } catch (IOException iOException) {
/*  77 */       field_164439_d.warn("Failed to save ip banlist: ", iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_152617_w() {
/*     */     try {
/*  83 */       func_152608_h().func_152678_f();
/*  84 */     } catch (IOException iOException) {
/*  85 */       field_164439_d.warn("Failed to save user banlist: ", iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_152619_x() {
/*     */     try {
/*  91 */       func_72363_f().func_152679_g();
/*  92 */     } catch (IOException iOException) {
/*  93 */       field_164439_d.warn("Failed to load ip banlist: ", iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_152620_y() {
/*     */     try {
/*  99 */       func_152608_h().func_152679_g();
/* 100 */     } catch (IOException iOException) {
/* 101 */       field_164439_d.warn("Failed to load user banlist: ", iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_72417_t() {
/*     */     try {
/* 107 */       func_152603_m().func_152679_g();
/* 108 */     } catch (Exception exception) {
/* 109 */       field_164439_d.warn("Failed to load operators list: ", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_72419_u() {
/*     */     try {
/* 115 */       func_152603_m().func_152678_f();
/* 116 */     } catch (Exception exception) {
/* 117 */       field_164439_d.warn("Failed to save operators list: ", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_72418_v() {
/*     */     try {
/* 123 */       func_152599_k().func_152679_g();
/* 124 */     } catch (Exception exception) {
/* 125 */       field_164439_d.warn("Failed to load white-list: ", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_72421_w() {
/*     */     try {
/* 131 */       func_152599_k().func_152678_f();
/* 132 */     } catch (Exception exception) {
/* 133 */       field_164439_d.warn("Failed to save white-list: ", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_152607_e(GameProfile p_152607_1_) {
/* 139 */     return (!func_72383_n() || func_152596_g(p_152607_1_) || func_152599_k().func_152705_a(p_152607_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public DedicatedServer func_72365_p() {
/* 144 */     return (DedicatedServer)super.func_72365_p();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\dedicated\DedicatedPlayerList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */