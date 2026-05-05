/*     */ package org.yaml.snakeyaml.resolver;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Pattern;
/*     */ import org.yaml.snakeyaml.nodes.NodeId;
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
/*     */ public class Resolver
/*     */ {
/*  33 */   public static final Pattern BOOL = Pattern.compile("^(?:yes|Yes|YES|no|No|NO|true|True|TRUE|false|False|FALSE|on|On|ON|off|Off|OFF)$");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   public static final Pattern FLOAT = Pattern.compile("^([-+]?(\\.[0-9]+|[0-9_]+(\\.[0-9_]*)?)([eE][-+]?[0-9]+)?|[-+]?[0-9][0-9_]*(?::[0-5]?[0-9])+\\.[0-9_]*|[-+]?\\.(?:inf|Inf|INF)|\\.(?:nan|NaN|NAN))$");
/*     */   
/*  42 */   public static final Pattern INT = Pattern.compile("^(?:[-+]?0b[0-1_]+|[-+]?0[0-7_]+|[-+]?(?:0|[1-9][0-9_]*)|[-+]?0x[0-9a-fA-F_]+|[-+]?[1-9][0-9_]*(?::[0-5]?[0-9])+)$");
/*     */   
/*  44 */   public static final Pattern MERGE = Pattern.compile("^(?:<<)$");
/*  45 */   public static final Pattern NULL = Pattern.compile("^(?:~|null|Null|NULL| )$");
/*  46 */   public static final Pattern EMPTY = Pattern.compile("^$");
/*  47 */   public static final Pattern TIMESTAMP = Pattern.compile("^(?:[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]|[0-9][0-9][0-9][0-9]-[0-9][0-9]?-[0-9][0-9]?(?:[Tt]|[ \t]+)[0-9][0-9]?:[0-9][0-9]:[0-9][0-9](?:\\.[0-9]*)?(?:[ \t]*(?:Z|[-+][0-9][0-9]?(?::[0-9][0-9])?))?)$");
/*     */   
/*  49 */   public static final Pattern VALUE = Pattern.compile("^(?:=)$");
/*  50 */   public static final Pattern YAML = Pattern.compile("^(?:!|&|\\*)$");
/*     */   
/*  52 */   protected Map<Character, List<ResolverTuple>> yamlImplicitResolvers = new HashMap<Character, List<ResolverTuple>>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Resolver(boolean respectDefaultImplicitScalars) {
/*  62 */     if (respectDefaultImplicitScalars) {
/*  63 */       addImplicitResolvers();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addImplicitResolvers() {
/*  68 */     addImplicitResolver(Tag.BOOL, BOOL, "yYnNtTfFoO");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  74 */     addImplicitResolver(Tag.INT, INT, "-+0123456789");
/*  75 */     addImplicitResolver(Tag.FLOAT, FLOAT, "-+0123456789.");
/*  76 */     addImplicitResolver(Tag.MERGE, MERGE, "<");
/*  77 */     addImplicitResolver(Tag.NULL, NULL, "~nN\000");
/*  78 */     addImplicitResolver(Tag.NULL, EMPTY, null);
/*  79 */     addImplicitResolver(Tag.TIMESTAMP, TIMESTAMP, "0123456789");
/*  80 */     addImplicitResolver(Tag.VALUE, VALUE, "=");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     addImplicitResolver(Tag.YAML, YAML, "!&*");
/*     */   }
/*     */   
/*     */   public Resolver() {
/*  89 */     this(true);
/*     */   }
/*     */   
/*     */   public void addImplicitResolver(Tag tag, Pattern regexp, String first) {
/*  93 */     if (first == null) {
/*  94 */       List<ResolverTuple> curr = this.yamlImplicitResolvers.get(null);
/*  95 */       if (curr == null) {
/*  96 */         curr = new ArrayList<ResolverTuple>();
/*  97 */         this.yamlImplicitResolvers.put(null, curr);
/*     */       } 
/*  99 */       curr.add(new ResolverTuple(tag, regexp));
/*     */     } else {
/* 101 */       char[] chrs = first.toCharArray();
/* 102 */       for (int i = 0, j = chrs.length; i < j; i++) {
/* 103 */         Character theC = new Character(chrs[i]);
/* 104 */         if (theC.charValue() == '\000')
/*     */         {
/* 106 */           theC = null;
/*     */         }
/* 108 */         List<ResolverTuple> curr = this.yamlImplicitResolvers.get(theC);
/* 109 */         if (curr == null) {
/* 110 */           curr = new ArrayList<ResolverTuple>();
/* 111 */           this.yamlImplicitResolvers.put(theC, curr);
/*     */         } 
/* 113 */         curr.add(new ResolverTuple(tag, regexp));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public Tag resolve(NodeId kind, String value, boolean implicit) {
/* 119 */     if (kind == NodeId.scalar && implicit) {
/* 120 */       List<ResolverTuple> resolvers = null;
/* 121 */       if (value.length() == 0) {
/* 122 */         resolvers = this.yamlImplicitResolvers.get(Character.valueOf(false));
/*     */       } else {
/* 124 */         resolvers = this.yamlImplicitResolvers.get(Character.valueOf(value.charAt(0)));
/*     */       } 
/* 126 */       if (resolvers != null) {
/* 127 */         for (ResolverTuple v : resolvers) {
/* 128 */           Tag tag = v.getTag();
/* 129 */           Pattern regexp = v.getRegexp();
/* 130 */           if (regexp.matcher(value).matches()) {
/* 131 */             return tag;
/*     */           }
/*     */         } 
/*     */       }
/* 135 */       if (this.yamlImplicitResolvers.containsKey(null)) {
/* 136 */         for (ResolverTuple v : this.yamlImplicitResolvers.get(null)) {
/* 137 */           Tag tag = v.getTag();
/* 138 */           Pattern regexp = v.getRegexp();
/* 139 */           if (regexp.matcher(value).matches()) {
/* 140 */             return tag;
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/* 145 */     switch (kind) {
/*     */       case scalar:
/* 147 */         return Tag.STR;
/*     */       case sequence:
/* 149 */         return Tag.SEQ;
/*     */     } 
/* 151 */     return Tag.MAP;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\resolver\Resolver.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */