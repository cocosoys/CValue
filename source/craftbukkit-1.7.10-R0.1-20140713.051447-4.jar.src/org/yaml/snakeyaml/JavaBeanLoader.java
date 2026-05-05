/*     */ package org.yaml.snakeyaml;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import org.yaml.snakeyaml.constructor.BaseConstructor;
/*     */ import org.yaml.snakeyaml.constructor.Constructor;
/*     */ import org.yaml.snakeyaml.introspector.BeanAccess;
/*     */ import org.yaml.snakeyaml.reader.UnicodeReader;
/*     */ import org.yaml.snakeyaml.representer.Representer;
/*     */ import org.yaml.snakeyaml.resolver.Resolver;
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
/*     */ public class JavaBeanLoader<T>
/*     */ {
/*     */   private Yaml loader;
/*     */   
/*     */   public JavaBeanLoader(TypeDescription typeDescription) {
/*  41 */     this(typeDescription, BeanAccess.DEFAULT);
/*     */   }
/*     */   
/*     */   public JavaBeanLoader(TypeDescription typeDescription, BeanAccess beanAccess) {
/*  45 */     this(new LoaderOptions(typeDescription), beanAccess);
/*     */   }
/*     */   
/*     */   public JavaBeanLoader(LoaderOptions options, BeanAccess beanAccess) {
/*  49 */     if (options == null) {
/*  50 */       throw new NullPointerException("LoaderOptions must be provided.");
/*     */     }
/*  52 */     if (options.getRootTypeDescription() == null) {
/*  53 */       throw new NullPointerException("TypeDescription must be provided.");
/*     */     }
/*  55 */     Constructor constructor = new Constructor(options.getRootTypeDescription());
/*  56 */     this.loader = new Yaml((BaseConstructor)constructor, options, new Representer(), new DumperOptions(), new Resolver());
/*     */     
/*  58 */     this.loader.setBeanAccess(beanAccess);
/*     */   }
/*     */   
/*     */   public <S extends T> JavaBeanLoader(Class<S> clazz, BeanAccess beanAccess) {
/*  62 */     this(new TypeDescription((Class)clazz), beanAccess);
/*     */   }
/*     */   
/*     */   public <S extends T> JavaBeanLoader(Class<S> clazz) {
/*  66 */     this(clazz, BeanAccess.DEFAULT);
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
/*     */   public T load(String yaml) {
/*  79 */     return (T)this.loader.load(new StringReader(yaml));
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
/*     */   public T load(InputStream io) {
/*  92 */     return (T)this.loader.load((Reader)new UnicodeReader(io));
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
/*     */   public T load(Reader io) {
/* 105 */     return (T)this.loader.load(io);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\JavaBeanLoader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */