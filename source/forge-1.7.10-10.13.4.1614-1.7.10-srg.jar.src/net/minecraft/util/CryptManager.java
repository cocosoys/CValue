/*     */ package net.minecraft.util;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.security.GeneralSecurityException;
/*     */ import java.security.Key;
/*     */ import java.security.KeyFactory;
/*     */ import java.security.KeyPairGenerator;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.PrivateKey;
/*     */ import java.security.PublicKey;
/*     */ import java.security.spec.X509EncodedKeySpec;
/*     */ import javax.crypto.BadPaddingException;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.KeyGenerator;
/*     */ import javax.crypto.SecretKey;
/*     */ 
/*     */ public class CryptManager {
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static SecretKey func_75890_a() {
/*     */     try {
/*  22 */       KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
/*  23 */       keyGenerator.init(128);
/*  24 */       return keyGenerator.generateKey();
/*  25 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*  26 */       throw new Error(noSuchAlgorithmException);
/*     */     } 
/*     */   }
/*     */   private static final String __OBFID = "CL_00001483";
/*     */   public static KeyPair func_75891_b() {
/*     */     try {
/*  32 */       KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
/*  33 */       keyPairGenerator.initialize(1024);
/*     */       
/*  35 */       return keyPairGenerator.generateKeyPair();
/*  36 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*  37 */       noSuchAlgorithmException.printStackTrace();
/*     */       
/*  39 */       System.err.println("Key pair generation failed!");
/*  40 */       return null;
/*     */     } 
/*     */   }
/*     */   public static byte[] func_75895_a(String p_75895_0_, PublicKey p_75895_1_, SecretKey p_75895_2_) {
/*     */     try {
/*  45 */       return func_75893_a("SHA-1", new byte[][] { p_75895_0_.getBytes("ISO_8859_1"), p_75895_2_.getEncoded(), p_75895_1_.getEncoded() });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*  51 */     catch (UnsupportedEncodingException unsupportedEncodingException) {
/*  52 */       unsupportedEncodingException.printStackTrace();
/*     */ 
/*     */       
/*  55 */       return null;
/*     */     } 
/*     */   }
/*     */   private static byte[] func_75893_a(String p_75893_0_, byte[]... p_75893_1_) {
/*     */     try {
/*  60 */       MessageDigest messageDigest = MessageDigest.getInstance(p_75893_0_);
/*  61 */       for (byte[] arrayOfByte : p_75893_1_) {
/*  62 */         messageDigest.update(arrayOfByte);
/*     */       }
/*  64 */       return messageDigest.digest();
/*  65 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*  66 */       noSuchAlgorithmException.printStackTrace();
/*     */ 
/*     */       
/*  69 */       return null;
/*     */     } 
/*     */   }
/*     */   public static PublicKey func_75896_a(byte[] p_75896_0_) {
/*     */     
/*  74 */     try { X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(p_75896_0_);
/*  75 */       KeyFactory keyFactory = KeyFactory.getInstance("RSA");
/*  76 */       return keyFactory.generatePublic(x509EncodedKeySpec); }
/*  77 */     catch (NoSuchAlgorithmException noSuchAlgorithmException) {  }
/*  78 */     catch (InvalidKeySpecException invalidKeySpecException) {}
/*     */     
/*  80 */     System.err.println("Public key reconstitute failed!");
/*  81 */     return null;
/*     */   }
/*     */   
/*     */   public static SecretKey func_75887_a(PrivateKey p_75887_0_, byte[] p_75887_1_) {
/*  85 */     return new SecretKeySpec(func_75889_b(p_75887_0_, p_75887_1_), "AES");
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static byte[] func_75894_a(Key p_75894_0_, byte[] p_75894_1_) {
/*  89 */     return func_75885_a(1, p_75894_0_, p_75894_1_);
/*     */   }
/*     */   
/*     */   public static byte[] func_75889_b(Key p_75889_0_, byte[] p_75889_1_) {
/*  93 */     return func_75885_a(2, p_75889_0_, p_75889_1_);
/*     */   }
/*     */   
/*     */   private static byte[] func_75885_a(int p_75885_0_, Key p_75885_1_, byte[] p_75885_2_) {
/*     */     try {
/*  98 */       return func_75886_a(p_75885_0_, p_75885_1_.getAlgorithm(), p_75885_1_).doFinal(p_75885_2_);
/*  99 */     } catch (IllegalBlockSizeException illegalBlockSizeException) {
/* 100 */       illegalBlockSizeException.printStackTrace();
/* 101 */     } catch (BadPaddingException badPaddingException) {
/* 102 */       badPaddingException.printStackTrace();
/*     */     } 
/* 104 */     System.err.println("Cipher data failed!");
/* 105 */     return null;
/*     */   }
/*     */   
/*     */   private static Cipher func_75886_a(int p_75886_0_, String p_75886_1_, Key p_75886_2_) {
/*     */     try {
/* 110 */       Cipher cipher = Cipher.getInstance(p_75886_1_);
/* 111 */       cipher.init(p_75886_0_, p_75886_2_);
/* 112 */       return cipher;
/* 113 */     } catch (InvalidKeyException invalidKeyException) {
/* 114 */       invalidKeyException.printStackTrace();
/* 115 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/* 116 */       noSuchAlgorithmException.printStackTrace();
/* 117 */     } catch (NoSuchPaddingException noSuchPaddingException) {
/* 118 */       noSuchPaddingException.printStackTrace();
/*     */     } 
/* 120 */     System.err.println("Cipher creation failed!");
/* 121 */     return null;
/*     */   }
/*     */   
/*     */   public static Cipher func_151229_a(int p_151229_0_, Key p_151229_1_) {
/*     */     try {
/* 126 */       Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
/* 127 */       cipher.init(p_151229_0_, p_151229_1_, new IvParameterSpec(p_151229_1_.getEncoded()));
/* 128 */       return cipher;
/* 129 */     } catch (GeneralSecurityException generalSecurityException) {
/* 130 */       throw new RuntimeException(generalSecurityException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\CryptManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */