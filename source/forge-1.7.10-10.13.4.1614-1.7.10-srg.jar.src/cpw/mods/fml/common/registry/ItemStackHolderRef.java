/*    */ package cpw.mods.fml.common.registry;
/*    */ 
/*    */ import com.google.common.base.Throwables;
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import java.lang.reflect.Field;
/*    */ import java.lang.reflect.Method;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ItemStackHolderRef
/*    */ {
/*    */   private Field field;
/*    */   private String itemName;
/*    */   private int meta;
/*    */   private String serializednbt;
/*    */   private static Field modifiersField;
/*    */   private static Object reflectionFactory;
/*    */   private static Method newFieldAccessor;
/*    */   private static Method fieldAccessorSet;
/*    */   
/*    */   ItemStackHolderRef(Field field, String itemName, int meta, String serializednbt) {
/* 32 */     this.field = field;
/* 33 */     this.itemName = itemName;
/* 34 */     this.meta = meta;
/* 35 */     this.serializednbt = serializednbt;
/* 36 */     makeWritable(field);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static void makeWritable(Field f) {
/*    */     try {
/* 47 */       if (modifiersField == null) {
/*    */         
/* 49 */         Method getReflectionFactory = Class.forName("sun.reflect.ReflectionFactory").getDeclaredMethod("getReflectionFactory", new Class[0]);
/* 50 */         reflectionFactory = getReflectionFactory.invoke(null, new Object[0]);
/* 51 */         newFieldAccessor = Class.forName("sun.reflect.ReflectionFactory").getDeclaredMethod("newFieldAccessor", new Class[] { Field.class, boolean.class });
/* 52 */         fieldAccessorSet = Class.forName("sun.reflect.FieldAccessor").getDeclaredMethod("set", new Class[] { Object.class, Object.class });
/* 53 */         modifiersField = Field.class.getDeclaredField("modifiers");
/* 54 */         modifiersField.setAccessible(true);
/*    */       } 
/* 56 */       modifiersField.setInt(f, f.getModifiers() & 0xFFFFFFEF);
/* 57 */     } catch (Exception e) {
/*    */       
/* 59 */       throw Throwables.propagate(e);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void apply() {
/*    */     ItemStack is;
/*    */     try {
/* 68 */       is = GameRegistry.makeItemStack(this.itemName, this.meta, 1, this.serializednbt);
/* 69 */     } catch (RuntimeException e) {
/*    */       
/* 71 */       FMLLog.getLogger().log(Level.ERROR, "Caught exception processing itemstack {},{},{} in annotation at {}.{}", new Object[] { this.itemName, Integer.valueOf(this.meta), this.serializednbt, this.field.getClass().getName(), this.field.getName() });
/* 72 */       throw e;
/*    */     } 
/*    */     
/*    */     try {
/* 76 */       Object fieldAccessor = newFieldAccessor.invoke(reflectionFactory, new Object[] { this.field, Boolean.valueOf(false) });
/* 77 */       fieldAccessorSet.invoke(fieldAccessor, new Object[] { null, is });
/*    */     }
/* 79 */     catch (Exception e) {
/*    */       
/* 81 */       FMLLog.getLogger().log(Level.WARN, "Unable to set {} with value {},{},{}", new Object[] { this.field, this.itemName, Integer.valueOf(this.meta), this.serializednbt });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\registry\ItemStackHolderRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */