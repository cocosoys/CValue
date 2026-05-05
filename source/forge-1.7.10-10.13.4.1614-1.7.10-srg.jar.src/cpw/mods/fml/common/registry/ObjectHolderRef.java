/*     */ package cpw.mods.fml.common.registry;
/*     */ 
/*     */ import com.google.common.base.Throwables;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import org.apache.logging.log4j.Level;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ObjectHolderRef
/*     */ {
/*     */   private Field field;
/*     */   private String injectedObject;
/*     */   private boolean isBlock;
/*     */   private boolean isItem;
/*     */   private static Field modifiersField;
/*     */   private static Object reflectionFactory;
/*     */   private static Method newFieldAccessor;
/*     */   private static Method fieldAccessorSet;
/*     */   
/*     */   ObjectHolderRef(Field field, String injectedObject, boolean extractFromExistingValues) {
/*  30 */     this.field = field;
/*  31 */     this.isBlock = Block.class.isAssignableFrom(field.getType());
/*  32 */     this.isItem = Item.class.isAssignableFrom(field.getType());
/*  33 */     if (extractFromExistingValues) {
/*     */       
/*     */       try
/*     */       {
/*  37 */         Object existing = field.get(null);
/*     */         
/*  39 */         if (existing == null || existing == GameData.getBlockRegistry().getDefaultValue()) {
/*     */           
/*  41 */           this.injectedObject = null;
/*  42 */           this.field = null;
/*  43 */           this.isBlock = false;
/*  44 */           this.isItem = false;
/*     */           
/*     */           return;
/*     */         } 
/*     */         
/*  49 */         this
/*  50 */           .injectedObject = this.isBlock ? GameData.getBlockRegistry().getNameForObject(existing) : (this.isItem ? GameData.getItemRegistry().getNameForObject(existing) : null);
/*     */       }
/*  52 */       catch (Exception e)
/*     */       {
/*  54 */         throw Throwables.propagate(e);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  59 */       this.injectedObject = injectedObject;
/*     */     } 
/*     */     
/*  62 */     if (this.injectedObject == null || !isValid())
/*     */     {
/*  64 */       throw new IllegalStateException(String.format("The ObjectHolder annotation cannot apply to a field that is not an Item or Block (found : %s at %s.%s)", new Object[] { field.getType().getName(), field.getClass().getName(), field.getName() }));
/*     */     }
/*  66 */     makeWritable(field);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void makeWritable(Field f) {
/*     */     try {
/*  77 */       if (modifiersField == null) {
/*     */         
/*  79 */         Method getReflectionFactory = Class.forName("sun.reflect.ReflectionFactory").getDeclaredMethod("getReflectionFactory", new Class[0]);
/*  80 */         reflectionFactory = getReflectionFactory.invoke(null, new Object[0]);
/*  81 */         newFieldAccessor = Class.forName("sun.reflect.ReflectionFactory").getDeclaredMethod("newFieldAccessor", new Class[] { Field.class, boolean.class });
/*  82 */         fieldAccessorSet = Class.forName("sun.reflect.FieldAccessor").getDeclaredMethod("set", new Class[] { Object.class, Object.class });
/*  83 */         modifiersField = Field.class.getDeclaredField("modifiers");
/*  84 */         modifiersField.setAccessible(true);
/*     */       } 
/*  86 */       modifiersField.setInt(f, f.getModifiers() & 0xFFFFFFEF);
/*  87 */     } catch (Exception e) {
/*     */       
/*  89 */       throw Throwables.propagate(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isValid() {
/*  95 */     return (this.isBlock || this.isItem);
/*     */   }
/*     */   
/*     */   public void apply() {
/*     */     Object thing;
/* 100 */     if (this.isBlock) {
/*     */       
/* 102 */       thing = GameData.getBlockRegistry().getObject(this.injectedObject);
/* 103 */       if (thing == Blocks.air)
/*     */       {
/* 105 */         thing = null;
/*     */       }
/*     */     }
/* 108 */     else if (this.isItem) {
/*     */       
/* 110 */       thing = GameData.getItemRegistry().getObject(this.injectedObject);
/*     */     }
/*     */     else {
/*     */       
/* 114 */       thing = null;
/*     */     } 
/*     */     
/* 117 */     if (thing == null) {
/*     */       
/* 119 */       FMLLog.getLogger().log(Level.DEBUG, "Unable to lookup {} for {}. This means the object wasn't registered. It's likely just mod options.", new Object[] { this.injectedObject, this.field });
/*     */       
/*     */       return;
/*     */     } 
/*     */     try {
/* 124 */       Object fieldAccessor = newFieldAccessor.invoke(reflectionFactory, new Object[] { this.field, Boolean.valueOf(false) });
/* 125 */       fieldAccessorSet.invoke(fieldAccessor, new Object[] { null, thing });
/*     */     }
/* 127 */     catch (Exception e) {
/*     */       
/* 129 */       FMLLog.log(Level.WARN, e, "Unable to set %s with value %s (%s)", new Object[] { this.field, thing, this.injectedObject });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\registry\ObjectHolderRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */