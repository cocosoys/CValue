/*     */ package net.minecraft.util;
/*     */ 
/*     */ import com.google.gson.JsonDeserializationContext;
/*     */ import com.google.gson.JsonDeserializer;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonPrimitive;
/*     */ import com.google.gson.JsonSerializationContext;
/*     */ import com.google.gson.JsonSerializer;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.lang.reflect.Type;
/*     */ import net.minecraft.event.ClickEvent;
/*     */ import net.minecraft.event.HoverEvent;
/*     */ 
/*     */ public class ChatStyle {
/*     */   private ChatStyle field_150249_a;
/*     */   private EnumChatFormatting field_150247_b;
/*     */   private Boolean field_150248_c;
/*     */   private Boolean field_150245_d;
/*     */   
/*     */   public EnumChatFormatting func_150215_a() {
/*  23 */     return (this.field_150247_b == null) ? func_150224_n().func_150215_a() : this.field_150247_b;
/*     */   }
/*     */   private Boolean field_150246_e; private Boolean field_150243_f; private Boolean field_150244_g; private ClickEvent field_150251_h; private HoverEvent field_150252_i;
/*     */   public boolean func_150223_b() {
/*  27 */     return (this.field_150248_c == null) ? func_150224_n().func_150223_b() : this.field_150248_c.booleanValue();
/*     */   }
/*     */   
/*     */   public boolean func_150242_c() {
/*  31 */     return (this.field_150245_d == null) ? func_150224_n().func_150242_c() : this.field_150245_d.booleanValue();
/*     */   }
/*     */   
/*     */   public boolean func_150236_d() {
/*  35 */     return (this.field_150243_f == null) ? func_150224_n().func_150236_d() : this.field_150243_f.booleanValue();
/*     */   }
/*     */   
/*     */   public boolean func_150234_e() {
/*  39 */     return (this.field_150246_e == null) ? func_150224_n().func_150234_e() : this.field_150246_e.booleanValue();
/*     */   }
/*     */   
/*     */   public boolean func_150233_f() {
/*  43 */     return (this.field_150244_g == null) ? func_150224_n().func_150233_f() : this.field_150244_g.booleanValue();
/*     */   }
/*     */   
/*     */   public boolean func_150229_g() {
/*  47 */     return (this.field_150248_c == null && this.field_150245_d == null && this.field_150243_f == null && this.field_150246_e == null && this.field_150244_g == null && this.field_150247_b == null && this.field_150251_h == null && this.field_150252_i == null);
/*     */   }
/*     */   
/*     */   public ClickEvent func_150235_h() {
/*  51 */     return (this.field_150251_h == null) ? func_150224_n().func_150235_h() : this.field_150251_h;
/*     */   }
/*     */   
/*     */   public HoverEvent func_150210_i() {
/*  55 */     return (this.field_150252_i == null) ? func_150224_n().func_150210_i() : this.field_150252_i;
/*     */   }
/*     */   
/*     */   public ChatStyle func_150238_a(EnumChatFormatting p_150238_1_) {
/*  59 */     this.field_150247_b = p_150238_1_;
/*  60 */     return this;
/*     */   }
/*     */   
/*     */   public ChatStyle func_150227_a(Boolean p_150227_1_) {
/*  64 */     this.field_150248_c = p_150227_1_;
/*  65 */     return this;
/*     */   }
/*     */   
/*     */   public ChatStyle func_150217_b(Boolean p_150217_1_) {
/*  69 */     this.field_150245_d = p_150217_1_;
/*  70 */     return this;
/*     */   }
/*     */   
/*     */   public ChatStyle func_150225_c(Boolean p_150225_1_) {
/*  74 */     this.field_150243_f = p_150225_1_;
/*  75 */     return this;
/*     */   }
/*     */   
/*     */   public ChatStyle func_150228_d(Boolean p_150228_1_) {
/*  79 */     this.field_150246_e = p_150228_1_;
/*  80 */     return this;
/*     */   }
/*     */   
/*     */   public ChatStyle func_150237_e(Boolean p_150237_1_) {
/*  84 */     this.field_150244_g = p_150237_1_;
/*  85 */     return this;
/*     */   }
/*     */   
/*     */   public ChatStyle func_150241_a(ClickEvent p_150241_1_) {
/*  89 */     this.field_150251_h = p_150241_1_;
/*  90 */     return this;
/*     */   }
/*     */   
/*     */   public ChatStyle func_150209_a(HoverEvent p_150209_1_) {
/*  94 */     this.field_150252_i = p_150209_1_;
/*  95 */     return this;
/*     */   }
/*     */   
/*     */   public ChatStyle func_150221_a(ChatStyle p_150221_1_) {
/*  99 */     this.field_150249_a = p_150221_1_;
/* 100 */     return this;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_150218_j() {
/* 104 */     if (func_150229_g()) {
/* 105 */       if (this.field_150249_a != null) {
/* 106 */         return this.field_150249_a.func_150218_j();
/*     */       }
/* 108 */       return "";
/*     */     } 
/*     */ 
/*     */     
/* 112 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 114 */     if (func_150215_a() != null) {
/* 115 */       stringBuilder.append(func_150215_a());
/*     */     }
/*     */     
/* 118 */     if (func_150223_b()) stringBuilder.append(EnumChatFormatting.BOLD); 
/* 119 */     if (func_150242_c()) stringBuilder.append(EnumChatFormatting.ITALIC); 
/* 120 */     if (func_150234_e()) stringBuilder.append(EnumChatFormatting.UNDERLINE); 
/* 121 */     if (func_150233_f()) stringBuilder.append(EnumChatFormatting.OBFUSCATED); 
/* 122 */     if (func_150236_d()) stringBuilder.append(EnumChatFormatting.STRIKETHROUGH);
/*     */     
/* 124 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private ChatStyle func_150224_n() {
/* 128 */     return (this.field_150249_a == null) ? field_150250_j : this.field_150249_a;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 147 */     return "Style{hasParent=" + ((this.field_150249_a != null) ? 1 : 0) + ", color=" + this.field_150247_b + ", bold=" + this.field_150248_c + ", italic=" + this.field_150245_d + ", underlined=" + this.field_150246_e + ", obfuscated=" + this.field_150244_g + ", clickEvent=" + func_150235_h() + ", hoverEvent=" + func_150210_i() + '}';
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
/*     */   
/*     */   public boolean equals(Object p_equals_1_) {
/* 161 */     if (this == p_equals_1_) return true; 
/* 162 */     if (p_equals_1_ instanceof ChatStyle) {
/*     */       
/* 164 */       ChatStyle chatStyle = (ChatStyle)p_equals_1_;
/*     */       
/* 166 */       return (func_150223_b() == chatStyle.func_150223_b() && func_150215_a() == chatStyle.func_150215_a() && func_150242_c() == chatStyle.func_150242_c() && func_150233_f() == chatStyle.func_150233_f() && func_150236_d() == chatStyle.func_150236_d() && func_150234_e() == chatStyle.func_150234_e() && ((func_150235_h() != null) ? func_150235_h().equals(chatStyle.func_150235_h()) : (chatStyle.func_150235_h() == null)) && ((func_150210_i() != null) ? func_150210_i().equals(chatStyle.func_150210_i()) : (chatStyle.func_150210_i() == null)));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 176 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 181 */     int i = this.field_150247_b.hashCode();
/* 182 */     i = 31 * i + this.field_150248_c.hashCode();
/* 183 */     i = 31 * i + this.field_150245_d.hashCode();
/* 184 */     i = 31 * i + this.field_150246_e.hashCode();
/* 185 */     i = 31 * i + this.field_150243_f.hashCode();
/* 186 */     i = 31 * i + this.field_150244_g.hashCode();
/* 187 */     i = 31 * i + this.field_150251_h.hashCode();
/* 188 */     i = 31 * i + this.field_150252_i.hashCode();
/* 189 */     return i;
/*     */   }
/*     */   
/* 192 */   private static final ChatStyle field_150250_j = new ChatStyle() { private static final String __OBFID = "CL_00001267";
/* 193 */       public EnumChatFormatting func_150215_a() { return null; }
/* 194 */       public boolean func_150223_b() { return false; }
/* 195 */       public boolean func_150242_c() { return false; }
/* 196 */       public boolean func_150236_d() { return false; }
/* 197 */       public boolean func_150234_e() { return false; }
/* 198 */       public boolean func_150233_f() { return false; }
/* 199 */       public ClickEvent func_150235_h() { return null; }
/* 200 */       public HoverEvent func_150210_i() { return null; }
/* 201 */       public ChatStyle func_150238_a(EnumChatFormatting p_150238_1_) { throw new UnsupportedOperationException(); }
/* 202 */       public ChatStyle func_150227_a(Boolean p_150227_1_) { throw new UnsupportedOperationException(); }
/* 203 */       public ChatStyle func_150217_b(Boolean p_150217_1_) { throw new UnsupportedOperationException(); }
/* 204 */       public ChatStyle func_150225_c(Boolean p_150225_1_) { throw new UnsupportedOperationException(); }
/* 205 */       public ChatStyle func_150228_d(Boolean p_150228_1_) { throw new UnsupportedOperationException(); }
/* 206 */       public ChatStyle func_150237_e(Boolean p_150237_1_) { throw new UnsupportedOperationException(); }
/* 207 */       public ChatStyle func_150241_a(ClickEvent p_150241_1_) { throw new UnsupportedOperationException(); }
/* 208 */       public ChatStyle func_150209_a(HoverEvent p_150209_1_) { throw new UnsupportedOperationException(); }
/* 209 */       public ChatStyle func_150221_a(ChatStyle p_150221_1_) { throw new UnsupportedOperationException(); }
/* 210 */       public String toString() { return "Style.ROOT"; }
/* 211 */       public ChatStyle func_150232_l() { return this; }
/* 212 */       public ChatStyle func_150206_m() { return this; } @SideOnly(Side.CLIENT)
/*     */       public String func_150218_j() {
/* 214 */         return "";
/*     */       } }
/*     */   ; private static final String __OBFID = "CL_00001266";
/*     */   public ChatStyle func_150232_l() {
/* 218 */     ChatStyle chatStyle = new ChatStyle();
/* 219 */     chatStyle.field_150248_c = this.field_150248_c;
/* 220 */     chatStyle.field_150245_d = this.field_150245_d;
/* 221 */     chatStyle.field_150243_f = this.field_150243_f;
/* 222 */     chatStyle.field_150246_e = this.field_150246_e;
/* 223 */     chatStyle.field_150244_g = this.field_150244_g;
/* 224 */     chatStyle.field_150247_b = this.field_150247_b;
/* 225 */     chatStyle.field_150251_h = this.field_150251_h;
/* 226 */     chatStyle.field_150252_i = this.field_150252_i;
/* 227 */     chatStyle.field_150249_a = this.field_150249_a;
/* 228 */     return chatStyle;
/*     */   }
/*     */   
/*     */   public ChatStyle func_150206_m() {
/* 232 */     ChatStyle chatStyle = new ChatStyle();
/*     */     
/* 234 */     chatStyle.func_150227_a(Boolean.valueOf(func_150223_b()));
/* 235 */     chatStyle.func_150217_b(Boolean.valueOf(func_150242_c()));
/* 236 */     chatStyle.func_150225_c(Boolean.valueOf(func_150236_d()));
/* 237 */     chatStyle.func_150228_d(Boolean.valueOf(func_150234_e()));
/* 238 */     chatStyle.func_150237_e(Boolean.valueOf(func_150233_f()));
/* 239 */     chatStyle.func_150238_a(func_150215_a());
/* 240 */     chatStyle.func_150241_a(func_150235_h());
/* 241 */     chatStyle.func_150209_a(func_150210_i());
/*     */     
/* 243 */     return chatStyle;
/*     */   }
/*     */   
/*     */   public static class Serializer implements JsonDeserializer, JsonSerializer {
/*     */     private static final String __OBFID = "CL_00001268";
/*     */     
/*     */     public ChatStyle deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) {
/* 250 */       if (p_deserialize_1_.isJsonObject()) {
/* 251 */         ChatStyle chatStyle = new ChatStyle();
/* 252 */         JsonObject jsonObject = p_deserialize_1_.getAsJsonObject();
/* 253 */         if (jsonObject == null) {
/* 254 */           return null;
/*     */         }
/*     */         
/* 257 */         if (jsonObject.has("bold")) chatStyle.field_150248_c = Boolean.valueOf(jsonObject.get("bold").getAsBoolean()); 
/* 258 */         if (jsonObject.has("italic")) chatStyle.field_150245_d = Boolean.valueOf(jsonObject.get("italic").getAsBoolean()); 
/* 259 */         if (jsonObject.has("underlined")) chatStyle.field_150246_e = Boolean.valueOf(jsonObject.get("underlined").getAsBoolean()); 
/* 260 */         if (jsonObject.has("strikethrough")) chatStyle.field_150243_f = Boolean.valueOf(jsonObject.get("strikethrough").getAsBoolean()); 
/* 261 */         if (jsonObject.has("obfuscated")) chatStyle.field_150244_g = Boolean.valueOf(jsonObject.get("obfuscated").getAsBoolean()); 
/* 262 */         if (jsonObject.has("color")) chatStyle.field_150247_b = (EnumChatFormatting)p_deserialize_3_.deserialize(jsonObject.get("color"), EnumChatFormatting.class);
/*     */         
/* 264 */         if (jsonObject.has("clickEvent")) {
/* 265 */           JsonObject jsonObject1 = jsonObject.getAsJsonObject("clickEvent");
/* 266 */           if (jsonObject1 != null) {
/* 267 */             JsonPrimitive jsonPrimitive1 = jsonObject1.getAsJsonPrimitive("action");
/* 268 */             ClickEvent.Action action = (jsonPrimitive1 == null) ? null : ClickEvent.Action.func_150672_a(jsonPrimitive1.getAsString());
/*     */             
/* 270 */             JsonPrimitive jsonPrimitive2 = jsonObject1.getAsJsonPrimitive("value");
/* 271 */             String str = (jsonPrimitive2 == null) ? null : jsonPrimitive2.getAsString();
/*     */             
/* 273 */             if (action != null && str != null && action.func_150674_a()) {
/* 274 */               chatStyle.field_150251_h = new ClickEvent(action, str);
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 279 */         if (jsonObject.has("hoverEvent")) {
/* 280 */           JsonObject jsonObject1 = jsonObject.getAsJsonObject("hoverEvent");
/* 281 */           if (jsonObject1 != null) {
/* 282 */             JsonPrimitive jsonPrimitive = jsonObject1.getAsJsonPrimitive("action");
/* 283 */             HoverEvent.Action action = (jsonPrimitive == null) ? null : HoverEvent.Action.func_150684_a(jsonPrimitive.getAsString());
/*     */             
/* 285 */             IChatComponent iChatComponent = (IChatComponent)p_deserialize_3_.deserialize(jsonObject1.get("value"), IChatComponent.class);
/*     */             
/* 287 */             if (action != null && iChatComponent != null && action.func_150686_a()) {
/* 288 */               chatStyle.field_150252_i = new HoverEvent(action, iChatComponent);
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 293 */         return chatStyle;
/*     */       } 
/*     */       
/* 296 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public JsonElement serialize(ChatStyle p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
/* 302 */       if (p_serialize_1_.func_150229_g()) return null; 
/* 303 */       JsonObject jsonObject = new JsonObject();
/*     */       
/* 305 */       if (p_serialize_1_.field_150248_c != null) jsonObject.addProperty("bold", p_serialize_1_.field_150248_c); 
/* 306 */       if (p_serialize_1_.field_150245_d != null) jsonObject.addProperty("italic", p_serialize_1_.field_150245_d); 
/* 307 */       if (p_serialize_1_.field_150246_e != null) jsonObject.addProperty("underlined", p_serialize_1_.field_150246_e); 
/* 308 */       if (p_serialize_1_.field_150243_f != null) jsonObject.addProperty("strikethrough", p_serialize_1_.field_150243_f); 
/* 309 */       if (p_serialize_1_.field_150244_g != null) jsonObject.addProperty("obfuscated", p_serialize_1_.field_150244_g); 
/* 310 */       if (p_serialize_1_.field_150247_b != null) jsonObject.add("color", p_serialize_3_.serialize(p_serialize_1_.field_150247_b));
/*     */       
/* 312 */       if (p_serialize_1_.field_150251_h != null) {
/* 313 */         JsonObject jsonObject1 = new JsonObject();
/* 314 */         jsonObject1.addProperty("action", p_serialize_1_.field_150251_h.func_150669_a().func_150673_b());
/* 315 */         jsonObject1.addProperty("value", p_serialize_1_.field_150251_h.func_150668_b());
/* 316 */         jsonObject.add("clickEvent", (JsonElement)jsonObject1);
/*     */       } 
/*     */       
/* 319 */       if (p_serialize_1_.field_150252_i != null) {
/* 320 */         JsonObject jsonObject1 = new JsonObject();
/* 321 */         jsonObject1.addProperty("action", p_serialize_1_.field_150252_i.func_150701_a().func_150685_b());
/* 322 */         jsonObject1.add("value", p_serialize_3_.serialize(p_serialize_1_.field_150252_i.func_150702_b()));
/* 323 */         jsonObject.add("hoverEvent", (JsonElement)jsonObject1);
/*     */       } 
/*     */       
/* 326 */       return (JsonElement)jsonObject;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\ChatStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */