/*    */ package net.minecraft.realms;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Hashtable;
/*    */ import javax.naming.directory.Attributes;
/*    */ import javax.naming.directory.InitialDirContext;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RealmsServerAddress {
/*    */   private final String host;
/*    */   private final int port;
/*    */   private static final String __OBFID = "CL_00001864";
/*    */   
/*    */   protected RealmsServerAddress(String p_i1121_1_, int p_i1121_2_) {
/* 16 */     this.host = p_i1121_1_;
/* 17 */     this.port = p_i1121_2_;
/*    */   }
/*    */   
/*    */   public String getHost() {
/* 21 */     return this.host;
/*    */   }
/*    */   
/*    */   public int getPort() {
/* 25 */     return this.port;
/*    */   }
/*    */   
/*    */   public static RealmsServerAddress parseString(String p_parseString_0_) {
/* 29 */     if (p_parseString_0_ == null) return null;
/*    */     
/* 31 */     String[] arrayOfString = p_parseString_0_.split(":");
/*    */     
/* 33 */     if (p_parseString_0_.startsWith("[")) {
/* 34 */       int j = p_parseString_0_.indexOf("]");
/* 35 */       if (j > 0) {
/* 36 */         String str1 = p_parseString_0_.substring(1, j);
/* 37 */         String str2 = p_parseString_0_.substring(j + 1).trim();
/* 38 */         if (str2.startsWith(":") && str2.length() > 0) {
/* 39 */           str2 = str2.substring(1);
/* 40 */           arrayOfString = new String[2];
/* 41 */           arrayOfString[0] = str1;
/* 42 */           arrayOfString[1] = str2;
/*    */         } else {
/* 44 */           arrayOfString = new String[1];
/* 45 */           arrayOfString[0] = str1;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 50 */     if (arrayOfString.length > 2) {
/* 51 */       arrayOfString = new String[1];
/* 52 */       arrayOfString[0] = p_parseString_0_;
/*    */     } 
/*    */     
/* 55 */     String str = arrayOfString[0];
/* 56 */     int i = (arrayOfString.length > 1) ? parseInt(arrayOfString[1], 25565) : 25565;
/*    */     
/* 58 */     if (i == 25565) {
/* 59 */       String[] arrayOfString1 = lookupSrv(str);
/* 60 */       str = arrayOfString1[0];
/* 61 */       i = parseInt(arrayOfString1[1], 25565);
/*    */     } 
/*    */     
/* 64 */     return new RealmsServerAddress(str, i);
/*    */   }
/*    */   
/*    */   private static String[] lookupSrv(String p_lookupSrv_0_) {
/*    */     try {
/* 69 */       String str = "com.sun.jndi.dns.DnsContextFactory";
/*    */       
/* 71 */       Class.forName("com.sun.jndi.dns.DnsContextFactory");
/*    */       
/* 73 */       Hashtable<Object, Object> hashtable = new Hashtable<Object, Object>();
/* 74 */       hashtable.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
/* 75 */       hashtable.put("java.naming.provider.url", "dns:");
/* 76 */       hashtable.put("com.sun.jndi.dns.timeout.retries", "1");
/* 77 */       InitialDirContext initialDirContext = new InitialDirContext(hashtable);
/* 78 */       Attributes attributes = initialDirContext.getAttributes("_minecraft._tcp." + p_lookupSrv_0_, new String[] { "SRV" });
/* 79 */       String[] arrayOfString = attributes.get("srv").get().toString().split(" ", 4);
/* 80 */       return new String[] { arrayOfString[3], arrayOfString[2] };
/* 81 */     } catch (Throwable throwable) {
/* 82 */       return new String[] { p_lookupSrv_0_, Integer.toString(25565) };
/*    */     } 
/*    */   }
/*    */   
/*    */   private static int parseInt(String p_parseInt_0_, int p_parseInt_1_) {
/*    */     try {
/* 88 */       return Integer.parseInt(p_parseInt_0_.trim());
/* 89 */     } catch (Exception exception) {
/*    */ 
/*    */       
/* 92 */       return p_parseInt_1_;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\realms\RealmsServerAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */