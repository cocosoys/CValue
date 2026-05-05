/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PersistentCollection
/*     */ {
/*     */   private IDataManager a;
/*  21 */   private Map b = new HashMap<Object, Object>();
/*  22 */   private List c = new ArrayList();
/*  23 */   private Map d = new HashMap<Object, Object>();
/*     */   
/*     */   public PersistentCollection(IDataManager paramIDataManager) {
/*  26 */     this.a = paramIDataManager;
/*  27 */     b();
/*     */   }
/*     */   
/*     */   public PersistentBase get(Class<PersistentBase> paramClass, String paramString) {
/*  31 */     PersistentBase persistentBase = (PersistentBase)this.b.get(paramString);
/*  32 */     if (persistentBase != null) return persistentBase;
/*     */     
/*  34 */     if (this.a != null) {
/*     */       try {
/*  36 */         File file = this.a.getDataFile(paramString);
/*  37 */         if (file != null && file.exists()) {
/*     */           try {
/*  39 */             persistentBase = paramClass.getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
/*  40 */           } catch (Exception exception) {
/*  41 */             throw new RuntimeException("Failed to instantiate " + paramClass.toString(), exception);
/*     */           } 
/*     */           
/*  44 */           FileInputStream fileInputStream = new FileInputStream(file);
/*  45 */           NBTTagCompound nBTTagCompound = NBTCompressedStreamTools.a(fileInputStream);
/*  46 */           fileInputStream.close();
/*     */           
/*  48 */           persistentBase.a(nBTTagCompound.getCompound("data"));
/*     */         } 
/*  50 */       } catch (Exception exception) {
/*  51 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/*  55 */     if (persistentBase != null) {
/*  56 */       this.b.put(paramString, persistentBase);
/*  57 */       this.c.add(persistentBase);
/*     */     } 
/*  59 */     return persistentBase;
/*     */   }
/*     */   
/*     */   public void a(String paramString, PersistentBase paramPersistentBase) {
/*  63 */     if (paramPersistentBase == null) throw new RuntimeException("Can't set null data"); 
/*  64 */     if (this.b.containsKey(paramString)) {
/*  65 */       this.c.remove(this.b.remove(paramString));
/*     */     }
/*  67 */     this.b.put(paramString, paramPersistentBase);
/*  68 */     this.c.add(paramPersistentBase);
/*     */   }
/*     */   
/*     */   public void a() {
/*  72 */     for (byte b = 0; b < this.c.size(); b++) {
/*  73 */       PersistentBase persistentBase = this.c.get(b);
/*  74 */       if (persistentBase.d()) {
/*  75 */         a(persistentBase);
/*  76 */         persistentBase.a(false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(PersistentBase paramPersistentBase) {
/*  82 */     if (this.a == null)
/*     */       return;  try {
/*  84 */       File file = this.a.getDataFile(paramPersistentBase.id);
/*  85 */       if (file != null) {
/*  86 */         NBTTagCompound nBTTagCompound1 = new NBTTagCompound();
/*  87 */         paramPersistentBase.b(nBTTagCompound1);
/*     */         
/*  89 */         NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
/*  90 */         nBTTagCompound2.set("data", nBTTagCompound1);
/*     */         
/*  92 */         FileOutputStream fileOutputStream = new FileOutputStream(file);
/*  93 */         NBTCompressedStreamTools.a(nBTTagCompound2, fileOutputStream);
/*  94 */         fileOutputStream.close();
/*     */       } 
/*  96 */     } catch (Exception exception) {
/*  97 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b() {
/*     */     try {
/* 103 */       this.d.clear();
/* 104 */       if (this.a == null)
/* 105 */         return;  File file = this.a.getDataFile("idcounts");
/* 106 */       if (file != null && file.exists()) {
/* 107 */         DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
/* 108 */         NBTTagCompound nBTTagCompound = NBTCompressedStreamTools.a(dataInputStream);
/* 109 */         dataInputStream.close();
/*     */         
/* 111 */         for (String str : nBTTagCompound.c()) {
/* 112 */           NBTBase nBTBase = nBTTagCompound.get(str);
/* 113 */           if (nBTBase instanceof NBTTagShort) {
/* 114 */             NBTTagShort nBTTagShort = (NBTTagShort)nBTBase;
/* 115 */             String str1 = str;
/* 116 */             short s = nBTTagShort.e();
/* 117 */             this.d.put(str1, Short.valueOf(s));
/*     */           } 
/*     */         } 
/*     */       } 
/* 121 */     } catch (Exception exception) {
/* 122 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public int a(String paramString) {
/* 127 */     Short short_ = (Short)this.d.get(paramString);
/* 128 */     if (short_ == null) {
/* 129 */       short_ = Short.valueOf((short)0);
/*     */     } else {
/* 131 */       Short short_1 = short_, short_2 = short_ = Short.valueOf((short)(short_.shortValue() + 1));
/*     */     } 
/*     */     
/* 134 */     this.d.put(paramString, short_);
/* 135 */     if (this.a == null) return short_.shortValue(); 
/*     */     try {
/* 137 */       File file = this.a.getDataFile("idcounts");
/* 138 */       if (file != null) {
/* 139 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */         
/* 141 */         for (String str : this.d.keySet()) {
/* 142 */           short s = ((Short)this.d.get(str)).shortValue();
/* 143 */           nBTTagCompound.setShort(str, s);
/*     */         } 
/*     */         
/* 146 */         DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
/* 147 */         NBTCompressedStreamTools.a(nBTTagCompound, dataOutputStream);
/* 148 */         dataOutputStream.close();
/*     */       } 
/* 150 */     } catch (Exception exception) {
/* 151 */       exception.printStackTrace();
/*     */     } 
/* 153 */     return short_.shortValue();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PersistentCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */