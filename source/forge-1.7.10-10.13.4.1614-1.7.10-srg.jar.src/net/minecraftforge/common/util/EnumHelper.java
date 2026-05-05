/*     */ package net.minecraftforge.common.util;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.BlockPressurePlate;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.enchantment.EnumEnchantmentType;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.entity.item.EntityPainting;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.EnumSkyBlock;
/*     */ import net.minecraft.world.gen.structure.StructureStrongholdPieces;
/*     */ import net.minecraftforge.classloading.FMLForgePlugin;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EnumHelper
/*     */ {
/*  35 */   private static Object reflectionFactory = null;
/*  36 */   private static Method newConstructorAccessor = null;
/*  37 */   private static Method newInstance = null;
/*  38 */   private static Method newFieldAccessor = null;
/*  39 */   private static Method fieldAccessorSet = null;
/*     */ 
/*     */   
/*     */   private static boolean isSetup = false;
/*     */   
/*  44 */   private static Class[][] commonTypes = new Class[][] { { EnumAction.class }, { ItemArmor.ArmorMaterial.class, int.class, int[].class, int.class }, { EntityPainting.EnumArt.class, String.class, int.class, int.class, int.class, int.class }, { EnumCreatureAttribute.class }, { EnumCreatureType.class, Class.class, int.class, Material.class, boolean.class, boolean.class }, { StructureStrongholdPieces.Stronghold.Door.class }, { EnumEnchantmentType.class }, { Entity.EnumEntitySize.class }, { BlockPressurePlate.Sensitivity.class }, { MovingObjectPosition.MovingObjectType.class }, { EnumSkyBlock.class, int.class }, { EntityPlayer.EnumStatus.class }, { Item.ToolMaterial.class, int.class, int.class, float.class, float.class, int.class }, { EnumRarity.class, EnumChatFormatting.class, String.class } };
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
/*     */   public static EnumAction addAction(String name) {
/*  64 */     return addEnum(EnumAction.class, name, new Object[0]);
/*     */   }
/*     */   
/*     */   public static ItemArmor.ArmorMaterial addArmorMaterial(String name, int durability, int[] reductionAmounts, int enchantability) {
/*  68 */     return addEnum(ItemArmor.ArmorMaterial.class, name, new Object[] { Integer.valueOf(durability), reductionAmounts, Integer.valueOf(enchantability) });
/*     */   }
/*     */   
/*     */   public static EntityPainting.EnumArt addArt(String name, String tile, int sizeX, int sizeY, int offsetX, int offsetY) {
/*  72 */     return addEnum(EntityPainting.EnumArt.class, name, new Object[] { tile, Integer.valueOf(sizeX), Integer.valueOf(sizeY), Integer.valueOf(offsetX), Integer.valueOf(offsetY) });
/*     */   }
/*     */   
/*     */   public static EnumCreatureAttribute addCreatureAttribute(String name) {
/*  76 */     return addEnum(EnumCreatureAttribute.class, name, new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public static EnumCreatureType addCreatureType(String name, Class typeClass, int maxNumber, Material material, boolean peaceful, boolean animal) {
/*  81 */     return addEnum(EnumCreatureType.class, name, new Object[] { typeClass, Integer.valueOf(maxNumber), material, Boolean.valueOf(peaceful), Boolean.valueOf(animal) });
/*     */   }
/*     */   
/*     */   public static StructureStrongholdPieces.Stronghold.Door addDoor(String name) {
/*  85 */     return addEnum(StructureStrongholdPieces.Stronghold.Door.class, name, new Object[0]);
/*     */   }
/*     */   
/*     */   public static EnumEnchantmentType addEnchantmentType(String name) {
/*  89 */     return addEnum(EnumEnchantmentType.class, name, new Object[0]);
/*     */   }
/*     */   
/*     */   public static Entity.EnumEntitySize addEntitySize(String name) {
/*  93 */     return addEnum(Entity.EnumEntitySize.class, name, new Object[0]);
/*     */   }
/*     */   
/*     */   public static BlockPressurePlate.Sensitivity addSensitivity(String name) {
/*  97 */     return addEnum(BlockPressurePlate.Sensitivity.class, name, new Object[0]);
/*     */   }
/*     */   
/*     */   public static MovingObjectPosition.MovingObjectType addMovingObjectType(String name) {
/* 101 */     return addEnum(MovingObjectPosition.MovingObjectType.class, name, new Object[0]);
/*     */   }
/*     */   
/*     */   public static EnumSkyBlock addSkyBlock(String name, int lightValue) {
/* 105 */     return addEnum(EnumSkyBlock.class, name, new Object[] { Integer.valueOf(lightValue) });
/*     */   }
/*     */   
/*     */   public static EntityPlayer.EnumStatus addStatus(String name) {
/* 109 */     return addEnum(EntityPlayer.EnumStatus.class, name, new Object[0]);
/*     */   }
/*     */   
/*     */   public static Item.ToolMaterial addToolMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
/* 113 */     return addEnum(Item.ToolMaterial.class, name, new Object[] { Integer.valueOf(harvestLevel), Integer.valueOf(maxUses), Float.valueOf(efficiency), Float.valueOf(damage), Integer.valueOf(enchantability) });
/*     */   }
/*     */   
/*     */   public static EnumRarity addRarity(String name, EnumChatFormatting color, String displayName) {
/* 117 */     return addEnum(EnumRarity.class, name, new Object[] { color, displayName });
/*     */   }
/*     */ 
/*     */   
/*     */   private static void setup() {
/* 122 */     if (isSetup) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 129 */       Method getReflectionFactory = Class.forName("sun.reflect.ReflectionFactory").getDeclaredMethod("getReflectionFactory", new Class[0]);
/* 130 */       reflectionFactory = getReflectionFactory.invoke(null, new Object[0]);
/* 131 */       newConstructorAccessor = Class.forName("sun.reflect.ReflectionFactory").getDeclaredMethod("newConstructorAccessor", new Class[] { Constructor.class });
/* 132 */       newInstance = Class.forName("sun.reflect.ConstructorAccessor").getDeclaredMethod("newInstance", new Class[] { Object[].class });
/* 133 */       newFieldAccessor = Class.forName("sun.reflect.ReflectionFactory").getDeclaredMethod("newFieldAccessor", new Class[] { Field.class, boolean.class });
/* 134 */       fieldAccessorSet = Class.forName("sun.reflect.FieldAccessor").getDeclaredMethod("set", new Class[] { Object.class, Object.class });
/*     */     }
/* 136 */     catch (Exception e) {
/*     */       
/* 138 */       e.printStackTrace();
/*     */     } 
/*     */     
/* 141 */     isSetup = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object getConstructorAccessor(Class<?> enumClass, Class<?>[] additionalParameterTypes) throws Exception {
/* 151 */     Class<?>[] parameterTypes = new Class[additionalParameterTypes.length + 2];
/* 152 */     parameterTypes[0] = String.class;
/* 153 */     parameterTypes[1] = int.class;
/* 154 */     System.arraycopy(additionalParameterTypes, 0, parameterTypes, 2, additionalParameterTypes.length);
/* 155 */     return newConstructorAccessor.invoke(reflectionFactory, new Object[] { enumClass.getDeclaredConstructor(parameterTypes) });
/*     */   }
/*     */ 
/*     */   
/*     */   private static <T extends Enum<?>> T makeEnum(Class<T> enumClass, String value, int ordinal, Class<?>[] additionalTypes, Object[] additionalValues) throws Exception {
/* 160 */     Object[] parms = new Object[additionalValues.length + 2];
/* 161 */     parms[0] = value;
/* 162 */     parms[1] = Integer.valueOf(ordinal);
/* 163 */     System.arraycopy(additionalValues, 0, parms, 2, additionalValues.length);
/* 164 */     return enumClass.cast(newInstance.invoke(getConstructorAccessor(enumClass, additionalTypes), new Object[] { parms }));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setFailsafeFieldValue(Field field, Object target, Object value) throws Exception {
/* 169 */     field.setAccessible(true);
/* 170 */     Field modifiersField = Field.class.getDeclaredField("modifiers");
/* 171 */     modifiersField.setAccessible(true);
/* 172 */     modifiersField.setInt(field, field.getModifiers() & 0xFFFFFFEF);
/* 173 */     Object fieldAccessor = newFieldAccessor.invoke(reflectionFactory, new Object[] { field, Boolean.valueOf(false) });
/* 174 */     fieldAccessorSet.invoke(fieldAccessor, new Object[] { target, value });
/*     */   }
/*     */ 
/*     */   
/*     */   private static void blankField(Class<?> enumClass, String fieldName) throws Exception {
/* 179 */     for (Field field : Class.class.getDeclaredFields()) {
/*     */       
/* 181 */       if (field.getName().contains(fieldName)) {
/*     */         
/* 183 */         field.setAccessible(true);
/* 184 */         setFailsafeFieldValue(field, enumClass, null);
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void cleanEnumCache(Class<?> enumClass) throws Exception {
/* 192 */     blankField(enumClass, "enumConstantDirectory");
/* 193 */     blankField(enumClass, "enumConstants");
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T extends Enum<?>> T addEnum(Class<T> enumType, String enumName, Object... paramValues) {
/* 198 */     setup();
/* 199 */     return addEnum(commonTypes, enumType, enumName, paramValues);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Enum<?>> T addEnum(Class[][] map, Class<T> enumType, String enumName, Object... paramValues) {
/* 205 */     for (Class[] lookup : map) {
/*     */       
/* 207 */       if (lookup[0] == enumType) {
/*     */         
/* 209 */         Class<?>[] paramTypes = new Class[lookup.length - 1];
/* 210 */         if (paramTypes.length > 0)
/*     */         {
/* 212 */           System.arraycopy(lookup, 1, paramTypes, 0, paramTypes.length);
/*     */         }
/* 214 */         return addEnum(enumType, enumName, paramTypes, paramValues);
/*     */       } 
/*     */     } 
/* 217 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Enum<?>> T addEnum(Class<T> enumType, String enumName, Class<?>[] paramTypes, Object[] paramValues) {
/* 223 */     if (!isSetup)
/*     */     {
/* 225 */       setup();
/*     */     }
/*     */     
/* 228 */     Field valuesField = null;
/* 229 */     Field[] fields = enumType.getDeclaredFields();
/*     */     
/* 231 */     for (Field field : fields) {
/*     */       
/* 233 */       String name = field.getName();
/* 234 */       if (name.equals("$VALUES") || name.equals("ENUM$VALUES")) {
/*     */         
/* 236 */         valuesField = field;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 241 */     int flags = (FMLForgePlugin.RUNTIME_DEOBF ? 1 : 2) | 0x8 | 0x10 | 0x1000;
/* 242 */     if (valuesField == null) {
/*     */       
/* 244 */       String valueType = String.format("[L%s;", new Object[] { enumType.getName().replace('.', '/') });
/*     */       
/* 246 */       for (Field field : fields) {
/*     */         
/* 248 */         if ((field.getModifiers() & flags) == flags && field
/* 249 */           .getType().getName().replace('.', '/').equals(valueType)) {
/*     */           
/* 251 */           valuesField = field;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 257 */     if (valuesField == null) {
/*     */       
/* 259 */       FMLLog.severe("Could not find $VALUES field for enum: %s", new Object[] { enumType.getName() });
/* 260 */       FMLLog.severe("Runtime Deobf: %s", new Object[] { Boolean.valueOf(FMLForgePlugin.RUNTIME_DEOBF) });
/* 261 */       FMLLog.severe("Flags: %s", new Object[] { String.format("%16s", new Object[] { Integer.toBinaryString(flags) }).replace(' ', '0') });
/* 262 */       FMLLog.severe("Fields:", new Object[0]);
/* 263 */       for (Field field : fields) {
/*     */         
/* 265 */         String mods = String.format("%16s", new Object[] { Integer.toBinaryString(field.getModifiers()) }).replace(' ', '0');
/* 266 */         FMLLog.severe("       %s %s: %s", new Object[] { mods, field.getName(), field.getType().getName() });
/*     */       } 
/* 268 */       return null;
/*     */     } 
/*     */     
/* 271 */     valuesField.setAccessible(true);
/*     */ 
/*     */     
/*     */     try {
/* 275 */       Enum[] arrayOfEnum = (Enum[])valuesField.get(enumType);
/* 276 */       List<T> values = new ArrayList<T>(Arrays.asList((T[])arrayOfEnum));
/* 277 */       T newValue = makeEnum(enumType, enumName, values.size(), paramTypes, paramValues);
/* 278 */       values.add(newValue);
/* 279 */       setFailsafeFieldValue(valuesField, null, values.toArray((Enum[])Array.newInstance(enumType, 0)));
/* 280 */       cleanEnumCache(enumType);
/*     */       
/* 282 */       return newValue;
/*     */     }
/* 284 */     catch (Exception e) {
/*     */       
/* 286 */       e.printStackTrace();
/* 287 */       throw new RuntimeException(e.getMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static {
/* 293 */     if (!isSetup)
/*     */     {
/* 295 */       setup();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\commo\\util\EnumHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */