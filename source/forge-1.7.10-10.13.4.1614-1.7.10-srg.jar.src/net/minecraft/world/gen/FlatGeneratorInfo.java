/*     */ package net.minecraft.world.gen;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FlatGeneratorInfo
/*     */ {
/*  22 */   private final List field_82655_a = new ArrayList();
/*  23 */   private final Map field_82653_b = new HashMap<Object, Object>();
/*     */   private int field_82654_c;
/*     */   
/*     */   public int func_82648_a() {
/*  27 */     return this.field_82654_c;
/*     */   }
/*     */   private static final String __OBFID = "CL_00000440";
/*     */   public void func_82647_a(int p_82647_1_) {
/*  31 */     this.field_82654_c = p_82647_1_;
/*     */   }
/*     */   
/*     */   public Map func_82644_b() {
/*  35 */     return this.field_82653_b;
/*     */   }
/*     */   
/*     */   public List func_82650_c() {
/*  39 */     return this.field_82655_a;
/*     */   }
/*     */   
/*     */   public void func_82645_d() {
/*  43 */     int i = 0;
/*     */     
/*  45 */     for (FlatLayerInfo flatLayerInfo : this.field_82655_a) {
/*  46 */       flatLayerInfo.func_82660_d(i);
/*  47 */       i += flatLayerInfo.func_82657_a();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  53 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*  55 */     stringBuilder.append(2);
/*  56 */     stringBuilder.append(";");
/*     */     byte b;
/*  58 */     for (b = 0; b < this.field_82655_a.size(); b++) {
/*  59 */       if (b > 0) stringBuilder.append(","); 
/*  60 */       stringBuilder.append(((FlatLayerInfo)this.field_82655_a.get(b)).toString());
/*     */     } 
/*     */     
/*  63 */     stringBuilder.append(";");
/*  64 */     stringBuilder.append(this.field_82654_c);
/*     */     
/*  66 */     if (!this.field_82653_b.isEmpty()) {
/*  67 */       stringBuilder.append(";");
/*  68 */       b = 0;
/*     */       
/*  70 */       for (Map.Entry entry : this.field_82653_b.entrySet()) {
/*  71 */         if (b++ > 0) stringBuilder.append(","); 
/*  72 */         stringBuilder.append(((String)entry.getKey()).toLowerCase());
/*     */         
/*  74 */         Map map = (Map)entry.getValue();
/*  75 */         if (!map.isEmpty()) {
/*  76 */           stringBuilder.append("(");
/*  77 */           byte b1 = 0;
/*     */           
/*  79 */           for (Map.Entry entry1 : map.entrySet()) {
/*  80 */             if (b1++ > 0) stringBuilder.append(" "); 
/*  81 */             stringBuilder.append((String)entry1.getKey());
/*  82 */             stringBuilder.append("=");
/*  83 */             stringBuilder.append((String)entry1.getValue());
/*     */           } 
/*     */           
/*  86 */           stringBuilder.append(")");
/*     */         } 
/*     */       } 
/*     */     } else {
/*  90 */       stringBuilder.append(";");
/*     */     } 
/*     */     
/*  93 */     return stringBuilder.toString();
/*     */   }
/*     */   private static FlatLayerInfo func_82646_a(String p_82646_0_, int p_82646_1_) {
/*     */     int j;
/*  97 */     String[] arrayOfString = p_82646_0_.split("x", 2);
/*  98 */     int i = 1;
/*     */     
/* 100 */     int k = 0;
/*     */     
/* 102 */     if (arrayOfString.length == 2) {
/*     */       try {
/* 104 */         i = Integer.parseInt(arrayOfString[0]);
/* 105 */         if (p_82646_1_ + i >= 256) i = 256 - p_82646_1_; 
/* 106 */         if (i < 0) i = 0; 
/* 107 */       } catch (Throwable throwable) {
/* 108 */         return null;
/*     */       } 
/*     */     }
/*     */     
/*     */     try {
/* 113 */       String str = arrayOfString[arrayOfString.length - 1];
/* 114 */       arrayOfString = str.split(":", 2);
/* 115 */       j = Integer.parseInt(arrayOfString[0]);
/* 116 */       if (arrayOfString.length > 1) k = Integer.parseInt(arrayOfString[1]);
/*     */       
/* 118 */       if (Block.func_149729_e(j) == Blocks.field_150350_a) {
/* 119 */         j = 0;
/* 120 */         k = 0;
/*     */       } 
/*     */       
/* 123 */       if (k < 0 || k > 15) k = 0; 
/* 124 */     } catch (Throwable throwable) {
/* 125 */       return null;
/*     */     } 
/*     */     
/* 128 */     FlatLayerInfo flatLayerInfo = new FlatLayerInfo(i, Block.func_149729_e(j), k);
/* 129 */     flatLayerInfo.func_82660_d(p_82646_1_);
/* 130 */     return flatLayerInfo;
/*     */   }
/*     */   
/*     */   private static List func_82652_b(String p_82652_0_) {
/* 134 */     if (p_82652_0_ == null || p_82652_0_.length() < 1) return null;
/*     */     
/* 136 */     ArrayList<FlatLayerInfo> arrayList = new ArrayList();
/* 137 */     String[] arrayOfString = p_82652_0_.split(",");
/* 138 */     int i = 0;
/*     */     
/* 140 */     for (String str : arrayOfString) {
/* 141 */       FlatLayerInfo flatLayerInfo = func_82646_a(str, i);
/* 142 */       if (flatLayerInfo == null) return null; 
/* 143 */       arrayList.add(flatLayerInfo);
/* 144 */       i += flatLayerInfo.func_82657_a();
/*     */     } 
/*     */     
/* 147 */     return arrayList;
/*     */   }
/*     */   
/*     */   public static FlatGeneratorInfo func_82651_a(String p_82651_0_) {
/* 151 */     if (p_82651_0_ == null) return func_82649_e(); 
/* 152 */     String[] arrayOfString = p_82651_0_.split(";", -1);
/* 153 */     byte b1 = (arrayOfString.length == 1) ? 0 : MathHelper.func_82715_a(arrayOfString[0], 0);
/* 154 */     if (!b1 || b1 > 2) return func_82649_e();
/*     */     
/* 156 */     FlatGeneratorInfo flatGeneratorInfo = new FlatGeneratorInfo();
/* 157 */     byte b2 = (arrayOfString.length == 1) ? 0 : 1;
/* 158 */     List list = func_82652_b(arrayOfString[b2++]);
/*     */     
/* 160 */     if (list == null || list.isEmpty()) {
/* 161 */       return func_82649_e();
/*     */     }
/*     */     
/* 164 */     flatGeneratorInfo.func_82650_c().addAll(list);
/* 165 */     flatGeneratorInfo.func_82645_d();
/*     */     
/* 167 */     int i = BiomeGenBase.field_76772_c.field_76756_M;
/* 168 */     if (b1 > 0 && arrayOfString.length > b2) i = MathHelper.func_82715_a(arrayOfString[b2++], i); 
/* 169 */     flatGeneratorInfo.func_82647_a(i);
/*     */     
/* 171 */     if (b1 > 0 && arrayOfString.length > b2) {
/* 172 */       String[] arrayOfString1 = arrayOfString[b2++].toLowerCase().split(",");
/*     */       
/* 174 */       for (String str : arrayOfString1) {
/* 175 */         String[] arrayOfString2 = str.split("\\(", 2);
/* 176 */         HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */         
/* 178 */         if (arrayOfString2[0].length() > 0) {
/* 179 */           flatGeneratorInfo.func_82644_b().put(arrayOfString2[0], hashMap);
/*     */           
/* 181 */           if (arrayOfString2.length > 1 && arrayOfString2[1].endsWith(")") && arrayOfString2[1].length() > 1) {
/* 182 */             String[] arrayOfString3 = arrayOfString2[1].substring(0, arrayOfString2[1].length() - 1).split(" ");
/*     */             
/* 184 */             for (byte b = 0; b < arrayOfString3.length; b++) {
/* 185 */               String[] arrayOfString4 = arrayOfString3[b].split("=", 2);
/* 186 */               if (arrayOfString4.length == 2) hashMap.put(arrayOfString4[0], arrayOfString4[1]); 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } else {
/* 192 */       flatGeneratorInfo.func_82644_b().put("village", new HashMap<Object, Object>());
/*     */     } 
/*     */     
/* 195 */     return flatGeneratorInfo;
/*     */   }
/*     */   
/*     */   public static FlatGeneratorInfo func_82649_e() {
/* 199 */     FlatGeneratorInfo flatGeneratorInfo = new FlatGeneratorInfo();
/*     */     
/* 201 */     flatGeneratorInfo.func_82647_a(BiomeGenBase.field_76772_c.field_76756_M);
/* 202 */     flatGeneratorInfo.func_82650_c().add(new FlatLayerInfo(1, Blocks.field_150357_h));
/* 203 */     flatGeneratorInfo.func_82650_c().add(new FlatLayerInfo(2, Blocks.field_150346_d));
/* 204 */     flatGeneratorInfo.func_82650_c().add(new FlatLayerInfo(1, (Block)Blocks.field_150349_c));
/* 205 */     flatGeneratorInfo.func_82645_d();
/* 206 */     flatGeneratorInfo.func_82644_b().put("village", new HashMap<Object, Object>());
/*     */     
/* 208 */     return flatGeneratorInfo;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\FlatGeneratorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */