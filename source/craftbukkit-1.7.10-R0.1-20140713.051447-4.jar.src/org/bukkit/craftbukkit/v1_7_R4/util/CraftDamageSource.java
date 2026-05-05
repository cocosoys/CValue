/*    */ package org.bukkit.craftbukkit.v1_7_R4.util;
/*    */ 
/*    */ import net.minecraft.server.v1_7_R4.DamageSource;
/*    */ 
/*    */ public final class CraftDamageSource
/*    */   extends DamageSource {
/*    */   public static DamageSource copyOf(DamageSource original) {
/*  8 */     CraftDamageSource newSource = new CraftDamageSource(original.translationIndex);
/*    */ 
/*    */     
/* 11 */     if (original.ignoresArmor()) {
/* 12 */       newSource.setIgnoreArmor();
/*    */     }
/*    */ 
/*    */     
/* 16 */     if (original.isMagic()) {
/* 17 */       newSource.setMagic();
/*    */     }
/*    */ 
/*    */     
/* 21 */     if (original.isExplosion()) {
/* 22 */       newSource.setExplosion();
/*    */     }
/*    */     
/* 25 */     return newSource;
/*    */   }
/*    */   
/*    */   private CraftDamageSource(String identifier) {
/* 29 */     super(identifier);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R\\util\CraftDamageSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */