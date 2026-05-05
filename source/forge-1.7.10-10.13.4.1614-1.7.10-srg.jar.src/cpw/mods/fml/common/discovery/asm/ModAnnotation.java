/*     */ package cpw.mods.fml.common.discovery.asm;
/*     */ 
/*     */ import com.google.common.base.Objects;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import org.objectweb.asm.Type;
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
/*     */ public class ModAnnotation
/*     */ {
/*     */   ASMModParser.AnnotationType type;
/*     */   Type asmType;
/*     */   String member;
/*     */   
/*     */   public class EnumHolder
/*     */   {
/*     */     private String desc;
/*     */     private String value;
/*     */     
/*     */     public EnumHolder(String desc, String value) {
/*  37 */       this.desc = desc;
/*  38 */       this.value = value;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   Map<String, Object> values = Maps.newHashMap();
/*     */   private ArrayList<Object> arrayList;
/*     */   private String arrayName;
/*     */   
/*     */   public ModAnnotation(ASMModParser.AnnotationType type, Type asmType, String member) {
/*  50 */     this.type = type;
/*  51 */     this.asmType = asmType;
/*  52 */     this.member = member;
/*     */   }
/*     */ 
/*     */   
/*     */   public ModAnnotation(ASMModParser.AnnotationType type, Type asmType, ModAnnotation parent) {
/*  57 */     this.type = type;
/*  58 */     this.asmType = asmType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  68 */     return Objects.toStringHelper("Annotation").add("type", this.type).add("name", this.asmType.getClassName()).add("member", this.member).add("values", this.values).toString();
/*     */   }
/*     */   
/*     */   public ASMModParser.AnnotationType getType() {
/*  72 */     return this.type;
/*     */   }
/*     */   
/*     */   public Type getASMType() {
/*  76 */     return this.asmType;
/*     */   }
/*     */   
/*     */   public String getMember() {
/*  80 */     return this.member;
/*     */   }
/*     */   
/*     */   public Map<String, Object> getValues() {
/*  84 */     return this.values;
/*     */   }
/*     */   
/*     */   public void addArray(String name) {
/*  88 */     this.arrayList = Lists.newArrayList();
/*  89 */     this.arrayName = name;
/*     */   }
/*     */   
/*     */   public void addProperty(String key, Object value) {
/*  93 */     if (this.arrayList != null) {
/*     */       
/*  95 */       this.arrayList.add(value);
/*     */     }
/*     */     else {
/*     */       
/*  99 */       this.values.put(key, value);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addEnumProperty(String key, String enumName, String value) {
/* 105 */     this.values.put(key, new EnumHolder(enumName, value));
/*     */   }
/*     */ 
/*     */   
/*     */   public void endArray() {
/* 110 */     this.values.put(this.arrayName, this.arrayList);
/* 111 */     this.arrayList = null;
/*     */   }
/*     */   
/*     */   public ModAnnotation addChildAnnotation(String name, String desc) {
/* 115 */     ModAnnotation child = new ModAnnotation(ASMModParser.AnnotationType.SUBTYPE, Type.getType(desc), this);
/* 116 */     if (this.arrayList != null)
/*     */     {
/* 118 */       this.arrayList.add(child.getValues());
/*     */     }
/* 120 */     return child;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\discovery\asm\ModAnnotation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */