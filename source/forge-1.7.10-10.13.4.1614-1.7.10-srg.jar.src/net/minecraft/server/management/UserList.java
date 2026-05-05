/*     */ package net.minecraft.server.management;
/*     */ import com.google.common.io.Files;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import com.google.gson.JsonDeserializationContext;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonSerializationContext;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ 
/*     */ public class UserList {
/*  20 */   protected static final Logger field_152693_a = LogManager.getLogger();
/*     */   protected final Gson field_152694_b;
/*     */   private final File field_152695_c;
/*  23 */   private final Map field_152696_d = Maps.newHashMap();
/*     */   private boolean field_152697_e = true;
/*     */   
/*     */   public UserList(File p_i1144_1_) {
/*  27 */     this.field_152695_c = p_i1144_1_;
/*  28 */     GsonBuilder gsonBuilder = (new GsonBuilder()).setPrettyPrinting();
/*  29 */     gsonBuilder.registerTypeHierarchyAdapter(UserListEntry.class, new Serializer());
/*  30 */     this.field_152694_b = gsonBuilder.create();
/*     */   }
/*     */   
/*     */   public boolean func_152689_b() {
/*  34 */     return this.field_152697_e;
/*     */   }
/*     */   
/*     */   public void func_152686_a(boolean p_152686_1_) {
/*  38 */     this.field_152697_e = p_152686_1_;
/*     */   }
/*     */   @SideOnly(Side.SERVER)
/*     */   public File func_152691_c() {
/*  42 */     return this.field_152695_c;
/*     */   }
/*     */   
/*     */   public void func_152687_a(UserListEntry p_152687_1_) {
/*  46 */     this.field_152696_d.put(func_152681_a(p_152687_1_.func_152640_f()), p_152687_1_);
/*     */     try {
/*  48 */       func_152678_f();
/*  49 */     } catch (IOException iOException) {
/*  50 */       field_152693_a.warn("Could not save the list after adding a user.", iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public UserListEntry func_152683_b(Object p_152683_1_) {
/*  55 */     func_152680_h();
/*  56 */     return (UserListEntry)this.field_152696_d.get(func_152681_a(p_152683_1_));
/*     */   }
/*     */   
/*     */   public void func_152684_c(Object p_152684_1_) {
/*  60 */     this.field_152696_d.remove(func_152681_a(p_152684_1_));
/*     */     try {
/*  62 */       func_152678_f();
/*  63 */     } catch (IOException iOException) {
/*  64 */       field_152693_a.warn("Could not save the list after removing a user.", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] func_152685_a() {
/*  73 */     return (String[])this.field_152696_d.keySet().toArray((Object[])new String[this.field_152696_d.size()]);
/*     */   }
/*     */   @SideOnly(Side.SERVER)
/*     */   public boolean func_152690_d() {
/*  77 */     return (this.field_152696_d.size() < 1);
/*     */   }
/*     */   
/*     */   protected String func_152681_a(Object p_152681_1_) {
/*  81 */     return p_152681_1_.toString();
/*     */   }
/*     */   
/*     */   protected boolean func_152692_d(Object p_152692_1_) {
/*  85 */     return this.field_152696_d.containsKey(func_152681_a(p_152692_1_));
/*     */   }
/*     */   
/*     */   private void func_152680_h() {
/*  89 */     ArrayList<Object> arrayList = Lists.newArrayList();
/*  90 */     for (UserListEntry userListEntry : this.field_152696_d.values()) {
/*  91 */       if (userListEntry.func_73682_e()) {
/*  92 */         arrayList.add(userListEntry.func_152640_f());
/*     */       }
/*     */     } 
/*  95 */     for (Object object : arrayList) {
/*  96 */       this.field_152696_d.remove(object);
/*     */     }
/*     */   }
/*     */   
/*     */   protected UserListEntry func_152682_a(JsonObject p_152682_1_) {
/* 101 */     return new UserListEntry(null, p_152682_1_);
/*     */   }
/*     */   
/*     */   protected Map func_152688_e() {
/* 105 */     return this.field_152696_d;
/*     */   }
/*     */   
/*     */   public void func_152678_f() throws IOException {
/* 109 */     Collection collection = this.field_152696_d.values();
/* 110 */     String str = this.field_152694_b.toJson(collection);
/* 111 */     BufferedWriter bufferedWriter = null;
/*     */     try {
/* 113 */       bufferedWriter = Files.newWriter(this.field_152695_c, Charsets.UTF_8);
/* 114 */       bufferedWriter.write(str);
/*     */     } finally {
/* 116 */       IOUtils.closeQuietly(bufferedWriter);
/*     */     } 
/*     */   }
/*     */   @SideOnly(Side.SERVER)
/*     */   public void func_152679_g() throws IOException {
/* 121 */     Collection collection = null;
/* 122 */     BufferedReader bufferedReader = null;
/*     */     try {
/* 124 */       bufferedReader = Files.newReader(this.field_152695_c, Charsets.UTF_8);
/* 125 */       collection = (Collection)this.field_152694_b.fromJson(bufferedReader, field_152698_f);
/*     */     } finally {
/* 127 */       IOUtils.closeQuietly(bufferedReader);
/*     */     } 
/* 129 */     if (collection != null) {
/* 130 */       this.field_152696_d.clear();
/* 131 */       for (UserListEntry userListEntry : collection) {
/* 132 */         if (userListEntry.func_152640_f() != null)
/* 133 */           this.field_152696_d.put(func_152681_a(userListEntry.func_152640_f()), userListEntry); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   class Serializer implements JsonDeserializer, JsonSerializer { private static final String __OBFID = "CL_00001874";
/*     */     
/*     */     private Serializer(UserList p_i1140_1_) {}
/*     */     
/*     */     public JsonElement func_152751_a(UserListEntry p_152751_1_, Type p_152751_2_, JsonSerializationContext p_152751_3_) {
/* 142 */       JsonObject jsonObject = new JsonObject();
/* 143 */       p_152751_1_.func_152641_a(jsonObject);
/* 144 */       return (JsonElement)jsonObject;
/*     */     }
/*     */ 
/*     */     
/*     */     public UserListEntry func_152750_a(JsonElement p_152750_1_, Type p_152750_2_, JsonDeserializationContext p_152750_3_) {
/* 149 */       if (p_152750_1_.isJsonObject()) {
/* 150 */         JsonObject jsonObject = p_152750_1_.getAsJsonObject();
/* 151 */         return this.field_152752_a.func_152682_a(jsonObject);
/*     */       } 
/*     */       
/* 154 */       return null;
/*     */     } }
/*     */ 
/*     */   
/* 158 */   private static final ParameterizedType field_152698_f = new ParameterizedType() { private static final String __OBFID = "CL_00001875";
/*     */       
/*     */       public Type[] getActualTypeArguments() {
/* 161 */         return new Type[] { UserListEntry.class };
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Type getRawType() {
/* 168 */         return List.class;
/*     */       }
/*     */ 
/*     */       
/*     */       public Type getOwnerType() {
/* 173 */         return null;
/*     */       } }
/*     */   ;
/*     */   private static final String __OBFID = "CL_00001876";
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\management\UserList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */