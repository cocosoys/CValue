/*    */ package net.minecraft.client.multiplayer;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Hashtable;
/*    */ import javax.naming.directory.Attributes;
/*    */ import javax.naming.directory.InitialDirContext;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ServerAddress
/*    */ {
/*    */   private final String field_78866_a;
/*    */   
/*    */   protected ServerAddress(String p_i1192_1_, int p_i1192_2_) {
/* 15 */     this.field_78866_a = p_i1192_1_;
/* 16 */     this.field_78865_b = p_i1192_2_;
/*    */   }
/*    */   private final int field_78865_b; private static final String __OBFID = "CL_00000889";
/*    */   public String func_78861_a() {
/* 20 */     return this.field_78866_a;
/*    */   }
/*    */   
/*    */   public int func_78864_b() {
/* 24 */     return this.field_78865_b;
/*    */   }
/*    */   
/*    */   public static ServerAddress func_78860_a(String p_78860_0_) {
/* 28 */     if (p_78860_0_ == null) return null;
/*    */     
/* 30 */     String[] arrayOfString = p_78860_0_.split(":");
/*    */     
/* 32 */     if (p_78860_0_.startsWith("[")) {
/* 33 */       int j = p_78860_0_.indexOf("]");
/* 34 */       if (j > 0) {
/* 35 */         String str1 = p_78860_0_.substring(1, j);
/* 36 */         String str2 = p_78860_0_.substring(j + 1).trim();
/* 37 */         if (str2.startsWith(":") && str2.length() > 0) {
/* 38 */           str2 = str2.substring(1);
/* 39 */           arrayOfString = new String[2];
/* 40 */           arrayOfString[0] = str1;
/* 41 */           arrayOfString[1] = str2;
/*    */         } else {
/* 43 */           arrayOfString = new String[1];
/* 44 */           arrayOfString[0] = str1;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 49 */     if (arrayOfString.length > 2) {
/* 50 */       arrayOfString = new String[1];
/* 51 */       arrayOfString[0] = p_78860_0_;
/*    */     } 
/*    */     
/* 54 */     String str = arrayOfString[0];
/* 55 */     int i = (arrayOfString.length > 1) ? func_78862_a(arrayOfString[1], 25565) : 25565;
/*    */     
/* 57 */     if (i == 25565) {
/* 58 */       String[] arrayOfString1 = func_78863_b(str);
/* 59 */       str = arrayOfString1[0];
/* 60 */       i = func_78862_a(arrayOfString1[1], 25565);
/*    */     } 
/*    */     
/* 63 */     return new ServerAddress(str, i);
/*    */   }
/*    */   
/*    */   private static String[] func_78863_b(String p_78863_0_) {
/*    */     try {
/* 68 */       String str = "com.sun.jndi.dns.DnsContextFactory";
/*    */       
/* 70 */       Class.forName("com.sun.jndi.dns.DnsContextFactory");
/*    */       
/* 72 */       Hashtable<Object, Object> hashtable = new Hashtable<Object, Object>();
/* 73 */       hashtable.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
/* 74 */       hashtable.put("java.naming.provider.url", "dns:");
/* 75 */       hashtable.put("com.sun.jndi.dns.timeout.retries", "1");
/* 76 */       InitialDirContext initialDirContext = new InitialDirContext(hashtable);
/* 77 */       Attributes attributes = initialDirContext.getAttributes("_minecraft._tcp." + p_78863_0_, new String[] { "SRV" });
/* 78 */       String[] arrayOfString = attributes.get("srv").get().toString().split(" ", 4);
/* 79 */       return new String[] { arrayOfString[3], arrayOfString[2] };
/* 80 */     } catch (Throwable throwable) {
/* 81 */       return new String[] { p_78863_0_, Integer.toString(25565) };
/*    */     } 
/*    */   }
/*    */   
/*    */   private static int func_78862_a(String p_78862_0_, int p_78862_1_) {
/*    */     try {
/* 87 */       return Integer.parseInt(p_78862_0_.trim());
/* 88 */     } catch (Exception exception) {
/*    */ 
/*    */       
/* 91 */       return p_78862_1_;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\multiplayer\ServerAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */