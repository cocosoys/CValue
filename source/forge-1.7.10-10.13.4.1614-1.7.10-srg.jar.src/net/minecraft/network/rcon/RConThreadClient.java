/*     */ package net.minecraft.network.rcon;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.net.Socket;
/*     */ import java.net.SocketTimeoutException;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.SERVER)
/*     */ public class RConThreadClient
/*     */   extends RConThreadBase
/*     */ {
/*  20 */   private static final Logger field_164005_h = LogManager.getLogger();
/*     */ 
/*     */   
/*     */   private boolean field_72657_g;
/*     */ 
/*     */   
/*     */   private Socket field_72659_h;
/*     */   
/*  28 */   private byte[] field_72660_i = new byte[1460];
/*     */   private String field_72658_j;
/*     */   
/*     */   RConThreadClient(IServer p_i1537_1_, Socket p_i1537_2_) {
/*  32 */     super(p_i1537_1_, "RCON Client");
/*  33 */     this.field_72659_h = p_i1537_2_;
/*     */     
/*     */     try {
/*  36 */       this.field_72659_h.setSoTimeout(0);
/*  37 */     } catch (Exception exception) {
/*  38 */       this.field_72619_a = false;
/*     */     } 
/*     */     
/*  41 */     this.field_72658_j = p_i1537_1_.func_71330_a("rcon.password", "");
/*  42 */     func_72609_b("Rcon connection from: " + p_i1537_2_.getInetAddress());
/*     */   }
/*     */   private static final String __OBFID = "CL_00001804";
/*     */   
/*     */   public void run() {
/*     */     try {
/*  48 */       while (this.field_72619_a) {
/*  49 */         String str; BufferedInputStream bufferedInputStream = new BufferedInputStream(this.field_72659_h.getInputStream());
/*  50 */         int i = bufferedInputStream.read(this.field_72660_i, 0, 1460);
/*     */         
/*  52 */         if (10 > i) {
/*     */           return;
/*     */         }
/*     */         
/*  56 */         int j = 0;
/*  57 */         int k = RConUtils.func_72665_b(this.field_72660_i, 0, i);
/*  58 */         if (k != i - 4) {
/*     */           return;
/*     */         }
/*     */         
/*  62 */         j += true;
/*  63 */         int m = RConUtils.func_72665_b(this.field_72660_i, j, i);
/*  64 */         j += true;
/*     */         
/*  66 */         int n = RConUtils.func_72662_b(this.field_72660_i, j);
/*  67 */         j += true;
/*  68 */         switch (n) {
/*     */           case 3:
/*  70 */             str = RConUtils.func_72661_a(this.field_72660_i, j, i);
/*  71 */             j += str.length();
/*  72 */             if (0 != str.length() && str.equals(this.field_72658_j)) {
/*  73 */               this.field_72657_g = true;
/*  74 */               func_72654_a(m, 2, ""); continue;
/*     */             } 
/*  76 */             this.field_72657_g = false;
/*  77 */             func_72656_f();
/*     */             continue;
/*     */           
/*     */           case 2:
/*  81 */             if (this.field_72657_g) {
/*  82 */               String str1 = RConUtils.func_72661_a(this.field_72660_i, j, i);
/*     */               try {
/*  84 */                 func_72655_a(m, this.field_72617_b.func_71252_i(str1));
/*  85 */               } catch (Exception exception) {
/*  86 */                 func_72655_a(m, "Error executing: " + str1 + " (" + exception.getMessage() + ")");
/*     */               }  continue;
/*     */             } 
/*  89 */             func_72656_f();
/*     */             continue;
/*     */         } 
/*     */         
/*  93 */         func_72655_a(m, String.format("Unknown request %s", new Object[] { Integer.toHexString(n) }));
/*     */       }
/*     */     
/*  96 */     } catch (SocketTimeoutException socketTimeoutException) {
/*     */     
/*  98 */     } catch (IOException iOException) {
/*     */     
/* 100 */     } catch (Exception exception) {
/* 101 */       field_164005_h.error("Exception whilst parsing RCON input", exception);
/*     */     } finally {
/* 103 */       func_72653_g();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void func_72654_a(int p_72654_1_, int p_72654_2_, String p_72654_3_) throws IOException {
/* 110 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1248);
/* 111 */     DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
/* 112 */     byte[] arrayOfByte = p_72654_3_.getBytes("UTF-8");
/* 113 */     dataOutputStream.writeInt(Integer.reverseBytes(arrayOfByte.length + 10));
/* 114 */     dataOutputStream.writeInt(Integer.reverseBytes(p_72654_1_));
/* 115 */     dataOutputStream.writeInt(Integer.reverseBytes(p_72654_2_));
/* 116 */     dataOutputStream.write(arrayOfByte);
/* 117 */     dataOutputStream.write(0);
/* 118 */     dataOutputStream.write(0);
/* 119 */     this.field_72659_h.getOutputStream().write(byteArrayOutputStream.toByteArray());
/*     */   }
/*     */   
/*     */   private void func_72656_f() throws IOException {
/* 123 */     func_72654_a(-1, 2, "");
/*     */   }
/*     */   
/*     */   private void func_72655_a(int p_72655_1_, String p_72655_2_) throws IOException {
/* 127 */     int i = p_72655_2_.length();
/*     */     
/*     */     do {
/* 130 */       boolean bool = (4096 <= i) ? true : i;
/* 131 */       func_72654_a(p_72655_1_, 0, p_72655_2_.substring(0, bool));
/* 132 */       p_72655_2_ = p_72655_2_.substring(bool);
/* 133 */       i = p_72655_2_.length();
/* 134 */     } while (0 != i);
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
/*     */   private void func_72653_g() {
/* 147 */     if (null == this.field_72659_h) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 152 */       this.field_72659_h.close();
/* 153 */     } catch (IOException iOException) {
/* 154 */       func_72606_c("IO: " + iOException.getMessage());
/*     */     } 
/* 156 */     this.field_72659_h = null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\rcon\RConThreadClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */