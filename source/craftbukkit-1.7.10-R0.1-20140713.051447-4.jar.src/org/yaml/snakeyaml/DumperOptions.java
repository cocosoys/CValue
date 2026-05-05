/*     */ package org.yaml.snakeyaml;
/*     */ 
/*     */ import java.util.Map;
/*     */ import org.yaml.snakeyaml.emitter.ScalarAnalysis;
/*     */ import org.yaml.snakeyaml.error.YAMLException;
/*     */ import org.yaml.snakeyaml.nodes.Tag;
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
/*     */ public class DumperOptions
/*     */ {
/*     */   public enum ScalarStyle
/*     */   {
/*  37 */     DOUBLE_QUOTED((String)new Character('"')), SINGLE_QUOTED((String)new Character('\'')), LITERAL((String)new Character('|')),
/*  38 */     FOLDED((String)new Character('>')), PLAIN(null);
/*     */     private Character styleChar;
/*     */     
/*     */     ScalarStyle(Character style) {
/*  42 */       this.styleChar = style;
/*     */     }
/*     */     
/*     */     public Character getChar() {
/*  46 */       return this.styleChar;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  51 */       return "Scalar style: '" + this.styleChar + "'";
/*     */     }
/*     */     
/*     */     public static ScalarStyle createStyle(Character style) {
/*  55 */       if (style == null) {
/*  56 */         return PLAIN;
/*     */       }
/*  58 */       switch (style.charValue()) {
/*     */         case '"':
/*  60 */           return DOUBLE_QUOTED;
/*     */         case '\'':
/*  62 */           return SINGLE_QUOTED;
/*     */         case '|':
/*  64 */           return LITERAL;
/*     */         case '>':
/*  66 */           return FOLDED;
/*     */       } 
/*  68 */       throw new YAMLException("Unknown scalar style character: " + style);
/*     */     }
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
/*     */   public enum FlowStyle
/*     */   {
/*  82 */     FLOW((String)Boolean.TRUE), BLOCK((String)Boolean.FALSE), AUTO(null);
/*     */     
/*     */     private Boolean styleBoolean;
/*     */     
/*     */     FlowStyle(Boolean flowStyle) {
/*  87 */       this.styleBoolean = flowStyle;
/*     */     }
/*     */     
/*     */     public Boolean getStyleBoolean() {
/*  91 */       return this.styleBoolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  96 */       return "Flow style: '" + this.styleBoolean + "'";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum LineBreak
/*     */   {
/* 104 */     WIN("\r\n"), MAC("\r"), UNIX("\n");
/*     */     
/*     */     private String lineBreak;
/*     */     
/*     */     LineBreak(String lineBreak) {
/* 109 */       this.lineBreak = lineBreak;
/*     */     }
/*     */     
/*     */     public String getString() {
/* 113 */       return this.lineBreak;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 118 */       return "Line break: " + name();
/*     */     }
/*     */     
/*     */     public static LineBreak getPlatformLineBreak() {
/* 122 */       String platformLineBreak = System.getProperty("line.separator");
/* 123 */       for (LineBreak lb : values()) {
/* 124 */         if (lb.lineBreak.equals(platformLineBreak)) {
/* 125 */           return lb;
/*     */         }
/*     */       } 
/* 128 */       return UNIX;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Version
/*     */   {
/* 136 */     V1_0((String)new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), V1_1((String)new Integer[] { Integer.valueOf(1), Integer.valueOf(1) });
/*     */     
/*     */     private Integer[] version;
/*     */     
/*     */     Version(Integer[] version) {
/* 141 */       this.version = version;
/*     */     }
/*     */     
/*     */     public Integer[] getArray() {
/* 145 */       return this.version;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 150 */       return "Version: " + this.version[0] + "." + this.version[1];
/*     */     }
/*     */   }
/*     */   
/* 154 */   private ScalarStyle defaultStyle = ScalarStyle.PLAIN;
/* 155 */   private FlowStyle defaultFlowStyle = FlowStyle.AUTO;
/*     */   private boolean canonical = false;
/*     */   private boolean allowUnicode = true;
/*     */   private boolean allowReadOnlyProperties = false;
/* 159 */   private int indent = 2;
/* 160 */   private int bestWidth = 80;
/* 161 */   private LineBreak lineBreak = LineBreak.UNIX;
/*     */ 
/*     */   
/*     */   private boolean explicitStart = false;
/*     */   
/*     */   private boolean explicitEnd = false;
/*     */   
/* 168 */   private Tag explicitRoot = null;
/* 169 */   private Version version = null;
/* 170 */   private Map<String, String> tags = null;
/* 171 */   private Boolean prettyFlow = Boolean.valueOf(false);
/*     */   
/*     */   public boolean isAllowUnicode() {
/* 174 */     return this.allowUnicode;
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
/*     */   public void setAllowUnicode(boolean allowUnicode) {
/* 186 */     this.allowUnicode = allowUnicode;
/*     */   }
/*     */   
/*     */   public ScalarStyle getDefaultScalarStyle() {
/* 190 */     return this.defaultStyle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultScalarStyle(ScalarStyle defaultStyle) {
/* 201 */     if (defaultStyle == null) {
/* 202 */       throw new NullPointerException("Use ScalarStyle enum.");
/*     */     }
/* 204 */     this.defaultStyle = defaultStyle;
/*     */   }
/*     */   
/*     */   public void setIndent(int indent) {
/* 208 */     if (indent < 1) {
/* 209 */       throw new YAMLException("Indent must be at least 1");
/*     */     }
/* 211 */     if (indent > 10) {
/* 212 */       throw new YAMLException("Indent must be at most 10");
/*     */     }
/* 214 */     this.indent = indent;
/*     */   }
/*     */   
/*     */   public int getIndent() {
/* 218 */     return this.indent;
/*     */   }
/*     */   
/*     */   public void setVersion(Version version) {
/* 222 */     this.version = version;
/*     */   }
/*     */   
/*     */   public Version getVersion() {
/* 226 */     return this.version;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCanonical(boolean canonical) {
/* 237 */     this.canonical = canonical;
/*     */   }
/*     */   
/*     */   public boolean isCanonical() {
/* 241 */     return this.canonical;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrettyFlow(boolean prettyFlow) {
/* 252 */     this.prettyFlow = Boolean.valueOf(prettyFlow);
/*     */   }
/*     */   
/*     */   public boolean isPrettyFlow() {
/* 256 */     return this.prettyFlow.booleanValue();
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
/*     */   public void setWidth(int bestWidth) {
/* 268 */     this.bestWidth = bestWidth;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/* 272 */     return this.bestWidth;
/*     */   }
/*     */   
/*     */   public LineBreak getLineBreak() {
/* 276 */     return this.lineBreak;
/*     */   }
/*     */   
/*     */   public void setDefaultFlowStyle(FlowStyle defaultFlowStyle) {
/* 280 */     if (defaultFlowStyle == null) {
/* 281 */       throw new NullPointerException("Use FlowStyle enum.");
/*     */     }
/* 283 */     this.defaultFlowStyle = defaultFlowStyle;
/*     */   }
/*     */   
/*     */   public FlowStyle getDefaultFlowStyle() {
/* 287 */     return this.defaultFlowStyle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Tag getExplicitRoot() {
/* 294 */     return this.explicitRoot;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExplicitRoot(String expRoot) {
/* 304 */     setExplicitRoot(new Tag(expRoot));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExplicitRoot(Tag expRoot) {
/* 314 */     if (expRoot == null) {
/* 315 */       throw new NullPointerException("Root tag must be specified.");
/*     */     }
/* 317 */     this.explicitRoot = expRoot;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineBreak(LineBreak lineBreak) {
/* 326 */     if (lineBreak == null) {
/* 327 */       throw new NullPointerException("Specify line break.");
/*     */     }
/* 329 */     this.lineBreak = lineBreak;
/*     */   }
/*     */   
/*     */   public boolean isExplicitStart() {
/* 333 */     return this.explicitStart;
/*     */   }
/*     */   
/*     */   public void setExplicitStart(boolean explicitStart) {
/* 337 */     this.explicitStart = explicitStart;
/*     */   }
/*     */   
/*     */   public boolean isExplicitEnd() {
/* 341 */     return this.explicitEnd;
/*     */   }
/*     */   
/*     */   public void setExplicitEnd(boolean explicitEnd) {
/* 345 */     this.explicitEnd = explicitEnd;
/*     */   }
/*     */   
/*     */   public Map<String, String> getTags() {
/* 349 */     return this.tags;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTags(Map<String, String> tags) {
/* 354 */     this.tags = tags;
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
/*     */   public ScalarStyle calculateScalarStyle(ScalarAnalysis analysis, ScalarStyle style) {
/* 367 */     return style;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAllowReadOnlyProperties() {
/* 377 */     return this.allowReadOnlyProperties;
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
/*     */   public void setAllowReadOnlyProperties(boolean allowReadOnlyProperties) {
/* 389 */     this.allowReadOnlyProperties = allowReadOnlyProperties;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\DumperOptions.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */