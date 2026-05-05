/*    */ package net.minecraft.util;
/*    */ 
/*    */ import com.google.common.collect.Maps;
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import com.mojang.util.UUIDTypeAdapter;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Map;
/*    */ import java.util.UUID;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class Session
/*    */ {
/*    */   private final String field_74286_b;
/*    */   private final String field_148257_b;
/*    */   
/*    */   public Session(String p_i1098_1_, String p_i1098_2_, String p_i1098_3_, String p_i1098_4_) {
/* 19 */     this.field_74286_b = p_i1098_1_;
/* 20 */     this.field_148257_b = p_i1098_2_;
/* 21 */     this.field_148258_c = p_i1098_3_;
/* 22 */     this.field_152429_d = Type.func_152421_a(p_i1098_4_);
/*    */   }
/*    */   private final String field_148258_c; private final Type field_152429_d; private static final String __OBFID = "CL_00000659";
/*    */   public String func_111286_b() {
/* 26 */     return "token:" + this.field_148258_c + ":" + this.field_148257_b;
/*    */   }
/*    */   
/*    */   public String func_148255_b() {
/* 30 */     return this.field_148257_b;
/*    */   }
/*    */   
/*    */   public String func_111285_a() {
/* 34 */     return this.field_74286_b;
/*    */   }
/*    */   
/*    */   public String func_148254_d() {
/* 38 */     return this.field_148258_c;
/*    */   }
/*    */   
/*    */   public GameProfile func_148256_e() {
/*    */     try {
/* 43 */       UUID uUID = UUIDTypeAdapter.fromString(func_148255_b());
/* 44 */       return new GameProfile(uUID, func_111285_a());
/* 45 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 46 */       return new GameProfile(null, func_111285_a());
/*    */     } 
/*    */   }
/*    */   
/*    */   public Type func_152428_f() {
/* 51 */     return this.field_152429_d;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/* 55 */   public enum Type { LEGACY("legacy"),
/* 56 */     MOJANG("mojang");
/*    */     
/* 58 */     private static final Map field_152425_c = Maps.newHashMap();
/*    */ 
/*    */ 
/*    */     
/*    */     private final String field_152426_d;
/*    */ 
/*    */ 
/*    */     
/*    */     private static final String __OBFID = "CL_00001851";
/*    */ 
/*    */ 
/*    */     
/*    */     static {
/* 71 */       for (Type type : values())
/* 72 */         field_152425_c.put(type.field_152426_d, type); 
/*    */     }
/*    */     
/*    */     Type(String p_i1096_3_) {
/*    */       this.field_152426_d = p_i1096_3_;
/*    */     }
/*    */     
/*    */     public static Type func_152421_a(String p_152421_0_) {
/*    */       return (Type)field_152425_c.get(p_152421_0_.toLowerCase());
/*    */     } }
/*    */ 
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\Session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */