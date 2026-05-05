/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.UUID;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class GenericAttributes
/*    */ {
/* 11 */   private static final Logger f = LogManager.getLogger();
/* 12 */   public static final IAttribute maxHealth = (new AttributeRanged("generic.maxHealth", 20.0D, 0.0D, Double.MAX_VALUE)).a("Max Health").a(true);
/* 13 */   public static final IAttribute b = (new AttributeRanged("generic.followRange", 32.0D, 0.0D, 2048.0D)).a("Follow Range");
/* 14 */   public static final IAttribute c = (new AttributeRanged("generic.knockbackResistance", 0.0D, 0.0D, 1.0D)).a("Knockback Resistance");
/* 15 */   public static final IAttribute d = (new AttributeRanged("generic.movementSpeed", 0.699999988079071D, 0.0D, Double.MAX_VALUE)).a("Movement Speed").a(true);
/* 16 */   public static final IAttribute e = new AttributeRanged("generic.attackDamage", 2.0D, 0.0D, Double.MAX_VALUE);
/*    */   
/*    */   public static NBTTagList a(AttributeMapBase paramAttributeMapBase) {
/* 19 */     NBTTagList nBTTagList = new NBTTagList();
/*    */     
/* 21 */     for (AttributeInstance attributeInstance : paramAttributeMapBase.a()) {
/* 22 */       nBTTagList.add(a(attributeInstance));
/*    */     }
/*    */     
/* 25 */     return nBTTagList;
/*    */   }
/*    */   
/*    */   private static NBTTagCompound a(AttributeInstance paramAttributeInstance) {
/* 29 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 30 */     IAttribute iAttribute = paramAttributeInstance.getAttribute();
/*    */     
/* 32 */     nBTTagCompound.setString("Name", iAttribute.getName());
/* 33 */     nBTTagCompound.setDouble("Base", paramAttributeInstance.b());
/*    */     
/* 35 */     Collection collection = paramAttributeInstance.c();
/*    */     
/* 37 */     if (collection != null && !collection.isEmpty()) {
/* 38 */       NBTTagList nBTTagList = new NBTTagList();
/*    */       
/* 40 */       for (AttributeModifier attributeModifier : collection) {
/* 41 */         if (attributeModifier.e()) {
/* 42 */           nBTTagList.add(a(attributeModifier));
/*    */         }
/*    */       } 
/*    */       
/* 46 */       nBTTagCompound.set("Modifiers", nBTTagList);
/*    */     } 
/*    */     
/* 49 */     return nBTTagCompound;
/*    */   }
/*    */   
/*    */   private static NBTTagCompound a(AttributeModifier paramAttributeModifier) {
/* 53 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*    */     
/* 55 */     nBTTagCompound.setString("Name", paramAttributeModifier.b());
/* 56 */     nBTTagCompound.setDouble("Amount", paramAttributeModifier.d());
/* 57 */     nBTTagCompound.setInt("Operation", paramAttributeModifier.c());
/* 58 */     nBTTagCompound.setLong("UUIDMost", paramAttributeModifier.a().getMostSignificantBits());
/* 59 */     nBTTagCompound.setLong("UUIDLeast", paramAttributeModifier.a().getLeastSignificantBits());
/*    */     
/* 61 */     return nBTTagCompound;
/*    */   }
/*    */   
/*    */   public static void a(AttributeMapBase paramAttributeMapBase, NBTTagList paramNBTTagList) {
/* 65 */     for (byte b = 0; b < paramNBTTagList.size(); b++) {
/* 66 */       NBTTagCompound nBTTagCompound = paramNBTTagList.get(b);
/* 67 */       AttributeInstance attributeInstance = paramAttributeMapBase.a(nBTTagCompound.getString("Name"));
/*    */       
/* 69 */       if (attributeInstance != null) {
/* 70 */         a(attributeInstance, nBTTagCompound);
/*    */       } else {
/* 72 */         f.warn("Ignoring unknown attribute '" + nBTTagCompound.getString("Name") + "'");
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private static void a(AttributeInstance paramAttributeInstance, NBTTagCompound paramNBTTagCompound) {
/* 78 */     paramAttributeInstance.setValue(paramNBTTagCompound.getDouble("Base"));
/*    */     
/* 80 */     if (paramNBTTagCompound.hasKeyOfType("Modifiers", 9)) {
/* 81 */       NBTTagList nBTTagList = paramNBTTagCompound.getList("Modifiers", 10);
/*    */       
/* 83 */       for (byte b = 0; b < nBTTagList.size(); b++) {
/* 84 */         AttributeModifier attributeModifier1 = a(nBTTagList.get(b));
/* 85 */         AttributeModifier attributeModifier2 = paramAttributeInstance.a(attributeModifier1.a());
/* 86 */         if (attributeModifier2 != null) paramAttributeInstance.b(attributeModifier2); 
/* 87 */         paramAttributeInstance.a(attributeModifier1);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static AttributeModifier a(NBTTagCompound paramNBTTagCompound) {
/* 93 */     UUID uUID = new UUID(paramNBTTagCompound.getLong("UUIDMost"), paramNBTTagCompound.getLong("UUIDLeast"));
/* 94 */     return new AttributeModifier(uUID, paramNBTTagCompound.getString("Name"), paramNBTTagCompound.getDouble("Amount"), paramNBTTagCompound.getInt("Operation"));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\GenericAttributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */