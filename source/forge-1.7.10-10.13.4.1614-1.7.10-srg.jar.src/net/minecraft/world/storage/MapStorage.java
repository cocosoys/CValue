/*     */ package net.minecraft.world.storage;
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
/*     */ import net.minecraft.nbt.CompressedStreamTools;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagShort;
/*     */ import net.minecraft.world.WorldSavedData;
/*     */ 
/*     */ public class MapStorage
/*     */ {
/*     */   private ISaveHandler field_75751_a;
/*  21 */   private Map field_75749_b = new HashMap<Object, Object>();
/*  22 */   private List field_75750_c = new ArrayList();
/*  23 */   private Map field_75748_d = new HashMap<Object, Object>();
/*     */   
/*     */   public MapStorage(ISaveHandler p_i2162_1_) {
/*  26 */     this.field_75751_a = p_i2162_1_;
/*  27 */     func_75746_b();
/*     */   }
/*     */   private static final String __OBFID = "CL_00000604";
/*     */   public WorldSavedData func_75742_a(Class<WorldSavedData> p_75742_1_, String p_75742_2_) {
/*  31 */     WorldSavedData worldSavedData = (WorldSavedData)this.field_75749_b.get(p_75742_2_);
/*  32 */     if (worldSavedData != null) return worldSavedData;
/*     */     
/*  34 */     if (this.field_75751_a != null) {
/*     */       try {
/*  36 */         File file = this.field_75751_a.func_75758_b(p_75742_2_);
/*  37 */         if (file != null && file.exists()) {
/*     */           try {
/*  39 */             worldSavedData = p_75742_1_.getConstructor(new Class[] { String.class }).newInstance(new Object[] { p_75742_2_ });
/*  40 */           } catch (Exception exception) {
/*  41 */             throw new RuntimeException("Failed to instantiate " + p_75742_1_.toString(), exception);
/*     */           } 
/*     */           
/*  44 */           FileInputStream fileInputStream = new FileInputStream(file);
/*  45 */           NBTTagCompound nBTTagCompound = CompressedStreamTools.func_74796_a(fileInputStream);
/*  46 */           fileInputStream.close();
/*     */           
/*  48 */           worldSavedData.func_76184_a(nBTTagCompound.func_74775_l("data"));
/*     */         } 
/*  50 */       } catch (Exception exception) {
/*  51 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/*  55 */     if (worldSavedData != null) {
/*  56 */       this.field_75749_b.put(p_75742_2_, worldSavedData);
/*  57 */       this.field_75750_c.add(worldSavedData);
/*     */     } 
/*  59 */     return worldSavedData;
/*     */   }
/*     */   
/*     */   public void func_75745_a(String p_75745_1_, WorldSavedData p_75745_2_) {
/*  63 */     if (p_75745_2_ == null) throw new RuntimeException("Can't set null data"); 
/*  64 */     if (this.field_75749_b.containsKey(p_75745_1_)) {
/*  65 */       this.field_75750_c.remove(this.field_75749_b.remove(p_75745_1_));
/*     */     }
/*  67 */     this.field_75749_b.put(p_75745_1_, p_75745_2_);
/*  68 */     this.field_75750_c.add(p_75745_2_);
/*     */   }
/*     */   
/*     */   public void func_75744_a() {
/*  72 */     for (byte b = 0; b < this.field_75750_c.size(); b++) {
/*  73 */       WorldSavedData worldSavedData = this.field_75750_c.get(b);
/*  74 */       if (worldSavedData.func_76188_b()) {
/*  75 */         func_75747_a(worldSavedData);
/*  76 */         worldSavedData.func_76186_a(false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_75747_a(WorldSavedData p_75747_1_) {
/*  82 */     if (this.field_75751_a == null)
/*     */       return;  try {
/*  84 */       File file = this.field_75751_a.func_75758_b(p_75747_1_.field_76190_i);
/*  85 */       if (file != null) {
/*  86 */         NBTTagCompound nBTTagCompound1 = new NBTTagCompound();
/*  87 */         p_75747_1_.func_76187_b(nBTTagCompound1);
/*     */         
/*  89 */         NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
/*  90 */         nBTTagCompound2.func_74782_a("data", (NBTBase)nBTTagCompound1);
/*     */         
/*  92 */         FileOutputStream fileOutputStream = new FileOutputStream(file);
/*  93 */         CompressedStreamTools.func_74799_a(nBTTagCompound2, fileOutputStream);
/*  94 */         fileOutputStream.close();
/*     */       } 
/*  96 */     } catch (Exception exception) {
/*  97 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_75746_b() {
/*     */     try {
/* 103 */       this.field_75748_d.clear();
/* 104 */       if (this.field_75751_a == null)
/* 105 */         return;  File file = this.field_75751_a.func_75758_b("idcounts");
/* 106 */       if (file != null && file.exists()) {
/* 107 */         DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
/* 108 */         NBTTagCompound nBTTagCompound = CompressedStreamTools.func_74794_a(dataInputStream);
/* 109 */         dataInputStream.close();
/*     */         
/* 111 */         for (String str : nBTTagCompound.func_150296_c()) {
/* 112 */           NBTBase nBTBase = nBTTagCompound.func_74781_a(str);
/* 113 */           if (nBTBase instanceof NBTTagShort) {
/* 114 */             NBTTagShort nBTTagShort = (NBTTagShort)nBTBase;
/* 115 */             String str1 = str;
/* 116 */             short s = nBTTagShort.func_150289_e();
/* 117 */             this.field_75748_d.put(str1, Short.valueOf(s));
/*     */           } 
/*     */         } 
/*     */       } 
/* 121 */     } catch (Exception exception) {
/* 122 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public int func_75743_a(String p_75743_1_) {
/* 127 */     Short short_ = (Short)this.field_75748_d.get(p_75743_1_);
/* 128 */     if (short_ == null) {
/* 129 */       short_ = Short.valueOf((short)0);
/*     */     } else {
/* 131 */       Short short_1 = short_, short_2 = short_ = Short.valueOf((short)(short_.shortValue() + 1));
/*     */     } 
/*     */     
/* 134 */     this.field_75748_d.put(p_75743_1_, short_);
/* 135 */     if (this.field_75751_a == null) return short_.shortValue(); 
/*     */     try {
/* 137 */       File file = this.field_75751_a.func_75758_b("idcounts");
/* 138 */       if (file != null) {
/* 139 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */         
/* 141 */         for (String str : this.field_75748_d.keySet()) {
/* 142 */           short s = ((Short)this.field_75748_d.get(str)).shortValue();
/* 143 */           nBTTagCompound.func_74777_a(str, s);
/*     */         } 
/*     */         
/* 146 */         DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
/* 147 */         CompressedStreamTools.func_74800_a(nBTTagCompound, dataOutputStream);
/* 148 */         dataOutputStream.close();
/*     */       } 
/* 150 */     } catch (Exception exception) {
/* 151 */       exception.printStackTrace();
/*     */     } 
/* 153 */     return short_.shortValue();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\storage\MapStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */