/*     */ package net.minecraft.stats;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParseException;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.network.play.server.S37PacketStatistics;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.IJsonSerializable;
/*     */ import net.minecraft.util.TupleIntJsonSerializable;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ 
/*     */ public class StatisticsFile extends StatFileWriter {
/*  23 */   private static final Logger field_150889_b = LogManager.getLogger();
/*     */   
/*     */   private final MinecraftServer field_150890_c;
/*     */   private final File field_150887_d;
/*  27 */   private final Set field_150888_e = Sets.newHashSet();
/*  28 */   private int field_150885_f = -300; private boolean field_150886_g = false;
/*     */   private static final String __OBFID = "CL_00001471";
/*     */   
/*     */   public StatisticsFile(MinecraftServer p_i45306_1_, File p_i45306_2_) {
/*  32 */     this.field_150890_c = p_i45306_1_;
/*  33 */     this.field_150887_d = p_i45306_2_;
/*     */   }
/*     */   
/*     */   public void func_150882_a() {
/*  37 */     if (this.field_150887_d.isFile()) {
/*     */       try {
/*  39 */         this.field_150875_a.clear();
/*  40 */         this.field_150875_a.putAll(func_150881_a(FileUtils.readFileToString(this.field_150887_d)));
/*  41 */       } catch (IOException iOException) {
/*  42 */         field_150889_b.error("Couldn't read statistics file " + this.field_150887_d, iOException);
/*  43 */       } catch (JsonParseException jsonParseException) {
/*  44 */         field_150889_b.error("Couldn't parse statistics file " + this.field_150887_d, (Throwable)jsonParseException);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_150883_b() {
/*     */     try {
/*  51 */       FileUtils.writeStringToFile(this.field_150887_d, func_150880_a(this.field_150875_a));
/*  52 */     } catch (IOException iOException) {
/*  53 */       field_150889_b.error("Couldn't save stats", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_150873_a(EntityPlayer p_150873_1_, StatBase p_150873_2_, int p_150873_3_) {
/*  59 */     boolean bool = p_150873_2_.func_75967_d() ? func_77444_a(p_150873_2_) : false;
/*  60 */     super.func_150873_a(p_150873_1_, p_150873_2_, p_150873_3_);
/*  61 */     this.field_150888_e.add(p_150873_2_);
/*     */     
/*  63 */     if (p_150873_2_.func_75967_d() && !bool && p_150873_3_ > 0) {
/*  64 */       this.field_150886_g = true;
/*  65 */       if (this.field_150890_c.func_147136_ar()) {
/*  66 */         this.field_150890_c.func_71203_ab().func_148539_a((IChatComponent)new ChatComponentTranslation("chat.type.achievement", new Object[] { p_150873_1_.func_145748_c_(), p_150873_2_.func_150955_j() }));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public Set func_150878_c() {
/*  72 */     HashSet hashSet = Sets.newHashSet(this.field_150888_e);
/*  73 */     this.field_150888_e.clear();
/*  74 */     this.field_150886_g = false;
/*  75 */     return hashSet;
/*     */   }
/*     */   
/*     */   public Map func_150881_a(String p_150881_1_) {
/*  79 */     JsonElement jsonElement = (new JsonParser()).parse(p_150881_1_);
/*  80 */     if (!jsonElement.isJsonObject()) return Maps.newHashMap(); 
/*  81 */     JsonObject jsonObject = jsonElement.getAsJsonObject();
/*  82 */     HashMap<StatBase, TupleIntJsonSerializable> hashMap = Maps.newHashMap();
/*     */     
/*  84 */     for (Map.Entry entry : jsonObject.entrySet()) {
/*  85 */       StatBase statBase = StatList.func_151177_a((String)entry.getKey());
/*     */       
/*  87 */       if (statBase != null) {
/*  88 */         TupleIntJsonSerializable tupleIntJsonSerializable = new TupleIntJsonSerializable();
/*     */         
/*  90 */         if (((JsonElement)entry.getValue()).isJsonPrimitive() && ((JsonElement)entry.getValue()).getAsJsonPrimitive().isNumber()) {
/*  91 */           tupleIntJsonSerializable.func_151188_a(((JsonElement)entry.getValue()).getAsInt());
/*  92 */         } else if (((JsonElement)entry.getValue()).isJsonObject()) {
/*  93 */           JsonObject jsonObject1 = ((JsonElement)entry.getValue()).getAsJsonObject();
/*     */           
/*  95 */           if (jsonObject1.has("value") && jsonObject1.get("value").isJsonPrimitive() && jsonObject1.get("value").getAsJsonPrimitive().isNumber()) {
/*  96 */             tupleIntJsonSerializable.func_151188_a(jsonObject1.getAsJsonPrimitive("value").getAsInt());
/*     */           }
/*     */           
/*  99 */           if (jsonObject1.has("progress") && statBase.func_150954_l() != null) {
/*     */             try {
/* 101 */               Constructor<IJsonSerializable> constructor = statBase.func_150954_l().getConstructor(new Class[0]);
/* 102 */               IJsonSerializable iJsonSerializable = constructor.newInstance(new Object[0]);
/* 103 */               iJsonSerializable.func_152753_a(jsonObject1.get("progress"));
/* 104 */               tupleIntJsonSerializable.func_151190_a(iJsonSerializable);
/* 105 */             } catch (Throwable throwable) {
/* 106 */               field_150889_b.warn("Invalid statistic progress in " + this.field_150887_d, throwable);
/*     */             } 
/*     */           }
/*     */         } 
/*     */         
/* 111 */         hashMap.put(statBase, tupleIntJsonSerializable); continue;
/*     */       } 
/* 113 */       field_150889_b.warn("Invalid statistic in " + this.field_150887_d + ": Don't know what " + (String)entry.getKey() + " is");
/*     */     } 
/*     */ 
/*     */     
/* 117 */     return hashMap;
/*     */   }
/*     */   
/*     */   public static String func_150880_a(Map p_150880_0_) {
/* 121 */     JsonObject jsonObject = new JsonObject();
/*     */     
/* 123 */     for (Map.Entry entry : p_150880_0_.entrySet()) {
/* 124 */       if (((TupleIntJsonSerializable)entry.getValue()).func_151187_b() != null) {
/* 125 */         JsonObject jsonObject1 = new JsonObject();
/*     */         
/* 127 */         jsonObject1.addProperty("value", Integer.valueOf(((TupleIntJsonSerializable)entry.getValue()).func_151189_a()));
/*     */         
/*     */         try {
/* 130 */           jsonObject1.add("progress", ((TupleIntJsonSerializable)entry.getValue()).func_151187_b().func_151003_a());
/* 131 */         } catch (Throwable throwable) {
/* 132 */           field_150889_b.warn("Couldn't save statistic " + ((StatBase)entry.getKey()).func_150951_e() + ": error serializing progress", throwable);
/*     */         } 
/*     */         
/* 135 */         jsonObject.add(((StatBase)entry.getKey()).field_75975_e, (JsonElement)jsonObject1); continue;
/*     */       } 
/* 137 */       jsonObject.addProperty(((StatBase)entry.getKey()).field_75975_e, Integer.valueOf(((TupleIntJsonSerializable)entry.getValue()).func_151189_a()));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 142 */     return jsonObject.toString();
/*     */   }
/*     */   
/*     */   public void func_150877_d() {
/* 146 */     for (StatBase statBase : this.field_150875_a.keySet()) {
/* 147 */       this.field_150888_e.add(statBase);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_150876_a(EntityPlayerMP p_150876_1_) {
/* 152 */     int i = this.field_150890_c.func_71259_af();
/* 153 */     HashMap<StatBase, Integer> hashMap = Maps.newHashMap();
/*     */     
/* 155 */     if (this.field_150886_g || i - this.field_150885_f > 300) {
/* 156 */       this.field_150885_f = i;
/*     */       
/* 158 */       for (StatBase statBase : func_150878_c()) {
/* 159 */         hashMap.put(statBase, Integer.valueOf(func_77444_a(statBase)));
/*     */       }
/*     */     } 
/*     */     
/* 163 */     p_150876_1_.field_71135_a.func_147359_a((Packet)new S37PacketStatistics(hashMap));
/*     */   }
/*     */   
/*     */   public void func_150884_b(EntityPlayerMP p_150884_1_) {
/* 167 */     HashMap<Achievement, Integer> hashMap = Maps.newHashMap();
/*     */     
/* 169 */     for (Achievement achievement : AchievementList.field_76007_e) {
/* 170 */       if (func_77443_a(achievement)) {
/* 171 */         hashMap.put(achievement, Integer.valueOf(func_77444_a(achievement)));
/* 172 */         this.field_150888_e.remove(achievement);
/*     */       } 
/*     */     } 
/*     */     
/* 176 */     p_150884_1_.field_71135_a.func_147359_a((Packet)new S37PacketStatistics(hashMap));
/*     */   }
/*     */   
/*     */   public boolean func_150879_e() {
/* 180 */     return this.field_150886_g;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\stats\StatisticsFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */