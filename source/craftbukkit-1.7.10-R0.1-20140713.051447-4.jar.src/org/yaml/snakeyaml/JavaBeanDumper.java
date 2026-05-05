/*     */ package org.yaml.snakeyaml;
/*     */ 
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import org.yaml.snakeyaml.introspector.BeanAccess;
/*     */ import org.yaml.snakeyaml.nodes.Tag;
/*     */ import org.yaml.snakeyaml.representer.Representer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JavaBeanDumper
/*     */ {
/*     */   private boolean useGlobalTag;
/*     */   private DumperOptions.FlowStyle flowStyle;
/*     */   private DumperOptions options;
/*     */   private Representer representer;
/*     */   private final BeanAccess beanAccess;
/*     */   
/*     */   public JavaBeanDumper(boolean useGlobalTag, BeanAccess beanAccess) {
/*  46 */     this.useGlobalTag = useGlobalTag;
/*  47 */     this.beanAccess = beanAccess;
/*  48 */     this.flowStyle = DumperOptions.FlowStyle.BLOCK;
/*     */   }
/*     */   
/*     */   public JavaBeanDumper(boolean useGlobalTag) {
/*  52 */     this(useGlobalTag, BeanAccess.DEFAULT);
/*     */   }
/*     */   
/*     */   public JavaBeanDumper(BeanAccess beanAccess) {
/*  56 */     this(false, beanAccess);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JavaBeanDumper() {
/*  63 */     this(BeanAccess.DEFAULT);
/*     */   }
/*     */   
/*     */   public JavaBeanDumper(Representer representer, DumperOptions options) {
/*  67 */     if (representer == null) {
/*  68 */       throw new NullPointerException("Representer must be provided.");
/*     */     }
/*  70 */     if (options == null) {
/*  71 */       throw new NullPointerException("DumperOptions must be provided.");
/*     */     }
/*  73 */     this.options = options;
/*  74 */     this.representer = representer;
/*  75 */     this.beanAccess = null;
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
/*     */   public void dump(Object data, Writer output) {
/*     */     DumperOptions doptions;
/*     */     Representer repr;
/*  89 */     if (this.options == null) {
/*  90 */       doptions = new DumperOptions();
/*  91 */       if (!this.useGlobalTag) {
/*  92 */         doptions.setExplicitRoot(Tag.MAP);
/*     */       }
/*  94 */       doptions.setDefaultFlowStyle(this.flowStyle);
/*     */     } else {
/*  96 */       doptions = this.options;
/*     */     } 
/*     */     
/*  99 */     if (this.representer == null) {
/* 100 */       repr = new Representer();
/* 101 */       repr.getPropertyUtils().setBeanAccess(this.beanAccess);
/*     */     } else {
/* 103 */       repr = this.representer;
/*     */     } 
/* 105 */     Yaml dumper = new Yaml(repr, doptions);
/* 106 */     dumper.dump(data, output);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String dump(Object data) {
/* 117 */     StringWriter buffer = new StringWriter();
/* 118 */     dump(data, buffer);
/* 119 */     return buffer.toString();
/*     */   }
/*     */   
/*     */   public boolean isUseGlobalTag() {
/* 123 */     return this.useGlobalTag;
/*     */   }
/*     */   
/*     */   public void setUseGlobalTag(boolean useGlobalTag) {
/* 127 */     this.useGlobalTag = useGlobalTag;
/*     */   }
/*     */   
/*     */   public DumperOptions.FlowStyle getFlowStyle() {
/* 131 */     return this.flowStyle;
/*     */   }
/*     */   
/*     */   public void setFlowStyle(DumperOptions.FlowStyle flowStyle) {
/* 135 */     this.flowStyle = flowStyle;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\JavaBeanDumper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */