/*     */ package org.yaml.snakeyaml;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
/*     */ import org.yaml.snakeyaml.composer.Composer;
/*     */ import org.yaml.snakeyaml.constructor.BaseConstructor;
/*     */ import org.yaml.snakeyaml.constructor.Constructor;
/*     */ import org.yaml.snakeyaml.emitter.Emitable;
/*     */ import org.yaml.snakeyaml.emitter.Emitter;
/*     */ import org.yaml.snakeyaml.error.YAMLException;
/*     */ import org.yaml.snakeyaml.events.Event;
/*     */ import org.yaml.snakeyaml.introspector.BeanAccess;
/*     */ import org.yaml.snakeyaml.nodes.Node;
/*     */ import org.yaml.snakeyaml.nodes.Tag;
/*     */ import org.yaml.snakeyaml.parser.Parser;
/*     */ import org.yaml.snakeyaml.parser.ParserImpl;
/*     */ import org.yaml.snakeyaml.reader.StreamReader;
/*     */ import org.yaml.snakeyaml.reader.UnicodeReader;
/*     */ import org.yaml.snakeyaml.representer.Representer;
/*     */ import org.yaml.snakeyaml.resolver.Resolver;
/*     */ import org.yaml.snakeyaml.serializer.Serializer;
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
/*     */ public class Yaml
/*     */ {
/*     */   protected final Resolver resolver;
/*     */   private String name;
/*     */   protected BaseConstructor constructor;
/*     */   protected Representer representer;
/*     */   protected DumperOptions dumperOptions;
/*     */   protected LoaderOptions loaderOptions;
/*     */   
/*     */   public Yaml() {
/*  65 */     this((BaseConstructor)new Constructor(), new LoaderOptions(), new Representer(), new DumperOptions(), new Resolver());
/*     */   }
/*     */ 
/*     */   
/*     */   public Yaml(LoaderOptions loaderOptions) {
/*  70 */     this((BaseConstructor)new Constructor(), loaderOptions, new Representer(), new DumperOptions(), new Resolver());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Yaml(DumperOptions dumperOptions) {
/*  81 */     this((BaseConstructor)new Constructor(), new Representer(), dumperOptions);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Yaml(Representer representer) {
/*  92 */     this((BaseConstructor)new Constructor(), representer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Yaml(BaseConstructor constructor) {
/* 103 */     this(constructor, new Representer());
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
/*     */   public Yaml(BaseConstructor constructor, Representer representer) {
/* 116 */     this(constructor, representer, new DumperOptions());
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
/*     */   public Yaml(Representer representer, DumperOptions dumperOptions) {
/* 129 */     this((BaseConstructor)new Constructor(), representer, dumperOptions, new Resolver());
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
/*     */   public Yaml(BaseConstructor constructor, Representer representer, DumperOptions dumperOptions) {
/* 144 */     this(constructor, representer, dumperOptions, new Resolver());
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
/*     */   public Yaml(BaseConstructor constructor, Representer representer, DumperOptions dumperOptions, Resolver resolver) {
/* 162 */     this(constructor, new LoaderOptions(), representer, dumperOptions, resolver);
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
/*     */   
/*     */   public Yaml(BaseConstructor constructor, LoaderOptions loaderOptions, Representer representer, DumperOptions dumperOptions, Resolver resolver) {
/* 182 */     if (!constructor.isExplicitPropertyUtils()) {
/* 183 */       constructor.setPropertyUtils(representer.getPropertyUtils());
/* 184 */     } else if (!representer.isExplicitPropertyUtils()) {
/* 185 */       representer.setPropertyUtils(constructor.getPropertyUtils());
/*     */     } 
/* 187 */     this.constructor = constructor;
/* 188 */     this.loaderOptions = loaderOptions;
/* 189 */     representer.setDefaultFlowStyle(dumperOptions.getDefaultFlowStyle());
/* 190 */     representer.setDefaultScalarStyle(dumperOptions.getDefaultScalarStyle());
/* 191 */     representer.getPropertyUtils().setAllowReadOnlyProperties(dumperOptions.isAllowReadOnlyProperties());
/*     */     
/* 193 */     this.representer = representer;
/* 194 */     this.dumperOptions = dumperOptions;
/* 195 */     this.resolver = resolver;
/* 196 */     this.name = "Yaml:" + System.identityHashCode(this);
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
/* 207 */     List<Object> list = new ArrayList(1);
/* 208 */     list.add(data);
/* 209 */     return dumpAll(list.iterator());
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
/*     */   public Node represent(Object data) {
/* 221 */     return this.representer.represent(data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String dumpAll(Iterator<? extends Object> data) {
/* 232 */     StringWriter buffer = new StringWriter();
/* 233 */     dumpAll(data, buffer);
/* 234 */     return buffer.toString();
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
/* 246 */     List<Object> list = new ArrayList(1);
/* 247 */     list.add(data);
/* 248 */     dumpAll(list.iterator(), output);
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
/*     */   public void dumpAll(Iterator<? extends Object> data, Writer output) {
/* 261 */     dumpAll(data, output, this.dumperOptions.getExplicitRoot());
/*     */   }
/*     */   
/*     */   private void dumpAll(Iterator<? extends Object> data, Writer output, Tag rootTag) {
/* 265 */     Serializer serializer = new Serializer((Emitable)new Emitter(output, this.dumperOptions), this.resolver, this.dumperOptions, rootTag);
/*     */     
/*     */     try {
/* 268 */       serializer.open();
/* 269 */       while (data.hasNext()) {
/* 270 */         Node node = this.representer.represent(data.next());
/* 271 */         serializer.serialize(node);
/*     */       } 
/* 273 */       serializer.close();
/* 274 */     } catch (IOException e) {
/* 275 */       throw new YAMLException(e);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public String dumpAs(Object data, Tag rootTag, DumperOptions.FlowStyle flowStyle) {
/* 320 */     DumperOptions.FlowStyle oldStyle = this.representer.getDefaultFlowStyle();
/* 321 */     if (flowStyle != null) {
/* 322 */       this.representer.setDefaultFlowStyle(flowStyle);
/*     */     }
/* 324 */     List<Object> list = new ArrayList(1);
/* 325 */     list.add(data);
/* 326 */     StringWriter buffer = new StringWriter();
/* 327 */     dumpAll(list.iterator(), buffer, rootTag);
/* 328 */     this.representer.setDefaultFlowStyle(oldStyle);
/* 329 */     return buffer.toString();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String dumpAsMap(Object data) {
/* 352 */     return dumpAs(data, Tag.MAP, DumperOptions.FlowStyle.BLOCK);
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
/*     */   public List<Event> serialize(Node data) {
/* 364 */     SilentEmitter emitter = new SilentEmitter();
/*     */     
/* 366 */     Serializer serializer = new Serializer(emitter, this.resolver, this.dumperOptions, this.dumperOptions.getExplicitRoot());
/*     */     
/*     */     try {
/* 369 */       serializer.open();
/* 370 */       serializer.serialize(data);
/* 371 */       serializer.close();
/* 372 */     } catch (IOException e) {
/* 373 */       throw new YAMLException(e);
/*     */     } 
/* 375 */     return emitter.getEvents();
/*     */   }
/*     */   
/*     */   private class SilentEmitter implements Emitable {
/* 379 */     private List<Event> events = new ArrayList<Event>(100);
/*     */     
/*     */     public List<Event> getEvents() {
/* 382 */       return this.events;
/*     */     }
/*     */     
/*     */     public void emit(Event event) throws IOException {
/* 386 */       this.events.add(event);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private SilentEmitter() {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object load(String yaml) {
/* 399 */     return loadFromReader(new StreamReader(yaml), Object.class);
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
/*     */   public Object load(InputStream io) {
/* 411 */     return loadFromReader(new StreamReader((Reader)new UnicodeReader(io)), Object.class);
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
/*     */   public Object load(Reader io) {
/* 423 */     return loadFromReader(new StreamReader(io), Object.class);
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
/*     */   public <T> T loadAs(Reader io, Class<T> type) {
/* 440 */     return (T)loadFromReader(new StreamReader(io), type);
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
/*     */   public <T> T loadAs(String yaml, Class<T> type) {
/* 457 */     return (T)loadFromReader(new StreamReader(yaml), type);
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
/*     */   public <T> T loadAs(InputStream input, Class<T> type) {
/* 474 */     return (T)loadFromReader(new StreamReader((Reader)new UnicodeReader(input)), type);
/*     */   }
/*     */   
/*     */   private Object loadFromReader(StreamReader sreader, Class<?> type) {
/* 478 */     Composer composer = new Composer((Parser)new ParserImpl(sreader), this.resolver);
/* 479 */     this.constructor.setComposer(composer);
/* 480 */     return this.constructor.getSingleData(type);
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
/*     */   public Iterable<Object> loadAll(Reader yaml) {
/* 493 */     Composer composer = new Composer((Parser)new ParserImpl(new StreamReader(yaml)), this.resolver);
/* 494 */     this.constructor.setComposer(composer);
/* 495 */     Iterator<Object> result = new Iterator() {
/*     */         public boolean hasNext() {
/* 497 */           return Yaml.this.constructor.checkData();
/*     */         }
/*     */         
/*     */         public Object next() {
/* 501 */           return Yaml.this.constructor.getData();
/*     */         }
/*     */         
/*     */         public void remove() {
/* 505 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/* 508 */     return new YamlIterable(result);
/*     */   }
/*     */   
/*     */   private class YamlIterable implements Iterable<Object> {
/*     */     private Iterator<Object> iterator;
/*     */     
/*     */     public YamlIterable(Iterator<Object> iterator) {
/* 515 */       this.iterator = iterator;
/*     */     }
/*     */     
/*     */     public Iterator<Object> iterator() {
/* 519 */       return this.iterator;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterable<Object> loadAll(String yaml) {
/* 535 */     return loadAll(new StringReader(yaml));
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
/*     */   public Iterable<Object> loadAll(InputStream yaml) {
/* 548 */     return loadAll((Reader)new UnicodeReader(yaml));
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
/*     */   public Node compose(Reader yaml) {
/* 561 */     Composer composer = new Composer((Parser)new ParserImpl(new StreamReader(yaml)), this.resolver);
/* 562 */     this.constructor.setComposer(composer);
/* 563 */     return composer.getSingleNode();
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
/*     */   public Iterable<Node> composeAll(Reader yaml) {
/* 576 */     final Composer composer = new Composer((Parser)new ParserImpl(new StreamReader(yaml)), this.resolver);
/* 577 */     this.constructor.setComposer(composer);
/* 578 */     Iterator<Node> result = new Iterator<Node>() {
/*     */         public boolean hasNext() {
/* 580 */           return composer.checkNode();
/*     */         }
/*     */         
/*     */         public Node next() {
/* 584 */           return composer.getNode();
/*     */         }
/*     */         
/*     */         public void remove() {
/* 588 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/* 591 */     return new NodeIterable(result);
/*     */   }
/*     */   
/*     */   private class NodeIterable implements Iterable<Node> {
/*     */     private Iterator<Node> iterator;
/*     */     
/*     */     public NodeIterable(Iterator<Node> iterator) {
/* 598 */       this.iterator = iterator;
/*     */     }
/*     */     
/*     */     public Iterator<Node> iterator() {
/* 602 */       return this.iterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addImplicitResolver(String tag, Pattern regexp, String first) {
/* 621 */     addImplicitResolver(new Tag(tag), regexp, first);
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
/*     */   public void addImplicitResolver(Tag tag, Pattern regexp, String first) {
/* 637 */     this.resolver.addImplicitResolver(tag, regexp, first);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 642 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 653 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String name) {
/* 663 */     this.name = name;
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
/*     */   public Iterable<Event> parse(Reader yaml) {
/* 675 */     final ParserImpl parser = new ParserImpl(new StreamReader(yaml));
/* 676 */     Iterator<Event> result = new Iterator<Event>() {
/*     */         public boolean hasNext() {
/* 678 */           return (parser.peekEvent() != null);
/*     */         }
/*     */         
/*     */         public Event next() {
/* 682 */           return parser.getEvent();
/*     */         }
/*     */         
/*     */         public void remove() {
/* 686 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/* 689 */     return new EventIterable(result);
/*     */   }
/*     */   
/*     */   private class EventIterable implements Iterable<Event> {
/*     */     private Iterator<Event> iterator;
/*     */     
/*     */     public EventIterable(Iterator<Event> iterator) {
/* 696 */       this.iterator = iterator;
/*     */     }
/*     */     
/*     */     public Iterator<Event> iterator() {
/* 700 */       return this.iterator;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setBeanAccess(BeanAccess beanAccess) {
/* 705 */     this.constructor.getPropertyUtils().setBeanAccess(beanAccess);
/* 706 */     this.representer.getPropertyUtils().setBeanAccess(beanAccess);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Yaml(Loader loader) {
/* 714 */     this(loader, new Dumper(new DumperOptions()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Yaml(Loader loader, Dumper dumper) {
/* 721 */     this(loader, dumper, new Resolver());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Yaml(Loader loader, Dumper dumper, Resolver resolver) {
/* 728 */     this(loader.constructor, dumper.representer, dumper.options, resolver);
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
/*     */   public Yaml(Dumper dumper) {
/* 740 */     this((BaseConstructor)new Constructor(), dumper.representer, dumper.options);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\Yaml.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */